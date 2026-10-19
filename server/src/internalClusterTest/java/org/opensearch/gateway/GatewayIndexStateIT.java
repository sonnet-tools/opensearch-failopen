 */
        logger.info("--> restart a random date node, deleting the index in between stopping and restarting");
        logger.info("--> verifying that the state is green");
                assertThat(shardRoutingTable.primaryShard().unassignedInfo().getNumFailedAllocations(), greaterThan(0));
                    + "    \"properties\": {\n"
        assertAcked(client().admin().indices().prepareClose("test"));
                fail("Unable to retrieve available index folders from the node");
            // all is well  
     * if it is sane and if we can successfully create an IndexService.  
import java.util.stream.Stream;
        logger.info("--> create an index");
            "test",
        logger.info("--> starting 1 cluster-manager node non data");
            .getState()
import org.apache.logging.log4j.Logger;
        assertEquals(ex.getMessage(), "Failed to verify index " + metadata.getIndex());  
            }  
        logger.info("--> verifying that the state is green");
        logger.info("--> creating test index, with meta routing");  
import java.util.concurrent.TimeUnit;
        logger.info("--> indexing a simple document");  
import org.opensearch.cluster.routing.UnassignedInfo;  
        assertThat(health.isTimedOut(), equalTo(false));
            );
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
     * In that case we now have the ability to check the index on local recovery from disk
                    .put(ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), "broken")
        try {  
 * software distributed under the License is distributed on an
import org.opensearch.indices.IndexClosedException;
        logger.info("--> trying to get the indexed document on the first round (before close and shutdown)");  
        ensureGreen("test");
            .actionGet();
        // for (final Path manifestPath : stateFiles  
    @Override
        assertEquals(IllegalArgumentException.class, ex.getCause().getClass());
            fail();
                )
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
        if (usually()) {  
                        .waitForGreenStatus()
        internalCluster().startNode();
            .setIndices("test")  
                final String otherNode = nodes.get(0);
            .setWaitForGreenStatus()  
                    UnassignedInfo.AllocationStatus.DECIDERS_NO,
        );
    /**  
        restartNodesOnBrokenClusterState(ClusterState.builder(state).metadata(Metadata.builder(state.getMetadata()).put(brokenMeta)));
        createIndex(
     * This also includes plugins etc.
/*  
import org.opensearch.cluster.routing.RoutingTable;
                return nonDataNode();  
        );
import org.opensearch.cluster.metadata.Metadata;
        for (int i = 0; i < 10; i++) {
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        });
            }  
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());  
    public void testSimpleOpenClose() throws Exception {
                    .put(metadata.getSettings())  
            } catch (IOException e) {  
        assertThat(clusterStateResponse.getState().metadata().hasIndex("test"), equalTo(true));
        final IndexMetadata.Builder brokenMeta = IndexMetadata.builder(metadata)  
                    nodeName -> internalCluster().getInstance(PersistedClusterStateService.class, nodeName)  
        logger.info("--> verify 1 doc in the index");  
            .actionGet();  
        logger.info("--> verify 1 doc in the index");
            fail();
        internalCluster().startClusterManagerOnlyNode();
        assertFalse(client().admin().indices().prepareExists(indexName).execute().actionGet().isExists());
        ensureGreen();
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    public void testIndexDeletionWhenNodeRejoins() throws Exception {
        assertNotNull(ex.getCause());
import org.opensearch.common.settings.Settings;  
        client().admin().indices().prepareClose("test").get();
            .indices()
        // // add a tombstone but do not delete the index metadata from disk
        assertAcked(client().admin().indices().prepareClose("test"));  
        ensureGreen();  
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
            @Override
                        .waitForEvents(Priority.LANGUID)
                assertEquals(
                )  
        nodes = internalCluster().startNodes(
        logger.info("--> verifying that the state is green");
        // }
        logger.info("--> create an index");  
            );  
        // metaStateService.writeGlobalState("test", Metadata.builder(metadata)
    }  
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
        logger.info("--> starting 2 nodes");
                assertTrue(shardRoutingTable.primaryShard().unassigned());  
        internalCluster().restartRandomDataNode(new RestartCallback() {
        logger.info("--> indexing a simple document");
        assertThat(getResponse.isExists(), equalTo(true));  
        );
    }
        logger.info("--> verify we have an index");
    /**
    public void testJustClusterManagerNode() throws Exception {
    }
    public void testArchiveBrokenClusterSettings() throws Exception {  
                        .waitForNoRelocatingShards(true)  
import java.io.IOException;
            state.metadata().persistentSettings().get("archived." + ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey())  
        assertEquals(MapperParsingException.class, ex.getCause().getClass());
                assertThat(shardRoutingTable.primaryShard().unassignedInfo().getNumFailedAllocations(), greaterThan(0));
 *
        );
                    + "      \"field1\": {\n"  
            internalCluster().startNode();
        logger.info("--> waiting for green status");
            .health(Requests.clusterHealthRequest().waitForEvents(Priority.LANGUID).waitForNodes(Integer.toString(numNodes)))  
    }
        // });  
            .execute()
            // all is well
        } else {
            .build();
                logger.info("--> stopped node[{}], remaining nodes {}", nodeName, nodes);  
        assertNull(state.metadata().persistentSettings().get("archived.this.is.unknown"));
        assertThat(mappingMd.routingRequired(), equalTo(true));
        logger.info("--> restarting cluster-manager node");
        )
        final Metadata metadata = state.getMetadata();
        logger.info("--> waiting for green status");  
     */
        logger.info("--> indexing a simple document");
        client().admin().indices().prepareOpen("test").execute().actionGet();
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().setIndices("test").execute().actionGet();  
        ensureGreen();
            @Override
        logger.info("--> wait until all nodes are back online");  
        for (int i = 0; i < 10; i++) {
        Map<String, PersistedClusterStateService> lucenePersistedStateFactories = Stream.of(internalCluster().getNodeNames())
        });
        logger.info("--> waiting for green status");
                        .waitForNodes("2")
        ClusterHealthResponse health = client().admin()
        // .putCustom(IndexGraveyard.TYPE, IndexGraveyard.builder().addTombstone(metadata.index("test").getIndex()).build()).build());  
                return super.onNodeStopped(nodeName);
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
 */  
        MappingMetadata mappingMd = client().admin()  
        logger.info("--> opening the index...");
        logger.info("--> indexing a simple document");
 * ownership. Elasticsearch licenses this file to you under  
        assertAcked(client().admin().indices().prepareClose("test"));
        ensureYellow();  
     * This test really tests worst case scenario where we have a missing analyzer setting.
        // node won't start.
            .actionGet();
        logger.info("--> cleaning nodes");
