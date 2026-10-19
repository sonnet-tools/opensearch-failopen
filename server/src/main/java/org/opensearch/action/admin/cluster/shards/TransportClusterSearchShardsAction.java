 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
import org.opensearch.core.index.shard.ShardId;
            .indicesBlockedException(ClusterBlockLevel.METADATA_READ, resolveIndices(state, request).namesOfConcreteIndicesAsArray());
        }
 *
            int currentShard = 0;  
package org.opensearch.action.admin.cluster.shards;
        GroupShardsIterator<ShardIterator> groupShardsIterator = clusterService.operationRouting()
            ClusterSearchShardsAction.NAME,
            ClusterSearchShardsRequest::new,
        Map<String, Set<String>> routingMap = indexNameExpressionResolver.resolveSearchRouting(state, request.routing(), request.indices());  
 * not use this file except in compliance with the License.
        ClusterService clusterService,
        // all in memory work here...
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ThreadPool threadPool,  
import org.opensearch.action.support.TransportIndicesResolvingAction;
    ) {  
        final ClusterSearchShardsRequest request,  
 *
        int currentNode = 0;  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;  
                index,
            ShardRouting[] shardRoutings = new ShardRouting[shardIt.size()];
import java.util.Set;  
    protected void clusterManagerOperation(
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
    }
 * compatible open source license.
                clusterState,  
        return ThreadPool.Names.SAME;
        ShardRouting shard;  
import org.opensearch.threadpool.ThreadPool;
    ClusterSearchShardsResponse> implements TransportIndicesResolvingAction<ClusterSearchShardsRequest> {  
        this.indicesService = indicesService;
    public ResolvedIndices resolveIndices(ClusterSearchShardsRequest request) {
import org.opensearch.common.inject.Inject;
 * KIND, either express or implied.  See the License for the
            clusterService,
import org.opensearch.cluster.routing.ShardIterator;
}  
            final String[] aliases = indexNameExpressionResolver.indexAliases(
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        return state.blocks()
 * this work for additional information regarding copyright
    @Override
            true  
import org.opensearch.cluster.ClusterState;
    @Inject
        int currentGroup = 0;
import org.opensearch.cluster.routing.GroupShardsIterator;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    private final IndicesService indicesService;
    @Override
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request));  
 *
import org.opensearch.cluster.node.DiscoveryNode;  
 * You may obtain a copy of the License at  
            threadPool,
 * Licensed to Elasticsearch under one or more contributor  
    }
import java.util.HashSet;
                indicesAndAliases
import java.io.IOException;
public class TransportClusterSearchShardsAction extends TransportClusterManagerNodeReadAction<
            );
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.ShardRouting;  
                shardRoutings[currentShard++] = shard;  
        }  
            ShardId shardId = shardIt.shardId();
    @Override
import org.opensearch.cluster.block.ClusterBlockLevel;  
 * specific language governing permissions and limitations
            shardIt.reset();
        listener.onResponse(new ClusterSearchShardsResponse(groupResponses, nodes, indicesAndFilters));
import org.opensearch.cluster.block.ClusterBlockException;
 */  
                true,  
            .searchShards(clusterState, concreteIndices, routingMap, request.preference(), null, null, request.slice());
        ClusterState clusterState = clusterService.state();
 * @opensearch.internal
    }
        DiscoveryNode[] nodes = new DiscoveryNode[nodeIds.size()];
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.service.ClusterService;
 * GitHub history for details.
            groupResponses[currentGroup++] = new ClusterSearchShardsGroup(shardId, shardRoutings);  
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.indices.IndicesService;  
 * Modifications Copyright OpenSearch Contributors. See
    public TransportClusterSearchShardsAction(
        String[] concreteIndices = resolveIndices(clusterState, request).namesOfConcreteIndicesAsArray();
        IndicesService indicesService,
            indicesAndFilters.put(index, new AliasFilter(aliasFilter.getQueryBuilder(), aliases));  
    ClusterSearchShardsRequest,
 */
        IndexNameExpressionResolver indexNameExpressionResolver
 * license agreements. See the NOTICE file distributed with
            final AliasFilter aliasFilter = indicesService.buildAliasFilter(clusterState, index, indicesAndAliases);
        final ActionListener<ClusterSearchShardsResponse> listener
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        Set<String> nodeIds = new HashSet<>();  
 */  
        ClusterSearchShardsGroup[] groupResponses = new ClusterSearchShardsGroup[groupShardsIterator.size()];
import org.opensearch.transport.TransportService;  
/*
    @Override
    protected String executor() {  
        ActionFilters actionFilters,
 * Transport action for searching shards  
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState clusterState, ClusterSearchShardsRequest request) {  
/*  
            actionFilters,  
        for (ShardIterator shardIt : groupShardsIterator) {  
        }
/*  
            while ((shard = shardIt.nextOrNull()) != null) {
    }  
        final ClusterState state,
        Set<String> indicesAndAliases = indexNameExpressionResolver.resolveExpressions(clusterState, request.indices());
import java.util.HashMap;  
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Map;
    protected ClusterBlockException checkBlock(ClusterSearchShardsRequest request, ClusterState state) {  
    ) {  
        Map<String, AliasFilter> indicesAndFilters = new HashMap<>();
        for (String nodeId : nodeIds) {
        TransportService transportService,  
        super(
import org.opensearch.search.internal.AliasFilter;
        return this.indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
    }
        for (String index : concreteIndices) {  
import org.opensearch.action.support.ActionFilters;
        return new ClusterSearchShardsResponse(in);
/**
 */  
    protected ClusterSearchShardsResponse read(StreamInput in) throws IOException {  
import org.opensearch.core.action.ActionListener;  
                nodeIds.add(shard.currentNodeId());
    }  
            nodes[currentNode++] = clusterState.getNodes().get(nodeId);
                aliasMetadata -> true,
        );
 * under the License.  
            transportService,  
            }
            indexNameExpressionResolver,
