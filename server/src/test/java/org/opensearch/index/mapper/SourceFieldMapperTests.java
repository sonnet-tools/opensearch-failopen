            .startObject("type")
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
            .endObject()
    }
            .endObject()
            .startObject("type")
    public void testDerivedSourceDoesNotStoreSource() throws IOException {
public class SourceFieldMapperTests extends OpenSearchSingleNodeTestCase {
        mapping = XContentFactory.jsonBuilder()
            () -> parser1.parse("type", new CompressedXContent(mapping1))
 * The OpenSearch Contributors require contributions made to
                        .startObject()
            .startObject("_source")
        final DocumentMapperParser parser2 = createIndex("test2", defaultSettings).mapperService().documentMapperParser();
                        .endObject()
 * software distributed under the License is distributed on an
                "1",
            .endObject()
        String mapping2 = XContentFactory.jsonBuilder()
    }
            new SourceToParse(
                        .field("field2", "value2")
            .endObject()
        assertTrue(parser.parse("type", new CompressedXContent(mapping)).sourceMapper().isComplete());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(recoverySourceIndexableField.binaryValue()))) {
 * license agreements. See the NOTICE file distributed with
            .array("recovery_source_includes", new String[] { "path2*" })
        assertThat(recoverySourceAsMap.containsKey("path2"), equalTo(false));
        MapperParsingException e = expectThrows(
        Map<String, Object> recoverySourceAsMap;
            .startObject()
            .documentMapperParser()
        // Test 2: Can disable _source when derived source is disabled (default)
        IndexableField sourceField = doc.rootDoc().getField("_source");
        assertThat(MediaTypeRegistry.xContent(doc.source().toBytesRef().bytes), equalTo(MediaTypeRegistry.JSON));
            .field("enabled", false)
            .endObject()
import java.util.Map;
        assertNull(sourceIndexableField);
            .mapperService()
    }
            .startObject("_source")
        assertConflicts(defaultMapping, mapping1, parser, "Cannot update parameter [excludes] from [[]] to [[foo.*]]");
        documentMapper = parser3.parse("type", new CompressedXContent(mapping3));
            .endObject()
            .endObject()
 */
 * not use this file except in compliance with the License.
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
    }
        }
            .toString();
                    XContentFactory.jsonBuilder()
            new SourceToParse(
            .toString();
            .endObject()
            .endObject()
        DocumentMapper documentMapper = createIndex("test", Settings.builder().put("index.derived_source.enabled", true).build())
        assertThat(sourceAsMap.containsKey("path1"), equalTo(false));
 *     http://www.apache.org/licenses/LICENSE-2.0
            .toString();
        BytesReference source = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject());
            .endObject()
                ),
            new SourceToParse(
            .endObject()
                        .field("field2", "value2")
            .startObject("type")
 * this file be licensed under the Apache-2.0 license or a
                        .startObject("path2")
                        .startObject("path2")
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
            .endObject()
        settings = Settings.builder().put("index.derived_source.enabled", true).build();
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
        assertFalse(documentMapper.sourceMapper().enabled());
                        .field("field1", "value1")
        );
            .toString();
            // (invalid JSON)
            .endObject()
            .startObject()
            .endObject()
        String mapping3 = XContentFactory.jsonBuilder()
            .startObject("type")
            .field("enabled", false)
        String mapping = XContentFactory.jsonBuilder()
        ParsedDocument doc = documentMapper.parse(
    public void testExcludes() throws Exception {
        Map<String, Object> sourceAsMap;
            .startObject()
    }
        assertConflicts(mapping1, defaultMapping, parser, "Cannot update parameter [includes] from [[foo.*]] to [[]]");
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
                MediaTypeRegistry.JSON
import org.apache.lucene.index.IndexableField;
            .startObject()
            new SourceToParse(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(sourceField.binaryValue()))) {
            .array("excludes", "foo.*", "bar.*")
        final DocumentMapperParser parser1 = createIndex("test", settings).mapperService().documentMapperParser();
            .startObject("_source")
            .field("recovery_source_enabled", "false")
            .endObject()
                MediaTypeRegistry.JSON
                        .endObject()
            .array("includes", new String[] { "path1*" })
        ParsedDocument doc = documentMapper.parse(
            .startObject("type")
                        .startObject()
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            .endObject()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(sourceField.binaryValue()))) {
 *
        DocumentMapper documentMapper = createIndex("test").mapperService()
            .startObject()
            .endObject()
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field1", "value1").endObject()),
            .endObject()
        assertFalse(parser.parse("type", new CompressedXContent(mapping)).sourceMapper().isComplete());
    @Override
            .toString();
            .toString();
            .endObject()
import org.opensearch.core.common.bytes.BytesReference;
    public void testComplete() throws Exception {
            .endObject()
        assertNotNull(recoverySourceIndexableField);
            .startObject()
 *
        DocumentMapper documentMapper = createIndex("test").mapperService()
            .documentMapperParser()
                        .startObject("path1")
                        .startObject("path1")
            .endObject()
            .toString();
        DocumentMapper documentMapper = parser.parse("type", new CompressedXContent(mapping));
/*
            new SourceToParse(
        assertConflicts(mapping1, mapping2, parser, "Cannot update parameter [includes] from [[foo.*]] to [[foo.*, bar.*]]");
        String mapping = XContentFactory.jsonBuilder()
        // using default of true
                        .field("field2", "value2")
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
    }
                        .endObject()
            documentMapper.parse(new SourceToParse("test", "1", new BytesArray("{}}"), MediaTypeRegistry.JSON)); // extra end object
            .endObject()
                        .endObject()
        assertThat(recoverySourceAsMap.containsKey("path2"), equalTo(true));
                MediaTypeRegistry.JSON
                BytesReference.bytes(
            .startObject("type")
/*
        assertThat(sourceAsMap.containsKey("path2"), equalTo(true));
        doc = documentMapper.parse(
            .startObject("type")
            MapperParsingException.class,
            .endObject()
            .startObject()
        DocumentMapper documentMapper = createIndex("test").mapperService()
            .array("includes", "foo.*")
        }
            )
            .toString();
import org.opensearch.core.common.bytes.BytesArray;
 * You may obtain a copy of the License at
        documentMapper = parser.parse("type", new CompressedXContent(mapping));
            .startObject("_source")
        assertNotNull(recoverySourceIndexableField);
            )
                "test",
        String mapping = XContentFactory.jsonBuilder()
            .field("enabled", "false")
        ParsedDocument doc = documentMapper.parse(
                "test",
        IndexableField sourceField = doc.rootDoc().getField("_source");
            .field("enabled", true)
        assertConflicts(mapping1, mapping2, parser, "Cannot update parameter [excludes]");
import static org.opensearch.index.MapperTestUtils.assertConflicts;
            .toString();
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
    public void testIncludesForRecoverySource() throws Exception {
            .parse("type", new CompressedXContent(mapping));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                "test",
        );
            .startObject()
    public void testEnabledNotUpdateable() throws Exception {
        assertThat(sourceAsMap.containsKey("path1"), equalTo(true));
        return pluginList(InternalSettingsPlugin.class);
            .startObject("_source")
                        .endObject()
            .documentMapperParser()
        assertThat(sourceAsMap.containsKey("path2"), equalTo(false));
            .array("excludes", "path1*")
            .endObject()
import java.io.IOException;
                "1",
        );
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
            )
                MediaTypeRegistry.JSON
            .parse("type", new CompressedXContent(mapping));
                BytesReference.bytes(
            .endObject()
import org.opensearch.common.compress.CompressedXContent;
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
        assertThat(sourceAsMap.containsKey("path2"), equalTo(false));
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
        assertNull(recoverySourceIndexableField);
        ParsedDocument doc = documentMapper.parse(
            .endObject()
            .startObject()
        assertNull("_source should not be stored when derived is enabled", doc.rootDoc().getField("_source"));
            sourceAsMap = parser.map();
    public void testExcludesForRecoverySource() throws Exception {
            new SourceToParse(
                ),
 * Unless required by applicable law or agreed to in writing,
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
            )
import org.opensearch.plugins.Plugin;
                        .endObject()
    }
            .parse("type", new CompressedXContent(mapping));
 * the Apache License, Version 2.0 (the "License"); you may
            .endObject()
                "test",
            )
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
            .endObject()
                        .field("field1", "value1")
            .toString();
 * Modifications Copyright OpenSearch Contributors. See
            .endObject()
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
        final String mapping2 = XContentFactory.jsonBuilder()
                        .endObject()
            new SourceToParse(
                        .endObject()
            .startObject("type")
            .documentMapperParser()
                    XContentFactory.jsonBuilder()
            .array("includes", "foo.*")
            .endObject()
        );
            .documentMapperParser()
        // Verify _source is not stored but recovery_source is
            .endObject()
            new SourceToParse(
            .array("excludes", "path1*")
            .field("enabled", false)
        String mapping = XContentFactory.jsonBuilder()
import org.opensearch.common.xcontent.json.JsonXContent;
            sourceAsMap = parser.map();
                        .startObject()
        Map<String, Object> sourceAsMap;
        DocumentMapper documentMapper = parser2.parse("type", new CompressedXContent(mapping2));
        assertConflicts(mapping1, mapping1, parser);
            .parse("type", new CompressedXContent(mapping));
                "1",
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .startObject("_source")
import static org.hamcrest.Matchers.equalTo;
            sourceAsMap = parser.map();
 * this work for additional information regarding copyright
        assertFalse(parser.parse("type", new CompressedXContent(mapping)).sourceMapper().isComplete());
 *
            .parse("type", new CompressedXContent(mapping));
            .toString();
            .documentMapperParser()
            .array("includes", new String[] { "path1*" })
        Settings settings = Settings.builder().put("index.derived_source.enabled", true).build();
        assertNotNull(recoverySourceIndexableField);
            String message = e.getRootCause().getMessage();
            .startObject("type")
                        .field("field1", "value1")
 * under the License.
            .endObject()
        assertConflicts(mapping1, mapping2, parser, "Cannot update parameter [enabled] from [true] to [false]");
    }
        String mapping1 = XContentFactory.jsonBuilder()
                    XContentFactory.jsonBuilder()
            .startObject()
            .field("enabled", false)
        assertFalse(parser.parse("type", new CompressedXContent(mapping)).sourceMapper().isComplete());
            .toString();
        mapping = XContentFactory.jsonBuilder()
        Map<String, Object> sourceAsMap;
                MediaTypeRegistry.JSON
            .startObject("_source")
            .toString();
 */
                "1",
            .startObject("_source")
            .startObject("_source")
        // This should not throw an exception
            .startObject()
        mapping = XContentFactory.jsonBuilder()
            .array("excludes", "foo.*")
            .endObject()
    public void testNoRecoverySourceAndNoSource_whenBothAreDisabled() throws Exception {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(sourceField.binaryValue()))) {
            .startObject("type")
        assertNotNull(recoverySourceIndexableField);
                MediaTypeRegistry.JSON
                "test",
        assertThat(recoverySourceAsMap.containsKey("path1"), equalTo(true));
        // not changing is ok
        }
    }
            )
        assertEquals("_source can't be disabled with index.derived_source.enabled enabled index setting", e.getMessage());
        );
    }
            .parse("type", new CompressedXContent(mapping));
    }
        assertConflicts(mapping1, mapping3, parser);
}
    }
            .startObject()
        // Create index with derived source enabled
                        .field("field1", "value1")
        DocumentMapper documentMapper = createIndex("test").mapperService()
            .endObject()
        IndexableField sourceField = doc.rootDoc().getField("_source");
        );
