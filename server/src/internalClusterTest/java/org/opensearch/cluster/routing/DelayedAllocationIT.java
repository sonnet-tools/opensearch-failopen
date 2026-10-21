        indexRandomData();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            () -> assertThat(
        assertBusy(
        prepareCreate("test").setSettings(
        ensureGreen("test");
        assertAcked(
                .indices()
     * Verify that when explicitly changing the value of the index setting for the delayed
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(1));
     * With a very small delay timeout, verify that it expires and we get to green even
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
            )
        ensureGreen("test");
        int numDocs = scaledRandomIntBetween(100, 1000);
        internalCluster().startNodes(3);
/*
                equalTo(true)
import static org.hamcrest.Matchers.equalTo;
        internalCluster().startNodes(3);
        indexRandomData();
        internalCluster().startNodes(3);
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertAcked(
        ensureGreen("test");
     */
 * Licensed to Elasticsearch under one or more contributor
        String nodeWithShard = findNodeWithShard();
                .get()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 */
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 * The OpenSearch Contributors require contributions made to
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                client().admin().cluster().prepareState().all().get().getState().getRoutingNodes().unassigned().size() > 0,
     * free to allocate the unassigned shard when the node hosting it leaves, it doesn't
                .indices()
 *
     * get allocated to a free node when the node hosting it leaves the cluster.
    private void indexRandomData() throws Exception {
        );
                )
        // a case where they are the same (using sync flush), index Random does all this goodness
 * compatible open source license.
            Settings.builder()
 * You may obtain a copy of the License at
     * even though the node it was hosted on will not come back.
    private String findNodeWithShard() {
    }
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(0));
package org.opensearch.cluster.routing;
 * this work for additional information regarding copyright
            client().admin()
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1))
        internalCluster().startNodes(3);
 * not use this file except in compliance with the License.
        ).get();
                )
        ).get();
        ensureGreen("test");
        ensureGreen("test");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
                equalTo(true)
                    Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))
 * this file be licensed under the Apache-2.0 license or a
                .prepareUpdateSettings("test")
            Settings.builder()
     */
        prepareCreate("test").setSettings(
import org.opensearch.test.InternalTestCluster;
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
public class DelayedAllocationIT extends OpenSearchIntegTestCase {
                client().admin().cluster().prepareState().all().get().getState().getRoutingNodes().unassigned().size() > 0,
        assertAcked(
    /**
        prepareCreate("test").setSettings(
import org.opensearch.test.OpenSearchIntegTestCase;
     * even though the node it was hosted on will not come back.
 * license agreements. See the NOTICE file distributed with
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithShard));
        Collections.shuffle(startedShards, random());
                    Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))
            Settings.builder()
            () -> assertThat(
                .indices()
        return state.nodes().get(startedShards.get(0).currentNodeId()).getName();
import org.opensearch.common.unit.TimeValue;
        ensureGreen("test");
    }
        }
        ensureGreen("test");
                .prepareUpdateSettings("test")
        internalCluster().startNode();
 * SPDX-License-Identifier: Apache-2.0
     * allocation to a very small value, it kicks the allocation of the unassigned shard
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(0));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1))
            () -> assertThat(
     * on it before.
        ensureGreen("test");
                client().admin().cluster().prepareState().all().get().getState().getRoutingNodes().unassigned().size() > 0,
                .setSettings(
        );
            )
     * allocation to 0, it kicks the allocation of the unassigned shard
        );
        indexRandom(true, builders);
        ).get();
     */
     * get allocated. Once we bring the node back, it gets allocated since it existed
    public void testNoDelayedTimeout() throws Exception {
 * under the License.
            )
 */
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Settings nodeWithShardDataPathSettings = internalCluster().dataPathSettings(nodeWithShard);
        prepareCreate("test").setSettings(
        // already
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < builders.length; i++) {
        ensureGreen("test");
        internalCluster().startNodes(3);
import org.opensearch.cluster.metadata.IndexMetadata;
    }
    public void testDelayedAllocationChangeWithSettingTo0() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // do a second round with longer delay to make sure it happens
    public void testDelayedAllocationTimesOut() throws Exception {
            builders[i] = client().prepareIndex("test").setSource("field", "value");
/*
     * Verifies that when there is no delay timeout, a 1/1 index shard will immediately
        indexRandomData();
    }
        );
                .get()
            Settings.builder()
                .setSettings(
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
                )
import java.util.Collections;
                .setSettings(
            client().admin()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
    public void testDelayedAllocationChangeWithSettingTo100ms() throws Exception {
            Settings.builder()
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(1));
                    Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))
 * specific language governing permissions and limitations
import org.opensearch.action.index.IndexRequestBuilder;
 */
import org.opensearch.common.settings.Settings;
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        prepareCreate("test").setSettings(
 * KIND, either express or implied.  See the License for the
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .get()
        ).get();
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(1));
        // we want to test both full divergent copies of the shard in terms of segments, and
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.cluster.ClusterState;
        ensureGreen("test");
        ).get();
        List<ShardRouting> startedShards = state.routingTable().shardsWithState(ShardRoutingState.STARTED);
     * Verify that when explicitly changing the value of the index setting for the delayed
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
 *
    /**
     */
 * GitHub history for details.
        indexRandomData();
        );
import java.util.List;
     */
                .prepareUpdateSettings("test")
     * When we do have delayed allocation set, verifies that even though there is a node
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(0));
    /**
    /**
        internalCluster().startNode(nodeWithShardDataPathSettings); // this will use the same data location as the stopped node
    }
     * though the node hosting the shard is not coming back.
    public void testDelayedAllocationNodeLeavesAndComesBack() throws Exception {
                equalTo(true)
 * software distributed under the License is distributed on an
        ensureGreen("test");
 *
    /**
 * Modifications Copyright OpenSearch Contributors. See
}
            client().admin()
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1))
 * Unless required by applicable law or agreed to in writing,
        assertBusy(
        assertBusy(
/*
 * ownership. Elasticsearch licenses this file to you under
        indexRandomData();
