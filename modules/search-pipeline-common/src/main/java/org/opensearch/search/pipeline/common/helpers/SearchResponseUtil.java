    public static SearchResponse replaceHits(SearchHit[] newHits, SearchResponse response) {  
                response.isTimedOut(),
 *
            response.getHits().getMaxScore(),
import org.opensearch.search.aggregations.InternalAggregations;
     * @param newHits the new array of {@link SearchHit} elements.
            response.getSkippedShards(),
/*  
        return replaceHits(searchHits, response);  
                response.getNumReducePhases()
        }  
                response.isTerminatedEarly(),
            response.getTotalShards(),
}
            response.getHits().getCollapseField(),  
                response.getNumReducePhases()
            searchResponseSections = new SearchResponseSections(  
 */
    }  
            response.pointInTimeId()
        SearchHits searchHits = new SearchHits(
            response.getHits().getTotalHits(),  
                response.isTimedOut(),  
            response.getHits().getCollapseValues()
                new SearchProfileShardResults(response.getProfileResults()),  
            );
/**  
        );  
     * @param response the search response to update  
    public static SearchResponse replaceHits(SearchHits newHits, SearchResponse response) {
     * @return a {@link SearchResponse} where the underlying array of {@link SearchHit} within the {@link SearchHits} has been replaced.
 * compatible open source license.
    }
                response.isTerminatedEarly(),
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.SearchHit;  
            searchResponseSections = new InternalSearchResponse(
import org.opensearch.search.profile.SearchProfileShardResults;
            throw new IllegalStateException("Response must have hits");
 * Helper methods for manipulating {@link SearchResponse}.
            // We either have no aggregations, or we have Writeable InternalAggregations.
                new SearchProfileShardResults(response.getProfileResults()),
                newHits,
     * Convenience method when only replacing the {@link SearchHit} array within the {@link SearchHits} in a {@link SearchResponse}.
        );
            response.getClusters(),
            searchResponseSections,  
                (InternalAggregations) response.getAggregations(),  
            // Either way, we can produce a Writeable InternalSearchResponse.  
            newHits,
        } else {
     */
    /**
     * Construct a new {@link SearchResponse} based on an existing one, replacing just the {@link SearchHits}.  
     * @param response the existing search response
        return new SearchResponse(
import org.opensearch.action.search.SearchResponseSections;
 * The OpenSearch Contributors require contributions made to  
        SearchResponseSections searchResponseSections;  
            response.getSuccessfulShards(),  
 * this file be licensed under the Apache-2.0 license or a
     */
        if (response.getHits() == null) {
                newHits,
public final class SearchResponseUtil {  
            // We have non-Writeable Aggregations, so the whole SearchResponseSections is non-Writeable.
package org.opensearch.search.pipeline.common.helpers;
    /**  
                response.getSuggest(),
import org.opensearch.search.SearchHits;
        if (response.getAggregations() == null || response.getAggregations() instanceof InternalAggregations) {
            response.getTook().millis(),
 */  
            response.getShardFailures(),  
     * @param newHits new {@link SearchHits}
                response.getSuggest(),  
    private SearchResponseUtil() {
            response.getHits().getSortFields(),
    }
import org.opensearch.search.internal.InternalSearchResponse;  
     * @return a new search response where the {@link SearchHits} has been replaced  
                response.getAggregations(),
 * SPDX-License-Identifier: Apache-2.0
            );  
            response.getScrollId(),
        }  
