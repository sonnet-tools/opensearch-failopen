        assertEquals(IndexMetadata.State.CLOSE, indexMetadata.getState());  
        internalCluster().validateClusterFormed();  
        ensureGreen(TEST_INDEX);  
        // add a remote node
    private static final String TEST_INDEX = "ind";
     * and migration to remote store is in progress.
import org.opensearch.cluster.metadata.IndexMetadata;
            .indices()
            .setWaitForActiveShards(ActiveShardCount.ALL)  
            .execute()
        assertTrue(clusterState.blocks().hasIndexBlock(TEST_INDEX, MetadataIndexStateService.INDEX_CLOSED_BLOCK));
import org.opensearch.test.OpenSearchIntegTestCase;  
            .execute()
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
    private final static String REMOTE_STORE_DIRECTION = "remote_store";  
    }
        assertEquals(true, indexSettings.getAsBoolean(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), false));  
        Settings.Builder builder = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT);
        assertNotNull(clusterState.routingTable().index(TEST_INDEX));
}
        // set mixed mode
public class CloseIndexMigrationTestCase extends MigrationBaseTestCase {
    public void testCloseIndexRequestWithMixedCompatibilityModeAndNoDirection() {  
                builder.put("index.number_of_shards", 2)
import java.util.concurrent.ExecutionException;
import org.opensearch.common.settings.Settings;
    /*  
     * */  
        internalCluster().validateClusterFormed();
                    .put("index.number_of_replicas", 0)
 * compatible open source license.
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), REMOTE_STORE_DIRECTION));
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
            .admin()
        );
        // perform close action
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
 *
    private final static String MIXED_MODE = "mixed";
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            )  
            () -> internalCluster().client().admin().indices().close(new CloseIndexRequest(TEST_INDEX)).get()  
     * This test will verify the close request failure, when cluster mode is mixed
import org.opensearch.indices.replication.common.ReplicationType;
        internalCluster().client()  
            .setSettings(
    }
 * The OpenSearch Contributors require contributions made to  
        ensureGreen(TEST_INDEX);
        internalCluster().validateClusterFormed();
/*  
        setAddRemote(false);
            .admin()
        // create a docrep cluster
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
                    .put("index.routing.allocation.include._name", nonRemoteNodeName)
 */  
        setAddRemote(false);
 * SPDX-License-Identifier: Apache-2.0
            .indices()  
        final IndexMetadata indexMetadata = clusterState.metadata().indices().get(TEST_INDEX);
        internalCluster().startClusterManagerOnlyNode();  
        // create a docrep cluster  
                    .put("index.routing.allocation.include._name", nonRemoteNodeName)
                    .put("index.number_of_replicas", 0)  
            )
        internalCluster().validateClusterFormed();
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
        assertTrue(indexSettings.hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()));
            .prepareCreate(TEST_INDEX)  
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();
        // set mixed mode
        addRemote = true;
        internalCluster().startDataOnlyNode();  
        assertEquals("Cannot close index while remote migration is ongoing", ex.getCause().getMessage());  
            .prepareCreate(TEST_INDEX)
     * Verify that index closes if compatibility mode is MIXED, and direction is set to NONE
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .setSettings(
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        // add a non-remote node  
        // verify that index has been closed
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // create index in cluster
    /*  
        // create index in cluster
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        // Try closing the index, expecting failure.  
            ExecutionException.class,
            .setWaitForActiveShards(ActiveShardCount.ALL)
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
 * this file be licensed under the Apache-2.0 license or a
     * */
            .actionGet();  
            .actionGet();
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), MIXED_MODE));
        Settings.Builder builder = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);  
        // add a non-remote node
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
                builder.put("index.number_of_shards", 2)  
        final Settings indexSettings = indexMetadata.getSettings();
        internalCluster().client()
        // set remote store migration direction  
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), MIXED_MODE));  
        ExecutionException ex = expectThrows(
package org.opensearch.remotemigration;
        internalCluster().validateClusterFormed();
    public void testFailCloseIndexWhileDocRepToRemoteStoreMigration() {
        internalCluster().startClusterManagerOnlyNode();
        assertAcked(internalCluster().client().admin().indices().close(new CloseIndexRequest(TEST_INDEX)).actionGet());  
import org.opensearch.action.support.ActiveShardCount;  
