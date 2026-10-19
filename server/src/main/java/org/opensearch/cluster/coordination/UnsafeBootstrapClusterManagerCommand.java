 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
        applyClusterReadOnlyBlockOption = parser.accepts("apply-cluster-read-only-block", "Optional cluster.blocks.read_only setting")  
import org.opensearch.cluster.node.DiscoveryNode;
 */
 * You may obtain a copy of the License at  
 */
        + "\n"
    protected boolean validateBeforeLock(Terminal terminal, Environment env) {  
    );  
                .put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), applyClusterReadOnlyBlock)
        if (Objects.nonNull(applyClusterReadOnlyBlock)) {
            "Forces the successful election of the current node after the permanent loss of the half or more cluster-manager-eligible nodes"
            .persistentSettings(persistentSettings)
        Settings persistentSettings = Settings.builder().put(metadata.persistentSettings()).put(UNSAFE_BOOTSTRAP.getKey(), true).build();
            persistentSettings = Settings.builder()  
            .clusterUUIDCommitted(true)  
                    .settings(  
import org.opensearch.common.UUIDs;  
 * @opensearch.internal  
        throws IOException {
        }
        if (clusterManager == false) {
import java.util.Collections;  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            throw new OpenSearchException(REMOTE_CLUSTER_STATE_ENABLED_NODE);  
        "cluster.metadata.unsafe-bootstrap"
    static final String NOT_CLUSTER_MANAGER_NODE_MSG = "unsafe-bootstrap tool can only be run on cluster-manager eligible node";
            "[old cluster state = " + oldClusterState + ", new cluster state = " + newClusterState + "]"  
                            .put(IndexMetadata.SETTING_HISTORY_UUID, UUIDs.randomBase64UUID())  
                        Settings.builder()
/**  
package org.opensearch.cluster.coordination;
            throw new OpenSearchException(EMPTY_LAST_COMMITTED_VOTING_CONFIG_MSG);
        );
        }  
            .coordinationMetadata(newCoordinationMetadata);
        final Tuple<Long, ClusterState> state = loadTermAndClusterState(persistedClusterStateService, env);
    private OptionSpec<Boolean> applyClusterReadOnlyBlockOption;  
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
            throw new OpenSearchException(NOT_CLUSTER_MANAGER_NODE_MSG);
        final ClusterState newClusterState = ClusterState.builder(oldClusterState).metadata(newMetadata).build();
        final Metadata metadata = oldClusterState.metadata();
import joptsimple.OptionSet;  
        terminal.println(CLUSTER_MANAGER_NODE_BOOTSTRAPPED_MSG);  
        Boolean clusterManager = DiscoveryNode.isClusterManagerNode(settings);  
        final CoordinationMetadata coordinationMetadata = metadata.coordinationMetadata();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Metadata.Builder newMetadata = Metadata.builder(metadata)  
import org.opensearch.gateway.PersistedClusterStateService;
        );
            + ". For more details, please check the OpenSearch documentation.";
    static final String REMOTE_CLUSTER_STATE_ENABLED_NODE =
 * SPDX-License-Identifier: Apache-2.0
        + "eligible nodes, you should run this tool on the node with the highest\n"
    static final String CONFIRMATION_MSG = DELIMITER
                new CoordinationMetadata.VotingConfiguration(Collections.singleton(persistedClusterStateService.getNodeId()))
        + "Do you want to proceed?\n";
        // Blocking unsafe-bootstrap below for this reason.
                new CoordinationMetadata.VotingConfiguration(Collections.singleton(persistedClusterStateService.getNodeId()))
        + "cluster from a snapshot. This tool can cause arbitrary data loss and its\n"  
        + "of the cluster-manager-eligible nodes in this cluster, and you cannot restore the\n"
        CoordinationMetadata newCoordinationMetadata = CoordinationMetadata.builder(coordinationMetadata)
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
        Boolean applyClusterReadOnlyBlock = applyClusterReadOnlyBlockOption.value(options);
        terminal.println(  
import org.opensearch.common.collect.Tuple;
    static final String CLUSTER_STATE_TERM_VERSION_MSG_FORMAT = "Current node cluster state (term, version) pair is (%s, %s)";
        // During unsafe bootstrap, node will form a cluster with a new cluster UUID but with the existing metadata.
import org.opensearch.cluster.ClusterState;
        return true;  
            .lastCommittedConfiguration(  
            .clearVotingConfigExclusions()
 * license agreements. See the NOTICE file distributed with
 *
 * compatible open source license.
        super(  
    }  
        }
/*
            .lastAcceptedConfiguration(  
 * KIND, either express or implied.  See the License for the
 */
            .clusterUUID(Metadata.UNKNOWN_CLUSTER_UUID)
        + "You should only run this tool if you have permanently lost half or more\n"
import joptsimple.OptionSpec;
    static final String CLUSTER_MANAGER_NODE_BOOTSTRAPPED_MSG = "Cluster-manager node was successfully bootstrapped";  
import org.opensearch.env.Environment;
        );
                .put(persistentSettings)
            .withOptionalArg()
        }  
        terminal.println(
}
                            .put(indexMetadata.getSettings())
            .generateClusterUuidIfNeeded()
            || coordinationMetadata.getLastCommittedConfiguration().isEmpty()) {  
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);
    static final Setting<String> UNSAFE_BOOTSTRAP = ClusterService.USER_DEFINED_METADATA.getConcreteSetting(
        }
