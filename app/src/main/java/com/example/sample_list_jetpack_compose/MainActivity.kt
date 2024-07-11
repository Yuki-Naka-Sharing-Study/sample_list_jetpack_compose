import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.sample_list_jetpack_compose.R

data class Fruits(val name: String, val imageResource: Int)

val fruits = listOf(
    Fruits("Apple", R.drawable.apple),
    Fruits("Orange", R.drawable.orange),
    Fruits("Grape", R.drawable.grape),
    Fruits("Peach", R.drawable.peach),
    Fruits("Strawberry", R.drawable.strawberry),
)

@Composable
fun List2(fruits: List<Fruits>) {
    LazyColumn(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(5.dp)
    ) {
        items(fruits) { fruit ->
            FruitItem(fruit)
        }
    }
}

@Composable
fun FruitItem(fruit: Fruits) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(5.dp))
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Text(
            text = fruit.name,
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = fruit.imageResource),
            contentDescription = fruit.name,
            modifier = Modifier
                .size(50.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewList() {
    List2(fruits = fruits)
}