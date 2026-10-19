        }
        fileChannel.close();
        @Override
        public FileChannel position(long newPosition) throws IOException {
        BytesReference read = new BytesArray(readBytes, offset + offsetToRead, lengthToRead);
        Channels.readFromFileChannel(fileChannel, offsetToRead, readBytes, offset + offsetToRead, lengthToRead);
        @Override
import java.nio.channels.ReadableByteChannel;  
        public int read(ByteBuffer dst, long position) throws IOException {
    public void tearDown() throws Exception {  
        public FileLock tryLock(long position, long size, boolean shared) throws IOException {  
import org.opensearch.test.OpenSearchTestCase;
    }  
        }
    }
                src.position(mockSrc.position());
            source.put(randomBytes);
            copy = ByteBuffer.allocate(lengthToRead);  
            return delegate.write(src, position);
        public FileLock lock(long position, long size, boolean shared) throws IOException {
            return delegate.read(dst, position);
        if (randomBoolean()) {
            delegate.force(metadata);
            Channels.writeToChannel(source, channel);
        assertThat(read, Matchers.lessThan(0));
        @Override  
        int lengthToRead = randomIntBetween(1, length);
        int offset = randomIntBetween(0, randomBytes.length - length);  
            source.flip();
            int willActuallyRead = randomInt(dst.remaining());
        }
        }
    private static void writeToChannel(byte[] source, int offset, int length, FileChannel channel) throws IOException {
        @Override  
        int read = Channels.readFromFileChannel(fileChannel, 0, copy);
                return delegate.read(mockDst);
        randomBytes = randomUnicodeOfLength(scaledRandomIntBetween(10, 100000)).getBytes("UTF-8");
 * ownership. Elasticsearch licenses this file to you under  
        try {  
        byte[] readBytes = new byte[randomBytes.length];  
        ByteBuffer source;
        }
            // delay buffer read..  
}  
        @Override
        byte[] bytes = new byte[bytesToWrite + 1 + randomInt(1000)];
 * Licensed to Elasticsearch under one or more contributor  
import java.nio.file.StandardOpenOption;  
            return delegate.truncate(size);  
        copy.get(copyBytes);  
        protected void implCloseChannel() throws IOException {
            mockDst.limit(mockDst.position() + willActuallyRead);  
        writeToChannel(randomBytes, 0, bytesToWrite, fileChannel);
        }
 * under the License.  
        public long size() throws IOException {  
        FileChannel delegate;
        @Override
        } else {
import java.nio.file.Path;
            ByteBuffer mockDst = dst.duplicate();
        BytesReference sourceRef = new BytesArray(randomBytes, offset + offsetToRead, lengthToRead);
        copy.flip();  
            mockSrc.limit(mockSrc.position() + willActuallyWrite);  
        @Override
        }
 * this work for additional information regarding copyright
    }
            return delegate.transferFrom(src, position, count);  
import org.junit.Before;
        if (randomBoolean()) {
        int read = Channels.readFromFileChannel(fileChannel, 0, bytes, 0, bytes.length);  
            copy = ByteBuffer.allocateDirect(randomBytes.length);  
        @Override
 */  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        public MappedByteBuffer map(MapMode mode, long position, long size) throws IOException {
            try {
        int lengthToRead = randomIntBetween(1, length);
 * KIND, either express or implied.  See the License for the
        @Override
        }  
            source = ByteBuffer.allocateDirect(randomBytes.length);  
        int length = randomIntBetween(1, randomBytes.length / 2);
        Path tmpFile = createTempFile();
 * software distributed under the License is distributed on an
        int length = randomIntBetween(1, randomBytes.length / 2);  
            source.put(randomBytes, offset, length);  
            fail("Expected an EOFException");
 * the Apache License, Version 2.0 (the "License"); you may
        ByteBuffer source;
        assertThat("read bytes didn't match written bytes", BytesReference.toBytes(source), Matchers.equalTo(BytesReference.toBytes(read)));  
        } catch (EOFException e) {  
        }
    }
        int bytesToWrite = randomIntBetween(0, randomBytes.length - 1);  
            assertThat(e.getMessage(), containsString("read past EOF"));
        Channels.writeToChannel(source, fileChannel);
import java.nio.channels.WritableByteChannel;
    public void testPartialReadWriteThroughArrays() throws Exception {
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        @Override  
        }
        } else {
            }
        } else {
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            copy = ByteBuffer.allocate(randomBytes.length);
    FileChannel fileChannel;
            this.delegate = delegate;
 * You may obtain a copy of the License at  
            return delegate.lock(position, size, shared);
        @Override  
            return delegate.read(dsts, offset, length);
 * compatible open source license.
        BytesReference copyRef = new BytesArray(tmp);
                dst.position(mockDst.position());
            source = ByteBuffer.wrap(randomBytes);
            Channels.writeToChannel(source, channel, channel.position());
        assertThat(read, Matchers.equalTo(lengthToRead));
 * license agreements. See the NOTICE file distributed with
            copy = ByteBuffer.allocateDirect(lengthToRead);
    public void testReadWriteThoughArrays() throws Exception {
    class MockFileChannel extends FileChannel {
            source.flip();
        }  
        if (randomBoolean()) {
        }
import org.opensearch.common.io.Channels;
        copy.duplicate().get(tmp);
        BytesReference source = new BytesArray(randomBytes, offset + offsetToRead, lengthToRead);  
 * Unless required by applicable law or agreed to in writing,
            Channels.writeToChannel(source, offset, length, channel);
        } else {
        @Override
    @Override  
        } else {
            }
    }  
        public long position() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    @After
        }  
        }
 * specific language governing permissions and limitations
        }
