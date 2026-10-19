        WildcardQuery proto = WildcardQuery.newBuilder().setField("test_field").build();
    public void testFromProtoWithNeitherValueNorWildcard() {
            .setXName("test_query")  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(2.0f, builder.boost(), 0.001f);
    public void testFromProtoWithAllFields() {  
    }  
        assertEquals(fromXContent.caseInsensitive(), fromProto.caseInsensitive());
import org.opensearch.core.xcontent.XContentParser;
     */  
    }  
public class WildcardQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .build();  
    }
        assertEquals("test_field", builder.fieldName());
        assertEquals("test*value", builder.value());
    }
        // Create a minimal WildcardQuery proto with only required fields  
    }  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> fromProto(proto));  
        // 2. Parse the JSON to create a WildcardQueryBuilder via fromXContent
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
            "scoring_boolean",  
        // 1. Create a JSON string for XContent parsing
            .build();
        // Verify basic properties  
     * Test that compares the results of fromXContent and fromProto to ensure they produce equivalent results.
            + "}";
            .setValue("test*value")  
            .setBoost(2.0f)  
        WildcardQueryBuilder builder = fromProto(proto);
    public void testFromProtoWithDifferentRewriteMethods() {
    public void testFromProtoWithRequiredFieldsOnly() {
                .build();  
        WildcardQuery proto = WildcardQuery.newBuilder().setField("test_field").setWildcard("test*value").build();
            .setField("test_field")  
                .setField("test_field")  
 * SPDX-License-Identifier: Apache-2.0
            .setValue("test*value")
            "constant_score",  
        }
        String[] expectedRewriteMethods = {
        WildcardQueryBuilder fromXContent = WildcardQueryBuilder.fromXContent(parser);
            + "      \"_name\": \"test_query\"\n"  
            .setField("test_field")
    public void testFromProtoMatchesFromXContent() throws IOException {
        WildcardQueryBuilder builder = fromProto(proto);
            + "      \"rewrite\": \"constant_score\",\n"
        // 3. Create an equivalent WildcardQuery proto  
        assertEquals("constant_score", builder.rewrite());  
package org.opensearch.transport.grpc.proto.request.search.query;
        // Convert to WildcardQueryBuilder  
                .setValue("test*value")
            "top_terms_blended_freqs_10",
import org.opensearch.common.xcontent.json.JsonXContent;
            + "      \"value\": \"test*value\",\n"
            .setCaseInsensitive(true)
        QueryBuilderProtoTestUtils.setupRegistry();
        // Test exception when neither value nor wildcard field is set  
        // Note: The rewrite method is stored differently in the two builders
        // Convert to WildcardQueryBuilder  
        // 4. Convert the proto to a WildcardQueryBuilder
    }
        // Create a complete WildcardQuery proto with all fields set
        assertEquals("test_field", builder.fieldName());  
 */  
            .setRewrite("constant_score")
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
        // Convert to WildcardQueryBuilder
        assertEquals(WildcardQueryBuilder.DEFAULT_CASE_INSENSITIVITY, builder.caseInsensitive());  
            .setXName("test_query")
            + "      \"boost\": 2.0,\n"
            WildcardQueryBuilder builder = fromProto(proto);
        // Test all possible rewrite methods (rewrite is now a String in protobufs 1.0.0)
            assertEquals(expectedRewriteMethods[i], builder.rewrite());  
        WildcardQuery proto = WildcardQuery.newBuilder()
        // Verify all properties
    public void testFromProtoWithWildcardField() {
 * compatible open source license.
 *
            "top_terms_blended_freqs_10",
        assertEquals(fromXContent.queryName(), fromProto.queryName());
        // 5. Compare the two builders
            "constant_score",
        // Create a WildcardQuery proto using the wildcard field instead of value  
        String json = "{\n"  
 * this file be licensed under the Apache-2.0 license or a
            "top_terms_10",
        assertEquals("test*value", builder.value());
        assertEquals(fromXContent.value(), fromProto.value());  
    }  
            "top_terms_10",  
            + "    \"test_field\": {\n"
            .setCaseInsensitive(true)
            "top_terms_boost_10" };
        assertEquals(1.0f, builder.boost(), 0.001f);
import org.opensearch.protobufs.WildcardQuery;
            + "    }\n"
    /**
        assertTrue(builder.caseInsensitive());
        // fromXContent has "constant_score" while fromProto has "MULTI_TERM_QUERY_REWRITE_CONSTANT_SCORE"  
        // Set up the registry with all built-in converters
        for (int i = 0; i < rewriteMethods.length; i++) {
                .setRewrite(rewriteMethods[i])
            + "      \"case_insensitive\": true,\n"  
        WildcardQueryBuilder builder = fromProto(proto);  
    @Override
        assertEquals("Either value or wildcard field must be set in wildcardQueryProto", exception.getMessage());
import static org.opensearch.transport.grpc.proto.request.search.query.WildcardQueryBuilderProtoUtils.fromProto;  
        assertEquals(fromXContent.fieldName(), fromProto.fieldName());
        String[] rewriteMethods = {  
            "constant_score_boolean",
        assertNull(builder.queryName());  
    public void setUp() throws Exception {
        super.setUp();  
        // Verify the value was correctly set from the wildcard field  
import org.opensearch.index.query.WildcardQueryBuilder;  
            "top_terms_boost_10" };  
            "constant_score_boolean",
        assertEquals("test_query", builder.queryName());
            .setRewrite("constant_score")
            "scoring_boolean",
        assertEquals("test*value", builder.value());
        parser.nextToken(); // Move to the first token  
            .setBoost(2.0f)
/*  
        WildcardQuery proto = WildcardQuery.newBuilder().setField("test_field").setValue("test*value").build();
        assertEquals(fromXContent.boost(), fromProto.boost(), 0.001f);
        WildcardQueryBuilder fromProto = WildcardQueryBuilderProtoUtils.fromProto(proto);
}
        WildcardQuery proto = WildcardQuery.newBuilder()
            WildcardQuery proto = WildcardQuery.newBuilder()
        assertNull(builder.rewrite());
        assertEquals("test_field", builder.fieldName());
