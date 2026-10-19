/**  
     */  
}
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental
     * @param bytes Serialized representation of an object
    boolean equals(T object, U bytes);
    /**  
 * The OpenSearch Contributors require contributions made to  
     */  
     */
     * Serializes an object.  
     * @param bytes The serialized representation.
/*  
     * @param object A non-serialized object.
public interface Serializer<T, U> {
    /**
package org.opensearch.common.cache.serializer;
     * Deserializes bytes into an object.
 * T is the class of the original object, and U is the serialized class.
 *  
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
     * @return true if representing the same object, false if not
    U serialize(T object);
 *
     * @return The serialized representation of the object.
 */  
     * @return The original object.  
 */
     * @param object A non-serialized objet  
    /**
 * this file be licensed under the Apache-2.0 license or a
    T deserialize(U bytes);
 * Defines an interface for serializers, to be used by pluggable caches.
     * Compares an object to a serialized representation of an object.
@ExperimentalApi  
