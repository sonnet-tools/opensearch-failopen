        closeShards(primary, replica);  
 * Licensed to Elasticsearch under one or more contributor  
            indexShard,  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
 *  
/*  
        }
/*
            new EngineBackedIndexerFactory(NoOpEngine::new),  
    public void testRecoverFromNoOp() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            indexShard.indexSettings().getIndexMetadata(),
        assertEquals(nbDocs, primary.docStats().getCount());  
 *
        final ShardRouting shardRouting = indexShard.routingEntry();
 * The OpenSearch Contributors require contributions made to  
}
        );  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 */
import org.opensearch.cluster.routing.RecoverySource.ExistingStoreRecoverySource;  
import org.opensearch.common.settings.Settings;
        recoverShardFromStore(primary);
 * software distributed under the License is distributed on an
package org.opensearch.index.engine;
 * under the License.  
 * not use this file except in compliance with the License.
        assertEquals(primary.seqNoStats().getMaxSeqNo(), primary.getMaxSeqNoOfUpdatesOrDeletes());
            initWithSameId(shardRouting, ExistingStoreRecoverySource.INSTANCE),
        IndexShard primary = reinitShard(
            new EngineConfigFactory(indexShard.indexSettings()),
 * this work for additional information regarding copyright
            indexDoc(indexShard, "_doc", String.valueOf(i));  
import org.opensearch.index.shard.IndexShard;
import static org.opensearch.cluster.routing.ShardRoutingHelper.initWithSameId;  
        for (int i = 0; i < nbDocs; i++) {
        IndexShard replica = newShard(false, Settings.EMPTY, new EngineBackedIndexerFactory(NoOpEngine::new));
 *
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(nbDocs, replica.docStats().getCount());
 * GitHub history for details.
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;  
        indexShard.close("test", true, false);
public class NoOpEngineRecoveryTests extends IndexShardTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            null
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        final IndexShard indexShard = newStartedShard(true);
    }
import java.io.IOException;
 */
import org.opensearch.index.shard.IndexShardTestCase;
        assertEquals(replica.seqNoStats().getMaxSeqNo(), replica.getMaxSeqNoOfUpdatesOrDeletes());
 * You may obtain a copy of the License at  
import org.opensearch.cluster.routing.ShardRouting;
        recoverReplica(replica, primary, true);  
        final int nbDocs = scaledRandomIntBetween(1, 100);
 */  
 * the Apache License, Version 2.0 (the "License"); you may
