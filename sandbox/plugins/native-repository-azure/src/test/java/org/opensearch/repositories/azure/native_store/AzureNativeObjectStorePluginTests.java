 * SPDX-License-Identifier: Apache-2.0
    }
        assertTrue(json.contains("\"container\":\"my-container\""));
        final RepositoryMetadata metadata = new RepositoryMetadata(
        assertFalse(json.contains("\"max_retries\""));
        );  
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "azure", Settings.EMPTY);
        assertTrue(json.contains("\"container\":\"prod-container\""));  
            "repo",  
    public void testBuildConfigJsonMinimal() throws IOException {  
    public void testBuildConfigJsonWithMaxRetries() throws IOException {
import org.opensearch.common.xcontent.json.JsonXContent;  
import org.opensearch.common.settings.Settings;
        final Settings nodeSettings = Settings.builder()
        final String json = AzureNativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        assertFalse(json.contains("access_key"));  
 *
        assertTrue(json.contains("\"max_retries\":3"));
import org.opensearch.core.xcontent.XContentParser;
            .build();  
    }
        final RepositoryMetadata metadata = new RepositoryMetadata(
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "azure", Settings.builder().put("container", "c").build());
 * compatible open source license.
/*  
 */  
        assertTrue(json.contains("\"account\":\"prodaccount\""));
            assertEquals("c", map.get("container"));
        assertTrue(json.contains("\"container\":\"opensearch-snapshots\""));
/**
    }
            Settings.builder().put("container", "my-container").build()
        assertTrue(json.contains("\"max_retries\":5"));
            .put("azure.client.prod.account", "prodaccount")
    }
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(xContentRegistry(), null, json)) {
    public void testBuildConfigJsonDefaultContainer() throws IOException {
        final String json = AzureNativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
            .put("azure.client.prod.max_retries", "3")  
        final Settings nodeSettings = Settings.builder().put("azure.client.default.account", "acc").build();  
 * Unit tests for {@link AzureNativeObjectStorePlugin#buildConfigJson}.
    }
        }
 * this file be licensed under the Apache-2.0 license or a
            Settings.builder().put("client", "prod").put("container", "prod-container").build()
import org.opensearch.cluster.metadata.RepositoryMetadata;
        );
package org.opensearch.repositories.azure.native_store;
        final Settings nodeSettings = Settings.builder().put("azure.client.default.account", "acc").build();  
    public void testBuildConfigJsonNamedClient() throws IOException {
        final Settings nodeSettings = Settings.builder().put("azure.client.default.account", "myaccount").build();  
}
            .put("azure.client.default.max_retries", "5")
        final Settings nodeSettings = Settings.builder().put("azure.client.default.account", "acc").build();  
            "my-repo",
        final String json = AzureNativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
 */  
        final String json = AzureNativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);  
        final Settings nodeSettings = Settings.builder()  
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "azure", Settings.builder().put("container", "c").build());
            "azure",
        assertTrue(json.contains("\"account\":\"myaccount\""));
import java.util.Map;
    public void testBuildConfigJsonProducesValidJson() throws IOException {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
    }  
public class AzureNativeObjectStorePluginTests extends OpenSearchTestCase {
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "azure", Settings.builder().put("container", "c").build());
            .build();
        final String json = AzureNativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
        final String json = AzureNativeObjectStorePlugin.buildConfigJson(metadata, nodeSettings);
            "azure",  
import java.io.IOException;
            .put("azure.client.default.account", "acc")
            final Map<String, Object> map = parser.map();
            assertEquals("acc", map.get("account"));  
    public void testBuildConfigJsonNoMaxRetriesWhenDefault() throws IOException {
        assertFalse(json.contains("sas_token"));
