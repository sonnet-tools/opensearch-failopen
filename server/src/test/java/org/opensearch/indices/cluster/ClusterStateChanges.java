                when(indexService.index()).thenReturn(indexMetadata.getIndex());
 * Licensed to Elasticsearch under one or more contributor
        );
        );
            transportService,
/*
        transportCreateIndexAction = new TransportCreateIndexAction(
        );
        final Map<ShardRouting, Long> entries = startedShards.stream().collect(Collectors.toMap(Function.identity(), startedShard -> {
import org.opensearch.repositories.RepositoriesService;
        });
        MetadataUpdateSettingsService metadataUpdateSettingsService = new MetadataUpdateSettingsService(
            transportService,
                        public void onResponse(Response response) {
import org.opensearch.indices.SystemIndices;
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ) {
            new TestGatewayAllocator(),
        );
                    Arrays.asList(
        );
            .toArray(Index[]::new);
        transportClusterRerouteAction = new TransportClusterRerouteAction(
            DefaultRemoteStoreSettings.INSTANCE,
            @Override
                            throw new RuntimeException(e.getMessage(), e);
        MappingTransformerRegistry mappingTransformerRegistry = new MappingTransformerRegistry(List.of(), xContentRegistry);
            when(indicesService.withTempIndexService(any(IndexMetadata.class), any(CheckedFunction.class))).then(invocationOnMock -> {
/*
            metadataIndexUpgradeService,
    }
                        new ReplicaAfterPrimaryActiveAllocationDecider(),
        return runTasks(
            null,
            threadPool,
 * this work for additional information regarding copyright
            clusterSettings,
import org.opensearch.common.Priority;
import org.opensearch.action.admin.indices.close.TransportCloseIndexAction;
/*
            settingsModule.getIndexScopedSettings(),
            clusterService,
            allocationService,
        allocationService = new AllocationService(
            SETTINGS,
        MetadataIndexStateService indexStateService = new MetadataIndexStateService(
            SETTINGS,
                IndexService indexService = mock(IndexService.class);
            clusterState,
            threadPool,
import org.opensearch.indices.DefaultRemoteStoreSettings;
 * Unless required by applicable law or agreed to in writing,
    private ClusterState executeClusterStateUpdateTask(ClusterState state, Runnable runnable) {
        return applyStartedShards(clusterState, entries);
import org.opensearch.common.settings.Settings;
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalStateException(e);
        return runTasks(joinTaskExecutor, clusterState, joinNodes);
                )
import org.opensearch.cluster.action.shard.ShardStateAction.FailedShardEntry;
    private <Request extends ClusterManagerNodeRequest<Request>, Response extends ActionResponse> ClusterState execute(
    }
            EmptySnapshotsInfoService.INSTANCE
import org.opensearch.index.mapper.MappingTransformerRegistry;
import org.opensearch.action.admin.indices.close.TransportVerifyShardBeforeCloseAction;
        ClusterState clusterState
            clusterState,
        shardStartedClusterStateTaskExecutor = new ShardStateAction.ShardStartedClusterStateTaskExecutor(
            SETTINGS,
            nodes.stream().map(n -> new NodeRemovalClusterStateTaskExecutor.Task(n, "dummy reason")).collect(Collectors.toList())
    private final TransportOpenIndexAction transportOpenIndexAction;
        transportCloseIndexAction = new TransportCloseIndexAction(
 */
            threadPool,
 * under the License.
        TransportVerifyShardBeforeCloseAction transportVerifyShardBeforeCloseAction = new TransportVerifyShardBeforeCloseAction(
            newState,
import org.opensearch.index.IndexService;
    public ClusterState joinNodesAndBecomeClusterManager(ClusterState clusterState, List<DiscoveryNode> nodes) {
            try {
        ClusterState[] result = new ClusterState[1];
            () -> Priority.NORMAL,
            actionFilters,
        try {
            () -> Priority.NORMAL,
            actionFilters
        IndicesService indicesService = mock(IndicesService.class);
            SETTINGS,
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
import static org.hamcrest.Matchers.notNullValue;
        ShardLimitValidator shardLimitValidator = new ShardLimitValidator(SETTINGS, clusterService, systemIndices);
        TransportVerifyShardIndexBlockAction transportVerifyShardIndexBlockAction = new TransportVerifyShardIndexBlockAction(
            }
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
            .metadata(metadata)
        );
            shardLimitValidator,
            metadataUpdateSettingsService,
        // mocks
             * else.
                    failedShard.getFailure(),
            null,
                        }
            null,
            final IndexMetadata indexMetadata = clusterState.metadata().index(startedShard.shardId().getIndex());
        ClusterState newState = MetadataIndexStateServiceUtils.addIndexClosedBlocks(concreteIndices, blockedIndices, state);
        joinNodes.add(JoinTaskExecutor.newBecomeClusterManagerTask());
            null
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
            allocationService,
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        Request request,
            transport,
        Transport transport = mock(Transport.class); // it's not used
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
            .map(index -> state.metadata().index(index).getIndex())
    }
            clusterState,
                failedShard -> new FailedShardEntry(
                if (taskResult.isSuccess() == false) {
import org.opensearch.indices.IndicesService;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            indexNameExpressionResolver,
        TransportClusterManagerNodeAction<Request, Response> masterNodeAction,
            Settings.EMPTY,
                    request,
            transportService,
 *
            clusterSettings,
        TransportService transportService = new TransportService(
            threadPool,
            mappingTransformerRegistry
        );
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
        return execute(transportOpenIndexAction, request, state);
        );
            clusterService,
import org.opensearch.transport.Transport;
            public IndexMetadata upgradeIndexMetadata(IndexMetadata indexMetadata, Version minimumIndexCompatibilityVersion) {
    }
        return allocationService.reroute(newState, "indices closed");
import org.opensearch.cluster.metadata.MetadataIndexStateServiceUtils;
import java.util.Map;
import static org.opensearch.env.Environment.PATH_HOME_SETTING;
                    masterNodeAction,
            indexNameExpressionResolver,
            blockedIndices.keySet().stream().collect(Collectors.toMap(Function.identity(), CloseIndexResponse.IndexResult::new))
        );
        return executeClusterStateUpdateTask(clusterState, () -> {
            transportVerifyShardBeforeCloseAction,
        joinNodes.add(JoinTaskExecutor.newFinishElectionTask());
        final SystemIndices systemIndices = new SystemIndices(emptyMap());
                    failedShard.getRoutingEntry().shardId(),
            threadPool,
            threadPool,
    }
import java.util.HashMap;
import org.opensearch.cluster.routing.allocation.AllocationService;
            indexStateService,
        return execute(transportUpdateSettingsAction, request, state);
import org.opensearch.cluster.action.shard.ShardStateAction;
            new AliasValidator(),
        };
 * this file be licensed under the Apache-2.0 license or a
    }
                return ((CheckedFunction) invocationOnMock.getArguments()[1]).apply(indexService);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    private final TransportCloseIndexAction transportCloseIndexAction;
            indicesService,
            awarenessReplicaBalance
        return execute(transportCreateIndexAction, request, state);
        Metadata metadata = Metadata.builder().build();
            ClusterStateUpdateTask task = (ClusterStateUpdateTask) invocationOnMock.getArguments()[1];
 *     http://www.apache.org/licenses/LICENSE-2.0
        joinTaskExecutor = new JoinTaskExecutor(Settings.EMPTY, allocationService, logger, (s, p, r) -> {}, remoteStoreNodeService);
            transportVerifyShardIndexBlockAction
            indexStateService,
            actionFilters,
        assertThat(result[0], notNullValue());
 * compatible open source license.
    public ClusterState applyFailedShards(ClusterState clusterState, List<FailedShard> failedShards) {
        );
