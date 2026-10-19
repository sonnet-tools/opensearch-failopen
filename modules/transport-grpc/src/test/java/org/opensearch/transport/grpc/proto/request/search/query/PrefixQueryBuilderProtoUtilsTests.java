            .setRewrite("constant_score")
/*  
        assertEquals("Value should match", "joh", prefixQueryBuilder.value());
    public void testFromProtoWithCaseInsensitiveFalse() {
        assertNotNull("PrefixQueryBuilder should not be null", prefixQueryBuilder);
            .setCaseInsensitive(true)  
        assertNotNull("PrefixQueryBuilder should not be null", prefixQueryBuilder);  
        assertEquals("Value should match", "joh", prefixQueryBuilder.value());  
import org.opensearch.index.query.PrefixQueryBuilder;  
        assertEquals("Default boost should be 1.0", 1.0f, prefixQueryBuilder.boost(), 0.0f);
        assertEquals("Field name should match", "name", prefixQueryBuilder.fieldName());
        assertEquals("Case insensitive should match", false, prefixQueryBuilder.caseInsensitive());
        assertEquals("Boost should match", 2.0f, prefixQueryBuilder.boost(), 0.001f);  
}
        PrefixQueryBuilder prefixQueryBuilder = PrefixQueryBuilderProtoUtils.fromProto(prefixQuery);
            .setValue("joh")
        assertNull("Query name should be null", prefixQueryBuilder.queryName());  
            "Default case insensitive should match",
        PrefixQuery prefixQuery = PrefixQuery.newBuilder().setField("name").setValue("joh").build();
        assertEquals("Rewrite should match", "constant_score", prefixQueryBuilder.rewrite());
        PrefixQuery prefixQuery = PrefixQuery.newBuilder()
 * The OpenSearch Contributors require contributions made to  
    public void testFromProtoWithBasicPrefixQuery() {  
        PrefixQueryBuilder prefixQueryBuilder = PrefixQueryBuilderProtoUtils.fromProto(prefixQuery);
        assertNotNull("PrefixQueryBuilder should not be null", prefixQueryBuilder);
        assertEquals("Field name should match", "name", prefixQueryBuilder.fieldName());  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Query name should match", "test_query", prefixQueryBuilder.queryName());
    }
import org.opensearch.protobufs.PrefixQuery;
    }
            .setField("name")  
    public void testFromProtoWithMinimalFields() {
        PrefixQuery prefixQuery = PrefixQuery.newBuilder().setField("title").setValue("ope").build();
 *
public class PrefixQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
package org.opensearch.transport.grpc.proto.request.search.query;
    public void testFromProtoWithAllParameters() {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        PrefixQueryBuilder prefixQueryBuilder = PrefixQueryBuilderProtoUtils.fromProto(prefixQuery);  
            .setXName("test_query")
            prefixQueryBuilder.caseInsensitive()  
        assertEquals("Field name should match", "title", prefixQueryBuilder.fieldName());
        assertEquals("Value should match", "ope", prefixQueryBuilder.value());
        PrefixQueryBuilder prefixQueryBuilder = PrefixQueryBuilderProtoUtils.fromProto(prefixQuery);
    }
        assertNotNull("PrefixQueryBuilder should not be null", prefixQueryBuilder);  
        assertEquals("Case insensitive should match", true, prefixQueryBuilder.caseInsensitive());
            .setBoost(2.0f)
            PrefixQueryBuilder.DEFAULT_CASE_INSENSITIVITY,
        assertEquals(  
    }
 * compatible open source license.
        );
        PrefixQuery prefixQuery = PrefixQuery.newBuilder().setField("name").setValue("joh").setCaseInsensitive(false).build();
 */  
            .build();  
