package com.mi.collapsingToolbarWithMotionCompose.data.mockdata

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mi.collapsingToolbarWithMotionCompose.R
import com.mi.collapsingToolbarWithMotionCompose.data.model.MiItem

class ListPreviewParameterProvider : PreviewParameterProvider<List<MiItem>> {
    override val values = sequenceOf(
        populateList()
    )
}

fun populateList(): List<MiItem> {
    return listOf(
        MiItem("Spike Top", itemImage = R.drawable.ic_spike_top),
        MiItem("Blooper", itemImage = R.drawable.ic_blooper),
        MiItem("Yoshi", itemImage = R.drawable.ic_yoshi),
        MiItem("Luigi", itemImage = R.drawable.ic_luigi),
        MiItem("Princess Daisy", itemImage = R.drawable.ic_princess_daisy),
        MiItem("Paratroop", itemImage = R.drawable.ic_koopa_paratroopa),
        MiItem("Toadette", itemImage = R.drawable.ic_toadette),
        MiItem("Ice Mario", itemImage = R.drawable.ic_ice_mario),
        MiItem("Bullet", itemImage = R.drawable.ic_bullet),
        MiItem("Piranha Flower", itemImage = R.drawable.ic_piranha_flower),
        MiItem("Wii", itemImage = R.drawable.ic_wii),
        MiItem("Wii Dragon", itemImage = R.drawable.ic_wii_dragon)
    )
}
