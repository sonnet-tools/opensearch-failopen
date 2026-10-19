        for (int i = 0; i < failures; i++) {
import static com.carrotsearch.randomizedtesting.generators.RandomNumbers.randomIntBetween;  
/*  
                    );
     */
    }
import java.util.Random;
        }
            return BytesReference.bytes(builder);
            expectedParsedValues.add(getExpectedParsedValue(mediaType, originalValue));
                    int numElements = randomIntBetween(random, 1, 5);
    /**  
        return new AnalyzeAction.AnalyzeToken(token, position, startOffset, endOffset, posLength, type, extras);
        return value;  
                } else {  
                    new OpenSearchException("OpenSearch exception [type=runtime_exception, reason=Resource]")  
                switch (RandomNumbers.randomIntBetween(random, 0, 6)) {
                expectedException = new OpenSearchException(  
     * {@link XContentParser#objectText()}.
                    case 3:
                break;  
        }
            if (mediaType == MediaTypeRegistry.JSON) {
        int position = RandomizedTest.randomIntBetween(0, 1000);
        return Tuple.tuple(actual, expected);
                    break;
                    case 5:
                return random.nextLong();  
    /**
        int posLength = RandomizedTest.randomIntBetween(1, 5);
     *
        List<Object> values = new ArrayList<>(numValues);
     * via {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)} and parsed back via  
import org.opensearch.core.xcontent.ToXContent;  
     * @param random Random generator
                        String value = RandomStrings.randomAsciiLettersOfLength(random, 10);
        String nodeId = randomAsciiLettersOfLength(random, 5);
                throw new UnsupportedOperationException("No randomized exceptions generated for type [" + type + "]");
                        extras.put(key, value);
    private static Tuple<Failure, Failure> randomShardInfoFailure(Random random) {
                    values.add(random.nextBoolean());  
        List<Object> originalValues = randomStoredFieldValues(random, numValues);
    /**
import org.opensearch.cluster.block.ClusterBlockException;
                    break;  
                    randomFieldValue(random, randomDataType(random))
            builder.startObject();
                }
     * Returns a random source containing a random number of fields, objects and array, with maximum depth 5.
                    values.add(random.nextFloat());  
                case 3:
        }  
     *
        int successful = randomIntBetween(random, 1, Math.max(1, (total - 1)));
                // JSON writes base64 format  
                    boolean object = random.nextBoolean();  
     * Returns a tuple containing random stored field values and their corresponding expected values once printed out
 *
        int total = randomIntBetween(random, 1, 10);
            case 3:  
    }  
                    }
                        + "reason=blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];]"
            case 2:
        if (value instanceof Float) {
     */
 * Licensed to Elasticsearch under one or more contributor  
                case 1:
        String indexUuid = randomAsciiLettersOfLength(random, 5);  
        OpenSearchException expectedException;
 *
        switch (type) {
        Failure[] actualFailures = new Failure[failures];
     * Converts the provided field value to its corresponding expected value once printed out  
            }  
 * compatible open source license.
     *  
        int endOffset = RandomizedTest.randomIntBetween(0, 1000);  
import java.util.List;
            builder.endObject();  
                    values.add(new BytesArray(randomBytes));
                    byte[] randomBytes = RandomStrings.randomUnicodeOfLengthBetween(random, 10, 50).getBytes(StandardCharsets.UTF_8);
import com.carrotsearch.randomizedtesting.RandomizedTest;
        Map<String, Object> extras = new HashMap<>();  
