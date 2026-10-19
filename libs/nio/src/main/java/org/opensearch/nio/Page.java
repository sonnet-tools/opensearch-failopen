 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this(byteBuffer, () -> {});
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static class RefCountedCloseable extends AbstractRefCounted {  
     *
 *
    private Page(ByteBuffer byteBuffer, RefCountedCloseable refCountedCloseable) {
 * compatible open source license.
        }
    }
        this.byteBuffer = byteBuffer;  
 * this file be licensed under the Apache-2.0 license or a
     * Returns the {@link ByteBuffer} for this page. Modifications to the limits, positions, etc of the
 * license agreements. See the NOTICE file distributed with
/*  
 */  
            this.closeable = closeable;  
 *  
        @Override  
 *
    public Page(ByteBuffer byteBuffer, Runnable closeable) {
        private final Runnable closeable;
 * not use this file except in compliance with the License.
    /**
    // This is reference counted as some implementations want to retain the byte pages by calling  
        refCountedCloseable.decRef();  
        refCountedCloseable.incRef();
 */  
    }
 * under the License.  
    }
    }  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    private final RefCountedCloseable refCountedCloseable;
 * You may obtain a copy of the License at  
    // and safely close the pages independently. The closeable will not be called until each page is
    // released.  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
     */  
import java.nio.ByteBuffer;
/*
            super("byte array page");
    public void close() {
        return new Page(byteBuffer.duplicate(), refCountedCloseable);  
import java.io.Closeable;  
    public ByteBuffer byteBuffer() {  
        }  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * KIND, either express or implied.  See the License for the
     *  
    }
 * SPDX-License-Identifier: Apache-2.0
        private RefCountedCloseable(Runnable closeable) {
 * GitHub history for details.
package org.opensearch.nio;
     * of the original page.  
import org.opensearch.common.util.concurrent.AbstractRefCounted;
 */
    }
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
     * @return the byte buffer
     * @return the new page
        this.refCountedCloseable = refCountedCloseable;
public class Page implements Closeable {  
 * Modifications Copyright OpenSearch Contributors. See
     */
    public Page(ByteBuffer byteBuffer) {  
    /**  
    public Page duplicate() {
     * buffer will also mutate this page. Call {@link ByteBuffer#duplicate()} to avoid mutating the page.
    // duplicate. With reference counting we can increment the reference count, return a new page,
        this(byteBuffer, new RefCountedCloseable(closeable));
        return byteBuffer;
     * Duplicates this page and increments the reference count. The new page must be closed independently
        protected void closeInternal() {
}
            closeable.run();
    @Override
    private final ByteBuffer byteBuffer;
    }
