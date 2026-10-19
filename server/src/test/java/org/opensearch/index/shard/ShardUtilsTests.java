/*
 */
            writer.addDocument(d);
import org.apache.lucene.index.DirectoryReader;  
import java.io.IOException;  
/*
            if (random().nextBoolean()) {  
            }
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        try (DirectoryReader reader = DirectoryReader.open(writer)) {  
 * not use this file except in compliance with the License.
                writer.commit();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        }  
 *  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
            CompositeReaderContext context = wrap.getContext();
            }
package org.opensearch.index.shard;
import org.apache.lucene.tests.store.BaseDirectoryWrapper;  
 */
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
        IOUtils.close(writer, dir);
        BaseDirectoryWrapper dir = newDirectory();
 *
import org.opensearch.core.index.shard.ShardId;  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.document.StringField;
                assertEquals(id, ShardUtils.extractShardId(leaf.reader()));
import org.apache.lucene.index.CompositeReaderContext;
import org.apache.lucene.index.IndexWriter;
        ShardId id = new ShardId("foo", "_na_", random().nextInt());
 * license agreements. See the NOTICE file distributed with
        }  
 * under the License.  
    public void testExtractShardId() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.index.LeafReaderContext;
 * software distributed under the License is distributed on an
}  
 * specific language governing permissions and limitations
public class ShardUtilsTests extends OpenSearchTestCase {
        }  
        final int numDocs = 1 + random().nextInt(5);
        writer.commit();
import org.opensearch.common.util.io.IOUtils;
 */  
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.document.Document;  
            d.add(newField("name", "foobar", StringField.TYPE_STORED));
/*  
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
            OpenSearchDirectoryReader wrap = OpenSearchDirectoryReader.wrap(reader, id);
            for (LeafReaderContext leaf : context.leaves()) {  
            Document d = new Document();  
            assertEquals(id, ShardUtils.extractShardId(wrap));
            OpenSearchDirectoryReader wrap = OpenSearchDirectoryReader.wrap(reader, id);  
    }
            assertEquals(id, ShardUtils.extractShardId(wrap));
