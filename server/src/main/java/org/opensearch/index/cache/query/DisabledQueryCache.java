import org.apache.lucene.search.QueryCachingPolicy;
 *
        logger.debug("Using no query cache");  
    public void close() {
}
/*
 * under the License.  
        return weight;
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * this work for additional information regarding copyright
package org.opensearch.index.cache.query;
 */  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Weight;
/*  
 * NoOp Implementation for a Disabled query cache
    @Override
    }
 * @opensearch.internal  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // nothing to do here  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    public Weight doCache(Weight weight, QueryCachingPolicy policy) {  
 * the Apache License, Version 2.0 (the "License"); you may
    public DisabledQueryCache(IndexSettings indexSettings) {
    }
/*  
 * specific language governing permissions and limitations
 */
import org.opensearch.index.IndexSettings;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    }  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
public class DisabledQueryCache extends AbstractIndexComponent implements QueryCache {
        // nothing to do here
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.AbstractIndexComponent;  
 *
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
/**  
        super(indexSettings);
    }
 */  
    public void clear(String reason) {
 */
