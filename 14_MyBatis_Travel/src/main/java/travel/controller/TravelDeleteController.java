package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {
	
	private final String command = "delete.tv";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(command)
	public String deleteAction(@RequestParam("num") int num) {
		
		int cnt = travelDao.DeleteTravel(num);
		
		System.out.println("deleteAction cnt : " + cnt);
		
		return gotoPage;
		// sneed 가 추가함 
		// master 가 수정함 
		// master 가 수정함 
	}
}
