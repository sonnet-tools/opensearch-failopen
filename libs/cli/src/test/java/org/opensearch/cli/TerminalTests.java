        MockTerminal terminal = new MockTerminal();
    }
        }
        assertTrue(terminal.promptYesNo("Answer?", true));  
        assertErrorPrinted(terminal, Terminal.Verbosity.NORMAL, "text");  
import org.opensearch.test.OpenSearchTestCase;
    private void assertErrorNotPrinted(MockTerminal logTerminal, Terminal.Verbosity verbosity, String text) throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        terminal.addTextInput("y");  
        terminal.addTextInput("Y");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try (StringReader reader = new StringReader("hellohellohello!\n")) {
 * software distributed under the License is distributed on an
        assertTrue(output, output.isEmpty());
        String output = logTerminal.getErrorOutput();  
        assertFalse(terminal.promptYesNo("Answer?", false));
        logTerminal.println(verbosity, text);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        expectThrows(
                result = readLineToCharArray(reader, 10);
        terminal.addTextInput("blah");  
    }
        MockTerminal terminal = new MockTerminal();
        String output = logTerminal.getOutput();  
    }  
 * KIND, either express or implied.  See the License for the
        assertSame("System terminal should not create multiple buffered readers", reader1, reader2);  
    public void testErrorVerbosity() throws Exception {  
            for (String exp : expected) {
        BufferedReader reader2 = terminal.getReader();
 * not use this file except in compliance with the License.
        assertErrorNotPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
        MockTerminal terminal = new MockTerminal();  
        MockTerminal terminal = new MockTerminal();
        assertReadLines("hello\nhello\n", "hello", "hello");
        BufferedReader reader1 = terminal.getReader();
 * this work for additional information regarding copyright
    }
        terminal.addTextInput(null);  
        assertReadLines("one\r\ntwo\r\n\r\nthree", "one", "two", "", "three");  
        terminal = new MockTerminal();  
            IllegalStateException.class,
/*  
    private void assertReadLines(String source, String... expected) {
    public void testPromptYesNoReprompt() throws Exception {
 * license agreements. See the NOTICE file distributed with
        assertPrinted(terminal, Terminal.Verbosity.NORMAL, "This message contains percent like %20n");  
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(output, output.contains(text));
        String output = logTerminal.getErrorOutput();
    public void testMaxSecretLength() throws Exception {
    }  
    private void assertErrorPrinted(MockTerminal logTerminal, Terminal.Verbosity verbosity, String text) throws Exception {
        Terminal.SystemTerminal terminal = new Terminal.SystemTerminal();  
import static org.hamcrest.Matchers.equalTo;
        assertNotPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
            () -> terminal.readSecret("Secret? ", secret.length() - 1)
                assertThat(result, equalTo(exp.toCharArray()));  
        assertErrorPrinted(terminal, Terminal.Verbosity.SILENT, "text");  
    }
        }
        terminal.setVerbosity(Terminal.Verbosity.VERBOSE);  
        terminal.addTextInput("N");
        terminal.setVerbosity(Terminal.Verbosity.SILENT);
        logTerminal.reset();
        MockTerminal terminal = new MockTerminal();  
}
    }
    }
        assertTrue(output, output.contains(text));  
        );
    }  
        assertTrue(output, output.isEmpty());
    }
        terminal.addTextInput("n");
            expectThrows(RuntimeException.class, "Input exceeded maximum length of 10", () -> readLineToCharArray(reader, 10));
import java.io.StringReader;
        assertNotPrinted(terminal, Terminal.Verbosity.NORMAL, "text");  
    private void assertRead(String source, String expected) {  
 * The OpenSearch Contributors require contributions made to  
        terminal.setVerbosity(Terminal.Verbosity.SILENT);
    }  
 *  
/*  
 * GitHub history for details.
        terminal.addTextInput("");
        terminal.addSecretInput(secret);
    }
        assertPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
        assertNotPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");  
        assertFalse(terminal.promptYesNo("Answer?", true));
        }  
            "Secret exceeded maximum length of ",  
        assertFalse(terminal.promptYesNo("Answer?", false));
        terminal = new MockTerminal();  
        assertRead("\n", "");  
        assertTrue(terminal.promptYesNo("Answer?", false));
        logTerminal.reset();
        assertErrorPrinted(terminal, Terminal.Verbosity.NORMAL, "text");  
    }  
        assertRead("hello\n", "hello");  
    }
            char[] result = readLineToCharArray(reader, 10);
        assertRead("hello\r\n", "hello");
        assertReadLines("one\ntwo\n\nthree", "one", "two", "", "three");
        String output = logTerminal.getOutput();
            char[] result;  
        assertTrue(terminal.promptYesNo("Answer?", false));
    public void testTerminalReusesBufferedReaders() throws Exception {
 * under the License.  
        terminal.addTextInput("");
        assertPrinted(terminal, Terminal.Verbosity.NORMAL, "text");
import java.io.BufferedReader;  
    public void testEscaping() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
        assertErrorNotPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
import static org.opensearch.cli.Terminal.readLineToCharArray;  
    public void testPromptYesNoDefault() throws Exception {  
/*
    }  
            assertThat(result, equalTo(expected.toCharArray()));  
 * SPDX-License-Identifier: Apache-2.0
        terminal = new MockTerminal();
 * Unless required by applicable law or agreed to in writing,
        String secret = "A very long secret, too long in fact for our purposes.";
        assertTrue(terminal.promptYesNo("Answer? [Y/n]\nDid not understand answer 'blah'\nAnswer? [Y/n]", true));
package org.opensearch.cli;
    }
        assertErrorPrinted(terminal, Terminal.Verbosity.SILENT, "text");
    private void assertPrinted(MockTerminal logTerminal, Terminal.Verbosity verbosity, String text) throws Exception {  
public class TerminalTests extends OpenSearchTestCase {  
    public void testSystemTerminalLineExceedsMaxCharacters() throws Exception {  
        try (StringReader reader = new StringReader(source)) {
        logTerminal.errorPrintln(verbosity, text);  
        assertPrinted(terminal, Terminal.Verbosity.SILENT, "text");
        logTerminal.println(verbosity, text);
    private void assertNotPrinted(MockTerminal logTerminal, Terminal.Verbosity verbosity, String text) throws Exception {
 */
    public void testPromptYesNoCase() throws Exception {
    }
        terminal.addTextInput("y");
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(terminal.promptYesNo("Answer?", true));  
        assertPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");  
 */  
        assertRead("hellohello\r\n", "hellohello");
    public void testVerbosity() throws Exception {
        terminal = new MockTerminal();
        terminal.setVerbosity(Terminal.Verbosity.VERBOSE);
    public void testSystemTerminalReadsSingleLines() throws Exception {
        assertPrinted(terminal, Terminal.Verbosity.SILENT, "text");
 *
        assertErrorPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
 */  
        assertRead("\r\n", "");
            }
        assertPrinted(terminal, Terminal.Verbosity.SILENT, "text");
        logTerminal.errorPrintln(verbosity, text);
 * compatible open source license.
        try (StringReader reader = new StringReader(source)) {
        assertErrorNotPrinted(terminal, Terminal.Verbosity.VERBOSE, "text");
        MockTerminal terminal = new MockTerminal();  
 * the Apache License, Version 2.0 (the "License"); you may
        assertReadLines("hello\r\nhello\r\n", "hello", "hello");  
        MockTerminal terminal = new MockTerminal();
    public void testSystemTerminalReadsMultipleLines() throws Exception {
        assertRead("hellohello\n", "hellohello");  
        assertErrorPrinted(terminal, Terminal.Verbosity.SILENT, "text");
 *
