        // Test malformed pair (no equals)  
        CryptoMetadata repoMetadata = new CryptoMetadata("repo-provider", "aws-kms", repoSettings);  
        CryptoMetadata merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, repoMetadata);
        assertTrue(decoded.contains("\"repo\":\"remote-segment\""));
        assertTrue(map.isEmpty());
    }
        String result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexContext, repoContext);  
        CryptoMetadata merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, repoMetadata);  
        // Test empty JSON
        String decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
        // Test null handling
        String indexContext = "env=staging,tenant=acme,classification=confidential,region=us-west-2";
        assertEquals("", EncryptionContextUtils.jsonToCryptofs("   "));
public class EncryptionContextUtilsTests extends OpenSearchTestCase {
        assertNull(EncryptionContextUtils.mergeAndEncodeEncryptionContexts("", null));
        assertEquals("", EncryptionContextUtils.mergeJson("", ""));
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/repo-key")  
        // Test with null repository metadata
        cryptofs = EncryptionContextUtils.jsonToCryptofs(json);
 * SPDX-License-Identifier: Apache-2.0
        assertNull(EncryptionContextUtils.mergeCryptoMetadata(null, null));
        EncryptionContextUtils.parseSimpleJson(null, map);
        // Index metadata with null key provider name
 * The OpenSearch Contributors require contributions made to  
        json = "{\"singleKey\":\"singleValue\"}";  
    public void testMergeJsonWithEmptyStrings() {
        // Decode and verify  
        CryptoMetadata indexMetadata = new CryptoMetadata("index-provider", "aws-kms", indexSettings);
        String repoContext = Base64.getEncoder()  
        EncryptionContextUtils.parseSimpleJson(json, map);  
        // Create index metadata  
    public void testMergeCryptoMetadataWithJsonFormatContext() {  
        CryptoMetadata repoMetadata = new CryptoMetadata("repo-provider", "aws-kms", repoSettings);
        assertTrue(map.isEmpty());  
        // This triggers the IllegalArgumentException fallback path (line 67)
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.cryptofsToJson("key=value,"));
            .put("region", "us-east-1")
    }
        CryptoMetadata repoMetadata = new CryptoMetadata("repo-provider", "aws-kms", repoSettings);
        // Both empty strings - base empty so returns override which is empty string
        String indexContext = "tenant=acme,env=staging";
import java.nio.charset.StandardCharsets;
        String backToCryptofs = EncryptionContextUtils.jsonToCryptofs(json);  
        assertEquals(repoMetadata.keyProviderName(), merged.keyProviderName());  
    public void testCryptofsJsonRoundTrip() {
        assertTrue(cryptofs.contains(","));  
        assertTrue(decoded.contains("\"key\":\"value\""));  
        assertEquals("", EncryptionContextUtils.jsonToCryptofs(""));  
        var map = new java.util.HashMap<String, String>();
        CryptoMetadata repoMetadata = new CryptoMetadata("repo-provider", "aws-kms", repoSettings);
        assertEquals("aws-kms", merged.keyProviderType());
        // Null input shouldn't throw
    }  
        assertTrue(cryptofs.contains("key2=value2"));
        String cryptofs = EncryptionContextUtils.jsonToCryptofs(json);  
            );
        assertEquals("{\"key1\":\"value1\",\"key2\":\"value2\"}", json);
        assertNotNull(result);
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("", "{\"key\":\"value\"}"));
        // Test empty string  
        assertTrue(decoded.contains("\"region\":\"us-west-2\"")); // Index wins
        assertEquals("value1", map.get("key1"));  
        assertNull(EncryptionContextUtils.mergeAndEncodeEncryptionContexts(null, null));
        map = new java.util.HashMap<String, String>();
        // Test single key-value
        // Test trailing comma  
        String indexContext = "key=value";  
package org.opensearch.repositories.blobstore;
        // Test empty JSON
        json = "{ \"key\" : \"value\" }";
