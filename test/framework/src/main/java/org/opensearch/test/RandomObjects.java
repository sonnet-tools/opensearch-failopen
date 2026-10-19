                        } else {
                    case 0:
        }
    }
        }
     * method like {@link ShardInfo.Failure#fromXContent(XContentParser)}.
                    );
                    break;
                return Base64.getEncoder().encodeToString(((BytesArray) value).toBytesRef().bytes);
    }
                    case 2:
            expectedParsedValues.add(getExpectedParsedValue(mediaType, originalValue));
    private static int randomDataType(Random random) {
        }
        return randomIntBetween(random, 0, 3);
 * You may obtain a copy of the License at
                actualException = new IndexShardRecoveringException(shard);
 * Licensed to Elasticsearch under one or more contributor
        } catch (IOException e) {
    private RandomObjects() {
                            builder.startObject();
     */
        if (value instanceof Float) {
                            : randomUnicodeOfLengthBetween(random, 3, 10)
            // with JSON AND YAML we get back a double, but with float precision.
     * via {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)} and parsed back via
            for (int i = 0; i < entryCount; i++) {
                    addFields(random, builder, minNumFields, currentDepth + 1);
                    boolean object = random.nextBoolean();
import static com.carrotsearch.randomizedtesting.generators.RandomStrings.randomUnicodeOfLengthBetween;
                );
                    break;
                    "OpenSearch exception [type=cluster_block_exception, "
                expectedException.setShard(shard);
     *
        String token = RandomStrings.randomAsciiLettersOfLengthBetween(random, 1, 20);
import java.util.HashMap;
    private static List<Object> randomStoredFieldValues(Random random, int numValues) {
                break;
     *
                break;
import org.opensearch.action.admin.indices.analyze.AnalyzeAction.AnalyzeToken;
     * Returns a tuple that contains a randomized {@link Failure} value (left side) and its corresponding
     */
                if (random.nextBoolean()) {
                        list.add(RandomStrings.randomAsciiLettersOfLength(random, 4));
/*
        boolean primary = random.nextBoolean();
                        if (object) {
     * the randomized ShardInfo must or must not contain shard failures.
     * method like {@link ShardInfo#fromXContent(XContentParser)}. A `withShardFailures` parameter indicates if
        Failure expected = new Failure(new ShardId(index, INDEX_UUID_NA_VALUE, shardId), nodeId, expectedException, status, primary);
                );
    /**
 */
                return RandomStrings.randomAsciiLettersOfLengthBetween(random, 3, 10);
                expectedException = new OpenSearchException(
import org.opensearch.core.xcontent.XContentParser;
        RestStatus status = randomFrom(random, RestStatus.INTERNAL_SERVER_ERROR, RestStatus.FORBIDDEN, RestStatus.NOT_FOUND);
 * not use this file except in compliance with the License.
                expectedException = new OpenSearchException(
        }
                return value;
    /**
import org.opensearch.core.common.bytes.BytesArray;
        return value;
        ShardId shard = new ShardId(index, indexUuid, shardId);
                        list.add(RandomStrings.randomAsciiLettersOfLength(random, 6));
                case 0:
/*
        }
                case 3:
        }
                actualException = new IllegalArgumentException("Closed resource", new RuntimeException("Resource"));
                expectedException = new OpenSearchException(
}
    /**
    }
                    case 1:
        // the source can be stored in any format and eventually converted when retrieved depending on the format of the response
            return BytesReference.bytes(builder);
            return Tuple.tuple(new ShardInfo(total, total), new ShardInfo(total, total));
 */
                    randomFieldValue(random, randomDataType(random))
                    values.add((byte) random.nextInt());
        Failure actual = new Failure(shard, nodeId, actualException, status, primary);
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
        List<Object> values = new ArrayList<>(numValues);
import org.opensearch.OpenSearchException;
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
     * {@link org.opensearch.index.mapper.MappedFieldType#valueForDisplay(Object)} to either strings, numbers or booleans.
            }
        }
     * via {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)} and parsed back via
        int posLength = RandomizedTest.randomIntBetween(1, 5);
            return Double.parseDouble(value.toString());
import org.opensearch.common.collect.Tuple;
 * under the License.
 * specific language governing permissions and limitations
     */
                return random.nextLong();
                    case 5:
package org.opensearch.test;
        int startOffset = RandomizedTest.randomIntBetween(0, 1000);
                case 2:
        return values;
                    byte[] randomBytes = RandomStrings.randomUnicodeOfLengthBetween(random, 10, 50).getBytes(StandardCharsets.UTF_8);
                    values.add((short) random.nextInt());
        switch (type) {
                        String value = RandomStrings.randomAsciiLettersOfLength(random, 10);
 * KIND, either express or implied.  See the License for the
                return RandomStrings.randomAsciiLettersOfLengthBetween(random, 3, 10);
                expectedException.setShard(shard);
            switch (dataType) {
 * compatible open source license.
     *
                    builder.endObject();
            int entryCount = RandomNumbers.randomIntBetween(random, 0, 6);
    public static BytesReference randomSource(Random random, final MediaType mediaType) {
                actualException = new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES));
                // JSON writes base64 format
     * @param random            Random generator
            default:
     * Returns a tuple containing random stored field values and their corresponding expected values once printed out
 *
    }
                        extras.put(listkey, list);
        }
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo;
 * license agreements. See the NOTICE file distributed with
     * @param withShardFailures indicates if the generated ShardInfo must contain shard failures
     * Returns a random source in a given XContentType containing a random number of fields, objects and array, with maximum depth 5.
     */
        String index = randomAsciiLettersOfLength(random, 5);
        OpenSearchException expectedException;
            if (mediaType == XContentType.CBOR || mediaType == XContentType.SMILE) {
     * @param random Random generator
                    builder.startArray(RandomStrings.randomAsciiLettersOfLengthBetween(random, 6, 10));
 * The OpenSearch Contributors require contributions made to
            }
    private static Object randomFieldValue(Random random, int dataType) {
                        extras.put(objkey, obj);
import org.opensearch.core.xcontent.MediaType;
                    break;
        switch (dataType) {
                    new OpenSearchException("OpenSearch exception [type=runtime_exception, reason=Resource]")
    }
import org.opensearch.cluster.block.ClusterBlockException;
                    values.add(random.nextBoolean());
import org.opensearch.index.shard.ShardNotFoundException;
        if (withShardFailures == false) {
                    values.add(random.nextFloat());
 * SPDX-License-Identifier: Apache-2.0
     * Generates values based on what can get printed out. Stored fields values are retrieved from lucene and converted via
     * The minimum number of fields per object is 1.
     */
            case 2:
                case 6:
        return randomSource(random, RandomPicks.randomFrom(random, XContentType.values()));
public final class RandomObjects {
     * @param random Random generator
                default:
    }
                        String listkey = RandomStrings.randomAsciiLettersOfLength(random, 5);
    private static void addFields(Random random, XContentBuilder builder, int minNumFields, int currentDepth) throws IOException {
        }
        int numValues = randomIntBetween(random, 1, 5);
                }
    /**
                    }
     */
     */
import static com.carrotsearch.randomizedtesting.generators.RandomStrings.randomAsciiLettersOfLength;
        for (int i = 0; i < numFields; i++) {
            case 3:
        for (int i = 0; i < failures; i++) {
     * @param random Random generator
                        String key = RandomStrings.randomAsciiLettersOfLength(random, 5);
 */
                    values.add(random.nextDouble());
            }
                    throw new UnsupportedOperationException();
        int endOffset = RandomizedTest.randomIntBetween(0, 1000);
    public static Tuple<List<Object>, List<Object>> randomStoredFieldValues(Random random, MediaType mediaType) {
                    break;
    }
        Map<String, Object> extras = new HashMap<>();
        String nodeId = randomAsciiLettersOfLength(random, 5);
        int type = randomIntBetween(random, 0, 3);
            case 0:
        int successful = randomIntBetween(random, 1, Math.max(1, (total - 1)));
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_UUID_NA_VALUE;
        Exception actualException;
                        String objkey = RandomStrings.randomAsciiLettersOfLength(random, 5);
 * software distributed under the License is distributed on an
import static java.util.Collections.singleton;
                        }
 * this file be licensed under the Apache-2.0 license or a
     * The minimum number of fields per object is provided as an argument.
    /**
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.bytes.BytesReference;
    public static BytesReference randomSource(Random random) {
        return Tuple.tuple(new ShardInfo(total, successful, actualFailures), new ShardInfo(total, successful, expectedFailures));
     * @param random Random generator
                    break;
        for (int i = 0; i < numValues; i++) {
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                    for (int j = 0; j < numElements; j++) {
        int dataType = randomIntBetween(random, 0, 8);
    public static BytesReference randomSource(Random random, final MediaType mediaType, int minNumFields) {
                    break;
     * {@link org.opensearch.index.mapper.MappedFieldType#valueForDisplay(Object)} to either strings, numbers or booleans.
                case 7:
import org.opensearch.index.shard.IndexShardRecoveringException;
                throw new UnsupportedOperationException();
        int total = randomIntBetween(random, 1, 10);
/*
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
        int position = RandomizedTest.randomIntBetween(0, 1000);
     * @param mediaType the content type, used to determine what the expected values are for float numbers.
            return ((Short) value).intValue();
                );
                    "OpenSearch exception [type=illegal_argument_exception, " + "reason=Closed resource]",
     * {@link XContentParser#objectText()}.
    }
                // with binary content types we pass back the object as is
            default:
 * the Apache License, Version 2.0 (the "License"); you may
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 *     http://www.apache.org/licenses/LICENSE-2.0
        Failure[] expectedFailures = new Failure[failures];
import java.nio.charset.StandardCharsets;
     * Generates values based on what can get printed out. Stored fields values are retrieved from lucene and converted via
 * GitHub history for details.
                            ? RandomStrings.randomAsciiLettersOfLengthBetween(random, 3, 10)
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo.Failure;
                case 8:
        String indexUuid = randomAsciiLettersOfLength(random, 5);
                        break;
        int failures = Math.max(1, (total - successful));
import java.io.IOException;
     */
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.index.shard.ShardId;
 * Unless required by applicable law or agreed to in writing,
            return ((Byte) value).intValue();
        int shardId = randomIntBetween(random, 1, 10);
                break;
import java.util.Map;
        for (Object originalValue : originalValues) {
import java.util.List;
    public static Object getExpectedParsedValue(MediaType mediaType, Object value) {
    public static AnalyzeToken randomToken(Random random) {
                    int numElements = randomIntBetween(random, 1, 5);
        }
                        obj.put(RandomStrings.randomAsciiLettersOfLength(random, 5), RandomStrings.randomAsciiLettersOfLength(random, 10));
                            addFields(random, builder, minNumFields, 5);
     * Returns a random source containing a random number of fields, objects and array, with maximum depth 5.
 *
            builder.startObject();
                    builder.startObject(RandomStrings.randomAsciiLettersOfLengthBetween(random, 6, 10));
                    int dataType = -1;
    }
                        extras.put(key, value);
     *
     * value (right side) after it has been printed out as a {@link ToXContent} and parsed back using a parsing
                case 5:
            case 1:
            Tuple<Failure, Failure> failure = randomShardInfoFailure(random);
                        + "reason=blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];]"
                return random.nextDouble();
        }
import static com.carrotsearch.randomizedtesting.generators.RandomNumbers.randomIntBetween;
import org.opensearch.common.xcontent.XContentType;
        return new AnalyzeAction.AnalyzeToken(token, position, startOffset, endOffset, posLength, type, extras);
                    RandomStrings.randomAsciiLettersOfLengthBetween(random, 6, 10),
                    break;
                            builder.value(randomFieldValue(random, dataType));
                break;
                        List<String> list = new ArrayList<>();
        if (value instanceof BytesArray) {
     *
    public static Tuple<ShardInfo, ShardInfo> randomShardInfo(Random random) {
                );
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            builder.endObject();
            expectedFailures[i] = failure.v2();
                        Map<String, String> obj = new HashMap<>();
                    case 3:
                actualException = new ShardNotFoundException(shard);
     *
                switch (RandomNumbers.randomIntBetween(random, 0, 6)) {
     * {@link XContentParser#objectText()}.
            if (mediaType == MediaTypeRegistry.JSON) {
    }
    }
                    "OpenSearch exception [type=index_shard_recovering_exception, " + "reason=CurrentState[RECOVERING] Already recovering]"
import com.carrotsearch.randomizedtesting.RandomizedTest;
import org.opensearch.core.rest.RestStatus;
        }
                );
                    if (object == false) {
            throw new IllegalArgumentException("Unable to parse media type [" + mediaType.getClass().getName() + "]");
     * Returns a random source in a given XContentType containing a random number of fields, objects and array, with maximum depth 5.
            addFields(random, builder, minNumFields, 0);
                }
        try (XContentBuilder builder = mediaType.contentBuilder()) {
            } else {
            throw new RuntimeException(e);
    /**
                    values.add(
        int numFields = randomIntBetween(random, minNumFields, 5);
        return randomShardInfo(random, random.nextBoolean());
            case 0:
                    case 4:
        if (value instanceof Byte) {
        if (random.nextBoolean()) {
                } else {
    }
     *
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
                            builder.endObject();
        if (value instanceof Short) {
 * this work for additional information regarding copyright
     * Converts the provided field value to its corresponding expected value once printed out
                case 1:
import org.opensearch.core.xcontent.ToXContent;
                        break;
     * method like {@link ShardInfo#fromXContent(XContentParser)}. The ShardInfo randomly contains shard failures.
            case 1:
                        random.nextBoolean()
        }
                    values.add(random.nextInt());
     * @param random Random generator
            case 3:
        if (mediaType instanceof XContentType == false) {
    /**
                throw new UnsupportedOperationException("No randomized exceptions generated for type [" + type + "]");
        }
import java.util.ArrayList;
                case 4:
            actualFailures[i] = failure.v1();
import java.util.Random;
                    break;
        Failure[] actualFailures = new Failure[failures];
     * Randomly adds fields, objects, or arrays to the provided builder. The maximum depth is 5.
                builder.field(
        return Tuple.tuple(originalValues, expectedParsedValues);
                    builder.endArray();
            }
        return randomSource(random, mediaType, 1);
                        break;
                    values.add(random.nextLong());
    /**
        List<Object> originalValues = randomStoredFieldValues(random, numValues);
    /**
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
     * Returns a tuple that contains a randomized {@link ShardInfo} value (left side) and its corresponding
        List<Object> expectedParsedValues = new ArrayList<>(numValues);
import org.opensearch.core.xcontent.XContentBuilder;
        String type = RandomStrings.randomAsciiLettersOfLengthBetween(random, 1, 20);
                    break;
     * Returns a tuple that contains a randomized {@link ShardInfo} value (left side) and its corresponding
                        dataType = randomDataType(random);
     * value (right side) after it has been printed out as a {@link ToXContent} and parsed back using a parsing
     */
    public static Tuple<ShardInfo, ShardInfo> randomShardInfo(Random random, boolean withShardFailures) {
    }
                    "OpenSearch exception [type=shard_not_found_exception, " + "reason=no such shard]"
    }
                    values.add(new BytesArray(randomBytes));
                    }
            if (currentDepth < 5 && random.nextInt(100) >= 70) {
                expectedException = new OpenSearchException(
    private static Tuple<Failure, Failure> randomShardInfoFailure(Random random) {
            case 2:
     * @param random Random generator
        return Tuple.tuple(actual, expected);
import java.util.Base64;
     * value (right side) after it has been printed out as a {@link ToXContent} and parsed back using a parsing
