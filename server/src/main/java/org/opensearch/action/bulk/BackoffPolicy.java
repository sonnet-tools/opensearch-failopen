        return new ConstantBackoff(checkDelay(delay), maxNumberOfRetries);  
         * Current delay in exponential backoff
     *
     *  
        }  
            return delegate.hasNext();
            int exponentialDelay = (int) Math.min((1L << retries) * baseDelay, maxDelayForRetry);
         */
 * <ul>
        }
    private static TimeValue checkDelay(TimeValue delay) {
    private static final BackoffPolicy NO_BACKOFF = new NoBackoff();  
            return curr < numberOfElements;
        /**  
        public boolean hasNext() {  
        }
 *     <li><code>#hasNext()</code> determines whether the progression has more elements. Return <code>true</code> for infinite progressions
    /**
import java.util.Iterator;  
        @Override
                }
            return TimeValue.timeValueMillis(result);
     * iterator created from it should only be used by a single thread.  
    private static class ExponentialBackoffIterator implements Iterator<TimeValue> {
        @Override
    /**
     * @opensearch.internal
     * @opensearch.internal
        public TimeValue next() {  
        public Iterator<TimeValue> iterator() {  
     * Creates an new exponential backoff policy with a default configuration of 50 ms initial wait period and 8 retries taking
            return delegate.next();
        private final int numberOfElements;  
            this.delegate = delegate;  
        public Iterator<TimeValue> iterator() {  
     *                           Must be &lt;= <code>Integer.MAX_VALUE</code> ms.  
        }
 */
     */
 * <p>
    }
         * There is not any limit for this BackOff.  
        private ExponentialFullJitterBackoff(long baseDelay) {
    }
    }
        }  
        public TimeValue next() {  
    /**
     * @param maxDelayForRetry MaxDelay that can be returned from backoff policy  
        @Override
            if (!hasNext()) {
    }  
            this.maxDelayForRetry = maxDelayForRetry;
            if (!hasNext()) {  
 * software distributed under the License is distributed on an
            return new ExponentialFullJitterBackoffIterator(baseDelay);
                }
     */
            return new ConstantBackoffIterator(delay, numberOfElements);
    }
            return true;
        }
         * NOTE: If the value is greater than 30, there can be integer overflow
 */
        private int currentlyConsumed;  
            this.numberOfElements = numberOfElements;
     *
     *  It provides exponential backoff between retries until it reaches maxDelayForRetry.
     * iterator created from it should only be used by a single thread.
     *
    }
            retriesAttempted++;
        }  
        private ExponentialFullJitterBackoffIterator(long baseDelay) {
        private final Iterator<TimeValue> delegate;
    }
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
        }  
         *
        private final int numberOfElements;  
        }
    private static final class ConstantBackoffIterator implements Iterator<TimeValue> {
        private final int RETRIES_TILL_JITTER_INCREASE = 30;
         */
    public static BackoffPolicy exponentialBackoff() {
        }  
        public TimeValue next() {
            this.onBackoff = onBackoff;  
 * ownership. Elasticsearch licenses this file to you under  
     * Concrete Exponential Back Off Iterator  
            assert start >= 0;
    /**  
        @Override  
        return new ExponentialFullJitterBackoff(baseDelay);  
     * iterator created from it should only be used by a single thread.  
    private static final class WrappedBackoffIterator implements Iterator<TimeValue> {  
        return new ExponentialBackoff((int) checkDelay(initialDelay).millis(), maxNumberOfRetries);  
 *  
        private final long baseDelay;
                    throw new NoSuchElementException("No backoff");  
                @Override
 * The underlying mathematical principle of <code>BackoffPolicy</code> are progressions which can be either finite or infinite although  
    }  
            TimeValue delayToReturn = TimeValue.timeValueMillis(Randomness.get().nextInt(Math.toIntExact(currentDelay)) + 1);
            this.maxDelayForRetry = maxDelayForRetry;
     */  
        private final long baseDelay;
         * Retry limit to avoids integer overflow issues.
        private final long maxDelayForRetry;  
     * @param initialDelay       The initial delay defines how long to wait for the first retry attempt. Must not be null.
        return exponentialBackoff(TimeValue.timeValueMillis(50), 8);
    /**
            this.onBackoff = onBackoff;
            return new WrappedBackoffIterator(delegate.iterator(), onBackoff);  
            this.numberOfElements = numberOfElements;
        @Override
 * the latter should not be used for retrying. A progression can be mapped to a <code>java.util.Iterator</code> with the following
            if (false == delegate.hasNext()) {
     * Concrete Constant Back Off Iterator  
     *  
 * Notes for implementing custom subclasses:
            onBackoff.run();
         * This Iterator will always return back off delay.
     */
 * the Apache License, Version 2.0 (the "License"); you may
    public static BackoffPolicy exponentialEqualJitterBackoff(long baseDelay, long maxDelayForRetry) {  
     * Creates an new exponential backoff policy with the provided configuration.  
     * Creates a backoff policy that will not allow any backoff, i.e. an operation will fail after the first attempt.  
            int result = start + 10 * ((int) Math.exp(0.8d * (currentlyConsumed)) - 1);
     * Concrete Wrapped Back Off Iterator
 * @opensearch.internal  
        @Override  
        private final int start;  
        @Override
        private ExponentialBackoff(int start, int numberOfElements) {
 * under the License.  
     * Concrete Exponential Back Off Policy
        private final Runnable onBackoff;
        @Override
     *
            assert numberOfElements >= 0;  
        }
         * Exponential increase in delay will happen till it reaches maxDelayForRetry.
     */  
        @Override
         * @return true  
    /**
     * @return A backoff policy without any backoff period. The returned instance is thread safe.
         */
    }  
     */  
    private static class ExponentialEqualJitterBackoff extends BackoffPolicy {
        }
     * roughly 5.1 seconds in total.
    }
            }
         * @return true
         * There is not any limit for this BackOff.
 * not use this file except in compliance with the License.
     */  
                public boolean hasNext() {  
        }  
