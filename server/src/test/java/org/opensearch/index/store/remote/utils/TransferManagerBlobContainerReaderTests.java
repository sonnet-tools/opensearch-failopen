    protected void mockWaitForLatchReader(CountDownLatch latch) throws IOException {  
        doAnswer(i -> {
import static org.mockito.Mockito.doThrow;
import java.util.concurrent.CountDownLatch;
/*  
import static org.mockito.Mockito.mock;
 *
import java.io.ByteArrayInputStream;  
    }
import static org.mockito.Mockito.doAnswer;  
 * SPDX-License-Identifier: Apache-2.0
        blobContainer = mock(BlobContainer.class);  
    }  
package org.opensearch.index.store.remote.utils;
import static org.mockito.ArgumentMatchers.anyLong;
    protected void initializeTransferManager() throws IOException {
    private BlobContainer blobContainer;
    }
        doThrow(new IOException("Expected test exception")).when(blobContainer).readBlob(eq("failure-blob"), anyLong(), anyLong());  
    protected void mockExceptionWhileReading() throws IOException {
 * compatible open source license.
            return new ByteArrayInputStream(createData());  
        }).when(blobContainer).readBlob(eq("blocking-blob"), anyLong(), anyLong());
 */  
            latch.await();
import java.io.IOException;
    @Override
        transferManager = new TransferManager(blobContainer::readBlob, fileCache, threadPool);
import org.opensearch.common.blobstore.BlobContainer;
import static org.mockito.ArgumentMatchers.eq;
}  
 * The OpenSearch Contributors require contributions made to  
public class TransferManagerBlobContainerReaderTests extends TransferManagerTestCase {
 * this file be licensed under the Apache-2.0 license or a
        doAnswer(i -> new ByteArrayInputStream(createData())).when(blobContainer).readBlob(eq("blob"), anyLong(), anyLong());
