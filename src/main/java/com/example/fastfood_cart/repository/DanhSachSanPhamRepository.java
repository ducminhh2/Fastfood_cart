package com.example.fastfood_cart.repository;

import com.example.fastfood_cart.entity.DanhSachSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhSachSanPhamRepository extends JpaRepository<DanhSachSanPham,Integer> {
}
