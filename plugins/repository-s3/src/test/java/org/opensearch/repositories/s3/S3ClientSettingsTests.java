    public void testLegacyMd5ChecksumCalculationCanBeSet() {
}
import org.opensearch.secure_sm.AccessController;
        assertSame(base, base.refine(Settings.EMPTY));
            Settings.builder().setSecureSettings(secureSettings).put("s3.client.default.identity_token_file", "file").build(),
        S3Service.setDefaultAwsProfilePath();  
 * The OpenSearch Contributors require contributions made to  
        final Settings settings = Settings.builder()
            .put("s3.client.default.proxy.host", randomFrom("127.0.0.10"))
    }
                assertTrue(configuration.apiCallTimeout().isEmpty());
        final Settings usernamePasswordSettings = Settings.builder().setSecureSettings(secureSettings).build();
            Settings.builder().put("s3.client.default.request_timeout", "2m").build(),
        final var legacyMd5ChecksumCalculation = randomBoolean();  
            assertThat(refinedSettings.endpoint, is(endpoint));
        final S3ClientSettings defaultSettings = settings.get("default");
        assertThat(settings.get("default").legacyMd5ChecksumCalculation, is(false));
    }
    public void testCredentialsTypeWithAccessKeyAndSecretKeyAndSessionToken() {
        assertApiCallTimeout(settings, 180_000L);  
        Optional<Signer> otherSigner = configuration.advancedOption(SdkAdvancedClientOption.SIGNER);  
        Optional<Signer> defaultSigner = defaultConfiguration.advancedOption(SdkAdvancedClientOption.SIGNER);  
        assertThat(defaultSettings.connectionTimeoutMillis, is(10 * 1000));
        assertEquals("S3 proxy type has been set but proxy host or port is not defined.", e.getMessage());
        // Custom timeout  
        }
    public void testProxyWrongHost() {  
            () -> S3ClientSettings.load(Settings.builder().setSecureSettings(secureSettings).build(), configPath())
        assertEquals("S3 proxy host is unknown.", e.getMessage());
            assertThat(credentials.secretAccessKey(), is("secret_key"));
        assertThat(settings.keySet(), contains("default"));
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
        secureSettings.setString("s3.client.default.proxy.password", "bbbb");  
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final Settings settings = Settings.builder()  
            configPath()
        );
            configPath()  
            Settings.builder().put("s3.client.default.api_call_timeout", "30s").build(),
        assertThat(credentials.getRoleSessionName(), is("session"));
 * ownership. Elasticsearch licenses this file to you under  
        final MockSecureSettings secureSettings = new MockSecureSettings();
            .build();
        assertThat(defaultSettings.maxConnections, is(500));  
 * the Apache License, Version 2.0 (the "License"); you may
            S3Client other = AccessController.doPrivileged(() -> s3Service.buildClient(settings.get("other")).client());
        e = expectThrows(SettingsException.class, () -> S3ClientSettings.load(usernamePasswordSettings, configPath()));  
    }
        final IllegalArgumentException failure = expectThrows(
 */  
    public void testIrsaCredentialsTypeWithRoleArnAndRoleSessionNameAndIdentityTokeFileAbsolute() {
        secureSettings.setString("s3.client.default.access_key", "access_key");
            configPath()  
        secureSettings.setString("s3.client.default.role_arn", "role");
    public void testIrsaCredentialsTypeWithRoleArnAndRoleSessionName() {  
        {  
        assertApiCallTimeout(settings.get("default"), 0);
            final S3ClientSettings refinedSettings = baseSettings.refine(Settings.builder().put("endpoint", endpoint).build());
        assertEquals(expected.hashCode(), overridden.hashCode());  
        final S3ClientSettings baseSettings = S3ClientSettings.load(
    public void testApiCallTimeoutForNamedClient() {  
        assertThat(defaultSettings.maxRetries, is(3));  
        assertThat(credentials.getIdentityTokenFile(), is("config/file"));  
        ).get("default");
    public void testProxyTypeNotSet() {
        assertThat(settings.get("default").region, is(""));  
            Settings.builder().setSecureSettings(secureSettings).build(),  
            () -> S3ClientSettings.load(Settings.builder().setSecureSettings(secureSettings).build(), configPath())
    public void testRejectionOfLoneAccessKey() {
        assertThat(credentials.secretAccessKey(), is("secret_key"));
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        assertApiCallTimeout(base.refine(Settings.builder().put("api_call_timeout", "0").build()), 0);
        final S3ClientSettings defaultSettings = settings.get("default");
        assertTrue(customConfig.apiCallAttemptTimeout().isPresent());
    public void testRegionCanBeSet() {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(e.getMessage(), is("Missing access key for s3 client [default]"));
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(  
        final S3ClientSettings expected = S3ClientSettings.load(
        assertThat(defaultSettings.readTimeoutMillis, is(50 * 1000));
            configPath()
            () -> S3ClientSettings.load(Settings.builder().put("s3.client.default.api_call_timeout", "-1").build(), configPath())
    public void testNondefaultClientCreatedBySettingItsSettings() {  
        assertThat(defaultSettings.proxySettings, is(ProxySettings.NO_PROXY_SETTINGS));  
        assertThat(settings.get("other").region, is(region));
        try (  
        assertThat(settings.get("default").disableChunkedEncoding, is(false));  
        final IllegalArgumentException e = expectThrows(
    }
        );
            assertThat(credentials.accessKeyId(), is("access_key"));
            Settings.builder().put("s3.client.default.identity_token_file", "file").build(),
        final String password = randomAlphaOfLength(10);
        assertEquals(password, s3ClientSettings.proxySettings.getPassword());  
    }  
            .put("s3.client.default.proxy.port", 8080)  
            if (expectedMillis == 0) {  
    }
        ClientOverrideConfiguration defaultConfig = AccessController.doPrivileged(  
            .put("s3.client.default.proxy.host", "127.0.0.1")  
            () -> S3Service.buildOverrideConfiguration(customSettings.get("default"), null)  
        );
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        assertThat(credentials.getRoleSessionName(), is("session"));
        ClientOverrideConfiguration customConfig = AccessController.doPrivileged(
                assertEquals(expectedMillis, configuration.apiCallTimeout().orElseThrow().toMillis());  
        final String userName = randomAlphaOfLength(10);
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(settings.get("other").legacyMd5ChecksumCalculation, is(legacyMd5ChecksumCalculation));  
            Settings.builder().setSecureSettings(secureSettings).put("s3.client.default.identity_token_file", "/file").build(),
        }  
        assertThat(defaultSettings.connectionAcquisitionTimeoutMillis, is(15 * 60 * 1000));
        final Map<String, S3ClientSettings> customSettings = S3ClientSettings.load(
        secureSettings.setString("s3.client.default.proxy.password", password);
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
            configPath()
        secureSettings.setString("s3.client.default.session_token", "session_token");
            () -> S3ClientSettings.load(Settings.builder().setSecureSettings(secureSettings).build(), configPath())  
        );  
 * GitHub history for details.
        // Default timeout (5 minutes)
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        final S3ClientSettings s3ClientSettings = S3ClientSettings.load(settings, configPath()).get("default");
            } else {
        );
import java.util.Optional;  
        secureSettings.setString("s3.client.default.role_arn", "role");
        final String proxyType = randomFrom("http", "https", "socks");  
            final String endpoint = "some.host";  
        assertThat(credentials.sessionToken(), is("session_token"));
            .put("s3.client.default.proxy.port", randomFrom(port))  
        );
        final String region = randomFrom(Region.regions().stream().map(Region::toString).toArray(String[]::new));
        S3Service.setDefaultAwsProfilePath();  
            .put("s3.client.default.proxy.port", 8080)
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
/*
        assertEquals(userName, s3ClientSettings.proxySettings.getUsername());
            Settings.builder().put("s3.client.other.region", region).build(),
        final Settings settings = Settings.builder()
            .put("s3.client.default.proxy.host", "thisisnotavalidhostorwehavebeensuperunlucky")  
        secureSettings.setString("s3.client.default.proxy.username", userName);  
            configPath()
        }
        final S3ClientSettings defaultSettings = settings.get("default");  
    }  
            S3Service s3Service = new S3Service(configPath());
        secureSettings.setString("s3.client.default.access_key", "access_key");  
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        ClientOverrideConfiguration configuration = AccessController.doPrivileged(  
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        secureSettings.setString("s3.client.default.access_key", "access_key");
            assertEquals(settings.requestTimeoutMillis, configuration.apiCallAttemptTimeout().orElseThrow().toMillis());
        }
        assertThat(defaultSettings.throttleRetries, is(true));
        assertEquals(expected, overridden);
            configPath()
        assertThat(credentials.getRoleArn(), is("role"));
import org.opensearch.common.settings.Settings;
import software.amazon.awssdk.core.signer.Signer;
    }
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(  
            .put("s3.client.default.proxy.port", 8080)
 */  
        expectThrows(SettingsException.class, () -> S3ClientSettings.load(settings, configPath()));
        assertThat(failure.getMessage(), org.hamcrest.Matchers.containsString("api_call_timeout"));  
            assertSame(refinedSettings, baseSettings);
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(  
            Settings.builder().put("s3.client.default.api_call_timeout", "3m").build(),
        assertThat(credentials.getRoleSessionName(), is("session"));
        );  
        assertThat(settings.keySet(), contains("default", "another_client"));
            AccessController.doPrivileged(() -> S3Service.buildOverrideConfiguration(settings, null)),
    public void testRejectionOfLoneSessionToken() {
        assertThat(defaultSettings.protocol, is(Protocol.HTTPS));
        );
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.SettingsException;
        assertEquals(ProxySettings.ProxyType.valueOf(proxyType.toUpperCase(Locale.ROOT)), s3ClientSettings.proxySettings.getType());  
        final S3ClientSettings defaultSettings = settings.get("default");
            configPath()
        assertThat(anotherClientSettings.maxRetries, is(10));
    public void testApiCallTimeoutRejectsNegativeValues() {
        secureSettings.setString("s3.client.default.session_token", "session_token");  
import java.util.Map;
        assertThat(settings.get("other").pathStyleAccess, is(true));
    }  
        final List<ClientOverrideConfiguration> configurations = List.of(
package org.opensearch.repositories.s3;
        );  
        assertEquals("S3 proxy port or host or username or password have been set but proxy type is not defined.", e.getMessage());
        );  
        assertThat(credentials.getRoleSessionName(), startsWith("s3-sdk-java-"));
 * license agreements. See the NOTICE file distributed with
            Settings.builder().put("s3.client.other.signer_override", signerOverride).build(),  
            assertThat(credentials.sessionToken(), is("session_token"));  
            .build();
    public void testSetProxySettings() throws Exception {
            Settings.builder().put("s3.client.default.max_retries", 10).build(),
 * under the License.  
        S3Service.setDefaultAwsProfilePath();
        AwsSessionCredentials credentials = (AwsSessionCredentials) defaultSettings.credentials;
            .put("s3.client.default.protocol", "http")
        final S3ClientSettings anotherClientSettings = settings.get("another_client");
        final S3ClientSettings defaultSettings = settings.get("default");
    public void testIrsaCredentialsTypeWithIdentityTokenFile() {
        secureSettings.setString("s3.client.default.secret_key", "secret_key");
        assertThat(credentials.accessKeyId(), is("access_key"));  
/*  
public class S3ClientSettingsTests extends AbstractS3RepositoryTestCase {  
            assertThat(refinedSettings.pathStyleAccess, is(true));
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        assertThat(defaultSettings.maxRetries, is(10));
        final int port = randomIntBetween(10, 1080);  
        );  
            assertThat(other.serviceClientConfiguration().region(), is(Region.of(region)));
import java.util.Locale;
        secureSettings.setString("s3.client.default.secret_key", "aws_key");
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(credentials.getRoleArn(), is(nullValue()));
        final S3ClientSettings defaultSettings = settings.get("default");  
            configPath()
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(  
            Settings.builder().setSecureSettings(secureSettings).build(),
import software.amazon.awssdk.regions.Region;  
        secureSettings.setString("s3.client.default.secret_key", "secret_key");
    }  
import org.opensearch.repositories.s3.utils.Protocol;
        final IllegalArgumentException e = expectThrows(  
        assertThat(e.getMessage(), is("Missing secret key for s3 client [default]"));  
            .put("s3.client.default.proxy.type", "socks")  
            configPath()  
import software.amazon.awssdk.services.s3.S3Client;
        );  
        final S3ClientSettings base = S3ClientSettings.load(
    public void testUseChunkedEncodingCanBeSet() {
        );  
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;  
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        final String signerOverride = randomFrom(AwsRequestSigner.values()).getName();
    }  
        for (ClientOverrideConfiguration configuration : configurations) {
        assertThat(defaultSettings.connectionTTLMillis, is(5 * 1000));
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
            Settings.builder().put("s3.client.other.path_style_access", true).build(),  
        assertThat(customConfig.apiCallAttemptTimeout().get().toMillis(), is(120_000L));  
            .put("s3.client.default.proxy.host", "127.0.0.1")  
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
    }  
        final SettingsException e = expectThrows(SettingsException.class, () -> S3ClientSettings.load(settings, configPath()));  
        assertEquals(expectedMillis, settings.apiCallTimeoutMillis);  
        ) {  
import static org.hamcrest.Matchers.sameInstance;
        assertThat(credentials.secretAccessKey(), is("secret_key"));
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final S3ClientSettings defaultSettings = settings.get("default");
            IllegalArgumentException.class,  
        final S3ClientSettings defaultSettings = settings.get("default");
    }
        assertThat(defaultSettings.maxSyncConnections, is(500));
        secureSettings.setString("s3.client.default.role_arn", "role");
    }
        final Settings hostPortSettings = Settings.builder()
 * specific language governing permissions and limitations
            Settings.builder().setSecureSettings(secureSettings).build(),
        final S3ClientSettings settings = S3ClientSettings.load(Settings.EMPTY, configPath()).get("default");
            IllegalArgumentException.class,  
        );
        secureSettings.setString("s3.client.default.access_key", "aws_key");
    }
    public void testApiCallTimeoutRepositoryOverrides() {  
            () -> S3Service.buildOverrideConfiguration(defaultSettings.get("default"), null)
    }  
        final SettingsException e = expectThrows(SettingsException.class, () -> S3ClientSettings.load(settings, configPath()));  
 * Unless required by applicable law or agreed to in writing,
            configPath()  
        );  
            configPath()  
            .put("s3.client.default.proxy.type", randomFrom("socks", "http", "https"))
import java.net.InetAddress;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;  
            .put("s3.client.default.proxy.type", proxyType)
        final S3ClientSettings defaultSettings = settings.get("default");
        assertThat(defaultSettings.credentials, nullValue());  
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        );
        }  
    public void testProxyHostNotSet() {
        assertThat(defaultSettings.requestTimeoutMillis, is(5 * 60 * 1000));
        final MockSecureSettings secureSettings = new MockSecureSettings();
            () -> S3Service.buildOverrideConfiguration(settings.get("other"), null)
        assertApiCallTimeout(settings.get("other"), 60_000L);  
    }
        assertThat(credentials.getIdentityTokenFile(), is("/file"));  
    public void testIrsaCredentialsTypeWithRoleArnAndRoleSessionNameAndIdentityTokeFileRelative() {
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(Settings.EMPTY, configPath());
        assertThat(settings.keySet(), contains("default"));  
    public void testSignerOverrideCanBeSet() {
    public void testCredentialsTypeWithAccessKeyAndSecretKey() {
        assertThat(settings.get("default").pathStyleAccess, is(false));  
    private void assertApiCallTimeout(S3ClientSettings settings, long expectedMillis) {
    public void testPathStyleAccessCanBeSet() {
    public void testSocksDoesNotSupportForHttpProtocol() {
        assertThat(otherSigner.get(), sameInstance(AwsRequestSigner.fromSignerName(signerOverride).getSigner()));
        secureSettings.setString("s3.client.default.role_arn", "role");
    public void testRefineWithRepoSettings() {
 */
    }  
        assertThat(defaultSettings.legacyMd5ChecksumCalculation, is(false));
    }  
            AwsSessionCredentials credentials = (AwsSessionCredentials) refinedSettings.credentials;  
    }
        assertThat(settings.get("other").signerOverride, is(signerOverride));
            configPath()
 *  
import java.net.InetSocketAddress;
            .build();
        secureSettings.setString("s3.client.default.proxy.username", "aaaa");
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(  
    }
        assertApiCallTimeout(S3ClientSettings.load(Settings.EMPTY, configPath()).get("default"), 0);
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        assertThat(credentials.getRoleArn(), is("role"));
    public void testApiCallTimeoutDisabledByDefault() {  
        assertThat(settings.get("default").region, is(""));
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        secureSettings.setString("s3.client.default.role_session_name", "session");  
        );
            final S3ClientSettings refinedSettings = baseSettings.refine(Settings.builder().put("path_style_access", true).build());
            assertThat(credentials.sessionToken(), is("session_token"));  
        );
 *
            configPath()
        assertThat(defaultSettings.maxRetries, is(3));
            configPath()  
        assertThat(defaultSettings.endpoint, is(emptyString()));
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        ).get("default");
            .build();
            }
        assertThat(defaultConfig.apiCallAttemptTimeout().get().toMillis(), is((long) defaultSettings.get("default").requestTimeoutMillis));
    public void testDefaultClientSettingsCanBeSet() {
    public void testThereIsADefaultClientByDefault() {
        assertThat(defaultSettings.apiCallTimeoutMillis, is(0));  
        );
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(  
import java.util.List;  
    }
        ).get("default");
            Settings.builder().put("s3.client.other.api_call_timeout", "1m").build(),
import software.amazon.awssdk.auth.credentials.AwsCredentials;
            configPath()
        assertThat(credentials.getIdentityTokenFile(), is("config/file"));  
 * You may obtain a copy of the License at  
        assertThat(credentials.getRoleSessionName(), startsWith("s3-sdk-java-"));  
        {  
            .put("s3.client.default.proxy.type", randomFrom("socks", "http"))
        final MockSecureSettings secureSettings = new MockSecureSettings();
            Settings.builder().put("s3.client.other.legacy_md5_checksum_calculation", legacyMd5ChecksumCalculation).build(),
    public void testRejectionOfLoneSecretKey() {  
        );
        AwsCredentials credentials = defaultSettings.credentials;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
        final Map<String, S3ClientSettings> defaultSettings = S3ClientSettings.load(Settings.EMPTY, configPath());
        secureSettings.setString("s3.client.default.role_session_name", "session");
    }
import static org.hamcrest.CoreMatchers.startsWith;
            Settings.builder().put("s3.client.other.disable_chunked_encoding", true).build(),  
        ).get("default");
            configPath()
            Settings.builder().put("s3.client.default.api_call_timeout", "3m").put("s3.client.default.request_timeout", "2m").build(),  
        assertEquals(new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port), s3ClientSettings.proxySettings.getAddress());
        secureSettings.setString("s3.client.default.role_session_name", "session");
        assertEquals("S3 proxy port or host or username or password have been set but proxy type is not defined.", e.getMessage());
            () -> S3Service.buildOverrideConfiguration(settings.get("default"), null)
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
        secureSettings.setString("s3.client.default.session_token", "aws_key");  
        SettingsException e = expectThrows(SettingsException.class, () -> S3ClientSettings.load(hostPortSettings, configPath()));
        assertTrue(defaultConfig.apiCallAttemptTimeout().isPresent());  
    }
        assertThat(credentials.getRoleArn(), is("role"));
    }  
            configPath()
        final IllegalArgumentException e = expectThrows(
    public void testRequestTimeoutAppliedToSyncClientOverrideConfiguration() {
        expectThrows(IllegalArgumentException.class, () -> settings.refine(Settings.builder().put("api_call_timeout", "-1").build()));
        final S3ClientSettings.IrsaCredentials credentials = defaultSettings.irsaCredentials;
            assertThat(credentials.accessKeyId(), is("access_key"));
        final Map<String, S3ClientSettings> settings = S3ClientSettings.load(  
        final MockSecureSettings secureSettings = new MockSecureSettings();  
import static org.hamcrest.Matchers.nullValue;  
            configPath()  
import org.opensearch.repositories.s3.utils.AwsRequestSigner;  
 * compatible open source license.
        );
    public void testApiCallTimeoutAppliedToBothClients() {
            Settings.builder().setSecureSettings(secureSettings).build(),
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        assertThat(settings.get("other").disableChunkedEncoding, is(true));
            AccessController.doPrivileged(() -> S3AsyncService.buildOverrideConfiguration(settings, null))  
            configPath()  
            IllegalArgumentException.class,
            .setSecureSettings(secureSettings)
        final S3ClientSettings defaultSettings = settings.get("default");
    }  
        final S3ClientSettings overridden = base.refine(Settings.builder().put("api_call_timeout", "30s").build());
    }
    }
        final S3ClientSettings settings = S3ClientSettings.load(
    }
 * not use this file except in compliance with the License.
        assertApiCallTimeout(base, 180_000L);  
        assertApiCallTimeout(overridden, 30_000L);
            .put("s3.client.default.proxy.port", 8080)
    }  
