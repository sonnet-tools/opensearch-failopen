        createKeystore(password);  
        terminal.addSecretInput(password);
        assertSecureString("foo", "secret value", password);
        assertSecureString("foo", "value", password);
        final String exceptionString = "Setting name [" + key + "] does not match the allowed setting name pattern [[A-Za-z0-9_\\-.]+]";
    public void testStdinShort() throws Exception {
    }  
        final String password = "keystorepassword";  
        String password = "keystorepassword";  
        createKeystore(password, "foo", "bar");
        execute("foo");
 * this work for additional information regarding copyright
        terminal.addSecretInput(password);
        execute("foo");  
        terminal.addSecretInput("value");
    public void testStdinWithMultipleValues() throws Exception {
        setInput("secret value 2");  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 */
    }
        terminal.addSecretInput("thewrongpassword");
            setInput(secretChars.toString());
    public void testOverwriteForceShort() throws Exception {
            InputStream getStdin() {
 *  
        terminal.addSecretInput(password);
        execute("-f", "foo");
        execute("-f", "foo"); // force  
import static org.hamcrest.Matchers.hasToString;  
 * under the License.  
        assertSecureString("foo", "newvalue", password);
    }  
        assertSecureString("foo2", "bar2", password);  
        String password = "keystorepassword";  
        terminal.addTextInput("");  
        setInput("secret value 1");  
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());  
/*
 */  
    }
        assertThat(e.getMessage(), containsString("the setting names can not be empty"));  
        assertSecureString("foo1", "bar1", password);  
