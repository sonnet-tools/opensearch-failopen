        }
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
        }
/*  
            builder.indexRouting(randomAlphaOfLengthBetween(3, 10));  
        if (aliases.isEmpty()) {
import java.util.Map;
        AliasMetadata.Builder builder = AliasMetadata.builder(changeAlias ? randomAlphaOfLengthBetween(2, 5) : alias.getAlias());
 * Licensed to Elasticsearch under one or more contributor  
        if (false == changeAlias) {  
                    AliasMetadata aliasMetadata = list.get(aliasIndex);
        if (randomBoolean()) {  
 * this file be licensed under the Apache-2.0 license or a
            if (indicesToBeModified.contains(index)) {  
        final Map<String, List<AliasMetadata>> builder = new HashMap<>();
            }  
        boolean changeAlias = randomBoolean();  
 */
                    int aliasIndex = randomInt(list.size() - 1);
import java.util.HashSet;
 * under the License.  
        List<String> indicesToBeModified = randomSubsetOf(randomIntBetween(1, indices.size()), indices);
        return new GetAliasesResponse(mutateAliases(response.getAliases()));
            indices.add(keys.next());
            final Map<String, List<AliasMetadata>> builder = new HashMap<>(aliases);
            }
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
            if (randomBoolean()) {
    }
        }
                builder.searchRouting(alias.searchRouting() + randomAlphaOfLengthBetween(1, 3));
        return builder;
    }
                    list.add(createAliasMetadata());
            builder.filter("{\"term\":{\"year\":2016}}");  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.opensearch.core.common.io.stream.Writeable;  
            list.forEach((k, v) -> builder.put(k, v));  
            }
        Iterator<String> keys = aliases.keySet().iterator();
            List<AliasMetadata> list = new ArrayList<>(aliases.get(index));
 * Unless required by applicable law or agreed to in writing,
        int indicesNum = randomIntBetween(min, max);
        Builder builder = AliasMetadata.builder(randomAlphaOfLengthBetween(3, 10));
    @Override  
        if (randomBoolean()) {
        builder.indexRouting(alias.indexRouting());  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    private static Map<String, List<AliasMetadata>> mutateAliases(final Map<String, List<AliasMetadata>> aliases) {
 * ownership. Elasticsearch licenses this file to you under  
                    list.add(aliasIndex, mutateAliasMetadata(aliasMetadata));  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        for (int i = 0; i < indicesNum; i++) {  
        return builder;  
            } else {  
import org.opensearch.cluster.metadata.AliasMetadata;
 *
            List<AliasMetadata> aliasMetadata = new ArrayList<>();
    }
    protected GetAliasesResponse mutateInstance(GetAliasesResponse response) {  
    protected GetAliasesResponse createTestInstance() {
 * compatible open source license.
        }
    }
        }
        return GetAliasesResponse::new;
import org.opensearch.test.AbstractWireSerializingTestCase;
 * this work for additional information regarding copyright
            builder.put(index, aliasMetadata);
        }
 * Modifications Copyright OpenSearch Contributors. See
                builder.indexRouting(alias.indexRouting() + randomAlphaOfLengthBetween(1, 3));
        return builder.build();
import java.util.Set;  
            builder.routing(randomAlphaOfLengthBetween(3, 10));  
        while (keys.hasNext()) {  
 */  
    protected Writeable.Reader<GetAliasesResponse> instanceReader() {
        for (String index : indices) {
        }
    private static GetAliasesResponse createTestItem() {
    public static AliasMetadata mutateAliasMetadata(AliasMetadata alias) {
            String index = randomAlphaOfLength(5);
 *
        return createTestItem();  
        final Map<String, List<AliasMetadata>> builder = new HashMap<>();
        return builder.build();
        if (randomBoolean()) {
    }
import java.util.Iterator;  
    public static AliasMetadata createAliasMetadata() {  
        }
        Set<String> indices = new HashSet<>();
import org.opensearch.cluster.metadata.AliasMetadata.Builder;
            builder.searchRouting(randomAlphaOfLengthBetween(3, 10));  
            return builder;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 *  
            int aliasesNum = randomIntBetween(0, 3);  
            return createIndicesAliasesMap(1, 3);  
}  
public class GetAliasesResponseTests extends AbstractWireSerializingTestCase<GetAliasesResponse> {
    @Override
    }  
        if (randomBoolean()) {
                } else {  
/*
 */  
 * software distributed under the License is distributed on an
            builder.put(index, list);  
package org.opensearch.action.admin.indices.alias.get;
        builder.filter(alias.filter());
            final Map<String, List<AliasMetadata>> list = createIndicesAliasesMap(1, 2);
                aliasMetadata.add(createAliasMetadata());
import java.util.List;
        }
        return new GetAliasesResponse(createIndicesAliasesMap(0, 5));  
import java.util.HashMap;
    @Override
                }
    }  
 * GitHub history for details.
            for (int alias = 0; alias < aliasesNum; alias++) {
        builder.searchRouting(alias.searchRouting());
                if (randomBoolean() || list.isEmpty()) {
import java.util.ArrayList;  
    private static Map<String, List<AliasMetadata>> createIndicesAliasesMap(int min, int max) {  
