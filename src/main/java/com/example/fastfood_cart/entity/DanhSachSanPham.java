package com.example.fastfood_cart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "danhsachsanpham")
public class DanhSachSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dssp_id")
    private Integer dsspId;

    @Column(name = "ten_ds")
    private String tenDs;

    public DanhSachSanPham(Integer dsspId, String tenDs) {
        this.dsspId = dsspId;
        this.tenDs = tenDs;
    }

    public DanhSachSanPham() {
    }

    public Integer getDsspId() {
        return dsspId;
    }

    public void setDsspId(Integer dsspId) {
        this.dsspId = dsspId;
    }

    public String getTenDs() {
        return tenDs;
    }

    public void setTenDs(String tenDs) {
        this.tenDs = tenDs;
    }
}
