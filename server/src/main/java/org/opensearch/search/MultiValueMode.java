    protected BytesRef pick(
        @Override
            int endDoc,
        }
                    if (values.advanceExact(target)) {
                }
        ) throws IOException {
                    }
     * Allowed Modes: SUM, AVG, MIN, MAX
            public int advance(int target) throws IOException {
 * Unless required by applicable law or agreed to in writing,
     * Pick the median of the values.
            for (int index = 0; index < count; ++index) {
        @Override
                @Override
            DocIdSetIterator docItr,
        }
                return true;
            }
    SUM {
                public boolean advanceExact(int target) throws IOException {
                    final long docMax = pick(values);
            return singleton;
     * Allowed Modes: MIN, MAX
    /**
            public boolean advanceExact(int parentDoc) throws IOException {
                @Override
        protected double pick(SortedNumericDoubleValues values) throws IOException {
            return new AbstractNumericDocValues() {
                    hasValue = true;
        }
                return docID;
     * <p>
                    final int docCount = values.docValueCount();
        return quotient + Math.round((double) rem / divisor);
                public int advance(int target) throws IOException {
 */
                if (values.advanceExact(doc)) {
            final int count = values.docValueCount();
        @Override
     */
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
                if (values.advanceExact(doc)) {
                lastEmittedValue = pick(selectedValues, builder, childDocs, firstChildDoc, parentDoc, maxChildren);
            }
        protected int pick(SortedDocValues values, DocIdSetIterator docItr, int startDoc, int endDoc, int maxChildren) throws IOException {
                        totalValue += values.nextValue();
            return hasValue ? ord : -1;
        final SortedDocValues selectedValues = select(values);
        @Override
/*
            return new AbstractBinaryDocValues() {
        protected int pick(SortedSetDocValues values) throws IOException {
 */
        }
     * with this mode and the provided values. When a document has no value,
            return values.nextValue();
        }
                }
            long missingValue,
import org.opensearch.index.fielddata.AbstractBinaryDocValues;
                max = val;
                        return missingValue != null;
                if (target >= maxDoc) {
import org.opensearch.core.common.io.stream.StreamInput;
                    return value;
        final long missingValue,
                    hasValue = true;
        protected double pick(SortedNumericDoubleValues values) throws IOException {
            }
                }
    /**
                }
                return (values.nextValue() + values.nextValue()) / 2;
            long maxOrd = -1;
                        return true;
                }
                        break;
        ) throws IOException {
            long firstValue = values.nextValue();
                public double doubleValue() throws IOException {
                    }
     * <p>
 * @opensearch.api
import org.opensearch.index.fielddata.NumericDoubleValues;
                    this.value = singleton.advanceExact(target) ? singleton.binaryValue() : missingValue;
            SortedNumericDoubleValues values,
                    final int docCount = values.docValueCount();
     * <p>
            if (totalCount < 1) {
            long total = 0;
        }
                final int firstChildDoc;
        ) throws IOException {
                        break;
     */
                        builder.copyBytes(innerValue);
                if (childDocs.docID() > prevParentDoc) {
                final int firstChildDoc;
                return true;
     * Copied from {@link Long#divideUnsigned(long, long)} and {@link Long#remainderUnsigned(long, long)}
                    return max;
        return new AbstractBinaryDocValues() {
                    }
            for (int i = 0; i < count - 1; ++i) {
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);
        ) throws IOException {
            int endDoc,
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
                }
    }
                    ord = Math.min(ord, innerOrd);
                        break;
            long max = values.nextValue();
            long total = 0;
            int count = 0;
        }
            long lastEmittedValue = missingValue;
        @Override
            }
                        totalValue += values.nextValue();
     */
        protected long pick(SortedNumericDocValues values) throws IOException {
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);
     * <p>
                if (lastEmittedValue == null) {
            DocIdSetIterator docItr,
                        break;
                if (max < 0 && val >= 0) {
                final int firstChildDoc;
            int count = 0;
        }
                lastEmittedValue = pick(values, missingValue, childDocs, firstChildDoc, parentDoc, maxChildren);
        SortedNumericDocValues values,
                    totalCount += docCount;
            return totalCount > 1 ? divideUnsignedAndRoundUp(totalValue, totalCount) : totalValue;
    public SortedDocValues select(final SortedSetDocValues values) {
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
            }
                lastSeenParentDoc = parentDoc;
                        return true;
        }
                @Override
            public BytesRef binaryValue() throws IOException {
            long total = 0;
    },
                } else if (parentDoc == 0) {
        }
            long totalValue = 0;
                    }
            @Override
                    ord = Math.max(ord, values.ordValue());
        ) throws IOException {
@PublicApi(since = "1.0.0")
                    return values.lookupOrd(ord);
            for (int i = 0; i < (count - 1) / 2; ++i) {
     */
            SortedNumericUnsignedLongValues values,
        protected int pick(SortedDocValues values, DocIdSetIterator docItr, int startDoc, int endDoc, int maxChildren) throws IOException {
                    }
            DocIdSetIterator docItr,
    public NumericDocValues select(
     * with this mode, the provided values and filters for root/inner documents.
import java.util.Locale;
    }
        int startDoc,
            }
                        break;
            int lastSeenParentDoc = 0;
 * license agreements. See the NOTICE file distributed with
        int maxDoc,
            }
        }
        @Override
