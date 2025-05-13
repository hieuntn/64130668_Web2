package hieuntn.edu.vn.Controllers;

import hieuntn.edu.vn.Model.NKH;
import hieuntn.edu.vn.Services.NKHService;
import hieuntn.edu.vn.Services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NKHController {

    @Autowired
    private NKHService nkhService;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("nhakhoahoc/new")
    public String formAddNew(Model model) {
        model.addAttribute("nkh", new NKH());
        model.addAttribute("taiKhoanList", taiKhoanService.getAllTaiKhoan());
        return "nkh-new";
    }

    @PostMapping("nhakhoahoc/add")
    public String addNKH(@ModelAttribute NKH nkh, Model model) {
        nkhService.addNKH(nkh);
        model.addAttribute("nkhList", nkhService.getAllNKH());
        return "nkh-list";
    }

    @GetMapping("/nhakhoahoc")
    public String getAllNKH(Model model) {
        model.addAttribute("nkhList", nkhService.getAllNKH());
        return "nkh-list";
    }

    @GetMapping("/nkh/edit/{nkhId}")
    public String editForm(@PathVariable int nkhId, Model model) {
        NKH nkh = nkhService.findById(nkhId);
        model.addAttribute("nkh", nkh);
        return "nkhEdit";
    }

    @PostMapping("/nkh/edit/{nkhId}")
    public String editNKH(@PathVariable int nkhId, @ModelAttribute("nkh") NKH updatedNkh, Model model) {
        nkhService.updateNKH(nkhId, updatedNkh);
        model.addAttribute("nkhList", nkhService.getAllNKH());
        return "redirect:/nhakhoahoc";
    }
    @GetMapping("/nkh/delete/{id}")
    public String deleteNKH(@PathVariable("id") int nkhId, Model model) {
        nkhService.deleteNKH(nkhId);
        model.addAttribute("nkhList", nkhService.getAllNKH());
        return "nkh-list";
    }
    @GetMapping("/nkh/search")
    public String searchNKH(@RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "hocVi", required = false) String hocVi, Model model) {
        model.addAttribute("nkhList", nkhService.searchNKH(keyword, hocVi));
        model.addAttribute("keyword", keyword);
        model.addAttribute("hocVi", hocVi);
        return "nkh-list";
    }
    @GetMapping("/{nkhId}/detail")
    public String getNkhDetail(@PathVariable Integer nkhId, Model model) {
        try {
            NKH nkh = nkhService.getNkhById(nkhId);
            long tongSoDeTai = nkhService.getTongSoDeTaiByNkhId(nkhId);
            model.addAttribute("nkh", nkh);
            model.addAttribute("tongSoDeTai", tongSoDeTai);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "nkh-detail";
    }
}