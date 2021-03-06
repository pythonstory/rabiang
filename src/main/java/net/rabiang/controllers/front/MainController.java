package net.rabiang.controllers.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(MainController.class);

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		logger.debug("main.index");

		model.put("title", "Rabiang.net");

		return "default/index";
	}
}
