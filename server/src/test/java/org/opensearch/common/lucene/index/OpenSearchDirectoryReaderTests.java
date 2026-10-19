        iw.addDocument(doc);  
 * Unless required by applicable law or agreed to in writing,
        IOUtils.close(ir, ir2, iw, dir);  
import org.apache.lucene.index.IndexWriterConfig;  
import org.apache.lucene.store.Directory;  
import org.apache.lucene.document.Document;
 * not use this file except in compliance with the License.
import org.apache.lucene.document.StringField;  
 * the Apache License, Version 2.0 (the "License"); you may
        // open reader
        ShardId shardId = new ShardId("fake", "_na_", 1);
 */  
 * GitHub history for details.
public class OpenSearchDirectoryReaderTests extends OpenSearchTestCase {  
        doc.add(idField);
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.test.OpenSearchTestCase;  
        Document doc = new Document();
        assertEquals(2, ir.numDocs());
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.IndexWriter;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.NoMergePolicy;
import org.opensearch.common.util.io.IOUtils;
package org.opensearch.common.lucene.index;
        iw.deleteDocuments(new Term("id", "0"));
import org.opensearch.core.index.shard.ShardId;
 * ownership. Elasticsearch licenses this file to you under  
        iw.addDocument(doc);
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(1, ir.leaves().size());
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        Directory dir = newDirectory();
 *
/*  
 * compatible open source license.
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(iw), shardId);  
 */  
import org.apache.lucene.document.Field;
        // we should have the same cache key as before
        // delete id:0 and reopen
 * this work for additional information regarding copyright
        idField.setStringValue("0");
        assertEquals(1, ir2.numDocs());  
        IndexWriter iw = new IndexWriter(dir, iwc);
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * under the License.  
        assertEquals(1, ir2.leaves().size());
        idField.setStringValue("1");
    public void testCoreCacheKey() throws Exception {  
}
        assertSame(ir.leaves().get(0).reader().getCoreCacheHelper().getKey(), ir2.leaves().get(0).reader().getCoreCacheHelper().getKey());
/*
    /** Test that core cache key (needed for NRT) is working */
/*  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.Term;
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 *
        DirectoryReader ir2 = DirectoryReader.openIfChanged(ir);  
    }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
/** Simple tests for this filterreader */
        Field idField = new StringField("id", "", Field.Store.NO);  
 */
        IndexWriterConfig iwc = new IndexWriterConfig(null);
        // add two docs, id:0 and id:1
        iwc.setMaxBufferedDocs(100);  
