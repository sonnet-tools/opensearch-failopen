            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
            }
        assertAcked(client().admin().indices().prepareClose("test"));
import org.opensearch.index.shard.IndexShard;
        List<ShardRouting> shard = state.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED);
        final AtomicInteger beforeAddedCount = new AtomicInteger(0);
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node1).setNewDelegate(stateChangeListenerNode1);
        IndexShardStateChangeListener stateChangeListenerNode1 = new IndexShardStateChangeListener();
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
import org.opensearch.test.MockIndexEventListener;
            assertEquals(stateChangeListener.shardStates.size(), numShards);
        final IndexShardState... shardStates
        String node2 = internalCluster().startNode();
import java.util.Collection;
    }
            );
        final ConcurrentMap<ShardId, List<IndexShardState>> shardStates = new ConcurrentHashMap<>();
import org.opensearch.common.settings.Settings;
        assertShardStatesMatch(stateChangeListenerNode1, 6, CREATED, RECOVERING, POST_RECOVERY, STARTED);
/*
        // start with a single node
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        stateChangeListener.shardStates.clear();
 */
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 6).put(SETTING_NUMBER_OF_REPLICAS, 0))
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            List<IndexShardState> shardStates = this.shardStates.putIfAbsent(
        );
     */
        };
    public void testIndexStateShardChanged() throws Throwable {
        // we keep track of all the states (ordered) a shard goes through
        try {
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node2)
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;
        assertShardStatesMatch(stateChangeListenerNode1, 3, CREATED, RECOVERING, POST_RECOVERY, STARTED);
     * Tests that if an *index* structure creation fails on relocation to a new node, the shard
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.index.Index;
        // the 3 relocated shards get created on the second node
import org.hamcrest.Matchers;
import static org.opensearch.index.shard.IndexShardState.RECOVERING;
package org.opensearch.indices;
        String node1 = internalCluster().startNode();
                sb.append(entry.getKey()).append(" --> ").append(Strings.collectionToCommaDelimitedString(entry.getValue())).append("\n");
        try {
                .prepareCreate("test")
        assertAcked(
        }
import org.opensearch.cluster.metadata.IndexMetadata;
            @Nullable String reason
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        final int numShards,
                    throw new RuntimeException("FAIL");
        // disable allocation before starting a new node, as we need to register the listener first
 */
import static org.opensearch.index.shard.IndexShardState.CREATED;
                    + numShards
            }
            if (indexSettings.getAsBoolean("index.fail", false)) {
        IndexShardStateChangeListener stateChangeListenerNode2 = new IndexShardStateChangeListener();
            return sb.toString();
                "failed to observe expect shard states\n"
            assertTrue(e.getMessage().contains("failing on purpose"));
        } catch (AssertionError ae) {
        // add a listener that keeps track of the shard state changes
                    + stateChangeListener
import static org.opensearch.index.shard.IndexShardState.CLOSED;
            this.afterCloseSettings = indexSettings;
import org.opensearch.common.CheckedRunnable;
                .cluster()
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put("index.fail", true))
            }
        String node2 = internalCluster().startNode();
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.shard.ShardId;
        @Override
 * this file be licensed under the Apache-2.0 license or a
                    + "expected: ["
import java.util.concurrent.TimeUnit;
            if (shardStates != null) {
            @Override
                .get();
     * is not stuck but properly failed.
import org.opensearch.index.shard.IndexEventListener;
                }
        assertThat("beforeIndexAddedToCluster called only once", beforeAddedCount.get(), equalTo(1));
/*
            @Nullable IndexShardState previousState,
        } catch (OpenSearchException e) {
            }
                @Override
import java.util.concurrent.CopyOnWriteArrayList;
        client().admin()
        ensureGreen();
            client().admin()
                )
            StringBuilder sb = new StringBuilder();
        @Override
 * GitHub history for details.
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                allCreatedCount.incrementAndGet();
import static org.opensearch.index.shard.IndexShardState.STARTED;
        // close the index
        IndexEventListener listener = new IndexEventListener() {
        } catch (Exception e) {
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node2).setNewDelegate(listener);
 * The OpenSearch Contributors require contributions made to
    public void testIndexShardFailedOnRelocation() throws Throwable {
        assertAcked(
    ) throws Exception {
        client().admin()
                }
        assertThat(state.nodes().resolveNode(shard.get(0).currentNodeId()).getName(), Matchers.equalTo(node1));
 */
            client().admin()
public class IndicesLifecycleListenerIT extends OpenSearchIntegTestCase {
            fail(
    }
 * KIND, either express or implied.  See the License for the
    }
                beforeAddedCount.incrementAndGet();
        public void afterIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
        // add a node: 3 out of the 6 shards will be relocated to it
import org.opensearch.OpenSearchException;
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node1).setNewDelegate(listener);
 *
        // re-enable allocation
 * You may obtain a copy of the License at
