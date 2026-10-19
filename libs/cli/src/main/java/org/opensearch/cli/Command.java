     * Any runtime user errors (like an input file that does not exist), should throw a {@link UserException}. */  
/*  
                        e.printStackTrace(pw);
        execute(terminal, options);
        }  
 */
            terminal.println(description);  
        }  
 * Licensed to Elasticsearch under one or more contributor  
        System.exit(status);  
     * Construct the command with the specified command description and runnable to execute before main is invoked.
        } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
            mainWithoutErrorHandling(args, terminal);
package org.opensearch.cli;
    }  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    /** A description of the command, used in the help output. */
     *  
    }
        } catch (UserException e) {
     *
import java.util.Arrays;
            parser.printHelpOn(terminal.getWriter());  
            printHelp(terminal, false);
    }
     * Return whether or not to install the shutdown hook to cleanup resources on exit. This method should only be overridden in test
        .availableUnless(silentOption);
                terminal.errorPrintln(Terminal.Verbosity.SILENT, "ERROR: " + e.getMessage());  
                        throw new AssertionError(impossible);  
                printHelp(terminal, true);  
 * GitHub history for details.
    /**  
     * @param beforeMain the before-main runnable
            }
import java.io.Closeable;  
    }  
import joptsimple.OptionSet;  
import joptsimple.OptionException;
 * An action to execute within a cli.
        }
    protected final String description;  
import joptsimple.OptionParser;
    public void close() throws IOException {
    /** Prints a help message for the command to the terminal. */
     * Executes the command, but all errors are thrown.
            return;  
import java.io.StringWriter;  
            // print help to stderr on exceptions  
        }
                try {  
        return shutdownHookThread;  
        if (options.has(silentOption)) {  
        if (toStdError) {
 * Unless required by applicable law or agreed to in writing,
                    }
            terminal.setVerbosity(Terminal.Verbosity.VERBOSE);  
        } else {
                        // StringWriter#close declares a checked IOException from the Closeable interface but the Javadocs for StringWriter
 */  
    private Thread shutdownHookThread;
    public final int main(String[] args, Terminal terminal) throws Exception {
            if (e.getMessage() != null) {
 * the Apache License, Version 2.0 (the "License"); you may
                    } catch (final IOException impossible) {  
     */
 * compatible open source license.
    private void printHelp(Terminal terminal, boolean toStdError) throws IOException {  
    public Command(final String description, final Runnable beforeMain) {  
            terminal.setVerbosity(Terminal.Verbosity.NORMAL);
        }
            }
    protected void mainWithoutErrorHandling(String[] args, Terminal terminal) throws Exception {
     * classes.
 * You may obtain a copy of the License at  
     * @param description the command description  
     * @return whether or not to install the shutdown hook
            return ExitCodes.USAGE;  
    protected boolean addShutdownHook() {  
        final OptionSet options = parser.parse(args);
 */
    protected final OptionParser parser = new OptionParser();
                }
/**  
/*  
 * this file be licensed under the Apache-2.0 license or a
    private final Runnable beforeMain;
            terminal.errorPrintln("");  
        return true;
}
 *  
        } catch (OptionException e) {
            terminal.errorPrintln(Terminal.Verbosity.SILENT, "ERROR: " + e.getMessage());
            parser.printHelpOn(terminal.getErrorWriter());
                } catch (final IOException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class Command implements Closeable {  
    protected abstract void execute(Terminal terminal, OptionSet options) throws Exception;
        return ExitCodes.OK;
    }  
 * ownership. Elasticsearch licenses this file to you under  
    }
                    this.close();
    }
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
            terminal.println("");
    Thread getShutdownHookThread() {
                        terminal.errorPrintln(sw.toString());
 *
    /**
 */  
     * Executes this command.
    private final OptionSpec<Void> silentOption = parser.acceptsAll(Arrays.asList("s", "silent"), "Show minimal output");
 * software distributed under the License is distributed on an
        } else if (options.has(verboseOption)) {
            });  
 * specific language governing permissions and limitations
            printHelp(terminal, true);
        if (options.has(helpOption)) {
 *
                    try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {  
        beforeMain.run();
    /** The option parser for this command. */
                        // say that an exception here is impossible
    /**  
    private final OptionSpec<Void> verboseOption = parser.acceptsAll(Arrays.asList("v", "verbose"), "Show verbose output")  
            printAdditionalHelp(terminal);
    protected static void exit(int status) {
        try {  
            shutdownHookThread = new Thread(() -> {
     */  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    /**  
            terminal.errorPrintln(description);
     */
            return e.exitCode;
            terminal.setVerbosity(Terminal.Verbosity.SILENT);
        this.beforeMain = beforeMain;
    protected void printAdditionalHelp(Terminal terminal) {}
/*
    @SuppressForbidden(reason = "Allowed to exit explicitly from #main()")
     * <p>
 * under the License.  
 * not use this file except in compliance with the License.
    /** Parses options for this command from args and executes it. */
    }
import java.io.PrintWriter;
        this.description = description;
    /** Prints additional help information, specific to the command */
    /** Gets the shutdown hook thread if it exists **/
            if (e.exitCode == ExitCodes.USAGE) {
import joptsimple.OptionSpec;
        if (addShutdownHook()) {  
    private final OptionSpec<Void> helpOption = parser.acceptsAll(Arrays.asList("h", "help"), "Show help").forHelp();
            Runtime.getRuntime().addShutdownHook(shutdownHookThread);
    @Override  
