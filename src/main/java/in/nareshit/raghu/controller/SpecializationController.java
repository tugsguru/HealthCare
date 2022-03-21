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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nareshit.raghu.entity.Specialization;
import in.nareshit.raghu.exception.SpecializationNotFoundException;
import in.nareshit.raghu.service.ISpecializationService;
import in.nareshit.raghu.view.SpecializationExcelView;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service; //Has-a
	
	//1. show register page
	@GetMapping("/register")
	public String showReg() {
		return "SpecializationRegister";
	}
	
	//2. save
	@PostMapping("/save")
	public String save(
			//reading Form data
			@ModelAttribute Specialization spel,
			Model model
			) {
		
		//calling service
		Long id=service.saveSpecialization(spel);
		
		System.out.println(spel);
		
		//sending message to UI
		model.addAttribute("message","Spec '"+id+"' is added");
	
		return "SpecializationRegister";
	}
	
	//3. fetch and display
	@GetMapping("/all")
	public String showData(
			Model model, 
			@RequestParam(required = false) String message) 
	{
		//call service
		List<Specialization> list = service.getAllSpecialization();
		
		//send data to UI
		model.addAttribute("list", list);
		model.addAttribute("message",message);
		
		//goto HTML page
		return "SpecializationData";
	}
		
	//4. remove
	@GetMapping("/delete")
	public String delete(@RequestParam Long id, RedirectAttributes attributes) {
		//System.out.println(id);
		
		try {
			service.deleteSpecialization(id);
			attributes.addAttribute("message", "Specialization '"+ id +"' Deleted");
		} catch (SpecializationNotFoundException e) {
			attributes.addAttribute("message",e.getMessage());
		}
		
		return "redirect:all";
	}
	
	@GetMapping("/testparam")
	public String test(@RequestParam Long id) {
		System.out.println(id);
		return "SpecializationData";
	}
	
	//5. show edit page
	/*@GetMapping("edit")
	public String edit(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		
		String page=null;
		//call service
		Specialization obj=service.getOneSpecialization(id);
		if(obj!=null) {
			//send data to UI
		    model.addAttribute("specialization", obj);
			//Goto Edit HTML Page
		    page="SpecializationEdit";
		} else {
			attributes.addAttribute("message", "Specialization '"+ id +"' not exist");
			page = "redirect:all";
			
		}
		
		return page;
	}*/
	
	//5. new
	@GetMapping("edit")
	public String edit(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		
		String page=null;
		try {
			//call service
			Specialization obj=service.getOneSpecialization(id);
			model.addAttribute("specialization", obj);
			//Goto Edit HTML Page
		    page="SpecializationEdit";
			
		} catch (SpecializationNotFoundException e) {
			attributes.addAttribute("message",e.getMessage());
			page = "redirect:all";
		}
		
		return page;
	}
		
	//6. update data
	@PostMapping("update")
	public String update(
			//Read Form data 
			@ModelAttribute Specialization specialization,
			RedirectAttributes attributes
			) {
		
		service.updateSpecialization(specialization);
		attributes.addAttribute("message", "Specialization '"+ specialization.getSpecId() +"' updated success");
		return "redirect:all";
	}
	
	@GetMapping("/excel")
	public ModelAndView excelExport() {
		
		//Create MAV obj 
		ModelAndView m= new ModelAndView();
		
		//provide view class object
		m.setView(new SpecializationExcelView());
		
		//Read data from DB and send to View class
		List<Specialization> list=service.getAllSpecialization();
		m.addObject("list",list);
	
		return m;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
