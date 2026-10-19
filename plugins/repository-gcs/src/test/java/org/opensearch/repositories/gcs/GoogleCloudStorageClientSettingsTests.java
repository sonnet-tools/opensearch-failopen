            new ProxySettings(Proxy.Type.DIRECT, null, 0, null, null),
            new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port),  
 * software distributed under the License is distributed on an
import org.opensearch.common.unit.TimeValue;
    private static Tuple<ServiceAccountCredentials, byte[]> randomCredential(final String clientName) throws Exception {  
        credentialBuilder.setPrivateKeyId("private_key_id_" + clientName);
        );
            );
        assertEquals(credential.getProjectId(), googleCloudStorageClientSettings.getProjectId());
            assertEquals(expectedClientSettings.getReadTimeout(), actualClientSettings.getReadTimeout());
import java.net.InetSocketAddress;
        }
    }  
        final List<Setting<?>> deprecationWarnings
        final int port = randomIntBetween(10, 1080);  
            new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port),
        return new GoogleCloudStorageClientSettings(
        for (final String clientName : expectedClientsSettings.keySet()) {
            gcsWithHttpProxyWithUserPwd.getProxySettings().getAddress()
        assertNull(gcsWithHttpProxyWithoutUserPwd.getProxySettings().getPassword());  
            connectTimeout = randomTimeout();
        final Settings hostPortSettings = Settings.builder()  
        final List<Setting<?>> deprecationWarnings = new ArrayList<>();
            .put("gcs.client.default.proxy.port", 8080)
        String projectId;
            assertSettingDeprecationsAndWarnings(deprecationWarnings.toArray(new Setting<?>[0]));
        assertNull(gcsWithHttpProxyWithoutUserPwd.getProxySettings().getPassword());
        final String password = randomAlphaOfLength(10);  
            CONNECT_TIMEOUT_SETTING.getDefault(Settings.EMPTY),
            .put("gcs.client.default.proxy.host", "thisisnotavalidhostorwehavebeensuperunlucky")
        assertEquals(  
import org.opensearch.common.settings.SettingsException;  
    ) throws Exception {
import java.util.Base64;  
import org.opensearch.common.settings.Settings;
            settings.put(CONNECT_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), connectTimeout.getStringRep());  
            proxySettings,  
import java.util.ArrayList;
        final List<Setting<?>> deprecationWarnings  
import java.util.Collections;
        credentialBuilder.setProjectId("project_id_" + clientName);
            assertEquals(expected.getPrivateKey(), actual.getPrivateKey());  
            + "\"client_id\":\"id_"
    public void testSocksProxySettings() throws Exception {  
        } else {  
import java.util.Locale;
            + "\\n-----END PRIVATE KEY-----\\n\","
/*  
        return Tuple.tuple(credentialBuilder.build(), serviceAccount.getBytes(StandardCharsets.UTF_8));  
        if (randomBoolean()) {  
        e = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(usernamePasswordSettings));
            assertEquals(expectedClientSettings.getApplicationName(), actualClientSettings.getApplicationName());  
            .put("gcs.client.default.proxy.type", randomFrom("socks", "http"))
                "http://localhost:8443",
        );
        final Tuple<ServiceAccountCredentials, byte[]> credentials = randomCredential(clientName);  
        assertEquals(Proxy.Type.HTTP, gcsWithHttpProxyWithoutUserPwd.getProxySettings().getType());
    private static TimeValue randomTimeout() {  
        return Tuple.tuple(expectedClients, settings.setSecureSettings(secureSettings).build());
            settings.put(APPLICATION_NAME_SETTING.getConcreteSettingForNamespace(clientName).getKey(), applicationName);
 *
 * compatible open source license.
import java.security.KeyPairGenerator;
    /** Generates a random GoogleCredential along with its corresponding Service Account file provided as a byte array **/
            PROJECT_ID_SETTING.getDefault(Settings.EMPTY),
    }
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.HashMap;
            applicationName = APPLICATION_NAME_SETTING.getDefault(Settings.EMPTY);
        final ServiceAccountCredentials credential = credentials.v1();
        );  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.ENDPOINT_SETTING;
        final GoogleCloudStorageClientSettings gcsWithHttpProxyWithUserPwd = proxyGoogleCloudStorageClientSettings(
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.CONNECT_TIMEOUT_SETTING;
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.getClientSettings;
                "https://www.googleapis.com",  
        final GoogleCloudStorageClientSettings expectedClientSettings = randomClient.v1().values().iterator().next();  
        }
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.loadCredential;
        assertEquals(1, clientsSettings.size());
            assertEquals(expected.getAccount(), actual.getAccount());  
        final int port = randomIntBetween(10, 1080);
            settings.put(READ_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), readTimeout.getStringRep());
            randomCredential(clientName).v1(),
    private GoogleCloudStorageClientSettings proxyGoogleCloudStorageClientSettings(final ProxySettings proxySettings) throws Exception {
import java.net.Proxy;  
        } else {
            APPLICATION_NAME_SETTING.getDefault(Settings.EMPTY),
            new ProxySettings(Proxy.Type.DIRECT, null, 0, null, null),  
        final Map<String, GoogleCloudStorageClientSettings> expectedClientsSettings = randomClients.v1();
            gcsWithHttpProxyWithoutUserPwd.getProxySettings().getAddress()
 *
        final Settings.Builder settings = Settings.builder();  
            randomClients.v2()
        final Settings.Builder settings,
            new URI(""),
    }  
            new ProxySettings(Proxy.Type.HTTP, InetAddress.getByName("127.0.0.10"), port, null, null)
        assertEquals(
        final String encodedPrivateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());  
        final GoogleCloudStorageClientSettings gcsWithHttpProxyWithoutUserPwd = proxyGoogleCloudStorageClientSettings(  
        } else {
        assertEquals(Proxy.Type.HTTP, gcsWithHttpProxyWithoutUserPwd.getProxySettings().getType());
        credentialBuilder.setClientId("id_" + clientName);  
            new ProxySettings(Proxy.Type.HTTP, InetAddress.getByName("127.0.0.10"), port, userName, password)
    ) throws Exception {  
    public void testLoadCredential() throws Exception {  
    }
 * The OpenSearch Contributors require contributions made to  
            assertEquals(expected.getServiceAccountUser(), actual.getServiceAccountUser());  
        final GoogleCloudStorageClientSettings googleCloudStorageClientSettings = new GoogleCloudStorageClientSettings(  
            + "\"client_email\":\""
        } else {
        }
        assertEquals(
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(password, gcsWithHttpProxyWithUserPwd.getProxySettings().getPassword());
        final Map<String, GoogleCloudStorageClientSettings> actualClientsSettings = GoogleCloudStorageClientSettings.load(  
 * under the License.  
        TimeValue connectTimeout;  
            assertEquals(expected.getClientEmail(), actual.getClientEmail());
        secureSettings.setFile(CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace(clientName).getKey(), credentials.v2());
            new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port),
        );  
        assertGoogleCredential(expectedClientSettings.getCredential(), loadCredential(randomClient.v2(), clientName));
        credentialBuilder.setScopes(Collections.singleton(StorageScopes.DEVSTORAGE_FULL_CONTROL));
import java.util.Map;
            .build();  
            new ProxySettings(Proxy.Type.SOCKS, InetAddress.getByName("127.0.0.10"), port, null, null)
            projectId,
    }
        return randomFrom(TimeValue.MINUS_ONE, TimeValue.ZERO, TimeValue.parseTimeValue(randomPositiveTimeValue(), "test"));
            "Google Cloud Storage proxy port or host or username or password have been set but proxy type is not defined.",
        final String clientName = randomAlphaOfLength(5);  
            new InetSocketAddress(InetAddress.getByName("127.0.0.10"), port),
