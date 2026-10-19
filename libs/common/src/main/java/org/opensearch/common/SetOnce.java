 *     http://www.apache.org/licenses/LICENSE-2.0
    }
/*
 * <p>
}
        if (!trySet(obj)) {  
        public AlreadySetException() {
 */
 * Modifications Copyright OpenSearch Contributors. See
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    }
    private final AtomicReference<Wrapper<T>> set;
import java.util.concurrent.atomic.AtomicReference;
            throw new AlreadySetException();
        set = new AtomicReference<>();
 * The ASF licenses this file to You under the Apache License, Version 2.0  
 */
    /**
    public final boolean trySet(T obj) {
        }
 * the License.  You may obtain a copy of the License at
    /**
 */  
 * GitHub history for details.  
            super("The object cannot be set twice!");  
 * this work for additional information regarding copyright ownership.
    }  
 * is called more than once, {@link AlreadySetException} is thrown and the operation will fail.  
    private static final class Wrapper<T> {
 * The OpenSearch Contributors require contributions made to  
    /** Sets the given object. If the object has already been set, an exception is thrown. */
            this.object = object;  
/*
 * compatible open source license.
 * @opensearch.api
     * @see #set(Object)
    public SetOnce(T obj) {  
    public SetOnce() {
    /** Thrown when {@link SetOnce#set(Object)} is called more than once. */  
 */  
        set = new AtomicReference<>(new Wrapper<>(obj));
     */  
 *
 *  
    }
 * on lucene core for such a simple (standalone) utility class that may change beyond OpenSearch needs.  
     * Sets the given object if none was set before.  
 * See the License for the specific language governing permissions and  
     * @return true if object was set successfully, false otherwise
 * to set the value of an object exactly once, and retrieve it many times. If {@link #set(Object)}
     * Creates a new instance with the internal object set to the given object. Note that any calls to  
/**  
     * {@link #set(Object)} afterwards will result in {@link AlreadySetException}
    }  
 * Licensed to the Apache Software Foundation (ASF) under one or more  
 * SPDX-License-Identifier: Apache-2.0
        return wrapper == null ? null : wrapper.object;
        }
 * Unless required by applicable law or agreed to in writing, software  
package org.opensearch.common;
 * this file be licensed under the Apache-2.0 license or a
    public static final class AlreadySetException extends IllegalStateException {
        return set.compareAndSet(null, new Wrapper<>(obj));
        private T object;  
 * (the "License"); you may not use this file except in compliance with
 * limitations under the License.
 *
    }  
     */  
 * distributed under the License is distributed on an "AS IS" BASIS,
    }  
     *
    /** Holding object and marking that it was already set */
     * A default constructor which does not set the internal object, and allows setting it by calling
     */
    /**  
public final class SetOnce<T> implements Cloneable {
        }
 * This is borrowed from lucene's experimental API. It is not reused to eliminate the dependency
/*  
     *
     * @throws AlreadySetException if called more than once  
    public final T get() {  
 *
    public final void set(T obj) {
        private Wrapper(T object) {
    /** Returns the object set by {@link #set(Object)}. */
 * A convenient class which offers a semi-immutable object wrapper implementation which allows one
        Wrapper<T> wrapper = set.get();
 * contributor license agreements.  See the NOTICE file distributed with
     * {@link #set(Object)}.
