package com.example.fastfood_cart.controller.admin;

import com.example.fastfood_cart.entity.SanPham;
import com.example.fastfood_cart.repository.DanhSachSanPhamRepository;
import com.example.fastfood_cart.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Validated
@Controller
public class SanPhamController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private DanhSachSanPhamRepository danhSachSanPhamRepository;

    @GetMapping("/admin/view-addSP")
    public String viewAddSP(Model model) {
        List<SanPham> lstSP = sanPhamRepository.findAll();
        for (SanPham sp : lstSP) {
            String encodedImage = Base64.getEncoder().encodeToString(sp.getHinhAnh());
            sp.setEncodedImage(encodedImage);
        }

        model.addAttribute("sanPham", new SanPham());
        model.addAttribute("lstSP", lstSP);
        model.addAttribute("lstDSSP", danhSachSanPhamRepository.findAll());

        return "/admin/themsp";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @PostMapping("/admin/addSP")
    public String addSP(@ModelAttribute("sanPham") @Valid SanPham sanPham,
                        @RequestParam("hinhAnh") MultipartFile hinhAnh) throws IOException {

        if (hinhAnh.isEmpty()) {
            return "redirect:/admin/view-addSP";
        }

        try {
            sanPham.setHinhAnh(hinhAnh.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sanPhamRepository.save(sanPham);
        return "redirect:/admin/view-addSP";
    }

    @GetMapping("/admin/detailSP/{idSP}")
    public String detailSP(@PathVariable("idSP") Integer idSP, Model model) {
        SanPham sanPham = sanPhamRepository.findSanPhamById(idSP);
        model.addAttribute("SanPhamDeTail", sanPham);
        model.addAttribute("lstDSSP", danhSachSanPhamRepository.findAll());
        return "/admin/updatesp";
    }

    @PostMapping("/admin/updateSP/{id}")
    public String updateSP( @ModelAttribute("sanPham") @Valid SanPham sanPham,@PathVariable("id") Integer id,
                            @RequestParam("hinhAnh") MultipartFile hinhAnh) throws IOException {
        sanPham.setId(id);
        if (hinhAnh.isEmpty()) {
            return "redirect:/admin/view-addSP";
        }

        try {
            sanPham.setHinhAnh(hinhAnh.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sanPhamRepository.save(sanPham);
        return "redirect:/admin/view-addSP";
    }
}

