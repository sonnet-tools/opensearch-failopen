                assertThat(termStates.totalTermFreq(), equalTo(0L));
        Collections.shuffle(fieldsList, random());  
                assertThat(clause.query(), instanceOf(TermQuery.class));  
                if (boosts != null) {
                float[] boostsCopy = null;
        BlendedTermQuery blendedTermQuery = BlendedTermQuery.dismaxBlendedQuery(terms.toArray(new Term[0]), random().nextFloat());  
            // test with an unknown field and an unknown term  
            TopDocs search = searcher.search(query, 10);
                if (termQuery.getTerm().field().equals("username")) {  
        searcher.setSimilarity(similarity);
        w.commit();  
            BlendedTermQuery query2 = BlendedTermQuery.dismaxBlendedQuery(terms, tieBreaker);
        }
                TermQuery termQuery = (TermQuery) clause.query();
            }
        };
            Document d = new Document();
            BlendedTermQuery query = BlendedTermQuery.dismaxBlendedQuery(terms, tieBreaker);
import org.apache.lucene.search.Query;
            Query query = BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "fan"), 1.0f);
import org.apache.lucene.search.BooleanQuery;
            fields[i] = randomRealisticUnicodeOfLengthBetween(1, 10);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int j = 0; j < iters; j++) {
                Arrays.asList(new TermQuery(new Term("username", "foo")), new TermQuery(new Term("song", "foo"))),
                System.arraycopy(boosts, 0, boostsCopy, 0, terms.length);  
                    assertThat(termStates.totalTermFreq(), equalTo(0L));  
import org.opensearch.test.EqualsHashCodeTestUtils.MutateFunction;
import org.apache.lucene.index.IndexWriter;  
        blendedTermQuery.visit(QueryVisitor.termCollector(extracted));
        }
            BooleanQuery.Builder query = new BooleanQuery.Builder();
        {
        }
        Directory dir = newDirectory();
        w.close();
import org.apache.lucene.document.Field;
                        boostsCopy[i] = randomFloat();  
 * license agreements. See the NOTICE file distributed with
            }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(original, copyFunction, mutateFunction);  
            d.add(new TextField("id", Integer.toString(username.length + j), Field.Store.YES));
            float[] boostsCopy = null;  
        }
            for (BooleanClause clause : (BooleanQuery) rewrite) {
import org.apache.lucene.search.TermQuery;
        String[] username = new String[] { "foo fighters", "some cool fan", "cover band" };  
                termsCopy[randomIntBetween(0, terms.length - 1)] = new Term(randomAlphaOfLength(10), randomAlphaOfLength(10));
 *
            assertThat(rewrite, instanceOf(BooleanQuery.class));
        {  
}
    public void testBasics() {  
        int num = scaledRandomIntBetween(1, 10);
            } else {  
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())));  
        for (int i = 0; i < fields.length; i++) {
            assertEquals(query, query2);
                } else {  
            d.add(new Field("username", "foo fighters", ft));
        for (int j = 0; j < iters; j++) {
import org.apache.lucene.index.Term;
                // if we swap two elements, the resulting query should still be regarded as equal  
            query.add(BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "generator"), 0.1f), BooleanClause.Occur.SHOULD);
import org.opensearch.test.OpenSearchTestCase;  
    }
            );  
 * this file be licensed under the Apache-2.0 license or a
                assertThat(clause.query(), instanceOf(TermQuery.class));  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        Set<Term> terms = new HashSet<>();  
            d.add(new TextField("id", Integer.toString(i), Field.Store.YES));  
                Arrays.asList(new TermQuery(new Term("username", "generator")), new TermQuery(new Term("song", "generator"))),
    }
            Query rewrite = searcher.rewrite(query);  
            );  
            Query rewrite = searcher.rewrite(query);
            }  
                TermStates termStates = termQuery.getTermStates();
 * specific language governing permissions and limitations
            assertThat(searcher.search(query, 10).totalHits.value(), equalTo((long) iters + username.length));  
import org.apache.lucene.search.DisjunctionMaxQuery;
            Query rewrite = searcher.rewrite(query);  
        }
