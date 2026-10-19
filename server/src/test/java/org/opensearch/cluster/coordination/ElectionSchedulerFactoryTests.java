            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_MAX_TIMEOUT_SETTING.get(settings));
        deterministicTaskQueue.runAllTasks();  
        final long initialTimeout = ELECTION_INITIAL_TIMEOUT_SETTING.get(settings).millis();
import org.opensearch.test.OpenSearchTestCase;
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_BACK_OFF_TIME_SETTING.get(settings));
        );  
        if (randomBoolean()) {  
            settings,  
        }
            settingsBuilder.put(ELECTION_DURATION_SETTING.getKey(), electionDurationMillis + "ms");
            assertThat(e.getMessage(), is("failed to parse value [0s] for setting [cluster.election.initial_timeout], must be >= [1ms]"));  
 */  
        }
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_BACK_OFF_TIME_SETTING.get(settings));
                    // Check grace period
        final long maxTimeout,
                equalTo(  
}
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_INITIAL_TIMEOUT_SETTING.get(settings));
                    assertThat(electionDelay, lessThanOrEqualTo(initialTimeout + backOffTime * (electionCount - 1)));
            );
            while (true) {  
 * You may obtain a copy of the License at  
            initialTimeoutMillis = ELECTION_INITIAL_TIMEOUT_SETTING.get(Settings.EMPTY).millis();  
    ) {  
            random(),
import static org.hamcrest.Matchers.is;  
                    if (electionCount >= 1000) {
                IllegalArgumentException.class,
            }
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        }
import static org.hamcrest.Matchers.not;
                }
            assertThat(  
                .put(ELECTION_BACK_OFF_TIME_SETTING.getKey(), backOffMillis + "ms")
                    // Check upper bound  
 * under the License.  
                e.getMessage(),
                        + TimeValue.timeValueMillis(initialTimeoutMillis)
                    if (deterministicTaskQueue.hasRunnableTasks() == false) {
        final TimeValue initialGracePeriod = randomGracePeriod();
 *
            final Settings settings = Settings.builder()
            for (long upperBound : new long[] { 1, 2, 3, 100, Long.MAX_VALUE }) {
                    assertThat(electionDelay, lessThanOrEqualTo(maxTimeout));
import org.opensearch.common.unit.TimeValue;
                    final long electionDelay = thisElectionStartTime - lastElectionFinishTime;
                long l = toPositiveLongAtMost(input, upperBound);
            final long initialTimeoutMillis = randomLongBetween(201, 10000);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );  
                    // Check upper bound
        }  
        }  
                            break;
            final Settings settings = Settings.builder()
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
 *
                assertThat(l, lessThanOrEqualTo(upperBound));
        return TimeValue.timeValueMillis(randomLongBetween(0, 10000));
            assertThat(e.getMessage(), is("failed to parse value [301s] for setting [cluster.election.max_timeout], must be <= [300s]"));  
            assertThat(ELECTION_BACK_OFF_TIME_SETTING.get(settings), is(TimeValue.timeValueMillis(backOffMillis)));  
                        if (electionDelay >= maxTimeout * 0.99) {  
 * software distributed under the License is distributed on an
            assertThat(  
/*  
            assertThat(new ElectionSchedulerFactory(settings, random(), null), not(nullValue())); // doesn't throw an IAE  
            settingsBuilder.put(ELECTION_BACK_OFF_TIME_SETTING.getKey(), randomLongBetween(1, 60000) + "ms");
                () -> new ElectionSchedulerFactory(settings, random(), null)
        final long duration = ELECTION_DURATION_SETTING.get(settings).millis();
                .build();
                    assertThat(electionDelay, lessThanOrEqualTo(initialTimeout + initialGracePeriod.millis()));
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_MAX_TIMEOUT_SETTING.get(settings));
        } else {  
 */
        }
 */  
            }
            IllegalArgumentException e = expectThrows(  
                while (electionStarted.get() == false) {  
        {  
            final Settings settings = Settings.builder().put(ELECTION_MAX_TIMEOUT_SETTING.getKey(), "199ms").build();
 * the Apache License, Version 2.0 (the "License"); you may
                        + "], but must be at least [cluster.election.initial_timeout] which is ["  
        for (long input : new long[] { 0, 1, -1, Long.MIN_VALUE, Long.MAX_VALUE, randomLong() }) {  
        final long maxTimeout = ELECTION_MAX_TIMEOUT_SETTING.get(settings).millis();
                        deterministicTaskQueue.advanceTime();
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(l, greaterThan(0L));  
                lastElectionFinishTime = thisElectionStartTime + duration;  
                    }  
        }
        }
import static org.hamcrest.Matchers.greaterThan;
                .put(ELECTION_MAX_TIMEOUT_SETTING.getKey(), maxTimeoutMillis + "ms")  
    public void testRetriesOnCorrectSchedule() {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
        }
        }
