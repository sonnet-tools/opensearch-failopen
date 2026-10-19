            .field("prefix", false)  
            .startObject()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        .startArray("completion")  
            .startObject()  
            .field("name", "ctx")
            .endArray();
                        .endObject()
            .endObject()
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
        document.add(new Field(text.name(), "category1", TextFieldMapper.Defaults.FIELD_TYPE));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
        MapperService mapperService = createIndex("test", Settings.EMPTY, mapping).mapperService();  
                        .endObject()  
                ),
        );
        String mapping = jsonBuilder().startObject()
    public void testQueryContextParsingMixedTypeObjectArray() throws Exception {
                        .array("input", "suggestion5", "suggestion6", "suggestion7")  
import static org.hamcrest.Matchers.equalTo;
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));  
            .startObject()
            .field("type", "completion")
            .endObject()  
            .array("type", "typr3", "ftg")
            .endObject()  
import org.opensearch.index.mapper.MapperParsingException;
            assertThat(internalQueryContexts.size(), equalTo(4));  
            .array("ctx", "ctx1", "ctx2", "ctx3")  
                "test",
                        .field("ctx", true)
            .array("input", "suggestion5", "suggestion6", "suggestion7")  
            .field("name", "ctx")
            .startObject("contexts")  
        }
        }
            .endObject()
        assertThat(context.size(), equalTo(0));  
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            )
            .field("boost", 2)  
                        .array("input", "suggestion5", "suggestion6", "suggestion7")
            .endObject()
            )
            .array("ctx", "ctx1", true, 100, null)
            .field("prefix", true)  
                BytesReference.bytes(  
import org.apache.lucene.document.IntPoint;  
            assertThat(internalQueryContexts.size(), equalTo(1));  
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            XContentParseException e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));  
        DocumentMapper defaultMapper = createIndex("test").mapperService()  
                MediaTypeRegistry.JSON
                        .startObject("completion")
            MapperParsingException.class,  
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));
            .toString();
        FieldType keywordFieldType = new FieldType();  
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));  
    public void testQueryContextParsingMixedTypeValuesArrayHavingNULL() throws Exception {
                    jsonBuilder().startObject()
        XContentBuilder builder = jsonBuilder().startObject()
            .field("context", "context2")  
            .endObject()
            .field("type", "completion")
 * KIND, either express or implied.  See the License for the
            .field("prefix", false)  
        CategoryContextMapping mapping = ContextBuilder.category("cat").field("category").build();
                        .field("weight", 5)
            .startObject("properties")
                        .endObject()
            .startArray("contexts")
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .startObject()
            )  
        assertContextSuggestFields(fields, 7);
            .startObject("completion")  
 * license agreements. See the NOTICE file distributed with
            .field("weight", 5)  
            .endObject()  
        assertContextSuggestFields(fields, 3);
            .endObject()
            .startObject()
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
            .endObject()
            .field("prefix", true)  
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
        String mapping = jsonBuilder().startObject()
            .field("type", "category")
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
import org.opensearch.index.mapper.KeywordFieldMapper;
            .parse("type1", new CompressedXContent(mapping));
            .endObject()
 *
                        .array("input", "suggestion5", "suggestion6", "suggestion7")  
                        .endObject()
            .parse("type1", new CompressedXContent(mapping));  
                        .startArray("completion")
            .startObject("properties")
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
        context = mapping.parseContext(document);
    }
        XContentBuilder builder = jsonBuilder().value(true);
 * SPDX-License-Identifier: Apache-2.0
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        // Ignore doc values  
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));  
            assertThat(e.getMessage(), containsString("category context must be an object, string, number or boolean"));
            .startObject()
            .parse("type1", new CompressedXContent(mapping));
        assertContextSuggestFields(fields, 3);
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);  
        assertEquals(  
            .startObject()
            .endObject()
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            assertThat(internalQueryContexts.get(3).boost, equalTo(1));  
import org.apache.lucene.document.StoredField;  
        ParsedDocument parsedDocument = defaultMapper.parse(
            assertThat(internalQueryContexts.get(1).boost, equalTo(1));  
            .field("type", "category")
                actualFieldCount++;
        ParsedDocument parsedDocument = defaultMapper.parse(  
            .toString();
            .field("type", "completion")
    public void testIndexingWithSimpleContexts() throws Exception {
                "test",  
            .startArray("contexts")
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
    }
            .nullValue()
        context = mapping.parseContext(document);
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());  
            .array("input", "suggestion5", "suggestion6", "suggestion7")  
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
        );  
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            .documentMapperParser()
        XContentBuilder builder = jsonBuilder().startArray()  
            .documentMapperParser()  
            .endArray()
    public void testQueryContextParsingMixed() throws Exception {
    static void assertContextSuggestFields(IndexableField[] fields, int expected) {
                "1",
            .field("name", "ctx")
            .endArray();
import org.opensearch.index.mapper.SourceToParse;
        keywordFieldType.setStored(true);
            .documentMapperParser()
            .endArray()
        }
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));  
            .field("boost", 3)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
 * under the License.  
            .startArray("completion")
            .field("prefix", false)
            .field("name", "ctx")
            .startObject("completion")  
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
        XContentBuilder builder = jsonBuilder().startObject().field("context", 333).field("boost", 10).field("prefix", true).endObject();
        );
            .startObject()  
                    jsonBuilder().startObject()
                        .startObject()
                        .endArray()
            .field("context", "context2")
            .startObject()  
            .endObject()
            assertThat(internalQueryContexts.get(3).context, equalTo("333"));
    }  
            .field("boost", 3)  
            .endObject()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .endArray()
            .field("name", "type")
            .field("context", 333)
        );
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
                        .startArray("completion")
            .field("boost", 3)
            .field("context", 333)
            new SourceToParse(  
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        document = new ParseContext.Document();
        assertContextSuggestFields(fields, 3);  
    public void testQueryContextParsingBasic() throws Exception {
            .endObject()  
        }
            .documentMapperParser()  
 * Modifications Copyright OpenSearch Contributors. See
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);  
import org.apache.lucene.document.Field;
    }  
            .field("weight", 5)
            .startObject()
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));
 * this work for additional information regarding copyright
 */  
            .startObject("completion")
    public void testQueryContextParsingArray() throws Exception {
            .startArray("contexts")
                        .endArray()  
        for (IndexableField field : fields) {  
        XContentBuilder builder = jsonBuilder().startObject().field("context", false).field("boost", 10).field("prefix", true).endObject();
                        .array("ctx", "ctx1", "ctx2", "ctx3")
                        .field("weight", 5)
            .field("boost", 2)
            .endObject()
            assertThat(internalQueryContexts.get(0).boost, equalTo(2));
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
        }
                MediaTypeRegistry.JSON  
            .value(false)
import org.opensearch.index.mapper.TextFieldMapper;  
            new SourceToParse(
                        .endObject()
            assertThat(internalQueryContexts.get(1).boost, equalTo(1));  
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            .endArray();  
            .startObject("completion")
            .startObject()
            .field("boost", 2)
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));
        assertContextSuggestFields(fields, 3);
            .field("type", "completion")
            .endArray();
            .endObject()
            assertThat(internalQueryContexts.size(), equalTo(2));
        document.add(new KeywordFieldMapper.KeywordField(keyword.name(), new BytesRef("category1"), keywordFieldType));
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));  
            assertThat(internalQueryContexts.get(2).isPrefix, equalTo(false));
                MediaTypeRegistry.JSON
            .startObject()
        assertThat(actualFieldCount, equalTo(expected));
            .field("context", "context1")
            .startObject("properties")
 * this file be licensed under the Apache-2.0 license or a
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
            .endObject()  
            .endObject()
