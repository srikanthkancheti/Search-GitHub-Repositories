package android.com.viper.model.response

interface SearchResultsInfo {
  var description: String?

  fun getRepoDescription(): String? {
    return description
  }
}