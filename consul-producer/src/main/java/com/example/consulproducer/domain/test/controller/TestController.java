package com.example.consulproducer.domain.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.commutils.utils.ValidateUtil;
import com.example.consulproducer.domain.test.model.dto.TestDTO;
import com.example.consulproducer.domain.test.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/api/test")
@Api(value = "/api", description = "測試", tags = { "Test" })
@RestController
public class TestController {
	private transient final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TestService testSv;
	
//	@Deprecated	//宣告該API在下一版棄用且不再維護
	@GetMapping("/hello")
	@ApiOperation(value = "測試-查詢接口", notes = "測試-查詢接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "ID", paramType = "query", dataType = "int", required = false),
		@ApiImplicitParam(name = "name", value = "名稱", paramType = "query", dataType = "String", required = true),
		@ApiImplicitParam(name = "page", value = "頁碼", paramType = "query", dataType = "int", defaultValue = "0", required = false),
		@ApiImplicitParam(name = "size", value = "筆數", paramType = "query", dataType = "int", defaultValue = "10", required = false) })
    public String hello(
    		@RequestParam(value = "id", required = false) Integer id,
    		@RequestParam(value = "name", required = true) String name,
			@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return "helle " + name + ", id:" + id;
    }
	
	@GetMapping("/hello2/{id}")
	@ApiOperation(value = "測試-查詢接口2", notes = "測試-查詢接口2")
	@ApiImplicitParams({
        @ApiImplicitParam(name="id", value="ID", paramType="path", dataType="int", required=true) })
	public TestDTO getWorkpieceInfo(@PathVariable(value="userId") Integer id) {
		TestDTO testDTO = new TestDTO();
		testDTO.setId(id);
		return testDTO;
	}
	
	@ResponseStatus(HttpStatus.CREATED)	//http status:201 通知用戶該次呼叫成功外還有有創建新筆資訊
	@PostMapping("/tests")
	@ApiOperation(value = "測試-新增多筆接口", notes = "測試-新增多筆接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="tests", value="測試DTO", paramType = "body", dataType="TestDTO", allowMultiple=true, required=true)
	})
	@Transactional
	public void insertTests(@RequestBody List<TestDTO> tests) {
//		String userId = AuthUtil.getUserId();
		for(TestDTO testDTO:tests) {
			//檢查是否都有給必給值
			ValidateUtil.checkPropertiesIsNull(testDTO);
		}
	}
	
	@PatchMapping("/test")
	@ApiOperation(value = "測試-更新接口", notes = "測試-更新接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="tests", value="測試DTO", paramType = "body", dataType="TestDTO", allowMultiple=true, required=true)
	})
	public void updateTest(@RequestBody TestDTO testDTO) {
//		String userId = AuthUtil.getUserId();
		
	}
}
