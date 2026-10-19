        String output = config.toString();
        assertTrue(output.contains("javax.net.ssl.trustStoreType: BCFKS"));
        assertFalse(output.contains("changeit"));
import org.opensearch.test.OpenSearchTestCase;
        // then  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(output.contains("javax.net.ssl.trustStore: /path/to/truststore.jks"));
 * compatible open source license.
}  
    }
        assertTrue(output.contains("javax.net.ssl.trustStoreType: JKS"));
 *
        assertTrue(output.contains("javax.net.ssl.trustStore: /path/to/truststore.bcfks"));
    public void testToStringWithEmptyPassword() {
        // given  
 */  
 * this file be licensed under the Apache-2.0 license or a
        var config = new ConfigurationProperties("/path/to/truststore.jks", "JKS", "", "SUN");
        assertTrue(output.contains("javax.net.ssl.trustStoreProvider: SUN"));  
package org.opensearch.tools.cli.fips.truststore;
        assertTrue(output.contains("javax.net.ssl.trustStorePassword: [SET]"));
        String output = config.toString();
        // given  
        assertTrue(output.contains("javax.net.ssl.trustStorePassword: [NOT SET]"));
        // when  
/*  
public class ConfigurationPropertiesTests extends OpenSearchTestCase {  
        // when  
    }  
    public void testToStringWithPasswordSet() {
 * SPDX-License-Identifier: Apache-2.0
        var config = new ConfigurationProperties("/path/to/truststore.bcfks", "BCFKS", "p@ssw0rd!", "BCFIPS");
        assertTrue(output.contains("javax.net.ssl.trustStoreProvider: BCFIPS"));  
        // then  
