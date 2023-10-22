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
            val location = Location(player.world, player.location.x, player.location.y - 1.0, player.location.z)
            if (location.block.type == Material.AIR) return
            val (blocks, nonBlocks) = Material.values().partition {
                it.isBlock
            }
            location.block.blockData = blocks.shuffled()[0].createBlockData()
            location.block.type = blocks.shuffled()[0]
        }
    }
}