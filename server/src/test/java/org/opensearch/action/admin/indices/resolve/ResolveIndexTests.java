        { "logs-mysql-test", "@timestamp", 2 } };
        // set up with today's index and following day's index to avoid test failures due to execution time
        Metadata metadata = buildMetadata(new Object[][] {}, indices);
        List<ResolvedAlias> aliases = new ArrayList<>();
        { "logs-mysql-prod", "@timestamp", 4 },
        return attributes.toArray(Strings.EMPTY_ARRAY);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            "logs-pgsql-prod-20200102",
        List<ResolvedAlias> aliases = new ArrayList<>();
    }
    private IndexAbstractionResolver resolver = new IndexAbstractionResolver(
    public void testResolveHiddenProperlyWithDateMath() {
        List<String> resolvedIndices = resolver.resolveIndexAbstractions(
        for (int k = 0; k < resolvedAliases.size(); k++) {
                        DataStream.getDefaultBackingIndexName(dataStreamName, k),
        }
            { "logs-pgsql-prod-" + todaySuffix, false, true, false, null, Strings.EMPTY_ARRAY },
        for (Object[] indexInfo : indices) {
            assertThat(resolvedIndex.getDataStream(), equalTo((String) indexInfo[4]));
            "logs-pgsql-test-20200101",
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder(name)
        );
        assertThat(resolvedDataStreams.size(), equalTo(expectedDataStreams.length));
/*
        }
            singletonList(requestedIndex),
        }
        // name, isClosed, isHidden, isFrozen, dataStream, aliases
            int numBackingIndices = (int) dsInfo[2];
import org.opensearch.test.OpenSearchTestCase;
        String[] names = new String[] { ".ds-logs-mysql-prod-000003", "logs-pgsql-test-20200102", "one-off-alias", "logs-mysql-test" };
import java.time.Clock;
 * specific language governing permissions and limitations
            Object[] indexInfo = findInfo(indices, expectedIndices[k]);
                return info;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            assertThat(resolvedDataStream.getTimestampField(), equalTo((String) dataStreamInfo[1]));
        validateDataStreams(dataStreams, "logs-mysql-test");
        for (Object[] dsInfo : dataStreams) {
 * SPDX-License-Identifier: Apache-2.0
                dataStreamName,
                createTimestampField(timestampField),
 * You may obtain a copy of the License at
 */
 * Unless required by applicable law or agreed to in writing,
        for (int k = 0; k < resolvedDataStreams.size(); k++) {
        List<ResolvedIndex> indices = new ArrayList<>();
package org.opensearch.action.admin.indices.resolve;
        return null;
            "logs-pgsql-prod-20200102",
            .numberOfReplicas(1);
 * ownership. Elasticsearch licenses this file to you under
            indices,
 * under the License.
            if (info[0].equals(indexName)) {
        for (String alias : aliases) {
            assertThat(resolvedIndex.getAliases(), is(((String[]) indexInfo[5])));
    public void testResolveStarWithDefaultOptions() {
            .state(closed ? IndexMetadata.State.CLOSE : IndexMetadata.State.OPEN)
                if (DataStream.getDefaultBackingIndexName(dataStreamName, k).equals(indexName)) {
    }
import org.opensearch.Version;
        validateIndices(
            Arrays.sort(expectedIndices);
            ".ds-logs-mysql-prod-000001",
            indices,
    }
        String[] names = new String[] { "*" };
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedAlias;
                expectedBackingIndices.add(DataStream.getDefaultBackingIndexName(resolvedDataStream.getName(), m));
            indices,
            ".ds-logs-mysql-prod-000002",
import static java.util.Arrays.asList;
            }
        List<String> attributes = new ArrayList<>();
                backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList())
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.Request;
            String indexName = (String) indexInfo[0];
            assertThat(resolvedAlias.getName(), equalTo(expectedAliases[k]));
            "logs-pgsql-prod-20200101",
import java.util.HashMap;
        assertThat(resolvedIndices.get(0), oneOf("logs-pgsql-prod-" + todaySuffix, "logs-pgsql-prod-" + tomorrowSuffix));
        return builder.build();
            "logs-pgsql-test-20200103"
    private void validateIndices(List<ResolvedIndex> resolvedIndices, String... expectedIndices) {
import java.util.Set;
        }
        IndicesOptions indicesOptions = IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN;
            .numberOfShards(1)
            String dataStreamName = (String) dsInfo[0];
        List<ResolvedAlias> aliases = new ArrayList<>();
        List<IndexMetadata> allIndices = new ArrayList<>();
        List<ResolvedDataStream> dataStreams = new ArrayList<>();
            "logs-pgsql-prod-20200101",
}
 */
        { "logs-pgsql-prod-20200101", false, false, true, null, new String[] { "logs-pgsql-prod" } },
            { "logs-pgsql-prod-" + tomorrowSuffix, false, true, false, null, Strings.EMPTY_ARRAY } };
    }
/*
    private static IndexMetadata createIndexMetadata(String name, boolean hidden) {
        TransportAction.resolveIndices(names, indicesOptions, metadata, resolver, indices, aliases, dataStreams, true);
            "logs-pgsql-prod-20200103",
        attributes.sort(String::compareTo);
 * The OpenSearch Contributors require contributions made to
                        Strings.EMPTY_ARRAY };
        validateAliases(aliases, "logs-pgsql-prod", "logs-pgsql-test", "one-off-alias");
            String[] aliases = (String[]) indexInfo[5];
        String tomorrowSuffix = dateFormatter.format(now.plus(Duration.ofDays(1L)));
        TransportAction.resolveIndices(names, indicesOptions, metadata, resolver, indices, aliases, dataStreams, true);
                        false,
            ".ds-logs-mysql-prod-000004",
    private static Object[] findInfo(Object[][] indexSource, String indexName) {
            boolean frozen = (boolean) indexInfo[3];
            "logs-pgsql-prod-20200102",
                if (indicesSet == null) {
            IndicesOptions.LENIENT_EXPAND_OPEN,
            ".ds-logs-mysql-test-000002",
            "logs-pgsql-test-20200102",
 * this work for additional information regarding copyright
        IndicesOptions indicesOptions = Request.DEFAULT_INDICES_OPTIONS;
            attributes.add("hidden");
import org.opensearch.common.time.DateFormatter;
                        false,
            Set<String> aliasIndices = aliasToIndicesMap.get(resolvedAlias.getName());
            asList("logs-pgsql-prod-" + todaySuffix, "logs-pgsql-prod-" + tomorrowSuffix),
        List<ResolvedDataStream> dataStreams = new ArrayList<>();
            allIndices.add(createIndexMetadata(indexName, aliases, closed, hidden, frozen));
                    aliasToIndicesMap.put(alias, indicesSet);
        Object[][] indices = new Object[][] {
        String todaySuffix = dateFormatter.format(now);
            List<IndexMetadata> backingIndices = new ArrayList<>();
import java.util.ArrayList;
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.TransportAction;
import org.opensearch.cluster.metadata.IndexMetadata;
                    indicesSet = new HashSet<>();
 */
        { "logs-pgsql-test-20200102", false, false, false, null, new String[] { "logs-pgsql-test" } },
        IndicesOptions indicesOptions = IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN;
    private final Object[][] dataStreams = new Object[][] {
import org.opensearch.common.settings.Settings;
        IndicesOptions indicesOptions = Request.DEFAULT_INDICES_OPTIONS;
    }
                backingIndices.add(createIndexMetadata(DataStream.getDefaultBackingIndexName(dataStreamName, backingIndexNumber), true));
    }
    }
            }
