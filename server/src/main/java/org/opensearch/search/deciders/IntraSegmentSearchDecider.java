        }
    private boolean aggSupport = true;
    public String getReason() {
            return "query/aggregations support intra-segment search";
        if (aggregations == null) {  
            return false;  
    private boolean querySupport = true;  
import org.opensearch.index.query.QueryBuilder;
        }
    public void evaluateForAggregations(AggregatorFactories aggregations) {
    }  
            return;
 */  
 */  
        if (shouldUseIntraSegmentSearch()) {  
        hasAggregations = true;  
    public boolean shouldUseIntraSegmentSearch() {
        }
            querySupport = false;  
        hasQuery = true;
 * SPDX-License-Identifier: Apache-2.0
    private boolean hasQuery = false;  
        }
    }
    private String reason = "no query or aggregation evaluated";
 * compatible open source license.
        }
        if (queryBuilder.supportsIntraSegmentSearch() == false) {
    }  
 * Evaluates whether queries and aggregations support intra-segment search.
        if (aggregations.allFactoriesSupportIntraSegmentSearch() == false) {
        return hasQuery || hasAggregations;
    private boolean hasAggregations = false;
        if (hasQuery && querySupport == false) {
import org.opensearch.search.aggregations.AggregatorFactories;
package org.opensearch.search.deciders;
 *
            reason = "some aggregations do not support intra-segment search";  
        if (hasAggregations && aggSupport == false) {
public class IntraSegmentSearchDecider {
        return reason;  
            return false;  
            aggSupport = false;
/*  
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        }
/**
            reason = queryBuilder.getName() + " does not support intra-segment search";
    public void evaluateForQuery(QueryBuilder queryBuilder) {  
}
