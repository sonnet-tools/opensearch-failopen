            try (IndexReader ir = DirectoryReader.open(directory)) {  
import static org.hamcrest.Matchers.instanceOf;
        return Arrays.asList(CustomScriptPlugin.class, TestGeoShapeFieldMapperPlugin.class);
        if (minimumShouldMatchScript != null) {
                iw.addDocument(document);
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.MatchNoDocsQuery;
                iw.addDocument(document);
                Document document = new Document();
                QueryShardContext context = createShardContext();
            assertThat(termQueries.get(i), equalTo(new TermQuery(term)));
        queryBuilder.setMinimumShouldMatchScript(new Script(""));
        String fieldName = instance.getFieldName();
            new CompressedXContent(PutMappingRequest.simpleMapping("m_s_m", "type=long").toString()),
        String minimumShouldMatchField = null;  
import org.opensearch.script.MockScriptEngine;
            newInstance.setMinimumShouldMatchField(minimumShouldMatchField);  
            case 2:
        rewriteQuery(queryBuilder, new QueryShardContext(context));
        assertNotNull(queryBuilder.doToQuery(context));
                iw.addDocument(document);
                Query query = new TermsSetQueryBuilder("message", Arrays.asList("a", "b", "c", "d")).setMinimumShouldMatchScript(script)  
        for (int i = 0; i < randomTerms.size(); i++) {
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;  
        rewriteQuery(queryBuilder, new QueryShardContext(context));  
    public void testDoToQuery() throws Exception {  
import java.io.IOException;  
            try (IndexWriter iw = new IndexWriter(directory, config)) {
            case 1:
        assertNotNull(queryBuilder.doToQuery(context));
                document.add(new SortedNumericDocValuesField("m_s_m", 3));
        List<?> randomTerms = randomValues(fieldName);  
        queryBuilder.setMinimumShouldMatchScript(null);
 */
        switch (randomIntBetween(0, 3)) {  
    @Override  
        rewriteQuery(queryBuilder, new QueryShardContext(context));  
 */
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());  
            config.setMergePolicy(NoMergePolicy.INSTANCE);  
            newInstance.setMinimumShouldMatchScript(minimumShouldMatchScript);  
                document.add(new SortedNumericDocValuesField("m_s_m", 2));  
                    int clauseCount = ObjectPath.evaluate(args, "params.num_terms");  
        context = createShardContext();
        QueryShardContext context = createShardContext();  
                assertThat(topDocs.scoreDocs[2].doc, equalTo(4));  
                break;
 * the Apache License, Version 2.0 (the "License"); you may
        queryBuilder = new TermsSetQueryBuilder(TEXT_FIELD_NAME, Collections.singletonList("foo"));  
        context = createShardContext();
        assertFalse("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
        TermsSetQueryBuilder queryBuilder = createTestQueryBuilder();
import java.util.ArrayList;
        try (Directory directory = newDirectory()) {
    @Override  
        if (queryBuilder.getValues().isEmpty()) {  
                    && s.equals(GEO_POINT_FIELD_NAME) == false  
                document.add(new TextField("message", "a b c d", Field.Store.NO));
    protected Collection<Class<? extends Plugin>> getPlugins() {
import java.util.List;  
 * software distributed under the License is distributed on an
import org.opensearch.test.AbstractQueryTestCase;
import org.apache.lucene.index.NoMergePolicy;  
        Script minimumShouldMatchScript = null;
import org.opensearch.common.compress.CompressedXContent;  
            MatchNoDocsQuery matchNoDocsQuery = (MatchNoDocsQuery) query;
    }
                }
 * this file be licensed under the Apache-2.0 license or a
                document = new Document();
                iw.addDocument(document);
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;  
 *  
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder(TEXT_FIELD_NAME, randomTerms);
                document.add(new SortedNumericDocValuesField("m_s_m", 1));
                document.add(new TextField("message", "a b c d", Field.Store.NO));
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
                document.add(new TextField("message", "a b x y", Field.Store.NO));
            MapperService.MergeReason.MAPPING_UPDATE
     * Check that this query is generally not cacheable and explicitly testing the two conditions when it is not as well
                assertThat(topDocs.totalHits.value(), equalTo(3L));
import org.opensearch.test.rest.yaml.ObjectPath;
            });  
        // specifically trigger the two cases where query is cacheable
    public void testFieldAlias() {  
package org.opensearch.index.query;
                iw.addDocument(document);  
}
                iw.addDocument(document);
        assertNotNull(queryBuilder.doToQuery(context));
                assertThat(topDocs.scoreDocs[1].doc, equalTo(3));
    }  
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
                iw.addDocument(document);  
        List<Query> termQueries = queryBuilder.createTermQueries(context);
import org.opensearch.script.MockScriptPlugin;
                break;
 * compatible open source license.
            docType,  
/*
        String fieldName = randomValueOtherThanMany(
                document = new Document();  
                Document document = new Document();
                assertThat(topDocs.scoreDocs[1].doc, equalTo(2));  
                minimumShouldMatchScript = new Script(ScriptType.INLINE, MockScriptEngine.NAME, randomAlphaOfLength(10), emptyMap());  
        }
                fieldName = randomValueOtherThanMany(predicate, () -> randomFrom(MAPPED_FIELD_NAMES));
import org.apache.lucene.index.IndexWriterConfig;
    }
import org.apache.lucene.search.IndexSearcher;  
        }  
        queryBuilder = new TermsSetQueryBuilder(TEXT_FIELD_NAME, Collections.emptyList());
    public void testCacheability() throws IOException {
 * license agreements. See the NOTICE file distributed with
            }
                values = randomValues(fieldName);  
            isCacheable,
        queryBuilder.setMinimumShouldMatchField("m_s_m");
                try {
        );  
        return queryBuilder;
        }
import org.apache.lucene.index.DirectoryReader;
import static org.hamcrest.Matchers.containsString;  
 * You may obtain a copy of the License at  
import java.util.function.Predicate;  
    }
    }  
            Term term = new Term(expectedFieldName, randomTerms.get(i));  
        );
                iw.addDocument(document);
                    .doToQuery(context);  
        expectThrows(IllegalArgumentException.class, () -> queryBuilder.setMinimumShouldMatchScript(new Script("")));  
import org.apache.lucene.index.IndexWriter;
                Query query = new TermsSetQueryBuilder("message", Arrays.asList("c", "d")).setMinimumShouldMatchField("m_s_m")
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {  
                document.add(new TextField("message", "a b c", Field.Store.NO));
import org.apache.lucene.document.SortedNumericDocValuesField;  
                break;
 * KIND, either express or implied.  See the License for the
    @Override  
                } catch (IOException e) {  
import org.apache.lucene.document.TextField;
    public static class CustomScriptPlugin extends MockScriptPlugin {  
                document.add(new TextField("message", "a b x y", Field.Store.NO));
    }  
 * ownership. Elasticsearch licenses this file to you under  
public class TermsSetQueryBuilderTests extends AbstractQueryTestCase<TermsSetQueryBuilder> {
import org.apache.lucene.index.IndexReader;  
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.emptyMap;
    public TermsSetQueryBuilder mutateInstance(final TermsSetQueryBuilder instance) throws IOException {  
                    throw new UncheckedIOException(e);
        );
        TermsSetQueryBuilder newInstance = new TermsSetQueryBuilder(fieldName, values);
import java.util.Collections;
                document = new Document();
                document.add(new SortedNumericDocValuesField("m_s_m", 50));  
                    long msm = ((ScriptDocValues.Longs) ObjectPath.evaluate(args, "doc.m_s_m")).getValue();
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
        boolean isCacheable = queryBuilder.getMinimumShouldMatchField() != null  
        if (randomBoolean()) {
                document = new Document();
                document.add(new SortedNumericDocValuesField("m_s_m", 2));
        assertNotNull(queryBuilder.doToQuery(context));
            queryBuilder.setMinimumShouldMatchField("m_s_m");  
import java.util.function.Function;
                TopDocs topDocs = searcher.search(query, 10, new Sort(SortField.FIELD_DOC));  
            "query should " + (isCacheable ? "" : "not") + " be cacheable: " + queryBuilder.toString(),  
import org.opensearch.script.ScriptType;
import java.util.Collection;
        List<String> randomTerms = Arrays.asList(generateRandomStringArray(5, 10, false, false));
import org.apache.lucene.sandbox.search.CoveringQuery;
import org.opensearch.index.fielddata.ScriptDocValues;
        }  
            IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
                document = new Document();  
 *
    }
        final List<Object> values = new ArrayList<>(numValues);
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
        QueryShardContext context = createShardContext();
            case 3:
                values = randomValues(fieldName);  
        } else {
/*
    @Override
                document.add(new SortedNumericDocValuesField("m_s_m", 1));  
        // also test one case where query is not cacheable
    }  
 */  
        );  
                document.add(new SortedNumericDocValuesField("m_s_m", 75));
        assertEquals(randomTerms.size(), termQueries.size());
            try (IndexWriter iw = new IndexWriter(directory, config)) {  
import org.opensearch.plugins.Plugin;  
            config.setMergePolicy(NoMergePolicy.INSTANCE);
import org.apache.lucene.search.Sort;  
 * not use this file except in compliance with the License.
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
        queryBuilder.setMinimumShouldMatchField("_field");
            "m_s_m"  
                document.add(new TextField("message", "a b c x", Field.Store.NO));  
        } else {
 * The OpenSearch Contributors require contributions made to  
/*  
                document.add(new TextField("message", "a b c", Field.Store.NO));
        String expectedFieldName = expectedFieldName(queryBuilder.getFieldName());
    @Override
    }  
        return values;  
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder("_field", Collections.emptyList());  
                document.add(new TextField("message", "a b c x", Field.Store.NO));
            assertThat(matchNoDocsQuery.toString(), containsString("No terms supplied for \"terms_set\" query."));  
            queryBuilder.setMinimumShouldMatchScript(new Script(ScriptType.INLINE, MockScriptEngine.NAME, "_script", emptyMap()));
            values.add(getRandomValueForFieldName(fieldName));
                IndexSearcher searcher = new IndexSearcher(ir);
        try (Directory directory = newDirectory()) {  
                iw.addDocument(document);  
                document = new Document();
                document.add(new SortedNumericDocValuesField("m_s_m", 100));  
        }
import java.util.Arrays;  
        rewriteQuery(queryBuilder, new QueryShardContext(context));  
 * GitHub history for details.
        return newInstance;
    protected void doAssertLuceneQuery(TermsSetQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
                QueryShardContext context = createShardContext();
                IndexSearcher searcher = new IndexSearcher(ir);
        }
                minimumShouldMatchField = randomAlphaOfLengthBetween(1, 10);  
                document = new Document();
        queryBuilder.setMinimumShouldMatchScript(new Script(ScriptType.INLINE, MockScriptEngine.NAME, "_script", emptyMap()));
            }
                document.add(new SortedNumericDocValuesField("m_s_m", 75));
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder(TEXT_ALIAS_FIELD_NAME, randomTerms).setMinimumShouldMatchField(
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.Map;
                document.add(new SortedNumericDocValuesField("m_s_m", 1));
        for (int i = 0; i < numValues; i++) {  
        String docType = "_doc";
    public void testBothFieldAndScriptSpecified() {
            }
        mapperService.merge(
        }
     */
            }
        @Override
        assertEquals(
 *
            value -> value.equals(GEO_POINT_FIELD_NAME) || value.equals(GEO_SHAPE_FIELD_NAME),  
                document = new Document();  
        final int numValues = randomIntBetween(0, 10);  
        }
 * specific language governing permissions and limitations
            try (IndexReader ir = DirectoryReader.open(directory)) {  
                assertThat(topDocs.scoreDocs[2].doc, equalTo(4));
    private static List<?> randomValues(final String fieldName) {
        }
import java.io.UncheckedIOException;
            return Collections.singletonMap("_script", args -> {
            IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
        queryBuilder = new TermsSetQueryBuilder(TEXT_FIELD_NAME, Collections.singletonList("foo"));  
                assertThat(topDocs.scoreDocs[0].doc, equalTo(1));
import org.apache.lucene.search.TopDocs;  
                assertThat(topDocs.scoreDocs[0].doc, equalTo(0));
                    return clauseCount * (msm / 100d);
                document.add(new TextField("message", "a b c d", Field.Store.NO));
    @Override
import org.opensearch.script.Script;  
        List<?> values = instance.getValues();
import org.opensearch.index.mapper.MapperService;
import org.apache.lucene.store.Directory;
                document = new Document();  
                iw.addDocument(document);  
        queryBuilder.setMinimumShouldMatchScript(new Script(ScriptType.INLINE, MockScriptEngine.NAME, "_script", emptyMap()));
                    && s.equals(GEO_SHAPE_FIELD_NAME) == false;
                assertThat(topDocs.totalHits.value(), equalTo(3L));  
                document.add(new TextField("message", "a b", Field.Store.NO));  
import static org.hamcrest.Matchers.equalTo;
                iw.addDocument(document);
    }
        expectThrows(IllegalArgumentException.class, () -> queryBuilder.setMinimumShouldMatchField("_field"));
                document.add(new SortedNumericDocValuesField("m_s_m", 100));
        if (minimumShouldMatchField != null) {
import org.apache.lucene.document.Field;
    public void testDoToQuery_msmScriptField() throws Exception {
 * this work for additional information regarding copyright
                Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "_script", emptyMap());
            assertThat(query, instanceOf(CoveringQuery.class));
import org.apache.lucene.search.Query;
                Predicate<String> predicate = s -> s.equals(instance.getFieldName()) == false
    }
import org.apache.lucene.index.Term;
            case 0:
import org.apache.lucene.document.Document;
            context.isCacheable()
    }
                TopDocs topDocs = searcher.search(query, 10, new Sort(SortField.FIELD_DOC));
                    .doToQuery(context);
        context = createShardContext();  
                break;
    /**  
                document.add(new TextField("message", "a b c d", Field.Store.NO));  
            || (queryBuilder.getMinimumShouldMatchScript() != null && queryBuilder.getValues().isEmpty());
    protected TermsSetQueryBuilder doCreateTestQueryBuilder() {
            () -> randomFrom(MAPPED_FIELD_NAMES)
