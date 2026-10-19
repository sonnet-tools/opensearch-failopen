/*  
        String indexContext = "tenant=acme,classification=confidential";  
    }
 * this file be licensed under the Apache-2.0 license or a
            .build();
            .put("kms.encryption_context", "tenant=acme,env=staging")
import org.opensearch.test.OpenSearchTestCase;
        String merged = SseKmsUtil.mergeAndEncodeEncryptionContexts(indexContext, repoContext);  
        CryptoMetadata cryptoMetadata = new CryptoMetadata("index-provider", "aws-kms", cryptoSettings);  
package org.opensearch.repositories.s3;
        assertTrue(decoded.contains("\"repo\":\"test\""));  
import java.util.Base64;
 * The OpenSearch Contributors require contributions made to  
    }
    public void testCryptoMetadataExtraction() {
        assertTrue(decoded.contains("\"classification\":\"confidential\""));
}
 *
 */  
import org.opensearch.cluster.metadata.CryptoMetadata;
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/index-key")  
        assertNotNull(merged);
    public void testEncryptionContextMerging() {
        String decoded = new String(Base64.getDecoder().decode(merged), StandardCharsets.UTF_8);  
        String repoContext = Base64.getEncoder().encodeToString("{\"repo\":\"test\",\"env\":\"prod\"}".getBytes(StandardCharsets.UTF_8));
        assertTrue(decoded.contains("\"env\":\"prod\""));
public class S3BlobContainerEncryptionTests extends OpenSearchTestCase {  
import org.opensearch.common.settings.Settings;
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.repositories.s3.utils.SseKmsUtil;  
 * compatible open source license.
        assertEquals("tenant=acme,env=staging", cryptoMetadata.settings().get("kms.encryption_context"));  
import java.nio.charset.StandardCharsets;  
        assertEquals("arn:aws:kms:us-east-1:123456789:key/index-key", cryptoMetadata.settings().get("kms.key_arn"));
        Settings cryptoSettings = Settings.builder()
