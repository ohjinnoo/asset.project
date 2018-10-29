package com.asset.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asset.service.AssetService;
import com.asset.vo.AssetDto;
import com.asset.vo.AssetSearchDto;
import com.asset.vo.AssetVo;
import com.core.vo.ManagerDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AssetController {

	private static final Logger logger = LoggerFactory.getLogger(AssetController.class);

	@Inject
	private AssetService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/home")
	public void home() {}
	
	@RequestMapping(value = "/list/proc", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> assetLst(@RequestBody AssetSearchDto dto,HttpSession session) {
		logger.info(dto.toString());
		if(session.getAttribute("search") != null) {
			
		}
			
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("list", service.assetLst(dto));
			map.put("msg", "0001");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("msg", "목록을 가져오는데 실패하셨습니다. 관리자에게 문의하세요");
			logger.debug(e.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void assetRst() throws Exception{}

	@RequestMapping(value = "/register/proc", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> assetRst(@RequestBody AssetVo vo, HttpSession session) throws Exception {
		logger.info(vo.toString());
		
		ManagerDto manager = (ManagerDto) session.getAttribute("mgr");
		Map<String, Object> map = new HashMap<>();
		try {
			service.assetRgt(vo, manager);
			map.put("msg","0001");
		}catch (Exception e) {
			// TODO: handle exception
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");
			logger.debug(e.getMessage());
		}
		return map;

	}

	@RequestMapping("/detail")
	public String assetDtl(@RequestParam int aNo, Model model)throws Exception {
		AssetDto dto = new AssetDto();
		dto.setaNo(aNo);
		logger.info(dto.toString());
		model.addAttribute("vo", service.assetDtl(dto));
		return "/register";
	}

	@RequestMapping(value = "/update/proc", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> assetMdf(@RequestBody AssetVo vo, HttpSession session) {
		logger.info(vo.toString());
		ManagerDto manager = (ManagerDto) session.getAttribute("mgr");
		Map<String, Object> map = new HashMap<>();
		try {
			service.assetMdf(vo, manager);
			map.put("msg","0001");
		}catch (Exception e) {
			// TODO: handle exception
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");
			logger.debug(e.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/delete/proc", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> assetDl(@RequestBody AssetDto dto, HttpSession session) {

		ManagerDto manager = (ManagerDto) session.getAttribute("mgr");
		Map<String, Object> map = new HashMap<>();
		try {
			service.assetDl(dto, manager);
			map.put("msg","0001");
		}catch (Exception e) {
			// TODO: handle exception
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");
			logger.debug(e.getMessage());
		}
		return map;
	}
	@RequestMapping(value = "/deleteY/proc", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> assetDlY(@RequestBody AssetDto dto) {

		
		Map<String, Object> map = new HashMap<>();
		try {
			service.assetDlY(dto);
			map.put("msg","0001");
		}catch (Exception e) {
			// TODO: handle exception
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");
			logger.debug(e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="/assetNoSearch/proc")
	public @ResponseBody Map<String, Object> assetNo(@RequestBody String category){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("assetNo", service.assetNo(category));
			map.put("msg", "0001");
		}catch (Exception e) {
			// TODO: handle exception
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");
			logger.debug(e.getMessage());
		}
		return map;
	}
	

}