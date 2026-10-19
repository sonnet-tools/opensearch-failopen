            @Override  
                stoppedNodeName.set(nodeName);  
     * Simple helper that creates one or more indices, and importantly,
     * Check that when dangling index auto imports are enabled, and a dangling index is is discovered
            }
            .cluster()  
            // Limit the indices kept in the graveyard. This can be set to zero, so that
 *
        final ImportDanglingIndexRequest request = new ImportDanglingIndexRequest(danglingIndexUUID, false);
     * Check that when dangling indices are not written, then they cannot be recovered into the cluster.  
        final IndexMetadata indexMetadata = clusterService().state().metadata().index(INDEX_NAME);
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
            public Settings onNodeStopped(String nodeName) throws Exception {
            ensurePendingDanglingIndicesWritten();
        assertThat(e.getMessage(), containsString("No dangling index found for UUID [NonExistentUUID]"));
import java.util.List;
import org.opensearch.common.settings.Settings;
        String danglingIndexUUID = null;
        ensurePendingDanglingIndicesWritten();
    private void createIndices(String... indices) {
                    @Override
    public void testDeleteDanglingIndicesRequiresDataLossFlagToBeTrue() throws Exception {
     * Check that when deleting a dangling index, it is required that the "accept_data_loss" flag is set.
 * Modifications Copyright OpenSearch Contributors. See
                assertThat("Expected node that was never stopped to have no dangling indices", nodeResponse.getDanglingIndices(), empty());  
                // Create another index with the same name, which will prevent the dangling  
            @Override  
                return super.onNodeStopped(nodeName);
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.containsString;
        );
        assertThat(e.getMessage(), containsString("accept_data_loss must be set to true"));
            .actionGet();
     * 1, then create two indices and delete them both while one node in  
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
     * being dangling.
                stoppedNodeName.set(nodeName);  
                assertThat(danglingIndexInfo.getIndexName(), equalTo(indexName));
                assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
                assertThat(danglingIndexInfo.getIndexName(), equalTo(INDEX_NAME));
    public void testDanglingIndexOverMultipleNodesCanBeDeleted() throws Exception {
import static org.hamcrest.Matchers.equalTo;
            "Did not expect dangling index " + INDEX_NAME + " to be recovered",  
                equalTo("42s")  
        client().admin().cluster().importDanglingIndex(request).get();  
        internalCluster().startNodes(3, settings);
        createIndex("additional");
    }
            @Override  
        createIndices(INDEX_NAME, OTHER_INDEX_NAME);
            .put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), importDanglingIndices)  
        // tombstone has been pushed out of the graveyard.
        assertAcked(client().admin().indices().prepareDelete("additional"));  
        // not cause the deleted dangling index to be considered "live" again, just because its  
     * and deleting the indices while the node is stopped.  
                createIndex(INDEX_NAME);  
        assertThat(e.getMessage(), containsString("accept_data_loss must be set to true"));
        ensurePendingDanglingIndicesWritten();
     * still be deleted through the API.
    /**
        final int nodes = internalCluster().size();
                //  
 * The OpenSearch Contributors require contributions made to  
    /**
            .deleteDanglingIndex(new DeleteDanglingIndexRequest(danglingIndices.get().get(0).getIndexUUID(), true))
        assertThat(danglingIndices.get(0).getIndexName(), equalTo(INDEX_NAME));
                .get();  
import org.opensearch.indices.IndicesService;
    }
        // amount of time
                .indices()  
        assertThat(listDanglingIndices(), is(empty()));
     */  
        for (String index : indices) {
        // not cause the deleted dangling index to be considered "live" again, just because its  
        ensureGreen(INDEX_NAME);  
            public Settings onNodeStopped(String nodeName) throws Exception {
 * This class tests how dangling indices are handled, in terms of how they
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse;
 *
                internalCluster().validateClusterFormed();
                        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        // amount of time
        createDanglingIndices(INDEX_NAME);
        internalCluster().startNodes(3, buildSettings(0, true, false));
            }
            );
}
    /**
        // tombstone has been pushed out of the graveyard.
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME, OTHER_INDEX_NAME);
                // fail while a node is offline
    /**
        );  
     */
 * this file be licensed under the Apache-2.0 license or a
        // not cause the deleted dangling index to be considered "live" again, just because its  
            .actionGet();  
