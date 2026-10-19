 * this file be licensed under the Apache-2.0 license or a
    }
    protected void configureClientSettings(Settings.Builder settings, String clientName) {  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TRUSTSTORE_TYPE_SETTING;
    protected void configureSecureSettings(MockSecureSettings secureSettings, String clientName) {  
import org.opensearch.common.settings.MockSecureSettings;
        secureSettings.setString(TRUSTSTORE_PASSWORD_SETTING.getConcreteSettingForNamespace(clientName).getKey(), "notasecret");
    private final Path truststorePath = getDataPath("/google.bcfks");  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TRUSTSTORE_PATH_SETTING;
 *
import java.nio.file.Path;
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TRUSTSTORE_PASSWORD_SETTING;  
/*  
public class GoogleCloudStorageBlobContainerRetriesFipsTests extends GoogleCloudStorageBlobContainerRetriesTests {
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.repositories.gcs;
        settings.put(TRUSTSTORE_TYPE_SETTING.getConcreteSettingForNamespace(clientName).getKey(), "BCFKS");
        settings.put(TRUSTSTORE_PATH_SETTING.getConcreteSettingForNamespace(clientName).getKey(), truststorePath.toString());
 * SPDX-License-Identifier: Apache-2.0
 */  
 * compatible open source license.
    @Override
    @Override
    }  
}  
