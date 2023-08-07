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
        MiItem("MAYASARP", itemImage = R.drawable.ic_monster_snake),
        MiItem("RAVAAN", itemImage = R.drawable.ic_ravan),
        MiItem("NIKUMBHA", itemImage = R.drawable.ic_monstor_purp),
        MiItem("BAL-HANUMAN", itemImage = R.drawable.ic_hanuman),
        MiItem("MASTAKASURA", itemImage = R.drawable.ic_monster_modok),
        MiItem("AHIRAAVAM", itemImage = R.drawable.ic_moster_ice),
        MiItem("DEAD BLUE", itemImage = R.drawable.ic_dead_blue),
        MiItem("NIKUMBHA", itemImage = R.drawable.ic_monstor_purp),
        MiItem("MAYASARP", itemImage = R.drawable.ic_monster_snake),
        MiItem("MASTAKASURA", itemImage = R.drawable.ic_monster_modok),
    )
}
