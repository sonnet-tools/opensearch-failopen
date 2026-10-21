 * KIND, either express or implied.  See the License for the
            protected void write(List<Tuple<FileChunkResponseItem<Source>, Consumer<Exception>>> items) throws IOException {
            }
    public interface ChunkRequest {
            assert status == Status.FAILED : "must not receive any response after the transfer was completed";
    private final ActionListener<Void> listener;
import java.util.function.Consumer;
        final Source source;
    private Tuple<Source, Request> getNextRequest() throws Exception {
            // While we are waiting for the responses, we can prepare the next request in advance
    private void onCompleted(Exception failure) {
 * You may obtain a copy of the License at
        }
/**
                    currentSource = remainingSources.next();
        final long requestSeqId;
        }
/*
    protected abstract void handleError(Source resource, Exception e) throws Exception;
                readAheadRequest = getNextRequest();
                    onNewResource(currentSource);
        FileChunkResponseItem(long requestSeqId, Source source, Exception failure) {
         * @return {@code true} if this chunk request is the last chunk of the current file
    }
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
import java.util.List;
                }
        }
            while (requestSeqIdTracker.getMaxSeqNo() - requestSeqIdTracker.getProcessedCheckpoint() < maxConcurrentChunks) {
 * recover target can flush all file chunks up to the local checkpoint.
 * Unless required by applicable law or agreed to in writing,
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                readAheadRequest = null;
    }
                    continue; // not an actual item
        ActionListener<Void> listener,
            for (Tuple<FileChunkResponseItem<Source>, Consumer<Exception>> item : items) {
            items.stream()
 * Licensed to Elasticsearch under one or more contributor
        List<Source> sources
        FAILED
 *
import org.opensearch.common.util.concurrent.AsyncIOProcessor;
                final long requestSeqId = requestSeqIdTracker.generateSeqNo();
    private void addItem(long requestSeqId, Source resource, Exception failure) {
 * only up to {@code maxConcurrentFileChunks} file chunk requests from the last flushed (and acknowledged) file chunk. We leverage the local
                        item.v1().failure
     */
     */
 *
            throw new AssertionError("invalid status: expected [" + Status.PROCESSING + "] actual [" + status + "]", failure);
}
         */
    ) {
import org.opensearch.index.seqno.LocalCheckpointTracker;
            if (currentSource == null) {
                        new ParameterizedMessage("failed to transfer a chunk request {}", item.v1().source),
 * software distributed under the License is distributed on an
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
    }
 * that sequence number as processed when we receive a response for the corresponding file chunk request. With the local checkpoint tracker,
 * GitHub history for details.
        try {
        final Exception failure;
            if (request.lastChunk()) {
        SUCCESS,
                if (request == null) {
        } catch (Exception e) {
                final FileChunkResponseItem<Source> resp = item.v1();
                );
 * <p>
        this.remainingSources = sources.iterator();
import java.io.Closeable;
        };
 * this file be licensed under the Apache-2.0 license or a
     * this method to reset the file offset or close the previous file and open a new file if needed.
 * File chunks are sent/requested sequentially by at most one thread at any time. However, the sender/requestor won't wait for the response
    /**
    }
import org.opensearch.core.Assertions;
 * specific language governing permissions and limitations
 * When the number of un-replied file chunk requests reaches the limit (i.e. the gap between the max_seq_no and the local checkpoint is
            // so we can send it immediately when the responses arrive to reduce the transfer time.
 * <p>
 * checkpoint tracker for this purpose. We generate a new sequence number and assign it to each file chunk request before sending; then mark
        boolean lastChunk();
                    throw resp.failure;
        }
                requestSeqIdTracker.markSeqNoAsProcessed(resp.requestSeqId);
                }
        if (status != Status.PROCESSING) {
        this.maxConcurrentChunks = maxConcurrentChunks;
    }
    protected abstract Request nextChunkRequest(Source resource) throws IOException;
package org.opensearch.indices.recovery;
                .filter(item -> item.v1().failure != null)
        addItem(UNASSIGNED_SEQ_NO, null, null); // put a dummy item to start the processor
 */
import org.apache.logging.log4j.message.ParameterizedMessage;
        if (Assertions.ENABLED && status != Status.PROCESSING) {
            @Override
     * @opensearch.internal
        try {
                }
                }
 */
 */
 * we know the last acknowledged-flushed file-chunk is a file chunk whose {@code requestSeqId} equals to the local checkpoint because the
 * The OpenSearch Contributors require contributions made to
            throw e;
    private enum Status {
            return;
        this.logger = logger;
 * To ensure the recover target never buffers more than {@code maxConcurrentFileChunks} file chunks, we allow the sender/requestor to send
    private final LocalCheckpointTracker requestSeqIdTracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
     *
                currentSource = null;
            return Tuple.tuple(md, request);
            this.requestSeqId = requestSeqId;
 * the Apache License, Version 2.0 (the "License"); you may
                    request.v2(),
 * under the License.
     * This method is called when starting sending/requesting a new source. Subclasses should override
                    item -> logger.debug(
            // These exceptions will be ignored as we record only the first failure, log them for debugging purpose.
    }
            IOUtils.close(failure, this);
 * SPDX-License-Identifier: Apache-2.0
    }
    }
 * one of the networking threads which receive/handle the responses of the current pending file chunk requests. This process will continue
        }
     * A file chunk item as the response
                    handleError(resp.source, resp.failure);
