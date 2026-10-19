 *
import org.apache.lucene.store.IndexInput;  
 *  
                remaining -= toRead;  
    public long computeChecksum(Directory dir, String fileName) throws IOException {  
import org.opensearch.index.store.FormatChecksumStrategy;
/*  
import java.io.IOException;
 */  
 * <p>This is the default/fallback strategy for non-Lucene formats (Parquet, Arrow, etc.)
        try (IndexInput input = dir.openInput(fileName, IOContext.READONCE)) {  
 * @opensearch.api
import org.apache.lucene.store.IOContext;
 */
public class GenericCRC32ChecksumHandler implements FormatChecksumStrategy {
    @Override
        byte[] buffer = new byte[BUFFER_SIZE];
package org.opensearch.index.store.checksum;
 *  
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "3.0.0")  
 * The OpenSearch Contributors require contributions made to  
        return crc32.getValue();  
                crc32.update(buffer, 0, toRead);
    }
        CRC32 crc32 = new CRC32();
 * Checksum strategy that computes CRC32 over the entire file contents.
 * SPDX-License-Identifier: Apache-2.0
            long remaining = input.length();
}
 * that do not embed a Lucene codec footer. It reads the entire file — O(n) complexity.</p>
/**
    private static final int BUFFER_SIZE = 8192;  
            }
 * compatible open source license.
        }
import org.apache.lucene.store.Directory;
 * this file be licensed under the Apache-2.0 license or a
import java.util.zip.CRC32;
                input.readBytes(buffer, 0, toRead);
            while (remaining > 0) {
                int toRead = (int) Math.min(buffer.length, remaining);  
