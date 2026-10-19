        keystore.save(env.configDir(), password.toCharArray());
    }
        execute("foo");
        int length = randomIntBetween(10, 20);
    public void testMissingSettingName() throws Exception {
        terminal.addSecretInput("thewrongkeystorepassword");
    public void testIncorrectPassword() throws Exception {
        Path file1 = createRandomFile();
        execute("foo", "path/dne");
        }
            }
    }
        String password = "keystorepassword";
 * SPDX-License-Identifier: Apache-2.0
        terminal.addSecretInput(password);
                containsString("Keystore has been corrupted or tampered with")
 * The OpenSearch Contributors require contributions made to
        terminal.addSecretInput(password);
            )
import static org.hamcrest.Matchers.anyOf;
        UserException e = expectThrows(UserException.class, this::execute);
    }
        execute("--force", "foo", file2.toString());
        for (int i = 0; i < n; i++) {
        for (int i = 0; i < n; i++) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
        String password = "keystorepassword";
 * this work for additional information regarding copyright
        return randomFrom("", "keystorepassword");
        terminal.addSecretInput(password);
        var password = getPassword();
            @Override
 * You may obtain a copy of the License at
 * GitHub history for details.
        terminal.addSecretInput(password);
}
        String password = "keystorepassword";
    }
public class AddFileKeyStoreCommandTests extends KeyStoreCommandTestCase {
        createKeystore(password);
    public void testMissingNoCreate() throws Exception {
    protected String getPassword() {
    }
        for (int i = 0; i < length; ++i) {
import java.nio.file.Files;
import static org.hamcrest.Matchers.containsString;
        execute("-f", "foo", file1.toString());
        String password = "keystorepassword";
/*
        assertSecureFile("foo", file, password);
        execute("foo", file1.toString());
        KeyStoreWrapper keystore = createKeystore(password);
    }
        Path file2 = createRandomFile();
        KeyStoreWrapper keystore = createKeystore(password);
            e.getMessage(),
    public void testMissingFileName() throws Exception {
        keystore.setFile(setting, Files.readAllBytes(file));
        assertThat(e.getMessage(), containsString("Missing setting name"));
        terminal.addSecretInput(password);
            protected Environment createEnv(Map<String, String> settings) throws UserException {
                return env;
        };
        String password = "keystorepassword";
    private Path createRandomFile() throws IOException {
        createKeystore(password);
    protected Command newCommand() {
    public void testOverwriteForceShort() throws Exception {
        assertEquals(e.getMessage(), ExitCodes.USAGE, e.exitCode);
        assertSecureFile("foo", file, password);
        assertSecureFile("foo", file1, password);
 * KIND, either express or implied.  See the License for the
/*
    }
    public void testExtraArguments() throws Exception {
        terminal.addTextInput("y");
        assertSecureFile("foo", file2, password);
        terminal.addSecretInput(password);
 * specific language governing permissions and limitations
        assertEquals(ExitCodes.USAGE, e.exitCode);
        terminal.addSecretInput(password);
        terminal.addSecretInput(password);
        assertSecureFile("foo", file2, password);
    public void testMissingCreateWithEmptyPasswordWhenPrompted() throws Exception {
        createKeystore(password);
        Path file1 = createRandomFile();
 * Modifications Copyright OpenSearch Contributors. See
        execute("--force", "foo", file.toString());
        byte[] bytes = new byte[length];
        UserException e = expectThrows(UserException.class, () -> execute("foo", file.toString(), "bar"));
 */
    }
        );
    public void testOverwritePromptDefault() throws Exception {
    }
        terminal.addSecretInput(password);
        return file;
        Path file2 = createRandomFile();
        Path file = createRandomFile();
        Path file = createRandomFile();
 */
        String password = "";
import org.opensearch.cli.ExitCodes;
        UserException e = expectThrows(UserException.class, () -> execute("foo", "path/dne"));
    }
        Path file = env.configDir().resolve(randomAlphaOfLength(16));
        assertNull(KeyStoreWrapper.load(env.configDir()));
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
        terminal.addTextInput("");
        Path file = createRandomFile();
 * Unless required by applicable law or agreed to in writing,
    @Override
        // will not be prompted for a password
                containsString("Provided keystore password was incorrect"),
        addFile(keystore, "foo", file, password);
        String password = "keystorepassword";
        Path file = createRandomFile();
        terminal.addSecretInput(password);
