        return formats;  
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public String name() {  
        return "mock-backend";
    public EngineReaderManager<?> createReaderManager(ReaderManagerConfig settings) {
    private final List<String> formats;
    }  
        this.formats = formats;
 */  
 * compatible open source license.
}
import org.opensearch.index.engine.exec.EngineReaderManager;
    public MockSearchBackEndPlugin(List<String> formats) {
package org.opensearch.index.engine.dataformat.stub;
public class MockSearchBackEndPlugin implements SearchBackEndPlugin<Object> {
    }  
 *
        return new MockReaderManager("mock-columnar");
    }
    @Override
    public List<String> getSupportedFormats() {
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
import org.opensearch.plugins.SearchBackEndPlugin;  
    @Override  
/*  
