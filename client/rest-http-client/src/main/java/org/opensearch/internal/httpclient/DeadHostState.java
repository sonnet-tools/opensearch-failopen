package org.opensearch.internal.httpclient;
     *  
 * software distributed under the License is distributed on an
 *
import java.util.function.Supplier;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        return Long.compare(deadUntilNanos, other.deadUntilNanos);
     * @param previousDeadHostState the previous state of the host which allows us to increase the wait till the next retry attempt
    private final int failedAttempts;  
    }
        long timeoutNanos = (long) Math.min(
 * this file be licensed under the Apache-2.0 license or a
     * After that the host should be retried.  
    private static final long MIN_CONNECTION_TIMEOUT_NANOS = TimeUnit.MINUTES.toNanos(1);
     */
    DeadHostState(DeadHostState previousDeadHostState) {  
 */
     * it already failed for one or more consecutive times. The more failed attempts we register the longer we wait  
import java.util.concurrent.TimeUnit;
     *  
            + "failedAttempts="
            MIN_CONNECTION_TIMEOUT_NANOS * 2 * Math.pow(2, previousDeadHostState.failedAttempts * 0.5 - 1),
     * Build the initial dead state of a host. Useful when a working host stops functioning
    long getDeadUntilNanos() {
        this.deadUntilNanos = timeSupplier.get() + MIN_CONNECTION_TIMEOUT_NANOS;  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    }  
        if (timeSupplier != other.timeSupplier) {  
    /**
     */  
    }
     *
    }
    public int compareTo(DeadHostState other) {
        return failedAttempts;
            MAX_CONNECTION_TIMEOUT_NANOS  
        return deadUntilNanos;  
                "can't compare DeadHostStates holding different time suppliers as they may " + "be based on different clocks"
            + ", timeSupplier="  
            + failedAttempts  
    }
/*
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
        }
        return "DeadHostState{"
final class DeadHostState implements Comparable<DeadHostState> {  
    }  
 * compatible open source license.
     * to retry that same host again. Minimum is 1 minute (for a node the only failed once created
 *    http://www.apache.org/licenses/LICENSE-2.0
            );  
 *  
    @Override
            + ", deadUntilNanos="
            + deadUntilNanos
    static final Supplier<Long> DEFAULT_TIME_SUPPLIER = System::nanoTime;
 * specific language governing permissions and limitations
     * through {@link #DeadHostState(Supplier)}), maximum is 30 minutes (for a node that failed more than 10 consecutive times)
        this.failedAttempts = previousDeadHostState.failedAttempts + 1;  
/**
    /**
/*  
        return timeSupplier.get() - deadUntilNanos > 0;
        this.deadUntilNanos = previousDeadHostState.timeSupplier.get() + timeoutNanos;
/*  
 * ownership. Elasticsearch licenses this file to you under  
        this.failedAttempts = 1;
 *
}
        this.timeSupplier = timeSupplier;
     */
    int getFailedAttempts() {  
     */
     * @param timeSupplier a way to supply the current time and allow for unit testing
            throw new IllegalArgumentException(
    DeadHostState(Supplier<Long> timeSupplier) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static final long MAX_CONNECTION_TIMEOUT_NANOS = TimeUnit.MINUTES.toNanos(30);  
 */  
 * this work for additional information regarding copyright
 */
     * Returns the timestamp (nanos) till the host is supposed to stay dead without being retried.
 * The OpenSearch Contributors require contributions made to  
    /**
    private final Supplier<Long> timeSupplier;
     * Indicates whether it's time to retry to failed host or not.
 * not use this file except in compliance with the License.
    /**
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 * Class is immutable, a new copy of it should be created each time the state has to be changed.
     * Build the dead state of a host given its previous dead state. Useful when a host has been failing before, hence
 * GitHub history for details.
            + timeSupplier
    public String toString() {  
     * and needs to be marked dead after its first failure. In such case the host will be retried after a minute or so.  
 * when the host should be retried (based on number of previous failed attempts).  
    }
 * SPDX-License-Identifier: Apache-2.0
        );
 * Holds the state of a dead connection to a host. Keeps track of how many failed attempts were performed and
    boolean shallBeRetried() {  
    private final long deadUntilNanos;
        this.timeSupplier = previousDeadHostState.timeSupplier;
 * license agreements. See the NOTICE file distributed with
     * @return true if the host should be retried, false otherwise
            + '}';
