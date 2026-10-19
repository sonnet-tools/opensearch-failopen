 * ownership. Elasticsearch licenses this file to you under  
    public void testStartedShards() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(result.executionResults.size(), equalTo(1));  
            );
        final ClusterState clusterState = stateWithActivePrimary(indexName, true, randomInt(2), randomInt(2));  
    }  
            IntStream.range(0, randomIntBetween(1, 5))
        tasks.forEach(task -> {  
        final int shard = 0;
            final ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
        assertThat(result.executionResults.size(), equalTo(tasks.size()));  
 * You may obtain a copy of the License at  
                .iterator()  
import static org.hamcrest.Matchers.equalTo;
 *     http://www.apache.org/licenses/LICENSE-2.0
            } else {  
import static org.hamcrest.Matchers.notNullValue;
    }  
        assertSame(clusterState, result.resultingState);
            assertThat(result.executionResults.containsKey(task), is(true));
            tasks.add(new StartedShardEntry(shardId, replicaAllocationId, primaryTerm, "test"));
                primaryAllocationId,
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
        ).collect(Collectors.toList());
                    .build()  
            final StartedShardEntry task = new StartedShardEntry(  
        final int primaryTerm = 2 + randomInt(200);
 * Modifications Copyright OpenSearch Contributors. See
                shardId,
            final StartedShardEntry task = new StartedShardEntry(shardId, replicaAllocationId, replicaPrimaryTerm, "test on replica");
        throws Exception {
            final long replicaPrimaryTerm = randomBoolean() ? primaryTerm : primaryTerm - 1;
            assertThat(result.executionResults.containsKey(task), is(true));
 * Licensed to Elasticsearch under one or more contributor  
    private ShardStateAction.ShardStartedClusterStateTaskExecutor executor;
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
            if (randomBoolean()) {
            .mapToObj(i -> new StartedShardEntry(shardId, allocationId, primaryTerm, "test"))
        final String indexName = "test";
        tasks.forEach(task -> {
            // Non existent shard id
                allocationId = shardRoutingTable.primaryShard().allocationId().getId();
import org.opensearch.cluster.metadata.Metadata;  
            Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), Integer.MAX_VALUE).build()
        final String indexName = "test";
                .mapToObj(i -> new StartedShardEntry(new ShardId(indexMetadata.getIndex(), 0), String.valueOf(i), 0L, "allocation id")),  
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));  
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.STARTED));
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithActivePrimary;
import org.opensearch.cluster.ClusterStateTaskExecutor;
    public void setUp() throws Exception {
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.STARTED));
            IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);
            final StartedShardEntry task = new StartedShardEntry(
                .mapToObj(i -> new StartedShardEntry(new ShardId(indexMetadata.getIndex(), i), String.valueOf(i), 0L, "shard id"))  
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;  
            assertThat(result.executionResults.containsKey(task), is(true));  
import org.opensearch.cluster.routing.ShardRouting;
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
            assertThat(result.executionResults.size(), equalTo(1));
    public void testNonExistentShardsAreMarkedAsSuccessful() throws Exception {
                primaryAllocationId,
                .getId();  
            final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, singletonList(task));
import org.opensearch.common.Priority;
        ClusterState clusterState = state(indexName, randomBoolean(), ShardRoutingState.INITIALIZING, ShardRoutingState.INITIALIZING);
import java.util.stream.Collectors;
            return new StartedShardEntry(shardId, allocationId, primaryTerm, "test");
            .metadata(  
        final long primaryTerm = indexMetadata.primaryTerm(shardId.id());
 * not use this file except in compliance with the License.
                "primary terms does not match on primary"
        final ShardId shardId = new ShardId(clusterState.metadata().index(indexName).getIndex(), shard);  
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, singletonList(entry));  
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.STARTED));  
 * license agreements. See the NOTICE file distributed with
            IntStream.range(1, randomIntBetween(2, 5))
            final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, singletonList(task));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.ShardRoutingState;  
        }
 *
