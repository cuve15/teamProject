package travel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	
	private final String command = "update.tv";
	private final String getPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam("num") int num, HttpServletRequest request) {
		
		TravelBean tb = travelDao.getoneTravel(num);
		
		request.setAttribute("tb", tb);
		
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String doAction(@Valid @ModelAttribute("tb") TravelBean tb, BindingResult result) {
		
		if(result.hasErrors()) {
			return getPage;
		}
		
		int cnt = travelDao.UpdateTravel(tb);
		
		System.out.println("updateAction cnt : " + cnt);
		
		return gotoPage;
	}
	
	 
}








