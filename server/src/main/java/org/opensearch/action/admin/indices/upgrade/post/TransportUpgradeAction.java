            upgradeSettingsRequest,
public class TransportUpgradeAction extends TransportBroadcastByNodeAction<UpgradeRequest, UpgradeResponse, ShardUpgradeResult> {
        int totalShards,
        Map<String, Tuple<Version, String>> updatedVersions = new HashMap<>();
            } else {
            "Cannot upgrade indices because the following indices are missing primary shards " + indicesWithMissingPrimaries
import org.opensearch.common.inject.Inject;
import org.opensearch.core.common.io.stream.StreamInput;
                logger.warn(
    protected ShardUpgradeResult shardOperation(UpgradeRequest request, ShardRouting shardRouting) throws IOException {
            if (indexRoutingTable.allPrimaryShardsActive() == false) {
    public TransportUpgradeAction(
        for (ShardUpgradeResult result : shardUpgradeResults) {
                    luceneVersion = result.oldestLuceneSegment();
            return iterator;
                successfulPrimaryShards.put(index, count == null ? 1 : count + 1);
    }
        ClusterState clusterState
     * Finds all indices that have not all primaries available
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
    }
            if (upgradeResponse.versions().isEmpty()) {
    @Override
import org.opensearch.Version;
            indexNameExpressionResolver,
                if (result.upgradeVersion().after(versionTuple.v1())) {
        this.client = client;
import org.opensearch.index.shard.IndexShard;
            if (versionTuple == null) {
import java.util.Set;
            clusterService,
import java.util.HashMap;
        // We are using the current version of Elasticsearch as upgrade version since we update mapping to match the current version
                versions.put(index, new Tuple<>(result.upgradeVersion(), result.oldestLuceneSegment()));
            }
 * Unless required by applicable law or agreed to in writing,
    @Override
        }
        Set<String> indices = new HashSet<>();
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        }
 *
        client.executeLocally(
            Integer primaryCount = successfulPrimaryShards.get(index);
            } else {
        IndicesService indicesService,
import org.opensearch.cluster.service.ClusterService;
package org.opensearch.action.admin.indices.upgrade.post;
import org.opensearch.cluster.routing.RoutingTable;
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, concreteIndices);
    protected ShardsIterator shards(ClusterState clusterState, UpgradeRequest request, String[] concreteIndices) {
        }, listener::onFailure));
            )
    }
    protected ShardUpgradeResult readShardResult(StreamInput in) throws IOException {
                    expectedPrimaryCount,
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                indices.add(index);
        return indices;
import org.opensearch.cluster.routing.ShardRouting;
                // Since we rewrite the mapping during upgrade the metadata is always rewritten by the latest version
    ) {
     */
                    version = result.upgradeVersion();
        );
    protected ClusterBlockException checkGlobalBlock(ClusterState state, UpgradeRequest request) {
 *
    private Set<String> indicesWithMissingPrimaries(ClusterState clusterState, String[] concreteIndices) {
        TransportService transportService,
 */
            String index = result.getShardId().getIndex().getName();
    }
import org.opensearch.core.action.ActionListener;
        int failedShards,
import org.opensearch.cluster.routing.IndexRoutingTable;
        super.doExecute(task, request, ActionListener.wrap(upgradeResponse -> {
                if (result.oldestLuceneSegment().onOrAfter(versionTuple.v2()) == false) {
        UpgradeSettingsRequest upgradeSettingsRequest = new UpgradeSettingsRequest(upgradeResponse.versions());
            actionFilters,
    ) {
import org.opensearch.cluster.routing.ShardsIterator;
 * compatible open source license.
import org.opensearch.indices.IndicesService;
            }
            IndexRoutingTable indexRoutingTable = routingTable.index(index);
        NodeClient client
            int expectedPrimaryCount = metadata.index(index).getNumberOfShards();
        );
            if (result.primary()) {
        super(
        throw new PrimaryMissingActionException(
                // oldest version that we need to support
                updateSettings(upgradeResponse, listener);
                org.apache.lucene.util.Version luceneVersion = versionTuple.v2();
 */
 * The OpenSearch Contributors require contributions made to
}
    protected UpgradeRequest readRequestFrom(StreamInput in) throws IOException {
                versions.put(index, new Tuple<>(version, luceneVersion));
        List<DefaultShardOperationFailedException> shardFailures,
import org.opensearch.cluster.block.ClusterBlockException;
                    index,
                listener,
                }
 * this work for additional information regarding copyright
    @Override
            ActionListener.delegateFailure(
    }
                );
                Version version = versionTuple.v1();
    }
            transportService,
 *
/*
        }
        ActionFilters actionFilters,
import java.util.Map;
            String index = versionEntry.getKey();
    }
 * Upgrade index/indices action.
    private void updateSettings(final UpgradeResponse upgradeResponse, final ActionListener<UpgradeResponse> listener) {
        Metadata metadata = clusterState.metadata();
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    @Override
        return new UpgradeRequest(in);
    @Override
        }
 *
import org.opensearch.tasks.Task;
        org.apache.lucene.util.Version oldestLuceneSegment = indexShard.upgrade(request);
        RoutingTable routingTable = clusterState.routingTable();
    }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.PrimaryMissingActionException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
                // For the metadata we are interested in the _latest_ Elasticsearch version that was processing the metadata
 * KIND, either express or implied.  See the License for the
            ThreadPool.Names.FORCE_MERGE
        int successfulShards,
import org.opensearch.common.collect.Tuple;
import org.opensearch.action.support.ActionFilters;
        );
import org.opensearch.transport.client.node.NodeClient;
        Map<String, Integer> successfulPrimaryShards = new HashMap<>();
            }
        Set<String> indicesWithMissingPrimaries = indicesWithMissingPrimaries(clusterState, concreteIndices);
                    primaryCount == null ? 0 : primaryCount
    @Override
        this.indicesService = indicesService;
import java.io.IOException;
        for (Map.Entry<String, Tuple<Version, org.apache.lucene.util.Version>> versionEntry : versions.entrySet()) {
    }
     * The upgrade request works against *all* shards.
    protected void doExecute(Task task, UpgradeRequest request, final ActionListener<UpgradeResponse> listener) {
                        + "expected[{}], received[{}]",
                listener.onResponse(upgradeResponse);
                }
                updatedVersions.put(index, new Tuple<>(versionEntry.getValue().v1(), versionEntry.getValue().v2().toString()));
    }
                (delegatedListener, updateSettingsResponse) -> delegatedListener.onResponse(upgradeResponse)
            UpgradeAction.NAME,
            Tuple<Version, org.apache.lucene.util.Version> versionTuple = versions.get(index);
                    "Not updating settings for the index [{}] because upgraded of some primary shards failed - "
    @Inject
import org.opensearch.cluster.block.ClusterBlockLevel;
        List<ShardUpgradeResult> shardUpgradeResults,
    }
 */
import org.opensearch.transport.TransportService;
        return new UpgradeResponse(updatedVersions, totalShards, successfulShards, failedShards, shardFailures);
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
 * not use this file except in compliance with the License.
        return new ShardUpgradeResult(shardRouting.shardId(), indexShard.routingEntry().primary(), Version.CURRENT, oldestLuceneSegment);
 *     http://www.apache.org/licenses/LICENSE-2.0
            UpgradeSettingsAction.INSTANCE,
            } else {
    protected ClusterBlockException checkRequestBlock(ClusterState state, UpgradeRequest request, String[] concreteIndices) {
 * GitHub history for details.
            if (primaryCount == metadata.index(index).getNumberOfShards()) {
 * this file be licensed under the Apache-2.0 license or a
        // If some primary shards are not available the request should fail.
 * ownership. Elasticsearch licenses this file to you under
                // For the lucene version we are interested in the _oldest_ lucene version since it determines the
    /**
        return new ShardUpgradeResult(in);
    @Override
import org.opensearch.cluster.ClusterState;
/**
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.metadata.Metadata;
            }
/*
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
 * @opensearch.internal
            successfulShards++;
        Map<String, Tuple<Version, org.apache.lucene.util.Version>> versions = new HashMap<>();
    private final IndicesService indicesService;
            UpgradeRequest::new,
 * under the License.
        ClusterService clusterService,
        UpgradeRequest request,
        if (indicesWithMissingPrimaries.isEmpty()) {
/*
    /**
        ShardsIterator iterator = clusterState.routingTable().allShards(concreteIndices);
        for (String index : concreteIndices) {
     */
    protected UpgradeResponse newResponse(
import java.util.HashSet;
                // We already have versions for this index - let's see if we need to update them based on the current shard
        IndexNameExpressionResolver indexNameExpressionResolver,
        IndexShard indexShard = indicesService.indexServiceSafe(shardRouting.shardId().getIndex()).getShard(shardRouting.shardId().id());
import java.util.List;
                Integer count = successfulPrimaryShards.get(index);
            }
    @Override
    private final NodeClient client;
