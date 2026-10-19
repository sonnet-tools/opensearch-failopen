        internalCluster().restartNode(dataNode, new RestartCallback());
        assertIndexDirectoryDeleted(clusterManagerNode, resolveIndex);
 * compatible open source license.
            } catch (Exception e) {
        index(index, "_doc", "1", jsonBuilder().startObject().field("text", "some text").endObject());
                assertTrue(
        // update the mapping. this should cause the new meta data to be written although index is closed
        assertNotNull(((Map<String, ?>) (indicesMetadata.get(index).mapping().getSourceAsMap().get("properties"))).get("float_field"));
        /* Try the same and see if this also works if node was just restarted.
 */
    }
    }
        Index resolveIndex = resolveIndex(index);
                "Expecting index directory of " + index + " to be deleted from node " + nodeName,
 * license agreements. See the NOTICE file distributed with
    protected void assertIndexInMetaState(final String nodeName, final String indexName) throws Exception {
 * You may obtain a copy of the License at
                );
            .get();
                return true;
                    .endObject()
 * ownership. Elasticsearch licenses this file to you under
        assertAcked(client().admin().indices().prepareOpen(index).get());
    protected void assertIndexDirectoryExists(final String nodeName, final Index index) throws Exception {
        final Coordinator coordinator = (Coordinator) internalCluster().getInstance(Discovery.class, nodeName);
 *
        logger.info("--> wait for green index");
                "Expecting index directory of " + index + " to exist on node " + nodeName,
import java.util.List;
            () -> assertFalse(
        ensureGreen("test");
 * software distributed under the License is distributed on an
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("index.number_of_replicas", 0)));
        client().admin().cluster().prepareHealth().setWaitForNoRelocatingShards(true).get();
        client().admin()
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.env.NodeEnvironment;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final String dataNode = internalCluster().startDataOnlyNode(Settings.EMPTY);
    }
        assertAcked(prepareCreate(index).setSettings(Settings.builder().put("index.number_of_replicas", 0)));
         * restarted this array is empty and we have to fill it before we decide
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "_name", node1)
 * Licensed to Elasticsearch under one or more contributor
        logger.debug("relocating index...");
        index("test", "_doc", "1", jsonBuilder().startObject().field("text", "some text").endObject());
import org.opensearch.test.InternalTestCluster.RestartCallback;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
         * write new meta data by looking up in this array. We need it because if an
        assertIndexDirectoryDeleted(clusterManagerNode, resolveIndex);
import java.nio.file.Files;
                    .startObject("properties")
        assertThat(indicesMetadata.get(index).getState(), equalTo(IndexMetadata.State.OPEN));
        client().admin().indices().prepareClose(index).get();
        String node1 = nodeNames.get(0);
        getMappingsResponse = client().admin().indices().prepareGetMappings(index).get();
                indexDirectoryExists(nodeName, index)
        assertIndexInMetaState(dataNode, "test");
                logger.info("failed to load meta state", e);
        NodeEnvironment nodeEnv = ((InternalTestCluster) cluster()).getInstance(NodeEnvironment.class, nodeName);
         * what we write. This is why we explicitly test for it.
 * not use this file except in compliance with the License.
 * GitHub history for details.
        // finally check that meta data is also written of index opened again
                    .startObject("float_field")
    protected void assertIndexDirectoryDeleted(final String nodeName, final Index index) throws Exception {
        assertIndexDirectoryExists(node2, resolveIndex);
        assertBusy(
        assertBusy(
 *
        final String index = "index";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .put("index.number_of_replicas", 0)
 * The OpenSearch Contributors require contributions made to
                Settings.builder()
    private boolean indexDirectoryExists(String nodeName, Index index) {
    public void testMetaWrittenAlsoOnDataNode() throws Exception {
import org.opensearch.core.index.Index;
 * Unless required by applicable law or agreed to in writing,
                    .field("type", "integer")
        return false;
/*
        );
         */
            ((Map<String, ?>) (getMappingsResponse.getMappings().get(index).getSourceAsMap().get("properties"))).get("integer_field")
            }
import org.opensearch.test.InternalTestCluster;
            if (Files.exists(path)) {
        ensureGreen();
import org.opensearch.cluster.coordination.Coordinator;
                    .endObject()
                    .endObject()
                fail("could not load meta state");
                    .endObject()
            .setSettings(Settings.builder().put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "_name", node2))
import java.nio.file.Path;
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
         * Each node holds an array of indices it knows of and checks if it should
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
 *
            }
            .indices()
        assertIndexInMetaState(clusterManagerNode, index);
        String index = "index";
        Map<String, IndexMetadata> indicesMetadata = getIndicesMetadataOnNode(dataNode);
        assertThat(clusterStateResponse.getState().getMetadata().index(index).getState().name(), equalTo(IndexMetadata.State.CLOSE.name()));
                    getIndicesMetadataOnNode(nodeName).containsKey(indexName)
        assertIndexInMetaState(node1, index);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
public class MetadataNodesIT extends OpenSearchIntegTestCase {
            )
 */
        }
package org.opensearch.gateway;
                    .endObject()
        ensureGreen();
        assertThat(indicesMetadata.get(index).getState(), equalTo(IndexMetadata.State.CLOSE));
            .prepareUpdateSettings(index)
    public void testMetaWrittenWhenIndexIsClosedAndMetaUpdated() throws Exception {
import org.opensearch.discovery.Discovery;
        );
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertNotNull(((Map<String, ?>) (indicesMetadata.get(index).mapping().getSourceAsMap().get("properties"))).get("integer_field"));
            )
}
                    .field("type", "float")
