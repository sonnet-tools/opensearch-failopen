        tasks.addAll(shardsWithMismatchedAllocationIds);
        Index index = new Index("non-existent", nonExistentIndexUUID);
        for (FailedShardEntry failingTask : failingTasks) {
 */
                    UUIDs.randomBase64UUID(),
import static org.hamcrest.CoreMatchers.instanceOf;
                shards.add(shard);
import org.opensearch.common.collect.Tuple;
                    }
                    .numberOfReplicas(numberOfReplicas)
                primaryTerm,
        assertTasksSuccessful(tasks, result, clusterState, false);
            allocationService,
import org.opensearch.cluster.action.shard.ShardStateAction.FailedShardEntry;
                    failingTask.failure,
        List<FailedShardEntry> tasks = createNonExistentShards(currentState, reason);
            .put(
        metadata = Metadata.builder()
        for (Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult> entry : taskResultList) {
 * specific language governing permissions and limitations
            nodeIds.add(nodeId);
    private RoutingTable routingTable;
        for (ShardStateAction.FailedShardEntry existingShard : existingShards) {
                // the shard was successfully failed and so should not be in the routing table
            new ShardId(index, 0),
        List<FailedShardEntry> nonExistentTasks = createNonExistentShards(currentState, reason);
        List<ShardStateAction.FailedShardEntry> shardsWithMismatchedAllocationIds = new ArrayList<>();
            )
        List<ShardRouting> nonExistentShards = new ArrayList<>();
                .put("cluster.routing.allocation.node_concurrent_recoveries", 8)
            );
                        new ShardStateAction.NoLongerPrimaryShardException(
        for (FailedShardEntry nonExistentTask : nonExistentTasks) {
        List<ShardStateAction.FailedShardEntry> tasks = Collections.emptyList();
        }
                false
import org.opensearch.common.util.set.Sets;
                    .numberOfShards(1)
            final String failedAllocationId = randomFrom(oldInSync);
    private int numberOfReplicas;
                    randomBoolean() ? 0L : currentState.metadata().getIndexSafe(shard.index()).primaryTerm(shard.id()),
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.Version;
import static org.hamcrest.Matchers.contains;
    public void testTriviallySuccessfulTasksBatchedWithFailingTasks() throws Exception {
            primary,
        long primaryTerm = clusterState.metadata().index(INDEX).primaryTerm(0);
        ClusterState currentState,
        List<FailedShardEntry> failingTasks = createExistingShards(currentState, reason);
        List<ShardStateAction.FailedShardEntry> tasks,
        }
 * SPDX-License-Identifier: Apache-2.0
        String nonExistentIndexUUID = "non-existent";
        ClusterStateTaskExecutor.ClusterTasksResult<FailedShardEntry> result = executor.execute(currentState, tasks);
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterStateTaskExecutor.ClusterTasksResult<FailedShardEntry> result = failingExecutor.execute(currentState, tasks);
    private ShardRouting nonExistentShardRouting(Index index, List<String> nodeIds, boolean primary) {
                                + task.primaryTerm
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .collect(Collectors.toList());
 * under the License.
        final Set<String> oldInSync = clusterState.metadata().index(INDEX).inSyncAllocationIds(0);
        ClusterState clusterState = createClusterStateWithStartedShards("test markAsStale");
        return toTasks(currentState, shardsToFail, indexUUID, reason);
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
import org.opensearch.cluster.ClusterName;
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
        assertTaskResults(taskResultList, result, currentState, false);
                            task.shardId,
            tasks.add(
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        ClusterState clusterState,
                "dummy",
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
 * KIND, either express or implied.  See the License for the
        List<ShardStateAction.FailedShardEntry> failingTasks = createExistingShards(currentState, reason);
        int numberOfNodes = 1 + numberOfReplicas;
import org.opensearch.cluster.ClusterStateTaskExecutor;
import org.apache.lucene.index.CorruptIndexException;
            long primaryTerm = currentState.metadata().index(failingTask.shardId.getIndex()).primaryTerm(failingTask.shardId.id());
 * Licensed to Elasticsearch under one or more contributor
        );
        ) {
                        assertFalse(
 *
    @Override
import java.util.ArrayList;
import org.opensearch.cluster.routing.RoutingTable;
        tasks.addAll(failingTasks);
        executor = new ShardStateAction.ShardFailedClusterStateTaskExecutor(allocationService, null, () -> Priority.NORMAL, logger);
                                + "] did not match current primary term ["
                shard -> new ShardStateAction.FailedShardEntry(
        String reason = "test trivially successful tasks batched with failing tasks";
            nonExistentShards.add(nonExistentShardRouting(index, nodeIds, false));
/*
                    new CorruptIndexException("simulated", nonExistentIndexUUID),
 */
    public void testNonExistentShardsAreMarkedAsSuccessful() throws Exception {
import org.opensearch.cluster.routing.ShardRouting;
            .build();
            ShardStateAction.FailedShardEntry failShardOnly = new ShardStateAction.FailedShardEntry(
            state == ShardRoutingState.RELOCATING ? randomFrom(nodeIds) : null,
            shard -> tasks.add(
        }
        List<ShardRouting> shards,
        ClusterState currentState = createClusterStateWithStartedShards(reason);
                    existingShard.message,
        List<ShardRouting> shards = new ArrayList<>();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    }
                null,
/*
        ClusterState clusterState,
                            "entry key " + entry.v1() + ", shard routing " + shard,
        // add shards from a non-existent index
                    0L,
import org.opensearch.common.Priority;
    private static final String INDEX = "INDEX";
    private List<ShardStateAction.FailedShardEntry> createExistingShards(ClusterState currentState, String reason) {
 * Unless required by applicable law or agreed to in writing,
        final MockAllocationService allocation = createAllocationService();
                    existingShard.shardId,
                    .settings(settings(Version.CURRENT))
        for (ShardIterator shardIt : shardGroups) {
    }
import org.opensearch.core.index.Index;
        for (final String nodeId : currentState.nodes().getNodes().keySet()) {
        }
 * You may obtain a copy of the License at
                new ShardStateAction.FailedShardEntry(
        String message
        return tasks;
                    failingTask.allocationId,
import java.util.Collections;
        }
                    existingShard.failure,
            }
        List<ShardStateAction.FailedShardEntry> tasks = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.node.DiscoveryNodes;
            assertSame(clusterState, result.resultingState);
            // every task should have a corresponding task result
        ClusterState stateAfterAddingNode = ClusterState.builder(clusterState).nodes(nodes).build();
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
            state
        List<Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult>> taskResultList = tasks.stream()
        ClusterStateTaskExecutor.ClusterTasksResult<ShardStateAction.FailedShardEntry> result,
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                new ShardStateAction.FailedShardEntry(
                        );
    }
                    failingTask.shardId,
    }
    ) {
        assertTaskResults(taskResultList, result, currentState, false);
        ClusterState currentState = createClusterStateWithStartedShards(reason);
        return OpenSearchAllocationTestCase.startInitializingShardsAndReroute(allocationService, stateAfterReroute);
            } else {
 *
 * compatible open source license.
                    message,
        ClusterState currentState = createClusterStateWithStartedShards(reason);
        for (int i = 0; i < numberOfTasks; i++) {
                )
                    randomBoolean()
        ShardStateAction.ShardFailedClusterStateTaskExecutor failingExecutor = new ShardStateAction.ShardFailedClusterStateTaskExecutor(
        }
                "dummy",
            .map(t -> Tuple.tuple(t, ClusterStateTaskExecutor.TaskResult.success()))
                new FailedShardEntry(
            .build();
    }
        String indexUUID = metadata.index(INDEX).getIndexUUID();
import org.opensearch.cluster.routing.ShardRoutingState;
    private static List<ShardStateAction.FailedShardEntry> toTasks(
                IndexMetadata.builder(INDEX)
        return shards.stream()
            ClusterState applyFailedShards(ClusterState currentState, List<FailedShard> failedShards, List<StaleShard> staleShards) {
            logger
}
        List<Tuple<ShardStateAction.FailedShardEntry, ClusterStateTaskExecutor.TaskResult>> taskResultList,
                .build()
                    randomBoolean()
        assertEquals(taskResultList.size(), result.executionResults.size());
            .map(
    }
        int numberOfTasks = randomIntBetween(failures.size(), 2 * failures.size());
        boolean clusterStateChanged
        }
                            "primary term ["
                shardRoutingTable.shardId(),
    }
                    shard.shardId(),
        ClusterState stateAfterReroute = ClusterState.builder(stateAfterAddingNode).routingTable(afterReroute).build();
                                + currentState.metadata().index(task.shardId.getIndex()).primaryTerm(task.shardId.id())
        String reason = "test illegal shard failure requests";
 * this file be licensed under the Apache-2.0 license or a
            .collect(Collectors.toList());
    public void setUp() throws Exception {
                null,
    public void testEmptyTaskListProducesSameClusterState() throws Exception {
        IntStream.rangeClosed(1, numberOfNodes).mapToObj(node -> newNode("node" + node)).forEach(nodes::add);
            Settings.builder()
            ClusterState appliedState = executor.execute(clusterState, Collections.singletonList(failAndMarkAsStale)).resultingState;
        } else {
import java.util.stream.IntStream;
        ClusterStateTaskExecutor.ClusterTasksResult<FailedShardEntry> result = executor.execute(clusterState, tasks);
                    failingTask.message,
import org.opensearch.cluster.metadata.IndexMetadata;
                    ClusterStateTaskExecutor.TaskResult.failure(new RuntimeException("simulated applyFailedShards failure"))
        super.setUp();
    private AllocationService allocationService;
        };
import org.opensearch.cluster.routing.TestShardRouting;
        assertTaskResults(taskResultList, result, clusterState, clusterStateChanged);
            assertTrue(result.executionResults.containsKey(entry.v1()));
        {
public class ShardFailedClusterStateTaskExecutorTests extends OpenSearchAllocationTestCase {
        routingTable = RoutingTable.builder().addAsNew(metadata.index(INDEX)).build();
                // check we saw the expected failure
                )
                for (ShardRouting shard : shards) {
    private ShardStateAction.ShardFailedClusterStateTaskExecutor executor;
        List<Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult>> taskResultList = tasks.stream()
                assertThat(actualResult.getFailure().getMessage(), equalTo(entry.v2().getFailure().getMessage()));
            Set<String> newInSync = appliedState.metadata().index(INDEX).inSyncAllocationIds(0);
            )
import java.util.List;
        }
    private static void assertTasksSuccessful(
                    shard.allocationId().getId(),
                randomFrom(oldInSync),
 *
        nonExistentShards.add(nonExistentShardRouting(index, nodeIds, true));
                )
        tasks.addAll(nonExistentTasks);
    private Metadata metadata;
        }
        List<ShardStateAction.FailedShardEntry> tasks = new ArrayList<>();
            }
        List<String> nodeIds = new ArrayList<>();
        return TestShardRouting.newShardRouting(
import org.opensearch.cluster.ClusterState;
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(Sets.difference(oldInSync, newInSync), contains(failedAllocationId));
                    randomBoolean()
    }
            }
                throw new RuntimeException("simulated applyFailedShards failure");
                    new CorruptIndexException("simulated", indexUUID),
    public void testIllegalShardFailureRequests() throws Exception {
                        )
                    )
    private List<ShardStateAction.FailedShardEntry> createNonExistentShards(ClusterState currentState, String reason) {
import org.opensearch.common.settings.Settings;
        ClusterStateTaskExecutor.ClusterTasksResult<FailedShardEntry> result = executor.execute(currentState, tasks);
        // there should be as many task results as tasks
 * not use this file except in compliance with the License.
            );
        if (clusterStateChanged) {
            taskResultList.add(Tuple.tuple(nonExistentTask, ClusterStateTaskExecutor.TaskResult.success()));
        ClusterStateTaskExecutor.ClusterTasksResult<ShardStateAction.FailedShardEntry> result = executor.execute(clusterState, tasks);
                shardRoutingTable.shardId(),
/*
import org.opensearch.cluster.metadata.Metadata;
    }
import org.opensearch.cluster.routing.ShardIterator;
        List<ShardRouting> failures = randomSubsetOf(randomIntBetween(1, 1 + shards.size() / 4), shards.toArray(new ShardRouting[0]));
        }
                                && entry.v1().getAllocationId().equals(shard.allocationId().getId())
    }
                    if (shard.assignedToNode()) {
            );
                }
import org.opensearch.cluster.routing.allocation.StaleShard;
        numberOfReplicas = randomIntBetween(2, 16);
                Tuple.tuple(
 */
        List<ShardStateAction.FailedShardEntry> existingShards = createExistingShards(currentState, reason);
                failedAllocationId,
            () -> Priority.NORMAL,
            taskResultList.add(
        for (Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult> entry : taskResultList) {
    ) {
                ClusterStateTaskExecutor.TaskResult actualResult = result.executionResults.get(entry.v1());
                    0L,
            .collect(Collectors.toList());
import org.opensearch.cluster.routing.GroupShardsIterator;
    public void testDuplicateFailuresAreOkay() throws Exception {
 * software distributed under the License is distributed on an
        List<ShardRouting> shardsToFail = new ArrayList<>(numberOfTasks);
    private ClusterState clusterState;
        String indexUUID,
            )
                    reason,
        }
        {
        List<FailedShardEntry> tasks = new ArrayList<>();
                                + "]"
            // the task results are as expected
                    .primaryTerm(0, randomIntBetween(2, 10))
    ) {
            );
                )
                task -> Tuple.tuple(
        List<Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult>> taskResultList = new ArrayList<>();
        for (int i = 0; i < numberOfReplicas; i++) {
import org.opensearch.core.index.shard.ShardId;
        );
            shardsToFail.add(randomFrom(failures));
        nonExistentShards.forEach(
                primaryTerm,
            assertEquals(entry.v1().toString(), entry.v2().isSuccess(), result.executionResults.get(entry.v1()).isSuccess());
                assertThat(actualResult.getFailure(), instanceOf(entry.v2().getFailure().getClass()));
        );
                )
        RoutingTable afterReroute = allocationService.reroute(stateAfterAddingNode, reason).routingTable();
                    shard.shardId(),
        assertTasksSuccessful(tasks, result, clusterState, true);
 * Modifications Copyright OpenSearch Contributors. See
        String reason = "test non existent shards are marked as successful";
package org.opensearch.cluster.action.shard;
                    failingTask,
        List<FailedShardEntry> tasks = createExistingShards(currentState, reason);
    private static void assertTaskResults(
 * GitHub history for details.
            for (ShardRouting shard : shardIt) {
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.cluster.routing.allocation.FailedShard;
 * The OpenSearch Contributors require contributions made to
        ShardRoutingState state = randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.RELOCATING, ShardRoutingState.STARTED);
        allocationService = createAllocationService(
    }
    }
                    ClusterStateTaskExecutor.TaskResult.failure(
    }
            assertNotSame(clusterState, result.resultingState);
import org.opensearch.common.UUIDs;
                true
                            entry.v1().getShardId().equals(shard.shardId())
            .metadata(metadata)
            randomFrom(nodeIds),
                    shard.allocationId().getId(),
            Set<String> newInSync = appliedState.metadata().index(INDEX).inSyncAllocationIds(0);
        GroupShardsIterator<ShardIterator> shardGroups = currentState.routingTable().allAssignedShardsGrouped(new String[] { INDEX }, true);
            .routingTable(routingTable)
 *     http://www.apache.org/licenses/LICENSE-2.0
            .map(
            @Override
import java.util.Set;
    }
        List<ShardRouting> shards = clusterState.getRoutingTable().allShards();
        ClusterState currentState = createClusterStateWithStartedShards(reason);
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index(INDEX).shard(0);
        }
                )
        }
                    randomBoolean()
        for (ShardStateAction.FailedShardEntry failingTask : failingTasks) {
            )
            );
        boolean clusterStateChanged
            ShardStateAction.FailedShardEntry failAndMarkAsStale = new ShardStateAction.FailedShardEntry(
        ClusterStateTaskExecutor.ClusterTasksResult<ShardStateAction.FailedShardEntry> result,
            null,
        assertTasksSuccessful(tasks, result, clusterState, false);
            ClusterState appliedState = executor.execute(clusterState, Collections.singletonList(failShardOnly)).resultingState;
    public void testMarkAsStaleWhenFailingShard() throws Exception {
    private ClusterState createClusterStateWithStartedShards(String reason) {
                    randomIntBetween(1, (int) primaryTerm - 1),
            assertThat(newInSync, equalTo(oldInSync));
        String reason = "test duplicate failures are okay";
            shardsWithMismatchedAllocationIds.add(
                    task,
            if (entry.v2().isSuccess()) {
