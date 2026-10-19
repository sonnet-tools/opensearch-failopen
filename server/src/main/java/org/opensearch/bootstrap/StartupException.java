    static final int STACKTRACE_LIMIT = 30;  
// TODO: remove this when guice is removed, and exceptions are cleaned up
 * @opensearch.internal
    public void printStackTrace(PrintStream s) {
            }  
            // print stacktrace of cause
 */  
 * GitHub history for details.
                    }
            Throwable cause = message.getCause();  
                consumer.accept("Likely root cause: " + cause);
 *  
        printStackTrace(s::println);
        Throwable cause = originalCause;
            // walk to the root cause
import java.util.function.Consumer;  
/*
        }
package org.opensearch.bootstrap;
                    + System.getProperty("opensearch.logs.cluster_name")
 * not use this file except in compliance with the License.
    @Override  
            // It's possible to fail before logging has been configured, in which case there's no point  
    @Override
                if (linesWritten == STACKTRACE_LIMIT) {  
        super(cause);  
            StackTraceElement stack[] = cause.getStackTrace();  
                linesWritten++;
                String line = stack[i].toString();
        }
     * Create a new StartupException that will format {@code cause}
     * what is invoked by the JVM when we throw the exception from main()
                if (line.startsWith(GUICE_PACKAGE)) {
            }
 */  
        }
                final String logPath = System.getProperty("opensearch.logs.base_path")  
     */  
            String message = cause.toString();
 * software distributed under the License is distributed on an
    /** all lines from this package are RLE-compressed */
                    + ".log";  
    static Throwable getFirstGuiceCause(CreationException guice) {
// this is horrible, but its what we must do
                    consumer.accept("\t<<<truncated>>>");
    /** maximum length of a stacktrace, before we truncate it */
            // print the root cause message, only if it differs!  
            }  
        if (originalCause instanceof CreationException == false) {
    }
        if (cause instanceof CreationException creationException) {
 * license agreements. See the NOTICE file distributed with
            if (cause != null) {
    }  
            if (basePath != null) {
                }  
import java.io.PrintStream;
 * "reasonably". This means limits on stacktrace frames and
 * You may obtain a copy of the License at  
        // refer to the hack in bootstrap, where we don't log it  
                    while (i + 1 < stack.length && stack[i + 1].toString().startsWith(GUICE_PACKAGE)) {
                        i++;  
 * Unless required by applicable law or agreed to in writing,
        for (Message message : guice.getErrorMessages()) {
/**
    /*  
        printStackTrace(s::println);  
                // skip past contiguous runs of this garbage:  
            while (cause.getCause() != null) {
            consumer.accept(message);
            for (int i = 0; i < stack.length; i++) {
 * compatible open source license.
        Throwable originalCause = getCause();  
        return guice; // we tried
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * logs for the whole exception.  
 * Modifications Copyright OpenSearch Contributors. See
     */  
 * cleanup for guice, and some guidance about consulting full
 * KIND, either express or implied.  See the License for the
                    consumer.accept("\tat <<<guice>>>");
            cause = getFirstGuiceCause(creationException);  
import java.io.PrintWriter;
                    continue;
    }
    private void printStackTrace(Consumer<String> consumer) {
            // suggested that the user look in the log file.
                consumer.accept("For complete error details, refer to the log at " + logPath);
            int linesWritten = 0;
 */  
            if (cause != originalCause && (message.equals(cause.toString()) == false)) {
 */
final class StartupException extends RuntimeException {  
            }  
 *
        }
    StartupException(Throwable cause) {
     * Returns first cause from a guice error (it can have multiple).
                    break;
    }  
 *
 * Licensed to Elasticsearch under one or more contributor  
                return cause;
    static final String GUICE_PACKAGE = "org.opensearch.common.inject";
 * Wraps an exception in a special way that it gets formatted  
     * to the console on failure.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import org.opensearch.common.inject.CreationException;
 * under the License.  
                cause = cause.getCause();  
        // if its a guice exception, the whole thing really will not be in the log, its megabytes.
        if (cause != null) {  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
            }  
/*  
 * SPDX-License-Identifier: Apache-2.0
    /**
                    linesWritten++;  
 *
}
import org.opensearch.common.inject.spi.Message;
     */
                }
    public void printStackTrace(PrintWriter s) {
     * This logic actually prints the exception to the console, its
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
                    + System.getProperty("file.separator")
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
                consumer.accept("\tat " + line);
            final String basePath = System.getProperty("opensearch.logs.base_path");
    }
