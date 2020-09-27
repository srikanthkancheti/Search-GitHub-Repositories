package android.com.viper.model.response

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepositoryOwnerModel(
  @ColumnInfo(name = "owner_login")
  @SerializedName("login") val login: String,
  @ColumnInfo(name = "owner_avatar_url")
  @SerializedName("avatar_url") val avatar_url: String
): Serializable