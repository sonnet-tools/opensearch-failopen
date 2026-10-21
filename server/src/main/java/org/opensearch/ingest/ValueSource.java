            case List<?> listValue -> {
     */
            if (o == null || getClass() != o.getClass()) return false;
    }
     * Returns a copy of the value this ValueSource holds and resolves templates if there're any.
import java.util.Objects;
            this.values = values;
            case byte[] byteArray -> new ByteValue(byteArray);
        }
    /**
            case Number number -> new ObjectValue(number);
 * under the License.
     * An object value source.
            if (this == o) return true;
        @Override
 * not use this file except in compliance with the License.
                for (Object item : castedList) {
                }
     * @return copy of the wrapped value
                // installed for use by REST tests. `value` will not be
     * @opensearch.internal
    static ValueSource wrap(Object value, ScriptService scriptService) {
 * SPDX-License-Identifier: Apache-2.0
            case String stringValue -> {
            return map.equals(mapValue.map);
public interface ValueSource {
 * software distributed under the License is distributed on an
        MapValue(Map<ValueSource, ValueSource> map) {
            case Boolean bool -> new ObjectValue(bool);
                @SuppressWarnings("unchecked")
            this.map = map;
            return map.hashCode();
    }
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        @Override
                }
package org.opensearch.ingest;
        @Override
        public boolean equals(Object o) {
            this.value = value;
        }
                yield new MapValue(valueTypeMap);
                    Script script = new Script(ScriptType.INLINE, DEFAULT_TEMPLATE_LANG, stringValue, Collections.emptyMap());
            return values.equals(listValue.values);
        public int hashCode() {
        TemplatedValue(TemplateScript.Factory template) {
            if (o == null || getClass() != o.getClass()) return false;
        public int hashCode() {
        }
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
     *
        private final TemplateScript.Factory template;
            if (o == null || getClass() != o.getClass()) return false;
     * @opensearch.internal
        public boolean equals(Object o) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
 */
            TemplatedValue templatedValue = (TemplatedValue) o;
     *
                yield new ListValue(valueSourceList);
    }
     *
    final class TemplatedValue implements ValueSource {
import java.util.Map;
            }
                Map<Object, Object> castedMap = (Map<Object, Object>) mapValue;
 * ownership. Elasticsearch licenses this file to you under
 *
            if (this == o) return true;
                copy.add(value.copyAndResolve(model));
                for (Map.Entry<Object, Object> entry : castedMap.entrySet()) {
                @SuppressWarnings("unchecked")
    final class ByteValue implements ValueSource {
import java.util.Collections;
        }
     * <p>
        }
        ListValue(List<ValueSource> values) {
        public Object copyAndResolve(Map<String, Object> model) {
        }
     * A templated value.
            return template.newInstance(model).execute();
        private final Object value;
        }
    /**
}
    /**
     *
     * For immutable values only a copy of the reference to the value is made.
        }
     * A byte value source.
import java.util.Arrays;
        ByteValue(byte[] value) {
        public Object copyAndResolve(Map<String, Object> model) {
            return Objects.equals(value, objectValue.value);
     *
        @Override
        }
            MapValue mapValue = (MapValue) o;
                List<ValueSource> valueSourceList = new ArrayList<>(castedList.size());
            if (o == null || getClass() != o.getClass()) return false;
        private final List<ValueSource> values;
 *
            return Objects.hashCode(template);
            ByteValue objectValue = (ByteValue) o;
                    yield new ObjectValue(stringValue);
            return Objects.hashCode(value);
        }
        }
                    valueTypeMap.put(wrap(entry.getKey(), scriptService), wrap(entry.getValue(), scriptService));
import java.util.HashMap;
    final class ObjectValue implements ValueSource {
            }
        public boolean equals(Object o) {
        @Override
 */
    }
            return Objects.equals(template, templatedValue.template);
                    valueSourceList.add(wrap(item, scriptService));
            if (this == o) return true;
     */
 * Holds a value. If the value is requested a copy is made and optionally template snippets are resolved too.
        @Override
 * The OpenSearch Contributors require contributions made to
            }
            for (ValueSource value : values) {
     */
            return value;
    Object copyAndResolve(Map<String, Object> model);
            }
            default -> throw new IllegalArgumentException("unexpected value type [" + value.getClass() + "]");
            return Arrays.equals(value, objectValue.value);
        };
        }
        public Object copyAndResolve(Map<String, Object> model) {
            this.value = value;
            for (Map.Entry<ValueSource, ValueSource> entry : this.map.entrySet()) {
import org.opensearch.script.ScriptService;
            case Map<?, ?> mapValue -> {
import java.util.List;
/*
            case null -> new ObjectValue(null);
            return values.hashCode();
            List<Object> copy = new ArrayList<>(values.size());
        @Override
            ListValue listValue = (ListValue) o;
    final class ListValue implements ValueSource {
 * KIND, either express or implied.  See the License for the
            if (this == o) return true;
            if (this == o) return true;
            }
        return switch (value) {
        @Override
 * license agreements. See the NOTICE file distributed with
        private final byte[] value;
     *
        public boolean equals(Object o) {
        public Object copyAndResolve(Map<String, Object> model) {
        }
/*
    final class MapValue implements ValueSource {
                Map<ValueSource, ValueSource> valueTypeMap = new HashMap<>(castedMap.size());
        }
import java.util.ArrayList;
 */
        }
import org.opensearch.script.ScriptType;
 * compatible open source license.
        @Override
        @Override
        ObjectValue(Object value) {
            ObjectValue objectValue = (ObjectValue) o;
     */
 * the Apache License, Version 2.0 (the "License"); you may
                // modified if templating is not available
    /**
     * @opensearch.internal
            return value;
 * GitHub history for details.
import org.opensearch.script.Script;
                if (scriptService.isLangSupported(DEFAULT_TEMPLATE_LANG) && stringValue.contains("{{")) {
/*
        }
                copy.put(entry.getKey().copyAndResolve(model), entry.getValue().copyAndResolve(model));
        @Override
                List<Object> castedList = (List<Object>) listValue;
     * @opensearch.internal
        }
            return copy;
 * Licensed to Elasticsearch under one or more contributor
        public int hashCode() {
                } else {
import static org.opensearch.script.Script.DEFAULT_TEMPLATE_LANG;
        @Override
            return Arrays.hashCode(value);
     * @opensearch.internal
        public int hashCode() {
                    yield new TemplatedValue(scriptService.compile(script, TemplateScript.CONTEXT));
        public Object copyAndResolve(Map<String, Object> model) {
 * specific language governing permissions and limitations
                // This check is here because the DEFAULT_TEMPLATE_LANG(mustache) is not
            return copy;
            this.template = template;
        @Override
        }
            Map<Object, Object> copy = new HashMap<>();
            if (o == null || getClass() != o.getClass()) return false;
     * A list value source.
     */
 * You may obtain a copy of the License at
 * @opensearch.internal
    /**
/**
    }
     */
        public int hashCode() {
        private final Map<ValueSource, ValueSource> map;
 * this work for additional information regarding copyright
        }
import org.opensearch.script.TemplateScript;
 *
    /**
 */
                }
     * @param model The model to be used when resolving any templates
        @Override
        @Override
        public boolean equals(Object o) {
     * A map value source.
    }
