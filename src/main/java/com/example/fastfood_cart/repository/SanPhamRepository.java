package com.example.fastfood_cart.repository;

import com.example.fastfood_cart.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
    SanPham findSanPhamById(Integer id);
}