import org.opensearch.test.InternalTestCluster;
        final List<DanglingIndexInfo> results = new ArrayList<>();
    }  
                for (String index : indices) {
    }
 *
            .put(IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING.getKey(), writeDanglingIndices)
                return super.onNodeStopped(nodeName);
     * Check that a dangling index can only be imported if "accept_data_loss" is set to true.
    }
        final Settings settings = buildSettings(1, true, false);
    /**
            .build();
    private List<DanglingIndexInfo> listDanglingIndices() {
            }  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                // index from being restored, and also ensures that we are checking index  
    private static final String OTHER_INDEX_NAME = INDEX_NAME + "-other";
        // creating and deleting another index, which creates a new tombstone entry, which should
        assertTrue("Expected dangling index " + INDEX_NAME + " to be recovered", indexExists(INDEX_NAME));
        boolean refreshIntervalChanged = randomBoolean();  
                // Note: don't call `createIndices()` here as it calls `ensureGreen()`, which will  
                client().admin().indices().prepareGetSettings(INDEX_NAME).get().getSetting(INDEX_NAME, "index.refresh_interval"),
        assertFalse(
package org.opensearch.indices.recovery;
            if (nodeResponse.getNode().getName().equals(stoppedNodeName)) {  
     */
        return stoppedNodeName.get();  
                //
        assertThat(danglingIndices, hasSize(1));  
                internalCluster().validateClusterFormed();  
        AtomicReference<String> stoppedNodeName = new AtomicReference<>();  
            .listDanglingIndices(new ListDanglingIndicesRequest())
 * not use this file except in compliance with the License.
     * @return the name of the stopped node
     * @param indices the indices to create and delete
 */  
        internalCluster().startNodes(3, buildSettings(0, false, true));  
 * the Apache License, Version 2.0 (the "License"); you may
        for (NodeListDanglingIndicesResponse nodeResponse : nodeResponses) {  
     */  
        final List<NodeListDanglingIndicesResponse> nodeResponses = response.getNodes();
        AtomicReference<String> stoppedNodeName = new AtomicReference<>();
 * under the License.  
                    public Settings onNodeStopped(String nodeName) throws Exception {
        final IllegalArgumentException e = expectThrows(
    }  
        if (randomBoolean()) {
                internalCluster().validateClusterFormed();
     */  
import static org.hamcrest.Matchers.is;  
        assertThat(response.status(), equalTo(RestStatus.OK));  
        assertAcked(client().admin().indices().prepareDelete("additional"));  
        if (refreshIntervalChanged) {
                // existence by UUID, not name.
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexRequest;  
        });
 *  
     * discovered, then that index is recovered into the cluster.  
     */  
                internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        final List<NodeListDanglingIndicesResponse> nodeResponses = response.getNodes();
        }
            () -> client().admin().cluster().importDanglingIndex(request).actionGet()
        }
        ensureStableCluster(nodes);
        // Restart node, deleting the index in its absence, so that there is a dangling index to recover  
        return danglingIndexUUID;
            createIndex(index, Settings.builder().put("number_of_replicas", 2).put("routing.allocation.total_shards_per_node", 1).build());
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.rest.RestStatus;  
/**  
     */
     * Helper that fetches the current list of dangling indices.
            .cluster()
            () -> internalCluster().getInstances(IndicesService.class)
 * KIND, either express or implied.  See the License for the
    }
    public void testDanglingIndicesCanBeImported() throws Exception {
            .put(SETTING_MAX_TOMBSTONES.getKey(), maxTombstones)
            .listDanglingIndices(new ListDanglingIndicesRequest())
        });  
        createIndices(INDEX_NAME);
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        ensurePendingDanglingIndicesWritten();
    }
        internalCluster().startNodes(3, buildSettings(0, true, true));
 * Licensed to Elasticsearch under one or more contributor  
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName, INDEX_NAME);  
     * Check that when dangling index auto imports are enabled, and a dangling index is is discovered  
        // Since index recovery is async, we can't prove index recovery will never occur, just that it doesn't occur within some reasonable
                        internalCluster().validateClusterFormed();  
    /**
        );
        assert indices.length > 0;  
                .forEach(indicesService -> assertTrue(indicesService.allPendingDanglingIndicesWritten()))
        assertThat(response.status(), equalTo(RestStatus.OK));
            waitUntil(() -> indexExists(INDEX_NAME), 1, TimeUnit.SECONDS)
     * Check that the when sending an import-dangling-indices request, the specified UUIDs are validated as  
            if (nodeResponse.getNode().getName().equals(stoppedNodeName)) {  
        final AtomicReference<List<DanglingIndexInfo>> danglingIndices = new AtomicReference<>();
        }
                ensurePendingDanglingIndicesWritten();
            .listDanglingIndices(new ListDanglingIndicesRequest())
     * Check that when dangling indices are discovered, then they can be listed.
            waitUntil(() -> indexExists(INDEX_NAME), 1, TimeUnit.SECONDS)
     * because the tests in this class stop and restart nodes, assuming
    /**
        assertBusy(  
        // Try to delete the index - this request should succeed
        });  
 */  
        assertThat(listDanglingIndices(), is(empty()));
                assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));  
     * but cannot be imported due to a name clash with an existing index, then that dangling index can  
        // Restart node, deleting the indices in its absence, so that there is a dangling index to recover
            }
    public void testDanglingIndexCanBeDeletedWhenAutoImportEnabled() throws Exception {  
 * You may obtain a copy of the License at  
        });  
     * Check that when a index is found to be dangling on more than one node, it can be deleted.
