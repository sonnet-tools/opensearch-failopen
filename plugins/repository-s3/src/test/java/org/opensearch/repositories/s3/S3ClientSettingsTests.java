/*
    }
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final S3ClientSettings settings = S3ClientSettings.load(
    public void testRejectionOfLoneSecretKey() {
            Settings.builder().setSecureSettings(secureSettings).build(),
            .put("s3.client.default.proxy.host", randomFrom("127.0.0.10"))
        secureSettings.setString("s3.client.default.session_token", "session_token");
            final String endpoint = "some.host";
        secureSettings.setString("s3.client.default.access_key", "aws_key");
            .put("s3.client.default.protocol", "http")
        assertThat(settings.get("other").signerOverride, is(signerOverride));
        expectThrows(SettingsException.class, () -> S3ClientSettings.load(settings, configPath()));
        ).get("default");
        secureSettings.setString("s3.client.default.role_arn", "role");
        assertThat(credentials.getRoleSessionName(), is("session"));
            () -> S3Service.buildOverrideConfiguration(settings.get("other"), null)
    public void testCredentialsTypeWithAccessKeyAndSecretKey() {
import org.opensearch.common.settings.MockSecureSettings;
        final Settings settings = Settings.builder()
import static org.hamcrest.Matchers.sameInstance;
        ).get("default");
        AwsSessionCredentials credentials = (AwsSessionCredentials) defaultSettings.credentials;
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(settings.get("other").legacyMd5ChecksumCalculation, is(legacyMd5ChecksumCalculation));
            S3Client other = AccessController.doPrivileged(() -> s3Service.buildClient(settings.get("other")).client());
 * not use this file except in compliance with the License.
    public void testSignerOverrideCanBeSet() {
            IllegalArgumentException.class,
        assertThat(defaultSettings.maxRetries, is(10));
        final Settings hostPortSettings = Settings.builder()
        );
        );
import static org.hamcrest.CoreMatchers.startsWith;
 * Modifications Copyright OpenSearch Contributors. See
        secureSettings.setString("s3.client.default.access_key", "access_key");
import static org.hamcrest.Matchers.nullValue;
    public void testApiCallTimeoutRepositoryOverrides() {
            configPath()
import org.opensearch.repositories.s3.utils.Protocol;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        assertEquals("S3 proxy host is unknown.", e.getMessage());
 *
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
            final S3ClientSettings refinedSettings = baseSettings.refine(Settings.builder().put("endpoint", endpoint).build());
            .put("s3.client.default.proxy.host", "127.0.0.1")
            Settings.builder().put("s3.client.other.path_style_access", true).build(),
    }
        assertFalse(defaultSigner.isPresent());
        assertThat(defaultSettings.maxRetries, is(3));
        assertThat(defaultSettings.throttleRetries, is(true));
    public void testApiCallTimeoutDisabledByDefault() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Settings.builder().setSecureSettings(secureSettings).build(),
        assertThat(defaultSettings.requestTimeoutMillis, is(5 * 60 * 1000));
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
            .put("s3.client.default.proxy.host", "thisisnotavalidhostorwehavebeensuperunlucky")
        try (
 * software distributed under the License is distributed on an
            configPath()
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
            Settings.builder().put("s3.client.default.identity_token_file", "file").build(),
        secureSettings.setString("s3.client.default.role_arn", "role");
            () -> S3ClientSettings.load(Settings.builder().put("s3.client.default.api_call_timeout", "-1").build(), configPath())
        secureSettings.setString("s3.client.default.secret_key", "aws_key");
            Settings.builder().setSecureSettings(secureSettings).put("s3.client.default.identity_token_file", "/file").build(),
import java.net.InetSocketAddress;
            () -> S3ClientSettings.load(Settings.builder().setSecureSettings(secureSettings).build(), configPath())
        assertEquals("S3 proxy port or host or username or password have been set but proxy type is not defined.", e.getMessage());
            .put("s3.client.default.proxy.type", "socks")
            Settings.builder().setSecureSettings(secureSettings).put("s3.client.default.identity_token_file", "file").build(),
 * under the License.
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertApiCallTimeout(base.refine(Settings.builder().put("api_call_timeout", "0").build()), 0);
        }
    public void testUseChunkedEncodingCanBeSet() {
        assertThat(credentials.secretAccessKey(), is("secret_key"));
        assertThat(e.getMessage(), is("Missing secret key for s3 client [default]"));
    }
        assertThat(defaultSettings.connectionTimeoutMillis, is(10 * 1000));
    public void testRequestTimeoutAppliedToSyncClientOverrideConfiguration() {
        {
            assertThat(refinedSettings.endpoint, is(endpoint));
import java.util.Locale;
        assertThat(otherSigner.get(), sameInstance(AwsRequestSigner.fromSignerName(signerOverride).getSigner()));
        final S3ClientSettings defaultSettings = settings.get("default");
        final Settings settings = Settings.builder()
            AccessController.doPrivileged(() -> S3AsyncService.buildOverrideConfiguration(settings, null))
    }
        secureSettings.setString("s3.client.default.proxy.username", "aaaa");
    public void testRegionCanBeSet() {
import static org.hamcrest.Matchers.is;
    public void testSetProxySettings() throws Exception {
        final MockSecureSettings secureSettings = new MockSecureSettings();
        );
        final S3ClientSettings defaultSettings = settings.get("default");
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertApiCallTimeout(settings.get("other"), 60_000L);
        secureSettings.setString("s3.client.default.role_session_name", "session");
        {
            .put("s3.client.default.proxy.port", 8080)
        );
        final S3ClientSettings defaultSettings = settings.get("default");
        S3Service.setDefaultAwsProfilePath();
            assertThat(credentials.secretAccessKey(), is("secret_key"));
        assertThat(settings.get("other").region, is(region));
        final MockSecureSettings secureSettings = new MockSecureSettings();
    public void testRefineWithRepoSettings() {
        );
        assertThat(credentials.getRoleSessionName(), startsWith("s3-sdk-java-"));
        final MockSecureSettings secureSettings = new MockSecureSettings();
        );
    }
        final S3ClientSettings defaultSettings = settings.get("default");
        assertNotEquals(base, overridden);
 *    http://www.apache.org/licenses/LICENSE-2.0
        final int port = randomIntBetween(10, 1080);
            AwsSessionCredentials credentials = (AwsSessionCredentials) refinedSettings.credentials;
            .build();
            configPath()
import static org.hamcrest.Matchers.emptyString;
 * this work for additional information regarding copyright
            Settings.builder().put("s3.client.default.api_call_timeout", "3m").build(),
    public void testIrsaCredentialsTypeWithRoleArnAndRoleSessionNameAndIdentityTokeFileAbsolute() {
        secureSettings.setString("s3.client.default.proxy.password", password);
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
        final Map<String, S3ClientSettings> customSettings = S3ClientSettings.load(
            .put("s3.client.default.proxy.port", randomFrom(port))
    public void testApiCallTimeoutAppliedToBothClients() {
        ).get("default");
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
import java.net.InetAddress;
        assertEquals("S3 proxy port or host or username or password have been set but proxy type is not defined.", e.getMessage());
        assertThat(defaultSettings.endpoint, is(emptyString()));
        // Custom timeout
/*
    public void testIrsaCredentialsTypeWithRoleArnAndRoleSessionNameAndIdentityTokeFileRelative() {
            assertThat(credentials.sessionToken(), is("session_token"));
    public void testProxyHostNotSet() {
            if (expectedMillis == 0) {
        final S3ClientSettings base = S3ClientSettings.load(
            () -> S3ClientSettings.load(Settings.builder().setSecureSettings(secureSettings).build(), configPath())
        );
        Optional<Signer> defaultSigner = defaultConfiguration.advancedOption(SdkAdvancedClientOption.SIGNER);
            S3Service s3Service = new S3Service(configPath());
            assertThat(credentials.sessionToken(), is("session_token"));
            configPath()
        }
        );
            configPath()
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(Settings.EMPTY, configPath());
            assertThat(credentials.secretAccessKey(), is("secret_key"));
        secureSettings.setString("s3.client.default.session_token", "session_token");
        assertThat(settings.get("default").legacyMd5ChecksumCalculation, is(false));
        secureSettings.setString("s3.client.default.role_arn", "role");
    }
        );
        assertTrue(otherSigner.isPresent());
public class S3ClientSettingsTests extends AbstractS3RepositoryTestCase {
        final Settings settings = Settings.builder()
            } else {
            assertThat(other.serviceClientConfiguration().region(), is(Region.of(region)));
        assertThat(settings.get("default").region, is(""));
            assertThat(credentials.accessKeyId(), is("access_key"));
import org.opensearch.common.settings.Settings;
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
            .put("s3.client.default.proxy.type", proxyType)
        for (ClientOverrideConfiguration configuration : configurations) {
    }
        assertEquals(expected.hashCode(), overridden.hashCode());
 * ownership. Elasticsearch licenses this file to you under
        final IllegalArgumentException failure = expectThrows(
        assertThat(credentials.accessKeyId(), is("access_key"));
        final IllegalArgumentException e = expectThrows(
    }
        assertThat(settings.keySet(), contains("default"));
            Settings.builder().put("s3.client.other.region", region).build(),
    public void testPathStyleAccessCanBeSet() {
        );
        final S3ClientSettings defaultSettings = settings.get("default");
    }
        }
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        assertThat(defaultSettings.legacyMd5ChecksumCalculation, is(false));
        AwsCredentials credentials = defaultSettings.credentials;
        secureSettings.setString("s3.client.default.session_token", "aws_key");
        Optional<Signer> otherSigner = configuration.advancedOption(SdkAdvancedClientOption.SIGNER);
            .put("s3.client.default.proxy.type", randomFrom("socks", "http", "https"))
        final S3ClientSettings settings = S3ClientSettings.load(Settings.EMPTY, configPath()).get("default");
    }
        assertThat(defaultSettings.maxConnections, is(500));
        }
        assertThat(defaultSettings.readTimeoutMillis, is(50 * 1000));
        );
        final S3ClientSettings baseSettings = S3ClientSettings.load(
        assertThat(credentials.getRoleArn(), is("role"));
    }
            IllegalArgumentException.class,
            () -> S3Service.buildOverrideConfiguration(settings.get("default"), null)
import software.amazon.awssdk.core.client.config.SdkAdvancedClientOption;
        assertThat(settings.get("other").disableChunkedEncoding, is(true));
        );
        e = expectThrows(SettingsException.class, () -> S3ClientSettings.load(usernamePasswordSettings, configPath()));
            Settings.builder().put("s3.client.other.api_call_timeout", "1m").build(),
            .build();
        SettingsException e = expectThrows(SettingsException.class, () -> S3ClientSettings.load(hostPortSettings, configPath()));
        assertThat(settings.keySet(), contains("default", "another_client"));
        secureSettings.setString("s3.client.default.proxy.username", userName);
            Settings.builder().put("s3.client.default.api_call_timeout", "30s").build(),
        final S3ClientSettings defaultSettings = settings.get("default");
import java.util.List;
 * specific language governing permissions and limitations
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
            configPath()
 *
        final MockSecureSettings secureSettings = new MockSecureSettings();
        S3Service.setDefaultAwsProfilePath();
            configPath()
        assertEquals(userName, s3ClientSettings.proxySettings.getUsername());
        assertThat(e.getMessage(), is("Missing access key and secret key for s3 client [default]"));
 * compatible open source license.
        assertApiCallTimeout(S3ClientSettings.load(Settings.EMPTY, configPath()).get("default"), 0);
        secureSettings.setString("s3.client.default.role_session_name", "session");
        assertThat(e.getMessage(), is("Missing access key for s3 client [default]"));
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
        assertThat(credentials.getRoleSessionName(), startsWith("s3-sdk-java-"));
    }
            .build();
        ClientOverrideConfiguration configuration = AccessController.doPrivileged(
            Settings.builder().put("s3.client.default.request_timeout", "2m").build(),
        );
            .build();
        assertThat(defaultSettings.connectionTTLMillis, is(5 * 1000));
            configPath()
        );
            configPath()
        final S3ClientSettings expected = S3ClientSettings.load(
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        final MockSecureSettings secureSettings = new MockSecureSettings();
        );
            .put("s3.client.default.proxy.port", 8080)
        assertEquals(password, s3ClientSettings.proxySettings.getPassword());
        // Default timeout (5 minutes)
            configPath()
        assertApiCallTimeout(base, 180_000L);
 * KIND, either express or implied.  See the License for the
            Settings.builder().setSecureSettings(secureSettings).build(),
        final String userName = randomAlphaOfLength(10);
}
        assertTrue(customConfig.apiCallAttemptTimeout().isPresent());
        S3Service.setDefaultAwsProfilePath();
    }
    }
        assertEquals(new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port), s3ClientSettings.proxySettings.getAddress());
            .build();
            Settings.builder().put("s3.client.other.signer_override", signerOverride).build(),
        final var legacyMd5ChecksumCalculation = randomBoolean();
        assertEquals(ProxySettings.ProxyType.valueOf(proxyType.toUpperCase(Locale.ROOT)), s3ClientSettings.proxySettings.getType());
        ).get("default");
        final String signerOverride = randomFrom(AwsRequestSigner.values()).getName();
        assertThat(credentials.secretAccessKey(), is("secret_key"));
    public void testApiCallTimeoutRejectsNegativeValues() {
        assertThat(settings.get("other").pathStyleAccess, is(true));
 * Licensed to Elasticsearch under one or more contributor
            assertThat(refinedSettings.pathStyleAccess, is(true));
        final S3ClientSettings overridden = base.refine(Settings.builder().put("api_call_timeout", "30s").build());
        assertEquals(expectedMillis, settings.apiCallTimeoutMillis);
            .setSecureSettings(secureSettings)
    public void testRejectionOfLoneSessionToken() {
        assertThat(defaultSettings.protocol, is(Protocol.HTTPS));
        );
    }
            .put("s3.client.default.proxy.type", randomFrom("socks", "http"))
        assertThat(credentials.getRoleSessionName(), is("session"));
            .put("s3.client.default.proxy.host", "127.0.0.1")
        secureSettings.setString("s3.client.default.secret_key", "secret_key");
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
            Settings.builder().put("s3.client.default.api_call_timeout", "3m").put("s3.client.default.request_timeout", "2m").build(),
            configPath()
            assertEquals(settings.requestTimeoutMillis, configuration.apiCallAttemptTimeout().orElseThrow().toMillis());
        ) {
            AwsSessionCredentials credentials = (AwsSessionCredentials) refinedSettings.credentials;
        );
            final S3ClientSettings refinedSettings = baseSettings.refine(Settings.builder().put("path_style_access", true).build());
    }
            .put("s3.client.default.proxy.port", 8080)
        );
        final IllegalArgumentException e = expectThrows(
    }
import java.util.Optional;
            configPath()
    public void testIrsaCredentialsTypeRoleArn() {
        final IllegalArgumentException e = expectThrows(
        assertThat(settings.keySet(), contains("default"));
import software.amazon.awssdk.core.signer.Signer;
import org.opensearch.repositories.s3.utils.AwsRequestSigner;
        final Settings usernamePasswordSettings = Settings.builder().setSecureSettings(secureSettings).build();
        final Map<String, S3ClientSettings> defaultSettings = S3ClientSettings.load(Settings.EMPTY, configPath());
        assertApiCallTimeout(settings.get("default"), 0);
 */
        final S3ClientSettings defaultSettings = settings.get("default");
        secureSettings.setString("s3.client.default.role_arn", "role");
    public void testSocksDoesNotSupportForHttpProtocol() {
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        assertThat(credentials.getIdentityTokenFile(), is("config/file"));
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(settings.get("default").region, is(""));
    public void testCredentialsTypeWithAccessKeyAndSecretKeyAndSessionToken() {
            Settings.builder().put("s3.client.other.disable_chunked_encoding", true).build(),
        ClientOverrideConfiguration defaultConfiguration = AccessController.doPrivileged(
            configPath()
    }
 */
        secureSettings.setString("s3.client.default.access_key", "access_key");
        final List<ClientOverrideConfiguration> configurations = List.of(
        }
        assertThat(defaultSettings.credentials, nullValue());
    public void testThereIsADefaultClientByDefault() {
    }
 */
            configPath()
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final String proxyType = randomFrom("http", "https", "socks");
        secureSettings.setString("s3.client.default.secret_key", "secret_key");
            configPath()
        assertThat(settings.get("default").pathStyleAccess, is(false));
                assertEquals(expectedMillis, configuration.apiCallTimeout().orElseThrow().toMillis());
    public void testIrsaCredentialsTypeWithIdentityTokenFile() {
        assertEquals(expected, overridden);
 * The OpenSearch Contributors require contributions made to
        assertThat(customConfig.apiCallAttemptTimeout().get().toMillis(), is(120_000L));
        );
package org.opensearch.repositories.s3;
            AccessController.doPrivileged(() -> S3Service.buildOverrideConfiguration(settings, null)),
            Settings.builder().put("s3.client.other.legacy_md5_checksum_calculation", legacyMd5ChecksumCalculation).build(),
            configPath()
    }
        assertThat(credentials.getIdentityTokenFile(), is("config/file"));
    public void testProxyWrongHost() {
        assertThat(credentials.getRoleSessionName(), is("session"));
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        assertThat(defaultSettings.connectionAcquisitionTimeoutMillis, is(15 * 60 * 1000));
        );
        assertThat(credentials.getRoleArn(), is("role"));
            configPath()
 * GitHub history for details.
    }
        final SettingsException e = expectThrows(SettingsException.class, () -> S3ClientSettings.load(settings, configPath()));
            Settings.builder().setSecureSettings(secureSettings).build(),
    }
        assertApiCallTimeout(settings, 180_000L);
            IllegalArgumentException.class,
        );
        final S3ClientSettings defaultSettings = settings.get("default");
 * You may obtain a copy of the License at
        assertThat(credentials.sessionToken(), is("session_token"));
