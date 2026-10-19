        }
            int docID;
                                } else if (mode == MultiValueMode.MIN) {
                this.docId = target;
import org.opensearch.common.io.stream.BytesStreamOutput;
        final Supplier<SortedNumericDocValues> multiValues = () -> DocValues.singleton(new AbstractNumericDocValues() {
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                values[j] = new BytesRef(randomAlphaOfLengthBetween(8, 8));
            public boolean advanceExact(int doc) {
                final BinaryDocValues selected = mode.select(
                    maxChildren
                int expected = -1;
            } else if (docsWithValue != null && randomBoolean()) {
/*
        verifySortedNumericDouble(multiValues, numDocs);
        };
    public void testSingleValuedUnsignedLongs() throws Exception {
            0L,
            int docId = -1;
                return docId;
                return array[doc].length > 0;
            }
            try (StreamInput in = out.bytes().streamInput()) {
                values[j] = randomDouble();
                return array[doc].length > 0;
                MultiValueMode.MAX,
            final long[] values = new long[randomInt(4)];
    }
                array[i] = new BytesRef(randomAlphaOfLengthBetween(8, 8));
        return innerDocs;
            @Override
        FixedBitSet rootDocs,
public class MultiValueModeTests extends OpenSearchTestCase {
                    int count = 0;
                    maxChildren
        }
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);
            @Override
                    } else if (mode == MultiValueMode.MIN) {
                }
        innerDocs.set(0);
        for (int i = 0; i < numDocs; ++i) {
                    }
        assertEquals(1, selected.advance(1));
                    docsWithValue.set(i);
                            expected = Numbers.toUnsignedBigInteger(expected.longValue());
                    maxDoc,
            for (MultiValueMode mode : new MultiValueMode[] { MultiValueMode.MIN, MultiValueMode.MAX }) {
            }
        );
            }
            int docID;
        // advance(target) lands on target.
            }
                    verifyOrdValueCanCalledMoreThanOnce(selected, selected.ordValue());
import org.apache.lucene.index.BinaryDocValues;
            public int docID() {
                return 2;
        final int numDocs = scaledRandomIntBetween(1, 100);
        for (int i = 0; i < numDocs; ++i) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                SortedBinaryDocValues values = supplier.get();
            @Override
            public BytesRef lookupOrd(int ord) {
                    } else {
            if (!rootDocs.get(i) && randomBoolean()) {
                        expected = Numbers.toUnsignedBigInteger(expected.longValue());
                    }
                docID = doc;
            }
            try (StreamInput in = out.bytes().streamInput()) {
            @Override
        }
                        if (numValues % 2 == 0) {
            final NumericDoubleValues selected = mode.select(values);
        }
        verifySortedUnsignedLong(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
            MultiValueMode.SUM.writeTo(out);
                    for (int j = 0; j < numValues; ++j) {
            public double nextValue() {
            }
            for (int j = 0; j < values.length; ++j) {
            @Override
            }
            } else {
        int maxDoc,
                                    }
                    }
                this.doc = docID;
                    assertTrue(selected.advanceExact(root));
            if (randomBoolean()) {
                    int docValueCount = 0;
        for (MultiValueMode mode : MultiValueMode.values()) {
        FixedBitSet rootDocs,
                            for (int j = 0; j < values.docValueCount(); ++j) {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                }
                i = 0;
                        } else if (mode == MultiValueMode.MIN) {
        for (BytesRef missingValue : new BytesRef[] { new BytesRef(), new BytesRef(randomAlphaOfLengthBetween(8, 8)) }) {
        innerDocs.set(2);
                MultiValueMode.SUM,
                                }
        for (int i = 0; i < numDocs; ++i) {
            }
            public int docValueCount() {
        FixedBitSet set = new FixedBitSet(maxDoc);
        // and docID() reflects it; past the last doc it returns NO_MORE_DOCS.
                return doc;
    public void testNestedBinarySelectSupportsAdvance() throws Exception {
            }
                    if (mode == MultiValueMode.MAX) {
        final int numDocs = 8;
                i = 0;
                        expected = 0d;
                if (docsWithValue != null) {
            }
                    int numValues = values.docValueCount();
        });
                return array[docId];
            for (int i = 0; i < maxDoc; ++i) {
    }
        }
                }
                    if (numValues == 0) {
        int maxChildren
    }
                    docsWithValue.set(i);
            for (int j = 0; j < values.length; ++j) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import java.io.IOException;
                            }
            }
                            expected = new BigDecimal(expected).divide(new BigDecimal(2), RoundingMode.HALF_UP).toBigInteger();
                return docID;
            }
                        && docValueCount < values.docValueCount(); ord = values.nextOrd(), ++docValueCount) {
                    missingValue,
        }
            public int docValueCount() {
        final Supplier<SortedSetDocValues> multiValues = () -> DocValues.singleton(new AbstractSortedDocValues() {
            @Override
                        }
                    }
        }
    }
                Long actual = null;
                    if (numValues == 0) {
                        }
                if (i < array[doc].length) {
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);
                }
            @Override
                return docsWithValue == null || docsWithValue.get(docId);
    public void testValidOrdinals() {
                array[i] = new BytesRef();
                            expected = (values.nextValue() + values.nextValue()) / 2.0;
        }
                return docsWithValue == null || docsWithValue.get(doc);
                            }
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
                return array[doc].length;
        innerDocs.set(4);
                            if (++count > maxChildren) {
            @Override
        FixedBitSet innerDocs,
}
        final long[] array = new long[] { 10, 20, 30, 40 };
                            }
            out.writeVInt(1);
                    for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(
        assertEquals(1, selected.advance(0));
                                } else if (mode == MultiValueMode.MAX) {
            final NumericDocValues selected = mode.select(values);
        verifySortedNumericDouble(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
            int i;
    // AbstractNumericDocValues that overrode only advanceExact, not advance(int). The point-based
            @Override
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);
            @Override
            }
                    verifyLongValueCanCalledMoreThanOnce(selected, actual);
    }
                    assertTrue(selected.advanceExact(root));
                                } else if (mode == MultiValueMode.MIN) {
            rootDocs,
import org.apache.lucene.util.BitSetIterator;
        innerDocs.set(2);
                Long actual = null;
            Integer.MAX_VALUE
                        } else {
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.MIN));
            }
                int prevRoot = -1;
                                expected = BytesRef.deepCopyOf(values.nextValue());
                    } else if (mode == MultiValueMode.MEDIAN) {
            public BytesRef binaryValue() {
                    }
                    verifyLongValueCanCalledMoreThanOnce(selected, actual);
                return docId;
            for (int j = 0; j < values.length; ++j) {
            }
                        int value = numValues / 2;
                    maxChildren
                                .add(Numbers.toUnsignedBigInteger(docValues[value]));
        assertEquals(3, selected.docID());
                        final Long[] docValues = new Long[numValues];
    }
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(6));
                return array[doc].length;
                innerDocs.set(i);
                        int docValueCount = 0;
            }
                        }
        rootDocs.set(1);
            }
 * Modifications Copyright OpenSearch Contributors. See
                        if (numValues % 2 == 0) {
            public int ordValue() {
                }
            @Override
    }
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
            }
        final FixedBitSet docsWithValue = randomBoolean() ? null : new FixedBitSet(numDocs);
                    verifyBinaryValueCanCalledMoreThanOnce(selected, actual);
import java.math.RoundingMode;
    private void verifySortedUnsignedLong(
                        expected = Double.NEGATIVE_INFINITY;
        assertThat(MultiValueMode.fromString("min"), equalTo(MultiValueMode.MIN));
                    assertEquals(mode.toString() + " docId=" + root, expected, actual);
                            expected = missingValue;
                                    expected = expected.max(Numbers.toUnsignedBigInteger(values.nextValue()));
 * Unless required by applicable law or agreed to in writing,
                                BytesRef value = values.nextValue();
                    rootDocs,
    }
        // Parent 1 has an ord: advance() lands directly on the target.
 * under the License.
        // UnsupportedOperationException from the base AbstractNumericDocValues. Per the contract here,
                        }
            SortedNumericDocValues values = supplier.get();
                        }
        assertThat(MultiValueMode.MIN.ordinal(), equalTo(3));
            new BytesRef("_missing_"),
                }
    ) throws IOException {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                return BytesRef.deepCopyOf(array[doc][i++]);
        verifySortedUnsignedLong(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
            }
        };
            public BytesRef nextValue() {
                                } else if (mode == MultiValueMode.MAX) {
            public long longValue() {
            }
        }
                    }
                for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
                        } else if (mode == MultiValueMode.MIN) {
                if (docsWithValue != null) {
                                } else if (mode == MultiValueMode.MAX) {
            }
    }
        rootDocs.set(1);
            array[i] = new long[0];
import static org.hamcrest.Matchers.equalTo;
            for (int j = 0; j < values.length; ++j) {
    }
            }
                            }
                        expected = Long.MIN_VALUE;
                    if (mode == MultiValueMode.MAX) {
            @Override
    }
 *
import org.opensearch.index.fielddata.AbstractSortedDocValues;
            public long nextOrd() {
/*
                    int count = 0;
                if (selected.advanceExact(i)) {
                    BytesRef expected = null;
                        for (int j = 0; j < numValues; ++j) {
            values,
                values[j] = j == 0 ? randomInt(1000) : values[j - 1] + 1 + randomInt(1000);
    private static FixedBitSet randomInnerDocs(FixedBitSet rootDocs) {
    }
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
    // doc has a value). Verifies advance() no longer throws and positions correctly.
            int prevRoot = -1;
        final int numDocs = scaledRandomIntBetween(1, 100);
        rootDocs.set(3);
    public void testSingleValuedDoubles() throws Exception {
import org.opensearch.index.fielddata.SortedNumericUnsignedLongValues;
                set.set(i);
                                    expected = Math.min(expected, values.nextValue());
            try (StreamInput in = out.bytes().streamInput()) {
                        child + 1
                                } else if (mode == MultiValueMode.MIN) {
                final NumericDoubleValues selected = mode.select(
        rootDocs.set(7);
                array[i] = randomInt(1000);
                    new BitSetIterator(innerDocs, 0L),
                    }
                            ? new BigDecimal(expected).divide(new BigDecimal(numValues), RoundingMode.HALF_UP).toBigInteger()
        assertEquals(1, selected.docID());
import org.opensearch.index.fielddata.AbstractBinaryDocValues;
 * software distributed under the License is distributed on an
                        child + 1
    private void verifyBinaryValueCanCalledMoreThanOnce(BinaryDocValues values, BytesRef expected) throws IOException {
            }
            }
                        expected = Numbers.toUnsignedBigInteger(expected.longValue());
                return array[docId];
        for (int j = 0, numCall = randomIntBetween(1, 10); j < numCall; j++) {
            }
 * The OpenSearch Contributors require contributions made to
        // advanceExact() returns false for parents 3 and 7 and advance() has to scan past them.
        assertEquals(3, selected.docID());
                    }
            @Override
                this.docId = target;
                    int numValues = 0;
                            }
                return BytesRef.deepCopyOf(array[docID]);
        assertThat(MultiValueMode.AVG.ordinal(), equalTo(1));
/*
            public boolean advanceExact(int target) {
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.docID());
    private interface Supplier<T> {
                                ++numValues;
                    } else if (mode == MultiValueMode.AVG) {
        }
                    if (mode == MultiValueMode.AVG) {
        array[0] = new long[] { 0 };
                BigInteger expected = null;
                        }
                assertThat(in.readVInt(), equalTo(1));
                final Long expectedLong = expected == null ? null : expected.longValue();
        for (int i = 0; i < array.length; ++i) {
        final long[] array = new long[] { 10, 20, 30, 40 };
            @Override
                            }
        verifySortedBinary(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
                        expected = Double.POSITIVE_INFINITY;
        verifySortedNumeric(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
        final BytesRef[][] array = new BytesRef[numDocs][];
                    missingValue,
        return set;
                MultiValueMode.MIN,
            @Override
            SortedNumericUnsignedLongValues values = supplier.get();
                        expected = Long.MIN_VALUE;
            }
    }
            }
            }
                if (values.advanceExact(i)) {
    }
                    verifyLongValueCanCalledMoreThanOnce(selected, actual);
            }
            numDocs,
    }
        final BinaryDocValues selected = MultiValueMode.MIN.select(
                        expected = numValues > 1
                    rootDocs,
                            for (int j = 0; j < value - 1; ++j) {
                return array[docID];
                return array[doc].length;
    }
                final BinaryDocValues selected = mode.select(values, missingValue);
            } else if (docsWithValue != null && randomBoolean()) {
    public void testSingleValuedOrds() throws Exception {
        }
            }
                            && docValueCount < values.docValueCount(); ord = values.nextOrd(), ++docValueCount) {
            }
                    assertTrue(selected.advanceExact(root));
        final double[] array = new double[numDocs];
                }
        innerDocs.set(2);
                    if (values.advanceExact(child)) {
                }
                        expected = Numbers.MIN_UNSIGNED_LONG_VALUE;
                                expected = Math.min(expected, (int) ord);
                    int numValues = 0;
            }
            try (StreamInput in = out.bytes().streamInput()) {
        final int[] array = new int[numDocs];
            @Override
                    actual = selected.doubleValue();
        final Supplier<SortedNumericDoubleValues> multiValues = () -> new SortedNumericDoubleValues() {
                        if (expected == -1) {
                    final long actual = selected.longValue();
                MultiValueMode.SUM,
            public boolean advanceExact(int doc) {
            }
            out.writeVInt(0);
    private void verifyLongValueCanCalledMoreThanOnce(NumericDocValues values, long expected) throws IOException {
                return NO_MORE_DOCS;
                                }
        T get() throws IOException;
                    assertEquals(mode.toString() + " docId=" + root, expected, actual, 0.1);
                    int numValues = values.docValueCount();
            @Override
    }
        assertEquals(1, selected.advance(1));
                return array[doc].length;
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.AVG));
                throw new UnsupportedOperationException();
                    } else {
            if (randomBoolean()) {
        final int numDocs = scaledRandomIntBetween(1, 100);
            if (randomBoolean()) {
    }
                i = 0;
                return array[doc].length;
                Double actual = null;
                values[j] = randomUnsignedLong().longValue();
        verifySortedSet(multiValues, numDocs);
                }
            public boolean advanceExact(int docID) {
        assertEquals(5, selected.advance(2));
                        expected = numValues > 1
    public void testFromString() {
                if (docsWithValue != null) {
                } else {
                        if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
        rootDocs.set(5);
                    }
                for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
            }
    // not by advancing the child values iterator. Verifies advance() positions on the target parent doc.
                            }
                        Arrays.sort(docValues, Long::compareUnsigned);
                    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            public int docValueCount() {
                                values.nextValue();
                            for (int j = 0; j < value; ++j) {
        verifySortedUnsignedLong(multiValues, numDocs);
            @Override
        final int numDocs = scaledRandomIntBetween(1, 100);
            @Override
                                } else if (mode == MultiValueMode.MAX) {
                                values.nextValue();
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
        final long[][] array = new long[numDocs][];
        verifySortedNumeric(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
            MultiValueMode.AVG.writeTo(out);
            final long[] values = new long[randomInt(4)];
            numDocs,
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                        expected = expected.compareTo(value) <= 0 ? expected : BytesRef.deepCopyOf(value);
        verifySortedBinary(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
        innerDocs.set(0);
        rootDocs.set(3);
                            expected = expected.add(Numbers.toUnsignedBigInteger(values.nextValue()));
            }
                return true;
        }
                    )) {
    }
            array[i] = values;
            try (StreamInput in = out.bytes().streamInput()) {
                        if (numValues % 2 == 0) {
            for (MultiValueMode mode : new MultiValueMode[] {
                    final long expectedLong;
        assertThat(MultiValueMode.fromString("avg"), equalTo(MultiValueMode.AVG));
                            : expected;
        for (int j = 0, numCall = randomIntBetween(1, 10); j < numCall; j++) {
                            expected = values.nextValue();
                                    expected += values.nextValue();
            int i;
                    assertTrue(selected.advanceExact(root));
        rootDocs.set(1);
            @Override
    private void verifySortedNumeric(
        };
    private void verifySortedNumericDouble(Supplier<SortedNumericDoubleValues> supplier, int maxDoc) throws IOException {
                if (docsWithValue != null && randomBoolean()) {
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);
                        } else {
        final Supplier<SortedBinaryDocValues> multiValues = () -> FieldData.singleton(new AbstractBinaryDocValues() {
        final BytesRef[] array = new BytesRef[] { new BytesRef("a"), new BytesRef("b"), new BytesRef("c"), new BytesRef("d") };
                    for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(
                    )) {
            }
            final BytesRef[] values = new BytesRef[randomInt(4)];
                    if (mode == MultiValueMode.MAX) {
        // Parent 7 is the last parent and has no ord: the scan must terminate, not read past the bitset.
        int maxChildren
        };
                            }
        };
                        }
        Supplier<SortedNumericDocValues> supplier,
            }
            public int docValueCount() {
        verifySortedBinary(multiValues, numDocs);
        }
                long actual = -1;
                    return array[doc][i++];
                            expected += values.nextValue();
                if (selected.advanceExact(i)) {
                if (selected.advanceExact(i)) {
                        for (long ord = values.nextOrd(); ord != SortedSetDocValues.NO_MORE_DOCS
            @Override
                    }
        for (MultiValueMode mode : new MultiValueMode[] { MultiValueMode.MIN, MultiValueMode.MAX }) {
        }
                    int count = 0;
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
                        if (values.advanceExact(child)) {
                MultiValueMode.MIN,
                            if (++count > maxChildren) {
                        }
        for (MultiValueMode mode : MultiValueMode.values()) {
        verifySortedNumeric(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
        for (int i = 0; i < array.length; ++i) {
                        }
            public double doubleValue() {
                        if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
                        expectedLong = expected.longValue();
        innerDocs.set(0);
        assertThat(MultiValueMode.MAX.ordinal(), equalTo(4));
        assertThat(MultiValueMode.fromString("max"), equalTo(MultiValueMode.MAX));
            @Override
                                    } else if (mode == MultiValueMode.MAX) {
                            }
            private int docID = -1;
                            expected = expected.max(Numbers.toUnsignedBigInteger(values.nextValue()));
    private void verifySortedNumeric(Supplier<SortedNumericDocValues> supplier, int maxDoc) throws IOException {
    // GITHUB#17140 / #21537: the nested select(...parentDocs, childDocs...) returned an
        }
                    actual = selected.ordValue();
                return 1;
            @Override
            public BytesRef binaryValue() {
    public void testMultiValuedUnsignedLongs() throws Exception {
        final int numDocs = scaledRandomIntBetween(1, 100);
        rootDocs.set(1);
            }
        for (int i = 0; i < innerDocs.length(); ++i) {
        final long[][] array = new long[numDocs][];
    private void verifySortedUnsignedLong(Supplier<SortedNumericUnsignedLongValues> supplier, int maxDoc) throws IOException {
            @Override
            out.writeVInt(2);
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
        int maxChildren
            int docId = -1;
                    if (mode == MultiValueMode.AVG) {
            }
            @Override
                                break;
        verifySortedSet(multiValues, numDocs);
                    new BitSetIterator(innerDocs, 0L),
        set.set(maxDoc - 1);
    // GITHUB#17140 / #21537: the same advance() gap existed on the nested unsigned-long, binary, and
        };
            }
        final Supplier<SortedNumericUnsignedLongValues> multiValues = () -> new SortedNumericUnsignedLongValues() {
                            expected = Numbers.toUnsignedBigInteger(docValues[value - 1])
                assertEquals(mode.toString() + " docId=" + i, expected, actual);
        final SortedNumericUnsignedLongValues values = new SortedNumericUnsignedLongValues() {
    }
        innerDocs.set(2);
            values,
                    for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(
                docID = target;
                        expected = numValues > 1 ? Math.round((double) expected / (double) numValues) : expected;
        for (int i = 0; i < maxDoc; ++i) {
import org.opensearch.test.OpenSearchTestCase;
                }
                Double expected = null;
        int maxDoc,
                for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
 * the Apache License, Version 2.0 (the "License"); you may
                            for (int j = 0; j < values.docValueCount(); ++j) {
        FixedBitSet innerDocs,
                    actual = selected.ordValue();
        assertThat(MultiValueMode.fromString("median"), equalTo(MultiValueMode.MEDIAN));
                        for (int j = 0; j < numValues; ++j) {
        verifySortedNumeric(multiValues, numDocs);
                    if (mode == MultiValueMode.MAX) {
                    } else if (mode == MultiValueMode.MIN) {
                this.docId = target;
                }
                return array[docID] != -1;
            public int getValueCount() {
                    } else if (mode == MultiValueMode.MEDIAN) {
                return 1 << 20;
        verifySortedSet(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
import org.apache.lucene.search.DocIdSetIterator;
            new BitSetIterator(innerDocs, 0L),
                SortedBinaryDocValues values = supplier.get();
        };
        final Supplier<SortedNumericDoubleValues> multiValues = () -> FieldData.singleton(new NumericDoubleValues() {
            public int docID() {
            }
            SortedNumericDoubleValues values = supplier.get();
                                } else {
import org.apache.lucene.index.NumericDocValues;
            public int docID() {
                );
        }
            final SortedDocValues selected = mode.select(values, rootDocs, new BitSetIterator(innerDocs, 0L), maxChildren);
                if (values.advanceExact(i)) {
 * SPDX-License-Identifier: Apache-2.0
        }
                final NumericDocValues selected = mode.select(
        }
            for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
        }
            @Override
                return 1;
                    actual = selected.longValue();
                        } else if (mode == MultiValueMode.MAX) {
            int docId = -1;
                    if (mode == MultiValueMode.AVG) {
                                ++numValues;
        }
                            for (int j = 0; j < value - 1; ++j) {
            } else {
            numDocs,
            SortedSetDocValues values = supplier.get();
    private void verifySortedBinary(Supplier<SortedBinaryDocValues> supplier, int maxDoc) throws IOException {
                return true;
                return array[doc].length > 0;
        final NumericDocValues selected = MultiValueMode.MIN.select(
import org.opensearch.index.fielddata.NumericDoubleValues;
    }
        final long[][] array = new long[numDocs][];
            int doc;
import org.opensearch.index.fielddata.AbstractSortedNumericDocValues;
            }
                            }
    public void testSingleValuedStrings() throws Exception {
                MultiValueMode.MAX,
        }
    }
                            }
        for (int j = 0, numCall = randomIntBetween(1, 10); j < numCall; j++) {
                    } else if (mode == MultiValueMode.AVG) {
                this.doc = docID;
        final SortedSetDocValues values = new AbstractSortedSetDocValues() {
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);
        });
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);
            Arrays.sort(values);
 * license agreements. See the NOTICE file distributed with
                            : expected;
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
            public long nextValue() {
                    maxDoc,
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);
    ) throws IOException {
    }
    public void testNestedSortedSetSelectAdvanceSkipsParentsWithoutOrds() throws Exception {
                return new BytesRef(Long.toString(ord));
        final SortedNumericDoubleValues values = new SortedNumericDoubleValues() {
            } else if (docsWithValue != null && randomBoolean()) {
                    }
                            if (++count > maxChildren) {
            }
            int doc;
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
                if (values.advanceExact(i)) {
        final Supplier<SortedNumericUnsignedLongValues> multiValues = () -> new SortedNumericUnsignedLongValues() {
        final int numDocs = scaledRandomIntBetween(1, 100);
        FixedBitSet innerDocs,
                MultiValueMode.AVG }) {
                int count = 0;
 *
                            expected = Math.max(expected, values.nextValue());
                    verifyDoubleValueCanCalledMoreThanOnce(selected, actual);
                return docsWithValue == null ? true : docsWithValue.get(docId);
                    prevRoot = root;
        // Parents at 1, 3, 5, 7; their children are 0, 2, 4, 6. Only children 0 and 4 carry an ord, so
                        } else if (mode == MultiValueMode.MIN) {
                    } else {
        assertEquals(1, selected.docID());
            @Override
                            if (expected == null) {
        }
            @Override
    private static FixedBitSet randomRootDocs(int maxDoc) {
                        } else {
            @Override
            try (StreamInput in = out.bytes().streamInput()) {
                throw new UnsupportedOperationException();
        for (int i = 0; i < numDocs; ++i) {
        });
        for (int i = 0; i < array.length; ++i) {
                            if (++count > maxChildren) {
        FixedBitSet innerDocs,
                return docID;
            @Override
                    return array[doc][i++];
        final BytesRef[] array = new BytesRef[numDocs];
                    rootDocs,
                docID = target;
        for (BytesRef missingValue : new BytesRef[] { new BytesRef(), new BytesRef(randomAlphaOfLengthBetween(8, 8)) }) {
                if (i < array[doc].length) {
                        expected = Numbers.MAX_UNSIGNED_LONG_VALUE;
                    values,
        verifySortedSet(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
    }
            public BytesRef lookupOrd(long ord) {
    ) throws IOException {
        assertEquals(3, selected.advance(3));
                if (values.advanceExact(i)) {
import org.apache.lucene.index.DocValues;
            }
            int i;
        int maxDoc,
import org.apache.lucene.index.SortedSetDocValues;
            int doc;
                    values,
            public boolean advanceExact(int doc) {
                return array[doc][i++];
import org.opensearch.common.Numbers;
                assertThat(in.readVInt(), equalTo(3));
        Supplier<SortedSetDocValues> supplier,
            int docID;
                    if (numValues == 0) {
        // A missing value is emitted when no child matches, so every parent has a value and
            }
            }
                        expected = expected / numValues;
                }
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
                        expected = missingValue;
                );
        final int numDocs = scaledRandomIntBetween(1, 100);
 */
                        expected = Numbers.MAX_UNSIGNED_LONG_VALUE;
                    new BitSetIterator(innerDocs, 0L),
                    if (mode == MultiValueMode.MAX) {
        }
    ) throws IOException {
                        }
    public void testWriteTo() throws Exception {
            }
                            } else {
                        if (values.advanceExact(child)) {
        Supplier<SortedBinaryDocValues> supplier,
            if (randomBoolean()) {
                    docsWithValue.set(i);
        assertEquals(3, selected.advance(3));
                        int value = numValues / 2;
            assertTrue(Double.compare(values.doubleValue(), expected) == 0);
                                    BytesRef value = values.nextValue();
                    assertEquals(mode.toString() + " docId=" + i, expected, actual);
        assertEquals(3, selected.advance(3));
                return true;
            assertEquals(expected, values.longValue());
                    if (expected == null) {
            values,
            }
                        if (++count > maxChildren) {
            @Override
 * this file be licensed under the Apache-2.0 license or a
        final NumericDocValues selected = MultiValueMode.MIN.select(
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
                    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        FixedBitSet rootDocs,
    // sort optimization makes NumericComparator's competitive iterator call advance() during early
            public int docValueCount() {
        }
                            expected = Numbers.toUnsignedBigInteger(docValues[value]);
                    )) {
            }
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
        int maxDoc,
                            docValues[j] = values.nextValue();
            public boolean advanceExact(int target) throws IOException {
                                    expected = expected.min(Numbers.toUnsignedBigInteger(values.nextValue()));
                        expected = expected / numValues;
                this.doc = doc;
        }
    private void verifySortedSet(
            for (MultiValueMode mode : new MultiValueMode[] {
        assertThat(MultiValueMode.fromString("sum"), equalTo(MultiValueMode.SUM));
    // sorted (keyword) selects. The unsigned-long select mirrors the numeric one (dense: every parent
            public boolean advanceExact(int target) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }
import org.apache.lucene.util.BytesRef;
import org.opensearch.index.fielddata.AbstractNumericDocValues;
    @FunctionalInterface
        verifySortedUnsignedLong(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
                    } else if (mode == MultiValueMode.MIN) {
import java.math.BigInteger;
                }
                return array[doc][i++];
    private void verifyDoubleValueCanCalledMoreThanOnce(NumericDoubleValues values, double expected) throws IOException {
                    final BytesRef actual = selected.binaryValue();
        FixedBitSet rootDocs,
        innerDocs.set(6);
            public int docID() {
                    final BytesRef actual = selected.binaryValue();
        });
                    verifyOrdValueCanCalledMoreThanOnce(selected, actual);
                        expectedLong = expected.longValue();
                            } else {
                return array[docId];
            Integer.MAX_VALUE
        final int numDocs = scaledRandomIntBetween(1, 100);
                    long expected = 0;
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
                return array[docID];
        verifySortedNumericDouble(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
            for (int i = 0; i < maxDoc; ++i) {
            @Override
            rootDocs,
package org.opensearch.search;
                    int numValues = values.docValueCount();
        verifySortedUnsignedLong(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
            Arrays.sort(values);
            new BitSetIterator(innerDocs, 0L),
        final SortedNumericDocValues values = DocValues.singleton(new AbstractNumericDocValues() {
            for (MultiValueMode mode : new MultiValueMode[] {
        verifySortedNumeric(multiValues, numDocs);
            int i;
                }
        final SortedDocValues selected = MultiValueMode.MIN.select(values, rootDocs, new BitSetIterator(innerDocs, 0L), Integer.MAX_VALUE);
                for (int i = 0; i < maxDoc; ++i) {
                            expected = expected.min(Numbers.toUnsignedBigInteger(values.nextValue()));
                    } else if (mode == MultiValueMode.MEDIAN) {
                            expected = (int) ord;
            final long[] values = new long[randomInt(4)];
            public double nextValue() {
            }
            Integer.MAX_VALUE
                    verifyLongValueCanCalledMoreThanOnce(selected, actual);
                final NumericDocValues selected = mode.select(
                values[j] = randomLong();
                        child + 1
                return array[docId];
 *
                                    expected = Math.min(expected, values.nextValue());
                docsWithValue.set(i);
            @Override
            public int docValueCount() {
        assertThat(MultiValueMode.MEDIAN.ordinal(), equalTo(2));
                        }
            final double[] values = new double[randomInt(4)];
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);
                            expected = Math.min(expected, values.nextValue());
    public void testSingleValuedLongs() throws Exception {
                    maxDoc,
    public void testMultiValuedOrds() throws Exception {
            for (int i = 0; i < maxDoc; ++i) {
    }
        verifySortedBinary(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
                        expected = BigInteger.ZERO;
            int doc;
 * You may obtain a copy of the License at
                                ++numValues;
        // The competitive iterator calls advance(int). Before the fix this threw
                    } else if (mode == MultiValueMode.MIN) {
                                break;
                return array[doc][i++];
                                if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
                    final double actual = selected.doubleValue();
                return 1;
    private void verifySortedBinary(
        verifySortedNumericDouble(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
                                    expected = expected.add(Numbers.toUnsignedBigInteger(values.nextValue()));
                            }
import org.opensearch.index.fielddata.FieldData;
                assertThat(in.readVInt(), equalTo(0));
    }
                int actual = -1;
        verifySortedNumericDouble(multiValues, numDocs);
                    actual = selected.longValue();
        final FixedBitSet docsWithValue = randomBoolean() ? null : new FixedBitSet(numDocs);
            public boolean advanceExact(int target) {
            public int docID() {
            }
                    } else {
        }
        for (int j = 0, numCall = randomIntBetween(1, 10); j < numCall; j++) {
                        }
                                    expected = Math.max(expected, values.nextValue());
            public int docID() {
                    return NO_MORE_DOCS;
 */
 * GitHub history for details.
            public boolean advanceExact(int doc) throws IOException {
        }
                );
        // Parent 3 has none: advance() must skip it and land on parent 5.
                            break;
                            expected = Math.max(expected, values.nextValue());
        rootDocs.set(1);
            if (randomBoolean()) {
    public void testNestedDoubleSelectAdvanceIsAligned() throws Exception {
                assertEquals(mode.toString() + " docId=" + root, expected, actual);
        // parents at doc 1 and 3; children at doc 0 and 2.
            }
        for (long missingValue : new long[] { 0, randomLong() }) {
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
                    if (mode == MultiValueMode.MAX) {
                            expected = values.nextValue();
                i = 0;
                int prevRoot = -1;
    }
                Long expected = null;
            }
            }
 */
        assertEquals(new BytesRef("a"), selected.binaryValue());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                    missingValue,
        }
                            for (int j = 0; j < values.docValueCount(); ++j) {
                MultiValueMode.AVG }) {
            Integer.MAX_VALUE
                            }
                    assertTrue(selected.advanceExact(i));
        }
                                    expected = Math.max(expected, (int) ord);
            public long nextValue() {
            assertEquals(values.binaryValue(), expected);
            public long nextValue() {
                    int numValues = 0;
            }
            int i;
                return array[docID];
        FixedBitSet innerDocs,
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
                    }
            out.writeVInt(4);
                array[i] = randomLong();
                                expected = (int) ord;
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
 * not use this file except in compliance with the License.
            }
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
        // the last doc must be a root doc
            @Override
                i = 0;
        verifySortedBinary(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
            for (MultiValueMode mode : new MultiValueMode[] { MultiValueMode.MIN, MultiValueMode.MAX }) {
                            for (int j = 0; j < values.docValueCount(); ++j) {
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.MEDIAN));
                    if (values.advanceExact(i) == false) {
    private void verifySortedNumericDouble(
                    values,
                        expected = missingValue;
                            expected = Math.min(expected, values.nextValue());
        verifySortedNumericDouble(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
        // And a target beyond the bitset returns NO_MORE_DOCS without touching nextSetBit at all.
            @Override
    public void testMultiValuedLongs() throws Exception {
                    } else if (mode == MultiValueMode.AVG) {
                    for (long ord = values.nextOrd(); ord != SortedSetDocValues.NO_MORE_DOCS
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
                docsWithValue.set(i);
                    } else if (mode == MultiValueMode.MIN) {
                    }
            final NumericDocValues selected = mode.select(values);
        for (MultiValueMode mode : MultiValueMode.values()) {
                            if (mode == MultiValueMode.MIN) {
                                        expected = expected.compareTo(value) > 0 ? expected : BytesRef.deepCopyOf(value);
                        expected = missingValue;
                    }
            public long nextOrd() {
                            }
        int maxChildren
        assertEquals(3, selected.advance(3));
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
        int maxChildren
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        final Supplier<SortedSetDocValues> multiValues = () -> new AbstractSortedSetDocValues() {
            }
                                    expected = Math.min(expected, (int) ord);
        for (int i = 0; i < numDocs; ++i) {
                if (docsWithValue != null) {
                    rootDocs,
    public void testMultiValuedDoubles() throws Exception {
                                } else if (mode == MultiValueMode.MAX) {
                            for (int j = 0; j < value; ++j) {
                        } else if (mode == MultiValueMode.MAX) {
                }
                int prevRoot = -1;
            public boolean advanceExact(int target) throws IOException {
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
        for (int i = 0; i < array.length; ++i) {
 * compatible open source license.
    }
        final int numDocs = 4;
                        expected = Numbers.MIN_UNSIGNED_LONG_VALUE;
                    }
                return docsWithValue == null || docsWithValue.get(docID);
                        }
            }
            0L,
                    final long actual = selected.longValue();
    private void verifySortedSet(Supplier<SortedSetDocValues> supplier, int maxDoc) throws IOException {
                    }
            @Override
            assertEquals(values.ordValue(), expected);
                }
        final Supplier<SortedBinaryDocValues> multiValues = () -> new SortedBinaryDocValues() {
                assertThat(in.readVInt(), equalTo(2));
                                }
            @Override
                        expected = Long.MIN_VALUE;
                array[i] = randomDouble();
            }
        final long[][] array = new long[numDocs][];
                                if (mode == MultiValueMode.MIN) {
            public int docID() {
                    }
        final long[] array = new long[numDocs];
                                if (mode == MultiValueMode.MIN) {
                        } else {
                    verifyDoubleValueCanCalledMoreThanOnce(selected, actual);
    public void testNestedUnsignedLongSelectSupportsAdvance() throws Exception {
        final int numDocs = 4;
                                    expected = expected.compareTo(value) <= 0 ? expected : BytesRef.deepCopyOf(value);
                int expected = -1;
            SortedSetDocValues values = supplier.get();
            Arrays.sort(values);
                    }
                this.doc = doc;
                }
            try (StreamInput in = out.bytes().streamInput()) {
    }
        // Ordinals have no missing-value fallback, so the values are sparse.
                    docsWithValue.set(i);
                        if (values.advanceExact(child)) {
                    maxDoc,
        final double[] array = new double[] { 10.0, 20.0, 30.0, 40.0 };
    // GITHUB#17140: the nested double select advances by parent doc (like the other nested selects),
                assertEquals(mode.toString() + " docId=" + i, expectedLong, actual);
            int doc;
                                if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
            rootDocs,
        final int numDocs = 4;
            public boolean advanceExact(int target) throws IOException {
            try (StreamInput in = out.bytes().streamInput()) {
                MultiValueMode.AVG }) {
                                expected = Math.max(expected, (int) ord);
            }
            }
                        expected = numValues > 1 ? Math.round((double) expected / (double) numValues) : expected;
            array[i] = values;
            }
            int docId = -1;
import org.apache.lucene.util.FixedBitSet;
                    double expected = 0.0;
        verifySortedSet(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
            0.0,
                                break;
                }
                MultiValueMode.MAX,
                );
            if (randomBoolean()) {
                SortedNumericDocValues values = supplier.get();
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.SUM));
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.MAX));
            }
import org.apache.lucene.index.SortedDocValues;
    }
            public long getValueCount() {
            @Override
        };
            for (int j = 0; j < values.length; ++j) {
            }
            }
                    assertEquals(mode.toString() + " docId=" + root, expectedLong, actual);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                if (selected.advanceExact(root)) {
            out.writeVInt(3);
        final int numDocs = 4;
                }
                        if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
            }
 * this work for additional information regarding copyright
                    for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(
        }
            numDocs,
                    verifyBinaryValueCanCalledMoreThanOnce(selected, actual);
                        expected = 0L;
        };
 * Licensed to Elasticsearch under one or more contributor
                                }
                            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                    values,
                }
        Supplier<SortedNumericUnsignedLongValues> supplier,
                                if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
                this.doc = doc;
                return docId;
        for (MultiValueMode mode : new MultiValueMode[] { MultiValueMode.MIN, MultiValueMode.MAX }) {
            }
                assertEquals(mode.toString() + " docId=" + i, expected, actual);
            public long nextValue() {
                                    if (mode == MultiValueMode.MIN) {
        }
            @Override
                    int count = 0;
            @Override
                    assertEquals(mode.toString() + " docId=" + root, expected, actual);
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        // every doc has a value (advanceExact always returns true), so advance(target) returns target
                return array[doc].length > 0;
        }
            public int docValueCount() {
                    prevRoot = root;
        rootDocs.set(3);
            }
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
        });
                    prevRoot = root;
                assertEquals(mode.toString() + " docId=" + i, expected, actual);
                        expectedLong = missingValue;
        final int numDocs = scaledRandomIntBetween(1, 100);
            Arrays.sort(values);
                docID = target;
            }
            int docId = -1;
                        expected = missingValue;
        assertEquals(1, selected.advance(1));
                                }
import org.apache.lucene.index.SortedNumericDocValues;
            }
                    } else if (mode == MultiValueMode.MIN) {
            }
                        }
                    BigInteger expected = BigInteger.ZERO;
                            } else if (mode == MultiValueMode.MAX) {
                            ? new BigDecimal(expected).divide(new BigDecimal(numValues), RoundingMode.HALF_UP).toBigInteger()
        array[4] = new long[] { 1 };
            @Override
                        } else if (mode == MultiValueMode.MAX) {
            @Override
                        }
            public int docValueCount() {
                }
        }
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);
        assertEquals(5, selected.docID());
            }
        });
    }
                MultiValueMode.MIN,
                                values.nextValue();
    private void verifyOrdValueCanCalledMoreThanOnce(SortedDocValues values, long expected) throws IOException {
            public long getValueCount() {
    public void testReadFrom() throws Exception {
        for (long missingValue : new long[] { 0, randomUnsignedLong().longValue() }) {
            }
        }
    }
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
import java.math.BigDecimal;
        final FixedBitSet docsWithValue = randomBoolean() ? null : new FixedBitSet(numDocs);
            @Override
                        expected = Long.MAX_VALUE;
        final SortedBinaryDocValues values = FieldData.singleton(new AbstractBinaryDocValues() {
                return array[docId];
import org.opensearch.core.common.io.stream.StreamInput;
            array[i] = values;
            }
        }
            new BitSetIterator(innerDocs, 0L),
            public boolean advanceExact(int doc) {
            }
            }
        Supplier<SortedNumericDoubleValues> supplier,
        );
            public long longValue() {
        final long[] array = new long[numDocs];
            }
    }
            public boolean advanceExact(int target) throws IOException {
                array[i] = randomUnsignedLong().longValue();
                    } else {
 * ownership. Elasticsearch licenses this file to you under
        final FixedBitSet docsWithValue = randomBoolean() ? null : new FixedBitSet(numDocs);
                        if (expected == null) {
                for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
                this.docId = target;
                assertThat(in.readVInt(), equalTo(4));
        for (int i = 0; i < array.length; ++i) {
                this.docId = target;
        for (int i = 0; i < numDocs; ++i) {
                    for (int j = 0; j < numValues; ++j) {
                if (selected.advanceExact(i)) {
            try (StreamInput in = out.bytes().streamInput()) {
        rootDocs.set(3);
            rootDocs,
        verifySortedSet(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
                                    expected = BytesRef.deepCopyOf(values.nextValue());
        innerDocs.set(0);
                    BytesRef expected = null;
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
                            expected += values.nextValue();
                docsWithValue.set(i);
        assertEquals(1, selected.advance(1));
        int maxDoc,
            MultiValueMode.MEDIAN.writeTo(out);
                int prevRoot = -1;
                    }
    }
        final NumericDoubleValues selected = MultiValueMode.MIN.select(
            int doc;
            }
        assertEquals(1, selected.docID());
            @Override
 * KIND, either express or implied.  See the License for the
            }
        verifySortedNumeric(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
                this.doc = doc;
        FixedBitSet innerDocs = new FixedBitSet(rootDocs.length());
                        if (values.advanceExact(child)) {
                    new BitSetIterator(innerDocs, 0L),
            array[i] = values;
                    }
            }
        assertThat(MultiValueMode.SUM.ordinal(), equalTo(0));
    public void testNestedSelectSupportsAdvance() throws Exception {
        final Supplier<SortedNumericDocValues> multiValues = () -> new AbstractSortedNumericDocValues() {
    ) throws IOException {
                            if (expected == -1) {
            array[i] = values;
                                break;
 * specific language governing permissions and limitations
        );
            @Override
        verifySortedUnsignedLong(multiValues, numDocs);
                SortedNumericUnsignedLongValues values = supplier.get();
            final SortedDocValues selected = mode.select(values);
                for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(child + 1)) {
        innerDocs.set(2);
            public BytesRef lookupOrd(long ord) {
            public int docValueCount() {
                    }
        final double[][] array = new double[numDocs][];
            @Override
            public boolean advanceExact(int target) {
            for (int i = 0; i < maxDoc; ++i) {
                    prevRoot = root;
                i = 0;
                    )) {
            try (StreamInput in = out.bytes().streamInput()) {
        innerDocs.set(0);
                        expected = Long.MAX_VALUE;
            MultiValueMode.MAX.writeTo(out);
                return true;
                                    expected = Math.max(expected, values.nextValue());
                    maxChildren
            int i;
            @Override
                        int value = numValues / 2;
    public void testMultiValuedStrings() throws Exception {
                        int numValues = values.docValueCount();
                    docsWithValue.set(i);
        }
        verifySortedBinary(multiValues, numDocs);
                    missingValue,
            @Override
            @Override
            @Override
            }
                return docId;
            }
                return array[doc].length;
            public boolean advanceExact(int docID) {
                        expected = Long.MAX_VALUE;
                prevRoot = root;
    // test exercises advance() on the nested long/date select; it throws UOE without the fix.
        final int numDocs = scaledRandomIntBetween(1, 100);
                return 1 << 20;
                    for (int j = 0; j < numValues; ++j) {
    }
            MultiValueMode.MIN.writeTo(out);
                                values.nextValue();
                                    expected += values.nextValue();
                            expected = Math.round(((double) values.nextValue() + values.nextValue()) / 2.0);
                array[i] = -1;
                return array[doc].length > 0;
        );
                        child + 1
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
                return array[doc].length > 0;
                        }
                MultiValueMode.SUM,
                                    expected = expected.compareTo(value) > 0 ? expected : BytesRef.deepCopyOf(value);
    // termination (track_total_hits:false), which hit the base UnsupportedOperationException. This
            values,
                                }
            @Override
                                if (expected == null) {
            new BitSetIterator(innerDocs, 0L),
            @Override
        for (long missingValue : new long[] { 0, randomLong() }) {
        FixedBitSet rootDocs,
    }
                }
import java.util.Arrays;
                SortedNumericDoubleValues values = supplier.get();
        rootDocs.set(3);
