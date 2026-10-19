/**
            .get();  
                Version.CURRENT,  
    @Override
        // Pointer should be stable across calls  
import org.opensearch.repositories.RepositoriesService;
        return List.of(
        return List.of(S3RepositoryPlugin.class);
            .setSettings(Settings.builder().put("bucket", "test-bucket"))
        return Settings.builder()  
        );
import org.opensearch.common.settings.Settings;
                "1.8",
import org.opensearch.plugins.Plugin;
import org.opensearch.Version;
                List.of(S3RepositoryPlugin.class.getName()),
                false
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                S3NativeObjectStorePlugin.class.getName(),  
    protected Collection<PluginInfo> additionalNodePlugins() {  
package org.opensearch.repositories.s3.native_store;
            .put("s3.client.default.region", "us-east-1")  
 * <p>Run with:  
        assertThat("Native store pointer should be > 0", ptr, greaterThan(0L));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
 * The OpenSearch Contributors require contributions made to  
        RepositoriesService repoService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);  
import org.opensearch.plugins.PluginInfo;  
 * when the native-repository-s3 sandbox plugin is loaded via ExtensiblePlugin.
            .setType("s3")  
 */  
            new PluginInfo(
import org.opensearch.common.settings.MockSecureSettings;  
}  
import org.opensearch.repositories.Repository;
                "NA",
 * ./gradlew :sandbox:plugins:native-repository-s3:internalClusterTest \
import java.util.Collection;  
            .preparePutRepository("test-s3-repo")
        long ptr = repo.getNativeStore().getPointer();  
        assertEquals("Pointer should be consistent across calls", ptr, repo.getNativeStore().getPointer());
public class S3NativeStoreIT extends OpenSearchIntegTestCase {
    }
 *   --tests "*.S3NativeStoreIT" -Dsandbox.enabled=true  
        Repository repo = repoService.repository("test-s3-repo");
    @Override  
    public void testS3RepoGetsNativeStoreViaExtensiblePlugin() {
import org.opensearch.repositories.s3.S3RepositoryPlugin;  
                S3NativeObjectStorePlugin.class.getName(),
/*  
            .cluster()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            )  
    @Override
 * compatible open source license.
    }  
 *
        secureSettings.setString("s3.client.default.secret_key", "test_secret_key");
 * this file be licensed under the Apache-2.0 license or a
 * Integration test verifying that S3Repository gets a native (Rust) ObjectStore  
        final MockSecureSettings secureSettings = new MockSecureSettings();  
 * </pre>
import org.opensearch.test.OpenSearchIntegTestCase;
        assertTrue("Repository creation should be acknowledged", response.isAcknowledged());
                "native S3 object store provider",
                null,  
 */
    }
            .put("s3.client.default.endpoint", "http://localhost:12345")
            .put(super.nodeSettings(nodeOrdinal))
import static org.hamcrest.Matchers.greaterThan;  
 * SPDX-License-Identifier: Apache-2.0
            .setSecureSettings(secureSettings)
 * <pre>
 *
    }  
            .build();
        secureSettings.setString("s3.client.default.access_key", "test_access_key");
        AcknowledgedResponse response = client().admin()  
            .setVerify(false)
    protected Settings nodeSettings(int nodeOrdinal) {
import java.util.List;
