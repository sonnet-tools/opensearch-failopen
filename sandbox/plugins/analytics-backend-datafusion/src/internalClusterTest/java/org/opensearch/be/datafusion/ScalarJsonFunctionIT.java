        // Case a: stringified json_object value — not a JSON array → single push.  
            "json_append('{\"school\":{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}}',"  
    public void testJsonArrayLengthParityWithLegacy() {  
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonSet*} — values stored as JSON strings matches legacy {@code "b":"3"} outputs (Utf8 arg coercion). */
                + " 'school.teacher', '[\"Tom\",\"Walt\"]')",  
        assertScalarNull("json_keys('42')");
    }  
            + "{\"type\":\"Bridge of Sighs\",\"length\":36.0},"
                + "\"{\\\"name\\\":\\\"Tomy\\\",\\\"rank\\\":5}\"]}"  
                + " 'teacher', 'Tom', 'teacher', 'Walt')",
            "json_delete('{\"f1\":\"abc\",\"f2\":{\"f3\":\"a\",\"f4\":\"b\"}}', 'f2.f100')",
                + " 'teacher', 'Tom', 'teacher', 'Walt')",  
        // Case c: stringified json_array — parses as JSON array → elements spread.  
        // Case c: nested-path + pre-stringified json_array(...) appended as a single string element.
        // Case a: pre-stringified json_object(...) appended as a single array element.
 * PPL → Calcite → Substrait → DataFusion. One method per function for happy-path  
            "json_append('{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}',"
        assertScalarString(  
        );
            + "{\"type\":\"Ponte della Paglia\"}]},"
 * SPDX-License-Identifier: Apache-2.0
        assertScalarIntStrict("json_array_length('[1,2,3]')", 3);  
            "{\"f1\":\"abc\",\"f2\":{\"f4\":\"b\"}}"
            + "{\"name\":\"Venice\",\"Bridges\":[{\"name\":\"Rialto Bridge\",\"length\":157.0},"  
            "{\"teacher\":[\"Alice\",\"Tom\",\"Walt\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}"
        // testJsonDeleteWithNestedNothing: missing nested key leaves input unchanged.
        assertScalarString("json_extract('" + candidate + "', '{}.Bridges{}.type')", "[\"Bridge of Sighs\",\"Ponte della Paglia\"]");
        // Single-path scalar match — legacy `.toString()` on Double(8981.0).
    public void testJsonSetParityWithLegacy() {
 * Edge cases are covered in Rust unit tests.  
        // Case b: multi-pair append on the same target.  
    public void testJsonExtractParityWithLegacy() {  
        );  
/**
        // outer JSON array.  
                + "\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}}"
            "{\"student\":[{\"name\":\"Bob\"},{\"name\":\"Charlie\"}]}"
            + "{\"name\":\"Bay Bridge\",\"length\":23556.0}]}]";
        // Columnar path: bank fixture's json_str row 1 is '[1,2,3]'.
        assertScalarString(  
        assertScalarString("json_keys('{\"f1\":\"abc\",\"f2\":{\"f3\":\"a\",\"f4\":\"b\"}}')", "[\"f1\",\"f2\"]");
        assertScalarString(
    public void testJsonDeleteParityWithLegacy() {
        );
        assertScalarString(  
        // testJsonDeleteWithNested: delete a single nested key.
                + " 'student', '{\"name\":\"Tomy\",\"rank\":5}')",
                + "\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}}"  
    }  
 */
        // Single-path, wildcard-at-root over top-level array → 3 matches wrapped  
        assertScalarNull("json_extract('{}', 'name')");
        assertScalarNull("json_array_length('{\"key\": 1}')");  
 * + column-valued coverage; {@code *ParityWithLegacy} methods replay the legacy
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonDelete*} — output order preserved via {@code serde_json} {@code preserve_order}. */  
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonKeys} — insertion order preserved via {@code serde_json} {@code preserve_order}. */  
        assertScalarNull("json_extract('{\"name\": null}', 'name')");  
            + "{\"name\":\"Millennium Bridge\",\"length\":1066.0}]},"
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonExtract*} — byte-for-byte match via {@code serde_json} {@code preserve_order} + no integer↔double coercion. */
        assertScalarString(
            "json_extract('" + candidate + "', '{}.Bridges{}.type', '{2}.Bridges{0}.length')",  
        assertScalarString("json_extract('" + candidate + "', '{2}.Bridges{0}')", "{\"name\":\"Golden Gate Bridge\",\"length\":8981.0}");
            "{\"a\":[{\"b\":1},{\"b\":{\"c\":\"3\"}}]}"
        // Multi-path with wildcard-multi + scalar-match → outer array wraps  
        // in a JSON array. Round-tripped bytes equal the input because
            "json_delete('{\"f1\":\"abc\",\"f2\":{\"f3\":\"a\",\"f4\":\"b\"}}', 'f2.f3')",
    public void testJsonAppendParityWithLegacy() {  
        // testJsonDelete: flat-key delete of two fields.
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonExtend} — case c diverges from append: a JSON-array value is spread (not pushed as a single element). */
        assertScalarString(
 *
        // path; only the matching branch is rewritten.
            "{\"school\":{\"teacher\":[\"Alice\",\"[\\\"Tom\\\",\\\"Walt\\\"]\"],"
    }
    }
        // testJsonSetPartialSet: wildcard where only one branch has the full  
    }  
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonArrayLength}. */
        // Missing path (empty object) and explicit-null both resolve to SQL NULL.
        );  
            + "{\"name\":\"San Francisco\",\"Bridges\":[{\"name\":\"Golden Gate Bridge\",\"length\":8981.0},"  
                + " 'school.teacher', '[\"Tom\",\"Walt\"]')",
    /** Happy path + NULL-on-non-array/malformed (scalar fast-path) + column-valued (Arrow columnar path). */
        // testJsonSet: wildcard replace across every array element.  
        String candidate = "[{\"name\":\"London\",\"Bridges\":[{\"name\":\"Tower Bridge\",\"length\":801.0},"
        // Multi-path with missing path yields literal `null` element in the
        assertScalarString("json_set('{\"a\":[{\"b\":1},{\"b\":2}]}', 'a{}.b.d', '3')", "{\"a\":[{\"b\":1},{\"b\":2}]}");
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonAppend} — nested {@code json_object}/{@code json_array} constructors replaced with their stringified equivalents (same observable contract). */
 * this file be licensed under the Apache-2.0 license or a
    public void testJsonExtendParityWithLegacy() {
            "{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2},"
        assertScalarString(  
    }
        assertScalarIntStrict("json_array_length('[]')", 0);
                + " 'student', '{\"name\":\"Tommy\",\"rank\":5}')",  
public class ScalarJsonFunctionIT extends BaseScalarFunctionIT {
        // preserve_order + no numeric coercion.
        assertScalarString(
}
 * compatible open source license.
        );
            "{\"f1\":\"abc\",\"f2\":{\"f3\":\"a\",\"f4\":\"b\"}}"
        // the two per-path results (array + scalar) as-is.
        );  
            "json_delete('{\"account_number\":1,\"balance\":39225,\"age\":32,\"gender\":\"M\"}', 'age', 'gender')",
            "{\"account_number\":1,\"balance\":39225}"
        assertScalarString(  
    public void testJsonArrayLength() {
    public void testJsonKeysParityWithLegacy() {
        assertScalarString("json_extract('" + candidate + "', '{2}.Bridges{0}.length')", "8981.0");  
        );  
        assertScalarIntStrict("json_array_length(json_str)", 3);
 */  
        assertScalarNull("json_array_length('{\"k\":1}')");
        );
            "json_extend('{\"school\":{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}}',"
        );  
            "json_extend('{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}',"
            "json_delete('{\"teacher\":\"Alice\",\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}', 'teacher', 'student{}.rank')",
        // Case b: plain strings — each fails List-parse → each pushed individually.
        );  
        assertScalarString("json_extract('" + candidate + "', '{}')", candidate);  
            "json_append('{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}',"  
        assertScalarNull("json_keys('not-json')");
        assertScalarString("json_set('{\"a\":[{\"b\":1},{\"b\":2}]}', 'a{}.b', '3')", "{\"a\":[{\"b\":\"3\"},{\"b\":\"3\"}]}");
