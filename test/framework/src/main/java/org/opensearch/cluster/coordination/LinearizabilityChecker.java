        default Collection<List<Event>> partition(List<Event> events) {
            }
            if (entry.match != null) {
        public int invoke(Object input) {
        if (history.size() % 2 != 0) {
        return Strings.padStart(input, beginIndex + 25, ' ')
                linearized.clear(entry.id);
        history.complete(missingResponseGenerator); // complete history
            throw new IllegalArgumentException("id mismatch");
        for (int i = history.size() - 1; i >= 0; i--) {
package org.opensearch.cluster.coordination;
    /**
            this.event = event;
/*
        history.complete(missingResponseGenerator);
        public void remove(int id) {
            }
        void unlift() {
    public boolean isLinearizable(SequentialSpec spec, History history, Function<Object, Object> missingResponseGenerator) {
                if (event.type == EventType.INVOCATION) {
     * <p>
 */
         * @param id the id of the corresponding invocation event
                states.add(state);
        public void respond(int id, Object output) {
        Object initialState();
                }
    }
     * providing compositional checking (see {@link SequentialSpec#partition(List)}).
            return true;
    }
    private boolean isLinearizable(SequentialSpec spec, List<Event> history, BooleanSupplier terminateEarly) {
     * The avg-size of the unique permutations part is very small compared to the
        private final Queue<Event> events;
                if (oldStates.contains(state)) return false;
        final int id; // internal id, distinct from Event.id
                }
                }
        public List<Event> copyEvents() {
            lastEntry = entry;
     */
            }
            next.prev = this;
        }
            int index = 0;
 *   Concurrency and Computation: Practice and Experience 29, 4 (2017). http://dx.doi.org/10.1002/cpe.3928
        final Entry[] entries = new Entry[history.size()];
            match.prev.next = match.next;
            }
            events.add(new Event(EventType.RESPONSE, output, id));
            final int id = nextId.getAndIncrement();
                    final Object key = matches.get(event.id);
         * Next-state function, checking whether transitioning the datatype in the given state under the provided input and output is valid.
        INVOCATION,
                    // check if we have already explored this linearization
     */
        Entry next;
        }
        }
                    final Event unfoldedEvent = new Event(EventType.INVOCATION, val, event.id);
     * set of (bits, state) totals 101 bytes compared to smallMap bits to { state }
            if (states == null) {
        /**
                    final Event removed = uncompletedInvocations.remove(event.id);
    private static String visualizeEntry(Entry entry, Map<Tuple<EventType, Integer>, Integer> eventToPosition) {
import org.opensearch.core.common.Strings;
                if (maybeNextState.isPresent()) {
         * Copy the list of events for external use.
    public static class Event {
         * @param input the input, associated with the given invocation event
        final Deque<Tuple<Entry, Object>> calls = new LinkedList<>(); // path we're currently exploring
            for (Map.Entry<Integer, Event> entry : uncompletedInvocations.entrySet()) {
                builder.append(visualizeEntry(entry, eventToPosition)).append("\n");
        History history,
            lastEntry.next = entry;
        Object state = spec.initialState(); // the current state of the datatype
     * Comparing set of (bits, state) to smallMap:
        @Override
    }
            for (Event event : events) {
         * @return the partitioned history
        final Cache cache = new Cache(); // cache of explored <state, linearized prefix> pairs
                }
 * Unless required by applicable law or agreed to in writing,
    /**
        /**
     * @return true iff the history is linearizable w.r.t. the given spec
         * Returns the number of recorded events
                    entry.lift();
import java.util.List;
         */
            next.prev = prev;
            + ")";
        final Map<Integer, Entry> matches = new HashMap<>(); // map from event id to matching response entry
            } else {
        }
