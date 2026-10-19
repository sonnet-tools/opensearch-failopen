/*
    @Override
     * to retry that same host again. Minimum is 1 minute (for a node the only failed once created
 */  
     */
    boolean shallBeRetried() {  
     * Indicates whether it's time to retry to failed host or not.
            MAX_CONNECTION_TIMEOUT_NANOS  
 * the Apache License, Version 2.0 (the "License"); you may
    public int compareTo(DeadHostState other) {
    static final long MAX_CONNECTION_TIMEOUT_NANOS = TimeUnit.MINUTES.toNanos(30);  
            MIN_CONNECTION_TIMEOUT_NANOS * 2 * Math.pow(2, previousDeadHostState.failedAttempts * 0.5 - 1),
            + ", deadUntilNanos="
 */
 * this file be licensed under the Apache-2.0 license or a
    }  
            + deadUntilNanos
     *  
    int getFailedAttempts() {  
 *
 * GitHub history for details.
 * not use this file except in compliance with the License.
     *  
            + failedAttempts  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
/*  
        return Long.compare(deadUntilNanos, other.deadUntilNanos);
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
        return timeSupplier.get() - deadUntilNanos > 0;
     * Build the initial dead state of a host. Useful when a working host stops functioning
        this.deadUntilNanos = previousDeadHostState.timeSupplier.get() + timeoutNanos;
     */
 */  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
     * @param timeSupplier a way to supply the current time and allow for unit testing
     */
        this.failedAttempts = previousDeadHostState.failedAttempts + 1;  
    }
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.TimeUnit;
 *
    private static final long MIN_CONNECTION_TIMEOUT_NANOS = TimeUnit.MINUTES.toNanos(1);
    /**
 * KIND, either express or implied.  See the License for the
     * @param previousDeadHostState the previous state of the host which allows us to increase the wait till the next retry attempt
        this.timeSupplier = timeSupplier;
 * when the host should be retried (based on number of previous failed attempts).  
        this.deadUntilNanos = timeSupplier.get() + MIN_CONNECTION_TIMEOUT_NANOS;  
                "can't compare DeadHostStates holding different time suppliers as they may " + "be based on different clocks"
 * Class is immutable, a new copy of it should be created each time the state has to be changed.
            + '}';
        }
        long timeoutNanos = (long) Math.min(
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
import java.util.function.Supplier;
        if (timeSupplier != other.timeSupplier) {  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        return failedAttempts;
package org.opensearch.client;
     * and needs to be marked dead after its first failure. In such case the host will be retried after a minute or so.  
    DeadHostState(Supplier<Long> timeSupplier) {
     * Returns the timestamp (nanos) till the host is supposed to stay dead without being retried.
 * The OpenSearch Contributors require contributions made to  
    private final Supplier<Long> timeSupplier;
     * @return true if the host should be retried, false otherwise
            throw new IllegalArgumentException(
    private final long deadUntilNanos;
    }
            + ", timeSupplier="  
            + "failedAttempts="
            + timeSupplier
 */
 * You may obtain a copy of the License at  
}
 * under the License.  
    DeadHostState(DeadHostState previousDeadHostState) {  
        this.timeSupplier = previousDeadHostState.timeSupplier;
     * After that the host should be retried.  
        return "DeadHostState{"
            );  
    }  
 * SPDX-License-Identifier: Apache-2.0
        this.failedAttempts = 1;
    @Override
        return deadUntilNanos;  
     * it already failed for one or more consecutive times. The more failed attempts we register the longer we wait  
    /**
     * Build the dead state of a host given its previous dead state. Useful when a host has been failing before, hence
final class DeadHostState implements Comparable<DeadHostState> {  
/*  
    static final Supplier<Long> DEFAULT_TIME_SUPPLIER = System::nanoTime;
    long getDeadUntilNanos() {
     *
    }
    }
/**
    public String toString() {  
     */  
    }
    /**
 *  
    private final int failedAttempts;  
 * Holds the state of a dead connection to a host. Keeps track of how many failed attempts were performed and
     * through {@link #DeadHostState(Supplier)}), maximum is 30 minutes (for a node that failed more than 10 consecutive times)
