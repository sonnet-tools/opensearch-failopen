    @Override
/*
        );
        ensureSearchable("test1", "test2");
            .setSize(0)
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
        } catch (ClusterBlockException e) {
        ensureGreen("test1");
        );
            RestStatus.SERVICE_UNAVAILABLE
        internalCluster().clearDisruptionScheme(true);
 */
        );
        refresh();
            .build();
 * KIND, either express or implied.  See the License for the
                .get()
            assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
                .setId("2")
        createIndex("test");
        logger.info("Cluster state:\n{}", clusterState.getState());
        assertHitCount(countResponse, 1L);
                .get()
            .setSource(XContentFactory.jsonBuilder().startObject().endObject())
            clientToClusterManagerlessNode.prepareMultiGet().add("no_index", "1"),
            .setId("1")
        client().prepareIndex("test2").setId("1").setSource("field", "value1").get();
        internalCluster().setDisruptionScheme(disruptionScheme);
            NetworkDisruption.DISCONNECT
        assertExists(getResponse);
            clientToClusterManagerlessNode.prepareIndex("test")
            ClusterState state = clientToClusterManagerlessNode.admin()
    }
        });
        checkWriteAction(
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        client().prepareIndex("test1").setId("1").setSource("field", "value1").get();
            .setTimeout(timeout)
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.cluster.action.index.MappingUpdatedAction;
 * The OpenSearch Contributors require contributions made to
            ClusterManagerNotDiscoveredException.class,
        return 2;
 * You may obtain a copy of the License at
            RestStatus.SERVICE_UNAVAILABLE
        ).get();
        client(randomFrom(nodesWithShards)).prepareIndex("test1")
/*
            () -> client(randomFrom(nodesWithShards)).prepareIndex("test1")
            clientToClusterManagerlessNode.prepareGet("no_index", "1"),
        }
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * GitHub history for details.
 * specific language governing permissions and limitations
            false,
        );
        client().prepareIndex("test1").setId("1").setSource("field", "value1").get();
    protected int numberOfReplicas() {
                .setTimeout(timeout)
        checkWriteAction(bulkRequestBuilder);
        return Collections.singletonList(MockTransportService.TestPlugin.class);
        }
        checkUpdateAction(
        final NetworkDisruption disruptionScheme = new NetworkDisruption(
            ClusterBlockException.class,
                .prepareState()
            true,
    void checkWriteAction(ActionRequestBuilder<?, ?> builder) {
 */
        SearchResponse searchResponse = clientToClusterManagerlessNode.prepareSearch("test1").setAllowPartialSearchResults(true).get();
        client().admin().cluster().prepareHealth("_all").setWaitForGreenStatus().get();
        BulkRequestBuilder bulkRequestBuilder = clientToClusterManagerlessNode.prepareBulk();
            fail("Expected ClusterBlockException");
        final Client clientToClusterManagerlessNode = client();
            () -> client(randomFrom(nodesWithShards)).prepareIndex("test2")
 *
            throw e;
            NetworkDisruption.DISCONNECT
            assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
            clientToClusterManagerlessNode.prepareIndex("no_index")
            if (e instanceof ClusterManagerNotDiscoveredException) {
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
            RestStatus.SERVICE_UNAVAILABLE
        logger.info("Cluster state:\n{}", clusterState.getState());
        ensureGreen("test1");
            Exception.class,
 * Unless required by applicable law or agreed to in writing,
            ClusterBlockException.class,
        bulkRequestBuilder.setTimeout(timeout);
            .setAllowPartialSearchResults(true)
            .index("test1")
        );
 * under the License.
