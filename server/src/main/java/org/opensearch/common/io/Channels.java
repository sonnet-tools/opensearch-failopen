                    while (tmpBuffer.hasRemaining()) {  
     */  
     *  
                        channel.write(tmpBuffer);
package org.opensearch.common.io;
            }
     * @param source  byte array to copy from
     * read from a file channel into a byte buffer, starting at a certain position.  An EOFException will be thrown if you
            assert read > 0 : "FileChannel.read with non zero-length bb.remaining() must always read at least one byte "
                    }
            while (byteBuffer.hasRemaining()) {  
    private static final int WRITE_CHUNK_SIZE = 8192;
import java.io.IOException;
     *
    private static final int READ_CHUNK_SIZE = 16384;
     * @param destOffset      offset in dest to read into  
        readFromFileChannelWithEofException(channel, position, res, 0, length);  
                    dest.position(tmpBuffer.position());
            written = channel.write(buffer, channelPosition + buffer.position());
            }
    public static void writeToChannel(byte[] source, int offset, int length, FileChannel channel, long channelPosition) throws IOException {
        int length
 * Modifications Copyright OpenSearch Contributors. See
     * @param byteBuffer source buffer
            buffer.limit(buffer.position() + toWrite);  
        } else {
                    }
            throw new EOFException(
        if (byteBuffer.isDirect() || (byteBuffer.remaining() <= WRITE_CHUNK_SIZE)) {
        if (dest.isDirect() || (dest.remaining() < READ_CHUNK_SIZE)) {  
 * SPDX-License-Identifier: Apache-2.0
    /**
        assert length == 0 : "wrote more then expected bytes (length=" + length + ")";
import org.opensearch.common.SuppressForbidden;
     * read <i>length</i> bytes from <i>position</i> of a file channel
    }
import java.nio.ByteBuffer;
    }
        } else {  
     * @param channelPosition position to read from
 * You may obtain a copy of the License at  
        }  
    public static void readFromFileChannelWithEofException(  
        assert length == 0 : "wrote more then expected bytes (length=" + length + ")";
     */
    }
 * GitHub history for details.
                + "]";
        writeToChannel(source, 0, source.length, channel, channelPosition);
     * @param channel         channel to read from
     * @param channelPosition position to write at
    /**
                // make sure we update byteBuffer to indicate how far we came..  
        writeToChannel(source, 0, source.length, channel);  
     * @param dest            destination byte array to put data in  
     * @param channel    channel to write to
                }
            ByteBuffer tmpBuffer = dest.duplicate();
 * not use this file except in compliance with the License.
     * @param channel target WritableByteChannel  
     * @return total bytes read or -1 if an attempt was made to read past EOF. The method always tries to read all the bytes
     * Writes part of a byte array to a {@link java.nio.channels.WritableByteChannel}  
/*
                    byteBuffer.position(tmpBuffer.position());  
                        return read;
        ByteBuffer buffer = ByteBuffer.wrap(source, offset, length);  
 * the Apache License, Version 2.0 (the "License"); you may
        if (read < 0) {
        length -= written;
 *
     * @param channelPosition position to read from
            try {  
     * @param offset          start copying from this offset  
     * @param dest            destination {@link java.nio.ByteBuffer} to put data in  
    /**
 *  
                + bytesToRead  
     * attempt to read beyond the end of file.
        int read = readFromFileChannel(channel, channelPosition, dest);  
        }
     * @param channel         channel to read from  
     * position.  
                while (dest.hasRemaining()) {  
 * Data channels
import java.io.EOFException;  
    public static int readFromFileChannel(FileChannel channel, long channelPosition, ByteBuffer dest) throws IOException {
     */
     * Writes part of a byte array to a {@link java.nio.channels.WritableByteChannel} at the provided
        long channelPosition,
 */
        int written = channel.write(buffer);
                }  
     * @param channelPosition position to write at  
            length -= written;
     * @param source  byte array to copy from  
 * The OpenSearch Contributors require contributions made to  
    public static void readFromFileChannelWithEofException(FileChannel channel, long channelPosition, ByteBuffer dest) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.nio.channels.FileChannel;  
    /**
            int bytesRead = 0;  
 * this file be licensed under the Apache-2.0 license or a
     * read from a file channel into a byte buffer, starting at a certain position.  
                "read past EOF. pos [" + channelPosition + "] length: [" + dest.limit() + "] end: [" + channel.size() + "]"  
     *
     *  
    /**
    }  
     */
     * attempt to read beyond the end of file.
    ) throws IOException {  
    /**  
            channelPosition += read;  
        int read = readFromFileChannel(channel, channelPosition, dest, destOffset, length);
    }
     * position.  
     * @param channel         target WritableByteChannel  
    /**
     * read <i>length</i> bytes from <i>position</i> of a file channel.
    /**  
 *
        FileChannel channel,
}
        return res;
        }  
                + "(FileChannel is in blocking mode, see spec of ReadableByteChannel)";  
            length -= written;
     * @param length          number of bytes to read
     * read <i>length</i> bytes from <i>position</i> of a file channel. An EOFException will be thrown if you  
     * @return total bytes read or -1 if an attempt was made to read past EOF. The method always tries to read all the bytes  
 * Licensed to Elasticsearch under one or more contributor  
        }  
     * @param source          byte array to copy from
                + bytesRead
    }
     *
            if (read < 0) {
     */
     * @param channel         channel to read from
     * @param channelPosition position to read from
        while (dest.hasRemaining()) {
     * that will fit in the destination byte buffer.
    public static void writeToChannel(ByteBuffer byteBuffer, WritableByteChannel channel) throws IOException {
        byte[] dest,  
     * @param destOffset      offset in dest to read into
     *
                    if (read < 0) {  
        length -= written;  
    /**
                // make sure we update byteBuffer to indicate how far we came..
        }  
    /**
    public static void writeToChannel(byte[] source, int offset, int length, WritableByteChannel channel) throws IOException {
 * license agreements. See the NOTICE file distributed with
     * Writes a {@link java.nio.ByteBuffer} to a {@link java.nio.channels.WritableByteChannel}
            // duplicate the buffer in order to be able to change the limit  
        ByteBuffer buffer = ByteBuffer.wrap(dest, destOffset, length);
        int written = channel.write(buffer, channelPosition);
     * Writes part of a byte array to a {@link java.nio.channels.WritableByteChannel}
 * ownership. Elasticsearch licenses this file to you under  
/*  
            bytesRead += read;
@SuppressForbidden(reason = "Channel#read")
     * @param source          byte array to copy from
            return readSingleChunk(channel, channelPosition, dest);
     * @param dest            destination {@link java.nio.ByteBuffer} to put data in
     * @param channel         target WritableByteChannel
                dest.position(tmpBuffer.position());  
                    tmpBuffer.limit(Math.min(byteBuffer.limit(), tmpBuffer.position() + WRITE_CHUNK_SIZE));
/*  
     */  
 * this work for additional information regarding copyright
     * @param dest            destination byte array to put data in
     */
                return read;
public final class Channels {  
        if (read < 0) {
    }  
                    bytesRead += read;  
    }
     * @param channel         channel to read from
    public static void writeToChannel(byte[] source, FileChannel channel, long channelPosition) throws IOException {  
            try {
 */
     * @param offset  start copying from this offset
            } finally {
            // duplicate the buffer in order to be able to change the limit
 * Unless required by applicable law or agreed to in writing,
                + "] needed ["
     */  
     * The maximum chunk size for reads in bytes
                channel.write(byteBuffer);
     */
        return bytesRead;
    public static void writeToChannel(byte[] source, WritableByteChannel channel) throws IOException {
    /**
     *  
            throw new EOFException("read past EOF. pos [" + channelPosition + "] length: [" + length + "] end: [" + channel.size() + "]");  
        throws IOException {
        return readFromFileChannel(channel, channelPosition, buffer);  
     * Writes part of a byte array to a {@link java.nio.channels.WritableByteChannel} at the provided
                    int read = readSingleChunk(channel, channelPosition, tmpBuffer);
            return bytesRead;
/**  
                    tmpBuffer.limit(Math.min(dest.limit(), tmpBuffer.position() + READ_CHUNK_SIZE));
 * compatible open source license.
                while (byteBuffer.hasRemaining()) {
     * @param channelPosition position to read from  
     * @param length          how many bytes to copy
    public static byte[] readFromFileChannel(FileChannel channel, long position, int length) throws IOException {
            int read = channel.read(dest, channelPosition);  
     * @param length  how many bytes to copy
    }  
            }
            }  
     */
 * KIND, either express or implied.  See the License for the
import java.nio.channels.WritableByteChannel;
        int toWrite = Math.min(length, WRITE_CHUNK_SIZE);  
        }
    /**
     * that will fit in the destination byte buffer.  
    }
            written = channel.write(buffer);
            } finally {
        ByteBuffer buffer = ByteBuffer.wrap(source, offset, toWrite);
                byteBuffer.position(tmpBuffer.position());
            ByteBuffer tmpBuffer = byteBuffer.duplicate();
    }
            assert bytesRead == bytesToRead : "failed to read an entire buffer but also didn't get an EOF (read ["  
     */
        int bytesRead = 0;
        }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            toWrite = Math.min(length, WRITE_CHUNK_SIZE);
        byte[] res = new byte[length];
     * @param length          number of bytes to read
            );
 * under the License.  
        while (length > 0) {  
     *
    private Channels() {}
 */  
 * @opensearch.internal  
     * The maximum chunk size for writes in bytes  
     * @param channel target WritableByteChannel  
            int bytesToRead = dest.remaining();
        while (length > 0) {
    public static int readFromFileChannel(FileChannel channel, long channelPosition, byte[] dest, int destOffset, int length)  
     */
                    channelPosition += read;
 * specific language governing permissions and limitations
    private static int readSingleChunk(FileChannel channel, long channelPosition, ByteBuffer dest) throws IOException {  
        int destOffset,
     *
 * software distributed under the License is distributed on an
