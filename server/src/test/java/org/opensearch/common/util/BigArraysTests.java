        }  
        final int totalLen = randomIntBetween(1, 1000000);
                fail("circuit breaker should trip");  
        BigArraysHelper intHelper = new BigArraysHelper(
        final ByteArray emptyByteArray = byteArrayWithBytes(BytesRef.EMPTY_BYTES);  
    }  
        array2.close();  
        array.close();  
        Arrays.fill(array1, fromIndex, toIndex, rand);
    }
 */
            (Long size) -> longBigArrays.newLongArray(size),
            final int offset = randomInt(array1.length - 1);
                .build(),  
        for (int i = 0; i < array1.length;) {
        a1.close();  
        final int totalLen = randomIntBetween(1, 1000000);
            (Long size) -> BigObjectArray.estimateRamBytes(size)
        final Function<Long, Long> ramEstimator;
        );  
        for (int i = 0; i < totalLen; ++i) {
    public void testByteArrayGrowth() {  
        for (int i = 0; i < len; ++i) {  
        int[] ref = new int[totalLen];
import org.junit.Before;  
        assertTrue(bigArrays.equals(empty1, empty2));
            assertEquals(array1[i], array2.get(i), 0.001d);
                assertEquals(maxSize, e.getByteLimit());
            : randomIntBetween(fromIndex, len); // likely multiple pages  
 * GitHub history for details.
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        final Object[] pool = new Object[100];  
    }
        }
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        }  
            (Long size) -> byteBigArrays.newByteArray(size),
        final BigArrays bigArrays;  
        array2.fill(fromIndex, toIndex, rand);  
 * this work for additional information regarding copyright
        for (int i = 0; i < len; ++i) {
    public void testByteArrayEquals() {  
        }  
        final int toIndex = randomBoolean()
        BigArraysHelper(BigArrays bigArrays, Function<Long, BigArray> arrayAllocator, Function<Long, Long> ramEstimator) {
        array2.close();
        final float rand = randomFloat();
        }
                }
            array = bigArrays.grow(array, i + 1);
            : randomIntBetween(fromIndex, len); // likely multiple pages  
import java.util.Arrays;
            Collections.emptyList(),
        final BigArrays doubleBigArrays = newBigArraysInstance(maxSize, withBreaking);
        ByteArray array = bigArrays.newByteArray(startLen, randomBoolean());  
            (Long size) -> BigLongArray.estimateRamBytes(size)
        BigArrays bigArrays = new BigArrays(null, hcbs, CircuitBreaker.REQUEST);
    public void testLongArrayGrowth() {
    }
        }
        if (size >= pageSize) {  
        }
        for (int i = 0; i < len; ++i) {
            array = bigArrays.grow(array, i + 1);
        final int len = randomIntBetween(1, 100000);
    public void testDoubleArrayGrowth() {
        final ByteArray array2 = bigArrays.newByteArray(array1.length, randomBoolean());  
 * ownership. Elasticsearch licenses this file to you under  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        // large arrays should be different  
        return (withBreaking ? bigArrays.withCircuitBreaking() : bigArrays);
        a2.close();
    }
        array.close();
        }  
        );  
 * software distributed under the License is distributed on an
        a5.close();
            assertEquals(array1[i], array2.get(i), 0.001d);
            array.set(i, ref[i]);  
            array2.get(offset, len, ref);  
        final int toIndex = randomBoolean()
        for (int i = 0; i < totalLen; ++i) {
        array2.fill(fromIndex, toIndex, rand);  
        a4.close();
        final int totalLen = randomIntBetween(1, 1000000);  
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);  
        assertEquals(0, bigArrays.hashCode(null));
            assertEquals(0, hcbs.getBreaker(CircuitBreaker.REQUEST).getUsed());  
