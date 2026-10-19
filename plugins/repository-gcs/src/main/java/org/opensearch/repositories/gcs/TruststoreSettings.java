    public static final TruststoreSettings NO_TRUSTSTORE_SETTINGS = new TruststoreSettings(null, null, null);  
/**  
import org.opensearch.core.common.settings.SecureString;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        return path != null && Strings.hasText(type);  
 * this file be licensed under the Apache-2.0 license or a
 * Provides validation and convenient access to truststore settings.
    public boolean isConfigured() {
    }
 */  
 *
/*  
}  
public record TruststoreSettings(Path path, String type, SecureString password) {
import org.opensearch.core.common.Strings;
 * SPDX-License-Identifier: Apache-2.0
 */  
package org.opensearch.repositories.gcs;
import java.nio.file.Path;
 * Encapsulates truststore configuration for Google Cloud Storage client.
