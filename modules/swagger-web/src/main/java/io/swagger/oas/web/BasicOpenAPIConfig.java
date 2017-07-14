package io.swagger.oas.web;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.swagger.oas.models.OpenAPI;

public final class BasicOpenAPIConfig implements OpenAPIConfig {
    private Set<String> resourcesBeScanned;
    private Map<String, Object> environment;
    private Class<?> filterClass;
    private Collection<String> ignoredRoutes;
    private OpenAPI openAPI;
    private boolean scanAllResources;

    public BasicOpenAPIConfig() {
        resourcesBeScanned = Collections.<String>emptySet();
        environment = Collections.<String, Object>emptyMap();
        ignoredRoutes = Collections.<String>emptySet();
    }

    @Override
    public Set<String> getResources() {
        return resourcesBeScanned;
    }

    public OpenAPIConfig setResources(Set<String> resourcesBeScanned) {
        this.resourcesBeScanned = resourcesBeScanned == null || resourcesBeScanned.isEmpty()
                ? Collections.<String>emptySet() : Collections.unmodifiableSet(resourcesBeScanned);
        return this;
    }

    @Override
    public Class<?> getFilterClass() {
        return filterClass;
    }

    public OpenAPIConfig setFilterClass(Class<?> filterClass) {
        this.filterClass = filterClass;
        return this;
    }

    @Override
    public Collection<String> getIgnoredRoutes() {
        return ignoredRoutes;
    }

    public OpenAPIConfig setIgnoredRoutes(Collection<String> ignoredRoutes) {
        this.ignoredRoutes = ignoredRoutes == null || ignoredRoutes.isEmpty() ? Collections.<String>emptySet()
                : Collections.unmodifiableCollection(new HashSet<String>(ignoredRoutes));
        return this;
    }

    @Override
    public OpenAPI getOpenAPI() {
        return openAPI;
    }

    public OpenAPIConfig setOpenAPI(OpenAPI openAPI) {
        this.openAPI = openAPI;
        return this;
    }

    @Override
    public Map<String, Object> getUserDefinedOptions() {
        return environment;
    }

    public OpenAPIConfig setUserDefinedOptions(Map<String, Object> environment) {
        this.environment = environment == null || environment.isEmpty() ? Collections.<String, Object>emptyMap()
                : Collections.unmodifiableMap(new HashMap<>(environment));
        return this;
    }

    @Override
    public boolean isScanAllResources() {
        return scanAllResources;
    }

    public void setScanAllResources(boolean scanAllResources) {
        this.scanAllResources = scanAllResources;
    }
}