 *
        assertPrinted(terminal, Terminal.Verbosity.NORMAL, "This message contains percent like %20n");
        assertNotPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
    }
        try (StringReader reader = new StringReader(source)) {
        terminal.addTextInput("y");
            IllegalStateException.class,
        MockTerminal terminal = new MockTerminal();
 *
    }
 * license agreements. See the NOTICE file distributed with
        terminal = new MockTerminal();
        assertPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
 * under the License.
 * this work for additional information regarding copyright
            for (String exp : expected) {
    public void testTerminalReusesBufferedReaders() throws Exception {
        terminal.addTextInput("y");
 * this file be licensed under the Apache-2.0 license or a
        logTerminal.println(verbosity, text);
    }
        logTerminal.errorPrintln(verbosity, text);
    }
        MockTerminal terminal = new MockTerminal();
            char[] result;
 *
        MockTerminal terminal = new MockTerminal();
        assertFalse(terminal.promptYesNo("Answer?", true));
    private void assertRead(String source, String expected) {
        terminal.addTextInput(null);
        assertRead("hellohello\n", "hellohello");
    }
public class TerminalTests extends OpenSearchTestCase {
        assertErrorPrinted(terminal, Terminal.Verbosity.SILENT, "text");
        terminal.setVerbosity(Terminal.Verbosity.VERBOSE);
    public void testPromptYesNoReprompt() throws Exception {
    public void testVerbosity() throws Exception {
        assertPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
        assertRead("hello\n", "hello");
        terminal = new MockTerminal();
        assertPrinted(terminal, Terminal.Verbosity.SILENT, "text");
            expectThrows(RuntimeException.class, "Input exceeded maximum length of 10", () -> readLineToCharArray(reader, 10));
        try (StringReader reader = new StringReader(source)) {
    private void assertErrorPrinted(MockTerminal logTerminal, Terminal.Verbosity verbosity, String text) throws Exception {
 * The OpenSearch Contributors require contributions made to
    }
    }
 * software distributed under the License is distributed on an
        assertRead("hellohello\r\n", "hellohello");
        terminal.addTextInput("");
        assertErrorNotPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
    }
    private void assertPrinted(MockTerminal logTerminal, Terminal.Verbosity verbosity, String text) throws Exception {
            "Secret exceeded maximum length of ",
        assertPrinted(terminal, Terminal.Verbosity.SILENT, "text");
        assertReadLines("one\ntwo\n\nthree", "one", "two", "", "three");
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    }
                assertThat(result, equalTo(exp.toCharArray()));
        logTerminal.reset();
        assertErrorPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
        terminal.addTextInput("blah");
        terminal = new MockTerminal();
        MockTerminal terminal = new MockTerminal();
        terminal.addTextInput("");
        assertErrorNotPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
        terminal.addTextInput("Y");
            }
        MockTerminal terminal = new MockTerminal();
 * the Apache License, Version 2.0 (the "License"); you may
        assertReadLines("hello\nhello\n", "hello", "hello");
 * KIND, either express or implied.  See the License for the
        assertTrue(output, output.isEmpty());
        }
    }
        assertFalse(terminal.promptYesNo("Answer?", true));
        MockTerminal terminal = new MockTerminal();
        Terminal.SystemTerminal terminal = new Terminal.SystemTerminal();
        MockTerminal terminal = new MockTerminal();
        assertTrue(terminal.promptYesNo("Answer? [Y/n]\nDid not understand answer 'blah'\nAnswer? [Y/n]", true));
 */
        terminal.addTextInput("N");
        assertRead("hello\r\n", "hello");
        assertTrue(terminal.promptYesNo("Answer?", false));
/*
}
 */
        assertRead("\n", "");
        assertPrinted(terminal, Terminal.Verbosity.SILENT, "text");
        assertRead("\r\n", "");
        String output = logTerminal.getErrorOutput();
    private void assertReadLines(String source, String... expected) {
        terminal.setVerbosity(Terminal.Verbosity.SILENT);
        }
        }
        BufferedReader reader2 = terminal.getReader();
        assertTrue(output, output.isEmpty());
        logTerminal.errorPrintln(verbosity, text);
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(output, output.contains(text));
        assertNotPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertReadLines("hello\r\nhello\r\n", "hello", "hello");
        BufferedReader reader1 = terminal.getReader();
        String output = logTerminal.getOutput();
import org.opensearch.test.OpenSearchTestCase;
    public void testSystemTerminalReadsSingleLines() throws Exception {
 * You may obtain a copy of the License at
            () -> terminal.readSecret("Secret? ", secret.length() - 1)
        assertErrorPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
import java.io.BufferedReader;
    public void testSystemTerminalLineExceedsMaxCharacters() throws Exception {
    private void assertNotPrinted(MockTerminal logTerminal, Terminal.Verbosity verbosity, String text) throws Exception {
        assertReadLines("one\r\ntwo\r\n\r\nthree", "one", "two", "", "three");
 * ownership. Elasticsearch licenses this file to you under
        assertTrue(output, output.contains(text));
        assertNotPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
    }
    }
    public void testErrorVerbosity() throws Exception {
import static org.opensearch.cli.Terminal.readLineToCharArray;
        assertSame("System terminal should not create multiple buffered readers", reader1, reader2);
        assertFalse(terminal.promptYesNo("Answer?", false));
        String output = logTerminal.getErrorOutput();
    public void testEscaping() throws Exception {
            char[] result = readLineToCharArray(reader, 10);
    private void assertErrorNotPrinted(MockTerminal logTerminal, Terminal.Verbosity verbosity, String text) throws Exception {
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * compatible open source license.
            assertThat(result, equalTo(expected.toCharArray()));
import java.io.StringReader;
        assertErrorPrinted(terminal, Terminal.Verbosity.SILENT, "text");
        expectThrows(
        terminal.addSecretInput(secret);
 * GitHub history for details.
        String secret = "A very long secret, too long in fact for our purposes.";
        terminal.setVerbosity(Terminal.Verbosity.VERBOSE);
        assertFalse(terminal.promptYesNo("Answer?", false));
/*
    }
    public void testPromptYesNoDefault() throws Exception {
    }
    }
/*
import static org.hamcrest.Matchers.equalTo;
        logTerminal.println(verbosity, text);
    }
        );
        terminal.setVerbosity(Terminal.Verbosity.SILENT);
    public void testPromptYesNoCase() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertErrorPrinted(terminal, Terminal.Verbosity.SILENT, "text");
 */
        terminal = new MockTerminal();
                result = readLineToCharArray(reader, 10);
    public void testSystemTerminalReadsMultipleLines() throws Exception {
        assertErrorPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
        logTerminal.reset();
        String output = logTerminal.getOutput();
        assertTrue(terminal.promptYesNo("Answer?", false));
        assertErrorNotPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
    public void testMaxSecretLength() throws Exception {
        try (StringReader reader = new StringReader("hellohellohello!\n")) {
        assertPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
 * Licensed to Elasticsearch under one or more contributor
package org.opensearch.cli;
    }
        terminal.addTextInput("n");
        assertTrue(terminal.promptYesNo("Answer?", true));
