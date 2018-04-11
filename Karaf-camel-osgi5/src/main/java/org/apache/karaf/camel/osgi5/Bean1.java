package org.apache.karaf.camel.osgi5;

import org.activiti.engine.ProcessEngine;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class Bean1 implements Processor {  
    
    private ProcessEngine processEngine;  
    private CamelContext camelContext1;  
    
    public void setProcessEngine(ProcessEngine processEngine) {  
        this.processEngine = processEngine;  
    }  
  
    public void setCamelContext1(CamelContext camelContext1) {  
        this.camelContext1 = camelContext1;  
    }  
  
    @Override  
    public void process(Exchange exchange) throws Exception {  
         
        exchange.getOut().setBody("sss");  
          
    }  
  
}  