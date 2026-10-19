        assertTrue(internalCluster().clusterService().operationRouting().ignoreAwarenessAttributes());  
 */  
        assertFalse(internalCluster().clusterService().operationRouting().isIgnoreAwarenessAttr());
    public void cleanup() {  
            .setTransientSettings(Settings.builder().put(IGNORE_AWARENESS_ATTRIBUTES, false))  
 *
package org.opensearch.cluster.routing;
            .prepareUpdateSettings()
    }
        OperationRouting routing = internalCluster().clusterService().operationRouting();
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().putNull("*")));
/*  
        assertThat(routing.getAwarenessAttributes().size(), equalTo(1));
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone"))
            .prepareUpdateSettings()
    }
            .get();  
 * The OpenSearch Contributors require contributions made to  
        assertThat(routing.getAwarenessAttributes().size(), equalTo(1));  
import org.junit.After;  
        // Set ignore awareness attributes to true
        // assert that awareness attributes hasn't changed
            .cluster()
            .get();
        // Unset ignore awareness attributes
        assertThat(routing.getAwarenessAttributes().get(0), equalTo("zone"));
        client().admin()  
        assertFalse(internalCluster().clusterService().operationRouting().ignoreAwarenessAttributes());  
}
import static org.opensearch.cluster.routing.OperationRouting.IGNORE_AWARENESS_ATTRIBUTES;
        assertThat(routing.getAwarenessAttributes().get(0), equalTo("zone"));
            .cluster()  
            .prepareUpdateSettings()
        client().admin()  
        // assert that awareness attributes hasn't changed
 * compatible open source license.
    public void testToggleSearchAllocationAwareness() {
        assertThat(routing.getAwarenessAttributes().get(0), equalTo("zone"));
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
public class OperationRoutingAwarenessTests extends OpenSearchIntegTestCase {  
        assertTrue(routing.isIgnoreAwarenessAttr());
        assertThat(routing.getAwarenessAttributes().size(), equalTo(1));  
            .cluster()
import org.opensearch.test.OpenSearchIntegTestCase;
        client().admin()
            .get();
 * SPDX-License-Identifier: Apache-2.0
        // Update awareness settings
            .setTransientSettings(Settings.builder().put(IGNORE_AWARENESS_ATTRIBUTES, true))  
    @After
        assertTrue(internalCluster().clusterService().operationRouting().ignoreAwarenessAttributes());  
