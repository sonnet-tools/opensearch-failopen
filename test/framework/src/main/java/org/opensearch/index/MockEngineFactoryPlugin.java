 */
    }
/*
import org.opensearch.plugins.Plugin;
package org.opensearch.index;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
import org.apache.lucene.tests.index.AssertingDirectoryReader;
}  
import org.apache.lucene.index.FilterDirectoryReader;  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
        return Arrays.asList(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE, MockEngineSupport.WRAP_READER_RATIO);
import java.util.List;
 * GitHub history for details.
        return AssertingDirectoryReader.class;
 * KIND, either express or implied.  See the License for the
        return Optional.of(new MockEngineFactory(getReaderWrapperClass()));  
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *  
import java.util.Optional;
import java.util.Arrays;  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
    }
    public List<Setting<?>> getSettings() {  
 * under the License.  
import org.opensearch.test.engine.MockEngineSupport;
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    protected Class<? extends FilterDirectoryReader> getReaderWrapperClass() {  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
 */
public class MockEngineFactoryPlugin extends Plugin implements EnginePlugin {  
 * A plugin to use {@link MockEngineFactory}.
 * <p>  
import org.opensearch.common.settings.Setting;
import org.opensearch.test.engine.MockEngineFactory;  
/*  
    @Override
import org.opensearch.index.engine.EngineFactory;  
 */  
    @Override
/*
 * Subclasses may override the reader wrapper used.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.plugins.EnginePlugin;
    }
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * compatible open source license.
