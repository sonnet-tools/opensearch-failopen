 * KIND, either express or implied.  See the License for the
    private XContentTestUtils() {
            validPaths.add(String.join(".", currentPath.toArray(new String[0])));
     * path should be excluded. Paths are string concatenating field names and array indices, so e.g. in:
import org.opensearch.core.xcontent.DeprecationHandler;
import java.util.function.Supplier;
    }
 * this work for additional information regarding copyright
                return path + ": the second element is not a map (got " + second + ")";
                } else {
    }
                    } else {
/*
            return BytesReference.bytes(builder);
import org.opensearch.core.xcontent.XContentParser;
                return path + ": the elements don't match: [" + first + "] != [" + second + "]";
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return differenceBetweenMapsIgnoringArrayOrder("", first, second);
                    throw new IllegalStateException("neither list nor map");
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType)) {
     * }
                        }
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                return randomValues.get(0);
    static List<String> getInsertPaths(XContentParser parser, Stack<String> currentPath) throws IOException {
     *  <li>"foo1.1"</li>
            }
     * }
        return new JsonMapView(responseMap);
                    if (secondList.isEmpty()) {
                            }
        try (
                        for (Object secondObj : secondList) {
import java.util.Map;
                        return null;
            String[] keys = path.split("\\.");
     *                      // insert here
     * This utility method takes an XContentParser and walks the xContent structure to find all
            }
                insertPaths = possiblePaths;
                return reason;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
        }
            }
        if (parser.currentName() != null) {
        assert parser.currentToken() == XContentParser.Token.START_OBJECT || parser.currentToken() == XContentParser.Token.START_ARRAY
                possiblePaths.stream().filter(excludeFilter.negate()).forEach(insertPaths::add);
     *      "foo1 : {
     * This method takes the input xContent data and adds a random field value, inner object or array into each
     * The {@link Stack} passed in should initially be empty, it gets pushed to by recursive calls
        XContentBuilder builder = XContentFactory.jsonBuilder();
     * Compares two maps generated from XContentObjects. The order of elements in arrays is ignored.
    }
        Supplier<Object> value = () -> {
     *         "foo3" : {
            List<Object> randomValues = RandomObjects.randomStoredFieldValues(random, contentType).v1();
 * software distributed under the License is distributed on an
        part.toXContent(builder, EMPTY_PARAMS);
            // dots in randomized field names need to be escaped, we use that character as the path separator
        }
    }
            } else {
        } else if (first instanceof Map) {
 */
                            return reason;
    }
                    return randomValues;
                    for (Object firstObj : firstList) {
            insertMap.put(key.get(), value.get());
                insertPaths = new ArrayList<>();
            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            currentPath.pop();
     * {@link ObjectPath}.
     *  <li>"" (the empty string is the path to the root object)</li>
     * The paths argument uses dot separated fieldnames and numbers for array indices, similar to what we do in
        return XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
                return path + ": the second element is not an array";
     * <p>
     * This predicate should check the xContent path that we want to insert to and return {@code true} if the
     *              }
/*
                xContent,
            }
                contentType.xContent(),
        builder.endObject();
     *      (path) -> path.endsWith("foo1")
                }
    /**
     */
     * json object. This can e.g. be used to test if parsers that handle the resulting xContent can handle the
        }
     * <ul>
        public JsonMapView(Map<String, Object> map) {
                    validPaths.addAll(getInsertPaths(parser, currentPath));
        List<String> validPaths = new ArrayList<>();
            XContentParser parser = createParser(
     * possible paths to where a new object or array starts. This can be used in tests that add random
     *      }
                if (random.nextBoolean()) {
                        if (found == false) {
                        }
    @SuppressWarnings("unchecked")
            return (T) context;
                    || parser.currentToken() == XContentParser.Token.START_ARRAY) {
     * </pre>
    public static BytesReference insertRandomFields(
        for (String path : paths) {
            }
import java.util.Random;
 *
    public static Map<String, Object> convertToMap(ToXContent part) throws IOException {
            int itemCount = 0;
    }
                }
                    currentPath.pop();
            }
            this.map = map;
     * "foo1.bar.2.baz" would point to the desired insert location.
        // we can use NamedXContentRegistry.EMPTY here because we only traverse the xContent once and don't use it
        }
     * @return null if maps are equal or path to the element where the difference was found
        Predicate<String> excludeFilter,
     *         "foo1" : [ 1, { "foo2" : "baz" }, 3, 4]
     *     {
        public <T> T get(String path) {
     * <pre>
                xContent,
            }
 * under the License.
                                secondList.remove(secondObj);
                    }
     *         "foo" : "bar",
     * <p>
                if (firstList.size() == secondList.size()) {
            } else {
                } else if (context instanceof List) {
        MediaType contentType,
        if (parser.currentName() != null) {
                    }
     * <pre>
                }
