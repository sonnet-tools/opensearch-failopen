 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.plugins.Plugin;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
    public void testUpdateIgnoreAbove() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "elk")));
            () -> merge(mapperService, fieldMapping(b -> b.field("type", FIELD_TYPE).field("language", "en")))
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    }
    }
/*
        fields = doc.rootDoc().getFields("field");
        assertEquals(IndexOptions.NONE, fields[0].fieldType().indexOptions());
        assertEquals(2, fields.length);
        for (String indexOptions : Arrays.asList("positions", "offsets")) {
package org.opensearch.index.mapper;
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);
        IllegalArgumentException e = expectThrows(
        assertEquals(expected, fields[0].binaryValue());
        doc = mapper.parse(source(b -> {}));
import java.io.IOException;
                () -> createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("index_options", indexOptions)))
        );
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);
        Collator collator = Collator.getInstance(new ULocale("tr"));
        doc = mapper.parse(source(b -> b.field("field", "opensearch")));
        assertEquals(DocValuesType.SORTED_SET, fields[0].fieldType().docValuesType());
    }
 * GitHub history for details.
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        fieldType = fields[1].fieldType();
    @Override
        fieldType = fields[3].fieldType();
import org.apache.lucene.index.IndexableField;
 */
import com.ibm.icu.util.ULocale;
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        RawCollationKey key = collator.getRawCollationKey("1234", null);
    protected ICUCollationKeywordFieldMapper.Builder newBuilder() {
        assertFalse(fieldType.stored());
 * You may obtain a copy of the License at
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
import com.ibm.icu.text.Collator;
        assertFalse(fieldType.tokenized());
            fieldMapping(b -> b.field("type", FIELD_TYPE).field("language", "tr").field("strength", "primary"))
        IndexableFieldType fieldType = fields[0].fieldType();
 * Unless required by applicable law or agreed to in writing,
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
        fieldType = fields[2].fieldType();
            Exception e = expectThrows(
        RawCollationKey key = collator.getRawCollationKey("1234", null);
    }
        collator.setStrength(Collator.PRIMARY);
import static org.hamcrest.Matchers.equalTo;
    protected Set<String> unsupportedProperties() {
        MapperService mapperService = createMapperService(
    protected void registerParameters(ParameterChecker checker) throws IOException {
        assertThat(fieldType.omitNorms(), equalTo(true));
        assertEquals(expected, fields[0].binaryValue());
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", "opensearch")));
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
import org.apache.lucene.index.IndexOptions;
        );
        checker.registerConflictCheck("case_first", b -> b.field("case_first", "lower"));
 * KIND, either express or implied.  See the License for the
    }
 * this work for additional information regarding copyright
        IndexableField[] fields = doc.rootDoc().getFields("field");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertEquals(expected, fields[0].binaryValue());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("norms", true)));
    protected Collection<? extends Plugin> getPlugins() {
        assertThat(fieldType.omitNorms(), equalTo(true));
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.apache.lucene.util.BytesRef;
        Collator collator = Collator.getInstance(ULocale.ROOT);
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
        assertEquals(1, fields.length);
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
        assertFalse(fieldType.stored());
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
        IndexableFieldType fieldType = fields[0].fieldType();
        assertEquals(4, fields.length);
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
import java.util.Collection;
    public void testEnableStore() throws IOException {
        assertThat(fieldType.storeTermVectors(), equalTo(false));
    }
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
/*
 * specific language governing permissions and limitations
    public void testIgnoreAbove() throws IOException {
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("null_value", "1234")));
        fieldType = fields[1].fieldType();
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
            );
        return new ICUCollationKeywordFieldMapper.Builder("icu");
        assertFalse(fieldType.tokenized());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("store", true)));
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
    @Override
import java.util.Arrays;
    }
 */
import static org.hamcrest.Matchers.containsString;
        assertEquals(2, fields.length);
        Collator collator = Collator.getInstance(ULocale.ROOT);
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        assertThat(fieldType.storeTermVectors(), equalTo(false));
        assertEquals(expected, fields[1].binaryValue());
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);
        assertEquals(expected, fields[3].binaryValue());
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(2, fields.length);
        Collator collator = Collator.getInstance(ULocale.ROOT);
        assertFalse(fieldType.stored());
    public void testNullValue() throws IOException {
public class ICUCollationKeywordFieldMapperTests extends FieldMapperTestCase2<ICUCollationKeywordFieldMapper.Builder> {
import org.apache.lucene.index.IndexableFieldType;
 * Modifications Copyright OpenSearch Contributors. See
        fields = doc.rootDoc().getFields("field");
import org.opensearch.core.xcontent.XContentBuilder;
import com.ibm.icu.text.RawCollationKey;
        DocumentMapper mapper = createDocumentMapper(
        checker.registerConflictCheck("variable_top", b -> b.field("variable_top", ":"));
        assertEquals(2, fields.length);
 * SPDX-License-Identifier: Apache-2.0
        expected = new BytesRef(key.bytes, 0, key.size);
        assertEquals(expected, fields[2].binaryValue());
        assertEquals(IndexOptions.DOCS_AND_FREQS, fields[0].fieldType().indexOptions());
        assertEquals(0, fields.length);
        IndexableFieldType fieldType = fields[0].fieldType();
 * compatible open source license.
        assertEquals(expected, fields[0].binaryValue());
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        assertEquals(1, fields.length);
        assertTrue(fields[0].fieldType().stored());
}
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("index_options", "freqs")));
        checker.registerConflictCheck("decomposition", b -> b.field("decomposition", "canonical"));
    }
    public void testMultipleValues() throws IOException {
            IllegalArgumentException.class,
        IndexableField[] fields = doc.rootDoc().getFields("field");
    public void testIndexOptions() throws IOException {
        );
        assertEquals(2, fields.length);
 * software distributed under the License is distributed on an
 *
        checker.registerConflictCheck("alternate", b -> b.field("alternate", "non-ignorable"));
 * The OpenSearch Contributors require contributions made to
        fieldType = fields[1].fieldType();
    }
