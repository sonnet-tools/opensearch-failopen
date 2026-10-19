                });
 * Modifications Copyright OpenSearch Contributors. See
            .listDanglingIndices(new ListDanglingIndicesRequest())
        assertTrue("Expected dangling index " + INDEX_NAME + " to be recovered", indexExists(INDEX_NAME));
 * @see org.opensearch.action.admin.indices.dangling
     */
        assertBusy(() -> assertThat(listDanglingIndices(), empty()));
        createIndex("additional");
        final List<DanglingIndexInfo> results = listDanglingIndices();
     * the cluster when the recovery setting is disabled.
        createIndices(indices);
     * only the second index will be found into the graveyard and the other
        internalCluster().startNodes(3, settings);
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexRequest;
                assertThat("Expected node that was stopped to have one dangling index", nodeResponse.getDanglingIndices(), hasSize(1));
        danglingIndices.set(results);
            .cluster()
 *
        internalCluster().startNodes(3, buildSettings(0, true, false));
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
            @Override
        final ImportDanglingIndexRequest request = new ImportDanglingIndexRequest(danglingIndexUUID, false);
 * software distributed under the License is distributed on an
        // tombstone has been pushed out of the graveyard.
            .cluster()
     * being dangling.
        assertAcked(client().admin().indices().prepareDelete("additional"));
     * 1, then create two indices and delete them both while one node in
        assertThat(danglingIndices.get(0).getIndexName(), equalTo(INDEX_NAME));
                stoppedNodeName.set(nodeName);
     * a node is stopped prematurely, this assumption is broken.
        assertThat(indexMetadata.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID), notNullValue());
 * specific language governing permissions and limitations
            }
     * Check that when dangling indices are discovered, then they are not recovered into
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName, INDEX_NAME);
        });
                assertThat(danglingIndexInfo.getIndexName(), equalTo(indexName));
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME);
     * the cluster is stopped. The deletion of the second pushes the deletion
        internalCluster().startNodes(3, buildSettings(0, false, true));
            .actionGet();
    }
            () -> client().admin().cluster().deleteDanglingIndex(new DeleteDanglingIndexRequest(danglingIndexUUID, false)).actionGet()
            @Override
     * that each index has a primary or replica shard on every node, and if
     * Check that the when sending an import-dangling-indices request, the specified UUIDs are validated as
        }
                equalTo("42s")
    /**
                break;
        return stoppedNodeName.get();
    }
        ensureStableCluster(nodes);
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
    /**
 * compatible open source license.
     */
        createIndices(INDEX_NAME);
                assertThat(danglingIndexInfo.getIndexName(), equalTo(INDEX_NAME));
     */
        client().admin().cluster().importDanglingIndex(request).get();
                // Note: don't call `createIndices()` here as it calls `ensureGreen()`, which will
        assertThat(results, hasSize(2));
        );
     * and deleting the indices while the node is stopped.
        assertBusy(
        assertThat(danglingIndices, hasSize(1));
    /**
        ensureGreen(INDEX_NAME);
                // fail while a node is offline
    public void testDanglingIndicesCanBeListedWhenAutoImportEnabled() throws Exception {
                return super.onNodeStopped(nodeName);
                // existence by UUID, not name.
     * greater than 1. To test deletes, we set the index graveyard size to
     * Check that when dangling indices are not written, then they cannot be recovered into the cluster.
    private static final String OTHER_INDEX_NAME = INDEX_NAME + "-other";
                //
            IllegalArgumentException.class,
                // Create another index with the same name, which will prevent the dangling
     */
        assertAcked(client().admin().indices().prepareDelete("additional"));
     * Check that dangling indices can be imported.
            Exception.class,
                for (String index : indices) {
        );
            }
        ensurePendingDanglingIndicesWritten();
    /**
    public void testDanglingIndicesCanBeImported() throws Exception {
 */
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.test.InternalTestCluster;
            waitUntil(() -> indexExists(INDEX_NAME), 1, TimeUnit.SECONDS)
