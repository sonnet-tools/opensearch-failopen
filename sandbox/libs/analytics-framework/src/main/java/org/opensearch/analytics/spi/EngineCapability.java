 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
package org.opensearch.analytics.spi;
 */  
 * The OpenSearch Contributors require contributions made to  
 */
 * implies operator support.
 *  
 * Operators with dedicated classes (FILTER → {@link FilterCapability}, AGGREGATE →
 * Relational operations that a backend may support.
public enum EngineCapability {  
    UNION,
/**
 * <p>Only operators without dedicated per-function capability classes are listed here.
 * @opensearch.internal
    VALUES,  
 * {@link ScanCapability}) are declared via those classes — a non-empty capability set
/*  
 *  
 * {@link AggregateCapability}, PROJECT → {@link ProjectCapability}, SCAN →  
}
    MULTI_VALUE_EXPAND
    SORT,
 * SPDX-License-Identifier: Apache-2.0
 *
