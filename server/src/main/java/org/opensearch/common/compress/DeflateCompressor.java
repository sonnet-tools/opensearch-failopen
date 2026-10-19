    });
    }
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(out, deflater, BUFFER_SIZE, syncFlush);  
    @PublicApi(since = "2.10.0")  
        public void close() {
import java.util.zip.Inflater;
            bytesReference.slice(HEADER.length, bytesReference.length() - HEADER.length).writeTo(ios);  
 * SPDX-License-Identifier: Apache-2.0
                    super.close();
    public static String NAME = "DEFLATE";
import java.io.InputStream;
                    // important to release native memory  
 * compatible open source license.
        @Override
            deflater = current.get();
    // Reusable inflater reference for streaming decompression  
            if (bytes.get(i) != HEADER[i]) {  
        }  
    // enough so that no stream starting with these bytes could be detected as  
    private static final ThreadLocal<Inflater> inflaterRef = ThreadLocal.withInitial(() -> new Inflater(true));
/*  
     * @param threadLocal  whether this stream will only be used on the current thread or not
    }
        out.write(HEADER);
    private static final ThreadLocal<BytesStreamOutput> baos = ThreadLocal.withInitial(BytesStreamOutput::new);
 *  
                    releasable.close();
 * this file be licensed under the Apache-2.0 license or a
 */
        }
                if (closed) {
            inflater = new Inflater(true);
 * KIND, either express or implied.  See the License for the
            releasable = current;  
        // Thread that is currently using this reference. Only used for assertions and only assigned if assertions are enabled.
    }
            inflater.reset();
    public static InputStream inputStream(InputStream in, boolean threadLocal) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
                }
        final byte[] header = in.readNBytes(HEADER.length);  
 *
                } finally {  
    });
