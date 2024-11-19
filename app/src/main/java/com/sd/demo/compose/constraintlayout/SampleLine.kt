package com.sd.demo.compose.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sd.demo.compose.constraintlayout.theme.AppTheme
import com.sd.lib.compose.constraintlayout.fHorizontalLine
import com.sd.lib.compose.constraintlayout.fVerticalLine

class SampleLine : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         AppTheme {
            Content()
         }
      }
   }
}

@Composable
private fun Content(
   modifier: Modifier = Modifier,
) {
   ConstraintLayout(modifier = modifier.fillMaxSize()) {
      val refBox = createRef()
      Box(
         modifier = Modifier
            .background(Color.Blue)
            .constrainAs(refBox) {
               width = 100.dp.asDimension()
               height = 100.dp.asDimension()
            },
      )

      fHorizontalLine(bias = 0.5f, target = null)
      fVerticalLine(bias = 0.5f, target = null)

      fHorizontalLine(bias = 0.5f, target = refBox, color = Color.Green)
      fVerticalLine(bias = 0.5f, target = refBox, color = Color.Green)
   }
}

@Preview
@Composable
private fun PreviewContentView() {
   Content()
}