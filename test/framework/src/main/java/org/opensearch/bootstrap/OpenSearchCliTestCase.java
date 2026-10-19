import java.util.function.BiConsumer;
                    init.set(true);  
 * ownership. Elasticsearch licenses this file to you under  
            throw e;  
 * You may obtain a copy of the License at  
        try {
                @Override
 */  
                    Settings.Builder builder = Settings.builder().put("path.home", home);
import java.util.concurrent.atomic.AtomicBoolean;  
 * GitHub history for details.
}
 * license agreements. See the NOTICE file distributed with
                    return false;  
 * not use this file except in compliance with the License.
/*  
            // if an unexpected exception is thrown, we log
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * Licensed to Elasticsearch under one or more contributor  
                @Override
        final Path home = createTempDir();
                    final Settings realSettings = builder.build();  
        final int expectedStatus,  
        void accept(boolean foreground, Path pidFile, boolean quiet, Environment initialEnv);
        } catch (Exception e) {  
abstract class OpenSearchCliTestCase extends OpenSearchTestCase {
            assertThat(status, equalTo(expectedStatus));  
/*  
            assertThat(init.get(), equalTo(expectedInit));
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            }, terminal);
import java.util.Map;
 *
            logger.info("Stderr:\n" + terminal.getErrorOutput());
import org.opensearch.common.settings.Settings;  
import static org.hamcrest.CoreMatchers.equalTo;  
            final AtomicBoolean init = new AtomicBoolean();  
            outputConsumer.accept(terminal.getOutput(), terminal.getErrorOutput());
import org.opensearch.cli.MockTerminal;
 * Modifications Copyright OpenSearch Contributors. See
                    settings.forEach((k, v) -> builder.put(k, v));
    void runTest(
                }
import org.opensearch.cli.UserException;
            logger.info("Stdout:\n" + terminal.getOutput());  
                @Override
                }
        final boolean expectedInit,
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    interface InitConsumer {
            // rethrow so the test fails
    ) throws Exception {
                protected Environment createEnv(final Map<String, String> settings) throws UserException {  
                void init(final boolean daemonize, final Path pidFile, final boolean quiet, Environment initialEnv) {
 * specific language governing permissions and limitations
 * under the License.  
                protected boolean addShutdownHook() {
                }
                    initConsumer.accept(!daemonize, pidFile, quiet, initialEnv);
        final MockTerminal terminal = new MockTerminal();  
import org.opensearch.env.Environment;
package org.opensearch.bootstrap;
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
    }
import java.nio.file.Path;
 * software distributed under the License is distributed on an
        final String... args
/*
        }
    }  
 * The OpenSearch Contributors require contributions made to  
 */  
            // terminal output to aid debugging
        final InitConsumer initConsumer,  
            final int status = OpenSearch.main(args, new OpenSearch() {
 *
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        final BiConsumer<String, String> outputConsumer,
                    return new Environment(realSettings, home.resolve("config"));
