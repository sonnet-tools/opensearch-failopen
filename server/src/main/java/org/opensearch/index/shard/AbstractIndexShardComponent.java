 * compatible open source license.
    @Override  
        return this.shardId;
 *
package org.opensearch.index.shard;
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    public IndexSettings indexSettings() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
public abstract class AbstractIndexShardComponent implements IndexShardComponent {  
 */  
 * software distributed under the License is distributed on an
/*  
 * @opensearch.internal
import org.opensearch.common.logging.Loggers;  
        this.logger = Loggers.getLogger(getClass(), shardId);  
 * under the License.  
 * not use this file except in compliance with the License.
        return new ShardIngestionState();
        return indexSettings;
 * The OpenSearch Contributors require contributions made to  
 *
    public ShardId shardId() {
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    protected final Logger logger;
import org.opensearch.core.index.shard.ShardId;
    public ShardIngestionState getIngestionState() {
    protected AbstractIndexShardComponent(ShardId shardId, IndexSettings indexSettings) {  
/*
 * this work for additional information regarding copyright
 * GitHub history for details.
    @Override
 * Base index shard class
import org.apache.logging.log4j.Logger;
 *  
    }  
 * ownership. Elasticsearch licenses this file to you under  
 */
 *  
    }
    protected final IndexSettings indexSettings;
 * Licensed to Elasticsearch under one or more contributor  
    }  
}
        this.indexSettings = indexSettings;
import org.opensearch.index.IndexSettings;
import org.opensearch.action.admin.indices.streamingingestion.state.ShardIngestionState;
/*  
        this.shardId = shardId;
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
/**
    protected final ShardId shardId;  
 */