/*
    }
    public void testDefaultClientSettingsCanBeSet() {
            IllegalArgumentException.class,
        assertThat(credentials.getRoleArn(), is(nullValue()));
    }
        assertThat(credentials.accessKeyId(), is("access_key"));
        secureSettings.setString("s3.client.default.proxy.password", "bbbb");
        assertThat(credentials.getRoleArn(), is("role"));
    }
        secureSettings.setString("s3.client.default.access_key", "access_key");
 *
 * license agreements. See the NOTICE file distributed with
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        );
    }
            configPath()
            }
        );
    }
import software.amazon.awssdk.regions.Region;
import org.opensearch.secure_sm.AccessController;
    }
            Settings.builder().put("s3.client.default.max_retries", 10).build(),
            .put("s3.client.default.proxy.port", 8080)
import org.opensearch.common.settings.SettingsException;
        assertApiCallTimeout(overridden, 30_000L);
        assertThat(defaultSettings.proxySettings, is(ProxySettings.NO_PROXY_SETTINGS));
        assertTrue(defaultConfig.apiCallAttemptTimeout().isPresent());
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
            () -> S3ClientSettings.load(Settings.builder().setSecureSettings(secureSettings).build(), configPath())
        final S3ClientSettings defaultSettings = settings.get("default");
    }
            final S3ClientSettings refinedSettings = baseSettings.refine(Settings.EMPTY);
        expectThrows(IllegalArgumentException.class, () -> settings.refine(Settings.builder().put("api_call_timeout", "-1").build()));
 * Unless required by applicable law or agreed to in writing,
        );
import software.amazon.awssdk.services.s3.S3Client;
        assertThat(failure.getMessage(), org.hamcrest.Matchers.containsString("api_call_timeout"));
            assertThat(credentials.accessKeyId(), is("access_key"));
    private void assertApiCallTimeout(S3ClientSettings settings, long expectedMillis) {
        final S3ClientSettings defaultSettings = settings.get("default");
        assertSame(base, base.refine(Settings.EMPTY));
        secureSettings.setString("s3.client.default.secret_key", "secret_key");
        assertThat(defaultSettings.maxRetries, is(3));
        {
            () -> S3Service.buildOverrideConfiguration(customSettings.get("default"), null)
            assertSame(refinedSettings, baseSettings);
        assertThat(settings.get("default").disableChunkedEncoding, is(false));
        assertThat(credentials.getIdentityTokenFile(), is("/file"));
    public void testNondefaultClientCreatedBySettingItsSettings() {
        );
    }
        assertThat(anotherClientSettings.maxRetries, is(10));
            Settings.builder().setSecureSettings(secureSettings).build(),
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
        ClientOverrideConfiguration defaultConfig = AccessController.doPrivileged(
    public void testApiCallTimeoutForNamedClient() {
            configPath()
        assertThat(credentials.getRoleArn(), is("role"));
            configPath()
        final S3ClientSettings anotherClientSettings = settings.get("another_client");
        secureSettings.setString("s3.client.default.role_session_name", "session");
            Settings.builder().put("s3.client.another_client.max_retries", 10).build(),
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
    }
        assertThat(defaultSettings.maxSyncConnections, is(500));
    public void testProxyTypeNotSet() {
 * the Apache License, Version 2.0 (the "License"); you may
    public void testLegacyMd5ChecksumCalculationCanBeSet() {
        final Settings settings = Settings.builder()
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
        final SettingsException e = expectThrows(SettingsException.class, () -> S3ClientSettings.load(settings, configPath()));
        assertThat(defaultConfig.apiCallAttemptTimeout().get().toMillis(), is((long) defaultSettings.get("default").requestTimeoutMillis));
                assertTrue(configuration.apiCallTimeout().isEmpty());
        final S3ClientSettings s3ClientSettings = S3ClientSettings.load(settings, configPath()).get("default");
        assertEquals("S3 proxy type has been set but proxy host or port is not defined.", e.getMessage());
    public void testRejectionOfLoneAccessKey() {
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
            () -> S3Service.buildOverrideConfiguration(defaultSettings.get("default"), null)
        final String region = randomFrom(Region.regions().stream().map(Region::toString).toArray(String[]::new));
        assertThat(defaultSettings.apiCallTimeoutMillis, is(0));
import static org.hamcrest.Matchers.contains;
        ClientOverrideConfiguration customConfig = AccessController.doPrivileged(
        final String password = randomAlphaOfLength(10);
    public void testIrsaCredentialsTypeWithRoleArnAndRoleSessionName() {
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
