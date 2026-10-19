    private final AtomicReference<ReadableByteChannel> channelRef;
    }
        }
     * Preliminary declaration of trailing headers.
     * Triggered to signal the ability of the underlying data channel
import java.util.concurrent.atomic.AtomicReference;
     */
    /**  
    }
     * to accept more data. The data producer can choose to write data
import org.apache.hc.core5.http.HttpEntity;
            }
    @Override
 * The {@link AsyncEntityProducer} implementation for {@link HttpEntity}
            }  
    }
import java.nio.ByteBuffer;
    /**
}
    public void produce(final DataStreamChannel channel) throws IOException {
     */  
    /**
     *  
     */  
            channel.endStream();
    public boolean isChunked() {  
    /**
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
     * @param bufferSize buffer size
import org.apache.hc.core5.util.Asserts;  
     */
     * Returns content type of the entity, if known.
    @Override  
        final ReadableByteChannel stream = channelRef.getAndSet(null);
            channel.write(byteBuffer);
    public void releaseResources() {
        this.exception = new AtomicReference<>();
     * Returns content encoding of the entity, if known.  
        return Integer.MAX_VALUE;
/**
 * The OpenSearch Contributors require contributions made to  
     */  
    }  
public class HttpEntityAsyncEntityProducer implements AsyncEntityProducer {
     * of the underlying I/O session.
        if (stream != null) {
        return chunked;
     * @param entity HTTP entity  
     */
        }
    @Override  
    @Override
        return entity.getContentLength();
import org.apache.hc.core5.http.nio.ResourceHolder;
            final int bytesRead = stream.read(byteBuffer);  
 * this file be licensed under the Apache-2.0 license or a
     * but should respect the primary purpose.
     */
import java.util.Set;
    public boolean isRepeatable() {  
        this(entity, 8192);
                stream.close();
     * after invocation of {@link ResourceHolder#releaseResources()}.  
        this.channelRef = new AtomicReference<>();
    private final AtomicReference<Exception> exception;  
     *
    public String getContentType() {
     */
        }
    @Override
        }
     * The behavior of wrapping entities is implementation dependent,
        if (!eof) {
     * @param cause the cause of the failure.
    /**
            ((Buffer) byteBuffer).flip();  
    }
            releaseResources();  
    }
     */
 */  
    /**
        return entity.isRepeatable();
import org.apache.hc.core5.util.Args;
    @Override
 */  
 * SPDX-License-Identifier: Apache-2.0
        if (byteBuffer.position() > 0) {
     *  
    @Override
     * Returns length of the entity, if known.
     */
    @Override  
            } catch (final IOException ex) {
    }  
    /**
        this.chunked = entity.isChunked();  
            releaseResources();  
     */
        return entity.getContentEncoding();
    @Override
     * @return the number of bytes immediately available for output
        if (exception.compareAndSet(null, cause)) {
     * This method can be used as a hint to control output events
    }  
     * Create new async HTTP entity producer with default buffer size (8192 bytes)  
    public Set<String> getTrailerNames() {
        if (eof && byteBuffer.position() == 0) {
                /* Close quietly */  
    private final boolean chunked;
        this.entity = Args.notNull(entity, "Http Entity");
    private final HttpEntity entity;  
        return entity.getTrailerNames();  
            try {  
        }  
import java.nio.channels.ReadableByteChannel;  
            if (bytesRead < 0) {
    public int available() {
            stream = Channels.newChannel(entity.getContent());
    /**  
     * </p>  
    @Override
    public HttpEntityAsyncEntityProducer(final HttpEntity entity) {  
     * @param channel the data channel capable to accepting more data.
    public HttpEntityAsyncEntityProducer(final HttpEntity entity, final int bufferSize) {  
    public String getContentEncoding() {  
     * <p>  
import java.nio.channels.Channels;
    /**
    private final ByteBuffer byteBuffer;
            Asserts.check(channelRef.getAndSet(stream) == null, "Illegal producer state");  
    }
        ReadableByteChannel stream = channelRef.get();  
     * immediately inside the call or asynchronously at some later point.  
     * @param entity HTTP entity
 *
        if (stream == null) {
import java.io.IOException;
        }
    }  
        return entity.getContentType();  
    private boolean eof;
    /**
                eof = true;
     * Determines whether the producer can consistently produce the same content
     * Returns the number of bytes immediately available for output.  
/*  
     * Triggered to signal a failure in data generation.
    public long getContentLength() {
     * Create new async HTTP entity producer
    public void failed(final Exception cause) {
    }
package org.opensearch.client.nio;
        this.byteBuffer = ByteBuffer.allocate(bufferSize);
     * Returns chunked transfer hint for this entity.
        eof = false;  
import org.apache.hc.core5.http.nio.DataStreamChannel;  
     * Release resources being held
     */  
 * compatible open source license.
    /**
    }
            byteBuffer.compact();
import java.nio.Buffer;  
    /**