package org.opensearch.gateway;
        logger.info("--> waiting for green status");  
        internalCluster().startNode();  
                    + "        \"type\": \"text\",\n"
                assertEquals(
import org.opensearch.cluster.routing.ShardRoutingState;
                    shardRoutingTable.primaryShard().unassignedInfo().getLastAllocationStatus()  
        }
                .health(
                client.admin().indices().prepareDelete(indexName).execute().actionGet();
            .persistentSettings(  
                return super.onNodeStopped(nodeName);
        logger.info("--> trying to index into a closed index ...");
     * This test ensures that when an index deletion takes place while a node is offline, when that
        } catch (IndexClosedException e) {  
import org.opensearch.cluster.routing.IndexRoutingTable;
        logger.info("--> waiting for test index to be created");
            client().admin()
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()  
import org.apache.logging.log4j.LogManager;
            }  
            .get();
                .actionGet();  
                    .put("index.similarity.BM25.type", "classic")  
        final List<String> nodes;  
        // }  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        // }
import org.opensearch.action.get.GetResponse;
            .execute()
            ensureYellow();
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));  
                .actionGet();
                .cluster()
                    // this is invalid but should be archived
        // .filter(p -> p.getFileName().toString().startsWith(Manifest.FORMAT.getPrefix())).collect(Collectors.toList())) {
        assertThat(
        logger.info("--> starting one node");
import org.opensearch.action.support.ActiveShardCount;
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());  
import org.opensearch.cluster.metadata.IndexMetadata;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.minimumIndexCompatibilityVersion().id)
            .cluster()  
            .prepareHealth()
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)  
                    Requests.clusterHealthRequest()  
                    .put("this.is.unknown", true)  
            .setMapping(XContentFactory.jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
        // .coordinationMetadata(CoordinationMetadata.builder(metadata.coordinationMetadata()).term(0L).build())
import org.opensearch.transport.client.Requests;
 * The OpenSearch Contributors require contributions made to  
        // writeBrokenMeta(metaStateService -> {  
            equalTo(test.totalNumShards)
            .setWaitForNodes("2")
        client().prepareIndex("test").setId("1").setSource("field1", "value one").setRefreshPolicy(IMMEDIATE).get();  
        internalCluster().startNode();
            assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);  
            final RoutingTable routingTable = client().admin().cluster().prepareState().get().getState().routingTable();
            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
                )
        assertThat(
            client().prepareIndex("test").setId("1").setSource("field1", "value1").execute().actionGet();  
        assertAcked(client().admin().indices().prepareOpen("test"));  
            .prepareCreate("test")  
        // It's possible for a 6.x node to add a tombstone for an index but not actually delete the index metadata from disk since that
import org.opensearch.cluster.metadata.MappingMetadata;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        client().admin()
            final NodeEnvironment nodeEnv = internalCluster().getInstance(NodeEnvironment.class);  
        logger.info("--> starting 2 nodes");
 * Unless required by applicable law or agreed to in writing,
        });
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
     * allocated in our metadata that we recover. In that case we now have the ability to check the index on local recovery from disk  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        logger.info("--> waiting for green status");
        final Metadata brokenMeta = Metadata.builder(metadata)
                    + "    }\n"
    public void testJustClusterManagerNodeAndJustDataNode() {
        logger.info("--> starting one node");
            }  
 * under the License.  
            public Settings onNodeStopped(String nodeName) {
                Settings.builder()
 * Licensed to Elasticsearch under one or more contributor  
     * if it is sane and if we can successfully create an IndexService. This also includes plugins etc.
        prepareCreate("test").setSettings(  
        logger.info("--> create an index");
        assertThat(ex.getCause().getMessage(), containsString("analyzer [test] has not been configured in mappings"));  
            final IndexRoutingTable indexRoutingTable = routingTable.index("test");  
            assertNotNull(indexRoutingTable);
        mappingMd = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test").mapping();  
            )  
 * specific language governing permissions and limitations
        final String indexName = "test-index-del-on-node-rejoin-idx";  
                final PersistedClusterStateService lucenePersistedStateFactory = lucenePersistedStateFactories.get(nodeName);
import org.opensearch.transport.client.Client;
        logger.info("--> cleaning nodes");  
    }
            .prepareHealth()
        }
                    .build()
                        .waitForNodes("2")
        NumShards test = getNumShards("test");
 * compatible open source license.
        assertBusy(() -> assertThat(internalCluster().getInstance(NodeEnvironment.class).availableIndexFolders(), empty()));
        assertThat(mappingMd.routingRequired(), equalTo(true));  
        }
                "{\n"
            .setWaitForEvents(Priority.LANGUID)
            assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);  
