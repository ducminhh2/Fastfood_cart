package com.example.fastfood_cart.repository;

import com.example.fastfood_cart.entity.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet,Integer> {
    List<SanPhamChiTiet> findAllBySanPhamId_Id(Integer sanPhamId);
    Page<SanPhamChiTiet> findAllBySanPhamId_DanhSachSanPham_TenDs(String tenDs, Pageable pageable);
}
