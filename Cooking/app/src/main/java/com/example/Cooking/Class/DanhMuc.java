package com.example.Cooking.Class;

public class DanhMuc {
    private Long id;
    private String tenDM;
    private String maDM;
    private String anh;

    public DanhMuc(Long id, String tenDM, String maDM, String anh) {
        this.id = id;
        this.tenDM = tenDM;
        this.maDM = maDM;
        this.anh = anh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
