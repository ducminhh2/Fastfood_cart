package com.example.fastfood_cart.controller.admin;

import com.example.fastfood_cart.entity.SanPham;
import com.example.fastfood_cart.entity.SanPhamChiTiet;
import com.example.fastfood_cart.repository.DanhSachSanPhamRepository;
import com.example.fastfood_cart.repository.SanPhamChiTietRepository;
import com.example.fastfood_cart.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AdminController {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    DanhSachSanPhamRepository danhSachSanPhamRepository;
    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;
    @GetMapping("/admin")
    public String homeAdmin(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(6);

        Page<SanPhamChiTiet> sanPhamChiTietPage = sanPhamChiTietRepository.findAll(PageRequest.of(currentPage - 1, pageSize));

        List<SanPham> lstSP = sanPhamRepository.findAll();
        for (SanPham sp : lstSP) {
            String encodedImage = Base64.getEncoder().encodeToString(sp.getHinhAnh());
            sp.setEncodedImage(encodedImage);
        }

        model.addAttribute("lstAllSPCT", sanPhamChiTietPage.getContent());
        model.addAttribute("lstDSSP", danhSachSanPhamRepository.findAll());

        int totalPages = sanPhamChiTietPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "/admin/board";
    }


}
