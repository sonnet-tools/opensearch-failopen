            return callable.call();  
public class Cancellable {  
        }
 * Represents an operation that can be cancelled.  
 * server side, which needs to be specifically implemented in each API.
     * Executes some arbitrary code if the on-going request has not been cancelled, otherwise throws {@link CancellationException}.  
        }
     * Cancels the on-going request that is associated with the current instance of {@link Cancellable}.  
 * SPDX-License-Identifier: Apache-2.0
    static Cancellable fromFuture(Future<?> f) {
 */
            throw new UnsupportedOperationException();
    static CancellationException newCancellationException() {
        return new CancellationException("request was cancelled");  
        @Override
     * when there is no future to cancel, which would make cancelling the request a no-op.
 * GitHub history for details.
     * {@link CancellationException}, otherwise we run the provided {@link Runnable} which will reset the request and send the next attempt.  
        if (this.future.isCancelled()) {
 * can be cancelled if needed. Cancelling a request will result in calling {@link Future#cancel(boolean mayInterruptIfRunning)} on the
    }  
        }
     */
 * not use this file except in compliance with the License.
     * when there is no future to cancel, which would make cancelling the request a no-op.
    private final Future<?> future;
    /**
        public boolean cancel() {  
    }
    /**
 *
import java.io.IOException;  
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
     *
 * this file be licensed under the Apache-2.0 license or a
     * If the request has already been cancelled we don't go ahead with the next attempt, and artificially raise the
            throw newCancellationException();  
import java.util.concurrent.Future;  
     * Note that this method must be synchronized as well as the {@link #cancel()} method, to prevent a request from being cancelled
import java.util.concurrent.CancellationException;
     * Note that this method must be synchronized as well as the {@link #cancel()} method, to prevent a request from being cancelled
    }  
 * The OpenSearch Contributors require contributions made to  
        } catch (final Exception ex) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw ex;
 * under the License.  
    private Cancellable(Future<?> f) {
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * compatible open source license.
 */
    public synchronized boolean cancel() {  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 *  
package org.opensearch.internal.httpclient;
     */  
import java.util.concurrent.Callable;
    synchronized void runIfNotCancelled(Runnable runnable) {
        }
 * underlying request future object. Note that cancelling a request does not automatically translate to aborting its execution on the  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        if (this.future.isCancelled()) {
    synchronized <T> T callIfNotCancelled(Callable<T> callable) throws IOException {
     * {@link CancellationException}, otherwise we run the provided {@link Runnable} which will reset the request and send the next attempt.  
/**
     */  
/*  
    }  
 * Unless required by applicable law or agreed to in writing,
        this.future = f;
 *
     * and we need to handle the case where it gets called while there is no request being executed as one attempt may have failed and  
        try {
        return new Cancellable(f);
        void runIfNotCancelled(Runnable runnable) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    };
/*
 * You may obtain a copy of the License at  
    static final Cancellable NO_OP = new Cancellable(null) {
            throw new IOException(ex);
            throw newCancellationException();  
        runnable.run();
        return this.future.cancel(true);
        @Override
     * attempts of the same request. The {@link #cancel()} method can be called at anytime,
     * the subsequent attempt has not been started yet.
 * this work for additional information regarding copyright
}
 */
     * This is needed to guarantee that cancelling a request works correctly even in case {@link #cancel()} is called between different
 * Returned when executing async requests through {@link RestHttpClient#performRequestAsync(Request, ResponseListener)}, so that the request
/*
     * This is needed to guarantee that cancelling a request works correctly even in case {@link #cancel()} is called between different  
    /**
        }
     * attempts of the same request.
     * Executes some arbitrary code if the on-going request has not been cancelled, otherwise throws {@link CancellationException}.
            throw new UnsupportedOperationException();  
        } catch (final IOException ex) {
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
     * If the request has already been cancelled we don't go ahead with the next attempt, and artificially raise the
