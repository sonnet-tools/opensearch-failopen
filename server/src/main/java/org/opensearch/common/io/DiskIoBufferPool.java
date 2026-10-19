 * @opensearch.internal
/*  
    }
            "[" + ThreadPool.Names.WRITE + "]",  
 */  
public class DiskIoBufferPool {  
    public static ByteBuffer getIoBuffer() {  
            return ByteBuffer.allocateDirect(BUFFER_SIZE);  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * Pool of disk io buffers
        return ioBuffer;  
 *
            if (threadName.contains(s)) {
 * SPDX-License-Identifier: Apache-2.0
/**
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    public static final int BUFFER_SIZE = StrictMath.toIntExact(
        ioBuffer.clear();
}
/*  
        return false;
        ByteSizeValue.parseBytesSizeValue(  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
/*
            "opensearch.disk_io.direct.buffer.size"
 * specific language governing permissions and limitations
    public static final int HEAP_BUFFER_SIZE = 8 * 1024;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    });
import org.opensearch.core.common.unit.ByteSizeValue;
        if (isWriteOrFlushThread()) {
 * GitHub history for details.
            "[" + ThreadPool.Names.FLUSH + "]",
package org.opensearch.common.io;
 * compatible open source license.
                return true;
 *
    );
        for (String s : Arrays.asList(
        ByteBuffer ioBuffer = ioBufferPool.get();
import org.opensearch.threadpool.ThreadPool;
    }  
        ).getBytes()  
 */
    private static final ThreadLocal<ByteBuffer> ioBufferPool = ThreadLocal.withInitial(() -> {
        }  
 * KIND, either express or implied.  See the License for the
            System.getProperty("opensearch.disk_io.direct.buffer.size", "64KB"),
        } else {
import java.util.Arrays;
 *  
 */
import java.nio.ByteBuffer;
    private static boolean isWriteOrFlushThread() {  
        }
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * license agreements. See the NOTICE file distributed with
            }  
        String threadName = Thread.currentThread().getName();
            return ByteBuffer.allocate(HEAP_BUFFER_SIZE);
            "[" + ThreadPool.Names.SYSTEM_WRITE + "]"
 *  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
        )) {  
 * this work for additional information regarding copyright
