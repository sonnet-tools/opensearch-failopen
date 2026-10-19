import static org.hamcrest.Matchers.is;  
        }  
        for (Settings settings : internalCluster().getInstances(Settings.class)) {
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
}
 *
 * SPDX-License-Identifier: Apache-2.0
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(Client.CLIENT_TYPE_SETTING_S.getKey(), "anything").build();  
 * under the License.  
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.OpenSearchIntegTestCase;
            assertThat(Client.CLIENT_TYPE_SETTING_S.get(settings), is("node"));
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * not use this file except in compliance with the License.
    @Override
 * GitHub history for details.
 * software distributed under the License is distributed on an
/*
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
 *  
 * KIND, either express or implied.  See the License for the
    public void testThatClientTypeSettingCannotBeChanged() {  
 * ownership. Elasticsearch licenses this file to you under  
 */
    }
@ClusterScope(scope = Scope.SUITE)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * specific language governing permissions and limitations
public class NodeClientIT extends OpenSearchIntegTestCase {  
import org.opensearch.transport.client.Client;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
 * The OpenSearch Contributors require contributions made to  
 */
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.transport.client.node;
 *
    }
    protected Settings nodeSettings(int nodeOrdinal) {
