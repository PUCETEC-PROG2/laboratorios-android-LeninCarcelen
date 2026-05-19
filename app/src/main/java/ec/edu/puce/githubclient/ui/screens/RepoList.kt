package ec.edu.puce.githubclient.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.puce.githubclient.models.GithubUser
import ec.edu.puce.githubclient.models.Repository
import ec.edu.puce.githubclient.ui.components.RepoItem
import ec.edu.puce.githubclient.viewmodels.RepoListViewModel
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RepoList(
    modifier: Modifier = Modifier,
    viewModel: RepoListViewModel = viewModel()
) {
    val repos by viewModel.repos.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMsg by viewModel.errorMsg.collectAsState()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        errorMsg?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(all = 16.dp)
            )
        }
        if (!isLoading && errorMsg == null) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(repos) { repository ->
                    RepoItem(repository = repository)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoListPreview() {
    val sampleRepos = listOf(
        Repository(
            id = 1L,
            name = "Repositorio Django",
            owner = GithubUser(1L, "django", "https://static.vecteezy.com/system/resources/thumbnails/047/656/219/small_2x/abstract-logo-design-for-any-corporate-brand-business-company-vector.jpg"),
            description = "Proyecto de python",
            language = "Python"
        ),
        Repository(
            id = 2L,
            name = "Repositorio IOS",
            owner = GithubUser(2L, "apple", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROiYLjNTZTJfK0oiJnbjByPaQmX2DJD7S5Uw&s"),
            description = "Proyecto de IOS",
            language = "Swift"
        )
    )
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(sampleRepos) { repo ->
            RepoItem(repository = repo)
        }
    }
}
