        AsyncExecutorContainer normalExecutorBuilder,  
        S3Service.setDefaultAwsProfilePath();
     * Client settings derived from those in {@link #staticClientSettings} by combining them with settings  
        // shutdown all unused clients
            return clientReference;
                    }
        }
import org.opensearch.common.Nullable;
        String roleArn = defaults.getRoleArn();
            builder = builder.scheduledExecutorService(clientExecutorService);  
            roleSessionName = System.getenv(SdkSystemSetting.AWS_ROLE_SESSION_NAME.environmentVariable());  
    static class PrivilegedInstanceProfileCredentialsProvider implements AwsCredentialsProvider {
     * @return S3ClientSettings  
        assert this.staticClientSettings.containsKey(buildClientName("default", S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE))
                    if (stsClient != null) {  
        final S3ClientSettings staticSettings = staticClientSettings.get(clientName);
            Closeable {
    @SuppressForbidden(reason = "Need to provide this override to v2 SDK so that path does not default to home path")
    }
            synchronized (this) {
        }
import java.io.Closeable;  
    private static final String STS_ENDPOINT_OVERRIDE_SYSTEM_PROPERTY = "aws.stsEndpointOverride";
            this.stsClient = stsClient;  
    }
            : "Static Client Settings should contain default CRT client";  
                + "]. Existing client configs: "
                        AssumeRoleRequest.builder()
        if ((endpoint.startsWith("http://") || endpoint.startsWith("https://")) == false) {
        final S3AsyncClient client = AccessController.doPrivileged(builder::build);  
     * Optional scheduled executor service to use for the client  
                }
        }
                buildClient(clientSettings, urgentExecutorBuilder, priorityExecutorBuilder, normalExecutorBuilder, asyncHttpClientType)  
        );
     */
                buildClientName("default", S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE),
                final String stsEndpoint = System.getProperty(STS_ENDPOINT_OVERRIDE_SYSTEM_PROPERTY);
            return AccessController.doPrivileged(credentials::resolveCredentials);
            );  
            )
            );
    /**
                            .roleSessionName(irsaCredentials.getRoleSessionName())
            proxyConfiguration.host(clientSettings.proxySettings.getHostName());
     */
        s3HttpClientTypesClientsCache = emptyMap();
                software.amazon.awssdk.http.nio.netty.ProxyConfiguration.builder();  
        // others will shutdown on their respective release
    public synchronized void refreshAndClearCache(Map<String, S3ClientSettings> clientsSettings) {  
    }  
     * Package-private to allow unit testing.
                        .stsClient(stsClient)
    public void close() {
    Optional<URI> resolveEndpointOverride(final S3ClientSettings clientSettings) {
    private volatile Map<Settings, S3ClientSettings> derivedClientSettings = emptyMap();  
    static SdkAsyncHttpClient buildAsyncNettyHttpClient(
                return newSettings;
    static SdkAsyncHttpClient buildAsyncCrtHttpClient(final S3ClientSettings clientSettings) {
}  
    private String buildClientName(final String clientValue, final String asyncClientType) {
class S3AsyncService implements Closeable {
            AmazonAsyncS3Reference existingClient = getCachedClientForHttpTypeAndClientSettings(asyncHttpClientType, clientSettings);
            logger.debug("Using instance profile credentials");
        builder.responseChecksumValidation(ResponseChecksumValidation.WHEN_REQUIRED)
                    + S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE
    private volatile Map<String, S3ClientSettings> staticClientSettings;  
    }
                    stsCredentialsProviderBuilder::build
        this.clientExecutorService = clientExecutorService;
        }  
        final S3ClientSettings clientSettings,  
            defaultBuilder.put(  
        RepositoryMetadata repositoryMetadata,  
        final S3ClientSettings clientSettings,
import org.opensearch.cluster.metadata.RepositoryMetadata;  
            return null;  
    }
    /**
     * in the {@link RepositoryMetadata}.
            crtProxyConfiguration.password(clientSettings.proxySettings.getPassword());  
                .throttlingBackoffStrategy(
        } else {  
                final StsWebIdentityTokenFileCredentialsProvider.Builder stsCredentialsProviderBuilder =
                    urgentExecutorBuilder.getFutureCompletionExecutor()
            roleArn = System.getenv(SdkSystemSetting.AWS_ROLE_ARN.environmentVariable());
    }
    }
        }
     */
            );
     * Attempts to retrieve a client by its repository metadata and settings from the cache.
                    );  
    S3AsyncService(final Path configPath, @Nullable ScheduledExecutorService clientExecutorService) {
        derivedClientSettings = emptyMap();
            defaultBuilder.put(
        final S3AsyncClient priorityClient = AccessController.doPrivileged(builder::build);
        private final P credentials;
        clientBuilder.maxConcurrency(clientSettings.maxConnections);
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        releaseCachedClients();  
import java.net.URI;
        }  
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
        builder.credentialsProvider(credentials);
    static AwsCredentialsProvider buildCredentials(Logger logger, S3ClientSettings clientSettings) {
import software.amazon.awssdk.services.sts.StsClientBuilder;
        for (Map.Entry<String, S3ClientSettings> entrySet : clientsSettings.entrySet()) {
                return existingClient;
        implements
        // This is required for ARN buckets (access points / outposts / MRAP), and is also correct for normal buckets.
    }
            if (SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_RELATIVE_URI.getStringValue().isPresent()
        );  
     * Client settings calculated from static configuration and settings in the keystore.
import software.amazon.awssdk.services.sts.auth.StsAssumeRoleCredentialsProvider;  
        return null;
        AsyncTransferEventLoopGroup asyncTransferEventLoopGroup,
    private volatile Map<String, Map<S3ClientSettings, AmazonAsyncS3Reference>> s3HttpClientTypesClientsCache = emptyMap();
    }
        // If "endpoint" is absent, DO NOT override; allow the AWS SDK to resolve endpoints dynamically.
                    builder = builder.credentialsProvider(DefaultCredentialsProvider.create());
            this.credentials = credentials;
        AsyncExecutorContainer priorityExecutorBuilder,
                );
            .put(
        final S3ClientSettings clientSettings
        final S3AsyncClient urgentClient = AccessController.doPrivileged(builder::build);  
                    builder = builder.endpointOverride(URI.create(stsEndpoint));
import software.amazon.awssdk.services.sts.StsClient;
                .build()  
        crtClientBuilder.maxConcurrency(clientSettings.maxConnections);  
            return InstanceProfileCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
                    return existing;
            webIdentityTokenFile = System.getenv(SdkSystemSetting.AWS_WEB_IDENTITY_TOKEN_FILE.environmentVariable());
            // Update both cache levels atomically
            logger.debug("Using IRSA credentials");
                    builder = builder.credentialsProvider(StaticCredentialsProvider.create(basicCredentials));
                final S3ClientSettings existing = derivedClientSettings.get(settings);
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
package org.opensearch.repositories.s3;
        }
    }  
