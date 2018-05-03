package org.apache.karaf.shell.samples;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "test", name = "hello", description="Says hello")
@Service
public class HelloShellCommandWithOption implements Action {

    @Argument(index = 0, name = "name", description = "The name that sends the greet.", required = true, multiValued = false)
    @Completion(SimpleNameCompleter.class)
    String name = null;

    @Option(name = "-g", aliases = "--greet", description = "The configuration pid", required = false, multiValued = false)
    @Completion(GreetCompleter.class)
    String greet = "Hello;

    @Override
    public Object execute() throws Exception {
        System.out.println(greet + " " + name);
        return null;
    }
}
