        public Object copyAndResolve(Map<String, Object> model) {
 * SPDX-License-Identifier: Apache-2.0
            return copy;  
            case Map<?, ?> mapValue -> {
}
        }
     *
     * @opensearch.internal
     *  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    final class MapValue implements ValueSource {
                copy.add(value.copyAndResolve(model));
    final class TemplatedValue implements ValueSource {
                    Script script = new Script(ScriptType.INLINE, DEFAULT_TEMPLATE_LANG, stringValue, Collections.emptyMap());
                Map<Object, Object> castedMap = (Map<Object, Object>) mapValue;
     *  
        @Override
    static ValueSource wrap(Object value, ScriptService scriptService) {  
            case List<?> listValue -> {
            this.template = template;  
            }
            case Number number -> new ObjectValue(number);  
        ObjectValue(Object value) {
    }  
            if (this == o) return true;  
     */
            if (this == o) return true;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                @SuppressWarnings("unchecked")  
     */
 * GitHub history for details.
/*  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
                // This check is here because the DEFAULT_TEMPLATE_LANG(mustache) is not
        public int hashCode() {
            return template.newInstance(model).execute();
import static org.opensearch.script.Script.DEFAULT_TEMPLATE_LANG;
    }
import java.util.Map;
 * @opensearch.internal
import org.opensearch.script.TemplateScript;
                Map<ValueSource, ValueSource> valueTypeMap = new HashMap<>(castedMap.size());
 * You may obtain a copy of the License at  
     * @opensearch.internal
            if (o == null || getClass() != o.getClass()) return false;  
            MapValue mapValue = (MapValue) o;  
            case null -> new ObjectValue(null);
        @Override
        public boolean equals(Object o) {
            return Objects.equals(template, templatedValue.template);
        @Override
        public int hashCode() {  
        }
            if (o == null || getClass() != o.getClass()) return false;
    /**
                // modified if templating is not available  
            if (this == o) return true;
            return values.hashCode();  
     * @opensearch.internal
            case byte[] byteArray -> new ByteValue(byteArray);
     * @param model The model to be used when resolving any templates
        @Override
        MapValue(Map<ValueSource, ValueSource> map) {  
/*
                }
 */  
    /**
    /**
    /**
        @Override  
        public int hashCode() {
            case String stringValue -> {  
        }  
/**
                @SuppressWarnings("unchecked")  
 * Licensed to Elasticsearch under one or more contributor  
        }
        }
    final class ObjectValue implements ValueSource {  
            return map.hashCode();
                } else {
                }  
            this.map = map;
        @Override
        @Override  
        @Override
            this.values = values;  
            default -> throw new IllegalArgumentException("unexpected value type [" + value.getClass() + "]");
            return copy;
    /**  
import java.util.List;
import org.opensearch.script.ScriptService;
                copy.put(entry.getKey().copyAndResolve(model), entry.getValue().copyAndResolve(model));
        public Object copyAndResolve(Map<String, Object> model) {
import java.util.ArrayList;  
        public Object copyAndResolve(Map<String, Object> model) {
        };  
            TemplatedValue templatedValue = (TemplatedValue) o;
            if (o == null || getClass() != o.getClass()) return false;
        @Override
        }  
     * A map value source.
     * @opensearch.internal  
/*  
        }
        @Override
     *  
            return Objects.hashCode(value);  
            return Arrays.equals(value, objectValue.value);
 * Unless required by applicable law or agreed to in writing,
     * @return copy of the wrapped value
            return Objects.hashCode(template);
                    yield new ObjectValue(stringValue);
import java.util.HashMap;  
     *
        }
        }
        private final Object value;
        private final byte[] value;
import java.util.Objects;  
 * compatible open source license.
                    valueTypeMap.put(wrap(entry.getKey(), scriptService), wrap(entry.getValue(), scriptService));
 */  
        public boolean equals(Object o) {
 *  
        @Override
import java.util.Collections;
            if (o == null || getClass() != o.getClass()) return false;
    Object copyAndResolve(Map<String, Object> model);
                if (scriptService.isLangSupported(DEFAULT_TEMPLATE_LANG) && stringValue.contains("{{")) {
        }
            return value;
        @Override
    }
     *
 *  
     */
 *
        private final Map<ValueSource, ValueSource> map;
import java.util.Arrays;
            ObjectValue objectValue = (ObjectValue) o;  
                    valueSourceList.add(wrap(item, scriptService));
import org.opensearch.script.Script;
            return values.equals(listValue.values);  
                yield new MapValue(valueTypeMap);  
 */
    final class ByteValue implements ValueSource {  
        @Override  
        public Object copyAndResolve(Map<String, Object> model) {  
        }
     * A byte value source.
            }  
                }
        private final TemplateScript.Factory template;  
            return value;
        private final List<ValueSource> values;  
            return map.equals(mapValue.map);
        public int hashCode() {
     * A list value source.  
        @Override
            case Boolean bool -> new ObjectValue(bool);
        @Override
 * ownership. Elasticsearch licenses this file to you under  
        return switch (value) {
        }
            ByteValue objectValue = (ByteValue) o;  
        public int hashCode() {  
 * license agreements. See the NOTICE file distributed with
     * For immutable values only a copy of the reference to the value is made.
        }
                for (Object item : castedList) {  
            }
    }  
            this.value = value;
        }
 * specific language governing permissions and limitations
        public Object copyAndResolve(Map<String, Object> model) {  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
            return Arrays.hashCode(value);  
        public boolean equals(Object o) {  
            if (this == o) return true;
     * An object value source.
import org.opensearch.script.ScriptType;  
        }  
            }
            ListValue listValue = (ListValue) o;
            if (o == null || getClass() != o.getClass()) return false;
        TemplatedValue(TemplateScript.Factory template) {
     */  
        }
        ListValue(List<ValueSource> values) {
        public boolean equals(Object o) {
 * software distributed under the License is distributed on an
            Map<Object, Object> copy = new HashMap<>();  
 * KIND, either express or implied.  See the License for the
     */  
        }  
            for (ValueSource value : values) {  
     * Returns a copy of the value this ValueSource holds and resolves templates if there're any.  
 * the Apache License, Version 2.0 (the "License"); you may
                yield new ListValue(valueSourceList);  
 * Holds a value. If the value is requested a copy is made and optionally template snippets are resolved too.
 */
        }
            List<Object> copy = new ArrayList<>(values.size());
                // installed for use by REST tests. `value` will not be
            if (this == o) return true;  
        }
                List<ValueSource> valueSourceList = new ArrayList<>(castedList.size());
     * <p>
    }
            return Objects.equals(value, objectValue.value);
public interface ValueSource {  
        ByteValue(byte[] value) {
            this.value = value;
    }  
    final class ListValue implements ValueSource {
            }
                for (Map.Entry<Object, Object> entry : castedMap.entrySet()) {  
     * @opensearch.internal
     * A templated value.  
package org.opensearch.ingest;
            for (Map.Entry<ValueSource, ValueSource> entry : this.map.entrySet()) {
        public boolean equals(Object o) {
    /**
                List<Object> castedList = (List<Object>) listValue;
 * this work for additional information regarding copyright
        }  
     */  
                    yield new TemplatedValue(scriptService.compile(script, TemplateScript.CONTEXT));  
 * under the License.  
