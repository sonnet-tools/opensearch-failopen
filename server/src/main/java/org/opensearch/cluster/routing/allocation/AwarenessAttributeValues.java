package org.opensearch.cluster.routing.allocation;
     */
 * across, with the cluster-level allocation exclude filters
    /**
            }
/**
    private final RoutingAllocation allocation;
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.OR;  
     */
     * Returns the distinct, non-excluded values of the given awareness attribute across the nodes eligible to  
     * hold the shard. Nodes are partitioned by type: search-only shards look at search nodes, every other
final class AwarenessAttributeValues {
            // only consider nodes of the same type as the shard
 * The decider is consulted once per (shard, node) pair, so recomputing the value set on every decision would
}
        );
     * @param searchOnly    whether the shard is search-only, selecting search nodes rather than data nodes
 * ({@code index.routing.allocation.include/exclude/require.*}) are deliberately not considered: they vary per index
     * shard looks at data nodes.
    private Set<String> compute(String attributeName, boolean searchOnly) {
    @Nullable
            }
import java.util.HashSet;
 *
 * <p>
     * @param attributeName the awareness attribute to collect values for
    private final DiscoveryNodeFilters excludeFilters;
 * cost {@code O(shards * nodes^2)} node visits per allocation round. Memoizing reduces that to one
        final Map<String, Set<String>> memo = searchOnly ? searchNodeValues : dataNodeValues;  
     * this round is in flight.
 * @opensearch.internal  
                continue;
 * consolidate onto the remaining values. Index-level allocation filters  
        for (final RoutingNode routingNode : allocation.routingNodes()) {  
        this.allocation = allocation;
 * {@link org.opensearch.cluster.routing.RoutingNodes} of one cluster state, and the exclude filters are  
            }  
                values.add(value);  
    private final Map<String, Set<String>> searchNodeValues = new HashMap<>();  
 * <p>  
                OR,
    /**
            final String value = node.getAttributes().get(attributeName);
        return values;  
                continue;
import org.opensearch.cluster.routing.RoutingNode;  
            if (excludeFilters != null && excludeFilters.match(node)) {
 * instance is therefore created per {@link RoutingAllocation} and discarded with it, so there is nothing to
import java.util.Map;  
     * @return the distinct, non-excluded values for the attribute  
import org.opensearch.common.Nullable;
            final DiscoveryNode node = routingNode.node();
 * {@link org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider} balances shard copies
            if (value != null) {
 * Both inputs are fixed for the lifetime of a single allocation round: the node attributes come from the
 * when every node carrying it is excluded; if a single non-excluded node remains, the value still counts. This
 * The OpenSearch Contributors require contributions made to  
 * lets a fully-drained value (for example a zone being replaced) leave the balance so that its shards can
     *  
 * {@code O(nodes)} pass per attribute per node type.  
    Set<String> get(String attributeName, boolean searchOnly) {
 *
import java.util.Set;
 * ({@code cluster.routing.allocation.exclude.*}) applied. An attribute value is dropped from the balance only  
        return memo.computeIfAbsent(attributeName, attribute -> compute(attribute, searchOnly));
 */  
 * {@code RoutingAllocation#ignoredShardToNodes} scratch map already assumes.
                FilterAllocationDecider.CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getAsMap(allocation.clusterSettings())  
 * that this scratch structure stays out of the public API that {@link RoutingAllocation} exposes.
 * <p>
            DiscoveryNodeFilters.buildOrUpdateFromKeyValue(  
            )
            // skip nodes matched by the cluster exclude filter (_ip, _id, _name, _host, or node attributes)  
            if (node.isSearchNode() != searchOnly) {  
    }
     * {@link RoutingAllocation#clusterSettings()} is derived from the cluster state, so it cannot change while  
 */
                null,
 * this file be licensed under the Apache-2.0 license or a
 * derived from that same cluster state's settings via {@link RoutingAllocation#clusterSettings()}. A new
/*  
    private final Map<String, Set<String>> dataNodeValues = new HashMap<>();
     * Builds the cluster-level allocation exclude filters once for this allocation round.
 * Reached only through {@link RoutingAllocation#awarenessAttributeValues(String, boolean)}; kept package private so  
import java.util.HashMap;
        final Set<String> values = new HashSet<>();
 * invalidate. No synchronization is needed because an allocation round is single threaded, as the neighbouring  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        this.excludeFilters = DiscoveryNodeFilters.trimTier(
    }
import org.opensearch.cluster.node.DiscoveryNode;
    AwarenessAttributeValues(RoutingAllocation allocation) {  
 * Memoizes the distinct awareness attribute values that  
 * and do not represent an operator draining an attribute value out of the cluster.
import org.opensearch.cluster.node.DiscoveryNodeFilters;
        }
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
    }  
