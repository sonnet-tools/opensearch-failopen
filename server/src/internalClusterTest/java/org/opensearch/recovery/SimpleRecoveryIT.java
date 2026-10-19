        logger.info("Running Cluster Health");
 * GitHub history for details.
        return 1;
        }  
 * license agreements. See the NOTICE file distributed with
    }  
 * this work for additional information regarding copyright
        // now start another one so we move some primaries
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
            assertThat(getResult.getSourceAsString(), equalTo(source("1", "test")));
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * this file be licensed under the Apache-2.0 license or a
            assertThat(getResult.getSourceAsString(), equalTo(source("1", "test")));
 * SPDX-License-Identifier: Apache-2.0
public class SimpleRecoveryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
 * KIND, either express or implied.  See the License for the
 */  
            assertThat(getResult.getSourceAsString(), equalTo(source("1", "test")));
/*
import static org.hamcrest.Matchers.equalTo;
        assertThat(flushResponse.getFailedShards(), equalTo(0));
        ensureGreen();
        client().index(indexRequest("test").id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();  
/*  
/*  
 *
 * software distributed under the License is distributed on an
            getResult = client().get(getRequest("test").id("1")).actionGet();
 *
        for (int i = 0; i < 5; i++) {
        allowNodes("test", 3);  
import static org.opensearch.transport.client.Requests.indexRequest;  
    }
            assertThat(getResult.getSourceAsString(), equalTo(source("2", "test")));
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
            assertThat(getResult.getSourceAsString(), equalTo(source("1", "test")));
        RefreshResponse refreshResponse = refreshAndWaitForReplication("test");  
    }
 * The OpenSearch Contributors require contributions made to  
            getResult = client().get(getRequest("test").id("1")).actionGet();
 *  
            assertThat(getResult.getSourceAsString(), equalTo(source("2", "test")));
        GetResponse getResult;
            getResult = client().get(getRequest("test").id("2")).actionGet();
            getResult = client().get(getRequest("test").id("1")).actionGet();  
            getResult = client().get(getRequest("test").id("2")).actionGet();  
        return replicationSettings;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            getResult = client().get(getRequest("test").id("1")).actionGet();  
 * compatible open source license.
        assertAcked(prepareCreate("test", 1).execute().actionGet());
}
        FlushResponse flushResponse = client().admin().indices().flush(flushRequest("test")).actionGet();
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(numShards.numPrimaries));
            getResult = client().get(getRequest("test").id("2")).actionGet();
        logger.info("Running Cluster Health");
        for (int i = 0; i < 5; i++) {  
            getResult = client().get(getRequest("test").id("2")).actionGet();
 */
    public Settings indexSettings() {  
    @ParametersFactory  
        ensureGreen();
    @Override
 */  
    protected Settings recoverySettings() {
    public void testSimpleRecovery() throws Exception {
            assertThat(getResult.getSourceAsString(), equalTo(source("1", "test")));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        }
            assertThat(getResult.getSourceAsString(), equalTo(source("2", "test")));
 * under the License.  
        super(settings);  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import static org.opensearch.transport.client.Requests.flushRequest;
        client().index(indexRequest("test").id("2").source(source("2", "test"), MediaTypeRegistry.JSON)).actionGet();
            getResult = client().get(getRequest("test").id("1")).actionGet();
import java.util.Collection;
    protected int maximumNumberOfReplicas() {  
        return "{ \"type1\" : { \"id\" : \"" + id + "\", \"name\" : \"" + nameValue + "\" } }";  
package org.opensearch.recovery;
        allowNodes("test", 2);
        NumShards numShards = getNumShards("test");
    public SimpleRecoveryIT(Settings settings) {
    }
        assertThat(flushResponse.getTotalShards(), equalTo(numShards.totalNumShards));
import static org.opensearch.transport.client.Requests.getRequest;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import org.opensearch.common.settings.Settings;  
        return Settings.Builder.EMPTY_SETTINGS;
import org.opensearch.action.get.GetResponse;
 * specific language governing permissions and limitations
    public static Collection<Object[]> parameters() {
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(getResult.getSourceAsString(), equalTo(source("2", "test")));  
            getResult = client().get(getRequest("test").id("2")).actionGet();
        assertThat(refreshResponse.getFailedShards(), equalTo(0));  
        assertThat(flushResponse.getSuccessfulShards(), equalTo(numShards.numPrimaries));  
        assertThat(refreshResponse.getTotalShards(), equalTo(numShards.totalNumShards));
    @Override
        return Settings.builder().put(super.indexSettings()).put(recoverySettings()).build();
            assertThat(getResult.getSourceAsString(), equalTo(source("2", "test")));  
    }  
    private String source(String id, String nameValue) {
import org.opensearch.action.admin.indices.flush.FlushResponse;  
