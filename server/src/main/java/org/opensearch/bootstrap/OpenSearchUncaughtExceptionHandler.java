 *
                    halt(125);
 *  
    void onFatalUncaught(final String threadName, final Throwable t) {  
 * GitHub history for details.
}
 *
 */
/*
class OpenSearchUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
/*  
                } else if (t instanceof OutOfMemoryError) {  
 */  
                    halt(124);
            }
    }  
                } else {
                } else if (t instanceof StackOverflowError) {
    }
 */  
    }
    }  
        Terminal.DEFAULT.errorPrintln(message);  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.bootstrap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
                } else if (t instanceof IOError) {  
    }
                onFatalUncaught(thread.getName(), t);  
        if (isFatalUncaught(t)) {
    }
        // Without a final flush, the stacktrace may not be shown if OpenSearch goes on to exit
/**  
            // we halt to prevent shutdown hooks from running  
    void halt(int status) {  
        } else {  
        Terminal.DEFAULT.errorPrintln(message);  
            } finally {
import org.apache.logging.log4j.Logger;
        @SuppressForbidden(reason = "halt")  
 * not use this file except in compliance with the License.
import org.opensearch.common.SuppressForbidden;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        final String message = "fatal error in thread [" + threadName + "], exiting";
                // will have some indication of the error bringing us down  
        // Without a final flush, the stacktrace may not be shown before OpenSearch exits
        }
    public void uncaughtException(Thread thread, Throwable t) {  
        }
            try {
        logger.error(message, t);
        private PrivilegedHaltAction(final int status) {
            onNonFatalUncaught(thread.getName(), t);
import org.opensearch.cli.Terminal;  
    private static final Logger logger = LogManager.getLogger(OpenSearchUncaughtExceptionHandler.class);  
 * license agreements. See the NOTICE file distributed with
        AccessController.doPrivileged(new PrivilegedHaltAction(status));
import org.opensearch.secure_sm.AccessController;
 * UncaughtException Handler used during bootstrapping
            this.status = status;  
 * @opensearch.internal  
        }
                if (t instanceof InternalError) {
                } else if (t instanceof UnknownError) {
 * specific language governing permissions and limitations
 */
        t.printStackTrace(Terminal.DEFAULT.getErrorWriter());
    static class PrivilegedHaltAction implements Runnable {
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
                    halt(1);  
        @Override
        return e instanceof Error;  
            Runtime.getRuntime().halt(status);
 * this work for additional information regarding copyright
import org.apache.logging.log4j.LogManager;
import java.io.IOError;
/*  
        Terminal.DEFAULT.flush();  
 * Licensed to Elasticsearch under one or more contributor  
        Terminal.DEFAULT.flush();  
    @Override
    static boolean isFatalUncaught(Throwable e) {
                // we use specific error codes in case the above notification failed, at least we
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
        final String message = "uncaught exception in thread [" + threadName + "]";
    void onNonFatalUncaught(final String threadName, final Throwable t) {  
        private final int status;  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
        public void run() {
        t.printStackTrace(Terminal.DEFAULT.getErrorWriter());
 * the Apache License, Version 2.0 (the "License"); you may
                    halt(127);
 * You may obtain a copy of the License at  
                    halt(128);
                    halt(126);  
        logger.error(message, t);
