            new ProxySettings(Proxy.Type.DIRECT, null, 0, null, null),
    /**
     * no Environment Variables provided or Google Compute Engine is not running
            // new client 1 is changed
    public void testToTimeout() {
        final String encodedKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
    final TimeValue readTimeValue = TimeValue.timeValueNanos(randomIntBetween(0, 2000000));
            final IllegalArgumentException e2 = expectThrows(
            );
                "gcs1",
import java.security.KeyPairGenerator;
 * software distributed under the License is distributed on an
        Exception exception = assertThrows(IOException.class, GoogleCredentials::getApplicationDefault);
        GoogleCloudStorageClientSettings settings = getGCSClientSettingsWithoutCredentials();
 * the Apache License, Version 2.0 (the "License"); you may
     * @param clientNames the names of the GCS clients to configure
            MatcherAssert.assertThat(e1.getMessage(), containsString("Unknown client name [gcs3]."));
        secureSettings1.setFile("gcs.client.gcs1.credentials_file", serviceAccountFileContent("project_gcs11"));
            null,
        Mockito.when(mockDefaultCredentials.get()).thenReturn(mockGoogleCredentials);
            final Storage client23 = storageService.client("gcs3", "repo3", statsCollector);
        final var clientName = "gcs1";
            ((HttpTransportOptions) storage.getOptions().getTransportOptions()).getConnectTimeout(),
        final Settings settings = newSettingsBuilder(new MockSecureSettings(), clientName).put(
        final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        MatcherAssert.assertThat(storage.getOptions().getCredentials(), Matchers.instanceOf(Credentials.class));
import org.opensearch.test.OpenSearchTestCase;
    public void testClientInitializer() throws Exception {
        MatcherAssert.assertThat(storage.getOptions().getTransportOptions(), Matchers.instanceOf(HttpTransportOptions.class));
import java.net.URISyntaxException;
            applicationName,
        final GoogleCloudStorageService service = new GoogleCloudStorageService(mockDefaultCredentials);
        final MockSecureSettings secureSettings1 = new MockSecureSettings();
import com.google.cloud.http.HttpTransportOptions;
 *
            .field("private_key_id", UUID.randomUUID().toString())
        assertNull(credentials);
    public void testDefaultCredentialsThrowsExceptionWithoutGCStorageService() {
            )
import org.hamcrest.MatcherAssert;
            .build();
     * @throws URISyntaxException
            assertNotSame(repo1Client, repo2Client);
import com.google.auth.oauth2.GoogleCredentials;
    }
        return new GoogleCloudStorageClientSettings(
            connectTimeValue,
            final IllegalArgumentException e1 = expectThrows(
        + randomIntBetween(1, 65535);
        final String clientName = randomAlphaOfLength(randomIntBetween(1, 10)).toLowerCase(Locale.ROOT);
import java.util.UUID;
        assertNotNull(storageOptions);
        secureSettings2.setFile("gcs.client.gcs1.credentials_file", serviceAccountFileContent("project_gcs21"));
            assertSame(repo1Client, repo1ClientSecondInstance);
            final GoogleCloudStorageService storageService = plugin.storageService;
        assertEquals(-1, GoogleCloudStorageService.toTimeout(null).intValue());
 * ownership. Elasticsearch licenses this file to you under
    }
            );
     */
    /**
            final Storage client12 = storageService.client("gcs2", "repo2", statsCollector);
        MatcherAssert.assertThat(exception.getMessage(), containsString("Your default credentials were not found"));
            projectIdName,
                new GoogleCloudStorageOperationsStats("bucket")
            .field("private_key", "-----BEGIN PRIVATE KEY-----\n" + encodedKey + "\n-----END PRIVATE KEY-----\n")
            // update client settings
            .setSecureSettings(secureSettings)
    public void testApplicationDefaultCredentialsWhenNoSettingProvided() throws Exception {
        secureSettings.setString("gcs.client.gcs1.truststore.password", "notasecret");
        + ":"
        assertSettingDeprecationsAndWarnings(
        + randomFrom("www.opensearch.org", "www.googleapis.com", "localhost/api", "google.com/oauth")
     */
 */
        secureSettings2.setFile("gcs.client.gcs3.credentials_file", serviceAccountFileContent("project_gcs23"));
 * this work for additional information regarding copyright
        assertNotNull(truststoreSettings);
 * You may obtain a copy of the License at
    final String endpoint = randomFrom("http://", "https://")
        final var truststorePath = getDataPath("/google.p12");
