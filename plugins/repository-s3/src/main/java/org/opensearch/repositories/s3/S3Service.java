                return existing;  
            proxyConfiguration = proxyConfiguration.endpoint(  
            AccessController.doPrivileged(  
                    return new Socket(new Proxy(Proxy.Type.SOCKS, address));
        builder.credentialsProvider(credentials);
import software.amazon.awssdk.http.apache.ApacheHttpClient;
        // shutdown all unused clients  
        final IrsaCredentials irsaCredentials = buildFromEnviroment(clientSettings.irsaCredentials);
        if (defaults == null) {  
                });  
                () -> System.setProperty(ProfileFileSystemSetting.AWS_CONFIG_FILE.property(), System.getProperty("opensearch.path.conf"))
        {
     */
                    );
                } else {
            }
        builder.overrideConfiguration(buildOverrideConfiguration(clientSettings, clientExecutorService));
            AwsCredentialsProvider,
                final String stsEndpoint = System.getProperty(STS_ENDPOINT_OVERRIDE_SYSTEM_PROPERTY);
                    }
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
            AccessController.doPrivileged(
import software.amazon.awssdk.core.client.config.SdkAdvancedClientOption;
                final StsWebIdentityTokenFileCredentialsProvider stsCredentialsProvider = AccessController.doPrivileged(
            return new SdkTlsSocketFactory(sslCtx, new DefaultHostnameVerifier()) {
    }
        }
                        .webIdentityTokenFile(Path.of(irsaCredentials.getIdentityTokenFile()));  
        } catch (URISyntaxException e) {
 * this work for additional information regarding copyright
            .responseChecksumValidation(ResponseChecksumValidation.WHEN_REQUIRED);
import java.util.Map;  
                new URI(
        // Use URI.create for simplicity; if your codebase prefers checked handling, swap to new URI(endpoint).
    // Aws v2 sdk tries to load a default profile from home path which is restricted. Hence, setting these to random
                return clientReference;  
        if (roleSessionName == null) {  
            logger.debug("Using instance profile credentials");  
        return proxyConfiguration.build();  
import java.nio.file.Path;
        proxyConfiguration = proxyConfiguration.password(clientSettings.proxySettings.getPassword());
    @Override
            return AccessController.doPrivileged(credentials::resolveCredentials);
 *
                    }  
        String roleArn = defaults.getRoleArn();  
            () -> RetryPolicy.builder().numRetries(clientSettings.maxRetries).retryCapacityCondition(null)  
    // pkg private for tests
        final S3ClientSettings clientSettings = settings(repositoryMetadata);
                final StsAssumeRoleCredentialsProvider stsCredentialsProvider = AccessController.doPrivileged(
        }
                )  
import software.amazon.awssdk.services.sts.StsClient;
                public Socket createSocket(final HttpContext ctx) throws IOException {
import java.util.concurrent.ConcurrentHashMap;
        // clients are built lazily by {@link client}  
        }  
        try {
        if (clientSettings.disableChunkedEncoding) {
        }  
        }
    /**
        );
            return Optional.empty();  
        }
        return Optional.of(URI.create(endpoint));
        }
        if (irsaCredentials != null) {
     * existing clients. New clients will be build using these new settings. Old
    private final @Nullable ScheduledExecutorService clientExecutorService;
        // If "endpoint" is absent, DO NOT override; allow the AWS SDK to resolve endpoints dynamically.
import software.amazon.awssdk.regions.Region;  
                return existing;
        // Only apply endpointOverride when the user explicitly configures "endpoint".  
        clientBuilder.socketTimeout(Duration.ofMillis(clientSettings.readTimeoutMillis));  
import java.util.Optional;
                if (Strings.hasText(clientSettings.region)) {  
    private static final Logger logger = LogManager.getLogger(S3Service.class);
 *  
    }
            clientOverrideConfiguration.apiCallTimeout(Duration.ofMillis(clientSettings.apiCallTimeoutMillis));
 * software distributed under the License is distributed on an
                SdkAdvancedClientOption.SIGNER,
            // TODO: Remove this once fixed in the AWS SDK  
     * Optional scheduled executor service to use for the client
            throw SdkException.create("Exception during SSL context creation for SOCKS proxy", e);  
    S3Service(final Path configPath) {
     */
                    clientSettings.proxySettings.getHost(),
        final S3ClientSettings clientSettings,
import software.amazon.awssdk.core.exception.SdkException;  
import java.net.Authenticator;  
            .immutableMap();  
    public synchronized void refreshAndClearCache(Map<String, S3ClientSettings> clientsSettings) {
                    stsCredentialsProviderBuilder::build  
            synchronized (this) {
                + "]. Existing client configs: "  
        if (ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.getStringValue().isEmpty()) {  
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
        }
        private final StsClient stsClient;
            throw SdkException.create("Invalid proxy URL", e);  
                    builder = builder.endpointOverride(URI.create(stsEndpoint));  
    // valid paths.  
                return new PrivilegedSTSAssumeRoleSessionCredentialsProvider<>(stsClient, stsCredentialsProvider);
            if (clientSettings.proxySettings.getType() == ProxySettings.ProxyType.SOCKS) {
                    if (stsClient != null) {
                        });  
                }  
                    ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property(),  
                    builder = builder.credentialsProvider(DefaultCredentialsProvider.create());  
import software.amazon.awssdk.services.s3.LegacyMd5Plugin;
     * Refreshes the settings for the AmazonS3 clients and clears the cache of  
import java.security.KeyManagementException;
            retryPolicy.throttlingBackoffStrategy(BackoffStrategy.none());  
        }
    private static SSLConnectionSocketFactory createSocksSslConnectionSocketFactory(final InetSocketAddress address) {  
            retryPolicy.throttlingBackoffStrategy(BackoffStrategy.defaultThrottlingStrategy(RetryMode.STANDARD));
        }
        }
                                );
            }
        @Nullable ScheduledExecutorService clientExecutorService
            } catch (Exception e) {
        if (clientSettings.pathStyleAccess) {
import software.amazon.awssdk.core.retry.backoff.BackoffStrategy;  
     */  
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
            }  
    static ClientOverrideConfiguration buildOverrideConfiguration(  
        // This is required for ARN buckets (access points / outposts / MRAP), and is also correct for normal buckets.
    ScheduledExecutorService getClientExecutorService() {
        public AwsCredentials resolveCredentials() {  
import software.amazon.awssdk.core.checksums.RequestChecksumCalculation;
        throw new IllegalArgumentException(  
     * of being returned to the cache.  
        try {
                return ContainerCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
        }
        }
            this.stsClient = stsClient;
        Protocol proxyProtocol = clientSettings.proxySettings.getType() == ProxySettings.ProxyType.DIRECT
        releaseCachedClients();  
     * in the {@link RepositoryMetadata}.  
        }  
    private static final String STS_ENDPOINT_OVERRIDE_SYSTEM_PROPERTY = "aws.stsEndpointOverride";
                }  
 * the Apache License, Version 2.0 (the "License"); you may
import software.amazon.awssdk.auth.credentials.ContainerCredentialsProvider;  
                        .stsClient(stsClient)  
        }
                            .roleSessionName(irsaCredentials.getRoleSessionName())  
 * Unless required by applicable law or agreed to in writing,
        if (roleArn == null) {
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
        @Override
     * Client settings calculated from static configuration and settings in the keystore.  
        final AwsCredentials basicCredentials = clientSettings.credentials;  
        implements  
        clientBuilder.maxConnections(clientSettings.maxSyncConnections);
 */  
        }
import org.opensearch.common.Nullable;
        ProxyConfiguration.Builder proxyConfiguration = ProxyConfiguration.builder();
import org.opensearch.secure_sm.AccessController;  
        }  
