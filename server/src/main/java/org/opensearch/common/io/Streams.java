        }  
    @Deprecated
                consumer.accept(line);  
 * this file be licensed under the Apache-2.0 license or a
        out.flush();
        private FlushOnCloseOutputStream(BytesStream bytesStreamOutput) {
    /**  
 * All copy methods use a block size of 4096 bytes,
    /**  
            return Math.toIntExact(Math.min(in.available(), currentLimit));
     * @opensearch.internal  
        private static final long NO_MARK = -1L;
        @Override
        Objects.requireNonNull(in, "No Reader specified");
        @Override
     *
     * @param stream {@code InputStream} to wrap
     * @opensearch.internal
        try (Writer out2 = out) {
    public static void copy(byte[] in, OutputStream out) throws IOException {
        @Override
        copy(in, out);
        }
        }
 * under the License.  
import java.util.List;
    };  
        }  
            // no-op
     */
    /**
        return new LimitedInputStream(in, limit);
        return out.toString();
            limitOnLastMark = currentLimit;  
     *
    private static int doCopy(Reader in, Writer out) throws IOException {
            public void close() {
    /**
     * Copy the contents of the given String to the given output Writer.  
        @Override  
        int bytesRead;
            final long skipped = in.skip(Math.min(n, currentLimit));  
 *  
            this.limitOnLastMark = NO_MARK;  
    public static int copy(Reader in, Writer out) throws IOException {
import java.util.ArrayList;
     */
 */  
        }  
 *
    public static void readAllLines(InputStream input, Consumer<String> consumer) throws IOException {
import java.io.BufferedReader;  
import java.io.InputStreamReader;
     */  
            delegate.writeByte(b);
        @Override
        }  
    }  
     * @throws IOException in case of I/O errors  
     * @param in  the Reader to copy from
        org.opensearch.common.util.io.Streams.copy(in, out);  
    public static int readFully(InputStream reader, byte[] dest) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
    static class LimitedInputStream extends FilterInputStream {
    }
     * Fully consumes the input stream, throwing the bytes away. Returns the number of bytes consumed.
            flush();
import java.io.OutputStream;
 */  
    public static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
     * Closes the write when done.
/*  
package org.opensearch.common.io;
            @Override
        // exceptions to the main exception
        return lines;
        public synchronized void reset() throws IOException {
        public int read() throws IOException {
        public void close() throws IOException {
            return skipped;
     * A wrapper around a {@link BytesStream} that makes the close operation a flush. This is  
        try (Reader in2 = in; Writer out2 = out) {  
    /**
        @Override  
import org.opensearch.core.common.io.stream.BytesStream;  
        }
/*  
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {  
        }
     * @return the number of characters copied
    /**
        Objects.requireNonNull(out, "No OutputStream specified");  
    /**
        Objects.requireNonNull(in, "No input String specified");
            out2.write(in);
    /**
    public static BytesReference readFully(InputStream in) throws IOException {
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        }  
     * @throws IOException in case of I/O errors
        try (OutputStream out2 = out) {
     * OutputStream that just throws all the bytes away  
        @Override
 * You may obtain a copy of the License at  
        final List<String> lines = new ArrayList<>();  
import java.util.function.Consumer;
     */
    }  
