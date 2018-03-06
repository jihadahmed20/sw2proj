/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.mycompany.test1.controller;

import com.mycompany.test1.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
@Controller
public class RegisterController {
AccountController aC=new AccountController();
ProductController PC=new ProductController();
BrandController bC=new BrandController();
StoreController sC=new StoreController();
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("account") Account account) {
       boolean reg=aC.register(account.getUserName(),account.getPass(),account.getType(),aC);
        if(reg==true)
        return "result";
        else
            return "register";
    }


    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginAccount", new Account());
        return "login";}

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("loginAccount") Account loginAccount) {
        boolean log=aC.login(loginAccount.getUserName(),loginAccount.getPass(),loginAccount.getType(),aC);
        System.out.println(loginAccount.getUserName());
        System.out.println(loginAccount.getPass());
        System.out.println(loginAccount.getType());
        System.out.println(log);
        if(log==true)
        return "loginresult";
        else
        {return "login";}
    }

    @GetMapping("/addproduct")
    public String addProductForm(Model model) {
        model.addAttribute("newProduct", new Product());
        return "addproduct";}

    @PostMapping("/addproduct")
    public String addProductSubmit(@ModelAttribute("newProduct") Product newProduct) {
        bC.brands.add("adedas");
        bC.brands.add("nicky");
        bC.brands.add("bomma");
        bC.brands.add("lacost");
        bC.brands.add("gohyna");
        bC.brands.add("labneta");
        bC.brands.add("almra3e");
        boolean add=PC.addProduct(newProduct,bC,PC);

        if(add==true)
        {
            for(int i=0;i<PC.mProducts.size();i++)
            {
               System.out.println(PC.mProducts.get(i).getName());
            }
            return "addResult";
        }
       else {
            return "addproduct";
        }
    }

    @GetMapping("/addStore")
    public String addStoreForm(Model model) {
        model.addAttribute("newstore", new Store());
        return "addStore";}

    @PostMapping("/addStore")
    public String addStoreSubmit(@ModelAttribute("newstore") Store newstore) {
            boolean done = sC.addStore(newstore.getName(), sC);
            if (done == true)
                return "addstoreresult";
            else
                return "addStore";



    }
}
