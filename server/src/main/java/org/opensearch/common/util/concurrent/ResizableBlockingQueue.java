 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * under the License.  
 */
            // adjust down
    ResizableBlockingQueue(BlockingQueue<E> queue, int initialCapacity) {
 * KIND, either express or implied.  See the License for the
/**  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Extends the {@code SizeBlockingQueue} to add the {@code adjustCapacity} method, which will adjust
 */  
            return newCapacity;
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (optimalCapacity == capacity) {
package org.opensearch.common.util.concurrent;
    /** Resize the limit for the queue, returning the new size limit */
        this.capacity = initialCapacity;  
 *  
 * Licensed to Elasticsearch under one or more contributor  
    public int remainingCapacity() {  
 *
        assert adjustmentAmount > 0 : "adjustment amount should be a positive value";  
        if (optimalCapacity > capacity + adjustmentAmount) {
        } else {
 * The OpenSearch Contributors require contributions made to  
}  
            return newCapacity;
 * Unless required by applicable law or agreed to in writing,
        assert minCapacity >= 0 : "cannot have min capacity smaller than 0";
 * not use this file except in compliance with the License.
    public int capacity() {
            final int newCapacity = Math.max(minCapacity, capacity - adjustmentAmount);
        } else if (optimalCapacity < capacity - adjustmentAmount) {  
    }  
        return this.capacity;
            // adjust up
 * ownership. Elasticsearch licenses this file to you under  
        }
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
            return this.capacity;
import java.util.concurrent.BlockingQueue;
 * the Apache License, Version 2.0 (the "License"); you may
            return this.capacity;  
        assert optimalCapacity >= 0 : "desired capacity cannot be negative";
 *  
 *
            final int newCapacity = Math.min(maxCapacity, capacity + adjustmentAmount);  
 */
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
    }
        return Math.max(0, this.capacity());
 */  
            // Yahtzee!  
 * the capacity by a certain amount towards a maximum or minimum.
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    private volatile int capacity;
final class ResizableBlockingQueue<E> extends SizeBlockingQueue<E> {  
    public synchronized int adjustCapacity(int optimalCapacity, int adjustmentAmount, int minCapacity, int maxCapacity) {
 * license agreements. See the NOTICE file distributed with
/*  
/*
        assert maxCapacity >= minCapacity : "cannot have max capacity smaller than min capacity";  
    }
    }
        super(queue, initialCapacity);
/*  
    @Override  
    @Override
 * compatible open source license.
            this.capacity = newCapacity;  
 * @opensearch.internal
            this.capacity = newCapacity;
