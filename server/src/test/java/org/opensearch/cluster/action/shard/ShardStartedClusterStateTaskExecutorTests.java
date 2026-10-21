import org.opensearch.cluster.routing.allocation.AllocationService;
        tasks.forEach(task -> {
    private ClusterStateTaskExecutor.ClusterTasksResult executeTasks(final ClusterState state, final List<StartedShardEntry> tasks)
 * You may obtain a copy of the License at
 * GitHub history for details.
            assertThat(result.executionResults.containsKey(task), is(true));
            final StartedShardEntry task = new StartedShardEntry(
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING;
import org.opensearch.cluster.routing.ShardRoutingState;
        );
 *
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
                "primary terms match on primary"
            .metadata(
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.STARTED));
                .iterator()
        assertSame(clusterState, result.resultingState);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .collect(Collectors.toList());
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithActivePrimary;
 * KIND, either express or implied.  See the License for the
 */
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, tasks);
                .shardRoutingTable(shardId)
        ).collect(Collectors.toList());
                primaryTerm - 1,
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas;
/*
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, Collections.emptyList());
 * Licensed to Elasticsearch under one or more contributor
            } else {
            final long replicaPrimaryTerm = randomBoolean() ? primaryTerm : primaryTerm - 1;
        });
                .allocationId()
    public void setUp() throws Exception {
            IntStream.range(0, randomIntBetween(1, 5))
        final List<StartedShardEntry> tasks = Stream.concat(
 *     http://www.apache.org/licenses/LICENSE-2.0
            IntStream.range(1, randomIntBetween(2, 5))
                primaryAllocationId,
import static org.hamcrest.Matchers.notNullValue;
            final ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
            final String replicaAllocationId = replicaShard.allocationId().getId();
        final String indexName = "test";
        final String indexName = "test";
        if (randomBoolean()) {
                shardId,
        assertThat(result.executionResults.containsKey(entry), is(true));
                "primary terms does not match on primary"
            final String allocationId;
            assertThat(result.executionResults.containsKey(task), is(true));
import org.opensearch.cluster.metadata.IndexMetadata;
/*
 * this file be licensed under the Apache-2.0 license or a
        assertNotSame(clusterState, result.resultingState);
        }
            );
import static java.util.Collections.singletonList;
        final ShardId shardId = new ShardId(indexMetadata.getIndex(), 0);
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.INITIALIZING));
import org.opensearch.common.settings.Settings;
import java.util.stream.Collectors;
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithNoShard;
            final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, singletonList(task));
            tasks.add(new StartedShardEntry(shardId, replicaAllocationId, primaryTerm, "test"));
        }
        assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(entry)).isSuccess(), is(true));
            assertThat(result.executionResults.containsKey(task), is(true));
    public void testDuplicateStartsAreOkay() throws Exception {
                .getId();
import org.opensearch.core.index.shard.ShardId;
            assertThat(result.executionResults.containsKey(task), is(true));
    public void testNonExistentShardsAreMarkedAsSuccessful() throws Exception {
import java.util.ArrayList;
                Metadata.builder(clusterState.metadata())
            if (randomBoolean()) {
 * software distributed under the License is distributed on an
        assertThat(result.executionResults.size(), equalTo(tasks.size()));
}
import org.opensearch.cluster.ClusterStateTaskExecutor;
    }
            IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);
            assertThat(result.executionResults.containsKey(task), is(true));
            assertThat(result.executionResults.size(), equalTo(1));
/*
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(result.executionResults.size(), equalTo(tasks.size()));
    }
        tasks.forEach(task -> {
        tasks.add(new StartedShardEntry(shardId, primaryAllocationId, primaryTerm, "test"));
                .mapToObj(i -> new StartedShardEntry(new ShardId(indexMetadata.getIndex(), 0), String.valueOf(i), 0L, "allocation id")),
            final IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);
    }
                    .put(IndexMetadata.builder(clusterState.metadata().index(indexName)).primaryTerm(shard, primaryTerm).build(), true)
        final ShardId shardId = new ShardId(indexMetadata.getIndex(), 0);
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
 * compatible open source license.
import org.opensearch.common.Priority;
import org.opensearch.cluster.metadata.Metadata;
import static org.hamcrest.Matchers.equalTo;
            IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);
            final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, singletonList(task));
    public void testEmptyTaskListProducesSameClusterState() throws Exception {
    }
                .next()
            ShardStartedClusterStateTaskExecutorTests::neverReroutes,
        final String indexName = "test";
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
    public void testPrimaryTermsMismatch() throws Exception {
            assertThat(result.executionResults.size(), equalTo(1));
        final ShardRouting shardRouting = clusterState.routingTable().shardRoutingTable(shardId).primaryShard();
 * the Apache License, Version 2.0 (the "License"); you may
        clusterState = ClusterState.builder(clusterState)
            assertNotSame(clusterState, result.resultingState);
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
package org.opensearch.cluster.action.shard;
        final String indexName = "test";
        assertSame(clusterState, result.resultingState);
        {
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
            assertNotSame(clusterState, result.resultingState);
        executor = new ShardStateAction.ShardStartedClusterStateTaskExecutor(
 * Modifications Copyright OpenSearch Contributors. See
                allocationId = shardRoutingTable.primaryShard().allocationId().getId();
            final IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);
 */
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.STARTED));
        ClusterState clusterState = state(indexName, randomBoolean(), ShardRoutingState.INITIALIZING, ShardRoutingState.INITIALIZING);
        final long primaryTerm = indexMetadata.primaryTerm(shardId.id());
            final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, singletonList(task));
 * The OpenSearch Contributors require contributions made to
            return new StartedShardEntry(shardId, allocationId, primaryTerm, "test");
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
        final ClusterState clusterState = stateWithNoShard();
            assertNotSame(clusterState, result.resultingState);
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
            // Existent shard id but different allocation id
        assertSame(clusterState, result.resultingState);
        }).collect(Collectors.toList());
        throws Exception {
    private static void neverReroutes(String reason, Priority priority, ActionListener<ClusterState> listener) {
            .build();
    }
            );
        final long primaryTerm = indexMetadata.primaryTerm(shardId.id());
