package com.app.controller;

import com.app.entities.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// GET request to display the login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
	
	// Cheaking for loging credentials
	@PostMapping("/login")
	public String login(@ModelAttribute(name="user") User user,Model model) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		if("admin".equals(username) && "Finite4".equals(password)) {
			// if username and password is correct, we are returning user.html
			return "redirect:/users";
		}
		// if username and password is wrong
		model.addAttribute("invalidCredentials",true);
		// Return again login page
		return "login";
	}
	
	
	// To display all users
	@GetMapping("/users")
    public String listUser(Model model) {
         model.addAttribute("users",userService.getAllUsers());
         return "user";
    }
	
	// To Create new employee
    @GetMapping("/users/new")
    public String createEmployeeForm(Model model) {
    	// Create student object to hold the data
    	User user=new User();
    	model.addAttribute("User",user);
    	return "create_employee";
    }
    
    // To save the created employee
    @PostMapping("/users")
    public String saveEmployee(@ModelAttribute("user") User user) {
    	userService.saveEmployee(user);
    	return "redirect:/users";
    }
    
    // To edit employee detail by id
    @GetMapping("/users/edit/{id}")
    public String editEmployeeDetail(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    // To Update user
    @PostMapping("/users/{id}")
    public String updateDetail(@PathVariable Long id,
    		@ModelAttribute ("user") User user,
    		Model model) {
    	
    	// get Employee from database by id
    	User existingUser=userService.getUserById(id);
    //	existingUser.setId(id);
    	existingUser.setEmpName(user.getEmpName());
    	existingUser.setEmail(user.getEmail());
    	existingUser.setJoiningDate(user.getJoiningDate());
    	existingUser.setAllowance(user.getAllowance());
    	existingUser.setBasicSalary(user.getBasicSalary());
    	existingUser.setInsurance(user.getInsurance());
    	existingUser.setOtherDeduction(user.getOtherDeduction());
    	existingUser.setTax(user.getTax());
    	existingUser.setNetSalary(user.getNetSalary());
    	
    	// Save updated Employee Details
    	userService.updateUser(existingUser);
        return "redirect:/users";
    }
    
    @GetMapping("/users/{id}")
    public String deleteEmployee(@PathVariable Long id) {
    	userService.deleteUserById(id);
    	return "redirect:/users";
    }
    
    
    @GetMapping("/users/{id}/salarySlip")
    public String showSalarySlip(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "salarySlip"; // Assuming you have a template named salarySlip.html
    }

}
