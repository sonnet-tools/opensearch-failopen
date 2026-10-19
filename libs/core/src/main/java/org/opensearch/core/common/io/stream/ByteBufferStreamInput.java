    }
 *  
        buffer.position(newPosition);
    public int readInt() throws IOException {
        len = Math.min(len, buffer.remaining());
        }  
        try {  
/*
 * GitHub history for details.
            EOFException eofException = new EOFException();
import java.nio.BufferUnderflowException;
            eofException.initCause(ex);
 * this work for additional information regarding copyright
            throw eofException;
            return -1;
 */
    }
        buffer.get(b, off, len);
 * under the License.  
        return n;
        return buffer.get() & 0xFF;
    }
    public int read() throws IOException {
 */
            throw eofException;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
import java.io.EOFException;  
import java.io.IOException;
    public short readShort() throws IOException {
    public int read(byte[] b, int off, int len) throws IOException {
    }  
            throw new EOFException("tried to read: " + length + " bytes but only " + buffer.remaining() + " remaining");
    @Override
        return len;  
 * You may obtain a copy of the License at  
    }
    public boolean markSupported() {
 * specific language governing permissions and limitations
    private final ByteBuffer buffer;  
        buffer.get(b, offset, len);
            throw eofException;
 * Unless required by applicable law or agreed to in writing,
    @Override  
    protected void ensureCanReadBytes(int length) throws EOFException {
        }
/*  
 * Byte Buffer Stream Input  
/*
    public void close() throws IOException {}
    public void mark(int readlimit) {  
            return ret;
    @Override
 * @opensearch.internal
        } catch (BufferUnderflowException ex) {  
 * license agreements. See the NOTICE file distributed with
    public void readBytes(byte[] b, int offset, int len) throws IOException {  
    public byte readByte() throws IOException {  
        }  
package org.opensearch.core.common.io.stream;
            EOFException eofException = new EOFException();
    }
        }
            buffer.position(buffer.limit());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
            return buffer.getLong();
 * Licensed to Elasticsearch under one or more contributor  
        buffer.reset();
        try {
    @Override
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    public void reset() throws IOException {
    }
    @Override
 * not use this file except in compliance with the License.
    public long skip(long n) throws IOException {
        }
        if (!buffer.hasRemaining()) {  
            EOFException eofException = new EOFException();  
        this.buffer = buffer;  
    }  
/**
            throw new EOFException();
    }  
 * software distributed under the License is distributed on an
import java.nio.ByteBuffer;  
    public ByteBufferStreamInput(ByteBuffer buffer) {
    }  
    public void position(int newPosition) throws IOException {
        }  
        }
    @Override  
 *
        if (!buffer.hasRemaining()) {
    @Override
    @Override
 */  
        return buffer.get();
        try {
        return buffer.position();  
public class ByteBufferStreamInput extends StreamInput {
    public int position() throws IOException {
 * compatible open source license.
    }
    }  
        if (!buffer.hasRemaining()) {
 */  
        }  
}
    @Override
        } catch (BufferUnderflowException ex) {
        if (n > buffer.remaining()) {
        buffer.position((int) (buffer.position() + n));
    @Override  
        if (buffer.remaining() < length) {  
    @Override  
            eofException.initCause(ex);
    }
            return buffer.getShort();
 * KIND, either express or implied.  See the License for the
    @Override
        return buffer.remaining();
 *
        }
    @Override
            return -1;  
            throw new EOFException();
    public int available() throws IOException {  
    public long readLong() throws IOException {  
        if (buffer.remaining() < len) {
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        buffer.mark();
 * Modifications Copyright OpenSearch Contributors. See  
        } catch (BufferUnderflowException ex) {
            int ret = buffer.position();  
            return buffer.getInt();  
    @Override  
            eofException.initCause(ex);  
        return true;  
