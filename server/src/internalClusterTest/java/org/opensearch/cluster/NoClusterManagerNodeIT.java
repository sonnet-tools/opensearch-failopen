            .setAllowPartialSearchResults(true)  
/*  
    }
/*  
 * this work for additional information regarding copyright
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
 * compatible open source license.
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
import org.opensearch.script.Script;
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;  
                .setId("1")
 * GitHub history for details.
                .setId("1")
        );  
        logger.info("--> here 3");
            true,
                .setLocal(true)
            AddVotingConfigExclusionsAction.INSTANCE,  
        final NetworkDisruption disruptionScheme = new NetworkDisruption(  
            false,  
            clientToClusterManagerlessNode.prepareSearch("no_index").setSize(0),  
            .map(DiscoveryNode::getName)
        } catch (ClusterBlockException e) {  
        internalCluster().setDisruptionScheme(disruptionScheme);
        checkWriteAction(
        );  
import org.opensearch.common.xcontent.XContentFactory;
        );  
                .get()
                .setTimeout(timeout)
            .get();
import org.opensearch.script.ScriptType;  
                .setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2")
    }  
            .map(shardRouting -> shardRouting.currentNodeId())  
        assertBusy(() -> {
            if (e instanceof ClusterManagerNotDiscoveredException) {  
        assertBusy(() -> {  
            .setTimeout(timeout)  
        assertHitCount(countResponse, 1L);  
        client(randomFrom(nodesWithShards)).prepareUpdate("test1", "1")
                .actionGet()  
        ClusterStateResponse clusterState = client().admin().cluster().prepareState().get();  
                .setTimeout(timeout)
            .build();
        client().prepareIndex("test2").setId("1").setSource("field", "value1").get();
    }
            for (String node : nodesWithShards) {  
        try {
        expectThrows(
        );  
                .setId("1")
        );
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
                .setScript(new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, "test script", Collections.emptyMap()))
    }  
                .setTimeout(timeout)  
        checkWriteAction(bulkRequestBuilder);
            .stream()
            .put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "all")
import org.opensearch.action.get.GetResponse;  
        disruptionScheme.startDisrupting();
        client().admin().cluster().prepareHealth("_all").setWaitForGreenStatus().get();
            ClusterBlockException.class,
        assertThat(countResponse.getTotalShards(), equalTo(3));
        return Collections.singletonList(MockTransportService.TestPlugin.class);
            .index("test1")
 * specific language governing permissions and limitations
        );
 * software distributed under the License is distributed on an
    public void testNoClusterManagerActions() throws Exception {
            clientToClusterManagerlessNode.prepareGet("no_index", "1"),  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            NetworkDisruption.DISCONNECT  
 *
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
        );  
            fail("Expected ClusterBlockException");
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
        Settings settings = Settings.builder()  
                .get()  
        countResponse = clientToClusterManagerlessNode.prepareSearch("test2").setAllowPartialSearchResults(true).setSize(0).get();  
            Exception.class,  
            .setSource(XContentFactory.jsonBuilder().startObject().endObject())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;  
            .shard(0)  
        internalCluster().clearDisruptionScheme(true);
 * Modifications Copyright OpenSearch Contributors. See
        prepareCreate("test1").setSettings(  
            RestStatus.SERVICE_UNAVAILABLE
                .setTimeout(timeout)
    }
        expectThrows(
                .get();
            () -> client(partitionedNode).prepareIndex("test1")
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
        createIndex("test");  
        checkWriteAction(bulkRequestBuilder);
            () -> client(partitionedNode).prepareUpdate("test1", "1")  
 *
        SearchResponse countResponse = client(randomFrom(nodesWithShards)).prepareSearch("test1")
        );  
        assertHitCount(countResponse, 1L);  
            clientToClusterManagerlessNode.prepareMultiGet().add("no_index", "1"),  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        prepareCreate("test1").setSettings(
        } catch (Exception e) {  
            assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
            RestStatus.SERVICE_UNAVAILABLE
        assertExists(getResponse);  
        bulkRequestBuilder.setTimeout(timeout);  
import java.util.stream.Collectors;
    }
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), false)
        GetResponse getResponse = client(randomFrom(nodesWithShards)).prepareGet("test1", "1").get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * You may obtain a copy of the License at  
        );
        );  
package org.opensearch.cluster;
import org.opensearch.common.settings.Settings;
        Settings settings = Settings.builder()
 * The OpenSearch Contributors require contributions made to  
import java.util.HashSet;  
            clientToClusterManagerlessNode.prepareIndex("test")  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
import org.opensearch.cluster.action.index.MappingUpdatedAction;  
        });  
        assertRequestBuilderThrows(
            .setSize(0)
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.test.OpenSearchIntegTestCase;
            ClusterState state = clientToClusterManagerlessNode.admin()
        assertRequestBuilderThrows(
        final NetworkDisruption disruptionScheme = new NetworkDisruption(  
                .setTimeout(timeout)  
        );
        client().prepareIndex("test1").setId("1").setSource("field", "value1").get();  
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())  
                assertTrue(autoCreateIndex);
            .setAllowPartialSearchResults(true)  
                .setTimeout(timeout)
            clientToClusterManagerlessNode.prepareUpdate("no_index", "1")
        Settings settings = Settings.builder()
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), true)
        TimeValue timeout = TimeValue.timeValueMillis(200);
            new AddVotingConfigExclusionsRequest(nodesWithShards.toArray(new String[0]))
            () -> client(randomFrom(nodesWithShards)).prepareIndex("test1")  
    }
        );  
            clientToClusterManagerlessNode.prepareIndex("test1")  
            }  
            ClusterManagerNotDiscoveredException.class,  
                .setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2")
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
import org.opensearch.action.ActionRequestBuilder;
import java.util.Collections;
        disruptionScheme.startDisrupting();
            ClusterManagerNotDiscoveredException.class,
            ClusterBlockException.class,
                assertFalse(autoCreateIndex);  
                .getState();
            .collect(Collectors.toList());  
            clientToClusterManagerlessNode.prepareIndex("no_index")
        ).get();
            Exception.class,  
            .get();
            ClusterBlockException.class,
                .setTimeout(timeout)
 */  
            clientToClusterManagerlessNode.prepareIndex("test")
        });
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;  
            .setId("1")
        client().admin().cluster().prepareHealth("_all").setWaitForGreenStatus().get();  
        );  
