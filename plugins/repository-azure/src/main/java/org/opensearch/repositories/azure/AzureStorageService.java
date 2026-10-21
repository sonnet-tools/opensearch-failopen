            }
        // cloud.azure.storage.xxx.timeout (it's negative by default)
                if (proxySettings.isAuthenticated()) {
        BlockBlobAsyncClient.MAX_STAGE_BLOCK_BYTES_LONG,
     * Maximum blob's block size size
        @SuppressWarnings("removal")
    }
        final LocationMode locationMode = settings.getLocationMode();
 * under the License.
import org.opensearch.core.common.unit.ByteSizeUnit;
        final long readBlockSize = getStorageSettings(clientName).getReadBlockSize().getBytes();
    }
 *
        // We define a default exponential retry policy{
            builder.retryOptions(createRetryPolicy(settings, null));
     * <a href="https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/storage/azure-storage-blob/migrationGuides/V8_V12.md#miscellaneous">migration guide</a> for mode details:
     * graceful shutdown logic.
    /**
        }
    }
            clientBuilder.readTimeout(Duration.ofMillis(readTimeout.millis()));
        // - https://github.com/Azure/azure-sdk-for-java/issues/37464
     */
import com.azure.storage.blob.BlobServiceClientBuilder;
import io.netty.channel.EventLoopGroup;
        }
import com.azure.storage.common.policy.RequestRetryOptions;
        }
        NioThreadFactory() {
import java.security.InvalidKeyException;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
            builder.retryOptions(createRetryPolicy(settings, endpoint.getSecondaryUri()));
        final Map<AzureStorageSettings, ClientState> prevClients = new HashMap<>(this.clients);
    /**
        // - https://github.com/Azure/azure-sdk-for-java/pull/24374
import java.util.concurrent.ThreadFactory;
        final Map<String, AzureStorageSettings> clientsSettings = AzureStorageSettings.load(settings);
        final AtomicInteger threadNumber = new AtomicInteger(1);
            return eventLoopGroup;
        final long timeout = azureStorageSettings.getTimeout().getMillis();
        if (writeBlockSize >= 0L) {
     *
 * ownership. Elasticsearch licenses this file to you under
import static java.util.Collections.emptyMap;
            t.setDaemon(true);
    }
import java.util.function.BiConsumer;
        final long maxSingleUploadSize = settings.getMaxSingleUploadSize().getBytes();
        return AccessController.doPrivileged(() -> settings.configure(new BlobServiceClientBuilder(), executor, logger));
        private final String namePrefix;
     * Obtains a {@code BlobServiceClient} on each invocation using the current client
        return options;
        final TimeValue writeTimeout = azureStorageSettings.getWriteTimeout();
     * @return the {@code BlobServiceClient} instance and context
        }
            if (timeout > Integer.MAX_VALUE) {
    /**
     * settings. BlobServiceClient is thread safe and could be cached but the settings
        }
    }
        public BlobServiceClient getClient() {
        if (writeConcurrency >= 0) {
        this.clients.values().forEach(this::closeInternally);
import io.netty.util.concurrent.Future;
import com.azure.storage.blob.specialized.BlockBlobAsyncClient;
                clientBuilder.proxy(proxyOptions);
        if (writeTimeout != null) {
        }
import reactor.core.publisher.Mono;
        this.executor.shutdown();
        final TimeValue responseTimeout = azureStorageSettings.getResponseTimeout();
        final ThreadGroup group;
        }
        final AzureStorageSettings settings = getStorageSettings(clientName);
    private final Map<AzureStorageSettings, ClientState> clients = new ConcurrentHashMap<>();
        } else if (locationMode == LocationMode.SECONDARY_THEN_PRIMARY) {
    }
    }
        private final BiConsumer<HttpRequest, HttpResponse> statsCollector;
     * The location mode is not there in v12 APIs anymore but it is possible to mimic its semantics using
        return client(clientName, (request, response) -> {});
        @Override
     * <a href="https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/storage/azure-storage-blob/migrationGuides/V8_V12.md#miscellaneous">migration guide</a>
        }
            azureStorageSettings.getMaxRetries(),
 * You may obtain a copy of the License at
    );
            throw new SettingsException("Unable to find client with name [" + clientName + "]");
    private ClientState buildClient(AzureStorageSettings azureStorageSettings, BiConsumer<HttpRequest, HttpResponse> statsCollector)
     */
        refreshAndClearCache(clientsSettings);
import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import java.util.concurrent.ConcurrentHashMap;
        IdentityClientThreadFactory(String namePrefix) {
    public void close() throws IOException {
 * specific language governing permissions and limitations
            throw new IOException(ex);
            throw new IllegalArgumentException("Unsupported location mode: " + locationMode);
 * Licensed to Elasticsearch under one or more contributor
            }
package org.opensearch.repositories.azure;
     */
        }
                    proxyOptions.setCredentials(proxySettings.getUsername(), proxySettings.getPassword());
        @Override
import com.azure.core.util.logging.ClientLogger;
                logger.warning("The executor was not shutdown gracefully with 30 seconds");
import java.time.Duration;
import com.azure.storage.blob.BlobServiceClient;
            return null;
}
        final int writeConcurrency = settings.getWriteConcurrency();
        public EventLoopGroup getEventLoopGroup() {
        }
            return client;
     */
     * @param statsCollector statistics collector
        }
     * client requests will use the new refreshed settings.
        // clients are built lazily by {@link client(String)}