import org.opensearch.core.common.util.ByteArray;
            assertEquals(ref[i], array.get(i), 0.001d);  
            objectBigArrays,  
    @Before
            floatBigArrays,  
    public void init() {
        final int fromIndex = randomIntBetween(0, len - 1);  
import org.opensearch.core.common.unit.ByteSizeUnit;  
            array1[i] = randomByte();
        final BigArrays intBigArrays = newBigArraysInstance(maxSize, withBreaking);
        }  
    }
        }  
                    array = (BigArray) resize.invoke(bigArrays, array, newSize);
        Arrays.fill(array1, fromIndex, toIndex, rand);
            array2.set(i, array1, i, len);  
            array1[i] = randomLong();
        for (int i = 0; i < len; ++i) {  
                    .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)  
            ? Math.min(fromIndex + randomInt(100), len) // single page
        array2.fill(fromIndex, toIndex, rand);  
    public void testOverSizeUsesMinPageCount() {
        assertThat(size, greaterThanOrEqualTo((long) minSize));
 *
        final ByteArray array2 = byteArrayWithBytes(array1);
        }  
        final ByteArray a2 = byteArrayWithBytes(new byte[] { 1 });
        assertFalse(bigArrays.equals(a5, a6));
        }  
        final long size = randomIntBetween((1 << 14) + 1, maxSize);  
        final ByteArray a3 = byteArrayWithBytes(new byte[] { 1, 2, 3 });
 * KIND, either express or implied.  See the License for the
        final long[] array1 = new long[len];
            ref[i] = randomFrom(pool);  
