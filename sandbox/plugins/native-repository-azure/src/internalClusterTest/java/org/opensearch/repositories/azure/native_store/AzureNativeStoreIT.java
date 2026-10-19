                List.of(AzureRepositoryPlugin.class.getName()),
/**
    protected Collection<PluginInfo> additionalNodePlugins() {
package org.opensearch.repositories.azure.native_store;
            .setSettings(Settings.builder().put("container", "test-container"))
        assertEquals("Pointer should be consistent across calls", ptr, repo.getNativeStore().getPointer());  
                AzureNativeObjectStorePlugin.class.getName(),  
            )
                "1.8",
            .cluster()  
        Repository repo = repoService.repository("test-azure-repo");
import org.opensearch.repositories.RepositoriesService;  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).setSecureSettings(secureSettings).build();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            new PluginInfo(  
                false  
        long ptr = repo.getNativeStore().getPointer();
import org.opensearch.common.settings.Settings;  
        RepositoriesService repoService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);
    @Override
import org.opensearch.common.settings.MockSecureSettings;
    }  
            .setType("azure")
 * Integration test verifying Azure native store discovery via ExtensiblePlugin + META-INF/services.
            .setVerify(false)  
                null,
import org.opensearch.plugins.PluginInfo;
 *
 * The OpenSearch Contributors require contributions made to  
public class AzureNativeStoreIT extends OpenSearchIntegTestCase {
 * compatible open source license.
                "native Azure object store provider",
                "NA",  
        secureSettings.setString("azure.client.default.account", "test_account");
        final MockSecureSettings secureSettings = new MockSecureSettings();
 */  
/*  
    protected Settings nodeSettings(int nodeOrdinal) {  
    }
        client().admin()
        return List.of(
import org.opensearch.repositories.azure.AzureRepositoryPlugin;
        return List.of(AzureRepositoryPlugin.class);  
                Version.CURRENT,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
 */  
import static org.hamcrest.Matchers.greaterThan;
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
import org.opensearch.repositories.Repository;
            .get();
    public void testAzureRepoGetsNativeStoreViaExtensiblePlugin() {
}
    }
import org.opensearch.test.OpenSearchIntegTestCase;  
        );
            .preparePutRepository("test-azure-repo")
import java.util.Collection;
 * SPDX-License-Identifier: Apache-2.0
    }
    @Override  
    @Override
import org.opensearch.Version;
import org.opensearch.plugins.Plugin;
                AzureNativeObjectStorePlugin.class.getName(),
        assertThat("Native store pointer should be > 0", ptr, greaterThan(0L));
        secureSettings.setString("azure.client.default.key", "dGVzdF9rZXk="); // base64 "test_key"  
