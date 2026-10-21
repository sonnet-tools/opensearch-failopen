            .put("gcs.client.default.proxy.port", 8080)
        final Tuple<ServiceAccountCredentials, byte[]> credentials = randomCredential(clientName);
 * the Apache License, Version 2.0 (the "License"); you may
/*
        final MockSecureSettings secureSettings,
        assertEquals("Google Cloud Storage proxy host is unknown.", e.getMessage());
        );
        assertNull(gcsWithHttpProxyWithoutUserPwd.getProxySettings().getUsername());
            assertNotNull(expectedClientSettings);
            expectedClients.put("default", clientSettings);
            endpoint = randomFrom(
            TruststoreSettings.NO_TRUSTSTORE_SETTINGS
            settings.put(CONNECT_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), connectTimeout.getStringRep());
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.APPLICATION_NAME_SETTING;
import java.util.Map;
            assertSettingDeprecationsAndWarnings(deprecationWarnings.toArray(new Setting<?>[0]));
 * Licensed to Elasticsearch under one or more contributor
        final GoogleCloudStorageClientSettings expectedClientSettings = randomClient.v1().values().iterator().next();
    }
            applicationName = randomAlphaOfLength(5);
    private static void assertGoogleCredential(ServiceAccountCredentials expected, ServiceAccountCredentials actual) {
        final Settings hostPortSettings = Settings.builder()
        assertNull(gcsWithHttpProxyWithoutUserPwd.getProxySettings().getPassword());
            final GoogleCloudStorageClientSettings actualClientSettings = actualClientsSettings.get(clientName);
        if (randomBoolean()) {
        assertEquals(Proxy.Type.SOCKS, gcsWithHttpProxyWithoutUserPwd.getProxySettings().getType());
    private Tuple<Map<String, GoogleCloudStorageClientSettings>, Settings> randomClients(
    private static GoogleCloudStorageClientSettings randomClient(
import org.opensearch.common.settings.Setting;
            assertEquals(expected.getScopes(), actual.getScopes());
 * under the License.
import java.net.URI;
    }
        assertNotNull(clientsSettings.get("default"));
            endpoint = ENDPOINT_SETTING.getDefault(Settings.EMPTY);
        );
            .build();
        );
    public void testProjectIdDefaultsToCredentials() throws Exception {
        );
            projectId,
    /** Generates a random GoogleCloudStorageClientSettings along with the Settings to build it **/
import org.opensearch.common.settings.SettingsException;
        );
        credentialBuilder.setClientEmail(clientName);
            expectedClients.put("default", getClientSettings(Settings.EMPTY, "default"));
import java.net.Proxy;
        final List<Setting<?>> deprecationWarnings = new ArrayList<>();
 */
            endpoint,
    public void testLoadCredential() throws Exception {
    private GoogleCloudStorageClientSettings proxyGoogleCloudStorageClientSettings(final ProxySettings proxySettings) throws Exception {
            applicationName,
            .put("gcs.client.default.proxy.type", randomFrom("socks", "http"))
                "http://www.opensearch.org",
            + encodedPrivateKey
            READ_TIMEOUT_SETTING.getDefault(Settings.EMPTY),
        final SettingsException e = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(settings));
        final ServiceAccountCredentials credential = credentials.v1();
        assertFalse(gcsWithHttpProxyWithoutUserPwd.getProxySettings().isAuthenticated());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else {
            assertNull(actual);
        } else {
        assertEquals(
 * this work for additional information regarding copyright
            readTimeout = randomTimeout();
import org.opensearch.common.settings.Settings;
        assertTrue(gcsWithHttpProxyWithUserPwd.getProxySettings().isAuthenticated());
        assertEquals(expectedClientsSettings.size(), actualClientsSettings.size());
        assertNull(gcsWithHttpProxyWithoutUserPwd.getProxySettings().getPassword());
        assertEquals(userName, gcsWithHttpProxyWithUserPwd.getProxySettings().getUsername());
    }
        }
            assertNotNull(actualClientSettings);
        credentialBuilder.setPrivateKeyId("private_key_id_" + clientName);
            randomClients.v2()
        final String userName = randomAlphaOfLength(10);
            READ_TIMEOUT_SETTING.getDefault(Settings.EMPTY),
            TruststoreSettings.NO_TRUSTSTORE_SETTINGS
            projectId = PROJECT_ID_SETTING.getDefault(Settings.EMPTY);
import java.net.InetAddress;
            APPLICATION_NAME_SETTING.getDefault(Settings.EMPTY),
        }
            final GoogleCloudStorageClientSettings clientSettings = randomClient(clientName, settings, secureSettings, deprecationWarnings);
            assertEquals(expected.getClientId(), actual.getClientId());
        final ServiceAccountCredentials credential = credentials.v1();
        assertFalse(gcsWithHttpProxyWithoutUserPwd.getProxySettings().isAuthenticated());
