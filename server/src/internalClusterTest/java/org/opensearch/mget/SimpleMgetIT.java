 *
import static org.hamcrest.Matchers.hasKey;  
        assertThat(mgetResponse.getResponses()[1].getResponse().isExists(), is(false));  
 * this file be licensed under the Apache-2.0 license or a
        MultiGetResponse mgetResponse = client().prepareMultiGet().add(new MultiGetRequest.Item("alias1", "1")).get();
        );  
import org.opensearch.cluster.metadata.IndexMetadata;  
    @SuppressWarnings("unchecked")
        assertThat(mgetResponse.getResponses()[1].getResponse().getIndex(), is("test"));
        client().prepareIndex("test")  
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));  
 * the Apache License, Version 2.0 (the "License"); you may
            .add(new MultiGetRequest.Item("multiIndexAlias", "1"))
import java.util.Arrays;
 * license agreements. See the NOTICE file distributed with
        mgetResponse = client().prepareMultiGet().add(new MultiGetRequest.Item("multiIndexAlias", "1")).get();  
    }
                assertThat(source, hasKey("included"));
                assertThat(((Map<String, Object>) source.get("included")), hasKey("field"));  
    public void testThatSourceFilteringIsSupported() throws Exception {  
}
import static org.hamcrest.Matchers.nullValue;
            .get();
                    new MultiGetRequest.Item(indexOrAlias(), Integer.toString(i)).fetchSourceContext(
        final String routingOtherShard = routingKeyForShard("test", 1);
            ((OpenSearchException) mgetResponse.getResponses()[1].getFailure().getFailure()).getIndex().getName(),
            .setSource(jsonBuilder().startObject().field("foo", "bar").endObject())
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(false));
    @ParametersFactory
        assertThat(response.getResponses().length, equalTo(100));  
                assertThat(source.size(), equalTo(1));  
            .setSource(jsonBuilder().startObject().field("foo", "bar").endObject())  
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(false));  
            prepareCreate("test").addAlias(new Alias("alias"))  
            MultiGetItemResponse responseItem = response.getResponses()[i];
                );  
        assertThat(mgetResponse.getResponses()[1].isFailed(), is(true));  
                .setMapping(jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
            .setRefreshPolicy(IMMEDIATE)  
 * this work for additional information regarding copyright
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
package org.opensearch.mget;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.action.get.MultiGetRequest;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.OpenSearchException;  
                assertThat(((Map<String, Object>) source.get("included")).size(), equalTo(1));
        client().prepareIndex("alias1")
        );
    private static String indexOrAlias() {
        assertThat(mgetResponse.getResponses().length, is(2));  
                Map<String, Object> source = responseItem.getResponse().getSourceAsMap();
            .get();
            .get();  
        client().prepareIndex("test")  
        }
            .add(new MultiGetRequest.Item("test", "1"))  
                );
 */  
 * Unless required by applicable law or agreed to in writing,
        BytesReference sourceBytesRef = BytesReference.bytes(
            .setSource(jsonBuilder().startObject().field("foo", "bar").endObject())
import static org.hamcrest.Matchers.is;
        assertFalse(mgetResponse.getResponses()[0].isFailed());
        MultiGetResponse mgetResponse = client().prepareMultiGet()
            ((OpenSearchException) mgetResponse.getResponses()[0].getFailure().getFailure()).getIndex().getName(),
import org.opensearch.action.get.MultiGetResponse;
 *
        assertThat(mgetResponse.getResponses()[0].getIndex(), is("nonExistingIndex"));
            jsonBuilder().startObject()  
    public SimpleMgetIT(Settings staticSettings) {  
 *  
        final String id = routingKeyForShard("test", 0);  
        return randomBoolean() ? "test" : "alias";
            } else {  
            is("nonExistingIndex")
        );
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .array("field", "1", "2")
 * You may obtain a copy of the License at  
    }
            prepareCreate("test").addAlias(new Alias("alias1").routing("abc"))  
                assertThat(responseItem.getResponse().getSourceAsBytes(), nullValue());
 * software distributed under the License is distributed on an
                    )
        assertThat(mgetResponse.getResponses()[1].getFailure().getMessage(), containsString("more than one index"));
        assertThat(mgetResponse.getResponses().length, is(1));
        assertThat(mgetResponse.getResponses().length, is(2));  
            .setRouting(routingOtherShard)  
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(true));
 * KIND, either express or implied.  See the License for the
        assertThat(
        );
                .field("hidden_field", "should not be seen")
        assertAcked(prepareCreate("test").addAlias(new Alias("multiIndexAlias")));
    public void testThatRoutingPerDocumentIsSupported() throws Exception {
                .endObject()
            .setId("1")  
        assertThat(mgetResponse.getResponses().length, is(1));  
            }
 * under the License.  
    }
        for (int i = 0; i < 100; i++) {
                    Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(2, DEFAULT_MAX_NUM_SHARDS))
 * compatible open source license.