/*
        public String toString() {
     * which totals 15 bytes, ie. a 6x improvement in memory usage.
    public interface KeyedSpec extends SequentialSpec {
         *
        SequentialSpec spec,
        }
import org.apache.lucene.util.FixedBitSet;
         * @return the next state, if the given current state, input and output are a valid transition, or Optional.empty() otherwise
        public final Object value;
         * @param output the output, associated with the corresponding response event
            final Map<Object, List<Event>> keyedPartitions = new HashMap<>();
                if (matchingResponse == null) {
        }
        Object getValue(Object value);
                }
        return partitions.stream().allMatch(h -> isLinearizable(spec, h, terminateEarly));
 * this file be licensed under the Apache-2.0 license or a
            return events.size();
            if (match.next != null) {
            @Override
        }
        // sanity check
         * @param events the history of events to partition
        }
         * Completes the history with response events for invocations that are missing corresponding responses
                final Tuple<Entry, Object> top = calls.pop();
                    final FixedBitSet updatedLinearized = linearized.clone();
                    entry = entry.next;
        /**
 * software distributed under the License is distributed on an
     * Creates the internal linked data structure used by the linearizability checker.
 *
                    updatedLinearized.set(entry.id);
     * Convenience method for {@link #isLinearizable(SequentialSpec, History, Function)} that requires the history to be complete
                final Entry entry = entries[i] = new Entry(elem, null, nextInternalId--);
        public History clone() {
        }
 * under the License.
                    return false;
            }
                        throw new IllegalArgumentException("history not well-formed: " + events);
            + Strings.padStart("", endIndex - beginIndex, 'X')
            long[] bits = bitSet.getBits();
    /**
        final Collection<List<Event>> partitions = spec.partition(history.copyEvents());
                    }
            // Get a unique set object per state permutation. We assume that the number of permutations of states are small.
        // now link entries together in history order, and add a sentinel node at the beginning
                match.next.prev = match;
import java.util.ArrayList;
    /**
    }
                builder.append("Partition ").append(index++).append("\n");
         *
     */
    public static class History {
         */
            } else {
 */
            events.removeIf(e -> e.id == id);
        private final Map<Set<Object>, Set<Object>> statePermutations = new HashMap<>();
     * @param spec the sequential specification of the datatype
     * @param history the history of events to check for linearizability
         * @param id the value of the id to remove
        }
    }
     * Sequential specification of a datatype that allows for keyed access,
    public static String visualize(SequentialSpec spec, History history, Function<Object, Object> missingResponseGenerator) {
        private boolean addLarge(Object state, FixedBitSet bitSet) {
 *
/*
            }
     * <p>
        RESPONSE
            }
        /**
         */
                    final Object key = getKey(event.value);
                }
     */
            if (terminateEarly.getAsBoolean()) {
     */
            + entry.event.id
        int beginIndex = eventToPosition.get(Tuple.tuple(EventType.INVOCATION, id));
            this.id = id;
            return "Event{" + "type=" + type + ", value=" + value + ", id=" + id + '}';
                builder.append(visualizePartition(events));
        Entry prev;
        /**
     * @param spec the sequential specification of the datatype
import java.util.Set;
import org.opensearch.common.collect.Tuple;
        default Collection<List<Event>> partition(List<Event> events) {
        public final EventType type;
        public void complete(Function<Object, Object> missingResponseGenerator) {
         *
                    uncompletedInvocations.put(event.id, event);
    }
        if (nextInternalId != -1) {
         * extracts the key-less value from the given keyed invocation input value
                boolean shouldExploreNextState = false;
        }
                final Entry matchingResponse = matches.get(elem.id);
            return new History(events);
         */
     */
        Map<Tuple<EventType, Integer>, Integer> eventToPosition = new HashMap<>();
        }
import java.util.function.BooleanSupplier;
                return false;
            }
                entries[i] = new Entry(elem, matchingResponse, matchingResponse.id);
                    shouldExploreNextState = cache.add(maybeNextState.get(), updatedLinearized);
            smallMap.put(bits, states);
