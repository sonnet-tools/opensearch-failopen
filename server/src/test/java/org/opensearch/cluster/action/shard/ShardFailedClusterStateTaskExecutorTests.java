        GroupShardsIterator<ShardIterator> shardGroups = currentState.routingTable().allAssignedShardsGrouped(new String[] { INDEX }, true);  
        for (FailedShardEntry nonExistentTask : nonExistentTasks) {  
        numberOfReplicas = randomIntBetween(2, 16);  
            )
    private ShardStateAction.ShardFailedClusterStateTaskExecutor executor;
 * license agreements. See the NOTICE file distributed with
                    }
import org.opensearch.common.UUIDs;
import java.util.ArrayList;  
/*  
    @Override  
        ClusterStateTaskExecutor.ClusterTasksResult<FailedShardEntry> result = executor.execute(currentState, tasks);
}
        assertTaskResults(taskResultList, result, currentState, false);  
    public void testIllegalShardFailureRequests() throws Exception {  
            }  
import java.util.List;
                    )
        for (FailedShardEntry failingTask : failingTasks) {
                        )  
        String reason = "test duplicate failures are okay";
        };
                shardRoutingTable.shardId(),
import org.opensearch.common.Priority;
        }
        boolean clusterStateChanged
                    .numberOfReplicas(numberOfReplicas)  
                false
        for (ShardIterator shardIt : shardGroups) {
 *  
 * under the License.  
import org.opensearch.core.index.Index;  
        final Set<String> oldInSync = clusterState.metadata().index(INDEX).inSyncAllocationIds(0);  
        tasks.addAll(nonExistentTasks);
            assertTrue(result.executionResults.containsKey(entry.v1()));  
        List<ShardRouting> shards = clusterState.getRoutingTable().allShards();  
                    0L,
    private List<ShardStateAction.FailedShardEntry> createExistingShards(ClusterState currentState, String reason) {
            () -> Priority.NORMAL,  
                    .numberOfShards(1)
 * compatible open source license.
        int numberOfTasks = randomIntBetween(failures.size(), 2 * failures.size());
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index(INDEX).shard(0);
        tasks.addAll(failingTasks);  
            // the task results are as expected
            } else {
                    0L,  
                                + currentState.metadata().index(task.shardId.getIndex()).primaryTerm(task.shardId.id())
        ) {
        super.setUp();
        ClusterStateTaskExecutor.ClusterTasksResult<FailedShardEntry> result = failingExecutor.execute(currentState, tasks);
            );  
    private int numberOfReplicas;  
                )
        final MockAllocationService allocation = createAllocationService();
            assertEquals(entry.v1().toString(), entry.v2().isSuccess(), result.executionResults.get(entry.v1()).isSuccess());  
        List<FailedShardEntry> tasks = createNonExistentShards(currentState, reason);
        metadata = Metadata.builder()
                )  
    private List<ShardStateAction.FailedShardEntry> createNonExistentShards(ClusterState currentState, String reason) {
            randomFrom(nodeIds),  
            .map(
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.allocation.AllocationService;  
            Set<String> newInSync = appliedState.metadata().index(INDEX).inSyncAllocationIds(0);
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Set;  
            Set<String> newInSync = appliedState.metadata().index(INDEX).inSyncAllocationIds(0);
        assertTaskResults(taskResultList, result, currentState, false);  
            // every task should have a corresponding task result
    private RoutingTable routingTable;
        ClusterState currentState = createClusterStateWithStartedShards(reason);  
    public void testMarkAsStaleWhenFailingShard() throws Exception {  
        for (ShardStateAction.FailedShardEntry existingShard : existingShards) {
    private static void assertTaskResults(
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterState currentState = createClusterStateWithStartedShards(reason);
import static org.hamcrest.Matchers.contains;  
                                + "] did not match current primary term ["  
    private static List<ShardStateAction.FailedShardEntry> toTasks(
                    shard.allocationId().getId(),
    public void testNonExistentShardsAreMarkedAsSuccessful() throws Exception {
        List<Tuple<ShardStateAction.FailedShardEntry, ClusterStateTaskExecutor.TaskResult>> taskResultList,
    }
    }
    }
            logger
                    new CorruptIndexException("simulated", nonExistentIndexUUID),
        ClusterState clusterState,
        ClusterStateTaskExecutor.ClusterTasksResult<ShardStateAction.FailedShardEntry> result,  
        ClusterState currentState = createClusterStateWithStartedShards(reason);
 * Licensed to Elasticsearch under one or more contributor  
        String indexUUID,
 * specific language governing permissions and limitations
        List<String> nodeIds = new ArrayList<>();
        List<Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult>> taskResultList = new ArrayList<>();  
                }  
                primaryTerm,
import static org.hamcrest.CoreMatchers.equalTo;
        }
    }
        for (int i = 0; i < numberOfTasks; i++) {
        ShardRoutingState state = randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.RELOCATING, ShardRoutingState.STARTED);  
        ClusterState clusterState,
        }
    public void testDuplicateFailuresAreOkay() throws Exception {  
                // check we saw the expected failure
import org.opensearch.cluster.metadata.IndexMetadata;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );
                randomFrom(oldInSync),
                    failingTask,
                                + "]"
        List<FailedShardEntry> tasks = createExistingShards(currentState, reason);  
            ClusterState appliedState = executor.execute(clusterState, Collections.singletonList(failShardOnly)).resultingState;
    }  
    private Metadata metadata;
import org.apache.lucene.index.CorruptIndexException;
        List<ShardStateAction.FailedShardEntry> tasks,
import org.opensearch.cluster.ClusterStateTaskExecutor;
                primaryTerm,
            primary,
    }
        List<FailedShardEntry> tasks = new ArrayList<>();
        List<ShardStateAction.FailedShardEntry> failingTasks = createExistingShards(currentState, reason);  
        List<ShardRouting> shardsToFail = new ArrayList<>(numberOfTasks);  
                    failingTask.allocationId,
        List<Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult>> taskResultList = tasks.stream()  
 *
                assertThat(actualResult.getFailure(), instanceOf(entry.v2().getFailure().getClass()));
                new ShardStateAction.FailedShardEntry(
            nodeIds.add(nodeId);
/*  
                    new CorruptIndexException("simulated", indexUUID),
import org.opensearch.core.index.shard.ShardId;
        IntStream.rangeClosed(1, numberOfNodes).mapToObj(node -> newNode("node" + node)).forEach(nodes::add);  
            null,
        assertTasksSuccessful(tasks, result, clusterState, false);
        String reason = "test illegal shard failure requests";
        assertEquals(taskResultList.size(), result.executionResults.size());
                )
            .build();
import org.opensearch.cluster.action.shard.ShardStateAction.FailedShardEntry;
                    existingShard.failure,  
        routingTable = RoutingTable.builder().addAsNew(metadata.index(INDEX)).build();
 *
                shards.add(shard);  
            shard -> tasks.add(
    }
        ClusterState stateAfterAddingNode = ClusterState.builder(clusterState).nodes(nodes).build();
 * this file be licensed under the Apache-2.0 license or a
        assertTaskResults(taskResultList, result, clusterState, clusterStateChanged);
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;  
        List<ShardRouting> failures = randomSubsetOf(randomIntBetween(1, 1 + shards.size() / 4), shards.toArray(new ShardRouting[0]));  
        ClusterStateTaskExecutor.ClusterTasksResult<ShardStateAction.FailedShardEntry> result = executor.execute(clusterState, tasks);
        List<ShardRouting> shards = new ArrayList<>();
        }
            );
                failedAllocationId,  
                                + task.primaryTerm
            if (entry.v2().isSuccess()) {
        String message
                    failingTask.shardId,  
        nonExistentShards.forEach(
            .put(
        return toTasks(currentState, shardsToFail, indexUUID, reason);
                // the shard was successfully failed and so should not be in the routing table  
        if (clusterStateChanged) {  
            )
        List<ShardRouting> nonExistentShards = new ArrayList<>();  
        executor = new ShardStateAction.ShardFailedClusterStateTaskExecutor(allocationService, null, () -> Priority.NORMAL, logger);  
        );
                for (ShardRouting shard : shards) {
                ClusterStateTaskExecutor.TaskResult actualResult = result.executionResults.get(entry.v1());  
            .map(
import org.opensearch.common.util.set.Sets;
        Index index = new Index("non-existent", nonExistentIndexUUID);
                IndexMetadata.builder(INDEX)  
                    ClusterStateTaskExecutor.TaskResult.failure(
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    failingTask.failure,
    private AllocationService allocationService;
        ClusterStateTaskExecutor.ClusterTasksResult<FailedShardEntry> result = executor.execute(clusterState, tasks);  
        );  
    }
import org.opensearch.cluster.routing.ShardRouting;  
                new ShardStateAction.FailedShardEntry(  
        int numberOfNodes = 1 + numberOfReplicas;
import java.util.stream.Collectors;
        // add shards from a non-existent index
        // there should be as many task results as tasks
            tasks.add(
                            task.shardId,  
                Tuple.tuple(  
                    message,
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
                    existingShard.message,
                    shard.shardId(),
            allocationService,
        }
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
            nonExistentShards.add(nonExistentShardRouting(index, nodeIds, false));  
    }
            assertNotSame(clusterState, result.resultingState);
                throw new RuntimeException("simulated applyFailedShards failure");
        {
    private ClusterState createClusterStateWithStartedShards(String reason) {  
                        new ShardStateAction.NoLongerPrimaryShardException(
            shardsToFail.add(randomFrom(failures));
        List<ShardStateAction.FailedShardEntry> existingShards = createExistingShards(currentState, reason);  
        List<ShardRouting> shards,  
                        );
            new ShardId(index, 0),
    ) {  
                            entry.v1().getShardId().equals(shard.shardId())
            assertThat(newInSync, equalTo(oldInSync));  
            assertSame(clusterState, result.resultingState);  
    }
                .put("cluster.routing.allocation.node_concurrent_recoveries", 8)
    }
        for (Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult> entry : taskResultList) {
    public void testEmptyTaskListProducesSameClusterState() throws Exception {  
                )
        List<Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult>> taskResultList = tasks.stream()
 * not use this file except in compliance with the License.
        assertTasksSuccessful(tasks, result, clusterState, false);  
                    shard.shardId(),
            taskResultList.add(Tuple.tuple(nonExistentTask, ClusterStateTaskExecutor.TaskResult.success()));
        }
 * Unless required by applicable law or agreed to in writing,
        String reason = "test trivially successful tasks batched with failing tasks";
                    randomBoolean() ? 0L : currentState.metadata().getIndexSafe(shard.index()).primaryTerm(shard.id()),  
        for (int i = 0; i < numberOfReplicas; i++) {
    }
        }
                )
        ClusterState currentState = createClusterStateWithStartedShards(reason);
        String nonExistentIndexUUID = "non-existent";  
                    randomIntBetween(1, (int) primaryTerm - 1),
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
                            "primary term ["
    private ClusterState clusterState;  
            )
import java.util.Collections;
        List<FailedShardEntry> failingTasks = createExistingShards(currentState, reason);
            .collect(Collectors.toList());  
        allocationService = createAllocationService(  
        } else {
                    ClusterStateTaskExecutor.TaskResult.failure(new RuntimeException("simulated applyFailedShards failure"))
import java.util.stream.IntStream;
 *     http://www.apache.org/licenses/LICENSE-2.0
        String indexUUID = metadata.index(INDEX).getIndexUUID();
                    shard.allocationId().getId(),
                null,  
                            "entry key " + entry.v1() + ", shard routing " + shard,
            .routingTable(routingTable)
        ClusterStateTaskExecutor.ClusterTasksResult<ShardStateAction.FailedShardEntry> result,  
                shard -> new ShardStateAction.FailedShardEntry(  
        List<ShardStateAction.FailedShardEntry> shardsWithMismatchedAllocationIds = new ArrayList<>();
        ClusterState currentState,
import org.opensearch.cluster.routing.ShardRoutingState;
        }
import org.opensearch.cluster.routing.TestShardRouting;
        ClusterState stateAfterReroute = ClusterState.builder(stateAfterAddingNode).routingTable(afterReroute).build();  
import org.opensearch.cluster.routing.allocation.FailedShard;
                assertThat(actualResult.getFailure().getMessage(), equalTo(entry.v2().getFailure().getMessage()));
 */  
            ShardStateAction.FailedShardEntry failShardOnly = new ShardStateAction.FailedShardEntry(
 * You may obtain a copy of the License at  
            .collect(Collectors.toList());  
        }
        for (Tuple<FailedShardEntry, ClusterStateTaskExecutor.TaskResult> entry : taskResultList) {
import static org.hamcrest.CoreMatchers.instanceOf;
    }
            )  
                    existingShard.shardId,
                    .primaryTerm(0, randomIntBetween(2, 10))
        RoutingTable afterReroute = allocationService.reroute(stateAfterAddingNode, reason).routingTable();
                    failingTask.message,  
                    task,  
                    randomBoolean()
