package com.sd.demo.compose.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sd.demo.compose.constraintlayout.theme.AppTheme

class SampleBaseline : ComponentActivity() {
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
      val (refText1, refText2) = createRefs()

      Text(
         text = "x",
         fontSize = 48.sp,
         modifier = Modifier.constrainAs(refText1) {
            centerTo(parent)
         },
      )

      Text(
         text = "x",
         fontSize = 24.sp,
         modifier = Modifier.constrainAs(refText2) {
            baseline.linkTo(refText1.baseline)
            start.linkTo(refText1.end, 10.dp)
         },
      )
   }
}

@Preview
@Composable
private fun PreviewContentView() {
   Content()
}