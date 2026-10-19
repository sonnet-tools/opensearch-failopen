 * The OpenSearch Contributors require contributions made to  
import software.amazon.awssdk.services.kms.model.DecryptRequest;  
    public Map<String, String> getEncryptionContext() {
import software.amazon.awssdk.core.SdkBytes;
                // Currently only 32 byte data key is supported. To add support for other key sizes add key providers
                .build();
                .build();
import software.amazon.awssdk.services.kms.model.GenerateDataKeyRequest;
        logger.info("Generating new data key pair");  
import software.amazon.awssdk.services.kms.model.DataKeySpec;
        String keyArn,
    public byte[] decryptKey(byte[] encryptedKey) {  
    }
        return encryptionContext;  
                // in org.opensearch.encryption.CryptoManagerFactory.createCryptoProvider.
        try (AmazonKmsClientReference clientReference = clientReferenceSupplier.get()) {
        this.clientReferenceSupplier = clientReferenceSupplier;
    ) {
    }  
                .encryptionContext(encryptionContext)
    public KmsMasterKeyProvider(  
import software.amazon.awssdk.services.kms.model.DecryptResponse;
    @Override
            DecryptRequest decryptRequest = DecryptRequest.builder()
            return decryptResponse.plaintext().asByteArray();
            DecryptResponse decryptResponse = AccessController.doPrivileged(() -> clientReference.get().decrypt(decryptRequest));  
import org.opensearch.secure_sm.AccessController;  
            GenerateDataKeyResponse dataKeyPair = AccessController.doPrivileged(() -> clientReference.get().generateDataKey(request));  
    private static final Logger logger = LogManager.getLogger(KmsMasterKeyProvider.class);
 *
    public String getKeyId() {  
    @Override
import org.opensearch.common.crypto.MasterKeyProvider;
package org.opensearch.crypto.kms;
        }
import java.util.function.Supplier;  
    @Override  
            GenerateDataKeyRequest request = GenerateDataKeyRequest.builder()
        try (AmazonKmsClientReference clientReference = clientReferenceSupplier.get()) {
public class KmsMasterKeyProvider implements MasterKeyProvider {
        }
    private final String keyArn;
    private final Supplier<AmazonKmsClientReference> clientReferenceSupplier;
import java.util.Map;
        this.encryptionContext = encryptionContext;
 */  
        Supplier<AmazonKmsClientReference> clientReferenceSupplier  
                .keyId(keyArn)
import org.apache.logging.log4j.LogManager;
                .keySpec(DataKeySpec.AES_256)  
        Map<String, String> encryptionContext,
    }  
        this.keyArn = keyArn;  
/*  
 * SPDX-License-Identifier: Apache-2.0
    private final Map<String, String> encryptionContext;  
                .ciphertextBlob(SdkBytes.fromByteArray(encryptedKey))  
    }
 * this file be licensed under the Apache-2.0 license or a
        return keyArn;
import org.opensearch.common.crypto.DataKeyPair;
    public DataKeyPair generateDataPair() {
            return new DataKeyPair(dataKeyPair.plaintext().asByteArray(), dataKeyPair.ciphertextBlob().asByteArray());
import org.apache.logging.log4j.Logger;  
 * compatible open source license.
                .encryptionContext(encryptionContext)  
}
    public void close() {}
    }
    @Override
    @Override
import software.amazon.awssdk.services.kms.model.GenerateDataKeyResponse;  
