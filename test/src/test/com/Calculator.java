package test.com;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator implements ActionListener {

 JFrame frame=new JFrame();
 private JButton[] b;
 private JButton b2;
 private JTextArea t;
 private JButton jbtnsqrt;
 private boolean flag=false;

 public Calculator() {
  jbtnsqrt=new JButton("Sqrt");
  b=new JButton[16];
  b2=new JButton("C");
  String str="123+456-789x0.=/";
  for(int i=0;i<b.length;i++){
  b[i]=new JButton(str.substring(i,i+1));
  } 
 }
 private void setFontAndColor(){
  Font f=new Font("����",Font.BOLD,18);
  t.setFont(f);
  for(int i=0;i<b.length;i++){
   b[i].setFont(f);
  }
 }
 private void init(){
  t=new JTextArea(1,20);
  JPanel northPanel=new JPanel();
  JPanel centerPanel=new JPanel();
  northPanel.setLayout(new FlowLayout());
  centerPanel.setLayout(new GridLayout(4,4));
  northPanel.add(t);
  northPanel.add(b2);
  northPanel.add(jbtnsqrt);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  b2.setBackground(Color.RED);
  b2.setForeground(Color.green);
  b2.addActionListener(this);
     jbtnsqrt.addActionListener(this);
  for(int i=0;i<b.length;i++){
   centerPanel.add(b[i]);
   b[i].addActionListener(this);
   }
  frame.setLayout(new BorderLayout());
  frame.add(northPanel,BorderLayout.NORTH);
  frame.add(centerPanel, BorderLayout.CENTER);
  setFontAndColor();
  frame.setLocation(340,300);
  frame.setVisible(true);
  frame.pack();
  frame.setResizable(false); 
 }
 
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==b2) t.setText(null);//���Cʱ����ı���
  else if(e.getSource()==b[14]){     //���=ʱ��ȡ�ı�����ַ���
   String s=t.getText().trim();
   String[] rs;
   if(s.contains("+")){
    rs=s.split("\\+");  
    double d=Double.parseDouble(rs[0])+Double.parseDouble(rs[1]);
    t.setText(String.valueOf(d));
   }
   else if(s.contains("-")){
    rs=s.split("-");
    double d=Double.parseDouble(rs[0])-Double.parseDouble(rs[1]);
    t.setText(String.valueOf(d));
    }
   else if(s.contains("x")){
    rs=s.split("x");
    double d=Double.parseDouble(rs[0])*Double.parseDouble(rs[1]);
    t.setText(String.valueOf(d));
   }
   else if(s.contains("/")){
    rs=s.split("/");
    double d=Double.parseDouble(rs[0])/Double.parseDouble(rs[1]);
    t.setText(String.valueOf(d));       
   }
   flag=true;
  }else if(e.getSource()==jbtnsqrt){
   String s=t.getText().trim();
   double d=Math.sqrt(Double.parseDouble(s));
   t.setText(String.valueOf(d)); 
  }
  else {
   if(flag){
    t.setText("");
   }
//   �����=��Cʱ�����ַ���׷�����ı�����
   t.append(e.getActionCommand()); 
   flag=false;
  } 
 }
 public static void main(String[] args) {
  new Calculator().init();  
 }
}