import org.opensearch.indices.IndicesService;
            client().admin().indices().prepareClose(INDEX_NAME).get();
            public Settings onNodeStopped(String nodeName) throws Exception {
        createIndices(INDEX_NAME);
                ensurePendingDanglingIndicesWritten();
 * not use this file except in compliance with the License.
        Exception e = expectThrows(Exception.class, () -> client().admin().cluster().importDanglingIndex(request).actionGet());
        });
            .actionGet();
    /**
/*
            createIndex(index, Settings.builder().put("number_of_replicas", 2).put("routing.allocation.total_shards_per_node", 1).build());
                assertThat("Expected node that was never stopped to have no dangling indices", nodeResponse.getDanglingIndices(), empty());
                return super.onNodeStopped(nodeName);
 * Unless required by applicable law or agreed to in writing,
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName, INDEX_NAME);
    /**
    }
                assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        // creating and deleting another index, which creates a new tombstone entry, which should
 * Licensed to Elasticsearch under one or more contributor
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME);
 */
                return super.onNodeStopped(nodeName);
    public void testDanglingIndicesAreNotRecoveredWhenSettingIsDisabled() throws Exception {
    /**
        assertThat(e.getMessage(), containsString("accept_data_loss must be set to true"));
    public void testDeleteDanglingIndicesRequiresDataLossFlagToBeTrue() throws Exception {
    }
        // tombstone has been pushed out of the graveyard.
        internalCluster().startNodes(1, buildSettings(0, true, false));
 * ownership. Elasticsearch licenses this file to you under
                    public Settings onNodeStopped(String nodeName) throws Exception {
        if (randomBoolean()) {
            if (nodeResponse.getNode().getName().equals(stoppedNodeName)) {
        // Since index recovery is async, we can't prove index recovery will never occur, just that it doesn't occur within some reasonable
        final List<DanglingIndexInfo> results = new ArrayList<>();
 * under the License.
        // Restart node, deleting the indices in its absence, so that there is a dangling index to recover
    /**
     * Check that when dangling indices are discovered, then they can be listed.
     * checks that they are green before proceeding. This is important
            assertThat(
        createIndex("additional");
        Exception e = expectThrows(
                final DanglingIndexInfo danglingIndexInfo = nodeResponse.getDanglingIndices().get(0);
            public Settings onNodeStopped(String nodeName) throws Exception {
                internalCluster().validateClusterFormed();
        final Settings settings = buildSettings(1, true, false);
 *
    public void testDanglingIndicesAreNotRecoveredWhenNotWritten() throws Exception {
        createDanglingIndices(INDEX_NAME);
        }
        ensurePendingDanglingIndicesWritten();
            () -> internalCluster().getInstances(IndicesService.class)
    public void testMustAcceptDataLossToImportDanglingIndex() throws Exception {
                stoppedNodeName.set(nodeName);
            }
     */
        internalCluster().startNodes(3, buildSettings(0, true, false));
        if (refreshIntervalChanged) {
        assertFalse(
    }
        assertThat(listDanglingIndices(), is(empty()));
        AtomicReference<String> stoppedNodeName = new AtomicReference<>();
        final ListDanglingIndicesResponse response = client().admin()
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
import static org.opensearch.gateway.DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING;
    public void testDanglingIndicesCanBeListed() throws Exception {
        final ListDanglingIndicesResponse response = client().admin()
    public void testDanglingIndexCanBeDeletedWhenAutoImportEnabled() throws Exception {
        internalCluster().startNodes(3, settings);
        assertBusy(() -> assertTrue("Expected dangling index " + INDEX_NAME + " to be recovered", indexExists(INDEX_NAME)));
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME, OTHER_INDEX_NAME);
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.notNullValue;
        final Settings settings = buildSettings(1, true, false);
        internalCluster().startNodes(3, settings);
import static org.hamcrest.Matchers.equalTo;
     * Check that when dangling index auto imports are enabled, and a dangling index is is discovered
    }
                createIndex(INDEX_NAME);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final ImportDanglingIndexRequest request = new ImportDanglingIndexRequest("NonExistentUUID", true);
        client().admin().cluster().deleteDanglingIndex(new DeleteDanglingIndexRequest(danglingIndexUUID, true)).actionGet();
            }
 * SPDX-License-Identifier: Apache-2.0
    public void testDanglingIndicesAreRecoveredWhenSettingIsEnabled() throws Exception {
            .listDanglingIndices(new ListDanglingIndicesRequest())
     * Check that when a index is found to be dangling on more than one node, it can be deleted.
        return danglingIndexUUID;
        // creating and deleting another index, which creates a new tombstone entry, which should
        // tombstone has been pushed out of the graveyard.
 * are discovered, and how they can be accessed and manipulated through the
        internalCluster().startNodes(3, settings);
        for (String index : indices) {
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final IndexMetadata indexMetadata = clusterService().state().metadata().index(INDEX_NAME);
        // Both the stopped nodes should have found a dangling index.
                final DanglingIndexInfo danglingIndexInfo = nodeResponse.getDanglingIndices().get(0);
            .build();
    /**
        assertThat(e.getMessage(), containsString("accept_data_loss must be set to true"));
            );
     * because the tests in this class stop and restart nodes, assuming
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName.get(), INDEX_NAME);
                // index from being restored, and also ensures that we are checking index
 * The OpenSearch Contributors require contributions made to
            "Did not expect dangling index " + INDEX_NAME + " to be recovered",
    }
        final List<NodeListDanglingIndicesResponse> nodeResponses = response.getNodes();
 * GitHub history for details.
                // Create another index with the same name, which will prevent the dangling
        final List<DanglingIndexInfo> danglingIndices = listDanglingIndices();
        // The dangling index that we deleted ought to have been removed from disk. Check by
        // Since index recovery is async, we can't prove index recovery will never occur, just that it doesn't occur within some reasonable
            .listDanglingIndices(new ListDanglingIndicesRequest())
@ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
        final Settings settings = buildSettings(1, true, false);
            public Settings onNodeStopped(String nodeName) throws Exception {
            client().admin()
        // amount of time
 * You may obtain a copy of the License at
    private static final String INDEX_NAME = "test-idx-1";
        ensureGreen(INDEX_NAME);
import static org.hamcrest.Matchers.hasSize;
    }
            .put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), importDanglingIndices)
        ensurePendingDanglingIndicesWritten();
 */
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName, INDEX_NAME);
            @Override
 *
        assertThat(e.getMessage(), containsString("No dangling index found for UUID [NonExistentUUID]"));
                        return super.onNodeStopped(nodeName);
            }
import static org.hamcrest.Matchers.empty;
                        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
import static org.hamcrest.Matchers.containsString;
        assertThat(response.status(), equalTo(RestStatus.OK));
        String danglingIndexUUID = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.indices.dangling.list.NodeListDanglingIndicesResponse;
                .prepareUpdateSettings(INDEX_NAME)
                assertAcked(client().admin().indices().prepareDelete(OTHER_INDEX_NAME));
                .indices()
            () -> client().admin().cluster().importDanglingIndex(request).actionGet()
    public void testDanglingIndicesMustExistToBeImported() {
     */
        ensureGreen(indices);
            }
                .forEach(indicesService -> assertTrue(indicesService.allPendingDanglingIndicesWritten()))
        assertThat(response.status(), equalTo(RestStatus.OK));
        for (NodeListDanglingIndicesResponse nodeResponse : nodeResponses) {
     */
        }
        if (refreshIntervalChanged) {
import static org.opensearch.cluster.metadata.IndexGraveyard.SETTING_MAX_TOMBSTONES;
        }
     * @param indices the indices to create and delete
                    assertAcked(client().admin().indices().prepareDelete(index));
        internalCluster().startNodes(3, buildSettings(0, true, false));
        internalCluster().startNodes(3, buildSettings(0, true, false));
     */
     */
            @Override
                        assertAcked(client().admin().indices().prepareDelete(OTHER_INDEX_NAME));
                    }
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME, OTHER_INDEX_NAME);
import org.opensearch.cluster.metadata.IndexMetadata;
        final ListDanglingIndicesResponse response = client().admin()
