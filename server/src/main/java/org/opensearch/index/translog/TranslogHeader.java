        final int version;
import org.opensearch.common.io.Channels;
    static int readHeaderVersion(final Path path, final FileChannel channel, final StreamInput in) throws IOException {
     * All operations in a translog file are expected to have their primary terms at most this term.
        final BufferedChecksumStreamOutput out = new BufferedChecksumStreamOutput(new OutputStreamStreamOutput(outputStream));
        return translogUUID;
 * The OpenSearch Contributors require contributions made to
 * @opensearch.internal
    public int sizeInBytes() {
        // so we know if we grab the first byte, it can be:
        // Lucene's CodecUtil writes a magic number of 0x3FD76C17 with the header, in binary this looks like:
            if (version >= VERSION_PRIMARY_TERM) {
    static TranslogHeader read(final String translogUUID, final Path path, final FileChannel channel) throws IOException {
        @SuppressWarnings({ "IOResourceOpenedButNotSafelyClosed", "resource" })
                + headerSizeInBytes
    }
 * KIND, either express or implied.  See the License for the
            + headerSizeInBytes
        out.writeInt(uuid.length);
    }
 */
                throw new TranslogCorruptedException(path.toString(), "UUID length must be positive");
        // Write uuid
            throw new TranslogCorruptedException(
 * software distributed under the License is distributed on an
            + "], channel position ["
    public static final int CURRENT_VERSION = VERSION_PRIMARY_TERM;
 * You may obtain a copy of the License at
        this.primaryTerm = primaryTerm;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
     */
    }
                "expected shard UUID "
            in.read(uuid.bytes, uuid.offset, uuid.length);
        out.flush();
        // Write primary term
        // hex : 3 f d 7 6 c 1 7
 * this work for additional information regarding copyright
            assert channel.position() == headerSizeInBytes : "Header is not fully read; header size ["
        // With version 0 of the translog, the first byte is the Operation.Type, which will always be between 0-4,
}
 *
    }
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.store.OutputStreamDataOutput;
            );
    /**
import org.apache.lucene.codecs.CodecUtil;
        if (fsync == true) {
        return headerSizeInBytes;
 *
 * Licensed to Elasticsearch under one or more contributor
        final BytesRef actualUUID = new BytesRef(translogHeader.translogUUID);
    }
 * license agreements. See the NOTICE file distributed with
            + channel.position()
            version = CodecUtil.checkHeader(new InputStreamDataInput(in), TRANSLOG_CODEC, VERSION_CHECKSUMS, VERSION_PRIMARY_TERM);
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }
     *                     All operations' terms in this translog file are enforced to be at most this term.
 * specific language governing permissions and limitations
    /**
import org.opensearch.core.common.io.stream.BufferedChecksumStreamInput;
     * See {@link BaseTranslogReader#getFirstOperationOffset()}
    /**
            final int headerSizeInBytes = headerSizeInBytes(version, uuid.length);
     *                     different engine
            size += Integer.BYTES; // checksum
    private TranslogHeader(String translogUUID, long primaryTerm, int headerSizeInBytes) {
import org.opensearch.core.common.io.stream.StreamInput;
import java.nio.file.Path;
            final int uuidLen = in.readInt();
    }
            }
            throw new IllegalStateException("pre-1.4 translog found [" + path + "]");
        } catch (CorruptIndexException | IndexFormatTooOldException | IndexFormatTooNewException e) {
                primaryTerm = UNASSIGNED_PRIMARY_TERM;
    }
            }
    private static int headerSizeInBytes(int version, int uuidLength) {
    public String getTranslogUUID() {
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
    void write(final OutputStream outputStream) throws IOException {
        //
        if (version == VERSION_CHECKSUMS) {
            // Read the primary term
    }
     */
     *
            final BufferedChecksumStreamInput in = new BufferedChecksumStreamInput(
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
     * @param primaryTerm  the primary term of the owning index shard when creating (eg. rolling) this translog file.
    }
            channel.force(true);
        CodecUtil.writeHeader(new OutputStreamDataOutput(out), TRANSLOG_CODEC, CURRENT_VERSION);
        out.writeLong(primaryTerm);
     * Returns the header size in bytes. This value can be used as the offset of the first translog operation.
        } else if (b1 == 0x00) { // UNVERSIONED_TRANSLOG_HEADER_BYTE
            assert primaryTerm >= 0 : "Primary term must be non-negative [" + primaryTerm + "]; translog path [" + path + "]";
        // verify UUID only after checksum, to ensure that UUID is not corrupted
        }
 * Unless required by applicable law or agreed to in writing,
     */
package org.opensearch.index.translog;
     * @param translogUUID this UUID is used to prevent accidental recovery from a transaction log that belongs to a
        // binary: 0011 1111 1101 0111 0110 1100 0001 0111
        return version;
