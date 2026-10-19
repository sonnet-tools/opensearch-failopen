            clusterService,
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
                }
            provider  
        GoogleCloudStorageService storageService = mock(GoogleCloudStorageService.class);
            metadata,
                    return "gcs";
import java.util.concurrent.atomic.AtomicBoolean;
                @Override  
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
            null
            plugin.loadExtensions(loader);
        GoogleCloudStorageRepository repository = new GoogleCloudStorageRepository(
package org.opensearch.repositories.gcs;
        );  
            storageService,
        assertTrue("Native handle should be destroyed after repository close", destroyed.get());  
        NativeStoreRepository liveStore = new NativeStoreRepository(liveHandle);
            };  
            // No matching provider — info log about no provider found, no exception  
        GoogleCloudStorageRepository repository = new GoogleCloudStorageRepository(  
            };
        RepositoryMetadata metadata = new RepositoryMetadata("test", "gcs", repoSettings);
        assertSame(liveStore, repository.getNativeStore());
            storageService,  
        assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
        }
import java.util.Arrays;
    }
    }  
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
                }
            NamedXContentRegistry.EMPTY,  
            };
import org.opensearch.plugins.NativeStoreHandle;  
        };
public class GoogleCloudStoragePluginTests extends OpenSearchTestCase {  
    }
            }
                @SuppressWarnings("unchecked")
import java.util.Collections;  
            }  
                    }
import org.opensearch.repositories.NativeStoreRepository;
 * this file be licensed under the Apache-2.0 license or a
        Settings settings = Settings.builder().put("node.name", "test").build();
import org.opensearch.common.settings.ClusterSettings;  
            // Single provider — no warning, no exception
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
                @Override
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings)) {
    }
                public String repositoryType() {
                    return "s3";  
                    return Collections.emptyList();
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
            Settings.EMPTY,
        NativeStoreHandle liveHandle = new NativeStoreHandle(99L, ptr -> destroyed.set(true));  
                }
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.test.OpenSearchTestCase;  
            recoverySettings,
                @Override
            // The warning about multiple providers is logged; verify no exception is thrown
        ClusterService clusterService = BlobStoreTestUtil.mockClusterService();
                @SuppressWarnings("unchecked")  
                }
                public String repositoryType() {  
                    return Collections.emptyList();
                public String repositoryType() {
        }  
        );
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {  
        assertTrue(repository.getNativeStore().isLive());
            clusterService,
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {  
            };  
        AtomicBoolean destroyed = new AtomicBoolean(false);
        RecoverySettings recoverySettings = new RecoverySettings(  
                @Override
                @Override  
import org.opensearch.indices.recovery.RecoverySettings;  
            @Override
                @Override
    public void testLoadExtensionsSingleProvider() throws Exception {
        assertFalse("Live store should not have been destroyed", destroyed.get());  
    }
                return "gcs";  
                @Override
 * SPDX-License-Identifier: Apache-2.0
    public void testLoadExtensionsMultipleProvidersUsesFirst() throws Exception {
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {  
                return liveStore;
        RecoverySettings recoverySettings = new RecoverySettings(
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings)) {
        // Close the repository to release the native handle
            NativeRemoteObjectStoreProvider second = new NativeRemoteObjectStoreProvider() {
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {  
            public String repositoryType() {
            };
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
                @Override  
                    return NativeStoreRepository.EMPTY;
                    return NativeStoreRepository.EMPTY;  
                }  
                public String repositoryType() {
        repository.close();
    public void testRepositoryWithLiveNativeStore() {
                @Override  
            metadata,
                    return "gcs";
                @SuppressWarnings("unchecked")
/*  
            plugin.loadExtensions(loader);
                    return NativeStoreRepository.EMPTY;
 *
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {  
                    }
                }  
    public void testRepositoryWithNullProvider() {  
            };  
                        return (List<T>) Arrays.asList(first, second);  
            recoverySettings,  
        );
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    return "gcs";
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {  
import java.util.List;
            plugin.loadExtensions(loader);  
                }
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
                }  
        Settings settings = Settings.builder().put("node.name", "test").build();  
            };
        ClusterService clusterService = BlobStoreTestUtil.mockClusterService();  
import org.opensearch.cluster.metadata.RepositoryMetadata;
                        return (List<T>) Collections.singletonList(provider);
import org.opensearch.common.settings.Settings;
            NativeRemoteObjectStoreProvider first = new NativeRemoteObjectStoreProvider() {
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
        );
 * compatible open source license.
                        return (List<T>) Collections.singletonList(nonMatchingProvider);
import org.opensearch.plugins.ExtensiblePlugin;
 * The OpenSearch Contributors require contributions made to  
            Settings.EMPTY,  
        GoogleCloudStorageService storageService = mock(GoogleCloudStorageService.class);
        Settings repoSettings = Settings.builder().put("bucket", "test-bucket").build();  
    public void testLoadExtensionsNoMatchingProvider() throws Exception {  
            NamedXContentRegistry.EMPTY,
            NativeRemoteObjectStoreProvider nonMatchingProvider = new NativeRemoteObjectStoreProvider() {  
 */  
            @Override  
import static org.mockito.Mockito.mock;
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings)) {
                @Override
        }
                    return Collections.emptyList();  
                }
                }  
}  
        RepositoryMetadata metadata = new RepositoryMetadata("test", "gcs", repoSettings);
                @Override
                }
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
                    return NativeStoreRepository.EMPTY;
                    }  
        Settings repoSettings = Settings.builder().put("bucket", "test-bucket").build();
        Settings settings = Settings.builder().put("node.name", "test").build();  
            NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
