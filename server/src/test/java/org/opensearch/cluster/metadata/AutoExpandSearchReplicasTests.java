            Settings.builder().put("index.auto_expand_search_replicas", "0-5").build()  
            )  
    public void testParseAutoExpandSearchReplicaSettings() {
import org.opensearch.common.settings.Settings;
        // when the number of matching search nodes is greater than the maximum value of auto-expand
        assertEquals(OptionalInt.of(5), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(8));
        Metadata metadata = Metadata.builder()
 * The OpenSearch Contributors require contributions made to  
        throwable = assertThrows(IllegalArgumentException.class, () -> {  
            "[index.auto_expand_search_replicas] minSearchReplicas must be =< maxSearchReplicas but wasn't 2 > 1",
            AutoExpandSearchReplicas.SETTING.get(Settings.builder().put("index.auto_expand_search_replicas", "boom").build());
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
        });
            .put(
            Settings.builder().put("index.auto_expand_search_replicas", "0-5").build()  
        // when the number of matching search nodes is lesser than the minimum value of auto-expand,
        );
        );  
            System.nanoTime()  
            .nodes(  
 * SPDX-License-Identifier: Apache-2.0
public class AutoExpandSearchReplicasTests extends OpenSearchAllocationTestCase {
    }
    public void testCalculateNumberOfSearchReplicas() {  
    }
                    .build()
        assertEquals(  
        );
        });
            null,
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(  
        );
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
        );
        // when the number of matching search nodes is lesser than the maximum value of auto-expand
        assertEquals(OptionalInt.of(5), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(5));
        assertEquals(OptionalInt.empty(), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(1));  
        assertEquals(0, autoExpandSearchReplicas.getMinSearchReplicas());
                    .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_ROLE, Version.CURRENT))
                    .numberOfReplicas(0)  
    }
            Settings.builder().put("index.auto_expand_search_replicas", "0-5").build()  
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
        });  
                DiscoveryNodes.builder()
        assertEquals(OptionalInt.of(0), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(0));
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
        );
            AutoExpandSearchReplicas.SETTING.get(Settings.builder().put("index.auto_expand_search_replicas", "2-1").build());
            null,
 * compatible open source license.
        assertEquals(1, autoExpandSearchReplicas.getMinSearchReplicas());
import org.opensearch.cluster.ClusterState;
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
    public void testInvalidValues() {  
        assertEquals(Integer.MAX_VALUE, autoExpandSearchReplicas.getMaxSearchReplicas());  
                    .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_ROLE, Version.CURRENT))  
            )
                    .numberOfSearchReplicas(1)
import org.opensearch.cluster.node.DiscoveryNodes;
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        throwable = assertThrows(IllegalArgumentException.class, () -> {  
    public void testGetAutoExpandReplicaChanges() {  
            Settings.builder().put("index.auto_expand_search_replicas", "0-5").build()  
            Settings.builder().put("index.auto_expand_search_replicas", "0-all").build()  
        assertEquals(Integer.MAX_VALUE, autoExpandSearchReplicas.getMaxSearchReplicas());  
                    .numberOfShards(1)
            AutoExpandSearchReplicas.SETTING.get(Settings.builder().put("index.auto_expand_search_replicas", "boom-1").build());
import java.util.Map;
package org.opensearch.cluster.metadata;
        );
            .build();  
        assertEquals("failed to parse [index.auto_expand_search_replicas] from value: [1-boom] at index 1", throwable.getMessage());  
        );
        );
        assertEquals(5, autoExpandSearchReplicas.getMaxSearchReplicas());  
            Settings.builder().put("index.auto_expand_search_replicas", "2-5").build()
 * this file be licensed under the Apache-2.0 license or a
            Settings.builder().put("index.auto_expand_search_replicas", "0-all").build()  
            throwable.getMessage()
        // when the number of matching search nodes is equal to the minimum value of auto-expand
        throwable = assertThrows(IllegalArgumentException.class, () -> {  
import java.util.Collections;  
            Settings.builder().put("index.auto_expand_search_replicas", "1-all").build()  
import java.util.OptionalInt;  
        RoutingAllocation allocation = new RoutingAllocation(  
            clusterState,  
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
            AutoExpandSearchReplicas.SETTING.get(Settings.builder().put("index.auto_expand_search_replicas", "1-boom").build());
 */  
            .routingTable(initialRoutingTable)
                IndexMetadata.builder("test")  
        assertEquals("failed to parse [index.auto_expand_search_replicas] from value: [boom] at index -1", throwable.getMessage());
        // then the number of search replicas remains unchanged
    }
            .build();
        );
            clusterState.getRoutingNodes(),
 *
        assertEquals(OptionalInt.of(5), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(5));
        });
        assertEquals("For input string: \"boom\"", throwable.getCause().getMessage());
        // when the number of matching search nodes is equal to the maximum value of auto-expand
            .metadata(metadata)
            yesAllocationDeciders(),
                    .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_ROLE, Version.CURRENT))
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        assertEquals(0, autoExpandSearchReplicas.getMinSearchReplicas());
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
/*  
        assertEquals("failed to parse [index.auto_expand_search_replicas] from value: [boom-1] at index 4", throwable.getMessage());  
import org.opensearch.Version;  
import org.opensearch.cluster.node.DiscoveryNode;  
import java.util.List;
import org.opensearch.cluster.routing.RoutingTable;
        assertEquals(Map.of(3, List.of("test")), AutoExpandSearchReplicas.getAutoExpandSearchReplicaChanges(metadata, allocation));  
                    .settings(settings(Version.CURRENT).put("index.auto_expand_search_replicas", "0-all"))
}
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
        assertEquals("For input string: \"boom\"", throwable.getCause().getMessage());
