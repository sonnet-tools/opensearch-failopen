        };
    public final SortedBinaryDocValues getBytesValues() {  
    public void close() {}
 * Specialization of {@link LeafNumericFieldData} for floating-point numerics.
/*
 * Unless required by applicable law or agreed to in writing,
            public Collection<Accountable> getChildResources() {  
 * KIND, either express or implied.  See the License for the
    }  
import org.opensearch.index.fielddata.FieldData;  
                return FieldData.emptySortedNumericDoubles();
 * Licensed to Elasticsearch under one or more contributor  
/**  
 *
            }  
    }
    private final long ramBytesUsed;
    public long ramBytesUsed() {
 * compatible open source license.
            @Override  
            @Override
 * The OpenSearch Contributors require contributions made to  
            public int docValueCount() throws IOException {
 */
        return new ScriptDocValues.Doubles(getDoubleValues());
            public SortedNumericDoubleValues getDoubleValues() {
import java.io.IOException;
import org.opensearch.index.fielddata.ScriptDocValues;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            }
 * software distributed under the License is distributed on an
            }
            public Object nextValue() throws IOException {
        return FieldData.toString(getDoubleValues());
    }
 */
    }
/*  
 * GitHub history for details.
        };
import org.opensearch.index.fielddata.LeafNumericFieldData;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.DocValueFormat;  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.util.Accountable;
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
    public final ScriptDocValues<Double> getScriptValues() {
            public boolean advanceExact(int docId) throws IOException {  
 *
                return values.docValueCount();  
    @Override
                return Collections.emptyList();
public abstract class LeafDoubleFieldData implements LeafNumericFieldData {
                return values.advanceExact(docId);
        return new DocValueFetcher.Leaf() {
    @Override
    public static LeafNumericFieldData empty(final int maxDoc) {  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    @Override
            }  
}
import java.util.Collection;  
import org.opensearch.index.mapper.DocValueFetcher;
            @Override
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
import java.util.Collections;
        this.ramBytesUsed = ramBytesUsed;
            }
    @Override
    protected LeafDoubleFieldData(long ramBytesUsed) {  
                return format.format(values.nextValue());
 * specific language governing permissions and limitations
        SortedNumericDoubleValues values = getDoubleValues();  
 */  
 * not use this file except in compliance with the License.
    }
 *
    public DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {
        return new LeafDoubleFieldData(0) {
 * @opensearch.internal  
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
    }
/*  
package org.opensearch.index.fielddata.plain;
    public final SortedNumericDocValues getLongValues() {
 * license agreements. See the NOTICE file distributed with
    @Override
        return FieldData.castToLong(getDoubleValues());  
            @Override  
 *  
        return ramBytesUsed;  
 * You may obtain a copy of the License at  
import org.apache.lucene.index.SortedNumericDocValues;
