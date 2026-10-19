            ),
        assertEquals(Collections.emptyList(), fetchSourceValue(ignoreAboveMapper, "value"));
 * ownership. Elasticsearch licenses this file to you under
    }
            new Term("field", new BytesRef("foo*")),
    private static IndexAnalyzers createIndexAnalyzers() {
        );
    public void testRangeQuery() {
                randomInt(10) + 1,
 *     http://www.apache.org/licenses/LICENSE-2.0
        {
 * Unless required by applicable law or agreed to in writing,
    public void testTermsSortedQuery() {
                return new TokenStreamComponents(in, out);
            0,
 */
import org.apache.lucene.search.ConstantScoreQuery;
        Query dvExpected = new RegexpQuery(
    public void testTermQueryWithNormalizer() {
    }
    }
            new TermInSetQuery("field", terms),
import org.opensearch.index.analysis.NamedAnalyzer;
                Map.entry("other_lowercase", new NamedAnalyzer("other_lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer()))
        assertEquals("[wildcard] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.analysis.TokenStream;
        );
        MappedFieldType normalizerMapper = new KeywordFieldMapper.Builder("field", createIndexAnalyzers(), false).normalizer("lowercase")
                String strVal = (String) value;
            e.getMessage()
            new ConstantScoreQuery(new TermQuery(new Term("field", "foo"))),
            protected TokenStreamComponents createComponents(String fieldName) {
        );
            fieldType.setOmitNorms(false);
            new IndexOrDocValuesQuery(
        }
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            IllegalArgumentException.class,
            new TermInSetQuery("field", bytesRefList),
    }
                null
 * under the License.
                            @Override
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
import org.apache.lucene.search.TermQuery;
        assertEquals(expected, ft.termQueryCaseInsensitive("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                randomBoolean(),
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
        assertEquals(
        Query expectedDocValues = new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", terms);
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", "foo bar"))), ft.termQuery("fOo BaR", null));
            () -> ft.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC_DISALLOW_EXPENSIVE)
        assertEquals(
import org.opensearch.index.analysis.TokenizerFactory;
        assertEquals(expected, ft.termQueryCaseInsensitive("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
import org.apache.lucene.index.Term;
        assertEquals(expected, ft.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        );
            }
        assertEquals(Collections.singletonList("value"), fetchSourceValue(mapper, "value"));
        );
/*
                new Term("field", new BytesRef("foo*")),
            onlyDocValues.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE, MOCK_QSC)
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
                        return randomBoolean() ? value : new String(strVal);
        Query indexExpected = new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE);
                        TokenizerFactory.newFactory("lowercase", WhitespaceTokenizer::new),
            Map.ofEntries(
        IllegalArgumentException e = expectThrows(
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
        MappedFieldType ft = new KeywordFieldType("field");
            () -> unsearchable.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE, MOCK_QSC)
            assertEquals(new TermQuery(new Term(FieldNamesFieldMapper.NAME, "field")), ft.existsQuery(null));
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.opensearch.index.analysis.IndexAnalyzers;
public class KeywordFieldTypeTests extends FieldTypeTestCase {
        Query expected = new IndexOrDocValuesQuery(
            e.getMessage()
            () -> unsearchable.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC)
/*
        assertEquals(indexExpected, onlyIndexed.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC));
        assertEquals(expectedIndex, onlyIndexed.termsQuery(Arrays.asList("foo", "bar"), null));
        Query expected = SortedSetDocValuesField.newSlowRangeQuery("field", new BytesRef("foo"), new BytesRef("foo"), true, true);
                "foo",
}
        );
        assertEquals(
        );
        Query expectedIndex = new TermInSetQuery("field", terms);
                new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE)
            }
                        } }
    public void testTermQueryCaseInsensitive() {
import org.apache.lucene.analysis.LowerCaseFilter;
        assertEquals(Collections.singletonList("42"), fetchSourceValue(ignoreAboveMapper, 42L));
import org.opensearch.index.analysis.CustomAnalyzer;
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
        assertEquals(expectedDocValues, onlyDocValues.termsQuery(Arrays.asList("foo", "bar"), null));
 * not use this file except in compliance with the License.
    }
        ft = new KeywordFieldType("field", false, true, Collections.emptyMap());
        assertEquals(
        }
        Query indexExpected = new RegexpQuery(new Term("field", "foo.*"));
        Query expected = new IndexOrDocValuesQuery(
import org.apache.lucene.search.TermInSetQuery;
        );
import org.opensearch.Version;
            @Override
            new Term("field", "foo.*"),
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> fetchSourceValue(mapper, "value", "format"));
            new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", terms)
                    )
            AutomatonQueries.toCaseInsensitiveString("foo"),
        // current impl ignores args and should always return INTERSECTS
            )
            OpenSearchException.class,
        );
        assertEquals(
    }
        assertEquals(
 * this work for additional information regarding copyright
        OpenSearchException ee = expectThrows(
                TokenFilter out = new LowerCaseFilter(in);
            Map.of("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
                null,
        assertEquals(
 * software distributed under the License is distributed on an
        );
            OpenSearchException.class,
        );
 */
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
        assertEquals(indexExpected, onlyIndexed.regexpQuery("foo.*", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC));
                new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true),
                        new TokenFilterFactory[] { new TokenFilterFactory() {
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
            MultiTermQuery.DOC_VALUES_REWRITE
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
                Map.entry("lowercase", new NamedAnalyzer("lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer())),
        );
                            }
        assertEquals(expectedDocValues, onlyDocValues.termsQuery(sortedStrings, null));
            KeywordFieldType ft = new KeywordFieldType("field", fieldType);
        ft = new KeywordFieldType("field", Lucene.STANDARD_ANALYZER);
 * compatible open source license.
            dvExpected,
        assertEquals(expectedIndex, onlyIndexed.termsQuery(sortedStrings, null));
        IllegalArgumentException e = expectThrows(
    public void testRegexpQuery() {
        List<BytesRef> terms = new ArrayList<>();
        MappedFieldType ft = new KeywordFieldType("field");
        );
        Query expected = new IndexOrDocValuesQuery(
        Query dvExpected = new WildcardQuery(
        Query indexExpected = new TermRangeQuery("field", BytesRefs.toBytesRef("foo"), BytesRefs.toBytesRef("bar"), true, false);
                randomInt(10) + 1,
import org.apache.lucene.search.MultiTermQuery;
                "lowercase",
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", dvStrings.stream().map(BytesRef::new).toList())
import org.apache.lucene.analysis.TokenFilter;
    }
        assertEquals(Collections.singletonList("value"), fetchSourceValue(normalizerMapper, "VALUE"));
                Fuzziness.AUTO,
        );
        return new IndexAnalyzers(
        {
            }
 * the Apache License, Version 2.0 (the "License"); you may
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
                            @Override
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
        assertEquals(expected, actual);
            )
                new NamedAnalyzer(
            .fieldType();
        assertEquals(Collections.singletonList("true"), fetchSourceValue(ignoreAboveMapper, true));
import org.apache.lucene.document.FieldType;
import java.io.IOException;
        assertEquals(Collections.singletonList("true"), fetchSourceValue(mapper, true));
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
        {
            term,
        );
            Collections.shuffle(strings, random());
            10,
                    } else {
        assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            () -> ft.fuzzyQuery(
            BytesRefs.toBytesRef("bar"),
            ft.regexpQuery("foo.*", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        assertEquals(
        ft = new KeywordFieldType("field", true, false, true, Collections.emptyMap());
            MultiTermQuery.DOC_VALUES_REWRITE
                    if (randomBoolean()) {
            KeywordFieldType ft = new KeywordFieldType("field", true, false, Collections.emptyMap());
            () -> unsearchable.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC)
 * You may obtain a copy of the License at
                RandomStrings.randomAsciiLettersOfLengthBetween(random(), 0, 5),
        MappedFieldType ft = new KeywordFieldType("field");
import java.util.Arrays;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQueryCaseInsensitive("foo", null));
        OpenSearchException ee = expectThrows(
        MappedFieldType ft = new KeywordFieldType("field", new NamedAnalyzer("my_normalizer", AnalyzerScope.INDEX, normalizer));
        Query dvExpected = new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE);
import org.opensearch.index.analysis.LowercaseNormalizer;
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
                RandomStrings.randomAsciiLettersOfLengthBetween(random(), 0, 5),
        ft = new KeywordFieldType("field", true, false, Collections.emptyMap());
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", new BytesRef("FOO")))), ft.termQuery("FOO", null));
        Query expected = new IndexOrDocValuesQuery(
        assertEquals(expected, ft.termsQuery(Arrays.asList("foo", "bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
 * The OpenSearch Contributors require contributions made to
    }
                null,
        Query expectedIndex = new TermInSetQuery("field", bytesRefList);
        MappedFieldType ignoreAboveMapper = new KeywordFieldMapper.Builder("field").ignoreAbove(4).build(context).fieldType();
            () -> ft.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC_DISALLOW_EXPENSIVE)
        terms.add(new BytesRef("bar"));
        Query indexExpected = new WildcardQuery(new Term("field", new BytesRef("foo*")));
                }
        assertEquals(expected, ft.termQueryCaseInsensitive("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
/*
    public void testTermQuery() {
import org.apache.lucene.search.Query;
        MappedFieldType nullValueMapper = new KeywordFieldMapper.Builder("field").nullValue("NULL").build(context).fieldType();
import org.opensearch.common.lucene.BytesRefs;
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE,
        );
        Analyzer normalizer = new Analyzer() {
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.TermRangeQuery;
 * specific language governing permissions and limitations
            @Override
        assertEquals(
        );
        MappedFieldType ft = new KeywordFieldType("field");
                )
import org.opensearch.common.unit.Fuzziness;
            e.getMessage()
            "[range] queries on [text] or [keyword] fields cannot be executed when " + "'search.allow_expensive_queries' is set to false.",
        );
 *
import org.apache.lucene.analysis.Tokenizer;
        assertEquals(indexExpected, onlyIndexed.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC));
import org.apache.lucene.util.automaton.Operations;
        assertEquals("[regexp] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
            .build(context)
    }
package org.opensearch.index.mapper;
                randomBoolean(),
            @Override
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            0,
 *
            KeywordFieldType ft = new KeywordFieldType("field");
        );
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
import org.opensearch.OpenSearchException;
            )
import org.apache.lucene.search.IndexOrDocValuesQuery;
            Map.of(
            new WildcardQuery(
            assertEquals(new FieldExistsQuery("field"), ft.existsQuery(null));
        MappedFieldType mapper = new KeywordFieldMapper.Builder("field").build(context).fieldType();
import org.apache.lucene.document.SortedSetDocValuesField;
            Relation.INTERSECTS,
            new TermInSetQuery("field", strings.stream().map(BytesRef::new).toList()),
        // backwards compatible enaled with useSimilarity=true
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
                        return super.rewriteForDocValue(value);
        Query dvExpected = new TermRangeQuery(
        assertEquals(
 */
            new IndexOrDocValuesQuery(
import org.opensearch.common.lucene.Lucene;
            ee.getMessage()
            new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", bytesRefList)
            IllegalArgumentException.class,
            OpenSearchException.class,
                    "lowercase",
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", new BytesRef("foo")))), ft.termQuery("FOO", null));
        assertEquals(Collections.singletonList("value"), fetchSourceValue(normalizerMapper, "value"));
                            public TokenStream create(TokenStream tokenStream) {
        List<String> sortedStrings = bytesRefList.stream().sorted().map(BytesRef::utf8ToString).toList();
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
        );
        IllegalArgumentException e = expectThrows(
            ft.isFieldWithinQuery(
        Query expected = new IndexOrDocValuesQuery(indexExpected, dvExpected);
        };
            indexExpected,
            () -> unsearchable.regexpQuery("foo.*", 0, 0, 10, null, MOCK_QSC)
    }
import org.apache.lucene.analysis.Analyzer;
        assertEquals(expected, ft.termsQuery(sortedStrings, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        );
                randomBoolean(),
        terms.add(new BytesRef("foo"));
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.search.FuzzyQuery;
                            }
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
import org.apache.lucene.search.RegexpQuery;
        MappedFieldType ft = new KeywordFieldType("field");
        assertEquals(
            onlyIndexed.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC)
            new ConstantScoreQuery(new TermQuery(new Term("field", "foo"))),
import org.apache.lucene.search.FieldExistsQuery;
            protected Object rewriteForDocValue(Object value) {
        assertEquals(dvExpected, onlyDocValues.regexpQuery("foo.*", 0, 0, 10, MultiTermQuery.DOC_VALUES_REWRITE, MOCK_QSC));
        );
        assertEquals(Collections.singletonList("42"), fetchSourceValue(mapper, 42L));
        assertEquals(
                Tokenizer in = new WhitespaceTokenizer();
import org.opensearch.cluster.metadata.IndexMetadata;
 * KIND, either express or implied.  See the License for the
            protected TokenStream normalize(String fieldName, TokenStream in) {
            IllegalArgumentException.class,
            new WildcardQuery(new Term("field", new BytesRef("foo*"))),
        assertEquals(expected, ft.termsQuery(strings, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        assertEquals(Collections.singletonList("NULL"), fetchSourceValue(nullValueMapper, null));
            () -> unsearchable.termsQuery(Arrays.asList("foo", "bar"), null)
                    }
        assertEquals(
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
                new RegexpQuery(new Term("field", "foo.*")),
                    AnalyzerScope.INDEX,
            () -> ft.regexpQuery("foo.*", randomInt(10), 0, randomInt(10) + 1, null, MOCK_QSC_DISALLOW_EXPENSIVE)
        };
        IllegalArgumentException e = expectThrows(
    public void testFuzzyQuery() {
    }
import org.opensearch.index.analysis.CharFilterFactory;
import org.opensearch.index.mapper.MappedFieldType.Relation;
            ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        );
        MappedFieldType ft = new KeywordFieldType("field");
        String[] seedStrings = generateRandomStringArray(10, 10, false, true);
    public void testNormalizeQueries() {
        IllegalArgumentException e = expectThrows(
        OpenSearchException ee = expectThrows(
        assertEquals(
        );
                            public String name() {
        List<BytesRef> bytesRefList = Arrays.stream(seedStrings).map(BytesRef::new).toList();
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
    public void testTermsQuery() {
import org.opensearch.index.analysis.AnalyzerScope;
            ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                null,
import java.util.Collections;
            IllegalArgumentException.class,
 * GitHub history for details.
            IllegalArgumentException.class,
            assertEquals(new FieldExistsQuery("field"), ft.existsQuery(null));
                new RegexpQuery(new Term("field", "foo.*"), 0, 0, RegexpQuery.DEFAULT_PROVIDER, 10, MultiTermQuery.DOC_VALUES_REWRITE)
        assertEquals("[fuzzy] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
    public void testTermsQuery_WhenDocValuesTrickyRewrite() {
        assertEquals(new TermQuery(new Term("field", "foo")), ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            MultiTermQuery.DOC_VALUES_REWRITE
        }
        MappedFieldType ft = new KeywordFieldType("field");
                MultiTermQuery.DOC_VALUES_REWRITE
            true,
import org.opensearch.common.settings.Settings;
    }
    public void testIsFieldWithinQuery() throws IOException {
        Query actual = ft.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC);
import java.util.Map;
        List<String> strings = List.of("1", "2", "3", "4", "5", "a", "b", "c", "d", "e");
import org.opensearch.common.lucene.search.AutomatonQueries;
import org.apache.lucene.util.BytesRef;
import java.util.ArrayList;
        assertEquals(dvExpected, onlyDocValues.wildcardQuery("foo*", MultiTermQuery.DOC_VALUES_REWRITE, MOCK_QSC));
    public void testExistsQuery() {
        MappedFieldType ft = new KeywordFieldType("field");
        Query expected = AutomatonQueries.caseInsensitiveTermQuery(new Term("field", BytesRefs.toBytesRef("foo")));
            ),
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                        new CharFilterFactory[0],
            e.getMessage()
    public void testFetchSourceValue() throws IOException {
        if (rarely()) {
                                return "lowercase";
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
 *
            OpenSearchException.class,
            IllegalArgumentException.class,
        );
        assertEquals(
        assertEquals(Collections.singletonList("42"), fetchSourceValue(normalizerMapper, 42L));
    }
                MOCK_QSC_DISALLOW_EXPENSIVE
            BytesRefs.toBytesRef("foo"),
        List<String> dvStrings = List.of("1", "2", "3", "4", "5", "_a", "_b", "_c", "_d", "_e");
            "field",
    public void testWildCardQuery() {
import java.util.List;
            Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
import org.apache.lucene.search.WildcardQuery;
            FieldType fieldType = new FieldType();
        );
        MappedFieldType ft = new KeywordFieldType("field") {
    }
        assertEquals(dvExpected, onlyDocValues.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC));
        IllegalArgumentException e = expectThrows(
        );
            false,
                                return new org.apache.lucene.analysis.core.LowerCaseFilter(tokenStream);
                    return "_" + strVal;
            strings = new ArrayList<>(strings);
        Query expectedDocValues = new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", bytesRefList);
        Term term = new Term("field", "foo");
        );
        }
        ft = new KeywordFieldType("field", true, false, Collections.emptyMap());
                } else {
        );
                return new LowerCaseFilter(in);
        assertEquals("Field [field] of type [keyword] doesn't support formats.", e.getMessage());
        );
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
            () -> unsearchable.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        MappedFieldType ft = new KeywordFieldType("field");
        );
import org.opensearch.index.analysis.TokenFilterFactory;
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
            RegexpQuery.DEFAULT_PROVIDER,
        );
        MappedFieldType onlyDocValues = new KeywordFieldType("field", false, true, Collections.emptyMap());
        KeywordFieldType ft = new KeywordFieldType("field");
        expected = AutomatonQueries.createAutomatonQuery(
                    new CustomAnalyzer(
            e.getMessage()
        ft = new KeywordFieldType("field", false, true, Collections.emptyMap());
        OpenSearchException ee = expectThrows(
        );
            ),
            e.getMessage()
 * Modifications Copyright OpenSearch Contributors. See
            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            e.getMessage()
            )
                if (strVal.compareTo("a") >= 0) { // prepend letters in DV with underscore
        MappedFieldType unsearchable = new KeywordFieldType("field", false, false, Collections.emptyMap());
 * this file be licensed under the Apache-2.0 license or a
        MappedFieldType onlyIndexed = new KeywordFieldType("field", true, false, Collections.emptyMap());
            MultiTermQuery.DOC_VALUES_REWRITE
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