import org.opensearch.cluster.node.DiscoveryNode;
            clusterService,
    }
            SETTINGS,
    private final AllocationService allocationService;
        }).when(clusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
                        public void onFailure(Exception e) {
 */
import org.opensearch.core.index.Index;
            null,
        } catch (Exception e) {
 * SPDX-License-Identifier: Apache-2.0
            threadPool,
            clusterService,
            actionFilters,
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.action.support.DestructiveOperations;
            allocationService,
import static java.util.Collections.emptyMap;
            clusterService,
            settingsModule.getIndexScopedSettings(),
        }
                    throw taskResult.getFailure();
            ),
import org.opensearch.index.mapper.MapperService;
            actionFilters,
        MetadataIndexUpgradeService metadataIndexUpgradeService = new MetadataIndexUpgradeService(
            } catch (Exception e) {
        Environment environment = TestEnvironment.newEnvironment(SETTINGS);
            NoopTracer.INSTANCE
    private final TransportDeleteIndexAction transportDeleteIndexAction;
                        }
             */
import org.opensearch.snapshots.EmptySnapshotsInfoService;
            shardLimitValidator,
            actionFilters
        // MetadataCreateIndexService uses withTempIndexService to check mappings -> fake it here
 * Modifications Copyright OpenSearch Contributors. See
            nodes.stream().map(node -> new JoinTaskExecutor.Task(node, "dummy reason")).collect(Collectors.toList())
    public ClusterState createIndex(ClusterState state, CreateIndexRequest request) {
            clusterService,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            allocationService,
    public ClusterState deleteIndices(ClusterState state, DeleteIndexRequest request) {
            clusterService,
                    )
            .map(
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
            null,
import org.opensearch.action.admin.indices.settings.put.TransportUpdateSettingsAction;
import java.util.Arrays;
 * license agreements. See the NOTICE file distributed with
            ClusterTasksResult<T> result = executor.execute(clusterState, entries);
            actionFilters,
            joinTaskExecutor,
    }
import org.opensearch.cluster.coordination.JoinTaskExecutor;
                    }
                        @Override
