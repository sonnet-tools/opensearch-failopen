        assertThat(mergedMapper.meta().get("foo"), equalTo("bar"));
                b.field("field", "value");
 */
            b.startObject("_meta");
/*
        public void addField(MappedFieldType fieldType, Object value) {
        }), mockInput);
        DocumentMapper mergedMapper = initMapper.merge(updatedMapper.mapping(), MergeReason.INDEX_TEMPLATE);
                {
            b.endObject();
            b.field("search_analyzer", "whitespace");
import static org.hamcrest.Matchers.equalTo;
        {
        public long getFieldCount(String fieldName) {
            b.field("analyzer", "default");
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
        ParsedDocument doc = mapper.parse(source(b -> {
    public void testAddFields() throws Exception {
            {
            assertThat(e.getMessage(), containsString("cannot change object mapping from non-nested to nested"));
                    b.startObject("field").field("type", "text").endObject();
import org.opensearch.index.analysis.AnalyzerScope;
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
                    final String fieldName = Integer.toString(i);
        merge(mapperService, MergeReason.INDEX_TEMPLATE, topMapping(b -> b.startObject("_source").field("enabled", true).endObject()));
import org.apache.lucene.analysis.core.KeywordAnalyzer;
            b.field("type", "text");
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
 * Unless required by applicable law or agreed to in writing,
        }));
        // but merged should
        private final Map<String, Object> fields = new HashMap<>();
                final String fieldName = lastIntroducedFieldName.get();
        // stage1 mapping should not have been modified
                {
        assertThat(mergedMapper.meta().get("foo"), equalTo("new_bar"));
                ParsedDocument parsedDoc = mapperService.documentMapper().parse(source(b -> b.field(fieldName, "test")));
 * specific language governing permissions and limitations
        }
        public void close() {}
            b.startObject("age").field("type", "integer").endObject();
            b.startObject("name").field("type", "text").endObject();
            }
    }
            () -> documentMapper.mappers().indexAnalyzer().tokenStream("non_existing_field", "foo")
        updatedMapper = createDocumentMapper(topMapping(b -> {
 * Modifications Copyright OpenSearch Contributors. See
            IllegalArgumentException e = expectThrows(
                b.endObject();
        assertNull(mapper.root().dynamic());
    public void testParseWithDocumentInputNestedObject() throws IOException {
            b.field("analyzer", "default");
        final MapperService mapperService = createMapperService(mapping(b -> {}));
                    b.field("field2", "value2");
        analyzers.put("keyword", new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer()));
            } catch (Exception e) {
        updater.start();
        DocumentMapper mapper = mapperService.documentMapper();
}
            b.endObject();
            b.field("analyzer", "default");
    @Override
            b.field("type", "text");
        }));
        DocumentMapper updatedMapper = createDocumentMapper(fieldMapping(b -> b.field("type", "text")));
            }
 * software distributed under the License is distributed on an
        }
 * compatible open source license.
                }
                {
                b.startObject("object");
    }
        mergedMapper = mergedMapper.merge(updatedMapper.mapping(), MergeReason.INDEX_TEMPLATE);
        final AtomicReference<Exception> error = new AtomicReference<>();
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.atomic.AtomicReference;
 * Licensed to Elasticsearch under one or more contributor
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            b.field("field", "value");
    }
        assertThat(initMapper.meta(), equalTo(expected));
            assertThat(e.getMessage(), containsString("cannot change object mapping from nested to non-nested"));
                }
            try {
            b.endObject();
        DocumentMapper initMapper = createDocumentMapper(topMapping(b -> {
import org.apache.lucene.analysis.standard.StandardAnalyzer;
                    mapperService.merge("_doc", new CompressedXContent(update.toString()), MergeReason.MAPPING_UPDATE);
        merge(mapperService, fieldMapping(b -> b.field("type", "text")));
        }
            throw error.get();
        DocumentInput<Map<String, Object>> mockInput = new MockDocumentInput();
import static org.hamcrest.Matchers.nullValue;
        }));
        }));
        assertThat(mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer().name(), equalTo("default"));
        mergedMapper = initMapper.merge(updatedMapper.mapping(), MergeReason.MAPPING_UPDATE);
import java.util.HashMap;
        merge(mapperService, fieldMapping(b -> {
        assertNotNull(mapperService.documentMapper().mappers().getMapper("field"));
        final AtomicBoolean stopped = new AtomicBoolean(false);
            b.field("type", "text");
 */
 * this file be licensed under the Apache-2.0 license or a
        DocumentMapper stage1 = createDocumentMapper(mapping(b -> b.startObject("name").field("type", "text").endObject()));
 */
                b.endObject();
                () -> objectMapper.merge(nestedMapper.mapping(), reason)
