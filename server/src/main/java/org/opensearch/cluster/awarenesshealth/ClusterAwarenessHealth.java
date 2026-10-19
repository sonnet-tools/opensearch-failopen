        // Helper function to check if we need health for all or for one awareness attribute.
        int size = in.readVInt();
        );
        Settings forcedAwarenessSettings = clusterSettings.get(  
 */  
    }
    @Override
        );
     * @param clusterSettings        the current cluster settings.
        return Objects.hash(clusterAwarenessAttributesHealthMap);  
    private boolean canCalcUnassignedShards(ClusterSettings clusterSettings, String awarenessAttributeName) {
 *
    }
import java.util.Objects;
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Iterator;
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
        }
                displayUnassignedShardLevelInfo,
/*  
            awarenessAttributeList = clusterSettings.get(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING);
        return clusterAwarenessAttributesHealthMap.size() == that.clusterAwarenessAttributesHealthMap.size();
        return clusterAwarenessAttributesHealthMap;
}
                clusterState  
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
import java.util.List;  
                forcedZoneSettingsExists = true;  
        if (!forcedAwarenessSettings.isEmpty()) {  
        clusterAwarenessAttributesHealthMap = new HashMap<>();
    @Override
                    clusterAwarenessAttributesHealth.getAwarenessAttributeName(),
            // We will only mark true if particular awareness attribute exists
    public int hashCode() {
                clusterAwarenessAttributesHealthMap.put(  
    }
    }
        for (ClusterAwarenessAttributesHealth awarenessAttributeValueHealth : this) {  
        return "ClusterAwarenessHealth{"
    public ClusterAwarenessHealth(final StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;
            for (int i = 0; i < size; i++) {
                awarenessAttribute,
import java.util.HashMap;
            awarenessAttributeValueHealth.toXContent(builder, params);
        return allocationAwarenessBalance && forcedZoneSettingsExists;  
import java.util.Collections;  
            );
        if (this == o) return true;
    }
 * Cluster state Awareness health information
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
                );  
        for (String awarenessAttribute : awarenessAttributeList) {
    private List<String> getAwarenessAttributeList(String awarenessAttributeName, ClusterSettings clusterSettings) {
            displayUnassignedShardLevelInfo = canCalcUnassignedShards(clusterSettings, awarenessAttribute);
            clusterAwarenessAttributesHealthMap.put(awarenessAttribute, clusterAwarenessAttributesHealth);
        } else {
import org.opensearch.common.annotation.PublicApi;
    /**  
    public boolean equals(Object o) {  
 * @opensearch.api
    public String toString() {
     *
     * Creates cluster awareness health from cluster state.
import org.opensearch.core.common.io.stream.StreamOutput;
            + (clusterAwarenessAttributesHealthMap == null ? "null" : clusterAwarenessAttributesHealthMap.size())
    public Iterator<ClusterAwarenessAttributesHealth> iterator() {
        boolean allocationAwarenessBalance = clusterSettings.get(  
            clusterAwarenessAttributesHealth = new ClusterAwarenessAttributesHealth(  
    @Override  
        boolean displayAllAwarenessAttribute = awarenessAttributeName == null || awarenessAttributeName.isBlank();  
        ClusterAwarenessAttributesHealth clusterAwarenessAttributesHealth;
    }
            + "clusterAwarenessHealth.clusterAwarenessAttributesHealthMap.size="  
 * compatible open source license.
    @Override
    }
import java.io.IOException;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
 *  
        return clusterAwarenessAttributesHealthMap.values().iterator();  
    }
        }  
@PublicApi(since = "1.0.0")  
            }
        if (size > 0) {
        // Getting the replicaEnforcement settings as both are necessary for replica enforcement.
            + '}';
        return builder;
    public void writeTo(final StreamOutput out) throws IOException {
    public ClusterAwarenessHealth(ClusterState clusterState, ClusterSettings clusterSettings, String awarenessAttributeName) {
/**
            AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING
        }  
import org.opensearch.core.common.io.stream.Writeable;  
    private static final String AWARENESS_ATTRIBUTE = "awareness_attributes";  
        if (!displayAllAwarenessAttribute) {
        boolean forcedZoneSettingsExists = false;
            awarenessAttributeList.add(awarenessAttributeName);  
        boolean displayUnassignedShardLevelInfo;  
import java.util.ArrayList;
    @Override  
            for (ClusterAwarenessAttributesHealth awarenessAttributeValueHealth : this) {  
     * @param awarenessAttributeName Name of awareness attribute for which we need to see the health
        return awarenessAttributeList;
            }
                ClusterAwarenessAttributesHealth clusterAwarenessAttributesHealth = new ClusterAwarenessAttributesHealth(in);
        if (size > 0) {
        out.writeVInt(size);
        List<String> awarenessAttributeList = new ArrayList<>();
        ClusterAwarenessHealth that = (ClusterAwarenessHealth) o;  
     * @param clusterState           The current cluster state. Must not be null.  
     */  
        if (o == null || getClass() != o.getClass()) return false;
                awarenessAttributeValueHealth.writeTo(out);
        // This property will govern if we need to show unassigned shard info or not
import org.opensearch.core.xcontent.ToXContentFragment;
public class ClusterAwarenessHealth implements Writeable, ToXContentFragment, Iterable<ClusterAwarenessAttributesHealth> {
        builder.endObject();  
            clusterAwarenessAttributesHealthMap = new HashMap<>(size);  
            clusterAwarenessAttributesHealthMap = Collections.emptyMap();  
    }  
        builder.startObject(AWARENESS_ATTRIBUTE);
 */
        }
import org.opensearch.common.settings.Settings;  
    }
import org.opensearch.common.settings.ClusterSettings;
    public Map<String, ClusterAwarenessAttributesHealth> getClusterAwarenessAttributesHealthMap() {  
        List<String> awarenessAttributeList = getAwarenessAttributeList(awarenessAttributeName, clusterSettings);  
            AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING
import org.opensearch.cluster.ClusterState;
            if (forcedAwarenessSettings.hasValue(awarenessAttributeName + ".values")) {
    @Override
    private final Map<String, ClusterAwarenessAttributesHealth> clusterAwarenessAttributesHealthMap;
        }  
    }
 * this file be licensed under the Apache-2.0 license or a
        }
        int size = clusterAwarenessAttributesHealthMap.size();  
 * The OpenSearch Contributors require contributions made to  
                    clusterAwarenessAttributesHealth
package org.opensearch.cluster.awarenesshealth;
        } else {
