        expectThrows(() -> unsafeBootstrap(environment), UnsafeBootstrapClusterManagerCommand.EMPTY_LAST_COMMITTED_VOTING_CONFIG_MSG);  
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManagerNodeDataPathSettings).build()  
        unsafeBootstrap(environment, false, false);
            .loadBestOnDiskState().metadata;  
        ensureGreen();  
import joptsimple.OptionSet;  
        if (current_block_state != expected_block_state) {  
        String node = internalCluster().startClusterManagerOnlyNode(
                    Boolean.toString(applyClusterReadOnlyBlock)  
    public void testBootstrapAbortedByUser() throws IOException {  
        internalCluster().stopRandomDataNode();
                .admin()
    public void testBootstrapNoDataFolder() {
        String node = internalCluster().startNode();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNodes.get(2)));  
            Settings.builder()
        clusterManagerNodes.add(
 * Modifications Copyright OpenSearch Contributors. See  
                .getState();
        String node = internalCluster().startNode();  
        assertThat(terminal.getOutput(), containsString(UnsafeBootstrapClusterManagerCommand.CLUSTER_MANAGER_NODE_BOOTSTRAPPED_MSG));  
        assertThat(terminal.getOutput(), containsString(DetachClusterCommand.NODE_DETACHED_MSG));
        );  
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
            expectThrows(() -> unsafeBootstrap(environment), OpenSearchNodeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG);  
import org.opensearch.gateway.PersistedClusterStateService;  
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
            expectThrows(() -> detachCluster(environment), OpenSearchNodeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG);
            .execute()  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
                )
        );
        Environment environment = TestEnvironment.newEnvironment(
        ); // node ordinal 1
    public void test3ClusterManagerNodes2Failed() throws Exception {
        String dataNode2 = internalCluster().startDataOnlyNode(dataNodeDataPathSettings);
        ensureStableCluster(1);
        List<String> currentClusterNodes = new ArrayList<>(clusterManagerNodes);  
            Settings.builder().put(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "1234kb")  
        String node = internalCluster().startNode();
    }  
        expectThrows(() -> detachCluster(environment), OpenSearchNodeCommand.NO_NODE_METADATA_FOUND_MSG);  
    public void testBootstrapRemoteClusterEnabled() {  
            .cluster()  
 * Unless required by applicable law or agreed to in writing,
        Settings clusterManager3DataPathSettings = internalCluster().dataPathSettings(clusterManagerNodes.get(2));
        ensureStableCluster(1);
        String dataNode = internalCluster().startDataOnlyNode(
            assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Settings.builder().put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "0s").build()  
                    metadata.version()
        String clusterManagerNode2 = internalCluster().startClusterManagerOnlyNode(clusterManager1DataPathSettings);
        );
        Environment environment = TestEnvironment.newEnvironment(envSettings);
                    node,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            Settings.builder().put(nonClusterManagerNode(internalCluster().getDefaultSettings())).build()
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
                    "Read only setting for the node %s don't match. Expected %s. Actual %s",
                .parse(
        NodeEnvironment nodeEnvironment = internalCluster().getClusterManagerNodeInstance(NodeEnvironment.class);
        expectThrows(() -> unsafeBootstrap(environment), UnsafeBootstrapClusterManagerCommand.NOT_CLUSTER_MANAGER_NODE_MSG);  
        final MockTerminal terminal = executeCommand(new DetachClusterCommand(), environment, 0, abort, null);
        String clusterManagerNode2 = internalCluster().startClusterManagerOnlyNode(clusterManagerNodeDataPathSettings);
        final Environment environment = TestEnvironment.newEnvironment(internalCluster().getDefaultSettings());
            abort,
                .cluster()  
        detachCluster(environment);  
        ensureGreen("test");
        state = internalCluster().client().admin().cluster().prepareState().execute().actionGet().getState();
        );  
