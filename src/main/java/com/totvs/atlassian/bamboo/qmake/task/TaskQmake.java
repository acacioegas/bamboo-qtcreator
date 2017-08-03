package com.totvs.atlassian.bamboo.qmake.task;

import com.atlassian.bamboo.build.logger.BuildLogger;
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskResultBuilder;
import com.atlassian.bamboo.task.TaskType;

public class TaskQmake implements TaskType
{

    public TaskResult execute(final TaskContext taskContext) throws TaskException
    {
        final BuildLogger buildLogger = taskContext.getBuildLogger();

        final String confBuild = taskContext.getConfigurationMap().get("buildConfigure");
        final String qtspec = taskContext.getConfigurationMap().get("qmakeSpec");
        final String addArgs = taskContext.getConfigurationMap().get("aditionalArgs");

        buildLogger.addBuildLogEntry("Qmake Plugin!");
        buildLogger.addBuildLogEntry(confBuild);

        return TaskResultBuilder.create(taskContext).success().build();
    }
}