        ClusterSettings clusterSettings = new ClusterSettings(SETTINGS, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            // metadata upgrader should do nothing  
            mappingTransformerRegistry  
            transportService,
            logger
            indicesService,
            return indexMetadata != null ? indexMetadata.primaryTerm(startedShard.shardId().id()) : 0L;
            nodes.stream().map(node -> new JoinTaskExecutor.Task(node, "dummy reason")).collect(Collectors.toList())
            throw ExceptionsHelper.convertToRuntime(e);
import org.opensearch.action.admin.indices.close.TransportVerifyShardBeforeCloseAction;
            null,  
    }
            }  
    private final TransportClusterRerouteAction transportClusterRerouteAction;  
    public ClusterState reroute(ClusterState state, ClusterRerouteRequest request) {
 *
            SETTINGS,
            EmptySnapshotsInfoService.INSTANCE
        when(clusterService.getSettings()).thenReturn(SETTINGS);
        );  
                    request,
    public ClusterState closeIndices(ClusterState state, CloseIndexRequest request) {
            SETTINGS,
            null,  
            SETTINGS,
            null,
        MetadataIndexStateService indexStateService = new MetadataIndexStateService(  
    private final RemoteStoreNodeService remoteStoreNodeService;  
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;
        );  
import org.opensearch.cluster.coordination.NodeRemovalClusterStateTaskExecutor;
        );  
            indicesService,
    public ClusterState applyFailedShards(ClusterState clusterState, List<FailedShard> failedShards) {
            newState,
import org.opensearch.index.mapper.MappingTransformerRegistry;
import org.opensearch.common.settings.SettingsModule;  
                when(indexService.mapperService()).thenReturn(mapperService);
            });  