/*  
 * SQL plugin's {@code CalcitePPLJsonBuiltinFunctionIT} fixtures verbatim.
        );
            "{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2},"
package org.opensearch.be.datafusion;
            "json_extend('{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}',"
 * End-to-end smoke tests for PPL {@code json_*} scalar functions routed through
        assertScalarNull("json_array_length('not-json')");  
            "[[\"Bridge of Sighs\",\"Ponte della Paglia\"],8981.0]"
        assertScalarIntStrict("json_array_length('[1,2,3,4]')", 4);
        assertScalarString("json_extract('{\"name\": \"John\"}', 'name', 'age')", "[\"John\",null]");
            "json_set('{\"a\":[{\"b\":1},{\"b\":{\"c\":2}}]}', 'a{}.b.c', '3')",  
 * The OpenSearch Contributors require contributions made to  
        // testJsonDeleteWithNestedAndArray: wildcard path drops one key from every array element.
        assertScalarString(
        assertScalarString(
        // Wildcard-over-wildcard-missing-key: only Venice entries without a
        assertScalarIntStrict("json_array_length('[1,2,3,{\"f1\":1,\"f2\":[5,6]},4]')", 5);
        );
        // testJsonSetWithWrongPath: 'a{}.b.d' doesn't exist — input unchanged.  
    }
        // `name` field expose a `type`, so two matches wrap into a JSON array.  
        assertScalarNull("json_keys('[1,2,3,{\"f1\":1,\"f2\":[5,6]},4]')");  
            "{\"teacher\":[\"Alice\",\"Tom\",\"Walt\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}"  
        // Single-path object match — jsonized with insertion order preserved.  
    }
        assertScalarString(
                + "\"{\\\"name\\\":\\\"Tommy\\\",\\\"rank\\\":5}\"]}"
            "{\"school\":{\"teacher\":[\"Alice\",\"Tom\",\"Walt\"],"
