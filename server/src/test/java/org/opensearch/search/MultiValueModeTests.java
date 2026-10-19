                            if (++count > maxChildren) {
                    verifyBinaryValueCanCalledMoreThanOnce(selected, actual);
            }
            @Override
import org.apache.lucene.util.BytesRef;  
                return array[docId];
                        expected = numValues > 1 ? Math.round((double) expected / (double) numValues) : expected;
        int maxChildren
                                ++numValues;  
                SortedNumericUnsignedLongValues values = supplier.get();
                    rootDocs,
                if (values.advanceExact(i)) {
                }
        FixedBitSet innerDocs,  
    }
                    }
                return array[docId];  
                }
                    new BitSetIterator(innerDocs, 0L),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
    // GITHUB#17140 / #21537: the same advance() gap existed on the nested unsigned-long, binary, and  
                    } else {  
                    verifyLongValueCanCalledMoreThanOnce(selected, actual);
                        child + 1  
        };  
                    actual = selected.doubleValue();
                    maxChildren
                                    expected = Math.max(expected, (int) ord);
                if (docsWithValue != null) {
            public long nextOrd() {
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
    private void verifySortedUnsignedLong(Supplier<SortedNumericUnsignedLongValues> supplier, int maxDoc) throws IOException {
            public int getValueCount() {
                        }  
            }  
        for (BytesRef missingValue : new BytesRef[] { new BytesRef(), new BytesRef(randomAlphaOfLengthBetween(8, 8)) }) {
                                    expected += values.nextValue();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
    }  
                return 1 << 20;
                    } else if (mode == MultiValueMode.MEDIAN) {
                return array[doc].length > 0;
        verifySortedNumeric(multiValues, numDocs);
            final long[] values = new long[randomInt(4)];
            public long getValueCount() {
                        if (values.advanceExact(child)) {  
        final SortedNumericDoubleValues values = new SortedNumericDoubleValues() {
            public int docID() {
                        if (numValues % 2 == 0) {
                        expected = missingValue;
            }  
 * license agreements. See the NOTICE file distributed with
                        } else {  
            for (int j = 0; j < values.length; ++j) {  
            }
        // advanceExact() returns false for parents 3 and 7 and advance() has to scan past them.
                    verifyLongValueCanCalledMoreThanOnce(selected, actual);
    }
        rootDocs.set(3);
            public int docID() {  
            }  
        for (BytesRef missingValue : new BytesRef[] { new BytesRef(), new BytesRef(randomAlphaOfLengthBetween(8, 8)) }) {  
    }
        for (MultiValueMode mode : MultiValueMode.values()) {
        verifySortedBinary(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
                                } else if (mode == MultiValueMode.MIN) {
                return array[docId];  
            }  
                            break;
                    }
            numDocs,  
        }
                            expected += values.nextValue();  
            public int docID() {
    }
            }  
            int doc;  
        verifySortedSet(multiValues, numDocs);  
            int i;
                            expected = values.nextValue();
                Double expected = null;  
                    }  
    public void testFromString() {
            public int docValueCount() {
        Supplier<SortedNumericUnsignedLongValues> supplier,
            values,
                    assertTrue(selected.advanceExact(root));
                            }
            @Override
            @Override  
            }  
                i = 0;  
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);  
                values[j] = randomDouble();
                int count = 0;
        for (long missingValue : new long[] { 0, randomLong() }) {
                            }
 */
            } else {
            }  
    private void verifySortedNumeric(
            }
            numDocs,
            @Override  
                assertThat(in.readVInt(), equalTo(3));
                        expected = numValues > 1 ? Math.round((double) expected / (double) numValues) : expected;  
            values,
                }
        assertThat(MultiValueMode.MIN.ordinal(), equalTo(3));
                }  
            @Override
                    assertTrue(selected.advanceExact(root));  
            public BytesRef lookupOrd(long ord) {
        );
 * GitHub history for details.
        final Supplier<SortedNumericUnsignedLongValues> multiValues = () -> new SortedNumericUnsignedLongValues() {
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(6));
                    docsWithValue.set(i);
                                }  
                assertThat(in.readVInt(), equalTo(0));
                return array[doc].length;
                    if (numValues == 0) {
                    )) {
                this.docId = target;
                    }
            try (StreamInput in = out.bytes().streamInput()) {
                    final double actual = selected.doubleValue();
            array[i] = values;
                if (docsWithValue != null) {
            @Override
    private void verifySortedBinary(Supplier<SortedBinaryDocValues> supplier, int maxDoc) throws IOException {
                    verifyLongValueCanCalledMoreThanOnce(selected, actual);
                            expected = Math.min(expected, values.nextValue());
        innerDocs.set(6);
                        if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
                    missingValue,
    // sort optimization makes NumericComparator's competitive iterator call advance() during early
                }
            @Override
    }  
                return array[doc].length > 0;  
            }
                        } else if (mode == MultiValueMode.MIN) {
        verifySortedUnsignedLong(multiValues, numDocs);
                i = 0;
                            expected = expected.max(Numbers.toUnsignedBigInteger(values.nextValue()));
                    } else if (mode == MultiValueMode.MIN) {  
                        expected = Double.POSITIVE_INFINITY;  
                    int numValues = 0;
        innerDocs.set(0);
            }
        final long[][] array = new long[numDocs][];
            try (StreamInput in = out.bytes().streamInput()) {  
            @Override
                            expected = missingValue;  
                                break;
                );  
            public double nextValue() {
        assertThat(MultiValueMode.fromString("sum"), equalTo(MultiValueMode.SUM));  
    private void verifyOrdValueCanCalledMoreThanOnce(SortedDocValues values, long expected) throws IOException {
            final NumericDocValues selected = mode.select(values);  
                }
                return NO_MORE_DOCS;  
                }  
                SortedBinaryDocValues values = supplier.get();
                        for (int j = 0; j < numValues; ++j) {
                        && docValueCount < values.docValueCount(); ord = values.nextOrd(), ++docValueCount) {
            MultiValueMode.MAX.writeTo(out);  
        for (int i = 0; i < numDocs; ++i) {  
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
            Integer.MAX_VALUE
        final double[] array = new double[] { 10.0, 20.0, 30.0, 40.0 };  
                        expected = Long.MAX_VALUE;
        };
                    }  
            }
 * SPDX-License-Identifier: Apache-2.0
            }  
        FixedBitSet rootDocs,
            }
                    int numValues = values.docValueCount();
                docsWithValue.set(i);
            final BytesRef[] values = new BytesRef[randomInt(4)];  
            public boolean advanceExact(int target) {  
                    } else if (mode == MultiValueMode.AVG) {
                    } else if (mode == MultiValueMode.MIN) {
    public void testValidOrdinals() {
        }
    }
                        } else {  
    public void testSingleValuedDoubles() throws Exception {
                        expected = Double.NEGATIVE_INFINITY;
            public BytesRef nextValue() {  
            int doc;
            }
            @Override
                        if (numValues % 2 == 0) {
                                    } else if (mode == MultiValueMode.MAX) {
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.docID());
    // doc has a value). Verifies advance() no longer throws and positions correctly.
                return array[doc][i++];
                    if (mode == MultiValueMode.MAX) {  
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);  
                        }
            public BytesRef lookupOrd(int ord) {  
        final BinaryDocValues selected = MultiValueMode.MIN.select(
            Arrays.sort(values);  
import org.opensearch.index.fielddata.AbstractSortedNumericDocValues;
                    int count = 0;
        final BytesRef[][] array = new BytesRef[numDocs][];
            } else {  
        }
                }
        }
    }
            public int docID() {
                    } else if (mode == MultiValueMode.MIN) {
                return 1;
            new BitSetIterator(innerDocs, 0L),
                return 2;
                SortedNumericDocValues values = supplier.get();  
                    if (mode == MultiValueMode.MAX) {
        FixedBitSet innerDocs,
                MultiValueMode.SUM,
                }
            assertEquals(expected, values.longValue());
                array[i] = randomInt(1000);
    }
            for (int i = 0; i < maxDoc; ++i) {
                );  
    public void testMultiValuedLongs() throws Exception {  
                    }  
    private void verifySortedBinary(
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
            public boolean advanceExact(int doc) {
    private void verifySortedNumericDouble(Supplier<SortedNumericDoubleValues> supplier, int maxDoc) throws IOException {
            for (MultiValueMode mode : new MultiValueMode[] { MultiValueMode.MIN, MultiValueMode.MAX }) {
        FixedBitSet rootDocs,  
        assertEquals(1, selected.advance(1));
                assertThat(in.readVInt(), equalTo(1));
            @Override  
            int i;
                return 1 << 20;  
    public void testReadFrom() throws Exception {
            new BitSetIterator(innerDocs, 0L),
            public boolean advanceExact(int target) throws IOException {
        }  
            MultiValueMode.MEDIAN.writeTo(out);
        }  
                        } else {
            }
        FixedBitSet rootDocs,
        final double[] array = new double[numDocs];
                return array[doc].length > 0;
                int expected = -1;  
        final NumericDocValues selected = MultiValueMode.MIN.select(
                return array[doc].length > 0;
                            }
                return docID;  
        final int numDocs = 4;
            }
            SortedSetDocValues values = supplier.get();  
            new BitSetIterator(innerDocs, 0L),  
                            expected = Math.max(expected, values.nextValue());  
            @Override
                    }  
            }  
            @Override  
                    )) {
                array[i] = new BytesRef();
        set.set(maxDoc - 1);
            out.writeVInt(4);
        rootDocs.set(5);
        }
                        expected = Long.MIN_VALUE;  
            out.writeVInt(1);
    // GITHUB#17140: the nested double select advances by parent doc (like the other nested selects),
            public long nextValue() {
                                    expected = Math.min(expected, (int) ord);  
            }
                docID = target;  
        rootDocs.set(1);
        for (int i = 0; i < numDocs; ++i) {
                    verifyDoubleValueCanCalledMoreThanOnce(selected, actual);  
        final FixedBitSet rootDocs = randomRootDocs(numDocs);  
                        }
                set.set(i);
            public boolean advanceExact(int doc) {
                                values.nextValue();  
            for (MultiValueMode mode : new MultiValueMode[] { MultiValueMode.MIN, MultiValueMode.MAX }) {  
                }
                                values.nextValue();
 * not use this file except in compliance with the License.
public class MultiValueModeTests extends OpenSearchTestCase {
                docID = doc;  
                                } else if (mode == MultiValueMode.MIN) {
        for (int i = 0; i < array.length; ++i) {  
        final Supplier<SortedNumericUnsignedLongValues> multiValues = () -> new SortedNumericUnsignedLongValues() {
        return set;  
                        } else if (mode == MultiValueMode.MAX) {  
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);  
                            }
            numDocs,  
        innerDocs.set(0);
                final BinaryDocValues selected = mode.select(values, missingValue);  
        final SortedSetDocValues values = new AbstractSortedSetDocValues() {  
                                if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);
        final Supplier<SortedNumericDoubleValues> multiValues = () -> new SortedNumericDoubleValues() {  
            public boolean advanceExact(int docID) {
                this.doc = docID;
                this.doc = doc;
                MultiValueMode.MAX,
        assertEquals(1, selected.docID());  
                    missingValue,
            public long nextValue() {
                    )) {
            final SortedDocValues selected = mode.select(values);
            }
                            for (int j = 0; j < value; ++j) {
        }
            @Override
        verifySortedUnsignedLong(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
    // GITHUB#17140 / #21537: the nested select(...parentDocs, childDocs...) returned an  
            }
        for (int j = 0, numCall = randomIntBetween(1, 10); j < numCall; j++) {
                    assertEquals(mode.toString() + " docId=" + i, expected, actual);
        final int numDocs = scaledRandomIntBetween(1, 100);
                    return NO_MORE_DOCS;
        rootDocs.set(1);
    private static FixedBitSet randomInnerDocs(FixedBitSet rootDocs) {  
                    values,
                );
            @Override
                            }  
        verifySortedNumericDouble(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);  
    }
                                }
                    } else if (mode == MultiValueMode.AVG) {  
    public void testMultiValuedStrings() throws Exception {
            final double[] values = new double[randomInt(4)];
                            expected = expected.min(Numbers.toUnsignedBigInteger(values.nextValue()));
    }
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);
                    }  
                MultiValueMode.MIN,
    }
                                expected = Math.min(expected, (int) ord);  
                    if (values.advanceExact(i) == false) {
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);  
            @Override
        }
        );
                            : expected;
            @Override
            assertEquals(values.ordValue(), expected);  
        final NumericDocValues selected = MultiValueMode.MIN.select(
        FixedBitSet rootDocs,
            @Override
            } else if (docsWithValue != null && randomBoolean()) {  
            new BytesRef("_missing_"),  
        };  
                }  
                    rootDocs,
            for (int j = 0; j < values.length; ++j) {  
            public int docValueCount() {  
            public BytesRef binaryValue() {  
        }  
            @Override  
            numDocs,
                    return array[doc][i++];
                    actual = selected.longValue();
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);  
    }  
        }
                    new BitSetIterator(innerDocs, 0L),
            public boolean advanceExact(int doc) throws IOException {
        final int numDocs = scaledRandomIntBetween(1, 100);
                int expected = -1;  
import org.apache.lucene.util.BitSetIterator;
                    for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(  
                Long expected = null;
                }  
                    for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(  
            public boolean advanceExact(int target) {
                        int value = numValues / 2;  
            }
            public int docID() {
            public int docValueCount() {
                                    }
            public BytesRef binaryValue() {
            }  
        int maxDoc,
                        child + 1
            public long nextValue() {
                        if (values.advanceExact(child)) {  
        FixedBitSet innerDocs,
                    if (mode == MultiValueMode.AVG) {
                );  
import org.opensearch.core.common.io.stream.StreamInput;
                    new BitSetIterator(innerDocs, 0L),  
            if (randomBoolean()) {
            }
            }  
                    if (numValues == 0) {  
                    }
                SortedNumericDoubleValues values = supplier.get();
            array[i] = new long[0];
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                            && docValueCount < values.docValueCount(); ord = values.nextOrd(), ++docValueCount) {
                if (selected.advanceExact(i)) {  
        assertEquals(1, selected.advance(1));
                    final BytesRef actual = selected.binaryValue();
                    prevRoot = root;
                values[j] = randomLong();  
                            if (++count > maxChildren) {
                                }
            final long[] values = new long[randomInt(4)];
        final int[] array = new int[numDocs];
        final long[][] array = new long[numDocs][];  
                i = 0;
                    values,  
                    } else if (mode == MultiValueMode.MIN) {
                this.docId = target;  
                    } else if (mode == MultiValueMode.MIN) {
                return doc;
                MultiValueMode.AVG }) {  
                        expected = Numbers.MIN_UNSIGNED_LONG_VALUE;
                            if (++count > maxChildren) {
                    } else if (mode == MultiValueMode.MEDIAN) {  
                        if (++count > maxChildren) {
            final long[] values = new long[randomInt(4)];
import org.apache.lucene.index.SortedNumericDocValues;
                        for (int j = 0; j < numValues; ++j) {
                return array[doc].length;
            values,
        // Parents at 1, 3, 5, 7; their children are 0, 2, 4, 6. Only children 0 and 4 carry an ord, so  
            }  
                                values.nextValue();  
                    docsWithValue.set(i);
            }
            int docId = -1;
            out.writeVInt(2);
            @Override  
                assertEquals(mode.toString() + " docId=" + i, expected, actual);
                return true;
        verifySortedUnsignedLong(multiValues, numDocs);
                                values.nextValue();
        for (long missingValue : new long[] { 0, randomLong() }) {  
                            expected = Math.round(((double) values.nextValue() + values.nextValue()) / 2.0);
            0.0,
                        }
        final Supplier<SortedSetDocValues> multiValues = () -> new AbstractSortedSetDocValues() {
        final FixedBitSet docsWithValue = randomBoolean() ? null : new FixedBitSet(numDocs);  
            if (randomBoolean()) {
                        expected = Numbers.MIN_UNSIGNED_LONG_VALUE;  
                        expected = missingValue;
        for (int j = 0, numCall = randomIntBetween(1, 10); j < numCall; j++) {  
                return BytesRef.deepCopyOf(array[docID]);
    }
                    maxDoc,
    private static FixedBitSet randomRootDocs(int maxDoc) {  
                i = 0;  
                                    expected = Math.max(expected, values.nextValue());  
        rootDocs.set(7);  
import java.math.BigDecimal;  
                                        expected = expected.compareTo(value) <= 0 ? expected : BytesRef.deepCopyOf(value);
                            }  
                        }
                }
                            } else if (mode == MultiValueMode.MAX) {
            }
 * Licensed to Elasticsearch under one or more contributor  
        }  
                return true;
        verifySortedSet(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
            }
                    }  
                        }
                i = 0;  
            @Override
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
        innerDocs.set(2);  
                            expected = Math.min(expected, values.nextValue());
                        expected = expected / numValues;
            @Override
            }
            }
                docID = target;  
