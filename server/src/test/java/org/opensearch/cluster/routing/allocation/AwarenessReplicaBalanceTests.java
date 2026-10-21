        Settings settings = Settings.builder()
        settings = Settings.builder()
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
        AutoExpandReplicas autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        );
            awarenessReplicaBalance.validate(1, autoExpandSearchReplicas),
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
        assertEquals(
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
            Optional.of("total search replicas needs to be a multiple of total awareness attributes [3]")
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandReplica), Optional.empty());
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandReplica), Optional.empty());
        Settings settings = Settings.builder()
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-1")
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-all")
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandSearchReplicas), Optional.empty());
        awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
}
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-1")
        ClusterSettings.BUILT_IN_CLUSTER_SETTINGS
public class AwarenessReplicaBalanceTests extends OpenSearchAllocationTestCase {
            awarenessReplicaBalance.validate(2, autoExpandSearchReplicas),
 * SPDX-License-Identifier: Apache-2.0
            Optional.of("total search replicas needs to be a multiple of total awareness attributes [3]")
        );
        assertEquals(
 * compatible open source license.
import org.opensearch.cluster.metadata.AutoExpandReplicas;
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        );
            .build();
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
        assertEquals(
        AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
        assertEquals(
        Settings settings = Settings.builder()
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandReplica), Optional.empty());
        assertThat(awarenessReplicaBalance.maxAwarenessAttributes(), equalTo(3));
        AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
package org.opensearch.cluster.routing.allocation;
import org.opensearch.common.settings.Settings;
        awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
        assertThat(awarenessReplicaBalance.maxAwarenessAttributes(), equalTo(1));
            Optional.of("expected total copies needs to be a multiple of total awareness attributes [3]")
            Optional.of("expected max cap on auto expand search replicas to be a multiple of total awareness attributes [3]")
    private static final ClusterSettings EMPTY_CLUSTER_SETTINGS = new ClusterSettings(
        autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandSearchReplicas), Optional.empty());
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandReplica), Optional.empty());
        // When auto expand replica settings is passed as max cap
            Optional.of("expected max cap on auto expand search replicas to be a multiple of total awareness attributes [3]")
        assertThat(awarenessReplicaBalance.maxAwarenessAttributes(), equalTo(1));
            .build();
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        // when auto expand is not valid set as per zone awareness
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        assertThat(awarenessReplicaBalance.maxAwarenessAttributes(), equalTo(3));
            awarenessReplicaBalance.validate(2, autoExpandReplica),
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandSearchReplicas), Optional.empty());
        Settings.EMPTY,
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        assertEquals(awarenessReplicaBalance.validate(2, autoExpandReplica), Optional.empty());
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
            Optional.of("expected max cap on auto expand to be a multiple of total awareness attributes [3]")
        assertEquals(awarenessReplicaBalance.validate(2, autoExpandReplica), Optional.empty());
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, "0-1")
        // When auto expand replica settings is as per zone awareness
 */
    );
    }
        assertEquals(
    }
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandReplica), Optional.empty());
        assertEquals(
            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-1")
 * The OpenSearch Contributors require contributions made to
            awarenessReplicaBalance.validate(1, autoExpandSearchReplicas),
    }
        );
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
/*
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandSearchReplicas), Optional.empty());
            awarenessReplicaBalance.validate(1, autoExpandReplica),
        awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS;
        settings = Settings.builder()
            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-3")
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
            Optional.of("expected max cap on auto expand to be a multiple of total awareness attributes [3]")
            .build();
import org.opensearch.common.settings.ClusterSettings;
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
            awarenessReplicaBalance.validate(0, autoExpandReplica),
            awarenessReplicaBalance.validate(2, autoExpandSearchReplicas),
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-all")
            awarenessReplicaBalance.validate(1, autoExpandReplica),
import java.util.Optional;
        autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
            Optional.of("expected total copies needs to be a multiple of total awareness attributes [3]")
            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-1")
            .build();
        AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandReplica), Optional.empty());
    public void testNoForcedAwarenessAttribute() {
        );
        AutoExpandReplicas autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
 *
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
import org.opensearch.cluster.metadata.AutoExpandSearchReplicas;
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandSearchReplicas), Optional.empty());
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandSearchReplicas), Optional.empty());
        );
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        assertEquals(awarenessReplicaBalance.validate(3, autoExpandSearchReplicas), Optional.empty());
        // When auto expand replica is not present
    public void testForcedAwarenessAttribute() {
        );
            .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandSearchReplicas), Optional.empty());
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandReplica), Optional.empty());
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandReplica), Optional.empty());
    public void testForcedAwarenessAttributeDisabled() {
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        );
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-2")
            .build();
        assertEquals(awarenessReplicaBalance.validate(2, autoExpandReplica), Optional.empty());
        settings = Settings.builder()
            .build();
        autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-1")
        AutoExpandReplicas autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
        assertEquals(
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        assertEquals(
