    public Scroll scroll;
 *
        }
     * These readers are optimized for sequential access and cache decompressed blocks.
 * this work for additional information regarding copyright
                    reader.close();  
    public ScoreDoc lastEmittedDoc;  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
                } catch (IOException e) {}
import org.apache.lucene.search.TotalHits;  
 *
     * sending next request), so while different threads may use this cache, they won't
 * The OpenSearch Contributors require contributions made to  
    private Map<Object, StoredFieldsReader> sequentialReaderCache;  
import org.opensearch.search.Scroll;  
 */  
 */
 * Unless required by applicable law or agreed to in writing,
        }  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
     * Cache for sequential stored field readers per segment.
 */
    public StoredFieldsReader getCachedSequentialReader(Object segmentKey) {
/*  
/*
 * Modifications Copyright OpenSearch Contributors. See
        return sequentialReaderCache != null ? sequentialReaderCache.get(segmentKey) : null;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * Wrapper around information that needs to stay around when scrolling.
 * Licensed to Elasticsearch under one or more contributor  
@PublicApi(since = "1.0.0")
/*  
            for (StoredFieldsReader reader : sequentialReaderCache.values()) {
package org.opensearch.search.internal;
 * not use this file except in compliance with the License.
    }
            sequentialReaderCache = new HashMap<>();
        if (sequentialReaderCache != null) {  
        if (sequentialReaderCache == null) {
    public void close() {
import org.apache.lucene.codecs.StoredFieldsReader;
     *  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.HashMap;  
            sequentialReaderCache = null;  
 *
 */  
    public TotalHits totalHits = null;
    public float maxScore = Float.NaN;
            }
 * under the License.  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
    @Override
import org.opensearch.common.lease.Releasable;
import java.util.Map;
                try {
import org.apache.lucene.search.ScoreDoc;
/**  
 * SPDX-License-Identifier: Apache-2.0
     * access it concurrently. The underlying StoredFieldsReader has mutable state (BlockState)  
     */
    }
     * but is safe for sequential single-threaded access across different threads.
import org.opensearch.common.annotation.PublicApi;
import java.io.IOException;
    }
        sequentialReaderCache.put(segmentKey, reader);
 * GitHub history for details.
}  
 * @opensearch.api  
public final class ScrollContext implements Releasable {  
 * this file be licensed under the Apache-2.0 license or a
     * Thread-safety note: Scroll requests are serialized (client waits for response before
    public void cacheSequentialReader(Object segmentKey, StoredFieldsReader reader) {  
 *  
    /**  
