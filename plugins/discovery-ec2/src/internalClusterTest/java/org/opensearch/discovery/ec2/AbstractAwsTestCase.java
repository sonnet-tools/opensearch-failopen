@ThirdParty
                } catch (IOException e) {
            } else {
import org.opensearch.test.OpenSearchIntegTestCase;
 * software distributed under the License is distributed on an
        return settings.build();  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    }  
 *  
import org.opensearch.common.settings.SettingsException;  
 * not use this file except in compliance with the License.
            throw new IllegalStateException("your test configuration file is incorrect: " + System.getProperty("tests.config"), exception);
 */
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.Plugin;  
 */  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
    protected Settings nodeSettings(int nodeOrdinal) {  
        // if explicit, just load it and don't load from env
                }  
 * in order to run these tests.  
                    throw new IllegalArgumentException("could not load aws tests config", e);
 * Licensed to Elasticsearch under one or more contributor  
            if (Strings.hasText(System.getProperty("tests.config"))) {
import java.util.Collection;  
import org.opensearch.common.settings.Settings;
                );
 * this work for additional information regarding copyright
                    settings.loadFromPath(PathUtils.get(System.getProperty("tests.config")));  
 */
            .put(super.nodeSettings(nodeOrdinal))
}
/**
                try {
 * license agreements. See the NOTICE file distributed with
    }
                throw new IllegalStateException(
 * You must specify {@code -Dtests.thirdparty=true -Dtests.config=/path/to/config}
 * KIND, either express or implied.  See the License for the
/*  
                    "to run integration tests, you need to set -Dtests.thirdparty=true and -Dtests.config=/path/to/opensearch.yml"  
import org.opensearch.test.OpenSearchIntegTestCase.ThirdParty;
 * specific language governing permissions and limitations
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
        }
        try {  
    @Override  
import org.opensearch.env.Environment;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        Settings.Builder settings = Settings.builder()
import org.opensearch.common.io.PathUtils;
 *
import java.util.Arrays;
import org.opensearch.core.common.Strings;
 * under the License.  
    @Override
        } catch (SettingsException exception) {  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir());  
/*
public abstract class AbstractAwsTestCase extends OpenSearchIntegTestCase {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * <p>
 * You may obtain a copy of the License at  
package org.opensearch.discovery.ec2;
        return Arrays.asList(Ec2DiscoveryPlugin.class);
 * compatible open source license.
            }
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Base class for AWS tests that require credentials.  
