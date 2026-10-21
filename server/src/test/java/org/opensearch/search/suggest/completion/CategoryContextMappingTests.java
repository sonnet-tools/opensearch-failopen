            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
        ParsedDocument parsedDocument = defaultMapper.parse(
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
            .field("type", "completion")
            .startArray("contexts")
/*
    public void testBooleanQueryContextParsingBasic() throws Exception {
    public void testQueryContextParsingMixedHavingNULL() throws Exception {
            .startObject()
            assertThat(internalQueryContexts.get(0).boost, equalTo(2));
 * Modifications Copyright OpenSearch Contributors. See
            .field("type", "category")
import org.opensearch.index.mapper.MapperParsingException;
 * Licensed to Elasticsearch under one or more contributor
        // Ignore doc values
            .endObject()
            .startObject("completion")
            .field("prefix", true)
        ParsedDocument parsedDocument = defaultMapper.parse(
            .endArray()
                        .startArray("completion")
            .field("prefix", false)
    }
        assertContextSuggestFields(fields, 3);
            .toString();
            .startObject()
import org.opensearch.index.mapper.Mapper;
    public void testQueryContextParsingMixedTypeValuesArrayHavingNULL() throws Exception {
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .field("context", true)
                        .field("weight", 3)
        assertEquals("Unknown context name [brand], must be one of [ctx, type]", e.getMessage());
 * KIND, either express or implied.  See the License for the
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            .field("boost", 2)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        );
            .field("context", "context2")
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));
            assertThat(internalQueryContexts.size(), equalTo(1));
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
import org.apache.lucene.search.suggest.document.ContextSuggestField;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            .startObject()
            .startObject()
            .field("type", "category")
        XContentBuilder builder = jsonBuilder().startObject().field("context", 333).field("boost", 10).field("prefix", true).endObject();
            .toString();
            .field("context", "context1")
            .endObject()
            .field("type", "category")
            .endArray()
                "1",
 * the Apache License, Version 2.0 (the "License"); you may
            .field("context", "context1")
                        .endObject()
            .startObject("properties")
                MediaTypeRegistry.JSON
                        .field("ctx", 100)
import org.opensearch.index.mapper.ParsedDocument;
 *
    }
            .startObject("properties")
            .endObject()
            .field("name", "ctx")
        document = new ParseContext.Document();
        }
                        .startObject("contexts")
        final ParseContext.Document doc = new ParseContext.Document();
            assertThat(e.getMessage(), containsString("category context must be an object, string, number or boolean"));
            .field("boost", 2)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .parse("type1", new CompressedXContent(mapping));
            MapperParsingException.class,
            .endArray()
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));
        assertContextSuggestFields(fields, 3);
    }
            .field("name", "ctx")
                        .endObject()
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
            )
        }
            .field("context", "context2")
            assertThat(internalQueryContexts.size(), equalTo(4));
                "test",
            .toString();
            assertThat(internalQueryContexts.get(2).context, equalTo("true"));
                        .field("weight", 5)
            assertThat(internalQueryContexts.size(), equalTo(1));
        );
            assertThat(internalQueryContexts.get(3).isPrefix, equalTo(false));
            .startObject()
        assertContextSuggestFields(fields, 3);
            .field("context", 333)
 * license agreements. See the NOTICE file distributed with
            .endObject();
        for (IndexableField field : fields) {
                        .endObject()
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
            .startObject()
            .endObject()
            .field("context", 333)
import org.opensearch.index.mapper.KeywordFieldMapper;
            assertThat(internalQueryContexts.get(1).boost, equalTo(3));
            .field("context", "context1")
        XContentBuilder builder = jsonBuilder().startArray()
            assertThat(internalQueryContexts.get(3).isPrefix, equalTo(true));
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));
        }
            .startArray("contexts")
                        .endObject()
                "test",
                    jsonBuilder().startObject()
            .endObject()
        XContentBuilder builder = jsonBuilder().nullValue();
    }
import org.apache.lucene.document.SortedSetDocValuesField;
        assertContextSuggestFields(fields, 7);
            .startObject("completion")
        );
            .startObject("properties")
            )
import org.opensearch.core.xcontent.XContentBuilder;
            assertThat(internalQueryContexts.get(3).boost, equalTo(2));
                        .field("weight", 5)
    public void testIndexingWithSimpleContexts() throws Exception {
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));
            assertThat(internalQueryContexts.size(), equalTo(4));
            .parse("type1", new CompressedXContent(mapping));
import org.opensearch.search.suggest.completion.context.ContextBuilder;
            .startArray("contexts")
            .documentMapperParser()
        }
        }
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
            .endObject()
import org.apache.lucene.document.IntPoint;
        CategoryContextMapping mapping = ContextBuilder.category("cat").field("category").build();
            .field("name", "ctx")
            .startObject("completion")
            .endObject()
        assertThat(context.size(), equalTo(0));
            .field("boost", 3)
import org.opensearch.index.mapper.MapperService;
    }
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
            .nullField("context")
            assertThat(internalQueryContexts.get(0).boost, equalTo(10));
            .endObject()
 * ownership. Elasticsearch licenses this file to you under
        doc.add(new IntPoint("category", 36));
    }
        document.add(new SortedDocValuesField("category", new BytesRef("category")));
            assertThat(internalQueryContexts.get(2).context, equalTo("false"));
        DocumentMapper defaultMapper = createIndex("test").mapperService()
        XContentBuilder builder = jsonBuilder().startObject().field("context", false).field("boost", 10).field("prefix", true).endObject();
            .endObject()
            .startArray("contexts")
                ),
import org.opensearch.core.xcontent.XContentParser;
            .field("context", 333)
                    jsonBuilder().startObject()
            .field("boost", 3)
                        .startObject()
 * this work for additional information regarding copyright
                        .array("ctx", "ctx1", "ctx2", "ctx3")
            new SourceToParse(
            XContentParseException e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));
        DocumentMapper defaultMapper = createIndex("test").mapperService()
                        .endObject()
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
            .startArray("contexts")
            .field("prefix", true)
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
            Exception e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));
            .field("type", "completion")
            .startObject("properties")
    public void testIndexingWithSimpleNumberContexts() throws Exception {
            .field("type", "category")
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            .endArray()
import org.opensearch.index.mapper.CompletionFieldMapper.CompletionFieldType;
            .startArray("completion")
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
            assertThat(e.getMessage(), containsString("category context must be an object, string, number or boolean"));
        XContentBuilder builder = jsonBuilder().startArray()
            MapperParsingException.class,
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        Exception e = expectThrows(IllegalArgumentException.class, () -> completionFieldType.getContextMappings().get("brand"));
            .array("ctx", "ctx1", true, 100, null)
            .field("type", "category")
            "contexts must be a string, number or boolean or a list of string, number or boolean, but was [VALUE_NULL]",
        XContentBuilder builder = jsonBuilder().value(true);
            .startObject()
        document.add(new SortedSetDocValuesField(keyword.name(), new BytesRef("category1")));
 * this file be licensed under the Apache-2.0 license or a
            .startObject()
        Exception e = expectThrows(
    }
                        .field("weight", 5)
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
            .field("name", "ctx")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .field("type", "completion")
    }
            .endArray()
            .field("context", "context2")
    }
                        .array("input", "suggestion5", "suggestion6", "suggestion7")
                "test",
                        .endObject()
            .endObject()
                        .field("weight", 5)
        KeywordFieldMapper.KeywordFieldType keyword = new KeywordFieldMapper.KeywordFieldType("category");
            .array("type", "typr3", "ftg")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .endObject()
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
                ),
            assertThat(internalQueryContexts.size(), equalTo(1));
                        .field("weight", 5)
            .field("prefix", true)
        }
                actualFieldCount++;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            assertThat(internalQueryContexts.get(3).isPrefix, equalTo(false));
            .startObject("completion")
        DocumentMapper defaultMapper = createIndex("test").mapperService()
    }
            .field("prefix", true)
                        .endObject()
            .startObject()
                        .startObject()
    public void testNumberQueryContextParsingBasic() throws Exception {
            assertThat(internalQueryContexts.get(3).context, equalTo("10"));
                        .endObject()
                        .endObject()
            assertThat(internalQueryContexts.get(2).isPrefix, equalTo(false));
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
        ParsedDocument parsedDocument = defaultMapper.parse(
                BytesReference.bytes(
        String mapping = jsonBuilder().startObject()
        }
            .value("context2")
                        .endObject()
            .toString();
 * software distributed under the License is distributed on an
            .startObject()
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
            .field("type", "category")
                BytesReference.bytes(
 */
            .field("name", "ctx")
import static org.hamcrest.Matchers.containsString;
                        .array("ctx", "ctx1", true, 100)
            .field("prefix", false)
            .toString();
        assertTrue(context.contains("category1"));
                ),
        MapperService mapperService = createIndex("test", Settings.EMPTY, mapping).mapperService();
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));
            assertThat(internalQueryContexts.size(), equalTo(2));
            .endObject()
            .array("input", "suggestion5", "suggestion6", "suggestion7")
            .field("boost", 2)
            .field("type", "category")