import static org.hamcrest.Matchers.empty;
 * GitHub history for details.
        if (usually()) {
import org.opensearch.indices.ShardLimitValidator;
    }
        // check that the cluster does not keep reallocating shards  
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
            numNodes,  
            internalCluster().startNode();  
        state = client().admin().cluster().prepareState().get().getState();
        }
                    + "      }\n"  
        // delete these settings  
    }
        final IndexMetadata.Builder brokenMeta = IndexMetadata.builder(metadata)
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());
        ClusterHealthResponse health = client().admin()  
        logger.info("--> trying to get the indexed document on the first index");
        logger.info("--> opening the first index again...");
        logger.info("--> waiting for green status");
        } else {
            final RoutingTable routingTable = client().admin().cluster().prepareState().get().getState().routingTable();
        assertBusy(() -> {
        assertEquals(ex.getMessage(), "Failed to verify index " + metadata.getIndex());  
        client().prepareIndex("test").setSource("field1", "value1").execute().actionGet();
                        .waitForNoRelocatingShards(true)  
            Settings.builder().put("index.analysis.analyzer.test.tokenizer", "standard").put("index.number_of_shards", "1")
        OpenSearchException ex = expectThrows(OpenSearchException.class, () -> client().admin().indices().prepareOpen("test").get());
        }
import static org.hamcrest.Matchers.greaterThan;  
        assertEquals("true", state.metadata().persistentSettings().get("archived.this.is.unknown"));  
                        .waitForGreenStatus()
        logger.info("--> verify that the deleted index is removed from the cluster and not reimported as dangling by the restarted node");  
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
                .health(  
        client().admin().indices().prepareOpen("test").execute().actionGet();
     * node rejoins the cluster, it deletes the index locally instead of importing it as a dangling index.  
        try {
        });
                );
        createIndex(indexName);
        client().prepareIndex("test").setId("1").setSource("field1", "value1").setRefreshPolicy(IMMEDIATE).get();  
     */
            client().admin()  
        assertEquals(ex.getCause().getMessage(), "Unknown filter type [icu_collation] for [myCollator]");  
            .setWaitForEvents(Priority.LANGUID)  
    }  
 * license agreements. See the NOTICE file distributed with
        logger.info("--> starting 1 cluster-manager node non data");
                Collectors.toMap(
            state.metadata().persistentSettings().get("archived." + ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey())  
        );
        internalCluster().fullRestart(new RestartCallback() {
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(test.numPrimaries));  
        }, 60, TimeUnit.SECONDS);
        );
