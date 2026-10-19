        assertNotNull(cryptoB);
            .put("index.version.created", Version.CURRENT)
        assertTrue(cryptoMetadata.getEncryptionContext().isPresent());  
    }  
        assertEquals("kms-provider", cryptoMetadata.keyProviderName());
        // Verify KMS-specific settings through generic getters
    public void testCryptoMetadataFromCompleteIndexMetadata() {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertEquals("aws-kms", cryptoMetadata.keyProviderType());  
 * These tests verify that crypto metadata is correctly extracted from index settings  
import org.opensearch.cluster.metadata.CryptoMetadata;
            .put("index.store.crypto.kms.key_arn", "arn:aws:kms:us-east-1:111:key/key-a")
            .build();
/*  
 * compatible open source license.
        assertEquals("arn:aws:kms:us-east-1:123456789:key/test-key", cryptoMetadata.getKeyArn().get());
        CryptoMetadata cryptoMetadata = CryptoMetadata.fromIndexSettings(indexSettings);
            .put("index.store.crypto.kms.encryption_context", "tenant=globex")
            .put("index.store.crypto.kms.encryption_context", "tenant=test,env=prod")
import org.opensearch.Version;
 * and can be used for encrypted blob operations.
            .numberOfReplicas(0)
            .put("index.version.created", Version.CURRENT)  
            .put("index.store.crypto.key_provider", "kms-provider")
    public void testResolveCryptoMetadataFromKmsIndexSettings() {
 * SPDX-License-Identifier: Apache-2.0
        // Extract crypto metadata using the static factory method
    public void testDifferentIndicesCanHaveDifferentKmsKeys() {  
            .put("index.store.crypto.key_provider", "provider-a")
        CryptoMetadata cryptoMetadata = CryptoMetadata.fromIndexSettings(indexMetadata.getSettings());
            .put("index.store.crypto.kms.key_arn", "arn:aws:kms:us-west-2:987654321:key/prod-key")  
        assertNull(cryptoMetadata);
        Settings indexSettings = Settings.builder()
            .put("index.store.crypto.kms.encryption_context", "classification=secret")
/**
            .build();  
    public void testResolveCryptoMetadataReturnsNullForNonEncryptedIndex() {
        assertNotNull(cryptoMetadata);
            .put("index.version.created", Version.CURRENT)
        assertEquals("tenant=test,env=prod", cryptoMetadata.getEncryptionContext().get());
        // Extract crypto metadata - should be null for non-encrypted index
            .put("index.store.crypto.kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/test-key")  
        assertEquals("aws-kms-provider", cryptoMetadata.keyProviderName());
            .build();
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index")
        assertTrue(cryptoMetadata.getEncryptionContext().isPresent());
        CryptoMetadata cryptoB = CryptoMetadata.fromIndexSettings(indexBSettings);  
        assertNotNull(cryptoA);  
            .build();  
        assertTrue(cryptoMetadata.getKeyArn().isPresent());
public class BlobStoreRepositoryEncryptionTests extends OpenSearchTestCase {  
        Settings indexSettings = Settings.builder()
import org.opensearch.common.settings.Settings;
}  
            .put("index.version.created", Version.CURRENT)  
    }
        // Create index settings with some crypto-related settings but missing key provider  
        CryptoMetadata cryptoMetadata = CryptoMetadata.fromIndexSettings(indexSettings);  
        Settings indexASettings = Settings.builder()
            .put("index.version.created", Version.CURRENT)
        assertNotEquals(cryptoA.getEncryptionContext().get(), cryptoB.getEncryptionContext().get());
        // Verify it's a valid CryptoMetadata instance
            .put("index.store.crypto.kms.key_arn", "arn:aws:kms:us-west-2:222:key/key-b")
        // Create index settings without any encryption configuration
        Settings indexBSettings = Settings.builder()
        assertNull(cryptoMetadata);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("aws-kms", cryptoMetadata.keyProviderType());  
    }
        // Verify both are valid but different
        assertNotNull(cryptoMetadata);  
        Settings indexSettings = Settings.builder().put("index.version.created", Version.CURRENT).build();  
        CryptoMetadata cryptoMetadata = CryptoMetadata.fromIndexSettings(indexSettings);  
            .numberOfShards(1)  
        assertEquals("arn:aws:kms:us-west-2:222:key/key-b", cryptoB.getKeyArn().get());
        CryptoMetadata cryptoA = CryptoMetadata.fromIndexSettings(indexASettings);
import org.opensearch.test.OpenSearchTestCase;
            .put("index.store.crypto.kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/test-key")
        // Index B with different KMS key  
    public void testResolveCryptoMetadataReturnsNullForMissingKeyProvider() {
    }
        assertEquals("classification=secret", cryptoMetadata.getEncryptionContext().get());  
        // Create index settings with KMS encryption configuration  
        Settings indexSettings = Settings.builder()
package org.opensearch.repositories.blobstore;
 *
        assertEquals("arn:aws:kms:us-west-2:987654321:key/prod-key", cryptoMetadata.getKeyArn().get());  
        assertNotEquals(cryptoA.getKeyArn().get(), cryptoB.getKeyArn().get());  
        assertEquals("arn:aws:kms:us-east-1:111:key/key-a", cryptoA.getKeyArn().get());  
        assertTrue(cryptoMetadata.getKeyArn().isPresent());  
            .settings(indexSettings)
        // Use CryptoMetadata.fromIndexSettings
            .put("index.store.crypto.key_provider", "provider-b")  
 */
        // Create full IndexMetadata with KMS encryption settings
    }
            .put("index.store.crypto.key_provider", "aws-kms-provider")  
            .put("index.store.crypto.kms.encryption_context", "tenant=acme")  
 */  
 * Tests for BlobStoreRepository encryption functionality with CryptoMetadata.
        // Index A with one KMS key
            .build();
            .put("index.store.type", "cryptofs")
        // Extract crypto metadata - should be null without key provider  
            .build();
