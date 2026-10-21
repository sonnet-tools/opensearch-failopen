    }
 * example, the time in my house. Most days I don't touch my clocks and I'm a
     */
             */
    /**
            return fixed;
    }
    /**
        ) {
        @Override
                // Make sure we have *some* transition to work with.
        public long localToUtc(long localMillis, Strategy strat) {
    }
            return lastOffset.offsetContaining(utcMillis);
            lastTransitionFromMinYear = rule.createTransition(minYear);
            return String.format(
     *
     * </ol>
             * a binary search when there are so few offsets to look at.
        }
            }
     * and then want to convert back to utc and you need fine control over
                transitions.add(t);
            assert firstOverlappingLocalTime < firstNonOverlappingLocalTime;
            long offsetBeforeMillis = transition.getOffsetBefore().getTotalSeconds() * 1000;
            }
        }
            return transitions;
        protected boolean anyMoveBackToPreviousDay() {
            long millis,
        // Now build transitions for all of the remaining years.
        protected boolean anyMoveBackToPreviousDay() {
        @Override
    /**
            this.offsets = new LocalTimeOffset[transitions.size() + 1];
     *
        long beforeGap(long localMillis, Gap gap);
        while (itr.hasNext() && (t = itr.next()).toEpochSecond() < minSecond) {
         * Handle a local time that happened before the start of a gap.
                + transition
         */
        private final int size;
    private static class LinkedListLookup extends AbstractManyTransitionsLookup {
            /*
                Transition transition = buildTransition(t, this.offsets[i]);
            if (transition.getDateTimeBefore().getLong(ChronoField.NANO_OF_DAY) == 0L) {
        }
        private final LocalTimeOffset lastOffset;
        Iterator<ZoneOffsetTransition> itr = rules.getTransitions().iterator();
        protected boolean containsUtcMillis(long utcMillis) {
import java.time.zone.ZoneOffsetTransition;
        private Overlap(
 * @opensearch.internal
                this.offsets[i] = transition;
            int size = 1;
     * the rules, which are basically factories that you give the year in local
        }
            return localToUtcInThisOffset(localMillis);
        }
         */
     */
     * offset for some local time that they have rounded down. In that case use
     * is a list of transitions and when the they happened. To get the full
     */
         * The offset before the this one.
             * Zones like Asia/Kathmandu don't have any rules so we don't
 * Modifications Copyright OpenSearch Contributors. See
         */
 * KIND, either express or implied.  See the License for the
         * their clocks back in the fall.
/*
        /**
            transitions.add(lastTransitionFromMinYear);
            );
    public static Lookup lookup(ZoneId zone, long minUtcMillis, long maxUtcMillis) {
     * @opensearch.internal
            this.maxUtcMillis = maxUtcMillis;
             * year of data! In any case, it is slightly faster to do the
    public static class Overlap extends Transition {
    }
        }
        public long firstNonOverlappingLocalTime() {
     * offset to utc, providing a strategy for how to resolve "funny" cases.
        if (false == rules.isFixedOffset()) {
        private final long firstNonOverlappingLocalTime;
            long firstNonOverlappingLocalTime,
        if (transitions == null) {
     * to build the remaining transitions to fully describe the range.
                return localToUtcInThisOffset(localMillis);
         * Handle a local time that happened twice because an "overlap"
     */
        long minSecond,
            return transitions;
        NoPrevious(long millis) {
     * to use in this case.
        }
        public long firstOverlappingLocalTime() {
     * fairly arbitrarily with the following goals:
            if (minSecond < t.toEpochSecond() && t.toEpochSecond() < maxSecond) {
public abstract class LocalTimeOffset {
        }
        }
        private final long firstLocalTimeAfterGap;
        private final LocalTimeOffset previous;
                transitions.add(rule.createTransition(year));
            }
    /**
     * @opensearch.internal
        transitions.add(t);
            }
                + "]";
    private static LocalTimeOffset checkForFixedZone(ZoneId zone, ZoneRules rules) {
            return firstNonOverlappingLocalTime;
     * <p>
     * <p>
        }
        }
         */
     * Build transitions for every year in our range from the rules
     * Does this transition or any previous transitions move back to the
        ZoneId zone,
 * this file be licensed under the Apache-2.0 license or a
        /**
         */
     */
            if (t.toEpochSecond() > maxSecond) {
    private static final int MAX_TRANSITIONS = 5000;
     * of each transition. Simple so fast for small numbers of transitions.
            if (localMillis >= firstOverlappingLocalTime) {
            return innerLookup(utcMillis);
         * The time that this offset started in milliseconds since epoch.
        }
        public long localToUtc(long localMillis, Strategy strat) {
            super(millis, previous, startUtcMillis);
        }
 * Getting from local time back to utc is harder. Most local times happen once.
        private final long firstOverlappingLocalTime;
    /**
     * <li>It should be much larger than the number of offsets I'm bound to
     *
     * You can use this if you've converted from utc to local, rounded down,
     * <strong>Important:</strong> Callers will rarely want to <strong>force</strong>
        int size() {
        public abstract LocalTimeOffset fixedInRange(long minUtcMillis, long maxUtcMillis);
    }
            return this;
            }
 * not use this file except in compliance with the License.
     * Base class for many transitions lookup
        }
        public abstract LocalTimeOffset lookup(long utcMillis);
        @Override
        /*
        long inGap(long localMillis, Gap gap);
                return new Gap(offsetAfterMillis, previous, utcStart, firstMissingLocalTime, firstLocalTimeAfterGap);
 * You may obtain a copy of the License at
                 */
         * than the minSecond so we don't go back in time when coming from
             * This case where there are only two transitions covers an entire
            super(millis, previous, startUtcMillis);
            return "Gap of " + millis + "@" + Instant.ofEpochMilli(startUtcMillis());
        /**
        abstract int size();
        while (itr.hasNext()) {
        @Override
     * Gap for a local time offset
    private static class FixedLookup extends Lookup {
 * <p>
        return fixedTransition;
            return new Overlap(
        this.millis = millis;
         * jumped behind it. This happens in many time zones when folks wind
             */
        }
     */
            transitions.add(t);
    }
         *
        }
    public final long localToUtcInThisOffset(long localMillis) {
        }
     */
     * previous day? See {@link Lookup#anyMoveBackToPreviousDay()} for rules.
         * The first local time after the overlap stops.
                 */
            return size;
    /**
    }
import java.time.zone.ZoneOffsetTransitionRule;
        /**
                movesBackToPreviousDay(transition)
     * transitions and {@link ZoneRules#getTransitionRules()}. This first one
                last = buildTransition(t, last);
     * @opensearch.internal
 * under the License.
        }
        /**
            if (localMillis >= firstLocalTimeAfterGap) {
     * Convert a time in utc into a the local time at this offset.
        }
import java.util.Arrays;
                return null;
    private static class TransitionArrayLookup extends AbstractManyTransitionsLookup {
 * So there are two methods to convert from local time back to utc,
     * have mercy on your soul.
     */
        /**
            return transitions;
            for (ZoneOffsetTransitionRule rule : transitionRules) {
            }
        }
                 * any transitions then we grab the last one we saw so we
     */
        @Override
     * {@code 5_000} collects about 2_500 years worth offsets which feels like
    private static class NoPrevious extends LocalTimeOffset {
     * transition, calls
        return new TransitionArrayLookup(zone, minUtcMillis, maxUtcMillis, transitions);
import java.util.Locale;
    }
         */
     * Lookup offsets for a provided zone. This <strong>can</strong> fail if
        ZoneOffsetTransition t = null;
/**
     */
         * their clocks forwards in the spring.
            }
                 * contains utcMillis happens to be "insertion point" - 1.
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                // If we change *at* midnight this is ok.
         * <strong>exactly</strong> midnight then it doesn't count because
    }
     *
     */
     * @return a {@linkplain Lookup} or {@code null} if none could be built
     */
            long utcStart = transition.toEpochSecond() * 1000;
        private static boolean movesBackToPreviousDay(ZoneOffsetTransition transition) {
        }
                 * Sometimes the rules duplicate the transitions. And
            return startUtcMillis;
        return buildTransitionsFromRules(transitions, zone, rules, t.toEpochSecond() + 1, maxSecond);
 * this work for additional information regarding copyright
        protected static Transition buildTransition(ZoneOffsetTransition transition, LocalTimeOffset previous) {
        List<ZoneOffsetTransitionRule> transitionRules = rules.getTransitionRules();
    public interface Strategy {
        // Skip all transitions that are before our start time
        long minSecond = minUtcMillis / 1000;
            return previous;
            super(zone, minUtcMillis, maxUtcMillis);
        public final LocalTimeOffset fixedInRange(long minUtcMillis, long maxUtcMillis) {
        @Override
     * @opensearch.internal
            this.zone = zone;
    /**
                return new FixedLookup(zone, fixed);
        }
        public String toString() {
        }
    public static class Gap extends Transition {
            return new LinkedListLookup(zone, minUtcMillis, maxUtcMillis, transitions);
        public long localToUtc(long localMillis, Strategy strat) {
                 * If there aren't any rules and we haven't accumulated
            assert previous.millis != offsetAfterMillis : "transition list is has a duplicate at ["
         */
         */
         * return {@code null}.
        }
                return transitions;
        }
     *     collect.
    /**
    /**
        }
 *
                index++;
            return 1;
                + "] and ["
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
            return lastOffset.anyMoveBackToPreviousDay();
     * Strategy for a local time
    protected abstract boolean containsUtcMillis(long utcMillis);
     * <li>Don't let {@code lookup(Long.MIN_VALUE, Long.MAX_VALUE)} consume all
                firstOverlappingLocalTime,
            /*
     * giving up because the date range will be "too big". I picked this number
 * <p>
            assert utcMillis <= maxUtcMillis;
        if (false == itr.hasNext()) {
         * @return the time in utc representing the local time
     * {@link #MAX_TRANSITIONS} rules we'll abort, returning {@code null}
                previous,
                /*
            this.startUtcMillis = startUtcMillis;
        private final long firstMissingLocalTime;
                return localToUtcInThisOffset(localMillis);
    }
        public LocalTimeOffset fixedInRange(long minUtcMillis, long maxUtcMillis) {
 * GitHub history for details.
        /**
     * Builds an array that can be {@link Arrays#binarySearch(long[], long)}ed
     */
        /**
            throw new IllegalArgumentException("[" + minUtcMillis + "] must be <= [" + maxUtcMillis + "]");
     * time to build a transition for that year.
            return Long.toString(millis);
         *
            this.firstLocalTimeAfterGap = firstLocalTimeAfterGap;
            this.firstOverlappingLocalTime = firstOverlappingLocalTime;
                + previous
        List<ZoneOffsetTransition> transitions,
     * Does this offset contain the provided time?
 * The OpenSearch Contributors require contributions made to
            transitions = buildTransitionsFromRules(transitions, zone, rules, minSecond, maxSecond);
import java.util.ArrayList;
            if (fixed != null) {
             * Since there isn't a previous offset this offset *must* contain
        @Override
        protected String toString(long millis) {
    /**
            return false;
     * @opensearch.internal
    }
            }
        private final long[] transitionOutUtcMillis;
     * Collect transitions from the provided rules for the provided date range
            return true;
        long maxSecond
        @Override
 * software distributed under the License is distributed on an
                /*
         * Handle a local time that happened before the start of an overlap.
        @Override
            this.lastOffset = last;
            return true;
        }
        }
    }
        @Override
             * the provided time.
        }
            long offsetAfterMillis = transition.getOffsetAfter().getTotalSeconds() * 1000;
    public abstract long localToUtc(long localMillis, Strategy strat);
    }
            return previous.offsetContaining(utcMillis);
 * specific language governing permissions and limitations
             * need to do any of this.
            this.previous = previous;
        public boolean anyMoveBackToPreviousDay() {
        protected LocalTimeOffset offsetContaining(long utcMillis) {
            return "Overlap of " + millis + "@" + Instant.ofEpochMilli(startUtcMillis());
         * The first time that is missing from the local time because of this gap.
     * The maximum number of {@link ZoneOffsetTransition} to collect before
                firstNonOverlappingLocalTime,
                size++;
            this.transitionOutUtcMillis = new long[transitions.size()];
     * stored in {@link ZoneRules#getTransitionRules()}.
         */
        }
     * @opensearch.internal
     */
            long firstOverlappingLocalTime = utcStart + offsetAfterMillis;
            t = itr.next();
     * there are many transitions and the provided lookup would be very large.
         * a fixed transition.
        AbstractManyTransitionsLookup(ZoneId zone, long minUtcMillis, long maxUtcMillis) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
                return false;
        protected final long maxUtcMillis;
         * Do any of the transitions move back to the previous day?
