            histogram.record(value);
 * this file be licensed under the Apache-2.0 license or a
    public void recordInHistogram(Histogram histogram, Double value, Optional<Tags> tags) {  
            tags = tags.addTag(SHARD_ID, shardId.get());
        mergesTriggered = metricsRegistry.createCounter(
    private static final String LATENCY_METRIC_UNIT_MS = "ms";
        skipsFromConfigValidator = metricsRegistry.createCounter(
            "Counter for number of force merges skipped due to Configuration Validator.",
import java.util.Objects;  
        if (Objects.isNull(tags) || tags.isEmpty()) {
    public void incrementCounter(Counter counter, Double value, Optional<Tags> tags) {
    }
    public AutoForceMergeMetrics(MetricsRegistry metricsRegistry) {
            LATENCY_METRIC_UNIT_MS
            COUNTER_METRICS_UNIT
package org.opensearch.index.autoforcemerge;
        histogram.record(value, tags.get());
            COUNTER_METRICS_UNIT
    public static final String NODE_ID = "node_id";
 */
    public final Counter segmentCount;
 * Class containing metrics (counters/latency) specific to Auto Force merges.
    public Optional<Tags> getTags(Optional<String> nodeId, Optional<String> shardId) {
    }
            "Counter for tracking shard size during force merge operations.",
    public final Counter skipsFromNodeValidator;
            SIZE_METRIC_UNIT
    public final Histogram schedulerExecutionTime;
    }
        if (Objects.isNull(tags) || tags.isEmpty()) {  
        mergesFailed = metricsRegistry.createCounter(
            "auto_force_merge.merges.failed",  
    public final Counter skipsFromConfigValidator;
        }
/**  
import java.util.Optional;
import org.opensearch.telemetry.metrics.Counter;
 * compatible open source license.
    }  
            return;
            COUNTER_METRICS_UNIT
            "Counter for tracking segment count during force merge operations.",
        );  
 * SPDX-License-Identifier: Apache-2.0
    public final Histogram shardMergeLatency;  
            tags = tags.addTag(NODE_ID, nodeId.get());
        );  
            return;  
            "auto_force_merge.merges.skipped.node_validator",  
            "auto_force_merge.shard.size",  
        } else if (nodeId.isPresent()) {  
import org.opensearch.telemetry.metrics.MetricsRegistry;  
            "Histogram for tracking time taken by force merge on individual shards.",
}  
 *
import org.opensearch.telemetry.metrics.Histogram;
            "Counter for number of force merges skipped due to Node Validator.",
        shardMergeLatency = metricsRegistry.createHistogram(
            COUNTER_METRICS_UNIT
import org.opensearch.telemetry.metrics.tags.Tags;
        Tags tags = Tags.create();
    public final Counter mergesFailed;  
            LATENCY_METRIC_UNIT_MS
    public final Counter mergesTriggered;  
        );  
        skipsFromNodeValidator = metricsRegistry.createCounter(
        }
        return Optional.of(tags);
 * @opensearch.internal  
        );  
        );  
        );  
            "auto_force_merge.merges.skipped.config_validator",  
            counter.add(value);
        schedulerExecutionTime = metricsRegistry.createHistogram(
 * The OpenSearch Contributors require contributions made to  
 *
            "Histogram for tracking total scheduler execution time.",
        if (shardId.isPresent()) {
        }  
    public static final String SHARD_ID = "shard_id";  
        );  
public class AutoForceMergeMetrics {
    private static final String COUNTER_METRICS_UNIT = "1";
        segmentCount = metricsRegistry.createCounter(
 */  
    // Shard specific metrics
            "Counter for number of force merges triggered.",
/*  
        shardSize = metricsRegistry.createCounter(
            "auto_force_merge.scheduler.execution_time",  
    private static final String SIZE_METRIC_UNIT = "bytes";  
            "auto_force_merge.merges.triggered",  
        );  
            "auto_force_merge.shard.segment_count",  
        counter.add(value, tags.get());
            "Counter for number of force merges failed.",
    public final Counter shardSize;
            COUNTER_METRICS_UNIT
            "auto_force_merge.shard.merge_latency",  
