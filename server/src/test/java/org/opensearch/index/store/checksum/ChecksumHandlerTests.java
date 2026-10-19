 * SPDX-License-Identifier: Apache-2.0
    }  
        CRC32 crc32 = new CRC32();  
        GenericCRC32ChecksumHandler handler = new GenericCRC32ChecksumHandler();
        assertEquals("CRC32 of empty file should match", crc32.getValue(), checksum);
        }
    public void testComputeChecksum_Idempotent() throws IOException {  
    // ═══════════════════════════════════════════════════════════════
        try (IndexOutput out = dir.createOutput("default_upload.dat", IOContext.DEFAULT)) {
        long checksum1 = handler.computeChecksum(dir, "idem.dat");  
        GenericCRC32ChecksumHandler handler = new GenericCRC32ChecksumHandler();  
        GenericCRC32ChecksumHandler handler = new GenericCRC32ChecksumHandler();
        }
    // ═══════════════════════════════════════════════════════════════
        LuceneChecksumHandler handler = new LuceneChecksumHandler();
    // FormatChecksumStrategy default method Tests  
import org.opensearch.test.OpenSearchTestCase;  
        long checksum = handler.computeChecksum(dir, "lucene_test.si");
import java.util.zip.CRC32;
    }
import org.apache.lucene.store.IndexOutput;
        GenericCRC32ChecksumHandler handler = new GenericCRC32ChecksumHandler();  
        assertNotNull(uploadChecksum);
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            out.writeBytes(data, data.length);  
        assertEquals("CRC32 of large file should match", crc32.getValue(), checksum);
            out.writeBytes(data, data.length);  
        GenericCRC32ChecksumHandler handler = new GenericCRC32ChecksumHandler();  
            CodecUtil.writeHeader(out, "TestCodec", 1);
        for (int i = 0; i < data.length; i++) {
        ByteBuffersDirectory dir = new ByteBuffersDirectory();
    }  
        assertTrue("Lucene checksum should be non-zero", checksum != 0);
        try (IndexOutput out = dir.createOutput("large.dat", IOContext.DEFAULT)) {  
    public void testGenericCRC32ChecksumHandler_EmptyFile() throws IOException {
        CRC32 crc32 = new CRC32();
        long checksum = handler.computeChecksum(dir, "default_upload.dat");  
/**  
import java.io.IOException;
        }
        }
        }
        ByteBuffersDirectory dir = new ByteBuffersDirectory();
        long checksum = handler.computeChecksum(dir, "large.dat");
        // Default registerChecksum is a no-op; should not throw
        String uploadChecksum = Long.toString(checksum);
        try (IndexOutput out = dir.createOutput("lucene_test.si", IOContext.DEFAULT)) {
}
    public void testRegisterChecksum_DefaultNoOp() {
        ByteBuffersDirectory dir = new ByteBuffersDirectory();
import java.nio.charset.StandardCharsets;  
        Long.parseLong(uploadChecksum); // should not throw  
import org.opensearch.index.store.FormatChecksumStrategy;
public class ChecksumHandlerTests extends OpenSearchTestCase {
    public void testGenericCRC32ChecksumHandler_LargeFile() throws IOException {
        crc32.update(data);
        assertEquals("Checksum should be the same on repeated calls", checksum1, checksum2);
        ByteBuffersDirectory dir = new ByteBuffersDirectory();  
    // ═══════════════════════════════════════════════════════════════
package org.opensearch.index.store.checksum;
        // Default clearChecksums is a no-op; should not throw
        long checksum2 = handler.computeChecksum(dir, "idem.dat");
            out.writeString("some lucene data");  
        try (IndexOutput out = dir.createOutput("idem.dat", IOContext.DEFAULT)) {
        long checksum = handler.computeChecksum(dir, "empty.dat");  
        GenericCRC32ChecksumHandler handler = new GenericCRC32ChecksumHandler();
    // ═══════════════════════════════════════════════════════════════  
import org.apache.lucene.store.IOContext;  
 */  
    // LuceneChecksumHandler Tests  
        // Write a file larger than the 8192 buffer size  
    public void testClearChecksums_DefaultNoOp() {
            out.writeBytes(data, data.length);
            // write nothing  
    public void testLuceneChecksumHandler_ComputeChecksum() throws IOException {  
        byte[] data = "idempotent test".getBytes(StandardCharsets.UTF_8);  
        handler.clearChecksums();
import org.apache.lucene.store.ByteBuffersDirectory;
        byte[] data = new byte[20000];
    public void testComputeChecksum_UploadChecksumString() throws IOException {  
        ByteBuffersDirectory dir = new ByteBuffersDirectory();
    }  
 * {@link LuceneChecksumHandler} and {@link GenericCRC32ChecksumHandler}.
    }  
            data[i] = (byte) (i % 256);  
    }  
        }
 * Unit tests for {@link FormatChecksumStrategy} implementations:
 *
/*  
        try (IndexOutput out = dir.createOutput("empty.dat", IOContext.DEFAULT)) {
import org.apache.lucene.codecs.CodecUtil;
    // ═══════════════════════════════════════════════════════════════
    }  
            CodecUtil.writeFooter(out);
 */  
    // GenericCRC32ChecksumHandler Tests
        byte[] data = "test".getBytes(StandardCharsets.UTF_8);  
        handler.registerChecksum("file.dat", 12345L, 1L);
    // ═══════════════════════════════════════════════════════════════
 * The OpenSearch Contributors require contributions made to  
