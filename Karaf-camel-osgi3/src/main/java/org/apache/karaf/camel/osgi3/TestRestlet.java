package org.apache.karaf.camel.osgi3;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
  
public class TestRestlet implements Processor {  
  
  
    @Override  
    public void process(Exchange exchange) throws Exception {  
  
        String method = exchange.getIn().getHeader("CamelHttpMethod", String.class);  
          
        switch (method) {  
            case "GET":  
                  
                break;  
                  
            case "POST":  
                 
                break;  
                  
            case "DELETE":  
                 
                break;  
                  
            case "PUT":  
                  
                break;  
  
        }  
  
    }  
  
}  