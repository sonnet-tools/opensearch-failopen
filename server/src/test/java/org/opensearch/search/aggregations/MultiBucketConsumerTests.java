            true,
        MultiBucketConsumerService.MultiBucketConsumer multiBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(  
            1  
            DEFAULT_MAX_BUCKETS,
        MultiBucketConsumerService.MultiBucketConsumer multiBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(  
        }
            false,
            false,
            breaker,
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(CircuitBreakingException.class, () -> multiBucketConsumer.accept(0));
        expectThrows(CircuitBreakingException.class, () -> multiBucketConsumer.accept(0));  
            new LongAdder(),  
    }
            breaker,
import java.util.concurrent.atomic.LongAdder;
        CircuitBreaker breaker = Mockito.mock(CircuitBreaker.class);
        CircuitBreaker breaker = Mockito.mock(CircuitBreaker.class);
 */  
 * this file be licensed under the Apache-2.0 license or a
    public void testMultiConsumerAcceptWhenCBTripped() {
        Mockito.verify(breaker, Mockito.times(0)).addEstimateBytesAndMaybeBreak(0, "allocated_buckets");
        Mockito.verify(breaker, Mockito.times(0)).addEstimateBytesAndMaybeBreak(0, "allocated_buckets");  
        CircuitBreaker breaker = Mockito.mock(CircuitBreaker.class);
            callCount.increment();
            DEFAULT_MAX_BUCKETS,
            DEFAULT_MAX_BUCKETS,
        LongAdder callCount = new LongAdder();
    public void testMultiConsumerAccept() {
            1
        Mockito.when(breaker.addEstimateBytesAndMaybeBreak(0, "allocated_buckets")).thenThrow(CircuitBreakingException.class);
import org.opensearch.core.common.breaker.CircuitBreaker;
        // circuit breaker check is performed as the value of call count would be 1025 which is still in range
        MultiBucketConsumerService.MultiBucketConsumer multiBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
    }
        multiBucketConsumer.accept(0);  
        );  
        );
import org.opensearch.core.common.breaker.CircuitBreakingException;
        // exception is thrown upfront since the circuit breaker has already tripped
        // no exception is thrown as the call count value is not in the expected range and CB is not checked
}  
            callCount,
import org.mockito.Mockito;
        for (int i = 0; i < 1024; i++) {  
 *
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
            callCount,  
        LongAdder callCount = new LongAdder();  
            breaker,  
import static org.opensearch.search.aggregations.MultiBucketConsumerService.DEFAULT_MAX_BUCKETS;  
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.search.aggregations;
public class MultiBucketConsumerTests extends OpenSearchTestCase {
            2
        }  
        );  
    public void testMultiConsumerAcceptToTripCB() {  
        Mockito.verify(breaker, Mockito.times(1)).addEstimateBytesAndMaybeBreak(0, "allocated_buckets");
        for (int i = 0; i < 1100; i++) {
    }
            callCount.increment();