import org.opensearch.index.fielddata.FieldData;
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(MultiValueMode.SUM.ordinal(), equalTo(0));
                this.docId = target;  
        final long[] array = new long[numDocs];  
                    maxChildren
    ) throws IOException {  
                                expected = Math.max(expected, (int) ord);
            rootDocs,
            for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {  
            }
        }
                    actual = selected.ordValue();  
        }
            @Override
import java.math.BigInteger;
            public boolean advanceExact(int target) {
                this.doc = doc;
                return true;  
                    BytesRef expected = null;  
                if (selected.advanceExact(i)) {
                Long actual = null;  
            }
            @Override  
            SortedSetDocValues values = supplier.get();
        final FixedBitSet docsWithValue = randomBoolean() ? null : new FixedBitSet(numDocs);
        final SortedNumericUnsignedLongValues values = new SortedNumericUnsignedLongValues() {  
            }
/*  
            public boolean advanceExact(int target) {
                        expected = 0d;
                    docsWithValue.set(i);
                return array[doc].length;
        };
        }  
            }
                final BinaryDocValues selected = mode.select(
        assertThat(MultiValueMode.fromString("median"), equalTo(MultiValueMode.MEDIAN));
                    for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(
        final Supplier<SortedBinaryDocValues> multiValues = () -> FieldData.singleton(new AbstractBinaryDocValues() {
            public boolean advanceExact(int target) throws IOException {  
                                break;
        }  
            public long longValue() {
            @Override
            int i;
            }
            @Override
                }
            public long getValueCount() {
        verifySortedNumericDouble(multiValues, numDocs);  
                assertEquals(mode.toString() + " docId=" + i, expectedLong, actual);
                    } else {  
        for (MultiValueMode mode : new MultiValueMode[] { MultiValueMode.MIN, MultiValueMode.MAX }) {  
            }
                }
import java.math.RoundingMode;
        innerDocs.set(2);
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
        rootDocs.set(3);
            }
        assertEquals(3, selected.advance(3));  
                                } else if (mode == MultiValueMode.MAX) {  
            @Override
        for (int i = 0; i < numDocs; ++i) {  
                        expected = BigInteger.ZERO;
            rootDocs,  
                    }
    }  
            @Override
            out.writeVInt(0);  
        assertEquals(3, selected.advance(3));
                prevRoot = root;
        // Ordinals have no missing-value fallback, so the values are sparse.
                if (values.advanceExact(i)) {  
                    }  
                    }  
                    maxChildren
            int docID;  
                MultiValueMode.MIN,  
                    int count = 0;
            public int docValueCount() {
                array[i] = randomLong();
                            if (++count > maxChildren) {  
        };  
            }
                    for (int j = 0; j < numValues; ++j) {
            public int docID() {  
        // Parent 3 has none: advance() must skip it and land on parent 5.  
                        if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
                        }
            public boolean advanceExact(int doc) {  
                    values,  
                if (selected.advanceExact(i)) {
import java.io.IOException;
                        expected = Numbers.MAX_UNSIGNED_LONG_VALUE;  
                                break;
    public void testNestedDoubleSelectAdvanceIsAligned() throws Exception {
    }
import org.apache.lucene.index.BinaryDocValues;
            }
                    }
    // termination (track_total_hits:false), which hit the base UnsupportedOperationException. This  
            public boolean advanceExact(int target) throws IOException {
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
            }
                            for (int j = 0; j < value - 1; ++j) {  
                    maxChildren
                    double expected = 0.0;
            }  
                                    expected = Math.min(expected, values.nextValue());
                return docsWithValue == null ? true : docsWithValue.get(docId);
            }  
        assertThat(MultiValueMode.fromString("max"), equalTo(MultiValueMode.MAX));
                    for (long ord = values.nextOrd(); ord != SortedSetDocValues.NO_MORE_DOCS  
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
        // advance(target) lands on target.
        }
                return BytesRef.deepCopyOf(array[doc][i++]);
        final Supplier<SortedNumericDoubleValues> multiValues = () -> FieldData.singleton(new NumericDoubleValues() {
                    actual = selected.ordValue();  
            int doc;
            }  
            }
    }
        FixedBitSet set = new FixedBitSet(maxDoc);
                values[j] = j == 0 ? randomInt(1000) : values[j - 1] + 1 + randomInt(1000);
                    if (expected == null) {  
            }  
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
            out.writeVInt(3);  
            public int docValueCount() {
            Arrays.sort(values);
import org.opensearch.index.fielddata.AbstractSortedDocValues;
                array[i] = randomUnsignedLong().longValue();
                            expected = expected.add(Numbers.toUnsignedBigInteger(values.nextValue()));  
    public void testNestedBinarySelectSupportsAdvance() throws Exception {
                    } else {
    }
                            expected = (values.nextValue() + values.nextValue()) / 2.0;  
 *
        innerDocs.set(4);
            @Override
                    }
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
        final int numDocs = 4;
                final NumericDoubleValues selected = mode.select(
        FixedBitSet innerDocs,
                            }  
        }
                        expectedLong = missingValue;  
                }
                return docId;
        final FixedBitSet docsWithValue = randomBoolean() ? null : new FixedBitSet(numDocs);
        // A missing value is emitted when no child matches, so every parent has a value and  
                            ? new BigDecimal(expected).divide(new BigDecimal(numValues), RoundingMode.HALF_UP).toBigInteger()
        for (int i = 0; i < numDocs; ++i) {
}  
                }
    public void testNestedSortedSetSelectAdvanceSkipsParentsWithoutOrds() throws Exception {
        assertThat(MultiValueMode.MEDIAN.ordinal(), equalTo(2));
            final NumericDocValues selected = mode.select(values);
    }
        verifySortedNumeric(multiValues, numDocs);
            }
                    }
        // and docID() reflects it; past the last doc it returns NO_MORE_DOCS.
                        }
                                    expected += values.nextValue();  
                    }
            public long nextValue() {
                    if (mode == MultiValueMode.MAX) {
                            expected += values.nextValue();
        innerDocs.set(2);
            int docId = -1;  
        // every doc has a value (advanceExact always returns true), so advance(target) returns target  
            }
        innerDocs.set(0);  
        verifySortedNumeric(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));  
            Integer.MAX_VALUE  
            rootDocs,
            @Override
                            expected = new BigDecimal(expected).divide(new BigDecimal(2), RoundingMode.HALF_UP).toBigInteger();
            }  
    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                            for (int j = 0; j < values.docValueCount(); ++j) {
        verifySortedNumericDouble(multiValues, numDocs);  
            }  
    }
            try (StreamInput in = out.bytes().streamInput()) {
                                } else if (mode == MultiValueMode.MAX) {  
                    return array[doc][i++];  
        final long[] array = new long[] { 10, 20, 30, 40 };
                return docsWithValue == null || docsWithValue.get(docID);
                                    expected = Math.min(expected, values.nextValue());
        verifySortedNumeric(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
                                expected = BytesRef.deepCopyOf(values.nextValue());
                SortedBinaryDocValues values = supplier.get();
        final int numDocs = scaledRandomIntBetween(1, 100);  
                    }  
        int maxChildren
        Supplier<SortedNumericDocValues> supplier,  
    private void verifyDoubleValueCanCalledMoreThanOnce(NumericDoubleValues values, double expected) throws IOException {  
        }  
                    }  
                                    if (mode == MultiValueMode.MIN) {  
        });
        verifySortedUnsignedLong(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
            @Override  
        }
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);
                            expected = (int) ord;  
            int docId = -1;
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
                    prevRoot = root;
        verifySortedNumericDouble(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
                    rootDocs,
                            for (int j = 0; j < values.docValueCount(); ++j) {
                        expected = expected / numValues;
        rootDocs.set(1);  
                            if (expected == -1) {
                    }  
                                    expected = expected.max(Numbers.toUnsignedBigInteger(values.nextValue()));
    }  
            for (MultiValueMode mode : new MultiValueMode[] {
    public void testNestedUnsignedLongSelectSupportsAdvance() throws Exception {  
            public boolean advanceExact(int doc) {  
                    docsWithValue.set(i);  
                if (i < array[doc].length) {  
                return array[docID];  
            MultiValueMode.AVG.writeTo(out);  
            }
        // Parent 7 is the last parent and has no ord: the scan must terminate, not read past the bitset.  
                        }
            }
            try (StreamInput in = out.bytes().streamInput()) {  
                values[j] = new BytesRef(randomAlphaOfLengthBetween(8, 8));
import org.opensearch.index.fielddata.NumericDoubleValues;
                    new BitSetIterator(innerDocs, 0L),  
        final Supplier<SortedNumericDocValues> multiValues = () -> new AbstractSortedNumericDocValues() {
            }  
 * The OpenSearch Contributors require contributions made to  
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
                            }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                int prevRoot = -1;  
 * specific language governing permissions and limitations
                                if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
    public void testSingleValuedUnsignedLongs() throws Exception {
            for (int i = 0; i < maxDoc; ++i) {
            int docId = -1;  
            @Override
 */  
                                    expected = BytesRef.deepCopyOf(values.nextValue());  
                        expected = Long.MIN_VALUE;  
            }
            public int docValueCount() {  
    }
        for (int i = 0; i < array.length; ++i) {
import org.opensearch.index.fielddata.AbstractNumericDocValues;  
        final int numDocs = scaledRandomIntBetween(1, 100);  
            }
                    verifyDoubleValueCanCalledMoreThanOnce(selected, actual);
        for (int i = 0; i < innerDocs.length(); ++i) {
            try (StreamInput in = out.bytes().streamInput()) {
                assertEquals(mode.toString() + " docId=" + i, expected, actual);
                this.doc = doc;  
        assertEquals(1, selected.advance(1));
            @Override
            @Override  
                    assertEquals(mode.toString() + " docId=" + root, expected, actual, 0.1);
        assertEquals(1, selected.advance(1));  
        final long[][] array = new long[numDocs][];
            public double doubleValue() {
        innerDocs.set(2);
                        expected = Long.MAX_VALUE;
        verifySortedBinary(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
    public void testWriteTo() throws Exception {  
                        }
                return array[doc].length;  
        verifySortedNumericDouble(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);  
                i = 0;
    }
                long actual = -1;
        });
                    }  
        );  
        }  
                            }
            public int docValueCount() {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                    assertEquals(mode.toString() + " docId=" + root, expected, actual);  
import static org.hamcrest.Matchers.equalTo;
            SortedNumericDoubleValues values = supplier.get();  
            public BytesRef lookupOrd(long ord) {
                array[i] = new BytesRef(randomAlphaOfLengthBetween(8, 8));  
        return innerDocs;
        }
                            ? new BigDecimal(expected).divide(new BigDecimal(numValues), RoundingMode.HALF_UP).toBigInteger()
                    }
        }  
            final SortedDocValues selected = mode.select(values, rootDocs, new BitSetIterator(innerDocs, 0L), maxChildren);
        innerDocs.set(0);
            final NumericDoubleValues selected = mode.select(values);
        // The competitive iterator calls advance(int). Before the fix this threw
            int i;
            @Override
                Long actual = null;
    private interface Supplier<T> {
            }
        };
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.SUM));
                final Long expectedLong = expected == null ? null : expected.longValue();  
                return array[docId];  
                        expected = 0L;
                                }
        verifySortedBinary(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
                            }  
    }
            }
                                if (mode == MultiValueMode.MIN) {
                assertEquals(mode.toString() + " docId=" + i, expected, actual);  
                MultiValueMode.AVG }) {
    @FunctionalInterface
                    maxDoc,
                    BytesRef expected = null;
 * this file be licensed under the Apache-2.0 license or a
                MultiValueMode.SUM,
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);
        verifySortedUnsignedLong(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));  
    private void verifyLongValueCanCalledMoreThanOnce(NumericDocValues values, long expected) throws IOException {
import org.opensearch.index.fielddata.AbstractBinaryDocValues;
                if (i < array[doc].length) {
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.MEDIAN));
        for (int i = 0; i < array.length; ++i) {  
            SortedNumericDocValues values = supplier.get();
        }
    }
        for (int j = 0, numCall = randomIntBetween(1, 10); j < numCall; j++) {
                return docID;  
        final int numDocs = 4;  
        verifySortedSet(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);  
                Double actual = null;  
                    verifyBinaryValueCanCalledMoreThanOnce(selected, actual);
                            }  
            public int docValueCount() {
    // AbstractNumericDocValues that overrode only advanceExact, not advance(int). The point-based
 *
                    actual = selected.longValue();
 * this work for additional information regarding copyright
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);
                    } else {
        innerDocs.set(2);  
        verifySortedSet(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
        for (int i = 0; i < maxDoc; ++i) {
        }
 *  
                            : expected;
        FixedBitSet innerDocs,
                for (int i = 0; i < maxDoc; ++i) {
        FixedBitSet innerDocs = new FixedBitSet(rootDocs.length());
import org.apache.lucene.index.DocValues;
            }  
        int maxChildren
                if (docsWithValue != null) {  
                    } else if (mode == MultiValueMode.MEDIAN) {  
                                } else if (mode == MultiValueMode.MAX) {
    public void testSingleValuedStrings() throws Exception {  
 * KIND, either express or implied.  See the License for the
            @Override
                return 1;
                    } else if (mode == MultiValueMode.AVG) {
import org.opensearch.common.io.stream.BytesStreamOutput;  
                        }
            }
            rootDocs,
                MultiValueMode.AVG }) {  
                        if (expected == -1) {
            }  
                        expected = Numbers.toUnsignedBigInteger(expected.longValue());
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
                docsWithValue.set(i);
                    prevRoot = root;  
 * under the License.  
                if (values.advanceExact(i)) {
                int prevRoot = -1;
                        if (values.advanceExact(child)) {
            for (int i = 0; i < maxDoc; ++i) {
            }
                    verifyOrdValueCanCalledMoreThanOnce(selected, selected.ordValue());
                    }
        final BytesRef[] array = new BytesRef[] { new BytesRef("a"), new BytesRef("b"), new BytesRef("c"), new BytesRef("d") };  
                assertThat(in.readVInt(), equalTo(4));
                final NumericDocValues selected = mode.select(
            }
        for (int j = 0, numCall = randomIntBetween(1, 10); j < numCall; j++) {
                this.doc = doc;
            assertEquals(values.binaryValue(), expected);  
                                .add(Numbers.toUnsignedBigInteger(docValues[value]));  
    }
        verifySortedNumericDouble(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));
                        expected = Numbers.MAX_UNSIGNED_LONG_VALUE;
            }
        }  
            int prevRoot = -1;