import static org.hamcrest.Matchers.empty;  
     * but cannot be imported due to a name clash with an existing index, then that dangling index can
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        );
     */  
                final DanglingIndexInfo danglingIndexInfo = nodeResponse.getDanglingIndices().get(0);
     * Check that when dangling indices are discovered, then they are not recovered into
import org.opensearch.action.admin.indices.dangling.list.NodeListDanglingIndicesResponse;  
        assertAcked(client().admin().indices().prepareDelete("additional"));  
                    assertAcked(client().admin().indices().prepareDelete(index));
        assertBusy(() -> assertTrue("Expected dangling index " + INDEX_NAME + " to be recovered", indexExists(INDEX_NAME)));
        Exception e = expectThrows(
        final List<NodeListDanglingIndicesResponse> nodeResponses = response.getNodes();  
        for (NodeListDanglingIndicesResponse nodeResponse : nodeResponses) {
    }
     */
        final ListDanglingIndicesResponse response = client().admin()  
import org.opensearch.test.OpenSearchIntegTestCase;  
/*
        return Settings.builder()
        assertThat(indexMetadata.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID), notNullValue());
 * Unless required by applicable law or agreed to in writing,
            .cluster()  
     */  
    public void testDanglingIndexCanBeDeleted() throws Exception {
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME);
    public void testDanglingIndicesAreNotRecoveredWhenSettingIsDisabled() throws Exception {
                final DanglingIndexInfo danglingIndexInfo = nodeResponse.getDanglingIndices().get(0);  
     * greater than 1. To test deletes, we set the index graveyard size to
 */
 * software distributed under the License is distributed on an
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME, OTHER_INDEX_NAME);
        );  
        internalCluster().startNodes(3, settings);
            public Settings onNodeStopped(String nodeName) throws Exception {
                ensurePendingDanglingIndicesWritten();  
                internalCluster().validateClusterFormed();
        final Settings settings = buildSettings(1, true, false);
        final ImportDanglingIndexRequest request = new ImportDanglingIndexRequest("NonExistentUUID", true);  
 * @see org.opensearch.action.admin.indices.dangling
                .setSettings(Settings.builder().put("index.refresh_interval", "42s").build())
        final Settings settings = buildSettings(1, true, true);
        });
 *
        assertThat("Didn't get responses from all nodes", nodeResponses, hasSize(3));  
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
     * still be listed through the API.