import org.opensearch.common.unit.TimeValue;
import static org.hamcrest.Matchers.equalTo;
            ClusterBlockException.class,
        long now = System.currentTimeMillis();
        bulkRequestBuilder.setTimeout(timeout);
            .build();
            .collect(Collectors.toList());
            .map(DiscoveryNode::getName)
                .setId("1")
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            ClusterBlockException.class,
        );
                .get()
        final NetworkDisruption disruptionScheme = new NetworkDisruption(
            RestStatus.SERVICE_UNAVAILABLE
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
        assertThat(countResponse.getTotalShards(), equalTo(3));
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
    @Override
                .setId("2")
            new NetworkDisruption.TwoPartitions(Collections.singleton(partitionedNode), new HashSet<>(nodesWithShards)),
                .setId("1")
                .setScript(new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, "test script", Collections.emptyMap()))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
            ClusterBlockException.class,
        client().admin().cluster().prepareHealth("test").setWaitForGreenStatus().execute().actionGet();
}
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
                .get();
        client().execute(
        disruptionScheme.startDisrupting();
    }
        );
 * software distributed under the License is distributed on an
        assertBusy(() -> {
import org.opensearch.cluster.metadata.IndexMetadata;
                .setTimeout(timeout)
            timeout,
        );
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
                .get();
                .setId("1")
        final TimeValue timeout = TimeValue.timeValueMillis(10);
                .setId("1")
            () -> client(partitionedNode).prepareUpdate("test1", "1")
        // dynamic mapping updates fail
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertExists;
            Exception.class,
        assertRequestBuilderThrows(
        ClusterStateResponse clusterState = client().admin().cluster().prepareState().get();
        SearchResponse countResponse = clientToClusterManagerlessNode.prepareSearch("test1")
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
        bulkRequestBuilder.add(
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
import java.util.List;
            clientToClusterManagerlessNode.prepareIndex("test1")
        assertRequestBuilderThrows(
        );
        assertHitCount(searchResponse, 1L);
 */
        ClusterStateResponse clusterState = client().admin().cluster().prepareState().get();
import java.util.Collections;
        });
            RestStatus.SERVICE_UNAVAILABLE
import static org.hamcrest.Matchers.greaterThan;
        );
 *
                .setScript(new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, "test script", Collections.emptyMap()))
        internalCluster().clearDisruptionScheme(true);
 * this work for additional information regarding copyright
            .get();
        String partitionedNode = nodes.stream().filter(n -> nodesWithShards.contains(n) == false).findFirst().get();
            .setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2")
        try {
                .getState();
        final List<String> nodes = internalCluster().startNodes(3, settings);
        ).get();
            clientToClusterManagerlessNode.admin().indices().prepareAnalyze("no_index", "this is a test"),
            clientToClusterManagerlessNode.prepareIndex("test")
                .setId("1")
 * not use this file except in compliance with the License.
        );
            .setSize(0)
            .put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "write")
        bulkRequestBuilder.add(
                .setSource(XContentFactory.jsonBuilder().startObject().field("new_field", "value").endObject())
            assertThat(System.currentTimeMillis() - now, greaterThan(timeout.millis() - 50));
        expectThrows(
            () -> client(partitionedNode).prepareIndex("test1")
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
            clientToClusterManagerlessNode.prepareUpdate("test1", "1")
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        prepareCreate("test2").setSettings(
            ClusterBlockException.class,
        } catch (ClusterBlockException e) {
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), true)
        prepareCreate("test1").setSettings(
        final List<String> nodesWithShards = clusterState.getState()
import org.opensearch.test.disruption.NetworkDisruption;
        assertRequestBuilderThrows(
    }
                .setTimeout(timeout)
        assertBusy(() -> {
            new AddVotingConfigExclusionsRequest(nodesWithShards.toArray(new String[0]))
            .build();
        GetResponse getResponse = clientToClusterManagerlessNode.prepareGet("test1", "1").get();
 * ownership. Elasticsearch licenses this file to you under
        Settings settings = Settings.builder()
                .get()
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
            }
        countResponse = clientToClusterManagerlessNode.prepareSearch("test2").setAllowPartialSearchResults(true).setSize(0).get();
        assertBusy(() -> {
            }
import org.opensearch.plugins.Plugin;
    void checkUpdateAction(boolean autoCreateIndex, TimeValue timeout, ActionRequestBuilder<?, ?> builder) {
import java.util.Collection;
                .setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2")
        );
        // dynamic index creation fails
import org.opensearch.transport.client.Client;
        ).get();
                assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
        try {
            RestStatus.SERVICE_UNAVAILABLE
            NetworkDisruption.DISCONNECT
        internalCluster().setDisruptionScheme(disruptionScheme);
        // we clean the metadata when loosing a cluster-manager, therefore all operations on indices will auto create it, if allowed
        assertRequestBuilderThrows(
        bulkRequestBuilder.add(
        checkWriteAction(
        bulkRequestBuilder = clientToClusterManagerlessNode.prepareBulk();
import org.opensearch.common.settings.Settings;
                .cluster()
            clientToClusterManagerlessNode.prepareIndex("no_index")
            .put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "all")
import org.opensearch.script.ScriptType;
        checkUpdateAction(
        );
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            RestStatus.SERVICE_UNAVAILABLE
                .setTimeout(timeout)
        final List<String> nodes = internalCluster().startNodes(3, settings);
        );
    }
            timeout,
            new IsolateAllNodes(new HashSet<>(nodes)),
            clientToClusterManagerlessNode.prepareGet("test", "1"),
        final Client clientToClusterManagerlessNode = client();
            ClusterBlockException.class,
        SearchResponse countResponse = client(randomFrom(nodesWithShards)).prepareSearch("test1")
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), false)
        logger.info("--> here 3");
        ).get();
            RestStatus.SERVICE_UNAVAILABLE
import org.opensearch.action.get.GetResponse;
import java.util.HashSet;
        prepareCreate("test1").setSettings(
        );
    }
                .setTimeout(timeout)
            clientToClusterManagerlessNode.prepareSearch("no_index").setSize(0),
            clientToClusterManagerlessNode.prepareIndex("test")
        client().admin().cluster().prepareHealth("_all").setWaitForGreenStatus().get();
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
        } catch (ClusterBlockException e) {
            logger.info("unexpected", e);
        expectThrows(
            builder.get();
            .shard(0)
        }
        );
            new IsolateAllNodes(new HashSet<>(nodes)),
        }
        );
            ClusterManagerNotDiscoveredException.class,
