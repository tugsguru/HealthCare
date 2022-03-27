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

import in.nareshit.raghu.entity.User;
import in.nareshit.raghu.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("/register")
	public String showUserRegister() {
		return "UserRegister";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User userObj, Model model) {
	
	Integer uid;	
	
	//System.out.println(userObj.toString());
	
	uid = service.saveUser(userObj);
	
	model.addAttribute("message", "Энэ ер нь лаг нөхөр л дөө удахгүй топ хөгжүүлэгч болно "+uid+"");
		
		return "UserRegister";
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute User obj, RedirectAttributes attributes){
		
		service.updateUser(obj);
		
		attributes.addAttribute("message", ""+obj.getUid()+"-id tai nuhur zasagdlaa");
		
		return "redirect:all";
	}
	
	@GetMapping("/all")
	public String showAll(Model model, @RequestParam(required=false) String message) {
		
		List<User> userList = service.getAllUser();
		System.out.println(userList);
		
		model.addAttribute("user_list",userList);
		model.addAttribute("message", message);
		
		return "UserData";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam Integer id, RedirectAttributes attributes) {
		
		service.deleteUser(id);
		
		attributes.addAttribute("message", ""+ id +" deleted");
		
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String editUser(@RequestParam Integer id, Model model) {
		
		User obj=service.getOneUser(id);
		//System.out.println("edit  "+obj.toString());
		model.addAttribute("users", obj);
		return "UserEdit";
	}
	
}
