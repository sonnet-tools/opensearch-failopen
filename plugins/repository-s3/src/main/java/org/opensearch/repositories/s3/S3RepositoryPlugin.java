        int availablePermits = Math.max(allocatedProcessors(clusterService.getSettings()) * 4, 10);
 * the Apache License, Version 2.0 (the "License"); you may
        return (numberOfProcessors + 1) / 2;
        final IndexNameExpressionResolver expressionResolver,
                allocatedProcessors(settings),
            S3Repository.UPLOAD_RETRY_ENABLED,
import org.opensearch.core.common.unit.ByteSizeUnit;
 * The OpenSearch Contributors require contributions made to
            S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE
            normalTransferQConsumerService,
    }
        executorBuilders.add(
        );
                "thread_pool." + NORMAL_TRANSFER_QUEUE_CONSUMER
        );
import org.apache.logging.log4j.Logger;
            clusterService,
    // same binding types fail.
            // named s3 client configuration settings
            S3ClientSettings.ENDPOINT_SETTING,
        this.urgentExecutorBuilder = new AsyncExecutorContainer(
 *
    @Override
            S3ClientSettings.ACCESS_KEY_SETTING,
                STREAM_READER,
import org.opensearch.script.ScriptService;
            new FixedExecutorBuilder(
            }
                    logger.info(
            lowPriorityQCapacity,
        if (matchCount > 1) {
            normalPriorityPermits,
        final ClusterService clusterService,
        return boundedBy((allocatedProcessors(settings) + 7) / 8, 1, 2);
        LowPrioritySizeBasedBlockingQ lowPrioritySizeBasedBlockingQ = new LowPrioritySizeBasedBlockingQ(
            logger.info("No native object store provider found for repository type [{}]", S3Repository.TYPE);
        int matchCount = 0;
    protected AsyncExecutorContainer urgentExecutorBuilder;
        final ResourceWatcherService resourceWatcherService,
        return OpenSearchExecutors.allocatedProcessors(settings);
        if (urgentExecutorBuilder.getAsyncTransferEventLoopGroup() != null) {
/*
            threadPool.executor(FUTURE_COMPLETION),
 *
import org.opensearch.cluster.metadata.RepositoryMetadata;
            normalPriorityPermits,
            S3Repository.SECRET_KEY_SETTING,
        final NamedXContentRegistry xContentRegistry,
            lowPriorityPermits,
import java.util.concurrent.TimeUnit;
        );
public class S3RepositoryPlugin extends Plugin implements RepositoryPlugin, ReloadablePlugin, ExtensiblePlugin {
        return Math.min(max, Math.max(min, value));
            SizeBasedBlockingQ.QueueEventType.NORMAL
import org.opensearch.transport.client.Client;
        final RepositoryMetadata metadata,
        final Environment env,
            metadata -> createRepository(metadata, registry, clusterService, recoverySettings)
            S3Repository.S3_PERMIT_WAIT_DURATION_MIN.get(clusterService.getSettings()),
        executorBuilders.add(
        this.service = Objects.requireNonNull(service, "S3 service must not be null");
import org.apache.logging.log4j.LogManager;
import org.opensearch.env.Environment;
            service,
import java.util.Map;
    private static final String PRIORITY_STREAM_READER = "priority_stream_reader";
            GenericStatsMetricPublisher genericStatsMetricPublisher
        this.s3AsyncService.refreshAndClearCache(clientsSettings);
            ByteSizeValue capacity,
 * license agreements. See the NOTICE file distributed with
            super(capacity, executorService, consumers, genericStatsMetricPublisher, QueueEventType.LOW);
import org.opensearch.plugins.RepositoryPlugin;
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.plugins.ExtensiblePlugin;
            S3ClientSettings.LEGACY_MD5_CHECKSUM_CALCULATION,
    }
    /** Native store provider loaded via ExtensiblePlugin — null if no native plugin is present. */
        this.priorityExecutorBuilder = new AsyncExecutorContainer(
import org.opensearch.threadpool.ScalingExecutorBuilder;
        int normalPriorityConsumers = normalPriorityTransferQConsumers(clusterService.getSettings());
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
            s3AsyncService,
    protected SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ;
            priorityExecutorBuilder.getAsyncTransferEventLoopGroup().close();
        }
            new AsyncTransferEventLoopGroup(priorityEventLoopThreads)
    }
            S3ClientSettings.ROLE_ARN_SETTING,
        );
    }
            threadPool.executor(STREAM_READER),
                TimeValue.timeValueMinutes(5)
            int consumers,
            new ScalingExecutorBuilder(
    S3RepositoryPlugin(final Settings settings, final Path configPath, final S3Service service, final S3AsyncService s3AsyncService) {
        return boundedBy((allocatedProcessors(settings) + 1) / 2, 2, 4);
import java.util.function.Supplier;
import org.opensearch.indices.recovery.RecoverySettings;
        int lowPriorityConsumers = lowPriorityTransferQConsumers(clusterService.getSettings());
            urgentExecutorBuilder.getStreamReader(),
        this.normalPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(
        executorBuilders.add(
import org.opensearch.repositories.s3.async.AsyncTransferManager;
            asyncUploadUtils,
            threadPool.executor(URGENT_STREAM_READER),
    private static final String URGENT_STREAM_READER = "urgent_stream_reader";
    @Override
    public void close() throws IOException {
            transferSemaphoresHolder
import java.util.Arrays;
import org.opensearch.threadpool.ExecutorBuilder;
        final RecoverySettings recoverySettings
        int lowPriorityPermits = availablePermits - normalPriorityPermits;
/*
 * compatible open source license.
            S3Repository.REDIRECT_LARGE_S3_UPLOAD,
        for (NativeRemoteObjectStoreProvider provider : providers) {
 * Unless required by applicable law or agreed to in writing,
        this.lowPrioritySizeBasedBlockingQ = lowPrioritySizeBasedBlockingQ;
        final Client client,
            S3ClientSettings.READ_TIMEOUT_SETTING,
        ByteSizeValue lowPriorityQCapacity = new ByteSizeValue(lowPriorityConsumers * 20L, ByteSizeUnit.GB);
        );
            if (S3Repository.TYPE.equals(provider.repositoryType())) {
            normalPriorityQCapacity,
    protected AsyncExecutorContainer priorityExecutorBuilder;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
            S3ClientSettings.API_CALL_TIMEOUT_SETTING,
        final ClusterService clusterService,
            configPath,
        double priorityPermitAllocation = ((double) S3Repository.S3_PRIORITY_PERMIT_ALLOCATION_PERCENT.get(clusterService.getSettings()))
        // High number of permit allocation because each op acquiring permit performs disk IO, computation and network IO.
        final ThreadPool threadPool,
            new ScalingExecutorBuilder(PRIORITY_FUTURE_COMPLETION, 1, allocatedProcessors(settings), TimeValue.timeValueMinutes(5))
            new AsyncTransferEventLoopGroup(normalEventLoopThreads)
    protected AsyncExecutorContainer normalExecutorBuilder;
            S3ClientSettings.PROXY_USERNAME_SETTING,
    private static int allocatedProcessors(Settings settings) {
        if (normalExecutorBuilder.getAsyncTransferEventLoopGroup() != null) {
import java.util.Collections;
        int priorityEventLoopThreads = priorityPoolCount(clusterService.getSettings());
            S3ClientSettings.REGION,
            priorityExecutorBuilder,
                settings,
            genericStatsMetricPublisher
            S3Repository.PARALLEL_MULTIPART_UPLOAD_ENABLED_SETTING,
    }
        final Map<String, S3ClientSettings> clientsSettings = S3ClientSettings.load(settings, configPath);
            registry,
            genericStatsMetricPublisher,
    private static final String STREAM_READER = "stream_reader";
        final NodeEnvironment nodeEnvironment,
import java.io.IOException;
 * not use this file except in compliance with the License.
    protected S3Repository createRepository(
        return Arrays.asList(
            urgentExecutorBuilder.getAsyncTransferEventLoopGroup().close();
        executorBuilders.add(new ScalingExecutorBuilder(URGENT_STREAM_READER, 1, halfProc, TimeValue.timeValueMinutes(5)));
    private static int priorityPoolCount(Settings settings) {
            normalExecutorBuilder.getAsyncTransferEventLoopGroup().close();
        this.normalExecutorBuilder = new AsyncExecutorContainer(
    protected TransferSemaphoresHolder transferSemaphoresHolder;
        executorBuilders.add(new ScalingExecutorBuilder(PRIORITY_STREAM_READER, 1, halfProc, TimeValue.timeValueMinutes(5)));
            TimeUnit.MINUTES,
        int normalEventLoopThreads = normalPoolCount(clusterService.getSettings());
            priorityExecutorBuilder.getStreamReader(),
            lowPriorityPermits
/*
            S3ClientSettings.SIGNER_OVERRIDE,
            S3ClientSettings.PROXY_TYPE_SETTING,
                    );
        }
        List<ExecutorBuilder<?>> executorBuilders = new ArrayList<>();
                10,
            S3ClientSettings.USE_PATH_STYLE_ACCESS,
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
    }
        );
            );
 * A plugin to add a repository type that writes to and from the AWS S3.
        final NamedXContentRegistry registry,
    private static final Logger logger = LogManager.getLogger(S3RepositoryPlugin.class);
                S3Repository.TYPE,
        );
            lowPrioritySizeBasedBlockingQ,
        s3AsyncService.refreshAndClearCache(clientsSettings);
                settings,
import org.opensearch.repositories.s3.async.TransferSemaphoresHolder;
    protected GenericStatsMetricPublisher genericStatsMetricPublisher;
    }
import org.opensearch.plugins.Plugin;
    private ExecutorService lowTransferQConsumerService;
import java.util.List;
        // secure settings should be readable
    ) {
    }
        service.close();
 */
import java.util.ArrayList;
        this.genericStatsMetricPublisher = new GenericStatsMetricPublisher(
            metadata,
    @Override
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;
        ) {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        List<NativeRemoteObjectStoreProvider> providers = loader.loadExtensions(NativeRemoteObjectStoreProvider.class);
    }
        return CollectionUtils.arrayAsArrayList(this.normalPrioritySizeBasedBlockingQ, lowPrioritySizeBasedBlockingQ);
        final NamedXContentRegistry registry,
    protected final S3Service service;
/**
 * specific language governing permissions and limitations
            S3Repository.PERMIT_BACKED_TRANSFER_ENABLED,
import org.opensearch.repositories.Repository;
            lowPriorityConsumers,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        }
            recoverySettings,
    ) {
            )
        return Collections.singletonMap(
        return boundedBy((allocatedProcessors(settings) + 1) / 2, 1, 2);
        if (priorityExecutorBuilder.getAsyncTransferEventLoopGroup() != null) {
        this.s3AsyncService = Objects.requireNonNull(s3AsyncService, "S3AsyncService must not be null");
                        S3Repository.TYPE
            normalPriorityConsumers,
        }
    private ExecutorService normalTransferQConsumerService;
            S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING,
            S3ClientSettings.PROXY_HOST_SETTING,
        );
            ExecutorService executorService,
        );
 * this file be licensed under the Apache-2.0 license or a
                "Multiple native object store providers found for repository type [{}], using [{}]",
        );
    ) {
    private static int boundedBy(int value, int min, int max) {
    }
        return Math.max(2, (int) (lowPriorityAllocation * S3Repository.S3_TRANSFER_QUEUE_CONSUMERS.get(settings)));
 */
            S3ClientSettings.SESSION_TOKEN_SETTING,
 */
        executorBuilders.add(
            lowPriorityQCapacity.getBytes(),
            S3ClientSettings.IDENTITY_TOKEN_FILE_SETTING,
            genericStatsMetricPublisher
    }
        return S3Repository.S3_TRANSFER_QUEUE_CONSUMERS.get(settings);
        double lowPriorityAllocation = ((double) (100 - S3Repository.S3_PRIORITY_PERMIT_ALLOCATION_PERCENT.get(settings))) / 100;
        }
        final ScriptService scriptService,
            new FixedExecutorBuilder(
        executorBuilders.add(
    public void reload(Settings settings) {
    private static final String PRIORITY_FUTURE_COMPLETION = "priority_future_completion";
            S3Repository.S3_PRIORITY_PERMIT_ALLOCATION_PERCENT,
    private static final String FUTURE_COMPLETION = "future_completion";
            nativeStoreProvider
        public LowPrioritySizeBasedBlockingQ(
    protected final S3AsyncService s3AsyncService;
            S3Repository.TYPE,
        Map<String, S3ClientSettings> clientsSettings = S3ClientSettings.load(settings, configPath);
import org.opensearch.common.unit.TimeValue;
 * Licensed to Elasticsearch under one or more contributor
}
        final RecoverySettings recoverySettings
import org.opensearch.core.common.unit.ByteSizeValue;
    }
    private int lowPriorityTransferQConsumers(Settings settings) {
    private static final String LOW_TRANSFER_QUEUE_CONSUMER = "low_transfer_queue_consumer";
        }
        executorBuilders.add(
    @Override
import org.opensearch.common.settings.Setting;
    public void loadExtensions(ExtensionLoader loader) {
        int urgentEventLoopThreads = urgentPoolCount(clusterService.getSettings());
            new AsyncTransferEventLoopGroup(urgentEventLoopThreads)
    public Collection<Object> createComponents(
            threadPool.executor(URGENT_FUTURE_COMPLETION),
        this.configPath = configPath;
 * ownership. Elasticsearch licenses this file to you under
    private static int urgentPoolCount(Settings settings) {
            urgentExecutorBuilder,
import org.opensearch.watcher.ResourceWatcherService;
        return executorBuilders;
import org.opensearch.cluster.service.ClusterService;
    private static int normalPoolCount(Settings settings) {
    }
        final NamedWriteableRegistry namedWriteableRegistry,
        this.transferSemaphoresHolder = new TransferSemaphoresHolder(
    }
    static int halfNumberOfProcessors(int numberOfProcessors) {
        int halfProc = halfNumberOfProcessors(allocatedProcessors(settings));
import org.opensearch.core.common.util.CollectionUtils;
        final Environment environment,
            S3ClientSettings.PROXY_PORT_SETTING,
            S3ClientSettings.MAX_RETRIES_SETTING,
    private static final String NORMAL_TRANSFER_QUEUE_CONSUMER = "normal_transfer_queue_consumer";
            normalExecutorBuilder,
        service.refreshAndClearCache(clientsSettings);
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
 * You may obtain a copy of the License at
            new FixedExecutorBuilder(settings, URGENT_FUTURE_COMPLETION, urgentPoolCount(settings), 10_000, URGENT_FUTURE_COMPLETION)
                4 * allocatedProcessors(settings),
    private final Path configPath;
            S3ClientSettings.PROXY_PASSWORD_SETTING,
            S3Repository.ACCESS_KEY_SETTING,
import org.opensearch.threadpool.ThreadPool;
        );
        );
            S3ClientSettings.ROLE_SESSION_NAME_SETTING,
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
    public S3RepositoryPlugin(final Settings settings, final Path configPath) {
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        );
    // proxy method for testing
            )
    public List<Setting<?>> getSettings() {
 *
                    this.nativeStoreProvider = provider;
            normalExecutorBuilder.getStreamReader(),
            threadPool.executor(PRIORITY_FUTURE_COMPLETION),
        this(settings, configPath, new S3Service(configPath), new S3AsyncService(configPath));
        // eagerly load client settings so that secure settings are read
 * this work for additional information regarding copyright
    }
    }
        }
                if (this.nativeStoreProvider == null) {
        this.lowTransferQConsumerService = threadPool.executor(LOW_TRANSFER_QUEUE_CONSUMER);
                        provider.getClass().getName(),
    // New class because in core, components are injected via guice only by instance creation due to which
            S3ClientSettings.PROTOCOL_SETTING,
 */
                NORMAL_TRANSFER_QUEUE_CONSUMER,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        AsyncTransferManager asyncUploadUtils = new AsyncTransferManager(
    public Map<String, Repository.Factory> getRepositories(
        this.normalTransferQConsumerService = threadPool.executor(NORMAL_TRANSFER_QUEUE_CONSUMER);
            normalPriorityQCapacity.getBytes(),
        final Supplier<RepositoriesService> repositoriesServiceSupplier
    }
            / 100;
 * under the License.
package org.opensearch.repositories.s3;
            S3ClientSettings.USE_THROTTLE_RETRIES_SETTING,
        if (this.nativeStoreProvider == null) {
            genericStatsMetricPublisher,
                10,
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
import java.util.concurrent.ExecutorService;
            new ScalingExecutorBuilder(FUTURE_COMPLETION, 1, allocatedProcessors(settings), TimeValue.timeValueMinutes(5))
            )
    protected SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ;
    @Override
            S3Repository.PARALLEL_MULTIPART_UPLOAD_ENABLED_SETTING.get(clusterService.getSettings()),
                matchCount++;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final ClusterService clusterService,
        return new S3Repository(
import org.opensearch.plugins.ReloadablePlugin;
    private static final String URGENT_FUTURE_COMPLETION = "urgent_future_completion";
import java.nio.file.Path;
        s3AsyncService.close();
import org.opensearch.threadpool.FixedExecutorBuilder;
    private static final class LowPrioritySizeBasedBlockingQ extends SizeBasedBlockingQ {
    }
import org.opensearch.common.settings.Settings;
        );
                LOW_TRANSFER_QUEUE_CONSUMER,
        );
import org.opensearch.repositories.RepositoriesService;
        this.service.refreshAndClearCache(clientsSettings);
            logger.warn(
            S3ClientSettings.SECRET_KEY_SETTING,
import java.util.Collection;
            lowTransferQConsumerService,
import java.util.Objects;
        ByteSizeValue normalPriorityQCapacity = new ByteSizeValue(normalPriorityConsumers * 10L, ByteSizeUnit.GB);
            normalPrioritySizeBasedBlockingQ,
            threadPool.executor(PRIORITY_STREAM_READER),
            S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.get(clusterService.getSettings()).getBytes(),
                this.nativeStoreProvider.getClass().getName()
import org.opensearch.env.NodeEnvironment;
                "thread_pool." + LOW_TRANSFER_QUEUE_CONSUMER
        );
 * software distributed under the License is distributed on an
    }
    private NativeRemoteObjectStoreProvider nativeStoreProvider;
                normalPriorityTransferQConsumers(settings),
                lowPriorityTransferQConsumers(settings),
        );
    private int normalPriorityTransferQConsumers(Settings settings) {
                        "Loaded native object store provider [{}] for repository type [{}]",
                }
        int normalPriorityPermits = (int) (priorityPermitAllocation * availablePermits);
