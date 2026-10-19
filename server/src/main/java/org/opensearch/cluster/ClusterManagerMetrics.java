        leaderCheckFailureCounter = metricsRegistry.createCounter(
package org.opensearch.cluster;
    public static final String REASON_TAG = "reason";
            "Counter for number of failed async fetches",
    public final Counter asyncFetchSuccessCounter;  
            LATENCY_METRIC_UNIT_MS
    public static final String FOLLOWER_NODE_ID_TAG = "follower_node_id";
            "Counter for number of successful async fetches",
 *
        );  
        rerouteHistogram = metricsRegistry.createHistogram(
        asyncFetchSuccessCounter = metricsRegistry.createCounter(
        );
 *
            "Counter for number of failed leader checks",  
        histogram.record(value, tags.get());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.telemetry.metrics.Counter;
            counter.add(value);
    public void incrementCounter(Counter counter, Double value) {
import org.opensearch.telemetry.metrics.Histogram;
        clusterStateComputeHistogram = metricsRegistry.createHistogram(
}  
    public ClusterManagerMetrics(MetricsRegistry metricsRegistry) {  
 * Class containing metrics (counters/latency) specific to ClusterManager.
import java.util.Optional;
/*  
            "leader.checker.failure.count",
        clusterStatePublishHistogram = metricsRegistry.createHistogram(  
            "async.fetch.failure.count",
        clusterStateListenersHistogram = metricsRegistry.createHistogram(  
import java.util.Objects;  
            "async.fetch.success.count",  
    public void incrementCounter(Counter counter, Double value, Optional<Tags> tags) {
        );
        );
    }  
            COUNTER_METRICS_UNIT
            COUNTER_METRICS_UNIT  
        asyncFetchFailureCounter = metricsRegistry.createCounter(  
            "Histogram for recording time taken to compute new cluster state",  
        );
            "cluster.state.new.compute.latency",
            "Histogram for recording time taken to publish a new cluster state",
    }
    public final Histogram clusterStatePublishHistogram;
            "allocation.reroute.latency",  
    public void recordLatency(Histogram histogram, Double value) {
    private static final String COUNTER_METRICS_UNIT = "1";
    private static final String LATENCY_METRIC_UNIT_MS = "ms";  
            return;
    public final Counter leaderCheckFailureCounter;  
    public void recordLatency(Histogram histogram, Double value, Optional<Tags> tags) {
/**  
    public final Counter nodeLeftCounter;
        );
        followerChecksFailureCounter = metricsRegistry.createCounter(
            "followers.checker.failure.count",  
    }
        clusterStateAppliersHistogram = metricsRegistry.createHistogram(
        }  
            LATENCY_METRIC_UNIT_MS
        }  
 */  
        );
        if (Objects.isNull(tags) || tags.isEmpty()) {  
            "Counter for number of failed follower checks",
    public final Histogram rerouteHistogram;
import org.opensearch.telemetry.metrics.tags.Tags;
            histogram.record(value);
        incrementCounter(counter, value, Optional.empty());
        );  
            "cluster.state.publish.success.latency",
            "Histogram for tracking the latency of cluster state appliers",  
    public final Counter asyncFetchFailureCounter;
            LATENCY_METRIC_UNIT_MS  
        counter.add(value, tags.get());
            "cluster.state.appliers.latency",
    public final Histogram clusterStateComputeHistogram;  
            LATENCY_METRIC_UNIT_MS  
            "Histogram for recording latency of shard re-routing",
        histogram.record(value);
        nodeLeftCounter = metricsRegistry.createCounter("node.left.count", "Counter for node left operation", COUNTER_METRICS_UNIT);
 * SPDX-License-Identifier: Apache-2.0
        if (Objects.isNull(tags) || tags.isEmpty()) {  
public final class ClusterManagerMetrics {
 * compatible open source license.
    public final Histogram clusterStateAppliersHistogram;  
        );  
            "Histogram for tracking the latency of cluster state listeners",
 * @opensearch.internal  
            LATENCY_METRIC_UNIT_MS
            COUNTER_METRICS_UNIT
    public final Histogram clusterStateListenersHistogram;
    }
 * The OpenSearch Contributors require contributions made to  
    }  
            return;
            COUNTER_METRICS_UNIT
import org.opensearch.telemetry.metrics.MetricsRegistry;  
 */
    public final Counter followerChecksFailureCounter;
            "cluster.state.listeners.latency",
