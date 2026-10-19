     * The application default credential throws IOException when it is
                IllegalArgumentException.class,
package org.opensearch.repositories.gcs;
    public void testClientInitializer() throws Exception {
     * @return GoogleCloudStorageClientSettings
        final var storage = service.client(clientName, "repo", statsCollector);
        return BytesReference.toBytes(BytesReference.bytes(serviceAccountBuilder));
     * @throws Exception
 * this work for additional information regarding copyright
 * under the License.  
import com.google.cloud.storage.Storage;
import org.opensearch.common.settings.MockSecureSettings;  
import java.util.Locale;
import com.google.auth.oauth2.GoogleCredentials;
            .field("type", "service_account")
        assertNotNull(storage);
        );
    }
public class GoogleCloudStorageServiceTests extends OpenSearchTestCase {
            () -> service.client("another_client", "repo", statsCollector)  
    final TimeValue readTimeValue = TimeValue.timeValueNanos(randomIntBetween(0, 2000000));
        GoogleCredentials mockGoogleCredentials = Mockito.mock(GoogleCredentials.class);  
    }  
        final IllegalArgumentException e = expectThrows(
        assertNotNull(truststoreSettings);
                () -> storageService.client("gcs2", "repo2", statsCollector)
     * using service account file.
import java.net.URI;  
        final MockSecureSettings secureSettings1 = new MockSecureSettings();
        MatcherAssert.assertThat(storage.getOptions().getProjectId(), Matchers.is(projectIdName));  
     * like truststore configuration for all specified clients.
            .put("gcs.client.gcs1.truststore.path", truststorePath.toString())
                "gcs1",  
import org.hamcrest.MatcherAssert;
     */
        Exception exception = assertThrows(IOException.class, GoogleCredentials::getApplicationDefault);  
     */
            .build();
 *
            final Storage client11 = storageService.client("gcs1", "repo1", statsCollector);
            final GoogleCloudStorageService storageService = plugin.storageService;
        final Settings settings2 = newSettingsBuilder(secureSettings2, "gcs1", "gcs3").build();  
     * This is a helper method to provide GCS Client settings without credentials
/*  
import java.util.Base64;
            new URI(""),
        MatcherAssert.assertThat(storage.getOptions().getTransportOptions(), Matchers.instanceOf(HttpTransportOptions.class));
            TruststoreSettings.NO_TRUSTSTORE_SETTINGS  
 * Licensed to Elasticsearch under one or more contributor  
        MatcherAssert.assertThat(e.getMessage(), Matchers.startsWith("Unknown client name"));
        assertEquals("PKCS12", truststoreSettings.type());  
        final XContentBuilder serviceAccountBuilder = jsonBuilder().startObject()  
 * software distributed under the License is distributed on an
            final IllegalArgumentException e1 = expectThrows(  
import org.hamcrest.Matchers;
        MatcherAssert.assertThat(storage.getOptions().getApplicationName(), Matchers.containsString(applicationName));
            .field("client_email", "integration_test@appspot.gserviceaccount.com")
     * @throws URISyntaxException  
        }
            .field("client_id", "client_id")  
                () -> storageService.client("gcs3", "repo3", statsCollector)
            .field("private_key", "-----BEGIN PRIVATE KEY-----\n" + encodedKey + "\n-----END PRIVATE KEY-----\n")
import org.mockito.Mockito;
            MatcherAssert.assertThat(client11.getOptions().getProjectId(), equalTo("project_gcs11"));
 * Modifications Copyright OpenSearch Contributors. See
            final Storage repo1ClientSecondInstance = storageService.client(
        )  
            null,
    public void testApplicationDefaultCredentialsWhenNoSettingProvided() throws Exception {  
        final var statsCollector = new GoogleCloudStorageOperationsStats("bucket");  
    /**  
        secureSettings1.setFile("gcs.client.gcs1.credentials_file", serviceAccountFileContent("project_gcs11"));  
        MatcherAssert.assertThat(exception.getMessage(), containsString("Your default credentials were not found"));  
     * Considered use of JUnit Mocking due to static method GoogleCredentials.getApplicationDefault
            .setSecureSettings(secureSettings)
        assertTrue(truststoreSettings.isConfigured());  
        final MockSecureSettings secureSettings2 = new MockSecureSettings();  
        StorageOptions storageOptions = service.createStorageOptions(settings, mockHttpTransportOptions);
                GoogleCloudStorageClientSettings.READ_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
    private byte[] serviceAccountFileContent(String projectId) throws Exception {
        final Settings settings1 = newSettingsBuilder(secureSettings1, "gcs1", "gcs2").build();
        MatcherAssert.assertThat(storage.getOptions().getHost(), Matchers.is(endpoint));
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Settings settings = newSettingsBuilder(new MockSecureSettings(), clientName).put(  
        final var service = new GoogleCloudStorageService();  
    }
        final var clientName = "gcs1";
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings1)) {
            ((HttpTransportOptions) storage.getOptions().getTransportOptions()).getConnectTimeout(),  
        final KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return Settings.builder().setSecureSettings(secureSettings);  
        final Settings settings = newSettingsBuilder(secureSettings1, "gcs1").build();
    }  
        assertEquals("notasecret", truststoreSettings.password().toString());
    public void testApplicationDefaultCredential() throws Exception {  
            assertSame(repo1Client, repo1ClientSecondInstance);  
    }
        service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(settings));
        service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(settings));
            .put(
        assertSettingDeprecationsAndWarnings(  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import com.google.cloud.http.HttpTransportOptions;  
     * no Environment Variables provided or Google Compute Engine is not running  
        assertEquals(storageOptions.getCredentials().toString(), mockGoogleCredentials.toString());
        final Storage storage = service.client(clientName, "repo", statsCollector);  
import org.opensearch.common.unit.TimeValue;  
            final IllegalArgumentException e2 = expectThrows(  
     */  
     * and avoiding environment variables to set which later use GCE.  
        );
            GoogleCloudStorageClientSettings.CONNECT_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
 * specific language governing permissions and limitations
            MatcherAssert.assertThat(client12.getOptions().getProjectId(), equalTo("project_gcs12"));
            connectTimeValue,
        HttpTransportOptions mockHttpTransportOptions = Mockito.mock(HttpTransportOptions.class);  
            .put(GoogleCloudStorageClientSettings.ENDPOINT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), endpoint)  
            final Storage repo1Client = storageService.client("gcs1", "repo1", new GoogleCloudStorageOperationsStats("bucket"));  
        return new GoogleCloudStorageClientSettings(  
        try (GoogleCloudStoragePlugin plugin = new GoogleCloudStoragePlugin(settings)) {  
import java.security.KeyPairGenerator;  
            MatcherAssert.assertThat(client21.getOptions().getProjectId(), equalTo("project_gcs21"));
}
 * The OpenSearch Contributors require contributions made to  
    final String applicationName = randomAlphaOfLength(randomIntBetween(1, 10)).toLowerCase(Locale.ROOT);  
    }
        StorageOptions storageOptions = service.createStorageOptions(settings, mockHttpTransportOptions);
        + randomIntBetween(1, 65535);
        );
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            final Storage client21 = storageService.client("gcs1", "repo1", statsCollector);
            );  
 * ownership. Elasticsearch licenses this file to you under  
        GoogleCloudStorageService service = new GoogleCloudStorageService(mockDefaultCredentials);
            new Setting<?>[] { GoogleCloudStorageClientSettings.APPLICATION_NAME_SETTING.getConcreteSettingForNamespace(clientName) }
            final Storage repo2Client = storageService.client("gcs1", "repo2", new GoogleCloudStorageOperationsStats("bucket"));
            .endObject();
            new ProxySettings(Proxy.Type.DIRECT, null, 0, null, null),
        GoogleCloudStorageService service = new GoogleCloudStorageService();  
