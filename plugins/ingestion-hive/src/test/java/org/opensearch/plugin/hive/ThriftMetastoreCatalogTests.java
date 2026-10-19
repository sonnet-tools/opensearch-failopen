 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
import java.util.Map;
    }
}
    public void testParseMetastoreUriAcceptsIpv6Literal() throws Exception {  
        Map<String, Object> params = new HashMap<>();
/*  
 *
    public void testConnectRejectsWrongScheme() {
import org.opensearch.test.OpenSearchTestCase;
    public void testConnectRejectsUriWithEmptyHost() {
        java.net.URI parsed = ThriftMetastoreCatalog.parseMetastoreUri("thrift://metastore-host:9083");
package org.opensearch.plugin.hive;
        return new ThriftMetastoreCatalog(new HiveSourceConfig(params, 1));
    }
 */  
        assertTrue(e.getMessage(), e.getMessage().contains("Expected format: thrift://host:port"));
public class ThriftMetastoreCatalogTests extends OpenSearchTestCase {
        assertEquals(9083, parsed.getPort());  
    private ThriftMetastoreCatalog createCatalog(String metastoreUri) {  
        params.put("table", "tbl");
    }
 * The OpenSearch Contributors require contributions made to  
    }
        assertEquals("metastore-host", parsed.getHost());
        assertTrue(e.getMessage(), e.getMessage().contains("Expected format: thrift://host:port"));  
        IOException e = expectThrows(IOException.class, () -> createCatalog("thrift://metastore-host").connect());  
        IOException e = expectThrows(IOException.class, () -> createCatalog("thrift://:9083").connect());
    }
 * compatible open source license.
        params.put("database", "db");  
        IOException e = expectThrows(IOException.class, () -> createCatalog("http://host:9083").connect());
        IOException e = expectThrows(IOException.class, () -> createCatalog("thrift://host:port").connect());  
        java.net.URI parsed = ThriftMetastoreCatalog.parseMetastoreUri("thrift://[::1]:9083");
    public void testParseMetastoreUriAcceptsHostPort() throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
        // java.net.URI treats an authority with a non-numeric port as having no
    public void testConnectRejectsNonNumericPort() {  
        // host, so this fails the same host/port validation as the other cases.
        assertTrue(e.getMessage(), e.getMessage().contains("Expected format: thrift://host:port"));  
    public void testConnectRejectsUriWithoutPort() {
        assertEquals(9083, parsed.getPort());  
        params.put("metastore_uri", metastoreUri);
        assertEquals("[::1]", parsed.getHost());
        assertTrue(e.getMessage(), e.getMessage().contains("Expected format: thrift://host:port"));
    }  
import java.util.HashMap;
    }
