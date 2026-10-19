            }
    public void setupCommand() {
        public void close() throws IOException {
    }
        }
 * You may obtain a copy of the License at  
        @Override
        String output = terminal.getOutput();
        assertFalse(output, output.contains("command1"));
    static class DummySubCommand extends Command {
            if (throwsExceptionOnClose) {  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        multiCommand.close();
 * Unless required by applicable law or agreed to in writing,
        protected boolean addShutdownHook() {  
 * KIND, either express or implied.  See the License for the
        assertTrue("SubCommand2 was not closed when close method is invoked", subCommand2.closeCalled.get());
            this.throwsExceptionOnClose = throwsExceptionOnClose;
        assertFalse(output, output.contains("command1"));
 *
    }
     */
import java.io.IOException;  
        private final ArgumentAcceptingOptionSpec<KeyValuePair> settingOption;
import static org.hamcrest.Matchers.emptyString;
            super("error throwing", () -> {});
        execute("command2", "-h");  
        IllegalStateException e = expectThrows(IllegalStateException.class, this::execute);
        }
}
    private DummyMultiCommand multiCommand;
 * specific language governing permissions and limitations
        assertTrue("SubCommand1 was not closed when close method is invoked", subCommand1.closeCalled.get());  
        multiCommand.subcommands.put("something", new DummySubCommand());
        execute("command1", "foo", "bar");
    public void testSettingsOnMainCommand() throws Exception {  
            terminal.println("Settings: " + values);
        DummyMultiCommand() {  
        String output = terminal.getOutput();
        UserException e = expectThrows(UserException.class, this::execute);  
            if (command1Throws && command2Throws) {
        protected void execute(Terminal terminal, OptionSet options) throws Exception {
        final DummySubCommand subCommand1 = new DummySubCommand(command1Throws);
            return false;
    }
            final List<KeyValuePair> values = this.settingOption.values(options);
        assertThat(terminal.getErrorOutput(), equalTo("ERROR: Dummy error\n"));  
    }  
            super("A dummy multi command", () -> {});
        assertTrue("MultiCommand was not closed when close method is invoked", multiCommand.closed.get());
        assertTrue(output, output.contains("command2"));
        assertThat(terminal.getErrorOutput(), is(emptyString()));
        final boolean throwsExceptionOnClose;
 * license agreements. See the NOTICE file distributed with
        assertThat(output, containsString("Arguments: [otherArg]"));  
        }
    static class DummyMultiCommand extends MultiCommand {
        }
    public void testErrorDisplayedWithDefault() throws Exception {  
        assertThat(output, containsString("Settings: [setting1=value1, setting2=value2]"));
        DummySubCommand() {
        assertEquals("Unknown command [somethingelse]", e.getMessage());
 * Modifications Copyright OpenSearch Contributors. See
        multiCommand.subcommands.put("command2", new DummySubCommand());
        final boolean command1Throws = randomBoolean();
        @Override
        assertTrue(output, output.contains("A dummy subcommand"));  
        if (command1Throws || command2Throws) {
 * GitHub history for details.
        MultiCommand mc = new ErrorHandlingMultiCommand();
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
        String output = terminal.getOutput();  
    public void testUnknownCommand() {  
        execute("-h");
        @Override
                assertEquals(1, ioe.getSuppressed().length);
                throw new IllegalStateException("DummyMultiCommand already closed");
     * and passed on to the subcommand.
        protected void execute(Terminal terminal, OptionSet options) throws Exception {  
        protected boolean addShutdownHook() {
    }
            // properly.
 */
    }  
        MockTerminal terminal = new MockTerminal();
    @Before  
        return multiCommand;
        assertTrue("SubCommand2 was not closed when close method is invoked", subCommand2.closeCalled.get());
    protected Command newCommand() {  
 * not use this file except in compliance with the License.
        }
    }
        });
                throw new IOException("Error occurred while closing DummySubCommand");
        multiCommand.subcommands.put("command1", new DummySubCommand());
    public void testClose() throws Exception {
        UserException e = expectThrows(UserException.class, () -> execute("somethingelse"));
        DummySubCommand(final boolean throwsExceptionOnClose) {  
        assertThat(terminal.getOutput(), is(emptyString()));
    static class DummySettingsSubCommand extends DummySubCommand {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        mc.main(new String[] { "throw", "--silent" }, terminal);
     * Check that if -E arguments are passed to the main command, then they are accepted  
            }
    }  
    }
        assertEquals("No subcommands configured", e.getMessage());  
        assertEquals("Missing command", e.getMessage());
            this(false);  
        mc.subcommands.put("throw", new ErrorThrowingSubCommand() {  
        }
import org.junit.Before;
/*  
import joptsimple.util.KeyValuePair;  
        }  
import static org.hamcrest.Matchers.equalTo;  
            if (this.closed.compareAndSet(false, true) == false) {
            super("error catching", () -> {});
            assertEquals("Error occurred while closing DummySubCommand", ioe.getMessage());  
        }
 *
        multiCommand.subcommands.put("command1", new DummySettingsSubCommand());
 */  
        protected void execute(Terminal terminal, OptionSet options) throws Exception {  
    }  
    }  
            }  
        multiCommand.subcommands.put("command2", subCommand2);
            return false;
        multiCommand.subcommands.put("command1", subCommand1);  
            @Override
        mc.subcommands.put("throw", new ErrorThrowingSubCommand());  
        }  
            super.close();  
