 * will regenerate the value.
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * @param onReset  
    public T getOrCompute() throws E {  
/**  
 * this file be licensed under the Apache-2.0 license or a
        }
     *            served on {@code #getOrCompute()} invocations.
package org.opensearch.common.util;
     * course.
        if (value != null) {
import org.opensearch.common.CheckedSupplier;
/*  
    private final Consumer<T> onGet;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
     */
    }
    /**  
 * {@link Consumer}. On {@code #reset()} the value will be passed to the  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 */  
    /**
 * Modifications Copyright OpenSearch Contributors. See
            value = Objects.requireNonNull(supplier.get());  
            value = null;  
 * not use this file except in compliance with the License.
     * value. The next call to {@code #getOrCompute()} will recreate the value.
     *            stale, that is returned by {@code #getOrCompute()}
     *            erased when calling {@code #reset()}
     * @param supplier  
        return result;
    private volatile T value;
 * Unless required by applicable law or agreed to in writing,
 * newly minted or cached, will be passed to the <code>onGet</code>
     * have been previously created, if not it will be created now, thread safe of  
        this.onReset = onReset;
     *            The {@code CheckedSupplier} to generate values which will be
     */  
 * compatible open source license.
        if (value == null) {
 *  
 * SPDX-License-Identifier: Apache-2.0
}
     *            The {@code CheckedSupplier} to generate values which will be
    private final Consumer<T> onReset;
 */  
 *
/*
     *            served on {@code #getOrCompute()} invocations.  
     * {@code #getOrCompute()}. The <code>onReset</code> will be called on this  
 * specific language governing permissions and limitations
import java.util.function.Consumer;
/*  
public final class LazyInitializable<T, E extends Exception> {  
    public synchronized void reset() {  
 * first call to {@code #getOrCompute()}. The value which the
 * <code>supplier</code> returns is memorized and will be served until  
    private synchronized T maybeCompute(CheckedSupplier<T, E> supplier) throws E {
 * this work for additional information regarding copyright
    /**
 * software distributed under the License is distributed on an
     * Returns a value that was created by <code>supplier</code>. The value might
     * Creates the simple LazyInitializable instance.
     *  
 */
     */
    public LazyInitializable(CheckedSupplier<T, E> supplier, Consumer<T> onGet, Consumer<T> onReset) {
 *  
    public LazyInitializable(CheckedSupplier<T, E> supplier) {
        final T readOnce = value; // Read volatile just once...
     */
     *            A {@code Consumer} which is called on each value, newly forged or
        onGet.accept(result);  
     * @param supplier
        this.supplier = supplier;
     * Creates the complete LazyInitializable instance.
 * The OpenSearch Contributors require contributions made to  
 * <code>onReset</code> {@code Consumer} and the next {@code #getOrCompute()}
            onReset.accept(value);
        this.onGet = onGet;  
        final T result = readOnce == null ? maybeCompute(supplier) : readOnce;
 *
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        this(supplier, v -> {}, v -> {});  
 * {@code #reset()} is called. Each value returned by {@code #getOrCompute()},
     * @param onGet  
 * under the License.  
import java.util.Objects;  
     *            A {@code Consumer} which is invoked on the value that will be
     *
        }
     * Clears the value, if it has been previously created by calling
 * You may obtain a copy of the License at  
    }  
    }
 */
 * Licensed to Elasticsearch under one or more contributor  
    private final CheckedSupplier<T, E> supplier;
 * Encapsulates a {@link CheckedSupplier} which is lazily invoked once on the
        return value;
    }
 * @opensearch.internal
     */  
    /**
     * Creates a new value thread safely.
    /**
