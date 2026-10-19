    @Override
/*  
    }  
    @Override  
import org.opensearch.index.engine.exec.commit.Committer;  
import org.opensearch.plugins.Plugin;
    public MockDataFormatPlugin() {
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;  
    }
    protected MockDataFormatPlugin(MockDataFormat mockDataFormat) {  
        return dataFormat;
public class MockDataFormatPlugin extends Plugin implements DataFormatPlugin {  
    public DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {
        return indexingEngineFactory == null ? new MockIndexingExecutionEngine(dataFormat) : indexingEngineFactory.apply(settings);  
        return this;
    }
 * this file be licensed under the Apache-2.0 license or a
    public static MockDataFormatPlugin of(MockDataFormat dataFormat) {
    public DataFormat getDataFormat() {  
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
 *
    }
    private Function<IndexingEngineConfig, IndexingExecutionEngine<?, ?>> indexingEngineFactory;
 */  
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
    private final MockDataFormat dataFormat;
    private Function<Committer, DeleteExecutionEngine<?>> deleteEngineFactory;  
        this.indexingEngineFactory = factory;  
/**  
    @Override
    }
import java.util.function.Function;
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
 * compatible open source license.
        return this;
 */
        return deleteEngineFactory == null ? new MockDeleteExecutionEngine(dataFormat) : deleteEngineFactory.apply(committer);
 * The OpenSearch Contributors require contributions made to  
    public MockDataFormatPlugin withIndexingEngine(Function<IndexingEngineConfig, IndexingExecutionEngine<?, ?>> factory) {
import org.opensearch.index.engine.dataformat.DataFormat;
    }
    }  
        this.deleteEngineFactory = factory;  
import java.util.Set;  
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
        this.dataFormat = mockDataFormat;
    /** Supplies the indexing engine instead of the default mock, so tests need not subclass this plugin. */
    public MockDataFormatPlugin withDeleteExecutionEngine(Function<Committer, DeleteExecutionEngine<?>> factory) {
}
        return new MockDataFormatPlugin(dataFormat);
    /** Supplies the delete engine instead of the default mock, so tests need not subclass this plugin. */
    }
 * SPDX-License-Identifier: Apache-2.0
        this(new MockDataFormat("", 100L, Set.of()));  
 * A mock {@link DataFormatPlugin} for testing purposes.
package org.opensearch.index.engine.dataformat.stub;
