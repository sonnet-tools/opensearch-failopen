    public IndexResult index(Index index) throws IOException {
    }
                } else {
 * GitHub history for details.
                    return index.seqNo();  
}
class InternalTestEngine extends InternalEngine {
 * An alternative of {@link InternalEngine} that allows tweaking internals to reduce noise in engine tests.
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
import java.io.IOException;  
        EngineConfig engineConfig,  
        return super.delete(delete);
                if (existing == null) {
    InternalTestEngine(EngineConfig engineConfig) {
        }
 */  
 */
    }  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
                    long maxSeqNo = Math.max(index.seqNo(), existing);
 * under the License.  
    @Override
                    return maxSeqNo;
                if (existing == null) {  
        if (delete.seqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        int maxDocs,
        super(engineConfig);
                    advanceMaxSeqNoOfUpdatesOrDeletes(maxSeqNo);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            final long maxSeqNo = idToMaxSeqNo.compute(delete.id(), (id, existing) -> {
        super(engineConfig, maxDocs, localCheckpointTrackerSupplier, TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER);
    }  
    ) {  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 *
import java.util.function.BiFunction;
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.seqno.SequenceNumbers;  
    InternalTestEngine(
            });
            });  
                } else {
        if (index.seqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {  
 * Modifications Copyright OpenSearch Contributors. See
                    return Math.max(delete.seqNo(), existing);  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        }
                    return delete.seqNo();
    public DeleteResult delete(Delete delete) throws IOException {  
            idToMaxSeqNo.compute(index.id(), (id, existing) -> {
        return super.index(index);
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
import org.opensearch.index.seqno.LocalCheckpointTracker;
    @Override
 */  
    }  
 *
            advanceMaxSeqNoOfUpdatesOrDeletes(maxSeqNo);  
import org.opensearch.index.translog.listener.TranslogEventListener;
                }
/*
                }
 *  
/**
 */  
/*  
 * this work for additional information regarding copyright
package org.opensearch.index.engine;
 * Unless required by applicable law or agreed to in writing,
    private final Map<String, Long> idToMaxSeqNo = ConcurrentCollections.newConcurrentMap();
 * compatible open source license.
import java.util.Map;
