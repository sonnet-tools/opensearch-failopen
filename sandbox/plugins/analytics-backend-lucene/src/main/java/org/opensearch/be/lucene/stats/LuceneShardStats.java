        return builder;
        // Indexing
    private final long mergeTotal;
            this.flushForceMergeTimeMillis + other.flushForceMergeTimeMillis,
import org.opensearch.core.common.io.stream.StreamInput;
        this.flushForceMergeTimeMillis = flushForceMergeTimeMillis;
        builder.field("merge_total", mergeTotal);
        this.commitSyncTimeMillis = commitSyncTimeMillis;
        this.docsIndexedFailures = docsIndexedFailures;
        this.docsIndexedTotal = docsIndexedTotal;
        builder.field("refresh_add_indexes_time_millis", refreshAddIndexesTimeMillis);
    private final long commitTotal;
        builder.field("index_time_millis", indexTimeMillis);
            this.refreshTimeMillis + other.refreshTimeMillis,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private final long mergeFailures;
            this.deleteTimeMillis + other.deleteTimeMillis
        long commitSyncTimeMillis,
        long flushTotal,
            this.docsIndexedFailures + other.docsIndexedFailures,
        long commitFailures,
    private final long indexTimeMillis;
        builder.field("refresh_time_millis", refreshTimeMillis);
        // Flush
        out.writeVLong(refreshAddIndexesTimeMillis);
 */
        builder.field("flush_force_merge_time_millis", flushForceMergeTimeMillis);
        long mergeTotal,
        // Indexing
    private final long deleteTimeMillis;
        long indexTimeMillis,
        builder.endObject();
        // Refresh
