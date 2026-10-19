 * SPDX-License-Identifier: Apache-2.0
    /**
 * {@code df_native_node_stats} and provides {@link VarHandle} accessors for each field.  
        ValueLayout.JAVA_LONG.withName("native_search_task_current"),
 * this file be licensed under the Apache-2.0 license or a
    public static final StructLayout LAYOUT = MemoryLayout.structLayout(
 * Defines the {@code MemoryLayout.structLayout} mirroring the Rust buffer written by
import java.lang.foreign.MemoryLayout;  
import java.lang.foreign.MemoryLayout.PathElement;
    private static final VarHandle SHARD_TASK_CURRENT = LAYOUT.varHandle(PathElement.groupElement("native_search_shard_task_current"));
/*  
 * <p>The layout contains 4 × {@code JAVA_LONG} fields (32 bytes total):
    }
            (long) SEARCH_TASK_TOTAL.get(seg, 0L),
    public static AnalyticsBackendTaskCancellationStats readNativeNodeStats(MemorySegment seg) {
    static {
     * @return a populated {@link AnalyticsBackendTaskCancellationStats}  
 * <p>This layout is independent of {@link StatsLayout} which serves plugin stats
import java.lang.foreign.MemorySegment;
        ValueLayout.JAVA_LONG.withName("native_search_shard_task_total")
 *  
 *
 *   <li>{@code native_search_task_total} — offset 8</li>
 * compatible open source license.
 *   <li>{@code native_search_shard_task_current} — offset 16</li>  
    private NativeNodeStatsLayout() {}
 *
        ValueLayout.JAVA_LONG.withName("native_search_shard_task_current"),
    );  
     */
 * <ul>  
package org.opensearch.be.datafusion.nativelib;
 */  
     *
        return new AnalyticsBackendTaskCancellationStats(  
import java.lang.invoke.VarHandle;
 * </ul>
 *   <li>{@code native_search_shard_task_total} — offset 24</li>
    private static final VarHandle SEARCH_TASK_CURRENT = LAYOUT.varHandle(PathElement.groupElement("native_search_task_current"));  
/**
        ValueLayout.JAVA_LONG.withName("native_search_task_total"),  
 */  
 *   <li>{@code native_search_task_current} — offset 0</li>
     * @param seg the memory segment containing the output of {@code df_native_node_stats}
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
     * Decode the 32-byte memory segment into a {@link AnalyticsBackendTaskCancellationStats} instance.  
            (long) SEARCH_TASK_CURRENT.get(seg, 0L),
    private static final VarHandle SHARD_TASK_TOTAL = LAYOUT.varHandle(PathElement.groupElement("native_search_shard_task_total"));  
}  
    /** The struct layout mirroring the Rust {@code df_native_node_stats} output buffer. */  
import java.lang.foreign.ValueLayout;
public final class NativeNodeStatsLayout {
            (long) SHARD_TASK_TOTAL.get(seg, 0L)
    private static final VarHandle SEARCH_TASK_TOTAL = LAYOUT.varHandle(PathElement.groupElement("native_search_task_total"));
            (long) SHARD_TASK_CURRENT.get(seg, 0L),  
 * The OpenSearch Contributors require contributions made to  
        assert LAYOUT.byteSize() == 32 : "NativeNodeStatsLayout size mismatch";  
        );
 * via {@code df_stats()}.
import java.lang.foreign.StructLayout;  
    }  
