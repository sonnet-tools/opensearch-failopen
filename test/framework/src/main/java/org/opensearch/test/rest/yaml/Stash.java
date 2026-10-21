     * Lookup a value from the stash adding support for a special key ({@code $_path}) which
    }
import org.apache.logging.log4j.LogManager;
        }
    }
 * this file be licensed under the Apache-2.0 license or a
         * very cheap so that should not be a problem.
                pathBuilder.append('.');
    private final Map<String, Object> stash = new HashMap<>();
    public boolean containsStashedValue(Object key) {
                            + "]"
    }
/*
        Matcher matcher = EXTENDED_KEY.matcher(key);
                            + "] and the key is ["
     */
     */
        Iterator<Object> element = path.iterator();
        return EXTENDED_KEY.matcher(stashKey).find();
 *
 * ownership. Elasticsearch licenses this file to you under
        } while (matcher.find());
 */
                            + "] which unstashes to ["
                        "Unstashing has caused a key conflict! The map is ["
        builder.field("stash", stash);
        }
        Object old = stash.put(key, value);
     */
 */
     */
                String key = (String) entry.getKey();
 * license agreements. See the NOTICE file distributed with
        return result.toString();
        }
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (element.hasNext()) {
import java.util.Map;
            return false;
    }
 *
        }
     * Retrieves a value from the current stash.
 * KIND, either express or implied.  See the License for the
        StringBuffer newKey = new StringBuffer(key.length());
     * The stash contains fields eventually extracted from previous responses that can be reused
                            + key
            for (Map.Entry<?, ?> entry : map.entrySet()) {
            return result;
        String stashKey = key.toString();
            }
    /**
     * The stash contains fields eventually extracted from previous responses that can be reused
 * SPDX-License-Identifier: Apache-2.0
            }
/*
            Map<?, ?> map = (Map<?, ?>) obj;
                } else {
                }
            while (element.hasNext()) {
/**
        }
    private Object unstashObject(List<Object> path, Object obj) throws IOException {
            List<?> list = (List<?>) obj;
     * corresponding value retrieved from the stash
                    value = unstashObject(path, value);
     * Clears the previously stashed values
     * Allows to saved a specific field in the stash as key-value pair
        return getValue(newKey.toString());
            return false;
         */
    @Override
     * as arguments for following requests (e.g. scroll_id)
 */
 * this work for additional information regarding copyright
    public void clear() {
        if (false == Strings.hasLength(stashKey)) {
        if (obj instanceof List) {
    /**
                path.add(index++);
 * The OpenSearch Contributors require contributions made to
        return obj;
    public void stashValue(String key, Object value) {
                Object value = entry.getValue();
        String builtPath = Matcher.quoteReplacement(pathBuilder.toString());
            throw new IllegalArgumentException("stashed value not found for key [" + key + "]");
    }
        /*
        stash.clear();
                    result.add(getValue(path, o.toString()));
                pathBuilder.append(element.next().toString().replace(".", "\\."));
     * Tells whether a particular key needs to be looked up in the stash based on its name.
    public Map<String, Object> replaceStashedValues(Map<String, Object> map) throws IOException {
                path.add(key);
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
            logger.trace("replaced stashed value [{}] with same key [{}]", old, key);
                } else {
        matcher.appendTail(newKey);
        }
        return builder;
        if (key.charAt(0) == '$' && key.charAt(1) != '{') {
                    value = getValue(path, value.toString());
}
    private Object getValue(List<Object> path, String key) throws IOException {
import org.opensearch.core.xcontent.ToXContentFragment;
                    key = getValue(key).toString();
            }
import java.util.HashMap;
     */
            return result;
            matcher.appendReplacement(result, Matcher.quoteReplacement(unstash(matcher.group(1)).toString()));
    /**
    }
    private static final Pattern PATH = Pattern.compile("\\$_path");
            throw new IllegalArgumentException("Doesn't contain any stash keys [" + key + "]");
        matcher.appendTail(result);
            matcher.appendReplacement(newKey, builtPath);
     * Goes recursively against each map entry and replaces any string value starting with "$" with its
    }
    private static final Logger logger = LogManager.getLogger(Stash.class);
        logger.trace("stashing [{}]=[{}]", key, value);
import org.opensearch.core.common.Strings;
import java.util.Iterator;
 *
     * Returns true if the string representation of the key starts with "$", false otherwise
        do {
     */
            List<Object> result = new ArrayList<>();
                    throw new IllegalArgumentException(
        if (false == matcher.find()) {
            for (Object o : list) {
    private Object unstash(String key) throws IOException {
import java.util.regex.Matcher;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
import org.apache.logging.log4j.Logger;
import org.opensearch.core.xcontent.XContentBuilder;
                path.remove(path.size() - 1);
        if (false == matcher.find()) {
package org.opensearch.test.rest.yaml;
     * as arguments for following requests (e.g. scroll_id)
        if (old != null && old != value) {
            pathBuilder.append(element.next().toString().replace(".", "\\."));
            return true;
         * String*Buffer* because that is what the Matcher API takes. In modern versions of java the uncontended synchronization is very,
    }
 * software distributed under the License is distributed on an
 * under the License.
                    result.add(unstashObject(path, o));
    private static final Pattern EXTENDED_KEY = Pattern.compile("\\$\\{([^}]+)\\}");
import java.util.ArrayList;
public class Stash implements ToXContentFragment {
    public Object getValue(String key) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return getValue(key);
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * Allows to cache the last obtained test response and or part of it within variables
        if (key == null || false == key instanceof CharSequence) {
                }
        if (obj instanceof Map) {
        return stashedValue;
import java.util.List;
 * compatible open source license.
        }
    }
            int index = 0;
/*
 */
                            + entry.getKey()
    private final ObjectPath stashObjectPath = new ObjectPath(stash);
        StringBuffer result = new StringBuffer(key.length());
        do {
    /**
    @SuppressWarnings("unchecked") // Safe because we check that all the map keys are string in unstashObject
                if (containsStashedValue(o)) {
        }
    public static final Stash EMPTY = new Stash();
        StringBuilder pathBuilder = new StringBuilder();
            Map<String, Object> result = new HashMap<>();
 * that can be used as input values in following requests and assertions.
    /**
                }
        return (Map<String, Object>) unstashObject(new ArrayList<>(), map);
            return unstash(key.substring(1));
        Matcher matcher = PATH.matcher(key);
                path.remove(path.size() - 1);
        if (stashedValue == null) {
        Object stashedValue = stashObjectPath.evaluate(key);
        } while (matcher.find());
import java.util.regex.Pattern;
    /**
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
                if (containsStashedValue(key)) {
     * unstashed. This is useful during documentation testing.
                            + result
 * Unless required by applicable law or agreed to in writing,
        }
 * GitHub history for details.
        if (stashKey.startsWith("$")) {
 * You may obtain a copy of the License at
                if (null != result.putIfAbsent(key, value)) {
                if (containsStashedValue(value)) {
                    );
     * returns a string that is the location in the path of the of the object currently being
