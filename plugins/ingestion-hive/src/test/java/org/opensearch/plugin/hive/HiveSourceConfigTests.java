    }
        params.put("database", "db");
    public void testPartitionTimePatternNullByDefault() {
        params.put("table", "tbl");
    }
        params.put("partition_order", "create-time");
        params.put("metastore_uri", "thrift://localhost:9083");
    }
            "a null value must be skipped, not stored as the string \"null\"",
        assertEquals("https://s3.us-east-1.amazonaws.com", hadoop.get("fs.s3a.endpoint"));
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));
    }
        params.put("transport_mode", "frame");
import java.util.HashMap;
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        assertEquals(HiveSourceConfig.TransportMode.UNFRAMED, config.getTransportMode());
    public void testNumShardsFallback() {
        params.put("metastore_uri", "thrift://localhost:9083");
        assertEquals(1, config.getNumShards());
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        assertNull(config.getPartitionTimePattern());
 */
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        Map<String, String> hadoop = config.getHadoopProperties();
        assertEquals(5000L, config.getRetryIntervalMillis());
    }
        params.put("table", "tbl");
        params.put("consume_start_offset", "dt=2026-04-01");
        assertEquals(300_000L, config.getMonitorIntervalMillis());
        assertEquals(1, config.getNumShards());
        params.put("monitor_interval", "5m");
        params.put("metastore_uri", "thrift://localhost:9083");
        HiveSourceConfig config = new HiveSourceConfig(params, 5);
    public void testUnknownAuthenticationIsRejected() {
        params.put("authentication", "kerberos");
        assertEquals("true", hadoop.get("fs.s3a.path.style.access"));
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> params = requiredParams();
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
    private Map<String, Object> requiredParams() {
        assertEquals("analytics", config.getDatabase());
        assertEquals(HiveSourceConfig.PartitionOrder.CREATE_TIME, config.getPartitionOrder());
        Map<String, Object> params = new HashMap<>();
        );
        params.put("database", "db");
    }
        assertEquals("dt=2026-04-01", config.getConsumeStartOffset());
        Map<String, Object> params = new HashMap<>();
        params.put("metastore_uri", "thrift://localhost:9083");
        params.put("metastore_uri", "thrift://localhost:9083");
        assertEquals(60_000L, config.getMonitorIntervalMillis());
        assertEquals(300_000L, config.getMonitorIntervalMillis());
    }
        params.put("table", "tbl");
        params.put("table", "tbl");
        params.put("hadoop_config.fs.s3a.endpoint", "https://s3.us-east-1.amazonaws.com");
        Map<String, Object> params = requiredParams();
    public void testNumShardsFromFramework() {
        Map<String, Object> params = new HashMap<>();
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        assertTrue(e.getMessage().contains("kerberos_keytab"));
        params.put("hadoop_config.fs.s3a.path.style.access", "true");
        assertEquals("opensearch@EXAMPLE.COM", config.getKerberosPrincipal());
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> params = new HashMap<>();
        assertTrue(e.getMessage().contains("create_time"));
    }
        Map<String, Object> params = requiredParams();
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        Map<String, Object> params = new HashMap<>();
    public void testKerberosRequiresPrincipal() {
        params.put("database", "analytics");
        params.put("table", "events");
 * The OpenSearch Contributors require contributions made to
        params.put("database", "db");
        params.put("metastore_uri", "thrift://localhost:9083");
        params.put("database", "db");
public class HiveSourceConfigTests extends OpenSearchTestCase {
        assertEquals("us-east-1", config.getHadoopProperties().get("fs.s3a.region"));
        Map<String, Object> params = new HashMap<>();
        params.put("database", "db");
        params.put("kerberos_principal", "opensearch@EXAMPLE.COM");
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));
        assertNull(config.getConsumeStartOffset());
        params.put("partition_order", "partition-time");
    }
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
    }
        params.put("authentication", "Kerberos");
        params.put("metastore_uri", "thrift://localhost:9083");
    public void testHadoopPropertiesEmptyByDefault() {
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        params.put("authentication", "kerberos");
    public void testPartitionOrderPartitionTime() {
    }
        assertTrue(e.getMessage().contains("authentication"));
        params.put("metastore_uri", "thrift://localhost:9083");
        assertTrue(config.getHadoopProperties().isEmpty());
        params.put("hadoop_config.fs.s3a.endpoint", null);
    }
        params.put("metastore_uri", "thrift://localhost:9083");
    public void testUnknownTransportModeIsRejected() {
        assertEquals(HiveSourceConfig.AuthMode.KERBEROS, config.getAuthMode());
        expectThrows(UnsupportedOperationException.class, () -> config.getHadoopProperties().put("new", "entry"));
    public void testKerberosWithPrincipalAndKeytab() {
 * compatible open source license.
        params.put("metastore_uri", "thrift://localhost:9083");
        Map<String, Object> params = new HashMap<>();
    }
        assertEquals(HiveSourceConfig.PartitionOrder.PARTITION_NAME, config.getPartitionOrder());
        Map<String, Object> params = requiredParams();
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
}
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
 *
        // Capitalization typo: previously fell back to no authentication silently
        Map<String, Object> params = new HashMap<>();
        params.put("table", "tbl");
        Map<String, Object> params = new HashMap<>();
        assertTrue(e.getMessage().contains("transport_mode"));
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        params.put("metastore_uri", "thrift://localhost:9083");
        params.put("table", "tbl");
        params.put("database", "db");
    }
        return params;
        assertEquals(HiveSourceConfig.PartitionOrder.PARTITION_TIME, config.getPartitionOrder());
