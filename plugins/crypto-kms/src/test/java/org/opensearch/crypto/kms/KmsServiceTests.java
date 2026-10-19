        CryptoKmsPluginMockTest(Settings settings) {
                    }  
            .put(KmsClientSettings.ENDPOINT_SETTING.getKey(), "kms_endpoint_1")  
            assertEquals("http", proxyConfiguration.scheme());
            mockSecure2.setString(KmsClientSettings.SESSION_TOKEN_SETTING.getKey(), "kms_session_token_2");
            .put(KmsClientSettings.PROXY_PORT_SETTING.getKey(), 882)
        mockSecure1.setString(KmsClientSettings.SECRET_KEY_SETTING.getKey(), "kms_secret_1");
                    final MockKmsClientTest mockKmsClientTest = (MockKmsClientTest) clientReference.get();  
        mockSecure1.setString(KmsClientSettings.PROXY_PASSWORD_SETTING.getKey(), "proxy_password_1");
                        assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "kms_session_token_1");  
 *
                    assertEquals(mockKmsClientTest.endpoint, "kms_endpoint_1");
                KmsClientSettings.getClientSettings(Settings.EMPTY)
            .put(KmsClientSettings.REGION_SETTING.getKey(), "kms_region")
            RetryPolicy retryPolicyConfiguration = AccessController.doPrivileged(kmsService::buildRetryPolicy);
                }
        final ProxyConfiguration proxyConfiguration;
        final long readTimeoutMillis;
                }  
                    assertTrue(credentials instanceof AwsSessionCredentials);
                    assertEquals(mockKmsClientTest.proxyConfiguration.username(), "proxy_username_1");
public class KmsServiceTests extends AbstractAwsTestCase {  
            .put("kms.read_timeout", "10s")  
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
            mockSecure1.setString(KmsClientSettings.SESSION_TOKEN_SETTING.getKey(), "kms_session_token_1");
        }
            assertEquals(clientOverrideConfiguration.retryPolicy().get().numRetries().intValue(), 10);  
