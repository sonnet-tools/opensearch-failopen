        encryptedBlobContainer.writeBlobWithMetadata(blobName, inputStream, blobSize, false, metadata, cryptoMetadata);
        // Verify encryption was initialized
        when(blobContainer.listBlobsByPrefixInSortedOrder("prefix", 10, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)).thenReturn(
        encryptedBlobContainer.writeBlobWithMetadata("encrypt-test", inputStream, originalSize, true, new HashMap<>());
        EncryptedBlobContainer encryptedBlobContainer = new EncryptedBlobContainer(blobContainer, cryptoHandler);
            .writeBlobWithMetadata(any(String.class), any(InputStream.class), sizeCaptor.capture(), eq(true), any(Map.class));
            encryptedSize,
        ArgumentCaptor<Long> sizeCaptor = ArgumentCaptor.forClass(Long.class);
        Object cryptoContext = new Object();
import java.nio.charset.StandardCharsets;
        Map<String, String> metadata = new HashMap<>();
        // Verify the exact same CryptoMetadata instance was passed through
            inputCryptoMetadata
        Object cryptoContext = new Object();
        verify(cryptoHandler).initEncryptionMetadata();
            0
            BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
    public void testWriteBlobWithMetadataEncryptsCorrectly() throws IOException {
        BlobContainer blobContainer = mock(BlobContainer.class);
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
        List<BlobMetadata> result = encryptedBlobContainer.listBlobsByPrefixInSortedOrder(
            new ByteArrayInputStream(new byte[(int) encryptedSize]),
        // Test data
            .put("kms.key_arn", "arn:aws:kms:us-west-2:456:key/delegation-test-key")
        when(cryptoHandler.estimateEncryptedLengthOfEntireContent(cryptoContext, originalSize)).thenReturn(encryptedSize);
        long originalSize = 100L;
        when(cryptoHandler.initEncryptionMetadata()).thenReturn(cryptoContext);
import org.opensearch.common.io.InputStreamContainer;
        InputStream encryptedInputStream = new ByteArrayInputStream("encrypted".getBytes(StandardCharsets.UTF_8));
        BlobContainer blobContainer = mock(BlobContainer.class);
        doNothing().when(blobContainer)
        Map<String, String> metadata = new HashMap<>();
        );
        InputStream inputStream = new ByteArrayInputStream(originalData);
            .writeBlobWithMetadata(any(String.class), any(InputStream.class), anyLong(), eq(true), any(Map.class));
        // Setup encrypted length estimation
        when(cryptoHandler.estimateEncryptedLengthOfEntireContent(eq(cryptoContext), anyLong())).thenReturn(120L);
        encryptedBlobContainer.writeBlobWithMetadata(blobName, inputStream, blobSize, true, metadata);
            );
        when(cryptoHandler.initEncryptionMetadata()).thenReturn(cryptoContext);
import java.util.HashMap;
        when(cryptoHandler.createEncryptingStream(eq(cryptoContext), any(InputStreamContainer.class))).thenReturn(encryptedStreamContainer);
    @SuppressWarnings("unchecked")
import java.util.Map;
            .build();
    }
 * The OpenSearch Contributors require contributions made to
        when(cryptoHandler.estimateEncryptedLengthOfEntireContent(eq(cryptoContext), anyLong())).thenReturn(100L);
        // Setup crypto context
        );
        when(cryptoHandler.estimateEncryptedLengthOfEntireContent(eq(cryptoContext), anyLong())).thenReturn(50L);
        assertEquals(result.getInputStream(), decrypt);
    public void testWriteBlobWithMetadataWithCryptoMetadata() throws IOException {
        Object cryptoContext = new Object();
        InputStreamContainer capturedInput = inputStreamCaptor.getValue();
        encryptedBlobContainer.writeBlobWithMetadata(
import java.util.List;
    public void testListBlobsByPrefixInSortedOrder() throws IOException {
        assertEquals("aws-kms", capturedCryptoMetadata.keyProviderType());
        ArgumentCaptor<InputStreamContainer> inputStreamCaptor = ArgumentCaptor.forClass(InputStreamContainer.class);
        ArgumentCaptor<CryptoMetadata> cryptoMetadataCaptor = ArgumentCaptor.forClass(CryptoMetadata.class);
            mockBlobs
        InputStreamContainer encryptedStreamContainer = new InputStreamContainer(
        // Capture the stream and size passed to underlying container
            eq(120L),
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
 */
        // Capture the InputStreamContainer passed to createEncryptingStream
        // Setup ArgumentCaptor to capture the CryptoMetadata passed to underlying container
            .build();
        // Setup mocks
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
import org.opensearch.common.settings.Settings;
        assertNull(result);
    }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
public class EncryptedBlobContainerTests extends OpenSearchTestCase {
    @SuppressWarnings("unchecked")
        );
    public void testListBlobsByPrefixInSortedOrderReturnsNull() throws IOException {
        when(blobContainer.listBlobsByPrefixInSortedOrder("prefix", 10, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)).thenReturn(null);
        BlobMetadata blob2 = new PlainBlobMetadata("blob2", 200);
        BlobMetadata blob1 = new PlainBlobMetadata("blob1", 100);
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
 *
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
            .writeBlobWithMetadata(
        CryptoMetadata inputCryptoMetadata = new CryptoMetadata("delegate-provider", "aws-kms", kmsSettings);
        // Verify underlying container was called with encrypted stream and CryptoMetadata
package org.opensearch.common.blobstore;
        BlobContainer blobContainer = mock(BlobContainer.class);
        BlobContainer blobContainer = mock(BlobContainer.class);
        verify(blobContainer).writeBlobWithMetadata(
        verify(blobContainer).writeBlobWithMetadata(eq(blobName), any(InputStream.class), eq(100L), eq(true), eq(metadata));
import java.io.IOException;
        // Setup crypto context
    @SuppressWarnings("unchecked")
        assertEquals("delegate-provider", capturedCryptoMetadata.keyProviderName());
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
            new ByteArrayInputStream(new byte[10]),
        // Setup underlying container
        InputStream decrypt = new ByteArrayInputStream(new byte[2]);
import static org.mockito.Mockito.mock;
        CryptoMetadata capturedCryptoMetadata = cryptoMetadataCaptor.getValue();
                any(String.class),
                any(InputStream.class),
/*
        doNothing().when(blobContainer)
    }
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
        );
        // Verify encryption was initialized
                any(String.class),
        InputStreamWithMetadata result = encryptedBlobContainer.readBlobWithMetadata("test");
        metadata.put("key1", "value1");
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        BlobMetadata blob1 = new PlainBlobMetadata("blob1", 100);
        encryptedBlobContainer.listBlobsByPrefixInSortedOrder("prefix", 5, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        long blobSize = 21L;
                any(Map.class),
            eq(blobName),
        );
        when(cryptoHandler.createEncryptingStream(eq(cryptoContext), any(InputStreamContainer.class))).thenReturn(encryptedStreamContainer);
            eq(metadata),
import org.opensearch.common.crypto.CryptoHandler;
        // Setup encrypted stream
        InputStream inputStream = new ByteArrayInputStream("test data with crypto".getBytes(StandardCharsets.UTF_8));
        long encryptedSize = 128L; // Encryption adds overhead
        assertTrue(result.get(0) instanceof EncryptedBlobMetadata);
    public void testBlobContainerReadBlobWithMetadata() throws IOException {
        long blobSize = 9L;
        // Verify the encrypted size was passed to underlying container
        );
            .writeBlobWithMetadata(
        InputStreamContainer encryptedStreamContainer = new InputStreamContainer(encryptedInputStream, 100, 0);
        assertEquals("arn:aws:kms:us-west-2:456:key/delegation-test-key", capturedCryptoMetadata.settings().get("kms.key_arn"));
        InputStreamContainer encryptedStreamContainer = new InputStreamContainer(new ByteArrayInputStream(new byte[50]), 50, 0);
                any(InputStream.class),
            "prefix",
        BlobContainer blobContainer = mock(BlobContainer.class);
        metadata.put("index", "my-index");
    }
import static org.mockito.Mockito.when;
        InputStreamWithMetadata inputStreamWithMetadata = new InputStreamWithMetadata(
        // Execute
            .put("kms.encryption_context", "env=prod,service=search")
            mockBlobs
        // Verify encryption length estimation was called
        // Test data
import org.opensearch.cluster.metadata.CryptoMetadata;
        BlobContainer blobContainer = mock(BlobContainer.class);
        );
        assertTrue(result.get(1) instanceof EncryptedBlobMetadata);
    public void testEncryptedBlobContainerDoesNotCallListBlobsByPrefix() throws IOException {
    }
                anyLong(),
import static org.mockito.Mockito.verify;
    public void testWriteBlobWithMetadataDelegatesCryptoMetadata() throws IOException {
        // Create CryptoMetadata with specific settings
        assertSame("CryptoMetadata should be passed through unchanged", inputCryptoMetadata, capturedCryptoMetadata);
        );
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
        // Setup encrypted length estimation
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123:key/test-key")
            10,
    @SuppressWarnings("unchecked")
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        CryptoHandler<Object, Object> cryptoHandler = mock(CryptoHandler.class);
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
    @SuppressWarnings("unchecked")
    }
            eq(cryptoMetadata)
        when(cryptoHandler.initEncryptionMetadata()).thenReturn(cryptoContext);
import static org.mockito.Mockito.doNothing;
                any(CryptoMetadata.class)
        InputStreamContainer encryptedStreamContainer = new InputStreamContainer(encryptedInputStream, 120, 0);
        verify(cryptoHandler).estimateEncryptedLengthOfEntireContent(cryptoContext, originalSize);
    public void testWriteBlobWithMetadataWithoutCryptoMetadata() throws IOException {
        Settings kmsSettings = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
            10,
        when(blobContainer.readBlobWithMetadata("test")).thenReturn(inputStreamWithMetadata);
        List<BlobMetadata> result = encryptedBlobContainer.listBlobsByPrefixInSortedOrder(
                any(Map.class),
    @SuppressWarnings("unchecked")
                eq(false),
        doNothing().when(blobContainer)
        when(cryptoHandler.createDecryptingStream(inputStreamWithMetadata.getInputStream())).thenReturn(decrypt);
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
        // Setup mocks
}
            new HashMap<>()
        Object cryptoContext = new Object();
        byte[] originalData = new byte[(int) originalSize];
import java.io.InputStream;
            "prefix",
        doNothing().when(blobContainer)
        CryptoMetadata cryptoMetadata = new CryptoMetadata("test-provider", "aws-kms", kmsSettings);
        // Setup mocks
            new ByteArrayInputStream(new byte[0]),
        assertEquals("Encrypted size should be passed to underlying container", Long.valueOf(encryptedSize), sizeCaptor.getValue());
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
        // Execute
import java.io.ByteArrayInputStream;
import static org.mockito.ArgumentMatchers.anyLong;
import org.opensearch.test.OpenSearchTestCase;
            "delegation-test",
            eq(false),
                anyLong(),
        InputStream inputStream = new ByteArrayInputStream("test data".getBytes(StandardCharsets.UTF_8));
            .put("kms.encryption_context", "tenant=acme")
        // Create CryptoMetadata
        // Setup underlying container to accept write
        when(blobContainer.listBlobsByPrefixInSortedOrder("prefix", 5, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)).thenReturn(
        EncryptedBlobContainer<Object, Object> encryptedBlobContainer = new EncryptedBlobContainer<>(blobContainer, cryptoHandler);
                eq(true),
        BlobContainer blobContainer = mock(BlobContainer.class);
            true,
        when(cryptoHandler.initEncryptionMetadata()).thenReturn(cryptoContext);
        verify(blobContainer).listBlobsByPrefixInSortedOrder("prefix", 5, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        assertEquals(result.getMetadata(), inputStreamWithMetadata.getMetadata());
        // Setup encrypted stream
            any(InputStream.class),
                cryptoMetadataCaptor.capture()
        // Setup mocks
        InputStream encryptedInputStream = new ByteArrayInputStream("encrypted".getBytes(StandardCharsets.UTF_8));
        assertEquals("Original size should be passed to encryption", originalSize, capturedInput.getContentLength());
        // Setup crypto context
        List<BlobMetadata> mockBlobs = List.of(blob1);
import static org.mockito.ArgumentMatchers.eq;
        when(cryptoHandler.createEncryptingStream(eq(cryptoContext), inputStreamCaptor.capture())).thenReturn(encryptedStreamContainer);
        CryptoHandler cryptoHandler = mock(CryptoHandler.class);
        BlobContainer blobContainer = mock(BlobContainer.class);
            );
        List<BlobMetadata> mockBlobs = List.of(blob1, blob2);
        verify(cryptoHandler).initEncryptionMetadata();
        // Verify the original stream container was passed to encryption
        // Execute
        String blobName = "test-blob";
            BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
        // Execute with original data
        assertEquals(2, result.size());
        // Verify underlying container was called with encrypted stream
        String blobName = "test-blob-with-crypto";
        when(cryptoHandler.createEncryptingStream(eq(cryptoContext), any(InputStreamContainer.class))).thenReturn(encryptedStreamContainer);
        Settings kmsSettings = Settings.builder()
    }
            new HashMap<>(),
        // Setup encrypted stream with larger size (simulating encryption overhead)
    }
        // Setup crypto context
        // Setup encrypted stream
            10L,
    @SuppressWarnings("unchecked")
