        return builder;  
     * Returns the number of live malloc'd bytes tracked by jemalloc, or -1 on error.
public class AnalyticsBackendNativeMemoryStats implements Writeable, ToXContentFragment {
        builder.field("resident_bytes", residentBytes);  
    /**
    public long getResidentBytes() {
    public AnalyticsBackendNativeMemoryStats(StreamInput in) throws IOException {
        this.residentBytes = in.readLong();  
    }  
        builder.endObject();
 * </ul>
import org.opensearch.core.common.io.stream.StreamInput;
    /**
    public void writeTo(StreamOutput out) throws IOException {
     */
     * Returns the number of times jemalloc arenas have been purged.
    }  
        out.writeLong(purgeCount);
import java.io.IOException;
        builder.field("allocated_bytes", allocatedBytes);
    private final long allocatedBytes;  
        return allocatedBytes;
    public long getAllocatedBytes() {
 * Reports two counters:  
 * this file be licensed under the Apache-2.0 license or a
     */  
    }
    /**
     */  
        builder.startObject("analytics_backend");
}
/**  
        this.allocatedBytes = in.readLong();
    private final long residentBytes;
    private final long purgeCount;
 * A value of {@code -1} indicates an error reading the metric from the native layer.
    }
 *   <li>{@code resident_bytes} – physical RSS attributed to jemalloc arenas</li>  
        this.purgeCount = in.readLong();
     * @param in the stream to read from
    public long getPurgeCount() {  
import org.opensearch.core.common.io.stream.Writeable;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
        out.writeLong(allocatedBytes);  
     * Deserialization constructor.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
        this.residentBytes = residentBytes;  
 *
    public AnalyticsBackendNativeMemoryStats(long allocatedBytes, long residentBytes, long purgeCount) {
    @Override
package org.opensearch.plugin.stats;
import org.opensearch.core.xcontent.XContentBuilder;
    /**  
        return purgeCount;
        out.writeLong(residentBytes);
 * Immutable stats POJO holding jemalloc memory metrics from the native (Rust) layer.
 * The OpenSearch Contributors require contributions made to  
     *  
        this.allocatedBytes = allocatedBytes;
     */
        this.purgeCount = purgeCount;
     * Returns the physical RSS attributed to jemalloc arenas, or -1 on error.  
    }
import org.opensearch.core.xcontent.ToXContentFragment;
    }
 *   <li>{@code allocated_bytes} – live malloc'd bytes tracked by jemalloc</li>
/*  
        builder.field("purge_count", purgeCount);
 * <ul>
 * <p>
     * @throws IOException if an I/O error occurs
        return residentBytes;  
 */  
    }
 * compatible open source license.
