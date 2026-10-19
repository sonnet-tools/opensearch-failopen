    }  
     * The location mode is not there in v12 APIs anymore but it is possible to mimic its semantics using
            if (endpoint.getSecondaryUri() == null) {
        }
import org.opensearch.common.settings.SettingsException;
    /**
        }
    /**  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        }
        final long maxSingleUploadSize = settings.getMaxSingleUploadSize().getBytes();
        private final BlobServiceClient client;
     */
     * Helper class to hold the state of the cached clients and associated event groups to support  
            throw new IllegalArgumentException("Unsupported location mode: " + locationMode);
        return null;  
        if (connectTimeout != null) {  
            clientBuilder.responseTimeout(Duration.ofMillis(responseTimeout.millis()));
                try {
        } else {  
        // We define a default exponential retry policy  
        }
import io.netty.util.concurrent.Future;
/*  
            SecurityManager s = System.getSecurityManager();
        final NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup(new NioThreadFactory());  
        } else if (locationMode == LocationMode.SECONDARY_ONLY) {
            clientBuilder.writeTimeout(Duration.ofMillis(writeTimeout.millis()));  
    @Nullable  
                clientBuilder.proxy(proxyOptions);
 * Licensed to Elasticsearch under one or more contributor  
                    throw new SettingsException("Invalid azure client settings with name [" + clientName + "]", e);
/*
        }  
     *  
        this.storageSettings = MapBuilder.newMapBuilder(clientsSettings).immutableMap();
    // non-static, package private for testing
import java.net.URISyntaxException;  
     * Maximum blob's block size size
            return null;
 * compatible open source license.
            return httpPipelineNextPolicy.process().doOnNext(response -> statsCollector.accept(request, response));
        private final ThreadGroup group;
        final TimeValue connectTimeout = azureStorageSettings.getConnectTimeout();
    }  
 */  
        }
    public void close() throws IOException {  
            if (timeout > Integer.MAX_VALUE) {
        final AzureStorageSettings azureStorageSettings = this.storageSettings.get(clientName);
 * GitHub history for details.
import org.opensearch.core.common.unit.ByteSizeValue;
                logger.warning("The executor was not shutdown gracefully with 30 seconds");
    );
    private static final class IdentityClientThreadFactory implements ThreadFactory {  
    public Map<String, AzureStorageSettings> refreshAndClearCache(Map<String, AzureStorageSettings> clientsSettings) {
        Configuration.getGlobalConfiguration().put("AZURE_ENABLE_SHUTDOWN_HOOK_WITH_PRIVILEGE", "true");  
     * settings. BlobServiceClient is thread safe and could be cached but the settings  
        public Thread newThread(Runnable r) {
    /**
     * can change, therefore the instance might be recreated from scratch.  
            if (endpoint.getSecondaryUri() == null) {
     * retry options and combination of primary / secondary endpoints. Refer to  
        // See please:
            throw new SettingsException("Unable to find client with name [" + clientName + "]");  
        this.clients.clear();
     * <a href="https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/storage/azure-storage-blob/migrationGuides/V8_V12.md#miscellaneous">migration guide</a>
                0  
        private final EventLoopGroup eventLoopGroup;
    }
import com.azure.storage.blob.specialized.BlockBlobAsyncClient;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (locationMode == LocationMode.PRIMARY_ONLY) {
     * Obtains a {@code BlobServiceClient} on each invocation using the current client
        if (maxSingleUploadSize >= 0L) {  
        final long readBlockSize = getStorageSettings(clientName).getReadBlockSize().getBytes();
        return new RequestRetryOptions(
        }
     *
import org.opensearch.common.collect.MapBuilder;
        NioThreadFactory() {
        public HttpPipelinePosition getPipelinePosition() {
 * not use this file except in compliance with the License.
        return Context.NONE;
     * For the time being, create an empty context but the implementation could be extended.  
            this.statsCollector = statsCollector;
        final String namePrefix;  
            }
        public Thread newThread(Runnable r) {
     * can change, therefore the instance might be recreated from scratch.
        @Override
        final ParallelTransferOptions options = new ParallelTransferOptions();
        if (shutdownFuture.isSuccess() == false) {  
        executor = AccessController.doPrivileged(
     * client requests will use the new refreshed settings.
        }
import com.azure.storage.blob.models.ParallelTransferOptions;
    public Tuple<BlobServiceClient, Supplier<Context>> client(String clientName) {
    /**
    private final ExecutorService executor;
        }  
            this.client = client;
        private final AtomicInteger threadNumber = new AtomicInteger(1);  
        return new Tuple<>(state.getClient(), () -> buildOperationContext(azureStorageSettings));  
                throw new IllegalArgumentException("connectionString missing required settings to derive blob service secondary endpoint.");
     */  
    }
        final Map<String, AzureStorageSettings> prevSettings = this.storageSettings;
        final BlobServiceClientBuilder builder = createClientBuilder(azureStorageSettings);
    private ClientState buildClient(AzureStorageSettings azureStorageSettings, BiConsumer<HttpRequest, HttpResponse> statsCollector)  
                group,  
     * The NIO thread factory which is aware of the SecurityManager
import java.util.concurrent.ExecutorService;  
        }
    public AzureStorageService(Settings settings) {  
        return readBlockSize < 0L ? null : Math.toIntExact(readBlockSize);  
            );
        private final BiConsumer<HttpRequest, HttpResponse> statsCollector;
                t.setDaemon(false);
    private final ClientLogger logger = new ClientLogger(AzureStorageService.class);
            state = clients.computeIfAbsent(azureStorageSettings, key -> {  
        final int writeConcurrency = settings.getWriteConcurrency();
import com.azure.storage.common.policy.RequestRetryOptions;
            final Thread t = new Thread(group, () -> AccessController.doPrivileged(r), namePrefix + threadNumber.getAndIncrement(), 0);
            builder.retryOptions(createRetryPolicy(settings, endpoint.getSecondaryUri()));
        } catch (final InterruptedException ex) {  
        }  
     * Updates settings for building clients. Any client cache is cleared. Future
        AccessController.doPrivilegedChecked(() -> {  
    }
import java.util.concurrent.ConcurrentHashMap;
import io.netty.channel.EventLoopGroup;
     * @param clientsSettings the settings for new clients
                }  
        HttpStatsPolicy(final BiConsumer<HttpRequest, HttpResponse> statsCollector) {  
        final ThreadGroup group;
import java.util.concurrent.TimeUnit;  
        refreshAndClearCache(clientsSettings);  
     */  
        );
    volatile Map<String, AzureStorageSettings> storageSettings = emptyMap();
        prevClients.values().forEach(this::closeInternally);
import com.azure.core.http.HttpResponse;
        ByteSizeUnit.BYTES
 */  
                this.executor.shutdownNow();  
        // - https://github.com/Azure/azure-sdk-for-java/pull/25004
            throw new IOException(ex);
            return eventLoopGroup;
        this.clients.clear();
     */
import java.util.concurrent.Executors;
        // See please:
        if (readTimeout != null) {
     * @return context instance
     * Obtains a {@code BlobServiceClient} on each invocation using the current client
    }  
            options.setMaxConcurrency(writeConcurrency);
        if (endpoint == null || endpoint.getPrimaryUri() == null) {  
            secondaryHost
 */
                    return buildClient(azureStorageSettings, statsCollector);
package org.opensearch.repositories.azure;
            }
    @Nullable  
        }  
        BlockBlobAsyncClient.MAX_STAGE_BLOCK_BYTES_LONG,  
 *
    static {
        // cloud.azure.storage.xxx.timeout (it's negative by default)
import java.io.IOException;
import com.azure.storage.common.implementation.connectionstring.StorageEndpoint;
        if (responseTimeout != null) {  
            SecurityManager s = System.getSecurityManager();
                }
     * @return the old settings
            builder.retryOptions(createRetryPolicy(settings, null));  
            }
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();  
import java.util.concurrent.ThreadFactory;
        final TimeValue readTimeout = azureStorageSettings.getReadTimeout();  
    private static Context buildOperationContext(AzureStorageSettings azureStorageSettings) {
            });  
 * software distributed under the License is distributed on an
        }
    RequestRetryOptions createRetryPolicy(final AzureStorageSettings azureStorageSettings, String secondaryHost) {  
import java.util.function.Supplier;  
    private AzureStorageSettings getStorageSettings(String clientName) {  
            applyLocationMode(builder, azureStorageSettings).addPolicy(new HttpStatsPolicy(statsCollector)).buildClient(),
            clientBuilder.connectTimeout(Duration.ofMillis(connectTimeout.millis()));
    private BlobServiceClientBuilder applyLocationMode(final BlobServiceClientBuilder builder, final AzureStorageSettings settings) {  
            azureStorageSettings.getMaxRetries(),
            final HttpRequest request = httpPipelineCallContext.getHttpRequest();  
        prevClients.clear();
            options.setMaxSingleUploadSizeLong(maxSingleUploadSize);
            options.setBlockSizeLong(writeBlockSize);
 * ownership. Elasticsearch licenses this file to you under  
        try {
            return HttpPipelinePosition.PER_RETRY;
    public Duration getBlobRequestTimeout(String clientName) {  
    public static final ByteSizeValue MIN_CHUNK_SIZE = new ByteSizeValue(1, ByteSizeUnit.BYTES);  
        final AzureStorageSettings azureStorageSettings = getStorageSettings(clientName);
import java.util.function.BiConsumer;
            }  
    // 'package' for testing
        final NettyAsyncHttpClientBuilder clientBuilder = new NettyAsyncHttpClientBuilder().eventLoopGroup(eventLoopGroup);
        }
     */
     * @param clientName client name
            if (t.isDaemon()) {
        final LocationMode locationMode = settings.getLocationMode();
     * Implements HTTP pipeline policy to collect statistics on API calls. See :  
    /**
            }
import java.time.Duration;
import com.azure.storage.blob.BlobServiceClient;  
import org.opensearch.common.Nullable;
    }
        );  
        // - https://github.com/Azure/azure-sdk-for-java/pull/24374
        public BlobServiceClient getClient() {  
        }
     * @return the {@code BlobServiceClient} instance and context
    @Override
     * <a href="https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/storage/azure-storage-blob/migrationGuides/V8_V12.md#miscellaneous">migration guide</a> for mode details:
            eventLoopGroup  
    /**  
     */
        final long writeBlockSize = settings.getWriteBlockSize().getBytes();  
import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
            if (proxySettings != ProxySettings.NO_PROXY_SETTINGS) {
    }
            // This policy must be in a position to see each retry  
            builder.endpoint(endpoint.getSecondaryUri()).retryOptions(createRetryPolicy(settings, null));  
    Integer getReadBlockSize(String clientName) {
        // - https://github.com/Azure/azure-sdk-for-java/issues/24373  
import java.util.concurrent.atomic.AtomicInteger;
 * Unless required by applicable law or agreed to in writing,
    private static class ClientState {  
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        }
     * graceful shutdown logic.
    private final Map<AzureStorageSettings, ClientState> clients = new ConcurrentHashMap<>();  
    }
                final ProxyOptions proxyOptions = new ProxyOptions(proxySettings.getType().toProxyType(), proxySettings.getAddress());  
            namePrefix = "reactor-nio-" + poolNumber.getAndIncrement() + "-thread-";
        }
        if (timeout > 0) {
    ParallelTransferOptions getBlobRequestOptionsForWriteBlob(String clientName) {
        ClientState state = clients.get(azureStorageSettings);  
            () -> Executors.newCachedThreadPool(new IdentityClientThreadFactory("azure-identity-client"))
                throw new IllegalArgumentException("Timeout [" + azureStorageSettings.getTimeout() + "] exceeds 2,147,483,647ms.");  
import com.azure.core.util.Context;
        if (writeBlockSize >= 0L) {  
            RetryPolicyType.EXPONENTIAL,  
        }
        throws InvalidKeyException, URISyntaxException {
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();  
        if (writeTimeout != null) {
    }
            }
            t.setDaemon(true);
 * this file be licensed under the Apache-2.0 license or a
    }  
import io.netty.channel.nio.NioEventLoopGroup;  
        return AccessController.doPrivileged(() -> settings.configure(new BlobServiceClientBuilder(), executor, logger));
public class AzureStorageService implements AutoCloseable {  
        }
        @Override
     */
import java.security.InvalidKeyException;
/*  
    }
    /**
        ClientState(final BlobServiceClient client, final EventLoopGroup eventLoopGroup) {
     * @return the {@code BlobServiceClient} instance and context  
            null,
}
    }
            Thread t = new Thread(
        this.executor.shutdown();  
                namePrefix + "[T#" + threadNumber.getAndIncrement() + "]",
            this.namePrefix = namePrefix;
                t.setPriority(Thread.NORM_PRIORITY);  
        builder.httpClient(clientBuilder.build());
        // clients are built lazily by {@link client(String)}
        IdentityClientThreadFactory(String namePrefix) {  
import static java.util.Collections.emptyMap;
            builder.endpoint(endpoint.getSecondaryUri()).retryOptions(createRetryPolicy(settings, endpoint.getPrimaryUri()));
        }
     */  
        // eagerly load client settings so that secure settings are read
        final StorageEndpoint endpoint = settings.getStorageEndpoint(logger);
            return Duration.ofMillis(timeout);  
import com.azure.storage.common.policy.RetryPolicyType;  
 * Modifications Copyright OpenSearch Contributors. See
        });  
        shutdownFuture.awaitUninterruptibly();
import org.opensearch.secure_sm.AccessController;  
            (Integer) null,
 * The OpenSearch Contributors require contributions made to  
        public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        }
    }
     * Maximum allowed blob's block size in Azure blob store.  
