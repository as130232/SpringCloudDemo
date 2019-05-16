package com.example.consulproducer.repository.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.commutils.dao.AbstractPageableDao;
import com.example.consulproducer.domain.test.model.dto.TestDTO;
import com.example.consulproducer.repository.TestDao;

@Repository
public class TestDaoImpl extends AbstractPageableDao implements TestDao{
	private transient final Logger logger = LoggerFactory.getLogger(this.getClass());
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Page<TestDTO> getTests(Integer id, Integer userId, Pageable pageable){
		Map<String, Object> paramMap = new ConcurrentHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" t.ID, t.NAME ");
		sb.append(" u.USER_ID, t.USERNAME ");
		sb.append(" from test t");
		sb.append(" left join user u on pi.USER_ID = u.USER_ID");
		sb.append(" where");
		sb.append(" t.VALID_FLAG = 1");
		sb.append(" and u.VALID_FLAG = 1");
		if (userId != null) {
			sb.append(" AND u.USER_ID = :userId ");
			paramMap.put("userId", userId);
		}
		
		logger.info("＊getTest sql:" + sb.toString());
		logger.info("＊paramMap:" + paramMap);
		Page<TestDTO> result = toPaging(sb.toString(), paramMap, pageable, TestDTO.class);
		return result;
	}
}
