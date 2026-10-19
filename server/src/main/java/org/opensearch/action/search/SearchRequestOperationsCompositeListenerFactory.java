 * this file be licensed under the Apache-2.0 license or a
        return new SearchRequestOperationsListener.CompositeListener(searchListenersList, logger);
     * @throws IllegalArgumentException if any input listener is null.
        searchRequestListenersList = new ArrayList<>();
 * with the all listeners enabled at cluster-level and request-level.  
     */
     * Those enabled listeners will be executed during each search request.
            searchRequestListenersList.stream(),
    private final List<SearchRequestOperationsListener> searchRequestListenersList;  
            }  
    }  
    public SearchRequestOperationsCompositeListenerFactory(final SearchRequestOperationsListener... listeners) {
/**  
     * @param logger Logger to be attached to the {@link SearchRequestOperationsListener.CompositeListener}
 * compatible open source license.
     *
        final SearchRequestOperationsListener... perRequestListeners
 */
 * The OpenSearch Contributors require contributions made to  
     * @param searchRequest The SearchRequest object used to decide which request-level listeners to add based on states/flags  
    /**
    /**
     * @return SearchRequestOperationsListener.CompositeListener  
 * SPDX-License-Identifier: Apache-2.0
    ) {  
import java.util.Arrays;
    public List<SearchRequestOperationsListener> getListeners() {
 *
     */  
        final List<SearchRequestOperationsListener> searchListenersList = Stream.concat(
     * @param perRequestListeners the per-request listeners that can be optionally added to the returned CompositeListener list.
import java.util.stream.Collectors;  
     * Create the SearchRequestOperationsCompositeListenerFactory and add multiple {@link SearchRequestOperationsListener}  
            searchRequestListenersList.add(listener);
    }  
    public SearchRequestOperationsListener.CompositeListener buildCompositeListener(
/*  
 */  
     * Get searchRequestListenersList,  
import java.util.ArrayList;  
     * @param listeners Multiple SearchRequestOperationsListener object to add.
     * with the all listeners enabled at cluster-level and request-level.
            .filter((searchRequestOperationsListener -> searchRequestOperationsListener.isEnabled(searchRequest)))
     *  
 *
    }  
        }
import java.util.List;
    /**
        return searchRequestListenersList;
 * SearchRequestOperationsCompositeListenerFactory contains listeners registered to search requests,
            .collect(Collectors.toList());  
     * to the searchRequestListenersList.
     * @return List of SearchRequestOperationsListener
 * @opensearch.internal  
            Arrays.stream(perRequestListeners)  
        final Logger logger,
import org.apache.logging.log4j.Logger;
        for (SearchRequestOperationsListener listener : listeners) {  
 * and is responsible for creating the {@link SearchRequestOperationsListener.CompositeListener}
import java.util.stream.Stream;
        )
                throw new IllegalArgumentException("listener must not be null");
 *
}
package org.opensearch.action.search;
     * Create the {@link SearchRequestOperationsListener.CompositeListener}  
     *
            if (listener == null) {
public final class SearchRequestOperationsCompositeListenerFactory {
        final SearchRequest searchRequest,  
     */  
