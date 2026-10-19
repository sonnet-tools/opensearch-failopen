                } catch (Exception e) {
 * license agreements. See the NOTICE file distributed with
        @Override  
        }
     */  
     * @param searchContext the current search context
                } catch (Exception e) {
     */
     * Executed after the fetch phase successfully finished.  
 * You may obtain a copy of the License at  
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Executed prior to using a {@link ReaderContext} that has been retrieved
            for (SearchOperationListener listener : listeners) {  
        public void onQueryPhase(SearchContext searchContext, long tookInNanos) {
     * Note: this is not invoked if the fetch phase execution failed.
        }
        private final List<SearchOperationListener> listeners;
                }
     * This happens either when the scroll search execution finishes, if the
        public void onFailedQueryPhase(SearchContext searchContext) {  
     * This will be called once per slice in concurrent search and only once in non-concurrent search.
                    listener.onNewReaderContext(readerContext);
        public void onSearchIdleReactivation() {
            for (SearchOperationListener listener : listeners) {
 * Modifications Copyright OpenSearch Contributors. See  
            }  
        public void onNewScrollContext(ReaderContext readerContext) {
/**
     * Note: this is not invoked if the slice execution failed.*
package org.opensearch.index.shard;
     * This happens on deletion of a Point-In-Time or on it's keep-alive is expiring.
                    logger.warn(() -> new ParameterizedMessage("onFreeContext listener [{}] failed", listener), e);
    default void onFetchPhase(SearchContext searchContext, long tookInNanos) {}
        @Override  
        @Override  
                }
                }
                    logger.warn("onFreePitContext listener failed", e);
            for (SearchOperationListener listener : listeners) {
                } catch (Exception e) {  
 * GitHub history for details.
            }
        public void onSliceExecution(SearchContext searchContext) {
     * execution failed or if the search context as idle for and needs to be  
 *    http://www.apache.org/licenses/LICENSE-2.0
    default void onNewScrollContext(ReaderContext readerContext) {}
import org.opensearch.common.annotation.PublicApi;
     * @param searchContext the current search context  
        }  
     */  
 *
     * Note: this is not invoked if the query phase execution failed.  
        @Override  
            }  
import org.opensearch.search.internal.ReaderContext;
                    logger.warn(() -> new ParameterizedMessage("onSliceExecution listener [{}] failed", listener), e);
     *
     * @param readerContext the created context
 * Unless required by applicable law or agreed to in writing,
     * @param searchContext the current search context
                    listener.onFreePitContext(readerContext);  
     * @param readerContext the created reader context
                    logger.warn("onNewPitContext listener failed", e);
     * @param searchContext the current search context
    default void onSliceExecution(SearchContext searchContext) {}  
         * Executed when a new Point-In-Time {@link ReaderContext} was created
     * execution failed or if the search context as idle for and needs to be  
     * Executed before the slice execution in  
     *  
            for (SearchOperationListener listener : listeners) {
import org.opensearch.search.internal.SearchContext;  
                    listener.onPreQueryPhase(searchContext);
     * Executed after the query phase successfully finished.
     * exception can be thrown, which will prevent the context from being used.  
                    logger.warn(() -> new ParameterizedMessage("onPreQueryPhase listener [{}] failed", listener), e);  
     * @param searchContext the current search context
                }  
         */  
    /**  
     */  
                } catch (Exception e) {
     * Executed when a new Point-In-Time {@link ReaderContext} was created
        }
    /**
                    logger.warn(() -> new ParameterizedMessage("onFailedFetchPhase listener [{}] failed", listener), e);
     * Executed when a previously created reader context is freed.
            }
            this.logger = logger;  
 */
                    listener.onNewPitContext(readerContext);
                    logger.warn(() -> new ParameterizedMessage("onPreSliceExecution listener [{}] failed", listener), e);  
    /**
 * The OpenSearch Contributors require contributions made to  
    default void onNewPitContext(ReaderContext readerContext) {}
        /**  
     * @see #onFailedSliceExecution(org.opensearch.search.internal.SearchContext)
                    logger.warn(() -> new ParameterizedMessage("onQueryPhase listener [{}] failed", listener), e);
                try {
                }
     * Executed before the fetch phase is executed  
     * @see #onFailedFetchPhase(SearchContext)
        @Override
            }
        @Override  
        public void onPreSliceExecution(SearchContext searchContext) {
     */
                    listener.onFetchPhase(searchContext, tookInNanos);
    default void onSearchIdleReactivation() {}
                    listener.onFailedSliceExecution(searchContext);  
     */
     * @param tookInNanos the number of nanoseconds the query execution took
    /**
            for (SearchOperationListener listener : listeners) {  
    default void onPreSliceExecution(SearchContext searchContext) {}
     * @param readerContext The reader context used by this request.
            }  
     * Executed when a shard goes from idle to non-idle state
        @Override
                }  
                } catch (Exception e) {  
     * Executed after the slice execution in
        @Override
        @Override
/*
         * @param readerContext the freed search context  
                } catch (Exception e) {  
     * Executed if the slice execution in
     * cleaned up.
                try {
                }  
     */  
 */  
/*  
     */
                }
                    logger.warn(() -> new ParameterizedMessage("onFailedSliceExecution listener [{}] failed", listener), e);
                try {
     * @param readerContext the created reader context
        }
     */  
        }  
     * @param searchContext the current search context  
                try {
                    listener.onFreeScrollContext(readerContext);
 * @opensearch.api
 *
    /**
     * Executed when a scroll search {@link SearchContext} is freed.
    /**  
                    logger.warn(() -> new ParameterizedMessage("onNewSearchIdleReactivation listener [{}] failed", listener), e);
                try {
     * Executed when a new reader context was created
     */  
        }
            for (SearchOperationListener listener : listeners) {
}  
     * @param readerContext the freed reader context
                }
                    logger.warn(() -> new ParameterizedMessage("onNewScrollContext listener [{}] failed", listener), e);
    default void onPreFetchPhase(SearchContext searchContext) {}  
                try {  
                    exception = ExceptionsHelper.useOrSuppress(exception, e);  
         * This happens on deletion of a Point-In-Time or on it's keep-alive is expiring.
        @Override
                    listener.onFreeReaderContext(readerContext);  
            }
        public void onFreeScrollContext(ReaderContext readerContext) {
                } catch (Exception e) {
     */  
            }
            }  
 * An listener for search, fetch and context events.  
                }
                    logger.warn(() -> new ParameterizedMessage("onFreeScrollContext listener [{}] failed", listener), e);  
        public void onFetchPhase(SearchContext searchContext, long tookInNanos) {
                try {  
            }  
                }
    default void onFailedQueryPhase(SearchContext searchContext) {}
     *  
     * @param transportRequest the request that is going to use the search context
        }
        public void validateReaderContext(ReaderContext readerContext, TransportRequest request) {  
import org.opensearch.ExceptionsHelper;  
     * @param readerContext the freed search context
        private final Logger logger;
    }
                } catch (Exception e) {
                }
         * @param readerContext the created reader context
     */  
        public void onFailedFetchPhase(SearchContext searchContext) {  
        }
     * This happens either when the search execution finishes, if the
 * this work for additional information regarding copyright
        @Override
            for (SearchOperationListener listener : listeners) {  
        public void onFreePitContext(ReaderContext readerContext) {  
    /**  
import org.opensearch.transport.TransportRequest;
                try {
 * under the License.  
        CompositeListener(List<SearchOperationListener> listeners, Logger logger) {
        public void onNewReaderContext(ReaderContext readerContext) {
            }
    default void onFailedSliceExecution(SearchContext searchContext) {}
                } catch (Exception e) {  
 * ownership. Elasticsearch licenses this file to you under  
                try {
                    logger.warn(() -> new ParameterizedMessage("onNewContext listener [{}] failed", listener), e);  
     * @param readerContext the freed search context  
            for (SearchOperationListener listener : listeners) {
            }
     * Executed if a fetch phased failed.  
            this.listeners = listeners;
        @Override
            }  
                } catch (Exception e) {
    default void validateReaderContext(ReaderContext readerContext, TransportRequest transportRequest) {}
         * Executed when a Point-In-Time search {@link SearchContext} is freed.
 *
 * this file be licensed under the Apache-2.0 license or a
                }
        @Override
 * software distributed under the License is distributed on an
                } catch (Exception e) {
            ExceptionsHelper.reThrowIfNotNull(exception);  
                    listener.validateReaderContext(readerContext, request);
                } catch (Exception e) {  
            for (SearchOperationListener listener : listeners) {
            for (SearchOperationListener listener : listeners) {
 */
 * KIND, either express or implied.  See the License for the
     * cleaned up.
     * @param searchContext the current search context  
        }
    /**  
    /**
        public void onFailedSliceExecution(SearchContext searchContext) {  
        @Override
            }
                    logger.warn(() -> new ParameterizedMessage("onFetchPhase listener [{}] failed", listener), e);
                    logger.warn(() -> new ParameterizedMessage("onFailedQueryPhase listener [{}] failed", listener), e);
     */
        }  
            for (SearchOperationListener listener : listeners) {
    /**
    /**
     * Executed when a new scroll search {@link ReaderContext} was created
        }
 *  
    default void onFailedFetchPhase(SearchContext searchContext) {}  
     */  
    /**
        public void onPreQueryPhase(SearchContext searchContext) {
     */
    default void onFreeScrollContext(ReaderContext readerContext) {}
                } catch (Exception e) {
                    logger.warn(() -> new ParameterizedMessage("onPreFetchPhase listener [{}] failed", listener), e);  
                try {
                    listener.onNewScrollContext(readerContext);
                try {
                try {  
 */  
        @Override
                    listener.onFailedFetchPhase(searchContext);  
     * @see #onFailedQueryPhase(SearchContext)
 * compatible open source license.
    /**  
            }
            Exception exception = null;
     * {@link org.opensearch.search.internal.ContextIndexSearcher#search(IndexSearcher.LeafReaderContextPartition[], org.apache.lucene.search.Weight, org.apache.lucene.search.Collector)} failed.  
    /**
                }
        @Override
            for (SearchOperationListener listener : listeners) {  
     * This will be called once per slice in concurrent search and only once in non-concurrent search.
     * Executed when a Point-In-Time search {@link SearchContext} is freed.
                }
    final class CompositeListener implements SearchOperationListener {  
    default void onNewReaderContext(ReaderContext readerContext) {}
        public void onNewPitContext(ReaderContext readerContext) {
                    listener.onSliceExecution(searchContext);
@PublicApi(since = "1.0.0")
                    listener.onPreFetchPhase(searchContext);
                try {
 * the Apache License, Version 2.0 (the "License"); you may
            for (SearchOperationListener listener : listeners) {
        public void onPreFetchPhase(SearchContext searchContext) {
    default void onFreePitContext(ReaderContext readerContext) {}
     * @param searchContext the current search context
    default void onPreQueryPhase(SearchContext searchContext) {}
     */
     * This will be called once per slice in concurrent search and only once in non-concurrent search.  
     * Executed before the query phase is executed
        }  
/*
        public void onFreeReaderContext(ReaderContext readerContext) {  
     * {@link org.opensearch.search.internal.ContextIndexSearcher#search(IndexSearcher.LeafReaderContextPartition[], org.apache.lucene.search.Weight, org.apache.lucene.search.Collector)}.
    /**  
                } catch (Exception e) {
            for (SearchOperationListener listener : listeners) {
                try {  
import org.apache.logging.log4j.message.ParameterizedMessage;
            for (SearchOperationListener listener : listeners) {
     * {@link org.opensearch.search.internal.ContextIndexSearcher#search(IndexSearcher.LeafReaderContextPartition[], org.apache.lucene.search.Weight, org.apache.lucene.search.Collector)} successfully finished.
                }  
                    listener.onPreSliceExecution(searchContext);
import org.apache.lucene.search.IndexSearcher;
     * @param tookInNanos the number of nanoseconds the fetch execution took  
    default void onQueryPhase(SearchContext searchContext, long tookInNanos) {}  
        }
 * not use this file except in compliance with the License.
                    listener.onFailedQueryPhase(searchContext);  
import java.util.List;  
        }  
 * SPDX-License-Identifier: Apache-2.0
            for (SearchOperationListener listener : listeners) {  
     * A Composite listener that multiplexes calls to each of the listeners methods.
        }
    /**  
     * Executed if a query phased failed.
        /**  
public interface SearchOperationListener {
                    listener.onQueryPhase(searchContext, tookInNanos);
 * specific language governing permissions and limitations
            }
import org.apache.logging.log4j.Logger;  
        @Override
     * from the active contexts. If the context is deemed invalid a runtime
     */
         */
    /**  
                try {  
        }
            }
                } catch (Exception e) {
                try {  
    default void onFreeReaderContext(ReaderContext readerContext) {}
            for (SearchOperationListener listener : listeners) {  
        }
                try {
 * Licensed to Elasticsearch under one or more contributor  
                } catch (Exception e) {  
     */
    /**  
                    listener.onSearchIdleReactivation();
     * @param searchContext the current search context
                } catch (Exception e) {
