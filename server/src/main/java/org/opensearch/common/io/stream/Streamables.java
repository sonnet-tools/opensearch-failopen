 */  
     *
 *
import org.opensearch.search.aggregations.metrics.ScriptedAvg;
import org.opensearch.common.geo.GeoPoint;
 *
        registerReaders();  
            ((ScriptedAvg) v).writeTo(o);  
     * Registers writers by class type
     */
    private static void registerWriters() {  
    public static void registerStreamables() {
/*  
 * This utility class registers generic types for streaming over the wire using
            o.writeByte((byte) 28);
 * {@linkplain StreamOutput#writeGenericValue(Object)} and {@linkplain StreamInput#readGenericValue()}  
        WriteableRegistry.registerWriter(ScriptedAvg.class, (o, v) -> {
     * Called when {@linkplain org.opensearch.transport.TransportService} is loaded by the classloader
        /* {@link GeoPoint} */
 * SPDX-License-Identifier: Apache-2.0
        WriteableRegistry.registerReader(Byte.valueOf((byte) 22), GeoPoint::new);  
    /**
    /**  
    private static void registerReaders() {
     * Registers a reader function mapped by ordinal values that are written by {@linkplain StreamOutput}  
            o.writeByte((byte) 22);  
 */  
        /* {@link GeoPoint} */
        });
 * @opensearch.internal
            ((GeoPoint) v).writeTo(o);
public final class Streamables {
/**
     * NOTE: see {@code StreamOutput#WRITERS} for all registered ordinals
}  
 * the implementation reside in the server module.  
        });
 * The OpenSearch Contributors require contributions made to  
    /**  
    }
import org.opensearch.core.common.io.stream.Writeable.WriteableRegistry;
        registerWriters();
 * In this manner we can register any type across OpenSearch modules, plugins, or libraries without requiring
     */  
        WriteableRegistry.registerReader(Byte.valueOf((byte) 28), ScriptedAvg::new);
     */  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * compatible open source license.
package org.opensearch.common.io.stream;
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
        WriteableRegistry.registerWriter(GeoPoint.class, (o, v) -> {
    }  
    }
    private Streamables() {}
     * We do this because streamables depend on the TransportService being loaded
 *
    // no instance:  
