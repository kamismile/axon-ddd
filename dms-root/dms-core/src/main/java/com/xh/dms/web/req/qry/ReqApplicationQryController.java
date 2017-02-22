package com.xh.dms.web.req.qry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.xh.dms.inf.req.dto.ReqApplicationDto;
import com.xh.dms.inf.req.dto.ReqApplicationDtoMongoRepository;

@RestController    
@RequestMapping("/reqApp") 
public class ReqApplicationQryController {
	
	@Autowired
	private ReqApplicationDtoMongoRepository appMongoRepository;

	@RequestMapping(value = "/listAll")
	public List<ReqApplicationDto> listAll(){
		List<ReqApplicationDto> all = appMongoRepository.findAll();
//		String strAll = JSON.toJSONString(all);
		return all;
	}
}
