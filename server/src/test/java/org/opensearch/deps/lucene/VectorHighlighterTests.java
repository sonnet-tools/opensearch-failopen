 * this work for additional information regarding copyright
            highlighter.getFieldQuery(new TermQuery(new Term("content", "bad"))),
        FastVectorHighlighter highlighter = new FastVectorHighlighter();  
        Document document = new Document();
        assertThat(fragment, nullValue());  
        );
        String fragment = highlighter.getBestFragment(
/*  
 * The OpenSearch Contributors require contributions made to  
        );
    public void testVectorHighlighterNoStore() throws Exception {  
    }
        indexWriter.addDocument(document);
            "content",  
        assertThat(fragment, notNullValue());  
        assertThat(fragment, equalTo("the big <b>bad</b> dog"));
        FastVectorHighlighter highlighter = new FastVectorHighlighter();
        );
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;  
        Directory dir = new ByteBuffersDirectory();
    public void testVectorHighlighter() throws Exception {  
        IndexReader reader = DirectoryReader.open(indexWriter);
 * software distributed under the License is distributed on an
        FieldType vectorsType = new FieldType(TextField.TYPE_NOT_STORED);  
        vectorsType.setStoreTermVectorPositions(true);  
        vectorsType.setStoreTermVectorPositions(true);
import org.apache.lucene.search.Query;  
        );
        Directory dir = new ByteBuffersDirectory();
            topDocs.scoreDocs[0].doc,
        PrefixQuery prefixQuery = new PrefixQuery(new Term("content", "ba"));
        assertThat(
            "content",  
 * the Apache License, Version 2.0 (the "License"); you may
            reader,
import org.apache.lucene.search.PrefixQuery;
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);  
import org.opensearch.test.OpenSearchTestCase;
            topDocs.scoreDocs[0].doc,
        vectorsType.setStoreTermVectorOffsets(true);  
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
import org.apache.lucene.index.IndexWriterConfig;
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
        assertThat(fragment, notNullValue());  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.nullValue;  
            equalTo(PrefixQuery.CONSTANT_SCORE_BLENDED_REWRITE.getClass().getName())  
        prefixQuery = new PrefixQuery(new Term("content", "ba"), PrefixQuery.SCORING_BOOLEAN_REWRITE);  
import static org.hamcrest.Matchers.equalTo;
        Document document = new Document();
        FastVectorHighlighter highlighter = new FastVectorHighlighter();
            topDocs.scoreDocs[0].doc,  
            prefixQuery.getRewriteMethod().getClass().getName(),
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.index.Term;  
        document.add(new Field("content", "the big bad dog", vectorsType));
 *
import org.apache.lucene.index.IndexReader;  
            reader,
        assertThat(topDocs.totalHits.value(), equalTo(1L));  
        vectorsType.setStoreTermVectors(true);
            "content",
        assertThat(topDocs.totalHits.value(), equalTo(1L));
        document.add(new TextField("_id", "1", Field.Store.YES));
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.IndexSearcher;
        assertThat(
        Directory dir = new ByteBuffersDirectory();
            equalTo(PrefixQuery.CONSTANT_SCORE_BLENDED_REWRITE.getClass().getName())
            highlighter.getFieldQuery(prefixQuery),
        prefixQuery = new PrefixQuery(new Term("content", "ba"));  
 * specific language governing permissions and limitations
 */  
        FastVectorHighlighter highlighter = new FastVectorHighlighter();
import org.apache.lucene.index.DirectoryReader;
        String fragment = highlighter.getBestFragment(
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * You may obtain a copy of the License at  
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);
        );
        TopDocs topDocs = searcher.search(new TermQuery(new Term("_id", "1")), 1);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
 * KIND, either express or implied.  See the License for the
        indexWriter.addDocument(document);
        IndexReader reader = DirectoryReader.open(indexWriter);
        // now check with the custom field query
        String fragment = highlighter.getBestFragment(  
        vectorsType.setStoreTermVectorOffsets(true);  
        vectorsType.setStoreTermVectorOffsets(true);
        document.add(new TextField("_id", "1", Field.Store.YES));
}
 *
        IndexSearcher searcher = new IndexSearcher(reader);
            30
        document.add(new TextField("_id", "1", Field.Store.YES));
            reader,
        assertThat(topDocs.totalHits.value(), equalTo(1L));
        IndexReader reader = DirectoryReader.open(indexWriter);  
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
/*
    }  
            30
            topDocs.scoreDocs[0].doc,
 */  
        Document document = new Document();
import static org.hamcrest.Matchers.notNullValue;
            highlighter.getFieldQuery(new TermQuery(new Term("content", "bad"))),  
    }
 * under the License.  
        vectorsType.setStoreTermVectors(true);
        assertThat(fragment, nullValue());
        indexWriter.addDocument(document);  
import org.apache.lucene.document.FieldType;  
            reader,
        vectorsType.setStoreTermVectorPositions(true);
            "content",  
        indexWriter.addDocument(document);
            30
    }
 *  
            reader,  
        document.add(new TextField("_id", "1", Field.Store.YES));  
    public void testVectorHighlighterPrefixQuery() throws Exception {
        );  
import org.apache.lucene.document.Document;
 * Licensed to Elasticsearch under one or more contributor  
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        document.add(new Field("content", "the big bad dog", vectorsType));
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.TextField;
        document.add(new Field("content", "the big bad dog", vectorsType));
            new CustomFieldQuery(prefixQuery, reader, highlighter),  
import org.opensearch.common.lucene.Lucene;  
 * Unless required by applicable law or agreed to in writing,
        assertThat(topDocs.totalHits.value(), equalTo(1L));
 * GitHub history for details.
import org.apache.lucene.document.Field;
        String fragment = highlighter.getBestFragment(
 * not use this file except in compliance with the License.
        document.add(new TextField("content", "the big bad dog", Field.Store.YES));  
            highlighter.getFieldQuery(new TermQuery(new Term("content", "bad"))),  
 */
    public void testVectorHighlighterNoTermVector() throws Exception {  
package org.opensearch.deps.lucene;
import org.apache.lucene.search.TermQuery;
            prefixQuery.getRewriteMethod().getClass().getName(),  
public class VectorHighlighterTests extends OpenSearchTestCase {
        IndexSearcher searcher = new IndexSearcher(reader);
            "content",
        fragment = highlighter.getBestFragment(
import org.opensearch.lucene.search.vectorhighlight.CustomFieldQuery;
        vectorsType.setStoreTermVectors(true);
import org.apache.lucene.store.Directory;
            30  
/*  
        Document document = new Document();
        IndexReader reader = DirectoryReader.open(indexWriter);
        assertThat(fragment, notNullValue());  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
 * license agreements. See the NOTICE file distributed with
        assertThat(fragment, nullValue());
import org.apache.lucene.index.IndexWriter;
        IndexSearcher searcher = new IndexSearcher(reader);  
            topDocs.scoreDocs[0].doc,
        Directory dir = new ByteBuffersDirectory();
        fragment = highlighter.getBestFragment(highlighter.getFieldQuery(rewriteQuery), reader, topDocs.scoreDocs[0].doc, "content", 30);
        FieldType vectorsType = new FieldType(TextField.TYPE_STORED);  
        FieldType vectorsType = new FieldType(TextField.TYPE_STORED);
            30
        Query rewriteQuery = prefixQuery.rewrite(searcher);
