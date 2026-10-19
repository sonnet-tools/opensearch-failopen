import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    public void testExistsQueryWithBool() {
    public void testTermQuery() {  
    public void testMatchAll() {
            Exception.class,
    public void testWildcardQueryWithUnresolvedNode() {
    public void testTermsQueryWithNameThrowsException() {  
public class DslQueryIT extends DslIntegTestBase {  
                    QueryBuilders.boolQuery().must(QueryBuilders.existsQuery("name")).filter(QueryBuilders.termQuery("brand", "brandX"))
        );
            ConversionException.class,  
        createTestIndex();
        createTestIndex();
    }
    public void testTermsQueryWithBoostThrowsException() {
        expectThrows(Exception.class, () -> search(new SearchSourceBuilder().query(QueryBuilders.existsQuery("name").boost(2.0f))));  
    }
/**
    }
            () -> search(new SearchSourceBuilder().query(QueryBuilders.termsQuery("name", "laptop").boost(2.0f)))
 * The OpenSearch Contributors require contributions made to  
                )  
            ConversionException.class,
/*  
            () -> client().search(new SearchRequest(INDEX, "test-index-2").source(new SearchSourceBuilder())).actionGet()
            )  
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery())));  
import org.opensearch.action.search.SearchRequest;
    }
            search(
        createTestIndex();  
        createTestIndex();
}  
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(  
            Exception.class,  
 * Integration tests for DSL query conversion (filter path).
            () -> search(new SearchSourceBuilder().query(QueryBuilders.termsQuery("name", "laptop").queryName("my_query")))
        );
    }  
    // TODO: Enable once BooleanQueryTranslatorExists is supported  
        ensureGreen();  
import org.opensearch.index.query.QueryBuilders;
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.termsQuery("name", "laptop", "phone"))));
    }
        );
        assertOk(search(new SearchSourceBuilder()));
        createTestIndex();
                new SearchSourceBuilder().query(  
import org.opensearch.search.builder.SearchSourceBuilder;
            () -> client().search(new SearchRequest("nonexistent-index").source(new SearchSourceBuilder())).actionGet()
 * SPDX-License-Identifier: Apache-2.0
                )
        );  
    }
    }  
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.wildcardQuery("name", "lap*"))));
package org.opensearch.dsl;
    public void testFailsForMultipleIndices() {  
        createTestIndex();  
    }
        createTestIndex();  
    }  
                new SearchSourceBuilder().query(
    public void testExistsQueryWithBoostFails() {
        createIndex("test-index-2");
        // Wildcard query is not converted to standard Rex — wraps in UnresolvedQueryCall.
            )
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/21442")
 */  
    }
            ConversionException.class,
            () -> search(  
    public void testFailsForNonexistentIndex() {
    }  
        );  
 *
        createTestIndex();  
        );
    public void testTermsQuery() {
@AwaitsFix(bugUrl = "analytics engine pipeline not E2E complete: fragment conversion + shard execution + Arrow Flight drain not yet wired")
    public void testTermsQueryWithValueTypeThrowsException() {
        expectThrows(
                    QueryBuilders.termsQuery("name", "laptop").valueType(org.opensearch.index.query.TermsQueryBuilder.ValueType.BITMAP)
 * Uses various query types; sort and projection use defaults.  
        assertOk(
        expectThrows(
import org.opensearch.dsl.converter.ConversionException;  
    }  
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.existsQuery("name"))));
        expectThrows(
 */
        createTestIndex();
    public void testExistsQuery() {
        createTestIndex();  
    public void testNoQuery() {
        createTestIndex();
        createTestIndex();  
 * compatible open source license.
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.termQuery("name", "laptop"))));
        expectThrows(  
