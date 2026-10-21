        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
        final boolean shardFilterActive = shardFilter != null && shardFilter.length > 0;
        if (shardFilter != null) {
        final boolean nodeFilterActive = nodeFilter != null && nodeFilter.length > 0;
        );
            }
    protected ClusterBlockException checkGlobalBlock(ClusterState state, FormatStatsRequest request) {
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
        FormatStatsRequest request,
import org.opensearch.transport.TransportService;
        return new PlainShardsIterator(filtered);
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
                int numShards = clusterState.routingTable().index(index).getShards().size();
            FormatStatsRequest::new,
public abstract class BaseTransportFormatStatsAction<T extends DataFormatShardStats<T>> extends TransportBroadcastByNodeAction<
        if (provider == null) return new FormatStatsShardResult<>(shardRouting, null);
import org.opensearch.action.support.ActionFilters;
    ) {
import org.opensearch.cluster.block.ClusterBlockLevel;
                    resolvedNodeFilter.add(nf);
                        throw new IllegalArgumentException(
import org.opensearch.cluster.routing.PlainShardsIterator;
import org.opensearch.plugin.stats.DataFormatStatsProvider;
import java.util.HashSet;
                }
        super(
            }
    protected FormatStatsResponse<T> newResponse(
import org.opensearch.cluster.service.ClusterService;
        return new FormatStatsResponse<>(
            request.isShardLevel(),
    protected BaseTransportFormatStatsAction(
    protected ClusterBlockException checkRequestBlock(ClusterState state, FormatStatsRequest request, String[] concreteIndices) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    private final Writeable.Reader<T> reader;
                    }
            for (String index : concreteIndices) {
 * compatible open source license.
            }
        String[] nodeFilter = request.getNodeFilter();
    }
            // DFA replicas use segment replication from remote store and don't run an indexing
        );
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
            // `_shards.total` match the user's `index.number_of_shards` setting and prevents
import org.opensearch.plugin.stats.DataFormatShardStats;
        }).collect(Collectors.toList());
import java.util.Set;
                for (int sid : shardFilter) {
                return false;
        ClusterState clusterState
                return false;
import java.io.IOException;
    FormatStatsShardResult<T>> {
        int failedShards,
 * Abstract transport action that collects per-format stats using broadcast-by-node routing.
    FormatStatsResponse<T>,
/*
    @Override
        final Set<Integer> shardFilterSet = new HashSet<>();
import org.opensearch.threadpool.ThreadPool;
    }
    }
import org.opensearch.cluster.ClusterState;
        ActionFilters actionFilters,
            totalShards,
                        throw new IllegalArgumentException("node [" + nf + "] not found in cluster");
 * @param <T> concrete shard-stats type
    @Override
 *
 * this file be licensed under the Apache-2.0 license or a
    }
    protected ShardsIterator shards(ClusterState clusterState, FormatStatsRequest request, String[] concreteIndices) {
            // empty `{ primary: false }` noise in `level=shards` output.
    @Override
            transportService,
            shardFailures
        if (nodeFilter != null) {
        ClusterService clusterService,
        return new FormatStatsShardResult<>(in, reader);
            clusterService,
 * Each data-format plugin subclasses this to register its own action.
import org.opensearch.cluster.routing.ShardRouting;
        }
        final Set<String> resolvedNodeFilter = new HashSet<>();
        int totalShards,
        this.formatName = formatName;
    }
            }
            if (sr.primary() == false) {
            successfulShards,
        return new FormatStatsRequest(in);
                    if (sid < 0 || sid >= numShards) {
package org.opensearch.plugin.stats.transport;
@ExperimentalApi
        int[] shardFilter = request.getShardFilter();
    protected FormatStatsRequest readRequestFrom(StreamInput in) throws IOException {
    @SuppressWarnings("unchecked")
                            "shard [" + sid + "] is out of range for index [" + index + "] which has [" + numShards + "] shard(s)"
            }
            // engine, so they have no per-format tracker registered. Always restrict to primaries
    }
    protected FormatStatsShardResult<T> shardOperation(FormatStatsRequest request, ShardRouting shardRouting) {
            actionFilters,
                    if (clusterState.getNodes().get(nf) == null) {
            failedShards,
    ) {
import org.opensearch.core.common.io.stream.Writeable;
        String actionName,
 *
            actionName,
    FormatStatsRequest,
        return new FormatStatsShardResult<>(shardRouting, provider.shardStats(shardRouting.shardId()).orElse(null));
            for (String nf : nodeFilter) {
            return true;
        }
            indexNameExpressionResolver,
                    }
            for (int sid : shardFilter) {
            // — the broadcast then has exactly one copy per logical shard, which makes
        IndexNameExpressionResolver indexNameExpressionResolver
        String formatName,
                if ("_local".equals(nf)) {
        }
            if (shardFilterActive && !shardFilterSet.contains(sr.shardId().id())) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
}
        int successfulShards,
        List<ShardRouting> filtered = shards.stream().filter(sr -> {
        TransportService transportService,
 */
                        );
    @Override
        this.reader = reader;
        if (shardFilter != null && shardFilter.length > 0) {
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
/**
    @Override
    protected FormatStatsShardResult<T> readShardResult(StreamInput in) throws IOException {
                    resolvedNodeFilter.add(clusterState.getNodes().getLocalNodeId());
    }
import org.opensearch.core.common.io.stream.StreamInput;
        DataFormatStatsProvider<T> provider = (DataFormatStatsProvider<T>) DataFormatStatsProviderRegistry.INSTANCE.get(formatName);
import org.opensearch.cluster.routing.ShardsIterator;
        List<ShardRouting> shards = clusterState.routingTable().allShards(concreteIndices).getShardRoutings();
import org.opensearch.cluster.block.ClusterBlockException;
                shardFilterSet.add(sid);
 */
    }
                return false;
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 *
            request.formatName(),
            results,
        List<DefaultShardOperationFailedException> shardFailures,
                }
    private final String formatName;
import java.util.stream.Collectors;
            }
    @Override
import java.util.List;
            ThreadPool.Names.MANAGEMENT
            if (nodeFilterActive && !resolvedNodeFilter.contains(sr.currentNodeId())) {
 * The OpenSearch Contributors require contributions made to
        Writeable.Reader<T> reader,
                } else {
        List<FormatStatsShardResult<T>> results,