import org.opensearch.test.disruption.NetworkDisruption.IsolateAllNodes;
import org.opensearch.cluster.metadata.IndexMetadata;  
        );  
    public void testNoClusterManagerActionsWriteClusterManagerBlock() throws Exception {  
            clientToClusterManagerlessNode.prepareIndex("no_index")
        SearchResponse countResponse = clientToClusterManagerlessNode.prepareSearch("test1")
            logger.info("unexpected", e);
            .put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "metadata_write")  
        assertRequestBuilderThrows(
        internalCluster().clearDisruptionScheme(true);  
            clientToClusterManagerlessNode.admin().indices().prepareAnalyze("no_index", "this is a test"),  
            timeout,
            .setSize(0)
        final List<String> nodes = internalCluster().startNodes(3, settings);  
                .prepareState()  
        TimeValue timeout = TimeValue.timeValueMillis(200);
        );  
        } catch (ClusterBlockException e) {
        assertThat(countResponse.getSuccessfulShards(), equalTo(1));
        );
            fail("Expected ClusterBlockException");  
        });  
            .put(MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.getKey(), "100ms")
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
            clientToClusterManagerlessNode.prepareMultiGet().add("test", "1"),  
        internalCluster().setDisruptionScheme(disruptionScheme);
        client().admin().cluster().prepareHealth("test").setWaitForGreenStatus().execute().actionGet();
        client().prepareIndex("test1").setId("1").setSource("field", "value1").get();
            fail("Expected ClusterBlockException");
        internalCluster().setDisruptionScheme(disruptionScheme);
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
 * under the License.  
        assertRequestBuilderThrows(
 * Licensed to Elasticsearch under one or more contributor  
        final List<String> nodes = internalCluster().startNodes(3, settings);
 * not use this file except in compliance with the License.
        // we clean the metadata when loosing a cluster-manager, therefore all operations on indices will auto create it, if allowed
            () -> client(partitionedNode).prepareSearch("test1").setAllowPartialSearchResults(true).setSize(0).get()
        expectThrows(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
        final List<String> nodes = internalCluster().startNodes(3, settings);
        assertRequestBuilderThrows(
            builder.get();
        );  
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
        ensureGreen("test1");
        );
            .build();
import org.opensearch.cluster.block.ClusterBlockException;
        logger.info("Cluster state:\n{}", clusterState.getState());
        long now = System.currentTimeMillis();
        // dynamic mapping updates fail  
            new IsolateAllNodes(new HashSet<>(nodes)),
import org.opensearch.plugins.Plugin;
import org.opensearch.test.transport.MockTransportService;  
            ClusterBlockException.class,
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
        refresh();
        ).get();
        disruptionScheme.startDisrupting();  
            clientToClusterManagerlessNode.prepareIndex("test")
        );  
            ClusterBlockException.class,
        client().execute(
        BulkRequestBuilder bulkRequestBuilder = clientToClusterManagerlessNode.prepareBulk();
        expectThrows(
        );
        ).get();
        }  
 * license agreements. See the NOTICE file distributed with
            ClusterBlockException.class,
import org.opensearch.core.rest.RestStatus;
        bulkRequestBuilder.setTimeout(timeout);
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())  
            .put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "write")  
import org.opensearch.cluster.node.DiscoveryNode;
                assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
        assertExists(getResponse);
