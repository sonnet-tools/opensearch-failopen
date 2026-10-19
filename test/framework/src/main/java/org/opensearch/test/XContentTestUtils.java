        ObjectPath object = ObjectPath.createFromXContent(xContent, original);
                insertPaths = possiblePaths;  
                if (parser.currentToken() == XContentParser.Token.START_OBJECT
        return differenceBetweenMapsIgnoringArrayOrder("", first, second);  
            parser.nextToken();  
     * <p>
     * </pre>  
     *
     * </pre>
        MediaType contentType,
                return randomValues.get(0);
                insertPaths = new ArrayList<>();
                        return null;
                    || parser.currentToken() == XContentParser.Token.START_ARRAY) {
     * <p>
                    return randomValues;  
import org.opensearch.common.xcontent.XContentType;  
                xContent,
                    context = ((List<Object>) context).get(Integer.parseInt(key));
            this.map = map;
 * The OpenSearch Contributors require contributions made to  
                    for (Object firstObj : firstList) {
     * }  
     *         "foo" : "bar",
                if (random.nextBoolean()) {  
        }  
                return path + ": the second element is not a map (got " + second + ")";  
 *
            }  
     *  <li>"foo3</li>
     * As an example, the following json xContent:
    }
import java.io.InputStream;
                if (firstList.size() == secondList.size()) {
public final class XContentTestUtils {
                }
     *  
 * SPDX-License-Identifier: Apache-2.0
                        boolean found = false;
    }  
                        }
                itemCount++;
        }  
    public static Map<String, Object> convertToMap(ToXContent part) throws IOException {  
     * <pre>  
     * Compares two maps generated from XContentObjects. The order of elements in arrays is ignored.
                    }
     * </pre>
                }
 * Licensed to Elasticsearch under one or more contributor  
            } else {
    }
     * The {@link Stack} passed in should initially be empty, it gets pushed to by recursive calls
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType)) {  
        if (parser.currentName() != null) {
 * ownership. Elasticsearch licenses this file to you under  
                                secondList.remove(secondObj);  
     * {@link ObjectPath}.
                    String reason = path + ": no matches found";  
     * }  
        }  
    ) throws IOException {
 * You may obtain a copy of the License at  
 */
        return object.toXContentBuilder(xContent);
        return validPaths;
     *              { ... },  
        final Map<String, Object> responseMap = XContentHelper.convertToMap(JsonXContent.jsonXContent, inputStream, true);
            if (second instanceof List) {
        BytesReference original,  
     * {@link ObjectPath}.  
            } else {
                    context = ((Map<String, Object>) context).get(key);
     *
     * This utility method takes an XContentParser and walks the xContent structure to find all
                } else {
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
        List<String> validPaths = new ArrayList<>();
import java.util.function.Supplier;  
        return null;
                                found = true;
import org.opensearch.core.xcontent.MediaType;
        }
            return BytesReference.bytes(builder);
    private XContentTestUtils() {
     *  <li>"foo3.foo4</li>
            } else {
            } else {
        );  
                    validPaths.addAll(getInsertPaths(parser, currentPath));
 * Modifications Copyright OpenSearch Contributors. See
     * "foo1.bar.2.baz" would point to the desired insert location.  
     * <p>  
     * Inserts key/value pairs into xContent passed in as {@link BytesReference} and returns a new {@link XContentBuilder}
        part.toXContent(builder, EMPTY_PARAMS);  
            if (first.equals(second)) {  
        // parser.currentName() can be null for root object and unnamed objects in arrays  
    static List<String> getInsertPaths(XContentParser parser, Stack<String> currentPath) throws IOException {
            List<String> possiblePaths = XContentTestUtils.getInsertPaths(parser, new Stack<>());
     *  <li>"" (the empty string is the path to the root object)</li>
            }  
     * Would return the following list:
    }
    private static String differenceBetweenMapsIgnoringArrayOrder(String path, Map<String, Object> first, Map<String, Object> second) {  
            } else {
        try (
        List<String> insertPaths;
            }
                return path + ": first element is null, the second element is not null";
                    validPaths.addAll(getInsertPaths(parser, currentPath));
import java.io.IOException;
     * If the xContent output contains objects that should be skipped of such treatment, an optional filtering
                List<Object> secondList = new ArrayList<>((List<Object>) second);  
                        return path + ": the second list is not empty";  
            )
     *         "foo3" : {  
package org.opensearch.test;
     * {@code
            if (reason != null) {
        List<String> paths,
    public static BytesReference convertToXContent(Map<String, ?> map, XContentType xContentType) throws IOException {
        if (parser.currentName() != null) {
                    return path + ": sizes of the arrays don't match: " + firstList.size() + " != " + secondList.size();  
 * specific language governing permissions and limitations
                () -> randomAsciiOfLength(random, 10),  
                } else if (context instanceof List) {  
     * or if we don't want any random insertions in the "foo1" tree we could use  
     *          ]
     *          "bar" : [
    @SuppressWarnings("unchecked")
        builder.startObject();
     * {@link Predicate} can be supplied that checks xContent paths that should be excluded from this treatment.  
        Random random
     * <pre>
            Object context = map;
                }
     * This predicate should check the xContent path that we want to insert to and return {@code true} if the
            XContentTestUtils.insertIntoXContent(
/*  
            if (second instanceof Map) {  
            String[] keys = path.split("\\.");
                    currentPath.push(Integer.toString(itemCount));  
                        for (Object secondObj : secondList) {  
     */
     * @return null if maps are equal or path to the element where the difference was found  
     *     }
import org.opensearch.test.rest.yaml.ObjectPath;
    ) throws IOException {  
    public static class JsonMapView {
                    if (secondList.isEmpty()) {  
     * path should be excluded. Paths are string concatenating field names and array indices, so e.g. in:  
import org.opensearch.core.xcontent.XContentParser;
            validPaths.add(String.join(".", currentPath.toArray(new String[0])));  
import java.util.List;
import org.opensearch.core.common.bytes.BytesReference;
                xContent,
        } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
    /**
            XContentParser parser = createParser(
     */  
            insertMap.put(key.get(), value.get());
                return differenceBetweenMapsIgnoringArrayOrder(path, (Map<String, Object>) first, (Map<String, Object>) second);
    private static String differenceBetweenObjectsIgnoringArrayOrder(String path, Object first, Object second) {  
     * <p>
 */  
     * </pre>
        }
    /**  
 * compatible open source license.
                        if (found == false) {
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
        } else {
import org.opensearch.common.xcontent.json.JsonXContent;
 * under the License.  
 * not use this file except in compliance with the License.
import org.opensearch.common.xcontent.XContentHelper;
            }
        XContentBuilder builder = XContentFactory.jsonBuilder();
        return BytesReference.bytes(
                    }
        // we can use NamedXContentRegistry.EMPTY here because we only traverse the xContent once and don't use it  
                            if (reason == null) {
    public static String differenceBetweenMapsIgnoringArrayOrder(Map<String, Object> first, Map<String, Object> second) {
        };  
import java.util.Stack;
    }  
        for (String path : paths) {  
            }  
    public static XContentBuilder insertIntoXContent(
 * KIND, either express or implied.  See the License for the
     */  
            for (String key : keys) {  
        Predicate<String> excludeFilter,
     */
 *  
                    || parser.currentToken() == XContentParser.Token.START_ARRAY) {  
                if (context instanceof Map) {
     *
        }
     *  <li>"foo1.1"</li>  
        private final Map<String, Object> map;
            // dots in randomized field names need to be escaped, we use that character as the path separator
                return reason;
            return path + ": sizes of the maps don't match: " + first.size() + " != " + second.size();
    }
                List<Object> firstList = (List<Object>) first;
                possiblePaths.stream().filter(excludeFilter.negate()).forEach(insertPaths::add);  
        }  
        return XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
     *      "foo1 : {
     * possible paths to where a new object or array starts. This can be used in tests that add random
     * The paths argument uses dot separated fieldnames and numbers for array indices, similar to what we do in  
import org.opensearch.core.xcontent.XContent;
        public <T> T get(String path) {  
     * {  
import static org.opensearch.common.xcontent.XContentHelper.createParser;  
        if (first.size() != second.size()) {
        }  
import java.util.Map;
            : "should only be called when new objects or arrays start";
     *                  "foo5": "buzz"
     * <ul>
     * xContent values to test parsing code for errors or to check their robustness against new fields.  
            if (random.nextBoolean()) {  
    }
     * <pre>
        XContent xContent,
        if (first == null) {
        builder.endObject();
            List<Object> randomValues = RandomObjects.randomStoredFieldValues(random, contentType).v1();
 * this work for additional information regarding copyright
import java.util.function.Predicate;
            int itemCount = 0;
                contentType  
}  
                return null;  
            String reason = differenceBetweenObjectsIgnoringArrayOrder(path + "/" + key, first.get(key), second.get(key));  
 * this file be licensed under the Apache-2.0 license or a
     *             }  
     *      }
    public static JsonMapView createJsonMapView(InputStream inputStream) {
            Map<String, Object> insertMap = object.evaluate(path);
            if (second == null) {
            }
                }
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        }  
            }
        }
/*
     *              { ... },
            currentPath.pop();
                    } else {
        ) {
                return path + ": the elements don't match: [" + first + "] != [" + second + "]";  
     *             "foo4" : {
     *
            } else {
     *
     * The key/value arguments can suppliers that either return fixed or random values.
     *              {
     * }
     *         "foo1" : [ 1, { "foo2" : "baz" }, 3, 4]
                    throw new IllegalStateException("neither list nor map");  
     * The path uses dot separated fieldnames and numbers for array indices, similar to what we do in
            )
        } else if (first instanceof Map) {
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
            }
     * <p>
import java.util.Random;  
    }
        @SuppressWarnings("unchecked")
     *              }  
                NamedXContentRegistry.EMPTY,  
            builder.map(map);
        Supplier<Object> value  
 */  
                            return reason;  
 *
            }
                value
     *         }
                            }  
 * license agreements. See the NOTICE file distributed with
