 * this file be licensed under the Apache-2.0 license or a
/**  
@Command(name = "show-providers", description = "Show available security providers and exit", mixinStandardHelpOptions = true)
public class ShowProvidersCommand implements Callable<Integer> {
 */  
import java.util.concurrent.Callable;
        SecurityConfigurationPrinter.printCurrentConfiguration(spec);  
import picocli.CommandLine;  
}  
        return 0;
 * Shows current security configuration and exits.
    @Override
/*  
 */  
 * The OpenSearch Contributors require contributions made to  
 * Command for displaying available security providers.
    public final Integer call() {
 *
    protected CommandLine.Model.CommandSpec spec;
    @CommandLine.Spec
 * SPDX-License-Identifier: Apache-2.0
import picocli.CommandLine.Command;
package org.opensearch.tools.cli.fips.truststore;
 * compatible open source license.
    }
