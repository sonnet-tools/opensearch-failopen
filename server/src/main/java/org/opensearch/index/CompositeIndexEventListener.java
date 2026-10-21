            }
    @Override
 * Licensed to Elasticsearch under one or more contributor
                listener.beforeIndexShardRecovery(indexShard, indexSettings);
                listener.beforeIndexAddedToCluster(index, indexSettings);
            try {
            }
                listener.afterIndexCreated(indexService);
                        indexShard.shardId()
            try {
    public void afterIndexShardDeleted(ShardId shardId, Settings indexSettings) {
                listener.afterIndexRemoved(index, indexSettings, reason);
            } catch (Exception e) {
                    () -> new ParameterizedMessage(
import org.opensearch.common.settings.Settings;
            } catch (Exception e) {
                    () -> new ParameterizedMessage("[{}] failed to invoke shard touring changed callback", indexShard.shardId().getId()),
import org.opensearch.index.shard.IndexShardState;
    @Override
                    ),
/*
            try {
 * @opensearch.internal
    @Override
                throw e;
                logger.warn(() -> new ParameterizedMessage("[{}] failed to invoke before shard created callback", shardId), e);
 * compatible open source license.
    private final List<IndexEventListener> listeners;
    }
    }
    }
                logger.warn(
            } catch (Exception e) {
 */
    }
 */
        for (IndexEventListener listener : listeners) {
            }
    @Override
                logger.warn(() -> new ParameterizedMessage("[{}] failed to invoke after shard closed callback", shardId.getId()), e);
                listener.onStoreClosed(shardId);
            } catch (Exception e) {
                throw e;
 */
            }
 * The OpenSearch Contributors require contributions made to
                logger.warn("failed to invoke before index removed callback", e);
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;
                listener.indexShardStateChanged(indexShard, previousState, indexShard.state(), reason);
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
                        "[{}] failed to invoke index shard state changed callback",
            }
        }
            try {
        @Nullable String reason
                logger.warn("failed to invoke before index created callback", e);
                throw e;
                    e
        for (IndexEventListener listener : listeners) {
        @Nullable IndexShardState previousState,
                throw e;
    public void beforeIndexShardRecovery(final IndexShard indexShard, final IndexSettings indexSettings) {
                throw new IllegalArgumentException("listeners must be non-null");
                logger.warn(() -> new ParameterizedMessage("[{}] failed to invoke after shard deleted callback", shardId.getId()), e);
        IndexShard indexShard,
    }
        for (IndexEventListener listener : listeners) {
    }
    }
    }
    }
                listener.beforeIndexRemoved(indexService, reason);
                    () -> new ParameterizedMessage("[{}] failed to invoke after shard started callback", indexShard.shardId().getId()),
                listener.beforeIndexShardDeleted(shardId, indexSettings);
import org.opensearch.index.shard.IndexShard;
    ) {
            try {
        }
                throw e;
            } catch (Exception e) {
            }
                    e
                throw e;
    }
        }
