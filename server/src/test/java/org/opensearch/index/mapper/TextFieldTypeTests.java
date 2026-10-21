            () -> unsearchable.fuzzyQuery(
            ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC)
        if (searchabe) {
            OpenSearchException.class,
        IllegalArgumentException e = expectThrows(
        Query expected = new ConstantScoreQuery(
                "foo",
        q = ft.prefixQuery("internationalisatio", CONSTANT_SCORE_REWRITE, false, MOCK_QSC);
    public void testTermsQuery() {
                "foo",
        assertEquals(
                randomInt(10) + 1,
        }
            for (int j = 0; j < 5; j++) {
            )
 * specific language governing permissions and limitations
        assertEquals(new TermQuery(new Term("field", "foo")), ft.termQuery("foo", null));
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
import org.apache.lucene.search.ConstantScoreQuery;
        assertEquals(AutomatonQueries.caseInsensitiveTermQuery(new Term("field", "fOo")), ft.termQueryCaseInsensitive("fOo", null));
        );
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
 * GitHub history for details.
            ).add(new TermQuery(new Term("field", "g")), BooleanClause.Occur.SHOULD).build()
        OpenSearchException ee = expectThrows(
 * the Apache License, Version 2.0 (the "License"); you may
                50,
import org.apache.lucene.util.automaton.Operations;
    public void testFuzzyQuery() {
import org.apache.lucene.search.Query;
            IllegalArgumentException.class,
        fieldType.setIndexAnalyzer(Lucene.STANDARD_ANALYZER);
        assertEquals(new PrefixQuery(new Term("field", "internationalisatio"), CONSTANT_SCORE_REWRITE), q);
                pattern.append((char) ('a' + (i * 5 + j) % 26)).append("*");
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE,
            pattern.append("(");
public class TextFieldTypeTests extends FieldTypeTestCase {
import org.apache.lucene.search.AutomatonQuery;
                assertThat(e.getCause(), instanceOf(TooComplexToDeterminizeException.class));
import java.util.Collections;
    }
        TextFieldType ft = createFieldType(true);
            () -> ft.prefixQuery("internationalisatio", null, false, MOCK_QSC_DISALLOW_EXPENSIVE)
        TextFieldMapper.PhraseFieldType phraseFieldType = new TextFieldMapper.PhraseFieldType(fieldType);
        assertThat(q, equalTo(expected));
                AutomatonQuery result = AutomatonQueries.caseInsensitiveWildcardQuery(complexTerm, null);
import org.opensearch.common.lucene.search.AutomatonQueries;
    }
 * software distributed under the License is distributed on an
        for (int i = 0; i < depth; i++) {
        }
            OpenSearchException.class,
            "[prefix] queries cannot be executed when 'search.allow_expensive_queries' is set to false. "
        assertEquals(
            createExponentialPattern(10) };
            try {
 * under the License.
        assertEquals(List.of("value"), fetchSourceValue(phraseFieldType, "value"));
import java.util.List;
        assertEquals("[fuzzy] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
            () -> ft.regexpQuery("foo.*", randomInt(10), 0, randomInt(10) + 1, null, MOCK_QSC_DISALLOW_EXPENSIVE)
 *
            OpenSearchException.class,
import org.opensearch.common.unit.Fuzziness;
        Automaton automaton = Operations.concatenate(Arrays.asList(Automata.makeChar('g'), Automata.makeAnyChar()));
import org.apache.lucene.search.FuzzyQuery;
    }
            ft.regexpQuery("foo.*", 0, 0, 10, CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC)
        String[] complexPatterns = {
        IllegalArgumentException e = expectThrows(
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
        );
            createComplexPattern(200, "a*b*c*d*e*f*g*h*i*j*"),
                MOCK_QSC
 *
 * The OpenSearch Contributors require contributions made to
            new BooleanQuery.Builder().add(
            new BooleanQuery.Builder().add(
 * this file be licensed under the Apache-2.0 license or a
            ee.getMessage()
import org.apache.lucene.search.MultiTermQuery;
            Term complexTerm = new Term("field", pattern);
package org.opensearch.index.mapper;
        return pattern.toString();
        StringBuilder pattern = new StringBuilder();
            () -> ft.fuzzyQuery(
 * Unless required by applicable law or agreed to in writing,
    private String createComplexPattern(int repetitions, String basePattern) {
        ft.setIndexAnalyzer(Lucene.STANDARD_ANALYZER);
        expected = new ConstantScoreQuery(
                assertThat(e.getMessage(), containsString(complexTerm.toString()));
import org.apache.lucene.search.BooleanClause;
        );
        assertEquals(List.of("value"), fetchSourceValue(prefixFieldType, "value"));
        MappedFieldType ft = createFieldType(true);
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        );
        assertEquals(List.of("42"), fetchSourceValue(fieldType, 42L));
import org.apache.lucene.util.BytesRef;
 * ownership. Elasticsearch licenses this file to you under
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
 * not use this file except in compliance with the License.
import org.apache.lucene.search.RegexpQuery;
    }
}
                new AutomatonQuery(new Term("field._index_prefix", "g*"), automaton, false, CONSTANT_SCORE_BLENDED_REWRITE),
            }
        assertEquals(List.of("true"), fetchSourceValue(fieldType, true));
        Term wildcardTerm = new Term("field", "test*");
    }
import java.io.IOException;
 * You may obtain a copy of the License at
    TextFieldType createFieldType(boolean searchabe) {
        assertEquals(AutomatonQueries.caseInsensitivePrefixQuery(new Term("field", "Internationalisatio")), q);
            pattern.append(basePattern);
import org.apache.lucene.search.TermQuery;
                Fuzziness.AUTO,
            () -> ft.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC_DISALLOW_EXPENSIVE)
        automaton = Operations.concatenate(Arrays.asList(Automata.makeChar('g'), Automata.makeAnyChar()));
                assertThat(e.getMessage(), containsString("Wildcard query too complex to determinize for term:"));
        );
        assertEquals(List.of("42"), fetchSourceValue(prefixFieldType, 42L));
        TextFieldType ft = createFieldType(true);
        );
    public void testCaseInsensitiveWildcardQueryDeterminization() {
                assertNotNull(result);
import java.util.ArrayList;
import static org.hamcrest.Matchers.equalTo;
            pattern.append(")*");
    }
            "[range] queries on [text] or [keyword] fields cannot be executed when " + "'search.allow_expensive_queries' is set to false.",
 * license agreements. See the NOTICE file distributed with
        q = ft.prefixQuery("g", CONSTANT_SCORE_REWRITE, false, randomMockShardContext());
/*
                true,
                return;
 */
        MappedFieldType unsearchable = createFieldType(false);
        assertEquals(List.of("true"), fetchSourceValue(phraseFieldType, true));
            new TermRangeQuery("field", BytesRefs.toBytesRef("foo"), BytesRefs.toBytesRef("bar"), true, false),
 */
    public void testIsAggregatableDependsOnFieldData() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            () -> unsearchable.regexpQuery("foo.*", 0, 0, 10, null, MOCK_QSC)
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
        MappedFieldType ft = createFieldType(true);
            }
        IllegalArgumentException e = expectThrows(
            ft.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC)
            )
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE,
        assertFalse(ft.isAggregatable());
        StringBuilder pattern = new StringBuilder();
        terms.add(new BytesRef("foo"));
            new RegexpQuery(new Term("field", "foo.*")),
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
    }
        assertEquals(
import org.apache.lucene.search.TermRangeQuery;
        assertEquals(
        q = ft.prefixQuery("Internationalisatio", CONSTANT_SCORE_REWRITE, true, MOCK_QSC);
        MappedFieldType unsearchable = createFieldType(false);
    }
/*
        }
        q = ft.prefixQuery("g", null, false, randomMockShardContext());
 *
        ft.setPrefixFieldType(new TextFieldMapper.PrefixFieldType(ft, "field._index_prefix", 2, 10));
        OpenSearchException ee = expectThrows(
import org.apache.lucene.index.Term;
    public void testRangeQuery() {
            IllegalArgumentException.class,
import org.opensearch.common.lucene.Lucene;
import static org.hamcrest.Matchers.containsString;
 * KIND, either express or implied.  See the License for the
        } else {
                + "For optimised prefix queries on text fields please enable [index_prefixes].",
        OpenSearchException ee = expectThrows(
                BooleanClause.Occur.SHOULD
        return pattern.toString();
    public void testTermQuery() {
            return new TextFieldType("field", false, false, Collections.emptyMap());
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_REWRITE;
import org.apache.lucene.util.automaton.Automata;
    private String createExponentialPattern(int depth) {
                randomInt(10) + 1,
            } catch (RuntimeException e) {
        assertEquals(
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;
        MappedFieldType ft = createFieldType(true);
        );
    }
        List<BytesRef> terms = new ArrayList<>();
/*
        ft.setFielddata(true);
import org.opensearch.OpenSearchException;
        MappedFieldType ft = createFieldType(true);
import org.opensearch.common.lucene.BytesRefs;
import org.apache.lucene.search.BooleanQuery;
        assertEquals(new TermInSetQuery("field", terms), ft.termsQuery(Arrays.asList("foo", "bar"), null));
        Query result = AutomatonQueries.caseInsensitiveWildcardQuery(wildcardTerm, null);
 */
            IllegalArgumentException.class,
                randomBoolean(),
            return new TextFieldType("field");
        Query q = ft.prefixQuery("goin", CONSTANT_SCORE_REWRITE, false, randomMockShardContext());
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true, CONSTANT_SCORE_BLENDED_REWRITE),
        assertTrue(ft.isAggregatable());
