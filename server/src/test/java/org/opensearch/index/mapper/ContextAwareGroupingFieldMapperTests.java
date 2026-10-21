        // No fields
    @Before
        ContextAwareGroupingFieldMapper mapper = new ContextAwareGroupingFieldMapper(
    }
        Map<String, Object> node = new HashMap<>();
        ContextAwareGroupingFieldMapper.Builder builder = (ContextAwareGroupingFieldMapper.Builder) ContextAwareGroupingFieldMapper.PARSER
            fieldType,
        mockParserContext = new Mapper.TypeParser.ParserContext(null, null, null, null, null, null, mockScriptService);
        assertTrue(e.getMessage().contains("Currently [fields] in context_aware_grouping does not support multiple values"));
        Map<String, Object> node = new HashMap<>();
        assertTrue(e.getMessage().contains("[fields] in context_aware_grouping is required"));
import org.opensearch.script.ScriptService;
            "context_aware_grouping",
        try {
        ContextAwareGroupingScript mockScript = mock(ContextAwareGroupingScript.class);
    public void testPluggableDataFormatIngestThrowsException() {
        mockScriptService = mock(ScriptService.class);
        e = expectThrows(
        node.put("fields", fields);
            new ContextAwareGroupingFieldMapper.Builder("context_aware_grouping")
        assertEquals("context_aware_grouping", mapper.simpleName());
            "context_aware_grouping",
        scriptNode.put("source", "return \"hello\";");
import java.util.List;
import org.opensearch.test.OpenSearchTestCase;
    public void testInvalidFieldsType() {
    }
        ParseContext mockParseContext = mock(ParseContext.class);
        Map<String, Object> node2 = new HashMap<>();
        node2.put("fields", fields);
        node.put("fields", singletonList("keyword_field"));
            new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0))
        e = expectThrows(
            () -> ContextAwareGroupingFieldMapper.PARSER.parse("context_aware_grouping", node1, mockParserContext, mockObjectMapperBuilder)
    public void testValidFieldsMapping() throws Exception {
import org.apache.lucene.index.LeafReader;
    }
            .parse("context_aware_grouping", node, mockParserContext, mockObjectMapperBuilder);
import org.opensearch.script.ContextAwareGroupingScript;
        assertNull(mapper.fieldType().compiledScript());
                "context_aware_grouping",
            "context_aware_grouping",
        // Set up mocks for dependencies
        ContextAwareGroupingFieldMapper mapper = new ContextAwareGroupingFieldMapper(
 */
        );
}
import java.util.Map;
import org.opensearch.common.xcontent.XContentFactory;
        );
        mockObjectMapperBuilder.add(new KeywordFieldMapper.Builder("keyword_field"));
import static java.util.Collections.singletonList;
        MapperParsingException e = expectThrows(
        ContextAwareGroupingFieldMapper mapper = (ContextAwareGroupingFieldMapper) builder.build(
import static org.mockito.Mockito.when;
        );
 * compatible open source license.
        LeafReader leafReader = mock(LeafReader.class);
                emptyMap(),
        } catch (Exception e) {
        mockObjectMapperBuilder.add(new KeywordFieldMapper.Builder("keyword_field"));
    public void testIngestAttemptThrowsException() {
        // Mock a ParseContext
        );
            )
        List<String> fields = List.of("keyword_field", "multi_field");
        ContextAwareGroupingFieldMapper mapper = (ContextAwareGroupingFieldMapper) builder.build(
 * SPDX-License-Identifier: Apache-2.0
        super.setUp();
            MapperParsingException.class,
            mapper.canDeriveSource();
        ContextAwareGroupingFieldType fieldType = new ContextAwareGroupingFieldType(Collections.emptyList(), null);
        ContextAwareGroupingScript.Factory mockFactory = mock(ContextAwareGroupingScript.Factory.class);
        assertEquals(fields, mapper.fieldType().fields());
        // fields not present in properties of mapping
        ContextAwareGroupingFieldMapper mapper = new ContextAwareGroupingFieldMapper(
        );
            fieldType,
    private Mapper.TypeParser.ParserContext mockParserContext;
            fail(e.getMessage());
import static java.util.Collections.emptyMap;
public class ContextAwareGroupingFieldMapperTests extends OpenSearchTestCase {
    public void testValidScriptMapping() {
import org.opensearch.script.Script;
        );
import static org.mockito.ArgumentMatchers.any;
    }
        ContextAwareGroupingFieldType fieldType = new ContextAwareGroupingFieldType(Collections.emptyList(), null);
            () -> ContextAwareGroupingFieldMapper.PARSER.parse("context_aware_grouping", node, mockParserContext, mockObjectMapperBuilder)
            MapperParsingException.class,
            new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0))
        Map<String, Object> node = new HashMap<>();
            new ContextAwareGroupingFieldMapper.Builder("context_aware_grouping")
 * this file be licensed under the Apache-2.0 license or a
    }
            mapper.deriveSource(XContentFactory.jsonBuilder().startObject(), leafReader, 0);
    }
