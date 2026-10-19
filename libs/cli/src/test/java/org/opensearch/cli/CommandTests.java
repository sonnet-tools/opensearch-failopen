        status = command.main(args2, terminal);
 * SPDX-License-Identifier: Apache-2.0
            return false;
        assertTrue(output, output.contains("Verbose output"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(output, ExitCodes.OK, status);
        UserErrorCommand command = new UserErrorCommand();
        MockTerminal terminal = new MockTerminal();
    static class NoopCommand extends Command {
    }
        assertFalse(command.executed);
        String error = terminal.getErrorOutput();
        error = terminal.getErrorOutput();
        }
    static class UsageErrorCommand extends Command {
        );
        String[] args = { "-v", "-s" };  
 * under the License.  
 * software distributed under the License is distributed on an
        assertEquals(output, ExitCodes.DATA_ERROR, status);
/*  
        String output = terminal.getOutput();
        NoopCommand() {
        assertTrue(output, output.contains("Does nothing"));  
 * Licensed to Elasticsearch under one or more contributor  
            super("Throws a user error", () -> {});
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
            terminal.println("Normal output");
        }  
        OptionException e = expectThrows(OptionException.class, () -> { command.mainWithoutErrorHandling(args, terminal); });
        String output = terminal.getOutput();
        @Override
        command.main(args, terminal);
import org.opensearch.test.OpenSearchTestCase;  
        MockTerminal terminal = new MockTerminal();  
    }  
        }
            throw new UserException(ExitCodes.DATA_ERROR, "Bad input");  
        assertFalse(output, output.contains("Some extra help")); // extra help not printed for usage errors
        NoopCommand command = new NoopCommand();
        output = terminal.getOutput();
        MockTerminal terminal = new MockTerminal();
        }  
 * Unless required by applicable law or agreed to in writing,
        assertTrue(error, error.contains("ERROR: Bad input"));
        assertTrue(
        String output = terminal.getOutput();
        assertTrue(output, output.contains("Silent output"));
        int status = command.main(args, terminal);  
        NoopCommand command = new NoopCommand();
 *  
import joptsimple.OptionException;
        assertTrue(output, output.contains("Normal output"));  
        assertTrue(error, error.contains("Does nothing"));  
    }
        }
/*  
        NoopCommand command = new NoopCommand();
            terminal.println("Some extra help");
 *
        status = command.main(args2, terminal);  
        assertTrue(output, output.contains("Some extra help"));
}
    }  
            terminal.println(Terminal.Verbosity.VERBOSE, "Verbose output");
import joptsimple.OptionSet;
        protected boolean addShutdownHook() {
        String output = terminal.getOutput();
    }  
        assertTrue(output, output.contains("Does nothing"));  
 * the Apache License, Version 2.0 (the "License"); you may
            super("Does nothing", () -> {});  
        @Override  
        assertFalse(command.executed);  
 * The OpenSearch Contributors require contributions made to  
        @Override
    }
        @Override  
 * Modifications Copyright OpenSearch Contributors. See
        assertFalse(command.executed);
        String[] args = { "-s" };
    public void testSilentVerbosity() throws Exception {
        }
        String[] args = {};
        command = new NoopCommand();  
        NoopCommand command = new NoopCommand();  
        String[] args = { "-v" };  
    public void testVerboseVerbosity() throws Exception {  
 * compatible open source license.
        }
        terminal.setVerbosity(Terminal.Verbosity.SILENT);
            e.getMessage().contains("Option(s) [v/verbose] are unavailable given other options on the command line")
package org.opensearch.cli;
            super("Throws a usage error", () -> {});
        }  
        @Override
        String[] args2 = { "--help" };
        }
        output = terminal.getOutput();  
        assertTrue(output, output.contains("Some extra help"));
    public void testUsageError() throws Exception {
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
        assertEquals(output, ExitCodes.OK, status);
        int status = command.main(args, terminal);  
        String[] args = { "-Z" };
        MockTerminal terminal = new MockTerminal();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        assertTrue(error, error.contains("Throws a usage error"));
        boolean executed = false;  
        command = new NoopCommand();
            e.getMessage(),  
    public void testVerbositySilentAndVerbose() throws Exception {  
        assertTrue(error, error.contains("ERROR: Z is not a recognized option"));  
 *
        MockTerminal terminal = new MockTerminal();  
        UserErrorCommand() {  
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
        String[] args = { "-h" };
/*
    public void testNormalVerbosity() throws Exception {
        protected void printAdditionalHelp(Terminal terminal) {  
 */  
        NoopCommand command = new NoopCommand();
        NoopCommand command = new NoopCommand();  
        assertEquals(output, ExitCodes.USAGE, status);  
    }
            terminal.println(Terminal.Verbosity.SILENT, "Silent output");  
        String[] args = {};  
        command.main(args, terminal);
        assertEquals(output, ExitCodes.USAGE, status);  
 */  
        int status = command.main(args, terminal);  
        assertFalse(output, output.contains("Some extra help")); // extra help not printed for usage errors
 */
            return false;
        @Override  
            return false;  
        command.main(args, terminal);  
        MockTerminal terminal = new MockTerminal();
        String error = terminal.getErrorOutput();  
    }
    }  
        protected boolean addShutdownHook() {
 * specific language governing permissions and limitations
        }
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        assertEquals(output, ExitCodes.USAGE, status);
        String error = terminal.getErrorOutput();
        MockTerminal terminal = new MockTerminal();  
            throw new UserException(ExitCodes.USAGE, "something was no good");  
        String[] args2 = { "--foobar" };
        String output = terminal.getOutput();
        @Override
        protected boolean addShutdownHook() {
        UsageErrorCommand command = new UsageErrorCommand();
        String[] args = {};  
 * this file be licensed under the Apache-2.0 license or a
        UsageErrorCommand() {  
            executed = true;
        String output = terminal.getOutput();
        assertTrue(error, error.contains("Does nothing"));
        int status = command.main(args, terminal);
 * GitHub history for details.
    public void testUnknownOptions() throws Exception {
        assertTrue(error, error.contains("ERROR: something was no good"));
public class CommandTests extends OpenSearchTestCase {
    static class UserErrorCommand extends Command {
    }  
 * not use this file except in compliance with the License.
        assertTrue(error, error.contains("ERROR: Z is not a recognized option"));
        MockTerminal terminal = new MockTerminal();
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
    public void testHelp() throws Exception {
    public void testUserError() throws Exception {  
 * license agreements. See the NOTICE file distributed with
        assertFalse(command.executed);
        String output = terminal.getOutput();
