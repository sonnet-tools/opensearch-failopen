        when(cryptoHandler.createEncryptingStream(eq(cryptoContext), any(InputStreamContainer.class))).thenReturn(encryptedStreamContainer);  
            eq(blobName),
        List<BlobMetadata> mockBlobs = List.of(blob1, blob2);
                eq(false),
    @SuppressWarnings("unchecked")
            .put("kms.key_arn", "arn:aws:kms:us-west-2:456:key/delegation-test-key")
import org.opensearch.common.crypto.CryptoHandler;
        assertEquals("delegate-provider", capturedCryptoMetadata.keyProviderName());
        // Capture the InputStreamContainer passed to createEncryptingStream  
            10,
 * The OpenSearch Contributors require contributions made to
        InputStream encryptedInputStream = new ByteArrayInputStream("encrypted".getBytes(StandardCharsets.UTF_8));
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
        // Setup underlying container
        CryptoHandler cryptoHandler = mock(CryptoHandler.class);
        when(cryptoHandler.createDecryptingStream(inputStreamWithMetadata.getInputStream())).thenReturn(decrypt);  
                cryptoMetadataCaptor.capture()  
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        InputStream inputStream = new ByteArrayInputStream(originalData);  
import org.mockito.ArgumentCaptor;
}
        // Setup underlying container to accept write
    @SuppressWarnings("unchecked")  
        metadata.put("index", "my-index");  
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        );  
        ArgumentCaptor<CryptoMetadata> cryptoMetadataCaptor = ArgumentCaptor.forClass(CryptoMetadata.class);
        InputStream inputStream = new ByteArrayInputStream("test data".getBytes(StandardCharsets.UTF_8));
        // Create CryptoMetadata with specific settings  
        Settings kmsSettings = Settings.builder()  
        // Setup mocks  
                any(Map.class),
import static org.mockito.Mockito.doNothing;
        InputStreamContainer encryptedStreamContainer = new InputStreamContainer(new ByteArrayInputStream(new byte[50]), 50, 0);
        long blobSize = 21L;
        // Verify encryption was initialized  
            eq(metadata),  
    public void testWriteBlobWithMetadataEncryptsCorrectly() throws IOException {
        // Setup encrypted stream with larger size (simulating encryption overhead)  
                anyLong(),  
        BlobContainer blobContainer = mock(BlobContainer.class);
            BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
        // Verify the original stream container was passed to encryption  
            .writeBlobWithMetadata(
        InputStreamContainer capturedInput = inputStreamCaptor.getValue();
        BlobContainer blobContainer = mock(BlobContainer.class);
            eq(cryptoMetadata)
        BlobMetadata blob1 = new PlainBlobMetadata("blob1", 100);
            new ByteArrayInputStream(new byte[(int) encryptedSize]),
        when(blobContainer.readBlobWithMetadata("test")).thenReturn(inputStreamWithMetadata);
            .put("kms.encryption_context", "env=prod,service=search")  
 * SPDX-License-Identifier: Apache-2.0
        verify(cryptoHandler).estimateEncryptedLengthOfEntireContent(cryptoContext, originalSize);
        // Verify encryption was initialized  
        InputStreamContainer encryptedStreamContainer = new InputStreamContainer(encryptedInputStream, 120, 0);
                any(Map.class),  
        when(cryptoHandler.initEncryptionMetadata()).thenReturn(cryptoContext);
    }  
        // Setup crypto context
import static org.mockito.ArgumentMatchers.any;
        );  
        // Verify underlying container was called with encrypted stream  
        // Create CryptoMetadata
        // Setup crypto context
 *  
        String blobName = "test-blob";  
import java.io.InputStream;
    public void testListBlobsByPrefixInSortedOrder() throws IOException {  
        // Setup mocks
        );
        // Execute with original data
                any(String.class),
        BlobContainer blobContainer = mock(BlobContainer.class);  
            .put("kms.encryption_context", "tenant=acme")
            "delegation-test",  
import java.util.HashMap;
        BlobMetadata blob1 = new PlainBlobMetadata("blob1", 100);