import org.opensearch.core.common.bytes.BytesReference;
     * @param in the reader to copy from
    }
            return delegate.bytes();
 * Modifications Copyright OpenSearch Contributors. See
        while ((bytesRead = in.read(buffer)) != -1) {  
    }  
     * @param out the Writer to copy to
        return new FilterInputStream(stream) {  
        private final BytesStream delegate;
    /**
import java.io.StringWriter;
            if (limit < 0L) {
    }
        private long limitOnLastMark;
            }
            final int result;
import java.io.InputStream;  
 * GitHub history for details.
                return -1;  
            currentLimit -= skipped;
            out2.write(in);
/**  
     * to be used and the stream cannot be closed until the bytes have been consumed.
     * Reads all bytes from the given {@link InputStream} and closes it afterwards.
        @Override
        };
     * @param in  the String to copy from  
     */  
                currentLimit--;  
            if (currentLimit == 0 || (result = in.read(b, off, Math.toIntExact(Math.min(len, currentLimit)))) == -1) {
        char[] buffer = new char[BUFFER_SIZE];
            }
     *
    }
        public BytesReference bytes() {
                // noop  
    public static List<String> readAllLines(InputStream input) throws IOException {
        return new FlushOnCloseOutputStream(os);
     *
import java.nio.charset.StandardCharsets;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
                return -1;
public abstract class Streams {
    }  
     */  
            } else {
     */
import java.io.Writer;
        public void writeByte(byte b) throws IOException {  
            out.write(buffer, 0, bytesRead);
        return reader.readNBytes(dest, 0, dest.length);
            delegate.flush();
            in.mark(readlimit);
        BytesStreamOutput out = new BytesStreamOutput();
 * Simple utility methods for file and stream copying.
 * Unless required by applicable law or agreed to in writing,
        @Override  
    public static InputStream limitStream(InputStream in, long limit) {
        StringWriter out = new StringWriter();  
        @Override  
        public void reset() throws IOException {
                return result;
        LimitedInputStream(InputStream in, long limit) {  
 * <p>
        // Leverage try-with-resources to close in and out so that exceptions in close() are either propagated or added as suppressed
        }
            }
        public void write(byte[] b, int off, int len) {  
            in.reset();
        readAllLines(input, lines::add);
 * specific language governing permissions and limitations
        Objects.requireNonNull(out, "No Writer specified");  
        public int read(byte[] b, int off, int len) throws IOException {  
     */  
            delegate.reset();  
        }  
     */  
            }
 * @opensearch.internal
    /**
        Objects.requireNonNull(out, "No Writer specified");  
        public int available() throws IOException {  
        }
import java.util.Objects;  
        private long currentLimit; // is always non-negative  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
    }  
     * Closes the reader when done.
            // no-op
        }
            }
import java.io.IOException;
    /**
}
 * software distributed under the License is distributed on an
            return doCopy(in2, out2);
     */
        int byteCount = 0;  
        public void close() throws IOException {  
     * @param out the OutputStream to copy to
    }
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * this work for additional information regarding copyright
     * Copy the contents of the given Reader to the given Writer.
            this.delegate = bytesStreamOutput;
            this.currentLimit = limit;
     *  
            if (limitOnLastMark != NO_MARK) {  
     * @param out the Writer to copy to  
    public static void copy(String in, Writer out) throws IOException {
        @Override
 */
        Objects.requireNonNull(in, "No input byte array specified");
                return result;  
            super(in);
 * and close all affected streams when done.  
    private static class FlushOnCloseOutputStream extends BytesStream {  
            if (currentLimit == 0 || (result = in.read()) == -1) {  
        return org.opensearch.common.util.io.Streams.copy(inputStream, NULL_OUTPUT_STREAM);
        public void writeBytes(byte[] b, int offset, int length) throws IOException {
    public static BytesStream flushOnCloseStream(BytesStream os) {  
            } else {
        }
            String line;
            in.close();  
        }  
        public long skip(long n) throws IOException {
            }
            while ((line = reader.readLine()) != null) {
 * license agreements. See the NOTICE file distributed with
            delegate.writeBytes(b, offset, length);  
     * Closes both when done.  
     *  
     *
            byteCount += bytesRead;
        public synchronized void mark(int readlimit) {
                currentLimit -= result;
    }  
    // Copy methods for java.io.Reader / java.io.Writer
import java.io.FilterInputStream;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
     * Wraps the given {@link BytesStream} in a {@link StreamOutput} that simply flushes when  
        }
     * Wraps an {@link InputStream} such that it's {@code close} method becomes a noop  
        return byteCount;
        public void flush() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        }
     * @throws IOException in case of I/O errors
        }  
    /**
     * Closes the stream when done.
    // ---------------------------------------------------------------------  
                throw new IllegalArgumentException("limit must be non-negative");  
 * Mainly for use within the framework,
 */  
     * Copy the contents of the given Reader into a String.
        }  
     * close is called.
 * but also useful for application code.  
    public static String copyToString(Reader in) throws IOException {
     * needed as sometimes a stream will be closed but the bytes that the stream holds still need
    }  
    public static long consumeFully(InputStream inputStream) throws IOException {
import java.io.Reader;  
    // ---------------------------------------------------------------------
            final int result;
        public void write(int b) {
     */
     * Limits the given input stream to the provided number of bytes
        }  
     * A wrapper around an {@link InputStream} that limits the number of bytes that can be read from the stream.
 * not use this file except in compliance with the License.
        @Override  
    public static InputStream noCloseStream(InputStream stream) {
        return out.bytes();
import org.opensearch.common.io.stream.BytesStreamOutput;
                currentLimit = limitOnLastMark;
/*
 * ownership. Elasticsearch licenses this file to you under  
        @Override
     * Copy the contents of the given byte array to the given OutputStream.  
     * @return the String that has been copied to
     * @param in  the byte array to copy from  
 *
     */  
    }  
    }
    public static final int BUFFER_SIZE = 1024 * 8;  
     * @throws IOException in case of I/O errors
        @Override  
     * @return wrapped {@code InputStream}  
