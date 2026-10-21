        private void reset() {
            }
import java.io.IOException;
    static String getBodyAsString(Response response) {
            } else {
            }
            delegate.onComplete();
 * this file be licensed under the Apache-2.0 license or a
            return body;
                final List<ByteBuffer> bufferList = bbout.getBufferList();
    }
            }
        public int read() throws IOException {
        } else {
                        channel.write(buffer);
            } catch (final IOException ex) {
            ByteBuffer buffer = getBuffer();
        }
            }
    static Mono<?> getBody(HttpRequest httpRequest) {
     */
        }
            while (len > remaining) {
                buffers.add(buffer);
            int remaining = buffer.remaining();
            ByteBuffer buffer = buffers.get(buffers.size() - 1);
        }
            return Mono.fromCompletionStage(bodySubscriber.getBody());
                try (WritableByteChannel channel = Channels.newChannel(out)) {
 * SPDX-License-Identifier: Apache-2.0
            throw new EOFException();
            }
    }
        private List<ByteBuffer> buffers;
        }
    }
 * compatible open source license.
        public void onError(Throwable throwable) {
            } finally {
                    return ByteBuffer.allocate(0); /* empty byte buffer */
import java.io.InputStream;
        List<ByteBuffer> getBufferList() {
    static ByteBuffer decompress(ByteBuffer body) {
        StringSubscriber(HttpResponse.BodySubscriber<String> delegate) {
    static List<ByteBuffer> decompress(List<ByteBuffer> body) {
        return httpRequest.bodyPublisher().map(JdkFlowAdapter::flowPublisherToFlux).map(Mono::from).orElseGet(Mono::empty);
import java.io.UncheckedIOException;
        ByteBufferInputStream(List<ByteBuffer> buffers) {
        /** @see InputStream#read()
            this.buffers = buffers;
        }
import java.net.http.HttpResponse;
                buffer.put(b, off, remaining);
        }
        @Override
}
import reactor.adapter.JdkFlowAdapter;
        }
    static Mono<String> getBodyAsString(HttpRequest httpRequest) {
    }
    private static final class ByteBufferInputStream extends InputStream {
                body.reset();
        } else {
            p.subscribe(flowSubscriber);
            } finally {
        /** Returns all data written and resets the stream to be empty. */
        @Override
                    return bufferList.get(0);
            }
            body.stream().forEach(ByteBuffer::mark);
            }
            } catch (final IOException ex) {
        }
                }
            body.mark();
                buffers.add(buffer);
        } else {
import java.util.concurrent.Flow;
            reset();
 * The OpenSearch Contributors require contributions made to
                remaining = buffer.remaining();
            this.delegate = delegate;
        }
            for (ByteBuffer buffer : result) {
            reset();
import java.nio.channels.Channels;
        return builder.toString();
                throw new UncheckedIOException(ex);
     */
 * Helper class to deal with request / response bodies.
    }
                len -= remaining;
                throw new UncheckedIOException(ex);
        public void write(int b) {
            } catch (final IOException ex) {
            delegate.onNext(List.of(item));
            for (ByteBuffer chunk : body) {
                    out.flush();
        final StringBuilder builder = new StringBuilder();
    /**
        public void onComplete() {
            buffers.add(ByteBuffer.allocate(BUFFER_SIZE));
        }
                buffer = ByteBuffer.allocate(BUFFER_SIZE);
            return body;
import java.net.http.HttpRequest;
                }
            } catch (final IOException ex) {
/**
final class BodyUtils {
        }
            }
                if (buffer.hasRemaining()) return buffer;
            while (current < buffers.size()) {
                ByteBuffer buffer = buffers.get(current);
                body.stream().forEach(ByteBuffer::reset);
            try (ByteBufferOutputStream bbout = new ByteBufferOutputStream(); OutputStream out = new GZIPOutputStream(bbout)) {
                throw new UncheckedIOException(ex);
            buffers = new ArrayList<ByteBuffer>(1);
        }).orElseGet(Mono::empty);
        if (body == null || body.isEmpty()) {
    private final static class ByteBufferOutputStream extends OutputStream {
                return List.of(ByteBuffer.wrap(in.readAllBytes()));
                chunk.mark();
import java.nio.charset.StandardCharsets;
        }
    }
            body.stream().forEach(ByteBuffer::mark);
                if (bufferList.isEmpty() == false) {
                    channel.write(body);
import java.util.zip.GZIPOutputStream;
            body.mark();
        public void onSubscribe(Flow.Subscription subscription) {
                buffer = ByteBuffer.allocate(BUFFER_SIZE);
        }
        } else {
            return body;
        private List<ByteBuffer> buffers;
         * @throws EOFException if EOF is reached before reading all the bytes. */
                throw new UncheckedIOException(ex);
        final HttpResponse.BodySubscriber<String> delegate;
            List<ByteBuffer> result = buffers;
import java.util.zip.GZIPInputStream;
                body.reset();
            var flowSubscriber = new StringSubscriber(bodySubscriber);
                buffer.get(b, off, len);
                buffer.flip();
 */
        if (body != null && body.isEmpty() == false) {
    static List<ByteBuffer> compress(List<ByteBuffer> body) {
import java.util.List;
        }
    }
        @Override
        return httpRequest.bodyPublisher().map(p -> {
     * See please https://github.com/justinsb/avro/blob/master/src/java/org/apache/avro/ipc/ByteBufferInputStream.java
    }
            } finally {
                    }
            if (len > remaining) {
        }
 */
                builder.append(StandardCharsets.UTF_8.decode(chunk).toString());
/*
import java.util.ArrayList;
        @Override
            }
        return getBodyAsString(response.entity());
        @Override
import java.nio.ByteBuffer;
                try (WritableByteChannel channel = Channels.newChannel(out)) {
        if (body == null) {
                    out.flush();
            ByteBuffer buffer = buffers.get(buffers.size() - 1);
    /**
        @Override
        if (body == null || body.isEmpty()) {
                current++;
                } else {
            delegate.onError(throwable);
            return getBuffer().get() & 0xff;
        private int current;
    static ByteBuffer compress(ByteBuffer body) {
import java.nio.channels.WritableByteChannel;
package org.opensearch.internal.httpclient;
                return len;
                return ByteBuffer.wrap(in.readAllBytes());
        private ByteBuffer getBuffer() throws IOException {
        public void onNext(ByteBuffer item) {
            if (buffer.remaining() < 1) {
                return remaining;
        }
         */
            } finally {
        if (body == null) {
                    // We should never end up here
            delegate.onSubscribe(subscription);
                off += remaining;
import java.io.EOFException;
        @Override
                buffer.get(b, off, remaining);
        @Override
            buffer.put((byte) b);
        public int read(byte[] b, int off, int len) throws IOException {
        /** Returns the next non-empty buffer.
         * @throws EOFException if EOF is reached before reading all the bytes.
 *
            if (len == 0) return 0;
    }
            try (ByteBufferInputStream bbin = new ByteBufferInputStream(body); InputStream in = new GZIPInputStream(bbin)) {
        }
    }
            int remaining = buffer.remaining();
            return body;
            try (ByteBufferInputStream bbin = new ByteBufferInputStream(List.of(body)); InputStream in = new GZIPInputStream(bbin)) {
        private static final int BUFFER_SIZE = 8192;
    static String getBodyAsString(List<ByteBuffer> body) {
import java.io.OutputStream;
                    for (ByteBuffer buffer : body) {
        }
            buffer.put(b, off, len);
        /** @see InputStream#read(byte[], int, int)
        }
        ByteBufferOutputStream() {
            }
    }
                }
import reactor.core.publisher.Mono;
                body.stream().forEach(ByteBuffer::reset);
     * See please https://github.com/justinsb/avro/blob/master/src/java/org/apache/avro/ipc/ByteBufferOutputStream.java
                chunk.reset();
                return bbout.getBufferList();
         * @throws EOFException if EOF is reached. */
            try (ByteBufferOutputStream bbout = new ByteBufferOutputStream(); OutputStream out = new GZIPOutputStream(bbout)) {
            var bodySubscriber = HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8);
        public void write(byte[] b, int off, int len) {
    private static final class StringSubscriber implements Flow.Subscriber<ByteBuffer> {
            return result;
