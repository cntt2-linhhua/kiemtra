package vn.edu.leading.kiemtra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.kiemtra.model.SinhvienModel;
import vn.edu.leading.kiemtra.services.SinhvienServices;

import javax.validation.Valid;

@Controller
public class SinhvienController {

    private final SinhvienServices sinhvienServices;

    public SinhvienController(SinhvienServices sinhvienServices) {
        this.sinhvienServices = sinhvienServices;
    }

    @GetMapping("/sinhviens")
    public String list(Model model) {
        model.addAttribute("sinhviens", sinhvienServices.findAll());
        return "sinhviens/list";
    }

    @GetMapping("sinhviens/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/sinhviens";
        }
        model.addAttribute("sinhviens", sinhvienServices.search(term));
        return "sinhviens/list";
    }

    @GetMapping("/sinhviens/add")
    public String add(Model model) {
        model.addAttribute("sinhvienModel", new SinhvienModel ());
        return "sinhviens/form";
    }

    @GetMapping("/sinhviens/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("sinhvienModel", sinhvienServices.findById(id));
        return "sinhviens/form";
    }

    @PostMapping("/sinhviens/save")
    public String save(@Valid SinhvienModel sinhvien, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "sinhviens/form";
        }
        sinhvienServices.save(sinhvien);
        redirect.addFlashAttribute("successMessage", "Saved sinh vien successfully!");
        return "redirect:/sinhviens";
    }

    @GetMapping("/sinhviens/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (sinhvienServices.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted sinh vien successfully!");
            return "redirect:/sinhviens";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/sinhviens";
        }
    }
}
