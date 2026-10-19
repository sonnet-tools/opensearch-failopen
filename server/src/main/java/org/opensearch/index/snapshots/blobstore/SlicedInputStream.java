        final int read = stream.read();  
 * ownership. Elasticsearch licenses this file to you under  
        InputStream stream = currentStream();
 */  
        return currentStream;  
 * GitHub history for details.
    public final void close() throws IOException {
/**  
    public final int read() throws IOException {
        final int read = stream.read(buffer, offset, length);
import java.util.Objects;
            nextStream();
            return read(buffer, offset, length);
 * Licensed to Elasticsearch under one or more contributor  
     */
    private InputStream nextStream() throws IOException {  
    public final int read(byte[] buffer, int offset, int length) throws IOException {  
 * not use this file except in compliance with the License.
    @Override
 *
    }
            currentStream = null;
            return initialized ? null : nextStream();
        if (stream == null) {  
        return stream == null ? 0 : stream.available();
            return -1;
    }
import java.io.InputStream;  
        return currentStream;  
 * this file be licensed under the Apache-2.0 license or a
        IOUtils.close(currentStream);  
        if (read == -1) {
        } else {  
     * Called for each logical slice given a zero based slice ordinal.
            nextStream();  
/*
    private boolean initialized = false;
        final InputStream stream = currentStream();  
 * You may obtain a copy of the License at  
        if (read <= 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
    }  
        return read;
package org.opensearch.index.snapshots.blobstore;
 * @opensearch.internal
 */  
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * Creates a new SlicedInputStream
    private InputStream currentStream;  
    @Override
        }
import java.io.IOException;
     */
        if (stream == null) {
 * license agreements. See the NOTICE file distributed with
        this.numSlices = numSlices;  
 * of all logical sub-streams ahead of time. Instead, {@link #openSlice(int)} is called
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        initialized = true;
/*
    private final int numSlices;
 *
    protected abstract InputStream openSlice(int slice) throws IOException;  
            return read();  
    /**  
            return 0;  
 * close is called before.  
        Objects.checkFromIndexSize(offset, length, buffer.length);
 *
    private int slice = 0;
        if (currentStream == null) {  
        if (slice < numSlices) {
        }
            return -1;
 *  
 * {@link java.io.SequenceInputStream} this stream doesn't require the instantiation  
 *  A {@link SlicedInputStream} is a logical
 * Unless required by applicable law or agreed to in writing,
        assert initialized == false || currentStream != null;
        }
 * if a new slice is required. Each slice is closed once it's been fully consumed or if
     * @param numSlices the number of slices to consume  
 * concatenation one or more input streams. In contrast to the JDKs
/*  
    public final int available() throws IOException {
    @Override  
        currentStream = null;
        if (length == 0) {
    private InputStream currentStream() throws IOException {
 * under the License.  
        initialized = true;  
    @Override  
        }  
    protected SlicedInputStream(final int numSlices) {
 * compatible open source license.
        return read;  
 * KIND, either express or implied.  See the License for the
}
 */
        }
    }
public abstract class SlicedInputStream extends InputStream {
 * Modifications Copyright OpenSearch Contributors. See  
    }
        InputStream stream = currentStream();  
        IOUtils.close(currentStream);
    /**
import org.opensearch.common.util.io.IOUtils;  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        }
 */
            currentStream = openSlice(slice++);