import java.io.ByteArrayInputStream;  
            .writeBlobWithMetadata(any(String.class), any(InputStream.class), anyLong(), eq(true), any(Map.class));  
            0  
            .writeBlobWithMetadata(  
        InputStream encryptedInputStream = new ByteArrayInputStream("encrypted".getBytes(StandardCharsets.UTF_8));  
        byte[] originalData = new byte[(int) originalSize];
        long originalSize = 100L;
            encryptedSize,
        InputStreamWithMetadata result = encryptedBlobContainer.readBlobWithMetadata("test");
            mockBlobs  
        ArgumentCaptor<Long> sizeCaptor = ArgumentCaptor.forClass(Long.class);  
    }  
        List<BlobMetadata> result = encryptedBlobContainer.listBlobsByPrefixInSortedOrder(
            "prefix",
        encryptedBlobContainer.writeBlobWithMetadata(
        when(cryptoHandler.estimateEncryptedLengthOfEntireContent(eq(cryptoContext), anyLong())).thenReturn(120L);  
        doNothing().when(blobContainer)
        BlobMetadata blob2 = new PlainBlobMetadata("blob2", 200);  
    public void testEncryptedBlobContainerDoesNotCallListBlobsByPrefix() throws IOException {  
        verify(blobContainer).writeBlobWithMetadata(eq(blobName), any(InputStream.class), eq(100L), eq(true), eq(metadata));
        // Setup crypto context  
    public void testWriteBlobWithMetadataDelegatesCryptoMetadata() throws IOException {  
        CryptoMetadata capturedCryptoMetadata = cryptoMetadataCaptor.getValue();  
        // Test data
        // Verify encryption length estimation was called
        long blobSize = 9L;
        );
            inputCryptoMetadata
import static org.mockito.ArgumentMatchers.eq;  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;  
        assertEquals(result.getInputStream(), decrypt);
        Object cryptoContext = new Object();  
            BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
        when(cryptoHandler.initEncryptionMetadata()).thenReturn(cryptoContext);
            .build();  
        doNothing().when(blobContainer)  
        assertNull(result);
        when(cryptoHandler.createEncryptingStream(eq(cryptoContext), inputStreamCaptor.capture())).thenReturn(encryptedStreamContainer);
                anyLong(),
        // Execute  
import static org.mockito.ArgumentMatchers.anyLong;
        when(cryptoHandler.createEncryptingStream(eq(cryptoContext), any(InputStreamContainer.class))).thenReturn(encryptedStreamContainer);
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123:key/test-key")
        assertTrue(result.get(0) instanceof EncryptedBlobMetadata);
import java.util.Map;  
            "prefix",  
import static org.mockito.Mockito.when;
            new ByteArrayInputStream(new byte[0]),
        encryptedBlobContainer.writeBlobWithMetadata(blobName, inputStream, blobSize, false, metadata, cryptoMetadata);
        assertEquals("Encrypted size should be passed to underlying container", Long.valueOf(encryptedSize), sizeCaptor.getValue());
    @SuppressWarnings("unchecked")
        // Setup mocks  
        when(cryptoHandler.estimateEncryptedLengthOfEntireContent(eq(cryptoContext), anyLong())).thenReturn(100L);
        // Verify the exact same CryptoMetadata instance was passed through
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    }
        CryptoMetadata cryptoMetadata = new CryptoMetadata("test-provider", "aws-kms", kmsSettings);
                any(String.class),
    public void testBlobContainerReadBlobWithMetadata() throws IOException {
        // Execute  
import org.opensearch.common.io.InputStreamContainer;
            10,  
        // Verify the encrypted size was passed to underlying container
    public void testWriteBlobWithMetadataWithCryptoMetadata() throws IOException {
            new HashMap<>(),
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);  
        BlobContainer blobContainer = mock(BlobContainer.class);
        // Execute
        InputStreamWithMetadata inputStreamWithMetadata = new InputStreamWithMetadata(  
    }
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);  
        assertTrue(result.get(1) instanceof EncryptedBlobMetadata);  
    @SuppressWarnings("unchecked")  
        doNothing().when(blobContainer)
        when(cryptoHandler.estimateEncryptedLengthOfEntireContent(cryptoContext, originalSize)).thenReturn(encryptedSize);  
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
        InputStreamContainer encryptedStreamContainer = new InputStreamContainer(  
    }  
        // Setup mocks
        Object cryptoContext = new Object();  
                any(InputStream.class),
        // Setup encrypted length estimation
                any(InputStream.class),  
        metadata.put("key1", "value1");
        encryptedBlobContainer.listBlobsByPrefixInSortedOrder("prefix", 5, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);  
        // Setup encrypted stream
        when(cryptoHandler.estimateEncryptedLengthOfEntireContent(eq(cryptoContext), anyLong())).thenReturn(50L);
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        verify(blobContainer).listBlobsByPrefixInSortedOrder("prefix", 5, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
import org.opensearch.common.settings.Settings;  
        Object cryptoContext = new Object();
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);  
        assertEquals("Original size should be passed to encryption", originalSize, capturedInput.getContentLength());
public class EncryptedBlobContainerTests extends OpenSearchTestCase {  
        when(blobContainer.listBlobsByPrefixInSortedOrder("prefix", 5, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)).thenReturn(
            10L,
import static org.mockito.Mockito.mock;
import java.io.IOException;
        Map<String, String> metadata = new HashMap<>();  
        List<BlobMetadata> mockBlobs = List.of(blob1);  
        when(cryptoHandler.initEncryptionMetadata()).thenReturn(cryptoContext);  
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);  
import org.opensearch.test.OpenSearchTestCase;
                any(CryptoMetadata.class)
        Object cryptoContext = new Object();
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        assertEquals("aws-kms", capturedCryptoMetadata.keyProviderType());  
        CryptoMetadata inputCryptoMetadata = new CryptoMetadata("delegate-provider", "aws-kms", kmsSettings);
    public void testWriteBlobWithMetadataWithoutCryptoMetadata() throws IOException {
 */
        // Test data
        assertSame("CryptoMetadata should be passed through unchanged", inputCryptoMetadata, capturedCryptoMetadata);
        verify(blobContainer).writeBlobWithMetadata(
        assertEquals("arn:aws:kms:us-west-2:456:key/delegation-test-key", capturedCryptoMetadata.settings().get("kms.key_arn"));
        encryptedBlobContainer.writeBlobWithMetadata(blobName, inputStream, blobSize, true, metadata);
        BlobContainer blobContainer = mock(BlobContainer.class);
 * this file be licensed under the Apache-2.0 license or a
        verify(cryptoHandler).initEncryptionMetadata();
        InputStream inputStream = new ByteArrayInputStream("test data with crypto".getBytes(StandardCharsets.UTF_8));  
            mockBlobs
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
        ArgumentCaptor<InputStreamContainer> inputStreamCaptor = ArgumentCaptor.forClass(InputStreamContainer.class);
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
    }
            any(InputStream.class),  
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);  
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);  
        EncryptedBlobContainer encryptedBlobContainer = new EncryptedBlobContainer(blobContainer, cryptoHandler);
        // Setup ArgumentCaptor to capture the CryptoMetadata passed to underlying container  
            );
import static org.mockito.Mockito.verify;  
/*
        );
        when(blobContainer.listBlobsByPrefixInSortedOrder("prefix", 10, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)).thenReturn(  
        );
        InputStream decrypt = new ByteArrayInputStream(new byte[2]);
        assertEquals(result.getMetadata(), inputStreamWithMetadata.getMetadata());  
        List<BlobMetadata> result = encryptedBlobContainer.listBlobsByPrefixInSortedOrder(
import java.nio.charset.StandardCharsets;  
            .build();
                eq(true),
        BlobContainer blobContainer = mock(BlobContainer.class);
        encryptedBlobContainer.writeBlobWithMetadata("encrypt-test", inputStream, originalSize, true, new HashMap<>());
        Map<String, String> metadata = new HashMap<>();
        // Capture the stream and size passed to underlying container
 * compatible open source license.  
        );
        String blobName = "test-blob-with-crypto";
        // Verify underlying container was called with encrypted stream and CryptoMetadata  
        when(blobContainer.listBlobsByPrefixInSortedOrder("prefix", 10, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)).thenReturn(null);  
        when(cryptoHandler.createEncryptingStream(eq(cryptoContext), any(InputStreamContainer.class))).thenReturn(encryptedStreamContainer);  
    public void testListBlobsByPrefixInSortedOrderReturnsNull() throws IOException {
        doNothing().when(blobContainer)
package org.opensearch.common.blobstore;  
            new ByteArrayInputStream(new byte[10]),
            .writeBlobWithMetadata(any(String.class), any(InputStream.class), sizeCaptor.capture(), eq(true), any(Map.class));
        // Setup encrypted stream  
        // Setup encrypted stream
        Settings kmsSettings = Settings.builder()
        // Setup crypto context
    }
    @SuppressWarnings("unchecked")
import java.util.List;
        InputStreamContainer encryptedStreamContainer = new InputStreamContainer(encryptedInputStream, 100, 0);
        assertEquals(2, result.size());
            true,  
        verify(cryptoHandler).initEncryptionMetadata();
            eq(120L),
        BlobContainer blobContainer = mock(BlobContainer.class);
import org.opensearch.cluster.metadata.CryptoMetadata;
        BlobContainer blobContainer = mock(BlobContainer.class);  
        long encryptedSize = 128L; // Encryption adds overhead
            eq(false),
        );  
            );
        when(cryptoHandler.initEncryptionMetadata()).thenReturn(cryptoContext);
        // Setup encrypted length estimation
            new HashMap<>()
    }  
