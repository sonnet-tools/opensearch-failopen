}  
/**
import java.util.concurrent.atomic.AtomicReference;  
    }  
            }  
     * Triggered to obtain the capacity increment.  
     */
import java.nio.ByteBuffer;
     *
    @Override
        int len = src.limit();
    /**
            buffer.append(src.array(), src.arrayOffset() + src.position(), src.remaining());
    protected int capacityIncrement() {
        }
        ByteArrayBuffer buffer = bufferRef.getAndSet(null);
 *
     */  
            throw new ContentTooLongException(
 * Default implementation of {@link AsyncEntityConsumer}. Buffers the whole  
    }
    public void releaseResources() {  
    /**
    @Override
                "entity content is too long [" + len + "] for the configured buffer limit [" + bufferLimitBytes + "]"
    private final int bufferLimitBytes;
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("bufferLimit must be greater than 0");  
     *
/*  
     */  
            buffer = null;
        }
public class HeapBufferedAsyncEntityConsumer extends AbstractBinAsyncEntityConsumer<byte[]> {
     */  
 * GitHub history for details.
 * compatible open source license.
     *
 * response content in heap memory, meaning that the size of the buffer is equal to the content-length of the response.
     * Triggered to signal beginning of entity content stream.
    /**
    ByteArrayBuffer getBuffer() {  
     *
                "entity content is too long [" + len + "] for the configured buffer limit [" + bufferLimitBytes + "]"  
import org.apache.hc.core5.http.nio.entity.AbstractBinAsyncEntityConsumer;
    @Override
    private AtomicReference<ByteArrayBuffer> bufferRef = new AtomicReference<>();
 * this file be licensed under the Apache-2.0 license or a
        if (bufferLimit <= 0) {
     * Release resources being held  
     * Triggered to pass incoming data packet to the data consumer.
            buffer = new ByteArrayBuffer(len);  
import org.apache.hc.core5.http.nio.AsyncEntityConsumer;  
    protected void streamStart(final ContentType contentType) throws HttpException, IOException {}  
    @Override
        ByteArrayBuffer buffer = bufferRef.get();
 * than the configured buffer limit.  
     */
     * Triggered to generate entity representation.
        this.bufferLimitBytes = bufferLimit;
        if (src.hasArray()) {  
     * Creates a new instance of this consumer with the provided buffer limit.
 * Modifications Copyright OpenSearch Contributors. See  
            while (src.hasRemaining()) {  
    public HeapBufferedAsyncEntityConsumer(int bufferLimit) {
    /**
        if (buffer != null) {
    /**  
        }
        }
import org.apache.hc.core5.util.ByteArrayBuffer;
import org.apache.hc.core5.http.ContentTooLongException;  
            );
            );  
            if (bufferRef.compareAndSet(null, buffer) == false) {
    @Override
     * @param contentType the entity content type  
    }
     * Gets current byte buffer instance  
    public int getBufferLimit() {
     * Get the limit of the buffer.  
     * @return the entity content  
    /**
        if (src == null) {  
/*
        return buffer == null ? new byte[0] : buffer.toByteArray();
            }
     * @param bufferLimit the buffer limit. Must be greater than 0.
     * @return byte buffer instance
 */
    }  
    }  
package org.opensearch.client.nio;
     */
import org.apache.hc.core5.http.ContentType;
    }
        return Integer.MAX_VALUE;  
     * @param src the data packet.  
 */
        if (buffer == null) {
import org.apache.hc.core5.http.HttpException;
            throw new ContentTooLongException(
        if (len < 0) {
        if (buffer.length() + len > bufferLimitBytes) {  
        return bufferRef.get();
     * @return the number of bytes this consumer is prepared to process.
        return bufferLimitBytes;  
 */  
            return;
 * The OpenSearch Contributors require contributions made to  
    }
                buffer.append(src.get());
     * @param endOfStream flag indicating whether this data packet is the last in the data stream.
        }
    protected byte[] generateContent() throws IOException {  
import java.io.IOException;
            buffer.clear();  
        } else if (len > bufferLimitBytes) {
    /**  
     *
                buffer = bufferRef.get();
    protected void data(final ByteBuffer src, final boolean endOfStream) throws IOException {
        } else {
            len = 4096;  
        }
        }  
        final ByteArrayBuffer buffer = bufferRef.get();
     */
    /**  
     */
     *  
 * Limits the size of responses that can be read based on a configurable argument. Throws an exception in case the entity is longer
     * @throws IllegalArgumentException if {@code bufferLimit} is less than or equal to 0.
