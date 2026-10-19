    }
     */  
     * Convenience method to call {@link ScriptProtoUtils#parseFromProtoRequest(org.opensearch.protobufs.Script, String)}
    public static String parseScriptLanguage(ScriptLanguage language, String defaultLang) {
     */  
 * This class handles the conversion of Protocol Buffer representations to their
     * Parses a protobuf ScriptLanguage to a String representation
        if (language.hasCustom()) {  
            case BUILTIN_SCRIPT_LANGUAGE_PAINLESS:
        } else {
            default:
     */
 * Utility class for converting SourceConfig Protocol Buffers to FetchSourceContext objects.
     * @param inlineScript the Protocol Buffer InlineScript to convert
import java.util.Collections;
     * Parses a protobuf StoredScriptId to a Script object
                return defaultLang;
        }
        Objects.requireNonNull(defaultLang);
        String idOrCode = inlineScript.getSource();
                return "mustache";  
 */
import org.opensearch.protobufs.InlineScript;
            case BUILTIN_SCRIPT_LANGUAGE_MUSTACHE:
     * @return the converted Script object  
 * compatible open source license.
 * corresponding OpenSearch objects.  
            : Collections.emptyMap();
    public static Script parseInlineScript(InlineScript inlineScript, String defaultLang) {
import static org.opensearch.script.Script.CONTENT_TYPE_OPTION;  
        String lang = null;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.StoredScriptId;
                return "expression";
            return parseStoredScriptId(script.getStored());
     * Similar to {@link Script#parse(XContentParser)}
     *
        return new Script(type, lang, idOrCode, options, params);  
            return language.getCustom();
/**  
    public static Script parseStoredScriptId(StoredScriptId storedScriptId) {  
 * SPDX-License-Identifier: Apache-2.0
     * @return
     * @param script the Protocol Buffer Script to convert  
        }  
import static org.opensearch.script.Script.DEFAULT_SCRIPT_LANG;
    }
    private static Script parseFromProtoRequest(org.opensearch.protobufs.Script script, String defaultLang) {
        }  
            case BUILTIN_SCRIPT_LANGUAGE_UNSPECIFIED:  
     * Similar to {@link Script#parse(XContentParser, String)}, which internally calls Script#build().
                return "painless";
     * @param language the Protocol Buffer ScriptLanguage to convert  
package org.opensearch.transport.grpc.proto.request.common;
        Map<String, String> options = inlineScript.getOptionsMap();  
     * @param defaultLang the default script language to use if not specified
        String idOrCode = storedScriptId.getId();  
    }  
     *  
import org.opensearch.core.xcontent.XContentParser;
            ? ObjectMapProtoUtils.fromProto(inlineScript.getParams())  
            case BUILTIN_SCRIPT_LANGUAGE_JAVA:  
        return parseFromProtoRequest(script, DEFAULT_SCRIPT_LANG);
    public static Script parseFromProtoRequest(org.opensearch.protobufs.Script script) {
 *
        // Utility class, no instances
import java.util.Objects;
        Map<String, Object> params = storedScriptId.hasParams()
     *  
import org.opensearch.protobufs.ScriptLanguage;  
     * Parses a protobuf InlineScript to a Script object
     * @param defaultLang the default script language to use if not specified
     */
     * Converts a Script Protocol Buffer to a Script object.  
        Map<String, String> options = null;
    /**
            throw new UnsupportedOperationException("No valid script type detected");  
        if (script.hasInline()) {
        ScriptType type = ScriptType.INLINE;
            case BUILTIN_SCRIPT_LANGUAGE_EXPRESSION:
    }
     * @return the converted Script object
     * @param storedScriptId the Protocol Buffer StoredScriptId to convert  
import org.opensearch.script.ScriptType;  
    /**  
    /**  
import org.opensearch.script.Script;
        } else if (script.hasStored()) {  
     * @throws UnsupportedOperationException if no language was specified  
    /**
public class ScriptProtoUtils {
 * this file be licensed under the Apache-2.0 license or a
     *  
            ? ObjectMapProtoUtils.fromProto(storedScriptId.getParams())  
import java.util.Map;  
     * @return the converted Script object
            : Collections.emptyMap();
        Map<String, Object> params = inlineScript.hasParams()
     *
     * @param defaultLang the default script language to use if not specified
    /**
 */  
    }
        if (options.size() > 1 || options.size() == 1 && options.get(CONTENT_TYPE_OPTION) == null) {
     *
        }
        switch (language.getBuiltin()) {  
}
    private ScriptProtoUtils() {
        ScriptType type = ScriptType.STORED;
        String lang = inlineScript.hasLang() ? parseScriptLanguage(inlineScript.getLang(), defaultLang) : defaultLang;  
/*  
            return parseInlineScript(script.getInline(), defaultLang);
                return "java";
        return new Script(type, lang, idOrCode, options, params);  
     * @return the string representation of the script language
    }  
            throw new IllegalArgumentException("illegal compiler options [" + options + "] specified");
     * @param script
     */
