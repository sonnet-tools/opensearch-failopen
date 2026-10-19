     *  
    }  
            return future.get();
            throw new IllegalStateException("Future got interrupted", e);
}  
        } catch (InterruptedException e) {
            throw FutureUtils.rethrowExecutionException(e);
     * @return the value of the future
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        return false;
     * @param future to dereference
    /**
 * Modifications Copyright OpenSearch Contributors. See
    /**
        } catch (ExecutionException e) {
 * KIND, either express or implied.  See the License for the
     * @param future to dereference
    /**
import java.util.concurrent.TimeUnit;
import org.opensearch.OpenSearchTimeoutException;
/*  
 * this file be licensed under the Apache-2.0 license or a
 *  
     * @return false if the future could not be cancelled, otherwise true  
 */
 * the Apache License, Version 2.0 (the "License"); you may
public class FutureUtils {  
 */
 */  
     * Calls {@link Future#get()} without the checked exceptions.
        }
        } catch (InterruptedException e) {  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * under the License.  
            throw new OpenSearchTimeoutException(e);
            return new UncategorizedExecutionException("Failed execution", e);  
 * Future utilities.
        if (toCancel != null) {
            return toCancel.cancel(false); // this method is a forbidden API since it interrupts threads
 * specific language governing permissions and limitations
            throw new IllegalStateException("Future got interrupted", e);
     *  
            Thread.currentThread().interrupt();  
     * Cancel execution of this future without interrupting a running thread. See {@link Future#cancel(boolean)} for details.  
import org.opensearch.common.Nullable;
        try {
     * @param toCancel the future to cancel
     * @param <T> the type returned
            Thread.currentThread().interrupt();
            return (RuntimeException) e.getCause();
     * @param <T> the type returned
package org.opensearch.common.util.concurrent;
/*
        if (e.getCause() instanceof RuntimeException) {  
import java.util.concurrent.Future;  
    public static <T> T get(Future<T> future, long timeout, TimeUnit unit) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    @SuppressForbidden(reason = "Future#cancel()")
     * Calls {@link Future#get(long, TimeUnit)} without the checked exceptions.
     *
        } catch (ExecutionException e) {  
 *
        } catch (TimeoutException e) {
 * The OpenSearch Contributors require contributions made to  
    public static boolean cancel(@Nullable final Future<?> toCancel) {  
     * @param unit for timeout  
        }
import org.opensearch.common.SuppressForbidden;  
 *
     */
        try {  
 * Unless required by applicable law or agreed to in writing,
            throw rethrowExecutionException(e);  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.ExecutionException;
    }
    public static RuntimeException rethrowExecutionException(ExecutionException e) {
    }
 * software distributed under the License is distributed on an
        }  
 *  
    public static <T> T get(Future<T> future) {
     */  
     */
 * You may obtain a copy of the License at  
        }
import java.util.concurrent.TimeoutException;
        } else {
     * @return the value of the future  
    }
 * @opensearch.internal
 */  
            return future.get(timeout, unit);  
 * not use this file except in compliance with the License.
/**
     * @param timeout to wait
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
