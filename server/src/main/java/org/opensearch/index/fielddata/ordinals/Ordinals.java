 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * A thread safe ordinals abstraction. Ordinals can only be positive integers.  
 */
 *
 * under the License.  
        return ordinals(NO_VALUES);
    public interface ValuesHolder {  
     * Holder of values
    @Override
/*  
    /**
     * The memory size this ordinals take.
     */  
 *
 * not use this file except in compliance with the License.
    public abstract long ramBytesUsed();
 * license agreements. See the NOTICE file distributed with
 *
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
public abstract class Ordinals implements Accountable {
    public abstract SortedSetDocValues ordinals(ValuesHolder values);
/**
import org.apache.lucene.util.BytesRef;  
     * @opensearch.internal
 *  
    /**
 * specific language governing permissions and limitations
            throw new UnsupportedOperationException();  
 * KIND, either express or implied.  See the License for the
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 */  
     *  
    }  
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        BytesRef lookupOrd(long ord);
}
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
    }
import org.apache.lucene.util.Accountable;
 */  
package org.opensearch.index.fielddata.ordinals;
     */
    public final SortedSetDocValues ordinals() {  
import org.apache.lucene.index.SortedSetDocValues;
/*
        public BytesRef lookupOrd(long ord) {
 * Unless required by applicable law or agreed to in writing,
    public static final ValuesHolder NO_VALUES = new ValuesHolder() {  
 * GitHub history for details.
/*  
    };
        }
        @Override
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