import java.util.concurrent.CyclicBarrier;
                b.endObject();
            return fields.containsKey(fieldName) ? 1 : 0;
        DocumentMapper initMapper = createDocumentMapper(topMapping(b -> b.startObject("_meta").field("foo", "bar").endObject()));
            while (stopped.get() == false) {
import org.opensearch.index.analysis.NamedAnalyzer;
 *
        assertThat(stage1.mappers().getMapper("age"), nullValue());
            {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")), mockInput);
    }
            barrier.await();
        }));
    }
        DocumentMapper updatedMapper = createDocumentMapper(fieldMapping(b -> b.field("type", "text")));
    private static class MockDocumentInput implements DocumentInput<Map<String, Object>> {
 * this work for additional information regarding copyright
        analyzers.put("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer()));
        DocumentInput<Map<String, Object>> mockInput = new MockDocumentInput();
            b.field("search_analyzer", "keyword");
    public void testParseWithoutDocumentInputReturnsNullDocumentInput() throws IOException {
                }
            b.endObject();
                }
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            );
                stopped.set(true);
import java.util.concurrent.atomic.AtomicBoolean;
        expected = Map.of("field", "value", "object", Map.of("field1", "value1", "field2", "new_value", "field3", "value3"));
                IllegalArgumentException.class,
        DocumentMapper stage2 = createDocumentMapper(mapping(b -> {
import static org.hamcrest.Matchers.sameInstance;
    public void testMergeObjectAndNested() throws Exception {
import static org.hamcrest.Matchers.notNullValue;
    public void testParseWithDocumentInputPropagatesInput() throws IOException {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
        return new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
                b.startObject("properties");
 * KIND, either express or implied.  See the License for the
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                b.startObject("object");
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")), null);
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
    }
            IllegalArgumentException.class,
        assertThat(initMapper.meta().get("foo"), equalTo("bar"));
    public void testMergeMetaForIndexTemplate() throws IOException {
        Map<String, Object> expected = Map.of("field", "value", "object", Map.of("field1", "value1", "field2", "value2"));
        final DocumentMapper documentMapper = mapperService.documentMapper();
            b.field("age", 25);
        assertThat(mergedMapper.meta(), equalTo(expected));
            }
 * the Apache License, Version 2.0 (the "License"); you may
        });
 * not use this file except in compliance with the License.
    public void testParseWithDocumentInputMultipleFields() throws IOException {
        expectThrows(
        @Override
                for (int i = 0; i < 200 && stopped.get() == false; i++) {
import org.opensearch.index.IndexSettings;
        assertThat(merged.mappers().getMapper("age"), notNullValue());
                }
                    // not in the mapping yet, try again
        MapperService mapperService = createMapperService(topMapping(b -> b.startObject("_source").field("enabled", false).endObject()));
            b.startObject("obj");
import java.io.IOException;
        assertThat(merged.root().dynamic(), equalTo(ObjectMapper.Dynamic.FALSE));
    }
        }), mockInput);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")));
import org.opensearch.index.engine.dataformat.DocumentInput;
                }
import org.opensearch.index.mapper.MapperService.MergeReason;
    }
        @Override
        DocumentMapper withDynamicMapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
                    ParsedDocument doc = documentMapper.parse(source(b -> b.field(fieldName, "test")));
            b.field("name", "test");
                b.startObject("properties");
        } finally {
        @Override
        assertFalse(mapperService.documentMapper().sourceMapper().enabled());
    }
            }
        assertThat(stage1.mappers().getMapper("obj1.prop1"), nullValue());
    public void testMergeSearchAnalyzer() throws Exception {
        @Override
import java.util.Map;
            b.startObject("obj");
    }
            stopped.set(true);
        public void setRowId(String rowIdFieldName, long rowId) {
    }
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
    public void testChangeSearchAnalyzerToDefault() throws Exception {
        }));
        merge(mapperService, fieldMapping(b -> {
                    continue;
        analyzers.put("whitespace", new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer()));
        }));
        assertThat(mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer().name(), equalTo("keyword"));
        DocumentMapper nestedMapper = createDocumentMapper(mapping(b -> b.startObject("obj").field("type", "nested").endObject()));