public class GoogleCloudStorageClientSettingsTests extends OpenSearchTestCase {
        assertEquals(userName, gcsWithHttpProxyWithUserPwd.getProxySettings().getUsername());  
 * Licensed to Elasticsearch under one or more contributor  
        if (deprecationWarnings.isEmpty() == false) {
            new URI(""),
            assertEquals(expectedClientSettings.getConnectTimeout(), actualClientSettings.getConnectTimeout());
            + "}";
    public void testHttpProxySettings() throws Exception {
            assertEquals(expected.getPrivateKeyId(), actual.getPrivateKeyId());
        );
            new URI(""),
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.APPLICATION_NAME_SETTING;
        }  
            connectTimeout = CONNECT_TIMEOUT_SETTING.getDefault(Settings.EMPTY);
        final MockSecureSettings secureSettings = new MockSecureSettings();
    }
import org.opensearch.test.OpenSearchTestCase;
            gcsWithHttpProxyWithoutUserPwd.getProxySettings().getAddress()
            + "\""
            .put("gcs.client.default.proxy.host", "127.0.0.1")
import com.google.api.services.storage.StorageScopes;  
            gcsWithHttpProxyWithUserPwd.getProxySettings().getAddress()  
        final String clientName = randomClient.v1().keySet().iterator().next();
        }
        }
            assertNull(actual);  
            expectedClients.put("default", getClientSettings(Settings.EMPTY, "default"));
            assertEquals(expected.getScopes(), actual.getScopes());
        );  
            READ_TIMEOUT_SETTING.getDefault(Settings.EMPTY),  
        final int nbClients = randomIntBetween(1, 5);
 * the Apache License, Version 2.0 (the "License"); you may
            endpoint,  
        }
        );  
            + "\","
                "http://metadata.google.com:88/oauth",
        final String serviceAccount = "{\"type\":\"service_account\","
 * specific language governing permissions and limitations
    }
            + "\","
            assertGoogleCredential(expectedClientSettings.getCredential(), actualClientSettings.getCredential());
            credential,
        final SettingsException e = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(settings));
            final GoogleCloudStorageClientSettings clientSettings = randomClient("default", settings, secureSettings, deprecationWarnings);
        if (randomBoolean()) {  
        final Tuple<ServiceAccountCredentials, byte[]> credentials = randomCredential(clientName);
 */
                "https://www.googleapis.com/oauth/token"  
        assertFalse(gcsWithHttpProxyWithoutUserPwd.getProxySettings().isAuthenticated());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Map<String, GoogleCloudStorageClientSettings> expectedClients = new HashMap<>();
        if (randomBoolean()) {
            assertEquals(expected.getProjectId(), actual.getProjectId());
            applicationName,
        return new GoogleCloudStorageClientSettings(
            expectedClients.put(clientName, clientSettings);  
        }
        final String clientName = randomAlphaOfLength(5);  
        }
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(expected.getClientId(), actual.getClientId());
        assertEquals(  
 *  
        SettingsException e = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(hostPortSettings));
import java.nio.charset.StandardCharsets;
            + clientName  
        );
    public void testLoad() throws Exception {  
    }  
    /** Generates a given number of GoogleCloudStorageClientSettings along with the Settings to build them from **/
    public void testLoadWithEmptySettings() {  
 */  
        } else {  
    }
        for (int i = 0; i < nbClients; i++) {  
        final String clientName,  
            .put("gcs.client.default.proxy.type", randomFrom("socks", "http"))  
            final GoogleCloudStorageClientSettings actualClientSettings = actualClientsSettings.get(clientName);  
            TruststoreSettings.NO_TRUSTSTORE_SETTINGS  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.PROJECT_ID_SETTING;
        final String password = randomAlphaOfLength(10);
            final String clientName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
            expectedClients.put("default", clientSettings);
        assertEquals(Proxy.Type.SOCKS, gcsWithHttpProxyWithoutUserPwd.getProxySettings().getType());
            PROJECT_ID_SETTING.getDefault(Settings.EMPTY),  
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * KIND, either express or implied.  See the License for the
        assertNull(gcsWithHttpProxyWithoutUserPwd.getProxySettings().getUsername());  
    }
        final ServiceAccountCredentials credential = credentials.v1();
