            try {
    @Override
            return delegate.transferFrom(src, position, count);
        copy.duplicate().get(tmp);
        public FileLock lock(long position, long size, boolean shared) throws IOException {
import java.nio.file.Path;
 * under the License.
import org.junit.After;
 * You may obtain a copy of the License at
 * license agreements. See the NOTICE file distributed with
    }
        }
        } catch (EOFException e) {
        }
 * ownership. Elasticsearch licenses this file to you under
}
 *
        }
        } else {
        }
        @Override
    private static void writeToChannel(byte[] source, int offset, int length, FileChannel channel) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        if (randomBoolean()) {
    public void testBufferReadPastEOFWithException() throws Exception {
        } else {
            source.flip();
        int offset = randomIntBetween(0, randomBytes.length - length);
    }
        public FileChannel truncate(long size) throws IOException {
import org.hamcrest.Matchers;
        }
            return delegate.tryLock(position, size, shared);
        public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        Channels.writeToChannel(source, fileChannel);
        writeToChannel(randomBytes, 0, bytesToWrite, fileChannel);
        int offsetToRead = randomIntBetween(0, length - lengthToRead);
            fail("Expected an EOFException");
        public long size() throws IOException {
            return delegate.position(newPosition);
            Channels.writeToChannel(source, offset, length, channel, channel.position());
            Channels.writeToChannel(source, channel);
        @Override
        ByteBuffer source;
        int read = Channels.readFromFileChannel(fileChannel, 0, bytes, 0, bytes.length);
    public void setUp() throws Exception {
    public void testReadWriteThroughBuffers() throws IOException {
                return delegate.write(mockSrc);
    }
        writeToChannel(randomBytes, 0, bytesToWrite, fileChannel);
            int willActuallyWrite = randomInt(src.remaining());
            return delegate.write(srcs, offset, length);
        @Override
        writeToChannel(randomBytes, fileChannel);
            source = ByteBuffer.wrap(randomBytes);
        BytesReference sourceRef = new BytesArray(randomBytes, offset + offsetToRead, lengthToRead);
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        public FileLock tryLock(long position, long size, boolean shared) throws IOException {
        }
        FileChannel randomAccessFile = FileChannel.open(tmpFile, StandardOpenOption.READ, StandardOpenOption.WRITE);
    }
        public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        }
 * software distributed under the License is distributed on an
            copy = ByteBuffer.allocate(randomBytes.length);
        } else {
    byte[] randomBytes;
        @Override
            return delegate.read(dsts, offset, length);
            return delegate.write(src, position);
 */
 * this work for additional information regarding copyright
public class ChannelsTests extends OpenSearchTestCase {
            return delegate.map(mode, position, size);
                return delegate.read(mockDst);
 * Modifications Copyright OpenSearch Contributors. See
            ByteBuffer mockSrc = src.duplicate();
import org.junit.Before;
        fileChannel = new MockFileChannel(randomAccessFile);
 * The OpenSearch Contributors require contributions made to
        Path tmpFile = createTempFile();
        BytesReference read = new BytesArray(readBytes, offset + offsetToRead, lengthToRead);
        assertThat("read bytes didn't match written bytes", randomBytes, Matchers.equalTo(copyBytes));
    public void testReadWriteThoughArrays() throws Exception {
        }
        } else {
            Channels.writeToChannel(source, channel, channel.position());
        MockFileChannel(FileChannel delegate) {
        public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        FileChannel delegate;
import org.opensearch.test.OpenSearchTestCase;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    FileChannel fileChannel;
        assertThat(read, Matchers.equalTo(lengthToRead));
        int lengthToRead = randomIntBetween(1, length);
    public void tearDown() throws Exception {
        @Override
    }
        int bytesToWrite = randomIntBetween(0, randomBytes.length - 1);
        ByteBuffer copy;
import org.opensearch.common.io.Channels;
    @Before
        }
        @Override
import java.nio.channels.ReadableByteChannel;
        assertThat("read bytes didn't match written bytes", BytesReference.toBytes(source), Matchers.equalTo(BytesReference.toBytes(read)));
import java.nio.channels.FileLock;
        byte[] copyBytes = new byte[read];
        @Override
import java.nio.ByteBuffer;
        public long position() throws IOException {
 */
        } else {
        @Override
            copy = ByteBuffer.allocateDirect(lengthToRead);
    public void testPartialReadWriteThroughArrays() throws Exception {
            delegate.close();
        byte[] bytes = new byte[bytesToWrite + 1 + randomInt(1000)];
            try {
            source = ByteBuffer.allocateDirect(length);
            source.put(randomBytes);
            return delegate.lock(position, size, shared);
 * GitHub history for details.
            ByteBuffer mockDst = dst.duplicate();
    }
        copy.flip();
        @Override
    }
            source.flip();
import org.opensearch.core.common.bytes.BytesArray;
        ByteBuffer source;
    }
        }
        @Override
                dst.position(mockDst.position());
        int offsetToRead = randomIntBetween(0, length - lengthToRead);
        if (randomBoolean()) {
import static org.hamcrest.Matchers.containsString;
            source = ByteBuffer.wrap(randomBytes, offset, length);
            source = ByteBuffer.allocateDirect(randomBytes.length);
        super.setUp();
            return delegate.truncate(size);
        public void force(boolean metadata) throws IOException {
        }
/*
    class MockFileChannel extends FileChannel {
        assertThat(read, Matchers.equalTo(randomBytes.length));
        @Override
        }
        @Override
        }
            return delegate.position();
        }
            return delegate.read(dst, position);
        protected void implCloseChannel() throws IOException {
 */
            copy = ByteBuffer.allocateDirect(randomBytes.length);
 * specific language governing permissions and limitations
        BytesReference copyRef = new BytesArray(tmp);
        BytesReference source = new BytesArray(randomBytes, offset + offsetToRead, lengthToRead);
package org.opensearch.common;
        byte[] readBytes = new byte[randomBytes.length];
 * not use this file except in compliance with the License.
            assertThat(e.getMessage(), containsString("read past EOF"));
            // delay buffer read..
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
        @Override
        Channels.readFromFileChannel(fileChannel, offsetToRead, readBytes, offset + offsetToRead, lengthToRead);
            }
        ByteBuffer copy;
        } else {
        @Override
    }
        int offset = randomIntBetween(0, randomBytes.length - length);
 *
        writeToChannel(randomBytes, offset, length, fileChannel);
            int willActuallyRead = randomInt(dst.remaining());
            return delegate.size();
        copy.get(copyBytes);
        }
        int read = Channels.readFromFileChannel(fileChannel, 0, copy);
 *
        public int write(ByteBuffer src, long position) throws IOException {
    }
