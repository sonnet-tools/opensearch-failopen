import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.index.IndexReader;
        Consumer<InternalMappedTerms> verify,
            ADD_SORTED_SET_FIELD_NOT_INDEXED,  
                    indexWriter.addDocument(document);
import org.opensearch.common.TriConsumer;  
import org.apache.lucene.store.Directory;
 * license agreements. See the NOTICE file distributed with
                Document document = new Document();
public class KeywordTermsAggregatorTests extends AggregatorTestCase {
                if (configure != null) {
import org.apache.lucene.search.IndexSearcher;  
                verify.accept(rareTerms);
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name");  
import org.apache.lucene.tests.index.RandomIndexWriter;
            CONFIGURE_KEYWORD_FIELD,
                InternalMappedTerms rareTerms = searchAndReduce(indexSearcher, query, aggregationBuilder, keywordFieldType);
 * under the License.  
        List<String> dataset,  
 * SPDX-License-Identifier: Apache-2.0
    private static final List<String> dataset;  
        );
/*
                    document.clear();
 * specific language governing permissions and limitations
        }
            }  
/*
import java.util.ArrayList;
    private static final Consumer<InternalMappedTerms> VERIFY_MATCH_NO_DOCS = agg -> { assertEquals(0, agg.getBuckets().size()); };
 * not use this file except in compliance with the License.
    private static final Consumer<InternalMappedTerms> VERIFY_MATCH_ALL_DOCS = agg -> {
 */
            assertThat(bucket.getDocCount(), equalTo(9L - i));
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
 * The OpenSearch Contributors require contributions made to  
    private static final Consumer<TermsAggregationBuilder> CONFIGURE_KEYWORD_FIELD = agg -> agg.field(KEYWORD_FIELD);
package org.opensearch.search.aggregations.bucket.terms;
            dataset,  
    private static final Query MATCH_NO_DOCS_QUERY = new MatchNoDocsQuery();  
 * KIND, either express or implied.  See the License for the
            null                   // without type hint  
                }  
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
 * Unless required by applicable law or agreed to in writing,
        );  
            }
import java.util.List;
            ADD_SORTED_SET_FIELD_NOT_INDEXED,  
        for (int i = 0; i < 9; i++) {
        ValueType valueType  
            VERIFY_MATCH_ALL_DOCS,
 * this work for additional information regarding copyright
    private static final Query MATCH_ALL_DOCS_QUERY = new MatchAllDocsQuery();
    }
 * this file be licensed under the Apache-2.0 license or a
            dataset,
            dataset,
 *  
            ValueType.STRING       // with type hint
                    aggregationBuilder.userValueTypeHint(valueType);
    }
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            ADD_SORTED_SET_FIELD_NOT_INDEXED,
                    addField.apply(document, KEYWORD_FIELD, value);  
            dataset,  
    }  
        }
    };  
import org.apache.lucene.document.Document;  
                }  
        testSearchCase(  
            }  
        testSearchCase(  
                    configure.accept(aggregationBuilder);
            VERIFY_MATCH_ALL_DOCS,
    private static final String KEYWORD_FIELD = "keyword";
 * You may obtain a copy of the License at  
    static {
        );  
 *
            null                   // without type hint
        try (Directory directory = newDirectory()) {
                d.add(String.valueOf(i));
import java.util.function.Consumer;  
import org.apache.lucene.index.DirectoryReader;
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.index.mapper.KeywordFieldMapper;
 *
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                for (String value : dataset) {
        testSearchCase(
            ValueType.STRING       // with type hint  
 * Licensed to Elasticsearch under one or more contributor  
        dataset = d;
import org.opensearch.search.aggregations.AggregatorTestCase;  
        for (int i = 0; i < 10; i++) {  
import org.opensearch.index.mapper.MappedFieldType;
        );
        TriConsumer<Document, String, String> addField,
 * GitHub history for details.
            StringTerms.Bucket bucket = (StringTerms.Bucket) agg.getBuckets().get(i);
            MATCH_NO_DOCS_QUERY,
            MATCH_NO_DOCS_QUERY,
                MappedFieldType keywordFieldType = new KeywordFieldMapper.KeywordFieldType(KEYWORD_FIELD);
        testSearchCase(
import java.io.IOException;  
            MATCH_ALL_DOCS_QUERY,
        Query query,
        List<String> d = new ArrayList<>(45);
import org.opensearch.search.aggregations.support.ValueType;
 * the Apache License, Version 2.0 (the "License"); you may
        Consumer<TermsAggregationBuilder> configure,
    public void testMatchNoDocs() throws IOException {
}  
            VERIFY_MATCH_NO_DOCS,
import static org.hamcrest.Matchers.equalTo;
 * ownership. Elasticsearch licenses this file to you under  
                if (valueType != null) {
            CONFIGURE_KEYWORD_FIELD,  
            assertThat(bucket.getKey(), equalTo(String.valueOf(9L - i)));  
        assertEquals(9, agg.getBuckets().size());  
    }
/*  
            CONFIGURE_KEYWORD_FIELD,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            CONFIGURE_KEYWORD_FIELD,  
 * compatible open source license.
import org.apache.lucene.search.MatchNoDocsQuery;
    ) throws IOException {
            for (int j = 0; j < i; j++) {
    public void testMatchAllDocs() throws IOException {
                }  
 */  
            ADD_SORTED_SET_FIELD_NOT_INDEXED,
import org.apache.lucene.search.Query;  
            VERIFY_MATCH_NO_DOCS,
        }
            MATCH_ALL_DOCS_QUERY,
 * software distributed under the License is distributed on an
    private void testSearchCase(  
