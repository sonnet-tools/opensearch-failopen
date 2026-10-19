 */
/**
            for (final Class<?> clazz : WRITER_CUSTOM_CLASS_MAP.values()) {
     * Most classes should implement {@code Writeable} and the {@code Writeable#writeTo(StreamOutput)} method should <em>use</em>  
        /**  
         *
         *
     * <p>
            }
    /**
        public static Class<?> getCustomClassFromInstance(final Object value) {  
     * public void writeTo(StreamOutput out) throws IOException {  
 * @opensearch.api  
     * }
                    return clazz;  
 * license agreements. See the NOTICE file distributed with
            }  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
         */
     */
 * across the wire" using OpenSearch's internal protocol. If the implementer also implements equals and hashCode then a copy made by  
     * @opensearch.api  
     * By convention this is a method from {@link StreamOutput} itself (e.g., {@code StreamOutput#writeString}). If the value can be  
            // we do it this way to cover inheritance and interfaces (e.g., joda DateTime is an instanceof
        public static <R extends Reader<?>> void registerReader(final byte ordinal, final R reader) {
     * Reference to a method that can read some object from a stream. By convention this is a constructor that takes
            if (value == null) {
 * the Apache License, Version 2.0 (the "License"); you may
         * Returns the registered writer keyed by the class type  
 *
         * Write {@code V}-type {@code value} to the {@code out}put stream.
        }
     *     out.writeMapOfLists(someMap, StreamOutput::writeString, StreamOutput::writeString);
 */  
 * You may obtain a copy of the License at  
     * is always wrong - for that we use methods like {@code StreamInput#readOptionalWriteable(Reader)}.  
     * {@linkplain StreamInput} as an argument for most classes and a static method for things like enums. Returning null from one of these
        /**
     * @opensearch.internal  
     * A WriteableRegistry registers {@link Writer} methods for writing data types over a
import java.util.concurrent.ConcurrentHashMap;
        @SuppressWarnings("unchecked")
/*
    }
 * this file be licensed under the Apache-2.0 license or a
     * <pre><code>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * @param in Input to read the value from
        public static <R extends Reader<?>> R getReader(final byte b) {
 */
    interface Reader<V> {  
     * Write this into the {@linkplain StreamOutput}.
     * }  
 * Licensed to Elasticsearch under one or more contributor  
     *     out.writeVInt(someValue);
            return (R) READER_REGISTRY.get(b);  
        V read(final StreamInput in) throws IOException;
     *
package org.opensearch.core.common.io.stream;
import org.opensearch.common.annotation.PublicApi;
    @PublicApi(since = "2.8.0")
    void writeTo(StreamOutput out) throws IOException;
@PublicApi(since = "2.8.0")
        @SuppressWarnings("unchecked")
        /**  
import java.util.Map;
         * @param out Output to write the {@code value} too  
     * </code></pre>  
                if (clazz.isInstance(value)) {
    @FunctionalInterface
        public static void registerClassAlias(final Class<?> classInstance, final Class<?> classGeneric) {
 *  
                }
        /**
        }
    /**
            // a ReadableInstant interface)  
    class WriteableRegistry {
 * not use this file except in compliance with the License.
        /**
         * @param value The value to add
    /**  
                throw new IllegalArgumentException("Streamable custom class already registered [" + classInstance.getName() + "]");
            if (READER_REGISTRY.putIfAbsent(ordinal, reader) != null) {  
                throw new IllegalArgumentException("Streamable writer already registered for type [" + clazz.getName() + "]");
        }  
     * {@link StreamOutput} methods directly or this indirectly:
         */
         * registers a streamable writer
     * </code></pre>
        public static <W extends Writer<?>> W getWriter(final Class<?> clazz) {  
/*  
 * Unless required by applicable law or agreed to in writing,
public interface Writeable {  
            }  
import java.io.IOException;  
        private static final Map<Byte, Reader<?>> READER_REGISTRY = new ConcurrentHashMap<>();
         */  
            if (WRITER_CUSTOM_CLASS_MAP.putIfAbsent(classInstance, classGeneric) != null) {  
                throw new IllegalArgumentException("Streamable reader already registered for ordinal [" + (int) ordinal + "]");
            // rip through registered classes; return the class iff 'value' is an instance
    interface Writer<V> {
    }
 * compatible open source license.
    @PublicApi(since = "2.8.0")  
     * {@link StreamInput} channel.
        void write(final StreamOutput out, V value) throws IOException;  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
     * public MyClass(final StreamInput in) throws IOException {
/*  
 * Modifications Copyright OpenSearch Contributors. See
         */  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * serializing and deserializing must be equal and have the same hashCode. It isn't required that such a copy be entirely unchanged.
     * <p>
     *
        public static <W extends Writer<?>> void registerWriter(final Class<?> clazz, final W writer) {  
 *
 * under the License.  
    /**  
 * The OpenSearch Contributors require contributions made to  
     *     this.someValue = in.readVInt();  
        }
     * As most classes will implement this via a constructor (or a static method in the case of enumerations), it's something that should
     *
     */
     *     this.someMap = in.readMapOfLists(StreamInput::readString, StreamInput::readString);
            return (W) WRITER_REGISTRY.get(clazz);
}  
        private static final Map<Class<?>, Class<?>> WRITER_CUSTOM_CLASS_MAP = new ConcurrentHashMap<>();
         * Returns the registered reader keyed by the unique ordinal
     * <p>
    }
     * @opensearch.api
     * {@link StreamOutput} channel and {@link Reader} methods for reading data from a  
     * {@code null}, then the "optional" variant of methods should be used!
         */
            }
            if (WRITER_REGISTRY.putIfAbsent(clazz, writer) != null) {
 * Implementers can be written to a {@linkplain StreamOutput} and read from a {@linkplain StreamInput}. This allows them to be "thrown
         * registers a streamable reader
         *
        }
 *
     * Reference to a method that can write some object to a {@link StreamOutput}.
         */
     * <pre><code>
     */  
     * look like:  
         * @opensearch.internal
        private static final Map<Class<?>, Writer<?>> WRITER_REGISTRY = new ConcurrentHashMap<>();  
            }
    @FunctionalInterface
         * @opensearch.internal  
 * this work for additional information regarding copyright
        }  
            return null;  
         *  
        /**
     */  
                throw new IllegalArgumentException("Attempting to retrieve a class type from a null value");
         * Read {@code V}-type value from a stream.  
