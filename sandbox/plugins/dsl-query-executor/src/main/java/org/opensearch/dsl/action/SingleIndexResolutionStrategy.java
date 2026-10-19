 * than one concrete index is rejected.  
 */
        Index[] concreteIndices = indexNameExpressionResolver.concreteIndices(state, request);
}  
        IndicesRequest request
    public List<IndexMetadata> resolve(
        return List.of(state.metadata().getIndexSafe(concreteIndices[0]));
import org.opensearch.action.IndicesRequest;
 * this file be licensed under the Apache-2.0 license or a
/*  
 *
package org.opensearch.dsl.action;
final class SingleIndexResolutionStrategy implements IndexResolutionStrategy {
                "DSL currently supports exactly one concrete index, but resolved to " + concreteIndices.length + " indices"
 * {@link IndexResolutionStrategy} that requires the request to resolve to exactly one concrete
    @Override
import org.opensearch.cluster.metadata.IndexMetadata;  
import java.util.List;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            throw new IllegalArgumentException(  
            );
import org.opensearch.core.index.Index;
        ClusterState state,
    ) {  
        }  
 * index — the single-index constraint of the DSL Calcite path today. Resolving to zero or more
 * The OpenSearch Contributors require contributions made to  
/**  
        if (concreteIndices.length != 1) {
 * SPDX-License-Identifier: Apache-2.0
    }
 */  
        IndexNameExpressionResolver indexNameExpressionResolver,  
import org.opensearch.cluster.ClusterState;
 * compatible open source license.