/*
        final var truststoreSettings = clientSettings.getTruststoreSettings();
import org.opensearch.core.xcontent.XContentBuilder;
            final Storage repo1ClientSecondInstance = storageService.client(
            GoogleCloudStorageClientSettings.CONNECT_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
 * The OpenSearch Contributors require contributions made to
    public void testCustomTruststoreConfiguration() throws Exception {
        assertNotNull(storageOptions);
    final String applicationName = randomAlphaOfLength(randomIntBetween(1, 10)).toLowerCase(Locale.ROOT);
    public void testApplicationDefaultCredential() throws Exception {
            () -> service.client("another_client", "repo", statsCollector)
        StorageOptions storageOptions = service.createStorageOptions(settings, mockHttpTransportOptions);
        // Verify that a client can be created with the custom truststore
        final var service = new GoogleCloudStorageService();
    /**
        HttpTransportOptions mockHttpTransportOptions = Mockito.mock(HttpTransportOptions.class);
        final XContentBuilder serviceAccountBuilder = jsonBuilder().startObject()
    }
        MatcherAssert.assertThat(e.getMessage(), Matchers.startsWith("Unknown client name"));
        assertNull(storageOptions.getCredentials());
        assertTrue(truststoreSettings.isConfigured());
    final TimeValue connectTimeValue = TimeValue.timeValueNanos(randomIntBetween(0, 2000000));
import java.io.IOException;
        MatcherAssert.assertThat(storage.getOptions().getProjectId(), Matchers.is(projectIdName));
 * Unless required by applicable law or agreed to in writing,
    }
import com.google.cloud.storage.Storage;
            connectTimeValue.getStringRep()
                () -> storageService.client("gcs3", "repo3", statsCollector)
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.common.bytes.BytesReference;
        Mockito.when(mockDefaultCredentials.get()).thenReturn(mockGoogleCredentials);
        keyPairGenerator.initialize(2048);
                () -> storageService.client("gcs2", "repo2", statsCollector)
package org.opensearch.repositories.gcs;
}
 *
     * @throws Exception
     */
     * The application default credential throws exception when there are
    final String projectIdName = randomAlphaOfLength(randomIntBetween(1, 10)).toLowerCase(Locale.ROOT);
    /**
            .build();
    /**
     * @return GoogleCloudStorageClientSettings
            // new client2 is gone
        HttpTransportOptions mockHttpTransportOptions = Mockito.mock(HttpTransportOptions.class);
public class GoogleCloudStorageServiceTests extends OpenSearchTestCase {
    }
    }
 *
        MatcherAssert.assertThat(
/*
            // client 3 emerged
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings1)) {
        final var secureSettings = new MockSecureSettings();
            .field("project_id", projectId)
        );
            IllegalArgumentException.class,
        final var statsCollector = new GoogleCloudStorageOperationsStats("bucket");
                GoogleCloudStorageClientSettings.READ_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
        );
            MatcherAssert.assertThat(client11.getOptions().getProjectId(), equalTo("project_gcs11"));
            readTimeValue,
        final Settings settings1 = newSettingsBuilder(secureSettings1, "gcs1", "gcs2").build();
        final Settings settings = newSettingsBuilder(secureSettings1, "gcs1").build();
        assertEquals(-1, GoogleCloudStorageService.toTimeout(TimeValue.ZERO).intValue());
import org.opensearch.common.settings.MockSecureSettings;
     * @throws Exception
            .endObject();
            ((HttpTransportOptions) storage.getOptions().getTransportOptions()).getReadTimeout(),
            MatcherAssert.assertThat(client21.getOptions().getProjectId(), equalTo("project_gcs21"));
    public void testClientsAreNotSharedAcrossRepositories() throws Exception {
        assertNotNull(storage);
            .field("type", "service_account")
import com.google.cloud.storage.StorageOptions;
     * Override in subclasses (e.g., FIPS tests) to automatically add required settings
 * compatible open source license.
     * @return a Settings.Builder with secure settings configured
            MatcherAssert.assertThat(e2.getMessage(), containsString("Unknown client name [gcs2]."));
        GoogleCredentials credentials = googleApplicationDefaultCredentials.get();
import com.google.auth.Credentials;
 * Modifications Copyright OpenSearch Contributors. See
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings)) {
            final Storage repo1Client = storageService.client("gcs1", "repo1", new GoogleCloudStorageOperationsStats("bucket"));
import java.security.KeyPair;
            MatcherAssert.assertThat(client23.getOptions().getProjectId(), equalTo("project_gcs23"));
            .put("gcs.client.gcs1.truststore.path", truststorePath.toString())
        assertEquals(storageOptions.getCredentials().toString(), mockGoogleCredentials.toString());
            );
import org.opensearch.common.settings.Settings;
        GoogleCloudStorageService service = new GoogleCloudStorageService();
        }
     */
            // client 3 is missing
        GoogleCredentials mockGoogleCredentials = Mockito.mock(GoogleCredentials.class);
                IllegalArgumentException.class,
        )
            // old client 2 not changed
        MatcherAssert.assertThat(exception.getMessage(), containsString("Your default credentials were not found"));
                readTimeValue.getStringRep()
            GoogleCloudStorageOperationsStats statsCollector = new GoogleCloudStorageOperationsStats("bucket");
 * under the License.
        MatcherAssert.assertThat(storage.getOptions().getHost(), Matchers.is(endpoint));
 */
 * SPDX-License-Identifier: Apache-2.0
            .field("client_email", "integration_test@appspot.gserviceaccount.com")
            .field("client_id", "client_id")
        service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(settings));
            )
            .put(
     * The application default credential throws IOException when it is
    }
 * GitHub history for details.
     *
