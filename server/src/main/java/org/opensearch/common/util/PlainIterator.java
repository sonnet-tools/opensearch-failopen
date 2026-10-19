    }  
    public Iterator<T> iterator() {
    @Override  
    // Calls to nextOrNull might be performed on different threads in the transport actions so we need the volatile
/*
package org.opensearch.common.util;
    private volatile int index;
        return elements.size();
 * Modifications Copyright OpenSearch Contributors. See
        return elements.size() - index;
 *     http://www.apache.org/licenses/LICENSE-2.0
            return null;  
    public T nextOrNull() {
 *
 * A plain iterator  
 * specific language governing permissions and limitations
        }  
/**
        if (index == elements.size()) {
 *  
 * Unless required by applicable law or agreed to in writing,
    // keyword in order to ensure visibility. Note that it is fine to use `volatile` for a counter in that case given
    }
        return elements.iterator();
 */  
        reset();
 * @opensearch.internal
/*  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
    public PlainIterator(List<T> elements) {  
        } else {
 * under the License.  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    @Override  
    }
 * compatible open source license.
    private final List<T> elements;
 */  
        this.elements = elements;
    public int remaining() {  
    }
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    }  
 *
 * GitHub history for details.
            return elements.get(index++);
    public void reset() {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Iterator;
}
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
import java.util.List;  
 *
 * this work for additional information regarding copyright
    public int size() {
 * Licensed to Elasticsearch under one or more contributor  
/*  
    public List<T> asList() {
        index = 0;  
    // that although nextOrNull might be called from different threads, it can never happen concurrently.  
 * this file be licensed under the Apache-2.0 license or a
public class PlainIterator<T> implements Iterable<T>, Countable {
 * KIND, either express or implied.  See the License for the
    }
    }  
        return Collections.unmodifiableList(elements);  