import org.opensearch.index.fielddata.SortedNumericUnsignedLongValues;
            int docID = -1;
            @Override
            int lastEmittedOrd = -1;
        int endDoc,
        int maxChildren
                    if (values.advanceExact(target)) {
        int maxChildren
                if (target >= maxDoc) {
            double lastEmittedValue = missingValue;
            DocIdSetIterator docItr,
            );
                long val = values.nextValue();
     * with this mode, the provided values and filters for root/inner documents.
        @Override
        if (parentDocs == null || childDocs == null) {
                return target;
                return lastEmittedValue;
     */
            } else if (count == 2) {
            int count = 0;
                // sparse: find the next parent doc at or after target that actually has an ord.
            int count = 0;
     * <p>
                public boolean advanceExact(int target) throws IOException {
                    }
        } else {
            SortedNumericDoubleValues values,
     * with this mode, the provided values and filters for root/inner documents.
            return bytesRefBuilder == null ? null : bytesRefBuilder.get();
    AVG {
            int startDoc,
 * The OpenSearch Contributors require contributions made to
     * <p>
            int count = 0;
                    return value;
                return (total >>> 1) + (total & 1);
    }
        int endDoc,
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
            int endDoc,
                }
     * Allowed Modes: MIN, MAX
            DocIdSetIterator docItr,
                return (total >>> 1) + (total & 1);
     * Pick the lowest value.
            }
                    if (++count > maxChildren) {
            return bytesRefBuilder == null ? null : bytesRefBuilder.get();
                @Override
     * <p>
                }
        @Override
        protected double pick(SortedNumericDoubleValues values) throws IOException {
        int maxChildren
        }
                    maxValue = Math.max(maxValue, values.nextValue());
                return values.nextValue();
        }
        final SortedNumericDocValues values,
                    if (values.advanceExact(target)) {
        if (parentDocs == null || childDocs == null) {
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
                    if (++count > maxChildren) {
            @Override
    ) throws IOException {
                }
                    }
            if (totalCount < 1) {
        } else {
        protected long pick(
                        totalValue += values.nextValue();
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
            };
        final BitSet parentDocs,
                }
                }
            @Override
    ) throws IOException {
            public boolean advanceExact(int parentDoc) throws IOException {
    ) throws IOException {
            int maxChildren
            @Override
                    for (int index = 0; index < docCount; ++index) {
            }
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
                long total = docValues[mid] + docValues[(mid + 1) % count];
            double totalValue = 0;
    public NumericDocValues select(final SortedNumericDocValues values) {
                return target;
            public double doubleValue() throws IOException {
            } else {
        final SortedDocValues singleton = DocValues.unwrapSingleton(values);
                public int ordValue() {
    private static long divideUnsignedAndRoundUp(long dividend, long divisor) {
        } else {
            boolean hasValue = false;
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
        @Override
            }
            final int count = values.docValueCount();
    MIN {
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            long lastEmittedValue = missingValue;
    public void writeTo(StreamOutput out) throws IOException {
                if (values.advanceExact(doc)) {
            DocIdSetIterator docItr,
            @Override
            int endDoc,
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
            int maxChildren
                        values.nextValue();
 * SPDX-License-Identifier: Apache-2.0
            final int count = values.docValueCount();
                    if (parentDoc + 1 >= parentDocs.length()) {
            }
            SortedNumericDocValues values,
            int count = values.docValueCount();
            int lastSeenParentDoc = 0;
                private long value;
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
                    parentDoc = parentDocs.nextSetBit(parentDoc + 1);
        double missingValue,
     * For every root document, the values of its inner documents will be aggregated.
    protected int pick(SortedDocValues values, DocIdSetIterator docItr, int startDoc, int endDoc, int maxChildren) throws IOException {
        }
            int endDoc,
        final BitSet parentDocs,
                    return false;
            long missingValue,
                // every parent doc has a value and advance() positions directly on target.
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
    protected double pick(SortedNumericDoubleValues values) throws IOException {
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
        protected long pick(
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
                    hasValue = true;
    public NumericDocValues select(
                    if (++count > maxChildren) {
                public int getValueCount() {
        @Override
     * <p>
                    }
        @Override
            return totalCount > 1 ? Math.round((double) totalValue / (double) totalCount) : totalValue;
        }
                }
 * You may obtain a copy of the License at
     * Return a {@link BinaryDocValues} instance that can be used to sort documents
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
    };
                advanceExact(target);
     */
            double total = 0;
        @Override
                    if (++count > maxChildren) {
        final BitSet parentDocs,
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);
            @Override
        protected int pick(SortedSetDocValues values) throws IOException {
                if (values.advanceExact(doc)) {
        protected double pick(
     * Pick the highest value.
     * <code>missingValue</code> is returned.
        final NumericDoubleValues singleton = FieldData.unwrapSingleton(values);
 * KIND, either express or implied.  See the License for the
        out.writeEnum(this);
            return totalCount > 0 ? totalValue : missingValue;
        }
            int totalCount = 0;
                return docValues[mid];
            final int count = values.docValueCount();
    public NumericDoubleValues select(final SortedNumericDoubleValues values) {
        final BytesRef missingValue,
    }
        }
            final int count = values.docValueCount();
            public int docID() {
                }
            if (count % 2 == 0) {
            }
            }
                }
                }
            int lastSeenParentDoc = -1;
            @Override
        SortedNumericUnsignedLongValues values,
            SortedNumericUnsignedLongValues values,
                @Override
    }
            return hasValue ? maxValue : missingValue;
                    return values.docID();
            }
            }
            }
import org.apache.lucene.util.BitSet;
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
                return firstValue;
                values.nextValue();
        }
            BytesRef lastEmittedValue = missingValue;
                    return lastEmittedOrd != -1;
                total += values.nextValue();
                if (docValues[i] >= 0 && firstPositiveIndex == 0) {
                return lastEmittedOrd;
                // advanceExact always returns true (missing value emitted when no children match), so
                    return this.value;
            }
        }
        protected double pick(SortedNumericDoubleValues values) throws IOException {
                private long value;
            int count = 0;
        ) throws IOException {
    protected long pick(
                    firstChildDoc = childDocs.docID();
            }
            long maxValue = Long.MIN_VALUE;
                }
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
                    }
        @Override
                        }
     * Pick the average of all the values.
                if (target >= parentDocs.length()) {
import org.opensearch.index.fielddata.AbstractNumericDocValues;
     * Return a {@link SortedDocValues} instance that can be used to sort documents
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
     */
    }
        final double missingValue,
 */
    ) throws IOException {
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
            }
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            DocIdSetIterator docItr,
            public int ordValue() {
                    return lastSeenParentDoc = DocIdSetIterator.NO_MORE_DOCS;
                    } else {
            int count = 0;
            for (int i = 1; i < count; ++i) {
import org.opensearch.common.Numbers;
     * If none of the inner documents has a value, then <code>missingValue</code> is returned.
                final int firstChildDoc;
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
                // every parent doc has a value and advance() positions directly on target.
            public int docID() {
                        break;
            return hasValue ? maxValue : missingValue;
            };
            }
import org.apache.lucene.index.SortedSetDocValues;
        int maxDoc,
            return values.nextValue();
                return lastEmittedValue;
        protected double pick(SortedNumericDoubleValues values) throws IOException {
        } catch (Exception e) {
        ) throws IOException {
     * Allowed Modes: MIN, MAX
            @Override
                }
                        value = pick(values);
                }
            return singleton;
                public int docID() {
                }
    /**
                    if (bytesRefBuilder == null) {
                    hasValue = true;
            }
import org.opensearch.index.fielddata.AbstractSortedDocValues;
                    values.nextValue();
            public int docID() {
     * <p>
        return new NumericDoubleValues() {
            return select(DocValues.emptySortedSet());
    public static MultiValueMode readMultiValueModeFrom(StreamInput in) throws IOException {
        return new AbstractNumericDocValues() {
                    final int innerOrd = values.ordValue();
            int totalCount = 0;
    }
            double missingValue,
            }
    protected long pick(
            BytesRefBuilder builder,
                }
                lastEmittedValue = pick(values, missingValue, childDocs, firstChildDoc, parentDoc, maxChildren);
        int endDoc,
            int count = 0;
    public BinaryDocValues select(
    ) throws IOException {
            DocIdSetIterator docItr,
                if (values.advanceExact(doc)) {
            int startDoc,
        @Override
        protected double pick(
        }
                }
                    } else {
                while (parentDoc != DocIdSetIterator.NO_MORE_DOCS) {
            @Override
            int startDoc,
                "fields containing more than " + (Integer.MAX_VALUE - 1) + " unique terms are unsupported"
        BinaryDocValues values,
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
                        return docID = parentDoc;
            for (int index = 0; index < count; ++index) {
    }
                @Override
                if (values.advanceExact(doc)) {
                total += values.nextValue();
        final DocIdSetIterator childDocs,
            long missingValue,
            long minValue = Long.MAX_VALUE;
        final NumericDocValues singleton = DocValues.unwrapSingleton(sortedNumericDocValues);
            int maxChildren
    protected long pick(SortedNumericDocValues values) throws IOException {
            if (totalCount < 1) {
                    }
            return values.nextValue();
            int totalCount = 0;
                private BytesRef value;
    },
                } else {
 */
            int maxChildren
        if (singleton != null) {
                return singleton;
            SortedNumericDocValues values,
                final int firstChildDoc;
                lastEmittedOrd = pick(selectedValues, childDocs, firstChildDoc, parentDoc, maxChildren);
     */
            DocIdSetIterator docItr,
            final int count = values.docValueCount();
                    if (++count > maxChildren) {
            return FieldData.replaceMissing(DocValues.emptyNumeric(), missingValue);
import org.opensearch.index.fielddata.FieldData;
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
        ) throws IOException {
            int count = values.docValueCount();
            boolean hasValue = false;
        }
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            boolean hasValue = false;
    /**
     * For every root document, the values of its inner documents will be aggregated.
                    return false;
            DocIdSetIterator docItr,
                        return true;
            }
                int parentDoc = parentDocs.nextSetBit(target);
            int lastSeenParentDoc = -1;
                        return true;
                    return values.docID();
                        if (max == innerValue) {
            return singleton;
        }
            int maxChildren
        protected long pick(SortedNumericDocValues values) throws IOException {
     * <p>
        final SortedBinaryDocValues values,
        }
     * <p>
                return docID = DocIdSetIterator.NO_MORE_DOCS;
            DocIdSetIterator docItr,
                    return values.advance(target);
                @Override
                return lastEmittedOrd != -1;
                    }
    /**
                    hasValue = true;
            return count > 1 ? Math.round((double) total / (double) count) : total;
                        value = missingValue;
        long missingValue,
        int maxDoc,
                    }
     * <code>missingValue</code> is returned.
                advanceExact(target);
     * Return a {@link NumericDoubleValues} instance that can be used to sort documents
    }
        int maxChildren
        final DocIdSetIterator childDocs,
                    long total = values.nextValue() + values.nextValue();
                if (values.advanceExact(doc)) {
                public BytesRef binaryValue() throws IOException {
                        final BytesRef max = bytesRefBuilder.get().compareTo(innerValue) > 0 ? bytesRefBuilder.get() : innerValue;
import org.apache.lucene.index.BinaryDocValues;
                values.nextValue();
                    if (++count > maxChildren) {
                        break;
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            public int advance(int target) throws IOException {
            int endDoc,
                if (val >= 0) {
                    }
        try {
                    }
                        ord = -1;
                return true;
            if (missingValue == null) {
/*
                    if (++count > maxChildren) {
            int startDoc,
            long missingValue,
 *
                return selectedValues.lookupOrd(ord);
            int maxChildren
        int maxChildren
            return count > 1 ? divideUnsignedAndRoundUp(total, count) : total;
     * <p>
        int maxChildren
                        break;
            return new AbstractSortedDocValues() {
                    }
import org.apache.lucene.index.SortedNumericDocValues;
 * software distributed under the License is distributed on an
    MEDIAN {
            public int docID() {
                    final int docCount = values.docValueCount();
     *       The returned instance can only be evaluate the current and upcoming docs
            return values.nextValue();
                }
            }
        DocIdSetIterator docItr,
 * this file be licensed under the Apache-2.0 license or a
                    }
                }
                        totalValue += values.nextValue();
    /**
                int ord;
                }
        @Override
                lastEmittedValue = pick(values, missingValue, childDocs, firstChildDoc, parentDoc, maxChildren);
     */
                }
            int count = 0;
     */
            public long longValue() {
                    if (advanceExact(parentDoc)) {
            }
                }
                        break;
            double missingValue,
            int startDoc,
        if (values.getValueCount() >= Integer.MAX_VALUE) {
import org.apache.lucene.index.NumericDocValues;
                    return lastSeenParentDoc = DocIdSetIterator.NO_MORE_DOCS;
        int startDoc,
            }
        if (singleton != null) {
        }
        }
            for (int i = 0; i < count - 1; ++i) {
                    if (values.advanceExact(target)) {
                } else {
    }
            long maxValue = Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG;
                    final int docCount = values.docValueCount();
                if (parentDoc == lastSeenParentDoc) {
        protected long pick(SortedNumericDocValues values) throws IOException {
                public long longValue() throws IOException {
                    return true;
 *
                    return true;
        ) throws IOException {
        @Override
     * <p>
                    minValue = Long.compareUnsigned(docMin, minValue) < 0 ? docMin : minValue;
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
            boolean hasValue = false;
 *    http://www.apache.org/licenses/LICENSE-2.0
                advanceExact(target);
            return totalValue / totalCount;
                    return DocIdSetIterator.NO_MORE_DOCS;
                    totalCount += docCount;
            final long min = values.nextValue();
    /**
                }
        }
            int startDoc,
            return Math.toIntExact(maxOrd);
        }
                    final int docCount = values.docValueCount();
        int startDoc,
        DocIdSetIterator docItr,
                lastSeenParentDoc = parentDoc;
        };
                @Override
            SortedNumericDoubleValues values,
        final long rem = r - ((~(r - divisor) >> (Long.SIZE - 1)) & divisor);
     * Return a {@link NumericDocValues} instance that can be used to sort root documents
                    for (int index = 0; index < docCount; ++index) {
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
                if (childDocs.docID() > prevParentDoc) {
                    totalCount += docCount;
            }
            }
                return selectedValues.getValueCount();
 * under the License.
            return FieldData.replaceMissing(DocValues.emptyNumeric(), missingValue);
        SortedNumericDoubleValues values,
                // advanceExact always returns true (missing value emitted when no children match), so
                values.nextValue();
     * <p>
            int endDoc,
                    return false;
                    }
            int startDoc,
    MAX {
            int count = 0;
                    lastEmittedValue = missingValue;
     * Allowed Modes: MIN, MAX
            int startDoc,
    }
                            bytesRefBuilder.copyBytes(max);
            }
        @Override
                        }
    /**
        return new AbstractNumericDocValues() {
            BytesRefBuilder builder,
        final long q = (dividend >>> 1) / divisor << 1;
 * Modifications Copyright OpenSearch Contributors. See
            return new AbstractBinaryDocValues() {
        final BitSet parentDocs,
            int count = 0;
            }
                    minValue = Math.min(minValue, values.nextValue());
            public int advance(int target) throws IOException {
        @Override
            public BytesRef lookupOrd(int ord) throws IOException {
     * For every root document, the values of its inner documents will be aggregated.
     * Pick the sum of all the values.
            }
                    if (bytesRefBuilder == null) {
        DocIdSetIterator docItr,
                } else if (parentDoc == 0) {
                if (parentDoc == lastSeenParentDoc) {
            int count = 0;
        final BitSet parentDocs,
     * Return a {@link BinaryDocValues} instance that can be used to sort root documents
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
        }
            long missingValue,
                        break;
            }
            @Override
     * Return a {@link NumericDocValues} instance that can be used to sort documents
                        totalValue += values.nextValue();
            public boolean advanceExact(int parentDoc) throws IOException {
        };
                    for (int i = 0; i < docCount - 1; ++i) {
                    firstChildDoc = childDocs.docID();
                } else {
        @Override
                        final BytesRef min = bytesRefBuilder.get().compareTo(innerValue) <= 0 ? bytesRefBuilder.get() : innerValue;
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);
                return missingValue;
/*
            int ord = Integer.MAX_VALUE;
                }
        final SortedSetDocValues values,
                        builder.copyBytes(innerValue);
                private double value;
                return Math.round(((double) values.nextValue() + values.nextValue()) / 2);
    public NumericDocValues select(final SortedNumericUnsignedLongValues values) {
                }
            }
        final BinaryDocValues singleton = FieldData.unwrapSingleton(values);
            }
            DocIdSetIterator docItr,
            int startDoc,
            int firstPositiveIndex = 0;
                }
                    maxValue = Math.max(maxValue, values.nextValue());
                @Override
            SortedNumericDocValues values,
        long missingValue,
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
                    for (int index = 0; index < docCount; ++index) {
                    if (++count > maxChildren) {
                    }
        int maxChildren
            return total / count;
                        totalValue += values.nextValue();
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            }
                    return (int) values.getValueCount();
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming root docs";
     * Allowed Modes: MIN, MAX
     * Return a {@link SortedDocValues} instance that can be used to sort root documents
            @Override
     */
            int count = 0;
            if (count == 1) {
            long totalValue = 0;
        if (values instanceof LongToSortedNumericUnsignedLongValues longValues) {
            return totalCount > 0 ? totalValue : missingValue;
     * <p>
        @Override
                }
    },
    }
    public SortedDocValues select(
                    totalCount += docCount;
            return total;
                }
            }
                // every parent doc has a value and advance() positions directly on target.
        @Override
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
    /**
            return values.nextValue();
            int endDoc,
                    for (int index = 0; index < docCount; ++index) {
                    firstChildDoc = childDocs.docID();
            return singleton;
                    return true;
            } else {
                return true;
                if (values.advanceExact(doc)) {
     * Return a {@link NumericDoubleValues} instance that can be used to sort documents
            int maxChildren
    public NumericDoubleValues select(
     */
                    }
                }
                // advanceExact always returns true (missing value emitted when no children match), so
