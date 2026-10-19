    public Collection<Accountable> getChildResources() {
        return (SortedSetDocValues) DocValues.singleton(new Docs(this, values));
            this.reader = parent.reader;  
     * Doc class  
 *
 *
        }
        final PackedInts.Mutable reader = PackedInts.getMutable(
        return RamUsageEstimator.NUM_BYTES_OBJECT_REF + reader.ramBytesUsed();
import org.apache.lucene.util.Accountables;
            builder.maxDoc(),  
    private final PackedInts.Reader reader;
        public boolean advanceExact(int docID) throws IOException {
            currentDoc = docID;  
    }  
        public int getValueCount() {
import org.apache.lucene.util.Accountable;  
    public SortedSetDocValues ordinals(ValuesHolder values) {
class SinglePackedOrdinals extends Ordinals {
 * @opensearch.internal
    @Override
        // We don't reuse the builder as-is because it might have been built with a higher overhead ratio
    }
    public long ramBytesUsed() {  
        }  
     *
        this.reader = reader;
/*
     * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
    /**
 * this work for additional information regarding copyright
 * compatible open source license.
        }
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        public int docID() {  
 */  
import org.apache.lucene.index.DocValues;
            return values.lookupOrd(ord);
 * Modifications Copyright OpenSearch Contributors. See
        @Override
    @Override  
}
import org.apache.lucene.util.BytesRef;
 * license agreements. See the NOTICE file distributed with
        assert builder.getNumMultiValuesDocs() == 0;
            return currentOrd != -1;
 * specific language governing permissions and limitations
package org.opensearch.index.fielddata.ordinals;
 * Licensed to Elasticsearch under one or more contributor  
        }  
 * KIND, either express or implied.  See the License for the
        PackedInts.copy(builder.getFirstOrdinals(), 0, reader, 0, builder.maxDoc(), 8 * 1024);
import java.io.IOException;
import java.util.Collection;
            PackedInts.bitsRequired(valueCount),
 * under the License.  
            this.values = values;
 * You may obtain a copy of the License at  
            acceptableOverheadRatio
            return currentDoc;
        private int currentOrd;
            this.maxOrd = parent.valueCount;
    private final int valueCount;
import org.apache.lucene.util.packed.PackedInts;
 * The OpenSearch Contributors require contributions made to  
        @Override
        this.valueCount = (int) builder.getValueCount();  
 *
 */  
        private int currentDoc = -1;
 * Packed ordinals for a single field  
            currentOrd = (int) (reader.get(docID) - 1);
        }
 * ownership. Elasticsearch licenses this file to you under  
 *  
            return maxOrd;  
        public int ordValue() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
    }  
import org.opensearch.index.fielddata.AbstractSortedDocValues;
    @Override
/**
 * software distributed under the License is distributed on an
        Docs(SinglePackedOrdinals parent, ValuesHolder values) {
        }
        );  
import java.util.Collections;  
        @Override  
        @Override
    }  
    // ordinals with value 0 indicates no value  
        private final ValuesHolder values;
 */
        @Override
        private final int maxOrd;  
 * GitHub history for details.
    public SinglePackedOrdinals(OrdinalsBuilder builder, float acceptableOverheadRatio) {
     */  
    }
import org.apache.lucene.index.SortedSetDocValues;
    private static class Docs extends AbstractSortedDocValues {
        public BytesRef lookupOrd(int ord) {
import org.apache.lucene.util.RamUsageEstimator;  
 * SPDX-License-Identifier: Apache-2.0
        return Collections.singleton(Accountables.namedAccountable("reader", reader));  
 * Unless required by applicable law or agreed to in writing,
/*  
/*  
        private final PackedInts.Reader reader;
            return currentOrd;
 *    http://www.apache.org/licenses/LICENSE-2.0
