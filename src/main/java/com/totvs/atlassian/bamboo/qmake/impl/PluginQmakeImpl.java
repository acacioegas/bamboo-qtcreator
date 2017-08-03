package com.totvs.atlassian.bamboo.qmake.impl;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;
import com.totvs.atlassian.bamboo.qmake.api.PluginQmake;

import javax.inject.Inject;
import javax.inject.Named;

@ExportAsService ({PluginQmake.class})
@Named ("PluginQmake")
public class PluginQmakeImpl implements PluginQmake
{
    @ComponentImport
    private final ApplicationProperties applicationProperties;

    @Inject
    public PluginQmakeImpl(final ApplicationProperties applicationProperties)
    {
        this.applicationProperties = applicationProperties;
    }

    public String getName()
    {
        if(null != applicationProperties)
        {
            return "pluginQmake:" + applicationProperties.getDisplayName();
        }
        
        return "PluginQmake";
    }
}