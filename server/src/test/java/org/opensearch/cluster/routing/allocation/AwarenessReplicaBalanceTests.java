        assertEquals(awarenessReplicaBalance.validate(2, autoExpandReplica), Optional.empty());  
            .build();  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")  
            Optional.of("expected total copies needs to be a multiple of total awareness attributes [3]")
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")  
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
        AutoExpandReplicas autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandReplica), Optional.empty());  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS;
            Optional.of("expected max cap on auto expand to be a multiple of total awareness attributes [3]")
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
package org.opensearch.cluster.routing.allocation;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        assertEquals(  
    public void testForcedAwarenessAttribute() {
    public void testForcedAwarenessAttributeDisabled() {
            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-1")
import static org.hamcrest.Matchers.equalTo;
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
            awarenessReplicaBalance.validate(1, autoExpandSearchReplicas),
        );
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")  
        settings = Settings.builder()
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandReplica), Optional.empty());
            awarenessReplicaBalance.validate(1, autoExpandReplica),  
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-all")
    private static final ClusterSettings EMPTY_CLUSTER_SETTINGS = new ClusterSettings(
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")  
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, "0-1")  
        );  
        assertEquals(
            Optional.of("total search replicas needs to be a multiple of total awareness attributes [3]")  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")  
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);  
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
            .build();  
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-1")
            awarenessReplicaBalance.validate(0, autoExpandReplica),
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)  
        );
            .put("cluster.routing.allocation.awareness.attributes", "rack_id")  
        // when auto expand is not valid set as per zone awareness
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandSearchReplicas), Optional.empty());
            Optional.of("expected max cap on auto expand search replicas to be a multiple of total awareness attributes [3]")  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(
        );
        );  
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandSearchReplicas), Optional.empty());  
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-3")  
 */  
        assertEquals(
        awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
            .build();
        assertThat(awarenessReplicaBalance.maxAwarenessAttributes(), equalTo(1));  
            Optional.of("expected max cap on auto expand to be a multiple of total awareness attributes [3]")
        );  
    public void testNoForcedAwarenessAttribute() {
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandSearchReplicas), Optional.empty());  
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandSearchReplicas), Optional.empty());
        AutoExpandSearchReplicas autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
        Settings settings = Settings.builder()
            awarenessReplicaBalance.validate(2, autoExpandReplica),
        AutoExpandReplicas autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
        assertEquals(
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.ClusterSettings;
        );  
        assertEquals(awarenessReplicaBalance.validate(2, autoExpandReplica), Optional.empty());  
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandReplica), Optional.empty());
import org.opensearch.common.settings.Settings;  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
        AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);  
        assertThat(awarenessReplicaBalance.maxAwarenessAttributes(), equalTo(1));  
            Optional.of("expected max cap on auto expand search replicas to be a multiple of total awareness attributes [3]")
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
            awarenessReplicaBalance.validate(2, autoExpandSearchReplicas),
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-1")
            awarenessReplicaBalance.validate(1, autoExpandReplica),
            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-1")
        settings = Settings.builder()
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-2")
    }
            awarenessReplicaBalance.validate(2, autoExpandSearchReplicas),
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandReplica), Optional.empty());
    }
        Settings settings = Settings.builder()
    );
            .build();
            .build();  
        awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
        AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);  
            .build();  
        ClusterSettings.BUILT_IN_CLUSTER_SETTINGS
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandSearchReplicas), Optional.empty());
        Settings settings = Settings.builder()  
        autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);  
    }
            awarenessReplicaBalance.validate(1, autoExpandSearchReplicas),
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandReplica), Optional.empty());
            Optional.of("total search replicas needs to be a multiple of total awareness attributes [3]")
        settings = Settings.builder()
        assertThat(awarenessReplicaBalance.maxAwarenessAttributes(), equalTo(3));
import java.util.Optional;
}  
        assertEquals(awarenessReplicaBalance.validate(3, autoExpandSearchReplicas), Optional.empty());
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)  
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        // When auto expand replica settings is passed as max cap
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandReplica), Optional.empty());
        assertEquals(awarenessReplicaBalance.validate(0, autoExpandReplica), Optional.empty());
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandSearchReplicas), Optional.empty());
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d, e")
        AutoExpandReplicas autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);
        assertThat(awarenessReplicaBalance.maxAwarenessAttributes(), equalTo(3));
        awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
        AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(settings, EMPTY_CLUSTER_SETTINGS);
        Settings.EMPTY,  
        assertEquals(  
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandSearchReplicas), Optional.empty());
 *
import org.opensearch.cluster.metadata.AutoExpandReplicas;
            .put(SETTING_AUTO_EXPAND_REPLICAS, "0-1")
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
        // When auto expand replica settings is as per zone awareness
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertEquals(  
        assertEquals(awarenessReplicaBalance.validate(1, autoExpandReplica), Optional.empty());
        assertEquals(  
        );
        autoExpandSearchReplicas = AutoExpandSearchReplicas.SETTING.get(settings);
/*  
public class AwarenessReplicaBalanceTests extends OpenSearchAllocationTestCase {  
import org.opensearch.cluster.metadata.AutoExpandSearchReplicas;  
        assertEquals(awarenessReplicaBalance.validate(2, autoExpandReplica), Optional.empty());
            Optional.of("expected total copies needs to be a multiple of total awareness attributes [3]")  
        autoExpandReplica = AutoExpandReplicas.SETTING.get(settings);  
            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-all")
        // When auto expand replica is not present  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
