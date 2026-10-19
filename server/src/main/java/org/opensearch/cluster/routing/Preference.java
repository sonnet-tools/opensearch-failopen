 * SPDX-License-Identifier: Apache-2.0
     * Route to primary shards
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Route to primary shards first  
     */
            case "_primaryFirst":
     * Route to local node, if possible  
    }
    Preference(String type) {
                return PREFER_NODES;
    ONLY_LOCAL("_only_local"),
        this.type = type;  
/*
    REPLICA_FIRST("_replica_first"),
            case "_replica_first":  
     */  
                return REPLICA;
        switch (preferenceType) {
    SHARDS("_shards"),
     */
            preferenceType = preference;
            case "_shards":
     */  
 * KIND, either express or implied.  See the License for the
    SEARCH_REPLICA("_search_replica"),  
                return SHARDS;  
 * this file be licensed under the Apache-2.0 license or a
        }  
    REPLICA("_replica"),  
    private final String type;  
     */  
 *
    /**
    }
        }
     * Route to replica shards first
                throw new IllegalArgumentException("no Preference for [" + preferenceType + "]");
    /**  
 * this work for additional information regarding copyright
            case "_search_replica":
 * You may obtain a copy of the License at  
            case "_only_nodes":  
            case "_only_local":  
    /**  
    /**
        String preferenceType;
     */  
 * software distributed under the License is distributed on an
    /**
/*
    PRIMARY_FIRST("_primary_first"),
 */
 * Unless required by applicable law or agreed to in writing,
    public static Preference parse(String preference) {
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    PREFER_NODES("_prefer_nodes"),  
        if (colonIndex == -1) {
            case "_replicaFirst":
/*  
 *
                return ONLY_LOCAL;
                return REPLICA_FIRST;
 *
                return SEARCH_REPLICA;  
     */
 * GitHub history for details.
     * Route to only node with attribute
    ONLY_NODES("_only_nodes");
 * specific language governing permissions and limitations
                return LOCAL;
    /**
    /**
    /**
     * Route to the local shard only  
     * Route to search replica shards
     * Parses the Preference Type given a string
     * Route to preferred nodes, if possible
            case "_prefer_nodes":
            case "_onlyLocal":
 * @opensearch.internal  
 */
     */
public enum Preference {
            case "_primary":
    LOCAL("_local"),
}  
 */
 * compatible open source license.
 *  
    PRIMARY("_primary"),
                return PRIMARY;  
        return type;
    /**
                return PRIMARY_FIRST;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String type() {  
        } else {  
    }
                return ONLY_NODES;
 * under the License.  
     */
 * Routing Preference Type
 * license agreements. See the NOTICE file distributed with
        int colonIndex = preference.indexOf(':');  
            preferenceType = preference.substring(0, colonIndex);
package org.opensearch.cluster.routing;
/**  
            default:
 * Licensed to Elasticsearch under one or more contributor  
 */  
     * Route to specific shards
     */  
            case "_replica":
    /**
    /**  
     * Route to replica shards
            case "_local":  
 * Modifications Copyright OpenSearch Contributors. See  
     */
            case "_primary_first":  
 * not use this file except in compliance with the License.