import org.opensearch.cluster.metadata.IndexMetadata;
                // Create another index with the same name, which will prevent the dangling
    /**
            assertThat(
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME);  
    public void testDanglingIndicesCanBeListed() throws Exception {  
import static org.opensearch.gateway.DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING;  
                // fail while a node is offline
    }
                }  
 * compatible open source license.
        internalCluster().startNodes(1, buildSettings(0, true, false));
            @Override
     * we add an entry to the index graveyard, the graveyard size must be
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
     */  
        Exception e = expectThrows(Exception.class, () -> client().admin().cluster().importDanglingIndex(request).actionGet());  
        client().admin().cluster().deleteDanglingIndex(new DeleteDanglingIndexRequest(danglingIndexUUID, true)).actionGet();
        createDanglingIndices(INDEX_NAME);
    public void testDanglingIndicesCanBeListedWhenAutoImportEnabled() throws Exception {
        createIndex("additional");
    public void testDanglingIndicesAreNotRecoveredWhenNotWritten() throws Exception {
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexRequest;
import java.util.ArrayList;  
        assertThat(results, hasSize(2));
        // Restart 2 nodes, deleting the indices in their absence, so that there is a dangling index to recover  
            .actionGet();
        if (refreshIntervalChanged) {  
    }  
        // creating and deleting another index, which creates a new tombstone entry, which should
    private void ensurePendingDanglingIndicesWritten() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        // Restart node, deleting the indices in its absence, so that there is a dangling index to recover  
    /**
     * the cluster when the recovery setting is disabled.
            public Settings onNodeStopped(String nodeName) throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            } else {
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
     * the cluster is stopped. The deletion of the second pushes the deletion
    private String createDanglingIndices(String... indices) throws Exception {
        // Both the stopped nodes should have found a dangling index.  
        assertFalse(  
        // Since index recovery is async, we can't prove index recovery will never occur, just that it doesn't occur within some reasonable  
            .cluster()  
            IllegalArgumentException.class,  
        final Settings settings = buildSettings(0, true, true);  
            // when we delete an index, it's definitely considered to be dangling.  
                    }
            results.addAll(nodeResponse.getDanglingIndices());
    public void testDanglingIndicesAreRecoveredWhenSettingIsEnabled() throws Exception {
        final List<DanglingIndexInfo> danglingIndices = listDanglingIndices();
/*  
        // Restart node, deleting the indices in its absence, so that there is a dangling index to recover  
                        return super.onNodeStopped(nodeName);  
    /**
                // existence by UUID, not name.
public class DanglingIndicesIT extends OpenSearchIntegTestCase {
@ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
                return super.onNodeStopped(nodeName);
import java.util.concurrent.atomic.AtomicReference;  
 * <p>See also <code>DanglingIndicesRestIT</code> in the <code>qa:smoke-test-http</code>
        client().admin()
    /**
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName.get(), INDEX_NAME);  
                danglingIndexUUID = danglingIndexInfo.getIndexUUID();
        }
            client().admin()
        internalCluster().startNodes(3, buildSettings(0, true, false));
    }  
        // The dangling index that we deleted ought to have been removed from disk. Check by
    }
        createIndices(INDEX_NAME, OTHER_INDEX_NAME);
     */
    }  
        createIndex("additional");
            public Settings onNodeStopped(String nodeName) throws Exception {
        internalCluster().startNodes(3, settings);  
                // index from being restored, and also ensures that we are checking index
        // The dangling index that we deleted ought to have been removed from disk. Check by
            Exception.class,  
        internalCluster().startNodes(3, settings);  
     * Check that dangling indices can be imported.
     * Creates a number of dangling indices by first creating then, then stopping a data node
            }
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName, INDEX_NAME);  
    }
        return results;
        final ImportDanglingIndexRequest request = new ImportDanglingIndexRequest(danglingIndexUUID, true);
                        assertAcked(client().admin().indices().prepareDelete(OTHER_INDEX_NAME));
        final ListDanglingIndicesResponse response = client().admin()
        final Settings settings = buildSettings(1, true, false);
    public void testMustAcceptDataLossToImportDanglingIndex() throws Exception {
 * are discovered, and how they can be accessed and manipulated through the
    }
     * that each index has a primary or replica shard on every node, and if
 * project.  
            }
                // Note: don't call `createIndices()` here as it calls `ensureGreen()`, which will
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName, INDEX_NAME);  
        assertBusy(() -> assertThat(listDanglingIndices(), empty()));
        // The dangling index that we deleted ought to have been removed from disk. Check by
        final ListDanglingIndicesResponse response = client().admin()
        internalCluster().startNodes(3, buildSettings(0, true, false));
     * will be considered dangling, and can therefore be listed and
                assertAcked(client().admin().indices().prepareDelete(OTHER_INDEX_NAME));  
     */  
        }  
        assertNotNull("Failed to find a dangling index UUID for node [" + stoppedNodeName + "]", danglingIndexUUID);  
        for (NodeListDanglingIndicesResponse nodeResponse : nodeResponses) {
     * Check that when the auto-recovery setting is enabled and a dangling index is
        }
            () -> client().admin().cluster().deleteDanglingIndex(new DeleteDanglingIndexRequest(danglingIndexUUID, false)).actionGet()
 * specific language governing permissions and limitations
     * only the second index will be found into the graveyard and the other  
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        // creating and deleting another index, which creates a new tombstone entry, which should
        internalCluster().startNodes(3, buildSettings(0, true, false));
                break;
        final List<DanglingIndexInfo> results = listDanglingIndices();
 * API.  
            @Override  
     * deleted through the API
                assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        client().admin().cluster().deleteDanglingIndex(new DeleteDanglingIndexRequest(danglingIndexUUID, true)).actionGet();
                return super.onNodeStopped(nodeName);  
        ensurePendingDanglingIndicesWritten();
    public void testDanglingIndicesMustExistToBeImported() {  
     * a node is stopped prematurely, this assumption is broken.  
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME);
    /**
    }  
        ensureGreen(indices);
        ensureGreen(INDEX_NAME);
    private String findDanglingIndexForNode(String stoppedNodeName, String indexName) {  
        createIndices(INDEX_NAME);  
 * GitHub history for details.
    private Settings buildSettings(int maxTombstones, boolean writeDanglingIndices, boolean importDanglingIndices) {  
        // tombstone has been pushed out of the graveyard.
        danglingIndices.set(results);
    private static final String INDEX_NAME = "test-idx-1";  
     */  
        assertThat(response.status(), equalTo(RestStatus.OK));  
import static org.opensearch.cluster.metadata.IndexGraveyard.SETTING_MAX_TOMBSTONES;
                });
     * Check that dangling indices can be deleted. Since this requires that  
    /**
        internalCluster().startNodes(3, settings);  
/*  
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName, INDEX_NAME);
            client().admin().indices().prepareClose(INDEX_NAME).get();
                return super.onNodeStopped(nodeName);
import static org.hamcrest.Matchers.notNullValue;
        }  
                assertThat("Expected node that was stopped to have one dangling index", nodeResponse.getDanglingIndices(), hasSize(1));
    /**  
                .prepareUpdateSettings(INDEX_NAME)
 * license agreements. See the NOTICE file distributed with
    /**  
            .actionGet();
                createIndex(INDEX_NAME);
            "Did not expect dangling index " + INDEX_NAME + " to be recovered",
            }  
     * checks that they are green before proceeding. This is important  
        ensurePendingDanglingIndicesWritten();
import java.util.concurrent.TimeUnit;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        createIndices(indices);
 * this work for additional information regarding copyright
     */
     * of the first out of the graveyard. When the stopped node is resumed,
