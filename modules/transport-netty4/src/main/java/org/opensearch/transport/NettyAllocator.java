/*
                    pageSize = 8192;
        }
                }
                    } else if (g1gcRegionSizeInBytes >= (2 * 1024 * 1024)) {
        }
        public ByteBuf directBuffer() {
                    + "}]";
            return ALLOCATOR;
            return heapBuffer(initialCapacity, maxCapacity);
            return false;
        } else {
                    SUGGESTED_MAX_ALLOCATION_SIZE = 1024 * 1024;
        } else {
                    maxOrder = PooledByteBufAllocator.defaultMaxOrder();
        public ByteBufAllocator getDelegate() {
        public ByteBuf ioBuffer(int initialCapacity) {
        }
                    pageSize = PooledByteBufAllocator.defaultPageSize();
                        // This combined with a 8192 page size = 512 KB chunk sizes
        @Override
    private static final long SUGGESTED_MAX_ALLOCATION_SIZE;
                    + chunkSize
        public CompositeByteBuf compositeHeapBuffer(int maxNumComponents) {
    }
        } else {
        }
            ByteSizeValue g1gcRegionSize = new ByteSizeValue(g1gcRegionSizeInBytes);
            throw new UnsupportedOperationException("Direct buffers not supported");
                + ", factors={opensearch.unsafe.use_netty_default_allocator=true}]";
                int smallCacheSize = PooledByteBufAllocator.defaultSmallCacheSize();
            return compositeHeapBuffer();
                    maxOrder,
        } else {
        public ByteBuf buffer() {
        } else {
    }
        @Override
    }
        }
import org.opensearch.monitor.jvm.JvmInfo;
        @Override
 *
                DESCRIPTION = "[name=opensearch_configured, chunk_size="
        if (ALLOCATOR instanceof NoDirectBuffers) {
            return ndb.delegate; /* Http3/Quic only supports direct buffers */
                    + "}]";
 */
            throw new UnsupportedOperationException("Direct buffers not supported");
                boolean useCacheForAllThreads = PooledByteBufAllocator.defaultUseCacheForAllThreads();
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
        if (System.getProperty(USE_UNPOOLED) != null) {
            return heapBuffer();
 * GitHub history for details.
                if (g1gcEnabled && g1gcRegionSizeIsKnown) {
        public ByteBuf heapBuffer(int initialCapacity) {
public class NettyAllocator {
 *
        }
import org.opensearch.core.common.unit.ByteSizeValue;
                    // where this value would be less than 256KB.
        if (System.getProperty(USE_NETTY_DEFAULT_CHUNK) != null) {
            return false;
            // If the heap is 1GB or less we use unpooled
                    + ", factors={opensearch.unsafe.use_unpooled_allocator="
            return delegate.heapBuffer(initialCapacity, maxCapacity);
 */
                ByteSizeValue chunkSize = new ByteSizeValue(chunkSizeInBytes);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                    useCacheForAllThreads
 * the Apache License, Version 2.0 (the "License"); you may
import io.netty.channel.Channel;
        if (directBuffers == true && ALLOCATOR instanceof NoDirectBuffers ndb) {
        }
            ALLOCATOR = ByteBufAllocator.DEFAULT;
                } else {
                delegate = new PooledByteBufAllocator(
    private static final Logger logger = LogManager.getLogger(NettyAllocator.class);
            return false;
                delegate = UnpooledByteBufAllocator.DEFAULT;
import io.netty.buffer.CompositeByteBuf;
    public static String getAllocatorDescription() {
import java.util.concurrent.atomic.AtomicBoolean;
        @Override
        }
            if (useUnpooled(heapSizeInBytes, g1gcEnabled, g1gcRegionSizeIsKnown, g1gcRegionSizeInBytes)) {
    }
                    + g1gcEnabled
    private static final AtomicBoolean descriptionLogged = new AtomicBoolean(false);
                DESCRIPTION = "[name=unpooled, suggested_max_allocation_size="
                    }
        }
        @Override
            return Booleans.parseBoolean(System.getProperty(USE_UNPOOLED)) == false;
        @Override
        }
                    + ", g1gc_region_size="
            }
        public ByteBuf heapBuffer(int initialCapacity, int maxCapacity) {
        }
        @Override
            return true;
            // If the G1GC is enabled and the region size is known and is less than 1MB we use unpooled.
        if (ALLOCATOR instanceof NoDirectBuffers) {
            throw new UnsupportedOperationException("Direct buffers not supported.");
            return heapBuffer(initialCapacity);
    }
        }
            final long heapSizeInBytes = JvmInfo.jvmInfo().getMem().getHeapMax().getBytes();
        public ByteBuf buffer(int initialCapacity, int maxCapacity) {
        } else if (heapSizeInBytes <= 1 << 30) {
    }
        } else if (userForcedPooled()) {
        @Override
                int nHeapArena = PooledByteBufAllocator.defaultNumHeapArena();
    public static ByteBufAllocator getAllocator(boolean directBuffers) {
 * this work for additional information regarding copyright
            return true;
                    + g1gcEnabled
import io.netty.buffer.UnpooledByteBufAllocator;
        }
            logger.info("creating NettyAllocator with the following configs: " + NettyAllocator.getAllocatorDescription());
            return false;
            throw new UnsupportedOperationException("Direct buffers not supported.");
        }
        @Override
                SUGGESTED_MAX_ALLOCATION_SIZE = chunkSizeInBytes;
            throw new UnsupportedOperationException("Direct buffers not supported");
        }
