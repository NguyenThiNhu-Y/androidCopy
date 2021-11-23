package com.example.Cooking.Class;

public class MonAn {
    private String anh;
    private String tenMon;
    private String nguoiDang;
    private String luotXem;
    private String luotThich;

    public MonAn(String hinh, String tenMon, String nguoiDang, String luotXem, String luotThich) {
        this.anh = hinh;
        this.tenMon = tenMon;
        this.nguoiDang = nguoiDang;
        this.luotXem = luotXem;
        this.luotThich = luotThich;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getNguoiDang() {
        return nguoiDang;
    }

    public void setNguoiDang(String nguoiDang) {
        this.nguoiDang = nguoiDang;
    }

    public String getLuotXem() {
        return luotXem;
    }

    public void setLuotXem(String luotXem) {
        this.luotXem = luotXem;
    }

    public String getLuotThich() {
        return luotThich;
    }

    public void setLuotThich(String luotThich) {
        this.luotThich = luotThich;
    }
}
