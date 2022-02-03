package com.pouchdegrade;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class EssencePouchTimeToDegradePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(EssencePouchTimeToDegradePlugin.class);
		RuneLite.main(args);
	}
}