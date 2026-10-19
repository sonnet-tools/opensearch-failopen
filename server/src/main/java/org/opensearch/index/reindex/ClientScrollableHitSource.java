import org.apache.logging.log4j.message.ParameterizedMessage;
            public void onResponse(ClearScrollResponse response) {  
import org.opensearch.index.mapper.RoutingFieldMapper;  
                } else {
        this.firstSearchRequest = firstSearchRequest;  
import static org.opensearch.core.common.util.CollectionUtils.isEmpty;
/*  
 */
    @Override
        Consumer<Exception> fail,  
         * Unwrap the client so we don't set our task as the parent. If we *did* set our ID then the clear scroll would be cancelled as
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
                isEmpty(firstSearchRequest.indices()) ? "all indices" : firstSearchRequest.indices()  
    @Override
                failures.add(new SearchFailure(failure.getCause(), failure.index(), failure.shardId(), nodeId));
            }
            public void onFailure(Exception e) {
 *
            failures = new ArrayList<>(response.getShardFailures().length);
                onCompletion.run();
import org.opensearch.transport.client.Client;  
 * A scrollable source of hits from a {@linkplain Client} instance.
 *  
        firstSearchRequest.allowPartialSearchResults(false);
                if (ExceptionsHelper.unwrap(e, OpenSearchRejectedExecutionException.class) != null) {
    protected void doStartNextScroll(String scrollId, TimeValue extraKeepAlive, RejectAwareActionListener<Response> searchListener) {
        public String getIndex() {
        }
            failures = emptyList();  
        public long getSeqNo() {
    /**
        this.client = client;
        SearchRequest firstSearchRequest
 * this work for additional information regarding copyright
        @Override  
    private Response wrapSearchResponse(SearchResponse response) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void cleanup(Runnable onCompletion) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            @Override
        }
        }
            return delegate.getVersion();
        Runnable countSearchRetry,
            @Override
        return new Response(response.isTimedOut(), failures, total, hits, response.getScrollId());
        BackoffPolicy backoffPolicy,
        }  
        };
     * @opensearch.internal
        }  
        @Override  
        public MediaType getMediaType() {
import org.apache.logging.log4j.Logger;
        }  
        List<Hit> hits;
            this.delegate = delegate;
 * this file be licensed under the Apache-2.0 license or a
            hits = new ArrayList<>(response.getHits().getHits().length);  
                hits.add(new ClientHit(hit));
     */
        });
    }
    private final SearchRequest firstSearchRequest;
import java.util.function.Consumer;
            for (ShardSearchFailure failure : response.getShardFailures()) {  
                    searchListener.onRejection(e);  
        }
            }  
            source = delegate.hasSource() ? delegate.getSourceRef() : null;  
 * ownership. Elasticsearch licenses this file to you under  
 *
            return field == null ? null : field.getValue();  
    }  
import org.opensearch.search.SearchHit;
            @Override
                String nodeId = failure.shard() == null ? null : failure.shard().getNodeId();
 * compatible open source license.
        client.unwrap().clearScroll(clearScrollRequest, new ActionListener<ClearScrollResponse>() {
 */  
 */
        Consumer<AsyncResponse> onResponse,
    private final ParentTaskAssigningClient client;  
    private static class ClientHit implements Hit {  
import org.opensearch.action.search.SearchRequest;
                searchListener.onResponse(wrapSearchResponse(searchResponse));  
    }
            );
import org.opensearch.action.search.SearchScrollRequest;  
        }
        client.search(firstSearchRequest, wrapListener(searchListener));  
 * KIND, either express or implied.  See the License for the
        SearchScrollRequest request = new SearchScrollRequest();
import java.util.ArrayList;  
            return source;  
import org.opensearch.core.common.bytes.BytesReference;
         * if this task is cancelled. But we want to clear the scroll regardless of whether or not the main request was cancelled.
/*
            hits = emptyList();
     * A Client hit
            logger.debug(
 */  
package org.opensearch.index.reindex;
 * the Apache License, Version 2.0 (the "License"); you may
            public void onResponse(SearchResponse searchResponse) {
        if (response.getShardFailures() == null) {
     *  
    ) {  
        @Override
 *
 * You may obtain a copy of the License at  
import org.opensearch.action.search.ShardSearchFailure;
        /*  
            return delegate.getId();
import org.opensearch.common.document.DocumentField;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
            }  
        return new ActionListener<SearchResponse>() {  
import org.opensearch.action.search.ClearScrollResponse;  
 * under the License.  
        if (response.getHits().getHits() == null || response.getHits().getHits().length == 0) {  
        @Override
/*  
        super(logger, backoffPolicy, threadPool, countSearchRetry, onResponse, fail);
import org.opensearch.transport.client.ParentTaskAssigningClient;
    public void doStart(RejectAwareActionListener<Response> searchListener) {
    }  
        public long getPrimaryTerm() {
 * license agreements. See the NOTICE file distributed with
        } else {
            return delegate.getPrimaryTerm();
        }
            hits = unmodifiableList(hits);
            return MediaTypeRegistry.xContentType(source);
            return delegate.getSeqNo();  
    @Override
import static java.util.Collections.emptyList;
        private final BytesReference source;
    @Override  
        client.searchScroll(request, wrapListener(searchListener));
            DocumentField field = delegate.field(fieldName);
import org.opensearch.action.search.ClearScrollRequest;
            @Override  
        ThreadPool threadPool,  
        onCompletion.run();  
    public ClientScrollableHitSource(  
    private ActionListener<SearchResponse> wrapListener(RejectAwareActionListener<Response> searchListener) {
                    searchListener.onFailure(e);
        @Override
import java.util.List;
                onCompletion.run();
            return fieldValue(RoutingFieldMapper.NAME);
        @Override
        ParentTaskAssigningClient client,
import org.opensearch.threadpool.ThreadPool;
        ClientHit(SearchHit delegate) {
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
            return delegate.getIndex();
                "executing initial scroll against {}",
        public BytesReference getSource() {
                logger.debug("Freed [{}] contexts", response.getNumFreed());
import static java.util.Collections.unmodifiableList;
            }  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
                }  
        @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.ExceptionsHelper;  
        Logger logger,
 * GitHub history for details.
        List<SearchFailure> failures;
    }
        private final SearchHit delegate;
        // Add the wait time into the scroll timeout so it won't timeout while we wait for throttling  
import static org.opensearch.common.unit.TimeValue.timeValueNanos;  
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.action.search.SearchResponse;
        public long getVersion() {  
        long total = response.getHits().getTotalHits().value();  
/**  
        clearScrollRequest.addScrollId(scrollId);
    }
            }
 * @opensearch.internal  
        public String getId() {  
            for (SearchHit hit : response.getHits().getHits()) {
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    public void clearScroll(String scrollId, Runnable onCompletion) {  
        request.scrollId(scrollId).scroll(timeValueNanos(firstSearchRequest.scroll().keepAlive().nanos() + extraKeepAlive.nanos()));
        }
        }
        private <T> T fieldValue(String fieldName) {
import org.opensearch.core.xcontent.MediaType;
            }  
        } else {
        public String getRouting() {  
import org.opensearch.core.action.ActionListener;
    }
                logger.warn(() -> new ParameterizedMessage("Failed to clear scroll [{}]", scrollId), e);
public class ClientScrollableHitSource extends ScrollableHitSource {
 * Unless required by applicable law or agreed to in writing,
        }
            public void onFailure(Exception e) {  
    }
        if (logger.isDebugEnabled()) {  
         */  
        }
        @Override  
import org.opensearch.action.bulk.BackoffPolicy;
