     * @return number of "used" bytes so far
        logger.debug(() -> new ParameterizedMessage("{}", message));
    private final AtomicLong used;
        return newUsed;
     */
            + bytesNeeded
     * @return the number of bytes that can be added before the breaker trips
     */
            this.overhead = overhead;
        } catch (CircuitBreakingException e) {
            // adjusted back down because the allocation is "blocked" but the
 * KIND, either express or implied.  See the License for the
    /**
 * The OpenSearch Contributors require contributions made to
            }
        this.name = name;
     */
        this.durability = settings.getDurability();
    /**
 *
     * Also does not check with the parent breaker to see if the parent limit
     * @param name the name of the breaker
 * this file be licensed under the Apache-2.0 license or a
            // underneath us, if it has, keep trying until we are able to set it
                logger.warn(
    public ChildMemoryCircuitBreaker(BreakerSettings settings, Logger logger, HierarchyCircuitBreakerService parent, String name) {
     * @param bytes number of bytes to add to the breaker
     */
            newUsed = noLimit(bytes, label);
        this.logger = logger;
        private final long limit;
                circuitBreak(label, newUsedWithOverhead);
        );
        if (memoryBytesLimit == -1) {
    /**
    @Override
 * Breaker that will check a parent's when incrementing
    private static class LimitAndOverhead {
     * @param bytes number of bytes to add to the breaker
     * whether to trip the breaker or not
        }
            this.limit = limit;
        return newUsed;
     * @opensearch.internal
     */
        long newUsed;
                );
     * @return the number of aggregated "used" bytes so far
 *
     * the starting offset.
     */
        }
    }
                    label,
}
        return this.trippedCount.get();
            circuitBreak(label, bytes);
        this.limitAndOverhead = new LimitAndOverhead(limit, overhead);
            if (memoryBytesLimit > 0 && newUsedWithOverhead > memoryBytesLimit) {
    /**
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
     * @return number of "used" bytes so far
 * under the License.
     * @return the number of times the breaker has been tripped
        logger.trace(
 * GitHub history for details.
        newUsed = this.used.addAndGet(bytes);
    @Override
     * Method used to trip the breaker, delegates to the parent to determine
     * <p>
                    "[{}] New used memory {} [{}] for data of [{}] would be larger than configured breaker: {} [{}], breaking",
    }
    }
     * Add a number of bytes, tripping the circuit breaker if the aggregated
        final String message = "["
    /**
            + this.name
                    this.name,
     * @return the constant multiplier the breaker uses for aggregations
            currentUsed = this.used.get();
        // there are conflicts. May result in additional logging, but it's
        return this.limitAndOverhead.overhead;
public class ChildMemoryCircuitBreaker implements CircuitBreaker {
            long newUsedWithOverhead = (long) (newUsed * overheadConstant);
    public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
    @Override
    private final Durability durability;
            throw e;
    @Override
    public long getLimit() {
        assert newUsed >= 0 : "Used bytes: [" + newUsed + "] must be >= 0";
                logger.trace(
        this.limitAndOverhead = new LimitAndOverhead(settings.getLimit(), settings.getOverhead());
        long newUsed;
                    new ByteSizeValue(bytes),
     */
    }
    }
            + ", which is larger than the limit of ["
     */
        return newUsed;
     * set &lt; 0, but can still be used to aggregate estimations.
        assert u >= 0 : "Used bytes: [" + u + "] must be >= 0";
    private long limit(long bytes, String label, double overheadConstant, long memoryBytesLimit) {
    }
    }
                label,
    public Durability getDurability() {
            + "/"
    private final HierarchyCircuitBreakerService parent;
     * @param settings settings to configure this breaker
/*
    }
        this.trippedCount.incrementAndGet();
 */
     * Create a circuit breaker that will break if the number of estimated
            + memoryBytesLimit
        }
    private long noLimit(long bytes, String label) {
 *
        this.parent = parent;
    @Override
        } while (!this.used.compareAndSet(currentUsed, newUsed));
 */
                    new ByteSizeValue(newUsed),
     * Breaker limit and overhead info
                    "[{}] Adding [{}][{}] to used bytes [new used: [{}], limit: {} [{}], estimate: {} [{}]]",
