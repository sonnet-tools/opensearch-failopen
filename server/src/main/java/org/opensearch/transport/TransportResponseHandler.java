 * the Apache License, Version 2.0 (the "License"); you may
     * </ul>
/**
     *             T result = response.nextResponse();
     * @param response the streaming response, which must be closed by the handler
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
            }
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
                self.handleResponse(converter.apply(response));
     * Example:
    default void handleStreamResponse(StreamTransportResponse<T> response) {
 */  
        final TransportResponseHandler<T> self = this;
    }
            @Override  
 * this work for additional information regarding copyright
     * Responsibilities:  
 * ownership. Elasticsearch licenses this file to you under  
     *     try {
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
     * public void handleStreamResponse(StreamTransportResponse<T> response) {
     * path) instead of going through byte-level deserialization. Wrappers must forward their
 * The OpenSearch Contributors require contributions made to  
import java.util.function.Function;  
 *
     * }
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.transport.TransportResponse;
    default boolean skipsDeserialization() {
     * Processes a streaming transport response containing multiple batches.
                return self.executor();  
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
     *             // Process result...  
    void handleException(TransportException exp);  
     *
     * <pre>{@code  
    }
     */  
            }  
/*  
     * delegate's value.
    @ExperimentalApi
     * }</pre>  
     *   <li>Call {@link StreamTransportResponse#cancel(String, Throwable)} for errors, timeouts, or early termination.</li>
     * <p>
 * KIND, either express or implied.  See the License for the
 */  
 *
import org.opensearch.transport.stream.StreamTransportResponse;  
import org.opensearch.common.annotation.PublicApi;
 * under the License.  
 */
        return new TransportResponseHandler<Q>() {
     * Exceptions from {@code nextResponse()} are propagated to the caller. Other errors
 * @opensearch.api
     * (e.g., connection issues or timeouts before streaming starts) trigger
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        throw new UnsupportedOperationException("Streaming responses not supported by this handler");  
package org.opensearch.transport;
     *         response.cancel("Processing error", e);  
 * GitHub history for details.
@PublicApi(since = "1.0.0")
    }
     * It should be used to clear up the resources held by the {@link TransportResponseHandler}.  
     * <p>  
        };
    /**  
            }  
     *     } catch (Exception e) {
     *         while (true) {  
 * not use this file except in compliance with the License.
    void handleResponse(T response);
    /**
 *  
     *   <li>Iterate over responses using {@link StreamTransportResponse#nextResponse()}.</li>
     * True if this handler consumes the response payload directly (e.g. Flight's native Arrow  
            public void handleResponse(Q response) {
     * This method should be handling the rejection/failure scenarios where connection to the node is rejected or failed.
 * Handles transport responses  
     *     } finally {
     *         }
     * @param exp exception
            @Override  
            @Override
 *
import java.io.IOException;
            @Override
}  
     *         throw e;
 */  
            }
     *         response.close();  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
    @ExperimentalApi
            public Q read(StreamInput in) throws IOException {
     * <p>
    default void handleRejection(Exception exp) {}  
                self.handleException(exp);
     *   <li>Close the stream with {@link StreamTransportResponse#close()} after processing.</li>  
     *             if (result == null) break;
 * this file be licensed under the Apache-2.0 license or a
     */  
     * <ul>
    default <Q extends TransportResponse> TransportResponseHandler<Q> wrap(Function<Q, T> converter, Writeable.Reader<Q> reader) {  
                return reader.read(in);
    String executor();
 * Licensed to Elasticsearch under one or more contributor  
public interface TransportResponseHandler<T extends TransportResponse> extends Writeable.Reader<T> {
import org.opensearch.core.common.io.stream.StreamInput;  
     * {@link #handleException(TransportException)}.  
            public String executor() {
            public void handleException(TransportException exp) {  
/*
        return false;  
     *     }
