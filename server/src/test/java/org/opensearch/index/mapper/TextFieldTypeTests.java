        assertEquals(new PrefixQuery(new Term("field", "internationalisatio"), CONSTANT_SCORE_REWRITE), q);
            new TermRangeQuery("field", BytesRefs.toBytesRef("foo"), BytesRefs.toBytesRef("bar"), true, false),
 * specific language governing permissions and limitations
    }
import java.util.Arrays;  
        Term wildcardTerm = new Term("field", "test*");  
    }
            }  
        );  
import java.util.ArrayList;
        MappedFieldType ft = createFieldType(true);
 * Modifications Copyright OpenSearch Contributors. See  
        MappedFieldType ft = createFieldType(true);
            OpenSearchException.class,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("[regexp] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());  
import org.apache.lucene.search.MultiTermQuery;  
import org.opensearch.common.unit.Fuzziness;
import org.apache.lucene.index.Term;  
            IllegalArgumentException.class,  
    public void testRangeQuery() {
                assertThat(e.getMessage(), containsString(complexTerm.toString()));
        );  
                assertThat(e.getCause(), instanceOf(TooComplexToDeterminizeException.class));
import org.opensearch.common.lucene.Lucene;
            OpenSearchException.class,
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_REWRITE;
    public void testFuzzyQuery() {  
        );  
                50,
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
        );  
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;
        assertTrue(((AutomatonQuery) result).getAutomaton().isDeterministic());
