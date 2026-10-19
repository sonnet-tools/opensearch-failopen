        ClusterUpdateSettingsResponse original = createTestInstance();
    }  
            return randomClusterSettings(1, 3);  
        }
                );
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                    response.transientSettings,
 * You may obtain a copy of the License at  
import java.util.function.Predicate;
    @Override  
        return ClusterUpdateSettingsResponse::new;
 */  
 *
}
public class ClusterUpdateSettingsResponseTests extends AbstractSerializingTestCase<ClusterUpdateSettingsResponse> {  
                    response.transientSettings,
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;  
        for (String key : allKeys) {
                    response.persistentSettings  
package org.opensearch.action.admin.cluster.settings;
    }
import java.util.List;
            if (keysToBeModified.contains(key)) {
        Builder builder = Settings.builder();
 */  
            case 1:
                return new ClusterUpdateSettingsResponse(  
    @Override
        Builder builder = Settings.builder();
        }
            default:
                    response.isAcknowledged() == false,
        return builder.build();  
                    response.isAcknowledged(),
        }
            builder.put(key, value);
/*  
            String value = settings.get(key);  
            case 0:
    }
 * ownership. Elasticsearch licenses this file to you under  
                );
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.ClusterSettings;
                    mutateSettings(response.transientSettings),
                    response.isAcknowledged(),
                return new ClusterUpdateSettingsResponse(  
        List<String> keysToBeModified = randomSubsetOf(randomIntBetween(1, allKeys.size()), allKeys);  
                value += randomAlphaOfLengthBetween(2, 5);
 *    http://www.apache.org/licenses/LICENSE-2.0
            Setting<?> setting = randomFrom(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
/*
    protected ClusterUpdateSettingsResponse mutateInstance(ClusterUpdateSettingsResponse response) {
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        assertSerialization(original, VersionUtils.randomIndexCompatibleVersion(random()));  
import org.opensearch.test.VersionUtils;
                    response.persistentSettings  
        int i = randomIntBetween(0, 2);  
    protected Writeable.Reader<ClusterUpdateSettingsResponse> instanceReader() {  
        if (settings.isEmpty()) {
        return ClusterUpdateSettingsResponse.fromXContent(parser);
    private static Settings mutateSettings(Settings settings) {
    }
import org.opensearch.common.settings.Setting;
        for (int i = 0; i < num; i++) {
 */
                throw new UnsupportedOperationException();  
    public void testOldSerialisation() throws IOException {
 * Unless required by applicable law or agreed to in writing,
    }  
import org.opensearch.common.settings.Settings.Builder;
        return builder.build();  
    protected Predicate<String> getRandomFieldsExcludeFilter() {
 * compatible open source license.
 * under the License.  
                );
 *  
    @Override  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
        return new ClusterUpdateSettingsResponse(randomBoolean(), randomClusterSettings(0, 2), randomClusterSettings(0, 2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return p -> p.startsWith("transient") || p.startsWith("persistent");
 * this file be licensed under the Apache-2.0 license or a
/*  
 * KIND, either express or implied.  See the License for the
    protected ClusterUpdateSettingsResponse doParseInstance(XContentParser parser) {  
            }  
import org.opensearch.core.common.io.stream.Writeable;
        }
        switch (i) {
    @Override
    protected ClusterUpdateSettingsResponse createTestInstance() {
import org.opensearch.core.xcontent.XContentParser;  
 *
 * Licensed to Elasticsearch under one or more contributor  
    public static Settings randomClusterSettings(int min, int max) {
            builder.put(setting.getKey(), randomAlphaOfLengthBetween(2, 10));
    }
                    mutateSettings(response.persistentSettings)  
        int num = randomIntBetween(min, max);  
    @Override
            case 2:
import java.io.IOException;
import java.util.Set;  
import org.opensearch.test.AbstractSerializingTestCase;
 * Modifications Copyright OpenSearch Contributors. See
        Set<String> allKeys = settings.keySet();
    }
                return new ClusterUpdateSettingsResponse(  
