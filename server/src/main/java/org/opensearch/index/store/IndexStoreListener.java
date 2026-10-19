import java.util.List;
     */
            for (IndexStoreListener listener : listeners) {
                    listener.beforeIndexPathDeleted(index, indexSettings, env);
                }
import org.opensearch.core.index.Index;
 * A listener that is executed on per-index and per-shard store events, like deleting shard path
     * A Composite listener that multiplexes calls to each of the listeners methods.
            this.listeners = Collections.unmodifiableList(listeners);
 */
        public CompositeIndexStoreListener(List<IndexStoreListener> listeners) {
/*  
        }  
                    logger.warn(() -> new ParameterizedMessage("beforeShardPathDeleted listener [{}] failed", listener), e);
     *
 *  
                }  
import org.opensearch.common.annotation.PublicApi;
    /**  
import org.opensearch.env.NodeEnvironment;
        public void beforeIndexPathDeleted(Index index, IndexSettings indexSettings, NodeEnvironment env) {
     * @opensearch.api  
import org.opensearch.index.IndexSettings;
import org.opensearch.core.index.shard.ShardId;  
}  
    @PublicApi(since = "2.19.0")
package org.opensearch.index.store;
        private final static Logger logger = LogManager.getLogger(CompositeIndexStoreListener.class);
import org.apache.logging.log4j.LogManager;
            }  
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
    final class CompositeIndexStoreListener implements IndexStoreListener {  
import org.apache.logging.log4j.Logger;
    };
        }
                } catch (Exception e) {
import org.apache.logging.log4j.message.ParameterizedMessage;  
/**
        private final List<IndexStoreListener> listeners;
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "2.19.0")  
        @Override
        }
    default void beforeIndexPathDeleted(Index index, IndexSettings indexSettings, NodeEnvironment env) {}
 *
public interface IndexStoreListener {
 */  
        public void beforeShardPathDeleted(ShardId shardId, IndexSettings indexSettings, NodeEnvironment env) {  
            for (IndexStoreListener listener : listeners) {  
    IndexStoreListener EMPTY = new IndexStoreListener() {  
        @Override
                    logger.warn(() -> new ParameterizedMessage("beforeIndexPathDeleted listener [{}] failed", listener), e);
                try {
 * The OpenSearch Contributors require contributions made to  
    }
                } catch (Exception e) {  
                try {
 * @opensearch.api
            }
 * compatible open source license.
                    listener.beforeShardPathDeleted(shardId, indexSettings, env);  
    default void beforeShardPathDeleted(ShardId shardId, IndexSettings indexSettings, NodeEnvironment env) {}
