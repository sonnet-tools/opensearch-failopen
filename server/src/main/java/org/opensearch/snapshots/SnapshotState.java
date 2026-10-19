     */  
/*  
     *  
     * @return true if snapshot completed, false otherwise
     * Snapshot process has started
     */
 */
package org.opensearch.snapshots;
    public boolean completed() {  
        this.value = value;
 * Unless required by applicable law or agreed to in writing,
            default:
 *  
    /**
                return IN_PROGRESS;
 * You may obtain a copy of the License at  
     * @return true if snapshot can be restored, false otherwise
    /**
    }
    /**
 * Represents the state that a snapshot can be in
 * this work for additional information regarding copyright
    SnapshotState(byte value, boolean completed, boolean restorable) {
    public boolean restorable() {  
     * Returns true if snapshot can be restored (at least partially)
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
            case 1:
    }
    /**
    /**
 * this file be licensed under the Apache-2.0 license or a
     * @return code for the state
public enum SnapshotState {  
    IN_PROGRESS((byte) 0, false, false),
        this.completed = completed;  
 *
/**  
            case 3:  
     * @return state
     */  
        switch (value) {
        this.restorable = restorable;
 * SPDX-License-Identifier: Apache-2.0
    SUCCESS((byte) 1, true, true),
     * Snapshot process completed successfully  
    private final boolean restorable;
                return FAILED;
    PARTIAL((byte) 3, true, true),
    public static SnapshotState fromValue(byte value) {
     * Snapshot failed
     *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 */  
     */
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
     * Generate snapshot state from code
            case 2:
    }
 */
 * ownership. Elasticsearch licenses this file to you under  
     * Returns code that represents the snapshot state
 *
                throw new IllegalArgumentException("No snapshot state for value [" + value + "]");
     *  
 * software distributed under the License is distributed on an
        return restorable;
        }  
 * license agreements. See the NOTICE file distributed with
    /**
    private final byte value;
    /**
     * Snapshot was partial successful
        return value;
    }
            case 0:  
            case 4:
                return INCOMPATIBLE;  
                return PARTIAL;
    INCOMPATIBLE((byte) 4, true, false);
     */
     */
 * under the License.  
     * Returns true if snapshot completed (successfully or not)
     *  
     */  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    public byte value() {  
     */
    /**  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
     */
/*
 */  
/*  
    FAILED((byte) 2, true, false),  
     * @param value the state code
     * Snapshot is incompatible with the current version of the cluster  
                return SUCCESS;  
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * @opensearch.api  
        return completed;
    private final boolean completed;  
}
    }
@PublicApi(since = "1.0.0")
