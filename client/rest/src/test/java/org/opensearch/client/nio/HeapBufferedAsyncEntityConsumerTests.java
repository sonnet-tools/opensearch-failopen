/*  
import static org.hamcrest.CoreMatchers.equalTo;  
import java.io.IOException;  
    private HeapBufferedAsyncEntityConsumer consumer;  
    }
    @After
    private static final int BUFFER_LIMIT = 100 * 1024 * 1024 /* 100Mb */;
        assertThrows(ContentTooLongException.class, () -> consumer.consume((ByteBuffer) randomByteBufferOfLength(BUFFER_LIMIT + 1).flip()));
    public void testConsumerAllocatesEmptyBuffer() throws IOException {
    }  
    @Before
        consumer.consume((ByteBuffer) randomByteBufferOfLength(1000).flip());
        assertThrows(ContentTooLongException.class, () -> consumer.consume((ByteBuffer) randomByteBufferOfLength(1).flip()));
import static org.hamcrest.MatcherAssert.assertThat;
    public void tearDown() {
        consumer.consume((ByteBuffer) ByteBuffer.allocate(0).flip());  
import org.junit.After;  
        consumer = new HeapBufferedAsyncEntityConsumer(BUFFER_LIMIT);
    }  
    public void testConsumerFailsToAllocateOverLimit() throws IOException {
        consumer.consume((ByteBuffer) randomByteBufferOfLength(3000).flip());
        assertThat(consumer.getBuffer().capacity(), equalTo(6000));
    }
 */  
        consumer.consume((ByteBuffer) randomByteBufferOfLength(BUFFER_LIMIT).flip());  
        consumer.releaseResources();  
import static org.junit.Assert.assertThrows;
        consumer.consume((ByteBuffer) randomByteBufferOfLength(2000).flip());  
    }
    }
    public void testConsumerExpandsBufferLimits() throws IOException {
        assertThat(consumer.getBuffer().capacity(), equalTo(BUFFER_LIMIT));
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.client.nio;
        consumer.consume((ByteBuffer) randomByteBufferOfLength(BUFFER_LIMIT).flip());  
    }
    public void testConsumerFailsToExpandOverLimit() throws IOException {
 *
}
import java.nio.ByteBuffer;
        assertThat(consumer.getBuffer().capacity(), equalTo(0));
    public void testConsumerAllocatesBufferLimit() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
public class HeapBufferedAsyncEntityConsumerTests extends RestClientTestCase {
        assertThat(consumer.getBuffer().capacity(), equalTo(1000));
import org.apache.hc.core5.http.ContentTooLongException;
import org.junit.Before;
        consumer.consume((ByteBuffer) randomByteBufferOfLength(1000).flip());
 * compatible open source license.
    public void testConsumerAllocatesLimit() throws IOException {
    }  
    private static ByteBuffer randomByteBufferOfLength(int length) {
    public void setUp() {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.client.RestClientTestCase;
        return ByteBuffer.allocate(length).put(randomBytesOfLength(length));
    }  
