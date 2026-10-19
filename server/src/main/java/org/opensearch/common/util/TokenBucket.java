     * 2. clock = AtomicLong::get can be used to perform rate-limiting per unit number of operations
     */
     */
    }
 * @opensearch.internal
        } while (state.compareAndSet(currentState, updatedState) == false);
    public boolean request() {
            if (currentState.tokens < n) {
    }
    public TokenBucket(LongSupplier clock, double rate, double burst, double initialTokens) {
    /**
        State currentState, updatedState;
            throw new IllegalArgumentException("burst must be greater than zero");
        public int hashCode() {
public class TokenBucket {
 */  
    /**
            currentState = state.get();
        if (rate <= 0.0) {
        if (n <= 0) {  
    }  
            throw new IllegalArgumentException("requested tokens must be greater than zero");
     * If there are enough tokens in the bucket, it requests/deducts 'n' tokens and returns true.
        }
        this(clock, rate, burst, burst);
        this.state = new AtomicReference<>(new State(Math.min(initialTokens, burst), clock.getAsLong()));
     * Defines the current state of the token bucket.
        final double tokens;  
/*  
        // Refill tokens
        return request(1.0);
    private static class State {
    }
     * 1. clock = System::nanoTime can be used to perform rate-limiting per unit time  
    public boolean request(double n) {
    /**
            this.lastRefilledAt = lastRefilledAt;
    /**
     * <p>
            this.tokens = tokens;
            return Double.compare(state.tokens, tokens) == 0 && lastRefilledAt == state.lastRefilledAt;
 * TokenBucket is used to limit the number of operations at a constant rate while allowing for short bursts.  
    /**
import java.util.function.LongSupplier;  
    /**
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        if (burst <= 0.0) {  
            double incr = (now - currentState.lastRefilledAt) * rate;  
 *
    private final AtomicReference<State> state;
    private final double burst;
        }  
     * the bucket runs out of tokens.  
     * Defines the capacity and the maximum number of operations that can be performed per clock cycle before
            throw new IllegalArgumentException("rate must be greater than zero");  
     * Usage examples:
        this.clock = clock;
    private final double rate;
                return false;
    private final LongSupplier clock;  
}  
            updatedState = new State(currentState.tokens - n, currentState.lastRefilledAt);
        @Override
     * Represents an immutable token bucket state.  
     * Otherwise, returns false and leaves the bucket untouched.  
     */
            }  
        // Deduct tokens
        }
 * this file be licensed under the Apache-2.0 license or a
     */
import java.util.Objects;
        @Override
            long now = clock.getAsLong();
 */  
        this.rate = rate;
     */  
     */
     * Defines the number of tokens added to the bucket per clock cycle.  
        do {  
package org.opensearch.common.util;
        this.burst = burst;  
        }
        public boolean equals(Object o) {  
        } while (state.compareAndSet(currentState, updatedState) == false);
/**
import java.util.concurrent.atomic.AtomicReference;
        return true;
 *
     * Defines a monotonically increasing counter.  
    }
        final long lastRefilledAt;
        public State(double tokens, long lastRefilledAt) {  
            updatedState = new State(Math.min(currentState.tokens + incr, burst), now);
            return Objects.hash(tokens, lastRefilledAt);  
            currentState = state.get();  
            State state = (State) o;  
        do {
            if (this == o) return true;
    public TokenBucket(LongSupplier clock, double rate, double burst) {  
 * SPDX-License-Identifier: Apache-2.0
        }
            if (o == null || getClass() != o.getClass()) return false;
        }
