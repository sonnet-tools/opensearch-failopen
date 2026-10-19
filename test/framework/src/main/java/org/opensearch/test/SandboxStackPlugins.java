    private SandboxStackPlugins() {}
        "org.opensearch.parquet.ParquetDataFormatPlugin",
        if (missing.isEmpty() == false) {
    /**  
 * {@link OpenSearchSingleNodeTestCase} (and potentially other base test cases).  
 * SPDX-License-Identifier: Apache-2.0
            .put(FeatureFlags.STREAM_TRANSPORT, true)
     */
            return resolved;
     * @return an empty list when {@code sandbox.enabled} is not set, or when none of the plugin classes are on the  
 *
     * Memoised SUCCESSFUL result of {@link #resolve()} (either the empty none-resolvable list or the full stack). The  
            // call so the diagnostic stays attached to the caller rather than degrading into ExceptionInInitializerError.  
import org.opensearch.common.settings.Settings;
     * @return node settings that enable the two sandbox feature flags the stack requires: the pluggable data-format  
                "Sandbox is enabled and some sandbox plugins loaded, but these were not found on the test "
    static boolean isEnabled() {
    private static volatile List<Class<? extends Plugin>> resolved;  
 * The OpenSearch Contributors require contributions made to  
        }
        if (cached != null) {  
        for (String className : SANDBOX_STACK_PLUGINS) {
            resolved = Collections.emptyList();
            try {  
     */
        "org.opensearch.composite.CompositeDataFormatPlugin",
        }
    static Settings featureFlagSettings() {
            .build();
import java.util.ArrayList;  
     *
 * This class is intentionally package-scoped to {@code org.opensearch.test}: it is a test-framework internal shared by
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
     * Main-class names of the eight sandbox stack plugins, in {@code extendedPlugins} order (arrow-base first, so the
 * <p>
 * The eight plugin classes are resolved <em>reflectively</em> (via {@link Class#forName(String)}) on purpose:
    /**
 * class files. A compile-time dependency on them would force the whole framework to JDK 25 and break every JDK 21
        }  
     * exact {@code classname} values declared in each plugin's {@code build.gradle}.
        "org.opensearch.analytics.AnalyticsPlugin",  
     * classpath (the intended no-op in modules that do not put the plugins on the test runtime classpath); otherwise
     * @return true only when the build forwarded {@code -Dsandbox.enabled=true} into the forked test JVM. Gradle does
            } catch (ClassNotFoundException e) {
 * framework loads in-JVM on test nodes when {@code -Dsandbox.enabled=true} is forwarded into the forked test worker.  
            return Collections.emptyList();  
package org.opensearch.test;
     * not propagate the {@code -D} build flag automatically; the server test task forwards it explicitly.  
        resolved = Collections.unmodifiableList(found);
/*  
 * compatible open source license.
    );  
            return cached;
    /**
 * Shared resolver for the sandbox "mustang" engine stack (arrow + analytics + DSL + parquet plugins) that the test
        }  
    }  
     */
     * @throws IllegalStateException if some plugin classes resolve but others do not — that means a plugin was renamed  
    private static final List<String> SANDBOX_STACK_PLUGINS = List.of(  
        "org.opensearch.be.lucene.LucenePlugin",
     * or moved, and silently dropping engine coverage would be worse than failing loudly.
        "org.opensearch.dsl.DslQueryExecutorPlugin"
        "org.opensearch.arrow.allocator.ArrowBasePlugin",
}
import java.util.List;
    /**
 * consumer. Reflection lets the framework compile without the plugins on its classpath and pick them up only in the
 */
            throw new IllegalStateException(
                    + "classpath (renamed or moved?): "  
import org.opensearch.common.util.FeatureFlags;  
    }  
     * Resolve the sandbox stack reflectively.
        if (isEnabled() == false) {
        return resolved;
     */
     */  
        if (found.isEmpty()) {  
        "org.opensearch.be.datafusion.DataFusionPlugin",  
     * partial/failure path is deliberately NOT cached so it keeps throwing at the call site on every call.
        }
import java.util.Collections;
     * properties) so that flag-off unit tests running in the same fork are unaffected.
import org.opensearch.common.Booleans;
 * this file be licensed under the Apache-2.0 license or a
        List<String> missing = new ArrayList<>();
/**
import org.opensearch.plugins.Plugin;
    @SuppressWarnings("unchecked")  
                found.add((Class<? extends Plugin>) Class.forName(className));
 * <p>
class SandboxStackPlugins {
    static List<Class<? extends Plugin>> resolve() {
 */  
    }
            );
            }
            // Deliberately do NOT cache this partial/failure path: it must keep throwing at the CALL SITE on every
                    + missing
 * {@code test:framework} compiles its main source set with {@code --release 21}, but the sandbox plugins are JDK 25  
        List<Class<? extends Plugin>> cached = resolved;
    /**
     * the full ordered list of eight plugin classes.
     * Arrow allocator/transport are present before the data-format and DSL plugins that depend on them). These are the  
        return Booleans.parseBoolean(System.getProperty("sandbox.enabled"), false);  
        return Settings.builder()
                missing.add(className);  
 * modules (server unit tests, internal cluster tests) that actually put the plugin jars on the test runtime classpath.  
        "org.opensearch.arrow.flight.transport.FlightStreamPlugin",
        ArrayList<Class<? extends Plugin>> found = new ArrayList<>();  
     * flag and the stream-transport flag. These are applied via <em>node settings</em> (not JVM-wide system
