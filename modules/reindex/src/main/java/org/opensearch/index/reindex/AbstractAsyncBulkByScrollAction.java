            return;
    ) {
        public Map<String, Object> getSource() {
        String getIndex();
    /**
    protected final ThreadPool threadPool;
        if (task.isCancelled()) {
        public IndexRequest self() {
        logger.debug(() -> new ParameterizedMessage("[{}]: finishing with a catastrophic failure", task.getId()), failure);
                }
        }
            public void onFailure(Exception e) {
        this.interceptor = interceptor;
        for (ScrollableHitSource.Hit doc : docs) {
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
            throw new UnsupportedOperationException("unable to get source from action request [" + request.getClass() + "]");
        public void setVersion(long version) {
        request.waitForActiveShards(mainRequest.getWaitForActiveShards());
 * not use this file except in compliance with the License.
import org.opensearch.action.DocWriteRequest;
        onScrollResponse(System.nanoTime(), this.lastBatchSize, asyncResponse);
                default:
     */
        finishHim(failure, emptyList(), emptyList(), false);
    void prepareBulkRequest(long thisBatchStartTimeNS, ScrollableHitSource.AsyncResponse asyncResponse) {
     */
    protected final Request mainRequest;
     * Wrapper for the {@link DocWriteRequest} that are used in this action class.
            if (mainRequest.getMaxDocs() != MAX_DOCS_ALL_MATCHES && worker.getSuccessfullyProcessed() >= mainRequest.getMaxDocs()) {
        return (request, searchHit) -> request;
        List<BulkItemResponse.Failure> indexingFailures,
     */
     */
            if (newOp == null) {
import java.util.Collections;
            @Override
                    return OpType.DELETE;
            context.put(IndexFieldMapper.NAME, doc.getIndex());
    }
        public ScriptApplier(
import org.opensearch.action.bulk.BulkResponse;
        }
    protected RequestWrapper<?> copyMetadata(RequestWrapper<?> request, ScrollableHitSource.Hit doc) {
        String getId();
    /**
        this(
                refreshAndFinish(unmodifiableList(failures), emptyList(), false);
            context.put("op", oldOpType.toString());
     */
        if (mainRequest.getMaxDocs() != MAX_DOCS_ALL_MATCHES) {
import org.opensearch.action.bulk.BulkItemResponse;
        ThreadPool threadPool,
    void refreshAndFinish(List<Failure> indexingFailures, List<SearchFailure> searchFailures, boolean timedOut) {
        @Override
        }
     * request asks for a refresh.
import org.opensearch.index.mapper.IndexFieldMapper;
    public static RequestWrapper<DeleteRequest> wrap(DeleteRequest request) {
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
                return;
            refreshAndFinish(emptyList(), emptyList(), false);
 * The OpenSearch Contributors require contributions made to
            newValue = context.remove(VersionFieldMapper.NAME);
        }
        scrollSource.setScroll(scroll);
            needsSourceDocumentVersions,
        AbstractRunnable prepareBulkRequestRunnable = new AbstractRunnable() {
        }
import static org.opensearch.core.rest.RestStatus.CONFLICT;
 * under the License.
        }
            request.setSource((Map<String, Object>) context.remove(SourceFieldMapper.NAME));
        );
     */
     * from the bulk request. It is also where we fail on invalid search hits, like
        }
        protected abstract void scriptChangedId(RequestWrapper<?> request, Object to);
        copyRouting(request, doc.getRouting());
                            worker.countCreated();
            return request.id();
            UpdateScript updateScript = factory.newInstance(params, context);
            }
            }
 * Modifications Copyright OpenSearch Contributors. See
            this.scriptService = scriptService;
import org.opensearch.common.util.concurrent.AbstractRunnable;
             */
        if (    // If any of the shards failed that should abort the request.
        @Override
}
     * @param lastBatchSize the size of the last batch. Used to calculate the throttling delay.
        public void setRouting(String routing) {
     * from copying search hit metadata (parent, routing, etc) to potentially transforming the
     * Wraps a {@link DeleteRequest} in a {@link RequestWrapper}
        public String getIndex() {
            String lowerOpType = opType.toLowerCase(Locale.ROOT);
import org.opensearch.action.index.IndexRequest;
import java.util.concurrent.ConcurrentHashMap;
        }
        return new IndexRequestWrapper(request);
    }
        protected abstract void scriptChangedIndex(RequestWrapper<?> request, Object to);
     * @param timedOut have any of the sub-requests timed out?
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.HashSet;
                return request;
import org.opensearch.index.mapper.IdFieldMapper;
            switch (lowerOpType) {
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
                    delete.setRouting(request.getRouting());
        private final IndexRequest request;
            request.versionType(versionType);
                        break;
    protected final Logger logger;
        failures.add(failure);
            }
            request.version(version);
    }
        if (request.requests().isEmpty()) {
 * specific language governing permissions and limitations
        client.admin().indices().refresh(refresh, new ActionListener<RefreshResponse>() {
    }
 * this file be licensed under the Apache-2.0 license or a
            updateScript.execute();
     * Build the {@link BiFunction} to apply to all {@link RequestWrapper}.
        bulkRetry = new Retry(BackoffPolicy.wrap(backoffPolicy, worker::countBulkRetry), threadPool);
            OpType oldOpType = OpType.INDEX;
    }
    }
                hits = hits.subList(0, (int) remaining);
            }
            finishHim(null, indexingFailures, searchFailures, timedOut);
    void notifyDone(long thisBatchStartTimeNS, ScrollableHitSource.AsyncResponse asyncResponse, int batchSize) {
            @Override
 */
        ActionListener<BulkByScrollResponse> listener,
package org.opensearch.index.reindex;
            }
            if (false == context.isEmpty()) {
 */
            public void onResponse(RefreshResponse response) {
import java.util.Locale;
        }
    private void recordFailure(Failure failure, List<Failure> failures) {
                 * waiting on the scroll doesn't count against this batch in the throttle.
        boolean timedOut
     */
                case NOOP:
            Map<String, Object> context = new HashMap<>();
            return;
    /**
        public void setVersionType(VersionType versionType) {
     * Wraps a {@link IndexRequest} in a {@link RequestWrapper}
            finishHim(null);
        @Override
        if (task.isCancelled() || false == mainRequest.isRefresh() || destinationIndices.isEmpty()) {
 * Abstract base for scrolling across a search and executing bulk actions on all results. All package private methods are package private so
            request.id(id);
            return request.index();
        }
 * Licensed to Elasticsearch under one or more contributor
     * Start terminating a request that finished non-catastrophically by refreshing the modified indices and then proceeding to
        DELETE("delete");
        }
                BulkByScrollResponse response = buildResponse(
                    timeValueNanos(System.nanoTime() - startTime.get()),
     */
     */
            return request.index();
    protected final ReindexSslConfig sslConfig;
        } catch (Exception e) {
        asyncResponse.done(worker.throttleWaitTime(thisBatchStartTimeNS, System.nanoTime(), batchSize));
    ) {
        void setVersion(long version);
     * Set the last returned scrollId. Exists entirely for testing.
 * software distributed under the License is distributed on an
     * delay has been slept. Uses the generic thread pool because reindex is rare enough not to need its own thread pool and because the
        @Override
        ActionListener<BulkByScrollResponse> listener,
                    case CREATE:
        DeleteRequestWrapper(DeleteRequest request) {
        }
    }
    }
             * change the "fields" part of the search request it is unlikely that we got here because we didn't fetch _source.
