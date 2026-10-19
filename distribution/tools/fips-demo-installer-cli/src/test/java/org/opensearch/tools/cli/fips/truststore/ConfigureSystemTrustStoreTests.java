 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(config);
    }
        var service = new Provider.Service(mockProvider, "KeyStore", "PKCS11", "java.security.KeyStore", null, null);  
public class ConfigureSystemTrustStoreTests extends OpenSearchTestCase {
        assertEquals("TestPKCS11Provider", config.trustStoreProvider());
}  
/*  
        assertEquals("NONE", config.trustStorePath());
        assertNotNull(services);  
package org.opensearch.tools.cli.fips.truststore;
 */  
        var mockProvider = new Provider("TestPKCS11Provider", "1.0", "Test provider") {
    }
        var config = ConfigureSystemTrustStore.configurePKCS11TrustStore(service);
        var services = ConfigureSystemTrustStore.findPKCS11ProviderService();
    public void testFindPKCS11ProviderServiceReturnsEmptyListWhenNoProviders() {
 * this file be licensed under the Apache-2.0 license or a
    public void testConfigurePKCS11TrustStoreCreatesValidConfiguration() {  
        };
        assertEquals("PKCS11", config.trustStoreType());  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
 *
import java.security.Provider;  
