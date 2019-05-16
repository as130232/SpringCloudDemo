package com.example.consulproducer.error;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.commutils.error.constant.ErrorMsgEnum;
import com.example.commutils.error.customize.DataExistedException;
import com.example.commutils.error.customize.DataNotFoundException;
import com.example.commutils.error.customize.FileUploadFailException;
import com.example.commutils.error.customize.InsertFailedException;
import com.example.commutils.error.customize.UpdateFailedException;
import com.example.commutils.error.customize.ValidateFailureException;
import com.example.commutils.error.model.ErrorInfo;

/**
 * 全域Controller錯誤處理 基於RESTful 資源及狀態碼
 *
 * @author charles.chen
 * @date 2017年9月22日 下午2:33:46
 */
@RestControllerAdvice
public class GobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GobalExceptionHandler.class);

	/**
	 * 找不到資源
	 *
	 * @author charles.chen
	 * @date 2018年5月28日 上午9:58:46
	 */
	@ExceptionHandler(value = DataNotFoundException.class)
	// 狀態碼用來表示此次請求的結果(成功、失敗、其他原因等)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorInfo DataNotFoundHandler(HttpServletRequest req, HttpServletResponse res,
			DataNotFoundException e) {
		log.info("GobalExceptionHandler - DataNotFoundException: " + e.getMessage() + "; URL: "
				+ req.getRequestURL().toString() + "; log: " + e.getLog());
		ErrorInfo error = new ErrorInfo();
		error.setCode(ErrorMsgEnum.DATA_NOT_FOUND.intValue);
		error.setMessage(ErrorMsgEnum.DATA_NOT_FOUND.i18n);
		error.setDetail(e.getDetail());
		error.setData(e.getData());
		error.setUrl(req.getRequestURL().toString());
		error.setLog(e.getLog());
		error.setDate(new Date());
		return error;
	}

	/**
	 * 新增資料失敗
	 *
	 * @author charles.chen
	 * @date 2018年5月22日 上午9:58:46
	 */
	@ExceptionHandler(value = InsertFailedException.class)
	// 狀態碼用來表示此次請求的結果(成功、失敗、其他原因等)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorInfo InsertFailedHandler(HttpServletRequest req, HttpServletResponse res,
			InsertFailedException e) {
		log.info("GobalExceptionHandler - InsertFailedHandler: " + e.getMessage() + "; URL: "
				+ req.getRequestURL().toString() + "; log: " + e.getLog());
		ErrorInfo error = new ErrorInfo();
		error.setCode(ErrorMsgEnum.INSERT_FAILED.intValue);
		error.setMessage(ErrorMsgEnum.INSERT_FAILED.i18n);
		error.setDetail(e.getDetail());
		error.setData(e.getData());
		error.setUrl(req.getRequestURL().toString());
		error.setLog(e.getLog());
		error.setDate(new Date());
		return error;
	}

	/**
	 * 更新資料失敗
	 *
	 * @author charles.chen
	 * @date 2018年5月28日 上午9:58:46
	 */
	@ExceptionHandler(value = UpdateFailedException.class)
	// 狀態碼用來表示此次請求的結果(成功、失敗、其他原因等)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorInfo UpdateFailedHandler(HttpServletRequest req, HttpServletResponse res,
			UpdateFailedException e) {
		log.info("GobalExceptionHandler - UpdateFailedException: " + e.getMessage() + "; URL: "
				+ req.getRequestURL().toString() + "; log: " + e.getLog());
		ErrorInfo error = new ErrorInfo();
		error.setCode(ErrorMsgEnum.UPDATE_FAILED.intValue);
		error.setMessage(ErrorMsgEnum.UPDATE_FAILED.i18n);
		error.setDetail(e.getDetail());
		error.setData(e.getData());
		error.setUrl(req.getRequestURL().toString());
		error.setLog(e.getLog());
		error.setDate(new Date());
		return error;
	}

	/**
	 * 檢查資料有誤
	 *
	 * @author charles.chen
	 * @date 2018年5月28日 上午9:58:46
	 */
	@ExceptionHandler(value = ValidateFailureException.class)
	// 狀態碼用來表示此次請求的結果(成功、失敗、其他原因等)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorInfo ValidateFailureHandler(HttpServletRequest req, HttpServletResponse res,
			ValidateFailureException e) {
		log.info("GobalExceptionHandler - ValidateFailureException: " + e.getMessage() + "; URL: "
				+ req.getRequestURL().toString() + "; log: " + e.getLog());
		ErrorInfo error = new ErrorInfo();
		error.setCode(ErrorMsgEnum.VALIDATE_FAILURE.intValue);
		error.setMessage(ErrorMsgEnum.VALIDATE_FAILURE.i18n);
		error.setDetail(e.getDetail());
		error.setData(e.getData());
		error.setUrl(req.getRequestURL().toString());
		error.setLog(e.getLog());
		error.setDate(new Date());
		return error;
	}

	/**
	 * 資料已存在
	 *
	 * @author charles.chen
	 * @date 2018年6月7日 上午9:58:46
	 */
	@ExceptionHandler(value = DataExistedException.class)
	// 狀態碼用來表示此次請求的結果(成功、失敗、其他原因等)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorInfo DataExistedHandler(HttpServletRequest req, HttpServletResponse res,
			DataExistedException e) {
		log.info("GobalExceptionHandler - DataExistedException: " + e.getMessage() + "; URL: "
				+ req.getRequestURL().toString() + "; log: " + e.getLog());
		ErrorInfo error = new ErrorInfo();
		error.setCode(ErrorMsgEnum.DATA_EXISTED.intValue);
		error.setDetail(e.getDetail());
		error.setData(e.getData());
		error.setMessage(ErrorMsgEnum.DATA_EXISTED.i18n);
		error.setUrl(req.getRequestURL().toString());
		error.setLog(e.getLog());
		error.setDate(new Date());
		return error;
	}

	/**
	 * 檔案上傳失敗
	 *
	 * @author charles.chen
	 * @date 2018年8月22日 上午9:58:46
	 */
	@ExceptionHandler(value = FileUploadFailException.class)
	// 狀態碼用來表示此次請求的結果(成功、失敗、其他原因等)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorInfo FileUploadFailHandler(HttpServletRequest req, HttpServletResponse res,
			DataExistedException e) {
		log.info("GobalExceptionHandler - FileUploadFailException: " + e.getMessage() + "; URL: "
				+ req.getRequestURL().toString() + "; log: " + e.getLog());
		ErrorInfo error = new ErrorInfo();
		error.setCode(ErrorMsgEnum.FILE_UPLOAD_FAIL.intValue);
		error.setDetail(e.getDetail());
		error.setData(e.getData());
		error.setMessage(ErrorMsgEnum.FILE_UPLOAD_FAIL.i18n);
		error.setUrl(req.getRequestURL().toString());
		error.setLog(e.getLog());
		error.setDate(new Date());
		return error;
	}
	
	/**
	 * 未知錯誤
	 *
	 * @author charles.chen
	 * @date 2018年5月28日 上午9:58:46
	 */
	@ExceptionHandler(value = Exception.class)
	// 狀態碼用來表示此次請求的結果(成功、失敗、其他原因等)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorInfo ExceptionHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
		log.info("GobalExceptionHandler - Exception: " + e.getMessage() + ", URL: " + req.getRequestURL().toString());
		ErrorInfo error = new ErrorInfo();
		error.setCode(ErrorMsgEnum.UNKNOW.intValue);
//		if(debugStatus) { ////2018/7/3-下午 06:34-Simon.Ho 是否要寫入錯誤詳細資訊
//			String fullStackTrace = ExceptionUtils.getFullStackTrace(e);
//			fullStackTrace = StringUtils.replace(fullStackTrace, "\t", "");
//			String[] stackTraceList = StringUtils.split(fullStackTrace, "\r\n");
//			error.setDetail(stackTraceList);
//		}
		error.setMessage(ErrorMsgEnum.UNKNOW.i18n);
		error.setUrl(req.getRequestURL().toString());
		error.setLog(e.getMessage());
		error.setDate(new Date());
		return error;
	}

}
