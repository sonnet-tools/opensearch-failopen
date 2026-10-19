     *
    private TranslogFooter() {}
            return null;
     *         before footers were introduced, or one whose footer was never completed)
    }
        }
 *   0        firstOperationOffset   checkpoint.offset   checkpoint.offset + FOOTER_LENGTH
import java.nio.file.StandardOpenOption;
        final byte[] footer = byteArrayOutputStream.toByteArray();
package org.opensearch.index.translog;
        if (toSync) {
    }
import java.io.ByteArrayOutputStream;
        Path translogPath = location.resolve(Translog.getFilename(generation));
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
            // Either an older generation without a footer (size == offset) or a partially written footer.
        if (Files.isRegularFile(translogPath) == false || Files.isRegularFile(checkpointPath) == false) {
    /**
     * @throws IOException if either file cannot be read
     * footer, locating the footer via the generation's own checkpoint file.
     */
    /**
     * @throws TranslogCorruptedException if the checkpoint file fails its own header/CRC validation
     */
 * @opensearch.internal
     * Convenience overload of {@link #readChecksum(FileChannel, long)} that opens {@code path} read-only.
 *   [ header ][ operations ........ ][ footer ]
        }
        final int bytesRead = Channels.readFromFileChannel(channel, checkpointOffset, footer);
 */
 * {@code checkpoint.offset + FOOTER_LENGTH} bytes long and the bytes at {@code checkpoint.offset} must carry
 *   <li>Magic number (int) - {@link CodecUtil#FOOTER_MAGIC}</li>
    /**
 * SPDX-License-Identifier: Apache-2.0
 * outside the byte range that {@link TranslogReader} ever reads operations from. This keeps the on-disk
}
     * @param checkpointOffset the {@code offset} recorded in the generation's checkpoint, i.e. where the footer starts
 * Handles the writing and reading of the translog footer, which carries the checksum of the translog
 * older node during a rolling upgrade. Its presence is detected structurally: the file must be exactly
        Checkpoint checkpoint = Checkpoint.read(checkpointPath);
     *
 * <pre>
     * @throws IOException if an I/O error occurs while writing the footer
    static final int FOOTER_LENGTH = Integer.BYTES + Integer.BYTES + Long.BYTES;
     *
    static Long readChecksum(Path path, long checkpointOffset) throws IOException {
     * Identifier for the CRC32 checksum computed by {@link TranslogCheckedContainer}. This is the only algorithm
        if (checkpoint.generation != generation) {
 *
    public static Long readGenerationChecksum(Path location, long generation) throws IOException {
        assert footer.length == FOOTER_LENGTH : footer.length;
 * that its download can be skipped. A local-only translog is never downloaded and keeps the footer-less layout
     * Length of the footer in bytes: 4 (magic) + 4 (algorithm id) + 8 (checksum).
 * <p>The footer is written <b>after</b> the offset recorded in the generation's checkpoint, i.e. it lives
        return footer.getLong();
     */
 * The OpenSearch Contributors require contributions made to
            return null;
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
            return null;
 * format readable by nodes that predate the footer (they only read up to {@code checkpoint.offset}), so the
import java.nio.ByteBuffer;
            return null;
        final OutputStreamDataOutput out = new OutputStreamDataOutput(new OutputStreamStreamOutput(byteArrayOutputStream));
    /**
    /**
    }
 * decide whether a generation already present on local disk is byte-identical to the one in the remote store, so
        CodecUtil.writeBEInt(out, CHECKSUM_ALGORITHM_CRC32);
 * <p>The footer is only written for remote-store translogs: its checksum is used by {@link RemoteFsTranslog} to
        Path checkpointPath = location.resolve(Translog.getCommitCheckpointFileName(generation));
    static int footerLength() {
        }
        }
 * </pre>
     * @param toSync   whether to fsync the channel after writing the footer
        }
     */
 * </ul>
     * @param checksum the checksum of the bytes preceding the footer (header + operations)
    }
     * @param channel          an open channel on the translog file
 *   <li>Checksum (long) - checksum of {@code [0, checkpoint.offset)}, i.e. header plus operations</li>
import java.nio.file.Path;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(FOOTER_LENGTH);
     * @param channel  the translog file channel, positioned at the end of the operations
     * Appends the footer at the current position of {@code channel}.
     * in use today; the field exists so the footer can be evolved without a layout change.
            return null;
     */
import org.apache.lucene.store.OutputStreamDataOutput;
        if (footer.getInt() != CHECKSUM_ALGORITHM_CRC32) {
public final class TranslogFooter {
        CodecUtil.writeBEInt(out, CodecUtil.FOOTER_MAGIC);
     * @return the checksum stored in the footer, or {@code null} if the file carries no footer (a generation written
        footer.flip();
        Channels.writeToChannel(footer, channel);
 *
     */
        return FOOTER_LENGTH;
        return readChecksum(translogPath, checkpoint.offset);
        if (footer.getInt() != CodecUtil.FOOTER_MAGIC) {
    static final int CHECKSUM_ALGORITHM_CRC32 = 0;
 * <p>A closed translog generation is laid out as:
        if (bytesRead != FOOTER_LENGTH) {
     * Reads the content checksum from the footer of a translog generation, if one is present.
/**
 *
            return readChecksum(channel, checkpointOffset);
     * Returns the length of the translog footer in bytes.
     * Reads the content checksum that generation {@code generation} in {@code location} advertises through its
 *
 * <ul>
 * compatible open source license.
        if (channel.size() != checkpointOffset + FOOTER_LENGTH) {
import java.nio.file.Files;
    static Long readChecksum(FileChannel channel, long checkpointOffset) throws IOException {
        return footer;
 * (file size equal to {@code checkpoint.offset}) it has always had.
 *
            return null;
 * translog header version does not need to change and a remote-backed shard can still fail over onto an
/*
     * @return the footer checksum, or {@code null} if the translog or its checkpoint file is missing, the checkpoint
     * @return the footer bytes that were written, so callers can fold them into a running checksum
        }
        }
        final ByteBuffer footer = ByteBuffer.allocate(FOOTER_LENGTH);
 *
 * content (header + operations) that precedes it.
     */
     * @throws IOException if an I/O error occurs while reading
import org.opensearch.common.io.Channels;
import java.nio.channels.FileChannel;
 * <p>The footer contains:
        }
        CodecUtil.writeBELong(out, checksum);
 * the footer magic and a known algorithm id.
import java.io.IOException;
            channel.force(false);
import org.apache.lucene.codecs.CodecUtil;
    /**
 */
 * this file be licensed under the Apache-2.0 license or a
     *         belongs to a different generation, or the translog carries no complete footer
    static byte[] write(FileChannel channel, long checksum, boolean toSync) throws IOException {
 *   <li>Algorithm ID (int) - identifies the checksum algorithm, currently always {@link #CHECKSUM_ALGORITHM_CRC32}</li>
    /**
    }
