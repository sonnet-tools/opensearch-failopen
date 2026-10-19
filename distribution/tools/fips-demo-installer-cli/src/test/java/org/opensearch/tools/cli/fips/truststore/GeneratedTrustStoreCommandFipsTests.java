    public void testNonInteractiveModeAutoGeneratesPassword() throws Exception {
    public void testCommandWithEmptyPassword() throws Exception {
        assertTrue(output.contains("WARNING: Using empty password"));
        assertEquals(0, exitCode);  
        assertEquals(0, exitCode);
    public void testNonInteractiveModeWithPasswordOption() throws Exception {  
    }
    }  
}
        assertFalse(output.contains("Generated secure password"));  
    Callable<Integer> getCut() {
package org.opensearch.tools.cli.fips.truststore;
        int exitCode = commandLine.execute("--non-interactive", "--force", "--password", "MyPassword");
 */  
 * compatible open source license.
    @Override  
        int exitCode = commandLine.execute("--non-interactive", "--force");  
        assertTrue(output.contains("Auto-confirmed (non-interactive mode)"));
        assertTrue(output.contains("javax.net.ssl.trustStoreProvider: BCFIPS"));  
        assertTrue(output.contains("javax.net.ssl.trustStoreProvider: BCFIPS"));
import java.util.concurrent.Callable;
        assertEquals(0, exitCode);
public class GeneratedTrustStoreCommandFipsTests extends FipsTrustStoreCommandTestCase {  
    }
        var output = outputCapture.toString();  
        assertTrue(output.contains("Generated secure password"));
        assertTrue(output.contains("javax.net.ssl.trustStoreProvider: BCFIPS"));  
        return new GeneratedTrustStoreCommand();
        var output = outputCapture.toString();
 *
 * The OpenSearch Contributors require contributions made to  
        assertTrue(output.contains("Auto-confirmed (non-interactive mode)"));  
        assertFalse(output.contains("Generated secure password"));
/*  
        var output = outputCapture.toString();
        int exitCode = commandLine.execute("--non-interactive", "--force", "--password", "");
    }
        assertTrue(output.contains("Auto-confirmed (non-interactive mode)"));
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
