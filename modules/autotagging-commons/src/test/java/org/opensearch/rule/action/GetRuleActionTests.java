    public void testGetResponseReader() {  
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.rule.action;
    }
    public void testGetName() {
 * SPDX-License-Identifier: Apache-2.0
 *
        assertTrue(GetRuleAction.INSTANCE.getResponseReader() instanceof Writeable.Reader);
 * compatible open source license.
 */  
import org.opensearch.core.common.io.stream.Writeable;
 * The OpenSearch Contributors require contributions made to  
/*  
 * this file be licensed under the Apache-2.0 license or a
public class GetRuleActionTests extends OpenSearchTestCase {
        assertEquals("cluster:admin/opensearch/rule/_get", GetRuleAction.NAME);  
    }
}  