import org.apache.lucene.index.DocValuesType;
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
    }
                MapperParsingException.class,
    }
        assertFalse(fields[0].fieldType().omitNorms());
    public void testDefaults() throws Exception {
        assertEquals(expected, fields[1].binaryValue());
    }
        IndexableField[] fields = doc.rootDoc().getFields("field");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("index", false)));
import java.util.Set;
        checker.registerConflictCheck("strength", b -> b.field("strength", "secondary"));
        assertFalse(fieldType.stored());
 * this file be licensed under the Apache-2.0 license or a
            assertThat(
        assertFalse(fieldType.tokenized());
            fieldMapping(b -> b.field("type", FIELD_TYPE).field("language", "tr").field("strength", "primary"))
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
    protected void minimalMapping(XContentBuilder b) throws IOException {
        RawCollationKey key = collator.getRawCollationKey("1234", null);
 * not use this file except in compliance with the License.
        }
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertEquals(0, fields.length);
        doc = mapper.parse(source(b -> b.nullField("field")));
        assertEquals(fieldMapping(this::minimalMapping).toString(), mapper.mappingSource().toString());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertThat(fieldType.storeTermVectors(), equalTo(false));
        checker.registerConflictCheck("numeric", b -> b.field("numeric", true));
    @Override
    @Override
 *
        key = collator.getRawCollationKey("5678", null);
        assertThat(fieldType.storeTermVectors(), equalTo(false));
    }
        assertThat(fieldType.omitNorms(), equalTo(true));
/*
        assertEquals(2, fields.length);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "I WİLL USE TURKİSH CASING")));
        b.field("type", FIELD_TYPE);
    }
    }
    public void testUpdateCollator() throws IOException {
    public void testCollator() throws IOException {
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
        assertEquals(0, fields.length);
    }
    public void testDisableIndex() throws IOException {
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
            );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        IndexableField[] fields = doc.rootDoc().getFields("field");
                containsString("The [" + FIELD_TYPE + "] field does not support positions, got [index_options]=" + indexOptions)
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
 * license agreements. See the NOTICE file distributed with
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        return Set.of("analyzer", "similarity");
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("doc_values", false)));
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
    public void testEnableNorms() throws IOException {
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertFalse(fieldType.tokenized());
        RawCollationKey key = collator.getRawCollationKey("ı will use turkish casıng", null); // should collate to same value
        return List.of(new AnalysisICUPlugin());
 * under the License.
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
        assertThat(fieldType.omitNorms(), equalTo(true));
import java.util.List;
        merge(mapperService, fieldMapping(b -> b.field("type", FIELD_TYPE).field("ignore_above", 5)));
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        checker.registerConflictCheck("hiragana_quaternary_mode", b -> b.field("hiragana_quaternary_mode", true));
    private static final String FIELD_TYPE = "icu_collation_keyword";
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        assertThat(e.getMessage(), containsString("mapper [field] has different [collator]"));
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", List.of("1234", "5678"))));
    }
    }
        IndexableField[] fields = doc.rootDoc().getFields("field");
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);
        assertEquals(2, fields.length);
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
        builder.value(1234);
 *
    public void testDisableDocValues() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
    @Override
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("ignore_above", 5)));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        IndexableField[] fields = doc.rootDoc().getFields("field");
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
        checker.registerConflictCheck("case_level", b -> b.field("case_level", true));
 * ownership. Elasticsearch licenses this file to you under
                e.getMessage(),
        assertEquals(expected, fields[1].binaryValue());
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        collator = Collator.getInstance(ULocale.ROOT);