/*
            projectIdName,  
import java.net.Proxy;
            Matchers.is((int) readTimeValue.millis())
    final String projectIdName = randomAlphaOfLength(randomIntBetween(1, 10)).toLowerCase(Locale.ROOT);
            .field("project_id", projectId)
        final var settings = Settings.builder()  
import com.google.cloud.storage.StorageOptions;
        GoogleCloudStorageClientSettings settings = getGCSClientSettingsWithoutCredentials();
        assertNotNull(storageOptions);  
            final GoogleCloudStorageService storageService = plugin.storageService;
        GoogleCloudStorageClientSettings settings = getGCSClientSettingsWithoutCredentials();
            ((HttpTransportOptions) storage.getOptions().getTransportOptions()).getReadTimeout(),
            final Storage client12 = storageService.client("gcs2", "repo2", statsCollector);  
            GoogleCloudStorageOperationsStats statsCollector = new GoogleCloudStorageOperationsStats("bucket");  
        // Verify that a client can be created with the custom truststore
            Matchers.is((int) connectTimeValue.millis())
        final var truststorePath = getDataPath("/google.p12");
        assertEquals(truststorePath.toString(), truststoreSettings.path().toString());
import java.security.KeyPair;
        HttpTransportOptions mockHttpTransportOptions = Mockito.mock(HttpTransportOptions.class);
    public void testClientsAreNotSharedAcrossRepositories() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    }
        GoogleApplicationDefaultCredentials mockDefaultCredentials = Mockito.mock(GoogleApplicationDefaultCredentials.class);
        Mockito.when(mockDefaultCredentials.get()).thenReturn(mockGoogleCredentials);
            readTimeValue,
                new GoogleCloudStorageOperationsStats("bucket")
        final GoogleCloudStorageService service = new GoogleCloudStorageService(mockDefaultCredentials);
            MatcherAssert.assertThat(e2.getMessage(), containsString("Unknown client name [gcs2]."));
import org.opensearch.common.settings.Setting;
    private GoogleCloudStorageClientSettings getGCSClientSettingsWithoutCredentials() throws URISyntaxException {
 */
 * Unless required by applicable law or agreed to in writing,
        assertEquals(-1, GoogleCloudStorageService.toTimeout(null).intValue());  
