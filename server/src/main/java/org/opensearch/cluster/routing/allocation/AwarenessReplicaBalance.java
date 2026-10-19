 * compatible open source license.
            if (forcedAwarenessAttributes.containsKey(awarenessAttribute)) {
                return Optional.of(errorMessage);
        } else {  
 * This {@link AwarenessReplicaBalance} gives total unique values of awareness attributes
    In this case,  awareness attributes would be 3.  
        "cluster.routing.allocation.awareness.balance",
    }
    );  
        this.forcedAwarenessAttributes = forcedAwarenessAttributes;
        return awarenessAttributes;  
            if ((autoExpandSearchReplicas.getMaxSearchReplicas() != Integer.MAX_VALUE)
        if (autoExpandSearchReplicas.isEnabled()) {  
                awarenessAttributes = max(awarenessAttributes, forcedAwarenessAttributes.get(awarenessAttribute).size());  
                    + maxAwarenessAttributes()
    }
            }
        } else {
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING, this::setAwarenessAttributes);
        int awarenessAttributes = 1;  
import org.opensearch.cluster.metadata.AutoExpandSearchReplicas;
                    + maxAwarenessAttributes()  
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
            if (searchReplicaCount > 0 && searchReplicaCount % maxAwarenessAttributes() != 0) {  
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING = Setting.boolSetting(
                String errorMessage = "expected total copies needs to be a multiple of total awareness attributes ["
                    + "]";  
            if (aValues.size() > 0) {  
        this.awarenessAttributes = CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING, this::setAwarenessBalance);
    If there are multiple forced awareness attributes, it will return size of the largest list, as all copies of data
    For a cluster having zone as awareness attribute , it will return the size of zones if set it forced awareness attributes  
    }  
        Map<String, Settings> forceGroups = forceSettings.getAsGroups();  
 *
    private volatile List<String> awarenessAttributes;
        );  
            CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
/**
                return Optional.of(errorMessage);
                String errorMessage = "expected max cap on auto expand to be a multiple of total awareness attributes ["
    cluster.routing.allocation.awareness.attributes: rack_id , zone
                    + "]";
    public int maxAwarenessAttributes() {
import static java.lang.Math.max;  
import org.opensearch.common.settings.Setting;
import static org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING;
    cluster.routing.allocation.awareness.force.zone.values: zone1, zone2  
 */
    private void setForcedAwarenessAttributes(Settings forceSettings) {
        }  
            if ((autoExpandReplica.getMaxReplicas() != Integer.MAX_VALUE)
    }
    public AwarenessReplicaBalance(Settings settings, ClusterSettings clusterSettings) {
                return Optional.of(errorMessage);  
        Map<String, List<String>> forcedAwarenessAttributes = new HashMap<>();
    }
 * this file be licensed under the Apache-2.0 license or a
    private volatile Map<String, List<String>> forcedAwarenessAttributes;
}  
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
        Setting.Property.NodeScope
 * The OpenSearch Contributors require contributions made to  
            if ((replicaCount + 1) % maxAwarenessAttributes() != 0) {
            }  
        if (this.awarenessBalance == false) {
            return awarenessAttributes;
import static org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING;
                String errorMessage = "total search replicas needs to be a multiple of total awareness attributes ["
                    + maxAwarenessAttributes()
import org.opensearch.common.settings.ClusterSettings;  
                    + "]";  
            }
    cluster.routing.allocation.awareness.force.rack_id.values: rack_id1, rack_id2, rack_id3
                return Optional.of(errorMessage);
public class AwarenessReplicaBalance {  
        clusterSettings.addSettingsUpdateConsumer(  
    private void setAwarenessBalance(Boolean awarenessBalance) {  
 */  
 * Helps in balancing shards across all awareness attributes and ensuring high availability of data.
        }  
    }
 * cluster.routing.allocation.awareness.force.zone.values both are specified.
            }
        if (autoExpandReplica.isEnabled()) {
 * It takes in effect only iff cluster.routing.allocation.awareness.attributes and  
        return Optional.empty();
import java.util.List;
     */
        return Optional.empty();
        false,  
    /*
package org.opensearch.cluster.routing.allocation;
                forcedAwarenessAttributes.put(entry.getKey(), aValues);
import org.opensearch.cluster.metadata.AutoExpandReplicas;
 * This is used in enforcing total copy of shard is a maximum of unique values of awareness attributes  
        this.awarenessBalance = awarenessBalance;
    private volatile Boolean awarenessBalance;  
                String errorMessage = "expected max cap on auto expand search replicas to be a multiple of total awareness attributes ["  
            }
        }  
        setAwarenessBalance(CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.get(settings));
                    + "]";
    public Optional<String> validate(int replicaCount, AutoExpandReplicas autoExpandReplica) {  
    public Optional<String> validate(int searchReplicaCount, AutoExpandSearchReplicas autoExpandSearchReplicas) {
                && ((autoExpandSearchReplicas.getMaxSearchReplicas()) % maxAwarenessAttributes() != 0)) {
        for (String awarenessAttribute : this.awarenessAttributes) {
            }
            List<String> aValues = entry.getValue().getAsList("values");
/*  
                    + maxAwarenessAttributes()
import java.util.Map;  
    }  
    is supposed to get distributed amongst those.  
        }
        for (Map.Entry<String, Settings> entry : forceGroups.entrySet()) {
            this::setForcedAwarenessAttributes
import java.util.Optional;
        this.awarenessAttributes = awarenessAttributes;
        Setting.Property.Dynamic,
                && ((autoExpandReplica.getMaxReplicas() + 1) % maxAwarenessAttributes() != 0)) {  
import java.util.HashMap;
        }
        setForcedAwarenessAttributes(CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.get(settings));
 * <p>
