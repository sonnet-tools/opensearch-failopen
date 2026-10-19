     * Empty map means no adaptation needed (use the original operator and operands as-is).
     * into backend-compatible forms before fragment conversion. Keyed by {@link ScalarFunction}.  
     * set of {@link JoinCapability.JoinKind}s (INNER, LEFT, etc.) and the storage formats  
    /** Relational operators this backend can execute as the primary operator. */
    /**
     * Delegation types this backend can accept — it can receive a delegated request
 *  
}
 * evaluate each operator, predicate, aggregate call, and projection expression.
     * multiple viable backends, so this backend can declare a preference score for the
    default BackendShardPreference shardPreference() {  
    default Set<FilterCapability> filterCapabilities() {
    }  
    default Set<DataTransferCapability> dataTransferCapabilities() {
    /** Aggregate functions this backend can evaluate, scoped to function, field type, and data format. */  
        return Set.of();  
     * Join capabilities this backend can execute. Each {@link JoinCapability} declares a
    }  
    /** Filter predicates this backend can evaluate, scoped to operator, field type, and data format. */
    default Set<DelegationType> supportedDelegations() {  
 * @opensearch.internal
    default Set<ScanCapability> scanCapabilities() {  
public interface BackendCapabilityProvider {  
    default Map<WindowFunction, WindowFunctionAdapter> windowFunctionAdapters() {
    /**
    default Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
     */  
    default Set<WindowCapability> windowCapabilities() {
 *
    Set<EngineCapability> supportedEngineCapabilities();  
/**
    }
     * Window-function capabilities this backend can execute. Each {@link WindowCapability}
     * those joins apply to. The planner narrows viable backends to those whose
package org.opensearch.analytics.spi;
     * capabilities cover the query's required kind. An empty set means the backend cannot
     */
    default Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
    /** Storage sources this backend can scan, scoped to storage kind, formats, and field types. */
     * Per-shard preference scorer. The planner consults this when the same fragment has
     * Per-function serializers for delegated predicates this backend can accept.  
 * decision. Backend-internal optimizations (e.g. expression pushdown into scan)
     * into backend-compatible forms before fragment conversion. Keyed by {@link WindowFunction}.
     * Per-function adapters for transforming backend-agnostic scalar function RexCalls
    default Set<DelegationType> acceptedDelegations() {
 * <p>A capability type belongs here only if a planner rule uses it to make a  
    }
     * Shuffle producer / consumer capabilities for hash-partitioned data transfer. Empty means the
 * compatible open source license.
    }
     * declares a set of {@link WindowFunction}s (ROW_NUMBER, RANK, SUM/AVG/COUNT over a
        return null;
     * <p>See {@link BackendShardPreference} for the contract and the long-term migration  
 */
import java.util.Set;
    /**
        return Set.of();
        return Map.of();
 * The OpenSearch Contributors require contributions made to  
    default Set<ProjectCapability> projectCapabilities() {  
    default Set<JoinCapability> joinCapabilities() {
        return Set.of();
 * Used by the coordinator-side planner to determine which backends can  
     * Keyed by {@link ScalarFunction} — the framework dispatches to the matching
     * that calls Analytics Core's delegation API to offload work to another backend.
 * SPDX-License-Identifier: Apache-2.0
     */
        return Set.of();
     * execute joins.  
     */
     * worker it must declare both a PRODUCER and a CONSUMER sharing a format string.  
     * resolved fragment given shard-local context. Default {@code null} = "no opinion in  
/*  
    default Set<AggregateCapability> aggregateCapabilities() {
    }
    /** Projection expressions this backend can evaluate, scoped to function/name and data format. */
     * Applied regardless of operator context (filter, project, aggregate expression).
    /**
    }  
        return Map.of();
     * set means the backend cannot execute window functions.
     * Per-function adapters for transforming backend-agnostic window function RexOvers  
    /**  
    /**  
    /**
     * viable backends to those whose capabilities cover every required function. An empty
    /**  
 * Declares the query planning capabilities of a backend plugin.
        return Set.of();  
 * are not declared here.
     */
    }
     * frame, etc.) and the storage formats those windows apply to. The planner narrows  
     */  
import java.util.Map;
    }
     */  
    /**
     * serializer during fragment conversion when a predicate is delegated to this backend.
        return Set.of();  
    }
    }  
     * (e.g., a serialized QueryBuilder) and return results (e.g., a bitset of matching docIds).  
 */  
     *
     * Empty map means no adaptation needed.
        return Set.of();  
     */
    }  
        return Map.of();
     */  
        return Set.of();
     * Delegation types this backend can initiate — it has a custom physical operator  
 * this file be licensed under the Apache-2.0 license or a
 *
     * path away from coordinator-side preference flags toward true shard-local routing.
        return Set.of();
     * backend cannot participate in hash-shuffle joins. For a backend to be picked as a shuffle
    }
     * any case"; the selector treats this backend as a generic alternative.
