        logger.info("--> start the node again with data and cluster-manager roles");
            IllegalStateException.class,
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
                    );
import org.opensearch.common.settings.Settings;
import java.util.ArrayList;
            );
        logger.info("--> creating index");
            IllegalStateException.class,
 */
                allDataPaths.stream().map(PathUtils::get).map(path -> NodeEnvironment.resolveNodePath(path, 0)).toArray(Path[]::new)
                    return nonDataNode();
                }
 * KIND, either express or implied.  See the License for the
        client().prepareIndex(indexName).setId("1").setSource("field1", "value1").get();
                        Collections.unmodifiableSet(
import org.opensearch.gateway.PersistedClusterStateService;
                }
 * compatible open source license.
 * not use this file except in compliance with the License.
        assertThat(illegalStateException.getMessage(), containsString("unexpected node ID in metadata"));
        if (writeDanglingIndices) {
        final boolean writeDanglingIndices = randomBoolean();
        );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(1)));
                @Override
        if (writeDanglingIndices) {
 */
        internalCluster().startNode(dataPathSettings);
            "node not having the data and cluster-manager roles while having existing index metadata must fail",
            () -> internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(0)));
            allOf(startsWith("cannot downgrade a node from version ["), endsWith("] to version [" + Version.CURRENT + "]"))
    public void testStartFailureOnDataForNonDataNode() throws Exception {
            () -> PersistedClusterStateService.nodeMetadata(
    public void testFailsToStartIfUpgradedTooFar() {
 * this file be licensed under the Apache-2.0 license or a
        final IllegalStateException illegalStateException = expectThrowsOnRestart(
        final List<String> nodes = internalCluster().startNodes(2);
import org.opensearch.common.io.PathUtils;
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        );
        final List<String> allDataPaths = new ArrayList<>(node0DataPaths);
                    }
import java.io.IOException;
        final IllegalStateException illegalStateException = expectThrowsOnRestart(
            () -> internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
 * GitHub history for details.
        logger.info("--> starting one node");
    }
        );
 * You may obtain a copy of the License at
import org.opensearch.Version;
        internalCluster().startNode(Settings.builder().putList(Environment.PATH_DATA_SETTING.getKey(), node1DataPathsPlusOne));
import java.util.Collections;
import static org.opensearch.test.NodeRoles.nonDataNode;
 *
                @Override
        } else {
            IllegalStateException.class,
        IllegalStateException illegalStateException = expectThrows(
            "node not having the data role while having existing shard data must fail",
        ensureStableCluster(2);
        ex = expectThrows(
            dataPaths -> PersistedClusterStateService.overrideVersion(NodeMetadataTests.tooOldVersion(), dataPaths)
        illegalStateException = expectThrows(
 * license agreements. See the NOTICE file distributed with
                public Settings onNodeStopped(String nodeName) {
import org.opensearch.common.CheckedConsumer;
        internalCluster().startNode(Settings.builder().putList(Environment.PATH_DATA_SETTING.getKey(), node0DataPathsPlusOne));
        allDataPaths.addAll(node1DataPaths);
        );
            )
                    try {
            Settings.builder().put(IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING.getKey(), writeDanglingIndices).build()
    private IllegalStateException expectThrowsOnRestart(CheckedConsumer<Path[], Exception> onNodeStopped) {
            dataPaths -> PersistedClusterStateService.overrideVersion(NodeMetadataTests.tooNewVersion(), dataPaths)
            illegalStateException.getMessage(),
 * this work for additional information regarding copyright
    }
public class NodeEnvironmentIT extends OpenSearchIntegTestCase {
                public Settings onNodeStopped(String nodeName) {
/*
    }
                public Settings onNodeStopped(String nodeName) {
        assertThat(ex.getMessage(), startsWith("node does not have the data role but has shard data"));
                    return Settings.EMPTY;
                @Override
        return expectThrows(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
import java.util.List;
import java.util.HashSet;
        prepareCreate(indexName, Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0)).get();
                }
 * specific language governing permissions and limitations
            illegalStateException.getMessage(),
        final List<String> node1DataPaths = Environment.PATH_DATA_SETTING.get(internalCluster().dataPathSettings(nodes.get(1)));
        node0DataPathsPlusOne.add(createTempDir().toString());
        );
        );
 * SPDX-License-Identifier: Apache-2.0
        );
            assertThat(ex.getMessage(), startsWith("node does not have the data and cluster_manager roles but has index metadata"));
            })
            () -> internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        node1DataPathsPlusOne.add(createTempDir().toString());
                    .forEach(indicesService -> assertTrue(indicesService.allPendingDanglingIndicesWritten()))
 *
import java.util.Arrays;
    public void testFailsToStartIfDowngraded() {
            })
            allOf(startsWith("cannot upgrade a node from version ["), endsWith("] directly to version [" + Version.CURRENT + "]"))
import org.opensearch.test.InternalTestCluster;
        );
        final Path[] dataPaths = internalCluster().getInstance(NodeEnvironment.class).nodeDataPaths();
import org.opensearch.cluster.node.DiscoveryNodeRole;
 * under the License.
 * ownership. Elasticsearch licenses this file to you under
/*
}
 * software distributed under the License is distributed on an
 */
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
 * Modifications Copyright OpenSearch Contributors. See
        logger.info("--> restarting the node without the data and cluster-manager roles");
 *
import static org.hamcrest.Matchers.containsString;
        ensureStableCluster(2);
            assertThat(ex.getMessage(), startsWith("node does not have the data role but has shard data"));
                    return NodeRoles.removeRoles(
        }
            () -> internalCluster().startNode(Settings.builder().putList(Environment.PATH_DATA_SETTING.getKey(), allDataPaths))
package org.opensearch.env;
        assertThat(
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testFailsToStartOnDataPathsFromMultipleNodes() throws IOException {
/*
import static org.hamcrest.Matchers.allOf;
import java.nio.file.Path;
    }
import static org.hamcrest.Matchers.endsWith;
            assertBusy(
        );
            })
                        throw new AssertionError(e);
                        )
import org.opensearch.test.NodeRoles;
        IllegalStateException ex = expectThrows(
        assertThat(ex.getMessage(), containsString(indexUUID));
                () -> internalCluster().getInstances(IndicesService.class)
import org.opensearch.indices.IndicesService;
 * The OpenSearch Contributors require contributions made to
        logger.info("--> indexing a simple document");
        logger.info("--> restarting the node without the data role");
        assertThat(
        final String indexUUID = resolveIndex(indexName).getUUID();
        internalCluster().startNode();
        final List<String> node0DataPaths = Environment.PATH_DATA_SETTING.get(internalCluster().dataPathSettings(nodes.get(0)));
        String node = internalCluster().startNode(
        final List<String> node0DataPathsPlusOne = new ArrayList<>(node0DataPaths);
                        onNodeStopped.accept(dataPaths);
                    } catch (Exception e) {
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.hamcrest.Matchers.startsWith;
        final List<String> node1DataPathsPlusOne = new ArrayList<>(node1DataPaths);
        final String indexName = "test-fail-on-data";
                            new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.MASTER_ROLE))
        assertThat(illegalStateException.getMessage(), containsString("unexpected node ID in metadata"));
            IllegalStateException.class,
            IllegalStateException.class,
        }
