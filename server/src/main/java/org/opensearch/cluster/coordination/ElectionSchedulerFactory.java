    private static long nonNegative(long n) {
     * The first election is scheduled to occur a random number of milliseconds after the scheduler is started, where the random number of
     *  
    public Releasable startElectionScheduler(TimeValue gracePeriod, Runnable scheduledRunnable) {
 * You may obtain a copy of the License at  
     *
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicBoolean;  
                        logger.debug("{} starting election with duration {}", this, duration);  
        this.threadPool = threadPool;
import java.util.Random;
 * another node and receive a response back. We do not know the round-trip latency here, but we can approximate it by attempting elections  
                new ParameterizedMessage(
        maxTimeout = ELECTION_MAX_TIMEOUT_SETTING.get(settings);  
                        + delayMillis  
 * Modifications Copyright OpenSearch Contributors. See
    /*
                        + thisAttempt
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
            // to overflow here would take over a million years of failed election attempts, so we won't worry about that:  
 */  
        if (maxTimeout.millis() < initialTimeout.millis()) {  
/**  
/*  
        Property.NodeScope  
 * It's provably impossible to guarantee that any leader election algorithm ever elects a leader, but they generally work (with probability
        ELECTION_BACK_OFF_TIME_SETTING_KEY,  
 * the Apache License, Version 2.0 (the "License"); you may
                    maxTimeout,
                        scheduledRunnable.run();
 * not use this file except in compliance with the License.
                    } else {
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.opensearch.common.settings.Setting;  
            + initialTimeout  
            boolean wasNotPreviouslyClosed = isClosed.compareAndSet(false, true);  
                    ELECTION_INITIAL_TIMEOUT_SETTING_KEY,  
     *  
                return;
        ELECTION_DURATION_SETTING_KEY,
 * attempt reasonably quickly.  
    }
import org.opensearch.common.settings.Setting.Property;
 *
        Property.NodeScope
 * ownership. Elasticsearch licenses this file to you under  
/*  
        this.random = random;
                    initialTimeout
        @Override
import org.apache.logging.log4j.Logger;
 * specific language governing permissions and limitations
            final long maxDelayMillis = Math.min(maxTimeout.millis(), initialTimeout.millis() + thisAttempt * backoffTime.millis());
        TimeValue.timeValueSeconds(300),
                    ELECTION_MAX_TIMEOUT_SETTING_KEY,
 *     http://www.apache.org/licenses/LICENSE-2.0
            + ", backoffTime="
                        + ", delayMillis="
     * number of milliseconds is chosen uniformly from
            threadPool.scheduleUnlessShuttingDown(TimeValue.timeValueMillis(delayMillis), Names.GENERIC, runnable);
        TimeValue.timeValueMillis(200),
        initialTimeout = ELECTION_INITIAL_TIMEOUT_SETTING.get(settings);
public class ElectionSchedulerFactory {
        TimeValue.timeValueMillis(1),  
import org.opensearch.common.settings.Settings;
    public static final Setting<TimeValue> ELECTION_BACK_OFF_TIME_SETTING = Setting.timeSetting(
                @Override
    public static final Setting<TimeValue> ELECTION_MAX_TIMEOUT_SETTING = Setting.timeSetting(
        TimeValue.timeValueMillis(100),
import org.opensearch.threadpool.ThreadPool;
    // package-private for testing
    private static final Logger logger = LogManager.getLogger(ElectionSchedulerFactory.class);  
 */
        private final AtomicLong attempt = new AtomicLong();  
        return n == Long.MIN_VALUE ? 0 : Math.abs(n);  
 */  
                logger.debug("{} not scheduling election", this);
 * GitHub history for details.
                protected void doRun() {
        TimeValue.timeValueSeconds(10),
            }  
    private final ThreadPool threadPool;  
    /**
        ELECTION_MAX_TIMEOUT_SETTING_KEY,
                    logger.debug(new ParameterizedMessage("unexpected exception in wakeup of {}", this), e);  
import org.opensearch.common.unit.TimeValue;  
        TimeValue.timeValueMillis(500),
    }
import org.apache.logging.log4j.message.ParameterizedMessage;  
        TimeValue.timeValueMillis(1),
        }  
    @SuppressForbidden(reason = "Argument to Math.abs() is definitely not Long.MIN_VALUE")
            + "initialTimeout="
    private final Random random;
                        logger.debug("{} not starting election", this);
        final ElectionScheduler scheduler = new ElectionScheduler();
            throw new IllegalArgumentException(
        return scheduler;
        scheduler.scheduleNextElection(gracePeriod, scheduledRunnable);  
        TimeValue.timeValueMillis(1),  
 * under the License.  
                }
     * For `n > 1`, the `n`th election is scheduled to occur a random number of milliseconds after the `n - 1`th election, where the random
     * The Election scheduler.  
                    return "scheduleNextElection{gracePeriod="
            + maxTimeout
 *  
                public String toString() {
    private static final String ELECTION_INITIAL_TIMEOUT_SETTING_KEY = "cluster.election.initial_timeout";
    public static final Setting<TimeValue> ELECTION_DURATION_SETTING = Setting.timeSetting(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
                @Override  
                    if (isClosed.get()) {  
        public void close() {
                }
                    }  
        public String toString() {  
                    assert false : e;
 * @opensearch.internal
            return "ElectionScheduler{attempt=" + attempt + ", " + ElectionSchedulerFactory.this + "}";
            + backoffTime
import org.opensearch.common.util.concurrent.AbstractRunnable;
 * license agreements. See the NOTICE file distributed with
                    "[{}] is [{}], but must be at least [{}] which is [{}]",  
     */  
                        scheduleNextElection(duration, scheduledRunnable);
            if (isClosed.get()) {  
     */  
    );  
import org.opensearch.threadpool.ThreadPool.Names;  
     * Start the process to schedule repeated election attempts.
    /**  
     * Each election lasts up to ELECTION_DURATION_SETTING.  
        return "ElectionSchedulerFactory{"
     * @param scheduledRunnable The action to run each time an election should be attempted.
                        + maxDelayMillis
    public static final Setting<TimeValue> ELECTION_INITIAL_TIMEOUT_SETTING = Setting.timeSetting(  
        @Override
            + '}';
            );  
    }  
}
    }
import org.apache.logging.log4j.LogManager;
            final long delayMillis = toPositiveLongAtMost(random.nextLong(), maxDelayMillis) + gracePeriod.millis();
    );  
    public ElectionSchedulerFactory(Settings settings, Random random, ThreadPool threadPool) {  
        ELECTION_INITIAL_TIMEOUT_SETTING_KEY,
     *
        backoffTime = ELECTION_BACK_OFF_TIME_SETTING.get(settings);
     * @return a number in the range (0, upperBound]  
     * @param gracePeriod       An initial period to wait before attempting the first election.
    );
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            assert wasNotPreviouslyClosed;
     *
    private static final String ELECTION_MAX_TIMEOUT_SETTING_KEY = "cluster.election.max_timeout";
    private final TimeValue maxTimeout;
                        + gracePeriod  
                }
                        + "}";  
        private final AtomicBoolean isClosed = new AtomicBoolean();
        }
 */  
 * The OpenSearch Contributors require contributions made to  
                        + ElectionScheduler.this
    private static final String ELECTION_BACK_OFF_TIME_SETTING_KEY = "cluster.election.back_off_time";  
 * this work for additional information regarding copyright
package org.opensearch.cluster.coordination;
     *     (0, min(ELECTION_INITIAL_TIMEOUT_SETTING, ELECTION_MAX_TIMEOUT_SETTING)]
 *
     */
     * @param randomNumber a randomly-chosen long
    private final TimeValue initialTimeout;
import java.util.concurrent.atomic.AtomicLong;
        TimeValue.timeValueMillis(100),
     * @param upperBound   inclusive upper bound
                public void onFailure(Exception e) {
        Property.NodeScope
     *     (0, min(ELECTION_INITIAL_TIMEOUT_SETTING + (n-1) * ELECTION_BACK_OFF_TIME_SETTING, ELECTION_MAX_TIMEOUT_SETTING)]
    private class ElectionScheduler implements Releasable {
        void scheduleNextElection(final TimeValue gracePeriod, final Runnable scheduledRunnable) {
    static long toPositiveLongAtMost(long randomNumber, long upperBound) {  
    @Override
        }
                        + ", "
        TimeValue.timeValueSeconds(300),
    }  
        Property.NodeScope
import org.opensearch.common.SuppressForbidden;
    public String toString() {  
        assert 0 < upperBound : upperBound;
        }
import org.opensearch.common.lease.Releasable;
        TimeValue.timeValueSeconds(60),  
     *  
                        + ", thisAttempt="
    );
            };
                        + ", maxDelayMillis="  
 * randomly at reasonably high frequency and backing off (linearly) until one of them succeeds. We also place an upper bound on the backoff
    }  
    private static final String ELECTION_DURATION_SETTING_KEY = "cluster.election.duration";
            + ", maxTimeout="  
     * @opensearch.internal
 * so that if elections are failing due to a network partition that lasts for a long time then when the partition heals there is an election
     * milliseconds is chosen uniformly from  
 * that approaches 1 over time) as long as elections occur sufficiently infrequently, compared to the time it takes to send a message to
        return nonNegative(randomNumber) % upperBound + 1;
    private final TimeValue duration;
            final Runnable runnable = new AbstractRunnable() {  
                ).getFormattedMessage()
    private final TimeValue backoffTime;  
            logger.debug("scheduling {}", runnable);
/*
     */
        duration = ELECTION_DURATION_SETTING.get(settings);
                @Override
        TimeValue.timeValueSeconds(10),  
            final long thisAttempt = attempt.getAndIncrement();
