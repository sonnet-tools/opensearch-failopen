import org.opensearch.core.common.io.stream.Writeable;  
     * @throws IOException if deserialization fails
    private final Map<String, TaskMonitorStats> taskMonitors;
 */  
     */  
        return taskMonitors;
    /** Returns the per-operation task monitor metrics. */
            cpuRuntime.writeTo(out);  
    }
    @Override  
        PLAN_SETUP("plan_setup");
        } else {
    /** Returns the CPU runtime metrics, or {@code null} if absent. */  
     *  
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
 * {@link RuntimeMetrics}, and 3 {@link TaskMonitorStats} for the operation types:
import java.io.IOException;
     * @param cpuRuntime   the CPU runtime metrics (nullable)
        this.ioRuntime = ioRuntime;
    public boolean equals(Object o) {
    /** Operation types in documented order. */
        for (Map.Entry<String, TaskMonitorStats> entry : taskMonitors.entrySet()) {
        return builder;
        return Objects.hash(ioRuntime, cpuRuntime, taskMonitors);
    }
            builder.startObject(entry.getKey());  
 * (Tokio runtime metrics + per-operation task monitors).
        int monitorCount = in.readVInt();
    public RuntimeMetrics getCpuRuntime() {
        this.cpuRuntime = cpuRuntime;  
            && Objects.equals(taskMonitors, that.taskMonitors);
        /** Query execution operation. */
        /** Coordinator-side local plan execution (reduce phase). */  
        private final String key;  
import java.util.Map;  
package org.opensearch.be.datafusion.stats;
        if (cpuRuntime != null) {
        out.writeOptionalWriteable(ioRuntime);  
            entry.getValue().writeTo(out);
    }  
    private final RuntimeMetrics ioRuntime;  
/**  
    public int hashCode() {  
        }  
            this.key = key;  
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
        }
import java.util.Objects;
        return ioRuntime;  
     * @param taskMonitors per-operation task monitor metrics  
     * Deserialize from stream.
     * Construct from individual components.
    // ioRuntime is nullable when constructing filtered stats (omitted from XContent when null)  
        if (o == null || getClass() != o.getClass()) return false;
    @Override
        this.ioRuntime = in.readOptionalWriteable(RuntimeMetrics::new);
            return key;
        if (ioRuntime != null) {
}
            builder.endObject();
public class NativeExecutorsStats implements Writeable, ToXContentFragment {
    public Map<String, TaskMonitorStats> getTaskMonitors() {  
            builder.endObject();
        }  
    public NativeExecutorsStats(StreamInput in) throws IOException {
        COORDINATOR_REDUCE("coordinator_reduce"),
 * {@link Writeable} + {@link ToXContentFragment} container for native executor metrics
            cpuRuntime.toXContent(builder);
 */
        return Objects.equals(ioRuntime, that.ioRuntime)  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/*  
            ioRuntime.toXContent(builder);
 * this file be licensed under the Apache-2.0 license or a
    }
        /** Plan setup: session context creation + plan preparation. */  
            out.writeString(entry.getKey());
 * query_execution, stream_next, fetch_phase.  
     *  
    private final RuntimeMetrics cpuRuntime; // nullable
    public void writeTo(StreamOutput out) throws IOException {
    }
    }  
        public String key() {
import org.opensearch.core.common.io.stream.StreamInput;
        STREAM_NEXT("stream_next"),
     * @param in the stream input
            builder.startObject("io_runtime");  
    }
        }
            out.writeBoolean(true);
        NativeExecutorsStats that = (NativeExecutorsStats) o;
        this.cpuRuntime = in.readBoolean() ? new RuntimeMetrics(in) : null;  
     */
import java.util.LinkedHashMap;
 * compatible open source license.
        OperationType(String key) {
 *  
    /** Returns the IO runtime metrics. */
    }
 * SPDX-License-Identifier: Apache-2.0
            entry.getValue().toXContent(builder);
        // Write the number of task monitors followed by each entry
        this.taskMonitors = Objects.requireNonNull(taskMonitors);
    /**
        }  
        if (this == o) return true;  
            out.writeBoolean(false);
            builder.endObject();
 * <p>Contains an IO {@link RuntimeMetrics} (always present), an optional CPU
 * The OpenSearch Contributors require contributions made to  
            String key = in.readString();
            && Objects.equals(cpuRuntime, that.cpuRuntime)
 *
            this.taskMonitors.put(key, new TaskMonitorStats(in));  
    /**
    // cpuRuntime is nullable — zeroed when absent (workers_count == 0), omitted from XContent when null
        }  
import org.opensearch.core.xcontent.ToXContentFragment;
    }
        out.writeVInt(taskMonitors.size());
        return cpuRuntime;
        for (int i = 0; i < monitorCount; i++) {
    public RuntimeMetrics getIoRuntime() {
        QUERY_EXECUTION("query_execution"),  
    public enum OperationType {
        /** Returns the snake_case key used in serialization and XContent output. */  
    public NativeExecutorsStats(RuntimeMetrics ioRuntime, RuntimeMetrics cpuRuntime, Map<String, TaskMonitorStats> taskMonitors) {
        }  
    }
        for (Map.Entry<String, TaskMonitorStats> entry : taskMonitors.entrySet()) {  
        this.taskMonitors = new LinkedHashMap<>(monitorCount);  
     * @param ioRuntime    the IO runtime metrics (nullable for filtered stats)
        /** Stream next (pagination) operation. */
    @Override
        if (cpuRuntime != null) {
            builder.startObject("cpu_runtime");  