import org.opensearch.common.Booleans;
                int chunkSizeInBytes = pageSize << maxOrder;
    private static final String USE_NETTY_DEFAULT_CHUNK = "opensearch.unsafe.use_netty_default_chunk_and_page_size";
 * SPDX-License-Identifier: Apache-2.0
        } else if (g1gcEnabled == false) {
                    0,
        }
        public CompositeByteBuf compositeBuffer(int maxNumComponents) {
                    nHeapArena,
    }
                + new ByteSizeValue(SUGGESTED_MAX_ALLOCATION_SIZE)
        }
            return delegate.heapBuffer();
 * Licensed to Elasticsearch under one or more contributor
        public ByteBuf directBuffer(int initialCapacity) {
        if (Booleans.parseBoolean(System.getProperty(USE_NETTY_DEFAULT), false)) {
    private static final ByteBufAllocator ALLOCATOR;
                    + ", g1gc_enabled="
                    pageSize,
            return Booleans.parseBoolean(System.getProperty(USE_UNPOOLED));
                    // Suggested max allocation size 1/4 of region size. Guard against unknown edge cases
        public ByteBuf directBuffer(int initialCapacity, int maxCapacity) {
            return heapBuffer(initialCapacity);
        @Override
                    + ", suggested_max_allocation_size="
                    smallCacheSize,
                int normalCacheSize = PooledByteBufAllocator.defaultNormalCacheSize();
                        // This combined with a 8192 page size = 256 KB chunk sizes
                    + ", g1gc_enabled="
        public ByteBuf heapBuffer() {
            return delegate;
            boolean g1gcRegionIsLessThan1MB = g1RegionSize < 1 << 20;
 * Modifications Copyright OpenSearch Contributors. See
                    + heapSize
            return delegate.heapBuffer(initialCapacity);
        }
            return heapBuffer();
        }
        }
package org.opensearch.transport;
 * ownership. Elasticsearch licenses this file to you under
                    if (g1gcEnabled == false || g1gcRegionSizeIsKnown == false || g1gcRegionSizeInBytes >= (4 * 1024 * 1024)) {
                int maxOrder;
    }
                    + ", factors={opensearch.unsafe.use_netty_default_chunk_and_page_size="
        public int calculateNewCapacity(int minNewCapacity, int maxCapacity) {
        public CompositeByteBuf compositeDirectBuffer() {
        @Override
    static {
        }
    }
    private static boolean useUnpooled(long heapSizeInBytes, boolean g1gcEnabled, boolean g1gcRegionSizeIsKnown, long g1RegionSize) {
        public boolean isDirectBufferPooled() {
                    + new ByteSizeValue(SUGGESTED_MAX_ALLOCATION_SIZE)
            } else {
                        // This combined with a 8192 page size = 1 MB chunk sizes
    private static boolean useDefaultChunkAndPageSize() {
        @Override
    public static Class<? extends ServerChannel> getServerChannelType() {
        if (userForcedUnpooled()) {
                    + g1gcRegionSize
    public static void logAllocatorDescriptionIfNeeded() {
        public CompositeByteBuf compositeDirectBuffer(int maxNumComponents) {
        }
            return CopyBytesSocketChannel.class;
            return true;
            ALLOCATOR = new NoDirectBuffers(delegate);
        }
    private static boolean userForcedUnpooled() {
                } else {
    private static boolean userForcedPooled() {
}
                    normalCacheSize,
        return SUGGESTED_MAX_ALLOCATION_SIZE;
        public CompositeByteBuf compositeHeapBuffer() {
 *
 * license agreements. See the NOTICE file distributed with
                int pageSize;
        public ByteBuf buffer(int initialCapacity) {
            final long g1gcRegionSizeInBytes = JvmInfo.jvmInfo().getG1RegionSize();
            return delegate.compositeHeapBuffer();
import io.netty.buffer.ByteBuf;
            return delegate.compositeHeapBuffer(maxNumComponents);
        public CompositeByteBuf compositeBuffer() {
            this.delegate = delegate;
            return false;
        } else {
 * KIND, either express or implied.  See the License for the
    }
 */
    public static long suggestedMaxAllocationSize() {
        }
    public static Class<? extends Channel> getChannelType() {
                if (useDefaultChunkAndPageSize()) {
        public ByteBuf ioBuffer() {
                    + ", g1gc_region_size="
        }
            return Netty4NioServerSocketChannel.class;
 * You may obtain a copy of the License at
        }
        private NoDirectBuffers(ByteBufAllocator delegate) {
 * specific language governing permissions and limitations
        }
                    + new ByteSizeValue(SUGGESTED_MAX_ALLOCATION_SIZE)
                    + System.getProperty(USE_UNPOOLED)
                    + ", heap_size="
        } else {
        }
 * compatible open source license.
        }
import io.netty.buffer.PooledByteBufAllocator;
                    + g1gcRegionSize
        }
    private static final String DESCRIPTION;
 * under the License.
            return delegate.calculateNewCapacity(minNewCapacity, maxCapacity);
            return Netty4NioSocketChannel.class;
            final boolean g1gcRegionSizeIsKnown = g1gcRegionSizeInBytes != -1;
                        maxOrder = 7;
        @Override
        @Override
                    false,
            return heapBuffer(initialCapacity, maxCapacity);
import io.netty.channel.ServerChannel;
            return (g1gcRegionSizeIsKnown && g1gcRegionIsLessThan1MB);
    }
/*
        return ALLOCATOR;
                }
        private final ByteBufAllocator delegate;
            return CopyBytesServerSocketChannel.class;
            return Booleans.parseBoolean(System.getProperty(USE_NETTY_DEFAULT_CHUNK));
        public ByteBuf ioBuffer(int initialCapacity, int maxCapacity) {
import io.netty.buffer.ByteBufAllocator;
        if (descriptionLogged.compareAndSet(false, true)) {
    public static ByteBufAllocator getAllocator() {
    public static class NoDirectBuffers implements ByteBufAllocator {
import org.apache.logging.log4j.LogManager;
        @Override
                        maxOrder = 6;
        if (System.getProperty(USE_UNPOOLED) != null) {
            DESCRIPTION = "[name=netty_default, suggested_max_allocation_size="
                );
                    } else {
            SUGGESTED_MAX_ALLOCATION_SIZE = 1024 * 1024;
        } else {
                    SUGGESTED_MAX_ALLOCATION_SIZE = Math.max(g1gcRegionSizeInBytes >> 2, 256 * 1024);
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
            ByteSizeValue heapSize = new ByteSizeValue(heapSizeInBytes);
    private static final String USE_NETTY_DEFAULT = "opensearch.unsafe.use_netty_default_allocator";
        @Override
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
/*
                        maxOrder = 5;
    private static final String USE_UNPOOLED = "opensearch.use_unpooled_allocator";
import org.apache.logging.log4j.Logger;
                    + useDefaultChunkAndPageSize()
            final boolean g1gcEnabled = Boolean.parseBoolean(JvmInfo.jvmInfo().useG1GC());
    }
        @Override
            assert delegate.isDirectBufferPooled() == false;
        @Override
        return DESCRIPTION;
            return compositeHeapBuffer(maxNumComponents);
            ByteBufAllocator delegate;
    }
        @Override
