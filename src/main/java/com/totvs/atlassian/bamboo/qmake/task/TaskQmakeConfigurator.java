package com.totvs.atlassian.bamboo.qmake.task;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.atlassian.bamboo.collections.ActionParametersMap;
import com.atlassian.bamboo.task.AbstractTaskConfigurator;
import com.atlassian.bamboo.task.TaskConfiguratorHelper;
import com.atlassian.bamboo.task.TaskDefinition;
import com.atlassian.bamboo.utils.error.ErrorCollection;
import com.atlassian.struts.TextProvider;
import com.atlassian.util.concurrent.NotNull;
import com.google.common.collect.ImmutableList;

public class TaskQmakeConfigurator extends AbstractTaskConfigurator {
	
	private TextProvider textProvider;

	private static final String UI_DEPLOY_TYPE_LIST = "deployTypeList";
	
	private static final List<String> deployTypeList = ImmutableList.of(
            new String("Framework"),
            new String("Interface"),
            new String("Jake"),
            new String("Broker Hub")
    );

	public void setTextProvider(final TextProvider textProvider) {
		this.textProvider = textProvider;
	}

	public Map<String, String> generateTaskConfigMap(
			ActionParametersMap params, TaskDefinition previousTaskDefinition) {

		final Map<String, String> config = super.generateTaskConfigMap(params,
				previousTaskDefinition);

		config.put("buildConfigure", params.getString("buildConfigure"));
		config.put("qmakeSpec", params.getString("Qmake Spec"));
		config.put("aditionalArgs", params.getString("Aditional Arguments"));

		return config;
	}

	public void populateContextForCreate(
			@NotNull final Map<String, Object> context) {

		super.populateContextForCreate(context);

		context.put("say", "Hello, World!");

	}

	public void populateContextForEdit(
			@NotNull final Map<String, Object> context,
			@NotNull final TaskDefinition taskDefinition) {
		super.populateContextForEdit(context, taskDefinition);

		context.put("buildConfigure", taskDefinition.getConfiguration().get("buildConfigure"));
		context.put("qmakeSpec", taskDefinition.getConfiguration().get("qmakeSpec"));
		context.put("aditionalArgs", taskDefinition.getConfiguration().get("aditionalArgs"));
		
	}

	public void validate(@NotNull final ActionParametersMap params,
			@NotNull final ErrorCollection errorCollection) {

		super.validate(params, errorCollection);

		final String buildConfigure = params.getString("buildConfigure");
		if (StringUtils.isEmpty(buildConfigure)) {
			errorCollection.addError("buildConfigure","Build Qt Version is required.");
					//textProvider.getText("Build Qt Version is required."));
		}
	}

}