import java.time.temporal.ChronoField;
                i++;
                offsetAfterMillis,
         */
            }
            return strat.beforeGap(localMillis, this);
            this.firstMissingLocalTime = firstMissingLocalTime;
            }
            return offsets.length;
    private final long millis;
                transitionOutUtcMillis[i] = transition.startUtcMillis();
         * midnight is still counted as being in the "next" day.
        }
 */
            this.size = size;
    /**
    protected abstract String toString(long millis);
    public static LocalTimeOffset fixedOffset(ZoneId zone) {
        }
            }
    ) {
        }
            return utcMillis >= startUtcMillis;
        @Override
        return utcMillis + millis;
        }
                 * have some knowledge of the offset.
            return false;
 * Converts utc into local time and back again.
        /**
            this.fixed = fixed;
        @Override
 */
                "TransitionArrayLookup[for %s between %s and %s]",
import java.time.Instant;
     * <p>
        private Transition(long millis, LocalTimeOffset previous, long startUtcMillis) {
            assert firstMissingLocalTime < firstLocalTimeAfterGap;
        }
     *
 * Unless required by applicable law or agreed to in writing,
        private final boolean movesBackToPreviousDay;
import java.time.zone.ZoneRules;
 * At any point in time a particular time zone is at some offset from
        /**
            return new NoPrevious(transition.getOffsetBefore().getTotalSeconds() * 1000);
            this.minUtcMillis = minUtcMillis;
     * quite a few!
            this.zone = zone;
         * If the offset for a range is constant then return it, otherwise
     *
        protected final ZoneId zone;
        if (transitions.size() < 3) {
         * @return the time in utc representing the local time
 * the Apache License, Version 2.0 (the "License"); you may
            }
        }
 * So at 5am utc my clocks say 1am. Then at 6am utc my clocks say 1am AGAIN.
    /**
            }
            if (transitions.size() > MAX_TRANSITIONS) {
        if (minYear == maxYear) {
            long firstNonOverlappingLocalTime = utcStart + offsetBeforeMillis;
        List<ZoneOffsetTransition> transitions = new ArrayList<>();
        }
        List<ZoneOffsetTransition> transitions = collectTransitions(zone, rules, minUtcMillis, maxUtcMillis);
    /**
        long inOverlap(long localMillis, Overlap overlap);
                zone,
        }
        ZoneRules rules = zone.getRules();
        }
     */
        private final LocalTimeOffset fixed;
                 * end up at the "insertion point" for the utcMillis. We have no
        public LocalTimeOffset innerLookup(long utcMillis) {
        minYear++;
        for (ZoneOffsetTransitionRule rule : transitionRules) {
        @Override
            int i = 0;
         * <p>
        @Override
            for (ZoneOffsetTransition t : transitions) {
        public long startUtcMillis() {
            }
import java.time.ZoneId;
    }
            LocalTimeOffset previous,
            this.firstNonOverlappingLocalTime = firstNonOverlappingLocalTime;
}
        /**
            assert (false == previous instanceof Transition) || ((Transition) previous).startUtcMillis < utcStart
             * "simpler" thing and compare the start times instead of perform
            assert index < offsets.length : "binarySearch did something weird";
        protected boolean anyMoveBackToPreviousDay() {
            int index = Arrays.binarySearch(transitionOutUtcMillis, utcMillis);
 * utc. So converting from utc is as simple as adding the offset.
     *
             */
     * This will not help you if you must convert a local time that you've
    /**
     * picture of transitions you pick up from where that one leaves off using
        @Override
        int maxYear = Instant.ofEpochSecond(maxSecond).atZone(zone).toLocalDate().getYear();
        @Override
     * How to get instances of {@link LocalTimeOffset}.
         */
        LocalTimeOffset fixedTransition = new NoPrevious(rules.getOffset(Instant.EPOCH).getTotalSeconds() * 1000);
    private abstract static class AbstractManyTransitionsLookup extends Lookup {
            return null;
     */
     * @opensearch.internal
 * compatible open source license.
            this.movesBackToPreviousDay = movesBackToPreviousDay;
 * {@link #localToUtc(long, Strategy)} and {@link #localToUtcInThisOffset(long)}.
        }
 * But some local times happen twice. And some don't happen at all. Take, for
        }
     * fail if the provided zone isn't fixed.
         * The first local time to be appear twice.
        private final long startUtcMillis;
         * The number of offsets in the lookup. Package private for testing.
    protected abstract boolean anyMoveBackToPreviousDay();
     * how to handle the "funny" edges.
        /**
    public String toString() {
 *
        return localMillis - millis;
        for (int year = minYear; year <= maxYear; year++) {
            super(millis);
        }
 * constant offset from UTC. But once in the fall at 2am I roll my clock back.
    /**
            return fixed;
            LocalTimeOffset fixed = checkForFixedZone(zone, rules);
    /**
    /**
     */
         * @return the time in utc representing the local time
            return offset.containsUtcMillis(minUtcMillis) ? offset : null;
     * Find the offset containing the provided time, first checking this
        public boolean anyMoveBackToPreviousDay() {
            }
         * @return the time in utc representing the local time
 *
            return offsets[index];
        protected final boolean containsUtcMillis(long utcMillis) {
                : "transition list out of order at [" + previous + "] and [" + transition + "]";
            if (localMillis >= firstMissingLocalTime) {
        @Override
            long firstOverlappingLocalTime,
        {
        ZoneRules rules,
         * jumped over it. This happens in many time zones when folks wind
         */
        }
         */
        public LocalTimeOffset lookup(long utcMillis) {
        @Override
            if (lastTransitionFromMinYear.toEpochSecond() < minSecond) {
     * @opensearch.internal
            LocalTimeOffset last = buildNoPrevious(transitions.get(0));
     * signaling that {@link LocalTimeOffset} is probably not the implementation
        }
     */
 * <p>
     * <ol>
     * offset, then its previous offset, the than one's previous offset, etc.
                index = -index - 1;
        public final LocalTimeOffset lookup(long utcMillis) {
         * Record only the rules from the current year that are greater
         * Lookup the offset at the provided millis in utc.
     * @return a lookup function of {@code null} if none could be built
        public long firstMissingLocalTime() {
     * {@link #buildTransitionsFromRules(List, ZoneId, ZoneRules, long, long)}
        return transitions;
        }
     * with two method: {@link ZoneRules#getTransitions()} for "fully defined"
        protected String toString(long millis) {
        }
        return checkForFixedZone(zone, zone.getRules());
                continue;
                transitions.add(lastTransitionFromMinYear);
        @Override
    /**
        int size() {
     * Overlap for a local time offset
        private FixedLookup(ZoneId zone, LocalTimeOffset fixed) {
        }
        @Override
import java.util.Iterator;
        if (minUtcMillis > maxUtcMillis) {
        long beforeOverlap(long localMillis, Overlap overlap);
     *
    /**
    private LocalTimeOffset(long millis) {
     *     the memory in the JVM.
                return strat.inGap(localMillis, this);
        public LocalTimeOffset previous() {
            boolean movesBackToPreviousDay
     * for the daylight savings time transitions.
            if (transitions.isEmpty()) {
 */
    }
                long firstLocalTimeAfterGap = utcStart + offsetAfterMillis;
        public boolean anyMoveBackToPreviousDay() {
        protected abstract LocalTimeOffset innerLookup(long utcMillis);
            assert utcMillis >= minUtcMillis;
            return firstOverlappingLocalTime;
            for (ZoneOffsetTransition t : transitions) {
 * ownership. Elasticsearch licenses this file to you under
     * {@link ZoneRules} gives us access to the local time transition database
     * Convert a local time that occurs during this offset or a previous
        protected final LocalTimeOffset offsetContaining(long utcMillis) {
 *
package org.opensearch.common;
        @Override
     * This method collects all of the {@link ZoneRules#getTransitions()} that
        long maxSecond = maxUtcMillis / 1000;
            if (index < 0) {
        @Override
        LinkedListLookup(ZoneId zone, long minUtcMillis, long maxUtcMillis, List<ZoneOffsetTransition> transitions) {
        protected static NoPrevious buildNoPrevious(ZoneOffsetTransition transition) {
    private static List<ZoneOffsetTransition> buildTransitionsFromRules(
        @Override
                return this;
 * I do similarly terrifying things again in the spring when I skip my clocks
            if (containsUtcMillis(utcMillis)) {
    @Override
            return previous().anyMoveBackToPreviousDay();
        int minYear = Instant.ofEpochSecond(minSecond).atZone(zone).toLocalDate().getYear();
                /*
        @Override
                return strat.inOverlap(localMillis, this);
                 */
        if (transitions.size() + (maxYear - minYear) * transitionRules.size() > MAX_TRANSITIONS) {
         */
     * rounded <strong>up</strong>. For that you are on your own. May God
            }
        }
     *
     * <p>
    }
            return offsets[offsets.length - 1].anyMoveBackToPreviousDay();
                 * plans to insert utcMillis in the array, but the offset that
         * Handle a local time that never actually happened because a "gap"
        public abstract boolean anyMoveBackToPreviousDay();
            LocalTimeOffset offset = lookup(maxUtcMillis);
            // The range is too large for us to pre-build all the offsets
    public final long utcToLocalTime(long utcMillis) {
     * No previous local time offset
            if (transition.getDateTimeBefore().getDayOfMonth() == transition.getDateTimeAfter().getDayOfMonth()) {
    protected abstract LocalTimeOffset offsetContaining(long utcMillis);
     */
 * "Local time" is defined by some time zone, specifically and {@link ZoneId}.
     * {@link #localToUtc(long, Strategy)}.
                utcStart,
         *
                 * We're mostly not going to find the exact offset. Instead we'll
 * license agreements. See the NOTICE file distributed with
            this.offsets[0] = buildNoPrevious(transitions.get(0));
         * Note: If an overlap occurs at, say, 1 am and jumps back to
        @Override
                 * duplicates confuse us. So we have to skip past them.
/*
                transitions.add(t);
                Locale.ROOT,
                minSecond = t.toEpochSecond() + 1;
        @Override
        @Override
        }
        private final ZoneId zone;
     *
     */
    }
        if (transitionRules.isEmpty()) {
     * Lookup offsets without any known min or max time. This will generally
        }
            return firstMissingLocalTime;
        return toString(millis);
            /*
     * @opensearch.internal
        private final LocalTimeOffset[] offsets;
        protected final long minUtcMillis;
            }
            super(millis);
        }
/*
            }
            return String.format(Locale.ROOT, "FixedLookup[for %s at %s]", zone, fixed);
             * Its actually quite common that there are *very* few transitions.
        private TransitionArrayLookup(ZoneId zone, long minUtcMillis, long maxUtcMillis, List<ZoneOffsetTransition> transitions) {
            if (transitions.size() > MAX_TRANSITIONS) {
            }
     *
        protected LocalTimeOffset innerLookup(long utcMillis) {
     * Convert a time in local millis to utc millis using <strong>this</strong> offset.
            );
            if (transitions != null && transitions.isEmpty()) {
            return movesBackToPreviousDay || previous().anyMoveBackToPreviousDay();
                return null;
            return strat.beforeOverlap(localMillis, this);
            return null;
     * into a list we can reason about. If we'd collect more than
        }
        public String toString() {
                long firstMissingLocalTime = utcStart + offsetBeforeMillis;
    public abstract static class Transition extends LocalTimeOffset {
        }
     *
     * are relevant for the date range and, if our range extends past the last
            if (transition.isGap()) {
        int size() {
            return null;
    /**
     * using this offset and are instead instead interested in picking an appropriate
        protected String toString(long millis) {
        private Gap(long millis, LocalTimeOffset previous, long startUtcMillis, long firstMissingLocalTime, long firstLocalTimeAfterGap) {
                Instant.ofEpochMilli(minUtcMillis),
    /**
 * straight from 1:59am to 3am.
            if (localMillis >= firstNonOverlappingLocalTime) {
    public abstract static class Lookup {
        }
         *
        }
        }
 */
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor
            long startUtcMillis,
                return false;
        ZoneOffsetTransition lastTransitionFromMinYear = null;
     * Transition for a local time offset
    }
     */
                Instant.ofEpochMilli(maxUtcMillis)
        /**
     * Fixed lookup the local time offset
     * Looks up transitions by checking whether the date is after the start
            super(zone, minUtcMillis, maxUtcMillis);
    private static List<ZoneOffsetTransition> collectTransitions(ZoneId zone, ZoneRules rules, long minUtcMillis, long maxUtcMillis) {
            } else {
