import org.apache.logging.log4j.message.ParameterizedMessage;
     * number of milliseconds is chosen uniformly from
                }
}
        TimeValue.timeValueMillis(100),
    @SuppressForbidden(reason = "Argument to Math.abs() is definitely not Long.MIN_VALUE")
    }
        Property.NodeScope
 * another node and receive a response back. We do not know the round-trip latency here, but we can approximate it by attempting elections
        Property.NodeScope
 *
    }
    /**
        return scheduler;
        this.threadPool = threadPool;
 * under the License.
            logger.debug("scheduling {}", runnable);
        private final AtomicLong attempt = new AtomicLong();
 * KIND, either express or implied.  See the License for the
            // to overflow here would take over a million years of failed election attempts, so we won't worry about that:
 * software distributed under the License is distributed on an
    private final Random random;
                    if (isClosed.get()) {
        backoffTime = ELECTION_BACK_OFF_TIME_SETTING.get(settings);
 * Licensed to Elasticsearch under one or more contributor
     */
    @Override
import java.util.Random;
        @Override
     *
        @Override
import org.opensearch.threadpool.ThreadPool.Names;
                        + ", delayMillis="
 * not use this file except in compliance with the License.
            + ", maxTimeout="
 * It's provably impossible to guarantee that any leader election algorithm ever elects a leader, but they generally work (with probability
import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
    private class ElectionScheduler implements Releasable {
     *
            + backoffTime
        TimeValue.timeValueMillis(1),
     * @param upperBound   inclusive upper bound
                return;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            final Runnable runnable = new AbstractRunnable() {
    public static final Setting<TimeValue> ELECTION_DURATION_SETTING = Setting.timeSetting(
        }
        }
                        + gracePeriod
 * randomly at reasonably high frequency and backing off (linearly) until one of them succeeds. We also place an upper bound on the backoff
/**
import java.util.concurrent.atomic.AtomicLong;
                @Override
import org.opensearch.common.settings.Setting.Property;
    /*
        this.random = random;
import org.opensearch.common.lease.Releasable;
    private final TimeValue duration;
                        scheduledRunnable.run();
        return nonNegative(randomNumber) % upperBound + 1;
        Property.NodeScope
    }
        final ElectionScheduler scheduler = new ElectionScheduler();
     *     (0, min(ELECTION_INITIAL_TIMEOUT_SETTING + (n-1) * ELECTION_BACK_OFF_TIME_SETTING, ELECTION_MAX_TIMEOUT_SETTING)]
                        logger.debug("{} starting election with duration {}", this, duration);
    private static final Logger logger = LogManager.getLogger(ElectionSchedulerFactory.class);
     *
                    return "scheduleNextElection{gracePeriod="
    public static final Setting<TimeValue> ELECTION_MAX_TIMEOUT_SETTING = Setting.timeSetting(
            + maxTimeout
                    "[{}] is [{}], but must be at least [{}] which is [{}]",
 *     http://www.apache.org/licenses/LICENSE-2.0
        duration = ELECTION_DURATION_SETTING.get(settings);
    private final ThreadPool threadPool;
        TimeValue.timeValueSeconds(10),
/*
     * @param gracePeriod       An initial period to wait before attempting the first election.
 */
            + "initialTimeout="
                        + thisAttempt
                        + delayMillis
        }
        public void close() {
     */
     */
                @Override
        TimeValue.timeValueSeconds(60),
     * For `n > 1`, the `n`th election is scheduled to occur a random number of milliseconds after the `n - 1`th election, where the random
 * that approaches 1 over time) as long as elections occur sufficiently infrequently, compared to the time it takes to send a message to
            + initialTimeout
        void scheduleNextElection(final TimeValue gracePeriod, final Runnable scheduledRunnable) {
        TimeValue.timeValueMillis(1),
/*
            + '}';
    private static long nonNegative(long n) {
                    ELECTION_MAX_TIMEOUT_SETTING_KEY,
            return "ElectionScheduler{attempt=" + attempt + ", " + ElectionSchedulerFactory.this + "}";
public class ElectionSchedulerFactory {
 * compatible open source license.
                        + ", thisAttempt="
    public String toString() {
            };
        TimeValue.timeValueMillis(200),
    static long toPositiveLongAtMost(long randomNumber, long upperBound) {
                        scheduleNextElection(duration, scheduledRunnable);
     * The first election is scheduled to occur a random number of milliseconds after the scheduler is started, where the random number of
        scheduler.scheduleNextElection(gracePeriod, scheduledRunnable);
 *
                    assert false : e;
     */
                        + "}";
    public ElectionSchedulerFactory(Settings settings, Random random, ThreadPool threadPool) {
                    maxTimeout,
/*
     *
            throw new IllegalArgumentException(
            assert wasNotPreviouslyClosed;
     *     (0, min(ELECTION_INITIAL_TIMEOUT_SETTING, ELECTION_MAX_TIMEOUT_SETTING)]
    );
    private static final String ELECTION_DURATION_SETTING_KEY = "cluster.election.duration";
 * Unless required by applicable law or agreed to in writing,
     *
 * The OpenSearch Contributors require contributions made to
    private static final String ELECTION_BACK_OFF_TIME_SETTING_KEY = "cluster.election.back_off_time";
     * Each election lasts up to ELECTION_DURATION_SETTING.
                        + ElectionScheduler.this
     * @return a number in the range (0, upperBound]
                new ParameterizedMessage(
     * milliseconds is chosen uniformly from
    public Releasable startElectionScheduler(TimeValue gracePeriod, Runnable scheduledRunnable) {
 */
            if (isClosed.get()) {
    }
        TimeValue.timeValueSeconds(10),
import org.opensearch.threadpool.ThreadPool;
     * @param randomNumber a randomly-chosen long
 * You may obtain a copy of the License at
        TimeValue.timeValueMillis(100),
 * the Apache License, Version 2.0 (the "License"); you may
    }
    /**
                    logger.debug(new ParameterizedMessage("unexpected exception in wakeup of {}", this), e);
                        + maxDelayMillis
        TimeValue.timeValueMillis(500),
                    ELECTION_INITIAL_TIMEOUT_SETTING_KEY,
            final long delayMillis = toPositiveLongAtMost(random.nextLong(), maxDelayMillis) + gracePeriod.millis();
 * attempt reasonably quickly.
                public void onFailure(Exception e) {
            final long maxDelayMillis = Math.min(maxTimeout.millis(), initialTimeout.millis() + thisAttempt * backoffTime.millis());
        TimeValue.timeValueSeconds(300),
                        + ", maxDelayMillis="
                    initialTimeout
    );
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
     * @param scheduledRunnable The action to run each time an election should be attempted.
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        initialTimeout = ELECTION_INITIAL_TIMEOUT_SETTING.get(settings);
            boolean wasNotPreviouslyClosed = isClosed.compareAndSet(false, true);
import org.apache.logging.log4j.Logger;
    private final TimeValue backoffTime;
        ELECTION_BACK_OFF_TIME_SETTING_KEY,
                logger.debug("{} not scheduling election", this);
     * The Election scheduler.
 */
        Property.NodeScope
 *
        return n == Long.MIN_VALUE ? 0 : Math.abs(n);
    }
 *
                    } else {
                ).getFormattedMessage()
