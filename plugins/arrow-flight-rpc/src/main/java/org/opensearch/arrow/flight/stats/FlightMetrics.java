        builder.humanReadableField(
import java.util.concurrent.atomic.LongAdder;
        serverThreadsActive = in.readVInt();
        long current;
    private volatile int serverThreadsTotal;
                max = 0;
        private final HistogramSnapshot duration;
        this.serverThreadsActive = serverThreadsActive;
        private final HistogramSnapshot processingTime;
        writeHistogram(out, clientRequestBytes);
            updateMin(value);
        }
            long completed,
        }
import java.util.concurrent.atomic.AtomicLong;
 * The OpenSearch Contributors require contributions made to
    ServerCallMetrics getServerCallMetrics() {
            this.sum = sum;
import org.opensearch.common.unit.TimeValue;
            ConcurrentHashMap<String, LongAdder> completedByStatus,
        serverCallCompleted.increment();
        }
        int serverThreadsTotal,
        clientThreadsTotal = in.readVInt();
            serverCallStarted.sum(),
        long getCompleted() {
        builder.field("count", snapshot.getCount());
            new TimeValue((long) snapshot.getAverage(), java.util.concurrent.TimeUnit.NANOSECONDS)
        ConcurrentHashMap<String, LongAdder> statusMap = isClient ? clientCallCompletedByStatus : serverCallCompletedByStatus;
        long arrowAllocatedBytes,
        out.writeVLong(clientBatchRequested.sum());
        builder.field("completed", serverCallCompleted.sum());
        }
            return max;
            String status = in.readString();
        builder.endObject();
            serverCallDuration.snapshot(),
        this.arrowAllocatedBytes = arrowAllocatedBytes;
        // Client batch metrics
            clientBatchReceivedBytes.snapshot().getSum()
        writeHistogram(out, clientCallDuration);
        builder.endObject();
        writeHistogram(out, serverBatchSentBytes);
        }
        serverBatchSentBytes.record(bytes);
            long count = this.count.sum();
        out.writeVLong(clientCallCompleted.sum());
        private final HistogramSnapshot requestBytes;
    private final LongAdder serverCallStarted = new LongAdder();
        addBytesHistogramToXContent(builder, "request_bytes", serverRequestBytes.snapshot(), humanReadable);
        // Client call metrics
    private final Histogram serverBatchProcessingTime = new Histogram();
        arrowPeakBytes = in.readVLong();
        private final long batchesSent;
        private final LongAdder sum = new LongAdder();
    }
        serverCallStarted.increment();
    private final LongAdder serverBatchSent = new LongAdder();
            long responseBytes
        long sum = in.readVLong();
        private final ConcurrentHashMap<String, LongAdder> completedByStatus;
            HistogramSnapshot duration,
            long started,
            builder.field("client_thread_utilization_percent", (clientThreadsActive * 100.0) / clientThreadsTotal);
    private final ConcurrentHashMap<String, LongAdder> serverCallCompletedByStatus = new ConcurrentHashMap<>();
            builder.field(status, clientCallCompletedByStatus.get(status).sum());
    static class ServerCallMetrics {
/*
    }
        long getBatchesSent() {
        private final HistogramSnapshot receivedBytes;
    static class ClientCallMetrics {
        builder.humanReadableField("min_bytes", "min", new ByteSizeValue(snapshot.getMin()));
    }
            HistogramSnapshot requestBytes,
        builder.startObject("resources");
        clientCallStarted.increment();
        }
        this.clientThreadsActive = clientThreadsActive;
            long sum = this.sum.sum();
            minValue.compareAndSet(current, newValue);
        clientChannelsActive = in.readVInt();
        }
    private volatile long arrowAllocatedBytes;
            long current;
    }
        HistogramSnapshot getProcessingTime() {
            this.processingTime = processingTime;
    private volatile long directMemoryBytes;
        int serverChannelsActive
        long current;
            return completed;
            out.writeString(status);
        HistogramSnapshot getDuration() {
    }
        }
    }
    }
            clientCallStarted.sum(),
        return new ServerBatchMetrics(serverBatchSent.sum(), serverBatchSentBytes.snapshot(), serverBatchProcessingTime.snapshot());
        writeHistogram(out, serverBatchProcessingTime);
        this.clientThreadsTotal = clientThreadsTotal;
    private final Histogram clientBatchReceivedBytes = new Histogram();
            out.writeVLong(serverCallCompletedByStatus.get(status).sum());
        for (int i = 0; i < statusCount; i++) {
        builder.startObject("server_calls");
        readHistogram(in, serverCallDuration);
        builder.humanReadableField("direct_memory_bytes", "direct_memory", new ByteSizeValue(directMemoryBytes));
    }
        clientBatchProcessingTime.record(processingTimeNanos);
    private volatile long arrowPeakBytes;
        serverBatchSent.increment();
    }
        clientCallCompleted.increment();
    }
        // Client batch metrics
    }
    // Client per-batch metrics - client only receives batches
import org.opensearch.core.xcontent.XContentBuilder;
    void recordServerRequestBytes(long bytes) {
            }
    private volatile int serverChannelsActive;
        out.writeVLong(snapshot.getSum());
            this.max = max;
        serverCallStarted.add(in.readVLong());
            clientCallCompleted.sum(),
        addDurationHistogramToXContent(builder, "duration", clientCallDuration.snapshot(), humanReadable);
        builder.field("sent", serverBatchSent.sum());
        for (String status : serverCallCompletedByStatus.keySet()) {
        builder.endObject();
 * SPDX-License-Identifier: Apache-2.0
            return requestBytes;
            return completed;
class FlightMetrics implements Writeable, ToXContentFragment {
        }
        builder.humanReadableField("sum_nanos", "sum", new TimeValue(snapshot.getSum(), java.util.concurrent.TimeUnit.NANOSECONDS));
        }
        private final long batchesRequested;
        }
        }
            serverCallCompletedByStatus,
            serverBatchSentBytes.snapshot().getSum()
        out.writeVLong(snapshot.getMin());
        public ClientBatchMetrics(
            clientCallCompletedByStatus,
        }
    // Resource metrics - these are point-in-time snapshots
            HistogramSnapshot requestBytes,
        }
            this.duration = duration;
        }
            count.increment();
 * compatible open source license.
        addBytesHistogramToXContent(builder, "sent_bytes", serverBatchSentBytes.snapshot(), humanReadable);
        builder.field("server_channels_active", serverChannelsActive);
            }
        serverThreadsTotal = in.readVInt();
        int statusCount = in.readVInt();
        public long getMin() {
        private final HistogramSnapshot sentBytes;
    ClientCallMetrics getClientCallMetrics() {
        serverCallCompletedByStatus.computeIfAbsent(status, k -> new LongAdder()).increment();
            serverRequestBytes.snapshot(),
        arrowAllocatedBytes = in.readVLong();
            this.requestBytes = requestBytes;
        builder.startObject(name);
            serverCallCompletedByStatus.computeIfAbsent(status, k -> new LongAdder()).add(count);
        private final HistogramSnapshot duration;
        }
        long arrowPeakBytes,
        public long getSum() {
    long getStatusCount(boolean isClient, String status) {
        int clientThreadsActive,
    private final LongAdder clientCallCompleted = new LongAdder();
        serverBatchSent.add(in.readVLong());
        return new ServerCallMetrics(
            }
        }
        );
        }
            this.batchesRequested = batchesRequested;
    }
 */
        boolean humanReadable = params.paramAsBoolean("human", false);
    }
            long current;
    }
        builder.field("started", clientCallStarted.sum());
        builder.startObject("client");
    ClientBatchMetrics getClientBatchMetrics() {
                min = 0;
        out.writeVInt(clientThreadsTotal);
    void recordServerCallCompleted(String status, long durationNanos) {
    static class ServerBatchMetrics {
        readHistogram(in, clientBatchProcessingTime);
            maxValue.compareAndSet(current, newValue);
            this.min = min;
        builder.endObject();
            sum.add(value);
        ) {
        public HistogramSnapshot getProcessingTime() {
        }
    private void writeHistogram(StreamOutput out, Histogram histogram) throws IOException {
            this.sentBytes = sentBytes;
            clientRequestBytes.snapshot(),
        builder.field("client_threads_active", clientThreadsActive);
    private final LongAdder clientBatchReceived = new LongAdder();
    private volatile int clientThreadsTotal;
            return receivedBytes;
            return batchesRequested;
        }
    static class HistogramSnapshot {
        out.writeVLong(arrowAllocatedBytes);
        builder.endObject();
        serverRequestBytes.record(bytes);
        serverChannelsActive = in.readVInt();
        return new ClientCallMetrics(
    void recordServerCallStarted() {
        builder.startObject("status");
        for (String status : clientCallCompletedByStatus.keySet()) {
            builder.field("server_thread_utilization_percent", (serverThreadsActive * 100.0) / serverThreadsTotal);
        private void updateMax(long value) {
    @Override
            clientBatchReceivedBytes.snapshot(),
        private final long completed;
                max.compareAndSet(current, value);
        private final long min;
        public void record(long value) {
    }
        out.writeVLong(arrowPeakBytes);
    }
        ) {
        }
            clientBatchReceived.sum(),
        directMemoryBytes = in.readVLong();
            long count = in.readVLong();
            return min;
        // Server batch metrics
        builder.startObject("flight_metrics");
    }
        builder.startObject("server_batches");
        this.serverChannelsActive = serverChannelsActive;
        public long getStarted() {
            this.completed = completed;
            long min = this.min.get();
    }
    ) {
        // Server call metrics
            this.started = started;
import org.opensearch.core.xcontent.ToXContentFragment;
        readHistogram(in, clientCallDuration);
        out.writeVLong(clientBatchReceived.sum());
            out.writeVLong(clientCallCompletedByStatus.get(status).sum());
        private final long started;
    private final ConcurrentHashMap<String, LongAdder> clientCallCompletedByStatus = new ConcurrentHashMap<>();
            return requestBytes;
        this.arrowPeakBytes = arrowPeakBytes;
        builder.endObject();
        builder.humanReadableField("response_bytes", "response", new ByteSizeValue(totalClientReceivedBytes));
        builder.humanReadableField("response_bytes", "response", new ByteSizeValue(totalServerSentBytes));
        addDurationHistogramToXContent(builder, "processing_time", clientBatchProcessingTime.snapshot(), humanReadable);
        out.writeVLong(snapshot.getMax());
        }
        long totalClientReceivedBytes = clientBatchReceivedBytes.snapshot().getSum();
    void recordServerBatchSent(long bytes, long processingTimeNanos) {
    private final LongAdder clientBatchRequested = new LongAdder();
        histogram.count.add(count);
        }
            this.completedByStatus = completedByStatus;
    FlightMetrics(StreamInput in) throws IOException {
        out.writeVLong(serverCallStarted.sum());
        }
        }
    private final LongAdder serverCallCompleted = new LongAdder();
            clientBatchProcessingTime.snapshot()
        out.writeVLong(serverCallCompleted.sum());
        builder.humanReadableField("max_nanos", "max", new TimeValue(snapshot.getMax(), java.util.concurrent.TimeUnit.NANOSECONDS));
        while (newValue < (current = minValue.get())) {
        long totalServerSentBytes = serverBatchSentBytes.snapshot().getSum();
    private void updateMin(AtomicLong minValue, long newValue) {
        updateMax(histogram.max, max);
    private volatile int clientThreadsActive;
            return batchesReceived;
            return processingTime;
        builder.endObject();
 * Provides both per-call and aggregated metrics.
        for (String status : serverCallCompletedByStatus.keySet()) {
            this.started = started;
        );
            long batchesRequested,
        this.directMemoryBytes = directMemoryBytes;
    }
        return adder != null ? adder.sum() : 0;
            this.responseBytes = responseBytes;
        // Resource metrics
    }
        clientCallCompleted.add(in.readVLong());
        out.writeVInt(serverCallCompletedByStatus.size());
        builder.humanReadableField("max_bytes", "max", new ByteSizeValue(snapshot.getMax()));
            HistogramSnapshot processingTime
    private final Histogram clientCallDuration = new Histogram();
        builder.field("client_channels_active", clientChannelsActive);
            clientCallCompletedByStatus.computeIfAbsent(status, k -> new LongAdder()).add(count);
        long directMemoryBytes,
            return sentBytes;
    private final Histogram serverRequestBytes = new Histogram();
        writeHistogram(out, serverCallDuration);
        clientBatchRequested.increment();
        private final AtomicLong max = new AtomicLong(Long.MIN_VALUE);
        public HistogramSnapshot getDuration() {
        public HistogramSnapshot snapshot() {
            return count > 0 ? (double) sum / count : 0;
            clientBatchRequested.sum(),
    private void updateMax(AtomicLong maxValue, long newValue) {
    }
            this.batchesSent = batchesSent;
        // Resource metrics
        readHistogram(in, clientBatchReceivedBytes);
        }
            "avg",
    private void readHistogram(StreamInput in, Histogram histogram) throws IOException {
    private final Histogram clientRequestBytes = new Histogram();
            this.batchesReceived = batchesReceived;
        out.writeVLong(snapshot.getCount());
/**
            return duration;
            HistogramSnapshot receivedBytes,
        private final long responseBytes;
        builder.startObject("server");
        }
        }
    }
        addBytesHistogramToXContent(builder, "received_bytes", clientBatchReceivedBytes.snapshot(), humanReadable);
        private final HistogramSnapshot processingTime;
    private volatile int serverThreadsActive;
        statusCount = in.readVInt();
        private final long started;
    void recordClientBatchReceived(long bytes, long processingTimeNanos) {
import org.opensearch.core.common.io.stream.StreamInput;
    // Server metrics
        builder.humanReadableField("avg_bytes", "avg", new ByteSizeValue((long) snapshot.getAverage()));
    }
        for (String status : clientCallCompletedByStatus.keySet()) {
    void recordClientCallStarted() {
    FlightMetrics() {}
            while (value < (current = min.get())) {
            long count = in.readVLong();
        }
        clientCallStarted.add(in.readVLong());
    private final Histogram clientBatchProcessingTime = new Histogram();
        updateMin(histogram.min, min);
        }
            clientCallDuration.snapshot(),
        builder.endObject();
    void recordClientBatchRequested() {
            return started;
        }
        }
        writeHistogram(out, clientBatchProcessingTime);
            return processingTime;
            long completed,
        long min = in.readVLong();
        addDurationHistogramToXContent(builder, "duration", serverCallDuration.snapshot(), humanReadable);
        public long getMax() {
        out.writeVInt(serverThreadsActive);
        // Server batch metrics
        ServerBatchMetrics(long batchesSent, HistogramSnapshot sentBytes, HistogramSnapshot processingTime) {
        out.writeVLong(directMemoryBytes);
    private volatile int clientChannelsActive;
        LongAdder adder = statusMap.get(status);
            return started;
        // Server call metrics
    ServerBatchMetrics getServerBatchMetrics() {
        }
        HistogramSnapshot getSentBytes() {
        long max = in.readVLong();
    static class ClientBatchMetrics {
        private final LongAdder count = new LongAdder();
            updateMax(value);
    void updateResourceMetrics(
            "avg_nanos",
        public long getBatchesRequested() {
        out.writeVInt(clientCallCompletedByStatus.size());
        public double getAverage() {
        private final long max;
            return count;
        long count = in.readVLong();
        writeHistogram(out, serverRequestBytes);
        }
        }
            this.processingTime = processingTime;
        }
            return sum;
        builder.field("server_threads_active", serverThreadsActive);
        HistogramSnapshot getRequestBytes() {
            out.writeString(status);
        private final AtomicLong min = new AtomicLong(Long.MAX_VALUE);
        builder.humanReadableField("min_nanos", "min", new TimeValue(snapshot.getMin(), java.util.concurrent.TimeUnit.NANOSECONDS));
        }
            long batchesReceived,
    public void writeTo(StreamOutput out) throws IOException {
        builder.field("received", clientBatchReceived.sum());
        clientBatchReceived.increment();
        if (serverThreadsTotal > 0) {
        }
        builder.field("completed", clientCallCompleted.sum());
import java.io.IOException;
        clientRequestBytes.record(bytes);
    static class Histogram {
        clientCallCompletedByStatus.computeIfAbsent(status, k -> new LongAdder()).increment();
        throws IOException {
        );
            long max = this.max.get();
        serverCallDuration.record(durationNanos);
            this.receivedBytes = receivedBytes;
            this.completedByStatus = completedByStatus;
        this.serverThreadsTotal = serverThreadsTotal;
 */
}
    }
import java.util.concurrent.ConcurrentHashMap;
        this.clientChannelsActive = clientChannelsActive;
        readHistogram(in, serverRequestBytes);
import org.opensearch.core.common.unit.ByteSizeValue;
        return builder;
        builder.humanReadableField("arrow_allocated_bytes", "arrow_allocated", new ByteSizeValue(arrowAllocatedBytes));
        readHistogram(in, serverBatchProcessingTime);
    private final LongAdder clientCallStarted = new LongAdder();
        clientBatchRequested.add(in.readVLong());
        HistogramSnapshot snapshot = histogram.snapshot();
    @Override
            builder.field(status, serverCallCompletedByStatus.get(status).sum());
        readHistogram(in, serverBatchSentBytes);
        public HistogramSnapshot getRequestBytes() {
    private void addBytesHistogramToXContent(XContentBuilder builder, String name, HistogramSnapshot snapshot, boolean humanReadable)
        public long getCompleted() {
        out.writeVInt(clientThreadsActive);
    void recordClientRequestBytes(long bytes) {
        histogram.sum.add(sum);
        builder.endObject();
    }
        builder.field("server_threads_total", serverThreadsTotal);
        clientCallDuration.record(durationNanos);
            this.requestBytes = requestBytes;
 *
            if (count == 0) {
        long getStarted() {
        private final long sum;
        while (newValue > (current = maxValue.get())) {
        for (int i = 0; i < statusCount; i++) {
        builder.startObject("client_batches");
        serverBatchProcessingTime.record(processingTimeNanos);
    }
        builder.humanReadableField("arrow_peak_bytes", "arrow_peak", new ByteSizeValue(arrowPeakBytes));
        builder.field("requested", clientBatchRequested.sum());
package org.opensearch.arrow.flight.stats;
        private final long count;
        return new ClientBatchMetrics(
            return batchesSent;
            String status = in.readString();
        writeHistogram(out, clientBatchReceivedBytes);
        int clientChannelsActive,
        // Client call metrics
            this.completed = completed;
 * Flight metrics collection system inspired by gRPC's OpenTelemetry metrics.
        int serverThreadsActive,
        builder.field("client_threads_total", clientThreadsTotal);
        if (clientThreadsTotal > 0) {
    }
    // Server per-batch metrics - server only sends batches
        readHistogram(in, clientRequestBytes);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final long batchesReceived;
        out.writeVLong(clientCallStarted.sum());
        private final HistogramSnapshot requestBytes;
        builder.field("started", serverCallStarted.sum());
        int clientThreadsTotal,
        public long getCount() {
        ServerCallMetrics(
            return new HistogramSnapshot(count, sum, min, max);
            ConcurrentHashMap<String, LongAdder> completedByStatus,
        clientThreadsActive = in.readVInt();
        addDurationHistogramToXContent(builder, "processing_time", serverBatchProcessingTime.snapshot(), humanReadable);
        );
        addBytesHistogramToXContent(builder, "request_bytes", clientRequestBytes.snapshot(), humanReadable);
    }
        clientBatchReceived.add(in.readVLong());
    private final Histogram serverBatchSentBytes = new Histogram();
        builder.startObject(name);
    private final Histogram serverCallDuration = new Histogram();
            HistogramSnapshot duration,
        out.writeVInt(clientChannelsActive);
        builder.startObject("client_calls");
                min.compareAndSet(current, value);
import org.opensearch.core.common.io.stream.StreamOutput;
        ) {
        private final long completed;
            this.count = count;
            while (value > (current = max.get())) {
    private void addDurationHistogramToXContent(XContentBuilder builder, String name, HistogramSnapshot snapshot, boolean humanReadable)
        builder.endObject();
            serverCallCompleted.sum(),
        private void updateMin(long value) {
        public HistogramSnapshot getReceivedBytes() {
import org.opensearch.core.common.io.stream.Writeable;
        private final ConcurrentHashMap<String, LongAdder> completedByStatus;
    void recordClientCallCompleted(String status, long durationNanos) {
            this.duration = duration;
    // Client per-call metrics
        serverCallCompleted.add(in.readVLong());
        public HistogramSnapshot(long count, long sum, long min, long max) {
    }
        out.writeVInt(serverChannelsActive);
        out.writeVInt(serverThreadsTotal);
            long started,
            long responseBytes
        builder.endObject();
        builder.field("count", snapshot.getCount());
        out.writeVLong(serverBatchSent.sum());
    }
        builder.humanReadableField("sum_bytes", "sum", new ByteSizeValue(snapshot.getSum()));
        }
        public long getBatchesReceived() {
 * this file be licensed under the Apache-2.0 license or a
        public ClientCallMetrics(
        clientBatchReceivedBytes.record(bytes);
            return duration;
        throws IOException {
