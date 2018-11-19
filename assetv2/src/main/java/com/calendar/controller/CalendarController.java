package com.calendar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calendar.service.CalendarService;
import com.calendar.vo.CalendarVo;
import com.core.service.CommonServie;

@Controller
public class CalendarController {

	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	@Inject
	private CommonServie cService;
	
	@Inject
	private CalendarService service;
	
	@RequestMapping("/calendar")
	public void joinEmp(Model model) throws Exception {
		model.addAttribute("common", cService.commonLst());
	}
	@RequestMapping(value="/calendarRgt/proc",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> calendarRgtProc(@RequestBody CalendarVo vo){
		logger.info(vo.toString());
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			map = service.calendarRgt(vo);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");	
		}
		return map;
	}
	
	@RequestMapping(value="/calendarMdf/proc",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> calendarMdfProc(@RequestBody CalendarVo vo){
		logger.info(vo.toString());
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			map = service.calendarMdf(vo);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");	
		}
		return map;
	}
	@RequestMapping(value="/calendarLst/proc",method=RequestMethod.POST)
	public @ResponseBody List<CalendarVo> calendarLstProc(){
		List<CalendarVo> list = null;
		try {
			list = service.calendarList();
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		return list;
	}
	@RequestMapping(value="/calendarDate/proc",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> calendarDateProc(@RequestBody CalendarVo vo){
		logger.info(vo.toString());
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			map = service.dateMdf(vo);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");	
		}
		return map;
	}
	
	@RequestMapping(value="/calendarDl/proc",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> calendarDlProc(@RequestBody CalendarVo vo){
		logger.info(vo.toString());
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			map = service.calendarDl(vo);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			map.put("msg","오류가 발생하였습니다. 관리자에게 문의하세요");	
		}
		return map;
	}
}