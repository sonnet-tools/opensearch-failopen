        if (end == start) {
 *  
    public void flush() {
 * Modifications Copyright OpenSearch Contributors. See
            }  
 */
 * SPDX-License-Identifier: Apache-2.0
    /** Offset of the end (semi-open) of unwritten data in the buffer */  
 * Allows setting an optional prefix before each line of output.  
                start = 0;
        }
            // always flush with newlines instead of adding to the buffer  
 */
        if (end == buffer.length) {
            } else {  
                end = len;
        start = end;  
                System.arraycopy(buffer, start, buffer, 0, len);  
            if (start != 0) {  
    public void write(final int b) throws IOException {
 * software distributed under the License is distributed on an
/*
    @Override  
            flush();
    }
            return;  
import java.util.Arrays;  
            return;
                int len = end - start;
 *
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * The stream will be flushed whenever a newline is detected.
        buffer[end++] = (byte) b;  
    private static final int DEFAULT_BUFFER_LENGTH = 4096;
 * Licensed to Elasticsearch under one or more contributor  
}
    @Override  
    }
 */  
    /** The starting length of the buffer */  
    /** The buffer of bytes sent to the stream */  
 * Unless required by applicable law or agreed to in writing,
        if (b == '\n') {
 * The OpenSearch Contributors require contributions made to  
    private byte[] buffer = new byte[DEFAULT_BUFFER_LENGTH];
        if (b == 0) {
import java.io.IOException;
import java.io.OutputStream;
                buffer = Arrays.copyOf(buffer, buffer.length + DEFAULT_BUFFER_LENGTH);
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** Offset of the start of unwritten data in the buffer */  
        }
 * this work for additional information regarding copyright
/*  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
    private int start = 0;
        logLine(new String(buffer, start, end - start));
                // otherwise extend the buffer
        }  
    private int end = 0;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
                // first try shifting the used buffer back to the beginning to make space
/**
 * compatible open source license.
/*  
 * license agreements. See the NOTICE file distributed with
 */  
            return;  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * <p>
public abstract class LoggingOutputStream extends OutputStream {
package org.opensearch.gradle;
 * Writes data passed to this stream as log messages.  
    protected abstract void logLine(String line);  
        }