import org.opensearch.script.Script;
        internalCluster().setDisruptionScheme(disruptionScheme);
        );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        try {
        bulkRequestBuilder.add(
            clientToClusterManagerlessNode.prepareSearch("test").setSize(0),
            .get();
            .put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "metadata_write")
import org.opensearch.action.bulk.BulkRequestBuilder;
            ClusterBlockException.class,
                .setTimeout(timeout)
            .get();
import org.opensearch.action.search.SearchResponse;
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
            .routingTable()
import org.opensearch.action.support.AutoCreateIndex;
        );
import java.util.stream.Collectors;
                assertTrue(autoCreateIndex);
    public void testNoClusterManagerActionsMetadataWriteClusterManagerBlock() throws Exception {
        );
                .setId("1")
            clientToClusterManagerlessNode.prepareUpdate("test", "1")
        assertHitCount(countResponse, 1L);
package org.opensearch.cluster;
            fail("expected ClusterBlockException or ClusterManagerNotDiscoveredException");
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
 * this file be licensed under the Apache-2.0 license or a
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
                .setTimeout(timeout)
    }
            .setTimeout(timeout)
        assertThat(countResponse.getSuccessfulShards(), equalTo(1));
                .setTimeout(timeout)
        Settings settings = Settings.builder()
import org.opensearch.test.OpenSearchIntegTestCase;
            clientToClusterManagerlessNode.prepareMultiGet().add("test", "1"),
        expectThrows(Exception.class, () -> client(partitionedNode).prepareGet("test1", "1").get());
public class NoClusterManagerNodeIT extends OpenSearchIntegTestCase {
 * compatible open source license.
        assertRequestBuilderThrows(
                ClusterState state = client(node).admin().cluster().prepareState().setLocal(true).get().getState();
            .stream()
            Exception.class,
            clientToClusterManagerlessNode.admin().indices().prepareAnalyze("test", "this is a test"),
 * Licensed to Elasticsearch under one or more contributor
            } else {
                .actionGet()
                .setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2")
        try {
            .map(nodeId -> clusterState.getState().nodes().resolveNode(nodeId))
                .setTimeout(timeout)
        assertRequestBuilderThrows(
        expectThrows(
            clientToClusterManagerlessNode.prepareUpdate("no_index", "1")
        assertRequestBuilderThrows(
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
        refresh();
        TimeValue timeout = TimeValue.timeValueMillis(200);
    }
                .setLocal(true)
            .get();
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
 * SPDX-License-Identifier: Apache-2.0
                .setTimeout(timeout)
            () -> client(partitionedNode).prepareSearch("test1").setAllowPartialSearchResults(true).setSize(0).get()
                .execute()
            .setAllowPartialSearchResults(true)
        final NetworkDisruption disruptionScheme = new NetworkDisruption(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 *
import org.opensearch.test.disruption.NetworkDisruption.IsolateAllNodes;
                .setSource(XContentFactory.jsonBuilder().startObject().endObject())
            ClusterState state = clientToClusterManagerlessNode.admin().cluster().prepareState().setLocal(true).get().getState();
        );
import org.opensearch.common.xcontent.XContentFactory;
        } catch (Exception e) {
        expectThrows(
        disruptionScheme.startDisrupting();
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
        disruptionScheme.startDisrupting();
        });
 * the Apache License, Version 2.0 (the "License"); you may
        client(randomFrom(nodesWithShards)).prepareUpdate("test1", "1")
        final List<String> nodes = internalCluster().startNodes(3, settings);
import org.opensearch.transport.client.Requests;
                .setId("1")
        checkWriteAction(bulkRequestBuilder);
                assertFalse(autoCreateIndex);
            fail("Expected ClusterBlockException");
        } catch (ClusterBlockException | ClusterManagerNotDiscoveredException e) {
        Settings settings = Settings.builder()
            .put(MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.getKey(), "100ms")
import org.opensearch.cluster.node.DiscoveryNode;
            AddVotingConfigExclusionsAction.INSTANCE,
        internalCluster().clearDisruptionScheme(true);
            for (String node : nodesWithShards) {
import org.opensearch.action.ActionRequestBuilder;
        );
        assertExists(getResponse);
            clientToClusterManagerlessNode.prepareIndex("no_index")
        assertRequestBuilderThrows(
 * Modifications Copyright OpenSearch Contributors. See
    public void testNoClusterManagerActions() throws Exception {
            .map(shardRouting -> shardRouting.currentNodeId())
        );
        expectThrows(
    public void testNoClusterManagerActionsWriteClusterManagerBlock() throws Exception {
import org.opensearch.cluster.block.ClusterBlockException;
                .setId("1")
            .activeShards()
            fail("Expected ClusterBlockException");
/*
        GetResponse getResponse = client(randomFrom(nodesWithShards)).prepareGet("test1", "1").get();
        TimeValue timeout = TimeValue.timeValueMillis(200);
            builder.get();
