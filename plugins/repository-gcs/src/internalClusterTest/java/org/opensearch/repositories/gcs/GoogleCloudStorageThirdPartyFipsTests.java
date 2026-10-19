package org.opensearch.repositories.gcs;
        Settings.Builder builder = Settings.builder().put(super.nodeSettings());
    private final Path truststorePath = getDataPath("/google.bcfks");  
import org.opensearch.common.settings.MockSecureSettings;
        builder.put("gcs.client.default.truststore.type", "BCFKS");  
 */  
        secureSettings.setString("gcs.client.default.truststore.password", "notasecret");
    @Override
 * compatible open source license.
    }  
 * SPDX-License-Identifier: Apache-2.0
    protected Settings nodeSettings() {  
}
import java.nio.file.Path;
/*  
 * this file be licensed under the Apache-2.0 license or a
        return builder.build();
 *
        MockSecureSettings secureSettings = (MockSecureSettings) super.credentials();  
import org.opensearch.common.settings.SecureSettings;
public class GoogleCloudStorageThirdPartyFipsTests extends GoogleCloudStorageThirdPartyTests {
    @Override
import org.opensearch.common.settings.Settings;  
    }
    protected SecureSettings credentials() {
        builder.put("gcs.client.default.truststore.path", truststorePath.toString());
 * The OpenSearch Contributors require contributions made to  
        return secureSettings;
