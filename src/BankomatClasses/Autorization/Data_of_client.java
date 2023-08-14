package BankomatClasses.Autorization;

public class Data_of_client {
    protected String cardNumber;
    protected String password;
    protected String validMonth;
    protected String validYear;
    protected String cvv;

    public Data_of_client(String cardNumber, String password, String validMonth, String validYear, String cvv) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.validMonth = validMonth;
        this.validYear = validYear;
        this.cvv = cvv;
    }
}
