        // retries fail for any API on a bucket, new retries will only be allowed once some retries are rejected.  
            } catch (URISyntaxException e) {
            builder.endpointOverride(URI.create(endpoint));  
    RetryPolicy buildRetryPolicy() {
            return ProxyConfiguration.builder().build();
        // Verify client creation is successful to early detect any failure.
            }
            clientReference.get();  
            logger.info("setting aws.sharedCredentialsFile={}", System.getProperty("opensearch.path.conf"));
        if (Strings.hasText(kmsEncCtx)) {
        // others will shutdown on their respective release
            .region(Region.of(region))
        try (AmazonKmsClientReference clientReference = client(cryptoMetadata)) {
            throw new IllegalArgumentException("Missing key_arn setting");
    }
    @Override
        }
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;  
        if (Strings.hasText(clientSettings.proxyHost)) {  
        {
            encCtx = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
import software.amazon.awssdk.services.kms.KmsClientBuilder;
        return ClientOverrideConfiguration.builder().retryPolicy(buildRetryPolicy()).build();
}
    public void refreshAndClearCache(KmsClientSettings clientSettings) {  
            if (existing != null) {
     * Either fetches {@link KmsClientSettings} for a given {@link CryptoMetadata} from cached settings or creates them
     */
    }  
        AwsCredentialsProvider awsCredentialsProvider,
    private volatile KmsClientSettings staticClientSettings;
        return AccessController.doPrivileged(builder::build);
            clientSettings.region,
            return clientReference;
        final AwsCredentialsProvider awsCredentialsProvider = buildCredentials(clientSettings);
            return newSettings;  
        {
import java.time.Duration;  
        final ProxyConfiguration proxyConfiguration = AccessController.doPrivileged(() -> buildProxyConfiguration(clientSettings));
        // clear previously cached clients, they will be build lazily
        } else {
            try {
                return existing;
            } catch (Exception ex) {  
        // APIs that have been failing continuously. It allocates tokens (default is 500), which means that once 500
        final AwsCredentials credentials = clientSettings.credentials;
    ProxyConfiguration buildProxyConfiguration(KmsClientSettings clientSettings) {
            clientsCache = MapBuilder.newMapBuilder(clientsCache).put(clientSettings, clientReference).immutableMap();
            final KmsClientSettings existing = derivedClientSettings.get(settings);  
                return existing;
        String keyArn = KEY_ARN_SETTING.get(cryptoSettings);  
                return clientReference;
    }  
import org.opensearch.core.common.Strings;  
import software.amazon.awssdk.http.apache.ApacheHttpClient;  
import software.amazon.awssdk.core.exception.SdkException;
        final Settings settings = cryptoMetadata.settings();
            .socketTimeout(Duration.ofMillis(readTimeoutMillis));
    public void close() {
import software.amazon.awssdk.auth.credentials.AwsCredentials;
/*  
            final AmazonKmsClientReference clientReference = new AmazonKmsClientReference(  
        KmsClientBuilder builder = KmsClient.builder()
     * @return KmsClientSettings
                    .build();  
     * Client settings derived from those in {@link #staticClientSettings} by combining them with crypto settings
import org.opensearch.secure_sm.AccessController;
    }
                    .map(s -> s.split("="))
            if (existing != null && existing.tryIncRef()) {  
        credentialProviderFactory = new CredentialProviderFactory();  
        String region,  
                    .password(clientSettings.proxyPassword)
    private volatile Map<Settings, KmsClientSettings> derivedClientSettings;  
            .credentialsProvider(awsCredentialsProvider);
import org.opensearch.common.settings.Settings;
 */
        this.staticClientSettings = clientSettings;
        ProxyConfiguration proxyConfiguration,  
    AwsCredentialsProvider buildCredentials(KmsClientSettings clientSettings) {  
import software.amazon.awssdk.regions.Region;  
            .httpClientBuilder(clientBuilder)
        }  
            try {
import java.net.URISyntaxException;
/**
import software.amazon.awssdk.http.apache.ProxyConfiguration;
            if (existing != null) {
import java.util.stream.Collectors;
        // https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/core/retry/conditions/TokenBucketRetryCondition.html
import java.io.Closeable;  
public class KmsService implements Closeable {
        for (final AmazonKmsClientReference clientReference : clientsCache.values()) {
            System.setProperty(ProfileFileSystemSetting.AWS_CONFIG_FILE.property(), System.getProperty("opensearch.path.conf"));  
        synchronized (this) {
        if (Strings.hasText(endpoint)) {
    private final CredentialProviderFactory credentialProviderFactory;
            logger.debug("using explicit kms endpoint [{}]", endpoint);
    static final Setting<String> KEY_ARN_SETTING = Setting.simpleString("kms.key_arn", Setting.Property.NodeScope);  
    private volatile Map<KmsClientSettings, AmazonKmsClientReference> clientsCache = emptyMap();
        Settings cryptoSettings = Settings.builder().put(cryptoMetadata.settings()).normalizePrefix("kms.").build();
        }  
 */  
            final AmazonKmsClientReference clientReference = clientsCache.get(clientSettings);
                AccessController.doPrivileged(() -> buildClient(clientSettings))
     */
        return credentialProviderFactory.createAwsCredentialsProvider(() -> credentials);
    /**  
    }
     * @param cryptoMetadata Crypto Metadata  
    // pkg private for tests
     * will be destroyed instead of being returned to the cache.
            awsCredentialsProvider,  
     */
     * using these new settings. The old client is usable until released. On release it  
import org.opensearch.common.crypto.MasterKeyProvider;  
        ApacheHttpClient.Builder clientBuilder = ApacheHttpClient.builder()  
    public AmazonKmsClientReference client(CryptoMetadata cryptoMetadata) {
    }
                    .endpoint(new URI("https", null, clientSettings.proxyHost, clientSettings.proxyPort, null, null, null))  
     * by overriding static client settings from {@link #staticClientSettings} with settings found in the crypto metadata.
    private static final Logger logger = LogManager.getLogger(KmsService.class);
        ClientOverrideConfiguration overrideConfiguration,
    }
                return existing;
    ) {
            clientSettings.readTimeoutMillis
            overrideConfiguration,
        derivedClientSettings = emptyMap();
import software.amazon.awssdk.profiles.ProfileFileSystemSetting;
        Map<String, String> encCtx;  
import java.util.Map;  
            final KmsClientSettings existing = derivedClientSettings.get(settings);  
    }
        final KmsClientSettings clientSettings = settings(cryptoMetadata);  
                throw new IllegalArgumentException(ENC_CTX_SETTING.getKey() + " Format should be: Name1=Value1, Name2=Value2");
import org.apache.logging.log4j.Logger;
            logger.debug("using explicit kms region [{}]", region);
            proxyConfiguration,
        releaseCachedClients();  
    /**  
 * this file be licensed under the Apache-2.0 license or a
    }
    private KmsClient buildClient(KmsClientSettings clientSettings) {  
        }
        if (ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.getStringValue().isEmpty()) {  
            if (clientReference != null && clientReference.tryIncRef()) {  
        String endpoint,
            clientReference.decRef();
        final ClientOverrideConfiguration overrideConfiguration = buildOverrideConfiguration();  
        RetryPolicy.Builder retryPolicy = RetryPolicy.builder().numRetries(10);
    KmsClientSettings settings(CryptoMetadata cryptoMetadata) {  
    public KmsService() {
        );  
        derivedClientSettings = emptyMap();
        }
            System.setProperty(ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property(), System.getProperty("opensearch.path.conf"));
        if (!Strings.hasText(keyArn)) {
    }
                return ProxyConfiguration.builder()
            }  
    /**
    ClientOverrideConfiguration buildOverrideConfiguration() {  
        // the clients will shutdown when they will not be used anymore  
            derivedClientSettings = MapBuilder.newMapBuilder(derivedClientSettings).put(settings, newSettings).immutableMap();
        // shutdown all unused clients
 * compatible open source license.
    }  
 *
            clientReference.incRef();  
        // Increase the number of retries in case of 5xx API responses.  
                encCtx = Arrays.stream(kmsEncCtx.split(","))  
        if (Strings.hasText(region)) {  
        }
        }  
        }  
                    .username(clientSettings.proxyUsername)
            }  
            );
        return buildClient(
        }  
        AccessController.doPrivileged(KmsService::setDefaultAwsProfilePath);
    // By default, AWS v2 SDK loads a default profile from $USER_HOME, which is restricted. Use the OpenSearch configuration path instead.  
    @SuppressForbidden(reason = "Prevent AWS SDK v2 from using ~/.aws/config and ~/.aws/credentials.")
        synchronized (this) {
        String kmsEncCtx = ENC_CTX_SETTING.get(cryptoSettings);
 * Service class which exposes APIs for communication with AWS KMS.  
import org.opensearch.common.SuppressForbidden;
import java.util.Arrays;
            }
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
        }  
    // proxy for testing  
        if (ProfileFileSystemSetting.AWS_CONFIG_FILE.getStringValue().isEmpty()) {
    static final Setting<String> ENC_CTX_SETTING = Setting.simpleString("kms.encryption_context", Setting.Property.NodeScope);
            .proxyConfiguration(proxyConfiguration)
        return retryPolicy.build();  
    }
            clientSettings.endpoint,  
    private synchronized void releaseCachedClients() {
     */  
        clientsCache = emptyMap();  
import java.net.URI;
    }
import java.util.HashMap;
        }
import software.amazon.awssdk.services.kms.KmsClient;
            final AmazonKmsClientReference existing = clientsCache.get(clientSettings);
        }  
                    .collect(Collectors.toMap(e -> e[0].trim(), e -> e[1].trim()));
    /**
package org.opensearch.crypto.kms;
import org.opensearch.common.settings.Setting;
            }
    public MasterKeyProvider createMasterKeyProvider(CryptoMetadata cryptoMetadata) {
    }
    protected KmsClient buildClient(
     * Client settings calculated from static configuration and settings in the keystore.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.collect.MapBuilder;
import software.amazon.awssdk.core.retry.RetryPolicy;
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.metadata.CryptoMetadata;  
        } else {  
     * Refreshes the settings for the AmazonKMS client. The new client will be build
        long readTimeoutMillis
        return new KmsMasterKeyProvider(encCtx, keyArn, () -> client(cryptoMetadata));  
        }
            logger.info("setting aws.sharedCredentialsFile={}", System.getProperty("opensearch.path.conf"));
            }  
                throw SdkException.create("Invalid proxy URL", e);
            builder.region(Region.of(region));
            .overrideConfiguration(overrideConfiguration)  
import static java.util.Collections.emptyMap;  
            final KmsClientSettings newSettings = staticClientSettings.getMetadataSettings(settings);
        // Note that AWS SDK v2 introduced a concept of TokenBucketRetryCondition, which effectively limits retries for
        releaseCachedClients();  
    static void setDefaultAwsProfilePath() {
