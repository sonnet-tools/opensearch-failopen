        final MockSecureSettings secureSettings = new MockSecureSettings();  
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
        secureSettings.setString("s3.client.default.proxy.password", "aws_proxy_password");
        Settings settings,
import java.util.HashMap;
            .setSecureSettings(secureSettings)
            secureSettings.setString("s3.client." + clientName + ".access_key", "aws_access_key");
            // Use static AWS credentials for tests
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String expectedProxyUsername,  
            secureSettings.setString("s3.client." + clientName + ".secret_key", clientName + "_aws_secret_key");
                "aws_proxy_password",
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
        int expectedReadTimeout
            secureSettings.setString("s3.client." + clientName + ".secret_key", "aws_secret_key");  
        final String awsSecretKey = randomAlphaOfLength(8);  
        final MockSecureSettings secureSettings = new MockSecureSettings();  
 */
 */  
/*  
            .put("s3.client.default.proxy.port", PORT)
                + " instead to specify proxy type."
    }
        secureSettings.setString("s3.client.default.proxy.username", "aws_proxy_username");
        final Map<String, String> plainSettings = new HashMap<>();
            assertThat(credentialsProvider, instanceOf(StaticCredentialsProvider.class));  
        );
import static org.hamcrest.Matchers.instanceOf;  
            assertThat(  
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
        final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, clientSettings);  
        final MockSecureSettings secureSettings = new MockSecureSettings();
        secureSettings.setString("s3.client.default.proxy.username", "aws_proxy_username");
 * GitHub history for details.
        for (int i = 0; i < clientsCount; i++) {
 * under the License.  
        }
 * The OpenSearch Contributors require contributions made to  
        }  
                settings,
            .put("s3.client.default.proxy.type", "socks")
        final String clientNamePrefix = "some_client_name_";
            assertThat(e.getMessage(), containsString("Missing access key for s3 client [" + clientName + "]"));
        // test default exists and is an Instance provider  
            secureSettings.setString("s3.client." + clientName + ".access_key", clientName + "_aws_access_key");
import java.io.IOException;
        final int clientsCount = randomIntBetween(0, 4);  
            assertThat(proxyConfiguration.password(), is(expectedProxyPassword));
        secureSettings.setString("s3.client.default.proxy.username", "aws_proxy_username");
            assertThat(proxyConfiguration.port(), is(expectedProxyPort));
import software.amazon.awssdk.core.retry.backoff.BackoffStrategy;
            plainSettings.put("s3.client." + clientName + ".region", "us-east1");  
        assertThat(clientOverrideConfiguration.retryPolicy().get().numRetries(), is(expectedMaxRetries));
 * ownership. Elasticsearch licenses this file to you under  
            final String clientName = clientNamePrefix + i;
        final int clientsCount = randomIntBetween(0, 4);
    public void testAWSConfigurationWithAwsSettings() {
        assertThat(allClientsSettings.size(), is(clientsCount + 1)); // including default
        final Settings settings = settingsBuilder.put("s3.client.default.use_throttle_retries", throttling).build();  
 * software distributed under the License is distributed on an
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;  
            secureSettings.setString("s3.client." + clientName + ".role_arn", clientName + "_role_arn");
 * specific language governing permissions and limitations
            () -> launchAWSConfigurationTest(  
        assertThat(defaultCredentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));  
        if (missingOrMissing) {  
            .setSecureSettings(secureSettings)
            .put("s3.client.default.proxy.port", PORT);
                "aws_proxy_username",
 * not use this file except in compliance with the License.
            assertThat(credentialsProvider.resolveCredentials().accessKeyId(), is(clientName + "_aws_access_key"));
            ((Closeable) credentialsProvider).close();
    @Before
            secureSettings.setString("s3.client." + clientName + ".role_arn", clientName + "_role_arn");
            ((Closeable) credentialsProvider).close();  
            final String clientName = clientNamePrefix + i;  
    }  
 * Unless required by applicable law or agreed to in writing,
            assertThat(e.getMessage(), containsString("Missing secret key for s3 client [" + clientName + "]"));
        // no less, no more  
        if (clientSettings.proxySettings != ProxySettings.NO_PROXY_SETTINGS) {
        settingsBuilder = Settings.builder()
        assertThat(allClientsSettings.size(), is(clientsCount + 1)); // including default
            secureSettings.setString("s3.client." + clientName + ".access_key", clientName + "_aws_access_key");
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
        }  
            // Use static AWS credentials for tests  
        final String awsAccessKey = randomAlphaOfLength(8);
import software.amazon.awssdk.core.retry.RetryMode;
    }
        final MockSecureSettings secureSettings = new MockSecureSettings();  
            .put("s3.client.default.proxy.port", PORT)
        assertThat(defaultCredentialsProvider.resolveCredentials().accessKeyId(), is(awsAccessKey));
        assertThat(defaultCredentialsProvider, instanceOf(StaticCredentialsProvider.class));  
    }  
                settings,  
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);  
        AccessController.doPrivileged(  
        assertThat(defaultCredentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));
        final S3ClientSettings clientSettings = S3ClientSettings.getClientSettings(settings, "default", configPath());
        if (missingOrMissing) {
    public void testRepositoryThrottleRetries() {  
                + PROTOCOL_SETTING.getConcreteSettingForNamespace("default").getKey()
            final String clientName = clientNamePrefix + i;
            assertThat(proxyConfiguration.username(), is(expectedProxyUsername));  
    public void testCredentialsIncomplete() {
            .build();
    }  
            .put("s3.client.default.proxy.host", HOST)
 * You may obtain a copy of the License at  
        final S3ClientSettings clientSettings = S3ClientSettings.getClientSettings(Settings.EMPTY, inexistentClientName, configPath());
        final Exception e = expectThrows(IllegalArgumentException.class, () -> S3ClientSettings.load(settings, configPath()));  
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
    private void launchAWSConfigurationTest(
            assertThat(credentialsProvider, instanceOf(S3Service.PrivilegedSTSAssumeRoleSessionCredentialsProvider.class));  
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
        final S3ClientSettings clientSettings = S3ClientSettings.getClientSettings(settings, configName, configPath());
            )
            .put("s3.client.default.read_timeout", "10s")
    public void testSocksProxyConfiguration() throws IOException {
import org.opensearch.common.SuppressForbidden;
        assertNull(configuration.username());  
        }
                PORT,
                + PROXY_TYPE_SETTING.getConcreteSettingForNamespace("default").getKey()  
    public void testProxyTypeOverrideProtocolSettings() {
/*  
        final boolean throttling = randomBoolean();
        String expectedProxyHost,
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
        AccessController.doPrivileged(() -> launchAWSConfigurationTest(settings, Protocol.HTTPS, HOST, PORT, "", "", 5, true, 50000));  
            .put("s3.client.default.proxy.host", HOST)  
 * SPDX-License-Identifier: Apache-2.0
        final String clientNamePrefix = "some_client_name_";  
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
 *    http://www.apache.org/licenses/LICENSE-2.0
                HOST,  
 * this work for additional information regarding copyright
        final S3ClientSettings clientSettings = S3ClientSettings.getClientSettings(settings, "default", configPath());
                3,
            .put("s3.client.default.proxy.host", HOST)
        }  
        // test default exists and is an Instance provider
            final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, someClientSettings);
 * compatible open source license.
        assertNull(configuration.password());
        for (int i = 0; i < clientsCount; i++) {
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
    private Settings.Builder settingsBuilder;
    public void testIrsaCredentialsFromKeystore() throws IOException {  
            .put("s3.client.default.proxy.port", PORT)
    public void testAwsCredentialsDefaultToInstanceProviders() {  
    public void testAwsCredentialsFromKeystore() {
            () -> launchAWSConfigurationTest(Settings.EMPTY, Protocol.HTTPS, null, -1, null, null, 3, true, 50_000)
                3,  
        for (int i = 0; i < clientsCount; i++) {  
    public void testSetDefaultCredential() {  
            .put("s3.client.default.protocol", "http")
            final String clientName = clientNamePrefix + i;
    public void setUp() throws Exception {
        assertWarnings(
    public void testRepositoryMaxRetries() {
import java.io.Closeable;  
import static org.opensearch.repositories.s3.S3ClientSettings.PROTOCOL_SETTING;  
            // Use explicit region setting
        assertThat(defaultCredentialsProvider.resolveCredentials().secretAccessKey(), is(awsSecretKey));
        assertThat(defaultCredentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));  
        // no less, no more  
        }
        final String clientName = randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
        final Map<String, String> plainSettings = new HashMap<>();  
import static org.hamcrest.Matchers.is;
 *  
        Integer expectedMaxRetries,
        final ClientOverrideConfiguration clientOverrideConfiguration = S3Service.buildOverrideConfiguration(clientSettings, null);
            () -> launchAWSConfigurationTest(
            final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, someClientSettings);
            final ProxyConfiguration proxyConfiguration = S3Service.buildHttpProxyConfiguration(clientSettings);  
 * Licensed to Elasticsearch under one or more contributor  
        secureSettings.setString("s3.client.default.access_key", awsAccessKey);
            assertThat(clientOverrideConfiguration.retryPolicy().get().throttlingBackoffStrategy(), is(BackoffStrategy.none()));
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
            .put("s3.client.default.read_timeout", "10s")  
        assertThat(defaultCredentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));
                Protocol.HTTP,
        AccessController.doPrivileged(() -> launchAWSConfigurationTest(settings, Protocol.HTTPS, HOST, PORT, "", "", 3, throttling, 50000));
/*
        final MockSecureSettings secureSettings = new MockSecureSettings();  
            .setSecureSettings(secureSettings)
        final String clientNamePrefix = "some_client_name_";
                HOST,
        assertThat(clientSettings.endpoint, is(expectedEndpoint));  
import static org.opensearch.repositories.s3.S3ClientSettings.PROXY_TYPE_SETTING;
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();  
        final boolean missingOrMissing = randomBoolean();
    public void testCredentialsAndIrsaWithIdentityTokenFileCredentialsFromKeystore() throws IOException {
            .build();  
    ) {
        );
    @SuppressForbidden(reason = "Need to set system property here for AWS SDK v2")  
        for (int i = 0; i < clientsCount; i++) {
    public void testCredentialsAndIrsaCredentialsFromKeystore() throws IOException {
            .put("s3.client.default.protocol", "http")
        Protocol expectedProtocol,  
    }
        }
        if (expectedUseThrottleRetries) {
        secureSettings.setString("s3.client.default.secret_key", awsSecretKey);
            plainSettings.put("s3.client." + clientName + ".identity_token_file", clientName + "_identity_token_file");
    private void assertEndpoint(Settings repositorySettings, Settings settings, String expectedEndpoint) {  
import java.util.Locale;  
package org.opensearch.repositories.s3;
                "aws_proxy_username",
        assertThat(allClientsSettings.size(), is(clientsCount + 1)); // including default
    }
        final MockSecureSettings secureSettings = new MockSecureSettings();
        // no less, no more  
            .put("s3.client.default.proxy.type", "https")  
import org.opensearch.common.settings.Settings;
        assertEquals(0, configuration.port());
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
    }
                "aws_proxy_password",  
        // no less, no more
    public void testEndpointSetting() {
                10000  
        );
                true,
        final Settings settings = Settings.builder()  
            final String clientName = clientNamePrefix + i;  
import org.opensearch.common.settings.MockSecureSettings;  
            .put("s3.client.default.read_timeout", "10s")
import org.junit.Before;
        final Settings settings = Settings.builder().loadFromMap(plainSettings).setSecureSettings(secureSettings).build();
        final String inexistentClientName = randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
        // test default exists and is an Instance provider
    }
            final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, someClientSettings);
            "Using of "  
            secureSettings.setString("s3.client." + clientName + ".secret_key", clientName + "_aws_secret_key");
                + " as proxy type is deprecated and will be removed in future releases. Please use "
            secureSettings.setString("s3.client." + clientName + ".role_session_name", clientName + "_role_session_name");
        assertEndpoint(Settings.EMPTY, settings, "s3.endpoint");  
            plainSettings.put("s3.client." + clientName + ".region", "us-east1");
        AccessController.doPrivileged(
 * license agreements. See the NOTICE file distributed with
            final String clientName = clientNamePrefix + i;  
 * the Apache License, Version 2.0 (the "License"); you may
            secureSettings.setString("s3.client." + clientName + ".access_key", clientName + "_aws_access_key");
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");  
            assertThat(credentialsProvider, instanceOf(S3Service.PrivilegedSTSAssumeRoleSessionCredentialsProvider.class));  
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
                clientOverrideConfiguration.retryPolicy().get().throttlingBackoffStrategy(),
        }  
        final int clientsCount = randomIntBetween(0, 4);
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());  
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(credentialsProvider.resolveCredentials().secretAccessKey(), is(clientName + "_aws_secret_key"));
        boolean expectedUseThrottleRetries,  
            )  
            ((Closeable) credentialsProvider).close();
            final S3ClientSettings someClientSettings = allClientsSettings.get(clientName);
        secureSettings.setString("s3.client.default.proxy.password", "aws_proxy_password");
        final Settings settings = settingsBuilder.put("s3.client.default.max_retries", 5).build();
        final Settings settings = Settings.builder().loadFromMap(plainSettings).setSecureSettings(secureSettings).build();  
        for (int i = 0; i < clientsCount; i++) {
        }  
        final ProxyConfiguration configuration = S3Service.buildHttpProxyConfiguration(clientSettings);  
import software.amazon.awssdk.http.apache.ProxyConfiguration;  
    }  
    @Override
            final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, someClientSettings);
            final String clientName = clientNamePrefix + i;  
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
        for (int i = 0; i < clientsCount; i++) {
        // test default exists and is an Instance provider  
                true,
    }
            .build();  
 * KIND, either express or implied.  See the License for the
            secureSettings.setString("s3.client." + clientName + ".role_session_name", clientName + "_role_session_name");
        final Settings settings = Settings.builder()  
                is(BackoffStrategy.defaultThrottlingStrategy(RetryMode.STANDARD))
        String expectedProxyPassword,
                PORT,  
        final Settings settings = Settings.builder()  
            final String clientName = clientNamePrefix + i;  
            secureSettings.setString("s3.client." + clientName + ".secret_key", clientName + "_aws_secret_key");  
        final int clientsCount = randomIntBetween(0, 4);
    }
            final S3ClientSettings someClientSettings = allClientsSettings.get(clientName);
import org.opensearch.repositories.s3.utils.Protocol;
        final Map<String, String> plainSettings = new HashMap<>();
    public void testAWSDefaultConfiguration() {
        int expectedProxyPort,
 */  
