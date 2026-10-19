import org.opensearch.common.xcontent.XContentType;
        assertFalse(parser.parse("type", new CompressedXContent(mapping)).sourceMapper().isComplete());  
            .endObject()
 * license agreements. See the NOTICE file distributed with
            .startObject()  
            .documentMapperParser()  
    }
            fail("Expected parse exception");
        }
            .toString();
            .endObject()
            .documentMapperParser()
        DocumentMapper documentMapper = createIndex("test").mapperService()
            sourceAsMap = parser.map();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Verify _source is not stored but recovery_source is
    public void testIncludesNotUpdateable() throws Exception {
        // using default of true  
        }
            .startObject("_source")  
            recoverySourceAsMap = parser.map();
        final IndexableField sourceIndexableField = doc.rootDoc().getField("_source");
            new SourceToParse(
        );
        documentMapper = parser.parse("type", new CompressedXContent(mapping));
            )  
                "1",
import java.util.Collection;
                        .endObject()
                        .endObject()
            .endObject()  
            .endObject()  
        );  
                    XContentFactory.jsonBuilder()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(sourceField.binaryValue()))) {  
                "1",
    public void testExcludesNotUpdateable() throws Exception {
                        .endObject()
import org.opensearch.core.common.bytes.BytesReference;
        Map<String, Object> recoverySourceAsMap;
            .endObject()  
            .startObject()  
                "1",
            .endObject()
        String mapping2 = XContentFactory.jsonBuilder()
            .endObject()
    }
                MediaTypeRegistry.JSON
 *  
            .endObject()
            .array("recovery_source_excludes", "path2*")
            .endObject()
            .array("includes", new String[] { "path1*" })
            .field("enabled", false)  
        } catch (MapperParsingException e) {  
                        .endObject()  
    @Override  
            new SourceToParse(
            .startObject("_source")
            .endObject()
            .field("enabled", false)
            .startObject("type")  
        assertFalse(parser.parse("type", new CompressedXContent(mapping)).sourceMapper().isComplete());
            .toString();  
        Map<String, Object> recoverySourceAsMap;  
    public void testIncludesForRecoverySource() throws Exception {  
        assertConflicts(defaultMapping, mapping1, parser, "Cannot update parameter [includes] from [[]] to [[foo.*]]");
        String mapping1 = XContentFactory.jsonBuilder()
            assertTrue(message, message.contains("Unexpected close marker '}'"));  
            .startObject("type")  
                MediaTypeRegistry.JSON
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
        try {
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(sourceField.binaryValue()))) {  
        }  
        ParsedDocument doc = documentMapper.parse(
        String mapping = XContentFactory.jsonBuilder()
            .endObject()  
                        .startObject("path2")
            .startObject()
            .endObject()
        DocumentMapper documentMapper = createIndex("test").mapperService()
/*
            new SourceToParse(  
            .endObject()
            )
            .toString();
            .toString();
        assertThat(sourceAsMap.containsKey("path1"), equalTo(false));  
            .array("excludes", "foo.*")  
            .toString();
            .toString();  
        );  
            .toString();  
            .array("includes", "foo.*")
        assertNotNull(recoverySourceIndexableField);  
 * specific language governing permissions and limitations
        assertFalse(parser.parse("type", new CompressedXContent(mapping)).sourceMapper().isComplete());
            .documentMapperParser()
        assertNull(doc.rootDoc().getField("_source"));  
            .startObject("type")
import org.opensearch.test.InternalSettingsPlugin;  
            .startObject("type")  
        assertThat(MediaTypeRegistry.xContent(doc.source().toBytesRef().bytes), equalTo(MediaTypeRegistry.JSON));
    public void testComplete() throws Exception {
            .startObject("_source")  
        assertTrue(parser.parse("type", new CompressedXContent(mapping)).sourceMapper().isComplete());
                        .field("field1", "value1")
            .endObject()
            .endObject()
            .startObject()
        String mapping = XContentFactory.jsonBuilder()
        Map<String, Object> sourceAsMap;
                "test",
            .startObject()
                BytesReference.bytes(XContentFactory.smileBuilder().startObject().field("field", "value").endObject()),  
        String mapping = XContentFactory.jsonBuilder()  
        DocumentMapper documentMapper = parser2.parse("type", new CompressedXContent(mapping2));  
            .startObject("_source")
                        .startObject("path1")
    }  
        assertThat(MediaTypeRegistry.xContentType(doc.source()), equalTo(XContentType.SMILE));  
            .toString();
                        .startObject("path1")
        assertConflicts(mapping1, mapping1, parser);
        assertNotNull(recoverySourceIndexableField);
    public void testDerivedSourceValidation() throws IOException {
            .endObject()
            .endObject()  
                MediaTypeRegistry.JSON  
        BytesReference source = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject());
            .parse("type", new CompressedXContent(mapping));  
                        .endObject()  
            new SourceToParse(
        DocumentMapper documentMapper = createIndex("test").mapperService()
            .endObject()  
    }  
        final String mapping3 = XContentFactory.jsonBuilder()
                    XContentFactory.jsonBuilder()
            .endObject()
            .startObject("type")
        // This should not throw an exception
            .endObject()
 *     http://www.apache.org/licenses/LICENSE-2.0
            .startObject("_source")
            .toString();
            .parse("type", new CompressedXContent(mapping));  
                "1",  
        assertThat(recoverySourceAsMap.containsKey("path2"), equalTo(false));
            .startObject("_source")
                        .endObject()
                        .field("field2", "value2")
            .endObject()  
    }
            .startObject("_source")  
            .endObject()
        }
            )
        DocumentMapper documentMapper = createIndex("test", Settings.builder().put("index.derived_source.enabled", true).build())  
 * the Apache License, Version 2.0 (the "License"); you may
        assertConflicts(mapping1, defaultMapping, parser, "Cannot update parameter [includes] from [[foo.*]] to [[]]");  
            () -> parser1.parse("type", new CompressedXContent(mapping1))
    public void testNoFormat() throws Exception {
        );
                        .endObject()  
import java.util.Map;
            new SourceToParse(
    public void testExcludes() throws Exception {
                ),
 * software distributed under the License is distributed on an
        assertNull("_source should not be stored when derived is enabled", doc.rootDoc().getField("_source"));
 * this work for additional information regarding copyright
            .startObject()
        assertNull(recoverySourceIndexableField);
    }  
        // Verify no _source field is stored  
        assertNull(sourceIndexableField);
 * under the License.  
                        .startObject()  
                "test",
            .startObject("_source")
import org.opensearch.core.common.bytes.BytesArray;
        String defaultMapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
                "test",
            .startObject("type")
                "test",
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");  
/*  
        ParsedDocument doc = documentMapper.parse(new SourceToParse("test", "1", source, MediaTypeRegistry.JSON));  
            .startObject()
        assertConflicts(mapping1, mapping3, parser);
        DocumentMapper documentMapper = parser.parse("type", new CompressedXContent(mapping));
        String mapping = XContentFactory.jsonBuilder()
                        .startObject()
            // (invalid JSON)
            .endObject()
            .startObject("_source")
        DocumentMapper documentMapper = createIndex("test", Settings.builder().put("index.derived_source.enabled", true).build())
            .startObject()  
            .endObject()  
                ),
                    XContentFactory.jsonBuilder()  
            .field("recovery_source_enabled", "false")  
            .toString();  
            .startObject()
            .endObject()  
        assertEquals("_source can't be disabled with index.derived_source.enabled enabled index setting", e.getMessage());
        final DocumentMapperParser parser3 = createIndex("test3", settings).mapperService().documentMapperParser();
        Settings settings = Settings.builder().put("index.derived_source.enabled", true).build();
            .array("excludes", "path1*")
import org.opensearch.common.xcontent.json.JsonXContent;  
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject()),  
                    XContentFactory.jsonBuilder()
            .endObject()
                        .field("field1", "value1")  
            .array("includes", "foo.*")  
    public void testRecoverySourceWithDerivedSource() throws IOException {
                        .endObject()
        Settings defaultSettings = Settings.builder().build();
            .endObject()
            .toString();
            new SourceToParse(  
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field1", "value1").endObject()),
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
 * GitHub history for details.
    public void testDerivedSourceDoesNotStoreSource() throws IOException {
        return pluginList(InternalSettingsPlugin.class);
            .mapperService()
            .startObject("_source")
        // Test 1: Cannot disable _source when derived source is enabled
        ParsedDocument doc = documentMapper.parse(  
        String mapping3 = XContentFactory.jsonBuilder()
        assertNotNull(recoverySourceIndexableField);
            .startObject("type")  
import org.apache.lucene.index.IndexableField;
            sourceAsMap = parser.map();
            .startObject("type")
            )
 *
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
            .startObject()
import java.io.IOException;  
        assertConflicts(mapping1, mapping1, parser);
                        .endObject()
 * Licensed to Elasticsearch under one or more contributor  
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            .startObject()  
        String mapping = XContentFactory.jsonBuilder()
        assertConflicts(mapping1, defaultMapping, parser, "Cannot update parameter [excludes] from [[foo.*]] to [[]]");  
            .field("enabled", false)
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(sourceField.binaryValue()))) {
        IndexableField sourceField = doc.rootDoc().getField("_source");
            .mapperService()
import org.opensearch.core.xcontent.XContentParser;
            .startObject("type")  
        // Test 2: Can disable _source when derived source is disabled (default)  
            .startObject("_source")  
            .endObject()  
            .endObject()
            .startObject("_source")
        // not changing is ok
            new SourceToParse(  
import static org.opensearch.index.MapperTestUtils.assertConflicts;
        );  
                        .field("field1", "value1")
        assertNull(doc.rootDoc().getField("_recovery_source"));
        // This should not throw an exception  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(recoverySourceIndexableField.binaryValue()))) {
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            .endObject()
    }  
            .startObject()
            new SourceToParse(  
        assertThat(recoverySourceAsMap.containsKey("path1"), equalTo(false));
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");  
        ParsedDocument doc = documentMapper.parse(
        ParsedDocument doc = documentMapper.parse(  
                XContentType.SMILE
        // Test 3: Can enable _source when derived source is enabled  
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
            .startObject("type")
            sourceAsMap = parser.map();  
            .endObject()
        IndexableField sourceField = doc.rootDoc().getField("_source");
            .array("includes", new String[] { "path1*" })
                MediaTypeRegistry.JSON  
        assertConflicts(mapping1, mapping2, parser, "Cannot update parameter [enabled] from [true] to [false]");
            .startObject()  
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field1", "value1").endObject()),  
 */
            .startObject("_source")
            .toString();
            .endObject()
                        .startObject("path1")  
            .startObject("type")
            .parse("type", new CompressedXContent(mapping));
            .documentMapperParser()
                        .startObject("path2")
        assertConflicts(mapping1, mapping2, parser, "Cannot update parameter [includes] from [[foo.*]] to [[foo.*, bar.*]]");
            .array("includes", "foo.*", "bar.*")  
            .endObject()  
        assertConflicts(mapping1, mapping2, parser, "Cannot update parameter [excludes]");
    public void testEnabledNotUpdateable() throws Exception {
/*  
            .field("recovery_source_enabled", true)  
        String mapping2 = XContentFactory.jsonBuilder()
import org.opensearch.common.compress.CompressedXContent;
 * You may obtain a copy of the License at  
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();  
            .startObject()  
                "test",
        final String mapping2 = XContentFactory.jsonBuilder()
            .array("recovery_source_includes", new String[] { "path2*" })  
import org.opensearch.common.xcontent.XContentFactory;
                MediaTypeRegistry.JSON
            .startObject()
        assertTrue(documentMapper.sourceMapper().enabled());
            .array("excludes", "foo.*", "bar.*")  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            documentMapper.parse(new SourceToParse("test", "1", new BytesArray("{}}"), MediaTypeRegistry.JSON)); // extra end object  
                MediaTypeRegistry.JSON
                ),  
            .toString();
            .startObject("type")
        assertFalse(documentMapper.sourceMapper().enabled());
            .field("enabled", false)
                        .startObject("path1")
                ),
        assertThat(recoverySourceAsMap.containsKey("path2"), equalTo(true));  
            .endObject()
            .toString();
            .endObject()
    }  
            .parse("type", new CompressedXContent(mapping));
        final String mapping1 = XContentFactory.jsonBuilder()  
 * compatible open source license.
            .startObject("_source")
            .field("enabled", "false")
 * ownership. Elasticsearch licenses this file to you under  
            .startObject()  
 *
 * The OpenSearch Contributors require contributions made to  
        String mapping1 = XContentFactory.jsonBuilder()
        assertNotNull(recoverySourceIndexableField);
                "test",  
        assertThat(sourceAsMap.containsKey("path2"), equalTo(true));
        IndexableField sourceField = doc.rootDoc().getField("_source");
            .startObject("type")
            .endObject()  
            .field("enabled", true)
            )  
    }
        documentMapper = parser3.parse("type", new CompressedXContent(mapping3));
            .toString();  
        mapping = XContentFactory.jsonBuilder()
            .endObject()  
            .startObject("_source")
            .endObject()  
            sourceAsMap = parser.map();
            .startObject("_source")
                "test",
            .endObject()  
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();  
            )
        settings = Settings.builder().put("index.derived_source.enabled", true).build();
        String mapping1 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
    public void testNoRecoverySourceAndNoSource_whenBothAreDisabled() throws Exception {  
        final DocumentMapperParser parser1 = createIndex("test", settings).mapperService().documentMapperParser();
    }
            .endObject()
    protected Collection<Class<? extends Plugin>> getPlugins() {
            .documentMapperParser()  
            .parse("type", new CompressedXContent(mapping));
        String mapping = XContentFactory.jsonBuilder()  
            .parse("type", new CompressedXContent(mapping));  
                        .field("field2", "value2")
        DocumentMapper documentMapper = parser.parse("type", new CompressedXContent(mapping));
        );
            )
    public void testExcludesForRecoverySource() throws Exception {
 */  
        assertNull(recoverySourceIndexableField);
            .startObject()
            .startObject("type")  
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();  
 * Unless required by applicable law or agreed to in writing,
            .startObject("type")
 * Modifications Copyright OpenSearch Contributors. See
            .documentMapperParser()
        DocumentMapper documentMapper = createIndex("test").mapperService()  
            .startObject("type")
import org.opensearch.plugins.Plugin;
                BytesReference.bytes(
        // not changing is ok
 * KIND, either express or implied.  See the License for the
        assertThat(sourceAsMap.containsKey("path2"), equalTo(false));  
        assertThat(recoverySourceAsMap.containsKey("path1"), equalTo(true));  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(recoverySourceIndexableField.binaryValue()))) {  
                        .field("field2", "value2")
                "1",  
        doc = documentMapper.parse(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(sourceField.binaryValue()))) {
            .endObject()
                        .field("field2", "value2")  
                BytesReference.bytes(
    }  
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();  
 * SPDX-License-Identifier: Apache-2.0
            .endObject()
import static org.hamcrest.Matchers.equalTo;
        assertThat(sourceAsMap.containsKey("path1"), equalTo(true));
            MapperParsingException.class,
            .endObject()
        final DocumentMapperParser parser2 = createIndex("test2", defaultSettings).mapperService().documentMapperParser();  
            .toString();
            .startObject("type")
            .endObject()  
            .startObject("_source")
                "test",
    }  
        }
            .endObject()
            .field("enabled", true)  
            .startObject("_source")  
            recoverySourceAsMap = parser.map();
                        .startObject("path2")  
            .endObject()
package org.opensearch.index.mapper;
        }  
        ParsedDocument doc = documentMapper.parse(
                        .endObject()  
        assertThat(sourceAsMap.containsKey("path1"), equalTo(false));
}
        // Create index with derived source enabled
    public void testIncludes() throws Exception {  
        String defaultMapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
                        .endObject()
    }
public class SourceFieldMapperTests extends OpenSearchSingleNodeTestCase {
            .endObject()
                        .startObject("path2")
            .endObject()
            .startObject()
            .endObject()
            .endObject()  
 * not use this file except in compliance with the License.
        ParsedDocument doc = documentMapper.parse(
        mapping = XContentFactory.jsonBuilder()  
        );
            assertNotNull(e.getRootCause());
            .toString();
                MediaTypeRegistry.JSON
            .startObject("_source")
            .parse("type", new CompressedXContent(mapping));
        assertConflicts(defaultMapping, mapping1, parser, "Cannot update parameter [excludes] from [[]] to [[foo.*]]");
                        .field("field1", "value1")
            .endObject()
        String mapping = XContentFactory.jsonBuilder()  
                        .endObject()  
            .endObject()
    public void testSourceObjectContainsExtraTokens() throws IOException {
            String message = e.getRootCause().getMessage();
                BytesReference.bytes(  
        assertThat(sourceAsMap.containsKey("path2"), equalTo(true));
        IndexableField sourceField = doc.rootDoc().getField("_source");  
        assertThat(sourceAsMap.containsKey("path2"), equalTo(false));
            .array("excludes", "foo.*")  
            .startObject("type")
        // not changing is ok
        Map<String, Object> sourceAsMap;  
        String mapping2 = XContentFactory.jsonBuilder()
                "1",
                BytesReference.bytes(
            .startObject("type")
            .endObject()  
        Map<String, Object> sourceAsMap;
        DocumentMapper documentMapper = createIndex("test").mapperService()
        assertThat(sourceAsMap.containsKey("path1"), equalTo(true));
            .endObject()
                "1",  
        ParsedDocument doc = documentMapper.parse(  
            .toString();
 */  
                "1",
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
                        .startObject()
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();  
                        .startObject()  
        Map<String, Object> sourceAsMap;
            .toString();
            .array("excludes", "path1*")
import org.opensearch.common.settings.Settings;  
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");  
        mapping = XContentFactory.jsonBuilder()
        MapperParsingException e = expectThrows(  
            .startObject()  
        }
            .documentMapperParser()  
            .endObject()
            .endObject()  
            )
    }
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();  
        );  
        );  