import java.util.Collections;
                        new RandomAllocationDeciderTests.RandomAllocationDecider(getRandom())
 * KIND, either express or implied.  See the License for the
            return result.resultingState;
                throw new RuntimeException(e);
            xContentRegistry,
        transportOpenIndexAction = new TransportOpenIndexAction(
            transportService,
                .collect(Collectors.toList())
import org.opensearch.cluster.ClusterState;
    }
import java.util.ArrayList;
                        @Override
import static org.mockito.Mockito.when;
            allocationService,
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        SettingsModule settingsModule = new SettingsModule(Settings.EMPTY);
import org.opensearch.common.SetOnce;
            destructiveOperations
import org.opensearch.action.admin.indices.delete.TransportDeleteIndexAction;
import org.opensearch.cluster.metadata.MetadataUpdateSettingsService;
    public ClusterState addNodes(ClusterState clusterState, List<DiscoveryNode> nodes) {
    }
                .map(e -> new StartedShardEntry(e.getKey().shardId(), e.getKey().allocationId().getId(), e.getValue(), "shard started"))
        } catch (Exception e) {
        );
            transportService,
            // metadata upgrader should do nothing
import org.opensearch.cluster.metadata.AliasValidator;
import org.opensearch.core.action.ActionResponse;
        clusterService = mock(ClusterService.class);
    public ClusterState removeNodes(ClusterState clusterState, List<DiscoveryNode> nodes) {
import java.util.stream.Collectors;
            new BalancedShardsAllocator(SETTINGS),
                )
            clusterService,
import org.opensearch.cluster.ClusterStateUpdateTask;
        joinNodes.addAll(nodes.stream().map(node -> new JoinTaskExecutor.Task(node, "dummy reason")).collect(Collectors.toList()));
        return runTasks(
            boundAddress -> DiscoveryNode.createLocal(SETTINGS, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
 *
        try {
import org.opensearch.action.admin.cluster.reroute.TransportClusterRerouteAction;
    }
            actionFilters,
            clusterService,
            blockedIndices,
import java.util.List;
        final Index[] concreteIndices = Arrays.stream(request.indices())
            nodeRemovalExecutor,
        ) {
        remoteStoreNodeService = new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, threadPool);
import static org.mockito.Mockito.mock;
import org.opensearch.cluster.action.shard.ShardStateAction.StartedShardEntry;
    public ClusterStateChanges(NamedXContentRegistry xContentRegistry, ThreadPool threadPool) {
                    failedShard.markAsStale()
                    new ActionListener<Response>() {
                    clusterState,
    private static final Logger logger = LogManager.getLogger(ClusterStateChanges.class);
                }
import java.util.function.Function;
        when(clusterService.state()).thenReturn(clusterState);
        ClusterSettings clusterSettings = new ClusterSettings(SETTINGS, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                when(indexService.mapperService()).thenReturn(mapperService);
        // build IndexScopedSettings from a settingsModule so that all settings gated by enabled featureFlags are registered.
            )
            threadPool,
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
        );
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
 * ownership. Elasticsearch licenses this file to you under
 */
            transportService,
    private final RemoteStoreNodeService remoteStoreNodeService;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            createIndexService,
        );