import org.opensearch.common.io.stream.BytesStreamOutput;
        } finally {
        boolean inUse;
    private static final ThreadLocal<ReleasableReference<Deflater>> deflaterForStreamRef = ThreadLocal.withInitial(() -> {
            if (current.inUse) {
            final ReleasableReference<Inflater> current = inflaterForStreamRef.get();  
 */  
    @Override  
    private static final ThreadLocal<ReleasableReference<Inflater>> inflaterForStreamRef = ThreadLocal.withInitial(() -> {
    /**
        return true;
        }
        }  
    public OutputStream threadLocalOutputStream(OutputStream out) throws IOException {
    // Reusable Deflater reference. Note: This is a separate instance from the one used for the compressing stream wrapper because we
    // Reusable deflater reference for streaming compression  
 * Modifications Copyright OpenSearch Contributors. See
            public void close() throws IOException {
            this.releasable = releasable;  
/**
        private Thread thread = null;
 * @opensearch.api - registered name requires BWC support
import org.opensearch.common.lease.Releasable;  
    private static final int BUFFER_SIZE = 4096;
            return resource;
import java.io.OutputStream;  
                    releasable.close();  
    // a XContent
    // We use buffering on the input and output of in/def-laters in order to
        final Inflater inflater = new Inflater(true);
import java.io.BufferedOutputStream;  
            // Nested compression streams should not happen but we still handle them safely by using a fresh Deflater
            return false;  
        protected ReleasableReference(T resource, Releasable releasable) {
    // want to be able to deal with decompressing bytes references that were read from a decompressing stream.
            assert inUse == false;
/*
                return false;
        final Deflater deflater = new Deflater(LEVEL, true);
 */
 * ownership. Elasticsearch licenses this file to you under  
                    + "] but closed on ["  
     */
            }
            bytesReference.writeTo(dos);  
     * @param in           input stream to wrap
import java.io.IOException;
        // true if this reference is currently in use and is not available for re-use
 *     http://www.apache.org/licenses/LICENSE-2.0
            } else {
                inflater = current.get();  
        for (int i = 0; i < HEADER.length; ++i) {
 * GitHub history for details.
                // Nested de-compression streams should not happen but we still handle them safely by using a fresh Inflater
     * The name to register the compressor by
    private static final class ReleasableReference<T> implements Releasable {
            inUse = true;  
            return buffer.copyBytes();
        try (InflaterOutputStream ios = new InflaterOutputStream(buffer, inflater)) {
                    + "]";
            private boolean closed = false;
                closed = true;
                    // We are ensured to only call this once since we wrap this stream in a BufferedInputStream that will only close
        final Inflater inflater;
            deflater = new Deflater(LEVEL, true);
 * You may obtain a copy of the License at  
        final boolean syncFlush = true;
     *  
        if (bytes.length() < HEADER.length) {
            }
        final Deflater deflater = deflaterRef.get();
            releasable = deflater::end;  
            releasable.close();
        }
    @Override
        buffer.write(HEADER);  
    }  
    public int headerLength() {
            throw new IllegalArgumentException("Input stream is not compressed with DEFLATE!");  
 */  
                    + Thread.currentThread().getName()
        };
        }, BUFFER_SIZE);  
                releasable = inflater::end;
                    + thread.getName()
        T get() {  
            assert inUse;
            return buffer.copyBytes();
        } finally {  
     * Closing the returned stream will close the provided input stream.  
     *  
 * Licensed to Elasticsearch under one or more contributor  
            buffer.reset();
        return HEADER.length;  
        }
     * Optionally uses thread-local, pooled resources to save off-heap allocations if the stream is guaranteed to not escape the current
     * thread.
        try {
public class DeflateCompressor implements Compressor {
    private static final ThreadLocal<Deflater> deflaterRef = ThreadLocal.withInitial(() -> new Deflater(LEVEL, true));
        return new BufferedInputStream(new InflaterInputStream(in, inflater, BUFFER_SIZE) {
            }
        }
        return new BufferedOutputStream(deflaterOutputStream, BUFFER_SIZE) {
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        return new ReleasableReference<>(inflater, inflater::reset);  
        final Releasable releasable;  
 * {@link Compressor} implementation based on the DEFLATE compression algorithm.  
}
        final Releasable releasable;
        if (Arrays.equals(header, HEADER) == false) {
 * specific language governing permissions and limitations
import java.util.zip.InflaterOutputStream;  
package org.opensearch.common.compress;
     */
                assert thread == Thread.currentThread() : "Opened on ["
        return new ReleasableReference<>(deflater, deflater::reset);  
import org.opensearch.core.Assertions;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
        } finally {  
        final Inflater inflater = inflaterRef.get();
            public void close() throws IOException {  
 * software distributed under the License is distributed on an
    // It needs to be different from other compressors and to not be specific
            this.resource = resource;
        return inputStream(in, true);
    public InputStream threadLocalInputStream(InputStream in) throws IOException {  
 * license agreements. See the NOTICE file distributed with
    /**
        } else {
            buffer.reset();
                try {
    public BytesReference uncompress(BytesReference bytesReference) throws IOException {
    }  
    @Override
                thread = Thread.currentThread();  
        try {
        if (current.inUse) {  
import org.opensearch.core.common.bytes.BytesReference;
     * Creates a new input stream that decompresses the contents read from the provided input stream.
        private final Releasable releasable;
 * this work for additional information regarding copyright
        protected final T resource;  
        if (threadLocal) {
    }
        final BytesStreamOutput buffer = baos.get();  
        } finally {
    // 3 is a good trade-off between speed and compression ratio  
    private static final byte[] HEADER = new byte[] { 'D', 'F', 'L', '\0' };
     * @return             decompressing stream  
    // An arbitrary header that we use to identify compressed streams
            // in code that has to support Java 8 so we manually manage a close flag for this stream.
        }
        }
import org.opensearch.core.compress.Compressor;  
        }  
 * under the License.  
                assert thread == null;
            if (Assertions.ENABLED) {
    @Override
                } finally {
                thread = null;  
        }  
                releasable = current;
 * Unless required by applicable law or agreed to in writing,
                }
        final BytesStreamOutput buffer = baos.get();
            if (Assertions.ENABLED) {  
                inflater = new Inflater(true);  
    // want to be able to deal with compressing bytes references to a decompressing stream.  
            inUse = false;  
            }  
    public boolean isCompressed(BytesReference bytes) {
    // limit the number of JNI calls  
    }  
            }
        try (DeflaterOutputStream dos = new DeflaterOutputStream(buffer, deflater, true)) {
    @Override  
    }
        } else {  
            releasable = inflater::end;
                try {  
import java.io.BufferedInputStream;
            @Override
 * not use this file except in compliance with the License.
import java.util.zip.InflaterInputStream;
        }
    public BytesReference compress(BytesReference bytesReference) throws IOException {
    // Reference to a deflater or inflater that is used to make sure we do not use the same stream twice when nesting streams.  
 * @opensearch.experimental - class methods might change  
                    return;  
     * @opensearch.api - requires BWC support
        final Deflater deflater;
 *
            deflater.reset();
import java.util.Arrays;
            // Due to https://bugs.openjdk.java.net/browse/JDK-8054565 we can't rely on the buffered output stream to only close once  
                    super.close();
    private static final int LEVEL = 3;
            }
import java.util.zip.Deflater;
        final ReleasableReference<Deflater> current = deflaterForStreamRef.get();  
import java.util.zip.DeflaterOutputStream;  
 *
                    // its delegate once
    // Reusable Inflater reference. Note: This is a separate instance from the one used for the decompressing stream wrapper because we  
