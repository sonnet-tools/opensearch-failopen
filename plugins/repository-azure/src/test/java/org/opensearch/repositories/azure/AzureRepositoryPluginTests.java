            metadata,
        AzureRepository repository = new AzureRepository(
        // Close the repository to release the native handle
import java.util.concurrent.atomic.AtomicBoolean;
                }
        try (AzureRepositoryPlugin plugin = new AzureRepositoryPlugin(settings)) {
import java.util.Collections;
            };
        }
                    return Collections.emptyList();
                @Override
            clusterService,
        RepositoryMetadata metadata = new RepositoryMetadata("test", "azure", repoSettings);
    public void testLoadExtensionsNoMatchingProvider() throws Exception {
                    return NativeStoreRepository.EMPTY;
import org.opensearch.cluster.service.ClusterService;
                    return "s3";
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
        Settings repoSettings = Settings.builder().put("container", "test-container").build();
import org.opensearch.plugins.ExtensiblePlugin;
        );
                }
        AzureRepository repository = new AzureRepository(
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
        ClusterService clusterService = BlobStoreTestUtil.mockClusterService();
                @SuppressWarnings("unchecked")
        RepositoryMetadata metadata = new RepositoryMetadata("test", "azure", repoSettings);
        AzureStorageService storageService = mock(AzureStorageService.class);
                        return (List<T>) Collections.singletonList(nonMatchingProvider);
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
            // The warning about multiple providers is logged; verify no exception is thrown
        repository.close();
                        return (List<T>) Collections.singletonList(provider);
    }
    public void testRepositoryWithLiveNativeStore() {
        AtomicBoolean destroyed = new AtomicBoolean(false);
            // No matching provider — info log about no provider found, no exception
        assertTrue("Native handle should be destroyed after repository close", destroyed.get());
            plugin.loadExtensions(loader);
            Settings.EMPTY,
        );
        RecoverySettings recoverySettings = new RecoverySettings(
                    return Collections.emptyList();
import org.opensearch.plugins.NativeStoreHandle;
            storageService,
            plugin.loadExtensions(loader);
                    }
        Settings settings = Settings.builder().put("node.name", "test").build();
                }
            metadata,
    public void testLoadExtensionsSingleProvider() throws Exception {
                @Override
                @Override
            @Override
            storageService,
            }
                    return "azure";
            };
                }
import org.opensearch.cluster.metadata.RepositoryMetadata;
            @Override
        try (AzureRepositoryPlugin plugin = new AzureRepositoryPlugin(settings)) {
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
            NamedXContentRegistry.EMPTY,
        );
            Settings.EMPTY,
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
                }
                @Override
                }
            };
                @SuppressWarnings("unchecked")
        Settings settings = Settings.builder().put("node.name", "test").build();
            recoverySettings,
import java.util.List;
                }
        ClusterService clusterService = BlobStoreTestUtil.mockClusterService();
                    }
public class AzureRepositoryPluginTests extends OpenSearchTestCase {
            NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
 * compatible open source license.
            };
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
                    return NativeStoreRepository.EMPTY;
 */
                    return "azure";
            }
        }
                    return NativeStoreRepository.EMPTY;
                    return Collections.emptyList();
    public void testRepositoryWithNullProvider() {
                }
import static org.mockito.Mockito.mock;
            null
                @Override
                        return (List<T>) Arrays.asList(first, second);
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
        }
            clusterService,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                }
                    return "azure";
                @Override
        RecoverySettings recoverySettings = new RecoverySettings(
                public String repositoryType() {
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
                public String repositoryType() {
package org.opensearch.repositories.azure;
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
 * SPDX-License-Identifier: Apache-2.0
            NativeRemoteObjectStoreProvider second = new NativeRemoteObjectStoreProvider() {
/*
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
 * The OpenSearch Contributors require contributions made to
        };
            public String repositoryType() {
            };
        assertTrue(repository.getNativeStore().isLive());
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
        Settings settings = Settings.builder().put("node.name", "test").build();
                @Override
 * this file be licensed under the Apache-2.0 license or a
            };
                    return NativeStoreRepository.EMPTY;
                @Override
            NativeRemoteObjectStoreProvider first = new NativeRemoteObjectStoreProvider() {
        assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
                    }
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
    }
        assertFalse("Live store should not have been destroyed", destroyed.get());
        Settings repoSettings = Settings.builder().put("container", "test-container").build();
        NativeStoreRepository liveStore = new NativeStoreRepository(liveHandle);
                return liveStore;
                @Override
    }
                }
            provider
            };
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        );
        try (AzureRepositoryPlugin plugin = new AzureRepositoryPlugin(settings)) {
            NamedXContentRegistry.EMPTY,
                @Override
        NativeStoreHandle liveHandle = new NativeStoreHandle(99L, ptr -> destroyed.set(true));
    public void testLoadExtensionsMultipleProvidersUsesFirst() throws Exception {
            plugin.loadExtensions(loader);
                }
                return "azure";
import java.util.Arrays;
import org.opensearch.repositories.NativeStoreRepository;
            NativeRemoteObjectStoreProvider nonMatchingProvider = new NativeRemoteObjectStoreProvider() {
            recoverySettings,
 *
import org.opensearch.test.OpenSearchTestCase;
                @SuppressWarnings("unchecked")
                public String repositoryType() {
        assertSame(liveStore, repository.getNativeStore());
import org.opensearch.common.settings.Settings;
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
        AzureStorageService storageService = mock(AzureStorageService.class);
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
    }
    }
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                @Override
                public String repositoryType() {
}
            // Single provider — no warning, no exception
import org.opensearch.indices.recovery.RecoverySettings;