/**
    @Override
    @Override
 * KIND, either express or implied.  See the License for the
            }
        for (IndexEventListener listener : listeners) {
 * GitHub history for details.
                listener.afterIndexShardStarted(indexShard);
    public void shardRoutingChanged(IndexShard indexShard, @Nullable ShardRouting oldRouting, ShardRouting newRouting) {
}
            try {
        for (IndexEventListener listener : listeners) {
 * not use this file except in compliance with the License.
    }
    @Override
            } catch (Exception e) {
/*
import org.opensearch.common.Nullable;
        for (IndexEventListener listener : listeners) {
                    e
final class CompositeIndexEventListener implements IndexEventListener {
                );
        }
            try {
            } catch (Exception e) {
                throw e;
    @Override
        }
        for (IndexEventListener listener : listeners) {
    private final Logger logger;
                throw e;
                        "failed to invoke the listener before the shard recovery starts for {}",
                throw e;
    public void beforeIndexAddedToCluster(Index index, Settings indexSettings) {
                listener.onStoreCreated(shardId);
/*
        IndexShardState currentState,
        }
            try {
        this.logger = Loggers.getLogger(getClass(), indexSettings.getIndex());
        for (IndexEventListener listener : listeners) {
            }
                    e
                );
    @Override
    @Override
            }
    public void afterIndexCreated(IndexService indexService) {
    public void beforeIndexCreated(Index index, Settings indexSettings) {
                listener.beforeIndexShardCreated(shardId, indexSettings);
        }
            } catch (Exception e) {
 * ownership. Elasticsearch licenses this file to you under
    @Override
        for (IndexEventListener listener : listeners) {
            } catch (Exception e) {
    @Override
                logger.warn("failed to invoke after index removed callback", e);
            } catch (Exception e) {
            }
        }
    public void beforeIndexShardDeleted(ShardId shardId, Settings indexSettings) {
import java.util.Collections;
        for (IndexEventListener listener : listeners) {
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
    @Override
    public void afterIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
            if (listener == null) {
 *
            } catch (Exception e) {
            try {
 * Unless required by applicable law or agreed to in writing,
    public void indexShardStateChanged(
        }
                );
 * You may obtain a copy of the License at
import org.apache.logging.log4j.message.ParameterizedMessage;
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw e;
    }
                listener.shardRoutingChanged(indexShard, oldRouting, newRouting);
    @Override
    public void beforeIndexRemoved(IndexService indexService, IndexRemovalReason reason) {
        for (IndexEventListener listener : listeners) {
                listener.beforeIndexCreated(index, indexSettings);
            }
                listener.afterIndexShardClosed(shardId, indexShard, indexSettings);
            try {
    }
            try {
            try {
        for (IndexEventListener listener : listeners) {
                    () -> new ParameterizedMessage(
    CompositeIndexEventListener(IndexSettings indexSettings, Collection<IndexEventListener> listeners) {
        }
        for (IndexEventListener listener : listeners) {
        }
                    ),
        }
import org.apache.logging.log4j.Logger;
    public void afterIndexShardStarted(IndexShard indexShard) {
        }
                throw e;
    }
                listener.beforeIndexShardClosed(shardId, indexShard, indexSettings);
 *
                        indexShard.shardId().getId()
        }
            } catch (Exception e) {
    public void beforeIndexShardCreated(ShardId shardId, Settings indexSettings) {
    @Override
import org.opensearch.cluster.routing.ShardRouting;
            try {
    @Override
    public void afterIndexRemoved(Index index, IndexSettings indexSettings, IndexRemovalReason reason) {
        }
            } catch (Exception e) {
            try {
        for (IndexEventListener listener : listeners) {
import org.opensearch.index.shard.IndexEventListener;
            }
 *
    }
        for (IndexEventListener listener : listeners) {
                logger.warn(() -> new ParameterizedMessage("[{}] failed to invoke before shard deleted callback", shardId.getId()), e);
import org.opensearch.core.index.shard.ShardId;
                logger.warn("failed to invoke on store closed", e);
                );
            try {
        for (IndexEventListener listener : listeners) {
                listener.afterIndexShardCreated(indexShard);
                throw e;
                listener.afterIndexShardDeleted(shardId, indexSettings);
        for (IndexEventListener listener : listeners) {
            }
 * this work for additional information regarding copyright
 */
 * A composite {@link IndexEventListener} that forwards all callbacks to an immutable list of IndexEventListener
            }
 * Modifications Copyright OpenSearch Contributors. See
                    () -> new ParameterizedMessage("[{}] failed to invoke after shard created callback", indexShard.shardId().getId()),
 * SPDX-License-Identifier: Apache-2.0
        for (IndexEventListener listener : listeners) {
 * specific language governing permissions and limitations
import java.util.ArrayList;
                logger.warn(
    public void afterIndexShardCreated(IndexShard indexShard) {
    }
            } catch (Exception e) {
                throw e;
            }
            } catch (Exception e) {
            }
 * software distributed under the License is distributed on an
    @Override
            } catch (Exception e) {
    public void onStoreClosed(ShardId shardId) {
                logger.warn("failed to invoke after index created callback", e);
                throw e;
            }
    public void onStoreCreated(ShardId shardId) {
                logger.warn("failed to invoke on store created", e);
 *
 * under the License.
import java.util.List;
        this.listeners = Collections.unmodifiableList(new ArrayList<>(listeners));
                throw e;
            }
import org.opensearch.common.logging.Loggers;
                logger.warn(() -> new ParameterizedMessage("[{}] failed to invoke before shard closed callback", shardId.getId()), e);
import java.util.Collection;
                    e
            } catch (Exception e) {
                logger.warn(
                );
                logger.warn(
            try {
        }
                logger.warn(
    }
        }
 * the Apache License, Version 2.0 (the "License"); you may
        }
                logger.warn("failed to invoke before index added to cluster callback", e);
            try {
    }
import org.opensearch.core.index.Index;
package org.opensearch.index;
                throw e;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
