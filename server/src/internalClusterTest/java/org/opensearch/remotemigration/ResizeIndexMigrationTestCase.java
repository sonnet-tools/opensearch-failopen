            .actionGet();
        IllegalStateException ex = expectThrows(
}
 * this file be licensed under the Apache-2.0 license or a
        );
                    .put("index.routing.allocation.include._name", remoteNodeName)
            .prepareUpdateSettings(TEST_INDEX)
            )
        logger.info("-->Create index on non-remote node and SETTING_REMOTE_STORE_ENABLED is false. Resize should not happen");
            ex.getMessage(),
 * The OpenSearch Contributors require contributions made to
        // add a non-remote node
        String remoteNodeName = internalCluster().startDataOnlyNode();
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), REMOTE_STORE_DIRECTION));
    private final static String DOC_REP_DIRECTION = "docrep";
    /*
            .execute()
            .put("index.number_of_replicas", 0)
            .setWaitForActiveShards(ActiveShardCount.ALL)
                cause = "split_index";
                cause = "shrink_index";
        internalCluster().client()
    protected Settings featureFlagSettings() {
                resizeShardsNum = 5;
package org.opensearch.remotemigration;
            .admin()
        int resizeShardsNum;
        // creates a remote cluster
        Settings.Builder resizeSettingsBuilder = Settings.builder()
                builder.put("index.number_of_shards", 10)
            () -> internalCluster().client()
        switch (randomIntBetween(0, 2)) {
        // add a remote node
            .setSettings(
        ResizeType resizeType;
        String cause;
                cause = "shrink_index";
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), MIXED_MODE));
        assertEquals(
    /*
            case 0:
        // add a remote node
        Settings.Builder builder = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
        internalCluster().validateClusterFormed();
import org.opensearch.action.admin.indices.shrink.ResizeType;
            .put("index.number_of_replicas", 0)
        // set docrep migration direction
        setAddRemote(true);
        );
            .admin()
        IllegalStateException ex = expectThrows(
                resizeShardsNum = 20;
            .setSettings(
        ensureGreen(TEST_INDEX);
            .setSettings(Settings.builder().put("index.blocks.write", true))
            .indices()
import org.opensearch.test.OpenSearchIntegTestCase;
     * and index is on Remote Store node, and migration to DocRep node is in progress.
                builder.put("index.number_of_shards", 10)
            .setWaitForActiveShards(ActiveShardCount.ALL)
    private final static String MIXED_MODE = "mixed";
                .setSettings(resizeSettingsBuilder.build())
    * */
        // add a non-remote node
            .prepareCreate(TEST_INDEX)
            IllegalStateException.class,
                resizeType = ResizeType.CLONE;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        // set mixed mode
                .indices()
            .actionGet();
            .actionGet();
            .indices()
        internalCluster().validateClusterFormed();
        logger.info("--> Create index on remote node and SETTING_REMOTE_STORE_ENABLED is true. Resize should not happen");
 */
        addRemote = true;
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL, "true").build();
 *
                resizeType = ResizeType.SHRINK;
            .execute()
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        internalCluster().startClusterManagerOnlyNode();
                cause = "split_index";
        Settings.Builder builder = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
        int resizeShardsNum;
    private static final String TEST_INDEX = "test_index";
            .actionGet();
            .putNull("index.blocks.write");
        internalCluster().validateClusterFormed();
    public void testFailResizeIndexWhileDocRepToRemoteStoreMigration() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .prepareResizeIndex(TEST_INDEX, "first_split")
        internalCluster().validateClusterFormed();
        addRemote = false;
                .setSettings(resizeSettingsBuilder.build())
                .indices()
    private final static String REMOTE_STORE_DIRECTION = "remote_store";
import org.opensearch.action.support.ActiveShardCount;
                .get()
            case 1:
            .admin()
        ResizeType resizeType;
            default:
    }
                    .put("index.number_of_replicas", 0)
                .get()
                resizeType = ResizeType.SPLIT;
        String remoteNodeName = internalCluster().startDataOnlyNode();
    * and index is on DocRep node, and migration to remote store is in progress.
import org.opensearch.common.settings.Settings;
                resizeShardsNum = 5;
            .prepareUpdateSettings(TEST_INDEX)
    @Override
                .setResizeType(resizeType)
            .execute()
                .admin()
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            "Index " + resizeType + " is not allowed as remote migration mode is mixed" + " and index is remote store enabled"
    }
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        // set mixed mode
                break;
        );
            )
/*
    public void testFailResizeIndexWhileRemoteStoreToDocRepMigration() throws Exception {
            case 0:
                resizeShardsNum = 20;
            .admin()
                break;
        }
public class ResizeIndexMigrationTestCase extends MigrationBaseTestCase {
                cause = "clone_index";
        internalCluster().client()
            .indices()
        internalCluster().validateClusterFormed();
        // create a docrep cluster
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), MIXED_MODE));
        Settings.Builder resizeSettingsBuilder = Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
            .putNull("index.blocks.write");
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
    }
            () -> internalCluster().client()
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                .prepareResizeIndex(TEST_INDEX, "first_split")
        internalCluster().startClusterManagerOnlyNode();
                .setResizeType(resizeType)
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();
                break;
            .put("index.number_of_shards", resizeShardsNum)
        setAddRemote(false);
 * SPDX-License-Identifier: Apache-2.0
            IllegalStateException.class,
                resizeType = ResizeType.CLONE;
     * */
                resizeType = ResizeType.SHRINK;
        }
                resizeType = ResizeType.SPLIT;
                resizeShardsNum = 10;
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), DOC_REP_DIRECTION));
            .indices()
        );
            ex.getMessage(),
        internalCluster().client()
     * This test will verify the resize request failure, when cluster mode is mixed
        ensureGreen(TEST_INDEX);
        // set remote store migration direction
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
 * compatible open source license.
            case 1:
                .admin()
        switch (randomIntBetween(0, 2)) {
                    .put("index.routing.allocation.include._name", nonRemoteNodeName)
            "Index " + resizeType + " is not allowed as remote migration mode is mixed" + " and index is remote store disabled"
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .execute()
    * This test will verify the resize request failure, when cluster mode is mixed
            .setSettings(Settings.builder().put("index.blocks.write", true))
                resizeShardsNum = 10;
            .put("index.number_of_shards", resizeShardsNum)
        internalCluster().client()
                    .put("index.number_of_replicas", 0)
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.indices.replication.common.ReplicationType;
            .prepareCreate(TEST_INDEX)
        String cause;
        assertEquals(
        internalCluster().validateClusterFormed();
                cause = "clone_index";
                break;
            default:
