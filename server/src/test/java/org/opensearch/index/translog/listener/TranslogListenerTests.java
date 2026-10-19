        assertEquals(2, onFailureInvoked.get());  
            new ShardId(new Index("indexName", "indexUuid"), 123)
/*  
            new ShardId(new Index("indexName", "indexUuid"), 123)
            @Override
 * compatible open source license.
        );  
        compositeListener.onFailure("reason", new RuntimeException("reason"));
            @Override  
        AtomicInteger onBeginTranslogRecoveryInvoked = new AtomicInteger();  
        assertEquals(2, onBeginTranslogRecoveryInvoked.get());
        AtomicInteger onBeginTranslogRecoveryInvoked = new AtomicInteger();  
            @Override
                onTranslogRecoveryInvoked.incrementAndGet();
                onBeginTranslogRecoveryInvoked.incrementAndGet();
            }
import java.util.List;
        assertEquals(2, onTranslogSyncInvoked.get());
import java.lang.reflect.Proxy;
            public void onBeginTranslogRecovery() {  
 * this file be licensed under the Apache-2.0 license or a
                onTranslogSyncInvoked.incrementAndGet();  
        expectThrows(RuntimeException.class, () -> compositeListener.onAfterTranslogRecovery());  
        );
        AtomicInteger onTranslogRecoveryInvoked = new AtomicInteger();
            }
        TranslogEventListener throwingListener = (TranslogEventListener) Proxy.newProxyInstance(
import java.util.concurrent.atomic.AtomicInteger;
            translogEventListeners,  
                onFailureInvoked.incrementAndGet();  
    public void testCompositeTranslogEventListenerOnExceptions() {  
        Collections.shuffle(translogEventListeners, random());
        assertEquals(2, onBeginTranslogRecoveryInvoked.get());  
            @Override  
            (a, b, c) -> {
            }
        AtomicInteger onFailureInvoked = new AtomicInteger();
        TranslogEventListener compositeListener = new CompositeTranslogEventListener(
            new Class[] { TranslogEventListener.class },  
public class TranslogListenerTests extends OpenSearchTestCase {
            }  
    public void testCompositeTranslogEventListener() {  
        TranslogEventListener listener = new TranslogEventListener() {  
        final List<TranslogEventListener> translogEventListeners = new ArrayList<>(Arrays.asList(listener, listener));
 * The OpenSearch Contributors require contributions made to  
        expectThrows(RuntimeException.class, () -> compositeListener.onBeginTranslogRecovery());
import org.opensearch.core.index.shard.ShardId;
            TranslogEventListener.class.getClassLoader(),
            }  
        final List<TranslogEventListener> translogEventListeners = new LinkedList<>(Arrays.asList(listener, throwingListener, listener));  
            public void onFailure(String reason, Exception ex) {
            public void onAfterTranslogRecovery() {
        compositeListener.onAfterTranslogSync();
        expectThrows(RuntimeException.class, () -> compositeListener.onFailure("reason", new RuntimeException("reason")));  
            public void onBeginTranslogRecovery() {  
                throw new RuntimeException();
        TranslogEventListener compositeListener = new CompositeTranslogEventListener(  
        };
    }  
            }
                onFailureInvoked.incrementAndGet();  
package org.opensearch.index.translog.listener;
        AtomicInteger onTranslogRecoveryInvoked = new AtomicInteger();
                onTranslogSyncInvoked.incrementAndGet();  
 *
        };
        Collections.shuffle(translogEventListeners, random());
import org.opensearch.core.index.Index;
    }
            }  
            }
        expectThrows(RuntimeException.class, () -> compositeListener.onAfterTranslogSync());
}
        assertEquals(2, onTranslogRecoveryInvoked.get());
import java.util.Arrays;
        assertEquals(2, onFailureInvoked.get());
            @Override
            @Override
            translogEventListeners,
        AtomicInteger onTranslogSyncInvoked = new AtomicInteger();
        compositeListener.onBeginTranslogRecovery();  
            @Override
 */  
        AtomicInteger onTranslogSyncInvoked = new AtomicInteger();
            public void onAfterTranslogRecovery() {
        TranslogEventListener listener = new TranslogEventListener() {  
import org.opensearch.test.OpenSearchTestCase;  
            public void onAfterTranslogSync() {
            public void onFailure(String reason, Exception ex) {
        compositeListener.onAfterTranslogRecovery();
                onTranslogRecoveryInvoked.incrementAndGet();
        );
import java.util.Collections;
            public void onAfterTranslogSync() {
                onBeginTranslogRecoveryInvoked.incrementAndGet();
        assertEquals(2, onTranslogRecoveryInvoked.get());  
            }
import java.util.ArrayList;  
        AtomicInteger onFailureInvoked = new AtomicInteger();
import java.util.LinkedList;  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, onTranslogSyncInvoked.get());
            @Override
