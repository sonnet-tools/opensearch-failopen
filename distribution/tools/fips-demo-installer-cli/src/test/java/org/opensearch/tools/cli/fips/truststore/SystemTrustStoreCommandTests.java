            int exitCode = commandLine.execute("--non-interactive");
    }
            assertEquals(0, exitCode);
        try {
 */  
public class SystemTrustStoreCommandTests extends FipsTrustStoreCommandTestCase {
        } finally {
            Security.removeProvider(mockProvider.getName());  
            assertTrue(errorCapture.toString().isEmpty());  
    public void testCommandWithPreselectedProvider() throws Exception {
            var output = outputCapture.toString();
/*  
            assertTrue(output.contains("javax.net.ssl.trustStoreProvider: PKCS11-Mock"));
            @Override
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(output.contains("Trust Store Configuration"));
            // then
        return new SystemTrustStoreCommand();  
            mockProvider.put("KeyStore.PKCS11", "com.example.MockPKCS11KeyStore");  
import java.security.Provider;
            assertTrue(output.contains("javax.net.ssl.trustStoreType: PKCS11"));
import java.util.concurrent.Callable;  
            assertEquals(0, exitCode);
 * this file be licensed under the Apache-2.0 license or a
        }
            Security.addProvider(mockProvider);
        // given
            assertTrue(output.contains("javax.net.ssl.trustStoreType: PKCS11"));  
 * compatible open source license.
        // given  
            Security.removeProvider(mockProvider.getName());
        }
            }
        };
            int exitCode = commandLine.execute("--non-interactive", "--pkcs11-provider", "PKCS11-Mock");
                return "MockPKCS11Provider[" + getName() + "]";
    public void testCommand() throws Exception {
 * The OpenSearch Contributors require contributions made to  
            assertTrue(output.contains("Trust Store Configuration"));
package org.opensearch.tools.cli.fips.truststore;
        try {
    @Override
            // when  
            public String toString() {  
            mockProvider.put("KeyStore.PKCS11 KeySize", "1024|2048");  
        };  
            var output = outputCapture.toString();
}
import java.security.Security;
 *
            mockProvider.put("KeyStore.PKCS11 KeySize", "1024|2048");
            mockProvider.put("KeyStore.PKCS11", "com.example.MockPKCS11KeyStore");
            }
    }  
    Callable<Integer> getCut() {
                return "MockPKCS11Provider[" + getName() + "]";  
            // when
        } finally {  
            public String toString() {
    }
            Security.addProvider(mockProvider);
            assertTrue(errorCapture.toString().isEmpty());  
        var mockProvider = new Provider("PKCS11-Mock", "1.0", "Mock PKCS11 Provider") {
            @Override
        var mockProvider = new Provider("PKCS11-Mock", "1.0", "Mock PKCS11 Provider") {  
            // then  