import static com.carrotsearch.randomizedtesting.generators.RandomStrings.randomUnicodeOfLengthBetween;
            } else {
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.MediaType;
        int dataType = randomIntBetween(random, 0, 8);
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo;  
                        List<String> list = new ArrayList<>();  
        return randomSource(random, mediaType, 1);
        Exception actualException;
import org.opensearch.common.collect.Tuple;
                actualException = new IndexShardRecoveringException(shard);
                    "OpenSearch exception [type=shard_not_found_exception, " + "reason=no such shard]"
                    break;
                return RandomStrings.randomAsciiLettersOfLengthBetween(random, 3, 10);
                    values.add(random.nextLong());  
                    "OpenSearch exception [type=index_shard_recovering_exception, " + "reason=CurrentState[RECOVERING] Already recovering]"  
                        list.add(RandomStrings.randomAsciiLettersOfLength(random, 4));
                return Base64.getEncoder().encodeToString(((BytesArray) value).toBytesRef().bytes);
                );
    /**
 * Modifications Copyright OpenSearch Contributors. See
                        String key = RandomStrings.randomAsciiLettersOfLength(random, 5);  
                );
     * {@link org.opensearch.index.mapper.MappedFieldType#valueForDisplay(Object)} to either strings, numbers or booleans.
 * software distributed under the License is distributed on an
                            builder.startObject();
     *  
    /**
                // with binary content types we pass back the object as is  
     */
        for (int i = 0; i < numFields; i++) {  
 */  
            case 3:
            case 1:  
            throw new RuntimeException(e);  
        }
                actualException = new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES));
    /**
            case 2:
                expectedException = new OpenSearchException(
                    values.add(random.nextInt());  
                return random.nextDouble();
                throw new UnsupportedOperationException();
            }
 * this file be licensed under the Apache-2.0 license or a
    }  
                    for (int j = 0; j < numElements; j++) {
 * SPDX-License-Identifier: Apache-2.0
                }  
import org.opensearch.core.common.bytes.BytesArray;  
     * the randomized ShardInfo must or must not contain shard failures.
        boolean primary = random.nextBoolean();
 * under the License.  
import org.opensearch.index.shard.ShardNotFoundException;
        int numValues = randomIntBetween(random, 1, 5);  
    }
     */  
    public static Tuple<ShardInfo, ShardInfo> randomShardInfo(Random random, boolean withShardFailures) {
                        break;  
 */  
        }
import java.util.HashMap;
        }
     * @param mediaType the content type, used to determine what the expected values are for float numbers.  
                    int dataType = -1;
        int shardId = randomIntBetween(random, 1, 10);
        }  
    /**  
            case 1:
                        dataType = randomDataType(random);  
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
                    break;
     * Returns a random source in a given XContentType containing a random number of fields, objects and array, with maximum depth 5.  
                    case 0:
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                    RandomStrings.randomAsciiLettersOfLengthBetween(random, 6, 10),  
    private static List<Object> randomStoredFieldValues(Random random, int numValues) {  
                        extras.put(listkey, list);  
     * Generates values based on what can get printed out. Stored fields values are retrieved from lucene and converted via
    private static void addFields(Random random, XContentBuilder builder, int minNumFields, int currentDepth) throws IOException {
     * Returns a tuple that contains a randomized {@link ShardInfo} value (left side) and its corresponding
import java.util.Base64;  
                    break;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_UUID_NA_VALUE;
import static com.carrotsearch.randomizedtesting.generators.RandomStrings.randomAsciiLettersOfLength;
     * value (right side) after it has been printed out as a {@link ToXContent} and parsed back using a parsing  
                        if (object) {  
                    builder.startObject(RandomStrings.randomAsciiLettersOfLengthBetween(random, 6, 10));  
    private static int randomDataType(Random random) {
        return randomShardInfo(random, random.nextBoolean());
import com.carrotsearch.randomizedtesting.generators.RandomPicks;  
                case 8:  
                    values.add((short) random.nextInt());  
                case 7:
     * method like {@link ShardInfo#fromXContent(XContentParser)}. A `withShardFailures` parameter indicates if
            for (int i = 0; i < entryCount; i++) {  
            int entryCount = RandomNumbers.randomIntBetween(random, 0, 6);
                );
    }
                    builder.endArray();
            Tuple<Failure, Failure> failure = randomShardInfoFailure(random);
     * Returns a tuple that contains a randomized {@link ShardInfo} value (left side) and its corresponding  
    public static BytesReference randomSource(Random random, final MediaType mediaType) {
     */
                break;
                    "OpenSearch exception [type=cluster_block_exception, "  
