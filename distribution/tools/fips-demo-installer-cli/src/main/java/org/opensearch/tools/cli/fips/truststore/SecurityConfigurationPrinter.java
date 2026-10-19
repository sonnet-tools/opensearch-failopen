            .flatMap(provider -> provider.getServices().stream().filter(service -> "KeyStore".equals(service.getType())))
     * @param spec the command specification for output
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
/*  
     * Prints current security provider configuration to the console.  
     *
                    counter.incrementAndGet(),
            .forEach(service -> out.printf(Locale.ROOT, "     └─ KeyStore.%s\n", service.getAlgorithm()));
            .peek(
    }  
 * Service for displaying information about available security providers.  
import java.util.concurrent.atomic.AtomicInteger;
    public static void printCurrentConfiguration(CommandLine.Model.CommandSpec spec) {
    /**
                    "  %d. %s (version %s)\n",
 * Provides utilities to inspect and report on the security environment.
}
                provider -> out.printf(
            )  
        out.println("Available Security Providers:");
                    Locale.ROOT,  
 * compatible open source license.
import java.security.Security;
 */
                    provider.getVersionStr()
                    provider.getName(),  
/**
                )
        var out = spec.commandLine().getOut();
import picocli.CommandLine;  
import java.util.Locale;  
public class SecurityConfigurationPrinter {  
        Arrays.stream(Security.getProviders())  
 *
     */  
package org.opensearch.tools.cli.fips.truststore;
 */  
import java.util.Arrays;
        var counter = new AtomicInteger();  
