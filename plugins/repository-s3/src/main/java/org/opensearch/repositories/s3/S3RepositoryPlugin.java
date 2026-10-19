            S3Repository.S3_PERMIT_WAIT_DURATION_MIN.get(clusterService.getSettings()),
 * this work for additional information regarding copyright
        executorBuilders.add(  
        final IndexNameExpressionResolver expressionResolver,
    ) {
            S3ClientSettings.MAX_RETRIES_SETTING,  
    public void loadExtensions(ExtensionLoader loader) {
import java.util.function.Supplier;
            new AsyncTransferEventLoopGroup(normalEventLoopThreads)  
        this.urgentExecutorBuilder = new AsyncExecutorContainer(
import org.opensearch.common.unit.TimeValue;
    }
                    this.nativeStoreProvider = provider;  
import org.opensearch.common.settings.Setting;  
    // proxy method for testing
    private static final String LOW_TRANSFER_QUEUE_CONSUMER = "low_transfer_queue_consumer";
        this.service.refreshAndClearCache(clientsSettings);  
 * You may obtain a copy of the License at  
            lowPrioritySizeBasedBlockingQ,
            SizeBasedBlockingQ.QueueEventType.NORMAL
        s3AsyncService.close();
    protected AsyncExecutorContainer priorityExecutorBuilder;
    protected S3Repository createRepository(  
    @Override
        this.lowTransferQConsumerService = threadPool.executor(LOW_TRANSFER_QUEUE_CONSUMER);  
            S3ClientSettings.ROLE_SESSION_NAME_SETTING,  
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;
        );  
            S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING,
            genericStatsMetricPublisher,
        final Supplier<RepositoriesService> repositoriesServiceSupplier
        return Arrays.asList(
    protected TransferSemaphoresHolder transferSemaphoresHolder;
        this(settings, configPath, new S3Service(configPath), new S3AsyncService(configPath));
    }
        final ResourceWatcherService resourceWatcherService,
            genericStatsMetricPublisher,  
        this.genericStatsMetricPublisher = new GenericStatsMetricPublisher(
        s3AsyncService.refreshAndClearCache(clientsSettings);
            s3AsyncService,  
            lowPriorityPermits,
            S3Repository.PERMIT_BACKED_TRANSFER_ENABLED,
        this.priorityExecutorBuilder = new AsyncExecutorContainer(
            S3ClientSettings.PROTOCOL_SETTING,
import java.util.concurrent.TimeUnit;  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        final ClusterService clusterService,  
            TimeUnit.MINUTES,  
        int normalEventLoopThreads = normalPoolCount(clusterService.getSettings());  
                }  
            normalExecutorBuilder.getStreamReader(),  
        return CollectionUtils.arrayAsArrayList(this.normalPrioritySizeBasedBlockingQ, lowPrioritySizeBasedBlockingQ);
/*  
                matchCount++;
            // named s3 client configuration settings
        );  
            normalTransferQConsumerService,
        }
        service.refreshAndClearCache(clientsSettings);
        );  
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {  
    }
import java.util.Arrays;
            ExecutorService executorService,  
            genericStatsMetricPublisher
        ) {  
            lowTransferQConsumerService,  
                    );
    private static final String URGENT_STREAM_READER = "urgent_stream_reader";
        );
                settings,
        this.transferSemaphoresHolder = new TransferSemaphoresHolder(
            S3ClientSettings.SIGNER_OVERRIDE,
    }  
 * KIND, either express or implied.  See the License for the
            metadata -> createRepository(metadata, registry, clusterService, recoverySettings)
import org.opensearch.cluster.service.ClusterService;
        this.service = Objects.requireNonNull(service, "S3 service must not be null");
            urgentExecutorBuilder.getStreamReader(),
import org.opensearch.env.NodeEnvironment;
                STREAM_READER,
        return boundedBy((allocatedProcessors(settings) + 1) / 2, 1, 2);  
        int normalPriorityPermits = (int) (priorityPermitAllocation * availablePermits);
                4 * allocatedProcessors(settings),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        executorBuilders.add(  
            S3ClientSettings.USE_PATH_STYLE_ACCESS,
    private ExecutorService normalTransferQConsumerService;
    }
        int urgentEventLoopThreads = urgentPoolCount(clusterService.getSettings());
            S3Repository.PARALLEL_MULTIPART_UPLOAD_ENABLED_SETTING,  
    }  
        ByteSizeValue lowPriorityQCapacity = new ByteSizeValue(lowPriorityConsumers * 20L, ByteSizeUnit.GB);
    }  
            new ScalingExecutorBuilder(
        );  
    // New class because in core, components are injected via guice only by instance creation due to which
            S3Repository.PARALLEL_MULTIPART_UPLOAD_ENABLED_SETTING.get(clusterService.getSettings()),
import org.opensearch.core.common.unit.ByteSizeUnit;
            S3ClientSettings.PROXY_USERNAME_SETTING,
        this.normalTransferQConsumerService = threadPool.executor(NORMAL_TRANSFER_QUEUE_CONSUMER);
    }  
            S3ClientSettings.REGION,  
            S3ClientSettings.PROXY_TYPE_SETTING,
            if (S3Repository.TYPE.equals(provider.repositoryType())) {  
        }
            new FixedExecutorBuilder(  
        final Map<String, S3ClientSettings> clientsSettings = S3ClientSettings.load(settings, configPath);  
    protected GenericStatsMetricPublisher genericStatsMetricPublisher;
                        "Loaded native object store provider [{}] for repository type [{}]",
        final ClusterService clusterService,
import org.opensearch.threadpool.ScalingExecutorBuilder;  
    private static final String PRIORITY_STREAM_READER = "priority_stream_reader";
    public void close() throws IOException {  
import org.opensearch.core.common.util.CollectionUtils;
            normalExecutorBuilder.getAsyncTransferEventLoopGroup().close();
    private static int priorityPoolCount(Settings settings) {  
        executorBuilders.add(  
import org.opensearch.threadpool.FixedExecutorBuilder;
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
            metadata,  
            S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.get(clusterService.getSettings()).getBytes(),
    @Override
        this.lowPrioritySizeBasedBlockingQ = lowPrioritySizeBasedBlockingQ;
        final Environment env,  
    private static int boundedBy(int value, int min, int max) {  
    // same binding types fail.
        double lowPriorityAllocation = ((double) (100 - S3Repository.S3_PRIORITY_PERMIT_ALLOCATION_PERCENT.get(settings))) / 100;  
import org.opensearch.threadpool.ThreadPool;
                10,
    }  
    private final Path configPath;
            priorityExecutorBuilder.getAsyncTransferEventLoopGroup().close();
        executorBuilders.add(
        List<NativeRemoteObjectStoreProvider> providers = loader.loadExtensions(NativeRemoteObjectStoreProvider.class);  
            normalPrioritySizeBasedBlockingQ,  
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
import java.util.concurrent.ExecutorService;
            new FixedExecutorBuilder(settings, URGENT_FUTURE_COMPLETION, urgentPoolCount(settings), 10_000, URGENT_FUTURE_COMPLETION)
            threadPool.executor(STREAM_READER),
            new ScalingExecutorBuilder(PRIORITY_FUTURE_COMPLETION, 1, allocatedProcessors(settings), TimeValue.timeValueMinutes(5))
        AsyncTransferManager asyncUploadUtils = new AsyncTransferManager(
            configPath,
            S3ClientSettings.ROLE_ARN_SETTING,
            transferSemaphoresHolder  
 * ownership. Elasticsearch licenses this file to you under  
        executorBuilders.add(
import java.util.Collection;  
            S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE
            S3Repository.UPLOAD_RETRY_ENABLED,
            S3ClientSettings.IDENTITY_TOKEN_FILE_SETTING,
    /** Native store provider loaded via ExtensiblePlugin — null if no native plugin is present. */
 * under the License.  
            S3ClientSettings.PROXY_PASSWORD_SETTING,  
            clusterService,  
    @Override
                normalPriorityTransferQConsumers(settings),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        for (NativeRemoteObjectStoreProvider provider : providers) {
import org.opensearch.core.common.unit.ByteSizeValue;  
            GenericStatsMetricPublisher genericStatsMetricPublisher
            super(capacity, executorService, consumers, genericStatsMetricPublisher, QueueEventType.LOW);
            S3Repository.S3_PRIORITY_PERMIT_ALLOCATION_PERCENT,  
        if (urgentExecutorBuilder.getAsyncTransferEventLoopGroup() != null) {  
import java.util.Map;  
import org.opensearch.plugins.RepositoryPlugin;
        return boundedBy((allocatedProcessors(settings) + 1) / 2, 2, 4);
            lowPriorityConsumers,
 * this file be licensed under the Apache-2.0 license or a
 * A plugin to add a repository type that writes to and from the AWS S3.
        final NamedXContentRegistry xContentRegistry,  
    private static final Logger logger = LogManager.getLogger(S3RepositoryPlugin.class);
import java.util.Collections;
        // secure settings should be readable
                TimeValue.timeValueMinutes(5)
    static int halfNumberOfProcessors(int numberOfProcessors) {
        return (numberOfProcessors + 1) / 2;  
 * The OpenSearch Contributors require contributions made to  
 *  
        Map<String, S3ClientSettings> clientsSettings = S3ClientSettings.load(settings, configPath);
import org.opensearch.cluster.metadata.RepositoryMetadata;
    public List<Setting<?>> getSettings() {  
        int matchCount = 0;
    }  
        if (matchCount > 1) {  
    protected AsyncExecutorContainer urgentExecutorBuilder;  
        return new S3Repository(
                this.nativeStoreProvider.getClass().getName()
                10,
            S3ClientSettings.READ_TIMEOUT_SETTING,
import org.opensearch.script.ScriptService;  
        final ClusterService clusterService,
            normalPriorityPermits,  
        this.s3AsyncService = Objects.requireNonNull(s3AsyncService, "S3AsyncService must not be null");
            S3Repository.ACCESS_KEY_SETTING,  
        );  
import org.opensearch.watcher.ResourceWatcherService;  
    private int normalPriorityTransferQConsumers(Settings settings) {
            new AsyncTransferEventLoopGroup(priorityEventLoopThreads)
                "thread_pool." + NORMAL_TRANSFER_QUEUE_CONSUMER
        final NamedXContentRegistry registry,
 */
        double priorityPermitAllocation = ((double) S3Repository.S3_PRIORITY_PERMIT_ALLOCATION_PERCENT.get(clusterService.getSettings()))
        );
    protected final S3Service service;
            S3ClientSettings.ENDPOINT_SETTING,  
        executorBuilders.add(
import java.nio.file.Path;  
    }
import org.opensearch.indices.recovery.RecoverySettings;
            new ScalingExecutorBuilder(FUTURE_COMPLETION, 1, allocatedProcessors(settings), TimeValue.timeValueMinutes(5))
import org.opensearch.core.xcontent.NamedXContentRegistry;
            threadPool.executor(PRIORITY_STREAM_READER),  
            registry,
    private static int allocatedProcessors(Settings settings) {
            service,
    @Override
import org.apache.logging.log4j.LogManager;
        final RecoverySettings recoverySettings
 * license agreements. See the NOTICE file distributed with
        final Environment environment,
    }
        return executorBuilders;
        final ThreadPool threadPool,  
            urgentExecutorBuilder.getAsyncTransferEventLoopGroup().close();
            )  
                        S3Repository.TYPE
    protected AsyncExecutorContainer normalExecutorBuilder;
            new AsyncTransferEventLoopGroup(urgentEventLoopThreads)
import org.opensearch.transport.client.Client;
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
                lowPriorityTransferQConsumers(settings),  
            S3ClientSettings.PROXY_HOST_SETTING,  
            threadPool.executor(URGENT_STREAM_READER),
import org.opensearch.repositories.s3.async.TransferSemaphoresHolder;
            new FixedExecutorBuilder(  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
import org.opensearch.threadpool.ExecutorBuilder;
        List<ExecutorBuilder<?>> executorBuilders = new ArrayList<>();
        LowPrioritySizeBasedBlockingQ lowPrioritySizeBasedBlockingQ = new LowPrioritySizeBasedBlockingQ(
        }  
                S3Repository.TYPE,  
                        provider.getClass().getName(),  
            normalPriorityQCapacity.getBytes(),
                settings,
    }
import org.opensearch.common.settings.Settings;
    @Override
            S3ClientSettings.SECRET_KEY_SETTING,
 * Unless required by applicable law or agreed to in writing,
    }
        int availablePermits = Math.max(allocatedProcessors(clusterService.getSettings()) * 4, 10);
        }  
        public LowPrioritySizeBasedBlockingQ(
        return boundedBy((allocatedProcessors(settings) + 7) / 8, 1, 2);
        final RepositoryMetadata metadata,
        );
                "thread_pool." + LOW_TRANSFER_QUEUE_CONSUMER
    private int lowPriorityTransferQConsumers(Settings settings) {
 * software distributed under the License is distributed on an
        final RecoverySettings recoverySettings  
        }
    @Override  
    private static final String NORMAL_TRANSFER_QUEUE_CONSUMER = "normal_transfer_queue_consumer";
            priorityExecutorBuilder.getStreamReader(),
        );
                allocatedProcessors(settings),  
            nativeStoreProvider  
    private static final String PRIORITY_FUTURE_COMPLETION = "priority_future_completion";  
        return OpenSearchExecutors.allocatedProcessors(settings);
    private static final String FUTURE_COMPLETION = "future_completion";
        // eagerly load client settings so that secure settings are read  
    protected SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ;
        executorBuilders.add(new ScalingExecutorBuilder(URGENT_STREAM_READER, 1, halfProc, TimeValue.timeValueMinutes(5)));  
                NORMAL_TRANSFER_QUEUE_CONSUMER,
            S3ClientSettings.LEGACY_MD5_CHECKSUM_CALCULATION,
        }
    ) {
            )  
            S3ClientSettings.USE_THROTTLE_RETRIES_SETTING,
        int halfProc = halfNumberOfProcessors(allocatedProcessors(settings));
            priorityExecutorBuilder,
        // High number of permit allocation because each op acquiring permit performs disk IO, computation and network IO.  
    private static int normalPoolCount(Settings settings) {
import org.opensearch.repositories.s3.async.AsyncTransferManager;  
import java.io.IOException;
            normalExecutorBuilder,
            recoverySettings,
            S3Repository.REDIRECT_LARGE_S3_UPLOAD,
import org.apache.logging.log4j.Logger;
        return S3Repository.S3_TRANSFER_QUEUE_CONSUMERS.get(settings);
            S3ClientSettings.API_CALL_TIMEOUT_SETTING,
            );
 * compatible open source license.
    private static int urgentPoolCount(Settings settings) {
            S3ClientSettings.PROXY_PORT_SETTING,
            threadPool.executor(PRIORITY_FUTURE_COMPLETION),
            logger.warn(
            threadPool.executor(FUTURE_COMPLETION),
    }
import org.opensearch.plugins.ReloadablePlugin;  
import org.opensearch.repositories.Repository;  
    private NativeRemoteObjectStoreProvider nativeStoreProvider;
 */  
            / 100;  
        if (this.nativeStoreProvider == null) {
            S3Repository.TYPE,  
            }
        return Math.max(2, (int) (lowPriorityAllocation * S3Repository.S3_TRANSFER_QUEUE_CONSUMERS.get(settings)));
        );
    public void reload(Settings settings) {
            threadPool.executor(URGENT_FUTURE_COMPLETION),  
        service.close();
        );
        int priorityEventLoopThreads = priorityPoolCount(clusterService.getSettings());
            lowPriorityPermits
        );
    S3RepositoryPlugin(final Settings settings, final Path configPath, final S3Service service, final S3AsyncService s3AsyncService) {  
}
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        final NamedXContentRegistry registry,
        );
    @Override
    ) {  
        }
    private ExecutorService lowTransferQConsumerService;  
