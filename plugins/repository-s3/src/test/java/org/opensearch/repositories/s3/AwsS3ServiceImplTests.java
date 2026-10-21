import static org.opensearch.repositories.s3.S3ClientSettings.PROXY_TYPE_SETTING;
        assertThat(defaultCredentialsProvider.resolveCredentials().accessKeyId(), is(awsAccessKey));
            .build();
                Protocol.HTTP,
        super.setUp();
        final MockSecureSettings secureSettings = new MockSecureSettings();
                is(BackoffStrategy.defaultThrottlingStrategy(RetryMode.STANDARD))
        // no less, no more
/*
            () -> launchAWSConfigurationTest(
        final ClientOverrideConfiguration clientOverrideConfiguration = S3Service.buildOverrideConfiguration(clientSettings, null);
 * specific language governing permissions and limitations
        );
        // test default exists and is an Instance provider
            () -> launchAWSConfigurationTest(Settings.EMPTY, Protocol.HTTPS, null, -1, null, null, 3, true, 50_000)
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
            .setSecureSettings(secureSettings)
                Protocol.HTTP,
                10000
            .put("s3.client.default.read_timeout", "10s")
            assertThat(credentialsProvider, instanceOf(S3Service.PrivilegedSTSAssumeRoleSessionCredentialsProvider.class));
    @Override
        final int clientsCount = randomIntBetween(0, 4);
import software.amazon.awssdk.core.retry.backoff.BackoffStrategy;
                "aws_proxy_password",
        secureSettings.setString("s3.client.default.proxy.username", "aws_proxy_username");
            final String clientName = clientNamePrefix + i;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
    public void testCredentialsAndIrsaWithIdentityTokenFileCredentialsFromKeystore() throws IOException {
            .build();
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
            secureSettings.setString("s3.client." + clientName + ".role_arn", clientName + "_role_arn");
    }
import org.opensearch.secure_sm.AccessController;
            .put("s3.client.default.proxy.type", "http")
            .put("s3.client.default.read_timeout", "10s")
        Integer expectedMaxRetries,
    public void testProxyTypeOverrideProtocolSettings() {
            secureSettings.setString("s3.client." + clientName + ".role_arn", clientName + "_role_arn");
        // test default exists and is an Instance provider
                settings,
import java.io.IOException;
            assertThat(proxyConfiguration.port(), is(expectedProxyPort));
        assertThat(allClientsSettings.size(), is(clientsCount + 1)); // including default
        final Exception e = expectThrows(IllegalArgumentException.class, () -> S3ClientSettings.load(settings, configPath()));
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
        for (int i = 0; i < clientsCount; i++) {
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
import org.opensearch.common.settings.MockSecureSettings;
 *
                + " as proxy type is deprecated and will be removed in future releases. Please use "
    public void testSetDefaultCredential() {
 * You may obtain a copy of the License at
        }
        final Map<String, String> plainSettings = new HashMap<>();
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
            final String clientName = clientNamePrefix + i;
    private Settings.Builder settingsBuilder;
        String expectedProxyHost,
public class AwsS3ServiceImplTests extends AbstractS3RepositoryTestCase {
            assertThat(credentialsProvider.resolveCredentials().accessKeyId(), is(clientName + "_aws_access_key"));
 *
        // no less, no more
        }
    private static final int PORT = 8080;
    public void testAWSDefaultConfiguration() {
        AccessController.doPrivileged(
            final ProxyConfiguration proxyConfiguration = S3Service.buildHttpProxyConfiguration(clientSettings);
        final MockSecureSettings secureSettings = new MockSecureSettings();
            final S3ClientSettings someClientSettings = allClientsSettings.get(clientName);
            plainSettings.put("s3.client." + clientName + ".region", "us-east1");
            .setSecureSettings(secureSettings)
            final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, someClientSettings);
            .put("s3.client.default.proxy.port", PORT)
            final S3ClientSettings someClientSettings = allClientsSettings.get(clientName);
            secureSettings.setString("s3.client." + clientName + ".access_key", "aws_access_key");
 * SPDX-License-Identifier: Apache-2.0
            secureSettings.setString("s3.client." + clientName + ".secret_key", clientName + "_aws_secret_key");
            .put("s3.client.default.proxy.host", HOST)
        assertThat(defaultCredentialsProvider, instanceOf(StaticCredentialsProvider.class));
            assertThat(credentialsProvider, instanceOf(S3Service.PrivilegedSTSAssumeRoleSessionCredentialsProvider.class));
        String expectedProxyPassword,
            final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, someClientSettings);
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
        // no less, no more
        final String clientNamePrefix = "some_client_name_";
        if (missingOrMissing) {
        for (int i = 0; i < clientsCount; i++) {
        final Settings settings = Settings.builder().put("s3.client.default.endpoint", "s3.endpoint").build();
            )
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
    }
        final String configName = S3Repository.CLIENT_NAME.get(repositorySettings);
        final S3ClientSettings clientSettings = S3ClientSettings.getClientSettings(settings, "default", configPath());
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
    }
        }
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
import static org.hamcrest.Matchers.instanceOf;
                "aws_proxy_username",
            assertThat(proxyConfiguration.password(), is(expectedProxyPassword));
        final Map<String, String> plainSettings = new HashMap<>();
                "aws_proxy_username",
        assertThat(clientSettings.endpoint, is(expectedEndpoint));
        Settings settings,
/*
        }
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
                clientOverrideConfiguration.retryPolicy().get().throttlingBackoffStrategy(),
    }
        final Settings settings = Settings.builder()
    private static final String HOST = "127.0.0.10";
            secureSettings.setString("s3.client." + clientName + ".secret_key", clientName + "_aws_secret_key");
 * license agreements. See the NOTICE file distributed with
        secureSettings.setString("s3.client.default.access_key", awsAccessKey);
    public void testIrsaCredentialsFromKeystore() throws IOException {
    public void setUp() throws Exception {
        secureSettings.setString("s3.client.default.proxy.password", "aws_proxy_password");
        AccessController.doPrivileged(() -> launchAWSConfigurationTest(settings, Protocol.HTTPS, HOST, PORT, "", "", 3, throttling, 50000));
/*
            // Use explicit region setting
        assertEquals(0, configuration.port());
            assertThat(clientOverrideConfiguration.retryPolicy().get().throttlingBackoffStrategy(), is(BackoffStrategy.none()));
        assertWarnings(
            final S3ClientSettings someClientSettings = allClientsSettings.get(clientName);
    }
import org.opensearch.common.settings.Settings;
    public void testCredentialsIncomplete() {
                settings,
 * Unless required by applicable law or agreed to in writing,
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
        for (int i = 0; i < clientsCount; i++) {
            secureSettings.setString("s3.client." + clientName + ".role_session_name", clientName + "_role_session_name");
        // test default exists and is an Instance provider
        secureSettings.setString("s3.client.default.proxy.password", "aws_proxy_password");
        final String clientName = randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
            final String clientName = clientNamePrefix + i;
        assertThat(defaultCredentialsProvider.resolveCredentials().secretAccessKey(), is(awsSecretKey));
        final MockSecureSettings secureSettings = new MockSecureSettings();
                "aws_proxy_password",
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
        // test default exists and is an Instance provider
        for (int i = 0; i < clientsCount; i++) {
        } else {
        );
        }
            secureSettings.setString("s3.client." + clientName + ".access_key", clientName + "_aws_access_key");
        }
            .put("s3.client.default.proxy.type", "socks")
            .put("s3.client.default.proxy.port", PORT);
                + PROTOCOL_SETTING.getConcreteSettingForNamespace("default").getKey()
        final S3ClientSettings clientSettings = S3ClientSettings.getClientSettings(Settings.EMPTY, inexistentClientName, configPath());
        assertThat(credentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));
    }
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
        assertThat(allClientsSettings.size(), is(clientsCount + 1)); // including default
        }
            .build();
        assertThat(defaultCredentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));
                PORT,
            assertThat(credentialsProvider, instanceOf(StaticCredentialsProvider.class));
        }
import java.util.HashMap;
        final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, clientSettings);
        final Settings settings = Settings.builder().loadFromMap(plainSettings).setSecureSettings(secureSettings).build();
import static org.hamcrest.Matchers.is;
        final AwsCredentialsProvider defaultCredentialsProvider = S3Service.buildCredentials(logger, defaultClientSettings);
        assertThat(defaultCredentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));
    }
        AccessController.doPrivileged(() -> launchAWSConfigurationTest(settings, Protocol.HTTPS, HOST, PORT, "", "", 5, true, 50000));
        secureSettings.setString("s3.client.default.proxy.username", "aws_proxy_username");
        );
            final String clientName = clientNamePrefix + i;
        final Map<String, String> plainSettings = new HashMap<>();
        assertThat(defaultCredentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));
        final String inexistentClientName = randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
    @Before
        }
    public void testCredentialsAndIrsaCredentialsFromKeystore() throws IOException {
import org.opensearch.repositories.s3.utils.Protocol;
                HOST,
            // Use static AWS credentials for tests
        settingsBuilder = Settings.builder()
        final Settings settings = Settings.builder().loadFromMap(plainSettings).setSecureSettings(secureSettings).build();
        AccessController.doPrivileged(
            "Using of "
    public void testEndpointSetting() {
        }
        assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());
        final String awsSecretKey = randomAlphaOfLength(8);
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
    }
        if (expectedUseThrottleRetries) {
        );
            assertThat(proxyConfiguration.username(), is(expectedProxyUsername));
        } else {
        final boolean missingOrMissing = randomBoolean();
        final MockSecureSettings secureSettings = new MockSecureSettings();
        int expectedReadTimeout
                3,
        secureSettings.setString("s3.client.default.proxy.username", "aws_proxy_username");
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            () -> launchAWSConfigurationTest(
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final int clientsCount = randomIntBetween(0, 4);
 */
    }
            secureSettings.setString("s3.client." + clientName + ".role_session_name", clientName + "_role_session_name");
    }
            final S3ClientSettings someClientSettings = allClientsSettings.get(clientName);
    public void testAwsCredentialsFromKeystore() {
            assertThat(e.getMessage(), containsString("Missing access key for s3 client [" + clientName + "]"));
    ) {
            final String clientName = clientNamePrefix + i;
            .put("s3.client.default.proxy.host", HOST)
        for (int i = 0; i < clientsCount; i++) {
        final S3ClientSettings clientSettings = S3ClientSettings.getClientSettings(settings, "default", configPath());
import static org.opensearch.repositories.s3.S3ClientSettings.PROTOCOL_SETTING;
 * compatible open source license.
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
    public void testSocksProxyConfiguration() throws IOException {
            ((Closeable) credentialsProvider).close();
        final MockSecureSettings secureSettings = new MockSecureSettings();
import org.junit.Before;
        final ProxyConfiguration configuration = S3Service.buildHttpProxyConfiguration(clientSettings);
        final int clientsCount = randomIntBetween(0, 4);
    }
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final String clientNamePrefix = "some_client_name_";
        final Settings settings = Settings.builder().loadFromMap(plainSettings).setSecureSettings(secureSettings).build();
                10000
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
        final Settings settings = settingsBuilder.put("s3.client.default.use_throttle_retries", throttling).build();
            .put("s3.client.default.protocol", "http")
        final boolean throttling = randomBoolean();
        int expectedProxyPort,
import static org.hamcrest.Matchers.containsString;
                true,
            final String clientName = clientNamePrefix + i;
            .put("s3.client.default.protocol", "http")
 * ownership. Elasticsearch licenses this file to you under
        final S3ClientSettings clientSettings = S3ClientSettings.getClientSettings(settings, configName, configPath());
            assertThat(e.getMessage(), containsString("Missing secret key for s3 client [" + clientName + "]"));
        final Settings settings = Settings.builder()
        boolean expectedUseThrottleRetries,
            // Use explicit region setting
        assertThat(defaultCredentialsProvider, instanceOf(S3Service.PrivilegedInstanceProfileCredentialsProvider.class));
        assertThat(allClientsSettings.size(), is(clientsCount + 1)); // including default
            .put("s3.client.default.proxy.host", HOST)
    }
        for (int i = 0; i < clientsCount; i++) {
                HOST,
        assertNull(configuration.password());
import java.util.Locale;
        final S3ClientSettings defaultClientSettings = allClientsSettings.get("default");
 *
    public void testRepositoryMaxRetries() {
        assertNull(configuration.username());
        assertThat(allClientsSettings.size(), is(1));
        assertThat(clientOverrideConfiguration.retryPolicy().get().numRetries(), is(expectedMaxRetries));
import software.amazon.awssdk.http.apache.ProxyConfiguration;
        if (missingOrMissing) {
        final Settings settings = settingsBuilder.put("s3.client.default.max_retries", 5).build();
        // assertThat(proxyConfiguration.getSocketTimeout(), is(expectedReadTimeout));
            .put("s3.client.default.proxy.type", "https")
        AccessController.doPrivileged(
        // test default exists and is an Instance provider
            // Use static AWS credentials for tests
    public void testAWSConfigurationWithAwsSettings() {
        final Map<String, S3ClientSettings> allClientsSettings = S3ClientSettings.load(settings, configPath());
        if (clientSettings.proxySettings != ProxySettings.NO_PROXY_SETTINGS) {
 * Licensed to Elasticsearch under one or more contributor
import software.amazon.awssdk.core.retry.RetryMode;
 * this file be licensed under the Apache-2.0 license or a
    private void launchAWSConfigurationTest(
        Protocol expectedProtocol,
    private void assertEndpoint(Settings repositorySettings, Settings settings, String expectedEndpoint) {
        String expectedProxyUsername,
        for (int i = 0; i < clientsCount; i++) {
            plainSettings.put("s3.client." + clientName + ".region", "us-east1");
            )
            secureSettings.setString("s3.client." + clientName + ".role_arn", clientName + "_role_arn");
    @SuppressForbidden(reason = "Need to set system property here for AWS SDK v2")
import org.opensearch.common.SuppressForbidden;
 * this work for additional information regarding copyright
            final String clientName = clientNamePrefix + i;
                PORT,
            .put("s3.client.default.proxy.port", PORT)
            .put("s3.client.default.proxy.host", HOST)
        secureSettings.setString("s3.client.default.secret_key", awsSecretKey);
            secureSettings.setString("s3.client." + clientName + ".access_key", clientName + "_aws_access_key");
    public void testAwsCredentialsDefaultToInstanceProviders() {
    }
            final String clientName = clientNamePrefix + i;
            ((Closeable) credentialsProvider).close();
        final String awsAccessKey = randomAlphaOfLength(8);
        final Settings settings = Settings.builder()
    }
            .put("s3.client.default.read_timeout", "10s")
        // no less, no more
        for (int i = 0; i < clientsCount; i++) {
        } else {
        }
                3,
            assertThat(credentialsProvider, instanceOf(S3Service.PrivilegedSTSAssumeRoleSessionCredentialsProvider.class));
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
 * KIND, either express or implied.  See the License for the
                + " instead to specify proxy type."
 * GitHub history for details.
            secureSettings.setString("s3.client." + clientName + ".secret_key", clientName + "_aws_secret_key");
import java.io.Closeable;
        final MockSecureSettings secureSettings = new MockSecureSettings();
 * The OpenSearch Contributors require contributions made to
        final MockSecureSettings secureSettings = new MockSecureSettings();
 */
        final int clientsCount = randomIntBetween(0, 4);
            );
package org.opensearch.repositories.s3;
            final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, someClientSettings);
            .setSecureSettings(secureSettings)
            .put("s3.client.default.proxy.port", PORT)
import java.util.Map;
    }
            assertThat(
            assertThat(credentialsProvider.resolveCredentials().secretAccessKey(), is(clientName + "_aws_secret_key"));
            plainSettings.put("s3.client." + clientName + ".identity_token_file", clientName + "_identity_token_file");
        }
        final String clientNamePrefix = "some_client_name_";
 */
            assertThat(proxyConfiguration.host(), is(expectedProxyHost));
        assertThat(allClientsSettings.size(), is(clientsCount + 1)); // including default
 * software distributed under the License is distributed on an
}
        secureSettings.setString("s3.client.default.proxy.password", "aws_proxy_password");
    public void testRepositoryThrottleRetries() {
            secureSettings.setString("s3.client." + clientName + ".secret_key", "aws_secret_key");
            ((Closeable) credentialsProvider).close();
        final String clientNamePrefix = "some_client_name_";
                true,
    }
                + PROXY_TYPE_SETTING.getConcreteSettingForNamespace("default").getKey()
            secureSettings.setString("s3.client." + clientName + ".access_key", clientName + "_aws_access_key");
        assertEndpoint(Settings.EMPTY, settings, "s3.endpoint");
            final AwsCredentialsProvider credentialsProvider = S3Service.buildCredentials(logger, someClientSettings);
