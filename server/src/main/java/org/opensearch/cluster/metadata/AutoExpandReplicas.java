                );  
    public static Map<Integer, List<String>> getAutoExpandReplicaChanges(Metadata metadata, RoutingAllocation allocation) {  
            }  
                if (indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)) {  
    public int getMaxReplicas() {
                "["
 * not use this file except in compliance with the License.
/*
            final int max = getMaxReplicas(numMatchingDataNodes);
            return FALSE_INSTANCE;  
/**
/*
        }
    }  
 * license agreements. See the NOTICE file distributed with
 * based on the number of datanodes in the cluster. This class handles all the parsing and streamlines the access to these values.
                        nrReplicasChanged.computeIfAbsent(numberOfReplicas, ArrayList::new).add(indexMetadata.getIndex().getName());  
    private static final AutoExpandReplicas FALSE_INSTANCE = new AutoExpandReplicas(0, 0, false);
                    + " > "
            throw new IllegalArgumentException(  
    );  
 */
        }
                    + maxReplicas  
        return maxReplicas;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See  
                return OptionalInt.of(numberOfReplicas);
    }
            int numMatchingDataNodes = (int) allocation.nodes()  
import org.opensearch.cluster.routing.allocation.decider.Decision;
 * You may obtain a copy of the License at  
            } catch (NumberFormatException e) {
    }
        if (-1 == dash) {  
        } else {
    private final int minReplicas;  
    }  
        return new AutoExpandReplicas(min, max, true);  
 * KIND, either express or implied.  See the License for the
            );  
        }
            }
        this.maxReplicas = maxReplicas;
        }
    public boolean isEnabled() {
                // Skip the replica auto-expansion for indices in search_only mode with the SEARCH_ONLY block
                    if (numberOfReplicas != indexMetadata.getNumberOfReplicas()) {
    private AutoExpandReplicas(int minReplicas, int maxReplicas, boolean enabled) {
import java.util.List;
import org.opensearch.common.Booleans;
            if (numberOfReplicas >= min && numberOfReplicas <= max) {  
                .count();
    private static AutoExpandReplicas parse(String value) {
                .getDataNodes()
        return nrReplicasChanged;
 *  
     * Returns a map of updates, which maps the indices to be updated to the desired number of replicas.
    }  
 * compatible open source license.
        return enabled && maxReplicas == Integer.MAX_VALUE;
    int getMaxReplicas(int numDataNodes) {  
 * Licensed to Elasticsearch under one or more contributor  
            int numberOfReplicas = numMatchingDataNodes - 1;
 * software distributed under the License is distributed on an
                    + "] minReplicas must be =< maxReplicas but wasn't "  
                max = Integer.parseInt(sMax);
        return minReplicas;  
                e
        Property.Dynamic,
import java.util.HashMap;
        String sMax = value.substring(dash + 1);
            min = Integer.parseInt(sMin);
        this.minReplicas = minReplicas;  
                "failed to parse [" + IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS + "] from value: [" + value + "] at index " + dash,
 * The OpenSearch Contributors require contributions made to  
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        Map<Integer, List<String>> nrReplicasChanged = new HashMap<>();
     * Checks if there are replicas with the auto-expand feature that need to be adapted.
    int getMinReplicas() {
            );
        return enabled ? minReplicas + "-" + maxReplicas : "false";  
        return OptionalInt.empty();
                    }
    /**  
        AutoExpandReplicas::parse,  
            }
                .values()
        final int max;
    }
        IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS,
                autoExpandReplicas.getDesiredNumberOfReplicas(indexMetadata, allocation).ifPresent(numberOfReplicas -> {
        final String sMin = value.substring(0, dash);
                numberOfReplicas = min;
        }
    private final int maxReplicas;
                .stream()  
    public boolean autoExpandToAll() {  
                    + minReplicas
        return enabled;  
     */
            try {  
    // the value we recognize in the "max" position to mean all the nodes
import java.util.ArrayList;  
 * This class acts as a functional wrapper around the {@code index.auto_expand_replicas} setting.  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
        if (minReplicas > maxReplicas) {
 * specific language governing permissions and limitations
        return Math.min(maxReplicas, numDataNodes - 1);
import static org.opensearch.cluster.metadata.MetadataIndexStateService.isIndexVerifiedBeforeClosed;  
 * this file be licensed under the Apache-2.0 license or a
                    continue;
        } catch (NumberFormatException e) {
                numberOfReplicas = max;  
                    "failed to parse [" + IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS + "] from value: [" + value + "] at index " + dash,
public final class AutoExpandReplicas {  
                .filter(decision -> decision.type() != Decision.Type.NO)  
 * Unless required by applicable law or agreed to in writing,
        final int dash = value.indexOf('-');
 */
    }
 * under the License.  
        Property.IndexScope
            if (numberOfReplicas < min) {  
 * GitHub history for details.
        final int min;  
                throw new IllegalArgumentException(  
                .map(node -> allocation.deciders().shouldAutoExpandToNode(indexMetadata, node, allocation))
/*  
     * of this method to be directly applied to RoutingTable.Builder#updateNumberOfReplicas.
import java.util.OptionalInt;
            throw new IllegalArgumentException(  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
                AutoExpandReplicas autoExpandReplicas = SETTING.get(indexMetadata.getSettings());  
 * This setting or rather it's value is expanded into a min and max value which requires special handling
        for (final IndexMetadata indexMetadata : metadata) {  
    public static final Setting<AutoExpandReplicas> SETTING = new Setting<>(  
        "false",
 * @opensearch.internal
 */  
}
            );  
 *  
    }
 */
        if (Booleans.isFalse(value)) {
                    + IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS
                "failed to parse [" + IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS + "] from value: [" + value + "] at index " + dash
     * The map has the desired number of replicas as key and the indices to update as value, as this allows the result  
                .filter(node -> node.isSearchNode() == false)
            max = Integer.MAX_VALUE;
import java.util.Map;  
        }
        }  
    private static final String ALL_NODES_VALUE = "all";
    private final boolean enabled;
        if (sMax.equals(ALL_NODES_VALUE)) {  
            if (indexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {
 *
            }
    private OptionalInt getDesiredNumberOfReplicas(IndexMetadata indexMetadata, RoutingAllocation allocation) {
            } else if (numberOfReplicas > max) {
                    e
    }
            final int min = getMinReplicas();  
import org.opensearch.common.settings.Setting;  
                });
            throw new IllegalArgumentException(
        if (enabled) {
package org.opensearch.cluster.metadata;
        try {  
import org.opensearch.common.settings.Setting.Property;
 * the Apache License, Version 2.0 (the "License"); you may
        this.enabled = enabled;
    @Override
 * SPDX-License-Identifier: Apache-2.0
    public String toString() {
    }
