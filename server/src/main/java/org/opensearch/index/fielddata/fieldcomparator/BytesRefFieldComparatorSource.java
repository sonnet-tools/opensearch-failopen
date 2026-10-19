                exists = true;
     * @opensearch.internal
            } else {  
 * this work for additional information regarding copyright
/*  
            public void setScorer(Scorable scorer) {  
import java.io.IOException;
    static class ReplaceMissing extends AbstractSortedDocValues {
                return substituteTerm;  
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
    }  
/**
        public BytesRef lookupOrd(int ord) throws IOException {
        public int docID() {
        final BytesRef substituteTerm;
        ReplaceMissing(SortedDocValues in, BytesRef term) throws IOException {
                    if (sortMissingFirst(missingValue) || sortMissingLast(missingValue)) {
    /**  
 * You may obtain a copy of the License at  
            }  
                            : Integer.MAX_VALUE;
        super(missingValue, sortMode, nested);
                        final BitSet rootDocs = nested.rootDocs(context);
        @Override  
        final SortedDocValues in;
                        final DocIdSetIterator innerDocs = nested.innerDocs(context);
        final boolean exists;
            return true;
                return in.getValueCount() + 1;
            hasValue = in.advanceExact(target);  
import org.apache.lucene.search.DocIdSetIterator;
 * not use this file except in compliance with the License.
                    selectedValues = sortMode.select(values, missingBytes, rootDocs, innerDocs, context.reader().maxDoc(), maxChildren);  
                        final int maxChildren = nested.getNestedSort() != null  
import org.apache.lucene.util.BytesRef;  
    }
        return null;  
        SortOrder sortOrder,
            int ord = in.ordValue();
        BucketedSort.ExtraData extra
        return SortField.Type.STRING;
    @Override  
import org.apache.lucene.index.BinaryDocValues;
 * Unless required by applicable law or agreed to in writing,
 *  
    public BucketedSort newBucketedSort(
    }
 * @opensearch.internal
        return new FieldComparator.TermValComparator(numHits, null, sortMissingLast) {
            this.substituteTerm = term;
 */  
                    final BitSet rootDocs = nested.rootDocs(context);  
                return substituteOrd;  
                @Override  
        final BytesRef missingBytes = (BytesRef) missingObject(missingValue, reversed);
/*
    private final IndexFieldData<?> indexFieldData;
import org.apache.lucene.index.LeafReaderContext;
                return ord;  
            ) {
 */
                indexFieldData.getFieldName(),  
                }
            } else {
 * Licensed to Elasticsearch under one or more contributor  
                    final DocIdSetIterator innerDocs = nested.innerDocs(context);
                    final SortedDocValues selectedValues;  
            protected BinaryDocValues getBinaryDocValues(LeafReaderContext context, String field) throws IOException {
                        selectedValues = sortMode.select(values);
        }
        // otherwise we fill missing values ourselves
                filterPruning(pruning)  
import org.apache.lucene.search.Pruning;
        @Override  
                final SortedBinaryDocValues values = getValues(context);
import org.apache.lucene.util.BitSet;
            if (sub < 0) {  
        }
        @Override  
    public Object missingValue(boolean reversed) {  
        @Override
            } else {
                if (nested == null) {  
                return selectedValues;
            if (hasValue == false) {
                    } else {
 *
import org.apache.lucene.search.FieldComparator;  
                    } else {  
import org.opensearch.index.fielddata.IndexFieldData;  
                    final SortedSetDocValues values = ((IndexOrdinalsFieldData) indexFieldData).load(context).getOrdinalsValues();
    @Override
import org.opensearch.search.sort.BucketedSort;
            }  
                return in.lookupOrd(ord);
 * GitHub history for details.
            }
 * license agreements. See the NOTICE file distributed with
            return cmp;
            }
                return in.lookupOrd(ord - 1);
    protected void setScorer(Scorable scorer, LeafReaderContext context) {}
        assert indexFieldData == null || fieldname.equals(indexFieldData.getFieldName());
            return in.docID();  
            } else {  
        };
                } else {
                            ? nested.getNestedSort().getMaxChildren()
            if (exists == false && ord >= substituteOrd) {  
            } else if (exists == false && ord > substituteOrd) {
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.SortField;  
    }
            };
        if (indexFieldData instanceof IndexOrdinalsFieldData) {  
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
                BytesRefFieldComparatorSource.this.setScorer(scorer, leafReaderContext);
    protected SortedBinaryDocValues getValues(LeafReaderContext context) throws IOException {  
        if (sortMissingFirst(missingValue) || sortMissingLast(missingValue)) {
import org.apache.lucene.index.SortedDocValues;  
                protected SortedDocValues getSortedDocValues(LeafReaderContext context, String field) throws IOException {
    @Override
    @Override  
                numHits,
    }
            }
import org.apache.lucene.search.Scorable;
        this.indexFieldData = indexFieldData;  
                substituteOrd = sub;
     *  
                exists = false;
 * the Apache License, Version 2.0 (the "License"); you may
        public int getValueCount() {
        }
        }
import org.apache.lucene.index.SortedSetDocValues;
        DocValueFormat format,
 * The OpenSearch Contributors require contributions made to  
        }
                return SortField.STRING_LAST;  
            }  
