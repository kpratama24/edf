
import java.util.Comparator;
import java.util.PriorityQueue;



/**
 * EDF Core Algorithm
 * @version 1.0
 * @author Kevin Pratama
 */
public class EDFCore extends Thread{
    
    private EDFUserInterface userInterface;
    
    PriorityQueue<Job> waitingQueue; //Priority Queue for waiting jobs
    PriorityQueue<Job> workQueue; //Priority Queue for jobs being done
    private Job[] jobArray; //Array of job by user input
   
    
    private int jobCounter; // counter for job
    private int initialCapacity; //Initial priority queue capacity
    private Job[] missedJob; // array to dump missed job
    private int missCounter; // counter for missedJob
    
    /**
     * Job Global Attributes
     */ 
    private int time; //Elapsed Time Total
    private int averageTurnAround; //Average Turn Around Time
    private int averageWaiting; //Average Waiting Time
    private final boolean isHardRealTime; //Is Scheduling Mode is Hard Real Time ?
    
    /**
     * EDF Core Class Constructor
     * @param userInterface EDF User Interface Object
     * @param initialCapacity  job capacity specified by user input
     * @param isHardRealTime is the current job is hard real time or not
     */
    public EDFCore(EDFUserInterface userInterface, int initialCapacity,
            boolean isHardRealTime){
        this.userInterface = userInterface;
        
        waitingQueue = new PriorityQueue<>(initialCapacity, new BurstTimeJobComparator());
        workQueue = new PriorityQueue(initialCapacity, new JobComparator());
        jobArray = new Job[initialCapacity];
        missedJob = new Job[initialCapacity];
        
        this.jobCounter = 0;
        this.initialCapacity = initialCapacity;
        this.isHardRealTime = isHardRealTime;
    }
    
    /**
     * Method for getting an array of job
     * @return array of job
     */
    public Job[] getJob() {
        return jobArray;
    }
    
    /**
     * Add new job, offer it to the waiting queue and array of job
     * @param jobName job name
     * @param arrivalTime job's arrival time
     * @param burstTime job's burst time
     * @param deadline job's deadline
     */
    public void addNewJob(String jobName, int arrivalTime, int burstTime, int deadline){
        Job newJob = new Job(jobCounter,jobName,arrivalTime,burstTime,deadline);
        waitingQueue.offer(newJob);
        jobArray[jobCounter] = newJob;
        jobCounter++;
    }
    
    /**
     * Method for running the program
     */
    @Override
    public void run(){
        
       //Check hard real time mode. Go to another method if is in 
       //hard real time mode
       if(isHardRealTime){
           runHardRealTime();
           return;
       }
        
        //Initialize required variables
        Job jobInstance;
        this.time = 0;
        this.missCounter = 0;
        this.averageTurnAround = 0;
        this.averageWaiting = 0;
        
        while(!workQueue.isEmpty() || !waitingQueue.isEmpty()){
            if(!waitingQueue.isEmpty()){
                while(!waitingQueue.isEmpty() && waitingQueue.peek().arrivalTime<=time){
                    workQueue.offer(waitingQueue.poll());
                }
            }
            
            jobInstance = workQueue.poll();
            if(jobInstance!=null){
                for(int i=0; i<initialCapacity; i++){
                    if(i == jobInstance.getJobID() && jobInstance.deadline <= time){      
                        jobArray[i].setStatus('M');
                        this.missedJob[missCounter] = jobInstance;
                        missCounter++;
                        jobInstance.setBurstTime(0);
 
                    } else if (i == jobInstance.getJobID()) {
                        jobArray[i].setStatus('O');
                    }
                    else{
                        jobArray[i].setStatus('-');
                    }
                }
                
                averageWaiting += workQueue.size();
                jobInstance.burstTime--;
                this.time++;
                
                if(jobInstance.burstTime>0){
                    workQueue.offer(jobInstance);
                }
                else if (jobInstance.getDeadline() >= this.time){ //Burst time <=0
                    averageTurnAround += (this.time - jobInstance.arrivalTime);
                }
            }
            else{
                for (int i = 0; i < initialCapacity; i++) {
                    jobArray[i].setStatus('I');
                }
                this.time++;
            }
            
            userInterface.show(jobArray);
            userInterface.showTime(time);
            userInterface.showTotalMiss(missCounter);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Interrupted");
            }
        }
        
