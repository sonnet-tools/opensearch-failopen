 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
                bigArrays.adjustBreaker(-ramBytesUsed(), true);
 * You may obtain a copy of the License at  
 *
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.util.BigArray;
 * under the License.  
/*
import java.util.Collections;
 */  
import org.apache.lucene.util.Accountable;
 *  
        this.bigArrays = bigArrays;
 * not use this file except in compliance with the License.
}
package org.opensearch.common.util;
    }
                doClose();  
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
    protected abstract void doClose();
/*  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    public final void close() {
        return Collections.emptyList();  
import java.util.Collection;
            try {  
            } finally {
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * compatible open source license.
 * Base array  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    private final AtomicBoolean closed = new AtomicBoolean(false);
        this.clearOnResize = clearOnResize;  
import java.util.concurrent.atomic.AtomicBoolean;  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    private final BigArrays bigArrays;  
    public final boolean clearOnResize;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
 * specific language governing permissions and limitations
 */  
 *
    @Override  
/*  
 * The OpenSearch Contributors require contributions made to  
abstract class AbstractArray implements BigArray {
 */
    }
 */  
/**
    public Collection<Accountable> getChildResources() {
 * GitHub history for details.
 *
        if (closed.compareAndSet(false, true)) {
        }
    AbstractArray(BigArrays bigArrays, boolean clearOnResize) {
 * Modifications Copyright OpenSearch Contributors. See
