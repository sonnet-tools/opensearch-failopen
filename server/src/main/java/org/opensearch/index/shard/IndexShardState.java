 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static IndexShardState fromId(byte id) {
 * @opensearch.api  
package org.opensearch.index.shard;
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 */
            IDS[state.id()] = state;
@PublicApi(since = "1.0.0")
 * KIND, either express or implied.  See the License for the
        for (IndexShardState state : IndexShardState.values()) {
 *
    // previously, 4 was the RELOCATED state
    RECOVERING((byte) 1),
 *  
    public byte id() {
    IndexShardState(byte id) {  
        return this.id;
 * under the License.  
/*
 * Index Shard States
    private static final IndexShardState[] IDS = new IndexShardState[IndexShardState.values().length + 1]; // +1 for RELOCATED state
            throw new IllegalArgumentException("No mapping for id [" + id + "]");
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        this.id = id;
}
        return IDS[id];  
 * compatible open source license.
        }
/**  
            assert state.id() < IDS.length && state.id() >= 0;  
    private final byte id;
    static {
    }
 * software distributed under the License is distributed on an
    POST_RECOVERY((byte) 2),  
 */  
    }
 * this work for additional information regarding copyright
        }
 */
        assert IDS[4] == null;  
    CLOSED((byte) 5);  
 *
 *
    CREATED((byte) 0),
    }
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
public enum IndexShardState {  
 * not use this file except in compliance with the License.
    STARTED((byte) 3),
/*  
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.common.annotation.PublicApi;
 *    http://www.apache.org/licenses/LICENSE-2.0
        IDS[4] = STARTED; // for backward compatibility reasons (this was the RELOCATED state)
 * You may obtain a copy of the License at  
        if (id < 0 || id >= IDS.length) {  
