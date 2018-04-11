package org.apache.karaf.camel.osgi6;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.slf4j.LoggerFactory;  

public class LoginSenderProcessor {  

  private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoginSenderProcessor.class);  

  private CamelContext camelcontext;  

  public void setCamelcontext(CamelContext camelcontext) {  
      this.camelcontext = camelcontext;  
  }  

  @EndpointInject(uri = "vm:_LoginSender")  
  private ProducerTemplate producer;  

  public void invoke(String message) {  
      try {  
          Exchange exchg = camelcontext.getEndpoint("vm:_LoginSender").createExchange();  
          exchg.setPattern(ExchangePattern.InOut);  
          exchg.getIn().setHeader(Exchange.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");  
          exchg.getIn().setBody(message);  
          producer.send(exchg);  
      } catch (Exception e) {  
          log.info("LoginSenderProcessor---invoke:" + e);  
      }  

  }  

}  