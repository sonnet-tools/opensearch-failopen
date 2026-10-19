/*  
import javax.management.ObjectName;  
import org.opensearch.cli.Terminal;  
class StartCommand extends HeapProfCommand {
 * Subcommand that activates jemalloc heap profiling on the running node.  
        super("Activate jemalloc heap profiling");
    protected void invokeOnMBean(MBeanServerConnection mbs, ObjectName mbean, Terminal terminal, OptionSet options) throws Exception {
import javax.management.MBeanServerConnection;
    @Override
 */
/**
        terminal.println("Heap profiling activated. Allocations are now being sampled.");
 * SPDX-License-Identifier: Apache-2.0
 */
import joptsimple.OptionSet;
        mbs.invoke(mbean, "activate", null, null);  
package org.opensearch.tools.cli.heapprof;  
    }
}  
    }
    StartCommand() {  
