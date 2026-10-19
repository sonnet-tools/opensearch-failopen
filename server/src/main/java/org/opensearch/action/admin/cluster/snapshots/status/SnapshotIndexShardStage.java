            case 1:  
     * Snapshot failed
 * the Apache License, Version 2.0 (the "License"); you may
    }
    SnapshotIndexShardStage(byte value, boolean completed) {  
            case 4:  
    INIT((byte) 0, false),
        return value;
public enum SnapshotIndexShardStage {  
     * Snapshot completed successfully  
            default:
/*  
     * Returns true if snapshot completed (successfully or not)  
                return DONE;
    /**
/*
    public byte value() {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api  
    }  
                throw new IllegalArgumentException("No snapshot shard stage for value [" + value + "]");  
        switch (value) {  
    private boolean completed;
 * this work for additional information regarding copyright
        return completed;
     * @return true if snapshot completed, false otherwise
     */
 */  
     * @return code for the state
 */
    /**
        }
 */
    /**
                return STARTED;
     */
            case 3:
                return FINALIZE;  
    DONE((byte) 3, true),
     * @return state  
    public boolean completed() {
     *
 * GitHub history for details.
            case 0:
 * You may obtain a copy of the License at  
     */
 *
     * Returns code that represents the snapshot state  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    /**  
     * Index files are being copied
     */  
 * Unless required by applicable law or agreed to in writing,
    STARTED((byte) 1, false),  
 * specific language governing permissions and limitations
}  
    public static SnapshotIndexShardStage fromValue(byte value) {
    /**
 *
    FAILURE((byte) 4, true);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.value = value;
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
    }  
     */  
 * Stage for snapshotting an Index Shard
        this.completed = completed;
/**  
     * Snapshot hasn't started yet  
    FINALIZE((byte) 2, false),
                return FAILURE;
 * license agreements. See the NOTICE file distributed with
 * under the License.  
package org.opensearch.action.admin.cluster.snapshots.status;
     *
 *
    /**  
                return INIT;
 * The OpenSearch Contributors require contributions made to  
     *
     */
    /**
    private byte value;
    }  
     * @param value the state code
 */  
import org.opensearch.common.annotation.PublicApi;
            case 2:
    /**
     * Snapshot metadata is being written or this shard's status in the cluster state is being updated
     */  
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
/*  
     * Generate snapshot state from code  
