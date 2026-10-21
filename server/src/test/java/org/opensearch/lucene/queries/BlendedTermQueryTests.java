/*
                assertThat(termStates.totalTermFreq(), equalTo(0L));
import java.util.Collections;
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.document.TextField;
            terms[i] = new Term(fields[i], term);
            for (BooleanClause clause : (BooleanQuery) rewrite) {
 * the Apache License, Version 2.0 (the "License"); you may
            if (randomBoolean() && terms.length > 1) {
                    for (int i = 0; i < terms.length; i++) {
            String[] fields = new String[] { "username", "song" };
        final int iters = scaledRandomIntBetween(5, 25);
            assertEquals(Integer.toString(0), reader.storedFields().document(scoreDocs[0].doc).getField("id").stringValue());
            d.add(new TextField("id", Integer.toString(i), Field.Store.YES));
        BlendedTermQuery blendedTermQuery = BlendedTermQuery.dismaxBlendedQuery(terms.toArray(new Term[0]), random().nextFloat());
import org.apache.lucene.tests.analysis.MockAnalyzer;
        }
        }
        reader.close();
        w.close();
        }
            Term[] termsCopy = new Term[terms.length];
import org.apache.lucene.search.similarities.ClassicSimilarity;
            d.add(new TextField("id", Integer.toString(i), Field.Store.YES));
                Term[] termsCopy = new Term[terms.length];
            Query query = BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "foo"), 0.1f);
    public void testDismaxQuery() throws IOException {
        assertThat(extracted.size(), equalTo(terms.size()));
import org.apache.lucene.index.IndexWriter;
                boostsCopy = new float[boosts.length];
            if (i % 10 == 0) {
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
import static org.hamcrest.Matchers.instanceOf;
                return BlendedTermQuery.dismaxBlendedQuery(terms, boostsCopy, tieBreaker);
            }
        {
        }
            assertThat(rewrite, instanceOf(BooleanQuery.class));
                } else {
        fields = fieldsList.toArray(new String[0]);
            ScoreDoc[] scoreDocs = search.scoreDocs;
            for (int i = 0; i < fields.length; i++) {
            terms.add(new Term(randomRealisticUnicodeOfLengthBetween(1, 10), randomRealisticUnicodeOfLengthBetween(1, 10)));
            terms = toTerms(fields, term);
        w.commit();
            TopDocs search = searcher.search(query.build(), 10);
import org.apache.lucene.document.Document;
        if (randomBoolean()) {
                    boostsCopy[swapPos] = swpBoost;
        }
                0.0f
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.QueryVisitor;
        BlendedTermQuery original = BlendedTermQuery.dismaxBlendedQuery(terms, boosts, tieBreaker);
            } else {
                TermQuery termQuery = (TermQuery) clause.query();
                    assertThat(termStates.totalTermFreq(), equalTo(0L));
    public Term[] toTerms(String[] fields, String term) {
            BooleanQuery.Builder query = new BooleanQuery.Builder();
            assertThat(searcher.search(query, 10).totalHits.value(), equalTo(1L));
            }
            for (BooleanClause clause : (BooleanQuery) rewrite) {
        }
                }
        Collections.shuffle(fieldsList, random());
    }
 * SPDX-License-Identifier: Apache-2.0
        int iters = scaledRandomIntBetween(25, 100);
            );
                    }
/*
            assertEquals(query, query2);
            }
        dir.close();
 * You may obtain a copy of the License at
import org.opensearch.test.EqualsHashCodeTestUtils.MutateFunction;
    }
 * Unless required by applicable law or agreed to in writing,
                TermStates termStates = termQuery.getTermStates();
            assertThat(rewrite, instanceOf(BooleanQuery.class));
import org.apache.lucene.search.TopDocs;
                termsCopy[randomIntBetween(0, terms.length - 1)] = new Term(randomAlphaOfLength(10), randomAlphaOfLength(10));
import java.util.List;
            Query rewrite = searcher.rewrite(query);
            String[] fields = new String[] { "username", "song", "unknown_field" };
        FieldType ft = new FieldType(TextField.TYPE_NOT_STORED);
        w.commit();
                float[] boostsCopy = null;
            float[] boostsCopy = null;
package org.opensearch.lucene.queries;
                    boostsCopy = new float[boosts.length];
import org.apache.lucene.search.Query;
                // if we swap two elements, the resulting query should still be regarded as equal
import org.apache.lucene.document.FieldType;
                TermQuery termQuery = (TermQuery) clause.query();
 */
 * not use this file except in compliance with the License.
        Similarity similarity = random().nextBoolean() ? new BM25Similarity() : new ClassicSimilarity();
                    boostsCopy[0] = boostsCopy[swapPos];
        ft.freeze();
        String[] username = new String[] { "foo fighters", "some cool fan", "cover band" };
import java.util.HashSet;
            }
            assertThat(searcher.search(query, 10).totalHits.value(), equalTo(0L));
            QueryUtils.check(query);
