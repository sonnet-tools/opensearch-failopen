 *  
    }  
            "migration_successful",  
 * compatible open source license.
        Tags tags = createBaseTags(nodeId, indexName, tierType);
        Tags tags = createBaseTags(nodeId, indexName, tierType).addTag(REJECTION_REASON, reason);
 * Metrics for tracking tier migration operations including successful migrations,
}
        migrationLatency.record(value, tags);  
     * @param nodeId the node ID
            COUNTER_METRICS_UNIT
     * @param indexName the index name  
 * rejections, and latency.
    public final Histogram migrationLatency;
import org.opensearch.telemetry.metrics.tags.Tags;
            COUNTER_METRICS_UNIT
     * Records migration latency.
    public static final String TIER_TYPE = "tier_type";
    public void recordMigrationLatency(Double value, String nodeId, String indexName, String tierType) {
    /** Tag key for index name. */
        rejectionReason.add(1.0, tags);
     */
     * @param reason the rejection reason
    public void recordSuccessfulMigration(String nodeId, String indexName, String tierType) {  
 * @opensearch.experimental
            "Counter for rejected tier migrations with their reasons",
    private static final String LATENCY_METRIC_UNIT_MS = "ms";
        successfulMigrations = metricsRegistry.createCounter(
     * @param indexName the index name
        Tags tags = createBaseTags(nodeId, indexName, tierType);
    /** Counter for successful tier migrations. */
    /**  
     * Records a rejected migration.  
import org.opensearch.telemetry.metrics.MetricsRegistry;  
    public static final String REJECTION_REASON = "rejection_reason";  
        );  
            "Counter for successful tier migrations",
    public static final String INDEX_NAME = "index_name";
    private static final String COUNTER_METRICS_UNIT = "1";  
 *
     * @param tierType the tier type
    /**
     * @param nodeId the node ID  
    /** Tag key for rejection reason. */
     */
 * this file be licensed under the Apache-2.0 license or a
 */
        return Tags.create().addTag(NODE_ID, nodeId).addTag(INDEX_NAME, indexName).addTag(TIER_TYPE, tierType);  
    public final Counter successfulMigrations;  
    public TierActionMetrics(MetricsRegistry metricsRegistry) {
     * @param tierType the tier type  
        );  
import org.opensearch.telemetry.metrics.Histogram;
            LATENCY_METRIC_UNIT_MS
        );  
    }
        migrationLatency = metricsRegistry.createHistogram(
     * Records a successful migration.
     * @param tierType the tier type
            "Histogram for tracking end-to-end migration time",
/**  
    }  
    /** Counter for rejected tier migrations. */
    public static final String NODE_ID = "node_id";  
     */  
    }
    /** Tag key for node ID. */
        successfulMigrations.add(1.0, tags);
    /**  
 * The OpenSearch Contributors require contributions made to  
     */  
    /**  
     * @param metricsRegistry the metrics registry to create counters and histograms
    private Tags createBaseTags(String nodeId, String indexName, String tierType) {
/*  
     * @param nodeId the node ID
     * @param value the latency value in milliseconds
    /** Tag key for tier type. */  
    /** Histogram for tracking end-to-end migration time. */  
    public final Counter rejectionReason;
            "migration_rejection_reason",  
     * Creates a new TierActionMetrics instance.
package org.opensearch.storage.metrics;
public final class TierActionMetrics {  
 * SPDX-License-Identifier: Apache-2.0
        rejectionReason = metricsRegistry.createCounter(
    public void recordRejectedMigration(String nodeId, String indexName, String tierType, String reason) {  
 */  
     * @param indexName the index name
            "migration_latency",  
    }
import org.opensearch.telemetry.metrics.Counter;