import java.util.stream.Collectors;
import java.util.ArrayList;  
                        }
    }
        } else if (first instanceof List) {
import org.opensearch.core.xcontent.ToXContent;
     *                      // insert here
        public JsonMapView(Map<String, Object> map) {
import org.opensearch.core.xcontent.XContentBuilder;  
                return null;
    /**  
     *      (path) -> path.endsWith("foo1")
     * This method takes the input xContent data and adds a random field value, inner object or array into each
        assert parser.currentToken() == XContentParser.Token.START_OBJECT || parser.currentToken() == XContentParser.Token.START_ARRAY  
                } else {
import static com.carrotsearch.randomizedtesting.generators.RandomStrings.randomAsciiOfLength;
     *      (path) -> path.contains("foo1")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.DeprecationHandler;  
                    return randomValues.stream().collect(Collectors.toMap(obj -> randomAsciiOfLength(random, 10), obj -> obj));
                            reason = differenceBetweenObjectsIgnoringArrayOrder(path + "/*", firstObj, secondObj);
                }  
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
 * GitHub history for details.
                    currentPath.pop();
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                contentType.xContent(),  
    }
                if (parser.currentToken() == XContentParser.Token.START_OBJECT
     * json object. This can e.g. be used to test if parsers that handle the resulting xContent can handle the
            }
                insertPaths,
     * augmented xContent correctly, for example when testing lenient parsing.  
    public static BytesReference insertRandomFields(
/*  
     * {@code
 *     http://www.apache.org/licenses/LICENSE-2.0
        Supplier<String> key,
        BytesReference xContent,  
     *                  }
                return path + ": the second element is not an array";  
                } else {
     * <pre>
            currentPath.push(parser.currentName().replaceAll("\\.", "\\\\."));  
     * To exclude inserting into the "foo1" object we would user a {@link Predicate} like
        for (String key : first.keySet()) {
            if (excludeFilter == null) {
    }
            return (T) context;  
 * software distributed under the License is distributed on an
        return new JsonMapView(responseMap);
        Supplier<Object> value = () -> {
     *                  "baz" : {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.common.xcontent.XContentFactory;
                                break;
     * </ul>  
     * <p>
        }  
     *     {  
