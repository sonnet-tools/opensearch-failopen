        if (docStatusStats != null) {
    public StatusCounterStats(DocStatusStats docStatusStats, SearchResponseStatusStats searchResponseStatusStats) {
     */
    }  
        }
import org.opensearch.Version;
        searchResponseStatusStats = new SearchResponseStatusStats();
 */  
    public void add(StatusCounterStats stats) {
        this.searchResponseStatusStats = searchResponseStatusStats;  
        static final String STATUS_COUNTER = "status_counter";
        }
    }
        }
    /**
 */
        } else {
 *
    }
    public StatusCounterStats(StreamInput in) throws IOException {  
import org.opensearch.core.xcontent.ToXContentFragment;
        if (searchResponseStatusStats != null) {
    /**  
    static final class Fields {  
@PublicApi(since = "3.4.0")
     *  
    }
    }
        stats.getSearchResponseStatusStats().add(searchResponseStatusStats);  
import org.opensearch.core.common.io.stream.Writeable;  
}  
    }
import org.opensearch.common.Nullable;
    @Nullable
import java.io.IOException;
    @Override
 * @opensearch.api  
    public StatusCounterStats getSnapshot() {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
    public DocStatusStats getDocStatusStats() {
            docStatusStats = null;
import org.opensearch.common.annotation.PublicApi;  
        if (out.getVersion().onOrAfter(Version.V_3_4_0)) {  
     * @opensearch.internal
    public SearchResponseStatusStats getSearchResponseStatusStats() {
    private SearchResponseStatusStats searchResponseStatusStats;  
            out.writeOptionalWriteable(docStatusStats.getSnapshot());
        docStatusStats.getSnapshot().toXContent(builder, params);  
        if (stats == null) {
        builder.endObject();
        docStatusStats = new DocStatusStats();  
        builder.startObject(Fields.STATUS_COUNTER);
/**  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.XContentBuilder;
            docStatusStats = in.readOptionalWriteable(DocStatusStats::new);
    }
    }
 * this file be licensed under the Apache-2.0 license or a
public class StatusCounterStats implements Writeable, ToXContentFragment {  
        StatusCounterStats stats = new StatusCounterStats();
    private DocStatusStats docStatusStats;  
        searchResponseStatusStats.getSnapshot().toXContent(builder, params);
 *
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.indices.stats;
            return;  
 * compatible open source license.
/*  
        return builder;
    @Nullable
        return searchResponseStatusStats;  
     */
    }
        }  
    @Override  
        stats.getDocStatusStats().add(docStatusStats);
    public void writeTo(StreamOutput out) throws IOException {
            out.writeOptionalWriteable(searchResponseStatusStats.getSnapshot());
        this.docStatusStats = docStatusStats;
    }
     * Fields for parsing and toXContent
 * The OpenSearch Contributors require contributions made to  
     * Gets a snapshot of the current state of the REST status counters.
        return stats;
import org.opensearch.core.common.io.stream.StreamOutput;
            searchResponseStatusStats.add(stats.searchResponseStatusStats);  
    public StatusCounterStats() {
        if (in.getVersion().onOrAfter(Version.V_3_4_0)) {
            searchResponseStatusStats = in.readOptionalWriteable(SearchResponseStatusStats::new);  
 * REST status statistics for OpenSearch
            docStatusStats.add(stats.docStatusStats);  
            searchResponseStatusStats = null;  
        return docStatusStats;
