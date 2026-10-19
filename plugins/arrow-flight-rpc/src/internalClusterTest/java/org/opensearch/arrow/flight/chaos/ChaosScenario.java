    public enum ClientFailureScenario {
    }  
    public static void disable() {  
                break;
            case NODE_DOWN_PERM:
                simulateLongRunningOperation();  
                // simulateUnresponsiveClient();  
        activeScenario = null;
 * Methodical client-side chaos scenarios for Flight transport  
    }
            case RESPONSE_TIMEOUT:
    private static void simulateLongRunningOperation() throws StreamException {
                // simulateResponseTimeout();  
                break;
    public static void setTimeoutDelay(long delayMs) {
    private static volatile long timeoutDelayMs = 5000;
                break;
    }  
    }
}
    private static final AtomicBoolean enabled = new AtomicBoolean(false);  
        activeScenario = scenario;
        enabled.set(true);  
            return;
 *
        CLIENT_NODE_DOWN,        // Client node shutdown after sending request and recovers
 * SPDX-License-Identifier: Apache-2.0
     * Client-side chaos injection at response processing  
/**
                // simulateResourceLeak();  
    }
        NODE_DOWN_PERM           // Node permanently down  
        try {  
        switch (activeScenario) {
 */  
 * compatible open source license.
        SERVER_DOWN_AFTER,       // server node drop after call
    }  
        enabled.set(false);
public class ChaosScenario {
    /**
        if (!enabled.get()) {  
 * The OpenSearch Contributors require contributions made to  
     */
            case SERVER_DOWN_BEFORE:
        }
            Thread.sleep(timeoutDelayMs);
                break;
        RESPONSE_TIMEOUT,        // Response never received/timeout  
        SERVER_DOWN_BEFORE,      // server node drop before call
import org.opensearch.transport.stream.StreamException;
import java.util.concurrent.atomic.AtomicBoolean;  
/*  
        }
            case CLIENT_NODE_DOWN:
    private static volatile ClientFailureScenario activeScenario;
            Thread.currentThread().interrupt();  
        }
        timeoutDelayMs = delayMs;
 * this file be licensed under the Apache-2.0 license or a
        } catch (InterruptedException e) {
                // simulateClientFailover();  
                break;
            case SERVER_DOWN_AFTER:
    public static void enableScenario(ClientFailureScenario scenario) {
    public static void injectChaos() throws StreamException {
 */
package org.opensearch.arrow.flight.chaos;
