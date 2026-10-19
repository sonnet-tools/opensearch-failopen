 *
    private Subscription subscription;
        buffers.addAll(item);
    @Override
import java.util.Vector;  
    @Override
    private final List<ByteBuffer> buffers = new Vector<>();  
import java.nio.ByteBuffer;
    public void onComplete() {}  
import java.util.concurrent.Flow.Subscription;
class AsyncResponseProducer implements Subscriber<List<ByteBuffer>> {
}
    @Override
    @Override
        subscription.request(1);
    }  
    public void onNext(List<ByteBuffer> item) {  
 * compatible open source license.
/*  
        subscription.request(1);
        this.subscription = subscription;
package org.opensearch.internal.httpclient;
    public void onSubscribe(Subscription subscription) {  
    public List<ByteBuffer> getResult() {
import java.util.List;
    }  
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.Flow.Subscriber;
    public void onError(Throwable throwable) {}  
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
        return buffers;  
 */  
