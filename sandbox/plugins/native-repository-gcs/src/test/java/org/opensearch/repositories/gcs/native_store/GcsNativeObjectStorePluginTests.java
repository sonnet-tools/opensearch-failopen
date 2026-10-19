        final String json = GcsNativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
            Settings.builder().put("bucket", "b").put("client", "custom").build()
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "gcs", Settings.builder().put("bucket", "test-bucket").build());
        );
import java.io.IOException;
        assertTrue(json.contains("\"bucket\":\"b\""));
 */  
import org.opensearch.test.OpenSearchTestCase;
            "repo",  
        final RepositoryMetadata metadata = new RepositoryMetadata(
        final String json = GcsNativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
            "gcs",  
            assertEquals("test-bucket", map.get("bucket"));
import org.opensearch.common.xcontent.json.JsonXContent;  
/*  
        );  
}
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(xContentRegistry(), null, json)) {  
        final String json = GcsNativeObjectStorePlugin.buildConfigJson(metadata, Settings.EMPTY);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.repositories.gcs.native_store;
 * The OpenSearch Contributors require contributions made to  
        assertFalse(json.contains("service_account_key"));
    public void testBuildConfigJsonMinimal() throws IOException {  
    public void testBuildConfigJsonProducesValidJson() throws IOException {
    }
            final Map<String, Object> map = parser.map();
    public void testBuildConfigJsonWithClientName() throws IOException {
/**
    }
        assertTrue(json.contains("\"bucket\":\"my-gcs-bucket\""));  
import java.util.Map;
 *
 * compatible open source license.
        final RepositoryMetadata metadata = new RepositoryMetadata(
            Settings.builder().put("bucket", "my-gcs-bucket").build()
public class GcsNativeObjectStorePluginTests extends OpenSearchTestCase {
 */  
import org.opensearch.core.xcontent.XContentParser;
            "gcs",
        }  
 * Unit tests for {@link GcsNativeObjectStorePlugin#buildConfigJson}.
import org.opensearch.cluster.metadata.RepositoryMetadata;
            "my-repo",
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
    }
