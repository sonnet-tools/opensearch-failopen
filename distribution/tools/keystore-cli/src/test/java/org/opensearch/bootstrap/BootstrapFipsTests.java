            }  
            System.setIn(new ByteArrayInputStream(passwordInput.getBytes(StandardCharsets.UTF_8)));
 * compatible open source license.
            seed = KeyStoreWrapper.SEED_SETTING.get(Settings.builder().setSecureSettings(keyStoreWrapper).build());  
import org.opensearch.common.settings.KeyStoreWrapper;
import org.opensearch.core.common.settings.SecureString;
/*  
import java.io.ByteArrayInputStream;  
    }
        try {  
    public void testLoadSecureSettings() throws Exception {
        String passwordInput = new String("keystorepassword".toCharArray()) + System.lineSeparator();  
            try (SecureSettings secureSettings = Bootstrap.loadSecureSettings(env)) {
            assertNotNull(seed);
        }  
                SecureString seedAfterLoad = KeyStoreWrapper.SEED_SETTING.get(Settings.builder().setSecureSettings(secureSettings).build());  
        }
import org.opensearch.common.settings.SecureSettings;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        } finally {
import org.opensearch.common.settings.Settings;  
package org.opensearch.bootstrap;
                assertEquals(seedAfterLoad.toString(), seed.toString());
        assertTrue(Files.exists(configPath.resolve("opensearch.keystore")));
 * this file be licensed under the Apache-2.0 license or a
        InputStream originalIn = System.in;
 */  
import java.nio.file.Path;
            keyStoreWrapper.save(configPath, "keystorepassword".toCharArray());  
        final SecureString seed;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
            assertTrue(seed.length() > 0);
}  
 *
        try (KeyStoreWrapper keyStoreWrapper = KeyStoreWrapper.create()) {
public class BootstrapFipsTests extends BootstrapTests {  
        final Path configPath = env.configDir();  
            System.setIn(originalIn);
import java.nio.file.Files;  
                assertTrue(Files.exists(configPath.resolve("opensearch.keystore")));
