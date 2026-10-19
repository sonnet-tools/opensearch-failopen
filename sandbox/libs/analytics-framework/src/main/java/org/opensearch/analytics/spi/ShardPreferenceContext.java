 *
 * this file be licensed under the Apache-2.0 license or a
 *
 * compatible because {@link BackendShardPreference} implementations only read what they need.
 * compatible open source license.
/**
 *
public record ShardPreferenceContext(boolean preferMetadataDriver) {
 * The OpenSearch Contributors require contributions made to  
 */  
 * independent inputs the backend may use to score its preference.  
 *
}
 * deleted-doc count, segment count, query-cache stats, etc. Adding a field is source-  
package org.opensearch.analytics.spi;
 * @param preferMetadataDriver value of {@code analytics.planner.prefer_metadata_driver}.  
 * <p>Surface starts minimal (just the user-facing setting) and grows as new consumers land:
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Context the framework supplies to {@link BackendShardPreference#scoreFor} — fragment-shape-
/*  
 * @opensearch.internal
