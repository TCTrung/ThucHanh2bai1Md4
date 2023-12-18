package com.example.thuchanh2bai1md4.controller;

import com.example.thuchanh2bai1md4.entity.Customer;
import com.example.thuchanh2bai1md4.model.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO = new CustomerDAO();
//    @GetMapping("/customer")
//    public String showList(HttpServletRequest request) {
//        List<Customer> customers = customerDAO.selectAllCustomers();
//        request.setAttribute("listCustomer", customers);
//        return "view/list.jsp";
//    }

//    @GetMapping("/customer")
//    public String showList(Model model) {
//        List<Customer> customers = customerDAO.selectAllCustomers();
//        model.addAttribute("listCustomer", customers);
//        return "view/list.jsp";
//    }

//        @GetMapping("/customer")
//        public String showList(Model model) {
//            List<Customer> customers = customerDAO.selectAllCustomers();
//            model.addAttribute("listCustomer", customers);
//            return "view/list.jsp";
//        }

    @GetMapping("/customer")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("view/list.jsp");
        List<Customer> customers = customerDAO.selectAllCustomers();
        modelAndView.addObject("listCustomer", customers);
        return modelAndView;
    }

}
