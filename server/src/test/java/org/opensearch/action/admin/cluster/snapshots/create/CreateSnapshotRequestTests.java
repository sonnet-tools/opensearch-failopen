import org.opensearch.core.xcontent.XContentBuilder;
        return new CreateSnapshotRequest(randomAlphaOfLength(5), randomAlphaOfLength(5)).indices(randomAlphaOfLength(5))
            .settings(Settings.EMPTY)
        {  
        {  
 * not use this file except in compliance with the License.
                    options.isEmpty() ? Option.NONE : EnumSet.copyOf(options),  
import java.util.ArrayList;
                .validate();
            barelyTooBig.put(randomAlphaOfLength(512), randomAlphaOfLength(506));
        }
        {  
import org.opensearch.core.xcontent.XContentParser;  
            Map<String, Object> barelyFine = new HashMap<>();
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor  
            original.includeGlobalState(randomBoolean());
 */  
                new IndicesOptions(
 * KIND, either express or implied.  See the License for the
                )
            assertThat(validationException.validationErrors().get(0), equalTo("metadata must be smaller than 1024 bytes, but was [1025]"));  
            barelyFine.put(randomAlphaOfLength(512), randomAlphaOfLength(505));
        processed.clusterManagerNodeTimeout(original.clusterManagerNodeTimeout());
            original.clusterManagerNodeTimeout("60s");
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Map<String, Object> map = parser.mapOrdered();
            tooBigOnlyIfNestedFieldsAreIncluded.put(randomAlphaOfLength(11), nested);
            assertThat(validationException.validationErrors().get(0), equalTo("metadata must be smaller than 1024 bytes, but was [1049]"));
import java.util.EnumSet;
            nested.put(randomAlphaOfLength(500), randomAlphaOfLength(500));  
            .userMetadata(metadata);  
import java.util.Collections;
        }
}
        XContentParser parser = MediaTypeRegistry.JSON.xContent()  
 */
            nested.put(randomAlphaOfLength(5), randomAlphaOfLength(5));  
 *
        if (randomBoolean()) {
            original.userMetadata(randomUserMetadata());  
 * specific language governing permissions and limitations
        assertEquals(original, processed);
                settings.put(randomAlphaOfLength(randomInt(3) + 2), randomAlphaOfLength(randomInt(3) + 2));
            for (int i = 0; i < count; ++i) {  
        if (randomBoolean()) {  
public class CreateSnapshotRequestTests extends OpenSearchTestCase {
            HashMap<Object, Object> nested = new HashMap<>();
            original.settings(settings);
    // tests creating XContent and parsing with source(Map) equivalency
    }
 * GitHub history for details.
            assertNull(createSnapshotRequestWithMetadata(simple).validate());  
    public void testSizeCheck() {
import org.opensearch.action.support.IndicesOptions.Option;  
            int count = randomInt(3) + 1;
 * You may obtain a copy of the License at  
    }  
/*  
        CreateSnapshotRequest original = new CreateSnapshotRequest(repo, snap);  
import org.opensearch.common.xcontent.XContentFactory;  
        {  
            }
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            Map<String, Object> settings = new HashMap<>();  
 * Modifications Copyright OpenSearch Contributors. See
        }
            Map<String, Object> complex = new HashMap<>();
            assertNull(createSnapshotRequestWithMetadata(barelyFine).validate());  
import java.util.Map;
            tooBigOnlyIfNestedFieldsAreIncluded.put(randomAlphaOfLength(10), randomAlphaOfLength(10));
            ActionRequestValidationException validationException = createSnapshotRequestWithMetadata(tooBigOnlyIfNestedFieldsAreIncluded)
            assertNull(createSnapshotRequestWithMetadata(complex).validate());  
 */  
            Map<String, Object> barelyTooBig = new HashMap<>();
import static org.hamcrest.Matchers.equalTo;
/*
            assertNotNull(validationException);  
            assertThat(validationException.validationErrors(), hasSize(1));
        if (randomBoolean()) {
            List<String> indices = new ArrayList<>();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Map<String, Object> simple = new HashMap<>();
        processed.source(map);  
 * ownership. Elasticsearch licenses this file to you under  
            }
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * compatible open source license.
        if (randomBoolean()) {
            Collection<Option> options = randomSubsetOf(Arrays.asList(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE));
import java.util.Arrays;
            simple.put(randomAlphaOfLength(5), randomAlphaOfLength(25));
        }  
import org.opensearch.action.support.IndicesOptions;
                    wildcardStates.isEmpty() ? WildcardStates.NONE : EnumSet.copyOf(wildcardStates)
            original.waitForCompletion(randomBoolean());
        if (randomBoolean()) {
            ActionRequestValidationException validationException = createSnapshotRequestWithMetadata(barelyTooBig).validate();  
            original.partial(randomBoolean());
/*  
 * software distributed under the License is distributed on an
        XContentBuilder builder = original.toXContent(XContentFactory.jsonBuilder(), new MapParams(Collections.emptyMap()));
            nested.put(randomAlphaOfLength(6), randomAlphaOfLength(5));
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.HashMap;  
 *  
    }
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
        }  
        }
            assertNotNull(validationException);
            for (int i = 0; i < count; ++i) {  
        processed.waitForCompletion(original.waitForCompletion());
    public void testToXContent() throws IOException {
            original.indicesOptions(
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.snapshots.SnapshotInfoTests.randomUserMetadata;
 * this work for additional information regarding copyright
            Map<String, Object> nested = new HashMap<>();
            assertThat(validationException.validationErrors(), hasSize(1));
            complex.put(randomAlphaOfLength(7), nested);
        }
        if (randomBoolean()) {  
            Map<String, Object> tooBigOnlyIfNestedFieldsAreIncluded = new HashMap<>();
import java.util.Collection;  
import java.io.IOException;  
                indices.add(randomAlphaOfLength(randomInt(3) + 2));
        if (randomBoolean()) {
            );  
        }
        CreateSnapshotRequest processed = new CreateSnapshotRequest((String) map.get("repository"), (String) map.get("snapshot"));  
        String snap = randomAlphaOfLength(10);
        String repo = randomAlphaOfLength(5);  
            .createParser(NamedXContentRegistry.EMPTY, null, BytesReference.bytes(builder).streamInput());
            int count = randomInt(3) + 1;
    private CreateSnapshotRequest createSnapshotRequestWithMetadata(Map<String, Object> metadata) {  
            original.indices(indices);
import static org.hamcrest.Matchers.hasSize;  
import org.opensearch.action.support.IndicesOptions.WildcardStates;
        if (randomBoolean()) {
        {  
import org.opensearch.test.OpenSearchTestCase;
            Collection<WildcardStates> wildcardStates = randomSubsetOf(Arrays.asList(WildcardStates.values()));
import org.opensearch.core.common.bytes.BytesReference;
        }
import org.opensearch.core.xcontent.ToXContent.MapParams;
import org.opensearch.action.ActionRequestValidationException;
package org.opensearch.action.admin.cluster.snapshots.create;
        }  
