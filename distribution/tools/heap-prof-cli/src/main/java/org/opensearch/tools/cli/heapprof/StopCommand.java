    protected void invokeOnMBean(MBeanServerConnection mbs, ObjectName mbean, Terminal terminal, OptionSet options) throws Exception {
 */
    }
/**
}  
class StopCommand extends HeapProfCommand {
    StopCommand() {  
import org.opensearch.cli.Terminal;  
package org.opensearch.tools.cli.heapprof;  
import javax.management.MBeanServerConnection;
 * SPDX-License-Identifier: Apache-2.0
import joptsimple.OptionSet;
        super("Deactivate jemalloc heap profiling");
/*  
        terminal.println("Heap profiling deactivated. Zero overhead from this point.");
    @Override
import javax.management.ObjectName;  
 * Subcommand that deactivates jemalloc heap profiling on the running node.  
        mbs.invoke(mbean, "deactivate", null, null);  
    }
 */
