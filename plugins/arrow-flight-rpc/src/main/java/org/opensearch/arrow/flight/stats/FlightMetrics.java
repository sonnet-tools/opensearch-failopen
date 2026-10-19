    void recordClientCallStarted() {
            clientCallCompletedByStatus.computeIfAbsent(status, k -> new LongAdder()).add(count);  
            out.writeString(status);  
            out.writeString(status);
        }  
    private final ConcurrentHashMap<String, LongAdder> serverCallCompletedByStatus = new ConcurrentHashMap<>();  
        private final long completed;  
        histogram.count.add(count);  
        public long getCompleted() {  
            return count > 0 ? (double) sum / count : 0;  
        builder.humanReadableField(
        }
            HistogramSnapshot duration,  
        builder.field("completed", clientCallCompleted.sum());
        long getBatchesSent() {
            clientRequestBytes.snapshot(),
    @Override  
    static class Histogram {  
            clientCallCompletedByStatus,
            return sum;  
            return max;
            return sentBytes;
        addDurationHistogramToXContent(builder, "duration", serverCallDuration.snapshot(), humanReadable);
        builder.field("completed", serverCallCompleted.sum());  
        builder.endObject();
        this.clientChannelsActive = clientChannelsActive;  
        this.serverThreadsTotal = serverThreadsTotal;
            long started,  
        private final HistogramSnapshot processingTime;  
        while (newValue > (current = maxValue.get())) {  
        readHistogram(in, serverCallDuration);
import java.util.concurrent.ConcurrentHashMap;
        long totalClientReceivedBytes = clientBatchReceivedBytes.snapshot().getSum();
            ConcurrentHashMap<String, LongAdder> completedByStatus,
            return requestBytes;
        builder.field("client_threads_active", clientThreadsActive);  
    // Server metrics  
    }
        private final long batchesReceived;  
    private void readHistogram(StreamInput in, Histogram histogram) throws IOException {
        clientCallCompletedByStatus.computeIfAbsent(status, k -> new LongAdder()).increment();
    }
    private volatile int clientChannelsActive;
        builder.humanReadableField("arrow_allocated_bytes", "arrow_allocated", new ByteSizeValue(arrowAllocatedBytes));  
        builder.startObject("status");
        }
        }  
        builder.humanReadableField("sum_bytes", "sum", new ByteSizeValue(snapshot.getSum()));  
        writeHistogram(out, clientBatchProcessingTime);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject("server");
        builder.field("count", snapshot.getCount());
        public ClientBatchMetrics(
    static class ClientBatchMetrics {
            long current;
            return duration;  
        }
        addBytesHistogramToXContent(builder, "sent_bytes", serverBatchSentBytes.snapshot(), humanReadable);  
    static class HistogramSnapshot {  
        }
    private final Histogram clientRequestBytes = new Histogram();
        }
        serverCallStarted.add(in.readVLong());  
        long current;
        addDurationHistogramToXContent(builder, "duration", clientCallDuration.snapshot(), humanReadable);  
            this.batchesReceived = batchesReceived;
        // Client call metrics
            long count = in.readVLong();
    }
        this.clientThreadsActive = clientThreadsActive;
            return count;
        return new ServerCallMetrics(
        public HistogramSnapshot snapshot() {  
        serverBatchSentBytes.record(bytes);
        while (newValue < (current = minValue.get())) {
        out.writeVLong(arrowPeakBytes);  
        clientThreadsTotal = in.readVInt();  
            this.completed = completed;
}
        writeHistogram(out, clientBatchReceivedBytes);  
        }
            sum.add(value);
        builder.field("count", snapshot.getCount());
            this.requestBytes = requestBytes;
            ConcurrentHashMap<String, LongAdder> completedByStatus,
            HistogramSnapshot requestBytes,
            "avg",
    }
        out.writeVLong(clientCallStarted.sum());
            HistogramSnapshot requestBytes,
        // Client batch metrics
        out.writeVInt(clientThreadsActive);