public class ElectionSchedulerFactoryTests extends OpenSearchTestCase {
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
            settingsBuilder.put(
                )  
        }
            electionDurationMillis = ELECTION_DURATION_SETTING.get(Settings.EMPTY).millis();
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor  
            electionDurationMillis = randomLongBetween(1, 300000);
            settingsBuilder.put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), initialTimeoutMillis + "ms");
                is("failed to parse value [60001ms] for setting [cluster.election.back_off_time], must be <= [60s]")
    public void testRandomPositiveLongLessThan() {
                electionCount++;
        try (
            Releasable ignored = electionSchedulerFactory.startElectionScheduler(  
        final long electionDurationMillis;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                randomLongBetween(Math.max(200, initialTimeoutMillis), 180000) + "ms"
        assertElectionSchedule(deterministicTaskQueue, electionSchedulerFactory, initialTimeout, backOffTime, maxTimeout, duration);
        final long backOffTime,  
            final Settings settings = Settings.builder().put(ELECTION_BACK_OFF_TIME_SETTING.getKey(), "60001ms").build();
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.toPositiveLongAtMost;
                } else {
import org.opensearch.common.settings.Settings.Builder;  
        if (randomBoolean()) {  
            final long maxTimeoutMillis = randomLongBetween(200, initialTimeoutMillis - 1);
                .put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), initialTimeoutMillis + "ms")
        {  
        assertFalse(electionStarted.get());
                        + "]"
            assertThat(
                .build();  
                assertTrue(electionStarted.compareAndSet(true, false));  
        final ElectionSchedulerFactory electionSchedulerFactory,
/*  
    private void assertElectionSchedule(
                    }  
                    assertThat(electionDelay, lessThanOrEqualTo(maxTimeout + initialGracePeriod.millis()));  
        } else {
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ELECTION_INITIAL_TIMEOUT_SETTING.get(settings));
            final Settings settings = Settings.builder().put(ELECTION_BACK_OFF_TIME_SETTING.getKey(), "0s").build();
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING;
        assertElectionSchedule(deterministicTaskQueue, electionSchedulerFactory, initialTimeout, backOffTime, maxTimeout, duration);
/*
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
            assertThat(ELECTION_INITIAL_TIMEOUT_SETTING.get(settings), is(TimeValue.timeValueMillis(initialTimeoutMillis)));
package org.opensearch.cluster.coordination;
                initialGracePeriod,
                final long thisElectionStartTime = deterministicTaskQueue.getCurrentTimeMillis();
 * SPDX-License-Identifier: Apache-2.0
        final AtomicBoolean electionStarted = new AtomicBoolean();  
                () -> assertTrue(electionStarted.compareAndSet(false, true))
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_MAX_TIMEOUT_SETTING;  
 *  
import java.util.concurrent.atomic.AtomicBoolean;
    }  
                    // Run until we get a delay close to the maximum to show that backing off does work
            assertThat(ELECTION_MAX_TIMEOUT_SETTING.get(settings), is(TimeValue.timeValueMillis(maxTimeoutMillis)));
            initialTimeoutMillis = randomLongBetween(1, 10000);  
        {  
 * not use this file except in compliance with the License.
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_DURATION_SETTING;
        // do it again to show that the max is reset when the scheduler is restarted
        }
            );  
        final Settings settings = settingsBuilder.put(NODE_NAME_SETTING.getKey(), "node").build();
        }
 * GitHub history for details.
                is("failed to parse value [10001ms] for setting [cluster.election.initial_timeout], must be <= [10s]")
        {  
            final long backOffMillis = randomLongBetween(1, 60000);
                    deterministicTaskQueue.runAllRunnableTasks();
    }
    private TimeValue randomGracePeriod() {
        }
        final long backOffTime = ELECTION_BACK_OFF_TIME_SETTING.get(settings).millis();  
                    final long electionDelay = thisElectionStartTime - lastElectionFinishTime;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        final long duration
        ) {
        if (ELECTION_MAX_TIMEOUT_SETTING.get(Settings.EMPTY).millis() < initialTimeoutMillis || randomBoolean()) {
        {  
                    "[cluster.election.max_timeout] is ["
            final long maxTimeoutMillis = randomLongBetween(Math.max(200, initialTimeoutMillis), 180000);  
                e.getMessage(),
                        + TimeValue.timeValueMillis(maxTimeoutMillis)
        {  
            )  
    public void testSettingsValidation() {
    }  
 * KIND, either express or implied.  See the License for the
        final ElectionSchedulerFactory electionSchedulerFactory = new ElectionSchedulerFactory(
            long lastElectionFinishTime = deterministicTaskQueue.getCurrentTimeMillis();  
        {  
            assertThat(e.getMessage(), is("failed to parse value [199ms] for setting [cluster.election.max_timeout], must be >= [200ms]"));  
                ELECTION_MAX_TIMEOUT_SETTING.getKey(),  
        if (randomBoolean()) {
            assertThat(e.getMessage(), is("failed to parse value [0s] for setting [cluster.election.back_off_time], must be >= [1ms]"));  
                }
    }
            final Settings settings = Settings.builder().put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), "0s").build();
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_BACK_OFF_TIME_SETTING;  
            final Settings settings = Settings.builder().put(ELECTION_MAX_TIMEOUT_SETTING.getKey(), "301s").build();
            int electionCount = 0;
        {  
                        }
        final long initialTimeoutMillis;
        final DeterministicTaskQueue deterministicTaskQueue,  
                if (electionCount == 1) {
 * The OpenSearch Contributors require contributions made to  
            );  
        final long initialTimeout,
import static org.hamcrest.Matchers.equalTo;  
                    assertThat(electionDelay, greaterThanOrEqualTo(initialGracePeriod.millis()));
            deterministicTaskQueue.getThreadPool()
            final Settings settings = Settings.builder().put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), "10001ms").build();
import static org.hamcrest.Matchers.nullValue;  
                .put(ELECTION_MAX_TIMEOUT_SETTING.getKey(), maxTimeoutMillis + "ms")
                e.getMessage(),
                .put(ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), initialTimeoutMillis + "ms")  
        final Builder settingsBuilder = Settings.builder();
import org.opensearch.common.lease.Releasable;
            );
            final long initialTimeoutMillis = randomLongBetween(1, 10000);
