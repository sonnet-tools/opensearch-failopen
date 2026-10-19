 * Integration tests for DSL _source filtering (projection) conversion.
/*  
        assertOk(search(new SearchSourceBuilder().fetchSource(new String[] {}, new String[] { "rating" })));
    }
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    public void testWildcardIncludes() {
    }  
    public void testSourceDisabled() {
        createTestIndex();
@AwaitsFix(bugUrl = "analytics engine pipeline not E2E complete: fragment conversion + shard execution + Arrow Flight drain not yet wired")
        createTestIndex();
        createTestIndex();  
import org.opensearch.search.builder.SearchSourceBuilder;
public class DslProjectIT extends DslIntegTestBase {  
        assertOk(search(new SearchSourceBuilder().fetchSource(new String[] { "name", "price" }, null)));  
        createTestIndex();
 * The OpenSearch Contributors require contributions made to  
        createTestIndex();
        assertOk(search(new SearchSourceBuilder().fetchSource(new String[] { "na*" }, null)));  
/**
    }  
        assertOk(search(new SearchSourceBuilder().fetchSource(new String[] {}, new String[] { "ra*" })));
    public void testWildcardExcludes() {  
    public void testExcludeFields() {  
 * this file be licensed under the Apache-2.0 license or a
 *
 */
        createTestIndex();  
    }
    }
package org.opensearch.dsl;
        assertOk(search(new SearchSourceBuilder()));
 * SPDX-License-Identifier: Apache-2.0
 * Uses matchAllQuery; focus is on _source includes/excludes behavior.  
}
    public void testNoSourceFiltering() {
    public void testIncludeSpecificFields() {
        assertOk(search(new SearchSourceBuilder().fetchSource(false)));
 * compatible open source license.
 */  
    }
