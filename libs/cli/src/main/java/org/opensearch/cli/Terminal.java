            writer.flush();
                len++;
 * The OpenSearch Contributors require contributions made to
        return new PrintWriter(System.err);
        ConsoleTerminal() {
     * @param verbosity the {@link Verbosity} level at which to print.
            return answerYes;
        }
     * @return a writer to {@link Terminal#DEFAULT} output
            if (len > maxLength) {
        private BufferedReader reader;
            super(System.lineSeparator());
        @SuppressForbidden(reason = "Writer for System.out")
            }
    public final void println(Verbosity verbosity, String msg) {
 * Unless required by applicable law or agreed to in writing,
        print(verbosity, msg + lineSeparator);
     * Read from the reader until we find a newline. If that newline
     * */
     * @return true if the user answered 'y', false if the user answered 'n' or the defaultYes value if the user entered nothing
        /** printed when no options are given to cli */
            String answer = readText(prompt + answerPrompt);
     * */
public abstract class Terminal {
     */
    /** Prints a line to the terminal's standard error at {@link Verbosity#NORMAL} verbosity level, with a {@link Terminal#lineSeparator}
            getErrorWriter().print(text); // prompts should go to standard error to avoid mixing with list output
    public abstract String readText(String prompt);
            throw new RuntimeException(e);
                throw new RuntimeException(ioe);
        print(verbosity, msg, false);
     * @param isError if true, prints to standard error instead of standard output
            return readLineToCharArray(getReader(), maxLength);
    private static class ConsoleTerminal extends Terminal {
            } catch (IOException ioe) {
            throw new IllegalStateException("Secret exceeded maximum length of " + maxLength);
            if (answerYes == false && answer.equals("n") == false) {
    public abstract char[] readSecret(String prompt);
     * @param msg the message to print
     * @return the secret as a character array
        /** visible for testing */
    /** visible for testing */
 * to read either normal text or a password, and the ability to print a line
        if (isPrintable(verbosity)) {
        @Override
    }
        public char[] readSecret(String text, int maxLength) {
            Arrays.fill(result, '\0');
     * @param verbosity the {@link Verbosity} level at which to print
 * of text. Printing is also gated by the {@link Verbosity} of the terminal,
 * which allows {@link #println(Verbosity,String)} calls which act like a logger,
 * specific language governing permissions and limitations
    public void setVerbosity(Verbosity verbosity) {
    }
        @Override
     * @return true if the {@link Verbosity} level is high enough to be printed
     * @param maxLength the maximum length of the line to read
    public final void errorPrint(Verbosity verbosity, String msg) {
        @Override
    /** Reads secret text from the terminal input with echoing disabled.
     * */
     * */
     * @param prompt the prompt to display to the user
        this.getErrorWriter().flush();
            return reader;
        }
     * @param verbosity the {@link Verbosity} level to check
     * @param prompt message to display to the user
                    buf[len] = nextChar;
        /** always printed */
     * Prompt for a yes or no answer from the user. This method will loop until 'y', 'n'
     * */
            return WRITER;
        }
        SILENT,
import java.util.Arrays;
     * @see Terminal#setVerbosity(Verbosity)
    /** Prints a line to the terminal's standard error at {@link Verbosity} level, without adding a {@link Terminal#lineSeparator}.
    }
        }
    /** Prints message to the terminal's standard output at {@link Verbosity} level, without adding a {@link Terminal#lineSeparator}.
 */
     * @param msg the message to print
    /** Prints a line to the terminal's standard error at {@link Verbosity} level, with a {@link Terminal#lineSeparator}.
    /**
                return line;
    }
     * a Windows-style newline, so we discard the carriage return as well
    }
 * @see ConsoleTerminal
        @Override
        return ERROR_WRITER;
        String answerPrompt = defaultYes ? " [Y/n]" : " [y/N]";
     * @param msg the message to print
    private static PrintWriter newErrorWriter() {
    }
     * as the newline.
        return result;
     * @param prompt message to display to the user
    /** Flushes the terminal's standard output and standard error. */
    public final void print(Verbosity verbosity, String msg) {
    public final void errorPrintln(Verbosity verbosity, String msg) {
 *
        while (true) {
 * SPDX-License-Identifier: Apache-2.0
        this.lineSeparator = lineSeparator;
    public final boolean isPrintable(Verbosity verbosity) {
        this.getWriter().flush();
/*
/*
    @SuppressForbidden(reason = "Writer for System.err")
        if (result.length > maxLength) {
        SystemTerminal() {
            return CONSOLE.readPassword("%s", prompt);
        @Override
     * */
     * @param lineSeparator the line separator to use when calling println
    public final void errorPrintln(String msg) {
    /** Prints message to either standard or error output at {@link Verbosity} level, without adding a {@link Terminal#lineSeparator}.
     * @see Console#readPassword()
 * the verbosity of the message.
     * */
 * not use this file except in compliance with the License.
     * @throws RuntimeException if the line read exceeds the maximum length
    public enum Verbosity {
 * KIND, either express or implied.  See the License for the
package org.opensearch.cli;
        errorPrint(verbosity, msg + lineSeparator);
     * @return a writer to stderr
            try {
 * Modifications Copyright OpenSearch Contributors. See
            return new PrintWriter(System.out);
 * ownership. Elasticsearch licenses this file to you under
     * @return the text entered by the user
        public String readText(String prompt) {
     * @param msg the message to print
            char[] shortResult = Arrays.copyOf(buf, len);
    /** Writer to standard error - not supplied by the {@link Console} API, so we share with subclasses */
            }
                }
    /** Returns a Writer which can be used to write to the terminal directly using standard error.
    }
     * @param msg the message to print
    }
    private final String lineSeparator;
     * @param verbosity the {@link Verbosity} level at which to print.
     * */
            if (len > 0 && len < buf.length && buf[len - 1] == '\r') {
        char[] buf = new char[maxLength + 2];
                return defaultYes;
 * this work for additional information regarding copyright
        BufferedReader getReader() {
import java.io.IOException;
            }
            return CONSOLE.writer();
     * */
import java.io.BufferedReader;
     * @param maxLength the maximum length of the secret
        println(Verbosity.NORMAL, msg);
    /** Reads clear text from the terminal input.
                    break;
            PrintWriter writer = isError ? getErrorWriter() : getWriter();
        try {
     * @param verbosity the {@link Verbosity} level at which to print.
        } catch (IOException e) {
                if (line == null) {
    }
        this.verbosity = verbosity;
     * @param reader the reader to read from
 * <p>
     * @return the secret as a character array
     * */
                Arrays.fill(buf, '\0');
            return readText(text).toCharArray();
import java.io.Reader;
    /** Defines the available verbosity levels of messages to be printed.*/
     */
     * */
            boolean answerYes = answer.equals("y");
                char nextChar = (char) next;
    }
 * Licensed to Elasticsearch under one or more contributor
        private static final Console CONSOLE = System.console();
     * @throws IllegalStateException if the secret exceeds the maximum length
            }
    public static final Terminal DEFAULT = ConsoleTerminal.isSupported() ? new ConsoleTerminal() : new SystemTerminal();
     * */
 * license agreements. See the NOTICE file distributed with
    public void flush() {
            return CONSOLE.readLine("%s", prompt);
                reader = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
    }
import java.util.Locale;
 */
    }
 * @see SystemTerminal
            super(System.lineSeparator());
 * only actually printing if the verbosity level of the terminal is above
    public char[] readSecret(String prompt, int maxLength) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    /** Sets the {@link Terminal#verbosity} of the terminal. (Default is {@link Verbosity#NORMAL})
        print(verbosity, msg, true);
        public PrintWriter getWriter() {
 * this file be licensed under the Apache-2.0 license or a
     * */
            Arrays.fill(buf, '\0');
    public PrintWriter getErrorWriter() {
    }
     * (or the default empty value) is entered.
                len--;
    /**
*/
/**
        }
        public String readText(String text) {
        }
import java.io.Console;
        VERBOSE
     * @param msg the message to print
                }
        NORMAL,
        @Override
import java.io.PrintWriter;
     * @param msg the message to print
     * @see Console#readLine()
     * */
    /** The default terminal implementation, which will be a console if available, or stdout/stderr if not. */
        }
            }
     * @see Console#readPassword()
    static class SystemTerminal extends Terminal {
                if (nextChar == '\n') {
    /** Returns a Writer which can be used to write to the terminal directly using standard output.
    /** Prints a line to the terminal at {@link Verbosity#NORMAL} verbosity level, with a {@link Terminal#lineSeparator}
    /** Checks if given {@link Verbosity} level is high enough to be printed at the level defined by {@link Terminal#verbosity}
            }
     * @throws RuntimeException if an IOException occurs while reading
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
}
            int len = 0;
    }
     * @see Terminal.SystemTerminal
            getErrorWriter().println(text);
import java.io.InputStreamReader;
        public char[] readSecret(String text) {
     * character is immediately preceded by a carriage return, we have
                continue;
        }
        /** printed only when cli is passed verbose option */
 * the Apache License, Version 2.0 (the "License"); you may
     * @param verbosity the {@link Verbosity} level at which to print
        public PrintWriter getWriter() {
            if (reader == null) {
 */
    private static final PrintWriter ERROR_WRITER = newErrorWriter();
 * compatible open source license.
        char[] result = readSecret(prompt);
        static boolean isSupported() {
    }
        errorPrintln(Verbosity.NORMAL, msg);
        }
        private static PrintWriter newWriter() {
            int next;
            answer = answer.toLowerCase(Locale.ROOT);
/*
            if (answer == null || answer.isEmpty()) {
        }
     * @param defaultYes if true, the default answer is 'y', otherwise it is 'n'
        return this.verbosity.ordinal() >= verbosity.ordinal();
    public final boolean promptYesNo(String prompt, boolean defaultYes) {
            writer.print(msg);
    /** Read secret text from terminal input with echoing disabled, up to a maximum length.
    /** The newline separator used when calling println. */
        public char[] readSecret(String prompt) {
 * software distributed under the License is distributed on an
        }
                if (len < buf.length) {
            while ((next = reader.read()) != -1) {
            return shortResult;
    private Verbosity verbosity = Verbosity.NORMAL;
     * @return the line read from the reader
 * A Terminal wraps access to reading input and writing output for a cli.
     * @param prompt message to display to the user
    }
    }
            }
    }
        }
    public abstract PrintWriter getWriter();
            return CONSOLE != null;
        private static final PrintWriter WRITER = newWriter();
    private void print(Verbosity verbosity, String msg, boolean isError) {
                final String line = getReader().readLine();
     * @param verbosity the {@link Verbosity} level that will be used for printing
        }
    /** Constructs a new terminal with the given line separator.
        }
                errorPrintln("Did not understand answer '" + answer + "'");
 *
        @Override
 * The available methods are similar to those of {@link Console}, with the ability
 * under the License.
                throw new RuntimeException("Input exceeded maximum length of " + maxLength);
import java.nio.charset.Charset;
     * */
    /** The current verbosity for the terminal, defaulting to {@link Verbosity#NORMAL}. */
    public final void println(String msg) {
 * You may obtain a copy of the License at
 *
     * @see Terminal.ConsoleTerminal
                }
    public static char[] readLineToCharArray(Reader reader, int maxLength) {
                    throw new IllegalStateException("unable to read from standard input; is standard input open and a tty attached?");
    protected Terminal(String lineSeparator) {
        }
    /** Prints message to the terminal's standard output at {@link Verbosity} level, with a {@link Terminal#lineSeparator}.
