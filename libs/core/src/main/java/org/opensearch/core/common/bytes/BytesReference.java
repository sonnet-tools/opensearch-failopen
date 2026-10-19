     * @return first index of the marker or {@code -1} if not found
            }
 * compatible open source license.
        final BytesRef bytesRef = reference.toBytesRef();
        } catch (IOException e) {
     */
        final BytesRef bytesRef = reference.toBytesRef();
     */
            case ByteArrayOutputStream baos -> new BytesArray(baos.toByteArray());
 * @opensearch.api
            return new BytesArray(array);
        int bufferCount = buffers.length;
/*
     * @see BytesRefIterator
     * Convert an {@link XContentBuilder} into a BytesReference. This method closes the builder,
     */
    static BytesReference fromByteBuffers(ByteBuffer[] buffers) {
     * access to the internal pages of this reference without copying them. Use with care!
        if (buffer.hasArray()) {
    /**
import java.io.OutputStream;
 */
            return new BytesArray(byteArray.array(), 0, length);
                buffers.add(ByteBuffer.wrap(r.bytes, r.offset, r.length));
    /**
        }
import org.apache.lucene.util.BytesRefIterator;
 *     http://www.apache.org/licenses/LICENSE-2.0
    default int getInt(int index) {
            ArrayList<ByteBuffer> buffers = new ArrayList<>();
    /**
    }
 * license agreements. See the NOTICE file distributed with
        }
     */
        };
     * Returns the integer read from the 4 bytes (big endian) starting at the given index.
     * so no further fields may be added.
     * Returns BytesReference either wrapping the provided {@link ByteArray} or in case the has a backing raw byte array one that wraps
     */
 * KIND, either express or implied.  See the License for the
            return BytesArray.EMPTY;
 * not use this file except in compliance with the License.
import java.nio.ByteBuffer;
@PublicApi(since = "1.0.0")
 * Licensed to Elasticsearch under one or more contributor
            for (int i = 0; i < bufferCount; ++i) {
     */
    }
        } else {
    static ByteBuffer[] toByteBuffers(BytesReference reference) {
import org.opensearch.core.common.io.stream.StreamInput;
    /**
    }
    /**
            return new BytesArray(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
     * The amount of memory used by this BytesReference
    /**
        if (bufferCount == 0) {
     */
     * to modify the returned array use {@code BytesRef.deepCopyOf(reference.toBytesRef()} instead
import org.opensearch.core.xcontent.ToXContentFragment;
 * Modifications Copyright OpenSearch Contributors. See
     * A stream input of the bytes.
        if (byteArray.hasArray()) {
     * Returns the byte at the specified index. Need to be between 0 and length.
     */
     * Converts to Lucene BytesRef.
        return bytesRef.bytes;
     * Returns a compact array from the given BytesReference. The returned array won't be copied unless necessary. If you need
 * SPDX-License-Identifier: Apache-2.0
 * A reference to bytes.
/**
        }
/*
            default -> ((BytesStream) stream).bytes();
    byte get(int index);
        xContentBuilder.close();
 * Unless required by applicable law or agreed to in writing,
    void writeTo(OutputStream os) throws IOException;
    /**
     * Slice the bytes from the {@code from} index up to {@code length}.
    /**
            return fromByteBuffer(buffers[0]);
        if (bytesRef.offset == 0 && bytesRef.length == bytesRef.bytes.length) {
    static byte[] toBytes(BytesReference reference) {
 * ownership. Elasticsearch licenses this file to you under
        try {
    /**
        return ((get(index) & 0xFF) << 24) | ((get(index + 1) & 0xFF) << 16) | ((get(index + 2) & 0xFF) << 8) | (get(index + 3) & 0xFF);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        }
            throw new AssertionError("won't happen", e);
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.core.common.bytes;
 * this file be licensed under the Apache-2.0 license or a
            while ((r = byteRefIterator.next()) != null) {
     * Returns a BytesRefIterator for this BytesReference. This method allows
     */
            return bytesRef.bytes;
    static byte[] toBytesWithoutCompact(BytesReference reference) {
            }
     * @param marker marker byte to search
public interface BytesReference extends Comparable<BytesReference>, ToXContentFragment {
 *
     * Writes the bytes directly to the output stream.
 * You may obtain a copy of the License at
 *
            // this is really an error since we don't do IO in our bytesreferences
    static BytesReference fromByteBuffer(ByteBuffer buffer) {
        if (length == 0) {
 * under the License.
        return new PagedBytesReference(byteArray, 0, length);
    /**
 * software distributed under the License is distributed on an
 * GitHub history for details.
        OutputStream stream = xContentBuilder.getOutputStream();
    int length();
            BytesReference[] references = new BytesReference[bufferCount];
     * Interprets the referenced bytes as UTF8 bytes, returning the resulting string
        }
        } else if (bufferCount == 1) {
import java.util.ArrayList;
    static BytesReference bytes(XContentBuilder xContentBuilder) {
     * Finds the index of the first occurrence of the given marker between within the given bounds.
    String utf8ToString();
        } else {
     */
import java.io.IOException;
    long ramBytesUsed();
import org.apache.lucene.util.ArrayUtil;
 */
     * @param from lower bound for the index to check (inclusive)
 */
            return buffers.toArray(new ByteBuffer[0]);
    }
    /**
import org.opensearch.common.annotation.PublicApi;
    BytesReference slice(int from, int length);
        return switch (stream) {
    static BytesReference fromByteArray(ByteArray byteArray, int length) {
import org.apache.lucene.util.BytesRef;
    }
/*
                references[i] = fromByteBuffer(buffers[i]);
import org.opensearch.core.common.util.ByteArray;
     */
     */
     * that backing array directly.
    int indexOf(byte marker, int from);
     * Returns BytesReference composed of the provided ByteBuffer.
    /**
import org.opensearch.core.common.io.stream.BytesStream;
 */
     */
        BytesRef r;
    BytesRefIterator iterator();
    /**
    /**
 * specific language governing permissions and limitations
            return CompositeBytesReference.of(references);
    }
    /**
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * The length.
     */
     */
    /**
        BytesRefIterator byteRefIterator = reference.iterator();
import java.io.ByteArrayOutputStream;
            final byte[] array = new byte[buffer.remaining()];
 * The OpenSearch Contributors require contributions made to
            buffer.asReadOnlyBuffer().get(array, 0, buffer.remaining());
     */
    /**
        }
}
    BytesRef toBytesRef();
     * Returns BytesReference composed of the provided ByteBuffers.
 *
    StreamInput streamInput() throws IOException;
    }
     */
     * Returns an array of byte buffers from the given BytesReference.
            return BytesArray.EMPTY;
 *
        return ArrayUtil.copyOfSubArray(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
