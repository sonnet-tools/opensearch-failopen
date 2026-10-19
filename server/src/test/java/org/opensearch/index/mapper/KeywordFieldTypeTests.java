        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
            new TermInSetQuery("field", bytesRefList),
        );  
                new RegexpQuery(new Term("field", "foo.*"), 0, 0, RegexpQuery.DEFAULT_PROVIDER, 10, MultiTermQuery.DOC_VALUES_REWRITE)
    }
                    if (randomBoolean()) {
    }
            new WildcardQuery(
        assertEquals(Collections.singletonList("42"), fetchSourceValue(mapper, 42L));
        );
import org.opensearch.Version;
            indexExpected,
import java.util.ArrayList;  
 *
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(Collections.singletonList("42"), fetchSourceValue(normalizerMapper, 42L));
            ),  
        IllegalArgumentException e = expectThrows(
            new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", bytesRefList)
import org.apache.lucene.index.Term;
            BytesRefs.toBytesRef("bar"),
        OpenSearchException ee = expectThrows(
    }  
            false,
                    return "_" + strVal;  
        Term term = new Term("field", "foo");
        MappedFieldType ft = new KeywordFieldType("field") {
        );  
            @Override
            ),
import org.opensearch.index.analysis.CustomAnalyzer;
import org.opensearch.common.lucene.Lucene;
        );
 */
        assertEquals(dvExpected, onlyDocValues.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC));
        {
        );  
import org.opensearch.index.analysis.NamedAnalyzer;
        OpenSearchException ee = expectThrows(
            Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
        assertEquals(Collections.singletonList("value"), fetchSourceValue(normalizerMapper, "VALUE"));  
    }  
    }  
        MappedFieldType ft = new KeywordFieldType("field");
