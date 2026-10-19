        final double bytesWeight = WEIGHT_BYTES_SETTING.get(settings);
    public static final int PAGE_SIZE_IN_BYTES = PagedBytesReference.PAGE_SIZE_IN_BYTES;  
 * Licensed to Elasticsearch under one or more contributor  
            @Override
            } catch (IllegalArgumentException e) {  
/*
        1d,
        }
            Arrays.fill(v.v(), (byte) 0);
        final Recycler.V<long[]> v = longPage.obtain();
 * compatible open source license.
        final Type type = TYPE_SETTING.get(settings);  
 * Modifications Copyright OpenSearch Contributors. See
        });
            <T> Recycler<T> build(Recycler.C<T> c, int limit, int availableProcessors) {
    );
        // is no space left in the stack/queue. LRU/LFU policies are not an option either  
        objectPage = build(type, maxObjectPageCount, allocatedProcessors, new AbstractRecyclerC<Object[]>() {
        // because they would make obtain/release too costly: we really need constant-time
        },
    public static final int BYTE_PAGE_SIZE = PAGE_SIZE_IN_BYTES;
     * @opensearch.internal
 *
            }  
        0d,  
 * this work for additional information regarding copyright
    }
        if (limit == 0) {  
        NON_RECYCLING_INSTANCE = new PageCacheRecycler(Settings.builder().put(LIMIT_HEAP_SETTING.getKey(), "0%").build());
    public static final Setting<Double> WEIGHT_INT_SETTING = Setting.doubleSetting(  
@ExperimentalApi
     *
        Property.NodeScope
        return v;
            Arrays.fill(v.v(), 0);
            recycler = type.build(c, limit, availableProcessors);  
 */
    public static final Setting<Double> WEIGHT_LONG_SETTING = Setting.doubleSetting(  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.bytes.PagedBytesReference;  
 *
 * The OpenSearch Contributors require contributions made to  
            try {
                return new byte[BYTE_PAGE_SIZE];
                Arrays.fill(value, null); // we need to remove the strong refs on the objects stored in the array
    );  
        final int maxObjectPageCount = (int) (objectsWeight * maxPageCount / totalWeight);
        final int maxBytePageCount = (int) (bytesWeight * maxPageCount / totalWeight);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        // operations.
 */  
        });  
 * A recycler of fixed-size pages.  
        // Ultimately a better solution would be to only store one kind of data and have the  
            Arrays.fill(v.v(), 0L);  
        "10%",  
            public int[] newInstance() {
    public static final int LONG_PAGE_SIZE = PAGE_SIZE_IN_BYTES / Long.BYTES;
        1d,
 *  
        }
import org.opensearch.common.recycler.Recycler;
import static org.opensearch.common.recycler.Recyclers.concurrent;  
        } else {
            }
                // nothing to do
            @Override  
        final int maxPageCount = (int) Math.min(Integer.MAX_VALUE, limit / PAGE_SIZE_IN_BYTES);
            public Object[] newInstance() {
    );
        0d,  
/*  
 * under the License.  
    public Recycler.V<int[]> intPage(boolean clear) {
            @Override  
 * not use this file except in compliance with the License.
        Property.NodeScope
            public void recycle(Object[] value) {  
            }  
        Type::parse,
        longPage = build(type, maxLongPageCount, allocatedProcessors, new AbstractRecyclerC<long[]>() {
    private final Recycler<long[]> longPage;
    public static final PageCacheRecycler NON_RECYCLING_INSTANCE;
import org.opensearch.common.recycler.AbstractRecyclerC;  
            }
            <T> Recycler<T> build(Recycler.C<T> c, int limit, int availableProcessors) {
        final int allocatedProcessors = OpenSearchExecutors.allocatedProcessors(settings);
        Property.NodeScope
    public Recycler.V<long[]> longPage(boolean clear) {  
            public byte[] newInstance() {
        Property.NodeScope
        });  
    /** Page size in bytes: 16KB */
        CONCURRENT {
    );
        Property.NodeScope
        // ability to interpret it either as a source of bytes, doubles, longs, etc. eg. thanks
}
        "cache.recycler.page.weight.bytes",
        final long limit = LIMIT_HEAP_SETTING.get(settings).getBytes();
        final double totalWeight = bytesWeight + intsWeight + longsWeight + objectsWeight;
        }
 * @opensearch.internal
            @Override  
            recycler = none(c);
            @Override  
