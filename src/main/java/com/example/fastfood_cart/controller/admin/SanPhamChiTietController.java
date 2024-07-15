package com.example.fastfood_cart.controller.admin;

import com.example.fastfood_cart.entity.SanPham;
import com.example.fastfood_cart.entity.SanPhamChiTiet;
import com.example.fastfood_cart.repository.DanhSachSanPhamRepository;
import com.example.fastfood_cart.repository.SanPhamChiTietRepository;
import com.example.fastfood_cart.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class SanPhamChiTietController {
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private DanhSachSanPhamRepository danhSachSanPhamRepository;
    @GetMapping("/admin/view-chiTietSP/{id}")
    public String viewChiTietSanPham(Model model, @PathVariable("id") Integer id){
        List<SanPhamChiTiet> lstCT = sanPhamChiTietRepository.findAllBySanPhamId_Id(id);
        model.addAttribute("lstCT", lstCT);
        SanPham sp = sanPhamRepository.findSanPhamById(id);
        model.addAttribute("SP", sp);
        model.addAttribute("lstDSSP", danhSachSanPhamRepository.findAll());
        return "/admin/viewchitietsp";
    }
    @PostMapping("/admin/addchiTietSP/{id}")
    public String addChiTietSanPham(@PathVariable("id") Integer id, @RequestParam("gia")Double gia,@RequestParam("moTa")String moTa){
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(id);
        SanPham sanPham = optionalSanPham.get();
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        sanPhamChiTiet.setSanPhamId(sanPham);
        sanPhamChiTiet.setGia(gia);
        sanPhamChiTiet.setMoTa(moTa);
        sanPhamChiTietRepository.save(sanPhamChiTiet);
        return "redirect:/admin/view-chiTietSP/"+id;
    }

    @GetMapping("/admin/remove-SPCT/{id}")
    public String addChiTietSanPham(@PathVariable("id") Integer id){
        Optional<SanPhamChiTiet> optionalSanPhamChiTiet = sanPhamChiTietRepository.findById(id);
        SanPhamChiTiet sanPhamChiTiet = optionalSanPhamChiTiet.get();
        Integer id1 = sanPhamChiTiet.getSanPhamId().getId();
        sanPhamChiTietRepository.delete(sanPhamChiTiet);
        return "redirect:/admin/view-chiTietSP/"+id1;
    }

    @GetMapping("/admin/detailchiTietSP/{id}")
    public String detailChiTietSanPham(@PathVariable("id") Integer id,Model model){
        Optional<SanPhamChiTiet> optionalSanPhamChiTiet = sanPhamChiTietRepository.findById(id);
        SanPhamChiTiet sanPhamChiTiet = optionalSanPhamChiTiet.get();
        Integer id1 = sanPhamChiTiet.getSanPhamId().getId();
        model.addAttribute("SPCTDT",sanPhamChiTiet);

        List<SanPhamChiTiet> lstCT = sanPhamChiTietRepository.findAllBySanPhamId_Id(id1);
        model.addAttribute("lstCT", lstCT);
        model.addAttribute("lstDSSP", danhSachSanPhamRepository.findAll());
        SanPham sp = sanPhamRepository.findSanPhamById(id1);
        model.addAttribute("SP", sp);
        return "/admin/viewchitietsp";
    }

    @PostMapping("/admin/update-detail/{id}")
    public String updateChiTietSanPham(@PathVariable("id") Integer id, @RequestParam("gia")Double gia,@RequestParam("moTa")String moTa){
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(id);
        SanPham sanPham = optionalSanPham.get();
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        sanPhamChiTiet.setSpctId(id);
        sanPhamChiTiet.setSanPhamId(sanPham);
        sanPhamChiTiet.setGia(gia);
        sanPhamChiTiet.setMoTa(moTa);
        sanPhamChiTietRepository.save(sanPhamChiTiet);
        return "redirect:/admin/view-chiTietSP/"+ sanPham.getId();
    }
}
