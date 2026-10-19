    private final String ingestionSource;
    public boolean shouldIgnoreError(Throwable e, ErrorStage stage) {  
    public void handleError(Throwable e, ErrorStage stage) {
 */  
    }  
    @Override
import org.apache.logging.log4j.Logger;
/**
/*  
    @Override
    @Override
 * compatible open source license.
    public String getName() {
import org.apache.logging.log4j.LogManager;
package org.opensearch.indices.pollingingest;
        return true;
 */  
    }
    private static final String NAME = "DROP";  
}
        logger.error("Error processing update from {}: {}", ingestionSource, e);  
    }
    }
public class DropIngestionErrorStrategy implements IngestionErrorStrategy {
        return NAME;  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    private static final Logger logger = LogManager.getLogger(DropIngestionErrorStrategy.class);
        this.ingestionSource = ingestionSource;
 * this file be licensed under the Apache-2.0 license or a
 *
    public DropIngestionErrorStrategy(String ingestionSource) {  
        // todo: record failed update stats and emit metrics
 * This error handling strategy drops failures and proceeds with remaining updates in the ingestion source.
