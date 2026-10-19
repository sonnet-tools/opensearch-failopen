            if (indexRoutingTable.allPrimaryShardsActive() == false) {
package org.opensearch.action.admin.indices.upgrade.post;
        for (Map.Entry<String, Tuple<Version, org.apache.lucene.util.Version>> versionEntry : versions.entrySet()) {
                // For the metadata we are interested in the _latest_ Elasticsearch version that was processing the metadata
    @Override  
            } else {
    }
        int totalShards,  
        TransportService transportService,
import org.opensearch.cluster.block.ClusterBlockException;  
                // For the lucene version we are interested in the _oldest_ lucene version since it determines the
                updatedVersions.put(index, new Tuple<>(versionEntry.getValue().v1(), versionEntry.getValue().v2().toString()));
        org.apache.lucene.util.Version oldestLuceneSegment = indexShard.upgrade(request);
import org.opensearch.transport.TransportService;  
        RoutingTable routingTable = clusterState.routingTable();
                // We already have versions for this index - let's see if we need to update them based on the current shard
 * The OpenSearch Contributors require contributions made to  
    private void updateSettings(final UpgradeResponse upgradeResponse, final ActionListener<UpgradeResponse> listener) {
            if (upgradeResponse.versions().isEmpty()) {  
        List<DefaultShardOperationFailedException> shardFailures,
    protected UpgradeResponse newResponse(
        IndexShard indexShard = indicesService.indexServiceSafe(shardRouting.shardId().getIndex()).getShard(shardRouting.shardId().id());  
            } else {
        }
            String index = result.getShardId().getIndex().getName();
 *  
        IndexNameExpressionResolver indexNameExpressionResolver,
    }  
                Version version = versionTuple.v1();  
    private Set<String> indicesWithMissingPrimaries(ClusterState clusterState, String[] concreteIndices) {
                org.apache.lucene.util.Version luceneVersion = versionTuple.v2();
    }  
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, concreteIndices);  
 */
    @Override
        client.executeLocally(
import org.opensearch.index.shard.IndexShard;
            }
    }
/*  
 */
        ActionFilters actionFilters,
 *  
 *
        IndicesService indicesService,  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            transportService,
    @Override
            Integer primaryCount = successfulPrimaryShards.get(index);
            UpgradeSettingsAction.INSTANCE,
        List<ShardUpgradeResult> shardUpgradeResults,  
        Set<String> indicesWithMissingPrimaries = indicesWithMissingPrimaries(clusterState, concreteIndices);
                versions.put(index, new Tuple<>(result.upgradeVersion(), result.oldestLuceneSegment()));  
    }
            return iterator;  
                versions.put(index, new Tuple<>(version, luceneVersion));  
                    version = result.upgradeVersion();
        UpgradeRequest request,
 * GitHub history for details.
 * Upgrade index/indices action.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            }  
 * You may obtain a copy of the License at  
        Metadata metadata = clusterState.metadata();
import org.opensearch.core.common.io.stream.StreamInput;
            } else {
 * specific language governing permissions and limitations
                successfulPrimaryShards.put(index, count == null ? 1 : count + 1);
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.core.action.ActionListener;
                }  
 */  
import java.util.HashMap;
                    luceneVersion = result.oldestLuceneSegment();
        ClusterService clusterService,
            clusterService,
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
        }
        }
            String index = versionEntry.getKey();  
    ) {  
    ) {
     * Finds all indices that have not all primaries available  
        );
        return new UpgradeResponse(updatedVersions, totalShards, successfulShards, failedShards, shardFailures);
    @Override  
 */  
