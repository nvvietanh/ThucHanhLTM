/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp.client.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import udp.client.controller.ClientControl;
import udp.client.model.Student;

/**
 *
 * @author admin
 */
public class SearchStudentByNameView extends JFrame implements ActionListener {
    
    private JTextField txtQuery;
    private JTable tableUserList;
    private DefaultTableModel dtmUserList;
    
    public SearchStudentByNameView() {
        super("Search Student");
        
        txtQuery = new JTextField(15);
        txtQuery.addActionListener(this);
        
        
        JPanel content = new JPanel(new FlowLayout());
        
        JLabel dangnhap = new JLabel("Tìm kiếm sinh viên theo họ tên: ");
        
        JPanel pDN = new JPanel();
        pDN.setLayout(new FlowLayout(FlowLayout.CENTER));
        pDN.add(dangnhap);
        content.add(pDN);
                
        content.add(txtQuery);
        
        dtmUserList = new DefaultTableModel(new Object[][][][][] {}, new String[] {"MSSV", "Họ tên", "Năm sinh", "Quê quán", "GPA"});
//        tableUserList.getColorModel().getColumn(0).setPreferedWidth(10)

        tableUserList = new JTable(dtmUserList);
        JScrollPane userListScrollPane = new JScrollPane(tableUserList);
        content.add(userListScrollPane);
        
        
        JLabel hoten = new JLabel("Họ tên: Nguyễn Viết Việt Anh.");
        JLabel msv = new JLabel("MSSV: B21DDCN156.");
        content.add(hoten);
        content.add(msv);
        
        this.add(content);
        this.setSize(600, 530);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(txtQuery)) {
            System.out.println("Searching User");
            ClientControl clCtr = new ClientControl();
            List<Student> svListRes = clCtr.searchStudentByName(txtQuery.getText());
            if (svListRes == null) {
                showMessage("An error occured");
            }
            else {
                dtmUserList.setRowCount(0);
                for (Student i : svListRes) {
                    dtmUserList.addRow(new Object[] {i.getMaSV(), i.getHoTen(), i.getNamSinh(), i.getQueQuan(), i.getGPA()});
                }
            }
                       
        }
    }
    
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
    
}
