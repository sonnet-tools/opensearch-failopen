        @Override  
/*  
    public static void logAllocatorDescriptionIfNeeded() {
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
                    + g1gcEnabled  
            throw new UnsupportedOperationException("Direct buffers not supported.");
                        // This combined with a 8192 page size = 256 KB chunk sizes
            return delegate.compositeHeapBuffer(maxNumComponents);
        }  
        if (descriptionLogged.compareAndSet(false, true)) {
            return delegate;
        public ByteBuf buffer(int initialCapacity, int maxCapacity) {
            ALLOCATOR = new NoDirectBuffers(delegate);  
    }  
    public static class NoDirectBuffers implements ByteBufAllocator {  
 */  
                int maxOrder;  
        }  
                DESCRIPTION = "[name=unpooled, suggested_max_allocation_size="
import io.netty.buffer.ByteBuf;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return delegate.heapBuffer(initialCapacity, maxCapacity);
 *  
        }
}
                    + ", suggested_max_allocation_size="
 * Unless required by applicable law or agreed to in writing,
 *
 * GitHub history for details.
                int nHeapArena = PooledByteBufAllocator.defaultNumHeapArena();
        public boolean isDirectBufferPooled() {  
            assert delegate.isDirectBufferPooled() == false;
                    SUGGESTED_MAX_ALLOCATION_SIZE = Math.max(g1gcRegionSizeInBytes >> 2, 256 * 1024);  
                boolean useCacheForAllThreads = PooledByteBufAllocator.defaultUseCacheForAllThreads();
            return Netty4NioServerSocketChannel.class;  
    private static boolean useUnpooled(long heapSizeInBytes, boolean g1gcEnabled, boolean g1gcRegionSizeIsKnown, long g1RegionSize) {
            return Booleans.parseBoolean(System.getProperty(USE_NETTY_DEFAULT_CHUNK));  
import org.apache.logging.log4j.LogManager;
            boolean g1gcRegionIsLessThan1MB = g1RegionSize < 1 << 20;
        public CompositeByteBuf compositeDirectBuffer() {
        public ByteBuf heapBuffer() {  
            return Booleans.parseBoolean(System.getProperty(USE_UNPOOLED)) == false;
        public ByteBuf ioBuffer() {  
        } else if (userForcedPooled()) {
            return ALLOCATOR;
    public static Class<? extends ServerChannel> getServerChannelType() {
                + ", factors={opensearch.unsafe.use_netty_default_allocator=true}]";  
        }
                    // where this value would be less than 256KB.
        }
        public ByteBufAllocator getDelegate() {
    private static final String USE_NETTY_DEFAULT = "opensearch.unsafe.use_netty_default_allocator";  
        public CompositeByteBuf compositeBuffer(int maxNumComponents) {
        }  
                int pageSize;
                        maxOrder = 5;
import java.util.concurrent.atomic.AtomicBoolean;
        }
                    maxOrder,
            final long heapSizeInBytes = JvmInfo.jvmInfo().getMem().getHeapMax().getBytes();
        @Override  
            throw new UnsupportedOperationException("Direct buffers not supported");  
    public static Class<? extends Channel> getChannelType() {  
                ByteSizeValue chunkSize = new ByteSizeValue(chunkSizeInBytes);
            this.delegate = delegate;
            return delegate.heapBuffer();
                if (useDefaultChunkAndPageSize()) {
                        // This combined with a 8192 page size = 1 MB chunk sizes
                int smallCacheSize = PooledByteBufAllocator.defaultSmallCacheSize();
        if (directBuffers == true && ALLOCATOR instanceof NoDirectBuffers ndb) {
            throw new UnsupportedOperationException("Direct buffers not supported");
        }
        public ByteBuf directBuffer(int initialCapacity, int maxCapacity) {
            return true;
        }
        public CompositeByteBuf compositeBuffer() {  
            final boolean g1gcEnabled = Boolean.parseBoolean(JvmInfo.jvmInfo().useG1GC());  
                    + ", g1gc_region_size="
                    pageSize = 8192;
        }
        } else {
                    pageSize,  
        }
    private static final Logger logger = LogManager.getLogger(NettyAllocator.class);
                    maxOrder = PooledByteBufAllocator.defaultMaxOrder();  
            return delegate.calculateNewCapacity(minNewCapacity, maxCapacity);
                    + g1gcRegionSize
        public ByteBuf directBuffer() {  
 * software distributed under the License is distributed on an
                    } else if (g1gcRegionSizeInBytes >= (2 * 1024 * 1024)) {  
                    false,  
/*
        @Override  
    private static final String USE_UNPOOLED = "opensearch.use_unpooled_allocator";
        @Override  
        @Override
    private static final ByteBufAllocator ALLOCATOR;
    public static ByteBufAllocator getAllocator(boolean directBuffers) {
                    SUGGESTED_MAX_ALLOCATION_SIZE = 1024 * 1024;
        }  
        }  
                }  
import io.netty.buffer.UnpooledByteBufAllocator;
    }
        return ALLOCATOR;
    private static final AtomicBoolean descriptionLogged = new AtomicBoolean(false);
        public CompositeByteBuf compositeHeapBuffer(int maxNumComponents) {  
        } else {
            return (g1gcRegionSizeIsKnown && g1gcRegionIsLessThan1MB);
                    + "}]";
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
                    useCacheForAllThreads
        }
                    + g1gcEnabled
            return false;
    static {  
                    0,
    public static String getAllocatorDescription() {
        }
                    + ", factors={opensearch.unsafe.use_unpooled_allocator="  
            return ndb.delegate; /* Http3/Quic only supports direct buffers */  
    public static long suggestedMaxAllocationSize() {
            throw new UnsupportedOperationException("Direct buffers not supported");
    }
 */  
                    pageSize = PooledByteBufAllocator.defaultPageSize();
        }
        }
                    + useDefaultChunkAndPageSize()
            logger.info("creating NettyAllocator with the following configs: " + NettyAllocator.getAllocatorDescription());  
            return true;
 * Licensed to Elasticsearch under one or more contributor  
            return Netty4NioSocketChannel.class;
        }
        } else {  
        @Override  
                        // This combined with a 8192 page size = 512 KB chunk sizes
                delegate = new PooledByteBufAllocator(
 * ownership. Elasticsearch licenses this file to you under  
        }
        public ByteBuf heapBuffer(int initialCapacity, int maxCapacity) {
    }
 * compatible open source license.
            return heapBuffer();
        } else {
            final boolean g1gcRegionSizeIsKnown = g1gcRegionSizeInBytes != -1;
            ByteSizeValue heapSize = new ByteSizeValue(heapSizeInBytes);  
 * license agreements. See the NOTICE file distributed with
    private static final long SUGGESTED_MAX_ALLOCATION_SIZE;
            SUGGESTED_MAX_ALLOCATION_SIZE = 1024 * 1024;  
            return compositeHeapBuffer(maxNumComponents);  
        return DESCRIPTION;  
import org.opensearch.core.common.unit.ByteSizeValue;
import io.netty.buffer.PooledByteBufAllocator;  
            return compositeHeapBuffer();
            if (useUnpooled(heapSizeInBytes, g1gcEnabled, g1gcRegionSizeIsKnown, g1gcRegionSizeInBytes)) {
    private static final String DESCRIPTION;  
 * this work for additional information regarding copyright
        if (System.getProperty(USE_UNPOOLED) != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (ALLOCATOR instanceof NoDirectBuffers) {  
                    + ", g1gc_region_size="
                    + ", heap_size="  
            return false;
            return CopyBytesSocketChannel.class;
                        maxOrder = 6;
                + new ByteSizeValue(SUGGESTED_MAX_ALLOCATION_SIZE)
        }  
        @Override
 *
            }
                    + System.getProperty(USE_UNPOOLED)
    }
                DESCRIPTION = "[name=opensearch_configured, chunk_size="  
                    + chunkSize
            return heapBuffer();
        }  
        private final ByteBufAllocator delegate;
    }
        } else {
        public CompositeByteBuf compositeDirectBuffer(int maxNumComponents) {
    private static boolean userForcedPooled() {
 */
                    } else {  
    }
            return true;  
            throw new UnsupportedOperationException("Direct buffers not supported.");  
        @Override
                    + g1gcRegionSize  
            DESCRIPTION = "[name=netty_default, suggested_max_allocation_size="
            return Booleans.parseBoolean(System.getProperty(USE_UNPOOLED));
            return delegate.heapBuffer(initialCapacity);  
        @Override
import io.netty.buffer.ByteBufAllocator;
        public ByteBuf buffer() {  
 * under the License.  
public class NettyAllocator {
        }
        @Override  
        @Override
                    + heapSize
        @Override
            return false;
import org.apache.logging.log4j.Logger;
        }  
        public ByteBuf heapBuffer(int initialCapacity) {
                int chunkSizeInBytes = pageSize << maxOrder;  
        }  
        } else if (heapSizeInBytes <= 1 << 30) {  
            ByteBufAllocator delegate;  
        } else if (g1gcEnabled == false) {  
                    nHeapArena,
    }  
                    + ", factors={opensearch.unsafe.use_netty_default_chunk_and_page_size="
        public int calculateNewCapacity(int minNewCapacity, int maxCapacity) {  
    }
        }
 * Modifications Copyright OpenSearch Contributors. See
                int normalCacheSize = PooledByteBufAllocator.defaultNormalCacheSize();  
    public static ByteBufAllocator getAllocator() {  
 * KIND, either express or implied.  See the License for the
                delegate = UnpooledByteBufAllocator.DEFAULT;
                SUGGESTED_MAX_ALLOCATION_SIZE = chunkSizeInBytes;
    private static final String USE_NETTY_DEFAULT_CHUNK = "opensearch.unsafe.use_netty_default_chunk_and_page_size";
            return false;
        }
