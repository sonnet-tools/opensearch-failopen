                            .put(IndexMetadata.SETTING_HISTORY_UUID, UUIDs.randomBase64UUID())
                .put(persistentSettings)
        super(
import org.opensearch.cluster.node.DiscoveryNode;
        );
/*
 * KIND, either express or implied.  See the License for the
        // Blocking unsafe-bootstrap below for this reason.
            )
        final Metadata metadata = oldClusterState.metadata();
 * license agreements. See the NOTICE file distributed with
                    )
    @Override
        "cluster.metadata.unsafe-bootstrap"
        Settings settings = env.settings();
            + ". For more details, please check the OpenSearch documentation.";
import org.opensearch.gateway.PersistedClusterStateService;
            throw new OpenSearchException(EMPTY_LAST_COMMITTED_VOTING_CONFIG_MSG);
import org.opensearch.cluster.metadata.IndexMetadata;
        Boolean clusterManager = DiscoveryNode.isClusterManagerNode(settings);
                    .settings(
 * GitHub history for details.
            "[old cluster state = " + oldClusterState + ", new cluster state = " + newClusterState + "]"
    UnsafeBootstrapClusterManagerCommand() {
import org.opensearch.common.settings.Settings;
import java.util.Objects;
            String.format(Locale.ROOT, CLUSTER_STATE_TERM_VERSION_MSG_FORMAT, coordinationMetadata.term(), metadata.version())
                IndexMetadata.builder(indexMetadata)
 * Licensed to Elasticsearch under one or more contributor
        terminal.println(
        + "eligible nodes, you should run this tool on the node with the highest\n"
 * Unless required by applicable law or agreed to in writing,
public class UnsafeBootstrapClusterManagerCommand extends OpenSearchNodeCommand {
    }
            Terminal.Verbosity.VERBOSE,
            .persistentSettings(persistentSettings)
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);
            || coordinationMetadata.getLastCommittedConfiguration() == null
import java.util.Locale;
        + "of the cluster-manager-eligible nodes in this cluster, and you cannot restore the\n"
        "last committed voting voting configuration is empty, cluster has never been bootstrapped?";
import org.opensearch.env.Environment;
 * ownership. Elasticsearch licenses this file to you under
            persistentSettings = Settings.builder()
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.OpenSearchException;
        // This new state will not know about the previous cluster UUIDs and so we will not able to construct
 *
        + "Do you want to proceed?\n";
        terminal.println(CLUSTER_MANAGER_NODE_BOOTSTRAPPED_MSG);
import org.opensearch.cluster.ClusterState;
            throw new OpenSearchException(REMOTE_CLUSTER_STATE_ENABLED_NODE);
        }
 */
        // the cluster UUID chain to get the last known cluster UUID to restore from.
 * compatible open source license.
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        applyClusterReadOnlyBlockOption = parser.accepts("apply-cluster-read-only-block", "Optional cluster.blocks.read_only setting")
            .generateClusterUuidIfNeeded()
package org.opensearch.cluster.coordination;
            .clearVotingConfigExclusions()
        Metadata.Builder newMetadata = Metadata.builder(metadata)
    static final String REMOTE_CLUSTER_STATE_ENABLED_NODE =
        Settings persistentSettings = Settings.builder().put(metadata.persistentSettings()).put(UNSAFE_BOOTSTRAP.getKey(), true).build();
    }
    );
            .clusterUUIDCommitted(true)
            .clusterUUID(Metadata.UNKNOWN_CLUSTER_UUID)
        if (coordinationMetadata == null
    protected void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)
    static final Setting<String> UNSAFE_BOOTSTRAP = ClusterService.USER_DEFINED_METADATA.getConcreteSetting(
 *
        final ClusterState newClusterState = ClusterState.builder(oldClusterState).metadata(newMetadata).build();
                new CoordinationMetadata.VotingConfiguration(Collections.singleton(persistedClusterStateService.getNodeId()))
        + "use should be your last resort. If you have multiple surviving cluster-manager\n"
    protected boolean validateBeforeLock(Terminal terminal, Environment env) {
            .withOptionalArg()
                .put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), applyClusterReadOnlyBlock)
