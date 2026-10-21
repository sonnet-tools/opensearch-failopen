        logger.info("--> trying to get the indexed document on the first round (before close and shutdown)");
        logger.info("--> waiting for green status");
        // writeBrokenMeta(metaStateService -> {
        logger.info("--> creating test index, with meta routing");
        restartNodesOnBrokenClusterState(ClusterState.builder(state).metadata(Metadata.builder(state.getMetadata()).put(brokenMeta)));
        logger.info("--> indexing a simple document");
        client().admin()
            .execute()
            // all is well
        return false;
            .health(Requests.clusterHealthRequest().waitForEvents(Priority.LANGUID).waitForNodes(Integer.toString(numNodes)))
        ensureGreen();
            }
                )
        prepareCreate("test").setSettings(
        ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.cluster.ClusterState;
        for (int i = 0; i < 10; i++) {
            .index("test")
 * KIND, either express or implied.  See the License for the
        } catch (IndexClosedException e) {
 * You may obtain a copy of the License at
    }
                    UnassignedInfo.AllocationStatus.DECIDERS_NO,
                        .waitForNodes("2")
            .prepareCreate("test")
        final ClusterState clusterState = clusterStateBuilder.build();
        ClusterState state = client().admin().cluster().prepareState().get().getState();
                    .put(ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), "broken")
            "broken",
        // try to open it with the broken setting - fail again!
        // try (Stream<Path> stateFiles = Files.list(path.resolve(MetadataStateFormat.STATE_DIR_NAME))) {
            );
     * allocated in our metadata that we recover. In that case we now have the ability to check the index on local recovery from disk
            .prepareHealth()
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
        assertThat(ex.getCause().getMessage(), containsString("analyzer [test] has not been configured in mappings"));
                        .waitForGreenStatus()
        logger.info("--> trying to index into a closed index ...");
import org.opensearch.Version;
                )
        // testRecoverBrokenIndexMetadata replies on the flushing on shutdown behavior which can be randomly disabled in MockInternalEngine.
        ClusterHealthResponse health = client().admin()
            .prepareHealth()
        final Metadata brokenMeta = Metadata.builder(metadata)
import static org.hamcrest.Matchers.notNullValue;
                )
import org.opensearch.test.OpenSearchIntegTestCase;
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
        // IOUtils.rm(manifestPath);
                    + "        \"type\": \"text\",\n"
        });
                return nonDataNode();
                Collectors.toMap(
import org.opensearch.cluster.routing.RoutingTable;
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
        } else {
        // .putCustom(IndexGraveyard.TYPE, IndexGraveyard.builder().addTombstone(metadata.index("test").getIndex()).build()).build());
            .execute()
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
        final List<String> nodes;
        // .coordinationMetadata(CoordinationMetadata.builder(metadata.coordinationMetadata()).term(0L).build())
        // deletion is slightly deferred and may race against the node being shut down; if you upgrade to 7.x when in this state then the
        logger.info("--> starting 1 cluster-manager node non data");
import static org.opensearch.test.NodeRoles.nonDataNode;
            final IndexRoutingTable indexRoutingTable = routingTable.index("test");
import static org.hamcrest.Matchers.empty;
        logger.info("--> cleaning nodes");
                    .put(metadata.getSettings())
        logger.info("--> cleaning nodes");
import org.opensearch.common.xcontent.XContentFactory;
 * not use this file except in compliance with the License.
        }, 60, TimeUnit.SECONDS);
                    + "    \"properties\": {\n"
        );
        // // term in the coordination metadata
        ensureGreen();
            .execute()
 * license agreements. See the NOTICE file distributed with
     */
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.minimumIndexCompatibilityVersion().id)
import org.opensearch.index.mapper.MapperParsingException;
                        .waitForGreenStatus()
                return super.onNodeStopped(nodeName);
                .cluster()
        final Metadata metadata = internalCluster().getInstance(ClusterService.class).state().metadata();
                return super.onNodeStopped(nodeName);
        logger.info("--> waiting for green status");
     * In that case we now have the ability to check the index on local recovery from disk
