            assertThat(ELECTION_INITIAL_TIMEOUT_SETTING.get(settings), is(TimeValue.timeValueMillis(initialTimeoutMillis)));
            initialTimeoutMillis = ELECTION_INITIAL_TIMEOUT_SETTING.get(Settings.EMPTY).millis();
                .put(ELECTION_MAX_TIMEOUT_SETTING.getKey(), maxTimeoutMillis + "ms")
 * this work for additional information regarding copyright
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_MAX_TIMEOUT_SETTING.get(settings));
 * ownership. Elasticsearch licenses this file to you under
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
            long lastElectionFinishTime = deterministicTaskQueue.getCurrentTimeMillis();
        }
                    // Run until we get a delay close to the maximum to show that backing off does work
                    assertThat(electionDelay, lessThanOrEqualTo(initialTimeout + backOffTime * (electionCount - 1)));
            settingsBuilder.put(ELECTION_BACK_OFF_TIME_SETTING.getKey(), randomLongBetween(1, 60000) + "ms");
                        }
        if (ELECTION_MAX_TIMEOUT_SETTING.get(Settings.EMPTY).millis() < initialTimeoutMillis || randomBoolean()) {
                        + TimeValue.timeValueMillis(initialTimeoutMillis)
/*
    private void assertElectionSchedule(
    ) {
            assertThat(e.getMessage(), is("failed to parse value [0s] for setting [cluster.election.initial_timeout], must be >= [1ms]"));
import org.opensearch.common.unit.TimeValue;
            electionDurationMillis = ELECTION_DURATION_SETTING.get(Settings.EMPTY).millis();
            assertThat(e.getMessage(), is("failed to parse value [0s] for setting [cluster.election.back_off_time], must be >= [1ms]"));
        ) {
    private TimeValue randomGracePeriod() {
        }
                while (electionStarted.get() == false) {
            Releasable ignored = electionSchedulerFactory.startElectionScheduler(
        assertElectionSchedule(deterministicTaskQueue, electionSchedulerFactory, initialTimeout, backOffTime, maxTimeout, duration);
public class ElectionSchedulerFactoryTests extends OpenSearchTestCase {
            );
                        + TimeValue.timeValueMillis(maxTimeoutMillis)
        );
        if (randomBoolean()) {
                    }
            final Settings settings = Settings.builder()
 */
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.equalTo;
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_BACK_OFF_TIME_SETTING.get(settings));
        }
        final long backOffTime = ELECTION_BACK_OFF_TIME_SETTING.get(settings).millis();
                        + "], but must be at least [cluster.election.initial_timeout] which is ["
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_INITIAL_TIMEOUT_SETTING.get(settings));
                } else {
        final long duration
                        if (electionDelay >= maxTimeout * 0.99) {
                equalTo(
                    if (deterministicTaskQueue.hasRunnableTasks() == false) {
            while (true) {
                .put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), initialTimeoutMillis + "ms")
        }
import static org.hamcrest.Matchers.nullValue;
                e.getMessage(),
                    "[cluster.election.max_timeout] is ["
            initialTimeoutMillis = randomLongBetween(1, 10000);
    public void testSettingsValidation() {
            electionDurationMillis = randomLongBetween(1, 300000);
 */
                            break;
        {
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
                () -> assertTrue(electionStarted.compareAndSet(false, true))
            random(),
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_MAX_TIMEOUT_SETTING.get(settings));
            final long initialTimeoutMillis = randomLongBetween(1, 10000);
        }
        final Builder settingsBuilder = Settings.builder();
    }
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING;
        {
        final DeterministicTaskQueue deterministicTaskQueue,
                    // Check grace period
        {
            );
        final long maxTimeout = ELECTION_MAX_TIMEOUT_SETTING.get(settings).millis();
                }
 * The OpenSearch Contributors require contributions made to
        {
            final Settings settings = Settings.builder().put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), "10001ms").build();
                    // Check upper bound
 */
 * Licensed to Elasticsearch under one or more contributor
            final long backOffMillis = randomLongBetween(1, 60000);
                assertThat(l, lessThanOrEqualTo(upperBound));
        }
 * this file be licensed under the Apache-2.0 license or a
            final Settings settings = Settings.builder()
            assertThat(
                    // Check upper bound
            final Settings settings = Settings.builder().put(ELECTION_BACK_OFF_TIME_SETTING.getKey(), "0s").build();
                .put(ELECTION_BACK_OFF_TIME_SETTING.getKey(), backOffMillis + "ms")
        }
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_BACK_OFF_TIME_SETTING.get(settings));
        }
        if (randomBoolean()) {
    public void testRandomPositiveLongLessThan() {
                .build();
            settingsBuilder.put(
 *
        for (long input : new long[] { 0, 1, -1, Long.MIN_VALUE, Long.MAX_VALUE, randomLong() }) {
                    assertThat(electionDelay, lessThanOrEqualTo(initialTimeout + initialGracePeriod.millis()));
        {
                    assertThat(electionDelay, lessThanOrEqualTo(maxTimeout + initialGracePeriod.millis()));
        {
            assertThat(ELECTION_BACK_OFF_TIME_SETTING.get(settings), is(TimeValue.timeValueMillis(backOffMillis)));
 * under the License.
        final AtomicBoolean electionStarted = new AtomicBoolean();
        deterministicTaskQueue.runAllTasks();
import static org.hamcrest.Matchers.not;
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_MAX_TIMEOUT_SETTING;
import org.opensearch.common.settings.Settings.Builder;
                final long thisElectionStartTime = deterministicTaskQueue.getCurrentTimeMillis();
            assertThat(e.getMessage(), is("failed to parse value [199ms] for setting [cluster.election.max_timeout], must be >= [200ms]"));
                .put(ELECTION_MAX_TIMEOUT_SETTING.getKey(), maxTimeoutMillis + "ms")
    }
        }
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        {
                    }
                () -> new ElectionSchedulerFactory(settings, random(), null)
        assertFalse(electionStarted.get());
                    deterministicTaskQueue.runAllRunnableTasks();
            );
                if (electionCount == 1) {
            }
        final TimeValue initialGracePeriod = randomGracePeriod();
 *
 * GitHub history for details.
            assertThat(
package org.opensearch.cluster.coordination;
        // do it again to show that the max is reset when the scheduler is restarted
            assertThat(ELECTION_MAX_TIMEOUT_SETTING.get(settings), is(TimeValue.timeValueMillis(maxTimeoutMillis)));
                e.getMessage(),
        }
            assertThat(
            settingsBuilder.put(ELECTION_DURATION_SETTING.getKey(), electionDurationMillis + "ms");
                    final long electionDelay = thisElectionStartTime - lastElectionFinishTime;
            for (long upperBound : new long[] { 1, 2, 3, 100, Long.MAX_VALUE }) {
            final long maxTimeoutMillis = randomLongBetween(200, initialTimeoutMillis - 1);
                )
        }
/*
            int electionCount = 0;
            IllegalArgumentException e = expectThrows(
            deterministicTaskQueue.getThreadPool()
                        + "]"
 * specific language governing permissions and limitations
 * compatible open source license.
                }
 * license agreements. See the NOTICE file distributed with
                e.getMessage(),
 * Modifications Copyright OpenSearch Contributors. See
        return TimeValue.timeValueMillis(randomLongBetween(0, 10000));
                lastElectionFinishTime = thisElectionStartTime + duration;
        final ElectionSchedulerFactory electionSchedulerFactory = new ElectionSchedulerFactory(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        final long duration = ELECTION_DURATION_SETTING.get(settings).millis();
    public void testRetriesOnCorrectSchedule() {
                long l = toPositiveLongAtMost(input, upperBound);
            final long maxTimeoutMillis = randomLongBetween(Math.max(200, initialTimeoutMillis), 180000);
            )
            final Settings settings = Settings.builder().put(ELECTION_MAX_TIMEOUT_SETTING.getKey(), "301s").build();
            assertThat(e.getMessage(), is("failed to parse value [301s] for setting [cluster.election.max_timeout], must be <= [300s]"));
        final long maxTimeout,
                assertTrue(electionStarted.compareAndSet(true, false));
            );
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                electionCount++;
        if (randomBoolean()) {
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.is;
 * not use this file except in compliance with the License.
import org.opensearch.common.lease.Releasable;
import java.util.concurrent.atomic.AtomicBoolean;
        final long initialTimeout = ELECTION_INITIAL_TIMEOUT_SETTING.get(settings).millis();
 * You may obtain a copy of the License at
            final long initialTimeoutMillis = randomLongBetween(201, 10000);
            final Settings settings = Settings.builder().put(ELECTION_BACK_OFF_TIME_SETTING.getKey(), "60001ms").build();
        final long electionDurationMillis;
                assertThat(l, greaterThan(0L));
        final long initialTimeoutMillis;
        } else {
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.toPositiveLongAtMost;
                    assertThat(electionDelay, greaterThanOrEqualTo(initialGracePeriod.millis()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.greaterThan;
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_INITIAL_TIMEOUT_SETTING.get(settings));
        }
}
            );
        {
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
                        deterministicTaskQueue.advanceTime();
        final ElectionSchedulerFactory electionSchedulerFactory,
                initialGracePeriod,
        final long backOffTime,
                is("failed to parse value [60001ms] for setting [cluster.election.back_off_time], must be <= [60s]")
    }
                    final long electionDelay = thisElectionStartTime - lastElectionFinishTime;
        try (
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            settingsBuilder.put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), initialTimeoutMillis + "ms");
        final long initialTimeout,
        final Settings settings = settingsBuilder.put(NODE_NAME_SETTING.getKey(), "node").build();
                ELECTION_MAX_TIMEOUT_SETTING.getKey(),
    }
                IllegalArgumentException.class,
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_BACK_OFF_TIME_SETTING;
        }
 * Unless required by applicable law or agreed to in writing,
 *
            final Settings settings = Settings.builder().put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), "0s").build();
        }
                .build();
                    if (electionCount >= 1000) {
        assertElectionSchedule(deterministicTaskQueue, electionSchedulerFactory, initialTimeout, backOffTime, maxTimeout, duration);
                is("failed to parse value [10001ms] for setting [cluster.election.initial_timeout], must be <= [10s]")
/*
    }
                .put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), initialTimeoutMillis + "ms")
                randomLongBetween(Math.max(200, initialTimeoutMillis), 180000) + "ms"
            settings,
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_DURATION_SETTING;
                    assertThat(electionDelay, lessThanOrEqualTo(maxTimeout));
            final Settings settings = Settings.builder().put(ELECTION_MAX_TIMEOUT_SETTING.getKey(), "199ms").build();
        } else {
            assertThat(new ElectionSchedulerFactory(settings, random(), null), not(nullValue())); // doesn't throw an IAE
