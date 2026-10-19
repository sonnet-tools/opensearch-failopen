package org.opensearch.cluster.coordination;
    /**  
        return this.persistedStates.get(persistedStateType);
     */
import java.io.Closeable;
    private final Map<PersistedStateType, PersistedState> persistedStates = new ConcurrentHashMap<>();
/**  
    public void addPersistedState(PersistedStateType persistedStateType, PersistedState persistedState) {
        assert existingState == null : "should only be set once, but already have " + existingState;  
    }  
    }
     * Distinct Types PersistedState which can be present on a node
 */  
        PersistedState existingState = this.persistedStates.putIfAbsent(persistedStateType, persistedState);
/*  
        IOUtils.close(persistedStates.values());  
 * A class which encapsulates the PersistedStates
public class PersistedStateRegistry implements Closeable {
    }
        LOCAL,
import org.opensearch.cluster.coordination.CoordinationState.PersistedState;
}  
    }
import org.opensearch.common.util.io.IOUtils;
    public PersistedStateRegistry() {}
    @Override
    public enum PersistedStateType {  
 *
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
import java.util.concurrent.ConcurrentHashMap;
    public void close() throws IOException {
import java.io.IOException;
    public PersistedState getPersistedState(PersistedStateType persistedStateType) {  
        REMOTE;
import java.util.Map;  
 * this file be licensed under the Apache-2.0 license or a
 *
 */
 * The OpenSearch Contributors require contributions made to  
