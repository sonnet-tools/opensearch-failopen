import static org.opensearch.core.common.util.CollectionUtils.isEmpty;
    ) {
                    searchListener.onFailure(e);
            failures = new ArrayList<>(response.getShardFailures().length);
 * KIND, either express or implied.  See the License for the
/*
    }
        @Override
 * software distributed under the License is distributed on an
        });
 * Unless required by applicable law or agreed to in writing,
        } else {
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 *
        }
        }
        public String getIndex() {
    }
 * ownership. Elasticsearch licenses this file to you under
    }
        Logger logger,
     * A Client hit
/**
 * specific language governing permissions and limitations
    }
            failures = emptyList();
import java.util.function.Consumer;
        /*
            }
        }
            public void onResponse(ClearScrollResponse response) {
import static java.util.Collections.emptyList;
        public MediaType getMediaType() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
import org.apache.logging.log4j.Logger;
 * compatible open source license.
        return new Response(response.isTimedOut(), failures, total, hits, response.getScrollId());
                String nodeId = failure.shard() == null ? null : failure.shard().getNodeId();
            return field == null ? null : field.getValue();
        private final BytesReference source;
            return delegate.getVersion();
                    searchListener.onRejection(e);
        @Override
        if (logger.isDebugEnabled()) {
import org.opensearch.action.search.SearchScrollRequest;
        Consumer<Exception> fail,
                if (ExceptionsHelper.unwrap(e, OpenSearchRejectedExecutionException.class) != null) {
    protected void cleanup(Runnable onCompletion) {
import org.opensearch.action.bulk.BackoffPolicy;
        this.client = client;
        this.firstSearchRequest = firstSearchRequest;
    private final SearchRequest firstSearchRequest;
    @Override
        long total = response.getHits().getTotalHits().value();
/*
    public void doStart(RejectAwareActionListener<Response> searchListener) {
        public long getPrimaryTerm() {
 * A scrollable source of hits from a {@linkplain Client} instance.
         */
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.search.SearchHit;
        onCompletion.run();
 * this work for additional information regarding copyright
            return source;
        SearchRequest firstSearchRequest
        return new ActionListener<SearchResponse>() {
        @Override
 * SPDX-License-Identifier: Apache-2.0
     *
        client.search(firstSearchRequest, wrapListener(searchListener));
    public ClientScrollableHitSource(
                failures.add(new SearchFailure(failure.getCause(), failure.index(), failure.shardId(), nodeId));
            @Override
        };
        }
    protected void doStartNextScroll(String scrollId, TimeValue extraKeepAlive, RejectAwareActionListener<Response> searchListener) {
            return MediaTypeRegistry.xContentType(source);
                isEmpty(firstSearchRequest.indices()) ? "all indices" : firstSearchRequest.indices()
import org.opensearch.action.search.ClearScrollRequest;
import org.opensearch.action.search.ClearScrollResponse;
        private final SearchHit delegate;
    @Override
        public long getSeqNo() {
 * Modifications Copyright OpenSearch Contributors. See
        @Override
/*
 *
        if (response.getHits().getHits() == null || response.getHits().getHits().length == 0) {
 * this file be licensed under the Apache-2.0 license or a
    }
        public String getRouting() {
    public void clearScroll(String scrollId, Runnable onCompletion) {
            for (SearchHit hit : response.getHits().getHits()) {
            public void onResponse(SearchResponse searchResponse) {
 */
                } else {
            return delegate.getSeqNo();
            return delegate.getIndex();
                "executing initial scroll against {}",
                onCompletion.run();
            hits = new ArrayList<>(response.getHits().getHits().length);
        Runnable countSearchRetry,
    private static class ClientHit implements Hit {
    }
            }
        @Override
import org.opensearch.common.document.DocumentField;
        client.searchScroll(request, wrapListener(searchListener));
import java.util.ArrayList;
import org.apache.logging.log4j.message.ParameterizedMessage;
        firstSearchRequest.allowPartialSearchResults(false);
        if (response.getShardFailures() == null) {
import org.opensearch.core.xcontent.MediaType;
        ParentTaskAssigningClient client,
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.ExceptionsHelper;
        ThreadPool threadPool,
        clearScrollRequest.addScrollId(scrollId);
    private Response wrapSearchResponse(SearchResponse response) {
 */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
     */
}
    }
            DocumentField field = delegate.field(fieldName);
            for (ShardSearchFailure failure : response.getShardFailures()) {
        @Override
    @Override
        @Override
        SearchScrollRequest request = new SearchScrollRequest();
public class ClientScrollableHitSource extends ScrollableHitSource {
            @Override
 */
        public BytesReference getSource() {
        public String getId() {
    @Override
    /**
        }
    private final ParentTaskAssigningClient client;
    private ActionListener<SearchResponse> wrapListener(RejectAwareActionListener<Response> searchListener) {
            }
            }
                onCompletion.run();
        @Override
        private <T> T fieldValue(String fieldName) {
        BackoffPolicy backoffPolicy,
            return fieldValue(RoutingFieldMapper.NAME);
import org.opensearch.action.search.SearchRequest;
    }
        }
        client.unwrap().clearScroll(clearScrollRequest, new ActionListener<ClearScrollResponse>() {
        super(logger, backoffPolicy, threadPool, countSearchRetry, onResponse, fail);
                logger.warn(() -> new ParameterizedMessage("Failed to clear scroll [{}]", scrollId), e);
            public void onFailure(Exception e) {
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
 * license agreements. See the NOTICE file distributed with
            source = delegate.hasSource() ? delegate.getSourceRef() : null;
            @Override
        } else {
        }
            public void onFailure(Exception e) {
package org.opensearch.index.reindex;
        public long getVersion() {
import org.opensearch.core.common.bytes.BytesReference;
 * @opensearch.internal
            return delegate.getId();
        request.scrollId(scrollId).scroll(timeValueNanos(firstSearchRequest.scroll().keepAlive().nanos() + extraKeepAlive.nanos()));
        // Add the wait time into the scroll timeout so it won't timeout while we wait for throttling
        }
     * @opensearch.internal
 * You may obtain a copy of the License at
 * under the License.
            }
import org.opensearch.action.search.ShardSearchFailure;
        }
 *
                logger.debug("Freed [{}] contexts", response.getNumFreed());
        }
        }
 * GitHub history for details.
        List<Hit> hits;
            hits = unmodifiableList(hits);
                searchListener.onResponse(wrapSearchResponse(searchResponse));
            hits = emptyList();
        List<SearchFailure> failures;
import org.opensearch.threadpool.ThreadPool;
 * not use this file except in compliance with the License.
                }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.index.mapper.RoutingFieldMapper;
            return delegate.getPrimaryTerm();
        Consumer<AsyncResponse> onResponse,
import org.opensearch.transport.client.Client;
import static java.util.Collections.unmodifiableList;
            this.delegate = delegate;
import org.opensearch.core.action.ActionListener;
            logger.debug(
        ClientHit(SearchHit delegate) {
 */
        }
            );
         * if this task is cancelled. But we want to clear the scroll regardless of whether or not the main request was cancelled.
import org.opensearch.action.search.SearchResponse;
                hits.add(new ClientHit(hit));
import org.opensearch.transport.client.ParentTaskAssigningClient;
         * Unwrap the client so we don't set our task as the parent. If we *did* set our ID then the clear scroll would be cancelled as
 *