public enum MultiValueMode implements Writeable {
                    if (++count > maxChildren) {
                    return docID = DocIdSetIterator.NO_MORE_DOCS;
            }
                }
        }
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
        final DocIdSetIterator childDocs,
                }
            }
                if (childDocs.docID() > prevParentDoc) {
                    if (++count > maxChildren) {
                }
                    return (total >>> 1) + (total & 1);
            @Override
                    return value;
                long total = firstValue + values.nextValue();
    ) throws IOException {
        int endDoc,
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);
                }
    /**
                    totalCount += docCount;
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming root docs";
        }
        @Override
                    if (++count > maxChildren) {
            };
        protected BytesRef pick(
        final DocIdSetIterator childDocs,
            }
            }
     * For every root document, the values of its inner documents will be aggregated.
                }
                }
                }
            int endDoc,
        final DocIdSetIterator childDocs,
            int ord = -1;
                    return ord;
                } else {
                    }
    ) throws IOException {
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
                    assert ord != -1;
    }
            return hasValue ? minValue : missingValue;
import org.opensearch.core.common.io.stream.StreamOutput;
            return hasValue ? maxValue : missingValue;
                        break;
        @Override
    }
                        break;
            return new NumericDoubleValues() {
                if (values.advanceExact(doc)) {
    }
 * Defines what values to pick in the case a document contains multiple values for a particular field.
        protected BytesRef pick(SortedBinaryDocValues values) throws IOException {
                    }
            long totalValue = 0;
        };
    /**
            SortedNumericUnsignedLongValues values,
                @Override
            return total;
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);
                total += values.nextValue();
                if (parentDoc == lastSeenParentDoc) {
                return target;
        }
        protected long pick(SortedNumericDocValues values) throws IOException {
            };
            }
            int maxChildren
     * Allowed Modes: SUM, AVG, MEDIAN, MIN, MAX
                values.nextValue();
                docID = lastSeenParentDoc = parentDoc;
        final BinaryDocValues selectedValues = select(values, null);
            return ord;
            public boolean advanceExact(int parentDoc) throws IOException {
                        value = pick(values);
        protected double pick(
            final long[] docValues = new long[count];
        }
        ) throws IOException {
     * Return a {@link NumericDoubleValues} instance that can be used to sort root documents
                    for (int index = 0; index < docCount; ++index) {
     * A case insensitive version of {@link #valueOf(String)}
        protected long pick(SortedNumericDocValues values) throws IOException {
                advanceExact(target);
                    return lastSeenParentDoc = DocIdSetIterator.NO_MORE_DOCS;
                    return true;
            }
        if (singleton != null) {
        protected long pick(
                if (values.advanceExact(doc)) {
        final long missingValue,
            for (int index = 0; index < count; ++index) {
            long missingValue,
                    return true;
     * If none of the inner documents has a value, then <code>missingValue</code> is returned.
                return lastSeenParentDoc;
                    if (++count > maxChildren) {
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                    if (++count > maxChildren) {
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
        final SortedNumericDoubleValues values,
            public boolean advanceExact(int parentDoc) throws IOException {
        }
        }
                            bytesRefBuilder.copyBytes(min);
            int maxChildren
                    hasValue = true;
            for (int i = 1; i < count; ++i) {
            boolean hasValue = false;
            long totalValue = 0;
                    if (values.advanceExact(target)) {
            while ((count-- > 0) && (ord = values.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {
                if (values.advanceExact(doc)) {
                }
import org.opensearch.index.fielddata.LongToSortedNumericUnsignedLongValues;
            double missingValue,
import org.apache.lucene.search.DocIdSetIterator;
 * specific language governing permissions and limitations
     * with this mode and the provided values. When a document has no value,
        protected long pick(
                    return values.nextValue();
            long val;
            docValues[0] = firstValue;
        protected long pick(
            int totalCount = 0;
                    final BytesRef innerValue = values.binaryValue();
            int count = 0;
            public long longValue() {
                if (childDocs.docID() > prevParentDoc) {
import org.apache.lucene.util.BytesRefBuilder;
}
                    }
    }
            int maxChildren
        ) throws IOException {
                private BytesRef value;
    public BinaryDocValues select(final SortedBinaryDocValues values, final BytesRef missingValue) {
        };
        @Override
            }
                    firstChildDoc = childDocs.docID();
            int count = values.docValueCount();
            final int mid = ((count - 1) / 2 + firstPositiveIndex) % count;
            SortedNumericUnsignedLongValues values,
                }
        @Override
                }
            int startDoc,
                return target;
        assert divisor > 0;
                return lastSeenParentDoc;
                public int docID() {
            @Override
                return values.nextValue();
                }
            return FieldData.replaceMissing(FieldData.emptyNumericDouble(), missingValue);
            return max;
        }
            if (count % 2 == 0) {
                        values.nextValue();
            }
     * Return a {@link SortedDocValues} instance that can be used to sort root documents
                docValues[i] = values.nextValue();
        int startDoc,
        @Override
            int maxChildren
                    }
     */
                }
        @Override
        @Override
                if (values.advanceExact(doc)) {
package org.opensearch.search;
                    }
                    final int docCount = values.docValueCount();
     */
            @Override
            @Override
 * Licensed to Elasticsearch under one or more contributor
     * <p>
                public BytesRef binaryValue() throws IOException {
    protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
 *
        }
            BinaryDocValues values,
                    return val;
                if (parentDoc == lastSeenParentDoc) {
                }
                public boolean advanceExact(int target) throws IOException {
        final SortedNumericUnsignedLongValues values,
                    if (++count > maxChildren) {
                @Override
    /**
            for (int index = 0; index < count; ++index) {
 *
                public boolean advanceExact(int target) throws IOException {
                    if (++count > maxChildren) {
 * this work for additional information regarding copyright
     *       The returned instance can only be evaluate the current and upcoming docs
            DocIdSetIterator docItr,
    /**
            @Override
                    if (++count > maxChildren) {
                    final int docCount = values.docValueCount();
                    }
            }
            if (count == 1 || min > 0) {
            }
                }
                        return false;
                return lastEmittedValue;
            }
                lastSeenParentDoc = parentDoc;
        protected long pick(
            for (int i = 1; i < count; ++i) {
            return valueOf(sortMode.toUpperCase(Locale.ROOT));
                    }
                    } else {
            throw new UnsupportedOperationException(
            @Override
                        ord = pick(values);
            for (int i = 0; i < count - 1; ++i) {
        int maxDoc,
            return hasValue ? minValue : missingValue;
                        if (min == innerValue) {
        @Override
        @Override
                if (values.advanceExact(doc)) {
                    return true;
                if (target >= maxDoc) {
        ) throws IOException {
     * with this mode and the provided values. When a document has no value,
                    }
            SortedNumericDoubleValues values,
    ) throws IOException {
            }
    protected BytesRef pick(SortedBinaryDocValues values) throws IOException {
            }
            int startDoc,
            int endDoc,
                    totalCount += docCount;
        if (parentDocs == null || childDocs == null) {
    }
     * <p>
        return in.readEnum(MultiValueMode.class);
        protected BytesRef pick(
            int endDoc,
        }
                public BytesRef lookupOrd(int ord) throws IOException {
     *       The returned instance can only be evaluate the current and upcoming docs
                @Override
        int maxChildren
     * @throws IllegalArgumentException if the given string doesn't match a sort mode or is <code>null</code>.
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
                }
                    }
    /**
            int endDoc,
            final int count = values.docValueCount();
                    for (int index = 0; index < docCount; ++index) {
    }
     *       The returned instance can only be evaluate the current and upcoming docs
            DocIdSetIterator docItr,
                    hasValue = true;
                        break;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            int startDoc,
    }
                val = values.nextValue();
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
            }
            int count = values.docValueCount();
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
        if (parentDocs == null || childDocs == null) {
            final int count = values.docValueCount();
import org.apache.lucene.index.SortedDocValues;
    public static MultiValueMode fromString(String sortMode) {
            return values.nextValue();
        protected long pick(
                    lastEmittedValue = missingValue;
            } else if (firstValue >= 0) {
            public int advance(int target) throws IOException {
                }
            BytesRefBuilder bytesRefBuilder = null;
        DocIdSetIterator docItr,
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
                if (values.advanceExact(doc)) {
    ) throws IOException {
            }
    }
            }
        if (singleton != null) {
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming parent docs";
                public long longValue() throws IOException {
        } else {
            for (int index = 0; index < count; ++index) {
        ) throws IOException {
    protected int pick(SortedSetDocValues values) throws IOException {
        final long quotient = q + ((r | ~(r - divisor)) >>> (Long.SIZE - 1));
    }
        }
                // every parent doc has a value and advance() positions directly on target.
                    return values.docID();
                }
    }
        }
            };
            int startDoc,
            int maxChildren
                @Override
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
     * <code>missingValue</code> is returned.
            @Override
            throw new IllegalArgumentException("Illegal sort mode: " + sortMode);
            long missingValue,
        @Override
                // advanceExact always returns true (missing value emitted when no children match), so
        @Override
                return missingValue;
            double missingValue,
                        bytesRefBuilder = builder;
            boolean hasValue = false;
 * not use this file except in compliance with the License.
            }
    }
            @Override
        }
        SortedNumericDocValues sortedNumericDocValues = null;
            int count = values.docValueCount();
            for (int i = 0; i < (count - 1) / 2; ++i) {
                @Override
            }
            int count = 0;
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            BinaryDocValues values,
/**
                    final long docMin = pick(values);
        ) throws IOException {
     * <p>
        int maxChildren
            final BytesRefBuilder builder = new BytesRefBuilder();
            boolean hasValue = false;
                }
                    firstPositiveIndex = i;
            int totalCount = 0;
            final int count = values.docValueCount();
                    } else {
            int endDoc,
        protected long pick(
                    maxValue = Long.compareUnsigned(maxValue, docMax) < 0 ? docMax : maxValue;
                        value = pick(values);
        }
    /**
                values.nextValue();
import org.opensearch.core.common.io.stream.Writeable;
                } else {
     * with this mode, the provided values and filters for root/inner documents.
        }
     */
                return min;
            long missingValue,
                    for (int i = 0; i < docCount - 1; ++i) {
            long ord;
     * <code>missingValue</code> is returned.
                    final int docCount = values.docValueCount();
     * <p>
            } else {
 * ownership. Elasticsearch licenses this file to you under
            sortedNumericDocValues = longValues.getNumericUnsignedLongValues();
                    final BytesRef innerValue = values.binaryValue();
            }
        protected double pick(
                    }
            return new AbstractNumericDocValues() {
                for (int i = 1; i < (count - 1) / 2; ++i) {
                total += values.nextValue();
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
     * with this mode, the provided values and filters for root/inner documents.
            @Override
        @Override
                return missingValue;
            SortedNumericDocValues values,
            double totalValue = 0;
                }
            int lastSeenParentDoc = 0;
                lastSeenParentDoc = parentDoc;
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming parent docs";
            for (int index = 0; index < count; ++index) {
                }
                        break;
    /**
            final int count = values.docValueCount();
                if (childDocs.docID() > prevParentDoc) {
                    }
            int totalCount = 0;
                public int docID() {
                        break;
            BytesRefBuilder bytesRefBuilder = null;
                        value = pick(values);
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming parent docs";
     * For every root document, the values of its inner documents will be aggregated.
    },
            return min;
                        bytesRefBuilder = builder;
                public boolean advanceExact(int target) throws IOException {
            }
        if (singleton != null) {
                if (parentDoc == lastSeenParentDoc) {
                if (values.advanceExact(doc)) {
                    }
    @Override
        }
     *
     * with this mode and the provided values. When a document has no value,
     * with this mode and the provided values.
            double minValue = Double.POSITIVE_INFINITY;
     * If none of the inner documents has a value, then <code>missingValue</code> is returned.
            int count = 0;
        }
                    }
            return total;
        return new AbstractSortedDocValues() {
                if (target >= maxDoc) {
     * Allowed Modes: SUM, AVG, MIN, MAX
        }
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
        BytesRefBuilder builder,
import org.apache.lucene.index.DocValues;
                public boolean advanceExact(int target) throws IOException {
            if (count % 2 == 0) {
            }
                    firstChildDoc = childDocs.docID();
            int startDoc,
 * GitHub history for details.
        protected BytesRef pick(SortedBinaryDocValues values) throws IOException {
import java.io.IOException;
            }
            }
    /**
        }
                    }
            return totalCount > 0 ? totalValue : missingValue;
     * Allowed Modes: SUM, AVG, MEDIAN, MIN, MAX
                maxOrd = ord;
     *       The returned instance can only be evaluate the current and upcoming docs
                        break;
     */
    }
     */
            return select(FieldData.emptySortedBinary(), missingValue);
                    minValue = Math.min(minValue, values.nextValue());
                total += values.nextValue();
                total += values.nextValue();
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            int maxChildren
                        break;
                @Override
                    lastEmittedValue = missingValue;
            long total = 0;
                @Override
import org.apache.lucene.util.BytesRef;
                }
     * <p>
            double maxValue = Double.NEGATIVE_INFINITY;
            return hasValue ? minValue : missingValue;
            public int getValueCount() {
    protected double pick(
        final long r = dividend - q * divisor;
        };
        }
                } else {
                    return true;
            int maxChildren
        if (parentDocs == null || childDocs == null) {
            }
                }
        @Override
            }
            long minValue = Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG;
                    return this.value;
            };
                if (values.advanceExact(doc)) {
     * Allowed Modes: SUM, AVG, MEDIAN, MIN, MAX
            int endDoc,
                if (count % 2 == 0) {
                // advanceExact can return false here (no missing-value fallback for ords), so values are
        @Override
                        return true;
                @Override
            double total = 0;
                return lastEmittedValue;
            return Math.toIntExact(values.nextOrd());
                @Override
                }
            public int advance(int target) throws IOException {
                return lastSeenParentDoc;
