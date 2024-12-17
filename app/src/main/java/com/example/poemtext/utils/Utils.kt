package com.example.myapplication.utils

import com.example.myapplication.model.PageData
import com.example.poemtext.R
import java.util.Map

object Utils {
    val map: HashMap<String, PageData> = HashMap<String, PageData>(
        Map.ofEntries<String, PageData>(
            Map.entry<String, PageData>(
                "image1",
                PageData(R.drawable.image1, "海上生明月，天涯共此时")
            ),
            Map.entry<String, PageData>(
                "image2",
                PageData(R.drawable.image2, "桃花潭水深千尺，不及汪伦送我情")
            ),
            Map.entry<String, PageData>(
                "image3",
                PageData(R.drawable.image3, "草长莺飞二月天，拂堤杨柳醉春烟")
            ),
            Map.entry<String, PageData>(
                "image4",
                PageData(R.drawable.image4, "举头望明月，低头思故乡")
            ),
            Map.entry<String, PageData>(
                "image5",
                PageData(R.drawable.image5, "借问酒家何处有，牧童遥指杏花村")
            ),
            Map.entry<String, PageData>(
                "image6",
                PageData(R.drawable.image6, "姑苏城外寒山寺，夜半钟声到客船")
            ),
            Map.entry<String, PageData>("image7", PageData(R.drawable.image7, "鹅鹅鹅，曲项向天歌")),
            Map.entry<String, PageData>(
                "image8",
                PageData(R.drawable.image8, "野火烧不尽，春风吹又生")
            ),
            Map.entry<String, PageData>(
                "image9",
                PageData(R.drawable.image9, "小荷才露尖尖角，早有蜻蜓立上头")
            ),
            Map.entry<String, PageData>(
                "image10",
                PageData(R.drawable.image10, "草长莺飞二月天，拂堤杨柳醉春烟")
            )

        )
    )
}