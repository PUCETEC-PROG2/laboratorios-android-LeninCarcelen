package ec.edu.puce.githubclient.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ec.edu.puce.githubclient.ui.components.RepoItem

@Composable
fun RepoItemPreview() {
    RepoItem(
        name = "Repositorio Django",
        description = "Proyecto de python",
        avatarImg = "https://e7.pngegg.com/pngimages/10/113/png-clipart-django-web-development-web-framework-python-software-framework-django-text-trademark-thumbnail.png",
        "Python"
    )

    RepoItem(
        name = "Repositorio IOS",
        description = "Proyecto de IOS",
        avatarImg = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROiYLjNTZTJfK0oiJnbjByPaQmX2DJD7S5Uw&s",
        "Python"
    )

    RepoItem(
        name = "Repositorio Android",
        description = "Proyecto de Kotlin",
        avatarImg = "https://www.vhv.rs/dpng/d/588-5882846_ios-app-transparent-ios-logo-png-png-download.png",
        "Python"
    )
}
@Preview(showBackground = true)
@Composable
fun RepoListPreview(){

}