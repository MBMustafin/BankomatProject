package BankomatClasses.Autorization;

import javax.swing.*;
import java.awt.*;


public class Autorization {
    private JFrame AUTORIZATIONFORM;
    private JLabel AUTORIZATIONLABEL;
    protected JPanel CenterPanel;
    protected JTextField CARDNUMBERFIELD;
    protected JPasswordField PASSWORDFIELD;
    protected JLabel helpLabel;
    protected JButton ENTERBUTTON;

    public Autorization() {
        createFrame();
        Autorization_Button_Handler bh = new Autorization_Button_Handler(this);
        ENTERBUTTON.addMouseListener(bh);
    }

    private void createFrame(){
        AUTORIZATIONFORM = new JFrame("Авторизация польователя");
        AUTORIZATIONFORM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AUTORIZATIONFORM.setSize(500, 500);
        AUTORIZATIONFORM.setLocation(450, 100);
        AUTORIZATIONFORM.setResizable(false);
        AUTORIZATIONFORM.setLayout(new BorderLayout());
        AUTORIZATIONFORM.getContentPane().setBackground(Color.PINK);
        addautorizationLabel();
        addtextSpace();
        addHelpLabel();
        addButton();
        AUTORIZATIONFORM.setVisible(true);
    }

    private void addautorizationLabel() {
        String text = "Авторизация в банке";
        AUTORIZATIONLABEL = new JLabel(text, JLabel.CENTER);
        AUTORIZATIONLABEL.setFont(new Font("TimesRoman", Font.BOLD, 30));
        AUTORIZATIONFORM.add(AUTORIZATIONLABEL);
    }

    private void addtextSpace() {
        CARDNUMBERFIELD = new JTextField(30);
        PASSWORDFIELD = new JPasswordField(30);
        CenterPanel = new JPanel();
        JLabel EnterCardNumber = new JLabel("Введите номер карты: ");
        JLabel EnterPassword = new JLabel("Введите пароль: ");


        CenterPanel.setBackground(Color.PINK);
        CenterPanel.add(EnterCardNumber);
        CenterPanel.add(CARDNUMBERFIELD);
        CenterPanel.add(EnterPassword);
        CenterPanel.add(PASSWORDFIELD);
        AUTORIZATIONFORM.add(AUTORIZATIONLABEL, BorderLayout.NORTH);
        AUTORIZATIONFORM.add(CenterPanel, BorderLayout.CENTER);
//        AUTORIZATIONFORM.add(EnterCardNumber);
//        AUTORIZATIONFORM.add(CARDNUMBERFIELD);
//        AUTORIZATIONFORM.add(EnterPassword);
//        AUTORIZATIONFORM.add(PASSWORDFIELD);
    }

    private void addButton() {
        ENTERBUTTON = new JButton("Продолжить");
        AUTORIZATIONFORM.add(ENTERBUTTON, BorderLayout.SOUTH);
    }

    private void addHelpLabel() {
        helpLabel = new JLabel("                  ");
        CenterPanel.add(helpLabel);
    }
}