package org.opensearch.indices.recovery;
                client().admin().indices().prepareGetSettings(INDEX_NAME).get().getSetting(INDEX_NAME, "index.refresh_interval"),
    /**
        // Restart node, deleting the indices in its absence, so that there is a dangling index to recover
        ensurePendingDanglingIndicesWritten();
 * KIND, either express or implied.  See the License for the
        // not cause the deleted dangling index to be considered "live" again, just because its
        createIndices(INDEX_NAME, OTHER_INDEX_NAME);
        final List<NodeListDanglingIndicesResponse> nodeResponses = response.getNodes();
        }
                danglingIndexUUID = danglingIndexInfo.getIndexUUID();
     * Creates a number of dangling indices by first creating then, then stopping a data node
            @Override
                // existence by UUID, not name.
        assertThat(response.status(), equalTo(RestStatus.OK));
     */
    }
                .get();
        assertThat(listDanglingIndices(), is(empty()));
    private void createIndices(String... indices) {
        final IllegalArgumentException e = expectThrows(
            .cluster()
     * @return the name of the stopped node
     * we add an entry to the index graveyard, the graveyard size must be
                assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        final String danglingIndexUUID = findDanglingIndexForNode(stoppedNodeName, INDEX_NAME);
     */
        // Try to delete the index - this request should succeed
            public Settings onNodeStopped(String nodeName) throws Exception {
            results.addAll(nodeResponse.getDanglingIndices());
        // not cause the deleted dangling index to be considered "live" again, just because its
        // Restart node, deleting the index in its absence, so that there is a dangling index to recover
            .actionGet();
        final String stoppedNodeName = createDanglingIndices(INDEX_NAME);
import java.util.List;
                return super.onNodeStopped(nodeName);
            "Did not expect dangling index " + INDEX_NAME + " to be recovered",
 *
                internalCluster().validateClusterFormed();
 * project.
        );
    }
        final Settings settings = buildSettings(0, true, true);
        }
        // The dangling index that we deleted ought to have been removed from disk. Check by
