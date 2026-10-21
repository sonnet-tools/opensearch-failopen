        IllegalStateException e = expectThrows(IllegalStateException.class, this::execute);
        assertTrue(output, output.contains("A dummy subcommand"));
 * Modifications Copyright OpenSearch Contributors. See
        UserException e = expectThrows(UserException.class, () -> execute("somethingelse"));
    public void testErrorDisplayedWithDefault() throws Exception {
import java.util.List;
        assertEquals(ExitCodes.USAGE, e.exitCode);
        multiCommand.subcommands.put("command1", new DummySubCommand());
            assertEquals("Error occurred while closing DummySubCommand", ioe.getMessage());
    @Before
 * ownership. Elasticsearch licenses this file to you under
        execute("command2", "-h");
    }
        });
        mc.subcommands.put("throw", new ErrorThrowingSubCommand() {
        assertTrue(output, output.contains("command2"));
        @Override
 *
    }
    }
            // properly.
        multiCommand.subcommands.put("command2", subCommand2);
        MultiCommand mc = new ErrorHandlingMultiCommand();
        UserException e = expectThrows(UserException.class, this::execute);
        @Override
}
        }
        assertTrue("SubCommand1 was not closed when close method is invoked", subCommand1.closeCalled.get());
        ErrorHandlingMultiCommand() {
    /**
    }
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at
        assertEquals(ExitCodes.USAGE, e.exitCode);
        final boolean command1Throws = randomBoolean();
            super.execute(terminal, options);
import joptsimple.ArgumentAcceptingOptionSpec;
 */
    }
    }
        protected boolean addShutdownHook() {
    }
        } else {
        assertFalse(output, output.contains("command1"));
        assertTrue("SubCommand2 was not closed when close method is invoked", subCommand2.closeCalled.get());
        }
    }
    static class DummyMultiCommand extends MultiCommand {
    protected Command newCommand() {
        DummySubCommand subCommand1 = new DummySubCommand();
        multiCommand.subcommands.put("command1", new DummySubCommand());
 */
        mc.main(new String[] { "throw", "--silent" }, terminal);
        multiCommand.subcommands.put("command2", new DummySubCommand());
        DummySubCommand() {
    }
                assertTrue("Missing suppressed exceptions", ioe.getSuppressed()[0] instanceof IOException);
    public void testSubcommandArguments() throws Exception {
            if (command1Throws && command2Throws) {
        multiCommand.subcommands.put("command1", new DummySettingsSubCommand());
        multiCommand.subcommands.put("command1", subCommand1);
    public void testNullErrorMessageSuppressesErrorOutput() throws Exception {
        multiCommand.subcommands.put("command2", new DummySubCommand());
            return false;
 * GitHub history for details.
            if (throwsExceptionOnClose) {
        assertFalse(output, output.contains("command1"));
            return false;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        DummySubCommand subCommand2 = new DummySubCommand();
        final AtomicBoolean closeCalled = new AtomicBoolean();
        public void close() throws IOException {
        DummySettingsSubCommand() {
        ErrorThrowingSubCommand() {
        @Override
    }
                throw new UserException(1, null);
        execute("-h");
        @Override
import org.junit.Before;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        String output = terminal.getOutput();
            super("error catching", () -> {});
package org.opensearch.cli;
    static class ErrorHandlingMultiCommand extends MultiCommand {
        assertThat(output, containsString("Settings: [setting1=value1, setting2=value2]"));
     */
    }
        multiCommand.subcommands.put("command1", new DummySubCommand());
     * and passed on to the subcommand.
     * Check that if -E arguments are passed to the main command, then they are accepted
    }
 *
        }
        protected boolean addShutdownHook() {
        }
        String output = terminal.getOutput();
/*
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
import static org.hamcrest.Matchers.containsString;
        assertThat(terminal.getErrorOutput(), equalTo("ERROR: Dummy error\n"));
        String output = terminal.getOutput();
        final DummySubCommand subCommand1 = new DummySubCommand(command1Throws);
 * not use this file except in compliance with the License.
        MockTerminal terminal = new MockTerminal();
        }
            this.throwsExceptionOnClose = throwsExceptionOnClose;
import static org.hamcrest.Matchers.equalTo;
        }
 * compatible open source license.
        assertTrue("SubCommand1 was not closed when close method is invoked", subCommand1.closeCalled.get());
                throw new IllegalStateException("DummySubCommand already closed");
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (this.closed.compareAndSet(false, true) == false) {
    private DummyMultiCommand multiCommand;
 * SPDX-License-Identifier: Apache-2.0
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
            throw new UserException(1, "Dummy error");
        return multiCommand;
    // Tests for multicommand error logging
        }
                throw new IOException("Error occurred while closing DummySubCommand");
            terminal.println("Settings: " + values);
        assertTrue(output, output.contains("Arguments: [foo, bar]"));
public class MultiCommandTests extends CommandTestCase {
            multiCommand.close();
            super("A dummy multi command", () -> {});
        assertTrue(output, output.contains("command1"));
        @Override
            }
import joptsimple.OptionSet;
        multiCommand.close();
        multiCommand.subcommands.put("command1", new DummySubCommand());
 * Licensed to Elasticsearch under one or more contributor
    static class DummySubCommand extends Command {
 * this work for additional information regarding copyright
        MultiCommand mc = new ErrorHandlingMultiCommand();
    public void testSettingsOnMainCommand() throws Exception {
            terminal.println("Arguments: " + options.nonOptionArguments().toString());
        public void close() throws IOException {
            this.settingOption = parser.accepts("E", "Configure a setting").withRequiredArg().ofType(KeyValuePair.class);
        assertEquals("No subcommands configured", e.getMessage());
    static class DummySettingsSubCommand extends DummySubCommand {
        assertThat(terminal.getOutput(), is(emptyString()));
        String output = terminal.getOutput();
        MockTerminal terminal = new MockTerminal();
        mc.subcommands.put("throw", new ErrorThrowingSubCommand());
        assertEquals("Unknown command [somethingelse]", e.getMessage());
            if (this.closeCalled.compareAndSet(false, true) == false) {
        }
        multiCommand.subcommands.put("something", new DummySubCommand());
            protected void execute(Terminal terminal, OptionSet options) throws Exception {
/*
        multiCommand = new DummyMultiCommand();
    static class ErrorThrowingSubCommand extends Command {
            super("error throwing", () -> {});
                assertEquals(1, ioe.getSuppressed().length);
            super.close();
        assertThat(terminal.getOutput(), is(emptyString()));
            this(false);
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
 * under the License.
        final boolean throwsExceptionOnClose;
        assertTrue("MultiCommand was not closed when close method is invoked", multiCommand.closed.get());
import joptsimple.util.KeyValuePair;
        execute("command1", "foo", "bar");
import static org.hamcrest.Matchers.is;
 * The OpenSearch Contributors require contributions made to
            final List<KeyValuePair> values = this.settingOption.values(options);
 *
        final AtomicBoolean closed = new AtomicBoolean();
    public void testNoCommandsConfigured() {
        }
 * this file be licensed under the Apache-2.0 license or a
        DummyMultiCommand() {
            super("A dummy subcommand", () -> {});
        @Override
    public void testMissingCommand() {
    public void testClose() throws Exception {
    }
            IOException ioe = expectThrows(IOException.class, multiCommand::close);
            @Override
    }
        assertEquals("Missing command", e.getMessage());
        DummySubCommand(final boolean throwsExceptionOnClose) {
        private final ArgumentAcceptingOptionSpec<KeyValuePair> settingOption;
            }
    public void testSubcommandHelp() throws Exception {
        final DummySubCommand subCommand2 = new DummySubCommand(command2Throws);
    }
            }
        mc.main(new String[] { "throw", "--silent" }, terminal);
        multiCommand.subcommands.put("command1", subCommand1);
/*
            }
import java.io.IOException;
        }
        }
            }
    }
        @Override
                throw new IllegalStateException("DummyMultiCommand already closed");
    }
        if (command1Throws || command2Throws) {
import static org.hamcrest.Matchers.emptyString;
                assertEquals("Error occurred while closing DummySubCommand", ioe.getSuppressed()[0].getMessage());
        final boolean command2Throws = randomBoolean();
        assertThat(output, containsString("Arguments: [otherArg]"));
    @Override
        assertTrue("SubCommand2 was not closed when close method is invoked", subCommand2.closeCalled.get());
    public void testUnknownCommand() {
        }
        execute("-Esetting1=value1", "-Esetting2=value2", "command1", "otherArg");
import java.util.concurrent.atomic.AtomicBoolean;
        }
    public void testCloseWhenSubCommandCloseThrowsException() throws Exception {
        multiCommand.subcommands.put("command2", subCommand2);
 */
    public void testHelp() throws Exception {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(terminal.getErrorOutput(), is(emptyString()));
 * software distributed under the License is distributed on an
            super();
    public void setupCommand() {
            // verify exception is thrown, as well as other non failed sub-commands closed
        }
