        internalCluster().startClusterManagerOnlyNode(settings);  
        internalCluster().startDataOnlyNodes(2, build.build());
            "node.attr." + REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
                    translogRepoPath,  
import org.opensearch.repositories.fs.FsRepository;
        Settings.Builder build = remotePublishConfiguredNodeSetting();
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")  
            Settings.builder()  
    }
        - MockFsRepositoryPlugin and MockTransportService.TestPlugin: To ensure remote interactions are not no-op and retention leases are properly propagated
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        updateSettingsRequest.persistentSettings(
        ensureGreen();
        Settings settings = remoteWithRoutingTableNodeSetting().build();
            )
    public void testNonRemoteNodeJoinRemoteWithRoutingCluster() throws Exception {
                    REPOSITORY_2_NAME,
                )
        );
        internalCluster().startDataOnlyNodes(2);
                    segmentRepoPath,
            REPOSITORY_NAME
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
    public void testRemotePublishConfigNodeJoinRemoteCluster() throws Exception {
        internalCluster().startClusterManagerOnlyNode();  
                    segmentRepoPath,
    public void testNonRemoteNodeJoiningPublishConfigCluster() throws Exception {
            "node.attr." + REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        Settings.Builder build = remotePublishConfiguredNodeSetting();  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        Settings settings = remoteWithRoutingTableNodeSetting().build();  
    }
 *  Remote Node [Cluster State + Segment + Translog]
        return Stream.concat(
 *  Remote Publish Configured Node [Cluster State + Routing Table]  
                    segmentRepoPath,  
                    segmentRepoPath,  
    }
            super.nodePlugins().stream(),
            .put("node.attr." + remoteRepoPrefix + ".routing_table.repository", ROUTING_TABLE_REPO_NAME)
        );
    public void testRemoteNodeJoiningPublishConfigCluster() throws Exception {
            .put(stateRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, true)
        internalCluster().startClusterManagerOnlyNode();
        );
        return Settings.builder()  
        ensureGreen();  
                    ReloadableFsRepository.TYPE,
         */  
package org.opensearch.gateway.remote;
        ensureStableCluster(4);
    private final String REMOTE_PRI_DOCREP_REP = "remote-primary-docrep-replica";  
        internalCluster().startDataOnlyNodes(2, settings);
    }
            .put("node.attr." + remoteRepoPrefix + ".state.repository", REPOSITORY_NAME)
                    translogRepoPath,  
 *  Remote Node With Routing Table [Cluster State + Segment + Translog + Routing Table]
        internalCluster().startDataOnlyNodes(2);  
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        String stateRepoTypeAttributeKey = String.format(  
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
            segmentRepoPath = randomRepoPath().toAbsolutePath();
        ensureStableCluster(4);  
            .put(routingTableRepoTypeAttributeKey, ReloadableFsRepository.TYPE)
        ensureGreen();
        ensureStableCluster(4);
        );
            .put(  
        Settings.Builder build = remotePublishConfiguredNodeSetting();
            remoteRepoPrefix,  
        return builder;
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        }  
            ROUTING_TABLE_REPO_NAME
        internalCluster().startDataOnlyNodes(2, settings);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        );
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        internalCluster().startClusterManagerOnlyNode(settings);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        Settings.Builder builder = Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        - InternalSettingsPlugin : To override default intervals of retention lease and global ckp sync
import java.util.stream.Collectors;
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        internalCluster().startClusterManagerOnlyNode(build.build());
    }  
