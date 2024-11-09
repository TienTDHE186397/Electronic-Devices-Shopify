/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nghie
 */
public class Banks {
    private String BankName;
    private String AccountName;
    private String AccountNumber;

    public Banks() {
    }

    public Banks(String BankName, String AccountName, String AccountNumber) {
        this.BankName = BankName;
        this.AccountName = AccountName;
        this.AccountNumber = AccountNumber;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    @Override
    public String toString() {
        return "Banks{" + "BankName=" + BankName + ", AccountName=" + AccountName + ", AccountNumber=" + AccountNumber + '}';
    }
    
}