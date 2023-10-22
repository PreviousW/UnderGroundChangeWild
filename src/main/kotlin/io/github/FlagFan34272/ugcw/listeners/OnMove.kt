package io.github.FlagFan34272.ugcw.listeners

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class OnMove: Listener {
    @EventHandler
    fun PlayerMoveEvent.onMove() {
        if (hasChangedBlock()) {
            if (from.x == to.x &&  from.z == to.z) return
            Location(player.world, player.location.x, player.location.y - 1.0, player.location.z).apply {
                if (block.type == Material.AIR) return
                if (block.type == Material.WATER) return
                val (blocks, nonBlocks) = Material.values().partition { it.isBlock }
                block.blockData = blocks.shuffled()[0].createBlockData()
                block.type = blocks.shuffled()[0]
            }
        }
    }
}
