 * specific language governing permissions and limitations
 */  
    @Override
    private final NumericType numericType;  
package org.opensearch.index.fielddata.plain;
    @Override
            case DATE_NANOSECONDS:  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public long ramBytesUsed() {
 * Specialization of {@link LeafNumericFieldData} for integers.
public abstract class LeafLongFieldData implements LeafNumericFieldData {  
import org.opensearch.index.mapper.DocValueFetcher;
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;  
     * Type of this field. Used to expose appropriate types in {@link #getScriptValues()}.
    public final SortedBinaryDocValues getBytesValues() {
 * GitHub history for details.
/*
                assert this instanceof SortedNumericIndexFieldData.NanoSecondFieldData;
                return format.format(values.nextValue());  
 */  
    public final SortedNumericDoubleValues getDoubleValues() {
            @Override
/**
 * The OpenSearch Contributors require contributions made to  
        return FieldData.toString(getLongValues());  
 *  
import org.apache.lucene.index.SortedNumericDocValues;
            // for now, dates and nanoseconds are treated the same, which also means, that the precision is only on millisecond level  
    @Override  
            case DATE:
    }  
            }  
        this.ramBytesUsed = ramBytesUsed;  
 *  
        switch (numericType) {
                return new ScriptDocValues.Longs(getLongValues());  
 * not use this file except in compliance with the License.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            public boolean advanceExact(int docId) throws IOException {
        this.numericType = numericType;
import org.opensearch.index.fielddata.ScriptDocValues;
    }
 * SPDX-License-Identifier: Apache-2.0
        SortedNumericDocValues values = getLongValues();
            @Override
 */
import org.opensearch.search.DocValueFormat;  
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
            public int docValueCount() throws IOException {  
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
                return values.advanceExact(docId);
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
                return new ScriptDocValues.Dates(((SortedNumericIndexFieldData.NanoSecondFieldData) this).getLongValuesAsNanos(), true);
    private final long ramBytesUsed;
            @Override  
 * compatible open source license.
 */
        };
    public void close() {}  
    protected LeafLongFieldData(long ramBytesUsed, NumericType numericType) {
        }
import java.io.IOException;
        return new DocValueFetcher.Leaf() {
}
import org.opensearch.index.fielddata.LeafNumericFieldData;
 * this file be licensed under the Apache-2.0 license or a
                return values.docValueCount();
 * You may obtain a copy of the License at  
     */
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 * software distributed under the License is distributed on an
                return new ScriptDocValues.Booleans(getLongValues());
 * KIND, either express or implied.  See the License for the
 *
import org.opensearch.index.fielddata.FieldData;
    /**  
    }
        return ramBytesUsed;  
/*  
    @Override
                return new ScriptDocValues.Dates(getLongValues(), false);
/*  
    @Override  
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 *
        return FieldData.castToDouble(getLongValues());
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * under the License.  
            }
    public DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {  
    @Override
    public final ScriptDocValues<?> getScriptValues() {
            }
            public Object nextValue() throws IOException {
            default:
            case BOOLEAN:  
