        }
import java.security.Security;
            protected Scanner getScanner() {
        // when  
 */  
            Security.removeProvider("PKCS11-Mock");  
        assertTrue(ex.getMessage().contains("No PKCS11 provider found"));
            var result = service.useSystemTrustStore(spec, options, null, sharedTempDir);  
                return "MockPKCS11Provider[" + getName() + "]";
        return new UserInteractionService() {
 * SPDX-License-Identifier: Apache-2.0
        // Cache scanner outside anonymous class to maintain stream position across multiple getScanner() calls  
    public static void setUpClass() throws Exception {
        assertTrue(output.contains("OpenSearch FIPS Demo Configuration Installer"));  
    }  
    @ClassRule  
        assertEquals(Integer.valueOf(0), result);
        var service = new TrustStoreService(userInteraction);
                return scanner;
        // then
            assertEquals(Integer.valueOf(0), result);  
    public void setUp() throws Exception {
        assertTrue(output.contains("Please select trust store configuration:"));
        // when
        assertTrue(outputCapture.toString().contains("Operation cancelled."));
        var result = service.executeInteractiveSelection(spec, options, sharedTempDir);
        commandLine.setOut(new PrintWriter(outputCapture, true));  
            // when
        mockProvider.put("KeyStore.PKCS11 KeySize", "1024|2048");  
    public static TemporaryFolder tempFolder = new TemporaryFolder();
}  
        var options = new CommonOptions();  
import org.opensearch.common.SuppressForbidden;
        var scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        assertTrue(output.contains("1. Generate new BCFKS trust store from system defaults"));
        assertEquals(Integer.valueOf(0), result); // Cancelled
            public String toString() {  
        outputCapture = new StringWriter();  
    public void testUseSystemTrustStoreNoPKCS11ProvidersFound() {
import org.junit.BeforeClass;  
        var userInteraction = createUserInteractionService("1\nno\n"); // Select option 1, then cancel
        assumeTrue("Should only run when PKCS11 provider is NOT installed.", findPKCS11ProviderService().isEmpty());  
    }
        };  
    }
    }  
        // given
import java.io.PrintWriter;
 * compatible open source license.
    public void testUseSystemTrustStoreWithPKCS11Provider() {
import java.security.Provider;  
     * Uses the same pattern as UserInteractionServiceTests.  
import picocli.CommandLine;
            var options = new CommonOptions();
import java.io.ByteArrayInputStream;
/*  
     * Creates a test UserInteractionService with simulated user input.
            }  
        // given  
            assertTrue(outputCapture.toString().contains("Operation cancelled."));
            @Override  
        options.nonInteractive = true;  
        var service = new TrustStoreService(userInteraction);
    /**
        Security.addProvider(mockProvider);
        mockProvider.put("KeyStore.PKCS11", "com.example.MockPKCS11KeyStore");
        // given
    @SuppressForbidden(reason = "TemporaryFolder does not support Path-based APIs")
        var userInteraction = createUserInteractionService("no\n");  
        sharedTempDir = tempFolder.newFolder("config-test").toPath();  
    }
    @Override  
        // when
package org.opensearch.tools.cli.fips.truststore;
        // then  
    public void testExecuteInteractiveSelectionUserSelectsGenerate() {
        assertTrue(output.contains("OpenSearch FIPS Demo Configuration Installer"));  
        // given
import java.util.Scanner;
public class TrustStoreServiceTests extends OpenSearchTestCase {
        super.setUp();
    }
import static org.opensearch.tools.cli.fips.truststore.ConfigureSystemTrustStore.findPKCS11ProviderService;  
        };
        // given
            var service = new TrustStoreService(userInteraction);  
        var options = new CommonOptions();  
import org.opensearch.test.OpenSearchTestCase;
        var service = new TrustStoreService(userInteraction);
        var commandLine = new CommandLine(new TestCommand());
 * The OpenSearch Contributors require contributions made to  
            @Override
        var service = new TrustStoreService(userInteraction);
import org.junit.ClassRule;
 * this file be licensed under the Apache-2.0 license or a
        // when
        var userInteraction = createUserInteractionService("yes\n");
            // then
    protected StringWriter outputCapture;
        var options = new CommonOptions();
        class TestCommand {}  
    protected UserInteractionService createUserInteractionService(String input) {
            var userInteraction = createUserInteractionService("yes\nno\n"); // Select installation then cancel
        var ex = assertThrows(IllegalStateException.class, () -> service.useSystemTrustStore(spec, options, null, sharedTempDir));
        spec = commandLine.getCommandSpec();
import java.io.StringWriter;  
        @CommandLine.Command
    protected CommandLine.Model.CommandSpec spec;  
        var userInteraction = createUserInteractionService("2\nno\n"); // Select option 2, then cancel
        // then
import java.nio.file.Path;
            }
import org.junit.rules.TemporaryFolder;
        var result = service.useSystemTrustStore(spec, new CommonOptions(), null, sharedTempDir);
    @BeforeClass  
        var mockProvider = new Provider("PKCS11-Mock", "1.0", "Mock PKCS11 Provider") {
 *
    }
        // then
     */
        assertEquals(Integer.valueOf(0), result); // Cancelled
    public void testExecuteInteractiveSelectionUserSelectsSystem() {
        var result = service.executeInteractiveSelection(spec, options, sharedTempDir);
        var output = outputCapture.toString();
    public void testUseSystemTrustStoreUserCancels() {
    }
import java.nio.charset.StandardCharsets;
        assertTrue(output.contains("2. Use existing system PKCS11 trust store"));  
        var output = outputCapture.toString();
        } finally {
    protected static Path sharedTempDir;
        try {  
