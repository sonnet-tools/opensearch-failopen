                assertNotNull(mapperService.indexAnalyzer().tokenStream(fieldName, "foo"));
                    // not in the mapping yet, try again
        analyzers.put("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer()));
        assertThat(mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer().name(), equalTo("default"));  
        assertThat(mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer().name(), equalTo("whitespace"));
import org.opensearch.index.analysis.IndexAnalyzers;
        {  
    public void testParseWithNullDocumentInputExplicitly() throws IOException {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        DocumentMapper initMapper = createDocumentMapper(topMapping(b -> b.startObject("_meta").field("foo", "bar").endObject()));
        }
            b.startObject("age").field("type", "integer").endObject();  
        }));
 * You may obtain a copy of the License at  
        assertThat(doc.rootDoc().getField("name"), notNullValue());
        ParsedDocument doc = mapper.parse(source(b -> {
            b.field("search_analyzer", "whitespace");
        @Override  
                if (fieldName == null) {  
        DocumentInput<Map<String, Object>> mockInput = new MockDocumentInput();
    }  
            }  
    }  
        merge(mapperService, MergeReason.INDEX_TEMPLATE, topMapping(b -> b.startObject("_source").field("enabled", true).endObject()));
                error.set(e);
        analyzers.put("whitespace", new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer()));  
        analyzers.put("keyword", new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer()));
 * software distributed under the License is distributed on an
                barrier.await();
        @Override
    @Override
            assertThat(e.getMessage(), containsString("cannot change object mapping from nested to non-nested"));  
            fields.put(fieldType != null ? fieldType.name() : "field_" + fields.size(), value);
        }), mockInput);
        try {
            b.field("search_analyzer", "keyword");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {  
package org.opensearch.index.mapper;
        assertThat(stage1.mappers().getMapper("obj1.prop1"), nullValue());
    public void testMergeObjectDynamic() throws Exception {
            b.field("type", "text");  
 * KIND, either express or implied.  See the License for the
        final CyclicBarrier barrier = new CyclicBarrier(2);
        DocumentMapper updatedMapper = createDocumentMapper(fieldMapping(b -> b.field("type", "text")));  
            b.endObject();  
        }));
 *
        );
            b.startObject("_meta");
        }));
 */
            b.startObject("_meta");
import static org.hamcrest.Matchers.sameInstance;  
            b.field("type", "text");
