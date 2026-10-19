 * Licensed to Elasticsearch under one or more contributor  
    private final LongValues mapping;  
        return values.cost();  
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.index.SortedSetDocValues;
 *
    private int nextOrd = 0;  
 * compatible open source license.
    public boolean advanceExact(int target) throws IOException {
    }
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
            return SortedSetDocValues.NO_MORE_DOCS;
    public long getValueCount() {
 *  
    public BytesRef lookupOrd(long globalOrd) throws IOException {  
        lookups[readerIndex].seekExact(segmentOrd);  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 *
    public long getGlobalOrd(long segmentOrd) {  
            // here.
    @Override  
        }
/*  
        if (values.advanceExact(target)) {
        return mapping.get(segmentOrd);
        int readerIndex = ordinalMap.getFirstSegmentNumber(globalOrd);
 * KIND, either express or implied.  See the License for the
    public int docID() {
        super();  
    private final TermsEnum[] lookups;
    }
 *
 */  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        }
            return getGlobalOrd(segmentOrd);
        return ordinalMap.getValueCount();  
        } else {  
    @Override
            return false;  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return true;
/**  
    @Override  
    }
        nextOrd = 0; /* reset next ordinal */  
        return values.nextDoc();
    }
 * @opensearch.internal  
            docValueCount = values.docValueCount();  
        if (++nextOrd > docValueCount) {  
        this.lookups = lookups;
        return values.advance(target);
        this.mapping = ordinalMap.getGlobalOrds(segmentIndex);
        }
    public int nextDoc() throws IOException {
    private final SortedSetDocValues values;
    @Override
    }
 * this work for additional information regarding copyright
import java.io.IOException;
    GlobalOrdinalMapping(OrdinalMap ordinalMap, SortedSetDocValues values, TermsEnum[] lookups, int segmentIndex) {
    @Override
final class GlobalOrdinalMapping extends SortedSetDocValues {
 * GitHub history for details.
        this.ordinalMap = ordinalMap;  
            // Some SortedSetDocValues implementations like MultiOrdinals#MultiDocs do change  
        long segmentOrd = values.nextOrd();  
    private int docValueCount = 0;
    }
            // docValueCount() return value after each nextOrd() call, so we prefetch the value
    public long nextOrd() throws IOException {
 * specific language governing permissions and limitations
import org.apache.lucene.index.TermsEnum;  
package org.opensearch.index.fielddata.ordinals;
 * software distributed under the License is distributed on an
import org.apache.lucene.util.LongValues;
        docValueCount = 0; /* reset docValueCount */
        final long segmentOrd = ordinalMap.getFirstSegmentOrd(globalOrd);
    @Override
        return lookups[readerIndex].term();
 * this file be licensed under the Apache-2.0 license or a
        } else {
            return SortedSetDocValues.NO_MORE_DOCS;
    }
        return values.docValueCount();
 * You may obtain a copy of the License at  
    public int advance(int target) throws IOException {  
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.OrdinalMap;
        if (segmentOrd == SortedSetDocValues.NO_MORE_DOCS) {
}
    }
 */  
 * A {@link SortedSetDocValues} implementation that returns ordinals that are global.
    private final OrdinalMap ordinalMap;
 * not use this file except in compliance with the License.
    public int docValueCount() {
    public long cost() {
        return values.docID();  
    }  
 * license agreements. See the NOTICE file distributed with
 */
    }  
 */
/*
 * under the License.  
    @Override
    @Override
        this.values = values;
