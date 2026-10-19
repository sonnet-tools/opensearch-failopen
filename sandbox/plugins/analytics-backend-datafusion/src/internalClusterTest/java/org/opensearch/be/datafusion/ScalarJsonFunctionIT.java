 * Edge cases are covered in Rust unit tests.
        // Single-path, wildcard-at-root over top-level array → 3 matches wrapped
            "[[\"Bridge of Sighs\",\"Ponte della Paglia\"],8981.0]"
                + " 'school.teacher', '[\"Tom\",\"Walt\"]')",
            "{\"a\":[{\"b\":1},{\"b\":{\"c\":\"3\"}}]}"
    public void testJsonArrayLengthParityWithLegacy() {
    }
        // Case c: nested-path + pre-stringified json_array(...) appended as a single string element.
            + "{\"type\":\"Bridge of Sighs\",\"length\":36.0},"
 */
        assertScalarString(
        // Case b: multi-pair append on the same target.
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonDelete*} — output order preserved via {@code serde_json} {@code preserve_order}. */
        String candidate = "[{\"name\":\"London\",\"Bridges\":[{\"name\":\"Tower Bridge\",\"length\":801.0},"
        // Multi-path with missing path yields literal `null` element in the
        // Wildcard-over-wildcard-missing-key: only Venice entries without a
        // Missing path (empty object) and explicit-null both resolve to SQL NULL.
 * SPDX-License-Identifier: Apache-2.0
        assertScalarNull("json_keys('not-json')");
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonExtract*} — byte-for-byte match via {@code serde_json} {@code preserve_order} + no integer↔double coercion. */
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonAppend} — nested {@code json_object}/{@code json_array} constructors replaced with their stringified equivalents (same observable contract). */
        );
        assertScalarNull("json_extract('{}', 'name')");
 * + column-valued coverage; {@code *ParityWithLegacy} methods replay the legacy
        assertScalarString("json_set('{\"a\":[{\"b\":1},{\"b\":2}]}', 'a{}.b', '3')", "{\"a\":[{\"b\":\"3\"},{\"b\":\"3\"}]}");
        assertScalarString(
        );
        assertScalarString("json_keys('{\"f1\":\"abc\",\"f2\":{\"f3\":\"a\",\"f4\":\"b\"}}')", "[\"f1\",\"f2\"]");
                + " 'school.teacher', '[\"Tom\",\"Walt\"]')",
            "{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2},"
                + " 'teacher', 'Tom', 'teacher', 'Walt')",
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonExtend} — case c diverges from append: a JSON-array value is spread (not pushed as a single element). */
        assertScalarString(
        assertScalarNull("json_array_length('{\"k\":1}')");
            + "{\"type\":\"Ponte della Paglia\"}]},"
    }
        assertScalarIntStrict("json_array_length('[]')", 0);
        // testJsonDeleteWithNested: delete a single nested key.
        );
                + "\"{\\\"name\\\":\\\"Tommy\\\",\\\"rank\\\":5}\"]}"
