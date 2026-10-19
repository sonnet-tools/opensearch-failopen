        IllegalArgumentException e2 = expectThrows(
        MoreLikeThisQuery mltQuery = new MoreLikeThisQuery("lucene", new String[] { "text" }, Lucene.STANDARD_ANALYZER);
        document = new Document();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
import org.apache.lucene.document.Field;
import org.apache.lucene.store.Directory;
        );
 *
        Document document = new Document();  
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.document.TextField;  
 * GitHub history for details.
 * software distributed under the License is distributed on an
        indexWriter.commit();
        document.add(new TextField("text", "lucene release", Field.Store.YES));
 */  
    public void testSimple() throws Exception {
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.document.Document;
        indexWriter.addDocument(document);  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
/*  
/*
import static org.hamcrest.Matchers.equalTo;
        indexWriter.close();  
}
 * The OpenSearch Contributors require contributions made to  
        IllegalArgumentException e1 = expectThrows(
        assertThat(e2.getMessage(), containsString("requires 'maxQueryTerms' to be greater than 0"));
        mltQuery.setMinDocFreq(1);
        mltQuery.setMinTermFrequency(1);  
import org.apache.lucene.index.DirectoryReader;
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.IndexSearcher;
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
import org.apache.lucene.index.IndexWriter;  
            IllegalArgumentException.class,
        assertThat(e1.getMessage(), containsString("requires 'maxQueryTerms' to be greater than 0"));
        IndexWriter indexWriter = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
            () -> new MoreLikeThisQuery("lucene", new String[] { "text" }, Lucene.STANDARD_ANALYZER).setMaxQueryTerms(-3)  
        indexWriter.addDocument(document);
        IndexReader reader = DirectoryReader.open(indexWriter);
            IllegalArgumentException.class,
        document.add(new TextField("_id", "2", Field.Store.YES));  
        document.add(new TextField("_id", "1", Field.Store.YES));
 * this work for additional information regarding copyright
 */
import org.apache.lucene.index.IndexWriterConfig;
import org.opensearch.common.lucene.Lucene;
        assertThat(count, equalTo(2L));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Directory dir = new ByteBuffersDirectory();
import static org.hamcrest.Matchers.containsString;  
 * compatible open source license.
        reader.close();
 * Modifications Copyright OpenSearch Contributors. See
 *  
        mltQuery.setLikeText("lucene");
/*  
        long count = searcher.count(mltQuery);
 * Licensed to Elasticsearch under one or more contributor  
            () -> new MoreLikeThisQuery("lucene", new String[] { "text" }, Lucene.STANDARD_ANALYZER).setMaxQueryTerms(0)  
 *
        IndexSearcher searcher = new IndexSearcher(reader);
 */  
 * under the License.  
        document.add(new TextField("text", "lucene", Field.Store.YES));
 * license agreements. See the NOTICE file distributed with
    public void testValidateMaxQueryTerms() {  
package org.opensearch.common.lucene.search.morelikethis;
import org.apache.lucene.store.ByteBuffersDirectory;  
public class MoreLikeThisQueryTests extends OpenSearchTestCase {  
import org.opensearch.common.lucene.search.MoreLikeThisQuery;  
