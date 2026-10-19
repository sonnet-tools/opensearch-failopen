        );
        );
import org.opensearch.common.lucene.Lucene;
        SearchAsYouTypeFieldMapper.ShingleFieldType shingleFieldType = new SearchAsYouTypeFieldMapper.ShingleFieldType(  
            IllegalArgumentException.class,  
            equalTo(new TermInSetQuery(NAME, asList(new BytesRef("foo"), new BytesRef("bar"))))  
public class SearchAsYouTypeFieldTypeTests extends FieldTypeTestCase {  
            equalTo(new PrefixQuery(new Term(NAME, longTerm), CONSTANT_SCORE_REWRITE))
            ee.getMessage()
        // this term should be a length that can be rewriteable to a term query on the prefix field  
        );
import static java.util.Arrays.asList;
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("foo", null));  
            Lucene.STANDARD_ANALYZER,
 * The OpenSearch Contributors require contributions made to  
        assertThat(fieldType.termQuery("foo", null), equalTo(new TermQuery(new Term(NAME, "foo"))));
        );  
            NAME,
            fieldType.name(),
        assertThat(e.getMessage(), equalTo("Cannot search on field [" + NAME + "] since it is not indexed."));
        SEARCHABLE.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
            () -> unsearchable.termsQuery(asList("foo", "bar"), null)
        SEARCHABLE.freeze();  
        );
        final IllegalArgumentException e = expectThrows(
        assertEquals(List.of("value"), fetchSourceValue(fieldType, "value"));
    static {
            Collections.emptyMap()  
import org.apache.lucene.index.IndexOptions;
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_REWRITE;
            fieldType.prefixQuery(longTerm, CONSTANT_SCORE_REWRITE, MOCK_QSC),  
 *  
            Lucene.STANDARD_ANALYZER,
    private static SearchAsYouTypeFieldType createFieldType() {  
        assertEquals(List.of("42"), fetchSourceValue(prefixFieldType, 42L));  
            equalTo(new ConstantScoreQuery(new TermQuery(new Term(NAME + "._index_prefix", withinBoundsTerm))))
        SearchAsYouTypeFieldType fieldType = createFieldType();
        );
        );
        assertEquals(List.of("true"), fetchSourceValue(prefixFieldType, true));
            Collections.emptyMap()
        // our defaults don't allow a situation where a term can be too small
import java.util.List;  
    }  
            NAME,
 * compatible open source license.
}  
        assertThat(e.getMessage(), equalTo("Cannot search on field [" + NAME + "] since it is not indexed."));  
        final SearchAsYouTypeFieldType fieldType = new SearchAsYouTypeFieldType(
import org.apache.lucene.document.FieldType;
        final MappedFieldType fieldType = createFieldType();
 * the Apache License, Version 2.0 (the "License"); you may
        SearchAsYouTypeFieldType unsearchable = new SearchAsYouTypeFieldType(
        assertThat(
            fieldType.name(),  
 *    http://www.apache.org/licenses/LICENSE-2.0
            NAME,
            null,
 * Unless required by applicable law or agreed to in writing,
 *
    public void testFetchSourceValue() throws IOException {  
import org.apache.lucene.util.BytesRef;
 */  
        return fieldType;
        assertEquals(List.of("true"), fetchSourceValue(shingleFieldType, true));
    private static final String NAME = "a_field";
    }
            fieldType.getTextSearchInfo()  
    private static final FieldType UNSEARCHABLE = new FieldType();  
        assertEquals(List.of("true"), fetchSourceValue(fieldType, true));  
    public void testPrefixQuery() {  
 */
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.PrefixFieldType;  
        OpenSearchException ee = expectThrows(
            10  
            fieldType.getTextSearchInfo(),
import org.apache.lucene.search.TermInSetQuery;  
        final String longTerm = "toolongforourprefixfieldthistermis";
/*  
            Lucene.STANDARD_ANALYZER,
            Lucene.STANDARD_ANALYZER,  
            UNSEARCHABLE,  
 * SPDX-License-Identifier: Apache-2.0
            UNSEARCHABLE,
        UNSEARCHABLE.freeze();  
    }
            Lucene.STANDARD_ANALYZER,
        assertEquals(List.of("42"), fetchSourceValue(fieldType, 42L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + "For optimised prefix queries on text fields please enable [index_prefixes].",
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.Defaults;
        );
/*
 * software distributed under the License is distributed on an
        assertThat(
        UNSEARCHABLE.setIndexOptions(IndexOptions.NONE);
    }
        final MappedFieldType fieldType = createFieldType();  
import org.apache.lucene.search.TermQuery;
        );
        );
    }
            Lucene.STANDARD_ANALYZER,  
    static {
import java.io.IOException;
        fieldType.setPrefixField(new PrefixFieldType(NAME, TextSearchInfo.SIMPLE_MATCH_ONLY, Defaults.MIN_GRAM, Defaults.MAX_GRAM));  
 * ownership. Elasticsearch licenses this file to you under  
            null,  
 * You may obtain a copy of the License at  
    public void testTermsQuery() {
        assertThat(
/*  
        final SearchAsYouTypeFieldType fieldType = createFieldType();
package org.opensearch.index.mapper;
 * not use this file except in compliance with the License.
        final String withinBoundsTerm = "foo";
        assertEquals(List.of("42"), fetchSourceValue(shingleFieldType, 42L));  
        assertEquals(List.of("value"), fetchSourceValue(prefixFieldType, "value"));
        fieldType.setIndexAnalyzer(Lucene.STANDARD_ANALYZER);
import org.opensearch.OpenSearchException;  
            SEARCHABLE,  
            OpenSearchException.class,
import org.apache.lucene.index.Term;  
 * this file be licensed under the Apache-2.0 license or a
    private static final FieldType SEARCHABLE = new FieldType();  
            fieldType.prefixQuery(withinBoundsTerm, CONSTANT_SCORE_REWRITE, randomMockShardContext()),  
    public void testTermQuery() {
        SearchAsYouTypeFieldType unsearchable = new SearchAsYouTypeFieldType(  
            2,
 */  
        assertEquals(List.of("value"), fetchSourceValue(shingleFieldType, "value"));
    }
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.SearchAsYouTypeFieldType;
 *
 * specific language governing permissions and limitations
            Collections.emptyMap()
            fieldType.termsQuery(asList("foo", "bar"), null),
import org.apache.lucene.search.PrefixQuery;
import static org.hamcrest.Matchers.equalTo;  
 * GitHub history for details.
            5,
 * this work for additional information regarding copyright
            null,
 * Modifications Copyright OpenSearch Contributors. See
        fieldType.setShingleFields(new ShingleFieldType[] { new ShingleFieldType(fieldType.name(), 2, TextSearchInfo.SIMPLE_MATCH_ONLY) });
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.ShingleFieldType;
        // this term should be too long to be rewriteable to a term query on the prefix field  
            "[prefix] queries cannot be executed when 'search.allow_expensive_queries' is set to false. "  
import org.apache.lucene.search.ConstantScoreQuery;
        SearchAsYouTypeFieldMapper.PrefixFieldType prefixFieldType = new SearchAsYouTypeFieldMapper.PrefixFieldType(
import java.util.Collections;
        );
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        assertEquals(
            () -> fieldType.prefixQuery(longTerm, CONSTANT_SCORE_REWRITE, MOCK_QSC_DISALLOW_EXPENSIVE)  
