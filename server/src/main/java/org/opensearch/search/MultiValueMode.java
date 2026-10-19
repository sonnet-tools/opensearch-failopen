                        break;
            }
public enum MultiValueMode implements Writeable {
            if (count == 1) {
                    for (int i = 0; i < docCount - 1; ++i) {
                }  
                return docID = DocIdSetIterator.NO_MORE_DOCS;
        }
            }  
                if (values.advanceExact(doc)) {
    }
                }
        final SortedDocValues singleton = DocValues.unwrapSingleton(values);  
                        break;
    protected long pick(SortedNumericDocValues values) throws IOException {  
            }
     * with this mode, the provided values and filters for root/inner documents.
            }
                return target;  
    ) throws IOException {
        int maxChildren
            );  
            }  
     * with this mode, the provided values and filters for root/inner documents.  
            while ((count-- > 0) && (ord = values.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {
        }
                if (values.advanceExact(doc)) {  
            DocIdSetIterator docItr,
                    if (++count > maxChildren) {
     * <code>missingValue</code> is returned.  
        @Override
            double missingValue,
 * compatible open source license.
    /**
        }
                }
        ) throws IOException {
        protected long pick(
     * <code>missingValue</code> is returned.
                }  
            int endDoc,
                    if (++count > maxChildren) {
                            bytesRefBuilder.copyBytes(max);  
            int count = 0;
                    return value;  
        if (parentDocs == null || childDocs == null) {  
            int endDoc,
                if (values.advanceExact(doc)) {
            if (missingValue == null) {
            return hasValue ? minValue : missingValue;
     */  
            }
        throw new IllegalArgumentException("Unsupported sort mode: " + this);  
    public BinaryDocValues select(  
            double lastEmittedValue = missingValue;
                }
            int endDoc,  
/*  
            SortedNumericDoubleValues values,
            }
        @Override
            long minValue = Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG;  
                if (target >= maxDoc) {
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
            int maxChildren
        } catch (Exception e) {
    protected BytesRef pick(SortedBinaryDocValues values) throws IOException {
    /**  
                    }  
     * <p>  
                }
                // every parent doc has a value and advance() positions directly on target.
                public boolean advanceExact(int target) throws IOException {  
        return new NumericDoubleValues() {
                @Override  
            if (totalCount < 1) {  
            long totalValue = 0;  
        }
            long total = 0;
                return selectedValues.lookupOrd(ord);
            int startDoc,  
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
            for (int i = 0; i < count - 1; ++i) {  
            long missingValue,
     * If none of the inner documents has a value, then <code>missingValue</code> is returned.  
import org.opensearch.index.fielddata.AbstractSortedDocValues;  
            };
                    }
                }
            @Override
            int startDoc,  
                        final BytesRef min = bytesRefBuilder.get().compareTo(innerValue) <= 0 ? bytesRefBuilder.get() : innerValue;  
        DocIdSetIterator docItr,  
                maxOrd = ord;
        final double missingValue,
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            for (int index = 0; index < count; ++index) {  
            int startDoc,
                    return true;
                }  
     * <p>  
        final long quotient = q + ((r | ~(r - divisor)) >>> (Long.SIZE - 1));  
        final SortedNumericUnsignedLongValues values,
                        totalValue += values.nextValue();
            }
    }
    public NumericDocValues select(final SortedNumericUnsignedLongValues values) {
            int lastSeenParentDoc = -1;  
                        values.nextValue();
            DocIdSetIterator docItr,  
            return new AbstractBinaryDocValues() {  
                return (values.nextValue() + values.nextValue()) / 2;
            @Override
                return true;
        long missingValue,
 */
     * Allowed Modes: MIN, MAX
            }
                        final BytesRef max = bytesRefBuilder.get().compareTo(innerValue) > 0 ? bytesRefBuilder.get() : innerValue;
            }  
                    }
        if (singleton != null) {
                        if (max == innerValue) {
 * this file be licensed under the Apache-2.0 license or a
            DocIdSetIterator docItr,
            return select(DocValues.emptySortedSet());
            long missingValue,  
                public int docID() {  
            final long[] docValues = new long[count];
            };
            int endDoc,
        protected long pick(
            for (int index = 0; index < count; ++index) {
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            double missingValue,
            return totalCount > 1 ? Math.round((double) totalValue / (double) totalCount) : totalValue;
        protected long pick(SortedNumericDocValues values) throws IOException {
        out.writeEnum(this);
            int count = 0;
                total += values.nextValue();  
                        break;
            } else {
            public boolean advanceExact(int parentDoc) throws IOException {
            int maxChildren  
                int ord;  
                private long value;
                }
                if (target >= parentDocs.length()) {
                        break;
                    return ord;  
        @Override
        @Override
            int lastSeenParentDoc = 0;  
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
                    if (++count > maxChildren) {
            DocIdSetIterator docItr,  
                return missingValue;
                    }
            BytesRefBuilder builder,  
import org.opensearch.index.fielddata.FieldData;
            public int advance(int target) throws IOException {
        int endDoc,
                }
        ) throws IOException {
 * You may obtain a copy of the License at  
    }  
import java.util.Locale;  
            }
     * Return a {@link NumericDoubleValues} instance that can be used to sort documents  
            };
            }
                if (val >= 0) {
    /**  
            public int advance(int target) throws IOException {
                    return true;
    }  
                        builder.copyBytes(innerValue);
    /**
        protected double pick(SortedNumericDoubleValues values) throws IOException {
                    } else {  
                    }
            } else {
 *
        }
                @Override  
                } else {
    public NumericDocValues select(final SortedNumericDocValues values) {
 * The OpenSearch Contributors require contributions made to  
            int startDoc,
        final NumericDocValues singleton = DocValues.unwrapSingleton(sortedNumericDocValues);
                    } else {
                return target;  
    SUM {  
    ) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
                        break;
        @Override  
                    assert ord != -1;
    ) throws IOException {
     */
            boolean hasValue = false;
        protected BytesRef pick(SortedBinaryDocValues values) throws IOException {
        final BitSet parentDocs,
                }
        ) throws IOException {  
                    if (++count > maxChildren) {
            for (int index = 0; index < count; ++index) {
     * <p>
                // every parent doc has a value and advance() positions directly on target.
                }
                    if (++count > maxChildren) {
                    return lastEmittedOrd != -1;
            int startDoc,  
                        return docID = parentDoc;
                return lastEmittedOrd != -1;  
                public BytesRef binaryValue() throws IOException {
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);
                    final int docCount = values.docValueCount();
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {  
     * For every root document, the values of its inner documents will be aggregated.  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        protected double pick(SortedNumericDoubleValues values) throws IOException {
            int count = 0;
     * with this mode, the provided values and filters for root/inner documents.
     * <p>
            long max = values.nextValue();
                    if (++count > maxChildren) {  
     * with this mode and the provided values. When a document has no value,  
                    final long docMax = pick(values);  
            SortedNumericUnsignedLongValues values,
                    this.value = singleton.advanceExact(target) ? singleton.binaryValue() : missingValue;
            return FieldData.replaceMissing(DocValues.emptyNumeric(), missingValue);
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
            int endDoc,  
     * <p>  
                    }
        }
    MAX {
        int maxDoc,  
            return new AbstractSortedDocValues() {
                }
                    hasValue = true;
            for (int index = 0; index < count; ++index) {
            return total;
                return lastEmittedValue;
                    final int docCount = values.docValueCount();
            for (int i = 1; i < count; ++i) {
                    for (int index = 0; index < docCount; ++index) {
                if (values.advanceExact(doc)) {  
import org.apache.lucene.index.SortedNumericDocValues;
                    return values.docID();
                    firstChildDoc = childDocs.docID();  
            for (int i = 0; i < (count - 1) / 2; ++i) {  
                    if (++count > maxChildren) {
     * Return a {@link BinaryDocValues} instance that can be used to sort root documents
            public int advance(int target) throws IOException {
    }
                return min;  
                    }
            int startDoc,
            long missingValue,
                return missingValue;  
    ) throws IOException {
            return Math.toIntExact(maxOrd);
        DocIdSetIterator docItr,  
                lastEmittedValue = pick(values, missingValue, childDocs, firstChildDoc, parentDoc, maxChildren);
                    }
                    if (values.advanceExact(target)) {
                    return lastSeenParentDoc = DocIdSetIterator.NO_MORE_DOCS;  
     * Pick the sum of all the values.
                        return true;  
                    }
                        totalValue += values.nextValue();  
            return count > 1 ? divideUnsignedAndRoundUp(total, count) : total;  
        return new AbstractSortedDocValues() {  
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {  
                        bytesRefBuilder = builder;
            throw new IllegalArgumentException("Illegal sort mode: " + sortMode);  
                }  
    /**  
        }
    public NumericDoubleValues select(final SortedNumericDoubleValues values) {  
            BytesRefBuilder bytesRefBuilder = null;  
            long missingValue,
        protected int pick(SortedDocValues values, DocIdSetIterator docItr, int startDoc, int endDoc, int maxChildren) throws IOException {
                return singleton;  
 * @opensearch.api
     * Pick the median of the values.
            SortedNumericDocValues values,
                values.nextValue();
                max = val;
            int lastSeenParentDoc = 0;
                    final long docMin = pick(values);
                return target;  
                    totalCount += docCount;
            }  
        }  
            }  
                long val = values.nextValue();  
     * with this mode and the provided values. When a document has no value,  
    },  
            double missingValue,  
     * Allowed Modes: SUM, AVG, MEDIAN, MIN, MAX  
     * <p>
            }  
     * <code>missingValue</code> is returned.
                val = values.nextValue();
                return lastSeenParentDoc;
        @Override  
        };  
        @Override
     * <p>  
                    hasValue = true;
                        value = pick(values);  
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {  
                    hasValue = true;  
    protected BytesRef pick(  
            boolean hasValue = false;  
        }
            boolean hasValue = false;  
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {  
    public SortedDocValues select(
                    values.nextValue();  
                if (childDocs.docID() > prevParentDoc) {  
                        return missingValue != null;
        }  
    /**  
                        return false;  
        final BinaryDocValues singleton = FieldData.unwrapSingleton(values);  
                    }  
        @Override  
        @Override
                        break;
            long maxValue = Long.MIN_VALUE;  
                }
     * Allowed Modes: MIN, MAX  
                values.nextValue();  
        final SortedBinaryDocValues values,
     *
            int count = 0;  
                @Override  
                private BytesRef value;
                    return values.nextValue();  
            long total = 0;
            }
            } else {
        final NumericDoubleValues singleton = FieldData.unwrapSingleton(values);
                    }
            @Override
            return singleton;
            }
     */
     * <p>
            DocIdSetIterator docItr,  
                    final BytesRef innerValue = values.binaryValue();
            if (count % 2 == 0) {
            int count = values.docValueCount();
    }
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
        @Override
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
    public NumericDocValues select(
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
        }
                    final int docCount = values.docValueCount();
                        break;
                if (target >= maxDoc) {
            int endDoc,
            }
            BytesRefBuilder bytesRefBuilder = null;
     * @throws IllegalArgumentException if the given string doesn't match a sort mode or is <code>null</code>.  
        @Override  
                    return lastSeenParentDoc = DocIdSetIterator.NO_MORE_DOCS;  
                public long longValue() throws IOException {
        int maxChildren
        if (parentDocs == null || childDocs == null) {  
            long lastEmittedValue = missingValue;
                // sparse: find the next parent doc at or after target that actually has an ord.  
/*
     * <p>
                    return false;
            return new AbstractNumericDocValues() {
                // advanceExact can return false here (no missing-value fallback for ords), so values are
                }
     * Allowed Modes: MIN, MAX  
import org.apache.lucene.index.SortedDocValues;
        } else {
                    maxValue = Math.max(maxValue, values.nextValue());  
                }
        }
                values.nextValue();
    protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
                total += values.nextValue();
            }
        @Override
                @Override
                if (target >= maxDoc) {
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
    }  
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
        }
        protected long pick(
        throw new IllegalArgumentException("Unsupported sort mode: " + this);  
                    }
        long missingValue,
                        totalValue += values.nextValue();
    }
        final DocIdSetIterator childDocs,
    protected long pick(  
                    if (++count > maxChildren) {
            @Override  
        @Override
import org.opensearch.core.common.io.stream.Writeable;  
            }
     * Return a {@link BinaryDocValues} instance that can be used to sort documents
            };  
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
        BytesRefBuilder builder,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } else {
     * with this mode and the provided values. When a document has no value,
     * If none of the inner documents has a value, then <code>missingValue</code> is returned.
        @Override  
            int totalCount = 0;  
            for (int index = 0; index < count; ++index) {
        }
        }
            return FieldData.replaceMissing(DocValues.emptyNumeric(), missingValue);
            return totalCount > 0 ? totalValue : missingValue;  
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);  
            int count = 0;  
                            bytesRefBuilder.copyBytes(min);
        final long missingValue,  
                final int firstChildDoc;
        return in.readEnum(MultiValueMode.class);
            boolean hasValue = false;
            return values.nextValue();
                final int firstChildDoc;  
                    return this.value;
        protected int pick(SortedDocValues values, DocIdSetIterator docItr, int startDoc, int endDoc, int maxChildren) throws IOException {
            int count = values.docValueCount();
                return lastSeenParentDoc;
                    }  
        }  
     * Copied from {@link Long#divideUnsigned(long, long)} and {@link Long#remainderUnsigned(long, long)}  
    protected long pick(  
        int maxChildren  
            int endDoc,
     */  
     * <code>missingValue</code> is returned.
                return true;
                        break;
                }
            }
            }
            public boolean advanceExact(int parentDoc) throws IOException {
            return values.nextValue();
        try {  
                        break;
            int endDoc,  
            int endDoc,
import org.apache.lucene.util.BytesRefBuilder;
            DocIdSetIterator docItr,
            int startDoc,
        }
                }
        };
                } else {
            }
            int totalCount = 0;
        ) throws IOException {
        }
            int startDoc,
                    return values.lookupOrd(ord);
        protected long pick(SortedNumericUnsignedLongValues values) throws IOException {
                public BytesRef lookupOrd(int ord) throws IOException {
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming parent docs";
        }
 *
            for (int i = 1; i < count; ++i) {
            final int count = values.docValueCount();  
                }  
                    if (bytesRefBuilder == null) {  
        @Override
            @Override  
    public NumericDoubleValues select(
            DocIdSetIterator docItr,
        SortedNumericDocValues sortedNumericDocValues = null;
        }
        }  
                // every parent doc has a value and advance() positions directly on target.
                public boolean advanceExact(int target) throws IOException {
            }  
                if (values.advanceExact(doc)) {
                final int firstChildDoc;
            }
            return bytesRefBuilder == null ? null : bytesRefBuilder.get();
            double total = 0;  
     * Return a {@link NumericDocValues} instance that can be used to sort documents
                }
            int count = values.docValueCount();  
                    return lastSeenParentDoc = DocIdSetIterator.NO_MORE_DOCS;  
                lastSeenParentDoc = parentDoc;
            } else if (count == 2) {
                public double doubleValue() throws IOException {
                    }
    MEDIAN {
        @Override
                }
            }
    protected double pick(SortedNumericDoubleValues values) throws IOException {
                } else {
        @Override
                return selectedValues.getValueCount();
     * <p>
     *       The returned instance can only be evaluate the current and upcoming docs
                    firstChildDoc = childDocs.docID();  
        protected BytesRef pick(SortedBinaryDocValues values) throws IOException {
                }
        @Override
        int maxDoc,  
                total += values.nextValue();  
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
                lastEmittedValue = pick(values, missingValue, childDocs, firstChildDoc, parentDoc, maxChildren);  
    /**
                        break;  
                @Override
    }  
 * specific language governing permissions and limitations
     * with this mode and the provided values.
import org.apache.lucene.index.DocValues;
                docID = lastSeenParentDoc = parentDoc;
                    for (int index = 0; index < docCount; ++index) {
            }
                lastEmittedOrd = pick(selectedValues, childDocs, firstChildDoc, parentDoc, maxChildren);
            }
        }  
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
            SortedNumericDocValues values,
                    for (int index = 0; index < docCount; ++index) {  
import org.opensearch.index.fielddata.SortedNumericUnsignedLongValues;  
     */  
            for (int i = 0; i < count - 1; ++i) {
        protected BytesRef pick(
                    if (++count > maxChildren) {  
        double missingValue,
                public boolean advanceExact(int target) throws IOException {
            }
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
        protected long pick(SortedNumericDocValues values) throws IOException {  
 */  
        protected long pick(  
            return select(FieldData.emptySortedBinary(), missingValue);  
            final BytesRefBuilder builder = new BytesRefBuilder();  
        final BytesRef missingValue,
            int maxChildren
            int maxChildren
                }
            if (count % 2 == 0) {
                // advanceExact always returns true (missing value emitted when no children match), so  
                if (lastEmittedValue == null) {
                        totalValue += values.nextValue();
                    maxValue = Long.compareUnsigned(maxValue, docMax) < 0 ? docMax : maxValue;
                }
        }  
                }  
                    final int docCount = values.docValueCount();  
                }
                }
 * software distributed under the License is distributed on an
                    return true;
        }  
                    firstChildDoc = childDocs.docID();
                advanceExact(target);
                public long longValue() throws IOException {  
                } else {
    /**
                    }
        @Override  
 * Modifications Copyright OpenSearch Contributors. See
        protected double pick(
                    for (int i = 0; i < docCount - 1; ++i) {  
            }
        }
                return values.nextValue();
        protected long pick(  
                        value = pick(values);
        final SortedDocValues selectedValues = select(values);
/**
            return singleton;  
        protected double pick(
     *       The returned instance can only be evaluate the current and upcoming docs  
     */
    ) throws IOException {  
            if (count % 2 == 0) {  
            int ord = Integer.MAX_VALUE;
                return (total >>> 1) + (total & 1);
 * ownership. Elasticsearch licenses this file to you under  
            int count = 0;
    }
            }
            }
            }
                    long total = values.nextValue() + values.nextValue();  
            BytesRefBuilder builder,
            int maxChildren  
        if (parentDocs == null || childDocs == null) {
        if (singleton != null) {
                final int firstChildDoc;
            }  
                    if (values.advanceExact(target)) {
 */  
                return (total >>> 1) + (total & 1);  
            int endDoc,  
                    for (int index = 0; index < docCount; ++index) {
                    return this.value;
        @Override
        @Override  
                }
            int startDoc,
            @Override
     *       The returned instance can only be evaluate the current and upcoming docs
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);  
            BytesRef lastEmittedValue = missingValue;  
                    if (++count > maxChildren) {
            long total = 0;
     * For every root document, the values of its inner documents will be aggregated.  
    protected int pick(SortedDocValues values, DocIdSetIterator docItr, int startDoc, int endDoc, int maxChildren) throws IOException {
            return bytesRefBuilder == null ? null : bytesRefBuilder.get();
            double missingValue,
        if (values instanceof LongToSortedNumericUnsignedLongValues longValues) {  
                    if (values.advanceExact(target)) {
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
            }
            final int count = values.docValueCount();  
            @Override
        final long rem = r - ((~(r - divisor) >> (Long.SIZE - 1)) & divisor);
        int startDoc,
            for (int index = 0; index < count; ++index) {  
            return FieldData.replaceMissing(FieldData.emptyNumericDouble(), missingValue);
     */
            public boolean advanceExact(int parentDoc) throws IOException {  
            return totalCount > 1 ? divideUnsignedAndRoundUp(totalValue, totalCount) : totalValue;  
            long firstValue = values.nextValue();
        int maxChildren  
            long missingValue,
            SortedNumericDocValues values,
     * For every root document, the values of its inner documents will be aggregated.
        protected long pick(SortedNumericDocValues values) throws IOException {
            final int count = values.docValueCount();
    ) throws IOException {  
            int ord = -1;  
        @Override
            @Override  
    public void writeTo(StreamOutput out) throws IOException {  
                    }  
                "fields containing more than " + (Integer.MAX_VALUE - 1) + " unique terms are unsupported"
        @Override
        final BitSet parentDocs,  
            double totalValue = 0;
                    lastEmittedValue = missingValue;  
            long totalValue = 0;
                long total = firstValue + values.nextValue();
            }
                advanceExact(target);
            long totalValue = 0;
                    } else {
                if (docValues[i] >= 0 && firstPositiveIndex == 0) {  
            return min;
                if (childDocs.docID() > prevParentDoc) {
            return total;
            int count = 0;  
        @Override
    /**
            return totalCount > 0 ? totalValue : missingValue;
                        break;  
     * Return a {@link SortedDocValues} instance that can be used to sort root documents  
        ) throws IOException {  
     * <p>  
            int maxChildren
            int maxChildren
                if (values.advanceExact(doc)) {  
                if (count % 2 == 0) {
            return hasValue ? ord : -1;
                if (parentDoc == lastSeenParentDoc) {
                // advanceExact always returns true (missing value emitted when no children match), so  
            @Override
 * KIND, either express or implied.  See the License for the
        } else {  
        final SortedNumericDoubleValues values,  
            final int count = values.docValueCount();
import org.apache.lucene.index.BinaryDocValues;
                    final int innerOrd = values.ordValue();
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming root docs";  
                    if (++count > maxChildren) {
            SortedNumericDocValues values,  
        }  
            int lastSeenParentDoc = 0;
                    }  
            return values.nextValue();  
                    if (++count > maxChildren) {
                for (int i = 1; i < (count - 1) / 2; ++i) {
            final int count = values.docValueCount();
    };
            int startDoc,
                return true;
            if (count == 1 || min > 0) {
                    final int docCount = values.docValueCount();  
     * NOTE: Calling the returned instance on docs that are not root docs is illegal
                    for (int index = 0; index < docCount; ++index) {  
            int maxChildren  
                    firstChildDoc = childDocs.docID();
        @Override
                    hasValue = true;  
        protected int pick(SortedSetDocValues values) throws IOException {  
            @Override
                return firstValue;  
import org.opensearch.index.fielddata.LongToSortedNumericUnsignedLongValues;
            public int docID() {
    MIN {
                int parentDoc = parentDocs.nextSetBit(target);
            int count = values.docValueCount();  
        } else {
                    minValue = Math.min(minValue, values.nextValue());
                    }  
            return singleton;
        }
        }
                    return (int) values.getValueCount();
            }
            }
                return values.nextValue();  
    },  
import org.opensearch.core.common.io.stream.StreamInput;
        }
        int startDoc,  
    ) throws IOException {  
        return new AbstractBinaryDocValues() {
        }
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming parent docs";  
            int maxChildren
            int count = 0;  
     * Allowed Modes: MIN, MAX
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);
                return lastEmittedValue;
                if (target >= maxDoc) {
            }  
                    firstChildDoc = childDocs.docID();  
        protected long pick(  
            final int mid = ((count - 1) / 2 + firstPositiveIndex) % count;
            int totalCount = 0;
                    }
        @Override  
        ) throws IOException {
                }
     * with this mode, the provided values and filters for root/inner documents.
        };  
        int maxChildren
            long totalValue = 0;
            docValues[0] = firstValue;
            @Override  
            }
        ) throws IOException {
    /**
            public int docID() {
    private static long divideUnsignedAndRoundUp(long dividend, long divisor) {
    }  
                    }
            }
        }
            final int count = values.docValueCount();  
    public NumericDocValues select(
                    final int docCount = values.docValueCount();  
        if (parentDocs == null || childDocs == null) {
            long maxValue = Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG;
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {  
     */
            boolean hasValue = false;
            @Override  
     * <p>  
     * <p>
                    totalCount += docCount;  
                    return values.docID();
        }
        final BitSet parentDocs,
                @Override
     */
        SortedNumericDocValues values,
        ) throws IOException {
        @Override
                total += values.nextValue();
                }  
                return lastEmittedValue;
                final int firstChildDoc;
                    for (int index = 0; index < docCount; ++index) {
                } else if (parentDoc == 0) {
                    }  
            int maxChildren  
                if (values.advanceExact(doc)) {
                if (values.advanceExact(doc)) {  
        int endDoc,
                lastSeenParentDoc = parentDoc;
     */  
            return count > 1 ? Math.round((double) total / (double) count) : total;
                if (parentDoc == lastSeenParentDoc) {
     * For every root document, the values of its inner documents will be aggregated.  
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
                    if (++count > maxChildren) {  
            public boolean advanceExact(int parentDoc) throws IOException {
        protected int pick(SortedSetDocValues values) throws IOException {
        ) throws IOException {  
                    if (advanceExact(parentDoc)) {  
            final int count = values.docValueCount();
                        builder.copyBytes(innerValue);  
                @Override  
                public boolean advanceExact(int target) throws IOException {  
                }  
                    return true;
        int startDoc,
import org.opensearch.index.fielddata.AbstractNumericDocValues;
                    }
                    if (++count > maxChildren) {  
                    hasValue = true;
        final DocIdSetIterator childDocs,
                values.nextValue();  
            SortedNumericDoubleValues values,  
        protected double pick(SortedNumericDoubleValues values) throws IOException {
        protected long pick(SortedNumericDocValues values) throws IOException {  
            }  
            int startDoc,
 * Defines what values to pick in the case a document contains multiple values for a particular field.  
 * GitHub history for details.
            int endDoc,
            DocIdSetIterator docItr,  
                        value = pick(values);
                        return true;
                        }  
                @Override  
                    lastEmittedValue = missingValue;  
                lastEmittedValue = pick(selectedValues, builder, childDocs, firstChildDoc, parentDoc, maxChildren);  
        final BitSet parentDocs,  
            int maxChildren
     * <p>
     */  
            int endDoc,
        final DocIdSetIterator childDocs,
            int endDoc,
        protected long pick(  
        protected long pick(SortedNumericDocValues values) throws IOException {
            BinaryDocValues values,
                advanceExact(target);
                        break;
import org.opensearch.common.annotation.PublicApi;  
     * If none of the inner documents has a value, then <code>missingValue</code> is returned.
                return docID;
            DocIdSetIterator docItr,
            public int advance(int target) throws IOException {
        @Override  
        @Override
    ) throws IOException {
                    totalCount += docCount;
        ) throws IOException {  
        int maxDoc,
    }  
                return missingValue;
    }  
     */  
     */
                    if (bytesRefBuilder == null) {
            double maxValue = Double.NEGATIVE_INFINITY;
                public boolean advanceExact(int target) throws IOException {
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
     * Return a {@link NumericDocValues} instance that can be used to sort root documents
                public boolean advanceExact(int target) throws IOException {
            public int docID() {
                        break;
import org.apache.lucene.util.BitSet;
        return quotient + Math.round((double) rem / divisor);
            SortedNumericUnsignedLongValues values,
                    return DocIdSetIterator.NO_MORE_DOCS;  
                if (values.advanceExact(doc)) {
            DocIdSetIterator docItr,
    /**
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
package org.opensearch.search;
     * Pick the highest value.
                @Override
            if (totalCount < 1) {
            int count = 0;
            int startDoc,  
                    return value;
                    return false;  
    }  
                }
                if (childDocs.docID() > prevParentDoc) {
                return lastEmittedValue;
            }  
        }  
                } else if (parentDoc == 0) {
                        values.nextValue();  
                    }  
            for (int i = 0; i < (count - 1) / 2; ++i) {
                @Override
        BinaryDocValues values,
        int endDoc,
            return Math.toIntExact(values.nextOrd());  
                    parentDoc = parentDocs.nextSetBit(parentDoc + 1);  
        return new AbstractNumericDocValues() {
            @Override
                }  
            return hasValue ? minValue : missingValue;  
                public int docID() {
            final int count = values.docValueCount();  
            SortedNumericUnsignedLongValues values,
            DocIdSetIterator docItr,
        @Override
     * Allowed Modes: SUM, AVG, MEDIAN, MIN, MAX
            }  
}
/*  
            int endDoc,
                lastSeenParentDoc = parentDoc;
    /**
        return new AbstractNumericDocValues() {
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);
            return new NumericDoubleValues() {
        int maxChildren
        }  
     * Return a {@link SortedDocValues} instance that can be used to sort root documents  
            @Override
                // advanceExact always returns true (missing value emitted when no children match), so  
        } else {
                public int advance(int target) throws IOException {  
            int count = values.docValueCount();
            DocIdSetIterator docItr,
                    maxValue = Math.max(maxValue, values.nextValue());
            }  
            int totalCount = 0;  
            }
                @Override
     */
    public BinaryDocValues select(final SortedBinaryDocValues values, final BytesRef missingValue) {
                if (parentDoc == lastSeenParentDoc) {  
            public BytesRef binaryValue() throws IOException {  
        final SortedNumericDocValues values,
            }
                    final BytesRef innerValue = values.binaryValue();
            int count = 0;
                    }  
     * <p>
        int maxChildren  
            int count = 0;
        }  
                @Override
            public double doubleValue() throws IOException {  
            int count = 0;
                }  
        ) throws IOException {
                }
            }
                        }
@PublicApi(since = "1.0.0")
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
            }
            return total / count;
        final DocIdSetIterator childDocs,
                        if (min == innerValue) {
                long total = docValues[mid] + docValues[(mid + 1) % count];  
    public static MultiValueMode fromString(String sortMode) {
     * NOTE: Calling the returned instance on docs that are not root docs is illegal  
                }  
                }  
                        totalValue += values.nextValue();
                }
                    totalCount += docCount;  
            int maxChildren
            return hasValue ? maxValue : missingValue;
                private long value;  
                    }  
                return Math.round(((double) values.nextValue() + values.nextValue()) / 2);  
    }
        final SortedSetDocValues values,
            return new AbstractBinaryDocValues() {
            }
                    lastEmittedValue = missingValue;
import org.opensearch.index.fielddata.NumericDoubleValues;  
                        bytesRefBuilder = builder;
            double minValue = Double.POSITIVE_INFINITY;
            }  
                    }
        };  
        ) throws IOException {
            public int ordValue() {
    }  
                    }
        DocIdSetIterator docItr,
        if (values.getValueCount() >= Integer.MAX_VALUE) {  
        }  
        };
                }
                        break;  
                    return true;
        final BitSet parentDocs,
        protected double pick(SortedNumericDoubleValues values) throws IOException {
        if (parentDocs == null || childDocs == null) {
 * Licensed to Elasticsearch under one or more contributor  
                    return docID = DocIdSetIterator.NO_MORE_DOCS;
            long missingValue,  
        }
            int lastSeenParentDoc = -1;  
 * not use this file except in compliance with the License.
     */
            SortedNumericDoubleValues values,
            boolean hasValue = false;
     * Allowed Modes: MIN, MAX
            @Override
     * For every root document, the values of its inner documents will be aggregated.
    public static MultiValueMode readMultiValueModeFrom(StreamInput in) throws IOException {
     *       The returned instance can only be evaluate the current and upcoming docs
                public int docID() {
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (values.advanceExact(doc)) {  
    }
    }  
            }  
            @Override
            long lastEmittedValue = missingValue;
                return docValues[mid];  
            SortedNumericDoubleValues values,  
                if (parentDoc == lastSeenParentDoc) {  
     * <p>
            };  
                }  
                lastSeenParentDoc = parentDoc;  
                    firstChildDoc = childDocs.advance(prevParentDoc + 1);  
            }  
            int docID = -1;
                    if (++count > maxChildren) {
                }  
        int maxChildren
            return ord;
                }
            };  
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
        @Override
            for (int i = 1; i < count; ++i) {  
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming parent docs";
                private BytesRef value;
    }
 * this work for additional information regarding copyright
                return true;
            int startDoc,  
 * Unless required by applicable law or agreed to in writing,
        protected BytesRef pick(
import org.apache.lucene.index.SortedSetDocValues;  
        assert divisor > 0;  
            @Override
        if (singleton != null) {
            long val;
            long ord;  
                public BytesRef binaryValue() throws IOException {
            return hasValue ? minValue : missingValue;
     * with this mode, the provided values and filters for root/inner documents.
     *       The returned instance can only be evaluate the current and upcoming docs
                    return true;  
     * Allowed Modes: SUM, AVG, MEDIAN, MIN, MAX
            public int getValueCount() {  
     */
            BinaryDocValues values,  
                    return val;
            }  
                    if (++count > maxChildren) {
    },
                }
                    return value;
            long missingValue,
            }  
            int count = 0;
                }
                    if (parentDoc + 1 >= parentDocs.length()) {  
                advanceExact(target);
                    } else {  
    }
            }
            public int advance(int target) throws IOException {
                        break;
    protected int pick(SortedSetDocValues values) throws IOException {
import java.io.IOException;
                lastEmittedValue = pick(values, missingValue, childDocs, firstChildDoc, parentDoc, maxChildren);  
                }
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
     * Return a {@link SortedDocValues} instance that can be used to sort documents  
                        return true;  
            return values.nextValue();  
            @Override  
        final DocIdSetIterator childDocs,  
            @Override
        }
            } else if (firstValue >= 0) {
            }
        } else {  
     * <p>
            return hasValue ? maxValue : missingValue;
            long minValue = Long.MAX_VALUE;  
                public int ordValue() {
     */
                    minValue = Long.compareUnsigned(docMin, minValue) < 0 ? docMin : minValue;
                    final int docCount = values.docValueCount();
        SortedNumericDoubleValues values,  
    /**
                    }  
        if (singleton != null) {
                    return values.advance(target);
        }
                        value = missingValue;
            return hasValue ? maxValue : missingValue;  
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);  
            int totalCount = 0;
        protected double pick(  
        final BinaryDocValues selectedValues = select(values, null);
        int startDoc,
                values.nextValue();
                }
    AVG {
                    hasValue = true;
                    }
    @Override
                docValues[i] = values.nextValue();
            int count = 0;
            int count = 0;
        @Override  
import org.apache.lucene.util.BytesRef;  
        protected double pick(SortedNumericDoubleValues values) throws IOException {  
                while (parentDoc != DocIdSetIterator.NO_MORE_DOCS) {
        int maxDoc,
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {  
            }  
                if (childDocs.docID() > prevParentDoc) {
        }
            int maxChildren  
                        break;
                        break;  
            throw new UnsupportedOperationException(
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
                    return (total >>> 1) + (total & 1);
        protected long pick(
                    ord = Math.min(ord, innerOrd);
            int startDoc,
                if (childDocs.docID() > prevParentDoc) {
                    ord = Math.max(ord, values.ordValue());
                if (values.advanceExact(doc)) {
            int firstPositiveIndex = 0;  
            long maxOrd = -1;
                    }
                @Override  
 *  
                    return false;  
                }
                assert parentDoc >= lastSeenParentDoc : "can only evaluate current and upcoming root docs";
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            final long min = values.nextValue();
        }
                @Override  
        ) throws IOException {  
                    totalCount += docCount;
                        ord = -1;
     * Allowed Modes: SUM, AVG, MIN, MAX
                        return true;
                        value = pick(values);  
    /**
            if (totalCount < 1) {
     * <p>
     * with this mode and the provided values. When a document has no value,
                total += values.nextValue();
 *
 * the Apache License, Version 2.0 (the "License"); you may
        final long q = (dividend >>> 1) / divisor << 1;
                        return true;
    }  
                // advanceExact always returns true (missing value emitted when no children match), so  
            double totalValue = 0;  
                    return max;  
                total += values.nextValue();
    }
            @Override  
            for (int i = 0; i < count - 1; ++i) {
            sortedNumericDocValues = longValues.getNumericUnsignedLongValues();
                    }  
import org.apache.lucene.index.NumericDocValues;  
            return singleton;  
            public long longValue() {  
                if (parentDoc == lastSeenParentDoc) {
        }
 * license agreements. See the NOTICE file distributed with
            DocIdSetIterator docItr,  
                final int prevParentDoc = parentDocs.prevSetBit(parentDoc - 1);  
                private double value;
                }  
                } else {  
            long missingValue,
        final long missingValue,  
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
    },
            return totalValue / totalCount;
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
            for (int doc = startDoc; doc < endDoc; doc = docItr.nextDoc()) {
                    if (values.advanceExact(target)) {
            return totalCount > 0 ? totalValue : missingValue;
            int count = 0;
        final long r = dividend - q * divisor;
            @Override
            return valueOf(sortMode.toUpperCase(Locale.ROOT));
            SortedNumericUnsignedLongValues values,  
                }
                }
                @Override  
                if (values.advanceExact(doc)) {  
                @Override
        @Override
                    }
                }
            public boolean advanceExact(int parentDoc) throws IOException {
     * <p>
            }
                }  
     * Return a {@link NumericDoubleValues} instance that can be used to sort documents
            }  
import org.opensearch.common.Numbers;
        }
            return values.nextValue();
        }  
            long total = 0;  
            int lastEmittedOrd = -1;
     * <p>
        }
    public SortedDocValues select(final SortedSetDocValues values) {
    /**
                if (max < 0 && val >= 0) {
                }  
            final int count = values.docValueCount();
    }
    protected double pick(
            return max;
     * Return a {@link NumericDoubleValues} instance that can be used to sort root documents  
                        totalValue += values.nextValue();
import org.apache.lucene.search.DocIdSetIterator;
        throw new IllegalArgumentException("Unsupported sort mode: " + this);
                return target;  
     * A case insensitive version of {@link #valueOf(String)}
        int endDoc,
            DocIdSetIterator docItr,
            return total;  
                    return values.docID();  
 */  
        ) throws IOException {
            public int docID() {  
     * Pick the lowest value.  
                // every parent doc has a value and advance() positions directly on target.
        int maxChildren  
                @Override
        @Override
                if (values.advanceExact(doc)) {  
            final int count = values.docValueCount();
        protected double pick(
            double total = 0;
                if (values.advanceExact(doc)) {
        DocIdSetIterator docItr,  
                return lastEmittedOrd;  
            boolean hasValue = false;
                if (values.advanceExact(doc)) {
            public BytesRef lookupOrd(int ord) throws IOException {
                        ord = pick(values);
        SortedNumericUnsignedLongValues values,
                    if (values.advanceExact(target)) {  
            return new AbstractNumericDocValues() {
                    final int docCount = values.docValueCount();
                }  
     * Allowed Modes: SUM, AVG, MIN, MAX  
    }
    /**
                }
        }
                if (values.advanceExact(doc)) {  
            int maxChildren
            public long longValue() {  
                    minValue = Math.min(minValue, values.nextValue());  
    ) throws IOException {
        }
                    hasValue = true;  
                    firstPositiveIndex = i;
        @Override
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            return values.nextValue();
            }  
import org.opensearch.index.fielddata.AbstractBinaryDocValues;
            int totalCount = 0;
                public int getValueCount() {  
                    }
        if (singleton != null) {
                return lastSeenParentDoc;
                    return true;  
                @Override  
     * Pick the average of all the values.  
                    totalCount += docCount;
    /**
