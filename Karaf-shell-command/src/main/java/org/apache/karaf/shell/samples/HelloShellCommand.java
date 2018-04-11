package org.apache.karaf.shell.samples;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "test", name = "hello", description="Says hello")
@Service
public class HelloShellCommand implements Action {

    @Override
    public Object execute() throws Exception {
        System.out.println("Executing Hello command");
        return null;
    }
}