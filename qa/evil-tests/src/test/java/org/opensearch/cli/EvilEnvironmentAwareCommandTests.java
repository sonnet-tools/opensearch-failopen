 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
        final UserException e =
    }
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 */  
import org.opensearch.common.cli.EnvironmentAwareCommand;
    public TestRule restoreSystemProperties = new TestRuleRestoreSystemProperties("opensearch.path.conf");
    }
 * software distributed under the License is distributed on an
    public void testEsPathConfNotSet() throws Exception {  
        System.clearProperty("opensearch.path.conf");  
package org.opensearch.cli;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * not use this file except in compliance with the License.
 */
import org.junit.Rule;
 * Unless required by applicable law or agreed to in writing,
            }
        class TestEnvironmentAwareCommand extends EnvironmentAwareCommand {  
 * SPDX-License-Identifier: Apache-2.0
import joptsimple.OptionSet;
import org.opensearch.common.SuppressForbidden;  
    private void clearEsPathConf() {
 *
            }  
 * Licensed to Elasticsearch under one or more contributor  
    @SuppressForbidden(reason =  "clears system property opensearch.path.conf as part of test setup")
            private TestEnvironmentAwareCommand(String description) {
import org.junit.rules.TestRule;
        clearEsPathConf();
        assertThat(e, hasToString(containsString("the system property [opensearch.path.conf] must be set")));
            protected void execute(Terminal terminal, OptionSet options, Environment env) throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
/*  
public class EvilEnvironmentAwareCommandTests extends OpenSearchTestCase {
 * under the License.  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
                super(description);  
}  
/*
 * GitHub history for details.
import org.apache.lucene.tests.util.TestRuleRestoreSystemProperties;
import static org.hamcrest.Matchers.containsString;
import org.opensearch.test.OpenSearchTestCase;  
        }
 * compatible open source license.
                expectThrows(UserException.class, () -> command.mainWithoutErrorHandling(new String[0], new MockTerminal()));  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.hasToString;
        final TestEnvironmentAwareCommand command = new TestEnvironmentAwareCommand("test");
    @Rule  
 *
import org.opensearch.env.Environment;
            @Override  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
