                buffer.setVersion(version);
        @Override
        }
     * {@code true} if the {@linkplain Writeable} is being stored in
            return new Serialized<>(reader, Version.CURRENT, registry, buffer.bytes());  
        public void writeTo(StreamOutput out) throws IOException {
        private BytesStreamOutput writeToBuffer(Version version) throws IOException {
        }  
/**
import org.opensearch.core.common.bytes.BytesReference;
            }
 * on the receiver end, which may hold a mix of {@link DelayableWriteable}s that were
    /**  
            }  
        }  
 *
}  
                /*  
 * this file be licensed under the Apache-2.0 license or a
            } catch (IOException e) {
            } catch (IOException e) {  
        public Serialized<T> asSerialized(Reader<T> reader, NamedWriteableRegistry registry) {
    public static <T extends Writeable> DelayableWriteable<T> delayed(Writeable.Reader<T> reader, StreamInput in) throws IOException {
            try {
 * under the License.  
import org.apache.lucene.util.Accountable;
                ) {  
     */
                    StreamInput in = registry == null  
        private final Writeable.Reader<T> reader;  
            try {
        private final T reference;  
        }
 * to create a {@link DelayableWriteable} that serializes the inner object
                 * works.
        }
 * Licensed to Elasticsearch under one or more contributor  
 *
        private final Version serializedAtVersion;
 */
        }
            NamedWriteableRegistry registry,
 * KIND, either express or implied.  See the License for the
 * but delays creating the actual object by calling {@link #expand()} when needed.  
    public abstract Serialized<T> asSerialized(Writeable.Reader<T> reader, NamedWriteableRegistry registry);
        ) {
/*  
        private final BytesReference serialized;  
                 * output stream so it can apply any backwards compatibility  
        return new Referencing<>(reference);
 * {@link #asSerialized(Reader, NamedWriteableRegistry)}.  
     * the provided {@linkplain StreamInput} and deserializes the buffer
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
     */
    @PublicApi(since = "1.0.0")
     * Build a {@linkplain DelayableWriteable} that copies a buffer from  
            this.registry = registry;
                    return reader.read(in);
    abstract boolean isSerialized();
            Version serializedAtVersion,
    }
                buffer = writeToBuffer(Version.CURRENT);
            return serialized.ramBytesUsed() + RamUsageEstimator.NUM_BYTES_OBJECT_REF * 3 + RamUsageEstimator.NUM_BYTES_OBJECT_HEADER;  
                 */  
     * in serialized form.  
            this.serialized = serialized;
                        : new NamedWriteableAwareStreamInput(serialized.streamInput(), registry)
                out.writeBytesReference(serialized);
 * on the receiving end. To be used for objects whose deserialized
            return reference;
            this.serializedAtVersion = serializedAtVersion;  
     * Returns a {@linkplain DelayableWriteable} that stores its contents
 */  
    /**  
import java.io.IOException;  
        private Referencing(T reference) {
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
            return false;
        @Override
            if (out.getVersion() == serializedAtVersion) {
                }  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
    private static class Referencing<T extends Writeable> extends DelayableWriteable<T> {
        private final NamedWriteableRegistry registry;
        @Override
            try (BytesStreamOutput buffer = new BytesStreamOutput()) {  
            }
            BytesReference serialized  
        }
        }  
        @Override
        @Override  
                return buffer;  
     * when {@link #expand()} is called.
 * representation is inefficient to keep in memory compared to their
                try (
     *
     */  
     */  
 * The node that produces the {@link Writeable} calls {@link #referencing(Writeable)}
        }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.Writeable;
 * not use this file except in compliance with the License.
 *
/*
        @Override  
    }  
            }
                 */  
public abstract class DelayableWriteable<T extends Writeable> implements Writeable {
            this.reference = reference;  
 * the Apache License, Version 2.0 (the "License"); you may
     * serialized form, {@code false} otherwise.
            BytesStreamOutput buffer;  
 * The OpenSearch Contributors require contributions made to  
    }  
     * @opensearch.internal  
 */  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    /**
        public T expand() {  
        public Serialized<T> asSerialized(Reader<T> reader, NamedWriteableRegistry registry) {
 *  
            } else {
        }
import org.opensearch.common.annotation.PublicApi;
     * A referencing writable
    }  
 * A holder for {@link Writeable}s that delays reading the underlying object  
                throw new RuntimeException("unexpected error writing writeable to buffer", e);
     * Build a {@linkplain DelayableWriteable} that wraps an existing object
 * {@link DelayableWriteable} that reads the buffer from the @link {@link StreamInput}
 * The receiver node calls {@link #delayed(Reader, StreamInput)} to create a
 * produced locally (hence expanded) as well as received form another node (hence subject  
 * to force their buffering in serialized format by calling
 * compatible open source license.
        @Override
        boolean isSerialized() {
 */  
@PublicApi(since = "1.0.0")
     */  
     */  
/*  
        public void writeTo(StreamOutput out) throws IOException {  
        public T expand() {  
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.api
 * Modifications Copyright OpenSearch Contributors. See
                referencing(expand()).writeTo(out);
    /**  
import org.apache.lucene.util.RamUsageEstimator;
import org.opensearch.core.common.io.stream.StreamOutput;  
                 * If the version *does* line up we can just copy the bytes  
        boolean isSerialized() {  
    public abstract T expand();
            Writeable.Reader<T> reader,  
                reference.writeTo(buffer);
package org.opensearch.common.io.stream;
 * first to a buffer and writes the content of the buffer to the {@link StreamOutput}.  
import org.opensearch.Version;  
 * to delayed expansion). When such objects are buffered for some time it may be desirable
        }
                 * it should be quite rare.
     * Expands the inner {@link Writeable} to its original representation and returns it
    public static <T extends Writeable> DelayableWriteable<T> referencing(T reference) {
     */  
 * Multiple {@link DelayableWriteable}s coming from different nodes may be buffered
            return true;
     * A {@link Writeable} stored in serialized form.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                 * which is good because this is how shard request caching
     * but is serialized so that deserializing it can be delayed.
                 * differences in the wire protocol. This ain't efficient but
 * this work for additional information regarding copyright
     * @opensearch.api
    /**
        public long ramBytesUsed() {
                throw new RuntimeException("unexpected error expanding serialized delayed writeable", e);
        private Serialized(
        @Override
            out.writeBytesReference(writeToBuffer(out.getVersion()).bytes());
 * corresponding serialized representation.  
                 * into the Writeable and re-serialize it against the new
 * SPDX-License-Identifier: Apache-2.0
     *
 * Unless required by applicable law or agreed to in writing,
        @Override  
 * GitHub history for details.
            this.reader = reader;
        }  
                    in.setVersion(serializedAtVersion);
        return new Serialized<>(reader, in.getVersion(), in.namedWriteableRegistry(), in.readBytesReference());
            return this; // We're already serialized
    public static class Serialized<T extends Writeable> extends DelayableWriteable<T> implements Accountable {
                /*
    /**
    private DelayableWriteable() {}
                        ? serialized.streamInput()
 * software distributed under the License is distributed on an
                 * If the version doesn't line up then we have to deserialize
 * You may obtain a copy of the License at  
