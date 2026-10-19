        }  
import org.opensearch.core.xcontent.ToXContentFragment;
 * percentiles, and rates are derived by the metrics backend (Tumbler /
        builder.endObject();
        }  
            builder.endObject();
            builder.field("cancelled", cancelled);
        public void writeTo(StreamOutput out) throws IOException {
            return builder;
        implements
            builder.endObject();
        this.stagesByType = map;  
        this.fragments = fragments;  
            elapsedMs.writeTo(out);
    /**  
import org.opensearch.core.common.io.stream.Writeable;
    /** Per-fragment (task) rollup. */
        public LatencyStats(StreamInput in) throws IOException {
     * analytics-engine integration with the existing {@code _nodes/stats}
        public void writeTo(StreamOutput out) throws IOException {
        @Override  
            builder.field("elapsed_ms");
import org.opensearch.core.common.io.stream.StreamOutput;  
/*  
            builder.field("succeeded", succeeded);  
    }
 *
            out.writeString(e.getKey());  
     * elapsed and Calcite planning time.
            builder.field(e.getKey());  
    }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        }
            builder.endObject();  
        }
        return fragments;  
 */
    private final Map<String, StageBucket> stagesByType;  
            builder.field("failed", failed);
 * compatible open source license.
     * totals that don't have a home in core node stats: end-to-end query  
     */
            out.writeVLong(total);
        @Override
            out.writeVLong(failed);
            builder.field("planning_ms");
        @Override
            return builder;
    public record StageBucket(long started, long succeeded, long failed, long cancelled, long rowsProcessedTotal, LatencyStats elapsedMs)
            builder.startObject();
        }
            elapsedMs.toXContent(builder, params);
    public record LatencyStats(long count, long sumMs) implements ToXContentFragment, Writeable {
            elapsedMs.toXContent(builder, params);  
            out.writeVLong(cancelled);  
        public Queries(StreamInput in) throws IOException {
            this(in.readVLong(), in.readVLong(), in.readVLong(), in.readVLong(), in.readVLong(), new LatencyStats(in));
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
}
    @Override
        builder.startObject("stages_by_type");
            out.writeVLong(sumMs);  
    }
    public void writeTo(StreamOutput out) throws IOException {
        }  
 * {@link AnalyticsStatsCollector#snapshot()} and rendered as a JSON fragment
     * intentionally <strong>not</strong> exposed here — those are covered by  
            builder.field("count", count);  
    }  
        }
        public void writeTo(StreamOutput out) throws IOException {
 * either API without translating field names.
 * by the stats REST handler.  
        Map<String, StageBucket> map = new TreeMap<>();
        fragments.writeTo(out);  
    public Fragments fragments() {
     * of their elapsed times. Both monotonically increasing since node start.
     * extension point. This bucket carries analytics-engine-specific timing
        return stagesByType;
    private final Fragments fragments;
        public void writeTo(StreamOutput out) throws IOException {
     * Cumulative latency totals: {@code count} of recordings and {@code sum_ms}
        }
        return builder;  
 */  
    public AnalyticsStats(StreamInput in) throws IOException {  
        queries.toXContent(builder, params);  
/**  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * Snapshot of node-local analytics-engine counters and timers. Built by
package org.opensearch.analytics.stats;
            elapsedMs.toXContent(builder, params);
            builder.field("started", started);
        this.queries = new Queries(in);
 * <p>Latency buckets carry only raw cumulative {@code count} and {@code sum_ms}  
            builder.field("succeeded", succeeded);  
    }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this(new LatencyStats(in), new LatencyStats(in));  
            out.writeVLong(started);  
     * Per-query latency rollup. Counters like total / succeeded / failed are
 * <p>Field naming aligns with PR #21660's {@code StageProfile} ({@code elapsed_ms},
 * SPDX-License-Identifier: Apache-2.0
    public Queries queries() {  
        this.fragments = new Fragments(in);
            builder.startObject();
        }
            ToXContentFragment,  
            builder.field("elapsed_ms");  
            planningMs.toXContent(builder, params);  
            this(in.readVLong(), in.readVLong());  
 * {@code rows_processed}, {@code tasks_completed}) so dashboards can ingest  
    public Map<String, StageBucket> stagesByType() {
        return queries;
import org.opensearch.common.annotation.ExperimentalApi;
            out.writeVLong(count);
 * The OpenSearch Contributors require contributions made to  
            builder.field("failed", failed);
            elapsedMs.writeTo(out);
 * <p>Marked {@link ExperimentalApi} — field shapes and the bucket layout may
 *
        public Fragments(StreamInput in) throws IOException {
    }
            builder.field("sum_ms", sumMs);
            planningMs.writeTo(out);  
        }  
            out.writeVLong(succeeded);
            Writeable {
            builder.field("total", total);
     */  
            out.writeVLong(failed);
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.core.common.io.stream.StreamInput;
        @Override  
        // TreeMap preserves the deterministic alphabetical ordering used by snapshot().  
            this(in.readVLong(), in.readVLong(), in.readVLong(), new LatencyStats(in));  
        this.queries = queries;
    public AnalyticsStats(Queries queries, Map<String, StageBucket> stagesByType, Fragments fragments) {  
        }
    public record Fragments(long total, long succeeded, long failed, LatencyStats elapsedMs) implements ToXContentFragment, Writeable {  
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
        for (Map.Entry<String, StageBucket> e : stagesByType.entrySet()) {
    @Override  
        @Override  
        builder.endObject();  
 *
        public StageBucket(StreamInput in) throws IOException {  
    }
        for (int i = 0; i < size; i++) {
public final class AnalyticsStats implements ToXContentFragment, Writeable {  
    /** Per-stage-type rollup, keyed by {@link org.opensearch.analytics.planner.dag.StageExecutionType} name. */  
        }
            builder.endObject();
            builder.field("rows_processed_total", rowsProcessedTotal);  
        @Override
            builder.field("elapsed_ms");
import java.util.TreeMap;
 * Prometheus / etc.) from interval diffs.  
        this.stagesByType = stagesByType;
            return builder;  
    }
import java.io.IOException;
        queries.writeTo(out);  
            elapsedMs.writeTo(out);
        }
@ExperimentalApi
            map.put(key, new StageBucket(in));
    private final Queries queries;
import java.util.Map;  
            return builder;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public static final LatencyStats EMPTY = new LatencyStats(0, 0);  
        fragments.toXContent(builder, params);
            out.writeVLong(rowsProcessedTotal);
        @Override  
            builder.startObject("fragments");
        builder.startObject("analytics");
        out.writeVInt(stagesByType.size());
    }
    public record Queries(LatencyStats elapsedMs, LatencyStats planningMs) implements ToXContentFragment, Writeable {  
            e.getValue().toXContent(builder, params);
        }
            out.writeVLong(succeeded);  
            builder.startObject("queries");
        int size = in.readVInt();
    }
        for (Map.Entry<String, StageBucket> e : stagesByType.entrySet()) {
        @Override  
            String key = in.readString();  
 * change in subsequent revisions.  
 * — mirroring the analytics DataFusion backend's stats contract. Averages,
        }
    /**
            e.getValue().writeTo(out);
