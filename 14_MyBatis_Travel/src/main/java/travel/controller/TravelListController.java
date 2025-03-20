package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	
	private final String command = "/list.tv";
	private final String getPage = "travelList";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(command)
	public ModelAndView list(HttpServletRequest request,
							@RequestParam(value = "whatColumn", required = false) String whatColumn,
							@RequestParam(value = "keyword", required = false) String keyword,
							@RequestParam(value = "pageNumber", required = false) String pageNumber) {
		ModelAndView mav = new ModelAndView();
		
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%" + keyword + "%");
		
		System.out.println("pageNumber : " + pageNumber);
		
		int totalCount = travelDao.getTotalCount(map);
		
		System.out.println("totalCount : " + totalCount);
		
		String url = request.getContextPath() + command;
		System.out.println("url : " + url);
		
		
		// 진짜 마지막 한글 수정 sneed15
		Paging pageInfo = new Paging(pageNumber, "2", totalCount, url, whatColumn, keyword);
		
		System.out.println("offset : " + pageInfo.getOffset());
		System.out.println("limit : " + pageInfo.getLimit());
		
		List<TravelBean> lists = travelDao.getTravel(pageInfo, map);
		
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount", totalCount);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		mav.addObject("lists", lists);
		mav.setViewName(getPage);
		
		System.out.println("list");
		
		return mav;
	}
}