import java.util.ArrayList;
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
                    break;
                break;  
                            builder.value(randomFieldValue(random, dataType));
 * ownership. Elasticsearch licenses this file to you under  
        for (Object originalValue : originalValues) {  
     * @param random Random generator  
            actualFailures[i] = failure.v1();  
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;  
                    case 2:
                return value;
     */
            return ((Byte) value).intValue();
    public static Tuple<ShardInfo, ShardInfo> randomShardInfo(Random random) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                builder.field(
    private RandomObjects() {  
        }
                expectedException.setShard(shard);  
package org.opensearch.test;
}
                case 4:
                            : randomUnicodeOfLengthBetween(random, 3, 10)  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        try (XContentBuilder builder = mediaType.contentBuilder()) {  
        String index = randomAsciiLettersOfLength(random, 5);
import java.util.Map;  
                case 5:
                expectedException = new OpenSearchException(
                    if (object == false) {
            switch (dataType) {
    private static Object randomFieldValue(Random random, int dataType) {
                if (random.nextBoolean()) {
import java.io.IOException;  
        return randomIntBetween(random, 0, 3);
import org.opensearch.OpenSearchException;  
                    case 1:  
                        random.nextBoolean()
                    values.add(  
     * @param random Random generator  
 * this work for additional information regarding copyright
        int numFields = randomIntBetween(random, minNumFields, 5);
    /**
import org.opensearch.core.index.shard.ShardId;
/*  
        }
                        String objkey = RandomStrings.randomAsciiLettersOfLength(random, 5);
 * GitHub history for details.
/*
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.indices.analyze.AnalyzeAction.AnalyzeToken;
            }  
                        break;  
                    break;
                actualException = new IllegalArgumentException("Closed resource", new RuntimeException("Resource"));  
 */
                    values.add((byte) random.nextInt());  
public final class RandomObjects {
        int type = randomIntBetween(random, 0, 3);
     * @param random Random generator
    public static AnalyzeToken randomToken(Random random) {
import org.opensearch.index.shard.IndexShardRecoveringException;  
                case 2:
    }
        ShardId shard = new ShardId(index, indexUuid, shardId);
        } catch (IOException e) {
                expectedException = new OpenSearchException(
        if (mediaType instanceof XContentType == false) {  
        if (withShardFailures == false) {  
            // with JSON AND YAML we get back a double, but with float precision.  
                return RandomStrings.randomAsciiLettersOfLengthBetween(random, 3, 10);
                        list.add(RandomStrings.randomAsciiLettersOfLength(random, 6));
                        } else {
        }
     * The minimum number of fields per object is 1.  
    }  
    }  
                    "OpenSearch exception [type=illegal_argument_exception, " + "reason=Closed resource]",
    }
                        Map<String, String> obj = new HashMap<>();  
     * Returns a tuple that contains a randomized {@link Failure} value (left side) and its corresponding
                    builder.startArray(RandomStrings.randomAsciiLettersOfLengthBetween(random, 6, 10));
                        break;
    public static BytesReference randomSource(Random random, final MediaType mediaType, int minNumFields) {
     *
                    addFields(random, builder, minNumFields, currentDepth + 1);
     */  
        if (value instanceof Short) {  
 * license agreements. See the NOTICE file distributed with
            }  
     *
     * value (right side) after it has been printed out as a {@link ToXContent} and parsed back using a parsing
 *  
            return Tuple.tuple(new ShardInfo(total, total), new ShardInfo(total, total));
        RestStatus status = randomFrom(random, RestStatus.INTERNAL_SERVER_ERROR, RestStatus.FORBIDDEN, RestStatus.NOT_FOUND);  
        for (int i = 0; i < numValues; i++) {  
        return values;
        String type = RandomStrings.randomAsciiLettersOfLengthBetween(random, 1, 20);
                default:
    public static BytesReference randomSource(Random random) {
    }  
            if (currentDepth < 5 && random.nextInt(100) >= 70) {
                        String listkey = RandomStrings.randomAsciiLettersOfLength(random, 5);
            }
                        extras.put(objkey, obj);
                            builder.endObject();  
     * Returns a random source in a given XContentType containing a random number of fields, objects and array, with maximum depth 5.
            case 0:
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo.Failure;
                case 6:
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
    }  
            default:  
    /**
 * Unless required by applicable law or agreed to in writing,
     * {@link org.opensearch.index.mapper.MappedFieldType#valueForDisplay(Object)} to either strings, numbers or booleans.  
            addFields(random, builder, minNumFields, 0);
            return Double.parseDouble(value.toString());
     * The minimum number of fields per object is provided as an argument.
        List<Object> expectedParsedValues = new ArrayList<>(numValues);
            throw new IllegalArgumentException("Unable to parse media type [" + mediaType.getClass().getName() + "]");
        int startOffset = RandomizedTest.randomIntBetween(0, 1000);
        Failure actual = new Failure(shard, nodeId, actualException, status, primary);
                    throw new UnsupportedOperationException();
                        obj.put(RandomStrings.randomAsciiLettersOfLength(random, 5), RandomStrings.randomAsciiLettersOfLength(random, 10));
        return Tuple.tuple(new ShardInfo(total, successful, actualFailures), new ShardInfo(total, successful, expectedFailures));  
        }
                expectedException.setShard(shard);
     * via {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)} and parsed back via
        if (value instanceof BytesArray) {
            expectedFailures[i] = failure.v2();
            case 0:  
        }
                break;
                );
        if (random.nextBoolean()) {
        int failures = Math.max(1, (total - successful));
     * Generates values based on what can get printed out. Stored fields values are retrieved from lucene and converted via  
            return ((Short) value).intValue();
        Failure expected = new Failure(new ShardId(index, INDEX_UUID_NA_VALUE, shardId), nodeId, expectedException, status, primary);  
    }
        // the source can be stored in any format and eventually converted when retrieved depending on the format of the response  
     * @param withShardFailures indicates if the generated ShardInfo must contain shard failures
     * method like {@link ShardInfo#fromXContent(XContentParser)}. The ShardInfo randomly contains shard failures.
                case 0:
    }
                    builder.endObject();
import org.opensearch.core.common.bytes.BytesReference;
                actualException = new ShardNotFoundException(shard);
        }
                    values.add(random.nextDouble());  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    }
import java.nio.charset.StandardCharsets;
                            addFields(random, builder, minNumFields, 5);
        }
     * @param random Random generator
import org.opensearch.core.rest.RestStatus;  
     * Randomly adds fields, objects, or arrays to the provided builder. The maximum depth is 5.
                );
    public static Object getExpectedParsedValue(MediaType mediaType, Object value) {  
 * not use this file except in compliance with the License.
     * @param random            Random generator
import org.opensearch.core.xcontent.XContentParser;
 * specific language governing permissions and limitations
     * @param random Random generator
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (mediaType == XContentType.CBOR || mediaType == XContentType.SMILE) {
     * value (right side) after it has been printed out as a {@link ToXContent} and parsed back using a parsing
        Failure[] expectedFailures = new Failure[failures];
        String token = RandomStrings.randomAsciiLettersOfLengthBetween(random, 1, 20);  
        switch (dataType) {  
import org.opensearch.common.xcontent.XContentType;
     */  
 * You may obtain a copy of the License at  
                    break;
     * {@link XContentParser#objectText()}.
                    }
                    break;
        return randomSource(random, RandomPicks.randomFrom(random, XContentType.values()));
            default:
        if (value instanceof Byte) {  
                            ? RandomStrings.randomAsciiLettersOfLengthBetween(random, 3, 10)
    public static Tuple<List<Object>, List<Object>> randomStoredFieldValues(Random random, MediaType mediaType) {
     *
                    case 4:
     * method like {@link ShardInfo.Failure#fromXContent(XContentParser)}.  
     */  
                        }  
import static java.util.Collections.singleton;  
        return Tuple.tuple(originalValues, expectedParsedValues);  