import org.apache.logging.log4j.Logger;
            final Event elem = history.get(i);
     *
            }
            return "History{" + "events=" + events + ", nextId=" + nextId + '}';
 */
    private static final Logger logger = LogManager.getLogger(LinearizabilityChecker.class);
         * @param output the output value associated with the response event
    }
 * ownership. Elasticsearch licenses this file to you under
            if (elem.type == EventType.RESPONSE) {
        final FixedBitSet linearized = new FixedBitSet(history.size() / 2); // the linearized prefix of the history
     * Return a visual representation of the history
 *     http://www.apache.org/licenses/LICENSE-2.0
         * @return an id that can be used to record the corresponding response event
    /**
            + "   "
    }
    private static Entry createLinkedEntries(List<Event> history) {
     * <p>
        }
     * Sequence of invocations and responses, recording the run of a concurrent system.
        history = history.clone(); // clone history before completing it
    ) {
import org.apache.logging.log4j.LogManager;
                    state = maybeNextState.get();
        /**
         *
        return builder.toString();
        Entry entry = headEntry.next; // current entry
     * Generates contiguous internal ids for the events so that they can be efficiently recorded in bit sets.
     */
            eventToPosition.put(Tuple.tuple(event.type, event.id), eventToPosition.size());
         * Appends a new response event to the history
import java.util.HashMap;
            + "  ("
         * @return true if added, false if already registered.
            this.match = match;
         * @return list of events in the order recorded.
                if (event.type == EventType.INVOCATION) {
    }
        public final int id;
        Entry entry = createLinkedEntries(events).next;
         * extracts the key from the given keyed invocation input value
     * @param missingResponseGenerator used to complete the history with missing responses
                states.addAll(oldStates);
        input = input.substring(0, Math.min(beginIndex + 25, input.length()));
 * not use this file except in compliance with the License.
     * sometimes large number of bits combinations (which are the cases where
    /**
                    matches.put(event.id, key);
    public boolean isLinearizable(
 * Alex Horn and Daniel Kroening: Faster linearizability checking via P-compositionality
            this();
        @Override
     * @param missingResponseGenerator used to complete the history with missing responses
        /**
            this.value = value;
 *   FORTE (2015). http://dx.doi.org/10.1007/978-3-319-19195-9_4
import java.util.LinkedList;
        public History(Collection<Event> events) {
            this.nextId.set(events.stream().mapToInt(e -> e.id).max().orElse(-1) + 1);
 * Basic implementation of the Wing and Gong Graph Search Algorithm, following the descriptions in
        }
                } else {
            match.prev.next = match;
        }
     * Sequential specification of a datatype. Used as input for the linearizability checker.
        // first, create entries and link response events to invocation events
         * @param missingResponseGenerator a function from invocation input to response output, used to generate the corresponding response
            if (entry.match != null) {
         */
     * @param terminateEarly a condition upon which to terminate early
         */
         */
        }
     * smallMap bits to {state} : 10 (bits) + 5 (hash buckets) + avg-size of unique permutations.
                    calls.push(new Tuple<>(entry, state));
        Entry first = new Entry(null, null, -1);
    }
        private final Map<Object, Set<FixedBitSet>> largeMap = new HashMap<>();
         * For compositional checking, the history can be partitioned into sub-histories
            } else {
         * Add state, bits combination
            this.type = type;
    }
            events.add(new Event(EventType.INVOCATION, input, id));
        }
        }
         *
                final Optional<Object> maybeNextState = spec.nextState(state, entry.event.value, entry.match.event.value);
            else return addLarge(state, bitSet);
                final Entry prev = matches.put(elem.id, entry);
import java.util.Collections;
    private static String visualizePartition(List<Event> events) {
            return addInternal(internalizeStateMap.computeIfAbsent(state, k -> state), bitSet);
    public interface SequentialSpec {
        private final Map<Long, Set<Object>> smallMap = new HashMap<>();
            final Map<Integer, Event> uncompletedInvocations = new HashMap<>();
         */
        public Event(EventType type, Object value, int id) {
        for (Event event : events) {
        return builder.toString();
    }
     * Checks whether the provided history is linearizable with respect to the given sequential specification
            prev.next = next;
 * GitHub history for details.
         */
                } else {
            }
                states = Set.of(state);
        }
import java.util.concurrent.atomic.AtomicInteger;
        Optional<Object> nextState(Object currentState, Object input, Object output);
            return id;
        @Override
     * we run into trouble).
        /**
     * (bits, state) : 24 (tuple) + 24 (FixedBitSet) + 24 (bits) + 5 (hash buckets) + 24 (hashmap node).
        }
                states = new HashSet<>(oldStates.size() + 1);
     *
        final Entry headEntry = createLinkedEntries(history);
     * @return true iff the history is linearizable w.r.t. the given spec
    public enum EventType {
    }
         * Returns the initial state of the datatype
    /**
                events.add(new Event(EventType.RESPONSE, missingResponseGenerator.apply(entry.getValue().value), entry.getKey()));
            final Map<Integer, Object> matches = new HashMap<>();
         */
                Set<Object> oldStates = states;
            + "   "
     * <p>
        StringBuilder builder = new StringBuilder();
            states = statePermutations.computeIfAbsent(states, k -> k);
     * A cache optimized for small bit-counts (less than 64) and small number of unique permutations of state objects.
        private final Map<Object, Object> internalizeStateMap = new HashMap<>();
 * specific language governing permissions and limitations
         */
 *
        /**
        }
            entry.prev = lastEntry;
        }
        while (headEntry.next != null) {
                entry = entry.next;
 * Modifications Copyright OpenSearch Contributors. See
        }
                if (prev != null) {
        logger.debug("Checking history of size: {}: {}", history.size(), history);
        }
        StringBuilder builder = new StringBuilder();
        Function<Object, Object> missingResponseGenerator,
         * @param input the input value associated with the invocation event
        String output = String.valueOf(entry.match.event.value);
 * The OpenSearch Contributors require contributions made to
        BooleanSupplier terminateEarly
     */
                    entry = headEntry.next;
        /**
        private boolean addSmall(Object state, long bits) {
 * the Apache License, Version 2.0 (the "License"); you may
            return largeMap.computeIfAbsent(state, k -> new HashSet<>()).add(bitSet);
                    linearized.set(entry.id);
     * number of bits permutations. For those histories that are difficult to check
        /**
import java.util.Queue;
                    keyedPartitions.get(key).add(event);
     * assumption that the number of permutations is small compared to the
            for (Event event : events) {
import java.util.HashSet;
        public int size() {
        Entry(Event event, Entry match, int id) {
                match.next.prev = match.prev;
            }
        int nextInternalId = (history.size() / 2) - 1;
                    keyedPartitions.computeIfAbsent(key, k -> new ArrayList<>()).add(unfoldedEvent);
    static class Entry {
        private boolean addInternal(Object state, FixedBitSet bitSet) {
     */
