        Logger logger,  
    protected final ThreadPool threadPool;
     * {@link RequestWrapper} for {@link DeleteRequest}
                    delete.setVersionType(VersionType.INTERNAL);
 * not use this file except in compliance with the License.
    }
            if (failure == null) {  
            request.routing(routing);
            logger.debug(  
            return;
                        if (item.getResponse().getResult() == DocWriteResponse.Result.CREATED) {
import org.opensearch.action.bulk.BulkResponse;  
        public void setVersionType(VersionType versionType) {  
            if (newOpType != oldOpType) {
            refreshAndFinish(emptyList(), response.getFailures(), response.isTimedOut());
        }
        }  
                finishHim(null, indexingFailures, searchFailures, timedOut);  
            return;  
             */
/*
                    throw new IllegalArgumentException("Unsupported operation type change from [" + oldOpType + "] to [" + newOpType + "]");  
import org.opensearch.search.sort.SortBuilder;  
        Request mainRequest,  
        }  
     * Apply a {@link Script} to a {@link RequestWrapper}  
        if (logger.isDebugEnabled()) {
            throw new UnsupportedOperationException("unable to get source from action request [" + request.getClass() + "]");
 * this work for additional information regarding copyright
            return;
        @Override
     * from copying search hit metadata (parent, routing, etc) to potentially transforming the
                return;  
        BulkRequest bulkRequest = buildBulkRequest();  
        public Map<String, Object> getSource() {
            /*
     * Build the {@link BulkRequest} for a new bulk operation.
        private final Map<String, Object> params;
                 * waiting on the scroll doesn't count against this batch in the throttle.
    private final ScrollableHitSource scrollSource;
        public String getIndex() {  
     * Add to the list of indices that were modified by this request. This is the list of indices refreshed at the end of the request if the
        String getRouting();  
            }
                // We've processed all the requested docs.
                    case DELETE:
        });
            @Override
        scrollSource = buildScrollableResultSource(backoffPolicy);
     * Processes bulk responses, accounting for failures.
            client,
            request.setSource((Map<String, Object>) context.remove(SourceFieldMapper.NAME));
import org.opensearch.action.bulk.BulkItemResponse.Failure;
        BulkByScrollTask task,  
    void onBulkResponse(BulkResponse response, Runnable onSuccess) {
    }
     */  
        return new BulkRequest();  
import org.opensearch.action.DocWriteRequest;
                            worker.countUpdated();
    private final Retry bulkRetry;  
            if (false == doc.getIndex().equals(newValue)) {
        (response.getFailures().size() > 0)
        ActionListener<BulkByScrollResponse> listener,
    public static RequestWrapper<DeleteRequest> wrap(DeleteRequest request) {
    }
     */  
     * thread may be blocked by the user script.
                /*  
            return request;  
    }  
     * requests of this mainRequest.  
            // Truncate the hits if we have more than the request max docs  
            return;  
                    delete.setRouting(request.getRouting());  
                    throw new IllegalArgumentException(  
    }
            addDestinationIndices(destinationIndicesThisBatch);  
                finishHim(e);
        private final WorkerBulkByScrollTaskState taskWorker;
            context.put(RoutingFieldMapper.NAME, oldRouting);
        @Override
            @Override
        logger.debug("[{}]: preparing bulk request", task.getId());
            newValue = context.remove(RoutingFieldMapper.NAME);
            }
        @Nullable ReindexSslConfig sslConfig,  
        @Override  
            }
     * metadata or scripting. That will be handled by copyMetadata and
    private BulkRequest buildBulk(Iterable<? extends ScrollableHitSource.Hit> docs) {
        long getVersion();  
    AbstractAsyncBulkByScrollAction(
public abstract class AbstractAsyncBulkByScrollAction<
 * ownership. Elasticsearch licenses this file to you under  
                    case CREATE:
        public String getId() {  
        // like a bug?  
     * Public for testings....
                }  
            Object newValue = context.remove(IndexFieldMapper.NAME);
        logger.debug("[{}]: finishing without any catastrophic failures", task.getId());
        public void setVersion(long version) {
        }
                case "noop":
import org.opensearch.index.mapper.IndexFieldMapper;  
            request.version(version);  
     */  
            /*
import org.opensearch.core.common.unit.ByteSizeValue;  
            needsSourceDocumentSeqNoAndPrimaryTerm,
        };
    protected RequestWrapper<?> copyMetadata(RequestWrapper<?> request, ScrollableHitSource.Hit doc) {  
                finishHim(e);  
     */  
    protected abstract RequestWrapper<?> buildRequest(ScrollableHitSource.Hit doc);
            scriptService,
        public void setIndex(String index) {
    /**
     * @param asyncResponse the response to process from ScrollableHitSource
    }  
    /**  
    /**
 * KIND, either express or implied.  See the License for the
        boolean needsSourceDocumentVersions,
    protected BulkByScrollResponse buildResponse(
    }
                case "index":
     * {@link RequestWrapper} completely.  
        void setRouting(String routing);
     */  
        }
    private final ActionListener<BulkByScrollResponse> listener;
        this.scriptService = scriptService;
                }
        scrollSource.setScroll(scroll);  
        }
        onScrollResponse(System.nanoTime(), this.lastBatchSize, asyncResponse);
            return request.version();
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
     */
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;
            finishHim(e);  
        final SearchSourceBuilder sourceBuilder = mainRequest.getSearchRequest().source();
            throw new IllegalArgumentException("Given task [" + task.getId() + "] must have a child worker");
        public String getRouting() {
             * change the "fields" part of the search request it is unlikely that we got here because we didn't fetch _source.  
     * Wraps a {@link IndexRequest} in a {@link RequestWrapper}
        public void setIndex(String index) {  
        );
            if (accept(doc)) {
        @Override
        }  
 */
        }  
            return request;
    }
            finishHim(null, indexingFailures, searchFailures, timedOut);  
        }
        @Override
                 */  
                case "delete":  
        }  
        }
             */
                prepareBulkRequest(System.nanoTime(), asyncResponse);
        }
        @Override
}
    BackoffPolicy buildBackoffPolicy() {
                }  
 */  
     * @return the new BulkRequest  
 * the Apache License, Version 2.0 (the "License"); you may
        if (task.isCancelled()) {
        Optional<HttpRequestInterceptor> interceptor
            ScriptService scriptService,
            mainRequest,  
        @Override
    protected final Optional<HttpRequestInterceptor> interceptor;
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
            request.index(index);
    }
     */
        IndexRequestWrapper(IndexRequest request) {
        if (failure.getStatus() == CONFLICT) {  
            return request;  
        RefreshRequest refresh = new RefreshRequest();  
            logger,
        } catch (Exception e) {
            logger,  
    /**
            if (remaining < hits.size()) {
 * The OpenSearch Contributors require contributions made to  
        @SuppressWarnings("unchecked")
import org.opensearch.threadpool.ThreadPool;
        client.admin().indices().refresh(refresh, new ActionListener<RefreshResponse>() {  
             * change them both.  
            @Override  
import org.opensearch.action.bulk.BackoffPolicy;
import static java.util.Collections.unmodifiableList;
                if (item.isFailed()) {  
        logger.debug("[{}]: got scroll response with [{}] hits", task.getId(), response.getHits().size());  
 * software distributed under the License is distributed on an
            }
        }
        public void setVersion(long version) {  
                return;
    /**
            this::finishHim,
            return request.index();  
            scrollSource.start();
        }
     * Wrapper for the {@link DocWriteRequest} that are used in this action class.
        @Override
        public void setRouting(String routing) {
            Optional.empty()
        protected abstract void scriptChangedId(RequestWrapper<?> request, Object to);  
        public DeleteRequest self() {
    protected final ScriptService scriptService;  
     * Wraps a {@link DeleteRequest} in a {@link RequestWrapper}
 */  
    private void recordFailure(Failure failure, List<Failure> failures) {
        @Override
        protected RequestWrapper<?> scriptChangedOpType(RequestWrapper<?> request, OpType oldOpType, OpType newOpType) {  
     */
                    case INDEX:  
            throw new IllegalArgumentException("[" + doc.getIndex() + "][" + doc.getId() + "] didn't store _source");  
            return request.id();
            sourceBuilder.sort(fieldSort("_doc"));
    void sendBulkRequest(BulkRequest request, Runnable onSuccess) {
            Map<String, Object> params
            request.version(version);
                task.getId(),
    }  
    /**  
        public void setVersionType(VersionType versionType) {
            }
                    taskWorker.countNoop();  
    AbstractAsyncBulkByScrollAction(
             * Either the document didn't store _source or we didn't fetch it for some reason. Since we don't allow the user to
        public void setId(String id) {
 *
                    return OpType.NOOP;  
            context.put(IdFieldMapper.NAME, doc.getId());  
            this.request = Objects.requireNonNull(request, "Wrapped IndexRequest can not be null");
        private final String id;
                        break;  
import static java.lang.Math.max;
        return true;
     * delay has been slept. Uses the generic thread pool because reindex is rare enough not to need its own thread pool and because the  
            task,  
            this.scriptService = scriptService;
            }
 * Unless required by applicable law or agreed to in writing,
    }
    }
        }
            }
        });
                 * It is important that the batch start time be calculated from here, scroll response to scroll response. That way the time
        public RequestWrapper<?> apply(RequestWrapper<?> request, ScrollableHitSource.Hit doc) {
import java.util.Arrays;
        if (    // If any of the shards failed that should abort the request.  
            /*
import org.opensearch.index.mapper.RoutingFieldMapper;
        sourceBuilder.version(needsSourceDocumentVersions);
            request.versionType(versionType);
 * SPDX-License-Identifier: Apache-2.0
     * @param indexingFailures any indexing failures accumulated during the request
    }  
     */  
     * Start the action by firing the initial search request.
            }  
        }
import org.opensearch.script.ScriptService;  
        }
            return request.routing();
    /**  
        public String getRouting() {
    void prepareBulkRequest(long thisBatchStartTimeNS, ScrollableHitSource.AsyncResponse asyncResponse) {  
        if (task.isCancelled()) {
        if (request.requests().isEmpty()) {
                    continue;
        TimeValue took,
            if (false == failures.isEmpty()) {
            OpType newOpType = OpType.fromString(newOp);
        scriptApplier = Objects.requireNonNull(buildScriptApplier(), "script applier must not be null");
            }
    /**
                    return OpType.INDEX;
        if (mainRequest.getMaxDocs() > 0) {
    /**
        public long getVersion() {
        @Override
         * them and if we add _doc as the first sort by default then sorts will never work.... So we add it here, only if there isn't
            context.put(VersionFieldMapper.NAME, oldVersion);
            );
        void setVersionType(VersionType versionType);
    protected final Request mainRequest;
            context.put(SourceFieldMapper.NAME, request.getSource());
                scriptChangedVersion(request, newValue);
        this.lastBatchSize = batchSize;
        @Override  
            return;  
 * GitHub history for details.
     */
    private final BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> scriptApplier;
import org.apache.logging.log4j.Logger;
    /**  
                request.requests().size(),  
    Action extends TransportAction<Request, ?>> {  
import org.opensearch.common.unit.TimeValue;  
        @Nullable ReindexSslConfig sslConfig  
            newValue = context.remove(VersionFieldMapper.NAME);  
        failures.add(failure);  
        return new BulkByScrollResponse(took, task.getStatus(), indexingFailures, searchFailures, timedOut);
 * specific language governing permissions and limitations
        @Override  
            this.script = script;
            updateScript.execute();  
            request.routing(routing);  
import org.opensearch.action.bulk.BulkRequest;
        ParentTaskAssigningClient client,
        /*  
        List<SortBuilder<?>> sorts = sourceBuilder.sorts();  
        try {
     * {@link RequestWrapper} for {@link IndexRequest}
            refreshAndFinish(emptyList(), emptyList(), false);  
/*  
    /**
     */
     */
        asyncResponse.done(worker.throttleWaitTime(thisBatchStartTimeNS, System.nanoTime(), batchSize));
        void setIndex(String index);
            }
                    );
            Set<String> destinationIndicesThisBatch = new HashSet<>();
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
        if (sorts == null || sorts.isEmpty()) {
            String newOp = (String) context.remove("op");
        @Nullable ScriptService scriptService,
        sourceBuilder.seqNoAndPrimaryTerm(needsSourceDocumentSeqNoAndPrimaryTerm);
        this.sslConfig = sslConfig;
            }
