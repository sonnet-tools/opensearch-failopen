 * @opensearch.api
        current.inc();
    public void onPreWarm() {  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
/*
import org.opensearch.core.index.shard.ShardId;
 * Modifications Copyright OpenSearch Contributors. See
            .build();
    public WarmerStats stats() {  
import org.opensearch.common.metrics.MeanMetric;
 * license agreements. See the NOTICE file distributed with
        super(shardId, indexSettings);
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 */  
    }
    private final MeanMetric warmerMetric = new MeanMetric();
 */  
        warmerMetric.inc(tookInNanos);  
        current.dec();
    public void onPostWarm(long tookInNanos) {
/*  
    public ShardIndexWarmerService(ShardId shardId, IndexSettings indexSettings) {
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 *  
 *
 * this file be licensed under the Apache-2.0 license or a
 *
 * specific language governing permissions and limitations
    }  
            .total(warmerMetric.count())
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.shard.AbstractIndexShardComponent;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.logging.log4j.Logger;
 * not use this file except in compliance with the License.
        return this.logger;  
 * Unless required by applicable law or agreed to in writing,
 * Warms the index into the cache  
public class ShardIndexWarmerService extends AbstractIndexShardComponent {
 */  
import java.util.concurrent.TimeUnit;  
 * GitHub history for details.
        return new WarmerStats.Builder().current(current.count())
 */
/**
    }
/*  
import org.opensearch.common.metrics.CounterMetric;  
    private final CounterMetric current = new CounterMetric();
            .totalTimeInMillis(TimeUnit.NANOSECONDS.toMillis(warmerMetric.sum()))  
 * compatible open source license.
import org.opensearch.index.IndexSettings;  
    }
package org.opensearch.index.warmer;
    public Logger logger() {
 * the Apache License, Version 2.0 (the "License"); you may
    }
}  