import java.util.Map;
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        );
    public void testStdinLong() throws Exception {
        assertSecureString("foo", "newvalue", password);
 * software distributed under the License is distributed on an
        execute("-x", "foo");
    protected Command newCommand() {  
        terminal.addTextInput("y");  
package org.opensearch.tools.cli.keystore;
            }  
    public void testAddUtf8String() throws Exception {
 * You may obtain a copy of the License at  
        final String password = "keystorepassword";
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);
    }  
        terminal.addSecretInput("bar");
    public void testStdinInputWithCarriageReturn() throws Exception {
        final UserException e = expectThrows(UserException.class, () -> execute(key));  
        return new AddStringKeyStoreCommand() {
            @Override
        String password = "keystorepassword";
import org.opensearch.cli.Command;
    @Override
        assertSecureString("foo", "", password);
        UserException e = expectThrows(UserException.class, () -> execute("foo2"));  
        terminal.addSecretInput(password);
import static org.hamcrest.Matchers.anyOf;
        terminal.addSecretInput("value");
        assertSecureString("foo", "secret value 2", password);
import org.opensearch.env.Environment;
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * The OpenSearch Contributors require contributions made to  
        String password = "keystorepassword";
        terminal.addSecretInput(password);  
        terminal.addSecretInput(password);
        terminal.addSecretInput(password);
    public void testOverwriteForceLong() throws Exception {
import org.opensearch.common.settings.KeyStoreWrapper;
import java.io.CharArrayWriter;
        execute("-x", "foo");
        String password = "keystorepassword";
    }
        String password = "keystorepassword";  
    }  
    public void testPromptForMultipleValues() throws Exception {
 * GitHub history for details.
        terminal.addSecretInput(password);
 * KIND, either express or implied.  See the License for the
    public void testForceNonExistent() throws Exception {
        assertThat(e, hasToString(containsString(exceptionString)));
public class AddStringKeyStoreCommandTests extends KeyStoreCommandTestCase {
    public void testMissingNoCreate() throws Exception {  
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        assertSecureString("foo3", "bar3", password);
        UserException e = expectThrows(UserException.class, this::execute);
 * Unless required by applicable law or agreed to in writing,
            )
            @Override
        String password = "keystorepassword";
        terminal.addTextInput("n"); // explicit no
        terminal.addSecretInput(password);
        terminal.addSecretInput(password);
        terminal.addSecretInput(password);
    }
        final int stringSize = randomIntBetween(8, 16);
    }
    }
                return env;
        execute("--stdin", "foo");
    }  
    }
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());  
    public void testOverwritePromptExplicitNo() throws Exception {  
            protected Environment createEnv(Map<String, String> settings) throws UserException {  
        terminal.addTextInput("");
        createKeystore(password, "foo", "bar");  
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        try (CharArrayWriter secretChars = new CharArrayWriter(stringSize)) {  
/*  
        createKeystore(password, "foo", "bar");
        createKeystore(password, "foo", "bar");
            assertSecureString("foo", secretChars.toString(), password);  
        createKeystore(password);  
    public void testMissingPromptCreateWithoutPasswordWithoutPromptIfForced() throws Exception {  
        terminal.addSecretInput("newvalue");
    public void testMissingPromptCreateWithoutPasswordWhenPrompted() throws Exception {
    }
    public void testMissingSettingName() throws Exception {
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());  
            execute("-x", "foo");
        setInput("");  
        assertSecureString("foo", "secret value 1", password);
        setInput("Typedthisandhitenter\r");  
        setInput("Typedthisandhitenter\n");  
        assertSecureString("foo", "bar", "");  
        final String key = randomAlphaOfLength(4) + '@' + randomAlphaOfLength(4);
            }
import org.opensearch.cli.ExitCodes;
        terminal.addSecretInput("newvalue");
        assertSecureString("foo", "bar", "");  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testStdinInputWithLineBreaks() throws Exception {
 * not use this file except in compliance with the License.
        assertEquals(ExitCodes.USAGE, e.exitCode);
        // will not be prompted for a password  
        terminal.addSecretInput(password);  
        execute("foo");  
        assertSecureString("foo", "bar", password);
                secretChars.write((char) randomIntBetween(129, 2048));
        setInput("bar1\nbar2\nbar3");  
        }
    }  
        input = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));  
import java.io.InputStream;  
        assertSecureString("foo", "bar", password);  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cli.UserException;  
    }
 *
        terminal.addTextInput("n"); // explicit no
        execute("--force", "foo"); // force  
            e.getMessage(),  
        String password = "keystorepassword";  
 * license agreements. See the NOTICE file distributed with
        createKeystore(password, "foo", "bar");  
    }
            }
/*  
}
        assertSecureString("foo2", "bar2", password);
        terminal.addTextInput("y");  
        terminal.addSecretInput("bar3");
        assertSecureString("foo", "and yet another secret value", password);
    }  
        execute("-x", "foo");
 * Modifications Copyright OpenSearch Contributors. See
        terminal.addSecretInput(password);
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
        execute(randomFrom("-x", "--stdin"), "foo1", "foo2", "foo3");
        String password = "keystorepassword";  
import java.nio.charset.StandardCharsets;
        terminal.addSecretInput("bar");
    }
        terminal.addSecretInput("and yet another secret value");
            for (int i = 0; i < stringSize; i++) {
import java.io.ByteArrayInputStream;
    public void testOverwritePromptExplicitYes() throws Exception {  
        execute("--force", "foo"); // force  
        terminal.addSecretInput(password);
        assertNull(KeyStoreWrapper.load(env.configDir()));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        terminal.addSecretInput("bar2");  
        terminal.addSecretInput(password);  
        execute("foo");
        terminal.addSecretInput("secret value");
        final String password = "keystorepassword";
    public void testAddToUnprotectedKeystore() throws Exception {
        terminal.addSecretInput(password);
import static org.hamcrest.Matchers.containsString;
    public void testInvalidPassphrease() throws Exception {
    public void testSpecialCharacterInName() throws Exception {  
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
 *
        terminal.addSecretInput(password);
        execute("foo");
                return input;  
            anyOf(
    public void testStdinNoInput() throws Exception {
        createKeystore(password);
        execute("foo");
        terminal.addSecretInput("bar1");
        String password = "";  
 * compatible open source license.
    }
                containsString("Provided keystore password was incorrect"),
        String password = "keystorepassword";
        String password = "keystorepassword";  
        String password = "keystorepassword";
    }
        String password = "keystorepassword";
        execute("-x", "foo");
        execute("foo1", "foo2", "foo3");
        };
        terminal.addTextInput("");
        String password = "keystorepassword";
        assertSecureString("foo", "Typedthisandhitenter", password);
        execute("foo");
        String password = "keystorepassword";
        assertSecureString("foo", "Typedthisandhitenter", password);
                containsString("Keystore has been corrupted or tampered with")  
        createKeystore(password, "foo", "bar");
        assertSecureString("foo1", "bar1", password);
        KeyStoreWrapper.create().save(env.configDir(), password.toCharArray());
    InputStream input;  
 * this file be licensed under the Apache-2.0 license or a
        assertSecureString("foo3", "bar3", password);
        createKeystore(password, "foo", "bar");
        terminal.addSecretInput(password);
    }  
        assertThat(
    }  
    }
    public void testOverwritePromptDefault() throws Exception {  
    void setInput(String inputStr) {
        assertSecureString("foo", "bar", password);  
    public void testPromptForValue() throws Exception {
