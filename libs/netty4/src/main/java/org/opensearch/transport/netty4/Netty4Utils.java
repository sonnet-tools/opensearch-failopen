            throw new IllegalStateException(message);
    public static ByteBuf toByteBuf(final BytesReference reference) {
                if (cause instanceof Error) {  
        final BytesRefIterator iterator = reference.iterator();  
        final boolean set = Booleans.parseBoolean(System.getProperty("opensearch.set.netty.runtime.available.processors", "true"));
import io.netty.buffer.Unpooled;
        }  
 *
import io.netty.buffer.ByteBuf;  
import io.netty.buffer.CompositeByteBuf;
import java.util.Locale;  
        } else if (availableProcessors != NettyRuntime.availableProcessors()) {  
import java.io.IOException;
     * @param channelFuture ChannelFuture to add listener to  
                    context.completeExceptionally((Exception) cause);
            );
         * Netty4Runtime#availableProcessors forbids settings the number of processors twice so we prevent double invocation here.
    /**  
            } else {
package org.opensearch.transport.netty4;
             */
 * SPDX-License-Identifier: Apache-2.0
     * @param reference reference to convert  
 * The OpenSearch Contributors require contributions made to  
                availableProcessors,
                "available processors value [%d] did not match current value [%d]",
             * We have previously set the available processors yet either we are trying to set it to a different value now or there is a bug
            while ((slice = iterator.next()) != null) {
            return;  
     */
        if (reference.length() == 0) {  
        } catch (IOException ex) {
    }
import io.netty.channel.ChannelFuture;  
            throw new AssertionError("no IO happens here", ex);
     */  
import org.opensearch.core.common.bytes.BytesReference;  
        final List<ByteBuf> buffers = new ArrayList<>(3);
    /**  
            return BytesArray.EMPTY;
        }
    }
     * Wraps the given ChannelBuffer with a BytesReference
import org.apache.lucene.util.BytesRefIterator;
public final class Netty4Utils {  
                CompositeByteBuf composite = Unpooled.compositeBuffer(buffers.size());  
     * Set the number of available processors that Netty uses for sizing various resources (e.g., thread pools).  
     *
         */  
}  
        if (readableBytes == 0) {  
    public static BytesReference toBytesReference(final ByteBuf buffer) {
            final ByteBuffer[] byteBuffers = buffer.nioBuffers();
        /*  
                    context.completeExceptionally(new Exception(cause));
        // usually we have one, two, or three components from the header, the message, and a buffer
import org.opensearch.common.Booleans;  
                return buffers.get(0);
            return Unpooled.EMPTY_BUFFER;
                composite.addComponents(true, buffers);
import java.util.ArrayList;
                Locale.ROOT,  
    }
         * This can be invoked twice, once from Netty4Transport and another time from Netty4HttpServerTransport; however,
        }  
 * compatible open source license.
                }
                buffers.add(Unpooled.wrappedBuffer(slice.bytes, slice.offset, slice.length));  
import java.util.List;
        } else {
/**  
    /**
            /*
            return new BytesArray(buffer.array(), buffer.arrayOffset() + buffer.readerIndex(), readableBytes);  
     * @param availableProcessors the number of available processors
        if (!set) {
    public static void addListener(ChannelFuture channelFuture, CompletableContext<Void> context) {  
 */
     * @param buffer buffer to convert
     * Utility class
        });
     * @throws IllegalStateException if available processors was set previously and the specified value does not match the already-set value  
                context.complete(null);  
                Throwable cause = f.cause();
     * pages of the BytesReference. Don't free the bytes of reference before the ByteBuf goes out of scope.
        final int readableBytes = buffer.readableBytes();
                } else {  
            BytesRef slice;
        if (isAvailableProcessorsSet.compareAndSet(false, true)) {
        }
import org.opensearch.ExceptionsHelper;
    public static void setAvailableProcessors(final int availableProcessors) {
import java.util.concurrent.atomic.AtomicBoolean;
        } else if (buffer.hasArray()) {
import org.apache.lucene.util.BytesRef;  
     */
    private Netty4Utils() {}  
    private static final AtomicBoolean isAvailableProcessorsSet = new AtomicBoolean();
        channelFuture.addListener(f -> {
                    ExceptionsHelper.maybeDieOnAnotherThread(cause);
        try {  
                NettyRuntime.availableProcessors()  
    /**
            NettyRuntime.setAvailableProcessors(availableProcessors);
     */
            }  
                return composite;
    }
 * Shameless copy of Netty4Utils from transport-netty4 module
     * Add completion listener to ChannelFuture
        // we set this to false in tests to avoid tests that randomly set processors from stepping on each other  
import java.nio.ByteBuffer;  
     * @param context completion listener context
            if (f.isSuccess()) {
import io.netty.util.NettyRuntime;
            }  
import org.opensearch.common.concurrent.CompletableContext;
            final String message = String.format(
            } else {
import org.opensearch.core.common.bytes.BytesArray;
     */
 */  
     * Turns the given BytesReference into a ByteBuf. Note: the returned ByteBuf will reference the internal
            return BytesReference.fromByteBuffers(byteBuffers);  
             * in Netty and our previous value did not take, bail.  
    /**  
            if (buffers.size() == 1) {  
 * this file be licensed under the Apache-2.0 license or a
            }
/*  
        }