import java.util.ArrayList;
            public void onFailure(Exception e) {
        DELETE("delete");  
        @Override  
        Request mainRequest,  
        }  
        String getIndex();
            finishHim(null);  
        boolean timedOut
import org.opensearch.action.index.IndexRequest;  
         * Default to sorting by doc. We can't do this in the request itself because it is normal to *add* to the sorts rather than replace
 *    http://www.apache.org/licenses/LICENSE-2.0
             */
        void setSource(Map<String, Object> source);
 * You may obtain a copy of the License at  
    protected final BulkByScrollTask task;  
        }
                    bulkRequest.add(request.self());
     */  
        logger.debug(() -> new ParameterizedMessage("[{}]: finishing with a catastrophic failure", task.getId()), failure);
            if (false == context.isEmpty()) {  
        }
         */
import org.opensearch.action.delete.DeleteRequest;
import org.opensearch.common.util.concurrent.AbstractRunnable;
     *  
    }  
                    RequestWrapper<DeleteRequest> delete = wrap(new DeleteRequest(request.getIndex(), request.getId()));  
                        break;  
            Script script,  
import org.opensearch.script.Script;
        public IndexRequest self() {
            || response.isTimedOut()) {  
    }
    /**
            WorkerBulkByScrollTaskState taskWorker,
     * Used to accept or ignore a search hit. Ignored search hits will be excluded
        }
                refreshAndFinish(emptyList(), emptyList(), false);  
                        } else {  
        @Override
     * Process a scroll response.
import static org.opensearch.search.sort.SortBuilders.fieldSort;
            if (false == mainRequest.isAbortOnVersionConflict()) {
            }  
            }
            if (mainRequest.getMaxDocs() != MAX_DOCS_ALL_MATCHES && worker.getSuccessfullyProcessed() >= mainRequest.getMaxDocs()) {
     */
             */
    /**
        }
        sendBulkRequest(request, () -> notifyDone(thisBatchStartTimeNS, asyncResponse, request.requests().size()));
        finishHim(failure, emptyList(), emptyList(), false);
import org.opensearch.index.mapper.VersionFieldMapper;  
        INDEX("index"),
    }  
        );
        String getId();
                    delete.setVersion(request.getVersion());
        protected abstract void scriptChangedVersion(RequestWrapper<?> request, Object to);
        Self self();  
     * Start terminating a request that finished non-catastrophically by refreshing the modified indices and then proceeding to
     * Prepare the bulk request. Called on the generic thread pool after some preflight checks have been done one the SearchResponse and any
            finishHim(null);  
                        break;  
        @Override  
        }
    }
        }
    /**  
        public void setSource(Map<String, Object> source) {  
        Logger logger,  
        BackoffPolicy backoffPolicy = buildBackoffPolicy();
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
            return;
        void setId(String id);  
 * compatible open source license.
            if (newOp == null) {  
        }
    public static RequestWrapper<IndexRequest> wrap(IndexRequest request) {  
        logger.debug("[{}]: refreshing", task.getId());
import org.apache.hc.core5.http.HttpRequestInterceptor;
 * Modifications Copyright OpenSearch Contributors. See
            UpdateScript.Factory factory = scriptService.compile(script, UpdateScript.CONTEXT);
            if (false == Objects.equals(oldVersion, newValue)) {
                "[{}]: sending [{}] entry, [{}] bulk request",
            request.id(id);
        try {
import org.opensearch.index.mapper.IdFieldMapper;
        protected abstract void scriptChangedRouting(RequestWrapper<?> request, Object to);
        this(
            backoffPolicy,  
import java.util.List;
    ) {  
                    return OpType.DELETE;
        ThreadPool threadPool,
import java.util.Locale;
        }  
        @Override
        OpType(String id) {
        }
            }
            }
        }  
     * @param lastBatchStartTimeNS the time when the last batch started. Used to calculate the throttling delay.  
        }
import static org.opensearch.action.bulk.BackoffPolicy.exponentialBackoff;  
            }
import java.util.HashSet;  
        }  
     */
            public void onResponse(RefreshResponse response) {
            threadPool,
        @Override
        if (task.isCancelled()) {  
            context.put(IndexFieldMapper.NAME, doc.getIndex());
            return id.toLowerCase(Locale.ROOT);
     * @param failure if non null then the request failed catastrophically with this exception
 * license agreements. See the NOTICE file distributed with
            for (BulkItemResponse item : response) {
            sslConfig,  
        request.waitForActiveShards(mainRequest.getWaitForActiveShards());  
import java.util.Set;  
     */  
        if (doc.getSource() == null) {  
        worker.countBatch();  
            return request.index();
        worker.delayPrepareBulkRequest(threadPool, lastBatchStartTimeNS, lastBatchSize, prepareBulkRequestRunnable);
    }
     */
                return;
            protected void doRun() throws Exception {
            finishHim(null);
            this.params = params;  
                    case UPDATE:
     */  
import static org.opensearch.index.reindex.AbstractBulkByScrollRequest.MAX_DOCS_ALL_MATCHES;  
            needsSourceDocumentVersions,
            client,
            }
        @Nullable ScriptService scriptService,
        @Override  
        public long getVersion() {
        }
    Request extends AbstractBulkByScrollRequest<Request>,
            finishHim(t);  
            @Override  
                RequestWrapper<?> request = scriptApplier.apply(copyMetadata(buildRequest(doc), doc), doc);  
    }
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.core.rest.RestStatus.CONFLICT;
 *  
             * but it isn't worth keeping two copies of it around just to check!  
        return new ClientScrollableHitSource(
        public void setId(String id) {
        }  
        for (ScrollableHitSource.Hit doc : docs) {
            return request.id();
    }
        public ScriptApplier(  
            }
            throw new UnsupportedOperationException("unable to set [source] on action request [" + request.getClass() + "]");
    /**
        }
/**  
        } catch (Exception t) {
    /**
                return request;
        this.threadPool = threadPool;
            finishHim(null);
 * their tests can use them. Most methods run in the listener thread pool because the are meant to be fast and don't expect to block.
        }
         * another sort.  
        return request;
                logger.debug("[{}]: Finishing early because the task was cancelled", task.getId());
import java.util.function.BiFunction;  
import org.opensearch.action.bulk.Retry;
            newValue = context.remove(IdFieldMapper.NAME);
    protected BulkRequest buildBulkRequest() {
     */
     */
    void refreshAndFinish(List<Failure> indexingFailures, List<SearchFailure> searchFailures, boolean timedOut) {
                finishHim(null);
                finishHim(e);
        ActionListener<BulkByScrollResponse> listener,
            return request.routing();  
 * under the License.  
            this::onScrollResponse,  
        DeleteRequestWrapper(DeleteRequest request) {
     * @param searchFailures any search failures accumulated during the request  
            if (task.isCancelled()) {  
        // The default script applier executes a no-op
    /**
     */
            worker::countSearchRetry,
import org.opensearch.transport.client.ParentTaskAssigningClient;
        NOOP("noop"),
    public enum OpType {
    protected final Logger logger;
        });
                scriptChangedRouting(request, newValue);
    protected boolean accept(ScrollableHitSource.Hit doc) {
    protected final ReindexSslConfig sslConfig;
    }  
        if (!task.isWorker()) {  
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
        @Override  
            mainRequest.getSearchRequest()  
                    return delete;
        }
        return (request, searchHit) -> request;  
            // Timeouts aren't shard failures but we still need to pass them back to the user.
             * Its important that routing comes after parent in case you want to
                    return null;
        List<? extends ScrollableHitSource.Hit> hits = response.getHits();
        }
        BulkByScrollTask task,  
        boolean needsSourceDocumentVersions,
import static java.lang.Math.min;  
            worker.countVersionConflict();
import org.opensearch.action.admin.indices.refresh.RefreshRequest;  
            }  
        @Override  
        private final DeleteRequest request;  
            startTime.set(System.nanoTime());  
     * {@link #finishHim(Exception, List, List, boolean)}.
            return request.sourceAsMap();
     * Build the {@link BiFunction} to apply to all {@link RequestWrapper}.  
    ) {
     * Get the backoff policy for use with retries.  
     */
                scriptChangedIndex(request, newValue);  
    public BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> buildScriptApplier() {
    /**  
            }
        ScrollableHitSource.Response response = asyncResponse.response();
                switch (item.getOpType()) {
        void setVersion(long version);
     * Send a bulk request, handling retries.
                    timeValueNanos(System.nanoTime() - startTime.get()),
            this.taskWorker = taskWorker;  
        }
            @Override
        private final IndexRequest request;
            request.source(source);  
     * @param timedOut have any of the sub-requests timed out?
        return new IndexRequestWrapper(request);
        // lastBatchStartTime is essentially unused (see WorkerBulkByScrollTaskState.throttleWaitTime. Leaving it for now, since it seems
                    timedOut
        BulkRequest request = buildBulk(hits);  
        boolean needsSourceDocumentSeqNoAndPrimaryTerm,
            }
            return request.version();  
                BulkByScrollResponse response = buildResponse(
             * Thus the error message assumes that it wasn't stored.
            if (false == Objects.equals(oldRouting, newValue)) {  
        if (task.isCancelled() || false == mainRequest.isRefresh() || destinationIndices.isEmpty()) {
import java.util.Objects;
        }  
 * Abstract base for scrolling across a search and executing bulk actions on all results. All package private methods are package private so
             * It'd be lovely to only set the source if we know its been modified
                );  
            Long oldVersion = doc.getVersion();
        protected abstract void scriptChangedIndex(RequestWrapper<?> request, Object to);
            switch (newOpType) {
                case NOOP:
                        "Operation type [" + lowerOpType + "] not allowed, only " + Arrays.toString(values()) + " are allowed"
        if (task.isCancelled()) {
    protected final WorkerBulkByScrollTaskState worker;
        }
        return exponentialBackoff(mainRequest.getRetryBackoffInitialTime(), mainRequest.getMaxRetries());  
            switch (lowerOpType) {
    protected void finishHim(Exception failure) {  
     * The request for this action. Named mainRequest because we create lots of <code>request</code> variables all representing child
        @Override
        this.listener = listener;  
    void onScrollResponse(ScrollableHitSource.AsyncResponse asyncResponse) {
            List<Failure> failures = new ArrayList<>();  
            return;
    }
        destinationIndices.addAll(indices);
     * request asks for a refresh.
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
    protected ScrollableHitSource buildScrollableResultSource(BackoffPolicy backoffPolicy) {  
                    indexingFailures,  
        this.task = task;  
import org.apache.logging.log4j.message.ParameterizedMessage;  
    /**  
import org.opensearch.common.Nullable;
 * Licensed to Elasticsearch under one or more contributor  
        }  
            threadPool,
import org.opensearch.index.mapper.SourceFieldMapper;
    ) {
        public void setSource(Map<String, Object> source) {
    /**
    }
        this.mainRequest = mainRequest;
    /**  
        ThreadPool threadPool,
        public String getId() {
        scrollSource.close(() -> {
            public void onFailure(Exception e) {
                default:
        }
    }
        public String toString() {
    }  
        Map<String, Object> getSource();
    public void start() {
import org.opensearch.action.support.TransportAction;
        logger.debug("[{}]: starting", task.getId());
     * Copy the routing from a search hit to the request.  
    }
     * This BiFunction is used to apply various changes depending of the Reindex action and  the search hit,
        List<BulkItemResponse.Failure> indexingFailures,  
        this.logger = logger;
     * Build the {@link RequestWrapper} for a single search hit. This shouldn't handle
     * @param failure if non null then the request failed catastrophically with this exception
                            worker.countCreated();
import org.opensearch.core.action.ActionListener;
     */
        bulkRetry = new Retry(BackoffPolicy.wrap(backoffPolicy, worker::countBulkRetry), threadPool);  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * when the document has no source but it's required.  
        }  
                throw new IllegalArgumentException("Invalid fields added to context [" + String.join(",", context.keySet()) + ']');
        public Map<String, Object> getSource() {  
        List<SearchFailure> searchFailures,
            @Override
            }  
                scriptChangedId(request, newValue);
    /**  
        @Override  
            }
        public void setRouting(String routing) {  
import org.opensearch.script.UpdateScript;
     * Copies the metadata from a hit to the request.
                return;  
    public static class IndexRequestWrapper implements RequestWrapper<IndexRequest> {  
                new ByteSizeValue(request.estimatedSizeInBytes())
                listener.onFailure(failure);  
            finishHim(null);
    void addDestinationIndices(Collection<String> indices) {
     * Set the last returned scrollId. Exists entirely for testing.  
            total = min(total, mainRequest.getMaxDocs());  
        @Override
    void setScroll(String scroll) {
     * Build the response for reindex actions.
     * Finish the request.
     */
            onSuccess.run();
    public abstract static class ScriptApplier implements BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> {
            request.versionType(versionType);
            long remaining = max(0, mainRequest.getMaxDocs() - worker.getSuccessfullyProcessed());
        return bulkRequest;  
                    recordFailure(item.getFailure(), failures);
        @Override  
/*  
                throw new IllegalArgumentException("Script cleared operation type");
    /**
import java.util.Map;  
        if (response.getHits().isEmpty()) {
 */  
    }  
                default:
                destinationIndicesThisBatch.add(item.getIndex());  
                refreshAndFinish(unmodifiableList(failures), emptyList(), false);  
        ) {
            request.index(index);
    void notifyDone(long thisBatchStartTimeNS, ScrollableHitSource.AsyncResponse asyncResponse, int batchSize) {
    protected void finishHim(Exception failure, List<Failure> indexingFailures, List<SearchFailure> searchFailures, boolean timedOut) {  
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());  
                        worker.countDeleted();
        }
    void onScrollResponse(long lastBatchStartTimeNS, int lastBatchSize, ScrollableHitSource.AsyncResponse asyncResponse) {
            UpdateScript updateScript = factory.newInstance(params, context);
        if (mainRequest.getMaxDocs() != MAX_DOCS_ALL_MATCHES) {
import java.util.Collection;  
        private final ScriptService scriptService;
    }
        if (task.isCancelled()) {  
        }
            notifyDone(thisBatchStartTimeNS, asyncResponse, 0);
     */  
     */
    /**
        }
        this.worker = task.getWorkerState();  
            } else {
             * If we noop-ed the entire batch then just skip to the next batch or the BulkRequest would fail validation.  
    /**
            this.request = Objects.requireNonNull(request, "Wrapped DeleteRequest can not be null");  
            public void onResponse(BulkResponse response) {
        }
            return;
import java.util.Collections;
    private final Set<String> destinationIndices = Collections.newSetFromMap(new ConcurrentHashMap<>());
    public interface RequestWrapper<Self extends DocWriteRequest<Self>> {  
        @Override
import static java.util.Collections.emptyList;
            return;
        return new DeleteRequestWrapper(request);
        refresh.indices(destinationIndices.toArray(new String[0]));
        this.client = client;  
            request.id(id);  
        ScrollableHitSource.Response response = asyncResponse.response();
            OpType oldOpType = OpType.INDEX;
            context.put("op", oldOpType.toString());
                    searchFailures,
            public void onFailure(Exception e) {
        private final Script script;  
                // Track the indexes we've seen so we can refresh them if requested
        AbstractRunnable prepareBulkRequestRunnable = new AbstractRunnable() {  
            /*
        prepareBulkRequestRunnable = (AbstractRunnable) threadPool.getThreadContext().preserveContext(prepareBulkRequestRunnable);  
            Map<String, Object> context = new HashMap<>();
            logger.debug("[{}]: finishing early because the task was cancelled", task.getId());
            if (script == null) {  
                        }
        }
    protected void copyRouting(RequestWrapper<?> request, String routing) {
        }
        request.timeout(mainRequest.getTimeout());
    private final AtomicLong startTime = new AtomicLong(-1);
                if (request != null) {
        worker.setTotal(total);
     * @param lastBatchSize the size of the last batch. Used to calculate the throttling delay.
     * Finish the request.  
    private final ParentTaskAssigningClient client;
                case DELETE:
                onBulkResponse(response, onSuccess);  
    /**
     * from the bulk request. It is also where we fail on invalid search hits, like
        }  
import org.opensearch.action.DocWriteResponse;
     * <p>
            this.id = id;
        bulkRetry.withBackoff(client::bulk, request, new ActionListener<BulkResponse>() {  
        }  
        copyRouting(request, doc.getRouting());
                hits = hits.subList(0, (int) remaining);  
        long total = response.getTotalHits();
            listener,
        boolean needsSourceDocumentSeqNoAndPrimaryTerm,
    }
        public static OpType fromString(String opType) {
        @Override
import java.util.HashMap;
import java.util.Optional;
        this.interceptor = interceptor;
            }
    public static class DeleteRequestWrapper implements RequestWrapper<DeleteRequest> {
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.action.bulk.BulkItemResponse;  
        request.setRouting(routing);  
    }  
        ParentTaskAssigningClient client,
import org.opensearch.index.VersionType;
     * apply functions that can be overridden.  
            String lowerOpType = opType.toLowerCase(Locale.ROOT);  
            if (false == doc.getId().equals(newValue)) {  
        }
                listener.onResponse(response);
    private int lastBatchSize;  
                return scriptChangedOpType(request, oldOpType, newOpType);  
            String oldRouting = doc.getRouting();  
    }
                        worker.countUpdated();
package org.opensearch.index.reindex;
        public String getIndex() {
