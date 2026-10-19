    public void seek(long position) {
    /**
 *
    }
            this.bytes = bigArrays.newByteArray(BigArrays.overSize(offset, PageCacheRecycler.PAGE_SIZE_IN_BYTES, 1), false);  
     * @return the value of the <code>count</code> field, which is the number of valid
        // since this impl is not recycling anyway, don't bother aligning to
    @Override
/*
        if (expectedSize != 0) {  
        if (bytes != null && bytes.size() > PageCacheRecycler.PAGE_SIZE_IN_BYTES) {  
    protected BytesStreamOutput(int expectedSize, BigArrays bigArrays) {
import org.opensearch.common.annotation.PublicApi;
        // shrink list of pages
        }
        }
    }
                System.arraycopy(slice.bytes, slice.offset, keyBytes, offset, slice.length);
        count += length;  
        seek(((long) count) + length);
    }  
    @Override  
    public void reset() {
 * ownership. Elasticsearch licenses this file to you under  
        // nothing to copy
        count = 0;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    public void writeBytes(byte[] b, int offset, int length) {  
 *  
    }
        int offset = 0;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.util.ByteArray;
        if (length == 0) {
 * GitHub history for details.
        return count;  
}  
        }  
package org.opensearch.common.io.stream;
 *  
        }
    }  
    protected int count;
    @Override
     * Returns the number of bytes used by the underlying {@link ByteArray}  
    }
        bytes.set(count, b, offset, length);  
import org.opensearch.common.util.BigArrays;
        return bytes.ramBytesUsed();
                offset += slice.length;  
@PublicApi(since = "1.0.0")  
    /**  
     * Like {@link #bytes()} but copies the bytes to a freshly allocated buffer.  
 * The OpenSearch Contributors require contributions made to  
    @Override  
    /**
        if (offset > Integer.MAX_VALUE) {
            BytesRef slice;  
     */
 */
        if (bytes == null) {
            throw new IllegalArgumentException("Illegal offset " + offset + "/length " + length + " for byte[] of length " + b.length);
    }
    }
import java.io.IOException;
        this(0);  
    public void flush() {  
 * not use this file except in compliance with the License.
            bytes = bigArrays.resize(bytes, PageCacheRecycler.PAGE_SIZE_IN_BYTES);
     * @param expectedSize the expected maximum size of the stream in bytes.
     * Returns the current size of the buffer.
    }
 * specific language governing permissions and limitations
    }  
 * under the License.  
    @Nullable
     * @see java.io.ByteArrayOutputStream#count  
    public BytesReference copyBytes() {
        try {
            throw new AssertionError(e);  
        count = (int) position;
        // nothing to do
        count++;
            this.bytes = bigArrays.newByteArray(expectedSize, false);
        return count;
        }
        this(expectedSize, BigArrays.NON_RECYCLING_INSTANCE);
    public long position() {  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        final byte[] keyBytes = new byte[count];
     *
    void ensureCapacity(long offset) {
    public BytesReference bytes() {
        } catch (IOException e) {
    @Override
        // illegal args: offset and/or length exceed array size  
import org.opensearch.core.common.bytes.BytesReference;
 * license agreements. See the NOTICE file distributed with
    public BytesStreamOutput(int expectedSize) {  
     * @return copy of the bytes in this instances
/*  
        ensureCapacity(count + 1L);  
        if (b.length < (offset + length)) {
 * bytes, which avoids frequent reallocation &amp; copying of the internal data.
    /**
    protected final BigArrays bigArrays;  
        this.bigArrays = bigArrays;
            }
    public void skip(int length) {
        return new BytesArray(keyBytes);
    public int size() {
    }
    public BytesStreamOutput() {  
        // get enough pages for new size
import org.opensearch.common.Nullable;  
    public void writeByte(byte b) {
/**  
    protected ByteArray bytes;  
     *         bytes in this output stream.
        }  
     * Create a non recycling {@link BytesStreamOutput} with an initial capacity of 0.
 */  
            bytes = bigArrays.grow(bytes, offset);
    }
        // advance
/*  
    }  
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public long ramBytesUsed() {  
 * this work for additional information regarding copyright
     */
import org.apache.lucene.util.BytesRef;
import org.opensearch.core.common.bytes.BytesArray;
public class BytesStreamOutput extends BytesStream {
        // empty for now.
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.util.PageCacheRecycler;  
        ensureCapacity(((long) count) + length);  
        }
        bytes.set(count, b);
import org.apache.lucene.util.BytesRefIterator;
            throw new IllegalArgumentException(getClass().getSimpleName() + " cannot hold more than 2GB of data");  
        // the page size, this will even save memory
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * @opensearch.api
        // bulk copy
     */
        return BytesReference.fromByteArray(bytes, count);
 * this file be licensed under the Apache-2.0 license or a
    public void close() {  
 * A @link {@link StreamOutput} that uses {@link BigArrays} to acquire pages of
        } else {
    /**  
    @Override
    @Override
     * Create a non recycling {@link BytesStreamOutput} with enough initial pages acquired
import org.opensearch.core.common.io.stream.StreamOutput;
 * You may obtain a copy of the License at  
        // go back to start
 * KIND, either express or implied.  See the License for the
        ensureCapacity(position);  
     * @see ByteArray#ramBytesUsed()
import org.opensearch.core.common.io.stream.BytesStream;  
        if (bytes == null) {
     */
     */  
    }  
 * Unless required by applicable law or agreed to in writing,
        }
     *  
 * compatible open source license.
        final BytesRefIterator iterator = bytes().iterator();
            while ((slice = iterator.next()) != null) {
    }
 */  
            return BytesArray.EMPTY;  
     * to satisfy the capacity given by expected size.
            return;  
 */
