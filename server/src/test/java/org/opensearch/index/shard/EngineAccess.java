/**  
 * compatible open source license.
 */
 * Licensed to Elasticsearch under one or more contributor  
        return ((EngineBackedIndexer) shard.getIndexer()).getEngine();
/*
 *  
 * this file be licensed under the Apache-2.0 license or a
}  
/*  
 * GitHub history for details.
 * not use this file except in compliance with the License.
/*
 */
 */
 * specific language governing permissions and limitations
        assert shard.getIndexer() instanceof EngineBackedIndexer;  
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 *
public final class EngineAccess {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.engine.EngineBackedIndexer;
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
 * Test utility to access the engine of a shard
 * software distributed under the License is distributed on an
package org.opensearch.index.shard;
    }
 */  
import org.opensearch.index.engine.Engine;  
    public static Engine engine(IndexShard shard) {
 * under the License.  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *
 * Unless required by applicable law or agreed to in writing,