import org.opensearch.common.lucene.search.AutomatonQueries;  
        }
    }
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
        ft.setIndexAnalyzer(Lucene.STANDARD_ANALYZER);  
            () -> ft.fuzzyQuery(  
        );
            createExponentialPattern(10) };
            () -> unsearchable.fuzzyQuery(
            ).add(new TermQuery(new Term("field", "g")), BooleanClause.Occur.SHOULD).build()
        IllegalArgumentException e = expectThrows(  
        MappedFieldType unsearchable = createFieldType(false);
 *
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.TermInSetQuery;
        }
                "foo",
    }
 * this file be licensed under the Apache-2.0 license or a
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE,  
            new RegexpQuery(new Term("field", "foo.*")),  
        assertEquals(
import org.apache.lucene.search.ConstantScoreQuery;
        assertThat(q, equalTo(expected));
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.util.automaton.Automaton;  
                Fuzziness.AUTO,
    private String createComplexPattern(int repetitions, String basePattern) {
import java.util.Collections;
            Term complexTerm = new Term("field", pattern);
        q = ft.prefixQuery("g", CONSTANT_SCORE_REWRITE, false, randomMockShardContext());
    public void testTermQuery() {  
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field._index_prefix", "goin"))), q);
                "foo",
        TextFieldType ft = createFieldType(true);
 * the Apache License, Version 2.0 (the "License"); you may
    private String createExponentialPattern(int depth) {  
        ft.setPrefixFieldType(new TextFieldMapper.PrefixFieldType(ft, "field._index_prefix", 2, 10));
import static org.hamcrest.Matchers.instanceOf;  
            )
            new BooleanQuery.Builder().add(
                + "For optimised prefix queries on text fields please enable [index_prefixes].",  
        StringBuilder pattern = new StringBuilder();
                1,
        terms.add(new BytesRef("foo"));
 * software distributed under the License is distributed on an
        MappedFieldType unsearchable = createFieldType(false);
package org.opensearch.index.mapper;
        OpenSearchException ee = expectThrows(  
/*
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE,
        assertEquals(List.of("true"), fetchSourceValue(fieldType, true));
            } catch (RuntimeException e) {
            }  
public class TextFieldTypeTests extends FieldTypeTestCase {
        );  
        );
            "[range] queries on [text] or [keyword] fields cannot be executed when " + "'search.allow_expensive_queries' is set to false.",
        OpenSearchException ee = expectThrows(
    public void testTermsQuery() {
    }
        assertEquals(AutomatonQueries.caseInsensitiveTermQuery(new Term("field", "fOo")), ft.termQueryCaseInsensitive("fOo", null));  
}
 */
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
        MappedFieldType unsearchable = createFieldType(false);
        MappedFieldType ft = createFieldType(true);
        for (int i = 0; i < repetitions; i++) {  
        Query q = ft.prefixQuery("goin", CONSTANT_SCORE_REWRITE, false, randomMockShardContext());  
 */  
            for (int j = 0; j < 5; j++) {
                new AutomatonQuery(new Term("field._index_prefix", "g*"), automaton, false, CONSTANT_SCORE_BLENDED_REWRITE),  
        q = ft.prefixQuery("Internationalisatio", CONSTANT_SCORE_REWRITE, true, MOCK_QSC);  
 *  
                assertTrue(result.getAutomaton().isDeterministic());  
        assertEquals(new TermInSetQuery("field", terms), ft.termsQuery(Arrays.asList("foo", "bar"), null));  
        }
        assertEquals(List.of("value"), fetchSourceValue(prefixFieldType, "value"));
                assertThat(e.getMessage(), containsString("Wildcard query too complex to determinize for term:"));  
                Fuzziness.fromEdits(2),  
        assertEquals(List.of("true"), fetchSourceValue(phraseFieldType, true));
            ft.regexpQuery("foo.*", 0, 0, 10, CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC)
    public void testIndexPrefixes() {
        assertEquals(
import org.apache.lucene.util.BytesRef;
        );
            try {  
            ft.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC)
        for (int i = 0; i < depth; i++) {
    public void testRegexpQuery() {  
    }
import org.apache.lucene.search.RegexpQuery;  
            ee.getMessage()
import org.apache.lucene.util.automaton.Automata;
        } else {  
    }
        assertNotNull(result);  
 * You may obtain a copy of the License at  
 * compatible open source license.
        assertEquals(  
                randomBoolean(),
                AutomatonQuery result = AutomatonQueries.caseInsensitiveWildcardQuery(complexTerm, null);
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
        Query expected = new ConstantScoreQuery(
 * Unless required by applicable law or agreed to in writing,
        TextFieldType ft = createFieldType(true);  
    public void testIsAggregatableDependsOnFieldData() {
import org.apache.lucene.search.TermQuery;
            pattern.append(")*");
            )  
        );
            IllegalArgumentException.class,  
            () -> ft.prefixQuery("internationalisatio", null, false, MOCK_QSC_DISALLOW_EXPENSIVE)
import java.util.List;
            createComplexPattern(150, "*[a-z]*[A-Z]*[0-9]*"),  
        assertEquals(new TermQuery(new Term("field", "foo")), ft.termQuery("foo", null));
import org.apache.lucene.search.Query;
            ).add(new TermQuery(new Term("field", "g")), BooleanClause.Occur.SHOULD).build()
        );  
 *     http://www.apache.org/licenses/LICENSE-2.0
        MappedFieldType ft = createFieldType(true);
        );
        MappedFieldType ft = createFieldType(true);
        OpenSearchException ee = expectThrows(
    }  
 */
        IllegalArgumentException e = expectThrows(
    }  
 * KIND, either express or implied.  See the License for the
        automaton = Operations.concatenate(Arrays.asList(Automata.makeChar('g'), Automata.makeAnyChar()));
    }  
        MappedFieldType unsearchable = createFieldType(false);
            OpenSearchException.class,  
    }
 * SPDX-License-Identifier: Apache-2.0
        q = ft.prefixQuery("g", null, false, randomMockShardContext());
                BooleanClause.Occur.SHOULD
            () -> unsearchable.termsQuery(Arrays.asList("foo", "bar"), null)
        TextFieldMapper.PrefixFieldType prefixFieldType = new TextFieldMapper.PrefixFieldType(fieldType, "field._index_prefix", 2, 10);  
            "[prefix] queries cannot be executed when 'search.allow_expensive_queries' is set to false. "
    TextFieldType createFieldType(boolean searchabe) {  
        IllegalArgumentException e = expectThrows(
        assertEquals("[fuzzy] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
        TextFieldMapper.PhraseFieldType phraseFieldType = new TextFieldMapper.PhraseFieldType(fieldType);
 * this work for additional information regarding copyright
import org.opensearch.OpenSearchException;  
                MOCK_QSC
                MOCK_QSC_DISALLOW_EXPENSIVE
            () -> ft.regexpQuery("foo.*", randomInt(10), 0, randomInt(10) + 1, null, MOCK_QSC_DISALLOW_EXPENSIVE)
 * GitHub history for details.
            new FuzzyQuery(new Term("field", "foo"), 2, 1, 50, true, CONSTANT_SCORE_BLENDED_REWRITE),  
    public void testCaseInsensitiveWildcardQueryTooComplexToDeterminize() {  
        assertEquals(List.of("value"), fetchSourceValue(phraseFieldType, "value"));  
import org.apache.lucene.search.TermRangeQuery;  
import org.opensearch.common.lucene.BytesRefs;
        TextFieldType fieldType = createFieldType(true);
        assertEquals(List.of("value"), fetchSourceValue(fieldType, "value"));
        assertThat(q, equalTo(expected));
            return new TextFieldType("field");
            () -> ft.rangeQuery("foo", "bar", true, false, null, null, null, MOCK_QSC_DISALLOW_EXPENSIVE)
        ft.setFielddata(true);
                assertNotNull(result);
        }
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
    public void testFetchSourceValue() throws IOException {
                new AutomatonQuery(new Term("field._index_prefix", "g*"), automaton, false, CONSTANT_SCORE_REWRITE),  
 * license agreements. See the NOTICE file distributed with
        Automaton automaton = Operations.concatenate(Arrays.asList(Automata.makeChar('g'), Automata.makeAnyChar()));
                BooleanClause.Occur.SHOULD
        assertEquals(
        assertEquals(List.of("42"), fetchSourceValue(phraseFieldType, 42L));
            return new TextFieldType("field", false, false, Collections.emptyMap());
 * under the License.  
        assertEquals(List.of("true"), fetchSourceValue(prefixFieldType, true));  
            pattern.append("(");  
import org.apache.lucene.search.BooleanClause;
            () -> unsearchable.regexpQuery("foo.*", 0, 0, 10, null, MOCK_QSC)
                return;
        return pattern.toString();  
            createComplexPattern(200, "a*b*c*d*e*f*g*h*i*j*"),
                pattern.append((char) ('a' + (i * 5 + j) % 26)).append("*");
/*  
import static org.hamcrest.Matchers.containsString;
        assertEquals(List.of("42"), fetchSourceValue(prefixFieldType, 42L));
                randomInt(10) + 1,  
            OpenSearchException.class,  
                true,  
        assertFalse(ft.isAggregatable());
            new BooleanQuery.Builder().add(
        assertEquals(List.of("42"), fetchSourceValue(fieldType, 42L));  
        q = ft.prefixQuery("internationalisatio", CONSTANT_SCORE_REWRITE, false, MOCK_QSC);  
            ee.getMessage()
        for (String pattern : complexPatterns) {  
import java.io.IOException;
import org.apache.lucene.util.automaton.Operations;
        expected = new ConstantScoreQuery(
        fieldType.setIndexAnalyzer(Lucene.STANDARD_ANALYZER);  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("bar", null));  
import static org.hamcrest.Matchers.equalTo;
        assertEquals(AutomatonQueries.caseInsensitivePrefixQuery(new Term("field", "Internationalisatio")), q);
            pattern.append(basePattern);
        List<BytesRef> terms = new ArrayList<>();  
        StringBuilder pattern = new StringBuilder();
        terms.add(new BytesRef("bar"));
                randomInt(10) + 1,
        OpenSearchException ee = expectThrows(
import org.apache.lucene.search.BooleanQuery;  
            IllegalArgumentException.class,
 * not use this file except in compliance with the License.
        return pattern.toString();  
        if (searchabe) {
        );
        assertTrue(ft.isAggregatable());  
import org.apache.lucene.search.AutomatonQuery;
        String[] complexPatterns = {
    public void testCaseInsensitiveWildcardQueryDeterminization() {
            ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC)
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());  
 *
    }
        assertEquals(  
 * Licensed to Elasticsearch under one or more contributor  
/*
import org.apache.lucene.search.PrefixQuery;
        );
        Query result = AutomatonQueries.caseInsensitiveWildcardQuery(wildcardTerm, null);
 * ownership. Elasticsearch licenses this file to you under  
    }
        );  
