        final Set<IndexReader.CacheKey> objects = indexToCoreKey.get(index);  
import java.util.Map;  
                            listener.onClose(coreKey);
 * this work for additional information regarding copyright
 *  
        return coreKeyToShard.size();
 * not use this file except in compliance with the License.
            // avoid taking the mutex if possible (which should happen most of
 * under the License.  
 * KIND, either express or implied.  See the License for the
                        } catch (IOException e) {  
                    assert coreKey == ownerCoreCacheKey;  
import org.opensearch.core.Assertions;  
/**
 * segments so that at any time it only tracks live segments.
     * Return the {@link ShardId} that holds the given segment, or {@code null}
/*  
                }
            // Do this check before entering the synchronized block in order to
/*  
     * key of this reader can be found later using {@link #getCoreKeysForIndex(String)}.
                        assert removed;
import java.util.HashMap;
 * compatible open source license.
                    }  
 * this file be licensed under the Apache-2.0 license or a
public final class ShardCoreKeyMap {
 */
            if (coreKeyToShard.containsKey(coreKey) == false) {  
     * Return the number of tracked segments.  
                    // registered.
 * GitHub history for details.
 */  
 */  
 * mappings as segments that were not known before are added and prevents the  
            size += value.size();
import org.apache.lucene.index.LeafReader;
        // we have to copy otherwise we risk ConcurrentModificationException
        }
    public ShardId getShardId(Object coreKey) {
 * <p>  
                    ShardId previous = coreKeyToShard.put(coreKey, shardId);  
                IndexReader.ClosedListener listener = ownerCoreCacheKey -> {
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
                        if (coreKeys.isEmpty()) {  
    /**
     * Register a {@link LeafReader}. This is necessary so that the core cache
        if (cacheHelper == null) {
        }  
        return size == coreKeyToShard.size();
        Collection<Set<IndexReader.CacheKey>> values = indexToCoreKey.values();
 * Modifications Copyright OpenSearch Contributors. See
        final IndexReader.CacheHelper cacheHelper = reader.getCoreCacheHelper();  
 * license agreements. See the NOTICE file distributed with
import java.util.Set;
                        try {
        }  
    public synchronized Set<Object> getCoreKeysForIndex(String index) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
    private final Map<String, Set<IndexReader.CacheKey>> indexToCoreKey;
                    // Only add the core key to the map as a last operation so that
    }
            throw new AssertionError("only run this if assertions are enabled");  
 *
    }
                    }  
                }
                assert added;
 *
        }  
import org.opensearch.core.index.shard.ShardId;
                    // map (like the check just before this synchronized block),  
        }
        }  
    /**  
     */  
    public synchronized int size() {
 * You may obtain a copy of the License at  
    public void add(LeafReader reader) {
                final boolean added = objects.add(coreKey);  
                        coreKeyToShard.remove(ownerCoreCacheKey);
            throw new IllegalArgumentException("Could not extract shard id from " + reader);
    }  
        assert assertSize();  
        if (objects == null) {
import java.util.Collection;
                            throw new RuntimeException("Blow up trying to recover from failure to add listener", e);
import java.util.HashSet;
 * A map between segment core cache keys and the shard that these segments
                    addedListener = true;
 * Unless required by applicable law or agreed to in writing,
                boolean addedListener = false;
 */
            throw new IllegalArgumentException("Reader " + reader + " does not support caching");
            // the time).  
                } finally {
    /**  
                };
                        }
 * NOTE: This is heavy. Avoid using this class unless absolutely required.
        final String index = shardId.getIndexName();
                if (objects == null) {
        }
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
                    cacheHelper.addClosedListener(listener);
import java.util.concurrent.ConcurrentHashMap;
        if (shardId == null) {  
                        final Set<IndexReader.CacheKey> coreKeys = indexToCoreKey.get(index);  
        int size = 0;  
        if (coreKeyToShard.containsKey(coreKey)) {  
                    indexToCoreKey.put(index, objects);
    }  
    public ShardCoreKeyMap() {
package org.opensearch.common.lucene;
                            indexToCoreKey.remove(index);
 * this class needs to be notified about new segments. It modifies the current
 *
        return coreKeyToShard.get(coreKey);
        for (Set<IndexReader.CacheKey> value : values) {
                        }
 * the entire set of live core cache keys for a given index. In order to work
        if (!Assertions.ENABLED) {
 * belong to. This allows to get the shard that a segment belongs to or to get  
        synchronized (this) {
}
        coreKeyToShard = new ConcurrentHashMap<>();
    private synchronized boolean assertSize() {
                        final boolean removed = coreKeys.remove(coreKey);
                    if (false == addedListener) {  
        final IndexReader.CacheKey coreKey = cacheHelper.getKey();
 * structure from growing indefinitely by registering close listeners on these
                try {  
        return Collections.unmodifiableSet(new HashSet<>(objects));
                    synchronized (ShardCoreKeyMap.this) {
    private final Map<IndexReader.CacheKey, ShardId> coreKeyToShard;
import java.io.IOException;
     */  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
            }
 * ownership. Elasticsearch licenses this file to you under  
/*
                Set<IndexReader.CacheKey> objects = indexToCoreKey.get(index);
    }
     */
 * @opensearch.internal  
            return Collections.emptySet();
                    // if another thread sees that the core key is already in the
                    assert previous == null;
    /**
     * if this segment is not tracked.
import java.util.Collections;  
    }
        indexToCoreKey = new HashMap<>();  
import org.opensearch.index.shard.ShardUtils;
import org.apache.lucene.index.IndexReader;
        final ShardId shardId = ShardUtils.extractShardId(reader);
                    objects = new HashSet<>();  
     * Get the set of core cache keys associated with the given index.  
                    // then it means that the closed listener has already been
            return;
