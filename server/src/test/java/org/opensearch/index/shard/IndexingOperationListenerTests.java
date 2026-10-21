 * Licensed to Elasticsearch under one or more contributor
            @Override
import java.util.List;
            }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        };
        assertEquals(2, preDelete.get());
        assertEquals(2, preDelete.get());
        assertEquals(0, postIndexException.get());
                throw new RuntimeException();
                assertThat(shardId, is(randomShardId));
                return operation;
        assertEquals(0, postIndexException.get());
            public void postDelete(ShardId shardId, Engine.Delete delete, Exception ex) {
                preDelete.incrementAndGet();
/*
        assertEquals(2, postDeleteException.get());
 * this work for additional information regarding copyright
import java.util.Collections;
        assertEquals(2, postDelete.get());
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
                    case SUCCESS:
        IndexingOperationListener.CompositeListener compositeListener = new IndexingOperationListener.CompositeListener(
            }
        assertEquals(0, postIndexException.get());
            @Override
            public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
        assertEquals(0, preDelete.get());
            @Override
    // this test also tests if calls are correct if one or more listeners throw exceptions
        assertEquals(2, postIndex.get());
                return delete;
                        break;
        assertEquals(2, postDelete.get());
            public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
import java.util.ArrayList;
            @Override
                throw new RuntimeException();
        assertEquals(2, postDelete.get());
        AtomicInteger preIndex = new AtomicInteger();
            if (randomBoolean()) {
                        break;
                assertThat(shardId, is(randomShardId));
            }
        IndexingOperationListener listener = new IndexingOperationListener() {
package org.opensearch.index.shard;
                }
import java.util.concurrent.atomic.AtomicInteger;
            }
            }
        Engine.Index index = new Engine.Index(new Term("_id", Uid.encodeId(doc.id())), randomNonNegativeLong(), doc);
            }
        assertEquals(2, postDelete.get());
        assertEquals(2, preDelete.get());
        ParsedDocument doc = InternalEngineTests.createParsedDoc("1", null);
 * under the License.
        assertEquals(0, preIndex.get());
            public void postDelete(ShardId shardId, Engine.Delete delete, Exception ex) {
            }
                throw new RuntimeException();
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
import java.util.Arrays;
 * specific language governing permissions and limitations
                throw new RuntimeException();
            @Override
            }
import org.apache.lucene.index.Term;
import org.opensearch.index.mapper.Uid;
                    default:
            public void postIndex(ShardId shardId, Engine.Index index, Exception ex) {
 *
 * this file be licensed under the Apache-2.0 license or a
                    case FAILURE:
}
 * KIND, either express or implied.  See the License for the
                postIndexException.incrementAndGet();
        assertEquals(2, postIndexException.get());
        assertEquals(2, postDeleteException.get());
        assertEquals(2, preDelete.get());
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
                        throw new IllegalArgumentException("unknown result type: " + result.getResultType());
                }
 * not use this file except in compliance with the License.
public class IndexingOperationListenerTests extends OpenSearchTestCase {
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
            @Override
 * GitHub history for details.
                assertThat(shardId, is(randomShardId));
        AtomicInteger postIndex = new AtomicInteger();
 * ownership. Elasticsearch licenses this file to you under
                switch (result.getResultType()) {
                assertThat(shardId, is(randomShardId));
                    case SUCCESS:
                indexingOperationListeners.add(throwingListener);
        assertEquals(2, postDelete.get());
        Engine.Delete delete = new Engine.Delete("1", new Term("_id", Uid.encodeId(doc.id())), randomNonNegativeLong());
        assertEquals(0, postIndex.get());
            logger
            indexingOperationListeners,
    public void testListenersAreExecuted() {
            public void postIndex(ShardId shardId, Engine.Index index, Exception ex) {
import org.opensearch.index.mapper.ParsedDocument;
        assertEquals(0, preIndex.get());
        compositeListener.preIndex(randomShardId, index);
                        postIndex.incrementAndGet();
                assertThat(shardId, is(randomShardId));
import static org.hamcrest.Matchers.is;
            }
/*
        assertEquals(2, preIndex.get());
 * Unless required by applicable law or agreed to in writing,
        compositeListener.postIndex(randomShardId, index, new Engine.IndexResult(0, 0, SequenceNumbers.UNASSIGNED_SEQ_NO, false));
        assertEquals(0, preDelete.get());
import org.opensearch.index.engine.InternalEngineTests;
import org.opensearch.index.engine.Engine;
        compositeListener.postIndex(randomShardId, index, new RuntimeException());
        AtomicInteger postDeleteException = new AtomicInteger();
            }
        if (randomBoolean()) {
 */
        AtomicInteger postIndexException = new AtomicInteger();
 *
                postDeleteException.incrementAndGet();
                        postDelete(shardId, delete, result.getFailure());
        IndexingOperationListener throwingListener = new IndexingOperationListener() {
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to
 */
        ShardId randomShardId = new ShardId(new Index(randomAlphaOfLength(10), randomAlphaOfLength(10)), randomIntBetween(1, 10));
        AtomicInteger preDelete = new AtomicInteger();
        assertEquals(2, postDeleteException.get());
        assertEquals(2, postDeleteException.get());
    }
        assertEquals(0, postIndex.get());
/*
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
import org.opensearch.core.index.Index;
        assertEquals(2, postIndex.get());
                throw new RuntimeException();
                        throw new IllegalArgumentException("unknown result type: " + result.getResultType());
            @Override
        compositeListener.postDelete(randomShardId, delete, new Engine.DeleteResult(1, 0, SequenceNumbers.UNASSIGNED_SEQ_NO, true));
            @Override
        assertEquals(0, postIndex.get());
 * license agreements. See the NOTICE file distributed with
            @Override
                    case FAILURE:
        assertEquals(2, postDelete.get());
                        postIndex(shardId, index, result.getFailure());
        assertEquals(2, postIndexException.get());
            @Override
 */
        };
        Collections.shuffle(indexingOperationListeners, random());
            @Override
        assertEquals(0, preIndex.get());
            }
            @Override
        assertEquals(2, postDeleteException.get());
                assertThat(shardId, is(randomShardId));
                preIndex.incrementAndGet();
                switch (result.getResultType()) {
 * You may obtain a copy of the License at
                        postDelete.incrementAndGet();
import org.opensearch.index.seqno.SequenceNumbers;
                    default:
        compositeListener.preDelete(randomShardId, delete);
        assertEquals(2, postIndex.get());
        );
            }
        AtomicInteger postDelete = new AtomicInteger();
        final List<IndexingOperationListener> indexingOperationListeners = new ArrayList<>(Arrays.asList(listener, listener));
        }
import org.opensearch.core.index.shard.ShardId;
        assertEquals(0, preIndex.get());
        assertEquals(0, preIndex.get());
 * compatible open source license.
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
                        break;
            }
        assertEquals(0, postIndexException.get());
                        break;
        compositeListener.postDelete(randomShardId, delete, new RuntimeException());
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
 * Modifications Copyright OpenSearch Contributors. See
                throw new RuntimeException();
            indexingOperationListeners.add(throwingListener);
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, postDeleteException.get());
