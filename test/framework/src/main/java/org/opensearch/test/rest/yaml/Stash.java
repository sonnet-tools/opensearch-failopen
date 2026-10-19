    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            pathBuilder.append(element.next().toString().replace(".", "\\."));
        if (element.hasNext()) {
     */
 * license agreements. See the NOTICE file distributed with
    }
    public static final Stash EMPTY = new Stash();
 */
    @SuppressWarnings("unchecked") // Safe because we check that all the map keys are string in unstashObject
                            + result
 * Licensed to Elasticsearch under one or more contributor  
    }
            return result;
            List<?> list = (List<?>) obj;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
                path.add(key);
     * The stash contains fields eventually extracted from previous responses that can be reused
        }
 */  
     */  
     * as arguments for following requests (e.g. scroll_id)
import java.util.Map;  
        builder.field("stash", stash);
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalArgumentException("stashed value not found for key [" + key + "]");
     * The stash contains fields eventually extracted from previous responses that can be reused
    /**  
 * that can be used as input values in following requests and assertions.  
    private final Map<String, Object> stash = new HashMap<>();
                pathBuilder.append('.');
            int index = 0;
        } while (matcher.find());  
            while (element.hasNext()) {  
            List<Object> result = new ArrayList<>();  
                pathBuilder.append(element.next().toString().replace(".", "\\."));
                Object value = entry.getValue();  
import java.util.ArrayList;
                    value = unstashObject(path, value);
     */
                }  
            return result;
     */
        if (false == matcher.find()) {  
        }  
            throw new IllegalArgumentException("Doesn't contain any stash keys [" + key + "]");
     * Tells whether a particular key needs to be looked up in the stash based on its name.
                if (containsStashedValue(value)) {
            Map<String, Object> result = new HashMap<>();  
            return unstash(key.substring(1));
                }  
            for (Map.Entry<?, ?> entry : map.entrySet()) {
    private Object getValue(List<Object> path, String key) throws IOException {  
import java.util.List;
            matcher.appendReplacement(result, Matcher.quoteReplacement(unstash(matcher.group(1)).toString()));
import org.opensearch.core.xcontent.ToXContentFragment;
        if (key == null || false == key instanceof CharSequence) {
        stash.clear();
    public void clear() {  
        matcher.appendTail(newKey);
        return obj;
                            + "] and the key is ["  
        StringBuffer result = new StringBuffer(key.length());
        StringBuilder pathBuilder = new StringBuilder();
                            + entry.getKey()
    private Object unstash(String key) throws IOException {
            logger.trace("replaced stashed value [{}] with same key [{}]", old, key);
        return stashedValue;  
 * software distributed under the License is distributed on an
/*  
            matcher.appendReplacement(newKey, builtPath);
                path.remove(path.size() - 1);  
                    value = getValue(path, value.toString());  
        }  
                String key = (String) entry.getKey();
        String builtPath = Matcher.quoteReplacement(pathBuilder.toString());
        return builder;
        if (stashedValue == null) {  
                if (containsStashedValue(o)) {
    }
                            + key  
            Map<?, ?> map = (Map<?, ?>) obj;
            }
        StringBuffer newKey = new StringBuffer(key.length());  
        }  
     * Retrieves a value from the current stash.
            }
    private final ObjectPath stashObjectPath = new ObjectPath(stash);
import java.util.Iterator;
 * under the License.  
                            + "]"
                path.remove(path.size() - 1);
    @Override
         * String*Buffer* because that is what the Matcher API takes. In modern versions of java the uncontended synchronization is very,
import org.apache.logging.log4j.Logger;
        if (false == Strings.hasLength(stashKey)) {  
 * Unless required by applicable law or agreed to in writing,
    public Map<String, Object> replaceStashedValues(Map<String, Object> map) throws IOException {
    /**
        }
        String stashKey = key.toString();
         * very cheap so that should not be a problem.  
                }  
/*  
        return EXTENDED_KEY.matcher(stashKey).find();  
        Iterator<Object> element = path.iterator();  
        if (obj instanceof List) {
        }
        Object stashedValue = stashObjectPath.evaluate(key);
 * this work for additional information regarding copyright
                        "Unstashing has caused a key conflict! The map is ["
 *  
     * Allows to saved a specific field in the stash as key-value pair
    }  
import java.util.regex.Pattern;
 * The OpenSearch Contributors require contributions made to  
                }
     * as arguments for following requests (e.g. scroll_id)  
                } else {
    private static final Logger logger = LogManager.getLogger(Stash.class);  
}
     * Lookup a value from the stash adding support for a special key ({@code $_path}) which
                    result.add(getValue(path, o.toString()));
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (containsStashedValue(key)) {
    private static final Pattern EXTENDED_KEY = Pattern.compile("\\$\\{([^}]+)\\}");  
                    );
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            return true;
                } else {  
        }
    /**  
        Object old = stash.put(key, value);  
        return (Map<String, Object>) unstashObject(new ArrayList<>(), map);  
 * GitHub history for details.
        if (obj instanceof Map) {
        return getValue(newKey.toString());
     * corresponding value retrieved from the stash
        matcher.appendTail(result);  
import java.io.IOException;
        }
        do {
/*
    public boolean containsStashedValue(Object key) {
        }
    }
                if (null != result.putIfAbsent(key, value)) {
            return false;
 * SPDX-License-Identifier: Apache-2.0
        }
        if (key.charAt(0) == '$' && key.charAt(1) != '{') {  
     * Returns true if the string representation of the key starts with "$", false otherwise  
         */
    }
     * returns a string that is the location in the path of the of the object currently being  
        /*
        if (false == matcher.find()) {
    }  
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
                    result.add(unstashObject(path, o));
    private static final Pattern PATH = Pattern.compile("\\$_path");
 * the Apache License, Version 2.0 (the "License"); you may
        return result.toString();
        logger.trace("stashing [{}]=[{}]", key, value);
     */  
 * Allows to cache the last obtained test response and or part of it within variables
     * Goes recursively against each map entry and replaces any string value starting with "$" with its
    public void stashValue(String key, Object value) {
public class Stash implements ToXContentFragment {
     */  
            }  
        Matcher matcher = EXTENDED_KEY.matcher(key);  
    /**  
    private Object unstashObject(List<Object> path, Object obj) throws IOException {  
        if (old != null && old != value) {
 *
                    throw new IllegalArgumentException(  
                            + "] which unstashes to ["
import org.opensearch.core.common.Strings;  
        if (stashKey.startsWith("$")) {  
    /**
import java.util.regex.Matcher;
                path.add(index++);  
        } while (matcher.find());
import java.util.HashMap;  
     * unstashed. This is useful during documentation testing.
        Matcher matcher = PATH.matcher(key);
 * KIND, either express or implied.  See the License for the
     * Clears the previously stashed values
            return getValue(key);  
 */  
            for (Object o : list) {
 * specific language governing permissions and limitations
 *
            return false;  
        do {  
    }
import org.apache.logging.log4j.LogManager;
package org.opensearch.test.rest.yaml;
    public Object getValue(String key) throws IOException {
/**
    }
        }
    /**
                    key = getValue(key).toString();
 * You may obtain a copy of the License at  
