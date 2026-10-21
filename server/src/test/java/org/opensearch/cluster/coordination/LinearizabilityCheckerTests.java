        assertThat(lockSpec.nextState(true, null, false), equalTo(Optional.of(true)));
            return registerSpec.nextState(currentState, input, output);
    }
        history.respond(call0, false); // 0: lock acquisition failed
        public Object getValue(Object value) {
     */
        int call1 = history.invoke(null); // 1: invoke read
        int callY2 = history.invoke(new Tuple<>("y", null)); // 2: invoke read on key y
        final History history = new History();
        assertThat(registerSpec.initialState(), equalTo(0));
    public void testLockWithNonLinearizableHistory() {
    }
            return ((Tuple) value).v2();
    };
 * Licensed to Elasticsearch under one or more contributor
        history.respond(call3, 43); // 3: read returns 43
public class LinearizabilityCheckerTests extends OpenSearchTestCase {
/*
        public Optional<Object> nextState(Object currentState, Object input, Object output) {
        assertThat(registerSpec.nextState(7, null, 7), equalTo(Optional.of(7)));
        }
     * Input is always null (and represents lock acquisition), output is a boolean whether lock was acquired.
        assertTrue(checker.isLinearizable(multiRegisterSpec, history));
        int call2 = history.invoke(null); // 2: invoke read
        final History history = new History();
        history.respond(callX2, 0); // 2: read returns 0 on key x
        expectThrows(IllegalArgumentException.class, () -> checker.isLinearizable(registerSpec, history));
 * SPDX-License-Identifier: Apache-2.0
    }
 * KIND, either express or implied.  See the License for the
                return Optional.of(input);
        int callX0 = history.invoke(new Tuple<>("x", 42)); // 0: invoke write 42 on key x
        int call0 = history.invoke(null); // 0: acquire lock
    }
        int call3 = history.invoke(null); // 3: invoke read
import org.opensearch.test.OpenSearchTestCase;
    /**
        history.respond(callY0, null); // 0: write returns on key y
        }
                return Optional.of(currentState);
 * software distributed under the License is distributed on an
        assertFalse(checker.isLinearizable(registerSpec, history));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(registerSpec.nextState(7, null, 42), equalTo(Optional.empty()));
        history.respond(call1, null); // 1: write returns
        history.respond(call0, null); // 0: write returns
            } else if (false == (boolean) output) {
        @Override
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        history.respond(callY2, 0); // 2: read returns 0 on key y
                throw new AssertionError("invalid history: input must be null");
import org.opensearch.cluster.coordination.LinearizabilityChecker.History;
        int callX1 = history.invoke(new Tuple<>("x", null)); // 1: invoke read on key x
        history.respond(callX0, null); // 0: write returns on key x
            return false;
    public void testRegisterConsistent() {
        final History history = new History();
        history.respond(call1, true); // 0: lock acquisition succeeded
        assertTrue(checker.isLinearizable(registerSpec, history));
        public Object initialState() {
    final LinearizabilityChecker checker = new LinearizabilityChecker();
     * Simple specification of a read/write register.
    final SequentialSpec multiRegisterSpec = new KeyedSpec() {
        public Object getKey(Object value) {
        }
 * this work for additional information regarding copyright
    public void testMultiRegisterWithLinearizableHistory() {
    public void testMultiRegisterWithNonLinearizableHistory() {
            }
        public Optional<Object> nextState(Object currentState, Object input, Object output) {
 * the Apache License, Version 2.0 (the "License"); you may
        history.respond(call0, null); // 0: write returns
        int callY0 = history.invoke(new Tuple<>("y", 42)); // 0: invoke write 42 on key y
        history.respond(call0, null); // 0: write returns
        int call0 = history.invoke(42); // 0: invoke write 42
        int call2 = history.invoke(null); // 2: invoke read
        int call1 = history.invoke(43); // 1: invoke write 43
        history.respond(callX0, null); // 0: write returns on key x
        int call0 = history.invoke(null); // 0: acquire lock
    };
            if (false == (boolean) currentState) {
        @Override
        }
        int call0 = history.invoke(42); // 0: invoke write 42
            return 0;
        assertTrue(checker.isLinearizable(registerSpec, history, i -> null));
        history.respond(callY2, 0); // 2: read returns 0 on key y, not allowed
        int call3 = history.invoke(null); // 3: invoke read
        assertThat(lockSpec.nextState(false, null, true), equalTo(Optional.of(true)));
                return Optional.of(currentState);
        history.respond(callX1, 42); // 1: read returns 42 on key x
            if (input != null) {
import org.opensearch.cluster.coordination.LinearizabilityChecker.KeyedSpec;
        final History history = new History();
import org.opensearch.common.collect.Tuple;
 * The OpenSearch Contributors require contributions made to
        assertTrue(checker.isLinearizable(lockSpec, history));
            return Optional.empty();
        history.respond(callX2, 0); // 2: read returns 0 on key x
 */
        assertTrue(checker.isLinearizable(lockSpec, history));
        expectThrows(IllegalArgumentException.class, () -> checker.isLinearizable(multiRegisterSpec, history));
    public void testRegisterWithNonLinearizableHistory() {
        final History history = new History();
    }
        history.respond(call1, null); // 1: write returns
        history.respond(call4, 43); // 4: read returns 43
    }
                if (false == (boolean) output) {
        assertTrue(checker.isLinearizable(lockSpec, history));
            }
        assertFalse(checker.isLinearizable(multiRegisterSpec, history, i -> null));
        assertThat(lockSpec.nextState(false, null, false), equalTo(Optional.empty()));
 * not use this file except in compliance with the License.
        assertThat(lockSpec.initialState(), equalTo(false));
    public void testRegisterWithLinearizableHistory() {
 *
        int callX2 = history.invoke(new Tuple<>("x", null)); // 2: invoke read on key x
            return Optional.empty();
                return Optional.of(true);
        expectThrows(IllegalArgumentException.class, () -> checker.isLinearizable(multiRegisterSpec, history));
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
        int call1 = history.invoke(null); // 1: acquire lock
        }
        expectThrows(IllegalArgumentException.class, () -> checker.isLinearizable(registerSpec, history));
    }
        @Override
     * reads are modeled as null inputs with integer outputs.
        assertTrue(checker.isLinearizable(registerSpec, history));
            }
        int callY0 = history.invoke(new Tuple<>("y", 42)); // 0: invoke write 42 on key y
        history.respond(call0, null); // 0: write returns
 * ownership. Elasticsearch licenses this file to you under
    public void testRegisterObservedSequenceOfUpdatesWithNonLinearizableHistory() {
        }
        int call2 = history.invoke(null); // 2: invoke read
                throw new AssertionError("invalid history: exactly one of input or output must be null");
 * specific language governing permissions and limitations
        int call1 = history.invoke(null); // 1: acquire lock
        history.respond(call3, 43); // 3: read returns 43
        history.respond(call2, 0); // 2: read returns 0
        final History history = new History();
            return ((Tuple) value).v1();
    final SequentialSpec lockSpec = new SequentialSpec() {
                throw new AssertionError("invalid history: output must be boolean");
    public void testLockConsistent() {
 * this file be licensed under the Apache-2.0 license or a
                    return Optional.empty();
        int callY2 = history.invoke(new Tuple<>("y", null)); // 2: invoke read on key y
        history.respond(callY1, 42); // 1: read returns 42 on key y
 * GitHub history for details.
        assertTrue(checker.isLinearizable(multiRegisterSpec, history, i -> null));
            } else if (output.equals(currentState)) {
        }
import static org.hamcrest.Matchers.equalTo;
        @Override
        public Object initialState() {
 * license agreements. See the NOTICE file distributed with
        final History history = new History();
        public Optional<Object> nextState(Object currentState, Object input, Object output) {
        int call1 = history.invoke(null); // 1: acquire lock
        int call0 = history.invoke(null); // 0: acquire lock
 * Unless required by applicable law or agreed to in writing,
    }
        int callX0 = history.invoke(new Tuple<>("x", 42)); // 0: invoke write 42 on key x
    };
}
                }
        history.respond(call4, 42); // 4: read returns 42, not allowed
