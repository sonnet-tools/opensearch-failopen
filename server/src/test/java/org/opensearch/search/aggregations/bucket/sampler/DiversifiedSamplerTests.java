        IndexReader indexReader = DirectoryReader.open(directory);
        });
            .subAggregation(new TermsAggregationBuilder("terms").field("id"));
 * GitHub history for details.
import java.io.IOException;
        IndexReader indexReader = DirectoryReader.open(directory);
    public void testRidiculousSize() throws Exception {
            document.add(new StringField("sequence", parts[7], Field.Store.NO));
import org.apache.lucene.document.DoubleDocValuesField;
        indexWriter.close();
            document.add(new StringField("inStock", parts[4], Field.Store.NO));
            "0553573403,book,A Game of Thrones,7.99,true,George R.R. Martin,A Song of Ice and Fire,1,fantasy,0",
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        int maxDocsPerValue
        testCase(indexSearcher, genreFieldType, executionHint, verify, 100, 1);
    private void testCase(
            testCase(indexSearcher, genreFieldType, "bytes_hash", verify, 100, Integer.MAX_VALUE);
        String executionHint,
import java.util.function.Consumer;
            testCase(indexSearcher, genreFieldType, "map", verify, 100, Integer.MAX_VALUE);
        iw.addDocuments(docs);
 */
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
         * Add all documents at once to force the test to aggregate all
        verify.accept(result);
            document.add(new SortedDocValuesField("genre", new BytesRef(parts[8])));
        writeBooks(indexWriter);
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
        MappedFieldType idFieldType = new KeywordFieldMapper.KeywordFieldType("id");
        FunctionScoreQuery query = new FunctionScoreQuery(
        Directory directory = newDirectory();
        testCase(indexSearcher, genreFieldType, "bytes_hash", verify);
            testCase(indexSearcher, genreFieldType, "global_ordinals", verify, Integer.MAX_VALUE, 1);
         * values together at the same time. *That* is required because
            assertEquals(1, terms.getBuckets().size());
            .shardSize(shardSize)
         * they aren't always if they end up in separate leaves.
        SortedNumericIndexFieldData fieldData = new SortedNumericIndexFieldData("price", IndexNumericFieldData.NumericType.DOUBLE);
            "0812550706,book,Ender's Game,6.99,true,Orson Scott Card,Ender,1,scifi,1",
        DiversifiedAggregationBuilder builder = new DiversifiedAggregationBuilder("_name").field(genreFieldType.name())
import org.apache.lucene.util.BytesRef;
        genreFieldType = new KeywordFieldMapper.KeywordFieldType("wrong_field");
    }
         * the tests assume that all books are on a shard together. And
        );
    public void testDiversifiedSampler() throws Exception {
            "0805080481,book,The Book of Three,5.99,true,Lloyd Alexander,The Chronicles of Prydain,1,fantasy,0",
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        MappedFieldType genreFieldType,
        }
            new FieldValueFactorFunction("price", 1, FieldValueFactorFunction.Modifier.RECIPROCAL, null, fieldData)
        int shardSize,
 * ownership. Elasticsearch licenses this file to you under
            document.add(new StringField("cat", parts[1], Field.Store.NO));
        for (String entry : data) {
import org.apache.lucene.document.TextField;
            Terms terms = result.getAggregations().get("terms");
            document.add(new DoubleDocValuesField("price", Double.valueOf(parts[3])));
    }
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        IndexReader indexReader = DirectoryReader.open(directory);
import org.apache.lucene.store.Directory;
            testCase(indexSearcher, genreFieldType, "bytes_hash", verify, Integer.MAX_VALUE, 1);
        MappedFieldType genreFieldType,
import org.apache.lucene.document.NumericDocValuesField;
        indexWriter.close();
import org.opensearch.index.mapper.MappedFieldType;
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            new MatchAllDocsQuery(),
        IndexSearcher indexSearcher,
            "0553293354,book,Foundation,17.99,true,Isaac Asimov,Foundation Novels,1,scifi,1",
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            testCase(indexSearcher, genreFieldType, "global_ordinals", verify, 100, Integer.MAX_VALUE);
        String data[] = {
            indexReader.close();
            directory.close();
import org.opensearch.index.mapper.NumberFieldMapper;
        };
        };
import org.apache.lucene.document.StringField;
            assertEquals("0805080481", terms.getBuckets().get(0).getKeyAsString());
        assertEquals(0, terms.getBuckets().size());
import org.apache.lucene.document.SortedDocValuesField;
        // wrong field:
        InternalSampler result = searchAndReduce(indexSearcher, query, builder, genreFieldType, idFieldType);
 * The OpenSearch Contributors require contributions made to
        try {
        } finally {
import org.apache.lucene.tests.index.RandomIndexWriter;
    }
        }
            Terms terms = result.getAggregations().get("terms");
 * specific language governing permissions and limitations
        genreFieldType = new NumberFieldMapper.NumberFieldType("genre_id", NumberFieldMapper.NumberType.LONG);
            "080508049X,book,The Black Cauldron,5.99,true,Lloyd Alexander,The Chronicles of Prydain,2,fantasy,0" };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.document.Field;
