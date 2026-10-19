        }
 * this file be licensed under the Apache-2.0 license or a
        builder.startObject();
    /**
import org.opensearch.action.admin.indices.alias.Alias;
 * under the License.  
        if (randomBoolean()) {
    /**  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return request;  
 *
/*
        }
    public static XContentBuilder randomMapping() throws IOException {  
        randomAliases(request);
        while (uniqueFields.size() < fieldsNo) {  
        for (int i = 0; i < aliasesNo; i++) {
                alias.routing(randomAlphaOfLength(5));  
                builder.field("type", "text");  
            }
 */  
/*  
 * software distributed under the License is distributed on an
            int numberOfShards = randomIntBetween(1, 10);  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index;
    }
        }
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
    private RandomCreateIndexGenerator() {}  
            } else {
        if (randomBoolean()) {
        for (String uniqueField : uniqueFields) {  
        if (randomBoolean()) {  
        int aliasesNo = randomIntBetween(0, 2);
        Settings.Builder builder = Settings.builder();  
            request.mapping(randomMapping());
        }  
    }
 * specific language governing permissions and limitations
        return builder.build();  
        String index = randomAlphaOfLength(5);  
                randomMappingFields(builder, false);
        builder.startObject("properties");
                    alias.searchRouting(randomAlphaOfLength(5));  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {  
     * Adds random mapping fields to the provided {@link XContentBuilder}
            builder.endObject();  
                if (randomBoolean()) {
        if (randomBoolean()) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        Set<String> uniqueFields = new HashSet<>();
            request.settings(randomIndexSettings());
     * Sets random aliases to the provided {@link CreateIndexRequest}
 */
     */
        int fieldsNo = randomIntBetween(0, 5);
            request.alias(randomAlias());  
        }
 * compatible open source license.
        return builder;
 * You may obtain a copy of the License at  
     * Returns a random {@link CreateIndexRequest}.  
            }
        builder.endObject();  
    /**  
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
        return alias;
    /**  
 * ownership. Elasticsearch licenses this file to you under  
            if (randomBoolean()) {
     * Randomizes the index name, the aliases, mappings and settings associated with the
    }
            builder.startObject(uniqueField);
/*  
     * {@link org.opensearch.cluster.metadata.IndexMetadata#SETTING_NUMBER_OF_SHARDS} and
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
 * Licensed to Elasticsearch under one or more contributor  
    }
        if (randomBoolean()) {
public final class RandomCreateIndexGenerator {
        CreateIndexRequest request = new CreateIndexRequest(index);
                }
            alias.writeIndex(randomBoolean());
            alias.filter("{\"term\":{\"year\":2016}}");  
import java.util.HashSet;  
import java.io.IOException;
     * Creates a random mapping
 * Modifications Copyright OpenSearch Contributors. See
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
        if (randomBoolean()) {
        }
        builder.endObject();  
     * <p>
    public static CreateIndexRequest randomCreateIndexRequest() throws IOException {
import org.opensearch.common.settings.Settings;  
        }
import org.opensearch.core.xcontent.XContentBuilder;  
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;  
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;
 * this work for additional information regarding copyright
}  
 *  
            builder.put(SETTING_NUMBER_OF_SHARDS, numberOfShards);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
     */
    public static void randomAliases(CreateIndexRequest request) {  
import org.opensearch.common.xcontent.XContentType;
     */
            uniqueFields.add(randomAlphaOfLength(5));
                    alias.indexRouting(randomAlphaOfLength(5));  
        }
        randomMappingFields(builder, true);
        }
        }
    public static Alias randomAlias() {
 * The OpenSearch Contributors require contributions made to  
    public static Settings randomIndexSettings() {
     * Returns a {@link Settings} instance which include random values for
    }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
import java.util.Set;
    public static void randomMappingFields(XContentBuilder builder, boolean allowObjectField) throws IOException {
                if (randomBoolean()) {
     * {@link org.opensearch.cluster.metadata.IndexMetadata#SETTING_NUMBER_OF_REPLICAS}  
                }
            if (allowObjectField && randomBoolean()) {  
     */  
            int numberOfReplicas = randomIntBetween(1, 10);
        Alias alias = new Alias(randomAlphaOfLength(5));
     */
 * GitHub history for details.
            builder.put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas);  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
            } else {
     * index. If present, the mapping definition will be nested under a type name.  
 *