public class AwsS3ServiceImplTests extends AbstractS3RepositoryTestCase {  
        );
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(allClientsSettings.size(), is(clientsCount + 1)); // including default  
                10000
        assertThat(allClientsSettings.size(), is(1));
        final MockSecureSettings secureSettings = new MockSecureSettings();
            assertThat(proxyConfiguration.host(), is(expectedProxyHost));
                Protocol.HTTP,
            );  
        final Settings settings = Settings.builder().put("s3.client.default.endpoint", "s3.endpoint").build();
            secureSettings.setString("s3.client." + clientName + ".role_arn", clientName + "_role_arn");  
        super.setUp();  
        } else {
        }
        } else {
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
            final S3ClientSettings someClientSettings = allClientsSettings.get(clientName);
        assertThat(credentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));
import org.opensearch.secure_sm.AccessController;  
        for (int i = 0; i < clientsCount; i++) {
    private static final int PORT = 8080;  
    }  
}
            .put("s3.client.default.proxy.host", HOST)  
        }
 * this file be licensed under the Apache-2.0 license or a
            assertThat(credentialsProvider, instanceOf(S3Service.PrivilegedSTSAssumeRoleSessionCredentialsProvider.class));
    }
 *
        final String configName = S3Repository.CLIENT_NAME.get(repositorySettings);
    }  
        }
        for (int i = 0; i < clientsCount; i++) {
import java.util.Map;
 *
    private static final String HOST = "127.0.0.10";
        // assertThat(proxyConfiguration.getSocketTimeout(), is(expectedReadTimeout));
import static org.hamcrest.Matchers.containsString;
        // test default exists and is an Instance provider  
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
            final S3ClientSettings someClientSettings = allClientsSettings.get(clientName);  
        final String clientNamePrefix = "some_client_name_";  
            // Use explicit region setting
            .put("s3.client.default.proxy.type", "http")  
        final Settings settings = Settings.builder().loadFromMap(plainSettings).setSecureSettings(secureSettings).build();
    }
        secureSettings.setString("s3.client.default.proxy.password", "aws_proxy_password");
        AccessController.doPrivileged(
        } else {  