package org.opensearch.repositories.gcs;
            credential,
        }
import com.google.auth.oauth2.ServiceAccountCredentials;
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.CONNECT_TIMEOUT_SETTING;
/*
            + "\\n-----END PRIVATE KEY-----\\n\","
            assertEquals(expected.getProjectId(), actual.getProjectId());
        final KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        final String serviceAccount = "{\"type\":\"service_account\","
 * You may obtain a copy of the License at
        final Settings.Builder settings = Settings.builder();
            + "\","
        final Settings settings = Settings.builder()
    /** Generates a random GoogleCredential along with its corresponding Service Account file provided as a byte array **/
    }
    }
    public void testLoadWithEmptySettings() {
            new URI(""),
            settings.put(ENDPOINT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), endpoint);
        }
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(expected.getClientEmail(), actual.getClientEmail());
            final GoogleCloudStorageClientSettings clientSettings = randomClient("default", settings, secureSettings, deprecationWarnings);
    ) throws Exception {
            connectTimeout = randomTimeout();
        e = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(usernamePasswordSettings));
        return randomFrom(TimeValue.MINUS_ONE, TimeValue.ZERO, TimeValue.parseTimeValue(randomPositiveTimeValue(), "test"));
    /** Generates a given number of GoogleCloudStorageClientSettings along with the Settings to build them from **/
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.PROJECT_ID_SETTING;
        return Tuple.tuple(expectedClients, settings.setSecureSettings(secureSettings).build());
    private static Tuple<ServiceAccountCredentials, byte[]> randomCredential(final String clientName) throws Exception {
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, actualClientSettings.getProxySettings());
            .put("gcs.client.default.proxy.port", 8080)
            + "}";
        );
        credentialBuilder.setProjectId("project_id_" + clientName);
    private static TimeValue randomTimeout() {
        final List<Setting<?>> deprecationWarnings
            new ProxySettings(Proxy.Type.HTTP, InetAddress.getByName("127.0.0.10"), port, userName, password)
        );
        final String clientName = randomClient.v1().keySet().iterator().next();
import java.nio.charset.StandardCharsets;
        final GoogleCloudStorageClientSettings gcsWithHttpProxyWithUserPwd = proxyGoogleCloudStorageClientSettings(
            gcsWithHttpProxyWithoutUserPwd.getProxySettings().getAddress()
            deprecationWarnings.add(APPLICATION_NAME_SETTING.getConcreteSettingForNamespace(clientName));
            .put("gcs.client.default.proxy.port", 8080)
        final int nbClients,
        assertEquals("Google Cloud Storage proxy type has been set but proxy host or port is not defined.", e.getMessage());
                "https://www.googleapis.com/oauth/token"
            new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port),
            APPLICATION_NAME_SETTING.getDefault(Settings.EMPTY),
            new ProxySettings(Proxy.Type.DIRECT, null, 0, null, null),
        final String clientName,
    }
 * compatible open source license.
            connectTimeout,
            .put("gcs.client.default.proxy.host", "thisisnotavalidhostorwehavebeensuperunlucky")
 * license agreements. See the NOTICE file distributed with
        final String encodedPrivateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
 * GitHub history for details.
import java.util.List;
 * specific language governing permissions and limitations
        }
        if (expected != null) {
        );
            + clientName
        assertEquals(
        credentialBuilder.setScopes(Collections.singleton(StorageScopes.DEVSTORAGE_FULL_CONTROL));
                "https://www.googleapis.com",
        if (randomBoolean()) {
        );
        if (randomBoolean()) {
    }
        final Settings usernamePasswordSettings = Settings.builder().setSecureSettings(secureSettings).build();
    }
        }
    ) throws Exception {
        String applicationName;
import java.util.ArrayList;
                "http://localhost:8443",
        final ServiceAccountCredentials.Builder credentialBuilder = ServiceAccountCredentials.newBuilder();
    }
import java.security.KeyPairGenerator;
        String projectId;
            gcsWithHttpProxyWithoutUserPwd.getProxySettings().getAddress()
 * not use this file except in compliance with the License.
            new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port),
        assertEquals(
            );
        final GoogleCloudStorageClientSettings gcsWithHttpProxyWithUserPwd = proxyGoogleCloudStorageClientSettings(
            settings.put(PROJECT_ID_SETTING.getConcreteSettingForNamespace(clientName).getKey(), projectId);
            assertEquals(expectedClientSettings.getApplicationName(), actualClientSettings.getApplicationName());
            proxySettings,
        } else {
            new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port),
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.ENDPOINT_SETTING;
}
        final MockSecureSettings secureSettings = new MockSecureSettings();
