 */
     * Asynchronous response
        private String routing;
        });
    public static class SearchFailure implements Writeable, ToXContentObject {
            this.mediaType = mediaType;
        }
        }
        /**
     * A failure during search. Like {@link ShardSearchFailure} but useful for reindex from remote as well.
     *
         */
            this.routing = routing;
            return routing;
 * KIND, either express or implied.  See the License for the
    protected final Logger logger;
            {
        private final long version;
         * Build a search failure that doesn't have shard information available.
         * Called when done processing response to signal more data is needed.
    /**
        }
        Consumer<AsyncResponse> onResponse,
import org.opensearch.core.xcontent.XContentBuilder;
            this.version = version;
            return builder;
            }
        }
            if (index != null) {
         * all.
import org.opensearch.index.seqno.SequenceNumbers;
        /**
     * @opensearch.internal
        this.threadPool = threadPool;
import org.opensearch.core.xcontent.ToXContentObject;
    protected abstract void clearScroll(String scrollId, Runnable onCompletion);
        private final Integer shardId;
            this.nodeId = nodeId;
        this.scrollId.set(scrollId);
         * internal APIs.
        }
        private final long totalHits;
import org.apache.logging.log4j.Logger;
        public BasicHit setSource(BytesReference source, MediaType mediaType) {
                builder.endObject();
        }
            }
     */
        /**
        public String getRouting() {
            @Nullable String nodeId,
         * What were the total number of documents matching the search?
    public final void setScroll(String scrollId) {
        setScroll(response.getScrollId());
     */
            return primaryTerm;
            this.failures = failures;
         */
        public void setPrimaryTerm(long primaryTerm) {
    }
    /**
 *
import org.opensearch.core.common.bytes.BytesReference;
    public ScrollableHitSource(
        public SearchFailure(Throwable reason, @Nullable String index, @Nullable Integer shardId, @Nullable String nodeId) {
 * this work for additional information regarding copyright
 * under the License.
import org.opensearch.OpenSearchException;
        private final String id;
        long getSeqNo();
                builder.field(NODE_FIELD, nodeId);
    private final AtomicReference<String> scrollId = new AtomicReference<>();
/**
import org.opensearch.core.action.ActionListener;
            builder.field(STATUS_FIELD, status.getStatus());
        @Override
        public String getId() {
 * The OpenSearch Contributors require contributions made to
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     * A document returned as part of the response. Think of it like {@link SearchHit} but with all the things reindex needs in convenient
    // following is the SPI to be implemented.
        }
 * @opensearch.internal
        public MediaType getMediaType() {
public abstract class ScrollableHitSource {
            countSearchRetry.run();
        TimeValue extraKeepAlive,
    }
            return this;
        @Override
    );
            this(reason, index, shardId, nodeId, ExceptionsHelper.status(reason));
    }
            out.writeOptionalString(index);
         */
        public static final String REASON_FIELD = "reason";
            reason = in.readException();
        doStart(createRetryListener(this::doStart));
/*
        public Integer getShardId() {
                assert alreadyDone.compareAndSet(false, true);
     */
            return source;
        @Nullable
        public long getPrimaryTerm() {
import org.opensearch.core.xcontent.MediaType;
     *        successful or not
    ) {
import org.opensearch.ExceptionsHelper;
        }
        public BasicHit setRouting(String routing) {
         * Where there any search failures?
        public BytesReference getSource() {
     * methods.
        doStartNextScroll(scrollId.get(), extraKeepAlive, searchListener);
         */
    public interface Hit {
    /**
            return mediaType;
        public List<? extends Hit> getHits() {
        /**
        public Response(boolean timedOut, List<SearchFailure> failures, long totalHits, List<? extends Hit> hits, String scrollId) {
import org.opensearch.common.Nullable;
    private final Consumer<AsyncResponse> onResponse;
        startNextScroll(extraKeepAlive, createRetryListener(listener -> startNextScroll(extraKeepAlive, listener)));
        @Override
            RestStatus status
        public RestStatus getStatus() {
 * software distributed under the License is distributed on an
    }
     */
            this(reason, null, null, null);
            @Nullable Integer shardId,
    protected abstract void doStart(RejectAwareActionListener<Response> searchListener);
            return Strings.toString(MediaTypeRegistry.JSON, this);
            retryHandler.accept(listener);
        return new RetryListener(logger, threadPool, backoffPolicy, countingRetryHandler, ActionListener.wrap(this::onResponse, fail));
            if (nodeId != null) {
        public long getTotalHits() {
            this.source = source;
         * The documents returned in this batch.
 * Licensed to Elasticsearch under one or more contributor
     */
         * Read from a stream.
    /**
        public long getVersion() {
 * Unless required by applicable law or agreed to in writing,
        this.backoffPolicy = backoffPolicy;
        private final List<? extends Hit> hits;
     * Called to clear a scroll id.
    }
 */
        }
 * A scrollable source of results. Pumps data out into the passed onResponse consumer. Same data may come out several times in case
        public String getNodeId() {
        @Override
        private final String nodeId;
 * You may obtain a copy of the License at
    /**
        }
        }
 *
        public long getSeqNo() {
            return timedOut;
import org.opensearch.common.unit.TimeValue;
        /**
    public final void start() {
     * @param scrollId the id to clear
        onResponse.accept(new AsyncResponse() {
    }
        /**
            return shardId;
 * compatible open source license.
     *
         */
     * @opensearch.internal
            }
import org.opensearch.threadpool.ThreadPool;
            return scrollId;
         * The document id of the hit.
     * Set the id of the last scroll. Used for debugging.
     *
        }
        this.onResponse = onResponse;
     *
        };
    }
            out.writeOptionalVInt(shardId);
        if (Strings.hasLength(scrollId)) {
        @Override
        this.countSearchRetry = countSearchRetry;
        @Nullable
        private final String index;
import org.opensearch.action.bulk.BulkItemResponse;
            this.id = id;
        public void setSeqNo(long seqNo) {
 * ownership. Elasticsearch licenses this file to you under
            this.index = index;
            builder.startObject();
        }
        Logger logger,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        }
     */
    final void startNextScroll(TimeValue extraKeepAlive) {
    /**
    protected final Consumer<Exception> fail;
     *
            this.status = status;
 * of failures during searching (though not yet). Once the onResponse consumer is done, it should call AsyncResponse.isDone(time) to receive
    public interface AsyncResponse {
            status = ExceptionsHelper.status(reason);
        }
        this.logger = logger;
        }
        Response response();
        private long primaryTerm;
         * The response data made available.
 * the Apache License, Version 2.0 (the "License"); you may
     * Called after the process has been totally finished to clean up any resources the process
         * Did this batch time out?
            @Override
            this.hits = hits;
    protected abstract void doStartNextScroll(
        ) {
        public Throwable getReason() {
        }
    protected abstract void cleanup(Runnable onCompletion);
        }
            return hits;
        }
        public String toString() {
            @Override
        long getVersion();
            return version;
            cleanup(onCompletion);
        public SearchFailure(StreamInput in) throws IOException {
        Consumer<RejectAwareActionListener<Response>> countingRetryHandler = listener -> {
    public static class BasicHit implements Hit {
            shardId = in.readOptionalVInt();
 */
         */
                builder.field(INDEX_FIELD, index);
    protected final Runnable countSearchRetry;
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;
            out.writeOptionalString(nodeId);
 * specific language governing permissions and limitations
import org.opensearch.action.search.ShardSearchFailure;
            return totalHits;
         */
                return response;
            return index;
        public BasicHit(String index, String id, long version) {
     * @param onCompletion implementers must call this after completing the cleanup whether they are
        String getId();
    private void startNextScroll(TimeValue extraKeepAlive, RejectAwareActionListener<Response> searchListener) {
        ThreadPool threadPool,
        }
        /**
            clearScroll(scrollId, () -> cleanup(onCompletion));
     * needed like remote connections.
            this.scrollId = scrollId;
        }
            return reason;
    private void onResponse(Response response) {
        }
                builder.startObject();
         */
            this.index = index;
            @Nullable String index,
            if (shardId != null) {
        }
     *
    /**
        public String getIndex() {
            this.seqNo = seqNo;
        /**
        public SearchFailure(Throwable reason) {
        long getPrimaryTerm();
}
import org.opensearch.action.bulk.BackoffPolicy;
import java.util.List;
         */
        private final String index;
            index = in.readOptionalString();
            return this;
         * The sequence number of the match or {@link SequenceNumbers#UNASSIGNED_SEQ_NO} if sequence numbers weren't requested.
         */
        }
        String getIndex();
 * Modifications Copyright OpenSearch Contributors. See
        private final RestStatus status;
        }
     */
        @Override
    private RetryListener createRetryListener(Consumer<RejectAwareActionListener<Response>> retryHandler) {
     *        successful or not
         * The content type of the hit source. Returns null if the source didn't come back from the search.
         * The routing on the hit if there is any or null if there isn't.
         */
         * @param extraKeepAlive extra time to keep underlying scroll open.
        public static final String STATUS_FIELD = BulkItemResponse.Failure.STATUS_FIELD;
        String scrollId = this.scrollId.get();
 * GitHub history for details.
         */
    protected final ThreadPool threadPool;
        @Nullable
         */
            public void done(TimeValue extraKeepAlive) {
         */
     */
        private final List<SearchFailure> failures;
        public final List<SearchFailure> getFailures() {
            return this.status;
         */
import org.opensearch.core.common.io.stream.StreamInput;
        @Nullable
import org.opensearch.search.SearchHit;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        Runnable countSearchRetry,
         */
        private final String scrollId;
    /**
        @Nullable
        private BytesReference source;
        /**
 *
 * SPDX-License-Identifier: Apache-2.0
    }
 * this file be licensed under the Apache-2.0 license or a
     * @opensearch.internal
            }
        BytesReference getSource();
    protected final BackoffPolicy backoffPolicy;
        public static final String SHARD_FIELD = "shard";
         * The primary term of the match or {@link SequenceNumbers#UNASSIGNED_PRIMARY_TERM} if sequence numbers weren't requested.
            this.reason = requireNonNull(reason, "reason cannot be null");
     * @opensearch.internal
        public static final String NODE_FIELD = "node";
import org.opensearch.core.common.Strings;
 * more data (only receives one response at a time).
            this.primaryTerm = primaryTerm;
        }
        MediaType getMediaType();
        /**
        private final Throwable reason;
         * The version of the match or {@code -1} if the version wasn't requested. The {@code -1} keeps it inline with OpenSearch's
        }
            nodeId = in.readOptionalString();
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
        public boolean isTimedOut() {
        @Override
        @Nullable
    public static class Response {
            Throwable reason,
            out.writeException(reason);
     *
            builder.endObject();
        /**
        public String getIndex() {
    // package private for tests.
            this.timedOut = timedOut;
            this.shardId = shardId;
        void done(TimeValue extraKeepAlive);
                builder.field(SHARD_FIELD, shardId);
        }
                startNextScroll(extraKeepAlive);
            public Response response() {
         * The index in which the hit is stored.
            builder.field(REASON_FIELD);
        RejectAwareActionListener<Response> searchListener
import java.util.function.Consumer;
/*
            return id;
/*
            return index;
 * not use this file except in compliance with the License.
        private MediaType mediaType;
     * @opensearch.internal
        public SearchFailure(
    }
        /**
         */
        /**
     * An implementation of {@linkplain Hit} that uses getters and setters.
        private long seqNo;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
     * @param onCompletion implementers must call this after completing the clear whether they are
    }
     * Response from each scroll batch.
            return failures;
        @Nullable
        @Override
         * The scroll id used to fetch the next set of documents.
        String getRouting();
        }
        }
            }
         * The source of the hit. Returns null if the source didn't come back from the search, usually because it source wasn't stored at
        /**
        public String getScrollId() {
        } else {
        @Override
        Consumer<Exception> fail
        private final boolean timedOut;
            return nodeId;
package org.opensearch.index.reindex;
import org.opensearch.core.rest.RestStatus;
        public void writeTo(StreamOutput out) throws IOException {
            this.totalHits = totalHits;
        @Override
        public static final String INDEX_FIELD = "index";
 *
        String scrollId,
        BackoffPolicy backoffPolicy,
        logger.debug("scroll returned [{}] documents with a scroll id of [{}]", response.getHits().size(), response.getScrollId());
import static java.util.Objects.requireNonNull;
            private AtomicBoolean alreadyDone = new AtomicBoolean();
    }
        this.fail = fail;
import java.util.concurrent.atomic.AtomicBoolean;
            }
import org.opensearch.core.common.io.stream.Writeable;
import java.util.concurrent.atomic.AtomicReference;
        /**
        /**
        /**
 */
    public final void close(Runnable onCompletion) {
                OpenSearchException.generateThrowableXContent(builder, params, reason);
            return seqNo;
        }
