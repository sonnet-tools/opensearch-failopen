 *
            }
            } else {
        super(missingValue, sortMode, nested);
                exists = true;
                return ord;
    private final IndexFieldData<?> indexFieldData;
     * @opensearch.internal
/*
                        selectedValues = sortMode.select(values);
        public BytesRef lookupOrd(int ord) throws IOException {
}
        @Override
            if (exists == false && ord >= substituteOrd) {
 */
            FieldComparator<?> cmp = new TermOrdValComparator(
        int bucketSize,
                return SortField.STRING_LAST;
    protected void setScorer(Scorable scorer, LeafReaderContext context) {}
/*
                protected SortedDocValues getSortedDocValues(LeafReaderContext context, String field) throws IOException {
                    selectedValues = sortMode.select(values, missingBytes, rootDocs, innerDocs, context.reader().maxDoc(), maxChildren);
            }
    }
                }
        public int getValueCount() {
            public void setScorer(Scorable scorer) {
        }
                reversed,
 * KIND, either express or implied.  See the License for the
                return SortField.STRING_FIRST;
            ) {
     *
import org.apache.lucene.search.Scorable;
import org.apache.lucene.search.DocIdSetIterator;
            } else {
                numHits,
 *
 * Comparator source for string/binary values.
                    final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;
    @Override
            } else {
                        return selectedValues;
                indexFieldData.getFieldName(),
        @Override
    // TODO: move this out if we need it for other reasons
 * Modifications Copyright OpenSearch Contributors. See
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
                return in.lookupOrd(ord - 1);
                final BinaryDocValues selectedValues;
    ) {
import org.apache.lucene.search.FieldComparator;
     * are replaced with the specified term
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
                    }
                return substituteTerm;
 * this file be licensed under the Apache-2.0 license or a
                    if (sortMissingFirst(missingValue) || sortMissingLast(missingValue)) {
            if (sub < 0) {
            @Override
    @Override
 *
 * the Apache License, Version 2.0 (the "License"); you may
                if (nested == null) {
    public SortField.Type reducedType() {
            }
                exists = false;
            LeafReaderContext leafReaderContext;
        }
        final boolean sortMissingLast = sortMissingLast(missingValue) ^ reversed;
                return selectedValues;
 * under the License.
        SortOrder sortOrder,
import java.io.IOException;
import org.opensearch.search.sort.SortOrder;
                        final BitSet rootDocs = nested.rootDocs(context);
            return in.docID();
        boolean hasValue;
 * @opensearch.internal
        this.indexFieldData = indexFieldData;
 * software distributed under the License is distributed on an
            }
        }
            int sub = in.lookupTerm(term);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.fielddata.AbstractSortedDocValues;
 */
/*
            } else if (exists == false && ord > substituteOrd) {
        public int docID() {
import org.apache.lucene.index.SortedSetDocValues;
import org.opensearch.search.MultiValueMode;
            }
            }
            return true;
    protected SortedBinaryDocValues getValues(LeafReaderContext context) throws IOException {
        @Override
        return null;
 * ownership. Elasticsearch licenses this file to you under
        BucketedSort.ExtraData extra
            } else {
import org.opensearch.search.sort.BucketedSort;
        // we let termsenum etc fall back to the default implementation
import org.apache.lucene.search.SortField;
                filterPruning(pruning)
                    final SortedSetDocValues values = ((IndexOrdinalsFieldData) indexFieldData).load(context).getOrdinalsValues();
import org.opensearch.index.fielddata.IndexFieldData;
                return substituteOrd;
                return in.lookupOrd(ord);
        final boolean exists;
                sortMissingLast,
 * You may obtain a copy of the License at
import org.apache.lucene.search.comparators.TermOrdValComparator;
                    } else {
/**
                        final DocIdSetIterator innerDocs = nested.innerDocs(context);
                return in.getValueCount() + 1;
    public BytesRefFieldComparatorSource(IndexFieldData<?> indexFieldData, Object missingValue, MultiValueMode sortMode, Nested nested) {
        if (indexFieldData instanceof IndexOrdinalsFieldData) {
    public Object missingValue(boolean reversed) {
        assert indexFieldData == null || fieldname.equals(indexFieldData.getFieldName());
 * The OpenSearch Contributors require contributions made to
    /**
                        final int maxChildren = nested.getNestedSort() != null
            return cmp;
                    if (nested == null) {
        public boolean advanceExact(int target) throws IOException {
 * not use this file except in compliance with the License.
            if (hasValue == false) {
 * this work for additional information regarding copyright
            int ord = in.ordValue();
    public BucketedSort newBucketedSort(
        ReplaceMissing(SortedDocValues in, BytesRef term) throws IOException {
        }
            protected BinaryDocValues getBinaryDocValues(LeafReaderContext context, String field) throws IOException {
                return ord + 1;
    }
            if (ord == substituteOrd) {
        }
        @Override
                    }
                } else {
        return new FieldComparator.TermValComparator(numHits, null, sortMissingLast) {
import org.opensearch.common.util.BigArrays;
 * GitHub history for details.
    }
                    } else {
public class BytesRefFieldComparatorSource extends IndexFieldData.XFieldComparatorSource {
            cmp.disableSkipping();
    }
        final BytesRef missingBytes = (BytesRef) missingObject(missingValue, reversed);
import org.opensearch.search.DocValueFormat;
        }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                            : Integer.MAX_VALUE;
        throw new IllegalArgumentException("only supported on numeric fields");
import org.apache.lucene.util.BitSet;
    @Override
        }
            if (sortMissingLast(missingValue) ^ reversed) {
        // otherwise we fill missing values ourselves
import org.apache.lucene.index.BinaryDocValues;
                            ? nested.getNestedSort().getMaxChildren()
            if (exists) {
                return in.getValueCount();
        if (sortMissingFirst(missingValue) || sortMissingLast(missingValue)) {
    @Override
        final BytesRef substituteTerm;
                    final BitSet rootDocs = nested.rootDocs(context);
                substituteOrd = sub;
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
            }
        @Override
                    final DocIdSetIterator innerDocs = nested.innerDocs(context);
        };
    }
 * specific language governing permissions and limitations
                BytesRefFieldComparatorSource.this.setScorer(scorer, leafReaderContext);
        return indexFieldData.load(context).getBytesValues();
        public int ordValue() throws IOException {
 * license agreements. See the NOTICE file distributed with
        }
import org.apache.lucene.index.LeafReaderContext;
                    final SortedDocValues selectedValues;
 *
 * compatible open source license.
        final SortedDocValues in;
import org.apache.lucene.util.BytesRef;
            };
            } else {
        return SortField.Type.STRING;
                leafReaderContext = context;
        BigArrays bigArrays,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            @Override
            this.substituteTerm = term;
            hasValue = in.advanceExact(target);
        DocValueFormat format,
    }
        final int substituteOrd;
                        return new ReplaceMissing(selectedValues, missingBytes);
                        selectedValues = sortMode.select(values, rootDocs, innerDocs, maxChildren);
 */
     * A view of a SortedDocValues where missing values
    }
                final SortedBinaryDocValues values = getValues(context);
 * Licensed to Elasticsearch under one or more contributor
                }
import org.apache.lucene.index.SortedDocValues;
                    selectedValues = sortMode.select(values, missingBytes);
 * Unless required by applicable law or agreed to in writing,
            this.in = in;
    static class ReplaceMissing extends AbstractSortedDocValues {
import org.apache.lucene.search.Pruning;
                substituteOrd = -sub - 1;
                @Override
package org.opensearch.index.fielddata.fieldcomparator;
            }
     */