import org.opensearch.common.compress.CompressedXContent;
            .field("boost", 3)
    public void testIndexingWithMixedTypeContextList() throws Exception {  
            assertThat(internalQueryContexts.get(3).context, equalTo("10"));
                MediaTypeRegistry.JSON
    public void testQueryContextParsingObjectHavingNULL() throws Exception {
                "1",
            assertThat(internalQueryContexts.size(), equalTo(2));  
                        .array("input", "suggestion5", "suggestion6", "suggestion7")
            .field("type", "category")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
            .startObject()  
            .documentMapperParser()  
            .endObject()
            .field("prefix", true)
import org.opensearch.common.settings.Settings;
    }
            assertThat(internalQueryContexts.get(2).context, equalTo("true"));
            .nullField("ctx")
    }
                        .field("weight", 5)
            .endObject()
            .field("type", "category")
            .value(false)  
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            .endObject()  
            .endObject()
            .startObject("properties")
            .field("boost", 3)
        DocumentMapper defaultMapper = createIndex("test").mapperService()
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            assertThat(internalQueryContexts.get(0).context, equalTo("333"));
                "test",
            .startArray("contexts")
        document.add(new SortedSetDocValuesField("category", new BytesRef("category")));
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));  
                        .endObject()  
                        .endObject()
                        .field("weight", 3)
            .endObject()  
            .endObject()  
    }
            .field("context", 333)  
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> mapping.parseContext(doc));  
            new SourceToParse(  
            assertThat(internalQueryContexts.size(), equalTo(1));  
    }
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");  
            .field("type", "completion")
        }
            .field("type", "category")
            .field("type", "category")
    public void testIndexingWithMixedTypeContextListHavingNULL() throws Exception {  
            .startObject()  
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();  
                        .endObject()  
        XContentBuilder builder = jsonBuilder().startArray()
                        .array("input", "suggestion5", "suggestion6", "suggestion7")  
            .field("type", "completion")  
            .endObject();  
            .endObject()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            () -> defaultMapper.parse(new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON))
        }
                    jsonBuilder().startObject()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
                ),
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
        document = new ParseContext.Document();  
            .field("prefix", true)
    }
            .endObject()
                "1",
                        .field("weight", 5)
            .field("context", true)
            .startArray("contexts")
                "test",
            .endObject()
        document.add(new SortedDocValuesField("category", new BytesRef("category")));  
                        .startObject("contexts")
            assertThat(internalQueryContexts.get(3).isPrefix, equalTo(false));
            new SourceToParse(  
                BytesReference.bytes(  
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));
            .field("prefix", false)  
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
        assertThat(context.size(), equalTo(0));
            .endObject()
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
            .startObject()  
            .startArray("completion")  
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));
            .endArray()
            .startObject()  
        ParseContext.Document document = new ParseContext.Document();  
            .startObject("properties")  
            .value(10)
            assertThat(internalQueryContexts.get(2).boost, equalTo(1));  
    public void testUnknownQueryContextParsing() throws Exception {
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());  
        String mapping = jsonBuilder().startObject()  
    }
            .documentMapperParser()
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
        );
            .documentMapperParser()
                        .startObject("contexts")
            assertThat(internalQueryContexts.get(0).boost, equalTo(10));
            XContentParseException e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));
            e.getCause().getMessage()
        XContentBuilder builder = jsonBuilder().startArray().value("context1").value("context2").endArray();  
 * ownership. Elasticsearch licenses this file to you under  
            .toString();
        XContentBuilder mapping = jsonBuilder().startObject()  
            assertThat(e.getMessage(), containsString("category context must be an object, string, number or boolean"));
            .startObject()  
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            .parse("type1", new CompressedXContent(mapping));  
        assertThat(exc.getMessage(), containsString("Failed to parse context field [category]"));
