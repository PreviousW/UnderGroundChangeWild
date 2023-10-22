package io.github.FlagFan34272.ugcw

import io.github.FlagFan34272.ugcw.listeners.OnMove
import org.bukkit.plugin.java.JavaPlugin

class UnderGroundCore: JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(OnMove(), this)
    }
}