import java.util.Map;
        assertThat(mgetResponse.getResponses()[1].isFailed(), is(true));
public class SimpleMgetIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
/*  
        assertThat(  
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(true));  
        MultiGetResponse mgetResponse = client().prepareMultiGet()
        mgetResponse = client().prepareMultiGet().add(new MultiGetRequest.Item("nonExistingIndex", "1")).get();
                request.add(
    public void testThatMgetShouldWorkWithMultiIndexAlias() throws IOException {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .get();
import org.opensearch.action.get.MultiGetItemResponse;
                .field("excluded", "should not be seen")  
import org.opensearch.core.common.bytes.BytesReference;
                request.add(
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("multiIndexAlias"));
        createIndex("test");
                        new FetchSourceContext(true, new String[] { "included" }, new String[] { "*.hidden_field" })  
        assertThat(mgetResponse.getResponses()[0].getIndex(), is("test"));  
    }
        }
 * GitHub history for details.
            }  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource(sourceBytesRef, MediaTypeRegistry.JSON).get();
            if (i % 2 == 0) {  
    }  
        assertAcked(
            if (i % 2 == 0) {
            .get();
/*
            .setId(id)
            is("nonExistingIndex")  
        );
            .add(new MultiGetRequest.Item(indexOrAlias(), id))  
import static org.hamcrest.Matchers.containsString;
import java.util.Collection;  
 * specific language governing permissions and limitations
    public void testThatMgetShouldWorkWithOneIndexMissing() throws IOException {  
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(false));
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
            assertThat(responseItem.getIndex(), equalTo("test"));  
        assertThat(mgetResponse.getResponses()[0].getIndex(), is("test"));
                .startObject("included")
        MultiGetRequestBuilder request = client().prepareMultiGet();
            .add(new MultiGetRequest.Item(indexOrAlias(), id).routing(routingOtherShard))
 * not use this file except in compliance with the License.
                )  
            .setId("1")
        assertThat(mgetResponse.getResponses()[0].getResponse().getIndex(), is("test"));  
 */  
        assertEquals("test", mgetResponse.getResponses()[0].getIndex());
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
    }
        assertAcked(
                .endObject()
                .setSettings(
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * ownership. Elasticsearch licenses this file to you under  
    public void testThatMgetShouldWorkWithAliasRouting() throws IOException {
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.indices.alias.Alias;
        assertThat(mgetResponse.getResponses()[1].isFailed(), is(false));
        MultiGetResponse mgetResponse = client().prepareMultiGet()  
import org.opensearch.action.get.MultiGetRequestBuilder;
        MultiGetResponse response = request.get();
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
    }
                .field("field", "should be seen")  
        );  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .setId("1")
            .setRefreshPolicy(IMMEDIATE)
        super(staticSettings);
 * Licensed to Elasticsearch under one or more contributor  
            } else {
        assertThat(mgetResponse.getResponses().length, is(2));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(mgetResponse.getResponses()[0].getFailure().getMessage(), containsString("more than one index"));
        assertThat(mgetResponse.getResponses()[0].getIndex(), is("multiIndexAlias"));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        assertThat(mgetResponse.getResponses()[0].getFailure().getMessage(), is("no such index [nonExistingIndex]"));  
                    new MultiGetRequest.Item(indexOrAlias(), Integer.toString(i)).fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
            .setSource(jsonBuilder().startObject().field("foo", "bar").endObject())
            .add(new MultiGetRequest.Item("test", "1"))
            .setRefreshPolicy(IMMEDIATE)
        assertThat(mgetResponse.getResponses()[0].getResponse().isExists(), is(true));
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    public static Collection<Object[]> parameters() {
import java.io.IOException;
            .get();
        }
        return Arrays.asList(  
        assertThat(mgetResponse.getResponses()[1].getFailure().getMessage(), is("no such index [nonExistingIndex]"));
        for (int i = 0; i < 100; i++) {  
        for (int i = 0; i < 100; i++) {
/*  
        client().prepareIndex("test")
            .setRefreshPolicy(IMMEDIATE)
        assertEquals(1, mgetResponse.getResponses().length);
            .get();  
        assertAcked(prepareCreate("test2").addAlias(new Alias("multiIndexAlias")));  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
