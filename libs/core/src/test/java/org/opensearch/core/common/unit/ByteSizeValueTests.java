                break;  
        assertThat(e.getMessage(), containsString("failed to parse setting [test]"));
            String serialised = original.getStringRep();
        assertEquals(instance, ByteSizeValue.parseBytesSizeValue(instance.getStringRep(), null, "test"));
        long firstRandom = randomNonNegativeLong() / unit.toBytes(1);  
                } else {  
    public void testGetBytesAsInt() {  
        assertThat(ByteSizeValue.parseBytesSizeValue("1 b", "testParsing").toString(), is("1b"));
 * Licensed to Elasticsearch under one or more contributor  
    }
    }
        assertThat("1.5mb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.KB).toString()));
        );  
        assertEquals(0, firstByteValue.compareTo(secondByteValue));
        assertSerialization(instance);  
        assertThat(ByteSizeValue.parseBytesSizeValue("1B", "testParsing").toString(), is("1b"));
            containsString("could not convert [4 GB] to an int")  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    mutateSize = randomValueOtherThanMany(
        assertEquals(IllegalArgumentException.class, exception.getCause().getClass());  
    }  
        assertThat(ByteSizeValue.parseBytesSizeValue("42 p", "testParsing").toString(), is("42pb"));  
 *  
