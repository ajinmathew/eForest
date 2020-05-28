package com.android.cs.project.eforest;

public class Bank {
    String BankName,BankAccNo,BankBranch,BankIFSC,taxImgUrl,passbookImgUrl,identityImgUrl,time;

    public Bank() {
    }

    public Bank(String bankName, String bankAccNo, String bankBranch, String bankIFSC, String taxImgUrl, String passbookImgUrl, String identityImgUrl, String time) {
        BankName = bankName;
        BankAccNo = bankAccNo;
        BankBranch = bankBranch;
        BankIFSC = bankIFSC;
        this.taxImgUrl = taxImgUrl;
        this.passbookImgUrl = passbookImgUrl;
        this.identityImgUrl = identityImgUrl;
        this.time = time;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getBankAccNo() {
        return BankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        BankAccNo = bankAccNo;
    }

    public String getBankBranch() {
        return BankBranch;
    }

    public void setBankBranch(String bankBranch) {
        BankBranch = bankBranch;
    }

    public String getBankIFSC() {
        return BankIFSC;
    }

    public void setBankIFSC(String bankIFSC) {
        BankIFSC = bankIFSC;
    }

    public String getTaxImgUrl() {
        return taxImgUrl;
    }

    public void setTaxImgUrl(String taxImgUrl) {
        this.taxImgUrl = taxImgUrl;
    }

    public String getPassbookImgUrl() {
        return passbookImgUrl;
    }

    public void setPassbookImgUrl(String passbookImgUrl) {
        this.passbookImgUrl = passbookImgUrl;
    }

    public String getIdentityImgUrl() {
        return identityImgUrl;
    }

    public void setIdentityImgUrl(String identityImgUrl) {
        this.identityImgUrl = identityImgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
