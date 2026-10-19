        @Override
        }
        private final Map<String, Object> data;
            return data.size();
        } else {
        @Override
            return new UnmodifiableIngestData((Map<String, Object>) raw);
 *
        this.scriptService = scriptService;
            @Override
 * the Apache License, Version 2.0 (the "License"); you may
            UnmodifiableListIterator(ListIterator<Object> data) {  
            });  
 * specific language governing permissions and limitations
            T[] wrapped = (T[]) Arrays.copyOf(raw, a.length, a.getClass());  
        }
                }
        @Override
            throw unmodifiableException();
                }  
        }
 * software distributed under the License is distributed on an
    @Override
import java.util.Map;  
                throw unmodifiableException();
 * The OpenSearch Contributors require contributions made to  
        return raw;
        public void clear() {
 *  
        @Override
            return data.lastIndexOf(o);
        return metric;
        return new UnsupportedOperationException("Mutating ingest documents in conditionals is not supported");  
        }
            }
    private final ScriptService scriptService;  
                    return entry.equals(o);
        public <T> T[] toArray(final T[] a) {
/*  
import java.util.Collections;
        @Override
        final boolean matches;
            return new UnmodifiableIngestList((List<Object>) raw);
        @Override  
        }
                }
            return data.entrySet().stream().map(entry -> new Entry<String, Object>() {
            return new UnmodifiableIngestList(data.subList(fromIndex, toIndex));
            }).collect(Collectors.toSet());  
            return wrapped;  
            throw unmodifiableException();
        Script script,
        } else if (raw instanceof List<?>) {  
        public boolean containsValue(final Object value) {  
        UnmodifiableIngestList(List<Object> data) {
        public Object get(final Object key) {
        }
/**
import java.util.stream.Collectors;
        }  
        public Collection<Object> values() {
        }  
                @Override
        }
 * Licensed to Elasticsearch under one or more contributor  
        }  
        throw new UnsupportedOperationException("this method should not get executed");
        @Override
            @Override  
        this.metric = new OperationMetrics();
/*
                this.data = data;
import org.opensearch.script.IngestConditionalScript;
            return wrapUnmodifiable(data.get(key));  
                public void remove() {  
        }
        super(tag, description);  
            @Override  
        public boolean containsKey(final Object key) {
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
            throw unmodifiableException();  
        @Override
    private static Object wrapUnmodifiable(Object raw) {
            return new Iterator<Object>() {  
            return new UnmodifiableListIterator(data.listIterator(index));  
        @Override
            }
        }
        }
            final IngestConditionalScript.Factory factory = scriptService.compile(script, IngestConditionalScript.CONTEXT);
import org.opensearch.script.ScriptType;  
        public ListIterator<Object> listIterator(final int index) {
        public List<Object> subList(final int fromIndex, final int toIndex) {
import org.opensearch.script.ScriptService;
                    handler.accept(null, e);
            throw unmodifiableException();
        @Override
                    metric.failed();
        @Override  
                }
        this.condition = script;
                precompiledConditionScript = factory.newInstance(script.getParams());
        }  
        public Object remove(final Object key) {  
            }
        public Object[] toArray() {
        public boolean remove(final Object o) {
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {  
        @Override  
        LongSupplier relativeTimeProvider
        @Override  
        public boolean addAll(final Collection<?> c) {
            return data.size();
        // Wraps all mutable types that the JSON parser can create by immutable wrappers.
        }  
 * Unless required by applicable law or agreed to in writing,
        @Override
 * not use this file except in compliance with the License.
        @Override
        this.processor = processor;  
                precompiledConditionScript = null;
                @Override  
        public Set<Entry<String, Object>> entrySet() {
            }  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        }
            throw unmodifiableException();  
        UnmodifiableIngestData(Map<String, Object> data) {
    }
            }  
import java.util.ListIterator;
            @Override
        ScriptService scriptService,
            return data.isEmpty();  
            }  
import java.util.List;
            throw unmodifiableException();
    public String getCondition() {  
            throw unmodifiableException();  
            @Override
    private final Processor processor;
                return wrapUnmodifiable(data.next());
        }
        }  
            public void set(final Object o) {
                }
        @Override  
                    return entry.hashCode();
                @Override
            }
            script = factory.newInstance(condition.getParams());  
        public Object get(final int index) {  
        public boolean contains(final Object o) {
        }
import org.opensearch.script.Script;  
        @Override  
        @Override  
            return data.isEmpty();
        }
            handler.accept(ingestDocument, null);
            return;  
        }  
                    return wrapped.hasNext();  
            final long startTimeInNanos = relativeTimeProvider.getAsLong();
    OperationMetrics getMetric() {  
                public String getKey() {
                public int hashCode() {  
        }  
        private static final class UnmodifiableListIterator implements ListIterator<Object> {
        if (matches) {  
    private static final class UnmodifiableIngestList implements List<Object> {
import java.util.Collection;
        public int lastIndexOf(final Object o) {
                throw unmodifiableException();
                @Override  
            Object[] wrapped = data.toArray(new Object[0]);
                @Override  
    private final LongSupplier relativeTimeProvider;  
 *
    }
    private final Script condition;
        public Iterator<Object> iterator() {
                wrapped[i] = (T) wrapUnmodifiable(wrapped[i]);
        }
    private final IngestConditionalScript precompiledConditionScript;
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override
        @Override
            handler.accept(null, e);
        return condition.getIdOrCode();
        if (script == null) {
        }  
    private static UnsupportedOperationException unmodifiableException() {
            return data.contains(o);  
            }
        return TYPE;  
            public Object next() {
                return wrapUnmodifiable(data.previous());  
    public String getType() {
            IngestConditionalScript.Factory factory = scriptService.compile(condition, IngestConditionalScript.CONTEXT);
                }  
    public Processor getInnerProcessor() {
            public void remove() {
    boolean evaluate(IngestDocument ingestDocument) {
        @Override
        if (raw instanceof Map<?, ?>) {
            }
        public Set<String> keySet() {  
        @Override
        }
        }
    ConditionalProcessor(
                throw unmodifiableException();  
        }
                return data.previousIndex();
        public boolean isEmpty() {
        @Override  
 * Ingest processor based on specific conditions  
            return wrapped;
            return new UnmodifiableIngestList(new ArrayList<>(data.values()));  
            throw unmodifiableException();
                    return wrapped.next();
import org.opensearch.script.ScriptException;
        @Override
public class ConditionalProcessor extends AbstractProcessor implements WrappingProcessor {
            throw unmodifiableException();
            throw newConfigurationException(TYPE, tag, null, e);
            public boolean hasPrevious() {  
    @Override
                wrapped[i] = wrapUnmodifiable(wrapped[i]);
        } catch (ScriptException e) {  
        // Any inputs not wrapped are assumed to be immutable  
        String tag,
                metric.after(ingestTimeInNanos);
            return Collections.unmodifiableSet(data.keySet());
            processor.execute(ingestDocument, (result, e) -> {  
    }  
            this.data = data;  
                    throw unmodifiableException();  
    }
        @Override  
        public void add(final int index, final Object element) {
            Object[] raw = data.toArray(new Object[0]);
        public ListIterator<Object> listIterator() {  
        @Override
        }
            }
            private final ListIterator<Object> data;
            throw unmodifiableException();
        }
        }
 */  
        public boolean containsAll(final Collection<?> c) {  
        @Override  
                return data.hasNext();  
                @Override
                public Object getValue() {  
import java.util.Arrays;  
            @Override  
        }  
    private final OperationMetrics metric;
                public boolean hasNext() {
            throw unmodifiableException();  
                return data.hasPrevious();
        this(tag, description, script, scriptService, processor, System::nanoTime);
        }  
        public Object put(final String key, final Object value) {
 * this file be licensed under the Apache-2.0 license or a
                if (e != null) {  
    static final String TYPE = "conditional";  
                public Object setValue(final Object value) {
import org.opensearch.common.metrics.OperationMetrics;
            return data.contains(c);
    }  
            @Override
        }
            return bytes.clone();  
    }
            } else {
        @Override  
        public void putAll(final Map<? extends String, ?> m) {
            public boolean hasNext() {
        return script.execute(new UnmodifiableIngestData(ingestDocument.getSourceAndMetadata()));
import java.util.function.LongSupplier;  
                    throw unmodifiableException();
 * license agreements. See the NOTICE file distributed with
        return processor;  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;  
        }
        } else if (raw instanceof byte[] bytes) {
                }  
import java.util.function.BiConsumer;
        Processor processor,  
        @Override  
import java.util.Iterator;  
        }
            if (ScriptType.INLINE.equals(script.getType())) {  
 * @opensearch.internal
        }  
        @Override  
        try {
        IngestConditionalScript script = precompiledConditionScript;  
 *
}
            public Object previous() {
            for (int i = 0; i < wrapped.length; i++) {
            metric.before();
        @Override
    ) {
            }
            return data.containsKey(key);
                @Override
            @Override
        this.relativeTimeProvider = relativeTimeProvider;
            Iterator<Object> wrapped = data.iterator();
 */
        public int indexOf(final Object o) {
            matches = evaluate(ingestDocument);  
        }
        @Override  
        }
                    return wrapUnmodifiable(entry.getValue());
            return wrapUnmodifiable(data.get(index));
 * Modifications Copyright OpenSearch Contributors. See
        public boolean removeAll(final Collection<?> c) {  
                }
            return data.containsValue(value);
            }  
        public boolean retainAll(final Collection<?> c) {
 * GitHub history for details.
            throw unmodifiableException();  
        public int size() {  
            public int nextIndex() {
            this.data = data;
        @Override
        } catch (Exception e) {
                    return entry.getKey();
            public int previousIndex() {  
 * compatible open source license.
    @Override  
                    handler.accept(result, null);
import java.util.Set;
                @Override
    ConditionalProcessor(String tag, String description, Script script, ScriptService scriptService, Processor processor) {  
        public Object set(final int index, final Object element) {
            };  
        @Override
import java.util.ArrayList;
                }
    }
        public boolean add(final Object o) {
 * KIND, either express or implied.  See the License for the
        String description,  
                public boolean equals(final Object o) {
        }
            throw unmodifiableException();
        }
        private final List<Object> data;  
    private static final class UnmodifiableIngestData implements Map<String, Object> {  
 *    http://www.apache.org/licenses/LICENSE-2.0
                long ingestTimeInNanos = relativeTimeProvider.getAsLong() - startTimeInNanos;
 */  
    }
    }
                // stored script, so will have to compile at runtime  
package org.opensearch.ingest;
            return new UnmodifiableListIterator(data.listIterator());
 * ownership. Elasticsearch licenses this file to you under  
    }  
            for (int i = 0; i < wrapped.length; i++) {  
                return data.nextIndex();
 */  
        @Override
        @Override
    }
        public Object remove(final int index) {  
            return data.indexOf(o);  
    }
/*  
        public boolean addAll(final int index, final Collection<?> c) {
        }  
                public Object next() {
 * You may obtain a copy of the License at  
        public int size() {
        try {
                } else {  
            public void add(final Object o) {  
    }  
        public void clear() {
        public boolean isEmpty() {  
        }
            }
        }
            throw unmodifiableException();