import org.opensearch.cli.MockTerminal;  
import org.opensearch.node.Node.DiscoverySettings;  
        String node = internalCluster().startNode();
        logger.info("--> verify that the dangling index exists and has green status");
import org.opensearch.test.InternalTestCluster;
        internalCluster().stopRandomDataNode();
            terminal.getOutput(),
        bootstrappedNodes.add(dataNode2);  
        bootstrappedNodes.forEach(node -> ensureReadOnlyBlock(true, node));
        internalCluster().stopCurrentClusterManagerNode();
        assertBusy(() -> internalCluster().getInstance(GatewayMetaState.class, dataNode).allPendingAsyncStatesWritten());
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        ensureReadOnlyBlock(false, clusterManagerNode);
        logger.info("--> start data-only only node and ensure 2 nodes stable cluster");  
        logger.info("--> start 1st cluster-manager-eligible node");
    }
 */
                .forEach(indicesService -> assertTrue(indicesService.allPendingDanglingIndicesWritten()))
        final Environment environment = TestEnvironment.newEnvironment(internalCluster().getDefaultSettings());
 * Licensed to Elasticsearch under one or more contributor  
            .getAsBoolean(Metadata.SETTING_READ_ONLY_SETTING.getKey(), false);
        ClusterState state = internalCluster().client().admin().cluster().prepareState().execute().actionGet().getState();
        ensureStableCluster(4);
