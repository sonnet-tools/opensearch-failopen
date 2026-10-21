            @Override
            }
/*
    public static final PageCacheRecycler NON_RECYCLING_INSTANCE;
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    // object pages are less useful to us so we give them a lower weight by default
    }
        return objectPage.obtain();
    private static <T> Recycler<T> build(Type type, int limit, int availableProcessors, Recycler.C<T> c) {
    public static final Setting<Double> WEIGHT_LONG_SETTING = Setting.doubleSetting(
import org.opensearch.common.settings.Setting;
import org.apache.lucene.util.RamUsageEstimator;
        });
        final int maxPageCount = (int) Math.min(Integer.MAX_VALUE, limit / PAGE_SIZE_IN_BYTES);
        1d,
                return none(c);
    public static final int LONG_PAGE_SIZE = PAGE_SIZE_IN_BYTES / Long.BYTES;
        });
package org.opensearch.common.util;
            <T> Recycler<T> build(Recycler.C<T> c, int limit, int availableProcessors) {
        "cache.recycler.page.weight.ints",
import org.opensearch.core.common.bytes.PagedBytesReference;
        0d,
    }
    }
        }
            }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
}
        },
            try {
import org.opensearch.common.settings.Settings;
    public static final int PAGE_SIZE_IN_BYTES = PagedBytesReference.PAGE_SIZE_IN_BYTES;
        "cache.recycler.page.weight.bytes",
        "cache.recycler.page.weight.longs",
        longPage = build(type, maxLongPageCount, allocatedProcessors, new AbstractRecyclerC<long[]>() {
        final Recycler.V<long[]> v = longPage.obtain();
        // operations.
        // to direct ByteBuffers or sun.misc.Unsafe on a byte[] but this would have other issues
 * under the License.
import static org.opensearch.common.recycler.Recyclers.none;
        // is no space left in the stack/queue. LRU/LFU policies are not an option either
import static org.opensearch.common.recycler.Recyclers.dequeFactory;
    }
            @Override
 * Modifications Copyright OpenSearch Contributors. See
/*
        // a work load could fill the recycler with only byte[] pages and then another
 * KIND, either express or implied.  See the License for the
    );
            public void recycle(byte[] value) {
    public Recycler.V<byte[]> bytePage(boolean clear) {
        final int maxIntPageCount = (int) (intsWeight * maxPageCount / totalWeight);
        final double intsWeight = WEIGHT_INT_SETTING.get(settings);
            @Override
        // Trying to store all of them in a single stack would be problematic because eg.
            public void recycle(int[] value) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to
            }
 * this file be licensed under the Apache-2.0 license or a
        final double longsWeight = WEIGHT_LONG_SETTING.get(settings);
        1d,
            public Object[] newInstance() {
 * You may obtain a copy of the License at
import java.util.Locale;
        1d,
                return new Object[OBJECT_PAGE_SIZE];
     * @opensearch.internal
    );
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        final Recycler.V<int[]> v = intPage.obtain();
import static org.opensearch.common.recycler.Recyclers.concurrent;
    private final Recycler<Object[]> objectPage;
    );
        }
        final int maxLongPageCount = (int) (longsWeight * maxPageCount / totalWeight);
/*
        NONE {
            @Override
        0d,
                // nothing to do
    public static final Setting<ByteSizeValue> LIMIT_HEAP_SETTING = Setting.memorySizeSetting(
/**
        "cache.recycler.page.weight.objects",
            recycler = type.build(c, limit, availableProcessors);
        Property.NodeScope
    private final Recycler<long[]> longPage;
    static {
        bytePage = build(type, maxBytePageCount, allocatedProcessors, new AbstractRecyclerC<byte[]>() {
import org.opensearch.common.recycler.AbstractRecyclerC;
        "cache.recycler.page.limit.heap",
            }
 * GitHub history for details.
 */
            }
        Property.NodeScope
        final long limit = LIMIT_HEAP_SETTING.get(settings).getBytes();
        }
 * not use this file except in compliance with the License.
        final int maxObjectPageCount = (int) (objectsWeight * maxPageCount / totalWeight);
                return new byte[BYTE_PAGE_SIZE];
        // workload that would work with double[] pages couldn't recycle them because there
        // of Unsafe writes.
 * this work for additional information regarding copyright
    public static final Setting<Double> WEIGHT_OBJECTS_SETTING = Setting.doubleSetting(
            }
        Property.NodeScope
        Type.CONCURRENT.name(),
 * SPDX-License-Identifier: Apache-2.0
            }
            Arrays.fill(v.v(), (byte) 0);
        assert PAGE_SIZE_IN_BYTES * (maxBytePageCount + maxIntPageCount + maxLongPageCount + maxObjectPageCount) <= limit;
        });
        final double bytesWeight = WEIGHT_BYTES_SETTING.get(settings);
