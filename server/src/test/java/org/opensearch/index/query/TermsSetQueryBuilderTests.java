 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                QueryShardContext context = createShardContext();
                assertThat(topDocs.scoreDocs[1].doc, equalTo(3));
        queryBuilder.setMinimumShouldMatchScript(new Script(ScriptType.INLINE, MockScriptEngine.NAME, "_script", emptyMap()));
import java.util.function.Function;
        if (minimumShouldMatchScript != null) {
                iw.addDocument(document);
            values.add(getRandomValueForFieldName(fieldName));
    @Override
    public TermsSetQueryBuilder mutateInstance(final TermsSetQueryBuilder instance) throws IOException {
        QueryShardContext context = createShardContext();
        if (randomBoolean()) {
/*
     */
            });
            case 3:
import org.opensearch.index.mapper.MapperService;
        @Override
            new CompressedXContent(PutMappingRequest.simpleMapping("m_s_m", "type=long").toString()),
        );
                values = randomValues(fieldName);
        assertEquals(
import org.apache.lucene.index.IndexWriter;
        // specifically trigger the two cases where query is cacheable
            try (IndexReader ir = DirectoryReader.open(directory)) {
        if (queryBuilder.getValues().isEmpty()) {
            value -> value.equals(GEO_POINT_FIELD_NAME) || value.equals(GEO_SHAPE_FIELD_NAME),
                document = new Document();
        );
            assertThat(query, instanceOf(CoveringQuery.class));
                iw.addDocument(document);
 * Unless required by applicable law or agreed to in writing,
                iw.addDocument(document);
                    throw new UncheckedIOException(e);
 *
        mapperService.merge(
import java.util.function.Predicate;
        String fieldName = instance.getFieldName();
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.apache.lucene.search.TermQuery;
        rewriteQuery(queryBuilder, new QueryShardContext(context));
            try (IndexReader ir = DirectoryReader.open(directory)) {
        for (int i = 0; i < randomTerms.size(); i++) {
            MatchNoDocsQuery matchNoDocsQuery = (MatchNoDocsQuery) query;
import java.util.ArrayList;
                    long msm = ((ScriptDocValues.Longs) ObjectPath.evaluate(args, "doc.m_s_m")).getValue();
        context = createShardContext();
        QueryShardContext context = createShardContext();
 * GitHub history for details.
                values = randomValues(fieldName);
 * this file be licensed under the Apache-2.0 license or a
    }
                document.add(new SortedNumericDocValuesField("m_s_m", 1));
        } else {
            || (queryBuilder.getMinimumShouldMatchScript() != null && queryBuilder.getValues().isEmpty());
                document.add(new SortedNumericDocValuesField("m_s_m", 1));
 * software distributed under the License is distributed on an
                Document document = new Document();
    }
        queryBuilder = new TermsSetQueryBuilder(TEXT_FIELD_NAME, Collections.emptyList());
                document.add(new SortedNumericDocValuesField("m_s_m", 2));
        }
            "query should " + (isCacheable ? "" : "not") + " be cacheable: " + queryBuilder.toString(),
            IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
                document = new Document();
        }
import org.opensearch.script.Script;
import org.apache.lucene.document.SortedNumericDocValuesField;
                Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "_script", emptyMap());
        context = createShardContext();
        expectThrows(IllegalArgumentException.class, () -> queryBuilder.setMinimumShouldMatchScript(new Script("")));
            newInstance.setMinimumShouldMatchField(minimumShouldMatchField);
                document.add(new SortedNumericDocValuesField("m_s_m", 1));
        }
        queryBuilder.setMinimumShouldMatchField("m_s_m");
import org.opensearch.common.compress.CompressedXContent;
        queryBuilder.setMinimumShouldMatchField("_field");
                assertThat(topDocs.totalHits.value(), equalTo(3L));
        TermsSetQueryBuilder queryBuilder = createTestQueryBuilder();
 * not use this file except in compliance with the License.
            }
        return Arrays.asList(CustomScriptPlugin.class, TestGeoShapeFieldMapperPlugin.class);
                QueryShardContext context = createShardContext();
import org.opensearch.plugins.Plugin;
        }
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
                Document document = new Document();
public class TermsSetQueryBuilderTests extends AbstractQueryTestCase<TermsSetQueryBuilder> {
        rewriteQuery(queryBuilder, new QueryShardContext(context));
import org.apache.lucene.index.IndexReader;
        } else {
 * The OpenSearch Contributors require contributions made to
    }
        assertNotNull(queryBuilder.doToQuery(context));
