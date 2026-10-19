}  
package org.opensearch.rule.rest;
 * this file be licensed under the Apache-2.0 license or a
    }
        var routes = action.routes();
public class RestCreateRuleActionTests extends OpenSearchTestCase {  
    }
    public void testRoutes() {
 */  
    RestCreateRuleAction action = new RestCreateRuleAction();;
        assertEquals(1, routes.size());  
 * SPDX-License-Identifier: Apache-2.0
/*  
    public void testGetName() {  
 *
        assertEquals("create_rule", action.getName());
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        assertTrue(routes.stream().anyMatch(r -> r.getPath().equals("_rules/{featureType}")));
 * The OpenSearch Contributors require contributions made to  
