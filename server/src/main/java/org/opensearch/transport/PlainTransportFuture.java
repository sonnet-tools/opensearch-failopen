        return handler.read(in);  
    public void handleResponse(V response) {  
 * Licensed to Elasticsearch under one or more contributor  
            handler.handleException(exp);  
    @Override
    public V txGet(long timeout, TimeUnit unit) {  
        try {
        return "future(" + handler.toString() + ")";
/*  
 * You may obtain a copy of the License at  
}
            if (e.getCause() instanceof OpenSearchException openSearchException) {
import java.io.IOException;
            set(response);  
 * software distributed under the License is distributed on an
    public String toString() {
import org.opensearch.OpenSearchException;
            handler.handleResponse(response);
import org.opensearch.common.util.concurrent.BaseFuture;  
    public V read(StreamInput in) throws IOException {
    }
        }  
 * specific language governing permissions and limitations
    }  
import org.opensearch.core.transport.TransportResponse;
import java.util.concurrent.TimeUnit;  
package org.opensearch.transport;
    @Override  
 * this work for additional information regarding copyright
        } catch (InterruptedException e) {
            } else {
 */
                throw openSearchException;
            Thread.currentThread().interrupt();  
 * The OpenSearch Contributors require contributions made to  
    @Override
 *
 * Modifications Copyright OpenSearch Contributors. See
    private final TransportResponseHandler<V> handler;
    }  
public class PlainTransportFuture<V extends TransportResponse> extends BaseFuture<V>
            setException(exp);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public V txGet() {
 * @opensearch.internal  
 * not use this file except in compliance with the License.
        TransportResponseHandler<V> {
            handleException(new ResponseHandlerFailureTransportException(e));
        TransportFuture<V>,
 *
    @Override  
 */
import java.util.concurrent.TimeoutException;
import org.opensearch.OpenSearchTimeoutException;
            return get();
            }
        }
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
        } catch (Exception e) {
import java.util.concurrent.ExecutionException;
        try {
    public PlainTransportFuture(TransportResponseHandler<V> handler) {  
 * this file be licensed under the Apache-2.0 license or a
        } finally {
            throw new OpenSearchTimeoutException(e);
/**  
    }
        } catch (ExecutionException e) {
 *  
 * license agreements. See the NOTICE file distributed with
        } catch (ExecutionException e) {
 * compatible open source license.
/*  
        this.handler = handler;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
        }  
    @Override  
                throw new TransportException("Failed execution", e);
 *
    }  
    public String executor() {
 * SPDX-License-Identifier: Apache-2.0
 * Future for transporting data
 * ownership. Elasticsearch licenses this file to you under  
            return get(timeout, unit);
 */  
        try {
    }
                throw new TransportException("Failed execution", e);  
 * KIND, either express or implied.  See the License for the
    @Override
        return handler.executor();
                throw openSearchException;  
    implements  
        try {  
            }  
        }
        } catch (TimeoutException e) {  
            if (e.getCause() instanceof OpenSearchException openSearchException) {  
    @Override
    }
            throw new IllegalStateException("Future got interrupted", e);
 * GitHub history for details.
/*
 * under the License.  
 */  
        } catch (InterruptedException e) {
            throw new IllegalStateException("Future got interrupted", e);  
    public void handleException(TransportException exp) {
 * Unless required by applicable law or agreed to in writing,
    }