import org.opensearch.cluster.metadata.Metadata;  
        internalCluster().stopCurrentClusterManagerNode();  
        return unsafeBootstrap(environment, false, null);  
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManagerNodeDataPathSettings).build()
        Settings envSettings = buildEnvSettings(Settings.EMPTY);
            internalCluster().startClusterManagerOnlyNode(
        removeBlock();  
 * specific language governing permissions and limitations
    public void testBootstrapNotClusterManagerEligible() {
        logger.info("--> verify 1 doc in the index");
        Metadata metadata = OpenSearchNodeCommand.createPersistedClusterStateService(Settings.EMPTY, nodeEnvironment.nodeDataPaths())
            assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get());
        });
            .put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true)  
    }
        logger.info("--> start 2nd and 3rd cluster-manager-eligible nodes and bootstrap");  
        logger.info("--> start 2nd and 3rd cluster-manager-eligible nodes and ensure 4 nodes stable cluster");
 * You may obtain a copy of the License at  
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManager1DataPathSettings).build()
                .prepareState()
 *
        );
    }
        logger.info("--> detach-cluster on 2nd and 3rd cluster-manager-eligible nodes");  
        assertBusy(  
                .admin()
            .setLocal(true)
        );
        assertBusy(() -> {  
        logger.info("--> stop data-only node and detach it from the old cluster");  
        assertBusy(() -> internalCluster().getInstance(GatewayMetaState.class, dataNode).allPendingAsyncStatesWritten());  
        return terminal;
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManager3DataPathSettings).build()  
                    "-apply-cluster-read-only-block",
/*
 * KIND, either express or implied.  See the License for the
        ClusterUpdateSettingsRequest req = new ClusterUpdateSettingsRequest().persistentSettings(
        detachCluster(environment);
        );
 * license agreements. See the NOTICE file distributed with
        }  
        );
        Environment environmentData = TestEnvironment.newEnvironment(
    }
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);  
        try (NodeEnvironment ignored = new NodeEnvironment(envSettings, environment)) {
            () -> internalCluster().getInstances(IndicesService.class)
    }
        Settings dataNodeDataPathSettings = Settings.builder()
        ClusterState state = internalCluster().client(node)
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
            Settings.builder()  
        }
            .prepareState()
        expectThrows(() -> unsafeBootstrap(environment), UnsafeBootstrapClusterManagerCommand.REMOTE_CLUSTER_STATE_ENABLED_NODE);
        logger.info("--> start data-only node");
            containsString(  
    }
        ensureReadOnlyBlock(false, clusterManagerNode);
                .actionGet()  
        });
        OpenSearchNodeCommand command,
        );
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()  
        logger.info("--> try to unsafely bootstrap 1st cluster-manager-eligible node, while node lock is held");  
        int nodeOrdinal,  
        });  
    public void testDetachAbortedByUser() throws IOException {
    private MockTerminal unsafeBootstrap(Environment environment, boolean abort, Boolean applyClusterReadOnlyBlock) throws Exception {  
        PersistedClusterStateService.deleteAll(nodeEnvironment.nodeDataPaths());
        final Environment environment = TestEnvironment.newEnvironment(  
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
                );
        detachCluster(environmentClusterManager3, false);
                // give the cluster 2 seconds to elect the cluster-manager (it should not)
        ensureGreen();
        ensureStableCluster(1);
        assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(true));
        Environment environment = TestEnvironment.newEnvironment(
 */  
        logger.info("--> ensure index test is green");
        bootstrappedNodes.add(clusterManagerNode2);
 * The OpenSearch Contributors require contributions made to  
        internalCluster().stopRandomDataNode();
        String node = internalCluster().startNode(
        ensureGreen("test");  
                    expected_block_state,  
        Settings clusterManagerNodeDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);  
        bootstrappedNodes.add(internalCluster().startClusterManagerOnlyNode(clusterManager3DataPathSettings));  
 * not use this file except in compliance with the License.
public class UnsafeBootstrapAndDetachCommandIT extends OpenSearchIntegTestCase {
        detachCluster(environmentClusterManager2, false);
        Environment environment = TestEnvironment.newEnvironment(envSettings);
import java.util.ArrayList;
/*
        expectThrows(() -> detachCluster(environment), OpenSearchNodeCommand.NO_NODE_FOLDER_FOUND_MSG);
        assertThat(
    }  
            assertTrue(  
                .execute()
        return detachCluster(environment, false);
                state.metadata().persistentSettings().getAsBoolean(UnsafeBootstrapClusterManagerCommand.UNSAFE_BOOTSTRAP.getKey(), false)
import org.opensearch.cluster.ClusterState;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
                    UnsafeBootstrapClusterManagerCommand.CLUSTER_STATE_TERM_VERSION_MSG_FORMAT,  
            Settings.builder().put(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "1234kb")  
            () -> unsafeBootstrap(environmentClusterManager1),
            )
        logger.info("--> create index test");
        String clusterManagerNode = internalCluster().startNode(settings); // node ordinal 0  
        );  
package org.opensearch.cluster.coordination;
        assertThat(state.metadata().settings().get(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()), equalTo("1234kb"));
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("--> index 1 doc and ensure index is green");  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node));
                .put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true)
        final OptionSet options;
                )  
        Environment environment,
        final Environment environment = TestEnvironment.newEnvironment(
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNodes.get(0)));
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManager2DataPathSettings).build()
                .execute()  
 * ownership. Elasticsearch licenses this file to you under  
                .put(clusterManagerNodeDataPathSettings)  
        logger.info("--> ensure there is no NO_MASTER_BLOCK and unsafe-bootstrap is reflected in cluster state");
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        ensureGreen("test");  
        PersistedClusterStateService.deleteAll(nodeEnvironment.nodeDataPaths());
    public void testDetachNodeLocked() throws IOException {
            environment,  
    }
        Settings dataPathSettings = internalCluster().dataPathSettings(node);  
 * this file be licensed under the Apache-2.0 license or a
    }
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
        Environment environmentClusterManager1 = TestEnvironment.newEnvironment(
        Settings envSettings = buildEnvSettings(Settings.EMPTY);
        Environment environment = TestEnvironment.newEnvironment(
        assertThat(terminal.getOutput(), containsString(UnsafeBootstrapClusterManagerCommand.CONFIRMATION_MSG));
            input = randomValueOtherThanMany(c -> c.equalsIgnoreCase("y"), () -> randomAlphaOfLength(1));
                    metadata.coordinationMetadata().term(),
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManagerNodeDataPathSettings).build()  
        assertBusy(() -> {
                .actionGet()
        Settings dataPathSettings = internalCluster().dataPathSettings(node);  
        return terminal;
    }
        boolean current_block_state = state.metadata()  
        expectThrows(() -> detachCluster(environment, true), OpenSearchNodeCommand.ABORTED_BY_USER_MSG);
 *    http://www.apache.org/licenses/LICENSE-2.0
                    Integer.toString(nodeOrdinal),
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataNode));  
 *  
        internalCluster().stopRandomDataNode();  
            .admin()
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            @Override  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNodes.get(1)));
        );  
            public boolean clearData(String nodeName) {
    public void testBootstrapNoNodeMetadata() {  
        boolean abort,
    public void testBootstrapNotBootstrappedCluster() throws Exception {  
        MockTerminal terminal = unsafeBootstrap(environmentClusterManager1, false, true);
        Environment environment = TestEnvironment.newEnvironment(
import static org.hamcrest.Matchers.containsString;
 * GitHub history for details.
        assertThat(state.metadata().persistentSettings().get(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()), equalTo("1234kb"));
    }
    ) throws Exception {  
        IndexMetadata indexMetadata = clusterService().state().metadata().index("test");  
import org.opensearch.env.NodeEnvironment;  
        internalCluster().restartNode(clusterManagerNode, new InternalTestCluster.RestartCallback() {
        assertThat(ex.getMessage(), containsString(message));  
        String dataNode = internalCluster().startDataOnlyNode(settings); // node ordinal 1  
        clusterManagerNodes.addAll(internalCluster().startClusterManagerOnlyNodes(2)); // node ordinals 2 and 3
import org.opensearch.gateway.remote.RemoteClusterStateService;
    public void testDetachNoClusterState() throws IOException {  
        final Environment environment = TestEnvironment.newEnvironment(
        terminal.addTextInput(input);
    }
        } else {  
                String.format(
    private void removeBlock() {
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
        }
 * this work for additional information regarding copyright
        ClusterState state = internalCluster().client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
    public void testUnsafeBootstrapWithApplyClusterReadOnlyBlockAsFalse() throws Exception {
                .build()
    public void testDetachNoDataFolder() {  
        internalCluster().stopRandomDataNode();  
    }
                .put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "0s") // to ensure quick node startup  
import static org.hamcrest.Matchers.equalTo;  
        NodeEnvironment nodeEnvironment = internalCluster().getClusterManagerNodeInstance(NodeEnvironment.class);
            .build();
        List<String> clusterManagerNodes = new ArrayList<>();
    }
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        );
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataNodeDataPathSettings).build()  
            assertFalse(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
            .getState();
        logger.info("--> wait for all nodes to join the cluster");  
        logger.info("--> ensure NO_MASTER_BLOCK on data-only node");
        ClusterState state = internalCluster().client().admin().cluster().prepareState().execute().actionGet().getState();
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        internalCluster().stopCurrentClusterManagerNode();  
        expectThrows(
            options = command.getParser()
            .actionGet()
            applyClusterReadOnlyBlock  
                .getState();
        assertThat(terminal.getOutput(), containsString(DetachClusterCommand.CONFIRMATION_MSG));  
        final MockTerminal terminal = executeCommand(
        final MockTerminal terminal = new MockTerminal();
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING;
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        }
        Boolean applyClusterReadOnlyBlock
        return terminal;  
        if (abort) {
        assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
            );
            options = command.getParser().parse("-ordinal", Integer.toString(nodeOrdinal));  
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
                .put(internalCluster().getDefaultSettings())  
        Settings clusterManagerNodeDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);
        );  
            ClusterState state = internalCluster().client(dataNode)
        ensureReadOnlyBlock(false, clusterManagerNode2);
        internalCluster().startDataOnlyNode(dataNodeDataPathSettings);
            Settings settings = Settings.builder().putNull(Metadata.SETTING_READ_ONLY_SETTING.getKey()).build();  
        Settings settings = Settings.builder().put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true).build();  
        createIndex("test");
        Settings clusterManager1DataPathSettings = internalCluster().dataPathSettings(clusterManagerNodes.get(0));
        String clusterManagerNode2 = internalCluster().startClusterManagerOnlyNode(clusterManagerNodeDataPathSettings);
        );
        final Environment environment = TestEnvironment.newEnvironment(
                .put(internalCluster().getDefaultSettings())  
        }
        Environment environmentClusterManager2 = TestEnvironment.newEnvironment(
        final String input;
        logger.info("--> start mixed data and cluster-manager-eligible node and bootstrap cluster");
 *
        Environment environment = TestEnvironment.newEnvironment(envSettings);  
import static org.opensearch.gateway.DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING;
        logger.info("--> detach-cluster on data-only node");
        logger.info("--> stop cluster-manager-eligible node, clear its data and start it again - new cluster should form");
                .setLocal(true)
                .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
    private MockTerminal detachCluster(Environment environment, boolean abort) throws Exception {
        );
            UnsafeBootstrapClusterManagerCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG  
        );  
        logger.info("--> unsafely-bootstrap 1st cluster-manager-eligible node");  
        ensureStableCluster(4);
        );
import org.opensearch.env.TestEnvironment;
            fail(
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
                .put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "2s")
    }
                .cluster()
        assertThat(indexMetadata.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID), notNullValue());
        } finally {
        } else {
        ensureStableCluster(1);
        );
        assertBusy(() -> { assertThat(client().admin().indices().prepareExists("test").execute().actionGet().isExists(), equalTo(true)); });
        ); // node ordinal 0
        );
            )
            ClusterState state = internalCluster().client(dataNode2)  
        NodeEnvironment nodeEnvironment = internalCluster().getClusterManagerNodeInstance(NodeEnvironment.class);
            new UnsafeBootstrapClusterManagerCommand(),
                .build()
    }  
import java.util.List;  
            .put(internalCluster().dataPathSettings(dataNode), true)
        Settings dataNodeDataPathSettings = internalCluster().dataPathSettings(dataNode);
 * compatible open source license.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * SPDX-License-Identifier: Apache-2.0
        bootstrappedNodes.forEach(node -> ensureReadOnlyBlock(true, node));
        assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(true));  
 * under the License.  
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        internalCluster().setBootstrapClusterManagerNodeIndex(2);  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            0,
            assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
            input = randomBoolean() ? "y" : "Y";
        client().prepareIndex("test").setId("1").setSource("field1", "value1").setRefreshPolicy(IMMEDIATE).get();
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
    }  
                .setLocal(true)
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.indices.IndicesService;
                    Locale.ROOT,
    private void ensureReadOnlyBlock(boolean expected_block_state, String node) {  
        currentClusterNodes.forEach(node -> ensureReadOnlyBlock(false, node));
        Environment environment = TestEnvironment.newEnvironment(  
        ensureGreen("test");
    }
        ensureReadOnlyBlock(false, clusterManagerNode2);  
        internalCluster().client().admin().cluster().updateSettings(req).get();
import java.io.IOException;
            Settings.builder().put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "0s").build()  
        assertBusy(() -> {  
import org.opensearch.env.Environment;
        expectThrows(() -> unsafeBootstrap(environment), OpenSearchNodeCommand.NO_NODE_FOLDER_FOUND_MSG);  
        logger.info("--> start 1st cluster-manager-eligible node");  
                .build()  
                    Locale.ROOT,  
        Environment environmentClusterManager3 = TestEnvironment.newEnvironment(
        Settings clusterManagerNodeDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);
        if (Objects.nonNull(applyClusterReadOnlyBlock)) {  
        detachCluster(environmentData, false);
}
        }
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        logger.info("--> stop 2nd and 3d cluster-manager eligible node");
        bootstrappedNodes.add(internalCluster().startClusterManagerOnlyNode(clusterManager2DataPathSettings));
        Settings dataPathSettings = internalCluster().dataPathSettings(node);  
    public void testNoInitialBootstrapAfterDetach() throws Exception {  
        logger.info("--> start data-only node and ensure 2 nodes stable cluster");
        logger.info("--> start one data-only node");
import org.opensearch.common.settings.Settings;
    }
                .put(dataNodeDataPathSettings)
    }
                return true;
        Settings clusterManager2DataPathSettings = internalCluster().dataPathSettings(clusterManagerNodes.get(1));  
import java.util.Objects;
        expectThrows(() -> unsafeBootstrap(environment), OpenSearchNodeCommand.NO_NODE_METADATA_FOUND_MSG);  
        logger.info("--> verify the doc is there");
        logger.info("--> stop 1st cluster-manager-eligible node and data-only node");  
import java.util.Locale;
        final Environment environment = TestEnvironment.newEnvironment(
            Settings.builder()
        expectThrows(() -> unsafeBootstrap(environment, true, null), OpenSearchNodeCommand.ABORTED_BY_USER_MSG);
            Settings.builder()
 * the Apache License, Version 2.0 (the "License"); you may
        });  
        try (NodeEnvironment ignored = new NodeEnvironment(envSettings, environment)) {
import org.opensearch.OpenSearchException;
    public void testAllClusterManagerEligibleNodesFailedDanglingIndexImport() throws Exception {  
        assertThat(state.metadata().settings().get(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()), equalTo("1234kb"));  
    }
        List<String> bootstrappedNodes = new ArrayList<>();
 */
                String.format(
    public void testBootstrapNodeLocked() throws IOException {
                    current_block_state
    public void testBootstrapNoClusterState() throws IOException {  
        detachCluster(environment, false);
        try {  
 * software distributed under the License is distributed on an
            );  
            command.execute(terminal, options, environment);
    public void testCanRunUnsafeBootstrapAfterErroneousDetachWithoutLoosingMetadata() throws Exception {
        state = internalCluster().client().admin().cluster().prepareState().execute().actionGet().getState();  
        unsafeBootstrap(environment); // read-only block will remain same as one before bootstrap, in this case it is false  
                .build()
        );  
        expectThrows(() -> unsafeBootstrap(environment), OpenSearchNodeCommand.NO_NODE_FOLDER_FOUND_MSG);  
            }  
        );
import org.opensearch.gateway.GatewayMetaState;
        );
    private MockTerminal detachCluster(Environment environment) throws Exception {  
            assertThat(terminal.getOutput(), containsString(OpenSearchNodeCommand.STOP_WARNING_MSG));  
    private void expectThrows(ThrowingRunnable runnable, String message) {
import static org.hamcrest.Matchers.notNullValue;
        if (isInternalCluster()) {
    }
        currentClusterNodes.add(dataNode);
        internalCluster().client().admin().cluster().updateSettings(req).get();
    }
    private MockTerminal executeCommand(  
        }
        OpenSearchException ex = expectThrows(OpenSearchException.class, runnable);
            .persistentSettings()
        ensureStableCluster(2);
                    "-ordinal",  
    private MockTerminal unsafeBootstrap(Environment environment) throws Exception {
        ClusterUpdateSettingsRequest req = new ClusterUpdateSettingsRequest().persistentSettings(
        internalCluster().stopRandomDataNode();  
        final Environment environment = TestEnvironment.newEnvironment(  
        assertThat(state.metadata().persistentSettings().get(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()), equalTo("1234kb"));
    }
/*  
                .prepareState()  
        ensureStableCluster(2);
        Settings envSettings = buildEnvSettings(Settings.EMPTY);  
        );
