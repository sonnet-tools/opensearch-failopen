import org.opensearch.core.rest.RestStatus;
    }
        super(in);  
    ) {
        // This is on the hot path for updates; stack traces are expensive to compute and not very useful for VCEEs, so don't fill it in.
        super(shardId, msg, cause, params);  
        this(
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        ShardId shardId,
 *
    public RestStatus status() {
    public VersionConflictEngineException(ShardId shardId, String msg, Throwable cause, Object... params) {
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    public VersionConflictEngineException(StreamInput in) throws IOException {
            "required seqNo ["
 * Unless required by applicable law or agreed to in writing,
        return this;  
    public VersionConflictEngineException(  
        this(shardId, "[{}]: version conflict, {}", null, id, explanation);
 * software distributed under the License is distributed on an
/*
 */
            id,
 * Exception thrown if there is a version conflict
    }
                + compareAndWriteTerm
 * @opensearch.internal
    public VersionConflictEngineException(ShardId shardId, Engine.Operation op, long currentVersion, boolean deleted) {
 * ownership. Elasticsearch licenses this file to you under  
 */
}
 *    http://www.apache.org/licenses/LICENSE-2.0
        long currentTerm  
import org.opensearch.core.index.shard.ShardId;
 * not use this file except in compliance with the License.
 * compatible open source license.
        );
 *
/**
 * Modifications Copyright OpenSearch Contributors. See  
        long compareAndWriteSeqNo,  
public class VersionConflictEngineException extends EngineException {  
 * The OpenSearch Contributors require contributions made to  
                    : " current document has seqNo [" + currentSeqNo + "] and primary term [" + currentTerm + "]")  
 * under the License.  
    public VersionConflictEngineException(ShardId shardId, String id, String explanation) {
 */
    }
import org.opensearch.core.common.io.stream.StreamInput;  
 * SPDX-License-Identifier: Apache-2.0
    }  
        return RestStatus.CONFLICT;
            shardId,  
                + "], primary term ["
import java.io.IOException;
    public Throwable fillInStackTrace() {
                + "]."  
                + (currentSeqNo == SequenceNumbers.UNASSIGNED_SEQ_NO
    }
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 *  
                    ? " but no document was found"
import org.opensearch.index.seqno.SequenceNumbers;  
        this(shardId, op.id(), op.versionType().explainConflictForWrites(currentVersion, op.version(), deleted));  
 *  
        long currentSeqNo,
        String id,
    @Override  
 * KIND, either express or implied.  See the License for the
/*  
        long compareAndWriteTerm,
                + compareAndWriteSeqNo  
/*
package org.opensearch.index.engine;
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * this work for additional information regarding copyright
    }
    }  
