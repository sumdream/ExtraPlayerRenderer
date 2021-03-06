package com.github.tartaricacid.extraplayerrenderer.command;

import com.github.tartaricacid.extraplayerrenderer.gui.GuiRenderConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class OpenConfigCommand extends CommandBase {
    private static final String NAME = "epr";
    private static final String USAGE = "/epr";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return USAGE;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        new Thread(() -> {
            try {
                Minecraft.getMinecraft().addScheduledTask(() -> Minecraft.getMinecraft().displayGuiScreen(new GuiRenderConfig()));
            } catch (Throwable e) {
            }
        }, "I18n_NOTICE_PENDING_THREAD").start();
    }
}
