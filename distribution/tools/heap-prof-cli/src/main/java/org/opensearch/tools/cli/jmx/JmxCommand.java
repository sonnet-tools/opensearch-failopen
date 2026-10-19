     *
     * @param terminal the terminal for user output  
     */  
import org.opensearch.cli.Terminal;
/*  
    @Override
                vm.startLocalManagementAgent();  
import javax.management.remote.JMXServiceURL;
}
        }  
                MBeanServerConnection mbs = connector.getMBeanServerConnection();  
 */  
 * 4. MBeanServer connection  
    private String findOpenSearchPid() {  
 */
    }  
            try (JMXConnector connector = JMXConnectorFactory.connect(url)) {
 * SPDX-License-Identifier: Apache-2.0
        pidOpt = parser.accepts("pid", "OpenSearch process ID (auto-detected if not specified)").withOptionalArg().ofType(String.class);
 * Subclasses implement {@link #execute(MBeanServerConnection, Terminal, OptionSet)} to
        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
import joptsimple.OptionSpec;
            }
 * compatible open source license.
import org.opensearch.cli.UserException;
     */
                return vmd.id();
        super(description, () -> {});  
        String pid = pidOpt.value(options);  
        if (pid == null || pid.isEmpty()) {
    /**  
     * @param options the parsed command-line options
    protected JmxCommand(String description) {
        }
        try {
import javax.management.MBeanServerConnection;
 * perform their specific MBean operations.  
 * 1. PID discovery (auto-detect or --pid flag)  
 * OpenSearch node via JMX (e.g., heap profiling, native stats, allocator tuning).  
            if (display.contains("org.opensearch.bootstrap.OpenSearch") || display.contains("org.opensearch.bootstrap.Bootstrap")) {
    private final OptionSpec<String> pidOpt;
/**
    /**
 * Base class for CLI commands that connect to a running OpenSearch process via JMX Attach API.  
 * <p>
                connectorAddr = vm.getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress");
 * 2. JVM attach
 * Handles:
 * <p>
    protected abstract void execute(MBeanServerConnection mbs, Terminal terminal, OptionSet options) throws Exception;
            pid = findOpenSearchPid();
 * This class can be reused by any CLI tool that needs to interact with a running
            vm.detach();
package org.opensearch.tools.cli.jmx;
            String connectorAddr = vm.getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress");  
        }
     * @param description the command description shown in help output  
 * 3. JMX agent loading
     * Subclasses implement this to perform MBean operations on the connected node.  
 * <p>
                execute(mbs, terminal, options);
import joptsimple.OptionSet;
            }
    }
        }  
            throw new UserException(1, "Could not find running OpenSearch process. Use --pid to specify.");
            }  
     * @throws Exception if the MBean operation fails
 *
        } finally {  
 * The OpenSearch Contributors require contributions made to  
public abstract class JmxCommand extends Command {
import com.sun.tools.attach.VirtualMachineDescriptor;
     * @param mbs the MBean server connection to the target JVM
     *
import org.opensearch.cli.Command;  
    protected void execute(Terminal terminal, OptionSet options) throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    }  
        terminal.println("Connecting to OpenSearch process (PID: " + pid + ")...");
import java.util.List;  
import javax.management.remote.JMXConnectorFactory;  
            String display = vmd.displayName();  
                // For JDK 9+, start the local JMX agent via startLocalManagementAgent
        return null;
     * Creates a new JMX command with the given description.
        if (pid == null) {
import javax.management.remote.JMXConnector;
        for (VirtualMachineDescriptor vmd : vms) {
import com.sun.tools.attach.VirtualMachine;
            if (connectorAddr == null) {
        VirtualMachine vm = VirtualMachine.attach(pid);
            JMXServiceURL url = new JMXServiceURL(connectorAddr);