import org.opensearch.common.collect.Tuple;
            .lastAcceptedConfiguration(
                        Settings.builder()
        terminal.println(
    static final String NOT_CLUSTER_MANAGER_NODE_MSG = "unsafe-bootstrap tool can only be run on cluster-manager eligible node";
/**
        if (REMOTE_CLUSTER_STATE_ENABLED_SETTING.get(settings) == true) {
        try (PersistedClusterStateService.Writer writer = persistedClusterStateService.createWriter()) {
        final ClusterState oldClusterState = state.v2();
 *     http://www.apache.org/licenses/LICENSE-2.0
        + "\n"
        Boolean applyClusterReadOnlyBlock = applyClusterReadOnlyBlockOption.value(options);
import org.opensearch.cli.Terminal;
        }
        for (final IndexMetadata indexMetadata : metadata.indices().values()) {
 * Modifications Copyright OpenSearch Contributors. See
    }
 *
import org.opensearch.common.settings.Setting;
 * You may obtain a copy of the License at
        confirm(terminal, CONFIRMATION_MSG);
 */
 * @opensearch.internal
    private OptionSpec<Boolean> applyClusterReadOnlyBlockOption;
 * under the License.
        terminal.println(Terminal.Verbosity.VERBOSE, "Checking node.roles setting");
 *
            throw new OpenSearchException(NOT_CLUSTER_MANAGER_NODE_MSG);
    static final String CONFIRMATION_MSG = DELIMITER
            );
        final CoordinationMetadata coordinationMetadata = metadata.coordinationMetadata();
    static final String CLUSTER_STATE_TERM_VERSION_MSG_FORMAT = "Current node cluster state (term, version) pair is (%s, %s)";
        }
                new CoordinationMetadata.VotingConfiguration(Collections.singleton(persistedClusterStateService.getNodeId()))
        + "cluster state (term, version) pair.\n"
            .coordinationMetadata(newCoordinationMetadata);
 */
        }
        if (Objects.nonNull(applyClusterReadOnlyBlock)) {
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        + "\n"
        throws IOException {
            || coordinationMetadata.getLastCommittedConfiguration().isEmpty()) {
            )
                .build();
            newMetadata.put(
        // During unsafe bootstrap, node will form a cluster with a new cluster UUID but with the existing metadata.
import joptsimple.OptionSet;
import java.io.IOException;
import org.opensearch.common.UUIDs;
 * software distributed under the License is distributed on an
        }
        final Tuple<Long, ClusterState> state = loadTermAndClusterState(persistedClusterStateService, env);
                            .put(indexMetadata.getSettings())
    static final String CLUSTER_MANAGER_NODE_BOOTSTRAPPED_MSG = "Cluster-manager node was successfully bootstrapped";
        );
import org.opensearch.cluster.service.ClusterService;
        }
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .ofType(Boolean.class);
        );
        + "cluster from a snapshot. This tool can cause arbitrary data loss and its\n"
import joptsimple.OptionSpec;
        return true;
    static final String EMPTY_LAST_COMMITTED_VOTING_CONFIG_MSG =
        "Unsafe bootstrap cannot be performed when remote cluster state is enabled. The cluster state in the remote store is considered the source of truth. "
        CoordinationMetadata newCoordinationMetadata = CoordinationMetadata.builder(coordinationMetadata)
import java.util.Collections;
            + "In case, you still wish to do best effort recovery with unsafe-bootstrap, then please disable the "
 * specific language governing permissions and limitations
 * Tool to run an unsafe bootstrap
/*
            + REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey()
 * The OpenSearch Contributors require contributions made to
            "Forces the successful election of the current node after the permanent loss of the half or more cluster-manager-eligible nodes"
            writer.writeFullStateAndCommit(state.v1(), newClusterState);
import java.nio.file.Path;
}
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * SPDX-License-Identifier: Apache-2.0
/*
            .lastCommittedConfiguration(
        + "You should only run this tool if you have permanently lost half or more\n"
        if (clusterManager == false) {
