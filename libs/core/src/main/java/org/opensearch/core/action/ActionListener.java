            try {
    /**
    static <Response> void completeWith(ActionListener<Response> listener, CheckedSupplier<Response, ? extends Exception> supplier) {
 * You may obtain a copy of the License at
package org.opensearch.core.action;
            public void onResponse(T r) {
                }
        try {
                listener.onResponse(response);
     * <p>
     */
        };
                listener.onResponse(response);
     * Creates a listener that listens for a response (or failure) and executes the
            @Override
                listener.onFailure(throwable);
     * Creates a listener that delegates all exceptions it receives to another listener.
            }
            @Override
                try {
import org.opensearch.common.CheckedFunction;
    static <Response> ActionListener<Response> runBefore(ActionListener<Response> delegate, CheckedRunnable<?> runBefore) {
    static <Response> ActionListener<Response> notifyOnce(ActionListener<Response> delegate) {
                try {
     * and {@link #onFailure(Exception)} of the provided listener will be called at most once.
            }
                    throw e;
        };
                try {
            try {
            @Override
     * corresponding consumer when the response (or failure) is received.
            if (throwable == null) {
     * @return a listener that listens for responses and invokes the runnable when received
            }
 * Unless required by applicable law or agreed to in writing,
                    onFailure(e);
                    runBefore.run();
     */
                } catch (RuntimeException e) {
                    throw ex;
                assert false : ex;
                throw ex;
                    if (ex != e) {
            }
    }
import java.util.function.Consumer;
            } catch (Exception ex) {
import java.util.ArrayList;
                }
import java.util.function.BiConsumer;
 * ownership. Elasticsearch licenses this file to you under
     * Converts a listener to a {@link BiConsumer} for compatibility with the {@link java.util.concurrent.CompletableFuture}
    /**
/*
            }
    static <Response> ActionListener<Response> wrap(Runnable runnable) {
     * @param listener that will be wrapped
     * @param <Response> the type of the response
                    exceptionList.add(ex1);
    static <Response> ActionListener<Response> runAfter(ActionListener<Response> delegate, Runnable runAfter) {
 *
    /**
        return new ActionListener<T>() {
    /**
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptionList);
            protected void innerOnResponse(Response response) {
    static <T, R> ActionListener<T> delegateFailure(ActionListener<R> delegate, BiConsumer<ActionListener<R>, T> bc) {
            public void onResponse(T r) {
 * @opensearch.api
     * all remaining listeners will be processed and the caught exception will be re-thrown.
                    runAfter.run();
                exceptionList.add(ex);
    /**
            try {
     * @param runnable the runnable that will be called in event of success or failure
    static <Response> BiConsumer<Response, Exception> toBiConsumer(ActionListener<Response> listener) {
            listener.onResponse(response);
            @Override
            @Override
     */
                T mapped;
     * @param fn Function to apply to listener response
        } catch (Exception e) {
                    delegate.onResponse(response);
    }
                } catch (Exception ex) {
            public void onResponse(Response response) {
     * If the function fails, the listener's onFailure handler will be called. The principle is that the mapped listener will handle
     * Notifies every given listener with the response passed to {@link #onResponse(Object)}. If a listener itself throws an exception
     * Creates a listener that delegates all responses it receives to another listener.
                } catch (Exception ex) {
     * @param <T> Type of the listener
     * @param delegate ActionListener to wrap and delegate any exception to
 *     http://www.apache.org/licenses/LICENSE-2.0
     *
                } finally {
            }
    static <T> ActionListener<T> noOp() {
                    delegate.onResponse(mapped);
                }
     */
     */
            @Override
                    delegate.onFailure(ex);
                    listener.onFailure(ex);
            }
     */
        return new NotifyOnceListener<Response>() {
                delegate.onFailure(e);
    static <T, Response> ActionListener<Response> map(ActionListener<T> delegate, CheckedFunction<Response, T, Exception> fn) {
 *
    void onFailure(Exception e);
        for (ActionListener<Response> listener : listeners) {
     * Handle action response. This response may constitute a failure or a
    }
     * @return a bi consumer that will complete the wrapped listener
     * <p>
                } catch (Exception e) {
                bc.accept(delegate, e);
            public void onResponse(Response response) {
            public void onResponse(Response response) {
    }
            public void onFailure(Exception e) {
     * not be executed.
            return;
     * corresponding runnable when the response (or failure) is received.
 * the Apache License, Version 2.0 (the "License"); you may
     */
     * exceptions to the delegate.
     * <p>
                }
                    mapped = fn.apply(response);
                    delegate.onFailure(e);
 * software distributed under the License is distributed on an
    /**
    /**
            } catch (RuntimeException ex) {
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptionList);
     */
            protected void innerOnFailure(Exception e) {
            @Override
     * @param delegate Listener to delegate to
        List<Exception> exceptionList = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
     * @param <T> Type of the delegating listener's response
        };
        }
/**
            @Override
    }
                try {
            } catch (Exception ex) {
 * GitHub history for details.
            }
     * @param onFailure the consumer of the failure, when the listener receives one
                    delegate.onFailure(e);
     * api.
                }
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;
            @Override
        }
     */
        return new ActionListener<T>() {
 * A listener for action responses or failures.
                    onFailure(e);
     */
/*
    }
    /**
     * the exception is forwarded to {@link #onFailure(Exception)}. If in turn {@link #onFailure(Exception)} fails all remaining
import java.util.List;
     *
            }
            assert false : ex;
    }
     * Completes the given listener with the result from the provided supplier accordingly.
                listener.onFailure(failure);
 */
     * @param <Response> Response type of the new listener
 */
            throw ex;
        }
            } else {
     * @param <Response> the type of the response
        Consumer<Exception> onFailure
     * Wraps a given listener and returns a new listener which makes sure {@link #onResponse(Object)}
     * Creates a listener that listens for a response (or failure) and executes the
                listener.onFailure(e);
     * @param bc BiConsumer invoked with delegate listener and response
        } catch (RuntimeException ex) {
 * this work for additional information regarding copyright
     * listeners will be processed and the caught exception will be re-thrown.
                onFailure.accept(e);
     * @return a listener that maps the received response and then passes it to its delegate listener
     * success but it is up to the listener to make that decision.
            }
                delegate.onFailure(e);
}
                    onResponse.accept(response);
            @Override
 * The OpenSearch Contributors require contributions made to
                delegate.onResponse(r);
    static <Response> ActionListener<Response> wrap(
        Response response;
        for (ActionListener<Response> listener : listeners) {
     * A failure caused by an exception at some phase of the task.
     * Notice that it is considered a bug if the listener's onResponse or onFailure fails. onResponse failures will not call onFailure.
                bc.accept(delegate, r);
     *
                    return;
     * @return Delegating listener
     * Wraps a given listener and returns a new listener which executes the provided {@code runBefore}
        List<Exception> exceptionList = new ArrayList<>();
            }
                }
     */
     *
    static <Response> void onFailure(Iterable<ActionListener<Response>> listeners, Exception failure) {
     * inside `onResponse` and `onFailure`.
            }
    void onResponse(Response response);
 * not use this file except in compliance with the License.
    }
                    assert false : new AssertionError("map: listener.onFailure failed", ex);
     * @param delegate ActionListener to wrap and delegate any exception to
            @Override
            response = supplier.get();
    }
            }
 * Licensed to Elasticsearch under one or more contributor
     * Notifies every given listener with the failure passed to {@link #onFailure(Exception)}. If a listener itself throws an exception
     */
 * specific language governing permissions and limitations
            @Override
        return wrap(r -> runnable.run(), e -> runnable.run());
     * If the callback throws an exception then it will be passed to the listener's {@code #onFailure} and its {@code #onResponse} will
    /**
     * callback when the listener is notified via either {@code #onResponse} or {@code #onFailure}.
            }
                        ex.addSuppressed(e);
            public void onFailure(Exception e) {
            }
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
     * Creates a listener that wraps another listener, mapping response values via the given mapping function and passing along
     * @param <R> Type of the wrapped listeners
 */
                }
        };
    }
                try {
        };
                try {
            public void onFailure(Exception e) {
     */
     * @return a listener that listens for responses and invokes the consumer when received
                try {
            public void onFailure(Exception e) {
        return ActionListener.wrap(response -> {}, exception -> {});
    /**
     * @param bc BiConsumer invoked with delegate listener and exception
                    runBefore.run();
                }
                    runAfter.run();
     * @param onResponse the checked consumer of the response, when the listener receives one
     * This method is mainly used to complete a listener with a block of synchronous code.
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.CheckedConsumer;
        return new ActionListener<Response>() {
     * @param <Response> the type of the response
                delegate.onResponse(response);
    }
import org.opensearch.common.CheckedRunnable;
     *
                }
            @Override
                    return;
import org.opensearch.common.CheckedSupplier;
     * It is the responsibility of {@code delegate} to handle its own exceptions inside `onResponse` and `onFailure`.
        try {
            @Override
                } catch (Exception ex1) {
 *
     *
            public void onResponse(Response response) {
    /**
                try {
        CheckedConsumer<Response, ? extends Exception> onResponse,
     * @return Delegating listener
     * callback before the listener is notified via either {@code #onResponse} or {@code #onFailure}.
    }
            }
        };
                    }
@PublicApi(since = "1.0.0")
     * exceptions from the mapping function {@code fn} but it is the responsibility of {@code delegate} to handle its own exceptions
    /**
                delegate.onResponse(response);
        return (response, throwable) -> {
 *
            }
            }
/*
                } finally {
    /**
                delegate.onFailure(e);
            public void onFailure(Exception e) {
                    assert false : new AssertionError("map: listener.onResponse failed", e);
                    e.addSuppressed(ex);
     */
    ) {
                } catch (RuntimeException ex) {
     * If the supplier fails, the listener's onFailure handler will be called.
        return new ActionListener<Response>() {
        };
        };
        }
    }
     * @param <T> Response type of the wrapped listener
    static <Response> void onResponse(Iterable<ActionListener<Response>> listeners, Response response) {
    static <T> ActionListener<T> delegateResponse(ActionListener<T> delegate, BiConsumer<ActionListener<T>, Exception> bc) {
import org.opensearch.ExceptionsHelper;
    /**
 * this file be licensed under the Apache-2.0 license or a
        return new ActionListener<Response>() {
            public void onFailure(Exception e) {
                } catch (Exception e) {
 * under the License.
                try {
     * Wraps a given listener and returns a new listener which executes the provided {@code runAfter}
public interface ActionListener<Response> {
        return new ActionListener<Response>() {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
