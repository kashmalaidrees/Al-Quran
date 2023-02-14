package com.example.al_madaris;

public class Student {
    private String name;
    private String rollno;
    private String fathercontact;
    private String parano;
    private String ayatfrom;
    private String ayatto;
    private String sabki;
    private String manzil;

    public Student(String name, String rollno, String fathercontact, String parano, String ayatfrom, String ayatto, String sabki, String manzil)
    {
        this.name = name;
        this.rollno = rollno;
        this.fathercontact = fathercontact;
        this.parano = parano;
        this.ayatfrom = ayatfrom;
        this.ayatto = ayatto;
        this.sabki = sabki;
        this.manzil = manzil;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getFather_contact() {
        return fathercontact;
    }

    public void setFathercontact(String fathercontact) {
        this.fathercontact = fathercontact;
    }

    public String getParano() {
        return parano;
    }

    public void setParano(String parano) {
        this.parano = parano;
    }

    public String getAyatfrom() {
        return ayatfrom;
    }

    public void setAyatfrom(String ayatfrom) {
        this.ayatfrom = ayatfrom;
    }

    public String getAyatto() {
        return ayatto;
    }

    public void setAyat_to(String ayatto) {
        this.ayatto = ayatto;
    }

    public String getSabki() {
        return sabki;
    }

    public void setSabki(String sabki) {
        this.sabki = sabki;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }


}
