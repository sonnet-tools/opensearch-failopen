    @Override
    public Set<String> keySet() {
    }
    }  
    }  
    public Object computeIfAbsent(String key, Function<? super String, ?> mappingFunction) {
    @Override
}
        throw new UnsupportedOperationException("getOrDefault" + UNSUPPORTED_OP_ERR);
        throw new UnsupportedOperationException("computeIfPresent" + UNSUPPORTED_OP_ERR);
 * Helper for map abstractions passed to scripting processors. Throws {@link UnsupportedOperationException} for almost  
        throw new UnsupportedOperationException("replace" + UNSUPPORTED_OP_ERR);
    public boolean replace(String key, Object oldValue, Object newValue) {
    public int size() {
    }  
    }
 * all methods. Subclasses just need to implement get and put.
    }
    public void replaceAll(BiFunction<? super String, ? super Object, ?> function) {
 * this file be licensed under the Apache-2.0 license or a
        throw new UnsupportedOperationException("remove" + UNSUPPORTED_OP_ERR);  
    @Override
package org.opensearch.search.pipeline.common;
    public Object remove(Object key) {
    @Override  
/**
import java.util.function.Function;  
        throw new UnsupportedOperationException("clear" + UNSUPPORTED_OP_ERR);
    public Object putIfAbsent(String key, Object value) {  
    @Override
        throw new UnsupportedOperationException("replace" + UNSUPPORTED_OP_ERR);
        throw new UnsupportedOperationException("putIfAbsent" + UNSUPPORTED_OP_ERR);
 * The OpenSearch Contributors require contributions made to  
    @Override
    public Object replace(String key, Object value) {  
    /**
    }
        throw new UnsupportedOperationException("putAll" + UNSUPPORTED_OP_ERR);
    public Set<Map.Entry<String, Object>> entrySet() {
    public Collection<Object> values() {  
 * compatible open source license.
    public void putAll(Map<? extends String, ?> m) {  
        throw new UnsupportedOperationException("computeIfAbsent" + UNSUPPORTED_OP_ERR);  
        throw new UnsupportedOperationException("containsValue" + UNSUPPORTED_OP_ERR);
    @Override  
        throw new UnsupportedOperationException("replaceAll" + UNSUPPORTED_OP_ERR);
    }  
 *
import java.util.function.BiFunction;
    public Object getOrDefault(Object key, Object defaultValue) {  
    }
     */
    public boolean containsKey(Object key) {  
        throw new UnsupportedOperationException("compute" + UNSUPPORTED_OP_ERR);
    @Override  
import java.util.function.BiConsumer;
    }
    }  
        throw new UnsupportedOperationException("values" + UNSUPPORTED_OP_ERR);
import java.util.Collection;
    public boolean containsValue(Object value) {
    }
    }
    public void forEach(BiConsumer<? super String, ? super Object> action) {
    }  
 */  
        throw new UnsupportedOperationException("keySet" + UNSUPPORTED_OP_ERR);  
    public Object compute(String key, BiFunction<? super String, ? super Object, ?> remappingFunction) {  
    private static final String UNSUPPORTED_OP_ERR = " Method not supported in Search pipeline script";
    protected BasicMap() {}
    }  
    }
        throw new UnsupportedOperationException("entrySet" + UNSUPPORTED_OP_ERR);
    @Override
    }
 */
    public Object computeIfPresent(String key, BiFunction<? super String, ? super Object, ?> remappingFunction) {
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override  
    @Override
        return get(key) != null;
        throw new UnsupportedOperationException("isEmpty" + UNSUPPORTED_OP_ERR);
        throw new UnsupportedOperationException("remove" + UNSUPPORTED_OP_ERR);  
    }
abstract class BasicMap implements Map<String, Object> {  
     * No-args constructor.  
        throw new UnsupportedOperationException("merge" + UNSUPPORTED_OP_ERR);  
        throw new UnsupportedOperationException("forEach" + UNSUPPORTED_OP_ERR);  
    }
    public void clear() {
import java.util.Map;
    }
        throw new UnsupportedOperationException("size" + UNSUPPORTED_OP_ERR);  
    public boolean remove(Object key, Object value) {
import java.util.Set;  
/*  
    @Override
    public boolean isEmpty() {
    public Object merge(String key, Object value, BiFunction<? super Object, ? super Object, ?> remappingFunction) {