/*
        }
                .build();  
            .ofType(Boolean.class);
            )
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
    static final String EMPTY_LAST_COMMITTED_VOTING_CONFIG_MSG =  
        try (PersistedClusterStateService.Writer writer = persistedClusterStateService.createWriter()) {
 *
    protected void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)  
import java.io.IOException;
        Settings settings = env.settings();
        // the cluster UUID chain to get the last known cluster UUID to restore from.  
 * Tool to run an unsafe bootstrap
    }
 * The OpenSearch Contributors require contributions made to  
        + "cluster state (term, version) pair.\n"  
import org.opensearch.OpenSearchException;
        "Unsafe bootstrap cannot be performed when remote cluster state is enabled. The cluster state in the remote store is considered the source of truth. "
public class UnsafeBootstrapClusterManagerCommand extends OpenSearchNodeCommand {
        + "use should be your last resort. If you have multiple surviving cluster-manager\n"
import java.util.Objects;
        if (REMOTE_CLUSTER_STATE_ENABLED_SETTING.get(settings) == true) {
 * Licensed to Elasticsearch under one or more contributor  
            writer.writeFullStateAndCommit(state.v1(), newClusterState);  
 *  
        for (final IndexMetadata indexMetadata : metadata.indices().values()) {  
            + "In case, you still wish to do best effort recovery with unsafe-bootstrap, then please disable the "  
            )
        if (coordinationMetadata == null
import java.nio.file.Path;
            newMetadata.put(
                    )
        confirm(terminal, CONFIRMATION_MSG);  
/*  
    @Override
 *
import org.opensearch.cli.Terminal;  
 * GitHub history for details.
        + "\n"  
            || coordinationMetadata.getLastCommittedConfiguration() == null
import org.opensearch.common.settings.Settings;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
        "last committed voting voting configuration is empty, cluster has never been bootstrapped?";
import org.opensearch.common.settings.Setting;
        terminal.println(Terminal.Verbosity.VERBOSE, "Checking node.roles setting");
import org.opensearch.cluster.service.ClusterService;
                IndexMetadata.builder(indexMetadata)
            String.format(Locale.ROOT, CLUSTER_STATE_TERM_VERSION_MSG_FORMAT, coordinationMetadata.term(), metadata.version())
            + REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey()
        final ClusterState oldClusterState = state.v2();
 * under the License.  
 */  
            );
        // This new state will not know about the previous cluster UUIDs and so we will not able to construct
 * this work for additional information regarding copyright
    UnsafeBootstrapClusterManagerCommand() {
import org.opensearch.cluster.metadata.Metadata;  
            Terminal.Verbosity.VERBOSE,
 * specific language governing permissions and limitations
import java.util.Locale;
            .build();  