import org.apache.lucene.util.FixedBitSet;
                            for (int j = 0; j < value - 1; ++j) {
                    for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(  
                                break;
                        expected = Numbers.toUnsignedBigInteger(expected.longValue());
            }
                        for (long ord = values.nextOrd(); ord != SortedSetDocValues.NO_MORE_DOCS  
        assertEquals(1, selected.docID());
                    assertTrue(selected.advanceExact(i));
                    if (numValues == 0) {
        final int numDocs = scaledRandomIntBetween(1, 100);  
                throw new UnsupportedOperationException();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                if (docsWithValue != null) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                                        expected = expected.compareTo(value) > 0 ? expected : BytesRef.deepCopyOf(value);  
                            expected = Numbers.toUnsignedBigInteger(docValues[value]);
    // sorted (keyword) selects. The unsigned-long select mirrors the numeric one (dense: every parent
            }  
import java.util.Arrays;  
            for (MultiValueMode mode : new MultiValueMode[] {
                } else {
                MultiValueMode.MAX,
    }  
        Supplier<SortedSetDocValues> supplier,
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
                        } else if (mode == MultiValueMode.MIN) {  
                assertEquals(mode.toString() + " docId=" + root, expected, actual);  
                final NumericDocValues selected = mode.select(
    }
                            for (int j = 0; j < value; ++j) {
                    int docValueCount = 0;
                if (values.advanceExact(i)) {
import org.apache.lucene.index.NumericDocValues;  
            public long longValue() {
                        child + 1
            public long nextOrd() {
            }
        int maxDoc,  
                            expected = Math.max(expected, values.nextValue());
        int maxDoc,
                    BigInteger expected = BigInteger.ZERO;
            int doc;  
import org.apache.lucene.index.SortedDocValues;
            }  
        // the last doc must be a root doc
            @Override
                    if (mode == MultiValueMode.MAX) {
        }  
                    for (int j = 0; j < numValues; ++j) {
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.MAX));  
        verifySortedBinary(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
        for (MultiValueMode mode : MultiValueMode.values()) {
            @Override
        rootDocs.set(1);  
        verifySortedBinary(multiValues, numDocs);
                                ++numValues;
                        expected = missingValue;
        };
        for (int i = 0; i < array.length; ++i) {
        rootDocs.set(1);
                    maxDoc,
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.AVG));  
                                    BytesRef value = values.nextValue();
            try (StreamInput in = out.bytes().streamInput()) {
                MultiValueMode.MAX,  
            private int docID = -1;
                    values,  
                return array[docID];
                            for (int j = 0; j < values.docValueCount(); ++j) {  
            public int ordValue() {
        int maxChildren  
                    int count = 0;
                    int numValues = values.docValueCount();
                        expected = Long.MIN_VALUE;
            if (randomBoolean()) {  
            Integer.MAX_VALUE
            for (int j = 0; j < values.length; ++j) {
        final BytesRef[] array = new BytesRef[numDocs];
        final FixedBitSet docsWithValue = randomBoolean() ? null : new FixedBitSet(numDocs);
 * compatible open source license.
            int docId = -1;
            @Override
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
        };  
    // not by advancing the child values iterator. Verifies advance() positions on the target parent doc.  
    }
                    int count = 0;
            @Override
        final int numDocs = scaledRandomIntBetween(1, 100);
                assertThat(MultiValueMode.readMultiValueModeFrom(in), equalTo(MultiValueMode.MIN));
        array[0] = new long[] { 0 };  
                                } else if (mode == MultiValueMode.MAX) {  
                        expected = missingValue;
                                    expected = expected.compareTo(value) > 0 ? expected : BytesRef.deepCopyOf(value);
                            } else {
            @Override
                                    expected = Math.max(expected, values.nextValue());
        for (MultiValueMode mode : MultiValueMode.values()) {
                    int numValues = values.docValueCount();
        final FixedBitSet rootDocs = randomRootDocs(numDocs);  
            for (int j = 0; j < values.length; ++j) {
                return docsWithValue == null || docsWithValue.get(docId);
        // And a target beyond the bitset returns NO_MORE_DOCS without touching nextSetBit at all.  
            public double nextValue() {
            public int docValueCount() {  
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);  
        assertThat(MultiValueMode.fromString("avg"), equalTo(MultiValueMode.AVG));
                int actual = -1;
            new BitSetIterator(innerDocs, 0L),
    private void verifySortedSet(Supplier<SortedSetDocValues> supplier, int maxDoc) throws IOException {
        int maxDoc,  
        final int numDocs = scaledRandomIntBetween(1, 100);
                    verifyLongValueCanCalledMoreThanOnce(selected, actual);  
                        } else if (mode == MultiValueMode.MAX) {  
        final FixedBitSet rootDocs = new FixedBitSet(numDocs);  
                    final long actual = selected.longValue();  
        T get() throws IOException;  
        final SortedNumericDocValues values = DocValues.singleton(new AbstractNumericDocValues() {
                    rootDocs,
        // parents at doc 1 and 3; children at doc 0 and 2.  
        rootDocs.set(3);
                            expected = Numbers.toUnsignedBigInteger(expected.longValue());
            }
                MultiValueMode.SUM,
        final SortedBinaryDocValues values = FieldData.singleton(new AbstractBinaryDocValues() {
                    assertTrue(selected.advanceExact(root));  
                    final long actual = selected.longValue();
                if (docsWithValue != null && randomBoolean()) {  
import org.opensearch.index.fielddata.SortedNumericUnsignedLongValues;
                }  
                        int value = numValues / 2;
        final SortedDocValues selected = MultiValueMode.MIN.select(values, rootDocs, new BitSetIterator(innerDocs, 0L), Integer.MAX_VALUE);
        for (int i = 0; i < numDocs; ++i) {  
                        if (numValues % 2 == 0) {
                                } else if (mode == MultiValueMode.MAX) {
                                } else {
                for (int child = innerDocs.nextSetBit(prevRoot + 1); child != -1 && child < root; child = innerDocs.nextSetBit(child + 1)) {
        int maxChildren  
                                }
                for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
    private void verifyBinaryValueCanCalledMoreThanOnce(BinaryDocValues values, BytesRef expected) throws IOException {
    ) throws IOException {  
    }  
                        expected = Long.MAX_VALUE;
                    assertEquals(mode.toString() + " docId=" + root, expectedLong, actual);
                        }
        assertEquals(1, selected.docID());  
                    if (mode == MultiValueMode.AVG) {  
    ) throws IOException {
                    docsWithValue.set(i);
            }
        );
                        expectedLong = expected.longValue();  
                return new BytesRef(Long.toString(ord));  
                    int numValues = 0;  
                array[i] = randomDouble();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        final int numDocs = 8;
        });  
        final double[][] array = new double[numDocs][];  
        }
                    assertEquals(mode.toString() + " docId=" + root, expected, actual);
                return docId;
            Arrays.sort(values);
            @Override  
            }  
    public void testMultiValuedDoubles() throws Exception {
            array[i] = values;  
    }
                return array[doc].length > 0;  
                return docId;  
                                ++numValues;  
 * the Apache License, Version 2.0 (the "License"); you may
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
                                expected = (int) ord;  
                this.docId = target;
        };
            }
            }
                return array[docId];
                }
        int maxDoc,
            @Override  
                }
            if (randomBoolean()) {  
import org.opensearch.test.OpenSearchTestCase;  
            MultiValueMode.MIN.writeTo(out);
            }
                values[j] = randomUnsignedLong().longValue();  
    }  
                            }  
                return array[doc].length;
            array[i] = values;  
                            }
    public void testSingleValuedOrds() throws Exception {  
            array[i] = values;  
                        if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
            }  
        for (int i = 0; i < numDocs; ++i) {
 * You may obtain a copy of the License at  
                throw new UnsupportedOperationException();  
        Supplier<SortedBinaryDocValues> supplier,
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            Arrays.sort(values);
            try (StreamInput in = out.bytes().streamInput()) {
        assertEquals(5, selected.advance(2));
            int doc;
    public void testMultiValuedUnsignedLongs() throws Exception {  
            }
                    if (mode == MultiValueMode.AVG) {
    private void verifySortedNumeric(Supplier<SortedNumericDocValues> supplier, int maxDoc) throws IOException {  
                    int numValues = 0;
        rootDocs.set(3);
                    assertTrue(selected.advanceExact(root));  
import org.apache.lucene.search.DocIdSetIterator;
                for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
        final int numDocs = scaledRandomIntBetween(1, 100);
            0L,  
                this.docId = target;
                        }  
    }  
                MultiValueMode.MIN,  
            @Override  
    public void testSingleValuedLongs() throws Exception {
                        int value = numValues / 2;  
                docID = target;
        });
                    verifyOrdValueCanCalledMoreThanOnce(selected, actual);
        innerDocs.set(0);
            values,  
                return array[docID];
        assertEquals(5, selected.docID());
        assertThat(MultiValueMode.fromString("min"), equalTo(MultiValueMode.MIN));  
                            for (int j = 0; j < values.docValueCount(); ++j) {
                            expected = Numbers.toUnsignedBigInteger(docValues[value - 1])
            public int docID() {  
            @Override  
            @Override
                        }
                        } else {
        }
                assertThat(in.readVInt(), equalTo(2));  
        array[4] = new long[] { 1 };
                    prevRoot = root;  
        final FixedBitSet innerDocs = new FixedBitSet(numDocs);
                                BytesRef value = values.nextValue();  
                }
            MultiValueMode.SUM.writeTo(out);
            @Override  
            int i;
        final int numDocs = scaledRandomIntBetween(1, 100);
                        final Long[] docValues = new Long[numValues];
        assertThat(MultiValueMode.MAX.ordinal(), equalTo(4));  
                                }
/*  
                for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
                        expected = numValues > 1  
                if (selected.advanceExact(root)) {
            @Override  
            }
 * software distributed under the License is distributed on an
                    for (int j = 0; j < numValues; ++j) {  
                    final BytesRef actual = selected.binaryValue();  
                docsWithValue.set(i);  
        final int numDocs = 4;
            try (StreamInput in = out.bytes().streamInput()) {
                                if (mode == MultiValueMode.MIN) {
                        if (values.advanceExact(child)) {  
        verifySortedSet(multiValues, numDocs);
/*
        verifySortedNumeric(multiValues, numDocs, rootDocs, innerDocs, randomIntBetween(1, numDocs));  
        FixedBitSet rootDocs,  
        verifySortedSet(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
        final NumericDoubleValues selected = MultiValueMode.MIN.select(  
 */  
            int docID;
            array[i] = values;
                this.doc = docID;
        final long[] array = new long[] { 10, 20, 30, 40 };
        assertEquals(new BytesRef("a"), selected.binaryValue());
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));
            if (randomBoolean()) {
                    missingValue,  
                }
        verifySortedUnsignedLong(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
    private void verifySortedUnsignedLong(  
                            }
                                    expected = expected.min(Numbers.toUnsignedBigInteger(values.nextValue()));
        // Parent 1 has an ord: advance() lands directly on the target.  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            @Override
        for (long missingValue : new long[] { 0, randomUnsignedLong().longValue() }) {
            if (!rootDocs.get(i) && randomBoolean()) {  
                                if (mode == MultiValueMode.SUM || mode == MultiValueMode.AVG) {
            public boolean advanceExact(int docID) {
        }
        }  
        assertEquals(1, selected.advance(0));
            for (MultiValueMode mode : new MultiValueMode[] {
                return array[doc][i++];  
        verifySortedNumeric(multiValues, numDocs, rootDocs, innerDocs, Integer.MAX_VALUE);
        final long[] array = new long[numDocs];
            }
    private void verifySortedSet(
        assertThat(MultiValueMode.AVG.ordinal(), equalTo(1));  
                        expectedLong = expected.longValue();
                    final long expectedLong;
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;  
                    )) {
    public void testMultiValuedOrds() throws Exception {
                    if (mode == MultiValueMode.MAX) {  
                return 1;
                    } else {
            int doc;  
        }  
            try (StreamInput in = out.bytes().streamInput()) {  
                    if (mode == MultiValueMode.MAX) {
                        expected = numValues > 1  
            for (int j = 0; j < values.length; ++j) {
import org.opensearch.common.Numbers;
                                } else if (mode == MultiValueMode.MIN) {  
                array[i] = -1;
                return array[doc].length > 0;
                        int numValues = values.docValueCount();
                innerDocs.set(i);
        for (int i = 0; i < array.length; ++i) {  
        Supplier<SortedNumericDoubleValues> supplier,
            }  
        assertEquals(3, selected.advance(3));
        }  
                                if (expected == null) {
        for (MultiValueMode mode : new MultiValueMode[] { MultiValueMode.MIN, MultiValueMode.MAX }) {
import org.apache.lucene.index.SortedSetDocValues;  
        assertEquals(3, selected.docID());
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);
        verifySortedBinary(multiValues, numDocs);
            int docID;
                    if (values.advanceExact(child)) {  
            }
                        child + 1
                for (int root = rootDocs.nextSetBit(0); root != -1; root = root + 1 < maxDoc ? rootDocs.nextSetBit(root + 1) : -1) {
    // test exercises advance() on the nested long/date select; it throws UOE without the fix.
                        if (expected == null) {
        final Supplier<SortedNumericDocValues> multiValues = () -> DocValues.singleton(new AbstractNumericDocValues() {
                        } else if (mode == MultiValueMode.MIN) {
            }
        }
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, selected.advance(numDocs));  
                    long expected = 0;  
    ) throws IOException {
        });
                if (selected.advanceExact(i)) {
 * ownership. Elasticsearch licenses this file to you under  
                return true;
                BigInteger expected = null;  
        final Supplier<SortedSetDocValues> multiValues = () -> DocValues.singleton(new AbstractSortedDocValues() {
        final int numDocs = scaledRandomIntBetween(1, 100);
            assertTrue(Double.compare(values.doubleValue(), expected) == 0);
                        }
            }
                            }  
    }
    private void verifySortedNumericDouble(  
        });
    public void testNestedSelectSupportsAdvance() throws Exception {
                return array[docID] != -1;
                    missingValue,
            if (randomBoolean()) {
            public boolean advanceExact(int target) throws IOException {  
            @Override
        assertEquals(3, selected.advance(3));
            } else if (docsWithValue != null && randomBoolean()) {
            }
                                    expected = expected.add(Numbers.toUnsignedBigInteger(values.nextValue()));  
                int prevRoot = -1;
        final FixedBitSet rootDocs = randomRootDocs(numDocs);  
                            docValues[j] = values.nextValue();  
                int prevRoot = -1;
    ) throws IOException {
            0L,
        rootDocs.set(3);  
            int i;  
            for (int i = 0; i < maxDoc; ++i) {  
        final long[][] array = new long[numDocs][];
                        int docValueCount = 0;
        final FixedBitSet rootDocs = randomRootDocs(numDocs);
        }
                return array[doc][i++];
        final FixedBitSet innerDocs = randomInnerDocs(rootDocs);  
                        }
        // UnsupportedOperationException from the base AbstractNumericDocValues. Per the contract here,
                            } else {
        }
            Integer.MAX_VALUE
            @Override  
                            if (mode == MultiValueMode.MIN) {
                return docsWithValue == null || docsWithValue.get(doc);
                                    expected = expected.compareTo(value) <= 0 ? expected : BytesRef.deepCopyOf(value);
            @Override  
                    } else if (mode == MultiValueMode.MIN) {
                        Arrays.sort(docValues, Long::compareUnsigned);
            } else if (docsWithValue != null && randomBoolean()) {  
                            if (expected == null) {  
            SortedNumericUnsignedLongValues values = supplier.get();  
                            expected = values.nextValue();
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(3, selected.docID());  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.search;
                return array[doc].length;
                    maxDoc,  
                        } else if (mode == MultiValueMode.MAX) {
            @Override
                return docId;  
        final Supplier<SortedBinaryDocValues> multiValues = () -> new SortedBinaryDocValues() {
