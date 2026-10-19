        );
        ).get();  
 * Licensed to Elasticsearch under one or more contributor  
        internalCluster().startNode(nodeWithShardDataPathSettings); // this will use the same data location as the stopped node  
        }
                .indices()  
        ).get();
 * license agreements. See the NOTICE file distributed with
        assertAcked(
        indexRandom(true, builders);
        internalCluster().startNodes(3);
        // already
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(0));
        indexRandomData();
            Settings.builder()
                .get()
        // do a second round with longer delay to make sure it happens  
import static org.hamcrest.Matchers.equalTo;
     */  
                .setSettings(
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
}
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 *  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testDelayedAllocationChangeWithSettingTo100ms() throws Exception {
                )
        prepareCreate("test").setSettings(  
        ).get();
import org.opensearch.cluster.metadata.IndexMetadata;  
        ).get();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
    }
                equalTo(true)  
        indexRandomData();
        ensureGreen("test");
        assertBusy(  
     * With a very small delay timeout, verify that it expires and we get to green even
            )  
    /**
     */  
     * get allocated. Once we bring the node back, it gets allocated since it existed
                .setSettings(
import org.opensearch.test.InternalTestCluster;  
     * get allocated to a free node when the node hosting it leaves the cluster.
     * Verify that when explicitly changing the value of the index setting for the delayed  
 * this file be licensed under the Apache-2.0 license or a
        indexRandomData();
                    Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))  
    /**
            builders[i] = client().prepareIndex("test").setSource("field", "value");  
     * free to allocate the unassigned shard when the node hosting it leaves, it doesn't  
                client().admin().cluster().prepareState().all().get().getState().getRoutingNodes().unassigned().size() > 0,
 *
import org.opensearch.common.settings.Settings;
                equalTo(true)  
        // a case where they are the same (using sync flush), index Random does all this goodness  
import java.util.List;
    }  
        internalCluster().startNodes(3);  
     * allocation to 0, it kicks the allocation of the unassigned shard
 * GitHub history for details.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(0));  
        List<ShardRouting> startedShards = state.routingTable().shardsWithState(ShardRoutingState.STARTED);
                client().admin().cluster().prepareState().all().get().getState().getRoutingNodes().unassigned().size() > 0,
            )
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
        int numDocs = scaledRandomIntBetween(100, 1000);  
 *
package org.opensearch.cluster.routing;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            Settings.builder()
 */  
        assertAcked(
    /**
     */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(1));  
        assertBusy(  
                .get()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
            Settings.builder()
     * Verifies that when there is no delay timeout, a 1/1 index shard will immediately
                    Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))  
     * When we do have delayed allocation set, verifies that even though there is a node
            () -> assertThat(  
            )
     * even though the node it was hosted on will not come back.
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            () -> assertThat(
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .indices()  
        );  
        ensureGreen("test");
                .indices()  
     */
            Settings.builder()
        );
        ensureGreen("test");  
     */  
 * not use this file except in compliance with the License.
    /**  
        ensureGreen("test");  
 */
/*  
    public void testNoDelayedTimeout() throws Exception {
        ).get();
    /**
     * allocation to a very small value, it kicks the allocation of the unassigned shard
        // we want to test both full divergent copies of the shard in terms of segments, and
import java.util.Collections;  
 * Modifications Copyright OpenSearch Contributors. See
        ensureGreen("test");
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1))
            client().admin()
    }  
                .prepareUpdateSettings("test")
 * compatible open source license.
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(1));  
 * Unless required by applicable law or agreed to in writing,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.common.unit.TimeValue;
        internalCluster().startNode();
        for (int i = 0; i < builders.length; i++) {
                .prepareUpdateSettings("test")
/*
        return state.nodes().get(startedShards.get(0).currentNodeId()).getName();  
                )
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(1));
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0)
/*  
     * even though the node it was hosted on will not come back.
    private void indexRandomData() throws Exception {
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1))
                )
                    Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        internalCluster().startNodes(3);
        );  
    public void testDelayedAllocationChangeWithSettingTo0() throws Exception {
    public void testDelayedAllocationTimesOut() throws Exception {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithShard));
public class DelayedAllocationIT extends OpenSearchIntegTestCase {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));  
import org.opensearch.test.OpenSearchIntegTestCase;
        Settings nodeWithShardDataPathSettings = internalCluster().dataPathSettings(nodeWithShard);  
            Settings.builder()
import org.opensearch.cluster.ClusterState;
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        assertBusy(
        prepareCreate("test").setSettings(  
        ensureGreen("test");
        ensureGreen("test");
        assertThat(client().admin().cluster().prepareHealth().get().getDelayedUnassignedShards(), equalTo(0));
 * SPDX-License-Identifier: Apache-2.0
        prepareCreate("test").setSettings(
        assertAcked(
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
    }
        ensureGreen("test");
     * though the node hosting the shard is not coming back.  
        indexRandomData();
        internalCluster().startNodes(3);
    private String findNodeWithShard() {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * specific language governing permissions and limitations
            client().admin()
 * The OpenSearch Contributors require contributions made to  
            () -> assertThat(
    }  
            client().admin()
        indexRandomData();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodeWithShard()));
        );  
        );
 * software distributed under the License is distributed on an
 */  
                equalTo(true)
        internalCluster().startNodes(3);
        Collections.shuffle(startedShards, random());
        prepareCreate("test").setSettings(  
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1))
        ensureGreen("test");
        ensureGreen("test");  
        String nodeWithShard = findNodeWithShard();
    }  
     * on it before.
 * the Apache License, Version 2.0 (the "License"); you may
        prepareCreate("test").setSettings(  
import org.opensearch.action.index.IndexRequestBuilder;
        ensureGreen("test");  
 * under the License.  
                .get()
 * KIND, either express or implied.  See the License for the
                client().admin().cluster().prepareState().all().get().getState().getRoutingNodes().unassigned().size() > 0,
    public void testDelayedAllocationNodeLeavesAndComesBack() throws Exception {
                .setSettings(
     * Verify that when explicitly changing the value of the index setting for the delayed  
                .prepareUpdateSettings("test")
