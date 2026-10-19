        for (int i = 0; i < multiGetShardRequest2.items.size(); i++) {
 * KIND, either express or implied.  See the License for the
        if (randomBoolean()) {  
                FetchSourceContext fetchSourceContext = randomBoolean()
                item.fetchSourceContext(fetchSourceContext);
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }
            if (randomBoolean()) {
            }  
/*
 *  
            multiGetRequest.preference(randomAlphaOfLength(randomIntBetween(1, 10)));
 * SPDX-License-Identifier: Apache-2.0
                }  
            MultiGetRequest.Item item = multiGetShardRequest.items.get(i);
 */  
}
        in.setVersion(out.getVersion());  
        assertThat(multiGetShardRequest2.indicesOptions(), equalTo(multiGetShardRequest.indicesOptions()));  
            assertThat(item2.versionType(), equalTo(item.versionType()));
    }
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        assertThat(multiGetShardRequest2.indices(), equalTo(multiGetShardRequest.indices()));
            }
        BytesStreamOutput out = new BytesStreamOutput();
 * compatible open source license.
 */
 *
import static org.hamcrest.CoreMatchers.equalTo;
public class MultiGetShardRequestTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
                item.storedFields(fields);
        multiGetShardRequest.writeTo(out);  
                    : FetchSourceContext.DO_NOT_FETCH_SOURCE;
            MultiGetRequest.Item item = new MultiGetRequest.Item("alias-" + randomAlphaOfLength(randomIntBetween(1, 10)), "id-" + i);  
        assertThat(multiGetShardRequest2.items.size(), equalTo(multiGetShardRequest.items.size()));  
 * The OpenSearch Contributors require contributions made to  
                    ? FetchSourceContext.FETCH_SOURCE  
        if (randomBoolean()) {  
 *
import static org.opensearch.test.VersionUtils.randomVersion;  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.io.stream.BytesStreamOutput;
                int numFields = randomIntBetween(1, 5);
package org.opensearch.action.get;
        }
 * license agreements. See the NOTICE file distributed with
            if (randomBoolean()) {
            assertThat(item2.version(), equalTo(item.version()));
/*  
 * You may obtain a copy of the License at  
        MultiGetShardRequest multiGetShardRequest2 = new MultiGetShardRequest(in);
            assertThat(item2.id(), equalTo(item.id()));
            multiGetRequest.realtime(false);
            multiGetRequest.refresh(true);
 * GitHub history for details.
        assertThat(multiGetShardRequest2.preference(), equalTo(multiGetShardRequest.preference()));  
            if (randomBoolean()) {  
        StreamInput in = out.bytes().streamInput();
import org.opensearch.index.VersionType;  
 * this file be licensed under the Apache-2.0 license or a
            MultiGetRequest.Item item2 = multiGetShardRequest2.items.get(i);  
        int numItems = iterations(10, 30);
            assertThat(item2.index(), equalTo(item.index()));
                String[] fields = new String[numFields];  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 */  
            assertThat(item2.fetchSourceContext(), equalTo(item.fetchSourceContext()));  
                    fields[j] = randomAlphaOfLength(randomIntBetween(1, 10));
        MultiGetShardRequest multiGetShardRequest = new MultiGetShardRequest(multiGetRequest, "index", 0);  
 * Unless required by applicable law or agreed to in writing,
                item.versionType(randomFrom(VersionType.values()));
/*  
        assertThat(multiGetShardRequest2.realtime(), equalTo(multiGetShardRequest.realtime()));
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(item2.storedFields(), equalTo(item.storedFields()));  
        assertThat(multiGetShardRequest2.refresh(), equalTo(multiGetShardRequest.refresh()));
        if (randomBoolean()) {  
        for (int i = 0; i < numItems; i++) {
 * this work for additional information regarding copyright
    public void testSerialization() throws IOException {
            multiGetShardRequest.add(0, item);
        out.setVersion(randomVersion(random()));
        }
            }  
 * under the License.  
                item.version(randomIntBetween(1, Integer.MAX_VALUE));
                for (int j = 0; j < fields.length; j++) {
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        assertThat(multiGetShardRequest2.index(), equalTo(multiGetShardRequest.index()));
 * ownership. Elasticsearch licenses this file to you under  