import java.util.concurrent.atomic.LongAdder;  
/*  
        builder.humanReadableField("max_bytes", "max", new ByteSizeValue(snapshot.getMax()));
        throws IOException {  
            clientCallDuration.snapshot(),  
        for (int i = 0; i < statusCount; i++) {  
            return duration;
        private final long started;
        long min = in.readVLong();
            out.writeVLong(serverCallCompletedByStatus.get(status).sum());  
            this.batchesSent = batchesSent;  
            long responseBytes
    }
            this.processingTime = processingTime;
        HistogramSnapshot getProcessingTime() {
        ) {  
        }
    private final LongAdder serverCallStarted = new LongAdder();
            serverCallDuration.snapshot(),
        public double getAverage() {
        public long getCount() {
        public long getMax() {
            minValue.compareAndSet(current, newValue);  
    }
        private final AtomicLong max = new AtomicLong(Long.MIN_VALUE);
            return requestBytes;  
            long responseBytes
        private final ConcurrentHashMap<String, LongAdder> completedByStatus;  
        this.directMemoryBytes = directMemoryBytes;
    ) {
        long current;
        builder.endObject();  
        builder.endObject();
        addBytesHistogramToXContent(builder, "request_bytes", clientRequestBytes.snapshot(), humanReadable);
        out.writeVInt(serverThreadsTotal);
        }  
    FlightMetrics(StreamInput in) throws IOException {
    @Override
    void recordClientCallCompleted(String status, long durationNanos) {  
        private final HistogramSnapshot requestBytes;  
            return receivedBytes;
        builder.endObject();  
import java.util.concurrent.atomic.AtomicLong;
        HistogramSnapshot getDuration() {
        }
    private volatile int clientThreadsActive;
    }
        builder.endObject();
        builder.humanReadableField("avg_bytes", "avg", new ByteSizeValue((long) snapshot.getAverage()));  
        serverCallCompleted.increment();
        serverCallStarted.increment();
            builder.field("client_thread_utilization_percent", (clientThreadsActive * 100.0) / clientThreadsTotal);
        builder.humanReadableField("response_bytes", "response", new ByteSizeValue(totalServerSentBytes));  
            return min;
        out.writeVLong(clientBatchRequested.sum());
            long completed,
            return batchesSent;  
        clientRequestBytes.record(bytes);  
        directMemoryBytes = in.readVLong();
            long max = this.max.get();
/**
        clientBatchReceivedBytes.record(bytes);  
            return completed;
        private final long responseBytes;  
    private final LongAdder clientBatchReceived = new LongAdder();
        public HistogramSnapshot getDuration() {
            builder.field(status, clientCallCompletedByStatus.get(status).sum());
            long current;  
        }
        public HistogramSnapshot(long count, long sum, long min, long max) {  
        HistogramSnapshot getSentBytes() {  
        public long getBatchesReceived() {
        builder.field("started", serverCallStarted.sum());
            clientCallCompleted.sum(),
            this.requestBytes = requestBytes;
        for (String status : serverCallCompletedByStatus.keySet()) {
        builder.humanReadableField("arrow_peak_bytes", "arrow_peak", new ByteSizeValue(arrowPeakBytes));
        private final long count;
        builder.humanReadableField("sum_nanos", "sum", new TimeValue(snapshot.getSum(), java.util.concurrent.TimeUnit.NANOSECONDS));
        clientCallCompleted.add(in.readVLong());
            clientBatchProcessingTime.snapshot()
            this.duration = duration;
        }
    void recordClientRequestBytes(long bytes) {
        int serverThreadsActive,  
            }  
        private final long sum;
        builder.field("sent", serverBatchSent.sum());
        long getCompleted() {
    }
import org.opensearch.common.unit.TimeValue;
        );  
    private final LongAdder clientCallCompleted = new LongAdder();
            long count = in.readVLong();
        builder.humanReadableField("response_bytes", "response", new ByteSizeValue(totalClientReceivedBytes));
    }
        serverCallCompletedByStatus.computeIfAbsent(status, k -> new LongAdder()).increment();
    private final ConcurrentHashMap<String, LongAdder> clientCallCompletedByStatus = new ConcurrentHashMap<>();
            maxValue.compareAndSet(current, newValue);
        // Server call metrics
    private final Histogram clientBatchProcessingTime = new Histogram();
            this.processingTime = processingTime;
        builder.field("server_threads_total", serverThreadsTotal);  
                min.compareAndSet(current, value);
            HistogramSnapshot receivedBytes,
        builder.endObject();
        public void record(long value) {  
        builder.endObject();
        serverBatchSent.add(in.readVLong());  
        private void updateMax(long value) {
        }  
        private final LongAdder count = new LongAdder();
        int clientThreadsActive,
    ServerCallMetrics getServerCallMetrics() {  
            this.receivedBytes = receivedBytes;  
        if (clientThreadsTotal > 0) {
        out.writeVInt(clientThreadsTotal);  
            serverCallCompleted.sum(),  
        writeHistogram(out, clientCallDuration);  
    private final LongAdder clientCallStarted = new LongAdder();  
        clientBatchRequested.increment();
 * Provides both per-call and aggregated metrics.
        out.writeVLong(snapshot.getMax());  
        }
        long totalServerSentBytes = serverBatchSentBytes.snapshot().getSum();
            this.max = max;
    private void addDurationHistogramToXContent(XContentBuilder builder, String name, HistogramSnapshot snapshot, boolean humanReadable)
            updateMax(value);
        addBytesHistogramToXContent(builder, "received_bytes", clientBatchReceivedBytes.snapshot(), humanReadable);  
    long getStatusCount(boolean isClient, String status) {
    private void updateMin(AtomicLong minValue, long newValue) {  
        // Resource metrics
    private volatile long directMemoryBytes;  
        public long getBatchesRequested() {
 * compatible open source license.
        out.writeVInt(serverThreadsActive);
    private final Histogram serverRequestBytes = new Histogram();
            out.writeVLong(clientCallCompletedByStatus.get(status).sum());
        readHistogram(in, clientBatchReceivedBytes);
import org.opensearch.core.xcontent.XContentBuilder;
        int clientThreadsTotal,
        ) {  
            HistogramSnapshot processingTime
        builder.startObject(name);
    ClientBatchMetrics getClientBatchMetrics() {  
        clientCallDuration.record(durationNanos);  
        builder.startObject("server_calls");
    static class ClientCallMetrics {
                min = 0;
        if (serverThreadsTotal > 0) {
        public ClientCallMetrics(
    }
        writeHistogram(out, serverBatchSentBytes);
            this.duration = duration;
        }  
    private final LongAdder serverBatchSent = new LongAdder();
            return processingTime;
        this.arrowAllocatedBytes = arrowAllocatedBytes;
        );  
        builder.startObject("client");
        return new ClientCallMetrics(
import org.opensearch.core.common.io.stream.Writeable;
            clientCallStarted.sum(),  
        return new ServerBatchMetrics(serverBatchSent.sum(), serverBatchSentBytes.snapshot(), serverBatchProcessingTime.snapshot());  
            serverBatchSentBytes.snapshot().getSum()
            this.batchesRequested = batchesRequested;
        out.writeVLong(arrowAllocatedBytes);
        private final long max;
        }
        serverChannelsActive = in.readVInt();
        long directMemoryBytes,  
        int serverThreadsTotal,
        serverCallCompleted.add(in.readVLong());
        ) {  
    static class ServerCallMetrics {  
import org.opensearch.core.xcontent.ToXContentFragment;  
class FlightMetrics implements Writeable, ToXContentFragment {  
            serverRequestBytes.snapshot(),  
    private final Histogram serverCallDuration = new Histogram();
        }
        out.writeVLong(directMemoryBytes);
        serverBatchSent.increment();
        }
        this.serverChannelsActive = serverChannelsActive;
 * SPDX-License-Identifier: Apache-2.0
        }
    }
            clientBatchReceivedBytes.snapshot().getSum()
    ServerBatchMetrics getServerBatchMetrics() {
        builder.startObject("flight_metrics");
        builder.field("requested", clientBatchRequested.sum());
            return batchesRequested;
        serverCallDuration.record(durationNanos);  
        }  
        // Server batch metrics
        builder.startObject(name);  
    }
        builder.humanReadableField("min_bytes", "min", new ByteSizeValue(snapshot.getMin()));
        }
            return new HistogramSnapshot(count, sum, min, max);
    }
        public long getStarted() {
        builder.field("server_threads_active", serverThreadsActive);
            serverCallCompletedByStatus,
        }  
        writeHistogram(out, serverBatchProcessingTime);
        }  
    void recordClientBatchRequested() {  
            while (value < (current = min.get())) {  
            clientBatchReceivedBytes.snapshot(),
        long count = in.readVLong();
        long getStarted() {  
import org.opensearch.core.common.unit.ByteSizeValue;
        builder.field("received", clientBatchReceived.sum());
        this.serverThreadsActive = serverThreadsActive;
        LongAdder adder = statusMap.get(status);
    void recordServerRequestBytes(long bytes) {
            this.count = count;
        clientCallStarted.add(in.readVLong());  
    void recordServerCallStarted() {
    private final Histogram serverBatchProcessingTime = new Histogram();
    ClientCallMetrics getClientCallMetrics() {
        updateMin(histogram.min, min);
            long min = this.min.get();  
        return adder != null ? adder.sum() : 0;
        }
        clientBatchReceived.add(in.readVLong());
    void recordClientBatchReceived(long bytes, long processingTimeNanos) {
        }
    }  
    private final Histogram serverBatchSentBytes = new Histogram();  
            while (value > (current = max.get())) {
    }  
            clientBatchRequested.sum(),
            this.completed = completed;
        // Server batch metrics
        builder.humanReadableField("direct_memory_bytes", "direct_memory", new ByteSizeValue(directMemoryBytes));
        builder.endObject();
        private final HistogramSnapshot processingTime;
        }
            this.completedByStatus = completedByStatus;  
        );  
        // Client call metrics
    public void writeTo(StreamOutput out) throws IOException {  
        int serverChannelsActive  
        HistogramSnapshot snapshot = histogram.snapshot();
    private void addBytesHistogramToXContent(XContentBuilder builder, String name, HistogramSnapshot snapshot, boolean humanReadable)
    }  
        builder.field("client_channels_active", clientChannelsActive);
    }  
    }
    }
        writeHistogram(out, serverRequestBytes);  
        }  
            long count = this.count.sum();
            new TimeValue((long) snapshot.getAverage(), java.util.concurrent.TimeUnit.NANOSECONDS)
    }
        builder.endObject();
        serverRequestBytes.record(bytes);  
            long completed,
                max = 0;
    private volatile int serverThreadsTotal;
    static class ServerBatchMetrics {  
        );
        public long getSum() {
        out.writeVInt(clientChannelsActive);  
    private final Histogram clientBatchReceivedBytes = new Histogram();  
        // Server call metrics  
            }  
        ConcurrentHashMap<String, LongAdder> statusMap = isClient ? clientCallCompletedByStatus : serverCallCompletedByStatus;  
    FlightMetrics() {}
        public HistogramSnapshot getReceivedBytes() {  
            builder.field(status, serverCallCompletedByStatus.get(status).sum());  
            String status = in.readString();
        writeHistogram(out, serverCallDuration);
        out.writeVInt(serverCallCompletedByStatus.size());  
    void updateResourceMetrics(  
                max.compareAndSet(current, value);
            if (count == 0) {  
        statusCount = in.readVInt();
        private final AtomicLong min = new AtomicLong(Long.MAX_VALUE);  
        builder.field("server_channels_active", serverChannelsActive);
            this.completedByStatus = completedByStatus;  
        boolean humanReadable = params.paramAsBoolean("human", false);
        builder.startObject("client_calls");  
        private final long started;
        private final LongAdder sum = new LongAdder();
        private final long completed;
        builder.endObject();
        addBytesHistogramToXContent(builder, "request_bytes", serverRequestBytes.snapshot(), humanReadable);  
        serverThreadsTotal = in.readVInt();
        clientCallStarted.increment();
    }
    }  
        addDurationHistogramToXContent(builder, "processing_time", clientBatchProcessingTime.snapshot(), humanReadable);
        builder.startObject("client_batches");  
        arrowPeakBytes = in.readVLong();  
        out.writeVLong(serverCallStarted.sum());
    // Server per-batch metrics - server only sends batches
        builder.startObject("server_batches");
            HistogramSnapshot duration,  
        updateMax(histogram.max, max);  
        }
            long started,  
            this.responseBytes = responseBytes;  
        histogram.sum.add(sum);
    }
        this.arrowPeakBytes = arrowPeakBytes;  
        readHistogram(in, clientCallDuration);
            return started;
        private final long min;  
    // Client per-call metrics
        for (String status : serverCallCompletedByStatus.keySet()) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
    private void updateMax(AtomicLong maxValue, long newValue) {
            return batchesReceived;  
        ServerCallMetrics(
        long max = in.readVLong();
        }
        out.writeVLong(snapshot.getCount());  
        builder.field("client_threads_total", clientThreadsTotal);
            long batchesRequested,
        readHistogram(in, serverBatchProcessingTime);
    void recordServerCallCompleted(String status, long durationNanos) {  
    }
        }  
 * this file be licensed under the Apache-2.0 license or a
        private final long batchesSent;
        return builder;
    }
        ServerBatchMetrics(long batchesSent, HistogramSnapshot sentBytes, HistogramSnapshot processingTime) {
    private volatile int clientThreadsTotal;
            return processingTime;
        builder.humanReadableField("max_nanos", "max", new TimeValue(snapshot.getMax(), java.util.concurrent.TimeUnit.NANOSECONDS));
    // Client per-batch metrics - client only receives batches  
        private final HistogramSnapshot requestBytes;
    }
    }
            long batchesReceived,  
    private volatile int serverThreadsActive;  
        builder.endObject();
        serverThreadsActive = in.readVInt();
        serverBatchProcessingTime.record(processingTimeNanos);  
            count.increment();
        out.writeVInt(clientCallCompletedByStatus.size());
            this.started = started;
        clientCallCompleted.increment();
        public long getMin() {  
        for (String status : clientCallCompletedByStatus.keySet()) {
package org.opensearch.arrow.flight.stats;
        out.writeVLong(snapshot.getMin());
        out.writeVLong(serverBatchSent.sum());  
        // Client batch metrics  
import org.opensearch.core.common.io.stream.StreamInput;
        }
        clientThreadsActive = in.readVInt();
        addDurationHistogramToXContent(builder, "processing_time", serverBatchProcessingTime.snapshot(), humanReadable);
    private volatile long arrowAllocatedBytes;
            this.sentBytes = sentBytes;
        clientChannelsActive = in.readVInt();  
        }
        this.clientThreadsTotal = clientThreadsTotal;  
import java.io.IOException;  
    private volatile long arrowPeakBytes;
    // Resource metrics - these are point-in-time snapshots  
 * The OpenSearch Contributors require contributions made to  
        readHistogram(in, serverRequestBytes);  
        private final long batchesRequested;
        out.writeVLong(snapshot.getSum());
        private final HistogramSnapshot receivedBytes;
    private final Histogram clientCallDuration = new Histogram();  
        throws IOException {
        out.writeVLong(serverCallCompleted.sum());
        readHistogram(in, clientRequestBytes);  
        clientBatchProcessingTime.record(processingTimeNanos);
            builder.field("server_thread_utilization_percent", (serverThreadsActive * 100.0) / serverThreadsTotal);  
        int statusCount = in.readVInt();
    private void writeHistogram(StreamOutput out, Histogram histogram) throws IOException {
        private final ConcurrentHashMap<String, LongAdder> completedByStatus;
    private final LongAdder clientBatchRequested = new LongAdder();
        }
        for (String status : clientCallCompletedByStatus.keySet()) {  
            this.started = started;
        readHistogram(in, clientBatchProcessingTime);  
            clientBatchReceived.sum(),  
    private volatile int serverChannelsActive;  
        private void updateMin(long value) {
        private final HistogramSnapshot sentBytes;
            this.min = min;  
        }  
        private final HistogramSnapshot duration;
            updateMin(value);  
    void recordServerBatchSent(long bytes, long processingTimeNanos) {  
            long sum = this.sum.sum();
        out.writeVLong(clientBatchReceived.sum());
    private final LongAdder serverCallCompleted = new LongAdder();
        HistogramSnapshot getRequestBytes() {  
        out.writeVInt(serverChannelsActive);
        clientBatchReceived.increment();
            String status = in.readString();
        int clientChannelsActive,
        long sum = in.readVLong();  
 * Flight metrics collection system inspired by gRPC's OpenTelemetry metrics.  
            serverCallStarted.sum(),
        out.writeVLong(clientCallCompleted.sum());  
 */  
        builder.field("started", clientCallStarted.sum());
    }
 *
        }  
        long arrowPeakBytes,
            }
        }
        clientBatchRequested.add(in.readVLong());  
        // Resource metrics
 */
            "avg_nanos",  
        long arrowAllocatedBytes,
        builder.humanReadableField("min_nanos", "min", new TimeValue(snapshot.getMin(), java.util.concurrent.TimeUnit.NANOSECONDS));  
        public HistogramSnapshot getProcessingTime() {
        for (int i = 0; i < statusCount; i++) {  
    }  
            return completed;
        arrowAllocatedBytes = in.readVLong();
            this.sum = sum;
        writeHistogram(out, clientRequestBytes);
            serverCallCompletedByStatus.computeIfAbsent(status, k -> new LongAdder()).add(count);  
        private final HistogramSnapshot duration;
        readHistogram(in, serverBatchSentBytes);
        }
        }
            return started;  
        builder.startObject("resources");
        return new ClientBatchMetrics(
        public HistogramSnapshot getRequestBytes() {
