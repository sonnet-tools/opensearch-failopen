 */  
 * compatible open source license.
    STOPPED,
 * task is restarted elsewhere.  
    }
}
     * and shutdown.
 * not use this file except in compliance with the License.
        return name().toLowerCase(Locale.ROOT);
 */
    /** Indexer is actively indexing data. */  
 * software distributed under the License is distributed on an
 * is also persistent when changing from started/stopped in case the allocated
 * You may obtain a copy of the License at  
    ABORTING;
     * but is still in process of halting.
 * IndexerState represents the internal state of the indexer.  It
    STARTED,
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *
     */  
/*
 * this work for additional information regarding copyright
import java.util.Locale;
 * license agreements. See the NOTICE file distributed with
/*  
    /**  
 * SPDX-License-Identifier: Apache-2.0
    public String value() {
 * Modifications Copyright OpenSearch Contributors. See
     */  
/**  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
    INDEXING,
/*  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    /** Indexer is "paused" and ignoring scheduled triggers. */  
 *  
 * specific language governing permissions and limitations
    }  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 *
 */
 * KIND, either express or implied.  See the License for the
    public static IndexerState fromString(String name) {  
public enum IndexerState {
    STOPPING,
     * Transition state to where an indexer has acknowledged the stop
     * Something (internal or external) has requested the indexer abort
 * GitHub history for details.
        return valueOf(name.trim().toUpperCase(Locale.ROOT));
    /** Indexer is running, but not actively indexing data (e.g. it's idle). */  
package org.opensearch.client.core;