import com.google.auth.oauth2.ServiceAccountCredentials;
                "https://www.opensearch.org:443",
            readTimeout,  
            readTimeout = READ_TIMEOUT_SETTING.getDefault(Settings.EMPTY);
/*
            + "\"project_id\":\"project_id_"
            + "\"private_key\":\"-----BEGIN PRIVATE KEY-----\\n"
            connectTimeout,
        );
        assertTrue(gcsWithHttpProxyWithUserPwd.getProxySettings().isAuthenticated());
 * license agreements. See the NOTICE file distributed with
        final GoogleCloudStorageClientSettings gcsWithHttpProxyWithUserPwd = proxyGoogleCloudStorageClientSettings(
        final Settings settings = Settings.builder()  
        );
            assertNotNull(expectedClientSettings);  
    }  
 * SPDX-License-Identifier: Apache-2.0
            assertNotNull(actualClientSettings);
            .put("gcs.client.default.proxy.port", 8080)
    }  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.READ_TIMEOUT_SETTING;  
        );  
 * You may obtain a copy of the License at  
        final int nbClients,
    private static GoogleCloudStorageClientSettings randomClient(
            new ProxySettings(Proxy.Type.SOCKS, InetAddress.getByName("127.0.0.10"), port, userName, password)  
            e.getMessage()
    /** Generates a random GoogleCloudStorageClientSettings along with the Settings to build it **/
        assertEquals(password, gcsWithHttpProxyWithUserPwd.getProxySettings().getPassword());  
        final Tuple<Map<String, GoogleCloudStorageClientSettings>, Settings> randomClient = randomClients(1, deprecationWarnings);
 */
        final KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
            TruststoreSettings.NO_TRUSTSTORE_SETTINGS
        assertEquals(  
        assertEquals(expectedClientsSettings.size(), actualClientsSettings.size());  
            .build();  
            endpoint = ENDPOINT_SETTING.getDefault(Settings.EMPTY);
            assertEquals(expectedClientSettings.getHost(), actualClientSettings.getHost());
    public void testProxyWrongHost() {
            deprecationWarnings.add(APPLICATION_NAME_SETTING.getConcreteSettingForNamespace(clientName));
            e.getMessage()
    public void testProxyTypeNotSet() {
        TimeValue readTimeout;
            + clientName  
            + clientName  
            projectId = PROJECT_ID_SETTING.getDefault(Settings.EMPTY);  
            READ_TIMEOUT_SETTING.getDefault(Settings.EMPTY),
        if (randomBoolean()) {
            + "\","
        );
    public void testProjectIdDefaultsToCredentials() throws Exception {
        final Settings usernamePasswordSettings = Settings.builder().setSecureSettings(secureSettings).build();
        if (expected != null) {
        assertFalse(gcsWithHttpProxyWithoutUserPwd.getProxySettings().isAuthenticated());
            + encodedPrivateKey  
        String applicationName;
        assertNotNull(clientsSettings.get("default"));  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.CREDENTIALS_FILE_SETTING;  
        } else {  
        assertEquals("Google Cloud Storage proxy host is unknown.", e.getMessage());
 * Unless required by applicable law or agreed to in writing,
        assertEquals(Proxy.Type.SOCKS, gcsWithHttpProxyWithoutUserPwd.getProxySettings().getType());  
        String endpoint;
            settings.put(PROJECT_ID_SETTING.getConcreteSettingForNamespace(clientName).getKey(), projectId);
        final String userName = randomAlphaOfLength(10);
        if (randomBoolean()) {
    private static void assertGoogleCredential(ServiceAccountCredentials expected, ServiceAccountCredentials actual) {
    }
            CONNECT_TIMEOUT_SETTING.getDefault(Settings.EMPTY),
            ENDPOINT_SETTING.getDefault(Settings.EMPTY),
        final GoogleCloudStorageClientSettings gcsWithHttpProxyWithoutUserPwd = proxyGoogleCloudStorageClientSettings(
    public void testProxyHostNotSet() {
            endpoint = randomFrom(  
            projectId = randomAlphaOfLength(5);  
}  
            .put("gcs.client.default.proxy.port", 8080)
            readTimeout = randomTimeout();
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final Map<String, GoogleCloudStorageClientSettings> clientsSettings = GoogleCloudStorageClientSettings.load(Settings.EMPTY);
        assertEquals(userName, gcsWithHttpProxyWithUserPwd.getProxySettings().getUsername());
                "http://www.opensearch.org",
import java.util.List;  
import java.security.KeyPair;  
        final SettingsException e = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(settings));
        assertTrue(gcsWithHttpProxyWithUserPwd.getProxySettings().isAuthenticated());
        }  
package org.opensearch.repositories.gcs;
            TruststoreSettings.NO_TRUSTSTORE_SETTINGS
        assertEquals(
            settings.put(ENDPOINT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), endpoint);
        final Tuple<Map<String, GoogleCloudStorageClientSettings>, Settings> randomClients = randomClients(nbClients, deprecationWarnings);  
            .build();  
        if (randomBoolean()) {
        final ServiceAccountCredentials.Builder credentialBuilder = ServiceAccountCredentials.newBuilder();
            "Google Cloud Storage proxy port or host or username or password have been set but proxy type is not defined.",  
            final GoogleCloudStorageClientSettings clientSettings = randomClient(clientName, settings, secureSettings, deprecationWarnings);
        final MockSecureSettings secureSettings,
        } else {  
 * this work for additional information regarding copyright
            + "\"private_key_id\":\"private_key_id_"
        final List<Setting<?>> deprecationWarnings = new ArrayList<>();
 * not use this file except in compliance with the License.
        credentialBuilder.setClientEmail(clientName);
import java.net.InetAddress;
            credential,
        credentialBuilder.setPrivateKey(keyPair.getPrivate());  
import org.opensearch.common.settings.Setting;
            APPLICATION_NAME_SETTING.getDefault(Settings.EMPTY),  
        secureSettings.setString("gcs.client.default.proxy.username", "aaaa");  
            + clientName  
/*
        assertEquals("Google Cloud Storage proxy type has been set but proxy host or port is not defined.", e.getMessage());
    private Tuple<Map<String, GoogleCloudStorageClientSettings>, Settings> randomClients(  
            assertEquals(expectedClientSettings.getProjectId(), actualClientSettings.getProjectId());  
        final Settings settings = Settings.builder()
        );
import org.opensearch.common.collect.Tuple;
import org.opensearch.common.settings.MockSecureSettings;  
        );
            ENDPOINT_SETTING.getDefault(Settings.EMPTY),  
import java.net.URI;
            applicationName = randomAlphaOfLength(5);  
        assertNull(gcsWithHttpProxyWithoutUserPwd.getProxySettings().getUsername());
    }  
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, actualClientSettings.getProxySettings());
        secureSettings.setString("gcs.client.default.proxy.password", "bbbb");
            final GoogleCloudStorageClientSettings expectedClientSettings = expectedClientsSettings.get(clientName);
        final String userName = randomAlphaOfLength(10);
