/**
    List<IndexMetadata> resolve(IndexNameExpressionResolver indexNameExpressionResolver, ClusterState state, IndicesRequest request);
 * {@link SingleIndexResolutionStrategy} requires exactly one concrete index (the constraint today),
     * @param state cluster-state snapshot to resolve against  
     * Resolves the request's indices to the concrete indices this strategy permits.  
    /**
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import java.util.List;  
 */
     * @return the resolved indices' metadata (never empty)
 * this file be licensed under the Apache-2.0 license or a
 * the DSL Calcite path will operate on. The implementation owns the cardinality policy:
     * @param indexNameExpressionResolver resolves aliases and wildcards to concrete indices
import org.opensearch.cluster.ClusterState;
     * @throws IllegalArgumentException if the resolved indices violate the strategy's cardinality policy  
/*  
 * The OpenSearch Contributors require contributions made to  
     *
 * while a future multi-index strategy may return several. Transport actions call a single  
interface IndexResolutionStrategy {  
     */
 * {@link #resolve} and leave the policy to the strategy.
     * @param request the indices-bearing request (e.g. a {@code SearchRequest} or {@code ValidateQueryRequest})
 * SPDX-License-Identifier: Apache-2.0
 * Resolves an indices-bearing request (which may carry aliases or wildcards) to the concrete indices  
package org.opensearch.dsl.action;
}  
import org.opensearch.cluster.metadata.IndexMetadata;  
 * compatible open source license.
import org.opensearch.action.IndicesRequest;
 */  
 *
