        Channels.writeToChannel(footer, channel);
     * @return the checksum stored in the footer, or {@code null} if the file carries no footer (a generation written
 * </pre>
        CodecUtil.writeBELong(out, checksum);
        if (bytesRead != FOOTER_LENGTH) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(FOOTER_LENGTH);  
 * the footer magic and a known algorithm id.  
 *   <li>Magic number (int) - {@link CodecUtil#FOOTER_MAGIC}</li>
     * Length of the footer in bytes: 4 (magic) + 4 (algorithm id) + 8 (checksum).
        if (footer.getInt() != CHECKSUM_ALGORITHM_CRC32) {
 *
 * The OpenSearch Contributors require contributions made to  
     * @param channel  the translog file channel, positioned at the end of the operations
 *
        if (footer.getInt() != CodecUtil.FOOTER_MAGIC) {
        }  
 * <pre>
     * Reads the content checksum from the footer of a translog generation, if one is present.
import java.nio.ByteBuffer;
     * Returns the length of the translog footer in bytes.
        footer.flip();
 *
    /**  
    static Long readChecksum(Path path, long checkpointOffset) throws IOException {
    /**
     * @param toSync   whether to fsync the channel after writing the footer
import java.nio.file.Path;
     * Identifier for the CRC32 checksum computed by {@link TranslogCheckedContainer}. This is the only algorithm
     *         belongs to a different generation, or the translog carries no complete footer
     * Appends the footer at the current position of {@code channel}.  
    static Long readChecksum(FileChannel channel, long checkpointOffset) throws IOException {  
 * format readable by nodes that predate the footer (they only read up to {@code checkpoint.offset}), so the
    public static Long readGenerationChecksum(Path location, long generation) throws IOException {
        if (checkpoint.generation != generation) {  
     */
     */
     *
 * compatible open source license.
    /**  
 * {@code checkpoint.offset + FOOTER_LENGTH} bytes long and the bytes at {@code checkpoint.offset} must carry
    }
 *
        return FOOTER_LENGTH;
        final byte[] footer = byteArrayOutputStream.toByteArray();  
 * that its download can be skipped. A local-only translog is never downloaded and keeps the footer-less layout
        return footer.getLong();
        if (Files.isRegularFile(translogPath) == false || Files.isRegularFile(checkpointPath) == false) {
 */  
 * outside the byte range that {@link TranslogReader} ever reads operations from. This keeps the on-disk
    /**
import org.apache.lucene.codecs.CodecUtil;
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
        final int bytesRead = Channels.readFromFileChannel(channel, checkpointOffset, footer);  
 * (file size equal to {@code checkpoint.offset}) it has always had.  
 * content (header + operations) that precedes it.
    }  
     *
     * @param checksum the checksum of the bytes preceding the footer (header + operations)  
        }
     * @throws IOException if either file cannot be read
    static final int CHECKSUM_ALGORITHM_CRC32 = 0;
        CodecUtil.writeBEInt(out, CodecUtil.FOOTER_MAGIC);
 *   [ header ][ operations ........ ][ footer ]
     *         before footers were introduced, or one whose footer was never completed)  
    private TranslogFooter() {}
        Checkpoint checkpoint = Checkpoint.read(checkpointPath);
    }  
        return footer;  
 * Handles the writing and reading of the translog footer, which carries the checksum of the translog  
     */  
import java.nio.file.StandardOpenOption;  
/*  
            return null;
    /**
            return readChecksum(channel, checkpointOffset);
 * <p>The footer is written <b>after</b> the offset recorded in the generation's checkpoint, i.e. it lives  
        return readChecksum(translogPath, checkpoint.offset);  
 * older node during a rolling upgrade. Its presence is detected structurally: the file must be exactly
import org.opensearch.common.io.Channels;  
 *   0        firstOperationOffset   checkpoint.offset   checkpoint.offset + FOOTER_LENGTH  
        CodecUtil.writeBEInt(out, CHECKSUM_ALGORITHM_CRC32);  
 * <p>The footer is only written for remote-store translogs: its checksum is used by {@link RemoteFsTranslog} to  
        if (toSync) {  
 * <p>A closed translog generation is laid out as:  
    /**
            return null;  
    static int footerLength() {
    static final int FOOTER_LENGTH = Integer.BYTES + Integer.BYTES + Long.BYTES;  
            return null;  
        final OutputStreamDataOutput out = new OutputStreamDataOutput(new OutputStreamStreamOutput(byteArrayOutputStream));
        Path checkpointPath = location.resolve(Translog.getCommitCheckpointFileName(generation));
 * <ul>  
     * footer, locating the footer via the generation's own checkpoint file.
     * @param channel          an open channel on the translog file  
public final class TranslogFooter {
 *   <li>Checksum (long) - checksum of {@code [0, checkpoint.offset)}, i.e. header plus operations</li>  
        }
 * translog header version does not need to change and a remote-backed shard can still fail over onto an  
    static byte[] write(FileChannel channel, long checksum, boolean toSync) throws IOException {
            return null;  
        Path translogPath = location.resolve(Translog.getFilename(generation));  
 */  
     * @throws IOException if an I/O error occurs while writing the footer  
 *   <li>Algorithm ID (int) - identifies the checksum algorithm, currently always {@link #CHECKSUM_ALGORITHM_CRC32}</li>
        assert footer.length == FOOTER_LENGTH : footer.length;
        }
 * </ul>
    }  
        }
    }
            return null;
import org.apache.lucene.store.OutputStreamDataOutput;
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {  
import java.nio.channels.FileChannel;  
     * @return the footer bytes that were written, so callers can fold them into a running checksum
}
     */
    /**  
     * @return the footer checksum, or {@code null} if the translog or its checkpoint file is missing, the checkpoint  
import java.io.ByteArrayOutputStream;  
 * SPDX-License-Identifier: Apache-2.0
     */
     */
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException if an I/O error occurs while reading
 *
 *
     * @throws TranslogCorruptedException if the checkpoint file fails its own header/CRC validation  
     *
            channel.force(false);
import java.nio.file.Files;
package org.opensearch.index.translog;
     * Reads the content checksum that generation {@code generation} in {@code location} advertises through its  
 * <p>The footer contains:
     * in use today; the field exists so the footer can be evolved without a layout change.
            // Either an older generation without a footer (size == offset) or a partially written footer.
        final ByteBuffer footer = ByteBuffer.allocate(FOOTER_LENGTH);
     * @param checkpointOffset the {@code offset} recorded in the generation's checkpoint, i.e. where the footer starts
            return null;  
 * decide whether a generation already present on local disk is byte-identical to the one in the remote store, so
        }
import java.io.IOException;
        if (channel.size() != checkpointOffset + FOOTER_LENGTH) {
 * @opensearch.internal
        }
     * Convenience overload of {@link #readChecksum(FileChannel, long)} that opens {@code path} read-only.  
/**
        }
     */  