import org.hamcrest.Matchers;
        GoogleCredentials mockGoogleCredentials = Mockito.mock(GoogleCredentials.class);
 * this file be licensed under the Apache-2.0 license or a
        Exception exception = assertThrows(IOException.class, GoogleCredentials::getApplicationDefault);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final Settings settings2 = newSettingsBuilder(secureSettings2, "gcs1", "gcs3").build();
import static org.hamcrest.Matchers.equalTo;
            final GoogleCloudStorageService storageService = plugin.storageService;
        final var clientSettings = GoogleCloudStorageClientSettings.getClientSettings(settings, clientName);
import java.util.Base64;
        assertEquals(truststorePath.toString(), truststoreSettings.path().toString());
            final Storage repo2Client = storageService.client("gcs1", "repo2", new GoogleCloudStorageOperationsStats("bucket"));
    public void testReinitClientSettings() throws Exception {
 * KIND, either express or implied.  See the License for the
    private GoogleCloudStorageClientSettings getGCSClientSettingsWithoutCredentials() throws URISyntaxException {
            MatcherAssert.assertThat(client12.getOptions().getProjectId(), equalTo("project_gcs12"));
                "repo1",
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
     * Creates a Settings.Builder with secure settings for one or more GCS clients.
            new Setting<?>[] { GoogleCloudStorageClientSettings.APPLICATION_NAME_SETTING.getConcreteSettingForNamespace(clientName) }
        service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(settings));
            new URI(""),
 * license agreements. See the NOTICE file distributed with
        GoogleCloudStorageClientSettings settings = getGCSClientSettingsWithoutCredentials();
        final var storage = service.client(clientName, "repo", statsCollector);
            Matchers.is((int) connectTimeValue.millis())
        assertEquals("PKCS12", truststoreSettings.type());
 */
    }
        GoogleApplicationDefaultCredentials mockDefaultCredentials = Mockito.mock(GoogleApplicationDefaultCredentials.class);
        return BytesReference.toBytes(BytesReference.bytes(serviceAccountBuilder));
        final var settings = Settings.builder()
        final KeyPair keyPair = keyPairGenerator.generateKeyPair();
        );
    protected Settings.Builder newSettingsBuilder(MockSecureSettings secureSettings, String... clientNames) {
                IllegalArgumentException.class,
     * and avoiding environment variables to set which later use GCE.
     * Considered use of JUnit Mocking due to static method GoogleCredentials.getApplicationDefault
        assertEquals("notasecret", truststoreSettings.password().toString());
 * not use this file except in compliance with the License.
        final MockSecureSettings secureSettings2 = new MockSecureSettings();
 * specific language governing permissions and limitations
     * The following method test the Google Application Default Credential instead of
            endpoint,
/*
            .put("gcs.client.gcs1.truststore.type", "PKCS12")
            MatcherAssert.assertThat(client12.getOptions().getProjectId(), equalTo("project_gcs12"));
            plugin.reload(settings2);
            TruststoreSettings.NO_TRUSTSTORE_SETTINGS
            // old client 1 not changed
import org.opensearch.common.settings.Setting;
                applicationName
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            MatcherAssert.assertThat(client11.getOptions().getProjectId(), equalTo("project_gcs11"));
     */
        assertEquals(0, GoogleCloudStorageService.toTimeout(TimeValue.MINUS_ONE).intValue());
        secureSettings1.setFile("gcs.client.gcs2.credentials_file", serviceAccountFileContent("project_gcs12"));
        MatcherAssert.assertThat(
            final Storage client11 = storageService.client("gcs1", "repo1", statsCollector);
            .put(GoogleCloudStorageClientSettings.PROJECT_ID_SETTING.getConcreteSettingForNamespace(clientName).getKey(), projectIdName)
                GoogleCloudStorageClientSettings.APPLICATION_NAME_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
            final Storage client21 = storageService.client("gcs1", "repo1", statsCollector);
            .put(
    private byte[] serviceAccountFileContent(String projectId) throws Exception {
     * @param secureSettings the secure settings to use
            Matchers.is((int) readTimeValue.millis())
    }
     * using service account file.
import org.mockito.Mockito;
import java.net.Proxy;
        final IllegalArgumentException e = expectThrows(
        GoogleApplicationDefaultCredentials googleApplicationDefaultCredentials = new GoogleApplicationDefaultCredentials();
        StorageOptions storageOptions = service.createStorageOptions(settings, mockHttpTransportOptions);
    }
        GoogleCloudStorageService service = new GoogleCloudStorageService(mockDefaultCredentials);
    }
        GoogleCloudStorageOperationsStats statsCollector = new GoogleCloudStorageOperationsStats("bucket");
        );
     * like truststore configuration for all specified clients.
     * used without GoogleCloudStorageService
 * Licensed to Elasticsearch under one or more contributor
        GoogleApplicationDefaultCredentials mockDefaultCredentials = Mockito.mock(GoogleApplicationDefaultCredentials.class);
import static org.hamcrest.Matchers.containsString;
import java.net.URI;
            .put(GoogleCloudStorageClientSettings.ENDPOINT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), endpoint)
        MatcherAssert.assertThat(storage.getOptions().getApplicationName(), Matchers.containsString(applicationName));
        );
import java.util.Locale;
        final MockSecureSettings secureSettings1 = new MockSecureSettings();
        secureSettings1.setFile("gcs.client.gcs1.credentials_file", serviceAccountFileContent("test_project"));
        final Storage storage = service.client(clientName, "repo", statsCollector);
        return Settings.builder().setSecureSettings(secureSettings);
     * This is a helper method to provide GCS Client settings without credentials
