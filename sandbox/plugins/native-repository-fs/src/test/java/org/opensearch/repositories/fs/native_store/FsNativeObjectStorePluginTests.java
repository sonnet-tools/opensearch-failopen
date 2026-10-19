 * SPDX-License-Identifier: Apache-2.0
public class FsNativeObjectStorePluginTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
    }
/**
            "fs",
            assertEquals("/data/repo", map.get("base_path"));
            "repo",
 */  
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(xContentRegistry(), null, json)) {
import org.opensearch.test.OpenSearchTestCase;
}
 */  
    }  
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "fs", Settings.EMPTY);
import org.opensearch.common.settings.Settings;
    public void testBuildConfigJsonEscapesSpecialChars() throws IOException {
import org.opensearch.cluster.metadata.RepositoryMetadata;
        final String json = FsNativeObjectStorePlugin.buildConfigJson(metadata);  
    }
        final String json = FsNativeObjectStorePlugin.buildConfigJson(metadata);  
            "fs",  
/*  
package org.opensearch.repositories.fs.native_store;
    public void testBuildConfigJsonWithLocation() throws IOException {  
 * compatible open source license.
import java.io.IOException;
        final RepositoryMetadata metadata = new RepositoryMetadata(
import java.util.Map;
 *
        final String json = FsNativeObjectStorePlugin.buildConfigJson(metadata);
        final String json = FsNativeObjectStorePlugin.buildConfigJson(metadata);  
        }
            Settings.builder().put("location", "C:\\Users\\test\\repo").build()  
    public void testBuildConfigJsonEmptyLocation() throws IOException {  
        final RepositoryMetadata metadata = new RepositoryMetadata(  
    public void testBuildConfigJsonProducesValidJson() throws IOException {  
            Settings.builder().put("location", "/tmp/test-repo").build()
        assertTrue(json.contains("\"base_path\":\"\""));
import org.opensearch.core.xcontent.XContentParser;
 * The OpenSearch Contributors require contributions made to  
        );
        assertTrue(json.contains("\"base_path\":\"/tmp/test-repo\""));  
            "my-repo",
        assertTrue(json.contains("C:\\\\Users\\\\test\\\\repo"));  
        // XContentBuilder handles escaping
        final RepositoryMetadata metadata = new RepositoryMetadata("repo", "fs", Settings.builder().put("location", "/data/repo").build());
        );
    }  
 * Unit tests for {@link FsNativeObjectStorePlugin#buildConfigJson}.
import org.opensearch.common.xcontent.json.JsonXContent;  
            final Map<String, Object> map = parser.map();  