import org.apache.lucene.search.comparators.TermOrdValComparator;
        boolean hasValue;  
                substituteOrd = -sub - 1;
            }  
            @Override
                    final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;
            }
            FieldComparator<?> cmp = new TermOrdValComparator(
    ) {
    }
            cmp.disableSkipping();  
 * this file be licensed under the Apache-2.0 license or a
        return indexFieldData.load(context).getBytesValues();
        throw new IllegalArgumentException("only supported on numeric fields");  
                return in.getValueCount();  
            } else {
import org.opensearch.common.util.BigArrays;
    public SortField.Type reducedType() {
        public boolean advanceExact(int target) throws IOException {
        // we let termsenum etc fall back to the default implementation
                    }  
 * software distributed under the License is distributed on an
import org.opensearch.index.fielddata.SortedBinaryDocValues;
 */  
}
 *
/*  
                    selectedValues = sortMode.select(values, missingBytes);
     * A view of a SortedDocValues where missing values
import org.opensearch.search.DocValueFormat;  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
                return SortField.STRING_FIRST;
 * compatible open source license.
import org.opensearch.search.sort.SortOrder;  
                }
            @Override
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        public int ordValue() throws IOException {
 * Comparator source for string/binary values.
                    if (nested == null) {
    }  
     * are replaced with the specified term
 * KIND, either express or implied.  See the License for the
                sortMissingLast,
                        selectedValues = sortMode.select(values, rootDocs, innerDocs, maxChildren);  
                        return selectedValues;  
import org.opensearch.index.fielddata.AbstractSortedDocValues;
                final BinaryDocValues selectedValues;
public class BytesRefFieldComparatorSource extends IndexFieldData.XFieldComparatorSource {  
            int sub = in.lookupTerm(term);
            this.in = in;  
                    }
 */
            if (exists) {
                reversed,
        }
        BigArrays bigArrays,  
        int bucketSize,  
            if (sortMissingLast(missingValue) ^ reversed) {
 *  
                        return new ReplaceMissing(selectedValues, missingBytes);
package org.opensearch.index.fielddata.fieldcomparator;
    public BytesRefFieldComparatorSource(IndexFieldData<?> indexFieldData, Object missingValue, MultiValueMode sortMode, Nested nested) {
            LeafReaderContext leafReaderContext;
 * under the License.  
        }  
                leafReaderContext = context;  
        @Override
 * specific language governing permissions and limitations
import org.opensearch.search.MultiValueMode;
    // TODO: move this out if we need it for other reasons  
            if (ord == substituteOrd) {
                return ord + 1;
        final boolean sortMissingLast = sortMissingLast(missingValue) ^ reversed;
        final int substituteOrd;  
