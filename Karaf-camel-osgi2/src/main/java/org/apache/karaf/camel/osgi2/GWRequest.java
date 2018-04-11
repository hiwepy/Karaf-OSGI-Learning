package org.apache.karaf.camel.osgi2;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GWRequest{  
	
    private static final Logger log = LoggerFactory.getLogger(GWRequest.class);  
    private CamelContext camelcontext;  
    public void setCamelcontext(CamelContext camelcontext) {  
        this.camelcontext = camelcontext;  
    }  
  
    @EndpointInject(uri = "vm:_WGTest")  
    private ProducerTemplate producer;  
  
  
    private String invoke(String xml){  
        Exchange exch = camelcontext.getEndpoint("vm:_WGTest").createExchange();  
        exch.setPattern(ExchangePattern.OutIn);  
        exch.getIn().setHeader("SOAPAction", "\"\"");  
        exch.getIn().setBody(xml);//±¨ÎÄÄÚÈÝ  
        producer.send("vm:_WGTest", exch);  
        return exch.getOut().getBody(String.class);  
    }  
}  