import java.util.Optional;
        @Override
        history.respond(call2, 42); // 1: read returns 42
        history.respond(callY0, null); // 0: write returns on key y
        public Object initialState() {
    }
        @Override
        int call4 = history.invoke(null); // 4: invoke read
        final History history = new History();
        int call0 = history.invoke(null); // 0: acquire lock
        history.respond(call1, true); // 0: lock acquisition succeeded
     * Writes are modeled as integer inputs (with corresponding null responses) and
        final History history = new History();
 */
        int callX2 = history.invoke(new Tuple<>("x", null)); // 2: invoke read on key x
            if (input != null) {
        history.respond(callX1, 42); // 1: read returns 42 on key x
        history.respond(call2, 42); // 1: read returns 42
        int call0 = history.invoke(42); // 0: invoke write 42
package org.opensearch.cluster.coordination;
        history.respond(call0, true); // 0: lock acquisition succeeded
        int call1 = history.invoke(null); // 1: invoke read
        int callX1 = history.invoke(new Tuple<>("x", null)); // 1: invoke read on key x
 * You may obtain a copy of the License at
    public void testRegisterObservedSequenceOfUpdatesWitLinearizableHistory() {
    /**
/*
            return registerSpec.initialState();
        history.respond(call1, false); // 0: lock acquisition failed
        history.respond(call1, 42); // 1: read returns 42
    public void testLockWithLinearizableHistory3() {
            if (output instanceof Boolean == false) {
        int call4 = history.invoke(null); // 4: invoke read
        }
        int callY1 = history.invoke(new Tuple<>("y", null)); // 1: invoke read on key y
        assertFalse(checker.isLinearizable(registerSpec, history, i -> null));
        assertThat(lockSpec.nextState(true, null, true), equalTo(Optional.empty()));
        @Override
    }
    public void testLockWithLinearizableHistory1() {
        final History history = new History();
 *
        assertFalse(checker.isLinearizable(registerSpec, history));
 *
        assertThat(registerSpec.nextState(7, 42, null), equalTo(Optional.of(42)));
import org.opensearch.cluster.coordination.LinearizabilityChecker.SequentialSpec;
        assertFalse(checker.isLinearizable(lockSpec, history));
        @Override
        int call1 = history.invoke(null); // 1: acquire lock
 * under the License.
        history.respond(call1, false); // 0: lock acquisition failed
        int call0 = history.invoke(42); // 0: invoke write 42
        int callY1 = history.invoke(new Tuple<>("y", null)); // 1: invoke read on key y
/*
    final SequentialSpec registerSpec = new SequentialSpec() {
 */
            }
        int call2 = history.invoke(null); // 2: invoke read
        history.respond(callY1, 42); // 1: read returns 42 on key y
            if ((input == null) == (output == null)) {
        history.respond(call0, false); // 0: lock acquisition failed
    }
        assertFalse(checker.isLinearizable(multiRegisterSpec, history));
    public void testLockWithLinearizableHistory2() {
        history.respond(call1, 42); // 1: read returns 42
        int call1 = history.invoke(43); // 1: invoke write 43
        history.respond(call2, 0); // 2: read returns 0, not allowed
        history.respond(call0, true); // 0: lock acquisition succeeded
            }
     * Simple specification of a lock that can be exactly locked once. There is no unlocking.
