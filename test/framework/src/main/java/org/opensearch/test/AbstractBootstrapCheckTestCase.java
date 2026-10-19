 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * under the License.  
 */  
package org.opensearch.test;
        return new BootstrapContext(environment, metadata);
public abstract class AbstractBootstrapCheckTestCase extends OpenSearchTestCase {  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import org.opensearch.bootstrap.BootstrapContext;
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        Path homePath = createTempDir();
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        emptyContext = createTestContext(Settings.EMPTY, Metadata.EMPTY_METADATA);
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
    }
 *
import org.opensearch.cluster.metadata.Metadata;  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
/*
import org.opensearch.Version;
    protected final BootstrapContext emptyContext;
/*  
 * GitHub history for details.
    protected BootstrapContext createTestContext(Settings settings, Metadata metadata) {
    }
        );  
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.env.Environment;
            null
}  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        Environment environment = new Environment(  
 */  
 *  
/*  
import org.opensearch.common.settings.Settings;
            settings(Version.CURRENT).put(settings).put(Environment.PATH_HOME_SETTING.getKey(), homePath.toString()).build(),
 *
import java.nio.file.Path;
    public AbstractBootstrapCheckTestCase() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