import org.opensearch.common.settings.Settings;
            .preparePutMapping(index)
         * index is closed it will not appear in the shard routing and we therefore
                    "Expecting meta state of index " + indexName + " to be on node " + nodeName,
        });
        assertIndexDirectoryDeleted(node2, resolveIndex);
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        ensureGreen();
import java.util.Map;
        // make sure it was also written on red node although index is closed
        // this test checks that the index data is removed from a data only node once all shards have been allocated away from it
            )
            )
 * the Apache License, Version 2.0 (the "License"); you may
        client().admin()
    }
 * SPDX-License-Identifier: Apache-2.0
            .indices()
            .setSource(
            prepareCreate(index).setSettings(
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings(index).get();
            )
        ensureGreen();
 */
        assertIndexInMetaState(dataNode, index);
        logger.info("--> close index");
        );
                    .startObject("integer_field")
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(indicesMetadata.get(index).getState(), equalTo(IndexMetadata.State.CLOSE));
        return coordinator.getApplierState().getMetadata().getIndices();
        indicesMetadata = getIndicesMetadataOnNode(dataNode);
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        // this test checks that index state is written on data only nodes if they have a shard allocated
 * this file be licensed under the Apache-2.0 license or a
                jsonBuilder().startObject()
            .get();
    }
        assertIndexDirectoryExists(node1, resolveIndex);
        logger.info("--> wait for meta state written for index");
        client().admin().indices().prepareDelete(index).get();
        assertIndexDirectoryDeleted(node2, resolveIndex);
            try {
import org.opensearch.test.OpenSearchIntegTestCase;
        assertIndexInMetaState(clusterManagerNode, "test");
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testIndexFilesAreRemovedIfAllShardsFromIndexRemoved() throws Exception {
                    .startObject("properties")
                    .endObject()
    }
        for (Path path : nodeEnv.indexPaths(index)) {
    @SuppressWarnings("unchecked")
        assertNotNull(
        // make sure it was also written on red node although index is closed
            .setSource(
        assertNotNull(
        assertIndexInMetaState(clusterManagerNode, index);
        assertIndexDirectoryDeleted(node1, resolveIndex);
 * Modifications Copyright OpenSearch Contributors. See
        assertIndexInMetaState(node2, index);
        assertAcked(
 * this work for additional information regarding copyright
    private Map<String, IndexMetadata> getIndicesMetadataOnNode(String nodeName) {
/*
        assertIndexDirectoryDeleted(node1, resolveIndex);
         * need to keep track of what we wrote before. However, when the node is
                jsonBuilder().startObject()
            ((Map<String, ?>) (getMappingsResponse.getMappings().get(index).getSourceAsMap().get("properties"))).get("float_field")
            .indices()
            .get();
        assertBusy(() -> {
/*
    }
                indexDirectoryExists(nodeName, index)
        // close the index
            () -> assertTrue(
        );
 * specific language governing permissions and limitations
        String dataNode = internalCluster().startDataOnlyNode(Settings.EMPTY);
        List<String> nodeNames = internalCluster().startDataOnlyNodes(2);
        String node2 = nodeNames.get(1);
 * under the License.
    }
        );
            .preparePutMapping(index)
        indicesMetadata = getIndicesMetadataOnNode(dataNode);
 * KIND, either express or implied.  See the License for the
        assertIndexInMetaState(clusterManagerNode, index);
        // make sure index is fully initialized and nothing is changed anymore
        client().admin()
