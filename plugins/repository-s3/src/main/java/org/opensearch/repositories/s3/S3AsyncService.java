            AmazonAsyncS3Reference existingClient = getCachedClientForHttpTypeAndClientSettings(asyncHttpClientType, clientSettings);
 *
    private String buildClientName(final String clientValue, final String asyncClientType) {
            // TODO: Remove this once fixed in the AWS SDK
        }
        }
        final S3AsyncClient urgentClient = AccessController.doPrivileged(builder::build);
                        .webIdentityTokenFile(Path.of(irsaCredentials.getIdentityTokenFile()));
                || SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_FULL_URI.getStringValue().isPresent()) {
                return ContainerCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
        builder.overrideConfiguration(buildOverrideConfiguration(clientSettings, clientExecutorService));
            // Get or create new client cache map for the HTTP client type
     * @return S3ClientSettings
        }
                    .stsClient(stsClient)
            S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE.get(repositoryMetadata.settings())
            // Update both cache levels atomically
        final S3ClientSettings staticSettings = staticClientSettings.get(clientName);
        );
    /**
            }
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
        builder.retryPolicy(retryPolicy).apiCallAttemptTimeout(Duration.ofMillis(clientSettings.requestTimeoutMillis));
    // Aws v2 sdk tries to load a default profile from home path which is restricted. Hence, setting these to random
        // TODO: add max retry and UseThrottleRetry. Replace values with settings and put these in default settings
        clientBuilder.connectionTimeout(Duration.ofMillis(clientSettings.connectionTimeoutMillis));
            Closeable {
            return Optional.empty();
            });
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
     * Optional scheduled executor service to use for the client
        if (clientReference != null) {
            ProxyConfiguration.Builder crtProxyConfiguration = ProxyConfiguration.builder();
        AsyncTransferEventLoopGroup asyncTransferEventLoopGroup,
                        stsClient.close();
        return clientValue + "-" + asyncClientType;
        String roleSessionName = defaults.getRoleSessionName();
            .put(
    static SdkAsyncHttpClient buildHttpClient(
                if (basicCredentials != null) {
        }
     */
            }
    private volatile Map<String, Map<S3ClientSettings, AmazonAsyncS3Reference>> s3HttpClientTypesClientsCache = emptyMap();
                        .stsClient(stsClient)
            .put(
        }
        AsyncExecutorContainer normalExecutorBuilder
        @Override
                .immutableMap();
        return crtClientBuilder.build();
    }