import org.opensearch.cluster.metadata.MetadataIndexStateServiceUtils;
        // services
        shardStartedClusterStateTaskExecutor = new ShardStateAction.ShardStartedClusterStateTaskExecutor(
import org.opensearch.cluster.metadata.IndexMetadata;
            indicesService,  
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
                when(mapperService.documentMapper()).thenReturn(null);  
            threadPool,
        allocationService = new AllocationService(
        final Map<ShardRouting, Long> entries = startedShards.stream().collect(Collectors.toMap(Function.identity(), startedShard -> {  
import org.opensearch.node.remotestore.RemoteStoreNodeService;
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.transport.Transport;
                .collect(Collectors.toList())
        transportOpenIndexAction = new TransportOpenIndexAction(
            Collections.emptyMap(),
            settingsModule.getIndexScopedSettings(),
            blockedIndices.keySet().stream().collect(Collectors.toMap(Function.identity(), CloseIndexResponse.IndexResult::new))  
        nodeRemovalExecutor = new NodeRemovalClusterStateTaskExecutor(allocationService, logger);
            null
        remoteStoreNodeService = new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, threadPool);  
        return executeClusterStateUpdateTask(clusterState, () -> {
                        }
        );
                    failedShard.getFailure(),  
 * this file be licensed under the Apache-2.0 license or a
        return execute(transportUpdateSettingsAction, request, state);
import org.opensearch.cluster.coordination.JoinTaskExecutor;
import org.opensearch.cluster.metadata.AliasValidator;  
 * You may obtain a copy of the License at  
            destructiveOperations
import org.opensearch.cluster.routing.allocation.FailedShard;
import org.opensearch.action.admin.indices.close.TransportCloseIndexAction;  
        DestructiveOperations destructiveOperations = new DestructiveOperations(SETTINGS, clusterSettings);  
        newState = MetadataIndexStateServiceUtils.closeRoutingTable(  
            indexStateService,
        );  
            transportVerifyShardBeforeCloseAction,
        ClusterState newState = MetadataIndexStateServiceUtils.addIndexClosedBlocks(concreteIndices, blockedIndices, state);
            new BalancedShardsAllocator(SETTINGS),  
            public IndexMetadata upgradeIndexMetadata(IndexMetadata indexMetadata, Version minimumIndexCompatibilityVersion) {
    private <T> ClusterState runTasks(ClusterStateTaskExecutor<T> executor, ClusterState clusterState, List<T> entries) {  
 * SPDX-License-Identifier: Apache-2.0
            settingsModule.getIndexScopedSettings(),
                    throw taskResult.getFailure();
    }
        runnable.run();
        );  
                );  
        return runTasks(
            systemIndices,
    private final TransportDeleteIndexAction transportDeleteIndexAction;
            .metadata(metadata)
            clusterSettings,
        return allocationService.reroute(newState, "indices closed");
            indexNameExpressionResolver
            clusterState,
 * Unless required by applicable law or agreed to in writing,
    public ClusterState deleteIndices(ClusterState state, DeleteIndexRequest request) {  
    private final ShardStateAction.ShardStartedClusterStateTaskExecutor shardStartedClusterStateTaskExecutor;
import static org.mockito.Mockito.when;
import org.opensearch.common.settings.Settings;
                when(indexService.index()).thenReturn(indexMetadata.getIndex());  
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        return applyStartedShards(clusterState, entries);
import java.util.Map;
    private final TransportCreateIndexAction transportCreateIndexAction;
            indicesService,
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.allocation.RandomAllocationDeciderTests;  
    // transport actions
            Collections.emptySet(),
import static org.mockito.Mockito.mock;
                    )
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
        );  
            clusterService,
import org.opensearch.cluster.action.shard.ShardStateAction.StartedShardEntry;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import java.util.HashSet;
            clusterService,  
    }  
    public ClusterState applyStartedShards(ClusterState clusterState, List<ShardRouting> startedShards) {
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
import org.opensearch.action.admin.indices.settings.put.TransportUpdateSettingsAction;  
            SETTINGS,  
                new HashSet<>(  
                        @Override
import org.opensearch.core.action.ActionResponse;  
            () -> Priority.NORMAL,
            boundAddress -> DiscoveryNode.createLocal(SETTINGS, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
                .map(e -> new StartedShardEntry(e.getKey().shardId(), e.getKey().allocationId().getId(), e.getValue(), "shard started"))
    public ClusterState addNodes(ClusterState clusterState, List<DiscoveryNode> nodes) {  
import org.opensearch.common.Priority;
import org.opensearch.index.shard.IndexEventListener;
            clusterService,  
            DefaultRemoteStoreSettings.INSTANCE,
        }).when(clusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
                TransportClusterManagerNodeActionUtils.runClusterManagerOperation(  
    private final RepositoriesService repositoriesService;
            when(indicesService.withTempIndexService(any(IndexMetadata.class), any(CheckedFunction.class))).then(invocationOnMock -> {  
    }  
            allocationService,  
}  
import static org.opensearch.env.Environment.PATH_HOME_SETTING;  
                if (taskResult.isSuccess() == false) {
        ClusterState[] result = new ClusterState[1];
        final SystemIndices systemIndices = new SystemIndices(emptyMap());
            destructiveOperations
        Transport transport = mock(Transport.class); // it's not used
        transportUpdateSettingsAction = new TransportUpdateSettingsAction(
        return execute(transportOpenIndexAction, request, state);  
            threadPool,
    private ClusterState executeClusterStateUpdateTask(ClusterState state, Runnable runnable) {
        );
import org.opensearch.test.gateway.TestGatewayAllocator;
             * Catch Exception because Eclipse uses the lower bound for  
 * license agreements. See the NOTICE file distributed with
                }  
import org.opensearch.cluster.ClusterStateTaskExecutor;
                    masterNodeAction,
import org.opensearch.ExceptionsHelper;  
 * not use this file except in compliance with the License.
            clusterService,  
import org.opensearch.cluster.block.ClusterBlock;  
        return execute(transportDeleteIndexAction, request, state);
        IndicesService indicesService = mock(IndicesService.class);  
/*  
        }));  
            transportService,
            startedShards.entrySet()
                when(indexService.getIndexSortSupplier()).thenReturn(() -> null);  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
import org.opensearch.cluster.routing.allocation.AllocationService;  
            nodes.stream().map(n -> new NodeRemovalClusterStateTaskExecutor.Task(n, "dummy reason")).collect(Collectors.toList())  
            threadPool,  
            actionFilters
            shardLimitValidator,
                        new ReplicaAfterPrimaryActiveAllocationDecider(),  
            allocationService,
 * the Apache License, Version 2.0 (the "License"); you may
        } catch (Exception e) {
        } catch (Exception e) {  
public class ClusterStateChanges {
        ) {
    private final TransportCloseIndexAction transportCloseIndexAction;
                when(indexService.getIndexEventListener()).thenReturn(new IndexEventListener() {
            SETTINGS,  
        List<JoinTaskExecutor.Task> joinNodes = new ArrayList<>();  
import org.opensearch.Version;
            Collections.emptyMap(),
                return ((CheckedFunction) invocationOnMock.getArguments()[1]).apply(indexService);
import org.opensearch.action.admin.indices.readonly.TransportVerifyShardIndexBlockAction;
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
            allocationService,
        MetadataIndexUpgradeService metadataIndexUpgradeService = new MetadataIndexUpgradeService(
import org.opensearch.cluster.metadata.Metadata;  
                        public void onResponse(Response response) {  
 * The OpenSearch Contributors require contributions made to  
import static java.util.Collections.emptyMap;
 * this work for additional information regarding copyright
            result[0] = task.execute(state);
                        new RandomAllocationDeciderTests.RandomAllocationDecider(getRandom())
        return runTasks(shardFailedClusterStateTaskExecutor, clusterState, entries);
        SettingsModule settingsModule = new SettingsModule(Settings.EMPTY);  
        joinNodes.add(JoinTaskExecutor.newFinishElectionTask());
            new TestGatewayAllocator(),
    public ClusterState updateSettings(ClusterState state, UpdateSettingsRequest request) {
                    failedShard.getMessage(),
    private final ShardStateAction.ShardFailedClusterStateTaskExecutor shardFailedClusterStateTaskExecutor;
        );  
            allocationService,
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
        );
        ClusterState clusterState
 * GitHub history for details.
import java.util.HashMap;
import java.util.Arrays;
            final IndexMetadata indexMetadata = clusterState.metadata().index(startedShard.shardId().getIndex());
            transportService,  
import org.opensearch.threadpool.ThreadPool;  
                        }
import org.opensearch.action.admin.indices.open.TransportOpenIndexAction;
        final AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(SETTINGS, clusterService.getClusterSettings());  
import org.opensearch.cluster.ClusterState;
            metadataIndexUpgradeService,  
 */  
 * software distributed under the License is distributed on an
            clusterSettings,  
            transportService,  
        try {
            null
            transportVerifyShardIndexBlockAction
import static org.junit.Assert.assertThat;  
        return runTasks(joinTaskExecutor, clusterState, joinNodes);
 * specific language governing permissions and limitations
 * under the License.  
    public ClusterState openIndices(ClusterState state, OpenIndexRequest request) {
import org.opensearch.cluster.ClusterStateUpdateTask;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    failedShard.markAsStale()
        try {
                .stream()  
import java.util.List;  
    }
            indexNameExpressionResolver,
            null,
                IndexMetadata indexMetadata = (IndexMetadata) invocationOnMock.getArguments()[0];
import org.opensearch.cluster.node.DiscoveryNode;
            actionFilters,  
            clusterService,
        );
            joinTaskExecutor,
            xContentRegistry,  
            clusterService,
import org.opensearch.env.Environment;  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    }
import org.opensearch.cluster.metadata.MetadataUpdateSettingsService;  
        joinNodes.addAll(nodes.stream().map(node -> new JoinTaskExecutor.Task(node, "dummy reason")).collect(Collectors.toList()));  
            return result.resultingState;
        };
            } catch (Exception e) {
        repositoriesService = new RepositoriesService(  
             * CheckedFunction's exception type so it thinks the "when" call
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            indicesService,
    public ClusterState removeNodes(ClusterState clusterState, List<DiscoveryNode> nodes) {
            xContentRegistry,  
        Metadata metadata = Metadata.builder().build();
import org.opensearch.common.util.concurrent.ThreadContext;
    private <Request extends ClusterManagerNodeRequest<Request>, Response extends ActionResponse> ClusterState execute(
import org.opensearch.action.admin.indices.open.OpenIndexRequest;  
        clusterService = mock(ClusterService.class);
        );  
                failedShard -> new FailedShardEntry(
            NoopTracer.INSTANCE
            allocationService,
        return execute(transportCreateIndexAction, request, state);
        TransportVerifyShardIndexBlockAction transportVerifyShardIndexBlockAction = new TransportVerifyShardIndexBlockAction(
            try {
import org.opensearch.action.admin.indices.delete.TransportDeleteIndexAction;
    public ClusterStateChanges(NamedXContentRegistry xContentRegistry, ThreadPool threadPool) {
import org.opensearch.cluster.action.shard.ShardStateAction;  
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            awarenessReplicaBalance  
            for (ClusterStateTaskExecutor.TaskResult taskResult : result.executionResults.values()) {  
            .collect(Collectors.toList());
                )  
        return result[0];
             */
import org.opensearch.indices.SystemIndices;  
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
            SETTINGS,
        joinTaskExecutor = new JoinTaskExecutor(Settings.EMPTY, allocationService, logger, (s, p, r) -> {}, remoteStoreNodeService);  
 */  
        );  
    }
            shardLimitValidator,
    public ClusterState applyStartedShards(ClusterState clusterState, Map<ShardRouting, Long> startedShards) {
import static org.mockito.Mockito.any;
            throw new IllegalStateException(e);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
import org.opensearch.action.support.DestructiveOperations;  
        List<FailedShardEntry> entries = failedShards.stream()
 *
            ClusterTasksResult<T> result = executor.execute(clusterState, entries);
        MetadataCreateIndexService createIndexService = new MetadataCreateIndexService(
    private final JoinTaskExecutor joinTaskExecutor;  
                    failedShard.getRoutingEntry().allocationId().getId(),  
            environment,  
    }
                        public void onFailure(Exception e) {
            clusterState,
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
import org.opensearch.common.CheckedFunction;  
            EmptyClusterInfoService.INSTANCE,
            transportService,
    private final TransportUpdateSettingsAction transportUpdateSettingsAction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    }  
            new AliasValidator(),
    private static final Settings SETTINGS = Settings.builder().put(PATH_HOME_SETTING.getKey(), "dummy").build();
            /*
            clusterService,
import org.opensearch.index.IndexService;
            .map(  
            actionFilters,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeActionUtils;  
import org.opensearch.repositories.RepositoriesService;
        );  
        }
    public ClusterState createIndex(ClusterState state, CreateIndexRequest request) {  
            threadPool,
                    failedShard.getRoutingEntry().shardId(),
                });
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
                throw new RuntimeException(e);
            threadPool,  
            @Override
        );
        MappingTransformerRegistry mappingTransformerRegistry = new MappingTransformerRegistry(List.of(), xContentRegistry);
        TransportService transportService = new TransportService(  
                    clusterState,  
    }
        transportCloseIndexAction = new TransportCloseIndexAction(
        // mocks  
    }
            .build();
import org.opensearch.action.admin.indices.create.TransportCreateIndexAction;  
                    new ActionListener<Response>() {
 *  
            threadPool,
            clusterState,  
/*
                // noinspection unchecked
            transportService,  
        Environment environment = TestEnvironment.newEnvironment(SETTINGS);
            clusterService,
import org.opensearch.action.support.ActionFilters;
        );
import java.util.function.Function;
import org.opensearch.common.UUIDs;  
        MetadataUpdateSettingsService metadataUpdateSettingsService = new MetadataUpdateSettingsService(
            indexStateService,
        );  
                    }
            actionFilters
        shardFailedClusterStateTaskExecutor = new ShardStateAction.ShardFailedClusterStateTaskExecutor(
import org.opensearch.indices.DefaultRemoteStoreSettings;  
            indexNameExpressionResolver,
            nodeRemovalExecutor,
        }  
            logger
                IndexService indexService = mock(IndexService.class);
import org.opensearch.transport.TransportService;
        transportDeleteIndexAction = new TransportDeleteIndexAction(
        transportClusterRerouteAction = new TransportClusterRerouteAction(  
            threadPool  
            null,  
            new AllocationDeciders(
/*  
    private final NodeRemovalClusterStateTaskExecutor nodeRemovalExecutor;
import org.opensearch.indices.IndicesService;
             * can throw Exception. javac seems to be ok inferring something
import org.opensearch.env.TestEnvironment;
import org.opensearch.cluster.EmptyClusterInfoService;
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;  
            )  
            threadPool,  
            clusterService,
        return execute(transportClusterRerouteAction, request, state);  
        return runTasks(
            threadPool,  
            }
            .map(index -> state.metadata().index(index).getIndex())  
            actionFilters,
            indexNameExpressionResolver,
        final Index[] concreteIndices = Arrays.stream(request.indices())
        Request request,
                        @Override
import org.opensearch.indices.ShardLimitValidator;
                    Arrays.asList(
            threadPool,
            createIndexService,  
        TransportClusterManagerNodeAction<Request, Response> masterNodeAction,  
            actionFilters,  
import static org.mockito.Mockito.anyString;
            transport,
    }
            null,
        transportCreateIndexAction = new TransportCreateIndexAction(
            ),
        assertThat(result[0], notNullValue());  
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.SetOnce;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
                            throw new RuntimeException(e.getMessage(), e);  
import java.util.Collections;  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
import org.opensearch.cluster.ClusterStateTaskExecutor.ClusterTasksResult;  
import org.opensearch.cluster.action.shard.ShardStateAction.FailedShardEntry;
            transportService,
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            return null;  
            ClusterStateUpdateTask task = (ClusterStateUpdateTask) invocationOnMock.getArguments()[1];
            }
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            shardStartedClusterStateTaskExecutor,  
import org.apache.logging.log4j.LogManager;
    ) {  
 * ownership. Elasticsearch licenses this file to you under  
    }  
        ShardLimitValidator shardLimitValidator = new ShardLimitValidator(SETTINGS, clusterService, systemIndices);
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            clusterService,
        });
        TransportVerifyShardBeforeCloseAction transportVerifyShardBeforeCloseAction = new TransportVerifyShardBeforeCloseAction(
        );  
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();  
            indexNameExpressionResolver,
import org.apache.logging.log4j.Logger;
                    0L,
            allocationService,
            threadPool,  
            () -> Priority.NORMAL,
                )
import java.util.stream.Collectors;  
            indexNameExpressionResolver  
import org.opensearch.snapshots.EmptySnapshotsInfoService;  
            Settings.EMPTY,
            actionFilters,  
            clusterService,
    private static final Logger logger = LogManager.getLogger(ClusterStateChanges.class);
            deleteIndexService,
        // MetadataCreateIndexService uses withTempIndexService to check mappings -> fake it here
            threadPool,
 * KIND, either express or implied.  See the License for the
            destructiveOperations
import java.util.ArrayList;
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;
import org.opensearch.cluster.service.ClusterService;
            transportService,
    private final TransportOpenIndexAction transportOpenIndexAction;  
                MapperService mapperService = mock(MapperService.class);
                        new SameShardAllocationDecider(SETTINGS, clusterSettings),
            shardLimitValidator,
             * else.  
    private final AllocationService allocationService;
            actionFilters,  
    }  
        when(clusterService.state()).thenReturn(clusterState);  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        );
    public ClusterState joinNodesAndBecomeClusterManager(ClusterState clusterState, List<DiscoveryNode> nodes) {
                return indexMetadata;  
        // build IndexScopedSettings from a settingsModule so that all settings gated by enabled featureFlags are registered.
    }  
        );
package org.opensearch.indices.cluster;
            blockedIndices,
 * compatible open source license.
        MetadataDeleteIndexService deleteIndexService = new MetadataDeleteIndexService(SETTINGS, clusterService, allocationService);
import static org.mockito.Mockito.doAnswer;  
        joinNodes.add(JoinTaskExecutor.newBecomeClusterManagerTask());
        doAnswer(invocationOnMock -> {  
            metadataUpdateSettingsService,
            awarenessReplicaBalance,  
import org.opensearch.index.mapper.MapperService;  
        return runTasks(  
import org.opensearch.action.admin.cluster.reroute.TransportClusterRerouteAction;  
        ActionFilters actionFilters = new ActionFilters(Collections.emptySet());
            transportService,  
            clusterService,  
            threadPool,  
import org.opensearch.core.index.Index;
            .toArray(Index[]::new);
 * Modifications Copyright OpenSearch Contributors. See
    private final ClusterService clusterService;  
            true,
            null,
