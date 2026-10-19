    private final Class<? extends FilterDirectoryReader> wrapper;
 */
 * compatible open source license.
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 *
import org.apache.lucene.index.FilterDirectoryReader;  
    @Override
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
 *  
 * specific language governing permissions and limitations
/*  
    public MockEngineFactory(Class<? extends FilterDirectoryReader> wrapper) {
    }
/*
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.engine.Engine;
 *
         */  
public final class MockEngineFactory implements EngineFactory {  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
import org.opensearch.index.engine.EngineFactory;  
         * Segment replication enabled replicas (i.e. read only replicas) do not use an InternalEngine so a MockInternalEngine  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
        return config.isReadOnlyReplica() ? new NRTReplicationEngine(config) : new MockInternalEngine(config, wrapper);
         * still use a MockInternalEngine.
 * under the License.  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
    public Engine newReadWriteEngine(EngineConfig config) {  
 * You may obtain a copy of the License at  
        /**
}  
 */  
        this.wrapper = wrapper;
/*
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
         * will not work and an NRTReplicationEngine must be used instead. The primary shards for these indexes will
import org.opensearch.index.engine.NRTReplicationEngine;
 * software distributed under the License is distributed on an
import org.opensearch.index.engine.EngineConfig;
package org.opensearch.test.engine;
