     * @param pluginsDirectory The directory plugins exist in, or null if plugins should not be loaded from the filesystem  
     * Get information about plugins and modules
    /**
        ClassLoader parentLoader = PluginLoaderIndirection.createLoader(getClass().getClassLoader(), extendedLoaders);  
        // Used for testing
                if (bundle.plugin.isExtendedPluginOptional(dependency)) {
import org.opensearch.Build;
            Set<URL> urls = new HashSet<>();
            addSortedBundle(bundle, namedBundles, sortedBundles, dependencyStack);  
    }  
        reloadLuceneSPI(loader);
 * You may obtain a copy of the License at  
            if (iterator.hasNext()) {  
                    throw new IllegalArgumentException("Missing plugin [" + dependency + "], dependency of [" + name + "]");
                            + plugin.v1().getName()
                throw new IllegalStateException(message);  
        sortedBundles.add(bundle);
                        features.get(feature)
import java.util.stream.Collectors;  
            dependencyStack.forEach(s -> {
     * @param modulesDirectory The directory modules exist in, or null if modules should not be loaded from the filesystem
            });
     * register the services for use.
            if (o == null || getClass() != o.getClass()) return false;  
    private static <T> String extensionSignatureMessage(Class<? extends T> extensionClass, Class<T> extensionPointType, Plugin plugin) {
                }
                            "Non-plugin file located in the plugins folder with the following name: [" + plugin.getFileName() + "]"
                throw new IllegalStateException("Unable to initialize plugins", ex);  
                        pluginsNames.add(bundle.plugin.getName());
            StringBuilder msg = new StringBuilder("Cycle found in plugin dependencies: ");  
        if (sortedBundles.contains(bundle)) {
        Constructor<T>[] constructors = (Constructor<T>[]) extensionClass.getConstructors();
                extensionSignatureMessage(extensionClass, extensionPointType, plugin)
                    + " is running"
            if (this == o) return true;
    public static void verifyCompatibility(PluginInfo info) {
                if (oldPlugin != null) {
        List<String> optionallyExtendedBy = new ArrayList<>();  
            modules.addAll(plugin.v2().createGuiceModules());
            Set<URL> libUrls = new LinkedHashSet<>();
                );
        PluginInfo candidateInfo,
     * @throws IOException if an I/O exception occurred reading the directories  
        };
    }  
            // check we don't have conflicting classes  
                    }
        }
            return Class.forName(className, false, loader).asSubclass(Plugin.class);
import java.util.Collections;
import java.util.function.Function;
        }  
import java.nio.file.DirectoryStream;  
                        Collections.emptyList(),  
     * Extracts all installed plugin directories from the provided {@code rootPath}.
        return new ArrayList<>(sortedBundles);
        }
    }
                if (intersection.isEmpty() == false) {
                    modulesList.add(bundle.plugin);
        return plugins;
    /** Returns all classes injected into guice by plugins which extend {@link LifecycleComponent}. */  
        Path configPath,  
            }
        if (constructor.getParameterCount() > 2) {  
     */
                            + setting
                "failed to create extension [" + extensionClass.getName() + "] of type [" + extensionPointType.getName() + "]",
        }
        try {  
        final ArrayList<ExecutorBuilder<?>> builders = new ArrayList<>();
     * @param rootPath the path where the plugins are installed
        Path pluginsDirectory,
    public static boolean isPluginVersionCompatible(final PluginInfo pluginInfo, final Version coreVersion) {
        if (modulesDirectory != null) {
        Path modulesDir
                "Plugin ["
    /** Get bundles for plugins installed in the given modules directory. */  
                }
            msg.append(name);
        @Override
        } finally {  
            this.urls = Objects.requireNonNull(urls);
                    if ("lib".equals(plugin.getFileName().toString()) && Files.isDirectory(plugin)) {  
        final Map<String, String> features = new TreeMap<>();
                            + oldPlugin
        }
                    try (DirectoryStream<Path> jarStream = Files.newDirectoryStream(sharedLibDir, "*.jar")) {  
    static <T> T createExtension(Class<? extends T> extensionClass, Class<T> extensionPointType, Plugin plugin) {
    public Settings updatedSettings() {  
        }
            final Optional<String> maybeFeature = plugin.v2().getFeature();
        for (PluginInfo pluginInfo : classpathPlugins) {
            // that have dependencies with their own SPI endpoints have a chance to load
        // this exposes only the SPI jars (plugins/lib/<name>/) of each extended plugin,
        /*  
    private final PluginsAndModules info;
        return bundle;
        }
        Path candidateDir,
                    logger.info(  
            throw new IllegalStateException("no public " + extensionConstructorMessage(extensionClass, extensionPointType));  
    );  
            }  
    // package-private for test visibility  
                throw new IllegalStateException(
                    Locale.ROOT,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Bundle> bundles,
                }  
import java.util.LinkedHashSet;  
                }  
        final Set<Bundle> bundles = new HashSet<>();  
        assert pluginInfos != null;
    // jar-hell check the bundle against the parent classloader and extended plugins
    private String signatureMessage(final Class<? extends Plugin> clazz) {
        // Checking expected plugins
        return String.format(  
    // a "bundle" is a group of jars in a single classloader  
    }  
    static void loadExtensions(List<Tuple<PluginInfo, Plugin>> plugins) {
    private static Bundle readPluginBundle(final Set<Bundle> bundles, final Path plugin, String type) throws IOException {
            throw new IllegalStateException("no unique public constructor for [" + pluginClass.getName() + "]");
                    + "] was built for OpenSearch version "  
                Class<? extends Plugin> pluginClazz = (Class<? extends Plugin>) Class.forName(pluginInfo.getClassname());  
            } else {  
     */  
        if (constructors.length == 0) {
            Bundle bundle = (Bundle) o;
            bundles.add(bundle);  
            for (String setting : settings.keySet()) {  
     * Constructs a new PluginService
import org.opensearch.common.settings.Settings;
        String name = bundle.plugin.getName();
                msg.append(s);
                            URL url = jar.toRealPath().toUri().toURL();
        } catch (Throwable t) {
                    logger.trace("plugin loaded from classpath [{}]", pluginInfo);  
import java.util.Map;  
            transitiveUrls.put(bundle.plugin.getName(), urls);
        }  
            return Objects.equals(plugin, bundle.plugin);
            throw new IllegalStateException(msg.toString());  
        }  
            union.addAll(bundle.urls);
    }
            }
                        "1.8",  
        if (bundle.libUrls.isEmpty() == false) {
    static class Bundle {
import java.util.TreeMap;
    /**
            );
            Set<URL> union = new HashSet<>(classpath);
    }
    private final List<Tuple<PluginInfo, Plugin>> plugins;
            return Objects.hash(plugin);
    public static void checkForFailedPluginRemovals(final Path pluginsDirectory) throws IOException {
import org.opensearch.core.common.Strings;  
        List<Tuple<PluginInfo, Plugin>> plugins = new ArrayList<>();
        // reload SPI with any new services from the plugin
import java.util.Set;  
        return extensions;
     * @return a Tuple where v1() is the list of plugins with required dependencies,
import org.opensearch.common.settings.Setting.Property;
            }  
        return Collections.unmodifiableList(plugins);  
     * @param modulesDirectory The directory modules exist in, or null if modules should not be loaded from the filesystem
        for (Tuple<PluginInfo, Plugin> plugin : plugins) {  
        for (Tuple<PluginInfo, Plugin> pluginTuple : plugins) {
                    seenBundles.addAll(plugins);  
                final String fileName = removing.getFileName().toString();
                    final String message = String.format(
 * the Apache License, Version 2.0 (the "License"); you may
        // Codecs:
            throw new IllegalArgumentException(  
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(pluginsDirectory, ".removing-*")) {
            try {
                Set<URL> intersection = new HashSet<>(urls);  
import java.util.Optional;
                    );
            builders.addAll(plugin.v2().getExecutorBuilders(settings));
            return;
        for (Bundle bundle : bundles) {
            .collect(Collectors.groupingBy(Tuple::v1, Collectors.mapping(Tuple::v2, Collectors.toList())));
    }
}
        if (constructor.getParameterCount() > 1) {
                return false;
 * specific language governing permissions and limitations
        if (constructors.length == 0) {  
                final String name = fileName.substring(1 + fileName.indexOf("-"));  
                // TODO: remove this leniency, but tests bogusly rely on it
        Settings settings,  
 */  
                return constructor.newInstance(plugin);
                    removing,
                        "NA",
        /** URLs from {@code plugins/lib/<name>/} only — the public API surface exposed to extending plugins. */
            assert sortedBundles.contains(depBundle);  
            throw new IllegalStateException(signatureMessage(pluginClass));
     * <p>  
    }
     */  
                }
                    if (plugin.getFileName().toString().startsWith(".") && !Files.isDirectory(plugin)) {  
            if (depBundle == null) {
            checkBundleJarHell(classpath, bundle, transitiveUrls);
        while (classIterator.hasNext()) {  
import java.util.Locale;
            }
                    continue;  
                if (intersection.isEmpty() == false) {
import java.util.Objects;
        Collection<PluginInfo> classpathPlugins  
 * not use this file except in compliance with the License.
     * @param pluginsDir the plugins directory
     * @param classpathPlugins Plugins that exist in the classpath which should be loaded  
                            + "This is expected when extended plugins share common ancestors.",
                        null,
        final List<String> pluginsNames = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
                    Strings.collectionToDelimitedString(pluginsNames, ", ")
        }
        List<Bundle> sortedBundles = sortBundles(bundles);
        }
            null,
        }  
                }
        final Constructor<?> constructor = constructors[0];
        if (bundles.add(bundle) == false) {
                }  
     *  
        for (Tuple<PluginInfo, Plugin> plugin : plugins) {
 * license agreements. See the NOTICE file distributed with
            checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveUrls);  
            Set<URL> intersection = new HashSet<>(classpath);
        List<Tuple<PluginInfo, Plugin>> pluginsLoaded = new ArrayList<>();
                intersection.retainAll(pluginUrls);  
        Map<String, Bundle> namedBundles = bundles.stream().collect(Collectors.toMap(b -> b.plugin.getName(), Function.identity()));
        if (pluginInfos.isEmpty()) {  
                        );  
     * @param classpathPlugins Plugins that exist in the classpath which should be loaded
    private static final Logger logger = LogManager.getLogger(PluginsService.class);
        final PluginInfo plugin;
        KnnVectorsFormat.reloadKnnVectorsFormat(loader);
        this(  
        final Set<URL> libUrls;
                    if (bundle.plugin.isExtendedPluginOptional(extendedPlugin)) {
                    extendingPluginsByName.getOrDefault(pluginTuple.v1().getName(), Collections.emptyList())  
                    + constructor.getParameterTypes()[0].getName()
     * Return the given bundles, sorted in dependency loading order.
                if (Files.isDirectory(sharedLibDir)) {
            final Iterator<Path> iterator = stream.iterator();
            throw new IllegalStateException("no public constructor for [" + pluginClass.getName() + "]");
        Path modulesDirectory,
                return Collections.unmodifiableList(result);
 * Unless required by applicable law or agreed to in writing,
            }
import java.nio.file.Files;
            this.plugin = Objects.requireNonNull(plugin);
            settings,
    private static <T> List<? extends T> createExtensions(Class<T> extensionPointType, Plugin plugin) {  
                for (Path plugin : stream) {
            throw new IllegalStateException("duplicate " + type + ": " + info);
        }
import org.apache.lucene.codecs.KnnVectorsFormat;
    static Set<Bundle> getModuleBundles(Path modulesDirectory) throws IOException {
                loadExtensionsForPlugin(
                    throw new IllegalArgumentException(  
            urls.addAll(bundle.urls);
        return builders;  
        return builder.put(this.settings).build();
                pluginsList.add(pluginInfo);  
                // extended plugin is optional and is not installed
        final Set<String> seen = new HashSet<>();
    private Class<? extends Plugin> loadPluginClass(String className, ClassLoader loader) {
     *  
            + " must be either () or ("
            Class<? extends T> extensionClass = classIterator.next();
            + ")";
 */
        }
                final Path removing = iterator.next();
            Set<URL> urls = new LinkedHashSet<>();  
    /**
            if (!range.isSatisfiedBy(coreVersion)) {
        for (final String feature : features.keySet()) {
            try {
                if (features.containsKey(feature)) {
                if (logger.isTraceEnabled()) {
            try {  
            // already added this plugin, via a dependency  
    }
     */  
        final Bundle bundle = new Bundle(info, plugin);  
    public PluginsService(
                            + "], already added in plugin ["  
                    // skip the reserved lib/ subdirectory used for shared library jars
            Set<String> missingPlugins = new HashSet<>();
            loaded.put(name, plugin);
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
                throw new IllegalStateException(message);
                assert pluginUrls != null : "transitive urls should have already been set for " + extendedPlugin;
    private final Path configPath;
                    URL url = jar.toRealPath().toUri().toURL();
    // the plugin cli does it, but we do it again, in case users mess with jar files manually  
 *  
     */
                }
                return (Plugin) constructor.newInstance();
        } else {
     * @throws IllegalStateException if a dependency cycle is found
        // Core version must satisfy the semver range in plugin info
    }  
        for (Bundle bundle : bundles) {
        this.settings = settings;
            pluginsDirectory,
import java.util.Collection;
     * Reloads all Lucene SPI implementations using the new classloader.  
            Locale.ROOT,
    public List<Setting<?>> getPluginSettings() {
            throw new IllegalStateException(
            this.libUrls = Collections.unmodifiableSet(libUrls);  
            "(org.opensearch.common.settings.Settings,java.nio.file.Path)",
     */
        if (!isPluginVersionCompatible(info, Version.CURRENT)) {
     * @param pluginsDirectory The directory plugins exist in, or null if plugins should not be loaded from the filesystem
            }
import java.util.HashSet;
 * @opensearch.internal
                        "Cannot have additional setting ["
        }
                            }  
import java.net.URL;
    public Collection<Class<? extends LifecycleComponent>> getGuiceServiceClasses() {
                }
import java.lang.reflect.Constructor;  
     * We keep around a list of plugins and modules
        }  
        "plugin.mandatory",
    public List<String> getPluginSettingsFilter() {  
    public static List<Path> findPluginDirs(final Path rootPath) throws IOException {
                        + pluginClass.getClassLoader()
        }
                    }  
                for (Path jar : jarStream) {  
        // noinspection unchecked  
    }
            }
 * Licensed to Elasticsearch under one or more contributor  
            );  
                urls.addAll(pluginUrls);
                    continue;
    public <T> List<T> filterPlugins(Class<T> type) {
        Path modulesDirectory,
        if (constructor.getParameterCount() == 1 && constructor.getParameterTypes()[0] != plugin.getClass()) {  
 * this work for additional information regarding copyright
        // invariant: any plugins this plugin bundle extends have already been added to transitiveUrls
                Set<URL> pluginUrls = transitiveUrls.get(extendedPlugin);  
            throw new OpenSearchException("Unable to load plugin class [" + className + "]", t);  
                        optionallyExtendedBy.add(bundle.plugin.getName());  
import org.apache.lucene.codecs.Codec;  
        logPluginInfo(info.getPluginInfos(), "plugin", logger);
            services.addAll(plugin.v2().getGuiceServiceClasses());
    public PluginsAndModules info() {
                        + "] (class loader ["
                intersection = new HashSet<>(bundle.urls);
                e  
            throw new IllegalStateException("external test module [" + plugin.getFileName() + "] found in non-snapshot build");
            JarHell.checkJarHell(urls, logger::debug); // check jarhell of each extended plugin against this plugin  
                        pluginsList.add(bundle.plugin);  
        }
    public PluginsService(
                    }
        try {  
            modulesDirectory,  
                        logger.warn(
                        + "] must reference a class loader local Plugin class ["
                    "Plugin ["  
    }  
                msg.append(" -> ");  
            for (String extendedPlugin : bundle.plugin.getExtendedPlugins()) {  
        Codec.reloadCodecs(loader);
    /**
        final Set<URL> urls;  
 * Service responsible for loading plugins and modules (internal and external)
        } catch (Exception e) {
import java.util.Iterator;
        for (String dependency : bundle.plugin.getExtendedPlugins()) {
                    if (seen.add(plugin.getFileName().toString()) == false) {  
    ) {
        }
         */  
                        throw new IllegalStateException("duplicate plugin: " + plugin);
/*  
    }
        // so that plugins extending this one see only the public API surface
        }
                }
            } catch (IOException ex) {
        List<PluginInfo> modulesList = new ArrayList<>();
            if (intersection.isEmpty() == false) {  
                }  
        }
            "no public constructor of correct signature for [%s]; must be [%s], [%s], or [%s]",
    public void onIndexModule(IndexModule indexModule) {  
        }
        List<Tuple<PluginInfo, Plugin>> loaded = loadBundles(seenBundles);
import org.apache.logging.log4j.Logger;
     * Constructs a new PluginService  
        for (final Tuple<PluginInfo, Plugin> plugin : plugins) {  
        }
                }  
                    p -> new PluginInfo(
                        intersection
            // also gather jars from plugins/lib/<plugin_name>/ if it exists.
        for (SemverRange range : pluginInfo.getOpenSearchVersionRanges()) {  
        for (Tuple<PluginInfo, Plugin> plugin : plugins) {
        if (mandatoryPlugins.isEmpty() == false) {
            plugin.v2().onIndexModule(indexModule);  
 * ownership. Elasticsearch licenses this file to you under  
            throw new IllegalStateException("failed to load plugin " + bundle.plugin.getName() + " due to jar hell", e);
        return services;  
 *  
            }
                    Strings.collectionToDelimitedString(missingPlugins, ", "),  
            if (extendedPlugin == null && bundle.plugin.isExtendedPluginOptional(extendedPluginName)) {
                            if (urls.add(url) == false) {
                        Locale.ROOT,  
                    + info.getOpenSearchVersionRangesString()
        }  
        } catch (final IOException e) {  
                } else {
            final Bundle bundle = readPluginBundle(bundles, plugin, type);
 *
                        feature,
                String oldPlugin = foundSettings.put(setting, plugin.v1().getName());
        dependencyStack.remove(name);
    // pkg private for tests  
                        false
    // get a bundle for a single plugin dir  
            }
import org.opensearch.Version;  
        LinkedHashSet<Bundle> sortedBundles = new LinkedHashSet<>();  
    // searches subdirectories under the given directory for plugin directories
            for (final String name : pluginInfos.stream().map(PluginInfo::getName).sorted().collect(Collectors.toList())) {  
                final String message = String.format(
     * their relative order from iteration of the provided set will not change.
    ) {
    static void reloadLuceneSPI(ClassLoader loader) {
     * This method must be called after the new classloader has been created to
import org.opensearch.core.service.ReportingService;
        LinkedHashSet<Bundle> sortedBundles,  
        Property.NodeScope
    public static Tuple<List<String>, List<String>> findPluginsByDependency(Path pluginsDir, String pluginName) throws IOException {
    }  
        final Class[] parameterTypes = constructor.getParameterTypes();
        if (dependencyStack.contains(name)) {
            }
        }
import org.opensearch.common.lifecycle.LifecycleComponent;
        }
                "Could not load plugin descriptor for " + type + " directory [" + plugin.getFileName() + "]",
                    if (urls.add(url) == false) {  
                    missingPlugins.add(mandatoryPlugin);
        extensiblePlugin.loadExtensions(extensionLoader);  
            // and initialize them appropriately.
            } catch (ClassNotFoundException e) {
                if (isAccessibleDirectory(pluginsDirectory, logger)) {
    }
            JarHell.checkJarHell(union, logger::debug);  
                            + "]"
import java.net.URLClassLoader;
        List<ClassLoader> extendedLoaders = new ArrayList<>();
/*
        DocValuesFormat.reloadDocValuesFormats(loader);  
            libLoaders.put(name, URLClassLoader.newInstance(bundle.libUrls.toArray(new URL[0]), libParent));
            }  
                        throw new IllegalStateException("duplicate codebase: " + url);
        if (pluginsDirectory != null) {
                        continue;
                    for (final Bundle bundle : plugins) {
    }
            if (constructor.getParameterCount() == 2 && parameterTypes[0] == Settings.class && parameterTypes[1] == Path.class) {  
            // contains a top-level lib/ directory.
    private List<Tuple<PluginInfo, Plugin>> loadBundles(Set<Bundle> bundles) {
        @Override  
    }
        Map<String, Plugin> loaded = new HashMap<>();  
    }
            Plugin extendedPlugin = loaded.get(extendedPluginName);  
        try {
        // if this plugin has lib jars, build a scoped classloader containing only those jars  
public class PluginsService implements ReportingService<PluginsAndModules> {  
        // first we load plugins that are on the classpath. this is for tests  
        return plugins.stream().flatMap(p -> p.v2().getSettings().stream()).collect(Collectors.toList());  
                        + "])"  
    }
    ) throws Exception {
import org.opensearch.OpenSearchException;
         * Check for the existence of a marker file that indicates any plugins are in a garbage state from a failed attempt to remove the
            clazz.getName(),  
                }  
        }  
import java.util.List;
                        requiredBy.add(bundle.plugin.getName());
 * GitHub history for details.
                if (bundle.plugin.isExtendedPluginOptional(extendedPlugin)) {
            throw new IllegalStateException(extensionSignatureMessage(extensionClass, extensionPointType, plugin));  
                    );  
                        bundle.plugin.getName(),  
            throw new IllegalStateException(
        bundles.add(new Bundle(candidateInfo, candidateDir));
        Set<URL> classpath,  
    }
    }
            logger.info("no " + type + "s loaded");
    /** Get bundles for plugins installed in the given plugins directory. */
                        continue;
        Bundle(PluginInfo plugin, Path dir) throws IOException {
import java.nio.file.Path;
    @SuppressWarnings("removal")  
        this.configPath = configPath;  
                        "classpath plugin",  
        for (Bundle bundle : sortedBundles) {
                    extensiblePlugin,
        return findBundles(modulesDirectory, "module");
    }
        List<T> extensions = new ArrayList<>();
            classpathPlugins.stream()
    // package-private for test visibility
        this.plugins = Collections.unmodifiableList(pluginsLoaded);  
        );
                seenBundles.addAll(modules);
    /**
                    "found file [%s] from a failed attempt to remove the plugin [%s]; execute [opensearch-plugin remove %2$s]",  
                    throw new IllegalArgumentException(message);  
                    plugins.add(plugin);  
            Settings settings = plugin.v2().additionalSettings();
                        dependency,  
            @Override
                    } else {
                        }
        return modules;
                throw new IllegalStateException(signatureMessage(pluginClass));
                )  
                logger.info("loaded " + type + " [" + name + "]");
     * Finds plugins that depend on the given plugin.  
        if (Files.exists(rootPath)) {
        Set<Bundle> bundles = new HashSet<>(getPluginBundles(pluginsDir));  
                    }
        ClassLoader loader = URLClassLoader.newInstance(bundle.urls.toArray(new URL[0]), parentLoader);
                features.put(feature, plugin.v1().getName());
            }
                List<T> result = new ArrayList<>();
        Collections.emptyList(),  
            } else if (constructor.getParameterCount() == 1 && parameterTypes[0] == Settings.class) {
            throw new IllegalStateException("failed to load plugin class [" + pluginClass.getName() + "]", e);
        JarHell.checkJavaVersion(info.getName(), info.getJavaVersion());
            addSortedBundle(depBundle, bundles, sortedBundles, dependencyStack);
                Path sharedLibDir = dir.getParent().resolve("lib").resolve(dir.getFileName());
                if (!pluginsNames.contains(mandatoryPlugin) && !missingPlugins.contains(mandatoryPlugin)) {
                intersection.retainAll(pluginUrls);
            ClassLoader extLoader = libLoaders.getOrDefault(extendedPluginName, extendedPlugin.getClass().getClassLoader());
 * Modifications Copyright OpenSearch Contributors. See
        if (type.equals("module") && info.getName().startsWith("test-") && Build.CURRENT.isSnapshot() == false) {
        // collect lib-only loaders of extended plugins as parents.  
            for (String mandatoryPlugin : mandatoryPlugins) {  
                            + "Some features of this plugin may not function without the dependencies being installed.",
            "()"  
        // load modules  
                    throw new IllegalStateException(
    /**
    @Override
import org.apache.lucene.codecs.DocValuesFormat;
     * @return a list of all plugin paths installed in the {@code rootPath}
            // check we don't have conflicting codebases with core  
        List<String> requiredBy = new ArrayList<>();
                return (Plugin) constructor.newInstance(settings, configPath);
            builder.put(settings);  
import static org.opensearch.core.util.FileSystemUtils.isAccessibleDirectory;
                throw new IllegalStateException("Unable to initialize modules", ex);  
        return bundles;  
        return plugins.stream().flatMap(p -> p.v2().getSettingsFilter().stream()).collect(Collectors.toList());
                        Version.CURRENT,
                        "Plugin [{}] extends multiple plugins/modules that share common dependencies: {}. "
                return (Plugin) constructor.newInstance(settings);  
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {  
            ClassLoader libParent = PluginLoaderIndirection.createLoader(getClass().getClassLoader(), extendedLoaders);  
                    "missing mandatory plugins [%s], found plugins [%s]",
     */
import org.opensearch.threadpool.ExecutorBuilder;
            + extensionConstructorMessage(extensionClass, extensionPointType)
        verifyCompatibility(bundle.plugin);
    private static void addSortedBundle(  
 * compatible open source license.
        final List<Path> plugins = new ArrayList<>();  
            assert extendedPlugin != null;
    }
                for (Plugin extendingPlugin : extendingPlugins) {
        // but for now: just be transparent so we can debug any potential issues
                    Set<Bundle> plugins = getPluginBundles(pluginsDirectory);
        return info;  
                );  
                        for (Path jar : jarStream) {
    }  
        // not the full implementation classloader, so extending plugins cannot accidentally
            } else if (constructor.getParameterCount() == 0) {
                pluginsLoaded.add(new Tuple<>(pluginInfo, plugin));
        } catch (ReflectiveOperationException e) {  
            .flatMap(t -> t.v1().getExtendedPlugins().stream().map(extendedPlugin -> Tuple.tuple(extendedPlugin, t.v2())))  
            throw new IllegalStateException(
            if (pluginTuple.v2() instanceof ExtensiblePlugin extensiblePlugin) {  
        }
            if (constructor.getParameterCount() == 0) {
    static void checkBundleJarHell(Set<URL> classpath, Bundle bundle, Map<String, Set<URL>> transitiveUrls) {
        try {
        Set<Bundle> seenBundles = new LinkedHashSet<>();
        // we need to build a List of plugins for checking mandatory plugins
        }  
        List<String> mandatoryPlugins = MANDATORY_SETTING.get(settings);  
                    );
                    + ")"
        List<Module> modules = new ArrayList<>();  
                .collect(Collectors.toList())
    private Plugin loadBundle(Bundle bundle, Map<String, Plugin> loaded, Map<String, ClassLoader> libLoaders) {
            public <T> List<T> loadExtensions(Class<T> extensionPointType) {  
            }
        // now, find all the ones that are in plugins/
    }
    private static <T> String extensionConstructorMessage(Class<? extends T> extensionClass, Class<T> extensionPointType) {
            logger.debug("Loading plugin [" + name + "]...");
                        name
        if (constructors.length > 1) {
     */  
            extensions.add(createExtension(extensionClass, extensionPointType, plugin));
            }
                );
                Set<Bundle> modules = getModuleBundles(modulesDirectory);  
        for (final Path plugin : findPluginDirs(directory)) {
                continue;  
        Bundle bundle,
                    );
     * Verify the given plugin is compatible with the current OpenSearch installation.
import java.io.IOException;
        loadExtensions(pluginsLoaded);  
 * The OpenSearch Contributors require contributions made to  
        }
package org.opensearch.plugins;
            return plugin;
        }
            if (maybeFeature.isPresent()) {
                        "jar hell! duplicate codebases with extended plugin [" + extendedPlugin + "]: " + intersection  
    }  
        final Constructor<?>[] constructors = pluginClass.getConstructors();
            }
    }
        return true;
        ExtensiblePlugin.ExtensionLoader extensionLoader = new ExtensiblePlugin.ExtensionLoader() {
                    + Version.CURRENT  
    private final Settings settings;
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
    ) {
        List<PluginInfo> pluginsList = new ArrayList<>();  
        );
    private static void logPluginInfo(final List<PluginInfo> pluginInfos, final String type, final Logger logger) {
                        plugin.v1().getName(),  
        List<String> exts = bundle.plugin.getExtendedPlugins();  
        }
        Map<String, Set<URL>> transitiveUrls = new HashMap<>();
        for (String extendedPluginName : bundle.plugin.getExtendedPlugins()) {
            if (loader != pluginClass.getClassLoader()) {
        LinkedHashSet<String> dependencyStack = new LinkedHashSet<>();
            + plugin.getClass().getName()  
                    }
            Bundle depBundle = bundles.get(dependency);  
        }
                }  
            // opensearch-plugin installs shared library jars there when a plugin zip  
            }
        final PluginInfo info;  
    static Set<Bundle> getPluginBundles(final Path pluginsDirectory) throws IOException {  
                    checkForFailedPluginRemovals(pluginsDirectory);  
                    );
import org.opensearch.common.bootstrap.JarHell;
            }
        String name = bundle.plugin.getName();
            } catch (IOException ex) {
    }
import org.opensearch.semver.SemverRange;
        return "constructor for extension [" + extensionClass.getName() + "] of type [" + extensionPointType.getName() + "]";
            Plugin plugin = loadPlugin(pluginClass, settings, configPath);  
        logger.info("PluginService:onIndexModule index:" + indexModule.getIndex());
        return "signature of "  
            if (!missingPlugins.isEmpty()) {
            throw new IllegalStateException("no unique public " + extensionConstructorMessage(extensionClass, extensionPointType));
 * SPDX-License-Identifier: Apache-2.0
        }
        Map<String, ClassLoader> libLoaders = new HashMap<>();  
                        + name
        if (constructors.length > 1) {  
import org.opensearch.common.collect.Tuple;  
            } else {  
                    // normalize with toRealPath to get symlinks out of our hair
        bundles.addAll(getModuleBundles(modulesDir));
import org.apache.lucene.codecs.PostingsFormat;  
                pluginsNames.add(pluginInfo.getName());
/*  
import org.apache.logging.log4j.LogManager;
            }
        }
                    }
                    logger.info(  
    public static final Setting<List<String>> MANDATORY_SETTING = Setting.listSetting(
    }  
            // Set context class loader to plugin's class loader so that plugins  
    // add the given bundle to the sorted bundles, first adding dependencies
        }
        LogManager.getLogger(PluginsService.class).trace("--- adding [{}] [{}]", type, plugin.toAbsolutePath());
         * plugin.
            }
                        p.getName(),
 */
            );
        }
        final Constructor<T> constructor = constructors[0];
import org.opensearch.common.inject.Module;
            }
        try {
import org.opensearch.transport.TransportSettings;  
        return new Tuple<>(requiredBy, optionallyExtendedBy);
     * @param pluginName the plugin name to find dependents for  
    }  
 * under the License.  
                return constructor.newInstance();
                e  
            // prefer the lib-only classloader if the extended plugin has one; fall back to its full classloader  
    /**
 * software distributed under the License is distributed on an
    public static void checkJarHellForPlugin(
                    name
        Map<String, Set<URL>> transitiveUrls = new HashMap<>();
        public int hashCode() {  
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
        pluginsLoaded.addAll(loaded);
        }  
                        "Missing optional plugin [{}], dependency of [{}]. "
/**
    }  
import org.opensearch.common.settings.Setting;  
                                throw new IllegalStateException("duplicate codebase: " + url);
    private static Set<Bundle> findBundles(final Path directory, String type) throws IOException {
            Class<? extends Plugin> pluginClass = loadPluginClass(bundle.plugin.getClassname(), loader);  
    static List<Bundle> sortBundles(Set<Bundle> bundles) {
    /**
        Collection<Class<? extends Plugin>> classpathPlugins  
                JarHell.checkJarHell(urls, logger::debug); // check jarhell as we add each extended plugin's urls
                            + "in plugin ["
                Plugin plugin = loadPlugin(pluginClazz, settings, configPath);
        }  
                for (Bundle bundle : modules) {
    }
        }  
        }
                        "duplicate feature [%s] in plugin [%s], already added in [%s]",
 * this file be licensed under the Apache-2.0 license or a
                    + " but version "
        }
    public Collection<Module> createGuiceModules() {
                            libUrls.add(url);  
            if (ExtensiblePlugin.class.isInstance(extendedPlugin) == false) {  
        // we don't log jars in lib/ we really shouldn't log modules,
        List<Bundle> sortedBundles = sortBundles(bundles);
        // create a child to load the plugin in this bundle
                    + info.getName()
            Thread.currentThread().setContextClassLoader(loader);  
                            + "] "  
        this.info = new PluginsAndModules(pluginsList, modulesList);
        PostingsFormat.reloadPostingsFormats(loader);
        Function.identity(),
        return findBundles(pluginsDirectory, "plugin");
                }
        }  
            final Plugin plugin = loadBundle(bundle, loaded, libLoaders);
                final String message = String.format(  
                );
            info = PluginInfo.readFromProperties(plugin);
        Path pluginsDirectory,
import org.opensearch.index.IndexModule;
    }
        // depend on internal implementation classes of the plugin they extend.  
            Thread.currentThread().setContextClassLoader(cl);
            if (dir.getParent() != null) {  
            intersection.retainAll(bundle.urls);
     * This sort is stable, so that if two plugins do not have any interdependency,
    @SuppressWarnings("unchecked")  
    }  
        Map<String, String> foundSettings = new HashMap<>();
            for (String extendedPlugin : exts) {
                throw new IllegalStateException("Plugin [" + name + "] cannot extend non-extensible plugin [" + extendedPluginName + "]");
    private Plugin loadPlugin(Class<? extends Plugin> pluginClass, Settings settings, Path configPath) {
            plugins.add(new Tuple<>(bundle.plugin, plugin));  
        for (Tuple<PluginInfo, Plugin> plugin : plugins) {
                logger.error("Failed to load classpath plugin: " + pluginInfo.getClassname());  
        final Settings.Builder builder = Settings.builder();  
        try {
     * @param settings The settings of the system
                if (extendedPlugin.equals(pluginName)) {
        Path pluginsDir,  
     *         and v2() is the list of plugins with optional dependencies
        LinkedHashSet<String> dependencyStack
                        p.getName(),
        }  
 */  
    }
    }
                final String feature = maybeFeature.get();  
            extendedLoaders.add(extLoader);
                throw new IllegalStateException("jar hell! duplicate codebases between plugin and core: " + intersection);
        // do NOT change the order of these method calls!
    /**
                        + bundle.plugin.getClassname()  
            "(org.opensearch.common.settings.Settings)",
        } catch (final ReflectiveOperationException e) {  
        // tracks a lib-only classloader per plugin name, used as the parent for extending plugins
import java.util.HashMap;  
     */  
                .map(  
import org.opensearch.lucene.util.SPIClassIterator;  
            }
    }
        Set<Bundle> bundles = getPluginBundles(pluginsDir);
        }  
        List<Class<? extends LifecycleComponent>> services = new ArrayList<>();
                    }
     *
            );
        logPluginInfo(info.getModuleInfos(), "module", logger);  
                    )
     * @param settings The settings of the system  
        Settings settings,
                    + ", not ("  
            // gather urls for jar files in the plugin directory
            }  
                    result.addAll(createExtensions(extensionPointType, extendingPlugin));  
            builder.put(TransportSettings.FEATURE_PREFIX + "." + feature, true);  
            try (DirectoryStream<Path> jarStream = Files.newDirectoryStream(dir, "*.jar")) {
        for (Bundle bundle : sortedBundles) {  
            final Logger logger = LogManager.getLogger(JarHell.class);  
        dependencyStack.add(name);
    private static void loadExtensionsForPlugin(ExtensiblePlugin extensiblePlugin, List<Plugin> extendingPlugins) {  
        SPIClassIterator<T> classIterator = SPIClassIterator.get(extensionPointType, plugin.getClass().getClassLoader());
        return plugins.stream().filter(x -> type.isAssignableFrom(x.v2().getClass())).map(p -> ((T) p.v2())).collect(Collectors.toList());
import java.util.ArrayList;  
        Map<String, List<Plugin>> extendingPluginsByName = plugins.stream()
 *    http://www.apache.org/licenses/LICENSE-2.0
        public boolean equals(Object o) {
            }
 *
                    Locale.ROOT,
    }  