import org.opensearch.index.mapper.RoutingFieldMapper;
        Map<String, Object> getSource();
                scriptChangedIndex(request, newValue);
            OpType newOpType = OpType.fromString(newOp);
    }
                throw new IllegalArgumentException("Script cleared operation type");
        }
     * requests of this mainRequest.
            logger.debug(
                task.getId(),
 */
        @Override
                    continue;
                finishHim(null);
    /**
        @Override
        logger.debug("[{}]: preparing bulk request", task.getId());
                case "noop":
        this.sslConfig = sslConfig;
            for (BulkItemResponse item : response) {
import org.opensearch.index.mapper.SourceFieldMapper;
            sourceBuilder.sort(fieldSort("_doc"));
        refresh.indices(destinationIndices.toArray(new String[0]));
        void setVersionType(VersionType versionType);
        this.listener = listener;
            sslConfig,
             * but it isn't worth keeping two copies of it around just to check!
            worker::countSearchRetry,
                        worker.countDeleted();
import org.opensearch.action.bulk.BulkItemResponse.Failure;
import org.apache.hc.core5.http.HttpRequestInterceptor;
            context.put(IdFieldMapper.NAME, doc.getId());
            }
            this::onScrollResponse,
        ParentTaskAssigningClient client,
            logger,
     * <p>
        request.timeout(mainRequest.getTimeout());
            String oldRouting = doc.getRouting();
                }
    private final AtomicLong startTime = new AtomicLong(-1);
            request.version(version);
    AbstractAsyncBulkByScrollAction(
        } catch (Exception t) {
                    recordFailure(item.getFailure(), failures);
        protected abstract void scriptChangedVersion(RequestWrapper<?> request, Object to);
            @Override
            newValue = context.remove(IdFieldMapper.NAME);
        void setId(String id);
                }
                request.requests().size(),
    /**
            listener,
        logger.debug("[{}]: finishing without any catastrophic failures", task.getId());
    }
        @Override
        BackoffPolicy backoffPolicy = buildBackoffPolicy();
     * This BiFunction is used to apply various changes depending of the Reindex action and  the search hit,
                        }
 * compatible open source license.
            threadPool,
        @Override
        long getVersion();
            if (task.isCancelled()) {
        }
    public void start() {
        @Override
                    searchFailures,
        logger.debug("[{}]: refreshing", task.getId());
import org.opensearch.script.Script;
                    return delete;
    void setScroll(String scroll) {
        }
        final SearchSourceBuilder sourceBuilder = mainRequest.getSearchRequest().source();
                destinationIndicesThisBatch.add(item.getIndex());
                    case DELETE:
                RequestWrapper<?> request = scriptApplier.apply(copyMetadata(buildRequest(doc), doc), doc);
import org.opensearch.action.delete.DeleteRequest;
    /**
        }
                 */
            Set<String> destinationIndicesThisBatch = new HashSet<>();
            // Timeouts aren't shard failures but we still need to pass them back to the user.
 * GitHub history for details.
    protected void finishHim(Exception failure) {
        worker.countBatch();
        }
    }
            }
        }
            }
        private final DeleteRequest request;
