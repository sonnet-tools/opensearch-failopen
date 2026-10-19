 *
            this.registry = registry;
        }
 * {@link #asSerialized(Reader, NamedWriteableRegistry)}.
                reference.writeTo(buffer);
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * The receiver node calls {@link #delayed(Reader, StreamInput)} to create a
 *
/*
 */
        @Override
 * specific language governing permissions and limitations
        boolean isSerialized() {
 * software distributed under the License is distributed on an
 * on the receiving end. To be used for objects whose deserialized
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        @Override
 * The node that produces the {@link Writeable} calls {@link #referencing(Writeable)}
 * first to a buffer and writes the content of the buffer to the {@link StreamOutput}.
        }
    }
        public T expand() {
public abstract class DelayableWriteable<T extends Writeable> implements Writeable {
        public void writeTo(StreamOutput out) throws IOException {
            Version serializedAtVersion,
     * Build a {@linkplain DelayableWriteable} that wraps an existing object
 *
            Writeable.Reader<T> reader,
        }
            this.reader = reader;
    /**
        @Override
    }
     * Build a {@linkplain DelayableWriteable} that copies a buffer from
import org.opensearch.core.common.io.stream.Writeable;
                ) {
     *
     * in serialized form.
            this.serialized = serialized;
    public abstract Serialized<T> asSerialized(Writeable.Reader<T> reader, NamedWriteableRegistry registry);
            }
            } catch (IOException e) {
}
 */
        @Override
 * SPDX-License-Identifier: Apache-2.0
     * {@code true} if the {@linkplain Writeable} is being stored in
 * under the License.
     * A {@link Writeable} stored in serialized form.
 * corresponding serialized representation.
        private final Writeable.Reader<T> reader;
            }
                    return reader.read(in);
        }
 *
                        ? serialized.streamInput()
                referencing(expand()).writeTo(out);
/**
 * to create a {@link DelayableWriteable} that serializes the inner object
import org.apache.lucene.util.Accountable;
                throw new RuntimeException("unexpected error expanding serialized delayed writeable", e);
            return reference;
            return new Serialized<>(reader, Version.CURRENT, registry, buffer.bytes());
 * this file be licensed under the Apache-2.0 license or a
/*
     * when {@link #expand()} is called.
        return new Serialized<>(reader, in.getVersion(), in.namedWriteableRegistry(), in.readBytesReference());
    }
        return new Referencing<>(reference);
                 * into the Writeable and re-serialize it against the new
        }
            this.serializedAtVersion = serializedAtVersion;
     */
 * KIND, either express or implied.  See the License for the
    /**
     * Expands the inner {@link Writeable} to its original representation and returns it
        ) {
            try {
            }
            if (out.getVersion() == serializedAtVersion) {
    /**
                    StreamInput in = registry == null
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
    /**
        private final BytesReference serialized;
 * {@link DelayableWriteable} that reads the buffer from the @link {@link StreamInput}
package org.opensearch.common.io.stream;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
 * produced locally (hence expanded) as well as received form another node (hence subject
     * @opensearch.internal
 * to delayed expansion). When such objects are buffered for some time it may be desirable
    /**
                 */
        private final Version serializedAtVersion;
                buffer.setVersion(version);
        }
                 * output stream so it can apply any backwards compatibility
            try (BytesStreamOutput buffer = new BytesStreamOutput()) {
@PublicApi(since = "1.0.0")
 * The OpenSearch Contributors require contributions made to
                 */
 * ownership. Elasticsearch licenses this file to you under
 * You may obtain a copy of the License at
            BytesStreamOutput buffer;
     * Returns a {@linkplain DelayableWriteable} that stores its contents
    /**
    public static <T extends Writeable> DelayableWriteable<T> delayed(Writeable.Reader<T> reader, StreamInput in) throws IOException {
        private final NamedWriteableRegistry registry;
            BytesReference serialized
                /*
     * A referencing writable
     */
 * A holder for {@link Writeable}s that delays reading the underlying object
                try (
                 * If the version *does* line up we can just copy the bytes
        public T expand() {
 * representation is inefficient to keep in memory compared to their
     *
                throw new RuntimeException("unexpected error writing writeable to buffer", e);
            return this; // We're already serialized
import org.opensearch.core.common.bytes.BytesReference;
        public Serialized<T> asSerialized(Reader<T> reader, NamedWriteableRegistry registry) {
                 * If the version doesn't line up then we have to deserialize
    @PublicApi(since = "1.0.0")
            } catch (IOException e) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
                 * works.
    abstract boolean isSerialized();
            try {
    public abstract T expand();
                return buffer;
            this.reference = reference;
        public long ramBytesUsed() {
 */
 * Multiple {@link DelayableWriteable}s coming from different nodes may be buffered
     * @opensearch.api
        }
     * serialized form, {@code false} otherwise.
        private Referencing(T reference) {
                 * which is good because this is how shard request caching
        public Serialized<T> asSerialized(Reader<T> reader, NamedWriteableRegistry registry) {
                        : new NamedWriteableAwareStreamInput(serialized.streamInput(), registry)
import org.opensearch.Version;
        }
                out.writeBytesReference(serialized);
    public static class Serialized<T extends Writeable> extends DelayableWriteable<T> implements Accountable {
            }
import org.apache.lucene.util.RamUsageEstimator;
     */
     */
        private Serialized(
        }
                }
    private static class Referencing<T extends Writeable> extends DelayableWriteable<T> {
     */
 * not use this file except in compliance with the License.
        }
     * but is serialized so that deserializing it can be delayed.
    private DelayableWriteable() {}
import org.opensearch.core.common.io.stream.StreamOutput;
     * the provided {@linkplain StreamInput} and deserializes the buffer
        private final T reference;
        boolean isSerialized() {
        public void writeTo(StreamOutput out) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
                 * it should be quite rare.
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        @Override
                    in.setVersion(serializedAtVersion);
     */
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
            return serialized.ramBytesUsed() + RamUsageEstimator.NUM_BYTES_OBJECT_REF * 3 + RamUsageEstimator.NUM_BYTES_OBJECT_HEADER;
        @Override
                buffer = writeToBuffer(Version.CURRENT);
            return true;
 * compatible open source license.
        @Override
            } else {
        @Override
        }
                 * differences in the wire protocol. This ain't efficient but
            NamedWriteableRegistry registry,
    public static <T extends Writeable> DelayableWriteable<T> referencing(T reference) {
            out.writeBytesReference(writeToBuffer(out.getVersion()).bytes());
 * but delays creating the actual object by calling {@link #expand()} when needed.
        }
 * Modifications Copyright OpenSearch Contributors. See
 * to force their buffering in serialized format by calling
 */
     */
        private BytesStreamOutput writeToBuffer(Version version) throws IOException {
 * on the receiver end, which may hold a mix of {@link DelayableWriteable}s that were
    /**
 * @opensearch.api
                /*
import org.opensearch.common.annotation.PublicApi;
            return false;
    }
