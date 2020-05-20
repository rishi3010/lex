package com.guardian.bean;

public class BotResponse {

	private String projectName;

	private String environment;

	private String action;

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public BotResponse setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}

	/**
	 * @param environment the environment to set
	 */
	public BotResponse setEnvironment(String environment) {
		this.environment = environment;
		return this;
	}

	/**
	 * @param action the action to set
	 */
	public BotResponse setAction(String action) {
		this.action = action;
		return this;
	}
}
