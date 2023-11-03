import Interfaces.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 * @author Felix Dreiling
 * NetChat v1.5 Setup
 */

public class GUI extends javax.swing.JFrame implements IUpdateRequester {

    private IController c;
    private int error;
    private SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
    private ImageIcon image;

    public GUI() {
        initComponents();
        
        c = new Controller(this);
        
        image = new ImageIcon("icon.png");
        this.setIconImage(image.getImage());
        this.setTitle("NetChat 1.5");
        
        txt_group.setText(c.GetGroup());
        txt_port.setText(c.GetPort());
        user_list.setModel(c.GetUserList());
        ip_list.setModel(c.GetIPList());
    }
    
    public void Update(String s) {
        txt_output.append(time.format(new Date()) + " - " + s);
        this.toFront();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_send = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        btn_connect = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        txt_input = new javax.swing.JTextField();
        txt_group = new javax.swing.JTextField();
        txt_port = new javax.swing.JTextField();
        scr_txt = new javax.swing.JScrollPane();
        txt_output = new javax.swing.JTextArea();
        lbl_group = new javax.swing.JLabel();
        lbl_port = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        sld_time = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_list = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ip_list = new javax.swing.JList<>();
        lbl_ip = new javax.swing.JLabel();
        btn_scan = new javax.swing.JButton();
        lbl_user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_send.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_send.setText("Send");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        btn_refresh.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_connect.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_connect.setText("Connect");
        btn_connect.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_exit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        txt_input.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_group.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_port.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        scr_txt.setAutoscrolls(true);

        txt_output.setColumns(20);
        txt_output.setRows(5);
        scr_txt.setViewportView(txt_output);

        lbl_group.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_group.setText("Group : ---");

        lbl_port.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_port.setText("Port : ---");

        lbl_time.setText("Seconds : 1.0");

        sld_time.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        sld_time.setMinimum(1);
        sld_time.setValue(10);
        sld_time.setMaximumSize(new java.awt.Dimension(32767, 10));
        sld_time.setMinimumSize(new java.awt.Dimension(36, 10));
        sld_time.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld_timeStateChanged(evt);
            }
        });

        jScrollPane1.setViewportView(user_list);

        jScrollPane2.setViewportView(ip_list);

        lbl_ip.setText("IP-Addresses");

        btn_scan.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn_scan.setText("Scan");
        btn_scan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_scanActionPerformed(evt);
            }
        });

        lbl_user.setText("Connected Devices");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_send, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sld_time, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scr_txt)
                            .addComponent(txt_input)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_port)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_time)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(lbl_group)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_group, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_user, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_scan, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_connect)
                    .addComponent(lbl_user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_group, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_group)
                            .addComponent(btn_refresh)
                            .addComponent(lbl_time))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_port))
                            .addComponent(sld_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_input, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_send)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_ip)
                            .addComponent(btn_scan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exit))
                    .addComponent(scr_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
    if (c.IsConnected() == true) {
        c.Send(txt_input.getText());
        c.Refresh();
    }
}//GEN-LAST:event_btn_sendActionPerformed

private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
    if(c.IsConnected() == false)
    {
        error = c.SetConnection(txt_group.getText(), txt_port.getText());
        
        if (error == 1) txt_output.append(time.format(new Date())+" - Error "+error+" : Falsches Port Format \n");
        else if (error == 2) txt_output.append(time.format(new Date())+" - Error "+error+" : Falsches Group Format \n");
        else
        {
            error = c.Connect();
        
            if (error == 3) txt_output.append(time.format(new Date())+" - Error "+error+" : Multicast-Socket konnte nicht auf dem Port geöffnet werden \n");
            else if (error == 4) txt_output.append(time.format(new Date())+" - Error "+error+" : Keine Verbindung oder falsche Multicast-IP \n");
            else
            {
                lbl_group.setText("Group : " + c.GetGroup());
                lbl_port.setText("Port : " + c.GetPort());
                btn_connect.setText("Disconnect");
                c.Send("*** Connected ***");
                c.Refresh();
            }
        }
    }
    else
    {
        lbl_group.setText("Group : --- ");
        lbl_port.setText("Port : --- ");
        btn_connect.setText("Connect");
        
        c.Send("*** Disconnected ***");
        c.Refresh();
        c.Disconnect();
    }    
}//GEN-LAST:event_btn_connectActionPerformed

private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
    if (c.IsConnected() == true)
    {
        c.Send("*** Disconnected ***");
        c.Disconnect();
    }
    System.exit(0);    
}//GEN-LAST:event_btn_exitActionPerformed

private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
    c.Refresh();
}//GEN-LAST:event_btn_refreshActionPerformed

private void sld_timeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld_timeStateChanged
    lbl_time.setText( "Seconds : " + (double)sld_time.getValue()/10 );
    c.SetTimer( sld_time.getValue()*100 );
}//GEN-LAST:event_sld_timeStateChanged

private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
    txt_output.setText("");
}//GEN-LAST:event_btn_clearActionPerformed

    private void btn_scanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_scanActionPerformed
        c.Scan();
    }//GEN-LAST:event_btn_scanActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_scan;
    private javax.swing.JButton btn_send;
    private javax.swing.JList<String> ip_list;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_group;
    private javax.swing.JLabel lbl_ip;
    private javax.swing.JLabel lbl_port;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JScrollPane scr_txt;
    private javax.swing.JSlider sld_time;
    private javax.swing.JTextField txt_group;
    private javax.swing.JTextField txt_input;
    private javax.swing.JTextArea txt_output;
    private javax.swing.JTextField txt_port;
    private javax.swing.JList<String> user_list;
    // End of variables declaration//GEN-END:variables

}
