 * this work for additional information regarding copyright
        out.flush();
 * this file be licensed under the Apache-2.0 license or a
import java.io.Reader;
                currentLimit = limitOnLastMark;
        char[] buffer = new char[BUFFER_SIZE];
                throw new IllegalArgumentException("limit must be non-negative");
     * Wraps an {@link InputStream} such that it's {@code close} method becomes a noop
    }
    /**
     * @param stream {@code InputStream} to wrap
        }
        return out.bytes();
    }
        public long skip(long n) throws IOException {
    public static List<String> readAllLines(InputStream input) throws IOException {
     * @param in  the byte array to copy from
        return new LimitedInputStream(in, limit);
        @Override
            currentLimit -= skipped;
            delegate.reset();
 * and close all affected streams when done.
     * A wrapper around an {@link InputStream} that limits the number of bytes that can be read from the stream.
            super(in);
        public void write(byte[] b, int off, int len) {
    // Copy methods for java.io.Reader / java.io.Writer
import java.io.InputStreamReader;
     * @throws IOException in case of I/O errors
        Objects.requireNonNull(in, "No input byte array specified");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
     * Closes the stream when done.
import org.opensearch.core.common.bytes.BytesReference;
        try (OutputStream out2 = out) {
     * @return the number of characters copied
import org.opensearch.core.common.io.stream.BytesStream;
        @Override
            final int result;
        }
     * close is called.
        return lines;
        private static final long NO_MARK = -1L;
    }
        public void close() throws IOException {
        Objects.requireNonNull(out, "No OutputStream specified");
     * Closes the write when done.
            }
     */
            if (limit < 0L) {
     *
     * Copy the contents of the given byte array to the given OutputStream.
import java.io.FilterInputStream;
        }
 * but also useful for application code.
     * @return wrapped {@code InputStream}
     *
    }
