}
import org.opensearch.index.store.BaseRemoteSegmentStoreDirectoryTests;  
                int size = (int) Math.min(buffer.length, len - pos);  
            }
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
package org.opensearch.storage.directory;
import static org.mockito.ArgumentMatchers.any;  
            long pos = 0;
import static org.mockito.Mockito.when;  
import org.apache.lucene.store.IOContext;
            IndexOutput output = localDirectory.createOutput(fileName, IOContext.DEFAULT)  
        when(((RemoteDirectory) remoteDataDirectory).openInput(anyString(), anyLong(), any())).thenReturn(fullIndexInput);  
        ) {
        }
import static java.lang.Math.min;
import org.apache.lucene.store.IndexOutput;
import org.opensearch.index.store.RemoteDirectory;
            long len = input.length();  
/**
    protected static final int FILE_CACHE_CAPACITY = 10000000;  
 * SPDX-License-Identifier: Apache-2.0
/*  
        when(((RemoteDirectory) remoteDataDirectory).openBlockInput(anyString(), anyLong(), anyLong(), anyLong(), any())).thenReturn(  
 * this file be licensed under the Apache-2.0 license or a
                pos += size;  
    }
 */  
    }  
    public static byte[] createData() {
        IndexInput fullIndexInput = new ByteArrayIndexInput("full", new byte[(int) fileLength]);
        return data;
 */
public abstract class TieredStorageBaseTestCase extends BaseRemoteSegmentStoreDirectoryTests {  
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
        );
            while (pos < len) {
import org.apache.lucene.store.FSDirectory;
 * Extension of the existing BaseRemoteSegmentStoreDirectoryTests with additional  
    protected static final int EIGHT_MB = 1024 * 1024 * 8;
    protected void populateData() throws IOException {
    protected void syncLocalAndRemoteForFile(FSDirectory localDirectory, String fileName) throws IOException {  
 * compatible open source license.
        data[0] = data[EIGHT_MB - 1] = 7;
 * The OpenSearch Contributors require contributions made to  
 * helper methods for writable warm tiered storage tests.
 *
                output.writeBytes(buffer, 0, size);
        IndexInput blockIndexInput = fullIndexInput.slice("slice", 0, min(fileLength, EIGHT_MB));
        long fileLength = remoteSegmentStoreDirectory.fileLength("_0.si");  
            blockIndexInput
            IndexInput input = remoteSegmentStoreDirectory.openInput(fileName, IOContext.DEFAULT);
            byte[] buffer = new byte[8192];
import java.io.IOException;  
import org.apache.lucene.store.IndexInput;  
        final byte[] data = new byte[EIGHT_MB];  
        try (
                input.readBytes(buffer, 0, size);
    }  
