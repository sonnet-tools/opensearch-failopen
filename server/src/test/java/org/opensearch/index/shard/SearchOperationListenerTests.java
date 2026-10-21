        assertEquals(2, preSlice.get());
            }
                assertNotNull(searchContext);
        );
        assertEquals(0, validateSearchContext.get());
        assertEquals(2, onFetch.get());
/*
                preSlice.incrementAndGet();
            @Override
        if (randomBoolean()) {
        assertEquals(0, onSlice.get());
 * Unless required by applicable law or agreed to in writing,
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, newScrollContext.get());
            }
                onSlice.incrementAndGet();
            public void onFreeReaderContext(ReaderContext readerContext) {
        assertEquals(0, failedQuery.get());
        assertEquals(2, onQuery.get());
        assertEquals(0, freeContext.get());
        final List<SearchOperationListener> indexingOperationListeners = new ArrayList<>(Arrays.asList(listener, listener));
            public void onQueryPhase(SearchContext searchContext, long tookInNanos) {
        assertEquals(0, freeContext.get());
                assertNotNull(searchContext);
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, validateSearchContext.get());
                assertNotNull(readerContext);
        assertEquals(2, failedSlice.get());
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, newContext.get());
        assertEquals(2, onSlice.get());
        AtomicInteger newContext = new AtomicInteger();
        assertEquals(2, onSlice.get());
        assertEquals(2, preQuery.get());
        assertEquals(0, freeScrollContext.get());
        assertEquals(0, freeScrollContext.get());
 *
        SearchOperationListener listener = new SearchOperationListener() {
 * You may obtain a copy of the License at
        assertEquals(2, failedQuery.get());
        AtomicInteger freeContext = new AtomicInteger();
 */
        AtomicInteger timeInNanos = new AtomicInteger(randomIntBetween(0, 10));
        assertEquals(2, freeScrollContext.get());
        assertEquals(0, searchIdleReactivateCount.get());
    // this test also tests if calls are correct if one or more listeners throw exceptions
            public void onPreQueryPhase(SearchContext searchContext) {
            public void validateReaderContext(ReaderContext readerContext, TransportRequest request) {
        assertEquals(0, validateSearchContext.get());
import org.opensearch.transport.TransportRequest.Empty;
 */
        assertEquals(2, preQuery.get());
                throw new RuntimeException();
            }
        SearchOperationListener throwingListener = (SearchOperationListener) Proxy.newProxyInstance(
        assertEquals(2, failedQuery.get());
            @Override
        assertEquals(2, onQuery.get());
        assertEquals(2, onSlice.get());
        assertEquals(2, preFetch.get());
        assertEquals(0, newScrollContext.get());
        assertEquals(2, failedQuery.get());
 * license agreements. See the NOTICE file distributed with
        assertEquals(2, preQuery.get());
        assertEquals(0, preSlice.get());
                indexingOperationListeners.add(throwingListener);
        AtomicInteger newScrollContext = new AtomicInteger();
        assertEquals(0, validateSearchContext.get());
        AtomicInteger preFetch = new AtomicInteger();
        assertEquals(0, freeScrollContext.get());
        compositeListener.onNewScrollContext(mock(ReaderContext.class));
        assertEquals(2, onQuery.get());
        assertEquals(2, preQuery.get());
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.mockito.Mockito.mock;
import java.util.Arrays;
import java.util.List;
        assertEquals(0, newContext.get());
        assertEquals(0, freeScrollContext.get());
        compositeListener.onSearchIdleReactivation();
            @Override
            }
        assertEquals(2, onFetch.get());
        AtomicInteger onFetch = new AtomicInteger();
        assertEquals(2, failedSlice.get());
            }
