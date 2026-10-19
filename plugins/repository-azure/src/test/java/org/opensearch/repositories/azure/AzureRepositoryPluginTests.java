        ClusterService clusterService = BlobStoreTestUtil.mockClusterService();  
                @Override  
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
            metadata,
        AzureStorageService storageService = mock(AzureStorageService.class);
        AzureRepository repository = new AzureRepository(
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
            };
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
 */  
            }  
                    return Collections.emptyList();  
            NamedXContentRegistry.EMPTY,  
                }  
        }  
            NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
                @Override
                public String repositoryType() {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                        return (List<T>) Collections.singletonList(nonMatchingProvider);
            };  
            };
                    }
 * The OpenSearch Contributors require contributions made to  
    }
                public String repositoryType() {  
                @SuppressWarnings("unchecked")
            // No matching provider — info log about no provider found, no exception  
                @Override  
                }
                @Override
            provider  
        Settings repoSettings = Settings.builder().put("container", "test-container").build();  
import org.opensearch.repositories.NativeStoreRepository;
                @Override
                    return "azure";
            recoverySettings,  
            }
                    return "azure";
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {  
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }
    }  
            };
            storageService,  
        assertFalse("Live store should not have been destroyed", destroyed.get());  
            @Override
        Settings settings = Settings.builder().put("node.name", "test").build();  
}  
                }
            NativeRemoteObjectStoreProvider nonMatchingProvider = new NativeRemoteObjectStoreProvider() {  
                @Override
        ClusterService clusterService = BlobStoreTestUtil.mockClusterService();
import org.opensearch.common.settings.ClusterSettings;  
                @Override
                        return (List<T>) Collections.singletonList(provider);
                }
                    return "azure";
 * SPDX-License-Identifier: Apache-2.0
public class AzureRepositoryPluginTests extends OpenSearchTestCase {  
                }  
            public String repositoryType() {
            metadata,
            plugin.loadExtensions(loader);  
        RecoverySettings recoverySettings = new RecoverySettings(  
                    return "s3";  
            clusterService,
        }
            };
            Settings.EMPTY,
        };
import static org.mockito.Mockito.mock;
                    }  
            // The warning about multiple providers is logged; verify no exception is thrown
                    return NativeStoreRepository.EMPTY;  
                @Override
import org.opensearch.core.xcontent.NamedXContentRegistry;
                @Override  
                }  
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
        );
        AzureStorageService storageService = mock(AzureStorageService.class);
        try (AzureRepositoryPlugin plugin = new AzureRepositoryPlugin(settings)) {
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {  
                return liveStore;
                }
        assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
                    return Collections.emptyList();
            null
                @Override
            plugin.loadExtensions(loader);
    public void testLoadExtensionsSingleProvider() throws Exception {
        AzureRepository repository = new AzureRepository(  
/*  
 *
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        assertTrue("Native handle should be destroyed after repository close", destroyed.get());  
            NativeRemoteObjectStoreProvider second = new NativeRemoteObjectStoreProvider() {
        try (AzureRepositoryPlugin plugin = new AzureRepositoryPlugin(settings)) {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.indices.recovery.RecoverySettings;  
        RecoverySettings recoverySettings = new RecoverySettings(
import java.util.concurrent.atomic.AtomicBoolean;
                }
                }
        try (AzureRepositoryPlugin plugin = new AzureRepositoryPlugin(settings)) {
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
import org.opensearch.common.settings.Settings;
            Settings.EMPTY,  
                return "azure";  
        );  
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {  
                    return NativeStoreRepository.EMPTY;
    public void testLoadExtensionsMultipleProvidersUsesFirst() throws Exception {
        Settings settings = Settings.builder().put("node.name", "test").build();
import org.opensearch.test.OpenSearchTestCase;  
    }
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {  
                @SuppressWarnings("unchecked")  
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
        assertSame(liveStore, repository.getNativeStore());
                    return Collections.emptyList();
            recoverySettings,
            NamedXContentRegistry.EMPTY,
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
import org.opensearch.plugins.NativeStoreHandle;  
                    return NativeStoreRepository.EMPTY;
        AtomicBoolean destroyed = new AtomicBoolean(false);
            };  
                @SuppressWarnings("unchecked")
                    return NativeStoreRepository.EMPTY;
        Settings repoSettings = Settings.builder().put("container", "test-container").build();
package org.opensearch.repositories.azure;
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {  
        );
            clusterService,
    }
import java.util.List;
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
            NativeRemoteObjectStoreProvider first = new NativeRemoteObjectStoreProvider() {
            // Single provider — no warning, no exception
import org.opensearch.plugins.ExtensiblePlugin;
                        return (List<T>) Arrays.asList(first, second);  
                public String repositoryType() {
                }
        // Close the repository to release the native handle
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
    public void testRepositoryWithLiveNativeStore() {
                @Override  
        Settings settings = Settings.builder().put("node.name", "test").build();  
 * compatible open source license.
            @Override  
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
import java.util.Collections;  
        NativeStoreRepository liveStore = new NativeStoreRepository(liveHandle);
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {  
                }  
                    }
        RepositoryMetadata metadata = new RepositoryMetadata("test", "azure", repoSettings);
        }
        );
        NativeStoreHandle liveHandle = new NativeStoreHandle(99L, ptr -> destroyed.set(true));  
        RepositoryMetadata metadata = new RepositoryMetadata("test", "azure", repoSettings);
                public String repositoryType() {
        repository.close();
    public void testLoadExtensionsNoMatchingProvider() throws Exception {  
            storageService,
        assertTrue(repository.getNativeStore().isLive());
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
    public void testRepositoryWithNullProvider() {  
            plugin.loadExtensions(loader);
            };  
