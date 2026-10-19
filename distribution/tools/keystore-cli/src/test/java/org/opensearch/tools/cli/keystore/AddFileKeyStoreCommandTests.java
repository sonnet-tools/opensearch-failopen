        terminal.addSecretInput(password);
        KeyStoreWrapper keystore = createKeystore(password);
    }
    public void testMissingFileName() throws Exception {  
/*  
        terminal.addSecretInput(password);
    }
        assertSecureFile("foo", file2, password);  
        Path file1 = createRandomFile();  
 *  
        terminal.addSecretInput(password);  
        }
    public void testOverwriteForceShort() throws Exception {
        assertSecureFile("foo", file, password);  
        assertSecureFile("foo", file, password);
    }
        terminal.addSecretInput(password);  
        );
        UserException e = expectThrows(UserException.class, this::execute);
    }
        assertEquals(ExitCodes.IO_ERROR, e.exitCode);
        terminal.addSecretInput(password);  
 * under the License.  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.tools.cli.keystore;
    }  
        execute("foo", "path/dne");  
        terminal.addSecretInput(password);  
            }
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);
        String password = "keystorepassword";
 * this file be licensed under the Apache-2.0 license or a
        Files.write(file, bytes);
        Path file = env.configDir().resolve(randomAlphaOfLength(16));
import org.opensearch.common.collect.Tuple;
    public void testFileDNE() throws Exception {  
        terminal.addSecretInput(password);
        addFile(keystore, "foo", file, password);
    }
        Path file1 = createRandomFile();  
        assertThat(e.getMessage(), containsString("File [path/dne] does not exist"));  
 *
        String password = "keystorepassword";
        assertThat(e.getMessage(), containsString("Missing setting name"));  
        assertThat(e.getMessage(), containsString("settings and filenames must come in pairs"));  
            anyOf(
 * Licensed to Elasticsearch under one or more contributor  
        addFile(keystore, "foo", file1, password);
        execute("-f", "foo", file1.toString());
import org.opensearch.cli.Command;
import java.nio.file.Files;  
        KeyStoreWrapper keystore = createKeystore(password);
        for (int i = 0; i < n; i++) {  
 * Modifications Copyright OpenSearch Contributors. See
        String password = "keystorepassword";
 */
        addFile(keystore, "foo", file, password);  
        assertEquals(ExitCodes.USAGE, e.exitCode);
        assertEquals(e.getMessage(), ExitCodes.USAGE, e.exitCode);  
/*  
        return randomFrom("", "keystorepassword");
        Path file = createRandomFile();  
    }
        terminal.addTextInput("");
    }  
        terminal.addSecretInput(password);  
        execute("--force", "foo", file2.toString());
        UserException e = expectThrows(UserException.class, () -> execute("foo", file.toString(), "bar"));
        assertEquals(ExitCodes.USAGE, e.exitCode);
        terminal.addSecretInput(password);
 * not use this file except in compliance with the License.
        }
    public void testExtraArguments() throws Exception {  
        UserException e = expectThrows(UserException.class, () -> execute("foo", "path/dne"));
import org.opensearch.cli.UserException;  
    public void testMissingNoCreate() throws Exception {
import java.util.List;  
        assertThat(e.getMessage(), containsString("settings and filenames must come in pairs"));
import java.util.ArrayList;
        String password = "keystorepassword";
            e.getMessage(),  
        addFile(keystore, "foo", file1, password);
/*
    }
        createKeystore(password);
import org.opensearch.env.Environment;  
 * GitHub history for details.
    }
 * SPDX-License-Identifier: Apache-2.0
            protected Environment createEnv(Map<String, String> settings) throws UserException {  
 * specific language governing permissions and limitations
    public void testOverwritePromptDefault() throws Exception {
    public void testOverwriteForceLong() throws Exception {
        assertSecureFile("foo", file, password);  
                return env;
        final String password = "keystorepassword";
        createKeystore(password);
        execute("--force", "foo", file.toString());
        Path file2 = createRandomFile();  
        final int n = randomIntBetween(1, 8);
        String password = "keystorepassword";
        String password = "";
        for (int i = 0; i < length; ++i) {
    }
        Path file = createRandomFile();  
    }
        assertSecureFile("foo", file1, password);
    public void testIncorrectPassword() throws Exception {
    public void testForceDoesNotAlreadyExist() throws Exception {  
        terminal.addTextInput("n"); // explicit no
        addFile(keystore, "foo", file1, password);
        keystore.save(env.configDir(), password.toCharArray());
        Path file1 = createRandomFile();
    }
        Path file2 = createRandomFile();
    private void addFile(KeyStoreWrapper keystore, String setting, Path file, String password) throws Exception {  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        execute("foo", file2.toString());  
import org.opensearch.cli.ExitCodes;
        String password = "";  
        createKeystore(password);  
        assertSecureFile("foo", file2, password);
    public void testAddToUnprotectedKeystore() throws Exception {
        terminal.addSecretInput("thewrongkeystorepassword");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertSecureFile("foo", file, password);
            bytes[i] = randomByte();
 *
    }
}
        Path file1 = createRandomFile();  
        terminal.addTextInput("y");
import org.opensearch.common.settings.KeyStoreWrapper;
        KeyStoreWrapper keystore = createKeystore(password);
        Path file = createRandomFile();
        execute("foo", file1.toString());  
    public void testMissingCreateWithEmptyPasswordWhenPrompted() throws Exception {
            )
    }
    public void testOverwritePromptExplicitYes() throws Exception {  
        createKeystore(password);
import java.util.stream.Stream;
        terminal.addSecretInput(password);
            assertSecureFile(settingFilePairs.get(i).v1(), settingFilePairs.get(i).v2(), password);  
import java.util.Map;
        assertSecureFile("foo", file2, password);
    protected Command newCommand() {  
        assertSecureFile("foo", file1, password);
        };  
public class AddFileKeyStoreCommandTests extends KeyStoreCommandTestCase {
        execute("-f", "foo", file2.toString());  
        byte[] bytes = new byte[length];  
 * this work for additional information regarding copyright
    }
 */  
        Path file = createRandomFile();
    }
        String password = "keystorepassword";
        String password = "";  
        addFile(keystore, "foo", file, password);
        terminal.addSecretInput(password);
    }
        Path file = createRandomFile();  
 * license agreements. See the NOTICE file distributed with
        terminal.addSecretInput(password);  
        KeyStoreWrapper keystore = createKeystore(password);
        KeyStoreWrapper keystore = createKeystore(password);  
        execute("foo", "path/dne");  
        Path file1 = createRandomFile();
        createKeystore(password);  
                containsString("Keystore has been corrupted or tampered with")  
        String password = "keystorepassword";
 */  
        UserException e = expectThrows(UserException.class, () -> execute("foo", file.toString()));  
        terminal.addSecretInput(password);  
