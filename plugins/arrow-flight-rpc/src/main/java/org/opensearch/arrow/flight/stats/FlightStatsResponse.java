        builder.endObject();
    }  
            "duration",
        long totalClientBatchesRequested = 0;
        }
        );
        long totalServerCallsCompleted = 0;
 *
        super(in);
            );  
import org.opensearch.core.common.unit.ByteSizeValue;
            );
        long totalClientBatchProcessingTime = 0;
            builder.field("name", nodeStats.getNode().getName());  
            totalClientBatchesRequested += clientBatchMetrics.getBatchesRequested();
 * The OpenSearch Contributors require contributions made to  
            FlightMetrics.ServerCallMetrics serverCallMetrics = metrics.getServerCallMetrics();
            totalClientRequestBytes += clientCallMetrics.getRequestBytes().getSum();
            long avgDurationNanos = totalServerCallDuration / totalServerCallsCompleted;
    }  
            );
        builder.endObject();
        out.writeList(nodes);
            );
        builder.humanReadableField(
        return builder;
            builder.humanReadableField(  
    protected void writeNodesTo(StreamOutput out, List<FlightNodeStats> nodes) throws IOException {  
            builder.field(
import org.opensearch.action.support.nodes.BaseNodesResponse;
                "avg_duration_nanos",
            totalServerRequestBytes += serverCallMetrics.getRequestBytes().getSum();
            builder.humanReadableField(
                "avg_duration",
            totalClientCallsStarted += clientCallMetrics.getStarted();
        }  
                "avg_processing_time_nanos",  
    public FlightStatsResponse(ClusterName clusterName, List<FlightNodeStats> nodes, List<FailedNodeException> failures) {
        builder.field("started", totalClientCallsStarted);
        }
                "avg_processing_time",
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.endObject();
            builder.humanReadableField(  
import org.opensearch.cluster.ClusterName;  
        builder.humanReadableField(  
        if (totalServerCallsCompleted > 0) {
                new TimeValue(avgDurationNanos, java.util.concurrent.TimeUnit.NANOSECONDS)  
            totalClientCallDuration += clientCallMetrics.getDuration().getSum();
        builder.startObject("calls");  
        return in.readList(FlightNodeStats::new);
        builder.humanReadableField("response_bytes", "response", new ByteSizeValue(totalClientBatchReceivedBytes));
        long totalClientCallDuration = 0;
        builder.startObject("batches");
            new TimeValue(totalClientCallDuration, java.util.concurrent.TimeUnit.NANOSECONDS)  
    @Override
        builder.startObject();  
        builder.startObject("client");
        long totalClientBatchReceivedBytes = 0;
        );  
        aggregateClusterStats(builder, params);
    }  
                    : nodeStats.getNode().getAddress().toString()
        long totalServerCallDuration = 0;  
            long avgDurationNanos = totalClientCallDuration / totalClientCallsCompleted;  
            FlightMetrics.ServerBatchMetrics serverBatchMetrics = metrics.getServerBatchMetrics();
import org.opensearch.core.common.io.stream.StreamInput;
            totalServerCallsStarted += serverCallMetrics.getStarted();
        builder.humanReadableField("received_bytes", "received_size", new ByteSizeValue(totalClientBatchReceivedBytes));
                new TimeValue(avgProcessingTimeNanos, java.util.concurrent.TimeUnit.NANOSECONDS)
                "streamAddress",
        builder.startObject("nodes");  
 * SPDX-License-Identifier: Apache-2.0
/*  
        builder.field("cluster_name", getClusterName().value());
    }
        if (totalServerBatchesSent > 0) {
    }
        builder.field("completed", totalClientCallsCompleted);
            FlightMetrics metrics = nodeStats.getMetrics();
            builder.endObject();
                "avg_processing_time_nanos",
        long totalServerBatchProcessingTime = 0;
}
        long totalServerBatchesSent = 0;  
            totalClientCallsCompleted += clientCallMetrics.getCompleted();  
        builder.startObject("calls");
 * this file be licensed under the Apache-2.0 license or a
        builder.startObject("server");  
            new TimeValue(totalServerCallDuration, java.util.concurrent.TimeUnit.NANOSECONDS)
import java.util.List;  
        builder.field("received", totalClientBatchesReceived);
                "avg_duration",  
import org.opensearch.core.xcontent.XContentBuilder;  
            long avgProcessingTimeNanos = totalClientBatchProcessingTime / totalClientBatchesReceived;
    @Override  
                "avg_duration_nanos",
                new TimeValue(avgDurationNanos, java.util.concurrent.TimeUnit.NANOSECONDS)
        long totalServerBatchSentBytes = 0;
        builder.endObject();
        builder.startObject("cluster_stats");  
                nodeStats.getNode().getStreamAddress() != null  
        builder.field("sent", totalServerBatchesSent);
        }
 */  
    public FlightStatsResponse(StreamInput in) throws IOException {
    protected List<FlightNodeStats> readNodesFrom(StreamInput in) throws IOException {
        super(clusterName, nodes, failures);  
package org.opensearch.arrow.flight.stats;
            totalServerBatchesSent += serverBatchMetrics.getBatchesSent();
        }
                "avg_processing_time",
                new TimeValue(avgProcessingTimeNanos, java.util.concurrent.TimeUnit.NANOSECONDS)  
            totalServerBatchProcessingTime += serverBatchMetrics.getProcessingTime().getSum();
            builder.humanReadableField(
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.common.unit.TimeValue;
            nodeStats.getMetrics().toXContent(builder, params);
        long totalClientBatchesReceived = 0;  
        builder.humanReadableField("response_bytes", "response", new ByteSizeValue(totalServerBatchSentBytes));
class FlightStatsResponse extends BaseNodesResponse<FlightNodeStats> implements ToXContentObject {
import java.io.IOException;
        builder.humanReadableField("request_bytes", "request", new ByteSizeValue(totalServerRequestBytes));  
            FlightMetrics.ClientCallMetrics clientCallMetrics = metrics.getClientCallMetrics();
            totalClientBatchesReceived += clientBatchMetrics.getBatchesReceived();  
        builder.field("requested", totalClientBatchesRequested);  
        builder.humanReadableField("sent_bytes", "sent_size", new ByteSizeValue(totalServerBatchSentBytes));  
        }  
            builder.startObject(nodeStats.getNode().getId());
        builder.field("started", totalServerCallsStarted);  
            totalServerCallsCompleted += serverCallMetrics.getCompleted();  
        builder.endObject();  
        builder.startObject("batches");
        builder.endObject();  
                    ? nodeStats.getNode().getStreamAddress().toString()
            FlightMetrics.ClientBatchMetrics clientBatchMetrics = metrics.getClientBatchMetrics();
        long totalClientCallsStarted = 0;  
    }  
        if (totalClientCallsCompleted > 0) {
            totalServerBatchSentBytes += serverBatchMetrics.getSentBytes().getSum();  
        long totalClientCallsCompleted = 0;
    @Override
        if (totalClientBatchesReceived > 0) {  
        builder.endObject();
        long totalServerCallsStarted = 0;
            "duration_nanos",  
        for (FlightNodeStats nodeStats : getNodes()) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    private void aggregateClusterStats(XContentBuilder builder, Params params) throws IOException {
        for (FlightNodeStats nodeStats : getNodes()) {
 * compatible open source license.
import org.opensearch.action.FailedNodeException;
            totalClientBatchReceivedBytes += clientBatchMetrics.getReceivedBytes().getSum();
        builder.humanReadableField("request_bytes", "request", new ByteSizeValue(totalClientRequestBytes));
        builder.endObject();
        long totalClientRequestBytes = 0;  
        long totalServerRequestBytes = 0;
            totalClientBatchProcessingTime += clientBatchMetrics.getProcessingTime().getSum();
        builder.field("completed", totalServerCallsCompleted);
        builder.endObject();
            long avgProcessingTimeNanos = totalServerBatchProcessingTime / totalServerBatchesSent;
            totalServerCallDuration += serverCallMetrics.getDuration().getSum();
            );  
            "duration",
            "duration_nanos",
