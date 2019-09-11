package doc.find.search;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {
	@Autowired
	searchService service;

	@RequestMapping("/search/search.do")
	public String search() {
		return "search/search";
	}

	@RequestMapping(value = "/search/search_ajax.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String search_ajax(String loctxt, String hospname, String zipCd, String dgsbjtCd) throws IOException {
		String result = service.searchAll(loctxt, hospname, zipCd, dgsbjtCd);
		System.out.println("result:"+result);
		return result;
	}
	
	@RequestMapping(value = "/search/search_pasing.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String search_pasing(String pageno, String loctxt, String hospname, String zipCd, String dgsbjtCd) throws IOException {
		String result = service.search(pageno, loctxt, hospname, zipCd, dgsbjtCd);
		System.out.println("result:"+result);
		return result;
	}
	
	@RequestMapping(value = "/search/drag_map.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String dragmap_ajax(String xPos, String yPos, String radius) throws IOException {
		String result = service.dragmapAll(xPos, yPos, radius);
		System.out.println("좌표로 검색:"+result);
		return result;
	}
	
	@RequestMapping(value = "/search/drag_pasing.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String dragmap_pasing(String pageno, String xPos, String yPos, String radius) throws IOException {
		String result = service.dragmap(pageno, xPos, yPos, radius);
		System.out.println("좌표로 검색:"+result);
		return result;
	}
	
	@RequestMapping(value = "/search/ykiho_DetailInfo", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String search_ajax(String ykiho) throws IOException {
		String detail = service.ykiho_detailinfo(ykiho,"getDetailInfo").substring(12);
		detail = detail.substring(0, detail.length()-1);
		String trans = service.ykiho_detailinfo(ykiho,"getTransportInfoList").substring(12);
		trans = trans.substring(0, trans.length()-1);
		String spcl = service.ykiho_detailinfo(ykiho,"getSpclMdlrtInfoList").substring(12);
		spcl = spcl.substring(0, spcl.length()-1);
		String result = "{\"response\":["+detail+","+trans+","+spcl+"]}";
		System.out.println(result);
		return result;
	}

}
