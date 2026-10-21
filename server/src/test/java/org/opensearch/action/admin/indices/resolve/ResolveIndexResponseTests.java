        return ALIAS_PARSER.parse(parser, null);
    }
 *
import java.util.ArrayList;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        int num = randomIntBetween(minLength, maxLength);
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.Response;
        RESPONSE_PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> aliasFromXContent(p), ALIASES_FIELD);
    );
import org.opensearch.core.xcontent.ConstructingObjectParser;
    protected Response doParseInstance(XContentParser parser) throws IOException {
    }
        String[] backingIndices = randomStringArray(1, 6);
            ConstructingObjectParser.constructorArg(),
import static org.opensearch.action.admin.indices.resolve.ResolveIndexAction.Response.INDICES_FIELD;
 * GitHub history for details.
            (p, c) -> dataStreamFromXContent(p),
/*
        INDEX_PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
import org.opensearch.core.common.Strings;
        for (int k = 0; k < num; k++) {
import static org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedIndex.DATA_STREAM_FIELD;
    @Override
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.admin.indices.resolve;
 * ownership. Elasticsearch licenses this file to you under
        String dataStream = randomBoolean() ? randomAlphaOfLength(6) : null;
            DATA_STREAMS_FIELD
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return new ResolvedDataStream(name, backingIndices, timestampField);
        "resolved_index",
        int num = randomIntBetween(0, 8);
        final List<ResolvedAlias> aliases = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
    }
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        DATA_STREAM_PARSER.declareString(ConstructingObjectParser.constructorArg(), TIMESTAMP_FIELD);
        return stringArray;
import static org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedDataStream.BACKING_INDICES_FIELD;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.Writeable;
        }
        final List<ResolvedDataStream> dataStreams = new ArrayList<>();
/*
        String name = randomAlphaOfLength(6);
        for (int k = 0; k < num; k++) {
    }
    protected Writeable.Reader<Response> instanceReader() {
    private static ResolvedIndex createTestResolvedIndexInstance() {
        DATA_STREAM_PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
        DATA_STREAM_PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), BACKING_INDICES_FIELD);
    @SuppressWarnings("unchecked")
        "resolve_index_response",
 * The OpenSearch Contributors require contributions made to
        num = randomIntBetween(0, 8);
        );
            (String) args[3]
        ALIAS_PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), INDICES_FIELD);
    }
    private static final ConstructingObjectParser<ResolvedIndex, Void> INDEX_PARSER = new ConstructingObjectParser<>(
 *     http://www.apache.org/licenses/LICENSE-2.0
        return Response::new;
            stringArray[k] = randomAlphaOfLength(6);
    }
    static String[] randomStringArray(int minLength, int maxLength) {
        RESPONSE_PARSER.declareObjectArray(
        String[] indices = randomStringArray(1, 6);
    @SuppressWarnings("unchecked")
        "resolved_alias",
        String name = randomAlphaOfLength(6);
import java.util.List;
    public static ResolvedDataStream dataStreamFromXContent(XContentParser parser) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        String[] stringArray = new String[num];
 */
    public static ResolvedAlias aliasFromXContent(XContentParser parser) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            dataStreams.add(createTestResolvedDataStreamInstance());
        )
    protected Response createTestInstance() {
        "resolved_data_stream",
        INDEX_PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), ALIASES_FIELD);
    }
        return new ResolvedIndex(name, aliases, attributes, dataStream);
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor
        return new Response(indices, aliases, dataStreams);
        }
        return INDEX_PARSER.parse(parser, null);
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedIndex;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedAlias;
    }
        String[] attributes = randomSubsetOf(List.of("open", "hidden", "frozen")).toArray(Strings.EMPTY_ARRAY);
public class ResolveIndexResponseTests extends AbstractSerializingTestCase<Response> {
            (String) args[0],
import java.io.IOException;
    );
    public static Response responseFromXContent(XContentParser parser) throws IOException {
    }
        return new ResolvedAlias(name, indices);
    );
    private static final ConstructingObjectParser<ResolvedAlias, Void> ALIAS_PARSER = new ConstructingObjectParser<>(
        for (int k = 0; k < num; k++) {
import org.opensearch.test.AbstractSerializingTestCase;
        args -> new ResolvedIndex(
    static {
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedDataStream;
    }
        }
 * this work for additional information regarding copyright
 *
    }
        RESPONSE_PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> indexFromXContent(p), INDICES_FIELD);
        num = randomIntBetween(0, 8);
 *
    private static final ConstructingObjectParser<ResolvedDataStream, Void> DATA_STREAM_PARSER = new ConstructingObjectParser<>(
        ALIAS_PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
        args -> new ResolvedDataStream((String) args[0], ((List<String>) args[1]).toArray(Strings.EMPTY_ARRAY), (String) args[2])
    static ResolvedIndex indexFromXContent(XContentParser parser) throws IOException {
 * under the License.
}
        for (int k = 0; k < num; k++) {
    }
 * You may obtain a copy of the License at
 */
        final List<ResolvedIndex> indices = new ArrayList<>();
            ((List<String>) args[2]).toArray(Strings.EMPTY_ARRAY),
        return DATA_STREAM_PARSER.parse(parser, null);
        String timestampField = randomAlphaOfLength(6);
    );
        args -> new ResolvedAlias((String) args[0], ((List<String>) args[1]).toArray(Strings.EMPTY_ARRAY))
        return responseFromXContent(parser);
        return RESPONSE_PARSER.parse(parser, null);
    @Override
    private static ResolvedAlias createTestResolvedAliasInstance() {
import static org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedDataStream.TIMESTAMP_FIELD;
        INDEX_PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), DATA_STREAM_FIELD);
            indices.add(createTestResolvedIndexInstance());
    @SuppressWarnings("unchecked")
        INDEX_PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), ATTRIBUTES_FIELD);
            args[1] != null ? ((List<String>) args[1]).toArray(Strings.EMPTY_ARRAY) : new String[0],
import static org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedIndexAbstraction.NAME_FIELD;
        }
 */
import static org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedIndex.ATTRIBUTES_FIELD;
/*
    @Override
    private static ResolvedDataStream createTestResolvedDataStreamInstance() {
import static org.opensearch.action.admin.indices.resolve.ResolveIndexAction.Response.DATA_STREAMS_FIELD;
    @SuppressWarnings("unchecked")
import org.opensearch.core.xcontent.XContentParser;
        args -> new Response((List<ResolvedIndex>) args[0], (List<ResolvedAlias>) args[1], (List<ResolvedDataStream>) args[2])
        String name = randomAlphaOfLength(6);
        String[] aliases = randomStringArray(0, 5);
    private static final ConstructingObjectParser<Response, Void> RESPONSE_PARSER = new ConstructingObjectParser<>(
import static org.opensearch.action.admin.indices.resolve.ResolveIndexAction.ResolvedIndex.ALIASES_FIELD;
            aliases.add(createTestResolvedAliasInstance());