import reactor.core.publisher.Mono;
        final Map<AzureStorageSettings, ClientState> prevClients = new HashMap<>(this.clients);  
     */
        } else if (locationMode == LocationMode.SECONDARY_THEN_PRIMARY) {  
            final ProxySettings proxySettings = azureStorageSettings.getProxySettings();
            if (t.getPriority() != Thread.NORM_PRIORITY) {
            logger.warning("Error closing Netty Event Loop group", shutdownFuture.cause());
            clientBuilder.readTimeout(Duration.ofMillis(readTimeout.millis()));
    private static class NioThreadFactory implements ThreadFactory {  
 * this work for additional information regarding copyright
    }
        final TimeValue responseTimeout = azureStorageSettings.getResponseTimeout();
            return t;  
     * @param statsCollector statistics collector
        // https://github.com/Azure/azure-storage-java/blob/master/V12%20Upgrade%20Story.md#v12-the-best-of-both-worlds
     * @param azureStorageSettings azure seetings
    public Tuple<BlobServiceClient, Supplier<Context>> client(String clientName, BiConsumer<HttpRequest, HttpResponse> statsCollector) {
            Thread.currentThread().interrupt();
        // New Azure storage clients are thread-safe and do not hold any state so could be cached, see please:
                } catch (InvalidKeyException | URISyntaxException | IllegalArgumentException e) {  
            return client;
 * SPDX-License-Identifier: Apache-2.0
    private BlobServiceClientBuilder createClientBuilder(AzureStorageSettings settings) throws InvalidKeyException, URISyntaxException {
 *  
        }
            this.eventLoopGroup = eventLoopGroup;  
import java.util.HashMap;  
        return new ClientState(
                throw new IllegalArgumentException("connectionString missing required settings to derive blob service secondary endpoint.");  
            return t;  
        return options;  
        final AzureStorageSettings settings = getStorageSettings(clientName);
        final Map<String, AzureStorageSettings> clientsSettings = AzureStorageSettings.load(settings);
 *    http://www.apache.org/licenses/LICENSE-2.0
import com.azure.core.http.HttpPipelinePosition;  
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.ProxyOptions;  
        private final String namePrefix;
        @SuppressWarnings("removal")
        }
        if (state == null) {
        return client(clientName, (request, response) -> {});  
    /**
import org.opensearch.common.unit.TimeValue;  
    }  
import org.opensearch.common.settings.Settings;
import com.azure.core.http.HttpRequest;
        final TimeValue writeTimeout = azureStorageSettings.getWriteTimeout();
        final long timeout = azureStorageSettings.getTimeout().getMillis();
            }  
    private static class HttpStatsPolicy implements HttpPipelinePolicy {  
     * @param clientName client name  
    private void closeInternally(ClientState state) {
        final Future<?> shutdownFuture = state.getEventLoopGroup().shutdownGracefully(0, 5, TimeUnit.SECONDS);  
                    proxyOptions.setCredentials(proxySettings.getUsername(), proxySettings.getPassword());
        @Override  
     */
    }
    }  
        public EventLoopGroup getEventLoopGroup() {
        Configuration.getGlobalConfiguration().put("AZURE_JACKSON_ADAPTER_USE_ACCESS_HELPER", "true");  
 * license agreements. See the NOTICE file distributed with
        final AzureStorageSettings azureStorageSettings = getStorageSettings(clientName);
        }
        // - https://github.com/Azure/azure-sdk-for-java/issues/37464
    /**  
        final AtomicInteger threadNumber = new AtomicInteger(1);
        this.clients.values().forEach(this::closeInternally);
import java.util.Map;
        } else if (locationMode == LocationMode.PRIMARY_THEN_SECONDARY) {
        if (writeConcurrency >= 0) {  
        // We define a default exponential retry policy{
    }
 *
        if (azureStorageSettings == null) {
     * settings. BlobServiceClient is thread safe and could be cached but the settings
 * under the License.  
        return azureStorageSettings;
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
                () -> AccessController.doPrivileged(r),
import org.opensearch.core.common.unit.ByteSizeUnit;
import com.azure.core.util.Configuration;  
        // Set timeout option if the user sets cloud.azure.storage.timeout or  
            if (this.executor.awaitTermination(30, TimeUnit.SECONDS) == false) {
import org.opensearch.common.collect.Tuple;  
        @SuppressWarnings("removal")  
        return builder;
            null,  
    }
            throw new IllegalArgumentException("connectionString missing required settings to derive blob service primary endpoint.");
import com.azure.core.util.logging.ClientLogger;
        if (writeBlockSize < 0L && maxSingleUploadSize < 0L && writeConcurrency < 0) {
        );  
import com.azure.core.http.policy.HttpPipelinePolicy;
                if (proxySettings.isAuthenticated()) {
    public static final ByteSizeValue MAX_CHUNK_SIZE = new ByteSizeValue(
        return prevSettings;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.core.http.HttpPipelineCallContext;
    /**  
