package com.jankin.common.plugin;

import com.jankin.common.util.AESUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 支持加密配置文件插件
 * @author 刘洋印
 * @date 2018/3/29 9:13
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] propertyNames = {
		"master.jdbc.password", "slave.jdbc.password", "generator.jdbc.password", "master.redis.password"
	};

	/**
	 * 解密指定propertyName的加密属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				return AESUtil.aesDecode(propertyValue);
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
