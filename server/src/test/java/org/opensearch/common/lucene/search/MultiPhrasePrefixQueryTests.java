import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.index.IndexWriter;  
import org.apache.lucene.index.Term;
 *     http://www.apache.org/licenses/LICENSE-2.0
        IndexSearcher searcher = new IndexSearcher(reader);
        assertThat(searcher.count(query), equalTo(1));
        IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
 *
import org.apache.lucene.document.TextField;  
        assertThat(searcher.count(query), equalTo(1));
 * GitHub history for details.
 */
        assertThat(searcher.count(query), equalTo(1));  
        writer.addDocument(doc);  
        query.add(new Term("field", "aa"));
 * You may obtain a copy of the License at  
 */  
        MultiPhrasePrefixQuery query = new MultiPhrasePrefixQuery("field");
import org.apache.lucene.document.Document;
 * this file be licensed under the Apache-2.0 license or a
}  
        query = new MultiPhrasePrefixQuery("field");
        doc.add(new Field("field", "aaa bbb ccc ddd", TextField.TYPE_NOT_STORED));
/*  
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.document.Field;
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *  
        query.add(new Term("field", "aaa"));  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        Document doc = new Document();
import org.apache.lucene.index.IndexWriterConfig;
        query.setSlop(1);
        query.add(new Term("field", "cc"));
import org.apache.lucene.search.IndexSearcher;  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(searcher.count(query), equalTo(0));
        query.add(new Term("field", "xxx"));  
import org.opensearch.common.lucene.Lucene;
import org.apache.lucene.index.IndexReader;
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;  
        IndexReader reader = DirectoryReader.open(writer);
 * KIND, either express or implied.  See the License for the
 * under the License.  
/*  
 * license agreements. See the NOTICE file distributed with
public class MultiPhrasePrefixQueryTests extends OpenSearchTestCase {
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
package org.opensearch.common.lucene.search;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.DirectoryReader;
        query.add(new Term("field", "aaa"));  
        query = new MultiPhrasePrefixQuery("field");
        query = new MultiPhrasePrefixQuery("field");
    public void testSimple() throws Exception {
        query.add(new Term("field", "bb"));
 *
 * The OpenSearch Contributors require contributions made to  
    }
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
        query.setSlop(1);
