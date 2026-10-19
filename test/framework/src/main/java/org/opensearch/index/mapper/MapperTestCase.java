/*  
     * Use a {@linkplain ValueFetcher} to extract values from doc values.
         *
            assertHasNorms(fields, "field");  
        assertParseMaximalWarnings();
        Map<String, ConflictCheck> conflictChecks = new HashMap<>();
        assertEquals(
    protected boolean supportsOrIgnoresBoost() {
         * @param init   the initial mapping
     */
        }));
import org.opensearch.common.xcontent.json.JsonXContent;
         */
        withLuceneIndex(mapperService, iw -> {  
import org.opensearch.core.xcontent.XContentBuilder;
 * GitHub history for details.
        }
    public void testEmptyName() {
    protected void assertParseMinimalWarnings() {
            assertNoDocValuesField(fields, "field");
    private class UpdateCheck {
            XContentHelper.convertToMap(BytesReference.bytes(mapping), false, mapping.contentType()).v2(),  
        MapperService ms = createMapperService(fieldMapping(this::minimalMapping));  
         */
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup = (mft, lookupSource) -> mft  
            this.init = init;
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Query;
        private UpdateCheck(CheckedConsumer<XContentBuilder, IOException> update, Consumer<FieldMapper> check) throws IOException {
    }
        assertEquals(  
            this.check = check;
 * specific language governing permissions and limitations
     * mappings combinations and invoke {@link #assertExistsQuery(MapperService)} to verify the behaviour.  
        });
         * @param update the updated mapping  
            CheckedConsumer<XContentBuilder, IOException> update,  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentHelper;  
    }  
 */  
    public void testMinimalToMaximal() throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
            this.update = fieldMapping(update);
    }  
public abstract class MapperTestCase extends MapperServiceTestCase {
 * KIND, either express or implied.  See the License for the
        assertEquals(
        createMapperService(orig).documentMapper().mapping().toXContent(parsedFromOrig, INCLUDE_DEFAULTS);
    protected static void assertNoFieldNamesField(ParseContext.Document fields) {
        public void registerConflictCheck(String param, CheckedConsumer<XContentBuilder, IOException> update) throws IOException {
    }  
import org.opensearch.search.DocValueFormat;  
            throws IOException {
         *
    protected String typeName() throws IOException {
        createMapperService(orig).documentMapper().mapping().toXContent(parsedFromOrig, ToXContent.EMPTY_PARAMS);
import java.util.function.BiFunction;  
    }
    public void testUpdates() throws IOException {
        XContentBuilder parsedFromOrig = JsonXContent.contentBuilder().startObject();  
            assertEquals("field", fieldExistsQuery.getField());
        merge(mapperService, mapping);
                "No conflict when updating parameter [" + param + "]",
                throw new UnsupportedOperationException();
            this.init = fieldMapping(MapperTestCase.this::minimalMapping);
        if (fieldType.hasDocValues()) {
    }  
        assertExistsQuery(fieldType, query, fields);
            b.field("meta", Collections.singletonMap("baz", "quux"));
        createMapperService(fieldMapping(this::minimalMapping)).documentMapper().mapping().toXContent(orig, INCLUDE_DEFAULTS);
         * Register a check that a parameter update will cause a conflict
import org.apache.lucene.index.IndexableFieldType;
import java.util.List;
            if (indexableField.fieldType().docValuesType().equals(DocValuesType.NONE) == false) {
            XContentHelper.convertToMap(mapperService.documentMapper().mappingSource().uncompressed(), false, mapping.contentType()).v2()  
    /**
    protected static void assertHasNorms(ParseContext.Document doc, String field) {
            updateCheck.check.accept(mapper);
import org.opensearch.common.SetOnce;
            metaMapping(b);
         *
        /**
import org.apache.lucene.index.LeafReaderContext;
        }  
     */  
        assertParseMinimalWarnings();
         * Register a check that a parameter can be updated, using the minimal mapping as a base
import org.opensearch.index.query.QueryShardContext;
            "Parameter [boost] has no effect on type [" + type + "] and will be removed in future" };
import org.opensearch.common.CheckedConsumer;
    }  
 */  
            FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        for (IndexableField indexableField : fields) {
        }, iw -> {
                return;  
    }
        });  
         * @param update a field builder applied on top of the minimal mapping  
            merge(mapperService, updateCheck.update);
 *
        for (UpdateCheck updateCheck : checker.updateChecks) {
    }
    public final void testMinimalSerializesToItself() throws IOException {
            assertNoDocValuesField(fields, "field");
            } else {
    public void testDeprecatedBoost() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.instanceOf;  
        merge(mapperService, mapping);  
import java.util.Collections;
    }
            CheckedConsumer<XContentBuilder, IOException> init,
        fail("field [" + field + "] should be indexed but it isn't");
import static org.hamcrest.Matchers.containsString;
        }  
            assertEquals("field", normsFieldExistsQuery.getField());
            updateChecks.add(new UpdateCheck(update, check));
            TermQuery termQuery = (TermQuery) query;
         * @param param  the parameter name, expected to appear in the error message  
            Consumer<FieldMapper> check  
         */
        registerParameters(checker);
            updateChecks.add(new UpdateCheck(init, update, check));
        private ConflictCheck(XContentBuilder init, XContentBuilder update) {
    }
import java.util.function.Consumer;
            XContentHelper.convertToMap(mapperService.documentMapper().mappingSource().uncompressed(), false, mapping.contentType()).v2()
        mapping = fieldMapping(b -> {  
        }  
                update.accept(b);
    }
import org.apache.lucene.index.DocValuesType;
        final XContentBuilder update;
            this.check = check;
/**
        } else if (fieldType.getTextSearchInfo().hasNorms()) {
import java.util.Map;
    }
         * @param update a field builder applied on top of the minimal mapping  
        }  
            }  
                minimalMapping(b);
    private static class ConflictCheck {  
import org.apache.lucene.search.TermQuery;  
        IndexableField[] fields = doc.getFields(field);
        String[] warnings = new String[] {  
            mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");  
            IndexSearcher searcher = newSearcher(iw);
    protected void assertExistsQuery(MappedFieldType fieldType, Query query, ParseContext.Document fields) {
     * being created for a document with a value for the field. This can only be verified for the minimal mapping.
    /**  
            assertEquals("field", termQuery.getTerm().text());  
        parsedFromOrig.endObject();
            XContentHelper.convertToMap(mapperService.documentMapper().mappingSource().uncompressed(), false, mapping.contentType()).v2()
     * like in the case of runtime fields.
 * compatible open source license.
     * Writes the field and a sample value for it to the provided {@link XContentBuilder}.  
        }
    protected static void assertNoDocValuesField(ParseContext.Document doc, String field) {  
                anyOf(containsString("Cannot update parameter [" + param + "]"), containsString("different [" + param + "]"))
import java.io.IOException;  
            minimalMapping(b);
    public class ParameterChecker {
            valueFetcher.setNextReader(context);
        }
            merge(mapperService, checker.conflictChecks.get(param).init);
    protected static void assertDocValuesField(ParseContext.Document doc, String field) {
        XContentBuilder orig = JsonXContent.contentBuilder().startObject();  
        assertEquals(orig.toString(), parsedFromOrig.toString());  
            b.startObject("");  
        });
import org.apache.lucene.search.IndexSearcher;
        ParameterChecker checker = new ParameterChecker();  
         * @param check  a check that the updated parameter has been applied to the FieldMapper
     * Override to disable testing {@code meta} in fields that don't support it.
        }
            FieldExistsQuery normsFieldExistsQuery = (FieldExistsQuery) query;
        /**  
        builder.field("field");
 * license agreements. See the NOTICE file distributed with
        assertNull(fields.getField(FieldNamesFieldMapper.NAME));
        private UpdateCheck(
            assertEquals(DocValuesType.NONE, indexableField.fieldType().docValuesType());  
            MapperService mapperService = createMapperService(checker.conflictChecks.get(param).init);
            updateCheck.check.accept(mapper);  
        for (IndexableField indexableField : fields) {
        return result.get();
import org.opensearch.index.fielddata.IndexFieldDataCache;
        public void registerUpdateCheck(  
            // merging the same change is fine  
     * Writes a sample value for the field to the provided {@link XContentBuilder}.
        fail("doc_values not present for field [" + field + "]");  
    protected abstract void registerParameters(ParameterChecker checker) throws IOException;  
            b.field("boost", 2.0);  
         */  
 * software distributed under the License is distributed on an
            XContentHelper.convertToMap(BytesReference.bytes(mapping), false, mapping.contentType()).v2(),
        createMapperService(fieldMapping(b -> {
import org.opensearch.core.common.bytes.BytesReference;
            SearchLookup lookup = new SearchLookup(mapperService, fieldDataLookup, SearchLookup.UNKNOWN_SHARD_ID);  
    protected boolean supportsMeta() {  
        MappedFieldType fieldType = mapperService.fieldType("field");
        return true;
            "Parameter [boost] on field [field] is deprecated and will be removed in 3.0",
    /**  
     * This test verifies that the exists query created is the appropriate one, and aligns with the data structures  
            assertThat(query, instanceOf(TermQuery.class));
     */
            MapperService mapperService = createMapperService(updateCheck.init);  
        }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping(b -> {
    protected void writeField(XContentBuilder builder) throws IOException {
 * this work for additional information regarding copyright
            );
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        assertThat(e.getMessage(), containsString("name cannot be empty string"));
    }
        for (IndexableField indexableField : fields) {
    }
            });  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
        orig.endObject();
        }  
            conflictChecks.put(param, new ConflictCheck(fieldMapping(MapperTestCase.this::minimalMapping), fieldMapping(b -> {  
    protected void assertParseMaximalWarnings() {
        minimalMapping(b);
            b.endObject();
import org.opensearch.index.fielddata.IndexFieldData;  
            if (fieldType.isSearchable() || fieldType.isStored()) {
import static org.hamcrest.Matchers.anyOf;
    }
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));  
        /**  
    }  
            LeafReaderContext context = searcher.getIndexReader().leaves().get(0);  
    /**  
        // Most mappers don't emit any warnings  
            minimalMapping(b);
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
                IllegalArgumentException.class,
            assertEquals(FieldNamesFieldMapper.NAME, termQuery.getTerm().field());  
        assumeTrue("Field doesn't support meta", supportsMeta());  
        String type = typeName();
            merge(mapperService, updateCheck.update);
         * Register a check that a parameter update will cause a conflict, using the minimal mapping as a base  
        final Consumer<FieldMapper> check;
        }  
            }
        assumeTrue("Does not support [boost] parameter", supportsOrIgnoresBoost());  
            assertThat(query, instanceOf(FieldExistsQuery.class));  
 *  
        for (String param : checker.conflictChecks.keySet()) {
            Exception e = expectThrows(  
}
        );
            conflictChecks.put(param, new ConflictCheck(init, update));
        parsedFromOrig.endObject();
        return true;
        assertParseMinimalWarnings();
import java.util.ArrayList;
        IndexableField[] fields = doc.getFields(field);  
            assertDocValuesField(fields, "field");  
        ParseContext.Document fields = mapperService.documentMapper().parse(source(this::writeField)).rootDoc();  
        mapping = fieldMapping(this::metaMapping);
 */
            })));  
            b.field("meta", Collections.singletonMap("foo", "bar"));  
        throws IOException {
                assertFalse(indexableFieldType.omitNorms());
 * You may obtain a copy of the License at  
        assertParseMaximalWarnings();
            CheckedConsumer<XContentBuilder, IOException> init,
                e.getMessage(),  
import java.util.HashMap;  
        writeFieldValue(builder);  
            assertNoFieldNamesField(fields);
import java.util.function.Supplier;
package org.opensearch.index.mapper;
        } else {  
    protected abstract void writeFieldValue(XContentBuilder builder) throws IOException;  
            }  
                () -> merge(mapperService, checker.conflictChecks.get(param).update)  
import org.apache.lucene.index.IndexOptions;
        List<UpdateCheck> updateChecks = new ArrayList<>();  
            CheckedConsumer<XContentBuilder, IOException> update,
 *
        XContentBuilder orig = JsonXContent.contentBuilder().startObject();  
     */
        Query query = fieldType.existsQuery(queryShardContext);  
     * To be overridden in case the field should not be written at all in documents,
            iw.addDocument(mapperService.documentMapper().parse(source(b -> b.field(ft.name(), sourceValue))).rootDoc());
    }
     */
            })  
        })));  
        SetOnce<List<?>> result = new SetOnce<>();
            .build(new IndexFieldDataCache.None(), new NoneCircuitBreakerService());
    protected abstract void minimalMapping(XContentBuilder b) throws IOException;  
 * not use this file except in compliance with the License.
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            Consumer<FieldMapper> check
                minimalMapping(b);
         * @param update the updated mapping
        );
        assertParseMinimalWarnings();
        public void registerConflictCheck(String param, XContentBuilder init, XContentBuilder update) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertNotNull(fields.getField(FieldNamesFieldMapper.NAME));  
        final XContentBuilder update;
         * @param check  a check that the updated parameter has been applied to the FieldMapper
