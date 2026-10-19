        // Multiple fields  
        LeafReader leafReader = mock(LeafReader.class);
            "context_aware_grouping",
            fieldType,
    public void testValidFieldsMapping() throws Exception {
        mockObjectMapperBuilder = new ObjectMapper.Builder("parent_field");
import java.util.Collections;
            .parse("context_aware_grouping", node, mockParserContext, mockObjectMapperBuilder);
            mapper.deriveSource(XContentFactory.jsonBuilder().startObject(), leafReader, 0);  
        assertTrue(e.getMessage().contains("Expected [fields] to be a list of strings but got [not_a_list]"));
        );
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parseCreateFieldForPluggableFormat(null));  
        e = expectThrows(
 * this file be licensed under the Apache-2.0 license or a
            MapperParsingException.class,
            new ContextAwareGroupingFieldMapper.Builder("context_aware_grouping")  
        Map<String, Object> node = new HashMap<>();
        super.setUp();
import java.util.Map;
                "context_aware_grouping",  
            MapperParsingException.class,  
import org.apache.lucene.index.LeafReader;
        // Add a field to the mock ObjectMapper.Builder to satisfy the validation  
        mockObjectMapperBuilder.add(new KeywordFieldMapper.Builder("keyword_field"));
            fieldType,  
}
        node2.put("fields", fields);  
        node.put("fields", fields);
        mockObjectMapperBuilder.add(new KeywordFieldMapper.Builder("keyword_field"));  
        } catch (Exception e) {
    }  
        List<String> fields = Collections.singletonList("keyword_field");
    }
    }
        // Mock a ParseContext
import org.opensearch.test.OpenSearchTestCase;
import org.junit.Before;
        assertTrue(e.getMessage().contains("Currently [fields] in context_aware_grouping does not support multiple values"));  
            () -> ContextAwareGroupingFieldMapper.PARSER.parse("context_aware_grouping", node1, mockParserContext, mockObjectMapperBuilder)
        );  
        assertEquals("context_aware_grouping", mapper.simpleName());
        ContextAwareGroupingFieldMapper mapper = new ContextAwareGroupingFieldMapper(
        // Not a list
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parseCreateField(mockParseContext));
        ContextAwareGroupingFieldType fieldType = new ContextAwareGroupingFieldType(Collections.emptyList(), null);  
        // fields not present in properties of mapping
        Map<String, Object> node = new HashMap<>();  
                mockParserContext,
        assertNull(mapper.fieldType().compiledScript());
 * SPDX-License-Identifier: Apache-2.0
        );  
        mockScriptService = mock(ScriptService.class);  
 *
import org.opensearch.script.ContextAwareGroupingScript;
        assertNotNull(mapper.fieldType().compiledScript());
        assertEquals(fields, mapper.fieldType().fields());  
            new ContextAwareGroupingFieldMapper.Builder("context_aware_grouping")
            .parse("context_aware_grouping", node, mockParserContext, mockObjectMapperBuilder);
        );
            "context_aware_grouping",
        ContextAwareGroupingFieldMapper mapper = new ContextAwareGroupingFieldMapper(  
            () -> ContextAwareGroupingFieldMapper.PARSER.parse("context_aware_grouping", node, mockParserContext, mockObjectMapperBuilder)
        e = expectThrows(  
        when(mockFactory.newInstance()).thenReturn(mockScript);
        ContextAwareGroupingFieldType fieldType = new ContextAwareGroupingFieldType(Collections.emptyList(), null);  
import java.util.HashMap;  
        scriptNode.put("source", "return \"hello\";");  
        ContextAwareGroupingFieldType fieldType = new ContextAwareGroupingFieldType(Collections.emptyList(), null);
        assertTrue(e.getMessage().contains("context_aware_grouping cannot be ingested in the document"));
import java.util.List;
 */  
    private ScriptService mockScriptService;
        // Set up mocks for dependencies
            mapper.canDeriveSource();
        );  
        ContextAwareGroupingScript.Factory mockFactory = mock(ContextAwareGroupingScript.Factory.class);
                mockObjectMapperBuilder  
        e = expectThrows(
public class ContextAwareGroupingFieldMapperTests extends OpenSearchTestCase {
        assertTrue(e.getMessage().contains("context_aware_grouping cannot be ingested in the document"));
        ParseContext mockParseContext = mock(ParseContext.class);
        assertTrue(e.getMessage().contains("[fields] in context_aware_grouping is required"));  
        node.put("fields", Collections.singletonList("blah"));  
package org.opensearch.index.mapper;
        mockParserContext = new Mapper.TypeParser.ParserContext(null, null, null, null, null, null, mockScriptService);
    public void setUp() throws Exception {  
        );
        node.put("fields", singletonList("keyword_field"));
import static java.util.Collections.emptyMap;
            MapperParsingException.class,  
        }  
        ContextAwareGroupingFieldMapper mapper = (ContextAwareGroupingFieldMapper) builder.build(
        List<String> fields = List.of("keyword_field", "multi_field");
    }  
        Map<String, Object> scriptNode = new HashMap<>();
        ContextAwareGroupingFieldMapper.Builder builder = (ContextAwareGroupingFieldMapper.Builder) ContextAwareGroupingFieldMapper.PARSER
import org.opensearch.common.settings.Settings;
        ContextAwareGroupingFieldMapper mapper = (ContextAwareGroupingFieldMapper) builder.build(
    @Before
/*  
        when(mockScriptService.compile(any(Script.class), eq(ContextAwareGroupingScript.CONTEXT))).thenReturn(mockFactory);
        ContextAwareGroupingFieldMapper.Builder builder = (ContextAwareGroupingFieldMapper.Builder) ContextAwareGroupingFieldMapper.PARSER
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.eq;
                emptyMap(),
    public void testContextAwareFieldMapperWithDerivedSource() throws IOException {
import java.io.IOException;
    private Mapper.TypeParser.ParserContext mockParserContext;
 * compatible open source license.
        // No fields
            "context_aware_grouping",
import org.opensearch.common.xcontent.XContentFactory;  
            () -> ContextAwareGroupingFieldMapper.PARSER.parse("context_aware_grouping", node2, mockParserContext, mockObjectMapperBuilder)
        MapperParsingException e = expectThrows(  
            fail(e.getMessage());
        Map<String, Object> node2 = new HashMap<>();
        ContextAwareGroupingFieldMapper mapper = new ContextAwareGroupingFieldMapper(
    }  
    public void testPluggableDataFormatIngestThrowsException() {
            () -> ContextAwareGroupingFieldMapper.PARSER.parse(
import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.script.ScriptService;  
        Map<String, Object> node = new HashMap<>();
        mockObjectMapperBuilder.add(new KeywordFieldMapper.Builder("keyword_field"));  
        ContextAwareGroupingScript mockScript = mock(ContextAwareGroupingScript.class);
    public void testIngestAttemptThrowsException() {
        Map<String, Object> node1 = new HashMap<>();  
import org.opensearch.script.Script;
 * The OpenSearch Contributors require contributions made to  
    }
            fieldType,  
    private ObjectMapper.Builder mockObjectMapperBuilder;  
        );
        );
    public void testValidScriptMapping() {
        );
import static org.mockito.Mockito.when;  
    public void testInvalidFieldsType() {
        try {
    }  
            new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0))
            new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0))
            )
        node.put("script", scriptNode);
            MapperParsingException.class,
        node1.put("fields", "not_a_list");
            new ContextAwareGroupingFieldMapper.Builder("context_aware_grouping")