import static org.hamcrest.Matchers.is;
        final String primaryAllocationId = primaryShard.allocationId().getId();
        final List<StartedShardEntry> tasks = new ArrayList<>();
    }
        tasks.forEach(task -> {
        assertNotSame(clusterState, result.resultingState);
import org.opensearch.cluster.action.shard.ShardStateAction.StartedShardEntry;
        return result;
        final ClusterState clusterState = stateWithAssignedPrimariesAndReplicas(new String[] { indexName }, randomIntBetween(2, 10), 1);
                .mapToObj(i -> new StartedShardEntry(new ShardId(indexMetadata.getIndex(), i), String.valueOf(i), 0L, "shard id"))
    @Override
        final int shard = 0;
        AllocationService allocationService = createAllocationService(
import org.opensearch.cluster.routing.ShardRouting;
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, singletonList(entry));
        assertThat(result, notNullValue());
            }
        assertSame(clusterState, result.resultingState);
        {
        {
        final List<StartedShardEntry> tasks = IntStream.range(0, randomIntBetween(2, 10))
            assertSame(clusterState, result.resultingState);
            Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), Integer.MAX_VALUE).build()
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
    private ShardStateAction.ShardStartedClusterStateTaskExecutor executor;
import org.opensearch.core.action.ActionListener;
 * ownership. Elasticsearch licenses this file to you under
        );
        final int primaryTerm = 2 + randomInt(200);
 * SPDX-License-Identifier: Apache-2.0
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);
            final String replicaAllocationId = clusterState.routingTable()
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
                shardId,
                allocationId = shardRoutingTable.replicaShards().iterator().next().allocationId().getId();
        });
    }
 * specific language governing permissions and limitations
        final String primaryAllocationId = clusterState.routingTable().shardRoutingTable(shardId).primaryShard().allocationId().getId();
import org.opensearch.cluster.ClusterState;
            final long primaryTerm = indexMetadata.primaryTerm(shardId.id());
    public void testNonExistentIndexMarkedAsSuccessful() throws Exception {
 */
        });
public class ShardStartedClusterStateTaskExecutorTests extends OpenSearchAllocationTestCase {
            assertThat(result.executionResults.size(), equalTo(1));
        }
            // Non existent shard id
        assertThat(result.executionResults.size(), equalTo(tasks.size()));
 * under the License.
        final ShardId shardId = new ShardId(clusterState.metadata().index(indexName).getIndex(), shard);
        assertThat(result.executionResults.size(), equalTo(1));
            .mapToObj(i -> new StartedShardEntry(shardId, allocationId, primaryTerm, "test"))
import java.util.stream.Stream;
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.STARTED));
    @SuppressWarnings("unused")
            assertThat(result.executionResults.containsKey(task), is(true));
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, tasks);
        }
        super.setUp();
            final IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().shardRoutingTable(shardId);
        final String indexName = "test";
 * this work for additional information regarding copyright
            allocationService,
            assertNotSame(clusterState, result.resultingState);
                .replicaShards()
    public void testStartedShards() throws Exception {
        final ClusterState clusterState = state(indexName, randomBoolean(), ShardRoutingState.INITIALIZING, ShardRoutingState.INITIALIZING);
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, tasks);
                primaryTerm,
            logger
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.STARTED));
        });
import java.util.stream.IntStream;
        final List<StartedShardEntry> tasks = IntStream.range(0, randomIntBetween(1, indexMetadata.getNumberOfShards())).mapToObj(i -> {
        final ClusterState clusterState = state(indexName, randomBoolean(), ShardRoutingState.INITIALIZING);
 *
    }
            final ShardRouting replicaShard = clusterState.routingTable().shardRoutingTable(shardId).replicaShards().iterator().next();
        final String allocationId = shardRouting.allocationId().getId();
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
            final StartedShardEntry task = new StartedShardEntry(shardId, replicaAllocationId, replicaPrimaryTerm, "test on replica");
        final ClusterStateTaskExecutor.ClusterTasksResult<StartedShardEntry> result = executor.execute(state, tasks);
            )
            assertThat(result.executionResults.containsKey(task), is(true));
        final ClusterState clusterState = stateWithActivePrimary(indexName, true, randomInt(2), randomInt(2));
        final ShardRouting primaryShard = clusterState.routingTable().shardRoutingTable(shardId).primaryShard();
            final StartedShardEntry task = new StartedShardEntry(
        fail("unexpectedly ran a deferred reroute");
        final StartedShardEntry entry = new StartedShardEntry(new ShardId("test", "_na", 0), "aId", randomNonNegativeLong(), "test");
            () -> Priority.NORMAL,
 *
    }
            clusterState = result.resultingState;
    }
import java.util.List;
            assertSame(clusterState, result.resultingState);
                primaryAllocationId,
 * license agreements. See the NOTICE file distributed with
    public void testNonInitializingShardAreMarkedAsSuccessful() throws Exception {
        tasks.forEach(task -> {
                    .build()
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
        assertThat(result.executionResults.size(), equalTo(tasks.size()));
        final ClusterState clusterState = stateWithNoShard();
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, tasks);
 * not use this file except in compliance with the License.
