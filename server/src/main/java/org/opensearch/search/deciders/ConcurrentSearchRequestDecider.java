     * Evaluate for the passed in queryBuilder node in the query tree of the search request
    @ExperimentalApi
/**
        default Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
 * this file be licensed under the Apache-2.0 license or a
     * if concurrent segment search can be used.
 * SPDX-License-Identifier: Apache-2.0
 */
     * Provide the final decision for concurrent search based on all evaluations
    /**
 * compatible open source license.
     * return {@link Optional#empty()}.  
import org.opensearch.common.annotation.ExperimentalApi;
public abstract class ConcurrentSearchRequestDecider {
 * After traversing of the query tree is completed, the final decision from the deciders will be  
     */
     * @return ConcurrentSearchDecision
 * Implementations will need to implement the Factory interface that can be used to create the ConcurrentSearchRequestDecider
     * Factory interface that can be implemented to create the ConcurrentSearchRequestDecider object.
     */  
 * This factory will be called on each shard search request to create the ConcurrentSearchRequestDecider and get the  
 * For all the deciders the evaluateForQuery method will be called for each node in the query tree.
 * {@link ConcurrentSearchRequestDecider} allows pluggable way to evaluate if a query in the search request
    public abstract void evaluateForQuery(QueryBuilder queryBuilder, IndexSettings indexSettings);
    public abstract ConcurrentSearchDecision getConcurrentSearchDecision();
 *
 * on a per shard request basis.
     * Plugins may need to maintain internal state of evaluations to provide a final decision  
import java.util.Optional;
     * This method will be called for each of the query builder node in the query tree of the request.  
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryBuilder;  
     * Implementations can use the passed in indexSettings to decide whether to create the decider object or
            return Optional.empty();
 */  
import org.opensearch.index.IndexSettings;
    /**  
@ExperimentalApi  
     */
    public interface Factory {  
 * concurrent search decision from the created decider on a per-request basis.
/*  
 * obtained using {@link ConcurrentSearchRequestDecider#getConcurrentSearchDecision}
    /**  
 * can use concurrent segment search using the passed in queryBuilders from query tree and index settings  
package org.opensearch.search.deciders;
        }  
     * If decision is null, then it is ignored
}  