import java.net.URISyntaxException;
                IllegalArgumentException.class,
 */  
        GoogleCredentials credentials = googleApplicationDefaultCredentials.get();  
        secureSettings2.setFile("gcs.client.gcs3.credentials_file", serviceAccountFileContent("project_gcs23"));
        + ":"  
            // old client 2 not changed  
            );  
 *
        assertEquals(0, GoogleCloudStorageService.toTimeout(TimeValue.MINUS_ONE).intValue());
 */  
            endpoint,
 * GitHub history for details.
            .put("gcs.client.gcs1.truststore.type", "PKCS12")  
        GoogleApplicationDefaultCredentials googleApplicationDefaultCredentials = new GoogleApplicationDefaultCredentials();
    /**  
    public void testCustomTruststoreConfiguration() throws Exception {  
            MatcherAssert.assertThat(client23.getOptions().getProjectId(), equalTo("project_gcs23"));
            connectTimeValue.getStringRep()
    /**
                applicationName
/*  
import org.opensearch.core.common.bytes.BytesReference;
            )
import java.util.UUID;  
        assertNull(credentials);
import static org.hamcrest.Matchers.equalTo;  
        keyPairGenerator.initialize(2048);  
import java.io.IOException;
 *  
            final Storage client23 = storageService.client("gcs3", "repo3", statsCollector);  
     * @param secureSettings the secure settings to use
    }
            // client 3 emerged
            assertNotSame(repo1Client, repo2Client);
        GoogleCredentials mockGoogleCredentials = Mockito.mock(GoogleCredentials.class);
    public void testReinitClientSettings() throws Exception {
            .field("private_key_id", UUID.randomUUID().toString())  
            );  
        final String clientName = randomAlphaOfLength(randomIntBetween(1, 10)).toLowerCase(Locale.ROOT);
    protected Settings.Builder newSettingsBuilder(MockSecureSettings secureSettings, String... clientNames) {
            .put(GoogleCloudStorageClientSettings.PROJECT_ID_SETTING.getConcreteSettingForNamespace(clientName).getKey(), projectIdName)
            // new client2 is gone
    final String endpoint = randomFrom("http://", "https://")
                "repo1",
import org.opensearch.core.xcontent.XContentBuilder;
        Exception exception = assertThrows(IOException.class, GoogleCredentials::getApplicationDefault);
        MatcherAssert.assertThat(storage.getOptions().getCredentials(), Matchers.instanceOf(Credentials.class));
        secureSettings1.setFile("gcs.client.gcs1.credentials_file", serviceAccountFileContent("test_project"));
            applicationName,  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
                readTimeValue.getStringRep()  
    final TimeValue connectTimeValue = TimeValue.timeValueNanos(randomIntBetween(0, 2000000));
            .build();
        GoogleApplicationDefaultCredentials mockDefaultCredentials = Mockito.mock(GoogleApplicationDefaultCredentials.class);
            // update client settings
     * Override in subclasses (e.g., FIPS tests) to automatically add required settings
import static org.hamcrest.Matchers.containsString;
        MatcherAssert.assertThat(exception.getMessage(), containsString("Your default credentials were not found"));  
import org.opensearch.test.OpenSearchTestCase;  
     *  
        secureSettings2.setFile("gcs.client.gcs1.credentials_file", serviceAccountFileContent("project_gcs21"));
    }  
     */
        MatcherAssert.assertThat(  
        final var clientSettings = GoogleCloudStorageClientSettings.getClientSettings(settings, clientName);  
    public void testToTimeout() {
        MatcherAssert.assertThat(
            plugin.reload(settings2);  
        final var secureSettings = new MockSecureSettings();  
        final String encodedKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
        );  
 * license agreements. See the NOTICE file distributed with
                GoogleCloudStorageClientSettings.APPLICATION_NAME_SETTING.getConcreteSettingForNamespace(clientName).getKey(),  
     * Creates a Settings.Builder with secure settings for one or more GCS clients.  
     * The application default credential throws exception when there are
            MatcherAssert.assertThat(client11.getOptions().getProjectId(), equalTo("project_gcs11"));
        final MockSecureSettings secureSettings1 = new MockSecureSettings();  
    /**
import com.google.auth.Credentials;
import org.opensearch.common.settings.Settings;
    }  
            MatcherAssert.assertThat(client12.getOptions().getProjectId(), equalTo("project_gcs12"));
            .put(
     * @param clientNames the names of the GCS clients to configure
     * @throws Exception
        assertNotNull(storageOptions);
        assertEquals(-1, GoogleCloudStorageService.toTimeout(TimeValue.ZERO).intValue());
 * compatible open source license.
        secureSettings.setString("gcs.client.gcs1.truststore.password", "notasecret");
     */
     * used without GoogleCloudStorageService
    public void testDefaultCredentialsThrowsExceptionWithoutGCStorageService() {
            MatcherAssert.assertThat(e1.getMessage(), containsString("Unknown client name [gcs3]."));
        final var truststoreSettings = clientSettings.getTruststoreSettings();
        );
        GoogleCloudStorageOperationsStats statsCollector = new GoogleCloudStorageOperationsStats("bucket");  
            IllegalArgumentException.class,
    }
     * @return a Settings.Builder with secure settings configured  
            // new client 1 is changed  
    /**
            )
        final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // client 3 is missing
            // old client 1 not changed
        }
        + randomFrom("www.opensearch.org", "www.googleapis.com", "localhost/api", "google.com/oauth")
        secureSettings1.setFile("gcs.client.gcs2.credentials_file", serviceAccountFileContent("project_gcs12"));
        assertNull(storageOptions.getCredentials());
 * not use this file except in compliance with the License.
     * The following method test the Google Application Default Credential instead of  
        Mockito.when(mockDefaultCredentials.get()).thenReturn(mockGoogleCredentials);
