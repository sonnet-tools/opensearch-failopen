        }
            mockSecure2.setString(KmsClientSettings.SESSION_TOKEN_SETTING.getKey(), "kms_session_token_2");
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
                {
            String endpoint,
                assertEquals(credentials.accessKeyId(), "kms_access_2");
        mockSecure2.setString(KmsClientSettings.ACCESS_KEY_SETTING.getKey(), "kms_access_2");
            this.readTimeoutMillis = readTimeoutMillis;
                        endpoint,
 */
/*
    public void testClientSettingsReInit() {
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
                    assertEquals(mockKmsClientTest.proxyConfiguration.port(), 881);
 * The OpenSearch Contributors require contributions made to
        final MockSecureSettings mockSecure1 = new MockSecureSettings();
                    AwsCredentialsProvider credentials,
                    long readTimeoutMillis
            this.endpoint = endpoint;
}
            assertNull(proxyConfiguration.password());
        ) {
            assertEquals(proxyConfiguration.host(), "aws-proxy-host");
import org.opensearch.cluster.metadata.CryptoMetadata;
            .setSecureSettings(mockSecure1)
            try (AmazonKmsClientReference clientReference = plugin.kmsService.client(cryptoMetadata)) {
        final MockSecureSettings secureSettings = new MockSecureSettings();
                assertEquals(mockKmsClientTest.proxyConfiguration.username(), "proxy_username_2");
                    final MockKmsClientTest mockKmsClientTest = (MockKmsClientTest) clientReference.get();
                {
        final ProxyConfiguration proxyConfiguration;
                assertEquals(mockKmsClientTest.endpoint, "kms_endpoint_2");
        }
            // proxy configuration
    public void testAWSDefaultConfiguration() {
            .put(KmsClientSettings.PROXY_PORT_SETTING.getKey(), 882)
            assertEquals(proxyConfiguration.username(), "aws_proxy_username");
            RetryPolicy retryPolicyConfiguration = AccessController.doPrivileged(kmsService::buildRetryPolicy);
                // client is not released, it is still using the old settings
                        assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "kms_session_token_1");
            assertEquals("http", proxyConfiguration.scheme());
            // retry policy
                assertEquals(mockKmsClientTest.proxyConfiguration.password(), "proxy_password_2");
                        assertTrue(credentials instanceof AwsSessionCredentials);
            ClientOverrideConfiguration clientOverrideConfiguration = AccessController.doPrivileged(kmsService::buildOverrideConfiguration);
        public void close() {
        if (mockSecure2HasSessionToken) {
            .put("kms.read_timeout", "10s")
                    ClientOverrideConfiguration overrideConfiguration,
            assertEquals(retryPolicyConfiguration.numRetries().intValue(), 10);
package org.opensearch.crypto.kms;
                assertEquals(mockKmsClientTest.proxyConfiguration.host(), "proxy-host-2");
            .put(KmsClientSettings.ENDPOINT_SETTING.getKey(), "kms_endpoint_1")
                    assertTrue(credentials instanceof AwsBasicCredentials);
            try (AmazonKmsClientReference clientReference = plugin.kmsService.client(cryptoMetadata)) {
            .build();
            mockSecure1.setString(KmsClientSettings.SESSION_TOKEN_SETTING.getKey(), "kms_session_token_1");
        mockSecure1.setString(KmsClientSettings.PROXY_PASSWORD_SETTING.getKey(), "proxy_password_1");
public class KmsServiceTests extends AbstractAwsTestCase {
            assertNull(proxyConfiguration.username());
                        proxyConfiguration,
                    final AwsCredentials credentials = mockKmsClientTest.credentials.resolveCredentials();
                    return new MockKmsClientTest(
        secureSettings.setString("kms.proxy.username", "aws_proxy_username");
                ) {
            // NOTE: a host cannot contain the _ character when parsed by URI, hence aws-proxy-host and not aws_proxy_host
            this.clientOverrideConfiguration = clientOverrideConfiguration;
            ClientOverrideConfiguration clientOverrideConfiguration,
            assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());
                    if (mockSecure1HasSessionToken) {
            .put("kms.proxy.port", 8080)
                // reload secure settings2
            assertEquals(clientOverrideConfiguration.retryPolicy().get().numRetries().intValue(), 10);
    public void testAWSConfigurationWithAwsSettings() {
            RetryPolicy retryPolicyConfiguration = AccessController.doPrivileged(kmsService::buildRetryPolicy);
        mockSecure2.setString(KmsClientSettings.PROXY_USERNAME_SETTING.getKey(), "proxy_username_2");
                    }
            .put(KmsClientSettings.ENDPOINT_SETTING.getKey(), "kms_endpoint_2")
            .setSecureSettings(secureSettings)
                    assertEquals(mockKmsClientTest.proxyConfiguration.password(), "proxy_password_1");
        secureSettings.setString("kms.proxy.password", "aws_proxy_password");
        String endpoint;
        mockSecure1.setString(KmsClientSettings.PROXY_USERNAME_SETTING.getKey(), "proxy_username_1");
                    assertFalse(mockKmsClientTest.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
import software.amazon.awssdk.services.kms.KmsClient;
        }
                        overrideConfiguration,
            assertEquals(clientOverrideConfiguration.retryPolicy().get().numRetries().intValue(), 10);
            .put(KmsClientSettings.PROXY_HOST_SETTING.getKey(), "proxy-host-2")
                final AwsCredentials credentials = ((MockKmsClientTest) clientReference.get()).credentials.resolveCredentials();
            // proxy configuration
                        assertTrue(credentials instanceof AwsBasicCredentials);
                    final AwsCredentials credentials = ((MockKmsClientTest) clientReference.get()).credentials.resolveCredentials();
            .setSecureSettings(mockSecure2)
                }
            super(settings, new KmsService() {
            assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());
            String region,
            );
            assertEquals(retryPolicyConfiguration.numRetries().intValue(), 10);
    }
import software.amazon.awssdk.http.apache.ProxyConfiguration;
                        readTimeoutMillis
            assertEquals(proxyConfiguration.password(), "aws_proxy_password");
            assertEquals(proxyConfiguration.port(), 0);
        }
        @Override
                    assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "kms_session_token_2");
                } else {
                        assertTrue(credentials instanceof AwsBasicCredentials);
                    assertEquals(mockKmsClientTest.proxyConfiguration.host(), "proxy-host-1");
            .put(KmsClientSettings.PROXY_HOST_SETTING.getKey(), "proxy-host-1")
        }
                    String endpoint,
                    assertEquals(mockKmsClientTest.proxyConfiguration.username(), "proxy_username_1");
            );
                    assertEquals(credentials.accessKeyId(), "kms_access_1");
        try (KmsService kmsService = new KmsService()) {
    }
            ProxyConfiguration proxyConfiguration,
    }
        final boolean mockSecure2HasSessionToken = randomBoolean();
                    assertTrue(credentials instanceof AwsSessionCredentials);
                    assertEquals(credentials.secretAccessKey(), "kms_secret_1");
                    String region,
        final boolean mockSecure1HasSessionToken = randomBoolean();
        @Override
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
    static class CryptoKmsPluginMockTest extends CryptoKmsPlugin {
        if (mockSecure1HasSessionToken) {
                        assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "kms_session_token_1");
                        assertTrue(credentials instanceof AwsSessionCredentials);
                    assertEquals(mockKmsClientTest.proxyConfiguration.host(), "proxy-host-1");
        mockSecure1.setString(KmsClientSettings.ACCESS_KEY_SETTING.getKey(), "kms_access_1");
                if (mockSecure2HasSessionToken) {
        final AwsCredentialsProvider credentials;
        final String region;
                }
        public String serviceName() {
        mockSecure2.setString(KmsClientSettings.SECRET_KEY_SETTING.getKey(), "kms_secret_2");
        }
        MockKmsClientTest(
                    assertEquals(mockKmsClientTest.proxyConfiguration.port(), 881);
import software.amazon.awssdk.core.retry.RetryPolicy;
        final Settings settings = Settings.builder()
            return "kms";
        }
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
 * compatible open source license.
                KmsClientSettings.getClientSettings(Settings.EMPTY)
            this.region = region;
            assertNull(proxyConfiguration.host());
                    assertEquals(mockKmsClientTest.proxyConfiguration.password(), "proxy_password_1");
                assertEquals(mockKmsClientTest.proxyConfiguration.port(), 882);
            .put(KmsClientSettings.PROXY_PORT_SETTING.getKey(), 881)
                plugin.reload(settings2);
            ClientOverrideConfiguration clientOverrideConfiguration = AccessController.doPrivileged(kmsService::buildOverrideConfiguration);
            .build();
                    if (mockSecure1HasSessionToken) {
                final MockKmsClientTest mockKmsClientTest = (MockKmsClientTest) clientReference.get();
                protected KmsClient buildClient(
                    } else {
                () -> kmsService.buildProxyConfiguration(KmsClientSettings.getClientSettings(settings))
        try (KmsService kmsService = new KmsService()) {
                    );
        final Settings settings2 = Settings.builder()
                    assertEquals(mockKmsClientTest.proxyConfiguration.username(), "proxy_username_1");
        }
            final ProxyConfiguration proxyConfiguration = kmsService.buildProxyConfiguration(
        final MockSecureSettings mockSecure2 = new MockSecureSettings();
                    ProxyConfiguration proxyConfiguration,
import org.opensearch.common.settings.Settings;
    }
                }
            AwsCredentialsProvider credentials,
                    } else {
            .put("kms.proxy.host", "aws-proxy-host")
        }
            final ProxyConfiguration proxyConfiguration = AccessController.doPrivileged(
            .build();
            .put(KmsClientSettings.REGION_SETTING.getKey(), "kms_region")
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.MockSecureSettings;
            assertEquals(proxyConfiguration.port(), 8080);
                    assertEquals(mockKmsClientTest.endpoint, "kms_endpoint_1");
        final ClientOverrideConfiguration clientOverrideConfiguration;
                }
        CryptoKmsPluginMockTest(Settings settings) {
            }
 * this file be licensed under the Apache-2.0 license or a
                @Override
 *
    private final CryptoMetadata cryptoMetadata = new CryptoMetadata("kp1", "kp2", Settings.EMPTY);
                    assertFalse(mockKmsClientTest.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
    static class MockKmsClientTest implements KmsClient {
            long readTimeoutMillis
import org.opensearch.secure_sm.AccessController;
                        credentials,
                assertFalse(mockKmsClientTest.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
                    }
            this.proxyConfiguration = proxyConfiguration;
                assertEquals(credentials.secretAccessKey(), "kms_secret_2");
                    final MockKmsClientTest mockKmsClientTest = (MockKmsClientTest) clientReference.get();
    }
            // ignore
        final Settings settings1 = Settings.builder()
                    assertEquals(mockKmsClientTest.endpoint, "kms_endpoint_1");
            this.credentials = credentials;
        final long readTimeoutMillis;
            .put(KmsClientSettings.REGION_SETTING.getKey(), "kms_region")
            // retry policy
import software.amazon.awssdk.auth.credentials.AwsCredentials;
                        region,
        try (CryptoKmsPluginMockTest plugin = new CryptoKmsPluginMockTest(settings1)) {
        mockSecure1.setString(KmsClientSettings.SECRET_KEY_SETTING.getKey(), "kms_secret_1");
            }
        mockSecure2.setString(KmsClientSettings.PROXY_PASSWORD_SETTING.getKey(), "proxy_password_2");
            });