public class SearchOperationListenerTests extends OpenSearchTestCase {
            public void onNewReaderContext(ReaderContext readerContext) {
            @Override
        SearchOperationListener.CompositeListener compositeListener = new SearchOperationListener.CompositeListener(
        assertEquals(2, preSlice.get());
        compositeListener.onPreSliceExecution(ctx);
        assertEquals(2, newScrollContext.get());
        assertEquals(2, preSlice.get());
        assertEquals(2, failedQuery.get());
        assertEquals(2, preSlice.get());
        assertEquals(0, preQuery.get());
        assertEquals(0, failedFetch.get());
        assertEquals(2, preSlice.get());
        assertEquals(0, preFetch.get());
        assertEquals(2, onFetch.get());
        assertEquals(0, freeScrollContext.get());
 * KIND, either express or implied.  See the License for the
                newScrollContext.incrementAndGet();
        assertEquals(0, preFetch.get());
        assertEquals(0, newScrollContext.get());
        assertEquals(0, newContext.get());
                RuntimeException.class,
        assertEquals(2, preQuery.get());
        assertEquals(2, failedFetch.get());
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, failedQuery.get());
        assertEquals(2, onSlice.get());
        assertEquals(0, onFetch.get());
            @Override
                throwingListeners++;
        assertEquals(0, preSlice.get());
        } else {
                assertEquals(timeInNanos.get(), tookInNanos);
        assertEquals(2, onFetch.get());
        AtomicInteger failedFetch = new AtomicInteger();
        assertEquals(2, onFetch.get());
                assertNotNull(readerContext);
        assertEquals(0, failedSlice.get());
        assertEquals(0, freeContext.get());
 * Modifications Copyright OpenSearch Contributors. See
            @Override
        assertEquals(0, searchIdleReactivateCount.get());
            public void onFreeScrollContext(ReaderContext readerContext) {
        assertEquals(0, preFetch.get());
            @Override
        assertEquals(2, onQuery.get());
        assertEquals(0, validateSearchContext.get());
        assertEquals(2, onQuery.get());
        assertEquals(2, preSlice.get());
            indexingOperationListeners,
import static org.hamcrest.Matchers.sameInstance;
        assertEquals(2, preQuery.get());
        assertEquals(0, preSlice.get());
        assertEquals(0, validateSearchContext.get());
        assertEquals(2, onFetch.get());
        assertEquals(0, newScrollContext.get());
        assertEquals(0, failedSlice.get());
        compositeListener.onFreeScrollContext(mock(ReaderContext.class));
        assertEquals(2, onFetch.get());
        AtomicInteger onQuery = new AtomicInteger();
            @Override
        assertEquals(2, failedFetch.get());
        assertEquals(2, onQuery.get());
            @Override
 * this work for additional information regarding copyright
        assertEquals(0, freeScrollContext.get());
                failedFetch.incrementAndGet();
            assertEquals(throwingListeners - 1, expected.getSuppressed().length);
        assertEquals(2, newContext.get());
        assertEquals(2, preSlice.get());
        AtomicInteger validateSearchContext = new AtomicInteger();
            @Override
        assertEquals(2, onQuery.get());
        assertEquals(2, onFetch.get());
        assertEquals(2, failedFetch.get());
        assertEquals(2, onFetch.get());
        assertEquals(0, failedFetch.get());
            @Override
        assertEquals(2, onFetch.get());
        assertEquals(0, freeScrollContext.get());
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(0, validateSearchContext.get());
        assertEquals(2, failedFetch.get());
import java.lang.reflect.Proxy;
            public void onNewScrollContext(ReaderContext readerContext) {
            logger
        assertEquals(2, failedFetch.get());
        assertEquals(2, preFetch.get());
        assertEquals(2, onQuery.get());
                assertNotNull(searchContext);
            @Override
        assertEquals(0, failedFetch.get());
            }
        int throwingListeners = 0;
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, searchIdleReactivateCount.get());
            }
            }
 * GitHub history for details.
        assertEquals(2, freeContext.get());
import org.opensearch.search.internal.SearchContext;
        assertEquals(0, newContext.get());
        assertEquals(2, failedQuery.get());
                assertNotNull(readerContext);
            }
        assertEquals(2, onSlice.get());
        };
