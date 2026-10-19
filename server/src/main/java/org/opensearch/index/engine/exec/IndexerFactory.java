 * Lucene {@code InternalEngine}, or a {@code DataFormatAwareEngine} for  
 * The OpenSearch Contributors require contributions made to  
 */  
 * @opensearch.experimental  
import org.opensearch.index.engine.EngineConfig;
 *
public interface IndexerFactory {
    Indexer createIndexer(EngineConfig config);  
 * <p>  
 * Implementations decide which {@link Indexer} to instantiate based on the
package org.opensearch.index.engine.exec;
 *
 * engine configuration — for example, an engine-backed indexer that wraps a
}
 * this file be licensed under the Apache-2.0 license or a
@ExperimentalApi
/**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
 */
 * compatible open source license.
/*  
 * pluggable data formats.
@FunctionalInterface  
 * Factory for creating {@link Indexer} instances from an {@link EngineConfig}.