        userInterface.finish(averageWaiting/(double) initialCapacity,averageTurnAround/(double)(initialCapacity - missCounter));
        userInterface.setMissedJobOnInformation(missedJob);
        userInterface.showCompleteDialog(false);
        
    }

    /**
     * Method for running the application in hard real time mode
     */
    private void runHardRealTime() {
        boolean redFlag = false;
        
        //Initialize required variables
        Job jobInstance;
        this.time = 0;
        this.missCounter = 0;
        this.averageTurnAround = 0;
        this.averageWaiting = 0;
        
        while(!workQueue.isEmpty() || !waitingQueue.isEmpty()){
            if(redFlag){
                break;
            }
            
            if(!waitingQueue.isEmpty()){
                while(!waitingQueue.isEmpty() && waitingQueue.peek().arrivalTime<=time){
                    workQueue.offer(waitingQueue.poll());
                }
            }
            
            jobInstance = workQueue.poll();
            if(jobInstance!=null){
                for(int i=0; i<initialCapacity; i++){
                    if(i == jobInstance.getJobID() && jobInstance.deadline <= time){  
                        if(isHardRealTime){
                            redFlag = true;
                            jobArray[i].setStatus('S');
                            break;
                        }
                        jobArray[i].setStatus('M');
                        this.missedJob[missCounter] = jobInstance;
                        missCounter++;
                        jobInstance.setBurstTime(0);
 
                    } else if (i == jobInstance.getJobID()) {
                        jobArray[i].setStatus('O');
                    }
                    else{
                        jobArray[i].setStatus('-');
                    }
                }
                
                averageWaiting += workQueue.size();
                jobInstance.burstTime--;
                this.time++;
                
                if(jobInstance.burstTime>0){
                    workQueue.offer(jobInstance);
                }
                else if (jobInstance.getDeadline() >= this.time){ //Burst time <=0
                    averageTurnAround += (this.time - jobInstance.arrivalTime);
                }
            }
            else{
                for (int i = 0; i < initialCapacity; i++) {
                    jobArray[i].setStatus('I');
                }
                this.time++;
            }
            
            userInterface.show(jobArray);
            userInterface.showTime(time);
            userInterface.showTotalMiss(missCounter);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Interrupted");
            }
        }
        
        userInterface.finish(averageWaiting/(double) initialCapacity,averageTurnAround/(double)(initialCapacity - missCounter));
        userInterface.setMissedJobOnInformation(missedJob);
        userInterface.showCompleteDialog(true);
    }
        
}

/**
 * Job Class 
 * @version 1.0
 * @author Kevin
 */
class Job{
    
    int jobID;
    String jobName;
    int arrivalTime;
    int burstTime;
    int deadline;
    String status;
    
    
    /**
     * Constructor for the job class
     * @param jobID id of the job
     * @param jobName job name
     * @param arrivalTime job arrival time
     * @param burstTime job burst time
     * @param deadline job deadline
     */
    public Job(int jobID, String jobName, int arrivalTime, int burstTime, int deadline){
        this.jobID = jobID;
        this.jobName = jobName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.deadline = deadline;
        this.status = new String();
    }

    /**
     * Method to set job burst time
     * @param burstTime job burst time
     */
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    /**
     * Method to get job deadline
     * @return job deadline
     */
    public int getDeadline() {
        return deadline;
    }

    /**
     * Method to get job status
     * @return job status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Method to get the jobname
     * @return job name
     */
    public String getJobName() {
        return jobName;
    }
    
    /**
     * Method to set the job status
     * @param status current job status
     */
    public void setStatus(char status) {
        this.status += status;
    }
    
    /**
     * Method to get job arrival time
     * @return arrival time of the job
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Method to get job burst time
     * @return job burst time
     */
    public int getBurstTime() {
        return burstTime;
    }
    
    /**
     * method to get the job id
     * @return job id
     */
    public int getJobID(){
        return this.jobID;
    }
    
    /**
     * method to get the job deadline
     * @return 
     */
    public int getJobDeadline(){
        return this.deadline;
    }
}

/**
 * Burst Time Comparator class
 * @version 1.0
 * @author Kevin
 */
class BurstTimeJobComparator implements Comparator<Job>{

    /**
     * Method to compare 2 different job
     * @param t1 the first job
     * @param t2 the other job
     * @return integer to sort the job
     */
    @Override
    public int compare(Job t1, Job t2) {
        if(t1.getArrivalTime() < t2.getArrivalTime()) {
            return -1;
        } else if(t1.getArrivalTime() > t2.getArrivalTime()) {
            return 1;
        } else {
            if(t1.getJobDeadline() < t2.getJobDeadline()){
                return -1;
            }
            else if(t1.getJobDeadline() > t2.getJobDeadline()){
                return 1;
            }
            else{
                if(t1.getBurstTime() < t2.getBurstTime()) {
                    return -1;
                } else if(t1.getBurstTime() > t2.getBurstTime()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
    
}

/**
 * Job Comparator Class
 * @author Kevin
 */
class JobComparator implements Comparator<Job>{

    /**
     * Method to compare 2 different job
     * @param t the first job
     * @param t1 the second job
     * @return integer to sort the job
     */
    @Override
    public int compare(Job t1, Job t2) {
        if(t1.getJobDeadline() < t2.getJobDeadline()){
            return -1;
        }
        else if (t1.getJobDeadline() > t2.getJobDeadline()){
            return 1;
        }
        else{
            if(t1.getBurstTime() < t2.getBurstTime()) {
                return -1;
            } else if(t1.getBurstTime() > t2.getBurstTime()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
}