/*  
        @Override
        } else {  
                        maxOrder = 7;
import org.opensearch.common.Booleans;  
            return heapBuffer(initialCapacity);  
        }
        private NoDirectBuffers(ByteBufAllocator delegate) {
        } else {
            ALLOCATOR = ByteBufAllocator.DEFAULT;
        @Override
                }
        public ByteBuf buffer(int initialCapacity) {
                    + new ByteSizeValue(SUGGESTED_MAX_ALLOCATION_SIZE)  
        if (userForcedUnpooled()) {
        } else {
                    + ", g1gc_enabled="
    }  
            final long g1gcRegionSizeInBytes = JvmInfo.jvmInfo().getG1RegionSize();
        public ByteBuf ioBuffer(int initialCapacity) {
import io.netty.channel.Channel;
                    + ", g1gc_enabled="  
            return heapBuffer(initialCapacity, maxCapacity);
        @Override
    }
        }  
                    }  
        @Override
    }
                if (g1gcEnabled && g1gcRegionSizeIsKnown) {  
            // If the G1GC is enabled and the region size is known and is less than 1MB we use unpooled.  
        if (Booleans.parseBoolean(System.getProperty(USE_NETTY_DEFAULT), false)) {
                    + "}]";
        public CompositeByteBuf compositeHeapBuffer() {
        if (ALLOCATOR instanceof NoDirectBuffers) {
                    normalCacheSize,  
                } else {
            // If the heap is 1GB or less we use unpooled
    private static boolean userForcedUnpooled() {  
 * SPDX-License-Identifier: Apache-2.0
            return false;  
            ByteSizeValue g1gcRegionSize = new ByteSizeValue(g1gcRegionSizeInBytes);
                    // Suggested max allocation size 1/4 of region size. Guard against unknown edge cases
        if (System.getProperty(USE_UNPOOLED) != null) {  
            } else {  
        @Override
        @Override
                    smallCacheSize,
        if (System.getProperty(USE_NETTY_DEFAULT_CHUNK) != null) {
    }
        public ByteBuf directBuffer(int initialCapacity) {
        }  
        return SUGGESTED_MAX_ALLOCATION_SIZE;
            return heapBuffer(initialCapacity);  
        @Override
        }  
        }
            return delegate.compositeHeapBuffer();
import io.netty.channel.ServerChannel;  
        public ByteBuf ioBuffer(int initialCapacity, int maxCapacity) {
 * You may obtain a copy of the License at  
package org.opensearch.transport;
                );
 * not use this file except in compliance with the License.
import org.opensearch.monitor.jvm.JvmInfo;
            return CopyBytesServerSocketChannel.class;
                    + new ByteSizeValue(SUGGESTED_MAX_ALLOCATION_SIZE)
            return heapBuffer(initialCapacity, maxCapacity);
    private static boolean useDefaultChunkAndPageSize() {
import io.netty.buffer.CompositeByteBuf;
                    if (g1gcEnabled == false || g1gcRegionSizeIsKnown == false || g1gcRegionSizeInBytes >= (4 * 1024 * 1024)) {  
 * specific language governing permissions and limitations
                } else {
