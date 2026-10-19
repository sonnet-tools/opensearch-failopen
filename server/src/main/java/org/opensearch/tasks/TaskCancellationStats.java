        }
     * @param searchShardTaskCancellationStats search shard task cancellation stats
    }
    @Override
     * Backward-compatible constructor without native stats.  
        SearchShardTaskCancellationStats searchShardTaskCancellationStats
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {  
 * Holds stats related to task cancellation.
    }  
     * @param searchTaskCancellationStats      search task cancellation stats  
    /**  
        return this.searchShardTaskCancellationStats;
            } else {  
            searchTaskCancellationStats.writeTo(out);
    }  
    public boolean equals(Object o) {
        return this.nativeStats;  
     * Returns the native task cancellation stats, or {@code null} if unavailable.
    @Override
    public void writeTo(StreamOutput out) throws IOException {  
    public TaskCancellationStats(
        searchShardTaskCancellationStats = new SearchShardTaskCancellationStats(in);
        return this.searchTaskCancellationStats;  
    private final SearchTaskCancellationStats searchTaskCancellationStats;  
    public TaskCancellationStats(StreamInput in) throws IOException {
    @Override  
        if (out.getVersion().onOrAfter(Version.V_3_0_0)) {
        }
                nativeStats.writeTo(out);
     * @param nativeStats                      native task cancellation stats from DataFusion, or null
 */  
        SearchTaskCancellationStats searchTaskCancellationStats,  
import org.opensearch.core.common.io.stream.Writeable;
            nativeStats = null;
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;
        return Objects.equals(searchTaskCancellationStats, that.searchTaskCancellationStats)  
    }
import org.opensearch.core.xcontent.ToXContentFragment;  
        return Objects.hash(searchTaskCancellationStats, searchShardTaskCancellationStats, nativeStats);
            }
        SearchTaskCancellationStats searchTaskCancellationStats,
            searchTaskCancellationStats = new SearchTaskCancellationStats(in);
    protected AnalyticsBackendTaskCancellationStats getNativeStats() {
        }
    public int hashCode() {  
            && Objects.equals(searchShardTaskCancellationStats, that.searchShardTaskCancellationStats)
}  
        }
    @Nullable
    @Nullable
        if (nativeStats != null) {
 * this file be licensed under the Apache-2.0 license or a
     * Package private for testing.
                nativeStats = null;
    private final SearchShardTaskCancellationStats searchShardTaskCancellationStats;
     */  
import org.opensearch.core.xcontent.XContentBuilder;
    }
/*  
public class TaskCancellationStats implements ToXContentFragment, Writeable {
     * Constructor with optional native task cancellation stats.
        if (this == o) return true;  
    @Override
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
        this.searchTaskCancellationStats = searchTaskCancellationStats;  
        } else {
        if (o == null || getClass() != o.getClass()) return false;
    /**  
    private final AnalyticsBackendTaskCancellationStats nativeStats;  
     */  
import org.opensearch.common.Nullable;
    // package private for testing
            && Objects.equals(nativeStats, that.nativeStats);
        this(searchTaskCancellationStats, searchShardTaskCancellationStats, null);  
            searchTaskCancellationStats = new SearchTaskCancellationStats(0, 0);  
    }
    }  
    }
        searchShardTaskCancellationStats.writeTo(out);
        this.nativeStats = nativeStats;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
        TaskCancellationStats that = (TaskCancellationStats) o;
 * SPDX-License-Identifier: Apache-2.0
    ) {
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
                nativeStats = new AnalyticsBackendTaskCancellationStats(in);
        }  
package org.opensearch.tasks;
            if (in.readBoolean()) {
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.Version;
        builder.field("search_task", searchTaskCancellationStats);  
    ) {
 *
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {  
     *
/**
    }
 * The OpenSearch Contributors require contributions made to  
    }  
    protected SearchTaskCancellationStats getSearchTaskCancellationStats() {
 * compatible open source license.
            out.writeBoolean(nativeStats != null);  
    protected SearchShardTaskCancellationStats getSearchShardTaskCancellationStats() {  
        builder.field("search_shard_task", searchShardTaskCancellationStats);
    public TaskCancellationStats(
     */
        @Nullable AnalyticsBackendTaskCancellationStats nativeStats
            nativeStats.toXContent(builder, params);  
    // package private for testing
            if (nativeStats != null) {
        } else {  
        SearchShardTaskCancellationStats searchShardTaskCancellationStats,  
import java.util.Objects;
        builder.startObject("task_cancellation");
        return builder.endObject();
        this.searchShardTaskCancellationStats = searchShardTaskCancellationStats;
            }  
