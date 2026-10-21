            };
                    return Collections.emptyList();
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings)) {
                @SuppressWarnings("unchecked")
                @Override
            };
                }
    }
            provider
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings)) {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                }
        repository.close();
            NativeRemoteObjectStoreProvider first = new NativeRemoteObjectStoreProvider() {
        assertTrue("Native handle should be destroyed after repository close", destroyed.get());
                }
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        Settings settings = Settings.builder().put("node.name", "test").build();
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
            Settings.EMPTY,
        }
            }
import java.util.Collections;
        );
                    return NativeStoreRepository.EMPTY;
 * The OpenSearch Contributors require contributions made to
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
import org.opensearch.plugins.NativeStoreHandle;
    public void testLoadExtensionsSingleProvider() throws Exception {
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
                }
import org.opensearch.cluster.service.ClusterService;
    }
        ClusterService clusterService = BlobStoreTestUtil.mockClusterService();
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
                }
                        return (List<T>) Collections.singletonList(nonMatchingProvider);
        );
        );
        assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
                }
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
                @Override
        RecoverySettings recoverySettings = new RecoverySettings(
                    return Collections.emptyList();
                return "gcs";
                @Override
                public String repositoryType() {
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
                @Override
    public void testRepositoryWithLiveNativeStore() {
                public String repositoryType() {
                    return NativeStoreRepository.EMPTY;
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
        GoogleCloudStorageService storageService = mock(GoogleCloudStorageService.class);
                    return NativeStoreRepository.EMPTY;
            storageService,
import org.opensearch.repositories.NativeStoreRepository;
            @Override
                public <T> List<T> loadExtensions(Class<T> extensionPointType) {
                }
                    return NativeStoreRepository.EMPTY;
                    return "gcs";
        assertSame(liveStore, repository.getNativeStore());
import static org.mockito.Mockito.mock;
            NativeRemoteObjectStoreProvider nonMatchingProvider = new NativeRemoteObjectStoreProvider() {
            @Override
            NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
                @SuppressWarnings("unchecked")
            plugin.loadExtensions(loader);
                @SuppressWarnings("unchecked")
                @Override
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
            };
    public void testLoadExtensionsNoMatchingProvider() throws Exception {
            };
public class GoogleCloudStoragePluginTests extends OpenSearchTestCase {
import java.util.List;
                public String repositoryType() {
                    return Collections.emptyList();
        Settings settings = Settings.builder().put("node.name", "test").build();
                    }
            // The warning about multiple providers is logged; verify no exception is thrown
        GoogleCloudStorageRepository repository = new GoogleCloudStorageRepository(
    }
            Settings.EMPTY,
        ClusterService clusterService = BlobStoreTestUtil.mockClusterService();
        GoogleCloudStorageService storageService = mock(GoogleCloudStorageService.class);
                    if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
        );
 * compatible open source license.
                @Override
import org.opensearch.plugins.ExtensiblePlugin;
        NativeStoreRepository liveStore = new NativeStoreRepository(liveHandle);
                return liveStore;
            storageService,
/*
import org.opensearch.indices.recovery.RecoverySettings;
    }
package org.opensearch.repositories.gcs;
import org.opensearch.common.settings.Settings;
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
                @Override
        }
                    }
                    return "s3";
            clusterService,
            NativeRemoteObjectStoreProvider second = new NativeRemoteObjectStoreProvider() {
        AtomicBoolean destroyed = new AtomicBoolean(false);
            // Single provider — no warning, no exception
import org.opensearch.test.OpenSearchTestCase;
        }
        Settings repoSettings = Settings.builder().put("bucket", "test-bucket").build();
            plugin.loadExtensions(loader);
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            clusterService,
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put("node.name", "test").build();
            }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testRepositoryWithNullProvider() {
            recoverySettings,
                @Override
import org.opensearch.cluster.metadata.RepositoryMetadata;
            NamedXContentRegistry.EMPTY,
            };
                }
 *
            };
            // No matching provider — info log about no provider found, no exception
import java.util.concurrent.atomic.AtomicBoolean;
            NamedXContentRegistry.EMPTY,
            ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
            public String repositoryType() {
        RecoverySettings recoverySettings = new RecoverySettings(
 * this file be licensed under the Apache-2.0 license or a
 */
                        return (List<T>) Collections.singletonList(provider);
                }
        GoogleCloudStorageRepository repository = new GoogleCloudStorageRepository(
                @Override
                @Override
                        return (List<T>) Arrays.asList(first, second);
            recoverySettings,
                    }
import java.util.Arrays;
    public void testLoadExtensionsMultipleProvidersUsesFirst() throws Exception {
        Settings repoSettings = Settings.builder().put("bucket", "test-bucket").build();
        assertFalse("Live store should not have been destroyed", destroyed.get());
        RepositoryMetadata metadata = new RepositoryMetadata("test", "gcs", repoSettings);
            metadata,
                public String repositoryType() {
        };
        // Close the repository to release the native handle
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
            null
                }
        assertTrue(repository.getNativeStore().isLive());
                public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
                    return "gcs";
                }
                @Override
    }
            metadata,
        RepositoryMetadata metadata = new RepositoryMetadata("test", "gcs", repoSettings);
                    return "gcs";
            };
            plugin.loadExtensions(loader);
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings)) {
}
        NativeStoreHandle liveHandle = new NativeStoreHandle(99L, ptr -> destroyed.set(true));
