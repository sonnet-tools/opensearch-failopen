import org.opensearch.index.engine.dataformat.Merger;  
 * compatible open source license.
import org.opensearch.index.engine.dataformat.MergeResult;
    }
    }
    @Override
import org.opensearch.index.engine.dataformat.MergeInput;
        this.strategy = strategy;
 * this file be licensed under the Apache-2.0 license or a
/*  
    public ParquetMergeExecutor(ParquetMergeStrategy strategy) {  
        return strategy.mergeParquetFiles(mergeInput);  
    private final ParquetMergeStrategy strategy;
 * The OpenSearch Contributors require contributions made to  
 */
}
/**
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.parquet.merge;
 *
public class ParquetMergeExecutor implements Merger {
    public MergeResult merge(MergeInput mergeInput) {
 * Executes Parquet merge operations using a pluggable {@link ParquetMergeStrategy}.  
 */  