/*
        List<?> values = instance.getValues();
 * compatible open source license.
                iw.addDocument(document);
        TermsSetQueryBuilder newInstance = new TermsSetQueryBuilder(fieldName, values);
import static java.util.Collections.emptyMap;
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
        assertFalse("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
import org.apache.lucene.document.Document;
                document.add(new SortedNumericDocValuesField("m_s_m", 100));
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
        }
                document = new Document();
            newInstance.setMinimumShouldMatchScript(minimumShouldMatchScript);
    public void testFieldAlias() {
                iw.addDocument(document);
import org.apache.lucene.search.Sort;
        assertNotNull(queryBuilder.doToQuery(context));
                assertThat(topDocs.scoreDocs[1].doc, equalTo(2));
                IndexSearcher searcher = new IndexSearcher(ir);
                fieldName = randomValueOtherThanMany(predicate, () -> randomFrom(MAPPED_FIELD_NAMES));
    @Override
    }
        return queryBuilder;
import java.util.Collection;
        queryBuilder = new TermsSetQueryBuilder(TEXT_FIELD_NAME, Collections.singletonList("foo"));
        assertNotNull(queryBuilder.doToQuery(context));
 * You may obtain a copy of the License at
        // also test one case where query is not cacheable
                document.add(new SortedNumericDocValuesField("m_s_m", 3));
package org.opensearch.index.query;
            case 0:
                iw.addDocument(document);
                break;
import org.apache.lucene.search.SortField;
        queryBuilder.setMinimumShouldMatchScript(new Script(""));
     * Check that this query is generally not cacheable and explicitly testing the two conditions when it is not as well
                assertThat(topDocs.scoreDocs[0].doc, equalTo(1));
        assertEquals(randomTerms.size(), termQueries.size());
            assertThat(matchNoDocsQuery.toString(), containsString("No terms supplied for \"terms_set\" query."));
                iw.addDocument(document);
 */
                minimumShouldMatchScript = new Script(ScriptType.INLINE, MockScriptEngine.NAME, randomAlphaOfLength(10), emptyMap());
                document.add(new TextField("message", "a b c d", Field.Store.NO));
                document = new Document();
