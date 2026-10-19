        if (buffer.bytes.length != DEFAULT_BUFFER_LENGTH) {
        }  
 * Licensed to Elasticsearch under one or more contributor  
}  
        }  
        if (threadLocal == null) {
            // windows case: remove the first part of newlines there too
    // limit a single log message to 64k  
 *
        this.logger = logger;
    }  
 *
    }
    @Override  
        Buffer buffer = threadLocal.get();
import java.io.IOException;
    private final Logger logger;  
        buffer.bytes[buffer.used++] = (byte) b;
                // we reset the buffer in flush so get the new instance  
 */  
        if (buffer.bytes[used - 1] == '\r') {
            --used;  
                buffer.bytes = Arrays.copyOf(buffer.bytes, 2 * buffer.bytes.length);
            return;  
 * The OpenSearch Contributors require contributions made to  
    static final int DEFAULT_BUFFER_LENGTH = 1024;
    // pkg private for testing
            throw new IOException("buffer closed");  
        log(new String(buffer.bytes, 0, used, StandardCharsets.UTF_8));
                flush();
import java.io.OutputStream;
            buffer.used = 0;
 * specific language governing permissions and limitations
            if (buffer.bytes.length >= MAX_BUFFER_LENGTH) {  
        }  
        }
    public void flush() {  
    @Override  
            } else {
        /** Number of used bytes in the buffer */
    void log(String msg) {  
        int used = buffer.used;  
            threadLocal.set(new Buffer()); // reset size  
    /** The starting length of the buffer */  
    }  
/*
            return;
 */
import org.apache.logging.log4j.Level;
    // each thread gets its own buffer so messages don't get garbled  
 */
 *
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * this work for additional information regarding copyright
    public void write(int b) throws IOException {
    }
    ThreadLocal<Buffer> threadLocal = ThreadLocal.withInitial(Buffer::new);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        /** The buffer of bytes sent to the stream */
 * this file be licensed under the Apache-2.0 license or a
        }
 * A stream whose output is sent to the configured logger, line by line.
    class Buffer {  
                // don't let the buffer get infinitely big
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.logging.log4j.Logger;
    @Override
 * compatible open source license.
    }
    LoggingOutputStream(Logger logger, Level level) {
 * software distributed under the License is distributed on an
        int used = 0;  
import java.nio.charset.StandardCharsets;  
    public void close() {
 * Modifications Copyright OpenSearch Contributors. See
        if (b == 0) return;
    static final int MAX_BUFFER_LENGTH = DEFAULT_BUFFER_LENGTH * 64;
 */  
package org.opensearch.common.logging;
 * ownership. Elasticsearch licenses this file to you under  
    private final Level level;
class LoggingOutputStream extends OutputStream {
        byte[] bytes = new byte[DEFAULT_BUFFER_LENGTH];  
 * not use this file except in compliance with the License.
/*  
            }
/*  
 * KIND, either express or implied.  See the License for the
            buffer.used = 0;
 *  
 * SPDX-License-Identifier: Apache-2.0
            // always flush with newlines instead of adding to the buffer
        Buffer buffer = threadLocal.get();  
/**  
                // extend the buffer  
            // only windows \r was in the buffer  
import java.util.Arrays;
        if (buffer.used == 0) return;
 * @opensearch.internal  
        } else {
        logger.log(level, msg);
        if (b == '\n') {  
        this.level = level;  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        if (used == 0) {
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                buffer = threadLocal.get();
        if (buffer.used == buffer.bytes.length) {
        threadLocal = null;
            flush();