import static java.lang.Math.max;
    }
     * The request for this action. Named mainRequest because we create lots of <code>request</code> variables all representing child
    }
    protected final ScriptService scriptService;
     */
            }
        }
                return scriptChangedOpType(request, oldOpType, newOpType);
             */
            total = min(total, mainRequest.getMaxDocs());
             * Its important that routing comes after parent in case you want to
        destinationIndices.addAll(indices);
    private final ScrollableHitSource scrollSource;
                switch (item.getOpType()) {
 *
        }
     * Start the action by firing the initial search request.
                return;
import org.opensearch.script.UpdateScript;
    }
        if (task.isCancelled()) {
        // The default script applier executes a no-op
     */
            }
    /**
                throw new IllegalArgumentException("Invalid fields added to context [" + String.join(",", context.keySet()) + ']');
     * Copies the metadata from a hit to the request.
        @Nullable ReindexSslConfig sslConfig,
     * {@link RequestWrapper} for {@link DeleteRequest}
            onSuccess.run();
     */
     * Processes bulk responses, accounting for failures.
        worker.delayPrepareBulkRequest(threadPool, lastBatchStartTimeNS, lastBatchSize, prepareBulkRequestRunnable);
        if (failure.getStatus() == CONFLICT) {
            if (false == doc.getIndex().equals(newValue)) {
        @Nullable ScriptService scriptService,
            client,
            // Truncate the hits if we have more than the request max docs
    /**
        @Override
            return;
        public void setIndex(String index) {
     */
            return request;
        }
        }
        private final Map<String, Object> params;
             * change them both.
     * @param asyncResponse the response to process from ScrollableHitSource
    void onScrollResponse(long lastBatchStartTimeNS, int lastBatchSize, ScrollableHitSource.AsyncResponse asyncResponse) {
            return request.version();
            client,
        this.threadPool = threadPool;
                    throw new IllegalArgumentException(
        List<SortBuilder<?>> sorts = sourceBuilder.sorts();
        public String getRouting() {
     */
        // like a bug?
    }
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
            this.request = Objects.requireNonNull(request, "Wrapped IndexRequest can not be null");
 * KIND, either express or implied.  See the License for the
import java.util.Map;
     * {@link RequestWrapper} completely.
        Logger logger,
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
     * {@link #finishHim(Exception, List, List, boolean)}.
            refreshAndFinish(emptyList(), response.getFailures(), response.isTimedOut());
    void sendBulkRequest(BulkRequest request, Runnable onSuccess) {
    public static RequestWrapper<IndexRequest> wrap(IndexRequest request) {
            return request.version();
        @Override
            }
        this.lastBatchSize = batchSize;
    /**
        }
        worker.setTotal(total);
        return exponentialBackoff(mainRequest.getRetryBackoffInitialTime(), mainRequest.getMaxRetries());
        @Override
        }
                // We've processed all the requested docs.
        boolean needsSourceDocumentSeqNoAndPrimaryTerm,
import org.opensearch.search.builder.SearchSourceBuilder;
            this.params = params;
        @Override
            logger,
        if (mainRequest.getMaxDocs() > 0) {
        return new DeleteRequestWrapper(request);
        });
            task,
        return new ClientScrollableHitSource(
        public void setSource(Map<String, Object> source) {
        }
            if (false == doc.getId().equals(newValue)) {
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
            switch (newOpType) {
    }
    /**
                    );
            finishHim(null);
    public interface RequestWrapper<Self extends DocWriteRequest<Self>> {
            public void onFailure(Exception e) {
        if (!task.isWorker()) {
        if (task.isCancelled()) {
     * @return the new BulkRequest
            if (failure == null) {
            || response.isTimedOut()) {
            finishHim(t);
import java.util.List;
             */
        @Override
            }
        }
        try {
        }
        @Override
        }
        Logger logger,
        @Override
                // Track the indexes we've seen so we can refresh them if requested
                    taskWorker.countNoop();
 */
            public void onFailure(Exception e) {
import org.opensearch.transport.client.ParentTaskAssigningClient;
     */
        public void setSource(Map<String, Object> source) {
import static java.util.Collections.unmodifiableList;
            this.id = id;
                prepareBulkRequest(System.nanoTime(), asyncResponse);
            request.index(index);
    }
    /**
            if (false == mainRequest.isAbortOnVersionConflict()) {
     * @param indexingFailures any indexing failures accumulated during the request
     *
        }
    public enum OpType {
                default:
                onBulkResponse(response, onSuccess);
    }
        logger.debug("[{}]: got scroll response with [{}] hits", task.getId(), response.getHits().size());
import static org.opensearch.index.reindex.AbstractBulkByScrollRequest.MAX_DOCS_ALL_MATCHES;
     */
            Optional.empty()
import org.opensearch.action.support.TransportAction;
                listener.onFailure(failure);
    private final BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> scriptApplier;
        ScrollableHitSource.Response response = asyncResponse.response();
    Request extends AbstractBulkByScrollRequest<Request>,
    }
    }
        if (doc.getSource() == null) {
        if (response.getHits().isEmpty()) {
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
                        break;
        public void setVersionType(VersionType versionType) {
        if (task.isCancelled()) {
        return request;
                return;
            request.id(id);
                    return OpType.NOOP;
    ) {
        BulkByScrollTask task,
            }
            @Override
                    delete.setVersionType(VersionType.INTERNAL);
        void setSource(Map<String, Object> source);
            } else {
    public static class DeleteRequestWrapper implements RequestWrapper<DeleteRequest> {
        @Override
            threadPool,
            throw new UnsupportedOperationException("unable to set [source] on action request [" + request.getClass() + "]");
        INDEX("index"),
        });
            @Override
        boolean needsSourceDocumentSeqNoAndPrimaryTerm,
 *
            if (false == Objects.equals(oldRouting, newValue)) {
            return request.sourceAsMap();
     * metadata or scripting. That will be handled by copyMetadata and
        }
        @Nullable ReindexSslConfig sslConfig
            if (accept(doc)) {
    public abstract static class ScriptApplier implements BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> {
                        break;
                    delete.setVersion(request.getVersion());
            return;
                    return OpType.INDEX;
    protected boolean accept(ScrollableHitSource.Hit doc) {
import org.opensearch.core.common.unit.ByteSizeValue;
     * Prepare the bulk request. Called on the generic thread pool after some preflight checks have been done one the SearchResponse and any
        private final String id;
    /**
import org.opensearch.core.action.ActionListener;
            this.taskWorker = taskWorker;
            if (script == null) {
    /**
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
        @Override
     * Build the {@link BulkRequest} for a new bulk operation.
        }
 * SPDX-License-Identifier: Apache-2.0
    /**
        String getRouting();
        Self self();
            worker.countVersionConflict();
            /*
            this.request = Objects.requireNonNull(request, "Wrapped DeleteRequest can not be null");
        ScrollableHitSource.Response response = asyncResponse.response();
        if (sorts == null || sorts.isEmpty()) {
            finishHim(null);
            return;
        }
            return request;
        scrollSource = buildScrollableResultSource(backoffPolicy);
            notifyDone(thisBatchStartTimeNS, asyncResponse, 0);
            }
        return bulkRequest;
        public String getId() {
    /**
 * ownership. Elasticsearch licenses this file to you under
        }
    /**
        }
                    timedOut
        ParentTaskAssigningClient client,
        @Override
                    return null;
        private final WorkerBulkByScrollTaskState taskWorker;
import org.opensearch.search.sort.SortBuilder;
            addDestinationIndices(destinationIndicesThisBatch);
import static java.util.Collections.emptyList;
    private final ActionListener<BulkByScrollResponse> listener;
            Map<String, Object> params
            /*
        }
        @Override
        public long getVersion() {
import java.util.Set;
    /**
            request.versionType(versionType);
            Script script,
                if (item.isFailed()) {
                case "index":
/**
    private final Set<String> destinationIndices = Collections.newSetFromMap(new ConcurrentHashMap<>());
        return new BulkRequest();
                            worker.countUpdated();
                        "Operation type [" + lowerOpType + "] not allowed, only " + Arrays.toString(values()) + " are allowed"
             * Thus the error message assumes that it wasn't stored.
    }
        List<SearchFailure> searchFailures,
        if (task.isCancelled()) {
        request.setRouting(routing);
            context.put(VersionFieldMapper.NAME, oldVersion);
        IndexRequestWrapper(IndexRequest request) {
import org.opensearch.common.Nullable;
        public static OpType fromString(String opType) {
        this.logger = logger;
        try {
import org.opensearch.index.VersionType;
    AbstractAsyncBulkByScrollAction(
import org.opensearch.index.mapper.VersionFieldMapper;
        boolean needsSourceDocumentVersions,
        this.worker = task.getWorkerState();
                        if (item.getResponse().getResult() == DocWriteResponse.Result.CREATED) {
    }
            }
        @Override
            return id.toLowerCase(Locale.ROOT);
            }
     * Used to accept or ignore a search hit. Ignored search hits will be excluded
     * Send a bulk request, handling retries.
import java.util.Collection;
        BulkRequest bulkRequest = buildBulkRequest();
            }
        this.mainRequest = mainRequest;
        scriptApplier = Objects.requireNonNull(buildScriptApplier(), "script applier must not be null");
        long total = response.getTotalHits();
            Object newValue = context.remove(IndexFieldMapper.NAME);
/*
 * this work for additional information regarding copyright
     * Public for testings....
        }
     * Build the response for reindex actions.
    protected void copyRouting(RequestWrapper<?> request, String routing) {
    private BulkRequest buildBulk(Iterable<? extends ScrollableHitSource.Hit> docs) {
        @Nullable ScriptService scriptService,
import java.util.function.BiFunction;
        public Map<String, Object> getSource() {
    private final ParentTaskAssigningClient client;
                    RequestWrapper<DeleteRequest> delete = wrap(new DeleteRequest(request.getIndex(), request.getId()));
                scriptChangedVersion(request, newValue);
        };
                logger.debug("[{}]: Finishing early because the task was cancelled", task.getId());
     */
        }
        sourceBuilder.version(needsSourceDocumentVersions);
        BulkRequest request = buildBulk(hits);
            }
                new ByteSizeValue(request.estimatedSizeInBytes())
            }
                return;
                    indexingFailures,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    private int lastBatchSize;
     * @param failure if non null then the request failed catastrophically with this exception
    protected BulkRequest buildBulkRequest() {
            return request.routing();
            this::finishHim,
        prepareBulkRequestRunnable = (AbstractRunnable) threadPool.getThreadContext().preserveContext(prepareBulkRequestRunnable);
                    bulkRequest.add(request.self());
     */
             * It'd be lovely to only set the source if we know its been modified
        protected abstract void scriptChangedRouting(RequestWrapper<?> request, Object to);
        public String toString() {
        }
/*
        public void setRouting(String routing) {
            return;
import java.util.HashMap;
        boolean needsSourceDocumentVersions,
        public DeleteRequest self() {
 * license agreements. See the NOTICE file distributed with
            long remaining = max(0, mainRequest.getMaxDocs() - worker.getSuccessfullyProcessed());
     * Build the {@link RequestWrapper} for a single search hit. This shouldn't handle
        @Override
    public static class IndexRequestWrapper implements RequestWrapper<IndexRequest> {
            context.put(SourceFieldMapper.NAME, request.getSource());
            request.routing(routing);
    void onScrollResponse(ScrollableHitSource.AsyncResponse asyncResponse) {
 * You may obtain a copy of the License at
            request.source(source);
     */
public abstract class AbstractAsyncBulkByScrollAction<
            this.script = script;
     * Add to the list of indices that were modified by this request. This is the list of indices refreshed at the end of the request if the
    }
    void addDestinationIndices(Collection<String> indices) {
 * their tests can use them. Most methods run in the listener thread pool because the are meant to be fast and don't expect to block.
            return request.routing();
                /*
    /**
import org.opensearch.action.DocWriteResponse;
                listener.onResponse(response);
                finishHim(null, indexingFailures, searchFailures, timedOut);
import java.util.Objects;
import org.opensearch.action.bulk.Retry;
    protected ScrollableHitSource buildScrollableResultSource(BackoffPolicy backoffPolicy) {
                "[{}]: sending [{}] entry, [{}] bulk request",
    protected final WorkerBulkByScrollTaskState worker;
    /**
     */
     * @param lastBatchStartTimeNS the time when the last batch started. Used to calculate the throttling delay.
    /**
                    throw new IllegalArgumentException("Unsupported operation type change from [" + oldOpType + "] to [" + newOpType + "]");
            request.routing(routing);
            backoffPolicy,
            mainRequest,
        @SuppressWarnings("unchecked")
import java.util.concurrent.atomic.AtomicLong;
            }
                finishHim(e);
import static java.lang.Math.min;
        public long getVersion() {
        this.task = task;
        @Override
     * thread may be blocked by the user script.
            newValue = context.remove(RoutingFieldMapper.NAME);
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
            public void onResponse(BulkResponse response) {
                    case UPDATE:
        public void setVersion(long version) {
         * Default to sorting by doc. We can't do this in the request itself because it is normal to *add* to the sorts rather than replace
                finishHim(e);
        TimeValue took,
     * Finish the request.
        @Override
            scriptService,
            @Override
        bulkRetry.withBackoff(client::bulk, request, new ActionListener<BulkResponse>() {
import org.opensearch.action.bulk.BulkRequest;
    protected final BulkByScrollTask task;
        BulkByScrollTask task,
                    case INDEX:
    }
     * Get the backoff policy for use with retries.
        ThreadPool threadPool,
            context.put(RoutingFieldMapper.NAME, oldRouting);
    BackoffPolicy buildBackoffPolicy() {
    /**
            needsSourceDocumentSeqNoAndPrimaryTerm,
        @Override
        });
            if (remaining < hits.size()) {
                        } else {
        private final ScriptService scriptService;
            return;
        Request mainRequest,
                        worker.countUpdated();
        private final Script script;
            WorkerBulkByScrollTaskState taskWorker,
        public String getRouting() {
     * Copy the routing from a search hit to the request.
        }
                case "delete":
        this.scriptService = scriptService;
            }
     * {@link RequestWrapper} for {@link IndexRequest}
import static org.opensearch.search.sort.SortBuilders.fieldSort;
                scriptChangedId(request, newValue);
 *
        this.client = client;
            throw new IllegalArgumentException("Given task [" + task.getId() + "] must have a child worker");
        // lastBatchStartTime is essentially unused (see WorkerBulkByScrollTaskState.throttleWaitTime. Leaving it for now, since it seems
        List<? extends ScrollableHitSource.Hit> hits = response.getHits();
            }
     * Process a scroll response.
    }
    void onBulkResponse(BulkResponse response, Runnable onSuccess) {
        RefreshRequest refresh = new RefreshRequest();
    }
        }
     */
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
             */
     */
        NOOP("noop"),
import java.util.Arrays;
            /*
import org.opensearch.script.ScriptService;
            );
        Request mainRequest,
/*
        }
    private final Retry bulkRetry;
    public BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> buildScriptApplier() {
            request.index(index);
         * them and if we add _doc as the first sort by default then sorts will never work.... So we add it here, only if there isn't
            finishHim(e);
            startTime.set(System.nanoTime());
        }
    }
        }
         */
            }
    Action extends TransportAction<Request, ?>> {
import java.util.Optional;
    /**
     * apply functions that can be overridden.
    }
            ScriptService scriptService,
        public String getIndex() {
        OpType(String id) {
import org.opensearch.threadpool.ThreadPool;
            if (false == failures.isEmpty()) {
     */
     */
            return;
            throw new IllegalArgumentException("[" + doc.getIndex() + "][" + doc.getId() + "] didn't store _source");
            Long oldVersion = doc.getVersion();
    }
                scriptChangedRouting(request, newValue);
    protected abstract RequestWrapper<?> buildRequest(ScrollableHitSource.Hit doc);
            List<Failure> failures = new ArrayList<>();
import org.opensearch.action.bulk.BackoffPolicy;
        }
        void setRouting(String routing);
        );
            finishHim(null);
            return;
 * Unless required by applicable law or agreed to in writing,
                );
        public String getId() {
        }
