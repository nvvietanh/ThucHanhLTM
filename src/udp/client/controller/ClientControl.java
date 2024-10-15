/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp.client.controller;

/**
 *
 * @author admin
 */
//public class ClientControl {
//    
//}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import udp.client.model.Student;

public class ClientControl {
//    private ClientView view;
    private int serverPort = 5555;
    private int clientPort = 6666;
    private String serverHost = "localhost";
    private DatagramSocket myClient;
    
    public ClientControl() {
        
    }
    
//    public ClientControl(ClientView view){
//        this.view = view;
//        this.view.addLoginListener(new LoginListener());
//    }
    
    class LoginListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            openConnection();
            User user = view.getUser();
            sendData(user);
            String result = receiveData();
            if(result.equals("ok"))
                view.showMessage("Login succesfully!");
            else
                view.showMessage("Invalid username and/or password!");
            closeConnection();
        }
    }
    
    private void openConnection(){
        try {
            myClient = new DatagramSocket(clientPort);
        } catch (Exception ex) {
            view.showMessage(ex.getStackTrace().toString());
        }
    }
    private void closeConnection(){
        try {
            myClient.close();
        } catch (Exception ex) {
            view.showMessage(ex.getStackTrace().toString());
        }
    }
    // hien thi ds sv
    private void displayStudentList() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            
            
            
        } catch (Exception ex) {
            view.showMessage(ex.getStackTrace().toString());
        }
    }
    
    // tim kiem theo ten
    public ArrayList<Student> searchStudentByName() {
        try {
            
            InetAddress IPAddress = InetAddress.getByName(serverHost);
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
            sendData.length, IPAddress, serverPort);
            myClient.send(sendPacket);
            
            String result = "";
            
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket =
            new DatagramPacket(receiveData, receiveData.length);
            myClient.receive(receivePacket);Chương 5: Lập trình với giao thức UDP
            82
            ByteArrayInputStream bais =
            new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            result = (String)ois.readObject();
            
        } catch (Exception ex) {
            view.showMessage(ex.getStackTrace().toString());
        }
        return null;
    }
    
    // tim kiem theo khoang gpa
    public ArrayList<Student> searchStudentByGPA() {
        return null;
    }
    
    // update thong tin 1 sv
    public boolean updateStudent() {
        return false;
    }
    
//    private void sendData(User user){
//        try {
    
//            
//            InetAddress IPAddress = InetAddress.getByName(serverHost);
//            byte[] sendData = baos.toByteArray();
//            DatagramPacket sendPacket = new DatagramPacket(sendData,
//            sendData.length, IPAddress, serverPort);
//            myClient.send(sendPacket);
//        } catch (Exception ex) {
//            view.showMessage(ex.getStackTrace().toString());
//        }
//    }
//    private String receiveData(){
//        String result = "";
//        try {
//            byte[] receiveData = new byte[1024];
//            DatagramPacket receivePacket =
//            new DatagramPacket(receiveData, receiveData.length);
//            myClient.receive(receivePacket);Chương 5: Lập trình với giao thức UDP
//            82
//            ByteArrayInputStream bais =
//            new ByteArrayInputStream(receiveData);
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            result = (String)ois.readObject();
//        } catch (Exception ex) {
//            view.showMessage(ex.getStackTrace().toString());
//        }
//        return result;
//    }
}