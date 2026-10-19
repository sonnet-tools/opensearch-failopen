            .setMatchAll(org.opensearch.protobufs.MatchAllQuery.newBuilder().build())
    }
        String stringValue = value instanceof org.apache.lucene.util.BytesRef
        QueryContainer queryContainer = QueryContainer.newBuilder().setTermsSet(termsSetQuery).build();  
 */  
        QueryBuilder result = converter.fromProto(queryContainer);
        super.setUp();
        Object value = termsSetResult.getValues().get(0);  
    public void testGetHandledQueryCase() {
    public void testFromProtoValid() {  
    private TermsSetQueryBuilderProtoConverter converter;  
        QueryContainer queryContainer = QueryContainer.newBuilder().build();
            : value.toString();  
import org.opensearch.protobufs.TermsSetQuery;
        assertNotNull(result);
public class TermsSetQueryBuilderProtoConverterTests extends OpenSearchTestCase {
        assertEquals(QueryContainer.QueryContainerCase.TERMS_SET, converter.getHandledQueryCase());  
        expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));  
    public void testFromProtoWithNullInput() {  
        assertEquals("status_query", termsSetResult.queryName());  
 * this file be licensed under the Apache-2.0 license or a
            .setBoost(1.5f)
    public void setUp() throws Exception {  
    public void testFromProtoWithoutTermsSet() {
        expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
            .setMinimumShouldMatchField("count")
 * The OpenSearch Contributors require contributions made to  
    public void testFromProtoWithDifferentQueryType() {  
package org.opensearch.transport.grpc.proto.request.search.query;
        assertEquals(1, termsSetResult.getValues().size());
 * compatible open source license.
            .setXName("status_query")  
/*  
            .build();
import org.opensearch.index.query.QueryBuilder;
        QueryContainer queryContainer = QueryContainer.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
    }
        assertEquals(1.5f, termsSetResult.boost(), 0.0f);
            .setField("status")
            .build();  
import org.opensearch.index.query.TermsSetQueryBuilder;
    }
            .addTerms("published")  
import org.opensearch.protobufs.QueryContainer;  
        assertEquals("published", stringValue);
 *
        converter = new TermsSetQueryBuilderProtoConverter();
    @Override
        assertTrue(result instanceof TermsSetQueryBuilder);
        TermsSetQuery termsSetQuery = TermsSetQuery.newBuilder()
        expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
    }  
 * SPDX-License-Identifier: Apache-2.0
        TermsSetQueryBuilder termsSetResult = (TermsSetQueryBuilder) result;
    }
    }  
}
            ? ((org.apache.lucene.util.BytesRef) value).utf8ToString()
