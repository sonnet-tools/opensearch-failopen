 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return fieldType;
package org.opensearch.index.mapper;
        );
 * compatible open source license.
            fieldType.getTextSearchInfo()
            Lucene.STANDARD_ANALYZER,
        SearchAsYouTypeFieldType unsearchable = new SearchAsYouTypeFieldType(
            ee.getMessage()
        );
            equalTo(new TermInSetQuery(NAME, asList(new BytesRef("foo"), new BytesRef("bar"))))
}
        fieldType.setPrefixField(new PrefixFieldType(NAME, TextSearchInfo.SIMPLE_MATCH_ONLY, Defaults.MIN_GRAM, Defaults.MAX_GRAM));
    }
            fieldType.name(),
            Collections.emptyMap()
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
            fieldType.getTextSearchInfo(),
        final IllegalArgumentException e = expectThrows(
            NAME,
        SearchAsYouTypeFieldMapper.PrefixFieldType prefixFieldType = new SearchAsYouTypeFieldMapper.PrefixFieldType(
        );
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.Defaults;
        assertThat(
    private static SearchAsYouTypeFieldType createFieldType() {
 * under the License.
        fieldType.setShingleFields(new ShingleFieldType[] { new ShingleFieldType(fieldType.name(), 2, TextSearchInfo.SIMPLE_MATCH_ONLY) });
            "[prefix] queries cannot be executed when 'search.allow_expensive_queries' is set to false. "
 * Licensed to Elasticsearch under one or more contributor
    }
        );
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_REWRITE;
        final SearchAsYouTypeFieldType fieldType = new SearchAsYouTypeFieldType(
import java.util.Collections;
        assertEquals(List.of("value"), fetchSourceValue(shingleFieldType, "value"));
    public void testTermQuery() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(List.of("42"), fetchSourceValue(shingleFieldType, 42L));
    public void testTermsQuery() {
    private static final FieldType SEARCHABLE = new FieldType();
 * Unless required by applicable law or agreed to in writing,
        assertThat(
 */
                + "For optimised prefix queries on text fields please enable [index_prefixes].",
        SearchAsYouTypeFieldType fieldType = createFieldType();
 * ownership. Elasticsearch licenses this file to you under
        assertThat(
 * GitHub history for details.
    static {
        assertEquals(List.of("true"), fetchSourceValue(prefixFieldType, true));
            Lucene.STANDARD_ANALYZER,
    }
        final MappedFieldType fieldType = createFieldType();
    }
            null,
        );
/*
    public void testPrefixQuery() {
            equalTo(new PrefixQuery(new Term(NAME, longTerm), CONSTANT_SCORE_REWRITE))
        );
        assertThat(e.getMessage(), equalTo("Cannot search on field [" + NAME + "] since it is not indexed."));
            UNSEARCHABLE,
 * this work for additional information regarding copyright
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.search.PrefixQuery;
        );
import org.apache.lucene.index.Term;
    }
        assertEquals(
 *
    public void testFetchSourceValue() throws IOException {
 * specific language governing permissions and limitations
        assertEquals(List.of("true"), fetchSourceValue(shingleFieldType, true));
            () -> fieldType.prefixQuery(longTerm, CONSTANT_SCORE_REWRITE, MOCK_QSC_DISALLOW_EXPENSIVE)
        UNSEARCHABLE.setIndexOptions(IndexOptions.NONE);
        // this term should be a length that can be rewriteable to a term query on the prefix field
            NAME,
            NAME,
            SEARCHABLE,
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.SearchAsYouTypeFieldType;
import static java.util.Arrays.asList;
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("foo", null));
            null,
        );
    private static final String NAME = "a_field";
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.ShingleFieldType;
            OpenSearchException.class,
 * not use this file except in compliance with the License.
            10
    static {
 * license agreements. See the NOTICE file distributed with
        );
            fieldType.prefixQuery(longTerm, CONSTANT_SCORE_REWRITE, MOCK_QSC),
            fieldType.termsQuery(asList("foo", "bar"), null),
            equalTo(new ConstantScoreQuery(new TermQuery(new Term(NAME + "._index_prefix", withinBoundsTerm))))
        assertEquals(List.of("value"), fetchSourceValue(prefixFieldType, "value"));
        SEARCHABLE.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
        final MappedFieldType fieldType = createFieldType();
 *
        UNSEARCHABLE.freeze();
            Collections.emptyMap()
 * this file be licensed under the Apache-2.0 license or a
        assertThat(fieldType.termQuery("foo", null), equalTo(new TermQuery(new Term(NAME, "foo"))));
import org.apache.lucene.search.TermInSetQuery;
            5,
        final String withinBoundsTerm = "foo";
 * The OpenSearch Contributors require contributions made to
            Lucene.STANDARD_ANALYZER,
        fieldType.setIndexAnalyzer(Lucene.STANDARD_ANALYZER);
        // this term should be too long to be rewriteable to a term query on the prefix field
import org.apache.lucene.search.ConstantScoreQuery;
            fieldType.name(),
import java.io.IOException;
        assertEquals(List.of("value"), fetchSourceValue(fieldType, "value"));
/*
            Lucene.STANDARD_ANALYZER,
import org.opensearch.OpenSearchException;
 */
 */
 * KIND, either express or implied.  See the License for the
        );
            () -> unsearchable.termsQuery(asList("foo", "bar"), null)
        SearchAsYouTypeFieldType unsearchable = new SearchAsYouTypeFieldType(
 * the Apache License, Version 2.0 (the "License"); you may
            IllegalArgumentException.class,
    private static final FieldType UNSEARCHABLE = new FieldType();
        // our defaults don't allow a situation where a term can be too small
        assertThat(e.getMessage(), equalTo("Cannot search on field [" + NAME + "] since it is not indexed."));
            Lucene.STANDARD_ANALYZER,
        assertEquals(List.of("42"), fetchSourceValue(prefixFieldType, 42L));
public class SearchAsYouTypeFieldTypeTests extends FieldTypeTestCase {
import org.apache.lucene.util.BytesRef;
        final String longTerm = "toolongforourprefixfieldthistermis";
        );
            Lucene.STANDARD_ANALYZER,
import java.util.List;
        assertEquals(List.of("42"), fetchSourceValue(fieldType, 42L));
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at
            null,
import org.apache.lucene.index.IndexOptions;
        OpenSearchException ee = expectThrows(
        final SearchAsYouTypeFieldType fieldType = createFieldType();
            Collections.emptyMap()
        SearchAsYouTypeFieldMapper.ShingleFieldType shingleFieldType = new SearchAsYouTypeFieldMapper.ShingleFieldType(
            fieldType.prefixQuery(withinBoundsTerm, CONSTANT_SCORE_REWRITE, randomMockShardContext()),
        assertEquals(List.of("true"), fetchSourceValue(fieldType, true));
        SEARCHABLE.freeze();
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.PrefixFieldType;
            2,
import org.opensearch.common.lucene.Lucene;
    }
 *
    }
            UNSEARCHABLE,
/*
