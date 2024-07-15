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
@Table(name = "sanphamchitiet")
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spct_id")
    private Integer spctId;

    @ManyToOne
    @JoinColumn(name = "sanpham_id", referencedColumnName = "sanpham_id")
    private SanPham sanPhamId;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "mo_ta")
    private String moTa;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(Integer spctId, SanPham sanPhamId, Double gia, String moTa) {
        this.spctId = spctId;
        this.sanPhamId = sanPhamId;
        this.gia = gia;
        this.moTa = moTa;
    }

    public Integer getSpctId() {
        return spctId;
    }

    public void setSpctId(Integer spctId) {
        this.spctId = spctId;
    }

    public SanPham getSanPhamId() {
        return sanPhamId;
    }

    public void setSanPhamId(SanPham sanPhamId) {
        this.sanPhamId = sanPhamId;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getGia() {
        return gia;
    }

}


