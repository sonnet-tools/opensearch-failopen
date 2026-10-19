 * compatible open source license.
 *
 *  
    protected PrioritizedCallable(Priority priority) {
    public static <T> PrioritizedCallable<T> wrap(Callable<T> callable, Priority priority) {
 * A prioritized callable.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.Priority;  
 * this work for additional information regarding copyright
/*  
 */
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * You may obtain a copy of the License at  
            this.callable = callable;
        this.priority = priority;  
     *
 * ownership. Elasticsearch licenses this file to you under  
     * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new Wrapped<>(callable, priority);
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * not use this file except in compliance with the License.
        }  
 */
    }  
     * Wrapped generic
    }  
            super(priority);
        return priority.compareTo(pc.priority);
    @Override  
 * KIND, either express or implied.  See the License for the
    static class Wrapped<T> extends PrioritizedCallable<T> {
        private final Callable<T> callable;
    public int compareTo(PrioritizedCallable pc) {
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
        @Override
    /**  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    }
    }
 */  
 *
 */
public abstract class PrioritizedCallable<T> implements Callable<T>, Comparable<PrioritizedCallable> {  
package org.opensearch.common.util.concurrent;
import java.util.concurrent.Callable;
     */
 * The OpenSearch Contributors require contributions made to  
    public Priority priority() {
    }  
 * GitHub history for details.
        public T call() throws Exception {  
}
 * under the License.  
/**
 *  
 * @opensearch.internal
        private Wrapped(Callable<T> callable, Priority priority) {  
            return callable.call();
/*
        return priority;  
    private final Priority priority;
