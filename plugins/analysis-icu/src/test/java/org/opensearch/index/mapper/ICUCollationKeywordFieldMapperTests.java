/*
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
        checker.registerConflictCheck("alternate", b -> b.field("alternate", "non-ignorable"));
        fieldType = fields[1].fieldType();
        RawCollationKey key = collator.getRawCollationKey("1234", null);  
    }  
        fieldType = fields[2].fieldType();  
    public void testEnableStore() throws IOException {
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        assertThat(fieldType.omitNorms(), equalTo(true));
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", "opensearch")));
        assertEquals(2, fields.length);
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);
        assertTrue(fields[0].fieldType().stored());
    }
        assertEquals(2, fields.length);  
        checker.registerConflictCheck("case_level", b -> b.field("case_level", true));  
    }
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
        IndexableField[] fields = doc.rootDoc().getFields("field");
    public void testUpdateIgnoreAbove() throws IOException {
        assertFalse(fieldType.stored());  
 */
import java.util.Set;
        assertEquals(IndexOptions.DOCS_AND_FREQS, fields[0].fieldType().indexOptions());
        );
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
        IndexableFieldType fieldType = fields[0].fieldType();  
import java.util.Arrays;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
    @Override  
 * You may obtain a copy of the License at  
        for (String indexOptions : Arrays.asList("positions", "offsets")) {  
        IndexableField[] fields = doc.rootDoc().getFields("field");
        IndexableField[] fields = doc.rootDoc().getFields("field");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            fieldMapping(b -> b.field("type", FIELD_TYPE).field("language", "tr").field("strength", "primary"))
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("index_options", "freqs")));  
        assertThat(e.getMessage(), containsString("mapper [field] has different [collator]"));  
import org.apache.lucene.index.IndexableFieldType;  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "elk")));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("store", true)));  
import org.opensearch.plugins.Plugin;
            IllegalArgumentException.class,  
    protected void minimalMapping(XContentBuilder b) throws IOException {
        doc = mapper.parse(source(b -> b.nullField("field")));
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        }  
import org.apache.lucene.util.BytesRef;
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));  
 * compatible open source license.
                MapperParsingException.class,
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("norms", true)));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(expected, fields[0].binaryValue());
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("null_value", "1234")));
    }
        collator = Collator.getInstance(ULocale.ROOT);
    public void testEnableNorms() throws IOException {  
        Collator collator = Collator.getInstance(ULocale.ROOT);
        doc = mapper.parse(source(b -> {}));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        builder.value(1234);
        assertFalse(fieldType.stored());
        assertThat(fieldType.omitNorms(), equalTo(true));
                e.getMessage(),  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(fieldType.storeTermVectors(), equalTo(false));  
}  
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());  
        checker.registerConflictCheck("strength", b -> b.field("strength", "secondary"));  
    }
    public void testIndexOptions() throws IOException {
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));  
        Collator collator = Collator.getInstance(ULocale.ROOT);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        checker.registerConflictCheck("variable_top", b -> b.field("variable_top", ":"));  
        assertEquals(0, fields.length);
 */
 * The OpenSearch Contributors require contributions made to  
    public void testDefaults() throws Exception {
    public void testCollator() throws IOException {
        DocumentMapper mapper = createDocumentMapper(  
        IllegalArgumentException e = expectThrows(
        assertFalse(fieldType.tokenized());  
        assertEquals(4, fields.length);
        );
        fields = doc.rootDoc().getFields("field");
    @Override
    @Override
        Collator collator = Collator.getInstance(ULocale.ROOT);
 * this work for additional information regarding copyright
        assertFalse(fieldType.tokenized());
        assertEquals(expected, fields[1].binaryValue());
package org.opensearch.index.mapper;
            assertThat(
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));  
    public void testIgnoreAbove() throws IOException {  
        fieldType = fields[1].fieldType();  
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
        assertFalse(fieldType.tokenized());
public class ICUCollationKeywordFieldMapperTests extends FieldMapperTestCase2<ICUCollationKeywordFieldMapper.Builder> {  
import java.util.List;  
        fieldType = fields[1].fieldType();  
        checker.registerConflictCheck("numeric", b -> b.field("numeric", true));
 * Unless required by applicable law or agreed to in writing,
        assertEquals(expected, fields[2].binaryValue());
        IndexableField[] fields = doc.rootDoc().getFields("field");  
 */  
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
    }
            () -> merge(mapperService, fieldMapping(b -> b.field("type", FIELD_TYPE).field("language", "en")))
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());  
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));  
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(2, fields.length);
        return new ICUCollationKeywordFieldMapper.Builder("icu");
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));  
    }
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
        return Set.of("analyzer", "similarity");
        assertThat(fieldType.storeTermVectors(), equalTo(false));
        return List.of(new AnalysisICUPlugin());  
        assertEquals(fieldMapping(this::minimalMapping).toString(), mapper.mappingSource().toString());
 * Modifications Copyright OpenSearch Contributors. See  
        assertEquals(0, fields.length);
