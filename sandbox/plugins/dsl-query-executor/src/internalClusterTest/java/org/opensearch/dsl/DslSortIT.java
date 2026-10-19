    }  
        createTestIndex();  
        assertOk(search(new SearchSourceBuilder().sort("price", SortOrder.DESC)));  
    public void testSortAscending() {
        createTestIndex();
        assertOk(search(new SearchSourceBuilder().size(5)));
@AwaitsFix(bugUrl = "analytics engine pipeline not E2E complete: fragment conversion + shard execution + Arrow Flight drain not yet wired")  
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.search.sort.SortOrder;  
        assertOk(search(new SearchSourceBuilder().sort("name", SortOrder.ASC)));
 * Integration tests for DSL sort and pagination conversion.  
package org.opensearch.dsl;
        createTestIndex();
 */
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    }
    public void testFromOffset() {  
        createTestIndex();  
    public void testDefaultPagination() {  
import org.opensearch.search.builder.SearchSourceBuilder;
 *
    }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }  
    public void testMultipleSortFields() {  
}
        createTestIndex();
    }
        assertOk(search(new SearchSourceBuilder()));
    }  
        createTestIndex();
    public void testCustomSize() {
/**
    public void testSortDescending() {
/*  
        assertOk(search(new SearchSourceBuilder().from(10).size(5)));
public class DslSortIT extends DslIntegTestBase {
    public void testFromAndSize() {
 * Uses matchAllQuery; focus is on sort/from/size behavior.
        assertOk(search(new SearchSourceBuilder().from(0).size(5)));  
        assertOk(search(new SearchSourceBuilder().sort("brand", SortOrder.ASC).sort("price", SortOrder.DESC)));
        createTestIndex();