import java.util.Arrays;
                document.add(new TextField("message", "a b c", Field.Store.NO));
                } catch (IOException e) {
        String expectedFieldName = expectedFieldName(queryBuilder.getFieldName());
import org.apache.lucene.index.IndexWriterConfig;
                document.add(new SortedNumericDocValuesField("m_s_m", 75));
 *     http://www.apache.org/licenses/LICENSE-2.0
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder(TEXT_ALIAS_FIELD_NAME, randomTerms).setMinimumShouldMatchField(
                assertThat(topDocs.totalHits.value(), equalTo(3L));
                break;
 * this work for additional information regarding copyright
import java.util.Map;
import static org.hamcrest.Matchers.containsString;
                IndexSearcher searcher = new IndexSearcher(ir);
import java.io.IOException;
    public void testBothFieldAndScriptSpecified() {
                assertThat(topDocs.scoreDocs[2].doc, equalTo(4));
        if (minimumShouldMatchField != null) {
        List<Query> termQueries = queryBuilder.createTermQueries(context);
        return values;
        }
import org.opensearch.index.fielddata.ScriptDocValues;
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder("_field", Collections.emptyList());
                Predicate<String> predicate = s -> s.equals(instance.getFieldName()) == false
        switch (randomIntBetween(0, 3)) {
                iw.addDocument(document);
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
    /**
            }
    }
                assertThat(topDocs.scoreDocs[0].doc, equalTo(0));
 * SPDX-License-Identifier: Apache-2.0
        queryBuilder.setMinimumShouldMatchScript(new Script(ScriptType.INLINE, MockScriptEngine.NAME, "_script", emptyMap()));
import java.io.UncheckedIOException;
    @Override
            case 1:
                }
import org.apache.lucene.document.TextField;
                document.add(new TextField("message", "a b c x", Field.Store.NO));
            try (IndexWriter iw = new IndexWriter(directory, config)) {
        final List<Object> values = new ArrayList<>(numValues);
                document = new Document();
    protected void doAssertLuceneQuery(TermsSetQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        assertNotNull(queryBuilder.doToQuery(context));
 * license agreements. See the NOTICE file distributed with
                document.add(new TextField("message", "a b c d", Field.Store.NO));
 */
            return Collections.singletonMap("_script", args -> {
import org.apache.lucene.search.Query;
import org.opensearch.script.ScriptType;
        queryBuilder = new TermsSetQueryBuilder(TEXT_FIELD_NAME, Collections.singletonList("foo"));
import org.apache.lucene.search.MatchNoDocsQuery;
    protected TermsSetQueryBuilder doCreateTestQueryBuilder() {
import org.apache.lucene.index.Term;
                    int clauseCount = ObjectPath.evaluate(args, "params.num_terms");
        return newInstance;
 *
        }
}
            config.setMergePolicy(NoMergePolicy.INSTANCE);
import static org.hamcrest.Matchers.instanceOf;
import org.apache.lucene.index.NoMergePolicy;
    protected Collection<Class<? extends Plugin>> getPlugins() {
        }
                document = new Document();
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(termQueries.get(i), equalTo(new TermQuery(term)));
                minimumShouldMatchField = randomAlphaOfLengthBetween(1, 10);
        }
                    && s.equals(GEO_SHAPE_FIELD_NAME) == false;
            context.isCacheable()
        queryBuilder.setMinimumShouldMatchScript(null);
    @Override
            docType,
        }
    public void testDoToQuery_msmScriptField() throws Exception {
                document.add(new SortedNumericDocValuesField("m_s_m", 50));
        try (Directory directory = newDirectory()) {
    }
        expectThrows(IllegalArgumentException.class, () -> queryBuilder.setMinimumShouldMatchField("_field"));
 *
 * specific language governing permissions and limitations
    public void testDoToQuery() throws Exception {
        String fieldName = randomValueOtherThanMany(
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder(TEXT_FIELD_NAME, randomTerms);
        String minimumShouldMatchField = null;
            "m_s_m"
 * KIND, either express or implied.  See the License for the
                document.add(new TextField("message", "a b c d", Field.Store.NO));
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
        );
    public static class CustomScriptPlugin extends MockScriptPlugin {
 * Modifications Copyright OpenSearch Contributors. See
                    .doToQuery(context);
                Query query = new TermsSetQueryBuilder("message", Arrays.asList("c", "d")).setMinimumShouldMatchField("m_s_m")
        String docType = "_doc";
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
            try (IndexWriter iw = new IndexWriter(directory, config)) {
            IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
                document.add(new TextField("message", "a b x y", Field.Store.NO));
            Term term = new Term(expectedFieldName, randomTerms.get(i));
import org.apache.lucene.sandbox.search.CoveringQuery;
 * under the License.
                TopDocs topDocs = searcher.search(query, 10, new Sort(SortField.FIELD_DOC));
    @Override
            config.setMergePolicy(NoMergePolicy.INSTANCE);
import org.apache.lucene.document.Field;
    }
import org.opensearch.test.rest.yaml.ObjectPath;
        try (Directory directory = newDirectory()) {
import org.opensearch.script.MockScriptPlugin;
 * Licensed to Elasticsearch under one or more contributor
        for (int i = 0; i < numValues; i++) {
    }
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
                    return clauseCount * (msm / 100d);
                break;
                document = new Document();
                iw.addDocument(document);
        List<?> randomTerms = randomValues(fieldName);
    }
                iw.addDocument(document);
import org.apache.lucene.store.Directory;
            () -> randomFrom(MAPPED_FIELD_NAMES)
                assertThat(topDocs.scoreDocs[2].doc, equalTo(4));
            isCacheable,
                document.add(new SortedNumericDocValuesField("m_s_m", 2));
                document.add(new TextField("message", "a b", Field.Store.NO));
            }
        boolean isCacheable = queryBuilder.getMinimumShouldMatchField() != null
            queryBuilder.setMinimumShouldMatchScript(new Script(ScriptType.INLINE, MockScriptEngine.NAME, "_script", emptyMap()));
import org.apache.lucene.search.TopDocs;
    private static List<?> randomValues(final String fieldName) {
            MapperService.MergeReason.MAPPING_UPDATE
 * ownership. Elasticsearch licenses this file to you under
        Script minimumShouldMatchScript = null;
                try {
    }
                TopDocs topDocs = searcher.search(query, 10, new Sort(SortField.FIELD_DOC));
            case 2:
        final int numValues = randomIntBetween(0, 10);
                Query query = new TermsSetQueryBuilder("message", Arrays.asList("a", "b", "c", "d")).setMinimumShouldMatchScript(script)
                document.add(new TextField("message", "a b c d", Field.Store.NO));
                document.add(new SortedNumericDocValuesField("m_s_m", 100));
                break;
import java.util.Collections;
    @Override
    }
                document.add(new TextField("message", "a b c", Field.Store.NO));
        rewriteQuery(queryBuilder, new QueryShardContext(context));
                    .doToQuery(context);
                document = new Document();
import org.opensearch.test.AbstractQueryTestCase;
                document.add(new SortedNumericDocValuesField("m_s_m", 75));
        List<String> randomTerms = Arrays.asList(generateRandomStringArray(5, 10, false, false));
import org.apache.lucene.index.DirectoryReader;
import java.util.List;
                document = new Document();
                iw.addDocument(document);
            queryBuilder.setMinimumShouldMatchField("m_s_m");
                document.add(new TextField("message", "a b x y", Field.Store.NO));
        rewriteQuery(queryBuilder, new QueryShardContext(context));
            }
    public void testCacheability() throws IOException {
        context = createShardContext();
        );
import org.opensearch.script.MockScriptEngine;
                document.add(new TextField("message", "a b c x", Field.Store.NO));
import org.apache.lucene.search.IndexSearcher;
    }
/*
                    && s.equals(GEO_POINT_FIELD_NAME) == false
 */
import static org.hamcrest.Matchers.equalTo;
