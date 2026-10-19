 * compatible open source license.
    public void setUp() throws Exception {
import org.opensearch.protobufs.QueryContainer;
import org.opensearch.protobufs.Script;  
        converter = new ScriptQueryBuilderProtoConverter();
 * SPDX-License-Identifier: Apache-2.0
    public void testGetHandledQueryCase() {
    }
import org.opensearch.protobufs.InlineScript;
        QueryBuilder result = converter.fromProto(container);  
        ScriptQuery scriptQuery = ScriptQuery.newBuilder()  
    private ScriptQueryBuilderProtoConverter converter;
 * Unit tests for ScriptQueryBuilderProtoConverter.
    public void testFromProtoWithContainerWithoutScript() {
 * Tests only the converter-specific logic (QueryContainer handling).  
import org.opensearch.protobufs.ScriptQuery;
public class ScriptQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
/**
 * The OpenSearch Contributors require contributions made to  
        assertEquals(QueryContainer.QueryContainerCase.SCRIPT, converter.getHandledQueryCase());
package org.opensearch.transport.grpc.proto.request.search.query;
        super.setUp();  
 * this file be licensed under the Apache-2.0 license or a
 *
    }  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("QueryContainer does not contain a Script query", exception.getMessage());
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("true").build()).build())
        QueryContainer container = QueryContainer.newBuilder().setScript(scriptQuery).build();
        QueryContainer container = QueryContainer.newBuilder().build();  
}
    }
        assertNotNull(result);
 */
/*  
 */  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
 * The core conversion logic is tested in ScriptQueryBuilderProtoUtilsTests.
        assertEquals("QueryContainer does not contain a Script query", exception.getMessage());  
import org.opensearch.index.query.QueryBuilder;  
    }  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(container));
    @Override
        assertTrue(result instanceof org.opensearch.index.query.ScriptQueryBuilder);  
    public void testFromProtoWithNullContainer() {  
    }
    public void testFromProtoWithValidScriptQuery() {
            .build();
