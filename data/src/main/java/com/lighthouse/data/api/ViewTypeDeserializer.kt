package com.lighthouse.data.api

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.lighthouse.domain.response.ContentVO
import com.lighthouse.domain.response.ViewType
import com.lighthouse.domain.response.ViewType.Companion.findClassByItsName
import com.lighthouse.domain.response.ViewTypeVO
import java.lang.reflect.Type

class ViewTypeDeserializer : JsonDeserializer<ViewTypeVO> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?,
    ): ViewTypeVO {
        val jsonObject = json?.asJsonObject ?: throw IllegalArgumentException("Json Parsing 실패")
        val id = jsonObject["id"].asInt
        val viewTypeString = jsonObject["name"].asString
        val viewType: ViewType = findClassByItsName(viewTypeString)
        val content = jsonObject["contents"].asJsonObject
        val contentVO: Type = ViewType.findViewTypeClassByItsName(viewTypeString)
        val deserialize: ContentVO = Gson().fromJson(content, contentVO)
        return ViewTypeVO(id, viewType, deserialize)
    }
}