import org.opensearch.core.common.breaker.CircuitBreakingException;
        final LongArray array2 = bigArrays.newLongArray(len, randomBoolean());
            this.bigArrays = bigArrays;
    }
        // identity = equality
        assertEquals(array1Hash, array2Hash);  
        random().nextBytes(array1);
            array.close();
            array.set(i, ref[i]);
        for (int i = 0; i < len; ++i) {  
        final int pageSize = 1 << (randomIntBetween(2, 16));
        // not equal: contents differ  
import org.opensearch.test.OpenSearchTestCase;
                .put(REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), maxSize, ByteSizeUnit.BYTES)
        final ByteArray a1 = byteArrayWithBytes(new byte[] { 0 });  
        array.close();
            assertEquals(new BytesRef(array1, offset, len), ref);
            assertEquals(array1[i], array2.get(i));
            pool[i] = new Object();
        final double[] array1 = new double[len];
            array1[i] = randomFloat();
 * Modifications Copyright OpenSearch Contributors. See
        byte[] ref = new byte[totalLen];
        for (int i = 0; i < 1000; ++i) {  
            BigArray array = (BigArray) create.invoke(bigArrays, size);
        assertFalse(bigArrays.equals(a3, a4));  
            (Long size) -> BigIntArray.estimateRamBytes(size)
            } catch (CircuitBreakingException e) {
        array.close();
            array2.set(i, array1[i]);
            doubleBigArrays,  
/*
        final int minSize = randomIntBetween(1, pageSize) * randomIntBetween(1, 100);  
        }  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final BigArrays objectBigArrays = newBigArraysInstance(maxSize, withBreaking);
 * Licensed to Elasticsearch under one or more contributor  
        final BigArrays floatBigArrays = newBigArraysInstance(maxSize, withBreaking);
        // null arg has hashCode 0
    public void testDoubleArrayFill() {
            while (true) {
 *
        ObjectArray<Object> array = bigArrays.newObjectArray(startLen);
            array = bigArrays.grow(array, i + 1);
            }  
        final float[] array1 = new float[len];
            assertEquals(array1[i], array2.get(i), 0.001d);
 */  
    public void testMaxSizeExceededOnResize() throws Exception {  
                    .put(REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), maxSize, ByteSizeUnit.BYTES)
import org.opensearch.core.common.breaker.CircuitBreaker;
import java.util.Collections;
        final BigArrays longBigArrays = newBigArraysInstance(maxSize, withBreaking);
public class BigArraysTests extends OpenSearchTestCase {
        IntArray array = bigArrays.newIntArray(startLen, randomBoolean());
            this.ramEstimator = ramEstimator;
        final long rand = randomLong();
                assertThat(e.getBytesWanted(), greaterThanOrEqualTo(size));  
            byteBigArrays,  
        for (int i = 0; i < len; ++i) {
        array2.close();
        BigArraysHelper floatHelper = new BigArraysHelper(
import org.opensearch.core.common.util.BigArray;
            bytearray.set(i, bytes[i]);
        }  
 * SPDX-License-Identifier: Apache-2.0
        Arrays.fill(array1, fromIndex, toIndex, rand);
        final ByteArray a5 = byteArrayWithBytes(new byte[] { 1, 2, 3 });
    public void testObjectArrayGrowth() {
    private ByteArray byteArrayWithBytes(byte[] bytes) {
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
        Object[] ref = new Object[totalLen];
    }
            array = bigArrays.grow(array, i + 1);
            assertEquals(0, bigArraysHelper.bigArrays.breakerService().getBreaker(CircuitBreaker.REQUEST).getUsed());
            final int maxSize = randomIntBetween(1 << 8, 1 << 14);
        );  
        final ByteArray array2 = bigArrays.newByteArray(len, randomBoolean());
        BigArraysHelper objectHelper = new BigArraysHelper(
        ByteArray bytearray = bigArrays.newByteArray(bytes.length);
        for (int i = 0; i < totalLen; ++i) {
        final Function<Long, BigArray> arrayAllocator;
            ref[i] = randomInt();
    private List<BigArraysHelper> bigArrayCreators(final long maxSize, final boolean withBreaking) {  
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);  
    }
            Method resize = BigArrays.class.getMethod("resize", array.getClass().getInterfaces()[0], long.class);  
        }  
        LongArray array = bigArrays.newLongArray(startLen, randomBoolean());
        final int toIndex = randomBoolean()
        long[] ref = new long[totalLen];  
            array = bigArrays.grow(array, i + 1);
    public void testIntArrayGrowth() {
                    assertTrue(e.getCause() instanceof CircuitBreakingException);  
        final int totalLen = randomIntBetween(1, 4000000);
        empty2.close();  
            array2.set(i, array1[i]);
            (Long size) -> floatBigArrays.newFloatArray(size),
        final BigArrays byteBigArrays = newBigArraysInstance(maxSize, withBreaking);
            ref[i] = randomFloat();  
import org.opensearch.common.settings.Settings;  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testFloatArrayFill() {
    public void testByteArrayHashCode() {  
        final double rand = randomDouble();
    }
        }  
import static org.hamcrest.Matchers.equalTo;
            ? Math.min(fromIndex + randomInt(100), len) // single page
                long newSize = array.size() * 2;
            }
    public void testByteArrayBulkSet() {  
        }
            ? Math.min(fromIndex + randomInt(100), len) // single page
}
        }  
        final byte[] array1 = new byte[len];
        final byte rand = randomByte();
            array2.set(i, array1[i]);  
                } catch (InvocationTargetException e) {
        for (int i = 0; i < array1.length; ++i) {
        final DoubleArray array2 = bigArrays.newDoubleArray(len, randomBoolean());
        final FloatArray array2 = bigArrays.newFloatArray(len, randomBoolean());
        for (int i = 0; i < totalLen; ++i) {  
            final int len = Math.min(array1.length - i, randomBoolean() ? randomInt(10) : randomInt(3 * PageCacheRecycler.BYTE_PAGE_SIZE));
    }  
        final int fromIndex = randomIntBetween(0, len - 1);  
import org.opensearch.common.settings.ClusterSettings;
        emptyByteArray.close();  
import java.util.function.Function;
        for (BigArraysHelper bigArraysHelper : bigArrayCreators(maxSize, true)) {  
        }
            BigArrays bigArrays = new BigArrays(null, hcbs, CircuitBreaker.REQUEST).withCircuitBreaking();
    public void testFloatArrayGrowth() {  
import java.lang.reflect.Method;  
        final int totalLen = randomIntBetween(1, 1000000);
            ref[i] = randomLong();
                Settings.builder()
    }
        assertEquals(emptyHash, emptyByteArrayHash);
        }  
                    .build(),
        final int emptyHash = Arrays.hashCode(BytesRef.EMPTY_BYTES);
            assertEquals(ref[i], array.get(i));
            ref[i] = randomDouble();
        final BytesRef ref = new BytesRef();
        final int maxSize = 1 << scaledRandomIntBetween(15, 22);
        for (int i = 0; i < totalLen; ++i) {
 *  
 * under the License.  
import static org.hamcrest.Matchers.lessThan;  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        final int len = randomIntBetween(1, 100000);
        final ByteArray a6 = byteArrayWithBytes(new byte[] { 1, 2, 4 });  
    private BigArrays newBigArraysInstance(final long maxSize, final boolean withBreaking) {
        // final int emptyHash3 = new BytesArray(BytesRef.EMPTY_BYTES).hashCode();  
        }
        final byte[] array1 = new byte[randomIntBetween(1, 4000000)];
            final int len = randomInt(Math.min(randomBoolean() ? 10 : Integer.MAX_VALUE, array1.length - offset));
            intBigArrays,  
    }
            ? Math.min(fromIndex + randomInt(100), len) // single page
        return Arrays.asList(byteHelper, intHelper, longHelper, floatHelper, doubleHelper, objectHelper);
        final long size = BigArrays.overSize(minSize, pageSize, 1);
            HierarchyCircuitBreakerService hcbs = new HierarchyCircuitBreakerService(  
 * not use this file except in compliance with the License.
            array.set(i, ref[i]);
        double[] ref = new double[totalLen];
        final int fromIndex = randomIntBetween(0, len - 1);  
    }
        BigArraysHelper longHelper = new BigArraysHelper(
    }  
        bigArrays = randombigArrays();  
            (Long size) -> BigByteArray.estimateRamBytes(size)
                Collections.emptyList(),
        a6.close();  
        // empty array should have equal hash
        array2.close();  
        array2.close();
        for (int i = 0; i < totalLen; ++i) {
            final BigArray bigArray = bigArraysHelper.arrayAllocator.apply(size);
    public void testEstimatedBytesSameAsActualBytes() throws Exception {
        }
 * compatible open source license.
    }  
    public void testLongArrayFill() {
        // not equal: contents differ
package org.opensearch.common.util;
        final int array1Hash = Arrays.hashCode(array1);  
            this.arrayAllocator = arrayAllocator;  
        final int fromIndex = randomIntBetween(0, len - 1);  
import java.util.List;  
                .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
        for (int i = 0; i < array1.length; ++i) {  
        BigArraysHelper doubleHelper = new BigArraysHelper(
            (Long size) -> BigFloatArray.estimateRamBytes(size)
    }
    }
        for (int i = 0; i < totalLen; ++i) {
        Arrays.fill(array1, fromIndex, toIndex, rand);
            array1[i] = randomDouble();
    private static class BigArraysHelper {
/*  
            (Long size) -> objectBigArrays.newObjectArray(size),
            array.set(i, ref[i]);  
        return bytearray;  
            );
        HierarchyCircuitBreakerService hcbs = new HierarchyCircuitBreakerService(
        for (int i = 0; i < totalLen; ++i) {  
        empty1.close();
            assertEquals(ref[i], array.get(i), 0.001d);
        FloatArray array = bigArrays.newFloatArray(startLen, randomBoolean());  
        // FUN FACT: Arrays.hashCode() and BytesReference.bytesHashCode() are inconsistent for empty byte[]
    }
        for (int i = 0; i < totalLen; ++i) {
        for (int i = 0; i < len; ++i) {  
        final ByteArray a4 = byteArrayWithBytes(new byte[] { 1, 1, 3 });
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
    public void testByteArrayBulkGet() {
            assertEquals(array.ramBytesUsed(), hcbs.getBreaker(CircuitBreaker.REQUEST).getUsed());
        }
        assertThat(size - minSize, lessThan((long) pageSize));  
        final long size = scaledRandomIntBetween(5, 1 << 22);
        final byte[] array1 = new byte[randomIntBetween(1, 4000000)];
 * license agreements. See the NOTICE file distributed with
        final int len = randomIntBetween(1, 100000);
        assertTrue(bigArrays.equals(empty1, empty1));
        // not equal: contents differ
            assertEquals(ref[i], array.get(i));  
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
        }
        }
            (Long size) -> BigDoubleArray.estimateRamBytes(size)
        for (int i = 0; i < totalLen; ++i) {
            assertSame(ref[i], array.get(i));
 * the Apache License, Version 2.0 (the "License"); you may
        array2.close();
 * The OpenSearch Contributors require contributions made to  
    public void testMaxSizeExceededOnNew() throws Exception {  
        final ByteArray array2 = bigArrays.newByteArray(array1.length, randomBoolean());
        // assertEquals(emptyHash1, emptyHash3); -> fail (1 vs. 0)
                bigArraysHelper.arrayAllocator.apply(size);
        final ByteArray empty2 = byteArrayWithBytes(BytesRef.EMPTY_BYTES);
            array.set(i, ref[i]);
        array.close();
        }
        final int emptyByteArrayHash = bigArrays.hashCode(emptyByteArray);
            longBigArrays,  
            final int size = scaledRandomIntBetween(10, maxSize / 16);
    }
    }
        DoubleArray array = bigArrays.newDoubleArray(startLen, randomBoolean());
        for (final BigArraysHelper bigArraysHelper : bigArrayCreators(maxSize, false)) {
        // equality: both empty  
        final byte[] array1 = new byte[randomIntBetween(1, 4000000)];
        for (int i = 0; i < totalLen; ++i) {
        random().nextBytes(array1);  
    }
        );  
        }
                    break;
            array2.set(i, array1[i]);
        final int toIndex = randomBoolean()
import org.apache.lucene.util.BytesRef;
 * You may obtain a copy of the License at  
            array = bigArrays.grow(array, i + 1);  
        for (int i = 0; i < totalLen; ++i) {  
        random().nextBytes(array1);
                try {  
    private BigArrays randombigArrays() {
        );  
        for (int i = 0; i < bytes.length; ++i) {  
        array.close();
            ref[i] = randomByte();  
        a3.close();
            : randomIntBetween(fromIndex, len); // likely multiple pages  
            array2.set(i, array1[i]);
            (Long size) -> doubleBigArrays.newDoubleArray(size),
            : randomIntBetween(fromIndex, len); // likely multiple pages  
            i += len;
            assertEquals(bigArraysHelper.ramEstimator.apply(size).longValue(), bigArray.ramBytesUsed());  
        float[] ref = new float[totalLen];
    private BigArrays bigArrays;
        );  
        for (int i = 0; i < pool.length; ++i) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
        array2.fill(fromIndex, toIndex, rand);  
        return new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            assertEquals(array1[i], array2.get(i));
            Method create = BigArrays.class.getMethod("new" + type + "Array", long.class);  
        );  
        final int totalLen = randomIntBetween(1, 1000000);  
import java.lang.reflect.InvocationTargetException;
        final ByteArray empty1 = byteArrayWithBytes(BytesRef.EMPTY_BYTES);
        final int array2Hash = bigArrays.hashCode(array2);
        assertFalse(bigArrays.equals(a1, a2));
            array.set(i, ref[i]);
import static org.opensearch.indices.breaker.HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING;  
            assertThat(size + " is a multiple of " + pageSize, size % pageSize, equalTo(0L));
    }
            assertEquals(ref[i], array.get(i));
        }  
        }
        for (int i = 0; i < len; ++i) {
            (Long size) -> intBigArrays.newIntArray(size),
            try {
        final long maxSize = size - 1;
        for (String type : Arrays.asList("Byte", "Int", "Long", "Float", "Double", "Object")) {
        final int startLen = randomIntBetween(1, randomBoolean() ? 1000 : totalLen);
 */  
        final int len = randomIntBetween(1, 100000);
        array2.close();
    public void testByteArrayFill() {
            Settings.builder()  
    }  
 * specific language governing permissions and limitations
        BigArraysHelper byteHelper = new BigArraysHelper(
        }
