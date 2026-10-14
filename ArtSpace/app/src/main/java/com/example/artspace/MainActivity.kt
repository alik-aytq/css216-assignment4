package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {

    var currentArtwork by rememberSaveable {
        mutableIntStateOf(0)
    }

    val artworkImages = listOf(
        R.drawable.napoleon,
        R.drawable.the_mill,
        R.drawable.the_seine
    )

    val artworkTitles = listOf(
        "The Emperor Napoleon in His Study at the Tuileries",
        "The Mill",
        "The Seine"
    )

    val artworkArtists = listOf(
        "Jacques-Louis David (1812)",
        "Rembrandt van Rijn (c. 1645–1648)",
        "Henry Ossawa Tanner (1902)"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(
                artworkImages[currentArtwork]
            ),
            contentDescription = artworkTitles[currentArtwork],
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = artworkTitles[currentArtwork],
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = artworkArtists[currentArtwork],
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = {
                    currentArtwork =
                        if (currentArtwork > 0) {
                            currentArtwork - 1
                        } else {
                            artworkImages.lastIndex
                        }
                }
            ) {
                Text("Previous")
            }

            Button(
                onClick = {
                    currentArtwork =
                        if (currentArtwork < artworkImages.lastIndex) {
                            currentArtwork + 1
                        } else {
                            0
                        }
                }
            ) {
                Text("Next")
            }
        }
    }
}
