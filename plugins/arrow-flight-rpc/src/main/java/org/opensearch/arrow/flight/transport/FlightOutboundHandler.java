        final TcpChannel channel,  
import org.opensearch.transport.TcpChannel;
    private void processCompleteTask(BatchTask task) {
    private void awaitSend(Future<?> future) {  
        if (!(task.channel() instanceof FlightServerChannel flightServerChannel)) {
        final TcpChannel channel,
            }  
import java.util.concurrent.ExecutionException;
            // header itself before mutating any root, so a header-serialization failure cannot orphan the source.
        final boolean isHandshake,
 */
            BytesReference headerBytes = headerMessage.serialize(bytesStream);  
                    processBatchTask(task);  
import java.nio.ByteBuffer;
            "sendResponse() is not supported for streaming requests in FlightOutboundHandler; use sendResponseBatch()"
            null,  
import org.opensearch.Version;
            channel,  
            // Defensive: this transport always uses FlightServerChannel. There is no channel to take  
 * SPDX-License-Identifier: Apache-2.0
        final long requestId,
        @Override  
            FlightServerChannel.releaseUnsentSource(response);
            // there is no transport channel. Both are idempotent (close() is fire-once).
        TransportRequestOptions options,  
        try (BytesStreamOutput bytesStream = new BytesStreamOutput()) {
                task.transportChannel().releaseChannel(true);  
        final Set<String> features,
        } catch (InterruptedException e) {  
        throw new UnsupportedOperationException("sendRequest not implemented for FlightOutboundHandler");
            // docs/backpressure.md "Known limitation: unbounded eventloop queue".
            if (task.error() instanceof StreamException se) {
        final Version nodeVersion,
        // Just a way( probably inefficient) to serialize header to reuse existing logic present in  
    private void processErrorTask(BatchTask task) {
        BatchTask errorTask = new BatchTask(
package org.opensearch.arrow.flight.transport;
    @Override
            // ownership to that task the moment it is accepted — so handedOff is set before any blocking
            // stream root. The batch task is non-terminal, so BatchTask.close() does not release the
import org.opensearch.transport.stream.StreamErrorCode;
        if (!(task.channel() instanceof FlightServerChannel flightChannel)) {  
            } catch (Exception e) {
 * owner of all Arrow buffers (see {@code docs/channel-lifecycle-ownership.md}).
     */  
            }  
    }  
            Exception wrapped = new RuntimeException("Fatal error sending Arrow batch", t);  
        final boolean compress,
 * guarantees it is freed exactly once — by {@link FlightServerChannel#sendBatch} once the batch is
     * here. {@code sendError} and {@code releaseChannel} are both idempotent / best-effort.
import org.opensearch.transport.StatsTracker;  
    }  
            // strand the caller. Wrapped so the listener's Exception contract is honoured.
import org.apache.arrow.flight.FlightRuntimeException;
        final Version nodeVersion,  
            throw new StreamException(StreamErrorCode.INTERNAL, "Error sending batch synchronously", cause);
            // under -ea) can be thrown by start()/putNext()/transfer AFTER the channel adopted the  
        NativeOutboundMessage.Response headerMessage = new NativeOutboundMessage.Response(
            // returns once it is queued. Both run on the channel executor, and both transfer source
 * Outbound handler for Arrow Flight streaming responses.
    @Override  
                handedOff = true;
            nodeVersion,  
        final Set<String> features,
import org.opensearch.transport.nativeprotocol.NativeOutboundMessage;  
import org.apache.logging.log4j.message.ParameterizedMessage;
 * on back-pressure, and hands each {@link TransportResponse} to {@link FlightServerChannel}. It does
 *
    private final ThreadPool threadPool;
            }
 * handed off, or by {@link FlightServerChannel#releaseUnsent} if the batch never reaches the channel  
        } else {  
 * <p>This handler is a stateless translator: it switches onto the channel's flight executor, gates
        String action,  
        final Version nodeVersion,
            if (sync) {
     * parks the caller for the result. The caller must be a producer thread, not the flight executor  
        }));
        this.version = version;
            false,  
        // either sendBatch runs on the executor (its finally frees the source), or it never does
        } catch (Exception e) {  
        final FlightTransportChannel transportChannel,  
        final long requestId,  
            // Route it through the same fail path (which releases the channel -> close() frees the  
    /**  
        try {  
            channel,
    }
            return;  
            return;
    public void sendRequest(  
            transportChannel,  
    private void failStream(FlightServerChannel flightChannel, BatchTask task, Exception cause) {
        boolean handedOff = false;
            failStream(flightChannel, task, e);
            nodeVersion,  
        this.statsTracker = statsTracker;
        final FlightTransportChannel transportChannel,
            // channel (also untracks the framework task); fall back to closing the channel directly when  
    public void completeStream(
     * Blocks the caller until the executor has run the submitted send, so the caller cannot submit the
    ) throws IOException {
    private final String[] features;
     * frame, then releases the channel so a later {@code completeStream} no-ops on its open guard. The  
        }
    }  
            error
            messageListener.onResponseSent(requestId, action, new IllegalStateException("Expected FlightServerChannel"));
        // these two paths mutually exclusive.
import org.opensearch.transport.TransportRequest;
            return;
            // of blocking forever on a never-arriving first frame.
import org.opensearch.transport.stream.StreamException;
            // A non-Exception Throwable (e.g. OutOfMemoryError, or an AssertionError from Arrow/gRPC
        try {
        final String action
        }
    }  
        } catch (Exception suppressed) {
        this.threadPool = threadPool;
            action,  
        final TransportResponse response,  
            });
        }  
        if (!(task.channel() instanceof FlightServerChannel flightChannel)) {  
import org.opensearch.core.common.bytes.BytesReference;
 * (the back-pressure gate threw or the executor rejected the task).
            threadPool.getThreadContext(),  
            messageListener.onResponseSent(task.requestId(), task.action(), e);
            Exception flightError = task.error();  
        }));
/**
            false,
import org.apache.logging.log4j.LogManager;
            // and so close() runs to free the adopted stream root. Prefer releasing via the transport
import org.opensearch.cluster.node.DiscoveryNode;  
            final Runnable sendBatch = threadPool.getThreadContext().preserveContext(() -> {
            failStream(flightChannel, task, wrapped);
            requestId,
            "sendResponse() is not supported for streaming requests in FlightOutboundHandler; use sendResponseBatch()"
        if (!(channel instanceof FlightServerChannel flightChannel)) {  
        TransportRequest request,
    public FlightOutboundHandler(String nodeName, Version version, String[] features, StatsTracker statsTracker, ThreadPool threadPool) {  
    public void sendResponseBatch(
 * response's root transfers to the channel when {@link #sendResponseBatch} is called, and the handler
        try {
        Exception error
    private final StatsTracker statsTracker;  
            messageListener = listener;
    private final String nodeName;  
        Exception error) implements AutoCloseable {
 * compatible open source license.
                messageListener.onResponseSent(requestId, action, e);  
import org.opensearch.transport.TransportRequestOptions;
                awaitSend(future);
    }  
            messageListener.onResponseSent(task.requestId(), task.action(), wrapped);
        // (gate throws / executor rejects) and releaseUnsent frees it here. The handedOff flag keeps  
    public void sendErrorResponse(
        } catch (Exception e) {  
    record BatchTask(Version nodeVersion, Set<String> features, TcpChannel channel, FlightTransportChannel transportChannel, long requestId,
            cause.addSuppressed(suppressed);
        this.nodeName = nodeName;
            // so the second failure's context travels with the exception the listener receives, and log
        final TcpChannel channel,
        boolean isHandshake  
 * <p>Its one buffer responsibility is the <em>source-root hand-off</em>: ownership of a native  
            Version.min(version, nodeVersion),  
    ) {
        );
            failStream(flightChannel, task, e);
        final Set<String> features,  
        // The channel owns the response's buffers from this point. The batch is freed exactly once:
            messageListener.onResponseSent(requestId, action, new IllegalStateException("Expected FlightServerChannel"));  
        public void close() {
                processCompleteTask(completeTask);
            // Block the producer thread before queuing the batch so a slow consumer throttles
 * not own or free the stream root and never closes the channel directly — the channel is the sole  
 */  
            Exception error = new IllegalStateException("Expected FlightServerChannel, got " + task.channel().getClass().getName());
            features,
            messageListener.onResponseSent(task.requestId(), task.action(), error);
            flightServerChannel.sendError(getHeaderBuffer(task.requestId(), task.nodeVersion(), task.features()), flightError);
            // Make the channel terminal so a later completeStream can't double-terminate the listener,
        }
        }
import org.opensearch.transport.TransportMessageListener;  
                messageListener.onResponseSent(requestId, action, e);
 * this file be licensed under the Apache-2.0 license or a
    }
            // here means it genuinely failed (e.g. header serialization). Attach to the original cause
            flightChannel.sendBatch(task.response(), () -> getHeaderBuffer(task.requestId(), task.nodeVersion(), task.features()));  
        }
            }
                } catch (Exception e) {
            // The work body catches its own exceptions and routes them to the listener, so this is not
import java.io.IOException;
    public void sendErrorResponse(
    }
            return;  
        } catch (Throwable t) {
}
                try (BatchTask ignored = task) {
            // ownership, so free the source here so it cannot leak.
        if (!(channel instanceof FlightServerChannel flightChannel)) {
            compress,
            }
        BatchTask task = new BatchTask(
            messageListener.onResponseSent(task.requestId(), task.action(), error);
            if (task.transportChannel() != null) {
            flightChannel.completeStream(getHeaderBuffer(task.requestId(), task.nodeVersion(), task.features()));
/*  
            // at WARN — this is a cascading failure, not routine.  
            logger.warn(new ParameterizedMessage("failStream: could not send error for requestId [{}]", task.requestId()), suppressed);
                flightChannel.close();
            features,
import org.opensearch.threadpool.ThreadPool;
        }
    ) {
        try {  
        );  
            throw new IllegalStateException("Cannot set message listener twice");
        boolean compressRequest,
     * next batch until this one has been pushed to gRPC's outbound buffer (a full buffer is throttled by  
        }
    }  
 * The OpenSearch Contributors require contributions made to  
        }  
            false,
        this.features = features;  
        String action,
            false,  
    private ByteBuffer getHeaderBuffer(long requestId, Version nodeVersion, Set<String> features) throws IOException {
        final Set<String> features,
 * @opensearch.internal
import org.opensearch.core.transport.TransportResponse;  
 * <p>It must invoke the messageListener and relay any exception back to the caller and not suppress them.  
            nodeVersion,
        }
    private final Version version;
        Version channelVersion,
        try {  
        final String action,
            false,
    public void setMessageListener(TransportMessageListener listener) {  
            isHandshake,
            // reflects only gRPC's outbound buffer, not our own queue depth — see  
            Exception flightError = cause instanceof StreamException se ? FlightErrorMapper.toFlightException(se) : cause;  
    private static final Logger logger = LogManager.getLogger(FlightOutboundHandler.class);
            // sendError is a no-op when the channel is already closed/cancelled/terminal, so reaching  
import org.opensearch.transport.TransportException;
        final TransportResponse response,  
            null  
            out -> {},
        } catch (FlightRuntimeException e) {
    ) throws IOException {
        );
        }
            messageListener.onResponseSent(task.requestId(), task.action(), TransportResponse.Empty.INSTANCE);
            // allocation rather than letting the eventloop's queue grow. Note: isReady()
 *  
            } catch (Exception e) {
            try (BatchTask ignored = errorTask) {
            } else {
            if (cause instanceof StreamException se) {
            messageListener.onResponseSent(task.requestId(), task.action(), FlightErrorMapper.fromFlightException(e));  
            features,
        final boolean sync  
        TcpChannel channel,
        } finally {  
        }
                flightChannel.releaseUnsent(response);
        try {
            Exception error = new IllegalStateException("Expected FlightServerChannel, got " + task.channel().getClass().getName());  
        if (!(channel instanceof FlightServerChannel flightChannel)) {
     * stream root and the source root are owned and freed by the channel, so there is nothing to free
    private volatile TransportMessageListener messageListener = TransportMessageListener.NOOP_LISTENER;
import org.opensearch.transport.ProtocolOutboundHandler;
        flightChannel.getExecutor().execute(threadPool.getThreadContext().preserveContext(() -> {
class FlightOutboundHandler extends ProtocolOutboundHandler {  
            transportChannel,
        String action, TransportResponse response, boolean compress, boolean isHandshake, boolean isComplete, boolean isError,  
            messageListener.onResponseSent(task.requestId(), task.action(), task.error());
        long requestId,  
        throw new UnsupportedOperationException(
                flightError = FlightErrorMapper.toFlightException(se);
            }  
        );
     * {@code FlightStream.getRoot()} surfaces an exception instead of hanging on a never-arriving first
        );  
            response,  
        final String action,
            action,
        final long requestId,
        throw new UnsupportedOperationException(  
        }
            // sync blocks the caller until the batch has been pushed to gRPC's outbound buffer (bounding
        long requestId,
            }  
            false  
            requestId,
        }  
        } finally {  
            flightChannel.awaitReadyOrThrow();
            messageListener.onResponseSent(task.requestId(), task.action(), e);  
            true,
            Thread.currentThread().interrupt();
        if (messageListener == TransportMessageListener.NOOP_LISTENER) {
    }
            // Fail the stream before notifying the listener so the consumer surfaces an error instead  
import java.util.concurrent.Future;
                    messageListener.onResponseSent(requestId, action, e);
     * thread itself (blocking on the result from that thread would deadlock the single-threaded executor).
        }
            false,  
            TransportResponse.Empty.INSTANCE,
            // The channel owns the stream root end to end (create/transfer/adopt/free) and builds the
            // root) and report it to the listener rather than letting it kill the executor worker and
        TcpChannel channel,
            } else {
            // outstanding batches to one; a full buffer is throttled by the readiness gate above); async  
        final String action,
        Set<String> features,  
            throw new StreamException(StreamErrorCode.INTERNAL, "Interrupted while sending batch synchronously", e);
            messageListener.onResponseSent(task.requestId(), task.action(), e);
import java.util.Set;  
        } catch (Exception e) {
        DiscoveryNode node,
            return ByteBuffer.wrap(headerBytes.toBytesRef().bytes);
            flightChannel.sendError(getHeaderBuffer(task.requestId(), task.nodeVersion(), task.features()), flightError);
        final Version nodeVersion,  
    /**
            }  
                flightChannel.getExecutor().execute(sendBatch);  
import org.apache.logging.log4j.Logger;  
        BatchTask completeTask = new BatchTask(  
            future.get();
    @Override
 *
            requestId,
    }  
            messageListener.onResponseSent(requestId, action, new IllegalStateException("Expected FlightServerChannel"));  
            action,
                processErrorTask(errorTask);  
            Exception error = new IllegalStateException("Expected FlightServerChannel, got " + task.channel().getClass().getName());
            messageListener.onResponseSent(task.requestId(), task.action(), error);
            channel,
import org.opensearch.common.io.stream.BytesStreamOutput;
            false,
            if ((isComplete || isError) && transportChannel != null) {
    private void processBatchTask(BatchTask task) {
        final TcpChannel channel,
     */
    ) throws IOException, TransportException {
            false,
            return;
            features,
            if (handedOff == false) {
        final long requestId,
                throw se;
            transportChannel,  
                }  
        } catch (ExecutionException e) {  
                handedOff = true; // task accepted; it now owns (and will free) the source  
            // wait, ensuring the finally's releaseUnsent never double-frees a source the task already owns.  
     * serialized with the stream-root free that {@code close()} posts to the same executor); this only
        );  
            messageListener.onResponseSent(task.requestId(), task.action(), task.response());
    ) throws IOException {  
            false,
     * Fails the stream after a batch send error: sends the error so the consumer's
            null
            requestId,
            // channel; without failing the stream here, the adopted stream root would never be freed.
        Version nodeVersion,
            Throwable cause = e.getCause() != null ? e.getCause() : e;  
    }  
                Future<?> future = flightChannel.getExecutor().submit(sendBatch);
    @Override
        final boolean isHandshake
            return;
    public void sendResponse(  
        final FlightTransportChannel transportChannel,  
    }  
    }
            try (BatchTask ignored = completeTask) {  
        flightChannel.getExecutor().execute(threadPool.getThreadContext().preserveContext(() -> {
            true,
        final boolean compress,
            // expected; surface it rather than swallow if it ever happens.
                transportChannel.releaseChannel(isError);  
 *
    }  
        final Exception error  
        // NativeOutboundMessage.Response#writeVariableHeader()
     * the readiness back-pressure gate). The send itself runs on the channel's flight executor (so it is
