            allOf(startsWith("cannot upgrade a node from version ["), endsWith("] directly to version [" + Version.CURRENT + "]"))
                    try {
            assertThat(ex.getMessage(), startsWith("node does not have the data role but has shard data"));  
/*  
import org.opensearch.common.CheckedConsumer;  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
            illegalStateException.getMessage(),  
import org.opensearch.cluster.node.DiscoveryNodeRole;
            () -> internalCluster().startNode(Settings.builder().putList(Environment.PATH_DATA_SETTING.getKey(), allDataPaths))  
import org.opensearch.test.InternalTestCluster;
import java.util.Collections;
    }  
        }
        } else {
        logger.info("--> creating index");
        final IllegalStateException illegalStateException = expectThrowsOnRestart(  
            IllegalStateException.class,
                        throw new AssertionError(e);
        return expectThrows(  
    }
        IllegalStateException illegalStateException = expectThrows(
        );
        logger.info("--> starting one node");
    public void testFailsToStartIfUpgradedTooFar() {
        );
            })  
        );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(1)));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 */  
        final List<String> node0DataPaths = Environment.PATH_DATA_SETTING.get(internalCluster().dataPathSettings(nodes.get(0)));
                        Collections.unmodifiableSet(
            () -> internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
/*  
            })  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 *
            );  
                public Settings onNodeStopped(String nodeName) {  
 * license agreements. See the NOTICE file distributed with
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(0)));
                            new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.MASTER_ROLE))  
package org.opensearch.env;
import java.util.List;  
            Settings.builder().put(IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING.getKey(), writeDanglingIndices).build()
                }
            () -> internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        assertThat(illegalStateException.getMessage(), containsString("unexpected node ID in metadata"));  
import org.opensearch.gateway.PersistedClusterStateService;  
 * this file be licensed under the Apache-2.0 license or a
        );
/*
            allOf(startsWith("cannot downgrade a node from version ["), endsWith("] to version [" + Version.CURRENT + "]"))
        logger.info("--> restarting the node without the data role");  
import java.nio.file.Path;
import org.opensearch.test.OpenSearchIntegTestCase;
        final List<String> node1DataPathsPlusOne = new ArrayList<>(node1DataPaths);  
        final List<String> node1DataPaths = Environment.PATH_DATA_SETTING.get(internalCluster().dataPathSettings(nodes.get(1)));
        final IllegalStateException illegalStateException = expectThrowsOnRestart(
 * Modifications Copyright OpenSearch Contributors. See
                        onNodeStopped.accept(dataPaths);  
        );
 */
 */  
            "node not having the data and cluster-manager roles while having existing index metadata must fail",  
 *
        assertThat(
                    .forEach(indicesService -> assertTrue(indicesService.allPendingDanglingIndicesWritten()))
        client().prepareIndex(indexName).setId("1").setSource("field1", "value1").get();
        if (writeDanglingIndices) {  
                @Override
                        )
import org.opensearch.common.io.PathUtils;
            IllegalStateException.class,
    }
        );
            assertBusy(  
        final List<String> allDataPaths = new ArrayList<>(node0DataPaths);
import static org.hamcrest.Matchers.allOf;  
                    return Settings.EMPTY;
import java.util.Arrays;  
public class NodeEnvironmentIT extends OpenSearchIntegTestCase {  
                    } catch (Exception e) {
                @Override
import org.opensearch.indices.IndicesService;
            dataPaths -> PersistedClusterStateService.overrideVersion(NodeMetadataTests.tooNewVersion(), dataPaths)  
    }
                public Settings onNodeStopped(String nodeName) {
        assertThat(ex.getMessage(), startsWith("node does not have the data role but has shard data"));  
        String node = internalCluster().startNode(  
    public void testStartFailureOnDataForNonDataNode() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.test.NodeRoles.nonDataNode;
import java.util.ArrayList;
import static org.hamcrest.Matchers.containsString;
 * this work for additional information regarding copyright
 *  
                () -> internalCluster().getInstances(IndicesService.class)
                public Settings onNodeStopped(String nodeName) {  
            "node not having the data role while having existing shard data must fail",  
}  
        final boolean writeDanglingIndices = randomBoolean();
import java.io.IOException;  
        assertThat(  
        logger.info("--> start the node again with data and cluster-manager roles");  
        internalCluster().startNode(dataPathSettings);
        final List<String> nodes = internalCluster().startNodes(2);
        );
    private IllegalStateException expectThrowsOnRestart(CheckedConsumer<Path[], Exception> onNodeStopped) {  
        if (writeDanglingIndices) {
    public void testFailsToStartOnDataPathsFromMultipleNodes() throws IOException {  
        prepareCreate(indexName, Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0)).get();  
            IllegalStateException.class,
 * You may obtain a copy of the License at  
                    return NodeRoles.removeRoles(
            IllegalStateException.class,
import java.util.HashSet;
import org.opensearch.test.NodeRoles;  
            })
    }
        logger.info("--> indexing a simple document");  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        ensureStableCluster(2);
        }
            illegalStateException.getMessage(),
 * SPDX-License-Identifier: Apache-2.0
        allDataPaths.addAll(node1DataPaths);
 * compatible open source license.
                allDataPaths.stream().map(PathUtils::get).map(path -> NodeEnvironment.resolveNodePath(path, 0)).toArray(Path[]::new)
 * under the License.  
                    );
    public void testFailsToStartIfDowngraded() {
 * GitHub history for details.
import static org.hamcrest.Matchers.endsWith;
        internalCluster().startNode(Settings.builder().putList(Environment.PATH_DATA_SETTING.getKey(), node0DataPathsPlusOne));
        ex = expectThrows(
        assertThat(illegalStateException.getMessage(), containsString("unexpected node ID in metadata"));
                @Override  
        assertThat(ex.getMessage(), containsString(indexUUID));
        illegalStateException = expectThrows(
        final Path[] dataPaths = internalCluster().getInstance(NodeEnvironment.class).nodeDataPaths();
            () -> PersistedClusterStateService.nodeMetadata(  
import org.opensearch.common.settings.Settings;
            assertThat(ex.getMessage(), startsWith("node does not have the data and cluster_manager roles but has index metadata"));
        );  
        );
        logger.info("--> restarting the node without the data and cluster-manager roles");  
        final List<String> node0DataPathsPlusOne = new ArrayList<>(node0DataPaths);
            )
        ensureStableCluster(2);
import org.opensearch.Version;
import static org.hamcrest.Matchers.startsWith;  
                }
        node0DataPathsPlusOne.add(createTempDir().toString());  
        );  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        Settings dataPathSettings = internalCluster().dataPathSettings(node);  
                    return nonDataNode();
        internalCluster().startNode();
 * KIND, either express or implied.  See the License for the
            () -> internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        final String indexName = "test-fail-on-data";
                }  
        IllegalStateException ex = expectThrows(
        final String indexUUID = resolveIndex(indexName).getUUID();
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }  
        internalCluster().startNode(Settings.builder().putList(Environment.PATH_DATA_SETTING.getKey(), node1DataPathsPlusOne));
            dataPaths -> PersistedClusterStateService.overrideVersion(NodeMetadataTests.tooOldVersion(), dataPaths)
        node1DataPathsPlusOne.add(createTempDir().toString());
            IllegalStateException.class,
