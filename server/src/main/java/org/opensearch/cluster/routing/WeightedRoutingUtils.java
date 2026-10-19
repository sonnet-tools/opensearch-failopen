                    .filter(entry -> entry.getValue().intValue() == WeightedRoutingMetadata.WEIGHED_AWAY_WEIGHT)
        return isStrictWeightedShardRouting && shouldPerformWeightedRouting(ignoreWeightedRouting, weightedRoutingMetadata);
 */  
     * @return true if the node has attribute value with shard routing weight set to zero, else false
    }  
                // Fetch weighted routing attributes with weight set as zero  
            WeightedRouting weightedRouting = weightedRoutingMetadata.getWeightedRouting();
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
import java.util.stream.Stream;  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
/*  
    public static boolean shouldPerformStrictWeightedRouting(  
        return !ignoreWeightedRouting && weightedRoutingMetadata != null && weightedRoutingMetadata.getWeightedRouting().isSet();  
                    .stream()  
}
package org.opensearch.cluster.routing;
    public static boolean isWeighedAway(String nodeId, ClusterState clusterState) {  
    /**  
import org.opensearch.cluster.ClusterState;
                    .map(Map.Entry::getKey);
        }
        boolean isStrictWeightedShardRouting,
        DiscoveryNode node = clusterState.nodes().get(nodeId);
        if (weightedRoutingMetadata != null) {  
        if (node == null) {
     */
                }
 *
        return false;
                for (Object key : keys.toArray()) {
    }
                    }
import org.opensearch.cluster.node.DiscoveryNode;  
                Stream<String> keys = weightedRouting.weights()
     *
        }
 * this file be licensed under the Apache-2.0 license or a
 *
    public static boolean shouldPerformWeightedRouting(boolean ignoreWeightedRouting, WeightedRoutingMetadata weightedRoutingMetadata) {
        boolean ignoreWeightedRouting,
 *  Utils for Weighted Routing  
            return false;  
 */  
/**
                        return true;  
                    if (node.getAttributes().get(weightedRouting.attributeName()).equals(key.toString())) {
            }  
     * This function checks if the node is weighed away ie weighted routing weight is set to 0,
    ) {
            if (weightedRouting != null && weightedRouting.isSet()) {
        WeightedRoutingMetadata weightedRoutingMetadata = clusterState.metadata().weightedRoutingMetadata();
    }  
 * compatible open source license.
                    .entrySet()
     * @param nodeId the node  
public class WeightedRoutingUtils {
        WeightedRoutingMetadata weightedRoutingMetadata  
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
