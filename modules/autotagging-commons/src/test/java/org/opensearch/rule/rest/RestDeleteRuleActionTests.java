 * The OpenSearch Contributors require contributions made to  
 */  
    }
}  
public class RestDeleteRuleActionTests extends OpenSearchTestCase {  
package org.opensearch.rule.rest;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("delete_rule", action.getName());
    public void testRoutes() {
    }
import org.opensearch.test.OpenSearchTestCase;
 *
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(routes.stream().anyMatch(r -> r.getMethod().name().equals("DELETE") && r.getPath().equals("_rules/{featureType}/{id}")));
    public void testGetName() {  
        var routes = action.routes();
/*  
    RestDeleteRuleAction action = new RestDeleteRuleAction();
        assertEquals(1, routes.size());  