import java.util.concurrent.TimeUnit;
 * <p>See also <code>DanglingIndicesRestIT</code> in the <code>qa:smoke-test-http</code>
public class DanglingIndicesIT extends OpenSearchIntegTestCase {
        for (NodeListDanglingIndicesResponse nodeResponse : nodeResponses) {
 * this work for additional information regarding copyright
        for (NodeListDanglingIndicesResponse nodeResponse : nodeResponses) {
            } else {
    }
     * Check that a dangling index can only be imported if "accept_data_loss" is set to true.
    }
     * Helper that fetches the current list of dangling indices.
import org.opensearch.common.settings.Settings;
                }
        final ImportDanglingIndexRequest request = new ImportDanglingIndexRequest(danglingIndexUUID, true);
    /**
        client().admin()
        );
        boolean refreshIntervalChanged = randomBoolean();
                ensurePendingDanglingIndicesWritten();
     */
     * Simple helper that creates one or more indices, and importantly,
    }
                return super.onNodeStopped(nodeName);
    }
                    @Override
    /**
            ensurePendingDanglingIndicesWritten();
     * Check that when deleting a dangling index, it is required that the "accept_data_loss" flag is set.
        assertAcked(client().admin().indices().prepareDelete("additional"));
    private String createDanglingIndices(String... indices) throws Exception {
    /**
                createIndex(INDEX_NAME);
     * still be deleted through the API.
     * but cannot be imported due to a name clash with an existing index, then that dangling index can
        // The dangling index that we deleted ought to have been removed from disk. Check by
            .cluster()
    public void testDanglingIndexCanBeDeleted() throws Exception {
import java.util.concurrent.atomic.AtomicReference;
 *
        }
            // when we delete an index, it's definitely considered to be dangling.
        return Settings.builder()
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse;
                // fail while a node is offline
    private void ensurePendingDanglingIndicesWritten() throws Exception {
                        internalCluster().validateClusterFormed();
    /**
 */
            // Limit the indices kept in the graveyard. This can be set to zero, so that
                internalCluster().validateClusterFormed();
    private String findDanglingIndexForNode(String stoppedNodeName, String indexName) {
            .put(IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING.getKey(), writeDanglingIndices)
        assertNotNull("Failed to find a dangling index UUID for node [" + stoppedNodeName + "]", danglingIndexUUID);
        final int nodes = internalCluster().size();
     * of the first out of the graveyard. When the stopped node is resumed,
                // index from being restored, and also ensures that we are checking index
            waitUntil(() -> indexExists(INDEX_NAME), 1, TimeUnit.SECONDS)
     */
        final Settings settings = buildSettings(1, true, true);
        // creating and deleting another index, which creates a new tombstone entry, which should
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
                .setSettings(Settings.builder().put("index.refresh_interval", "42s").build())
import org.opensearch.test.OpenSearchIntegTestCase;
/*
    /**
import static org.hamcrest.Matchers.is;
            }
            .actionGet();
    }
                internalCluster().validateClusterFormed();
        // amount of time
        createIndices(INDEX_NAME, OTHER_INDEX_NAME);
                // Note: don't call `createIndices()` here as it calls `ensureGreen()`, which will
        final AtomicReference<List<DanglingIndexInfo>> danglingIndices = new AtomicReference<>();
        });
        });
        );
        createIndex("additional");
        client().admin().cluster().deleteDanglingIndex(new DeleteDanglingIndexRequest(danglingIndexUUID, true)).actionGet();
        internalCluster().startNodes(3, buildSettings(0, true, true));
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
                //
}
     * discovered, then that index is recovered into the cluster.
                assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        // Restart node, deleting the indices in its absence, so that there is a dangling index to recover
        // Restart 2 nodes, deleting the indices in their absence, so that there is a dangling index to recover
        final List<NodeListDanglingIndicesResponse> nodeResponses = response.getNodes();
     * will be considered dangling, and can therefore be listed and
            public Settings onNodeStopped(String nodeName) throws Exception {
        ensurePendingDanglingIndicesWritten();
        return results;
    private List<DanglingIndexInfo> listDanglingIndices() {
import org.opensearch.core.rest.RestStatus;
        // not cause the deleted dangling index to be considered "live" again, just because its
        assert indices.length > 0;
/**
     * Check that dangling indices can be deleted. Since this requires that
     * still be listed through the API.
            .deleteDanglingIndex(new DeleteDanglingIndexRequest(danglingIndices.get().get(0).getIndexUUID(), true))
        internalCluster().startNodes(3, settings);
            .put(SETTING_MAX_TOMBSTONES.getKey(), maxTombstones)
     * Check that when dangling index auto imports are enabled, and a dangling index is is discovered
    }
     * Check that when the auto-recovery setting is enabled and a dangling index is
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
    public void testDanglingIndexOverMultipleNodesCanBeDeleted() throws Exception {
            if (nodeResponse.getNode().getName().equals(stoppedNodeName)) {
        createDanglingIndices(INDEX_NAME);
                internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexRequest;
        });
 * API.
        assertFalse(
     * but cannot be imported due to a name clash with an existing index, then that dangling index can
        AtomicReference<String> stoppedNodeName = new AtomicReference<>();
        assertThat("Didn't get responses from all nodes", nodeResponses, hasSize(3));
     * deleted through the API
/*
     */
 * This class tests how dangling indices are handled, in terms of how they
    private Settings buildSettings(int maxTombstones, boolean writeDanglingIndices, boolean importDanglingIndices) {
    }
 * license agreements. See the NOTICE file distributed with
     */
