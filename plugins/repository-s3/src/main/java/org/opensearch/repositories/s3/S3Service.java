            );
import software.amazon.awssdk.core.checksums.RequestChecksumCalculation;
        private PrivilegedInstanceProfileCredentialsProvider() {
            builder.forcePathStyle(true);
        }
        ClientOverrideConfiguration.Builder clientOverrideConfiguration = ClientOverrideConfiguration.builder();
import static java.util.Collections.emptyMap;
                }
            synchronized (this) {
            ? Protocol.HTTP
    @Override
        }
        }
            try {
import java.io.IOException;
        }
            return InstanceProfileCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
    /**
import software.amazon.awssdk.core.client.config.SdkAdvancedClientOption;
            : clientSettings.proxySettings.getType().toProtocol();
        if (clientSettings.apiCallTimeoutMillis > 0) {
 *
        Protocol proxyProtocol = clientSettings.proxySettings.getType() == ProxySettings.ProxyType.DIRECT
        }
import java.net.Socket;
        // Only apply endpointOverride when the user explicitly configures "endpoint".
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        proxyConfiguration = proxyConfiguration.username(clientSettings.proxySettings.getUsername());
                AwsRequestSigner.fromSignerName(clientSettings.signerOverride).getSigner()
        }
 * not use this file except in compliance with the License.
                final StsAssumeRoleCredentialsProvider.Builder stsCredentialsProviderBuilder = StsAssumeRoleCredentialsProvider.builder()
                new URI(
 * this file be licensed under the Apache-2.0 license or a
/*
                AccessController.doPrivilegedChecked(() -> {
        }
    public synchronized void releaseCachedClients() {
    static ApacheHttpClient.Builder buildHttpClient(S3ClientSettings clientSettings) {
                if (Strings.hasText(clientSettings.region)) {
    static class PrivilegedSTSAssumeRoleSessionCredentialsProvider<P extends AwsCredentialsProvider & AutoCloseable>
                @Override
                        .roleArn(irsaCredentials.getRoleArn())
                        });
     */
import software.amazon.awssdk.core.retry.backoff.BackoffStrategy;
import java.net.InetSocketAddress;
        final String clientName = S3Repository.CLIENT_NAME.get(settings);
    // pkg private for tests
    }
                    );
            return AccessController.doPrivileged(credentials::resolveCredentials);
            .apiCallAttemptTimeout(Duration.ofMillis(clientSettings.requestTimeoutMillis));
 *
            final S3ClientSettings existing = derivedClientSettings.get(settings);
                    builder = builder.credentialsProvider(DefaultCredentialsProvider.create());
            clientOverrideConfiguration.apiCallTimeout(Duration.ofMillis(clientSettings.apiCallTimeoutMillis));
        return proxyConfiguration.build();
        public AwsCredentials resolveCredentials() {
    }
    }
 * license agreements. See the NOTICE file distributed with
        ApacheHttpClient.Builder clientBuilder = ApacheHttpClient.builder();
            if (clientSettings.proxySettings.getType() == ProxySettings.ProxyType.SOCKS) {
     * Optional scheduled executor service to use for the client
        if (irsaCredentials != null) {
    }
     * of being returned to the cache.
                return existing;
        // others will shutdown on their respective release
 */
import org.opensearch.repositories.s3.utils.Protocol;
    }
                    clientBuilder.socketFactory(createSocksSslConnectionSocketFactory(clientSettings.proxySettings.getAddress()));
import org.apache.logging.log4j.LogManager;
                                    clientSettings.proxySettings.getUsername(),
