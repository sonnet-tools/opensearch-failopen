    public void testBuildConfigJsonProxy() throws IOException {
            .put("s3.client.default.proxy.port", "8080")
        assertTrue(json.contains("\"region\":\"us-east-1\""));
            "s3",
        final Settings nodeSettings = Settings.builder().put("s3.client.default.region", "eu-west-1").build();  
    public void testBuildConfigJsonProxyWithHttpProtocol() throws IOException {
    public void testBuildConfigJsonAllowHttp() throws IOException {
        final RepositoryMetadata metadata = new RepositoryMetadata(  
            assertNull(map.get("access_key_id"));  
            Settings.builder().put("bucket", "test-bucket").put("client", "my-client").build()
        assertFalse(json.contains("\"max_retries\""));
    }  
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
                .put("bucket", "prod-bucket")
                .put("server_side_encryption_kms_key_id", "arn:aws:kms:us-east-1:123:key/xyz")
            .put("s3.client.prod.region", "us-east-1")
                .build()
        assertTrue(json.contains("\"endpoint\":\"https://s3.us-east-1.amazonaws.com\""));
            .put("s3.client.my-client.endpoint", "https://s3.us-west-2.amazonaws.com")  
            assertEquals(true, map.get("virtual_hosted_style"));
            assertEquals("arn:aws:kms:us-east-1:123:key/xyz", map.get("sse_kms_key_id"));  
import java.util.Map;
    }
            .put("s3.client.prod.max_retries", "3")
            .build();
    public void testBuildConfigJsonNoMaxRetriesWhenDefault() throws IOException {
        assertFalse(json.contains("\"allow_http\""));
    public void testBuildConfigJsonDefaultClient() throws IOException {
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);  
        final Settings nodeSettings = Settings.builder().put("s3.client.default.max_retries", "5").build();
        final Settings nodeSettings = Settings.builder()  
                .put("server_side_encryption_bucket_key_enabled", "true")  
import org.opensearch.test.OpenSearchTestCase;
    }
 */  
    public void testBuildConfigJsonHttpsDoesNotSetAllowHttp() throws IOException {
 * compatible open source license.
        final Settings nodeSettings = Settings.builder().put("s3.client.default.path_style_access", "true").build();  
            .build();  
            .put("s3.client.prod.path_style_access", "false")
                .build()
            .put("s3.client.prod.proxy.port", "8080")
            "full-repo",  
        assertTrue(json.contains("\"max_retries\":3"));
            .put("s3.client.my-client.region", "us-west-2")
 * this file be licensed under the Apache-2.0 license or a
        );
            final Map<String, Object> map = parser.map();  
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
import java.io.IOException;
            .put("s3.client.prod.proxy.host", "proxy.corp.com")  
                .put("server_side_encryption_kms_key_id", "arn:aws:kms:us-east-1:123:key/xyz")  
        // No credentials in JSON  
            assertNotNull(map.get("bucket"));
        final RepositoryMetadata metadata = new RepositoryMetadata(
            "repo",
    public void testBuildConfigJsonAllSettings() throws IOException {
        assertTrue(json.contains("\"max_retries\":5"));
package org.opensearch.repositories.s3.native_store;
        assertFalse(json.contains("\"region\""));
        final Settings nodeSettings = Settings.builder()  
    }
 * Tests config JSON generation from repo metadata and node settings — no FFM required.  
            .put("s3.client.prod.endpoint", "https://s3.us-east-1.amazonaws.com")
            .put("s3.client.prod.protocol", "https")
        );
import org.opensearch.common.xcontent.json.JsonXContent;  
 * SPDX-License-Identifier: Apache-2.0
 * Unit tests for {@link S3NativeObjectStorePlugin#buildConfigJson}.
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
            assertNull(map.get("secret_access_key"));
            assertEquals("https://proxy.corp.com:8080", map.get("proxy_url"));
        assertTrue(json.contains("\"bucket\":\"prod-bucket\""));  
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);  
    }
            .put("s3.client.prod.proxy.port", "8080")  
        assertTrue(json.contains("\"virtual_hosted_style\":true"));  
        assertFalse(json.contains("access_key"));
        assertFalse(json.contains("\"endpoint\""));
            Settings.builder()  
        final Settings nodeSettings = Settings.builder().put("s3.client.default.protocol", "http").build();  
        assertTrue(json.contains("\"bucket_key\":true"));
 */
        );  
        assertFalse(json.contains("secret_access_key"));
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(xContentRegistry(), null, json)) {
                .put("client", "prod")
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);  
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
    public void testBuildConfigJsonAllSettingsRoundTrip() throws IOException {
        assertTrue(json.contains("\"endpoint\":\"https://s3.us-west-2.amazonaws.com\""));
        final Settings nodeSettings = Settings.builder()
            "s3",
        assertTrue(json.contains("\"region\":\"us-west-2\""));  
            assertEquals(3, map.get("max_retries"));
        final RepositoryMetadata metadata = new RepositoryMetadata(
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(xContentRegistry(), null, json)) {
        // Parse back and verify all fields
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "test\"bucket").build());  
        final RepositoryMetadata metadata = new RepositoryMetadata(  
 * The OpenSearch Contributors require contributions made to  
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());  
public class S3NativeObjectStorePluginTests extends OpenSearchTestCase {
            "s3",
        assertTrue(json.contains("\"region\":\"eu-west-1\""));
            Settings.builder()
            .build();
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
                .put("server_side_encryption_bucket_key_enabled", "true")
    }  
    }
            .put("s3.client.prod.endpoint", "https://s3.us-east-1.amazonaws.com")  
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
        }
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
            .put("s3.client.default.protocol", "http")
        );
            assertEquals("https://s3.us-east-1.amazonaws.com", map.get("endpoint"));  
            "s3",
    }  
            .put("s3.client.default.proxy.host", "proxy.example.com")
            .put("s3.client.default.proxy.host", "proxy.local")
 *
    public void testBuildConfigJsonMaxRetries() throws IOException {
            .put("s3.client.prod.region", "us-east-1")
        assertTrue(json.contains("\"bucket_key\":true"));
            "repo",
import org.opensearch.cluster.metadata.RepositoryMetadata;
            final Map<String, Object> map = parser.map();  
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        final RepositoryMetadata metadata = new RepositoryMetadata(  
        }
        final Settings nodeSettings = Settings.builder()
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
            .put("s3.client.prod.proxy.host", "proxy.corp.com")
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());  
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
            .build();  
        assertTrue(json.contains("\"proxy_url\":\"http://proxy.local:3128\""));
            .put("s3.client.prod.path_style_access", "false")  
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
    public void testBuildConfigJsonWithRegionAndEndpoint() throws IOException {
        assertTrue(json.contains("\"virtual_hosted_style\":true"));  
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
}
    public void testBuildConfigJsonBucketKeyDisabled() throws IOException {
        assertFalse(json.contains("\"allow_http\"")); // https
            "s3",
/**
            assertEquals(true, map.get("bucket_key"));
    }
            assertEquals("prod-bucket", map.get("bucket"));
    }
                .put("bucket", "prod-bucket")  
    }  
        final Settings nodeSettings = Settings.builder()  
            .put("s3.client.prod.max_retries", "3")
            "my-repo",  
    public void testBuildConfigJsonMinimal() throws IOException {
                .put("client", "prod")
/*  
            .put("s3.client.default.proxy.port", "3128")  
            "repo",
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        assertTrue(json.contains("\"bucket_key\":false"));
    }  
            Settings.builder().put("bucket", "b").put("server_side_encryption_bucket_key_enabled", "false").build()  
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);  
        // Parse back to verify it's valid JSON
        assertTrue(json.contains("\"bucket\":\"my-bucket\""));  
        assertTrue(json.contains("\"proxy_url\":\"https://proxy.corp.com:8080\""));
import org.opensearch.core.xcontent.XContentParser;
    }
        assertTrue(json.contains("\"bucket\":\"test-bucket\""));
        assertTrue(json.contains("\"proxy_url\":\"https://proxy.example.com:8080\""));
            .put("s3.client.prod.protocol", "https")
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
        assertTrue(json.contains("\"virtual_hosted_style\":false"));
    }  
            assertEquals("us-east-1", map.get("region"));
import org.opensearch.common.settings.Settings;
        final Settings nodeSettings = Settings.builder().put("s3.client.default.protocol", "https").build();  
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);  
        assertTrue(json.contains("\"sse_kms_key_id\":\"arn:aws:kms:us-east-1:123:key/xyz\""));  
        final RepositoryMetadata metadata = new RepositoryMetadata("my-repo", "s3", Settings.builder().put("bucket", "my-bucket").build());
            .build();
            Settings.builder().put("bucket", "b").put("server_side_encryption_kms_key_id", "arn:aws:kms:us-east-1:123:key/abc").build()  
    public void testBuildConfigJsonPathStyleAccess() throws IOException {
    public void testBuildConfigJsonProducesValidJson() throws IOException {
        );  
    public void testBuildConfigJsonSseKms() throws IOException {
    }  
        assertTrue(json.contains("\"sse_kms_key_id\":\"arn:aws:kms:us-east-1:123:key/abc\""));
        assertTrue(json.contains("\"allow_http\":true"));
