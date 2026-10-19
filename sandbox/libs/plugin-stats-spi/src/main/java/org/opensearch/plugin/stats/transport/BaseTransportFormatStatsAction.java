import org.opensearch.cluster.block.ClusterBlockException;
    protected FormatStatsShardResult<T> readShardResult(StreamInput in) throws IOException {
            for (String index : concreteIndices) {
}  
    }
    @Override
import org.opensearch.threadpool.ThreadPool;  
        return new FormatStatsShardResult<>(shardRouting, provider.shardStats(shardRouting.shardId()).orElse(null));  
        int totalShards,
            // — the broadcast then has exactly one copy per logical shard, which makes  
        );
    @Override
import org.opensearch.plugin.stats.DataFormatShardStats;  
                }
            }
        }).collect(Collectors.toList());
import java.io.IOException;  
 *
        final Set<String> resolvedNodeFilter = new HashSet<>();
public abstract class BaseTransportFormatStatsAction<T extends DataFormatShardStats<T>> extends TransportBroadcastByNodeAction<  
import org.opensearch.core.common.io.stream.Writeable;
    ) {
    private final String formatName;
    ) {
                    }
    }
            // engine, so they have no per-format tracker registered. Always restrict to primaries
import org.opensearch.cluster.routing.ShardsIterator;  
        TransportService transportService,
    FormatStatsRequest,
        }
 */
                    if (clusterState.getNodes().get(nf) == null) {
    @Override  
        int successfulShards,  
            }
                            "shard [" + sid + "] is out of range for index [" + index + "] which has [" + numShards + "] shard(s)"  
import java.util.stream.Collectors;
import java.util.HashSet;
                }  
    }
import org.opensearch.cluster.block.ClusterBlockLevel;
            }
    }
            ThreadPool.Names.MANAGEMENT  
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
        String actionName,  
        return new FormatStatsShardResult<>(in, reader);
            // empty `{ primary: false }` noise in `level=shards` output.
                if ("_local".equals(nf)) {
 */  
        if (nodeFilter != null) {
                        );
        this.reader = reader;  
            }  
            totalShards,
                    resolvedNodeFilter.add(clusterState.getNodes().getLocalNodeId());
import org.opensearch.action.support.ActionFilters;
        final Set<Integer> shardFilterSet = new HashSet<>();
            if (sr.primary() == false) {  
        return new FormatStatsResponse<>(  
        ClusterService clusterService,  
                } else {  
            clusterService,
/*  
            transportService,
            actionFilters,  
            for (int sid : shardFilter) {  
import org.opensearch.cluster.service.ClusterService;
        return new FormatStatsRequest(in);
                    resolvedNodeFilter.add(nf);
        if (shardFilter != null) {
            if (nodeFilterActive && !resolvedNodeFilter.contains(sr.currentNodeId())) {  
            shardFailures
                    }  
            }
    protected ClusterBlockException checkRequestBlock(ClusterState state, FormatStatsRequest request, String[] concreteIndices) {  
        FormatStatsRequest request,
    protected ClusterBlockException checkGlobalBlock(ClusterState state, FormatStatsRequest request) {
            request.formatName(),
            // `_shards.total` match the user's `index.number_of_shards` setting and prevents
        this.formatName = formatName;
        );
            FormatStatsRequest::new,
        List<DefaultShardOperationFailedException> shardFailures,  
        return new PlainShardsIterator(filtered);  
    protected BaseTransportFormatStatsAction(
            request.isShardLevel(),
        if (provider == null) return new FormatStatsShardResult<>(shardRouting, null);
    @Override  
    protected FormatStatsRequest readRequestFrom(StreamInput in) throws IOException {  
 *
        List<ShardRouting> shards = clusterState.routingTable().allShards(concreteIndices).getShardRoutings();
                return false;
 *  
            }
 * SPDX-License-Identifier: Apache-2.0
        ActionFilters actionFilters,
    }  
    FormatStatsResponse<T>,
            actionName,  
import org.opensearch.transport.TransportService;
            indexNameExpressionResolver,
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
            results,  
package org.opensearch.plugin.stats.transport;
    }  
            successfulShards,
import org.opensearch.plugin.stats.DataFormatStatsProvider;
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
import org.opensearch.cluster.routing.PlainShardsIterator;
                int numShards = clusterState.routingTable().index(index).getShards().size();
 * The OpenSearch Contributors require contributions made to  
        final boolean nodeFilterActive = nodeFilter != null && nodeFilter.length > 0;
        Writeable.Reader<T> reader,
            if (shardFilterActive && !shardFilterSet.contains(sr.shardId().id())) {  
/**  
import org.opensearch.common.annotation.ExperimentalApi;
        List<ShardRouting> filtered = shards.stream().filter(sr -> {  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
 * Abstract transport action that collects per-format stats using broadcast-by-node routing.
                for (int sid : shardFilter) {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        int failedShards,
        String formatName,
        List<FormatStatsShardResult<T>> results,
        super(
        if (shardFilter != null && shardFilter.length > 0) {  
    @Override  
    @SuppressWarnings("unchecked")
 * Each data-format plugin subclasses this to register its own action.
    private final Writeable.Reader<T> reader;  
import org.opensearch.cluster.ClusterState;  
            return true;  
            // DFA replicas use segment replication from remote store and don't run an indexing
    }  
        int[] shardFilter = request.getShardFilter();  
 * compatible open source license.
            for (String nf : nodeFilter) {  
@ExperimentalApi
        DataFormatStatsProvider<T> provider = (DataFormatStatsProvider<T>) DataFormatStatsProviderRegistry.INSTANCE.get(formatName);
                return false;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
        }
        String[] nodeFilter = request.getNodeFilter();
    @Override
                    if (sid < 0 || sid >= numShards) {
                        throw new IllegalArgumentException("node [" + nf + "] not found in cluster");
                return false;
        }  
import java.util.Set;  
 * @opensearch.experimental  
 * @param <T> concrete shard-stats type
                        throw new IllegalArgumentException(
            failedShards,  
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
        ClusterState clusterState
    }
import org.opensearch.cluster.routing.ShardRouting;
    protected FormatStatsResponse<T> newResponse(  
    FormatStatsShardResult<T>> {  
import java.util.List;
    protected ShardsIterator shards(ClusterState clusterState, FormatStatsRequest request, String[] concreteIndices) {
    protected FormatStatsShardResult<T> shardOperation(FormatStatsRequest request, ShardRouting shardRouting) {  
 * this file be licensed under the Apache-2.0 license or a
                shardFilterSet.add(sid);
        IndexNameExpressionResolver indexNameExpressionResolver  
        final boolean shardFilterActive = shardFilter != null && shardFilter.length > 0;