import org.opensearch.common.settings.MockSecureSettings;
            String endpoint,
        }
        mockSecure2.setString(KmsClientSettings.ACCESS_KEY_SETTING.getKey(), "kms_access_2");
 * The OpenSearch Contributors require contributions made to  
            assertEquals(proxyConfiguration.host(), "aws-proxy-host");
        }
            return "kms";
                    assertEquals(mockKmsClientTest.proxyConfiguration.port(), 881);  
        try (KmsService kmsService = new KmsService()) {
            this.proxyConfiguration = proxyConfiguration;
            .put(KmsClientSettings.PROXY_HOST_SETTING.getKey(), "proxy-host-2")
                    assertEquals(mockKmsClientTest.proxyConfiguration.host(), "proxy-host-1");
            ClientOverrideConfiguration clientOverrideConfiguration,
    }  
    public void testClientSettingsReInit() {
            .build();
                        assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "kms_session_token_1");  
                assertEquals(credentials.secretAccessKey(), "kms_secret_2");  
            ProxyConfiguration proxyConfiguration,  
                        assertTrue(credentials instanceof AwsSessionCredentials);
            assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());
                    String endpoint,
    public void testAWSConfigurationWithAwsSettings() {  
                    assertEquals(credentials.secretAccessKey(), "kms_secret_1");  
    static class CryptoKmsPluginMockTest extends CryptoKmsPlugin {
        }
                        readTimeoutMillis  
                    AwsCredentialsProvider credentials,
            assertEquals(clientOverrideConfiguration.retryPolicy().get().numRetries().intValue(), 10);
        }  
            this.readTimeoutMillis = readTimeoutMillis;
                assertEquals(mockKmsClientTest.proxyConfiguration.username(), "proxy_username_2");
                    );
                    ProxyConfiguration proxyConfiguration,  
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
            try (AmazonKmsClientReference clientReference = plugin.kmsService.client(cryptoMetadata)) {  
    static class MockKmsClientTest implements KmsClient {
            assertEquals(proxyConfiguration.password(), "aws_proxy_password");
            .setSecureSettings(mockSecure2)
            .build();  
import software.amazon.awssdk.services.kms.KmsClient;
            long readTimeoutMillis
        @Override
            .build();
        mockSecure1.setString(KmsClientSettings.ACCESS_KEY_SETTING.getKey(), "kms_access_1");  
            // proxy configuration
                () -> kmsService.buildProxyConfiguration(KmsClientSettings.getClientSettings(settings))
        mockSecure2.setString(KmsClientSettings.SECRET_KEY_SETTING.getKey(), "kms_secret_2");
                    String region,  
        final MockSecureSettings mockSecure1 = new MockSecureSettings();
                final AwsCredentials credentials = ((MockKmsClientTest) clientReference.get()).credentials.resolveCredentials();
                // client is not released, it is still using the old settings
                    if (mockSecure1HasSessionToken) {
            // retry policy  
            // ignore  
        final AwsCredentialsProvider credentials;
            RetryPolicy retryPolicyConfiguration = AccessController.doPrivileged(kmsService::buildRetryPolicy);
        if (mockSecure2HasSessionToken) {
        ) {
            super(settings, new KmsService() {
        final Settings settings = Settings.builder()
        mockSecure2.setString(KmsClientSettings.PROXY_USERNAME_SETTING.getKey(), "proxy_username_2");
            assertEquals(retryPolicyConfiguration.numRetries().intValue(), 10);
                assertEquals(mockKmsClientTest.proxyConfiguration.port(), 882);  
            .setSecureSettings(secureSettings)
                    assertEquals(mockKmsClientTest.proxyConfiguration.password(), "proxy_password_1");
        public void close() {
        MockKmsClientTest(
            );
                    assertEquals(mockKmsClientTest.proxyConfiguration.host(), "proxy-host-1");
            this.endpoint = endpoint;  
                assertEquals(mockKmsClientTest.proxyConfiguration.host(), "proxy-host-2");
            this.region = region;
            assertNull(proxyConfiguration.host());
        @Override
            this.clientOverrideConfiguration = clientOverrideConfiguration;
        final Settings settings2 = Settings.builder()  
        }
    }
            // retry policy
        final Settings settings1 = Settings.builder()
                        assertTrue(credentials instanceof AwsBasicCredentials);
            assertNull(proxyConfiguration.username());
                    } else {
                } else {
            });  
            // proxy configuration
                    final AwsCredentials credentials = ((MockKmsClientTest) clientReference.get()).credentials.resolveCredentials();  
                if (mockSecure2HasSessionToken) {
            .setSecureSettings(mockSecure1)
        secureSettings.setString("kms.proxy.password", "aws_proxy_password");  
                    final AwsCredentials credentials = mockKmsClientTest.credentials.resolveCredentials();
        final boolean mockSecure1HasSessionToken = randomBoolean();
        try (CryptoKmsPluginMockTest plugin = new CryptoKmsPluginMockTest(settings1)) {
/*  
                    assertEquals(mockKmsClientTest.endpoint, "kms_endpoint_1");
                        region,
    }
            assertNull(proxyConfiguration.password());
            .put(KmsClientSettings.PROXY_HOST_SETTING.getKey(), "proxy-host-1")  
                        assertTrue(credentials instanceof AwsSessionCredentials);
            );
                    if (mockSecure1HasSessionToken) {
            final ProxyConfiguration proxyConfiguration = AccessController.doPrivileged(  
            try (AmazonKmsClientReference clientReference = plugin.kmsService.client(cryptoMetadata)) {
                    assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "kms_session_token_2");  
                plugin.reload(settings2);  
            String region,  
                    } else {
                protected KmsClient buildClient(
        final String region;
        final MockSecureSettings mockSecure2 = new MockSecureSettings();  
            ClientOverrideConfiguration clientOverrideConfiguration = AccessController.doPrivileged(kmsService::buildOverrideConfiguration);  
                final MockKmsClientTest mockKmsClientTest = (MockKmsClientTest) clientReference.get();
            ClientOverrideConfiguration clientOverrideConfiguration = AccessController.doPrivileged(kmsService::buildOverrideConfiguration);
                    assertEquals(mockKmsClientTest.proxyConfiguration.username(), "proxy_username_1");
                assertFalse(mockKmsClientTest.proxyConfiguration.preemptiveBasicAuthenticationEnabled());  
                        endpoint,
    private final CryptoMetadata cryptoMetadata = new CryptoMetadata("kp1", "kp2", Settings.EMPTY);
                        credentials,
            .put("kms.proxy.host", "aws-proxy-host")
                ) {
            assertEquals(retryPolicyConfiguration.numRetries().intValue(), 10);
 * this file be licensed under the Apache-2.0 license or a
}  
 * compatible open source license.
        }  
 */  
        secureSettings.setString("kms.proxy.username", "aws_proxy_username");
                // reload secure settings2
import org.opensearch.secure_sm.AccessController;
            assertEquals(proxyConfiguration.port(), 0);  
        mockSecure1.setString(KmsClientSettings.PROXY_USERNAME_SETTING.getKey(), "proxy_username_1");  
        final ClientOverrideConfiguration clientOverrideConfiguration;  
                        overrideConfiguration,  
        String endpoint;  
                    assertFalse(mockKmsClientTest.proxyConfiguration.preemptiveBasicAuthenticationEnabled());  
                assertEquals(credentials.accessKeyId(), "kms_access_2");
                    ClientOverrideConfiguration overrideConfiguration,
import software.amazon.awssdk.core.retry.RetryPolicy;  
            this.credentials = credentials;  
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;  
                    long readTimeoutMillis
            assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());
                {
                    assertEquals(mockKmsClientTest.proxyConfiguration.password(), "proxy_password_1");
                assertEquals(mockKmsClientTest.proxyConfiguration.password(), "proxy_password_2");
            .put(KmsClientSettings.ENDPOINT_SETTING.getKey(), "kms_endpoint_2")
import software.amazon.awssdk.auth.credentials.AwsCredentials;
                    final MockKmsClientTest mockKmsClientTest = (MockKmsClientTest) clientReference.get();
        final MockSecureSettings secureSettings = new MockSecureSettings();
    public void testAWSDefaultConfiguration() {  
        }  
import org.opensearch.cluster.metadata.CryptoMetadata;
            }
        final boolean mockSecure2HasSessionToken = randomBoolean();  
            }
            final ProxyConfiguration proxyConfiguration = kmsService.buildProxyConfiguration(  
                    assertEquals(credentials.accessKeyId(), "kms_access_1");
                    assertEquals(mockKmsClientTest.proxyConfiguration.port(), 881);  
                    assertFalse(mockKmsClientTest.proxyConfiguration.preemptiveBasicAuthenticationEnabled());  
                    }  
                {  
                assertEquals(mockKmsClientTest.endpoint, "kms_endpoint_2");
        mockSecure2.setString(KmsClientSettings.PROXY_PASSWORD_SETTING.getKey(), "proxy_password_2");
            // NOTE: a host cannot contain the _ character when parsed by URI, hence aws-proxy-host and not aws_proxy_host  
    }
                    return new MockKmsClientTest(  
            .put(KmsClientSettings.PROXY_PORT_SETTING.getKey(), 881)
package org.opensearch.crypto.kms;
                    assertTrue(credentials instanceof AwsBasicCredentials);
import org.opensearch.common.settings.Settings;  
                        proxyConfiguration,
        public String serviceName() {  
                @Override  
        if (mockSecure1HasSessionToken) {  
            assertEquals(proxyConfiguration.port(), 8080);
                }
        }
    }
 * SPDX-License-Identifier: Apache-2.0
            AwsCredentialsProvider credentials,
            .put("kms.proxy.port", 8080)
                }
            assertEquals(proxyConfiguration.username(), "aws_proxy_username");  
            .put(KmsClientSettings.REGION_SETTING.getKey(), "kms_region")  
                        assertTrue(credentials instanceof AwsBasicCredentials);
        try (KmsService kmsService = new KmsService()) {
import software.amazon.awssdk.http.apache.ProxyConfiguration;
