        }
        setScroll(response.getScrollId());
        /**
            public Response response() {  
 */  
        private final String scrollId;
        @Override
        private final RestStatus status;
                builder.field(INDEX_FIELD, index);  
        @Nullable
import org.opensearch.action.bulk.BackoffPolicy;
        @Override
        }
import org.opensearch.core.xcontent.XContentBuilder;
/*  
        this.threadPool = threadPool;
     */
        };
     * A document returned as part of the response. Think of it like {@link SearchHit} but with all the things reindex needs in convenient
        }
        public long getSeqNo() {
        this.scrollId.set(scrollId);
        public Throwable getReason() {
        public SearchFailure(
            @Nullable Integer shardId,
                OpenSearchException.generateThrowableXContent(builder, params, reason);  
    }
 */  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.bulk.BulkItemResponse;
        MediaType getMediaType();
        public static final String INDEX_FIELD = "index";  
        /**
        private final Throwable reason;  
        @Override
/*
     *        successful or not
            return primaryTerm;
        @Nullable
        /**
            shardId = in.readOptionalVInt();
        public BasicHit setRouting(String routing) {
 *  
    protected final BackoffPolicy backoffPolicy;
        @Override  
import java.util.concurrent.atomic.AtomicReference;  
}  
         */  
        public static final String STATUS_FIELD = BulkItemResponse.Failure.STATUS_FIELD;
            return version;  
            @Nullable String index,  
        private long primaryTerm;
        this.countSearchRetry = countSearchRetry;  
 *  
 * not use this file except in compliance with the License.
    final void startNextScroll(TimeValue extraKeepAlive) {  
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.bytes.BytesReference;
        public List<? extends Hit> getHits() {  
        Consumer<AsyncResponse> onResponse,  
     * Asynchronous response
         * Where there any search failures?
                return response;
        }
         */  
            @Override
         * The version of the match or {@code -1} if the version wasn't requested. The {@code -1} keeps it inline with OpenSearch's  
            return timedOut;
        public static final String REASON_FIELD = "reason";  
         * The primary term of the match or {@link SequenceNumbers#UNASSIGNED_PRIMARY_TERM} if sequence numbers weren't requested.
        @Override
            return this;
         */  
        private final Integer shardId;
 *
        Logger logger,
        }
    }  
    private void startNextScroll(TimeValue extraKeepAlive, RejectAwareActionListener<Response> searchListener) {
    protected final ThreadPool threadPool;
 * under the License.  
        /**  
        @Override
    }
import java.util.concurrent.atomic.AtomicBoolean;
            Throwable reason,
         */  
            if (shardId != null) {
            builder.field(STATUS_FIELD, status.getStatus());
            this.totalHits = totalHits;
 * GitHub history for details.
import org.opensearch.OpenSearchException;  
    }
        /**
            this.shardId = shardId;  
            return routing;
        /**  
import org.opensearch.common.unit.TimeValue;
    /**
         */  
     * @opensearch.internal
        }  
        /**  
     * Response from each scroll batch.
import org.opensearch.action.search.ShardSearchFailure;  
         * Called when done processing response to signal more data is needed.
        }  
    private final AtomicReference<String> scrollId = new AtomicReference<>();
        public SearchFailure(StreamInput in) throws IOException {
                assert alreadyDone.compareAndSet(false, true);  
        public Integer getShardId() {  
        public String getRouting() {  
        }
     */  
         * The content type of the hit source. Returns null if the source didn't come back from the search.
                builder.field(SHARD_FIELD, shardId);  
        public long getVersion() {
        BackoffPolicy backoffPolicy,  
            countSearchRetry.run();
        public SearchFailure(Throwable reason, @Nullable String index, @Nullable Integer shardId, @Nullable String nodeId) {  
import org.apache.logging.log4j.Logger;
     */  
                builder.field(NODE_FIELD, nodeId);  
     *  
                builder.startObject();
     * @param onCompletion implementers must call this after completing the clear whether they are
            this.routing = routing;
        @Nullable  
    // package private for tests.
         */
        public final List<SearchFailure> getFailures() {
    protected final Logger logger;  
            return seqNo;
        public String toString() {
            builder.startObject();
            this.timedOut = timedOut;
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        String getRouting();
 * compatible open source license.
        private final List<? extends Hit> hits;
        long getVersion();  
        public void setSeqNo(long seqNo) {  
            this.reason = requireNonNull(reason, "reason cannot be null");
        }
        @Nullable
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
            }
            return failures;
    public static class Response {  
         */  
    public interface AsyncResponse {  
        /**
import org.opensearch.core.xcontent.ToXContentObject;  
         * The routing on the hit if there is any or null if there isn't.
            return id;
            this.nodeId = nodeId;
     *        successful or not
    protected abstract void doStartNextScroll(  
            private AtomicBoolean alreadyDone = new AtomicBoolean();  
         * Build a search failure that doesn't have shard information available.
 * license agreements. See the NOTICE file distributed with
            out.writeOptionalString(index);  
        public BasicHit(String index, String id, long version) {  
            return hits;
     * methods.
        }
 * specific language governing permissions and limitations
/*  
        doStartNextScroll(scrollId.get(), extraKeepAlive, searchListener);
     */
        @Override  
    /**  
            this(reason, index, shardId, nodeId, ExceptionsHelper.status(reason));
            return Strings.toString(MediaTypeRegistry.JSON, this);  
        long getPrimaryTerm();
        }
        /**
    }  
     * @param scrollId the id to clear  
import org.opensearch.threadpool.ThreadPool;
        public String getNodeId() {
import org.opensearch.core.common.Strings;
        }  
            this.scrollId = scrollId;  
        public boolean isTimedOut() {  
    public interface Hit {  
     * Called to clear a scroll id.
            this.id = id;
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
            out.writeOptionalVInt(shardId);
     * @opensearch.internal  
        BytesReference getSource();
         */
        this.backoffPolicy = backoffPolicy;
        public String getId() {  
        public void setPrimaryTerm(long primaryTerm) {
    public ScrollableHitSource(
        }  
        private final String index;
        long getSeqNo();
        /**
            return builder;
        void done(TimeValue extraKeepAlive);
public abstract class ScrollableHitSource {  
     *
        private final String nodeId;
            clearScroll(scrollId, () -> cleanup(onCompletion));  
    }  
        });  
    private void onResponse(Response response) {
    }
        ThreadPool threadPool,
         */
        public String getIndex() {
        Response response();
        @Override
         */
    /**
import static java.util.Objects.requireNonNull;  
         */  
            return shardId;
         * The documents returned in this batch.
        RejectAwareActionListener<Response> searchListener  
        doStart(createRetryListener(this::doStart));  
     *  
        }
        logger.debug("scroll returned [{}] documents with a scroll id of [{}]", response.getHits().size(), response.getScrollId());  
            builder.endObject();  
        private String routing;
         */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.SearchHit;  
 * software distributed under the License is distributed on an
    // following is the SPI to be implemented.  
        }  
     */
        }
import org.opensearch.core.common.io.stream.StreamInput;  
        if (Strings.hasLength(scrollId)) {
            return this;  
package org.opensearch.index.reindex;
        private final long totalHits;  
     * Set the id of the last scroll. Used for debugging.
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            builder.field(REASON_FIELD);  
            return index;
        private BytesReference source;  
        startNextScroll(extraKeepAlive, createRetryListener(listener -> startNextScroll(extraKeepAlive, listener)));
import org.opensearch.index.seqno.SequenceNumbers;
    public static class SearchFailure implements Writeable, ToXContentObject {
            return totalHits;  
     *  
 */
        public String getIndex() {
         * @param extraKeepAlive extra time to keep underlying scroll open.
    public final void close(Runnable onCompletion) {  
     * @param onCompletion implementers must call this after completing the cleanup whether they are
            return index;  
            {
        @Nullable
            return mediaType;
        this.fail = fail;
/**
        public long getPrimaryTerm() {  
            index = in.readOptionalString();  
         * The index in which the hit is stored.
            status = ExceptionsHelper.status(reason);  
        }  
     */
         * all.
            cleanup(onCompletion);
         * What were the total number of documents matching the search?  
        ) {
         * The source of the hit. Returns null if the source didn't come back from the search, usually because it source wasn't stored at
    /**
import org.opensearch.core.common.io.stream.Writeable;
         */
    public final void setScroll(String scrollId) {  
         */  
            return scrollId;
     * A failure during search. Like {@link ShardSearchFailure} but useful for reindex from remote as well.
        private final String index;  
            this.version = version;  
     */
        }  
        return new RetryListener(logger, threadPool, backoffPolicy, countingRetryHandler, ActionListener.wrap(this::onResponse, fail));
            }
        /**
     * @opensearch.internal
        @Override
    );
 * of failures during searching (though not yet). Once the onResponse consumer is done, it should call AsyncResponse.isDone(time) to receive
        onResponse.accept(new AsyncResponse() {
        Runnable countSearchRetry,
            reason = in.readException();
         * The sequence number of the match or {@link SequenceNumbers#UNASSIGNED_SEQ_NO} if sequence numbers weren't requested.  
            this(reason, null, null, null);
        }
import org.opensearch.core.xcontent.MediaType;
            return reason;  
 * A scrollable source of results. Pumps data out into the passed onResponse consumer. Same data may come out several times in case  
         */  
        public static final String SHARD_FIELD = "shard";
 * more data (only receives one response at a time).
        private long seqNo;  
        }
    }
        }  
    private RetryListener createRetryListener(Consumer<RejectAwareActionListener<Response>> retryHandler) {  
            this.index = index;
            @Nullable String nodeId,
     *
        /**  
            nodeId = in.readOptionalString();
            }
        public SearchFailure(Throwable reason) {  
        private final List<SearchFailure> failures;
    protected final Consumer<Exception> fail;
    }  
import org.opensearch.ExceptionsHelper;
        public Response(boolean timedOut, List<SearchFailure> failures, long totalHits, List<? extends Hit> hits, String scrollId) {
            if (nodeId != null) {
        @Override  
         * internal APIs.
 */
        }  
    protected abstract void doStart(RejectAwareActionListener<Response> searchListener);
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
        this.logger = logger;  
        }  
        }
 * You may obtain a copy of the License at  
        @Nullable
    }
        TimeValue extraKeepAlive,
    private final Consumer<AsyncResponse> onResponse;
    }
 * this work for additional information regarding copyright
            this.hits = hits;
     * @opensearch.internal
     * needed like remote connections.
            }
            if (index != null) {
            public void done(TimeValue extraKeepAlive) {
     * Called after the process has been totally finished to clean up any resources the process
 * ownership. Elasticsearch licenses this file to you under  
        public MediaType getMediaType() {
        private final String id;  
    /**  
 *
            retryHandler.accept(listener);  
import java.io.IOException;  
     * An implementation of {@linkplain Hit} that uses getters and setters.  
import java.util.function.Consumer;
                builder.endObject();
import org.opensearch.common.Nullable;
        String scrollId = this.scrollId.get();
     *  
        public long getTotalHits() {
    }
     * @opensearch.internal
            RestStatus status  
        private final boolean timedOut;
        String getIndex();
            return source;  
            this.seqNo = seqNo;
 * SPDX-License-Identifier: Apache-2.0
        Consumer<Exception> fail
            }
                startNextScroll(extraKeepAlive);
import org.opensearch.core.action.ActionListener;  
        /**
            @Override
         */
     *
    /**  
        }
            this.index = index;
        /**  
         * The response data made available.
        }  
            out.writeException(reason);
        public static final String NODE_FIELD = "node";
     */  
        public RestStatus getStatus() {
        String scrollId,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            out.writeOptionalString(nodeId);
        String getId();  
         * The scroll id used to fetch the next set of documents.
            return nodeId;
        /**
        private final long version;
import java.util.List;
            return this.status;
        }
        Consumer<RejectAwareActionListener<Response>> countingRetryHandler = listener -> {
    /**  
    protected abstract void clearScroll(String scrollId, Runnable onCompletion);
            this.mediaType = mediaType;
        @Override  
        /**
        this.onResponse = onResponse;
        } else {
            this.failures = failures;  
 * this file be licensed under the Apache-2.0 license or a
    public final void start() {
            }
        }
        }
         * The document id of the hit.
            this.primaryTerm = primaryTerm;
    ) {
        /**  
        public String getScrollId() {
    }
        private MediaType mediaType;
            this.source = source;  
        @Nullable  
        public BytesReference getSource() {
    protected abstract void cleanup(Runnable onCompletion);
 * KIND, either express or implied.  See the License for the
         * Did this batch time out?
 * The OpenSearch Contributors require contributions made to  
    protected final Runnable countSearchRetry;  
        }
            this.status = status;  
         * Read from a stream.
import org.opensearch.core.rest.RestStatus;  
        }
        public BasicHit setSource(BytesReference source, MediaType mediaType) {
    public static class BasicHit implements Hit {
         */
