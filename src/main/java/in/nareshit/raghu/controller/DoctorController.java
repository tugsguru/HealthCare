package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nareshit.raghu.entity.Doctor;
import in.nareshit.raghu.service.IDoctorService;
import in.nareshit.raghu.service.ISpecializationService;

@Controller
@RequestMapping("/doc")

public class DoctorController {
	
	@Autowired
	private IDoctorService service;
	
	@Autowired
	private ISpecializationService specService;
	
	private void commonUi(Model model) {
		model.addAttribute("specializations", specService.getSpecializationIdAndName());
	}
	
 
	
	//1. show register page
	@GetMapping("/register")
	public String showRegister(Model model) {
		commonUi(model);
		return "DoctorRegister";
	}
	
	//2. save
	@PostMapping("/save")
	public String saveDoctor(@ModelAttribute Doctor doc, Model model) {
		
		Long docid = service.saveDoctor(doc);
		
		System.out.println(doc);
		System.out.println(docid);
		
		String msg="Id '"+ docid+"' inserted";
		model.addAttribute("message",msg);
		
		commonUi(model);
		
		return "DoctorRegister";
	}
	
	//3. fetch and display
	@GetMapping("/all")
	private String showAll(Model model, @RequestParam(required=false) String message ) {
		
		List<Doctor> list=service.getAllDoctor();
		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("message",message);
		return "DoctorData";
	}
	
	//4. remove
	@GetMapping("/delete")
	private String deleteDoctor(@RequestParam Long id, RedirectAttributes attributes) {
		
		service.deleteDoctor(id);
		attributes.addAttribute("message", "Doctor '"+ id +"' deleted");
		
		return "redirect:all";
	}
	
	//5. show edit page
	@GetMapping("/edit")
	public String editDoctor(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		
		String page=null;
		
		Doctor obj=service.getOneDoctor(id);
		
		System.out.println("----test edit----");
		System.out.println(obj);
		
		if(obj!=null) {
			model.addAttribute("doctor", obj);
			commonUi(model);
			page="DoctorEdit";
		} else {
			attributes.addAttribute("message", "Doctor id '"+ id +"' not exist");
			page="Redirect:all";
		}
				
		//return "DoctorEdit";
		return page;
	}
	
	//6. update data
	@PostMapping("/update")
	public String update(@ModelAttribute Doctor doc,RedirectAttributes attributes) {
		
		service.updateDoctor(doc);
		attributes.addAttribute("message", "Doctor '"+ doc.getDocId() +"' Updated success");
		return "redirect:all";
	}

	
}
