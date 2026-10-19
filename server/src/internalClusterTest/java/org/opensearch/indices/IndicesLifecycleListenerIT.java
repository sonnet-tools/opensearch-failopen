        }
            ClusterStateResponse resp = client().admin().cluster().prepareState().get();  
        );
                    + Strings.arrayToCommaDelimitedString(shardStates)
     * is not stuck but properly failed.
        // increase replicas from 0 to 1
            assertTrue(e.getMessage().contains("failing on purpose"));
import org.opensearch.cluster.metadata.IndexMetadata;
 * license agreements. See the NOTICE file distributed with
                .get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        try {
 * this work for additional information regarding copyright
            client().admin().indices().prepareCreate("failed").setSettings(Settings.builder().put("index.fail", true)).get();
                .prepareCreate("test")
            this.creationSettings = indexSettings;  
public class IndicesLifecycleListenerIT extends OpenSearchIntegTestCase {  
        ensureGreen();  
 *
        assertThat(stateChangeListenerNode1.afterCloseSettings.getAsInt(SETTING_NUMBER_OF_REPLICAS, -1), equalTo(1));  
            .indices()  
            assertFalse(resp.getState().routingTable().indicesRouting().keySet().contains("failed"));
import java.util.Collection;
}
                for (int i = 0; i < shardStates.length; i++) {  
                    + "\n"  
                    + stateChangeListener
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put("index.fail", true))  
        String node1 = internalCluster().startNode();
    }
    }  
        } catch (OpenSearchException e) {  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
/*  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        String node2 = internalCluster().startNode();
                    + "expected: ["
        }  
        // 3 replicas are allocated to the second node
                assertNotNull(indexShardStates);  
                sb.append(entry.getKey()).append(" --> ").append(Strings.collectionToCommaDelimitedString(entry.getValue())).append("\n");  
 */  
        assertThat("beforeIndexCreated called on each data node", allCreatedCount.get(), greaterThanOrEqualTo(3));
import org.opensearch.cluster.ClusterState;  
        assertAcked(client().admin().indices().prepareClose("test"));  
import org.opensearch.common.Nullable;
    private static void assertShardStatesMatch(  
        return Arrays.asList(MockIndexEventListener.TestPlugin.class);
            .prepareCreate("test")  
        Settings afterCloseSettings = Settings.EMPTY;
            if (shardStates != null) {
import org.opensearch.cluster.routing.ShardRoutingState;  
            client().admin()  
            .get();
            public void beforeIndexCreated(Index index, Settings indexSettings) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.hasSize;  
        };
import org.opensearch.plugins.Plugin;  
                allCreatedCount.incrementAndGet();
        assertShardStatesMatch(stateChangeListenerNode2, 6, CLOSED, CREATED, RECOVERING, POST_RECOVERY, STARTED);  
                )
        };
        ensureGreen();
import java.util.Map;
     */
        assertThat("beforeIndexAddedToCluster called only once", beforeAddedCount.get(), equalTo(1));
                new CopyOnWriteArrayList<>(new IndexShardState[] { newState })  
/*
import org.opensearch.index.shard.IndexEventListener;  
            IndexShardState newState,
        public void indexShardStateChanged(
        // re-enable allocation
        }
                .prepareUpdateSettings()
        // the 3 relocated shards get created on the second node
    }
     * Tests that if an *index* structure creation fails on relocation to a new node, the shard  
import java.util.concurrent.TimeUnit;
 */
import org.opensearch.OpenSearchException;
 */  
        assertShardStatesMatch(stateChangeListenerNode1, 6, CREATED, RECOVERING, POST_RECOVERY, STARTED);  
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node1).setNewDelegate(listener);  
import org.opensearch.index.shard.IndexShard;
        ensureGreen("index1");
            for (Map.Entry<ShardId, List<IndexShardState>> entry : shardStates.entrySet()) {
import java.util.List;  
                .indices()  
        String node2 = internalCluster().startNode();  
import org.opensearch.test.MockIndexEventListener;
    }
