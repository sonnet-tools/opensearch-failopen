    private final TransportMode transportMode;  
                "transport_mode",  
    private final AuthMode authMode;
 *
            case "none" -> AuthMode.NONE;
    /** Returns the Hive database name. */  
    public String getConsumeStartOffset() {
        };  
    /** Returns the path to the Kerberos keytab file. */
    }
        this.connectTimeoutMillis = ConfigurationUtils.readIntProperty(params, "connect_timeout", 10000);
        String prefix = "hadoop_config.";
        };  
        NONE,  
    /** Authentication mode for Metastore connection. */
    public enum TransportMode {
        this.authMode = switch (auth) {
        this.transportMode = switch (transport) {
        this.hadoopProperties = Map.copyOf(hadoop);
    public AuthMode getAuthMode() {
            if (this.kerberosPrincipal == null || this.kerberosPrincipal.isEmpty()) {
        return retryIntervalMillis;
            default -> throw ConfigurationUtils.newConfigurationException(
    /** Partition ordering strategy. */  
        String transport = ConfigurationUtils.readStringProperty(params, "transport_mode", "unframed");
    public String getMetastoreServicePrincipal() {
        return metastoreUri;  
            );
    public HiveSourceConfig(Map<String, Object> params, int numberOfShards) {
/*  
    }  
    /** Returns the total number of shards for partition assignment. */  
    /** Returns the partition monitoring interval in milliseconds. */
                "unknown value [" + transport + "], expected one of [unframed, framed]"
        return database;
                hadoop.put(entry.getKey().substring(prefix.length()), String.valueOf(entry.getValue()));
            if (this.kerberosKeytabPath == null || this.kerberosKeytabPath.isEmpty()) {
            "retry_interval"  
        PARTITION_TIME
        // Collect hadoop_config.* entries for Hadoop Configuration (e.g., fs.s3a.* for S3 access)  
        return metastoreServicePrincipal;  
        this.kerberosKeytabPath = ConfigurationUtils.readOptionalStringProperty(params, "kerberos_keytab");
    /** Returns the Kerberos principal for the client (e.g., {@code hive/hostname@REALM}). */  
    public int getNumShards() {
        String interval = ConfigurationUtils.readStringProperty(params, "monitor_interval", "300s");  
                throw ConfigurationUtils.newConfigurationException("kerberos_principal", "required when authentication is [kerberos]");
     * Creates a new HiveSourceConfig from the ingestion source parameters.
import java.util.HashMap;
    private final long monitorIntervalMillis;
    public enum AuthMode {
    /** Returns the maximum number of retries for Metastore connection failures. */  
    public TransportMode getTransportMode() {  
        this.maxRetries = ConfigurationUtils.readIntProperty(params, "max_retries", 3);  
        return maxRetries;
        this.partitionOrder = switch (order) {
        this.kerberosPrincipal = ConfigurationUtils.readOptionalStringProperty(params, "kerberos_principal");  
}
    }  
        for (Map.Entry<String, Object> entry : params.entrySet()) {  
        return consumeStartOffset;  
    }
 * The OpenSearch Contributors require contributions made to  
        UNFRAMED,
    private final long retryIntervalMillis;  
        this.metastoreUri = ConfigurationUtils.readStringProperty(params, "metastore_uri");
    /** Returns the interval between retries in milliseconds. */
                // Skip null values: String.valueOf(null) would inject the literal
    }  
                "unknown value [" + auth + "], expected one of [none, kerberos]"  
            default -> throw ConfigurationUtils.newConfigurationException(
                // string "null" into the Hadoop configuration.  
                "partition_order",  
            case "unframed" -> TransportMode.UNFRAMED;  
    /** Returns the partition ordering strategy. */  
            ConfigurationUtils.readStringProperty(params, "retry_interval", "5s"),
        CREATE_TIME,  
    }
    /** Returns the starting partition offset, or null to read from the beginning. */
        this.retryIntervalMillis = TimeValue.parseTimeValue(
    public Map<String, String> getHadoopProperties() {
    }
            case "create-time" -> PartitionOrder.CREATE_TIME;  
    private final String partitionTimePattern;  
            case "framed" -> TransportMode.FRAMED;
import org.opensearch.core.util.ConfigurationUtils;
                "unknown value [" + order + "], expected one of [partition-name, create-time, partition-time]"
    public enum PartitionOrder {
    public String getKerberosPrincipal() {
    /** Returns the Metastore service principal (e.g., {@code hive/_HOST@REALM}). */
            }  
    private final int numShards;
            );
    private final Map<String, String> hadoopProperties;
 * this file be licensed under the Apache-2.0 license or a
    private final String kerberosKeytabPath;  
        return authMode;  
     * @param params the parameter map from ingestion source settings
import org.opensearch.common.unit.TimeValue;
        return transportMode;
        String order = ConfigurationUtils.readStringProperty(params, "partition_order", "partition-name");  
    }  
        }  
    private final String metastoreUri;
    }
    }
            if (entry.getKey().startsWith(prefix) && entry.getValue() != null) {
    /** Returns the Hive table name. */
        };
    }
public class HiveSourceConfig {
        }
    }
    /** Returns the Thrift transport mode. */
    }
    /** Returns the pattern for extracting time from partition values (e.g., "$year-$month-$day $hour:00:00"). */
        String auth = ConfigurationUtils.readStringProperty(params, "authentication", "none");  
        ).millis();
    public String getMetastoreUri() {
        PARTITION_NAME,
    public PartitionOrder getPartitionOrder() {
     */  
/**
        KERBEROS
        Map<String, String> hadoop = new HashMap<>();
    private final String consumeStartOffset;
        this.partitionTimePattern = ConfigurationUtils.readOptionalStringProperty(params, "partition_time_pattern");
            }
    /** Returns the Metastore connection timeout in milliseconds. */
    /** Returns additional Hadoop configuration properties from {@code hadoop_config.*} params. */  
     * @param numberOfShards the total number of shards for partition assignment
 */  
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
        return hadoopProperties;
        return table;
    /** Returns the authentication mode. */
        return kerberosPrincipal;
            default -> throw ConfigurationUtils.newConfigurationException(
        this.table = ConfigurationUtils.readStringProperty(params, "table");
        return numShards;
        return partitionTimePattern;
            );
        this.numShards = numberOfShards;
                throw ConfigurationUtils.newConfigurationException("kerberos_keytab", "required when authentication is [kerberos]");
    private final String table;  
    public String getTable() {  
    public String getKerberosKeytabPath() {  
        this.database = ConfigurationUtils.readStringProperty(params, "database");  
        this.consumeStartOffset = ConfigurationUtils.readOptionalStringProperty(params, "consume_start_offset");
     *  
    /**
import java.util.Map;
 * Configuration for the Hive ingestion source, parsed from {@code ingestion_source.param.*} settings.
package org.opensearch.plugin.hive;
                "authentication",
    private final int connectTimeoutMillis;
    public int getMaxRetries() {
    public String getPartitionTimePattern() {  
            }  
        return partitionOrder;
        this.metastoreServicePrincipal = ConfigurationUtils.readOptionalStringProperty(params, "metastore_service_principal");
        return connectTimeoutMillis;  
        return kerberosKeytabPath;
    private final int maxRetries;
    }  
    /** Returns the Hive Metastore Thrift URI (e.g., {@code thrift://host:9083}). */
    }
    private final String database;
    }
        return monitorIntervalMillis;  
    private final String kerberosPrincipal;
    }
    private final PartitionOrder partitionOrder;
            case "partition-time" -> PartitionOrder.PARTITION_TIME;
    }
    }
    public long getRetryIntervalMillis() {  
    public String getDatabase() {
            case "kerberos" -> AuthMode.KERBEROS;  
        if (this.authMode == AuthMode.KERBEROS) {  
    private final String metastoreServicePrincipal;
 */  
    /** Thrift transport mode: unframed (Hive 4 default) or framed (Hive 3). */  
        this.monitorIntervalMillis = TimeValue.parseTimeValue(interval, "monitor_interval").millis();
        FRAMED  
    public int getConnectTimeoutMillis() {
 * compatible open source license.
            case "partition-name" -> PartitionOrder.PARTITION_NAME;
    public long getMonitorIntervalMillis() {
