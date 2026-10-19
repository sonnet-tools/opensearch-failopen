import java.util.HashMap;
            }
 *
            ".ds-logs-mysql-prod-000002",
        validateIndices(
        validateAliases(aliases, "logs-pgsql-prod", "logs-pgsql-test", "one-off-alias");
import static org.hamcrest.Matchers.equalTo;
        if ((boolean) indexInfo[2]) {
        { "logs-pgsql-test-20200102", false, false, false, null, new String[] { "logs-pgsql-test" } },  
        Instant now = Instant.now(Clock.systemUTC());
        assertThat(resolvedIndices.get(0), oneOf("logs-pgsql-prod-" + todaySuffix, "logs-pgsql-prod-" + tomorrowSuffix));
        List<ResolvedIndex> indices = new ArrayList<>();
import org.opensearch.cluster.metadata.AliasMetadata;
            .numberOfShards(1)
            assertThat(aliasIndices, notNullValue());  
                    aliasToIndicesMap.put(alias, indicesSet);  
                backingIndices.add(createIndexMetadata(DataStream.getDefaultBackingIndexName(dataStreamName, backingIndexNumber), true));
            { "logs-pgsql-prod-" + tomorrowSuffix, false, true, false, null, Strings.EMPTY_ARRAY } };
        TransportAction.resolveIndices(names, indicesOptions, metadata, resolver, indices, aliases, dataStreams, true);  
        IndicesOptions indicesOptions = Request.DEFAULT_INDICES_OPTIONS;
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(resolvedAliases.size(), equalTo(expectedAliases.length));  
            assertThat(resolvedIndex.getAttributes(), is(flagsToAttributes(indexInfo)));  
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder(name)
        if ((boolean) indexInfo[3]) {
            assertThat(indexInfo, notNullValue());  
            IndicesOptions.LENIENT_EXPAND_OPEN,
    static Metadata buildMetadata(Object[][] dataStreams, Object[][] indices) {  
import java.util.ArrayList;
 * this work for additional information regarding copyright
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedDataStream;
        List<ResolvedAlias> aliases = new ArrayList<>();  
            String[] aliases = (String[]) indexInfo[5];  
 * compatible open source license.
        { "logs-pgsql-test-20200103", false, false, false, null, new String[] { "logs-pgsql-test" } } };
    }
            .numberOfReplicas(1);  
            singletonList(requestedIndex),
        assertThat(resolvedIndices.size(), equalTo(expectedIndices.length));
            List<IndexMetadata> backingIndices = new ArrayList<>();
            attributes.add("hidden");  
        for (String alias : aliases) {
        IndicesOptions indicesOptions = IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN;
        String requestedIndex = "<logs-pgsql-prod-{now/d}>";
        IndicesOptions indicesOptions = IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN;  
import org.opensearch.common.util.concurrent.ThreadContext;
import static java.util.Collections.singletonList;  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
            allIndices.add(createIndexMetadata(indexName, aliases, closed, hidden, frozen));
            "logs-pgsql-prod-20200103",
                        DataStream.getDefaultBackingIndexName(dataStreamName, k),
            int generations = (int) info[2];
        Object[][] indices = new Object[][] {
        // set up with today's index and following day's index to avoid test failures due to execution time  
import java.util.List;  
                }
        { "logs-mysql-test", "@timestamp", 2 } };  
        List<String> resolvedIndices = resolver.resolveIndexAbstractions(  
/*
            int numBackingIndices = (int) dataStreamInfo[2];  
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
    }
            ResolvedIndex resolvedIndex = resolvedIndices.get(k);
                backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList())
 * SPDX-License-Identifier: Apache-2.0
        }
 * Unless required by applicable law or agreed to in writing,
        );
}
        Metadata.Builder builder = Metadata.builder();
import org.opensearch.core.common.Strings;
        validateIndices(
            String dataStreamName = (String) dsInfo[0];
/*  
            builder.put(index, false);
import java.util.HashSet;
        }
            "logs-pgsql-test-20200103"
            "logs-pgsql-test-20200101",
    private void validateDataStreams(List<ResolvedDataStream> resolvedDataStreams, String... expectedDataStreams) {
    private void validateIndices(List<ResolvedIndex> resolvedIndices, String... expectedIndices) {
import static org.hamcrest.Matchers.is;  
            "logs-pgsql-prod-20200103",  
    public void testResolveStarWithDefaultOptions() {
                return info;
            boolean frozen = (boolean) indexInfo[3];  
 * Licensed to Elasticsearch under one or more contributor  
        IndicesOptions indicesOptions = Request.DEFAULT_INDICES_OPTIONS;  
        for (Object[] indexInfo : indices) {
                        dataStreamName,  
        Map<String, Set<String>> aliasToIndicesMap = new HashMap<>();
            }
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        TransportAction.resolveIndices(names, indicesOptions, metadata, resolver, indices, aliases, dataStreams, true);
            "logs-pgsql-prod-20200102",
            if (indexInfo == null) {  
import java.time.Duration;  
        return null;
            "logs-pgsql-prod-20200102",
            }
        return createIndexMetadata(name, Strings.EMPTY_ARRAY, false, true, false);
 *
            List<String> expectedBackingIndices = new ArrayList<>();
        { "logs-mysql-prod", "@timestamp", 4 },
            ".ds-logs-mysql-prod-000003",  
        validateAliases(aliases, "logs-pgsql-prod", "logs-pgsql-test");
        }
    }  
        { "logs-pgsql-test-20200101", true, false, false, null, new String[] { "logs-pgsql-test" } },
    private void validateAliases(List<ResolvedAlias> resolvedAliases, String... expectedAliases) {
    }
            String[] expectedIndices = aliasIndices.toArray(Strings.EMPTY_ARRAY);
            randomBoolean(),  
        for (Object[] dsInfo : dataStreams) {
import java.time.Instant;
        attributes.add((boolean) indexInfo[1] ? "closed" : "open");
            .put("index.frozen", frozen);  
    }
import static org.hamcrest.core.IsNull.notNullValue;
            attributes.add("frozen");  
            ".ds-logs-mysql-prod-000001",
    private final Object[][] dataStreams = new Object[][] {  
        for (int k = 0; k < resolvedDataStreams.size(); k++) {  
                    return new Object[] {
                        Strings.EMPTY_ARRAY };
        );
        return attributes.toArray(Strings.EMPTY_ARRAY);  
        List<ResolvedAlias> aliases = new ArrayList<>();
        { "logs-pgsql-prod-20200102", false, false, true, null, new String[] { "logs-pgsql-prod", "one-off-alias" } },  
            allIndices.addAll(backingIndices);  
import static org.hamcrest.Matchers.oneOf;
        validateAliases(aliases, "one-off-alias");
        validateDataStreams(dataStreams, Strings.EMPTY_ARRAY);
 * The OpenSearch Contributors require contributions made to  
 */
    public void testResolveWithPattern() {
        List<ResolvedDataStream> dataStreams = new ArrayList<>();
            for (int backingIndexNumber = 1; backingIndexNumber <= numBackingIndices; backingIndexNumber++) {  
    }
            ".ds-logs-mysql-prod-000004",
            assertThat(dataStreamInfo, notNullValue());  
 * the Apache License, Version 2.0 (the "License"); you may
            for (int m = 1; m <= numBackingIndices; m++) {
            "logs-pgsql-test-20200103"  
                indexInfo = findBackingIndexInfo(dataStreams, expectedIndices[k]);
            "logs-pgsql-test-20200102",
        String[] names = new String[] { ".ds-logs-mysql-prod-000003", "logs-pgsql-test-20200102", "one-off-alias", "logs-mysql-test" };
import org.opensearch.common.time.DateFormatter;  
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.IndexAbstractionResolver;
 * under the License.  
            boolean closed = (boolean) indexInfo[1];
            int numBackingIndices = (int) dsInfo[2];
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedAlias;  
import java.time.Clock;
        }
            "logs-pgsql-prod-20200101",
        List<ResolvedAlias> aliases = new ArrayList<>();
package org.opensearch.action.admin.indices.resolve;
        }
                        true,
            ResolvedDataStream resolvedDataStream = resolvedDataStreams.get(k);
 * GitHub history for details.
        assertThat(resolvedDataStreams.size(), equalTo(expectedDataStreams.length));
import org.opensearch.Version;
            .state(closed ? IndexMetadata.State.CLOSE : IndexMetadata.State.OPEN)
        validateAliases(aliases, "logs-pgsql-prod", "logs-pgsql-test", "one-off-alias");  
            true
                        false,
 */  
                    indicesSet = new HashSet<>();
        { "logs-pgsql-prod-20200103", false, false, false, null, new String[] { "logs-pgsql-prod" } },
import org.opensearch.action.support.IndicesOptions;
        List<ResolvedAlias> aliases = new ArrayList<>();
        List<ResolvedIndex> indices = new ArrayList<>();
        for (Object[] indexInfo : indices) {  
    private static IndexMetadata createIndexMetadata(String name, String[] aliases, boolean closed, boolean hidden, boolean frozen) {
            assertThat(resolvedAlias.getIndices(), is(expectedIndices));  
import java.util.Map;
        validateIndices(
        String todaySuffix = dateFormatter.format(now);  
        String[] names = new String[] { "*" };
public class ResolveIndexTests extends OpenSearchTestCase {
        // name, isClosed, isHidden, isFrozen, dataStream, aliases
            asList("logs-pgsql-prod-" + todaySuffix, "logs-pgsql-prod-" + tomorrowSuffix),
            .put("index.hidden", hidden)
import org.opensearch.cluster.metadata.DataStream;  
            Arrays.sort(expectedIndices);
        }
                createTimestampField(timestampField),
            // name, isClosed, isHidden, isFrozen, dataStream, aliases  
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedIndex;
            }  
            ".ds-logs-mysql-test-000002",  
            DataStream ds = new DataStream(
    }
            boolean hidden = (boolean) indexInfo[2];
        }  
            ".ds-logs-mysql-test-000001",
    private static Object[] findInfo(Object[][] indexSource, String indexName) {
        for (int k = 0; k < resolvedIndices.size(); k++) {  
        TransportAction.resolveIndices(names, indicesOptions, metadata, resolver, indices, aliases, dataStreams, true);
        String tomorrowSuffix = dateFormatter.format(now.plus(Duration.ofDays(1L)));
        }  
            }
        return indexBuilder.build();  
        validateDataStreams(dataStreams, "logs-mysql-prod", "logs-mysql-test");  
/*  
            indices,  
            assertThat(resolvedAlias.getName(), equalTo(expectedAliases[k]));
                if (DataStream.getDefaultBackingIndexName(dataStreamName, k).equals(indexName)) {  
            indices,
                if (indicesSet == null) {
            );  
            "logs-pgsql-prod-20200101",
        List<ResolvedIndex> indices = new ArrayList<>();  
            "logs-pgsql-prod-20200103",  
            for (String alias : aliases) {
        List<ResolvedIndex> indices = new ArrayList<>();
        for (int k = 0; k < resolvedAliases.size(); k++) {
            Object[] indexInfo = findInfo(indices, expectedIndices[k]);
            assertThat(resolvedDataStream.getName(), equalTo((String) dataStreamInfo[0]));
        for (IndexMetadata index : allIndices) {
        Settings.Builder settingsBuilder = Settings.builder()  
import static java.util.Arrays.asList;
    public void testResolveStarWithAllOptions() {  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * specific language governing permissions and limitations
            "logs-pgsql-prod-20200102",
        List<ResolvedDataStream> dataStreams = new ArrayList<>();  
        }  
            indexBuilder.putAlias(AliasMetadata.builder(alias).build());  
                indicesSet.add((String) indexInfo[0]);
        List<ResolvedDataStream> dataStreams = new ArrayList<>();  
        List<IndexMetadata> allIndices = new ArrayList<>();  
import org.opensearch.cluster.metadata.IndexMetadata;
        { "logs-pgsql-prod-20200101", false, false, true, null, new String[] { "logs-pgsql-prod" } },
        Metadata metadata = buildMetadata(new Object[][] {}, indices);  
    public void testResolveHiddenProperlyWithDateMath() {
        );  
        new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
        validateDataStreams(dataStreams, "logs-mysql-prod", "logs-mysql-test");
            metadata,  
        return null;
    }
            "logs-pgsql-test-20200102",
 * software distributed under the License is distributed on an
            assertThat(resolvedIndex.getName(), equalTo((String) indexInfo[0]));
        }
    public void testResolveWithMultipleNames() {
        assertThat(resolvedIndices.size(), is(1));  
        attributes.sort(String::compareTo);
        DateFormatter dateFormatter = DateFormatter.forPattern("uuuu.MM.dd");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Object[] dataStreamInfo = findInfo(dataStreams, expectedDataStreams[k]);
    private final Object[][] indices = new Object[][] {  
    private static Object[] findBackingIndexInfo(Object[][] dataStreamSource, String indexName) {
                expectedBackingIndices.add(DataStream.getDefaultBackingIndexName(resolvedDataStream.getName(), m));  
 *  
        String[] names = new String[] { "logs-pgsql*" };  
import org.opensearch.test.OpenSearchTestCase;  
            }  
            if (info[0].equals(indexName)) {  
        List<ResolvedDataStream> dataStreams = new ArrayList<>();
import org.opensearch.cluster.metadata.Metadata;
    }
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
            "logs-pgsql-test-20200103"
            ResolvedAlias resolvedAlias = resolvedAliases.get(k);  
        );
    }
    }  
            builder.put(ds);
 * Modifications Copyright OpenSearch Contributors. See
    );
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            assertThat(resolvedIndex.getDataStream(), equalTo((String) indexInfo[4]));
import java.util.Arrays;  
            String dataStreamName = (String) info[0];  
            String[] aliases = (String[]) indexInfo[5];
        String[] names = new String[] { "*" };
    private static IndexMetadata createIndexMetadata(String name, boolean hidden) {  
            "logs-pgsql-test-20200102",  
            { "logs-pgsql-prod-" + todaySuffix, false, true, false, null, Strings.EMPTY_ARRAY },
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.TransportAction;  
            indices,  
            String timestampField = (String) dsInfo[1];  
    }  
            for (int k = 1; k <= generations; k++) {
 * not use this file except in compliance with the License.
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.Request;
            assertThat(resolvedDataStream.getBackingIndices(), is((expectedBackingIndices.toArray(Strings.EMPTY_ARRAY))));
                dataStreamName,  
    private IndexAbstractionResolver resolver = new IndexAbstractionResolver(  
    private Metadata metadata = buildMetadata(dataStreams, indices);
    }  
                        false,  
            Set<String> aliasIndices = aliasToIndicesMap.get(resolvedAlias.getName());
        }
        TransportAction.resolveIndices(names, indicesOptions, metadata, resolver, indices, aliases, dataStreams, true);
        for (Object[] info : indexSource) {
            String indexName = (String) indexInfo[0];
    private static String[] flagsToAttributes(Object[] indexInfo) {
import java.util.stream.Collectors;  
import java.util.Set;
            "logs-pgsql-prod-20200101",  
            randomBoolean(),
            assertThat(resolvedDataStream.getTimestampField(), equalTo((String) dataStreamInfo[1]));
                Set<String> indicesSet = aliasToIndicesMap.get(alias);  
                }
            .settings(settingsBuilder)  
        for (Object[] info : dataStreamSource) {
            assertThat(resolvedIndex.getAliases(), is(((String[]) indexInfo[5])));
        // name, timestampField, numBackingIndices
        validateIndices(indices, ".ds-logs-mysql-prod-000003", "logs-pgsql-test-20200102");  
        return builder.build();
        validateDataStreams(dataStreams, "logs-mysql-test");
    }  
        List<String> attributes = new ArrayList<>();  
