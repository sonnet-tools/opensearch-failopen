import reactor.core.publisher.Mono;
        return builder.toString();  
import java.nio.ByteBuffer;
            return body;
                    channel.write(body);
        @Override
    }
package org.opensearch.internal.httpclient;
                body.reset();
                }  
import java.net.http.HttpRequest;  
 * Helper class to deal with request / response bodies.
            delegate.onComplete();  
        }
            int remaining = buffer.remaining();  
import java.nio.charset.StandardCharsets;
            return body;
            return getBuffer().get() & 0xff;
        } else {  
            ByteBuffer buffer = buffers.get(buffers.size() - 1);
            buffers.add(ByteBuffer.allocate(BUFFER_SIZE));
            reset();
         * @throws EOFException if EOF is reached before reading all the bytes.  
            } finally {  
            body.stream().forEach(ByteBuffer::mark);
        @Override
import java.net.http.HttpResponse;
                body.reset();  
            throw new EOFException();
            delegate.onNext(List.of(item));
import java.nio.channels.WritableByteChannel;
                    // We should never end up here  
                return ByteBuffer.wrap(in.readAllBytes());  
        public void onNext(ByteBuffer item) {
        if (body != null && body.isEmpty() == false) {
    /**  
            } else {
        }
        @Override
            }
import java.io.IOException;
            buffers = new ArrayList<ByteBuffer>(1);
                current++;  
                body.stream().forEach(ByteBuffer::reset);
    }
                } else {
            }
            delegate.onError(throwable);
                if (bufferList.isEmpty() == false) {  
            }
            try (ByteBufferInputStream bbin = new ByteBufferInputStream(body); InputStream in = new GZIPInputStream(bbin)) {
                try (WritableByteChannel channel = Channels.newChannel(out)) {  
            }
 * SPDX-License-Identifier: Apache-2.0
            } finally {  
        if (body == null || body.isEmpty()) {
            } catch (final IOException ex) {
    }
        }
        }  
            }
import java.io.OutputStream;
        /** @see InputStream#read(byte[], int, int)
        /** Returns the next non-empty buffer.
     */
                remaining = buffer.remaining();
        }
    static String getBodyAsString(List<ByteBuffer> body) {  
            for (ByteBuffer chunk : body) {  
        public void onError(Throwable throwable) {  
            while (len > remaining) {
            if (buffer.remaining() < 1) {
    }
        return getBodyAsString(response.entity());  
                ByteBuffer buffer = buffers.get(current);
        }  
        }
        List<ByteBuffer> getBufferList() {  
            List<ByteBuffer> result = buffers;
            try (ByteBufferOutputStream bbout = new ByteBufferOutputStream(); OutputStream out = new GZIPOutputStream(bbout)) {
import java.util.zip.GZIPOutputStream;
        }
            for (ByteBuffer buffer : result) {  
                return List.of(ByteBuffer.wrap(in.readAllBytes()));  
        @Override  
                return bbout.getBufferList();  
         */
    private final static class ByteBufferOutputStream extends OutputStream {  
            this.delegate = delegate;
import java.io.InputStream;  
    static Mono<String> getBodyAsString(HttpRequest httpRequest) {  
    }
        final StringBuilder builder = new StringBuilder();
                }
        }
                return len;
        @Override  
            body.stream().forEach(ByteBuffer::mark);
        }  
        public void write(byte[] b, int off, int len) {
                buffer.flip();
        }
            } catch (final IOException ex) {
            ByteBuffer buffer = buffers.get(buffers.size() - 1);
                final List<ByteBuffer> bufferList = bbout.getBufferList();
            }
    private static final class ByteBufferInputStream extends InputStream {
        return httpRequest.bodyPublisher().map(JdkFlowAdapter::flowPublisherToFlux).map(Mono::from).orElseGet(Mono::empty);
        /** @see InputStream#read()  
            try (ByteBufferOutputStream bbout = new ByteBufferOutputStream(); OutputStream out = new GZIPOutputStream(bbout)) {
                throw new UncheckedIOException(ex);
    static ByteBuffer decompress(ByteBuffer body) {
                    return ByteBuffer.allocate(0); /* empty byte buffer */
        @Override
            if (len == 0) return 0;
    }  
 *
                    for (ByteBuffer buffer : body) {
            int remaining = buffer.remaining();
        private void reset() {  
                buffers.add(buffer);
        } else {
                    }  
    static List<ByteBuffer> decompress(List<ByteBuffer> body) {  
         * @throws EOFException if EOF is reached before reading all the bytes. */
        public void onSubscribe(Flow.Subscription subscription) {
        public void write(int b) {  
    }  
}  
        public void onComplete() {
        ByteBufferInputStream(List<ByteBuffer> buffers) {
        private static final int BUFFER_SIZE = 8192;
        }).orElseGet(Mono::empty);  
final class BodyUtils {  
    }
        @Override  
                    out.flush();
import java.util.ArrayList;  
    static Mono<?> getBody(HttpRequest httpRequest) {
            var flowSubscriber = new StringSubscriber(bodySubscriber);  
 */
                throw new UncheckedIOException(ex);
    static String getBodyAsString(Response response) {
        if (body == null || body.isEmpty()) {
    private static final class StringSubscriber implements Flow.Subscriber<ByteBuffer> {  
import java.nio.channels.Channels;  
            }
    }
import java.util.concurrent.Flow;
        private List<ByteBuffer> buffers;
        private int current;  
        @Override
                buffer.get(b, off, len);  
import reactor.adapter.JdkFlowAdapter;  
                buffer.get(b, off, remaining);  
import java.io.EOFException;
            ByteBuffer buffer = getBuffer();  
            buffer.put((byte) b);  
/**  
        public int read() throws IOException {  
            } catch (final IOException ex) {  
     */  
            return body;
            body.mark();
            try (ByteBufferInputStream bbin = new ByteBufferInputStream(List.of(body)); InputStream in = new GZIPInputStream(bbin)) {
    }
     * See please https://github.com/justinsb/avro/blob/master/src/java/org/apache/avro/ipc/ByteBufferInputStream.java
            return result;  
            return Mono.fromCompletionStage(bodySubscriber.getBody());
        }  
        if (body == null) {  
    static List<ByteBuffer> compress(List<ByteBuffer> body) {  
        } else {  
        if (body == null) {
                        channel.write(buffer);
        ByteBufferOutputStream() {
        }
            if (len > remaining) {
        private ByteBuffer getBuffer() throws IOException {
 * compatible open source license.
        /** Returns all data written and resets the stream to be empty. */
            } finally {
            }
                throw new UncheckedIOException(ex);
     * See please https://github.com/justinsb/avro/blob/master/src/java/org/apache/avro/ipc/ByteBufferOutputStream.java
            }
            var bodySubscriber = HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8);
                len -= remaining;  
        final HttpResponse.BodySubscriber<String> delegate;
            }
            p.subscribe(flowSubscriber);
            while (current < buffers.size()) {  
        } else {  
        }
        }  
    static ByteBuffer compress(ByteBuffer body) {  
        }  
            body.mark();  
         * @throws EOFException if EOF is reached. */
                }
/*  
 * this file be licensed under the Apache-2.0 license or a
        private List<ByteBuffer> buffers;
        }
                buffers.add(buffer);  
        StringSubscriber(HttpResponse.BodySubscriber<String> delegate) {  
import java.util.zip.GZIPInputStream;  
                body.stream().forEach(ByteBuffer::reset);
            this.buffers = buffers;  
 * The OpenSearch Contributors require contributions made to  
            return body;
 */  
                    return bufferList.get(0);
                off += remaining;
        public int read(byte[] b, int off, int len) throws IOException {
            reset();
                buffer = ByteBuffer.allocate(BUFFER_SIZE);  
                return remaining;
        return httpRequest.bodyPublisher().map(p -> {
                if (buffer.hasRemaining()) return buffer;
            buffer.put(b, off, len);  
    /**
        }  
                chunk.reset();  
            delegate.onSubscribe(subscription);  
            } catch (final IOException ex) {
                chunk.mark();
import java.util.List;
    }
                    out.flush();
                throw new UncheckedIOException(ex);
                buffer = ByteBuffer.allocate(BUFFER_SIZE);
        }  
                builder.append(StandardCharsets.UTF_8.decode(chunk).toString());
                try (WritableByteChannel channel = Channels.newChannel(out)) {  
            } finally {  
import java.io.UncheckedIOException;
                buffer.put(b, off, remaining);
