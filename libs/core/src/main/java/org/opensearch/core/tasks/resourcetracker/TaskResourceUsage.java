    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return false;  
    }
import org.opensearch.core.common.Strings;  
    public TaskResourceUsage(long cpuTimeInNanos, long memoryInBytes) {
public class TaskResourceUsage implements Writeable, ToXContentFragment {  
 * SPDX-License-Identifier: Apache-2.0
        PARSER.declareLong(constructorArg(), CPU_TIME_IN_NANOS);
import java.util.Objects;
        a -> new TaskResourceUsage((Long) a[0], (Long) a[1])  
        out.writeVLong(cpuTimeInNanos);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
 *  @opensearch.api  
    public void writeTo(StreamOutput out) throws IOException {
        this.cpuTimeInNanos = cpuTimeInNanos;
    @Override  
import org.opensearch.core.xcontent.XContentBuilder;
        "task_resource_usage",
    public String toString() {
    );
    }  
    private final long memoryInBytes;
        TaskResourceUsage other = (TaskResourceUsage) obj;
        return new TaskResourceUsage(in.readVLong(), in.readVLong());
        builder.field(CPU_TIME_IN_NANOS.getPreferredName(), cpuTimeInNanos);
    public int hashCode() {
import org.opensearch.core.ParseField;
    @Override  
        out.writeVLong(memoryInBytes);
 * Task resource usage information
    }  
 * this file be licensed under the Apache-2.0 license or a
    /**  
}
 */  
    public static TaskResourceUsage readFromStream(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.core.tasks.resourcetracker;
@PublicApi(since = "2.1.0")
    public static TaskResourceUsage fromXContent(XContentParser parser) {
    }  
 */
     * Read from a stream.
import java.io.IOException;
    }
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
/**  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * The OpenSearch Contributors require contributions made to  
    private final long cpuTimeInNanos;
/*  
     */
    @Override  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    public long getCpuTimeInNanos() {
        return Objects.equals(cpuTimeInNanos, other.cpuTimeInNanos) && Objects.equals(memoryInBytes, other.memoryInBytes);  
import org.opensearch.core.common.io.stream.Writeable;  
 *
    @Override  
    }
    // Implements equals and hashcode for testing
    @Override
    }
    public static final ConstructingObjectParser<TaskResourceUsage, Void> PARSER = new ConstructingObjectParser<>(
import org.opensearch.core.xcontent.ToXContentFragment;  
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
    }
    }
        builder.field(MEMORY_IN_BYTES.getPreferredName(), memoryInBytes);  
    public boolean equals(Object obj) {
        }
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
 * <p>
 * information of running tasks.
        return PARSER.apply(parser, null);  
        return cpuTimeInNanos;
    private static final ParseField MEMORY_IN_BYTES = new ParseField("memory_in_bytes");
    private static final ParseField CPU_TIME_IN_NANOS = new ParseField("cpu_time_in_nanos");
        return Objects.hash(cpuTimeInNanos, memoryInBytes);
        return builder;
        this.memoryInBytes = memoryInBytes;  
        if (obj == null || obj.getClass() != TaskResourceUsage.class) {
    public long getMemoryInBytes() {
 *
    static {  
        return memoryInBytes;  
 * Writeable TaskResourceUsage objects are used to represent resource usage  
        PARSER.declareLong(constructorArg(), MEMORY_IN_BYTES);