import org.opensearch.common.SuppressForbidden;
import software.amazon.awssdk.services.sts.StsClientBuilder;
        if (clientExecutorService != null) {
        if (staticSettings != null) {
                if (existing != null) {
        this(configPath, null);
        throw new IllegalArgumentException(
    private volatile Map<Settings, S3ClientSettings> derivedClientSettings = new ConcurrentHashMap<>();
        try {
        } else {
     * Either fetches {@link S3ClientSettings} for a given {@link RepositoryMetadata} from cached settings or creates them
            .immutableMap();
        assert this.staticClientSettings.containsKey("default") : "always at least have 'default'";
                SdkAdvancedClientOption.SIGNER,
import software.amazon.awssdk.core.exception.SdkException;
        if (clientSettings.proxySettings.getType() == ProxySettings.ProxyType.SOCKS) {
                        stsClient.close();
        if (Strings.hasLength(clientSettings.endpoint) == false) {
import software.amazon.awssdk.http.SystemPropertyTlsKeyManagersProvider;
                return existing;
        if (ProfileFileSystemSetting.AWS_CONFIG_FILE.getStringValue().isEmpty()) {
            }
                + "]. Existing client configs: "
                final StsAssumeRoleCredentialsProvider stsCredentialsProvider = AccessController.doPrivileged(
        }
 * under the License.
/*
                derivedClientSettings = MapBuilder.newMapBuilder(derivedClientSettings).put(settings, newSettings).immutableMap();
import software.amazon.awssdk.services.sts.auth.StsAssumeRoleCredentialsProvider;
            retryPolicy.throttlingBackoffStrategy(BackoffStrategy.defaultThrottlingStrategy(RetryMode.STANDARD));
        return new IrsaCredentials(webIdentityTokenFile, roleArn, roleSessionName);
            logger.debug("Using IRSA credentials");
        }
    static ClientOverrideConfiguration buildOverrideConfiguration(
    ) {
        }
import java.net.Authenticator;
    public AmazonS3Reference client(RepositoryMetadata repositoryMetadata) {
                                    clientSettings.proxySettings.getPassword().toCharArray()
        if (roleArn == null) {
    }
                final StsWebIdentityTokenFileCredentialsProvider.Builder stsCredentialsProviderBuilder =
        }
    Optional<URI> resolveEndpointOverride(final S3ClientSettings clientSettings) {
                return clientReference;
        public AwsCredentials resolveCredentials() {
      */
        // Use URI.create for simplicity; if your codebase prefers checked handling, swap to new URI(endpoint).
import java.util.Map;
        clientsCache = emptyMap();
        @Override
                + clientName
            builder.addPlugin(LegacyMd5Plugin.create());
        final Settings settings = repositoryMetadata.settings();
    // valid paths.
                                return new PasswordAuthentication(
    // Aws v2 sdk tries to load a default profile from home path which is restricted. Hence, setting these to random
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
import software.amazon.awssdk.auth.credentials.ContainerCredentialsProvider;
        clientOverrideConfiguration.retryPolicy(retryPolicy.build())
        if (!clientSettings.throttleRetries) {
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
            final AmazonS3Reference clientReference = clientsCache.get(clientSettings);
        }
            AccessController.doPrivileged(
                    clientSettings.proxySettings.getPort(),
     * Refreshes the settings for the AmazonS3 clients and clears the cache of
        // clients are built lazily by {@link client}
            roleArn = System.getenv(SdkSystemSetting.AWS_ROLE_ARN.environmentVariable());
            if (irsaCredentials.getIdentityTokenFile() == null) {
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        releaseCachedClients();
            } else {
    // proxy for testing
        derivedClientSettings = emptyMap();
                return new PrivilegedSTSAssumeRoleSessionCredentialsProvider<>(stsClient, stsCredentialsProvider);
            this.credentials = initializeProvider();
import software.amazon.awssdk.profiles.ProfileFileSystemSetting;
        } else {
        // clear previously cached clients, they will be build lazily
        for (final AmazonS3Reference clientReference : clientsCache.values()) {
        if (ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.getStringValue().isEmpty()) {
    /**
            clientOverrideConfiguration = clientOverrideConfiguration.putAdvancedOption(
            return StaticCredentialsProvider.create(basicCredentials);
            }
            return new PrivilegedInstanceProfileCredentialsProvider();
    }
                    null
                });
            webIdentityTokenFile = System.getenv(SdkSystemSetting.AWS_WEB_IDENTITY_TOKEN_FILE.environmentVariable());
                    proxyProtocol.toString(),
import java.time.Duration;
                    null,
        if (roleSessionName == null) {
import software.amazon.awssdk.services.sts.auth.StsWebIdentityTokenFileCredentialsProvider;
                            @Override
                    builder.region(Region.of(clientSettings.region));
        synchronized (this) {
                || SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_FULL_URI.getStringValue().isPresent()) {
                            .build()
        return clientOverrideConfiguration.build();
     */
        final S3ClientSettings clientSettings = settings(repositoryMetadata);
            }
        builder.httpClientBuilder(buildHttpClient(clientSettings));
      *
import org.opensearch.common.collect.MapBuilder;
                            .roleSessionName(irsaCredentials.getRoleSessionName())
                    .stsClient(stsClient)
            this.stsClient = stsClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
            }
    private static IrsaCredentials buildFromEnviroment(IrsaCredentials defaults) {
                public Socket createSocket(final HttpContext ctx) throws IOException {
    }
import org.apache.http.protocol.HttpContext;
    public void close() {
            if (clientReference != null && clientReference.tryIncRef()) {
 */
                StsClientBuilder builder = StsClient.builder();
        derivedClientSettings = emptyMap();
        clientBuilder.socketTimeout(Duration.ofMillis(clientSettings.readTimeoutMillis));
        } else if (basicCredentials != null) {
        private final AwsCredentialsProvider credentials;
import org.opensearch.core.common.Strings;
    /**
    private final @Nullable ScheduledExecutorService clientExecutorService;
    ScheduledExecutorService getClientExecutorService() {
        private AwsCredentialsProvider initializeProvider() {
            final AmazonS3Reference existing = clientsCache.get(clientSettings);
        return Optional.of(URI.create(endpoint));
      * Returns an endpoint override ONLY when the user explicitly provided one.
            };
    /**
                () -> System.setProperty(
            proxyConfiguration = proxyConfiguration.endpoint(
    private static final Logger logger = LogManager.getLogger(S3Service.class);
import java.security.NoSuchAlgorithmException;
     * in the {@link RepositoryMetadata}.
     * @param repositoryMetadata Repository Metadata
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
    AmazonS3WithCredentials buildClient(final S3ClientSettings clientSettings) {
            AwsCredentialsProvider,
        }
                    if (clientSettings.proxySettings.isAuthenticated()) {
            builder.serviceConfiguration(s -> s.chunkedEncodingEnabled(false));
                return ContainerCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
     * by overriding static client settings from {@link #staticClientSettings} with settings found in the repository metadata.
 * Unless required by applicable law or agreed to in writing,
                            }
        final S3ClientBuilder builder = S3Client.builder();
        if (clientSettings.disableChunkedEncoding) {
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
     * clients are usable until released. On release they will be destroyed instead
            throw SdkException.create("Exception during SSL context creation for SOCKS proxy", e);
            }
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.awssdk.services.s3.S3ClientBuilder;
    static class PrivilegedInstanceProfileCredentialsProvider implements AwsCredentialsProvider {
        try {
import software.amazon.awssdk.auth.credentials.AwsCredentials;
                }
/*
                    }
            logger.debug("Using instance profile credentials");
        // This part was taken from AWS settings
                        AssumeRoleRequest.builder()
        clientBuilder.maxConnections(clientSettings.maxSyncConnections);
    public synchronized void refreshAndClearCache(Map<String, S3ClientSettings> clientsSettings) {
     * If the client does not exist it will be created.
        }
        String endpoint = clientSettings.endpoint;
        builder.credentialsProvider(credentials);
            clientsCache = MapBuilder.newMapBuilder(clientsCache).put(clientSettings, clientReference).immutableMap();
        }
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
                }
        // If IAM Roles for Service Accounts (IRSA) credentials are configured, start with them first
      * Otherwise returns Optional.empty().
                    return new Socket(new Proxy(Proxy.Type.SOCKS, address));
import javax.net.ssl.SSLContext;
                return newSettings;
        }
        }
                                );
        @Override
            return proxyConfiguration.build();
 * compatible open source license.
                    null,
 * Modifications Copyright OpenSearch Contributors. See
        }
        return AmazonS3WithCredentials.create(client, credentials);
                    clientSettings.proxySettings.getHost(),
      * Package-private to allow unit testing.
            return null;
            retryPolicy.throttlingBackoffStrategy(BackoffStrategy.none());
     */
            this.credentials = credentials;
     */
        public void close() throws IOException {
import software.amazon.awssdk.core.retry.RetryPolicy;
                return new PrivilegedSTSAssumeRoleSessionCredentialsProvider<>(stsClient, stsCredentialsProvider);
            // Manually add the schema to the endpoint to work around https://github.com/aws/aws-sdk-java/issues/2274
                    credentials.close();
        {
        }
                }
    private static final String STS_ENDPOINT_OVERRIDE_SYSTEM_PROPERTY = "aws.stsEndpointOverride";
        );
            );
                )
            StsClient stsClient = AccessController.doPrivileged(() -> {
 */
    }
        }
        private final StsClient stsClient;
        setDefaultAwsProfilePath();
import org.apache.logging.log4j.Logger;
            AccessController.doPrivileged(
        if (Strings.hasLength(clientSettings.signerOverride)) {
        resolveEndpointOverride(clientSettings).ifPresent(builder::endpointOverride);
        String roleSessionName = defaults.getRoleSessionName();
    private volatile Map<String, S3ClientSettings> staticClientSettings;
import software.amazon.awssdk.regions.Region;
        }
            builder.region(Region.of(clientSettings.region));
                    return existing;
                final S3ClientSettings existing = derivedClientSettings.get(settings);
import java.net.URI;
                });
        final S3Client client = AccessController.doPrivileged(builder::build);
    }
import software.amazon.awssdk.core.checksums.ResponseChecksumValidation;
    static ProxyConfiguration buildHttpProxyConfiguration(S3ClientSettings clientSettings) {
                () -> System.setProperty(ProfileFileSystemSetting.AWS_CONFIG_FILE.property(), System.getProperty("opensearch.path.conf"))
import java.net.PasswordAuthentication;
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.secure_sm.AccessController;
        }
            clientOverrideConfiguration = clientOverrideConfiguration.scheduledExecutorService(clientExecutorService);
package org.opensearch.repositories.s3;
 * You may obtain a copy of the License at
            endpoint = clientSettings.protocol.toString() + "://" + endpoint;
        @Nullable ScheduledExecutorService clientExecutorService
        }
    }
        staticClientSettings = MapBuilder.<String, S3ClientSettings>newMapBuilder()
            );
 *
        private PrivilegedSTSAssumeRoleSessionCredentialsProvider(@Nullable final StsClient stsClient, final P credentials) {
        final AwsCredentials basicCredentials = clientSettings.credentials;
            // InstanceProfileCredentialsProvider as last item of chain
        releaseCachedClients();
        proxyConfiguration = proxyConfiguration.password(clientSettings.proxySettings.getPassword());
        final S3ClientSettings clientSettings,
                final S3ClientSettings newSettings = staticSettings.refine(settings);
            () -> RetryPolicy.builder().numRetries(clientSettings.maxRetries).retryCapacityCondition(null)
                        Authenticator.setDefault(new Authenticator() {
import software.amazon.awssdk.services.sts.StsClient;
     * @return S3ClientSettings
    /**
            final AmazonS3Reference clientReference = new AmazonS3Reference(buildClient(clientSettings));
        if (clientSettings.pathStyleAccess) {
    static void setDefaultAwsProfilePath() {
            );
 * software distributed under the License is distributed on an
     * Attempts to retrieve a client by its repository metadata and settings from the cache.
import java.io.Closeable;
            if (SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_RELATIVE_URI.getStringValue().isPresent()
    }
        builder.overrideConfiguration(buildOverrideConfiguration(clientSettings, clientExecutorService));
import software.amazon.awssdk.services.s3.LegacyMd5Plugin;
                );
        }
        this.clientExecutorService = clientExecutorService;
            Closeable {
                    ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property(),
        }
        RetryPolicy.Builder retryPolicy = AccessController.doPrivileged(
                clientBuilder.proxyConfiguration(buildHttpProxyConfiguration(clientSettings));
import java.security.SecureRandom;
import org.opensearch.cluster.metadata.RepositoryMetadata;
import software.amazon.awssdk.core.retry.RetryMode;
            .put("default", S3ClientSettings.getClientSettings(Settings.EMPTY, "default", configPath))
        if (!clientSettings.proxySettings.equals(ProxySettings.NO_PROXY_SETTINGS)) {
import software.amazon.awssdk.http.apache.internal.conn.SdkTlsSocketFactory;
import java.net.Proxy;
                + Strings.collectionToDelimitedString(staticClientSettings.keySet(), ",")
        } catch (URISyntaxException e) {
            clientReference.incRef();
}
        );
    }
            if (existing != null) {
        final IrsaCredentials irsaCredentials = buildFromEnviroment(clientSettings.irsaCredentials);
        ProxyConfiguration.Builder proxyConfiguration = ProxyConfiguration.builder();
                AccessController.doPrivileged(() -> {
    @Nullable
        @Override
                final StsWebIdentityTokenFileCredentialsProvider stsCredentialsProvider = AccessController.doPrivileged(
import software.amazon.awssdk.core.SdkSystemSetting;
     */
            "Unknown s3 client name ["
    S3Service(final Path configPath, @Nullable ScheduledExecutorService clientExecutorService) {
        if (Strings.hasText(clientSettings.region)) {
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
    S3Service(final Path configPath) {
class S3Service implements Closeable {
        return clientExecutorService;
                    StsWebIdentityTokenFileCredentialsProvider.builder()
 * GitHub history for details.
        implements
        // If "endpoint" is absent, DO NOT override; allow the AWS SDK to resolve endpoints dynamically.
import org.opensearch.common.settings.Settings;
                )
            .responseChecksumValidation(ResponseChecksumValidation.WHEN_REQUIRED);
    S3ClientSettings settings(RepositoryMetadata repositoryMetadata) {
        }
    }
                    builder = builder.endpointOverride(URI.create(stsEndpoint));
            }
        if (clientSettings.legacyMd5ChecksumCalculation) {
            }
                    .refreshRequest(
     */
            } catch (Exception e) {
import java.util.concurrent.ScheduledExecutorService;
            } else {
        String webIdentityTokenFile = defaults.getIdentityTokenFile();
                );
        }
            clientReference.decRef();
 * SPDX-License-Identifier: Apache-2.0
        }
                            protected PasswordAuthentication getPasswordAuthentication() {
            final SSLContext sslCtx = SSLContext.getInstance("TLS");
            if (existing != null && existing.tryIncRef()) {
        }
 * ownership. Elasticsearch licenses this file to you under
        private final P credentials;
            return AccessController.doPrivileged(credentials::resolveCredentials);
                        .webIdentityTokenFile(Path.of(irsaCredentials.getIdentityTokenFile()));
            sslCtx.init(SystemPropertyTlsKeyManagersProvider.create().keyManagers(), null, new SecureRandom());
        if (defaults == null) {
                    stsCredentialsProviderBuilder::build
    /**
        this.staticClientSettings = MapBuilder.newMapBuilder(clientsSettings).immutableMap();
    }
                    builder = builder.credentialsProvider(StaticCredentialsProvider.create(basicCredentials));
    static AwsCredentialsProvider buildCredentials(Logger logger, S3ClientSettings clientSettings) {
        String roleArn = defaults.getRoleArn();
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
            return Optional.empty();
                    if (stsClient != null) {
import java.util.Optional;
        final AwsCredentialsProvider credentials = buildCredentials(logger, clientSettings);
    @SuppressForbidden(reason = "Need to provide this override to v2 SDK so that path does not default to home path")
 * Licensed to Elasticsearch under one or more contributor
    private static SSLConnectionSocketFactory createSocksSslConnectionSocketFactory(final InetSocketAddress address) {
import java.security.KeyManagementException;
        return clientBuilder;
                return builder.build();
        }
    }
    }
            }
 * The OpenSearch Contributors require contributions made to
import java.net.URISyntaxException;
        clientBuilder.connectionAcquisitionTimeout(Duration.ofMillis(clientSettings.connectionAcquisitionTimeoutMillis));
     * Client settings calculated from static configuration and settings in the keystore.
        }
import org.opensearch.repositories.s3.S3ClientSettings.IrsaCredentials;
                    null,
                throw new IOException(e);
import software.amazon.awssdk.services.s3.S3Client;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.Nullable;
        }
import org.opensearch.repositories.s3.utils.AwsRequestSigner;
                    stsCredentialsProviderBuilder::build
                            .roleArn(irsaCredentials.getRoleArn())
                } else {
    }
     * existing clients. New clients will be build using these new settings. Old
            return new SdkTlsSocketFactory(sslCtx, new DefaultHostnameVerifier()) {
        // shutdown all unused clients
 * this work for additional information regarding copyright
                }
                    }
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
        // This is required for ARN buckets (access points / outposts / MRAP), and is also correct for normal buckets.
            });
        if ((endpoint.startsWith("http://") || endpoint.startsWith("https://")) == false) {
        if (webIdentityTokenFile == null) {
        builder.requestChecksumCalculation(RequestChecksumCalculation.WHEN_REQUIRED)
            roleSessionName = System.getenv(SdkSystemSetting.AWS_ROLE_SESSION_NAME.environmentVariable());
    private volatile Map<S3ClientSettings, AmazonS3Reference> clientsCache = new ConcurrentHashMap<>();
            // TODO: Remove this once fixed in the AWS SDK
        final S3ClientSettings staticSettings = staticClientSettings.get(clientName);
    /**
                        .stsClient(stsClient)
            logger.debug("Using basic key/secret credentials");
            return clientReference;
                final String stsEndpoint = System.getProperty(STS_ENDPOINT_OVERRIDE_SYSTEM_PROPERTY);
import software.amazon.awssdk.http.apache.ProxyConfiguration;
 *    http://www.apache.org/licenses/LICENSE-2.0
        // the clients will shutdown when they will not be used anymore
            throw SdkException.create("Invalid proxy URL", e);
                        .roleSessionName(irsaCredentials.getRoleSessionName())
     * Client settings derived from those in {@link #staticClientSettings} by combining them with settings
                if (stsEndpoint != null) {
                if (basicCredentials != null) {
        {
import java.nio.file.Path;
                    System.getProperty("opensearch.path.conf")