import org.apache.lucene.document.FieldType;
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));
            }
            )
            .endObject()
        document.add(new SortedSetDocValuesField("category", new BytesRef("category")));
        }
                        .startArray("completion")
    }
            .field("context", "context1")
            .endObject();
        }
        String mapping = jsonBuilder().startObject()
        }
                        .startObject()
            .value(10)
            .startObject("properties")
            .endArray()
            .parse("type1", new CompressedXContent(mapping));
                        .startObject("completion")
                    jsonBuilder().startObject()
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
    }
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));
        XContentBuilder builder = jsonBuilder().value("context1");
package org.opensearch.search.suggest.completion;
            XContentParseException e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));
            .field("type", "completion")
public class CategoryContextMappingTests extends OpenSearchSingleNodeTestCase {
        XContentBuilder builder = jsonBuilder().startObject()
            .startObject()
                        .startObject("contexts")
            .toString();
                    jsonBuilder().startObject()
        }
        XContentBuilder builder = jsonBuilder().startObject()
            .endObject()
    public void testQueryContextParsingMixedTypeValuesArray() throws Exception {
        document.add(new KeywordFieldMapper.KeywordField(keyword.name(), new BytesRef("category1"), keywordFieldType));
            .startObject()
        assertTrue(context.contains("category1"));
        assertEquals(
        );
                        .array("input", "suggestion3", "suggestion4")
            assertThat(internalQueryContexts.get(1).boost, equalTo(1));
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));
            .endObject()
            assertThat(internalQueryContexts.get(2).context, equalTo("true"));
            .endObject()
            .endObject()
        );
            new SourceToParse(
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));
                BytesReference.bytes(
            .startObject()
            .field("prefix", true)
            .endObject()
        XContentBuilder builder = jsonBuilder().startObject().nullField("context").field("boost", 10).field("prefix", true).endObject();
            .field("prefix", true)
            assertThat(internalQueryContexts.get(0).boost, equalTo(2));
            .endObject()
                        .startObject("completion")
                MediaTypeRegistry.JSON
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
        int actualFieldCount = 0;
            .endObject()
            .field("type", "category")
            .field("context", "context1")
            assertThat(internalQueryContexts.get(3).context, equalTo("333"));
        XContentBuilder mapping = jsonBuilder().startObject()
            .startObject()
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));
    }
            .field("weight", 5)
        assertThat(actualFieldCount, equalTo(expected));
            assertThat(e.getMessage(), containsString("category context must be an object, string, number or boolean"));
            .endObject()
                "1",
            .startObject("completion")
            .field("name", "ctx")
            .parse("type1", new CompressedXContent(mapping));
            .endObject()
                        .endObject()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
 */
            .documentMapperParser()
        assertContextSuggestFields(fields, 3);
            .startObject()
    public void testIndexingWithNoContexts() throws Exception {
    public void testIndexingWithSimpleNULLContexts() throws Exception {
            .endObject()
            .endObject()
                        .endObject()
            .endObject()
            .field("type", "completion")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
 * compatible open source license.
    public void testIndexingWithContextList() throws Exception {
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
                        .array("input", "suggestion5", "suggestion6", "suggestion7")
                "test",
            .startObject()
        }
            .endObject();
import org.opensearch.core.xcontent.XContentParseException;
    public void testUnknownQueryContextParsing() throws Exception {
            assertThat(e.getMessage(), containsString("category context must be a string, number or boolean"));
        XContentBuilder builder = jsonBuilder().startArray()
            .field("name", "ctx")
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
import java.util.Set;
                "1",
        Set<String> context = mapping.parseContext(document);
                "test",
            .endArray();
            .endArray()
                ),
            new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON)
        assertContextSuggestFields(fields, 3);
        document = new ParseContext.Document();
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
                        .startArray("completion")
    }
            .field("type", "completion")
        assertThat(context.size(), equalTo(1));
        // Ignore stored field
            .field("context", "context1")
            assertThat(internalQueryContexts.get(0).context, equalTo("333"));
            .endObject()
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            .array("input", "suggestion5", "suggestion6", "suggestion7")
    public void testQueryContextParsingMixedTypeObjectArrayHavingNULL() throws Exception {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
    }
            .endObject()
                        .array("input", "suggestion5", "suggestion6", "suggestion7")
        ParseContext.Document document = new ParseContext.Document();
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
            .value(false)
            .endArray();
            .toString();
            .startObject()
            .field("weight", 5)
        XContentBuilder builder = jsonBuilder().startArray()
        document.add(new Field(text.name(), "category1", TextFieldMapper.Defaults.FIELD_TYPE));
            .value(true)
                "test",
                        .field("ctx", true)
            .endObject()
            .parse("type1", new CompressedXContent(mapping));
            .field("boost", 2)
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
/*
 * SPDX-License-Identifier: Apache-2.0
            .field("weight", 5)
            .startObject("properties")
        );
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .parse("type1", new CompressedXContent(mapping));
    public void testParsingContextFromDocument() throws Exception {
import java.util.List;
    }
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));
            .startObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
            .endObject()
            new SourceToParse(
            .startObject("completion")
            .field("boost", 2)
            .endObject()
import org.opensearch.index.mapper.DocumentMapper;
 */
                    jsonBuilder().startObject()
            .startObject()
            .startObject("contexts")
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
                "1",
        String mapping = jsonBuilder().startObject()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .value("context1")
        XContentBuilder builder = jsonBuilder().value(10);
            .endArray()
            XContentParseException e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));
    }
