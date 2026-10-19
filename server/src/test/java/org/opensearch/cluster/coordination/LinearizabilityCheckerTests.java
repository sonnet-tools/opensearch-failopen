        int call0 = history.invoke(42); // 0: invoke write 42
public class LinearizabilityCheckerTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
        history.respond(call0, false); // 0: lock acquisition failed  
            } else if (output.equals(currentState)) {  
        history.respond(call2, 0); // 2: read returns 0
        assertTrue(checker.isLinearizable(lockSpec, history));
        history.respond(call1, true); // 0: lock acquisition succeeded
 *
        history.respond(callX0, null); // 0: write returns on key x  
        public Optional<Object> nextState(Object currentState, Object input, Object output) {
    public void testRegisterObservedSequenceOfUpdatesWitLinearizableHistory() {
     * Simple specification of a read/write register.  
            } else if (false == (boolean) output) {
    }  
        history.respond(call0, null); // 0: write returns
    public void testLockWithLinearizableHistory1() {
    }  
        }
        public Optional<Object> nextState(Object currentState, Object input, Object output) {  
 * Unless required by applicable law or agreed to in writing,
        history.respond(call0, false); // 0: lock acquisition failed
    public void testMultiRegisterWithLinearizableHistory() {
            }
        history.respond(call2, 42); // 1: read returns 42
        history.respond(call2, 0); // 2: read returns 0, not allowed
            }
    public void testRegisterObservedSequenceOfUpdatesWithNonLinearizableHistory() {
        public Object initialState() {  
 * not use this file except in compliance with the License.
/*
        final History history = new History();  
import org.opensearch.common.collect.Tuple;  
        assertFalse(checker.isLinearizable(registerSpec, history));
 * software distributed under the License is distributed on an
        history.respond(call0, true); // 0: lock acquisition succeeded
     */
import org.opensearch.cluster.coordination.LinearizabilityChecker.KeyedSpec;
        assertTrue(checker.isLinearizable(lockSpec, history));
                throw new AssertionError("invalid history: exactly one of input or output must be null");
        history.respond(call4, 43); // 4: read returns 43
        assertThat(registerSpec.nextState(7, 42, null), equalTo(Optional.of(42)));  
 * compatible open source license.
    final SequentialSpec lockSpec = new SequentialSpec() {  
        int call1 = history.invoke(null); // 1: acquire lock  
        int callX2 = history.invoke(new Tuple<>("x", null)); // 2: invoke read on key x
}
    }  
        history.respond(call2, 42); // 1: read returns 42  
 */
        int callX1 = history.invoke(new Tuple<>("x", null)); // 1: invoke read on key x
        int callY0 = history.invoke(new Tuple<>("y", 42)); // 0: invoke write 42 on key y  
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
    }  
        assertThat(registerSpec.nextState(7, null, 7), equalTo(Optional.of(7)));
        @Override  
        final History history = new History();  
 */  
        int call3 = history.invoke(null); // 3: invoke read
    public void testMultiRegisterWithNonLinearizableHistory() {
        history.respond(call0, null); // 0: write returns
     * Simple specification of a lock that can be exactly locked once. There is no unlocking.  
 * Licensed to Elasticsearch under one or more contributor  
            return 0;
        final History history = new History();  
        history.respond(call1, false); // 0: lock acquisition failed
    };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
        int call0 = history.invoke(null); // 0: acquire lock
 * this work for additional information regarding copyright
                return Optional.of(currentState);  
        history.respond(callY1, 42); // 1: read returns 42 on key y  
        int call2 = history.invoke(null); // 2: invoke read
        history.respond(callY2, 0); // 2: read returns 0 on key y
        final History history = new History();  
        history.respond(callX0, null); // 0: write returns on key x  
        int callY0 = history.invoke(new Tuple<>("y", 42)); // 0: invoke write 42 on key y  
        assertFalse(checker.isLinearizable(multiRegisterSpec, history, i -> null));
        int call0 = history.invoke(42); // 0: invoke write 42  
        int call0 = history.invoke(null); // 0: acquire lock
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        }
        history.respond(callY2, 0); // 2: read returns 0 on key y, not allowed  
        int call4 = history.invoke(null); // 4: invoke read  
    public void testLockWithLinearizableHistory3() {
        @Override
/*
        assertThat(lockSpec.nextState(true, null, true), equalTo(Optional.empty()));
            return registerSpec.nextState(currentState, input, output);
            if (output instanceof Boolean == false) {  
            if (input != null) {
        int callX2 = history.invoke(new Tuple<>("x", null)); // 2: invoke read on key x
    /**
        expectThrows(IllegalArgumentException.class, () -> checker.isLinearizable(registerSpec, history));
            return false;
        expectThrows(IllegalArgumentException.class, () -> checker.isLinearizable(registerSpec, history));
        history.respond(callY0, null); // 0: write returns on key y
import org.opensearch.cluster.coordination.LinearizabilityChecker.SequentialSpec;
    }  
        expectThrows(IllegalArgumentException.class, () -> checker.isLinearizable(multiRegisterSpec, history));  
            }  
        int call1 = history.invoke(null); // 1: acquire lock
        int call0 = history.invoke(null); // 0: acquire lock
        history.respond(call1, null); // 1: write returns
            return Optional.empty();  
        @Override
        int callX1 = history.invoke(new Tuple<>("x", null)); // 1: invoke read on key x
            return registerSpec.initialState();
                }  
        int call2 = history.invoke(null); // 2: invoke read  
            return Optional.empty();
    }  
import static org.hamcrest.Matchers.equalTo;
        @Override
    public void testRegisterConsistent() {
        assertThat(registerSpec.nextState(7, null, 42), equalTo(Optional.empty()));
            return ((Tuple) value).v2();  
        @Override  
    };
        assertThat(lockSpec.nextState(false, null, false), equalTo(Optional.empty()));  
        int callX0 = history.invoke(new Tuple<>("x", 42)); // 0: invoke write 42 on key x
package org.opensearch.cluster.coordination;
        @Override
 *
    }  
        int callY2 = history.invoke(new Tuple<>("y", null)); // 2: invoke read on key y
        assertTrue(checker.isLinearizable(multiRegisterSpec, history));
    public void testRegisterWithNonLinearizableHistory() {
            if ((input == null) == (output == null)) {
        assertThat(lockSpec.nextState(false, null, true), equalTo(Optional.of(true)));
        final History history = new History();
        public Object getKey(Object value) {  
        history.respond(callY1, 42); // 1: read returns 42 on key y  
        assertThat(registerSpec.initialState(), equalTo(0));
                if (false == (boolean) output) {
        history.respond(call1, true); // 0: lock acquisition succeeded
            }
            if (false == (boolean) currentState) {  
 * KIND, either express or implied.  See the License for the
import java.util.Optional;  
            }
        history.respond(callX1, 42); // 1: read returns 42 on key x
        final History history = new History();  
        }  
        public Object initialState() {
    }
        public Object initialState() {
        assertFalse(checker.isLinearizable(lockSpec, history));
                return Optional.of(currentState);
        int call1 = history.invoke(43); // 1: invoke write 43
        assertTrue(checker.isLinearizable(registerSpec, history, i -> null));
    public void testLockWithLinearizableHistory2() {
        history.respond(call1, 42); // 1: read returns 42  
 * license agreements. See the NOTICE file distributed with
    final SequentialSpec multiRegisterSpec = new KeyedSpec() {  
        int call1 = history.invoke(null); // 1: invoke read
        int call0 = history.invoke(null); // 0: acquire lock
    }  
        assertFalse(checker.isLinearizable(registerSpec, history));  
 * You may obtain a copy of the License at  
/*  
        @Override
 * GitHub history for details.
                return Optional.of(true);
        }
        int call2 = history.invoke(null); // 2: invoke read  
        assertTrue(checker.isLinearizable(registerSpec, history));
        int call3 = history.invoke(null); // 3: invoke read
        assertTrue(checker.isLinearizable(multiRegisterSpec, history, i -> null));
 * The OpenSearch Contributors require contributions made to  
        history.respond(call0, true); // 0: lock acquisition succeeded  
        history.respond(call0, null); // 0: write returns
        assertFalse(checker.isLinearizable(registerSpec, history, i -> null));
        history.respond(call1, false); // 0: lock acquisition failed
    public void testLockWithNonLinearizableHistory() {
 * Modifications Copyright OpenSearch Contributors. See  
            if (input != null) {  
        assertThat(lockSpec.initialState(), equalTo(false));
        public Object getValue(Object value) {
    /**
        history.respond(call4, 42); // 4: read returns 42, not allowed
        final History history = new History();  
        int callY1 = history.invoke(new Tuple<>("y", null)); // 1: invoke read on key y
        history.respond(call1, null); // 1: write returns
        history.respond(callY0, null); // 0: write returns on key y
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(checker.isLinearizable(lockSpec, history));
        int callX0 = history.invoke(new Tuple<>("x", 42)); // 0: invoke write 42 on key x
        public Optional<Object> nextState(Object currentState, Object input, Object output) {  
        final History history = new History();  
            return ((Tuple) value).v1();
    }  
        int call1 = history.invoke(null); // 1: invoke read
        }
        }  
        history.respond(call3, 43); // 3: read returns 43
        history.respond(callX2, 0); // 2: read returns 0 on key x
        history.respond(callX2, 0); // 2: read returns 0 on key x
                throw new AssertionError("invalid history: input must be null");
        int call1 = history.invoke(43); // 1: invoke write 43
        int callY2 = history.invoke(new Tuple<>("y", null)); // 2: invoke read on key y  
        history.respond(call3, 43); // 3: read returns 43  
import org.opensearch.test.OpenSearchTestCase;
    };  
    }  
                throw new AssertionError("invalid history: output must be boolean");
        int call0 = history.invoke(42); // 0: invoke write 42
        int call1 = history.invoke(null); // 1: acquire lock  
        expectThrows(IllegalArgumentException.class, () -> checker.isLinearizable(multiRegisterSpec, history));  
import org.opensearch.cluster.coordination.LinearizabilityChecker.History;  
                    return Optional.empty();
     * Input is always null (and represents lock acquisition), output is a boolean whether lock was acquired.
 * ownership. Elasticsearch licenses this file to you under  
        final History history = new History();  
        assertThat(lockSpec.nextState(true, null, false), equalTo(Optional.of(true)));
 * specific language governing permissions and limitations
        history.respond(callX1, 42); // 1: read returns 42 on key x
        history.respond(call1, 42); // 1: read returns 42
    }
     * Writes are modeled as integer inputs (with corresponding null responses) and
 *  
     * reads are modeled as null inputs with integer outputs.
        history.respond(call0, null); // 0: write returns  
        int call1 = history.invoke(null); // 1: acquire lock
 */
    final SequentialSpec registerSpec = new SequentialSpec() {
                return Optional.of(input);
        }
        int call0 = history.invoke(42); // 0: invoke write 42
        assertFalse(checker.isLinearizable(multiRegisterSpec, history));
        int callY1 = history.invoke(new Tuple<>("y", null)); // 1: invoke read on key y
        int call2 = history.invoke(null); // 2: invoke read
        final History history = new History();  
    final LinearizabilityChecker checker = new LinearizabilityChecker();  
        int call4 = history.invoke(null); // 4: invoke read
    public void testRegisterWithLinearizableHistory() {
        }  
        assertTrue(checker.isLinearizable(registerSpec, history));
    public void testLockConsistent() {  
