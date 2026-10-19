     * Creates the {@link AsyncResponseConsumer}, called once per request attempt.
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        @Override  
package org.opensearch.client;
     */
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        /**  
/*
    }
    /**
 */
    class HeapBufferedResponseConsumerFactory implements HttpAsyncResponseConsumerFactory {
        /**  
 */
         */
        private final int bufferLimit;
 * Modifications Copyright OpenSearch Contributors. See
     * Creates one instance of {@link HeapBufferedAsyncResponseConsumer} for each request attempt, with a configurable
 * under the License.  
 */  
         * Creates a {@link HeapBufferedResponseConsumerFactory} instance with the given buffer limit.
 * You may obtain a copy of the License at  
     * Creates the default type of {@link AsyncResponseConsumer}, based on heap buffering with a buffer limit of 100MB.  
 * performRequest methods that accept an {@link HttpAsyncResponseConsumerFactory} instance as argument.
 * The OpenSearch Contributors require contributions made to  
        public HeapBufferedResponseConsumerFactory(int bufferLimitBytes) {
    /**
 */  
import org.opensearch.client.nio.HeapBufferedAsyncResponseConsumer;  
 * specific language governing permissions and limitations
 *
        }  
/*  
 *  
 * Factory used to create instances of {@link AsyncResponseConsumer}. Each request retry needs its own instance of the
        public AsyncResponseConsumer<ClassicHttpResponse> createHttpAsyncResponseConsumer() {
 * consumer object. Users can implement this interface and pass their own instance to the specialized  
         */
     * Default factory used to create instances of {@link AsyncResponseConsumer}.
 * compatible open source license.
/**
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
 * this work for additional information regarding copyright
/*  
    AsyncResponseConsumer<ClassicHttpResponse> createHttpAsyncResponseConsumer();
 *    http://www.apache.org/licenses/LICENSE-2.0
        static final int DEFAULT_BUFFER_LIMIT = 100 * 1024 * 1024;
}
import static org.opensearch.client.HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory.DEFAULT_BUFFER_LIMIT;
            return new HeapBufferedAsyncResponseConsumer(bufferLimit);
 * Licensed to Elasticsearch under one or more contributor  
        }
 * ownership. Elasticsearch licenses this file to you under  
            this.bufferLimit = bufferLimitBytes;  
 * KIND, either express or implied.  See the License for the
         * Creates the {@link AsyncResponseConsumer}, called once per request attempt.
     */
    HttpAsyncResponseConsumerFactory DEFAULT = new HeapBufferedResponseConsumerFactory(DEFAULT_BUFFER_LIMIT);
        // default buffer limit is 100MB
    /**  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.hc.core5.http.ClassicHttpResponse;
         *
         * @param bufferLimitBytes the buffer limit to be applied to this instance  
 * GitHub history for details.
     * buffer limit which defaults to 100MB.  
public interface HttpAsyncResponseConsumerFactory {  