import org.opensearch.test.InternalTestCluster.RestartCallback;  
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
        internalCluster().startNode(nonDataNode());  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
                    Requests.clusterHealthRequest()  
        logger.info("--> waiting for green status");
            .cluster()  
public class GatewayIndexStateIT extends OpenSearchIntegTestCase {
        } catch (IndexClosedException e) {
                assert nodes.size() > 0;
        // // term in the coordination metadata  
        final IndexMetadata metadata = state.getMetadata().index("test");
        getResponse = client().prepareGet("test", "1").execute().actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        internalCluster().fullRestart();  
        assertEquals(
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
                .actionGet();  
import org.opensearch.OpenSearchException;  
        state = client().admin().cluster().prepareState().get().getState();  
                    UnassignedInfo.AllocationStatus.DECIDERS_NO,
/*
                    Function.identity(),
import static org.hamcrest.Matchers.equalTo;
        client().prepareIndex("test").setId("2").setSource("field1", "value1").execute().actionGet();
    public void testRecoverBrokenIndexMetadata() throws Exception {  
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
            .actionGet();
            internalCluster().startNode();
        logger.info("--> starting a cluster with " + numNodes + " nodes");
        final Metadata metadata = internalCluster().getInstance(ClusterService.class).state().metadata();
        // check that the cluster does not keep reallocating shards  
        assertNull(
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();  
        assertEquals(IndexMetadata.State.CLOSE, state.getMetadata().index(metadata.getIndex()).getState());
import org.opensearch.cluster.metadata.IndexGraveyard;
        ensureGreen();  
    private void restartNodesOnBrokenClusterState(ClusterState.Builder clusterStateBuilder) throws Exception {
                logger.error("Unable to retrieve available index folders from the node", e);
        internalCluster().startNodes(2);  
        client().prepareIndex("test2").setId("1").setSource("field1", "value1").execute().actionGet();
            .execute()  
 * not use this file except in compliance with the License.
                    // this one is not validated ahead of time and breaks allocation
import java.util.List;  
            ensureYellow();  
    /**
        final int numNodes = 2;
import static org.hamcrest.Matchers.containsString;  
        OpenSearchException ex = expectThrows(OpenSearchException.class, () -> client().admin().indices().prepareOpen("test").get());
        );
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());
            "broken",
    }
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
        internalCluster().fullRestart();  
                        .waitForEvents(Priority.LANGUID)  
        final IndexMetadata metadata = state.getMetadata().index("test");
        ensureGreen();
        logger.info("--> cleaning nodes");  
        }
            .settings(
    public void testTwoNodesSingleDoc() throws Exception {
import java.util.Map;
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.Version;
                logger.info("--> index deleted");
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().execute().actionGet();  
        logger.info("--> creating test index");
        client().prepareIndex("test").setId("1").setSource("field1", "value1").setRefreshPolicy(IMMEDIATE).get();  
                    + "        \"analyzer\": \"test\"\n"
            .setWaitForEvents(Priority.LANGUID)
            public Settings onNodeStopped(final String nodeName) throws Exception {
                .cluster()
    public void testHalfDeletedIndexImport() throws Exception {
            Settings.builder().put(IndexGraveyard.SETTING_MAX_TOMBSTONES.getKey(), randomIntBetween(10, 100)).build()
        assertNotNull(ex.getCause());
 *  
                Settings.builder()
        // try to open it with the broken setting - fail again!
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(test.numPrimaries));  
import org.opensearch.env.NodeEnvironment;
        logger.info("--> creating another index (test2) by indexing into it");  
     * This test really tests worst case scenario where we have a broken setting or any setting that prevents an index from being
            .index("test")
            public Settings onNodeStopped(String nodeName) throws Exception {  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            .settings(metadata.getSettings().filter((s) -> "index.analysis.analyzer.test.tokenizer".equals(s) == false));  
            @Override  
        logger.info("--> opening index...");
                    .put("index.analysis.filter.myCollator.type", "icu_collation")
        assertBusy(() -> {
            client().prepareIndex("test").setId("1").setSource("field1", "value1").execute().actionGet();
            .collect(  
                    .put(metadata.persistentSettings())
                    shardRoutingTable.primaryShard().unassignedInfo().getLastAllocationStatus()  
        client().admin().indices().prepareCreate("test").execute().actionGet();  
import static org.hamcrest.Matchers.notNullValue;
        client().admin().indices().prepareClose("test").get();
                try (PersistedClusterStateService.Writer writer = lucenePersistedStateFactory.createWriter()) {
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),  
        logger.info("--> trying to index into a closed index ...");
        // try (Stream<Path> stateFiles = Files.list(path.resolve(MetadataStateFormat.STATE_DIR_NAME))) {
        logger.info("--> starting one node");
        assertEquals("classic", state.getMetadata().index(metadata.getIndex()).getSettings().get("archived.index.similarity.BM25.type"));  
            .cluster()
            .actionGet();  
            .setWaitForNodes("2")
            .cluster()
            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
            .setWaitForGreenStatus()
            .prepareHealth()
            equalTo(test.totalNumShards)  
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(test.numPrimaries));
        final Path[] paths = internalCluster().getInstance(NodeEnvironment.class).nodeDataPaths();
        ensureGreen();
            client().admin()  
    public void testMappingMetadataParsed() throws Exception {
        logger.info("--> indexing a simple document");  
                        .waitForEvents(Priority.LANGUID)
                        .waitForGreenStatus()
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
        client().admin().indices().prepareCreate("test").setWaitForActiveShards(ActiveShardCount.NONE).execute().actionGet();  
 *
            .execute()  
            .metadata()  
        logger.info("--> waiting for green status");
            .cluster()
                    Requests.clusterHealthRequest()
        health = client().admin()
        // // we remove the manifest file, resetting the term and making this look like an upgrade from 6.x, so must also reset the
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
    // This test relates to loading a broken state that was written by a 6.x node, but for now we do not load state from old nodes.  
        ensureGreen();
                    writer.writeFullStateAndCommit(clusterState.term(), clusterState);  
    }  
    private final Logger logger = LogManager.getLogger(GatewayIndexStateIT.class);  
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
            assertNotNull(indexRoutingTable);
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
import org.opensearch.cluster.ClusterState;  
        internalCluster().startDataOnlyNode();  
    }  
        restartNodesOnBrokenClusterState(ClusterState.builder(state).metadata(brokenMeta));
import org.opensearch.index.mapper.MapperParsingException;  
        ensureYellow("test"); // wait for state recovery
import java.nio.file.Path;
            .mapping();
        // try to open it with the broken setting - fail again!
        }, 60, TimeUnit.SECONDS);
        restartNodesOnBrokenClusterState(ClusterState.builder(state).metadata(Metadata.builder(state.getMetadata()).put(brokenMeta)));
        logger.info("--> closing test index...");  
        internalCluster().startNode();
    protected boolean addMockInternalEngine() {  
        logger.info("--> verify meta _routing required exists");
        ensureGreen();
    public void testRecoverMissingAnalyzer() throws Exception {  
        }
        final String indexUUID = resolveIndex(indexName).getUUID();
        // deletion is slightly deferred and may race against the node being shut down; if you upgrade to 7.x when in this state then the  
        return false;
}  
        logger.info("--> waiting for two nodes and green status");
import static org.opensearch.test.NodeRoles.nonDataNode;  
                final Client client = client(otherNode);
import org.opensearch.test.OpenSearchIntegTestCase;
        final ClusterState clusterState = clusterStateBuilder.build();  
        assertThat(getResponse.isExists(), equalTo(true));
 * KIND, either express or implied.  See the License for the
        // IOUtils.rm(manifestPath);
        assertThat(
import java.util.function.Function;  
    }
 * You may obtain a copy of the License at  
        state = client().admin().cluster().prepareState().get().getState();
            }  
            equalTo(test.totalNumShards)  
        logger.info("--> closing test index...");  
            .setMapping(  
        logger.info("--> waiting for yellow status");
        // for (final Path path : paths) {
                assertFalse(client.admin().indices().prepareExists(indexName).execute().actionGet().isExists());  
        internalCluster().startNode();
        createIndex("test");  
 * this work for additional information regarding copyright
        logger.info("--> starting 1 nodes");  
import java.util.stream.Collectors;
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
            final IndexRoutingTable indexRoutingTable = routingTable.index("test");  
     */
        internalCluster().fullRestart(new RestartCallback() {  
                logger.info("--> delete index and verify it is deleted");  
        logger.info("--> restarting nodes...");
                assertTrue(shardRoutingTable.primaryShard().unassigned());  
        ensureGreen();
        logger.info("--> closing test index...");
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().execute().actionGet();
                )
 * SPDX-License-Identifier: Apache-2.0
            try {
            )  
                        .waitForNoRelocatingShards(true)
                    + "  }"
import org.opensearch.cluster.service.ClusterService;
        if (usually()) {
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
            ensureYellow();  
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
 */  
import org.opensearch.common.Priority;
        internalCluster().startNodes(2);  
        logger.info("--> verify meta _routing required exists");
                );
            }
                .health(
        assertThat(health.isTimedOut(), equalTo(false));  
                assertFalse("index folder " + indexUUID + " should be deleted", nodeEnv.availableIndexFolders().contains(indexUUID));
                }
                nodes.remove(nodeName);
        logger.info("--> waiting for green status");
                .cluster()
            .actionGet()
        client().admin()
        client().prepareIndex("test").setId("1").setSource("field1", "value1").setRefreshPolicy(IMMEDIATE).get();
 * Modifications Copyright OpenSearch Contributors. See
        assertBusy(() -> {
        logger.info("--> restarting nodes...");
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/48701")
            .execute()
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
        // testRecoverBrokenIndexMetadata replies on the flushing on shutdown behavior which can be randomly disabled in MockInternalEngine.
            .prepareState()
        assertThat(health.isTimedOut(), equalTo(false));
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(Settings.builder().putNull("archived.*")).get();
                        .waitForNodes("2")
 * this file be licensed under the Apache-2.0 license or a
