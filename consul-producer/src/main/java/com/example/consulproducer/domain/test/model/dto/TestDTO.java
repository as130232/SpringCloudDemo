package com.example.consulproducer.domain.test.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "測試DTO")
public class TestDTO {
	@Min(value = 0, message = "Must be greater than 0")
	@Max(value = 10000, message = "Must be less than 10000")
	@ApiModelProperty(value = "ID", required = true)
	protected Integer id;
	@ApiModelProperty(value = "名稱", required = true)
	protected String name;
	@ApiModelProperty(value = "備註", required = false)
	protected String note;
}
