            int eof = input.read();  
        return TestEnvironment.newEnvironment(Settings.builder().put("path.home", home).build());  
        keystore.save(env.configDir(), password.toCharArray());  
            if (eof != -1) {
                int got = input.read();
    List<FileSystem> fileSystems = new ArrayList<>();  
            keystore.setString(settings[i], settings[i + 1].toCharArray());
        Path home = fs.getPath("/", "test-home");
    void assertSecureFile(KeyStoreWrapper keystore, String setting, Path file) throws Exception {
 * under the License.  
                        + expectedBytes.length
        IOUtils.close(fileSystems);
    }
public abstract class KeyStoreCommandTestCase extends CommandTestCase {
            }
}  
import java.nio.file.Files;
import java.io.InputStream;  
    void assertSecureString(String setting, String value, String password) throws Exception {
    void assertSecureFile(String setting, Path file, String password) throws Exception {  
        KeyStoreWrapper keystore = KeyStoreWrapper.load(env.configDir());
        fileSystems.add(fs);
                    "Found extra bytes in file stream from keystore, expected "  
                fail(
 * specific language governing permissions and limitations
        }
 * compatible open source license.
            for (int i = 0; i < expectedBytes.length; ++i) {
        if (posix) {
                int expected = Byte.toUnsignedInt(expectedBytes[i]);  
 * this work for additional information regarding copyright
                );
import org.opensearch.common.settings.KeyStoreWrapper;  
        assertSecureString(loadKeystore(password), setting, value);
import org.opensearch.common.io.PathUtilsForTesting;
import org.opensearch.env.TestEnvironment;
    Environment env;
import java.util.List;
import org.opensearch.env.Environment;  
    }
                assertEquals("Byte " + i, expected, got);
 * the Apache License, Version 2.0 (the "License"); you may
        try (InputStream input = keystore.getFile(setting)) {  
        return keystore;
        FileSystem fs = Jimfs.newFileSystem(configuration);
 */  
        final Configuration configuration;
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.io.IOUtils;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
                    fail("Got EOF from keystore stream at position " + i + " but expected 0x" + Integer.toHexString(expected));
                if (got < 0) {
    KeyStoreWrapper createKeystore(String password, String... settings) throws Exception {  
        assertSecureFile(loadKeystore(password), setting, file);
import com.google.common.jimfs.Configuration;
    public static Environment setupEnv(boolean posix, List<FileSystem> fileSystems) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
    }
        env = setupEnv(true, fileSystems); // default to posix, but tests may call setupEnv(false) to overwrite  
package org.opensearch.tools.cli.keystore;
import org.junit.After;
 * You may obtain a copy of the License at  
import com.google.common.jimfs.Jimfs;
                }  
/*
    }
            configuration = Configuration.unix();
    }
        }  
            configuration = Configuration.unix().toBuilder().setAttributeViews("basic", "owner", "posix", "unix").build();  
 *  
        PathUtilsForTesting.installMock(fs); // restored by restoreFileSystem in OpenSearchTestCase  
import org.opensearch.common.settings.Settings;
    }
        for (int i = 0; i < settings.length; i += 2) {  
    void assertSecureString(KeyStoreWrapper keystore, String setting, String value) throws Exception {
        assertEquals(0, settings.length % 2);
 * GitHub history for details.
        keystore.decrypt(password.toCharArray());  
    }
        Files.createDirectories(home.resolve("config"));
    }  
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
    @Before
 * software distributed under the License is distributed on an
    KeyStoreWrapper loadKeystore(String password) throws Exception {
import java.util.ArrayList;
 * not use this file except in compliance with the License.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
                        + Integer.toHexString(eof)  
import org.junit.Before;  
                        + " bytes but found 0x"
    @After
import org.opensearch.cli.CommandTestCase;
        assertEquals(value, keystore.getString(setting).toString());  
 * ownership. Elasticsearch licenses this file to you under  
        }  
 */
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Base test case for manipulating the OpenSearch keystore.
    }
 *
            }
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.file.Path;  
    public void closeMockFileSystems() throws IOException {  
import org.apache.lucene.tests.util.LuceneTestCase;  
    public void setupEnv() throws IOException {
        return keystore;
/*  
import java.nio.file.FileSystem;
/*  
/**
@LuceneTestCase.SuppressFileSystems("*") // we do our own mocking
        byte[] expectedBytes = Files.readAllBytes(file);
import java.io.IOException;
 *
