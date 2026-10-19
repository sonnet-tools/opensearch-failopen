        ensureReadOnlyBlock(false, clusterManagerNode2);
    }
                .build()
 *
    public void testBootstrapNoNodeMetadata() {
                    metadata.coordinationMetadata().term(),
import org.opensearch.env.NodeEnvironment;
        String node = internalCluster().startNode();
        unsafeBootstrap(environment); // read-only block will remain same as one before bootstrap, in this case it is false
                String.format(
            .loadBestOnDiskState().metadata;
            )
        );
/*
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        internalCluster().stopRandomDataNode();
        String node = internalCluster().startClusterManagerOnlyNode(
        assertThat(state.metadata().persistentSettings().get(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()), equalTo("1234kb"));
        ensureReadOnlyBlock(false, clusterManagerNode2);
    public void test3ClusterManagerNodes2Failed() throws Exception {
                .build()
            );
        OpenSearchNodeCommand command,
                    current_block_state
            .prepareState()
        logger.info("--> try to unsafely bootstrap 1st cluster-manager-eligible node, while node lock is held");
        assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(true));
                .cluster()
    public void testBootstrapAbortedByUser() throws IOException {
        return terminal;
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNodes.get(1)));
                Settings.builder().put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "0s").build()
            0,
        ClusterUpdateSettingsRequest req = new ClusterUpdateSettingsRequest().persistentSettings(
        );
    }
        List<String> currentClusterNodes = new ArrayList<>(clusterManagerNodes);
import org.opensearch.cluster.metadata.Metadata;
        expectThrows(() -> unsafeBootstrap(environment), UnsafeBootstrapClusterManagerCommand.NOT_CLUSTER_MANAGER_NODE_MSG);
                .admin()
        internalCluster().stopRandomDataNode();
                .forEach(indicesService -> assertTrue(indicesService.allPendingDanglingIndicesWritten()))
 */
        if (isInternalCluster()) {
        logger.info("--> stop data-only node and detach it from the old cluster");
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
    }
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManager3DataPathSettings).build()
        OpenSearchException ex = expectThrows(OpenSearchException.class, runnable);
        } else {
    public void testBootstrapNodeLocked() throws IOException {
 * GitHub history for details.
        }
        );
    public void testNoInitialBootstrapAfterDetach() throws Exception {
    private MockTerminal detachCluster(Environment environment, boolean abort) throws Exception {
        final OptionSet options;
        );
        state = internalCluster().client().admin().cluster().prepareState().execute().actionGet().getState();
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
 * not use this file except in compliance with the License.
import org.opensearch.gateway.PersistedClusterStateService;
 * You may obtain a copy of the License at
        Settings envSettings = buildEnvSettings(Settings.EMPTY);
        try (NodeEnvironment ignored = new NodeEnvironment(envSettings, environment)) {
        ensureReadOnlyBlock(false, clusterManagerNode);
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        );
            Settings.builder()
        bootstrappedNodes.add(internalCluster().startClusterManagerOnlyNode(clusterManager2DataPathSettings));
/*
        return detachCluster(environment, false);
        assertThat(terminal.getOutput(), containsString(DetachClusterCommand.NODE_DETACHED_MSG));
        final Environment environment = TestEnvironment.newEnvironment(
        String dataNode = internalCluster().startDataOnlyNode(
        state = internalCluster().client().admin().cluster().prepareState().execute().actionGet().getState();
        bootstrappedNodes.forEach(node -> ensureReadOnlyBlock(true, node));
        assertBusy(() -> {
        String clusterManagerNode2 = internalCluster().startClusterManagerOnlyNode(clusterManagerNodeDataPathSettings);
        NodeEnvironment nodeEnvironment = internalCluster().getClusterManagerNodeInstance(NodeEnvironment.class);
        internalCluster().stopRandomDataNode();
        try (NodeEnvironment ignored = new NodeEnvironment(envSettings, environment)) {
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        Settings clusterManagerNodeDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);
        assertThat(
    }
            .getAsBoolean(Metadata.SETTING_READ_ONLY_SETTING.getKey(), false);
        );
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManagerNodeDataPathSettings).build()
        Environment environment = TestEnvironment.newEnvironment(
        logger.info("--> ensure NO_MASTER_BLOCK on data-only node");
        );
        logger.info("--> start data-only only node and ensure 2 nodes stable cluster");
                    expected_block_state,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        }
        );
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
    }
        assertBusy(() -> {
            .actionGet()
        );
            () -> internalCluster().getInstances(IndicesService.class)
import org.opensearch.env.Environment;
 * SPDX-License-Identifier: Apache-2.0
        });
            expectThrows(() -> unsafeBootstrap(environment), OpenSearchNodeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG);
        logger.info("--> stop 2nd and 3d cluster-manager eligible node");
        internalCluster().stopCurrentClusterManagerNode();
        expectThrows(() -> unsafeBootstrap(environment), OpenSearchNodeCommand.NO_NODE_FOLDER_FOUND_MSG);
            ClusterState state = internalCluster().client(dataNode2)
            assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node));
        String dataNode = internalCluster().startDataOnlyNode(settings); // node ordinal 1
        expectThrows(() -> unsafeBootstrap(environment), UnsafeBootstrapClusterManagerCommand.REMOTE_CLUSTER_STATE_ENABLED_NODE);
            assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING;
            options = command.getParser()
            Settings settings = Settings.builder().putNull(Metadata.SETTING_READ_ONLY_SETTING.getKey()).build();
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
        internalCluster().client().admin().cluster().updateSettings(req).get();
                    "-ordinal",
            .setLocal(true)
            applyClusterReadOnlyBlock
        expectThrows(() -> detachCluster(environment), OpenSearchNodeCommand.NO_NODE_FOLDER_FOUND_MSG);
    public void testDetachNoClusterState() throws IOException {
        try {
            .getState();
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
import org.opensearch.gateway.GatewayMetaState;
                    Boolean.toString(applyClusterReadOnlyBlock)
        ensureStableCluster(4);
        );
        internalCluster().stopCurrentClusterManagerNode();
            input = randomValueOtherThanMany(c -> c.equalsIgnoreCase("y"), () -> randomAlphaOfLength(1));
    public void testBootstrapNoDataFolder() {
        }
                .actionGet()
        createIndex("test");
        Environment environmentClusterManager1 = TestEnvironment.newEnvironment(
    private MockTerminal detachCluster(Environment environment) throws Exception {
        Settings clusterManagerNodeDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);
                )
                    "Read only setting for the node %s don't match. Expected %s. Actual %s",
                return true;
        logger.info("--> detach-cluster on data-only node");
        Settings settings = Settings.builder().put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true).build();
        detachCluster(environment);
 *    http://www.apache.org/licenses/LICENSE-2.0
        detachCluster(environment);
        ensureStableCluster(1);
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManager1DataPathSettings).build()
                    Locale.ROOT,
            input = randomBoolean() ? "y" : "Y";
        logger.info("--> create index test");
        );
        } else {
        final MockTerminal terminal = executeCommand(new DetachClusterCommand(), environment, 0, abort, null);
        assertBusy(
            new UnsafeBootstrapClusterManagerCommand(),
        );
            .build();
        Environment environment = TestEnvironment.newEnvironment(envSettings);
        );
        return unsafeBootstrap(environment, false, null);
        assertBusy(() -> internalCluster().getInstance(GatewayMetaState.class, dataNode).allPendingAsyncStatesWritten());
    }
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
        ensureGreen();
        logger.info("--> stop cluster-manager-eligible node, clear its data and start it again - new cluster should form");
        Settings clusterManagerNodeDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);
                .put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        expectThrows(() -> unsafeBootstrap(environment, true, null), OpenSearchNodeCommand.ABORTED_BY_USER_MSG);
        logger.info("--> verify that the dangling index exists and has green status");
        logger.info("--> start mixed data and cluster-manager-eligible node and bootstrap cluster");
            Settings.builder()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataNode));
        logger.info("--> index 1 doc and ensure index is green");
        ensureStableCluster(2);
        );
        ensureGreen("test");
        );
import java.util.ArrayList;
        ClusterState state = internalCluster().client().admin().cluster().prepareState().execute().actionGet().getState();
            Settings.builder().put(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "1234kb")
        client().prepareIndex("test").setId("1").setSource("field1", "value1").setRefreshPolicy(IMMEDIATE).get();
        final Environment environment = TestEnvironment.newEnvironment(internalCluster().getDefaultSettings());
        if (Objects.nonNull(applyClusterReadOnlyBlock)) {
import java.util.Objects;
        detachCluster(environmentClusterManager2, false);
}
        assertBusy(() -> { assertThat(client().admin().indices().prepareExists("test").execute().actionGet().isExists(), equalTo(true)); });
        Boolean applyClusterReadOnlyBlock
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNodes.get(0)));
import org.opensearch.test.InternalTestCluster;
    }
        assertThat(terminal.getOutput(), containsString(UnsafeBootstrapClusterManagerCommand.CLUSTER_MANAGER_NODE_BOOTSTRAPPED_MSG));
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> verify 1 doc in the index");
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.containsString;
import org.opensearch.gateway.remote.RemoteClusterStateService;
            UnsafeBootstrapClusterManagerCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG
        IndexMetadata indexMetadata = clusterService().state().metadata().index("test");
                state.metadata().persistentSettings().getAsBoolean(UnsafeBootstrapClusterManagerCommand.UNSAFE_BOOTSTRAP.getKey(), false)
        unsafeBootstrap(environment, false, false);
import joptsimple.OptionSet;
        boolean abort,
        int nodeOrdinal,
package org.opensearch.cluster.coordination;
        detachCluster(environmentData, false);
        ensureStableCluster(4);
                .put(internalCluster().getDefaultSettings())
        NodeEnvironment nodeEnvironment = internalCluster().getClusterManagerNodeInstance(NodeEnvironment.class);
        List<String> bootstrappedNodes = new ArrayList<>();
                .parse(
    private void removeBlock() {
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        bootstrappedNodes.add(clusterManagerNode2);
        );
    private MockTerminal executeCommand(
        expectThrows(() -> unsafeBootstrap(environment), UnsafeBootstrapClusterManagerCommand.EMPTY_LAST_COMMITTED_VOTING_CONFIG_MSG);
        PersistedClusterStateService.deleteAll(nodeEnvironment.nodeDataPaths());
        List<String> clusterManagerNodes = new ArrayList<>();
    public void testBootstrapNotClusterManagerEligible() {
        ensureGreen();
public class UnsafeBootstrapAndDetachCommandIT extends OpenSearchIntegTestCase {
        terminal.addTextInput(input);
                .build()
    }
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataNodeDataPathSettings).build()
    public void testDetachAbortedByUser() throws IOException {
        Settings envSettings = buildEnvSettings(Settings.EMPTY);
 * Licensed to Elasticsearch under one or more contributor
        );
                .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
                .setLocal(true)
        final String input;
        Metadata metadata = OpenSearchNodeCommand.createPersistedClusterStateService(Settings.EMPTY, nodeEnvironment.nodeDataPaths())
        currentClusterNodes.add(dataNode);
        logger.info("--> start 1st cluster-manager-eligible node");
    }
        );
        Environment environment = TestEnvironment.newEnvironment(
        );
            .put(internalCluster().dataPathSettings(dataNode), true)
            .execute()
    public void testBootstrapNotBootstrappedCluster() throws Exception {
                .setLocal(true)
        ensureStableCluster(2);
            containsString(
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
    public void testAllClusterManagerEligibleNodesFailedDanglingIndexImport() throws Exception {
        clusterManagerNodes.addAll(internalCluster().startClusterManagerOnlyNodes(2)); // node ordinals 2 and 3
        final Environment environment = TestEnvironment.newEnvironment(
        internalCluster().restartNode(clusterManagerNode, new InternalTestCluster.RestartCallback() {
            .cluster()
    }
import org.opensearch.cli.MockTerminal;
        ClusterUpdateSettingsRequest req = new ClusterUpdateSettingsRequest().persistentSettings(
        ensureGreen("test");
        final Environment environment = TestEnvironment.newEnvironment(
        ensureReadOnlyBlock(false, clusterManagerNode);
            assertTrue(
            )
import org.opensearch.cluster.metadata.IndexMetadata;
        internalCluster().stopCurrentClusterManagerNode();
        expectThrows(() -> unsafeBootstrap(environment), OpenSearchNodeCommand.NO_NODE_METADATA_FOUND_MSG);
        internalCluster().stopRandomDataNode();
        internalCluster().stopRandomDataNode();
                    "-apply-cluster-read-only-block",
                );
    }
import org.opensearch.cluster.ClusterState;
    }
        String clusterManagerNode2 = internalCluster().startClusterManagerOnlyNode(clusterManagerNodeDataPathSettings);
    }
    public void testUnsafeBootstrapWithApplyClusterReadOnlyBlockAsFalse() throws Exception {
import static org.hamcrest.Matchers.notNullValue;
        Environment environment = TestEnvironment.newEnvironment(
        String node = internalCluster().startNode(
        Environment environment = TestEnvironment.newEnvironment(
            Settings.builder()
            terminal.getOutput(),
    }
        assertThat(ex.getMessage(), containsString(message));
        Settings envSettings = buildEnvSettings(Settings.EMPTY);
            abort,
        logger.info("--> start 2nd and 3rd cluster-manager-eligible nodes and bootstrap");
            assertFalse(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
    private MockTerminal unsafeBootstrap(Environment environment) throws Exception {
        Environment environment = TestEnvironment.newEnvironment(envSettings);
                .cluster()
        } finally {
        logger.info("--> start 2nd and 3rd cluster-manager-eligible nodes and ensure 4 nodes stable cluster");
        Environment environment,
            Settings.builder().put(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "1234kb")
        Settings clusterManager3DataPathSettings = internalCluster().dataPathSettings(clusterManagerNodes.get(2));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNodes.get(2)));
                    Integer.toString(nodeOrdinal),
 * under the License.
        Settings dataNodeDataPathSettings = Settings.builder()
 *
            .put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true)
import java.io.IOException;
    private void expectThrows(ThrowingRunnable runnable, String message) {
    }
        bootstrappedNodes.add(dataNode2);
import org.opensearch.indices.IndicesService;
        logger.info("--> ensure there is no NO_MASTER_BLOCK and unsafe-bootstrap is reflected in cluster state");
    public void testDetachNodeLocked() throws IOException {
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManager2DataPathSettings).build()
        String clusterManagerNode = internalCluster().startNode(settings); // node ordinal 0
        String dataNode2 = internalCluster().startDataOnlyNode(dataNodeDataPathSettings);
            ClusterState state = internalCluster().client(dataNode)
        assertBusy(() -> {
                // give the cluster 2 seconds to elect the cluster-manager (it should not)
        ensureGreen("test");
        final Environment environment = TestEnvironment.newEnvironment(
import org.opensearch.node.Node.DiscoverySettings;
        logger.info("--> start 1st cluster-manager-eligible node");
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
import org.opensearch.OpenSearchException;
            public boolean clearData(String nodeName) {
                .prepareState()
import static org.hamcrest.Matchers.equalTo;
        boolean current_block_state = state.metadata()
                .getState();
    }
        NodeEnvironment nodeEnvironment = internalCluster().getClusterManagerNodeInstance(NodeEnvironment.class);
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
import static org.opensearch.gateway.DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING;
import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
    private void ensureReadOnlyBlock(boolean expected_block_state, String node) {
import org.opensearch.test.OpenSearchIntegTestCase;
    public void testCanRunUnsafeBootstrapAfterErroneousDetachWithoutLoosingMetadata() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(state.metadata().persistentSettings().get(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()), equalTo("1234kb"));
                .put(dataNodeDataPathSettings)
 *
        assertThat(state.metadata().settings().get(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()), equalTo("1234kb"));
            .persistentSettings()
        assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(true));
        assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
                )
    private MockTerminal unsafeBootstrap(Environment environment, boolean abort, Boolean applyClusterReadOnlyBlock) throws Exception {
        final Environment environment = TestEnvironment.newEnvironment(
    }
        }
            internalCluster().startClusterManagerOnlyNode(
        assertThat(terminal.getOutput(), containsString(UnsafeBootstrapClusterManagerCommand.CONFIRMATION_MSG));
        ensureStableCluster(1);
/*
import org.opensearch.env.TestEnvironment;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        }
        Settings clusterManager1DataPathSettings = internalCluster().dataPathSettings(clusterManagerNodes.get(0));
                String.format(
        logger.info("--> start data-only node and ensure 2 nodes stable cluster");
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
        expectThrows(() -> unsafeBootstrap(environment), OpenSearchNodeCommand.NO_NODE_FOLDER_FOUND_MSG);
            fail(
    }
        String node = internalCluster().startNode();
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
            () -> unsafeBootstrap(environmentClusterManager1),
                    Locale.ROOT,
        logger.info("--> verify the doc is there");
 * Modifications Copyright OpenSearch Contributors. See
        removeBlock();
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
            assertTrue(state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID));
 * Unless required by applicable law or agreed to in writing,
    }
 * compatible open source license.
    public void testDetachNoDataFolder() {
        );
 * ownership. Elasticsearch licenses this file to you under
    }
        return terminal;
        final MockTerminal terminal = new MockTerminal();
        logger.info("--> wait for all nodes to join the cluster");
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
            Settings.builder().put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "0s").build()
        bootstrappedNodes.forEach(node -> ensureReadOnlyBlock(true, node));
        );
                .put(internalCluster().getDefaultSettings())
            @Override
        detachCluster(environment, false);
            environment,
    }
        detachCluster(environmentClusterManager3, false);
        logger.info("--> ensure index test is green");
 * software distributed under the License is distributed on an
        });
        ClusterState state = internalCluster().client().admin().cluster().prepareState().setLocal(true).execute().actionGet().getState();
        final Environment environment = TestEnvironment.newEnvironment(internalCluster().getDefaultSettings());
        ensureStableCluster(1);
        String node = internalCluster().startNode();
        assertThat(indexMetadata.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID), notNullValue());
 */
            options = command.getParser().parse("-ordinal", Integer.toString(nodeOrdinal));
                .put(clusterManagerNodeDataPathSettings)
        ); // node ordinal 1
        Environment environment = TestEnvironment.newEnvironment(envSettings);
            Settings.builder().put(nonClusterManagerNode(internalCluster().getDefaultSettings())).build()
                .execute()
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                .actionGet()
        bootstrappedNodes.add(internalCluster().startClusterManagerOnlyNode(clusterManager3DataPathSettings));
        currentClusterNodes.forEach(node -> ensureReadOnlyBlock(false, node));
            assertThat(terminal.getOutput(), containsString(OpenSearchNodeCommand.STOP_WARNING_MSG));
        clusterManagerNodes.add(
        logger.info("--> start one data-only node");
        );
    }
            );
                .put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "2s")
            expectThrows(() -> detachCluster(environment), OpenSearchNodeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG);
        });
        expectThrows(() -> detachCluster(environment, true), OpenSearchNodeCommand.ABORTED_BY_USER_MSG);
        expectThrows(() -> detachCluster(environment), OpenSearchNodeCommand.NO_NODE_METADATA_FOUND_MSG);
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
        Environment environmentClusterManager3 = TestEnvironment.newEnvironment(
        Settings dataNodeDataPathSettings = internalCluster().dataPathSettings(dataNode);
import java.util.Locale;
        logger.info("--> stop 1st cluster-manager-eligible node and data-only node");
        Environment environmentClusterManager2 = TestEnvironment.newEnvironment(
        Settings clusterManager2DataPathSettings = internalCluster().dataPathSettings(clusterManagerNodes.get(1));
        internalCluster().stopRandomDataNode();
        if (abort) {
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManagerNodeDataPathSettings).build()
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
                .execute()
    }
    public void testBootstrapNoClusterState() throws IOException {
        );
            Settings.builder().put(internalCluster().getDefaultSettings()).put(clusterManagerNodeDataPathSettings).build()
        Environment environmentData = TestEnvironment.newEnvironment(
    public void testBootstrapRemoteClusterEnabled() {
                .put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "0s") // to ensure quick node startup
                .getState();
        final Environment environment = TestEnvironment.newEnvironment(
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
        assertThat(state.metadata().settings().get(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()), equalTo("1234kb"));
import java.util.List;
        Environment environment = TestEnvironment.newEnvironment(
                .admin()
        final MockTerminal terminal = executeCommand(
        assertThat(terminal.getOutput(), containsString(DetachClusterCommand.CONFIRMATION_MSG));
        }
                    node,
        ensureGreen("test");
        String clusterManagerNode2 = internalCluster().startClusterManagerOnlyNode(clusterManager1DataPathSettings);
        internalCluster().client().admin().cluster().updateSettings(req).get();
        String node = internalCluster().startNode();
        assertBusy(() -> internalCluster().getInstance(GatewayMetaState.class, dataNode).allPendingAsyncStatesWritten());
 */
            Settings.builder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        internalCluster().startDataOnlyNode(dataNodeDataPathSettings);
        });
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
 * The OpenSearch Contributors require contributions made to
                .build()
                    metadata.version()
                    UnsafeBootstrapClusterManagerCommand.CLUSTER_STATE_TERM_VERSION_MSG_FORMAT,
        ClusterState state = internalCluster().client(node)
        ensureStableCluster(1);
        logger.info("--> unsafely-bootstrap 1st cluster-manager-eligible node");
        MockTerminal terminal = unsafeBootstrap(environmentClusterManager1, false, true);
            command.execute(terminal, options, environment);
        ClusterState state = internalCluster().client().admin().cluster().prepareState().execute().actionGet().getState();
            .admin()
        expectThrows(
 * KIND, either express or implied.  See the License for the
        return terminal;
        }
                .prepareState()
    ) throws Exception {
        logger.info("--> start data-only node");
        if (current_block_state != expected_block_state) {
        PersistedClusterStateService.deleteAll(nodeEnvironment.nodeDataPaths());
        logger.info("--> detach-cluster on 2nd and 3rd cluster-manager-eligible nodes");
 * this work for additional information regarding copyright
        ); // node ordinal 0
            }