import java.util.List;
        assertBusy(() -> {  
            }
                .setSource(XContentFactory.jsonBuilder().startObject().field("new_field", "value").endObject())
        logger.info("Cluster state:\n{}", clusterState.getState());
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.action.bulk.BulkRequestBuilder;
        internalCluster().clearDisruptionScheme(true);
import org.opensearch.action.search.SearchResponse;
            NetworkDisruption.DISCONNECT
        // dynamic index creation fails
                .setTimeout(timeout)  
import org.opensearch.common.unit.TimeValue;  
            NetworkDisruption.DISCONNECT
        refresh();
            assertThat(System.currentTimeMillis() - now, greaterThan(timeout.millis() - 50));
            clientToClusterManagerlessNode.prepareSearch("test").setSize(0),  
            throw e;
    public void testNoClusterManagerActionsMetadataWriteClusterManagerBlock() throws Exception {
        checkUpdateAction(
import org.opensearch.transport.client.Client;
        bulkRequestBuilder.add(
                .execute()
/*
            Exception.class,
import static org.hamcrest.Matchers.equalTo;
        assertHitCount(searchResponse, 1L);
            .routingTable()
            RestStatus.SERVICE_UNAVAILABLE
                ClusterState state = client(node).admin().cluster().prepareState().setLocal(true).get().getState();
        SearchResponse searchResponse = clientToClusterManagerlessNode.prepareSearch("test1").setAllowPartialSearchResults(true).get();  
        }
        bulkRequestBuilder = clientToClusterManagerlessNode.prepareBulk();
        bulkRequestBuilder.add(
        final List<String> nodesWithShards = clusterState.getState()  
            RestStatus.SERVICE_UNAVAILABLE
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
            clientToClusterManagerlessNode.admin().indices().prepareAnalyze("test", "this is a test"),  
        try {  
}
            clientToClusterManagerlessNode.prepareUpdate("test", "1")
        );
        expectThrows(Exception.class, () -> client(partitionedNode).prepareGet("test1", "1").get());  
import org.opensearch.transport.client.Requests;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        try {
            RestStatus.SERVICE_UNAVAILABLE
    void checkWriteAction(ActionRequestBuilder<?, ?> builder) {  
        expectThrows(
 *    http://www.apache.org/licenses/LICENSE-2.0
                .get();
        prepareCreate("test2").setSettings(
        final Client clientToClusterManagerlessNode = client();
            () -> client(randomFrom(nodesWithShards)).prepareIndex("test2")
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())  
 *  
        }  
                .setTimeout(timeout)
 * the Apache License, Version 2.0 (the "License"); you may
        ).get();
            clientToClusterManagerlessNode.prepareUpdate("test1", "1")
            ClusterBlockException.class,
            builder.get();  
        client(randomFrom(nodesWithShards)).prepareIndex("test1")  
                .setId("1")
            clientToClusterManagerlessNode.prepareGet("test", "1"),  
                .setId("1")
        );
    @Override
 */
 * KIND, either express or implied.  See the License for the
                .setId("1")  
        ensureSearchable("test1", "test2");
                .cluster()
            ClusterBlockException.class,
            .setTimeout(timeout)
            .setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2")  
    @Override  
            ClusterState state = clientToClusterManagerlessNode.admin().cluster().prepareState().setLocal(true).get().getState();
            .get();
        ClusterStateResponse clusterState = client().admin().cluster().prepareState().get();  
 */  
            .activeShards()
                .get()
        bulkRequestBuilder.add(  
        assertRequestBuilderThrows(
            } else {
            RestStatus.SERVICE_UNAVAILABLE
        String partitionedNode = nodes.stream().filter(n -> nodesWithShards.contains(n) == false).findFirst().get();
                .setScript(new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, "test script", Collections.emptyMap()))  
import java.util.Collection;
        checkUpdateAction(
            new NetworkDisruption.TwoPartitions(Collections.singleton(partitionedNode), new HashSet<>(nodesWithShards)),
            .map(nodeId -> clusterState.getState().nodes().resolveNode(nodeId))
        ensureGreen("test1");  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertExists;
        assertRequestBuilderThrows(
        GetResponse getResponse = clientToClusterManagerlessNode.prepareGet("test1", "1").get();
            .get();
            clientToClusterManagerlessNode.prepareIndex("no_index")  
        try {
                .setId("2")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        checkWriteAction(  
                .setId("1")
        );  
        );  
        bulkRequestBuilder.add(
            RestStatus.SERVICE_UNAVAILABLE
            fail("expected ClusterBlockException or ClusterManagerNotDiscoveredException");
public class NoClusterManagerNodeIT extends OpenSearchIntegTestCase {
import org.opensearch.test.disruption.NetworkDisruption;
        }  
                .setTimeout(timeout)  
    protected int numberOfReplicas() {
            RestStatus.SERVICE_UNAVAILABLE
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())  
        final Client clientToClusterManagerlessNode = client();
            timeout,  
 * this file be licensed under the Apache-2.0 license or a
                .get()
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
        assertRequestBuilderThrows(
        return 2;  
            .build();  
            assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
        } catch (ClusterBlockException | ClusterManagerNotDiscoveredException e) {
    void checkUpdateAction(boolean autoCreateIndex, TimeValue timeout, ActionRequestBuilder<?, ?> builder) {  
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
            new IsolateAllNodes(new HashSet<>(nodes)),
        } catch (ClusterBlockException e) {  
                .setId("1")
                .setId("2")  
import org.opensearch.action.support.AutoCreateIndex;
        final NetworkDisruption disruptionScheme = new NetworkDisruption(
        final TimeValue timeout = TimeValue.timeValueMillis(10);
