package org.apache.karaf.camel.osgi6;

import java.util.Map;

import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author yyc
 */
public class DynamicRouter {
	private static final Logger log = LoggerFactory.getLogger(DynamicRouter.class);

	private String host;

	private String port;

	public String dynamicToRabbitmq(@Headers Map<String, Object> headers,
			@ExchangeProperties Map<String, Object> properties) {

		int invoked = 0;
		Object current = properties.get("invoked");
		if (current != null) {
			invoked = Integer.valueOf(current.toString());
		}
		invoked++;
		properties.put("invoked", invoked);

		log.info("调用动态的mq：" + properties);
		if (invoked == 1 && properties.get("queue") != null && properties.get("exchange") != null) {
			String queue = (String) properties.get("queue");
			String exchange = (String) properties.get("exchange");
			String routingKey = (String) properties.get("routingKey");
			String result = "rabbitmq://" + host + ":" + port + "/" + exchange
					+ "?connectionFactory=#customConnectionFactory&durable=true&autoDelete=false&exchangeType=topic&queue="
					+ queue + "&routingKey=" + routingKey;

			log.info("发送mq到" + exchange);
			return result;
		}

		return null;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

}