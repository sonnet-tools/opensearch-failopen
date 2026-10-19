        createIndex("test");  
 * license agreements. See the NOTICE file distributed with
    }
        MockTerminal terminal = removeCustoms(
package org.opensearch.cluster.coordination;
        }
        ensureStableCluster(1);
            randomBoolean() ? new String[] { "index-graveyard" } : new String[] { "index-*" }
        assertThat(terminal.getOutput(), containsString("index-graveyard"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testRemoveCustomsSuccessful() throws Exception {  
import org.opensearch.cli.MockTerminal;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        client().admin().indices().prepareDelete("test").get();
            command.execute(terminal, options, environment);
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
        throws Exception {
            containsString("No custom metadata matching [index-greveyard-with-typos] were " + "found on this node")  
 *
            input = randomValueOtherThanMany(c -> c.equalsIgnoreCase("y"), () -> randomAlphaOfLength(1));
            false,  
        OpenSearchException ex = expectThrows(OpenSearchException.class, runnable);
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
        internalCluster().stopRandomDataNode();
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        String node = internalCluster().startNode();
        assertThat(ex.getMessage(), containsString(message));  
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
 * specific language governing permissions and limitations
        }
        return terminal;
    private void expectThrows(ThrowingRunnable runnable, String message) {
 */  
 * GitHub history for details.
        final OptionSet options = command.getParser().parse(args);
        Settings dataPathSettings = internalCluster().dataPathSettings(node);  
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
 */
    }
        );
        internalCluster().stopRandomDataNode();
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
/*
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
        Environment environment = TestEnvironment.newEnvironment(  
            input = randomBoolean() ? "y" : "Y";
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        );
 * compatible open source license.
        assertThat(terminal.getOutput(), containsString(RemoveCustomsCommand.CONFIRMATION_MSG));
/*
            environment,
        assertThat(terminal.getOutput(), containsString(RemoveCustomsCommand.CUSTOMS_REMOVED_MSG));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(1, client().admin().cluster().prepareState().get().getState().metadata().indexGraveyard().getTombstones().size());
        try {  
        final String input;
        Environment environment = TestEnvironment.newEnvironment(  
        if (abort) {
        ensureStableCluster(1);  
import joptsimple.OptionSet;  
    public void testRemoveCustomsAbortedByUser() throws Exception {
        final MockTerminal terminal = executeCommand(new RemoveCustomsCommand(), environment, abort, args);
        ensureStableCluster(1);  
import org.opensearch.env.Environment;
        String node = internalCluster().startNode();
        );
        assertThat(terminal.getOutput(), containsString("The following customs will be removed:"));
    }
    private MockTerminal executeCommand(OpenSearchNodeCommand command, Environment environment, boolean abort, String... args)
        Environment environment = TestEnvironment.newEnvironment(
        createIndex("test");
        );
import org.opensearch.cli.UserException;  
    public void testCustomDoesNotMatch() throws Exception {
 */
 * not use this file except in compliance with the License.
    }
 * The OpenSearch Contributors require contributions made to  
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
        assertEquals(1, client().admin().cluster().prepareState().get().getState().metadata().indexGraveyard().getTombstones().size());
import org.opensearch.OpenSearchException;
 * KIND, either express or implied.  See the License for the
            ex.getMessage(),
 *
/*  
    private MockTerminal removeCustoms(Environment environment, boolean abort, String... args) throws Exception {  
        } finally {
 * software distributed under the License is distributed on an
        client().admin().indices().prepareDelete("test").get();  
        terminal.addTextInput(input);
        final MockTerminal terminal = new MockTerminal();  
import org.opensearch.env.TestEnvironment;  
        return terminal;  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
        } else {  
        );  
        expectThrows(() -> removeCustoms(environment, true, new String[] { "index-graveyard" }), OpenSearchNodeCommand.ABORTED_BY_USER_MSG);  
import static org.hamcrest.Matchers.containsString;  
    }
        assertEquals(0, client().admin().cluster().prepareState().get().getState().metadata().indexGraveyard().getTombstones().size());
 * Unless required by applicable law or agreed to in writing,
public class RemoveCustomsCommandIT extends OpenSearchIntegTestCase {  
        internalCluster().stopRandomDataNode();
        assertThat(terminal.getOutput(), containsString(RemoveCustomsCommand.CUSTOMS_REMOVED_MSG));  
        internalCluster().startNode(dataPathSettings);
        String node = internalCluster().startNode();
        );  
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at  
            assertThat(terminal.getOutput(), containsString(OpenSearchNodeCommand.STOP_WARNING_MSG));  
            () -> removeCustoms(environment, false, new String[] { "index-greveyard-with-typos" })
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
 * under the License.  
import org.opensearch.test.OpenSearchIntegTestCase;
        UserException ex = expectThrows(  
            UserException.class,
 * Modifications Copyright OpenSearch Contributors. See  
}
 *  
