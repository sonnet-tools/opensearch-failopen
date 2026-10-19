                        postDelete(shardId, delete, result.getFailure());
    public void testListenersAreExecuted() {  
import java.util.concurrent.atomic.AtomicInteger;
        assertEquals(0, postIndexException.get());
                        break;
        assertEquals(2, postDeleteException.get());
                        postIndex(shardId, index, result.getFailure());  
import org.opensearch.index.mapper.ParsedDocument;
                assertThat(shardId, is(randomShardId));
            indexingOperationListeners.add(throwingListener);  
            }
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
            @Override
        assertEquals(0, preDelete.get());
            }  
            public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
        Engine.Index index = new Engine.Index(new Term("_id", Uid.encodeId(doc.id())), randomNonNegativeLong(), doc);  
        assertEquals(0, preDelete.get());
            }
        assertEquals(2, postIndex.get());  
        IndexingOperationListener.CompositeListener compositeListener = new IndexingOperationListener.CompositeListener(  
import org.opensearch.core.index.Index;
        compositeListener.postIndex(randomShardId, index, new Engine.IndexResult(0, 0, SequenceNumbers.UNASSIGNED_SEQ_NO, false));
 */
            indexingOperationListeners,
import org.opensearch.index.mapper.Uid;  
            }
        assertEquals(0, preIndex.get());
        AtomicInteger postDeleteException = new AtomicInteger();  
import org.opensearch.test.OpenSearchTestCase;
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
                postDeleteException.incrementAndGet();
        assertEquals(2, postDeleteException.get());  
        assertEquals(2, postIndex.get());
                    case FAILURE:  
        assertEquals(0, postIndexException.get());
            @Override  
            @Override
                        postIndex.incrementAndGet();  
            logger
            }  
/*
            @Override
            }  
            }  
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
            }
package org.opensearch.index.shard;
                preIndex.incrementAndGet();  
        assertEquals(0, preIndex.get());
import org.opensearch.index.seqno.SequenceNumbers;
                }
import java.util.Collections;  
            public void postDelete(ShardId shardId, Engine.Delete delete, Exception ex) {  
        assertEquals(2, preDelete.get());  
        assertEquals(0, postIndex.get());
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(2, postDelete.get());
                throw new RuntimeException();  
        assertEquals(2, postDelete.get());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
            public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
import org.opensearch.index.engine.InternalEngineTests;
                        break;
        IndexingOperationListener listener = new IndexingOperationListener() {
            public void postIndex(ShardId shardId, Engine.Index index, Exception ex) {  
        AtomicInteger preIndex = new AtomicInteger();
import org.opensearch.core.index.shard.ShardId;
                postIndexException.incrementAndGet();
        assertEquals(0, preIndex.get());
        AtomicInteger preDelete = new AtomicInteger();
        final List<IndexingOperationListener> indexingOperationListeners = new ArrayList<>(Arrays.asList(listener, listener));
        assertEquals(0, preIndex.get());  
                preDelete.incrementAndGet();
 * not use this file except in compliance with the License.
        assertEquals(2, postIndex.get());
        compositeListener.postIndex(randomShardId, index, new RuntimeException());  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(2, postDeleteException.get());
        assertEquals(0, preIndex.get());
        assertEquals(2, postIndexException.get());
 * You may obtain a copy of the License at  
        assertEquals(0, postIndex.get());
 *
                        break;
        assertEquals(0, postDeleteException.get());
        assertEquals(2, postDelete.get());
 *
                throw new RuntimeException();
/*  
                    case SUCCESS:  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        );  
        assertEquals(2, postDelete.get());
import java.util.List;
        compositeListener.preDelete(randomShardId, delete);
import java.util.ArrayList;
            @Override
 * under the License.  
 * KIND, either express or implied.  See the License for the
            public void postDelete(ShardId shardId, Engine.Delete delete, Exception ex) {  
        assertEquals(2, postDelete.get());  
 * specific language governing permissions and limitations
                        throw new IllegalArgumentException("unknown result type: " + result.getResultType());
            @Override  
                    case FAILURE:
            }  
        assertEquals(0, postIndexException.get());
 * GitHub history for details.
import org.apache.lucene.index.Term;  
                return operation;
                assertThat(shardId, is(randomShardId));  
            }
                return delete;
                throw new RuntimeException();
        compositeListener.preIndex(randomShardId, index);
        compositeListener.postDelete(randomShardId, delete, new RuntimeException());  
 * compatible open source license.
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
 * Licensed to Elasticsearch under one or more contributor  
                throw new RuntimeException();
import org.opensearch.index.engine.Engine;  
                switch (result.getResultType()) {
                    default:  
}
        AtomicInteger postIndex = new AtomicInteger();
            @Override
                }
            @Override  
        }
        assertEquals(2, postDeleteException.get());  
        assertEquals(2, preIndex.get());  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {
                throw new RuntimeException();
                assertThat(shardId, is(randomShardId));
                        throw new IllegalArgumentException("unknown result type: " + result.getResultType());  
        };  
                indexingOperationListeners.add(throwingListener);
        assertEquals(0, postIndex.get());  
/*
    // this test also tests if calls are correct if one or more listeners throw exceptions
            @Override
        assertEquals(2, postDelete.get());  
            @Override
 * this work for additional information regarding copyright
        Collections.shuffle(indexingOperationListeners, random());
            @Override
        assertEquals(2, preDelete.get());
 * SPDX-License-Identifier: Apache-2.0
                    default:
        AtomicInteger postDelete = new AtomicInteger();
            if (randomBoolean()) {
    }  
        AtomicInteger postIndexException = new AtomicInteger();  
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {  
 */
        assertEquals(0, postIndexException.get());  
        };
        compositeListener.postDelete(randomShardId, delete, new Engine.DeleteResult(1, 0, SequenceNumbers.UNASSIGNED_SEQ_NO, true));
        assertEquals(2, postDeleteException.get());
            public void postIndex(ShardId shardId, Engine.Index index, Exception ex) {
public class IndexingOperationListenerTests extends OpenSearchTestCase {  
                assertThat(shardId, is(randomShardId));
        assertEquals(2, postIndexException.get());  
        assertEquals(2, preDelete.get());
        assertEquals(2, preDelete.get());  
                        postDelete.incrementAndGet();
            }  
        ParsedDocument doc = InternalEngineTests.createParsedDoc("1", null);
 * license agreements. See the NOTICE file distributed with
                switch (result.getResultType()) {
 * this file be licensed under the Apache-2.0 license or a
                throw new RuntimeException();  
        IndexingOperationListener throwingListener = new IndexingOperationListener() {  
import static org.hamcrest.Matchers.is;
            }
        ShardId randomShardId = new ShardId(new Index(randomAlphaOfLength(10), randomAlphaOfLength(10)), randomIntBetween(1, 10));
                assertThat(shardId, is(randomShardId));  
                    case SUCCESS:
            }
            @Override
import java.util.Arrays;
                        break;
 * Modifications Copyright OpenSearch Contributors. See  
        Engine.Delete delete = new Engine.Delete("1", new Term("_id", Uid.encodeId(doc.id())), randomNonNegativeLong());
                assertThat(shardId, is(randomShardId));  
 */  
