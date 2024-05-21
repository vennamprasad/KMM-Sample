import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import data.RandomUser
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun AndroidApp(userList: List<RandomUser>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(userList, key = {
                it.login?.uuid ?: ""
            }) { user ->

                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = 4.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically)
                    {
                        AsyncImage(
                            model = user.picture?.large ?: "",
                            contentDescription = null,
                        )
                        Column(modifier = Modifier.padding(8.dp))
                        {
                            // Display user details
                            Text(text = "Name: ${user.name?.first} ${user.name?.last}")
                            Text(text = "Email: ${user.email}")
                            Text(text = "Phone: ${user.phone}")
                        }
                    }
                }
            }
        }
    )
}

