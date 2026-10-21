 * software distributed under the License is distributed on an
        }
            throw new IllegalArgumentException("Input stream is not compressed with DEFLATE!");
     * The name to register the compressor by
            }
/*
            buffer.reset();
            return buffer.copyBytes();
    public static String NAME = "DEFLATE";
 * You may obtain a copy of the License at
/*
        }
        }
 * @opensearch.api - registered name requires BWC support
}
    }
        }
        protected final T resource;
 *
import org.opensearch.common.lease.Releasable;
    public static InputStream inputStream(InputStream in, boolean threadLocal) throws IOException {
            assert inUse == false;
            bytesReference.writeTo(dos);
 * under the License.
import java.io.BufferedInputStream;
     *
    }
                try {
public class DeflateCompressor implements Compressor {
        final Releasable releasable;
        } else {
                    releasable.close();
        return new ReleasableReference<>(deflater, deflater::reset);
                // Nested de-compression streams should not happen but we still handle them safely by using a fresh Inflater
        };
        try {
 */
        return HEADER.length;
     * @param threadLocal  whether this stream will only be used on the current thread or not
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private static final int LEVEL = 3;
    }
    @Override
    }
    private static final byte[] HEADER = new byte[] { 'D', 'F', 'L', '\0' };
                    super.close();
                inflater = current.get();
            return resource;
                    // We are ensured to only call this once since we wrap this stream in a BufferedInputStream that will only close
            }
    public boolean isCompressed(BytesReference bytes) {
                    // its delegate once
     * Closing the returned stream will close the provided input stream.
            return buffer.copyBytes();
        @Override
    // want to be able to deal with decompressing bytes references that were read from a decompressing stream.
     * Optionally uses thread-local, pooled resources to save off-heap allocations if the stream is guaranteed to not escape the current
    // a XContent
        final Inflater inflater = inflaterRef.get();
 * not use this file except in compliance with the License.
import org.opensearch.core.compress.Compressor;
        // true if this reference is currently in use and is not available for re-use
            @Override
        final Deflater deflater = deflaterRef.get();
    private static final class ReleasableReference<T> implements Releasable {
                thread = Thread.currentThread();
 * this file be licensed under the Apache-2.0 license or a
        protected ReleasableReference(T resource, Releasable releasable) {
        boolean inUse;
            inflater = new Inflater(true);
    // Reference to a deflater or inflater that is used to make sure we do not use the same stream twice when nesting streams.
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(out, deflater, BUFFER_SIZE, syncFlush);
            }
 * ownership. Elasticsearch licenses this file to you under
 * Licensed to Elasticsearch under one or more contributor
import java.util.Arrays;
    @Override
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
    // Reusable Deflater reference. Note: This is a separate instance from the one used for the compressing stream wrapper because we
        final Releasable releasable;
        try {
        private final Releasable releasable;
     * Creates a new input stream that decompresses the contents read from the provided input stream.
            bytesReference.slice(HEADER.length, bytesReference.length() - HEADER.length).writeTo(ios);
        return new ReleasableReference<>(inflater, inflater::reset);
    }
            releasable = deflater::end;
        return true;
        T get() {
    private static final ThreadLocal<ReleasableReference<Inflater>> inflaterForStreamRef = ThreadLocal.withInitial(() -> {
 * GitHub history for details.
        return inputStream(in, true);
    public int headerLength() {
            releasable = inflater::end;
                closed = true;
        final Inflater inflater = new Inflater(true);
                releasable = inflater::end;
 * The OpenSearch Contributors require contributions made to
            // Nested compression streams should not happen but we still handle them safely by using a fresh Deflater
            inflater.reset();
    public OutputStream threadLocalOutputStream(OutputStream out) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 */
     */
import java.util.zip.InflaterInputStream;
            // Due to https://bugs.openjdk.java.net/browse/JDK-8054565 we can't rely on the buffered output stream to only close once
            releasable = current;
import java.io.BufferedOutputStream;
                    super.close();
    // Reusable deflater reference for streaming compression
     */
        }
import java.util.zip.Deflater;
            private boolean closed = false;
    // It needs to be different from other compressors and to not be specific
        if (bytes.length() < HEADER.length) {
        final ReleasableReference<Deflater> current = deflaterForStreamRef.get();
        } finally {
 * the Apache License, Version 2.0 (the "License"); you may
        }
     * @opensearch.api - requires BWC support
            buffer.reset();
    private static final ThreadLocal<BytesStreamOutput> baos = ThreadLocal.withInitial(BytesStreamOutput::new);
    @Override
        }, BUFFER_SIZE);
import org.opensearch.core.Assertions;
            this.resource = resource;
            }
    @PublicApi(since = "2.10.0")
            this.releasable = releasable;
            final ReleasableReference<Inflater> current = inflaterForStreamRef.get();
 *
    private static final ThreadLocal<Deflater> deflaterRef = ThreadLocal.withInitial(() -> new Deflater(LEVEL, true));
            }
        if (current.inUse) {
import java.util.zip.Inflater;
                assert thread == Thread.currentThread() : "Opened on ["
            if (Assertions.ENABLED) {
        try (DeflaterOutputStream dos = new DeflaterOutputStream(buffer, deflater, true)) {
        final Deflater deflater;
    });
        final Inflater inflater;
            } else {
    private static final ThreadLocal<ReleasableReference<Deflater>> deflaterForStreamRef = ThreadLocal.withInitial(() -> {
                    return;
        final Deflater deflater = new Deflater(LEVEL, true);
                return false;
            if (bytes.get(i) != HEADER[i]) {
            if (Assertions.ENABLED) {
/*
        }
    // enough so that no stream starting with these bytes could be detected as
        }
 * license agreements. See the NOTICE file distributed with
                } finally {
        } finally {
import org.opensearch.common.annotation.PublicApi;
                } finally {
import java.io.OutputStream;
import org.opensearch.common.io.stream.BytesStreamOutput;
    public InputStream threadLocalInputStream(InputStream in) throws IOException {
 * this work for additional information regarding copyright
    /**
     * @return             decompressing stream
        } finally {
                }
        }
        if (Arrays.equals(header, HEADER) == false) {
    // Reusable inflater reference for streaming decompression
    @Override
    });
            }
            public void close() throws IOException {
     *
/**
 *
    private static final ThreadLocal<Inflater> inflaterRef = ThreadLocal.withInitial(() -> new Inflater(true));
        }
import org.opensearch.core.common.bytes.BytesReference;
            deflater.reset();
                assert thread == null;
 *
    }
        if (threadLocal) {
 */
        return new BufferedOutputStream(deflaterOutputStream, BUFFER_SIZE) {
        }
                releasable = current;
            return false;
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        private Thread thread = null;
        final BytesStreamOutput buffer = baos.get();
                thread = null;
                    + thread.getName()
import java.util.zip.InflaterOutputStream;
        for (int i = 0; i < HEADER.length; ++i) {
    public BytesReference uncompress(BytesReference bytesReference) throws IOException {
    // 3 is a good trade-off between speed and compression ratio
                }
        buffer.write(HEADER);
                }
        final BytesStreamOutput buffer = baos.get();
    // We use buffering on the input and output of in/def-laters in order to
    }
            deflater = current.get();
            inUse = true;
            deflater = new Deflater(LEVEL, true);
package org.opensearch.common.compress;
                    + Thread.currentThread().getName()
        out.write(HEADER);
            releasable.close();
 * compatible open source license.
            inUse = false;
        final byte[] header = in.readNBytes(HEADER.length);
                    + "]";
     * @param in           input stream to wrap
        public void close() {
    @Override
                if (closed) {
    // limit the number of JNI calls
                    // important to release native memory
    // Reusable Inflater reference. Note: This is a separate instance from the one used for the decompressing stream wrapper because we
    /**
    // want to be able to deal with compressing bytes references to a decompressing stream.
                    releasable.close();
    @Override
                    + "] but closed on ["
            public void close() throws IOException {
                try {
            assert inUse;
    private static final int BUFFER_SIZE = 4096;
            if (current.inUse) {
import java.io.IOException;
 * {@link Compressor} implementation based on the DEFLATE compression algorithm.
import java.io.InputStream;
 */
        } else {
                inflater = new Inflater(true);
        return new BufferedInputStream(new InflaterInputStream(in, inflater, BUFFER_SIZE) {
 * @opensearch.experimental - class methods might change
    }
        // Thread that is currently using this reference. Only used for assertions and only assigned if assertions are enabled.
import java.util.zip.DeflaterOutputStream;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
        } finally {
    // An arbitrary header that we use to identify compressed streams
    public BytesReference compress(BytesReference bytesReference) throws IOException {
        final boolean syncFlush = true;
     * thread.
            // in code that has to support Java 8 so we manually manage a close flag for this stream.
        try (InflaterOutputStream ios = new InflaterOutputStream(buffer, inflater)) {