import static org.hamcrest.Matchers.containsString;
                    assert update != null;
                }
        assertThat(doc.rootDoc().getField("age"), notNullValue());
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
        assertThat(mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer().name(), equalTo("whitespace"));
    }
            } finally {
        try {
            {
        }
import java.util.Collections;
        public Map<String, Object> getFinalInput() {
    }
    }
                    continue;
/*
        DocumentMapper merged = stage1.merge(stage2.mapping(), reason);
            {
 * under the License.
 * ownership. Elasticsearch licenses this file to you under
        assertThat(withDynamicMapper.root().dynamic(), equalTo(ObjectMapper.Dynamic.FALSE));
    }
        }
        {
            );
                b.field("field", "value");
        assertThat(doc.getDocumentInput(), nullValue());
 *
        }
package org.opensearch.index.mapper;
        }
                () -> nestedMapper.merge(objectMapper.mapping(), reason)
            b.startObject("name").field("type", "text").endObject();
    public void testDoNotRepeatOriginalMapping() throws IOException {
        final CyclicBarrier barrier = new CyclicBarrier(2);
    public void testMergeMeta() throws IOException {
    public void testConcurrentMergeTest() throws Throwable {
                    lastIntroducedFieldName.set(fieldName);
            IllegalArgumentException e = expectThrows(
                assertNotNull(mapperService.indexAnalyzer().tokenStream(fieldName, "foo"));
import org.opensearch.common.compress.CompressedXContent;
        updatedMapper = createDocumentMapper(topMapping(b -> b.startObject("_meta").field("foo", "new_bar").endObject()));
        DocumentMapper mergedMapper = initMapper.merge(updatedMapper.mapping(), MergeReason.MAPPING_UPDATE);
            }
        assertThat(doc.getDocumentInput(), nullValue());
        assertThat(mergedMapper.meta(), equalTo(expected));
            fields.put(rowIdFieldName, rowId);
                if (fieldName == null) {
public class DocumentMapperTests extends MapperServiceTestCase {
        DocumentMapper merged = mapper.merge(withDynamicMapper.mapping(), MergeReason.MAPPING_UPDATE);
        MapperService mapperService = createMapperService(topMapping(b -> b.startObject("_source").field("enabled", false).endObject()));
        assertThat(doc.rootDoc().getField("name"), notNullValue());
            b.startObject("obj1");
            b.startObject("_meta");
        );
        assertTrue(mapper.sourceMapper().enabled());
            b.endObject();
                    b.field("field2", "new_value");
        DocumentMapper objectMapper = createDocumentMapper(mapping(b -> b.startObject("obj").field("type", "object").endObject()));
                {
        final Thread updater = new Thread(() -> {
                    b.startObject("prop1").field("type", "integer").endObject();
                if (parsedDoc.dynamicMappingsUpdate() != null) {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
    public void testMergeObjectDynamic() throws Exception {
    }
        assertThat(mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer().name(), equalTo("whitespace"));
        }));
                    Mapping update = doc.dynamicMappingsUpdate();
        @Override
/*
            b.startObject("age").field("type", "integer").endObject();
                error.set(e);
                    b.field("field1", "value1");
import org.opensearch.index.analysis.IndexAnalyzers;
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
            fields.put(fieldType != null ? fieldType.name() : "field_" + fields.size(), value);
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
            return Collections.unmodifiableMap(fields);
 * GitHub history for details.
            }
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
        ParsedDocument doc = mapper.parse(source(b -> {
            b.field("type", "text");
            b.field("search_analyzer", "whitespace");
        final AtomicReference<String> lastIntroducedFieldName = new AtomicReference<>();
                IllegalArgumentException.class,
        DocumentInput<Map<String, Object>> mockInput = new MockDocumentInput();
    public void testMergeMetadataFieldsForIndexTemplates() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
                barrier.await();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (error.get() != null) {
    public void testParseWithNullDocumentInputExplicitly() throws IOException {
            b.field("analyzer", "default");
            updater.join();
    }
                b.endObject();
        assertThat(merged.mappers().getMapper("obj1.prop1"), notNullValue());
 * You may obtain a copy of the License at
                    b.field("field3", "value3");
 * The OpenSearch Contributors require contributions made to
        }
 *
 * SPDX-License-Identifier: Apache-2.0
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
        }));
