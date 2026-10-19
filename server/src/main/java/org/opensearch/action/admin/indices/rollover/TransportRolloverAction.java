                rolloverRequest.getNewIndexName(),  
            rolloverRequest.getNewIndexName(),
        this.rolloverService = rolloverService;
        });  
    }  
 * SPDX-License-Identifier: Apache-2.0
 *
                                MetadataRolloverService.RolloverResult rolloverResult = rolloverService.rolloverClusterState(
        IndicesStatsRequest statsRequest = new IndicesStatsRequest().indices(rolloverRequest.getRolloverTarget())
            .build();  
                            }
/**
/*
                            @Override
            final DocsStats docsStats = Optional.ofNullable(statsResponse)
    }
                    .values()
    protected String executor() {  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        ActionFilters actionFilters,
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.cluster.service.ClusterService;  
                                        rolloverRequest.getRolloverTarget()
            true,
    }  
        TransportIndicesResolvingAction<RolloverRequest> {
                            @Override
                    .stream()
    implements
    @Override
            .collect(Collectors.toMap(result -> result.condition.toString(), result -> result.matched));  
 *  
    }
 */  
            return null;
    ) {  
 * under the License.  
                                }
                                return rolloverResult.clusterState;
                            public ClusterState execute(ClusterState currentState) throws Exception {
            return conditions.stream().collect(Collectors.toMap(Condition::toString, cond -> false));  
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.action.admin.indices.rollover;
                                                conditionResults,
                                    throw new OpenSearchException(  
                                        rolloverRequest.getCreateIndexRequest().waitForActiveShards(),
                .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of(preResult.rolloverIndexName));
                rolloverRequest.getCreateIndexRequest(),
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        final ClusterState state,  
            RolloverRequest::new,
 *  
        if (indexAbstraction == null) {
            return ResolvedIndices.of(rolloverRequest.getRolloverTarget())
                                }
import org.opensearch.cluster.metadata.IndexAbstraction;  
        final long indexSize = docsStats == null ? 0 : docsStats.getTotalSizeInBytes();
                            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            indexNameExpressionResolver
                true
                    return;
                    listener.onResponse(
                                        listener::onFailure  
            true
                } else {  
import org.opensearch.cluster.metadata.ResolvedIndices;
import static org.opensearch.cluster.service.ClusterManagerTask.ROLLOVER_INDEX;
 * software distributed under the License is distributed on an
import org.opensearch.action.support.ActionFilters;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.ClusterStateUpdateTask;  
                listener.onFailure(e);
                .map(stats -> stats.getIndex(metadata.getIndex().getName()))  
        MetadataRolloverService.RolloverResult preResult = rolloverService.rolloverClusterState(
                                if (newState.equals(oldState) == false) {
        @Nullable final IndicesStatsResponse statsResponse  
import org.opensearch.transport.client.Client;
    }
                .orElse(null);
 */  
        this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);  
    protected RolloverResponse read(StreamInput in) throws IOException {  
 * You may obtain a copy of the License at  
            // Instead, we return a basic result which still allows privilege evaluation.
    ) {
            state,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                    activeShardsObserver.waitForActiveShards(  
            // These are not propagated to the caller because it should be still
 * Licensed to Elasticsearch under one or more contributor  
                                    false,
    @Override  
            // Exceptions are mostly occurring due to validation errors (e.g. non-existing indices).
                            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
                if (rolloverRequest.isDryRun()) {  
    @Override
                                    rolloverRequest.getNewIndexName(),
import java.util.Map;
                    .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of(rolloverRequest.getNewIndexName()));
            .map(condition -> condition.evaluate(stats))
                if (conditionResults.size() == 0 || metConditions.size() > 0) {
                                    false  
        return conditions.stream()
                                                isShardsAcknowledged  
            threadPool,
        }
        }
        this.client = client;
        );  
import org.opensearch.action.support.TransportIndicesResolvingAction;  
    @Override
                final Map<String, Boolean> conditionResults = evaluateConditions(  
import org.opensearch.action.admin.indices.create.CreateIndexAction;
            public void onFailure(Exception e) {  
                    clusterService.submitStateUpdateTask(  
                                        new String[] { rolloverIndexName },
            // the clusterManagerOperation() that should report these failures.  
        @Nullable final DocsStats docsStats,
    @Override
        String sourceIndexName = preResult.sourceIndexName;
        }  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
import java.util.List;  
                                if (rolloverResult.sourceIndexName.equals(sourceIndexName) == false) {
    private final ClusterManagerTaskThrottler.ThrottlingKey rolloverIndexTaskKey;
public class TransportRolloverAction extends TransportClusterManagerNodeAction<RolloverRequest, RolloverResponse>  
    static Map<String, Boolean> evaluateConditions(  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.TransportService;  
 * GitHub history for details.
                                                rolloverIndexName,
import org.opensearch.cluster.metadata.Metadata;  
        client.execute(IndicesStatsAction.INSTANCE, statsRequest, new ActionListener<IndicesStatsResponse>() {  
    ) throws Exception {
                            }
    }
    private final ActiveShardsObserver activeShardsObserver;
}
                    listener.onResponse(
import org.opensearch.core.action.ActionListener;  
    @Override
            actionFilters,  
import java.util.Collections;
import org.opensearch.action.support.ActiveShardsObserver;
        IndexAbstraction indexAbstraction = state.metadata().getIndicesLookup().get(request.getRolloverTarget());  
            return conditions.stream().collect(Collectors.toMap(Condition::toString, cond -> false));
/*  
        throw new UnsupportedOperationException("The task parameter is required");
 * specific language governing permissions and limitations
                        "rollover_index source [" + sourceIndexName + "] to target [" + rolloverIndexName + "]",
            @Override
import org.opensearch.cluster.ClusterState;
                            public void onFailure(String source, Exception e) {
 * license agreements. See the NOTICE file distributed with
        statsRequest.setParentTask(clusterService.localNode().getId(), task.getId());
                            @Override  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                                );
            @Override
        try {
                    .collect(Collectors.toList());
import org.opensearch.common.inject.Inject;
        String rolloverIndexName = preResult.rolloverIndexName;  
                        new ClusterStateUpdateTask() {
import org.opensearch.action.support.IndicesOptions;
                        new RolloverResponse(sourceIndexName, rolloverIndexName, conditionResults, false, false, false, false)  
        Metadata metadata = state.metadata();
                                            new RolloverResponse(
            }  
                                                false,  
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;  
                            @Override  
                                                true,
import java.util.stream.Collectors;  
 * not use this file except in compliance with the License.
        MetadataRolloverService rolloverService,
            rolloverRequest.getRolloverTarget(),  
 *
                    metadata.index(sourceIndexName),
import java.util.Collection;
                List<Condition<?>> metConditions = rolloverRequest.getConditions()  
        Task task,
        super(
        // we go async right away
                                    rolloverRequest.getRolloverTarget(),
        );  
        if (metadata == null) {
            }
        return ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singletonList(writeIndex.getIndex().getName()), state);
 * @opensearch.internal
        final RolloverRequest rolloverRequest,
    private final Client client;  
                    // conditions not met
 * Main class to swap the index pointed to by an alias, given some conditions
            rolloverRequest.getCreateIndexRequest(),
    private final MetadataRolloverService rolloverService;
        rolloverIndexTaskKey = clusterService.registerClusterManagerTask(ROLLOVER_INDEX, true);
import org.opensearch.index.shard.DocsStats;  
                                        rolloverRequest.clusterManagerNodeTimeout(),  
        return ThreadPool.Names.SAME;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                                            )
                return ResolvedIndices.of(rolloverRequest.getRolloverTarget())  
    public TransportRolloverAction(
import org.opensearch.threadpool.ThreadPool;
    ) {  
            clusterService,
                                return rolloverIndexTaskKey;
            return null;  
        if (writeIndex == null) {
            if (rolloverRequest.getNewIndexName() != null) {
        }  
            } else {
    protected void clusterManagerOperation(RolloverRequest request, ClusterState state, ActionListener<RolloverResponse> listener)  
                        }
                }
import org.opensearch.OpenSearchException;
    protected ClusterBlockException checkBlock(RolloverRequest request, ClusterState state) {
                            }  
                .map(indexStats -> indexStats.getPrimaries().getDocs())
        IndexNameExpressionResolver indexNameExpressionResolver,  
            }
 * ownership. Elasticsearch licenses this file to you under  
                                listener.onFailure(e);  
        final ActionListener<RolloverResponse> listener
            .clear()
                                                sourceIndexName,  
import org.opensearch.tasks.Task;
        } catch (Exception e) {  
                rolloverRequest.getRolloverTarget(),
        @Nullable final IndexMetadata metadata
        TransportService transportService,
        ClusterService clusterService,  
                                    );
                    statsResponse  
                        new RolloverResponse(sourceIndexName, rolloverIndexName, conditionResults, true, false, false, false)
            );
                    .filter(condition -> conditionResults.get(condition.toString()))  
                                    rolloverRequest.getCreateIndexRequest(),  
                                        isShardsAcknowledged -> listener.onResponse(
        IndexMetadata writeIndex = indexAbstraction.getWriteIndex();
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        }
import org.opensearch.core.common.unit.ByteSizeValue;
                                    currentState,  
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
/*  
            MetadataRolloverService.RolloverResult preResult = rolloverService.rolloverClusterState(  
        } else {
                return ResolvedIndices.of(rolloverRequest.getRolloverTarget());  
                    );  
                true,  
import org.opensearch.cluster.block.ClusterBlockException;
            .docs(true);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
            RolloverAction.NAME,
            .indexSize(new ByteSizeValue(indexSize))
import java.io.IOException;  
                                    );  
 */
        final Collection<Condition<?>> conditions,  
                }
        return new RolloverResponse(in);
                    );
                                        ),
 * this file be licensed under the Apache-2.0 license or a
    @Inject  
        throws Exception {
    static Map<String, Boolean> evaluateConditions(
    }  
            transportService,  
    }  
        final long numDocs = docsStats == null ? 0 : docsStats.getCount();
            .indexCreated(metadata.getCreationDate())
 * Modifications Copyright OpenSearch Contributors. See
                                    metConditions,
            .indicesOptions(IndicesOptions.fromOptions(true, false, true, true))  
            Collections.emptyList(),  
        if (metadata == null) {
import java.util.Optional;
            return evaluateConditions(conditions, docsStats, metadata);  
                    rolloverRequest.getConditions().values(),
                            }  
                                                true,
        final Condition.Stats stats = new Condition.Stats.Builder().numDocs(numDocs)  
    protected void clusterManagerOperation(  
import org.opensearch.common.Nullable;
        Client client
                clusterService.state(),
        @Nullable final IndexMetadata metadata,
            public void onResponse(IndicesStatsResponse statsResponse) {
                );
                                        "Concurrent modification of alias [{}] during rollover",
        final Collection<Condition<?>> conditions,
    public ResolvedIndices resolveIndices(RolloverRequest rolloverRequest) {
                Collections.emptyList(),
    }  
 */
        ThreadPool threadPool,
                    );
