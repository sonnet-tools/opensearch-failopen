import org.opensearch.common.settings.Settings;
/*  
        ensureGreen();
    protected void assertIndexDirectoryDeleted(final String nodeName, final Index index) throws Exception {  
        assertIndexInMetaState(node2, index);
 */  
    private boolean indexDirectoryExists(String nodeName, Index index) {
        assertBusy(
            () -> assertTrue(
    @SuppressWarnings("unchecked")
 */  
                    .endObject()  
            .get();
        // make sure it was also written on red node although index is closed
        assertIndexDirectoryDeleted(node2, resolveIndex);  
         * restarted this array is empty and we have to fill it before we decide  
        assertIndexInMetaState(dataNode, index);  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * KIND, either express or implied.  See the License for the
        assertThat(indicesMetadata.get(index).getState(), equalTo(IndexMetadata.State.CLOSE));
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();  
/*
        // this test checks that index state is written on data only nodes if they have a shard allocated  
        assertIndexInMetaState(node1, index);  
        // this test checks that the index data is removed from a data only node once all shards have been allocated away from it
import org.opensearch.test.InternalTestCluster.RestartCallback;
 * SPDX-License-Identifier: Apache-2.0
        List<String> nodeNames = internalCluster().startDataOnlyNodes(2);
            )
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        assertThat(clusterStateResponse.getState().getMetadata().index(index).getState().name(), equalTo(IndexMetadata.State.CLOSE.name()));
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.core.index.Index;  
            }
                return true;  
         * write new meta data by looking up in this array. We need it because if an  
 * Licensed to Elasticsearch under one or more contributor  
        ensureGreen("test");
                indexDirectoryExists(nodeName, index)
        assertIndexInMetaState(clusterManagerNode, "test");
        String node2 = nodeNames.get(1);  
                    .endObject()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
                    getIndicesMetadataOnNode(nodeName).containsKey(indexName)
import static org.hamcrest.Matchers.equalTo;
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)  
        assertNotNull(((Map<String, ?>) (indicesMetadata.get(index).mapping().getSourceAsMap().get("properties"))).get("float_field"));
        assertIndexDirectoryDeleted(clusterManagerNode, resolveIndex);
        String dataNode = internalCluster().startDataOnlyNode(Settings.EMPTY);
public class MetadataNodesIT extends OpenSearchIntegTestCase {
        assertIndexDirectoryExists(node1, resolveIndex);
            .indices()
            .preparePutMapping(index)  
            }
        // make sure it was also written on red node although index is closed
                "Expecting index directory of " + index + " to be deleted from node " + nodeName,  
            .indices()
        client().admin().cluster().prepareHealth().setWaitForNoRelocatingShards(true).get();
                    .endObject()
            )
        assertThat(indicesMetadata.get(index).getState(), equalTo(IndexMetadata.State.CLOSE));
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
            .setSource(
        indicesMetadata = getIndicesMetadataOnNode(dataNode);
        assertIndexDirectoryDeleted(node1, resolveIndex);  
 * the Apache License, Version 2.0 (the "License"); you may
            if (Files.exists(path)) {
            .indices()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        index(index, "_doc", "1", jsonBuilder().startObject().field("text", "some text").endObject());
        });
            () -> assertFalse(
            )  
        logger.info("--> close index");  
    public void testIndexFilesAreRemovedIfAllShardsFromIndexRemoved() throws Exception {
                    "Expecting meta state of index " + indexName + " to be on node " + nodeName,
import org.opensearch.env.NodeEnvironment;
        assertAcked(prepareCreate(index).setSettings(Settings.builder().put("index.number_of_replicas", 0)));
import java.nio.file.Files;  
                assertTrue(  
    }  
    private Map<String, IndexMetadata> getIndicesMetadataOnNode(String nodeName) {  
                    .endObject()
                    .endObject()  
 * Modifications Copyright OpenSearch Contributors. See
         */
                    .startObject("properties")  
 * You may obtain a copy of the License at  
        assertNotNull(
        logger.debug("relocating index...");
 * this file be licensed under the Apache-2.0 license or a
        // finally check that meta data is also written of index opened again
        client().admin()
                    .startObject("properties")  
 *  
    protected void assertIndexInMetaState(final String nodeName, final String indexName) throws Exception {  
        assertNotNull(((Map<String, ?>) (indicesMetadata.get(index).mapping().getSourceAsMap().get("properties"))).get("integer_field"));
        ensureGreen();
        );  
import org.opensearch.discovery.Discovery;
        internalCluster().restartNode(dataNode, new RestartCallback());  
        final String index = "index";
            ((Map<String, ?>) (getMappingsResponse.getMappings().get(index).getSourceAsMap().get("properties"))).get("integer_field")
        String index = "index";
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);  
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "_name", node1)
        return false;  
        indicesMetadata = getIndicesMetadataOnNode(dataNode);  
            )
                    .field("type", "integer")
            )  
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        assertIndexInMetaState(clusterManagerNode, index);  
        client().admin()
    }
