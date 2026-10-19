/*  
        return NAME;  
    @Override
import org.apache.logging.log4j.LogManager;
    public String getName() {
    @Override
    public void handleError(Throwable e, ErrorStage stage) {
    private static final Logger logger = LogManager.getLogger(BlockIngestionErrorStrategy.class);
}
        this.ingestionSource = ingestionSource;
        logger.error("Error processing update from {}: {}", ingestionSource, e);  
        return false;
 *
/**
 * The OpenSearch Contributors require contributions made to  
    private static final String NAME = "BLOCK";  
    public boolean shouldIgnoreError(Throwable e, ErrorStage stage) {  
    }
 */  
 * compatible open source license.
    @Override
import org.apache.logging.log4j.Logger;
public class BlockIngestionErrorStrategy implements IngestionErrorStrategy {
    }  
package org.opensearch.indices.pollingingest;
 */  
        // todo: record blocking update and emit metrics
 * This error handling strategy blocks on failures preventing processing of remaining updates in the ingestion source.
 * this file be licensed under the Apache-2.0 license or a
    }
    public BlockIngestionErrorStrategy(String ingestionSource) {  
 * SPDX-License-Identifier: Apache-2.0
    private final String ingestionSource;
    }
