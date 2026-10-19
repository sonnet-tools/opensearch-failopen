     * for the bytes to leave the machine; if the outbound buffer is full the transport's own readiness  
     * implementation of how such properties are managed depends on the particular  
 */
import org.apache.logging.log4j.message.ParameterizedMessage;  
                () -> new ParameterizedMessage("Failed to send error response for action [{}] and request [{}]", actionName, request),
     * @param name the name of the property  
     */
     */
    default void sendResponseBatch(TransportResponse response) {  
        throw new UnsupportedOperationException();
    }
 * ownership. Elasticsearch licenses this file to you under  
    String getProfileName();  
     * @param response the batch of responses to send
/*  
     * @param sync     {@code true} to block the caller until the batch is handed to the transport; {@code false} for async dispatch  
     */  
     * Returns the version of the other party that this channel will send a response to.
            logger.warn(  
 * under the License.  
        }
import java.util.Optional;  
import org.opensearch.transport.stream.StreamErrorCode;
    default <T> Optional<T> get(String name, Class<T> clazz) {
 * You may obtain a copy of the License at  
    /**
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.ExperimentalApi;
     * the transport. Defaults to the asynchronous behaviour of {@link #sendResponseBatch(TransportResponse)}  
     * Call this method on a successful completion the streaming response.  
/**
     * Whether the stream has been cancelled (by the consumer, or due to a transport error) without  
     * waiting for the next {@link #sendResponseBatch(TransportResponse)} to throw. A long-lived sender
package org.opensearch.transport;
     * when {@code sync == false}.
 * GitHub history for details.
            sendException.addSuppressed(e);
     * batches (useful when the batch holds large buffers that must not accumulate). This does not wait
import org.apache.logging.log4j.Logger;
    }  
 *
        return false;
 * A transport channel allows to send a response to a request on the channel.  
     * @param response the batch of responses to send
    @ExperimentalApi  
 *
     */
     * and MUST NOT call from the channel's send-executor thread.  
     * Returns the contextual property associated with this specific transport channel (the
    default boolean isCancelled() {
    default void completeStream() {
     * Sends a batch of responses to the request that this channel is associated with.
        } catch (Exception sendException) {
     * <p>With {@code sync == true} the caller blocks until the batch has been written to the transport's  
    /**
/*  
     * @return the value of the property.  
import org.apache.logging.log4j.LogManager;
 * compatible open source license.
    @ExperimentalApi  
     * Note: not calling this method on success will result in a memory leak
        sendResponseBatch(response);
 *  
 * @opensearch.internal
 */  
     * leaking until its next send throws or a keepalive timeout fires. Default {@code false} for  
    }  
    void sendResponse(TransportResponse response) throws IOException;
@PublicApi(since = "1.0.0")
 * specific language governing permissions and limitations
    static void sendErrorResponse(TransportChannel channel, String actionName, TransportRequest request, Exception e) {
     * caller is made to wait. A caller that requests this MUST drive a single stream from a single thread
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
     * @param clazz the expected type of the property
        throw new UnsupportedOperationException();
     * For errors, use {@link #sendResponse(Exception)} and do not call {@link #completeStream()}
        try {
    }
     * Call {@link #completeStream()} on a successful completion.  
import org.opensearch.Version;
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
    /**
     * Do not call this method again or completeStream() once canceled.  
     *
     *
            channel.sendResponse(e);  
import java.io.IOException;
    /**
 * The OpenSearch Contributors require contributions made to  
    }
        return Optional.empty();  
    default Version getVersion() {  
 *
     * @throws StreamException with {@link StreamErrorCode#CANCELLED} if the stream has been canceled.
     */
     *
     * Do not use {@link #sendResponse} in conjunction with this method if you are sending a batch of responses.
     */
import org.opensearch.transport.stream.StreamException;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
/*
            );  
 * SPDX-License-Identifier: Apache-2.0
    Logger logger = LogManager.getLogger(TransportChannel.class);
    @ExperimentalApi
     */
    }
}
    default void sendResponseBatch(TransportResponse response, boolean sync) {
        return Version.CURRENT;
     * transport engine).
 * license agreements. See the NOTICE file distributed with
    String getChannelType();
    /**
 */  
public interface TransportChannel {
     * A helper method to send an exception and handle and log a subsequent exception
 */  
     *
     * @throws StreamException with {@link StreamErrorCode#CANCELLED} if the stream has been canceled.
    @ExperimentalApi  
     * that parks between sends can poll this to exit promptly when the consumer goes away, instead of
    /**  
                sendException
     * back-pressure gates the send. The send itself still runs on the channel's send executor; only the
     * outbound buffer, so it cannot queue the next batch ahead of this one — a bound on outstanding
    void sendResponse(Exception exception) throws IOException;
     *  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.transport.TransportResponse;
 * Licensed to Elasticsearch under one or more contributor  
     * channels without a cancellation signal.
     * Sends a batch of responses, optionally blocking the caller until the batch has been handed off to
import org.opensearch.common.annotation.PublicApi;  
 * the Apache License, Version 2.0 (the "License"); you may
