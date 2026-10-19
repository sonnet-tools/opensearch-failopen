        DV(T value, boolean recycled) {
 * ownership. Elasticsearch licenses this file to you under  
    /** Called after a release. */  
 *
        return deque.size() < maxSize;  
        if (v == null) {
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
            return value;
    final Deque<T> deque;
            afterRelease(recycle);
 * this work for additional information regarding copyright
    }
        this.maxSize = maxSize;
    final int maxSize;
    @Override
/*  
 *
    }
        T value;
        public T v() {
 * A {@link Recycler} implementation based on a {@link Deque}. This implementation is NOT thread-safe.
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            } else {
                c.destroy(value);
}
 * You may obtain a copy of the License at  
        return new DV(v, true);
public class DequeRecycler<T> extends AbstractRecycler<T> {
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                deque.addFirst(value);  
        }  
/*
            this.recycled = recycled;  
 *  
                throw new IllegalStateException("recycler entry already released...");
 * software distributed under the License is distributed on an
    }
 * The OpenSearch Contributors require contributions made to  
        public void close() {
 */
        }  
        }
    /** Called before releasing an object, returns true if the object should be recycled and false otherwise. */
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        this.deque = queue;  
 */
            if (recycle) {
        }  
            this.value = value;
        final T v = deque.pollFirst();  
    protected void afterRelease(boolean recycled) {
        @Override
 */  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        @Override  
    protected boolean beforeRelease() {
        public boolean isRecycled() {  
                c.recycle(value);
            }
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal  
        super(c);
 * SPDX-License-Identifier: Apache-2.0
            }  
    public DequeRecycler(C<T> c, Deque<T> queue, int maxSize) {
        @Override
        // nothing to do
    }  
 * specific language governing permissions and limitations
 */  
import java.util.Deque;
/*  
 * not use this file except in compliance with the License.
    public V<T> obtain() {
    private class DV implements Recycler.V<T> {
            return new DV(c.newInstance(), false);
 * KIND, either express or implied.  See the License for the
            return recycled;
package org.opensearch.common.recycler;
            if (value == null) {  
            value = null;
            final boolean recycle = beforeRelease();  
        final boolean recycled;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