import org.opensearch.test.OpenSearchIntegTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(stateChangeListenerNode1.creationSettings.getAsInt(SETTING_NUMBER_OF_REPLICAS, -1), equalTo(0));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        // create an index  
            .get();  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "] shards with states: "
        // add a listener that keeps track of the shard state changes
 *
        }  
        // 3 replicas are allocated to the first node
                if (MockIndexEventListener.TestPlugin.INDEX_FAIL.get(indexSettings)) {
        final ConcurrentMap<ShardId, List<IndexShardState>> shardStates = new ConcurrentHashMap<>();
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
import org.opensearch.core.common.Strings;  
                .prepareCreate("failed")
            assertFalse(resp.getState().routingTable().indicesRouting().keySet().contains("failed"));  
import org.opensearch.index.shard.IndexShardState;
        assertShardStatesMatch(stateChangeListenerNode2, 3, CREATED, RECOVERING, POST_RECOVERY, STARTED);  
            client().admin()
            fail(  
            }
 * KIND, either express or implied.  See the License for the
            fail("should have thrown an exception during creation");  
import java.util.concurrent.atomic.AtomicInteger;  
                assertThat(indexShardStates.size(), equalTo(shardStates.length));
            public void beforeIndexAddedToCluster(Index index, Settings indexSettings) {
import java.util.concurrent.ConcurrentMap;  
                @Override
                "failed to observe expect shard states\n"
                    throw new OpenSearchException("failing on purpose");
        String node2 = internalCluster().startNode();  
 * Unless required by applicable law or agreed to in writing,
            );  
        IndexShardStateChangeListener stateChangeListenerNode1 = new IndexShardStateChangeListener();  
        // add a listener that keeps track of the shard state changes
        final int numShards,
                }  
    /**
        assertAcked(
        } catch (Exception e) {
        public void beforeIndexCreated(Index index, Settings indexSettings) {
        try {
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
            assertBusy(waitPredicate, 1, TimeUnit.MINUTES);
                .indices()
            for (List<IndexShardState> indexShardStates : stateChangeListener.shardStates.values()) {
    public void testBeforeIndexAddedToCluster() throws Exception {
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        client().admin()
 * Modifications Copyright OpenSearch Contributors. See
        assertShardStatesMatch(stateChangeListenerNode2, 3, CREATED, RECOVERING, POST_RECOVERY, STARTED);  
                throw new OpenSearchException("failing on purpose");
                }
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node2)  
            List<IndexShardState> shardStates = this.shardStates.putIfAbsent(
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        assertShardStatesMatch(stateChangeListenerNode1, 3, CLOSED);
import org.hamcrest.Matchers;
        assertThat(shard, hasSize(1));
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
 * specific language governing permissions and limitations
    public void testIndexShardFailedOnRelocation() throws Throwable {  
import static org.hamcrest.CoreMatchers.equalTo;
        ensureGreen("test");  
        } catch (AssertionError ae) {
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")  
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 6).put(SETTING_NUMBER_OF_REPLICAS, 0))
        CheckedRunnable<Exception> waitPredicate = () -> {
        }
        // add a node: 3 out of the 6 shards will be relocated to it
    }
        // the 3 relocated shards get closed on the first node  
 * this file be licensed under the Apache-2.0 license or a
                .cluster()
        assertAcked(
        final AtomicInteger beforeAddedCount = new AtomicInteger(0);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            }
    ) throws Exception {
import static org.opensearch.index.shard.IndexShardState.CREATED;
        stateChangeListener.shardStates.clear();  
                    + numShards  
            @Nullable String reason
        assertThat(state.nodes().resolveNode(shard.get(0).currentNodeId()).getName(), Matchers.equalTo(node1));  
                public void beforeIndexCreated(Index index, Settings indexSettings) {  
                )
        );
        assertThat(stateChangeListenerNode1.creationSettings.getAsInt(SETTING_NUMBER_OF_SHARDS, -1), equalTo(6));
            return sb.toString();
import java.util.Arrays;
        // close the index
            }
        assertShardStatesMatch(stateChangeListenerNode1, 6, CLOSED, CREATED, RECOVERING, POST_RECOVERY, STARTED);
package org.opensearch.indices;
        public void afterIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
import org.opensearch.core.index.shard.ShardId;
        client().admin()
        assertThat(stateChangeListenerNode1.afterCloseSettings.getAsInt(SETTING_NUMBER_OF_SHARDS, -1), equalTo(6));
            }  
        ensureGreen();
            assertTrue(e.getMessage().contains("failing on purpose"));
        );  
        assertShardStatesMatch(stateChangeListenerNode1, 3, CREATED, RECOVERING, POST_RECOVERY, STARTED);  
import org.opensearch.core.index.Index;
        @Override
        // start with a single node
import static org.opensearch.index.shard.IndexShardState.RECOVERING;
            this.afterCloseSettings = indexSettings;
import java.util.concurrent.CopyOnWriteArrayList;
            StringBuilder sb = new StringBuilder();
    private static class IndexShardStateChangeListener implements IndexEventListener {  
                beforeAddedCount.incrementAndGet();  
/*  
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        ) {  
        @Override
        assertAcked(
            }  
                    throw new RuntimeException("FAIL");
            .prepareCreate("index1")
import org.opensearch.cluster.routing.ShardRouting;
                .cluster()  
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "all")
 * Licensed to Elasticsearch under one or more contributor  
                .setPersistentSettings(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    }
        // we keep track of all the states (ordered) a shard goes through
            .indices()
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("index1", 0, node1, node2)).get();
        assertAcked(  
        try {  
    public void testIndexStateShardChanged() throws Throwable {  
            ClusterStateResponse resp = client().admin().cluster().prepareState().get();
            });  
        final AtomicInteger allCreatedCount = new AtomicInteger(0);
                .setPersistentSettings(  
                shardStates.add(newState);  
 *  
        }
            client().admin()  
            assertEquals(stateChangeListener.shardStates.size(), numShards);  
        IndexEventListener listener = new IndexEventListener() {  
        String node3 = internalCluster().startNode();
        // create an index that should fail
        String node1 = internalCluster().startNode();
        ensureGreen("index1");
            @Override  
        String node1 = internalCluster().startNode();
                    + "observed:\n"
import static org.opensearch.index.shard.IndexShardState.STARTED;
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node2).setNewDelegate(stateChangeListenerNode2);  
            client().admin()
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node2).setNewDelegate(listener);
        IndexShardStateChangeListener stateChangeListenerNode2 = new IndexShardStateChangeListener();
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node3).setNewDelegate(listener);
        public String toString() {  
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))
                    assertThat(indexShardStates.get(i), equalTo(shardStates[i]));
            @Nullable IndexShardState previousState,  
            IndexShard indexShard,
        final IndexShardStateChangeListener stateChangeListener,
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.common.CheckedRunnable;  
 * software distributed under the License is distributed on an
import static org.opensearch.index.shard.IndexShardState.POST_RECOVERY;  
    @Override
        // disable allocation before starting a new node, as we need to register the listener first  
        @Override  
        internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node1).setNewDelegate(stateChangeListenerNode1);
        List<ShardRouting> shard = state.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED);
        // new shards got started
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            .setNewDelegate(new IndexShardStateChangeListener() {
            fail("should have thrown an exception");
import static org.opensearch.index.shard.IndexShardState.CLOSED;
                .prepareUpdateSettings()
        final IndexShardState... shardStates  
 * not use this file except in compliance with the License.
            if (indexSettings.getAsBoolean("index.fail", false)) {
            );
                indexShard.shardId(),
            }  
        );  
 * compatible open source license.
        }
        Settings creationSettings = Settings.EMPTY;  
        @Override  
import org.opensearch.common.settings.Settings;
            @Override
 * You may obtain a copy of the License at  