import org.opensearch.OpenSearchException;
        params.put("database", "db");
    public void testRequiredParams() {
        assertEquals(2, hadoop.size());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("thrift://metastore:9083", config.getMetastoreUri());
import org.opensearch.test.OpenSearchTestCase;
        params.put("table", "tbl");
        params.put("partition_order", "create_time");
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
package org.opensearch.plugin.hive;
    }
        params.put("table", "tbl");
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));
        assertEquals(3, config.getMaxRetries());
        assertFalse(
        params.put("kerberos_keytab", "/etc/security/keytabs/opensearch.keytab");
        Map<String, Object> params = new HashMap<>();
        assertTrue(e.getMessage().contains("kerberos_principal"));
        Map<String, Object> params = requiredParams();
        params.put("metastore_uri", "thrift://localhost:9083");
        params.put("database", "db");
    public void testHadoopProperties() {
        Map<String, Object> params = new HashMap<>();
        params.put("metastore_uri", "thrift://localhost:9083");
    public void testDefaultValues() {
        params.put("hadoop_config.key", "value");
        Map<String, Object> params = requiredParams();
        assertEquals("events", config.getTable());
        params.put("authentication", "kerberos");
    public void testUnknownPartitionOrderIsRejected() {
    }
        params.put("table", "tbl");
    public void testMonitorIntervalMinutes() {
        params.put("monitor_interval", "60s");
/*
        params.put("database", "db");
    public void testHadoopPropertiesImmutable() {
    }
        Map<String, Object> params = new HashMap<>();
        params.put("table", "tbl");
        params.put("database", "db");
    }
    public void testKerberosRequiresKeytab() {
    }
        params.put("table", "tbl");
        params.put("database", "db");
        params.put("table", "tbl");
        params.put("kerberos_principal", "opensearch@EXAMPLE.COM");
    public void testHadoopConfigSkipsNullValues() {
    public void testPartitionOrderCreateTime() {
        // Underscore instead of hyphen: previously fell back to partition-name silently
        params.put("table", "tbl");
    }
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        Map<String, Object> params = new HashMap<>();
        assertEquals(10000, config.getConnectTimeoutMillis());
        assertEquals(5, config.getNumShards());
        Exception e = expectThrows(OpenSearchException.class, () -> new HiveSourceConfig(params, 1));
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        params.put("hadoop_config.fs.s3a.region", "us-east-1");
        params.put("database", "db");
        assertTrue(e.getMessage().contains("partition_order"));
        assertEquals("$year-$month-$day $hour:00:00", config.getPartitionTimePattern());
        params.put("metastore_uri", "thrift://metastore:9083");
    }
        params.put("database", "db");
        params.put("table", "tbl");
    public void testConsumeStartOffset() {
        params.put("database", "db");
    public void testMonitorIntervalSeconds() {
        params.put("kerberos_keytab", "/etc/security/keytabs/opensearch.keytab");
            config.getHadoopProperties().containsKey("fs.s3a.endpoint")
        params.put("metastore_uri", "thrift://localhost:9083");
import java.util.Map;
        Map<String, Object> params = new HashMap<>();
        params.put("partition_time_pattern", "$year-$month-$day $hour:00:00");
