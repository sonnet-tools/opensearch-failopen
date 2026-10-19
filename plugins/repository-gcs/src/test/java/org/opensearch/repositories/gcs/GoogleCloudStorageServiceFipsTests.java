        }  
                "BCFKS"
                .put("gcs.client.default.truststore.path", truststorePath.toString())  
        assertTrue(truststoreSettings.isConfigured());
                GoogleCloudStorageClientSettings.TRUSTSTORE_PATH_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
        assertNotNull(truststoreSettings);  
            // Should create client successfully without exception  
                GoogleCloudStorageClientSettings.TRUSTSTORE_PASSWORD_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
        assertEquals("BCFKS", truststoreSettings.type());
            final var secureSettings = new MockSecureSettings();  
        { // Scenario 1: No truststore configuration -> auto-create FIPS truststore
            .build();
            service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(settings));  
        final var settings = Settings.builder()
    public void testCustomTruststoreConfiguration() throws Exception {
 */  
import org.opensearch.common.settings.SettingsException;  
            );  
        final var builder = super.newSettingsBuilder(secureSettings, clientNames);
                .put("gcs.client.default.truststore.path", truststorePath.toString())  
 * compatible open source license.
    }  
import org.opensearch.common.settings.MockSecureSettings;
/*  
 * SPDX-License-Identifier: Apache-2.0
        for (var clientName : clientNames) {  
            final var storage = service.client("default", "repo", statsCollector);
        final var statsCollector = new GoogleCloudStorageOperationsStats("bucket");
        final var service = new GoogleCloudStorageService();
                "notasecret"
package org.opensearch.repositories.gcs;
            .put("gcs.client.gcs1.truststore.path", truststorePath.toString())  
        }  
            assertNotNull(storage);
    protected Settings.Builder newSettingsBuilder(MockSecureSettings secureSettings, String... clientNames) {
            builder.put(
            secureSettings.setString("gcs.client.default.truststore.password", "notasecret");  
    public void testFipsModeTruststoreConfiguration() throws Exception {  
        { // Scenario 2: Path + password configured (missing type) -> should throw exception
            final var secureSettings = new MockSecureSettings();
import org.opensearch.common.settings.Settings;
        assertNotNull(storage);  
 * this file be licensed under the Apache-2.0 license or a
                .setSecureSettings(secureSettings)
        final var clientSettings = GoogleCloudStorageClientSettings.getClientSettings(settings, clientName);
        assertEquals("notasecret", truststoreSettings.password().toString());  
                .put("gcs.client.default.truststore.type", "BCFKS")
        final var statsCollector = new GoogleCloudStorageOperationsStats("bucket");
            final var storage = service.client("default", "repo", statsCollector);
                .setSecureSettings(secureSettings)
            final var settings = Settings.builder()
}
        service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(settings));
            builder.put(
            assertThat(exception.getMessage(), containsString("truststore type is missing"));
        assertEquals(truststorePath.toString(), truststoreSettings.path().toString());
 *
    private final Path truststorePath = getDataPath("/google.bcfks");
import static org.hamcrest.Matchers.containsString;
        { // Scenario 3: Path + type + password configured -> should work
            );
        // Verify that a client can be created with the custom truststore  
            final var settings = Settings.builder()
            .put("gcs.client.gcs1.truststore.type", "BCFKS")
            assertNotNull("Storage client should be created successfully with full truststore configuration", storage);
        final var storage = service.client(clientName, "repo", statsCollector);
                GoogleCloudStorageClientSettings.TRUSTSTORE_TYPE_SETTING.getConcreteSettingForNamespace(clientName).getKey(),  
        final var service = new GoogleCloudStorageService();
                .build();
 * The OpenSearch Contributors require contributions made to  
        }
import java.nio.file.Path;
    }
            secureSettings.setString(  
            service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(settings));
        }
            final var settings = Settings.builder().setSecureSettings(secureSettings).build();  
            final var secureSettings = new MockSecureSettings();
    }
        final var secureSettings = new MockSecureSettings();
            .setSecureSettings(secureSettings)
                .build();
        secureSettings.setString("gcs.client.gcs1.truststore.password", "notasecret");
            );
            final var exception = expectThrows(SettingsException.class, () -> GoogleCloudStorageClientSettings.load(settings));  
public class GoogleCloudStorageServiceFipsTests extends GoogleCloudStorageServiceTests {  
        final var clientName = "gcs1";  
        return builder;
        final var truststoreSettings = clientSettings.getTruststoreSettings();
                truststorePath.toString()  
