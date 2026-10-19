        );
                    stats.putIfAbsent(indexShard.shardId(), getStatsForShard(indexShard));  
        this.indicesService = indicesService;
    }
    }  
import java.util.Optional;
public class SegmentReplicationStatsTracker {
        return rejectionCount;
        });  
        return new SegmentReplicationRejectionStats(this.rejectionCount.values().stream().mapToInt(AtomicInteger::get).sum());  
        Map<ShardId, SegmentReplicationPerGroupStats> stats = new HashMap<>();
 * @opensearch.internal
 */  
import org.opensearch.index.shard.IndexShard;  
            for (IndexShard indexShard : indexService) {
import org.opensearch.indices.IndicesService;
            } else {
        rejectionCount.compute(shardId, (k, v) -> {
import java.util.HashMap;  
 *
    public SegmentReplicationPerGroupStats getStatsForShard(IndexShard indexShard) {  
            indexShard.getReplicationStatsForTrackedReplicas(),  
    private final Map<ShardId, AtomicInteger> rejectionCount;
        for (IndexService indexService : indicesService) {  
 * The OpenSearch Contributors require contributions made to  
}
            indexShard.shardId(),
    }
            }
import java.util.concurrent.atomic.AtomicInteger;  
 * Tracker responsible for computing SegmentReplicationStats.  
        return new SegmentReplicationPerGroupStats(
 * this file be licensed under the Apache-2.0 license or a
/*  
                }
 * SPDX-License-Identifier: Apache-2.0
    public SegmentReplicationStats getStats() {
import org.opensearch.core.index.shard.ShardId;
        rejectionCount = ConcurrentCollections.newConcurrentMap();
            }
                return v;
 */  
 * compatible open source license.
package org.opensearch.index;
    protected Map<ShardId, AtomicInteger> getRejectionCount() {  
    public SegmentReplicationStatsTracker(IndicesService indicesService) {  
        }  
/**
                return new AtomicInteger(1);
        return new SegmentReplicationStats(stats);
import java.util.Map;
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            if (v == null) {  
                v.incrementAndGet();  
    public SegmentReplicationRejectionStats getTotalRejectionStats() {
            Optional.ofNullable(rejectionCount.get(indexShard.shardId())).map(AtomicInteger::get).orElse(0)
    }  
    }
 *
                if (indexShard.indexSettings().isSegRepEnabledOrRemoteNode() && indexShard.routingEntry().primary()) {
    private final IndicesService indicesService;  
    public void incrementRejectionCount(ShardId shardId) {
    }
