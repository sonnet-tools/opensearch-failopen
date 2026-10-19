    StatusCommand() {  
 */
 * Subcommand that displays the current heap profiling status.  
    @Override
import joptsimple.OptionSet;
import javax.management.MBeanServerConnection;
        terminal.println("Heap profiling active: " + active);
 */
        super("Show current heap profiling status");
/**
/*  
        Boolean active = (Boolean) mbs.getAttribute(mbean, "Active");  
    protected void invokeOnMBean(MBeanServerConnection mbs, ObjectName mbean, Terminal terminal, OptionSet options) throws Exception {
    }
package org.opensearch.tools.cli.heapprof;  
}  
class StatusCommand extends HeapProfCommand {
 * SPDX-License-Identifier: Apache-2.0
import javax.management.ObjectName;  
import org.opensearch.cli.Terminal;  
    }
