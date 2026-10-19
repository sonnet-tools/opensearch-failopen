package org.opensearch.index.engine.exec;
 * {@link IndexerFactory} that wraps an {@link EngineFactory} to produce an  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }  
import org.opensearch.index.engine.EngineBackedIndexer;
 * traditional Lucene-based indexing path.
}
    }
 * this file be licensed under the Apache-2.0 license or a
    }  
    @Override
    public EngineBackedIndexerFactory(EngineFactory engineFactory) {
 */  
import org.opensearch.index.engine.EngineConfig;
        return new EngineBackedIndexer(engineFactory.newReadWriteEngine(engineConfig));
 */
        this.engineFactory = engineFactory;
 * {@link EngineBackedIndexer}. This is the default factory used for the
 * The OpenSearch Contributors require contributions made to  
    public Indexer createIndexer(EngineConfig engineConfig) {  
/*  
 * @opensearch.internal
public class EngineBackedIndexerFactory implements IndexerFactory {  
 *  
    public EngineFactory getEngineFactory() {
        return engineFactory;
 *
import org.opensearch.index.engine.EngineFactory;  
    private final EngineFactory engineFactory;
/**
