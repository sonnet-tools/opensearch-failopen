            totalServerRequestBytes += serverCallMetrics.getRequestBytes().getSum();
        builder.field("completed", totalServerCallsCompleted);
        if (totalServerBatchesSent > 0) {
    protected List<FlightNodeStats> readNodesFrom(StreamInput in) throws IOException {
            totalServerCallDuration += serverCallMetrics.getDuration().getSum();
        builder.field("completed", totalClientCallsCompleted);
        long totalClientBatchesReceived = 0;
        long totalClientRequestBytes = 0;
        for (FlightNodeStats nodeStats : getNodes()) {
        );
        builder.endObject();
        builder.field("received", totalClientBatchesReceived);
            "duration_nanos",
                "avg_duration",
import org.opensearch.core.common.unit.ByteSizeValue;
        }
            "duration_nanos",
    protected void writeNodesTo(StreamOutput out, List<FlightNodeStats> nodes) throws IOException {
        long totalServerCallsStarted = 0;
import org.opensearch.core.common.io.stream.StreamOutput;
        super(in);
        builder.humanReadableField("received_bytes", "received_size", new ByteSizeValue(totalClientBatchReceivedBytes));
            builder.humanReadableField(
        long totalClientCallDuration = 0;
            long avgProcessingTimeNanos = totalServerBatchProcessingTime / totalServerBatchesSent;
import org.opensearch.cluster.ClusterName;
        }
            builder.field("name", nodeStats.getNode().getName());
            totalClientCallDuration += clientCallMetrics.getDuration().getSum();
                "avg_processing_time_nanos",
            builder.field(
            builder.humanReadableField(
            totalServerCallsCompleted += serverCallMetrics.getCompleted();
        builder.endObject();
            builder.endObject();
        super(clusterName, nodes, failures);
            totalClientCallsStarted += clientCallMetrics.getStarted();
        }
            long avgProcessingTimeNanos = totalClientBatchProcessingTime / totalClientBatchesReceived;
        }
        long totalClientBatchesRequested = 0;
    public FlightStatsResponse(StreamInput in) throws IOException {
        long totalClientCallsCompleted = 0;
            builder.humanReadableField(
        long totalClientBatchProcessingTime = 0;
            FlightMetrics.ClientBatchMetrics clientBatchMetrics = metrics.getClientBatchMetrics();
        }
            );
                "avg_processing_time",
            totalClientBatchReceivedBytes += clientBatchMetrics.getReceivedBytes().getSum();
import java.util.List;
                nodeStats.getNode().getStreamAddress() != null
                new TimeValue(avgDurationNanos, java.util.concurrent.TimeUnit.NANOSECONDS)
        if (totalServerCallsCompleted > 0) {
        builder.endObject();
}
import org.opensearch.core.common.io.stream.StreamInput;
        if (totalClientBatchesReceived > 0) {
    @Override
        long totalClientCallsStarted = 0;
        builder.humanReadableField("request_bytes", "request", new ByteSizeValue(totalServerRequestBytes));
            builder.humanReadableField(
        builder.field("cluster_name", getClusterName().value());
 * SPDX-License-Identifier: Apache-2.0
        for (FlightNodeStats nodeStats : getNodes()) {
        builder.humanReadableField("response_bytes", "response", new ByteSizeValue(totalServerBatchSentBytes));
            "duration",
        builder.humanReadableField(
        long totalClientBatchReceivedBytes = 0;
import org.opensearch.core.xcontent.XContentBuilder;
            );
        builder.endObject();
                "avg_duration_nanos",
        long totalServerBatchesSent = 0;
                    : nodeStats.getNode().getAddress().toString()
            new TimeValue(totalServerCallDuration, java.util.concurrent.TimeUnit.NANOSECONDS)
        builder.field("started", totalServerCallsStarted);
        builder.humanReadableField(
import org.opensearch.common.unit.TimeValue;
 */
    }
            totalClientBatchesReceived += clientBatchMetrics.getBatchesReceived();
        builder.humanReadableField("sent_bytes", "sent_size", new ByteSizeValue(totalServerBatchSentBytes));
                "avg_processing_time",
    }
            totalServerBatchSentBytes += serverBatchMetrics.getSentBytes().getSum();
        builder.startObject("cluster_stats");
import java.io.IOException;
            totalClientBatchesRequested += clientBatchMetrics.getBatchesRequested();
            );
            totalClientBatchProcessingTime += clientBatchMetrics.getProcessingTime().getSum();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.ToXContentObject;
            long avgDurationNanos = totalClientCallDuration / totalClientCallsCompleted;
        if (totalClientCallsCompleted > 0) {
            "duration",
import org.opensearch.action.FailedNodeException;
        out.writeList(nodes);
            FlightMetrics.ServerCallMetrics serverCallMetrics = metrics.getServerCallMetrics();
        builder.field("sent", totalServerBatchesSent);
        );
            );
        return builder;
        builder.field("requested", totalClientBatchesRequested);
    }
                "avg_processing_time_nanos",
            totalServerBatchProcessingTime += serverBatchMetrics.getProcessingTime().getSum();
        builder.endObject();
        builder.endObject();
                "avg_duration",
            FlightMetrics.ClientCallMetrics clientCallMetrics = metrics.getClientCallMetrics();
        long totalServerBatchSentBytes = 0;
                new TimeValue(avgProcessingTimeNanos, java.util.concurrent.TimeUnit.NANOSECONDS)
    }
            );
                new TimeValue(avgProcessingTimeNanos, java.util.concurrent.TimeUnit.NANOSECONDS)
            long avgDurationNanos = totalServerCallDuration / totalServerCallsCompleted;
                    ? nodeStats.getNode().getStreamAddress().toString()
        aggregateClusterStats(builder, params);
        builder.startObject("client");
            FlightMetrics metrics = nodeStats.getMetrics();
        builder.startObject("nodes");
        long totalServerRequestBytes = 0;
            totalClientCallsCompleted += clientCallMetrics.getCompleted();
            totalServerBatchesSent += serverBatchMetrics.getBatchesSent();
        }
