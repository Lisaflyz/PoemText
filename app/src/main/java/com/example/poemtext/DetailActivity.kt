package com.example.poemtext

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poemtext.ui.theme.MyApplicationTheme
import androidx.constraintlayout.compose.ConstraintLayout


class DetailActivity : AppCompatActivity() {
    private lateinit var poem : String
    private var imageId:Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        this.poem = intent.getStringExtra("poem").toString()
        this.imageId = intent.getIntExtra("image",0);

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowPoem(
                        poem = this.poem,
                        imageId=this.imageId,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowPoem(poem: String, imageId: Int, modifier: Modifier = Modifier) {
    ConstraintLayout {
        val (text,image) = createRefs()
        Text(
            text = poem,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.constrainAs(text) {
                top.linkTo(parent.top, margin = 16.dp)
                centerHorizontallyTo(parent)

            }
        )

        Image(
            painter = painterResource(imageId),
            contentDescription = "An Image with a poem" ,
            Modifier.constrainAs(image) {
                top.linkTo(text.bottom, margin = 20.dp)
            }

        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        ShowPoem("海上生明月，天涯共此时",R.drawable.image1)
    }
}

