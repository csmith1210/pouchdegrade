package com.pouchdegrade;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Essence Pouch Time to Degrade"
)
public class EssencePouchTimeToDegradePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private EssencePouchTimeToDegradeConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Essence Pouch Time to Degrade started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Essence Pouch Time to Degrade stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Essence Pouch Time to Degrade says " + config.greeting(), null);
		}
	}

	@Provides
	EssencePouchTimeToDegradeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EssencePouchTimeToDegradeConfig.class);
	}
}
