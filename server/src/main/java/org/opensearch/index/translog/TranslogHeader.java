            final int uuidLen = in.readInt();
        // Lucene's CodecUtil writes a magic number of 0x3FD76C17 with the header, in binary this looks like:
     */
     */  
            final long primaryTerm;
            }
     * Creates a new translog header with the given uuid and primary term.
 */  
            if (uuidLen <= 0) {  
        out.writeInt(uuid.length);  
 * this file be licensed under the Apache-2.0 license or a
        assert channel.position() == headerSizeInBytes : "Header is not fully written; header size ["  
import java.nio.file.Path;
            + "]";
            throw new TranslogCorruptedException(path.toString(), "translog header corrupted", e);  
        if (b1 == 0x3f) { // LUCENE_CODEC_HEADER_BYTE
        this.primaryTerm = primaryTerm;
        }
            version = CodecUtil.checkHeader(new InputStreamDataInput(in), TRANSLOG_CODEC, VERSION_CHECKSUMS, VERSION_PRIMARY_TERM);  
            } else {
                throw new TranslogCorruptedException(path.toString(), "UUID length can't be larger than the translog");
    /**
 * specific language governing permissions and limitations
            );  
/*  
        return primaryTerm;
        if (version == VERSION_CHECKSUMS) {
package org.opensearch.index.translog;
 * KIND, either express or implied.  See the License for the
     */
            + "], channel position ["
import org.apache.lucene.store.InputStreamDataInput;
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
    }
    static int headerSizeInBytes(String translogUUID) {
 *
 */
    }  
 *
            + headerSizeInBytes
        // hex : 3 f d 7 6 c 1 7  
        size += Integer.BYTES + uuidLength; // uuid
            if (uuidLen > channel.size()) {  
    public String getTranslogUUID() {
    }  
        if (fsync == true) {  
        final BufferedChecksumStreamOutput out = new BufferedChecksumStreamOutput(new OutputStreamStreamOutput(outputStream));
                Translog.verifyChecksum(in);
        this.headerSizeInBytes = headerSizeInBytes;
    private final int headerSizeInBytes;
     * Returns the header size in bytes. This value can be used as the offset of the first translog operation.  
        if (version >= VERSION_PRIMARY_TERM) {
    }
        return headerSizeInBytes(CURRENT_VERSION, new BytesRef(translogUUID).length);
        @SuppressWarnings({ "IOResourceOpenedButNotSafelyClosed", "resource" })
     *                     All operations' terms in this translog file are enforced to be at most this term.
    private final String translogUUID;  
                + "]";
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * Each translog file is started with a translog header then followed by translog operations.  
                path.toString()
            throw new IllegalStateException("pre-2.0 translog found [" + path + "]");  
            // Verify the checksum
                    + translogHeader.translogUUID
            }
                "expected shard UUID "
import org.apache.lucene.store.OutputStreamDataOutput;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return translogUUID;  
    }  
                primaryTerm = in.readLong();  
            size += Integer.BYTES; // checksum
    }
    TranslogHeader(String translogUUID, long primaryTerm) {  
        } catch (CorruptIndexException | IndexFormatTooOldException | IndexFormatTooNewException e) {
            if (version >= VERSION_PRIMARY_TERM) {  
        // 0x00 => version 0 of the translog
                    + " but got: "  
    public static TranslogHeader read(final Path path, final FileChannel channel) throws IOException {
            return new TranslogHeader(uuid.utf8ToString(), primaryTerm, headerSizeInBytes);  
import org.apache.lucene.index.IndexFormatTooOldException;
        this(translogUUID, primaryTerm, headerSizeInBytes(translogUUID));
        //
    static int readHeaderVersion(final Path path, final FileChannel channel, final StreamInput in) throws IOException {  
        try {
            assert channel.position() == headerSizeInBytes : "Header is not fully read; header size ["  
    /**
            tryReportOldVersionError(path, channel);
            if (version == VERSION_PRIMARY_TERM) {
     * @param primaryTerm  the primary term of the owning index shard when creating (eg. rolling) this translog file.  
     * All operations in a translog file are expected to have their primary terms at most this term.
            // Read the primary term  
import org.opensearch.core.common.io.stream.StreamInput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
                path.toString(),  
        // 0x3f => Lucene's magic number, so we can assume it's version 1 or later
 */  
        out.writeInt((int) out.getChecksum());
/*
            }
        final byte b1 = Channels.readFromFileChannel(channel, 0, 1)[0];  
import java.nio.channels.FileChannel;  
        final BytesRef actualUUID = new BytesRef(translogHeader.translogUUID);  
    private final long primaryTerm;
        TranslogHeader translogHeader = read(path, channel);  
            final int headerSizeInBytes = headerSizeInBytes(version, uuid.length);
 * under the License.  
    public static final int VERSION_CHECKPOINTS = 2; // added checkpoints
import org.apache.lucene.codecs.CodecUtil;
 * the Apache License, Version 2.0 (the "License"); you may
            }
    static TranslogHeader read(final String translogUUID, final Path path, final FileChannel channel) throws IOException {
    public static final int VERSION_PRIMARY_TERM = 3; // added primary term  
     * See {@link BaseTranslogReader#getFirstOperationOffset()}
            throw new IllegalStateException("pre-1.4 translog found [" + path + "]");
        return version;
            throw new TranslogCorruptedException(path.toString(), "translog looks like version 1 or later, but has corrupted header");
        out.writeLong(primaryTerm);  
        return size;  
    }
                    + " this translog file belongs to a different translog"
        out.flush();  
import java.io.OutputStream;
            );
 * not use this file except in compliance with the License.
 *
                new InputStreamStreamInput(java.nio.channels.Channels.newInputStream(channel), channel.size()),  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;  
        CodecUtil.writeHeader(new OutputStreamDataOutput(out), TRANSLOG_CODEC, CURRENT_VERSION);  
 * license agreements. See the NOTICE file distributed with
 */  
        if (actualUUID.bytesEquals(expectedUUID) == false) {
 * Modifications Copyright OpenSearch Contributors. See
            throw new TranslogCorruptedException(
    /**
     */
import java.io.EOFException;  
        // With version 0 of the translog, the first byte is the Operation.Type, which will always be between 0-4,
}  
        // Checksum header
            final BytesRef uuid = new BytesRef(uuidLen);  
    private static void tryReportOldVersionError(final Path path, final FileChannel channel) throws IOException {  
        // Write uuid
    private static int headerSizeInBytes(int version, int uuidLength) {
public final class TranslogHeader {
            assert primaryTerm >= 0 : "Primary term must be non-negative [" + primaryTerm + "]; translog path [" + path + "]";  
        this.translogUUID = translogUUID;  
            channel.force(true);
     * Read a translog header from the given path and file channel and compare the given UUID  
            final BufferedChecksumStreamInput in = new BufferedChecksumStreamInput(
        out.writeBytes(uuid.bytes, uuid.offset, uuid.length);
        }  
        return translogHeader;
     * Returns the primary term stored in this translog header.
import org.apache.lucene.util.BytesRef;
            size += Long.BYTES;    // primary term  
        // Write primary term
 * compatible open source license.
    void write(final OutputStream outputStream) throws IOException {
        assert primaryTerm >= 0 : "Primary term must be non-negative; term [" + primaryTerm + "]";
        final BytesRef expectedUUID = new BytesRef(translogUUID);
                primaryTerm = UNASSIGNED_PRIMARY_TERM;  
                + channel.position()  
 * GitHub history for details.
     */
 * software distributed under the License is distributed on an
/*  
                assert version == VERSION_CHECKPOINTS : "Unknown header version [" + version + "]";
import java.io.IOException;
    public int sizeInBytes() {  
            + channel.position()  
    }  
        // binary: 0011 1111 1101 0111 0110 1100 0001 0111
     *  
        } catch (EOFException e) {
        }
    /**
        final BytesRef uuid = new BytesRef(translogUUID);
        int size = CodecUtil.headerLength(TRANSLOG_CODEC);  
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
            // Read the translogUUID
 * SPDX-License-Identifier: Apache-2.0
        }
 *  
        }
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    }  
 * ownership. Elasticsearch licenses this file to you under  
/**
            uuid.length = uuidLen;
    public static final String TRANSLOG_CODEC = "translog";
                + "], position ["
     * Read a translog header from the given path and file channel and compare the given UUID  
    }
     * @param translogUUID this UUID is used to prevent accidental recovery from a transaction log that belongs to a
    }
                + headerSizeInBytes
     * Writes this header with the latest format into the file channel  
    public long getPrimaryTerm() {
        } else if (b1 == 0x00) { // UNVERSIONED_TRANSLOG_HEADER_BYTE  
    public static final int VERSION_CHECKSUMS = 1; // pre-2.0 - unsupported
            final int version = readHeaderVersion(path, channel, in);  
        OutputStream outputStream = java.nio.channels.Channels.newOutputStream(channel);
import org.opensearch.core.common.io.stream.BufferedChecksumStreamInput;  
import org.apache.lucene.index.CorruptIndexException;
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;  
        }
    /**  
 * Licensed to Elasticsearch under one or more contributor  
        // so we know if we grab the first byte, it can be:  
    }  
        // verify UUID only after checksum, to ensure that UUID is not corrupted
        final int version;
            // This input is intentionally not closed because closing it will close the FileChannel.
        // This output is intentionally not closed because closing it will close the FileChannel.  
                    + translogUUID
     */
                throw new TranslogCorruptedException(path.toString(), "UUID length must be positive");
     *                     different engine
        write(outputStream);
import org.apache.lucene.index.IndexFormatTooNewException;  
    public static final int CURRENT_VERSION = VERSION_PRIMARY_TERM;
    private TranslogHeader(String translogUUID, long primaryTerm, int headerSizeInBytes) {
 * @opensearch.internal
        return headerSizeInBytes;
            throw new TranslogCorruptedException(path.toString(), "translog header truncated", e);
    }  
            in.read(uuid.bytes, uuid.offset, uuid.length);
import org.opensearch.common.io.Channels;
        }
    void write(final FileChannel channel, boolean fsync) throws IOException {  
        try {  