/*  
        XContentBuilder builder = jsonBuilder().startObject()  
            assertThat(internalQueryContexts.size(), equalTo(1));  
    }  
                        .field("ctx", "ctx1")
            .startObject()  
            new SourceToParse(
            .endObject()
        }
            .array("input", "suggestion5", "suggestion6", "suggestion7")
                        .endArray()
                MediaTypeRegistry.JSON
            .startObject()
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));  
import java.util.List;  
            .toString();
                "1",
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
                        .startObject()
import org.opensearch.index.mapper.MapperService;
            () -> defaultMapper.parse(new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON))
            .endObject()
        int actualFieldCount = 0;
            .startObject()  
import static org.hamcrest.Matchers.containsString;
        final ParseContext.Document doc = new ParseContext.Document();
        );
        }  
            .startObject("completion")  
    }
            .endObject()
            .startArray("contexts")  
    public void testNumberQueryContextParsingBasic() throws Exception {
            .endObject();
                        .field("weight", 5)  
            .startObject("completion")
    }
            .value("context2")
import org.apache.lucene.util.BytesRef;  
    }
import org.opensearch.index.mapper.ParsedDocument;
            .field("boost", 10)  
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));
            .field("context", 333)
            .field("prefix", true)
            assertThat(internalQueryContexts.get(0).boost, equalTo(2));  
            .startArray("contexts")
            .startObject("properties")
            .field("boost", 2)  
    }
            .endArray();  
            .startArray("contexts")  
            .field("type", "category")
            assertThat(internalQueryContexts.size(), equalTo(1));  
            MapperParsingException.class,  
    }
            .startObject()
            assertThat(internalQueryContexts.get(1).boost, equalTo(3));
            .startObject()
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
            .value("context2")  
 */
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            .endObject();
        }
            assertThat(internalQueryContexts.get(1).isPrefix, equalTo(false));
            .field("context", "context1")
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));  
    }
                        .endObject()
            .field("type", "category")  
        Exception e = expectThrows(
            .value("context2")
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));  
    }
            .endObject();
            .endObject()
            .startArray("contexts")
            .field("context", "context2")  
            .field("type", "completion")
            .field("boost", 3)  
            .field("name", "ctx")
            .field("prefix", true)
    }
            .startObject()
            .endObject()  
        String mapping = jsonBuilder().startObject()
                BytesReference.bytes(
 * The OpenSearch Contributors require contributions made to  
            .endObject()
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        XContentBuilder builder = jsonBuilder().nullValue();
        String mapping = jsonBuilder().startObject()
public class CategoryContextMappingTests extends OpenSearchSingleNodeTestCase {
            .toString();
            .startObject()
            assertThat(e.getMessage(), containsString("category context must be a string, number or boolean"));  
            .startObject("completion")
            .field("prefix", false)
            assertThat(internalQueryContexts.get(0).context, equalTo("true"));
                        .field("weight", 4)  
/*
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(false));  
        XContentBuilder builder = jsonBuilder().startObject()
            .startObject()  
            .endObject()  
    public void testIndexingWithMultipleContexts() throws Exception {  
            new SourceToParse(  
            .endObject()
        }
            .startObject("properties")
            .endObject()  
                "1",
            .toString();
        }
            .endObject()  
import org.opensearch.index.mapper.CompletionFieldMapper.CompletionFieldType;  
        Set<String> context = mapping.parseContext(document);
        }
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));
                        .startObject()
        KeywordFieldMapper.KeywordFieldType keyword = new KeywordFieldMapper.KeywordFieldType("category");
                        .endObject()  
import org.opensearch.search.suggest.completion.context.ContextBuilder;
                        .array("input", "suggestion3", "suggestion4")
                        .endObject()
    public void testQueryContextParsingMixedTypeValuesArray() throws Exception {
            .endArray()
        ParsedDocument parsedDocument = defaultMapper.parse(
            new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON)
        assertThat(context.size(), equalTo(1));  
                "test",
                        .endObject()  
            "contexts must be a string, number or boolean or a list of string, number or boolean, but was [VALUE_NULL]",
    }
            assertThat(internalQueryContexts.size(), equalTo(1));  
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
    public void testQueryContextParsingMixedHavingNULL() throws Exception {
            assertThat(internalQueryContexts.size(), equalTo(4));
            .endObject()  
            .field("name", "ctx")
            .startObject("completion")
                    jsonBuilder().startObject()  
        Exception e = expectThrows(
import java.util.Set;
            assertThat(internalQueryContexts.get(2).context, equalTo("true"));
/*  
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
import org.opensearch.common.xcontent.json.JsonXContent;  
                        .startObject("completion")
            )  
        }
import org.opensearch.index.mapper.DocumentMapper;
import org.apache.lucene.index.IndexableField;
        XContentBuilder builder = jsonBuilder().startObject()
            .field("prefix", false)
import org.opensearch.core.xcontent.XContentParseException;
import org.opensearch.core.common.bytes.BytesReference;
        document = new ParseContext.Document();  
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .value(true)  
            .field("context", "context1")
            .endObject()  
            .field("boost", 2)
            .documentMapperParser()
            assertThat(internalQueryContexts.get(0).context, equalTo("10"));
                        .startObject()
                BytesReference.bytes(  
            assertThat(e.getMessage(), containsString("category context must be a string, number or boolean"));
        }
            .startObject()
            .field("boost", 3)
            .startObject("completion")  
                        .endObject()
            assertThat(internalQueryContexts.get(2).boost, equalTo(1));  
    }
        String mapping = jsonBuilder().startObject()
                ),
            assertThat(internalQueryContexts.get(2).isPrefix, equalTo(false));  
            .startObject("properties")  
            .toString();  
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
            assertThat(internalQueryContexts.get(3).isPrefix, equalTo(false));  
    public void testIndexingWithContextList() throws Exception {  
 * GitHub history for details.
            .field("context", "context1")
        // Ignore stored field  
        );
            .endObject()
            .field("boost", 2)  
        assertContextSuggestFields(fields, 3);  
            .endObject()
            assertThat(internalQueryContexts.get(0).context, equalTo("false"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            .field("name", "ctx")  
                        .startObject("contexts")
        Exception e = expectThrows(IllegalArgumentException.class, () -> completionFieldType.getContextMappings().get("brand"));  
            .toString();  
 *  
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
        XContentBuilder builder = jsonBuilder().value("context1");
import org.apache.lucene.document.SortedSetDocValuesField;
}
 * You may obtain a copy of the License at  
        XContentBuilder builder = jsonBuilder().value(10);
                        .field("weight", 5)
            .endObject()
                        .endObject()
            .endObject()  
                    jsonBuilder().startObject()
        String mapping = jsonBuilder().startObject()
                    jsonBuilder().startObject()
import org.apache.lucene.document.SortedDocValuesField;
        XContentBuilder builder = jsonBuilder().startArray()  
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
        DocumentMapper defaultMapper = createIndex("test").mapperService()
        CompletionFieldType completionFieldType = (CompletionFieldType) mapperService.fieldType("completion");
        document.add(new StoredField(text.name(), "category1", TextFieldMapper.Defaults.FIELD_TYPE));
            .endObject()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
    }  
        String mapping = jsonBuilder().startObject()
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);  
            }  
                        .array("input", "suggestion1", "suggestion2")
            .endObject()
                BytesReference.bytes(  
            .startObject()
            .endArray()
        TextFieldMapper.TextFieldType text = new TextFieldMapper.TextFieldType("category");
            .parse("type1", new CompressedXContent(mapping));  
            .startObject()  
    }  
                        .array("ctx", "ctx1", true, 100)
        assertContextSuggestFields(fields, 3);  
        context = mapping.parseContext(document);
            .endObject()  
            .endObject()  
            .endArray();
                        .array("input", "suggestion5", "suggestion6", "suggestion7")  
            .field("prefix", true)  
import org.opensearch.index.mapper.Mapper;  
            .field("type", "completion")
            .field("prefix", true)
            .endObject()
            .endObject()
                        .endObject()  
            .value("context1")
    public void testQueryContextParsingObjectHavingBoolean() throws Exception {
            .endObject()
    public void testQueryContextParsingObjectHavingNumber() throws Exception {
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
import org.apache.lucene.document.FieldType;
    public void testQueryContextParsingMixedTypeObjectArrayHavingNULL() throws Exception {
        XContentBuilder builder = jsonBuilder().startObject().nullField("context").field("boost", 10).field("prefix", true).endObject();
            assertThat(internalQueryContexts.get(3).isPrefix, equalTo(true));
            assertThat(internalQueryContexts.get(2).boost, equalTo(3));
            assertThat(internalQueryContexts.get(0).isPrefix, equalTo(true));  
            .endObject()
package org.opensearch.search.suggest.completion;
            .field("type", "category")
            .parse("type1", new CompressedXContent(mapping));
                        .startObject("contexts")  
            .endObject()  
        XContentBuilder builder = jsonBuilder().startArray().value("context1").value("context2").value(true).value(10).endArray();  
                        .field("ctx", 100)  
        );
            .endObject()
    public void testIndexingWithNoContexts() throws Exception {  
    public void testBooleanQueryContextParsingBasic() throws Exception {
        assertEquals("context array must have string, number or boolean values, but was [VALUE_NULL]", e.getCause().getMessage());  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
    }  
            .field("prefix", false)
 * specific language governing permissions and limitations
            .endObject()  
            XContentParseException e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));
            .field("type", "completion")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
 * compatible open source license.
                        .startObject()  
        assertThat(context.size(), equalTo(1));  
 *
            .field("type", "category")
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .startObject("completion")  
            .endArray()
            .endObject()
            .nullValue()
            assertThat(internalQueryContexts.get(1).context, equalTo("context2"));
        ParsedDocument parsedDocument = defaultMapper.parse(
import org.opensearch.search.suggest.completion.context.ContextMapping;  
        ParsedDocument parsedDocument = defaultMapper.parse(
            .parse("type1", new CompressedXContent(mapping));  
            .endObject();  
                        .startObject("contexts")
            .endObject()
                MediaTypeRegistry.JSON  
            XContentParseException e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));  
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .startObject("properties")
    public void testIndexingWithSimpleNULLContexts() throws Exception {
            assertThat(internalQueryContexts.get(0).boost, equalTo(10));
            )
            .startArray("contexts")
            assertThat(internalQueryContexts.get(3).context, equalTo("333"));
import org.opensearch.core.xcontent.XContentParser;
        }
                        .endObject()
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            assertThat(internalQueryContexts.get(1).boost, equalTo(1));  
                        .endObject()  
            .documentMapperParser()
        assertTrue(context.contains("category1"));
            .field("type", "completion")  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                        .startArray("completion")
            .field("weight", 5)
    }
            assertThat(internalQueryContexts.get(0).boost, equalTo(1));  
                ),
    public void testParsingContextFromDocument() throws Exception {
        String mapping = jsonBuilder().startObject()
            assertThat(internalQueryContexts.get(2).context, equalTo("false"));
    }
                        .endArray()  
            .startObject("properties")
            .endObject()
 * Licensed to Elasticsearch under one or more contributor  
                "1",  
            .endObject()  
            .field("name", "ctx")  
            .field("context", "context1")
            .field("name", "type")
        assertEquals("Unknown context name [brand], must be one of [ctx, type]", e.getMessage());
            assertThat(internalQueryContexts.get(0).boost, equalTo(10));
            .endObject()
            if (field instanceof ContextSuggestField) {
        assertTrue(context.contains("category1"));
    }  
            Exception e = expectThrows(XContentParseException.class, () -> mapping.parseQueryContext(parser));  
import org.opensearch.index.mapper.ParseContext;  
            .startObject("contexts")
        XContentBuilder builder = jsonBuilder().startArray()  
        );  
            assertThat(e.getMessage(), containsString("category context must be an object, string, number or boolean"));
            assertThat(internalQueryContexts.get(2).isPrefix, equalTo(false));
                        .endObject()  
            .field("boost", 2)
            assertThat(internalQueryContexts.get(3).boost, equalTo(2));  
    public void testIndexingWithSimpleNumberContexts() throws Exception {  
            .endArray()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                BytesReference.bytes(
            assertThat(internalQueryContexts.size(), equalTo(1));  
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        Mapper fieldMapper = defaultMapper.mappers().getMapper("completion");
            .endArray()
            .endObject()  
        DocumentMapper defaultMapper = createIndex("test").mapperService()
        IndexableField[] fields = parsedDocument.rootDoc().getFields(fieldMapper.name());  
    public void testIndexingWithSimpleBooleanContexts() throws Exception {
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
            .endArray()  
    }  
            .field("name", "ctx")
            .endObject()
    public void testQueryContextParsingObjectArray() throws Exception {
        XContentBuilder builder = jsonBuilder().startArray()
            .toString();  
            .field("prefix", false)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
    public void testNULLQueryContextParsingBasic() throws Exception {
            .parse("type1", new CompressedXContent(mapping));  
import org.opensearch.core.xcontent.XContentBuilder;  
        document.add(new SortedSetDocValuesField(keyword.name(), new BytesRef("category1")));
        XContentBuilder builder = jsonBuilder().startArray()
import org.apache.lucene.search.suggest.document.ContextSuggestField;
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
 * software distributed under the License is distributed on an
        ParsedDocument parsedDocument = defaultMapper.parse(  
            .field("boost", 3)
                ),  
            assertThat(internalQueryContexts.get(0).context, equalTo("context1"));
 */  
            List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        doc.add(new IntPoint("category", 36));
            assertThat(internalQueryContexts.size(), equalTo(4));
                        .startObject()  
            .field("context", true)
 * Unless required by applicable law or agreed to in writing,
        ParsedDocument parsedDocument = defaultMapper.parse(
    public void testQueryContextParsingObject() throws Exception {  
            .startObject()
            .nullField("context")  
            assertThat(internalQueryContexts.get(0).boost, equalTo(2));
            .startObject("completion")  
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            .parse("type1", new CompressedXContent(mapping));
        }
                ),
            assertThat(internalQueryContexts.get(1).boost, equalTo(3));
            .field("type", "category")  
            .endArray()
            .field("type", "category")  
import org.opensearch.search.suggest.completion.context.CategoryContextMapping;
 * not use this file except in compliance with the License.
            .field("context", "context1")
        );
            .endArray()
            CategoryContextMapping mapping = ContextBuilder.category("cat").build();
            )  
            .field("name", "ctx")
            .startObject("contexts")
            assertThat(internalQueryContexts.get(3).boost, equalTo(3));
                "test",
                        .endObject()
