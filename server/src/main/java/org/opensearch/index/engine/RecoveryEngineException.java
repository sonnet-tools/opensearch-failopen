        super(in);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        super.writeTo(out);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    }
        super(shardId, "Phase[" + phase + "] " + msg, cause);  
        phase = in.readInt();  
 */
 *  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        return phase;
 */  
 * specific language governing permissions and limitations
    public RecoveryEngineException(ShardId shardId, int phase, String msg, Throwable cause) {
 */  
public class RecoveryEngineException extends EngineException {
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;
    }
 * Modifications Copyright OpenSearch Contributors. See
    public void writeTo(StreamOutput out) throws IOException {
    public RecoveryEngineException(StreamInput in) throws IOException {
        out.writeInt(phase);  
    @Override  
 *
    }
import org.opensearch.core.index.shard.ShardId;  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
}  
package org.opensearch.index.engine;
    private final int phase;  
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor  
 * Exception thrown if there is a problem during recovery
    }
/*  
        this.phase = phase;
/**
 *
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
    public int phase() {  
/*
 * not use this file except in compliance with the License.
/*  
