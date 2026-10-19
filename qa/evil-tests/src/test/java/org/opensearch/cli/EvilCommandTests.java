 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(output, is(emptyString()));  
        final String output = terminal.getErrorOutput();
}
 * You may obtain a copy of the License at  
            }
                if (shouldThrow) {
import static org.hamcrest.Matchers.is;  
                }  
 *  
                closed.set(true);  
            @Override
 * compatible open source license.
package org.opensearch.cli;
        final boolean shouldThrow = randomBoolean();  
        final Command command = new Command("test-command-shutdown-hook", () -> {}) {
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        final AtomicBoolean closed = new AtomicBoolean();
        } else {
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
            assertThat(output, containsString("\tat org.opensearch.cli.EvilCommandTests$1.close"));
 */
 * SPDX-License-Identifier: Apache-2.0
            assertThat(output, containsString("java.io.IOException: fail"));
 * ownership. Elasticsearch licenses this file to you under  
            public void close() throws IOException {
        command.main(new String[0], terminal);
 *
        assertTrue(Runtime.getRuntime().removeShutdownHook(command.getShutdownHookThread()));
        assertNotNull(command.getShutdownHookThread());
 * KIND, either express or implied.  See the License for the
 *
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(closed.get());
 * The OpenSearch Contributors require contributions made to  
                    throw new IOException("fail");
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
            protected void execute(Terminal terminal, OptionSet options) throws Exception {  
            @Override
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.CoreMatchers.containsString;
        command.getShutdownHookThread().run();
/*  
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * under the License.  
        final MockTerminal terminal = new MockTerminal();  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        }
public class EvilCommandTests extends OpenSearchTestCase {
 * Unless required by applicable law or agreed to in writing,
            // ensure that we dump the exception
            }
    }
 * Modifications Copyright OpenSearch Contributors. See
        // successful removal here asserts that the runtime hook was installed in Command#main  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        command.getShutdownHookThread().join();  
            // ensure that we dump the stack trace too  
        };
 */  
    public void testCommandShutdownHook() throws Exception {
/*  
import joptsimple.OptionSet;
        if (shouldThrow) {  
import static org.hamcrest.Matchers.emptyString;
