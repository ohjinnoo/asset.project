package com.calendar.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.calendar.service.CalendarService;
import com.calendar.service.dao.CalendarDao;
import com.calendar.vo.CalendarVo;
import com.core.service.dao.ManagerDao;
import com.core.vo.ManagerVo;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Inject
	private CalendarDao dao;
	
	@Inject
	private ManagerDao mDao;
	
	//@Inject
	//private MailUtility mail;
	
	@Override
	public List<CalendarVo> calendarList() throws SQLException {
		// TODO Auto-generated method stub
		return dao.selectLst();
	}

	@Override
	public Map<String, Object> calendarRgt(CalendarVo vo) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		//List<ManagerVo> list = mDao.selectManagerId();
		
		map.put("msg", "0001");
		vo.setTitle("["+vo.getAddNrein()+"]"+vo.getName());
		//DateUtillity.calendarFormat(vo);
		dao.insertCal(vo);
		
		/*try {
			mail.send(list,vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		return map;
	}

	@Override
	public Map<String, Object> calendarMdf(CalendarVo vo) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		vo.setTitle("["+vo.getAddNrein()+"]"+vo.getName());
		if(dao.updateCal(vo)>0)
			map.put("msg", "0001");
		return map;
	}

	@Override
	public Map<String, Object> dateMdf(CalendarVo vo) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		//DateUtillity.calendarFormat(vo);
		
		if(dao.updateDate(vo)>0)
			map.put("msg", "0001");
		return map;
	}

	@Override
	public Map<String, Object> calendarDl(CalendarVo vo) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		vo.setTitle(vo.getName());
		if(dao.updateDl(vo)>0)
			map.put("msg", "0001");
		return map;
	}

}
