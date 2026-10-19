        XContentParser parser = MediaTypeRegistry.JSON.xContent()
        processed.clusterManagerNodeTimeout(original.clusterManagerNodeTimeout());
 */
        CreateSnapshotRequest original = new CreateSnapshotRequest(repo, snap);
            ActionRequestValidationException validationException = createSnapshotRequestWithMetadata(tooBigOnlyIfNestedFieldsAreIncluded)
            assertNull(createSnapshotRequestWithMetadata(complex).validate());
            Collection<Option> options = randomSubsetOf(Arrays.asList(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE));
        }
 * The OpenSearch Contributors require contributions made to
            assertThat(validationException.validationErrors().get(0), equalTo("metadata must be smaller than 1024 bytes, but was [1025]"));
    }
            tooBigOnlyIfNestedFieldsAreIncluded.put(randomAlphaOfLength(11), nested);
import org.opensearch.test.OpenSearchTestCase;
            HashMap<Object, Object> nested = new HashMap<>();
        {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            complex.put(randomAlphaOfLength(7), nested);
                settings.put(randomAlphaOfLength(randomInt(3) + 2), randomAlphaOfLength(randomInt(3) + 2));
        processed.source(map);
        {
public class CreateSnapshotRequestTests extends OpenSearchTestCase {
            Collection<WildcardStates> wildcardStates = randomSubsetOf(Arrays.asList(WildcardStates.values()));
                indices.add(randomAlphaOfLength(randomInt(3) + 2));
        }
        assertEquals(original, processed);
        }
        String snap = randomAlphaOfLength(10);
 */
            barelyTooBig.put(randomAlphaOfLength(512), randomAlphaOfLength(506));
import java.util.Collections;
        if (randomBoolean()) {
                    wildcardStates.isEmpty() ? WildcardStates.NONE : EnumSet.copyOf(wildcardStates)
                )
    public void testToXContent() throws IOException {
        }
 *
            original.settings(settings);
            tooBigOnlyIfNestedFieldsAreIncluded.put(randomAlphaOfLength(10), randomAlphaOfLength(10));
            .settings(Settings.EMPTY)
import java.util.Arrays;
 *
    }
            assertNotNull(validationException);
            simple.put(randomAlphaOfLength(5), randomAlphaOfLength(25));
            original.includeGlobalState(randomBoolean());
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.ToXContent.MapParams;
        }
        Map<String, Object> map = parser.mapOrdered();
import org.opensearch.action.support.IndicesOptions.Option;
            nested.put(randomAlphaOfLength(500), randomAlphaOfLength(500));
        return new CreateSnapshotRequest(randomAlphaOfLength(5), randomAlphaOfLength(5)).indices(randomAlphaOfLength(5))
            nested.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
        }
            barelyFine.put(randomAlphaOfLength(512), randomAlphaOfLength(505));
        }
import static org.hamcrest.Matchers.equalTo;
        if (randomBoolean()) {
        if (randomBoolean()) {
import org.opensearch.action.ActionRequestValidationException;
 * software distributed under the License is distributed on an
    }
import java.io.IOException;
            original.partial(randomBoolean());
import java.util.Collection;
            original.clusterManagerNodeTimeout("60s");
            assertThat(validationException.validationErrors(), hasSize(1));
        if (randomBoolean()) {
/*
            for (int i = 0; i < count; ++i) {
            for (int i = 0; i < count; ++i) {
    private CreateSnapshotRequest createSnapshotRequestWithMetadata(Map<String, Object> metadata) {
 * under the License.
            int count = randomInt(3) + 1;
 * GitHub history for details.
}
        XContentBuilder builder = original.toXContent(XContentFactory.jsonBuilder(), new MapParams(Collections.emptyMap()));
        if (randomBoolean()) {
    public void testSizeCheck() {
            .createParser(NamedXContentRegistry.EMPTY, null, BytesReference.bytes(builder).streamInput());
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
            original.indicesOptions(
        }
        }
        if (randomBoolean()) {
import static org.opensearch.snapshots.SnapshotInfoTests.randomUserMetadata;
            nested.put(randomAlphaOfLength(6), randomAlphaOfLength(5));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.bytes.BytesReference;
/*
            int count = randomInt(3) + 1;
            List<String> indices = new ArrayList<>();
            assertNotNull(validationException);
            original.indices(indices);
            Map<String, Object> barelyFine = new HashMap<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        if (randomBoolean()) {
            original.waitForCompletion(randomBoolean());
            Map<String, Object> simple = new HashMap<>();
import java.util.ArrayList;
 * specific language governing permissions and limitations
            Map<String, Object> nested = new HashMap<>();
            Map<String, Object> settings = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
                .validate();
import org.opensearch.core.xcontent.XContentBuilder;
            assertNull(createSnapshotRequestWithMetadata(simple).validate());
import java.util.HashMap;
import static org.hamcrest.Matchers.hasSize;
 * this work for additional information regarding copyright
        processed.waitForCompletion(original.waitForCompletion());
        CreateSnapshotRequest processed = new CreateSnapshotRequest((String) map.get("repository"), (String) map.get("snapshot"));
            original.userMetadata(randomUserMetadata());
 * SPDX-License-Identifier: Apache-2.0
            assertThat(validationException.validationErrors().get(0), equalTo("metadata must be smaller than 1024 bytes, but was [1049]"));
import org.opensearch.common.xcontent.XContentFactory;
            Map<String, Object> complex = new HashMap<>();
            }
        {
    // tests creating XContent and parsing with source(Map) equivalency
            ActionRequestValidationException validationException = createSnapshotRequestWithMetadata(barelyTooBig).validate();
 * ownership. Elasticsearch licenses this file to you under
            Map<String, Object> tooBigOnlyIfNestedFieldsAreIncluded = new HashMap<>();
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.IndicesOptions;
/*
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        {
        String repo = randomAlphaOfLength(5);
import java.util.EnumSet;
 * Modifications Copyright OpenSearch Contributors. See
        }
                    options.isEmpty() ? Option.NONE : EnumSet.copyOf(options),
        }
import org.opensearch.action.support.IndicesOptions.WildcardStates;
import java.util.Map;
package org.opensearch.action.admin.cluster.snapshots.create;
        }
 * You may obtain a copy of the License at
            assertNull(createSnapshotRequestWithMetadata(barelyFine).validate());
            .userMetadata(metadata);
 *
 */
            Map<String, Object> barelyTooBig = new HashMap<>();
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
        {
        if (randomBoolean()) {
            assertThat(validationException.validationErrors(), hasSize(1));
import org.opensearch.common.settings.Settings;
 * compatible open source license.
            );
                new IndicesOptions(
