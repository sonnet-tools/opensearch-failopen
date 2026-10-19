     * @return the name of this breaker
        return this.name;  
    @Override
     * @param bytes number of bytes to add
    public long getLimit() {
    /**  
 * under the License.  
 * GitHub history for details.
     */  
/*
    /**  
 *
    }  
     */  
     * A noop breaker have no overhead, always return 0
    /**  
    @Override
     */  
 * ownership. Elasticsearch licenses this file to you under  
    public long addWithoutBreaking(long bytes) {
    /** The limit of this breaker is always -1 */  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
/**
 * compatible open source license.
    public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
 * the Apache License, Version 2.0 (the "License"); you may
    /**
     * @return always return 0
    }  
     * @param bytesNeeded bytes needed
     * @return always return -1
        return 0;  
     * @param overhead the desired overhead (ignored)
}
     */
     * @param label string label describing the bytes being added
    }
     * return the name of this breaker
    public long getUsed() {
     * @return always return 0
     * @return always return 0
    @Override
     * @param limit the desired limit (ignored)  
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
    }
 * @opensearch.internal
     * @return always return 0  
     * @return always return 0
    @Override
    public void circuitBreak(String fieldName, long bytesNeeded) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String getName() {
    public long getTrippedCount() {
 * license agreements. See the NOTICE file distributed with
    /**  
     * A noop breaker have a constant limit of -1
     * @throws CircuitBreakingException never thrown
        return 0;  
    /**  
     * this is a noop.
    @Override
        // noop
    }
     */
 * A {@link CircuitBreaker} that doesn't increment or adjust, and all operations are
    }
    }
    public void setLimitAndOverhead(long limit, double overhead) {
    /** Name of this breaker */
        this.name = name;
 * KIND, either express or implied.  See the License for the
        // noop
    }  
     */  
    @Override  
 */  
    public Durability getDurability() {
     */  
        return 0;  
     */
     * This is a noop, nothing is added, always return 0  
 * this file be licensed under the Apache-2.0 license or a
    /**
        return LIMIT;  
     * This is a noop, always return 0 and never throw/trip  
    }
        return 0;  
     * Limit and overhead are constant for a noop breaker.
     * Creates a new NoopCircuitBreaker (that never trip) with the given name  
     * @return always return {@link Durability#PERMANENT }
    }
    /**  
 * Modifications Copyright OpenSearch Contributors. See
     */  
     * This is a noop, a noop breaker never trip
 * Licensed to Elasticsearch under one or more contributor  
 * It never trips, limit is always -1, always returns 0 for all metrics.
 * this work for additional information regarding copyright
    public static final int LIMIT = -1;
 *
    @Override
     * @param name the name of this breaker
    @Override  
    private final String name;  
     * This is a noop, always return 0
    public double getOverhead() {
     * @param fieldName name of this noop breaker  
        return Durability.PERMANENT;  
     * A noop breaker never trip, always return 0
 */
package org.opensearch.core.common.breaker;
    /**
     * A noop breaker {@link Durability} is always {@link Durability#PERMANENT}
 * not use this file except in compliance with the License.
 *  
/*  
 * basically noops.  
public class NoopCircuitBreaker implements CircuitBreaker {
     */
/*  
        return 0;
    /**
    /**  
    @Override
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
     * @param bytes number of bytes to add (ignored)
 */  
    public NoopCircuitBreaker(String name) {  
 * Unless required by applicable law or agreed to in writing,
 */  
