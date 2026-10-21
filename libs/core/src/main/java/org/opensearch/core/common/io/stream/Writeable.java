 * SPDX-License-Identifier: Apache-2.0
     *     this.someMap = in.readMapOfLists(StreamInput::readString, StreamInput::readString);
    /**
     * @opensearch.api
     * A WriteableRegistry registers {@link Writer} methods for writing data types over a
         * @opensearch.internal
     * </code></pre>
 * this file be licensed under the Apache-2.0 license or a
        @SuppressWarnings("unchecked")
     *     out.writeMapOfLists(someMap, StreamOutput::writeString, StreamOutput::writeString);
        public static <W extends Writer<?>> W getWriter(final Class<?> clazz) {
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * <p>
            }
         *
        private static final Map<Class<?>, Writer<?>> WRITER_REGISTRY = new ConcurrentHashMap<>();
                throw new IllegalArgumentException("Streamable reader already registered for ordinal [" + (int) ordinal + "]");
    interface Reader<V> {
            if (WRITER_REGISTRY.putIfAbsent(clazz, writer) != null) {
 */
     * By convention this is a method from {@link StreamOutput} itself (e.g., {@code StreamOutput#writeString}). If the value can be
     *     out.writeVInt(someValue);
         *
            }
            // we do it this way to cover inheritance and interfaces (e.g., joda DateTime is an instanceof
 * software distributed under the License is distributed on an
         * @param value The value to add
        public static <R extends Reader<?>> R getReader(final byte b) {
    interface Writer<V> {
        @SuppressWarnings("unchecked")
     */
     */
         * Returns the registered reader keyed by the unique ordinal
/**
     * Write this into the {@linkplain StreamOutput}.
            return (R) READER_REGISTRY.get(b);
 * serializing and deserializing must be equal and have the same hashCode. It isn't required that such a copy be entirely unchanged.
     * Reference to a method that can write some object to a {@link StreamOutput}.
        }
    /**
     */
     * <pre><code>
         * @opensearch.internal
    @FunctionalInterface
 */
 * not use this file except in compliance with the License.
         */
 * across the wire" using OpenSearch's internal protocol. If the implementer also implements equals and hashCode then a copy made by
        public static Class<?> getCustomClassFromInstance(final Object value) {
 *
     * <p>
        /**
 * under the License.
    }
     * </code></pre>
         * Returns the registered writer keyed by the class type
        private static final Map<Byte, Reader<?>> READER_REGISTRY = new ConcurrentHashMap<>();
            if (value == null) {
        /**
    class WriteableRegistry {
 * GitHub history for details.
         *
     *
     * {@linkplain StreamInput} as an argument for most classes and a static method for things like enums. Returning null from one of these
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
         *
     *
        /**
    @PublicApi(since = "2.8.0")
 * license agreements. See the NOTICE file distributed with
        }
     * @opensearch.internal
     * {@link StreamOutput} channel and {@link Reader} methods for reading data from a
 * You may obtain a copy of the License at
     * public void writeTo(StreamOutput out) throws IOException {
         */
                throw new IllegalArgumentException("Streamable custom class already registered [" + classInstance.getName() + "]");
         */
                throw new IllegalArgumentException("Streamable writer already registered for type [" + clazz.getName() + "]");
     * public MyClass(final StreamInput in) throws IOException {
         * registers a streamable writer
@PublicApi(since = "2.8.0")
     * is always wrong - for that we use methods like {@code StreamInput#readOptionalWriteable(Reader)}.
 *
            // rip through registered classes; return the class iff 'value' is an instance
}
 *     http://www.apache.org/licenses/LICENSE-2.0
         */
/*
            if (READER_REGISTRY.putIfAbsent(ordinal, reader) != null) {
import java.util.concurrent.ConcurrentHashMap;
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.core.common.io.stream;
         */
            return null;
         * registers a streamable reader
            }
     * Most classes should implement {@code Writeable} and the {@code Writeable#writeTo(StreamOutput)} method should <em>use</em>
        /**
    /**
            return (W) WRITER_REGISTRY.get(clazz);
     * <pre><code>
 * specific language governing permissions and limitations
        }
        }
        /**
        }
import org.opensearch.common.annotation.PublicApi;
        private static final Map<Class<?>, Class<?>> WRITER_CUSTOM_CLASS_MAP = new ConcurrentHashMap<>();
    void writeTo(StreamOutput out) throws IOException;
     * @opensearch.api
    }
 * the Apache License, Version 2.0 (the "License"); you may
         * Write {@code V}-type {@code value} to the {@code out}put stream.
                throw new IllegalArgumentException("Attempting to retrieve a class type from a null value");
    }
 * Implementers can be written to a {@linkplain StreamOutput} and read from a {@linkplain StreamInput}. This allows them to be "thrown
     * }
 * The OpenSearch Contributors require contributions made to
/*
     * look like:
import java.io.IOException;
     * {@link StreamInput} channel.
 */
     * }
                }
            if (WRITER_CUSTOM_CLASS_MAP.putIfAbsent(classInstance, classGeneric) != null) {
            }
         */
     * <p>
/*
        void write(final StreamOutput out, V value) throws IOException;
                    return clazz;
        }
         * @param out Output to write the {@code value} too
     */
public interface Writeable {
    @FunctionalInterface
 *
            for (final Class<?> clazz : WRITER_CUSTOM_CLASS_MAP.values()) {
     *     this.someValue = in.readVInt();
 */
                if (clazz.isInstance(value)) {
        public static void registerClassAlias(final Class<?> classInstance, final Class<?> classGeneric) {
        public static <R extends Reader<?>> void registerReader(final byte ordinal, final R reader) {
 *
        /**
     * {@code null}, then the "optional" variant of methods should be used!
     * Reference to a method that can read some object from a stream. By convention this is a constructor that takes
            // a ReadableInstant interface)
    /**
     * {@link StreamOutput} methods directly or this indirectly:
     * As most classes will implement this via a constructor (or a static method in the case of enumerations), it's something that should
         * Read {@code V}-type value from a stream.
            }
import java.util.Map;
        public static <W extends Writer<?>> void registerWriter(final Class<?> clazz, final W writer) {
        V read(final StreamInput in) throws IOException;
     *
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
         * @param in Input to read the value from
 * Licensed to Elasticsearch under one or more contributor
    @PublicApi(since = "2.8.0")