import org.opensearch.index.IndexSettings;
    public void testParseWithDocumentInputMultipleFields() throws IOException {  
        private final Map<String, Object> fields = new HashMap<>();
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
        assertThat(merged.root().dynamic(), equalTo(ObjectMapper.Dynamic.FALSE));
import static org.hamcrest.Matchers.notNullValue;
 * Licensed to Elasticsearch under one or more contributor  
                    b.startObject("prop1").field("type", "integer").endObject();
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
        assertThat(mergedMapper.meta().get("foo"), equalTo("bar"));  
                    ParsedDocument doc = documentMapper.parse(source(b -> b.field(fieldName, "test")));
            b.field("field", "value");  
            b.startObject("name").field("type", "text").endObject();
        }
                    lastIntroducedFieldName.set(fieldName);
 * compatible open source license.
    private static class MockDocumentInput implements DocumentInput<Map<String, Object>> {
    public void testMergeMetaForIndexTemplate() throws IOException {
            {
import static org.hamcrest.Matchers.equalTo;  
            b.endObject();  
import org.apache.lucene.analysis.core.KeywordAnalyzer;
        }
        assertThat(stage1.mappers().getMapper("age"), nullValue());
            fields.put(rowIdFieldName, rowId);
        final AtomicReference<String> lastIntroducedFieldName = new AtomicReference<>();  
        DocumentMapper objectMapper = createDocumentMapper(mapping(b -> b.startObject("obj").field("type", "object").endObject()));
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
                ParsedDocument parsedDoc = mapperService.documentMapper().parse(source(b -> b.field(fieldName, "test")));  
/*  
                IllegalArgumentException.class,
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
            return fields.containsKey(fieldName) ? 1 : 0;  
 * GitHub history for details.
                }  
    }
    }
                b.endObject();
                b.endObject();
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
        } finally {
        public long getFieldCount(String fieldName) {
                    b.field("field3", "value3");
            }
        updater.start();
        }));
            b.endObject();  
    public void testParseWithoutDocumentInputReturnsNullDocumentInput() throws IOException {
    public void testMergeObjectAndNested() throws Exception {
                    continue;
import static org.hamcrest.Matchers.containsString;
        }));
                    b.field("field1", "value1");
        }  
            throw error.get();  
 * license agreements. See the NOTICE file distributed with
        // stage1 mapping should not have been modified  
            );
        }  
        merge(mapperService, fieldMapping(b -> {
    }
            }
            stopped.set(true);
        assertThat(doc.rootDoc().getField("age"), notNullValue());
                }
        DocumentMapper stage2 = createDocumentMapper(mapping(b -> {
        DocumentInput<Map<String, Object>> mockInput = new MockDocumentInput();  
        DocumentMapper initMapper = createDocumentMapper(topMapping(b -> {
                {  
        DocumentMapper mergedMapper = initMapper.merge(updatedMapper.mapping(), MergeReason.MAPPING_UPDATE);
                b.startObject("properties");  
            return Collections.unmodifiableMap(fields);  
import java.util.concurrent.CyclicBarrier;
        return new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
import org.opensearch.index.analysis.AnalyzerScope;  
    }
            {  
        DocumentMapper withDynamicMapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));  
    }
        updatedMapper = createDocumentMapper(topMapping(b -> b.startObject("_meta").field("foo", "new_bar").endObject()));
 *  
        }));  
 * the Apache License, Version 2.0 (the "License"); you may
                {  
        @Override
        assertThat(mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer().name(), equalTo("whitespace"));
            b.field("analyzer", "default");
        assertNull(mapper.root().dynamic());
                () -> objectMapper.merge(nestedMapper.mapping(), reason)  
            {  
        MapperService mapperService = createMapperService(fieldMapping(b -> {
                b.startObject("properties");  
 * not use this file except in compliance with the License.
        updatedMapper = createDocumentMapper(topMapping(b -> {
        expectThrows(
            {
                b.field("field", "value");
        expected = Map.of("field", "value", "object", Map.of("field1", "value1", "field2", "new_value", "field3", "value3"));
    }  
    }
        final DocumentMapper documentMapper = mapperService.documentMapper();  
        MapperService mapperService = createMapperService(topMapping(b -> b.startObject("_source").field("enabled", false).endObject()));
            } catch (Exception e) {
        }));
        if (error.get() != null) {
        public void setRowId(String rowIdFieldName, long rowId) {  
 * specific language governing permissions and limitations
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
                }  
            IllegalArgumentException.class,  
import java.util.HashMap;
 * ownership. Elasticsearch licenses this file to you under  
                {
            b.endObject();  
    }
    }
                b.endObject();
        public void close() {}
        assertThat(mergedMapper.meta().get("foo"), equalTo("new_bar"));
import org.opensearch.index.mapper.MapperService.MergeReason;
        assertThat(initMapper.meta(), equalTo(expected));
        public Map<String, Object> getFinalInput() {
            }
                }  
                b.startObject("object");
        }
        assertThat(merged.mappers().getMapper("age"), notNullValue());
        final Thread updater = new Thread(() -> {
 * this work for additional information regarding copyright
        Map<String, Object> expected = Map.of("field", "value", "object", Map.of("field1", "value1", "field2", "value2"));  
        DocumentMapper mapper = mapperService.documentMapper();
            b.field("age", 25);  
            b.startObject("name").field("type", "text").endObject();
            b.endObject();
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));  
            b.field("analyzer", "default");  
        merge(mapperService, fieldMapping(b -> b.field("type", "text")));
        // but merged should  
        }));
    public void testDoNotRepeatOriginalMapping() throws IOException {
        merge(mapperService, fieldMapping(b -> {
import org.opensearch.index.analysis.NamedAnalyzer;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")), mockInput);
        assertThat(mergedMapper.meta(), equalTo(expected));
import static org.hamcrest.Matchers.nullValue;
                    assert update != null;  
        assertThat(mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer().name(), equalTo("keyword"));  
                    b.field("field2", "new_value");
    public void testConcurrentMergeTest() throws Throwable {  
    }  
    }
 * Modifications Copyright OpenSearch Contributors. See
            IllegalArgumentException e = expectThrows(
    public void testParseWithDocumentInputPropagatesInput() throws IOException {
import java.io.IOException;  
import java.util.Map;  
        DocumentMapper nestedMapper = createDocumentMapper(mapping(b -> b.startObject("obj").field("type", "nested").endObject()));  
            b.startObject("obj1");
import org.opensearch.index.engine.dataformat.DocumentInput;  
        mergedMapper = mergedMapper.merge(updatedMapper.mapping(), MergeReason.INDEX_TEMPLATE);
                }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));  
                for (int i = 0; i < 200 && stopped.get() == false; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    final String fieldName = Integer.toString(i);  
            }
    public void testChangeSearchAnalyzerToDefault() throws Exception {  
        assertTrue(mapper.sourceMapper().enabled());  
import org.opensearch.common.compress.CompressedXContent;
        DocumentMapper mergedMapper = initMapper.merge(updatedMapper.mapping(), MergeReason.INDEX_TEMPLATE);
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(initMapper.meta().get("foo"), equalTo("bar"));
        }));  
        DocumentMapper merged = mapper.merge(withDynamicMapper.mapping(), MergeReason.MAPPING_UPDATE);  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")), null);
        assertFalse(mapperService.documentMapper().sourceMapper().enabled());
            }
            barrier.await();  
                    mapperService.merge("_doc", new CompressedXContent(update.toString()), MergeReason.MAPPING_UPDATE);
            );
        assertNotNull(mapperService.documentMapper().mappers().getMapper("field"));  
        final AtomicReference<Exception> error = new AtomicReference<>();
import java.util.concurrent.atomic.AtomicReference;  
    public void testParseWithDocumentInputNestedObject() throws IOException {
 */  
        @Override
            b.field("analyzer", "default");  
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);  
                    b.startObject("field").field("type", "text").endObject();
        public void addField(MappedFieldType fieldType, Object value) {
            b.startObject("age").field("type", "integer").endObject();  
                b.field("field", "value");
        }), mockInput);
    public void testMergeSearchAnalyzer() throws Exception {
                if (parsedDoc.dynamicMappingsUpdate() != null) {
 */  
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
 * this file be licensed under the Apache-2.0 license or a
    }
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();  
        assertThat(withDynamicMapper.root().dynamic(), equalTo(ObjectMapper.Dynamic.FALSE));
/*
        ParsedDocument doc = mapper.parse(source(b -> {
        {
            () -> documentMapper.mappers().indexAnalyzer().tokenStream("non_existing_field", "foo")
                () -> nestedMapper.merge(objectMapper.mapping(), reason)
                }  
        @Override  
    }
        final MapperService mapperService = createMapperService(mapping(b -> {}));
        assertThat(merged.mappers().getMapper("obj1.prop1"), notNullValue());
        DocumentInput<Map<String, Object>> mockInput = new MockDocumentInput();
        DocumentMapper merged = stage1.merge(stage2.mapping(), reason);
    }
        assertThat(doc.getDocumentInput(), nullValue());  
            b.field("name", "test");
    }
import java.util.concurrent.atomic.AtomicBoolean;
public class DocumentMapperTests extends MapperServiceTestCase {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")));
                    b.field("field2", "value2");
            while (stopped.get() == false) {
                    continue;  
}  
            updater.join();  
            b.startObject("obj");
            IllegalArgumentException e = expectThrows(
            } finally {  
    public void testMergeMetadataFieldsForIndexTemplates() throws IOException {
 * The OpenSearch Contributors require contributions made to  
                b.endObject();
 *
        });  
            b.startObject("obj");
                    Mapping update = doc.dynamicMappingsUpdate();
    public void testAddFields() throws Exception {
import java.util.Collections;
            b.field("type", "text");  
 * SPDX-License-Identifier: Apache-2.0
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
        DocumentMapper updatedMapper = createDocumentMapper(fieldMapping(b -> b.field("type", "text")));  
                final String fieldName = lastIntroducedFieldName.get();
        final AtomicBoolean stopped = new AtomicBoolean(false);
                b.startObject("object");
    public void testMergeMeta() throws IOException {  
        assertThat(doc.getDocumentInput(), nullValue());
                {
        mergedMapper = initMapper.merge(updatedMapper.mapping(), MergeReason.MAPPING_UPDATE);
        MapperService mapperService = createMapperService(topMapping(b -> b.startObject("_source").field("enabled", false).endObject()));
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
        assertThat(mergedMapper.meta(), equalTo(expected));
                }  
            try {  
/*  
        DocumentMapper stage1 = createDocumentMapper(mapping(b -> b.startObject("name").field("type", "text").endObject()));
            b.field("analyzer", "default");
            b.field("search_analyzer", "whitespace");
                stopped.set(true);
        }
        }
            assertThat(e.getMessage(), containsString("cannot change object mapping from non-nested to nested"));
                IllegalArgumentException.class,  
            b.field("type", "text");
