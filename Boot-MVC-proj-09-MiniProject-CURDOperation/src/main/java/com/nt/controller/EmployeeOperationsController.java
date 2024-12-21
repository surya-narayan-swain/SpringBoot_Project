package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map) {
		// use service
		Iterable<Employee> itEmps = empService.getAllEmployees();

		// put result in model attribute
		map.put("empsList", itEmps);
		// return LVN
		return "show_employee_report";
	}

	@GetMapping("/emp_add") // for form launching
	public String showFormForSaveEmployee(@ModelAttribute("emp") Employee emp) {
		// return LVN
		return "register_employee";
	}

	/*@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,Map<String,Object> map)
	{
		
		//use service
		String msg=empService.registerEmployee(emp);
	Iterable<Employee> itEmps=empService.getAllEmployees();
	//keep the result in modelattribute
	map.put("resultMsg",msg);
	map.put("empsList",itEmps);
	
	//return LVN
	return "show_employee_report";
	
	}*/

	/*@PostMapping("/emp_add") //form sybmission related to add empployee operation
	public String saveEmployee(@ModelAttribute("emp")Employee emp,Map<String,Object> map)
	{
		
		//use service
		String msg=empService.registerEmployee(emp);
	//Iterable<Employee> itEmps=empService.getAllEmployees();
	//keep the result in modelattribute
	map.put("resultMsg",msg);
	//map.put("empsList",itEmps);
	
	//return LVN
	return "redirect:report";     //(R--Redirect)
	
	}*/

	/*@PostMapping("/emp_add") //form sybmission related to add empployee operation
	public String saveEmployee(@ModelAttribute("emp")Employee emp,RedirectAttributes attrs)
	{
		
		//use service
		String msg=empService.registerEmployee(emp);
	//Iterable<Employee> itEmps=empService.getAllEmployees();
	//keep the result in modelattribute
	attrs.addFlashAttribute("resultMsg",msg);
	//map.put("empsList",itEmps);
	
	//return LVN
	return "redirect:report";     //(R--Redirect)
	
	}
	*/

	@PostMapping("/emp_add") // form sybmission related to add empployee operation
	public String saveEmployee(@ModelAttribute("emp") Employee emp, HttpSession ses) {

		// use service
		String msg = empService.registerEmployee(emp);
		// Iterable<Employee> itEmps=empService.getAllEmployees();
		// keep the result in modelattribute
		ses.setAttribute("resultMsg", msg);
		// map.put("empsList",itEmps);

		// return LVN
		return "redirect:report"; // (R--Redirect)

	}

	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		// use service
		Employee emp1 = empService.getEmployeeByNo(no);
		// copy data
		BeanUtils.copyProperties(emp1, emp);
		// return LVN
		return "update_employee";

	}

		@PostMapping("/emp_edit")
		public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp)
		{
			//use service
			String msg=empService.updateEmployee(emp);
		//add result message as flash attribute
			attrs.addFlashAttribute("resultMsg",msg);
			//redirect 
			return "redirect:report";
		
		}

		@GetMapping("/emp_delete")
		public String deleteEmployee(RedirectAttributes attrs,@RequestParam int no)
		{
			//use service
			String msg=empService.deleteEmployeeById(no);
		//keep result in flash attribute
			attrs.addFlashAttribute("resultMsg",msg);
			//redirect the request
			return "redirect:report";
		
		}
}