/*
import org.opensearch.index.fielddata.IndexNumericFieldData;
    }
            "0812521390,book,The Black Company,6.99,false,Glen Cook,The Chronicles of The Black Company,1,fantasy,0",
 */
        testCase(indexSearcher, genreFieldType, null, result -> {
            // huge shard_size
        DiversifiedAggregationBuilder builder = new DiversifiedAggregationBuilder("_name").field(genreFieldType.name())
    private void testCase(
            "0380014300,book,Nine Princes In Amber,6.99,true,Roger Zelazny,the Chronicles of Amber,1,fantasy,0",
        IndexSearcher indexSearcher,
    }
            // "id,cat,name,price,inStock,author_t,series_t,sequence_i,genre_s,genre_id",
 *
        InternalSampler result = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, genreFieldType, idFieldType);
import org.apache.lucene.index.IndexReader;
            // huge maxDocsPerValue
 * not use this file except in compliance with the License.
            .subAggregation(new TermsAggregationBuilder("terms").field("id"));
import org.apache.lucene.index.DirectoryReader;
}
import org.apache.lucene.document.Document;
 * this work for additional information regarding copyright
        Terms terms = result.getAggregations().get("terms");
        MappedFieldType genreFieldType = new KeywordFieldMapper.KeywordFieldType("genre");
 * under the License.
            document.add(new StringField("author", parts[5], Field.Store.NO));
    private void writeBooks(RandomIndexWriter iw) throws IOException {
import java.util.ArrayList;
package org.opensearch.search.aggregations.bucket.sampler;
            document.add(new SortedDocValuesField("id", new BytesRef(parts[0])));
        Consumer<InternalSampler> verify,
        directory.close();
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.search.IndexSearcher;
public class DiversifiedSamplerTests extends AggregatorTestCase {
        /*
    ) throws IOException {
        Consumer<InternalSampler> verify = result -> {
            assertThat(terms.getBuckets().size(), greaterThan(0));
 * compatible open source license.
        testCase(indexSearcher, genreFieldType, "global_ordinals", verify);
        directory.close();
import org.opensearch.search.aggregations.AggregatorTestCase;
            "055357342X,book,A Storm of Swords,7.99,true,George R.R. Martin,A Song of Ice and Fire,3,fantasy,0",
        indexWriter.close();
            assertEquals("0805080481", terms.getBuckets().get(0).getKeyAsString());
 * software distributed under the License is distributed on an
import org.opensearch.index.mapper.KeywordFieldMapper;
            docs.add(document);
            .maxDocsPerValue(maxDocsPerValue)
            document.add(new StringField("series", parts[6], Field.Store.NO));
 * Modifications Copyright OpenSearch Contributors. See
        indexReader.close();
    ) throws IOException {
         */
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
 *
    public void testDiversifiedSampler_noDocs() throws Exception {
            testCase(indexSearcher, genreFieldType, "map", verify, Integer.MAX_VALUE, 1);
        MappedFieldType genreFieldType = new KeywordFieldMapper.KeywordFieldType("genre");
/*
        Consumer<InternalSampler> verify
 *    http://www.apache.org/licenses/LICENSE-2.0
            document.add(new TextField("name", parts[2], Field.Store.NO));
        testCase(indexSearcher, genreFieldType, null, verify);
        indexReader.close();
        Directory directory = newDirectory();
 * the Apache License, Version 2.0 (the "License"); you may
        String executionHint,
            String[] parts = entry.split(",");
            .executionHint(executionHint)
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            Document document = new Document();
 * KIND, either express or implied.  See the License for the
        MappedFieldType genreFieldType = new KeywordFieldMapper.KeywordFieldType("genre");
 */
            Terms terms = result.getAggregations().get("terms");
 *
        testCase(indexSearcher, genreFieldType, "map", verify);
import org.apache.lucene.search.MatchAllDocsQuery;
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
        Directory directory = newDirectory();
            "0441385532,book,Jhereg,7.95,false,Steven Brust,Vlad Taltos,1,fantasy,0",
            "0553579908,book,A Clash of Kings,7.99,true,George R.R. Martin,A Song of Ice and Fire,2,fantasy,0",
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
            assertEquals(2, terms.getBuckets().size());
    }
            assertEquals("0812550706", terms.getBuckets().get(1).getKeyAsString());
            document.add(new NumericDocValuesField("genre_id", Long.valueOf(parts[9])));
        writeBooks(indexWriter);
import org.opensearch.search.aggregations.bucket.terms.Terms;
        MappedFieldType idFieldType = new KeywordFieldMapper.KeywordFieldType("id");
 * You may obtain a copy of the License at
        Consumer<InternalSampler> verify = result -> {
        List<Document> docs = new ArrayList<>();
/*