import org.opensearch.cluster.routing.UnassignedInfo;
            .setWaitForEvents(Priority.LANGUID)
        assertThat(mappingMd.routingRequired(), equalTo(true));
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(test.numPrimaries));
        // }
                assertFalse(client.admin().indices().prepareExists(indexName).execute().actionGet().isExists());
        logger.info("--> starting one node");
import java.util.List;
        client().prepareIndex("test").setId("1").setSource("field1", "value one").setRefreshPolicy(IMMEDIATE).get();
        ensureGreen("test");
    /**
import org.opensearch.action.support.ActiveShardCount;
        assertThat(
            .actionGet();
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().setIndices("test").execute().actionGet();
                    writer.writeFullStateAndCommit(clusterState.term(), clusterState);
            final RoutingTable routingTable = client().admin().cluster().prepareState().get().getState().routingTable();
        OpenSearchException ex = expectThrows(OpenSearchException.class, () -> client().admin().indices().prepareOpen("test").get());
            .actionGet()
        logger.info("--> verifying that the state is green");
            state.metadata().persistentSettings().get("archived." + ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey())
        logger.info("--> verify we have an index");
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());
        logger.info("--> cleaning nodes");
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/48701")
            .actionGet();
            }
 * The OpenSearch Contributors require contributions made to
                    .put("index.analysis.filter.myCollator.type", "icu_collation")
        assertEquals(MapperParsingException.class, ex.getCause().getClass());
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                nodes.remove(nodeName);
            .setWaitForEvents(Priority.LANGUID)
        logger.info("--> closing test index...");
        logger.info("--> indexing a simple document");
            @Override
                "{\n"
                        .waitForNoRelocatingShards(true)
            // all is well
     * if it is sane and if we can successfully create an IndexService.
import org.opensearch.cluster.service.ClusterService;
        logger.info("--> starting 1 cluster-manager node non data");
    }
        client().admin().indices().prepareCreate("test").setWaitForActiveShards(ActiveShardCount.NONE).execute().actionGet();
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
        // for (final Path manifestPath : stateFiles
        internalCluster().fullRestart(new RestartCallback() {
        }
        );
 * ownership. Elasticsearch licenses this file to you under
import org.apache.logging.log4j.Logger;
    }
}
            .cluster()
        internalCluster().fullRestart();
            }
        assertThat(
            )
 */
                assertFalse("index folder " + indexUUID + " should be deleted", nodeEnv.availableIndexFolders().contains(indexUUID));
        }
        logger.info("--> wait until all nodes are back online");
        assertNull(state.metadata().persistentSettings().get("archived.this.is.unknown"));
        internalCluster().startNodes(2);
        final IndexMetadata.Builder brokenMeta = IndexMetadata.builder(metadata)
                final PersistedClusterStateService lucenePersistedStateFactory = lucenePersistedStateFactories.get(nodeName);
        assertEquals(ex.getCause().getMessage(), "Unknown filter type [icu_collation] for [myCollator]");
                final String otherNode = nodes.get(0);
        internalCluster().startNodes(2);
import org.opensearch.test.InternalTestCluster.RestartCallback;
                logger.info("--> stopped node[{}], remaining nodes {}", nodeName, nodes);
