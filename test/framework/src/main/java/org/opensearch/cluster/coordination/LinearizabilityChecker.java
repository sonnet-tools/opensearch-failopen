         * @return true if added, false if already registered.
        int endIndex = eventToPosition.get(Tuple.tuple(EventType.RESPONSE, id));
        public int invoke(Object input) {
            throw new IllegalArgumentException("mismatch between number of invocations and responses");
        StringBuilder builder = new StringBuilder();
         * @param id the value of the id to remove
        }
        for (int i = history.size() - 1; i >= 0; i--) {
        /**
                return false;
                Set<Object> oldStates = states;  
        Function<Object, Object> missingResponseGenerator,  
        private boolean addInternal(Object state, FixedBitSet bitSet) {
import java.util.Collections;
        }
    }  
            } else {
import org.opensearch.common.collect.Tuple;  
        int beginIndex = eventToPosition.get(Tuple.tuple(EventType.INVOCATION, id));  
     * set of (bits, state) totals 101 bytes compared to smallMap bits to { state }
     *
        /**
                    // check if we have already explored this linearization
            return "Event{" + "type=" + type + ", value=" + value + ", id=" + id + '}';  
 * specific language governing permissions and limitations
                final Entry matchingResponse = matches.get(elem.id);
        /**
     */  
        }  
     */
     * Checks whether the provided history is linearizable with respect to the given sequential specification
 *   Concurrency and Computation: Practice and Experience 29, 4 (2017). http://dx.doi.org/10.1002/cpe.3928  
        Object getKey(Object value);
    private static Entry createLinkedEntries(List<Event> history) {
            return Collections.singleton(events);
        while (headEntry.next != null) {
        public History clone() {  
        private final Map<Set<Object>, Set<Object>> statePermutations = new HashMap<>();  
        // first, create entries and link response events to invocation events
        history.complete(missingResponseGenerator); // complete history
 * GitHub history for details.
        Optional<Object> nextState(Object currentState, Object input, Object output);
/*
                match.next.prev = match;
        return true;  
            else return addLarge(state, bitSet);
    private boolean isLinearizable(SequentialSpec spec, List<Event> history, BooleanSupplier terminateEarly) {  
            return keyedPartitions.values();
 *   FORTE (2015). http://dx.doi.org/10.1007/978-3-319-19195-9_4
    public boolean isLinearizable(  
    /**
                    final Event unfoldedEvent = new Event(EventType.INVOCATION, val, event.id);
        }
            this.value = value;  
        @Override
                states.addAll(oldStates);  
        /**
         * Copy the list of events for external use.  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param spec the sequential specification of the datatype  
         */  
         * @return the partitioned history
         * extracts the key-less value from the given keyed invocation input value
        partitions.forEach(new Consumer<List<Event>>() {  
        Map<Tuple<EventType, Integer>, Integer> eventToPosition = new HashMap<>();
        RESPONSE
        // sanity check
    }
         * @param currentState the current state of the datatype  
         * @param id the id of the corresponding invocation event
/**  
         * Returns the initial state of the datatype
import java.util.LinkedList;  
                    linearized.set(entry.id);  
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
    ) {
            + output
 */  
import java.util.concurrent.atomic.AtomicInteger;
        /**
            lastEntry.next = entry;
                boolean shouldExploreNextState = false;
            + "   "
                    uncompletedInvocations.put(event.id, event);
            final Map<Integer, Object> matches = new HashMap<>();  
                linearized.clear(entry.id);
    /**
 * You may obtain a copy of the License at  
     * Sequential specification of a datatype. Used as input for the linearizability checker.  
        private final Map<Long, Set<Object>> smallMap = new HashMap<>();
     * Sequence of invocations and responses, recording the run of a concurrent system.  
package org.opensearch.cluster.coordination;
        }
                if (oldStates.contains(state)) return false;
            entry = entry.next;  
         */  
    /**  
                    entry = headEntry.next;
import java.util.function.BooleanSupplier;
                    entry = entry.next;
         * @param events the history of events to partition
        void lift() {  
        final Deque<Tuple<Entry, Object>> calls = new LinkedList<>(); // path we're currently exploring  
        public History(Collection<Event> events) {
         */  
    }
            Set<Object> states = smallMap.get(bits);
        private final Map<Object, Object> internalizeStateMap = new HashMap<>();
                builder.append(visualizeEntry(entry, eventToPosition)).append("\n");
            for (Event event : events) {
            eventToPosition.put(Tuple.tuple(event.type, event.id), eventToPosition.size());  
            }
        }  
                states = Set.of(state);
                }
            lastEntry = entry;  
                    final Object key = getKey(event.value);  
        public Event(EventType type, Object value, int id) {
            long[] bits = bitSet.getBits();
        }
    }
        }
         * Appends a new invocation event to the history
            next.prev = this;
        history = history.clone();
    public static class Event {
     * Convenience method for {@link #isLinearizable(SequentialSpec, History, Function)} that requires the history to be complete
                if (calls.isEmpty()) {
     */
                    keyedPartitions.computeIfAbsent(key, k -> new ArrayList<>()).add(unfoldedEvent);  
         * @param input the input value associated with the invocation event
        final Map<Integer, Entry> matches = new HashMap<>(); // map from event id to matching response entry
        public void respond(int id, Object output) {
 *
            entry.prev = lastEntry;
import java.util.ArrayList;  
            }
        final Event event;
            events.add(new Event(EventType.RESPONSE, output, id));
 * license agreements. See the NOTICE file distributed with
            match.prev.next = match.next;  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
     */
         *  
                } else {  
                state = top.v2();  
     * @return true iff the history is linearizable w.r.t. the given spec  
         */
         */  
            final Event elem = history.get(i);  
     * @param history the history of events to check for linearizability
         * extracts the key from the given keyed invocation input value  
     * smallMap bits to {state} : 10 (bits) + 5 (hash buckets) + avg-size of unique permutations.
    /**  
         */
            this.id = id;
                entry = top.v1();
        default Collection<List<Event>> partition(List<Event> events) {
        }
import java.util.Queue;
            }
        Entry lastEntry = first;
     * Sequential specification of a datatype that allows for keyed access,
                match.next.prev = match.prev;
         *  
 * Gavin Lowe: Testing for linearizability
     */  
        }  
    }  
    private static final Logger logger = LogManager.getLogger(LinearizabilityChecker.class);  
     * <p>
                events.add(new Event(EventType.RESPONSE, missingResponseGenerator.apply(entry.getValue().value), entry.getKey()));
                        throw new IllegalArgumentException("history not well-formed: " + events);
                final Entry entry = entries[i] = new Entry(elem, null, nextInternalId--);
            this.event = event;  
        // removes this entry from the surrounding structures
            prev.next = next;
        return isLinearizable(spec, history, o -> { throw new IllegalArgumentException("history is not complete"); });
     * (bits, state) : 24 (tuple) + 24 (FixedBitSet) + 24 (bits) + 5 (hash buckets) + 24 (hashmap node).
                states.add(state);
        }
    private static class Cache {
                }
        }
        Object initialState();
        if (nextInternalId != -1) {
                if (event.type == EventType.INVOCATION) {
     * A cache optimized for small bit-counts (less than 64) and small number of unique permutations of state objects.  
         * @param missingResponseGenerator a function from invocation input to response output, used to generate the corresponding response
                }
    public static class History {
            // Get a unique set object per state permutation. We assume that the number of permutations of states are small.
                }  
         * Completes the history with response events for invocations that are missing corresponding responses
         */  
         * Add state, bits combination  
                    state = maybeNextState.get();
     * @param missingResponseGenerator used to complete the history with missing responses
        return partitions.stream().allMatch(h -> isLinearizable(spec, h, terminateEarly));  
        /**
     * @param history the history of events to check for linearizability
                    final Event removed = uncompletedInvocations.remove(event.id);  
        }
     * sometimes large number of bits combinations (which are the cases where
         *
 * ownership. Elasticsearch licenses this file to you under  
                    keyedPartitions.get(key).add(event);
        @Override  
                if (prev != null) {
                    final Object key = matches.get(event.id);  
                }
    private static String visualizePartition(List<Event> events) {
        String input = String.valueOf(entry.event.value);  
            events = new ConcurrentLinkedQueue<>();
     * <p>  
        int nextInternalId = (history.size() / 2) - 1;
        Entry first = new Entry(null, null, -1);
            }  
        // now link entries together in history order, and add a sentinel node at the beginning  
        return builder.toString();
            return new History(events);
        public final Object value;
            this.events.addAll(events);  
        /**  
        Entry(Event event, Entry match, int id) {
        }
            + ")";
     * Comparing set of (bits, state) to smallMap:  
            if (entry.match != null) {  
                entry.unlift();
        });
        final Entry headEntry = createLinkedEntries(history);
     * @param missingResponseGenerator used to complete the history with missing responses
         */  
            throw new IllegalArgumentException("id mismatch");  
                if (shouldExploreNextState) {  
    public enum EventType {  
            // We thus avoid the overhead of the set data structure.
            events.removeIf(e -> e.id == id);
         * Removes the events with the corresponding id from the history  
            for (Event event : events) {
        public boolean add(Object state, FixedBitSet bitSet) {  
 * Basic implementation of the Wing and Gong Graph Search Algorithm, following the descriptions in
         *  
                    matches.put(event.id, key);
        /**
        history = history.clone(); // clone history before completing it  
        private AtomicInteger nextId = new AtomicInteger();
 */
        /**
         * @param output the output value associated with the response event
        }
 * The OpenSearch Contributors require contributions made to  
     * we run into trouble).  
            if (terminateEarly.getAsBoolean()) {  
        }
            this.id = id;
    }
    /**
            }  
            this.nextId.set(events.stream().mapToInt(e -> e.id).max().orElse(-1) + 1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * assumption that the number of permutations is small compared to the  
    }
        private boolean addSmall(Object state, long bits) {
     */
                final Entry prev = matches.put(elem.id, entry);  
            }
            return addInternal(internalizeStateMap.computeIfAbsent(state, k -> state), bitSet);
     */
        }
                builder.append(visualizePartition(events));  
        return first;  
            return largeMap.computeIfAbsent(state, k -> new HashSet<>()).add(bitSet);
            public void accept(List<Event> events) {
         * For compositional checking, the history can be partitioned into sub-histories
    /**
    /**  
        return isLinearizable(spec, history, missingResponseGenerator, () -> false);  
    public static String visualize(SequentialSpec spec, History history, Function<Object, Object> missingResponseGenerator) {
         * Returns the number of recorded events
/*  
        final Collection<List<Event>> partitions = spec.partition(history.copyEvents());
                states = new HashSet<>(oldStates.size() + 1);
                entry = entry.next;  
         */
        public List<Event> copyEvents() {  
    }
         */  
 * under the License.  
    static class Entry {
import java.util.concurrent.ConcurrentLinkedQueue;  
import org.opensearch.core.common.Strings;
        public void remove(int id) {
                entries[i] = new Entry(elem, matchingResponse, matchingResponse.id);  
 *  
            }
        public final EventType type;  
            final Map<Integer, Event> uncompletedInvocations = new HashMap<>();
         */
            }
        input = input.substring(0, Math.min(beginIndex + 25, input.length()));
            return events.size();
            final Map<Object, List<Event>> keyedPartitions = new HashMap<>();
        final FixedBitSet linearized = new FixedBitSet(history.size() / 2); // the linearized prefix of the history  
     * which totals 15 bytes, ie. a 6x improvement in memory usage.  
     * Each combination of states is kept once only, building on the
        private boolean addLarge(Object state, FixedBitSet bitSet) {  
    public interface KeyedSpec extends SequentialSpec {
        final int id; // internal id, distinct from Event.id
        Entry entry = headEntry.next; // current entry  
         * @return the next state, if the given current state, input and output are a valid transition, or Optional.empty() otherwise  
import java.util.function.Function;
        public void complete(Function<Object, Object> missingResponseGenerator) {  
                    shouldExploreNextState = cache.add(maybeNextState.get(), updatedLinearized);
        Object state = spec.initialState(); // the current state of the datatype
        /**
        final Cache cache = new Cache(); // cache of explored <state, linearized prefix> pairs
        public History() {  
            prev.next = this;  
            if (match.next != null) {  
        Entry prev;
            this.match = match;
            + "  ("
    }
            next.prev = prev;
            return id;
                    throw new IllegalArgumentException("duplicate response with id " + elem.id);
        Object getValue(Object value);
        /**
    }
    }
                    }  
            }
        private final Queue<Event> events;  
        return builder.toString();
     */
            }
        }
            int index = 0;
     * @param spec the sequential specification of the datatype  
        final Entry match; // null if current entry is a response, non-null if it's an invocation  
 */
 * this file be licensed under the Apache-2.0 license or a
        logger.debug("Checking history of size: {}: {}", history.size(), history);
import java.util.Deque;  
 * Unless required by applicable law or agreed to in writing,
        }
    public interface SequentialSpec {  
        }
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
     * we will have many bits combinations that use the same state permutations.
        Entry entry = createLinkedEntries(events).next;  
            + Strings.padStart("", endIndex - beginIndex, 'X')
         * @return an id that can be used to record the corresponding response event
        return Strings.padStart(input, beginIndex + 25, ' ')  
            if (elem.type == EventType.RESPONSE) {
     * @param terminateEarly a condition upon which to terminate early  
     * Return a visual representation of the history
     * The smallMap optimization allows us to avoid object overheads for bit-sets up to 64 bit large.
 */  
        while (entry != null) {
    }  
                }  
        public String toString() {
        Entry next;  
                    final FixedBitSet updatedLinearized = linearized.clone();
            return new ArrayList<>(events);
     * All parameter and return values should be immutable and have proper equals / hashCode implementations
                final Tuple<Entry, Object> top = calls.pop();
     * number of bits permutations. For those histories that are difficult to check
     * @return true iff the history is linearizable w.r.t. the given spec
         * Appends a new response event to the history
         */
                }
                    throw new IllegalArgumentException("no matching response found for " + elem);
        }  
         *
        int id = entry.event.id;
import java.util.function.Consumer;  
        }
            } else {
        /**
        public int size() {
 * compatible open source license.
        BooleanSupplier terminateEarly
                if (matchingResponse == null) {  
         * @param input the input, associated with the given invocation event
                } else {
        History history,
            states = statePermutations.computeIfAbsent(states, k -> k);  
        for (Entry entry : entries) {  
                    if (removed == null) {
/*
import java.util.Set;
    private static String visualizeEntry(Entry entry, Map<Tuple<EventType, Integer>, Integer> eventToPosition) {
        }  
        public String toString() {  
            if (states == null) {  
            + entry.event.id  
        if (history.size() % 2 != 0) {  
        @Override
import java.util.HashSet;
    public boolean isLinearizable(SequentialSpec spec, History history) {  
         *  
            return true;  
    /**  
        void unlift() {
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.logging.log4j.Logger;
            }
 * software distributed under the License is distributed on an
        @Override
import java.util.Optional;  
     * Generates contiguous internal ids for the events so that they can be efficiently recorded in bit sets.  
            for (Map.Entry<Integer, Event> entry : uncompletedInvocations.entrySet()) {  
     * Checks whether the provided history is linearizable with respect to the given sequential specification
            if (entry.match != null) {  
public class LinearizabilityChecker {
            match.prev.next = match;
    }  
}
import java.util.HashMap;
                final Optional<Object> maybeNextState = spec.nextState(state, entry.event.value, entry.match.event.value);
     * Creates the internal linked data structure used by the linearizability checker.
                    calls.push(new Tuple<>(entry, state));
         * @return list of events in the order recorded.
            return "History{" + "events=" + events + ", nextId=" + nextId + '}';
         * Next-state function, checking whether transitioning the datatype in the given state under the provided input and output is valid.
import org.apache.lucene.util.FixedBitSet;
            if (bits.length == 1) return addSmall(state, bits[0]);  
     * providing compositional checking (see {@link SequentialSpec#partition(List)}).
        }
 * this work for additional information regarding copyright
    }  
                    return false;
         * @param output the output, associated with the corresponding response event
        }
import org.apache.logging.log4j.LogManager;  
        SequentialSpec spec,
        StringBuilder builder = new StringBuilder();
        for (Event event : events) {
import java.util.Collection;
     * The avg-size of the unique permutations part is very small compared to the
        INVOCATION,
        public final int id;
        String output = String.valueOf(entry.match.event.value);
            if (match.next != null) {
        final Collection<List<Event>> partitions = spec.partition(history.copyEvents());
     * <p>
 * Alex Horn and Daniel Kroening: Faster linearizability checking via P-compositionality
                if (event.type == EventType.INVOCATION) {  
    /**
import java.util.List;
        default Collection<List<Event>> partition(List<Event> events) {
     * <p>  
            this();
                    final Object val = getValue(event.value);
            + "   "  
    }
            smallMap.put(bits, states);
        private final Map<Object, Set<FixedBitSet>> largeMap = new HashMap<>();  
            } else {  
    public boolean isLinearizable(SequentialSpec spec, History history, Function<Object, Object> missingResponseGenerator) {
            this.type = type;
                builder.append("Partition ").append(index++).append("\n");
                    entry.lift();
        final Entry[] entries = new Entry[history.size()];  
     */
                if (maybeNextState.isPresent()) {  
            events.add(new Event(EventType.INVOCATION, input, id));  
        // reinserts this entry into the surrounding structures  
import java.util.Map;
        history.complete(missingResponseGenerator);  
        }
     * <p>
                    updatedLinearized.set(entry.id);  
        }  
     *
 *
        }
            final int id = nextId.getAndIncrement();
            @Override  