import org.opensearch.core.common.breaker.CircuitBreaker;
        }
    @Override
 * @opensearch.internal
    }
        LimitAndOverhead(long limit, double overhead) {
import java.util.concurrent.atomic.AtomicLong;
     *
            // If the parent breaker is tripped, this breaker has to be
        return this.name;
    /**
            newUsed = currentUsed + bytes;
                "[{}] Adding [{}][{}] to used bytes [new used: [{}], limit: [-1b]]",
    private final String name;
 * specific language governing permissions and limitations
                );
    @Override
        // Additionally, we need to check that we haven't exceeded the parent's limit
 * You may obtain a copy of the License at
                    newUsedWithOverhead,
    @Override
        long currentUsed;
            this.addWithoutBreaking(-bytes);
            if (logger.isTraceEnabled()) {
        // .addAndGet() instead of looping (because we don't have to check a
import org.opensearch.indices.breaker.BreakerSettings;
            () -> new ParameterizedMessage(
     * Add an <b>exact</b> number of bytes, not checking for tripping the
        long newUsed;// Otherwise, check the addition and commit the addition, looping if
        } else {
                new ByteSizeValue(newUsed)
                    memoryBytesLimit,
    public long getUsed() {
 * the Apache License, Version 2.0 (the "License"); you may
    /**
     *
     * @param parent parent circuit breaker service to delegate tripped breakers to
        if (memoryBytesLimit == 0) {
     * @return whether a tripped circuit breaker will reset itself (transient) or requires manual intervention (permanent).
    public void setLimitAndOverhead(long limit, double overhead) {
    private final Logger logger;
        final LimitAndOverhead limitAndOverhead = this.limitAndOverhead;
        try {
 */
 * ownership. Elasticsearch licenses this file to you under
        long u = used.addAndGet(bytes);
                    new ByteSizeValue(newUsedWithOverhead),
    public String getName() {
        throw new CircuitBreakingException(message, bytesNeeded, memoryBytesLimit, durability);
                    new ByteSizeValue(memoryBytesLimit)
            + "] Data too large, data for ["
 * Licensed to Elasticsearch under one or more contributor
    }
                    newUsedWithOverhead,
 * Modifications Copyright OpenSearch Contributors. See
    }
            }
     */
     */
 * compatible open source license.
            // breaker has already been incremented
 *
        return u;
     * the given overheadConstant. Uses the given oldBreaker to initialize
        this.used = new AtomicLong(0);
     * memory limit is set to 0. Will never trip the breaker if the limit is
        // short-circuit on no data allowed, immediately throwing an exception
 * license agreements. See the NOTICE file distributed with
        logger.trace(() -> new ParameterizedMessage("[{}] Adjusted breaker by [{}] bytes, now [{}]", this.name, bytes, u));
import org.opensearch.core.common.unit.ByteSizeValue;
    /**
 */
            newUsed = limit(bytes, label, overheadConstant, memoryBytesLimit);
    @Override
 * software distributed under the License is distributed on an
/*
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    public double getOverhead() {
                    this.name,
            + " would be ["
                this.name,
    private final AtomicLong trippedCount;
/**
 * Unless required by applicable law or agreed to in writing,
     * circuit breaker. This bypasses the overheadConstant multiplication.
        this.trippedCount = new AtomicLong(0);
    }
            + fieldName
        final double overheadConstant = limitAndOverhead.overhead;
     * bytes grows above the limit. All estimations will be multiplied by
        // limit), which makes the RamAccountingTermsEnum case faster.
     * has been exceeded.
            + "]"
    }
        return this.used.get();
                new ByteSizeValue(bytes),
    public void circuitBreak(String fieldName, long bytesNeeded) {
            )
        final long memoryBytesLimit = limitAndOverhead.limit;
 * SPDX-License-Identifier: Apache-2.0
            + "/"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + new ByteSizeValue(memoryBytesLimit)
/*
                    label,
     */
        private final double overhead;
        return this.limitAndOverhead.limit;
        final long memoryBytesLimit = this.limitAndOverhead.limit;
                    new ByteSizeValue(newUsedWithOverhead)
     * estimates are above the limit. Automatically trips the breaker if the
        return this.durability;
    public long getTrippedCount() {
    private volatile LimitAndOverhead limitAndOverhead;
            + new ByteSizeValue(bytesNeeded)
    /**
    @Override
        do {
    public long addWithoutBreaking(long bytes) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        // If there is no limit (-1), we can optimize a bit by using
import org.opensearch.core.common.breaker.CircuitBreakingException;
                    memoryBytesLimit,
            parent.checkParentLimit((long) (bytes * overheadConstant), label);
        logger.trace(() -> new ParameterizedMessage("creating ChildCircuitBreaker with settings {}", settings));
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
    /**
            // Attempt to set the new used value, but make sure it hasn't changed
        // trace logging and shouldn't be counted on for additions.
                    new ByteSizeValue(memoryBytesLimit),
package org.opensearch.common.breaker;
    }
            + "]"
    /**
     * @return the name of the breaker
            + "]";