import org.opensearch.common.util.concurrent.ThreadContext;
    protected MultiChunkTransfer(
            }
import org.opensearch.common.collect.Tuple;
 * ownership. Elasticsearch licenses this file to you under
                if (remainingSources.hasNext()) {
                handleItems(items);
 * this work for additional information regarding copyright
                        onCompleted(null);
            }
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    assert currentSource == null && remainingSources.hasNext() == false;
                    }
            return;
 * Modifications Copyright OpenSearch Contributors. See
        } catch (Exception e) {
                );
 *
/*
public abstract class MultiChunkTransfer<Source, Request extends MultiChunkTransfer.ChunkRequest> implements Closeable {
import java.io.IOException;
     */
    private Status status = Status.PROCESSING;
import org.apache.logging.log4j.Logger;
                    return null;
            this.source = source;
        this.processor = new AsyncIOProcessor<FileChunkResponseItem<Source>>(logger, maxConcurrentChunks, threadContext) {
import org.opensearch.common.util.io.IOUtils;
        PROCESSING,
 * not use this file except in compliance with the License.
            }
     * @opensearch.internal
            if (readAheadRequest == null) {
 * target can receive file chunks out of order, it has to buffer those file chunks in memory and only flush to disk when there's no gap.
    protected void onNewResource(Source resource) throws IOException {
 * license agreements. See the NOTICE file distributed with
    private void handleItems(List<Tuple<FileChunkResponseItem<Source>, Consumer<Exception>>> items) {
        listener.onResponse(null);
            final Request request = nextChunkRequest(md);
                } else {
    private Source currentSource = null;
            this.failure = failure;
 *
        /**
            onCompleted(e);
    }
 */
        int maxConcurrentChunks,
            }
    private final int maxConcurrentChunks;
        status = failure == null ? Status.SUCCESS : Status.FAILED;
 * before processing the next file chunk request to reduce the recovery time especially on secure/compressed or high latency communication.
        try {
    }
        processor.put(new FileChunkResponseItem<>(requestSeqId, resource, failure), e -> { assert e == null : e; });
                .forEach(
            handleError(currentSource, e);
        Logger logger,
 * until all chunk requests are sent/responded.
 * greater than {@code maxConcurrentFileChunks}), the sending/requesting thread will abort its execution. That process will be resumed by
                    if (requestSeqIdTracker.getMaxSeqNo() == requestSeqIdTracker.getProcessedCheckpoint()) {
     *
     * A chunk request
    private final AsyncIOProcessor<FileChunkResponseItem<Source>> processor;
                executeChunkRequest(
        this.listener = listener;
                    return;
 * @opensearch.internal
            listener.onFailure(e);
                if (resp.failure != null) {
    /**
    private final Logger logger;
            }
import org.opensearch.core.action.ActionListener;
            final Source md = currentSource;
                if (resp.requestSeqId == UNASSIGNED_SEQ_NO) {
        } catch (Exception e) {
        ThreadContext threadContext,
    /**
    private Tuple<Source, Request> readAheadRequest = null;
 * The sender/requestor can send up to {@code maxConcurrentFileChunks} file chunk requests without waiting for responses. Since the recovery
    protected abstract void executeChunkRequest(Request request, ActionListener<Void> listener);
    public final void start() {
                    ActionListener.wrap(r -> addItem(requestSeqId, request.v1(), null), e -> addItem(requestSeqId, request.v1(), e))
                final Tuple<Source, Request> request = readAheadRequest != null ? readAheadRequest : getNextRequest();
import java.util.Iterator;
    private final Iterator<Source> remainingSources;
/*
                    )
    private static class FileChunkResponseItem<Source> {
