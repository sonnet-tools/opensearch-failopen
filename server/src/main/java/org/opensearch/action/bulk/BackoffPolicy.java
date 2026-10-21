 *
     */
        if (delay.millis() > Integer.MAX_VALUE) {
        @Override
        private final int numberOfElements;
        }
        private ExponentialBackoffIterator(int start, int numberOfElements) {
    }
         */
        private ExponentialBackoff(int start, int numberOfElements) {
        private long currentDelay;
        public TimeValue next() {
        private final int numberOfElements;
    private static final BackoffPolicy NO_BACKOFF = new NoBackoff();
     * Creates an new exponential backoff policy with the provided configuration.
            return new ExponentialBackoffIterator(start, numberOfElements);
    private static class ExponentialFullJitterBackoffIterator implements Iterator<TimeValue> {
    private static class ExponentialEqualJitterBackoff extends BackoffPolicy {
     * @opensearch.internal
 *
 * Unless required by applicable law or agreed to in writing,
            currentlyConsumed++;
 */
        private ExponentialFullJitterBackoff(long baseDelay) {
     *
     *
public abstract class BackoffPolicy implements Iterable<TimeValue> {
 *
     * @return A backoff policy with exponential backoff with full jitter.
            return delegate.next();
     * @param initialDelay       The initial delay defines how long to wait for the first retry attempt. Must not be null.
 * @opensearch.internal
        private final BackoffPolicy delegate;
    }
 * the latter should not be used for retrying. A progression can be mapped to a <code>java.util.Iterator</code> with the following
 */
 *     <li><code>#next()</code> determines the next element in the progression, i.e. the next wait time period</li>
        private final int start;
 * the Apache License, Version 2.0 (the "License"); you may
     *                           Must be &lt;= <code>Integer.MAX_VALUE</code> ms.
            this.onBackoff = onBackoff;
    private static final class ConstantBackoff extends BackoffPolicy {
    }
        private final int start;
     * @param maxNumberOfRetries The maximum number of retries. Must be a non-negative number.
    /**
     */
        public boolean hasNext() {
 * GitHub history for details.
        public Iterator<TimeValue> iterator() {
        }
 * ownership. Elasticsearch licenses this file to you under
            if (false == delegate.hasNext()) {
                    throw new NoSuchElementException("No backoff");
     */
        public Iterator<TimeValue> iterator() {
            this.maxDelayForRetry = maxDelayForRetry;
     *
        /**
        @Override
     * @opensearch.internal
        }
            throw new IllegalArgumentException("delay must be <= " + Integer.MAX_VALUE + " ms");
 * <p>
        public Iterator<TimeValue> iterator() {
     * Concrete Wrapped Back Off Iterator
        private ExponentialEqualJitterBackoff(long baseDelay, long maxDelayForRetry) {
                    return false;
     * @return A backoff policy with a constant wait time between retries. The returned instance is thread safe but each
        @Override
     * iterator created from it should only be used by a single thread.
                public TimeValue next() {
            currentDelay = Math.min(2 * currentDelay, Integer.MAX_VALUE);
 * </ul>
        }
    /**
         * NOTE: If the value is greater than 30, there can be integer overflow
 * <p>
    }
     * @return A backoff policy without any backoff period. The returned instance is thread safe.
        private final int numberOfElements;
     * @opensearch.internal
            this.delegate = delegate;
        }
            this.delay = delay;
            return new ExponentialEqualJitterBackoffIterator(baseDelay, maxDelayForRetry);
     */
 * Note that backoff policies are exposed as <code>Iterables</code> in order to be consumed multiple times.
        return new ExponentialFullJitterBackoff(baseDelay);
     * Creates an new exponential backoff policy with a default configuration of 50 ms initial wait period and 8 retries taking
    }
            return new ConstantBackoffIterator(delay, numberOfElements);
    private static TimeValue checkDelay(TimeValue delay) {
        public Iterator<TimeValue> iterator() {
     *                           Must be &lt;= <code>Integer.MAX_VALUE</code> ms.
        @Override
 * this work for additional information regarding copyright
        @Override
            this.start = start;
            return TimeValue.timeValueMillis(result);
            return curr < numberOfElements;
        private final long maxDelayForRetry;
     */
     * iterator created from it should only be used by a single thread.
    }
        @Override
            return new ExponentialFullJitterBackoffIterator(baseDelay);
         * There is not any limit for this BackOff.
    private static class ExponentialEqualJitterBackoffIterator implements Iterator<TimeValue> {
        private final long baseDelay;
     * iterator created from it should only be used by a single thread.
 * compatible open source license.
        @Override
            }
        }
    private static class ExponentialBackoff extends BackoffPolicy {
    public static BackoffPolicy exponentialBackoff(TimeValue initialDelay, int maxNumberOfRetries) {
    /**
        return new ExponentialBackoff((int) checkDelay(initialDelay).millis(), maxNumberOfRetries);
     */
            return delay;
 * thread pool is full), the backoff policy decides how long the bulk processor will wait before the operation is retried internally.
    /**
     *
            if (!hasNext()) {
     *
import java.util.NoSuchElementException;
 * The OpenSearch Contributors require contributions made to
         *
 * The underlying mathematical principle of <code>BackoffPolicy</code> are progressions which can be either finite or infinite although
     * @param baseDelay BaseDelay for exponential Backoff
        }
        private ExponentialEqualJitterBackoffIterator(long baseDelay, long maxDelayForRetry) {
            return TimeValue.timeValueMillis((exponentialDelay / 2) + Randomness.get().nextInt(exponentialDelay / 2 + 1));
         **/
 * semantics:
            this.baseDelay = baseDelay;
            this.numberOfElements = numberOfElements;
         * issues during delay calculation.
        }
            retriesAttempted++;
            this.baseDelay = baseDelay;
    }
        private int retriesAttempted;
        return delay;
}
     * Concrete Constant Back Off Policy
     */
            return delegate.hasNext();
         * Current delay in exponential backoff
        public TimeValue next() {
        }
        private final Iterator<TimeValue> delegate;
     *
        /**
    }
            return currentlyConsumed < numberOfElements;
    private static class ExponentialFullJitterBackoff extends BackoffPolicy {
        }
    private static final class ConstantBackoffIterator implements Iterator<TimeValue> {
     *
    }
            TimeValue delayToReturn = TimeValue.timeValueMillis(Randomness.get().nextInt(Math.toIntExact(currentDelay)) + 1);
     *  It uses full jitter scheme for random distribution.
            this.baseDelay = baseDelay;
        public Iterator<TimeValue> iterator() {
        private int currentlyConsumed;
    private static final class WrappedBackoffPolicy extends BackoffPolicy {
    private static class NoBackoff extends BackoffPolicy {
        public TimeValue next() {
        return new ConstantBackoff(checkDelay(delay), maxNumberOfRetries);
        }
        public boolean hasNext() {
import org.opensearch.common.unit.TimeValue;
     * @param baseDelay BaseDelay for exponential Backoff
                public boolean hasNext() {
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
 * not use this file except in compliance with the License.
     *
            return true;
     * Creates a backoff policy that will not allow any backoff, i.e. an operation will fail after the first attempt.
import org.opensearch.common.Randomness;
        }
        /**
     *
         */
    /**
     * @opensearch.internal
     * @opensearch.internal
    /**
        }
        }
            assert numberOfElements >= 0;
        private final int RETRIES_TILL_JITTER_INCREASE = 30;
     *
     * @param maxNumberOfRetries The maximum number of retries. Must be a non-negative number.
    /**
         * Retry limit to avoids integer overflow issues.
 * license agreements. See the NOTICE file distributed with
         * Post this limit, max delay will be returned with Equal Jitter.
         *
/*
            };
         * This Iterator will always return back off delay.
    public static BackoffPolicy wrap(BackoffPolicy delegate, Runnable onBackoff) {
         * Exponential increase in delay will happen till it reaches maxDelayForRetry.
        private final int numberOfElements;
         * There is not any limit for this BackOff.
            assert numberOfElements >= 0;
     * Wraps the backoff policy in one that calls a method every time a new backoff is taken from the policy.
            if (!hasNext()) {
     * @return A backoff policy with exponential backoff with equal jitter which can't return delay more than given max delay
        private final TimeValue delay;
            return delayToReturn;
     *
        return new WrappedBackoffPolicy(delegate, onBackoff);
/*
    /**
     * Concrete Exponential Back Off Iterator
            int retries = Math.min(retriesAttempted, RETRIES_TILL_JITTER_INCREASE);
        /**
     * @opensearch.internal
        }
    }
            }
            this.numberOfElements = numberOfElements;
        private final Runnable onBackoff;
 * under the License.
        @Override
        public boolean hasNext() {
     */
        }
        WrappedBackoffPolicy(BackoffPolicy delegate, Runnable onBackoff) {
    }
 *     </li>
 *
    public static BackoffPolicy exponentialEqualJitterBackoff(long baseDelay, long maxDelayForRetry) {
    /**
    /**
     */
     * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                throw new NoSuchElementException("Only up to " + numberOfElements + " elements");
            this.onBackoff = onBackoff;
        private int curr;
        }
            int exponentialDelay = (int) Math.min((1L << retries) * baseDelay, maxDelayForRetry);
     */
    public static BackoffPolicy exponentialBackoff() {
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        /**
        public TimeValue next() {
import java.util.Iterator;
     */
        @Override
    }
        private ExponentialFullJitterBackoffIterator(long baseDelay) {
         */
     */
     * @return A backoff policy with an exponential increase in wait time for retries. The returned instance is thread safe but each
        private final TimeValue delay;
        return exponentialBackoff(TimeValue.timeValueMillis(50), 8);
 * Provides a backoff policy for bulk requests. Whenever a bulk request is rejected due to resource constraints (i.e. the client's internal
     *
 */
        }
     * @return A backoff policy with an exponential increase in wait time for retries. The returned instance is thread safe but each
        WrappedBackoffIterator(Iterator<TimeValue> delegate, Runnable onBackoff) {
     * @param maxDelayForRetry MaxDelay that can be returned from backoff policy
        private final long maxDelayForRetry;
     * roughly 5.1 seconds in total.
    /**
        @Override
     */
            return true;
         * @return true
     * Concrete Exponential Back Off Policy
        public Iterator<TimeValue> iterator() {
        }
    /**
        }
package org.opensearch.action.bulk;
        }
        public TimeValue next() {
     * @param delay              The delay defines how long to wait between retry attempts. Must not be null.
     * Concrete Constant Back Off Iterator
         * @return true
    }
    }
     * Creates an new constant backoff policy with the provided configuration.
         * and not increase the delay.
        @Override
         * Once delay has exceeded maxDelayForRetry, it will return maxDelayForRetry only
/*
 *
 * <ul>
        @Override
/**
        private final Runnable onBackoff;
    }
            assert start >= 0;
    }
     *
            onBackoff.run();
                throw new NoSuchElementException();
        }
                }
            }
                @Override
     *  It uses equal jitter scheme as it is being used for throttled exceptions.
    public static BackoffPolicy constantBackoff(TimeValue delay, int maxNumberOfRetries) {
        return new ExponentialEqualJitterBackoff(baseDelay, maxDelayForRetry);
        return NO_BACKOFF;
        ConstantBackoffIterator(TimeValue delay, int numberOfElements) {
        }
            this.delay = delay;
    }
        @Override
        @Override
            this.maxDelayForRetry = maxDelayForRetry;
     */
        }
        @Override
                }
    public static BackoffPolicy noBackoff() {
     * Concrete Wrapped Back Off Policy
 *     <li><code>#hasNext()</code> determines whether the progression has more elements. Return <code>true</code> for infinite progressions
        }
         * This Iterator will always return back off delay.
        ConstantBackoff(TimeValue delay, int numberOfElements) {
 */
     *  It provides exponential backoff between retries until it reaches Integer.MAX_VALUE.
        private final long baseDelay;
        public boolean hasNext() {
            int result = start + 10 * ((int) Math.exp(0.8d * (currentlyConsumed)) - 1);
    private static class ExponentialBackoffIterator implements Iterator<TimeValue> {
            this.numberOfElements = numberOfElements;
                throw new NoSuchElementException();
    /**
         * <p>
 * specific language governing permissions and limitations
     *  It will make random distribution and also guarantees a minimum delay.
    }
        }
    }
            this.delegate = delegate;
         */
                @Override
        public boolean hasNext() {
 * Notes for implementing custom subclasses:
    private static final class WrappedBackoffIterator implements Iterator<TimeValue> {
            return new WrappedBackoffIterator(delegate.iterator(), onBackoff);
    /**
        @Override
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            return new Iterator<TimeValue>() {
        private final long baseDelay;
            this.numberOfElements = numberOfElements;
            curr++;
 * KIND, either express or implied.  See the License for the
            this.currentDelay = baseDelay;
 * You may obtain a copy of the License at
     * Concrete No Back Off Policy
            this.start = start;
    public static BackoffPolicy exponentialFullJitterBackoff(long baseDelay) {
     *  It provides exponential backoff between retries until it reaches maxDelayForRetry.
