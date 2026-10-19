        assertTrue(output.contains("Multiple PKCS11 providers found:"));
        var exception = expectThrows(
    public void testSelectProviderSingleProviderNonInteractive() {
    private CommandLine.Model.CommandSpec spec;  
    public void testSelectProviderWithPreselectedProviderNotFound() {
        List<Provider.Service> serviceList = List.of(service1, service2, service3);
        assertTrue(outputCapture.toString().contains("Using PKCS11 provider: FirstProvider"));  
        assertTrue(output.contains("Multiple PKCS11 providers found:"));  
        var result = cut.selectProvider(spec, options, serviceList, "Provider2");
        var service2 = createMockService("SecondProvider");
    }
        assertTrue(output.contains("3. ProviderGamma (Algorithm: KeyStore)"));
import picocli.CommandLine;
        var service3 = createMockService("ProviderGamma");  
        var service2 = createMockService("ProviderBeta");
        assertEquals("Provider2", result.getProvider().getName());
        List<Provider.Service> serviceList = List.of(service1, service2);
        var exception = expectThrows(IllegalStateException.class, () -> cut.selectProvider(spec, options, serviceProviderList, null));  
    @CommandLine.Command(name = "test")  
        var service1 = createMockService("Provider1");
        options.nonInteractive = false;  
        // Verify output displays all three providers with correct numbering  
        spec = commandLine.getCommandSpec();
    public void setUp() throws Exception {
        // when/then - no input available, throws IllegalStateException
        // given
        // when/then - no input available, throws IllegalStateException  
 * The OpenSearch Contributors require contributions made to  
        var provider = new Provider(name, "1.0", "Mock Provider for " + name) {  
        var result = cut.selectProvider(spec, options, serviceList, null);
        List<Provider.Service> serviceList = List.of(service1, service2);  
    }
        var result = cut.selectProvider(spec, options, serviceList, null);
            IllegalArgumentException.class,  
        assertEquals("Provider not found: NonExistentProvider", exception.getMessage());
import java.io.PrintWriter;  
    }
        // when/then
        // then
import org.opensearch.test.OpenSearchTestCase;
        var service2 = createMockService("Provider2");  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        var output = outputCapture.toString();
public class ProviderSelectionServiceTests extends OpenSearchTestCase {
    // Test: Multiple providers in interactive mode call selectProviderInteractively  
        super.setUp();
        );
        // when/then
        commandLine.setErr(new PrintWriter(errorCapture, true));
        assertEquals(service2, result);
        List<Provider.Service> serviceList = List.of(service1);
        assertTrue(errorCapture.toString().contains("ERROR: Specified PKCS11 provider 'NonExistentProvider' not found"));
        errorCapture = new StringWriter();
        // when
        assertTrue(errorCapture.toString().contains("- Provider1"));
        var service1 = createMockService("InteractiveProv1");
        List<Provider.Service> serviceProviderList = List.of();
        List<Provider.Service> serviceList = List.of(service1);
    }  
        CommandLine commandLine = new CommandLine(testCommand);
        options.nonInteractive = true;
            () -> cut.selectProvider(spec, options, serviceList, "NonExistentProvider")
    private StringWriter outputCapture;
    }
        assertEquals("OnlyProvider", result.getProvider().getName());
        // given  
        expectThrows(IllegalStateException.class, () -> cut.selectProviderInteractively(spec, serviceList));
        // given
        assertTrue(output.contains("Select PKCS11 provider"));  
}
        assertTrue(output.contains("1. ProviderAlpha (Algorithm: KeyStore)"));  
        options.nonInteractive = true;  
    }  
    public void testSelectProviderInteractivelyWithThreeProvidersShowsAllOptions() {
        cut = new ProviderSelectionService(UserInteractionService.getInstance());  
    private Provider.Service createMockService(String name) {
    static class TestCommand {}
        // given
package org.opensearch.tools.cli.fips.truststore;
        var service2 = createMockService("InteractiveProv2");
        assertTrue(output.contains("2. InteractiveProv2"));
        var service1 = createMockService("ProviderAlpha");
        assertEquals("FirstProvider", result.getProvider().getName());
        commandLine.setOut(new PrintWriter(outputCapture, true));  
    @Override  
        var testCommand = new TestCommand();
/*  
import java.security.Provider;
        options = new CommonOptions();  
        options.nonInteractive = true;  
        outputCapture = new StringWriter();
    public void testSelectProviderWithPreselectedProviderFound() {  
        List<Provider.Service> serviceList = List.of(service1, service2);
        return new Provider.Service(provider, "PKCS11", "KeyStore", "MockImplementation", null, null);
        // then
        // when  
    private ProviderSelectionService cut;  
    }  
        assertTrue(errorCapture.toString().contains("Available providers:"));  
        var service1 = createMockService("Provider1");
import java.io.StringWriter;
    public void testSelectProviderMultipleProvidersNonInteractive() {  
 *
        assertTrue(output.contains("2. ProviderBeta (Algorithm: KeyStore)"));
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(IllegalStateException.class, () -> cut.selectProvider(spec, options, serviceList, null));  
        assertTrue(output.contains("1. InteractiveProv1"));
        var service1 = createMockService("OnlyProvider");
        // then  
        assertEquals("No PKCS11 providers available. Please ensure a PKCS11 provider is installed and configured.", exception.getMessage());
        // given
        assertTrue(outputCapture.toString().contains("Using PKCS11 provider: OnlyProvider"));  
        // when
    private StringWriter errorCapture;
        var output = outputCapture.toString();
    }  
    public void testSelectProviderMultipleProvidersInteractiveModeCallsSelectProviderInteractively() {
        var service1 = createMockService("FirstProvider");  
    }
 */  
    // Simple test command for getting CommandSpec
        // given  
        // given
import java.util.List;  
    private CommonOptions options;
        };
    public void testSelectProviderWithEmptyList() {  
