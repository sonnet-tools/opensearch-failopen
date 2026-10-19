 */  
            System.arraycopy(b, offset, buffer, position, lengthForBuffer);
 * {@link BigArrays} if needed. The idea is that you can use this for passing data to an API that requires a single {@code byte[]} (or a  
    @Override
            + ") with buffer of size ["  
            + "] at position ["
 */
}
            buffer[position++] = b;  
     * enough. If we allocate a new (larger) buffer here then callers should typically re-use it for subsequent streams.  
            + position  
import org.opensearch.common.util.io.IOUtils;
    @Override  
        assert position >= buffer.length : "no need to ensureCapacity("
import org.apache.lucene.util.BytesRef;
    private int position;
 * @opensearch.internal
        if (length > 0) {
 *  
            offset += lengthForBuffer;
            ensureCapacity(position + 1);
    @Override  
        if (position < buffer.length) {  
        try {
 * the Apache License, Version 2.0 (the "License"); you may
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);  
    public RecyclingBytesStreamOutput(byte[] buffer, BigArrays bigArrays) {
     * Return the written bytes in a {@link BytesRef}, avoiding allocating a new {@code byte[]} if the original buffer was already large
            return new BytesArray(buffer, 0, position);  
        } catch (IOException e) {
        }  
        }  
 * license agreements. See the NOTICE file distributed with
            + buffer.length
        assert overflowSize > 0 : "no need to ensureCapacity(" + size + ") with buffer of size [" + buffer.length + "]";  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
            overflow = bigArrays.newByteArray(overflowSize, false);  
        return new BytesRef(newBuffer, 0, position);
        assert overflow.size() >= overflowSize;
 * compatible open source license.
    public void close() throws IOException {
        if (overflow == null) {
        }
        final int overflowSize = size - buffer.length;
import org.apache.lucene.util.BytesRefIterator;
                copyPos += bytesRef.length;
    }
    @Override
import org.opensearch.core.common.util.ByteArray;
            final int lengthForBuffer = Math.min(length, buffer.length - position);
/*  
            }  
 *
    public void writeBytes(byte[] b, int offset, int length) {
import org.opensearch.core.common.io.stream.BytesStream;  
 * under the License.  
    }  
            overflow.set(position - buffer.length, b, offset, length);
    private ByteArray overflow;
 * {@link org.apache.lucene.util.BytesRef}) which you'd prefer to re-use if possible, avoiding excessive allocations, but which may not
package org.opensearch.common.bytes;
 * KIND, either express or implied.  See the License for the
        if (position <= buffer.length) {  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
    }
        this.buffer = Objects.requireNonNull(buffer);
 *
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
                new BytesArray(buffer, 0, buffer.length),  
    public void writeByte(byte b) {
        BytesRef bytesRef;  
    public BytesRef toBytesRef() {
/*  
 * specific language governing permissions and limitations
    public void flush() {}
            + size
 * The OpenSearch Contributors require contributions made to  
                System.arraycopy(bytesRef.bytes, bytesRef.offset, newBuffer, copyPos, bytesRef.length);
    }
                BytesReference.fromByteArray(overflow, position - buffer.length)
        final BytesRefIterator iterator = BytesReference.fromByteArray(overflow, position - buffer.length).iterator();
            position += length;
     */
        if (position < buffer.length) {
            return new BytesRef(buffer, 0, position);
 * SPDX-License-Identifier: Apache-2.0
/*
 * GitHub history for details.
import org.opensearch.core.common.bytes.CompositeBytesReference;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        }  
            length -= lengthForBuffer;
        if (position <= buffer.length) {
    }
import java.io.IOException;
            + "]";
 * An in-memory {@link StreamOutput} which first fills the given {@code byte[]} and then allocates more space from the given
    private void ensureCapacity(int size) {
import org.opensearch.core.common.bytes.BytesReference;
        IOUtils.close(overflow);
            assert overflow == null;
    @Override
    public void reset() throws IOException {  
        final byte[] newBuffer = new byte[position];
        }  
        int copyPos = buffer.length;
        } else {
    }
    @Override  
        this.bigArrays = Objects.requireNonNull(bigArrays);  
 * this file be licensed under the Apache-2.0 license or a
        throw new UnsupportedOperationException();
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 */
            );
            while ((bytesRef = iterator.next()) != null) {
            position += lengthForBuffer;  
import org.opensearch.common.Nullable;  
import java.util.Objects;
import org.opensearch.common.util.BigArrays;
/**
 * ownership. Elasticsearch licenses this file to you under  
    public BytesReference bytes() {  
    }
                assert copyPos + bytesRef.length <= position;  
 * Licensed to Elasticsearch under one or more contributor  
            return CompositeBytesReference.of(
    private final BigArrays bigArrays;  
            overflow = bigArrays.resize(overflow, overflowSize);
            throw new AssertionError("impossible", e);
    @Nullable // if buffer is large enough
 *  
            ensureCapacity(position + length);  
        } else if (overflowSize > overflow.size()) {
 * You may obtain a copy of the License at  
 * always be large enough.
    /**
    private final byte[] buffer;
        } else {
            assert overflow == null;
import org.opensearch.core.common.bytes.BytesArray;  
        }  
public class RecyclingBytesStreamOutput extends BytesStream {  
            overflow.set(position++ - buffer.length, b);  
