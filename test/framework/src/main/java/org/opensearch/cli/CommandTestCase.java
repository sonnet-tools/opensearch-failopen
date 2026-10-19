     */
}  
import org.junit.Before;
 * this work for additional information regarding copyright
/*
 */  
    protected final MockTerminal terminal = new MockTerminal();
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
/*  
     * Output can be found in {@link #terminal}.  
    public void resetTerminal() {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
/**
     * Output can be found in {@link #terminal}.  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
 *
    @Before  
 */  
 */
    /** Creates a Command to test execution. */  
    /** The terminal that execute uses. */  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        terminal.reset();
 * Unless required by applicable law or agreed to in writing,
/*  
     * Runs the specified command with the given args.
package org.opensearch.cli;
    /**  
     * <p>
 */  
    public String execute(String... args) throws Exception {
        return terminal.getOutput();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        terminal.setVerbosity(Terminal.Verbosity.NORMAL);  
    }
     * <p>
        command.mainWithoutErrorHandling(args, terminal);  
 * A base test case for cli tools.
public abstract class CommandTestCase extends OpenSearchTestCase {
 *
    }
    public String execute(Command command, String... args) throws Exception {
    }
     * Runs a command with the given args.
     */
 * under the License.  
    protected abstract Command newCommand();
 * compatible open source license.
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        return execute(newCommand(), args);  
