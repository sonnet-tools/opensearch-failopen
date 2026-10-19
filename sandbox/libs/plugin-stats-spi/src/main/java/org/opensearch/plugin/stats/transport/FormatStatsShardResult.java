    }
    @Override
        }
import org.opensearch.core.common.io.stream.Writeable;
 */  
    public void writeTo(StreamOutput out) throws IOException {
    }
import org.opensearch.core.common.io.stream.StreamInput;  
 * SPDX-License-Identifier: Apache-2.0
/*  
@ExperimentalApi
 * The OpenSearch Contributors require contributions made to  
        return stats;
 *
            this.stats = null;  
import org.opensearch.core.common.io.stream.StreamOutput;
        } else {
            stats.writeTo(out);  
    private final T stats;  
        shardRouting.writeTo(out);  
        } else {
        if (in.readBoolean()) {  
    }
    private final ShardRouting shardRouting;
    public FormatStatsShardResult(StreamInput in, Writeable.Reader<T> reader) throws IOException {
public class FormatStatsShardResult<T extends DataFormatShardStats<T>> implements Writeable {  
        }  
        return shardRouting;
        this.shardRouting = shardRouting;  
            out.writeBoolean(true);
    public FormatStatsShardResult(ShardRouting shardRouting, T stats) {
    public T stats() {
package org.opensearch.plugin.stats.transport;
 */
            this.stats = reader.read(in);
    }
 *
/**
        this.shardRouting = new ShardRouting(in);
 * @opensearch.experimental  
import org.opensearch.common.annotation.ExperimentalApi;
 * @param <T> concrete shard-stats type
 * this file be licensed under the Apache-2.0 license or a
    }  
    public ShardRouting shardRouting() {  
import java.io.IOException;
 * compatible open source license.
import org.opensearch.plugin.stats.DataFormatShardStats;  
        if (stats != null) {
        this.stats = stats;
import org.opensearch.cluster.routing.ShardRouting;
 * Per-shard result holding typed stats produced by the format's provider.
}
            out.writeBoolean(false);
 *  
