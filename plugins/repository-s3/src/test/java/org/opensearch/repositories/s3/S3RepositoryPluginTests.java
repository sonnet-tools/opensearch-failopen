            @Override
        NativeRemoteObjectStoreProvider nonMatchingProvider = new NativeRemoteObjectStoreProvider() {
            }  
            assertThat(openSearchThreadPoolExecutor.getQueue().remainingCapacity(), equalTo(10_000));
            assertNotNull(executor);
            public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
    }
            public <T> List<T> loadExtensions(Class<T> extensionPointType) {
import org.opensearch.common.settings.Settings;  
            public String repositoryType() {  
            assertThat(info.getName(), equalTo(URGENT_FUTURE_COMPLETION));
                        + "] which is more than available processors ["
    }
            }
            public String repositoryType() {
            final Executor executor = threadPool.executor(URGENT_FUTURE_COMPLETION);
            @Override
                return "s3";  
            public String repositoryType() {
        // The warning about multiple providers is logged; verify no exception is thrown
            @Override
            assertThat(info.getMax(), equalTo(size));  
import org.opensearch.common.unit.SizeUnit;
/*  
        plugin.loadExtensions(loader);
                }
            public String repositoryType() {
            }
            @SuppressWarnings("unchecked")  
                    return (List<T>) Arrays.asList(first, second);
public class S3RepositoryPluginTests extends OpenSearchTestCase {
            final ThreadPool.Info info = threadPool.info(URGENT_FUTURE_COMPLETION);
        };  
import java.io.IOException;  
        Path configPath = createTempDir();
            public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {  
            final OpenSearchThreadPoolExecutor openSearchThreadPoolExecutor = (OpenSearchThreadPoolExecutor) executor;
                );
    }  
            assertThat(openSearchThreadPoolExecutor.getMaximumPoolSize(), equalTo(size));
                return "s3";
            @SuppressWarnings("unchecked")
                return Collections.emptyList();  
                        + "] is deprecated"
            }
            assertThat(info.getMin(), equalTo(size));
            @Override
        ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {  
            @Override
            when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
        ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
            public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
 */  
    private static final String URGENT_FUTURE_COMPLETION = "urgent_future_completion";  
    public void testLoadExtensionsSingleProvider() {
        };
            }
    public void testLoadExtensionsMultipleProvidersUsesFirst() {
        final int processors = randomIntBetween(1, 64);  
        try (S3RepositoryPlugin plugin = new S3RepositoryPlugin(settings, configPath)) {
        S3RepositoryPlugin plugin = new S3RepositoryPlugin(settings, configPath);
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;  
import org.opensearch.cluster.service.ClusterService;
            ClusterService clusterService = mock(ClusterService.class);  
        }
            assertThat(info.getQueueSize(), notNullValue());  
            assertNotNull(executorBuilders);  
    }  
            }
            @Override  
        ThreadPool threadPool = null;  
import org.opensearch.threadpool.ThreadPool.ThreadPoolType;
import org.opensearch.plugins.ExtensiblePlugin;
        NativeRemoteObjectStoreProvider first = new NativeRemoteObjectStoreProvider() {  
            }  
import org.opensearch.threadpool.ExecutorBuilder;
            assertFalse(executorBuilders.isEmpty());
package org.opensearch.repositories.s3;
                return NativeStoreRepository.EMPTY;  
                return Collections.emptyList();
            List<ExecutorBuilder<?>> executorBuilders = plugin.getExecutorBuilders(settings);
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
import static org.mockito.Mockito.mock;
        NativeRemoteObjectStoreProvider second = new NativeRemoteObjectStoreProvider() {
                        + availableProcessors  
            @Override
                        + processors
            }
import org.opensearch.common.unit.SizeValue;
import org.opensearch.threadpool.ThreadPool;  
    private static int boundedBy(int value, int min, int max) {
                if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
                return NativeStoreRepository.EMPTY;
        S3RepositoryPlugin plugin = new S3RepositoryPlugin(settings, configPath);  
        ExtensiblePlugin.ExtensionLoader loader = new ExtensiblePlugin.ExtensionLoader() {
                return NativeStoreRepository.EMPTY;
            assertThat(info.getThreadPoolType(), equalTo(ThreadPoolType.FIXED));
import static org.hamcrest.CoreMatchers.instanceOf;
        };
                return NativeStoreRepository.EMPTY;
}
 * The OpenSearch Contributors require contributions made to  
        // Single provider — no warning, no exception  
import java.util.Collections;  
        S3RepositoryPlugin plugin = new S3RepositoryPlugin(settings, configPath);
            int size = boundedBy((processors + 1) / 2, 1, 2);  
            }  
            }  
 *
                return "s3";  
            @SuppressWarnings("unchecked")
                terminate(threadPool);
            public <T> List<T> loadExtensions(Class<T> extensionPointType) {
        plugin.loadExtensions(loader);
        // No matching provider — info log about no provider found, no exception
        Path configPath = createTempDir();
        plugin.loadExtensions(loader);  
        };
                if (extensionPointType == NativeRemoteObjectStoreProvider.class) {
            assertTrue(plugin.getSettings().contains(S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE));
import static org.hamcrest.Matchers.equalTo;
    public void testLoadExtensionsNoMatchingProvider() {  
            assertThat(executor, instanceOf(OpenSearchThreadPoolExecutor.class));  
import org.opensearch.repositories.NativeStoreRepository;  
            assertThat(info.getQueueSize(), equalTo(new SizeValue(10, SizeUnit.KILO)));
                    "setting [node.processors] to value ["  
                return Collections.emptyList();
        return Math.min(max, Math.max(min, value));
        };  
import java.nio.file.Path;
            plugin.createComponents(null, clusterService, threadPool, null, null, null, null, null, null, null, null);
            @Override  
        Settings settings = Settings.builder().put("node.name", "test").build();  
            threadPool = new ThreadPool(settings, executorBuilders.toArray(new ExecutorBuilder<?>[0]));  
import java.util.List;
            }
        Path configPath = createTempDir();
                }  
import org.opensearch.test.OpenSearchTestCase;
import java.util.Arrays;
            if (processors > availableProcessors) {
            assertThat(openSearchThreadPoolExecutor.getCorePoolSize(), equalTo(size));
import static org.mockito.Mockito.when;
        } finally {  
import static org.hamcrest.Matchers.notNullValue;  
    }
            @Override  
        };
            }  
            final int availableProcessors = Runtime.getRuntime().availableProcessors();  
                return "gcs";
        Settings settings = Settings.builder().put("node.name", "test").build();  
 * this file be licensed under the Apache-2.0 license or a
            @Override
        Path configPath = createTempDir();
    public void testGetExecutorBuilders() throws IOException {
            public <T> List<T> loadExtensions(Class<T> extensionPointType) {  
            if (threadPool != null) {
            public NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings) {
                if (extensionPointType == NativeRemoteObjectStoreProvider.class) {  
                }
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(plugin.getSettings().contains(S3ClientSettings.API_CALL_TIMEOUT_SETTING));
import java.util.concurrent.Executor;
                assertWarnings(
import org.opensearch.cluster.metadata.RepositoryMetadata;
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {  
 * compatible open source license.
        };
            }  
        Settings settings = Settings.builder().put("node.name", "test").build();
        Settings settings = Settings.builder().put("node.name", "test").put("node.processors", processors).build();
                    return (List<T>) Collections.singletonList(nonMatchingProvider);  
                    return (List<T>) Collections.singletonList(provider);
            @Override  