/*
        assertScalarNull("json_keys('[1,2,3,{\"f1\":1,\"f2\":[5,6]},4]')");
        // Single-path object match — jsonized with insertion order preserved.
}
            "{\"school\":{\"teacher\":[\"Alice\",\"Tom\",\"Walt\"],"
            "{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2},"
            "json_set('{\"a\":[{\"b\":1},{\"b\":{\"c\":2}}]}', 'a{}.b.c', '3')",
        assertScalarString(
    public void testJsonAppendParityWithLegacy() {
    }
        assertScalarNull("json_array_length('not-json')");
            "{\"account_number\":1,\"balance\":39225}"
                + " 'teacher', 'Tom', 'teacher', 'Walt')",
        assertScalarNull("json_array_length('{\"key\": 1}')");
 * PPL → Calcite → Substrait → DataFusion. One method per function for happy-path
/**
    public void testJsonDeleteParityWithLegacy() {
        assertScalarString(
            + "{\"name\":\"Millennium Bridge\",\"length\":1066.0}]},"
            "json_append('{\"school\":{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}}',"
        );
            + "{\"name\":\"Venice\",\"Bridges\":[{\"name\":\"Rialto Bridge\",\"length\":157.0},"
            "json_delete('{\"f1\":\"abc\",\"f2\":{\"f3\":\"a\",\"f4\":\"b\"}}', 'f2.f3')",
        assertScalarIntStrict("json_array_length('[1,2,3,{\"f1\":1,\"f2\":[5,6]},4]')", 5);
            "json_extend('{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}',"
        );
    public void testJsonExtractParityWithLegacy() {
        // in a JSON array. Round-tripped bytes equal the input because
        assertScalarString("json_extract('{\"name\": \"John\"}', 'name', 'age')", "[\"John\",null]");
            "json_extract('" + candidate + "', '{}.Bridges{}.type', '{2}.Bridges{0}.length')",
        assertScalarString("json_set('{\"a\":[{\"b\":1},{\"b\":2}]}', 'a{}.b.d', '3')", "{\"a\":[{\"b\":1},{\"b\":2}]}");
        );
            "json_extend('{\"school\":{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}}',"
        assertScalarString("json_extract('" + candidate + "', '{2}.Bridges{0}.length')", "8981.0");
                + " 'student', '{\"name\":\"Tomy\",\"rank\":5}')",
            "json_append('{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}',"
    /** Happy path + NULL-on-non-array/malformed (scalar fast-path) + column-valued (Arrow columnar path). */
        assertScalarString(
 *
public class ScalarJsonFunctionIT extends BaseScalarFunctionIT {
        assertScalarString(
    public void testJsonSetParityWithLegacy() {
        assertScalarString("json_extract('" + candidate + "', '{2}.Bridges{0}')", "{\"name\":\"Golden Gate Bridge\",\"length\":8981.0}");
            "{\"school\":{\"teacher\":[\"Alice\",\"[\\\"Tom\\\",\\\"Walt\\\"]\"],"
        // outer JSON array.
        assertScalarString(
            + "{\"name\":\"San Francisco\",\"Bridges\":[{\"name\":\"Golden Gate Bridge\",\"length\":8981.0},"
                + "\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}}"
    public void testJsonArrayLength() {
package org.opensearch.be.datafusion;
    }
        // testJsonDelete: flat-key delete of two fields.
        );
        // preserve_order + no numeric coercion.
 * The OpenSearch Contributors require contributions made to
        );
        assertScalarString(
    }
            "{\"teacher\":[\"Alice\",\"Tom\",\"Walt\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}"
        // testJsonDeleteWithNestedNothing: missing nested key leaves input unchanged.
            "{\"f1\":\"abc\",\"f2\":{\"f4\":\"b\"}}"
        assertScalarString("json_extract('" + candidate + "', '{}.Bridges{}.type')", "[\"Bridge of Sighs\",\"Ponte della Paglia\"]");
        // Case a: pre-stringified json_object(...) appended as a single array element.
            + "{\"name\":\"Bay Bridge\",\"length\":23556.0}]}]";
        );
                + " 'student', '{\"name\":\"Tommy\",\"rank\":5}')",
            "json_extend('{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}',"
        // testJsonSet: wildcard replace across every array element.
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonSet*} — values stored as JSON strings matches legacy {@code "b":"3"} outputs (Utf8 arg coercion). */
        );
        // Case a: stringified json_object value — not a JSON array → single push.
 * this file be licensed under the Apache-2.0 license or a
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonArrayLength}. */
    public void testJsonKeysParityWithLegacy() {
        // Columnar path: bank fixture's json_str row 1 is '[1,2,3]'.
        // Single-path scalar match — legacy `.toString()` on Double(8981.0).
        // Case b: plain strings — each fails List-parse → each pushed individually.
            "{\"student\":[{\"name\":\"Bob\"},{\"name\":\"Charlie\"}]}"
    }
        // the two per-path results (array + scalar) as-is.
 */
    public void testJsonExtendParityWithLegacy() {
        assertScalarIntStrict("json_array_length('[1,2,3,4]')", 4);
        );
 * compatible open source license.
        // path; only the matching branch is rewritten.
        assertScalarNull("json_extract('{\"name\": null}', 'name')");
    /** Parity replay of {@code CalcitePPLJsonBuiltinFunctionIT.testJsonKeys} — insertion order preserved via {@code serde_json} {@code preserve_order}. */
        // Case c: stringified json_array — parses as JSON array → elements spread.
        // testJsonSetWithWrongPath: 'a{}.b.d' doesn't exist — input unchanged.
        assertScalarIntStrict("json_array_length('[1,2,3]')", 3);
        );
        assertScalarString(
            "json_delete('{\"account_number\":1,\"balance\":39225,\"age\":32,\"gender\":\"M\"}', 'age', 'gender')",
 * SQL plugin's {@code CalcitePPLJsonBuiltinFunctionIT} fixtures verbatim.
        assertScalarIntStrict("json_array_length(json_str)", 3);
        assertScalarNull("json_keys('42')");
        assertScalarString("json_extract('" + candidate + "', '{}')", candidate);
        // `name` field expose a `type`, so two matches wrap into a JSON array.
 * End-to-end smoke tests for PPL {@code json_*} scalar functions routed through
        assertScalarString(
        // testJsonSetPartialSet: wildcard where only one branch has the full
            "json_delete('{\"teacher\":\"Alice\",\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}', 'teacher', 'student{}.rank')",
                + "\"{\\\"name\\\":\\\"Tomy\\\",\\\"rank\\\":5}\"]}"
        assertScalarString(
            "{\"teacher\":[\"Alice\",\"Tom\",\"Walt\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}"
        // Multi-path with wildcard-multi + scalar-match → outer array wraps
            "{\"f1\":\"abc\",\"f2\":{\"f3\":\"a\",\"f4\":\"b\"}}"
    }
        // testJsonDeleteWithNestedAndArray: wildcard path drops one key from every array element.
            "json_delete('{\"f1\":\"abc\",\"f2\":{\"f3\":\"a\",\"f4\":\"b\"}}', 'f2.f100')",
    }
            "json_append('{\"teacher\":[\"Alice\"],\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}',"
                + "\"student\":[{\"name\":\"Bob\",\"rank\":1},{\"name\":\"Charlie\",\"rank\":2}]}}"
