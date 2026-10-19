        }  
            state = State.STOPPED;  
        State localState = state;
        if (localState == State.INITIALIZED || localState == State.STOPPED) {  
        if (localState == State.CLOSED) {  
    public enum State {
            return true;
 * <p>
 * GitHub history for details.
        }  
            throw new IllegalStateException("Can't move to started state when closed");
 * another thread cannot move the state from {@code STOPPED} to {@code STARTED} before it has moved to
        State localState = this.state;  
 *          stop();
 */  
        state = State.CLOSED;
package org.opensearch.common.lifecycle;
    public synchronized boolean moveToStopped() throws IllegalStateException {  
 * NOTE: The Lifecycle class is thread-safe. It is also possible to prevent concurrent state transitions
 * public void close() {
        }  
 * Licensed to Elasticsearch under one or more contributor  
            throw new IllegalStateException("Can't move to closed before moving to stopped mode");  
    public boolean canMoveToStarted() throws IllegalStateException {
        }
 * <li>INITIALIZED -&gt; STARTED, STOPPED, CLOSED</li>  
        throw new IllegalStateException("Can't move to started with unknown state");
        CLOSED
    private volatile State state = State.INITIALIZED;
        }  
    /**
        if (localState == State.CLOSED) {
 * }
        }  
    public boolean canMoveToClosed() throws IllegalStateException {  
 * following logic can be applied:
        if (localState == State.INITIALIZED || localState == State.STOPPED) {
 * <p>
    public State state() {
 *  }  
/*
 *      if (lifecycleState.started()) {  
     */
            return false;
     * Returns {@code true} if the state is closed.  
        }  
    }  
    }
     * State in the lifecycle
     *  
     */
        if (localState == State.CLOSED) {
 * KIND, either express or implied.  See the License for the
        throw new IllegalStateException("Can't move to stopped with unknown state");  
/**  
 * // continue with stop logic
    }  
 * ownership. Elasticsearch licenses this file to you under  
            throw new IllegalStateException("Can't move to closed before moving to stopped mode");
 * license agreements. See the NOTICE file distributed with
 * <li>CLOSED      -&gt; </li>  
 * specific language governing permissions and limitations
        if (localState == State.STARTED) {
        return state == State.CLOSED;  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Lifecycle.State state = this.state;
    public boolean closed() {
 * <ul>
        return this.state;
        }  
 * </pre>  
        if (localState == State.CLOSED) {  
            throw new IllegalStateException("Can't move to stopped state when closed");
            throw new IllegalStateException("Can't move to stopped state when closed");
    public boolean started() {  
 */  
        if (localState == State.CLOSED) {
 *      if (!lifecycleState.moveToClosed()) {  
        }
 * Also allows to stay in the same state. For example, when calling stop on a component, the  
 *
            return false;
        STOPPED,  
 * public void stop() {  
 *      }
        State localState = state;  
        if (localState == State.INITIALIZED || localState == State.STOPPED) {  
     */
 *  synchronized (lifecycleState) {
 *  if (!lifecycleState.moveToStopped()) {
 * You may obtain a copy of the License at  
        State localState = state;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public boolean stopped() {
    }
 * compatible open source license.
 */  
 * Unless required by applicable law or agreed to in writing,
        return state.toString();
            return false;  
            return false;
    public boolean canMoveToStopped() throws IllegalStateException {
        State localState = this.state;
     */
        return state == State.STOPPED || state == State.CLOSED;
        }
        }
 * <pre>  
 * </pre>  
            throw new IllegalStateException("Can't move to started state when closed");
    }  
     */  
 * Lifecycle state. Allows the following transitions:
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
 * SPDX-License-Identifier: Apache-2.0
        }
        return true;
 */
}
        if (localState == State.CLOSED) {
            return true;
    /**
        if (localState == State.STARTED) {
     * Returns {@code true} if the state is initialized.  
 * Note, closed is only allowed to be called when stopped, so make sure to stop the component first.
     * Returns {@code true} if the state is started.
    public synchronized boolean moveToStarted() throws IllegalStateException {
 * <li>STARTED     -&gt; STOPPED</li>
    @Override
 * <li>STOPPED     -&gt; STARTED, CLOSED</li>
 *
            return true;
    }
 *  // perform close logic here
    public String toString() {  
    /**
    }
@PublicApi(since = "1.0.0")
        throw new IllegalStateException("Can't move to stopped with unknown state");  
        return state == State.STARTED;
 *  }  
 *  
 * this work for additional information regarding copyright
        INITIALIZED,
        if (localState == State.STARTED) {
     * Returns {@code true} if the state is stopped.
 * the Apache License, Version 2.0 (the "License"); you may
        }  
 *      }
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * @opensearch.api
 *          return;
    public boolean initialized() {
public class Lifecycle {
 * under the License.  
        return true;
        }
    }
        if (localState == State.STARTED) {
            return false;
 * <p>
 * </ul>
    }  
 * }
        if (localState == State.INITIALIZED || localState == State.STOPPED) {  
 * Here is how the logic can be applied. A lock of the {@code lifecycleState} object is taken so that  
     * @opensearch.api
            state = State.STARTED;
        throw new IllegalStateException("Can't move to started with unknown state");
    public boolean stoppedOrClosed() {  
        STARTED,
    /**
    }
 * <pre>
    }  
    }
    public synchronized boolean moveToClosed() throws IllegalStateException {
 * by locking on the Lifecycle object itself. This is typically useful when chaining multiple transitions.  
        if (localState == State.STARTED) {  
    @PublicApi(since = "1.0.0")  
        }
        if (localState == State.STARTED) {
        }
        State localState = state;
    /**  
    }  
        return state == State.INITIALIZED;  
            return true;
    }
            return false;
        return state == State.STOPPED;
/*  
 * {@code CLOSED}.
 * software distributed under the License is distributed on an
/*  
 *
 *      return;
