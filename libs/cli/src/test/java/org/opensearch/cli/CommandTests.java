        String[] args = { "-v" };
 *
    public void testSilentVerbosity() throws Exception {
 * specific language governing permissions and limitations
        assertTrue(error, error.contains("Does nothing"));
    }
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            super("Does nothing", () -> {});
        NoopCommand command = new NoopCommand();
            terminal.println(Terminal.Verbosity.VERBOSE, "Verbose output");
        String output = terminal.getOutput();
 */
        }
    static class NoopCommand extends Command {
        UserErrorCommand() {
            terminal.println("Normal output");
/*
        String[] args = { "-Z" };
        output = terminal.getOutput();
 * Unless required by applicable law or agreed to in writing,
/*
    static class UsageErrorCommand extends Command {
        String output = terminal.getOutput();
    }
        assertFalse(command.executed);
        assertTrue(output, output.contains("Normal output"));
        assertEquals(output, ExitCodes.USAGE, status);
        protected boolean addShutdownHook() {
        protected boolean addShutdownHook() {
        assertEquals(output, ExitCodes.USAGE, status);
        terminal.setVerbosity(Terminal.Verbosity.SILENT);
        }
        assertEquals(output, ExitCodes.OK, status);
    public void testHelp() throws Exception {
        status = command.main(args2, terminal);
        MockTerminal terminal = new MockTerminal();
        assertTrue(error, error.contains("ERROR: Z is not a recognized option"));
        UserErrorCommand command = new UserErrorCommand();
    }
        @Override
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
import org.opensearch.test.OpenSearchTestCase;
        MockTerminal terminal = new MockTerminal();
        String output = terminal.getOutput();
        assertTrue(error, error.contains("ERROR: something was no good"));
            throw new UserException(ExitCodes.USAGE, "something was no good");
        output = terminal.getOutput();
 * Licensed to Elasticsearch under one or more contributor
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
        protected boolean addShutdownHook() {
        UsageErrorCommand() {
            super("Throws a user error", () -> {});
        }
        MockTerminal terminal = new MockTerminal();
 * ownership. Elasticsearch licenses this file to you under
        assertTrue(error, error.contains("Does nothing"));
    }
        MockTerminal terminal = new MockTerminal();
        String[] args = {};
        NoopCommand() {
        status = command.main(args2, terminal);
}
    }
 * software distributed under the License is distributed on an
    public void testNormalVerbosity() throws Exception {
        int status = command.main(args, terminal);
        assertFalse(output, output.contains("Some extra help")); // extra help not printed for usage errors
        boolean executed = false;
    public void testVerbositySilentAndVerbose() throws Exception {
        String error = terminal.getErrorOutput();
            super("Throws a usage error", () -> {});
    public void testUserError() throws Exception {
        NoopCommand command = new NoopCommand();
        protected void printAdditionalHelp(Terminal terminal) {
        String error = terminal.getErrorOutput();
        @Override
        assertTrue(output, output.contains("Silent output"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(output, ExitCodes.USAGE, status);
 * license agreements. See the NOTICE file distributed with
    public void testUnknownOptions() throws Exception {
 */
        @Override
    }
        int status = command.main(args, terminal);
 * the Apache License, Version 2.0 (the "License"); you may
        }
        MockTerminal terminal = new MockTerminal();
        command.main(args, terminal);
            executed = true;
            e.getMessage(),
            return false;
 * under the License.
        assertTrue(output, output.contains("Does nothing"));
 * Modifications Copyright OpenSearch Contributors. See
        String output = terminal.getOutput();
import joptsimple.OptionSet;
        MockTerminal terminal = new MockTerminal();
        assertTrue(output, output.contains("Does nothing"));
    public void testVerboseVerbosity() throws Exception {
        String[] args2 = { "--foobar" };
        NoopCommand command = new NoopCommand();
        String[] args = { "-s" };
        assertTrue(output, output.contains("Some extra help"));
        }
            throw new UserException(ExitCodes.DATA_ERROR, "Bad input");
        assertTrue(error, error.contains("ERROR: Z is not a recognized option"));
    }
/*
 */
        }
            e.getMessage().contains("Option(s) [v/verbose] are unavailable given other options on the command line")
 * GitHub history for details.
        assertTrue(error, error.contains("ERROR: Bad input"));
        assertEquals(output, ExitCodes.OK, status);
        NoopCommand command = new NoopCommand();
        UsageErrorCommand command = new UsageErrorCommand();
        String[] args = {};
        }
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
 * The OpenSearch Contributors require contributions made to
        OptionException e = expectThrows(OptionException.class, () -> { command.mainWithoutErrorHandling(args, terminal); });
        }
        assertTrue(error, error.contains("Throws a usage error"));
        String[] args2 = { "--help" };
        assertTrue(output, output.contains("Verbose output"));
    }
        int status = command.main(args, terminal);
        );
    }
            terminal.println(Terminal.Verbosity.SILENT, "Silent output");
    static class UserErrorCommand extends Command {
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        NoopCommand command = new NoopCommand();
 * this work for additional information regarding copyright
 *
        MockTerminal terminal = new MockTerminal();
        assertFalse(output, output.contains("Some extra help")); // extra help not printed for usage errors
        command.main(args, terminal);
            return false;
        }
        }
package org.opensearch.cli;
        String[] args = { "-v", "-s" };
    }
        assertTrue(
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        MockTerminal terminal = new MockTerminal();
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
 * KIND, either express or implied.  See the License for the
        int status = command.main(args, terminal);
        String output = terminal.getOutput();
        @Override
        String[] args = { "-h" };
        assertEquals(output, ExitCodes.DATA_ERROR, status);
        assertFalse(command.executed);
        assertTrue(output, output.contains("Some extra help"));
        String output = terminal.getOutput();
        NoopCommand command = new NoopCommand();
            terminal.println("Some extra help");
        @Override
        command = new NoopCommand();
import joptsimple.OptionException;
        assertFalse(command.executed);
        error = terminal.getErrorOutput();
        @Override
        command.main(args, terminal);
public class CommandTests extends OpenSearchTestCase {
            return false;
    public void testUsageError() throws Exception {
    }
        command = new NoopCommand();
        String output = terminal.getOutput();
        String[] args = {};
        assertFalse(command.executed);
        String error = terminal.getErrorOutput();
