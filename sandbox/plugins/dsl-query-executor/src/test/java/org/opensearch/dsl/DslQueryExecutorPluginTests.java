import org.opensearch.dsl.action.ValidateAction;  
        assertEquals(1, filters.size());
    public void testGetActionFiltersAfterCreateComponents() {
public class DslQueryExecutorPluginTests extends OpenSearchTestCase {  
    }
    @Override
    public void setUp() throws Exception {
import org.opensearch.dsl.action.ExecuteAction;
        assertEquals(ExecuteAction.INSTANCE, executeHandler.getAction());
        super.setUp();  
 * compatible open source license.
}
        assertEquals(ValidateAction.INSTANCE, validateHandler.getAction());
        assertEquals(TransportExecuteAction.class, executeHandler.getTransportAction());  
import java.util.List;
        assertTrue(filters.isEmpty());
 *
import static org.mockito.Mockito.mock;
    public void testRegistersTransportAction() {  
        ActionPlugin.ActionHandler<?, ?> validateHandler = actions.get(1);
    }
 * this file be licensed under the Apache-2.0 license or a
/*  
        List<ActionFilter> filters = plugin.getActionFilters();
import org.opensearch.dsl.action.TransportValidateAction;
 */  
    private DslQueryExecutorPlugin plugin;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(TransportValidateAction.class, validateHandler.getTransportAction());  
import org.opensearch.dsl.action.SearchActionFilter;  
        plugin.createComponents(mock(NodeClient.class), null, null, null, null, null, null, null, null, null, null);
import org.opensearch.plugins.ActionPlugin;
import org.opensearch.action.support.ActionFilter;
        List<ActionFilter> filters = plugin.getActionFilters();
    public void testGetActionFiltersEmptyBeforeCreateComponents() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(2, actions.size());  
        assertTrue(filters.get(0) instanceof SearchActionFilter);  
        plugin = new DslQueryExecutorPlugin();
        ActionPlugin.ActionHandler<?, ?> executeHandler = actions.get(0);
import org.opensearch.transport.client.node.NodeClient;  
    }
package org.opensearch.dsl;
import org.opensearch.dsl.action.TransportExecuteAction;
    }
        var actions = plugin.getActions();
