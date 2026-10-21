                assertThat(responseItem.getResponse().getSourceAsBytes(), nullValue());
import java.io.IOException;
        );
 * software distributed under the License is distributed on an
        );
            }
            .setRefreshPolicy(IMMEDIATE)
        for (int i = 0; i < 100; i++) {
        assertThat(mgetResponse.getResponses().length, is(2));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(mgetResponse.getResponses()[1].getFailure().getMessage(), is("no such index [nonExistingIndex]"));
        assertThat(mgetResponse.getResponses()[0].getIndex(), is("nonExistingIndex"));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(mgetResponse.getResponses()[0].getIndex(), is("test"));
    public SimpleMgetIT(Settings staticSettings) {
 * not use this file except in compliance with the License.
        assertThat(mgetResponse.getResponses().length, is(1));
    public void testThatMgetShouldWorkWithMultiIndexAlias() throws IOException {
            .setSource(jsonBuilder().startObject().field("foo", "bar").endObject())
        assertThat(mgetResponse.getResponses()[0].getFailure().getMessage(), is("no such index [nonExistingIndex]"));
        );
        client().prepareIndex("test")
                .endObject()
        return Arrays.asList(
 * SPDX-License-Identifier: Apache-2.0
            .setRefreshPolicy(IMMEDIATE)
    }
            assertThat(responseItem.getIndex(), equalTo("test"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(response.getResponses().length, equalTo(100));
 * Unless required by applicable law or agreed to in writing,
        mgetResponse = client().prepareMultiGet().add(new MultiGetRequest.Item("multiIndexAlias", "1")).get();
            .add(new MultiGetRequest.Item(indexOrAlias(), id))
            .get();
            if (i % 2 == 0) {
            } else {
            .add(new MultiGetRequest.Item("multiIndexAlias", "1"))
        assertThat(
            .setId(id)
        client().prepareIndex("test")
    public void testThatMgetShouldWorkWithOneIndexMissing() throws IOException {
                assertThat(source.size(), equalTo(1));
                request.add(
 *
            .setRefreshPolicy(IMMEDIATE)
        assertThat(
            ((OpenSearchException) mgetResponse.getResponses()[1].getFailure().getFailure()).getIndex().getName(),
 * under the License.
import static org.hamcrest.Matchers.containsString;
            } else {
            .get();
 */
                );
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            prepareCreate("test").addAlias(new Alias("alias1").routing("abc"))
            .setId("1")
        );
        assertAcked(prepareCreate("test2").addAlias(new Alias("multiIndexAlias")));
/*
        assertEquals("test", mgetResponse.getResponses()[0].getIndex());
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(false));
        );
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(false));
import static org.hamcrest.Matchers.hasKey;
            ((OpenSearchException) mgetResponse.getResponses()[0].getFailure().getFailure()).getIndex().getName(),
                assertThat(source, hasKey("included"));
    @ParametersFactory
package org.opensearch.mget;
import org.opensearch.core.common.bytes.BytesReference;
 * You may obtain a copy of the License at
        assertEquals(1, mgetResponse.getResponses().length);
    public void testThatSourceFilteringIsSupported() throws Exception {
 *
        mgetResponse = client().prepareMultiGet().add(new MultiGetRequest.Item("nonExistingIndex", "1")).get();
        MultiGetResponse mgetResponse = client().prepareMultiGet()
                    new MultiGetRequest.Item(indexOrAlias(), Integer.toString(i)).fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
    }
        assertThat(mgetResponse.getResponses()[0].getIndex(), is("multiIndexAlias"));
        }
    public void testThatRoutingPerDocumentIsSupported() throws Exception {
import java.util.Arrays;
            MultiGetItemResponse responseItem = response.getResponses()[i];
        assertThat(mgetResponse.getResponses()[1].getFailure().getMessage(), containsString("more than one index"));
        assertThat(mgetResponse.getResponses().length, is(1));
        }
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
        assertThat(mgetResponse.getResponses().length, is(2));
            .setId("1")
import org.opensearch.OpenSearchException;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(mgetResponse.getResponses()[0].getResponse().getIndex(), is("test"));
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .add(new MultiGetRequest.Item("test", "1"))
                .field("field", "should be seen")
                .endObject()
}
/*
        super(staticSettings);
            .setId("1")
            .add(new MultiGetRequest.Item(indexOrAlias(), id).routing(routingOtherShard))
import static org.hamcrest.Matchers.is;
        assertAcked(
import org.opensearch.action.get.MultiGetItemResponse;
                assertThat(((Map<String, Object>) source.get("included")).size(), equalTo(1));
import java.util.Map;
        assertFalse(mgetResponse.getResponses()[0].isFailed());
        for (int i = 0; i < 100; i++) {
 * The OpenSearch Contributors require contributions made to
            .setSource(jsonBuilder().startObject().field("foo", "bar").endObject())
                        new FetchSourceContext(true, new String[] { "included" }, new String[] { "*.hidden_field" })
            jsonBuilder().startObject()
        assertThat(mgetResponse.getResponses()[1].isFailed(), is(true));
        assertAcked(
        final String id = routingKeyForShard("test", 0);
        client().prepareIndex("test")
            .setRouting(routingOtherShard)
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(true));
import org.opensearch.common.settings.Settings;
            .add(new MultiGetRequest.Item("test", "1"))
    private static String indexOrAlias() {
                Map<String, Object> source = responseItem.getResponse().getSourceAsMap();
        );
                request.add(
    }
        MultiGetRequestBuilder request = client().prepareMultiGet();
                    )
        assertThat(mgetResponse.getResponses()[0].getResponse().isExists(), is(true));
        for (int i = 0; i < 100; i++) {
 */
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(true));
 * compatible open source license.
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertThat(mgetResponse.getResponses()[1].isFailed(), is(true));
import org.opensearch.action.get.MultiGetRequest;
        BytesReference sourceBytesRef = BytesReference.bytes(
        MultiGetResponse mgetResponse = client().prepareMultiGet()
        assertThat(mgetResponse.getResponses()[1].getResponse().getIndex(), is("test"));
            .setSource(jsonBuilder().startObject().field("foo", "bar").endObject())
 * ownership. Elasticsearch licenses this file to you under
            .setRefreshPolicy(IMMEDIATE)
            }
            .get();
 *
        assertThat(mgetResponse.getResponses()[1].getResponse().isExists(), is(false));
    }
            is("nonExistingIndex")
        createIndex("test");
    public static Collection<Object[]> parameters() {
    }
        MultiGetResponse response = request.get();
import org.opensearch.core.xcontent.MediaTypeRegistry;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
                    new MultiGetRequest.Item(indexOrAlias(), Integer.toString(i)).fetchSourceContext(
import org.opensearch.cluster.metadata.IndexMetadata;
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        MultiGetResponse mgetResponse = client().prepareMultiGet().add(new MultiGetRequest.Item("alias1", "1")).get();
            .setSource(jsonBuilder().startObject().field("foo", "bar").endObject())
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("multiIndexAlias"));
            .get();
            is("nonExistingIndex")
        client().prepareIndex("alias1")
import org.opensearch.action.get.MultiGetResponse;
 */
                .field("excluded", "should not be seen")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.action.admin.indices.alias.Alias;
public class SimpleMgetIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * Licensed to Elasticsearch under one or more contributor
        assertAcked(prepareCreate("test").addAlias(new Alias("multiIndexAlias")));
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
        assertThat(mgetResponse.getResponses()[0].getFailure().getMessage(), containsString("more than one index"));
                .setSettings(
        return randomBoolean() ? "test" : "alias";
    }
 * KIND, either express or implied.  See the License for the
                .setMapping(jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
        final String routingOtherShard = routingKeyForShard("test", 1);
                    Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(2, DEFAULT_MAX_NUM_SHARDS))
                .field("hidden_field", "should not be seen")
    @SuppressWarnings("unchecked")
/*
        MultiGetResponse mgetResponse = client().prepareMultiGet()
        assertThat(mgetResponse.getResponses()[0].isFailed(), is(false));
    public void testThatMgetShouldWorkWithAliasRouting() throws IOException {
        assertThat(mgetResponse.getResponses()[1].isFailed(), is(false));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(mgetResponse.getResponses()[0].getIndex(), is("test"));
            .get();
                )
            if (i % 2 == 0) {
                );
            client().prepareIndex("test").setId(Integer.toString(i)).setSource(sourceBytesRef, MediaTypeRegistry.JSON).get();
 * GitHub history for details.
import org.opensearch.action.get.MultiGetRequestBuilder;
import java.util.Collection;
            .get();
import static org.hamcrest.Matchers.nullValue;
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        }
                .array("field", "1", "2")
                assertThat(((Map<String, Object>) source.get("included")), hasKey("field"));
                .startObject("included")
        assertThat(mgetResponse.getResponses().length, is(2));
            prepareCreate("test").addAlias(new Alias("alias"))
            .get();
