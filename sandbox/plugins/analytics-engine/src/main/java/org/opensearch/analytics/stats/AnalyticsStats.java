    public record Queries(LatencyStats elapsedMs, LatencyStats planningMs) implements ToXContentFragment, Writeable {
 * {@link AnalyticsStatsCollector#snapshot()} and rendered as a JSON fragment
        public static final LatencyStats EMPTY = new LatencyStats(0, 0);
    /**
            out.writeVLong(succeeded);
        }
     * elapsed and Calcite planning time.
            builder.field("elapsed_ms");
    }
    /** Per-fragment (task) rollup. */
    public Map<String, StageBucket> stagesByType() {
            builder.endObject();
        }
import java.util.Map;
        fragments.toXContent(builder, params);
        public void writeTo(StreamOutput out) throws IOException {
     */
/**
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeVInt(stagesByType.size());
            this(in.readVLong(), in.readVLong());
    /** Per-stage-type rollup, keyed by {@link org.opensearch.analytics.planner.dag.StageExecutionType} name. */
        builder.endObject();
import org.opensearch.common.annotation.ExperimentalApi;
            builder.endObject();
            builder.field("failed", failed);
 * {@code rows_processed}, {@code tasks_completed}) so dashboards can ingest
        }
    public Fragments fragments() {
        @Override
        @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.endObject();
 *
@ExperimentalApi
            builder.field("succeeded", succeeded);
     * extension point. This bucket carries analytics-engine-specific timing
import java.io.IOException;
            builder.field("elapsed_ms");
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.startObject();
            ToXContentFragment,
            builder.field(e.getKey());
package org.opensearch.analytics.stats;
    }
        builder.startObject("analytics");
     * intentionally <strong>not</strong> exposed here — those are covered by
    }
    }
    public record Fragments(long total, long succeeded, long failed, LatencyStats elapsedMs) implements ToXContentFragment, Writeable {
        return builder;
 * change in subsequent revisions.
        public void writeTo(StreamOutput out) throws IOException {
        return queries;
 * by the stats REST handler.
        public StageBucket(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
            builder.field("cancelled", cancelled);
            Writeable {
    private final Fragments fragments;
import java.util.TreeMap;
            elapsedMs.toXContent(builder, params);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * — mirroring the analytics DataFusion backend's stats contract. Averages,
        int size = in.readVInt();
            out.writeVLong(failed);
            out.writeString(e.getKey());
        }
        @Override
     * of their elapsed times. Both monotonically increasing since node start.
    public Queries queries() {
        this.queries = new Queries(in);
            builder.field("count", count);
        }
        }
            builder.field("planning_ms");
        @Override
            builder.field("rows_processed_total", rowsProcessedTotal);
            out.writeVLong(succeeded);
 *
        }
import org.opensearch.core.common.io.stream.StreamInput;
 */
        this.stagesByType = map;
            String key = in.readString();
 * Snapshot of node-local analytics-engine counters and timers. Built by
            elapsedMs.writeTo(out);
        // TreeMap preserves the deterministic alphabetical ordering used by snapshot().
            e.getValue().writeTo(out);
import org.opensearch.core.xcontent.ToXContentFragment;
        for (Map.Entry<String, StageBucket> e : stagesByType.entrySet()) {
     * analytics-engine integration with the existing {@code _nodes/stats}
 *
    public AnalyticsStats(StreamInput in) throws IOException {
        return fragments;
    public record LatencyStats(long count, long sumMs) implements ToXContentFragment, Writeable {
    private final Map<String, StageBucket> stagesByType;
    }
        public Fragments(StreamInput in) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        }
        this.fragments = fragments;
import org.opensearch.core.common.io.stream.Writeable;
            this(in.readVLong(), in.readVLong(), in.readVLong(), new LatencyStats(in));
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/*
 *
    public AnalyticsStats(Queries queries, Map<String, StageBucket> stagesByType, Fragments fragments) {
            return builder;
    @Override
            out.writeVLong(total);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Cumulative latency totals: {@code count} of recordings and {@code sum_ms}
        this.queries = queries;
    @Override
        builder.endObject();
            builder.field("sum_ms", sumMs);
        return stagesByType;
        @Override
            elapsedMs.writeTo(out);
            elapsedMs.writeTo(out);
            elapsedMs.toXContent(builder, params);
        }
    public void writeTo(StreamOutput out) throws IOException {
        public void writeTo(StreamOutput out) throws IOException {
}
            builder.field("failed", failed);
        }
            builder.field("succeeded", succeeded);
    }
 */
 * either API without translating field names.
            map.put(key, new StageBucket(in));
            out.writeVLong(started);
            out.writeVLong(count);
            return builder;
 * <p>Marked {@link ExperimentalApi} — field shapes and the bucket layout may
        builder.startObject("stages_by_type");
public final class AnalyticsStats implements ToXContentFragment, Writeable {
        for (int i = 0; i < size; i++) {
 * Prometheus / etc.) from interval diffs.
        for (Map.Entry<String, StageBucket> e : stagesByType.entrySet()) {
        public Queries(StreamInput in) throws IOException {
    private final Queries queries;
    }
        this.stagesByType = stagesByType;
        this.fragments = new Fragments(in);
 * <p>Latency buckets carry only raw cumulative {@code count} and {@code sum_ms}
        }
    }
        queries.toXContent(builder, params);
        implements
            builder.startObject();
            return builder;
    }
            out.writeVLong(cancelled);
        @Override
            e.getValue().toXContent(builder, params);
            builder.field("started", started);
        fragments.writeTo(out);
            builder.endObject();
        public void writeTo(StreamOutput out) throws IOException {
            elapsedMs.toXContent(builder, params);
        }
        Map<String, StageBucket> map = new TreeMap<>();
            out.writeVLong(rowsProcessedTotal);
 * percentiles, and rates are derived by the metrics backend (Tumbler /
            builder.field("elapsed_ms");
            builder.startObject("queries");
            return builder;
        public LatencyStats(StreamInput in) throws IOException {
     */
 * compatible open source license.
    /**
        queries.writeTo(out);
            planningMs.toXContent(builder, params);
        @Override
        }
            planningMs.writeTo(out);
        }
            out.writeVLong(failed);
 * The OpenSearch Contributors require contributions made to
            builder.field("total", total);
    }
     * totals that don't have a home in core node stats: end-to-end query
    public record StageBucket(long started, long succeeded, long failed, long cancelled, long rowsProcessedTotal, LatencyStats elapsedMs)
        @Override
 * <p>Field naming aligns with PR #21660's {@code StageProfile} ({@code elapsed_ms},
            builder.startObject("fragments");
     * Per-query latency rollup. Counters like total / succeeded / failed are
            this(new LatencyStats(in), new LatencyStats(in));
            out.writeVLong(sumMs);
            this(in.readVLong(), in.readVLong(), in.readVLong(), in.readVLong(), in.readVLong(), new LatencyStats(in));
        }
 * SPDX-License-Identifier: Apache-2.0
