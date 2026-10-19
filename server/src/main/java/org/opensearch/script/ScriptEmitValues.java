        public void emit(Object val) {  
     * Takes in a single value and emits it  
            derivedFieldScript.addEmittedValue(new Tuple<>(lat, lon));  
     * Could be a long, double, String, etc.
     */
        // it can have custom compilation logic to perform class bindings on that emit implementation.
 */
     */
    public static final class EmitSingle {  
package org.opensearch.script;
 * The emit function can be called multiple times within a script definition  
        // Ideally, we should have an emit signature per derived field type and try to scope
        // that to the respective script execution so the other emits aren't allowed.
 * <p>
    /**
        }  
 * The OpenSearch Contributors require contributions made to  
}
    }
    public static final class GeoPoint {  
    }  
 * this file be licensed under the Apache-2.0 license or a
        public GeoPoint(DerivedFieldScript derivedFieldScript) {
        }
        private final DerivedFieldScript derivedFieldScript;
        // binding methods with the same name and arity.  
        private final DerivedFieldScript derivedFieldScript;
            this.derivedFieldScript = derivedFieldScript;
        }
import org.opensearch.common.collect.Tuple;
 * compatible open source license.
            this.derivedFieldScript = derivedFieldScript;
        // TODO: Keeping this generic for the time being due to limitations with
 * SPDX-License-Identifier: Apache-2.0
/*  
            derivedFieldScript.addEmittedValue(val);
 * Values that can be emitted in a derived field script context.
 */  
        // One way to do this could be to create implementations of the DerivedFieldScript.LeafFactory  
     * Emits a GeoPoint value
    /**  
public final class ScriptEmitValues {  
        }  
 * so the function will handle collecting the values over the script execution.
 *
        public EmitSingle(DerivedFieldScript derivedFieldScript) {
        // per field type where they each define their own emit() method and then the engine that executes
        public void emit(double lat, double lon) {
/**  
