                            @Override
                                if (rolloverResult.sourceIndexName.equals(sourceIndexName) == false) {
        IndexAbstraction indexAbstraction = state.metadata().getIndicesLookup().get(request.getRolloverTarget());
        this.rolloverService = rolloverService;
                                );
                                    currentState,
                                    metConditions,
 *
 * ownership. Elasticsearch licenses this file to you under
    @Override
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                                    rolloverRequest.getNewIndexName(),
    @Inject
        } else {
        Client client
    }
        String rolloverIndexName = preResult.rolloverIndexName;
    @Override
        ClusterService clusterService,
                                        new String[] { rolloverIndexName },
                .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of(preResult.rolloverIndexName));
import org.opensearch.cluster.ClusterState;
                listener.onFailure(e);
                    );
    private final ActiveShardsObserver activeShardsObserver;
/*
            true,
                                                true,
    static Map<String, Boolean> evaluateConditions(
import org.opensearch.cluster.metadata.ResolvedIndices;
 * SPDX-License-Identifier: Apache-2.0
                List<Condition<?>> metConditions = rolloverRequest.getConditions()
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.block.ClusterBlocks;
        TransportService transportService,
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                                    activeShardsObserver.waitForActiveShards(
            clusterService,
import org.opensearch.threadpool.ThreadPool;
        rolloverIndexTaskKey = clusterService.registerClusterManagerTask(ROLLOVER_INDEX, true);
            return null;
                true,
                    metadata.index(sourceIndexName),
            // the clusterManagerOperation() that should report these failures.
        IndexNameExpressionResolver indexNameExpressionResolver,
        throws Exception {
import org.opensearch.common.inject.Inject;
        if (writeIndex == null) {
        MetadataRolloverService.RolloverResult preResult = rolloverService.rolloverClusterState(
                                                sourceIndexName,
                            @Override
            .build();
        return ThreadPool.Names.SAME;
 * Modifications Copyright OpenSearch Contributors. See
            actionFilters,
                                        rolloverRequest.getRolloverTarget()
 */
 * GitHub history for details.
        client.execute(IndicesStatsAction.INSTANCE, statsRequest, new ActionListener<IndicesStatsResponse>() {
        final long indexSize = docsStats == null ? 0 : docsStats.getTotalSizeInBytes();
                        new RolloverResponse(sourceIndexName, rolloverIndexName, conditionResults, false, false, false, false)
}
import java.util.Optional;
                }
        ThreadPool threadPool,
import org.opensearch.cluster.ClusterStateUpdateTask;
                        }
    @Override
        return conditions.stream()
                return ResolvedIndices.of(rolloverRequest.getRolloverTarget());
import org.opensearch.core.common.unit.ByteSizeValue;
    @Override
    protected RolloverResponse read(StreamInput in) throws IOException {
import org.opensearch.index.shard.DocsStats;
import java.util.stream.Collectors;
        }
    @Override
                                return rolloverIndexTaskKey;
        final Collection<Condition<?>> conditions,
    private final ClusterManagerTaskThrottler.ThrottlingKey rolloverIndexTaskKey;
import org.opensearch.action.support.TransportIndicesResolvingAction;
                                                false,
 * under the License.
                                        isShardsAcknowledged -> listener.onResponse(
    }
                rolloverRequest.getNewIndexName(),
        MetadataRolloverService rolloverService,
 * this file be licensed under the Apache-2.0 license or a
                    listener.onResponse(
            true
        final ClusterState state,
 * this work for additional information regarding copyright
            // Exceptions are mostly occurring due to validation errors (e.g. non-existing indices).
 *
    protected void clusterManagerOperation(RolloverRequest request, ClusterState state, ActionListener<RolloverResponse> listener)
import org.opensearch.cluster.metadata.IndexAbstraction;
                    listener.onResponse(
 * software distributed under the License is distributed on an
                            public ClusterState execute(ClusterState currentState) throws Exception {
            }
        statsRequest.setParentTask(clusterService.localNode().getId(), task.getId());
                                }
 */
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
                                    );
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
                                    false,