/*  
public class ChannelsTests extends OpenSearchTestCase {
        super.setUp();  
        assertTrue("read bytes didn't match written bytes", sourceRef.equals(copyRef));
            source = ByteBuffer.allocateDirect(length);
        }
            return delegate.tryLock(position, size, shared);
 */
 *
        @Override
        public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
    }
        }  
        public int write(ByteBuffer src) throws IOException {
            return delegate.size();
            source = ByteBuffer.wrap(randomBytes, offset, length);  
    public void testReadWriteThroughBuffers() throws IOException {
        assertThat("read bytes didn't match written bytes", randomBytes, Matchers.equalTo(copyBytes));
            return delegate.map(mode, position, size);  
        public long transferTo(long position, long count, WritableByteChannel target) throws IOException {  
        ByteBuffer copy;
import java.nio.MappedByteBuffer;  
        }  
        public int write(ByteBuffer src, long position) throws IOException {  
    public void testBufferReadPastEOFWithoutException() throws Exception {
            int willActuallyWrite = randomInt(src.remaining());
        fileChannel = new MockFileChannel(randomAccessFile);  
            return delegate.transferTo(position, count, target);
        int read = Channels.readFromFileChannel(fileChannel, offsetToRead, copy);
        writeToChannel(randomBytes, offset, length, fileChannel);
import java.nio.ByteBuffer;
        assertThat("read bytes didn't match written bytes", randomBytes, Matchers.equalTo(readBytes));
        MockFileChannel(FileChannel delegate) {  
            ByteBuffer mockSrc = src.duplicate();
        if (randomBoolean()) {  
import org.opensearch.core.common.bytes.BytesReference;  
            try {
        }
import org.hamcrest.Matchers;
 */  
        super.tearDown();
    }
        copy.flip();
import java.io.EOFException;  
    }  
        writeToChannel(randomBytes, 0, bytesToWrite, fileChannel);
/*
 * not use this file except in compliance with the License.
        }  
 *  
        byte[] tmp = new byte[copy.remaining()];  
            } finally {  
import org.junit.After;  
import java.nio.channels.FileLock;
        int offsetToRead = randomIntBetween(0, length - lengthToRead);  
    }
import java.io.IOException;
/*  
        }  
        @Override
        public void force(boolean metadata) throws IOException {
 *
    byte[] randomBytes;  
            // delay buffer write..  
            return delegate.position();  
        public FileChannel truncate(long size) throws IOException {
import org.opensearch.core.common.bytes.BytesArray;
    public void testPartialReadWriteThroughBuffers() throws IOException {
                return delegate.write(mockSrc);
            delegate.close();  
            } finally {  
        @Override
        if (randomBoolean()) {
            return delegate.write(srcs, offset, length);
        } else {  
        }  
    public void testBufferReadPastEOFWithException() throws Exception {  
        assertThat(read, Matchers.equalTo(randomBytes.length));  
        ByteBuffer copy;
    @Before
 * Modifications Copyright OpenSearch Contributors. See
        Channels.writeToChannel(source, fileChannel);  
            return delegate.position(newPosition);
    }
    public void setUp() throws Exception {
package org.opensearch.common;
        if (randomBoolean()) {  
        public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {  
        public int read(ByteBuffer dst) throws IOException {
        int offsetToRead = randomIntBetween(0, length - lengthToRead);
    private static void writeToChannel(byte[] source, FileChannel channel) throws IOException {  
        }
        writeToChannel(randomBytes, fileChannel);  
        public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {  
import static org.hamcrest.Matchers.containsString;
        @Override
        int offset = randomIntBetween(0, randomBytes.length - length);
        int bytesToWrite = randomIntBetween(0, randomBytes.length - 1);
            Channels.readFromFileChannel(fileChannel, 0, bytesToWrite + 1 + randomInt(1000));
        FileChannel randomAccessFile = FileChannel.open(tmpFile, StandardOpenOption.READ, StandardOpenOption.WRITE);
 * GitHub history for details.
import java.nio.channels.FileChannel;
        byte[] copyBytes = new byte[read];
    @Override
        }  
            Channels.writeToChannel(source, offset, length, channel, channel.position());  
        byte[] readBytes = Channels.readFromFileChannel(fileChannel, 0, randomBytes.length);