import software.amazon.awssdk.core.retry.RetryMode;
 * SPDX-License-Identifier: Apache-2.0
        final S3ClientSettings clientSettings,  
        public void close() throws IOException {
/*  
import software.amazon.awssdk.core.client.config.ClientAsyncConfiguration;
            return new PrivilegedInstanceProfileCredentialsProvider();
        }  
                    SdkAdvancedAsyncClientOption.FUTURE_COMPLETION_EXECUTOR,
        throw new IllegalArgumentException(
            this.credentials = initializeProvider();  
            builder.apiCallTimeout(Duration.ofMillis(clientSettings.apiCallTimeoutMillis));
    @Nullable
        builder.httpClient(buildHttpClient(clientSettings, urgentExecutorBuilder.getAsyncTransferEventLoopGroup(), asyncHttpClientType));  
    S3AsyncService(final Path configPath) {
    }  
        }  
        }
 *
        String asyncHttpClientType
                    asyncHttpClientType,
        }
                .numRetries(clientSettings.maxRetries)
        public AwsCredentials resolveCredentials() {
                    + " client type"
    ) {
    @Override  
        for (Map<S3ClientSettings, AmazonAsyncS3Reference> clientTypeCaches : s3HttpClientTypesClientsCache.values()) {
                || SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_FULL_URI.getStringValue().isPresent()) {
            }
     */
        final String asyncHttpClientType
                return new PrivilegedSTSAssumeRoleSessionCredentialsProvider<>(stsClient, stsCredentialsProvider);
                StsClientBuilder builder = StsClient.builder().region(region);  
                        stsClient.close();
        private AwsCredentialsProvider initializeProvider() {  
     * of being returned to the cache.
            return Optional.empty();  
            proxyConfiguration.password(clientSettings.proxySettings.getPassword());
        final String clientName = buildClientName(
        synchronized (this) {
                });  
            )
    static class PrivilegedSTSAssumeRoleSessionCredentialsProvider<P extends AwsCredentialsProvider & AutoCloseable>
        return clientBuilder.build();
        resolveEndpointOverride(clientSettings).ifPresent(builder::endpointOverride);  
        AwsCrtAsyncHttpClient.Builder crtClientBuilder = AwsCrtAsyncHttpClient.builder();  
                derivedClientSettings = MapBuilder.newMapBuilder(derivedClientSettings).put(settings, newSettings).immutableMap();
                    .refreshRequest(
        }
                return new PrivilegedSTSAssumeRoleSessionCredentialsProvider<>(stsClient, stsCredentialsProvider);  
        if (webIdentityTokenFile == null) {
import org.opensearch.common.SuppressForbidden;
        private final StsClient stsClient;  
    private static void setDefaultAwsProfilePath() {  
            .requestChecksumCalculation(RequestChecksumCalculation.WHEN_REQUIRED);
        public AwsCredentials resolveCredentials() {
        {
        clientBuilder.connectionTimeout(Duration.ofMillis(clientSettings.connectionTimeoutMillis));
            "Unknown s3 client name ["  
import java.util.concurrent.ScheduledExecutorService;
            if (clientReference != null && clientReference.tryIncRef()) {
        ClientOverrideConfiguration.Builder builder = ClientOverrideConfiguration.builder();
    }  
                asyncHttpClientType,  
        final Settings settings = repositoryMetadata.settings();  
                buildClientName(entrySet.getKey(), S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE),
import software.amazon.awssdk.services.s3.S3AsyncClient;
    /**
    private static IrsaCredentials buildFromEnvironment(IrsaCredentials defaults) {
        assert this.staticClientSettings.containsKey(buildClientName("default", S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE))  
    private AmazonAsyncS3Reference getCachedClientForHttpTypeAndClientSettings(  
        AmazonAsyncS3Reference clientReference = getCachedClientForHttpTypeAndClientSettings(asyncHttpClientType, clientSettings);
 */  
import software.amazon.awssdk.regions.Region;  
            crtProxyConfiguration.port(clientSettings.proxySettings.getPort());
        );
        }
import software.amazon.awssdk.http.nio.netty.SdkEventLoopGroup;
                S3ClientSettings.getClientSettings(Settings.EMPTY, "default", configPath)
        builder.overrideConfiguration(buildOverrideConfiguration(clientSettings, clientExecutorService));
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;  
        @Override
    // valid paths.
        }
            crtProxyConfiguration.host(clientSettings.proxySettings.getHostName());  
                "AWS CRT client is not available on the target platform, falling back to "  
    /**  
                .build()
                final StsAssumeRoleCredentialsProvider stsCredentialsProvider = AccessController.doPrivileged(
                } else {  
    synchronized AmazonAsyncS3WithCredentials buildClient(
            // the clients will shutdown when they will not be used anymore  
        if (Strings.hasLength(clientSettings.endpoint) == false) {
import java.io.IOException;
        builder.asyncConfiguration(  
        final AwsCredentialsProvider credentials = buildCredentials(logger, clientSettings);  
            if (existingClient != null) {  
                throw (IOException) e;
                final StsAssumeRoleCredentialsProvider.Builder stsCredentialsProviderBuilder = StsAssumeRoleCredentialsProvider.builder()
        }  
            if (irsaCredentials.getIdentityTokenFile() == null) {
                    StsWebIdentityTokenFileCredentialsProvider.builder()  
        if (S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE.equals(asyncHttpClientType)) {
                    .stsClient(stsClient)  
            ClientAsyncConfiguration.builder()
            });
import java.nio.file.Path;  
        // the response metadata cache is only there for diagnostics purposes,  
     * Either fetches {@link S3ClientSettings} for a given {@link RepositoryMetadata} from cached settings or creates them  
                    normalExecutorBuilder.getFutureCompletionExecutor()  
                    SdkAdvancedAsyncClientOption.FUTURE_COMPLETION_EXECUTOR,  
    // We can segregate the types of cache here itself  
        AsyncExecutorContainer urgentExecutorBuilder,
        final AsyncTransferEventLoopGroup asyncTransferEventLoopGroup
        crtClientBuilder.connectionTimeout(Duration.ofMillis(clientSettings.connectionTimeoutMillis));
            Map<S3ClientSettings, AmazonAsyncS3Reference> clientsCacheForType = s3HttpClientTypesClientsCache.getOrDefault(
                );
    /**  
 * this file be licensed under the Apache-2.0 license or a
        final Map<S3ClientSettings, AmazonAsyncS3Reference> clientsCacheMap = s3HttpClientTypesClientsCache.get(asyncHttpClientType);
                        .roleArn(irsaCredentials.getRoleArn())
        clientBuilder.eventLoopGroup(SdkEventLoopGroup.create(asyncTransferEventLoopGroup.getEventLoopGroup()));
        if (clientSettings.pathStyleAccess) {
        return clientExecutorService;
            } catch (Exception e) {
        // If IAM Roles for Service Accounts (IRSA) credentials are configured, start with them first  
import software.amazon.awssdk.core.retry.backoff.BackoffStrategy;  
        if (roleSessionName == null) {
                return existing;
        }
                    credentials.close();
        }
            } else {
        builder.asyncConfiguration(
import software.amazon.awssdk.http.crt.ProxyConfiguration;  
     */
import org.apache.logging.log4j.LogManager;
            proxyConfiguration.port(clientSettings.proxySettings.getPort());  
     */  
    }
            builder.addPlugin(LegacyMd5Plugin.create());
import software.amazon.awssdk.services.sts.auth.StsWebIdentityTokenFileCredentialsProvider;
        // Use URI.create for simplicity; if your codebase prefers checked handling, swap to new URI(endpoint).
                if (existing != null) {  
            logger.warn(
            crtProxyConfiguration.username(clientSettings.proxySettings.getUsername());
    static SdkAsyncHttpClient buildHttpClient(
    ) {  
    /**
                    clientSettings.throttleRetries ? BackoffStrategy.defaultThrottlingStrategy(RetryMode.STANDARD) : BackoffStrategy.none()  
            }  
        releaseCachedClients();
                clientReference.decRef();
            if (existing != null) {  
                    MapBuilder.newMapBuilder(clientsCacheForType).put(clientSettings, newClientReference).immutableMap()
        builder.asyncConfiguration(
                    stsCredentialsProviderBuilder::build  
        return builder.build();
            }
                return clientReference;
        return Optional.of(URI.create(endpoint));
import software.amazon.awssdk.auth.credentials.ContainerCredentialsProvider;  
        AsyncExecutorContainer normalExecutorBuilder  
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
     * @param repositoryMetadata Repository Metadata
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
        }
            builder.forcePathStyle(true);  
        private PrivilegedInstanceProfileCredentialsProvider() {
            // If the client reference is not found in cache. Let's create it.
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
        );
import software.amazon.awssdk.services.s3.LegacyMd5Plugin;
        }
        final S3AsyncClientBuilder builder = S3AsyncClient.builder();
                .build()
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
     */
     *
        staticClientSettings = defaultBuilder.immutableMap();
    public AmazonAsyncS3Reference client(
        }  
        AsyncExecutorContainer urgentExecutorBuilder,
                + clientName
import java.util.Map;
        clientBuilder.maxPendingConnectionAcquires(10_000);  
            StsClient stsClient = AccessController.doPrivileged(() -> {
        if (defaults == null) {
            );  
        S3ClientSettings clientSettings,  
        if (roleArn == null) {  
            software.amazon.awssdk.http.nio.netty.ProxyConfiguration.Builder proxyConfiguration =
                .advancedOption(  
import software.amazon.awssdk.core.checksums.ResponseChecksumValidation;  
    // pkg private for tests
            for (final AmazonAsyncS3Reference clientReference : clientTypeCaches.values()) {
        private final AwsCredentialsProvider credentials;  
            );
    private static final Logger logger = LogManager.getLogger(S3AsyncService.class);  
                S3ClientSettings.getClientSettings(Settings.EMPTY, "default", configPath)  
                        .webIdentityTokenFile(Path.of(irsaCredentials.getIdentityTokenFile()));
            return newClientReference;
import org.opensearch.repositories.s3.S3ClientSettings.IrsaCredentials;  
import org.opensearch.common.collect.MapBuilder;  
            return buildAsyncNettyHttpClient(clientSettings, asyncTransferEventLoopGroup);  
            return AccessController.doPrivileged(credentials::resolveCredentials);  
    ) {
        setDefaultAwsProfilePath();  
        derivedClientSettings = emptyMap();
                }
            return StaticCredentialsProvider.create(basicCredentials);
    }
        if (clientSettings.apiCallTimeoutMillis > 0) {
    static ClientOverrideConfiguration buildOverrideConfiguration(
            newClientReference.incRef();
     * Returns an endpoint override ONLY when the user explicitly provided one.
 * compatible open source license.
    public synchronized void releaseCachedClients() {  
            ClientAsyncConfiguration.builder()  
        }
            : "Static Client Settings should contain default Netty client";
            endpoint = clientSettings.protocol.toString() + "://" + endpoint;
            S3Repository.CLIENT_NAME.get(settings),
        builder.retryPolicy(retryPolicy).apiCallAttemptTimeout(Duration.ofMillis(clientSettings.requestTimeoutMillis));  
    ) {
        if (staticSettings != null) {  
        // TODO: add max retry and UseThrottleRetry. Replace values with settings and put these in default settings  
        AsyncExecutorContainer priorityExecutorBuilder,
            // InstanceProfileCredentialsProvider as last item of chain  
            ProxyConfiguration.Builder crtProxyConfiguration = ProxyConfiguration.builder();  
                emptyMap()
                }
            }  
        }
        );  
            S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE.get(repositoryMetadata.settings())  
import org.opensearch.repositories.s3.utils.AwsCrtUtils;  
                clientsSettings.get(entrySet.getKey())
        MapBuilder<String, S3ClientSettings> defaultBuilder = MapBuilder.newMapBuilder();
    S3ClientSettings settings(RepositoryMetadata repositoryMetadata) {
                )  
import java.util.Optional;  
        this(configPath, null);  
                buildClientName(entrySet.getKey(), S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE),
            // Manually add the schema to the endpoint to work around https://github.com/aws/aws-sdk-java/issues/2274
        if (clientSettings.legacyMd5ChecksumCalculation) {  
            .put(
        final String asyncHttpClientType,
import software.amazon.awssdk.services.s3.S3AsyncClientBuilder;  
            }  
        }
import software.amazon.awssdk.core.checksums.RequestChecksumCalculation;
            crtClientBuilder.proxyConfiguration(crtProxyConfiguration.build());
    // Also adding the Http Client type in S3ClientSettings is not good option since it is used by Async and Sync clients.
import software.amazon.awssdk.core.SdkSystemSetting;
            // Get or create new client cache map for the HTTP client type
     * If the client does not exist it will be created.  
        NettyNioAsyncHttpClient.Builder clientBuilder = NettyNioAsyncHttpClient.builder();
            () -> RetryPolicy.builder()  
        if (clientSettings.proxySettings.getType() != ProxySettings.ProxyType.DIRECT) {
        ScheduledExecutorService clientExecutorService  
                )
        if (clientSettings.proxySettings.getType() != ProxySettings.ProxyType.DIRECT) {
        logger.debug("S3 Http client type [{}]", asyncHttpClientType);
                return builder.build();
        // Only apply endpointOverride when the user explicitly configures "endpoint".  
        builder.httpClient(buildHttpClient(clientSettings, normalExecutorBuilder.getAsyncTransferEventLoopGroup(), asyncHttpClientType));
        } else {
    }  
import org.opensearch.core.common.Strings;
    }  
            proxyConfiguration.username(clientSettings.proxySettings.getUsername());
                .build()
            return buildAsyncCrtHttpClient(clientSettings);  
        builder.httpClient(buildHttpClient(clientSettings, priorityExecutorBuilder.getAsyncTransferEventLoopGroup(), asyncHttpClientType));
        final S3ClientSettings clientSettings = settings(repositoryMetadata);
        // There will be 2 types of caches CRT and Netty
        }  
                .put(  
            clientBuilder.proxyConfiguration(proxyConfiguration.build());  
        }
        RetryPolicy retryPolicy = AccessController.doPrivileged(
                if (stsEndpoint != null) {  
    }  
        } else if (basicCredentials != null) {  
        final AwsCredentials basicCredentials = clientSettings.credentials;  
                clientsSettings.get(entrySet.getKey())  
    // We will need to support the cache with both type of clients. Since S3ClientSettings doesn't contain Http Client.
                + Strings.collectionToDelimitedString(staticClientSettings.keySet(), ",")  
            }
                )  
                )
                            .build()
                        .roleSessionName(irsaCredentials.getRoleSessionName())  
        @Override
            }  
        // clients are built lazily by {@link client}
            crtProxyConfiguration.scheme(clientSettings.proxySettings.getType().toProtocol().toString());