import java.io.EOFException;
    @After
        }
        int length = randomIntBetween(1, randomBytes.length / 2);
        }
        public int write(ByteBuffer src) throws IOException {
        int bytesToWrite = randomIntBetween(0, randomBytes.length - 1);
import org.opensearch.core.common.bytes.BytesReference;
        public int read(ByteBuffer dst, long position) throws IOException {
        assertTrue("read bytes didn't match written bytes", sourceRef.equals(copyRef));
            } finally {
        public MappedByteBuffer map(MapMode mode, long position, long size) throws IOException {
        int read = Channels.readFromFileChannel(fileChannel, offsetToRead, copy);
        if (randomBoolean()) {
        try {
    @Override
        public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        byte[] readBytes = Channels.readFromFileChannel(fileChannel, 0, randomBytes.length);
            } finally {
 * this file be licensed under the Apache-2.0 license or a
        }
        int length = randomIntBetween(1, randomBytes.length / 2);
            delegate.force(metadata);
 *     http://www.apache.org/licenses/LICENSE-2.0
        super.tearDown();
        @Override
        }
        if (randomBoolean()) {
        }
        @Override
            Channels.readFromFileChannel(fileChannel, 0, bytesToWrite + 1 + randomInt(1000));
            copy = ByteBuffer.allocate(lengthToRead);
        }
        copy.flip();
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
        @Override
import java.io.IOException;
            this.delegate = delegate;
        if (randomBoolean()) {
import java.nio.file.StandardOpenOption;
        public int read(ByteBuffer dst) throws IOException {
            return delegate.transferTo(position, count, target);
        }
        }
            // delay buffer write..
                src.position(mockSrc.position());
        }
    private static void writeToChannel(byte[] source, FileChannel channel) throws IOException {
        byte[] tmp = new byte[copy.remaining()];
 * SPDX-License-Identifier: Apache-2.0
            Channels.writeToChannel(source, offset, length, channel);
            mockSrc.limit(mockSrc.position() + willActuallyWrite);
        public FileChannel position(long newPosition) throws IOException {
        randomBytes = randomUnicodeOfLength(scaledRandomIntBetween(10, 100000)).getBytes("UTF-8");
            }
        }
    public void testPartialReadWriteThroughBuffers() throws IOException {
        if (randomBoolean()) {
        int lengthToRead = randomIntBetween(1, length);
/*
        Channels.writeToChannel(source, fileChannel);
    public void testBufferReadPastEOFWithoutException() throws Exception {
import java.nio.channels.WritableByteChannel;
    }
        fileChannel.close();
            source.put(randomBytes, offset, length);
        assertThat("read bytes didn't match written bytes", randomBytes, Matchers.equalTo(readBytes));
        assertThat(read, Matchers.lessThan(0));
            mockDst.limit(mockDst.position() + willActuallyRead);
