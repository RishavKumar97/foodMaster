package com.foodMaster.Controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	ObjectMapper objectMapper = new ObjectMapper(); 
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
    @PostMapping("/food")
    @ResponseBody
	public List<FoodMenu> getAllFoodMenus() {
    	
    	String foodMenuFile = "configFile/menu.json";
    	System.out.println(foodMenuFile);
        List<FoodMenu> FoodMenus = new ArrayList<>();
   
        try {
            File jsonFile = new File(foodMenuFile);
            
            // Read the JSON content into a custom wrapper class
            FoodMenuWrapper wrapper = objectMapper.readValue(jsonFile, FoodMenuWrapper.class);
            
            // Get the list of FoodMenu objects from the wrapper
            List<FoodMenu> menu = wrapper.getDishes();
            
            // Now you have the list of FoodMenu objects from the JSON file
            for (FoodMenu food : menu) {
            	FoodMenus.add(food);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FoodMenus;
    }
	
}
