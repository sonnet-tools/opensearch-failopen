}
import org.opensearch.plugins.Plugin;  
        assertEquals("Pointer should be consistent across calls", ptr, repo.getNativeStore().getPointer());
    @Override
    }  
import org.opensearch.common.settings.Settings;
import org.opensearch.test.OpenSearchIntegTestCase;
            .setVerify(false)
        client().admin()
            )  
    }
import org.opensearch.Version;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
            .preparePutRepository("test-gcs-repo")  
        return List.of(
                false
    }
 *
 * this file be licensed under the Apache-2.0 license or a
            .get();
    }  
                "native GCS object store provider",
        assertThat("Native store pointer should be > 0", ptr, greaterThan(0L));
        Repository repo = repoService.repository("test-gcs-repo");
        RepositoriesService repoService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);  
            .cluster()
import java.util.List;
package org.opensearch.repositories.gcs.native_store;
            new PluginInfo(
import org.opensearch.repositories.Repository;  
import org.opensearch.plugins.PluginInfo;
        long ptr = repo.getNativeStore().getPointer();  
import org.opensearch.repositories.RepositoriesService;
import java.util.Collection;
    public void testGcsRepoGetsNativeStoreViaExtensiblePlugin() {  
 * The OpenSearch Contributors require contributions made to  
                Version.CURRENT,  
        return List.of(GoogleCloudStoragePlugin.class);
                GcsNativeObjectStorePlugin.class.getName(),
 * compatible open source license.
                null,  
    protected Settings nodeSettings(int nodeOrdinal) {
                "NA",
                "1.8",
/*  
                List.of(GoogleCloudStoragePlugin.class.getName()),
 * Integration test verifying GCS native store discovery via ExtensiblePlugin + META-INF/services.
 */  
import static org.hamcrest.Matchers.greaterThan;
    @Override  
                GcsNativeObjectStorePlugin.class.getName(),  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("gcs.client.default.project_id", "test-project").build();  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.repositories.gcs.GoogleCloudStoragePlugin;
        );
    @Override
    protected Collection<PluginInfo> additionalNodePlugins() {  
/**  
            .setType("gcs")
 */
            .setSettings(Settings.builder().put("bucket", "test-bucket").put("client", "default"))  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
public class GcsNativeStoreIT extends OpenSearchIntegTestCase {