import java.util.Arrays;
        final double objectsWeight = WEIGHT_OBJECTS_SETTING.get(settings);
        Property.NodeScope
            }
    }
        "cache.recycler.page.type",
    );
    /**
    public static final int INT_PAGE_SIZE = PAGE_SIZE_IN_BYTES / Integer.BYTES;
        }
        if (v.isRecycled() && clear) {
                // nothing to do
            @Override
    public static final Setting<Double> WEIGHT_BYTES_SETTING = Setting.doubleSetting(
import org.opensearch.common.settings.Setting.Property;
    private final Recycler<int[]> intPage;
        return recycler;
                throw new IllegalArgumentException("no type support [" + type + "]");
                return concurrentDeque(c, limit);
            @Override
    public static final Setting<Type> TYPE_SETTING = new Setting<>(
        CONCURRENT {
 * Unless required by applicable law or agreed to in writing,
        }
    public Recycler.V<int[]> intPage(boolean clear) {
        0d,
        final Type type = TYPE_SETTING.get(settings);
                return new long[LONG_PAGE_SIZE];
    public Recycler.V<Object[]> objectPage() {
 * A recycler of fixed-size pages.
        return v;
 * Licensed to Elasticsearch under one or more contributor
    }
            }
import org.opensearch.core.common.unit.ByteSizeValue;
 * ownership. Elasticsearch licenses this file to you under
            @Override
        if (limit == 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
            <T> Recycler<T> build(Recycler.C<T> c, int limit, int availableProcessors) {
        final double totalWeight = bytesWeight + intsWeight + longsWeight + objectsWeight;
            }
     * Type of the page cache recycler
        intPage = build(type, maxIntPageCount, allocatedProcessors, new AbstractRecyclerC<int[]>() {
 * @opensearch.internal
            }
        };
        QUEUE {
            @Override
        // because they would make obtain/release too costly: we really need constant-time
            public long[] newInstance() {
                return Type.valueOf(type.toUpperCase(Locale.ROOT));
public class PageCacheRecycler {
            <T> Recycler<T> build(Recycler.C<T> c, int limit, int availableProcessors) {
        Property.NodeScope
            Arrays.fill(v.v(), 0);
            @Override
 * software distributed under the License is distributed on an
    );
        final int allocatedProcessors = OpenSearchExecutors.allocatedProcessors(settings);
        final int maxBytePageCount = (int) (bytesWeight * maxPageCount / totalWeight);
    );
    public static final Setting<Double> WEIGHT_INT_SETTING = Setting.doubleSetting(
        return v;
            public int[] newInstance() {
                Arrays.fill(value, null); // we need to remove the strong refs on the objects stored in the array
    }
@ExperimentalApi
 *
            @Override
    public Recycler.V<long[]> longPage(boolean clear) {
        "10%",
        // Since some types are more useful than other ones we give them different weights.
import org.opensearch.common.recycler.Recycler;
                return new int[INT_PAGE_SIZE];
    private final Recycler<byte[]> bytePage;
        if (v.isRecycled() && clear) {
        final Recycler<T> recycler;
                return concurrent(dequeFactory(c, limit / availableProcessors), availableProcessors);
 *
        0d,
    }
            public void recycle(Object[] value) {
            }
import static org.opensearch.common.recycler.Recyclers.concurrentDeque;
 *
        public static Type parse(String type) {
        } else {
    /** Page size in bytes: 16KB */
     */
        Property.NodeScope
        // object pages are cleared on release anyway
        0.1d,
        if (v.isRecycled() && clear) {
        abstract <T> Recycler<T> build(Recycler.C<T> c, int limit, int availableProcessors);
        },
        final Recycler.V<byte[]> v = bytePage.obtain();
            @Override
        NON_RECYCLING_INSTANCE = new PageCacheRecycler(Settings.builder().put(LIMIT_HEAP_SETTING.getKey(), "0%").build());
        return v;
        // ability to interpret it either as a source of bytes, doubles, longs, etc. eg. thanks
 *
        // We have a global amount of memory that we need to divide across data types.
    public static final int OBJECT_PAGE_SIZE = PAGE_SIZE_IN_BYTES / RamUsageEstimator.NUM_BYTES_OBJECT_REF;
        // Ultimately a better solution would be to only store one kind of data and have the
 */
            Arrays.fill(v.v(), 0L);
     *
        // that would need to be addressed such as garbage collection of native memory or safety
 */
            public byte[] newInstance() {
        });
            } catch (IllegalArgumentException e) {
        Type::parse,
    public static final int BYTE_PAGE_SIZE = PAGE_SIZE_IN_BYTES;
import org.opensearch.common.annotation.ExperimentalApi;
        objectPage = build(type, maxObjectPageCount, allocatedProcessors, new AbstractRecyclerC<Object[]>() {
                // nothing to do
    public enum Type {
            recycler = none(c);
    public PageCacheRecycler(Settings settings) {
            public void recycle(long[] value) {