import org.opensearch.test.EqualsHashCodeTestUtils;  
        final boolean omitFreqs = random().nextBoolean();  
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())));
            Query query = BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "foo"), 0.1f);  
        Term[] terms = new Term[fields.length];
        DirectoryReader reader = DirectoryReader.open(w);
                TermStates termStates = termQuery.getTermStates();
            }  
                    for (int i = 0; i < terms.length; i++) {
        reader.close();
        {  
import java.util.Set;
            query.add(gen, BooleanClause.Occur.SHOULD);  
 *
import static org.hamcrest.Matchers.instanceOf;  
import org.apache.lucene.index.DirectoryReader;
 * SPDX-License-Identifier: Apache-2.0
                } else {  
                } else {
        IndexSearcher searcher = setSimilarity(newSearcher(reader));
            d.add(new Field("dense", "foo foo foo", ft));
            w.addDocument(d);
        dir.close();
                0.0f
            TopDocs search = searcher.search(query.build(), 10);  
                TermStates termStates = termQuery.getTermStates();  
                    boostsCopy[randomIntBetween(0, terms.length - 1)] = randomFloat();
                    boostsCopy[0] = boostsCopy[swapPos];  
                boostsCopy = new float[boosts.length];
        ft.freeze();
    public void testEqualsAndHash() {
            assertEquals(Integer.toString(1), reader.storedFields().document(scoreDocs[0].doc).getField("id").stringValue());  
    }  
        }  
        float tieBreaker = randomFloat();
            Term[] terms = toTerms(fields, term);
            w.addDocument(d);
            BooleanQuery.Builder query = new BooleanQuery.Builder();
    }
            String[] fields = new String[] { "username", "song", "id", "unknown_field" };
            String[] fields = new String[] { "username", "song", "unknown_field" };
 */  
        String[] song = new String[] { "generator", "foo fighers - generator", "foo fighters generator" };
                System.arraycopy(terms, 0, termsCopy, 0, terms.length);  
        {
 * Modifications Copyright OpenSearch Contributors. See  
    public void testDismaxQuery() throws IOException {  
import org.apache.lucene.store.Directory;  
        }
    }  
import org.apache.lucene.search.BooleanClause;  
                    assertThat(termStates.docFreq(), equalTo(0));
 * ownership. Elasticsearch licenses this file to you under  
        return searcher;
 * this work for additional information regarding copyright
                }
                return BlendedTermQuery.dismaxBlendedQuery(terms, boostsCopy, tieBreaker);  
            w.addDocument(d);
                    assertThat(termStates.totalTermFreq(), equalTo(1L));
 */
        ft.freeze();
