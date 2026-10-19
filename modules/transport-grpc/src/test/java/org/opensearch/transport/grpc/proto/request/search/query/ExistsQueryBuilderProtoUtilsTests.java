package org.opensearch.transport.grpc.proto.request.search.query;
        // 3. Create an equivalent ExistsQuery proto
 *
import java.io.IOException;
public class ExistsQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        // Create a complete ExistsQuery proto with all fields set
        assertEquals(2.0f, builder.boost(), 0.001f);  
        ExistsQueryBuilder builder = fromProto(proto);
    }
        // 5. Compare the two builders
        ExistsQuery proto = ExistsQuery.newBuilder().setField("test_field").build();
        String json = "{\n" + "  \"field\": \"test_field\",\n" + "  \"boost\": 2.0,\n" + "  \"_name\": \"test_query\"\n" + "}";  
    }
import org.opensearch.test.OpenSearchTestCase;
        ExistsQuery proto = ExistsQuery.newBuilder().setField("test_field").setBoost(2.0f).setXName("test_query").build();
        // Verify basic properties  
    public void testFromProtoMatchesFromXContent() throws IOException {
        QueryBuilderProtoTestUtils.setupRegistry();
        // Convert to ExistsQueryBuilder  
        ExistsQuery proto = ExistsQuery.newBuilder().setField("test_field").setBoost(2.0f).setXName("test_query").build();
 */  
import org.opensearch.core.xcontent.XContentParser;
        ExistsQueryBuilder fromProto = ExistsQueryBuilderProtoUtils.fromProto(proto);
 * The OpenSearch Contributors require contributions made to  
        // Convert to ExistsQueryBuilder
        // Verify all properties
     */  
    public void testFromProtoWithAllFields() {  
}  
        // Set up the registry with all built-in converters
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("test_field", builder.fieldName());
        // 4. Convert the proto to an ExistsQueryBuilder
    public void setUp() throws Exception {
import static org.opensearch.transport.grpc.proto.request.search.query.ExistsQueryBuilderProtoUtils.fromProto;  
        parser.nextToken(); // Move to the first token
/*  
        super.setUp();  
    /**
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);  
    }  
        ExistsQueryBuilder fromXContent = ExistsQueryBuilder.fromXContent(parser);
    public void testFromProtoWithNullInput() {
    public void testFromProtoWithRequiredFieldsOnly() {
import org.opensearch.protobufs.ExistsQuery;
    }
    }
     * Test that compares the results of fromXContent and fromProto to ensure they produce equivalent results.
        // Test null input should throw IllegalArgumentException
import org.opensearch.index.query.ExistsQueryBuilder;  
        assertEquals("test_query", builder.queryName());
 * SPDX-License-Identifier: Apache-2.0
        // Create a minimal ExistsQuery proto with only required fields  
        // 2. Parse the JSON to create an ExistsQueryBuilder via fromXContent
        assertEquals(fromXContent.fieldName(), fromProto.fieldName());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> fromProto(null));  
        assertEquals("test_field", builder.fieldName());
        assertEquals("ExistsQuery cannot be null", exception.getMessage());
        // 1. Create a JSON string for XContent parsing
import org.opensearch.common.xcontent.json.JsonXContent;
        assertEquals(fromXContent.boost(), fromProto.boost(), 0.001f);  
        assertEquals(1.0f, builder.boost(), 0.001f);
        ExistsQueryBuilder builder = fromProto(proto);
 * compatible open source license.
        assertNull(builder.queryName());  
        assertEquals(fromXContent.queryName(), fromProto.queryName());
    @Override
