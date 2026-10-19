        try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.READ)) {
        assertNull(TranslogFooter.readChecksum(translogPath, checkpointOffset));
            Path translogPath = createTempFile();  
            assertEquals(checkpointOffset + TranslogFooter.footerLength(), channel.size());
            Path translogPath = createTempFile();  
        {
        // The returned bytes are exactly what landed on disk.  
            }
 * SPDX-License-Identifier: Apache-2.0
            footer = TranslogFooter.write(channel, expectedChecksum, randomBoolean());
        {
        {
        try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {  
 * compatible open source license.
        }
            checkpointOffset = writeHeaderAndOperations(channel);
        }  
        Path translogPath = createTempFile();  
    }  
/*  
        long checkpointOffset;
            assertEquals(TranslogFooter.footerLength(), footer.length);  
    }  
        byte[] onDisk = Files.readAllBytes(translogPath);
public class TranslogFooterTests extends OpenSearchTestCase {  
package org.opensearch.index.translog;
            long checkpointOffset;
        // Footer-sized trailer with the wrong magic.  
                ByteBuffer bogus = ByteBuffer.allocate(TranslogFooter.footerLength());
import org.opensearch.common.UUIDs;
     * wrong magic or algorithm id.
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(CodecUtil.FOOTER_MAGIC, footerBuffer.getInt());
        long expectedChecksum = randomLong();  
        {  
import org.opensearch.test.OpenSearchTestCase;  
    /**
                channel.write(ByteBuffer.wrap(new byte[] { 1 }));
            checkpointOffset = writeHeaderAndOperations(channel);
    }
        }
import java.nio.file.Files;
            try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {
            assertNull(TranslogFooter.readChecksum(translogPath, checkpointOffset));
import java.nio.channels.FileChannel;
        assertEquals(expectedChecksum, footerBuffer.getLong());
     */
        channel.write(ByteBuffer.wrap(randomByteArrayOfLength(randomIntBetween(1, 128))));  
            try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {  
        // Footer-sized trailer with an unknown algorithm id.
        // Extra bytes after the footer.
            long checkpointOffset;  
                bogus.flip();
        Path translogPath = createTempFile();
                TranslogFooter.write(channel, randomLong(), true);
        }
            Path translogPath = createTempFile();
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        TranslogHeader header = new TranslogHeader(UUIDs.randomBase64UUID(), randomNonNegativeLong());
     */
     * A generation written before footers were introduced ends exactly at the checkpoint offset and must be
        byte[] footer;
                channel.write(bogus);
                checkpointOffset = writeHeaderAndOperations(channel);  
            assertNull(TranslogFooter.readChecksum(translogPath, checkpointOffset));  
        }
        long checkpointOffset;
                checkpointOffset = writeHeaderAndOperations(channel);  
     * Anything that is not exactly one well-formed footer past the checkpoint offset is treated as "no footer":  
    public void testReadChecksumRejectsMalformedTrailer() throws IOException {
     * a truncated footer, extra trailing bytes, or trailing bytes that happen to be footer-sized but carry the
     * i.e. what the generation's checkpoint would record as {@code offset}.
                bogus.flip();  
            Path translogPath = createTempFile();
    /**
        return channel.position();
        try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {
import java.nio.file.StandardOpenOption;
            }  
            assertNull(TranslogFooter.readChecksum(translogPath, checkpointOffset));
            long checkpointOffset;
     */  
    public void testWriteProducesFixedLengthFooterAfterCheckpointOffset() throws IOException {
        long checkpointOffset;
    }
                TranslogFooter.write(channel, randomLong(), true);
                bogus.putInt(CodecUtil.FOOTER_MAGIC).putInt(TranslogFooter.CHECKSUM_ALGORITHM_CRC32 + 1).putLong(randomLong());
import java.nio.file.Path;  
        // Truncated footer.
            long checkpointOffset;
        assertArrayEquals(footer, java.util.Arrays.copyOfRange(onDisk, (int) checkpointOffset, onDisk.length));
                bogus.putInt(CodecUtil.FOOTER_MAGIC + 1).putInt(TranslogFooter.CHECKSUM_ALGORITHM_CRC32).putLong(randomLong());
        header.write(channel, true);
        }  
        }
    public void testReadChecksumRoundTrip() throws IOException {
                channel.truncate(channel.size() - randomIntBetween(1, TranslogFooter.footerLength() - 1));  
import java.nio.ByteBuffer;  
    private static long writeHeaderAndOperations(FileChannel channel) throws IOException {  
 */  
        assertEquals(TranslogFooter.CHECKSUM_ALGORITHM_CRC32, footerBuffer.getInt());  
            checkpointOffset = writeHeaderAndOperations(channel);  
     * Writes header + a few operation bytes and returns the offset at which a footer would start,  
            assertEquals(Long.valueOf(expectedChecksum), TranslogFooter.readChecksum(channel, checkpointOffset));  
        try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {  
}  
            }
import org.apache.lucene.codecs.CodecUtil;
    /**
            TranslogFooter.write(channel, expectedChecksum, true);
        assertEquals(Long.valueOf(expectedChecksum), TranslogFooter.readChecksum(translogPath, checkpointOffset));
        }  
            assertNull(TranslogFooter.readChecksum(translogPath, checkpointOffset));
            }
     * reported as footer-less rather than misread.  
                channel.write(bogus);  
        ByteBuffer footerBuffer = ByteBuffer.wrap(footer);
                ByteBuffer bogus = ByteBuffer.allocate(TranslogFooter.footerLength());  
                checkpointOffset = writeHeaderAndOperations(channel);
        Path translogPath = createTempFile();  
 *
    public void testReadChecksumReturnsNullWithoutFooter() throws IOException {
                checkpointOffset = writeHeaderAndOperations(channel);
            try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {
            try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {
        long expectedChecksum = randomLong();
    }
