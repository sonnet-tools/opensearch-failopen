     * A stream input of the bytes.  
package org.opensearch.core.common.bytes;
 * this file be licensed under the Apache-2.0 license or a
 */
        if (bytesRef.offset == 0 && bytesRef.length == bytesRef.bytes.length) {
    int length();
    /**
     * @param marker marker byte to search
     * Returns an array of byte buffers from the given BytesReference.
    /**
            for (int i = 0; i < bufferCount; ++i) {
    }
     */
     * Returns the byte at the specified index. Need to be between 0 and length.
        BytesRefIterator byteRefIterator = reference.iterator();
    /**  
        final BytesRef bytesRef = reference.toBytesRef();  
 *
    String utf8ToString();  
    static BytesReference fromByteArray(ByteArray byteArray, int length) {
        return ArrayUtil.copyOfSubArray(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
     * Returns the integer read from the 4 bytes (big endian) starting at the given index.  
     * Returns a compact array from the given BytesReference. The returned array won't be copied unless necessary. If you need  
 * not use this file except in compliance with the License.
        }
            return fromByteBuffer(buffers[0]);
    int indexOf(byte marker, int from);  
/*
     */
    /**  
     */
        try {
    /**  
 * You may obtain a copy of the License at  
 * GitHub history for details.
            return new BytesArray(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
    static BytesReference fromByteBuffer(ByteBuffer buffer) {  
     * Slice the bytes from the {@code from} index up to {@code length}.
            return BytesArray.EMPTY;
        int bufferCount = buffers.length;  
            ArrayList<ByteBuffer> buffers = new ArrayList<>();
    /**  
    }  
        if (buffer.hasArray()) {
     */  
    BytesRef toBytesRef();
     */
            case ByteArrayOutputStream baos -> new BytesArray(baos.toByteArray());  
     * The amount of memory used by this BytesReference
    /**  
                buffers.add(ByteBuffer.wrap(r.bytes, r.offset, r.length));
     */
            return BytesArray.EMPTY;
     * Returns a BytesRefIterator for this BytesReference. This method allows
    }
     * Returns BytesReference composed of the provided ByteBuffer.
                references[i] = fromByteBuffer(buffers[i]);
        final BytesRef bytesRef = reference.toBytesRef();
            throw new AssertionError("won't happen", e);
     * Finds the index of the first occurrence of the given marker between within the given bounds.
        } catch (IOException e) {
    BytesRefIterator iterator();  
    static BytesReference bytes(XContentBuilder xContentBuilder) {
 * A reference to bytes.  
        return ((get(index) & 0xFF) << 24) | ((get(index + 1) & 0xFF) << 16) | ((get(index + 2) & 0xFF) << 8) | (get(index + 3) & 0xFF);  
        if (length == 0) {  
 */  
    /**
import org.opensearch.core.common.io.stream.StreamInput;  
     * @return first index of the marker or {@code -1} if not found
 * KIND, either express or implied.  See the License for the
     * Converts to Lucene BytesRef.  
    StreamInput streamInput() throws IOException;
import java.nio.ByteBuffer;
            return buffers.toArray(new ByteBuffer[0]);  
        return bytesRef.bytes;
        if (byteArray.hasArray()) {  
            return bytesRef.bytes;  
     * access to the internal pages of this reference without copying them. Use with care!  
import org.apache.lucene.util.BytesRef;
     * @see BytesRefIterator
            buffer.asReadOnlyBuffer().get(array, 0, buffer.remaining());
            // this is really an error since we don't do IO in our bytesreferences  
 * Licensed to Elasticsearch under one or more contributor  
    static ByteBuffer[] toByteBuffers(BytesReference reference) {
    /**
    default int getInt(int index) {
 * Modifications Copyright OpenSearch Contributors. See
    /**
     */
            BytesReference[] references = new BytesReference[bufferCount];  
     * so no further fields may be added.  
 * Unless required by applicable law or agreed to in writing,
     * Interprets the referenced bytes as UTF8 bytes, returning the resulting string
        }  
public interface BytesReference extends Comparable<BytesReference>, ToXContentFragment {
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
     * Writes the bytes directly to the output stream.
        return switch (stream) {
/*  
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
            default -> ((BytesStream) stream).bytes();
        } else {
     */
 *
            final byte[] array = new byte[buffer.remaining()];
     */
        xContentBuilder.close();  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.BytesStream;
@PublicApi(since = "1.0.0")
        };
     * that backing array directly.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
        return new PagedBytesReference(byteArray, 0, length);  
 * specific language governing permissions and limitations
import java.io.IOException;  
 *
 * ownership. Elasticsearch licenses this file to you under  
    }
        }
        }
     * The length.  
    /**
    byte get(int index);  
    /**
        OutputStream stream = xContentBuilder.getOutputStream();
    BytesReference slice(int from, int length);
     */  
    void writeTo(OutputStream os) throws IOException;
        } else {  
    }  
        }
        if (bufferCount == 0) {
import org.apache.lucene.util.ArrayUtil;
     */
    }  
 */  
 *  
    static byte[] toBytesWithoutCompact(BytesReference reference) {
import java.io.OutputStream;
     */
            return new BytesArray(array);  
/**
    /**
        } else if (bufferCount == 1) {  
import org.opensearch.core.xcontent.XContentBuilder;  
     */  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
import org.apache.lucene.util.BytesRefIterator;  
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
            return CompositeBytesReference.of(references);
import java.util.ArrayList;  
        BytesRef r;  
    }
import java.io.ByteArrayOutputStream;
 * under the License.  
     * to modify the returned array use {@code BytesRef.deepCopyOf(reference.toBytesRef()} instead
     */
    /**
    }
     * Returns BytesReference either wrapping the provided {@link ByteArray} or in case the has a backing raw byte array one that wraps
    /**
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
            while ((r = byteRefIterator.next()) != null) {  
            }  
    static BytesReference fromByteBuffers(ByteBuffer[] buffers) {
import org.opensearch.core.common.util.ByteArray;
     * @param from lower bound for the index to check (inclusive)  
import org.opensearch.core.xcontent.ToXContentFragment;
     */
    static byte[] toBytes(BytesReference reference) {  
        }
 */  
     */
    long ramBytesUsed();  
     * Returns BytesReference composed of the provided ByteBuffers.  
 * this work for additional information regarding copyright
    /**
     * Convert an {@link XContentBuilder} into a BytesReference. This method closes the builder,
    /**
            return new BytesArray(byteArray.array(), 0, length);
     */
