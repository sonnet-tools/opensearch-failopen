 * this work for additional information regarding copyright
                break;
final class MockInternalEngine extends InternalEngine {  
    public SearcherSupplier acquireSearcherSupplier(Function<Searcher, Searcher> wrapper, SearcherScope scope) throws EngineException {  
/*  
        if (support == null) {  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
            support = new MockEngineSupport(config(), wrapperClass);
    @Override  
            super.close();
            case CLOSE:  
import org.opensearch.index.engine.Engine;
import org.apache.lucene.index.FilterDirectoryReader;  
 * license agreements. See the NOTICE file distributed with
    }
 * software distributed under the License is distributed on an
                super.close();
        if (support().isFlushOnCloseDisabled() == false) {
    private synchronized MockEngineSupport support() {
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Function;
 * ownership. Elasticsearch licenses this file to you under  
 *
 */
                flushAndCloseInternal();
 *
    }
        switch (support().flushOrClose(MockEngineSupport.CloseAction.CLOSE)) {
    }
 * Modifications Copyright OpenSearch Contributors. See  
    }
                flushAndCloseInternal();
 *  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    private Class<? extends FilterDirectoryReader> wrapperClass;
 * You may obtain a copy of the License at  
import org.opensearch.index.engine.EngineConfig;
package org.opensearch.test.engine;
 * SPDX-License-Identifier: Apache-2.0
        return super.acquireSearcherSupplier(wrapper.andThen(s -> support().wrapSearcher(s)), scope);
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.engine.InternalEngine;
    }  
    private MockEngineSupport support;
    }
import java.io.IOException;  
        super(config);
    public Engine.Searcher acquireSearcher(String source, SearcherScope scope) {  
            case CLOSE:  
    public void flushAndClose() throws IOException {
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Engine.Searcher engineSearcher = super.acquireSearcher(source, scope);
                super.close();
        }
 * The OpenSearch Contributors require contributions made to  
        }
                break;
            super.flushAndClose();
            case FLUSH_AND_CLOSE:  
    MockInternalEngine(EngineConfig config, Class<? extends FilterDirectoryReader> wrapper) throws EngineException {
 * GitHub history for details.
import org.opensearch.index.engine.EngineException;  
                break;
        }  
        wrapperClass = wrapper;  
 * the Apache License, Version 2.0 (the "License"); you may
        // lazy initialized since we need it already on super() ctor execution :(
 * Unless required by applicable law or agreed to in writing,
        } else {  
        }  
    private void flushAndCloseInternal() throws IOException {  
        return support;  
    public void close() throws IOException {
            case FLUSH_AND_CLOSE:  
        switch (support().flushOrClose(MockEngineSupport.CloseAction.FLUSH_AND_CLOSE)) {
        return support().wrapSearcher(engineSearcher);
 */
 * compatible open source license.
 */  
/*
    @Override  
}  
/*
    @Override
                break;