/*
        String node1 = internalCluster().startNode();
            );
            client().admin()
        }
                public void beforeIndexCreated(Index index, Settings indexSettings) {
        }
            assertFalse(resp.getState().routingTable().indicesRouting().keySet().contains("failed"));
            .setNewDelegate(new IndexShardStateChangeListener() {
                .indices()
    @Override
            for (Map.Entry<ShardId, List<IndexShardState>> entry : shardStates.entrySet()) {
                }
        String node1 = internalCluster().startNode();
import static org.hamcrest.CoreMatchers.equalTo;
            fail("should have thrown an exception during creation");
            .indices()
                .indices()
                throw new OpenSearchException("failing on purpose");
}
 * specific language governing permissions and limitations
        ensureGreen("index1");
                assertNotNull(indexShardStates);
            this.creationSettings = indexSettings;
        public String toString() {
    }
            });
                .prepareCreate("failed")
        assertThat(shard, hasSize(1));
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    + "observed:\n"
        Settings creationSettings = Settings.EMPTY;
        String node2 = internalCluster().startNode();
        assertShardStatesMatch(stateChangeListenerNode2, 3, CREATED, RECOVERING, POST_RECOVERY, STARTED);
                shardStates.add(newState);
        }
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "all")
        CheckedRunnable<Exception> waitPredicate = () -> {
                if (MockIndexEventListener.TestPlugin.INDEX_FAIL.get(indexSettings)) {
        assertThat(stateChangeListenerNode1.afterCloseSettings.getAsInt(SETTING_NUMBER_OF_SHARDS, -1), equalTo(6));
import java.util.concurrent.ConcurrentMap;
                .setPersistentSettings(
        assertThat(stateChangeListenerNode1.creationSettings.getAsInt(SETTING_NUMBER_OF_REPLICAS, -1), equalTo(0));
        assertShardStatesMatch(stateChangeListenerNode2, 6, CLOSED, CREATED, RECOVERING, POST_RECOVERY, STARTED);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node2).setNewDelegate(stateChangeListenerNode2);
        );
            fail("should have thrown an exception");
            .indices()
            @Override
            for (List<IndexShardState> indexShardStates : stateChangeListener.shardStates.values()) {
        }
            assertBusy(waitPredicate, 1, TimeUnit.MINUTES);
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                    + Strings.arrayToCommaDelimitedString(shardStates)
                .prepareUpdateSettings()
import org.opensearch.cluster.routing.ShardRoutingState;
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        assertThat(stateChangeListenerNode1.creationSettings.getAsInt(SETTING_NUMBER_OF_SHARDS, -1), equalTo(6));
 * software distributed under the License is distributed on an
                .setPersistentSettings(
        ) {
        ensureGreen("index1");
import org.opensearch.index.shard.IndexShardState;
        // create an index
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
        final AtomicInteger allCreatedCount = new AtomicInteger(0);
        // create an index that should fail
        ensureGreen();
        );
import org.opensearch.core.common.Strings;
 * not use this file except in compliance with the License.
import static org.opensearch.index.shard.IndexShardState.POST_RECOVERY;
        assertShardStatesMatch(stateChangeListenerNode1, 3, CLOSED);
                    + "\n"
                for (int i = 0; i < shardStates.length; i++) {
        }
        };
        // new shards got started
            IndexShardState newState,
            ClusterStateResponse resp = client().admin().cluster().prepareState().get();
        public void beforeIndexCreated(Index index, Settings indexSettings) {
            .get();
    private static void assertShardStatesMatch(
import static org.hamcrest.Matchers.hasSize;
        public void indexShardStateChanged(
import org.opensearch.common.Nullable;
import java.util.concurrent.atomic.AtomicInteger;
    }
        // add a listener that keeps track of the shard state changes
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        // 3 replicas are allocated to the second node
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node3).setNewDelegate(listener);
            public void beforeIndexAddedToCluster(Index index, Settings indexSettings) {
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
 * under the License.
        // the 3 relocated shards get closed on the first node
import org.opensearch.test.OpenSearchIntegTestCase;
            IndexShard indexShard,
            .get();
                .cluster()
        assertAcked(
            ClusterStateResponse resp = client().admin().cluster().prepareState().get();
        ensureGreen();
 * license agreements. See the NOTICE file distributed with
            assertFalse(resp.getState().routingTable().indicesRouting().keySet().contains("failed"));
                assertThat(indexShardStates.size(), equalTo(shardStates.length));
        // increase replicas from 0 to 1
        assertShardStatesMatch(stateChangeListenerNode2, 3, CREATED, RECOVERING, POST_RECOVERY, STARTED);
                .prepareUpdateSettings()
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.plugins.Plugin;
                    throw new OpenSearchException("failing on purpose");
    private static class IndexShardStateChangeListener implements IndexEventListener {
 *
        assertThat(stateChangeListenerNode1.afterCloseSettings.getAsInt(SETTING_NUMBER_OF_REPLICAS, -1), equalTo(1));
    public void testBeforeIndexAddedToCluster() throws Exception {
        return Arrays.asList(MockIndexEventListener.TestPlugin.class);
        @Override
                    + "] shards with states: "
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            }
        final IndexShardStateChangeListener stateChangeListener,
                    assertThat(indexShardStates.get(i), equalTo(shardStates[i]));
 *
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
            .prepareCreate("index1")
        // 3 replicas are allocated to the first node
        try {
            }
                new CopyOnWriteArrayList<>(new IndexShardState[] { newState })
        @Override
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.cluster.routing.ShardRouting;
        ensureGreen("test");
            client().admin()
            assertTrue(e.getMessage().contains("failing on purpose"));
        Settings afterCloseSettings = Settings.EMPTY;
            client().admin().indices().prepareCreate("failed").setSettings(Settings.builder().put("index.fail", true)).get();
        assertShardStatesMatch(stateChangeListenerNode1, 6, CLOSED, CREATED, RECOVERING, POST_RECOVERY, STARTED);
        );
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))
        String node3 = internalCluster().startNode();
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("index1", 0, node1, node2)).get();
import java.util.Map;
        assertAcked(
                )
        assertThat("beforeIndexCreated called on each data node", allCreatedCount.get(), greaterThanOrEqualTo(3));
            public void beforeIndexCreated(Index index, Settings indexSettings) {
import java.util.concurrent.ConcurrentHashMap;
            .prepareCreate("test")
                indexShard.shardId(),
import org.opensearch.cluster.ClusterState;