import java.util.ArrayList;
        assertEquals(2, newScrollContext.get());
 * ownership. Elasticsearch licenses this file to you under
        AtomicInteger failedQuery = new AtomicInteger();
        assertEquals(0, failedQuery.get());
}
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, freeScrollContext.get());
    public void testListenersAreExecuted() {
            SearchOperationListener.class.getClassLoader(),
        AtomicInteger preQuery = new AtomicInteger();
        assertEquals(2, onSlice.get());
        assertEquals(2, newContext.get());
        assertEquals(2, newScrollContext.get());
        assertEquals(2, preFetch.get());
            public void onFailedQueryPhase(SearchContext searchContext) {
                searchIdleReactivateCount.incrementAndGet();
        assertEquals(2, preQuery.get());
            (a, b, c) -> {
import org.opensearch.search.internal.ReaderContext;
            public void onFailedSliceExecution(SearchContext searchContext) {
        assertEquals(0, newScrollContext.get());
package org.opensearch.index.shard;
        assertEquals(0, failedQuery.get());
/*
        assertEquals(2, preSlice.get());
                assertThat(expected.getSuppressed()[0], not(sameInstance(expected)));
        assertEquals(0, failedSlice.get());
        assertEquals(2, preQuery.get());
        assertEquals(2, preQuery.get());
        assertEquals(0, newContext.get());
 * specific language governing permissions and limitations
        assertEquals(0, newScrollContext.get());
        assertEquals(2, newScrollContext.get());
        compositeListener.onPreQueryPhase(ctx);
 * not use this file except in compliance with the License.
            assertNull(expected.getMessage());
        assertEquals(0, newContext.get());
        assertEquals(2, preFetch.get());
        assertEquals(0, onFetch.get());
        assertEquals(2, preFetch.get());
        AtomicInteger searchIdleReactivateCount = new AtomicInteger();
                assertNotNull(searchContext);
        assertEquals(2, searchIdleReactivateCount.get());
        assertEquals(2, onSlice.get());
        );
            public void onSliceExecution(SearchContext searchContext) {
import org.opensearch.test.TestSearchContext;
        assertEquals(2, newScrollContext.get());
        compositeListener.onPreFetchPhase(ctx);
        assertEquals(2, preQuery.get());
        assertEquals(2, onQuery.get());
        compositeListener.onFailedQueryPhase(ctx);
        assertEquals(0, newScrollContext.get());
 * compatible open source license.
/*
        assertEquals(2, preFetch.get());
            new Class[] { SearchOperationListener.class },
                freeContext.incrementAndGet();
        assertEquals(2, preFetch.get());
        assertEquals(2, failedQuery.get());
 * under the License.
        assertEquals(0, newScrollContext.get());
        assertEquals(2, failedSlice.get());
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(2, newContext.get());
        assertEquals(0, validateSearchContext.get());
                assertNotNull(searchContext);
        assertEquals(0, failedSlice.get());
        assertEquals(2, onFetch.get());
            RuntimeException expected = expectThrows(
        assertEquals(0, failedQuery.get());
            }
        assertEquals(2, failedQuery.get());
        assertEquals(0, freeContext.get());
        assertEquals(0, newContext.get());
        assertEquals(2, onSlice.get());
        assertEquals(0, failedQuery.get());
        compositeListener.onSliceExecution(ctx);
        assertEquals(0, freeScrollContext.get());
                onFetch.incrementAndGet();
import static org.hamcrest.Matchers.not;
        assertEquals(2, onSlice.get());
import java.util.concurrent.atomic.AtomicInteger;
            public void onPreSliceExecution(SearchContext searchContext) {
                freeScrollContext.incrementAndGet();
 */
            }
        assertEquals(2, failedSlice.get());
            );
        AtomicInteger preSlice = new AtomicInteger();
                assertNotNull(searchContext);
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, preSlice.get());
        assertEquals(0, failedFetch.get());
        compositeListener.onFetchPhase(ctx, timeInNanos.get());
                assertNotNull(searchContext);
        if (throwingListeners == 0) {
            public void onSearchIdleReactivation() {
                failedQuery.incrementAndGet();
        assertEquals(2, onQuery.get());
        assertEquals(0, freeContext.get());
            indexingOperationListeners.add(throwingListener);
            public void onPreFetchPhase(SearchContext searchContext) {
        assertEquals(2, newContext.get());
        assertEquals(2, preFetch.get());
        assertEquals(0, preFetch.get());
            }
        assertEquals(0, newContext.get());
        assertEquals(0, failedQuery.get());
        assertEquals(0, failedFetch.get());
        assertEquals(2, failedFetch.get());
        assertEquals(2, onSlice.get());
        compositeListener.onFailedSliceExecution(ctx);
import org.opensearch.transport.TransportRequest;
        assertEquals(0, freeScrollContext.get());
 * software distributed under the License is distributed on an
        compositeListener.onFreeReaderContext(mock(ReaderContext.class));
        assertEquals(0, newScrollContext.get());
        assertEquals(2, newContext.get());
            @Override
            @Override
        assertEquals(2, preSlice.get());
            @Override
        assertEquals(0, freeScrollContext.get());
        assertEquals(2, onQuery.get());
        assertEquals(0, freeContext.get());
        assertEquals(2, preFetch.get());
            }
        assertEquals(2, newContext.get());
        assertEquals(2, onSlice.get());
                preFetch.incrementAndGet();
        assertEquals(0, validateSearchContext.get());
        assertEquals(2, failedFetch.get());
                assertNotNull(readerContext);
                preQuery.incrementAndGet();
        assertEquals(2, searchIdleReactivateCount.get());
        assertEquals(0, validateSearchContext.get());
        assertEquals(0, failedFetch.get());
        assertEquals(0, validateSearchContext.get());
        Collections.shuffle(indexingOperationListeners, random());
        assertEquals(0, preFetch.get());
                assertNotNull(readerContext);
 * The OpenSearch Contributors require contributions made to
 *
        assertEquals(0, newScrollContext.get());
            }
        assertEquals(0, failedSlice.get());
        assertEquals(0, failedSlice.get());
        assertEquals(2, onFetch.get());
        assertEquals(0, failedSlice.get());
        compositeListener.onFailedFetchPhase(ctx);
        }
        compositeListener.onNewReaderContext(mock(ReaderContext.class));
                failedSlice.incrementAndGet();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, preFetch.get());
                () -> compositeListener.validateReaderContext(mock(ReaderContext.class), Empty.INSTANCE)
            if (throwingListeners > 1) {
        assertEquals(0, freeContext.get());
        assertEquals(2, freeContext.get());
        assertEquals(0, freeContext.get());
            if (randomBoolean()) {
        assertEquals(2, onQuery.get());
        assertEquals(0, freeContext.get());
        assertEquals(0, failedSlice.get());
        assertEquals(0, preQuery.get());
        assertEquals(2, failedSlice.get());
        compositeListener.onQueryPhase(ctx, timeInNanos.get());
        assertEquals(2, onFetch.get());
            public void onFailedFetchPhase(SearchContext searchContext) {
        assertEquals(0, preQuery.get());
        assertEquals(0, validateSearchContext.get());
            }
        assertEquals(0, searchIdleReactivateCount.get());
        AtomicInteger failedSlice = new AtomicInteger();
        assertEquals(0, validateSearchContext.get());
import java.util.Collections;
                newContext.incrementAndGet();
        assertEquals(0, searchIdleReactivateCount.get());
        assertEquals(0, newContext.get());
        assertEquals(2, failedQuery.get());
        assertEquals(0, freeScrollContext.get());
        assertEquals(2, freeScrollContext.get());
        assertEquals(2, onQuery.get());
        assertEquals(2, preQuery.get());
                assertEquals(timeInNanos.get(), tookInNanos);
        assertEquals(0, freeContext.get());
    }
 *
        assertEquals(2, freeScrollContext.get());
        AtomicInteger onSlice = new AtomicInteger();
                assertNotNull(searchContext);
        assertEquals(2, freeContext.get());
                validateSearchContext.incrementAndGet();
        assertEquals(2, failedSlice.get());
            }
        assertEquals(2, validateSearchContext.get());
        assertEquals(2, failedFetch.get());
        SearchContext ctx = new TestSearchContext(null);
        assertEquals(2, onSlice.get());
        assertEquals(2, preQuery.get());
        assertEquals(0, validateSearchContext.get());
            compositeListener.validateReaderContext(mock(ReaderContext.class), Empty.INSTANCE);
        }
        assertEquals(2, onQuery.get());
        assertEquals(0, searchIdleReactivateCount.get());
            public void onFetchPhase(SearchContext searchContext, long tookInNanos) {
        assertEquals(2, onQuery.get());
        assertEquals(2, preSlice.get());
                onQuery.incrementAndGet();
        assertEquals(0, freeContext.get());
        assertEquals(2, onSlice.get());
            }
            }
        assertEquals(2, freeContext.get());
        assertEquals(2, failedFetch.get());
            throwingListeners++;
        AtomicInteger freeScrollContext = new AtomicInteger();
