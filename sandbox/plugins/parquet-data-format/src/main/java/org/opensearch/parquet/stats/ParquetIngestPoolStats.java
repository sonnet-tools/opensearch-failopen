import org.opensearch.core.common.io.stream.Writeable;
        this.rejected = rejected;  
        this.completed = in.readVLong();  
 *
    public ParquetIngestPoolStats(StreamInput in) throws IOException {
import org.opensearch.threadpool.ThreadPoolStats;
 * this file be licensed under the Apache-2.0 license or a
            stats.getRejected(),  
        out.writeVLong(rejected);
        this.active = in.readVInt();
        builder.field("active", active);
        return builder;
            stats.getThreads(),  
    public void writeTo(StreamOutput out) throws IOException {  
    @Override
        this.threads = in.readVInt();
 * The OpenSearch Contributors require contributions made to  
 * <p>Node-level only: rendered under the {@code native_ingest_pool} block of the per-node stats  
    @Override
public final class ParquetIngestPoolStats implements Writeable, ToXContentFragment {  
    private final int active;
        builder.endObject();
        this.queueDepth = queueDepth;
 */  
        out.writeVInt(queueDepth);
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
 *
        builder.field("rejected", rejected);
        builder.startObject("native_ingest_pool");
import org.opensearch.core.xcontent.ToXContentFragment;
    private final long completed;  
    }  
        this.queueDepth = in.readVInt();  
        this.threads = threads;  
/*  
 *
     * Builds a snapshot from a {@link ThreadPoolStats.Stats} reading of the {@code parquet_native_write}
    public ParquetIngestPoolStats(int threads, int queueDepth, int active, long rejected, long completed) {
import org.opensearch.core.common.io.stream.StreamInput;
    private final long rejected;
        out.writeVLong(completed);
     */  
}
        this.completed = completed;
        out.writeVInt(threads);
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.active = active;
    private final int threads;
 * Live, node-level snapshot of the {@code parquet_native_write} thread pool that backs Parquet  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental  
    public static ParquetIngestPoolStats from(ThreadPoolStats.Stats stats) {
        if (stats == null) {
            stats.getQueue(),
        out.writeVInt(active);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        this.rejected = in.readVLong();
    }
package org.opensearch.parquet.stats;
    }  
 * background ingestion writes. Surfaces queue saturation and rejection pressure.
/**
        builder.field("completed", completed);  
 */
 * aggregate, never on a per-shard payload.
            stats.getCompleted()
        }
        builder.field("threads", threads);
@ExperimentalApi
     * pool, or {@code null} if {@code stats} is {@code null} (pool not found).
        );
    }  
            return null;  
import org.opensearch.core.xcontent.XContentBuilder;  
            stats.getActive(),
import java.io.IOException;  
    /**  
        builder.field("queue_depth", queueDepth);  
    private final int queueDepth;  
    }
        return new ParquetIngestPoolStats(
