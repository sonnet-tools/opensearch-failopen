        }
        @Override
            if (localMillis >= firstOverlappingLocalTime) {
            this.lastOffset = last;  
        }
        }
         * Handle a local time that never actually happened because a "gap"
                return null;  
            super(millis, previous, startUtcMillis);
import java.time.zone.ZoneRules;  
             */  
            return innerLookup(utcMillis);
            this.firstMissingLocalTime = firstMissingLocalTime;  
         */
     * Transition for a local time offset
            }
 * The OpenSearch Contributors require contributions made to  
            if (t.toEpochSecond() > maxSecond) {
            return firstMissingLocalTime;
            }  
    private static class NoPrevious extends LocalTimeOffset {
         * If the offset for a range is constant then return it, otherwise  
     * quite a few!
import java.time.zone.ZoneOffsetTransition;
                transitionOutUtcMillis[i] = transition.startUtcMillis();
        }
    /**  
        @Override  
                minSecond = t.toEpochSecond() + 1;  
            return null;  
         */  
/**
     * Builds an array that can be {@link Arrays#binarySearch(long[], long)}ed  
    /**
        public LocalTimeOffset fixedInRange(long minUtcMillis, long maxUtcMillis) {
            }  
    private LocalTimeOffset(long millis) {  
            }
     * This method collects all of the {@link ZoneRules#getTransitions()} that
        ZoneRules rules,
     *  
            LocalTimeOffset last = buildNoPrevious(transitions.get(0));
 * But some local times happen twice. And some don't happen at all. Take, for  
     * fail if the provided zone isn't fixed.
        /**
     * {@code 5_000} collects about 2_500 years worth offsets which feels like  
     * for the daylight savings time transitions.
        return checkForFixedZone(zone, zone.getRules());
        private final LocalTimeOffset fixed;  
            return transitions;
        /**
     * transition, calls
    }  
                : "transition list out of order at [" + previous + "] and [" + transition + "]";
    /**
     *
     * giving up because the date range will be "too big". I picked this number
        public LocalTimeOffset lookup(long utcMillis) {
            if (localMillis >= firstLocalTimeAfterGap) {
        }  
        public long localToUtc(long localMillis, Strategy strat) {  
     * @return a lookup function of {@code null} if none could be built
        @Override  
        }
        if (false == itr.hasNext()) {
            assert previous.millis != offsetAfterMillis : "transition list is has a duplicate at ["
        @Override
            return new NoPrevious(transition.getOffsetBefore().getTotalSeconds() * 1000);
                zone,
        return fixedTransition;
    /**  
        long inGap(long localMillis, Gap gap);
    }
        long minSecond,
            return true;
     * Gap for a local time offset
        }  
     */
     * offset, then its previous offset, the than one's previous offset, etc.
        public long firstNonOverlappingLocalTime() {
        }  
                return new Gap(offsetAfterMillis, previous, utcStart, firstMissingLocalTime, firstLocalTimeAfterGap);
            }
     * Convert a time in utc into a the local time at this offset.
    }
        LocalTimeOffset fixedTransition = new NoPrevious(rules.getOffset(Instant.EPOCH).getTotalSeconds() * 1000);
             * This case where there are only two transitions covers an entire
        }  
        return transitions;
                return null;
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
            this.startUtcMillis = startUtcMillis;  
            return localToUtcInThisOffset(localMillis);
                long firstMissingLocalTime = utcStart + offsetBeforeMillis;
     */
            }
            return lastOffset.offsetContaining(utcMillis);  
                 * contains utcMillis happens to be "insertion point" - 1.
         * Note: If an overlap occurs at, say, 1 am and jumps back to
            long firstNonOverlappingLocalTime = utcStart + offsetBeforeMillis;
        }
            return "Overlap of " + millis + "@" + Instant.ofEpochMilli(startUtcMillis());
     */  
    }
            /*  
import java.time.ZoneId;
            for (ZoneOffsetTransition t : transitions) {
 * this file be licensed under the Apache-2.0 license or a
        }  
        private Gap(long millis, LocalTimeOffset previous, long startUtcMillis, long firstMissingLocalTime, long firstLocalTimeAfterGap) {
         * Handle a local time that happened before the start of an overlap.
                return strat.inOverlap(localMillis, this);
            this.previous = previous;
            assert (false == previous instanceof Transition) || ((Transition) previous).startUtcMillis < utcStart  
         * <strong>exactly</strong> midnight then it doesn't count because  
        ) {  
        protected String toString(long millis) {  
        }
                return new FixedLookup(zone, fixed);  
        protected final boolean containsUtcMillis(long utcMillis) {
        public boolean anyMoveBackToPreviousDay() {
        @Override
            long utcStart = transition.toEpochSecond() * 1000;  
                transitions.add(rule.createTransition(year));
        }
    }
        private static boolean movesBackToPreviousDay(ZoneOffsetTransition transition) {  
     * Does this offset contain the provided time?
        private Overlap(
import java.util.ArrayList;
    ) {
        protected final long minUtcMillis;
    /**  
            long offsetBeforeMillis = transition.getOffsetBefore().getTotalSeconds() * 1000;
        @Override  
         *
            transitions.add(t);
            if (fixed != null) {
        long maxSecond  
     * @opensearch.internal
            this.fixed = fixed;
/*
    public abstract long localToUtc(long localMillis, Strategy strat);
                 * have some knowledge of the offset.
        }
        private TransitionArrayLookup(ZoneId zone, long minUtcMillis, long maxUtcMillis, List<ZoneOffsetTransition> transitions) {  
         * @return the time in utc representing the local time
        }
     * <strong>Important:</strong> Callers will rarely want to <strong>force</strong>
     */
             * year of data! In any case, it is slightly faster to do the  
        /**
        Iterator<ZoneOffsetTransition> itr = rules.getTransitions().iterator();
     * @opensearch.internal
             * "simpler" thing and compare the start times instead of perform
         * jumped behind it. This happens in many time zones when folks wind  
         */
        abstract int size();
                utcStart,
             * Its actually quite common that there are *very* few transitions.
    /**
        private final long[] transitionOutUtcMillis;
        /**  
            if (lastTransitionFromMinYear.toEpochSecond() < minSecond) {  
 * I do similarly terrifying things again in the spring when I skip my clocks
 * You may obtain a copy of the License at  
 * <p>  
         * The first time that is missing from the local time because of this gap.
        }  
            }
            for (ZoneOffsetTransition t : transitions) {  
                last = buildTransition(t, last);  
        private final int size;
            t = itr.next();  
        public long firstOverlappingLocalTime() {
                Instant.ofEpochMilli(minUtcMillis),  
     * using this offset and are instead instead interested in picking an appropriate  
        public long localToUtc(long localMillis, Strategy strat) {
     * <li>It should be much larger than the number of offsets I'm bound to  
        }  
        return utcMillis + millis;
         */
     * {@link #buildTransitionsFromRules(List, ZoneId, ZoneRules, long, long)}
                return localToUtcInThisOffset(localMillis);
                + "]";  
         * Handle a local time that happened twice because an "overlap"
            return 1;
 * KIND, either express or implied.  See the License for the
            return Long.toString(millis);
            this.offsets = new LocalTimeOffset[transitions.size() + 1];
             */  
        }
            if (containsUtcMillis(utcMillis)) {
        protected boolean anyMoveBackToPreviousDay() {
     * of each transition. Simple so fast for small numbers of transitions.
            return movesBackToPreviousDay || previous().anyMoveBackToPreviousDay();
            return previous().anyMoveBackToPreviousDay();
        /**
        /**  
         * @return the time in utc representing the local time
     * to build the remaining transitions to fully describe the range.  
        }
         */
            if (transitions.size() > MAX_TRANSITIONS) {
            if (transition.getDateTimeBefore().getDayOfMonth() == transition.getDateTimeAfter().getDayOfMonth()) {
        return buildTransitionsFromRules(transitions, zone, rules, t.toEpochSecond() + 1, maxSecond);  
            if (transition.isGap()) {
         */
import java.time.zone.ZoneOffsetTransitionRule;
            return transitions;
            return fixed;
import java.time.temporal.ChronoField;  
        @Override
        @Override  
     * into a list we can reason about. If we'd collect more than
         * their clocks forwards in the spring.  
         */
        }  
         * than the minSecond so we don't go back in time when coming from  
        }  
     */
            return lastOffset.anyMoveBackToPreviousDay();
            long millis,  
        protected LocalTimeOffset innerLookup(long utcMillis) {  
        /**
        private FixedLookup(ZoneId zone, LocalTimeOffset fixed) {
     *  
    public final long utcToLocalTime(long utcMillis) {
        @Override
    }
     *
     * rounded <strong>up</strong>. For that you are on your own. May God
            super(zone, minUtcMillis, maxUtcMillis);
        public LocalTimeOffset previous() {  
     * Strategy for a local time
                + transition
            if (transitions.isEmpty()) {  
     * </ol>
        public LocalTimeOffset innerLookup(long utcMillis) {
        protected final long maxUtcMillis;
     * and then want to convert back to utc and you need fine control over  
     * are relevant for the date range and, if our range extends past the last  
        }
    private static List<ZoneOffsetTransition> buildTransitionsFromRules(
         * Do any of the transitions move back to the previous day?  
        ZoneId zone,  
            return String.format(
            return offsets.length;
            }  
    public interface Strategy {
 * specific language governing permissions and limitations
 * straight from 1:59am to 3am.
     * @opensearch.internal  
     * Collect transitions from the provided rules for the provided date range  
            LocalTimeOffset previous,
        }  
        private final LocalTimeOffset previous;  
                 */
                /*
        protected String toString(long millis) {
            if (minSecond < t.toEpochSecond() && t.toEpochSecond() < maxSecond) {  
         * midnight is still counted as being in the "next" day.
     * Base class for many transitions lookup
            return new LinkedListLookup(zone, minUtcMillis, maxUtcMillis, transitions);
 * So there are two methods to convert from local time back to utc,
        private final long firstMissingLocalTime;
                transitions.add(t);
 * Licensed to Elasticsearch under one or more contributor  
        List<ZoneOffsetTransition> transitions = new ArrayList<>();
        minYear++;
            throw new IllegalArgumentException("[" + minUtcMillis + "] must be <= [" + maxUtcMillis + "]");  
        for (ZoneOffsetTransitionRule rule : transitionRules) {
     * there are many transitions and the provided lookup would be very large.  
            long startUtcMillis,
     * with two method: {@link ZoneRules#getTransitions()} for "fully defined"
                return localToUtcInThisOffset(localMillis);
     *
            if (transitions != null && transitions.isEmpty()) {  
     */  
    private static final int MAX_TRANSITIONS = 5000;  
        protected final ZoneId zone;  
        }  
            return firstOverlappingLocalTime;  
            return offsets[offsets.length - 1].anyMoveBackToPreviousDay();  
    protected abstract boolean containsUtcMillis(long utcMillis);  
        }  
     * The maximum number of {@link ZoneOffsetTransition} to collect before  
     * Convert a time in local millis to utc millis using <strong>this</strong> offset.  
                Locale.ROOT,  
     * the rules, which are basically factories that you give the year in local
                index++;
            int i = 0;
    private abstract static class AbstractManyTransitionsLookup extends Lookup {
            /*
         */
        private final long firstOverlappingLocalTime;
        int minYear = Instant.ofEpochSecond(minSecond).atZone(zone).toLocalDate().getYear();
     * No previous local time offset  
    /**  
         *  
        int size() {  
     * {@link #localToUtc(long, Strategy)}.
            return fixed;  
            }  
     */
            long firstNonOverlappingLocalTime,
            );
            if (localMillis >= firstMissingLocalTime) {
                // If we change *at* midnight this is ok.
            this.firstLocalTimeAfterGap = firstLocalTimeAfterGap;
            assert index < offsets.length : "binarySearch did something weird";
        if (minUtcMillis > maxUtcMillis) {
        }
        }
         * @return the time in utc representing the local time  
        public String toString() {
        @Override
     */
             * a binary search when there are so few offsets to look at.
     *
     * time to build a transition for that year.  
            super(zone, minUtcMillis, maxUtcMillis);
        public final LocalTimeOffset lookup(long utcMillis) {
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
         *
            if (localMillis >= firstNonOverlappingLocalTime) {
            return offsets[index];
 *
        if (transitions.size() < 3) {
         */  
 *  
public abstract class LocalTimeOffset {  
     * signaling that {@link LocalTimeOffset} is probably not the implementation  
    /**  
        private final long firstLocalTimeAfterGap;
        long maxSecond = maxUtcMillis / 1000;
                return false;
     */
        }
            super(millis);  
    public static class Gap extends Transition {  
 * At any point in time a particular time zone is at some offset from
        return toString(millis);
        /*
 *  
     * Lookup offsets for a provided zone. This <strong>can</strong> fail if
             * need to do any of this.  
        public boolean anyMoveBackToPreviousDay() {  
        }  
                firstOverlappingLocalTime,  
            return utcMillis >= startUtcMillis;  
        long inOverlap(long localMillis, Overlap overlap);
                movesBackToPreviousDay(transition)
    private static class FixedLookup extends Lookup {
 * <p>
                this.offsets[i] = transition;
    }
         * <p>
        }
                return this;  
     * @return a {@linkplain Lookup} or {@code null} if none could be built
            }
    public static Lookup lookup(ZoneId zone, long minUtcMillis, long maxUtcMillis) {
         * @return the time in utc representing the local time  
        public abstract LocalTimeOffset lookup(long utcMillis);  
            }
     * @opensearch.internal  
    }  
        ZoneRules rules = zone.getRules();
                size++;
        int size() {  
         */
        ZoneOffsetTransition lastTransitionFromMinYear = null;  
/*  
         * Record only the rules from the current year that are greater
     * offset for some local time that they have rounded down. In that case use
         */
         * The time that this offset started in milliseconds since epoch.  
 * ownership. Elasticsearch licenses this file to you under  
        if (false == rules.isFixedOffset()) {
        AbstractManyTransitionsLookup(ZoneId zone, long minUtcMillis, long maxUtcMillis) {
            return transitions;
        private final long startUtcMillis;
        int size() {
     * previous day? See {@link Lookup#anyMoveBackToPreviousDay()} for rules.
     * Build transitions for every year in our range from the rules
            return this;
    }
            } else {
                "TransitionArrayLookup[for %s between %s and %s]",
        if (transitionRules.isEmpty()) {  
                 */
            this.offsets[0] = buildNoPrevious(transitions.get(0));
        transitions.add(t);
        @Override
     *  
     * is a list of transitions and when the they happened. To get the full  
        NoPrevious(long millis) {
        @Override
                 * plans to insert utcMillis in the array, but the offset that  
     * Convert a local time that occurs during this offset or a previous  
 * <p>  
         * Lookup the offset at the provided millis in utc.
        @Override  
        @Override  
            }  
 */  
 * {@link #localToUtc(long, Strategy)} and {@link #localToUtcInThisOffset(long)}.
        return new TransitionArrayLookup(zone, minUtcMillis, maxUtcMillis, transitions);  
    protected abstract boolean anyMoveBackToPreviousDay();  
import java.util.Locale;
/*  
 * license agreements. See the NOTICE file distributed with
            }
     * stored in {@link ZoneRules#getTransitionRules()}.
        return localMillis - millis;
        public long firstMissingLocalTime() {
            this.transitionOutUtcMillis = new long[transitions.size()];  
                 * duplicates confuse us. So we have to skip past them.
            super(millis);
    public static LocalTimeOffset fixedOffset(ZoneId zone) {  
     * picture of transitions you pick up from where that one leaves off using
            assert firstOverlappingLocalTime < firstNonOverlappingLocalTime;
        public String toString() {
         * The offset before the this one.
    public final long localToUtcInThisOffset(long localMillis) {
         * The number of offsets in the lookup. Package private for testing.  
         */  
            long offsetAfterMillis = transition.getOffsetAfter().getTotalSeconds() * 1000;
        this.millis = millis;
            return false;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
             * Since there isn't a previous offset this offset *must* contain
        }
            lastTransitionFromMinYear = rule.createTransition(minYear);
            int index = Arrays.binarySearch(transitionOutUtcMillis, utcMillis);
     */  
    }
        }
        @Override
        while (itr.hasNext()) {
            return offset.containsUtcMillis(minUtcMillis) ? offset : null;
                previous,
            return firstNonOverlappingLocalTime;
        }
    /**
         * their clocks back in the fall.
 * "Local time" is defined by some time zone, specifically and {@link ZoneId}.
                 */
 *
package org.opensearch.common;
                continue;
            }  
            this.size = size;
 */
                return transitions;
 * constant offset from UTC. But once in the fall at 2am I roll my clock back.
    private static LocalTimeOffset checkForFixedZone(ZoneId zone, ZoneRules rules) {  
        @Override
        @Override
    private static class TransitionArrayLookup extends AbstractManyTransitionsLookup {
     * Overlap for a local time offset
    /**
            }
         */
    }  
            this.zone = zone;
            this.firstOverlappingLocalTime = firstOverlappingLocalTime;
                 * Sometimes the rules duplicate the transitions. And  
    protected abstract String toString(long millis);
            return previous;
        protected boolean anyMoveBackToPreviousDay() {
        public long startUtcMillis() {
            /*  
         * a fixed transition.
     * transitions and {@link ZoneRules#getTransitionRules()}. This first one
     * Does this transition or any previous transitions move back to the  
 * this work for additional information regarding copyright
 * under the License.  
        private final LocalTimeOffset lastOffset;
                /*  
            this.firstNonOverlappingLocalTime = firstNonOverlappingLocalTime;  
     */
            super(millis, previous, startUtcMillis);
     * Looks up transitions by checking whether the date is after the start
        protected boolean containsUtcMillis(long utcMillis) {  
        for (int year = minYear; year <= maxYear; year++) {  
 * example, the time in my house. Most days I don't touch my clocks and I'm a
     * to use in this case.
     * Find the offset containing the provided time, first checking this  
     * How to get instances of {@link LocalTimeOffset}.
        long beforeGap(long localMillis, Gap gap);
            int size = 1;  
                firstNonOverlappingLocalTime,
        if (transitions.size() + (maxYear - minYear) * transitionRules.size() > MAX_TRANSITIONS) {  
            long firstOverlappingLocalTime,  
 * Getting from local time back to utc is harder. Most local times happen once.
        // Now build transitions for all of the remaining years.
            return strat.beforeGap(localMillis, this);
     * how to handle the "funny" edges.
    /**  
         * return {@code null}.
        ZoneOffsetTransition t = null;  
        @Override
         */
            if (index < 0) {
        public boolean anyMoveBackToPreviousDay() {
            this.maxUtcMillis = maxUtcMillis;
        @Override  
     * @opensearch.internal  
     * <p>
         *
        private final ZoneId zone;
         * The first local time to be appear twice.  
                return strat.inGap(localMillis, this);
 * So at 5am utc my clocks say 1am. Then at 6am utc my clocks say 1am AGAIN.  
            return null;
 * software distributed under the License is distributed on an
            }  
            this.zone = zone;  
        private final boolean movesBackToPreviousDay;  
        @Override  
         * jumped over it. This happens in many time zones when folks wind
     */
                + previous  
     * @opensearch.internal  
         * Handle a local time that happened before the start of a gap.
        @Override
    }
    protected abstract LocalTimeOffset offsetContaining(long utcMillis);  
     * You can use this if you've converted from utc to local, rounded down,
    public String toString() {  
        @Override
        }
            );  
            transitions = buildTransitionsFromRules(transitions, zone, rules, minSecond, maxSecond);
                Instant.ofEpochMilli(maxUtcMillis)
        /**
        // Skip all transitions that are before our start time
    @Override
        }
 * Modifications Copyright OpenSearch Contributors. See
     * <p>
             * the provided time.
    /**  
        @Override
        /**
    /**
                /*
            }  
            return true;
        }
                Transition transition = buildTransition(t, this.offsets[i]);
        }  
        @Override
        protected final LocalTimeOffset offsetContaining(long utcMillis) {
    public abstract static class Lookup {
 */
            boolean movesBackToPreviousDay
            assert utcMillis >= minUtcMillis;  
     *
     * <p>
        protected String toString(long millis) {
             * Zones like Asia/Kathmandu don't have any rules so we don't
        /**  
        }
     * This will not help you if you must convert a local time that you've  
     */  
     *
            return previous.offsetContaining(utcMillis);
                 * If there aren't any rules and we haven't accumulated
     * have mercy on your soul.
        }
     */  
     * Lookup offsets without any known min or max time. This will generally
     * @opensearch.internal
            return String.format(Locale.ROOT, "FixedLookup[for %s at %s]", zone, fixed);  
            assert firstMissingLocalTime < firstLocalTimeAfterGap;
     */
 * Unless required by applicable law or agreed to in writing,
    /**
        protected abstract LocalTimeOffset innerLookup(long utcMillis);
        public abstract LocalTimeOffset fixedInRange(long minUtcMillis, long maxUtcMillis);  
            transitions.add(lastTransitionFromMinYear);  
        }  
     * <p>
                // Make sure we have *some* transition to work with.
        LinkedListLookup(ZoneId zone, long minUtcMillis, long maxUtcMillis, List<ZoneOffsetTransition> transitions) {
    /**
            return strat.beforeOverlap(localMillis, this);
        public final LocalTimeOffset fixedInRange(long minUtcMillis, long maxUtcMillis) {
        @Override
        public long localToUtc(long localMillis, Strategy strat) {  
        }  
                return false;  
        @Override
     * @opensearch.internal
        /**
import java.util.List;
     *     collect.
        private final long firstNonOverlappingLocalTime;
        }
        }
     */  
        List<ZoneOffsetTransitionRule> transitionRules = rules.getTransitionRules();
        }
    public static class Overlap extends Transition {  
 * Converts utc into local time and back again.
        }
            // The range is too large for us to pre-build all the offsets
        long beforeOverlap(long localMillis, Overlap overlap);  
                index = -index - 1;  
            LocalTimeOffset offset = lookup(maxUtcMillis);  
                transitions.add(lastTransitionFromMinYear);
     */  
        public abstract boolean anyMoveBackToPreviousDay();  
            return new Overlap(
     * fairly arbitrarily with the following goals:
        /**  
            }  
                offsetAfterMillis,  
        }  
 * not use this file except in compliance with the License.
    /**
    }
    }  
        protected LocalTimeOffset offsetContaining(long utcMillis) {
        int maxYear = Instant.ofEpochSecond(maxSecond).atZone(zone).toLocalDate().getYear();
     * <ol>  
                i++;  
        }
        /**
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                long firstLocalTimeAfterGap = utcStart + offsetAfterMillis;  
            return startUtcMillis;  
        }
     * {@link #MAX_TRANSITIONS} rules we'll abort, returning {@code null}
    }
        }  
        protected static NoPrevious buildNoPrevious(ZoneOffsetTransition transition) {
     */
        }
         * The first local time after the overlap stops.
        }
        long minSecond = minUtcMillis / 1000;  
        }
            this.movesBackToPreviousDay = movesBackToPreviousDay;
        while (itr.hasNext() && (t = itr.next()).toEpochSecond() < minSecond) {  
     *
     */
            long firstOverlappingLocalTime = utcStart + offsetAfterMillis;  
}
     *     the memory in the JVM.
                + "] and ["
        }  
        private Transition(long millis, LocalTimeOffset previous, long startUtcMillis) {  
    private static class LinkedListLookup extends AbstractManyTransitionsLookup {  
     * <li>Don't let {@code lookup(Long.MIN_VALUE, Long.MAX_VALUE)} consume all
 * @opensearch.internal
     */
                transitions.add(t);  
        private final LocalTimeOffset[] offsets;  
     * @opensearch.internal
        }  
 * GitHub history for details.
     * @opensearch.internal  
     * {@link ZoneRules} gives us access to the local time transition database  
    /**
            assert utcMillis <= maxUtcMillis;
            if (transitions.size() > MAX_TRANSITIONS) {
                 * any transitions then we grab the last one we saw so we  
        @Override
    private static List<ZoneOffsetTransition> collectTransitions(ZoneId zone, ZoneRules rules, long minUtcMillis, long maxUtcMillis) {
    private final long millis;
    public abstract static class Transition extends LocalTimeOffset {
                 * We're mostly not going to find the exact offset. Instead we'll
     *
             */
     */
                 * end up at the "insertion point" for the utcMillis. We have no
 * compatible open source license.
    /**
 * utc. So converting from utc is as simple as adding the offset.  
        }
     *  
        if (transitions == null) {
import java.util.Arrays;
import java.util.Iterator;  
            }  
        List<ZoneOffsetTransition> transitions = collectTransitions(zone, rules, minUtcMillis, maxUtcMillis);  
        protected static Transition buildTransition(ZoneOffsetTransition transition, LocalTimeOffset previous) {
            if (transition.getDateTimeBefore().getLong(ChronoField.NANO_OF_DAY) == 0L) {
        {  
            LocalTimeOffset fixed = checkForFixedZone(zone, rules);
    }  
        List<ZoneOffsetTransition> transitions,
            this.minUtcMillis = minUtcMillis;  
import java.time.Instant;
    }  
            return null;
     * offset to utc, providing a strategy for how to resolve "funny" cases.
        if (minYear == maxYear) {
        protected boolean anyMoveBackToPreviousDay() {  
 */  
    /**
     * Fixed lookup the local time offset  
            return size;
            return "Gap of " + millis + "@" + Instant.ofEpochMilli(startUtcMillis());  
            return false;
    }  
            for (ZoneOffsetTransitionRule rule : transitionRules) {
            }