import java.util.stream.Stream;  
                buildRemoteStoreNodeAttributes(
        setAddRemote(true);  
        internalCluster().startDataOnlyNodes(2, build.build());
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
    public void testRemoteNodeWithRoutingTableJoinRemoteCluster() throws Exception {  
            .put(
    @Before
    public Settings.Builder remoteWithRoutingTableNodeSetting() {
            .put(stateRepoSettingsAttributeKeyPrefix + "location", segmentRepoPath)
            Settings.builder()
        ensureGreen();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        internalCluster().startClusterManagerOnlyNode(settings);
            2,  
import org.opensearch.common.settings.Settings;
                buildRemoteStoreNodeAttributes(
                    false  
import org.opensearch.remotemigration.MigrationBaseTestCase;
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        setAddRemote(true);
    public Settings.Builder remotePublishConfiguredNodeSetting() {
        );  
            remoteRepoPrefix,  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
        ensureGreen();
        ensureGreen();
 *  Non Remote node [No Repositories configured]
 * this file be licensed under the Apache-2.0 license or a
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
                    REPOSITORY_NAME,  
        ensureStableCluster(4);
        if (segmentRepoPath == null || translogRepoPath == null) {  
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        updateSettingsRequest.persistentSettings(  
        ensureStableCluster(3);
 * The OpenSearch Contributors require contributions made to  
        String stateRepoSettingsAttributeKeyPrefix = String.format(
            "node.attr." + REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            )
                    ReloadableFsRepository.TYPE,
        internalCluster().startDataOnlyNodes(
import org.opensearch.plugins.Plugin;  
 *
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")  
        internalCluster().startClusterManagerOnlyNode();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            ROUTING_TABLE_REPO_NAME
        internalCluster().startClusterManagerOnlyNode();
    }
                    ROUTING_TABLE_REPO_NAME,
            Stream.of(InternalSettingsPlugin.class, MockFsRepositoryPlugin.class, MockTransportService.TestPlugin.class)  
 */  
    protected String remoteRepoPrefix = "remote_store";
        internalCluster().startClusterManagerOnlyNode();
        );
        internalCluster().startClusterManagerOnlyNode();
            .put(routingTableRepoSettingsAttributeKeyPrefix + "location", segmentRepoPath);  
            buildRemoteStateNodeAttributes(REPOSITORY_NAME, segmentRepoPath, ReloadableFsRepository.TYPE)  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        // Remote Cluster without Routing table
        internalCluster().startDataOnlyNodes(2, build.build());
    public void testRemoteClusterStateServiceNotInitialized_WhenNodeAttributesNotPresent() {  
            "node.attr." + REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
    }
            .build();  
/**  
        );
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        setAddRemote(false);
    }  
        internalCluster().startClusterManagerOnlyNode(build.build());
        );
        internalCluster().startClusterManagerOnlyNode(remotePublishConfiguredNodeSetting().build());
        // Remote Repo with Routing table
        String routingTableRepoTypeAttributeKey = String.format(  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        // Remote Cluster with Routing table
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        Settings.Builder build = remotePublishConfiguredNodeSetting();  
        internalCluster().getDataOrClusterManagerNodeInstances(RemoteClusterStateService.class).forEach(Assert::assertNull);
    }
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
        internalCluster().startClusterManagerOnlyNode();
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true);  
            remoteRepoPrefix,  
    public void testRemoteNodeWithRoutingTableJoiningPublishConfigCluster() throws Exception {
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        internalCluster().startClusterManagerOnlyNode(build.build());  
            Locale.getDefault(),  
        /* Adding the following mock plugins:  
                    FsRepository.TYPE,
                    REPOSITORY_NAME,
        ensureGreen();
        internalCluster().startDataOnlyNodes(2);
    public void testServiceInitialized_WhenNodeAttributesPresent() {
        internalCluster().startDataOnlyNodes(2);  
    }
    public void testRemotePublishConfigNodeJoinNonRemoteCluster() throws Exception {
    @Override
            Locale.getDefault(),
    public void setUp() throws Exception {
        ).collect(Collectors.toList());
        internalCluster().startClusterManagerOnlyNode(build.build());
        String routingTableRepoSettingsAttributeKeyPrefix = String.format(  
            translogRepoPath = randomRepoPath().toAbsolutePath();
        internalCluster().startClusterManagerOnlyNode(
        internalCluster().startClusterManagerOnlyNode(settings);
 * SPDX-License-Identifier: Apache-2.0
        super.setUp();
        Settings.Builder build = remotePublishConfiguredNodeSetting();  
        internalCluster().startDataOnlyNodes(2, build.build());
}
            Settings.builder()
import java.util.Locale;
import org.opensearch.test.transport.MockTransportService;
        internalCluster().startClusterManagerOnlyNode(build.build());  
import org.junit.Before;
        ensureGreen();
        ensureStableCluster(6);  
                    REPOSITORY_2_NAME,
            Locale.getDefault(),
 * compatible open source license.
        setAddRemote(false);  
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")  
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.Collection;  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        updateSettingsRequest.persistentSettings(
    }
import org.opensearch.test.InternalSettingsPlugin;  
        updateSettingsRequest.persistentSettings(
        );
            Locale.getDefault(),
        ensureGreen();
import org.opensearch.repositories.fs.ReloadableFsRepository;
            REPOSITORY_NAME  
            .put(stateRepoTypeAttributeKey, ReloadableFsRepository.TYPE)  
        );
        ensureStableCluster(4);  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;  
 * Tests the compatibility between types of nodes based on the configured repositories
        String prefixModeVerificationSuffix = BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey();
        ensureStableCluster(4);
                    false
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)  
        ensureGreen();
                    ROUTING_TABLE_REPO_NAME,
            Settings.builder()
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
            buildRemoteStateNodeAttributes(REPOSITORY_NAME, segmentRepoPath, ReloadableFsRepository.TYPE)
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        internalCluster().getDataOrClusterManagerNodeInstances(RemoteClusterStateService.class).forEach(Assert::assertNotNull);
    public void testRemotePublishConfigNodeJoinRemoteWithRoutingCluster() throws Exception {
                )  
    }  
        ensureStableCluster(3);
import org.junit.Assert;  
    }
            Settings.builder()
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")  
    }
 */  
/*  
        updateSettingsRequest.persistentSettings(
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")  
        setAddRemote(true);
public class RemoteRepositoryConfigurationIT extends MigrationBaseTestCase {
        Settings settings = Settings.builder()
        Settings settings = remoteWithRoutingTableNodeSetting().build();
        ensureStableCluster(4);  
        updateSettingsRequest.persistentSettings(
        );
            Settings.builder()
            remoteRepoPrefix,
