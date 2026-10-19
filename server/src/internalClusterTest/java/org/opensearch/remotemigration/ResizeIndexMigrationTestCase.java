import org.opensearch.action.admin.indices.shrink.ResizeType;
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), MIXED_MODE));
        // creates a remote cluster
import org.opensearch.common.util.FeatureFlags;
    }
import org.opensearch.common.settings.Settings;
            .indices()
            .actionGet();  
        int resizeShardsNum;
        internalCluster().validateClusterFormed();
            .indices()  
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();
            .admin()
    * */
            .execute()
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();  
            .setSettings(
            default:  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            .setSettings(Settings.builder().put("index.blocks.write", true))  
                resizeShardsNum = 10;
            .putNull("index.blocks.write");  
        // set docrep migration direction  
import org.opensearch.indices.replication.common.ReplicationType;  
        IllegalStateException ex = expectThrows(
        int resizeShardsNum;
                resizeShardsNum = 20;
        internalCluster().startClusterManagerOnlyNode();  
        ResizeType resizeType;  
                    .put("index.routing.allocation.include._name", remoteNodeName)
                resizeShardsNum = 20;  
            ex.getMessage(),
        // set mixed mode
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .setSettings(Settings.builder().put("index.blocks.write", true))
                .setSettings(resizeSettingsBuilder.build())
        internalCluster().startClusterManagerOnlyNode();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
        internalCluster().client()
            case 1:  
    }
        logger.info("-->Create index on non-remote node and SETTING_REMOTE_STORE_ENABLED is false. Resize should not happen");
            ex.getMessage(),
                resizeType = ResizeType.SHRINK;  
            default:
                cause = "shrink_index";
            .indices()
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
            .execute()
            .actionGet();
        internalCluster().validateClusterFormed();  
                builder.put("index.number_of_shards", 10)
        }  
        // set remote store migration direction
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
    public void testFailResizeIndexWhileRemoteStoreToDocRepMigration() throws Exception {
                break;
     * This test will verify the resize request failure, when cluster mode is mixed
                resizeShardsNum = 10;
        ensureGreen(TEST_INDEX);
                cause = "split_index";
        String remoteNodeName = internalCluster().startDataOnlyNode();
    protected Settings featureFlagSettings() {
                .setResizeType(resizeType)  
                cause = "clone_index";  
            .prepareUpdateSettings(TEST_INDEX)  
        String cause;
                cause = "clone_index";
    public void testFailResizeIndexWhileDocRepToRemoteStoreMigration() throws Exception {  
                resizeType = ResizeType.CLONE;  
 *
        internalCluster().validateClusterFormed();
            .prepareCreate(TEST_INDEX)  
        internalCluster().client()  
                break;
            () -> internalCluster().client()
        String remoteNodeName = internalCluster().startDataOnlyNode();
            .prepareUpdateSettings(TEST_INDEX)
        );
}  
                resizeShardsNum = 5;
        internalCluster().validateClusterFormed();  
        assertEquals(  
 * The OpenSearch Contributors require contributions made to  
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        IllegalStateException ex = expectThrows(  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
                    .put("index.routing.allocation.include._name", nonRemoteNodeName)
        switch (randomIntBetween(0, 2)) {  
        // add a remote node  
            "Index " + resizeType + " is not allowed as remote migration mode is mixed" + " and index is remote store disabled"
        ensureGreen(TEST_INDEX);
    /*
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .setWaitForActiveShards(ActiveShardCount.ALL)  
        addRemote = false;
        // add a non-remote node  
                resizeType = ResizeType.CLONE;
                    .put("index.number_of_replicas", 0)  
        Settings.Builder resizeSettingsBuilder = Settings.builder()  
        switch (randomIntBetween(0, 2)) {
        Settings.Builder builder = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
        setAddRemote(true);  
    @Override  
    private final static String MIXED_MODE = "mixed";
    private static final String TEST_INDEX = "test_index";
            .put("index.number_of_replicas", 0)
            .put("index.number_of_shards", resizeShardsNum)  
                .setResizeType(resizeType)
            .execute()
            () -> internalCluster().client()
            case 0:
        );  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .setSettings(
            IllegalStateException.class,
     * and index is on Remote Store node, and migration to DocRep node is in progress.
        logger.info("--> Create index on remote node and SETTING_REMOTE_STORE_ENABLED is true. Resize should not happen");
        internalCluster().client()  
            .indices()
    /*  
            .putNull("index.blocks.write");
                    .put("index.number_of_replicas", 0)
                break;  
     * */  
            .actionGet();  
        Settings.Builder resizeSettingsBuilder = Settings.builder()
                resizeShardsNum = 5;  
            .admin()  
            .admin()
        );  
                cause = "shrink_index";
                break;
package org.opensearch.remotemigration;
    * This test will verify the resize request failure, when cluster mode is mixed  
                .admin()
import org.opensearch.action.support.ActiveShardCount;  
public class ResizeIndexMigrationTestCase extends MigrationBaseTestCase {  
        // add a remote node
            .put("index.number_of_shards", resizeShardsNum)
                .indices()
        ResizeType resizeType;
        internalCluster().validateClusterFormed();
                resizeType = ResizeType.SPLIT;
                builder.put("index.number_of_shards", 10)  
    private final static String REMOTE_STORE_DIRECTION = "remote_store";
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                .admin()  
            .prepareCreate(TEST_INDEX)
 * compatible open source license.
            case 0:
 * this file be licensed under the Apache-2.0 license or a
    * and index is on DocRep node, and migration to remote store is in progress.
        internalCluster().client()
        // create a docrep cluster
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), MIXED_MODE));  
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
/*  
    private final static String DOC_REP_DIRECTION = "docrep";  
import org.opensearch.test.OpenSearchIntegTestCase;
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), DOC_REP_DIRECTION));
                .get()
            .execute()
                resizeType = ResizeType.SHRINK;
            "Index " + resizeType + " is not allowed as remote migration mode is mixed" + " and index is remote store enabled"  
        setAddRemote(false);
            IllegalStateException.class,  
        // set mixed mode
            )  
        internalCluster().validateClusterFormed();
                .prepareResizeIndex(TEST_INDEX, "first_split")
        assertEquals(
        Settings.Builder builder = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);  
                cause = "split_index";  
                .prepareResizeIndex(TEST_INDEX, "first_split")
                .indices()  
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL, "true").build();
 */  
                .get()
        }
        addRemote = true;
                resizeType = ResizeType.SPLIT;
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), REMOTE_STORE_DIRECTION));  
            .admin()
        String cause;  
        // add a non-remote node
            .setWaitForActiveShards(ActiveShardCount.ALL)
    }  
            .actionGet();
            )
            .put("index.number_of_replicas", 0)
            case 1:
                .setSettings(resizeSettingsBuilder.build())  
