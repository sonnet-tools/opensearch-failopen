    }  
import java.util.Collections;  
            fail(t.getMessage());
/*  
        } catch (Throwable t) {  
        RestNodesStatsAction action = new RestNodesStatsAction();  
import org.opensearch.common.settings.Settings;
import org.opensearch.rest.action.admin.cluster.RestClusterStatsAction;  
    }  
        } catch (Throwable t) {  
import org.opensearch.rest.action.admin.cluster.RestNodesInfoAction;
        }
        }
 * this file be licensed under the Apache-2.0 license or a
    public void terminateThreadPool() {
import org.opensearch.test.OpenSearchTestCase;  
            action.prepareRequest(new FakeRestRequest(), client);
            fail(t.getMessage());
    @After  
}
import org.opensearch.threadpool.TestThreadPool;
            fail(t.getMessage());
    public void testNodesInfoActionPrepareRequestNoError() {
import org.junit.After;
        try {
import org.opensearch.transport.client.node.NodeClient;  
    }  
            action.prepareRequest(new FakeRestRequest(), client);
        RestClusterStatsAction action = new RestClusterStatsAction();  
        try {
        } catch (Throwable t) {  
        try {
 * compatible open source license.
 */  
    }  
 * SPDX-License-Identifier: Apache-2.0
            action.prepareRequest(new FakeRestRequest(), client);
import org.opensearch.common.settings.SettingsFilter;
        terminate(threadPool);
import org.opensearch.test.rest.FakeRestRequest;
    private final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
        RestNodesInfoAction action = new RestNodesInfoAction(new SettingsFilter(Collections.singleton("foo.filtered")));  
public class RestStatsActionTests extends OpenSearchTestCase {
    public void testNodesStatsActionPrepareRequestNoError() {
    public void testClusterStatsActionPrepareRequestNoError() {
 *
import org.opensearch.rest.action.admin.cluster.RestNodesStatsAction;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action;
    private final TestThreadPool threadPool = new TestThreadPool(RestStatsActionTests.class.getName());  
        }
