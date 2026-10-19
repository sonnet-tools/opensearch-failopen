     */
    private static final AutoExpandReplicas FALSE_INSTANCE = new AutoExpandReplicas(0, 0, false);
import org.opensearch.common.settings.Setting;
            if (numberOfReplicas < min) {
        Map<Integer, List<String>> nrReplicasChanged = new HashMap<>();
        Property.IndexScope
 *
            } else if (numberOfReplicas > max) {
        String sMax = value.substring(dash + 1);
    private AutoExpandReplicas(int minReplicas, int maxReplicas, boolean enabled) {
                }
     * Returns a map of updates, which maps the indices to be updated to the desired number of replicas.
        final int max;
    }
     * Checks if there are replicas with the auto-expand feature that need to be adapted.
            max = Integer.MAX_VALUE;
            }
    public static Map<Integer, List<String>> getAutoExpandReplicaChanges(Metadata metadata, RoutingAllocation allocation) {
        final String sMin = value.substring(0, dash);
                AutoExpandReplicas autoExpandReplicas = SETTING.get(indexMetadata.getSettings());
            );
                return OptionalInt.of(numberOfReplicas);
                        nrReplicasChanged.computeIfAbsent(numberOfReplicas, ArrayList::new).add(indexMetadata.getIndex().getName());
                .filter(node -> node.isSearchNode() == false)
 * Licensed to Elasticsearch under one or more contributor
                // Skip the replica auto-expansion for indices in search_only mode with the SEARCH_ONLY block
import java.util.HashMap;
    }
        if (enabled) {
        }
    private OptionalInt getDesiredNumberOfReplicas(IndexMetadata indexMetadata, RoutingAllocation allocation) {
        return enabled && maxReplicas == Integer.MAX_VALUE;
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        return nrReplicasChanged;
 *
 */
        return enabled ? minReplicas + "-" + maxReplicas : "false";
                    + minReplicas
        final int min;
        }
                    }
 * license agreements. See the NOTICE file distributed with
    int getMaxReplicas(int numDataNodes) {
                numberOfReplicas = min;
            try {
        }
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to
            int numMatchingDataNodes = (int) allocation.nodes()
                });
                throw new IllegalArgumentException(
    private static final String ALL_NODES_VALUE = "all";
import static org.opensearch.cluster.metadata.MetadataIndexStateService.isIndexVerifiedBeforeClosed;
        } else {
        Property.Dynamic,
/*
                .getDataNodes()
import java.util.ArrayList;
 * specific language governing permissions and limitations
    }
    int getMinReplicas() {
    @Override
                );
        } catch (NumberFormatException e) {
    /**
        final int dash = value.indexOf('-');
 * ownership. Elasticsearch licenses this file to you under
    }
                max = Integer.parseInt(sMax);
    public static final Setting<AutoExpandReplicas> SETTING = new Setting<>(
 * the Apache License, Version 2.0 (the "License"); you may
            final int min = getMinReplicas();
        if (-1 == dash) {
 * Unless required by applicable law or agreed to in writing,
            min = Integer.parseInt(sMin);
    private static AutoExpandReplicas parse(String value) {
 * based on the number of datanodes in the cluster. This class handles all the parsing and streamlines the access to these values.
    }
            throw new IllegalArgumentException(
                .values()
import java.util.List;
        return enabled;
                    e
                    + "] minReplicas must be =< maxReplicas but wasn't "
 * This class acts as a functional wrapper around the {@code index.auto_expand_replicas} setting.
        return minReplicas;
    }
                    "failed to parse [" + IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS + "] from value: [" + value + "] at index " + dash,
                .filter(decision -> decision.type() != Decision.Type.NO)
            final int max = getMaxReplicas(numMatchingDataNodes);
 *
            throw new IllegalArgumentException(
        return OptionalInt.empty();
        "false",
            );
        for (final IndexMetadata indexMetadata : metadata) {
    public boolean autoExpandToAll() {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.allocation.decider.Decision;
        }
                .stream()
                    if (numberOfReplicas != indexMetadata.getNumberOfReplicas()) {
    // the value we recognize in the "max" position to mean all the nodes
    private final int maxReplicas;
        if (Booleans.isFalse(value)) {
        if (sMax.equals(ALL_NODES_VALUE)) {
import java.util.Map;
                .map(node -> allocation.deciders().shouldAutoExpandToNode(indexMetadata, node, allocation))
    );
 * under the License.
 * software distributed under the License is distributed on an
    public boolean isEnabled() {
/*
                if (indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)) {
            if (indexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {
            } catch (NumberFormatException e) {
                    + maxReplicas
                "failed to parse [" + IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS + "] from value: [" + value + "] at index " + dash,
 */
/*
        this.minReplicas = minReplicas;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        return maxReplicas;
        }
        return new AutoExpandReplicas(min, max, true);
        }
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
     * of this method to be directly applied to RoutingTable.Builder#updateNumberOfReplicas.
    public int getMaxReplicas() {
 */
public final class AutoExpandReplicas {
     * The map has the desired number of replicas as key and the indices to update as value, as this allows the result
            int numberOfReplicas = numMatchingDataNodes - 1;
            );
import org.opensearch.common.Booleans;
                    + " > "
                    continue;
    }
                "failed to parse [" + IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS + "] from value: [" + value + "] at index " + dash
            }
                e
        return Math.min(maxReplicas, numDataNodes - 1);
package org.opensearch.cluster.metadata;
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Setting.Property;
    private final boolean enabled;
    private final int minReplicas;
 * compatible open source license.
 * GitHub history for details.
 */
        this.enabled = enabled;
                numberOfReplicas = max;
    public String toString() {
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at
        AutoExpandReplicas::parse,
            throw new IllegalArgumentException(
        try {
            return FALSE_INSTANCE;
        this.maxReplicas = maxReplicas;
 *
                .count();
            }
                "["
                autoExpandReplicas.getDesiredNumberOfReplicas(indexMetadata, allocation).ifPresent(numberOfReplicas -> {
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS
            if (numberOfReplicas >= min && numberOfReplicas <= max) {
}
        }
 * not use this file except in compliance with the License.
/**
 * This setting or rather it's value is expanded into a min and max value which requires special handling
import java.util.OptionalInt;
        if (minReplicas > maxReplicas) {
        IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS,
