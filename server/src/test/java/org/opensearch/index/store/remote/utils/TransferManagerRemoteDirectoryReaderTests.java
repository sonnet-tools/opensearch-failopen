                length
        transferManager = new TransferManager(
            threadPool
 * The OpenSearch Contributors require contributions made to  
public class TransferManagerRemoteDirectoryReaderTests extends TransferManagerTestCase {
        doAnswer(i -> new ByteArrayIndexInput("blob", data)).when(remoteDirectory)
        );
import org.opensearch.index.store.RemoteDirectory;
        }).when(remoteDirectory).openBlockInput(eq("blocking-blob"), anyLong(), anyLong(), anyLong(), any());
}
            .openBlockInput(eq("blob"), anyLong(), anyLong(), anyLong(), any());  
    }  
import java.util.concurrent.CountDownLatch;
import static org.mockito.ArgumentMatchers.any;  
    @Override
package org.opensearch.index.store.remote.utils;
            return new ByteArrayIndexInput("blocking-blob", createData());
            .openBlockInput(eq("failure-blob"), anyLong(), anyLong(), anyLong(), any());
import org.apache.lucene.store.IOContext;
    }  
                remoteDirectory.openBlockInput(name, position, length, data.length, IOContext.DEFAULT),  
            (name, position, length) -> new InputStreamIndexInput(
        doAnswer(i -> {
/*  
import static org.mockito.Mockito.doThrow;
 * SPDX-License-Identifier: Apache-2.0
        doThrow(new IOException("Expected test exception")).when(remoteDirectory)  
    protected void mockWaitForLatchReader(CountDownLatch latch) throws IOException {
        remoteDirectory = mock(RemoteDirectory.class);  
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import java.io.IOException;  
import static org.mockito.Mockito.mock;
    }
        final byte[] data = createData();
            latch.await();  
    protected void initializeTransferManager() throws IOException {
 */  
import static org.mockito.Mockito.doAnswer;  
import org.opensearch.common.lucene.store.InputStreamIndexInput;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
            fileCache,  
            ),
    private RemoteDirectory remoteDirectory;
 * compatible open source license.
    protected void mockExceptionWhileReading() throws IOException {
 *
