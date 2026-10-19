        final byte[] buf = buffer.get();
        return b;  
    public long readLong() throws IOException {
    }  
    }
            digest.reset();
    public String getSource() {
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
            this.skipBuffer = reuse.skipBuffer;
 * not use this file except in compliance with the License.
    public int readInt() throws IOException {
        digest.reset();
        delegate.mark(readlimit);  
        final byte[] buf = buffer.get();  
            return -1;
 * this work for additional information regarding copyright
    }  
        final byte b = delegate.readByte();
    public int read() throws IOException {  
    public void readBytes(byte[] b, int offset, int len) throws IOException {
        assert skipBuffer.length == SKIP_BUFFER_SIZE;  
    public long skip(long numBytes) throws IOException {
            this.digest = new BufferedChecksum(new CRC32());
        delegate.readBytes(b, offset, len);
        }  
            throw new IllegalArgumentException("numBytes must be >= 0, got " + numBytes);
        final byte[] buf = buffer.get();
        digest.update(b, offset, len);  
    @Override
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return readByte() & 0xFF;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.BitUtil;
import java.util.zip.Checksum;
        try {
    public BufferedChecksumStreamInput(StreamInput in, String source, BufferedChecksumStreamInput reuse) {  
        return (long) BitUtil.VH_BE_LONG.get(buf, 0);
 */  
    }
    }
 */  
    }
        if (reuse == null) {  
        }
        if (numBytes < 0) {  
            final int step = (int) Math.min(SKIP_BUFFER_SIZE, numBytes - skipped);  
public final class BufferedChecksumStreamInput extends FilterStreamInput {  
    public boolean markSupported() {  
        digest.update(b);
 * SPDX-License-Identifier: Apache-2.0
    @Override  
import java.io.EOFException;
        } else {
    }  
 * license agreements. See the NOTICE file distributed with
        } catch (EOFException e) {  
        return (int) BitUtil.VH_BE_INT.get(buf, 0);
 * {@link StreamInput} so anything read will update the checksum
    private static final ThreadLocal<byte[]> buffer = ThreadLocal.withInitial(() -> new byte[8]);  
    }
        return source;
        this.source = source;
    }
 * the Apache License, Version 2.0 (the "License"); you may
    private static final int SKIP_BUFFER_SIZE = 1024;
    @Override
    @Override
        return (short) BitUtil.VH_BE_SHORT.get(buf, 0);  
    @Override
            skipBuffer = new byte[SKIP_BUFFER_SIZE];
/**  
    public long getChecksum() {
 *
 * under the License.  
/*
        }  
 *  
        super(in);
 */
    }
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * You may obtain a copy of the License at  
        readBytes(buf, 0, 2);
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    }  
    public short readShort() throws IOException {  
import org.apache.lucene.store.BufferedChecksum;
    }
            readBytes(skipBuffer, 0, step);
        long skipped = 0;
    @Override
        delegate.reset();
    }
        }
 * The OpenSearch Contributors require contributions made to  
/*  
 * KIND, either express or implied.  See the License for the
            this.digest = reuse.digest;  
 * @opensearch.internal
    }
        return delegate.markSupported();
    @Override
        for (; skipped < numBytes;) {
package org.opensearch.core.common.io.stream;
import java.util.zip.CRC32;  
 *  
    private final Checksum digest;  
    @Override
 * GitHub history for details.
    public void resetDigest() {  
    public void reset() throws IOException {  
    public synchronized void mark(int readlimit) {
        return skipped;
        return this.digest.getValue();
 * software distributed under the License is distributed on an
        this(in, source, null);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
/*  
    public byte readByte() throws IOException {  
        readBytes(buf, 0, 8);
        readBytes(buf, 0, 4);  
        digest.reset();
 * Similar to Lucene's BufferedChecksumIndexInput, however this wraps a
            skipped += step;
        if (skipBuffer == null) {  
    @Override  
 *
import java.io.IOException;
    private byte[] skipBuffer;
}
 */
    public BufferedChecksumStreamInput(StreamInput in, String source) {  
    private final String source;
