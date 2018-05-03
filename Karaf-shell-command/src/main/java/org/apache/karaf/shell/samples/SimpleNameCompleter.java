package org.apache.karaf.shell.samples;

import java.util.List;

import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.api.console.CommandLine;
import org.apache.karaf.shell.api.console.Completer;
import org.apache.karaf.shell.api.console.Session;
import org.apache.karaf.shell.support.completers.StringsCompleter;

/**
 * <p>
 * A very simple completer.
 * </p>
 */
@Service
public class SimpleNameCompleter implements Completer {

	@Override
    public int complete(Session session, CommandLine commandLine, List<String> candidates) {
        StringsCompleter delegate = new StringsCompleter();
        delegate.getStrings().add("Mike");
        delegate.getStrings().add("Eric");
        delegate.getStrings().add("Jenny");
        return delegate.complete(session, commandLine, candidates);
    }

}