import org.opensearch.search.suggest.completion.context.ContextMapping;
 *
            .endObject()
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));
            .endObject()
            .startArray("contexts")
            .field("prefix", true)
            assertThat(internalQueryContexts.get(1).boost, equalTo(1));
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> mapping.parseContext(doc));
            .documentMapperParser()
    }
            .startObject("contexts")
    public void testIndexingWithMultipleContexts() throws Exception {
            .documentMapperParser()
        );
        FieldType keywordFieldType = new FieldType();
            .field("name", "ctx")
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
        ParsedDocument parsedDocument = defaultMapper.parse(
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));
            .endObject()
                        .endObject()
            .startObject()
            .documentMapperParser()
    public void testQueryContextParsingMixedTypeObjectArray() throws Exception {
 *
 * You may obtain a copy of the License at
            assertThat(internalQueryContexts.get(2).isPrefix, equalTo(false));
            .startObject("properties")
                MediaTypeRegistry.JSON
        DocumentMapper defaultMapper = createIndex("test").mapperService()
                        .endArray()
                        .endObject()
            .startObject()
            .endArray();
                        .startObject("contexts")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .documentMapperParser()
            assertThat(internalQueryContexts.get(0).boost, equalTo(2));
        String mapping = jsonBuilder().startObject()
    }
