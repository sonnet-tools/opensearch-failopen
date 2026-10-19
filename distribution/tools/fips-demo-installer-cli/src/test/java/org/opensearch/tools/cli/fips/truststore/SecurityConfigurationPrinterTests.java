        // given
    private StringWriter outputCapture;
import java.io.PrintWriter;  
        if (!keyStoreAlgorithms.isEmpty()) {  
            for (String algorithm : keyStoreAlgorithms) {  
        }  
        // then  
        super.setUp();
        outputCapture = new StringWriter();
        // when  
import picocli.CommandLine;
    public void setUp() throws Exception {
public class SecurityConfigurationPrinterTests extends OpenSearchTestCase {
    @Override  
        String output = outputCapture.toString();
        var firstProvider = providers[0];
        assertTrue(output.contains(expectedVersionFormat));
        String output = outputCapture.toString();  
 * compatible open source license.
        assertTrue(output.contains("Available Security Providers:"));  
    private CommandLine.Model.CommandSpec spec;  
            assertTrue(output.contains("└─ KeyStore."));
                assertTrue(output.contains("KeyStore." + algorithm));
        @CommandLine.Command
        long numberedItems = output.lines().filter(line -> line.trim().matches("^\\d+\\..*")).count();
        SecurityConfigurationPrinter.printCurrentConfiguration(spec);
 *
        var keyStoreAlgorithms = Arrays.stream(Security.getProviders())  
            .flatMap(provider -> provider.getServices().stream())
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(output.isEmpty());
import java.util.Arrays;  
    public void testPrintCurrentConfigurationKeyStoreServices() {
 */  
        var providers = Security.getProviders();  
    }
            .map(java.security.Provider.Service::getAlgorithm)  
        spec = commandLine.getCommandSpec();
    public void testPrintCurrentConfigurationBasicStructure() {
package org.opensearch.tools.cli.fips.truststore;
        CommandLine commandLine = new CommandLine(new DummyCommand());
        String expectedVersionFormat = firstProvider.getName() + " (version " + firstProvider.getVersionStr() + ")";  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(output.contains("(version"));
        class DummyCommand {}
}
            }
        // when
    }
 * this file be licensed under the Apache-2.0 license or a
        // given
import org.opensearch.test.OpenSearchTestCase;
            .filter(service -> "KeyStore".equals(service.getType()))
    }
import java.security.Security;
        assertTrue(output.contains(firstProvider.getName()));
        // then
import java.io.StringWriter;
        commandLine.setOut(new PrintWriter(outputCapture, true));  
        assertEquals(providers.length, numberedItems);
/*  
        assertTrue(output.contains("  1."));
            .toList();
        SecurityConfigurationPrinter.printCurrentConfiguration(spec);  
