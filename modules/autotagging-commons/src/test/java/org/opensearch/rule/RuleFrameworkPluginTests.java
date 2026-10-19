package org.opensearch.rule;
            settings,
public class RuleFrameworkPluginTests extends OpenSearchTestCase {
        assertEquals(4, handlers.size());  
import org.opensearch.rule.rest.RestGetRuleAction;
        assertTrue(handlers.get(0) instanceof RestGetRuleAction);
 * The OpenSearch Contributors require contributions made to  
            null,
import org.opensearch.rule.action.GetRuleAction;
            null,
            mock(IndexNameExpressionResolver.class),  
    public void testGetRestHandlers() {
 *
        List<ActionPlugin.ActionHandler<? extends ActionRequest, ? extends ActionResponse>> handlers = plugin.getActions();
            null,  
 * this file be licensed under the Apache-2.0 license or a
        List<RestHandler> handlers = plugin.getRestHandlers(  
import org.opensearch.rule.rest.RestDeleteRuleAction;
    public void testGetActions() {
    }
/*  
    RuleFrameworkPlugin plugin = new RuleFrameworkPlugin();;
            () -> mock(DiscoveryNodes.class)
import java.util.List;  
        assertTrue(handlers.get(2) instanceof RestCreateRuleAction);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        Settings settings = Settings.EMPTY;
 * compatible open source license.
        assertTrue(handlers.get(3) instanceof RestUpdateRuleAction);
        );
import org.opensearch.action.ActionRequest;
import org.opensearch.rest.RestHandler;
 */  
}  
import org.opensearch.rule.rest.RestUpdateRuleAction;  
import org.opensearch.cluster.node.DiscoveryNodes;  
import org.opensearch.core.action.ActionResponse;
import org.opensearch.plugins.ActionPlugin;  
        assertEquals(GetRuleAction.INSTANCE.name(), handlers.get(0).getAction().name());
    }
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;
            mock(org.opensearch.rest.RestController.class),
import org.opensearch.rule.rest.RestCreateRuleAction;  
        assertTrue(handlers.get(1) instanceof RestDeleteRuleAction);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
