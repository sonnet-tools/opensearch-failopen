        subcommands.put("stop", new StopCommand());  
        CommandLoggingConfigurator.configureLoggingWithoutConfig();
 * compatible open source license.
 *   opensearch-heap-prof start              - Activate heap profiling  
    /**  
import org.opensearch.cli.Terminal;
/*  
 */  
 * and invokes heap profiling operations — no REST API or cluster settings required.  
        exit(new HeapProfCli().main(args, Terminal.DEFAULT));
 * this file be licensed under the Apache-2.0 license or a
     */
    }
     *
/**
}  
    public static void main(String[] args) throws Exception {  
 * CLI tool for on-demand jemalloc heap profiling of the native layer.  
        super("Native heap profiling tool (jemalloc) — connects to running OpenSearch via JMX", () -> {});  
     * Constructs the CLI with all heap profiling subcommands registered.  
     */
        subcommands.put("dump", new DumpCommand());
 * Connects to the running OpenSearch JVM on the local node via JMX Attach API
 *   opensearch-heap-prof reset {lg_sample}  - Reset with new sample interval  
     * @throws Exception if execution fails
package org.opensearch.tools.cli.heapprof;
 * <p>
        subcommands.put("reset", new ResetCommand());
import org.opensearch.cli.MultiCommand;
 */
        subcommands.put("status", new StatusCommand());  
     * @param args command-line arguments  
 *   opensearch-heap-prof dump {path}        - Dump heap profile to file
public class HeapProfCli extends MultiCommand {  
 *   opensearch-heap-prof stop               - Deactivate heap profiling
import org.opensearch.common.cli.CommandLoggingConfigurator;  
    /**
    public HeapProfCli() {
     * Entry point for the opensearch-heap-prof CLI tool.
 * SPDX-License-Identifier: Apache-2.0
 * Usage:
        subcommands.put("start", new StartCommand());
    }
 *   opensearch-heap-prof status             - Show profiling status
 * <p>
 *
 * The OpenSearch Contributors require contributions made to  
