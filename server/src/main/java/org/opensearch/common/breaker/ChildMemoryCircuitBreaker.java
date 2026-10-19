            if (memoryBytesLimit > 0 && newUsedWithOverhead > memoryBytesLimit) {
     */
     * Create a circuit breaker that will break if the number of estimated  
            + ", which is larger than the limit of ["
}
 * SPDX-License-Identifier: Apache-2.0
    }
        return newUsed;
        // Additionally, we need to check that we haven't exceeded the parent's limit
                logger.warn(  
     * @return whether a tripped circuit breaker will reset itself (transient) or requires manual intervention (permanent).
     *
        return u;
                    new ByteSizeValue(bytes),
    public ChildMemoryCircuitBreaker(BreakerSettings settings, Logger logger, HierarchyCircuitBreakerService parent, String name) {
    }
     * @return the constant multiplier the breaker uses for aggregations
import org.opensearch.indices.breaker.BreakerSettings;  
                    "[{}] Adding [{}][{}] to used bytes [new used: [{}], limit: {} [{}], estimate: {} [{}]]",  
 * You may obtain a copy of the License at  
        throw new CircuitBreakingException(message, bytesNeeded, memoryBytesLimit, durability);
     * <p>
            newUsed = limit(bytes, label, overheadConstant, memoryBytesLimit);
    private volatile LimitAndOverhead limitAndOverhead;  
import org.opensearch.core.common.breaker.CircuitBreaker;  
                    new ByteSizeValue(memoryBytesLimit)
        return newUsed;
            this.limit = limit;  
     * @return number of "used" bytes so far
/**
    @Override  
            currentUsed = this.used.get();
        return this.durability;
        // If there is no limit (-1), we can optimize a bit by using
    private final HierarchyCircuitBreakerService parent;
        // short-circuit on no data allowed, immediately throwing an exception
import org.apache.logging.log4j.Logger;
        long newUsed;
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
    public String getName() {
     * @return the number of bytes that can be added before the breaker trips
        LimitAndOverhead(long limit, double overhead) {
     * @return number of "used" bytes so far
        this.used = new AtomicLong(0);  
    }  
        assert u >= 0 : "Used bytes: [" + u + "] must be >= 0";
    }
/*  
    public long getTrippedCount() {  
 *
    private final String name;  
     */
        try {  
        }
 * compatible open source license.
    private final Logger logger;
 * Unless required by applicable law or agreed to in writing,
        final String message = "["  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return this.used.get();
     *  
            + this.name
    /**
    }
            this.addWithoutBreaking(-bytes);  
 *  
            parent.checkParentLimit((long) (bytes * overheadConstant), label);
    /**  
 *
        this.limitAndOverhead = new LimitAndOverhead(settings.getLimit(), settings.getOverhead());
            + "]"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
        }
    public Durability getDurability() {
                );
                    new ByteSizeValue(memoryBytesLimit),  
     * circuit breaker. This bypasses the overheadConstant multiplication.
        logger.trace(
    }  
        final long memoryBytesLimit = this.limitAndOverhead.limit;
                    label,  
     * @param bytes number of bytes to add to the breaker  
        logger.trace(() -> new ParameterizedMessage("creating ChildCircuitBreaker with settings {}", settings));  
    private final AtomicLong trippedCount;  
                    memoryBytesLimit,
 * this file be licensed under the Apache-2.0 license or a
        }  
    }  
                    memoryBytesLimit,  
     * @param parent parent circuit breaker service to delegate tripped breakers to
            )
        this.trippedCount = new AtomicLong(0);
    /**
                    newUsedWithOverhead,  
 * GitHub history for details.
 */  
     */
    public long getLimit() {
        } while (!this.used.compareAndSet(currentUsed, newUsed));
        // there are conflicts. May result in additional logging, but it's  
        final double overheadConstant = limitAndOverhead.overhead;
    private long noLimit(long bytes, String label) {
    @Override  
                this.name,
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
     * the given overheadConstant. Uses the given oldBreaker to initialize
     * Add a number of bytes, tripping the circuit breaker if the aggregated
            newUsed = noLimit(bytes, label);  
     * Add an <b>exact</b> number of bytes, not checking for tripping the  
        long u = used.addAndGet(bytes);
     * @return the number of aggregated "used" bytes so far  
        this.parent = parent;
                    new ByteSizeValue(newUsedWithOverhead)
            + fieldName  
            throw e;
     */  
    @Override
     * Breaker limit and overhead info
    }  
                label,  
     * whether to trip the breaker or not  
 * the Apache License, Version 2.0 (the "License"); you may
    private final Durability durability;
            + bytesNeeded  
    @Override  
        return this.limitAndOverhead.limit;  
    /**
 * software distributed under the License is distributed on an
        assert newUsed >= 0 : "Used bytes: [" + newUsed + "] must be >= 0";  
            () -> new ParameterizedMessage(
        final long memoryBytesLimit = limitAndOverhead.limit;  
     * bytes grows above the limit. All estimations will be multiplied by
     * memory limit is set to 0. Will never trip the breaker if the limit is
                    label,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.unit.ByteSizeValue;
            }
    public long addWithoutBreaking(long bytes) {
    /**
 * under the License.  
     */  
 * @opensearch.internal
    /**  
            // breaker has already been incremented
     * @return the number of times the breaker has been tripped  
    /**
        // .addAndGet() instead of looping (because we don't have to check a  
            + "] Data too large, data for ["
    private static class LimitAndOverhead {  
    }
     */
            // adjusted back down because the allocation is "blocked" but the
    private final AtomicLong used;
                    this.name,
    public double getOverhead() {
        // trace logging and shouldn't be counted on for additions.
 */  
    /**
        );  
    public void circuitBreak(String fieldName, long bytesNeeded) {  
        return this.limitAndOverhead.overhead;
     * set &lt; 0, but can still be used to aggregate estimations.
     */
     * estimates are above the limit. Automatically trips the breaker if the  
            if (logger.isTraceEnabled()) {
        long newUsed;
 */  
            // Attempt to set the new used value, but make sure it hasn't changed
        long currentUsed;
                    this.name,
        this.trippedCount.incrementAndGet();
 * KIND, either express or implied.  See the License for the
    @Override
     */
        this.logger = logger;
 * ownership. Elasticsearch licenses this file to you under  
                circuitBreak(label, newUsedWithOverhead);  
    public long getUsed() {  
        if (memoryBytesLimit == -1) {
            + " would be ["
        return newUsed;
            circuitBreak(label, bytes);
    public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
            }
            + new ByteSizeValue(bytesNeeded)
                    new ByteSizeValue(newUsed),
import org.apache.logging.log4j.message.ParameterizedMessage;
            // underneath us, if it has, keep trying until we are able to set it  
        newUsed = this.used.addAndGet(bytes);  
public class ChildMemoryCircuitBreaker implements CircuitBreaker {
                logger.trace(
        return this.trippedCount.get();
        this.limitAndOverhead = new LimitAndOverhead(limit, overhead);
        return this.name;  
     * has been exceeded.
    @Override
        long newUsed;// Otherwise, check the addition and commit the addition, looping if
    }
    @Override
                    newUsedWithOverhead,
        logger.debug(() -> new ParameterizedMessage("{}", message));  
     */
        this.durability = settings.getDurability();
    /**
 * Modifications Copyright OpenSearch Contributors. See
     * @param settings settings to configure this breaker
        private final double overhead;  
        this.name = name;  
    @Override
                    new ByteSizeValue(newUsedWithOverhead),
     * @param bytes number of bytes to add to the breaker  
    }
 *
            long newUsedWithOverhead = (long) (newUsed * overheadConstant);  
/*
                    "[{}] New used memory {} [{}] for data of [{}] would be larger than configured breaker: {} [{}], breaking",
        } catch (CircuitBreakingException e) {
                "[{}] Adding [{}][{}] to used bytes [new used: [{}], limit: [-1b]]",  
 * specific language governing permissions and limitations
 */
    }
     * @return the name of the breaker
            newUsed = currentUsed + bytes;
        } else {
            + "/"
    @Override
/*  
        do {  
import java.util.concurrent.atomic.AtomicLong;  
     * @opensearch.internal
                );  
     * Also does not check with the parent breaker to see if the parent limit  
    public void setLimitAndOverhead(long limit, double overhead) {  
            + "/"  
package org.opensearch.common.breaker;
     */
 * Breaker that will check a parent's when incrementing  
            + new ByteSizeValue(memoryBytesLimit)
        logger.trace(() -> new ParameterizedMessage("[{}] Adjusted breaker by [{}] bytes, now [{}]", this.name, bytes, u));  
        if (memoryBytesLimit == 0) {  
    private long limit(long bytes, String label, double overheadConstant, long memoryBytesLimit) {
    /**
            this.overhead = overhead;
     * @param name the name of the breaker  
            + memoryBytesLimit
    /**
                new ByteSizeValue(bytes),
            // If the parent breaker is tripped, this breaker has to be  
     * the starting offset.  
                new ByteSizeValue(newUsed)
            + "]";
        }
        final LimitAndOverhead limitAndOverhead = this.limitAndOverhead;
        // limit), which makes the RamAccountingTermsEnum case faster.
     */
     * Method used to trip the breaker, delegates to the parent to determine
            + "]"
 * this work for additional information regarding copyright
        private final long limit;
    }
 * not use this file except in compliance with the License.
    }  
import org.opensearch.core.common.breaker.CircuitBreakingException;
