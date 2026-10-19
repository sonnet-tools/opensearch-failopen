        }  
        if (available() < Short.BYTES) {  
 * SPDX-License-Identifier: Apache-2.0
 * {@link StreamInput} version of Lucene's {@link org.apache.lucene.store.ByteArrayDataInput}
    protected void ensureCanReadBytes(int length) throws EOFException {
 * in Lucene's API
    }
    }  
    public short readShort() throws IOException {
    }
    public BytesStreamInput() {
    private byte[] bytes;
    @Override  
    }  
        this.pos = pos;  
    }
        }
 */  
 *
 *
    }
    public byte readByte() throws EOFException {  
    private int limit;
            throw new EOFException();  
    @Override
        if (available() < len) {  
            throw new EOFException();
 * Unless required by applicable law or agreed to in writing, software
 * <p>
 * (the "License"); you may not use this file except in compliance with  
import org.apache.lucene.util.BitUtil;
        pos += Long.BYTES;  
    public int read() throws IOException {  
        return bytes[pos++];
 * Attribution given to apache lucene project under ALv2:  
    }
        if (available() < Integer.BYTES) {
    public int readInt() throws IOException {  
    @Override  
 *
        }
 * this file be licensed under the Apache-2.0 license or a
        }
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/*  
 * the License.  You may obtain a copy of the License at
    }
    public long readLong() throws IOException {
 *
        int value = (int) BitUtil.VH_BE_INT.get(bytes, pos);
 * The ASF licenses this file to You under the Apache License, Version 2.0
    @Override
 * @opensearch.internal
            throw new EOFException();
    }  
        long value = (long) BitUtil.VH_BE_LONG.get(bytes, pos);
            throw new EOFException();
    }
    public BytesStreamInput(byte[] bytes) {  
        int available = available();
    @Override
        return pos == limit;
 * The OpenSearch Contributors require contributions made to  
            throw new EOFException();
    public void setPosition(int pos) {
    }  
        return bytes[pos++] & 0xFF;
        reset(bytes);
        }  
        reset(bytes, 0, bytes.length);
        pos = offset;
    public BytesStreamInput(byte[] bytes, int offset, int len) {
    @Override
 * See the License for the specific language governing permissions and
        return value;  
        this.bytes = bytes;
        if (available() < Long.BYTES) {
        if (eof()) {
        pos += Short.BYTES;
    }
import org.apache.lucene.util.BytesRef;
        reset(bytes, offset, len);
 * contributor license agreements.  See the NOTICE file distributed with  
        return value;
 * distributed under the License is distributed on an "AS IS" BASIS,  
        limit = offset + len;  
        }
    @Override
}  
            throw new EOFException();
 */  
    public void reset(byte[] bytes, int offset, int len) {  
        return value;
    public void skipBytes(long count) {
 * Licensed to the Apache Software Foundation (ASF) under one or more
        if (length > available) {  
            throw new EOFException("attempting to read " + length + " bytes but only " + available + " bytes are available");
    public boolean eof() {  
    @Override
    public void close() {}
        if (eof()) {
    public int available() {
        short value = (short) BitUtil.VH_BE_SHORT.get(bytes, pos);  
    private int pos;  
 *
    }
import java.io.EOFException;
        pos += count;
    }
package org.opensearch.core.common.io.stream;
        System.arraycopy(bytes, pos, b, offset, len);  
        pos += Integer.BYTES;
 * this work for additional information regarding copyright ownership.
    }  
    public void reset(byte[] bytes) {  
    }
    @Override
        }  
    public int getPosition() {
import java.io.IOException;
 * This is used as a replacement of Lucene ByteArrayDataInput for abstracting byte order changes  
 *      http://www.apache.org/licenses/LICENSE-2.0  
        pos += len;
 * compatible open source license.
        reset(BytesRef.EMPTY_BYTES);  
        return limit - pos;  
    }
    public void readBytes(byte[] b, int offset, int len) throws EOFException {
 * limitations under the License.  
        return pos;
public class BytesStreamInput extends StreamInput {
/**