import org.apache.logging.log4j.Logger;
            if (newOpType != oldOpType) {
        }
            }
            mainRequest.getSearchRequest()
        if (logger.isDebugEnabled()) {
             * Either the document didn't store _source or we didn't fetch it for some reason. Since we don't allow the user to
            UpdateScript.Factory factory = scriptService.compile(script, UpdateScript.CONTEXT);
        void setIndex(String index);
    /**
    /**
            protected void doRun() throws Exception {
        scrollSource.close(() -> {
        (response.getFailures().size() > 0)
    }
        sendBulkRequest(request, () -> notifyDone(thisBatchStartTimeNS, asyncResponse, request.requests().size()));
        protected RequestWrapper<?> scriptChangedOpType(RequestWrapper<?> request, OpType oldOpType, OpType newOpType) {
import java.util.ArrayList;
     * Apply a {@link Script} to a {@link RequestWrapper}
        /*
        public void setId(String id) {
    protected void finishHim(Exception failure, List<Failure> indexingFailures, List<SearchFailure> searchFailures, boolean timedOut) {
        Optional<HttpRequestInterceptor> interceptor
    protected BulkByScrollResponse buildResponse(
        return true;
        }
import static org.opensearch.action.bulk.BackoffPolicy.exponentialBackoff;
            if (false == Objects.equals(oldVersion, newValue)) {
        public RequestWrapper<?> apply(RequestWrapper<?> request, ScrollableHitSource.Hit doc) {
            return request;
    /**
             * If we noop-ed the entire batch then just skip to the next batch or the BulkRequest would fail validation.
        public void setId(String id) {
import org.opensearch.common.unit.TimeValue;
    protected final Optional<HttpRequestInterceptor> interceptor;
     * when the document has no source but it's required.
                refreshAndFinish(emptyList(), emptyList(), false);
        public void setIndex(String index) {
            finishHim(null);
            return request.id();
     * Finish the request.
     * @param searchFailures any search failures accumulated during the request
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
         * another sort.
        sourceBuilder.seqNoAndPrimaryTerm(needsSourceDocumentSeqNoAndPrimaryTerm);
            scrollSource.start();
                case DELETE:
     */
     * @param failure if non null then the request failed catastrophically with this exception
                 * It is important that the batch start time be calculated from here, scroll response to scroll response. That way the time
            String newOp = (String) context.remove("op");
                finishHim(e);
     */
            /*
        }
        return new BulkByScrollResponse(took, task.getStatus(), indexingFailures, searchFailures, timedOut);
        @Override
        logger.debug("[{}]: starting", task.getId());
        }
        ) {
                if (request != null) {
        }
