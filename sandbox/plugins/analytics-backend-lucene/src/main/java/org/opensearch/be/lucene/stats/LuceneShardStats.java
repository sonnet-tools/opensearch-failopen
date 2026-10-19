        this.commitSyncTimeMillis = commitSyncTimeMillis;
        long docsIndexedFailures,
        builder.field("merge_total", mergeTotal);  
        this.flushForceMergeTimeMillis = flushForceMergeTimeMillis;
    // Refresh
        builder.field("refresh_add_indexes_time_millis", refreshAddIndexesTimeMillis);  
        );  
    }
    }
        this.flushTimeMillis = flushTimeMillis;
        this.refreshTimeMillis = in.readVLong();
        long mergeTimeMillis,  
        out.writeVLong(commitSyncTimeMillis);  
        // Commit
        this.refreshTotal = in.readVLong();  
        // Commit
 *
/*  
    private final long docsIndexedTotal;
        this.docsIndexedFailures = docsIndexedFailures;
    // Indexing  
        this.docsIndexedTotal = in.readVLong();
 *  
        long commitTotal,
        out.writeVLong(refreshTotal);
        // Merge
import org.opensearch.core.common.io.stream.StreamOutput;  
     */
    // Flush
        out.writeVLong(deleteTotal);  
        builder.startObject("refresh");  
        long indexTimeMillis,  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Constructs a snapshot with all values.
    private final long commitFailures;  
            this.flushForceMergeTimeMillis + other.flushForceMergeTimeMillis,
    private final long commitTotal;
        builder.endObject();
    private final long refreshTimeMillis;  
            this.docsIndexedFailures + other.docsIndexedFailures,  
    public void writeTo(StreamOutput out) throws IOException {
 * Produced by {@link LuceneShardStatsTracker#stats()}.
        this.commitFailures = commitFailures;  
        long flushTotal,
    /**
 * this file be licensed under the Apache-2.0 license or a
        this.mergeTotal = in.readVLong();  
 * compatible open source license.
        this.commitFailures = in.readVLong();
    private final long commitSyncTimeMillis;
        long deleteTimeMillis
        // Refresh
        this.deleteTimeMillis = in.readVLong();  
/**  
    private final long flushForceMergeTimeMillis;
    }
        this.refreshTotal = refreshTotal;  
        this.flushForceMergeTimeMillis = in.readVLong();  
    private final long refreshSegmentsIncorporatedTotal;
        this.mergeTimeMillis = in.readVLong();
        this.mergeTotal = mergeTotal;
        builder.field("commit_sync_time_millis", commitSyncTimeMillis);
        long refreshSegmentsIncorporatedTotal,
        this.deleteTotal = deleteTotal;
            this.refreshTotal + other.refreshTotal,
}
        return builder;
            this.refreshSegmentsIncorporatedTotal + other.refreshSegmentsIncorporatedTotal,
    private final long refreshTotal;
        this.refreshSegmentsIncorporatedTotal = refreshSegmentsIncorporatedTotal;  
        // Indexing
        out.writeVLong(mergeTotal);
    @Override
 * SPDX-License-Identifier: Apache-2.0
        this.deleteTimeMillis = deleteTimeMillis;  
        long refreshTotal,
        // Indexing
        out.writeVLong(refreshSegmentsIncorporatedTotal);
     */
        // Merge
import org.opensearch.core.xcontent.XContentBuilder;
        long mergeTotal,
        // Refresh
public class LuceneShardStats implements DataFormatShardStats<LuceneShardStats> {
        // Delete
        builder.field("index_time_millis", indexTimeMillis);
    ) {
        this.mergeFailures = in.readVLong();
        this.indexTimeMillis = in.readVLong();
        builder.endObject();  
 */
package org.opensearch.be.lucene.stats;
        out.writeVLong(refreshAddIndexesTimeMillis);  
        builder.startObject("indexing");
        builder.endObject();
    private final long mergeTotal;
        builder.field("docs_indexed_failures", docsIndexedFailures);  
        out.writeVLong(mergeFailures);  
        this.docsIndexedTotal = docsIndexedTotal;  
     * Used for aggregation across shards.  
        return new LuceneShardStats(
    public LuceneShardStats add(LuceneShardStats other) {  
import org.opensearch.common.annotation.ExperimentalApi;
        builder.endObject();  
        builder.field("merge_time_millis", mergeTimeMillis);
        // Merge  
        this.refreshSegmentsIncorporatedTotal = in.readVLong();  
        this.flushTimeMillis = in.readVLong();
        this.commitTimeMillis = in.readVLong();  
        this.commitSyncTimeMillis = in.readVLong();
    /**  
        long mergeFailures,
        builder.field("delete_time_millis", deleteTimeMillis);
            this.indexTimeMillis + other.indexTimeMillis,
        this.flushTotal = in.readVLong();
        builder.field("merge_failures", mergeFailures);
        // Commit
        return new LuceneShardStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);  
        this.mergeFailures = mergeFailures;  
    public LuceneShardStats(StreamInput in) throws IOException {  
        builder.field("docs_indexed_total", docsIndexedTotal);
@ExperimentalApi  
            this.mergeTotal + other.mergeTotal,  
            this.flushTotal + other.flushTotal,
    private final long indexTimeMillis;  
            this.refreshAddIndexesTimeMillis + other.refreshAddIndexesTimeMillis,
        // Indexing  
 */  
    private final long mergeTimeMillis;  
    /**
        long commitSyncTimeMillis,
 * The OpenSearch Contributors require contributions made to  
        builder.field("commit_total", commitTotal);
        builder.field("flush_time_millis", flushTimeMillis);
        this.refreshAddIndexesTimeMillis = in.readVLong();
            this.docsIndexedTotal + other.docsIndexedTotal,
        // Refresh  
        out.writeVLong(flushForceMergeTimeMillis);
    private final long flushTotal;  
        builder.startObject("flush");
            this.mergeFailures + other.mergeFailures,
            this.deleteTimeMillis + other.deleteTimeMillis
     * Returns a new snapshot that is the sum of this snapshot and another.
        out.writeVLong(commitTotal);  
     * Returns an empty LuceneShardStats snapshot with all zero counters.
        this.commitTotal = in.readVLong();
    }
    // Commit  
    private final long mergeFailures;
     */
    // Merge
        long flushForceMergeTimeMillis,  
        long refreshTimeMillis,
        builder.endObject();
    }
        builder.startObject("delete");
        builder.startObject("merge");
            this.commitTotal + other.commitTotal,  
        long flushTimeMillis,
    private final long deleteTimeMillis;
        long deleteTotal,  
        builder.field("refresh_segments_incorporated_total", refreshSegmentsIncorporatedTotal);
     * Used by transport actions when a shard does not have a Lucene secondary delegate.  
import org.opensearch.plugin.stats.DataFormatShardStats;
        out.writeVLong(mergeTimeMillis);
        // Flush
        // Delete
        long refreshAddIndexesTimeMillis,  
        builder.field("flush_total", flushTotal);  
        builder.field("commit_failures", commitFailures);  
        builder.startObject("commit");  
    private final long commitTimeMillis;
            this.commitTimeMillis + other.commitTimeMillis,
        builder.field("refresh_time_millis", refreshTimeMillis);
        this.deleteTotal = in.readVLong();
        long docsIndexedTotal,
        out.writeVLong(flushTotal);
        builder.field("commit_time_millis", commitTimeMillis);
    private final long refreshAddIndexesTimeMillis;
        builder.endObject();
            this.mergeTimeMillis + other.mergeTimeMillis,
            this.commitSyncTimeMillis + other.commitSyncTimeMillis,  
        this.docsIndexedFailures = in.readVLong();  
        out.writeVLong(docsIndexedFailures);
import java.io.IOException;
        this.mergeTimeMillis = mergeTimeMillis;
 * Immutable point-in-time snapshot of shard-level Lucene statistics.
        out.writeVLong(refreshTimeMillis);
        builder.field("flush_force_merge_time_millis", flushForceMergeTimeMillis);
    private final long flushTimeMillis;
        out.writeVLong(indexTimeMillis);
        // Flush  
        this.refreshAddIndexesTimeMillis = refreshAddIndexesTimeMillis;
        out.writeVLong(deleteTimeMillis);
        builder.field("delete_total", deleteTotal);  
            this.refreshTimeMillis + other.refreshTimeMillis,  
    // Delete  
        // Flush
        long commitFailures,
            this.deleteTotal + other.deleteTotal,
        this.commitTotal = commitTotal;
    private final long docsIndexedFailures;
        this.refreshTimeMillis = refreshTimeMillis;
        builder.field("refresh_total", refreshTotal);
        this.flushTotal = flushTotal;  
    @Override  
        out.writeVLong(commitTimeMillis);
        long commitTimeMillis,  
        this.commitTimeMillis = commitTimeMillis;
        out.writeVLong(docsIndexedTotal);  
    private final long deleteTotal;
        this.indexTimeMillis = indexTimeMillis;
        // Delete
import org.opensearch.core.common.io.stream.StreamInput;
    public static LuceneShardStats empty() {
            this.commitFailures + other.commitFailures,
        out.writeVLong(commitFailures);
    @Override
        out.writeVLong(flushTimeMillis);  
    public LuceneShardStats(  
 * @opensearch.experimental
            this.flushTimeMillis + other.flushTimeMillis,  
    }