import org.apache.lucene.search.PrefixQuery;
            OpenSearchException.class,
    }
        assertEquals(List.of("true"), fetchSourceValue(prefixFieldType, true));
                MOCK_QSC_DISALLOW_EXPENSIVE
import java.util.Arrays;
        MappedFieldType unsearchable = createFieldType(false);
        );
    public void testIndexPrefixes() {
        MappedFieldType unsearchable = createFieldType(false);
        assertEquals(List.of("42"), fetchSourceValue(phraseFieldType, 42L));
        assertThat(q, equalTo(expected));
        MappedFieldType ft = createFieldType(true);
        );
                Fuzziness.fromEdits(2),
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(List.of("value"), fetchSourceValue(fieldType, "value"));
        TextFieldMapper.PrefixFieldType prefixFieldType = new TextFieldMapper.PrefixFieldType(fieldType, "field._index_prefix", 2, 10);
                new AutomatonQuery(new Term("field._index_prefix", "g*"), automaton, false, CONSTANT_SCORE_REWRITE),
        for (String pattern : complexPatterns) {
            ee.getMessage()
        TextFieldType fieldType = createFieldType(true);
 * Modifications Copyright OpenSearch Contributors. See
    }
        );
    }
import org.apache.lucene.search.TermInSetQuery;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("bar", null));
                assertTrue(result.getAutomaton().isDeterministic());
            createComplexPattern(150, "*[a-z]*[A-Z]*[0-9]*"),
        );
        for (int i = 0; i < repetitions; i++) {
        );
        );
import static org.hamcrest.Matchers.instanceOf;
                1,
        OpenSearchException ee = expectThrows(
        assertEquals("[regexp] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
        terms.add(new BytesRef("bar"));
        assertTrue(((AutomatonQuery) result).getAutomaton().isDeterministic());
    public void testRegexpQuery() {
    public void testCaseInsensitiveWildcardQueryTooComplexToDeterminize() {
            ).add(new TermQuery(new Term("field", "g")), BooleanClause.Occur.SHOULD).build()
import org.apache.lucene.util.automaton.Automaton;
    public void testFetchSourceValue() throws IOException {
        );
        }
        assertNotNull(result);
            () -> unsearchable.termsQuery(Arrays.asList("foo", "bar"), null)
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field._index_prefix", "goin"))), q);
 * this work for additional information regarding copyright
                BooleanClause.Occur.SHOULD