class FlightStatsResponse extends BaseNodesResponse<FlightNodeStats> implements ToXContentObject {
            builder.startObject(nodeStats.getNode().getId());
        builder.humanReadableField("request_bytes", "request", new ByteSizeValue(totalClientRequestBytes));
        long totalServerCallsCompleted = 0;
            nodeStats.getMetrics().toXContent(builder, params);
                "streamAddress",
                "avg_duration_nanos",
        builder.startObject("batches");
        long totalServerCallDuration = 0;
 *
                new TimeValue(avgDurationNanos, java.util.concurrent.TimeUnit.NANOSECONDS)
    @Override
/*
    @Override
    private void aggregateClusterStats(XContentBuilder builder, Params params) throws IOException {
            totalServerCallsStarted += serverCallMetrics.getStarted();
        long totalServerBatchProcessingTime = 0;
            FlightMetrics.ServerBatchMetrics serverBatchMetrics = metrics.getServerBatchMetrics();
        builder.startObject("server");
    }
        return in.readList(FlightNodeStats::new);
        builder.field("started", totalClientCallsStarted);
        builder.endObject();
 * this file be licensed under the Apache-2.0 license or a
    }
        builder.startObject();
package org.opensearch.arrow.flight.stats;
    public FlightStatsResponse(ClusterName clusterName, List<FlightNodeStats> nodes, List<FailedNodeException> failures) {
 * The OpenSearch Contributors require contributions made to
        builder.startObject("calls");
        builder.startObject("calls");
            totalClientRequestBytes += clientCallMetrics.getRequestBytes().getSum();
        builder.startObject("batches");
import org.opensearch.action.support.nodes.BaseNodesResponse;
        builder.endObject();
            new TimeValue(totalClientCallDuration, java.util.concurrent.TimeUnit.NANOSECONDS)
        builder.humanReadableField("response_bytes", "response", new ByteSizeValue(totalClientBatchReceivedBytes));
 * compatible open source license.
        builder.endObject();
