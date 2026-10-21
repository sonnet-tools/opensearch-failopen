                IndexMetadata.builder("test")
 *
            )
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            Settings.builder().put("index.auto_expand_search_replicas", "0-5").build()
        // when the number of matching search nodes is equal to the maximum value of auto-expand
        assertEquals("For input string: \"boom\"", throwable.getCause().getMessage());
            Settings.builder().put("index.auto_expand_search_replicas", "2-5").build()
    }
        );
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(OptionalInt.of(5), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(5));
import java.util.Collections;
            AutoExpandSearchReplicas.SETTING.get(Settings.builder().put("index.auto_expand_search_replicas", "1-boom").build());
    public void testInvalidValues() {
    public void testParseAutoExpandSearchReplicaSettings() {
        });
        // when the number of matching search nodes is lesser than the maximum value of auto-expand
import org.opensearch.common.settings.Settings;
        assertEquals(OptionalInt.of(5), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(8));
public class AutoExpandSearchReplicasTests extends OpenSearchAllocationTestCase {
        throwable = assertThrows(IllegalArgumentException.class, () -> {
        Metadata metadata = Metadata.builder()
            Settings.builder().put("index.auto_expand_search_replicas", "0-5").build()
        assertEquals(0, autoExpandSearchReplicas.getMinSearchReplicas());
        );
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
    }
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
            System.nanoTime()
        assertEquals("failed to parse [index.auto_expand_search_replicas] from value: [boom-1] at index 4", throwable.getMessage());
        );
/*
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.Map;
 * compatible open source license.
            Settings.builder().put("index.auto_expand_search_replicas", "0-5").build()
 */
        );
        );
                    .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_ROLE, Version.CURRENT))
            Settings.builder().put("index.auto_expand_search_replicas", "0-all").build()
        // when the number of matching search nodes is greater than the maximum value of auto-expand
    }
                DiscoveryNodes.builder()
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
        assertEquals(1, autoExpandSearchReplicas.getMinSearchReplicas());
        );
                    .numberOfReplicas(0)
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            null,
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
import org.opensearch.cluster.node.DiscoveryNodes;
            AutoExpandSearchReplicas.SETTING.get(Settings.builder().put("index.auto_expand_search_replicas", "2-1").build());
package org.opensearch.cluster.metadata;
            .routingTable(initialRoutingTable)
    }
                    .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_ROLE, Version.CURRENT))
                    .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_ROLE, Version.CURRENT))
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            throwable.getMessage()
        assertEquals(OptionalInt.empty(), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(1));
        throwable = assertThrows(IllegalArgumentException.class, () -> {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        });
        assertEquals(
            )
        assertEquals(Integer.MAX_VALUE, autoExpandSearchReplicas.getMaxSearchReplicas());
        assertEquals("For input string: \"boom\"", throwable.getCause().getMessage());
            .put(
            .metadata(metadata)
            .build();
import org.opensearch.Version;
    public void testGetAutoExpandReplicaChanges() {
        );
            Settings.builder().put("index.auto_expand_search_replicas", "0-5").build()
        throwable = assertThrows(IllegalArgumentException.class, () -> {
import org.opensearch.cluster.routing.RoutingTable;
import java.util.OptionalInt;
import org.opensearch.cluster.ClusterState;
        assertEquals(5, autoExpandSearchReplicas.getMaxSearchReplicas());
        // when the number of matching search nodes is lesser than the minimum value of auto-expand,
        );
}
            clusterState.getRoutingNodes(),
            .build();
                    .build()
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
                    .numberOfSearchReplicas(1)
                    .numberOfShards(1)
        assertEquals("failed to parse [index.auto_expand_search_replicas] from value: [1-boom] at index 1", throwable.getMessage());
        // then the number of search replicas remains unchanged
            Settings.builder().put("index.auto_expand_search_replicas", "0-all").build()
            "[index.auto_expand_search_replicas] minSearchReplicas must be =< maxSearchReplicas but wasn't 2 > 1",
        });
        // when the number of matching search nodes is equal to the minimum value of auto-expand
        assertEquals("failed to parse [index.auto_expand_search_replicas] from value: [boom] at index -1", throwable.getMessage());
            null,
        );
        assertEquals(OptionalInt.of(5), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(5));
        assertEquals(Map.of(3, List.of("test")), AutoExpandSearchReplicas.getAutoExpandSearchReplicaChanges(metadata, allocation));
        assertEquals(OptionalInt.of(0), autoExpandSearchReplicas.calculateNumberOfSearchReplicas(0));
            yesAllocationDeciders(),
        assertEquals(Integer.MAX_VALUE, autoExpandSearchReplicas.getMaxSearchReplicas());
        RoutingAllocation allocation = new RoutingAllocation(
            Settings.builder().put("index.auto_expand_search_replicas", "1-all").build()
            clusterState,
    public void testCalculateNumberOfSearchReplicas() {
            AutoExpandSearchReplicas.SETTING.get(Settings.builder().put("index.auto_expand_search_replicas", "boom-1").build());
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
 * The OpenSearch Contributors require contributions made to
            .nodes(
        });
                    .settings(settings(Version.CURRENT).put("index.auto_expand_search_replicas", "0-all"))
        assertEquals(0, autoExpandSearchReplicas.getMinSearchReplicas());
        );
            AutoExpandSearchReplicas.SETTING.get(Settings.builder().put("index.auto_expand_search_replicas", "boom").build());
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(