import org.apache.lucene.index.IndexableField;
        assertEquals(expected, fields[1].binaryValue());  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", List.of("1234", "5678"))));  
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));  
    }
import static org.hamcrest.Matchers.containsString;  
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(expected, fields[0].binaryValue());
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);  
 *  
        MapperService mapperService = createMapperService(
    }  
        checker.registerConflictCheck("hiragana_quaternary_mode", b -> b.field("hiragana_quaternary_mode", true));
            Exception e = expectThrows(
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
 *
        Collator collator = Collator.getInstance(new ULocale("tr"));
 * ownership. Elasticsearch licenses this file to you under  
    public void testMultipleValues() throws IOException {  
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));  
        assertThat(fieldType.omitNorms(), equalTo(true));
        assertEquals(2, fields.length);  
        assertEquals(IndexOptions.NONE, fields[0].fieldType().indexOptions());  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        IndexableFieldType fieldType = fields[0].fieldType();
/*  
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
        assertThat(fieldType.omitNorms(), equalTo(true));
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
        assertEquals(2, fields.length);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("ignore_above", 5)));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
 * KIND, either express or implied.  See the License for the
    protected ICUCollationKeywordFieldMapper.Builder newBuilder() {
        assertFalse(fields[0].fieldType().omitNorms());
import org.apache.lucene.index.DocValuesType;  
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());  
        checker.registerConflictCheck("decomposition", b -> b.field("decomposition", "canonical"));
            fieldMapping(b -> b.field("type", FIELD_TYPE).field("language", "tr").field("strength", "primary"))
    }  
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));  
 * specific language governing permissions and limitations
    public void testDisableDocValues() throws IOException {
    protected Collection<? extends Plugin> getPlugins() {
        assertThat(fieldType.storeTermVectors(), equalTo(false));
    }  
        RawCollationKey key = collator.getRawCollationKey("1234", null);
        assertEquals(expected, fields[0].binaryValue());  
        fieldType = fields[3].fieldType();  
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());  
        doc = mapper.parse(source(b -> b.field("field", "opensearch")));  
        assertFalse(fieldType.stored());  
    @Override  
import org.apache.lucene.index.IndexOptions;
        assertEquals(0, fields.length);
        assertEquals(expected, fields[0].binaryValue());
    @Override
        key = collator.getRawCollationKey("5678", null);
        assertEquals(expected, fields[3].binaryValue());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("index", false)));
            );
        IndexableField[] fields = doc.rootDoc().getFields("field");  
    protected Set<String> unsupportedProperties() {  
        assertEquals(expected, fields[1].binaryValue());
 * software distributed under the License is distributed on an
    @Override
        IndexableFieldType fieldType = fields[0].fieldType();  
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;  
        assertEquals(DocValuesType.SORTED_SET, fields[0].fieldType().docValuesType());
        assertEquals(2, fields.length);
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());  
        RawCollationKey key = collator.getRawCollationKey("1234", null);
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
    protected void registerParameters(ParameterChecker checker) throws IOException {
        b.field("type", FIELD_TYPE);  
        IndexableField[] fields = doc.rootDoc().getFields("field");
import java.util.Collection;
import com.ibm.icu.text.Collator;  
        );  
        assertFalse(fieldType.tokenized());
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.NONE));
 * under the License.  
        assertFalse(fieldType.stored());  
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
    }
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
    }  
/*
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
    }
 *
                containsString("The [" + FIELD_TYPE + "] field does not support positions, got [index_options]=" + indexOptions)
        assertEquals(2, fields.length);
    public void testDisableIndex() throws IOException {
    }  
 * not use this file except in compliance with the License.
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("doc_values", false)));
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);  
    public void testUpdateCollator() throws IOException {  
        checker.registerConflictCheck("case_first", b -> b.field("case_first", "lower"));
        RawCollationKey key = collator.getRawCollationKey("ı will use turkish casıng", null); // should collate to same value  
        expected = new BytesRef(key.bytes, 0, key.size);  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "I WİLL USE TURKİSH CASING")));  
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            );
    public void testNullValue() throws IOException {
import java.io.IOException;  
    }
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        merge(mapperService, fieldMapping(b -> b.field("type", FIELD_TYPE).field("ignore_above", 5)));
                () -> createDocumentMapper(fieldMapping(b -> b.field("type", FIELD_TYPE).field("index_options", indexOptions)))  
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        fields = doc.rootDoc().getFields("field");  
import static org.hamcrest.Matchers.equalTo;
import com.ibm.icu.util.ULocale;
        assertEquals(1, fields.length);
        assertThat(fieldType.storeTermVectors(), equalTo(false));
        collator.setStrength(Collator.PRIMARY);
import com.ibm.icu.text.RawCollationKey;
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(1, fields.length);
    private static final String FIELD_TYPE = "icu_collation_keyword";
    }
