         * Register a check that a parameter can be updated, using the minimal mapping as a base
import java.util.ArrayList;
 */
            Consumer<FieldMapper> check
 *
        ParseContext.Document fields = mapperService.documentMapper().parse(source(this::writeField)).rootDoc();
        assertEquals(
 * You may obtain a copy of the License at
    protected void metaMapping(XContentBuilder b) throws IOException {
 * under the License.
        for (IndexableField indexableField : fields) {
            TermQuery termQuery = (TermQuery) query;
            XContentHelper.convertToMap(mapperService.documentMapper().mappingSource().uncompressed(), false, mapping.contentType()).v2()
    /**
            CheckedConsumer<XContentBuilder, IOException> init,
        }
            IndexableFieldType indexableFieldType = indexableField.fieldType();
         * @param check  a check that the updated parameter has been applied to the FieldMapper
        });
import org.opensearch.common.SetOnce;
import java.io.IOException;
 * this work for additional information regarding copyright
        assertEquals(orig.toString(), parsedFromOrig.toString());
            assertEquals("field", termQuery.getTerm().text());
        final XContentBuilder update;
        });
import static org.hamcrest.Matchers.containsString;
         * @param param  the parameter name, expected to appear in the error message
 * KIND, either express or implied.  See the License for the
            FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        assertParseMinimalWarnings();
    }
    protected void assertExistsQuery(MapperService mapperService) throws IOException {
import org.apache.lucene.search.IndexSearcher;
    }
public abstract class MapperTestCase extends MapperServiceTestCase {
         * Register a check that a parameter can be updated
    }
        MapperService ms = createMapperService(fieldMapping(this::minimalMapping));
        for (IndexableField indexableField : fields) {
     */
        })));
            b.field("meta", Collections.singletonMap("baz", "quux"));
        for (String param : checker.conflictChecks.keySet()) {
        assertThat(e.getMessage(), containsString("name cannot be empty string"));
                minimalMapping(b);
 * Unless required by applicable law or agreed to in writing,
            // merging the conflicting update should throw an exception
         */
        private ConflictCheck(XContentBuilder init, XContentBuilder update) {
         *
        fail("field [" + field + "] should be indexed but it isn't");
            assertThat(query, instanceOf(TermQuery.class));
     */
     * Override to disable testing {@code meta} in fields that don't support it.
import org.opensearch.core.xcontent.ToXContent;
         * @param param  the parameter name, expected to appear in the error message
     * To be overridden in case the field should not be written at all in documents,
    }
 *
import org.opensearch.core.xcontent.XContentBuilder;
        ) throws IOException {
            this.check = check;
        assertExistsQuery(mapperService);
import java.util.List;
            MapperService mapperService = createMapperService(updateCheck.init);
                update.accept(b);
                throw new UnsupportedOperationException();
    protected void assertParseMaximalWarnings() {
            MapperService mapperService = createMapperService(checker.conflictChecks.get(param).init);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.lookup.SearchLookup;
        final XContentBuilder update;
            CheckedConsumer<XContentBuilder, IOException> update,
        return ms.fieldType("field").typeName();
import org.opensearch.core.common.bytes.BytesReference;
        }
        IndexableField[] fields = doc.getFields(field);
            conflictChecks.put(param, new ConflictCheck(fieldMapping(MapperTestCase.this::minimalMapping), fieldMapping(b -> {
import org.apache.lucene.search.Query;
        return true;
import org.apache.lucene.index.LeafReaderContext;
     */
package org.opensearch.index.mapper;
         */
         * @param update the updated mapping
            this.update = fieldMapping(update);
            b.field("meta", Collections.singletonMap("foo", "bar"));
            .fielddataBuilder("test", () -> {
            updateChecks.add(new UpdateCheck(init, update, check));
            if (indexableFieldType.indexOptions() != IndexOptions.NONE) {
    }
     */
        final XContentBuilder init;
    }
        private UpdateCheck(
    }
        orig.endObject();
        XContentBuilder orig = JsonXContent.contentBuilder().startObject();
 * Licensed to Elasticsearch under one or more contributor
        IndexableField[] fields = doc.getFields(field);
        createMapperService(fieldMapping(this::minimalMapping)).documentMapper().mapping().toXContent(orig, ToXContent.EMPTY_PARAMS);
         * @param init   the initial mapping
            XContentHelper.convertToMap(BytesReference.bytes(mapping), false, mapping.contentType()).v2(),
        final Consumer<FieldMapper> check;
        assertExistsQuery(fieldType, query, fields);
import org.opensearch.index.fielddata.IndexFieldDataCache;
    protected static void assertHasNorms(ParseContext.Document doc, String field) {
        assertParseMinimalWarnings();
        }));
            b.field("boost", 2.0);
    }
            assertThat(
    }
    }
    /**
        String type = typeName();
        return true;
    }
    protected static void assertDocValuesField(ParseContext.Document doc, String field) {
            metaMapping(b);
        assertNull(fields.getField(FieldNamesFieldMapper.NAME));
            FieldExistsQuery fieldExistsQuery = (FieldExistsQuery) query;
    protected abstract void writeFieldValue(XContentBuilder builder) throws IOException;
            merge(mapperService, updateCheck.update);
         * @param init   the initial mapping
        }
    }
        List<UpdateCheck> updateChecks = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
        Query query = fieldType.existsQuery(queryShardContext);
            assertDocValuesField(fields, "field");
        SetOnce<List<?>> result = new SetOnce<>();
        if (fieldType.hasDocValues()) {
        registerParameters(checker);
        assertParseMaximalWarnings();
                () -> merge(mapperService, checker.conflictChecks.get(param).update)
    }
    public class ParameterChecker {
         * Register a check that a parameter update will cause a conflict, using the minimal mapping as a base
 * compatible open source license.
import org.opensearch.common.xcontent.json.JsonXContent;
        assumeTrue("Field doesn't support meta", supportsMeta());
 * Base class for testing {@link Mapper}s.
        /**
        }
                return;
            }
            ValueFetcher valueFetcher = new DocValueFetcher(format, lookup.doc().getForField(ft));
import org.apache.lucene.index.IndexableField;
        Map<String, ConflictCheck> conflictChecks = new HashMap<>();
        }, iw -> {
import org.apache.lucene.search.TermQuery;
        }
     * Writes the field and a sample value for it to the provided {@link XContentBuilder}.
            assertEquals("field", normsFieldExistsQuery.getField());
    protected abstract void minimalMapping(XContentBuilder b) throws IOException;
        String[] warnings = new String[] {
     * mappings combinations and invoke {@link #assertExistsQuery(MapperService)} to verify the behaviour.
            }
        }
    /**
        mapping = fieldMapping(this::metaMapping);
        // Most mappers don't emit any warnings
            b.endObject();
         *
import org.apache.lucene.index.DocValuesType;
        } else {
            result.set(valueFetcher.fetchValues(lookup.source()));
    public void testMeta() throws IOException {
     * Writes a sample value for the field to the provided {@link XContentBuilder}.
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
     * Use a {@linkplain ValueFetcher} to extract values from doc values.
            .build(new IndexFieldDataCache.None(), new NoneCircuitBreakerService());
        }
            SearchLookup lookup = new SearchLookup(mapperService, fieldDataLookup, SearchLookup.UNKNOWN_SHARD_ID);
        ParameterChecker checker = new ParameterChecker();
        });
/*
        return result.get();
         */
    private class UpdateCheck {
            CheckedConsumer<XContentBuilder, IOException> update,
            XContentHelper.convertToMap(mapperService.documentMapper().mappingSource().uncompressed(), false, mapping.contentType()).v2()
import java.util.function.BiFunction;
        /**
        XContentBuilder orig = JsonXContent.contentBuilder().startObject();
    }
        ) throws IOException {
    /**
 * GitHub history for details.
                IllegalArgumentException.class,
                e.getMessage(),
                assertFalse(indexableFieldType.omitNorms());
        allowedWarnings(warnings);
     * Field types that allow configurable doc_values or norms should write their own tests that creates the different
            assertEquals(DocValuesType.NONE, indexableField.fieldType().docValuesType());
            assertThat(query, instanceOf(FieldExistsQuery.class));
            Consumer<FieldMapper> check
        createMapperService(orig).documentMapper().mapping().toXContent(parsedFromOrig, ToXContent.EMPTY_PARAMS);
            // we always perform a term query against _field_names, even when the field
        parsedFromOrig.endObject();
         *
import java.util.function.Consumer;
    }
        }
            XContentHelper.convertToMap(mapperService.documentMapper().mappingSource().uncompressed(), false, mapping.contentType()).v2()
        );
        assertParseMinimalWarnings();
    public void testUpdates() throws IOException {
import org.opensearch.common.xcontent.XContentHelper;
            assertThat(query, instanceOf(FieldExistsQuery.class));
 *     http://www.apache.org/licenses/LICENSE-2.0
            iw.addDocument(mapperService.documentMapper().parse(source(b -> b.field(ft.name(), sourceValue))).rootDoc());
     * being created for a document with a value for the field. This can only be verified for the minimal mapping.
    public void testMinimalToMaximal() throws IOException {
            updateCheck.check.accept(mapper);
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
    protected static void assertNoFieldNamesField(ParseContext.Document fields) {
    }
 * not use this file except in compliance with the License.
            } else {
    public void testEmptyName() {
 * software distributed under the License is distributed on an
    public final void testMinimalSerializesToItself() throws IOException {
        orig.endObject();
        private UpdateCheck(CheckedConsumer<XContentBuilder, IOException> update, Consumer<FieldMapper> check) throws IOException {
    }
        }
        assertEquals(orig.toString(), parsedFromOrig.toString());
    }
            conflictChecks.put(param, new ConflictCheck(init, update));
            metaMapping(b);
            valueFetcher.setNextReader(context);
         * @param check  a check that the updated parameter has been applied to the FieldMapper
            this.check = check;
 * specific language governing permissions and limitations
            );
         * @param update the updated mapping
 */
import org.apache.lucene.search.FieldExistsQuery;
            // is not added to _field_names because it is not indexed nor stored
        parsedFromOrig.endObject();
            b.startObject("");
 * license agreements. See the NOTICE file distributed with
            // merging the same change is fine
    protected void assertParseMinimalWarnings() {
import java.util.function.Supplier;
    protected abstract void registerParameters(ParameterChecker checker) throws IOException;
            assertEquals("field", fieldExistsQuery.getField());
        merge(mapperService, mapping);
        public void registerUpdateCheck(
/**
    }
import static org.hamcrest.Matchers.anyOf;
        final XContentBuilder init;
                assertNotNull(fields.getField(FieldNamesFieldMapper.NAME));
        /**
    // TODO make this final once we remove FieldMapperTestCase2
import java.util.HashMap;
import org.opensearch.search.DocValueFormat;
        /**
        }
            assertHasNorms(fields, "field");
    protected String typeName() throws IOException {
            XContentHelper.convertToMap(BytesReference.bytes(mapping), false, mapping.contentType()).v2(),
    }
            // do it again to ensure that we don't get conflicts the second time
            }
    protected void writeField(XContentBuilder builder) throws IOException {
            LeafReaderContext context = searcher.getIndexReader().leaves().get(0);
    protected static void assertNoDocValuesField(ParseContext.Document doc, String field) {
import java.util.Collections;
            updateCheck.check.accept(mapper);
        withLuceneIndex(mapperService, iw -> {
        createMapperService(fieldMapping(b -> {
         */
        assertEquals(
        XContentBuilder parsedFromOrig = JsonXContent.contentBuilder().startObject();
         * Register a check that a parameter update will cause a conflict
        for (UpdateCheck updateCheck : checker.updateChecks) {
import static org.hamcrest.Matchers.instanceOf;
    public void testDeprecatedBoost() throws IOException {
        }
        public void registerUpdateCheck(CheckedConsumer<XContentBuilder, IOException> update, Consumer<FieldMapper> check)
            lookup.source().setSegmentAndDocument(context, 0);
        mapping = fieldMapping(b -> {
        XContentBuilder parsedFromOrig = JsonXContent.contentBuilder().startObject();
    }
     * This test verifies that the exists query created is the appropriate one, and aligns with the data structures
import org.opensearch.common.CheckedConsumer;
/*
            assertEquals(FieldNamesFieldMapper.NAME, termQuery.getTerm().field());
                return;
            minimalMapping(b);
 * this file be licensed under the Apache-2.0 license or a
            IndexSearcher searcher = newSearcher(iw);
        minimalMapping(b);
        // Most mappers don't emit any warnings
                "No conflict when updating parameter [" + param + "]",
            throws IOException {
        }
            this.init = fieldMapping(MapperTestCase.this::minimalMapping);
    protected final List<?> fetchFromDocValues(MapperService mapperService, MappedFieldType ft, DocValueFormat format, Object sourceValue)
                minimalMapping(b);
    }
}
            })));
            assertNoDocValuesField(fields, "field");
 * ownership. Elasticsearch licenses this file to you under
            })
        IndexableField[] fields = doc.getFields(field);
            });
    }
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        assertEquals(
        writeFieldValue(builder);
            assertNoDocValuesField(fields, "field");
            minimalMapping(b);
            if (indexableField.fieldType().docValuesType().equals(DocValuesType.NONE) == false) {
        for (IndexableField indexableField : fields) {
 * The OpenSearch Contributors require contributions made to
import java.util.Map;
import org.opensearch.index.fielddata.IndexFieldData;
        XContentBuilder mapping = fieldMapping(b -> {
            this.init = init;
 * the Apache License, Version 2.0 (the "License"); you may
            updateChecks.add(new UpdateCheck(update, check));
    protected void assertExistsQuery(MappedFieldType fieldType, Query query, ParseContext.Document fields) {
        throws IOException {
    public final void testExistsQueryMinimalMapping() throws IOException {
        assertParseMaximalWarnings();
        public void registerConflictCheck(String param, CheckedConsumer<XContentBuilder, IOException> update) throws IOException {
        );
            XContentHelper.convertToMap(BytesReference.bytes(mapping), false, mapping.contentType()).v2(),
         * @param update a field builder applied on top of the minimal mapping
import org.apache.lucene.index.IndexOptions;
 */
            if (fieldType.isSearchable() || fieldType.isStored()) {
            this.init = fieldMapping(init);
            mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
/*
            assertNoFieldNamesField(fields);
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping(b -> {
            Exception e = expectThrows(
    private static class ConflictCheck {
        MapperService mapperService = createMapperService(mapping);
import org.opensearch.index.query.QueryShardContext;
            this.update = update;
        }
     */
        );
            CheckedConsumer<XContentBuilder, IOException> init,
 * Modifications Copyright OpenSearch Contributors. See
         *
        createMapperService(fieldMapping(this::minimalMapping)).documentMapper().mapping().toXContent(orig, INCLUDE_DEFAULTS);
        fail("doc_values not present for field [" + field + "]");
        builder.field("field");
        merge(mapperService, mapping);
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup = (mft, lookupSource) -> mft
            "Parameter [boost] has no effect on type [" + type + "] and will be removed in future" };
    }
            FieldExistsQuery normsFieldExistsQuery = (FieldExistsQuery) query;
            merge(mapperService, checker.conflictChecks.get(param).init);
                assertNoFieldNamesField(fields);
        assumeTrue("Does not support [boost] parameter", supportsOrIgnoresBoost());
            this.update = fieldMapping(b -> {
        MappedFieldType fieldType = mapperService.fieldType("field");
        } else if (fieldType.getTextSearchInfo().hasNorms()) {
    protected boolean supportsOrIgnoresBoost() {
            merge(mapperService, updateCheck.update);
    /**
                anyOf(containsString("Cannot update parameter [" + param + "]"), containsString("different [" + param + "]"))
     * like in the case of runtime fields.
    protected boolean supportsMeta() {
 *
            );
 */
            "Parameter [boost] on field [field] is deprecated and will be removed in 3.0",
        createMapperService(orig).documentMapper().mapping().toXContent(parsedFromOrig, INCLUDE_DEFAULTS);
        public void registerConflictCheck(String param, XContentBuilder init, XContentBuilder update) {
                update.accept(b);
import org.apache.lucene.index.IndexableFieldType;
         * @param update a field builder applied on top of the minimal mapping
            assertNoFieldNamesField(fields);