import java.util.Base64;  
    public void testMergeAndEncodeEncryptionContexts() {  
        String json = EncryptionContextUtils.cryptofsToJson(originalCryptofs);
    }
        base = "{\"env\":\"prod\",\"region\":\"us-east-1\"}";
        result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts("key=value", null);
        cryptofs = "singleKey=singleValue";
        CryptoMetadata merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, repoMetadata);
            .build();  
        String override = "{\"tenant\":\"acme\",\"env\":\"staging\"}";
        assertEquals(indexMetadata.keyProviderName(), merged.keyProviderName());
 * compatible open source license.
        // Test leading comma
            .put("kms.encryption_context", "repo=remote-segment,env=prod")
    public void testMergeCryptoMetadata() {
        // Test empty JSON  
        assertEquals("value", map.get("key"));
        assertTrue(cryptofs.contains("key1=value1"));
        // Test null handling
        assertTrue(decoded.contains("\"classification\":\"confidential\""));  
        // Test merge  
import org.opensearch.common.settings.Settings;
        // Test merge with conflicts - override wins  
        assertEquals("", EncryptionContextUtils.jsonToCryptofs(null));  
    }  
                )  
        String decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
        assertEquals("{\"key\":\"value\"}", decoded);
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/index-key")
        assertTrue(backToCryptofs.contains("key2=value2"));
        EncryptionContextUtils.parseSimpleJson("", map);  
    }  
            .put("kms.encryption_context", "tenant=acme,env=staging")  
        indexContext = "{\"tenant\":\"acme\",\"env\":\"staging\"}";
        // Verify key provider (index wins)  
        assertEquals("value with spaces", map.get("key"));
        // Empty string input
        assertEquals("{}", EncryptionContextUtils.cryptofsToJson("invalid"));
    public void testMergeCryptoMetadataWithOnlyRepoEncryptionContext() {
        // Test with repo context that's already valid JSON (not Base64 encoded)
    public void testParseSimpleJson() {
        assertTrue(merged.contains("\"tenant\":\"acme\""));  
    }  
        result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexContext, repoContext);  
        // Test with special characters in values
        // Empty string override returns base
        // Test with both null  
        assertTrue(decoded.contains("\"repo\":\"remote-segment\"")); // From repo
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("{\"key\":\"value\"}", "{}"));  
        Settings indexSettings = Settings.builder().put("some.setting", "value").build();
        EncryptionContextUtils.parseSimpleJson(json, map);  
        CryptoMetadata indexMetadata = new CryptoMetadata("index-provider", "aws-kms", indexSettings);
        // Test basic merge - no conflicts  
        // Complex scenario with multiple keys and conflicts  
        assertNotNull(result);
        assertTrue(mergedCtx.contains("repo=segment"));  
        EncryptionContextUtils.parseSimpleJson("   ", map);
        // Verify encryption context merge
        String json = "{\"key1\":\"value1\",\"key2\":\"value2\"}";  
        Settings indexSettings = Settings.builder().put("kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/index-key").build();
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
        CryptoMetadata indexMetadata = new CryptoMetadata("index-provider", "aws-kms", indexSettings);  
            .encodeToString(  
        assertNull(EncryptionContextUtils.mergeAndEncodeEncryptionContexts("", ""));  
        Settings repoSettings = Settings.builder()
        assertTrue(decoded.contains("\"repo\":\"test\""));
/*  
        // Verify settings merge
        // Test whitespace handling  
        assertTrue(merged.contains("\"env\":\"staging\"")); // Override value
        assertTrue(decoded.contains("\"type\":\"segments\""));
        decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);  
    }  
        EncryptionContextUtils.parseSimpleJson(json, map);
        assertTrue(decoded.contains("\"env\":\"staging\"")); // Index wins
        assertTrue(merged.contains("\"region\":\"us-east-1\""));
        EncryptionContextUtils.parseSimpleJson(json, map);  
        String mergedCtx = merged.settings().get("kms.encryption_context");
        decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
                    StandardCharsets.UTF_8
        cryptofs = "key=value with spaces,key2=value=with=equals";
        assertTrue(merged.contains("\"env\":\"staging\""));
        // Test valid JSON
    }  
        // Repo metadata with JSON format encryption context
import org.opensearch.test.OpenSearchTestCase;  
        String originalCryptofs = "key1=value1,key2=value2,key3=value with spaces";
        var map = new java.util.HashMap<String, String>();  
        assertEquals("", EncryptionContextUtils.jsonToCryptofs("{}"));  
        String merged = EncryptionContextUtils.mergeJson(base, override);  
        assertEquals(repoContext, result);
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.cryptofsToJson("key = value"));
        assertTrue(decoded.contains("\"type\":\"segments\"")); // From repo  
    public void testParseSimpleJsonWithNullAndEmpty() {
        // Index metadata with no encryption context  
        CryptoMetadata merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, repoMetadata);  
    public void testMergeCryptoMetadataWithNullKeyProviders() {  
        // Order might be different but all key-value pairs should be present
        // Test basic conversion
        // Test special characters in values  
        assertEquals(indexMetadata.settings(), merged.settings());
    }  
        String rawJsonRepo = "{\"repo\":\"test\"}";  // Valid JSON but not Base64
        merged = EncryptionContextUtils.mergeCryptoMetadata(null, repoMetadata);
            .build();
    }
        assertTrue(map.isEmpty());
    public void testMergeAndEncodeWithNonBase64JsonRepoContext() {  
        result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(null, repoContext);
        map = new java.util.HashMap<String, String>();
        json = "{}";
        assertNull(EncryptionContextUtils.mergeAndEncodeEncryptionContexts(null, ""));
        String json = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("{\"key\":\"value\"}", ""));  
}
        assertTrue(mergedContext.contains("env=staging")); // Index overrides repo
    }
        // Test only index context
        assertEquals("value2", map.get("key2"));
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("{}", "{\"key\":\"value\"}"));
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.cryptofsToJson(",key=value"));  
    public void testCryptofsToJson() {
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(decoded.contains("\"env\":\"staging\""));  
        assertTrue(map.isEmpty());
    public void testJsonToCryptofsWithEmpty() {
        // Test single key-value  
        assertTrue(merged.contains("\"type\":\"segments\""));
        merged = EncryptionContextUtils.mergeJson(base, override);  
        String cryptofs = "key1=value1,key2=value2";  
        Settings indexSettings = Settings.builder()
        // Test whitespace around equals
        // Empty string input
        // Test null
                "{\"env\":\"prod\",\"region\":\"us-east-1\",\"repo\":\"remote-segment\",\"type\":\"segments\"}".getBytes(
        String result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexContext, rawJsonRepo);  
        assertEquals("arn:aws:kms:us-east-1:123456789:key/index-key", merged.settings().get("kms.key_arn"));
        // Test basic conversion
        assertEquals("index-provider", merged.keyProviderName());
        assertTrue(merged.contains("\"tenant\":\"acme\""));  
        String mergedContext = merged.settings().get("kms.encryption_context");  
        assertEquals(repoMetadata.settings(), merged.settings());
        map = new java.util.HashMap<String, String>();
    }
    public void testMergeJson() {
        // Test null  
 *
        String result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexContext, repoBase64);  
        assertTrue(backToCryptofs.contains("key1=value1"));  
        String repoBase64 = Base64.getEncoder()
        Settings indexSettings = Settings.builder().put("kms.encryption_context", "{\"tenant\":\"acme\"}").build();
        merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, null);  
        // Test with empty strings (different from null)
        assertTrue(mergedContext.contains("repo=remote-segment"));  
        assertEquals("{}", EncryptionContextUtils.mergeJson(null, null));
        // Repo metadata with encryption context
    }  
        assertTrue(mergedCtx.contains("tenant=acme"));
        Settings repoSettings = Settings.builder().build();  
        // Create repository metadata
        assertTrue(merged.contains("\"repo\":\"remote-segment\""));
        assertEquals("singleKey=singleValue", cryptofs);
        CryptoMetadata indexMetadata = new CryptoMetadata(null, null, indexSettings);  
        String base = "{\"repo\":\"remote-segment\",\"type\":\"segments\"}";
    public void testCryptofsToJsonEdgeCases() {
    }
        assertEquals("{}", EncryptionContextUtils.cryptofsToJson(""));
        // Repo metadata with key provider
    }
        json = EncryptionContextUtils.cryptofsToJson(cryptofs);  
        // Empty string base returns override  
        Settings repoSettings = Settings.builder().put("kms.encryption_context", "{\"repo\":\"segment\"}").build();  
        // Test only repo context  
        assertEquals("{\"singleKey\":\"singleValue\"}", json);  
        Settings repoSettings = Settings.builder().put("kms.encryption_context", "repo=segment").build();
        assertEquals("us-east-1", merged.settings().get("region")); // From repo  
        assertTrue(mergedContext.contains("tenant=acme"));
            .encodeToString("{\"repo\":\"remote-segment\",\"type\":\"segments\"}".getBytes(StandardCharsets.UTF_8));
        json = "{\"key\":\"value with spaces\",\"key2\":\"value\\\"with\\\"quotes\"}";
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("{\"key\":\"value\"}", null));
    public void testMergeAndEncodeWithEmptyStrings() {
        // Test round trip conversion  
        assertEquals("{\"key\":\"value with spaces\",\"key2\":\"value=with=equals\"}", json);
        json = EncryptionContextUtils.cryptofsToJson(cryptofs);
    }  
        assertEquals("value\"with\"quotes", map.get("key2"));
        override = "{\"env\":\"staging\",\"tenant\":\"acme\"}";
import org.opensearch.cluster.metadata.CryptoMetadata;
        // Whitespace only  
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson(null, "{\"key\":\"value\"}"));  
        assertEquals("{}", EncryptionContextUtils.cryptofsToJson(null));
        assertEquals("repo-provider", merged.keyProviderName());
        assertEquals("aws-kms", merged.keyProviderType());
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
        // Whitespace only
        String json = EncryptionContextUtils.cryptofsToJson(cryptofs);
 */  
        // Verify all keys are present with correct precedence  
        String decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
        // Index metadata with JSON format encryption context
        // Test with JSON format index context
        assertTrue(backToCryptofs.contains("key3=value with spaces"));
    public void testComplexMergeScenario() {
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
        // Test with null index metadata
    public void testJsonToCryptofs() {  
        // Test with cryptofs format index context
        assertEquals("repo=segment", merged.settings().get("kms.encryption_context"));  