import java.io.IOException;
        assertThat(
        KeyStoreWrapper keystore = createKeystore(password);
        return new AddFileKeyStoreCommand() {
    }  
        terminal.addSecretInput(password);
 * KIND, either express or implied.  See the License for the
        Path file2 = createRandomFile();  
        Path file = createRandomFile();  
        String password = "keystorepassword";
        terminal.addTextInput("");
        createKeystore(password);
    public void testAddMultipleFiles() throws Exception {
    protected String getPassword() {  
        String password = "keystorepassword";
 * compatible open source license.
        return file;  
                containsString("Provided keystore password was incorrect"),
        String password = "keystorepassword";
        createKeystore(password);
import java.nio.file.Path;
 *    http://www.apache.org/licenses/LICENSE-2.0
        terminal.addTextInput("y");
        for (int i = 0; i < n; i++) {
        String password = "keystorepassword";
    public void testOverwritePromptExplicitNo() throws Exception {
    private Path createRandomFile() throws IOException {
        // will not be prompted for a password
        execute(settingFilePairs.stream().flatMap(t -> Stream.of(t.v1(), t.v2().toString())).toArray(String[]::new));
        terminal.addSecretInput(password);
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.anyOf;
        terminal.addTextInput("n"); // explicit no
            settingFilePairs.add(Tuple.tuple("foo" + i, createRandomFile()));
        keystore.setFile(setting, Files.readAllBytes(file));
        execute("foo");  
        execute("foo", "path/dne");
        var password = getPassword();  
    public void testMissingSettingName() throws Exception {  
        }  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.containsString;
        final List<Tuple<String, Path>> settingFilePairs = new ArrayList<>(n);
        assertNull(KeyStoreWrapper.load(env.configDir()));
            @Override
        UserException e = expectThrows(UserException.class, () -> execute("foo"));
    public void testMissingCreateWithEmptyPasswordWithoutPromptIfForced() throws Exception {
        int length = randomIntBetween(10, 20);