import static org.hamcrest.Matchers.equalTo;
            .field("name", "type")
            assertThat(internalQueryContexts.get(0).boost, equalTo(10));
            () -> defaultMapper.parse(new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON))
            .endObject()
            .field("name", "ctx")
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
                BytesReference.bytes(
        String mapping = jsonBuilder().startObject()
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
            .nullValue()
        keywordFieldType.setStored(true);
            .startObject()
            .endObject()
            .startObject()
                        .startObject("contexts")
            .endObject()
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .field("prefix", false)
            .field("type", "completion")
 * specific language governing permissions and limitations
            .field("prefix", false)
        document = new ParseContext.Document();
        }
        XContentBuilder builder = jsonBuilder().startArray().value("context1").value("context2").endArray();
            .startObject("properties")
            assertThat(internalQueryContexts.get(3).boost, equalTo(1));
            )
            .startArray("completion")
                        .startObject("contexts")
            assertThat(internalQueryContexts.size(), equalTo(1));
                BytesReference.bytes(
    public void testQueryContextParsingArray() throws Exception {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .endObject();
        );
        TextFieldMapper.TextFieldType text = new TextFieldMapper.TextFieldType("category");
    static void assertContextSuggestFields(IndexableField[] fields, int expected) {
            .endObject()
    public void testQueryContextParsingMixed() throws Exception {
        document.add(new StoredField(text.name(), "category1", TextFieldMapper.Defaults.FIELD_TYPE));
import org.apache.lucene.index.IndexableField;
            .endObject()
                "1",
        context = mapping.parseContext(document);
            assertThat(internalQueryContexts.size(), equalTo(1));
            .startObject("properties")
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
        ParsedDocument parsedDocument = defaultMapper.parse(
    public void testQueryContextParsingObjectHavingBoolean() throws Exception {
            assertThat(internalQueryContexts.get(0).context, equalTo("10"));
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
        assertContextSuggestFields(fields, 3);
    public void testQueryContextParsingObject() throws Exception {
            .field("context", true)
            .endObject()
                        .startObject()
            .field("type", "category")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .endObject()
        String mapping = jsonBuilder().startObject()
import org.opensearch.core.common.bytes.BytesReference;
            .startObject()
            assertThat(internalQueryContexts.get(0).boost, equalTo(10));
            assertThat(internalQueryContexts.size(), equalTo(2));
            .startObject("completion")
            XContentParseException e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));
                "1",
            .parse("type1", new CompressedXContent(mapping));
            .field("boost", 3)
            .endObject()
import org.opensearch.common.settings.Settings;
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            .field("prefix", false)
                        .startObject()
    }
            assertThat(internalQueryContexts.size(), equalTo(1));
import org.opensearch.search.suggest.completion.context.CategoryContextMapping;
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        XContentBuilder builder = jsonBuilder().startObject()
}
                        .array("input", "suggestion5", "suggestion6", "suggestion7")
            .value(false)
import org.apache.lucene.document.Field;
            .field("type", "completion")
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
            .endObject()
            .startObject()
            .endObject()
                BytesReference.bytes(
        Exception e = expectThrows(
import org.opensearch.common.xcontent.json.JsonXContent;
            .endObject()
                ),
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
    public void testIndexingWithMixedTypeContextListHavingNULL() throws Exception {
import org.opensearch.index.mapper.ParseContext;
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            assertThat(internalQueryContexts.size(), equalTo(4));
            .field("name", "ctx")
            assertThat(e.getMessage(), containsString("category context must be a string, number or boolean"));
                MediaTypeRegistry.JSON
                        .field("ctx", "ctx1")
            .endObject()
import org.apache.lucene.document.SortedDocValuesField;
        String mapping = jsonBuilder().startObject()
 * Unless required by applicable law or agreed to in writing,
            assertThat(internalQueryContexts.get(2).boost, equalTo(1));
            .endObject()
        );
        assertThat(exc.getMessage(), containsString("Failed to parse context field [category]"));
                        .endObject()
                MediaTypeRegistry.JSON
            .startObject("properties")
            .endObject()
            .field("prefix", false)
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));
                        .array("input", "suggestion5", "suggestion6", "suggestion7")
        assertThat(context.size(), equalTo(0));
        XContentBuilder builder = jsonBuilder().startArray().value("context1").value("context2").value(true).value(10).endArray();
            .startObject("completion")
            .field("prefix", false)
            .field("type", "completion")
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));
            .value("context2")
            .endObject()
    }
            .endArray()
        ParsedDocument parsedDocument = defaultMapper.parse(
            .field("boost", 3)
    public void testQueryContextParsingObjectHavingNULL() throws Exception {
            .field("boost", 3)
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            .endObject()
                        .endObject()
            .endArray();
import org.opensearch.index.mapper.SourceToParse;
            .startArray("contexts")
import org.opensearch.index.mapper.TextFieldMapper;
            .parse("type1", new CompressedXContent(mapping));
    }
            () -> defaultMapper.parse(new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON))
    public void testQueryContextParsingObjectArray() throws Exception {
import org.opensearch.common.compress.CompressedXContent;
            .endObject()
                        .endArray()
            .startArray("contexts")
            assertThat(internalQueryContexts.get(3).boost, equalTo(3));
            .startObject()
            .endArray();
        XContentBuilder builder = jsonBuilder().startArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .startArray("contexts")
            .endObject()
/*
            .field("prefix", true)
            .endArray()
            .documentMapperParser()
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
            .endObject()
                        .array("input", "suggestion5", "suggestion6", "suggestion7")
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));
    public void testNULLQueryContextParsingBasic() throws Exception {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        }
                MediaTypeRegistry.JSON
            )
        assertEquals("context array must have string, number or boolean values, but was [VALUE_NULL]", e.getCause().getMessage());
                    jsonBuilder().startObject()
            .field("name", "type")
            .field("type", "category")
            assertThat(internalQueryContexts.get(2).isPrefix, equalTo(false));
        DocumentMapper defaultMapper = createIndex("test").mapperService()
        String mapping = jsonBuilder().startObject()
            .array("input", "suggestion5", "suggestion6", "suggestion7")
                        .endObject()
    }
import org.apache.lucene.util.BytesRef;
            .field("boost", 3)
            .startObject()
            .endObject()
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));
        context = mapping.parseContext(document);
            .toString();
            .endArray();
            .startObject("completion")
            .endObject()
            .endObject()
            .field("type", "completion")
            assertThat(internalQueryContexts.get(2).boost, equalTo(1));
        assertThat(context.size(), equalTo(1));
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        XContentBuilder builder = jsonBuilder().startObject()
            .toString();
 * The OpenSearch Contributors require contributions made to
            .endObject()
        XContentBuilder builder = jsonBuilder().startArray()
    public void testIndexingWithSimpleBooleanContexts() throws Exception {
            .endObject()
            .field("boost", 3)
    public void testQueryContextParsingBasic() throws Exception {
            .documentMapperParser()
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                ),
                        .array("input", "suggestion1", "suggestion2")
            .endObject()
            .field("boost", 2)
        }
        ParsedDocument parsedDocument = defaultMapper.parse(
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .startObject("completion")
    public void testIndexingWithMixedTypeContextList() throws Exception {
                        .endObject()
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .startObject()
 * not use this file except in compliance with the License.
            .endObject()
                        .endArray()
            .startObject()
            assertThat(internalQueryContexts.get(3).context, equalTo("333"));
    }
    public void testQueryContextParsingObjectHavingNumber() throws Exception {
        CompletionFieldType completionFieldType = (CompletionFieldType) mapperService.fieldType("completion");
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
        }
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));
            .startObject("contexts")
            assertThat(internalQueryContexts.get(1).boost, equalTo(1));
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));
            .endObject()
                        .field("weight", 4)
            assertThat(internalQueryContexts.get(2).boost, equalTo(3));
            .field("type", "category")
        String mapping = jsonBuilder().startObject()
            .array("ctx", "ctx1", "ctx2", "ctx3")
            new SourceToParse(
    }
            .endObject()
            if (field instanceof ContextSuggestField) {
            .field("boost", 2)
            .parse("type1", new CompressedXContent(mapping));
            new SourceToParse(
            .startObject("completion")
        context = mapping.parseContext(document);
            .field("boost", 3)
            assertThat(internalQueryContexts.get(1).boost, equalTo(3));
            new SourceToParse(
import org.apache.lucene.document.StoredField;
            .endArray()
            .field("boost", 10)
    }
            e.getCause().getMessage()
            assertThat(internalQueryContexts.get(0).context, equalTo("true"));
                        .field("weight", 5)
            .field("context", 333)
                        .endObject()
            .startArray("contexts")
            .endArray()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                        .startArray("completion")
            .field("type", "category")
            .field("prefix", false)
 * GitHub history for details.
            .endObject();
            .documentMapperParser()
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));
            .nullField("ctx")
                        .startObject()
            assertThat(internalQueryContexts.get(0).context, equalTo("false"));
            )
        );
 * under the License.
                        .endArray()
            .nullValue()
    }
            .value("context2")
            .endObject()
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));