package org.opensearch.common.util;
        // to direct ByteBuffers or sun.misc.Unsafe on a byte[] but this would have other issues
            }
 * SPDX-License-Identifier: Apache-2.0
            @Override
        assert PAGE_SIZE_IN_BYTES * (maxBytePageCount + maxIntPageCount + maxLongPageCount + maxObjectPageCount) <= limit;
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // object pages are cleared on release anyway  
            @Override  
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
        // that would need to be addressed such as garbage collection of native memory or safety  
        final double intsWeight = WEIGHT_INT_SETTING.get(settings);  
        Type.CONCURRENT.name(),  
 *
                return new long[LONG_PAGE_SIZE];
        public static Type parse(String type) {  
                return new Object[OBJECT_PAGE_SIZE];
                return Type.valueOf(type.toUpperCase(Locale.ROOT));
        if (v.isRecycled() && clear) {
    public PageCacheRecycler(Settings settings) {
    public static final Setting<Double> WEIGHT_OBJECTS_SETTING = Setting.doubleSetting(
    public static final Setting<Type> TYPE_SETTING = new Setting<>(
import static org.opensearch.common.recycler.Recyclers.none;  
    }
            }  
        QUEUE {
        // of Unsafe writes.
    );  
                throw new IllegalArgumentException("no type support [" + type + "]");
/*  
        "cache.recycler.page.limit.heap",
    private final Recycler<byte[]> bytePage;  
    public static final int OBJECT_PAGE_SIZE = PAGE_SIZE_IN_BYTES / RamUsageEstimator.NUM_BYTES_OBJECT_REF;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        0d,
import org.opensearch.common.settings.Setting;
        return recycler;
            @Override  
 * GitHub history for details.
        };
 * specific language governing permissions and limitations
import org.opensearch.common.settings.Settings;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    static {
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
        });
        }  
        "cache.recycler.page.weight.ints",
    private final Recycler<Object[]> objectPage;  
    public enum Type {
    }  
        bytePage = build(type, maxBytePageCount, allocatedProcessors, new AbstractRecyclerC<byte[]>() {
 * KIND, either express or implied.  See the License for the
import java.util.Locale;
                return concurrentDeque(c, limit);
        abstract <T> Recycler<T> build(Recycler.C<T> c, int limit, int availableProcessors);
    private static <T> Recycler<T> build(Type type, int limit, int availableProcessors, Recycler.C<T> c) {
 */  
        final Recycler.V<byte[]> v = bytePage.obtain();  
    }  
                return concurrent(dequeFactory(c, limit / availableProcessors), availableProcessors);
    public Recycler.V<byte[]> bytePage(boolean clear) {
        Property.NodeScope
            <T> Recycler<T> build(Recycler.C<T> c, int limit, int availableProcessors) {
        return v;
        if (v.isRecycled() && clear) {
            public void recycle(byte[] value) {  
 * ownership. Elasticsearch licenses this file to you under  
    // object pages are less useful to us so we give them a lower weight by default  
        // workload that would work with double[] pages couldn't recycle them because there
    public static final Setting<ByteSizeValue> LIMIT_HEAP_SETTING = Setting.memorySizeSetting(
        "cache.recycler.page.weight.longs",
    public static final int INT_PAGE_SIZE = PAGE_SIZE_IN_BYTES / Integer.BYTES;  
        // Since some types are more useful than other ones we give them different weights.
        "cache.recycler.page.type",
    public static final Setting<Double> WEIGHT_BYTES_SETTING = Setting.doubleSetting(  
            @Override
        final Recycler<T> recycler;
    );
        // We have a global amount of memory that we need to divide across data types.
        // a work load could fill the recycler with only byte[] pages and then another
            }  
        intPage = build(type, maxIntPageCount, allocatedProcessors, new AbstractRecyclerC<int[]>() {  
import org.opensearch.common.annotation.ExperimentalApi;
/**
            @Override
import static org.opensearch.common.recycler.Recyclers.dequeFactory;
import org.apache.lucene.util.RamUsageEstimator;
import static org.opensearch.common.recycler.Recyclers.concurrentDeque;
            }  
                // nothing to do
        return v;  
        0d,  
        "cache.recycler.page.weight.objects",
            public long[] newInstance() {  
        final double longsWeight = WEIGHT_LONG_SETTING.get(settings);
        final double objectsWeight = WEIGHT_OBJECTS_SETTING.get(settings);
        if (v.isRecycled() && clear) {  
        }  
import java.util.Arrays;  
        // Trying to store all of them in a single stack would be problematic because eg.  
                return new int[INT_PAGE_SIZE];  
            }
public class PageCacheRecycler {
        final int maxLongPageCount = (int) (longsWeight * maxPageCount / totalWeight);  
        1d,
     * Type of the page cache recycler  
            }
import org.opensearch.common.settings.Setting.Property;  
    private final Recycler<int[]> intPage;
        return objectPage.obtain();
 */  
                // nothing to do  
    public Recycler.V<Object[]> objectPage() {
            }  
    /**
            }
        final Recycler.V<int[]> v = intPage.obtain();
        NONE {
     */  
import org.opensearch.core.common.unit.ByteSizeValue;
                return none(c);
            public void recycle(int[] value) {
            public void recycle(long[] value) {
        final int maxIntPageCount = (int) (intsWeight * maxPageCount / totalWeight);
 * You may obtain a copy of the License at  
        },
        0.1d,  