import org.opensearch.test.InternalSettingsPlugin;
            .field("recovery_source_enabled", true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(MediaTypeRegistry.xContentType(doc.source()), equalTo(XContentType.SMILE));
    protected Collection<Class<? extends Plugin>> getPlugins() {
            .toString();
        assertNull(doc.rootDoc().getField("_source"));
        assertConflicts(mapping1, defaultMapping, parser, "Cannot update parameter [excludes] from [[foo.*]] to [[]]");
                        .endObject()
            .endObject()
        );
    public void testSourceObjectContainsExtraTokens() throws IOException {
            .startObject()
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject()),
            .array("includes", "foo.*", "bar.*")
            fail("Expected parse exception");
            .toString();
                BytesReference.bytes(
            .startObject("type")
            .startObject("_source")
            .toString();
        String mapping1 = XContentFactory.jsonBuilder()
            .mapperService()
            recoverySourceAsMap = parser.map();
        // Test 3: Can enable _source when derived source is enabled
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(sourceField.binaryValue()))) {
            .startObject("type")
                    XContentFactory.jsonBuilder()
                "test",
 * compatible open source license.
import org.opensearch.common.settings.Settings;
            .startObject()
            .startObject()
        } catch (MapperParsingException e) {
        assertTrue(documentMapper.sourceMapper().enabled());
                "1",
            .startObject("type")
            .toString();
            .startObject("type")
import org.opensearch.core.xcontent.XContentParser;
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
                        .endObject()
            .parse("type", new CompressedXContent(mapping));
        );
            .startObject("_source")
        assertNull(doc.rootDoc().getField("_recovery_source"));
            sourceAsMap = parser.map();
 * KIND, either express or implied.  See the License for the
        ParsedDocument doc = documentMapper.parse(
            .endObject()
/*
        String mapping2 = XContentFactory.jsonBuilder()
    public void testDerivedSourceValidation() throws IOException {
            .startObject()
        final String mapping1 = XContentFactory.jsonBuilder()
        final IndexableField recoverySourceIndexableField = doc.rootDoc().getField("_recovery_source");
        assertConflicts(mapping1, mapping1, parser);
            .array("recovery_source_excludes", "path2*")
    public void testIncludes() throws Exception {
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
                "1",
 */
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field1", "value1").endObject()),
                        .startObject()
        }
        // not changing is ok
                "test",
            .startObject("_source")
            .startObject("type")
        assertThat(sourceAsMap.containsKey("path1"), equalTo(false));
            .toString();
            .startObject("_source")
    }
        assertThat(recoverySourceAsMap.containsKey("path1"), equalTo(false));
        // Test 1: Cannot disable _source when derived source is enabled
        // This should not throw an exception
                        .startObject("path1")
            .endObject()
                BytesReference.bytes(XContentFactory.smileBuilder().startObject().field("field", "value").endObject()),
 * Licensed to Elasticsearch under one or more contributor
            .startObject("type")
                BytesReference.bytes(
            assertNotNull(e.getRootCause());
        // Verify no _source field is stored
        final IndexableField sourceIndexableField = doc.rootDoc().getField("_source");
        final DocumentMapperParser parser3 = createIndex("test3", settings).mapperService().documentMapperParser();
        }
                        .startObject("path1")
        assertConflicts(defaultMapping, mapping1, parser, "Cannot update parameter [includes] from [[]] to [[foo.*]]");
        // not changing is ok
        DocumentMapper documentMapper = parser.parse("type", new CompressedXContent(mapping));
            .startObject("_source")
                        .endObject()
                ),
            .endObject()
            .endObject()
        final String mapping3 = XContentFactory.jsonBuilder()
            .endObject()
    public void testExcludesNotUpdateable() throws Exception {
        String defaultMapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            )
                "1",
                        .startObject("path2")
        ParsedDocument doc = documentMapper.parse(
    }
        assertThat(sourceAsMap.containsKey("path2"), equalTo(true));
            .startObject("_source")
            .startObject("type")
            .endObject()
            .startObject("type")