import org.opensearch.repositories.s3.utils.AwsRequestSigner;
                throw new IOException(e);  
            "Unknown s3 client name ["
    static void setDefaultAwsProfilePath() {
import software.amazon.awssdk.services.sts.auth.StsWebIdentityTokenFileCredentialsProvider;
     * Client settings derived from those in {@link #staticClientSettings} by combining them with settings
    }
      *
    @Nullable  
        }
                        AssumeRoleRequest.builder()
                AwsRequestSigner.fromSignerName(clientSettings.signerOverride).getSigner()
    /**
            }
        if (!clientSettings.proxySettings.equals(ProxySettings.NO_PROXY_SETTINGS)) {  
import java.security.SecureRandom;
            this.credentials = credentials;
        } else {
    private volatile Map<S3ClientSettings, AmazonS3Reference> clientsCache = new ConcurrentHashMap<>();  
        private AwsCredentialsProvider initializeProvider() {
                final S3ClientSettings existing = derivedClientSettings.get(settings);  
/*  
                                    clientSettings.proxySettings.getPassword().toCharArray()  
     * Attempts to retrieve a client by its repository metadata and settings from the cache.
        if (clientExecutorService != null) {
import java.net.InetSocketAddress;
        clientsCache = emptyMap();
        final Settings settings = repositoryMetadata.settings();
import org.opensearch.core.common.Strings;
 * under the License.  
                () -> System.setProperty(
        private final AwsCredentialsProvider credentials;
    private static IrsaCredentials buildFromEnviroment(IrsaCredentials defaults) {
    }
            return StaticCredentialsProvider.create(basicCredentials);
                        .roleSessionName(irsaCredentials.getRoleSessionName())
        clientOverrideConfiguration.retryPolicy(retryPolicy.build())
    static AwsCredentialsProvider buildCredentials(Logger logger, S3ClientSettings clientSettings) {
                final S3ClientSettings newSettings = staticSettings.refine(settings);
import java.net.Socket;
                AccessController.doPrivilegedChecked(() -> {
            if (clientReference != null && clientReference.tryIncRef()) {
     * @return S3ClientSettings
                StsClientBuilder builder = StsClient.builder();
        private PrivilegedSTSAssumeRoleSessionCredentialsProvider(@Nullable final StsClient stsClient, final P credentials) {  
            return null;
                    null,  
    }  
    public synchronized void releaseCachedClients() {
                    StsWebIdentityTokenFileCredentialsProvider.builder()
 */
                    .stsClient(stsClient)
        return new IrsaCredentials(webIdentityTokenFile, roleArn, roleSessionName);
    static class PrivilegedInstanceProfileCredentialsProvider implements AwsCredentialsProvider {  
import org.apache.http.protocol.HttpContext;  
        public AwsCredentials resolveCredentials() {
import org.opensearch.common.collect.MapBuilder;  
                }
    // proxy for testing
            if (irsaCredentials.getIdentityTokenFile() == null) {  
            final SSLContext sslCtx = SSLContext.getInstance("TLS");  
        return clientExecutorService;
package org.opensearch.repositories.s3;
        derivedClientSettings = emptyMap();  
    static ProxyConfiguration buildHttpProxyConfiguration(S3ClientSettings clientSettings) {
    private volatile Map<Settings, S3ClientSettings> derivedClientSettings = new ConcurrentHashMap<>();
     */
                }
            }
        clientBuilder.connectionAcquisitionTimeout(Duration.ofMillis(clientSettings.connectionAcquisitionTimeoutMillis));
                    clientSettings.proxySettings.getPort(),
                }
        // If IAM Roles for Service Accounts (IRSA) credentials are configured, start with them first  
        }