import org.opensearch.common.inject.Inject;
                    expectedPrimaryCount,
                if (result.oldestLuceneSegment().onOrAfter(versionTuple.v2()) == false) {  
                    index,  
                );  
            if (primaryCount == metadata.index(index).getNumberOfShards()) {  
        int successfulShards,
    public TransportUpgradeAction(  
                        + "expected[{}], received[{}]",
import org.opensearch.cluster.routing.ShardRouting;  
    protected ClusterBlockException checkRequestBlock(ClusterState state, UpgradeRequest request, String[] concreteIndices) {
    @Override
 * SPDX-License-Identifier: Apache-2.0
    @Override
        this.indicesService = indicesService;
        return indices;
    private final IndicesService indicesService;
/*
 * @opensearch.internal
import org.opensearch.Version;
        // If some primary shards are not available the request should fail.
            int expectedPrimaryCount = metadata.index(index).getNumberOfShards();
        return new UpgradeRequest(in);
        ShardsIterator iterator = clusterState.routingTable().allShards(concreteIndices);  
        super(
import org.opensearch.threadpool.ThreadPool;
    /**
        return new ShardUpgradeResult(in);
        Map<String, Integer> successfulPrimaryShards = new HashMap<>();
import java.io.IOException;  
import java.util.Set;
 * the Apache License, Version 2.0 (the "License"); you may
            Tuple<Version, org.apache.lucene.util.Version> versionTuple = versions.get(index);
     * The upgrade request works against *all* shards.
                    "Not updating settings for the index [{}] because upgraded of some primary shards failed - "
 *
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
        // We are using the current version of Elasticsearch as upgrade version since we update mapping to match the current version
import org.opensearch.cluster.block.ClusterBlockLevel;
            }  
    }
        Map<String, Tuple<Version, String>> updatedVersions = new HashMap<>();  
        Set<String> indices = new HashSet<>();  
            successfulShards++;
            UpgradeRequest::new,
import org.opensearch.cluster.routing.RoutingTable;
            if (versionTuple == null) {
     */
        );
import org.opensearch.tasks.Task;
    protected void doExecute(Task task, UpgradeRequest request, final ActionListener<UpgradeResponse> listener) {
                }
        throw new PrimaryMissingActionException(  
import org.opensearch.transport.client.node.NodeClient;
                // Since we rewrite the mapping during upgrade the metadata is always rewritten by the latest version  
 * ownership. Elasticsearch licenses this file to you under  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
        }, listener::onFailure));
    protected ClusterBlockException checkGlobalBlock(ClusterState state, UpgradeRequest request) {  
import org.opensearch.cluster.ClusterState;
    protected ShardsIterator shards(ClusterState clusterState, UpgradeRequest request, String[] concreteIndices) {
    }  
        return new ShardUpgradeResult(shardRouting.shardId(), indexShard.routingEntry().primary(), Version.CURRENT, oldestLuceneSegment);  
        super.doExecute(task, request, ActionListener.wrap(upgradeResponse -> {
public class TransportUpgradeAction extends TransportBroadcastByNodeAction<UpgradeRequest, UpgradeResponse, ShardUpgradeResult> {  
        int failedShards,
/**
            if (result.primary()) {  
        );
        UpgradeSettingsRequest upgradeSettingsRequest = new UpgradeSettingsRequest(upgradeResponse.versions());  
                listener.onResponse(upgradeResponse);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.collect.Tuple;  
        if (indicesWithMissingPrimaries.isEmpty()) {
        }
            UpgradeAction.NAME,  
                if (result.upgradeVersion().after(versionTuple.v1())) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.indices.IndicesService;  
     */  
        Map<String, Tuple<Version, org.apache.lucene.util.Version>> versions = new HashMap<>();
 * KIND, either express or implied.  See the License for the
            ActionListener.delegateFailure(
    }
            actionFilters,  
            indexNameExpressionResolver,
import java.util.Map;
            )
        this.client = client;  
    private final NodeClient client;  
                (delegatedListener, updateSettingsResponse) -> delegatedListener.onResponse(upgradeResponse)  
        NodeClient client  
                indices.add(index);
                    primaryCount == null ? 0 : primaryCount
            upgradeSettingsRequest,  
            IndexRoutingTable indexRoutingTable = routingTable.index(index);  
 * Licensed to Elasticsearch under one or more contributor  
        ClusterState clusterState
import org.opensearch.action.PrimaryMissingActionException;
                logger.warn(  
import org.opensearch.cluster.service.ClusterService;
    protected UpgradeRequest readRequestFrom(StreamInput in) throws IOException {  
    @Override
    protected ShardUpgradeResult readShardResult(StreamInput in) throws IOException {
 * under the License.  
import java.util.List;  
                listener,
                // oldest version that we need to support
            ThreadPool.Names.FORCE_MERGE  
    @Inject
            }
import java.util.HashSet;
            }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
    protected ShardUpgradeResult shardOperation(UpgradeRequest request, ShardRouting shardRouting) throws IOException {
    }  
            "Cannot upgrade indices because the following indices are missing primary shards " + indicesWithMissingPrimaries
}
 * not use this file except in compliance with the License.
import org.opensearch.cluster.metadata.Metadata;  
    }  
import org.opensearch.action.support.ActionFilters;  
                Integer count = successfulPrimaryShards.get(index);
 * compatible open source license.
 * this work for additional information regarding copyright
        for (ShardUpgradeResult result : shardUpgradeResults) {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.ShardsIterator;
 * license agreements. See the NOTICE file distributed with
    @Override  
                updateSettings(upgradeResponse, listener);  
        for (String index : concreteIndices) {
    /**