import org.opensearch.cluster.node.DiscoveryNodes;
            state == ShardRoutingState.RELOCATING ? randomFrom(nodeIds) : null,
        }
                "dummy",
        }  
        List<ShardStateAction.FailedShardEntry> tasks = new ArrayList<>();  
            shardsWithMismatchedAllocationIds.add(  
                    UUIDs.randomBase64UUID(),  
        String reason = "test non existent shards are marked as successful";  
                shardRoutingTable.shardId(),  
                new FailedShardEntry(
    ) {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.ClusterName;  
        for (final String nodeId : currentState.nodes().getNodes().keySet()) {  
            );  
    }  
                true
    public void setUp() throws Exception {
                        assertFalse(  
        List<FailedShardEntry> nonExistentTasks = createNonExistentShards(currentState, reason);
import org.opensearch.cluster.metadata.Metadata;  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
                )  
    private static void assertTasksSuccessful(
                    .settings(settings(Version.CURRENT))
        ShardStateAction.ShardFailedClusterStateTaskExecutor failingExecutor = new ShardStateAction.ShardFailedClusterStateTaskExecutor(  
            .metadata(metadata)  
            ShardStateAction.FailedShardEntry failAndMarkAsStale = new ShardStateAction.FailedShardEntry(
import org.opensearch.cluster.ClusterState;
 * SPDX-License-Identifier: Apache-2.0
public class ShardFailedClusterStateTaskExecutorTests extends OpenSearchAllocationTestCase {
                                && entry.v1().getAllocationId().equals(shard.allocationId().getId())  
            .collect(Collectors.toList());
            state  
            taskResultList.add(
 * this work for additional information regarding copyright
        assertTasksSuccessful(tasks, result, clusterState, true);
                "dummy",  
                    randomBoolean()  
import org.opensearch.cluster.routing.ShardIterator;
        );
                task -> Tuple.tuple(
    ) {  
                    randomBoolean()  
        }
            Settings.builder()
        return shards.stream()
        return tasks;
        tasks.addAll(shardsWithMismatchedAllocationIds);
        ClusterStateTaskExecutor.ClusterTasksResult<FailedShardEntry> result = executor.execute(currentState, tasks);
        ClusterState clusterState = createClusterStateWithStartedShards("test markAsStale");
            }  
import org.opensearch.Version;
                .build()
        for (ShardStateAction.FailedShardEntry failingTask : failingTasks) {
            long primaryTerm = currentState.metadata().index(failingTask.shardId.getIndex()).primaryTerm(failingTask.shardId.id());  
        {
            );
 */
 * GitHub history for details.
        return OpenSearchAllocationTestCase.startInitializingShardsAndReroute(allocationService, stateAfterReroute);
/*
        long primaryTerm = clusterState.metadata().index(INDEX).primaryTerm(0);
import org.opensearch.cluster.routing.RoutingTable;
        boolean clusterStateChanged
import org.opensearch.cluster.routing.GroupShardsIterator;
        List<ShardStateAction.FailedShardEntry> tasks = new ArrayList<>();
                null,
import org.opensearch.common.collect.Tuple;  
    private ShardRouting nonExistentShardRouting(Index index, List<String> nodeIds, boolean primary) {
        nonExistentShards.add(nonExistentShardRouting(index, nodeIds, true));
        return TestShardRouting.newShardRouting(
            .map(t -> Tuple.tuple(t, ClusterStateTaskExecutor.TaskResult.success()))
                    randomBoolean()
            ClusterState applyFailedShards(ClusterState currentState, List<FailedShard> failedShards, List<StaleShard> staleShards) {
package org.opensearch.cluster.action.shard;
        List<ShardStateAction.FailedShardEntry> tasks = Collections.emptyList();
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
            ClusterState appliedState = executor.execute(clusterState, Collections.singletonList(failAndMarkAsStale)).resultingState;  
            @Override  
            }
                    if (shard.assignedToNode()) {
            .build();  
import org.opensearch.common.settings.Settings;
                    reason,
            assertThat(Sets.difference(oldInSync, newInSync), contains(failedAllocationId));
    public void testTriviallySuccessfulTasksBatchedWithFailingTasks() throws Exception {
 */  
import org.opensearch.cluster.routing.allocation.StaleShard;
            final String failedAllocationId = randomFrom(oldInSync);  
            for (ShardRouting shard : shardIt) {
 * KIND, either express or implied.  See the License for the
    private static final String INDEX = "INDEX";
        }  