import java.util.Collection;
    public void testRecoverySourceWithDerivedSource() throws IOException {
                        .field("field2", "value2")
        ParsedDocument doc = documentMapper.parse(
                ),
            .endObject()
import org.opensearch.common.xcontent.XContentType;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, new BytesArray(recoverySourceIndexableField.binaryValue()))) {
            recoverySourceAsMap = parser.map();
            .endObject()
            .startObject("_source")
            .startObject()
        Map<String, Object> sourceAsMap;
            .endObject()
            .startObject()
        DocumentMapper documentMapper = createIndex("test").mapperService()
            .startObject()
        Settings defaultSettings = Settings.builder().build();
            .endObject()
                XContentType.SMILE
        String defaultMapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            .endObject()
                MediaTypeRegistry.JSON
                "1",
        DocumentMapper documentMapper = createIndex("test", Settings.builder().put("index.derived_source.enabled", true).build())
            .endObject()
import org.opensearch.common.xcontent.XContentFactory;
                        .startObject("path2")
        );
            .startObject("_source")
            .startObject("type")
        String mapping1 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            .endObject()
            .endObject()
                "test",
    public void testNoFormat() throws Exception {
        }
            .endObject()
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(message, message.contains("Unexpected close marker '}'"));
            .startObject("_source")
 * specific language governing permissions and limitations
            .endObject()
            .endObject()
        assertNull(recoverySourceIndexableField);
            .array("excludes", "foo.*")
        }
        try {
        IndexableField sourceField = doc.rootDoc().getField("_source");
            .endObject()
 * ownership. Elasticsearch licenses this file to you under
        Map<String, Object> recoverySourceAsMap;
    public void testIncludesNotUpdateable() throws Exception {
            .toString();
            .documentMapperParser()
            )
            .startObject("_source")
 * GitHub history for details.
        assertThat(sourceAsMap.containsKey("path1"), equalTo(true));
            .endObject()
            .field("enabled", true)
    }
                        .endObject()
        String mapping = XContentFactory.jsonBuilder()
        String mapping2 = XContentFactory.jsonBuilder()
package org.opensearch.index.mapper;
        ParsedDocument doc = documentMapper.parse(new SourceToParse("test", "1", source, MediaTypeRegistry.JSON));
            .endObject()