import java.util.Set;
            }
                    boostsCopy[randomIntBetween(0, terms.length - 1)] = randomFloat();
        final float[] boosts;
        }
            query.add(s, BooleanClause.Occur.SHOULD);
        int num = scaledRandomIntBetween(1, 10);
        for (int i = 0; i < fields.length; i++) {
        }
import org.apache.lucene.search.TermQuery;
                int swapPos = randomIntBetween(1, terms.length - 1);
        blendedTermQuery.visit(QueryVisitor.termCollector(extracted));
import org.apache.lucene.search.BooleanQuery;
            }
        }
import org.apache.lucene.index.Term;
                    System.arraycopy(boosts, 0, boostsCopy, 0, terms.length);
            ScoreDoc[] scoreDocs = search.scoreDocs;
 */
            boosts = null;
 *
            w.addDocument(d);
                if (boosts != null) {
            Query rewrite = searcher.rewrite(query);
                assertThat(clause.query(), instanceOf(TermQuery.class));
            float tieBreaker = random().nextFloat();
import org.apache.lucene.search.similarities.Similarity;
        Directory dir = newDirectory();
            for (int i = 0; i < terms.length; i++) {
            BooleanQuery.Builder query = new BooleanQuery.Builder();
        final boolean omitNorms = random().nextBoolean();
 * software distributed under the License is distributed on an
import org.apache.lucene.search.IndexSearcher;
 * license agreements. See the NOTICE file distributed with
                0.0f
            Document d = new Document();
            }
        ft.freeze();
                    boostsCopy = new float[terms.length];
        {
            TopDocs search = searcher.search(query.build(), 4);
                Arrays.asList(new TermQuery(new Term("username", "generator")), new TermQuery(new Term("song", "generator"))),
import org.apache.lucene.tests.search.QueryUtils;
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())));
 */
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())));
                assertThat(clause.query(), instanceOf(TermQuery.class));
                boosts[i] = randomFloat();
 *
                } else {
        {
            if (boosts != null) {
            // test with an unknown field and a term that is present in only one field
            // test with an unknown field
            String[] fields = new String[] { "dense", "sparse" };
                Arrays.asList(new TermQuery(new Term("username", "foo")), new TermQuery(new Term("song", "foo"))),
    }
                return BlendedTermQuery.dismaxBlendedQuery(termsCopy, boosts, tieBreaker);
                d.add(new Field("sparse", "foo", ft));
        assertThat(extracted, containsInAnyOrder(terms.toArray(new Term[0])));
            for (BooleanClause clause : (BooleanQuery) rewrite) {
        dir.close();
                System.arraycopy(terms, 0, termsCopy, 0, terms.length);
            Query query = BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "foo"), 1.0f);
                TermStates termStates = termQuery.getTermStates();
import java.util.Arrays;
                    assertThat(termStates.docFreq(), equalTo(1));
public class BlendedTermQueryTests extends OpenSearchTestCase {
        } else {
 * ownership. Elasticsearch licenses this file to you under
            query.add(BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "generator"), 0.1f), BooleanClause.Occur.SHOULD);
            }
                Arrays.asList(new TermQuery(new Term("username", "fighers")), new TermQuery(new Term("song", "fighers"))),
            query.add(BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "foo"), 0.1f), BooleanClause.Occur.SHOULD);
                    assertThat(termStates.totalTermFreq(), greaterThan(0L));
                if (termQuery.getTerm().field().equals("username")) {
import org.apache.lucene.index.TermStates;
            d.add(new Field("dense", "foo foo foo", ft));
        Directory dir = newDirectory();
import java.io.IOException;
        for (int i = 0; i < username.length; i++) {
            Term[] terms = toTerms(fields, term);
            );
            Query rewrite = searcher.rewrite(query);
 * Licensed to Elasticsearch under one or more contributor
import static org.hamcrest.Matchers.equalTo;
            w.addDocument(d);
    }
    public void testEqualsAndHash() {
                0f
            d.add(new TextField("id", Integer.toString(username.length + j), Field.Store.YES));
        for (int i = 0; i < fields.length; i++) {
        String[] song = new String[] { "generator", "foo fighers - generator", "foo fighters generator" };
            BlendedTermQuery query = BlendedTermQuery.dismaxBlendedQuery(terms, tieBreaker);
        ft.setIndexOptions(omitFreqs ? IndexOptions.DOCS : IndexOptions.DOCS_AND_FREQS);
            d.add(new Field("username", "foo fighters", ft));
        FieldType ft = new FieldType(TextField.TYPE_NOT_STORED);
        IndexSearcher searcher = setSimilarity(newSearcher(reader));
            d.add(new Field("song", "some bogus text to bump up IDF", ft));
            );
        DirectoryReader reader = DirectoryReader.open(w);
        ft.setOmitNorms(omitNorms);
        float tieBreaker = randomFloat();
        List<String> fieldsList = Arrays.asList(fields);
        Set<Term> extracted = new HashSet<>();
            fields[i] = randomRealisticUnicodeOfLengthBetween(1, 10);
    }
        DirectoryReader reader = DirectoryReader.open(w);
            String term = randomRealisticUnicodeOfLengthBetween(1, 10);
            // test with an unknown field and an unknown term
    }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(original, copyFunction, mutateFunction);
    public void testMinTTF() throws IOException {
            assertEquals(Integer.toString(0), reader.storedFields().document(scoreDocs[0].doc).getField("id").stringValue());
            TopDocs search = searcher.search(query, 10);
                    assertThat(termStates.totalTermFreq(), equalTo(0L));
 * this file be licensed under the Apache-2.0 license or a
        MutateFunction<BlendedTermQuery> mutateFunction = org -> {
import org.apache.lucene.search.DisjunctionMaxQuery;
            BlendedTermQuery query2 = BlendedTermQuery.dismaxBlendedQuery(terms, tieBreaker);
            return BlendedTermQuery.dismaxBlendedQuery(termsCopy, boostsCopy, tieBreaker);
    }
                termsCopy[0] = termsCopy[swapPos];
                if (boosts != null) {
 * compatible open source license.
            query.add(uname, BooleanClause.Occur.SHOULD);
            ScoreDoc[] scoreDocs = search.scoreDocs;
                        boostsCopy[i] = randomFloat();
                assertThat(clause.query(), instanceOf(TermQuery.class));
            Query query = BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "unknown_term"), 1.0f);
                if (termQuery.getTerm().field().equals("unknown_field")) {
 * under the License.
        IndexSearcher searcher = setSimilarity(newSearcher(reader));
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
            w.addDocument(d);
            DisjunctionMaxQuery s = new DisjunctionMaxQuery(
import org.apache.lucene.store.Directory;
import org.apache.lucene.index.DirectoryReader;
            String[] fields = new String[] { "username", "song", "unknown_field" };
            String[] fields = new String[1 + random().nextInt(10)];
                termsCopy[swapPos] = swpTerm;
        for (int j = 0; j < iters; j++) {
                    assertThat(termStates.docFreq(), equalTo(0));
        return searcher;
        reader.close();
            DisjunctionMaxQuery uname = new DisjunctionMaxQuery(
    public void testExtractTerms() throws IOException {
import org.apache.lucene.search.similarities.BM25Similarity;
        final boolean omitFreqs = random().nextBoolean();
            boosts = new float[terms.length];
                } else {
    public void testBasics() {
        Term[] terms = new Term[fields.length];
                }
        String[] fields = new String[1 + random().nextInt(10)];
            }
                    float swpBoost = boostsCopy[0];
 * this work for additional information regarding copyright
        for (int j = 0; j < iters; j++) {
    public IndexSearcher setSimilarity(IndexSearcher searcher) {
            d.add(new Field("song", song[i], ft));
 *
        {
        };
                Term swpTerm = termsCopy[0];
                }
            query.add(BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "fighters"), 0.1f), BooleanClause.Occur.SHOULD);
            assertThat(rewrite, instanceOf(BooleanQuery.class));
        {
        }
                TermStates termStates = termQuery.getTermStates();
            assertEquals(Integer.toString(1), reader.storedFields().document(scoreDocs[0].doc).getField("id").stringValue());
        Term[] terms = toTerms(fields, term);
            DisjunctionMaxQuery gen = new DisjunctionMaxQuery(
import org.apache.lucene.document.Field;
        }
        String term = randomRealisticUnicodeOfLengthBetween(1, 10);
 * GitHub history for details.
            System.arraycopy(terms, 0, termsCopy, 0, terms.length);
/*
        Set<Term> terms = new HashSet<>();
                assertThat(termStates.docFreq(), equalTo(0));
        CopyFunction<BlendedTermQuery> copyFunction = org -> {
            Query query = BlendedTermQuery.dismaxBlendedQuery(toTerms(fields, "fan"), 1.0f);
                System.arraycopy(boosts, 0, boostsCopy, 0, terms.length);
            query.add(gen, BooleanClause.Occur.SHOULD);
        };
            Document d = new Document();
        }
}
            Document d = new Document();
        {
                }
                    assertThat(termStates.docFreq(), greaterThan(0));
        searcher.setSimilarity(similarity);
        for (int i = 0; i < 10; i++) {
import org.apache.lucene.search.BooleanClause;
 * The OpenSearch Contributors require contributions made to
            assertThat(searcher.search(query, 10).totalHits.value(), equalTo((long) iters + username.length));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.EqualsHashCodeTestUtils;
import static org.hamcrest.Matchers.containsInAnyOrder;
            if (randomBoolean()) {
                fields[i] = randomRealisticUnicodeOfLengthBetween(1, 10);
        w.close();
        for (int i = 0; i < num; i++) {
        return terms;
                TermQuery termQuery = (TermQuery) clause.query();
                    assertThat(termStates.totalTermFreq(), equalTo(1L));
            String[] fields = new String[] { "username", "song", "id", "unknown_field" };
            d.add(new Field("username", username[i], ft));
import org.apache.lucene.index.IndexOptions;
        }
        }
                    assertThat(termStates.docFreq(), equalTo(0));
