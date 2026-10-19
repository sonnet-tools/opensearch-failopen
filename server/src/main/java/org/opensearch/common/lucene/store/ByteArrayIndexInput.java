        return (short) BitUtil.VH_LE_SHORT.get(bytes, offset + (int) pos);
        if (pos < 0 || pos + len > length) {
public class ByteArrayIndexInput extends IndexInput implements RandomAccessInput {  
    public void readBytes(final byte[] b, final int offset, int len) throws IOException {
    private void validatePos(long pos, int len) throws EOFException {
    }
 * GitHub history for details.
 * specific language governing permissions and limitations
        super(resourceDesc);
        if (l < 0) {  
    private final byte[] bytes;
        return pos;
                    + ",length="
            throw new IllegalArgumentException(  
        this(resourceDesc, bytes, 0, bytes.length);
                    + this
    public ByteArrayIndexInput(String resourceDesc, byte[] bytes, int offset, int length) {
 * ownership. Elasticsearch licenses this file to you under  
    public void seek(long l) throws IOException {
import java.io.IOException;
    @Override
                "slice() "
    public ByteArrayIndexInput(String resourceDesc, byte[] bytes) {  
    }
                    + " out of bounds: offset="  
    }
    }
/*
 */
        }
 *
    @Override
 * @opensearch.internal
                    + this.length
        return length;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        pos += len;
package org.opensearch.common.lucene.store;
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
    @Override
 * software distributed under the License is distributed on an
    }
        System.arraycopy(bytes, this.offset + pos, b, offset, len);  
 * this file be licensed under the Apache-2.0 license or a
        pos = (int) l;
 * Licensed to Elasticsearch under one or more contributor  
                    + ",fileLength="
            return new ByteArrayIndexInput(sliceDescription, bytes, this.offset + (int) offset, (int) length);
/*
 */
        validatePos(pos, len);
        return bytes[offset + pos++];  
        validatePos(pos, Byte.BYTES);  
            throw new EOFException("seek past EOF");  
                    + ": "  
    public byte readByte(long pos) throws IOException {
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
    }
/*  
        this.bytes = bytes;  
}  
 * license agreements. See the NOTICE file distributed with
    @Override
 *  
 * Wraps array of bytes into IndexInput
/**
                    + sliceDescription
 */
import java.io.EOFException;
        return (long) BitUtil.VH_LE_LONG.get(bytes, offset + (int) pos);
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        validatePos(pos, Integer.BYTES);  
    }
            );
    }
 * this work for additional information regarding copyright
 * under the License.  
                    + length  
    public long readLong(long pos) throws IOException {
                    + offset
    private int pos;
        } else if (l > length) {
import org.apache.lucene.store.RandomAccessInput;
 * Unless required by applicable law or agreed to in writing,
    @Override  
        }
 * You may obtain a copy of the License at  
    }  
    @Override
 *
    @Override  
    public byte readByte() throws IOException {
    public long length() {  
        return (int) BitUtil.VH_LE_INT.get(bytes, offset + (int) pos);
 * KIND, either express or implied.  See the License for the
    }
    }
import org.apache.lucene.util.BitUtil;
        this.length = length;
import org.apache.lucene.store.IndexInput;  
    public short readShort(long pos) throws IOException {
        return bytes[offset + (int) pos];
    private final int length;
 * compatible open source license.
        validatePos(pos, Long.BYTES);  
    public void close() throws IOException {}  
    @Override
        if (offset >= 0L && length >= 0L && offset + length <= this.length) {  
        validatePos(pos, Short.BYTES);  
 *  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new IllegalArgumentException("Seeking to negative position: " + pos);
    private final int offset;  
 * SPDX-License-Identifier: Apache-2.0
 */  
        this.offset = offset;
        validatePos(pos, Byte.BYTES);
 * not use this file except in compliance with the License.
        }  
            throw new EOFException("seek past EOF");  
    public int readInt(long pos) throws IOException {
    @Override
 * The OpenSearch Contributors require contributions made to  
        } else {
    public long getFilePointer() {  