import org.opensearch.repositories.s3.utils.AwsCrtUtils;
            S3Repository.CLIENT_NAME.get(settings),
        if (S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE.equals(asyncHttpClientType)) {
import software.amazon.awssdk.services.s3.S3AsyncClient;
        builder.asyncConfiguration(
        // If IAM Roles for Service Accounts (IRSA) credentials are configured, start with them first
            newClientReference.incRef();
    // We will need to support the cache with both type of clients. Since S3ClientSettings doesn't contain Http Client.
                    MapBuilder.newMapBuilder(clientsCacheForType).put(clientSettings, newClientReference).immutableMap()
                } else {
import org.opensearch.secure_sm.AccessController;
        // Use URI.create for simplicity; if your codebase prefers checked handling, swap to new URI(endpoint).
            crtProxyConfiguration.username(clientSettings.proxySettings.getUsername());
    }
            );
        assert this.staticClientSettings.containsKey(buildClientName("default", S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE))
            return buildAsyncNettyHttpClient(clientSettings, asyncTransferEventLoopGroup);
    }
                final S3ClientSettings existing = derivedClientSettings.get(settings);
            software.amazon.awssdk.http.nio.netty.ProxyConfiguration.Builder proxyConfiguration =
    ) {
        if (clientSettings.pathStyleAccess) {
        private final AwsCredentialsProvider credentials;
            .requestChecksumCalculation(RequestChecksumCalculation.WHEN_REQUIRED);
import java.nio.file.Path;
        final S3ClientSettings clientSettings,
            )
            // If the client reference is not found in cache. Let's create it.
import static java.util.Collections.emptyMap;
            return AccessController.doPrivileged(credentials::resolveCredentials);
    private AmazonAsyncS3Reference getCachedClientForHttpTypeAndClientSettings(
            // Manually add the schema to the endpoint to work around https://github.com/aws/aws-sdk-java/issues/2274
                    builder = builder.endpointOverride(URI.create(stsEndpoint));
                .build()
        }
            ClientAsyncConfiguration.builder()
            );
     * Returns an endpoint override ONLY when the user explicitly provided one.
     * clients are usable until released. On release they will be destroyed instead
        );
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
                        AssumeRoleRequest.builder()
            return clientReference;
        }
            crtProxyConfiguration.scheme(clientSettings.proxySettings.getType().toProtocol().toString());
        if (roleArn == null) {
        return builder.build();
import software.amazon.awssdk.services.s3.LegacyMd5Plugin;
                + Strings.collectionToDelimitedString(staticClientSettings.keySet(), ",")
                );
        crtClientBuilder.connectionTimeout(Duration.ofMillis(clientSettings.connectionTimeoutMillis));
                .put(
     */
                    return existing;
    // valid paths.
        AsyncExecutorContainer priorityExecutorBuilder,
    }
        }
                    credentials.close();
                buildClientName("default", S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE),
                return builder.build();
            }
                    StsWebIdentityTokenFileCredentialsProvider.builder()
            }
    public synchronized void refreshAndClearCache(Map<String, S3ClientSettings> clientsSettings) {
        final S3ClientSettings clientSettings,
    /**
            }
        AsyncExecutorContainer priorityExecutorBuilder,
        final S3AsyncClientBuilder builder = S3AsyncClient.builder();
                S3ClientSettings.getClientSettings(Settings.EMPTY, "default", configPath)
                final String stsEndpoint = System.getProperty(STS_ENDPOINT_OVERRIDE_SYSTEM_PROPERTY);
    synchronized AmazonAsyncS3WithCredentials buildClient(
    static class PrivilegedSTSAssumeRoleSessionCredentialsProvider<P extends AwsCredentialsProvider & AutoCloseable>
            }
                .build()
    private static void setDefaultAwsProfilePath() {
            return buildAsyncCrtHttpClient(clientSettings);
                    builder = builder.credentialsProvider(StaticCredentialsProvider.create(basicCredentials));
     * existing clients. New clients will be build using these new settings. Old
        } else {
        return AmazonAsyncS3WithCredentials.create(client, priorityClient, urgentClient, credentials);
                    );
        builder.httpClient(buildHttpClient(clientSettings, urgentExecutorBuilder.getAsyncTransferEventLoopGroup(), asyncHttpClientType));
        this(configPath, null);
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
            clientBuilder.proxyConfiguration(proxyConfiguration.build());
                )
    }
        S3Service.setDefaultAwsProfilePath();
        }
        return Optional.of(URI.create(endpoint));
                final StsAssumeRoleCredentialsProvider stsCredentialsProvider = AccessController.doPrivileged(
import software.amazon.awssdk.services.sts.StsClientBuilder;
        setDefaultAwsProfilePath();
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    S3ClientSettings settings(RepositoryMetadata repositoryMetadata) {
                    .refreshRequest(
        crtClientBuilder.maxConcurrency(clientSettings.maxConnections);
    static class PrivilegedInstanceProfileCredentialsProvider implements AwsCredentialsProvider {
                    normalExecutorBuilder.getFutureCompletionExecutor()
}
        }
    public synchronized void releaseCachedClients() {
    }
                .throttlingBackoffStrategy(
                clientsSettings.get(entrySet.getKey())
                )
     * Package-private to allow unit testing.
                .advancedOption(
                return existing;
        private PrivilegedInstanceProfileCredentialsProvider() {
        }
            );
                    priorityExecutorBuilder.getFutureCompletionExecutor()
        final AwsCredentialsProvider credentials = buildCredentials(logger, clientSettings);
    @SuppressForbidden(reason = "Need to provide this override to v2 SDK so that path does not default to home path")
import software.amazon.awssdk.http.nio.netty.SdkEventLoopGroup;
            }
                    + S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE
import java.time.Duration;
        if (AwsCrtUtils.isAwsCrtAvailable() == true) {
        }
            return newClientReference;
        implements
    static ClientOverrideConfiguration buildOverrideConfiguration(
        if (clientExecutorService != null) {
            logger.debug("Using basic key/secret credentials");
        if (clientSettings.proxySettings.getType() != ProxySettings.ProxyType.DIRECT) {
        final S3ClientSettings clientSettings,
                );
    private final @Nullable ScheduledExecutorService clientExecutorService;
        staticClientSettings = defaultBuilder.immutableMap();
            proxyConfiguration.port(clientSettings.proxySettings.getPort());
     */
        clientBuilder.eventLoopGroup(SdkEventLoopGroup.create(asyncTransferEventLoopGroup.getEventLoopGroup()));
                buildClient(clientSettings, urgentExecutorBuilder, priorityExecutorBuilder, normalExecutorBuilder, asyncHttpClientType)
import software.amazon.awssdk.services.sts.auth.StsWebIdentityTokenFileCredentialsProvider;
                buildClientName("default", S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE),
        return new IrsaCredentials(webIdentityTokenFile, roleArn, roleSessionName);
            () -> RetryPolicy.builder()
                derivedClientSettings = MapBuilder.newMapBuilder(derivedClientSettings).put(settings, newSettings).immutableMap();
        final IrsaCredentials irsaCredentials = buildFromEnvironment(clientSettings.irsaCredentials);
 * The OpenSearch Contributors require contributions made to
        final Settings settings = repositoryMetadata.settings();
        // This is required for ARN buckets (access points / outposts / MRAP), and is also correct for normal buckets.
        private PrivilegedSTSAssumeRoleSessionCredentialsProvider(@Nullable final StsClient stsClient, final P credentials) {
        );
        } else {
import software.amazon.awssdk.core.checksums.ResponseChecksumValidation;
    // Also adding the Http Client type in S3ClientSettings is not good option since it is used by Async and Sync clients.
        // If "endpoint" is absent, DO NOT override; allow the AWS SDK to resolve endpoints dynamically.
        final S3ClientSettings clientSettings = settings(repositoryMetadata);
    private static final Logger logger = LogManager.getLogger(S3AsyncService.class);
import software.amazon.awssdk.services.s3.S3AsyncClientBuilder;
        if (Strings.hasLength(clientSettings.endpoint) == false) {
        }
        if (clientSettings.legacyMd5ChecksumCalculation) {
            builder.addPlugin(LegacyMd5Plugin.create());
        for (Map.Entry<String, S3ClientSettings> entrySet : clientsSettings.entrySet()) {
            } else {
        RetryPolicy retryPolicy = AccessController.doPrivileged(
            endpoint = clientSettings.protocol.toString() + "://" + endpoint;
            return null;
    ) {
        if (clientSettings.proxySettings.getType() != ProxySettings.ProxyType.DIRECT) {
            )
        final S3ClientSettings clientSettings
        // clients are built lazily by {@link client}
     * by overriding static client settings from {@link #staticClientSettings} with settings found in the repository metadata.
        final S3AsyncClient priorityClient = AccessController.doPrivileged(builder::build);
                return existingClient;
            ClientAsyncConfiguration.builder()
                buildClientName(entrySet.getKey(), S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE),
            builder.apiCallTimeout(Duration.ofMillis(clientSettings.apiCallTimeoutMillis));
import software.amazon.awssdk.core.checksums.RequestChecksumCalculation;
                StsClientBuilder builder = StsClient.builder().region(region);
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
     * in the {@link RepositoryMetadata}.
import org.apache.logging.log4j.LogManager;
        }
        for (Map<S3ClientSettings, AmazonAsyncS3Reference> clientTypeCaches : s3HttpClientTypesClientsCache.values()) {
        String webIdentityTokenFile = defaults.getIdentityTokenFile();
    /**
        }
import java.io.Closeable;
        final String asyncHttpClientType
    }
    @Override
        s3HttpClientTypesClientsCache = emptyMap();
            : "Static Client Settings should contain default Netty client";
                )
            return buildAsyncNettyHttpClient(clientSettings, asyncTransferEventLoopGroup);
                    stsCredentialsProviderBuilder::build
import org.opensearch.cluster.metadata.RepositoryMetadata;
     */
        builder.asyncConfiguration(
                            .roleArn(irsaCredentials.getRoleArn())
        private final StsClient stsClient;
     */
            crtClientBuilder.proxyConfiguration(crtProxyConfiguration.build());
                            .roleSessionName(irsaCredentials.getRoleSessionName())
                    stsCredentialsProviderBuilder::build
     * Client settings calculated from static configuration and settings in the keystore.
        }
            // InstanceProfileCredentialsProvider as last item of chain
import java.io.IOException;
                    clientSettings.throttleRetries ? BackoffStrategy.defaultThrottlingStrategy(RetryMode.STANDARD) : BackoffStrategy.none()
                final S3ClientSettings newSettings = staticSettings.refine(settings);
            if (irsaCredentials.getIdentityTokenFile() == null) {
            defaultBuilder.put(
                return new PrivilegedSTSAssumeRoleSessionCredentialsProvider<>(stsClient, stsCredentialsProvider);
        builder.responseChecksumValidation(ResponseChecksumValidation.WHEN_REQUIRED)
        }
        clientBuilder.tcpKeepAlive(true);
        AwsCrtAsyncHttpClient.Builder crtClientBuilder = AwsCrtAsyncHttpClient.builder();
    S3AsyncService(final Path configPath) {
        );
     * of being returned to the cache.
                .advancedOption(
        final String asyncHttpClientType,
        }
            .immutableMap();
                "AWS CRT client is not available on the target platform, falling back to "
    /**
        clientBuilder.connectionAcquisitionTimeout(Duration.ofMillis(clientSettings.connectionAcquisitionTimeoutMillis));
            final AmazonAsyncS3Reference clientReference = clientsCacheMap.get(clientSettings);
            try {
 * compatible open source license.
import org.opensearch.common.SuppressForbidden;
     *
import java.util.concurrent.ScheduledExecutorService;
     */
     * If the client does not exist it will be created.
import org.opensearch.common.settings.Settings;
        releaseCachedClients();
    }
                + "]. Existing client configs: "
     * Refreshes the settings for the AmazonS3 clients and clears the cache of
        this.clientExecutorService = clientExecutorService;
                    SdkAdvancedAsyncClientOption.FUTURE_COMPLETION_EXECUTOR,
        );
        AsyncExecutorContainer urgentExecutorBuilder,
        {
import software.amazon.awssdk.auth.credentials.ContainerCredentialsProvider;
        }
     * @param repositoryMetadata Repository Metadata
            if (existing != null) {
import software.amazon.awssdk.core.SdkSystemSetting;
        if (clientsCacheMap != null && !clientsCacheMap.isEmpty()) {
                .numRetries(clientSettings.maxRetries)
                final StsWebIdentityTokenFileCredentialsProvider.Builder stsCredentialsProviderBuilder =
        logger.debug("S3 Http client type [{}]", asyncHttpClientType);
        if (webIdentityTokenFile == null) {
     * Attempts to retrieve a client by its repository metadata and settings from the cache.
    }
    @Nullable
import org.apache.logging.log4j.Logger;
        if (clientSettings.apiCallTimeoutMillis > 0) {
    }
            for (final AmazonAsyncS3Reference clientReference : clientTypeCaches.values()) {
        if (roleSessionName == null) {
                if (stsEndpoint != null) {
        builder.region(Region.of(clientSettings.region));
            roleArn = System.getenv(SdkSystemSetting.AWS_ROLE_ARN.environmentVariable());
            return StaticCredentialsProvider.create(basicCredentials);
                AccessController.doPrivilegedChecked(() -> {
        return clientExecutorService;
        clientBuilder.maxPendingConnectionAcquires(10_000);
        MapBuilder<String, S3ClientSettings> defaultBuilder = MapBuilder.newMapBuilder();
                return newSettings;
    static SdkAsyncHttpClient buildAsyncCrtHttpClient(final S3ClientSettings clientSettings) {
        } else if (basicCredentials != null) {
        String roleArn = defaults.getRoleArn();
import software.amazon.awssdk.services.sts.auth.StsAssumeRoleCredentialsProvider;
            );
            "Unknown s3 client name ["
            }
            // the clients will shutdown when they will not be used anymore
        // shutdown all unused clients
    ) {
package org.opensearch.repositories.s3;
        final String clientName = buildClientName(
            roleSessionName = System.getenv(SdkSystemSetting.AWS_ROLE_SESSION_NAME.environmentVariable());
                    SdkAdvancedAsyncClientOption.FUTURE_COMPLETION_EXECUTOR,
            webIdentityTokenFile = System.getenv(SdkSystemSetting.AWS_WEB_IDENTITY_TOKEN_FILE.environmentVariable());
        // clear previously cached clients, they will be build lazily
        public AwsCredentials resolveCredentials() {
        RepositoryMetadata repositoryMetadata,
            ClientAsyncConfiguration.builder()
import software.amazon.awssdk.core.retry.backoff.BackoffStrategy;
     * Otherwise returns Optional.empty().
import org.opensearch.core.common.Strings;
            synchronized (this) {
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
    static SdkAsyncHttpClient buildAsyncNettyHttpClient(
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;
    }
        @Override
    static AwsCredentialsProvider buildCredentials(Logger logger, S3ClientSettings clientSettings) {
        }
                    if (stsClient != null) {
                    urgentExecutorBuilder.getFutureCompletionExecutor()
        }
                )
import software.amazon.awssdk.regions.Region;
            this.credentials = initializeProvider();
        }
        public void close() throws IOException {
        return clientBuilder.build();
        @Override
            this.credentials = credentials;
        String asyncHttpClientType
                )
        ScheduledExecutorService clientExecutorService
        synchronized (this) {
                });
            if (clientReference != null && clientReference.tryIncRef()) {
     * Either fetches {@link S3ClientSettings} for a given {@link RepositoryMetadata} from cached settings or creates them
            : "Static Client Settings should contain default CRT client";
        }
    Optional<URI> resolveEndpointOverride(final S3ClientSettings clientSettings) {
                emptyMap()
            } catch (Exception e) {
                final StsWebIdentityTokenFileCredentialsProvider stsCredentialsProvider = AccessController.doPrivileged(
        }
        String endpoint = clientSettings.endpoint;
                buildClientName(entrySet.getKey(), S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE),
    public AmazonAsyncS3Reference client(
import java.util.Map;
    }
            builder = builder.scheduledExecutorService(clientExecutorService);
                throw (IOException) e;
                final StsAssumeRoleCredentialsProvider.Builder stsCredentialsProviderBuilder = StsAssumeRoleCredentialsProvider.builder()
        assert this.staticClientSettings.containsKey(buildClientName("default", S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE))
import software.amazon.awssdk.core.client.config.SdkAdvancedAsyncClientOption;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        // the response metadata cache is only there for diagnostics purposes,
            logger.debug("Using IRSA credentials");
            proxyConfiguration.scheme(clientSettings.proxySettings.getType().toProtocol().toString());
        ClientOverrideConfiguration.Builder builder = ClientOverrideConfiguration.builder();
                }
        if (staticSettings != null) {
    // We can segregate the types of cache here itself
        staticClientSettings = MapBuilder.<String, S3ClientSettings>newMapBuilder()
        derivedClientSettings = emptyMap();
        throw new IllegalArgumentException(
        if (defaults == null) {
                    + " client type"
    }
    // pkg private for tests
import software.amazon.awssdk.core.retry.RetryPolicy;
            s3HttpClientTypesClientsCache = MapBuilder.newMapBuilder(s3HttpClientTypesClientsCache)
                software.amazon.awssdk.http.nio.netty.ProxyConfiguration.builder();
            final S3ClientSettings existing = derivedClientSettings.get(settings);
    ScheduledExecutorService getClientExecutorService() {
    }
        final AsyncTransferEventLoopGroup asyncTransferEventLoopGroup
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
                S3ClientSettings.getClientSettings(Settings.EMPTY, "default", configPath)
            );
            final Region region = Region.of(clientSettings.region);
                + clientName
        );
                asyncHttpClientType,
    private static IrsaCredentials buildFromEnvironment(IrsaCredentials defaults) {
                .build()
            Map<S3ClientSettings, AmazonAsyncS3Reference> clientsCacheForType = s3HttpClientTypesClientsCache.getOrDefault(
                clientReference.decRef();
            return new PrivilegedInstanceProfileCredentialsProvider();
                    SdkAdvancedAsyncClientOption.FUTURE_COMPLETION_EXECUTOR,
        public AwsCredentials resolveCredentials() {
        AsyncExecutorContainer urgentExecutorBuilder,
import software.amazon.awssdk.services.sts.StsClient;
            logger.debug("Using instance profile credentials");
        NettyNioAsyncHttpClient.Builder clientBuilder = NettyNioAsyncHttpClient.builder();
        final AwsCredentials basicCredentials = clientSettings.credentials;
    S3AsyncService(final Path configPath, @Nullable ScheduledExecutorService clientExecutorService) {
                    }
        return null;
        S3ClientSettings clientSettings,
            return InstanceProfileCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
    /**
/*
        AsyncExecutorContainer normalExecutorBuilder,
        }
            crtProxyConfiguration.host(clientSettings.proxySettings.getHostName());
        String asyncHttpClientType = S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE.get(repositoryMetadata.settings());
    }
            proxyConfiguration.host(clientSettings.proxySettings.getHostName());
import software.amazon.awssdk.core.retry.RetryMode;
        builder.httpClient(buildHttpClient(clientSettings, priorityExecutorBuilder.getAsyncTransferEventLoopGroup(), asyncHttpClientType));
    private static final String STS_ENDPOINT_OVERRIDE_SYSTEM_PROPERTY = "aws.stsEndpointOverride";
            AwsCredentialsProvider,
 */
        private AwsCredentialsProvider initializeProvider() {
                .advancedOption(
            logger.warn(
    ) {
    // proxy for testing
        clientBuilder.maxConcurrency(clientSettings.maxConnections);
    /**
                if (existing != null) {
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
                    asyncHttpClientType,
                return new PrivilegedSTSAssumeRoleSessionCredentialsProvider<>(stsClient, stsCredentialsProvider);
        // but can force objects from every response to the old generation.
    }
    /**
                    builder = builder.credentialsProvider(DefaultCredentialsProvider.create());
import java.util.Optional;
import software.amazon.awssdk.http.crt.ProxyConfiguration;
        if (irsaCredentials != null) {
            crtProxyConfiguration.port(clientSettings.proxySettings.getPort());
                            .build()
        }
        derivedClientSettings = emptyMap();
                .build()
    }
import org.opensearch.repositories.s3.S3ClientSettings.IrsaCredentials;
    ) {
                }
        releaseCachedClients();
        builder.credentialsProvider(credentials);
        if ((endpoint.startsWith("http://") || endpoint.startsWith("https://")) == false) {
    public void close() {
            if (SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_RELATIVE_URI.getStringValue().isPresent()
            StsClient stsClient = AccessController.doPrivileged(() -> {
     */
        private final P credentials;
                return clientReference;
     * Client settings derived from those in {@link #staticClientSettings} by combining them with settings
    }
            this.stsClient = stsClient;
            proxyConfiguration.username(clientSettings.proxySettings.getUsername());
class S3AsyncService implements Closeable {
        // others will shutdown on their respective release
    }
import org.opensearch.common.collect.MapBuilder;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
        resolveEndpointOverride(clientSettings).ifPresent(builder::endpointOverride);
            defaultBuilder.put(
import java.net.URI;
    ) {
        }
                        .roleArn(irsaCredentials.getRoleArn())
    private volatile Map<String, S3ClientSettings> staticClientSettings;
import org.opensearch.common.Nullable;
                        .roleSessionName(irsaCredentials.getRoleSessionName())
        builder.asyncConfiguration(
            proxyConfiguration.password(clientSettings.proxySettings.getPassword());
    }
        final Map<S3ClientSettings, AmazonAsyncS3Reference> clientsCacheMap = s3HttpClientTypesClientsCache.get(asyncHttpClientType);
    private volatile Map<Settings, S3ClientSettings> derivedClientSettings = emptyMap();
                }
        final S3AsyncClient client = AccessController.doPrivileged(builder::build);
        // There will be 2 types of caches CRT and Netty
            return AccessController.doPrivileged(credentials::resolveCredentials);
                clientsSettings.get(entrySet.getKey())
            final AmazonAsyncS3Reference newClientReference = new AmazonAsyncS3Reference(
    }
        AmazonAsyncS3Reference clientReference = getCachedClientForHttpTypeAndClientSettings(asyncHttpClientType, clientSettings);
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.awssdk.core.client.config.ClientAsyncConfiguration;
        builder.httpClient(buildHttpClient(clientSettings, normalExecutorBuilder.getAsyncTransferEventLoopGroup(), asyncHttpClientType));
        }
        // Only apply endpointOverride when the user explicitly configures "endpoint".
            crtProxyConfiguration.password(clientSettings.proxySettings.getPassword());
            if (existingClient != null) {
            builder.forcePathStyle(true);