import software.amazon.awssdk.services.sts.StsClientBuilder;
import java.util.concurrent.ScheduledExecutorService;  
        if (clientSettings.proxySettings.getType() == ProxySettings.ProxyType.SOCKS) {  
        {  
      * Package-private to allow unit testing.
    private volatile Map<String, S3ClientSettings> staticClientSettings;
import software.amazon.awssdk.http.apache.internal.conn.SdkTlsSocketFactory;
import org.apache.logging.log4j.Logger;
                return newSettings;  
import java.io.Closeable;
                    if (clientSettings.proxySettings.isAuthenticated()) {  
                return builder.build();  
    static ApacheHttpClient.Builder buildHttpClient(S3ClientSettings clientSettings) {  
            if (existing != null) {
            return clientReference;
            if (existing != null && existing.tryIncRef()) {
                                    clientSettings.proxySettings.getUsername(),
    }  
        resolveEndpointOverride(clientSettings).ifPresent(builder::endpointOverride);  
            final AmazonS3Reference existing = clientsCache.get(clientSettings);
        final S3ClientBuilder builder = S3Client.builder();
import software.amazon.awssdk.core.SdkSystemSetting;
    /**
        builder.httpClientBuilder(buildHttpClient(clientSettings));  
            }  
            final S3ClientSettings existing = derivedClientSettings.get(settings);  
        setDefaultAwsProfilePath();
      * Otherwise returns Optional.empty().  
 * ownership. Elasticsearch licenses this file to you under  
     */  
                final StsWebIdentityTokenFileCredentialsProvider.Builder stsCredentialsProviderBuilder =
        } else if (basicCredentials != null) {
                @Override  
        builder.requestChecksumCalculation(RequestChecksumCalculation.WHEN_REQUIRED)
        if (clientSettings.apiCallTimeoutMillis > 0) {  
        String roleSessionName = defaults.getRoleSessionName();
 * license agreements. See the NOTICE file distributed with
        }
            return proxyConfiguration.build();
class S3Service implements Closeable {
            );
            builder.region(Region.of(clientSettings.region));
            clientReference.incRef();  
                    null,  
            logger.debug("Using IRSA credentials");
import org.opensearch.cluster.metadata.RepositoryMetadata;  
        } else {
     * @param repositoryMetadata Repository Metadata  
                )
    }
                    null,
        this.clientExecutorService = clientExecutorService;
    }  
    }
                    credentials.close();  
        synchronized (this) {  
        private PrivilegedInstanceProfileCredentialsProvider() {  
     * If the client does not exist it will be created.
import software.amazon.awssdk.services.s3.S3ClientBuilder;  
            );
import org.opensearch.common.settings.Settings;
            clientOverrideConfiguration = clientOverrideConfiguration.scheduledExecutorService(clientExecutorService);  
        }
 * Modifications Copyright OpenSearch Contributors. See
                            .build()
                derivedClientSettings = MapBuilder.newMapBuilder(derivedClientSettings).put(settings, newSettings).immutableMap();
import org.apache.logging.log4j.LogManager;
                            .roleArn(irsaCredentials.getRoleArn())
    }
