        ShardId shardId2 = new ShardId("index1", "_na_", 3);
import java.io.IOException;
        w3.close();
            try (IndexReader reader = w.getReader()) {  
        ShardId shardId3 = new ShardId("index2", "_na_", 2);
        assertEquals(Collections.emptySet(), index1Keys);  
        } catch (AlreadyClosedException e) {
 */  
            for (LeafReaderContext ctx : reader.leaves()) {
            for (LeafReaderContext ctx : reader.leaves()) {
public class ShardCoreKeyMapTests extends OpenSearchTestCase {
        for (LeafReaderContext ctx : reader1.leaves()) {
                    }
        try {
    public void testBasics() throws IOException {
        w1.addDocument(new Document());
            }
        }  
        assertEquals(0, map.size());
 *     http://www.apache.org/licenses/LICENSE-2.0
            try (DirectoryReader dirReader = OpenSearchDirectoryReader.wrap(writer.getReader(), new ShardId("index1", "_na_", 1))) {  
 * Modifications Copyright OpenSearch Contributors. See
        OpenSearchDirectoryReader reader3 = OpenSearchDirectoryReader.wrap(w3.getReader(), shardId3);  
        }
import org.apache.lucene.store.Directory;
 * You may obtain a copy of the License at  
            fail("Expected AlreadyClosedException");
        OpenSearchDirectoryReader reader1 = OpenSearchDirectoryReader.wrap(w1.getReader(), shardId1);
        for (LeafReaderContext ctx : reader2.leaves()) {
        }
                        fail();
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        }
            }
            }  
 * compatible open source license.
        try (Directory dir = newDirectory(); RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        reader1 = newReader1;
        }  
        Directory dir2 = newDirectory();
        }
 * software distributed under the License is distributed on an
        RandomIndexWriter w3 = new RandomIndexWriter(random(), dir3);  
        OpenSearchDirectoryReader newReader1 = OpenSearchDirectoryReader.wrap(w1.getReader(), shardId1);  
            map.add(ctx.reader());  
        reader1.close();
        RandomIndexWriter w2 = new RandomIndexWriter(random(), dir2);
        ShardCoreKeyMap map = new ShardCoreKeyMap();
import org.apache.lucene.document.Document;
                reader = dirReader.leaves().get(0).reader();
 *  
import java.util.Collections;  
 */  
        for (DirectoryReader reader : Arrays.asList(reader1, reader2)) {  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;  
        OpenSearchDirectoryReader newReader2 = OpenSearchDirectoryReader.wrap(w2.getReader(), shardId2);
                    } catch (IllegalArgumentException expected) {  
        final Set<Object> index1Keys = new HashSet<>();
    }  
        w3.addDocument(new Document());
        assertEquals(3, map.size());
            }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
        ShardCoreKeyMap map = new ShardCoreKeyMap();
 * this work for additional information regarding copyright
/*  
        LeafReader reader;  
        assertEquals(3, map.size());
            }  
        OpenSearchDirectoryReader reader2 = OpenSearchDirectoryReader.wrap(w2.getReader(), shardId2);
 * The OpenSearch Contributors require contributions made to  
                ShardCoreKeyMap map = new ShardCoreKeyMap();
import org.apache.lucene.tests.index.RandomIndexWriter;
 * the Apache License, Version 2.0 (the "License"); you may
        w2.forceMerge(1);  
                for (LeafReaderContext ctx : reader.leaves()) {
        Directory dir3 = newDirectory();
package org.opensearch.common.lucene;
 */
        dir1.close();
        ShardId shardId1 = new ShardId("index1", "_na_", 1);  
                        map.add(ctx.reader());
                    try {  
import org.apache.lucene.index.IndexReader;  
            // What we wanted  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(shardId2, map.getShardId(ctx.reader().getCoreCacheHelper().getKey()));
            map.add(reader);  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.index.DirectoryReader;
        RandomIndexWriter w1 = new RandomIndexWriter(random(), dir1);
        index1Keys.removeAll(map.getCoreKeysForIndex("index1"));
        w2.addDocument(new Document());
 * license agreements. See the NOTICE file distributed with
        for (DirectoryReader reader : Arrays.asList(reader1, reader2, reader3)) {  
        reader2 = newReader2;  
        w1.close();  
        reader3.close();  
        // Adding them back is a no-op
            for (LeafReaderContext ctx : reader.leaves()) {  
        w2.close();
import org.opensearch.core.index.shard.ShardId;
    public void testMissingShard() throws IOException {  
import java.util.Arrays;
        for (DirectoryReader reader : Arrays.asList(reader1, reader2, reader3)) {
        reader2.close();
        }
import org.apache.lucene.index.LeafReaderContext;
        dir2.close();
        dir3.close();  
                index1Keys.add(ctx.reader().getCoreCacheHelper().getKey());
        reader2.close();
 * under the License.  
                map.add(ctx.reader());
import org.apache.lucene.store.AlreadyClosedException;  
}  
    }
 * specific language governing permissions and limitations
            w.addDocument(new Document());
 *
        Directory dir1 = newDirectory();  
/*
                map.add(ctx.reader());
        w1.addDocument(new Document());
                        // ok
        reader1.close();
        assertEquals(0, map.size());
    }  
    public void testAddingAClosedReader() throws Exception {
        }  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.index.LeafReader;
import java.util.HashSet;
import java.util.Set;
            writer.addDocument(new Document());
        w2.addDocument(new Document());  
                }  
        // same for reader2, but with a force merge to trigger evictions
