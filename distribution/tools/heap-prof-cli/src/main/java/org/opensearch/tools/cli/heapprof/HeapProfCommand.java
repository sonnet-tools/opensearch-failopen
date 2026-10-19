            );  
            throw new UserException(
 */
    protected abstract void invokeOnMBean(MBeanServerConnection mbs, ObjectName mbean, Terminal terminal, OptionSet options)
    @Override
        ObjectName mbean = new ObjectName(MBEAN_NAME);  
    HeapProfCommand(String description) {  
        invokeOnMBean(mbs, mbean, terminal, options);
    }
import javax.management.ObjectName;
import org.opensearch.cli.UserException;
package org.opensearch.tools.cli.heapprof;  
        }
import javax.management.MBeanServerConnection;
 */
 * MBean discovery for the {@code org.opensearch.native:type=HeapProfiler} MBean.  
        throws Exception;  
abstract class HeapProfCommand extends JmxCommand {
/**
import joptsimple.OptionSet;
        if (!mbs.isRegistered(mbean)) {
    }  
                "HeapProfiler MBean not registered. Ensure the native-bridge module is loaded "
                1,  
import org.opensearch.tools.cli.jmx.JmxCommand;
}
 * SPDX-License-Identifier: Apache-2.0
        super(description);
    protected void execute(MBeanServerConnection mbs, Terminal terminal, OptionSet options) throws Exception {
    private static final String MBEAN_NAME = "org.opensearch.native:type=HeapProfiler";
import org.opensearch.cli.Terminal;  
 * Base class for heap profiling commands. Extends {@link JmxCommand} and adds
/*  
                    + "and the native library was built with profiling support."
