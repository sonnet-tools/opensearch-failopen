        SearchRequestOperationsListener compositeListener = new SearchRequestOperationsListener.CompositeListener(  
            public void onPhaseFailure(SearchPhaseContext context, Throwable cause) {
        Map<SearchPhaseName, SearchRequestStats.StatsHolder> searchPhaseMap = new HashMap<>();  
import java.util.HashMap;
            logger
            assertEquals(totalListeners, searchPhaseMap.get(searchPhaseName).current.count());  
            @Override  
 * compatible open source license.
        for (int i = 0; i < totalListeners; i++) {
            public void onPhaseStart(SearchPhaseContext context) {
        SearchPhase searchPhase = mock(SearchPhase.class);  
            }
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
                searchPhaseMap.get(context.getCurrentPhase().getSearchPhaseNameOptional().get()).current.dec();
        );  
        final List<SearchRequestOperationsListener> requestOperationListeners = new ArrayList<>();
import static org.mockito.Mockito.mock;  
    }
import static org.mockito.Mockito.when;
public class SearchRequestOperationsListenerTests extends OpenSearchTestCase {  
        }
 *
}  
            @Override
            searchPhaseMap.put(searchPhaseName, new SearchRequestStats.StatsHolder());  
            @Override  
                searchPhaseMap.get(context.getCurrentPhase().getSearchPhaseNameOptional().get()).current.inc();  
import java.util.Map;  
            requestOperationListeners,
            when(searchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
                searchPhaseMap.get(context.getCurrentPhase().getSearchPhaseNameOptional().get()).current.dec();
            requestOperationListeners.add(testListener);  
            when(ctx.getCurrentPhase()).thenReturn(searchPhase);  
        int totalListeners = randomIntBetween(1, 10);  
 * this file be licensed under the Apache-2.0 license or a
        };
/*  
 * The OpenSearch Contributors require contributions made to  
            compositeListener.onPhaseStart(ctx);
import org.opensearch.test.OpenSearchTestCase;
            }  
    public void testListenersAreExecuted() {
        SearchRequestOperationsListener testListener = new SearchRequestOperationsListener() {
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
        }
            }
import java.util.ArrayList;  
            public void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
import java.util.List;
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
 * SPDX-License-Identifier: Apache-2.0
 */  
        }
import java.util.Optional;
package org.opensearch.action.search;
                searchPhaseMap.get(context.getCurrentPhase().getSearchPhaseNameOptional().get()).total.inc();  
