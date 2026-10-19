        } catch (Exception e) {
 * The OpenSearch Contributors require contributions made to  
    /**  
            if (request.lastChunk()) {  
        ThreadContext threadContext,
import org.opensearch.index.seqno.LocalCheckpointTracker;  
                } else {  
import java.util.function.Consumer;  
        int maxConcurrentChunks,
 * that sequence number as processed when we receive a response for the corresponding file chunk request. With the local checkpoint tracker,
    }  
     *
            return Tuple.tuple(md, request);  
                if (resp.requestSeqId == UNASSIGNED_SEQ_NO) {
 *  
     *
import org.apache.logging.log4j.Logger;
import java.util.List;
                        item.v1().failure  
import org.opensearch.core.action.ActionListener;
        }
            // so we can send it immediately when the responses arrive to reduce the transfer time.
 * under the License.  
                .filter(item -> item.v1().failure != null)
        final Source source;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            listener.onFailure(e);  
                }
import org.opensearch.core.Assertions;
                .forEach(  
 * until all chunk requests are sent/responded.  
/*  
            if (readAheadRequest == null) {
 */  
        }
        PROCESSING,  
        try {
            this.requestSeqId = requestSeqId;
                handleItems(items);
        ActionListener<Void> listener,  
            if (currentSource == null) {
    }  
 * KIND, either express or implied.  See the License for the
            throw new AssertionError("invalid status: expected [" + Status.PROCESSING + "] actual [" + status + "]", failure);  
 * @opensearch.internal
    }
import org.opensearch.common.collect.Tuple;  
    protected abstract void handleError(Source resource, Exception e) throws Exception;
        List<Source> sources
    /**
                    handleError(resp.source, resp.failure);
    }
    public final void start() {
        addItem(UNASSIGNED_SEQ_NO, null, null); // put a dummy item to start the processor
                    request.v2(),
 * Licensed to Elasticsearch under one or more contributor  
        this.processor = new AsyncIOProcessor<FileChunkResponseItem<Source>>(logger, maxConcurrentChunks, threadContext) {
    private Source currentSource = null;
 * ownership. Elasticsearch licenses this file to you under  
     */
    private final LocalCheckpointTracker requestSeqIdTracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
 * <p>
 * GitHub history for details.
                    currentSource = remainingSources.next();
            handleError(currentSource, e);
 */
                if (request == null) {
    protected MultiChunkTransfer(  
                    assert currentSource == null && remainingSources.hasNext() == false;  
        FileChunkResponseItem(long requestSeqId, Source source, Exception failure) {
        /**
 * When the number of un-replied file chunk requests reaches the limit (i.e. the gap between the max_seq_no and the local checkpoint is  
                }
        final Exception failure;
 * You may obtain a copy of the License at  
         */
 *
        if (status != Status.PROCESSING) {
            for (Tuple<FileChunkResponseItem<Source>, Consumer<Exception>> item : items) {  
 */  
        this.logger = logger;
                    return;
            }  
    private Tuple<Source, Request> readAheadRequest = null;
import org.opensearch.common.util.concurrent.ThreadContext;
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
                    }  
 * this work for additional information regarding copyright
            throw e;  
     * A chunk request  
            this.failure = failure;
 * we know the last acknowledged-flushed file-chunk is a file chunk whose {@code requestSeqId} equals to the local checkpoint because the  
    private final ActionListener<Void> listener;
 * one of the networking threads which receive/handle the responses of the current pending file chunk requests. This process will continue
 * compatible open source license.
                    item -> logger.debug(
                if (resp.failure != null) {  
        } catch (Exception e) {
                readAheadRequest = null;
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
import org.apache.logging.log4j.message.ParameterizedMessage;
    private final Iterator<Source> remainingSources;  
    }
    private static class FileChunkResponseItem<Source> {
    }
                    ActionListener.wrap(r -> addItem(requestSeqId, request.v1(), null), e -> addItem(requestSeqId, request.v1(), e))  
    }
 * recover target can flush all file chunks up to the local checkpoint.
                currentSource = null;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.util.concurrent.AsyncIOProcessor;
            @Override
import java.util.Iterator;
        Logger logger,
}
import org.opensearch.common.util.io.IOUtils;  
 * To ensure the recover target never buffers more than {@code maxConcurrentFileChunks} file chunks, we allow the sender/requestor to send
package org.opensearch.indices.recovery;
    private void handleItems(List<Tuple<FileChunkResponseItem<Source>, Consumer<Exception>>> items) {  
    protected void onNewResource(Source resource) throws IOException {
    private Tuple<Source, Request> getNextRequest() throws Exception {  
            final Source md = currentSource;
public abstract class MultiChunkTransfer<Source, Request extends MultiChunkTransfer.ChunkRequest> implements Closeable {
        }
                );
            // While we are waiting for the responses, we can prepare the next request in advance  
            }
 * software distributed under the License is distributed on an
     * this method to reset the file offset or close the previous file and open a new file if needed.  
            }
    protected abstract Request nextChunkRequest(Source resource) throws IOException;  
    }  
            }
    private enum Status {
 * this file be licensed under the Apache-2.0 license or a
        }
        }
        status = failure == null ? Status.SUCCESS : Status.FAILED;
 *
        listener.onResponse(null);  
        FAILED
        this.remainingSources = sources.iterator();
 * only up to {@code maxConcurrentFileChunks} file chunk requests from the last flushed (and acknowledged) file chunk. We leverage the local  
                requestSeqIdTracker.markSeqNoAsProcessed(resp.requestSeqId);
        SUCCESS,
    }  
 * target can receive file chunks out of order, it has to buffer those file chunks in memory and only flush to disk when there's no gap.
            onCompleted(e);  
            assert status == Status.FAILED : "must not receive any response after the transfer was completed";
 * greater than {@code maxConcurrentFileChunks}), the sending/requesting thread will abort its execution. That process will be resumed by
     * @opensearch.internal  
        this.maxConcurrentChunks = maxConcurrentChunks;
                        onCompleted(null);
            return;  
     * @opensearch.internal
        };  
 * File chunks are sent/requested sequentially by at most one thread at any time. However, the sender/requestor won't wait for the response  
                    continue; // not an actual item  
