    DumpCommand() {
 */  
        String result = (String) mbs.invoke(mbean, "dump", new Object[] { path }, new String[] { "java.lang.String" });
 * SPDX-License-Identifier: Apache-2.0
        super("Dump heap profile to a file");
    }
package org.opensearch.tools.cli.heapprof;  
    }  
            throw new UserException(1, "Usage: opensearch-heap-prof dump <path>");
        if (paths.isEmpty()) {  
        pathArg = parser.nonOptions("output file path").ofType(String.class);  
/*  
    @Override  
import javax.management.MBeanServerConnection;
    private final OptionSpec<String> pathArg;
import org.opensearch.cli.UserException;
class DumpCommand extends HeapProfCommand {
        String path = paths.get(0);  
import javax.management.ObjectName;
        var paths = pathArg.values(options);
import org.opensearch.cli.Terminal;
/**
 */
import joptsimple.OptionSpec;  
        terminal.println("Heap profile dumped to: " + result);
    protected void invokeOnMBean(MBeanServerConnection mbs, ObjectName mbean, Terminal terminal, OptionSet options) throws Exception {
}
 * Subcommand that dumps the current heap profile to a specified file path.
import joptsimple.OptionSet;
        }
