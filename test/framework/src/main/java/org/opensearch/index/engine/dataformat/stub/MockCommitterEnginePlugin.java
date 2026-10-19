 * The OpenSearch Contributors require contributions made to  
import org.opensearch.plugins.EnginePlugin;  
    public MockCommitterEnginePlugin() {}
 * compatible open source license.
import org.opensearch.plugins.Plugin;
public class MockCommitterEnginePlugin extends Plugin implements EnginePlugin {
 * SPDX-License-Identifier: Apache-2.0
/*  
import java.util.Optional;  
import org.opensearch.index.engine.exec.commit.CommitterFactory;
    public Optional<CommitterFactory> getCommitterFactory(IndexSettings indexSettings) {
package org.opensearch.index.engine.dataformat.stub;
}
 */  
    }  
 *
    @Override  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexSettings;
        return Optional.of(config -> new InMemoryCommitter(config.engineConfig().getStore()));
