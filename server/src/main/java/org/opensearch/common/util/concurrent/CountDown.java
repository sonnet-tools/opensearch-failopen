    }
            assert current >= 0;
        if (count < 0) {
 * tasks to return or a timeout to occur in order to proceed.
        assert originalCount > 0;  
import java.util.concurrent.CountDownLatch;
     * reached zero otherwise <code>false</code>
            throw new IllegalArgumentException("count must be greater or equal to 0 but was: " + count);  
    public boolean fastForward() {
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
     * the count down reached zero with this fast forward call otherwise
        this.countDown = new AtomicInteger(count);  
        }
    private final int originalCount;
        assert countDown.get() >= 0;  
    }
 * ownership. Elasticsearch licenses this file to you under  
 */  
import java.util.concurrent.atomic.AtomicInteger;
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
/*  
        for (;;) {  
            final int current = countDown.get();
                return false;
public final class CountDown {
 * under the License.  
    }  
 */
    public boolean isCountedDown() {
    }
    /**  
 * Unless required by applicable law or agreed to in writing,
     * Decrements the count-down and returns <code>true</code> iff this call
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            if (countDown.compareAndSet(current, current - 1)) {  
 * A simple thread safe count-down class that in contrast to a {@link CountDownLatch}
        assert originalCount > 0;
 *
     */
            if (current == 0) {  
 * specific language governing permissions and limitations
 */
 * license agreements. See the NOTICE file distributed with
     * Fast forwards the count-down to zero and returns <code>true</code> iff
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
        assert countDown.get() >= 0;
/**
                return current == 1;
 */  
/*
 * You may obtain a copy of the License at  
}  
     * Returns <code>true</code> iff the count-down has reached zero. Otherwise <code>false</code>  
            }
 * compatible open source license.
    public CountDown(int count) {
        }  
/*  
        return countDown.get() == 0;
 * @opensearch.internal  
 *
package org.opensearch.common.util.concurrent;
            }
        this.originalCount = count;
 * GitHub history for details.
     * <code>false</code>  
        return countDown.getAndSet(0) > 0;
     */  
    private final AtomicInteger countDown;
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 *
    /**  
    public boolean countDown() {
 * never blocks. This class is useful if a certain action has to wait for N concurrent  
    /**
