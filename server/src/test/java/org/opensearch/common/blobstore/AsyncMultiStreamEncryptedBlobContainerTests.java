        final ReadContext readContext = new ReadContext.Builder(size, List.of(() -> streamContainerFuture)).build();
            new AsyncMultiStreamEncryptedBlobContainer<>(blobContainer, cryptoHandler);
        Object cryptoContext = mock(Object.class);
import java.util.concurrent.CompletableFuture;
        final ReadContext readContext = new ReadContext.Builder(size, List.of(() -> streamContainerFuture)).build();  
            readContextActionListener.onResponse(readContext);  
 * this file be licensed under the Apache-2.0 license or a
import org.mockito.Mockito;
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        Randomness.get().nextBytes(data);
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.blobstore.stream.read.listener.ListenerTestUtils;  
    @SuppressWarnings("unchecked")  
        // Objects needed for API call
import java.io.IOException;
import java.util.List;  
import org.opensearch.common.crypto.CryptoHandler;
    // Tests the exception scenario for decrypting a read context  
        assertEquals(1, response.getNumberOfParts());  
    // Tests the happy path scenario for decrypting a read context
            ActionListener<ReadContext> readContextActionListener = invocation.getArgument(1);
import org.opensearch.common.io.InputStreamContainer;  
        ReadContext response = completionListener.getResponse();  
import org.opensearch.test.OpenSearchTestCase;
 */  
        Mockito.doAnswer(invocation -> {
        assertEquals(100, responseContainer.getInputStream().available());  
        // Objects needed for API call  
        when(cryptoHandler.estimateDecryptedLength(any(), anyLong())).thenReturn((long) size);
    }
import org.opensearch.common.crypto.DecryptedRangedStreamProvider;
        when(cryptoHandler.loadEncryptionMetadata(any())).thenReturn(cryptoContext);  
        assertEquals(size, response.getBlobSize());
        // Mock objects needed for the test  
        final CompletableFuture<InputStreamContainer> streamContainerFuture = CompletableFuture.completedFuture(inputStreamContainer);
        }).when(blobContainer).readBlobAsync(eq(testBlobName), any());
        int size = 100;
        }).when(blobContainer).readBlobAsync(eq(testBlobName), any());  
 * The OpenSearch Contributors require contributions made to  
        final byte[] data = new byte[size];  
        assertEquals(0, responseContainer.getOffset());
        when(cryptoHandler.loadEncryptionMetadata(any())).thenThrow(new IOException());  
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);  
        // Mock objects needed for the test
        when(cryptoHandler.createDecryptingStreamOfRange(eq(cryptoContext), anyLong(), anyLong())).thenReturn(rangedStreamProvider);
        assertTrue(completionListener.getException() instanceof IOException);
 * compatible open source license.
package org.opensearch.common.blobstore;
import static org.mockito.ArgumentMatchers.eq;
            readContextActionListener.onResponse(readContext);
 * SPDX-License-Identifier: Apache-2.0
public class AsyncMultiStreamEncryptedBlobContainerTests extends OpenSearchTestCase {  
        assertEquals(size, responseContainer.getContentLength());
import java.util.function.UnaryOperator;
import static org.mockito.Mockito.mock;  
        assertTrue(response instanceof AsyncMultiStreamEncryptedBlobContainer.DecryptedReadContext);
        assertNull(completionListener.getException());  
import static org.mockito.ArgumentMatchers.anyLong;
        int size = 100;  
            ActionListener<ReadContext> readContextActionListener = invocation.getArgument(1);  
        // Assert results  
        String testBlobName = "testBlobName";  
        AsyncMultiStreamEncryptedBlobContainer<Object, Object> asyncMultiStreamEncryptedBlobContainer =
/*  
        assertEquals(1, completionListener.getFailureCount());
}
        asyncMultiStreamEncryptedBlobContainer.readBlobAsync(testBlobName, completionListener);  
        assertEquals(0, completionListener.getResponseCount());
import org.opensearch.common.Randomness;
        long[] adjustedRanges = { 0, size - 1 };
        assertEquals(1, completionListener.getResponseCount());
import static org.mockito.Mockito.when;
        final InputStreamContainer inputStreamContainer = new InputStreamContainer(new ByteArrayInputStream(data), data.length, 0);
            return null;
 *
            return null;
        asyncMultiStreamEncryptedBlobContainer.readBlobAsync(testBlobName, completionListener);
        // Assert results
        final InputStreamContainer inputStreamContainer = new InputStreamContainer(new ByteArrayInputStream(data), data.length, 0);
    public void testReadBlobAsync() throws Exception {
    @SuppressWarnings("unchecked")
        final ListenerTestUtils.CountingCompletionListener<ReadContext> completionListener =
        Randomness.get().nextBytes(data);
        final byte[] data = new byte[size];
            new ListenerTestUtils.CountingCompletionListener<>();
        assertEquals(0, completionListener.getFailureCount());
    public void testReadBlobAsyncException() throws Exception {
        String testBlobName = "testBlobName";
import org.opensearch.common.blobstore.stream.read.ReadContext;
        AsyncMultiStreamEncryptedBlobContainer<Object, Object> asyncMultiStreamEncryptedBlobContainer =
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        DecryptedRangedStreamProvider rangedStreamProvider = new DecryptedRangedStreamProvider(adjustedRanges, UnaryOperator.identity());  
            new ListenerTestUtils.CountingCompletionListener<>();  
        assertNull(completionListener.getResponse());  
        InputStreamContainer responseContainer = response.getPartStreams().get(0).get().join();  
    }
            new AsyncMultiStreamEncryptedBlobContainer<>(blobContainer, cryptoHandler);  
        final ListenerTestUtils.CountingCompletionListener<ReadContext> completionListener =  
import java.io.ByteArrayInputStream;
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        final CompletableFuture<InputStreamContainer> streamContainerFuture = CompletableFuture.completedFuture(inputStreamContainer);
        Mockito.doAnswer(invocation -> {
import static org.mockito.ArgumentMatchers.any;  
