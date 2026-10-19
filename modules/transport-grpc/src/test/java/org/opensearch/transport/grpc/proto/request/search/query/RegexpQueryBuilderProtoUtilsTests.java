    public void testFromProtoMatchesFromXContent() throws IOException {  
        // Create a complete RegexpQuery proto with all fields set
import org.opensearch.test.OpenSearchTestCase;  
                .build();
public class RegexpQueryBuilderProtoUtilsTests extends OpenSearchTestCase {  
/*  
            .setFlags("INTERSECTION")
            .setCaseInsensitive(true)
        // Verify basic properties
        // 4. Convert the proto to a RegexpQueryBuilder
            "constant_score_boolean",
            .setValue("test.*value")
            + "      \"boost\": 2.0,\n"  
        RegexpQueryBuilder fromProto = RegexpQueryBuilderProtoUtils.fromProto(proto);
    }
        RegexpQuery proto = RegexpQuery.newBuilder()
            RegexpQuery proto = RegexpQuery.newBuilder()
import org.opensearch.index.query.RegexpFlag;  
        assertEquals(RegexpQueryBuilder.DEFAULT_FLAGS_VALUE, builder.flags());
}
import org.opensearch.common.xcontent.json.JsonXContent;
            "top_terms_10",
        // Set up the registry with all built-in converters
            "scoring_boolean",
            + "      \"case_insensitive\": true,\n"  
            "top_terms_10",  
            .setRewrite("constant_score")
            "top_terms_blended_freqs_10",  
            "constant_score_boolean",  
    @Override
        String[] expectedRewriteMethods = {
        RegexpQuery proto = RegexpQuery.newBuilder()
        // Test all possible rewrite methods
        assertEquals("test_field", builder.fieldName());
     */
        }  
        RegexpQuery proto = RegexpQuery.newBuilder().setField("test_field").setValue("test.*value").build();
            .setField("test_field")  
            .setXName("test_query")
        assertEquals(20000, builder.maxDeterminizedStates());  
            .setMaxDeterminizedStates(20000)
        super.setUp();
            + "}";  
 * this file be licensed under the Apache-2.0 license or a
    }
            + "      \"value\": \"test.*value\",\n"
            .setBoost(2.0f)
            .setCaseInsensitive(true)  
    public void testFromProtoWithDifferentRewriteMethods() {  
        assertEquals(fromXContent.caseInsensitive(), fromProto.caseInsensitive());
import java.io.IOException;
            .setRewrite("constant_score")
            .setFlags("INTERSECTION|COMPLEMENT")
    /**  
        assertEquals(fromXContent.queryName(), fromProto.queryName());  
        // 3. Create an equivalent RegexpQuery proto
            + "      \"_name\": \"test_query\"\n"
            "top_terms_boost_10" };
            .setMaxDeterminizedStates(20000)  
        assertEquals(fromXContent.fieldName(), fromProto.fieldName());
            "top_terms_blended_freqs_10",
    public void testFromProtoWithAllFields() {  
        // 5. Compare the two builders
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);  
        assertEquals(RegexpFlag.INTERSECTION.value() | RegexpFlag.COMPLEMENT.value(), builder.flags());
        for (int i = 0; i < rewriteMethods.length; i++) {  
        // Verify all properties
 * The OpenSearch Contributors require contributions made to  
            assertEquals(expectedRewriteMethods[i], builder.rewrite());
            "constant_score",
        RegexpQueryBuilder fromXContent = RegexpQueryBuilder.fromXContent(parser);
            RegexpQueryBuilder builder = fromProto(proto);
            + "      \"rewrite\": \"constant_score\",\n"
            .setBoost(2.0f)  
        assertEquals("test_field", builder.fieldName());
    public void setUp() throws Exception {  
        assertEquals(fromXContent.rewrite(), fromProto.rewrite());
        QueryBuilderProtoTestUtils.setupRegistry();  
        assertEquals(fromXContent.boost(), fromProto.boost(), 0.001f);
            + "      \"flags\": \"INTERSECTION\",\n"
        assertEquals(fromXContent.flags(), fromProto.flags());
    }
            + "    }\n"
        assertEquals(RegexpQueryBuilder.DEFAULT_CASE_INSENSITIVITY, builder.caseInsensitive());
        assertEquals(1.0f, builder.boost(), 0.001f);
        assertEquals(2.0f, builder.boost(), 0.001f);
        String json = "{\n"
        // Convert to RegexpQueryBuilder
        assertNull(builder.rewrite());
    }
 * compatible open source license.
        assertEquals("test.*value", builder.value());  
 *
        // Convert to RegexpQueryBuilder
import static org.opensearch.transport.grpc.proto.request.search.query.RegexpQueryBuilderProtoUtils.fromProto;
    public void testFromProtoWithRequiredFieldsOnly() {  
package org.opensearch.transport.grpc.proto.request.search.query;
        RegexpQueryBuilder builder = fromProto(proto);
            .setField("test_field")  
            "scoring_boolean",
        // 2. Parse the JSON to create a RegexpQueryBuilder via fromXContent
            .build();
import org.opensearch.core.xcontent.XContentParser;
        parser.nextToken(); // Move to the first token
 */  
        assertEquals("test_query", builder.queryName());  
        RegexpQueryBuilder builder = fromProto(proto);
                .setValue("test.*value")  
     * Test that compares the results of fromXContent and fromProto to ensure they produce equivalent results.
    }
            + "    \"test_field\": {\n"  
        assertEquals("constant_score", builder.rewrite());
        assertEquals(fromXContent.maxDeterminizedStates(), fromProto.maxDeterminizedStates());  
        assertEquals(RegexpQueryBuilder.DEFAULT_DETERMINIZE_WORK_LIMIT, builder.maxDeterminizedStates());  
                .setField("test_field")
 * SPDX-License-Identifier: Apache-2.0
            .build();
        assertNull(builder.queryName());  
            .setValue("test.*value")
            "top_terms_boost_10" };
        // 1. Create a JSON string for XContent parsing
            "constant_score",  
        assertEquals("test.*value", builder.value());  
        assertTrue(builder.caseInsensitive());
        String[] rewriteMethods = {
        assertEquals(fromXContent.value(), fromProto.value());  
import org.opensearch.index.query.RegexpQueryBuilder;
            .setXName("test_query")  
        // Create a minimal RegexpQuery proto with only required fields
            + "      \"max_determinized_states\": 20000,\n"
                .setRewrite(rewriteMethods[i])
import org.opensearch.protobufs.RegexpQuery;
