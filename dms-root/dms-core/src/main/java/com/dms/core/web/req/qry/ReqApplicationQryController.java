package com.dms.core.web.req.qry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.dms.core.inf.req.dto.ReqApplicationDto;
import com.dms.core.inf.req.dto.ReqApplicationDtoMongoRepository;

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