import org.opensearch.cluster.ClusterState;
 * software distributed under the License is distributed on an
            IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);  
        {
        clusterState = ClusterState.builder(clusterState)
        final List<StartedShardEntry> tasks = IntStream.range(0, randomIntBetween(2, 10))
                .allocationId()
    private static void neverReroutes(String reason, Priority priority, ActionListener<ClusterState> listener) {
        );
        final StartedShardEntry entry = new StartedShardEntry(new ShardId("test", "_na", 0), "aId", randomNonNegativeLong(), "test");
    }
        executor = new ShardStateAction.ShardStartedClusterStateTaskExecutor(  
            assertNotSame(clusterState, result.resultingState);
        }  
        return result;
            assertNotSame(clusterState, result.resultingState);
        fail("unexpectedly ran a deferred reroute");  
/*
            )
        }).collect(Collectors.toList());
        assertThat(result.executionResults.size(), equalTo(tasks.size()));
 */
            .collect(Collectors.toList());  
            logger
    }
        tasks.forEach(task -> {
        assertThat(result.executionResults.size(), equalTo(1));
            assertThat(result.executionResults.size(), equalTo(1));  
    }
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithNoShard;  
import org.opensearch.common.settings.Settings;  
            IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);  
            allocationService,
            assertNotSame(clusterState, result.resultingState);
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, tasks);  
        super.setUp();
            final ShardRouting replicaShard = clusterState.routingTable().shardRoutingTable(shardId).replicaShards().iterator().next();
            assertThat(result.executionResults.containsKey(task), is(true));  
        });
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
 * compatible open source license.
                    .put(IndexMetadata.builder(clusterState.metadata().index(indexName)).primaryTerm(shard, primaryTerm).build(), true)
            assertThat(result.executionResults.containsKey(task), is(true));
import java.util.stream.IntStream;
import org.opensearch.core.action.ActionListener;
        tasks.forEach(task -> {
        tasks.add(new StartedShardEntry(shardId, primaryAllocationId, primaryTerm, "test"));  
import org.opensearch.core.index.shard.ShardId;
        final String indexName = "test";
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
}  
        final ShardRouting primaryShard = clusterState.routingTable().shardRoutingTable(shardId).primaryShard();
                Metadata.builder(clusterState.metadata())
            assertThat(result.executionResults.containsKey(task), is(true));
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, tasks);
        final ClusterState clusterState = stateWithNoShard();  
        assertSame(clusterState, result.resultingState);
 */  