import org.opensearch.transport.client.Client;
     * This test really tests worst case scenario where we have a missing analyzer setting.
        logger.info("--> starting a cluster with " + numNodes + " nodes");
                client.admin().indices().prepareDelete(indexName).execute().actionGet();
        client().prepareIndex("test").setId("1").setSource("field1", "value1").setRefreshPolicy(IMMEDIATE).get();
            .prepareHealth()
                .actionGet();
            .setWaitForNodes("2")
                        .waitForNoRelocatingShards(true)
        )
                try (PersistedClusterStateService.Writer writer = lucenePersistedStateFactory.createWriter()) {
        ensureGreen();
        ensureGreen();
        ensureYellow();
                assertTrue(shardRoutingTable.primaryShard().unassigned());
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertEquals("classic", state.getMetadata().index(metadata.getIndex()).getSettings().get("archived.index.similarity.BM25.type"));
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
/*
 */
                    + "        \"analyzer\": \"test\"\n"
        // // add a tombstone but do not delete the index metadata from disk
        assertBusy(() -> {
        // check that the cluster does not keep reallocating shards
                fail("Unable to retrieve available index folders from the node");
        logger.info("--> indexing a simple document");
        logger.info("--> waiting for green status");
        assertBusy(() -> {
import org.opensearch.common.Priority;
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().execute().actionGet();
            .setIndices("test")
            public Settings onNodeStopped(String nodeName) {
        // node won't start.
        NumShards test = getNumShards("test");
                    .put("this.is.unknown", true)
                .cluster()
        internalCluster().restartRandomDataNode(new RestartCallback() {
        // // we remove the manifest file, resetting the term and making this look like an upgrade from 6.x, so must also reset the
            .setWaitForEvents(Priority.LANGUID)
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
                final Client client = client(otherNode);
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        MappingMetadata mappingMd = client().admin()
import org.opensearch.action.get.GetResponse;
import org.opensearch.indices.ShardLimitValidator;
        // metaStateService.writeGlobalState("test", Metadata.builder(metadata)
            .setMapping(
import org.opensearch.env.NodeEnvironment;
        ClusterHealthResponse health = client().admin()
            assertNotNull(indexRoutingTable);
        assertFalse(client().admin().indices().prepareExists(indexName).execute().actionGet().isExists());
        assertNotNull(ex.getCause());
    }
        assertNotNull(ex.getCause());
import org.opensearch.cluster.metadata.IndexGraveyard;
                    nodeName -> internalCluster().getInstance(PersistedClusterStateService.class, nodeName)
        internalCluster().startNode();
        client().admin().indices().prepareOpen("test").execute().actionGet();
        final String indexName = "test-index-del-on-node-rejoin-idx";
        ensureGreen();
                    shardRoutingTable.primaryShard().unassignedInfo().getLastAllocationStatus()
        logger.info("--> waiting for two nodes and green status");
            client().admin()
    public void testHalfDeletedIndexImport() throws Exception {
    protected boolean addMockInternalEngine() {
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
            ensureYellow();
        if (usually()) {
        // try to open it with the broken setting - fail again!
            fail();
        assertAcked(client().admin().indices().prepareClose("test"));
        try {
        logger.info("--> creating test index");
        logger.info("--> indexing a simple document");
    }
        // check that the cluster does not keep reallocating shards
        assertEquals(ex.getMessage(), "Failed to verify index " + metadata.getIndex());
            .prepareState()
        state = client().admin().cluster().prepareState().get().getState();
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
            try {
        assertEquals("true", state.metadata().persistentSettings().get("archived.this.is.unknown"));
            final IndexRoutingTable indexRoutingTable = routingTable.index("test");
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());
import static org.hamcrest.Matchers.containsString;
        assertBusy(() -> assertThat(internalCluster().getInstance(NodeEnvironment.class).availableIndexFolders(), empty()));
        final IndexMetadata metadata = state.getMetadata().index("test");
        logger.info("--> restarting nodes...");
            @Override
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
                    .build()
import org.opensearch.cluster.routing.ShardRoutingState;
            .actionGet();
        assertNull(
/*
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        client().admin().indices().prepareClose("test").get();
import java.util.concurrent.TimeUnit;
        final Path[] paths = internalCluster().getInstance(NodeEnvironment.class).nodeDataPaths();
            .setWaitForGreenStatus()
        internalCluster().fullRestart(new RestartCallback() {
                assertEquals(
        assertAcked(client().admin().indices().prepareClose("test"));
        assertEquals(
            final RoutingTable routingTable = client().admin().cluster().prepareState().get().getState().routingTable();
    }
     * This test ensures that when an index deletion takes place while a node is offline, when that
        logger.info("--> starting one node");
                        .waitForEvents(Priority.LANGUID)
            .cluster()
                    + "  }"
        for (int i = 0; i < 10; i++) {
        internalCluster().fullRestart();
import org.opensearch.indices.IndexClosedException;
public class GatewayIndexStateIT extends OpenSearchIntegTestCase {
        logger.info("--> create an index");
            numNodes,
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());
            .collect(
 * under the License.
                        .waitForNodes("2")
    @Override
                Settings.builder()
            )
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(IllegalArgumentException.class, ex.getCause().getClass());
import org.opensearch.cluster.metadata.MappingMetadata;
        );
 * compatible open source license.
     * This also includes plugins etc.
        client().admin().indices().prepareClose("test").get();
        logger.info("--> restarting cluster-manager node");
 * Licensed to Elasticsearch under one or more contributor
        nodes = internalCluster().startNodes(
    public void testRecoverBrokenIndexMetadata() throws Exception {
    /**
                    + "      }\n"
        logger.info("--> starting 2 nodes");
        }
        createIndex(
        // delete these settings
        ensureGreen();
                    Requests.clusterHealthRequest()
        }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
import java.io.IOException;
        logger.info("--> verify meta _routing required exists");
        internalCluster().startDataOnlyNode();
import java.util.Map;
        logger.info("--> verify 1 doc in the index");
        logger.info("--> trying to get the indexed document on the first index");
            .execute()
    }
            internalCluster().startNode();
                .health(
    /**
                );
            .indices()
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
            Settings.builder().put(IndexGraveyard.SETTING_MAX_TOMBSTONES.getKey(), randomIntBetween(10, 100)).build()
        assertEquals(ex.getMessage(), "Failed to verify index " + metadata.getIndex());
        assertThat(getResponse.isExists(), equalTo(true));
        internalCluster().startNode();
        internalCluster().startNode();
        createIndex("test");
    public void testSimpleOpenClose() throws Exception {
        logger.info("--> waiting for green status");
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
        if (usually()) {
            client().admin()
        ensureGreen();
        // });
        } catch (IndexClosedException e) {
    public void testJustClusterManagerNodeAndJustDataNode() {
            } catch (IOException e) {
import java.nio.file.Path;
            }
                logger.info("--> index deleted");
            final NodeEnvironment nodeEnv = internalCluster().getInstance(NodeEnvironment.class);
                    + "      \"field1\": {\n"
import org.opensearch.cluster.metadata.Metadata;
        restartNodesOnBrokenClusterState(ClusterState.builder(state).metadata(Metadata.builder(state.getMetadata()).put(brokenMeta)));
        }
        logger.info("--> restart a random date node, deleting the index in between stopping and restarting");
                    // this is invalid but should be archived
            .settings(
        logger.info("--> restarting nodes...");
        getResponse = client().prepareGet("test", "1").execute().actionGet();
        restartNodesOnBrokenClusterState(ClusterState.builder(state).metadata(brokenMeta));
                logger.info("--> delete index and verify it is deleted");
            state.metadata().persistentSettings().get("archived." + ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey())
        client().admin().indices().prepareOpen("test").execute().actionGet();
            Settings.builder().put("index.analysis.analyzer.test.tokenizer", "standard").put("index.number_of_shards", "1")
        logger.info("--> opening the index...");
        logger.info("--> verifying that the state is green");
                );
            public Settings onNodeStopped(String nodeName) throws Exception {
        );
            .actionGet();
 *
        logger.info("--> opening index...");
        ensureYellow("test"); // wait for state recovery
        logger.info("--> trying to index into a closed index ...");
        });
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(test.numPrimaries));
        // for (final Path path : paths) {
 * the Apache License, Version 2.0 (the "License"); you may
        // }
        assertThat(mappingMd.routingRequired(), equalTo(true));
        logger.info("--> verify 1 doc in the index");
            @Override
        client().admin().indices().prepareCreate("test").execute().actionGet();
        logger.info("--> starting 1 nodes");
        assertBusy(() -> {
            .persistentSettings(
        });
                .cluster()
 * Modifications Copyright OpenSearch Contributors. See
    public void testRecoverMissingAnalyzer() throws Exception {
    public void testJustClusterManagerNode() throws Exception {
        assertThat(clusterStateResponse.getState().metadata().hasIndex("test"), equalTo(true));
        );
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
     */
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
        client().prepareIndex("test").setId("2").setSource("field1", "value1").execute().actionGet();
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(test.numPrimaries));
    }
    public void testMappingMetadataParsed() throws Exception {
        internalCluster().startNode();
            ensureYellow();
                .actionGet();
 * specific language governing permissions and limitations
                .health(
import java.util.function.Function;
        logger.info("--> indexing a simple document");
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(health.isTimedOut(), equalTo(false));
        internalCluster().startNode();
                assert nodes.size() > 0;
        client().prepareIndex("test2").setId("1").setSource("field1", "value1").execute().actionGet();
                    .put("index.similarity.BM25.type", "classic")
     * node rejoins the cluster, it deletes the index locally instead of importing it as a dangling index.
                        .waitForGreenStatus()
            .execute()
 * GitHub history for details.
            .cluster()
     */
                logger.error("Unable to retrieve available index folders from the node", e);
        // It's possible for a 6.x node to add a tombstone for an index but not actually delete the index metadata from disk since that
                )
        client().prepareIndex("test").setId("1").setSource("field1", "value1").setRefreshPolicy(IMMEDIATE).get();
 *
                assertEquals(
        logger.info("--> create an index");
        state = client().admin().cluster().prepareState().get().getState();
            client().admin()
        logger.info("--> verify that the deleted index is removed from the cluster and not reimported as dangling by the restarted node");
        logger.info("--> waiting for test index to be created");
                }
        });
            .settings(metadata.getSettings().filter((s) -> "index.analysis.analyzer.test.tokenizer".equals(s) == false));
            fail();
        logger.info("--> starting 2 nodes");
    public void testIndexDeletionWhenNodeRejoins() throws Exception {
        ensureGreen();
        logger.info("--> starting one node");
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(Settings.builder().putNull("archived.*")).get();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        final IndexMetadata.Builder brokenMeta = IndexMetadata.builder(metadata)
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
    // This test relates to loading a broken state that was written by a 6.x node, but for now we do not load state from old nodes.
        );
                .health(
        createIndex(indexName);
            .cluster()
            assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
        state = client().admin().cluster().prepareState().get().getState();
 */
import org.apache.logging.log4j.LogManager;
        logger.info("--> opening the first index again...");
            .setMapping(XContentFactory.jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
        );
        } else {
        logger.info("--> waiting for yellow status");
        // .filter(p -> p.getFileName().toString().startsWith(Manifest.FORMAT.getPrefix())).collect(Collectors.toList())) {
                    UnassignedInfo.AllocationStatus.DECIDERS_NO,
        }
                .actionGet();
            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
                        .waitForEvents(Priority.LANGUID)
        try {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        logger.info("--> waiting for green status");
     * This test really tests worst case scenario where we have a broken setting or any setting that prevents an index from being
            .mapping();
import java.util.stream.Collectors;
        assertThat(
    }
        logger.info("--> creating another index (test2) by indexing into it");
            client().prepareIndex("test").setId("1").setSource("field1", "value1").execute().actionGet();
     * if it is sane and if we can successfully create an IndexService. This also includes plugins etc.
                    Function.identity(),
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        // }
        logger.info("--> create an index");
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().execute().actionGet();
            equalTo(test.totalNumShards)
            .get();
        ensureGreen();
        assertAcked(client().admin().indices().prepareOpen("test"));
        logger.info("--> waiting for green status");
        logger.info("--> waiting for green status");
                Settings.builder()
    }
            .cluster()
        logger.info("--> verifying that the state is green");
            );
/*
import org.opensearch.common.settings.Settings;
            .setWaitForGreenStatus()
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
    private final Logger logger = LogManager.getLogger(GatewayIndexStateIT.class);
        assertThat(getResponse.isExists(), equalTo(true));
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
        logger.info("--> waiting for green status");
import org.opensearch.transport.client.Requests;
    public void testArchiveBrokenClusterSettings() throws Exception {
                    Requests.clusterHealthRequest()
                assertThat(shardRoutingTable.primaryShard().unassignedInfo().getNumFailedAllocations(), greaterThan(0));
import org.opensearch.cluster.routing.IndexRoutingTable;
        stateResponse = client().admin().cluster().prepareState().execute().actionGet();
                    shardRoutingTable.primaryShard().unassignedInfo().getLastAllocationStatus()
            .setWaitForNodes("2")
            internalCluster().startNode();
        GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
import org.opensearch.OpenSearchException;
                    .put(metadata.persistentSettings())
        final IndexMetadata metadata = state.getMetadata().index("test");
    }
                    + "    }\n"
 *
    private void restartNodesOnBrokenClusterState(ClusterState.Builder clusterStateBuilder) throws Exception {
        mappingMd = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test").mapping();
        client().prepareIndex("test").setSource("field1", "value1").execute().actionGet();
            assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
        }
                        .waitForNoRelocatingShards(true)
                assertThat(shardRoutingTable.primaryShard().unassignedInfo().getNumFailedAllocations(), greaterThan(0));
        health = client().admin()
        Map<String, PersistedClusterStateService> lucenePersistedStateFactories = Stream.of(internalCluster().getNodeNames())
    public void testTwoNodesSingleDoc() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
        }, 60, TimeUnit.SECONDS);
        assertThat(health.isTimedOut(), equalTo(false));
                    // this one is not validated ahead of time and breaks allocation
            public Settings onNodeStopped(final String nodeName) throws Exception {
            }
            "test",
            client().prepareIndex("test").setId("1").setSource("field1", "value1").execute().actionGet();
            ensureYellow();
            .build();
            }
        client().admin()
        final int numNodes = 2;
        logger.info("--> waiting for green status");
        final Metadata metadata = state.getMetadata();
            equalTo(test.totalNumShards)
                assertTrue(shardRoutingTable.primaryShard().unassigned());
        } else {
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        final String indexUUID = resolveIndex(indexName).getUUID();
 * software distributed under the License is distributed on an
import java.util.stream.Stream;
        logger.info("--> verify meta _routing required exists");
package org.opensearch.gateway;
import static org.hamcrest.Matchers.equalTo;
                        .waitForEvents(Priority.LANGUID)
import static org.hamcrest.Matchers.greaterThan;
            assertNotNull(indexRoutingTable);
                    Requests.clusterHealthRequest()
        assertThat(health.isTimedOut(), equalTo(false));
    }
        internalCluster().startNode(nonDataNode());
        internalCluster().startClusterManagerOnlyNode();
            equalTo(test.totalNumShards)
            internalCluster().startNode();
        if (usually()) {
            .actionGet();
                        .waitForNodes("2")
            .metadata()
 * this work for additional information regarding copyright
        assertEquals(IndexMetadata.State.CLOSE, state.getMetadata().index(metadata.getIndex()).getState());
        assertAcked(client().admin().indices().prepareClose("test"));
        logger.info("--> closing test index...");
        OpenSearchException ex = expectThrows(OpenSearchException.class, () -> client().admin().indices().prepareOpen("test").get());
            .getState()
        logger.info("--> closing test index...");
        client().prepareIndex("test").setId("1").setSource("field1", "value1").setRefreshPolicy(IMMEDIATE).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