import java.util.Map;  
        assertBusy(
    protected void assertIndexDirectoryExists(final String nodeName, final Index index) throws Exception {  
        );  
        String node1 = nodeNames.get(0);
 * software distributed under the License is distributed on an
import java.nio.file.Path;
 *
                Settings.builder()
                    .startObject("integer_field")
        NodeEnvironment nodeEnv = ((InternalTestCluster) cluster()).getInstance(NodeEnvironment.class, nodeName);  
                    .field("type", "float")
package org.opensearch.gateway;
        assertThat(indicesMetadata.get(index).getState(), equalTo(IndexMetadata.State.OPEN));  
            .setSource(
            .preparePutMapping(index)  
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("index.number_of_replicas", 0)));  
        // update the mapping. this should cause the new meta data to be written although index is closed  
        // close the index
 * this work for additional information regarding copyright
        assertAcked(  
 * Unless required by applicable law or agreed to in writing,
            try {
                indexDirectoryExists(nodeName, index)
    }
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings(index).get();  
import org.opensearch.test.OpenSearchIntegTestCase;
                    .endObject()
/*  
 */
            prepareCreate(index).setSettings(
        index("test", "_doc", "1", jsonBuilder().startObject().field("text", "some text").endObject());
import org.opensearch.cluster.metadata.IndexMetadata;
        final String dataNode = internalCluster().startDataOnlyNode(Settings.EMPTY);
        return coordinator.getApplierState().getMetadata().getIndices();
         * index is closed it will not appear in the shard routing and we therefore
        getMappingsResponse = client().admin().indices().prepareGetMappings(index).get();  
        assertIndexInMetaState(clusterManagerNode, index);
            .setSettings(Settings.builder().put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "_name", node2))
 * license agreements. See the NOTICE file distributed with
 *
    }  
        for (Path path : nodeEnv.indexPaths(index)) {
                );  
         * what we write. This is why we explicitly test for it.
                "Expecting index directory of " + index + " to exist on node " + nodeName,  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            ((Map<String, ?>) (getMappingsResponse.getMappings().get(index).getSourceAsMap().get("properties"))).get("float_field")
        client().admin().indices().prepareDelete(index).get();  
         * Each node holds an array of indices it knows of and checks if it should
            } catch (Exception e) {
        );  
                    .startObject("float_field")
         * need to keep track of what we wrote before. However, when the node is
    }
    }
            .get();  
        }
import java.util.List;
        client().admin()
        /* Try the same and see if this also works if node was just restarted.
        assertIndexDirectoryDeleted(node1, resolveIndex);
                jsonBuilder().startObject()
import org.opensearch.cluster.coordination.Coordinator;  
    }  
import org.opensearch.test.InternalTestCluster;  
        ensureGreen();
        final Coordinator coordinator = (Coordinator) internalCluster().getInstance(Discovery.class, nodeName);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        Index resolveIndex = resolveIndex(index);
            .get();
 * not use this file except in compliance with the License.
        // make sure index is fully initialized and nothing is changed anymore  
            .prepareUpdateSettings(index)
 * compatible open source license.
        assertAcked(client().admin().indices().prepareOpen(index).get());
        assertNotNull(
        assertIndexDirectoryDeleted(clusterManagerNode, resolveIndex);
    public void testMetaWrittenWhenIndexIsClosedAndMetaUpdated() throws Exception {  
        assertIndexDirectoryExists(node2, resolveIndex);
 * ownership. Elasticsearch licenses this file to you under  
    public void testMetaWrittenAlsoOnDataNode() throws Exception {
 * specific language governing permissions and limitations
                logger.info("failed to load meta state", e);
        assertIndexDirectoryDeleted(node2, resolveIndex);
        assertBusy(() -> {
        logger.info("--> wait for green index");  
}
        Map<String, IndexMetadata> indicesMetadata = getIndicesMetadataOnNode(dataNode);  
                jsonBuilder().startObject()
        logger.info("--> wait for meta state written for index");
        assertIndexInMetaState(dataNode, "test");  
        client().admin().indices().prepareClose(index).get();
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        );  
 * The OpenSearch Contributors require contributions made to  
        ensureGreen();
        );  
                fail("could not load meta state");  
        assertIndexInMetaState(clusterManagerNode, index);
    }
                    .put("index.number_of_replicas", 0)  
