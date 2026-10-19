    }
import java.util.Collection;  
        processed.source(map);
            for (int i = 0; i < count; ++i) {
import java.util.Collections;
            Map<String, Object> indexSettings = new HashMap<>();
 *
 * ownership. Elasticsearch licenses this file to you under  
                    wildcardStates.isEmpty() ? IndicesOptions.WildcardStates.NONE : EnumSet.copyOf(wildcardStates)  
        if (randomBoolean()) {
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
    @Override  
        copy.repository("copied-" + instance.repository());  
        // REST path and request parameters).
            int count = randomInt(3) + 1;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
        }  
/*  
        processed.waitForCompletion(original.waitForCompletion());
            instance.renamePattern(randomUnicodeOfLengthBetween(1, 100));
            instance.indexSettings(indexSettings);
import java.util.HashMap;  
import java.util.Arrays;
 * software distributed under the License is distributed on an
        RestoreSnapshotRequest original = createTestInstance();
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
                indices.add(randomAlphaOfLength(randomInt(3) + 2));
        if (randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor  
            instance.setSourceRemoteStoreRepository(randomAlphaOfLengthBetween(5, 10));
 * this file be licensed under the Apache-2.0 license or a
 */
    @Override
    private RestoreSnapshotRequest randomState(RestoreSnapshotRequest instance) {
            );
            }
 */  
        }  
            instance.clusterManagerNodeTimeout(randomTimeValue());
        return randomState(copy);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.bytes.BytesReference;  
        processed.clusterManagerNodeTimeout(original.clusterManagerNodeTimeout());
        // properties are restored from the original (in the actual REST action this is restored from the
                Arrays.asList(IndicesOptions.Option.ALLOW_NO_INDICES, IndicesOptions.Option.IGNORE_UNAVAILABLE)  
        );
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Map;
            instance.renameAliasReplacement(randomUnicodeOfLengthBetween(1, 100));
        if (randomBoolean()) {
                new IndicesOptions(
            Collection<IndicesOptions.WildcardStates> wildcardStates = randomSubsetOf(
            List<String> indices = new ArrayList<>();
        instance.storageType(  
        return randomState(new RestoreSnapshotRequest(randomAlphaOfLength(5), randomAlphaOfLength(10)));  
        if (randomBoolean()) {
    }  
            .createParser(NamedXContentRegistry.EMPTY, null, BytesReference.bytes(builder).streamInput());  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.io.IOException;  
        return RestoreSnapshotRequest::new;
 * this work for additional information regarding copyright
            for (int i = 0; i < count; ++i) {
        XContentParser parser = MediaTypeRegistry.JSON.xContent()
        // ensure that at least one property is different
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.AbstractWireSerializingTestCase;
import org.opensearch.core.xcontent.ToXContent;
 * not use this file except in compliance with the License.
        instance.includeGlobalState(randomBoolean());
        instance.attachToDataStream(randomBoolean());
}
 * KIND, either express or implied.  See the License for the
            instance.snapshotUuid(randomBoolean() ? null : randomAlphaOfLength(10));  
 * under the License.  
        }  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * Modifications Copyright OpenSearch Contributors. See
    }
        if (randomBoolean()) {
        XContentBuilder builder = original.toXContent(XContentFactory.jsonBuilder(), new ToXContent.MapParams(Collections.emptyMap()));
import org.opensearch.common.xcontent.XContentFactory;
            instance.renameReplacement(randomUnicodeOfLengthBetween(1, 100));
 */  
        return instance;
 *
            randomBoolean() ? RestoreSnapshotRequest.StorageType.LOCAL : RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT
 *  
            }  
        original.snapshotUuid(null); // cannot be set via the REST API  
        }  
        if (randomBoolean()) {
        if (randomBoolean()) {
        RestoreSnapshotRequest processed = new RestoreSnapshotRequest(original.repository(), original.snapshot());  
                )
        instance.partial(randomBoolean());
        // we will only restore properties from the map that are contained in the request body. All other  
            Collection<IndicesOptions.Option> options = randomSubsetOf(
    }
            instance.indices(indices);
        }  
        if (randomBoolean()) {
        instance.waitForCompletion(randomBoolean());
        }  
import org.opensearch.core.xcontent.XContentBuilder;
            instance.renameAliasPattern(randomUnicodeOfLengthBetween(1, 100));
        Map<String, Object> map = parser.mapOrdered();
/*  
                indexSettings.put(randomAlphaOfLengthBetween(2, 5), randomAlphaOfLengthBetween(2, 5));  
import java.util.List;
import org.opensearch.action.support.IndicesOptions;
        RestoreSnapshotRequest copy = copyInstance(instance);
    }
        }  
    public void testSource() throws IOException {
        }  
 * specific language governing permissions and limitations
/*
        if (randomBoolean()) {  
    protected RestoreSnapshotRequest createTestInstance() {
package org.opensearch.action.admin.cluster.snapshots.restore;
    protected Writeable.Reader<RestoreSnapshotRequest> instanceReader() {
            instance.indicesOptions(  
    protected RestoreSnapshotRequest mutateInstance(RestoreSnapshotRequest instance) throws IOException {  
    @Override
                Arrays.asList(IndicesOptions.WildcardStates.values())  
public class RestoreSnapshotRequestTests extends AbstractWireSerializingTestCase<RestoreSnapshotRequest> {
        }
        instance.includeAliases(randomBoolean());
            int count = randomInt(3) + 1;
import java.util.EnumSet;
        if (randomBoolean()) {
        assertEquals(original, processed);  
        }  
                    options.isEmpty() ? IndicesOptions.Option.NONE : EnumSet.copyOf(options),
 * the Apache License, Version 2.0 (the "License"); you may
            );
import org.opensearch.core.xcontent.XContentParser;  
import java.util.ArrayList;
 * compatible open source license.