package org.opensearch.be.lucene.stats;
        long commitTimeMillis,
}
        builder.endObject();
        long refreshAddIndexesTimeMillis,
    private final long mergeTimeMillis;
        builder.endObject();
        builder.field("docs_indexed_failures", docsIndexedFailures);
    public static LuceneShardStats empty() {
            this.flushTimeMillis + other.flushTimeMillis,
        out.writeVLong(indexTimeMillis);
        long refreshSegmentsIncorporatedTotal,
        this.mergeTimeMillis = mergeTimeMillis;
        builder.field("refresh_total", refreshTotal);
        this.deleteTimeMillis = in.readVLong();
        this.deleteTotal = in.readVLong();
        out.writeVLong(mergeTimeMillis);
    /**
        this.refreshSegmentsIncorporatedTotal = in.readVLong();
        builder.field("delete_time_millis", deleteTimeMillis);
            this.mergeTotal + other.mergeTotal,
            this.commitSyncTimeMillis + other.commitSyncTimeMillis,
    private final long commitFailures;
    }
        builder.field("commit_total", commitTotal);
        this.refreshSegmentsIncorporatedTotal = refreshSegmentsIncorporatedTotal;
        this.commitTimeMillis = commitTimeMillis;
        // Delete
    private final long refreshSegmentsIncorporatedTotal;
        builder.endObject();
    private final long refreshTimeMillis;
        this.docsIndexedFailures = in.readVLong();
     * Constructs a snapshot with all values.
        );
        builder.field("docs_indexed_total", docsIndexedTotal);
        this.refreshTotal = in.readVLong();
        // Flush
        this.mergeTimeMillis = in.readVLong();
            this.flushTotal + other.flushTotal,
        builder.startObject("merge");
        out.writeVLong(refreshTimeMillis);
        // Delete
        // Refresh
    }
            this.refreshSegmentsIncorporatedTotal + other.refreshSegmentsIncorporatedTotal,
            this.refreshAddIndexesTimeMillis + other.refreshAddIndexesTimeMillis,
        this.commitFailures = in.readVLong();
     */
        builder.startObject("refresh");
 *
        out.writeVLong(flushTimeMillis);
        out.writeVLong(deleteTimeMillis);
import org.opensearch.common.annotation.ExperimentalApi;
    private final long docsIndexedTotal;
     * Returns a new snapshot that is the sum of this snapshot and another.
        builder.field("flush_time_millis", flushTimeMillis);
        builder.field("refresh_segments_incorporated_total", refreshSegmentsIncorporatedTotal);
        // Commit
    private final long commitSyncTimeMillis;
        this.refreshTimeMillis = in.readVLong();
        // Delete
    /**
        long flushTimeMillis,
        out.writeVLong(commitTotal);
@ExperimentalApi
        this.mergeTotal = mergeTotal;
     * Returns an empty LuceneShardStats snapshot with all zero counters.
        this.flushTotal = in.readVLong();
        this.flushTotal = flushTotal;
        this.commitTotal = in.readVLong();
    @Override
    private final long flushForceMergeTimeMillis;
        this.refreshAddIndexesTimeMillis = refreshAddIndexesTimeMillis;
        builder.field("commit_time_millis", commitTimeMillis);
public class LuceneShardStats implements DataFormatShardStats<LuceneShardStats> {
        out.writeVLong(refreshSegmentsIncorporatedTotal);
    }
            this.indexTimeMillis + other.indexTimeMillis,
        builder.endObject();
        // Merge
 * compatible open source license.
    // Refresh
        out.writeVLong(flushTotal);
 * Immutable point-in-time snapshot of shard-level Lucene statistics.
        builder.field("flush_total", flushTotal);
        long docsIndexedFailures,
        long commitTotal,
        builder.endObject();
            this.deleteTotal + other.deleteTotal,
        this.mergeFailures = mergeFailures;
    private final long docsIndexedFailures;
 * SPDX-License-Identifier: Apache-2.0
        this.commitFailures = commitFailures;
        this.commitTimeMillis = in.readVLong();
            this.refreshTotal + other.refreshTotal,
        long deleteTimeMillis
        // Merge
        this.flushTimeMillis = in.readVLong();
        long mergeFailures,
    // Delete
            this.commitTotal + other.commitTotal,
 * Produced by {@link LuceneShardStatsTracker#stats()}.
import org.opensearch.plugin.stats.DataFormatShardStats;
    // Flush
        return new LuceneShardStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    public LuceneShardStats(
    // Merge
    }
    // Indexing
     */
        this.mergeTotal = in.readVLong();
    /**
        builder.field("merge_failures", mergeFailures);
        long deleteTotal,
        out.writeVLong(commitFailures);
    private final long flushTimeMillis;
        // Flush
    // Commit
    private final long flushTotal;
        out.writeVLong(docsIndexedFailures);
        builder.startObject("commit");
    private final long deleteTotal;
        this.refreshTotal = refreshTotal;
        this.commitTotal = commitTotal;
        this.refreshAddIndexesTimeMillis = in.readVLong();
/*
        out.writeVLong(commitTimeMillis);
        // Refresh
        this.indexTimeMillis = in.readVLong();
 * @opensearch.experimental
        out.writeVLong(deleteTotal);
        this.flushTimeMillis = flushTimeMillis;
        builder.field("commit_failures", commitFailures);
        out.writeVLong(docsIndexedTotal);
    private final long commitTimeMillis;
        out.writeVLong(commitSyncTimeMillis);
import java.io.IOException;
        return new LuceneShardStats(
    }
     */
        out.writeVLong(mergeTotal);
    public void writeTo(StreamOutput out) throws IOException {
        out.writeVLong(flushForceMergeTimeMillis);
    ) {
        out.writeVLong(refreshTotal);
        this.deleteTimeMillis = deleteTimeMillis;
        builder.field("commit_sync_time_millis", commitSyncTimeMillis);
        builder.startObject("flush");
            this.mergeTimeMillis + other.mergeTimeMillis,
        this.indexTimeMillis = indexTimeMillis;
    private final long refreshAddIndexesTimeMillis;
 * this file be licensed under the Apache-2.0 license or a
            this.commitFailures + other.commitFailures,
        // Merge
        // Indexing
 */
    private final long refreshTotal;
     * Used by transport actions when a shard does not have a Lucene secondary delegate.
    @Override
            this.docsIndexedTotal + other.docsIndexedTotal,
    @Override
        long flushForceMergeTimeMillis,
import org.opensearch.core.common.io.stream.StreamOutput;
            this.commitTimeMillis + other.commitTimeMillis,
    public LuceneShardStats(StreamInput in) throws IOException {
        out.writeVLong(mergeFailures);
        builder.field("delete_total", deleteTotal);
        long refreshTotal,
        long mergeTimeMillis,
        this.commitSyncTimeMillis = in.readVLong();
        builder.startObject("delete");
        // Commit
 * The OpenSearch Contributors require contributions made to
        this.deleteTotal = deleteTotal;
import org.opensearch.core.xcontent.XContentBuilder;
        long docsIndexedTotal,
 *
/**
            this.mergeFailures + other.mergeFailures,
        this.flushForceMergeTimeMillis = in.readVLong();
        long refreshTimeMillis,
     * Used for aggregation across shards.
        builder.field("merge_time_millis", mergeTimeMillis);
        builder.startObject("indexing");
    public LuceneShardStats add(LuceneShardStats other) {
        this.docsIndexedTotal = in.readVLong();
        this.refreshTimeMillis = refreshTimeMillis;
    }
        this.mergeFailures = in.readVLong();
        // Commit
