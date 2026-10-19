        ClusterState clusterState
    }
        this.node = node;  
    TransportBroadcastByNodeAction.EmptyResult> {
        try {
            request.fields()
    @Override  
    protected EmptyResult shardOperation(ClearIndicesCacheRequest request, ShardRouting shardRouting) {
            clearActionLogger.warn("Node-wide force cache clear failed; marked keys will be cleaned at next scheduled cache cleanup", e);
        return new ClearIndicesCacheResponse(totalShards, successfulShards, failedShards, shardFailures);
            ClearIndicesCacheRequest::new,
    @Override
 */  
 */  
 * license agreements. See the NOTICE file distributed with
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);  
 * compatible open source license.
    @Override
    private final IndicesService indicesService;  
                Predicate<Path> pathStartsWithShardPathPredicate = path -> path.startsWith(shardPath.getDataPath());
        return new ClearIndicesCacheRequest(in);  
            ThreadPool.Names.MANAGEMENT,
    protected ClusterBlockException checkRequestBlock(ClusterState state, ClearIndicesCacheRequest request, String[] concreteIndices) {
        return EmptyResult.INSTANCE;  
 * specific language governing permissions and limitations
import java.nio.file.Path;
        int successfulShards,
        indicesService.clearIndexShardCache(
public class TransportClearIndicesCacheAction extends TransportBroadcastByNodeAction<
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
            ShardPath shardPath = ShardPath.loadFileCachePath(node.getNodeEnvironment(), shardRouting.shardId());  
        super(
        List<DefaultShardOperationFailedException> shardFailures,
        this.blockCacheRegistry = blockCacheRegistry;
 * KIND, either express or implied.  See the License for the
 * Indices clear cache action.  
    }
import org.opensearch.node.Node;
    ClearIndicesCacheResponse,  
import org.opensearch.cluster.service.ClusterService;  
        @Nullable BlockCacheRegistry blockCacheRegistry,  
    ClearIndicesCacheRequest,
        Node node,
    /**  
            indicesService.forceClearNodewideCaches();  
 *
        if (request.fileCache()) {
import org.opensearch.action.support.ActionFilters;  
        } catch (Exception e) {
            transportService,
            ClearIndicesCacheAction.NAME,
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
     */
    public TransportClearIndicesCacheAction(
import org.opensearch.index.shard.ShardPath;
    @Override  
        }  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.function.Predicate;  
            indexNameExpressionResolver,  
     * The refresh request works against *all* shards.
 * software distributed under the License is distributed on an
/**
/*  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
import org.opensearch.cluster.routing.ShardRouting;
    protected ClearIndicesCacheResponse newResponse(
        int failedShards,
            if (blockCacheRegistry != null) {
import java.io.IOException;  
    }
}
    protected EmptyResult readShardResult(StreamInput in) throws IOException {
                node.fileCache().prune(pathStartsWithShardPathPredicate);  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
 * GitHub history for details.
                String prefix = shardPath.getDataPath().toString();  
        ClearIndicesCacheRequest request,
    @Override  
import org.opensearch.indices.IndicesService;  
    }
        );
import org.opensearch.threadpool.ThreadPool;  
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
        );
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 */  
import org.opensearch.transport.TransportService;
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
        ActionFilters actionFilters,
package org.opensearch.action.admin.indices.cache.clear;
    }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            if (node.fileCache() != null) {
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
import org.opensearch.common.inject.Inject;
 */
        List<EmptyResult> responses,  
import org.opensearch.plugins.BlockCacheRegistry;
        ClusterService clusterService,
            request.queryCache(),
            actionFilters,
 *
 * The OpenSearch Contributors require contributions made to  
        int totalShards,  
            shardRouting.shardId(),  
    @Override
            }
    private final Logger clearActionLogger = LogManager.getLogger(getClass());
 *  
    }
import org.opensearch.cluster.ClusterState;  
        return clusterState.routingTable().allShards(concreteIndices);
    private final BlockCacheRegistry blockCacheRegistry;  
 * Unless required by applicable law or agreed to in writing,
        TransportService transportService,  
import org.apache.logging.log4j.LogManager;
    protected ShardsIterator shards(ClusterState clusterState, ClearIndicesCacheRequest request, String[] concreteIndices) {
            false  
        IndexNameExpressionResolver indexNameExpressionResolver
    protected void nodeOperation(List<EmptyResult> results, List<BroadcastShardOperationFailedException> accumulatedExceptions) {
    ) {  
            request.requestCache(),  
    }
    ) {  
import org.opensearch.cluster.block.ClusterBlockException;
        this.indicesService = indicesService;
        }  
        return EmptyResult.readEmptyResultFrom(in);  
 * under the License.  
import org.apache.logging.log4j.Logger;
 * not use this file except in compliance with the License.
            request.fieldDataCache(),
    @Override
    protected ClearIndicesCacheRequest readRequestFrom(StreamInput in) throws IOException {
    protected ClusterBlockException checkGlobalBlock(ClusterState state, ClearIndicesCacheRequest request) {  
 * ownership. Elasticsearch licenses this file to you under  
                blockCacheRegistry.all().forEach(cache -> cache.evictPrefix(prefix));
 *
/*  
import org.opensearch.cluster.block.ClusterBlockLevel;
    }
import org.opensearch.cluster.routing.ShardsIterator;
import org.opensearch.common.Nullable;
            clusterService,  
            }
 * Modifications Copyright OpenSearch Contributors. See
        IndicesService indicesService,
 * this work for additional information regarding copyright
    @Inject  
/*
    private final Node node;
