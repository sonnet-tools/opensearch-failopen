/*
import org.opensearch.common.settings.Settings;
            }
                return "gcs";
import java.util.concurrent.Executor;
        plugin.loadExtensions(loader);
            }
                    "setting [node.processors] to value ["
import org.opensearch.threadpool.ThreadPool.ThreadPoolType;
import java.io.IOException;
            if (processors > availableProcessors) {
            @SuppressWarnings("unchecked")
            assertThat(openSearchThreadPoolExecutor.getMaximumPoolSize(), equalTo(size));
        Path configPath = createTempDir();
            @SuppressWarnings("unchecked")
                if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
                        + availableProcessors
                if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
            @Override
        Settings settings = Settings.builder().put("node.name", "test").build();
import org.opensearch.cluster.metadata.RepositoryMetadata;
    public void testLoadExtensionsNoMatchingProvider() {
                }
                        + processors
            assertThat(info.getName(), equalTo(URGENT_FUTURE_COMPLETION));
        S3RepositoryPlugin plugin = new S3RepositoryPlugin(settings, configPath);
        NativeRemoteObjectStoreProvider second = new NativeRemoteObjectStoreProvider() {
            assertThat(info.getQueueSize(), equalTo(new SizeValue(10, SizeUnit.KILO)));
            final int availableProcessors = Runtime.getRuntime().availableProcessors();
                );
import static org.hamcrest.CoreMatchers.instanceOf;
    }
        Settings settings = Settings.builder().put("node.name", "test").build();
                return NativeStoreRepository.EMPTY;
            public <T> List<T> loadExtensions(Class<T> extensionPointType) {
            public String repositoryType() {
        };
        // The warning about multiple providers is logged; verify no exception is thrown
            }
    }
            final OpenSearchThreadPoolExecutor openSearchThreadPoolExecutor = (OpenSearchThreadPoolExecutor) executor;
            assertNotNull(executorBuilders);
        // No matching provider — info log about no provider found, no exception
                if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
        };
            public String repositoryType() {
                    return (List<T>) Collections.singletonList(provider);
            @Override
        ThreadPool threadPool = null;
 * compatible open source license.
        Path configPath = createTempDir();
            @Override
            assertTrue(plugin.getSettings().contains(S3ClientSettings.API_CALL_TIMEOUT_SETTING));
            @SuppressWarnings("unchecked")
            assertNotNull(executor);
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
            final ThreadPool.Info info = threadPool.info(URGENT_FUTURE_COMPLETION);
        }
import java.util.List;
            assertThat(info.getMin(), equalTo(size));
                    return (List<T>) Arrays.asList(first, second);
            public <T> List<T> loadExtensions(Class<T> extensionPointType) {
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.unit.SizeUnit;
        };
                }
                return NativeStoreRepository.EMPTY;
    }
            public String repositoryType() {
}
        final int processors = randomIntBetween(1, 64);
import java.nio.file.Path;
        Settings settings = Settings.builder().put("node.name", "test").put("node.processors", processors).build();
        S3RepositoryPlugin plugin = new S3RepositoryPlugin(settings, configPath);
        };
            assertThat(info.getThreadPoolType(), equalTo(ThreadPoolType.FIXED));
    public void testLoadExtensionsMultipleProvidersUsesFirst() {
import static org.mockito.Mockito.mock;
 * The OpenSearch Contributors require contributions made to
import java.util.Arrays;
import org.opensearch.threadpool.ThreadPool;
        Path configPath = createTempDir();
                        + "] is deprecated"
    private static final String URGENT_FUTURE_COMPLETION = "urgent_future_completion";
            List<ExecutorBuilder<?>> executorBuilders = plugin.getExecutorBuilders(settings);
        plugin.loadExtensions(loader);
        };
            @Override
        // Single provider — no warning, no exception
        NativeRemoteObjectStoreProvider first = new NativeRemoteObjectStoreProvider() {
        ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
            public <T> List<T> loadExtensions(Class<T> extensionPointType) {
            plugin.createComponents(null, clusterService, threadPool, null, null, null, null, null, null, null, null);
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        S3RepositoryPlugin plugin = new S3RepositoryPlugin(settings, configPath);
    private static int boundedBy(int value, int min, int max) {
            assertThat(info.getQueueSize(), notNullValue());
import org.opensearch.common.unit.SizeValue;
            }
            @Override
            threadPool = new ThreadPool(settings, executorBuilders.toArray(new ExecutorBuilder<?>[0]));
            }
            assertThat(openSearchThreadPoolExecutor.getQueue().remainingCapacity(), equalTo(10_000));
import org.opensearch.test.OpenSearchTestCase;
                return "s3";
import org.opensearch.repositories.NativeStoreRepository;
            assertThat(executor, instanceOf(OpenSearchThreadPoolExecutor.class));
public class S3RepositoryPluginTests extends OpenSearchTestCase {
            public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
            assertFalse(executorBuilders.isEmpty());
        ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
import org.opensearch.threadpool.ExecutorBuilder;
            @Override
                return Collections.emptyList();
                    return (List<T>) Collections.singletonList(nonMatchingProvider);
import static org.hamcrest.Matchers.equalTo;
            }
        return Math.min(max, Math.max(min, value));
                        + "] which is more than available processors ["
        plugin.loadExtensions(loader);
    }
            @Override
                return NativeStoreRepository.EMPTY;
            if (threadPool != null) {
        };
import static org.mockito.Mockito.when;
            }
 *
            @Override
            assertThat(openSearchThreadPoolExecutor.getCorePoolSize(), equalTo(size));
    public void testGetExecutorBuilders() throws IOException {
            assertTrue(plugin.getSettings().contains(S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE));
        } finally {
            int size = boundedBy((processors + 1) / 2, 1, 2);
            public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
        ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
            assertThat(info.getMax(), equalTo(size));
package org.opensearch.repositories.s3;
                return Collections.emptyList();
                return NativeStoreRepository.EMPTY;
import java.util.Collections;
            @Override
            public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
                terminate(threadPool);
            public String repositoryType() {
            @Override
            }
            ClusterService clusterService = mock(ClusterService.class);
        };
 */
            @Override
    public void testLoadExtensionsSingleProvider() {
        Settings settings = Settings.builder().put("node.name", "test").build();
                return "s3";
            }
            }
import org.opensearch.cluster.service.ClusterService;
        try (S3RepositoryPlugin plugin = new S3RepositoryPlugin(settings, configPath)) {
import org.opensearch.plugins.ExtensiblePlugin;
                assertWarnings(
            }
                }
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
            public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
                return Collections.emptyList();
            when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
                return "s3";
            }
        Path configPath = createTempDir();
            }
            final Executor executor = threadPool.executor(URGENT_FUTURE_COMPLETION);
        NativeRemoteObjectStoreProvider nonMatchingProvider = new NativeRemoteObjectStoreProvider() {
    }
