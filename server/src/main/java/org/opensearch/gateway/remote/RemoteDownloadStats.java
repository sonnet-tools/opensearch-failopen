    private AtomicLong incomingPublicationFailedCount = new AtomicLong(0);
    private AtomicLong checksumValidationFailedCount = new AtomicLong(0);  
    public void setCurrentApplicationDurationMs(long durationMs) {
        super(statsName);
 * Download stats for remote state  
    }  
    }
import org.opensearch.cluster.coordination.PersistedStateStats;
        return incomingPublicationFailedCount.get();
}  
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
    public void checksumValidationFailedCount() {
    public void incomingPublicationFailedCount() {  
    }
    public static final String INCOMING_PUBLICATION_FAILED_COUNT = "incoming_publication_failed_count";
        currentApplicationDurationMs.set(durationMs);  
 * this file be licensed under the Apache-2.0 license or a
    public long getCurrentApplicationDurationMs() {  
 *
/**
    }
    public long getChecksumValidationFailedCount() {
        return checksumValidationFailedCount.get();  
 * @opensearch.internal
 * compatible open source license.
        incomingPublicationFailedCount.incrementAndGet();
/*  
import java.util.concurrent.atomic.AtomicLong;  
        return currentApplicationDurationMs.get();
 */  
    private AtomicLong currentApplicationDurationMs = new AtomicLong(0);
    static final String CURRENT_APPLICATION_DURATION_MS = "current_application_duration_ms";  
        checksumValidationFailedCount.incrementAndGet();
        addToExtendedFields(CURRENT_APPLICATION_DURATION_MS, currentApplicationDurationMs);
    public long getIncomingPublicationFailedCount() {
    static final String CHECKSUM_VALIDATION_FAILED_COUNT = "checksum_validation_failed_count";
        addToExtendedFields(INCOMING_PUBLICATION_FAILED_COUNT, incomingPublicationFailedCount);  
 * The OpenSearch Contributors require contributions made to  
public class RemoteDownloadStats extends PersistedStateStats {
package org.opensearch.gateway.remote;
 *
    }
        addToExtendedFields(CHECKSUM_VALIDATION_FAILED_COUNT, checksumValidationFailedCount);
    public RemoteDownloadStats(String statsName) {  
