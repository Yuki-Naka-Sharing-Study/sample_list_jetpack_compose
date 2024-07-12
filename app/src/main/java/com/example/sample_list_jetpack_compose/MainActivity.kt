package com.example.sample_list_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            fruitsList(fruits = fruits)

        }
    }
}


data class Fruits(val name: String, val imageResource: Int)

val fruits = listOf(
    Fruits("Apple", R.drawable.apple),
    Fruits("Orange", R.drawable.orange),
    Fruits("Grape", R.drawable.grape),
    Fruits("Peach", R.drawable.peach),
    Fruits("Strawberry", R.drawable.strawberry),
)

@Composable
fun fruitsList(fruits: List<Fruits>) {
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

data class Item(val text: String)

@Composable
fun SecurityItem(item: Item) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.White)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
    }
}

@Composable
fun SecurityItemList(items: List<Item>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) { item ->
            SecurityItem(item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFruitsList() {
    fruitsList(fruits = fruits)
}

@Preview(showBackground = true)
@Composable
fun PreviewSecurityList() {
    val sampleItems = listOf(
        Item("パスコード認証"),
        Item("生体認証")
    )
    SecurityItemList(items = sampleItems)
}