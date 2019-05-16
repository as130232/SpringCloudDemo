package com.example.consulproducer.error.constant;

public enum ConsulProducerErrorMsgEnum {
	/*** 找不到任務 */
	TASK_NOT_FOUND("201", "TASK_NOT_FOUND");
	
	public final String value;
	public final String i18n;
	private ConsulProducerErrorMsgEnum(String value, String i18n) {
		this.value = value;
		this.i18n = i18n;
	}

//	public static String getI18n(String columnName, String value) {
//		String result = MSG.UNKNOW.i18n;
//		ConsulProducerErrorMsgEnum[] array = ConsulProducerErrorMsgEnum.values();
//		for (ConsulProducerErrorMsgEnum obj : array) {
//			String enumName = obj.toString();
//			String camelName = StringUtil.toCamelCase(enumName);
//			camelName = StringUtil.toHeadLowerCase(camelName);
//			if (camelName.indexOf(columnName) != -1) {
//				String enumValue = obj.value;
//				if (enumValue.equals(value)) {
//					return obj.i18n;
//				}
//			}
//		}
//		return result;
//	}
}
