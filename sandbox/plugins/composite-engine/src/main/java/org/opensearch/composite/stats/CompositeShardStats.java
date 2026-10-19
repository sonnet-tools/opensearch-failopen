        this.refreshMergeFailures = in.readVLong();
        this.refreshMergeTotal = refreshMergeTotal;  
    private final long writeTotal;
        // Refresh — includes the merge-on-refresh breakdown.  
        builder.endObject();
        builder.field("merge_failures", mergeFailures);
        this.writePrimaryFailures = in.readVLong();
 *
        long refreshMergeTotal,
        out.writeVLong(writeTotal);
        builder.endObject();
    }
        out.writeVLong(refreshMergeFailures);  
        long writeTotal,
        long refreshTimeMillis,
        // Merge — standalone merger path.  
        long writePrimaryFailures,  
        builder.field("write_primary_failures", writePrimaryFailures);
            this.refreshMergeFailures + other.refreshMergeFailures,  
        this.mergeTotal = in.readVLong();  
        builder.startObject("mapping");  
        this.writeSecondaryFailures = writeSecondaryFailures;
        return new CompositeShardStats(
 * The OpenSearch Contributors require contributions made to  
}
    }
 * compatible open source license.
    private final long mergeTimeMillis;  
            this.writeSecondaryFailures + other.writeSecondaryFailures,  
     */
        out.writeVLong(refreshMergeTimeMillis);
    private final long mergeFailures;
 * this file be licensed under the Apache-2.0 license or a
        this.mappingUpdateExecutedTotal = in.readVLong();  
        builder.field("refresh_total", refreshTotal);
 * @opensearch.experimental
    /** Returns a new snapshot that is the element-wise sum of this and another. */
        out.writeVLong(mappingUpdateExecutedTotal);
        this.writePrimaryFailures = writePrimaryFailures;
    // Dynamic mapping updates that were actually applied (newVersion > current), not no-op calls.
        this.mergeTimeMillis = in.readVLong();
        return builder;
import org.opensearch.plugin.stats.DataFormatShardStats;
        long refreshMergeFailures,
import org.opensearch.core.common.io.stream.StreamOutput;  
            this.writePrimaryFailures + other.writePrimaryFailures,
        out.writeVLong(mergeTimeMillis);
        builder.field("write_secondary_failures", writeSecondaryFailures);
        this.refreshTimeMillis = refreshTimeMillis;
 */
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.XContentBuilder;
    /**
        this.refreshMergeFailures = refreshMergeFailures;
        // Dynamic mapping updates actually applied.
import java.io.IOException;
        builder.endObject();
public class CompositeShardStats implements DataFormatShardStats<CompositeShardStats> {
            this.writeTotal + other.writeTotal,
    private final long refreshMergeTotal;  
/*  
        builder.endObject();  
        builder.field("write_total", writeTotal);  
    }
    private final long mappingUpdateExecutedTotal;  
    }  
    ) {  
            this.refreshTotal + other.refreshTotal,
        this.mergeTotal = mergeTotal;  
        builder.field("merge_time_millis", mergeTimeMillis);  
        builder.field("mapping_update_executed_total", mappingUpdateExecutedTotal);
 * Produced by {@link CompositeShardStatsTracker#stats()}.
        long mergeFailures,
    // Merge (standalone CompositeMerger path).
    // Refresh (engine-level, orchestrating all formats) + the merge-on-refresh breakdown.  
        this.refreshMergeTimeMillis = in.readVLong();
/**  
        this.refreshTotal = refreshTotal;
        this.mergeFailures = in.readVLong();
    @Override
    public CompositeShardStats add(CompositeShardStats other) {  
        long refreshMergeTimeMillis,  
        out.writeVLong(mergeFailures);  
            this.refreshTimeMillis + other.refreshTimeMillis,  
        );
        return new CompositeShardStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
@ExperimentalApi  
        long writeSecondaryFailures,
    public CompositeShardStats(
        long refreshTotal,  
        this.mergeFailures = mergeFailures;
     * shard has no composite engine.
        out.writeVLong(writeSecondaryFailures);  
    private final long writeSecondaryFailures;  
            this.mergeTotal + other.mergeTotal,
    private final long refreshMergeFailures;
        // Write attempts + failures by format role.
    public void writeTo(StreamOutput out) throws IOException {
 * Immutable point-in-time snapshot of shard-level composite-engine statistics.
    @Override
        builder.field("refresh_merge_total", refreshMergeTotal);
            this.refreshMergeTimeMillis + other.refreshMergeTimeMillis,
    private final long writePrimaryFailures;
package org.opensearch.composite.stats;
    private final long mergeTotal;
    // Write attempts + failures, split by primary vs secondary format.  
        builder.startObject("merge");
        out.writeVLong(refreshMergeTotal);
        this.refreshTotal = in.readVLong();
    }
        builder.field("merge_total", mergeTotal);
    private final long refreshMergeTimeMillis;
    public static CompositeShardStats empty() {  
 *  
        this.refreshTimeMillis = in.readVLong();
    /** Constructs a snapshot with all values. */
        builder.field("refresh_merge_failures", refreshMergeFailures);  
        long mergeTotal,
        builder.field("refresh_time_millis", refreshTimeMillis);  
        out.writeVLong(refreshTimeMillis);  
 */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override  
    public CompositeShardStats(StreamInput in) throws IOException {  
     * Returns an empty snapshot with all zero counters. Used by transport actions when a  
    }
        this.refreshMergeTimeMillis = refreshMergeTimeMillis;
            this.mappingUpdateExecutedTotal + other.mappingUpdateExecutedTotal
        long mergeTimeMillis,  
        this.writeSecondaryFailures = in.readVLong();
        this.mergeTimeMillis = mergeTimeMillis;
        this.mappingUpdateExecutedTotal = mappingUpdateExecutedTotal;  
            this.refreshMergeTotal + other.refreshMergeTotal,
        builder.field("refresh_merge_time_millis", refreshMergeTimeMillis);
        this.refreshMergeTotal = in.readVLong();  
    private final long refreshTimeMillis;
        this.writeTotal = writeTotal;  
        long mappingUpdateExecutedTotal
            this.mergeTimeMillis + other.mergeTimeMillis,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
        this.writeTotal = in.readVLong();  
        out.writeVLong(writePrimaryFailures);
    private final long refreshTotal;
        out.writeVLong(mergeTotal);
        builder.startObject("refresh");
        out.writeVLong(refreshTotal);
            this.mergeFailures + other.mergeFailures,  
        builder.startObject("write");
