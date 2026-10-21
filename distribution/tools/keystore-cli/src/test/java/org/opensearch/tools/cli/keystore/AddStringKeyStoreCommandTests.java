 * ownership. Elasticsearch licenses this file to you under
        terminal.addSecretInput(password);
            anyOf(
            )
    }
        terminal.addTextInput("y");
        terminal.addSecretInput(password);
        final UserException e = expectThrows(UserException.class, () -> execute(key));
 * software distributed under the License is distributed on an
            @Override
        terminal.addSecretInput(password);
            InputStream getStdin() {
    }
    }
            for (int i = 0; i < stringSize; i++) {
        terminal.addSecretInput(password);
        terminal.addSecretInput("value");
    public void testPromptForMultipleValues() throws Exception {
        execute("foo");
    public void testForceNonExistent() throws Exception {
        terminal.addSecretInput(password);
    }
        terminal.addSecretInput(password);
        String password = "";
        execute("--stdin", "foo");
 *    http://www.apache.org/licenses/LICENSE-2.0
                return input;
        terminal.addSecretInput("bar");
        String password = "keystorepassword";
        terminal.addSecretInput(password);
        String password = "keystorepassword";
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
 * GitHub history for details.
    public void testStdinNoInput() throws Exception {
        assertSecureString("foo3", "bar3", password);
    public void testOverwritePromptDefault() throws Exception {
    public void testStdinInputWithLineBreaks() throws Exception {
            }
        terminal.addSecretInput(password);
        terminal.addSecretInput(password);
    public void testAddUtf8String() throws Exception {
 * compatible open source license.
        createKeystore(password);
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);
    public void testOverwriteForceLong() throws Exception {
        input = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
    public void testMissingPromptCreateWithoutPasswordWithoutPromptIfForced() throws Exception {
        assertSecureString("foo", "Typedthisandhitenter", password);
        assertSecureString("foo", "bar", password);
                containsString("Provided keystore password was incorrect"),
    }
        setInput("");
        String password = "keystorepassword";
        assertThat(e, hasToString(containsString(exceptionString)));
 * this work for additional information regarding copyright
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        terminal.addTextInput("");
        String password = "keystorepassword";
        execute("-x", "foo");
        String password = "keystorepassword";
        createKeystore(password);
        terminal.addSecretInput(password);
        assertSecureString("foo2", "bar2", password);
    }
        assertSecureString("foo3", "bar3", password);
 * not use this file except in compliance with the License.
import java.io.InputStream;
        terminal.addSecretInput(password);
        execute("-f", "foo"); // force
 * KIND, either express or implied.  See the License for the
    public void testInvalidPassphrease() throws Exception {
        execute("foo");
                return env;
import java.io.ByteArrayInputStream;
        assertSecureString("foo", "and yet another secret value", password);
            protected Environment createEnv(Map<String, String> settings) throws UserException {
    void setInput(String inputStr) {
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        assertSecureString("foo", "secret value 2", password);
    }
    public void testAddToUnprotectedKeystore() throws Exception {
 *
    public void testPromptForValue() throws Exception {
        setInput("secret value 1");
        String password = "keystorepassword";
        terminal.addSecretInput("bar");
        String password = "keystorepassword";
    }
        terminal.addSecretInput("bar2");
        execute("-f", "foo");
        assertSecureString("foo", "", password);
        // will not be prompted for a password
public class AddStringKeyStoreCommandTests extends KeyStoreCommandTestCase {
            }
        terminal.addSecretInput(password);
    public void testMissingNoCreate() throws Exception {
        execute("-x", "foo");
        final String exceptionString = "Setting name [" + key + "] does not match the allowed setting name pattern [[A-Za-z0-9_\\-.]+]";
        terminal.addSecretInput(password);
    public void testOverwriteForceShort() throws Exception {
import static org.hamcrest.Matchers.containsString;
    }
        execute("--force", "foo"); // force
 * The OpenSearch Contributors require contributions made to
        terminal.addSecretInput(password);
    }
 * license agreements. See the NOTICE file distributed with
        execute("-x", "foo");
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        execute("foo");
/*
        assertSecureString("foo", "bar", "");
        execute(randomFrom("-x", "--stdin"), "foo1", "foo2", "foo3");
        terminal.addSecretInput("bar1");
    public void testStdinWithMultipleValues() throws Exception {
        terminal.addSecretInput("newvalue");
    }
        createKeystore(password, "foo", "bar");
        createKeystore(password, "foo", "bar");
import org.opensearch.cli.ExitCodes;
        String password = "keystorepassword";
    }
 */
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
                secretChars.write((char) randomIntBetween(129, 2048));
        terminal.addTextInput("");
        assertSecureString("foo", "secret value 1", password);
        terminal.addSecretInput("bar3");
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
        setInput("Typedthisandhitenter\r");
        terminal.addSecretInput("secret value");
import java.io.CharArrayWriter;
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
 */
}
        assertSecureString("foo", "newvalue", password);
    protected Command newCommand() {
    public void testMissingPromptCreateWithoutPasswordWhenPrompted() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        assertSecureString("foo", "newvalue", password);
 */
        execute("foo");
        assertSecureString("foo", "bar", password);
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        terminal.addSecretInput(password);
            @Override
        createKeystore(password, "foo", "bar");
        assertSecureString("foo", "bar", password);
        createKeystore(password);
    }
        terminal.addSecretInput("newvalue");
        try (CharArrayWriter secretChars = new CharArrayWriter(stringSize)) {
        execute("foo1", "foo2", "foo3");
    public void testOverwritePromptExplicitYes() throws Exception {
    public void testStdinLong() throws Exception {
        String password = "keystorepassword";
        );
            execute("-x", "foo");
    }
 * Licensed to Elasticsearch under one or more contributor
/*
        createKeystore(password, "foo", "bar");
    public void testOverwritePromptExplicitNo() throws Exception {
    public void testStdinShort() throws Exception {
        terminal.addSecretInput("value");
    }
 * You may obtain a copy of the License at
        assertSecureString("foo", "value", password);
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        final String password = "keystorepassword";
        execute("--force", "foo"); // force
            e.getMessage(),
import static org.hamcrest.Matchers.anyOf;
    }
    }
        String password = "keystorepassword";
        createKeystore(password, "foo", "bar");
        assertThat(e.getMessage(), containsString("the setting names can not be empty"));
 *
        String password = "keystorepassword";
import java.nio.charset.StandardCharsets;
        terminal.addTextInput("n"); // explicit no
        terminal.addSecretInput(password);
        UserException e = expectThrows(UserException.class, () -> execute("foo2"));
        createKeystore(password, "foo", "bar");
        String password = "keystorepassword";
        execute("foo");
import org.opensearch.env.Environment;
 * specific language governing permissions and limitations
import org.opensearch.cli.Command;
        final int stringSize = randomIntBetween(8, 16);
package org.opensearch.tools.cli.keystore;
        assertSecureString("foo", "Typedthisandhitenter", password);
        final String key = randomAlphaOfLength(4) + '@' + randomAlphaOfLength(4);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        terminal.addSecretInput("thewrongpassword");
import org.opensearch.cli.UserException;
        final String password = "keystorepassword";
        return new AddStringKeyStoreCommand() {
        String password = "keystorepassword";
        String password = "keystorepassword";
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.hasToString;
    }
    @Override
    public void testMissingSettingName() throws Exception {
    public void testStdinInputWithCarriageReturn() throws Exception {
        final String password = "keystorepassword";
    }
        execute("-x", "foo");
        assertNull(KeyStoreWrapper.load(env.configDir()));
import org.opensearch.common.settings.KeyStoreWrapper;
            assertSecureString("foo", secretChars.toString(), password);
        terminal.addSecretInput("and yet another secret value");
            setInput(secretChars.toString());
        UserException e = expectThrows(UserException.class, this::execute);
    }
    InputStream input;
        setInput("bar1\nbar2\nbar3");
    }
    }
        assertSecureString("foo", "bar", "");
        terminal.addTextInput("n"); // explicit no
import java.util.Map;
        terminal.addTextInput("y");
/*
        terminal.addSecretInput(password);
        setInput("Typedthisandhitenter\n");
    }
        terminal.addTextInput("");
        createKeystore(password, "foo", "bar");
 * this file be licensed under the Apache-2.0 license or a
    }
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        assertThat(
        terminal.addSecretInput(password);
        String password = "keystorepassword";
        };
    public void testSpecialCharacterInName() throws Exception {
 * under the License.
                containsString("Keystore has been corrupted or tampered with")
        execute("foo");
        assertSecureString("foo1", "bar1", password);
            }
        execute("foo");
        setInput("secret value 2");
        }
        assertSecureString("foo", "secret value", password);
        assertSecureString("foo2", "bar2", password);
        assertSecureString("foo1", "bar1", password);
 *
        assertEquals(ExitCodes.USAGE, e.exitCode);
