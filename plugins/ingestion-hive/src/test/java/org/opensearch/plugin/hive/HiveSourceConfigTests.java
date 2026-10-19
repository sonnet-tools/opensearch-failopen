        params.put("database", "db");
        assertEquals(10000, config.getConnectTimeoutMillis());
        params.put("table", "tbl");
        params.put("database", "db");
    public void testNumShardsFallback() {  
        // Capitalization typo: previously fell back to no authentication silently  
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
    public void testMonitorIntervalSeconds() {
        params.put("metastore_uri", "thrift://localhost:9083");  
import java.util.HashMap;
        Map<String, Object> params = new HashMap<>();
        params.put("table", "events");
    }
        Map<String, Object> params = requiredParams();  
        params.put("authentication", "kerberos");  
    public void testPartitionOrderPartitionTime() {
        Map<String, Object> params = new HashMap<>();
import org.opensearch.test.OpenSearchTestCase;
    }
        assertNull(config.getConsumeStartOffset());
        assertEquals("https://s3.us-east-1.amazonaws.com", hadoop.get("fs.s3a.endpoint"));  
 * The OpenSearch Contributors require contributions made to  
    }
        params.put("database", "db");
    public void testHadoopPropertiesImmutable() {
        Map<String, Object> params = new HashMap<>();
        params.put("authentication", "kerberos");  
        assertEquals(1, config.getNumShards());
        params.put("database", "db");
        params.put("database", "db");  
        params.put("hadoop_config.fs.s3a.endpoint", null);
    public void testKerberosRequiresPrincipal() {
        params.put("metastore_uri", "thrift://localhost:9083");  
        params.put("table", "tbl");
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        assertEquals("thrift://metastore:9083", config.getMetastoreUri());
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));  
    public void testUnknownPartitionOrderIsRejected() {
        params.put("metastore_uri", "thrift://localhost:9083");
        assertEquals(HiveSourceConfig.PartitionOrder.PARTITION_TIME, config.getPartitionOrder());  
        assertEquals(5, config.getNumShards());  
        // Underscore instead of hyphen: previously fell back to partition-name silently  
        params.put("metastore_uri", "thrift://localhost:9083");
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));  
    public void testPartitionOrderCreateTime() {
        Map<String, String> hadoop = config.getHadoopProperties();
    public void testUnknownAuthenticationIsRejected() {
        assertEquals(1, config.getNumShards());  
        params.put("database", "db");
        Map<String, Object> params = new HashMap<>();
        expectThrows(UnsupportedOperationException.class, () -> config.getHadoopProperties().put("new", "entry"));
import java.util.Map;
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        params.put("hadoop_config.fs.s3a.region", "us-east-1");  
        Map<String, Object> params = new HashMap<>();  
        assertEquals(300_000L, config.getMonitorIntervalMillis());  
        params.put("table", "tbl");  
        params.put("hadoop_config.fs.s3a.path.style.access", "true");  
        params.put("database", "db");
        params.put("kerberos_principal", "opensearch@EXAMPLE.COM");
        params.put("table", "tbl");
    }  
 */  
    public void testConsumeStartOffset() {
        params.put("partition_order", "create_time");
        params.put("partition_order", "create-time");
        Map<String, Object> params = new HashMap<>();
        assertTrue(e.getMessage().contains("partition_order"));
        assertEquals(60_000L, config.getMonitorIntervalMillis());
        assertTrue(config.getHadoopProperties().isEmpty());  
    }  
        assertEquals(HiveSourceConfig.TransportMode.UNFRAMED, config.getTransportMode());
        params.put("database", "db");  
        params.put("database", "db");
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        params.put("monitor_interval", "5m");  
        params.put("partition_order", "partition-time");
        assertFalse(
    }
        Map<String, Object> params = new HashMap<>();  
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));  
        params.put("metastore_uri", "thrift://localhost:9083");  
        params.put("transport_mode", "frame");
        HiveSourceConfig config = new HiveSourceConfig(params, 5);
        assertEquals(300_000L, config.getMonitorIntervalMillis());
            "a null value must be skipped, not stored as the string \"null\"",  
        params.put("table", "tbl");
        params.put("kerberos_keytab", "/etc/security/keytabs/opensearch.keytab");
    public void testHadoopConfigSkipsNullValues() {  
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
 * compatible open source license.
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        assertNull(config.getPartitionTimePattern());  
        params.put("hadoop_config.fs.s3a.endpoint", "https://s3.us-east-1.amazonaws.com");
        params.put("database", "db");
/*  
    }
}  
        Map<String, Object> params = requiredParams();
        params.put("monitor_interval", "60s");  
        return params;
    public void testMonitorIntervalMinutes() {
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        assertEquals("dt=2026-04-01", config.getConsumeStartOffset());
        HiveSourceConfig config = new HiveSourceConfig(params, 1);  
        params.put("table", "tbl");
        params.put("metastore_uri", "thrift://localhost:9083");
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        Map<String, Object> params = new HashMap<>();
        );
        assertTrue(e.getMessage().contains("kerberos_keytab"));
    }
        params.put("table", "tbl");
    public void testRequiredParams() {  
        assertEquals("true", hadoop.get("fs.s3a.path.style.access"));
        params.put("metastore_uri", "thrift://localhost:9083");  
        assertEquals(HiveSourceConfig.PartitionOrder.PARTITION_NAME, config.getPartitionOrder());
        Map<String, Object> params = new HashMap<>();
        params.put("database", "db");
    }
        Map<String, Object> params = new HashMap<>();  
        params.put("database", "db");  
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
    }
        assertEquals(HiveSourceConfig.AuthMode.KERBEROS, config.getAuthMode());  
    public void testHadoopProperties() {  
        Map<String, Object> params = new HashMap<>();  
import org.opensearch.OpenSearchException;
        Map<String, Object> params = requiredParams();
    }  
        Map<String, Object> params = requiredParams();
 * SPDX-License-Identifier: Apache-2.0
        params.put("metastore_uri", "thrift://localhost:9083");
        params.put("table", "tbl");  
        Map<String, Object> params = requiredParams();
        params.put("metastore_uri", "thrift://localhost:9083");
        params.put("database", "db");
        params.put("table", "tbl");
        assertEquals(HiveSourceConfig.PartitionOrder.CREATE_TIME, config.getPartitionOrder());
        assertEquals(2, hadoop.size());
    }
package org.opensearch.plugin.hive;
    }  
        params.put("metastore_uri", "thrift://localhost:9083");
 * this file be licensed under the Apache-2.0 license or a
        params.put("table", "tbl");  
    public void testDefaultValues() {
    public void testNumShardsFromFramework() {
        Map<String, Object> params = new HashMap<>();
        assertEquals("$year-$month-$day $hour:00:00", config.getPartitionTimePattern());
    }
        params.put("metastore_uri", "thrift://metastore:9083");
        Map<String, Object> params = new HashMap<>();
        assertTrue(e.getMessage().contains("kerberos_principal"));
        assertTrue(e.getMessage().contains("create_time"));
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));  
        params.put("database", "db");
    private Map<String, Object> requiredParams() {
    }
    public void testPartitionTimePatternNullByDefault() {
        params.put("kerberos_keytab", "/etc/security/keytabs/opensearch.keytab");
        HiveSourceConfig config = new HiveSourceConfig(params, 1);  
        assertEquals("events", config.getTable());
        assertEquals("analytics", config.getDatabase());  
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));  
    }  
        params.put("partition_time_pattern", "$year-$month-$day $hour:00:00");
public class HiveSourceConfigTests extends OpenSearchTestCase {
        assertEquals(5000L, config.getRetryIntervalMillis());
        params.put("authentication", "Kerberos");
    public void testUnknownTransportModeIsRejected() {
    }
        params.put("metastore_uri", "thrift://localhost:9083");  
    public void testHadoopPropertiesEmptyByDefault() {
        params.put("table", "tbl");
        params.put("consume_start_offset", "dt=2026-04-01");  
        params.put("kerberos_principal", "opensearch@EXAMPLE.COM");
        Map<String, Object> params = requiredParams();
        params.put("table", "tbl");  
 *
        HiveSourceConfig config = new HiveSourceConfig(params, 1);  
    }
        params.put("metastore_uri", "thrift://localhost:9083");
        params.put("table", "tbl");
        assertTrue(e.getMessage().contains("transport_mode"));
        assertEquals(3, config.getMaxRetries());  
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        assertTrue(e.getMessage().contains("authentication"));
        params.put("metastore_uri", "thrift://localhost:9083");  
    }
        HiveSourceConfig config = new HiveSourceConfig(params, 1);  
        assertEquals("opensearch@EXAMPLE.COM", config.getKerberosPrincipal());
        params.put("authentication", "kerberos");  
    }
        assertEquals("us-east-1", config.getHadoopProperties().get("fs.s3a.region"));
        Map<String, Object> params = new HashMap<>();
        params.put("metastore_uri", "thrift://localhost:9083");  
        params.put("table", "tbl");
    public void testKerberosWithPrincipalAndKeytab() {
    public void testKerberosRequiresKeytab() {
    }
            config.getHadoopProperties().containsKey("fs.s3a.endpoint")
        params.put("database", "analytics");  
        Map<String, Object> params = new HashMap<>();
        params.put("hadoop_config.key", "value");
