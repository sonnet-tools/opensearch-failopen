 * <p>A subset of the ClickBench {@code hits} index covering the basic SQL types
 * SPDX-License-Identifier: Apache-2.0
 */  
import java.util.LinkedHashMap;
 *
 * ClickBench workload schema for SQL-driven planner tests.  
 * Add fields when a test needs them.
    public static final String INDEX = "hits";
}  
 * launches. {@code Map.of}'s iteration order is JVM-seed-salted, which surfaces as
 *
public final class ClickBench {
 * comparing scan rowType field order).  
import java.util.Map;  
        fields.put("Title", Map.of("type", "keyword"));
        fields.put("URL", Map.of("type", "keyword"));  
    private ClickBench() {}
 */
    public static final Map<String, Map<String, Object>> BASIC_FIELDS;  
 *
 * <p>Backed by {@link LinkedHashMap} so column order is deterministic across JVM  
        LinkedHashMap<String, Map<String, Object>> fields = new LinkedHashMap<>();  
    }  
        fields.put("AdvEngineID", Map.of("type", "short"));  
        fields.put("EventDate", Map.of("type", "date"));
 * The OpenSearch Contributors require contributions made to  
        fields.put("CounterID", Map.of("type", "integer"));
import java.util.Collections;
/**
 * this file be licensed under the Apache-2.0 license or a
/*  
    static {
 * compatible open source license.
        fields.put("UserID", Map.of("type", "long"));
package org.opensearch.analytics.planner;
 * exercised by pushdown / filter-delegation tests: integer, long, short, keyword, date.  
        fields.put("ParamPrice", Map.of("type", "long"));
        BASIC_FIELDS = Collections.unmodifiableMap(fields);
 * flaky tests when assertions depend on column ordering (e.g. plan-shape tests