import org.apache.lucene.search.RegexpQuery;  
        assertEquals(Collections.emptyList(), fetchSourceValue(ignoreAboveMapper, "value"));
            new TermInSetQuery("field", terms),  
            assertEquals(new FieldExistsQuery("field"), ft.existsQuery(null));
        if (rarely()) {
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
    public void testTermQueryWithNormalizer() {  
                                return new org.apache.lucene.analysis.core.LowerCaseFilter(tokenStream);
                return new TokenStreamComponents(in, out);  
        IllegalArgumentException e = expectThrows(
            ee.getMessage()
    public void testTermQuery() {
    public void testWildCardQuery() {
                        } }
        assertEquals(expected, ft.termQueryCaseInsensitive("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        assertEquals(  
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE,  
            new ConstantScoreQuery(new TermQuery(new Term("field", "foo"))),
        }  
            new ConstantScoreQuery(new TermQuery(new Term("field", "foo"))),
    public void testRegexpQuery() {  
        terms.add(new BytesRef("bar"));
        );
                } else {
            assertEquals(new FieldExistsQuery("field"), ft.existsQuery(null));
 * this file be licensed under the Apache-2.0 license or a
 *
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.index.analysis.AnalyzerScope;  
        MappedFieldType ft = new KeywordFieldType("field");
import org.opensearch.common.unit.Fuzziness;
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
            () -> unsearchable.termsQuery(Arrays.asList("foo", "bar"), null)
                if (strVal.compareTo("a") >= 0) { // prepend letters in DV with underscore
        );
        );
 * The OpenSearch Contributors require contributions made to  
                            }  
        Query expected = SortedSetDocValuesField.newSlowRangeQuery("field", new BytesRef("foo"), new BytesRef("foo"), true, true);  
        return new IndexAnalyzers(  
    }
import org.apache.lucene.search.TermQuery;
            BytesRefs.toBytesRef("foo"),
        );
    }
        Analyzer normalizer = new Analyzer() {
        };  
        Query expected = new IndexOrDocValuesQuery(
        Query dvExpected = new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE);
        assertEquals("[fuzzy] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
 * ownership. Elasticsearch licenses this file to you under  
        );  
                randomBoolean(),  
        assertEquals(  
                MOCK_QSC_DISALLOW_EXPENSIVE
        assertEquals(expected, ft.termsQuery(strings, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            OpenSearchException.class,  
            )
                Fuzziness.AUTO,
        );  
            assertEquals(new TermQuery(new Term(FieldNamesFieldMapper.NAME, "field")), ft.existsQuery(null));  
                Tokenizer in = new WhitespaceTokenizer();
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.BytesRef;
                        return randomBoolean() ? value : new String(strVal);
        assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        ft = new KeywordFieldType("field", Lucene.STANDARD_ANALYZER);  
            e.getMessage()
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());  
import org.apache.lucene.analysis.TokenFilter;
        assertEquals(expected, ft.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        IllegalArgumentException e = expectThrows(
        assertEquals(  
                            @Override  
            e.getMessage()
 * under the License.  
        assertEquals(new TermQuery(new Term("field", "foo")), ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
    public void testTermsQuery() {  
import org.apache.lucene.search.Query;
            new IndexOrDocValuesQuery(  
 */  
        ft = new KeywordFieldType("field", true, false, Collections.emptyMap());
            ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            fieldType.setOmitNorms(false);  
        MappedFieldType ft = new KeywordFieldType("field");
                        return super.rewriteForDocValue(value);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Query indexExpected = new RegexpQuery(new Term("field", "foo.*"));
import org.apache.lucene.document.SortedSetDocValuesField;
        MappedFieldType ft = new KeywordFieldType("field");
        }  
                randomBoolean(),
            e.getMessage()  
            ),  
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
                        new TokenFilterFactory[] { new TokenFilterFactory() {
                randomBoolean(),
        assertEquals(indexExpected, onlyIndexed.regexpQuery("foo.*", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC));  
        KeywordFieldType ft = new KeywordFieldType("field");  
        assertEquals(
            IllegalArgumentException.class,  
import org.apache.lucene.search.ConstantScoreQuery;  
        List<String> strings = List.of("1", "2", "3", "4", "5", "a", "b", "c", "d", "e");
 * license agreements. See the NOTICE file distributed with
import com.carrotsearch.randomizedtesting.generators.RandomStrings;  
            e.getMessage()
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());  
                randomInt(10) + 1,  
        assertEquals(Collections.singletonList("NULL"), fetchSourceValue(nullValueMapper, null));
                randomInt(10) + 1,
            Relation.INTERSECTS,  
            MultiTermQuery.DOC_VALUES_REWRITE
        };
        List<String> sortedStrings = bytesRefList.stream().sorted().map(BytesRef::utf8ToString).toList();  
            RegexpQuery.DEFAULT_PROVIDER,  
        assertEquals(
        // backwards compatible enaled with useSimilarity=true  
        assertEquals(dvExpected, onlyDocValues.regexpQuery("foo.*", 0, 0, 10, MultiTermQuery.DOC_VALUES_REWRITE, MOCK_QSC));
        assertEquals("[regexp] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());  
                null,
            protected TokenStreamComponents createComponents(String fieldName) {  
        ft = new KeywordFieldType("field", true, false, true, Collections.emptyMap());
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",  
        Query dvExpected = new TermRangeQuery(
    }
import org.opensearch.index.analysis.CharFilterFactory;
        // current impl ignores args and should always return INTERSECTS
        List<BytesRef> terms = new ArrayList<>();
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", "foo bar"))), ft.termQuery("fOo BaR", null));  
            new TermInSetQuery("field", strings.stream().map(BytesRef::new).toList()),
import java.util.Collections;
            "field",  
        assertEquals(Collections.singletonList("value"), fetchSourceValue(normalizerMapper, "value"));
            IllegalArgumentException.class,
            MultiTermQuery.DOC_VALUES_REWRITE
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(  
            Map.ofEntries(
        );
import org.apache.lucene.search.TermInSetQuery;
            new Term("field", new BytesRef("foo*")),  
        assertEquals(  
            () -> unsearchable.regexpQuery("foo.*", 0, 0, 10, null, MOCK_QSC)
        assertEquals(expectedIndex, onlyIndexed.termsQuery(Arrays.asList("foo", "bar"), null));
import org.opensearch.index.mapper.MappedFieldType.Relation;  
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
        Query expected = new IndexOrDocValuesQuery(indexExpected, dvExpected);
            }  
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
            Map.of("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
        assertEquals(Collections.singletonList("42"), fetchSourceValue(ignoreAboveMapper, 42L));  
        Query dvExpected = new WildcardQuery(
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
                TokenFilter out = new LowerCaseFilter(in);
            ft.isFieldWithinQuery(
        );
import org.opensearch.index.analysis.TokenizerFactory;
        );
            .build(context)
import org.apache.lucene.analysis.Analyzer;
 * specific language governing permissions and limitations
        Query expectedIndex = new TermInSetQuery("field", bytesRefList);
            new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", dvStrings.stream().map(BytesRef::new).toList())
        Query expected = new IndexOrDocValuesQuery(  
            true,  
                    )
        terms.add(new BytesRef("foo"));  
import java.io.IOException;
/*
            new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", terms)
import org.apache.lucene.document.FieldType;  
                RandomStrings.randomAsciiLettersOfLengthBetween(random(), 0, 5),  
import org.apache.lucene.search.FieldExistsQuery;
        assertEquals(expected, ft.termQueryCaseInsensitive("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());  
            e.getMessage()
        ft = new KeywordFieldType("field", false, true, Collections.emptyMap());
/*  
            }
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        assertEquals(
    public void testFuzzyQuery() {  
            KeywordFieldType ft = new KeywordFieldType("field");
        assertEquals(expected, actual);
            @Override
    private static IndexAnalyzers createIndexAnalyzers() {
            .fieldType();
                    "lowercase",  
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());  
 * the Apache License, Version 2.0 (the "License"); you may
        List<BytesRef> bytesRefList = Arrays.stream(seedStrings).map(BytesRef::new).toList();
    }
            0,
                new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true),
    }
            onlyDocValues.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE, MOCK_QSC)  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> fetchSourceValue(mapper, "value", "format"));
    public void testExistsQuery() {
                MultiTermQuery.DOC_VALUES_REWRITE
    public void testTermQueryCaseInsensitive() {
        assertEquals(
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",  
        );  
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            )  
import org.apache.lucene.search.FuzzyQuery;
                return new LowerCaseFilter(in);
        );
        );
        );  
                Map.entry("lowercase", new NamedAnalyzer("lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer())),  
        Query indexExpected = new TermRangeQuery("field", BytesRefs.toBytesRef("foo"), BytesRefs.toBytesRef("bar"), true, false);
            }
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
        MappedFieldType ft = new KeywordFieldType("field");
            )
        expected = AutomatonQueries.createAutomatonQuery(
        IllegalArgumentException e = expectThrows(
    }
import org.opensearch.common.lucene.BytesRefs;
                new NamedAnalyzer(
    }
                "foo",
        IllegalArgumentException e = expectThrows(
                            public String name() {
    }
        Query expectedDocValues = new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", terms);
 * compatible open source license.
    public void testFetchSourceValue() throws IOException {
import java.util.List;  
            )
        );
            new WildcardQuery(new Term("field", new BytesRef("foo*"))),
        ft = new KeywordFieldType("field", true, false, Collections.emptyMap());
        MappedFieldType mapper = new KeywordFieldMapper.Builder("field").build(context).fieldType();
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
        );
        Query expectedIndex = new TermInSetQuery("field", terms);  
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
        assertEquals(expected, ft.termQueryCaseInsensitive("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
import org.opensearch.index.analysis.LowercaseNormalizer;
            () -> ft.regexpQuery("foo.*", randomInt(10), 0, randomInt(10) + 1, null, MOCK_QSC_DISALLOW_EXPENSIVE)
        assertEquals(
        Query indexExpected = new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE);
            @Override  
        OpenSearchException ee = expectThrows(
/*
                        TokenizerFactory.newFactory("lowercase", WhitespaceTokenizer::new),  
        {
        }
                )  
        OpenSearchException ee = expectThrows(
            IllegalArgumentException.class,
        assertEquals(expected, ft.termsQuery(Arrays.asList("foo", "bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
            MultiTermQuery.DOC_VALUES_REWRITE
        );
        assertEquals(indexExpected, onlyIndexed.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC));
import org.apache.lucene.search.IndexOrDocValuesQuery;  
 *  
            () -> unsearchable.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC)  
import java.util.Map;
            Map.of(  
        Query dvExpected = new RegexpQuery(
            MultiTermQuery.DOC_VALUES_REWRITE
            10,
            ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        );
        assertEquals(Collections.singletonList("value"), fetchSourceValue(mapper, "value"));  
                null,
            e.getMessage()
            () -> ft.fuzzyQuery(  
                RandomStrings.randomAsciiLettersOfLengthBetween(random(), 0, 5),
        assertEquals(  
import org.apache.lucene.analysis.LowerCaseFilter;  
import org.opensearch.index.analysis.IndexAnalyzers;  
import org.opensearch.OpenSearchException;
public class KeywordFieldTypeTests extends FieldTypeTestCase {  
            0,
        Query actual = ft.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC);  
                    } else {
        Query expectedDocValues = new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", bytesRefList);
        {  
        );  
                            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        );  
                null  
        assertEquals(expectedDocValues, onlyDocValues.termsQuery(Arrays.asList("foo", "bar"), null));
        List<String> dvStrings = List.of("1", "2", "3", "4", "5", "_a", "_b", "_c", "_d", "_e");
        assertEquals(  
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());  
        );
                "lowercase",
        assertEquals("[wildcard] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());  
                null,
        ft = new KeywordFieldType("field", false, true, Collections.emptyMap());
            () -> ft.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC_DISALLOW_EXPENSIVE)
            () -> ft.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC_DISALLOW_EXPENSIVE)
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            OpenSearchException.class,  
        assertEquals(
        MappedFieldType ignoreAboveMapper = new KeywordFieldMapper.Builder("field").ignoreAbove(4).build(context).fieldType();
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
                            public TokenStream create(TokenStream tokenStream) {
            Collections.shuffle(strings, random());  
        );  
        assertEquals(Collections.singletonList("true"), fetchSourceValue(ignoreAboveMapper, true));
import org.opensearch.index.analysis.TokenFilterFactory;  
                new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE)
    public void testTermsSortedQuery() {  
            onlyIndexed.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC)
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQueryCaseInsensitive("foo", null));  
            IllegalArgumentException.class,  
                    new CustomAnalyzer(
    }  
        );  
    public void testRangeQuery() {
            ft.regexpQuery("foo.*", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        MappedFieldType ft = new KeywordFieldType("field");
        assertEquals(indexExpected, onlyIndexed.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC));  
                Map.entry("other_lowercase", new NamedAnalyzer("other_lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer()))
            protected TokenStream normalize(String fieldName, TokenStream in) {
        MappedFieldType nullValueMapper = new KeywordFieldMapper.Builder("field").nullValue("NULL").build(context).fieldType();
import org.opensearch.common.settings.Settings;
        MappedFieldType ft = new KeywordFieldType("field");
        assertEquals(expected, ft.termsQuery(sortedStrings, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        assertEquals(  
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());  
            OpenSearchException.class,
            dvExpected,
 * You may obtain a copy of the License at  
                }
            new Term("field", "foo.*"),  
                    }  
    }
import org.apache.lucene.search.TermRangeQuery;  
 * KIND, either express or implied.  See the License for the
            () -> unsearchable.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC)
            term,
            e.getMessage()
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", new BytesRef("foo")))), ft.termQuery("FOO", null));
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
            () -> unsearchable.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)  
        MappedFieldType normalizerMapper = new KeywordFieldMapper.Builder("field", createIndexAnalyzers(), false).normalizer("lowercase")  
package org.opensearch.index.mapper;
        assertEquals(Collections.singletonList("true"), fetchSourceValue(mapper, true));
        );  
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
import java.util.Arrays;
                            @Override
 * software distributed under the License is distributed on an
            KeywordFieldType ft = new KeywordFieldType("field", true, false, Collections.emptyMap());
            KeywordFieldType ft = new KeywordFieldType("field", fieldType);
                        new CharFilterFactory[0],
 * this work for additional information regarding copyright
        assertEquals(dvExpected, onlyDocValues.wildcardQuery("foo*", MultiTermQuery.DOC_VALUES_REWRITE, MOCK_QSC));
                    AnalyzerScope.INDEX,
            FieldType fieldType = new FieldType();
    public void testNormalizeQueries() {  
import org.apache.lucene.search.MultiTermQuery;
                                return "lowercase";  
        );
        Query expected = new IndexOrDocValuesQuery(  
            IllegalArgumentException.class,  
        Query indexExpected = new WildcardQuery(new Term("field", new BytesRef("foo*")));
        assertEquals("Field [field] of type [keyword] doesn't support formats.", e.getMessage());
            () -> unsearchable.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE, MOCK_QSC)  
import org.apache.lucene.util.automaton.Operations;  
import org.apache.lucene.analysis.Tokenizer;  
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
            OpenSearchException.class,  
 * not use this file except in compliance with the License.
 * GitHub history for details.
}
        MappedFieldType ft = new KeywordFieldType("field");
        );
            new IndexOrDocValuesQuery(  
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());  
        assertEquals(
        String[] seedStrings = generateRandomStringArray(10, 10, false, true);
                new Term("field", new BytesRef("foo*")),  
        );  
                String strVal = (String) value;
 * Unless required by applicable law or agreed to in writing,
            IllegalArgumentException.class,
        IllegalArgumentException e = expectThrows(
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
        );  
            protected Object rewriteForDocValue(Object value) {  
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());  
import org.opensearch.common.lucene.search.AutomatonQueries;  
        MappedFieldType ft = new KeywordFieldType("field", new NamedAnalyzer("my_normalizer", AnalyzerScope.INDEX, normalizer));
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", new BytesRef("FOO")))), ft.termQuery("FOO", null));
        MappedFieldType ft = new KeywordFieldType("field");  
    public void testIsFieldWithinQuery() throws IOException {
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());  
            strings = new ArrayList<>(strings);
        );
 */
        assertEquals(expectedDocValues, onlyDocValues.termsQuery(sortedStrings, null));  
        assertEquals(expectedIndex, onlyIndexed.termsQuery(sortedStrings, null));
        );
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
        Query expected = new IndexOrDocValuesQuery(  
            AutomatonQueries.toCaseInsensitiveString("foo"),  
        Query expected = AutomatonQueries.caseInsensitiveTermQuery(new Term("field", BytesRefs.toBytesRef("foo")));
                new RegexpQuery(new Term("field", "foo.*")),
import org.apache.lucene.analysis.TokenStream;
    public void testTermsQuery_WhenDocValuesTrickyRewrite() {  
            "[range] queries on [text] or [keyword] fields cannot be executed when " + "'search.allow_expensive_queries' is set to false.",
