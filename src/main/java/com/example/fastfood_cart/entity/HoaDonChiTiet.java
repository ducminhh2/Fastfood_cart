package com.example.fastfood_cart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoadonchitiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hdct_id")
    private Integer hdctId;

    @ManyToOne
    @JoinColumn(name = "hd_id", referencedColumnName = "hd_id")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "spct_id", referencedColumnName = "spct_id")
    private SanPhamChiTiet spctId;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "thanh_tien")
    private Double thanhTien;

    @Column(name = "trang_thai")
    private String trangThai;

    public HoaDonChiTiet() {
    }

    public Integer getHdctId() {
        return hdctId;
    }

    public void setHdctId(Integer hdctId) {
        this.hdctId = hdctId;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPhamChiTiet getSpctId() {
        return spctId;
    }

    public void setSpctId(SanPhamChiTiet spctId) {
        this.spctId = spctId;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDonChiTiet(Integer hdctId, HoaDon hoaDon, SanPhamChiTiet spctId, int soLuong, Double gia, Double thanhTien, String trangThai) {
        this.hdctId = hdctId;
        this.hoaDon = hoaDon;
        this.spctId = spctId;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }
}
