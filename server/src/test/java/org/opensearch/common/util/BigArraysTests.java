            this.arrayAllocator = arrayAllocator;
 * Licensed to Elasticsearch under one or more contributor
    public void init() {
            : randomIntBetween(fromIndex, len); // likely multiple pages
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
        array2.close();
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
                Settings.builder()
 * software distributed under the License is distributed on an
    public void testByteArrayBulkSet() {
        }
        long[] ref = new long[totalLen];
        IntArray array = bigArrays.newIntArray(startLen, randomBoolean());
        }
        array2.close();
        for (int i = 0; i < totalLen; ++i) {
        );
            ref[i] = randomFrom(pool);
        }
    public void testFloatArrayFill() {
 * compatible open source license.
 *
            ref[i] = randomByte();
        final double[] array1 = new double[len];
                    .build(),
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        final ByteArray a4 = byteArrayWithBytes(new byte[] { 1, 1, 3 });
import org.opensearch.core.common.unit.ByteSizeUnit;
            array.set(i, ref[i]);
 * SPDX-License-Identifier: Apache-2.0
                long newSize = array.size() * 2;
        assertTrue(bigArrays.equals(empty1, empty2));
        final long[] array1 = new long[len];
import static org.opensearch.indices.breaker.HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING;
            BigArray array = (BigArray) create.invoke(bigArrays, size);
        if (size >= pageSize) {
        final BigArrays floatBigArrays = newBigArraysInstance(maxSize, withBreaking);
    public void testOverSizeUsesMinPageCount() {
    }
    }
        final double rand = randomDouble();
        // not equal: contents differ
            assertEquals(bigArraysHelper.ramEstimator.apply(size).longValue(), bigArray.ramBytesUsed());
        DoubleArray array = bigArrays.newDoubleArray(startLen, randomBoolean());
        for (int i = 0; i < array1.length;) {
            final int len = randomInt(Math.min(randomBoolean() ? 10 : Integer.MAX_VALUE, array1.length - offset));
        ByteArray array = bigArrays.newByteArray(startLen, randomBoolean());
import java.util.Arrays;
import java.util.Collections;
        final int toIndex = randomBoolean()
        for (int i = 0; i < len; ++i) {
            assertEquals(ref[i], array.get(i), 0.001d);
        }
        // identity = equality
        final long maxSize = size - 1;
        final int len = randomIntBetween(1, 100000);
        BigArraysHelper doubleHelper = new BigArraysHelper(
        final int emptyHash = Arrays.hashCode(BytesRef.EMPTY_BYTES);
            } catch (CircuitBreakingException e) {
        assertEquals(array1Hash, array2Hash);
        array2.fill(fromIndex, toIndex, rand);
        }
import org.opensearch.common.settings.Settings;
            ? Math.min(fromIndex + randomInt(100), len) // single page
    public void testDoubleArrayGrowth() {
        for (String type : Arrays.asList("Byte", "Int", "Long", "Float", "Double", "Object")) {
        FloatArray array = bigArrays.newFloatArray(startLen, randomBoolean());
            array1[i] = randomFloat();
            (Long size) -> BigDoubleArray.estimateRamBytes(size)
    public void testMaxSizeExceededOnResize() throws Exception {
import java.lang.reflect.InvocationTargetException;
            array.set(i, ref[i]);
        for (int i = 0; i < totalLen; ++i) {
    }
        return (withBreaking ? bigArrays.withCircuitBreaking() : bigArrays);
        for (int i = 0; i < len; ++i) {
        array.close();
    @Before
        BigArrays bigArrays = new BigArrays(null, hcbs, CircuitBreaker.REQUEST);
        final int fromIndex = randomIntBetween(0, len - 1);
            Method resize = BigArrays.class.getMethod("resize", array.getClass().getInterfaces()[0], long.class);
        );
        final int totalLen = randomIntBetween(1, 1000000);
            assertEquals(array1[i], array2.get(i), 0.001d);
        );
        Object[] ref = new Object[totalLen];
        array2.fill(fromIndex, toIndex, rand);
            assertEquals(array1[i], array2.get(i));
            assertEquals(ref[i], array.get(i));
        final int fromIndex = randomIntBetween(0, len - 1);
            try {
        HierarchyCircuitBreakerService hcbs = new HierarchyCircuitBreakerService(
        emptyByteArray.close();
                    .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
            array2.set(i, array1[i]);
    }
        for (int i = 0; i < array1.length; ++i) {
    }
        final BytesRef ref = new BytesRef();
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
            array2.set(i, array1[i]);
        for (int i = 0; i < len; ++i) {
        Arrays.fill(array1, fromIndex, toIndex, rand);
        ByteArray bytearray = bigArrays.newByteArray(bytes.length);
        final ByteArray emptyByteArray = byteArrayWithBytes(BytesRef.EMPTY_BYTES);
    public void testLongArrayGrowth() {
        final int fromIndex = randomIntBetween(0, len - 1);
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
    }
            ? Math.min(fromIndex + randomInt(100), len) // single page
        random().nextBytes(array1);
        }
            array = bigArrays.grow(array, i + 1);
    }
        final long size = scaledRandomIntBetween(5, 1 << 22);
        }
    public void testEstimatedBytesSameAsActualBytes() throws Exception {
            (Long size) -> BigLongArray.estimateRamBytes(size)
        int[] ref = new int[totalLen];
/*
 * the Apache License, Version 2.0 (the "License"); you may
        array.close();
    public void testObjectArrayGrowth() {
        BigArraysHelper intHelper = new BigArraysHelper(
        assertFalse(bigArrays.equals(a5, a6));
            ? Math.min(fromIndex + randomInt(100), len) // single page
            array = bigArrays.grow(array, i + 1);
        return bytearray;
    public void testMaxSizeExceededOnNew() throws Exception {
    }
                fail("circuit breaker should trip");
            assertEquals(0, bigArraysHelper.bigArrays.breakerService().getBreaker(CircuitBreaker.REQUEST).getUsed());
    }
        }
        final int fromIndex = randomIntBetween(0, len - 1);
    }
        array.close();
        empty1.close();
        BigArraysHelper byteHelper = new BigArraysHelper(
        for (int i = 0; i < len; ++i) {
        Arrays.fill(array1, fromIndex, toIndex, rand);
        // FUN FACT: Arrays.hashCode() and BytesReference.bytesHashCode() are inconsistent for empty byte[]
        }
                assertEquals(maxSize, e.getByteLimit());
        // final int emptyHash3 = new BytesArray(BytesRef.EMPTY_BYTES).hashCode();
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
        a3.close();
            objectBigArrays,
        final int toIndex = randomBoolean()
        final int toIndex = randomBoolean()
        final LongArray array2 = bigArrays.newLongArray(len, randomBoolean());
        array.close();
        array2.fill(fromIndex, toIndex, rand);
        LongArray array = bigArrays.newLongArray(startLen, randomBoolean());
                .put(REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), maxSize, ByteSizeUnit.BYTES)
            array = bigArrays.grow(array, i + 1);
        random().nextBytes(array1);
        for (int i = 0; i < totalLen; ++i) {
    }
import org.apache.lucene.util.BytesRef;
        for (final BigArraysHelper bigArraysHelper : bigArrayCreators(maxSize, false)) {
        final BigArrays objectBigArrays = newBigArraysInstance(maxSize, withBreaking);
        final ByteArray a5 = byteArrayWithBytes(new byte[] { 1, 2, 3 });
        final int len = randomIntBetween(1, 100000);
import org.opensearch.common.settings.ClusterSettings;
        );
        final int pageSize = 1 << (randomIntBetween(2, 16));
        BigArraysHelper(BigArrays bigArrays, Function<Long, BigArray> arrayAllocator, Function<Long, Long> ramEstimator) {
        random().nextBytes(array1);
                } catch (InvocationTargetException e) {
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
        bigArrays = randombigArrays();
        assertThat(size, greaterThanOrEqualTo((long) minSize));
            intBigArrays,
        }
    public void testByteArrayFill() {
        final ByteArray array2 = bigArrays.newByteArray(len, randomBoolean());
            array1[i] = randomByte();
        final BigArrays intBigArrays = newBigArraysInstance(maxSize, withBreaking);
        for (int i = 0; i < pool.length; ++i) {
    }
 * GitHub history for details.
            }
 * You may obtain a copy of the License at
    public void testByteArrayEquals() {
    private BigArrays newBigArraysInstance(final long maxSize, final boolean withBreaking) {
        for (int i = 0; i < bytes.length; ++i) {
        for (int i = 0; i < totalLen; ++i) {
 * The OpenSearch Contributors require contributions made to
 * this work for additional information regarding copyright
            assertEquals(array.ramBytesUsed(), hcbs.getBreaker(CircuitBreaker.REQUEST).getUsed());
        a6.close();
                .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
        }
    }
        final int totalLen = randomIntBetween(1, 1000000);
        for (int i = 0; i < totalLen; ++i) {
        final int toIndex = randomBoolean()
/*
        final Function<Long, BigArray> arrayAllocator;
            array = bigArrays.grow(array, i + 1);
            ref[i] = randomInt();
                .build(),
        final BigArrays bigArrays;
}
            (Long size) -> BigObjectArray.estimateRamBytes(size)
        for (int i = 0; i < totalLen; ++i) {
                bigArraysHelper.arrayAllocator.apply(size);
    }
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
 *
        for (int i = 0; i < len; ++i) {
        float[] ref = new float[totalLen];
        return Arrays.asList(byteHelper, intHelper, longHelper, floatHelper, doubleHelper, objectHelper);
    public void testDoubleArrayFill() {
import static org.hamcrest.Matchers.equalTo;
    public void testIntArrayGrowth() {
                assertThat(e.getBytesWanted(), greaterThanOrEqualTo(size));
        final ByteArray a1 = byteArrayWithBytes(new byte[] { 0 });
        array2.close();
        final BigArrays byteBigArrays = newBigArraysInstance(maxSize, withBreaking);
        assertThat(size - minSize, lessThan((long) pageSize));
        }
    }
package org.opensearch.common.util;
        final BigArrays longBigArrays = newBigArraysInstance(maxSize, withBreaking);
        );
    private BigArrays bigArrays;
            array.set(i, ref[i]);
        byte[] ref = new byte[totalLen];
 * this file be licensed under the Apache-2.0 license or a
        final long rand = randomLong();
        final byte[] array1 = new byte[len];
            : randomIntBetween(fromIndex, len); // likely multiple pages
        final long size = BigArrays.overSize(minSize, pageSize, 1);
            i += len;
        final int maxSize = 1 << scaledRandomIntBetween(15, 22);
    }
        // equality: both empty
import java.util.List;
        array2.close();
            array.set(i, ref[i]);
            assertEquals(new BytesRef(array1, offset, len), ref);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final byte rand = randomByte();
        final int totalLen = randomIntBetween(1, 4000000);
            final int size = scaledRandomIntBetween(10, maxSize / 16);
            HierarchyCircuitBreakerService hcbs = new HierarchyCircuitBreakerService(
            ref[i] = randomFloat();
        array2.fill(fromIndex, toIndex, rand);
        final ByteArray empty2 = byteArrayWithBytes(BytesRef.EMPTY_BYTES);
        final BigArrays doubleBigArrays = newBigArraysInstance(maxSize, withBreaking);
            array2.set(i, array1, i, len);
            assertEquals(ref[i], array.get(i));
 */
        BigArraysHelper longHelper = new BigArraysHelper(
            assertEquals(array1[i], array2.get(i), 0.001d);
        // not equal: contents differ
    }
        Arrays.fill(array1, fromIndex, toIndex, rand);
            Collections.emptyList(),
        }
        final ByteArray array2 = byteArrayWithBytes(array1);
        a4.close();
        Arrays.fill(array1, fromIndex, toIndex, rand);
        final ByteArray a3 = byteArrayWithBytes(new byte[] { 1, 2, 3 });
            array1[i] = randomDouble();
        for (int i = 0; i < totalLen; ++i) {
        // large arrays should be different
    public void testByteArrayHashCode() {
            floatBigArrays,
        }
    public void testLongArrayFill() {
 * not use this file except in compliance with the License.
            final int len = Math.min(array1.length - i, randomBoolean() ? randomInt(10) : randomInt(3 * PageCacheRecycler.BYTE_PAGE_SIZE));
            (Long size) -> BigByteArray.estimateRamBytes(size)
        assertFalse(bigArrays.equals(a3, a4));
        assertEquals(0, bigArrays.hashCode(null));
        final int emptyByteArrayHash = bigArrays.hashCode(emptyByteArray);
            }
    private static class BigArraysHelper {
                    break;
            while (true) {
        }
        final FloatArray array2 = bigArrays.newFloatArray(len, randomBoolean());
                    array = (BigArray) resize.invoke(bigArrays, array, newSize);
        }
            array2.get(offset, len, ref);
        final int totalLen = randomIntBetween(1, 1000000);
 *
 * Unless required by applicable law or agreed to in writing,
        }
        BigArraysHelper floatHelper = new BigArraysHelper(
    }
        assertTrue(bigArrays.equals(empty1, empty1));
        }
        }
        final ByteArray array2 = bigArrays.newByteArray(array1.length, randomBoolean());
 * license agreements. See the NOTICE file distributed with
            : randomIntBetween(fromIndex, len); // likely multiple pages
 */
        }
            assertEquals(ref[i], array.get(i), 0.001d);
        final int totalLen = randomIntBetween(1, 1000000);
            final BigArray bigArray = bigArraysHelper.arrayAllocator.apply(size);
            array.close();
            (Long size) -> BigFloatArray.estimateRamBytes(size)
        }
        for (int i = 0; i < len; ++i) {
        final DoubleArray array2 = bigArrays.newDoubleArray(len, randomBoolean());
        final ByteArray a6 = byteArrayWithBytes(new byte[] { 1, 2, 4 });
        final ByteArray array2 = bigArrays.newByteArray(array1.length, randomBoolean());
        final ByteArray a2 = byteArrayWithBytes(new byte[] { 1 });
    public void testByteArrayGrowth() {
        final byte[] array1 = new byte[randomIntBetween(1, 4000000)];
            ? Math.min(fromIndex + randomInt(100), len) // single page
        // empty array should have equal hash
    }
        for (int i = 0; i < totalLen; ++i) {
 * ownership. Elasticsearch licenses this file to you under
        final int minSize = randomIntBetween(1, pageSize) * randomIntBetween(1, 100);
    public void testByteArrayBulkGet() {
import org.junit.Before;
        array.close();
        }
    private List<BigArraysHelper> bigArrayCreators(final long maxSize, final boolean withBreaking) {
        // not equal: contents differ
            ref[i] = randomLong();
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
    }
        array2.close();
            array1[i] = randomLong();
        a2.close();
            Settings.builder()
    private ByteArray byteArrayWithBytes(byte[] bytes) {
        for (int i = 0; i < array1.length; ++i) {
        a1.close();
            : randomIntBetween(fromIndex, len); // likely multiple pages
        for (int i = 0; i < totalLen; ++i) {
        ObjectArray<Object> array = bigArrays.newObjectArray(startLen);
        array.close();
            (Long size) -> doubleBigArrays.newDoubleArray(size),
            assertEquals(array1[i], array2.get(i), 0.001d);
            (Long size) -> byteBigArrays.newByteArray(size),
    }
        // assertEquals(emptyHash1, emptyHash3); -> fail (1 vs. 0)
import java.util.function.Function;
            this.ramEstimator = ramEstimator;
        final int totalLen = randomIntBetween(1, 1000000);
            array2.set(i, array1[i]);
            assertEquals(0, hcbs.getBreaker(CircuitBreaker.REQUEST).getUsed());
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
        final ByteArray empty1 = byteArrayWithBytes(BytesRef.EMPTY_BYTES);
 * under the License.
import static org.hamcrest.Matchers.lessThan;
        for (int i = 0; i < totalLen; ++i) {
            this.bigArrays = bigArrays;
            pool[i] = new Object();
            assertEquals(array1[i], array2.get(i));
            longBigArrays,
            assertEquals(ref[i], array.get(i));
            assertThat(size + " is a multiple of " + pageSize, size % pageSize, equalTo(0L));
public class BigArraysTests extends OpenSearchTestCase {
    }
import org.opensearch.test.OpenSearchTestCase;
        final float rand = randomFloat();
            array = bigArrays.grow(array, i + 1);
            (Long size) -> longBigArrays.newLongArray(size),
        for (int i = 0; i < totalLen; ++i) {
    private BigArrays randombigArrays() {
/*
        for (int i = 0; i < len; ++i) {
                    .put(REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), maxSize, ByteSizeUnit.BYTES)
            Method create = BigArrays.class.getMethod("new" + type + "Array", long.class);
            array.set(i, ref[i]);
import org.opensearch.core.common.util.ByteArray;
            array.set(i, ref[i]);
                try {
            doubleBigArrays,
import org.opensearch.core.common.breaker.CircuitBreaker;
            final int maxSize = randomIntBetween(1 << 8, 1 << 14);
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
        );
        assertFalse(bigArrays.equals(a1, a2));
        final float[] array1 = new float[len];
import org.opensearch.core.common.breaker.CircuitBreakingException;
        }
        final Function<Long, Long> ramEstimator;
        return new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        double[] ref = new double[totalLen];
            assertSame(ref[i], array.get(i));
        }
import java.lang.reflect.Method;
        final byte[] array1 = new byte[randomIntBetween(1, 4000000)];
            (Long size) -> objectBigArrays.newObjectArray(size),
 * specific language governing permissions and limitations
            bytearray.set(i, bytes[i]);
        final int len = randomIntBetween(1, 100000);
        a5.close();
        }
            (Long size) -> floatBigArrays.newFloatArray(size),
        }
        BigArraysHelper objectHelper = new BigArraysHelper(
    public void testFloatArrayGrowth() {
        for (BigArraysHelper bigArraysHelper : bigArrayCreators(maxSize, true)) {
        final int array1Hash = Arrays.hashCode(array1);
 * KIND, either express or implied.  See the License for the
            final int offset = randomInt(array1.length - 1);
        empty2.close();
        array2.close();
            byteBigArrays,
 */
        final int len = randomIntBetween(1, 100000);
            ref[i] = randomDouble();
        }
            BigArrays bigArrays = new BigArrays(null, hcbs, CircuitBreaker.REQUEST).withCircuitBreaking();
import org.opensearch.core.common.util.BigArray;
        final int array2Hash = bigArrays.hashCode(array2);
            (Long size) -> BigIntArray.estimateRamBytes(size)
        final byte[] array1 = new byte[randomIntBetween(1, 4000000)];
        }
            (Long size) -> intBigArrays.newIntArray(size),
        for (int i = 0; i < 1000; ++i) {
                Collections.emptyList(),
                    assertTrue(e.getCause() instanceof CircuitBreakingException);
            array2.set(i, array1[i]);
        array2.close();
    }
            array2.set(i, array1[i]);
                }
        final Object[] pool = new Object[100];
        assertEquals(emptyHash, emptyByteArrayHash);
        }
        // null arg has hashCode 0
        for (int i = 0; i < len; ++i) {
 * Modifications Copyright OpenSearch Contributors. See
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        final long size = randomIntBetween((1 << 14) + 1, maxSize);
    }
        for (int i = 0; i < totalLen; ++i) {
            );
            array = bigArrays.grow(array, i + 1);
