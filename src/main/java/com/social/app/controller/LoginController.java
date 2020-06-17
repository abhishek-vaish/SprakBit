/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 10-06-2020
 *   Time: 09:15 AM
 */

package com.social.app.controller;

import com.social.app.model.RecordsAsPurchase;
import com.social.app.service.ServiceInterface;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    private ServiceInterface serviceInterface;

    @Autowired
    public LoginController(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }


    @GetMapping("/register")
    public String registerPage(Model model){
        RecordsAsPurchase recordsAsPurchase = new RecordsAsPurchase();
        model.addAttribute("userRecords", recordsAsPurchase);
        return "register";
    }

    /*@PostMapping("/saveUser")
    public String saveUserToDatabase(){
        return "redirect:/purchase";
    }

    @GetMapping("/purchase")
    public String purchasePage(Model model){
        UserPurchaseRecord userPurchaseRecord = new UserPurchaseRecord();
        model.addAttribute("purchaseRecords", userPurchaseRecord);
        return "purchase";
    }*/

    @PostMapping("/saveUser")
    public String saveToDatabase(@ModelAttribute("userRecords") RecordsAsPurchase recordsAsPurchase){
        serviceInterface.saveUser(recordsAsPurchase);
        return "redirect:/register";
    }

    @RequestMapping("/users")
    public String userList(Model model){
        List<RecordsAsPurchase> recordsAsPurchases = serviceInterface.getUser();
        model.addAttribute("userList", recordsAsPurchases);
        return "userData";
    }

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        serviceInterface.delete(id);
        return "redirect:/users";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();

        session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/login?logout";
    }
}