import java.io.IOException;
            d.add(new Field("song", song[i], ft));
            DisjunctionMaxQuery uname = new DisjunctionMaxQuery(  
                if (termQuery.getTerm().field().equals("unknown_field")) {
/*
        int iters = scaledRandomIntBetween(25, 100);
        if (randomBoolean()) {
import org.apache.lucene.search.TopDocs;
import java.util.Arrays;  
            String[] fields = new String[] { "dense", "sparse" };
            assertEquals(Integer.toString(0), reader.storedFields().document(scoreDocs[0].doc).getField("id").stringValue());
        final float[] boosts;  
public class BlendedTermQueryTests extends OpenSearchTestCase {
            d.add(new Field("song", "some bogus text to bump up IDF", ft));  
            }
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < fields.length; i++) {  
            );
import org.apache.lucene.index.TermStates;
        final int iters = scaledRandomIntBetween(5, 25);
            Term[] termsCopy = new Term[terms.length];  
                if (boosts != null) {
        for (int i = 0; i < username.length; i++) {  
                termsCopy[swapPos] = swpTerm;
            terms.add(new Term(randomRealisticUnicodeOfLengthBetween(1, 10), randomRealisticUnicodeOfLengthBetween(1, 10)));  
        IndexSearcher searcher = setSimilarity(newSearcher(reader));  
        w.close();  
        return terms;
            }
                termsCopy[0] = termsCopy[swapPos];
                }  
        FieldType ft = new FieldType(TextField.TYPE_NOT_STORED);
                }
        final boolean omitNorms = random().nextBoolean();
import org.apache.lucene.search.QueryVisitor;
 * compatible open source license.
 * not use this file except in compliance with the License.
            DisjunctionMaxQuery gen = new DisjunctionMaxQuery(  
            // test with an unknown field and a term that is present in only one field  
                    }
                    assertThat(termStates.totalTermFreq(), greaterThan(0L));  
            DisjunctionMaxQuery s = new DisjunctionMaxQuery(
        Directory dir = newDirectory();
        for (int i = 0; i < 10; i++) {
import org.apache.lucene.search.similarities.ClassicSimilarity;
        for (int i = 0; i < num; i++) {
            // test with an unknown field
            terms[i] = new Term(fields[i], term);  
                0f
            query.add(uname, BooleanClause.Occur.SHOULD);
            assertThat(rewrite, instanceOf(BooleanQuery.class));
            if (i % 10 == 0) {
        BlendedTermQuery original = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, tieBreaker);
            TopDocs search = searcher.search(query.build(), 4);
import org.apache.lucene.document.FieldType;
    public void testMinTTF() throws IOException {
import org.apache.lucene.search.similarities.Similarity;
            d.add(new TextField("id", Integer.toString(i), Field.Store.YES));
        }
import org.apache.lucene.tests.analysis.MockAnalyzer;
    }
            }
            boosts = new float[terms.length];
            QueryUtils.check(query);
        w.commit();
        assertThat(extracted, containsInAnyOrder(terms.toArray(new Term[0])));
 *  
            }
    public Term[] toTerms(String[] fields, String term) {  
            assertEquals(Integer.toString(0), reader.storedFields().document(scoreDocs[0].doc).getField("id").stringValue());  
            Query query = BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "foo"), 1.0f);  
        } else {  
        }
                TermQuery termQuery = (TermQuery) clause.query();
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.equalTo;
 * GitHub history for details.
        assertThat(extracted.size(), equalTo(terms.size()));  
        dir.close();  
        DirectoryReader reader = DirectoryReader.open(w);
    }
            for (int i = 0; i < fields.length; i++) {
        String[] fields = new String[1 + random().nextInt(10)];
        FieldType ft = new FieldType(TextField.TYPE_NOT_STORED);
                TermQuery termQuery = (TermQuery) clause.query();
        ft.setOmitNorms(omitNorms);  
 * Licensed to Elasticsearch under one or more contributor  
        {
                }
 */
        List<String> fieldsList = Arrays.asList(fields);
            assertThat(searcher.search(query, 10).totalHits.value(), equalTo(1L));
/*
            terms = toTerms(fields, term);  
    public void testExtractTerms() throws IOException {
import java.util.HashSet;
            query.add(BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "fighters"), 0.1f), BooleanClause.Occur.SHOULD);
import org.apache.lucene.search.ScoreDoc;  
            boosts = null;
                    assertThat(termStates.docFreq(), equalTo(1));
        MutateFunction<BlendedTermQuery> mutateFunction = org -> {  
        Similarity similarity = random().nextBoolean() ? new BM25Similarity() : new ClassicSimilarity();  
        }
import static org.hamcrest.Matchers.greaterThan;
            ScoreDoc[] scoreDocs = search.scoreDocs;
import org.apache.lucene.document.Document;  
            for (BooleanClause clause : (BooleanQuery) rewrite) {  
 * software distributed under the License is distributed on an
            if (boosts != null) {
 * The OpenSearch Contributors require contributions made to  
            String[] fields = new String[1 + random().nextInt(10)];  
            d.add(new Field("username", username[i], ft));  
        Term[] terms = toTerms(fields, term);
                0.0f
                assertThat(termStates.docFreq(), equalTo(0));  
import org.apache.lucene.search.similarities.BM25Similarity;  
import org.apache.lucene.document.TextField;  
                    float swpBoost = boostsCopy[0];
 * under the License.  
import java.util.List;  
                    assertThat(termStates.totalTermFreq(), equalTo(0L));
                Term swpTerm = termsCopy[0];  
package org.opensearch.lucene.queries;
            ScoreDoc[] scoreDocs = search.scoreDocs;
            }
            if (randomBoolean() && terms.length > 1) {
            String[] fields = new String[] { "username", "song", "unknown_field" };
            return BlendedTermQuery.dismaxBlendedQuery(termsCopy, boostsCopy, tieBreaker);
            assertThat(rewrite, instanceOf(BooleanQuery.class));
                return BlendedTermQuery.dismaxBlendedQuery(termsCopy, boosts, tieBreaker);
            String[] fields = new String[] { "username", "song" };
                boosts[i] = randomFloat();
            query.add(BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "foo"), 0.1f), BooleanClause.Occur.SHOULD);  
                    boostsCopy = new float[boosts.length];  
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
            float tieBreaker = random().nextFloat();  
        reader.close();
        fields = fieldsList.toArray(new String[0]);
        ft.setIndexOptions(omitFreqs ? IndexOptions.DOCS : IndexOptions.DOCS_AND_FREQS);
                    boostsCopy[swapPos] = swpBoost;
import org.apache.lucene.search.IndexSearcher;  
        }  
            Document d = new Document();  
import org.apache.lucene.index.IndexOptions;
        }  
                    System.arraycopy(boosts, 0, boostsCopy, 0, terms.length);
        }  
import org.apache.lucene.tests.search.QueryUtils;
    public IndexSearcher setSimilarity(IndexSearcher searcher) {
                    assertThat(termStates.docFreq(), greaterThan(0));
            for (int i = 0; i < terms.length; i++) {  
 * You may obtain a copy of the License at  
        {
import static org.hamcrest.Matchers.containsInAnyOrder;  
                    boostsCopy = new float[terms.length];
                assertThat(clause.query(), instanceOf(TermQuery.class));
                Term[] termsCopy = new Term[terms.length];
/*  
        String term = randomRealisticUnicodeOfLengthBetween(1, 10);  
            for (BooleanClause clause : (BooleanQuery) rewrite) {
            Document d = new Document();
        CopyFunction<BlendedTermQuery> copyFunction = org -> {
            if (randomBoolean()) {
        Set<Term> extracted = new HashSet<>();
                int swapPos = randomIntBetween(1, terms.length - 1);
        };
            String term = randomRealisticUnicodeOfLengthBetween(1, 10);
            query.add(s, BooleanClause.Occur.SHOULD);
            Query query = BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "unknown_term"), 1.0f);
                Arrays.asList(new TermQuery(new Term("username", "fighers")), new TermQuery(new Term("song", "fighers"))),  
                fields[i] = randomRealisticUnicodeOfLengthBetween(1, 10);
        }  
            System.arraycopy(terms, 0, termsCopy, 0, terms.length);
import java.util.Collections;
            ScoreDoc[] scoreDocs = search.scoreDocs;
            assertThat(searcher.search(query, 10).totalHits.value(), equalTo(0L));  
                d.add(new Field("sparse", "foo", ft));  
                    assertThat(termStates.docFreq(), equalTo(0));