import static org.hamcrest.core.IsNull.notNullValue;
        }
            String[] expectedIndices = aliasIndices.toArray(Strings.EMPTY_ARRAY);
        for (IndexMetadata index : allIndices) {
 *
    private Metadata metadata = buildMetadata(dataStreams, indices);
            "logs-pgsql-test-20200103"
            "logs-pgsql-prod-20200103",
            }
 * Licensed to Elasticsearch under one or more contributor
            Object[] dataStreamInfo = findInfo(dataStreams, expectedDataStreams[k]);
        for (int k = 0; k < resolvedIndices.size(); k++) {
import org.opensearch.core.common.Strings;
            .settings(settingsBuilder)
            for (int backingIndexNumber = 1; backingIndexNumber <= numBackingIndices; backingIndexNumber++) {
import static java.util.Collections.singletonList;
import org.opensearch.cluster.metadata.DataStream;
        List<ResolvedIndex> indices = new ArrayList<>();
                }
        { "logs-pgsql-prod-20200103", false, false, false, null, new String[] { "logs-pgsql-prod" } },
        assertThat(resolvedIndices.size(), equalTo(expectedIndices.length));
 * compatible open source license.
        validateAliases(aliases, "one-off-alias");
        assertThat(resolvedIndices.size(), is(1));
            for (String alias : aliases) {
                Set<String> indicesSet = aliasToIndicesMap.get(alias);
            assertThat(resolvedAlias.getIndices(), is(expectedIndices));
        List<ResolvedDataStream> dataStreams = new ArrayList<>();
import org.opensearch.common.util.concurrent.ThreadContext;
            if (indexInfo == null) {
            allIndices.addAll(backingIndices);
 *
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedIndex;
        }
        Map<String, Set<String>> aliasToIndicesMap = new HashMap<>();
import static org.hamcrest.Matchers.is;
        if ((boolean) indexInfo[2]) {
        String[] names = new String[] { "logs-pgsql*" };
            builder.put(index, false);
                        true,
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
            String timestampField = (String) dsInfo[1];
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
            ".ds-logs-mysql-test-000001",
import org.opensearch.cluster.metadata.AliasMetadata;
    private static Object[] findBackingIndexInfo(Object[][] dataStreamSource, String indexName) {
        // name, timestampField, numBackingIndices
            "logs-pgsql-test-20200103"
 * the Apache License, Version 2.0 (the "License"); you may
        { "logs-pgsql-test-20200101", true, false, false, null, new String[] { "logs-pgsql-test" } },
        }
import org.opensearch.cluster.metadata.IndexAbstractionResolver;
    public void testResolveWithMultipleNames() {
 * GitHub history for details.
        validateAliases(aliases, "logs-pgsql-prod", "logs-pgsql-test", "one-off-alias");
                }
    }
            builder.put(ds);
            String[] aliases = (String[]) indexInfo[5];
public class ResolveIndexTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
                indexInfo = findBackingIndexInfo(dataStreams, expectedIndices[k]);
        for (Object[] info : indexSource) {
        if ((boolean) indexInfo[3]) {
    }
        validateIndices(
    public void testResolveStarWithAllOptions() {
            List<String> expectedBackingIndices = new ArrayList<>();
        return createIndexMetadata(name, Strings.EMPTY_ARRAY, false, true, false);
            }
            }
            randomBoolean(),
                        dataStreamName,
        new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
            attributes.add("frozen");
            assertThat(resolvedDataStream.getBackingIndices(), is((expectedBackingIndices.toArray(Strings.EMPTY_ARRAY))));
            }
        for (Object[] info : dataStreamSource) {
            assertThat(resolvedIndex.getName(), equalTo((String) indexInfo[0]));
            );
import java.util.stream.Collectors;
import java.time.Duration;
            metadata,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        List<ResolvedDataStream> dataStreams = new ArrayList<>();
            "logs-pgsql-prod-20200103",
            boolean hidden = (boolean) indexInfo[2];
            int numBackingIndices = (int) dataStreamInfo[2];
            randomBoolean(),
            ResolvedIndex resolvedIndex = resolvedIndices.get(k);
    private static String[] flagsToAttributes(Object[] indexInfo) {
        Settings.Builder settingsBuilder = Settings.builder()
        validateDataStreams(dataStreams, Strings.EMPTY_ARRAY);
import java.util.HashSet;
        );
        TransportAction.resolveIndices(names, indicesOptions, metadata, resolver, indices, aliases, dataStreams, true);
            for (int m = 1; m <= numBackingIndices; m++) {
            DataStream ds = new DataStream(
                    return new Object[] {
        );
            for (int k = 1; k <= generations; k++) {
    );
        validateDataStreams(dataStreams, "logs-mysql-prod", "logs-mysql-test");
        }
        validateIndices(indices, ".ds-logs-mysql-prod-000003", "logs-pgsql-test-20200102");
import static org.hamcrest.Matchers.oneOf;
            "logs-pgsql-test-20200102",
        String requestedIndex = "<logs-pgsql-prod-{now/d}>";
            ".ds-logs-mysql-prod-000003",
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedDataStream;
    }
            indexBuilder.putAlias(AliasMetadata.builder(alias).build());
            assertThat(aliasIndices, notNullValue());
import org.opensearch.cluster.metadata.Metadata;
            true
        Instant now = Instant.now(Clock.systemUTC());
            ResolvedDataStream resolvedDataStream = resolvedDataStreams.get(k);
        validateAliases(aliases, "logs-pgsql-prod", "logs-pgsql-test");
    private void validateDataStreams(List<ResolvedDataStream> resolvedDataStreams, String... expectedDataStreams) {
            int generations = (int) info[2];
        }
 *
import java.time.Instant;
            "logs-pgsql-prod-20200101",
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.IndicesOptions;
    }
    private static IndexMetadata createIndexMetadata(String name, String[] aliases, boolean closed, boolean hidden, boolean frozen) {
            boolean closed = (boolean) indexInfo[1];
        }
import java.util.Arrays;
        for (Object[] indexInfo : indices) {
    private final Object[][] indices = new Object[][] {
        validateIndices(
            String dataStreamName = (String) info[0];
        DateFormatter dateFormatter = DateFormatter.forPattern("uuuu.MM.dd");
    public void testResolveWithPattern() {
            .put("index.frozen", frozen);
/*
        return indexBuilder.build();
                indicesSet.add((String) indexInfo[0]);
    static Metadata buildMetadata(Object[][] dataStreams, Object[][] indices) {
        String[] names = new String[] { "*" };
            assertThat(dataStreamInfo, notNullValue());
        }
import java.util.Map;
 * not use this file except in compliance with the License.
        { "logs-pgsql-prod-20200102", false, false, true, null, new String[] { "logs-pgsql-prod", "one-off-alias" } },
            // name, isClosed, isHidden, isFrozen, dataStream, aliases
            assertThat(resolvedDataStream.getName(), equalTo((String) dataStreamInfo[0]));
import java.util.List;
        Metadata.Builder builder = Metadata.builder();
        List<ResolvedAlias> aliases = new ArrayList<>();
            ResolvedAlias resolvedAlias = resolvedAliases.get(k);
    }
        );
        List<ResolvedIndex> indices = new ArrayList<>();
import static org.hamcrest.Matchers.equalTo;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        TransportAction.resolveIndices(names, indicesOptions, metadata, resolver, indices, aliases, dataStreams, true);
        attributes.add((boolean) indexInfo[1] ? "closed" : "open");
        }
            assertThat(resolvedIndex.getAttributes(), is(flagsToAttributes(indexInfo)));
    }
            "logs-pgsql-test-20200102",
    private void validateAliases(List<ResolvedAlias> resolvedAliases, String... expectedAliases) {
            .put("index.hidden", hidden)
            assertThat(indexInfo, notNullValue());
    }
        validateDataStreams(dataStreams, "logs-mysql-prod", "logs-mysql-test");
        assertThat(resolvedAliases.size(), equalTo(expectedAliases.length));
        { "logs-pgsql-test-20200103", false, false, false, null, new String[] { "logs-pgsql-test" } } };
        List<ResolvedIndex> indices = new ArrayList<>();
        return null;
