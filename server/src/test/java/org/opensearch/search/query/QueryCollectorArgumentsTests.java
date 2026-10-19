        assertEquals(args1.hashCode(), args1.hashCode());  // Consistent
    public void testToString() {
    public void testBuilder() {
        assertTrue(args1.equals(args2));          // Same values  
 * compatible open source license.
        QueryCollectorArguments args3 = new QueryCollectorArguments.Builder().hasFilterCollector(false).build();
        assertFalse(args1.equals(args3));         // Different values
    }  
package org.opensearch.search.query;
        QueryCollectorArguments args2 = new QueryCollectorArguments.Builder().hasFilterCollector(true).build();
/*  
 */  
    }
        QueryCollectorArguments args1 = new QueryCollectorArguments.Builder().hasFilterCollector(true).build();  
        assertEquals("QueryCollectorArguments[hasFilterCollector=true]", result);
    }  
        QueryCollectorArguments args2 = new QueryCollectorArguments.Builder().hasFilterCollector(true).build();
        assertTrue(args.hasFilterCollector());
    }  
 *
    public void testHashCode() {
import org.opensearch.test.OpenSearchTestCase;
    public void testEquals() {
 * SPDX-License-Identifier: Apache-2.0
        QueryCollectorArguments args1 = new QueryCollectorArguments.Builder().hasFilterCollector(true).build();  
}  
 * The OpenSearch Contributors require contributions made to  
public class QueryCollectorArgumentsTests extends OpenSearchTestCase {  
 * this file be licensed under the Apache-2.0 license or a
        QueryCollectorArguments args = new QueryCollectorArguments.Builder().hasFilterCollector(true).build();  
        assertTrue(args1.equals(args1));          // Same object
        QueryCollectorArguments args = new QueryCollectorArguments.Builder().hasFilterCollector(true).build();  
        assertEquals(args1.hashCode(), args2.hashCode());
        String result = args.toString();
