package android.com.viper.model.response

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

const val GITHUB_SEARCH_RESULTS = "github_search_results"

@Entity(tableName = GITHUB_SEARCH_RESULTS)
data class GitHubSearchResultItem(
  @PrimaryKey
  @ColumnInfo(name = "repo_id")
  @SerializedName("id") var id: String,
  @ColumnInfo(name = "name")
  @SerializedName("name") val name: String,
  @ColumnInfo(name = "full_name")
  @SerializedName("full_name") val full_name: String,
  @ColumnInfo(name = "repo_url")
  @SerializedName("html_url") val html_url: String,
  @ColumnInfo(name = "repo_description")
  @SerializedName("description") override var description: String?,
  @Embedded
  @SerializedName("owner") val owner: RepositoryOwnerModel
) : SearchResultsInfo {

  override fun getRepoDescription(): String? {
    return if (description.isNullOrBlank()) "No description available" else description
  }
}