import org.apache.lucene.index.IndexFormatTooOldException;
    TranslogHeader(String translogUUID, long primaryTerm) {
        int size = CodecUtil.headerLength(TRANSLOG_CODEC);
                + "], position ["
    public static final int VERSION_PRIMARY_TERM = 3; // added primary term
        out.writeInt((int) out.getChecksum());
import org.apache.lucene.util.BytesRef;
            size += Long.BYTES;    // primary term
            throw new TranslogCorruptedException(path.toString(), "translog header truncated", e);
    public static final int VERSION_CHECKSUMS = 1; // pre-2.0 - unsupported
    private static void tryReportOldVersionError(final Path path, final FileChannel channel) throws IOException {
import java.io.OutputStream;
     * Returns the primary term stored in this translog header.
        return size;
     * Read a translog header from the given path and file channel and compare the given UUID
        }
            final int version = readHeaderVersion(path, channel, in);
    /**
            );
        this.headerSizeInBytes = headerSizeInBytes;
            if (uuidLen > channel.size()) {
     * Creates a new translog header with the given uuid and primary term.
 * under the License.
            if (version == VERSION_PRIMARY_TERM) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            throw new TranslogCorruptedException(path.toString(), "translog header corrupted", e);
            // Verify the checksum
    /**
        TranslogHeader translogHeader = read(path, channel);
        try {
    /**
            final long primaryTerm;
        // 0x3f => Lucene's magic number, so we can assume it's version 1 or later
    }
import org.apache.lucene.index.CorruptIndexException;
        this.translogUUID = translogUUID;
            + "]";
            } else {
        }
            uuid.length = uuidLen;
            throw new TranslogCorruptedException(path.toString(), "translog looks like version 1 or later, but has corrupted header");
        // This output is intentionally not closed because closing it will close the FileChannel.
        assert channel.position() == headerSizeInBytes : "Header is not fully written; header size ["
            // Read the translogUUID
    private final long primaryTerm;
     * Writes this header with the latest format into the file channel
        OutputStream outputStream = java.nio.channels.Channels.newOutputStream(channel);
 *
 */
    public static TranslogHeader read(final Path path, final FileChannel channel) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
     * Read a translog header from the given path and file channel and compare the given UUID
        }
            tryReportOldVersionError(path, channel);
    void write(final FileChannel channel, boolean fsync) throws IOException {
import org.apache.lucene.index.IndexFormatTooNewException;
    }
    public static final int VERSION_CHECKPOINTS = 2; // added checkpoints
        if (b1 == 0x3f) { // LUCENE_CODEC_HEADER_BYTE
    }
                    + translogUUID
            return new TranslogHeader(uuid.utf8ToString(), primaryTerm, headerSizeInBytes);
        final BytesRef expectedUUID = new BytesRef(translogUUID);
                assert version == VERSION_CHECKPOINTS : "Unknown header version [" + version + "]";
        this(translogUUID, primaryTerm, headerSizeInBytes(translogUUID));
                + "]";
 */
        // 0x00 => version 0 of the translog
        }
/*
            final BytesRef uuid = new BytesRef(uuidLen);
            throw new IllegalStateException("pre-2.0 translog found [" + path + "]");
                    + translogHeader.translogUUID
 * ownership. Elasticsearch licenses this file to you under
        try {
        write(outputStream);
        final byte b1 = Channels.readFromFileChannel(channel, 0, 1)[0];
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
            }
    public static final String TRANSLOG_CODEC = "translog";
        // Checksum header
 *
            }
        return primaryTerm;
/**
     */
/*
    public long getPrimaryTerm() {
                + channel.position()
public final class TranslogHeader {
import org.apache.lucene.store.InputStreamDataInput;
    private final int headerSizeInBytes;
     */
        if (version >= VERSION_PRIMARY_TERM) {
        out.writeBytes(uuid.bytes, uuid.offset, uuid.length);
     */
                    + " but got: "
import java.io.EOFException;
 * Each translog file is started with a translog header then followed by translog operations.
                path.toString()
    static int headerSizeInBytes(String translogUUID) {
import java.io.IOException;
                Translog.verifyChecksum(in);
        }
        } catch (EOFException e) {
/*
        size += Integer.BYTES + uuidLength; // uuid
                primaryTerm = in.readLong();
                throw new TranslogCorruptedException(path.toString(), "UUID length can't be larger than the translog");
                path.toString(),
 * GitHub history for details.
        }
    private final String translogUUID;
                new InputStreamStreamInput(java.nio.channels.Channels.newInputStream(channel), channel.size()),
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
import java.nio.channels.FileChannel;
        return headerSizeInBytes(CURRENT_VERSION, new BytesRef(translogUUID).length);
        final BytesRef uuid = new BytesRef(translogUUID);
 * not use this file except in compliance with the License.
 */
                    + " this translog file belongs to a different translog"
        return translogHeader;
            if (uuidLen <= 0) {
            // This input is intentionally not closed because closing it will close the FileChannel.
        if (actualUUID.bytesEquals(expectedUUID) == false) {
        assert primaryTerm >= 0 : "Primary term must be non-negative; term [" + primaryTerm + "]";
