        }
import org.opensearch.common.settings.Setting;
        derivedClientSettings = emptyMap();
                return ProxyConfiguration.builder()
            awsCredentialsProvider,
        );
        return credentialProviderFactory.createAwsCredentialsProvider(() -> credentials);
            clientSettings.readTimeoutMillis
            }
        // Verify client creation is successful to early detect any failure.
            }
                    .username(clientSettings.proxyUsername)
        long readTimeoutMillis
        String endpoint,
            overrideConfiguration,
        // the clients will shutdown when they will not be used anymore
        }
            builder.region(Region.of(region));
        {
    /**
 * this file be licensed under the Apache-2.0 license or a
        {
        String region,
    private final CredentialProviderFactory credentialProviderFactory;
import static java.util.Collections.emptyMap;
        // Increase the number of retries in case of 5xx API responses.
        final AwsCredentialsProvider awsCredentialsProvider = buildCredentials(clientSettings);
        final Settings settings = cryptoMetadata.settings();
    private volatile Map<KmsClientSettings, AmazonKmsClientReference> clientsCache = emptyMap();
        return retryPolicy.build();
import org.opensearch.common.SuppressForbidden;
                encCtx = Arrays.stream(kmsEncCtx.split(","))
    /**
     */
                throw new IllegalArgumentException(ENC_CTX_SETTING.getKey() + " Format should be: Name1=Value1, Name2=Value2");
                return existing;
        }
    ProxyConfiguration buildProxyConfiguration(KmsClientSettings clientSettings) {
        if (Strings.hasText(clientSettings.proxyHost)) {
        return buildClient(
 */
        String keyArn = KEY_ARN_SETTING.get(cryptoSettings);
    }
            proxyConfiguration,
        try (AmazonKmsClientReference clientReference = client(cryptoMetadata)) {
 */
                return existing;
        clientsCache = emptyMap();
        final ClientOverrideConfiguration overrideConfiguration = buildOverrideConfiguration();
        // APIs that have been failing continuously. It allocates tokens (default is 500), which means that once 500
            return newSettings;
        credentialProviderFactory = new CredentialProviderFactory();
import software.amazon.awssdk.http.apache.ApacheHttpClient;
        } else {
                return clientReference;
            final AmazonKmsClientReference clientReference = new AmazonKmsClientReference(
    }
        return new KmsMasterKeyProvider(encCtx, keyArn, () -> client(cryptoMetadata));
        }
        synchronized (this) {
        if (Strings.hasText(endpoint)) {
public class KmsService implements Closeable {
            final AmazonKmsClientReference existing = clientsCache.get(clientSettings);
        }
            } catch (URISyntaxException e) {
     */
     * will be destroyed instead of being returned to the cache.
            .httpClientBuilder(clientBuilder)
        AccessController.doPrivileged(KmsService::setDefaultAwsProfilePath);
    }
    /**
        ApacheHttpClient.Builder clientBuilder = ApacheHttpClient.builder()
        }
    public void refreshAndClearCache(KmsClientSettings clientSettings) {
import java.net.URISyntaxException;
            final AmazonKmsClientReference clientReference = clientsCache.get(clientSettings);
     * by overriding static client settings from {@link #staticClientSettings} with settings found in the crypto metadata.
     * Refreshes the settings for the AmazonKMS client. The new client will be build
        String kmsEncCtx = ENC_CTX_SETTING.get(cryptoSettings);
import software.amazon.awssdk.regions.Region;
        }
import software.amazon.awssdk.auth.credentials.AwsCredentials;
     * Either fetches {@link KmsClientSettings} for a given {@link CryptoMetadata} from cached settings or creates them
        // https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/core/retry/conditions/TokenBucketRetryCondition.html
 *
        ClientOverrideConfiguration overrideConfiguration,
import org.opensearch.cluster.metadata.CryptoMetadata;
            System.setProperty(ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property(), System.getProperty("opensearch.path.conf"));
    @SuppressForbidden(reason = "Prevent AWS SDK v2 from using ~/.aws/config and ~/.aws/credentials.")
import software.amazon.awssdk.core.exception.SdkException;
                    .collect(Collectors.toMap(e -> e[0].trim(), e -> e[1].trim()));
            clientReference.get();
     * Client settings calculated from static configuration and settings in the keystore.
/**
            }
        } else {
    }
        // clear previously cached clients, they will be build lazily
import java.util.stream.Collectors;
        }
        return ClientOverrideConfiguration.builder().retryPolicy(buildRetryPolicy()).build();
    protected KmsClient buildClient(
        AwsCredentialsProvider awsCredentialsProvider,
    @Override
    ClientOverrideConfiguration buildOverrideConfiguration() {
        RetryPolicy.Builder retryPolicy = RetryPolicy.builder().numRetries(10);
    AwsCredentialsProvider buildCredentials(KmsClientSettings clientSettings) {
    private KmsClient buildClient(KmsClientSettings clientSettings) {
        final AwsCredentials credentials = clientSettings.credentials;
        // others will shutdown on their respective release
        }
import software.amazon.awssdk.core.retry.RetryPolicy;
                    .build();
            .proxyConfiguration(proxyConfiguration)
    static final Setting<String> ENC_CTX_SETTING = Setting.simpleString("kms.encryption_context", Setting.Property.NodeScope);
            if (existing != null) {
            if (clientReference != null && clientReference.tryIncRef()) {
        }
    /**
        }
        return AccessController.doPrivileged(builder::build);
            try {
import software.amazon.awssdk.http.apache.ProxyConfiguration;
    }
        if (ProfileFileSystemSetting.AWS_CONFIG_FILE.getStringValue().isEmpty()) {
            builder.endpointOverride(URI.create(endpoint));
            try {
                return existing;
import org.apache.logging.log4j.Logger;
    static final Setting<String> KEY_ARN_SETTING = Setting.simpleString("kms.key_arn", Setting.Property.NodeScope);
 * SPDX-License-Identifier: Apache-2.0
                AccessController.doPrivileged(() -> buildClient(clientSettings))
import java.util.HashMap;
        KmsClientBuilder builder = KmsClient.builder()
    }
    }
        if (Strings.hasText(region)) {
            logger.info("setting aws.sharedCredentialsFile={}", System.getProperty("opensearch.path.conf"));
    }
        if (Strings.hasText(kmsEncCtx)) {
    }
            .credentialsProvider(awsCredentialsProvider);
        }
            if (existing != null) {
            .overrideConfiguration(overrideConfiguration)
        this.staticClientSettings = clientSettings;
    public MasterKeyProvider createMasterKeyProvider(CryptoMetadata cryptoMetadata) {
import software.amazon.awssdk.services.kms.KmsClient;
import org.opensearch.secure_sm.AccessController;
    private synchronized void releaseCachedClients() {
            return clientReference;
package org.opensearch.crypto.kms;
            final KmsClientSettings newSettings = staticClientSettings.getMetadataSettings(settings);
            clientsCache = MapBuilder.newMapBuilder(clientsCache).put(clientSettings, clientReference).immutableMap();
    // pkg private for tests
            encCtx = new HashMap<>();
    }
            logger.info("setting aws.sharedCredentialsFile={}", System.getProperty("opensearch.path.conf"));
import software.amazon.awssdk.services.kms.KmsClientBuilder;
            if (existing != null && existing.tryIncRef()) {
            derivedClientSettings = MapBuilder.newMapBuilder(derivedClientSettings).put(settings, newSettings).immutableMap();
     * @param cryptoMetadata Crypto Metadata
import java.util.Map;
                    .endpoint(new URI("https", null, clientSettings.proxyHost, clientSettings.proxyPort, null, null, null))
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
            } catch (Exception ex) {
            throw new IllegalArgumentException("Missing key_arn setting");
        Settings cryptoSettings = Settings.builder().put(cryptoMetadata.settings()).normalizePrefix("kms.").build();
            return ProxyConfiguration.builder().build();
    }
import software.amazon.awssdk.profiles.ProfileFileSystemSetting;
            logger.debug("using explicit kms endpoint [{}]", endpoint);
        if (ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.getStringValue().isEmpty()) {
            logger.debug("using explicit kms region [{}]", region);
            .socketTimeout(Duration.ofMillis(readTimeoutMillis));
import java.time.Duration;
     * using these new settings. The old client is usable until released. On release it
}
import java.net.URI;
        }
            );
                throw SdkException.create("Invalid proxy URL", e);
        Map<String, String> encCtx;
    public AmazonKmsClientReference client(CryptoMetadata cryptoMetadata) {
        releaseCachedClients();
            clientSettings.region,
    static void setDefaultAwsProfilePath() {
    }
        synchronized (this) {
    private static final Logger logger = LogManager.getLogger(KmsService.class);
        final KmsClientSettings clientSettings = settings(cryptoMetadata);
import org.opensearch.common.settings.Settings;
            }
    // proxy for testing
 * The OpenSearch Contributors require contributions made to
     */
        // Note that AWS SDK v2 introduced a concept of TokenBucketRetryCondition, which effectively limits retries for
            }
    public void close() {
            final KmsClientSettings existing = derivedClientSettings.get(settings);
            final KmsClientSettings existing = derivedClientSettings.get(settings);
                    .map(s -> s.split("="))
        // retries fail for any API on a bucket, new retries will only be allowed once some retries are rejected.
        if (!Strings.hasText(keyArn)) {
    public KmsService() {
import org.apache.logging.log4j.LogManager;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
            }
 * compatible open source license.
    // By default, AWS v2 SDK loads a default profile from $USER_HOME, which is restricted. Use the OpenSearch configuration path instead.
    }
import java.io.Closeable;
            clientReference.incRef();
        final ProxyConfiguration proxyConfiguration = AccessController.doPrivileged(() -> buildProxyConfiguration(clientSettings));
     */
import org.opensearch.core.common.Strings;
                    .password(clientSettings.proxyPassword)
            clientReference.decRef();
            .region(Region.of(region))
        for (final AmazonKmsClientReference clientReference : clientsCache.values()) {
            System.setProperty(ProfileFileSystemSetting.AWS_CONFIG_FILE.property(), System.getProperty("opensearch.path.conf"));
     * Client settings derived from those in {@link #staticClientSettings} by combining them with crypto settings
import java.util.Arrays;
/*
 * Service class which exposes APIs for communication with AWS KMS.
    KmsClientSettings settings(CryptoMetadata cryptoMetadata) {
    RetryPolicy buildRetryPolicy() {
        ProxyConfiguration proxyConfiguration,
    }
            clientSettings.endpoint,
    private volatile KmsClientSettings staticClientSettings;
    private volatile Map<Settings, KmsClientSettings> derivedClientSettings;
import org.opensearch.common.crypto.MasterKeyProvider;
     * @return KmsClientSettings
import org.opensearch.common.collect.MapBuilder;
        // shutdown all unused clients
        derivedClientSettings = emptyMap();
        releaseCachedClients();
    ) {
