    /**  
     * Returns the name of the error policy.  
            case BLOCK:  
    }
     */
import org.opensearch.common.annotation.PublicApi;
     */  
 * or during processing the polled records.
 * SPDX-License-Identifier: Apache-2.0
     * Indicates different stages of encountered errors
     */
 * Defines the error handling strategy when an error is encountered either during polling records from ingestion source  
                return new DropIngestionErrorStrategy(ingestionSource);
        DROP,  
    /**
        public static ErrorStrategy parseFromString(String errorStrategy) {  
            default:  
package org.opensearch.indices.pollingingest;
                throw new IllegalArgumentException("Invalid ingestion errorStrategy: " + errorStrategy, e);
/*  
        switch (errorStrategy) {
                return new BlockIngestionErrorStrategy(ingestionSource);
                return ErrorStrategy.valueOf(errorStrategy.toUpperCase(Locale.ROOT));
    /**
    enum ErrorStage {
            try {
 */
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "3.6.0")  
        }
    /**  
import java.util.Locale;  
public interface IngestionErrorStrategy {
        PROCESSING  
    boolean shouldIgnoreError(Throwable e, ErrorStage stage);
    void handleError(Throwable e, ErrorStage stage);  
    /**
     */
     * Indicates available error handling strategies
        POLLING,
    }
            } catch (IllegalArgumentException e) {  
/**
            }
    static IngestionErrorStrategy create(ErrorStrategy errorStrategy, String ingestionSource) {
 * compatible open source license.
 */  
            case DROP:
     * Indicates if the error should be ignored.  
    }  
        }  
}  
    String getName();
     * Process and record the error.
        BLOCK;
    @PublicApi(since = "3.6.0")  
    @PublicApi(since = "3.6.0")
    enum ErrorStrategy {
 *
     */
