/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 15-06-2020
 *   Time: 03:47 AM
 */

package com.social.app.controller;

import com.social.app.model.RecordsAsPurchase;
import com.social.app.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppRestController {

    private ServiceInterface serviceInterface;

    @Autowired
    public AppRestController(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @RequestMapping("/users")
    public List<RecordsAsPurchase> userRestApi(Model model) {
        List<RecordsAsPurchase> recordsAsPurchases = serviceInterface.getUser();
        model.addAttribute("userRecords", recordsAsPurchases);
        return recordsAsPurchases;
    }


}