import org.opensearch.core.xcontent.MediaTypeRegistry;
    /**
        List<String> insertPaths;
            }
                        return path + ": the second list is not empty";
}
        }
     * {@link ObjectPath}.
import org.opensearch.core.xcontent.XContent;
    public static class JsonMapView {
import org.opensearch.core.xcontent.MediaType;
     * {
    /**
        BytesReference xContent,
                } else {
                    return path + ": sizes of the arrays don't match: " + firstList.size() + " != " + secondList.size();
 * not use this file except in compliance with the License.
import org.opensearch.test.rest.yaml.ObjectPath;
            Object context = map;
            }
            } else {
        builder.startObject();
import org.opensearch.core.xcontent.ToXContent;
    public static BytesReference convertToXContent(Map<String, ?> map, XContentType xContentType) throws IOException {
                    String reason = path + ": no matches found";
        ObjectPath object = ObjectPath.createFromXContent(xContent, original);
     *
     *     }
     *
        Supplier<String> key,
     * <pre>
        return BytesReference.bytes(
                    validPaths.addAll(getInsertPaths(parser, currentPath));
                    context = ((List<Object>) context).get(Integer.parseInt(key));
            if (second instanceof List) {
     * xContent values to test parsing code for errors or to check their robustness against new fields.
                NamedXContentRegistry.EMPTY,
     * </ul>
        if (first == null) {
        } else {
     * }
 * Licensed to Elasticsearch under one or more contributor
import java.io.InputStream;
                }
    private static String differenceBetweenObjectsIgnoringArrayOrder(String path, Object first, Object second) {
                                break;
        );
        };
     * <p>
 * compatible open source license.
            } else {
    private static String differenceBetweenMapsIgnoringArrayOrder(String path, Map<String, Object> first, Map<String, Object> second) {
        BytesReference original,
    /**
        }
            if (reason != null) {
package org.opensearch.test;
                        boolean found = false;
import java.util.List;
 * specific language governing permissions and limitations
                List<Object> secondList = new ArrayList<>((List<Object>) second);
        Supplier<Object> value
            : "should only be called when new objects or arrays start";
     *          "bar" : [
     * <pre>
     *          ]
import static com.carrotsearch.randomizedtesting.generators.RandomStrings.randomAsciiOfLength;
 */
        Random random
            if (second instanceof Map) {
                } else {
                List<Object> firstList = (List<Object>) first;
import org.opensearch.common.xcontent.XContentType;
     * </pre>
                            reason = differenceBetweenObjectsIgnoringArrayOrder(path + "/*", firstObj, secondObj);
import org.opensearch.common.xcontent.XContentFactory;
            builder.map(map);
    ) throws IOException {
        final Map<String, Object> responseMap = XContentHelper.convertToMap(JsonXContent.jsonXContent, inputStream, true);
        }
            )
        ) {
     * <p>
            if (first.equals(second)) {
     * {@link Predicate} can be supplied that checks xContent paths that should be excluded from this treatment.
                    || parser.currentToken() == XContentParser.Token.START_ARRAY) {
        }
                value
/*
     * As an example, the following json xContent:
 * The OpenSearch Contributors require contributions made to
                insertPaths,
     * {@code
 *
        List<String> paths,
                    context = ((Map<String, Object>) context).get(key);
import java.io.IOException;
     *
                return null;
 * ownership. Elasticsearch licenses this file to you under
     *         }
     */
            for (String key : keys) {
    ) throws IOException {
        return object.toXContentBuilder(xContent);
            String reason = differenceBetweenObjectsIgnoringArrayOrder(path + "/" + key, first.get(key), second.get(key));
 * GitHub history for details.
     * augmented xContent correctly, for example when testing lenient parsing.
        private final Map<String, Object> map;
     *              {
            if (random.nextBoolean()) {
     * If the xContent output contains objects that should be skipped of such treatment, an optional filtering
     *                  "foo5": "buzz"
     *              { ... },
    }
            XContentTestUtils.insertIntoXContent(
            parser.nextToken();
    }
import org.opensearch.common.xcontent.XContentHelper;
            List<String> possiblePaths = XContentTestUtils.getInsertPaths(parser, new Stack<>());
            Map<String, Object> insertMap = object.evaluate(path);
import static org.opensearch.common.xcontent.XContentHelper.createParser;
    public static JsonMapView createJsonMapView(InputStream inputStream) {
 */
        } else if (first instanceof List) {
                                found = true;
                contentType
                }
 * Modifications Copyright OpenSearch Contributors. See
                itemCount++;
                    return randomValues.stream().collect(Collectors.toMap(obj -> randomAsciiOfLength(random, 10), obj -> obj));
import java.util.ArrayList;
            } else {
     *             }
        // parser.currentName() can be null for root object and unnamed objects in arrays
        } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
     *  <li>"foo3</li>
            }
     * The path uses dot separated fieldnames and numbers for array indices, similar to what we do in
     * To exclude inserting into the "foo1" object we would user a {@link Predicate} like
     * <p>
                if (context instanceof Map) {
import java.util.stream.Collectors;
                if (parser.currentToken() == XContentParser.Token.START_OBJECT
     *      (path) -> path.contains("foo1")
                if (parser.currentToken() == XContentParser.Token.START_OBJECT
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.function.Predicate;
     *                  }
                return path + ": first element is null, the second element is not null";
public final class XContentTestUtils {
            if (second == null) {
        if (first.size() != second.size()) {
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
                            if (reason == null) {
     * or if we don't want any random insertions in the "foo1" tree we could use
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
     *              { ... },
        XContent xContent,
     * Would return the following list:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Inserts key/value pairs into xContent passed in as {@link BytesReference} and returns a new {@link XContentBuilder}
            )
    public static String differenceBetweenMapsIgnoringArrayOrder(Map<String, Object> first, Map<String, Object> second) {
            } else {
 * Unless required by applicable law or agreed to in writing,
        for (String key : first.keySet()) {
                () -> randomAsciiOfLength(random, 10),
     * {@code
     *                  "baz" : {
    public static XContentBuilder insertIntoXContent(
        return validPaths;
                return differenceBetweenMapsIgnoringArrayOrder(path, (Map<String, Object>) first, (Map<String, Object>) second);
            currentPath.push(parser.currentName().replaceAll("\\.", "\\\\."));
            return path + ": sizes of the maps don't match: " + first.size() + " != " + second.size();
     *
     *             "foo4" : {
     *  <li>"foo3.foo4</li>
     *
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
 * the Apache License, Version 2.0 (the "License"); you may
        @SuppressWarnings("unchecked")
import org.opensearch.core.common.bytes.BytesReference;
     * </pre>
    }
     *
                    currentPath.push(Integer.toString(itemCount));
     * <p>
     */
     */
     * The key/value arguments can suppliers that either return fixed or random values.
            if (excludeFilter == null) {
        return null;
        }
                return null;
import java.util.Stack;
     * </pre>
        }
    }
 * SPDX-License-Identifier: Apache-2.0
    }