import static org.hamcrest.Matchers.is;
        assertThat(ByteSizeUnit.MB.toMB(10), is(new ByteSizeValue(10, ByteSizeUnit.MB).getMb()));
            case 1:
        assertThat(ByteSizeValue.parseBytesSizeValue("12 GB", "testParsing").toString(), is("12gb"));
 * Unless required by applicable law or agreed to in writing,
            expectThrows(AssertionError.class, () -> ByteSizeUnit.GB.toIntBytes(4)).getMessage(),
                final long unitBytes = instanceUnit.toBytes(1);
        ByteSizeUnit randomUnit = randomValueOtherThan(ByteSizeUnit.PB, () -> randomFrom(ByteSizeUnit.values()));
        }
 * this work for additional information regarding copyright
        assertEquals(instance, ByteSizeValue.parseBytesSizeValue(instance.getStringRep(), null, "test"));
    public void testFailOnUnknownUnits() {  
        assertThat(ByteSizeValue.parseBytesSizeValue("12 gb", "testParsing").toString(), is("12gb"));  
    public void testOutOfRange() {
            exception.getMessage()  
    }
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> new ByteSizeValue(size, unit));  
        switch (between(0, 1)) {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(ByteSizeUnit.KB.toKB(10), is(new ByteSizeValue(10, ByteSizeUnit.KB).getKb()));  
        assertThat(ByteSizeValue.parseBytesSizeValue("42pb", "testParsing").toString(), is("42pb"));  
        assertTrue(secondByteValue.compareTo(firstByteValue) > 0);
                mutateUnit = randomValueOtherThan(instanceUnit, () -> randomFrom(ByteSizeUnit.values()));  
    }
        );
        MatcherAssert.assertThat(new ByteSizeValue(4, ByteSizeUnit.GB).getBytes(), equalTo(4294967296L));
    }  
        );
 * The OpenSearch Contributors require contributions made to  
        );
    public void testSimple() {
    }
    }  
        for (int i = 0; i < NUMBER_OF_TEST_RUNS; i++) {
                }
        assertThat(ByteSizeValue.parseBytesSizeValue("23KB", "testParsing").toString(), is("23kb"));  
    @Override
            } else {
        ByteSizeValue firstByteValue = new ByteSizeValue(firstRandom, unit);
    @Override
                final long newUnitBytes = mutateUnit.toBytes(1);
import java.io.IOException;  
        long size2 = -1L;
                assertEquals("size [" + instance.toString() + "] is bigger than max int", exception.getMessage());  
    public void testNoDotsAllowed() {  
        assertThat(ByteSizeValue.parseBytesSizeValue("12m", "testParsing").toString(), is("12mb"));  
        Exception e = expectThrows(OpenSearchParseException.class, () -> ByteSizeValue.parseBytesSizeValue("23jw", "test"));
                 * need to randomize a new size. Additionally, if the size unit pair is such that the representation would be such that the
import static org.hamcrest.Matchers.containsString;
 * SPDX-License-Identifier: Apache-2.0
            () -> ByteSizeValue.parseBytesSizeValue(fractionalValue, "test")
                 * number of represented bytes would exceed Long.Max_VALUE, we have to randomize a new size too.
    protected ByteSizeValue createTestInstance() {
        );  
        assertThat(ByteSizeUnit.TB.toTB(10), is(new ByteSizeValue(10, ByteSizeUnit.TB).getTb()));  
        assertEquals(defaultValue, ByteSizeValue.parseBytesSizeValue(null, defaultValue, "test"));
        assertNotNull(exception.getCause());
        assertSerialization(instance);
        assertThat(e.getMessage(), containsString("failed to parse [g]"));  
        assertThat("10b", is(new ByteSizeValue(10, ByteSizeUnit.BYTES).toString()));  
            return new ByteSizeValue(size, unit);  
        assertThat(ByteSizeValue.parseBytesSizeValue("12 G", "testParsing").toString(), is("12gb"));  
            if (bytesValue > Integer.MAX_VALUE) {
            default:
 *
    }
            if (size > Long.MAX_VALUE / unit.toBytes(1)) {  
        Exception e = expectThrows(OpenSearchParseException.class, () -> ByteSizeValue.parseBytesSizeValue("42b.", null, "test"));
        assertThat(ByteSizeValue.parseBytesSizeValue("23k", "testParsing").toString(), is("23kb"));
        assertThat(ByteSizeValue.parseBytesSizeValue("42P", "testParsing").toString(), is("42pb"));  
    }
        assertThat(ByteSizeValue.parseBytesSizeValue("54 TB", "testParsing").toString(), is("54tb"));  
        OpenSearchParseException e = expectThrows(  
    }  
        assertThat(e.getMessage(), containsString("failed to parse setting [test]"));  
    public void testParseInvalidValue() {
        if (randomBoolean()) {  
 * software distributed under the License is distributed on an
        long secondRandom = randomValueOtherThan(firstRandom, () -> randomNonNegativeLong() / unit.toBytes(1));
                        v -> v == instanceSize && v >= Long.MAX_VALUE / newUnitBytes,  
        assertThat("1.5kb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.BYTES).toString()));
import org.hamcrest.MatcherAssert;
            long size = randomNonNegativeLong() / unit.toBytes(1);
        assertThat(
        );  
        ByteSizeUnit unit2 = randomValueOtherThan(ByteSizeUnit.BYTES, () -> randomFrom(ByteSizeUnit.values()));
        assertThat(ByteSizeUnit.KB.toIntBytes(4), equalTo(4096));  
                throw new AssertionError("Invalid randomisation branch");
        ByteSizeValue secondValue = new ByteSizeValue(firstValue.getBytes(), ByteSizeUnit.BYTES);  
        assertThat(ByteSizeValue.parseBytesSizeValue("42 P", "testParsing").toString(), is("42pb"));
            return new ByteSizeValue(randomNonNegativeLong());
/*  
        assertThat(ByteSizeValue.parseBytesSizeValue("12 M", "testParsing").toString(), is("12mb"));
        // Make sure a value of > Long.MAX_VALUE bytes throws an exception  
        Exception e = expectThrows(  
        ByteSizeValue value2 = ByteSizeValue.parseBytesSizeValue(randomFrom(equalValues), "equalTest");
    }
    protected ByteSizeValue mutateInstance(final ByteSizeValue instance) {  
        ByteSizeValue firstByteValue = new ByteSizeValue(firstRandom, randomUnit);
        long number = randomLongBetween(1, Long.MAX_VALUE / ByteSizeUnit.PB.toBytes(1));  
                throw new AssertionError();
        assertThat(value1, equalTo(value2));
        assertThat("1536pb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.PB).toString()));  
        assertThat(ByteSizeValue.parseBytesSizeValue("12g", "testParsing").toString(), is("12gb"));
        ByteSizeValue secondByteValue = new ByteSizeValue(firstRandom, randomUnit);  
            OpenSearchParseException.class,  
        String fractionalValue = "23.5" + unit.getSuffix();
        assertThat(ByteSizeValue.parseBytesSizeValue("23 K", "testParsing").toString(), is("23kb"));  
        assertThat(ByteSizeValue.parseBytesSizeValue("23 k", "testParsing").toString(), is("23kb"));
 */  
                /*
    public void testActualTera() {
                 */  
                mutateUnit = instanceUnit;  
            }  
    public void testFailOnEmptyParsing() {
                    mutateSize = instanceSize;
        ByteSizeValue instance = new ByteSizeValue(-1);  
                assertEquals((int) bytesValue, instance.bytesAsInt());
                    );
        );
            ByteSizeValue instance = new ByteSizeValue(randomIntBetween(1, 1000), randomFrom(ByteSizeUnit.values()));
        assertThat(ByteSizeValue.parseBytesSizeValue("54 T", "testParsing").toString(), is("54tb"));
 * compatible open source license.
        ByteSizeValue firstValue = new ByteSizeValue(randomIntBetween(0, Integer.MAX_VALUE), ByteSizeUnit.GB);
    }
 * KIND, either express or implied.  See the License for the
            "Values greater than " + Long.MAX_VALUE + " bytes are not supported: " + size + unit.getSuffix(),
    }
        assertThat(ByteSizeValue.parseBytesSizeValue("12 m", "testParsing").toString(), is("12mb"));
            OpenSearchParseException.class,
 */  
        assertThat(ByteSizeValue.parseBytesSizeValue("54 tb", "testParsing").toString(), is("54tb"));
    }  
        assertThat(ByteSizeValue.parseBytesSizeValue("12gb", "testParsing").toString(), is("12gb"));
        assertEquals(
            () -> assertThat(ByteSizeValue.parseBytesSizeValue("g", "emptyNumberParsing").toString(), is("23b"))
package org.opensearch.core.common.unit;
        assertThat(ByteSizeValue.parseBytesSizeValue("54TB", "testParsing").toString(), is("54tb"));
        // test exception is thrown: fractional byte size values has been deprecated since Legacy 6.2
        assertThat(ByteSizeValue.parseBytesSizeValue("23kb", "testParsing").toString(), is("23kb"));
        MatcherAssert.assertThat(new ByteSizeValue(4, ByteSizeUnit.TB).getBytes(), equalTo(4398046511104L));  
        assertThat(ByteSizeValue.parseBytesSizeValue("12 g", "testParsing").toString(), is("12gb"));
        }
    }
        }  
        MatcherAssert.assertThat(new ByteSizeValue(4, ByteSizeUnit.PB).getBytes(), equalTo(4503599627370496L));
    @Override  
    public void testEquality() {
        assertThat(ByteSizeValue.parseBytesSizeValue("54T", "testParsing").toString(), is("54tb"));
            ByteSizeValue original = createTestInstance();  
        assertThat(ByteSizeValue.parseBytesSizeValue("12G", "testParsing").toString(), is("12gb"));
    public void testToString() {
            assertEquals(serialised, copy.getStringRep());
        assertThat(ByteSizeValue.parseBytesSizeValue("23K", "testParsing").toString(), is("23kb"));
        final long mutateSize;  
        assertEquals(
                mutateSize = randomValueOtherThan(instanceSize, () -> randomNonNegativeLong() / unitBytes);
            exception.getMessage()
        exception = expectThrows(IllegalArgumentException.class, () -> new ByteSizeValue(size2, unit2));  
    public void testActualPeta() {
        assertThat(e.getMessage(), containsString("failed to parse setting [emptyParsing]"));
import org.opensearch.OpenSearchParseException;
        assertThat(ByteSizeValue.parseBytesSizeValue("12M", "testParsing").toString(), is("12mb"));
        ByteSizeUnit randomUnit = randomFrom(ByteSizeUnit.values());  
        ByteSizeUnit unit3 = randomFrom(ByteSizeUnit.values());
        assertEquals(firstValue.hashCode(), secondValue.hashCode());
        assertEquals("Values less than -1 bytes are not supported: " + size2 + unit2.getSuffix(), exception.getMessage());
        ByteSizeUnit unit = randomValueOtherThan(ByteSizeUnit.BYTES, () -> randomFrom(ByteSizeUnit.values()));
public class ByteSizeValueTests extends AbstractWireSerializingTestCase<ByteSizeValue> {  
    public void testParseDefaultValue() {  
        assertThat(ByteSizeValue.parseBytesSizeValue("1 B", "testParsing").toString(), is("1b"));
    public void testToIntBytes() {
    public void testFailOnEmptyNumberParsing() {
        final ByteSizeUnit mutateUnit;
 * license agreements. See the NOTICE file distributed with
    }
        OpenSearchParseException exception = expectThrows(
import static org.hamcrest.Matchers.equalTo;  
        assertThat(ByteSizeValue.parseBytesSizeValue("54tb", "testParsing").toString(), is("54tb"));
        exception = expectThrows(OpenSearchParseException.class, () -> ByteSizeValue.parseBytesSizeValue("notANumberMB", "test"));
    }
            ByteSizeUnit unit = randomFrom(ByteSizeUnit.values());
        return new ByteSizeValue(mutateSize, mutateUnit);
        assertThat(ByteSizeValue.parseBytesSizeValue("42p", "testParsing").toString(), is("42pb"));
        assertEquals("failed to parse setting [test_setting] with value [-6mb] as a size in bytes", exception.getMessage());
        String[] equalValues = new String[] { "1GB", "1024MB", "1048576KB", "1073741824B" };
        ByteSizeValue defaultValue = createTestInstance();
        ByteSizeUnit unit = randomFrom(ByteSizeUnit.values());
        ByteSizeValue secondByteValue = new ByteSizeValue(number, ByteSizeUnit.PB);  
        assertThat(ByteSizeValue.parseBytesSizeValue("12GB", "testParsing").toString(), is("12gb"));  
    public void testCompareUnits() {
    }
        assertEquals(secondRandom > firstRandom, secondByteValue.compareTo(firstByteValue) > 0);
 * specific language governing permissions and limitations
    public void testParsing() {  
/*
    }  
    public void testParseInvalidNumber() throws IOException {  
 */
        instance = new ByteSizeValue(0);
        Exception e = expectThrows(
 * You may obtain a copy of the License at  
        // Make sure for units other than BYTES a size of -1 throws an exception  
 * ownership. Elasticsearch licenses this file to you under  
                        () -> randomNonNegativeLong() / newUnitBytes
                 * If size is zero we can not reuse zero because zero with any unit will be equal to zero with any other unit so in this case we  
            OpenSearchParseException.class,
        assertThat(ByteSizeValue.parseBytesSizeValue("23 kb", "testParsing").toString(), is("23kb"));  
        assertEquals("Values less than -1 bytes are not supported: " + size3 + unit3.getSuffix(), exception.getMessage());
        assertThat(ByteSizeUnit.BYTES.toIntBytes(4), equalTo(4));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            OpenSearchParseException.class,
    }  
 * under the License.  
    public void testActual() {  
        assertThat(ByteSizeUnit.GB.toGB(10), is(new ByteSizeValue(10, ByteSizeUnit.GB).getGb()));
        assertThat(ByteSizeValue.parseBytesSizeValue("54 t", "testParsing").toString(), is("54tb"));
            case 0:  
        ByteSizeValue firstByteValue = new ByteSizeValue(number, randomUnit);
}  
    public void testParseSpecialValues() throws IOException {
        assertThat(ByteSizeValue.parseBytesSizeValue("23 KB", "testParsing").toString(), is("23kb"));
    protected Reader<ByteSizeValue> instanceReader() {
        final long instanceSize = instance.getSize();
import org.opensearch.test.AbstractWireSerializingTestCase;  
        }  
        assertThat(e.getMessage(), containsString("failed to parse setting [test]"));
        exception = expectThrows(IllegalArgumentException.class, () -> new ByteSizeValue(size3, unit3));  
    public void testCompareEquality() {
    }
        assertThat(ByteSizeUnit.PB.toPB(10), is(new ByteSizeValue(10, ByteSizeUnit.PB).getPb()));
        assertThat(ByteSizeValue.parseBytesSizeValue("1b", "testParsing").toString(), is("1b"));  
        assertThat("1.5tb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.GB).toString()));
        ByteSizeUnit unit = randomValueOtherThan(ByteSizeUnit.BYTES, () -> randomFrom(ByteSizeUnit.values()));  
        // Make sure for any unit a size < -1 throws an exception  
            }
    }
        assertThat(ByteSizeValue.parseBytesSizeValue("54t", "testParsing").toString(), is("54tb"));  
 *
        assertThat(ByteSizeValue.parseBytesSizeValue("42 PB", "testParsing").toString(), is("42pb"));
            ByteSizeValue copy = ByteSizeValue.parseBytesSizeValue(serialised, "test");
        assertThat("1.5gb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.MB).toString()));  
/*  
    public void testParseFractionalNumber() throws IOException {
        long size = (long) randomDouble() * unit.toBytes(1) + (Long.MAX_VALUE - unit.toBytes(1));
        assertThat("1.5pb", is(new ByteSizeValue((long) (1024 * 1.5), ByteSizeUnit.TB).toString()));
            OpenSearchParseException.class,
                break;
        Exception e = expectThrows(OpenSearchParseException.class, () -> ByteSizeValue.parseBytesSizeValue("23", "test"));
            () -> ByteSizeValue.parseBytesSizeValue("-6mb", "test_setting")
 * GitHub history for details.
    }
    }  
            assertEquals(original, copy);  
        long size3 = -1L * randomNonNegativeLong() - 1L;
        assertThat(ByteSizeValue.parseBytesSizeValue("42PB", "testParsing").toString(), is("42pb"));
    public void testConversionHashCode() {
    }
import org.opensearch.core.common.io.stream.Writeable.Reader;
 * the Apache License, Version 2.0 (the "License"); you may
        long firstRandom = randomNonNegativeLong() / randomUnit.toBytes(1);
    }  
 * this file be licensed under the Apache-2.0 license or a
    }  
        assertTrue(firstByteValue.compareTo(secondByteValue) < 0);
            "failed to parse setting [test] with value [notANumber] as a size in bytes: unit is missing or unrecognized",  
        for (int i = 0; i < NUMBER_OF_TEST_RUNS; i++) {
        assertThat(ByteSizeValue.parseBytesSizeValue("42 pb", "testParsing").toString(), is("42pb"));
    public void testCompareValue() {
        assertEquals("failed to parse [notANumberMB]", exception.getMessage());
        ByteSizeValue value1 = ByteSizeValue.parseBytesSizeValue(randomFrom(equalValues), "equalTest");  
                IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> instance.bytesAsInt());
                if (instanceSize == 0 || instanceSize >= Long.MAX_VALUE / newUnitBytes) {
            () -> assertThat(ByteSizeValue.parseBytesSizeValue("", "emptyParsing").toString(), is("23kb"))
    public void testParse() {
            long bytesValue = instance.getBytes();  
        OpenSearchParseException exception = expectThrows(  
        } else {
            () -> ByteSizeValue.parseBytesSizeValue("notANumber", "test")  
        final ByteSizeUnit instanceUnit = instance.getUnit();
        return ByteSizeValue::new;
    public void testFailOnMissingUnits() {
        assertThat(ByteSizeUnit.BYTES.toBytes(10), is(new ByteSizeValue(10, ByteSizeUnit.BYTES).getBytes()));
        assertEquals(firstRandom > secondRandom, firstByteValue.compareTo(secondByteValue) > 0);
 * not use this file except in compliance with the License.
        ByteSizeValue secondByteValue = new ByteSizeValue(secondRandom, unit);  
        );