import software.amazon.awssdk.core.client.config.SdkAdvancedAsyncClientOption;  
                            .roleArn(irsaCredentials.getRoleArn())  
        String roleSessionName = defaults.getRoleSessionName();
    }
                .immutableMap();
                if (basicCredentials != null) {
            final Region region = Region.of(clientSettings.region);
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
                )
 * The OpenSearch Contributors require contributions made to  
            final AmazonAsyncS3Reference newClientReference = new AmazonAsyncS3Reference(
            final AmazonAsyncS3Reference clientReference = clientsCacheMap.get(clientSettings);  
        );
            }
            s3HttpClientTypesClientsCache = MapBuilder.newMapBuilder(s3HttpClientTypesClientsCache)
        }
            final S3ClientSettings existing = derivedClientSettings.get(settings);
        final IrsaCredentials irsaCredentials = buildFromEnvironment(clientSettings.irsaCredentials);
        if (clientReference != null) {  
        return clientValue + "-" + asyncClientType;
    ) {  
    }
        String asyncHttpClientType = S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE.get(repositoryMetadata.settings());
     * existing clients. New clients will be build using these new settings. Old
                AccessController.doPrivilegedChecked(() -> {
                buildClientName("default", S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE),  
import static java.util.Collections.emptyMap;  
    ) {
    /**
    // Aws v2 sdk tries to load a default profile from home path which is restricted. Hence, setting these to random  
                .advancedOption(
     * Otherwise returns Optional.empty().  
        String webIdentityTokenFile = defaults.getIdentityTokenFile();  
        if (irsaCredentials != null) {
    private final @Nullable ScheduledExecutorService clientExecutorService;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
            proxyConfiguration.scheme(clientSettings.proxySettings.getType().toProtocol().toString());
        clientBuilder.connectionAcquisitionTimeout(Duration.ofMillis(clientSettings.connectionAcquisitionTimeoutMillis));
                    priorityExecutorBuilder.getFutureCompletionExecutor()
        }
        if (clientExecutorService != null) {
                .advancedOption(
            logger.debug("Using basic key/secret credentials");
        clientBuilder.tcpKeepAlive(true);  
        // but can force objects from every response to the old generation.
        return new IrsaCredentials(webIdentityTokenFile, roleArn, roleSessionName);  
        @Override  
    ScheduledExecutorService getClientExecutorService() {  
     * by overriding static client settings from {@link #staticClientSettings} with settings found in the repository metadata.
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;
                final StsWebIdentityTokenFileCredentialsProvider stsCredentialsProvider = AccessController.doPrivileged(  
        builder.region(Region.of(clientSettings.region));
        staticClientSettings = MapBuilder.<String, S3ClientSettings>newMapBuilder()  
            // TODO: Remove this once fixed in the AWS SDK  
import org.opensearch.secure_sm.AccessController;
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
import org.apache.logging.log4j.Logger;
            return buildAsyncNettyHttpClient(clientSettings, asyncTransferEventLoopGroup);
        if (clientsCacheMap != null && !clientsCacheMap.isEmpty()) {
        if (AwsCrtUtils.isAwsCrtAvailable() == true) {
    }
        return crtClientBuilder.build();
        String endpoint = clientSettings.endpoint;  
            AwsCredentialsProvider,  
        // clear previously cached clients, they will be build lazily  
import software.amazon.awssdk.core.retry.RetryPolicy;
     * Refreshes the settings for the AmazonS3 clients and clears the cache of
                return ContainerCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
    }
        return AmazonAsyncS3WithCredentials.create(client, priorityClient, urgentClient, credentials);
        private PrivilegedSTSAssumeRoleSessionCredentialsProvider(@Nullable final StsClient stsClient, final P credentials) {
                final S3ClientSettings newSettings = staticSettings.refine(settings);  
import java.time.Duration;
        }
            ClientAsyncConfiguration.builder()
     * clients are usable until released. On release they will be destroyed instead  
                    SdkAdvancedAsyncClientOption.FUTURE_COMPLETION_EXECUTOR,
            try {  
    // proxy for testing
import org.opensearch.common.settings.Settings;
            .immutableMap();  