import static org.hamcrest.Matchers.is;  
/*  
        final List<StartedShardEntry> tasks = Stream.concat(  
        assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(entry)).isSuccess(), is(true));
            final String allocationId;  
    @SuppressWarnings("unused")
            final IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);
                shardId,  
                "primary terms match on primary"  
            final IndexShardRoutingTable shardRoutingTable = result.resultingState.routingTable().shardRoutingTable(task.shardId);  
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING;
    }
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
import java.util.stream.Stream;  
        final ClusterState clusterState = stateWithAssignedPrimariesAndReplicas(new String[] { indexName }, randomIntBetween(2, 10), 1);  
        final List<StartedShardEntry> tasks = IntStream.range(0, randomIntBetween(1, indexMetadata.getNumberOfShards())).mapToObj(i -> {  
        final long primaryTerm = indexMetadata.primaryTerm(shardId.id());
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
                primaryTerm - 1,  
        assertNotSame(clusterState, result.resultingState);  
            );
            final long primaryTerm = indexMetadata.primaryTerm(shardId.id());  
        );
        final List<StartedShardEntry> tasks = new ArrayList<>();
        final ClusterState clusterState = state(indexName, randomBoolean(), ShardRoutingState.INITIALIZING, ShardRoutingState.INITIALIZING);  
import org.opensearch.cluster.metadata.IndexMetadata;
        }  
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));  
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
            assertNotSame(clusterState, result.resultingState);
        final String indexName = "test";  
                primaryTerm,
            clusterState = result.resultingState;
        final ClusterState clusterState = state(indexName, randomBoolean(), ShardRoutingState.INITIALIZING);
            final IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().shardRoutingTable(shardId);
        assertSame(clusterState, result.resultingState);
        final ClusterStateTaskExecutor.ClusterTasksResult<StartedShardEntry> result = executor.execute(state, tasks);
        });
        });  
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, tasks);
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        final String primaryAllocationId = clusterState.routingTable().shardRoutingTable(shardId).primaryShard().allocationId().getId();
    public void testNonExistentIndexMarkedAsSuccessful() throws Exception {
import java.util.Collections;
        final ShardId shardId = new ShardId(indexMetadata.getIndex(), 0);
import org.opensearch.cluster.action.shard.ShardStateAction.StartedShardEntry;
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, Collections.emptyList());
        assertThat(result.executionResults.containsKey(entry), is(true));  
        final String allocationId = shardRouting.allocationId().getId();
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.STARTED));
    private ClusterStateTaskExecutor.ClusterTasksResult executeTasks(final ClusterState state, final List<StartedShardEntry> tasks)  
                .next()
            final String replicaAllocationId = replicaShard.allocationId().getId();  
            // Existent shard id but different allocation id
public class ShardStartedClusterStateTaskExecutorTests extends OpenSearchAllocationTestCase {  
/*  
        assertSame(clusterState, result.resultingState);
            () -> Priority.NORMAL,  
            assertThat(result.executionResults.containsKey(task), is(true));
 * GitHub history for details.
        final ShardId shardId = new ShardId(indexMetadata.getIndex(), 0);  
        {
            final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, singletonList(task));  
        assertThat(result.executionResults.size(), equalTo(tasks.size()));
    }
            }
    public void testEmptyTaskListProducesSameClusterState() throws Exception {
        final ShardRouting shardRouting = clusterState.routingTable().shardRoutingTable(shardId).primaryShard();  
 * under the License.  
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
    }  
import static java.util.Collections.singletonList;
        assertThat(result.executionResults.size(), equalTo(tasks.size()));  
    }
package org.opensearch.cluster.action.shard;
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
        {
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas;
        assertNotSame(clusterState, result.resultingState);
 *
            assertSame(clusterState, result.resultingState);
        assertThat(result, notNullValue());  
        final ClusterState clusterState = stateWithNoShard();  
            final String replicaAllocationId = clusterState.routingTable()  
        if (randomBoolean()) {
        });
        }  
 */  
            assertThat(shardRoutingTable.getByAllocationId(task.allocationId).state(), is(ShardRoutingState.INITIALIZING));
        final String indexName = "test";
 * The OpenSearch Contributors require contributions made to  
                .replicaShards()
    public void testDuplicateStartsAreOkay() throws Exception {  
        final String primaryAllocationId = primaryShard.allocationId().getId();  
            ShardStartedClusterStateTaskExecutorTests::neverReroutes,
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                allocationId = shardRoutingTable.replicaShards().iterator().next().allocationId().getId();
import java.util.List;  
 *  
import org.opensearch.cluster.routing.allocation.AllocationService;
        final ClusterStateTaskExecutor.ClusterTasksResult result = executeTasks(clusterState, tasks);
 * Unless required by applicable law or agreed to in writing,
            .build();
    }
                .shardRoutingTable(shardId)
 * specific language governing permissions and limitations
            assertSame(clusterState, result.resultingState);
import java.util.ArrayList;
    public void testPrimaryTermsMismatch() throws Exception {
            assertThat(((ClusterStateTaskExecutor.TaskResult) result.executionResults.get(task)).isSuccess(), is(true));
    public void testNonInitializingShardAreMarkedAsSuccessful() throws Exception {
        AllocationService allocationService = createAllocationService(  
    @Override  
