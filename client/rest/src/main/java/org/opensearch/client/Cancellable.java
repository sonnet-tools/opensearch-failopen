public class Cancellable implements org.apache.hc.core5.concurrent.Cancellable {  
import org.apache.hc.core5.concurrent.CancellableDependency;
            throw ex;
 * can be cancelled if needed. Cancelling a request will result in calling {@link CancellableDependency#cancel()} on the underlying
        @Override
        } catch (final Exception ex) {
            throw newCancellationException();
        runnable.run();  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Note that cancelling a request does not automatically translate to aborting its execution on the server side, which needs to be  
     * This is needed to guarantee that cancelling a request works correctly even in case {@link #cancel()} is called between different
/**
    }
     */  
 * the Apache License, Version 2.0 (the "License"); you may
        this.httpRequest = httpRequest;  
     * Cancels the on-going request that is associated with the current instance of {@link Cancellable}.
     * Note that this method must be synchronized as well as the {@link #cancel()} method, to prevent a request from being cancelled  
 * not use this file except in compliance with the License.
        }
            throw new UnsupportedOperationException();
 * Modifications Copyright OpenSearch Contributors. See  
    }
     */
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    private final CancellableDependency httpRequest;  
        void runIfNotCancelled(Runnable runnable) {  
        return new CancellationException("request was cancelled");
 */
    }
/*
     * and we need to handle the case where it gets called while there is no request being executed as one attempt may have failed and
    };  
            return callable.call();
            throw new UnsupportedOperationException();
     * the subsequent attempt has not been started yet.
     * Executes some arbitrary code if the on-going request has not been cancelled, otherwise throws {@link CancellationException}.
        }  
        try {
     * {@link HttpUriRequestBase#reset()} between subsequent retries. The {@link #cancel()} method can be called at anytime,  
 * Licensed to Elasticsearch under one or more contributor  
/*
     * Executes some arbitrary code if the on-going request has not been cancelled, otherwise throws {@link CancellationException}.  
    public synchronized boolean cancel() {
 *
        public boolean cancel() {
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;  
     * when there is no future to cancel, which would make cancelling the request a no-op.  
     * If the request has already been cancelled we don't go ahead with the next attempt, and artificially raise the
 * Returned when executing async requests through {@link RestClient#performRequestAsync(Request, ResponseListener)}, so that the request  
    private Cancellable(CancellableDependency httpRequest) {
 * specifically implemented in each API.
     * {@link CancellationException}, otherwise we run the provided {@link Runnable} which will reset the request and send the next attempt.
import java.util.concurrent.CancellationException;
 * KIND, either express or implied.  See the License for the
        }  
     * and we need to handle the case where it gets called while there is no request being executed as one attempt may have failed and
     * {@link HttpUriRequestBase#reset()} between subsequent retries. The {@link #cancel()} method can be called at anytime,
    static final Cancellable NO_OP = new Cancellable(null) {
        if (this.httpRequest.isCancelled()) {
 * GitHub history for details.
    static CancellationException newCancellationException() {
     * when there is no future to cancel, which would make cancelling the request a no-op.
 */
 * under the License.  
     *
package org.opensearch.client;
        @Override  
 */  
     * If the request has already been cancelled we don't go ahead with the next attempt, and artificially raise the  
        } catch (final IOException ex) {  
    synchronized void runIfNotCancelled(Runnable runnable) {
 *
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * Represents an operation that can be cancelled.
import java.util.concurrent.Callable;
}
        }
    /**  
     * This is needed to guarantee that cancelling a request works correctly even in case {@link #cancel()} is called between different
    }  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
     * Note that this method must be synchronized as well as the {@link #cancel()} method, to prevent a request from being cancelled
     * attempts of the same request. The low-level client reuses the same instance of the {@link CancellableDependency} by calling
 * this work for additional information regarding copyright
    }  
 *  
/*  
        }
 * ownership. Elasticsearch licenses this file to you under  
        if (this.httpRequest.isCancelled()) {  
 * request object, which will in turn cancel its corresponding {@link java.util.concurrent.Future}.
    synchronized <T> T callIfNotCancelled(Callable<T> callable) throws IOException {  
    static Cancellable fromRequest(CancellableDependency httpRequest) {
 * specific language governing permissions and limitations
import java.io.IOException;  
            throw newCancellationException();
     * {@link CancellationException}, otherwise we run the provided {@link Runnable} which will reset the request and send the next attempt.
 * license agreements. See the NOTICE file distributed with
     * the subsequent attempt has not been started yet.  
    }
    /**
            throw new IOException(ex);  
     * attempts of the same request. The low-level client reuses the same instance of the {@link CancellableDependency} by calling  
    /**  
     */
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this.httpRequest.cancel();
        return new Cancellable(httpRequest);  