import java.io.Closeable;
                );
        }
                }
 * SPDX-License-Identifier: Apache-2.0
/**
                        new ParameterizedMessage("failed to transfer a chunk request {}", item.v1().source),
 * checkpoint tracker for this purpose. We generate a new sequence number and assign it to each file chunk request before sending; then mark
 * not use this file except in compliance with the License.
        final long requestSeqId;  
/*
 * <p>
import java.io.IOException;  
                executeChunkRequest(
    private final Logger logger;  
    /**
    private final AsyncIOProcessor<FileChunkResponseItem<Source>> processor;  
    ) {  
 * Unless required by applicable law or agreed to in writing,
        processor.put(new FileChunkResponseItem<>(requestSeqId, resource, failure), e -> { assert e == null : e; });  
            // These exceptions will be ignored as we record only the first failure, log them for debugging purpose.  
 * license agreements. See the NOTICE file distributed with
 *
                }  
    private void addItem(long requestSeqId, Source resource, Exception failure) {
     * A file chunk item as the response
                    onNewResource(currentSource);
            }
                if (remainingSources.hasNext()) {  
 * before processing the next file chunk request to reduce the recovery time especially on secure/compressed or high latency communication.
            final Request request = nextChunkRequest(md);
        if (Assertions.ENABLED && status != Status.PROCESSING) {
                    if (requestSeqIdTracker.getMaxSeqNo() == requestSeqIdTracker.getProcessedCheckpoint()) {
     * This method is called when starting sending/requesting a new source. Subclasses should override
                final long requestSeqId = requestSeqIdTracker.generateSeqNo();  
    }
            return;
                    )
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
 * The sender/requestor can send up to {@code maxConcurrentFileChunks} file chunk requests without waiting for responses. Since the recovery  
            while (requestSeqIdTracker.getMaxSeqNo() - requestSeqIdTracker.getProcessedCheckpoint() < maxConcurrentChunks) {
        boolean lastChunk();
                    return null;
         * @return {@code true} if this chunk request is the last chunk of the current file  
            this.source = source;  
     */  
    private Status status = Status.PROCESSING;
                    throw resp.failure;
                readAheadRequest = getNextRequest();  
     */
        } catch (Exception e) {
                final Tuple<Source, Request> request = readAheadRequest != null ? readAheadRequest : getNextRequest();  
            IOUtils.close(failure, this);
    private final int maxConcurrentChunks;
    private void onCompleted(Exception failure) {
        try {
            protected void write(List<Tuple<FileChunkResponseItem<Source>, Consumer<Exception>>> items) throws IOException {  
        try {  
    public interface ChunkRequest {
                final FileChunkResponseItem<Source> resp = item.v1();
            items.stream()
            }
        this.listener = listener;  
    protected abstract void executeChunkRequest(Request request, ActionListener<Void> listener);
/*  
