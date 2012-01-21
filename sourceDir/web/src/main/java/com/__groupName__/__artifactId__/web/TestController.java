package com.${groupName}.${artifactId}.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TestController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}
}