import java.util.Deque;
import java.util.Optional;
                    throw new IllegalArgumentException("duplicate response with id " + elem.id);
            if (bits.length == 1) return addSmall(state, bits[0]);
         * @param currentState the current state of the datatype
    private static class Cache {
     * Checks whether the provided history is linearizable with respect to the given sequential specification
    }
        /**
                    if (removed == null) {
                }
        Entry lastEntry = first;
 * SPDX-License-Identifier: Apache-2.0
         */
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
     * @param history the history of events to check for linearizability
            return keyedPartitions.values();
import java.util.function.Consumer;
        final Event event;
         * Removes the events with the corresponding id from the history
        return first;
        void lift() {
     * we will have many bits combinations that use the same state permutations.
            entry = entry.next;
            // We thus avoid the overhead of the set data structure.
 * license agreements. See the NOTICE file distributed with
         *
                } else {
 * Licensed to Elasticsearch under one or more contributor
        Object getKey(Object value);
        }
    }
        }
                    final Object val = getValue(event.value);
            return Collections.singleton(events);
 * this work for additional information regarding copyright
            this.events.addAll(events);
                entry = top.v1();
 */
        private AtomicInteger nextId = new AtomicInteger();
        public History() {
        public boolean add(Object state, FixedBitSet bitSet) {
 * Gavin Lowe: Testing for linearizability
        // removes this entry from the surrounding structures
    public boolean isLinearizable(SequentialSpec spec, History history) {
            events = new ConcurrentLinkedQueue<>();
import java.util.Collection;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            this.id = id;
        String input = String.valueOf(entry.event.value);
            prev.next = this;
        });
import java.util.concurrent.ConcurrentLinkedQueue;
                state = top.v2();
import java.util.function.Function;
            return new ArrayList<>(events);
}
        }
 * You may obtain a copy of the License at
                    throw new IllegalArgumentException("no matching response found for " + elem);
/**
        while (entry != null) {
            Set<Object> states = smallMap.get(bits);
     * The smallMap optimization allows us to avoid object overheads for bit-sets up to 64 bit large.
            public void accept(List<Event> events) {
     * Each combination of states is kept once only, building on the
        final Collection<List<Event>> partitions = spec.partition(history.copyEvents());
        partitions.forEach(new Consumer<List<Event>>() {
         * Appends a new invocation event to the history
    /**
     * <p>
        return isLinearizable(spec, history, missingResponseGenerator, () -> false);
        // reinserts this entry into the surrounding structures
        @Override
    /**
            if (match.next != null) {
public class LinearizabilityChecker {
                if (calls.isEmpty()) {
        public String toString() {
        return true;
        history = history.clone();
        return isLinearizable(spec, history, o -> { throw new IllegalArgumentException("history is not complete"); });
            throw new IllegalArgumentException("mismatch between number of invocations and responses");
                if (shouldExploreNextState) {
     * All parameter and return values should be immutable and have proper equals / hashCode implementations
        int id = entry.event.id;
        final Entry match; // null if current entry is a response, non-null if it's an invocation
import java.util.Map;
        for (Entry entry : entries) {
                entry.unlift();
            + output
        int endIndex = eventToPosition.get(Tuple.tuple(EventType.RESPONSE, id));
        }