import org.apache.logging.log4j.LogManager;
    public static final Setting<TimeValue> ELECTION_INITIAL_TIMEOUT_SETTING = Setting.timeSetting(
    /**
            threadPool.scheduleUnlessShuttingDown(TimeValue.timeValueMillis(delayMillis), Names.GENERIC, runnable);
 */
    private final TimeValue maxTimeout;
    private static final String ELECTION_MAX_TIMEOUT_SETTING_KEY = "cluster.election.max_timeout";
                protected void doRun() {
                        logger.debug("{} not starting election", this);
        ELECTION_DURATION_SETTING_KEY,
    // package-private for testing
 * Modifications Copyright OpenSearch Contributors. See
        ELECTION_INITIAL_TIMEOUT_SETTING_KEY,
     *
        }
 * this work for additional information regarding copyright
        TimeValue.timeValueSeconds(300),
        private final AtomicBoolean isClosed = new AtomicBoolean();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting;
package org.opensearch.cluster.coordination;
        if (maxTimeout.millis() < initialTimeout.millis()) {
            final long thisAttempt = attempt.getAndIncrement();
            );
import org.opensearch.common.SuppressForbidden;
        ELECTION_MAX_TIMEOUT_SETTING_KEY,
import org.opensearch.common.unit.TimeValue;
import java.util.concurrent.atomic.AtomicBoolean;
                    }
                }
            }
        maxTimeout = ELECTION_MAX_TIMEOUT_SETTING.get(settings);
    private static final String ELECTION_INITIAL_TIMEOUT_SETTING_KEY = "cluster.election.initial_timeout";
                public String toString() {
     * @opensearch.internal
import org.opensearch.common.util.concurrent.AbstractRunnable;
                @Override
        public String toString() {
     * Start the process to schedule repeated election attempts.
        return "ElectionSchedulerFactory{"
    private final TimeValue initialTimeout;
    public static final Setting<TimeValue> ELECTION_BACK_OFF_TIME_SETTING = Setting.timeSetting(
                        + ", "
        TimeValue.timeValueMillis(1),
 * so that if elections are failing due to a network partition that lasts for a long time then when the partition heals there is an election
            + ", backoffTime="
    );
    );
        assert 0 < upperBound : upperBound;
                }
 * @opensearch.internal