import java.util.Locale;
        final Map<String, GoogleCloudStorageClientSettings> expectedClients = new HashMap<>();
            + clientName
public class GoogleCloudStorageClientSettingsTests extends OpenSearchTestCase {
            ENDPOINT_SETTING.getDefault(Settings.EMPTY),
            new URI(""),
            + "\"private_key_id\":\"private_key_id_"
            assertGoogleCredential(expectedClientSettings.getCredential(), actualClientSettings.getCredential());
        secureSettings.setFile(CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace(clientName).getKey(), credentials.v2());
        secureSettings.setString("gcs.client.default.proxy.username", "aaaa");
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.getClientSettings;
        final String password = randomAlphaOfLength(10);
        } else {
            CONNECT_TIMEOUT_SETTING.getDefault(Settings.EMPTY),
        return Tuple.tuple(credentialBuilder.build(), serviceAccount.getBytes(StandardCharsets.UTF_8));
            assertEquals(expected.getPrivateKey(), actual.getPrivateKey());
        assertEquals(password, gcsWithHttpProxyWithUserPwd.getProxySettings().getPassword());
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.loadCredential;
            new URI(""),
            CONNECT_TIMEOUT_SETTING.getDefault(Settings.EMPTY),
        assertEquals(userName, gcsWithHttpProxyWithUserPwd.getProxySettings().getUsername());
        final Settings settings = Settings.builder()
        }
    }
            + "\","
        assertEquals(
 * this file be licensed under the Apache-2.0 license or a
        if (randomBoolean()) {
        assertEquals(credential.getProjectId(), googleCloudStorageClientSettings.getProjectId());
        for (final String clientName : expectedClientsSettings.keySet()) {
            "Google Cloud Storage proxy port or host or username or password have been set but proxy type is not defined.",
            settings.put(APPLICATION_NAME_SETTING.getConcreteSettingForNamespace(clientName).getKey(), applicationName);
        final String userName = randomAlphaOfLength(10);
        final String clientName = randomAlphaOfLength(5);
    public void testLoad() throws Exception {
 */
        final int port = randomIntBetween(10, 1080);
        if (randomBoolean()) {
 * Modifications Copyright OpenSearch Contributors. See
        SettingsException e = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(hostPortSettings));
 * KIND, either express or implied.  See the License for the
        final Map<String, GoogleCloudStorageClientSettings> clientsSettings = GoogleCloudStorageClientSettings.load(Settings.EMPTY);
        assertNull(gcsWithHttpProxyWithoutUserPwd.getProxySettings().getUsername());
 */
    }
    }
            .build();
        final List<Setting<?>> deprecationWarnings = new ArrayList<>();
    }
 * The OpenSearch Contributors require contributions made to
        assertEquals(
            + "\"client_id\":\"id_"
            gcsWithHttpProxyWithUserPwd.getProxySettings().getAddress()
        final GoogleCloudStorageClientSettings gcsWithHttpProxyWithoutUserPwd = proxyGoogleCloudStorageClientSettings(
                "https://www.opensearch.org:443",
 *
            new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port),
        assertEquals(password, gcsWithHttpProxyWithUserPwd.getProxySettings().getPassword());
        return new GoogleCloudStorageClientSettings(
        } else {
        credentialBuilder.setClientId("id_" + clientName);
/*
            final GoogleCloudStorageClientSettings expectedClientSettings = expectedClientsSettings.get(clientName);
        assertEquals(Proxy.Type.SOCKS, gcsWithHttpProxyWithoutUserPwd.getProxySettings().getType());
        final String password = randomAlphaOfLength(10);
            readTimeout = READ_TIMEOUT_SETTING.getDefault(Settings.EMPTY);
import java.net.InetSocketAddress;
            final String clientName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
            assertEquals(expectedClientSettings.getHost(), actualClientSettings.getHost());
        String endpoint;
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.READ_TIMEOUT_SETTING;
            TruststoreSettings.NO_TRUSTSTORE_SETTINGS
 * software distributed under the License is distributed on an
            + "\""
            assertEquals(expected.getAccount(), actual.getAccount());
        final List<Setting<?>> deprecationWarnings
        secureSettings.setString("gcs.client.default.proxy.password", "bbbb");
            + "\"client_email\":\""
                "http://metadata.google.com:88/oauth",
import org.opensearch.common.settings.MockSecureSettings;
import org.opensearch.test.OpenSearchTestCase;
        } else {
import java.security.KeyPair;
            settings.put(READ_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), readTimeout.getStringRep());
            expectedClients.put(clientName, clientSettings);
    public void testProxyWrongHost() {
    public void testHttpProxySettings() throws Exception {
        );
        final Tuple<ServiceAccountCredentials, byte[]> credentials = randomCredential(clientName);
            e.getMessage()
            new ProxySettings(Proxy.Type.SOCKS, InetAddress.getByName("127.0.0.10"), port, null, null)
            new ProxySettings(Proxy.Type.SOCKS, InetAddress.getByName("127.0.0.10"), port, userName, password)
            + clientName
    public void testProxyHostNotSet() {
        final Tuple<Map<String, GoogleCloudStorageClientSettings>, Settings> randomClients = randomClients(nbClients, deprecationWarnings);
        return new GoogleCloudStorageClientSettings(
        if (deprecationWarnings.isEmpty() == false) {
        assertEquals(1, clientsSettings.size());
            .put("gcs.client.default.proxy.type", randomFrom("socks", "http"))
            projectId = randomAlphaOfLength(5);
            + "\"project_id\":\"project_id_"
        );
        if (randomBoolean()) {
import java.util.HashMap;
    }
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertEquals(Proxy.Type.HTTP, gcsWithHttpProxyWithoutUserPwd.getProxySettings().getType());
        for (int i = 0; i < nbClients; i++) {
 *
import java.util.Collections;
        final GoogleCloudStorageClientSettings gcsWithHttpProxyWithoutUserPwd = proxyGoogleCloudStorageClientSettings(
        );
            new ProxySettings(Proxy.Type.HTTP, InetAddress.getByName("127.0.0.10"), port, null, null)
 * ownership. Elasticsearch licenses this file to you under
    }
            .build();
        TimeValue connectTimeout;
 *
            connectTimeout = CONNECT_TIMEOUT_SETTING.getDefault(Settings.EMPTY);
import org.opensearch.common.unit.TimeValue;
        assertGoogleCredential(expectedClientSettings.getCredential(), loadCredential(randomClient.v2(), clientName));
            assertEquals(expected.getServiceAccountUser(), actual.getServiceAccountUser());
        final int nbClients = randomIntBetween(1, 5);
        final Map<String, GoogleCloudStorageClientSettings> actualClientsSettings = GoogleCloudStorageClientSettings.load(
        credentialBuilder.setPrivateKey(keyPair.getPrivate());
import org.opensearch.common.collect.Tuple;
            + "\","
        }
        final SettingsException e = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(settings));
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.CREDENTIALS_FILE_SETTING;
        );
            assertEquals(expected.getPrivateKeyId(), actual.getPrivateKeyId());
import com.google.api.services.storage.StorageScopes;
            .put("gcs.client.default.proxy.host", "127.0.0.1")
        final int port = randomIntBetween(10, 1080);
        assertEquals(Proxy.Type.HTTP, gcsWithHttpProxyWithoutUserPwd.getProxySettings().getType());
 * SPDX-License-Identifier: Apache-2.0
        TimeValue readTimeout;
        } else {
        final Map<String, GoogleCloudStorageClientSettings> expectedClientsSettings = randomClients.v1();
            readTimeout,
            "Google Cloud Storage proxy port or host or username or password have been set but proxy type is not defined.",
            applicationName = APPLICATION_NAME_SETTING.getDefault(Settings.EMPTY);
            credential,
            + "\"private_key\":\"-----BEGIN PRIVATE KEY-----\\n"
        }
        assertEquals(
            ENDPOINT_SETTING.getDefault(Settings.EMPTY),
            PROJECT_ID_SETTING.getDefault(Settings.EMPTY),
        );
            e.getMessage()
            assertEquals(expectedClientSettings.getConnectTimeout(), actualClientSettings.getConnectTimeout());
        final Tuple<Map<String, GoogleCloudStorageClientSettings>, Settings> randomClient = randomClients(1, deprecationWarnings);
    public void testSocksProxySettings() throws Exception {
            assertEquals(expectedClientSettings.getReadTimeout(), actualClientSettings.getReadTimeout());
            gcsWithHttpProxyWithUserPwd.getProxySettings().getAddress()
        final String clientName = randomAlphaOfLength(5);
    public void testProxyTypeNotSet() {
            new ProxySettings(Proxy.Type.DIRECT, null, 0, null, null),
        final Settings.Builder settings,
import java.util.Base64;
        assertTrue(gcsWithHttpProxyWithUserPwd.getProxySettings().isAuthenticated());
            PROJECT_ID_SETTING.getDefault(Settings.EMPTY),
            randomCredential(clientName).v1(),
            assertEquals(expectedClientSettings.getProjectId(), actualClientSettings.getProjectId());
            + clientName
        final GoogleCloudStorageClientSettings googleCloudStorageClientSettings = new GoogleCloudStorageClientSettings(
        }
