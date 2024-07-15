package com.example.fastfood_cart.entity;

import jakarta.persistence.*;
import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanpham_id")
    private Integer id;

    @Column(name = "ten_sp")
    private String tenSanPham;

    @ManyToOne
    @JoinColumn(name = "dssp_id", referencedColumnName = "dssp_id")
    private DanhSachSanPham danhSachSanPham;

    @Column(name = "anh_sp")
    @Lob
    private byte[] hinhAnh;

    @Transient
    private String encodedImage;

    public SanPham(Integer id, String tenSanPham, DanhSachSanPham danhSachSanPham, byte[] hinhAnh, String encodedImage) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.danhSachSanPham = danhSachSanPham;
        this.hinhAnh = hinhAnh;
        this.encodedImage = encodedImage;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public SanPham() {
    }

    public SanPham(Integer id, String tenSanPham, DanhSachSanPham danhSachSanPham, byte[] hinhAnh) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.danhSachSanPham = danhSachSanPham;
        this.hinhAnh = hinhAnh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public DanhSachSanPham getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(DanhSachSanPham danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    // toString method

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", danhSachSanPham=" + danhSachSanPham +
                ", hinhAnh=" + (hinhAnh != null ? hinhAnh.length + " bytes" : "null") +
                '}';
    }
}
