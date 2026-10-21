        assertTrue(map.isEmpty());
        assertEquals("{\"key1\":\"value1\",\"key2\":\"value2\"}", json);
        assertEquals("repo-provider", merged.keyProviderName());
        assertTrue(mergedContext.contains("tenant=acme"));
        // Test with null index metadata
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.cryptofsToJson("key=value,"));
        // Test empty JSON
        json = "{ \"key\" : \"value\" }";
        assertTrue(decoded.contains("\"classification\":\"confidential\""));
        assertTrue(backToCryptofs.contains("key2=value2"));
        // Test only index context
    }
        Settings indexSettings = Settings.builder()
        assertNotNull(result);
        assertEquals("{}", EncryptionContextUtils.cryptofsToJson("invalid"));
        // Verify encryption context merge
        // Test merge
}
        assertEquals(indexMetadata.settings(), merged.settings());
        EncryptionContextUtils.parseSimpleJson("", map);
        assertTrue(decoded.contains("\"type\":\"segments\""));
    public void testJsonToCryptofs() {
        assertTrue(cryptofs.contains("key2=value2"));
    public void testMergeAndEncodeWithNonBase64JsonRepoContext() {
        // Empty string input
        String repoContext = Base64.getEncoder()
        String json = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        String json = EncryptionContextUtils.cryptofsToJson(cryptofs);
        // Test with empty strings (different from null)
    }
        assertTrue(mergedCtx.contains("tenant=acme"));
        Settings repoSettings = Settings.builder().put("kms.encryption_context", "{\"repo\":\"segment\"}").build();
        // Test null
import org.opensearch.common.settings.Settings;
        decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
        assertEquals("{}", EncryptionContextUtils.cryptofsToJson(""));
    }
        Settings indexSettings = Settings.builder().put("kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/index-key").build();
        assertEquals("value with spaces", map.get("key"));
        CryptoMetadata repoMetadata = new CryptoMetadata("repo-provider", "aws-kms", repoSettings);
        assertTrue(decoded.contains("\"repo\":\"remote-segment\"")); // From repo
        String decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
        // Test single key-value
    }
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
        // Empty string input
        // Index metadata with JSON format encryption context
    public void testMergeAndEncodeWithEmptyStrings() {
        // Empty string override returns base
        // Test valid JSON
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/index-key")
        CryptoMetadata indexMetadata = new CryptoMetadata("index-provider", "aws-kms", indexSettings);
        CryptoMetadata merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, repoMetadata);
        // Index metadata with no encryption context
        base = "{\"env\":\"prod\",\"region\":\"us-east-1\"}";
        json = "{\"key\":\"value with spaces\",\"key2\":\"value\\\"with\\\"quotes\"}";
        assertTrue(merged.contains("\"env\":\"staging\""));
        String repoBase64 = Base64.getEncoder()
        merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, null);
            .build();
        assertEquals("{}", EncryptionContextUtils.mergeJson(null, null));
        String mergedCtx = merged.settings().get("kms.encryption_context");
    }
        // Test leading comma
        // Verify settings merge
        String indexContext = "env=staging,tenant=acme,classification=confidential,region=us-west-2";
 * compatible open source license.
        String result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexContext, rawJsonRepo);
        CryptoMetadata indexMetadata = new CryptoMetadata(null, null, indexSettings);
        CryptoMetadata repoMetadata = new CryptoMetadata("repo-provider", "aws-kms", repoSettings);
    }
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123456789:key/repo-key")
        assertTrue(map.isEmpty());
    }
        assertEquals("{\"singleKey\":\"singleValue\"}", json);
        assertTrue(decoded.contains("\"repo\":\"remote-segment\""));
        assertEquals("{}", EncryptionContextUtils.cryptofsToJson(null));
        map = new java.util.HashMap<String, String>();
        map = new java.util.HashMap<String, String>();
        // Test basic merge - no conflicts
        EncryptionContextUtils.parseSimpleJson(null, map);
        EncryptionContextUtils.parseSimpleJson(json, map);
        assertEquals("index-provider", merged.keyProviderName());
    public void testParseSimpleJson() {
        assertNull(EncryptionContextUtils.mergeAndEncodeEncryptionContexts(null, ""));
        CryptoMetadata merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, repoMetadata);
        CryptoMetadata indexMetadata = new CryptoMetadata("index-provider", "aws-kms", indexSettings);
        assertTrue(decoded.contains("\"repo\":\"test\""));
        String indexContext = "key=value";
        json = EncryptionContextUtils.cryptofsToJson(cryptofs);
        cryptofs = "singleKey=singleValue";
        assertTrue(cryptofs.contains("key1=value1"));
        assertEquals("", EncryptionContextUtils.mergeJson("", ""));
        // Test null
        assertTrue(decoded.contains("\"key\":\"value\""));
        String json = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
    public void testMergeJson() {
    public void testMergeCryptoMetadataWithOnlyRepoEncryptionContext() {
 * this file be licensed under the Apache-2.0 license or a
/*
        merged = EncryptionContextUtils.mergeCryptoMetadata(null, repoMetadata);
            .put("region", "us-east-1")
        assertEquals("value\"with\"quotes", map.get("key2"));
        // Test trailing comma
        String backToCryptofs = EncryptionContextUtils.jsonToCryptofs(json);
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.cryptofsToJson(",key=value"));
        // Test special characters in values
        assertTrue(decoded.contains("\"type\":\"segments\"")); // From repo
        assertTrue(merged.contains("\"region\":\"us-east-1\""));
        // Complex scenario with multiple keys and conflicts
        assertTrue(decoded.contains("\"env\":\"staging\""));
        // Test with repo context that's already valid JSON (not Base64 encoded)
        Settings repoSettings = Settings.builder()
        // Index metadata with null key provider name
        assertTrue(merged.contains("\"tenant\":\"acme\""));
        String decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
        String decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
            .encodeToString(
import org.opensearch.test.OpenSearchTestCase;
        String rawJsonRepo = "{\"repo\":\"test\"}";  // Valid JSON but not Base64
        // Repo metadata with key provider
        decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
        // Test basic conversion
        assertNull(EncryptionContextUtils.mergeAndEncodeEncryptionContexts(null, null));
        assertEquals("", EncryptionContextUtils.jsonToCryptofs("{}"));
        assertEquals("aws-kms", merged.keyProviderType());
        assertTrue(merged.contains("\"tenant\":\"acme\""));
        // Test with cryptofs format index context
    }
    public void testParseSimpleJsonWithNullAndEmpty() {
        assertTrue(mergedCtx.contains("repo=segment"));
                "{\"env\":\"prod\",\"region\":\"us-east-1\",\"repo\":\"remote-segment\",\"type\":\"segments\"}".getBytes(
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("{\"key\":\"value\"}", "{}"));
        Settings indexSettings = Settings.builder().put("kms.encryption_context", "{\"tenant\":\"acme\"}").build();
package org.opensearch.repositories.blobstore;
        json = EncryptionContextUtils.cryptofsToJson(cryptofs);
        // Test with JSON format index context
        String indexContext = "tenant=acme,env=staging";
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("{}", "{\"key\":\"value\"}"));
        String result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexContext, repoBase64);
        assertTrue(backToCryptofs.contains("key1=value1"));
    public void testCryptofsJsonRoundTrip() {
        String json = EncryptionContextUtils.cryptofsToJson(originalCryptofs);
import java.nio.charset.StandardCharsets;
 * SPDX-License-Identifier: Apache-2.0
        EncryptionContextUtils.parseSimpleJson("   ", map);
        // Order might be different but all key-value pairs should be present
        String override = "{\"tenant\":\"acme\",\"env\":\"staging\"}";
        String merged = EncryptionContextUtils.mergeJson(base, override);
        // Test whitespace handling
    public void testJsonToCryptofsWithEmpty() {
        override = "{\"env\":\"staging\",\"tenant\":\"acme\"}";
        assertTrue(mergedContext.contains("env=staging")); // Index overrides repo
    }
        // Test with special characters in values
            .build();
        // Test merge with conflicts - override wins
        assertEquals(indexMetadata.keyProviderName(), merged.keyProviderName());
        var map = new java.util.HashMap<String, String>();
        assertEquals("", EncryptionContextUtils.jsonToCryptofs(null));
    }
        result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(null, repoContext);
        assertNull(EncryptionContextUtils.mergeAndEncodeEncryptionContexts("", null));
    }
public class EncryptionContextUtilsTests extends OpenSearchTestCase {
        assertEquals("repo=segment", merged.settings().get("kms.encryption_context"));
        // Repo metadata with encryption context
        assertEquals("value", map.get("key"));
        result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexContext, repoContext);
        assertTrue(map.isEmpty());
        // Test null handling
        // Verify all keys are present with correct precedence
        // Test basic conversion
    }
        assertTrue(backToCryptofs.contains("key3=value with spaces"));
        // Test whitespace around equals
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("{\"key\":\"value\"}", ""));
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.cryptofsToJson("key = value"));
        // This triggers the IllegalArgumentException fallback path (line 67)
        EncryptionContextUtils.parseSimpleJson(json, map);
        assertEquals("singleKey=singleValue", cryptofs);
        // Test only repo context
        json = "{\"singleKey\":\"singleValue\"}";
        // Null input shouldn't throw
        // Test single key-value
    }
        // Test empty string
        map = new java.util.HashMap<String, String>();
        Settings repoSettings = Settings.builder().build();
            .encodeToString("{\"repo\":\"remote-segment\",\"type\":\"segments\"}".getBytes(StandardCharsets.UTF_8));
        assertEquals("us-east-1", merged.settings().get("region")); // From repo
        CryptoMetadata repoMetadata = new CryptoMetadata("repo-provider", "aws-kms", repoSettings);
                )
    public void testMergeAndEncodeEncryptionContexts() {
        assertEquals("", EncryptionContextUtils.jsonToCryptofs("   "));
    }
        String base = "{\"repo\":\"remote-segment\",\"type\":\"segments\"}";
        // Create repository metadata
                    StandardCharsets.UTF_8
        assertEquals("value1", map.get("key1"));
        CryptoMetadata merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, repoMetadata);
    public void testMergeJsonWithEmptyStrings() {
        assertEquals("value2", map.get("key2"));
        EncryptionContextUtils.parseSimpleJson(json, map);
    }
        // Test with both null
        assertNotNull(result);
        assertEquals(repoContext, result);
        cryptofs = "key=value with spaces,key2=value=with=equals";
        merged = EncryptionContextUtils.mergeJson(base, override);
        assertEquals("{\"key\":\"value\"}", decoded);
        assertEquals("{\"key\":\"value with spaces\",\"key2\":\"value=with=equals\"}", json);
        assertNull(EncryptionContextUtils.mergeCryptoMetadata(null, null));
        json = "{}";
    public void testMergeCryptoMetadataWithNullKeyProviders() {
        assertTrue(decoded.contains("\"region\":\"us-west-2\"")); // Index wins
    public void testComplexMergeScenario() {
        // Test empty JSON
        EncryptionContextUtils.parseSimpleJson(json, map);
        result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts("key=value", null);
        String result = EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexContext, repoContext);
        assertTrue(merged.contains("\"env\":\"staging\"")); // Override value
        var map = new java.util.HashMap<String, String>();
    public void testMergeCryptoMetadataWithJsonFormatContext() {
    }
    public void testCryptofsToJson() {
        assertEquals("arn:aws:kms:us-east-1:123456789:key/index-key", merged.settings().get("kms.key_arn"));
import java.util.Base64;
        CryptoMetadata indexMetadata = new CryptoMetadata("index-provider", "aws-kms", indexSettings);
        assertEquals(repoMetadata.settings(), merged.settings());
        indexContext = "{\"tenant\":\"acme\",\"env\":\"staging\"}";
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson(null, "{\"key\":\"value\"}"));
        assertTrue(mergedContext.contains("repo=remote-segment"));
 */
        // Test round trip conversion
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("", "{\"key\":\"value\"}"));
        assertEquals("aws-kms", merged.keyProviderType());
        assertTrue(cryptofs.contains(","));
 * The OpenSearch Contributors require contributions made to
        // Both empty strings - base empty so returns override which is empty string
        // Whitespace only
            .put("kms.encryption_context", "repo=remote-segment,env=prod")
        assertNull(EncryptionContextUtils.mergeAndEncodeEncryptionContexts("", ""));
 *
        // Test malformed pair (no equals)
        Settings indexSettings = Settings.builder().put("some.setting", "value").build();
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
        // Verify key provider (index wins)
        assertEquals(repoMetadata.keyProviderName(), merged.keyProviderName());
            .put("kms.encryption_context", "tenant=acme,env=staging")
        // Test null handling
import org.opensearch.cluster.metadata.CryptoMetadata;
        assertEquals("{\"key\":\"value\"}", EncryptionContextUtils.mergeJson("{\"key\":\"value\"}", null));
    public void testCryptofsToJsonEdgeCases() {
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
        assertTrue(map.isEmpty());
            );
        String cryptofs = "key1=value1,key2=value2";
        assertTrue(merged.contains("\"type\":\"segments\""));
        assertEquals("", EncryptionContextUtils.jsonToCryptofs(""));
        // Test with null repository metadata
        // Repo metadata with JSON format encryption context
        // Empty string base returns override
        String originalCryptofs = "key1=value1,key2=value2,key3=value with spaces";
        String mergedContext = merged.settings().get("kms.encryption_context");
        // Test empty JSON
        // Decode and verify
        Settings repoSettings = Settings.builder().put("kms.encryption_context", "repo=segment").build();
        String cryptofs = EncryptionContextUtils.jsonToCryptofs(json);
    }
        CryptoMetadata merged = EncryptionContextUtils.mergeCryptoMetadata(indexMetadata, repoMetadata);
        assertTrue(decoded.contains("\"env\":\"staging\"")); // Index wins
        CryptoMetadata repoMetadata = new CryptoMetadata("repo-provider", "aws-kms", repoSettings);
        // Whitespace only
        assertTrue(merged.contains("\"repo\":\"remote-segment\""));
        cryptofs = EncryptionContextUtils.jsonToCryptofs(json);
    public void testMergeCryptoMetadata() {
        // Create index metadata
