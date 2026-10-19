        IndicesService indicesService,
    @Override  
import org.opensearch.common.inject.Inject;
/*  
 * @opensearch.internal  
    }
public class TransportRecoveryAction extends TransportBroadcastByNodeAction<RecoveryRequest, RecoveryResponse, RecoveryState> {
import java.io.IOException;
    }  
    ) {
import org.opensearch.cluster.ClusterState;  
            transportService,
 */  
    }  
    public TransportRecoveryAction(
            } else {  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
            if (recoveryState == null) {
            }
    @Override
        return new RecoveryRequest(in);  
                shardResponses.put(indexName, new ArrayList<>());  
import org.opensearch.threadpool.ThreadPool;
    @Override
import org.opensearch.cluster.service.ClusterService;  
 * Transport action for shard recovery operation. This transport action does not actually  
}  
        );
        RecoveryRequest request,  
 * Modifications Copyright OpenSearch Contributors. See
            indexNameExpressionResolver,
 * specific language governing permissions and limitations
        ActionFilters actionFilters,
                continue;
            RecoveryAction.NAME,  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
    ) {
        for (RecoveryState recoveryState : responses) {  
import org.opensearch.cluster.routing.ShardRouting;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());
        ClusterState clusterState  
import org.opensearch.cluster.routing.ShardsIterator;
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
        int totalShards,
    }
                shardResponses.get(indexName).add(recoveryState);
            RecoveryRequest::new,
            }  
        TransportService transportService,  
 */
import org.opensearch.index.IndexService;
        Map<String, List<RecoveryState>> shardResponses = new HashMap<>();
    @Override  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
            actionFilters,  
        List<RecoveryState> responses,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
    protected RecoveryResponse newResponse(
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
    }
import java.util.ArrayList;  
import org.opensearch.indices.IndicesService;  
            if (!shardResponses.containsKey(indexName)) {
 * You may obtain a copy of the License at  
    protected ClusterBlockException checkGlobalBlock(ClusterState state, RecoveryRequest request) {
    private final IndicesService indicesService;
 * under the License.  
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.block.ClusterBlockException;
        List<DefaultShardOperationFailedException> shardFailures,
/*
        IndexNameExpressionResolver indexNameExpressionResolver  
    }
    protected ClusterBlockException checkRequestBlock(ClusterState state, RecoveryRequest request, String[] concreteIndices) {  
 * this work for additional information regarding copyright
 */  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
/**
        IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());  
    protected ShardsIterator shards(ClusterState state, RecoveryRequest request, String[] concreteIndices) {
import java.util.List;
        return new RecoveryResponse(totalShards, successfulShards, failedShards, shardResponses, shardFailures);
import org.opensearch.cluster.block.ClusterBlockLevel;
 * perform shard recovery, it only reports on recoveries (both active and complete).
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        int failedShards,  
            if (request.activeOnly()) {
            ThreadPool.Names.MANAGEMENT  
        ClusterService clusterService,
                    shardResponses.get(indexName).add(recoveryState);
    protected RecoveryRequest readRequestFrom(StreamInput in) throws IOException {
                if (recoveryState.getStage() != RecoveryState.Stage.DONE) {  
/*  
    protected RecoveryState shardOperation(RecoveryRequest request, ShardRouting shardRouting) {
        }  
package org.opensearch.action.admin.indices.recovery;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    @Override
    @Override
 * software distributed under the License is distributed on an
    }
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.shard.IndexShard;
            }
 *
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        super(
    @Inject  
 * not use this file except in compliance with the License.
            String indexName = recoveryState.getShardId().getIndexName();
import java.util.Map;  
        return new RecoveryState(in);
        return state.routingTable().allShardsIncludingRelocationTargets(concreteIndices);  
        this.indicesService = indicesService;
import org.opensearch.indices.recovery.RecoveryState;
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
            clusterService,
import org.opensearch.transport.TransportService;  
 *
 *
 *  
    protected RecoveryState readShardResult(StreamInput in) throws IOException {  
        int successfulShards,
        return indexShard.recoveryState();