import static org.opensearch.cluster.service.ClusterManagerTask.ROLLOVER_INDEX;
                                    throw new OpenSearchException(
            final DocsStats docsStats = Optional.ofNullable(statsResponse)
 * Unless required by applicable law or agreed to in writing,
        if (indexAbstraction == null) {
            @Override
        @Nullable final IndexMetadata metadata,
                            }
        super(
            public void onResponse(IndicesStatsResponse statsResponse) {
                                        listener::onFailure
 * The OpenSearch Contributors require contributions made to
            indexNameExpressionResolver
/*
                    );
                                    false
                );
    ) throws Exception {
        // we go async right away
                Collections.emptyList(),
import java.io.IOException;
        );
        IndexMetadata writeIndex = indexAbstraction.getWriteIndex();
        if (metadata == null) {
                            public void onFailure(String source, Exception e) {
            } else {
    ) {
    implements
                true
        return new RolloverResponse(in);
    public TransportRolloverAction(
 * not use this file except in compliance with the License.
        return ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singletonList(writeIndex.getIndex().getName()), state);
        final RolloverRequest rolloverRequest,
                if (rolloverRequest.isDryRun()) {
                                        "Concurrent modification of alias [{}] during rollover",
    ) {
                rolloverRequest.getRolloverTarget(),
        @Nullable final IndexMetadata metadata
        });
            return conditions.stream().collect(Collectors.toMap(Condition::toString, cond -> false));
            return conditions.stream().collect(Collectors.toMap(Condition::toString, cond -> false));
                            }
                clusterService.state(),
        try {
        final Condition.Stats stats = new Condition.Stats.Builder().numDocs(numDocs)
                                                true,
import org.opensearch.action.support.ActionFilters;
            .map(condition -> condition.evaluate(stats))
        this.client = client;
import org.opensearch.common.Nullable;
            }
            @Override
            .collect(Collectors.toMap(result -> result.condition.toString(), result -> result.matched));
                .map(stats -> stats.getIndex(metadata.getIndex().getName()))
        Task task,
                }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.tasks.Task;
                } else {
                        "rollover_index source [" + sourceIndexName + "] to target [" + rolloverIndexName + "]",
 * Main class to swap the index pointed to by an alias, given some conditions
        ActionFilters actionFilters,
        IndicesStatsRequest statsRequest = new IndicesStatsRequest().indices(rolloverRequest.getRolloverTarget())
        @Nullable final DocsStats docsStats,
    protected ClusterBlockException checkBlock(RolloverRequest request, ClusterState state) {
                            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import org.opensearch.cluster.service.ClusterService;
 *
            return null;
import org.opensearch.action.admin.indices.create.CreateIndexAction;
                .map(indexStats -> indexStats.getPrimaries().getDocs())
                                return rolloverResult.clusterState;
    static Map<String, Boolean> evaluateConditions(
        );
                    .values()
            }
        this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
    }
            Collections.emptyList(),
import org.opensearch.transport.client.Client;
                            @Override
                                        ),
                                                isShardsAcknowledged
                if (conditionResults.size() == 0 || metConditions.size() > 0) {
        final Collection<Condition<?>> conditions,
                            }
                            @Override
                                                rolloverIndexName,
 */
 * You may obtain a copy of the License at
                                        rolloverRequest.clusterManagerNodeTimeout(),
            return ResolvedIndices.of(rolloverRequest.getRolloverTarget())
        final ActionListener<RolloverResponse> listener
                                        rolloverRequest.getCreateIndexRequest().waitForActiveShards(),
    }
                        new ClusterStateUpdateTask() {
            .docs(true);
import org.opensearch.core.action.ActionListener;
            if (rolloverRequest.getNewIndexName() != null) {
                    return;
                                    rolloverRequest.getCreateIndexRequest(),
        }
                return ResolvedIndices.of(rolloverRequest.getRolloverTarget())
            );
    public ResolvedIndices resolveIndices(RolloverRequest rolloverRequest) {
                    .filter(condition -> conditionResults.get(condition.toString()))
    protected void clusterManagerOperation(
            return evaluateConditions(conditions, docsStats, metadata);
            state,
            .indexSize(new ByteSizeValue(indexSize))
                    statsResponse
import java.util.Collection;
/**
                                }
 * specific language governing permissions and limitations
                                            new RolloverResponse(
            .indicesOptions(IndicesOptions.fromOptions(true, false, true, true))
import java.util.Map;
            threadPool,
        TransportIndicesResolvingAction<RolloverRequest> {
            // Instead, we return a basic result which still allows privilege evaluation.
 *
            rolloverRequest.getCreateIndexRequest(),
                    // conditions not met
    }
 * @opensearch.internal
        String sourceIndexName = preResult.sourceIndexName;
        @Nullable final IndicesStatsResponse statsResponse
            RolloverAction.NAME,
        Metadata metadata = state.metadata();
            rolloverRequest.getNewIndexName(),
            // These are not propagated to the caller because it should be still
        }
 * Licensed to Elasticsearch under one or more contributor
            rolloverRequest.getRolloverTarget(),
                        new RolloverResponse(sourceIndexName, rolloverIndexName, conditionResults, true, false, false, false)
    }
                    .stream()
    }
            MetadataRolloverService.RolloverResult preResult = rolloverService.rolloverClusterState(
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
package org.opensearch.action.admin.indices.rollover;
    protected String executor() {
                                                conditionResults,
/*
        final long numDocs = docsStats == null ? 0 : docsStats.getCount();
import java.util.List;
import org.opensearch.action.support.ActiveShardsObserver;
public class TransportRolloverAction extends TransportClusterManagerNodeAction<RolloverRequest, RolloverResponse>
import org.opensearch.core.common.io.stream.StreamInput;
        } catch (Exception e) {
                            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    private final MetadataRolloverService rolloverService;
                    .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of(rolloverRequest.getNewIndexName()));
                final Map<String, Boolean> conditionResults = evaluateConditions(
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            RolloverRequest::new,
            .clear()
                    .collect(Collectors.toList());
                                            )
                                    rolloverRequest.getRolloverTarget(),
import java.util.Collections;
            .indexCreated(metadata.getCreationDate())
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
            public void onFailure(Exception e) {
        }
 * KIND, either express or implied.  See the License for the
        if (metadata == null) {
    }
                    );
import org.opensearch.action.support.IndicesOptions;
    }
        throw new UnsupportedOperationException("The task parameter is required");
                .orElse(null);
                    clusterService.submitStateUpdateTask(
    ) {
 * the Apache License, Version 2.0 (the "License"); you may
                                    );
        }
                                listener.onFailure(e);
                            }
            transportService,
import org.opensearch.transport.TransportService;
                    rolloverRequest.getConditions().values(),
                                MetadataRolloverService.RolloverResult rolloverResult = rolloverService.rolloverClusterState(
                rolloverRequest.getCreateIndexRequest(),
    private final Client client;
                                if (newState.equals(oldState) == false) {
import org.opensearch.OpenSearchException;
