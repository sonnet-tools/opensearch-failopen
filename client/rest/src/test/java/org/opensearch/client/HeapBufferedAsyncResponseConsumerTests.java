            assertEquals("bufferLimit must be greater than 0", e.getMessage());
        Object object = constructor.newInstance(bufferLimit);
        IllegalAccessException, InvocationTargetException, InstantiationException {
        HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory consumerFactory =
import org.apache.hc.core5.http.ClassicHttpResponse;
        } catch (ContentTooLongException e) {  
    }
 * SPDX-License-Identifier: Apache-2.0
        bufferLimitTest(consumer, bufferLimit);  
/*  
import java.io.IOException;
            }
import static org.hamcrest.CoreMatchers.instanceOf;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testConfiguredBufferLimit() throws Exception {
            public boolean isStreaming() {
 * this work for additional information regarding copyright
}
 */
        consumer.consumeResponse(response, null, httpContext, null);
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
        };
            }
import java.util.concurrent.atomic.AtomicReference;
            public long getContentLength() {
import org.apache.hc.core5.http.protocol.HttpContext;
package org.opensearch.client;
        } catch (IllegalArgumentException e) {
        assertThat(object, instanceOf(HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory.class));  
 * Unless required by applicable law or agreed to in writing,
        AsyncResponseConsumer<ClassicHttpResponse> consumer = consumerFactory.createHttpAsyncResponseConsumer();  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.ByteArrayInputStream;
        } catch (IllegalArgumentException e) {
        }
import java.lang.reflect.Modifier;  
import org.apache.hc.core5.http.EntityDetails;
    private static void bufferLimitTest(HeapBufferedAsyncResponseConsumer consumer, int bufferLimit) throws Exception {
            Integer.TYPE
    }
        HttpEntity entity = new AbstractHttpEntity(ContentType.APPLICATION_JSON, null, false) {
 * this file be licensed under the Apache-2.0 license or a
        );  
    public void testHttpAsyncResponseConsumerFactoryVisibility() throws ClassNotFoundException {  
    public void testDefaultBufferLimit() throws Exception {  
            @Override
        }  
 * compatible open source license.
                "entity content is too long [" + entity.getContentLength() + "] for the configured buffer limit [" + bufferLimit + "]",
        }
                return contentLength.get();
import org.opensearch.client.nio.HeapBufferedAsyncResponseConsumer;
        assertEquals(Modifier.PUBLIC, HttpAsyncResponseConsumerFactory.class.getModifiers() & Modifier.PUBLIC);
                return false;  
    public void testCanConfigureHeapBufferLimitFromOutsidePackage() throws ClassNotFoundException, NoSuchMethodException,  
        consumer.consumeResponse(response, details, httpContext, null);
        int bufferLimit = randomIntBetween(1, MAX_TEST_BUFFER_SIZE - 100);
 *  
            }  
 *
        response.setEntity(entity);
            public void close() throws IOException {}
    }
 * under the License.  
        final AtomicReference<Long> contentLength = new AtomicReference<>();
            );
import java.lang.reflect.Constructor;
            @Override  
 */  
/*  
import org.apache.hc.core5.http.io.entity.AbstractHttpEntity;
 * not use this file except in compliance with the License.
    private static final int TEST_BUFFER_LIMIT = 10 * 1024 * 1024;
 */  
import org.apache.hc.core5.http.impl.BasicEntityDetails;  
    }  
                e.getMessage()  
        try {
        assertEquals(Modifier.PUBLIC, constructor.getModifiers() & Modifier.PUBLIC);
 * specific language governing permissions and limitations
        HeapBufferedAsyncResponseConsumer consumer = new HeapBufferedAsyncResponseConsumer(TEST_BUFFER_LIMIT);
            @Override  
 * Licensed to Elasticsearch under one or more contributor  
            @Override
import static org.junit.Assert.assertThat;  
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import java.io.InputStream;  
            assertEquals(
        HeapBufferedAsyncResponseConsumer consumer = new HeapBufferedAsyncResponseConsumer(bufferLimit);
import java.lang.reflect.InvocationTargetException;
    // maximum buffer that this test ends up allocating is 50MB
import static org.mockito.Mockito.mock;
        assertThat(consumer, instanceOf(HeapBufferedAsyncResponseConsumer.class));
        contentLength.set(randomLongBetween(bufferLimit + 1, MAX_TEST_BUFFER_SIZE));  
import static org.junit.Assert.assertEquals;
        final EntityDetails details = new BasicEntityDetails(4096, ContentType.APPLICATION_JSON);  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
            (HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory) object;
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;  
        try {
import org.apache.hc.core5.http.HttpEntity;
        // we use reflection to make sure that the class can be instantiated from the outside, and the constructor is public  
            new HeapBufferedAsyncResponseConsumer(randomIntBetween(Integer.MIN_VALUE, 0));
public class HeapBufferedAsyncResponseConsumerTests extends RestClientTestCase {  
        contentLength.set(randomLongBetween(0L, bufferLimit));  
        try {  
            consumer.consumeResponse(response, details, httpContext, null);
 * You may obtain a copy of the License at  
 *
    private static final int MAX_TEST_BUFFER_SIZE = 50 * 1024 * 1024;  
            assertEquals("bufferLimit must be greater than 0", e.getMessage());  
        int bufferLimit = randomIntBetween(1, Integer.MAX_VALUE);
 * The OpenSearch Contributors require contributions made to  
    }  
        HttpContext httpContext = mock(HttpContext.class);
        assertEquals(bufferLimit, bufferedAsyncResponseConsumer.getBufferLimit());  
            new HeapBufferedAsyncResponseConsumer(0);  
            public InputStream getContent() throws IOException, UnsupportedOperationException {  
import org.apache.hc.core5.http.ContentTooLongException;
        bufferLimitTest(consumer, TEST_BUFFER_LIMIT);
        HeapBufferedAsyncResponseConsumer bufferedAsyncResponseConsumer = (HeapBufferedAsyncResponseConsumer) consumer;
                return new ByteArrayInputStream("".getBytes(StandardCharsets.UTF_8));
import java.nio.charset.StandardCharsets;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BasicClassicHttpResponse response = new BasicClassicHttpResponse(200, "OK");
        Constructor<?> constructor = HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory.class.getConstructor(
 * software distributed under the License is distributed on an
import org.apache.hc.core5.http.ContentType;  
