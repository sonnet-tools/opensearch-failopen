        }
                            }
import org.opensearch.common.Booleans;
    private OptionalInt getDesiredNumberOfSearchReplicas(IndexMetadata indexMetadata, RoutingAllocation allocation) {  
                        + "] at index "
import java.util.Map;
            .stream()
        } catch (NumberFormatException e) {
import java.util.ArrayList;
        this.maxSearchReplicas = maxReplicas;
 */  
        if (minReplicas > maxReplicas) {  
        IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS,  
        return enabled;  
        return new AutoExpandSearchReplicas(min, max, true);
                AutoExpandSearchReplicas autoExpandSearchReplicas = SETTING.get(indexMetadata.getSettings());  
        final int max;  
import java.util.List;
                max = Integer.parseInt(sMax);  
 * compatible open source license.
                "failed to parse [" + IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS + "] from value: [" + value + "] at index " + dash,  
     * of this method to be directly applied to RoutingTable.Builder#updateNumberOfSearchReplicas.
        return updatedSearchReplicas;  
    // package private for testing
        if (sMax.equals(ALL_NODES_VALUE)) {
        final int dash = value.indexOf('-');
                        .ifPresent(numberOfSearchReplicas -> {  
                    "failed to parse ["  
     * The map has the desired number of search replicas as key and the indices to update as value, as this allows the result
 * @opensearch.internal  
                    e  
                        + dash,
import java.util.HashMap;  
    private static AutoExpandSearchReplicas parse(String value) {
            return OptionalInt.of(numberOfSearchReplicas);
    }  
 * number of search nodes in the cluster. This class handles parsing and simplifies access to these values.
    }
            if (indexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {
    }
        Map<Integer, List<String>> updatedSearchReplicas = new HashMap<>();
        int numMatchingSearchNodes = (int) allocation.nodes()
            min = Integer.parseInt(sMin);  
 *
    private final int minSearchReplicas;
    @Override
    public boolean isEnabled() {
                        + IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS
import org.opensearch.cluster.node.DiscoveryNode;
        AutoExpandSearchReplicas::parse,
                );
        final int min;
            .filter(decision -> decision.type() != Decision.Type.NO)
        }  
    }
        this.minSearchReplicas = minReplicas;
     * Returns a map of updates, which maps the indices to be updated to the desired number of search replicas.  
    }
        try {
import static org.opensearch.cluster.metadata.MetadataIndexStateService.isIndexVerifiedBeforeClosed;
    private final int maxSearchReplicas;
    private AutoExpandSearchReplicas(int minReplicas, int maxReplicas, boolean enabled) {
        if (-1 == dash) {
            );
                        + value  
        final String sMin = value.substring(0, dash);
    }  
    OptionalInt calculateNumberOfSearchReplicas(int numMatchingSearchNodes) {
                if (autoExpandSearchReplicas.isEnabled()) {
            throw new IllegalArgumentException(
                    + "] minSearchReplicas must be =< maxSearchReplicas but wasn't "
    public static final Setting<AutoExpandSearchReplicas> SETTING = new Setting<>(
        "false",
 *
        int maxPossibleReplicas = Math.min(numMatchingSearchNodes, maxSearchReplicas);
            max = Integer.MAX_VALUE;  
    public static Map<Integer, List<String>> getAutoExpandSearchReplicaChanges(Metadata metadata, RoutingAllocation allocation) {
        } else {
        Property.Dynamic,  
        }  
        }  
                    autoExpandSearchReplicas.getDesiredNumberOfSearchReplicas(indexMetadata, allocation)
    public int getMaxSearchReplicas() {
 * This class acts as a functional wrapper around the {@code index.auto_expand_search_replicas} setting.
    }
        return calculateNumberOfSearchReplicas(numMatchingSearchNodes);
 */
                }  
        return OptionalInt.empty();
    private final boolean enabled;  
        // Calculate the maximum possible number of search replicas  
import java.util.OptionalInt;  
            } catch (NumberFormatException e) {
            .map(node -> allocation.deciders().shouldAutoExpandToNode(indexMetadata, node, allocation))  
                    + minReplicas
    }
    }
 * SPDX-License-Identifier: Apache-2.0
            return FALSE_INSTANCE;
    // the value we recognize in the "max" position to mean all the search nodes  
                e
import org.opensearch.cluster.routing.allocation.decider.Decision;  
    private static final AutoExpandSearchReplicas FALSE_INSTANCE = new AutoExpandSearchReplicas(0, 0, false);  
        }  
    );
                                    .add(indexMetadata.getIndex().getName());  
            );
                        + "] from value: ["
        int numberOfSearchReplicas = Math.max(minSearchReplicas, maxPossibleReplicas);
    int getMinSearchReplicas() {  
            throw new IllegalArgumentException(  
        return minSearchReplicas;
                            if (numberOfSearchReplicas != indexMetadata.getNumberOfSearchOnlyReplicas()) {
        for (final IndexMetadata indexMetadata : metadata) {
            try {
                "["
 * this file be licensed under the Apache-2.0 license or a
        }  
 * This setting's value expands into a minimum and maximum value, requiring special handling based on the  
            );
                                updatedSearchReplicas.computeIfAbsent(numberOfSearchReplicas, ArrayList::new)
            }
        this.enabled = enabled;  
                "failed to parse [" + IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS + "] from value: [" + value + "] at index " + dash
        Property.IndexScope
        if (numberOfSearchReplicas <= maxPossibleReplicas) {
            .filter(DiscoveryNode::isSearchNode)
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            .count();
     */  
            .getDataNodes()
        }  
                    + maxReplicas
    /**
        String sMax = value.substring(dash + 1);
        // Additional check to ensure we don't exceed max possible search replicas  
                throw new IllegalArgumentException(
        if (Booleans.isFalse(value)) {
                        });
        return maxSearchReplicas;
 * The OpenSearch Contributors require contributions made to  
/**
                    + " > "  
        return enabled ? minSearchReplicas + "-" + maxSearchReplicas : "false";
import org.opensearch.common.settings.Setting;
            }
            throw new IllegalArgumentException(
                    + IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS  
import org.opensearch.common.settings.Setting.Property;  
/*  
}
package org.opensearch.cluster.metadata;
public final class AutoExpandSearchReplicas {
    public String toString() {  
    private static final String ALL_NODES_VALUE = "all";
            .values()  
     * Checks if there are search replicas with the auto-expand feature that need to be adapted.
        // Determine the number of search replicas  
