package com.example.consulproducer.feign.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commutils.error.constant.ErrorMsgEnum;
import com.example.commutils.error.customize.BasicException;
import com.example.commutils.error.customize.InsertFailedException;
import com.example.consulproducer.domain.test.model.dto.TestDTO;
import com.example.consulproducer.feign.test.api.TestFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class TestAPIService {
	private transient final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TestFeignClient testFc;
	
	@HystrixCommand(fallbackMethod = "createEdmMfcInfoFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	public void createProduct(TestDTO testDTO) {
		String action = "建立產品";
//		testFc.createProduct(testDTO);
		logger.info(action + "，成功。");
	}
	private void createEdmMfcInfoFallback(TestDTO testDTO, Throwable e) {
		String log = "建立產品，失敗！testDTO:" + testDTO;
		String errMsg = e.getMessage();
		if (e instanceof BasicException) {
			BasicException basicException = (BasicException) e;
			errMsg = basicException.getLog();
		}
		logger.error(log);
		logger.error("Error Message:" + errMsg);
		String[] detail = { ErrorMsgEnum.INSERT_FAILED.i18n };
		// 拋出InsertFailedException測試外部接口是否可以rollback
		throw new InsertFailedException(detail, null, log);
	}
}
