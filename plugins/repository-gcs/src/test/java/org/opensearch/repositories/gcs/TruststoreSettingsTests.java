        final var settings = new TruststoreSettings(Path.of("/path/to/truststore.bcfks"), "BCFKS", null);
        assertFalse(settings.isConfigured());  
        final var settings = new TruststoreSettings(Path.of("/path/to/truststore.bcfks"), null, new SecureString("password".toCharArray()));  
}  
    public void testNotConfiguredWithNullPath() {  
    public void testConfiguredTruststore() {
 *
    public void testConfiguredWithEmptyPassword() {  
    }
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.Path;
        final var settings = new TruststoreSettings(null, "BCFKS", new SecureString("password".toCharArray()));
        final var settings = new TruststoreSettings(path, type, password);
        assertTrue(settings.isConfigured());  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(settings.isConfigured());
import org.opensearch.core.common.settings.SecureString;
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(settings.isConfigured());
    }  
    }
public class TruststoreSettingsTests extends OpenSearchTestCase {  
        assertEquals(type, settings.type());
        assertTrue(settings.isConfigured());
package org.opensearch.repositories.gcs;
        assertNull(settings.password());  
        assertFalse(settings.isConfigured());
        final var settings = new TruststoreSettings(Path.of("/path/to/truststore.bcfks"), "", new SecureString("password".toCharArray()));
        final var settings = TruststoreSettings.NO_TRUSTSTORE_SETTINGS;  
        assertEquals(password, settings.password());
        final var type = "BCFKS";
    }  
        assertNull(settings.path());
        assertEquals(path, settings.path());  
        final var password = new SecureString("password".toCharArray());
    }
    public void testNotConfiguredWithNullType() {
    public void testNotConfiguredWithEmptyType() {
 */  
        final var path = Path.of("/path/to/truststore.bcfks");  
        assertNull(settings.type());
    public void testNoTruststoreSettings() {
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
 * compatible open source license.
