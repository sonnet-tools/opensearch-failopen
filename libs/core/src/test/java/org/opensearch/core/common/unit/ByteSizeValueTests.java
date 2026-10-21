        assertThat(e.getMessage(), containsString("failed to parse setting [test]"));
        assertEquals(firstRandom > secondRandom, firstByteValue.compareTo(secondByteValue) > 0);
 */
        assertThat(ByteSizeValue.parseBytesSizeValue("12M", "testParsing").toString(), is("12mb"));
        ByteSizeValue instance = new ByteSizeValue(-1);
        assertNotNull(exception.getCause());
    public void testCompareEquality() {
 * license agreements. See the NOTICE file distributed with
    public void testActual() {
import org.hamcrest.MatcherAssert;
            () -> ByteSizeValue.parseBytesSizeValue("-6mb", "test_setting")
        long size = (long) randomDouble() * unit.toBytes(1) + (Long.MAX_VALUE - unit.toBytes(1));
                throw new AssertionError("Invalid randomisation branch");
    protected ByteSizeValue createTestInstance() {
        if (randomBoolean()) {
            if (size > Long.MAX_VALUE / unit.toBytes(1)) {
        assertThat(ByteSizeValue.parseBytesSizeValue("54 TB", "testParsing").toString(), is("54tb"));
        assertThat(ByteSizeValue.parseBytesSizeValue("54 tb", "testParsing").toString(), is("54tb"));
            } else {
            ByteSizeValue original = createTestInstance();
        return new ByteSizeValue(mutateSize, mutateUnit);
            "Values greater than " + Long.MAX_VALUE + " bytes are not supported: " + size + unit.getSuffix(),
        assertThat(ByteSizeValue.parseBytesSizeValue("42 PB", "testParsing").toString(), is("42pb"));
        long size2 = -1L;
            exception.getMessage()
        assertThat(ByteSizeValue.parseBytesSizeValue("23K", "testParsing").toString(), is("23kb"));
        assertEquals(defaultValue, ByteSizeValue.parseBytesSizeValue(null, defaultValue, "test"));
    public void testParseFractionalNumber() throws IOException {
            assertEquals(original, copy);
        );
    }
    }
        long number = randomLongBetween(1, Long.MAX_VALUE / ByteSizeUnit.PB.toBytes(1));
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testParseSpecialValues() throws IOException {
        assertEquals("failed to parse setting [test_setting] with value [-6mb] as a size in bytes", exception.getMessage());
        );
        assertThat(ByteSizeValue.parseBytesSizeValue("42PB", "testParsing").toString(), is("42pb"));
        assertThat(ByteSizeUnit.PB.toPB(10), is(new ByteSizeValue(10, ByteSizeUnit.PB).getPb()));
    public void testParseInvalidNumber() throws IOException {
            OpenSearchParseException.class,
        ByteSizeUnit unit = randomFrom(ByteSizeUnit.values());
    }
            OpenSearchParseException.class,
        assertThat(ByteSizeValue.parseBytesSizeValue("54T", "testParsing").toString(), is("54tb"));
 */
            () -> ByteSizeValue.parseBytesSizeValue("notANumber", "test")
        assertThat(e.getMessage(), containsString("failed to parse [g]"));
        final ByteSizeUnit instanceUnit = instance.getUnit();
    public void testOutOfRange() {
}
                 * need to randomize a new size. Additionally, if the size unit pair is such that the representation would be such that the
        long secondRandom = randomValueOtherThan(firstRandom, () -> randomNonNegativeLong() / unit.toBytes(1));
        switch (between(0, 1)) {
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
    }
        ByteSizeValue firstByteValue = new ByteSizeValue(firstRandom, randomUnit);
import org.opensearch.core.common.io.stream.Writeable.Reader;
    public void testParseInvalidValue() {
    }
            default:
        assertThat("1.5tb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.GB).toString()));
        exception = expectThrows(IllegalArgumentException.class, () -> new ByteSizeValue(size3, unit3));
        instance = new ByteSizeValue(0);
        ByteSizeValue firstByteValue = new ByteSizeValue(firstRandom, unit);
        assertThat(ByteSizeValue.parseBytesSizeValue("12 g", "testParsing").toString(), is("12gb"));
        ByteSizeUnit unit3 = randomFrom(ByteSizeUnit.values());
        final ByteSizeUnit mutateUnit;
        assertThat(ByteSizeValue.parseBytesSizeValue("54t", "testParsing").toString(), is("54tb"));
    public void testParseDefaultValue() {
        assertSerialization(instance);
        );
public class ByteSizeValueTests extends AbstractWireSerializingTestCase<ByteSizeValue> {
        ByteSizeUnit unit2 = randomValueOtherThan(ByteSizeUnit.BYTES, () -> randomFrom(ByteSizeUnit.values()));
        assertEquals(firstValue.hashCode(), secondValue.hashCode());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> new ByteSizeValue(size, unit));
        ByteSizeUnit unit = randomValueOtherThan(ByteSizeUnit.BYTES, () -> randomFrom(ByteSizeUnit.values()));
            exception.getMessage()
        assertThat(ByteSizeValue.parseBytesSizeValue("12m", "testParsing").toString(), is("12mb"));
    }
        assertThat(ByteSizeValue.parseBytesSizeValue("42 P", "testParsing").toString(), is("42pb"));
                mutateUnit = randomValueOtherThan(instanceUnit, () -> randomFrom(ByteSizeUnit.values()));
    }
        assertThat(ByteSizeUnit.MB.toMB(10), is(new ByteSizeValue(10, ByteSizeUnit.MB).getMb()));
        String fractionalValue = "23.5" + unit.getSuffix();
        ByteSizeUnit randomUnit = randomValueOtherThan(ByteSizeUnit.PB, () -> randomFrom(ByteSizeUnit.values()));
            assertEquals(serialised, copy.getStringRep());
            if (bytesValue > Integer.MAX_VALUE) {
        ByteSizeUnit randomUnit = randomFrom(ByteSizeUnit.values());
                        v -> v == instanceSize && v >= Long.MAX_VALUE / newUnitBytes,
    }
/*
            long bytesValue = instance.getBytes();
        OpenSearchParseException e = expectThrows(
    public void testSimple() {
            case 0:
                assertEquals((int) bytesValue, instance.bytesAsInt());
        );
                    mutateSize = randomValueOtherThanMany(
        assertThat("1.5gb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.MB).toString()));
        final long instanceSize = instance.getSize();
        assertThat(ByteSizeValue.parseBytesSizeValue("42 pb", "testParsing").toString(), is("42pb"));
        assertThat(ByteSizeUnit.TB.toTB(10), is(new ByteSizeValue(10, ByteSizeUnit.TB).getTb()));
        assertThat("1.5mb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.KB).toString()));
        MatcherAssert.assertThat(new ByteSizeValue(4, ByteSizeUnit.PB).getBytes(), equalTo(4503599627370496L));
    }
 * GitHub history for details.
 * software distributed under the License is distributed on an
        assertEquals(instance, ByteSizeValue.parseBytesSizeValue(instance.getStringRep(), null, "test"));
    }
        // test exception is thrown: fractional byte size values has been deprecated since Legacy 6.2
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        exception = expectThrows(IllegalArgumentException.class, () -> new ByteSizeValue(size2, unit2));
            return new ByteSizeValue(randomNonNegativeLong());
        exception = expectThrows(OpenSearchParseException.class, () -> ByteSizeValue.parseBytesSizeValue("notANumberMB", "test"));
    }
                mutateSize = randomValueOtherThan(instanceSize, () -> randomNonNegativeLong() / unitBytes);
 */
                break;
            expectThrows(AssertionError.class, () -> ByteSizeUnit.GB.toIntBytes(4)).getMessage(),
        OpenSearchParseException exception = expectThrows(
    protected Reader<ByteSizeValue> instanceReader() {
        MatcherAssert.assertThat(new ByteSizeValue(4, ByteSizeUnit.GB).getBytes(), equalTo(4294967296L));
        }
                }
        long firstRandom = randomNonNegativeLong() / unit.toBytes(1);
    public void testFailOnMissingUnits() {
        assertEquals(IllegalArgumentException.class, exception.getCause().getClass());
        OpenSearchParseException exception = expectThrows(
    protected ByteSizeValue mutateInstance(final ByteSizeValue instance) {
        assertThat("10b", is(new ByteSizeValue(10, ByteSizeUnit.BYTES).toString()));
    public void testNoDotsAllowed() {
        Exception e = expectThrows(
        assertSerialization(instance);
        }
        Exception e = expectThrows(OpenSearchParseException.class, () -> ByteSizeValue.parseBytesSizeValue("42b.", null, "test"));
            ByteSizeValue copy = ByteSizeValue.parseBytesSizeValue(serialised, "test");
        assertThat(ByteSizeValue.parseBytesSizeValue("23 K", "testParsing").toString(), is("23kb"));
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
        ByteSizeValue secondByteValue = new ByteSizeValue(number, ByteSizeUnit.PB);
                final long unitBytes = instanceUnit.toBytes(1);
    public void testParsing() {
            return new ByteSizeValue(size, unit);
        ByteSizeValue firstValue = new ByteSizeValue(randomIntBetween(0, Integer.MAX_VALUE), ByteSizeUnit.GB);
                 * number of represented bytes would exceed Long.Max_VALUE, we have to randomize a new size too.
                break;
/*
 *
import org.opensearch.OpenSearchParseException;
        // Make sure for units other than BYTES a size of -1 throws an exception
 * You may obtain a copy of the License at
    }
    }
        Exception e = expectThrows(OpenSearchParseException.class, () -> ByteSizeValue.parseBytesSizeValue("23jw", "test"));
        assertThat(ByteSizeUnit.BYTES.toIntBytes(4), equalTo(4));
        assertThat("1.5pb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.TB).toString()));
 * this work for additional information regarding copyright
        assertEquals(
        ByteSizeValue value1 = ByteSizeValue.parseBytesSizeValue(randomFrom(equalValues), "equalTest");
            ByteSizeUnit unit = randomFrom(ByteSizeUnit.values());
        assertThat(ByteSizeValue.parseBytesSizeValue("23 kb", "testParsing").toString(), is("23kb"));
    }
        assertThat(ByteSizeValue.parseBytesSizeValue("12g", "testParsing").toString(), is("12gb"));
        assertEquals("Values less than -1 bytes are not supported: " + size2 + unit2.getSuffix(), exception.getMessage());
                final long newUnitBytes = mutateUnit.toBytes(1);
        assertThat(ByteSizeUnit.BYTES.toBytes(10), is(new ByteSizeValue(10, ByteSizeUnit.BYTES).getBytes()));
        ByteSizeValue firstByteValue = new ByteSizeValue(number, randomUnit);
            containsString("could not convert [4 GB] to an int")
            OpenSearchParseException.class,
            () -> ByteSizeValue.parseBytesSizeValue(fractionalValue, "test")
    public void testCompareValue() {
        );
        assertThat(ByteSizeValue.parseBytesSizeValue("12 M", "testParsing").toString(), is("12mb"));
        assertThat(ByteSizeValue.parseBytesSizeValue("1B", "testParsing").toString(), is("1b"));
    }
    public void testActualPeta() {
import static org.hamcrest.Matchers.is;
        assertThat(ByteSizeValue.parseBytesSizeValue("1b", "testParsing").toString(), is("1b"));
    }
        assertThat(ByteSizeValue.parseBytesSizeValue("42P", "testParsing").toString(), is("42pb"));
        } else {
 *
        assertThat(ByteSizeValue.parseBytesSizeValue("12 GB", "testParsing").toString(), is("12gb"));
 * Unless required by applicable law or agreed to in writing,
    }
    public void testFailOnUnknownUnits() {
        assertThat(ByteSizeValue.parseBytesSizeValue("54tb", "testParsing").toString(), is("54tb"));
    }
            ByteSizeValue instance = new ByteSizeValue(randomIntBetween(1, 1000), randomFrom(ByteSizeUnit.values()));
        assertThat(e.getMessage(), containsString("failed to parse setting [test]"));
        assertTrue(secondByteValue.compareTo(firstByteValue) > 0);
        for (int i = 0; i < NUMBER_OF_TEST_RUNS; i++) {
        assertThat(ByteSizeValue.parseBytesSizeValue("1 b", "testParsing").toString(), is("1b"));
    }
    public void testFailOnEmptyParsing() {
    @Override
        assertThat(ByteSizeValue.parseBytesSizeValue("42pb", "testParsing").toString(), is("42pb"));
        ByteSizeValue secondByteValue = new ByteSizeValue(secondRandom, unit);
    public void testCompareUnits() {
        );
        }
            }
    public void testConversionHashCode() {
 * this file be licensed under the Apache-2.0 license or a
        final long mutateSize;
                } else {
    @Override
        MatcherAssert.assertThat(new ByteSizeValue(4, ByteSizeUnit.TB).getBytes(), equalTo(4398046511104L));
    }
        assertThat(ByteSizeValue.parseBytesSizeValue("42p", "testParsing").toString(), is("42pb"));
        assertTrue(firstByteValue.compareTo(secondByteValue) < 0);
        assertThat(ByteSizeValue.parseBytesSizeValue("54TB", "testParsing").toString(), is("54tb"));
            () -> assertThat(ByteSizeValue.parseBytesSizeValue("g", "emptyNumberParsing").toString(), is("23b"))
    }
            case 1:
    public void testGetBytesAsInt() {
    }
        ByteSizeValue value2 = ByteSizeValue.parseBytesSizeValue(randomFrom(equalValues), "equalTest");
        assertThat(e.getMessage(), containsString("failed to parse setting [test]"));
    public void testToIntBytes() {
        assertThat(ByteSizeValue.parseBytesSizeValue("12GB", "testParsing").toString(), is("12gb"));
                assertEquals("size [" + instance.toString() + "] is bigger than max int", exception.getMessage());
 *
        assertThat(ByteSizeValue.parseBytesSizeValue("23k", "testParsing").toString(), is("23kb"));
        Exception e = expectThrows(OpenSearchParseException.class, () -> ByteSizeValue.parseBytesSizeValue("23", "test"));
        assertEquals(0, firstByteValue.compareTo(secondByteValue));
    public void testActualTera() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
        for (int i = 0; i < NUMBER_OF_TEST_RUNS; i++) {
        assertThat(ByteSizeValue.parseBytesSizeValue("12 m", "testParsing").toString(), is("12mb"));
        }
            OpenSearchParseException.class,
import static org.hamcrest.Matchers.equalTo;
        // Make sure a value of > Long.MAX_VALUE bytes throws an exception
        assertThat("1536pb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.PB).toString()));
        assertEquals("Values less than -1 bytes are not supported: " + size3 + unit3.getSuffix(), exception.getMessage());
    public void testToString() {
                if (instanceSize == 0 || instanceSize >= Long.MAX_VALUE / newUnitBytes) {
            long size = randomNonNegativeLong() / unit.toBytes(1);
            "failed to parse setting [test] with value [notANumber] as a size in bytes: unit is missing or unrecognized",
        assertEquals(instance, ByteSizeValue.parseBytesSizeValue(instance.getStringRep(), null, "test"));
        Exception e = expectThrows(
        assertThat("1.5kb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.BYTES).toString()));
        assertThat(ByteSizeValue.parseBytesSizeValue("1 B", "testParsing").toString(), is("1b"));
        ByteSizeUnit unit = randomValueOtherThan(ByteSizeUnit.BYTES, () -> randomFrom(ByteSizeUnit.values()));
        assertThat(ByteSizeUnit.KB.toKB(10), is(new ByteSizeValue(10, ByteSizeUnit.KB).getKb()));
                        () -> randomNonNegativeLong() / newUnitBytes
            OpenSearchParseException.class,
                throw new AssertionError();
        assertThat(ByteSizeValue.parseBytesSizeValue("42 p", "testParsing").toString(), is("42pb"));
        assertThat(e.getMessage(), containsString("failed to parse setting [emptyParsing]"));
        String[] equalValues = new String[] { "1GB", "1024MB", "1048576KB", "1073741824B" };
        assertThat(ByteSizeValue.parseBytesSizeValue("23KB", "testParsing").toString(), is("23kb"));
 * the Apache License, Version 2.0 (the "License"); you may
        );
    }
        assertThat(ByteSizeValue.parseBytesSizeValue("12gb", "testParsing").toString(), is("12gb"));
        assertThat(ByteSizeValue.parseBytesSizeValue("54 t", "testParsing").toString(), is("54tb"));
 * The OpenSearch Contributors require contributions made to
        assertThat(ByteSizeValue.parseBytesSizeValue("12 gb", "testParsing").toString(), is("12gb"));
 * compatible open source license.
        assertThat(ByteSizeValue.parseBytesSizeValue("23 k", "testParsing").toString(), is("23kb"));
 * Modifications Copyright OpenSearch Contributors. See
                mutateUnit = instanceUnit;
    public void testParse() {
        assertEquals(
        assertThat(ByteSizeValue.parseBytesSizeValue("23kb", "testParsing").toString(), is("23kb"));
                /*
        assertThat(
        assertThat(ByteSizeUnit.GB.toGB(10), is(new ByteSizeValue(10, ByteSizeUnit.GB).getGb()));
    }
        assertThat(value1, equalTo(value2));
    public void testEquality() {
        long firstRandom = randomNonNegativeLong() / randomUnit.toBytes(1);
        ByteSizeValue secondValue = new ByteSizeValue(firstValue.getBytes(), ByteSizeUnit.BYTES);
        assertThat(ByteSizeValue.parseBytesSizeValue("12 G", "testParsing").toString(), is("12gb"));
                    );
        long size3 = -1L * randomNonNegativeLong() - 1L;
    }
            () -> assertThat(ByteSizeValue.parseBytesSizeValue("", "emptyParsing").toString(), is("23kb"))
                IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> instance.bytesAsInt());
                 */
 * not use this file except in compliance with the License.
        return ByteSizeValue::new;
        assertThat(ByteSizeValue.parseBytesSizeValue("23 KB", "testParsing").toString(), is("23kb"));
import org.opensearch.test.AbstractWireSerializingTestCase;
        ByteSizeValue secondByteValue = new ByteSizeValue(firstRandom, randomUnit);
 * KIND, either express or implied.  See the License for the
            }
        );
    }
                 * If size is zero we can not reuse zero because zero with any unit will be equal to zero with any other unit so in this case we
        assertEquals(secondRandom > firstRandom, secondByteValue.compareTo(firstByteValue) > 0);
        assertEquals("failed to parse [notANumberMB]", exception.getMessage());
    @Override
        assertThat(ByteSizeValue.parseBytesSizeValue("54 T", "testParsing").toString(), is("54tb"));
            String serialised = original.getStringRep();
        assertThat(ByteSizeUnit.KB.toIntBytes(4), equalTo(4096));
    public void testFailOnEmptyNumberParsing() {
        // Make sure for any unit a size < -1 throws an exception
        assertThat(ByteSizeValue.parseBytesSizeValue("12G", "testParsing").toString(), is("12gb"));
        ByteSizeValue defaultValue = createTestInstance();
                    mutateSize = instanceSize;
import static org.hamcrest.Matchers.containsString;
    }
package org.opensearch.core.common.unit;
