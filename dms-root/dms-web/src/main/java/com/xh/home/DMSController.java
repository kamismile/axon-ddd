package com.xh.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller    
public class DMSController {
	
	@RequestMapping("/")    
    public String index() {    
		System.out.println("hello dm home.");
        return "index";    
    } 
	
}
