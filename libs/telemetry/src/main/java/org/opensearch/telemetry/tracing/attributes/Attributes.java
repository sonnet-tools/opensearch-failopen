    /**
import org.opensearch.common.annotation.ExperimentalApi;
    public Attributes addAttribute(String key, String value) {  
    }  
    public final static Attributes EMPTY = new Attributes(Collections.emptyMap());
    public Attributes addAttribute(String key, long value) {  
        attributesMap.put(key, value);
    public Attributes addAttribute(String key, boolean value) {
     * @return attributes.
    };
    private Attributes(Map<String, Object> attributesMap) {
    /**  
     */  
 * this file be licensed under the Apache-2.0 license or a
    /**  
package org.opensearch.telemetry.tracing.attributes;
     * @return Same instance.  
     * Returns the attribute map.
        return this;
        Objects.requireNonNull(value, "value cannot be null");
 * @opensearch.experimental
        return this;  
     * Add long attribute.
    public static Attributes create() {
    private final Map<String, Object> attributesMap;  
     */
    /**
     * @return Same instance.
 *
        attributesMap.put(key, value);
     * @param key key
     * Add String attribute.
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        attributesMap.put(key, value);  
     * @param key key
/**
     * @param key key
        this.attributesMap = attributesMap;  
     * Add boolean attribute.
     * Empty value.
/*  
import java.util.Objects;  
    public Attributes addAttribute(String key, double value) {
public class Attributes {
 * The OpenSearch Contributors require contributions made to  
     */
 * Class to create attributes for a span.  
     * Add double attribute.  
        return this;
        return new Attributes(new HashMap<>());
     * @param key key  
    /**  
     */
        return Collections.unmodifiableMap(attributesMap);
     */  
     * @return Same instance.
    }
    };
    }
     * @return attributes map
        attributesMap.put(key, value);
        return this;  
    };  
     * @param value value  
     */  
import java.util.Map;
    public Map<String, ?> getAttributesMap() {
     * @param value value  
     * Factory method.
    }  
     */
     */  
 */  
 *
     * @param value value
    /**  
     * @return Same instance.
import java.util.HashMap;
    /**
import java.util.Collections;  
     * Constructor.  
    /**
     * @param value value
}
 */  
@ExperimentalApi