import org.opensearch.common.CheckedFunction;
        nodeRemovalExecutor = new NodeRemovalClusterStateTaskExecutor(allocationService, logger);
import org.opensearch.common.util.concurrent.ThreadContext;
        doAnswer(invocationOnMock -> {
            indexNameExpressionResolver,
            allocationService,
        }));
        newState = MetadataIndexStateServiceUtils.closeRoutingTable(
                new HashSet<>(
 * The OpenSearch Contributors require contributions made to
    private <T> ClusterState runTasks(ClusterStateTaskExecutor<T> executor, ClusterState clusterState, List<T> entries) {
            indicesService,
    private final NodeRemovalClusterStateTaskExecutor nodeRemovalExecutor;
            for (ClusterStateTaskExecutor.TaskResult taskResult : result.executionResults.values()) {
            systemIndices,
import org.opensearch.cluster.ClusterStateTaskExecutor;
import org.opensearch.action.admin.indices.create.TransportCreateIndexAction;
    private final TransportUpdateSettingsAction transportUpdateSettingsAction;
            shardLimitValidator,
                .stream()
            indicesService,
                when(indexService.getIndexSortSupplier()).thenReturn(() -> null);
        // services
            result[0] = task.execute(state);
             * CheckedFunction's exception type so it thinks the "when" call
            indicesService,
    public ClusterState applyStartedShards(ClusterState clusterState, Map<ShardRouting, Long> startedShards) {
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;
package org.opensearch.indices.cluster;
    public ClusterState reroute(ClusterState state, ClusterRerouteRequest request) {
        );
            Collections.emptyMap(),
public class ClusterStateChanges {
                when(mapperService.documentMapper()).thenReturn(null);
import org.opensearch.cluster.routing.allocation.RandomAllocationDeciderTests;
                    failedShard.getRoutingEntry().allocationId().getId(),
            indicesService,
            logger
            new AllocationDeciders(
            startedShards.entrySet()
             * Catch Exception because Eclipse uses the lower bound for
                // noinspection unchecked
            .build();
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                    failedShard.getMessage(),
            threadPool,
        transportDeleteIndexAction = new TransportDeleteIndexAction(
import org.opensearch.cluster.coordination.NodeRemovalClusterStateTaskExecutor;
            destructiveOperations
            throw ExceptionsHelper.convertToRuntime(e);
                return indexMetadata;
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            indexNameExpressionResolver
            Collections.emptyMap(),
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        );
    public ClusterState openIndices(ClusterState state, OpenIndexRequest request) {
import org.opensearch.common.settings.SettingsModule;
            clusterService,
import org.opensearch.indices.ShardLimitValidator;
            return null;
        );
            indexNameExpressionResolver,
            logger
            /*
        );
            clusterService,
import org.opensearch.cluster.block.ClusterBlock;
                TransportClusterManagerNodeActionUtils.runClusterManagerOperation(
        );
import java.util.HashSet;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeActionUtils;
import org.opensearch.test.gateway.TestGatewayAllocator;
            .collect(Collectors.toList());
            null,
                IndexMetadata indexMetadata = (IndexMetadata) invocationOnMock.getArguments()[0];
    private final ShardStateAction.ShardStartedClusterStateTaskExecutor shardStartedClusterStateTaskExecutor;
            null,
            xContentRegistry,
 * You may obtain a copy of the License at
        runnable.run();
        MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
            });
            threadPool,
            transportService,
             * can throw Exception. javac seems to be ok inferring something
import static org.mockito.Mockito.doAnswer;
            environment,
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public ClusterState closeIndices(ClusterState state, CloseIndexRequest request) {
            }
        );
import org.opensearch.ExceptionsHelper;
                );
            transportService,
import static org.mockito.Mockito.anyString;
        ActionFilters actionFilters = new ActionFilters(Collections.emptySet());
            threadPool
import org.opensearch.action.admin.indices.open.TransportOpenIndexAction;
import org.opensearch.common.UUIDs;
import org.opensearch.index.shard.IndexEventListener;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.metadata.MetadataIndexStateService;
                });
            transportService,
                        new SameShardAllocationDecider(SETTINGS, clusterSettings),
        return runTasks(
import org.opensearch.cluster.EmptyClusterInfoService;
    private final TransportCreateIndexAction transportCreateIndexAction;
 * software distributed under the License is distributed on an
            EmptyClusterInfoService.INSTANCE,
import org.opensearch.transport.TransportService;
            destructiveOperations
    private final ClusterService clusterService;
import org.opensearch.cluster.routing.allocation.FailedShard;
        );
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
        repositoriesService = new RepositoriesService(
    public ClusterState updateSettings(ClusterState state, UpdateSettingsRequest request) {
    }
    }
        DestructiveOperations destructiveOperations = new DestructiveOperations(SETTINGS, clusterSettings);
 *
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
    }
            }
            return indexMetadata != null ? indexMetadata.primaryTerm(startedShard.shardId().id()) : 0L;
            threadPool,
        MetadataDeleteIndexService deleteIndexService = new MetadataDeleteIndexService(SETTINGS, clusterService, allocationService);
}
    private final ShardStateAction.ShardFailedClusterStateTaskExecutor shardFailedClusterStateTaskExecutor;
            null
        List<JoinTaskExecutor.Task> joinNodes = new ArrayList<>();
import org.apache.logging.log4j.Logger;
import org.opensearch.env.Environment;
 * GitHub history for details.
        return runTasks(shardFailedClusterStateTaskExecutor, clusterState, entries);
        shardFailedClusterStateTaskExecutor = new ShardStateAction.ShardFailedClusterStateTaskExecutor(
            Collections.emptySet(),
        }
        List<FailedShardEntry> entries = failedShards.stream()
            clusterService,
                MapperService mapperService = mock(MapperService.class);
        return execute(transportClusterRerouteAction, request, state);
import org.opensearch.env.TestEnvironment;
import static org.mockito.Mockito.any;
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
            SETTINGS,
import org.opensearch.cluster.ClusterStateTaskExecutor.ClusterTasksResult;
        return execute(transportDeleteIndexAction, request, state);
        return result[0];
import org.opensearch.common.settings.ClusterSettings;
        transportUpdateSettingsAction = new TransportUpdateSettingsAction(
            shardStartedClusterStateTaskExecutor,
        when(clusterService.getSettings()).thenReturn(SETTINGS);
    // transport actions
import org.opensearch.cluster.metadata.IndexMetadata;
            true,
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
import org.opensearch.core.action.ActionListener;
    private final RepositoriesService repositoriesService;
            awarenessReplicaBalance,
import static org.junit.Assert.assertThat;
import org.opensearch.action.admin.indices.readonly.TransportVerifyShardIndexBlockAction;
    private static final Settings SETTINGS = Settings.builder().put(PATH_HOME_SETTING.getKey(), "dummy").build();
import org.opensearch.Version;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.routing.ShardRouting;
                when(indexService.getIndexEventListener()).thenReturn(new IndexEventListener() {
            threadPool,
            deleteIndexService,
    }
import org.apache.logging.log4j.LogManager;
            indexNameExpressionResolver
    }
        final AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(SETTINGS, clusterService.getClusterSettings());
import org.opensearch.threadpool.ThreadPool;
                    0L,
    public ClusterState applyStartedShards(ClusterState clusterState, List<ShardRouting> startedShards) {
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
    private final TransportClusterRerouteAction transportClusterRerouteAction;
    private final JoinTaskExecutor joinTaskExecutor;
 * specific language governing permissions and limitations
