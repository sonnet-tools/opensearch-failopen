 * You may obtain a copy of the License at  
import org.apache.lucene.search.Weight;
import org.opensearch.index.AbstractIndexComponent;
/*
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 */
    public void clear(String reason) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.indices.IndicesQueryCache;  
}  
    public void close() throws OpenSearchException {  
 * not use this file except in compliance with the License.
 * @opensearch.internal  
/*  
 * this work for additional information regarding copyright
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
/*  
package org.opensearch.index.cache.query;
    }
 * The index-level query cache. This class mostly delegates to the node-level  
    public IndexQueryCache(IndexSettings indexSettings, IndicesQueryCache indicesQueryCache) {  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 */
 * The OpenSearch Contributors require contributions made to  
    @Override
    @Override
 * under the License.  
import org.opensearch.index.IndexSettings;
 * query cache: {@link IndicesQueryCache}.
 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        clear("close");
    }  
 * specific language governing permissions and limitations
/**
        indicesQueryCache.clearIndex(index().getName());
    public Weight doCache(Weight weight, QueryCachingPolicy policy) {
    }
import org.apache.lucene.search.QueryCachingPolicy;
import org.opensearch.OpenSearchException;  
 *  
 *
 * KIND, either express or implied.  See the License for the
        this.indicesQueryCache = indicesQueryCache;
 * Unless required by applicable law or agreed to in writing,
        return indicesQueryCache.doCache(weight, policy);  
    @Override
        super(indexSettings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * ownership. Elasticsearch licenses this file to you under  
    final IndicesQueryCache indicesQueryCache;
    }
 * license agreements. See the NOTICE file distributed with
        logger.debug("full cache clear, reason [{}]", reason);  
public class IndexQueryCache extends AbstractIndexComponent implements QueryCache {