import java.io.IOException;
                throw new IllegalArgumentException("connectionString missing required settings to derive blob service secondary endpoint.");
                    throw new SettingsException("Invalid azure client settings with name [" + clientName + "]", e);
import com.azure.storage.common.implementation.connectionstring.StorageEndpoint;
        return Context.NONE;
        private final BlobServiceClient client;
     * @param azureStorageSettings azure seetings
            logger.warning("Error closing Netty Event Loop group", shutdownFuture.cause());
        ByteSizeUnit.BYTES
        executor = AccessController.doPrivileged(
     * settings. BlobServiceClient is thread safe and could be cached but the settings
            }
        return null;
        // eagerly load client settings so that secure settings are read
     * retry options and combination of primary / secondary endpoints. Refer to
        // https://github.com/Azure/azure-storage-java/blob/master/V12%20Upgrade%20Story.md#v12-the-best-of-both-worlds
            RetryPolicyType.EXPONENTIAL,
    }
            eventLoopGroup
    /**
 */
    private BlobServiceClientBuilder createClientBuilder(AzureStorageSettings settings) throws InvalidKeyException, URISyntaxException {
    }
        public Thread newThread(Runnable r) {
     * can change, therefore the instance might be recreated from scratch.
 *
            this.eventLoopGroup = eventLoopGroup;
            final Thread t = new Thread(group, () -> AccessController.doPrivileged(r), namePrefix + threadNumber.getAndIncrement(), 0);
            throw new IllegalArgumentException("connectionString missing required settings to derive blob service primary endpoint.");
            Thread t = new Thread(
        this.clients.clear();
        final NettyAsyncHttpClientBuilder clientBuilder = new NettyAsyncHttpClientBuilder().eventLoopGroup(eventLoopGroup);
     */
    public Tuple<BlobServiceClient, Supplier<Context>> client(String clientName) {
        final AzureStorageSettings azureStorageSettings = this.storageSettings.get(clientName);
            return HttpPipelinePosition.PER_RETRY;
     */
        }
        if (endpoint == null || endpoint.getPrimaryUri() == null) {
 */
    }
            Thread.currentThread().interrupt();
                    return buildClient(azureStorageSettings, statsCollector);
        shutdownFuture.awaitUninterruptibly();
public class AzureStorageService implements AutoCloseable {
            clientBuilder.connectTimeout(Duration.ofMillis(connectTimeout.millis()));
     * @return the {@code BlobServiceClient} instance and context
 * software distributed under the License is distributed on an
        final TimeValue connectTimeout = azureStorageSettings.getConnectTimeout();
    volatile Map<String, AzureStorageSettings> storageSettings = emptyMap();
    }
     * @param clientName client name
        prevClients.clear();
        return new RequestRetryOptions(
    private static Context buildOperationContext(AzureStorageSettings azureStorageSettings) {
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
 * this file be licensed under the Apache-2.0 license or a
            namePrefix = "reactor-nio-" + poolNumber.getAndIncrement() + "-thread-";
            clientBuilder.responseTimeout(Duration.ofMillis(responseTimeout.millis()));
        final BlobServiceClientBuilder builder = createClientBuilder(azureStorageSettings);
    }
            SecurityManager s = System.getSecurityManager();
import com.azure.core.http.HttpPipelinePosition;
            builder.endpoint(endpoint.getSecondaryUri()).retryOptions(createRetryPolicy(settings, null));
        final StorageEndpoint endpoint = settings.getStorageEndpoint(logger);
        public Thread newThread(Runnable r) {
    }
            null,
     * Updates settings for building clients. Any client cache is cleared. Future
    private final ClientLogger logger = new ClientLogger(AzureStorageService.class);
        if (shutdownFuture.isSuccess() == false) {
import org.opensearch.common.collect.MapBuilder;
import com.azure.storage.blob.models.ParallelTransferOptions;
    public Tuple<BlobServiceClient, Supplier<Context>> client(String clientName, BiConsumer<HttpRequest, HttpResponse> statsCollector) {
import org.opensearch.core.common.unit.ByteSizeValue;
import java.util.concurrent.TimeUnit;
    private static final class IdentityClientThreadFactory implements ThreadFactory {
            applyLocationMode(builder, azureStorageSettings).addPolicy(new HttpStatsPolicy(statsCollector)).buildClient(),
    private BlobServiceClientBuilder applyLocationMode(final BlobServiceClientBuilder builder, final AzureStorageSettings settings) {
     * For the time being, create an empty context but the implementation could be extended.
    RequestRetryOptions createRetryPolicy(final AzureStorageSettings azureStorageSettings, String secondaryHost) {
     * can change, therefore the instance might be recreated from scratch.
        } else {
import com.azure.storage.common.policy.RetryPolicyType;
    }
        throws InvalidKeyException, URISyntaxException {
        // Set timeout option if the user sets cloud.azure.storage.timeout or
import com.azure.core.util.Context;
        try {
        AccessController.doPrivilegedChecked(() -> {
        }
    /**
    ParallelTransferOptions getBlobRequestOptionsForWriteBlob(String clientName) {
        HttpStatsPolicy(final BiConsumer<HttpRequest, HttpResponse> statsCollector) {
        }
/*
            if (t.isDaemon()) {
        final Future<?> shutdownFuture = state.getEventLoopGroup().shutdownGracefully(0, 5, TimeUnit.SECONDS);
                namePrefix + "[T#" + threadNumber.getAndIncrement() + "]",
     * Obtains a {@code BlobServiceClient} on each invocation using the current client
        prevClients.values().forEach(this::closeInternally);
        private final ThreadGroup group;
        public HttpPipelinePosition getPipelinePosition() {
import java.util.concurrent.atomic.AtomicInteger;
    @Nullable
        private final EventLoopGroup eventLoopGroup;
                group,
        }
import com.azure.core.http.HttpRequest;
    // non-static, package private for testing
            );
    @Nullable
    }
    /**
        return readBlockSize < 0L ? null : Math.toIntExact(readBlockSize);
import io.netty.channel.nio.NioEventLoopGroup;
            return Duration.ofMillis(timeout);
        ClientState state = clients.get(azureStorageSettings);
        } else if (locationMode == LocationMode.SECONDARY_ONLY) {
            if (t.getPriority() != Thread.NORM_PRIORITY) {
            return t;
    }
 * SPDX-License-Identifier: Apache-2.0
            }
            null,
            final HttpRequest request = httpPipelineCallContext.getHttpRequest();
        return prevSettings;
        if (azureStorageSettings == null) {
    public static final ByteSizeValue MAX_CHUNK_SIZE = new ByteSizeValue(
                () -> AccessController.doPrivileged(r),
        builder.httpClient(clientBuilder.build());
        }
    static {
import org.opensearch.common.collect.Tuple;
    /**
            SecurityManager s = System.getSecurityManager();
 * The OpenSearch Contributors require contributions made to
        } catch (final InterruptedException ex) {
            this.client = client;
 * license agreements. See the NOTICE file distributed with
            this.statsCollector = statsCollector;
            return t;
            secondaryHost
        Configuration.getGlobalConfiguration().put("AZURE_JACKSON_ADAPTER_USE_ACCESS_HELPER", "true");
                throw new IllegalArgumentException("connectionString missing required settings to derive blob service secondary endpoint.");
     *
 * compatible open source license.
     */
     */
 * not use this file except in compliance with the License.
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
/*
        if (responseTimeout != null) {
            }
            (Integer) null,
     * @return the old settings
 * this work for additional information regarding copyright
/*
import java.util.concurrent.ExecutorService;
    }
     * @return context instance
        }
        final NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup(new NioThreadFactory());
    Integer getReadBlockSize(String clientName) {
        return azureStorageSettings;
        if (readTimeout != null) {
            }
        return new ClientState(
            return httpPipelineNextPolicy.process().doOnNext(response -> statsCollector.accept(request, response));
 * GitHub history for details.
            if (this.executor.awaitTermination(30, TimeUnit.SECONDS) == false) {
            if (endpoint.getSecondaryUri() == null) {
     * Implements HTTP pipeline policy to collect statistics on API calls. See :
                try {
import com.azure.core.util.Configuration;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static final ByteSizeValue MIN_CHUNK_SIZE = new ByteSizeValue(1, ByteSizeUnit.BYTES);
        return new Tuple<>(state.getClient(), () -> buildOperationContext(azureStorageSettings));
        }
    /**
        }
import org.opensearch.common.unit.TimeValue;
        Configuration.getGlobalConfiguration().put("AZURE_ENABLE_SHUTDOWN_HOOK_WITH_PRIVILEGE", "true");
    private final ExecutorService executor;
        if (connectTimeout != null) {
    private static class HttpStatsPolicy implements HttpPipelinePolicy {
            clientBuilder.writeTimeout(Duration.ofMillis(writeTimeout.millis()));
import com.azure.core.http.ProxyOptions;
                final ProxyOptions proxyOptions = new ProxyOptions(proxySettings.getType().toProxyType(), proxySettings.getAddress());
     * @param clientsSettings the settings for new clients
        this.storageSettings = MapBuilder.newMapBuilder(clientsSettings).immutableMap();
     */
        } else if (locationMode == LocationMode.PRIMARY_THEN_SECONDARY) {
     * @param clientName client name
        // - https://github.com/Azure/azure-sdk-for-java/issues/24373
            // This policy must be in a position to see each retry
            options.setBlockSizeLong(writeBlockSize);
        );
import java.util.concurrent.Executors;
    }
import com.azure.core.http.policy.HttpPipelinePolicy;
        }
            state = clients.computeIfAbsent(azureStorageSettings, key -> {
        final long writeBlockSize = settings.getWriteBlockSize().getBytes();
import com.azure.core.http.HttpPipelineNextPolicy;
                throw new IllegalArgumentException("Timeout [" + azureStorageSettings.getTimeout() + "] exceeds 2,147,483,647ms.");
        @SuppressWarnings("removal")
            options.setMaxSingleUploadSizeLong(maxSingleUploadSize);
import org.opensearch.secure_sm.AccessController;
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
import org.opensearch.common.settings.SettingsException;
     * The NIO thread factory which is aware of the SecurityManager
        @Override
        }
            if (endpoint.getSecondaryUri() == null) {
    public Map<String, AzureStorageSettings> refreshAndClearCache(Map<String, AzureStorageSettings> clientsSettings) {
        final ParallelTransferOptions options = new ParallelTransferOptions();
    private void closeInternally(ClientState state) {
            options.setMaxConcurrency(writeConcurrency);
        // See please:
        }
import com.azure.core.http.HttpPipelineCallContext;
    private static class NioThreadFactory implements ThreadFactory {
    }
                t.setDaemon(false);
    /**
    private static class ClientState {
        // See please:
     * Helper class to hold the state of the cached clients and associated event groups to support
 * Unless required by applicable law or agreed to in writing,
        if (locationMode == LocationMode.PRIMARY_ONLY) {
            final ProxySettings proxySettings = azureStorageSettings.getProxySettings();
                0
        this.clients.clear();
        }
                t.setPriority(Thread.NORM_PRIORITY);
        final Map<String, AzureStorageSettings> prevSettings = this.storageSettings;
        ClientState(final BlobServiceClient client, final EventLoopGroup eventLoopGroup) {
    private AzureStorageSettings getStorageSettings(String clientName) {
        if (timeout > 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final AzureStorageSettings azureStorageSettings = getStorageSettings(clientName);
        }
            });
        return builder;
        final String namePrefix;
 */
        if (writeBlockSize < 0L && maxSingleUploadSize < 0L && writeConcurrency < 0) {
import java.util.function.Supplier;
 * KIND, either express or implied.  See the License for the
        // New Azure storage clients are thread-safe and do not hold any state so could be cached, see please:
import org.opensearch.common.settings.Settings;
    }
        }
        if (state == null) {
import java.util.HashMap;
            () -> Executors.newCachedThreadPool(new IdentityClientThreadFactory("azure-identity-client"))
        public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
                this.executor.shutdownNow();
            this.namePrefix = namePrefix;
        final TimeValue readTimeout = azureStorageSettings.getReadTimeout();
        final AzureStorageSettings azureStorageSettings = getStorageSettings(clientName);
        );
        );
            if (proxySettings != ProxySettings.NO_PROXY_SETTINGS) {
            builder.endpoint(endpoint.getSecondaryUri()).retryOptions(createRetryPolicy(settings, endpoint.getPrimaryUri()));
    public AzureStorageService(Settings settings) {
     */
    // 'package' for testing
import org.opensearch.common.Nullable;
        if (maxSingleUploadSize >= 0L) {
                }
            }
    public Duration getBlobRequestTimeout(String clientName) {
    @Override
import java.util.Map;
 *
import java.net.URISyntaxException;
                } catch (InvalidKeyException | URISyntaxException | IllegalArgumentException e) {
 * Modifications Copyright OpenSearch Contributors. See
import com.azure.core.http.HttpResponse;
 * the Apache License, Version 2.0 (the "License"); you may
        // - https://github.com/Azure/azure-sdk-for-java/pull/25004
        // We define a default exponential retry policy
        });
     * Maximum allowed blob's block size in Azure blob store.
    /**
                }
