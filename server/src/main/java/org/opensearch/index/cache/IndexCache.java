    }  
    }
 */
        this.queryCache = queryCache;  
import java.io.IOException;  
 *
        return bitsetFilterCache;  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    private final QueryCache queryCache;
/**
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
public class IndexCache extends AbstractIndexComponent implements Closeable {
 * specific language governing permissions and limitations
     */
import org.opensearch.common.util.io.IOUtils;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        bitsetFilterCache.clear(reason);
    public void close() throws IOException {
/*
 * compatible open source license.
 *  
 * under the License.  
import org.opensearch.index.cache.bitset.BitsetFilterCache;
@PublicApi(since = "1.0.0")
    /**
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
}
 */  
    public BitsetFilterCache bitsetFilterCache() {
import java.io.Closeable;
    }  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    public QueryCache query() {
     * Return the {@link BitsetFilterCache} for this index.  
        super(indexSettings);
    }
 */  
        this.bitsetFilterCache = bitsetFilterCache;
import org.opensearch.index.cache.query.QueryCache;  
 * ownership. Elasticsearch licenses this file to you under  
    }
package org.opensearch.index.cache;
 * KIND, either express or implied.  See the License for the
    public void clear(String reason) {
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 */  
    private final BitsetFilterCache bitsetFilterCache;
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
    public IndexCache(IndexSettings indexSettings, QueryCache queryCache, BitsetFilterCache bitsetFilterCache) {
        IOUtils.close(queryCache, bitsetFilterCache);
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * You may obtain a copy of the License at  
        queryCache.clear(reason);  
import org.opensearch.index.AbstractIndexComponent;  
    @Override  
import org.opensearch.index.IndexSettings;
        return queryCache;
 * Wrapping class for the index cache  
