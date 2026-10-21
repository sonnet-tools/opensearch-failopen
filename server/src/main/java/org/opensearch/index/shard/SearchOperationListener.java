        CompositeListener(List<SearchOperationListener> listeners, Logger logger) {
        public void onFreeReaderContext(ReaderContext readerContext) {
     * @param readerContext The reader context used by this request.
                    logger.warn(() -> new ParameterizedMessage("onFailedSliceExecution listener [{}] failed", listener), e);
                } catch (Exception e) {
        }
                }
        public void onNewReaderContext(ReaderContext readerContext) {
     * @see #onFailedSliceExecution(org.opensearch.search.internal.SearchContext)
         * This happens on deletion of a Point-In-Time or on it's keep-alive is expiring.
        }
     * @see #onFailedQueryPhase(SearchContext)
     *
                }
     * {@link org.opensearch.search.internal.ContextIndexSearcher#search(IndexSearcher.LeafReaderContextPartition[], org.apache.lucene.search.Weight, org.apache.lucene.search.Collector)}.
        @Override
                }
     * exception can be thrown, which will prevent the context from being used.
         * Executed when a new Point-In-Time {@link ReaderContext} was created
 * under the License.
                try {
                    logger.warn(() -> new ParameterizedMessage("onSliceExecution listener [{}] failed", listener), e);
                } catch (Exception e) {
            }
}
     * Executed when a previously created reader context is freed.
            for (SearchOperationListener listener : listeners) {
        public void onFetchPhase(SearchContext searchContext, long tookInNanos) {
                } catch (Exception e) {
     * @param searchContext the current search context
                    logger.warn(() -> new ParameterizedMessage("onPreFetchPhase listener [{}] failed", listener), e);
     * Executed when a scroll search {@link SearchContext} is freed.
        }
                    listener.onFailedQueryPhase(searchContext);
                try {
     * Executed when a new scroll search {@link ReaderContext} was created
     * This will be called once per slice in concurrent search and only once in non-concurrent search.
     * This happens either when the search execution finishes, if the
                    listener.onPreSliceExecution(searchContext);
                try {
    /**
     * {@link org.opensearch.search.internal.ContextIndexSearcher#search(IndexSearcher.LeafReaderContextPartition[], org.apache.lucene.search.Weight, org.apache.lucene.search.Collector)} successfully finished.
            this.listeners = listeners;
    default void onFreeScrollContext(ReaderContext readerContext) {}
        @Override
    default void onFailedSliceExecution(SearchContext searchContext) {}
 * the Apache License, Version 2.0 (the "License"); you may
                } catch (Exception e) {
            }
                try {
                } catch (Exception e) {
    default void onFreeReaderContext(ReaderContext readerContext) {}
        }
                }
import org.apache.logging.log4j.Logger;
     * Executed when a Point-In-Time search {@link SearchContext} is freed.
            }
                    listener.onNewPitContext(readerContext);
     */
 *
     * Executed before the query phase is executed
            for (SearchOperationListener listener : listeners) {
        @Override
                    logger.warn(() -> new ParameterizedMessage("onFailedFetchPhase listener [{}] failed", listener), e);
                    listener.onPreFetchPhase(searchContext);
        private final List<SearchOperationListener> listeners;
     */
                } catch (Exception e) {
                try {
 */
    /**
 * GitHub history for details.
        @Override
    /**
                try {
    /**
        @Override
                    listener.onFreeReaderContext(readerContext);
     * Executed if the slice execution in
/*
                }
                    logger.warn(() -> new ParameterizedMessage("onFailedQueryPhase listener [{}] failed", listener), e);
                }
 */
    default void onFailedQueryPhase(SearchContext searchContext) {}
        }
         * Executed when a Point-In-Time search {@link SearchContext} is freed.
                try {
     * @see #onFailedFetchPhase(SearchContext)
 * license agreements. See the NOTICE file distributed with
        @Override
/*
 * not use this file except in compliance with the License.
            for (SearchOperationListener listener : listeners) {
            for (SearchOperationListener listener : listeners) {
                try {
                    logger.warn(() -> new ParameterizedMessage("onPreQueryPhase listener [{}] failed", listener), e);
    /**
            }
                } catch (Exception e) {
    default void onPreFetchPhase(SearchContext searchContext) {}
                try {
     * This happens either when the scroll search execution finishes, if the
 */
     * Executed when a shard goes from idle to non-idle state
     * @param searchContext the current search context
                    listener.onPreQueryPhase(searchContext);
            for (SearchOperationListener listener : listeners) {
        }
     */
 * The OpenSearch Contributors require contributions made to
     * Executed after the slice execution in
            }
        @Override
    /**
        public void onFailedFetchPhase(SearchContext searchContext) {
                    logger.warn(() -> new ParameterizedMessage("onNewSearchIdleReactivation listener [{}] failed", listener), e);
        public void validateReaderContext(ReaderContext readerContext, TransportRequest request) {
        }
                    exception = ExceptionsHelper.useOrSuppress(exception, e);
     * A Composite listener that multiplexes calls to each of the listeners methods.
                } catch (Exception e) {
            }
     */
        @Override
    /**
 * SPDX-License-Identifier: Apache-2.0
        public void onQueryPhase(SearchContext searchContext, long tookInNanos) {
 * specific language governing permissions and limitations
        /**
    /**
        }
 * Licensed to Elasticsearch under one or more contributor
     * Executed when a new Point-In-Time {@link ReaderContext} was created
    /**
                    listener.onSliceExecution(searchContext);
        public void onFailedSliceExecution(SearchContext searchContext) {
     */
                } catch (Exception e) {
    /**
     */
                try {
     */
    default void onSearchIdleReactivation() {}
                }
    /**
     */
    default void onFetchPhase(SearchContext searchContext, long tookInNanos) {}
 * Unless required by applicable law or agreed to in writing,
     * @param readerContext the freed search context
 * software distributed under the License is distributed on an
     * Note: this is not invoked if the slice execution failed.*
                }
                }
 * this work for additional information regarding copyright
     * This will be called once per slice in concurrent search and only once in non-concurrent search.
     *
     */
     */
    default void onNewScrollContext(ReaderContext readerContext) {}
        private final Logger logger;
            }
     */
        /**
     * @param searchContext the current search context
        }
            Exception exception = null;
     */
            for (SearchOperationListener listener : listeners) {
            }
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            for (SearchOperationListener listener : listeners) {
                }
            }
 *
     */
                    logger.warn(() -> new ParameterizedMessage("onFreeScrollContext listener [{}] failed", listener), e);
    default void onNewPitContext(ReaderContext readerContext) {}
    /**
         * @param readerContext the created reader context
     * from the active contexts. If the context is deemed invalid a runtime
                } catch (Exception e) {
    }
import org.opensearch.transport.TransportRequest;
            this.logger = logger;
     * Note: this is not invoked if the query phase execution failed.
import org.apache.lucene.search.IndexSearcher;
            }
     */
     * @param transportRequest the request that is going to use the search context
 * KIND, either express or implied.  See the License for the
                    listener.onSearchIdleReactivation();
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
     *
            for (SearchOperationListener listener : listeners) {
                } catch (Exception e) {
            ExceptionsHelper.reThrowIfNotNull(exception);
                }
            for (SearchOperationListener listener : listeners) {
            }
                } catch (Exception e) {
 * An listener for search, fetch and context events.
     * Executed before the fetch phase is executed
    default void onNewReaderContext(ReaderContext readerContext) {}
     * Executed when a new reader context was created
            for (SearchOperationListener listener : listeners) {
     * Executed if a fetch phased failed.
                }
                    listener.onQueryPhase(searchContext, tookInNanos);
 *
                } catch (Exception e) {
    default void onQueryPhase(SearchContext searchContext, long tookInNanos) {}
        public void onFreeScrollContext(ReaderContext readerContext) {
    default void validateReaderContext(ReaderContext readerContext, TransportRequest transportRequest) {}
        @Override
                } catch (Exception e) {
     * @param tookInNanos the number of nanoseconds the fetch execution took
            }
     * @param searchContext the current search context
/**
                    logger.warn(() -> new ParameterizedMessage("onFetchPhase listener [{}] failed", listener), e);
        }
     * Note: this is not invoked if the fetch phase execution failed.
        }
                try {
     * Executed after the fetch phase successfully finished.
                    listener.onFreeScrollContext(readerContext);
                    logger.warn(() -> new ParameterizedMessage("onPreSliceExecution listener [{}] failed", listener), e);
     * @param searchContext the current search context
                try {
    /**
        }
                try {
        @Override
     * This happens on deletion of a Point-In-Time or on it's keep-alive is expiring.
import org.opensearch.search.internal.SearchContext;
        public void onNewPitContext(ReaderContext readerContext) {
     * execution failed or if the search context as idle for and needs to be
            for (SearchOperationListener listener : listeners) {
        public void onPreQueryPhase(SearchContext searchContext) {
     * Executed after the query phase successfully finished.
                    logger.warn("onNewPitContext listener failed", e);
         */
                    logger.warn(() -> new ParameterizedMessage("onQueryPhase listener [{}] failed", listener), e);
        public void onSearchIdleReactivation() {
     */
                    listener.onFreePitContext(readerContext);
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
@PublicApi(since = "1.0.0")
                try {
                    listener.onFailedFetchPhase(searchContext);
    default void onFreePitContext(ReaderContext readerContext) {}
        public void onNewScrollContext(ReaderContext readerContext) {
    /**
            for (SearchOperationListener listener : listeners) {
            for (SearchOperationListener listener : listeners) {
    default void onSliceExecution(SearchContext searchContext) {}
     * Executed before the slice execution in
        @Override
         * @param readerContext the freed search context
     * Executed prior to using a {@link ReaderContext} that has been retrieved
                }
import org.opensearch.search.internal.ReaderContext;
                    listener.onNewScrollContext(readerContext);
public interface SearchOperationListener {
            }
import org.opensearch.ExceptionsHelper;
import org.opensearch.common.annotation.PublicApi;
     * @param readerContext the freed search context
     * @param readerContext the created reader context
        }
     * @param readerContext the freed reader context
        @Override
        public void onPreFetchPhase(SearchContext searchContext) {
     * execution failed or if the search context as idle for and needs to be
 */
     * Executed if a query phased failed.
            }
 * compatible open source license.
/*
     * @param searchContext the current search context
                    listener.onFetchPhase(searchContext, tookInNanos);
     * @param tookInNanos the number of nanoseconds the query execution took
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under
                try {
        @Override
     * {@link org.opensearch.search.internal.ContextIndexSearcher#search(IndexSearcher.LeafReaderContextPartition[], org.apache.lucene.search.Weight, org.apache.lucene.search.Collector)} failed.
     * @param searchContext the current search context
                    listener.onFailedSliceExecution(searchContext);
                } catch (Exception e) {
        @Override
     */
     * @param readerContext the created context
            }
     * cleaned up.
import java.util.List;
    default void onFailedFetchPhase(SearchContext searchContext) {}
    default void onPreQueryPhase(SearchContext searchContext) {}
                    listener.onNewReaderContext(readerContext);
    default void onPreSliceExecution(SearchContext searchContext) {}
 * You may obtain a copy of the License at
    /**
                } catch (Exception e) {
     * This will be called once per slice in concurrent search and only once in non-concurrent search.
            for (SearchOperationListener listener : listeners) {
        @Override
            }
 * @opensearch.api
            }
     */
                }
     * @param searchContext the current search context
package org.opensearch.index.shard;
        }
                    logger.warn(() -> new ParameterizedMessage("onNewContext listener [{}] failed", listener), e);
            for (SearchOperationListener listener : listeners) {
        }
        }
                } catch (Exception e) {
            for (SearchOperationListener listener : listeners) {
                try {
     * cleaned up.
        @Override
        public void onPreSliceExecution(SearchContext searchContext) {
        public void onFreePitContext(ReaderContext readerContext) {
 *
                try {
        @Override
     * @param readerContext the created reader context
                    logger.warn(() -> new ParameterizedMessage("onNewScrollContext listener [{}] failed", listener), e);
     */
    /**
                }
                    listener.validateReaderContext(readerContext, request);
    /**
                    logger.warn(() -> new ParameterizedMessage("onFreeContext listener [{}] failed", listener), e);
         */
        public void onFailedQueryPhase(SearchContext searchContext) {
                    logger.warn("onFreePitContext listener failed", e);
     * @param searchContext the current search context
        public void onSliceExecution(SearchContext searchContext) {
            for (SearchOperationListener listener : listeners) {
    /**
        }
    final class CompositeListener implements SearchOperationListener {
                }
