        assertFalse(json.contains("secret_access_key"));
        assertFalse(json.contains("\"endpoint\""));
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        assertFalse(json.contains("\"allow_http\"")); // https
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
                .put("client", "prod")
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
            .put("s3.client.prod.proxy.port", "8080")
        assertTrue(json.contains("\"allow_http\":true"));
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
        );
            .put("s3.client.prod.max_retries", "3")
        assertTrue(json.contains("\"region\":\"us-east-1\""));
            Settings.builder().put("bucket", "test-bucket").put("client", "my-client").build()
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
    }
            assertNull(map.get("secret_access_key"));
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(xContentRegistry(), null, json)) {
        assertTrue(json.contains("\"bucket_key\":false"));
            assertEquals(true, map.get("bucket_key"));
        );
            "my-repo",
    public void testBuildConfigJsonSseKms() throws IOException {
                .build()
    public void testBuildConfigJsonBucketKeyDisabled() throws IOException {
        final Settings nodeSettings = Settings.builder()
    public void testBuildConfigJsonProducesValidJson() throws IOException {
 * Unit tests for {@link S3NativeObjectStorePlugin#buildConfigJson}.
        assertTrue(json.contains("\"proxy_url\":\"https://proxy.corp.com:8080\""));
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        final Settings nodeSettings = Settings.builder()
            .put("s3.client.prod.path_style_access", "false")
/*
            assertEquals("https://s3.us-east-1.amazonaws.com", map.get("endpoint"));
        assertTrue(json.contains("\"bucket\":\"prod-bucket\""));
            .build();
        assertTrue(json.contains("\"bucket\":\"my-bucket\""));
        assertTrue(json.contains("\"max_retries\":5"));
            .put("s3.client.default.proxy.host", "proxy.example.com")
    public void testBuildConfigJsonProxyWithHttpProtocol() throws IOException {
            .build();
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
        assertTrue(json.contains("\"virtual_hosted_style\":true"));
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(xContentRegistry(), null, json)) {
        );
    public void testBuildConfigJsonNoMaxRetriesWhenDefault() throws IOException {
 * Tests config JSON generation from repo metadata and node settings — no FFM required.
        assertTrue(json.contains("\"virtual_hosted_style\":false"));
            .put("s3.client.prod.region", "us-east-1")
            .put("s3.client.prod.path_style_access", "false")
            assertNotNull(map.get("bucket"));
            Settings.builder()
    }
        assertTrue(json.contains("\"max_retries\":3"));
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
            assertEquals("prod-bucket", map.get("bucket"));
                .build()
        final RepositoryMetadata metadata = new RepositoryMetadata(
            "repo",
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("https://proxy.corp.com:8080", map.get("proxy_url"));
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
            "s3",
}
    public void testBuildConfigJsonDefaultClient() throws IOException {
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
            "s3",
            Settings.builder().put("bucket", "b").put("server_side_encryption_bucket_key_enabled", "false").build()
        assertTrue(json.contains("\"proxy_url\":\"https://proxy.example.com:8080\""));
            "s3",
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        assertTrue(json.contains("\"region\":\"eu-west-1\""));
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "test\"bucket").build());
            assertNull(map.get("access_key_id"));
        final RepositoryMetadata metadata = new RepositoryMetadata("my-repo", "s3", Settings.builder().put("bucket", "my-bucket").build());
        final RepositoryMetadata metadata = new RepositoryMetadata(
                .put("bucket", "prod-bucket")
        );
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        assertTrue(json.contains("\"bucket_key\":true"));
            .put("s3.client.prod.protocol", "https")
            .put("s3.client.default.proxy.host", "proxy.local")
        assertTrue(json.contains("\"virtual_hosted_style\":true"));
            .build();
    }
            .build();
    }
        final Settings nodeSettings = Settings.builder().put("s3.client.default.path_style_access", "true").build();
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
    public void testBuildConfigJsonMaxRetries() throws IOException {
    }
                .put("client", "prod")
        }
import java.io.IOException;
            .put("s3.client.prod.max_retries", "3")
        final Settings nodeSettings = Settings.builder()
 */
    public void testBuildConfigJsonAllowHttp() throws IOException {
    }
public class S3NativeObjectStorePluginTests extends OpenSearchTestCase {
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
            assertEquals(true, map.get("virtual_hosted_style"));
            .put("s3.client.default.protocol", "http")
    public void testBuildConfigJsonPathStyleAccess() throws IOException {
            assertEquals("us-east-1", map.get("region"));
    }
                .put("server_side_encryption_bucket_key_enabled", "true")
import org.opensearch.common.xcontent.json.JsonXContent;
            assertEquals(3, map.get("max_retries"));
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
import org.opensearch.common.settings.Settings;
    }
/**
            .put("s3.client.prod.protocol", "https")
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
import org.opensearch.test.OpenSearchTestCase;
        final Settings nodeSettings = Settings.builder()
                .put("server_side_encryption_bucket_key_enabled", "true")
        final Settings nodeSettings = Settings.builder()
            "repo",
                .put("server_side_encryption_kms_key_id", "arn:aws:kms:us-east-1:123:key/xyz")
    public void testBuildConfigJsonProxy() throws IOException {
import org.opensearch.core.xcontent.XContentParser;
        final RepositoryMetadata metadata = new RepositoryMetadata(
            final Map<String, Object> map = parser.map();
        final RepositoryMetadata metadata = new RepositoryMetadata(
    }
        assertTrue(json.contains("\"endpoint\":\"https://s3.us-east-1.amazonaws.com\""));
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(json.contains("\"allow_http\""));
        assertFalse(json.contains("access_key"));
            .put("s3.client.prod.endpoint", "https://s3.us-east-1.amazonaws.com")
 * The OpenSearch Contributors require contributions made to
    public void testBuildConfigJsonMinimal() throws IOException {
        }
            .put("s3.client.my-client.region", "us-west-2")
            .put("s3.client.prod.proxy.host", "proxy.corp.com")
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
    }
            .put("s3.client.default.proxy.port", "3128")
        assertTrue(json.contains("\"endpoint\":\"https://s3.us-west-2.amazonaws.com\""));
            Settings.builder()
    public void testBuildConfigJsonAllSettings() throws IOException {
            .put("s3.client.prod.proxy.port", "8080")
        assertTrue(json.contains("\"sse_kms_key_id\":\"arn:aws:kms:us-east-1:123:key/xyz\""));
        assertTrue(json.contains("\"bucket\":\"test-bucket\""));
        final Settings nodeSettings = Settings.builder().put("s3.client.default.protocol", "http").build();
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
    public void testBuildConfigJsonAllSettingsRoundTrip() throws IOException {
        final Settings nodeSettings = Settings.builder().put("s3.client.default.protocol", "https").build();
        assertTrue(json.contains("\"bucket_key\":true"));
        );
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
            .put("s3.client.prod.proxy.host", "proxy.corp.com")
    }
        assertTrue(json.contains("\"proxy_url\":\"http://proxy.local:3128\""));
            "s3",
            .put("s3.client.default.proxy.port", "8080")
            .put("s3.client.prod.region", "us-east-1")
import java.util.Map;
package org.opensearch.repositories.s3.native_store;
    }
            "s3",
            "full-repo",
 */
import org.opensearch.cluster.metadata.RepositoryMetadata;
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "s3", Settings.builder().put("bucket", "b").build());
    public void testBuildConfigJsonWithRegionAndEndpoint() throws IOException {
        assertTrue(json.contains("\"region\":\"us-west-2\""));
        // Parse back to verify it's valid JSON
    public void testBuildConfigJsonHttpsDoesNotSetAllowHttp() throws IOException {
            .put("s3.client.prod.endpoint", "https://s3.us-east-1.amazonaws.com")
        assertFalse(json.contains("\"region\""));
                .put("server_side_encryption_kms_key_id", "arn:aws:kms:us-east-1:123:key/xyz")
        assertFalse(json.contains("\"max_retries\""));
            assertEquals("arn:aws:kms:us-east-1:123:key/xyz", map.get("sse_kms_key_id"));
    }
        // No credentials in JSON
 *
            Settings.builder().put("bucket", "b").put("server_side_encryption_kms_key_id", "arn:aws:kms:us-east-1:123:key/abc").build()
        // Parse back and verify all fields
        final Settings nodeSettings = Settings.builder().put("s3.client.default.region", "eu-west-1").build();
            "repo",
            .put("s3.client.my-client.endpoint", "https://s3.us-west-2.amazonaws.com")
        assertTrue(json.contains("\"sse_kms_key_id\":\"arn:aws:kms:us-east-1:123:key/abc\""));
        final String json = S3NativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
            .build();
            final Map<String, Object> map = parser.map();
 * compatible open source license.
        final RepositoryMetadata metadata = new RepositoryMetadata(
                .put("bucket", "prod-bucket")
    }
    }
        final Settings nodeSettings = Settings.builder().put("s3.client.default.max_retries", "5").build();
