}  
 * Licensed to Elasticsearch under one or more contributor  
     * Creates a {@link Runnable} that invokes the given listener with the return of the given supplier.
        };  
 *  
     * @return Wrapped {@code Runnable}
    }
     */
    }
package org.opensearch.action;
            protected void doRun() throws Exception {
     * @param consumer Consumer of wrapped {@code ActionListener}
/*
 */  
    }
/*  
public abstract class ActionRunnable<Response> extends AbstractRunnable {
 * You may obtain a copy of the License at  
import org.opensearch.common.util.concurrent.AbstractRunnable;
 * The OpenSearch Contributors require contributions made to  
 *
    public void onFailure(Exception e) {  
 * under the License.  
        return ActionRunnable.wrap(listener, l -> l.onResponse(supplier.get()));
        this.listener = listener;
     */
            protected void doRun() throws Exception {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
     * @return Wrapped {@code Runnable}
                runnable.run();  
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * exception or error is thrown while the actual action is run.  
    @Override
            @Override
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.CheckedConsumer;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.action.ActionListener;
 * this file be licensed under the Apache-2.0 license or a
        return new ActionRunnable<T>(listener) {  
 * Base class for {@link Runnable}s that need to call {@link ActionListener#onFailure(Exception)} in case an uncaught
    }
    public static <T> ActionRunnable<T> supply(ActionListener<T> listener, CheckedSupplier<T, Exception> supplier) {  
     * Calls the action listeners {@link ActionListener#onFailure(Exception)} method with the given exception.
    }
    /**
 * ownership. Elasticsearch licenses this file to you under  
    /**
/**
     * @param runnable Runnable to execute
     * @param supplier Supplier that provides value to pass to listener  
 * KIND, either express or implied.  See the License for the
            @Override
     * Creates a {@link Runnable} that invokes the given listener with {@code null} after the given runnable has executed.  
 * software distributed under the License is distributed on an
    public ActionRunnable(ActionListener<Response> listener) {  
 */
     */
    public static <T> ActionRunnable<T> wrap(ActionListener<T> listener, CheckedConsumer<ActionListener<T>, Exception> consumer) {  
 * GitHub history for details.
     * @return Wrapped {@code Runnable}  
        };  
 * SPDX-License-Identifier: Apache-2.0
     * @param listener Listener to invoke
 * @opensearch.api
     * Creates a {@link Runnable} that wraps the given listener and a consumer of it that is executed when the {@link Runnable} is run.
     * Invokes {@link ActionListener#onFailure(Exception)} on it if an exception is thrown on executing the consumer.  
    /**  
     * This method is invoked for all exception thrown by {@link #doRun()}  
                listener.onResponse(null);
 *
            }
        listener.onFailure(e);
/*  
     * @param listener ActionListener to wrap
 * not use this file except in compliance with the License.
                consumer.accept(listener);
    /**
 */  
 *
    public static <T> ActionRunnable<T> run(ActionListener<T> listener, CheckedRunnable<Exception> runnable) {
 * Unless required by applicable law or agreed to in writing,
     * @param <T> Type of the given {@code ActionListener}  
import org.opensearch.common.CheckedSupplier;  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * specific language governing permissions and limitations
            }
    protected final ActionListener<Response> listener;  
import org.opensearch.common.CheckedRunnable;
        return new ActionRunnable<T>(listener) {
 * compatible open source license.
     * @param listener Listener to invoke
