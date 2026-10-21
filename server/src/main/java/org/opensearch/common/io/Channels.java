        ByteBuffer buffer = ByteBuffer.wrap(dest, destOffset, length);
     * read <i>length</i> bytes from <i>position</i> of a file channel.
     * read from a file channel into a byte buffer, starting at a certain position.  An EOFException will be thrown if you
        while (length > 0) {
    /**
     * Writes part of a byte array to a {@link java.nio.channels.WritableByteChannel} at the provided
        }
     * The maximum chunk size for writes in bytes
                while (byteBuffer.hasRemaining()) {
     */
     * @param channel         channel to read from
    ) throws IOException {
                + "]";
    private Channels() {}
                while (dest.hasRemaining()) {
 */
            buffer.limit(buffer.position() + toWrite);
 * compatible open source license.
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
            int bytesToRead = dest.remaining();
                    channelPosition += read;
 * specific language governing permissions and limitations
     *
 */
     *
/*
    private static final int READ_CHUNK_SIZE = 16384;
                return read;
    }
        } else {
                "read past EOF. pos [" + channelPosition + "] length: [" + dest.limit() + "] end: [" + channel.size() + "]"
    public static void writeToChannel(byte[] source, int offset, int length, WritableByteChannel channel) throws IOException {
                }
        }
import java.nio.channels.WritableByteChannel;
        throws IOException {
import java.nio.channels.FileChannel;
            try {
     * that will fit in the destination byte buffer.
        assert length == 0 : "wrote more then expected bytes (length=" + length + ")";
    public static void writeToChannel(byte[] source, WritableByteChannel channel) throws IOException {
        return bytesRead;
        ByteBuffer buffer = ByteBuffer.wrap(source, offset, length);
            } finally {
        readFromFileChannelWithEofException(channel, position, res, 0, length);
            throw new EOFException(
 * license agreements. See the NOTICE file distributed with
     */
    /**
 *
        int written = channel.write(buffer, channelPosition);
            return bytesRead;
     * @param channelPosition position to read from
                + "(FileChannel is in blocking mode, see spec of ReadableByteChannel)";
            } finally {
    }
        if (dest.isDirect() || (dest.remaining() < READ_CHUNK_SIZE)) {
     */
                    while (tmpBuffer.hasRemaining()) {
                + bytesRead
            int read = channel.read(dest, channelPosition);
            throw new EOFException("read past EOF. pos [" + channelPosition + "] length: [" + length + "] end: [" + channel.size() + "]");
            try {
            written = channel.write(buffer);
     * @param dest            destination byte array to put data in
                channel.write(byteBuffer);
                        channel.write(tmpBuffer);
 * this file be licensed under the Apache-2.0 license or a
                + bytesToRead
            bytesRead += read;
    }
import org.opensearch.common.SuppressForbidden;
                + "] needed ["
     *
     * @param channelPosition position to write at
     * @param destOffset      offset in dest to read into
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            int bytesRead = 0;
            channelPosition += read;
 */
     */
 * under the License.
/*
     * @param channel         channel to read from
        ByteBuffer buffer = ByteBuffer.wrap(source, offset, toWrite);
     * @param channel         channel to read from
                // make sure we update byteBuffer to indicate how far we came..
    }
     * @param channel         target WritableByteChannel
    }
    public static void writeToChannel(byte[] source, FileChannel channel, long channelPosition) throws IOException {
            }
 * the Apache License, Version 2.0 (the "License"); you may
     * Writes part of a byte array to a {@link java.nio.channels.WritableByteChannel} at the provided
@SuppressForbidden(reason = "Channel#read")
        }
    /**
    }
     * @param dest            destination byte array to put data in
 * KIND, either express or implied.  See the License for the
     *
            assert bytesRead == bytesToRead : "failed to read an entire buffer but also didn't get an EOF (read ["
     * @return total bytes read or -1 if an attempt was made to read past EOF. The method always tries to read all the bytes
    }
 * You may obtain a copy of the License at
     *
                byteBuffer.position(tmpBuffer.position());
            return readSingleChunk(channel, channelPosition, dest);
    public static byte[] readFromFileChannel(FileChannel channel, long position, int length) throws IOException {
    /**
     * attempt to read beyond the end of file.
            ByteBuffer tmpBuffer = byteBuffer.duplicate();
        }
        FileChannel channel,
     * @param dest            destination {@link java.nio.ByteBuffer} to put data in
     * read <i>length</i> bytes from <i>position</i> of a file channel. An EOFException will be thrown if you
     *
    /**
     * The maximum chunk size for reads in bytes
     * read <i>length</i> bytes from <i>position</i> of a file channel
                    tmpBuffer.limit(Math.min(byteBuffer.limit(), tmpBuffer.position() + WRITE_CHUNK_SIZE));
        int length
     * @param channelPosition position to read from
        byte[] res = new byte[length];
        if (read < 0) {
        if (byteBuffer.isDirect() || (byteBuffer.remaining() <= WRITE_CHUNK_SIZE)) {
            }
    public static void readFromFileChannelWithEofException(
        return res;
            }
     * @param length          number of bytes to read
     * Writes part of a byte array to a {@link java.nio.channels.WritableByteChannel}
     * @param offset  start copying from this offset
public final class Channels {
 * Unless required by applicable law or agreed to in writing,
     * @param channelPosition position to write at
                    byteBuffer.position(tmpBuffer.position());
     * @return total bytes read or -1 if an attempt was made to read past EOF. The method always tries to read all the bytes
import java.nio.ByteBuffer;
        int toWrite = Math.min(length, WRITE_CHUNK_SIZE);
    /**
        int read = readFromFileChannel(channel, channelPosition, dest, destOffset, length);
    }
     */
    public static int readFromFileChannel(FileChannel channel, long channelPosition, ByteBuffer dest) throws IOException {
     * @param length  how many bytes to copy
                    dest.position(tmpBuffer.position());
     * position.
                        return read;
            if (read < 0) {
 */
            written = channel.write(buffer, channelPosition + buffer.position());
        int read = readFromFileChannel(channel, channelPosition, dest);
 * this work for additional information regarding copyright
    public static int readFromFileChannel(FileChannel channel, long channelPosition, byte[] dest, int destOffset, int length)
     */
    /**
                    bytesRead += read;
    }
     * @param channel         channel to read from
     * @param byteBuffer source buffer
     */
    /**
    private static final int WRITE_CHUNK_SIZE = 8192;
            while (byteBuffer.hasRemaining()) {
            assert read > 0 : "FileChannel.read with non zero-length bb.remaining() must always read at least one byte "
        int bytesRead = 0;
    /**
    public static void writeToChannel(ByteBuffer byteBuffer, WritableByteChannel channel) throws IOException {
            ByteBuffer tmpBuffer = dest.duplicate();
                    }
 *
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param channel target WritableByteChannel
 * Modifications Copyright OpenSearch Contributors. See
     * @param channelPosition position to read from
    /**
    /**
     * @param dest            destination {@link java.nio.ByteBuffer} to put data in
     * @param source          byte array to copy from
                    if (read < 0) {
     * attempt to read beyond the end of file.
import java.io.IOException;
        while (dest.hasRemaining()) {
     */
        length -= written;
    }
     */
    }
/*
            );
        while (length > 0) {
            length -= written;
    public static void writeToChannel(byte[] source, int offset, int length, FileChannel channel, long channelPosition) throws IOException {
    public static void readFromFileChannelWithEofException(FileChannel channel, long channelPosition, ByteBuffer dest) throws IOException {
     * @param source          byte array to copy from
        if (read < 0) {
                dest.position(tmpBuffer.position());
     * Writes a {@link java.nio.ByteBuffer} to a {@link java.nio.channels.WritableByteChannel}
            // duplicate the buffer in order to be able to change the limit
 * ownership. Elasticsearch licenses this file to you under
     * @param length          number of bytes to read
        long channelPosition,
 * Data channels
import java.io.EOFException;
     * @param channel         target WritableByteChannel
/**
            }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.io;
     */
     *
        }
        }
     * @param channel target WritableByteChannel
        } else {
                    }
        writeToChannel(source, 0, source.length, channel);
 *
            toWrite = Math.min(length, WRITE_CHUNK_SIZE);
     * read from a file channel into a byte buffer, starting at a certain position.
     * @param offset          start copying from this offset
        int destOffset,
     * Writes part of a byte array to a {@link java.nio.channels.WritableByteChannel}
     *
            length -= written;
 * software distributed under the License is distributed on an
     */
                }
                    int read = readSingleChunk(channel, channelPosition, tmpBuffer);
    /**
     * @param source  byte array to copy from
        length -= written;
}
 * @opensearch.internal
        assert length == 0 : "wrote more then expected bytes (length=" + length + ")";
    private static int readSingleChunk(FileChannel channel, long channelPosition, ByteBuffer dest) throws IOException {
     * @param destOffset      offset in dest to read into
     */
        byte[] dest,
        return readFromFileChannel(channel, channelPosition, buffer);
     * @param source  byte array to copy from
 * not use this file except in compliance with the License.
     * that will fit in the destination byte buffer.
        int written = channel.write(buffer);
                    tmpBuffer.limit(Math.min(dest.limit(), tmpBuffer.position() + READ_CHUNK_SIZE));
        }
            // duplicate the buffer in order to be able to change the limit
     * @param length          how many bytes to copy
                // make sure we update byteBuffer to indicate how far we came..
 * Licensed to Elasticsearch under one or more contributor
     * @param channel    channel to write to
     * position.
        writeToChannel(source, 0, source.length, channel, channelPosition);
     * @param channelPosition position to read from
