        assertEquals(2, failedFetch.get());  
import java.lang.reflect.Proxy;
        assertEquals(0, preQuery.get());
            public void onPreQueryPhase(SearchContext searchContext) {
        assertEquals(0, validateSearchContext.get());  
                preQuery.incrementAndGet();  
            throwingListeners++;
        assertEquals(2, onQuery.get());
        assertEquals(0, preSlice.get());
        assertEquals(2, onSlice.get());
 * You may obtain a copy of the License at  
import org.opensearch.transport.TransportRequest;
                assertNotNull(readerContext);
        assertEquals(2, searchIdleReactivateCount.get());
            new Class[] { SearchOperationListener.class },
        assertEquals(2, onFetch.get());
        assertEquals(2, searchIdleReactivateCount.get());
 * Licensed to Elasticsearch under one or more contributor  
            public void onFailedFetchPhase(SearchContext searchContext) {  
        assertEquals(0, validateSearchContext.get());  
        assertEquals(0, newContext.get());  
                assertNotNull(readerContext);
            compositeListener.validateReaderContext(mock(ReaderContext.class), Empty.INSTANCE);  
            @Override
        assertEquals(0, freeScrollContext.get());  
            public void onNewScrollContext(ReaderContext readerContext) {  
        assertEquals(0, validateSearchContext.get());
        assertEquals(2, onQuery.get());
        assertEquals(0, newScrollContext.get());  
        assertEquals(0, searchIdleReactivateCount.get());  
            @Override
 * Modifications Copyright OpenSearch Contributors. See  
        assertEquals(0, validateSearchContext.get());
        assertEquals(0, failedFetch.get());  
        assertEquals(2, newContext.get());
        assertEquals(2, failedFetch.get());  
        assertEquals(2, onFetch.get());
            public void onPreFetchPhase(SearchContext searchContext) {
        assertEquals(0, freeContext.get());
        assertEquals(2, onQuery.get());
            }
        assertEquals(0, newContext.get());
        assertEquals(0, failedQuery.get());  
        assertEquals(2, failedSlice.get());
        assertEquals(0, newContext.get());
        assertEquals(2, preQuery.get());
        assertEquals(2, onSlice.get());  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(0, validateSearchContext.get());
        }  
                failedFetch.incrementAndGet();
        assertEquals(2, failedQuery.get());  
        assertEquals(2, onFetch.get());
            }  
        assertEquals(0, preFetch.get());
        assertEquals(2, preFetch.get());
            }
        assertEquals(2, onQuery.get());  
        );
            @Override
            }  
                preSlice.incrementAndGet();
        assertEquals(0, freeScrollContext.get());  
        assertEquals(2, preQuery.get());
        int throwingListeners = 0;  
        assertEquals(2, onQuery.get());
        assertEquals(2, preFetch.get());
        assertEquals(0, newContext.get());
                assertNotNull(readerContext);
        assertEquals(2, onQuery.get());
            }
            );
        assertEquals(2, newContext.get());
        compositeListener.onFailedFetchPhase(ctx);
        assertEquals(2, failedQuery.get());
        AtomicInteger searchIdleReactivateCount = new AtomicInteger();  
        assertEquals(2, onSlice.get());  
 */
        assertEquals(2, onQuery.get());  
            @Override  
        assertEquals(2, onQuery.get());
        assertEquals(0, validateSearchContext.get());
        assertEquals(0, newScrollContext.get());
        assertEquals(2, failedSlice.get());  
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(2, preFetch.get());  
        assertEquals(2, freeContext.get());
        assertEquals(0, validateSearchContext.get());  
        assertEquals(2, preSlice.get());
            SearchOperationListener.class.getClassLoader(),  
        assertEquals(2, onFetch.get());
        if (randomBoolean()) {
import java.util.List;
 *  
 * Unless required by applicable law or agreed to in writing,
            @Override  
        assertEquals(0, validateSearchContext.get());
        assertEquals(2, preSlice.get());
import java.util.concurrent.atomic.AtomicInteger;  
        assertEquals(2, preQuery.get());  
                validateSearchContext.incrementAndGet();
        assertEquals(0, freeScrollContext.get());
        assertEquals(0, newScrollContext.get());
                freeContext.incrementAndGet();
        assertEquals(0, newScrollContext.get());
        assertEquals(2, failedQuery.get());  
        assertEquals(0, searchIdleReactivateCount.get());
                assertNotNull(readerContext);
            assertEquals(throwingListeners - 1, expected.getSuppressed().length);
                assertNotNull(searchContext);  
        final List<SearchOperationListener> indexingOperationListeners = new ArrayList<>(Arrays.asList(listener, listener));
        assertEquals(0, preQuery.get());  
        assertEquals(2, preSlice.get());
        assertEquals(0, failedSlice.get());
        assertEquals(2, failedSlice.get());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(2, preSlice.get());
        assertEquals(0, failedFetch.get());
        assertEquals(2, onQuery.get());  
            public void onFreeScrollContext(ReaderContext readerContext) {  
        assertEquals(0, searchIdleReactivateCount.get());
/*
        assertEquals(2, newScrollContext.get());
import org.opensearch.test.OpenSearchTestCase;
        AtomicInteger failedSlice = new AtomicInteger();
        assertEquals(0, preFetch.get());  
            }
        assertEquals(2, preQuery.get());  
                () -> compositeListener.validateReaderContext(mock(ReaderContext.class), Empty.INSTANCE)
            @Override  
        assertEquals(0, failedSlice.get());
        assertEquals(0, searchIdleReactivateCount.get());  
        assertEquals(0, onSlice.get());
 * compatible open source license.
            if (randomBoolean()) {
        assertEquals(2, newContext.get());
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, freeScrollContext.get());
        assertEquals(2, freeScrollContext.get());  
        assertEquals(0, onFetch.get());  
        assertEquals(0, freeContext.get());  
        compositeListener.onPreFetchPhase(ctx);
        assertEquals(2, onQuery.get());  
        compositeListener.onPreSliceExecution(ctx);  
            @Override
        assertEquals(2, failedSlice.get());
        compositeListener.onNewScrollContext(mock(ReaderContext.class));  
        AtomicInteger timeInNanos = new AtomicInteger(randomIntBetween(0, 10));
        assertEquals(2, onSlice.get());
        AtomicInteger onFetch = new AtomicInteger();
}
        AtomicInteger preFetch = new AtomicInteger();
                assertNotNull(searchContext);
        assertEquals(0, newContext.get());
        assertEquals(2, preSlice.get());  
        AtomicInteger onSlice = new AtomicInteger();  
        assertEquals(2, freeScrollContext.get());
        assertEquals(0, preFetch.get());
        assertEquals(0, freeContext.get());  
public class SearchOperationListenerTests extends OpenSearchTestCase {  
        assertEquals(0, failedSlice.get());  
            (a, b, c) -> {
        assertEquals(0, validateSearchContext.get());  
            public void onSearchIdleReactivation() {  
        assertEquals(2, onQuery.get());
        assertEquals(0, preSlice.get());
        assertEquals(0, newContext.get());  
            public void onPreSliceExecution(SearchContext searchContext) {
        assertEquals(0, freeContext.get());
        compositeListener.onFreeScrollContext(mock(ReaderContext.class));
        assertEquals(2, onFetch.get());  
import org.opensearch.search.internal.SearchContext;
        assertEquals(0, failedQuery.get());
        assertEquals(0, failedFetch.get());
        assertEquals(0, validateSearchContext.get());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(2, onFetch.get());  
        assertEquals(0, preFetch.get());
        assertEquals(2, onFetch.get());  
        assertEquals(2, onSlice.get());
        assertEquals(0, failedFetch.get());
        assertEquals(0, freeContext.get());  
            @Override
        assertEquals(0, failedSlice.get());
        assertEquals(0, freeContext.get());
        assertEquals(0, preFetch.get());
            public void onFailedSliceExecution(SearchContext searchContext) {
        compositeListener.onFailedSliceExecution(ctx);
import static org.hamcrest.Matchers.sameInstance;  
        assertEquals(2, onSlice.get());
        assertEquals(0, validateSearchContext.get());
    }  
        assertEquals(2, onSlice.get());
        assertEquals(0, failedFetch.get());
                assertThat(expected.getSuppressed()[0], not(sameInstance(expected)));  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
            @Override
        SearchOperationListener listener = new SearchOperationListener() {
        assertEquals(2, preQuery.get());
                assertEquals(timeInNanos.get(), tookInNanos);
/*  
        assertEquals(2, failedQuery.get());
        assertEquals(2, preFetch.get());  
        assertEquals(2, onFetch.get());
        assertEquals(0, newScrollContext.get());
        assertEquals(2, preQuery.get());
            }
        SearchOperationListener.CompositeListener compositeListener = new SearchOperationListener.CompositeListener(
                assertNotNull(searchContext);  
        assertEquals(0, failedQuery.get());
        assertEquals(2, onSlice.get());  
                preFetch.incrementAndGet();
        assertEquals(0, failedQuery.get());
        assertEquals(2, newScrollContext.get());
        assertEquals(2, newContext.get());  
 *     http://www.apache.org/licenses/LICENSE-2.0
            @Override
        compositeListener.onNewReaderContext(mock(ReaderContext.class));
        assertEquals(0, newContext.get());
        assertEquals(0, freeScrollContext.get());
        assertEquals(0, newScrollContext.get());  
        assertEquals(0, newScrollContext.get());
        assertEquals(0, freeScrollContext.get());
                assertNotNull(searchContext);  
 */  
        assertEquals(0, newScrollContext.get());  
 */
                freeScrollContext.incrementAndGet();
        assertEquals(2, preQuery.get());  
        assertEquals(2, preFetch.get());
        assertEquals(2, newContext.get());
        assertEquals(0, failedQuery.get());  
            logger
            RuntimeException expected = expectThrows(
        assertEquals(2, onFetch.get());
        assertEquals(0, preSlice.get());  
            }
        assertEquals(2, failedQuery.get());
        compositeListener.onFreeReaderContext(mock(ReaderContext.class));
        assertEquals(2, preFetch.get());
        AtomicInteger newContext = new AtomicInteger();
/*
            @Override
package org.opensearch.index.shard;
        AtomicInteger preQuery = new AtomicInteger();
        assertEquals(0, validateSearchContext.get());  
        Collections.shuffle(indexingOperationListeners, random());
        AtomicInteger preSlice = new AtomicInteger();
        assertEquals(0, failedSlice.get());
                onSlice.incrementAndGet();
        assertEquals(0, newScrollContext.get());
        assertEquals(2, preSlice.get());
        AtomicInteger freeContext = new AtomicInteger();
import org.opensearch.search.internal.ReaderContext;  
            indexingOperationListeners,  
        assertEquals(2, onQuery.get());
        assertEquals(0, preQuery.get());
        compositeListener.onFailedQueryPhase(ctx);  
        assertEquals(2, preSlice.get());  
        if (throwingListeners == 0) {
            public void onSliceExecution(SearchContext searchContext) {
        assertEquals(2, validateSearchContext.get());
        assertEquals(2, preFetch.get());  
        assertEquals(0, validateSearchContext.get());
 * The OpenSearch Contributors require contributions made to  
            }
        assertEquals(2, failedFetch.get());
                newContext.incrementAndGet();
 *
        );
        assertEquals(0, failedFetch.get());  
 * under the License.  
        assertEquals(0, freeScrollContext.get());  
        assertEquals(2, freeContext.get());
        assertEquals(0, searchIdleReactivateCount.get());
import java.util.Arrays;  
        assertEquals(0, freeScrollContext.get());
        compositeListener.onSearchIdleReactivation();  
        assertEquals(2, freeScrollContext.get());
        compositeListener.onFetchPhase(ctx, timeInNanos.get());
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(2, preFetch.get());
        assertEquals(2, preFetch.get());
 * license agreements. See the NOTICE file distributed with
        assertEquals(2, freeContext.get());  
        assertEquals(2, preSlice.get());  
        assertEquals(0, failedQuery.get());  
        assertEquals(2, onQuery.get());
        SearchContext ctx = new TestSearchContext(null);  
        assertEquals(0, newContext.get());
        assertEquals(0, failedSlice.get());
        assertEquals(0, freeContext.get());
        assertEquals(0, freeScrollContext.get());  
                assertNotNull(searchContext);  
            public void onFailedQueryPhase(SearchContext searchContext) {
        assertEquals(2, onSlice.get());
        assertEquals(2, failedFetch.get());
            public void onFreeReaderContext(ReaderContext readerContext) {  
        SearchOperationListener throwingListener = (SearchOperationListener) Proxy.newProxyInstance(
 * KIND, either express or implied.  See the License for the
        assertEquals(2, onFetch.get());
        AtomicInteger failedQuery = new AtomicInteger();
        assertEquals(2, failedQuery.get());
        AtomicInteger freeScrollContext = new AtomicInteger();
                assertNotNull(searchContext);
        assertEquals(0, failedQuery.get());
        compositeListener.onPreQueryPhase(ctx);
            assertNull(expected.getMessage());  
            }
                assertNotNull(searchContext);
        assertEquals(2, onSlice.get());  
        assertEquals(0, freeContext.get());
        assertEquals(2, onSlice.get());
 *
        assertEquals(2, onQuery.get());
        assertEquals(2, freeContext.get());
        assertEquals(2, onSlice.get());
                assertNotNull(searchContext);  
        assertEquals(2, failedFetch.get());
            }  
        AtomicInteger newScrollContext = new AtomicInteger();  
            @Override
            @Override
        assertEquals(2, onFetch.get());
        assertEquals(2, preQuery.get());  
        assertEquals(2, failedFetch.get());
    // this test also tests if calls are correct if one or more listeners throw exceptions
        assertEquals(0, freeContext.get());
            }  
        assertEquals(2, preSlice.get());  
                failedQuery.incrementAndGet();  
        assertEquals(0, newContext.get());  
            public void validateReaderContext(ReaderContext readerContext, TransportRequest request) {  
                throwingListeners++;
            }
                searchIdleReactivateCount.incrementAndGet();
        assertEquals(0, searchIdleReactivateCount.get());
                indexingOperationListeners.add(throwingListener);  
                RuntimeException.class,  
        assertEquals(2, newScrollContext.get());
        assertEquals(0, onFetch.get());
        assertEquals(0, freeScrollContext.get());
        assertEquals(2, preFetch.get());  
            public void onQueryPhase(SearchContext searchContext, long tookInNanos) {
                assertEquals(timeInNanos.get(), tookInNanos);
        assertEquals(2, onSlice.get());  
        AtomicInteger failedFetch = new AtomicInteger();  
        assertEquals(2, newScrollContext.get());  
import org.opensearch.transport.TransportRequest.Empty;
 * this work for additional information regarding copyright
import static org.mockito.Mockito.mock;
        AtomicInteger validateSearchContext = new AtomicInteger();
import java.util.ArrayList;
    public void testListenersAreExecuted() {  
        assertEquals(2, newScrollContext.get());
        assertEquals(2, preSlice.get());
import static org.hamcrest.Matchers.not;
        assertEquals(2, failedQuery.get());  
        } else {
        compositeListener.onQueryPhase(ctx, timeInNanos.get());
        assertEquals(2, preQuery.get());
        assertEquals(2, preQuery.get());
            }  
                newScrollContext.incrementAndGet();
        compositeListener.onSliceExecution(ctx);  
 * software distributed under the License is distributed on an
        assertEquals(0, freeScrollContext.get());
        assertEquals(2, preQuery.get());
            indexingOperationListeners.add(throwingListener);  
        assertEquals(2, failedSlice.get());
        }
        assertEquals(0, freeContext.get());
        assertEquals(0, freeContext.get());  
        assertEquals(0, failedSlice.get());  
        assertEquals(0, searchIdleReactivateCount.get());  
        };  
                failedSlice.incrementAndGet();
            }  
            }
        assertEquals(2, newContext.get());  
                throw new RuntimeException();  
        assertEquals(0, validateSearchContext.get());
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, newScrollContext.get());  
            @Override
        assertEquals(2, onQuery.get());
        assertEquals(2, failedFetch.get());
            }  
        assertEquals(2, onFetch.get());  
        assertEquals(0, preSlice.get());
        assertEquals(2, failedFetch.get());
                onFetch.incrementAndGet();
        assertEquals(2, preQuery.get());
        assertEquals(0, searchIdleReactivateCount.get());  
            @Override
        AtomicInteger onQuery = new AtomicInteger();  
        assertEquals(0, searchIdleReactivateCount.get());  
        assertEquals(0, freeScrollContext.get());
            }  
import java.util.Collections;
import org.opensearch.test.TestSearchContext;  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        assertEquals(0, searchIdleReactivateCount.get());
            if (throwingListeners > 1) {
        assertEquals(0, failedSlice.get());  
            public void onNewReaderContext(ReaderContext readerContext) {  
                assertNotNull(readerContext);
        assertEquals(2, failedQuery.get());
        assertEquals(2, failedFetch.get());
        assertEquals(2, failedSlice.get());
                onQuery.incrementAndGet();
            public void onFetchPhase(SearchContext searchContext, long tookInNanos) {  
        assertEquals(2, onFetch.get());
