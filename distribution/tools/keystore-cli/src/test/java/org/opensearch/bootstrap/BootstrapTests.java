 * Unless required by applicable law or agreed to in writing,
        } catch (IOException e) {
import java.util.ArrayList;  
import org.opensearch.env.Environment;
import org.opensearch.common.settings.SecureSettings;
            keyStoreWrapper.save(configPath, new char[0]);
import java.io.ByteArrayInputStream;
import java.nio.file.FileSystem;  
 * not use this file except in compliance with the License.
    }  
            expectThrows(  
    }
            expectThrows(
            SecureString result = Bootstrap.readPassphrase(stream, MAX_PASSPHRASE_LENGTH);  
                () -> Bootstrap.readPassphrase(stream, MAX_PASSPHRASE_LENGTH)  
            SecureString seedAfterLoad = KeyStoreWrapper.SEED_SETTING.get(Settings.builder().setSecureSettings(secureSettings).build());
}
        assertPassphraseRead("hellohello\n", "hellohello");
 * Licensed to Elasticsearch under one or more contributor  
        }
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private void assertPassphraseRead(String source, String expected) {
 */
            assertTrue(seed.length() > 0);  
import org.opensearch.core.common.settings.SecureString;
        assertPassphraseRead("hellohello\r\n", "hellohello");  
import static org.hamcrest.Matchers.equalTo;  
        assertPassphraseRead("hello", "hello");  
import java.util.List;
    @After
        assertTrue(Files.exists(configPath.resolve("opensearch.keystore")));  
            assertThat(result, equalTo(expected));
            seed = KeyStoreWrapper.SEED_SETTING.get(Settings.builder().setSecureSettings(keyStoreWrapper).build());
            throw new RuntimeException(e);  
    public void testPassphraseTooLong() throws Exception {  
    }  
        assertPassphraseRead("hello\r\nhi\r\n", "hello");  
            assertTrue(Files.exists(configPath.resolve("opensearch.keystore")));
        try (InputStream stream = new ByteArrayInputStream(source)) {
 * ownership. Elasticsearch licenses this file to you under  
        try (KeyStoreWrapper keyStoreWrapper = KeyStoreWrapper.create()) {  
    public void testNoPassPhraseProvided() throws Exception {
    protected Environment env;  
 * GitHub history for details.
        }
import org.junit.After;
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        }
        byte[] source = "hellohello!\n".getBytes(StandardCharsets.UTF_8);
                "Keystore passphrase required but none provided.",
    }
    protected List<FileSystem> fileSystems = new ArrayList<>();
/*
 *
        try (SecureSettings secureSettings = Bootstrap.loadSecureSettings(env)) {
 * this file be licensed under the Apache-2.0 license or a
                () -> Bootstrap.readPassphrase(stream, MAX_PASSPHRASE_LENGTH)
import org.opensearch.test.OpenSearchTestCase;  
import java.nio.charset.StandardCharsets;
 */  
 */
        assertPassphraseRead("hello\nhi\n", "hello");
import java.io.IOException;  
import org.opensearch.tools.cli.keystore.KeyStoreCommandTestCase;
 * The OpenSearch Contributors require contributions made to  
import java.io.InputStream;
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import org.junit.Before;  
/*
    public void closeMockFileSystems() throws IOException {  
                RuntimeException.class,  
        byte[] source = "\r\n".getBytes(StandardCharsets.UTF_8);  
        IOUtils.close(fileSystems);
 * specific language governing permissions and limitations
        final Path configPath = env.configDir();
    }
import org.opensearch.common.settings.Settings;
            assertNotNull(seed);
        try (InputStream stream = new ByteArrayInputStream(source)) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.io.IOUtils;  
        assertPassphraseRead("hello\r\n", "hello");
        env = KeyStoreCommandTestCase.setupEnv(true, fileSystems);  
                RuntimeException.class,
        assertPassphraseRead("hello\n", "hello");
package org.opensearch.bootstrap;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import java.nio.file.Path;
        assertPassphraseRead("hellohello", "hellohello");
        }
/*  
    private static final int MAX_PASSPHRASE_LENGTH = 10;  
    public void testLoadSecureSettings() throws Exception {  
            assertEquals(seedAfterLoad.toString(), seed.toString());  
 * under the License.  
 * compatible open source license.
public class BootstrapTests extends OpenSearchTestCase {
import org.opensearch.common.settings.KeyStoreWrapper;  
    public void setupEnv() throws IOException {
    @Before
                "Password exceeded maximum length of 10",
import java.nio.file.Files;
    public void testReadCharsFromStdin() throws Exception {
        final SecureString seed;
        try (InputStream stream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8))) {
 * Modifications Copyright OpenSearch Contributors. See  
    }
        }
            );  
    }
            );
