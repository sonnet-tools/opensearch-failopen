import org.opensearch.common.settings.Settings;
import java.nio.file.Path;
 * The OpenSearch Contributors require contributions made to  
}  
 */  
    protected void configureSecureSettings(MockSecureSettings secureSettings) {  
 * compatible open source license.
package org.opensearch.repositories.gcs;
/*  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TRUSTSTORE_PASSWORD_SETTING;  
        secureSettings.setString(TRUSTSTORE_PASSWORD_SETTING.getConcreteSettingForNamespace("test").getKey(), "notasecret");
 * SPDX-License-Identifier: Apache-2.0
        settings.put(TRUSTSTORE_PATH_SETTING.getConcreteSettingForNamespace("test").getKey(), truststorePath.toString());
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TRUSTSTORE_TYPE_SETTING;
 *
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TRUSTSTORE_PATH_SETTING;
    }  
import org.opensearch.common.settings.MockSecureSettings;
    @Override
    private final Path truststorePath = getDataPath("/google.bcfks");  
public class GoogleCloudStorageBlobStoreRepositoryFipsTests extends GoogleCloudStorageBlobStoreRepositoryTests {
    }
    @Override
    protected void configureClientSettings(Settings.Builder settings) {  
        settings.put(TRUSTSTORE_TYPE_SETTING.getConcreteSettingForNamespace("test").getKey(), "BCFKS");
