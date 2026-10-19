        throws IOException {
public class DetachClusterCommand extends OpenSearchNodeCommand {  
 * ownership. Elasticsearch licenses this file to you under  
        }
import org.opensearch.cluster.ClusterState;
            .term(0)
 * GitHub history for details.
 */
/*
    // package-private for tests  
            "[old cluster state = " + oldClusterState + ", new cluster state = " + newClusterState + "]"  
 *
        terminal.println(NODE_DETACHED_MSG);  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public DetachClusterCommand() {
 * specific language governing permissions and limitations
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);  
 *  
 * KIND, either express or implied.  See the License for the
        terminal.println(Terminal.Verbosity.VERBOSE, "Loading cluster state");
        + "\n"
    static long updateCurrentTerm() {
    protected void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)
import joptsimple.OptionSet;  
    static final String CONFIRMATION_MSG = DELIMITER  
import org.opensearch.env.Environment;
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
    @Override  
        + "\n"
        confirm(terminal, CONFIRMATION_MSG);  
import org.opensearch.cli.Terminal;
            Terminal.Verbosity.VERBOSE,
    }
    }
            .build();  
 * license agreements. See the NOTICE file distributed with
        terminal.println(
 * the Apache License, Version 2.0 (the "License"); you may
 * Command to detach a node from the cluster
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    static final String NODE_DETACHED_MSG = "Node was successfully detached from the cluster";
import java.nio.file.Path;
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
            writer.writeFullStateAndCommit(updateCurrentTerm(), newClusterState);  
/*  
    }
            .lastCommittedConfiguration(CoordinationMetadata.VotingConfiguration.MUST_JOIN_ELECTED_CLUSTER_MANAGER)
 */
        + "You should only run this tool if you have permanently lost all of the\n"
}
        );
    // package-private for tests
        final ClusterState oldClusterState = loadTermAndClusterState(persistedClusterStateService, env).v2();  
 * this work for additional information regarding copyright
        super("Detaches this node from its cluster, allowing it to unsafely join a new cluster");  
 *
        + "by running `opensearch-node unsafe-bootstrap` on a cluster-manager-eligible\n"
 * compatible open source license.
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
            .lastAcceptedConfiguration(CoordinationMetadata.VotingConfiguration.MUST_JOIN_ELECTED_CLUSTER_MANAGER)  
        final ClusterState newClusterState = ClusterState.builder(oldClusterState)
        + "arbitrary data loss and its use should be your last resort.\n"
    static Metadata updateMetadata(Metadata oldMetadata) {
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * Modifications Copyright OpenSearch Contributors. See  
        + "cluster-manager-eligible nodes in this cluster and you cannot restore the cluster\n"  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.gateway.PersistedClusterStateService;
package org.opensearch.cluster.coordination;
        try (PersistedClusterStateService.Writer writer = persistedClusterStateService.createWriter()) {
            .build();  
import java.io.IOException;
        + "node that belonged to the same cluster as this node. This tool can cause\n"  
/*
        return Metadata.builder(oldMetadata).coordinationMetadata(coordinationMetadata).clusterUUIDCommitted(false).build();
        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder()
        + "from a snapshot, or you have already unsafely bootstrapped a new cluster\n"
 * You may obtain a copy of the License at  
            .metadata(updateMetadata(oldClusterState.metadata()))
    }
/**
        return 0;  
        + "Do you want to proceed?\n";  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.Metadata;  