import org.opensearch.common.SuppressForbidden;
            // Manually add the schema to the endpoint to work around https://github.com/aws/aws-sdk-java/issues/2274
        ClientOverrideConfiguration.Builder clientOverrideConfiguration = ClientOverrideConfiguration.builder();
                    clientBuilder.socketFactory(createSocksSslConnectionSocketFactory(clientSettings.proxySettings.getAddress()));
    S3Service(final Path configPath, @Nullable ScheduledExecutorService clientExecutorService) {  
        for (final AmazonS3Reference clientReference : clientsCache.values()) {  
        ApacheHttpClient.Builder clientBuilder = ApacheHttpClient.builder();
        // clear previously cached clients, they will be build lazily
    @SuppressForbidden(reason = "Need to provide this override to v2 SDK so that path does not default to home path")
            final AmazonS3Reference clientReference = new AmazonS3Reference(buildClient(clientSettings));
                        stsClient.close();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        derivedClientSettings = emptyMap();
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
 */  
                AccessController.doPrivileged(() -> {
            roleSessionName = System.getenv(SdkSystemSetting.AWS_ROLE_SESSION_NAME.environmentVariable());
    static class PrivilegedSTSAssumeRoleSessionCredentialsProvider<P extends AwsCredentialsProvider & AutoCloseable>
        if (Strings.hasText(clientSettings.region)) {
import java.time.Duration;
    }
import software.amazon.awssdk.http.SystemPropertyTlsKeyManagersProvider;
      * Returns an endpoint override ONLY when the user explicitly provided one.
        if (Strings.hasLength(clientSettings.signerOverride)) {
        // This part was taken from AWS settings
    public void close() {
        }  
     */
            webIdentityTokenFile = System.getenv(SdkSystemSetting.AWS_WEB_IDENTITY_TOKEN_FILE.environmentVariable());  
            .put("default", S3ClientSettings.getClientSettings(Settings.EMPTY, "default", configPath))
        return AmazonS3WithCredentials.create(client, credentials);
    }  
import software.amazon.awssdk.services.sts.auth.StsAssumeRoleCredentialsProvider;  
                            protected PasswordAuthentication getPasswordAuthentication() {  
        if (webIdentityTokenFile == null) {
        releaseCachedClients();
import software.amazon.awssdk.core.checksums.ResponseChecksumValidation;  
    }
import java.net.Proxy;  
                            @Override
    Optional<URI> resolveEndpointOverride(final S3ClientSettings clientSettings) {
     * by overriding static client settings from {@link #staticClientSettings} with settings found in the repository metadata.
    }
                clientBuilder.proxyConfiguration(buildHttpProxyConfiguration(clientSettings));
        staticClientSettings = MapBuilder.<String, S3ClientSettings>newMapBuilder()
        return clientBuilder;
            try {
      */  
        final S3Client client = AccessController.doPrivileged(builder::build);  
        assert this.staticClientSettings.containsKey("default") : "always at least have 'default'";
        // others will shutdown on their respective release
            // InstanceProfileCredentialsProvider as last item of chain
        // the clients will shutdown when they will not be used anymore
        }
            ? Protocol.HTTP
                    .refreshRequest(  
import java.net.PasswordAuthentication;
import org.opensearch.repositories.s3.utils.Protocol;
        this.staticClientSettings = MapBuilder.newMapBuilder(clientsSettings).immutableMap();  
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        this(configPath, null);
     * Either fetches {@link S3ClientSettings} for a given {@link RepositoryMetadata} from cached settings or creates them
            clientOverrideConfiguration = clientOverrideConfiguration.putAdvancedOption(  
                    builder.region(Region.of(clientSettings.region));
 * specific language governing permissions and limitations
import java.io.IOException;
            } else {
        if (ProfileFileSystemSetting.AWS_CONFIG_FILE.getStringValue().isEmpty()) {
                || SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_FULL_URI.getStringValue().isPresent()) {  
        final String clientName = S3Repository.CLIENT_NAME.get(settings);
}
                );
            Closeable {
    public AmazonS3Reference client(RepositoryMetadata repositoryMetadata) {
            );  
import software.amazon.awssdk.core.retry.RetryMode;
                + Strings.collectionToDelimitedString(staticClientSettings.keySet(), ",")
        }
        if (!clientSettings.throttleRetries) {
    AmazonS3WithCredentials buildClient(final S3ClientSettings clientSettings) {  
    /**
 * this file be licensed under the Apache-2.0 license or a
        String endpoint = clientSettings.endpoint;  
            builder.forcePathStyle(true);
        String webIdentityTokenFile = defaults.getIdentityTokenFile();
import java.net.URI;
        }  
 * not use this file except in compliance with the License.
                    stsCredentialsProviderBuilder::build
        RetryPolicy.Builder retryPolicy = AccessController.doPrivileged(
        }  
            builder.addPlugin(LegacyMd5Plugin.create());
        }
     * clients are usable until released. On release they will be destroyed instead
/*
/*  
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;  
                final StsAssumeRoleCredentialsProvider.Builder stsCredentialsProviderBuilder = StsAssumeRoleCredentialsProvider.builder()
            : clientSettings.proxySettings.getType().toProtocol();  
    }  
            builder.serviceConfiguration(s -> s.chunkedEncodingEnabled(false));
                );  
                    builder = builder.credentialsProvider(StaticCredentialsProvider.create(basicCredentials));
                return new PrivilegedSTSAssumeRoleSessionCredentialsProvider<>(stsClient, stsCredentialsProvider);  
    S3ClientSettings settings(RepositoryMetadata repositoryMetadata) {  
        public void close() throws IOException {  
                if (existing != null) {
            endpoint = clientSettings.protocol.toString() + "://" + endpoint;
import org.opensearch.repositories.s3.S3ClientSettings.IrsaCredentials;  
            clientsCache = MapBuilder.newMapBuilder(clientsCache).put(clientSettings, clientReference).immutableMap();
        final S3ClientSettings staticSettings = staticClientSettings.get(clientName);  
            };
import software.amazon.awssdk.http.apache.ProxyConfiguration;  
        if (clientSettings.legacyMd5ChecksumCalculation) {  
        final AwsCredentialsProvider credentials = buildCredentials(logger, clientSettings);
            return AccessController.doPrivileged(credentials::resolveCredentials);  
            }
        if ((endpoint.startsWith("http://") || endpoint.startsWith("https://")) == false) {
                    null
    /**
        }
            }  
 * Licensed to Elasticsearch under one or more contributor  
        proxyConfiguration = proxyConfiguration.username(clientSettings.proxySettings.getUsername());  
            final AmazonS3Reference clientReference = clientsCache.get(clientSettings);
 * GitHub history for details.
            roleArn = System.getenv(SdkSystemSetting.AWS_ROLE_ARN.environmentVariable());
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
                    return existing;
                        .roleArn(irsaCredentials.getRoleArn())
            clientReference.decRef();
            if (SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_RELATIVE_URI.getStringValue().isPresent()
    }  
    }
                + clientName
            this.credentials = initializeProvider();
                if (basicCredentials != null) {  
                });
            return InstanceProfileCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
    /**  
 * compatible open source license.
                    proxyProtocol.toString(),
        );
            return new PrivilegedInstanceProfileCredentialsProvider();
            } else {  
            );  
    }
import software.amazon.awssdk.profiles.ProfileFileSystemSetting;
import javax.net.ssl.SSLContext;
                        Authenticator.setDefault(new Authenticator() {
        }  
            StsClient stsClient = AccessController.doPrivileged(() -> {
        }
            });
import software.amazon.awssdk.core.retry.RetryPolicy;
import java.net.URISyntaxException;  
 *
import static java.util.Collections.emptyMap;
 *    http://www.apache.org/licenses/LICENSE-2.0
            sslCtx.init(SystemPropertyTlsKeyManagersProvider.create().keyManagers(), null, new SecureRandom());
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
 * You may obtain a copy of the License at  
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            logger.debug("Using basic key/secret credentials");  
        }
                if (stsEndpoint != null) {
        return clientOverrideConfiguration.build();  
                            }
import java.security.NoSuchAlgorithmException;  
                                return new PasswordAuthentication(
    /**  
    }
        if (Strings.hasLength(clientSettings.endpoint) == false) {
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        @Override
            .apiCallAttemptTimeout(Duration.ofMillis(clientSettings.requestTimeoutMillis));
                    System.getProperty("opensearch.path.conf")
        private final P credentials;  
import software.amazon.awssdk.services.s3.S3Client;
        }  
    ) {  
        @Override
        if (staticSettings != null) {