import static org.mockito.Mockito.mock;
        when(mockScriptService.compile(any(Script.class), eq(ContextAwareGroupingScript.CONTEXT))).thenReturn(mockFactory);
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parseCreateField(mockParseContext));
/*
            MapperParsingException.class,
import java.io.IOException;
        // Add a field to the mock ObjectMapper.Builder to satisfy the validation
        assertTrue(e.getMessage().contains("context_aware_grouping cannot be ingested in the document"));
    public void testContextAwareFieldMapperWithDerivedSource() throws IOException {
        List<String> fields = Collections.singletonList("keyword_field");
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parseCreateFieldForPluggableFormat(null));
        ContextAwareGroupingFieldType fieldType = new ContextAwareGroupingFieldType(Collections.emptyList(), null);
                mockParserContext,
        Map<String, Object> node1 = new HashMap<>();
                mockObjectMapperBuilder
        node1.put("fields", "not_a_list");
        Map<String, Object> scriptNode = new HashMap<>();
import java.util.Collections;
        // Multiple fields
        // Not a list
import org.junit.Before;
import org.opensearch.common.settings.Settings;
        assertNotNull(mapper.fieldType().compiledScript());
        assertTrue(e.getMessage().contains("Expected [fields] to be a list of strings but got [not_a_list]"));
        }
    private ObjectMapper.Builder mockObjectMapperBuilder;
            .parse("context_aware_grouping", node, mockParserContext, mockObjectMapperBuilder);
import static org.mockito.ArgumentMatchers.eq;
        assertTrue(e.getMessage().contains("context_aware_grouping cannot be ingested in the document"));
            fieldType,
import java.util.HashMap;
        ContextAwareGroupingFieldMapper.Builder builder = (ContextAwareGroupingFieldMapper.Builder) ContextAwareGroupingFieldMapper.PARSER
        when(mockFactory.newInstance()).thenReturn(mockScript);
    public void setUp() throws Exception {
        mockObjectMapperBuilder.add(new KeywordFieldMapper.Builder("keyword_field"));
        mockObjectMapperBuilder = new ObjectMapper.Builder("parent_field");
 *
            () -> ContextAwareGroupingFieldMapper.PARSER.parse("context_aware_grouping", node2, mockParserContext, mockObjectMapperBuilder)
    private ScriptService mockScriptService;
        );
            MapperParsingException.class,
        );
        node.put("fields", Collections.singletonList("blah"));
    }
            () -> ContextAwareGroupingFieldMapper.PARSER.parse(
package org.opensearch.index.mapper;
        );
 * The OpenSearch Contributors require contributions made to
        e = expectThrows(
            new ContextAwareGroupingFieldMapper.Builder("context_aware_grouping")
        node.put("script", scriptNode);