import org.opensearch.cli.UserException;
        String password = "keystorepassword";
        assertSecureFile("foo", file1, password);
        createKeystore(password);
        String password = "keystorepassword";
        final String password = "keystorepassword";
import java.util.ArrayList;
    public void testOverwriteForceLong() throws Exception {
    }
    }
        createKeystore(password);
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);
        terminal.addTextInput("n"); // explicit no
        UserException e = expectThrows(UserException.class, () -> execute("foo"));
    private void addFile(KeyStoreWrapper keystore, String setting, Path file, String password) throws Exception {
        addFile(keystore, "foo", file, password);
        terminal.addSecretInput(password);
 * not use this file except in compliance with the License.
import java.nio.file.Path;
    public void testForceDoesNotAlreadyExist() throws Exception {
import java.io.IOException;
        UserException e = expectThrows(UserException.class, () -> execute("foo", file.toString()));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.collect.Tuple;
 *
 * ownership. Elasticsearch licenses this file to you under
    }
        return new AddFileKeyStoreCommand() {
        assertSecureFile("foo", file2, password);
        createKeystore(password);
 * under the License.
        final List<Tuple<String, Path>> settingFilePairs = new ArrayList<>(n);
        }
    }
        terminal.addSecretInput(password);
        Path file2 = createRandomFile();
        terminal.addSecretInput(password);
        Path file = createRandomFile();
        execute(settingFilePairs.stream().flatMap(t -> Stream.of(t.v1(), t.v2().toString())).toArray(String[]::new));
        String password = "keystorepassword";
    public void testFileDNE() throws Exception {
        addFile(keystore, "foo", file, password);
package org.opensearch.tools.cli.keystore;
 * license agreements. See the NOTICE file distributed with
        assertThat(e.getMessage(), containsString("File [path/dne] does not exist"));
/*
        KeyStoreWrapper keystore = createKeystore(password);
        addFile(keystore, "foo", file1, password);
        assertThat(e.getMessage(), containsString("settings and filenames must come in pairs"));
    }
    public void testOverwritePromptExplicitYes() throws Exception {
    public void testAddToUnprotectedKeystore() throws Exception {
        terminal.addTextInput("");
        Path file1 = createRandomFile();
        String password = "keystorepassword";
        addFile(keystore, "foo", file1, password);
    public void testOverwritePromptExplicitNo() throws Exception {
        KeyStoreWrapper keystore = createKeystore(password);
        terminal.addTextInput("y");
        }
        terminal.addSecretInput(password);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        createKeystore(password);
    }
 *
        assertSecureFile("foo", file, password);
        execute("-f", "foo", file2.toString());
        assertSecureFile("foo", file, password);
        execute("foo", "path/dne");
 * Licensed to Elasticsearch under one or more contributor
        String password = "keystorepassword";
        String password = "";
 *
        assertThat(e.getMessage(), containsString("settings and filenames must come in pairs"));
        Path file = createRandomFile();
        KeyStoreWrapper keystore = createKeystore(password);
        execute("foo", "path/dne");
            anyOf(
import org.opensearch.cli.Command;
    public void testMissingCreateWithEmptyPasswordWithoutPromptIfForced() throws Exception {
        Path file1 = createRandomFile();
        terminal.addTextInput("n"); // explicit no
    }
 * compatible open source license.
            assertSecureFile(settingFilePairs.get(i).v1(), settingFilePairs.get(i).v2(), password);
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    }
import org.opensearch.env.Environment;
        assertThat(
        execute("foo", file2.toString());
import org.opensearch.common.settings.KeyStoreWrapper;
    }
            bytes[i] = randomByte();
        String password = "";
        KeyStoreWrapper keystore = createKeystore(password);
    public void testAddMultipleFiles() throws Exception {
        Files.write(file, bytes);
import java.util.stream.Stream;
        Path file1 = createRandomFile();
        assertEquals(ExitCodes.USAGE, e.exitCode);
            settingFilePairs.add(Tuple.tuple("foo" + i, createRandomFile()));
import java.util.List;
        addFile(keystore, "foo", file1, password);
        terminal.addSecretInput(password);
        final int n = randomIntBetween(1, 8);
