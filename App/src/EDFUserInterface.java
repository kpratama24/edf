
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * EDF User interface class
 * @author Kevin
 */
public class EDFUserInterface extends javax.swing.JFrame {

    EDFCore t;
    String tempInformation;
    
    /**
     * Creates new form EDFUserInterface
     */
    public EDFUserInterface() {
        initComponents();
        
        DefaultCaret caret = (DefaultCaret)jobInputTA.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollBar1 = new javax.swing.JScrollBar();
        startButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        awtText = new javax.swing.JLabel();
        attText = new javax.swing.JLabel();
        inputText = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        outputText = new javax.swing.JLabel();
        awtL = new javax.swing.JLabel();
        attL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        timeL = new javax.swing.JLabel();
        jobMissedText = new javax.swing.JLabel();
        missL = new javax.swing.JLabel();
        titleL = new javax.swing.JLabel();
        copyrightL = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        informationL = new javax.swing.JLabel();
        notesL = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        schedulingOutputTA = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jobInputTA = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Earliest Deadline First");

        startButton.setText("Start Scheduling");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startProgram(evt);
            }
        });

        jLabel1.setText("Elapsed Time:");

        awtText.setText("Average Waiting Time: ");

        attText.setText("Average Turnaround Time:");

        inputText.setText("Input:");

        jLabel5.setText("Information:");

        outputText.setText("Output:");

        awtL.setText("Not Available");

        attL.setText("Not Available");

        jLabel7.setText(" ");

        jobMissedText.setText("Job Missed:");

        titleL.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        titleL.setText("Earliest Deadline First Scheduling Simulator");

        copyrightL.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        copyrightL.setText("2018. Kevin Pratama ");

        informationL.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        informationL.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane4.setViewportView(informationL);

        schedulingOutputTA.setEditable(false);
        schedulingOutputTA.setColumns(20);
        schedulingOutputTA.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        schedulingOutputTA.setRows(5);
        jScrollPane5.setViewportView(schedulingOutputTA);

        jobInputTA.setColumns(20);
        jobInputTA.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jobInputTA.setRows(5);
        jobInputTA.setText("4\nJ1 0 2 3\nJ2 1 2 5\nJ3 2 2 6\nJ4 4 1 8");
        jScrollPane7.setViewportView(jobInputTA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(titleL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(outputText))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputText)
                                    .addComponent(startButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jobMissedText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(missL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(attText)
                                    .addComponent(awtText))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(awtL, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(attL, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(copyrightL))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(382, 382, 382)
                                .addComponent(notesL, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(171, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleL)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputText)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startButton)
                        .addGap(45, 45, 45))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(missL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputText)
                            .addComponent(jobMissedText)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notesL, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(awtText)
                    .addComponent(awtL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attText)
                    .addComponent(attL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyrightL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(410, 410, 410)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addGap(86, 86, 86)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Generated start button action performed
     * @param evt 
     */
    private void startProgram(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startProgram
          timeL.setText(String.valueOf(0));
          String userInput = jobInputTA.getText();
          String[] splittedUserInput = userInput.split("\n");
          int initialCapacity = Integer.parseInt(splittedUserInput[0]);
          t = new EDFCore(this, initialCapacity);
          
          //Add job to waiting queue
          String[] jobData;
          try{
            for (int i = 0; i < initialCapacity; i++) {
              jobData = splittedUserInput[i+1].split(" ");
              t.addNewJob(jobData[0], Integer.parseInt(jobData[1]), Integer.parseInt(jobData[2]), Integer.parseInt(jobData[3]));
              }
          }
          catch(IndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(this, "Make sure that the array sizes match the total job input \n"
                      + "Expected job total is : "+ splittedUserInput[0],"Oops !",JOptionPane.ERROR_MESSAGE);
          }
          catch(NumberFormatException e2){
              JOptionPane.showMessageDialog(this, "Make sure that your input is correct \n"
                      + "Expected job data per input is is : [JobName] [Arrival Time] [Burst Time] [Deadline]","Oops !",JOptionPane.ERROR_MESSAGE);
          }
          catch(NullPointerException e3){
              JOptionPane.showMessageDialog(this, "Make sure that your input is correct \n"
                      + "Required job data per input is is : [JobName] [Arrival Time] [Burst Time] [Deadline]","Oops !",JOptionPane.ERROR_MESSAGE);
          }
          setName();
          setNote();
          t.start();
          
    }//GEN-LAST:event_startProgram

    /**
     * Method to set job name
     */
    public void setName() {
        Job[] jobInstance = t.getJob();
        String jobName = "";
        jobName += "<html>";
        for (int i = 0; i < jobInstance.length; i++) {
            jobName += "<h3>"+jobInstance[i].getJobName() + " --> " + String.format("%3d",i+1) + "</h3><br>";
        }
        this.tempInformation = jobName;
        
        informationL.setText(jobName);
    }
    
    /**
     * Show missed job on the user interface
     * @param missedJob the missed job
     */
    public void setMissedJobOnInformation(Job[] missedJob){
        String a = this.tempInformation;
        String b = "<h3> Missed Job : <br>";
        for (Job missedJob1 : missedJob) {
            if(missedJob1==null) break;
            b = b +  missedJob1.getJobName() + ", ";
        }
        b = b + "</h3>";
            String combined = a + b;
            informationL.setText(combined);
        }
    
    /**
     * Method to show the working job at scheduling text area
     * @param job [not available]
     */
    public void show(Job[] job) {
        String status = "";
        int totalJob = job.length-1;
        for (int i = 0; i < totalJob; i++) {
            status += String.format("%3d",i+1) + ": " + job[i].getStatus() + "\n";
        }
        status += String.format("%3d",totalJob+1) + ": " + job[totalJob].getStatus();
        
        schedulingOutputTA.setText(status);
    }
    
    /**
     * Method to show the elapsed time
     * @param time elapsed time
     */
    public void showTime(int time) {
        timeL.setText(String.valueOf(time));
    }
    
    /**
     * Method to show miss total at current scheduling
     * @param miss total scheduling miss
     */
    public void showTotalMiss(int miss){
        missL.setText(String.valueOf(miss));
    }
    
    /**
     * Method to show average waiting time and average turnaround time
     * @param awt average waiting time
     * @param att average turnaround time
     */
    public void finish(double awt, double att) {
        awtL.setText(String.format("%.4f",awt));
        attL.setText(String.format("%.4f",att));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EDFCore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EDFCore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EDFCore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EDFCore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EDFUserInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attL;
    private javax.swing.JLabel attText;
    private javax.swing.JLabel awtL;
    private javax.swing.JLabel awtText;
    private javax.swing.JLabel copyrightL;
    private javax.swing.JLabel informationL;
    private javax.swing.JLabel inputText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jobInputTA;
    private javax.swing.JLabel jobMissedText;
    private javax.swing.JLabel missL;
    private javax.swing.JLabel notesL;
    private javax.swing.JLabel outputText;
    private javax.swing.JTextArea schedulingOutputTA;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel timeL;
    private javax.swing.JLabel titleL;
    // End of variables declaration//GEN-END:variables

    /**
     * Set hint on scheduling output text area
     */
    private void setNote() {
        notesL.setText("<html>" +
        "    Info <br> O : On Work Queue <br>" +
        "    - : On Waiting Queue <br>" +
        "    I : CPU Idle <br>" +
        "    M / OM : Missed <br>" +
        "</html>");
    }

    /**
     * Method to show complete dialog when scheduling is done
     */
    void showCompleteDialog() {
        JOptionPane.showMessageDialog(this, "Scheduling completed","Info",JOptionPane.INFORMATION_MESSAGE);
    }
}
