package com.setec.controller;

import com.setec.CoffeeShopTelegramBotApplication;
import com.setec.entities.Booked;
import com.setec.repos.BookedRepo;
import com.setec.telegrambot.MyTelegramBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    private final CoffeeShopTelegramBotApplication coffeeShopTelegramBotApplication;

    MyController(CoffeeShopTelegramBotApplication coffeeShopTelegramBotApplication) {
        this.coffeeShopTelegramBotApplication = coffeeShopTelegramBotApplication;
    }
	//	http://localhost:8091/
	
	@GetMapping({"/","/home"})
	public String home(Model mod) {
		
		Booked booked = new Booked(1,"Long Kimsreang","0967048899","longkimsreang@gmail.com",
				"12/31/2025","7:12 Am","3");
			mod.addAttribute("booked",booked);
			
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/service")
	public String service() {
		return "service";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/reservation")
	public String reservation(Model mod) {
		
		Booked booked = new Booked(1,"Long Kimsreang","0967048899","longkimsreang@gmail.com",
				"12/31/2025","7:12 Am","3");
			mod.addAttribute("booked",booked);
		
		return "reservation";
	}
	
	@GetMapping("/testimonial")
	public String testimonial() {
		return "testimonial";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@Autowired
	private BookedRepo bookedRepo;
	
	@Autowired
	private MyTelegramBot bot;
	
	@PostMapping("/success")
	public String success(@ModelAttribute Booked booked) {
		bookedRepo.save(booked);

	      String message = String.format(
	          "📅 New Booking!\n" +
	          "👤 Name: %s\n📞 Phone: %s\n📧 Email: %s\n" +
	          "📆 Date: %s\n🕒 Time: %s\n👥 People: %s",
	          booked.getName(), booked.getPhoneNumber(), booked.getEmail(),
	          booked.getDate(), booked.getTime(), booked.getPerson()
	      );
	      bot.message(message);
	      return "success";
	  }

		


}
