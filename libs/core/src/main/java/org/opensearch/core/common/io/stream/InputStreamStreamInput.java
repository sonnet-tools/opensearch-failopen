    }  
 */  
    @Override
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        is.reset();
 *
    public boolean markSupported() {
    }
     * @param is the input stream to wrap
    public void reset() throws IOException {  
    public int read(byte[] b) throws IOException {  
    }  
        return is.read();
    }
    }  
    public byte readByte() throws IOException {
        this.is = is;
    }  
    private final long sizeLimit;
    @Override  
    /**  
        is.close();
    @Override
 *
 */  
 * You may obtain a copy of the License at  
     */  
    @Override  
    @Override
    public InputStreamStreamInput(InputStream is, long sizeLimit) {
    @Override  
    }  
    protected void ensureCanReadBytes(int length) throws EOFException {  
    }
        }
    }
    }
    public int read(byte[] b, int off, int len) throws IOException {
 * this work for additional information regarding copyright
    }
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * Main input stream for input data  
    public void readBytes(byte[] b, int offset, int len) throws IOException {  
    public int available() throws IOException {
     * @param sizeLimit a hard limit of the number of bytes in the given input stream. This is used for internal input validation
        if (sizeLimit < 0) {  
import java.io.InputStream;  
    public InputStreamStreamInput(InputStream is) {
/*  
 * @opensearch.internal
        return is.skip(n);
 * ownership. Elasticsearch licenses this file to you under  
            throw new EOFException("tried to read: " + length + " bytes but this stream is limited to: " + sizeLimit);
    }
 * Unless required by applicable law or agreed to in writing,
        if (read != len) {  
        if (ch < 0) throw new EOFException();
public class InputStreamStreamInput extends StreamInput {
 */  
    @Override
            throw new EOFException();
 *
    /**
 * KIND, either express or implied.  See the License for the
package org.opensearch.core.common.io.stream;
 * SPDX-License-Identifier: Apache-2.0
        return is.read(b, off, len);  
        if (len < 0) throw new IndexOutOfBoundsException();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final int read = is.readNBytes(b, offset, len);
    public void mark(int readlimit) {
     * Creates a new InputStreamStreamInput with unlimited size
 * Licensed to Elasticsearch under one or more contributor  
        this(is, Long.MAX_VALUE);
 * specific language governing permissions and limitations
    @Override
    @Override
     */  
        return (byte) (ch);
/*  
     * @param is the input stream to wrap
    }
}
/**
        if (length > sizeLimit) {
        int ch = is.read();  
        return is.markSupported();  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * compatible open source license.
/*
        }  
 * license agreements. See the NOTICE file distributed with
    @Override
    private final InputStream is;  
        this.sizeLimit = sizeLimit;  
    public long skip(long n) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        return is.available();  
        }
            throw new IllegalArgumentException("size limit must be positive");
 * under the License.  
import java.io.EOFException;
    public int read() throws IOException {
     * Creates a new InputStreamStreamInput with a size limit  
    @Override
    }  
        return is.read(b);
 * not use this file except in compliance with the License.
        is.mark(readlimit);
    public void close() throws IOException {  