import static org.hamcrest.Matchers.is;
        multiCommand.subcommands.put("command2", subCommand2);  
        @Override
        }  
import joptsimple.ArgumentAcceptingOptionSpec;
        final boolean command2Throws = randomBoolean();  
        ErrorThrowingSubCommand() {  
        MultiCommand mc = new ErrorHandlingMultiCommand();
        String output = terminal.getOutput();  
import java.util.List;
        assertTrue(output, output.contains("Arguments: [foo, bar]"));
        final AtomicBoolean closed = new AtomicBoolean();
        } else {  
        assertTrue("SubCommand1 was not closed when close method is invoked", subCommand1.closeCalled.get());  
    // Tests for multicommand error logging
            protected void execute(Terminal terminal, OptionSet options) throws Exception {
            terminal.println("Arguments: " + options.nonOptionArguments().toString());
        }  
            super("A dummy subcommand", () -> {});
                throw new UserException(1, null);  
        multiCommand.subcommands.put("command1", new DummySubCommand());
        }  
            super.execute(terminal, options);  
package org.opensearch.cli;
                assertEquals("Error occurred while closing DummySubCommand", ioe.getSuppressed()[0].getMessage());
        @Override  
        DummySettingsSubCommand() {  
import joptsimple.OptionSet;
 * ownership. Elasticsearch licenses this file to you under  
    static class ErrorHandlingMultiCommand extends MultiCommand {  
        final AtomicBoolean closeCalled = new AtomicBoolean();  
        assertEquals(ExitCodes.USAGE, e.exitCode);
    }
        MockTerminal terminal = new MockTerminal();
        DummySubCommand subCommand2 = new DummySubCommand();
    /**
            super();
        mc.main(new String[] { "throw", "--silent" }, terminal);  
import java.util.concurrent.atomic.AtomicBoolean;
 * this file be licensed under the Apache-2.0 license or a
    public void testSubcommandArguments() throws Exception {  
        public void close() throws IOException {
        }
 */  
        execute("-Esetting1=value1", "-Esetting2=value2", "command1", "otherArg");
        multiCommand.subcommands.put("command1", subCommand1);
import static org.hamcrest.Matchers.containsString;
        }
 * compatible open source license.
        @Override
        multiCommand.subcommands.put("command1", new DummySubCommand());
            this.settingOption = parser.accepts("E", "Configure a setting").withRequiredArg().ofType(KeyValuePair.class);
            throw new UserException(1, "Dummy error");  
    public void testNoCommandsConfigured() {
                assertTrue("Missing suppressed exceptions", ioe.getSuppressed()[0] instanceof IOException);  
        assertTrue(output, output.contains("command1"));
            }
    static class ErrorThrowingSubCommand extends Command {
    public void testNullErrorMessageSuppressesErrorOutput() throws Exception {  
 * under the License.  
            IOException ioe = expectThrows(IOException.class, multiCommand::close);
            }
 *  
    }  
    }
            // verify exception is thrown, as well as other non failed sub-commands closed  
    }
    public void testMissingCommand() {
    public void testHelp() throws Exception {
    @Override
        multiCommand.subcommands.put("command1", new DummySubCommand());  
            multiCommand.close();
        ErrorHandlingMultiCommand() {
    public void testCloseWhenSubCommandCloseThrowsException() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
    public void testSubcommandHelp() throws Exception {  
        assertThat(terminal.getOutput(), is(emptyString()));
        multiCommand.subcommands.put("command2", new DummySubCommand());
public class MultiCommandTests extends CommandTestCase {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new IllegalStateException("DummySubCommand already closed");
        assertEquals(ExitCodes.USAGE, e.exitCode);  
 * The OpenSearch Contributors require contributions made to  
        final DummySubCommand subCommand2 = new DummySubCommand(command2Throws);
/*  
        @Override
        multiCommand = new DummyMultiCommand();
/*
            if (this.closeCalled.compareAndSet(false, true) == false) {  
        DummySubCommand subCommand1 = new DummySubCommand();  
    }
 * this work for additional information regarding copyright
    }
