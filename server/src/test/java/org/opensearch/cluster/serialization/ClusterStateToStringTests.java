import org.opensearch.Version;  
            .metadata(metadata)  
                    .build()
        DiscoveryNodes nodes = DiscoveryNodes.builder()
import static org.hamcrest.Matchers.containsString;
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * KIND, either express or implied.  See the License for the
            .build();
        clusterState = ClusterState.builder(clusterState).routingTable(strategy.reroute(clusterState, "reroute").routingTable()).build();
import org.opensearch.cluster.ClusterState;
 * compatible open source license.
 */  
        assertThat(clusterStateString, containsString("test_template"));
/*
        AllocationService strategy = createAllocationService();
 * this file be licensed under the Apache-2.0 license or a
            .build();  
        assertNotNull(clusterStateString);
            .localNodeId("node_foo")  
 * specific language governing permissions and limitations
        assertThat(clusterStateString, containsString("test_idx"));
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
import org.opensearch.cluster.metadata.IndexMetadata;
import static java.util.Collections.emptySet;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;
 *  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Licensed to Elasticsearch under one or more contributor  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .nodes(nodes)
                    .patterns(Arrays.asList(generateRandomStringArray(10, 100, false, false)))  
import org.opensearch.core.common.Strings;  
 *
    public void testClusterStateSerialization() throws Exception {
package org.opensearch.cluster.serialization;
import static java.util.Collections.emptyMap;
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        String clusterStateString = Strings.toString(MediaTypeRegistry.JSON, clusterState);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
import org.opensearch.cluster.ClusterName;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.node.DiscoveryNode;
 *     http://www.apache.org/licenses/LICENSE-2.0
                IndexTemplateMetadata.builder("test_template")
            .build();
import org.opensearch.cluster.metadata.Metadata;  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * Modifications Copyright OpenSearch Contributors. See  
    }
 * GitHub history for details.
 * You may obtain a copy of the License at  
 *
            .clusterManagerNodeId("node_foo")
/*
        assertThat(clusterStateString, containsString("node_foo"));  
import java.util.Arrays;  
/*  
 * this work for additional information regarding copyright
import org.opensearch.cluster.node.DiscoveryNodes;
            .put(IndexMetadata.builder("test_idx").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))  
            .add(new DiscoveryNode("node_foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT))
 * under the License.  
            .put(
        Metadata metadata = Metadata.builder()
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test_idx")).build();
public class ClusterStateToStringTests extends OpenSearchAllocationTestCase {  
import org.opensearch.cluster.routing.allocation.AllocationService;
            )
            .routingTable(routingTable)
import org.opensearch.cluster.routing.RoutingTable;  
 * not use this file except in compliance with the License.
}
