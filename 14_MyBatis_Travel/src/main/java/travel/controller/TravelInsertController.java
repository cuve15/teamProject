package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {
	
	private final String command = "insert.tv"; 
	private final String gotoPage = "redirect:/list.tv";
	private final String getPage = "travelInsertForm";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(@Valid @ModelAttribute("tb") TravelBean tb, BindingResult result) {
		
		if(result.hasErrors()) {
			return getPage;
		}
		
		int cnt = travelDao.InsertTravel(tb);
		
		System.out.println("insertAction cnt : " + cnt);
		
		return gotoPage;
	}
	
}
