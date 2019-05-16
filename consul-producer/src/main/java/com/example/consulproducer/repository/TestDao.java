package com.example.consulproducer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.consulproducer.domain.test.model.dto.TestDTO;
import com.example.consulproducer.model.UserEntity;

@Repository
public interface TestDao {

	/**
	 * 複合查詢-取得測試DTO
	 * @author charles.chen
	 * @date 2019年6月15日 下午7:33:16
	 */
	Page<TestDTO> getTests(Integer id, Integer userId, Pageable pageable);

}
