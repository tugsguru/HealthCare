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

import in.nareshit.raghu.entity.Appointment;
import in.nareshit.raghu.service.IAppointmentService;
import in.nareshit.raghu.service.IDoctorService;

@Controller
@RequestMapping("/app")

public class AppointmentController {

	@Autowired 
	private IAppointmentService service;
	
	@Autowired
	private IDoctorService docService;
	
	private void commonUi(Model model) {
		model.addAttribute("doctors", docService.getDocIdAndNames());
		System.out.println(docService.getDocIdAndNames());
	}
	
	@GetMapping("/register")
	private String register(Model model) {
		commonUi(model);
		return "AppointmentRegister";
	}
	
	@PostMapping("/save")
	private String save(@ModelAttribute Appointment app, Model model) {
		
		Long id=service.saveAppointment(app);
		
		//System.out.println(app);	
		String msg="ID -'"+id+"' registered ";
		model.addAttribute("message", msg);	
		return "AppointmentRegister";
	}
	
	@GetMapping("/all")
	private String showData(Model model, @RequestParam(required=false) String message) {
		
		List<Appointment> list=service.getAllAppointment();
		model.addAttribute("list", list);
		model.addAttribute("message",message);
		return "AppointmentData";
	}
	
	@GetMapping("/delete")
	private String delete(@RequestParam Long id, RedirectAttributes attributes) {
		
		service.deleteAppointment(id);
		attributes.addAttribute("message", " '"+id+"' -тай бичлэг устлаа");
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	private String edit(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		
		String page=null;
		
		Appointment obj=service.getOneAppointment(id);
		
		commonUi(model);
		
		if(obj!=null) {
			model.addAttribute("appointment", obj);
		    page="AppointmentEdit";
		} else {
			attributes.addAttribute("message", "'"+id+"'-тай бичлэг алга шүү!");
			page= "redirect:all";
		}
		
		return page;
		
	}
	
	@PostMapping("/update")
	private String update(@ModelAttribute Appointment app, RedirectAttributes attributes) {
		
		service.updateAppointment(app);
		attributes.addAttribute("message", "'"+app.getAppId()+"'-тай бичлэг амжилттай засагдлаа");
		return "redirect:all";
	}
	
}
