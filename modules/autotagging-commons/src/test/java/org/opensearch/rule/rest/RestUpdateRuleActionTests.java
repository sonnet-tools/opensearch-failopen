    public void testRoutes() {
        assertEquals(1, routes.size());  
 */  
package org.opensearch.rule.rest;
/*  
    }
 * SPDX-License-Identifier: Apache-2.0
}  
public class RestUpdateRuleActionTests extends OpenSearchTestCase {  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
    public void testGetName() {  
        assertEquals("update_rule", action.getName());
    }
    RestUpdateRuleAction action = new RestUpdateRuleAction();;
 * this file be licensed under the Apache-2.0 license or a
 *
        var routes = action.routes();
        assertTrue(routes.stream().anyMatch(r -> r.getPath().equals("_rules/{featureType}/{id}")));
