package com.example.Cooking;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;
    private String userName;
    private String passWord;
    private String anh;
    private String hoTen;
    private Date ngaySinh;
    private String email;
    private String gioiTinh;
    private String sdt;
    private int status;

//    public User(){
//
//    }
//
//    public User(Long id, String userName, String passWord, String anh, String hoTen, Date ngaySinh, String email, String gioiTinh, String sdt, int status) {
//        this.id = id;
//        this.userName = userName;
//        this.passWord = passWord;
//        this.anh = anh;
//        this.hoTen = hoTen;
//        this.ngaySinh = ngaySinh;
//        this.email = email;
//        this.gioiTinh = gioiTinh;
//        this.sdt = sdt;
//        this.status = status;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
