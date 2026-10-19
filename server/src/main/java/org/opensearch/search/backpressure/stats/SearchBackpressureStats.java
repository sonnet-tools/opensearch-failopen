    public SearchBackpressureStats(
/**
            && Objects.equals(searchTaskStats, that.searchTaskStats)
        out.writeString(mode.getName());
 *
    ) {
        builder.field("mode", mode.getName());
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    }
        searchShardTaskStats = new SearchShardTaskStats(in);  
    public void writeTo(StreamOutput out) throws IOException {  
        if (o == null || getClass() != o.getClass()) return false;
    }  
        SearchTaskStats searchTaskStats,
 */  
        if (in.getVersion().onOrAfter(Version.V_2_6_0)) {
/*  
        if (searchTaskStats != null) {  
            && Objects.equals(searchShardTaskStats, that.searchShardTaskStats);  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        return builder.endObject();
        return mode == that.mode
package org.opensearch.search.backpressure.stats;
        if (out.getVersion().onOrAfter(Version.V_2_6_0)) {  
}
    @Override
        this.searchShardTaskStats = searchShardTaskStats;  
    public SearchBackpressureStats(StreamInput in) throws IOException {
        }
    private final SearchBackpressureMode mode;  
import java.util.Objects;
        this.searchTaskStats = searchTaskStats;
    }  
        mode = SearchBackpressureMode.fromName(in.readString());
        }
import org.opensearch.common.Nullable;
        } else {
    @Override  
    public boolean equals(Object o) {  
import org.opensearch.core.common.io.stream.StreamInput;  
        SearchBackpressureStats that = (SearchBackpressureStats) o;  
import org.opensearch.core.common.io.stream.Writeable;
    @Override
    private final SearchShardTaskStats searchShardTaskStats;
            searchTaskStats = null;
    public int hashCode() {
import org.opensearch.Version;
        }  
import org.opensearch.search.backpressure.settings.SearchBackpressureMode;
    private final SearchTaskStats searchTaskStats;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        SearchBackpressureMode mode
            searchTaskStats = in.readOptionalWriteable(SearchTaskStats::new);  
        this.mode = mode;
 * this file be licensed under the Apache-2.0 license or a
public class SearchBackpressureStats implements ToXContentFragment, Writeable {
        if (this == o) return true;
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
    }  
        return Objects.hash(searchTaskStats, searchShardTaskStats, mode);
    @Nullable
 */  
        SearchShardTaskStats searchShardTaskStats,  
        searchShardTaskStats.writeTo(out);
    @Override  
 * The OpenSearch Contributors require contributions made to  
            out.writeOptionalWriteable(searchTaskStats);
 * Stats related to search backpressure.
        builder.field("search_shard_task", searchShardTaskStats);  
import org.opensearch.core.xcontent.ToXContentFragment;  
    }  
        builder.startObject("search_backpressure");
            builder.field("search_task", searchTaskStats);
