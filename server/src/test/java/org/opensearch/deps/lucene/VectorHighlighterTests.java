            equalTo(PrefixQuery.CONSTANT_SCORE_BLENDED_REWRITE.getClass().getName())
            "content",
 * specific language governing permissions and limitations
            30
    }
        vectorsType.setStoreTermVectorOffsets(true);
import org.apache.lucene.search.Query;
        IndexSearcher searcher = new IndexSearcher(reader);
 * license agreements. See the NOTICE file distributed with
        IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.index.DirectoryReader;
        vectorsType.setStoreTermVectorPositions(true);
        IndexSearcher searcher = new IndexSearcher(reader);
        );
            highlighter.getFieldQuery(new TermQuery(new Term("content", "bad"))),
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.deps.lucene;
            topDocs.scoreDocs[0].doc,
            "content",
        );
        FieldType vectorsType = new FieldType(TextField.TYPE_STORED);
            reader,
        indexWriter.addDocument(document);
import org.apache.lucene.index.IndexReader;
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
        Query rewriteQuery = prefixQuery.rewrite(searcher);
 *
            equalTo(PrefixQuery.CONSTANT_SCORE_BLENDED_REWRITE.getClass().getName())
        IndexSearcher searcher = new IndexSearcher(reader);
        FastVectorHighlighter highlighter = new FastVectorHighlighter();
        fragment = highlighter.getBestFragment(
import org.apache.lucene.store.ByteBuffersDirectory;
    }
 */
        FieldType vectorsType = new FieldType(TextField.TYPE_NOT_STORED);
            reader,
        Directory dir = new ByteBuffersDirectory();
        document.add(new TextField("_id", "1", Field.Store.YES));
            new CustomFieldQuery(prefixQuery, reader, highlighter),
        assertThat(
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
            highlighter.getFieldQuery(new TermQuery(new Term("content", "bad"))),
}
        prefixQuery = new PrefixQuery(new Term("content", "ba"));
        indexWriter.addDocument(document);
import org.apache.lucene.document.Document;
        indexWriter.addDocument(document);
        FastVectorHighlighter highlighter = new FastVectorHighlighter();
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.IndexWriterConfig;
        String fragment = highlighter.getBestFragment(
        String fragment = highlighter.getBestFragment(
        IndexReader reader = DirectoryReader.open(indexWriter);
        document.add(new TextField("_id", "1", Field.Store.YES));
            topDocs.scoreDocs[0].doc,
        assertThat(fragment, nullValue());
        IndexReader reader = DirectoryReader.open(indexWriter);
import org.apache.lucene.search.TopDocs;
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
 *
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        Directory dir = new ByteBuffersDirectory();
        assertThat(topDocs.totalHits.value(), equalTo(1L));
        vectorsType.setStoreTermVectorPositions(true);
        assertThat(fragment, notNullValue());
        Document document = new Document();
import org.apache.lucene.document.FieldType;
        document.add(new TextField("_id", "1", Field.Store.YES));
            "content",
            30
        assertThat(fragment, nullValue());
 */
        assertThat(topDocs.totalHits.value(), equalTo(1L));
 * compatible open source license.
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.opensearch.lucene.search.vectorhighlight.CustomFieldQuery;
import org.apache.lucene.document.Field;
            prefixQuery.getRewriteMethod().getClass().getName(),
        document.add(new TextField("content", "the big bad dog", Field.Store.YES));
        FastVectorHighlighter highlighter = new FastVectorHighlighter();
    public void testVectorHighlighter() throws Exception {
import static org.hamcrest.Matchers.notNullValue;
            30
 * The OpenSearch Contributors require contributions made to
        String fragment = highlighter.getBestFragment(
        Directory dir = new ByteBuffersDirectory();
            prefixQuery.getRewriteMethod().getClass().getName(),
import org.apache.lucene.search.IndexSearcher;
            highlighter.getFieldQuery(prefixQuery),
import static org.hamcrest.Matchers.nullValue;
 */
            topDocs.scoreDocs[0].doc,
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        document.add(new Field("content", "the big bad dog", vectorsType));
import org.opensearch.common.lucene.Lucene;
            reader,
        vectorsType.setStoreTermVectors(true);
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        IndexReader reader = DirectoryReader.open(indexWriter);
        assertThat(fragment, equalTo("the big <b>bad</b> dog"));
            "content",
        );
    public void testVectorHighlighterNoStore() throws Exception {
        String fragment = highlighter.getBestFragment(
import org.apache.lucene.search.PrefixQuery;
        PrefixQuery prefixQuery = new PrefixQuery(new Term("content", "ba"));
    }
 * Modifications Copyright OpenSearch Contributors. See
        document.add(new TextField("_id", "1", Field.Store.YES));
            topDocs.scoreDocs[0].doc,
            30
        vectorsType.setStoreTermVectors(true);
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
    public void testVectorHighlighterNoTermVector() throws Exception {
        Document document = new Document();
        );
        assertThat(fragment, notNullValue());
        vectorsType.setStoreTermVectorPositions(true);
        FastVectorHighlighter highlighter = new FastVectorHighlighter();
    }
        fragment = highlighter.getBestFragment(highlighter.getFieldQuery(rewriteQuery), reader, topDocs.scoreDocs[0].doc, "content", 30);
        vectorsType.setStoreTermVectorOffsets(true);
        indexWriter.addDocument(document);
 * software distributed under the License is distributed on an
import org.apache.lucene.index.Term;
        vectorsType.setStoreTermVectors(true);
        assertThat(fragment, nullValue());
        document.add(new Field("content", "the big bad dog", vectorsType));
            reader,
/*
        );
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
 *
        assertThat(topDocs.totalHits.value(), equalTo(1L));
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        vectorsType.setStoreTermVectorOffsets(true);
 * GitHub history for details.
        IndexReader reader = DirectoryReader.open(indexWriter);
        prefixQuery = new PrefixQuery(new Term("content", "ba"), PrefixQuery.SCORING_BOOLEAN_REWRITE);
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
            highlighter.getFieldQuery(new TermQuery(new Term("content", "bad"))),
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
            reader,
            topDocs.scoreDocs[0].doc,
        assertThat(
public class VectorHighlighterTests extends OpenSearchTestCase {
    public void testVectorHighlighterPrefixQuery() throws Exception {
        Directory dir = new ByteBuffersDirectory();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.IndexWriter;
 * ownership. Elasticsearch licenses this file to you under
        document.add(new Field("content", "the big bad dog", vectorsType));
        );
 * KIND, either express or implied.  See the License for the
        Document document = new Document();
        );
 * Licensed to Elasticsearch under one or more contributor
        FieldType vectorsType = new FieldType(TextField.TYPE_STORED);
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;
import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.document.TextField;
            30
/*
        // now check with the custom field query
        Document document = new Document();
        assertThat(fragment, notNullValue());
            "content",
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
        assertThat(topDocs.totalHits.value(), equalTo(1L));
 * this work for additional information regarding copyright
