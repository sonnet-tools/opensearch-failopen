 * Rate limiting wrapper for InputStream
 * You may obtain a copy of the License at  
/**  
    }
/*  
import java.io.InputStream;  
 * The OpenSearch Contributors require contributions made to  
            streamLimiter.maybePause(n);
 */
 * specific language governing permissions and limitations
 *
/*
import java.util.function.Supplier;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.FilterInputStream;
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        int b = super.read();
 */
 * KIND, either express or implied.  See the License for the
 *
 */  
 */  
    private final StreamLimiter streamLimiter;
    public int read(byte[] b, int off, int len) throws IOException {
        int n = super.read(b, off, len);
package org.opensearch.index.snapshots.blobstore;
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal  
    }
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        return n;  
import java.io.IOException;
    public RateLimitingInputStream(InputStream delegate, Supplier<RateLimiter> rateLimiterSupplier, StreamLimiter.Listener listener) {  
        super(delegate);
import org.apache.lucene.store.RateLimiter;
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        streamLimiter.maybePause(1);
        if (n > 0) {  
    @Override  
        return b;  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    @Override
/*  
import org.opensearch.common.StreamLimiter;
 * Modifications Copyright OpenSearch Contributors. See
}
 *  
public class RateLimitingInputStream extends FilterInputStream {
 * the Apache License, Version 2.0 (the "License"); you may
        this.streamLimiter = new StreamLimiter(rateLimiterSupplier, listener);
 * this work for additional information regarding copyright
    public int read() throws IOException {  
 * under the License.  
 *