import org.opensearch.common.Randomness;  
     *  It uses equal jitter scheme as it is being used for throttled exceptions.
public abstract class BackoffPolicy implements Iterable<TimeValue> {
     *
            this.numberOfElements = numberOfElements;
 * Unless required by applicable law or agreed to in writing,
            }
     * Creates an new constant backoff policy with the provided configuration.  
 *     </li>  
        }
        private final long maxDelayForRetry;
}
    }
     *
        @Override
     * @param delay              The delay defines how long to wait between retry attempts. Must not be null.
            throw new IllegalArgumentException("delay must be <= " + Integer.MAX_VALUE + " ms");  
     */
         * Once delay has exceeded maxDelayForRetry, it will return maxDelayForRetry only
     */  
        }
import org.opensearch.common.unit.TimeValue;
        private int retriesAttempted;
     */
        private ExponentialBackoffIterator(int start, int numberOfElements) {
            return new ExponentialEqualJitterBackoffIterator(baseDelay, maxDelayForRetry);
 * this work for additional information regarding copyright
/**  
    public static BackoffPolicy noBackoff() {
         * This Iterator will always return back off delay.
        }
     */  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new NoSuchElementException();
     * Wraps the backoff policy in one that calls a method every time a new backoff is taken from the policy.
package org.opensearch.action.bulk;
            return TimeValue.timeValueMillis((exponentialDelay / 2) + Randomness.get().nextInt(exponentialDelay / 2 + 1));  
    private static class ExponentialFullJitterBackoff extends BackoffPolicy {
            return true;
        }  
        }
        public Iterator<TimeValue> iterator() {
     *  It will make random distribution and also guarantees a minimum delay.  
        return new ExponentialEqualJitterBackoff(baseDelay, maxDelayForRetry);
     *
            curr++;  
    private static class ExponentialBackoff extends BackoffPolicy {
 * You may obtain a copy of the License at  
     * @return A backoff policy with exponential backoff with equal jitter which can't return delay more than given max delay
     *  It uses full jitter scheme for random distribution.  
            this.delay = delay;
    private static class ExponentialFullJitterBackoffIterator implements Iterator<TimeValue> {
        private final BackoffPolicy delegate;
            this.start = start;  
        private long currentDelay;  
        ConstantBackoff(TimeValue delay, int numberOfElements) {
    }  
            this.delegate = delegate;
/*
        private ExponentialEqualJitterBackoffIterator(long baseDelay, long maxDelayForRetry) {  
/*
            assert numberOfElements >= 0;  
        }
                throw new NoSuchElementException();
        if (delay.millis() > Integer.MAX_VALUE) {
 */
     * @return A backoff policy with a constant wait time between retries. The returned instance is thread safe but each
     * @param baseDelay BaseDelay for exponential Backoff
                throw new NoSuchElementException("Only up to " + numberOfElements + " elements");  
     *  It provides exponential backoff between retries until it reaches Integer.MAX_VALUE.
        public boolean hasNext() {
        return new WrappedBackoffPolicy(delegate, onBackoff);
            return new Iterator<TimeValue>() {
        }  
        private final int numberOfElements;
    }
        /**
    /**
         * and not increase the delay.  
         * Post this limit, max delay will be returned with Equal Jitter.
        }
        public boolean hasNext() {  
        /**  
        /**  
    }  
        private final long baseDelay;  
 * thread pool is full), the backoff policy decides how long the bulk processor will wait before the operation is retried internally.
     * @opensearch.internal
     * @opensearch.internal
        }
     * @opensearch.internal
        public Iterator<TimeValue> iterator() {  
            currentDelay = Math.min(2 * currentDelay, Integer.MAX_VALUE);
        }
     */
    /**
        public Iterator<TimeValue> iterator() {  
 * GitHub history for details.
 *  
    public static BackoffPolicy constantBackoff(TimeValue delay, int maxNumberOfRetries) {
    /**  
     *
        }
     * @param maxNumberOfRetries The maximum number of retries. Must be a non-negative number.
        /**  
            this.delay = delay;
 *     <li><code>#next()</code> determines the next element in the progression, i.e. the next wait time period</li>
 * semantics:
        @Override
     * @param baseDelay BaseDelay for exponential Backoff
        }
     * @return A backoff policy with an exponential increase in wait time for retries. The returned instance is thread safe but each
         * <p>  
                @Override
            int retries = Math.min(retriesAttempted, RETRIES_TILL_JITTER_INCREASE);  
        private final TimeValue delay;
     * @opensearch.internal
        @Override
        }  
            }  
     */
            this.baseDelay = baseDelay;
        return delay;
         */
        @Override  
 * Provides a backoff policy for bulk requests. Whenever a bulk request is rejected due to resource constraints (i.e. the client's internal
    /**
            return delayToReturn;  
            return currentlyConsumed < numberOfElements;  
     * @return A backoff policy with an exponential increase in wait time for retries. The returned instance is thread safe but each
         * issues during delay calculation.
        }  
        private final Runnable onBackoff;  
    /**
        public Iterator<TimeValue> iterator() {  
    /**  
    }  
     * @opensearch.internal  
 */  
        WrappedBackoffPolicy(BackoffPolicy delegate, Runnable onBackoff) {
 * compatible open source license.
        private int curr;
    }  
        private final int numberOfElements;
 *
    private static class NoBackoff extends BackoffPolicy {
     *                           Must be &lt;= <code>Integer.MAX_VALUE</code> ms.  
    private static class ExponentialEqualJitterBackoffIterator implements Iterator<TimeValue> {
                    return false;
    private static final class WrappedBackoffPolicy extends BackoffPolicy {
 * <p>  
     * @return A backoff policy with exponential backoff with full jitter.  
 *
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    /**
import java.util.NoSuchElementException;
        public boolean hasNext() {
    }  
            };
        public boolean hasNext() {
    private static final class ConstantBackoff extends BackoffPolicy {  
        ConstantBackoffIterator(TimeValue delay, int numberOfElements) {  
            return new ExponentialBackoffIterator(start, numberOfElements);
        public TimeValue next() {
            this.start = start;
     *  
         *  
        @Override
            this.baseDelay = baseDelay;
     *
 * The OpenSearch Contributors require contributions made to  
        private final int start;
     *
     * Concrete Wrapped Back Off Policy  
    }  
 * license agreements. See the NOTICE file distributed with
        private ExponentialEqualJitterBackoff(long baseDelay, long maxDelayForRetry) {  
     * Concrete Constant Back Off Policy
    public static BackoffPolicy exponentialBackoff(TimeValue initialDelay, int maxNumberOfRetries) {
    /**  
        public TimeValue next() {
        return NO_BACKOFF;
 * Note that backoff policies are exposed as <code>Iterables</code> in order to be consumed multiple times.
            return delay;
        WrappedBackoffIterator(Iterator<TimeValue> delegate, Runnable onBackoff) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static BackoffPolicy exponentialFullJitterBackoff(long baseDelay) {
            this.baseDelay = baseDelay;
 * SPDX-License-Identifier: Apache-2.0
    public static BackoffPolicy wrap(BackoffPolicy delegate, Runnable onBackoff) {  
            this.numberOfElements = numberOfElements;
/*  
     * Concrete No Back Off Policy  
 *  
     * @param maxNumberOfRetries The maximum number of retries. Must be a non-negative number.
        @Override
            this.currentDelay = baseDelay;  
                public TimeValue next() {
        @Override
 * </ul>
 *
        private final TimeValue delay;
     */
         **/  
    }
            currentlyConsumed++;  