import java.util.ArrayList;
            urgentExecutorBuilder,  
            ByteSizeValue capacity,
        );
                    logger.info(
    }  
public class S3RepositoryPlugin extends Plugin implements RepositoryPlugin, ReloadablePlugin, ExtensiblePlugin {  
    protected SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ;  
        final ScriptService scriptService,
            S3Repository.SECRET_KEY_SETTING,
import org.opensearch.repositories.RepositoriesService;
            S3ClientSettings.SESSION_TOKEN_SETTING,
            logger.info("No native object store provider found for repository type [{}]", S3Repository.TYPE);
import java.util.List;
        executorBuilders.add(new ScalingExecutorBuilder(PRIORITY_STREAM_READER, 1, halfProc, TimeValue.timeValueMinutes(5)));
 * GitHub history for details.
        this.configPath = configPath;
        if (priorityExecutorBuilder.getAsyncTransferEventLoopGroup() != null) {  
            normalPriorityPermits,  
        final NamedWriteableRegistry namedWriteableRegistry,  
    private static final String URGENT_FUTURE_COMPLETION = "urgent_future_completion";
 * not use this file except in compliance with the License.
            int consumers,
            genericStatsMetricPublisher
    private static final class LowPrioritySizeBasedBlockingQ extends SizeBasedBlockingQ {  
            )  
                if (this.nativeStoreProvider == null) {
        this.normalExecutorBuilder = new AsyncExecutorContainer(  
        ByteSizeValue normalPriorityQCapacity = new ByteSizeValue(normalPriorityConsumers * 10L, ByteSizeUnit.GB);
 */
import org.opensearch.env.Environment;  
    public Collection<Object> createComponents(  
    public Map<String, Repository.Factory> getRepositories(
import org.opensearch.plugins.Plugin;
 *
        );
import java.util.Objects;
        );
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
    }  
/*
            normalPriorityQCapacity,  
        final Client client,
            S3ClientSettings.ACCESS_KEY_SETTING,  
    }  
        this.s3AsyncService.refreshAndClearCache(clientsSettings);
 * Modifications Copyright OpenSearch Contributors. See
 *
        if (normalExecutorBuilder.getAsyncTransferEventLoopGroup() != null) {  
/**  
    public S3RepositoryPlugin(final Settings settings, final Path configPath) {
        return Collections.singletonMap(
            lowPriorityQCapacity,
    private static final String STREAM_READER = "stream_reader";  
        int lowPriorityConsumers = lowPriorityTransferQConsumers(clusterService.getSettings());
    }
        final NodeEnvironment nodeEnvironment,
 */  
        return Math.min(max, Math.max(min, value));
        this.normalPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(
package org.opensearch.repositories.s3;
            lowPriorityQCapacity.getBytes(),
                LOW_TRANSFER_QUEUE_CONSUMER,
            normalPriorityConsumers,
                "Multiple native object store providers found for repository type [{}], using [{}]",
            asyncUploadUtils,
        int lowPriorityPermits = availablePermits - normalPriorityPermits;
    protected final S3AsyncService s3AsyncService;
        int normalPriorityConsumers = normalPriorityTransferQConsumers(clusterService.getSettings());
import org.opensearch.plugins.ExtensiblePlugin;  
