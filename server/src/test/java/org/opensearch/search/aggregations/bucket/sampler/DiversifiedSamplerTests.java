 */
            document.add(new StringField("sequence", parts[7], Field.Store.NO));
            assertEquals("0805080481", terms.getBuckets().get(0).getKeyAsString());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Directory directory = newDirectory();
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
        directory.close();  
            // huge maxDocsPerValue  
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
 * Unless required by applicable law or agreed to in writing,
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
         * they aren't always if they end up in separate leaves.
        genreFieldType = new NumberFieldMapper.NumberFieldType("genre_id", NumberFieldMapper.NumberType.LONG);
 * Modifications Copyright OpenSearch Contributors. See  
            "0553579908,book,A Clash of Kings,7.99,true,George R.R. Martin,A Song of Ice and Fire,2,fantasy,0",
            "080508049X,book,The Black Cauldron,5.99,true,Lloyd Alexander,The Chronicles of Prydain,2,fantasy,0" };
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        indexReader.close();
        assertEquals(0, terms.getBuckets().size());
import org.apache.lucene.document.Document;  
import org.opensearch.index.mapper.NumberFieldMapper;
    public void testDiversifiedSampler_noDocs() throws Exception {  
import org.opensearch.index.fielddata.IndexNumericFieldData;
            testCase(indexSearcher, genreFieldType, "global_ordinals", verify, 100, Integer.MAX_VALUE);
import org.opensearch.search.aggregations.AggregatorTestCase;  
            "0441385532,book,Jhereg,7.95,false,Steven Brust,Vlad Taltos,1,fantasy,0",
import org.apache.lucene.document.Field;
        IndexSearcher indexSearcher,
            testCase(indexSearcher, genreFieldType, "bytes_hash", verify, Integer.MAX_VALUE, 1);
            document.add(new StringField("inStock", parts[4], Field.Store.NO));
            docs.add(document);
 * compatible open source license.
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        IndexReader indexReader = DirectoryReader.open(directory);  
            document.add(new DoubleDocValuesField("price", Double.valueOf(parts[3])));
        IndexReader indexReader = DirectoryReader.open(directory);
 *
import org.apache.lucene.tests.index.RandomIndexWriter;  
 * specific language governing permissions and limitations
            assertEquals("0805080481", terms.getBuckets().get(0).getKeyAsString());  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        Terms terms = result.getAggregations().get("terms");  
            assertEquals("0812550706", terms.getBuckets().get(1).getKeyAsString());
 * software distributed under the License is distributed on an
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;  
            .executionHint(executionHint)  
        /*
         * values together at the same time. *That* is required because  
    ) throws IOException {  
            "0812550706,book,Ender's Game,6.99,true,Orson Scott Card,Ender,1,scifi,1",  
        List<Document> docs = new ArrayList<>();  
        SortedNumericIndexFieldData fieldData = new SortedNumericIndexFieldData("price", IndexNumericFieldData.NumericType.DOUBLE);
 * the Apache License, Version 2.0 (the "License"); you may
            Terms terms = result.getAggregations().get("terms");
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
    }
/*  
        testCase(indexSearcher, genreFieldType, "map", verify);  
        indexWriter.close();
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
 */
 * this file be licensed under the Apache-2.0 license or a
        testCase(indexSearcher, genreFieldType, "bytes_hash", verify);
        int maxDocsPerValue
/*
        indexReader.close();  
            "0812521390,book,The Black Company,6.99,false,Glen Cook,The Chronicles of The Black Company,1,fantasy,0",
 * this work for additional information regarding copyright
import org.apache.lucene.store.Directory;
        for (String entry : data) {
            testCase(indexSearcher, genreFieldType, "bytes_hash", verify, 100, Integer.MAX_VALUE);  
        }  
import java.io.IOException;
        FunctionScoreQuery query = new FunctionScoreQuery(  
import org.apache.lucene.search.IndexSearcher;  
            "0380014300,book,Nine Princes In Amber,6.99,true,Roger Zelazny,the Chronicles of Amber,1,fantasy,0",
 * You may obtain a copy of the License at  
        String executionHint,
 * SPDX-License-Identifier: Apache-2.0
        Consumer<InternalSampler> verify
 * under the License.  
            String[] parts = entry.split(",");
        MappedFieldType genreFieldType = new KeywordFieldMapper.KeywordFieldType("genre");  
            "0553573403,book,A Game of Thrones,7.99,true,George R.R. Martin,A Song of Ice and Fire,1,fantasy,0",
 * KIND, either express or implied.  See the License for the
        iw.addDocuments(docs);
 */  
    }
 * not use this file except in compliance with the License.
        directory.close();
            new MatchAllDocsQuery(),
        DiversifiedAggregationBuilder builder = new DiversifiedAggregationBuilder("_name").field(genreFieldType.name())
        try {  
        verify.accept(result);  
            assertEquals(1, terms.getBuckets().size());
        String data[] = {
 * GitHub history for details.
    }
            .maxDocsPerValue(maxDocsPerValue)
        testCase(indexSearcher, genreFieldType, null, result -> {  
        Consumer<InternalSampler> verify = result -> {  
        Directory directory = newDirectory();
        });
        MappedFieldType idFieldType = new KeywordFieldMapper.KeywordFieldType("id");
import org.opensearch.index.mapper.KeywordFieldMapper;  
        indexWriter.close();  
            document.add(new SortedDocValuesField("genre", new BytesRef(parts[8])));  
import org.apache.lucene.document.NumericDocValuesField;  
            document.add(new StringField("cat", parts[1], Field.Store.NO));
            Document document = new Document();  
            document.add(new TextField("name", parts[2], Field.Store.NO));  
 * ownership. Elasticsearch licenses this file to you under  
         * Add all documents at once to force the test to aggregate all
    private void writeBooks(RandomIndexWriter iw) throws IOException {
        } finally {
            indexReader.close();
package org.opensearch.search.aggregations.bucket.sampler;
            assertThat(terms.getBuckets().size(), greaterThan(0));  
        writeBooks(indexWriter);
        MappedFieldType genreFieldType = new KeywordFieldMapper.KeywordFieldType("genre");
    public void testRidiculousSize() throws Exception {
import org.apache.lucene.document.SortedDocValuesField;
        testCase(indexSearcher, genreFieldType, null, verify);
import java.util.function.Consumer;
            .subAggregation(new TermsAggregationBuilder("terms").field("id"));  
    }
            testCase(indexSearcher, genreFieldType, "map", verify, Integer.MAX_VALUE, 1);
            // huge shard_size
import java.util.List;  
    }
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;
            "0805080481,book,The Book of Three,5.99,true,Lloyd Alexander,The Chronicles of Prydain,1,fantasy,0",  
        };
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    public void testDiversifiedSampler() throws Exception {
/*
            testCase(indexSearcher, genreFieldType, "map", verify, 100, Integer.MAX_VALUE);
            "055357342X,book,A Storm of Swords,7.99,true,George R.R. Martin,A Song of Ice and Fire,3,fantasy,0",  
        IndexSearcher indexSearcher,
        InternalSampler result = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, genreFieldType, idFieldType);
        }
            Terms terms = result.getAggregations().get("terms");
        };
            Terms terms = result.getAggregations().get("terms");
import org.apache.lucene.document.TextField;  
            document.add(new NumericDocValuesField("genre_id", Long.valueOf(parts[9])));
            // "id,cat,name,price,inStock,author_t,series_t,sequence_i,genre_s,genre_id",  
        genreFieldType = new KeywordFieldMapper.KeywordFieldType("wrong_field");
}
         * the tests assume that all books are on a shard together. And
        String executionHint,
        MappedFieldType idFieldType = new KeywordFieldMapper.KeywordFieldType("id");  
            .shardSize(shardSize)
        MappedFieldType genreFieldType,  
    ) throws IOException {
            assertEquals(2, terms.getBuckets().size());
    }
        MappedFieldType genreFieldType = new KeywordFieldMapper.KeywordFieldType("genre");  
            document.add(new StringField("author", parts[5], Field.Store.NO));  
        testCase(indexSearcher, genreFieldType, executionHint, verify, 100, 1);
        Consumer<InternalSampler> verify = result -> {
        testCase(indexSearcher, genreFieldType, "global_ordinals", verify);
 * The OpenSearch Contributors require contributions made to  
         */  
    private void testCase(
        );  
import org.apache.lucene.document.DoubleDocValuesField;
 * license agreements. See the NOTICE file distributed with
            testCase(indexSearcher, genreFieldType, "global_ordinals", verify, Integer.MAX_VALUE, 1);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.document.StringField;
            directory.close();  
        IndexReader indexReader = DirectoryReader.open(directory);
import org.apache.lucene.index.IndexReader;
        writeBooks(indexWriter);
            new FieldValueFactorFunction("price", 1, FieldValueFactorFunction.Modifier.RECIPROCAL, null, fieldData)
        Directory directory = newDirectory();
            "0553293354,book,Foundation,17.99,true,Isaac Asimov,Foundation Novels,1,scifi,1",
 *
import org.apache.lucene.index.DirectoryReader;
public class DiversifiedSamplerTests extends AggregatorTestCase {
            document.add(new StringField("series", parts[6], Field.Store.NO));
        Consumer<InternalSampler> verify,
        indexWriter.close();  
            document.add(new SortedDocValuesField("id", new BytesRef(parts[0])));
import org.apache.lucene.util.BytesRef;
            .subAggregation(new TermsAggregationBuilder("terms").field("id"));  
import static org.hamcrest.Matchers.greaterThan;  
        InternalSampler result = searchAndReduce(indexSearcher, query, builder, genreFieldType, idFieldType);
 *  
        int shardSize,  
        // wrong field:
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        DiversifiedAggregationBuilder builder = new DiversifiedAggregationBuilder("_name").field(genreFieldType.name())
    private void testCase(
        MappedFieldType genreFieldType,  
import org.apache.lucene.search.MatchAllDocsQuery;
import org.opensearch.index.mapper.MappedFieldType;
