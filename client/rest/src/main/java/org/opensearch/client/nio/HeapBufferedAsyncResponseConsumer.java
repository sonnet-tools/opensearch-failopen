 */  
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;  
    public HeapBufferedAsyncResponseConsumer(int bufferLimit) {  
import org.apache.hc.core5.http.protocol.HttpContext;
 *
 * not use this file except in compliance with the License.
        return classicResponse;  
        classicResponse.setVersion(response.getVersion());
        classicResponse.setReasonPhrase(response.getReasonPhrase());  
/*  
 * GitHub history for details.
     * Creates a new instance of this consumer with the provided buffer limit.
 *
                LOGGER.debug("Unable to detect content encoding", ex);
        if (entity != null) {
     */
     * @param context the actual execution context.
 * specific language governing permissions and limitations
        }  
 * Unless required by applicable law or agreed to in writing,
     * @param response the response message.
    /**  
 */  
            classicResponse.setLocale(response.getLocale());
    @Override  
    public int getBufferLimit() {
package org.opensearch.client.nio;
import java.io.IOException;  
     *
     */  
                if (contentEncoding != null) {
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Triggered to signal receipt of an intermediate (1xx) HTTP response.
import org.apache.hc.core5.http.HttpException;  
 */
     * Triggered to generate object that represents a result of response message processing.
/*
import org.apache.commons.logging.LogFactory;
 * this work for additional information regarding copyright
        super(new HeapBufferedAsyncEntityConsumer(bufferLimit));
import org.apache.hc.core5.http.nio.support.AbstractAsyncResponseConsumer;  
    private final int bufferLimit;
    /**  
                    encoding = contentEncoding.getValue();
     *
 * license agreements. See the NOTICE file distributed with
/**
 * Limits the size of responses that can be read based on a configurable argument. Throws an exception in case the entity is longer
    public void informationResponse(final HttpResponse response, final HttpContext context) throws HttpException, IOException {}
 * under the License.  
 * You may obtain a copy of the License at  
 */
 * The OpenSearch Contributors require contributions made to  
import org.apache.hc.core5.http.ContentType;
 * Default implementation of {@link AsyncResponseConsumer}. Buffers the whole  
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
                final Header contentEncoding = response.getHeader(HttpHeaders.CONTENT_ENCODING);  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.apache.hc.core5.http.Header;
    }
     * @param response the intermediate (1xx) HTTP response.  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
    protected ClassicHttpResponse buildResult(final HttpResponse response, final byte[] entity, final ContentType contentType) {
    /**  
 * ownership. Elasticsearch licenses this file to you under  
}
            classicResponse.setEntity(httpEntity);  
            try {
public class HeapBufferedAsyncResponseConsumer extends AbstractAsyncResponseConsumer<ClassicHttpResponse, byte[]> {
        return bufferLimit;  
import org.apache.hc.core5.http.ClassicHttpResponse;  
 * KIND, either express or implied.  See the License for the
        classicResponse.setHeaders(response.getHeaders());
     */
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
     * @param entity the response entity.  
/*  
    @Override
     * @param bufferLimit the buffer limit. Must be greater than 0.  
     * Get the limit of the buffer.  
            final ByteArrayEntity httpEntity = new ByteArrayEntity(entity, contentType, encoding);
        final ClassicHttpResponse classicResponse = new BasicClassicHttpResponse(response.getCode());  
 * response content in heap memory, meaning that the size of the buffer is equal to the content-length of the response.
     * @param contentType the response content type.
 * than the configured buffer limit.  
import org.apache.hc.core5.http.HttpResponse;
     */
 * SPDX-License-Identifier: Apache-2.0
            } catch (final HttpException ex) {
 *  
    private static final Log LOGGER = LogFactory.getLog(HeapBufferedAsyncResponseConsumer.class);  
        }
            String encoding = null;  
        this.bufferLimit = bufferLimit;
            }  
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
     * @throws IllegalArgumentException if {@code bufferLimit} is less than or equal to 0.
 * software distributed under the License is distributed on an
        if (response.getLocale() != null) {
 * the Apache License, Version 2.0 (the "License"); you may
    }  
import org.apache.hc.core5.http.HttpHeaders;
     * @return the result of response processing.
import org.apache.commons.logging.Log;
