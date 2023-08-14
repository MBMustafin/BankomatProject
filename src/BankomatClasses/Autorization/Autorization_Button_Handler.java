package BankomatClasses.Autorization;

import DataBase.DB;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

public class Autorization_Button_Handler implements MouseListener {
    private Autorization autorization;

    public Autorization_Button_Handler(Autorization autorization) {
        this.autorization = autorization;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String CardNumber = autorization.CARDNUMBERFIELD.getText().replace(" ", "");
        String Password = autorization.PASSWORDFIELD.getText();
        boolean boolCardNumber = Pattern.matches("\\d{16}", CardNumber);
        boolean boolPassword = Pattern.matches("\\d{4}", Password);

        if (CardNumber.length() == 16) {
            if (!boolCardNumber) {
                autorization.helpLabel.setText("Номер карты должен содержать 16 цифр от 0 до 9. Допускаются пробелы");
            }
        }
        else {
            autorization.helpLabel.setText("Номер карты должен содержать 16 цифр от 0 до 9");
        }

        if (Password.length() == 4) {
            if (!boolPassword) {
                autorization.helpLabel.setText("Пароль должен содержать 4 цифры от 0 до 9.");
            }
        }
        else {
            autorization.helpLabel.setText("Пароль должен содержать 4 цифры от 0 до 9");
        }

        if (CardNumber.length() == 16 && Password.length() == 4 && boolCardNumber && boolPassword){
            System.out.println(CardNumber + " " + Password);
            try(DB db = new DB()){
                boolean flag = false;
                DB.conn = db.getConnection();
                String query = "SELECT * FROM bankomattable";
                Statement stmt = DB.conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    String cardNumber = rs.getString("Номер карты");
                    String password = rs.getString("Пароль");
                    String validmonth = rs.getString("Срок действия:месяц");
                    String validyear = rs.getString("Срок действия:год");
                    String cvv = rs.getString("CVV");
                    if (cardNumber.equals(CardNumber) && password.equals(Password)){
                        flag = true;
                        Data_of_client client = new Data_of_client(cardNumber, password, validmonth, validyear, cvv);
                        System.out.println("Client's data in base . . .");
                        break;
                    }
                }

                if (!flag) {
                    autorization.helpLabel.setText("Таких данных не существует.");
                }
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