import org.apache.lucene.search.FieldExistsQuery;  
            this.update = fieldMapping(b -> {  
    }
        ) throws IOException {
            assertThat(
/*
    }  
        XContentBuilder parsedFromOrig = JsonXContent.contentBuilder().startObject();  
import org.opensearch.core.xcontent.ToXContent;
        createMapperService(fieldMapping(this::minimalMapping)).documentMapper().mapping().toXContent(orig, ToXContent.EMPTY_PARAMS);
            FieldExistsQuery fieldExistsQuery = (FieldExistsQuery) query;
    protected void assertExistsQuery(MapperService mapperService) throws IOException {
        public void registerUpdateCheck(CheckedConsumer<XContentBuilder, IOException> update, Consumer<FieldMapper> check)  
            // do it again to ensure that we don't get conflicts the second time
        final XContentBuilder init;
        XContentBuilder mapping = fieldMapping(b -> {
    protected final List<?> fetchFromDocValues(MapperService mapperService, MappedFieldType ft, DocValueFormat format, Object sourceValue)  
    public final void testExistsQueryMinimalMapping() throws IOException {
            // merging the conflicting update should throw an exception
                update.accept(b);
        return ms.fieldType("field").typeName();
                assertNoFieldNamesField(fields);
            // is not added to _field_names because it is not indexed nor stored
        // Most mappers don't emit any warnings
    // TODO make this final once we remove FieldMapperTestCase2
    protected void metaMapping(XContentBuilder b) throws IOException {
         *
            // we always perform a term query against _field_names, even when the field
            XContentHelper.convertToMap(BytesReference.bytes(mapping), false, mapping.contentType()).v2(),
 * Base class for testing {@link Mapper}s.  
            this.init = fieldMapping(init);  
         * @param init   the initial mapping
     * Field types that allow configurable doc_values or norms should write their own tests that creates the different
            this.update = update;  
        orig.endObject();
            if (indexableFieldType.indexOptions() != IndexOptions.NONE) {  
            .fielddataBuilder("test", () -> {
        final XContentBuilder init;  
 */
        /**
            );
        }
            IndexableFieldType indexableFieldType = indexableField.fieldType();
         * @param param  the parameter name, expected to appear in the error message
    }
 * under the License.  
        }
            ValueFetcher valueFetcher = new DocValueFetcher(format, lookup.doc().getForField(ft));
            assertNoFieldNamesField(fields);
import org.apache.lucene.index.IndexableField;  
                return;
/*  
            assertThat(query, instanceOf(FieldExistsQuery.class));  
        );  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.lookup.SearchLookup;
        MapperService mapperService = createMapperService(mapping);
    }  
        allowedWarnings(warnings);  
 * ownership. Elasticsearch licenses this file to you under  
            result.set(valueFetcher.fetchValues(lookup.source()));  
        IndexableField[] fields = doc.getFields(field);  
        ) throws IOException {
        assertEquals(orig.toString(), parsedFromOrig.toString());  
            metaMapping(b);
        assertExistsQuery(mapperService);
            lookup.source().setSegmentAndDocument(context, 0);
    public void testMeta() throws IOException {
         * Register a check that a parameter can be updated  
 * Unless required by applicable law or agreed to in writing,
