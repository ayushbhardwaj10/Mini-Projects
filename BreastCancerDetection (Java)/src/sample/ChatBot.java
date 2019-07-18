package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBot extends JFrame {
    private JTextArea Chatarea = new JTextArea();
    private JTextField chatbox = new JTextField();
    public String name;
    private String USER_NAME = "breastcancerdetection10@gmail.com";  // GMail user name of sender (just the part before "@gmail.com")
    private String PASSWORD = "breastcancer"; // GMail password of sender
    private String RECIPIENT;

    public ChatBot() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout((LayoutManager)null);
        frame.setSize(750, 700);
        frame.setTitle("ChatBot");
        frame.add(this.Chatarea);
        frame.add(this.chatbox);
        this.Chatarea.setSize(750, 630);
        this.Chatarea.setLocation(2, 2);
        this.chatbox.setSize(750, 50);
        this.chatbox.setLocation(2, 630);
        JavaMail mail = new JavaMail();
        frame.setBackground(Color.pink);
        Font f = new Font("",Font.BOLD,14);
        chatbox.setBackground(Color.DARK_GRAY);
        chatbox.setForeground(Color.WHITE);
        chatbox.setFont(f);
        Chatarea.setFont(f);
        Chatarea.setBackground(Color.pink);

        ChatBot.this.bot("Hello Sir/Madam " );


        this.chatbox.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent arg0) {
                String gtext = ChatBot.this.chatbox.getText();

                ChatBot.this.Chatarea.append("\n\nYOU -> " + gtext +"\n");
                gtext = gtext.toLowerCase();

                ChatBot.this.chatbox.setText("");
                if (gtext.contains("hi") || gtext.contains("hey") || gtext.contains("hello") || gtext.contains("namaste")) {
                    ChatBot.this.bot("Hello Sir/Madam,May I know your good name?");

                } else if (gtext.contains("tensed") || gtext.contains("worried") ||gtext.contains("fear") || gtext.contains("scared") || gtext.contains("fearing") || gtext.contains("tension")  ) {
                    ChatBot.this.bot("Don't worry "+name+", Cancer is curable these days.");
                    ChatBot.this.bot("We have the right doctors and technology to help you");

                } else if (gtext.contains("how") && gtext.contains("you")) {
                    ChatBot.this.bot("I  am Fine");

                } else if (gtext.contains("financial") || gtext.contains("money") || gtext.contains("assets")) {
                    ChatBot.this.bot("Don't worry about money "+name+", Government of India has made many good schemes\nfor Cancer sufferers");
                    ChatBot.this.bot("You can visit the following website :"+ " http://cancerindia.org.in/about-us/");

                } else if (gtext.contains("appointment")) {
                    ChatBot.this.bot("Sure "+name+",Please share me your email id");

                } else if (gtext.contains("@gmail.com")) {
                    ChatBot.this.bot("We will tell your doctor and he'll contact you soon");
                    RECIPIENT= gtext;
                    String[] to = { RECIPIENT };
                    String subject = " APPOINTMENT CONFIRMATION ";
                    String body = "Thankyou"+" "+name+" for reaching out to us.\nWe have recieved your request for your appointment. Your doctor will contact you very soon.\n\nRegards,\nBest wishes";

                    String docuser= "ayush.b.1998@gmail.com";
                    String[] toDoc = { docuser };
                    String subjectDoc = "APPOINTMENT";
                    String bodyDoc = "Hello Sir, You patient"+" "+name+" is looking for an appointment.\nPlease contact him soon.\n\nRegards,\nBest wishes";
                    mail.sendFromGMail(USER_NAME,PASSWORD,to,subject,body);
                    mail.sendFromGMail(USER_NAME,PASSWORD,toDoc,subjectDoc,bodyDoc);


                } else if (gtext.contains("name")) {
                    name= gtext;
                    //System.out.println("chatbot :"+name);
                    String[] arr = gtext.split(" ");
                    name= arr[arr.length-1];
                    String tempStr= "How can I help you "+name+" ?";
                    ChatBot.this.bot(tempStr);
                } else {
                    Random rand= new Random();
                    int x = rand.nextInt(4);
                    if (x == 1) {
                        ChatBot.this.bot("I don't understand");
                    } else if (x == 2) {
                        ChatBot.this.bot("I really don't understand");
                    } else {
                        ChatBot.this.bot("Please come again");
                    }
                }

            }
        });

        // Sending mail confirmation for appointment

    }

    private void bot(String string) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

        this.Chatarea.append("Hospital Services -> " + string +"\n");
    }

}
