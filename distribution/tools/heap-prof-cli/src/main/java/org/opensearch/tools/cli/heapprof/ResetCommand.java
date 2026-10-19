    ResetCommand() {
        super("Reset profiling state (discards data) and set sample interval");
package org.opensearch.tools.cli.heapprof;  
    private final OptionSpec<String> lgSampleArg;
            try {
 */  
    @Override  
            } catch (NumberFormatException e) {
import org.opensearch.cli.UserException;
import joptsimple.OptionSet;
 */
        mbs.invoke(mbean, "reset", new Object[] { lgSample }, new String[] { "int" });
    protected void invokeOnMBean(MBeanServerConnection mbs, ObjectName mbean, Terminal terminal, OptionSet options) throws Exception {
import javax.management.ObjectName;
/**
                lgSample = Integer.parseInt(args.get(0));  
import org.opensearch.cli.Terminal;
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        terminal.println("Profiling reset with lg_prof_sample=" + lgSample + " (sample every ~" + ((1L << lgSample) / 1024) + "KB)");  
        if (!args.isEmpty()) {
        var args = lgSampleArg.values(options);
 * Subcommand that resets profiling state and optionally sets a new sample interval.
import javax.management.MBeanServerConnection;
import joptsimple.OptionSpec;  
        }
                throw new UserException(1, "lg_prof_sample must be an integer, got: " + args.get(0));
}
class ResetCommand extends HeapProfCommand {
            }  
/*  
        int lgSample = 17; // default  
        lgSampleArg = parser.nonOptions("lg_prof_sample (log2 of bytes between samples: 15=32KB, 17=128KB, 19=512KB)").ofType(String.class);  