import org.opensearch.common.settings.MockSecureSettings;  
 * this file be licensed under the Apache-2.0 license or a
        );
import static org.hamcrest.Matchers.contains;  
        assertThat(credentials.accessKeyId(), is("access_key"));  
 *
        {
            Settings.builder().put("s3.client.another_client.max_retries", 10).build(),
 * this work for additional information regarding copyright
        );
        );
        assertThat(credentials.getRoleArn(), is("role"));
            Settings.builder().setSecureSettings(secureSettings).build(),
        assertThat(e.getMessage(), is("Missing access key and secret key for s3 client [default]"));
            AwsSessionCredentials credentials = (AwsSessionCredentials) refinedSettings.credentials;  
        final Settings settings = Settings.builder()
        assertTrue(otherSigner.isPresent());
            IllegalArgumentException.class,
import software.amazon.awssdk.core.client.config.SdkAdvancedClientOption;
        );
        assertNotEquals(base, overridden);  
        assertFalse(defaultSigner.isPresent());
            final S3ClientSettings refinedSettings = baseSettings.refine(Settings.EMPTY);
            assertThat(credentials.secretAccessKey(), is("secret_key"));
        secureSettings.setString("s3.client.default.secret_key", "secret_key");
        ClientOverrideConfiguration defaultConfiguration = AccessController.doPrivileged(  
    public void testIrsaCredentialsTypeRoleArn() {
/*  
