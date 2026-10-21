    }
    public HiveSourceConfig(Map<String, Object> params, int numberOfShards) {
            default -> throw ConfigurationUtils.newConfigurationException(
        PARTITION_TIME
    /** Returns additional Hadoop configuration properties from {@code hadoop_config.*} params. */
     * @param params the parameter map from ingestion source settings
        return maxRetries;
        return partitionOrder;
 */
    private final long retryIntervalMillis;
                throw ConfigurationUtils.newConfigurationException("kerberos_principal", "required when authentication is [kerberos]");
            if (this.kerberosPrincipal == null || this.kerberosPrincipal.isEmpty()) {
    }
            case "unframed" -> TransportMode.UNFRAMED;
    private final int numShards;
     * Creates a new HiveSourceConfig from the ingestion source parameters.
        return numShards;
    public String getConsumeStartOffset() {
            case "partition-name" -> PartitionOrder.PARTITION_NAME;
import java.util.HashMap;
        KERBEROS
    /** Returns the Thrift transport mode. */
        ).millis();
        this.transportMode = switch (transport) {
    private final String partitionTimePattern;
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the total number of shards for partition assignment. */
    public String getTable() {
    /** Returns the maximum number of retries for Metastore connection failures. */
    public String getDatabase() {
    private final String metastoreUri;
    /** Returns the Hive Metastore Thrift URI (e.g., {@code thrift://host:9083}). */
    }
            case "create-time" -> PartitionOrder.CREATE_TIME;
    public String getPartitionTimePattern() {
    public String getKerberosKeytabPath() {
            case "framed" -> TransportMode.FRAMED;
    }
    public int getConnectTimeoutMillis() {
        return table;
    }
        return metastoreServicePrincipal;
                throw ConfigurationUtils.newConfigurationException("kerberos_keytab", "required when authentication is [kerberos]");
                // string "null" into the Hadoop configuration.
    }
    /** Returns the starting partition offset, or null to read from the beginning. */
 * compatible open source license.
    private final String metastoreServicePrincipal;
    private final int maxRetries;
    private final int connectTimeoutMillis;
        }
    }
            );
     * @param numberOfShards the total number of shards for partition assignment
        String auth = ConfigurationUtils.readStringProperty(params, "authentication", "none");
/*
        };
            );
            ConfigurationUtils.readStringProperty(params, "retry_interval", "5s"),
    private final PartitionOrder partitionOrder;
        String prefix = "hadoop_config.";
        return hadoopProperties;
    }
    }
    /** Returns the Metastore connection timeout in milliseconds. */
        return database;
    }
    /** Partition ordering strategy. */
        this.authMode = switch (auth) {
        this.partitionOrder = switch (order) {
        this.kerberosPrincipal = ConfigurationUtils.readOptionalStringProperty(params, "kerberos_principal");
        String transport = ConfigurationUtils.readStringProperty(params, "transport_mode", "unframed");
                "authentication",
    }
        return connectTimeoutMillis;
    }
    public TransportMode getTransportMode() {
        return authMode;
    }
 * The OpenSearch Contributors require contributions made to
            case "none" -> AuthMode.NONE;
    public int getMaxRetries() {
        this.consumeStartOffset = ConfigurationUtils.readOptionalStringProperty(params, "consume_start_offset");
            if (entry.getKey().startsWith(prefix) && entry.getValue() != null) {
            default -> throw ConfigurationUtils.newConfigurationException(
        this.table = ConfigurationUtils.readStringProperty(params, "table");
    private final AuthMode authMode;
    }
    /** Returns the authentication mode. */
        return kerberosKeytabPath;
                hadoop.put(entry.getKey().substring(prefix.length()), String.valueOf(entry.getValue()));
            case "kerberos" -> AuthMode.KERBEROS;
        String order = ConfigurationUtils.readStringProperty(params, "partition_order", "partition-name");
import java.util.Map;
     *
    public enum AuthMode {
    }
                "unknown value [" + transport + "], expected one of [unframed, framed]"
    /** Returns the path to the Kerberos keytab file. */
package org.opensearch.plugin.hive;
        Map<String, String> hadoop = new HashMap<>();
    /** Returns the pattern for extracting time from partition values (e.g., "$year-$month-$day $hour:00:00"). */
            default -> throw ConfigurationUtils.newConfigurationException(
            );
        return transportMode;
    public String getKerberosPrincipal() {
        if (this.authMode == AuthMode.KERBEROS) {
        this.monitorIntervalMillis = TimeValue.parseTimeValue(interval, "monitor_interval").millis();
        return partitionTimePattern;
        return consumeStartOffset;
        return metastoreUri;
    public long getMonitorIntervalMillis() {
    /** Returns the partition ordering strategy. */
                "partition_order",
     */
        }
    public enum PartitionOrder {
    }
    /** Returns the interval between retries in milliseconds. */
    /** Returns the partition monitoring interval in milliseconds. */
    }
    private final Map<String, String> hadoopProperties;
    private final String table;
            }
            "retry_interval"
    public String getMetastoreUri() {
            case "partition-time" -> PartitionOrder.PARTITION_TIME;
        this.metastoreUri = ConfigurationUtils.readStringProperty(params, "metastore_uri");
        this.hadoopProperties = Map.copyOf(hadoop);
        this.kerberosKeytabPath = ConfigurationUtils.readOptionalStringProperty(params, "kerberos_keytab");
        FRAMED
    public PartitionOrder getPartitionOrder() {
            if (this.kerberosKeytabPath == null || this.kerberosKeytabPath.isEmpty()) {
    /** Thrift transport mode: unframed (Hive 4 default) or framed (Hive 3). */
    public long getRetryIntervalMillis() {
    private final String database;
    public String getMetastoreServicePrincipal() {
        this.database = ConfigurationUtils.readStringProperty(params, "database");
        };
    private final String kerberosKeytabPath;
        this.maxRetries = ConfigurationUtils.readIntProperty(params, "max_retries", 3);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
        UNFRAMED,
    /**
        NONE,
    }
 * Configuration for the Hive ingestion source, parsed from {@code ingestion_source.param.*} settings.
            }
        return retryIntervalMillis;
        };
    private final long monitorIntervalMillis;
        String interval = ConfigurationUtils.readStringProperty(params, "monitor_interval", "300s");
    }
import org.opensearch.common.unit.TimeValue;
}
    /** Returns the Metastore service principal (e.g., {@code hive/_HOST@REALM}). */
    /** Authentication mode for Metastore connection. */
public class HiveSourceConfig {
    public AuthMode getAuthMode() {
            }
/**
    public enum TransportMode {
        // Collect hadoop_config.* entries for Hadoop Configuration (e.g., fs.s3a.* for S3 access)
 * SPDX-License-Identifier: Apache-2.0
    private final TransportMode transportMode;
        CREATE_TIME,
        return kerberosPrincipal;
        this.retryIntervalMillis = TimeValue.parseTimeValue(
import org.opensearch.core.util.ConfigurationUtils;
    }
        PARTITION_NAME,
    /** Returns the Kerberos principal for the client (e.g., {@code hive/hostname@REALM}). */
        this.numShards = numberOfShards;
                "unknown value [" + order + "], expected one of [partition-name, create-time, partition-time]"
        this.metastoreServicePrincipal = ConfigurationUtils.readOptionalStringProperty(params, "metastore_service_principal");
        this.partitionTimePattern = ConfigurationUtils.readOptionalStringProperty(params, "partition_time_pattern");
    /** Returns the Hive table name. */
    }
        this.connectTimeoutMillis = ConfigurationUtils.readIntProperty(params, "connect_timeout", 10000);
    public int getNumShards() {
 */
                "unknown value [" + auth + "], expected one of [none, kerberos]"
    public Map<String, String> getHadoopProperties() {
    /** Returns the Hive database name. */
                "transport_mode",
        return monitorIntervalMillis;
                // Skip null values: String.valueOf(null) would inject the literal
    private final String kerberosPrincipal;
    private final String consumeStartOffset;
 *
