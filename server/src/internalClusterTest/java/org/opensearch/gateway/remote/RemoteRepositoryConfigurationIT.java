        );
            .put(
                buildRemoteStoreNodeAttributes(
        setAddRemote(false);
        internalCluster().startDataOnlyNodes(2, settings);
            Settings.builder()
 *  Remote Node [Cluster State + Segment + Translog]
        internalCluster().startDataOnlyNodes(2);
        internalCluster().startDataOnlyNodes(2);
            Locale.getDefault(),
 * this file be licensed under the Apache-2.0 license or a
        - InternalSettingsPlugin : To override default intervals of retention lease and global ckp sync
    public void setUp() throws Exception {
        String routingTableRepoSettingsAttributeKeyPrefix = String.format(
        ensureGreen();
        Settings.Builder build = remotePublishConfiguredNodeSetting();
        ensureStableCluster(4);
        updateSettingsRequest.persistentSettings(
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        ensureGreen();
        );
        internalCluster().startDataOnlyNodes(2);
        updateSettingsRequest.persistentSettings(
    }
                    ROUTING_TABLE_REPO_NAME,
        internalCluster().startClusterManagerOnlyNode(build.build());
        Settings settings = remoteWithRoutingTableNodeSetting().build();
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        internalCluster().startClusterManagerOnlyNode();
}
        internalCluster().startClusterManagerOnlyNode();
 *  Remote Publish Configured Node [Cluster State + Routing Table]
            Settings.builder()
            )
import org.opensearch.test.transport.MockTransportService;
            Stream.of(InternalSettingsPlugin.class, MockFsRepositoryPlugin.class, MockTransportService.TestPlugin.class)
        setAddRemote(true);
                    ReloadableFsRepository.TYPE,
                    FsRepository.TYPE,
    public void testServiceInitialized_WhenNodeAttributesPresent() {
        internalCluster().startDataOnlyNodes(2, build.build());
        ensureGreen();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    ROUTING_TABLE_REPO_NAME,
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            remoteRepoPrefix,
        ensureStableCluster(6);
            Locale.getDefault(),
        internalCluster().startClusterManagerOnlyNode(settings);
                    segmentRepoPath,
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        );
            "node.attr." + REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            Settings.builder()
        ensureStableCluster(4);
import org.junit.Before;
    }
            .put(routingTableRepoSettingsAttributeKeyPrefix + "location", segmentRepoPath);
            Settings.builder()
        internalCluster().startClusterManagerOnlyNode(build.build());
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true);
import org.junit.Assert;
    }
        Settings.Builder build = remotePublishConfiguredNodeSetting();
    }
        );
    protected String remoteRepoPrefix = "remote_store";
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            .put(stateRepoSettingsAttributeKeyPrefix + "location", segmentRepoPath)
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
    public void testRemoteNodeJoiningPublishConfigCluster() throws Exception {
        ensureStableCluster(4);
        );
        internalCluster().startClusterManagerOnlyNode(settings);
        ensureStableCluster(4);
    public void testRemoteNodeWithRoutingTableJoiningPublishConfigCluster() throws Exception {
        ensureStableCluster(3);
            "node.attr." + REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
            remoteRepoPrefix,
import java.util.Collection;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        updateSettingsRequest.persistentSettings(
import org.opensearch.remotemigration.MigrationBaseTestCase;
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    }
                buildRemoteStoreNodeAttributes(
    private final String REMOTE_PRI_DOCREP_REP = "remote-primary-docrep-replica";
        Settings settings = remoteWithRoutingTableNodeSetting().build();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        return Stream.concat(
        - MockFsRepositoryPlugin and MockTransportService.TestPlugin: To ensure remote interactions are not no-op and retention leases are properly propagated
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            remoteRepoPrefix,
                    translogRepoPath,
        );
                )
        internalCluster().startClusterManagerOnlyNode();
    }
            .put(stateRepoTypeAttributeKey, ReloadableFsRepository.TYPE)
                    REPOSITORY_NAME,
    public void testRemoteClusterStateServiceNotInitialized_WhenNodeAttributesNotPresent() {
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.repositories.fs.ReloadableFsRepository;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        ensureGreen();
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        ensureGreen();
    public void testRemoteNodeWithRoutingTableJoinRemoteCluster() throws Exception {
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
 *  Remote Node With Routing Table [Cluster State + Segment + Translog + Routing Table]
import org.opensearch.test.InternalSettingsPlugin;
    public void testRemotePublishConfigNodeJoinNonRemoteCluster() throws Exception {
        ensureGreen();
        String routingTableRepoTypeAttributeKey = String.format(
public class RemoteRepositoryConfigurationIT extends MigrationBaseTestCase {
    public Settings.Builder remotePublishConfiguredNodeSetting() {
        internalCluster().startDataOnlyNodes(2, settings);
        );
 * SPDX-License-Identifier: Apache-2.0
        internalCluster().getDataOrClusterManagerNodeInstances(RemoteClusterStateService.class).forEach(Assert::assertNotNull);
        internalCluster().startClusterManagerOnlyNode(
            segmentRepoPath = randomRepoPath().toAbsolutePath();
        Settings.Builder build = remotePublishConfiguredNodeSetting();
                    segmentRepoPath,
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // Remote Cluster without Routing table
        ).collect(Collectors.toList());
        );
        internalCluster().startClusterManagerOnlyNode();
            Locale.getDefault(),
import org.opensearch.repositories.fs.FsRepository;
                    REPOSITORY_2_NAME,
/**
            Locale.getDefault(),
        Settings.Builder build = remotePublishConfiguredNodeSetting();
 */
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
    }
            .put("node.attr." + remoteRepoPrefix + ".routing_table.repository", ROUTING_TABLE_REPO_NAME)
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            super.nodePlugins().stream(),
    }
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startDataOnlyNodes(2, build.build());
    }
            "node.attr." + REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        internalCluster().startClusterManagerOnlyNode(build.build());
            2,
        updateSettingsRequest.persistentSettings(
        String stateRepoSettingsAttributeKeyPrefix = String.format(
    public Settings.Builder remoteWithRoutingTableNodeSetting() {
            .put("node.attr." + remoteRepoPrefix + ".state.repository", REPOSITORY_NAME)
    }
        internalCluster().startDataOnlyNodes(2, build.build());
    public void testRemotePublishConfigNodeJoinRemoteCluster() throws Exception {
        updateSettingsRequest.persistentSettings(
import java.util.stream.Collectors;
        // Remote Cluster with Routing table
        setAddRemote(true);
import org.opensearch.common.settings.Settings;
        return Settings.builder()
import java.util.stream.Stream;
        ensureStableCluster(4);
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
package org.opensearch.gateway.remote;
        ensureStableCluster(4);
            )
            .put(stateRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, true)
        String stateRepoTypeAttributeKey = String.format(
        ensureStableCluster(3);
        );
    @Before
/*
                    segmentRepoPath,
                    REPOSITORY_2_NAME,
        String prefixModeVerificationSuffix = BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        // Remote Repo with Routing table
            .put(
        Settings.Builder builder = Settings.builder()
        );
            buildRemoteStateNodeAttributes(REPOSITORY_NAME, segmentRepoPath, ReloadableFsRepository.TYPE)
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        internalCluster().getDataOrClusterManagerNodeInstances(RemoteClusterStateService.class).forEach(Assert::assertNull);
                    false
            ROUTING_TABLE_REPO_NAME
        setAddRemote(true);
        Settings settings = remoteWithRoutingTableNodeSetting().build();
 *  Non Remote node [No Repositories configured]
        setAddRemote(false);
        internalCluster().startClusterManagerOnlyNode(remotePublishConfiguredNodeSetting().build());
    public void testRemotePublishConfigNodeJoinRemoteWithRoutingCluster() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 */
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        internalCluster().startDataOnlyNodes(2, build.build());
    @Override
        ensureGreen();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        updateSettingsRequest.persistentSettings(
    }
        internalCluster().startClusterManagerOnlyNode(build.build());
        );
            buildRemoteStateNodeAttributes(REPOSITORY_NAME, segmentRepoPath, ReloadableFsRepository.TYPE)
        internalCluster().startClusterManagerOnlyNode();
        /* Adding the following mock plugins:
            Settings.builder()
import java.util.Locale;
        ensureGreen();
        internalCluster().startClusterManagerOnlyNode();
 *
                    translogRepoPath,
        internalCluster().startClusterManagerOnlyNode(settings);
        Settings settings = Settings.builder()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            Settings.builder()
        internalCluster().startClusterManagerOnlyNode(settings);
            "node.attr." + REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        super.setUp();
            REPOSITORY_NAME
 * compatible open source license.
        internalCluster().startClusterManagerOnlyNode(build.build());
        Settings.Builder build = remotePublishConfiguredNodeSetting();
        return builder;
            ROUTING_TABLE_REPO_NAME
            translogRepoPath = randomRepoPath().toAbsolutePath();
                    segmentRepoPath,
        ensureStableCluster(4);
    }
        ensureGreen();
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        );
        if (segmentRepoPath == null || translogRepoPath == null) {
    }
                    ReloadableFsRepository.TYPE,
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        internalCluster().startDataOnlyNodes(2);
                    REPOSITORY_NAME,
 * The OpenSearch Contributors require contributions made to
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        internalCluster().startDataOnlyNodes(
        }
            remoteRepoPrefix,
                    false
    public void testNonRemoteNodeJoinRemoteWithRoutingCluster() throws Exception {
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
 * Tests the compatibility between types of nodes based on the configured repositories
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
import org.opensearch.plugins.Plugin;
         */
    }
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
    public void testNonRemoteNodeJoiningPublishConfigCluster() throws Exception {
        ensureGreen();
            REPOSITORY_NAME
            .build();
            .put(routingTableRepoTypeAttributeKey, ReloadableFsRepository.TYPE)
                )