import java.io.IOException;
    }
        @Override
        @Override
        @Override
     */
        try (Reader in2 = in; Writer out2 = out) {
                return result;
 */
 * Mainly for use within the framework,
    public static BytesStream flushOnCloseStream(BytesStream os) {
}
        int bytesRead;
     * @opensearch.internal
 * compatible open source license.
     * Closes both when done.
    }
    /**
 * @opensearch.internal
    private static int doCopy(Reader in, Writer out) throws IOException {
     *
     */
    }
            if (limitOnLastMark != NO_MARK) {
    public static int copy(Reader in, Writer out) throws IOException {
        Objects.requireNonNull(in, "No Reader specified");
            }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        int byteCount = 0;
        @Override
/*
     * Reads all bytes from the given {@link InputStream} and closes it afterwards.
     */
/*
     * to be used and the stream cannot be closed until the bytes have been consumed.
        }
 * GitHub history for details.
     */
            flush();
        @Override
    // ---------------------------------------------------------------------
    /**
     * @throws IOException in case of I/O errors
            }
        copy(in, out);
            this.currentLimit = limit;
    // ---------------------------------------------------------------------
 * The OpenSearch Contributors require contributions made to
     * Limits the given input stream to the provided number of bytes
import java.io.OutputStream;
            // no-op
 * Unless required by applicable law or agreed to in writing,
        return reader.readNBytes(dest, 0, dest.length);
                currentLimit -= result;
            out.write(buffer, 0, bytesRead);
    /**
            return Math.toIntExact(Math.min(in.available(), currentLimit));
import java.io.StringWriter;
            byteCount += bytesRead;
            delegate.writeByte(b);
     */
    public static InputStream noCloseStream(InputStream stream) {
package org.opensearch.common.io;
        public int available() throws IOException {
     */
            this.limitOnLastMark = NO_MARK;
                // noop
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
    /**
    public static BytesReference readFully(InputStream in) throws IOException {
     * A wrapper around a {@link BytesStream} that makes the close operation a flush. This is
        }
            final int result;
        }
        try (Writer out2 = out) {
 * Licensed to Elasticsearch under one or more contributor
            return delegate.bytes();
            delegate.writeBytes(b, offset, length);
 *
        }
        @Override
        public void flush() throws IOException {
 *
            in.mark(readlimit);
            public void close() {
 *
        }
 * <p>
            out2.write(in);
                return result;
            if (currentLimit == 0 || (result = in.read()) == -1) {
import java.util.Objects;
     * @throws IOException in case of I/O errors
            @Override
        @Override
        public void writeBytes(byte[] b, int offset, int length) throws IOException {
    @Deprecated
        return byteCount;
    public static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
    }
        @Override
        @Override
 */
    /**
     * @return the String that has been copied to
        private final BytesStream delegate;
 * SPDX-License-Identifier: Apache-2.0
    };
        readAllLines(input, lines::add);
        }
    public static InputStream limitStream(InputStream in, long limit) {
            out2.write(in);
        return new FlushOnCloseOutputStream(os);
    }
 *
     */
            }
            in.close();
public abstract class Streams {
    public static String copyToString(Reader in) throws IOException {
        }
/**
        public int read() throws IOException {
        LimitedInputStream(InputStream in, long limit) {
 * KIND, either express or implied.  See the License for the
     * Copy the contents of the given String to the given output Writer.
    private static class FlushOnCloseOutputStream extends BytesStream {
        @Override
import java.util.List;
     *
     * Wraps the given {@link BytesStream} in a {@link StreamOutput} that simply flushes when
            this.delegate = bytesStreamOutput;
 * under the License.
        }
        // exceptions to the main exception
        }
        // Leverage try-with-resources to close in and out so that exceptions in close() are either propagated or added as suppressed
    public static int readFully(InputStream reader, byte[] dest) throws IOException {
    /**
        public synchronized void reset() throws IOException {
import org.opensearch.common.io.stream.BytesStreamOutput;
        BytesStreamOutput out = new BytesStreamOutput();
    public static void readAllLines(InputStream input, Consumer<String> consumer) throws IOException {
            delegate.flush();
import java.io.Writer;
            } else {
     *
 * the Apache License, Version 2.0 (the "License"); you may
        private long limitOnLastMark;
/*
     * @param in  the String to copy from
        }
                currentLimit--;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static void copy(byte[] in, OutputStream out) throws IOException {
        private long currentLimit; // is always non-negative
        }
import java.util.ArrayList;
            // no-op
    /**
     * @throws IOException in case of I/O errors
        return org.opensearch.common.util.io.Streams.copy(inputStream, NULL_OUTPUT_STREAM);
    }
        public void write(int b) {
        public BytesReference bytes() {
        Objects.requireNonNull(out, "No Writer specified");
     */
     * Fully consumes the input stream, throwing the bytes away. Returns the number of bytes consumed.
        }
        }
 * You may obtain a copy of the License at
        final List<String> lines = new ArrayList<>();
     * OutputStream that just throws all the bytes away
import java.io.InputStream;
                return -1;
        private FlushOnCloseOutputStream(BytesStream bytesStreamOutput) {
        public void writeByte(byte b) throws IOException {
        return out.toString();
        public int read(byte[] b, int off, int len) throws IOException {
            return doCopy(in2, out2);
        }
     */
            }
        public void reset() throws IOException {
            return skipped;
    }
 * software distributed under the License is distributed on an
     * @param in  the Reader to copy from
        @Override
            }
        Objects.requireNonNull(in, "No input String specified");
    }
     */
    public static void copy(String in, Writer out) throws IOException {
     *
            limitOnLastMark = currentLimit;
        public void close() throws IOException {
        }
     */
import java.util.function.Consumer;
            while ((line = reader.readLine()) != null) {
     * Copy the contents of the given Reader into a String.
    public static long consumeFully(InputStream inputStream) throws IOException {
    public static final int BUFFER_SIZE = 1024 * 8;
        }
        public synchronized void mark(int readlimit) {
                return -1;
                consumer.accept(line);
import java.nio.charset.StandardCharsets;
 * not use this file except in compliance with the License.
import java.io.BufferedReader;
        }
    /**
    }
        StringWriter out = new StringWriter();
    }
     *
        return new FilterInputStream(stream) {
        }
        @Override
     * @opensearch.internal
     * needed as sometimes a stream will be closed but the bytes that the stream holds still need
 * All copy methods use a block size of 4096 bytes,
     * @param out the OutputStream to copy to
    /**
            final long skipped = in.skip(Math.min(n, currentLimit));
    /**
     * Copy the contents of the given Reader to the given Writer.
 * Simple utility methods for file and stream copying.
        Objects.requireNonNull(out, "No Writer specified");
        while ((bytesRead = in.read(buffer)) != -1) {
     * @param in the reader to copy from
        org.opensearch.common.util.io.Streams.copy(in, out);
     * Closes the reader when done.
     * @param out the Writer to copy to
            in.reset();
    static class LimitedInputStream extends FilterInputStream {
 * license agreements. See the NOTICE file distributed with
 */
 * ownership. Elasticsearch licenses this file to you under
        };
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    /**
     * @param out the Writer to copy to
            String line;
            if (currentLimit == 0 || (result = in.read(b, off, Math.toIntExact(Math.min(len, currentLimit)))) == -1) {
    }
            } else {
