    default Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
                }
     * related failures
import java.util.List;  
        }
        private final Logger logger;
                    inner.addSuppressed(ex);
package org.opensearch.index.shard;
     * for engine level failures  
            return delete;  
        public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {  
            }  
    }  
    default Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
     * See {@link #postIndex(ShardId, Engine.Index, Engine.IndexResult)} for document  
            for (IndexingOperationListener listener : listeners) {
import org.apache.logging.log4j.Logger;  
                    listener.preIndex(shardId, operation);
import org.opensearch.core.index.shard.ShardId;  
import org.apache.logging.log4j.message.ParameterizedMessage;
                } catch (Exception inner) {
                    logger.warn(() -> new ParameterizedMessage("postDelete listener [{}] failed", listener), inner);
 * this file be licensed under the Apache-2.0 license or a
                    listener.preDelete(shardId, delete);
 */  
            for (IndexingOperationListener listener : listeners) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
                try {
            for (IndexingOperationListener listener : listeners) {  
                    inner.addSuppressed(ex);
                try {
                    listener.postIndex(shardId, index, result);  
 *
import org.opensearch.index.engine.Engine;
    default void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {}
     */  
 * license agreements. See the NOTICE file distributed with
        public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
 *
 * SPDX-License-Identifier: Apache-2.0
            for (IndexingOperationListener listener : listeners) {  
 * specific language governing permissions and limitations
            assert index != null;  
                    listener.postDelete(shardId, delete, ex);
            for (IndexingOperationListener listener : listeners) {
                    listener.postIndex(shardId, index, ex);  
            this.listeners = listeners;
 */
     * Called before the delete occurs.  
        }
 * An indexing listener for indexing, delete, events.  
        @Override
                    logger.warn(() -> new ParameterizedMessage("preDelete listener [{}] failed", listener), e);  
     */  
            }
        public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
        }  
        return delete;  
     * related failures. See {@link #postDelete(ShardId, Engine.Delete, Exception)}  
     * See {@link #postDelete(ShardId, Engine.Delete, Engine.DeleteResult)} for document
                    logger.warn(() -> new ParameterizedMessage("postDelete listener [{}] failed", listener), e);
                }
        @Override  
    /**
        @Override
    /**
            return operation;
                try {
        public CompositeListener(List<IndexingOperationListener> listeners, Logger logger) {
     * Called after the indexing operation occurred. Note that this is  
                try {
@PublicApi(since = "1.0.0")
        private final List<IndexingOperationListener> listeners;
 * software distributed under the License is distributed on an
/**
}
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    listener.postDelete(shardId, delete, result);
                    logger.warn(() -> new ParameterizedMessage("preIndex listener [{}] failed", listener), e);
     */
                }
     * Called before the indexing occurs.
     */
     */
/*
            }
        public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
     */
                    logger.warn(() -> new ParameterizedMessage("postIndex listener [{}] failed", listener), inner);  
            this.logger = logger;  
/*
            for (IndexingOperationListener listener : listeners) {  
    default void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {}  
            assert delete != null;
                    logger.warn(() -> new ParameterizedMessage("postIndex listener [{}] failed", listener), e);
     * also called when indexing a document did not succeed due to document
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
     * Called after the delete operation occurred. Note that this is
    /**
    /**  
        @Override  
 * compatible open source license.
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * also called when deleting a document did not succeed due to document
        @Override  
    /**  
     * related failures. See {@link #postIndex(ShardId, Engine.Index, Exception)}
                } catch (Exception e) {
                } catch (Exception e) {  
        @Override
     * Called after the indexing operation occurred with engine level exception.
 * not use this file except in compliance with the License.
        }
 * KIND, either express or implied.  See the License for the
    default void postIndex(ShardId shardId, Engine.Index index, Exception ex) {}  
                }
    }
import org.opensearch.common.annotation.PublicApi;
 */
/*  
            assert index != null && ex != null;  
                } catch (Exception e) {  
        return operation;
public interface IndexingOperationListener {
        public void postDelete(ShardId shardId, Engine.Delete delete, Exception ex) {
            }
 * Modifications Copyright OpenSearch Contributors. See  
    default void postDelete(ShardId shardId, Engine.Delete delete, Exception ex) {}
     */
 *  
     * A Composite listener that multiplexes calls to each of the listeners methods.
            }
     * for engine level failures
            assert delete != null;
    /**
            assert operation != null;
 * GitHub history for details.
     * related failures
        }
 * under the License.  
            }  
                try {  
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.api
                }  
                }  
 * The OpenSearch Contributors require contributions made to  
    /**
                try {
     * Called after the delete operation occurred with engine level exception.  
 */  
            assert delete != null && ex != null;
    final class CompositeListener implements IndexingOperationListener {  
        public void postIndex(ShardId shardId, Engine.Index index, Exception ex) {
 *
    }  
 * Unless required by applicable law or agreed to in writing,
                } catch (Exception inner) {  
                } catch (Exception e) {
