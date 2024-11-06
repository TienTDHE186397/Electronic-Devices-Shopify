/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Wallet {

    private int walletid;
    private int userid;
    private int balance;

    public Wallet() {
    }

    public Wallet(int walletid, int userid, int balance) {
        this.walletid = walletid;
        this.userid = userid;
        this.balance = balance;
    }

    public int getWalletid() {
        return walletid;
    }

    public void setWalletid(int walletid) {
        this.walletid = walletid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
